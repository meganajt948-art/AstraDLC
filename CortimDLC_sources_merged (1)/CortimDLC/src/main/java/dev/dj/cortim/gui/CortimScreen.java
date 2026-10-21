package dev.dj.cortim.gui;

import dev.dj.cortim.BindManager;
import dev.dj.cortim.module.Module;
import dev.dj.cortim.module.ModuleRegistry;
import dev.dj.cortim.render.CortimFont;
import dev.dj.cortim.render.RenderUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.CharInput;
import net.minecraft.client.input.KeyInput;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CortimScreen extends Screen {
    // размер по умолчанию (стал меньше) и границы растягивания
    private static final int DEFAULT_W = 720;
    private static final int DEFAULT_H = 500;
    private static final int MIN_W = 560;
    private static final int MIN_H = 430;

    private static final int SIDEBAR_W = 178;
    private static final int PAD = 14;
    private static final int CARD_H = 42;
    private static final int CARD_GAP = 10;
    private static final int TOPBAR_H = 78;
    private static final int SEARCH_MAX = 24;
    private static final int CORNER_ZONE = 14;

    // углы для растягивания (битовая маска)
    private static final int C_LEFT = 1, C_RIGHT = 2, C_TOP = 4, C_BOTTOM = 8;

    private static final Identifier AVATAR =
            Identifier.of("cortim", "textures/gui/avatar.png");

    // положение и размер запоминаются между открытиями меню
    private static int savedX = Integer.MIN_VALUE, savedY = Integer.MIN_VALUE;
    private static int savedW = DEFAULT_W, savedH = DEFAULT_H;

    private int panelX, panelY;
    private int panelW = DEFAULT_W;
    private int panelH = DEFAULT_H;
    private Tab selectedTab = Tab.COMBAT;

    private final List<Module> visibleModules = new ArrayList<>();
    private final List<Module> expandedModules = new ArrayList<>();

    private String searchQuery = "";
    private boolean searchFocused = false;
    private int scroll = 0;

    private int searchX, searchY, searchW;
    private int languageX, languageY, languageW;
    private int contentX, contentW, listTop;

    // перемещение / растягивание
    private boolean dragging = false;
    private int dragOffX, dragOffY;
    private int resizeCorner = 0;
    private int resL, resR, resT, resB;
    private int grabX, grabY;

    private enum Tab {
        COMBAT("tab.combat", Module.Category.COMBAT),
        MOVEMENT("tab.movement", Module.Category.MOVEMENT),
        PLAYER("tab.player", Module.Category.PLAYER),
        RENDER("tab.render", Module.Category.RENDER),
        MISC("tab.misc", Module.Category.MISC),
        HUD("tab.hud", null),
        CONFIGS("tab.configs", null),
        WAYPOINTS("tab.waypoints", null),
        FRIENDS("tab.friends", null),
        COSMETICS("tab.cosmetics", null);

        final String key;
        final Module.Category cat;

        Tab(String key, Module.Category cat) {
            this.key = key;
            this.cat = cat;
        }

        boolean accepts(Module.Category c) {
            if (cat == null) return false;
            if (this == RENDER && c == Module.Category.VISUAL) return true;
            return c == cat;
        }
    }

    public CortimScreen() {
        super(Text.literal("CygnusWare"));
    }

    @Override
    protected void init() {
        int maxW = Math.max(200, width - 8);
        int maxH = Math.max(200, height - 8);

        panelW = clamp(savedW, Math.min(MIN_W, maxW), maxW);
        panelH = clamp(savedH, Math.min(MIN_H, maxH), maxH);

        if (savedX == Integer.MIN_VALUE) {
            panelX = (width - panelW) / 2;
            panelY = (height - panelH) / 2;
        } else {
            panelX = clamp(savedX, 0, Math.max(0, width - panelW));
            panelY = clamp(savedY, 0, Math.max(0, height - panelH));
        }

        layoutControls();
        rebuildModules();
    }

    private static int clamp(int v, int lo, int hi) {
        return Math.max(lo, Math.min(hi, v));
    }

    private void saveBounds() {
        savedX = panelX;
        savedY = panelY;
        savedW = panelW;
        savedH = panelH;
    }

    private void layoutControls() {
        contentX = panelX + SIDEBAR_W + PAD;
        contentW = panelW - SIDEBAR_W - (PAD * 2);

        languageW = 58;
        languageX = panelX + panelW - PAD - languageW;
        languageY = panelY + 16;

        searchW = Math.min(190, Math.max(110, panelW - SIDEBAR_W - 150));
        searchX = languageX - 12 - searchW;
        searchY = panelY + 16;

        listTop = panelY + TOPBAR_H;
    }

    // ---- вкладки сайдбара: шаг подстраивается под высоту окна ----

    private int sideStep() {
        return clamp((panelH - 140) / 10, 28, 35);
    }

    private int sideItemH() {
        return sideStep() - 5;
    }

    private int tabY(Tab tab) {
        int idx = tab.ordinal();
        int y = panelY + 64 + idx * sideStep();
        if (idx >= 5) y += 14;
        return y;
    }

    // avatar.png: читаем размер и находим рамку самого логотипа, чтобы пустые поля не делали его крошечным
    private static int avW = 0, avH = 0;
    private static int cropX = 0, cropY = 0, cropS = 1;

    private static void loadAvatarSize() {
        if (avW != 0) return;
        try {
            var res = MinecraftClient.getInstance().getResourceManager().getResource(AVATAR);
            if (res.isPresent()) {
                try (java.io.InputStream in = res.get().getInputStream();
                     net.minecraft.client.texture.NativeImage img = net.minecraft.client.texture.NativeImage.read(in)) {
                    avW = img.getWidth();
                    avH = img.getHeight();

                    int step = Math.max(1, Math.max(avW, avH) / 256);
                    int minX = avW, minY = avH, maxX = -1, maxY = -1;
                    for (int y = 0; y < avH; y += step) {
                        for (int x = 0; x < avW; x += step) {
                            int c = img.getColorArgb(x, y);
                            int a = c >>> 24;
                            int lum = (((c >> 16) & 255) + ((c >> 8) & 255) + (c & 255)) / 3;
                            if (a > 24 && lum > 40) {
                                if (x < minX) minX = x;
                                if (x > maxX) maxX = x;
                                if (y < minY) minY = y;
                                if (y > maxY) maxY = y;
                            }
                        }
                    }
                    if (maxX >= minX && maxY >= minY) {
                        int side = (int) (Math.max(maxX - minX, maxY - minY) * 1.16) + 1;
                        side = Math.max(1, Math.min(side, Math.min(avW, avH)));
                        int cx = (minX + maxX) / 2;
                        int cy = (minY + maxY) / 2;
                        cropS = side;
                        cropX = Math.max(0, Math.min(avW - side, cx - side / 2));
                        cropY = Math.max(0, Math.min(avH - side, cy - side / 2));
                    } else {
                        cropS = Math.min(avW, avH);
                    }
                }
            }
        } catch (Exception ignored) {}
        if (avW <= 0 || avH <= 0) { avW = 1; avH = 1; cropX = 0; cropY = 0; cropS = 1; }
    }

    private void drawAvatar(DrawContext ctx, int x, int y, int size) {
        loadAvatarSize();
        ctx.drawTexture(RenderPipelines.GUI_TEXTURED, AVATAR,
                x, y, (float) cropX, (float) cropY, size, size, cropS, cropS, avW, avH);
    }

    private boolean searching() {
        return !searchQuery.isBlank();
    }

    // Карточка-переключатель для BoolSetting модуля Hud (вкладка HUD)
    private static final class SettingToggle extends Module {
        private final Module.BoolSetting setting;

        SettingToggle(Module.BoolSetting setting) {
            super(setting.getName(), Category.CLIENT);
            this.setting = setting;
        }

        @Override public boolean isEnabled() { return setting.get(); }
        @Override public void toggle() { setting.set(!setting.get()); }
    }

    private List<Module> hudCards;

    private List<Module> hudCards() {
        if (hudCards == null) {
            hudCards = new ArrayList<>();
            Module hud = ModuleRegistry.byName("Hud");
            if (hud != null) {
                hudCards.add(hud);
                for (Module.Setting<?> s : hud.getSettings()) {
                    if (s instanceof Module.BoolSetting b) hudCards.add(new SettingToggle(b));
                }
            }
        }
        return hudCards;
    }

    private void rebuildModules() {
        visibleModules.clear();
        String query = searchQuery.trim().toLowerCase(Locale.ROOT);

        if (query.isEmpty() && selectedTab == Tab.HUD) {
            visibleModules.addAll(hudCards());
            scroll = 0;
            return;
        }

        for (Module module : ModuleRegistry.all()) {
            if (query.isEmpty()) {
                if (selectedTab.accepts(module.getCategory())) {
                    visibleModules.add(module);
                }
            } else if (module.getName().toLowerCase(Locale.ROOT).contains(query)) {
                visibleModules.add(module); // поиск по ВСЕМ вкладкам
            }
        }
        scroll = 0;
    }

    private void text(DrawContext ctx, String value, int x, int y, int color) {
        CortimFont.draw(ctx, value, x, y, color);
    }

    // Полупрозрачные цвета
    private int cPanel()      { return 0xA00A0A0D; }
    private int cSidebarBg()  { return 0x80050507; }
    private int cCard()       { return 0xB00D0D11; }
    private int cCardHover()  { return 0xC8181820; }
    private int cCardActive() { return 0xC814141A; }
    private int cSideActive() { return 0xB0202028; }
    private int cSideHover()  { return 0x66181820; }
    private int cBorder()     { return 0x44333340; }
    private int cText()       { return 0xFFF2F2F5; }
    private int cTextDim()    { return 0xFF92929C; }

    private static final class CardLayout {
        final Module module;
        final int x, y, w, h;

        CardLayout(Module module, int x, int y, int w, int h) {
            this.module = module;
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }
    }

    private List<CardLayout> buildCardLayouts() {
        List<CardLayout> layouts = new ArrayList<>();
        int colW = Math.max(1, (contentW - CARD_GAP) / 2);
        int leftX = contentX;
        int rightX = contentX + colW + CARD_GAP;
        int leftY = listTop - scroll;
        int rightY = listTop - scroll;

        for (int i = 0; i < visibleModules.size(); i++) {
            Module module = visibleModules.get(i);
            int extra = expandedModules.contains(module)
                    ? measureExpandedHeight(module) + 6 : 0;
            int cardH = CARD_H + extra;

            if (i % 2 == 0) {
                layouts.add(new CardLayout(module, leftX, leftY, colW, cardH));
                leftY += cardH + CARD_GAP;
            } else {
                layouts.add(new CardLayout(module, rightX, rightY, colW, cardH));
                rightY += cardH + CARD_GAP;
            }
        }
        return layouts;
    }

    private int getCardsContentHeight() {
        int leftHeight = 0;
        int rightHeight = 0;
        for (int i = 0; i < visibleModules.size(); i++) {
            Module module = visibleModules.get(i);
            int h = CARD_H + (expandedModules.contains(module)
                    ? measureExpandedHeight(module) + 6 : 0) + CARD_GAP;
            if (i % 2 == 0) leftHeight += h;
            else rightHeight += h;
        }
        return Math.max(leftHeight, rightHeight);
    }

    // ---- углы для растягивания ----

    private int cornerAt(int mx, int my) {
        boolean l = mx >= panelX - 4 && mx <= panelX + CORNER_ZONE;
        boolean r = mx <= panelX + panelW + 4 && mx >= panelX + panelW - CORNER_ZONE;
        boolean t = my >= panelY - 4 && my <= panelY + CORNER_ZONE;
        boolean b = my <= panelY + panelH + 4 && my >= panelY + panelH - CORNER_ZONE;

        int c = 0;
        if (l && t) c = C_LEFT | C_TOP;
        else if (r && t) c = C_RIGHT | C_TOP;
        else if (l && b) c = C_LEFT | C_BOTTOM;
        else if (r && b) c = C_RIGHT | C_BOTTOM;
        return c;
    }

    private void drawCornerHandle(DrawContext ctx, int corner, int color) {
        int len = 9, th = 2, in = 9;
        boolean l = (corner & C_LEFT) != 0;
        boolean t = (corner & C_TOP) != 0;

        int x = l ? panelX + in : panelX + panelW - in;
        int y = t ? panelY + in : panelY + panelH - in;

        int hx0 = l ? x : x - len;
        int hy0 = t ? y : y - th;
        ctx.fill(hx0, hy0, hx0 + len, hy0 + th, color);

        int vx0 = l ? x : x - th;
        int vy0 = t ? y : y - len;
        ctx.fill(vx0, vy0, vx0 + th, vy0 + len, color);
    }

    @Override
    public void render(DrawContext ctx, int mouseX, int mouseY, float delta) {
        ctx.fill(0, 0, width, height, 0x44000000);

        // тонкое свечение по краю
        RenderUtils.drawSmoothRoundedRect(ctx, panelX - 1, panelY - 1, panelW + 2, panelH + 2, 25f, 0x226B7C96);

        // фон меню (полупрозрачный, без картинки по центру)
        RenderUtils.drawSmoothRoundedRect(ctx, panelX, panelY, panelW, panelH, 24f, cPanel());

        // сайдбар: скруглены только левые углы
        RenderUtils.drawSmoothRoundedRect(ctx, panelX, panelY, SIDEBAR_W, panelH, 24f, cSidebarBg(),
                true, false, true, false);
        ctx.fill(panelX + SIDEBAR_W, panelY + 12, panelX + SIDEBAR_W + 1, panelY + panelH - 12, cBorder());

        // логотип + название
        int logoSize = 38;
        drawAvatar(ctx, panelX + PAD, panelY + 11, logoSize);
        text(ctx, "CygnusWare", panelX + PAD + logoSize + 8, panelY + 26, cText());

        // вкладки
        for (Tab tab : Tab.values()) {
            drawTab(ctx, tab, panelX + PAD, tabY(tab), mouseX, mouseY);
        }
        int divY = panelY + 64 + 5 * sideStep() + 5;
        ctx.fill(panelX + PAD, divY, panelX + SIDEBAR_W - PAD, divY + 1, cBorder());

        // низ сайдбара: только кнопка выключения (без аватара/ника/UID)
        int powerY = panelY + panelH - 42;
        int powerX = panelX + SIDEBAR_W - PAD - 30;
        ctx.fill(panelX + PAD, powerY - 10, panelX + SIDEBAR_W - PAD, powerY - 9, cBorder());
        boolean powerHover = inside(mouseX, mouseY, powerX, powerY, 30, 30);
        RenderUtils.drawSmoothRoundedRect(ctx, powerX, powerY, 30, 30, 8f, powerHover ? cCardHover() : cCard());
        drawPowerIcon(ctx, powerX + 15, powerY + 15, powerHover ? cText() : cTextDim());

        // шапка
        String title = searching() ? Lang.tr("search.results") : Lang.tr(selectedTab.key);
        text(ctx, title, contentX, panelY + 26, cText());

        int enabled = 0;
        for (Module module : visibleModules) {
            if (module.isEnabled()) enabled++;
        }
        text(ctx, Lang.count(enabled, visibleModules.size()), contentX, panelY + 46, cTextDim());

        drawSearch(ctx, mouseX, mouseY);

        // кнопка языка
        String languageLabel = Lang.ru() ? "RU  v" : "EN  v";
        boolean langHover = inside(mouseX, mouseY, languageX, languageY, languageW, 30);
        RenderUtils.drawSmoothRoundedRect(ctx, languageX, languageY, languageW, 30, 15f, langHover ? cCardHover() : cCard());
        text(ctx, languageLabel, languageX + 12, languageY + 10, cText());

        // карточки
        ctx.enableScissor(contentX, listTop, contentX + contentW, panelY + panelH - PAD);
        for (CardLayout card : buildCardLayouts()) {
            if (card.y + card.h >= listTop && card.y < panelY + panelH - PAD) {
                drawCard(ctx, card.module, card.x, card.y, card.w, card.h, mouseX, mouseY);
            }
        }
        ctx.disableScissor();

        drawDropdownPopup(ctx, mouseX, mouseY);

        // индикатор угла при наведении / растягивании
        int corner = resizeCorner != 0 ? resizeCorner : (dragging ? 0 : cornerAt(mouseX, mouseY));
        if (corner != 0) {
            drawCornerHandle(ctx, corner, resizeCorner != 0 ? 0xFFFFFFFF : 0xB0FFFFFF);
        }
    }

    private void drawSearch(DrawContext ctx, int mouseX, int mouseY) {
        boolean hover = inside(mouseX, mouseY, searchX, searchY, searchW, 30);
        RenderUtils.drawSmoothRoundedRect(ctx, searchX, searchY, searchW, 30, 15f,
                searchFocused ? 0xE0181820 : (hover ? cCardHover() : cCard()));

        if (searchQuery.isEmpty() && !searchFocused) {
            text(ctx, Lang.tr("search"), searchX + 14, searchY + 10, cTextDim());
            return;
        }

        String shown = searchQuery;
        while (shown.length() > 1 && CortimFont.width(shown) > searchW - 36) {
            shown = shown.substring(1);
        }
        boolean blink = (System.currentTimeMillis() / 500) % 2 == 0;
        String cursor = searchFocused && blink ? "_" : "";
        text(ctx, shown + cursor, searchX + 14, searchY + 10, cText());
    }

    private void drawPowerIcon(DrawContext ctx, int cx, int cy, int color) {
        RenderUtils.drawSmoothRoundedRect(ctx, cx - 6, cy - 5, 12, 12, 6f, color);
        RenderUtils.drawSmoothRoundedRect(ctx, cx - 4, cy - 3, 8, 8, 4f, 0xFF0D0D11);
        ctx.fill(cx - 1, cy - 7, cx + 1, cy, color);
    }

    private boolean inside(int mx, int my, int x, int y, int w, int h) {
        return mx >= x && mx <= x + w && my >= y && my <= y + h;
    }

    private void drawTab(DrawContext ctx, Tab tab, int x, int y, int mouseX, int mouseY) {
        int w = SIDEBAR_W - (PAD * 2);
        int h = sideItemH();
        boolean active = selectedTab == tab && !searching();
        boolean hover = inside(mouseX, mouseY, x, y, w, h);

        if (active) {
            RenderUtils.drawSmoothRoundedRect(ctx, x, y, w, h, 14f, cSideActive());
            ctx.fill(x, y + 9, x + 3, y + h - 9, cText());
        } else if (hover) {
            RenderUtils.drawSmoothRoundedRect(ctx, x, y, w, h, 14f, cSideHover());
        }

        text(ctx, Lang.tr(tab.key), x + 14, y + (h - 8) / 2, active ? cText() : cTextDim());
    }

    private void drawCard(DrawContext ctx, Module module, int x, int y, int w, int h, int mouseX, int mouseY) {
        boolean expanded = expandedModules.contains(module);
        boolean hover = inside(mouseX, mouseY, x, y, w, CARD_H);
        boolean lit = expanded || hover || module.isEnabled();

        // свечение вокруг карточки (только при наведении/раскрытии — так дешевле)
        if (expanded || hover) {
            RenderUtils.drawGlow(ctx, x, y, w, h, 18f, 0x40AABBCC, 2);
        }

        RenderUtils.drawSmoothRoundedRect(ctx, x, y, w, h, 18f,
                expanded ? cCardActive() : (hover ? cCardHover() : cCard()));

        // стеклянная обводка: сверху ярче, снизу тусклее
        RenderUtils.drawRoundedBorder(ctx, x, y, w, h, 18f, 1f,
                lit ? 0xC0FFFFFF : 0x70FFFFFF,
                lit ? 0x40FFFFFF : 0x22FFFFFF);

        text(ctx, module.getName(), x + 14, y + 13, module.isEnabled() ? cText() : cTextDim());

        int toggleW = 26;
        int toggleH = 14;
        int toggleX = x + w - toggleW - 14;
        int toggleY = y + 14;

        RenderUtils.drawSmoothRoundedRect(ctx, toggleX, toggleY, toggleW, toggleH, 7f,
                module.isEnabled() ? 0xFFE7E7EA : 0xFF222228);
        RenderUtils.drawSmoothRoundedRect(ctx,
                module.isEnabled() ? toggleX + toggleW - 12 : toggleX + 3,
                toggleY + 2, 9, 9, 4.5f,
                module.isEnabled() ? 0xFF111114 : 0xFFAAAAAE);

        // плашка с клавишей бинда (или "..." пока ждём нажатия)
        boolean binding = dev.dj.cortim.Cortim.getBindingModule() == module;
        if (binding || module.getBoundKey() != -1) {
            String bl = binding ? "..." : dev.dj.cortim.module.Hud.keyName(module.getBoundKey());
            int cw = CortimFont.width(bl) + 14;
            int chipX = toggleX - 10 - cw;
            RenderUtils.drawSmoothRoundedRect(ctx, chipX, y + 13, cw, 16, 8f, binding ? 0x55FFFFFF : 0x33FFFFFF);
            text(ctx, bl, chipX + 7, y + 17, binding ? cText() : cTextDim());
        }

        if (expanded) {
            ctx.fill(x + 12, y + CARD_H, x + w - 12, y + CARD_H + 1, cBorder());
            int currentY = y + CARD_H + 8;

            for (Module.Setting<?> setting : module.getSettings()) {
                if (!setting.isVisible()) continue;
                drawSettingRow(ctx, setting, x + 14, currentY, w - 28, mouseX, mouseY);
                currentY += rowHeight(setting);
            }
        }
    }

    // ---------------------------------------------------------------
    // Настройки модуля: переключатели, режимы, ползунки
    // ---------------------------------------------------------------

    private Module.Setting<?> dragSetting = null;
    private int dragSliderX, dragSliderW;

    // ожидание нажатия клавиши для KeySetting
    private Module.KeySetting listeningKey = null;

    // ожидание ввода текста для TextSetting
    private Module.TextSetting editingText = null;

    // выпадающий список (настройки-режимы с 3+ вариантами)
    private Module.ModeSetting openDropdown = null;
    private int ddX, ddY, ddW;
    private static final int DD_ROW = 24;

    private int rowHeight(Module.Setting<?> s) {
        return (s instanceof Module.FloatSetting || s instanceof Module.IntSetting) ? 36 : 26;
    }

    private int measureExpandedHeight(Module module) {
        int h = 4;
        for (Module.Setting<?> setting : module.getSettings()) {
            if (setting.isVisible()) h += rowHeight(setting);
        }
        return h;
    }

    private int[] modeWidths(Module.ModeSetting ms) {
        String[] opts = ms.options();
        int[] ws = new int[opts.length];
        for (int i = 0; i < opts.length; i++) ws[i] = CortimFont.width(opts[i]) + 18;
        return ws;
    }

    private void drawToggle(DrawContext ctx, int x, int y, boolean on) {
        RenderUtils.drawSmoothRoundedRect(ctx, x, y, 26, 14, 7f, on ? 0xFFE7E7EA : 0xFF222228);
        RenderUtils.drawSmoothRoundedRect(ctx, on ? x + 14 : x + 3, y + 3, 9, 9, 4.5f,
                on ? 0xFF111114 : 0xFFAAAAAE);
    }

    private void drawSettingRow(DrawContext ctx, Module.Setting<?> setting, int x, int y, int w,
                                int mouseX, int mouseY) {
        if (setting instanceof Module.FloatSetting || setting instanceof Module.IntSetting) {
            float min, max, cur;
            if (setting instanceof Module.FloatSetting fs) {
                min = fs.min(); max = fs.max(); cur = fs.get();
            } else {
                Module.IntSetting is = (Module.IntSetting) setting;
                min = is.min(); max = is.max(); cur = is.get();
            }
            float t = max == min ? 0f : Math.max(0f, Math.min(1f, (cur - min) / (max - min)));

            text(ctx, setting.getName(), x, y + 3, cTextDim());
            String val = setting.display();
            text(ctx, val, x + w - CortimFont.width(val), y + 3, cText());

            int trackY = y + 22;
            RenderUtils.drawSmoothRoundedRect(ctx, x, trackY, w, 3, 1.5f, 0x44FFFFFF);
            int fillW = Math.round(w * t);
            if (fillW > 0) RenderUtils.drawSmoothRoundedRect(ctx, x, trackY, Math.max(3, fillW), 3, 1.5f, 0xFFE7E7EA);

            int thumbX = x + fillW - 4;
            thumbX = Math.max(x - 1, Math.min(x + w - 7, thumbX));
            RenderUtils.drawSmoothRoundedRect(ctx, thumbX, trackY - 3, 8, 8, 4f, 0xFFF2F2F5);
        } else if (setting instanceof Module.ModeSetting dm && !dm.isSegmented() && dm.options().length > 2) {
            drawDropdownRow(ctx, dm, x, y, w, mouseX, mouseY);
        } else if (setting instanceof Module.ModeSetting ms) {
            text(ctx, setting.getName(), x, y + 8, cTextDim());

            String[] opts = ms.options();
            int[] ws = modeWidths(ms);
            int total = 4;
            for (int cw : ws) total += cw;

            int px = x + w - total;
            RenderUtils.drawSmoothRoundedRect(ctx, px, y + 3, total, 20, 10f, 0x33FFFFFF);

            int cx = px + 2;
            for (int i = 0; i < opts.length; i++) {
                boolean sel = ms.get() == i;
                if (sel) RenderUtils.drawSmoothRoundedRect(ctx, cx, y + 5, ws[i], 16, 8f, 0x55FFFFFF);
                text(ctx, opts[i], cx + 9, y + 9, sel ? cText() : cTextDim());
                cx += ws[i];
            }
        } else if (setting instanceof Module.KeySetting ks) {
            text(ctx, ks.getName(), x, y + 8, cTextDim());

            boolean listening = listeningKey == ks;
            String label = listening ? "..."
                    : ks.getKey() < 0 ? (Lang.ru() ? "Нет" : "None")
                    : dev.dj.cortim.module.Hud.keyName(ks.getKey());
            int pw = Math.max(38, CortimFont.width(label) + 22);
            int px = x + w - pw;
            boolean hov = inside(mouseX, mouseY, px, y + 3, pw, 20);

            RenderUtils.drawSmoothRoundedRect(ctx, px, y + 3, pw, 20, 10f, (hov || listening) ? 0x55FFFFFF : 0x33FFFFFF);
            RenderUtils.drawRoundedBorder(ctx, px, y + 3, pw, 20, 10f, 1f, 0x70FFFFFF, 0x70FFFFFF);
            text(ctx, label, px + (pw - CortimFont.width(label)) / 2, y + 9, listening ? cText() : cTextDim());
        } else if (setting instanceof Module.ColorSetting cs) {
            text(ctx, setting.getName(), x, y + 8, cTextDim());
            RenderUtils.drawSmoothRoundedRect(ctx, x + w - 22, y + 5, 22, 16, 6f, 0xFF000000 | (cs.getColor() & 0xFFFFFF));
        } else if (setting instanceof Module.ButtonSetting) {
            text(ctx, setting.getName(), x, y + 8, cTextDim());
            RenderUtils.drawSmoothRoundedRect(ctx, x + w - 60, y + 3, 60, 20, 10f, 0x33FFFFFF);
            text(ctx, Lang.tr("apply"), x + w - 52, y + 9, cText());
        } else if (setting instanceof Module.MultiSetting) {
            text(ctx, setting.getName(), x, y + 8, cTextDim());
            String d = setting.display();
            text(ctx, d, x + w - CortimFont.width(d), y + 8, cText());
        } else if (setting instanceof Module.TextSetting ts) {
            text(ctx, ts.getName(), x, y + 8, cTextDim());

            boolean editing = editingText == ts;
            String shown = ts.get() == null ? "" : ts.get();
            boolean blink = (System.currentTimeMillis() / 500) % 2 == 0;
            String label = editing ? shown + (blink ? "_" : "") : (shown.isEmpty() ? "—" : shown);

            int pw = Math.max(70, CortimFont.width(label) + 20);
            int px = x + w - pw;
            boolean hov = inside(mouseX, mouseY, px, y + 3, pw, 20);

            RenderUtils.drawSmoothRoundedRect(ctx, px, y + 3, pw, 20, 10f, (hov || editing) ? 0x55FFFFFF : 0x33FFFFFF);
            RenderUtils.drawRoundedBorder(ctx, px, y + 3, pw, 20, 10f, 1f, 0x70FFFFFF, 0x70FFFFFF);
            text(ctx, label, px + 10, y + 9, editing ? cText() : cTextDim());
        } else {
            boolean on = Boolean.TRUE.equals(setting.get());
            text(ctx, setting.getName(), x, y + 8, on ? cText() : cTextDim());
            drawToggle(ctx, x + w - 26, y + 6, on);
        }
    }

    private int ddPillW(Module.ModeSetting ms) {
        int m = 0;
        for (String o : ms.options()) m = Math.max(m, CortimFont.width(o));
        return m + 38;
    }

    private void drawChevron(DrawContext ctx, int cx, int cy, boolean up, int color) {
        for (int i = 0; i < 4; i++) {
            int yy = up ? cy + 3 - i : cy + i;
            ctx.fill(cx - 4 + i, yy, cx - 2 + i, yy + 1, color);
            ctx.fill(cx + 2 - i, yy, cx + 4 - i, yy + 1, color);
        }
    }

    private void drawCheck(DrawContext ctx, int x, int y, int color) {
        int[][] pts = { {0, 2}, {1, 3}, {2, 4}, {3, 3}, {4, 2}, {5, 1}, {6, 0} };
        for (int[] p : pts) {
            ctx.fill(x + p[0], y + p[1], x + p[0] + 2, y + p[1] + 1, color);
        }
    }

    private void drawDropdownRow(DrawContext ctx, Module.ModeSetting ms, int x, int y, int w,
                                 int mouseX, int mouseY) {
        text(ctx, ms.getName(), x, y + 8, cTextDim());

        int pw = ddPillW(ms);
        int px = x + w - pw;
        int py = y + 3;
        boolean open = openDropdown == ms;
        boolean hover = inside(mouseX, mouseY, px, py, pw, 20);

        RenderUtils.drawSmoothRoundedRect(ctx, px, py, pw, 20, 10f, (hover || open) ? 0x55FFFFFF : 0x33FFFFFF);
        RenderUtils.drawRoundedBorder(ctx, px, py, pw, 20, 10f, 1f, 0x70FFFFFF, 0x70FFFFFF);
        text(ctx, ms.current(), px + 12, py + 6, cText());
        drawChevron(ctx, px + pw - 14, py + 8, open, cText());

        if (open) {
            ddX = px;
            ddY = py + 24;
            ddW = pw;
        }
    }

    private void drawDropdownPopup(DrawContext ctx, int mouseX, int mouseY) {
        if (openDropdown == null) return;

        String[] opts = openDropdown.options();
        int h = opts.length * DD_ROW + 8;

        RenderUtils.drawSmoothRoundedRect(ctx, ddX, ddY, ddW, h, 14f, 0xF00B0B0F);
        RenderUtils.drawRoundedBorder(ctx, ddX, ddY, ddW, h, 14f, 1f, 0x66FFFFFF, 0x66FFFFFF);

        for (int i = 0; i < opts.length; i++) {
            int ry = ddY + 4 + i * DD_ROW;
            boolean sel = openDropdown.get() == i;
            boolean hov = inside(mouseX, mouseY, ddX + 4, ry, ddW - 8, DD_ROW);

            if (hov) RenderUtils.drawSmoothRoundedRect(ctx, ddX + 4, ry, ddW - 8, DD_ROW, 10f, 0x22FFFFFF);
            text(ctx, opts[i], ddX + 14, ry + 8, sel ? cText() : cTextDim());
            if (sel) drawCheck(ctx, ddX + ddW - 22, ry + 9, cText());
        }
    }

    /** Клик при открытом списке: выбираем вариант или закрываем. Всегда съедает клик. */
    private boolean handleDropdownClick(int mx, int my) {
        Module.ModeSetting ms = openDropdown;
        openDropdown = null;
        if (ms == null) return false;

        int h = ms.options().length * DD_ROW + 8;
        if (inside(mx, my, ddX, ddY, ddW, h)) {
            int idx = (my - ddY - 4) / DD_ROW;
            if (idx >= 0 && idx < ms.options().length) ms.set(idx);
        }
        return true;
    }

    private boolean handleSettingClick(CardLayout card, int mx, int my) {
        int y = card.y + CARD_H + 8;
        int x = card.x + 14;
        int w = card.w - 28;

        for (Module.Setting<?> s : card.module.getSettings()) {
            if (!s.isVisible()) continue;
            int h = rowHeight(s);

            if (my >= y && my < y + h) {
                if (s instanceof Module.FloatSetting || s instanceof Module.IntSetting) {
                    if (my >= y + 12) {
                        dragSetting = s;
                        dragSliderX = x;
                        dragSliderW = w;
                        applySlider(mx);
                    }
                } else if (s instanceof Module.ModeSetting dm && !dm.isSegmented() && dm.options().length > 2) {
                    int pw = ddPillW(dm);
                    int px = x + w - pw;
                    if (mx >= px && mx <= px + pw) {
                        openDropdown = (openDropdown == dm) ? null : dm;
                    }
                } else if (s instanceof Module.ModeSetting ms) {
                    int[] ws = modeWidths(ms);
                    int total = 4;
                    for (int cw : ws) total += cw;
                    int px = x + w - total;
                    if (mx >= px && mx <= px + total) {
                        int cx = px + 2;
                        for (int i = 0; i < ws.length; i++) {
                            if (mx < cx + ws[i]) { ms.set(i); break; }
                            cx += ws[i];
                        }
                    }
                } else if (s instanceof Module.ButtonSetting) {
                    if (mx >= x + w - 60) s.adjust(1);
                } else if (s instanceof Module.KeySetting ks) {
                    String label = ks.getKey() < 0 ? (Lang.ru() ? "Нет" : "None")
                            : dev.dj.cortim.module.Hud.keyName(ks.getKey());
                    int pw = Math.max(38, CortimFont.width(label) + 22);
                    if (mx >= x + w - pw) listeningKey = (listeningKey == ks) ? null : ks;
                } else if (s instanceof Module.TextSetting ts) {
                    String shown = ts.get() == null ? "" : ts.get();
                    int pw = Math.max(70, CortimFont.width(shown.isEmpty() ? "—" : shown) + 20);
                    if (mx >= x + w - pw) editingText = (editingText == ts) ? null : ts;
                } else if (s instanceof Module.MultiSetting || s instanceof Module.ColorSetting) {
                    // пока без действий
                } else {
                    s.adjust(1); // переключатель
                }
                return true;
            }
            y += h;
        }
        return true;
    }

    private void applySlider(int mx) {
        if (dragSetting == null || dragSliderW <= 0) return;
        double t = Math.max(0.0, Math.min(1.0, (mx - dragSliderX) / (double) dragSliderW));

        if (dragSetting instanceof Module.FloatSetting fs) {
            float v = fs.min() + (float) t * (fs.max() - fs.min());
            float st = fs.step();
            if (st > 0) v = fs.min() + Math.round((v - fs.min()) / st) * st;
            fs.set(Math.max(fs.min(), Math.min(fs.max(), v)));
        } else if (dragSetting instanceof Module.IntSetting is) {
            int v = Math.round(is.min() + (float) t * (is.max() - is.min()));
            is.set(Math.max(is.min(), Math.min(is.max(), v)));
        }
    }

    private void selectTab(Tab tab) {
        openDropdown = null;
        selectedTab = tab;
        expandedModules.clear();
        searchQuery = "";
        searchFocused = false;
        rebuildModules();
    }

    @Override
    public boolean mouseClicked(Click click, boolean doubled) {
        int mx = (int) click.x();
        int my = (int) click.y();
        boolean left = click.button() == 0;

        if (listeningKey != null) {
            if (click.button() >= 2) { // СКМ или боковые кнопки мыши
                listeningKey.set(1000 + click.button());
                listeningKey = null;
                BindManager.save();
                return true;
            }
            listeningKey = null; // ЛКМ / ПКМ — просто отмена
        }

        if (openDropdown != null && left) {
            if (handleDropdownClick(mx, my)) return true;
        }

        // 1) угол -> растягивание
        if (left) {
            int corner = cornerAt(mx, my);
            if (corner != 0) {
                resizeCorner = corner;
                resL = panelX;
                resR = panelX + panelW;
                resT = panelY;
                resB = panelY + panelH;
                grabX = mx - ((corner & C_LEFT) != 0 ? resL : resR);
                grabY = my - ((corner & C_TOP) != 0 ? resT : resB);
                searchFocused = false;
                editingText = null;
                return true;
            }
        }

        if (inside(mx, my, searchX, searchY, searchW, 30)) {
            searchFocused = true;
            editingText = null;
            return true;
        }
        searchFocused = false;
        editingText = null;

        if (inside(mx, my, languageX, languageY, languageW, 30)) {
            MinecraftClient.getInstance().setScreen(new LanguageScreen(this));
            return true;
        }

        if (mx >= panelX + PAD && mx <= panelX + SIDEBAR_W - PAD) {
            for (Tab tab : Tab.values()) {
                if (inside(mx, my, panelX + PAD, tabY(tab), SIDEBAR_W - (PAD * 2), sideItemH())) {
                    selectTab(tab);
                    return true;
                }
            }

            int powerY = panelY + panelH - 42;
            int powerX = panelX + SIDEBAR_W - PAD - 30;
            if (inside(mx, my, powerX, powerY, 30, 30)) {
                return true; // пока без действия
            }
        }

        if (!visibleModules.isEmpty()) {
            for (CardLayout card : buildCardLayouts()) {
                Module module = card.module;
                if (!inside(mx, my, card.x, card.y, card.w, card.h)) continue;
                if (my < listTop) continue;

                if (click.button() == 2) { // СКМ по модулю: следующая нажатая клавиша станет биндом
                    if (my < card.y + CARD_H && !(module instanceof SettingToggle)) {
                        dev.dj.cortim.Cortim.setBindingModule(
                                dev.dj.cortim.Cortim.getBindingModule() == module ? null : module);
                    }
                    return true;
                }

                if (click.button() == 1) { // ПКМ по карточке: открыть / закрыть настройки
                    if (my < card.y + CARD_H) {
                        if (expandedModules.contains(module)) expandedModules.remove(module);
                        else expandedModules.add(module);
                        clampScroll();
                    }
                    return true;
                }
                if (click.button() != 0) continue;

                if (my >= card.y + CARD_H && expandedModules.contains(module)) {
                    return handleSettingClick(card, mx, my);
                }

                if (my < card.y + CARD_H && mx >= card.x + card.w - 46) {
                    module.toggle();
                    BindManager.save();
                    return true;
                }

                if (my < card.y + CARD_H) {
                    if (expandedModules.contains(module)) expandedModules.remove(module);
                    else expandedModules.add(module);
                    clampScroll();
                    return true;
                }
            }
        }

        // 2) пустое место панели -> перетаскивание
        if (left && inside(mx, my, panelX, panelY, panelW, panelH)) {
            dragging = true;
            dragOffX = mx - panelX;
            dragOffY = my - panelY;
            return true;
        }

        return super.mouseClicked(click, doubled);
    }

    @Override
    public boolean mouseDragged(Click click, double offsetX, double offsetY) {
        int mx = (int) click.x();
        int my = (int) click.y();

        if (dragSetting != null) {
            applySlider(mx);
            return true;
        }

        if (resizeCorner != 0) {
            int minW = Math.min(MIN_W, width);
            int minH = Math.min(MIN_H, height);
            int nl = resL, nr = resR, nt = resT, nb = resB;

            if ((resizeCorner & C_LEFT) != 0) nl = clamp(mx - grabX, 0, nr - minW);
            if ((resizeCorner & C_RIGHT) != 0) nr = clamp(mx - grabX, nl + minW, width);
            if ((resizeCorner & C_TOP) != 0) nt = clamp(my - grabY, 0, nb - minH);
            if ((resizeCorner & C_BOTTOM) != 0) nb = clamp(my - grabY, nt + minH, height);

            panelX = nl;
            panelY = nt;
            panelW = nr - nl;
            panelH = nb - nt;
            resL = nl; resR = nr; resT = nt; resB = nb;
            // якорь противоположных сторон остаётся прежним
            if ((resizeCorner & C_LEFT) != 0) resR = nr;
            if ((resizeCorner & C_RIGHT) != 0) resL = nl;
            if ((resizeCorner & C_TOP) != 0) resB = nb;
            if ((resizeCorner & C_BOTTOM) != 0) resT = nt;

            layoutControls();
            clampScroll();
            saveBounds();
            return true;
        }

        if (dragging) {
            panelX = clamp(mx - dragOffX, 0, Math.max(0, width - panelW));
            panelY = clamp(my - dragOffY, 0, Math.max(0, height - panelH));
            layoutControls();
            saveBounds();
            return true;
        }

        return super.mouseDragged(click, offsetX, offsetY);
    }

    @Override
    public boolean mouseReleased(Click click) {
        if (dragSetting != null) {
            dragSetting = null;
            return true;
        }
        if (resizeCorner != 0 || dragging) {
            resizeCorner = 0;
            dragging = false;
            saveBounds();
            return true;
        }
        return super.mouseReleased(click);
    }

    @Override
    public boolean keyPressed(KeyInput input) {
        int keyCode = input.key();
        boolean ctrl = (input.modifiers() & GLFW.GLFW_MOD_CONTROL) != 0;

        if (listeningKey != null) {
            if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
                listeningKey = null;
                return true;
            }
            if (keyCode == GLFW.GLFW_KEY_BACKSPACE || keyCode == GLFW.GLFW_KEY_DELETE) {
                listeningKey.set(-1);
            } else {
                listeningKey.set(keyCode);
            }
            listeningKey = null;
            BindManager.save();
            return true;
        }

        if (editingText != null) {
            if (keyCode == GLFW.GLFW_KEY_ESCAPE || keyCode == GLFW.GLFW_KEY_ENTER || keyCode == GLFW.GLFW_KEY_KP_ENTER) {
                editingText = null;
                return true;
            }
            if (keyCode == GLFW.GLFW_KEY_BACKSPACE) {
                String v = editingText.get();
                if (v != null && !v.isEmpty()) editingText.set(v.substring(0, v.length() - 1));
                return true;
            }
            return true;
        }

        if (dev.dj.cortim.Cortim.getBindingModule() != null) {
            return true;
        }

        if (ctrl && keyCode == GLFW.GLFW_KEY_F) {
            searchFocused = true;
            return true;
        }

        if (searchFocused) {
            if (keyCode == GLFW.GLFW_KEY_ESCAPE || keyCode == GLFW.GLFW_KEY_ENTER
                    || keyCode == GLFW.GLFW_KEY_KP_ENTER) {
                searchFocused = false;
                return true;
            }
            if (keyCode == GLFW.GLFW_KEY_BACKSPACE) {
                if (!searchQuery.isEmpty()) {
                    searchQuery = ctrl ? "" : searchQuery.substring(0, searchQuery.length() - 1);
                    rebuildModules();
                }
                return true;
            }
            return true; // пока вводим текст, остальные клавиши не трогаем
        }

        if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
            close();
            return true;
        }

        return super.keyPressed(input);
    }

    @Override
    public boolean charTyped(CharInput input) {
        if (editingText != null) {
            String s = input.asString();
            if (s.isEmpty() || Character.isISOControl(s.charAt(0))) return true;
            String cur = editingText.get() == null ? "" : editingText.get();
            if (cur.length() < 64) editingText.set(cur + s);
            return true;
        }

        if (!searchFocused) return super.charTyped(input);

        String s = input.asString();
        if (s.isEmpty() || Character.isISOControl(s.charAt(0))) return true;
        if (searchQuery.length() + s.length() > SEARCH_MAX) return true;

        searchQuery += s;
        rebuildModules();
        return true;
    }

    private void clampScroll() {
        int viewHeight = Math.max(1, panelH - TOPBAR_H - PAD);
        int maxScroll = Math.max(0, getCardsContentHeight() - viewHeight);
        scroll = Math.max(0, Math.min(scroll, maxScroll));
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double hAmount, double vAmount) {
        if (mouseX < panelX + SIDEBAR_W || visibleModules.isEmpty()) {
            return super.mouseScrolled(mouseX, mouseY, hAmount, vAmount);
        }
        openDropdown = null;
        scroll -= (int) (vAmount * 32);
        clampScroll();
        return true;
    }

    @Override
    public void close() {
        openDropdown = null;
        searchFocused = false;
        editingText = null;
        dragging = false;
        resizeCorner = 0;
        super.close();
    }
    public void handleScroll(double mx, double my, double amount) {
        mouseScrolled(mx, my, 0, amount);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}