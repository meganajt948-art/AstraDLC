/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.Click
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.hud.ClientBossBar
 *  net.minecraft.client.gui.screen.DeathScreen
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.input.CharInput
 *  net.minecraft.client.input.KeyInput
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.network.OtherClientPlayerEntity
 *  net.minecraft.client.option.GameOptions
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.ItemEntity
 *  net.minecraft.entity.mob.HostileEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.screen.PlayerScreenHandler
 *  net.minecraft.screen.ScreenHandler
 *  net.minecraft.screen.slot.Slot
 *  net.minecraft.screen.slot.SlotActionType
 *  net.minecraft.text.Style
 *  net.minecraft.text.Text
 *  net.minecraft.text.TextColor
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 */
package flow.bot;

import a.dts;
import a.dtv;
import a.dxe;
import a.dyh;
import a.eao;
import a.ece;
import a.ech;
import a.egq;
import a.eip;
import a.elb;
import a.hyv;
import a.iov;
import a.lqq;
import a.mpq;
import a.nfl;
import a.nxa;
import a.ppn;
import a.ppu;
import a.ujt;
import a.unf;
import a.uut;
import a.vdn;
import a.veo;
import a.vhz;
import a.vjf;
import a.vkl;
import a.vlj;
import a.vlv;
import a.vmc;
import a.vmo;
import a.vmu;
import a.vup;
import a.wap;
import flow.config.ConfigManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.ClientBossBar;
import net.minecraft.client.gui.screen.DeathScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.CharInput;
import net.minecraft.client.input.KeyInput;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public final class BotScreen
extends Screen {
    private static final float W = 600.0f;
    private static final float H = 318.0f;
    private static final float HEADER = 20.0f;
    private static final float PAD = 6.0f;
    private static final float LIST_W = 146.0f;
    private static final float MID_W = 226.0f;
    private static final float INFO_H = 18.0f;
    private static final float VIEW_H = 150.0f;
    private static final float TAB_H = 16.0f;
    private static final float SLOT = 20.0f;
    private static final float ROW = 30.0f;
    private static final float RADIUS = 8.0f;
    private static final float SIZE_TITLE = 8.5f;
    private static final float SIZE_NAME = 7.5f;
    private static final float SIZE_ROW = 7.0f;
    private static final float SIZE_SMALL = 6.5f;
    private static final float SIZE_CHAT = 6.5f;
    private static final float SIZE_TINY = 5.5f;
    private static final int GREEN = -10758549;
    private static final int AMBER = -1526966;
    private static final int RED = -2073765;
    private static final int GRAY = -7630435;
    private static final String[] F1_LABELS = new String[]{"\u0421\u0435\u0439\u0432", "\u041b\u0443\u0442", "\u0421\u043f\u043e\u0441\u043e\u0431 \u0422\u041f", "\u0425\u043e\u043c", "\u0412\u0430\u0440\u043f", "\u041c\u0430\u043a\u0441. \u0441\u0443\u043d\u0434\u0443\u043a\u043e\u0432", "\u0417\u0430\u0434\u0435\u0440\u0436\u043a\u0430 \u043b\u0443\u0442\u0430", "\u0417\u0435\u043b\u044c\u044f \u0441\u043a\u043e\u0440\u043e\u0441\u0442\u0438"};
    private static final String[] F1_STATES = new String[]{"\u043e\u0441\u043c\u0430\u0442\u0440\u0438\u0432\u0430\u0435\u0442\u0441\u044f", "\u043f\u043e\u043f\u043e\u043b\u043d\u0435\u043d\u0438\u0435 \u043d\u0430 \u0441\u0435\u0439\u0432\u0435", "\u0435\u0434\u0435\u0442 \u043d\u0430 \u0430\u043d\u0430\u0440\u0445\u0438\u044e \u043b\u0443\u0442\u0430", "\u0435\u0434\u0435\u0442 \u0432 \u0433\u043e\u0440\u043e\u0434", "\u0438\u0449\u0435\u0442 \u0441\u0443\u043d\u0434\u0443\u043a", "\u0436\u0434\u0451\u0442 \u0441\u0443\u043d\u0434\u0443\u043a", "\u043b\u0443\u0442\u0430\u0435\u0442 \u0441\u0443\u043d\u0434\u0443\u043a", "\u0443\u0431\u0435\u0433\u0430\u0435\u0442", "\u0436\u0434\u0451\u0442 \u043a\u043e\u043d\u0446\u0430 \u041f\u0432\u041f", "\u0435\u0434\u0435\u0442 \u043d\u0430 \u0441\u0435\u0439\u0432", "\u0438\u0434\u0451\u0442 \u043d\u0430 \u0431\u0430\u0437\u0443 \u0441\u0435\u0439\u0432\u0430"};
    private static final String[] F0_LABELS = new String[]{"\u0421\u0435\u0439\u0432 \u042d\u043d\u0434", "\u041b\u0443\u0442 \u042d\u043d\u0434", "\u0421\u043f\u043e\u0441\u043e\u0431 \u0422\u041f", "\u0412\u0430\u0440\u043f", "\u041c\u0430\u043a\u0441. \u0432\u0430\u0437", "\u041a\u0438\u0441\u0442\u044c (\u043f\u0435\u0441\u043e\u043a)", "\u0417\u0435\u043b\u044c\u044f \u0441\u043a\u043e\u0440\u043e\u0441\u0442\u0438"};
    private static final int[] LEGACY = new int[]{-16777216, -16777046, -16733696, -16733526, -5636096, -5635926, -22016, -5592406, -11184811, -11184641, -11141291, -11141121, -43691, -43521, -171, -1};
    private static float posX = Float.NaN;
    private static float posY = Float.NaN;
    private static dtv selected;
    private static Tab tab;
    private static boolean lootPicker;
    private static boolean cameraMode;
    private final List<Zone> zones = new ArrayList<Zone>();
    private final Field nickField = new Field(16, "\u043d\u0438\u043a");
    private final Field addressField = new Field(80, "\u0430\u0434\u0440\u0435\u0441 \u0441\u0435\u0440\u0432\u0435\u0440\u0430");
    private final Field chatField = new Field(256, "\u0441\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0435 \u0438\u043b\u0438 /\u043a\u043e\u043c\u0430\u043d\u0434\u0430");
    private final Field botAddressField = new Field(80, "\u0430\u0434\u0440\u0435\u0441");
    private final Field broadcastField = new Field(256, "\u0432\u0441\u0435\u043c: /an513, /tpa \u043d\u0438\u043a");
    private final Field captchaField = new Field(16, "\u0446\u0438\u0444\u0440\u044b \u0441 \u043a\u0430\u0440\u0442\u0438\u043d\u043a\u0438");
    private final Map<vmu, Field> settingFields = new HashMap<vmu, Field>();
    private final List<String> sentHistory = new ArrayList<String>();
    private int pickerRow;
    private int mineScroll;
    private String allNotice;
    private long allNoticeTime;
    private boolean captchaExpand;
    private Field focused;
    private String formError;
    private long formErrorTime;
    private DrawContext ctx;
    private float scale = 1.0f;
    private float x;
    private float y;
    private boolean dragging;
    private double dragX;
    private double dragY;
    private boolean rotating;
    private boolean control;
    private boolean keyForward;
    private boolean keyBack;
    private boolean keyLeft;
    private boolean keyRight;
    private boolean keyJump;
    private boolean keySneak;
    private boolean keySprint;
    private boolean mouseAttack;
    private boolean mouseUse;
    private float listScroll;
    private float chatScroll;
    private int historyIndex = -1;
    private float viewX;
    private float viewY;
    private float viewW;
    private float viewH;
    private boolean viewShown;
    private ItemStack hoveredStack = ItemStack.field_8037;
    private Slot hoveredSlot;
    private ScreenHandler hoveredHandler;
    private ChatCache chatCache;

    public BotScreen() {
        super((Text)Text.method_43470((String)"\u0411\u043e\u0442\u044b"));
    }

    protected void method_25426() {
        if (this.addressField.text.isEmpty()) {
            this.addressField.setText(egq.get().suggestAddress());
        }
        if (selected != null && !egq.get().getBots().contains(selected)) {
            selected = null;
        }
        if (selected == null && !egq.get().getBots().isEmpty()) {
            selected = egq.get().getBots().get(0);
        }
        this.syncBotFields();
    }

    public boolean method_25421() {
        return false;
    }

    public void method_25432() {
        this.setControl(false);
        this.commitSettingFields();
    }

    public void method_25420(DrawContext context, int mouseX, int mouseY, float delta) {
        uut.beginFrame();
        unf.observe(context);
        iov.update(unf.delta());
        float dim = (float)iov.DIM.get();
        if (this.field_22787 != null && this.field_22787.field_1687 != null) {
            hyv.capture(context, iov.BG_BLUR.getInt(), 1.0f, null);
            uut.gradientV(context, 0.0f, 0.0f, this.field_22789, this.field_22790, 0.0f, ujt.withAlpha(0, (int)(255.0f * dim * 0.65f)), ujt.withAlpha(0, (int)(255.0f * dim)));
        } else {
            hyv.skip();
            this.method_57728(context, delta);
            uut.rect(context, 0.0f, 0.0f, this.field_22789, this.field_22790, ujt.withAlpha(0, (int)(255.0f * Math.max(0.3f, dim))));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void method_25394(DrawContext context, int realX, int realY, float delta) {
        this.ctx = context;
        this.scale = Math.min(1.0f, Math.min(((float)this.field_22789 - 8.0f) / 600.0f, ((float)this.field_22790 - 8.0f) / 318.0f));
        this.scale = Math.max(0.3f, this.scale);
        int mouseX = Math.round((float)realX / this.scale);
        int mouseY = Math.round((float)realY / this.scale);
        this.zones.clear();
        this.viewShown = false;
        this.hoveredStack = ItemStack.field_8037;
        this.hoveredSlot = null;
        this.hoveredHandler = null;
        this.captchaExpand = false;
        for (Field field : this.allFields()) {
            field.visible = false;
        }
        float screenW = (float)this.field_22789 / this.scale;
        float screenH = (float)this.field_22790 / this.scale;
        if (Float.isNaN(posX)) {
            posX = (screenW - 600.0f) / 2.0f;
            posY = (screenH - 318.0f) / 2.0f;
        }
        posX = MathHelper.method_15363((float)posX, (float)0.0f, (float)Math.max(0.0f, screenW - 600.0f));
        posY = MathHelper.method_15363((float)posY, (float)0.0f, (float)Math.max(0.0f, screenH - 318.0f));
        this.x = Math.round(posX);
        this.y = Math.round(posY);
        if (selected != null && !egq.get().getBots().contains(selected)) {
            selected = null;
        }
        if (this.control && (selected == null || selected.getPlayer() == null)) {
            this.setControl(false);
        }
        if (this.control && selected != null) {
            selected.getControl().setMovement(this.keyForward, this.keyBack, this.keyLeft, this.keyRight, this.keyJump, this.keySneak, this.keySprint);
        }
        vdn.setRenderScale(this.scale);
        context.method_51448().pushMatrix();
        context.method_51448().scale(this.scale, this.scale);
        try {
            this.renderShell();
            this.renderList(mouseX, mouseY);
            if (selected == null) {
                this.renderEmpty();
            } else {
                this.renderBot(selected, mouseX, mouseY);
                if (this.captchaExpand) {
                    this.renderCaptchaExpand(selected.getCaptcha());
                }
            }
        }
        finally {
            context.method_51448().popMatrix();
            vdn.setRenderScale(1.0f);
        }
        if (selected != null) {
            ClientPlayerEntity player = selected.getPlayer();
            if (player != null && !player.field_7512.method_34255().method_7960()) {
                ItemStack cursor = player.field_7512.method_34255();
                context.method_51427(cursor, realX - 8, realY - 8);
                context.method_51431(this.field_22793, cursor, realX - 8, realY - 8);
            } else if (!this.hoveredStack.method_7960()) {
                context.method_51446(this.field_22793, this.hoveredStack, realX, realY);
            }
        }
        this.ctx = null;
    }

    private void renderShell() {
        float r = iov.r(12.0f);
        uut.shadow(this.ctx, this.x, this.y + 3.0f, 600.0f, 318.0f, r, 14.0f, iov.shadow);
        boolean glass = hyv.surface(this.ctx, this.x, this.y, 600.0f, 318.0f, r, hyv.tint(iov.window, iov.windowTint()), ujt.withAlpha(iov.window, 255), (float)hyv.EDGE.get(), hyv.WINDOW);
        uut.round(this.ctx, this.x, this.y, 600.0f, 20.0f, r, r, 0.0f, 0.0f, iov.panel);
        if (!glass || !hyv.liquid()) {
            uut.outline(this.ctx, this.x, this.y, 600.0f, 318.0f, r, 1.0f, glass ? ujt.withAlpha(0xFFFFFF, 24) : iov.stroke);
        }
        uut.round(this.ctx, this.x + 6.0f, this.y + 6.0f, 2.5f, 8.0f, 1.25f, BotScreen.accent(235));
        vdn bold = BotScreen.semibold(8.5f);
        this.text(bold, "\u0411\u043e\u0442\u044b", this.x + 14.0f, this.y + 10.0f, BotScreen.text());
        int online = 0;
        for (dtv bot : egq.get().getBots()) {
            if (bot.getStatus() != dts.ONLINE) continue;
            ++online;
        }
        Runtime runtime = Runtime.getRuntime();
        long used = runtime.totalMemory() - runtime.freeMemory() >> 20;
        long max = runtime.maxMemory() >> 20;
        String count = "\u0432 \u0438\u0433\u0440\u0435 " + online + " \u0438\u0437 " + egq.get().getBots().size() + "   \u043f\u0430\u043c\u044f\u0442\u044c " + String.format(Locale.ROOT, "%.1f / %.1f \u0413\u0411", (double)used / 1024.0, (double)max / 1024.0);
        this.text(BotScreen.medium(6.5f), count, this.x + 14.0f + bold.width("\u0411\u043e\u0442\u044b") + 8.0f, this.y + 10.0f, BotScreen.textDim());
        float closeX = this.x + 600.0f - 18.0f;
        this.centered(BotScreen.medium(7.0f), "x", closeX + 6.0f, this.y + 10.0f, BotScreen.textDim());
        this.zone(closeX, this.y + 3.0f, 12.0f, 14.0f, b -> this.method_25419());
    }

    private void renderEmpty() {
        float left = this.x + 6.0f + 146.0f + 6.0f;
        float cx = left + 218.0f;
        float cy = this.y + 159.0f;
        vdn font = BotScreen.medium(7.0f);
        this.centered(font, "\u0414\u043e\u0431\u0430\u0432\u044c \u0431\u043e\u0442\u0430 \u0441\u043b\u0435\u0432\u0430: \u043d\u0438\u043a \u043e\u0444\u0444\u043b\u0430\u0439\u043d-\u0430\u043a\u043a\u0430\u0443\u043d\u0442\u0430 \u0438 \u0430\u0434\u0440\u0435\u0441 \u0441\u0435\u0440\u0432\u0435\u0440\u0430.", cx, cy - 8.0f, BotScreen.textDim());
        this.centered(font, "\u0411\u043e\u0442 \u0437\u0430\u0439\u0434\u0451\u0442 \u0441\u0430\u043c - \u0434\u0430\u043b\u044c\u0448\u0435 /login \u0432 \u0435\u0433\u043e \u0447\u0430\u0442\u0435 \u0438 " + vup.e() + ".", cx, cy + 5.0f, BotScreen.textDim());
    }

    private void renderList(int mouseX, int mouseY) {
        float left = this.x + 6.0f;
        float top = this.y + 20.0f + 6.0f;
        float formH = 82.0f;
        float listBottom = this.y + 318.0f - 6.0f - formH - 4.0f;
        uut.round(this.ctx, left, top, 146.0f, listBottom - top, 7.0f, iov.card);
        List<dtv> bots = egq.get().getBots();
        float content = (float)bots.size() * 33.0f;
        float visible = listBottom - top - 6.0f;
        this.listScroll = MathHelper.method_15363((float)this.listScroll, (float)(-Math.max(0.0f, content - visible)), (float)0.0f);
        uut.pushScissor(this.ctx, left, top + 2.0f, 146.0f, listBottom - top - 4.0f);
        float rowY = top + 3.0f + this.listScroll;
        for (dtv bot : bots) {
            if (rowY + 30.0f >= top && rowY <= listBottom) {
                this.renderBotRow(bot, left + 3.0f, rowY, 140.0f, mouseX, mouseY, top, listBottom);
            }
            rowY += 33.0f;
        }
        uut.popScissor(this.ctx);
        if (bots.isEmpty()) {
            this.centered(BotScreen.medium(7.0f), "\u0431\u043e\u0442\u043e\u0432 \u043d\u0435\u0442", left + 73.0f, (top + listBottom) / 2.0f, BotScreen.textDim());
        }
        this.renderAddForm(left, listBottom + 4.0f, 146.0f, formH, mouseX, mouseY);
    }

    private void renderBotRow(dtv bot, float rx, float ry, float rw, int mouseX, int mouseY, float clipTop, float clipBottom) {
        String sub;
        boolean hover;
        boolean isSelected = bot == selected;
        boolean bl = hover = BotScreen.hovered(mouseX, mouseY, rx, ry, rw, 30.0f) && (float)mouseY >= clipTop && (float)mouseY <= clipBottom;
        if (isSelected) {
            uut.round(this.ctx, rx - 1.0f, ry - 1.0f, rw + 2.0f, 32.0f, 7.0f, BotScreen.accent(150));
            uut.round(this.ctx, rx, ry, rw, 30.0f, 6.0f, ujt.withAlpha(iov.window, 220));
        }
        uut.round(this.ctx, rx, ry, rw, 30.0f, 6.0f, hover ? iov.fieldHover : iov.field);
        this.zoneClip(rx, ry, rw, 30.0f, clipTop, clipBottom, b -> {
            selected = bot;
            this.chatScroll = 0.0f;
            this.syncBotFields();
        });
        uut.round(this.ctx, rx + 6.0f, ry + 15.0f - 3.0f, 6.0f, 6.0f, 2.25f, BotScreen.statusColor(bot.getStatus()));
        float nameX = rx + 17.0f;
        float buttonsW = hover ? 44.0f : 0.0f;
        vdn bold = BotScreen.semibold(7.5f);
        vdn font = BotScreen.medium(6.5f);
        this.text(bold, BotScreen.trim(bold, bot.getName(), rw - 22.0f - buttonsW), nameX, ry + 9.0f, BotScreen.text());
        int subColor = BotScreen.textDim();
        if (bot.getStatus() == dts.ONLINE && bot.getCaptcha().isPresent()) {
            sub = "\u043a\u0430\u043f\u0447\u0430 - \u043d\u0443\u0436\u0435\u043d \u043a\u043e\u0434";
            subColor = -1526966;
        } else if (bot.getStatus() == dts.ONLINE) {
            sub = bot.f0Run() ? bot.f0ref().getStateDescription() : (bot.f1Run() ? "\u0412\u0430\u0440\u0434\u0435\u043d: " + BotScreen.f1StateLabel(bot.f1ref().getStateIndex()) : (bot.f2Run() ? "\u0428\u0430\u0445\u0442\u0430: " + BotScreen.mineStatus(bot) : (bot.f3Run() ? "\u041e\u0431\u043b\u043e\u043c\u043a\u0438: " + bot.f3ref().status() : "\u0432 \u0438\u0433\u0440\u0435")));
        } else if (bot.getReconnectAt() > 0L) {
            long left = Math.max(0L, (bot.getReconnectAt() - System.currentTimeMillis()) / 1000L);
            sub = "\u043f\u0435\u0440\u0435\u043f\u043e\u0434\u043a\u043b\u044e\u0447\u0435\u043d\u0438\u0435 " + left + " \u0441";
        } else {
            sub = bot.getStatusText();
        }
        this.text(font, BotScreen.trim(font, sub, rw - 22.0f - buttonsW), nameX, ry + 21.0f, subColor);
        ClientPlayerEntity player = bot.getPlayer();
        if (player != null && !hover) {
            float barW = 30.0f;
            float ratio = MathHelper.method_15363((float)(player.method_6032() / Math.max(1.0f, player.method_6063())), (float)0.0f, (float)1.0f);
            uut.round(this.ctx, rx + rw - barW - 6.0f, ry + 7.5f, barW, 3.0f, 1.5f, iov.track);
            uut.round(this.ctx, rx + rw - barW - 6.0f, ry + 7.5f, Math.max(3.0f, barW * ratio), 3.0f, 1.5f, ratio > 0.5f ? -10758549 : (ratio > 0.25f ? -1526966 : -2073765));
        }
        if (hover) {
            boolean connected = bot.getStatus() != dts.OFFLINE && bot.getStatus() != dts.FAILED;
            float bx = rx + rw - 42.0f;
            this.smallButton(bx, ry + 15.0f - 7.0f, 24.0f, 14.0f, connected ? "\u0432\u044b\u043a\u043b" : "\u0432\u043a\u043b", mouseX, mouseY, b -> {
                if (connected) {
                    bot.disconnect();
                } else {
                    bot.connect();
                }
            });
            this.smallButton(bx + 26.0f, ry + 15.0f - 7.0f, 14.0f, 14.0f, "x", mouseX, mouseY, b -> {
                egq.get().remove(bot);
                if (selected == bot) {
                    selected = egq.get().getBots().isEmpty() ? null : egq.get().getBots().get(0);
                    this.syncBotFields();
                }
            });
        }
    }

    private void renderAddForm(float fx, float fy, float fw, float fh, int mouseX, int mouseY) {
        uut.round(this.ctx, fx, fy, fw, fh, 7.0f, iov.card);
        vdn font = BotScreen.medium(6.5f);
        float inner = fx + 5.0f;
        float innerW = fw - 10.0f;
        this.nickField.render(inner, fy + 5.0f, innerW, 16.0f, mouseX, mouseY);
        this.addressField.render(inner, fy + 24.0f, innerW, 16.0f, mouseX, mouseY);
        this.button(inner, fy + 44.0f, innerW, 16.0f, "\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u0431\u043e\u0442\u0430", true, mouseX, mouseY, b -> this.addBot());
        boolean error = this.formError != null && System.currentTimeMillis() - this.formErrorTime < 5000L;
        String hint = error ? this.formError : "\u043d\u0438\u043a: \u043b\u0430\u0442\u0438\u043d\u0438\u0446\u0430, \u0446\u0438\u0444\u0440\u044b, _";
        this.text(font, BotScreen.trim(font, hint, innerW), inner, fy + 70.0f, error ? -2073765 : BotScreen.textDim());
    }

    private void addBot() {
        String nick = this.nickField.text.trim();
        String address = this.addressField.text.trim();
        if (!egq.isValidName(nick)) {
            this.formError = "\u043d\u0438\u043a - \u043e\u0442 3 \u0434\u043e 16 \u0441\u0438\u043c\u0432\u043e\u043b\u043e\u0432: A-Z, 0-9, _";
            this.formErrorTime = System.currentTimeMillis();
            return;
        }
        if (address.isEmpty()) {
            this.formError = "\u0443\u043a\u0430\u0436\u0438 \u0430\u0434\u0440\u0435\u0441 \u0441\u0435\u0440\u0432\u0435\u0440\u0430";
            this.formErrorTime = System.currentTimeMillis();
            return;
        }
        dtv bot = egq.get().add(nick, address);
        if (bot != null) {
            selected = bot;
            this.nickField.setText("");
            this.formError = null;
            this.chatScroll = 0.0f;
            this.syncBotFields();
        }
    }

    private void renderBot(dtv bot, int mouseX, int mouseY) {
        float left = this.x + 6.0f + 146.0f + 6.0f;
        float right = this.x + 600.0f - 6.0f;
        float top = this.y + 20.0f + 6.0f;
        this.renderInfo(bot, left, top, right - left);
        float contentTop = top + 18.0f + 4.0f;
        float contentBottom = this.y + 318.0f - 6.0f;
        float rightX = left + 226.0f + 6.0f;
        ClientPlayerEntity player = bot.getPlayer();
        boolean container = player != null && player.field_7512 != player.field_7498;
        vlj picker = BotScreen.openPicker(bot);
        if (container) {
            this.renderContainer(bot, player, left, contentTop, 226.0f, contentBottom - contentTop, mouseX, mouseY);
        } else if (picker != null) {
            this.renderPicker(picker, left, contentTop, 226.0f, contentBottom - contentTop, mouseX, mouseY);
        } else if (player != null && bot.getCaptcha().isShown()) {
            this.renderCaptcha(bot, left, contentTop, 226.0f, contentBottom - contentTop, mouseX, mouseY);
        } else {
            this.renderView(bot, left, contentTop, 226.0f, 150.0f, mouseX, mouseY);
            this.renderInventory(bot, left, contentTop + 150.0f + 4.0f, 226.0f, contentBottom - contentTop - 150.0f - 4.0f, mouseX, mouseY);
        }
        this.renderTabs(bot, rightX, contentTop, right - rightX, contentBottom - contentTop, mouseX, mouseY);
    }

    private void renderInfo(dtv bot, float ix, float iy, float iw) {
        String info;
        uut.round(this.ctx, ix, iy, iw, 18.0f, 6.0f, iov.card);
        vdn bold = BotScreen.semibold(7.5f);
        vdn font = BotScreen.medium(6.5f);
        float cy = iy + 9.0f;
        uut.round(this.ctx, ix + 6.0f, cy - 3.0f, 6.0f, 6.0f, 2.25f, BotScreen.statusColor(bot.getStatus()));
        this.text(bold, bot.getName(), ix + 16.0f, cy, BotScreen.text());
        float cursor = ix + 16.0f + bold.width(bot.getName()) + 8.0f;
        ClientPlayerEntity player = bot.getPlayer();
        if (player == null) {
            info = bot.getStatusText();
        } else {
            BlockPos pos = player.method_24515();
            ClientWorld level = bot.getWorld();
            String dim = level == null ? "?" : BotScreen.dimensionName(level.method_27983().method_29177().method_12832());
            info = String.format(Locale.ROOT, "%.0f/%.0f hp   \u0435\u0434\u0430 %d   %s   %d %d %d   \u043f\u0438\u043d\u0433 %s   %.1f \u043c\u0441", Float.valueOf(player.method_6032()), Float.valueOf(player.method_6063()), player.method_7344().method_7586(), dim, pos.method_10263(), pos.method_10264(), pos.method_10260(), bot.getPing() < 0 ? "-" : String.valueOf(bot.getPing()), Float.valueOf(bot.getTickMillis()));
        }
        this.text(font, BotScreen.trim(font, info, ix + iw - 6.0f - cursor), cursor, cy, BotScreen.textDim());
    }

    private void renderView(dtv bot, float vx, float vy, float vw, float vh, int mouseX, int mouseY) {
        this.viewX = vx;
        this.viewY = vy;
        this.viewW = vw;
        this.viewH = vh;
        this.viewShown = true;
        if (this.control) {
            uut.round(this.ctx, vx - 1.5f, vy - 1.5f, vw + 3.0f, vh + 3.0f, 8.0f, BotScreen.accent(170));
        }
        uut.round(this.ctx, vx, vy, vw, vh, 7.0f, this.control ? -351794932 : -687339252);
        ClientPlayerEntity player = bot.getPlayer();
        vdn font = BotScreen.medium(7.0f);
        if (player == null) {
            this.centered(font, "\u0431\u043e\u0442 \u043d\u0435 \u0432 \u0438\u0433\u0440\u0435", vx + vw / 2.0f, vy + vh / 2.0f, BotScreen.textDim());
        } else if (cameraMode) {
            this.renderCamera(bot, vx, vy, vw, vh);
        } else {
            this.renderRadar(bot, player, vx, vy, vw, vh);
        }
        if (player != null) {
            this.renderOverlays(bot, vx, vy, vw, vh);
        }
        float by = vy + 4.0f;
        this.chip(vx + 4.0f, by, "\u0420\u0430\u0434\u0430\u0440", !cameraMode, mouseX, mouseY, b -> {
            cameraMode = false;
        });
        this.chip(vx + 40.0f, by, "\u041a\u0430\u043c\u0435\u0440\u0430", cameraMode, mouseX, mouseY, b -> {
            cameraMode = true;
        });
        if (player != null && bot.getCaptcha().isPresent()) {
            this.chip(vx + 82.0f, by, "\u041a\u0430\u043f\u0447\u0430", false, mouseX, mouseY, b -> bot.getCaptcha().show());
        }
        this.chip(vx + vw - 70.0f, by, this.control ? "\u0423\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u0438\u0435 \u0432\u043a\u043b" : "\u0423\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u0438\u0435", this.control, mouseX, mouseY, b -> this.setControl(!this.control));
        if (this.control) {
            this.text(BotScreen.medium(5.5f), "WASD, \u043f\u0440\u043e\u0431\u0435\u043b, Shift, Ctrl  -  \u041b\u041a\u041c/\u041f\u041a\u041c  -  \u043a\u043e\u043b\u0435\u0441\u043e: \u0442\u044f\u043d\u0443\u0442\u044c = \u043f\u043e\u0432\u043e\u0440\u043e\u0442", vx + 5.0f, vy + vh - 7.0f, BotScreen.textDim());
        }
    }

    private void renderCamera(dtv bot, float vx, float vy, float vw, float vh) {
        dyh camera = bot.getCamera();
        camera.demand();
        elb texture = camera.texture();
        if (texture == null) {
            this.centered(BotScreen.medium(7.0f), camera.getStatus(), vx + vw / 2.0f, vy + vh / 2.0f, BotScreen.textDim());
            return;
        }
        uut.imageRegion(this.ctx, texture.view(), vx, vy, vw, vh, 7.0f, 0.0f, 0.0f, 1.0f, 1.0f, -1, false);
        float cx = vx + vw / 2.0f;
        float cy = vy + vh / 2.0f;
        uut.rect(this.ctx, cx - 3.5f, cy - 0.5f, 7.0f, 1.0f, -922746881);
        uut.rect(this.ctx, cx - 0.5f, cy - 3.5f, 1.0f, 7.0f, -922746881);
        vdn font = BotScreen.medium(5.5f);
        uut.pushScissor(this.ctx, vx, vy, vw, vh);
        for (dxe label : camera.labels()) {
            float lx = vx + label.x() * vw;
            float ly = vy + label.y() * vh;
            float lw = font.width(label.text()) + 6.0f;
            uut.round(this.ctx, lx - lw / 2.0f, ly - 4.5f, lw, 9.0f, 3.0f, -1778384896);
            this.centered(font, label.text(), lx, ly, label.color());
        }
        uut.popScissor(this.ctx);
        this.text(font, String.format(Locale.ROOT, "%.1f \u043c\u0441", Float.valueOf(camera.getRenderMillis())), vx + vw - 30.0f, vy + vh - 7.0f, -1761607681);
    }

    private void renderRadar(dtv bot, ClientPlayerEntity player, float vx, float vy, float vw, float vh) {
        nxa fW;
        float pz;
        mpq fE;
        eip radar = bot.getRadar();
        radar.demand();
        elb texture = radar.texture();
        float scale = vw / 96.0f;
        double offsetX = (player.method_23317() - ((double)radar.getCenterX() + 0.5)) * (double)scale;
        double offsetZ = (player.method_23321() - ((double)radar.getCenterZ() + 0.5)) * (double)scale;
        float cx = vx + vw / 2.0f;
        float cy = vy + vh / 2.0f;
        uut.pushScissor(this.ctx, vx + 1.0f, vy + 1.0f, vw - 2.0f, vh - 2.0f);
        if (texture != null) {
            float size = 96.0f * scale;
            float tx = Math.round((float)((double)(cx - size / 2.0f) - offsetX));
            float ty = Math.round((float)((double)(cy - size / 2.0f) - offsetZ));
            uut.imageRegion(this.ctx, texture.view(), tx, ty, size, size, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, -1, true);
        }
        if ((fE = bot.f0ref()).isEnabled()) {
            BlockPos target;
            List<BlockPos> path = fE.getBotPath();
            if (path != null) {
                for (int i = Math.max(0, fE.getBotPathIndex()); i < path.size(); ++i) {
                    BlockPos node = path.get(i);
                    float px = cx + (float)(((double)node.method_10263() + 0.5 - player.method_23317()) * (double)scale);
                    pz = cy + (float)(((double)node.method_10260() + 0.5 - player.method_23321()) * (double)scale);
                    uut.round(this.ctx, px - 1.25f, pz - 1.25f, 2.5f, 2.5f, 1.0f, BotScreen.accent(200));
                }
            }
            if ((target = fE.getBotTarget()) != null) {
                float px = cx + (float)(((double)target.method_10263() + 0.5 - player.method_23317()) * (double)scale);
                float pz2 = cy + (float)(((double)target.method_10260() + 0.5 - player.method_23321()) * (double)scale);
                uut.round(this.ctx, px - 4.0f, pz2 - 4.0f, 8.0f, 8.0f, 3.5f, BotScreen.accent(230));
                uut.round(this.ctx, px - 2.5f, pz2 - 2.5f, 5.0f, 5.0f, 2.0f, -435681012);
            }
        }
        if ((fW = bot.f1ref()).isEnabled()) {
            BlockPos target;
            List<BlockPos> path = fW.getBotPath();
            if (path != null) {
                for (int i = Math.max(0, fW.getBotPathIndex()); i < path.size(); ++i) {
                    BlockPos node = path.get(i);
                    float px = cx + (float)(((double)node.method_10263() + 0.5 - player.method_23317()) * (double)scale);
                    float pz3 = cy + (float)(((double)node.method_10260() + 0.5 - player.method_23321()) * (double)scale);
                    uut.round(this.ctx, px - 1.25f, pz3 - 1.25f, 2.5f, 2.5f, 1.0f, BotScreen.accent(200));
                }
            }
            if ((target = fW.getBotTarget()) != null) {
                float px = cx + (float)(((double)target.method_10263() + 0.5 - player.method_23317()) * (double)scale);
                pz = cy + (float)(((double)target.method_10260() + 0.5 - player.method_23321()) * (double)scale);
                uut.round(this.ctx, px - 4.0f, pz - 4.0f, 8.0f, 8.0f, 3.5f, -1526966);
                uut.round(this.ctx, px - 2.5f, pz - 2.5f, 5.0f, 5.0f, 2.0f, -435681012);
            }
        }
        ClientWorld level = bot.getWorld();
        vdn font = BotScreen.medium(5.5f);
        if (level != null) {
            for (Entity entity : level.method_18112()) {
                if (entity == player) continue;
                float px = cx + (float)((entity.method_23317() - player.method_23317()) * (double)scale);
                float pz4 = cy + (float)((entity.method_23321() - player.method_23321()) * (double)scale);
                if (px < vx || px > vx + vw || pz4 < vy || pz4 > vy + vh) continue;
                if (entity instanceof OtherClientPlayerEntity) {
                    OtherClientPlayerEntity other = (OtherClientPlayerEntity)entity;
                    uut.round(this.ctx, px - 2.5f, pz4 - 2.5f, 5.0f, 5.0f, 2.0f, -2073765);
                    this.text(font, other.method_5477().getString(), px + 4.0f, pz4, -12080);
                    continue;
                }
                if (entity instanceof ItemEntity) {
                    uut.round(this.ctx, px - 1.5f, pz4 - 1.5f, 3.0f, 3.0f, 1.2f, -10166);
                    continue;
                }
                if (!(entity instanceof HostileEntity)) continue;
                uut.round(this.ctx, px - 2.0f, pz4 - 2.0f, 4.0f, 4.0f, 1.5f, -30147);
            }
        }
        double yaw = Math.toRadians(player.method_36454());
        float dx = (float)(-Math.sin(yaw));
        float dz = (float)Math.cos(yaw);
        for (int i = 1; i <= 3; ++i) {
            uut.round(this.ctx, cx + dx * 3.2f * (float)i - 1.0f, cy + dz * 3.2f * (float)i - 1.0f, 2.0f, 2.0f, 0.9f, -1);
        }
        uut.round(this.ctx, cx - 3.0f, cy - 3.0f, 6.0f, 6.0f, 2.5f, -1);
        uut.round(this.ctx, cx - 1.75f, cy - 1.75f, 3.5f, 3.5f, 1.5f, BotScreen.accent());
        uut.popScissor(this.ctx);
        elb map = radar.mapTexture();
        if (map != null) {
            float size = 64.0f;
            float mx = Math.round(vx + vw - size - 5.0f);
            float my = Math.round(vy + vh - size - 12.0f);
            uut.round(this.ctx, mx - 2.0f, my - 2.0f, size + 4.0f, size + 4.0f, 3.0f, -939524096);
            uut.imageRegion(this.ctx, map.view(), mx, my, size, size, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, -1, true);
        }
    }

    private void renderCaptcha(dtv bot, float cx, float cy, float cw, float ch, int mouseX, int mouseY) {
        uut.round(this.ctx, cx, cy, cw, ch, 7.0f, iov.card);
        eao captcha = bot.getCaptcha();
        vdn bold = BotScreen.semibold(7.5f);
        vdn font = BotScreen.medium(6.5f);
        this.text(bold, "\u041a\u0430\u043f\u0447\u0430", cx + 7.0f, cy + 9.0f, -1526966);
        String info = captcha.getFilledTiles() < captcha.getTotalTiles() ? "\u043a\u0430\u0440\u0442\u044b \u0433\u0440\u0443\u0437\u044f\u0442\u0441\u044f " + captcha.getFilledTiles() + "/" + captcha.getTotalTiles() : (!captcha.getAutoCode().isEmpty() ? "\u0441\u0435\u0442\u044c \u043e\u0442\u043f\u0440\u0430\u0432\u0438\u043b\u0430 " + captcha.getAutoCode() + " - \u0435\u0441\u043b\u0438 \u043d\u0435 \u043f\u0440\u0438\u043d\u044f\u043b\u0438, \u0432\u0432\u0435\u0434\u0438 \u0441\u0430\u043c" : (!captcha.getAutoState().isEmpty() ? captcha.getAutoState() : "\u0432\u0432\u0435\u0434\u0438 \u0446\u0438\u0444\u0440\u044b \u0441 \u043a\u0430\u0440\u0442\u0438\u043d\u043a\u0438"));
        float infoX = cx + 7.0f + bold.width("\u041a\u0430\u043f\u0447\u0430") + 6.0f;
        this.text(font, BotScreen.trim(font, info, cw - (infoX - cx) - 56.0f), infoX, cy + 9.0f, BotScreen.textDim());
        this.smallButton(cx + cw - 50.0f, cy + 3.0f, 44.0f, 12.0f, "\u0441\u043a\u0440\u044b\u0442\u044c", mouseX, mouseY, b -> captcha.dismiss());
        float fieldH = 16.0f;
        float top = cy + 18.0f;
        float bottom = cy + ch - fieldH - 9.0f;
        elb texture = captcha.texture();
        int imageW = Math.max(1, captcha.getWidth());
        int imageH = Math.max(1, captcha.getHeight());
        float scale = Math.min((cw - 10.0f) / (float)imageW, (bottom - top) / (float)imageH);
        float drawW = Math.max(1, Math.round((float)imageW * scale));
        float drawH = Math.max(1, Math.round((float)imageH * scale));
        float drawX = Math.round(cx + (cw - drawW) / 2.0f);
        float drawY = Math.round(top + (bottom - top - drawH) / 2.0f);
        uut.round(this.ctx, drawX - 2.0f, drawY - 2.0f, drawW + 4.0f, drawH + 4.0f, 3.0f, -939524096);
        if (texture != null) {
            uut.imageRegion(this.ctx, texture.view(), drawX, drawY, drawW, drawH, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, -1, false);
        }
        this.captchaExpand = texture != null && BotScreen.hovered(mouseX, mouseY, drawX, drawY, drawW, drawH);
        float fy = cy + ch - fieldH - 5.0f;
        this.captchaField.render(cx + 5.0f, fy, cw - 10.0f - 66.0f, fieldH, mouseX, mouseY);
        this.button(cx + cw - 5.0f - 62.0f, fy, 62.0f, fieldH, "\u041e\u0442\u043f\u0440\u0430\u0432\u0438\u0442\u044c", true, mouseX, mouseY, b -> this.submitCaptcha());
    }

    private void renderCaptchaExpand(eao captcha) {
        elb texture = captcha.texture();
        if (texture == null) {
            return;
        }
        int imageW = Math.max(1, captcha.getWidth());
        int imageH = Math.max(1, captcha.getHeight());
        float maxW = Math.min(580.0f, (float)this.field_22789 / this.scale - 10.0f);
        float maxH = Math.min(298.0f, (float)this.field_22790 / this.scale - 10.0f);
        float scale = Math.min(maxW / (float)imageW, maxH / (float)imageH);
        float drawW = Math.round((float)imageW * scale);
        float drawH = Math.round((float)imageH * scale);
        float drawX = Math.round(this.x + (600.0f - drawW) / 2.0f);
        float drawY = Math.round(this.y + (318.0f - drawH) / 2.0f);
        uut.round(this.ctx, drawX - 3.0f, drawY - 3.0f, drawW + 6.0f, drawH + 6.0f, 5.0f, -352321536);
        uut.imageRegion(this.ctx, texture.view(), drawX, drawY, drawW, drawH, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, -1, false);
    }

    private void submitCaptcha() {
        String code = this.captchaField.text.replaceAll("\\s+", "");
        if (selected != null && !code.isEmpty()) {
            selected.getCaptcha().answered(code);
            selected.sendChat(code);
            this.captchaField.setText("");
        }
        this.focused = null;
    }

    private void renderOverlays(dtv bot, float vx, float vy, float vw, float vh) {
        Text actionBar;
        Text subtitle;
        Text title;
        float barY = vy + 22.0f;
        int shown = 0;
        for (ClientBossBar bar : bot.getBossBars().values()) {
            if (shown++ >= 2) break;
            float bw = 110.0f;
            float bx = vx + vw / 2.0f - bw / 2.0f;
            this.styledCentered(bar.method_5414(), vx + vw / 2.0f, barY, 6.5f, bw + 60.0f);
            uut.round(this.ctx, bx, barY + 5.0f, bw, 3.0f, 1.5f, 0x32FFFFFF);
            uut.round(this.ctx, bx, barY + 5.0f, Math.max(3.0f, bw * bar.method_5412()), 3.0f, 1.5f, -2039584);
            barY += 15.0f;
        }
        if ((title = bot.getTitle()) != null) {
            this.styledCentered(title, vx + vw / 2.0f, vy + vh / 2.0f - 6.0f, 10.0f, vw - 10.0f);
        }
        if ((subtitle = bot.getSubtitle()) != null) {
            this.styledCentered(subtitle, vx + vw / 2.0f, vy + vh / 2.0f + 8.0f, 7.0f, vw - 10.0f);
        }
        if ((actionBar = bot.getActionBar()) != null) {
            this.styledCentered(actionBar, vx + vw / 2.0f, vy + vh - (this.control ? 18.0f : 9.0f), 6.5f, vw - 10.0f);
        }
        if (bot.getPlayer() != null && bot.getPlayer().method_29504()) {
            this.centered(BotScreen.semibold(7.0f), "\u0431\u043e\u0442 \u043f\u043e\u0433\u0438\u0431 - \u0432\u043e\u0437\u0440\u043e\u0436\u0434\u0435\u043d\u0438\u0435...", vx + vw / 2.0f, vy + vh / 2.0f + 22.0f, -2073765);
        }
        if (bot.getScreen() != null && !(bot.getScreen() instanceof DeathScreen)) {
            String name = bot.getScreen().getClass().getSimpleName();
            this.text(BotScreen.medium(5.5f), "\u043e\u0442\u043a\u0440\u044b\u0442 \u044d\u043a\u0440\u0430\u043d: " + name, vx + 5.0f, vy + vh - 18.0f, -1526966);
        }
    }

    private void renderInventory(dtv bot, float ix, float iy, float iw, float ih, int mouseX, int mouseY) {
        uut.round(this.ctx, ix, iy, iw, ih, 7.0f, iov.card);
        ClientPlayerEntity player = bot.getPlayer();
        if (player == null) {
            return;
        }
        PlayerScreenHandler handler = player.field_7498;
        float gridW = 180.0f;
        float gx = ix + (iw - gridW - 20.0f - 4.0f) / 2.0f + 20.0f + 4.0f;
        float gy = iy + 5.0f;
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.slot(bot, (ScreenHandler)handler, 9 + row * 9 + col, gx + (float)col * 20.0f, gy + (float)row * 20.0f, false, mouseX, mouseY);
            }
        }
        float hotbarY = gy + 60.0f + 4.0f;
        int selectedSlot = player.method_31548().method_67532();
        for (int col = 0; col < 9; ++col) {
            this.slot(bot, (ScreenHandler)handler, 36 + col, gx + (float)col * 20.0f, hotbarY, col == selectedSlot, mouseX, mouseY);
        }
        float armorX = gx - 20.0f - 4.0f;
        for (int i = 0; i < 4; ++i) {
            float sy = i < 3 ? gy + (float)i * 20.0f : hotbarY;
            this.slot(bot, (ScreenHandler)handler, 5 + i, armorX, sy, false, mouseX, mouseY);
        }
    }

    private void renderContainer(dtv bot, ClientPlayerEntity player, float cx, float cy, float cw, float ch, int mouseX, int mouseY) {
        uut.round(this.ctx, cx, cy, cw, ch, 7.0f, iov.card);
        ScreenHandler handler = player.field_7512;
        vdn bold = BotScreen.semibold(7.5f);
        String title = bot.getOpenedScreenTitle() == null ? "\u043a\u043e\u043d\u0442\u0435\u0439\u043d\u0435\u0440" : bot.getOpenedScreenTitle();
        this.text(bold, BotScreen.trim(bold, title, cw - 60.0f), cx + 7.0f, cy + 9.0f, BotScreen.text());
        this.smallButton(cx + cw - 50.0f, cy + 3.0f, 44.0f, 12.0f, "\u0437\u0430\u043a\u0440\u044b\u0442\u044c", mouseX, mouseY, b -> bot.closeScreen());
        int total = handler.field_7761.size();
        int own = Math.min(36, total);
        int containerSlots = Math.max(0, total - own);
        int rows = (containerSlots + 8) / 9;
        float gridW = 180.0f;
        float gx = cx + (cw - gridW) / 2.0f;
        float gy = cy + 18.0f;
        int maxRows = (int)((ch - 18.0f - 80.0f - 16.0f) / 20.0f);
        for (int i = 0; i < containerSlots && i / 9 < Math.max(1, maxRows); ++i) {
            this.slot(bot, handler, i, gx + (float)(i % 9) * 20.0f, gy + (float)(i / 9) * 20.0f, false, mouseX, mouseY);
        }
        float py = gy + (float)Math.min(rows, Math.max(1, maxRows)) * 20.0f + 8.0f;
        for (int i = 0; i < own && containerSlots + i < total; ++i) {
            int row = i / 9;
            float sy = row < 3 ? py + (float)row * 20.0f : py + 60.0f + 4.0f;
            this.slot(bot, handler, containerSlots + i, gx + (float)(i % 9) * 20.0f, sy, false, mouseX, mouseY);
        }
    }

    private void slot(dtv bot, ScreenHandler handler, int index, float sx, float sy, boolean highlight, int mouseX, int mouseY) {
        if (index < 0 || index >= handler.field_7761.size()) {
            return;
        }
        Slot slot = (Slot)handler.field_7761.get(index);
        boolean hover = BotScreen.hovered(mouseX, mouseY, sx, sy, 19.0f, 19.0f);
        if (highlight) {
            uut.round(this.ctx, sx - 1.0f, sy - 1.0f, 21.0f, 21.0f, 5.0f, BotScreen.accent(200));
            uut.round(this.ctx, sx, sy, 19.0f, 19.0f, 4.5f, ujt.withAlpha(iov.window, 220));
        }
        uut.round(this.ctx, sx, sy, 19.0f, 19.0f, 4.5f, hover ? iov.fieldHover : iov.field);
        ItemStack stack = slot.method_7677();
        if (!stack.method_7960()) {
            int ix = Math.round(sx + 1.5f);
            int iy = Math.round(sy + 1.5f);
            this.ctx.method_51427(stack, ix, iy);
            this.ctx.method_51431(this.field_22793, stack, ix, iy);
        }
        if (hover) {
            this.hoveredStack = stack;
            this.hoveredSlot = slot;
            this.hoveredHandler = handler;
        }
        int syncId = handler.field_7763;
        this.zone(sx, sy, 19.0f, 19.0f, button -> {
            boolean shift;
            ClientPlayerEntity owner = bot.getPlayer();
            if (owner == null) {
                return;
            }
            boolean bl = shift = this.field_22787 != null && this.field_22787.method_74187();
            if (handler == owner.field_7498 && index >= 36 && index <= 44 && button == 0 && !shift && owner.field_7512 == handler && handler.method_34255().method_7960() && this.control) {
                bot.selectSlot(index - 36);
                return;
            }
            SlotActionType action = shift ? SlotActionType.field_7794 : SlotActionType.field_7790;
            bot.clickSlot(syncId, index, button == 1 ? 1 : 0, action);
        });
    }

    private void renderTabs(dtv bot, float tx, float ty, float tw, float th, int mouseX, int mouseY) {
        float wide = 37.0f;
        float narrow = 33.0f;
        float gap = 2.0f;
        float tabW = (tw - wide * 3.0f - narrow - gap * 6.0f) / 3.0f;
        float cursor = tx;
        this.tabButton(cursor, ty, tabW, "\u0427\u0430\u0442", Tab.CHAT, mouseX, mouseY);
        this.tabButton(cursor += tabW + gap, ty, wide, vup.e(), Tab.TAB_E, mouseX, mouseY);
        this.tabButton(cursor += wide + gap, ty, wide, "\u0412\u0430\u0440\u0434\u0435\u043d", Tab.TAB_W, mouseX, mouseY);
        this.tabButton(cursor += wide + gap, ty, narrow, "\u0428\u0430\u0445\u0442\u0430", Tab.TAB_M, mouseX, mouseY);
        this.tabButton(cursor += narrow + gap, ty, wide, "\u041e\u0431\u043b\u043e\u043c\u043a\u0438", Tab.TAB_D, mouseX, mouseY);
        if (bot.f3ref().isVip()) {
            this.vipBadge(cursor + wide - 1.0f, ty, 7.0f, veo.bold(4.5f));
        }
        this.tabButton(cursor += wide + gap, ty, tabW, "\u0411\u043e\u0442", Tab.BOT, mouseX, mouseY);
        this.tabButton(cursor += tabW + gap, ty, tabW, "\u0412\u0441\u0435", Tab.ALL, mouseX, mouseY);
        float by = ty + 16.0f + 4.0f;
        float bh = th - 16.0f - 4.0f;
        uut.round(this.ctx, tx, by, tw, bh, 7.0f, iov.card);
        switch (tab.ordinal()) {
            case 0: {
                this.renderChat(bot, tx, by, tw, bh, mouseX, mouseY);
                break;
            }
            case 1: {
                this.renderF0(bot, tx, by, tw, bh, mouseX, mouseY);
                break;
            }
            case 2: {
                this.renderF1(bot, tx, by, tw, bh, mouseX, mouseY);
                break;
            }
            case 3: {
                this.renderF2(bot, tx, by, tw, bh, mouseX, mouseY);
                break;
            }
            case 4: {
                this.renderF3(bot, tx, by, tw, bh, mouseX, mouseY);
                break;
            }
            case 5: {
                this.renderBotTab(bot, tx, by, tw, bh, mouseX, mouseY);
                break;
            }
            case 6: {
                this.renderAll(tx, by, tw, bh, mouseX, mouseY);
            }
        }
    }

    private void tabButton(float bx, float by, float bw, String label, Tab value, int mouseX, int mouseY) {
        boolean active = tab == value;
        boolean hover = BotScreen.hovered(mouseX, mouseY, bx, by, bw, 16.0f);
        uut.round(this.ctx, bx, by, bw, 16.0f, 5.0f, active ? BotScreen.accent(215) : (hover ? iov.fieldHover : iov.field));
        this.centered(BotScreen.medium(7.0f), label, bx + bw / 2.0f, by + 8.0f, active ? iov.onAccent() : BotScreen.text());
        this.zone(bx, by, bw, 16.0f, b -> {
            this.commitSettingFields();
            tab = value;
        });
    }

    private void renderChat(dtv bot, float cx, float cy, float cw, float ch, int mouseX, int mouseY) {
        float inputH = 16.0f;
        float logTop = cy + 4.0f;
        float logBottom = cy + ch - inputH - 8.0f;
        float logX = cx + 5.0f;
        float logW = cw - 10.0f;
        float lineH = 8.5f;
        if (this.chatCache == null || this.chatCache.bot != bot || this.chatCache.revision != bot.getChat().revision() || this.chatCache.width != logW) {
            this.chatCache = new ChatCache(bot, bot.getChat().revision(), logW, this.wrapChat(bot.getChat().lines(), logW));
        }
        List<List<Seg>> lines = this.chatCache.lines;
        float content = (float)lines.size() * lineH;
        float visible = logBottom - logTop;
        this.chatScroll = MathHelper.method_15363((float)this.chatScroll, (float)0.0f, (float)Math.max(0.0f, content - visible));
        uut.pushScissor(this.ctx, cx, logTop, cw, visible);
        float lineY = logBottom - lineH / 2.0f + this.chatScroll;
        for (int i = lines.size() - 1; i >= 0 && !(lineY < logTop - lineH); lineY -= lineH, --i) {
            if (!(lineY <= logBottom + lineH)) continue;
            this.drawSegments(lines.get(i), logX, lineY, 6.5f);
        }
        uut.popScissor(this.ctx);
        this.chatField.render(cx + 4.0f, cy + ch - inputH - 4.0f, cw - 8.0f, inputH, mouseX, mouseY);
    }

    private void renderF0(dtv bot, float ax, float ay, float aw, float ah, int mouseX, int mouseY) {
        mpq fE = bot.f0ref();
        vdn font = BotScreen.medium(6.5f);
        float inner = ax + 6.0f;
        float innerW = aw - 12.0f;
        boolean running = bot.f0Run();
        boolean canRun = bot.getPlayer() != null;
        this.button(inner, ay + 6.0f, innerW, 18.0f, (running ? "\u041e\u0441\u0442\u0430\u043d\u043e\u0432\u0438\u0442\u044c " : "\u0417\u0430\u043f\u0443\u0441\u0442\u0438\u0442\u044c ") + vup.e(), !running && canRun, mouseX, mouseY, b -> {
            this.commitSettingFields();
            bot.setF0(!running);
        });
        String state = running ? fE.getStateDescription() + "   \u0432\u0430\u0437: " + fE.getBrokenVases() : (canRun ? "\u043e\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d" : "\u0431\u043e\u0442 \u043d\u0435 \u0432 \u0438\u0433\u0440\u0435");
        this.text(font, BotScreen.trim(font, state, innerW), inner, ay + 32.0f, running ? BotScreen.text() : BotScreen.textDim());
        String stats = "\u0444\u0430\u0440\u043c " + BotScreen.duration(fE.getFarmMillis()) + "   \u0432\u0430\u0437 " + fE.getTotalVases() + "   \u043a\u0438\u0441\u0442\u0435\u0439 " + fE.getTotalBrushes() + (fE.getTotalSand() > 0 ? "   \u043f\u0435\u0441\u043a\u0430 " + fE.getTotalSand() : "");
        this.text(font, BotScreen.trim(font, stats, innerW), inner, ay + 43.0f, BotScreen.textDim());
        float rowY = ay + 52.0f;
        vmo[] settings = fE.botSettings();
        for (int i = 0; i < settings.length; ++i) {
            vmo setting = settings[i];
            if (!BotScreen.isVisible(setting)) continue;
            if (rowY + 18.0f > ay + ah - 4.0f) break;
            this.settingRow(fE::onBotSettingChanged, setting, i < F0_LABELS.length ? F0_LABELS[i] : setting.getName(), inner, rowY, innerW, mouseX, mouseY);
            rowY += 20.0f;
        }
        this.lootButton(fE.lootList(), inner, rowY + 2.0f, innerW, mouseX, mouseY);
        vdn tiny = BotScreen.medium(5.5f);
        this.text(tiny, BotScreen.trim(tiny, "\u0431\u0435\u0440\u0451\u0442 \u0442\u043e\u043b\u044c\u043a\u043e \u043e\u0442\u043c\u0435\u0447\u0435\u043d\u043d\u043e\u0435; \u0441\u043f\u0438\u0441\u043e\u043a \u043e\u0431\u0449\u0438\u0439 \u0434\u043b\u044f \u0432\u0441\u0435\u0445 \u0431\u043e\u0442\u043e\u0432 \u0438 \u0442\u0432\u043e\u0435\u0433\u043e " + vup.e(), innerW), inner, ay + ah - 7.0f, BotScreen.textDim());
    }

    private void lootButton(vlj list, float bx, float by, float bw, int mouseX, int mouseY) {
        this.button(bx, by, bw, 16.0f, "\u0421\u043f\u0438\u0441\u043e\u043a \u043b\u0443\u0442\u0430 (" + list.size() + " \u0438\u0437 " + ppu.entries().size() + ")", lootPicker, mouseX, mouseY, b -> {
            lootPicker = !lootPicker;
            this.pickerRow = 0;
        });
    }

    private void renderF1(dtv bot, float ax, float ay, float aw, float ah, int mouseX, int mouseY) {
        nxa fW = bot.f1ref();
        vdn font = BotScreen.medium(6.5f);
        float inner = ax + 6.0f;
        float innerW = aw - 12.0f;
        boolean running = bot.f1Run();
        boolean canRun = bot.getPlayer() != null;
        this.button(inner, ay + 6.0f, innerW, 18.0f, (running ? "\u041e\u0441\u0442\u0430\u043d\u043e\u0432\u0438\u0442\u044c " : "\u0417\u0430\u043f\u0443\u0441\u0442\u0438\u0442\u044c ") + vup.w(), !running && canRun, mouseX, mouseY, b -> {
            this.commitSettingFields();
            bot.setF1(!running);
        });
        String state = running ? (fW.queueNote().isEmpty() ? BotScreen.f1StateLabel(fW.getStateIndex()) : fW.queueNote()) + "   \u0441\u0443\u043d\u0434\u0443\u043a\u043e\u0432 " + fW.getTripChests() + "/" + fW.getMaxChests() : (!canRun ? "\u0431\u043e\u0442 \u043d\u0435 \u0432 \u0438\u0433\u0440\u0435" : (bot.f1Want() ? "\u0437\u0430\u043f\u0443\u0441\u0442\u0438\u0442\u0441\u044f \u043f\u043e\u0441\u043b\u0435 \u0432\u0445\u043e\u0434\u0430" : "\u043e\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d"));
        this.text(font, BotScreen.trim(font, state, innerW), inner, ay + 32.0f, running ? BotScreen.text() : BotScreen.textDim());
        String stats = "\u0444\u0430\u0440\u043c " + BotScreen.duration(fW.getFarmMillis()) + "   \u0441\u0443\u043d\u0434\u0443\u043a\u043e\u0432 " + fW.getTotalChests() + "   \u0437\u0430\u0445\u043e\u0434\u043e\u0432 " + fW.getTotalTrips() + "   \u043b\u0443\u0442 " + fW.getCurrentLootAnarchy();
        this.text(font, BotScreen.trim(font, stats, innerW), inner, ay + 43.0f, BotScreen.textDim());
        float rowY = ay + 52.0f;
        vmo[] settings = fW.botSettings();
        for (int i = 0; i < settings.length; ++i) {
            vmo setting = settings[i];
            if (!BotScreen.isVisible(setting)) continue;
            if (rowY + 18.0f > ay + ah - 4.0f) break;
            this.settingRow(fW::onBotSettingChanged, setting, i < F1_LABELS.length ? F1_LABELS[i] : setting.getName(), inner, rowY, innerW, mouseX, mouseY);
            rowY += 20.0f;
        }
        if (rowY + 18.0f <= ay + ah - 10.0f) {
            this.lootButton(fW.lootList(), inner, rowY + 2.0f, innerW, mouseX, mouseY);
        }
        vdn tiny = BotScreen.medium(5.5f);
        this.text(tiny, BotScreen.trim(tiny, "\u0431\u0435\u0440\u0451\u0442 \u0442\u043e\u043b\u044c\u043a\u043e \u043e\u0442\u043c\u0435\u0447\u0435\u043d\u043d\u043e\u0435; \u0441\u043f\u0438\u0441\u043e\u043a \u043e\u0431\u0449\u0438\u0439 \u0434\u043b\u044f \u0432\u0441\u0435\u0445 \u0431\u043e\u0442\u043e\u0432 \u0438 \u0442\u0432\u043e\u0435\u0433\u043e " + vup.w(), innerW), inner, ay + ah - 7.0f, BotScreen.textDim());
    }

    private void renderF2(dtv bot, float ax, float ay, float aw, float ah, int mouseX, int mouseY) {
        nfl fM = bot.f2ref();
        vdn font = BotScreen.medium(6.5f);
        float inner = ax + 6.0f;
        float innerW = aw - 12.0f;
        boolean running = bot.f2Run();
        boolean canRun = bot.getPlayer() != null;
        this.button(inner, ay + 6.0f, innerW, 18.0f, (running ? "\u041e\u0441\u0442\u0430\u043d\u043e\u0432\u0438\u0442\u044c " : "\u0417\u0430\u043f\u0443\u0441\u0442\u0438\u0442\u044c ") + vup.m(), !running && canRun, mouseX, mouseY, b -> {
            this.commitSettingFields();
            bot.setF2(!running);
        });
        String state = running ? BotScreen.mineStatus(bot) : (!canRun ? "\u0431\u043e\u0442 \u043d\u0435 \u0432 \u0438\u0433\u0440\u0435" : (bot.f2Want() ? "\u0437\u0430\u043f\u0443\u0441\u0442\u0438\u0442\u0441\u044f \u043f\u043e\u0441\u043b\u0435 \u0432\u0445\u043e\u0434\u0430" : "\u043e\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d"));
        this.text(font, BotScreen.trim(font, state, innerW), inner, ay + 32.0f, running ? BotScreen.text() : BotScreen.textDim());
        String note = fM.lastNote() == null || fM.lastNote().isEmpty() ? "" : fM.lastNote();
        String stats = "\u043d\u0430\u043a\u043e\u043f\u0430\u043d\u043e " + fM.mined() + (note.isEmpty() ? "" : "   " + note);
        this.text(font, BotScreen.trim(font, stats, innerW), inner, ay + 43.0f, BotScreen.textDim());
        float rowY = ay + 52.0f;
        vmo[] settings = fM.botSettings();
        int shown = 0;
        for (vmo setting : settings) {
            if (!BotScreen.isVisible(setting) || shown++ < this.mineScroll) continue;
            if (rowY + 18.0f > ay + ah - 12.0f) break;
            this.settingRow(() -> {}, setting, wap.t(setting.getName()), inner, rowY, innerW, mouseX, mouseY);
            rowY += 20.0f;
        }
        vdn tiny = BotScreen.medium(5.5f);
        this.text(tiny, BotScreen.trim(tiny, "\u043a\u043e\u043b\u0435\u0441\u043e - \u043b\u0438\u0441\u0442\u0430\u0442\u044c; \u0440\u0443\u0434\u044b, \u043c\u0443\u0441\u043e\u0440 \u0438 \u043e\u0441\u0442\u0430\u043b\u044c\u043d\u043e\u0435 - \u043a\u0430\u043a \u0443 \u0442\u0432\u043e\u0435\u0433\u043e " + vup.m(), innerW), inner, ay + ah - 7.0f, BotScreen.textDim());
    }

    private void renderF3(dtv bot, float ax, float ay, float aw, float ah, int mouseX, int mouseY) {
        lqq farm = bot.f3ref();
        vdn font = BotScreen.medium(6.5f);
        float inner = ax + 6.0f;
        float innerW = aw - 12.0f;
        if (farm.isVip()) {
            float cx = ax + aw / 2.0f;
            float cy = ay + ah / 2.0f;
            float pulse = 0.5f + 0.5f * (float)Math.sin((double)System.nanoTime() / 4.5E8);
            uut.shadow(this.ctx, cx - 11.0f, cy - 37.0f, 22.0f, 22.0f, 11.0f, 6.0f, BotScreen.accent((int)(50.0f + 60.0f * pulse)));
            uut.round(this.ctx, cx - 11.0f, cy - 37.0f, 22.0f, 22.0f, 11.0f, iov.field);
            vjf.draw(this.ctx, vhz.CROWN, cx, cy - 26.0f, 12.0f, BotScreen.accent());
            vdn vipFont = veo.bold(6.0f);
            this.vipBadge(cx + (vipFont.width("VIP") + 11.0f) / 2.0f, cy - 6.0f, 11.0f, vipFont);
            vdn bold = BotScreen.semibold(7.5f);
            this.centered(bold, BotScreen.trim(bold, "\u0424\u0430\u0440\u043c \u043e\u0431\u043b\u043e\u043c\u043a\u043e\u0432 \u0434\u043e\u0441\u0442\u0443\u043f\u0435\u043d \u0442\u043e\u043b\u044c\u043a\u043e \u0441 VIP", innerW), cx, cy + 9.0f, BotScreen.text());
            this.centered(font, BotScreen.trim(font, "\u0437\u0430\u043f\u0443\u0441\u043a \u043d\u0430 \u0431\u043e\u0442\u0430\u0445 \u0437\u0430\u043a\u0440\u044b\u0442", innerW), cx, cy + 20.0f, BotScreen.textDim());
            return;
        }
        boolean running = bot.f3Run();
        boolean canRun = bot.getPlayer() != null;
        this.button(inner, ay + 6.0f, innerW, 18.0f, (running ? "\u041e\u0441\u0442\u0430\u043d\u043e\u0432\u0438\u0442\u044c" : "\u0417\u0430\u043f\u0443\u0441\u0442\u0438\u0442\u044c") + " \u0444\u0430\u0440\u043c \u043e\u0431\u043b\u043e\u043c\u043a\u043e\u0432", !running && canRun, mouseX, mouseY, b -> {
            this.commitSettingFields();
            bot.setF3(!running);
        });
        String state = running ? farm.status() : (!canRun ? "\u0431\u043e\u0442 \u043d\u0435 \u0432 \u0438\u0433\u0440\u0435" : (bot.f3Want() ? "\u0437\u0430\u043f\u0443\u0441\u0442\u0438\u0442\u0441\u044f \u043f\u043e\u0441\u043b\u0435 \u0432\u0445\u043e\u0434\u0430" : "\u043e\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d"));
        this.text(font, BotScreen.trim(font, state, innerW), inner, ay + 32.0f, running ? BotScreen.text() : BotScreen.textDim());
        String note = farm.lastNote() == null ? "" : farm.lastNote();
        String stats = "\u0434\u043e\u0431\u044b\u0442\u043e " + farm.mined() + "  \u00b7  \u0432\u0437\u0440\u044b\u0432\u043e\u0432 " + farm.blasts() + (note.isEmpty() ? "" : "   " + note);
        this.text(font, BotScreen.trim(font, stats, innerW), inner, ay + 43.0f, BotScreen.textDim());
        float rowY = ay + 52.0f;
        int shown = 0;
        for (vmo setting : farm.botSettings()) {
            if (!BotScreen.isVisible(setting) || shown++ < this.mineScroll) continue;
            if (rowY + 18.0f > ay + ah - 12.0f) break;
            this.settingRow(() -> {}, setting, wap.t(setting.getName()), inner, rowY, innerW, mouseX, mouseY);
            rowY += 20.0f;
        }
        vdn tiny = BotScreen.medium(5.5f);
        this.text(tiny, BotScreen.trim(tiny, "\u043a\u043e\u043b\u0435\u0441\u043e - \u043b\u0438\u0441\u0442\u0430\u0442\u044c; \u0441\u0443\u043d\u0434\u0443\u043a\u0438 \u043d\u0430 \u0441\u043a\u043b\u0430\u0434\u0435: \u0442\u0430\u0431\u043b\u0438\u0447\u043a\u0438 \u00ab\u0421\u0431\u0440\u043e\u0441\u00bb \u0438 \u00ab\u0420\u0435\u0441\u0443\u0440\u0441\u044b\u00bb", innerW), inner, ay + ah - 7.0f, BotScreen.textDim());
    }

    private static String mineStatus(dtv bot) {
        String status = bot.f2ref().status();
        return status == null ? "" : status;
    }

    static String f1StateLabel(int index) {
        return index >= 0 && index < F1_STATES.length ? F1_STATES[index] : "";
    }

    private static boolean isVisible(vmo setting) {
        BooleanSupplier condition = setting.visibleCondition();
        return condition == null || condition.getAsBoolean();
    }

    private void settingRow(Runnable changed, vmo setting, String label, float rx, float ry, float rw, int mouseX, int mouseY) {
        vdn font = BotScreen.medium(7.0f);
        float cy = ry + 8.0f;
        if (setting instanceof vkl) {
            vkl bool = (vkl)setting;
            this.text(font, BotScreen.trim(font, label, rw - 30.0f), rx, cy, BotScreen.textDim());
            this.toggle(rx + rw - 20.0f, cy - 5.5f, bool.get(), mouseX, mouseY, b -> {
                bool.set(!bool.get());
                changed.run();
            });
        } else if (setting instanceof vmc) {
            vmc number = (vmc)setting;
            String value = number.display();
            vdn valueFont = BotScreen.semibold(6.5f);
            float boxW = Math.max(44.0f, valueFont.width(value) + 30.0f);
            this.text(font, BotScreen.trim(font, label, rw - boxW - 6.0f), rx, cy, BotScreen.textDim());
            float sx = rx + rw - boxW;
            uut.round(this.ctx, sx, cy - 7.0f, boxW, 14.0f, 4.5f, iov.field);
            vdn sign = BotScreen.medium(8.0f);
            this.centered(sign, "-", sx + 6.5f, cy, BotScreen.textDim());
            this.centered(sign, "+", sx + boxW - 6.5f, cy, BotScreen.textDim());
            this.centered(valueFont, value, sx + boxW / 2.0f, cy, BotScreen.text());
            this.zone(sx, cy - 7.0f, 13.0f, 14.0f, b -> {
                number.set(number.get() - number.getStep());
                changed.run();
            });
            this.zone(sx + boxW - 13.0f, cy - 7.0f, 13.0f, 14.0f, b -> {
                number.set(number.get() + number.getStep());
                changed.run();
            });
        } else if (setting instanceof vmu) {
            vmu textSetting = (vmu)setting;
            float labelW = Math.min(62.0f, font.width(label) + 4.0f);
            this.text(font, BotScreen.trim(font, label, labelW), rx, cy, BotScreen.textDim());
            Field field = this.settingFields.computeIfAbsent(textSetting, s -> {
                Field created = new Field(64, "");
                created.setText(s.get());
                created.onCommit = value -> {
                    s.set(value.trim());
                    changed.run();
                };
                return created;
            });
            if (field != this.focused && !field.text.equals(textSetting.get())) {
                field.setText(textSetting.get());
            }
            field.render(rx + labelW + 4.0f, ry, rw - labelW - 4.0f, 16.0f, mouseX, mouseY);
        } else if (setting instanceof vlv) {
            vlv mode = (vlv)setting;
            this.text(font, BotScreen.trim(font, label, rw - 70.0f), rx, cy, BotScreen.textDim());
            String value = mode.get() == null ? "-" : wap.value(mode.get());
            float bw = Math.max(40.0f, BotScreen.medium(6.5f).width(value) + 14.0f);
            this.smallButton(rx + rw - bw, cy - 7.0f, bw, 14.0f, value, mouseX, mouseY, b -> {
                if (mode.getModes().isEmpty()) {
                    return;
                }
                mode.cycle();
                changed.run();
            });
        }
    }

    private static vlj openPicker(dtv bot) {
        if (!lootPicker || bot == null) {
            return null;
        }
        return tab == Tab.TAB_E ? bot.f0ref().lootList() : (tab == Tab.TAB_W ? bot.f1ref().lootList() : null);
    }

    private void renderPicker(vlj pick, float px, float py, float pw, float ph, int mouseX, int mouseY) {
        uut.round(this.ctx, px, py, pw, ph, 7.0f, iov.card);
        vdn bold = BotScreen.semibold(7.5f);
        vdn font = BotScreen.medium(6.5f);
        this.text(bold, tab == Tab.TAB_W ? "\u0427\u0442\u043e \u043b\u0443\u0442\u0430\u0442\u044c: " + vup.w() : "\u0427\u0442\u043e \u043b\u0443\u0442\u0430\u0442\u044c: " + vup.e(), px + 7.0f, py + 9.0f, BotScreen.text());
        this.smallButton(px + pw - 50.0f, py + 3.0f, 44.0f, 12.0f, "\u0433\u043e\u0442\u043e\u0432\u043e", mouseX, mouseY, b -> {
            lootPicker = false;
            ConfigManager.autoSaveLater();
        });
        List<ppn> entries = ppu.entries();
        int cols = 10;
        float gx = px + (pw - (float)cols * 20.0f) / 2.0f;
        float gy = py + 19.0f;
        float footer = 34.0f;
        int visibleRows = Math.max(1, (int)((ph - 19.0f - footer) / 20.0f));
        int rows = (entries.size() + cols - 1) / cols;
        this.pickerRow = MathHelper.method_15340((int)this.pickerRow, (int)0, (int)Math.max(0, rows - visibleRows));
        int first = this.pickerRow * cols;
        int last = Math.min(entries.size(), (this.pickerRow + visibleRows) * cols);
        for (int i = first; i < last; ++i) {
            ppn entry = entries.get(i);
            int local = i - first;
            float sx = gx + (float)(local % cols) * 20.0f;
            float sy = gy + (float)(local / cols) * 20.0f;
            boolean chosen = pick.contains(entry.id);
            boolean hover = BotScreen.hovered(mouseX, mouseY, sx, sy, 19.0f, 19.0f);
            if (chosen) {
                uut.round(this.ctx, sx - 1.0f, sy - 1.0f, 21.0f, 21.0f, 5.0f, BotScreen.accent(230));
                uut.round(this.ctx, sx, sy, 19.0f, 19.0f, 4.5f, ujt.withAlpha(iov.window, 220));
            }
            int fill = hover ? iov.fieldHover : (chosen ? ujt.lerp(iov.field, iov.accent(), 0.28f) : ujt.shade(iov.field, 0.6f));
            uut.round(this.ctx, sx, sy, 19.0f, 19.0f, 4.5f, fill);
            ItemStack icon = entry.icon();
            this.ctx.method_51427(icon, Math.round(sx + 1.5f), Math.round(sy + 1.5f));
            if (chosen) {
                uut.round(this.ctx, sx + 20.0f - 8.0f, sy + 1.5f, 5.5f, 5.5f, 2.75f, BotScreen.accent());
            }
            if (hover) {
                this.hoveredStack = icon;
            }
            this.zone(sx, sy, 19.0f, 19.0f, b -> pick.toggle(entry.id));
        }
        vdn tiny = BotScreen.medium(5.5f);
        if (rows > visibleRows) {
            String pages = this.pickerRow + 1 + "-" + Math.min(rows, this.pickerRow + visibleRows) + " \u0438\u0437 " + rows + " \u0440\u044f\u0434\u043e\u0432, \u043a\u043e\u043b\u0435\u0441\u043e";
            this.text(tiny, pages, px + 7.0f, py + ph - footer + 2.0f, BotScreen.textDim());
        }
        float fy = py + ph - 20.0f;
        this.text(font, "\u043e\u0442\u043c\u0435\u0447\u0435\u043d\u043e " + pick.size() + " \u0438\u0437 " + entries.size(), px + 7.0f, fy + 8.0f, BotScreen.textDim());
        float bw = 38.0f;
        float bx = px + pw - 6.0f - bw * 3.0f - 4.0f;
        this.smallButton(bx, fy + 1.0f, bw, 14.0f, "\u0432\u0441\u0435", mouseX, mouseY, b -> {
            ArrayList<String> all = new ArrayList<String>();
            for (ppn e : entries) {
                all.add(e.id);
            }
            pick.set(all);
        });
        this.smallButton(bx + bw + 2.0f, fy + 1.0f, bw, 14.0f, "\u0441\u043d\u044f\u0442\u044c", mouseX, mouseY, b -> pick.clear());
        this.smallButton(bx + bw * 2.0f + 4.0f, fy + 1.0f, bw, 14.0f, "\u0441\u0431\u0440\u043e\u0441", mouseX, mouseY, b -> pick.reset());
    }

    private void renderBotTab(dtv bot, float bx, float by, float bw, float bh, int mouseX, int mouseY) {
        vdn font = BotScreen.medium(7.0f);
        float inner = bx + 6.0f;
        float innerW = bw - 12.0f;
        float rowY = by + 6.0f;
        this.text(font, "\u0410\u0432\u0442\u043e\u043f\u0435\u0440\u0435\u043f\u043e\u0434\u043a\u043b\u044e\u0447\u0435\u043d\u0438\u0435", inner, rowY + 8.0f, BotScreen.textDim());
        this.toggle(inner + innerW - 20.0f, rowY + 2.5f, bot.isAutoReconnect(), mouseX, mouseY, b -> bot.setAutoReconnect(!bot.isAutoReconnect()));
        this.text(font, bot.hasLoginCommand() ? "/login \u0437\u0430\u043f\u043e\u043c\u043d\u0435\u043d, \u0441\u043e\u0445\u0440\u0430\u043d\u0451\u043d" : "/login \u043d\u0435 \u0437\u0430\u043f\u043e\u043c\u043d\u0435\u043d", inner, (rowY += 20.0f) + 8.0f, BotScreen.textDim());
        if (bot.hasLoginCommand()) {
            this.smallButton(inner + innerW - 44.0f, rowY + 1.0f, 44.0f, 14.0f, "\u0437\u0430\u0431\u044b\u0442\u044c", mouseX, mouseY, b -> bot.forgetLogin());
        }
        this.text(font, "\u041f\u0440\u043e\u0433\u0440\u0443\u0437\u043a\u0430 \u0447\u0430\u043d\u043a\u043e\u0432", inner, (rowY += 20.0f) + 8.0f, BotScreen.textDim());
        float sx = inner + innerW - 44.0f;
        uut.round(this.ctx, sx, rowY + 1.0f, 44.0f, 14.0f, 4.5f, iov.field);
        vdn sign = BotScreen.medium(8.0f);
        this.centered(sign, "-", sx + 6.5f, rowY + 8.0f, BotScreen.textDim());
        this.centered(sign, "+", sx + 37.5f, rowY + 8.0f, BotScreen.textDim());
        this.centered(BotScreen.semibold(6.5f), String.valueOf(egq.get().getViewDistance()), sx + 22.0f, rowY + 8.0f, BotScreen.text());
        this.zone(sx, rowY + 1.0f, 13.0f, 14.0f, b -> this.changeViewDistance(-1));
        this.zone(sx + 31.0f, rowY + 1.0f, 13.0f, 14.0f, b -> this.changeViewDistance(1));
        this.text(font, "\u0410\u0434\u0440\u0435\u0441", inner, (rowY += 20.0f) + 8.0f, BotScreen.textDim());
        this.botAddressField.render(inner + 32.0f, rowY, innerW - 32.0f, 16.0f, mouseX, mouseY);
        boolean connected = bot.getStatus() != dts.OFFLINE && bot.getStatus() != dts.FAILED;
        float half = (innerW - 4.0f) / 2.0f;
        this.button(inner, rowY += 24.0f, half, 16.0f, connected ? "\u041e\u0442\u043a\u043b\u044e\u0447\u0438\u0442\u044c" : "\u041f\u043e\u0434\u043a\u043b\u044e\u0447\u0438\u0442\u044c", false, mouseX, mouseY, b -> {
            this.commitSettingFields();
            if (connected) {
                bot.disconnect();
            } else {
                bot.connect();
            }
        });
        this.button(inner + half + 4.0f, rowY, half, 16.0f, "\u041f\u0435\u0440\u0435\u043f\u043e\u0434\u043a\u043b\u044e\u0447\u0438\u0442\u044c", false, mouseX, mouseY, b -> {
            this.commitSettingFields();
            bot.disconnect();
            bot.connect();
        });
        this.button(inner, rowY += 20.0f, half, 16.0f, "\u0412\u043e\u0437\u0440\u043e\u0434\u0438\u0442\u044c", false, mouseX, mouseY, b -> bot.respawn());
        this.button(inner + half + 4.0f, rowY, half, 16.0f, "\u0417\u0430\u043a\u0440\u044b\u0442\u044c \u044d\u043a\u0440\u0430\u043d", false, mouseX, mouseY, b -> bot.closeScreen());
        this.button(inner, rowY += 20.0f, innerW, 16.0f, "\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u0431\u043e\u0442\u0430", false, mouseX, mouseY, b -> {
            egq.get().remove(bot);
            selected = egq.get().getBots().isEmpty() ? null : egq.get().getBots().get(0);
            this.syncBotFields();
        });
        vdn small = BotScreen.medium(6.5f);
        String stats = String.format(Locale.ROOT, "\u0442\u0438\u043a %.2f \u043c\u0441   \u043e\u0447\u0435\u0440\u0435\u0434\u044c %d   \u043f\u0438\u043d\u0433 %s", Float.valueOf(bot.getTickMillis()), bot.getPendingPackets(), bot.getPing() < 0 ? "-" : bot.getPing() + " \u043c\u0441");
        this.text(small, BotScreen.trim(small, stats, innerW), inner, rowY += 26.0f, BotScreen.textDim());
        this.text(small, BotScreen.trim(small, "\u0441\u0442\u0430\u0442\u0443\u0441: " + bot.getStatusText(), innerW), inner, rowY + 10.0f, BotScreen.textDim());
    }

    private void renderAll(float ax, float ay, float aw, float ah, int mouseX, int mouseY) {
        vdn font = BotScreen.medium(6.5f);
        vdn bold = BotScreen.semibold(6.5f);
        vdn title = BotScreen.semibold(7.5f);
        float inner = ax + 6.0f;
        float innerW = aw - 12.0f;
        List<dtv> bots = egq.get().getBots();
        long farm = 0L;
        int vases = 0;
        int brushes = 0;
        int chests = 0;
        int online = 0;
        int running = 0;
        for (dtv bot : bots) {
            mpq fE = bot.f0ref();
            nxa fW = bot.f1ref();
            farm += fE.getFarmMillis() + fW.getFarmMillis();
            vases += fE.getTotalVases();
            brushes += fE.getTotalBrushes();
            chests += fW.getTotalChests();
            if (bot.getStatus() == dts.ONLINE) {
                ++online;
            }
            if (!bot.isActive()) continue;
            ++running;
        }
        float rowY = ay + 6.0f;
        this.text(title, "\u0412\u0441\u0435 \u0431\u043e\u0442\u044b", inner, rowY + 5.0f, BotScreen.text());
        this.text(font, "\u0444\u0430\u0440\u043c\u044f\u0442 " + running + " \u0438\u0437 " + online, inner + title.width("\u0412\u0441\u0435 \u0431\u043e\u0442\u044b") + 6.0f, rowY + 5.0f, BotScreen.textDim());
        this.smallButton(inner + innerW - 34.0f, rowY - 1.0f, 34.0f, 12.0f, "\u0441\u0431\u0440\u043e\u0441", mouseX, mouseY, b -> egq.get().resetFarmStats());
        if (online < bots.size()) {
            this.smallButton(inner + innerW - 34.0f - 4.0f - 52.0f, rowY - 1.0f, 52.0f, 12.0f, "\u0432\u043e\u0439\u0442\u0438 \u0432\u0441\u0435\u043c", mouseX, mouseY, b -> {
                int count = egq.get().connectAll();
                this.notice(count == 0 ? "\u0432\u0441\u0435 \u0443\u0436\u0435 \u0432 \u0438\u0433\u0440\u0435 \u0438\u043b\u0438 \u0437\u0430\u0445\u043e\u0434\u044f\u0442" : "\u043f\u043e \u043e\u0447\u0435\u0440\u0435\u0434\u0438 \u0437\u0430\u0445\u043e\u0434\u044f\u0442: " + count);
            });
        }
        float half = (innerW - 4.0f) / 2.0f;
        this.statRow("\u0412\u0440\u0435\u043c\u044f \u0444\u0430\u0440\u043c\u0430", BotScreen.duration(farm), inner, rowY += 16.0f, half);
        this.statRow("\u0421\u0443\u043d\u0434\u0443\u043a\u043e\u0432", String.valueOf(chests), inner + half + 4.0f, rowY, half);
        this.statRow("\u0412\u0430\u0437", String.valueOf(vases), inner, rowY += 11.0f, half);
        this.statRow("\u041a\u0438\u0441\u0442\u0435\u0439", String.valueOf(brushes), inner + half + 4.0f, rowY, half);
        float third = (innerW - 8.0f) / 3.0f;
        this.button(inner, rowY += 13.0f, third, 16.0f, vup.e() + " \u0432\u0441\u0435\u043c", true, mouseX, mouseY, b -> {
            this.commitSettingFields();
            this.notice("\u0437\u0430\u043f\u0443\u0441\u043a \u0443 " + egq.get().setF0All(true) + " \u0431\u043e\u0442\u043e\u0432, \u043f\u043e \u043e\u0447\u0435\u0440\u0435\u0434\u0438");
        });
        this.button(inner + third + 4.0f, rowY, third, 16.0f, "\u0412\u0430\u0440\u0434\u0435\u043d \u0432\u0441\u0435\u043c", true, mouseX, mouseY, b -> {
            this.commitSettingFields();
            this.notice(vup.w() + " \u0443 " + egq.get().setF1All(true) + " \u0431\u043e\u0442\u043e\u0432, \u0430\u043d\u0430\u0440\u0445\u0438\u0438 \u043b\u0443\u0442\u0430 \u0432\u0440\u0430\u0437\u043d\u043e\u0431\u043e\u0439");
        });
        this.button(inner + third * 2.0f + 8.0f, rowY, third, 16.0f, "\u0428\u0430\u0445\u0442\u0430 \u0432\u0441\u0435\u043c", true, mouseX, mouseY, b -> {
            this.commitSettingFields();
            this.notice(vup.m() + " \u0443 " + egq.get().setF2All(true) + " \u0431\u043e\u0442\u043e\u0432, \u043f\u043e \u043e\u0447\u0435\u0440\u0435\u0434\u0438");
        });
        float half2 = (innerW - 4.0f) / 2.0f;
        lqq farmer = lqq.get();
        boolean farmerVip = farmer == null || farmer.isVip();
        this.button(inner, rowY += 19.0f, half2, 16.0f, "\u041e\u0431\u043b\u043e\u043c\u043a\u0438 \u0432\u0441\u0435\u043c", !farmerVip, mouseX, mouseY, b -> {
            this.commitSettingFields();
            this.notice(farmerVip ? "\u0444\u0430\u0440\u043c \u043e\u0431\u043b\u043e\u043c\u043a\u043e\u0432 \u0434\u043e\u0441\u0442\u0443\u043f\u0435\u043d \u0442\u043e\u043b\u044c\u043a\u043e \u0441 VIP" : "\u0444\u0430\u0440\u043c \u043e\u0431\u043b\u043e\u043c\u043a\u043e\u0432 \u0443 " + egq.get().setF3All(true) + " \u0431\u043e\u0442\u043e\u0432, \u043f\u043e \u043e\u0447\u0435\u0440\u0435\u0434\u0438");
        });
        if (farmerVip) {
            this.vipBadge(inner + half2 - 1.0f, rowY, 7.0f, veo.bold(4.5f));
        }
        this.button(inner + half2 + 4.0f, rowY, half2, 16.0f, "\u0421\u0442\u043e\u043f \u0432\u0441\u0435\u043c", false, mouseX, mouseY, b -> this.notice("\u043e\u0441\u0442\u0430\u043d\u043e\u0432\u043a\u0430 \u0443 " + egq.get().stopAll() + " \u0431\u043e\u0442\u043e\u0432"));
        rowY += 22.0f;
        float fieldY = ay + ah - 20.0f;
        float listBottom = fieldY - 12.0f;
        long since = egq.get().getLastBroadcast();
        boolean replies = since > 0L && System.currentTimeMillis() - since < 30000L;
        int shown = 0;
        for (dtv bot : bots) {
            boolean target;
            if (rowY + 10.0f > listBottom) {
                this.text(font, "\u0438 \u0435\u0449\u0451 " + (bots.size() - shown), inner, rowY + 4.0f, BotScreen.textDim());
                break;
            }
            float cy = rowY + 5.0f;
            uut.round(this.ctx, inner, cy - 2.5f, 5.0f, 5.0f, 2.0f, BotScreen.statusColor(bot.getStatus()));
            String name = BotScreen.trim(bold, bot.getName(), innerW * 0.45f);
            this.text(bold, name, inner + 8.0f, cy, BotScreen.text());
            float restX = inner + 8.0f + bold.width(name) + 6.0f;
            float restW = inner + innerW - restX;
            boolean bl = target = replies && egq.get().wasBroadcastTarget(bot);
            if (bot.getStatus() == dts.ONLINE && bot.getCaptcha().isPresent()) {
                this.text(font, "\u043a\u0430\u043f\u0447\u0430", restX, cy, -1526966);
            } else if (target && bot.getLastSent() < since) {
                this.text(font, "\u0432 \u043e\u0447\u0435\u0440\u0435\u0434\u0438", restX, cy, BotScreen.textDim());
            } else if (target) {
                Text reply = bot.replyToLastSent();
                if (reply != null) {
                    this.styled(reply, restX, cy, 6.0f, restW);
                } else {
                    this.text(font, "\u043e\u0442\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u043e", restX, cy, BotScreen.textDim());
                }
            } else if (bot.f2Run()) {
                line = "\u0448\u0430\u0445\u0442\u0430  \u00b7  " + bot.f2ref().mined() + "  \u00b7  " + BotScreen.mineStatus(bot);
                this.text(font, BotScreen.trim(font, line, restW), restX, cy, BotScreen.textDim());
            } else if (bot.f3Run()) {
                line = "\u043e\u0431\u043b\u043e\u043c\u043a\u0438  \u00b7  " + bot.f3ref().mined() + "  \u00b7  " + bot.f3ref().status();
                this.text(font, BotScreen.trim(font, line, restW), restX, cy, BotScreen.textDim());
            } else if (bot.f1Run() || bot.f1ref().getTotalChests() > 0) {
                nxa fW = bot.f1ref();
                line = fW.getCurrentLootAnarchy() + "  \u00b7  " + BotScreen.duration(fW.getFarmMillis()) + "  \u00b7  " + fW.getTotalChests() + " \u0441\u0443\u043d\u0434." + (fW.isEnabled() ? "  \u00b7  " + BotScreen.f1StateLabel(fW.getStateIndex()) : "");
                this.text(font, BotScreen.trim(font, line, restW), restX, cy, BotScreen.textDim());
            } else {
                mpq fE = bot.f0ref();
                line = BotScreen.duration(fE.getFarmMillis()) + "  \u00b7  " + fE.getTotalVases() + " \u0432\u0430\u0437" + (fE.getTotalBrushes() > 0 ? "  \u00b7  " + fE.getTotalBrushes() + " \u043a\u0438\u0441\u0442." : "");
                this.text(font, BotScreen.trim(font, line, restW), restX, cy, BotScreen.textDim());
            }
            this.zone(inner, rowY, innerW, 10.0f, b -> {
                selected = bot;
                this.chatScroll = 0.0f;
                this.syncBotFields();
            });
            rowY += 11.0f;
            ++shown;
        }
        boolean fresh = this.allNotice != null && System.currentTimeMillis() - this.allNoticeTime < 5000L;
        String hint = fresh ? this.allNotice : "Enter - \u0432\u0441\u0435\u043c \u0432 \u0438\u0433\u0440\u0435, \u043f\u043e \u043e\u0447\u0435\u0440\u0435\u0434\u0438";
        vdn tiny = BotScreen.medium(5.5f);
        this.text(tiny, BotScreen.trim(tiny, hint, innerW), inner, fieldY - 6.0f, fresh ? BotScreen.text() : BotScreen.textDim());
        this.broadcastField.render(ax + 4.0f, fieldY, aw - 8.0f, 16.0f, mouseX, mouseY);
    }

    private void statRow(String label, String value, float rx, float ry, float rw) {
        vdn font = BotScreen.medium(6.5f);
        vdn bold = BotScreen.semibold(6.5f);
        float cy = ry + 5.0f;
        this.text(font, label, rx, cy, BotScreen.textDim());
        this.text(bold, value, rx + rw - bold.width(value), cy, BotScreen.text());
    }

    private void notice(String message) {
        this.allNotice = message;
        this.allNoticeTime = System.currentTimeMillis();
    }

    private void broadcast() {
        String message = this.broadcastField.text.trim();
        if (message.isEmpty()) {
            return;
        }
        int count = egq.get().broadcast(message);
        this.notice(count == 0 ? "\u043d\u0438\u043a\u043e\u0433\u043e \u043d\u0435\u0442 \u0432 \u0438\u0433\u0440\u0435" : "\"" + message + "\" - " + count + " " + BotScreen.bots(count) + ", \u043f\u043e \u043e\u0447\u0435\u0440\u0435\u0434\u0438");
        this.remember(message);
        this.broadcastField.setText("");
        this.historyIndex = -1;
    }

    private static String bots(int count) {
        int mod10 = count % 10;
        int mod100 = count % 100;
        if (mod10 == 1 && mod100 != 11) {
            return "\u0431\u043e\u0442\u0443";
        }
        return "\u0431\u043e\u0442\u0430\u043c";
    }

    private static String duration(long millis) {
        long seconds = Math.max(0L, millis / 1000L);
        long hours = seconds / 3600L;
        long minutes = seconds / 60L % 60L;
        if (hours > 0L) {
            return hours + " \u0447 " + minutes + " \u043c\u0438\u043d";
        }
        if (minutes > 0L) {
            return minutes + " \u043c\u0438\u043d " + seconds % 60L + " \u0441";
        }
        return seconds + " \u0441";
    }

    private void changeViewDistance(int delta) {
        egq.get().setViewDistance(egq.get().getViewDistance() + delta);
        for (dtv bot : egq.get().getBots()) {
            bot.syncOptionsLive();
        }
    }

    private void button(float bx, float by, float bw, float bh, String label, boolean primary, int mouseX, int mouseY, IntConsumer action) {
        boolean hover = BotScreen.hovered(mouseX, mouseY, bx, by, bw, bh);
        vdn font = BotScreen.medium(7.0f);
        if (primary) {
            uut.round(this.ctx, bx, by, bw, bh, 5.0f, BotScreen.accent(hover ? 255 : 220));
            this.centered(font, label, bx + bw / 2.0f, by + bh / 2.0f, iov.onAccent());
        } else {
            uut.round(this.ctx, bx, by, bw, bh, 5.0f, hover ? iov.cardHover : iov.field);
            this.centered(font, label, bx + bw / 2.0f, by + bh / 2.0f, BotScreen.text());
        }
        this.zone(bx, by, bw, bh, action);
    }

    private void vipBadge(float right, float top, float height, vdn font) {
        float bw = font.width("VIP") + height;
        float bx = right - bw;
        float by = top - height / 2.0f;
        float r = height / 2.0f;
        uut.shadow(this.ctx, bx, by, bw, height, r, 2.5f, BotScreen.accent(110));
        uut.gradientH(this.ctx, bx, by, bw, height, r, iov.accent(), iov.accent2());
        this.centered(font, "VIP", bx + bw / 2.0f, by + height / 2.0f, iov.onAccent());
    }

    private void smallButton(float bx, float by, float bw, float bh, String label, int mouseX, int mouseY, IntConsumer action) {
        boolean hover = BotScreen.hovered(mouseX, mouseY, bx, by, bw, bh);
        uut.round(this.ctx, bx, by, bw, bh, 4.0f, hover ? iov.fieldHover : iov.field);
        this.centered(BotScreen.medium(6.5f), label, bx + bw / 2.0f, by + bh / 2.0f, BotScreen.text());
        this.zone(bx, by, bw, bh, action);
    }

    private void chip(float bx, float by, String label, boolean active, int mouseX, int mouseY, IntConsumer action) {
        vdn font = BotScreen.medium(6.0f);
        float bw = font.width(label) + 10.0f;
        boolean hover = BotScreen.hovered(mouseX, mouseY, bx, by, bw, 12.0f);
        uut.round(this.ctx, bx, by, bw, 12.0f, 4.0f, active ? BotScreen.accent(220) : (hover ? 0x28FFFFFF : 0x16FFFFFF));
        this.centered(font, label, bx + bw / 2.0f, by + 6.0f, active ? iov.onAccent() : -1644306);
        this.zone(bx, by, bw, 12.0f, action);
    }

    private void toggle(float tx, float ty, boolean value, int mouseX, int mouseY, IntConsumer action) {
        boolean hover = BotScreen.hovered(mouseX, mouseY, tx - 4.0f, ty - 3.0f, 28.0f, 17.0f);
        int track = value ? BotScreen.accent(245) : (hover ? iov.fieldHover : iov.track);
        int knob = value ? iov.onAccent() : iov.knob;
        uut.round(this.ctx, tx, ty, 20.0f, 11.0f, 4.625f, track);
        uut.round(this.ctx, tx + 1.5f + (value ? 9.0f : 0.0f), ty + 1.5f, 8.0f, 8.0f, 3.125f, knob);
        this.zone(tx - 4.0f, ty - 3.0f, 28.0f, 17.0f, action);
    }

    private void zone(float zx, float zy, float zw, float zh, IntConsumer action) {
        this.zones.add(new Zone(zx, zy, zw, zh, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, action));
    }

    private void zoneClip(float zx, float zy, float zw, float zh, float clipTop, float clipBottom, IntConsumer action) {
        this.zones.add(new Zone(zx, zy, zw, zh, clipTop, clipBottom, action));
    }

    private void setControl(boolean on) {
        this.control = on;
        this.keySprint = false;
        this.keySneak = false;
        this.keyJump = false;
        this.keyRight = false;
        this.keyLeft = false;
        this.keyBack = false;
        this.keyForward = false;
        this.mouseUse = false;
        this.mouseAttack = false;
        this.rotating = false;
        for (dtv bot : egq.get().getBots()) {
            bot.getControl().setActive(on && bot == selected);
        }
    }

    private void syncBotFields() {
        this.settingFields.clear();
        this.botAddressField.setText(selected == null ? "" : selected.getAddress());
        this.botAddressField.onCommit = value -> {
            if (selected != null && !value.isBlank()) {
                selected.setAddress(value.trim());
            }
        };
        this.chatField.onCommit = null;
        this.chatCache = null;
        if (this.control) {
            this.setControl(true);
        }
    }

    private void commitSettingFields() {
        if (this.focused != null) {
            this.focused.commit();
        }
    }

    public boolean method_25402(Click click, boolean doubled) {
        double mouseX = click.comp_4798() / (double)this.scale;
        double mouseY = click.comp_4799() / (double)this.scale;
        int button = click.method_74245();
        Field previous = this.focused;
        this.focused = null;
        for (Field field : this.allFields()) {
            if (!field.visible || !BotScreen.hovered(mouseX, mouseY, field.x, field.y, field.w, field.h)) continue;
            this.focused = field;
            field.cursor = field.text.length();
            break;
        }
        if (previous != null && previous != this.focused) {
            previous.commit();
        }
        if (this.focused != null) {
            return true;
        }
        if (this.control && this.viewShown && selected != null && BotScreen.hovered(mouseX, mouseY, this.viewX, this.viewY + 16.0f, this.viewW, this.viewH - 16.0f)) {
            if (button == 0) {
                this.mouseAttack = true;
            } else if (button == 1) {
                this.mouseUse = true;
            } else if (button == 2) {
                this.rotating = true;
            }
            selected.getControl().setMouse(this.mouseAttack, this.mouseUse);
            return true;
        }
        for (int i = this.zones.size() - 1; i >= 0; --i) {
            Zone zone = this.zones.get(i);
            if (!zone.contains(mouseX, mouseY)) continue;
            zone.action.accept(button);
            return true;
        }
        if (BotScreen.hovered(mouseX, mouseY, this.x, this.y, 600.0f, 20.0f)) {
            this.dragging = true;
            this.dragX = mouseX - (double)posX;
            this.dragY = mouseY - (double)posY;
            return true;
        }
        return BotScreen.hovered(mouseX, mouseY, this.x, this.y, 600.0f, 318.0f) || super.method_25402(click, doubled);
    }

    public boolean method_25406(Click click) {
        int button = click.method_74245();
        this.dragging = false;
        if (button == 2) {
            this.rotating = false;
        }
        if (this.control && selected != null && (button == 0 || button == 1)) {
            if (button == 0) {
                this.mouseAttack = false;
            } else {
                this.mouseUse = false;
            }
            selected.getControl().setMouse(this.mouseAttack, this.mouseUse);
        }
        return super.method_25406(click);
    }

    public boolean method_25403(Click click, double deltaX, double deltaY) {
        if (this.dragging) {
            posX = (float)(click.comp_4798() / (double)this.scale - this.dragX);
            posY = (float)(click.comp_4799() / (double)this.scale - this.dragY);
            return true;
        }
        if (this.rotating && this.control && selected != null && this.field_22787 != null) {
            double scale = this.field_22787.method_22683().method_4495();
            selected.getControl().addLook(deltaX * scale, deltaY * scale);
            return true;
        }
        return super.method_25403(click, deltaX, deltaY);
    }

    public boolean method_25401(double realX, double realY, double horizontalAmount, double verticalAmount) {
        double mouseX = realX / (double)this.scale;
        double mouseY = realY / (double)this.scale;
        float listRight = this.x + 6.0f + 146.0f;
        if (mouseX < (double)listRight && BotScreen.hovered(mouseX, mouseY, this.x, this.y, 600.0f, 318.0f)) {
            this.listScroll += (float)verticalAmount * 20.0f;
            return true;
        }
        float middle = this.x + 6.0f + 146.0f + 6.0f;
        if (BotScreen.openPicker(selected) != null && mouseX >= (double)middle && mouseX <= (double)(middle + 226.0f) && BotScreen.hovered(mouseX, mouseY, this.x, this.y, 600.0f, 318.0f)) {
            this.pickerRow -= (int)Math.signum(verticalAmount);
            return true;
        }
        if ((tab == Tab.TAB_M || tab == Tab.TAB_D) && mouseX > (double)(this.x + 6.0f + 146.0f + 6.0f + 226.0f) && selected != null) {
            int count = 0;
            for (vmo setting : tab == Tab.TAB_D ? selected.f3ref().botSettings() : selected.f2ref().botSettings()) {
                if (!BotScreen.isVisible(setting)) continue;
                ++count;
            }
            this.mineScroll = MathHelper.method_15340((int)(this.mineScroll - (int)Math.signum(verticalAmount)), (int)0, (int)Math.max(0, count - 5));
            return true;
        }
        if (tab == Tab.CHAT && mouseX > (double)(this.x + 6.0f + 146.0f + 6.0f + 226.0f)) {
            this.chatScroll += (float)verticalAmount * 17.0f;
            return true;
        }
        if (this.control && this.viewShown && selected != null && selected.getPlayer() != null && BotScreen.hovered(mouseX, mouseY, this.viewX, this.viewY, this.viewW, this.viewH)) {
            int slot = selected.getPlayer().method_31548().method_67532();
            slot = Math.floorMod(slot - (int)Math.signum(verticalAmount), 9);
            selected.selectSlot(slot);
            return true;
        }
        return super.method_25401(realX, realY, horizontalAmount, verticalAmount);
    }

    public boolean method_25404(KeyInput input) {
        boolean ctrl;
        int keyCode = input.comp_4795();
        int modifiers = input.comp_4797();
        if (this.focused != null) {
            if (keyCode == 256) {
                this.focused.commit();
                this.focused = null;
                return true;
            }
            if (keyCode == 257 || keyCode == 335) {
                this.submit(this.focused);
                return true;
            }
            if (!(this.focused != this.chatField && this.focused != this.broadcastField || keyCode != 265 && keyCode != 264)) {
                this.browseHistory(this.focused, keyCode == 265 ? 1 : -1);
                return true;
            }
            this.focused.key(keyCode, modifiers);
            return true;
        }
        if (keyCode == 256) {
            this.method_25419();
            return true;
        }
        boolean bl = ctrl = (modifiers & 2) != 0;
        if (selected != null && selected.getPlayer() != null) {
            if (keyCode >= 49 && keyCode <= 57) {
                int index = keyCode - 49;
                if (this.hoveredSlot != null && this.hoveredHandler != null) {
                    selected.clickSlot(this.hoveredHandler.field_7763, this.hoveredHandler.field_7761.indexOf((Object)this.hoveredSlot), index, SlotActionType.field_7791);
                } else if (this.control) {
                    selected.selectSlot(index);
                }
                return true;
            }
            if (keyCode == 81) {
                if (this.hoveredSlot != null && this.hoveredHandler != null) {
                    selected.clickSlot(this.hoveredHandler.field_7763, this.hoveredHandler.field_7761.indexOf((Object)this.hoveredSlot), ctrl ? 1 : 0, SlotActionType.field_7795);
                    return true;
                }
                if (this.control) {
                    selected.dropSelected(ctrl);
                    return true;
                }
            }
            if (this.control && keyCode == 70) {
                selected.swapHands();
                return true;
            }
            if (this.control && this.movementKey(input, true)) {
                return true;
            }
        }
        if ((keyCode == 84 || keyCode == 47) && selected != null) {
            Field target;
            if (tab == Tab.ALL) {
                target = this.broadcastField;
            } else if (keyCode == 84 && selected.getCaptcha().isShown()) {
                target = this.captchaField;
            } else {
                tab = Tab.CHAT;
                target = this.chatField;
            }
            this.focused = target;
            if (keyCode == 47 && target.text.isEmpty()) {
                target.setText("/");
            }
            return true;
        }
        return super.method_25404(input);
    }

    public boolean method_16803(KeyInput input) {
        if (this.control && this.movementKey(input, false)) {
            return true;
        }
        return super.method_16803(input);
    }

    public boolean method_25400(CharInput input) {
        if (this.focused != null) {
            if (input.method_74227()) {
                for (char c : input.method_74226().toCharArray()) {
                    this.focused.type(c);
                }
            }
            return true;
        }
        return super.method_25400(input);
    }

    private boolean movementKey(KeyInput input, boolean down) {
        if (this.field_22787 == null) {
            return false;
        }
        GameOptions options = this.field_22787.field_1690;
        if (options.field_1894.method_1417(input)) {
            this.keyForward = down;
        } else if (options.field_1881.method_1417(input)) {
            this.keyBack = down;
        } else if (options.field_1913.method_1417(input)) {
            this.keyLeft = down;
        } else if (options.field_1849.method_1417(input)) {
            this.keyRight = down;
        } else if (options.field_1903.method_1417(input)) {
            this.keyJump = down;
        } else if (options.field_1832.method_1417(input)) {
            this.keySneak = down;
        } else if (options.field_1867.method_1417(input)) {
            this.keySprint = down;
        } else {
            return false;
        }
        return true;
    }

    private void submit(Field field) {
        if (field == this.chatField) {
            String message = this.chatField.text.trim();
            if (!message.isEmpty() && selected != null) {
                selected.sendChat(message);
                this.remember(message);
                this.chatScroll = 0.0f;
            }
            this.chatField.setText("");
            this.historyIndex = -1;
            return;
        }
        if (field == this.broadcastField) {
            this.broadcast();
            return;
        }
        if (field == this.captchaField) {
            this.submitCaptcha();
            return;
        }
        if (field == this.nickField || field == this.addressField) {
            this.addBot();
            return;
        }
        field.commit();
        this.focused = null;
    }

    private void remember(String message) {
        this.sentHistory.remove(message);
        this.sentHistory.add(0, message);
        if (this.sentHistory.size() > 50) {
            this.sentHistory.remove(this.sentHistory.size() - 1);
        }
    }

    private void browseHistory(Field field, int direction) {
        if (this.sentHistory.isEmpty()) {
            return;
        }
        this.historyIndex = MathHelper.method_15340((int)(this.historyIndex + direction), (int)-1, (int)(this.sentHistory.size() - 1));
        field.setText(this.historyIndex < 0 ? "" : this.sentHistory.get(this.historyIndex));
    }

    private List<Field> allFields() {
        ArrayList<Field> fields = new ArrayList<Field>();
        fields.add(this.nickField);
        fields.add(this.addressField);
        fields.add(this.chatField);
        fields.add(this.botAddressField);
        fields.add(this.broadcastField);
        fields.add(this.captchaField);
        fields.addAll(this.settingFields.values());
        return fields;
    }

    private List<List<Seg>> wrapChat(List<ech> source, float maxWidth) {
        vdn font = BotScreen.medium(6.5f);
        ArrayList<List<Seg>> out = new ArrayList<List<Seg>>();
        for (ech line : source) {
            int base = line.kind == ece.SYSTEM ? -6643542 : (line.kind == ece.OWN ? -4663041 : -1644306);
            List<Seg> segments = BotScreen.segments(line.text, base);
            ArrayList<Seg> current = new ArrayList<Seg>();
            float used = 0.0f;
            for (Seg seg : segments) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < seg.text.length(); ++i) {
                    char c = seg.text.charAt(i);
                    float cw = font.width(String.valueOf(c));
                    if (used + cw > maxWidth && used > 0.0f) {
                        if (builder.length() > 0) {
                            current.add(new Seg(builder.toString(), seg.color));
                            builder.setLength(0);
                        }
                        out.add(current);
                        current = new ArrayList();
                        used = 0.0f;
                    }
                    builder.append(c);
                    used += cw;
                }
                if (builder.length() <= 0) continue;
                current.add(new Seg(builder.toString(), seg.color));
            }
            out.add(current);
        }
        return out;
    }

    private static List<Seg> segments(Text text, int base) {
        ArrayList<Seg> out = new ArrayList<Seg>();
        text.method_27658((style, string) -> {
            TextColor color = style.method_10973();
            int styleColor = color == null ? base : 0xFF000000 | color.method_27716();
            BotScreen.legacy(string, styleColor, out);
            return Optional.empty();
        }, Style.field_24360);
        return out;
    }

    private static void legacy(String string, int start, List<Seg> out) {
        int color = start;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            if (c == '\u00a7' && i + 1 < string.length()) {
                char code = Character.toLowerCase(string.charAt(i + 1));
                int next = color;
                int skip = 1;
                if (code == 'x' && i + 13 < string.length()) {
                    StringBuilder hex = new StringBuilder();
                    for (int k = 0; k < 6; ++k) {
                        hex.append(string.charAt(i + 3 + k * 2));
                    }
                    try {
                        next = 0xFF000000 | Integer.parseInt(hex.toString(), 16);
                        skip = 13;
                    }
                    catch (NumberFormatException numberFormatException) {}
                } else if (code >= '0' && code <= '9') {
                    next = LEGACY[code - 48];
                } else if (code >= 'a' && code <= 'f') {
                    next = LEGACY[10 + code - 97];
                } else if (code == 'r') {
                    next = start;
                }
                if (builder.length() > 0) {
                    out.add(new Seg(builder.toString(), color));
                    builder.setLength(0);
                }
                color = next;
                i += skip;
                continue;
            }
            builder.append(c);
        }
        if (builder.length() > 0) {
            out.add(new Seg(builder.toString(), color));
        }
    }

    private void drawSegments(List<Seg> segments, float sx, float centerY, float size) {
        vdn font = BotScreen.medium(size);
        float cursor = sx;
        for (Seg seg : segments) {
            this.text(font, seg.text, cursor, centerY, seg.color);
            cursor += font.width(seg.text);
        }
    }

    private void styled(Text value, float left, float centerY, float size, float maxWidth) {
        vdn font = BotScreen.medium(size);
        float cursor = left;
        float end = left + maxWidth;
        for (Seg seg : BotScreen.segments(value, -1644306)) {
            String part = BotScreen.trim(font, seg.text, end - cursor);
            this.text(font, part, cursor, centerY, seg.color);
            if (!((cursor += font.width(part)) >= end) && !part.endsWith("..")) continue;
            break;
        }
    }

    private void styledCentered(Text value, float centerX, float centerY, float size, float maxWidth) {
        vdn font = BotScreen.medium(size);
        List<Seg> segments = BotScreen.segments(value, -1);
        float total = 0.0f;
        for (Seg seg : segments) {
            total += font.width(seg.text);
        }
        float cursor = centerX - Math.min(total, maxWidth) / 2.0f;
        float end = cursor + maxWidth;
        for (Seg seg : segments) {
            String part = BotScreen.trim(font, seg.text, end - cursor);
            this.text(font, part, cursor, centerY, seg.color);
            if (!((cursor += font.width(part)) >= end)) continue;
            break;
        }
    }

    private static int statusColor(dts status) {
        return switch (status) {
            case dts.ONLINE -> -10758549;
            case dts.QUEUED, dts.CONNECTING, dts.LOGIN, dts.JOINING -> -1526966;
            case dts.FAILED -> -2073765;
            default -> -7630435;
        };
    }

    private static String dimensionName(String path) {
        if (path.contains("end")) {
            return "\u042d\u043d\u0434";
        }
        if (path.contains("nether")) {
            return "\u0410\u0434";
        }
        if (path.contains("overworld")) {
            return "\u041e\u0431\u044b\u0447\u043d\u044b\u0439 \u043c\u0438\u0440";
        }
        return path;
    }

    private static int text() {
        return iov.text;
    }

    private static int textDim() {
        return iov.textDim;
    }

    private static int accent() {
        return iov.accent();
    }

    private static int accent(int alpha) {
        return iov.accent(alpha);
    }

    private static vdn medium(float size) {
        return veo.medium(size);
    }

    private static vdn semibold(float size) {
        return veo.semibold(size);
    }

    private static boolean hovered(double mouseX, double mouseY, float hx, float hy, float hw, float hh) {
        return mouseX >= (double)hx && mouseX <= (double)(hx + hw) && mouseY >= (double)hy && mouseY <= (double)(hy + hh);
    }

    private void text(vdn font, String string, float tx, float centerY, int color) {
        if (string == null || string.isEmpty()) {
            return;
        }
        font.draw(this.ctx, string, Math.round(tx), font.centerTop(centerY), color);
    }

    private void centered(vdn font, String string, float centerX, float centerY, int color) {
        this.text(font, string, centerX - font.width(string) / 2.0f, centerY, color);
    }

    private static String trim(vdn font, String string, float maxWidth) {
        if (string == null) {
            return "";
        }
        if (maxWidth <= 0.0f || font.width(string) <= maxWidth) {
            return string;
        }
        StringBuilder builder = new StringBuilder();
        for (char c : string.toCharArray()) {
            if (font.width(builder.toString() + c + "..") > maxWidth) break;
            builder.append(c);
        }
        return builder + "..";
    }

    static {
        tab = Tab.CHAT;
    }

    private final class Field {
        private final int max;
        private final String placeholder;
        private String text = "";
        private int cursor;
        private float x;
        private float y;
        private float w;
        private float h;
        private boolean visible;
        private Consumer<String> onCommit;

        Field(int max, String placeholder) {
            this.max = max;
            this.placeholder = placeholder;
        }

        void setText(String value) {
            this.text = value == null ? "" : (value.length() > this.max ? value.substring(0, this.max) : value);
            this.cursor = this.text.length();
        }

        void commit() {
            if (this.onCommit != null) {
                this.onCommit.accept(this.text);
            }
        }

        void render(float fx, float fy, float fw, float fh, int mouseX, int mouseY) {
            this.x = fx;
            this.y = fy;
            this.w = fw;
            this.h = fh;
            this.visible = true;
            boolean isFocused = BotScreen.this.focused == this;
            boolean hover = BotScreen.hovered(mouseX, mouseY, fx, fy, fw, fh);
            if (isFocused) {
                uut.round(BotScreen.this.ctx, fx - 1.0f, fy - 1.0f, fw + 2.0f, fh + 2.0f, 5.5f, BotScreen.accent(170));
            }
            uut.round(BotScreen.this.ctx, fx, fy, fw, fh, 5.0f, isFocused ? ujt.withAlpha(iov.window, 240) : (hover ? iov.fieldHover : iov.field));
            vdn font = BotScreen.medium(7.0f);
            float inner = fw - 10.0f;
            float cy = fy + fh / 2.0f;
            if (this.text.isEmpty() && !isFocused) {
                BotScreen.this.text(font, BotScreen.trim(font, this.placeholder, inner), fx + 5.0f, cy, BotScreen.textDim());
                return;
            }
            String before = this.text.substring(0, Math.min(this.cursor, this.text.length()));
            float caret = font.width(before);
            float shift = Math.max(0.0f, caret - inner + 2.0f);
            uut.pushScissor(BotScreen.this.ctx, fx + 3.0f, fy, fw - 6.0f, fh);
            BotScreen.this.text(font, this.text, fx + 5.0f - shift, cy, BotScreen.text());
            if (isFocused && System.currentTimeMillis() / 500L % 2L == 0L) {
                uut.rect(BotScreen.this.ctx, fx + 5.0f - shift + caret, cy - 4.5f, 1.0f, 9.0f, BotScreen.text());
            }
            uut.popScissor(BotScreen.this.ctx);
        }

        void key(int keyCode, int modifiers) {
            boolean ctrl;
            boolean bl = ctrl = (modifiers & 2) != 0;
            if (keyCode == 259 && this.cursor > 0) {
                this.text = this.text.substring(0, this.cursor - 1) + this.text.substring(this.cursor);
                --this.cursor;
            } else if (keyCode == 261 && this.cursor < this.text.length()) {
                this.text = this.text.substring(0, this.cursor) + this.text.substring(this.cursor + 1);
            } else if (keyCode == 263) {
                this.cursor = Math.max(0, this.cursor - 1);
            } else if (keyCode == 262) {
                this.cursor = Math.min(this.text.length(), this.cursor + 1);
            } else if (keyCode == 268) {
                this.cursor = 0;
            } else if (keyCode == 269) {
                this.cursor = this.text.length();
            } else if (ctrl && keyCode == 86 && BotScreen.this.field_22787 != null) {
                String clip = ((BotScreen)BotScreen.this).field_22787.field_1774.method_1460();
                if (clip != null) {
                    for (char c : clip.toCharArray()) {
                        this.type(c);
                    }
                }
            } else if (ctrl && keyCode == 65) {
                this.cursor = this.text.length();
            }
        }

        void type(char chr) {
            if (chr < ' ' || chr == '\u007f' || chr == '\u00a7' || this.text.length() >= this.max) {
                return;
            }
            this.text = this.text.substring(0, this.cursor) + chr + this.text.substring(this.cursor);
            ++this.cursor;
        }
    }

    private static enum Tab {
        CHAT,
        TAB_E,
        TAB_W,
        TAB_M,
        TAB_D,
        BOT,
        ALL;

    }

    private record ChatCache(dtv bot, int revision, float width, List<List<Seg>> lines) {
    }

    private record Zone(float x, float y, float w, float h, float clipTop, float clipBottom, IntConsumer action) {
        boolean contains(double mouseX, double mouseY) {
            if (mouseY < (double)this.clipTop || mouseY > (double)this.clipBottom) {
                return false;
            }
            return BotScreen.hovered(mouseX, mouseY, this.x, this.y, this.w, this.h);
        }
    }

    private record Seg(String text, int color) {
    }
}

