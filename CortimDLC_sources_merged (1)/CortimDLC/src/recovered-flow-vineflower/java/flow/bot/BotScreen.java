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
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public final class BotScreen extends Screen {
   private static final float W = 600.0F;
   private static final float H = 318.0F;
   private static final float HEADER = 20.0F;
   private static final float PAD = 6.0F;
   private static final float LIST_W = 146.0F;
   private static final float MID_W = 226.0F;
   private static final float INFO_H = 18.0F;
   private static final float VIEW_H = 150.0F;
   private static final float TAB_H = 16.0F;
   private static final float SLOT = 20.0F;
   private static final float ROW = 30.0F;
   private static final float RADIUS = 8.0F;
   private static final float SIZE_TITLE = 8.5F;
   private static final float SIZE_NAME = 7.5F;
   private static final float SIZE_ROW = 7.0F;
   private static final float SIZE_SMALL = 6.5F;
   private static final float SIZE_CHAT = 6.5F;
   private static final float SIZE_TINY = 5.5F;
   private static final int GREEN = -10758549;
   private static final int AMBER = -1526966;
   private static final int RED = -2073765;
   private static final int GRAY = -7630435;
   private static final String[] F1_LABELS = new String[]{"Сейв", "Лут", "Способ ТП", "Хом", "Варп", "Макс. сундуков", "Задержка лута", "Зелья скорости"};
   private static final String[] F1_STATES = new String[]{
      "осматривается",
      "пополнение на сейве",
      "едет на анархию лута",
      "едет в город",
      "ищет сундук",
      "ждёт сундук",
      "лутает сундук",
      "убегает",
      "ждёт конца ПвП",
      "едет на сейв",
      "идёт на базу сейва"
   };
   private static final String[] F0_LABELS = new String[]{"Сейв Энд", "Лут Энд", "Способ ТП", "Варп", "Макс. ваз", "Кисть (песок)", "Зелья скорости"};
   private static final int[] LEGACY = new int[]{
      -16777216, -16777046, -16733696, -16733526, -5636096, -5635926, -22016, -5592406, -11184811, -11184641, -11141291, -11141121, -43691, -43521, -171, -1
   };
   private static float posX = Float.NaN;
   private static float posY = Float.NaN;
   private static dtv selected;
   private static BotScreen.Tab tab = BotScreen.Tab.CHAT;
   private static boolean lootPicker;
   private static boolean cameraMode;
   private final List<BotScreen.Zone> zones = new ArrayList<>();
   private final BotScreen.Field nickField = new BotScreen.Field(16, "ник");
   private final BotScreen.Field addressField = new BotScreen.Field(80, "адрес сервера");
   private final BotScreen.Field chatField = new BotScreen.Field(256, "сообщение или /команда");
   private final BotScreen.Field botAddressField = new BotScreen.Field(80, "адрес");
   private final BotScreen.Field broadcastField = new BotScreen.Field(256, "всем: /an513, /tpa ник");
   private final BotScreen.Field captchaField = new BotScreen.Field(16, "цифры с картинки");
   private final Map<vmu, BotScreen.Field> settingFields = new HashMap<>();
   private final List<String> sentHistory = new ArrayList<>();
   private int pickerRow;
   private int mineScroll;
   private String allNotice;
   private long allNoticeTime;
   private boolean captchaExpand;
   private BotScreen.Field focused;
   private String formError;
   private long formErrorTime;
   private DrawContext ctx;
   private float scale = 1.0F;
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
   private ItemStack hoveredStack = ItemStack.EMPTY;
   private Slot hoveredSlot;
   private ScreenHandler hoveredHandler;
   private BotScreen.ChatCache chatCache;

   public BotScreen() {
      super(Text.literal("Боты"));
   }

   @Override
   protected void init() {
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

   @Override
   public boolean shouldPause() {
      return false;
   }

   @Override
   public void removed() {
      this.setControl(false);
      this.commitSettingFields();
   }

   @Override
   public void renderBackground(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
      uut.beginFrame();
      unf.observe(context);
      iov.update(unf.delta());
      float dim = (float)iov.DIM.get();
      if (this.client != null && this.client.world != null) {
         hyv.capture(context, iov.BG_BLUR.getInt(), 1.0F, null);
         uut.gradientV(context, 0.0F, 0.0F, this.width, this.height, 0.0F, ujt.withAlpha(0, (int)(255.0F * dim * 0.65F)), ujt.withAlpha(0, (int)(255.0F * dim)));
      } else {
         hyv.skip();
         this.renderPanoramaBackground(context, deltaTicks);
         uut.rect(context, 0.0F, 0.0F, this.width, this.height, ujt.withAlpha(0, (int)(255.0F * Math.max(0.3F, dim))));
      }
   }

   @Override
   public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
      this.ctx = context;
      this.scale = Math.min(1.0F, Math.min((this.width - 8.0F) / 600.0F, (this.height - 8.0F) / 318.0F));
      this.scale = Math.max(0.3F, this.scale);
      int mouseXx = Math.round(mouseX / this.scale);
      int mouseYx = Math.round(mouseY / this.scale);
      this.zones.clear();
      this.viewShown = false;
      this.hoveredStack = ItemStack.EMPTY;
      this.hoveredSlot = null;
      this.hoveredHandler = null;
      this.captchaExpand = false;

      for (BotScreen.Field field : this.allFields()) {
         field.visible = false;
      }

      float screenW = this.width / this.scale;
      float screenH = this.height / this.scale;
      if (Float.isNaN(posX)) {
         posX = (screenW - 600.0F) / 2.0F;
         posY = (screenH - 318.0F) / 2.0F;
      }

      posX = MathHelper.clamp(posX, 0.0F, Math.max(0.0F, screenW - 600.0F));
      posY = MathHelper.clamp(posY, 0.0F, Math.max(0.0F, screenH - 318.0F));
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
      context.getMatrices().pushMatrix();
      context.getMatrices().scale(this.scale, this.scale);

      try {
         this.renderShell();
         this.renderList(mouseXx, mouseYx);
         if (selected == null) {
            this.renderEmpty();
         } else {
            this.renderBot(selected, mouseXx, mouseYx);
            if (this.captchaExpand) {
               this.renderCaptchaExpand(selected.getCaptcha());
            }
         }
      } finally {
         context.getMatrices().popMatrix();
         vdn.setRenderScale(1.0F);
      }

      if (selected != null) {
         ClientPlayerEntity player = selected.getPlayer();
         if (player != null && !player.currentScreenHandler.getCursorStack().isEmpty()) {
            ItemStack cursor = player.currentScreenHandler.getCursorStack();
            context.drawItem(cursor, mouseX - 8, mouseY - 8);
            context.drawStackOverlay(this.textRenderer, cursor, mouseX - 8, mouseY - 8);
         } else if (!this.hoveredStack.isEmpty()) {
            context.drawItemTooltip(this.textRenderer, this.hoveredStack, mouseX, mouseY);
         }
      }

      this.ctx = null;
   }

   private void renderShell() {
      float r = iov.r(12.0F);
      uut.shadow(this.ctx, this.x, this.y + 3.0F, 600.0F, 318.0F, r, 14.0F, iov.shadow);
      boolean glass = hyv.surface(
         this.ctx, this.x, this.y, 600.0F, 318.0F, r, hyv.tint(iov.window, iov.windowTint()), ujt.withAlpha(iov.window, 255), (float)hyv.EDGE.get(), hyv.WINDOW
      );
      uut.round(this.ctx, this.x, this.y, 600.0F, 20.0F, r, r, 0.0F, 0.0F, iov.panel);
      if (!glass || !hyv.liquid()) {
         uut.outline(this.ctx, this.x, this.y, 600.0F, 318.0F, r, 1.0F, glass ? ujt.withAlpha(16777215, 24) : iov.stroke);
      }

      uut.round(this.ctx, this.x + 6.0F, this.y + 6.0F, 2.5F, 8.0F, 1.25F, accent(235));
      vdn bold = semibold(8.5F);
      this.text(bold, "Боты", this.x + 14.0F, this.y + 10.0F, text());
      int online = 0;

      for (dtv bot : egq.get().getBots()) {
         if (bot.getStatus() == dts.ONLINE) {
            online++;
         }
      }

      Runtime runtime = Runtime.getRuntime();
      long used = runtime.totalMemory() - runtime.freeMemory() >> 20;
      long max = runtime.maxMemory() >> 20;
      String count = "в игре "
         + online
         + " из "
         + egq.get().getBots().size()
         + "   память "
         + String.format(Locale.ROOT, "%.1f / %.1f ГБ", used / 1024.0, max / 1024.0);
      this.text(medium(6.5F), count, this.x + 14.0F + bold.width("Боты") + 8.0F, this.y + 10.0F, textDim());
      float closeX = this.x + 600.0F - 18.0F;
      this.centered(medium(7.0F), "x", closeX + 6.0F, this.y + 10.0F, textDim());
      this.zone(closeX, this.y + 3.0F, 12.0F, 14.0F, b -> this.close());
   }

   private void renderEmpty() {
      float left = this.x + 6.0F + 146.0F + 6.0F;
      float cx = left + 218.0F;
      float cy = this.y + 159.0F;
      vdn font = medium(7.0F);
      this.centered(font, "Добавь бота слева: ник оффлайн-аккаунта и адрес сервера.", cx, cy - 8.0F, textDim());
      this.centered(font, "Бот зайдёт сам - дальше /login в его чате и " + vup.e() + ".", cx, cy + 5.0F, textDim());
   }

   private void renderList(int mouseX, int mouseY) {
      float left = this.x + 6.0F;
      float top = this.y + 20.0F + 6.0F;
      float formH = 82.0F;
      float listBottom = this.y + 318.0F - 6.0F - formH - 4.0F;
      uut.round(this.ctx, left, top, 146.0F, listBottom - top, 7.0F, iov.card);
      List<dtv> bots = egq.get().getBots();
      float content = bots.size() * 33.0F;
      float visible = listBottom - top - 6.0F;
      this.listScroll = MathHelper.clamp(this.listScroll, -Math.max(0.0F, content - visible), 0.0F);
      uut.pushScissor(this.ctx, left, top + 2.0F, 146.0F, listBottom - top - 4.0F);
      float rowY = top + 3.0F + this.listScroll;

      for (dtv bot : bots) {
         if (rowY + 30.0F >= top && rowY <= listBottom) {
            this.renderBotRow(bot, left + 3.0F, rowY, 140.0F, mouseX, mouseY, top, listBottom);
         }

         rowY += 33.0F;
      }

      uut.popScissor(this.ctx);
      if (bots.isEmpty()) {
         this.centered(medium(7.0F), "ботов нет", left + 73.0F, (top + listBottom) / 2.0F, textDim());
      }

      this.renderAddForm(left, listBottom + 4.0F, 146.0F, formH, mouseX, mouseY);
   }

   private void renderBotRow(dtv bot, float rx, float ry, float rw, int mouseX, int mouseY, float clipTop, float clipBottom) {
      boolean isSelected = bot == selected;
      boolean hover = hovered(mouseX, mouseY, rx, ry, rw, 30.0F) && mouseY >= clipTop && mouseY <= clipBottom;
      if (isSelected) {
         uut.round(this.ctx, rx - 1.0F, ry - 1.0F, rw + 2.0F, 32.0F, 7.0F, accent(150));
         uut.round(this.ctx, rx, ry, rw, 30.0F, 6.0F, ujt.withAlpha(iov.window, 220));
      }

      uut.round(this.ctx, rx, ry, rw, 30.0F, 6.0F, hover ? iov.fieldHover : iov.field);
      this.zoneClip(rx, ry, rw, 30.0F, clipTop, clipBottom, b -> {
         selected = bot;
         this.chatScroll = 0.0F;
         this.syncBotFields();
      });
      uut.round(this.ctx, rx + 6.0F, ry + 15.0F - 3.0F, 6.0F, 6.0F, 2.25F, statusColor(bot.getStatus()));
      float nameX = rx + 17.0F;
      float buttonsW = hover ? 44.0F : 0.0F;
      vdn bold = semibold(7.5F);
      vdn font = medium(6.5F);
      this.text(bold, trim(bold, bot.getName(), rw - 22.0F - buttonsW), nameX, ry + 9.0F, text());
      int subColor = textDim();
      String sub;
      if (bot.getStatus() == dts.ONLINE && bot.getCaptcha().isPresent()) {
         sub = "капча - нужен код";
         subColor = -1526966;
      } else if (bot.getStatus() == dts.ONLINE) {
         sub = bot.f0Run()
            ? bot.f0ref().getStateDescription()
            : (
               bot.f1Run()
                  ? "Варден: " + f1StateLabel(bot.f1ref().getStateIndex())
                  : (bot.f2Run() ? "Шахта: " + mineStatus(bot) : (bot.f3Run() ? "Обломки: " + bot.f3ref().status() : "в игре"))
            );
      } else if (bot.getReconnectAt() > 0L) {
         long left = Math.max(0L, (bot.getReconnectAt() - System.currentTimeMillis()) / 1000L);
         sub = "переподключение " + left + " с";
      } else {
         sub = bot.getStatusText();
      }

      this.text(font, trim(font, sub, rw - 22.0F - buttonsW), nameX, ry + 21.0F, subColor);
      ClientPlayerEntity player = bot.getPlayer();
      if (player != null && !hover) {
         float barW = 30.0F;
         float ratio = MathHelper.clamp(player.getHealth() / Math.max(1.0F, player.getMaxHealth()), 0.0F, 1.0F);
         uut.round(this.ctx, rx + rw - barW - 6.0F, ry + 7.5F, barW, 3.0F, 1.5F, iov.track);
         uut.round(
            this.ctx,
            rx + rw - barW - 6.0F,
            ry + 7.5F,
            Math.max(3.0F, barW * ratio),
            3.0F,
            1.5F,
            ratio > 0.5F ? -10758549 : (ratio > 0.25F ? -1526966 : -2073765)
         );
      }

      if (hover) {
         boolean connected = bot.getStatus() != dts.OFFLINE && bot.getStatus() != dts.FAILED;
         float bx = rx + rw - 42.0F;
         this.smallButton(bx, ry + 15.0F - 7.0F, 24.0F, 14.0F, connected ? "выкл" : "вкл", mouseX, mouseY, b -> {
            if (connected) {
               bot.disconnect();
            } else {
               bot.connect();
            }
         });
         this.smallButton(bx + 26.0F, ry + 15.0F - 7.0F, 14.0F, 14.0F, "x", mouseX, mouseY, b -> {
            egq.get().remove(bot);
            if (selected == bot) {
               selected = egq.get().getBots().isEmpty() ? null : egq.get().getBots().get(0);
               this.syncBotFields();
            }
         });
      }
   }

   private void renderAddForm(float fx, float fy, float fw, float fh, int mouseX, int mouseY) {
      uut.round(this.ctx, fx, fy, fw, fh, 7.0F, iov.card);
      vdn font = medium(6.5F);
      float inner = fx + 5.0F;
      float innerW = fw - 10.0F;
      this.nickField.render(inner, fy + 5.0F, innerW, 16.0F, mouseX, mouseY);
      this.addressField.render(inner, fy + 24.0F, innerW, 16.0F, mouseX, mouseY);
      this.button(inner, fy + 44.0F, innerW, 16.0F, "Добавить бота", true, mouseX, mouseY, b -> this.addBot());
      boolean error = this.formError != null && System.currentTimeMillis() - this.formErrorTime < 5000L;
      String hint = error ? this.formError : "ник: латиница, цифры, _";
      this.text(font, trim(font, hint, innerW), inner, fy + 70.0F, error ? -2073765 : textDim());
   }

   private void addBot() {
      String nick = this.nickField.text.trim();
      String address = this.addressField.text.trim();
      if (!egq.isValidName(nick)) {
         this.formError = "ник - от 3 до 16 символов: A-Z, 0-9, _";
         this.formErrorTime = System.currentTimeMillis();
      } else if (address.isEmpty()) {
         this.formError = "укажи адрес сервера";
         this.formErrorTime = System.currentTimeMillis();
      } else {
         dtv bot = egq.get().add(nick, address);
         if (bot != null) {
            selected = bot;
            this.nickField.setText("");
            this.formError = null;
            this.chatScroll = 0.0F;
            this.syncBotFields();
         }
      }
   }

   private void renderBot(dtv bot, int mouseX, int mouseY) {
      float left = this.x + 6.0F + 146.0F + 6.0F;
      float right = this.x + 600.0F - 6.0F;
      float top = this.y + 20.0F + 6.0F;
      this.renderInfo(bot, left, top, right - left);
      float contentTop = top + 18.0F + 4.0F;
      float contentBottom = this.y + 318.0F - 6.0F;
      float rightX = left + 226.0F + 6.0F;
      ClientPlayerEntity player = bot.getPlayer();
      boolean container = player != null && player.currentScreenHandler != player.playerScreenHandler;
      vlj picker = openPicker(bot);
      if (container) {
         this.renderContainer(bot, player, left, contentTop, 226.0F, contentBottom - contentTop, mouseX, mouseY);
      } else if (picker != null) {
         this.renderPicker(picker, left, contentTop, 226.0F, contentBottom - contentTop, mouseX, mouseY);
      } else if (player != null && bot.getCaptcha().isShown()) {
         this.renderCaptcha(bot, left, contentTop, 226.0F, contentBottom - contentTop, mouseX, mouseY);
      } else {
         this.renderView(bot, left, contentTop, 226.0F, 150.0F, mouseX, mouseY);
         this.renderInventory(bot, left, contentTop + 150.0F + 4.0F, 226.0F, contentBottom - contentTop - 150.0F - 4.0F, mouseX, mouseY);
      }

      this.renderTabs(bot, rightX, contentTop, right - rightX, contentBottom - contentTop, mouseX, mouseY);
   }

   private void renderInfo(dtv bot, float ix, float iy, float iw) {
      uut.round(this.ctx, ix, iy, iw, 18.0F, 6.0F, iov.card);
      vdn bold = semibold(7.5F);
      vdn font = medium(6.5F);
      float cy = iy + 9.0F;
      uut.round(this.ctx, ix + 6.0F, cy - 3.0F, 6.0F, 6.0F, 2.25F, statusColor(bot.getStatus()));
      this.text(bold, bot.getName(), ix + 16.0F, cy, text());
      float cursor = ix + 16.0F + bold.width(bot.getName()) + 8.0F;
      ClientPlayerEntity player = bot.getPlayer();
      String info;
      if (player == null) {
         info = bot.getStatusText();
      } else {
         BlockPos pos = player.getBlockPos();
         ClientWorld level = bot.getWorld();
         String dim = level == null ? "?" : dimensionName(level.getRegistryKey().getValue().getPath());
         info = String.format(
            Locale.ROOT,
            "%.0f/%.0f hp   еда %d   %s   %d %d %d   пинг %s   %.1f мс",
            player.getHealth(),
            player.getMaxHealth(),
            player.getHungerManager().getFoodLevel(),
            dim,
            pos.getX(),
            pos.getY(),
            pos.getZ(),
            bot.getPing() < 0 ? "-" : String.valueOf(bot.getPing()),
            bot.getTickMillis()
         );
      }

      this.text(font, trim(font, info, ix + iw - 6.0F - cursor), cursor, cy, textDim());
   }

   private void renderView(dtv bot, float vx, float vy, float vw, float vh, int mouseX, int mouseY) {
      this.viewX = vx;
      this.viewY = vy;
      this.viewW = vw;
      this.viewH = vh;
      this.viewShown = true;
      if (this.control) {
         uut.round(this.ctx, vx - 1.5F, vy - 1.5F, vw + 3.0F, vh + 3.0F, 8.0F, accent(170));
      }

      uut.round(this.ctx, vx, vy, vw, vh, 7.0F, this.control ? -351794932 : -687339252);
      ClientPlayerEntity player = bot.getPlayer();
      vdn font = medium(7.0F);
      if (player == null) {
         this.centered(font, "бот не в игре", vx + vw / 2.0F, vy + vh / 2.0F, textDim());
      } else if (cameraMode) {
         this.renderCamera(bot, vx, vy, vw, vh);
      } else {
         this.renderRadar(bot, player, vx, vy, vw, vh);
      }

      if (player != null) {
         this.renderOverlays(bot, vx, vy, vw, vh);
      }

      float by = vy + 4.0F;
      this.chip(vx + 4.0F, by, "Радар", !cameraMode, mouseX, mouseY, b -> cameraMode = false);
      this.chip(vx + 40.0F, by, "Камера", cameraMode, mouseX, mouseY, b -> cameraMode = true);
      if (player != null && bot.getCaptcha().isPresent()) {
         this.chip(vx + 82.0F, by, "Капча", false, mouseX, mouseY, b -> bot.getCaptcha().show());
      }

      this.chip(vx + vw - 70.0F, by, this.control ? "Управление вкл" : "Управление", this.control, mouseX, mouseY, b -> this.setControl(!this.control));
      if (this.control) {
         this.text(medium(5.5F), "WASD, пробел, Shift, Ctrl  -  ЛКМ/ПКМ  -  колесо: тянуть = поворот", vx + 5.0F, vy + vh - 7.0F, textDim());
      }
   }

   private void renderCamera(dtv bot, float vx, float vy, float vw, float vh) {
      dyh camera = bot.getCamera();
      camera.demand();
      elb texture = camera.texture();
      if (texture == null) {
         this.centered(medium(7.0F), camera.getStatus(), vx + vw / 2.0F, vy + vh / 2.0F, textDim());
      } else {
         uut.imageRegion(this.ctx, texture.view(), vx, vy, vw, vh, 7.0F, 0.0F, 0.0F, 1.0F, 1.0F, -1, false);
         float cx = vx + vw / 2.0F;
         float cy = vy + vh / 2.0F;
         uut.rect(this.ctx, cx - 3.5F, cy - 0.5F, 7.0F, 1.0F, -922746881);
         uut.rect(this.ctx, cx - 0.5F, cy - 3.5F, 1.0F, 7.0F, -922746881);
         vdn font = medium(5.5F);
         uut.pushScissor(this.ctx, vx, vy, vw, vh);

         for (dxe label : camera.labels()) {
            float lx = vx + label.x() * vw;
            float ly = vy + label.y() * vh;
            float lw = font.width(label.text()) + 6.0F;
            uut.round(this.ctx, lx - lw / 2.0F, ly - 4.5F, lw, 9.0F, 3.0F, -1778384896);
            this.centered(font, label.text(), lx, ly, label.color());
         }

         uut.popScissor(this.ctx);
         this.text(font, String.format(Locale.ROOT, "%.1f мс", camera.getRenderMillis()), vx + vw - 30.0F, vy + vh - 7.0F, -1761607681);
      }
   }

   private void renderRadar(dtv bot, ClientPlayerEntity player, float vx, float vy, float vw, float vh) {
      eip radar = bot.getRadar();
      radar.demand();
      elb texture = radar.texture();
      float scale = vw / 96.0F;
      double offsetX = (player.getX() - (radar.getCenterX() + 0.5)) * scale;
      double offsetZ = (player.getZ() - (radar.getCenterZ() + 0.5)) * scale;
      float cx = vx + vw / 2.0F;
      float cy = vy + vh / 2.0F;
      uut.pushScissor(this.ctx, vx + 1.0F, vy + 1.0F, vw - 2.0F, vh - 2.0F);
      if (texture != null) {
         float size = 96.0F * scale;
         float tx = Math.round((float)(cx - size / 2.0F - offsetX));
         float ty = Math.round((float)(cy - size / 2.0F - offsetZ));
         uut.imageRegion(this.ctx, texture.view(), tx, ty, size, size, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, -1, true);
      }

      mpq fE = bot.f0ref();
      if (fE.isEnabled()) {
         List<BlockPos> path = fE.getBotPath();
         if (path != null) {
            for (int i = Math.max(0, fE.getBotPathIndex()); i < path.size(); i++) {
               BlockPos node = path.get(i);
               float px = cx + (float)((node.getX() + 0.5 - player.getX()) * scale);
               float pz = cy + (float)((node.getZ() + 0.5 - player.getZ()) * scale);
               uut.round(this.ctx, px - 1.25F, pz - 1.25F, 2.5F, 2.5F, 1.0F, accent(200));
            }
         }

         BlockPos target = fE.getBotTarget();
         if (target != null) {
            float px = cx + (float)((target.getX() + 0.5 - player.getX()) * scale);
            float pz = cy + (float)((target.getZ() + 0.5 - player.getZ()) * scale);
            uut.round(this.ctx, px - 4.0F, pz - 4.0F, 8.0F, 8.0F, 3.5F, accent(230));
            uut.round(this.ctx, px - 2.5F, pz - 2.5F, 5.0F, 5.0F, 2.0F, -435681012);
         }
      }

      nxa fW = bot.f1ref();
      if (fW.isEnabled()) {
         List<BlockPos> path = fW.getBotPath();
         if (path != null) {
            for (int i = Math.max(0, fW.getBotPathIndex()); i < path.size(); i++) {
               BlockPos node = path.get(i);
               float px = cx + (float)((node.getX() + 0.5 - player.getX()) * scale);
               float pz = cy + (float)((node.getZ() + 0.5 - player.getZ()) * scale);
               uut.round(this.ctx, px - 1.25F, pz - 1.25F, 2.5F, 2.5F, 1.0F, accent(200));
            }
         }

         BlockPos target = fW.getBotTarget();
         if (target != null) {
            float px = cx + (float)((target.getX() + 0.5 - player.getX()) * scale);
            float pz = cy + (float)((target.getZ() + 0.5 - player.getZ()) * scale);
            uut.round(this.ctx, px - 4.0F, pz - 4.0F, 8.0F, 8.0F, 3.5F, -1526966);
            uut.round(this.ctx, px - 2.5F, pz - 2.5F, 5.0F, 5.0F, 2.0F, -435681012);
         }
      }

      ClientWorld level = bot.getWorld();
      vdn font = medium(5.5F);
      if (level != null) {
         for (Entity entity : level.getEntities()) {
            if (entity != player) {
               float px = cx + (float)((entity.getX() - player.getX()) * scale);
               float pz = cy + (float)((entity.getZ() - player.getZ()) * scale);
               if (!(px < vx) && !(px > vx + vw) && !(pz < vy) && !(pz > vy + vh)) {
                  if (entity instanceof OtherClientPlayerEntity other) {
                     uut.round(this.ctx, px - 2.5F, pz - 2.5F, 5.0F, 5.0F, 2.0F, -2073765);
                     this.text(font, other.getName().getString(), px + 4.0F, pz, -12080);
                  } else if (entity instanceof ItemEntity) {
                     uut.round(this.ctx, px - 1.5F, pz - 1.5F, 3.0F, 3.0F, 1.2F, -10166);
                  } else if (entity instanceof HostileEntity) {
                     uut.round(this.ctx, px - 2.0F, pz - 2.0F, 4.0F, 4.0F, 1.5F, -30147);
                  }
               }
            }
         }
      }

      double yaw = Math.toRadians(player.getYaw());
      float dx = (float)(-Math.sin(yaw));
      float dz = (float)Math.cos(yaw);

      for (int i = 1; i <= 3; i++) {
         uut.round(this.ctx, cx + dx * 3.2F * i - 1.0F, cy + dz * 3.2F * i - 1.0F, 2.0F, 2.0F, 0.9F, -1);
      }

      uut.round(this.ctx, cx - 3.0F, cy - 3.0F, 6.0F, 6.0F, 2.5F, -1);
      uut.round(this.ctx, cx - 1.75F, cy - 1.75F, 3.5F, 3.5F, 1.5F, accent());
      uut.popScissor(this.ctx);
      elb map = radar.mapTexture();
      if (map != null) {
         float size = 64.0F;
         float mx = Math.round(vx + vw - size - 5.0F);
         float my = Math.round(vy + vh - size - 12.0F);
         uut.round(this.ctx, mx - 2.0F, my - 2.0F, size + 4.0F, size + 4.0F, 3.0F, -939524096);
         uut.imageRegion(this.ctx, map.view(), mx, my, size, size, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, -1, true);
      }
   }

   private void renderCaptcha(dtv bot, float cx, float cy, float cw, float ch, int mouseX, int mouseY) {
      uut.round(this.ctx, cx, cy, cw, ch, 7.0F, iov.card);
      eao captcha = bot.getCaptcha();
      vdn bold = semibold(7.5F);
      vdn font = medium(6.5F);
      this.text(bold, "Капча", cx + 7.0F, cy + 9.0F, -1526966);
      String info = captcha.getFilledTiles() < captcha.getTotalTiles()
         ? "карты грузятся " + captcha.getFilledTiles() + "/" + captcha.getTotalTiles()
         : (
            !captcha.getAutoCode().isEmpty()
               ? "сеть отправила " + captcha.getAutoCode() + " - если не приняли, введи сам"
               : (!captcha.getAutoState().isEmpty() ? captcha.getAutoState() : "введи цифры с картинки")
         );
      float infoX = cx + 7.0F + bold.width("Капча") + 6.0F;
      this.text(font, trim(font, info, cw - (infoX - cx) - 56.0F), infoX, cy + 9.0F, textDim());
      this.smallButton(cx + cw - 50.0F, cy + 3.0F, 44.0F, 12.0F, "скрыть", mouseX, mouseY, b -> captcha.dismiss());
      float fieldH = 16.0F;
      float top = cy + 18.0F;
      float bottom = cy + ch - fieldH - 9.0F;
      elb texture = captcha.texture();
      int imageW = Math.max(1, captcha.getWidth());
      int imageH = Math.max(1, captcha.getHeight());
      float scale = Math.min((cw - 10.0F) / imageW, (bottom - top) / imageH);
      float drawW = Math.max(1, Math.round(imageW * scale));
      float drawH = Math.max(1, Math.round(imageH * scale));
      float drawX = Math.round(cx + (cw - drawW) / 2.0F);
      float drawY = Math.round(top + (bottom - top - drawH) / 2.0F);
      uut.round(this.ctx, drawX - 2.0F, drawY - 2.0F, drawW + 4.0F, drawH + 4.0F, 3.0F, -939524096);
      if (texture != null) {
         uut.imageRegion(this.ctx, texture.view(), drawX, drawY, drawW, drawH, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, -1, false);
      }

      this.captchaExpand = texture != null && hovered(mouseX, mouseY, drawX, drawY, drawW, drawH);
      float fy = cy + ch - fieldH - 5.0F;
      this.captchaField.render(cx + 5.0F, fy, cw - 10.0F - 66.0F, fieldH, mouseX, mouseY);
      this.button(cx + cw - 5.0F - 62.0F, fy, 62.0F, fieldH, "Отправить", true, mouseX, mouseY, b -> this.submitCaptcha());
   }

   private void renderCaptchaExpand(eao captcha) {
      elb texture = captcha.texture();
      if (texture != null) {
         int imageW = Math.max(1, captcha.getWidth());
         int imageH = Math.max(1, captcha.getHeight());
         float maxW = Math.min(580.0F, this.width / this.scale - 10.0F);
         float maxH = Math.min(298.0F, this.height / this.scale - 10.0F);
         float scale = Math.min(maxW / imageW, maxH / imageH);
         float drawW = Math.round(imageW * scale);
         float drawH = Math.round(imageH * scale);
         float drawX = Math.round(this.x + (600.0F - drawW) / 2.0F);
         float drawY = Math.round(this.y + (318.0F - drawH) / 2.0F);
         uut.round(this.ctx, drawX - 3.0F, drawY - 3.0F, drawW + 6.0F, drawH + 6.0F, 5.0F, -352321536);
         uut.imageRegion(this.ctx, texture.view(), drawX, drawY, drawW, drawH, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, -1, false);
      }
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
      float barY = vy + 22.0F;
      int shown = 0;

      for (ClientBossBar bar : bot.getBossBars().values()) {
         if (shown++ >= 2) {
            break;
         }

         float bw = 110.0F;
         float bx = vx + vw / 2.0F - bw / 2.0F;
         this.styledCentered(bar.getName(), vx + vw / 2.0F, barY, 6.5F, bw + 60.0F);
         uut.round(this.ctx, bx, barY + 5.0F, bw, 3.0F, 1.5F, 855638015);
         uut.round(this.ctx, bx, barY + 5.0F, Math.max(3.0F, bw * bar.getPercent()), 3.0F, 1.5F, -2039584);
         barY += 15.0F;
      }

      Text title = bot.getTitle();
      if (title != null) {
         this.styledCentered(title, vx + vw / 2.0F, vy + vh / 2.0F - 6.0F, 10.0F, vw - 10.0F);
      }

      Text subtitle = bot.getSubtitle();
      if (subtitle != null) {
         this.styledCentered(subtitle, vx + vw / 2.0F, vy + vh / 2.0F + 8.0F, 7.0F, vw - 10.0F);
      }

      Text actionBar = bot.getActionBar();
      if (actionBar != null) {
         this.styledCentered(actionBar, vx + vw / 2.0F, vy + vh - (this.control ? 18.0F : 9.0F), 6.5F, vw - 10.0F);
      }

      if (bot.getPlayer() != null && bot.getPlayer().isDead()) {
         this.centered(semibold(7.0F), "бот погиб - возрождение...", vx + vw / 2.0F, vy + vh / 2.0F + 22.0F, -2073765);
      }

      if (bot.getScreen() != null && !(bot.getScreen() instanceof DeathScreen)) {
         String name = bot.getScreen().getClass().getSimpleName();
         this.text(medium(5.5F), "открыт экран: " + name, vx + 5.0F, vy + vh - 18.0F, -1526966);
      }
   }

   private void renderInventory(dtv bot, float ix, float iy, float iw, float ih, int mouseX, int mouseY) {
      uut.round(this.ctx, ix, iy, iw, ih, 7.0F, iov.card);
      ClientPlayerEntity player = bot.getPlayer();
      if (player != null) {
         ScreenHandler handler = player.playerScreenHandler;
         float gridW = 180.0F;
         float gx = ix + (iw - gridW - 20.0F - 4.0F) / 2.0F + 20.0F + 4.0F;
         float gy = iy + 5.0F;

         for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
               this.slot(bot, handler, 9 + row * 9 + col, gx + col * 20.0F, gy + row * 20.0F, false, mouseX, mouseY);
            }
         }

         float hotbarY = gy + 60.0F + 4.0F;
         int selectedSlot = player.getInventory().getSelectedSlot();

         for (int col = 0; col < 9; col++) {
            this.slot(bot, handler, 36 + col, gx + col * 20.0F, hotbarY, col == selectedSlot, mouseX, mouseY);
         }

         float armorX = gx - 20.0F - 4.0F;

         for (int i = 0; i < 4; i++) {
            float sy = i < 3 ? gy + i * 20.0F : hotbarY;
            this.slot(bot, handler, 5 + i, armorX, sy, false, mouseX, mouseY);
         }
      }
   }

   private void renderContainer(dtv bot, ClientPlayerEntity player, float cx, float cy, float cw, float ch, int mouseX, int mouseY) {
      uut.round(this.ctx, cx, cy, cw, ch, 7.0F, iov.card);
      ScreenHandler handler = player.currentScreenHandler;
      vdn bold = semibold(7.5F);
      String title = bot.getOpenedScreenTitle() == null ? "контейнер" : bot.getOpenedScreenTitle();
      this.text(bold, trim(bold, title, cw - 60.0F), cx + 7.0F, cy + 9.0F, text());
      this.smallButton(cx + cw - 50.0F, cy + 3.0F, 44.0F, 12.0F, "закрыть", mouseX, mouseY, b -> bot.closeScreen());
      int total = handler.slots.size();
      int own = Math.min(36, total);
      int containerSlots = Math.max(0, total - own);
      int rows = (containerSlots + 8) / 9;
      float gridW = 180.0F;
      float gx = cx + (cw - gridW) / 2.0F;
      float gy = cy + 18.0F;
      int maxRows = (int)((ch - 18.0F - 80.0F - 16.0F) / 20.0F);

      for (int i = 0; i < containerSlots && i / 9 < Math.max(1, maxRows); i++) {
         this.slot(bot, handler, i, gx + i % 9 * 20.0F, gy + i / 9 * 20.0F, false, mouseX, mouseY);
      }

      float py = gy + Math.min(rows, Math.max(1, maxRows)) * 20.0F + 8.0F;

      for (int i = 0; i < own && containerSlots + i < total; i++) {
         int row = i / 9;
         float sy = row < 3 ? py + row * 20.0F : py + 60.0F + 4.0F;
         this.slot(bot, handler, containerSlots + i, gx + i % 9 * 20.0F, sy, false, mouseX, mouseY);
      }
   }

   private void slot(dtv bot, ScreenHandler handler, int index, float sx, float sy, boolean highlight, int mouseX, int mouseY) {
      if (index >= 0 && index < handler.slots.size()) {
         Slot slot = handler.slots.get(index);
         boolean hover = hovered(mouseX, mouseY, sx, sy, 19.0F, 19.0F);
         if (highlight) {
            uut.round(this.ctx, sx - 1.0F, sy - 1.0F, 21.0F, 21.0F, 5.0F, accent(200));
            uut.round(this.ctx, sx, sy, 19.0F, 19.0F, 4.5F, ujt.withAlpha(iov.window, 220));
         }

         uut.round(this.ctx, sx, sy, 19.0F, 19.0F, 4.5F, hover ? iov.fieldHover : iov.field);
         ItemStack stack = slot.getStack();
         if (!stack.isEmpty()) {
            int ix = Math.round(sx + 1.5F);
            int iy = Math.round(sy + 1.5F);
            this.ctx.drawItem(stack, ix, iy);
            this.ctx.drawStackOverlay(this.textRenderer, stack, ix, iy);
         }

         if (hover) {
            this.hoveredStack = stack;
            this.hoveredSlot = slot;
            this.hoveredHandler = handler;
         }

         int syncId = handler.syncId;
         this.zone(
            sx,
            sy,
            19.0F,
            19.0F,
            button -> {
               ClientPlayerEntity owner = bot.getPlayer();
               if (owner != null) {
                  boolean shift = this.client != null && this.client.isShiftPressed();
                  if (handler == owner.playerScreenHandler
                     && index >= 36
                     && index <= 44
                     && button == 0
                     && !shift
                     && owner.currentScreenHandler == handler
                     && handler.getCursorStack().isEmpty()
                     && this.control) {
                     bot.selectSlot(index - 36);
                  } else {
                     SlotActionType action = shift ? SlotActionType.QUICK_MOVE : SlotActionType.PICKUP;
                     bot.clickSlot(syncId, index, button == 1 ? 1 : 0, action);
                  }
               }
            }
         );
      }
   }

   private void renderTabs(dtv bot, float tx, float ty, float tw, float th, int mouseX, int mouseY) {
      float wide = 37.0F;
      float narrow = 33.0F;
      float gap = 2.0F;
      float tabW = (tw - wide * 3.0F - narrow - gap * 6.0F) / 3.0F;
      float cursor = tx;
      this.tabButton(cursor, ty, tabW, "Чат", BotScreen.Tab.CHAT, mouseX, mouseY);
      cursor += tabW + gap;
      this.tabButton(cursor, ty, wide, vup.e(), BotScreen.Tab.TAB_E, mouseX, mouseY);
      cursor += wide + gap;
      this.tabButton(cursor, ty, wide, "Варден", BotScreen.Tab.TAB_W, mouseX, mouseY);
      cursor += wide + gap;
      this.tabButton(cursor, ty, narrow, "Шахта", BotScreen.Tab.TAB_M, mouseX, mouseY);
      cursor += narrow + gap;
      this.tabButton(cursor, ty, wide, "Обломки", BotScreen.Tab.TAB_D, mouseX, mouseY);
      if (bot.f3ref().isVip()) {
         this.vipBadge(cursor + wide - 1.0F, ty, 7.0F, veo.bold(4.5F));
      }

      cursor += wide + gap;
      this.tabButton(cursor, ty, tabW, "Бот", BotScreen.Tab.BOT, mouseX, mouseY);
      cursor += tabW + gap;
      this.tabButton(cursor, ty, tabW, "Все", BotScreen.Tab.ALL, mouseX, mouseY);
      float by = ty + 16.0F + 4.0F;
      float bh = th - 16.0F - 4.0F;
      uut.round(this.ctx, tx, by, tw, bh, 7.0F, iov.card);
      switch (tab) {
         case CHAT:
            this.renderChat(bot, tx, by, tw, bh, mouseX, mouseY);
            break;
         case TAB_E:
            this.renderF0(bot, tx, by, tw, bh, mouseX, mouseY);
            break;
         case TAB_W:
            this.renderF1(bot, tx, by, tw, bh, mouseX, mouseY);
            break;
         case TAB_M:
            this.renderF2(bot, tx, by, tw, bh, mouseX, mouseY);
            break;
         case TAB_D:
            this.renderF3(bot, tx, by, tw, bh, mouseX, mouseY);
            break;
         case BOT:
            this.renderBotTab(bot, tx, by, tw, bh, mouseX, mouseY);
            break;
         case ALL:
            this.renderAll(tx, by, tw, bh, mouseX, mouseY);
      }
   }

   private void tabButton(float bx, float by, float bw, String label, BotScreen.Tab value, int mouseX, int mouseY) {
      boolean active = tab == value;
      boolean hover = hovered(mouseX, mouseY, bx, by, bw, 16.0F);
      uut.round(this.ctx, bx, by, bw, 16.0F, 5.0F, active ? accent(215) : (hover ? iov.fieldHover : iov.field));
      this.centered(medium(7.0F), label, bx + bw / 2.0F, by + 8.0F, active ? iov.onAccent() : text());
      this.zone(bx, by, bw, 16.0F, b -> {
         this.commitSettingFields();
         tab = value;
      });
   }

   private void renderChat(dtv bot, float cx, float cy, float cw, float ch, int mouseX, int mouseY) {
      float inputH = 16.0F;
      float logTop = cy + 4.0F;
      float logBottom = cy + ch - inputH - 8.0F;
      float logX = cx + 5.0F;
      float logW = cw - 10.0F;
      float lineH = 8.5F;
      if (this.chatCache == null || this.chatCache.bot != bot || this.chatCache.revision != bot.getChat().revision() || this.chatCache.width != logW) {
         this.chatCache = new BotScreen.ChatCache(bot, bot.getChat().revision(), logW, this.wrapChat(bot.getChat().lines(), logW));
      }

      List<List<BotScreen.Seg>> lines = this.chatCache.lines;
      float content = lines.size() * lineH;
      float visible = logBottom - logTop;
      this.chatScroll = MathHelper.clamp(this.chatScroll, 0.0F, Math.max(0.0F, content - visible));
      uut.pushScissor(this.ctx, cx, logTop, cw, visible);
      float lineY = logBottom - lineH / 2.0F + this.chatScroll;

      for (int i = lines.size() - 1; i >= 0 && !(lineY < logTop - lineH); i--) {
         if (lineY <= logBottom + lineH) {
            this.drawSegments(lines.get(i), logX, lineY, 6.5F);
         }

         lineY -= lineH;
      }

      uut.popScissor(this.ctx);
      this.chatField.render(cx + 4.0F, cy + ch - inputH - 4.0F, cw - 8.0F, inputH, mouseX, mouseY);
   }

   private void renderF0(dtv bot, float ax, float ay, float aw, float ah, int mouseX, int mouseY) {
      mpq fE = bot.f0ref();
      vdn font = medium(6.5F);
      float inner = ax + 6.0F;
      float innerW = aw - 12.0F;
      boolean running = bot.f0Run();
      boolean canRun = bot.getPlayer() != null;
      this.button(inner, ay + 6.0F, innerW, 18.0F, (running ? "Остановить " : "Запустить ") + vup.e(), !running && canRun, mouseX, mouseY, b -> {
         this.commitSettingFields();
         bot.setF0(!running);
      });
      String state = running ? fE.getStateDescription() + "   ваз: " + fE.getBrokenVases() : (canRun ? "остановлен" : "бот не в игре");
      this.text(font, trim(font, state, innerW), inner, ay + 32.0F, running ? text() : textDim());
      String stats = "фарм "
         + duration(fE.getFarmMillis())
         + "   ваз "
         + fE.getTotalVases()
         + "   кистей "
         + fE.getTotalBrushes()
         + (fE.getTotalSand() > 0 ? "   песка " + fE.getTotalSand() : "");
      this.text(font, trim(font, stats, innerW), inner, ay + 43.0F, textDim());
      float rowY = ay + 52.0F;
      vmo[] settings = fE.botSettings();

      for (int i = 0; i < settings.length; i++) {
         vmo setting = settings[i];
         if (isVisible(setting)) {
            if (rowY + 18.0F > ay + ah - 4.0F) {
               break;
            }

            this.settingRow(fE::onBotSettingChanged, setting, i < F0_LABELS.length ? F0_LABELS[i] : setting.getName(), inner, rowY, innerW, mouseX, mouseY);
            rowY += 20.0F;
         }
      }

      this.lootButton(fE.lootList(), inner, rowY + 2.0F, innerW, mouseX, mouseY);
      vdn tiny = medium(5.5F);
      this.text(tiny, trim(tiny, "берёт только отмеченное; список общий для всех ботов и твоего " + vup.e(), innerW), inner, ay + ah - 7.0F, textDim());
   }

   private void lootButton(vlj list, float bx, float by, float bw, int mouseX, int mouseY) {
      this.button(bx, by, bw, 16.0F, "Список лута (" + list.size() + " из " + ppu.entries().size() + ")", lootPicker, mouseX, mouseY, b -> {
         lootPicker = !lootPicker;
         this.pickerRow = 0;
      });
   }

   private void renderF1(dtv bot, float ax, float ay, float aw, float ah, int mouseX, int mouseY) {
      nxa fW = bot.f1ref();
      vdn font = medium(6.5F);
      float inner = ax + 6.0F;
      float innerW = aw - 12.0F;
      boolean running = bot.f1Run();
      boolean canRun = bot.getPlayer() != null;
      this.button(inner, ay + 6.0F, innerW, 18.0F, (running ? "Остановить " : "Запустить ") + vup.w(), !running && canRun, mouseX, mouseY, b -> {
         this.commitSettingFields();
         bot.setF1(!running);
      });
      String state = running
         ? (fW.queueNote().isEmpty() ? f1StateLabel(fW.getStateIndex()) : fW.queueNote()) + "   сундуков " + fW.getTripChests() + "/" + fW.getMaxChests()
         : (!canRun ? "бот не в игре" : (bot.f1Want() ? "запустится после входа" : "остановлен"));
      this.text(font, trim(font, state, innerW), inner, ay + 32.0F, running ? text() : textDim());
      String stats = "фарм "
         + duration(fW.getFarmMillis())
         + "   сундуков "
         + fW.getTotalChests()
         + "   заходов "
         + fW.getTotalTrips()
         + "   лут "
         + fW.getCurrentLootAnarchy();
      this.text(font, trim(font, stats, innerW), inner, ay + 43.0F, textDim());
      float rowY = ay + 52.0F;
      vmo[] settings = fW.botSettings();

      for (int i = 0; i < settings.length; i++) {
         vmo setting = settings[i];
         if (isVisible(setting)) {
            if (rowY + 18.0F > ay + ah - 4.0F) {
               break;
            }

            this.settingRow(fW::onBotSettingChanged, setting, i < F1_LABELS.length ? F1_LABELS[i] : setting.getName(), inner, rowY, innerW, mouseX, mouseY);
            rowY += 20.0F;
         }
      }

      if (rowY + 18.0F <= ay + ah - 10.0F) {
         this.lootButton(fW.lootList(), inner, rowY + 2.0F, innerW, mouseX, mouseY);
      }

      vdn tiny = medium(5.5F);
      this.text(tiny, trim(tiny, "берёт только отмеченное; список общий для всех ботов и твоего " + vup.w(), innerW), inner, ay + ah - 7.0F, textDim());
   }

   private void renderF2(dtv bot, float ax, float ay, float aw, float ah, int mouseX, int mouseY) {
      nfl fM = bot.f2ref();
      vdn font = medium(6.5F);
      float inner = ax + 6.0F;
      float innerW = aw - 12.0F;
      boolean running = bot.f2Run();
      boolean canRun = bot.getPlayer() != null;
      this.button(inner, ay + 6.0F, innerW, 18.0F, (running ? "Остановить " : "Запустить ") + vup.m(), !running && canRun, mouseX, mouseY, b -> {
         this.commitSettingFields();
         bot.setF2(!running);
      });
      String state = running ? mineStatus(bot) : (!canRun ? "бот не в игре" : (bot.f2Want() ? "запустится после входа" : "остановлен"));
      this.text(font, trim(font, state, innerW), inner, ay + 32.0F, running ? text() : textDim());
      String note = fM.lastNote() != null && !fM.lastNote().isEmpty() ? fM.lastNote() : "";
      String stats = "накопано " + fM.mined() + (note.isEmpty() ? "" : "   " + note);
      this.text(font, trim(font, stats, innerW), inner, ay + 43.0F, textDim());
      float rowY = ay + 52.0F;
      vmo[] settings = fM.botSettings();
      int shown = 0;

      for (vmo setting : settings) {
         if (isVisible(setting) && shown++ >= this.mineScroll) {
            if (rowY + 18.0F > ay + ah - 12.0F) {
               break;
            }

            this.settingRow(() -> {}, setting, wap.t(setting.getName()), inner, rowY, innerW, mouseX, mouseY);
            rowY += 20.0F;
         }
      }

      vdn tiny = medium(5.5F);
      this.text(tiny, trim(tiny, "колесо - листать; руды, мусор и остальное - как у твоего " + vup.m(), innerW), inner, ay + ah - 7.0F, textDim());
   }

   private void renderF3(dtv bot, float ax, float ay, float aw, float ah, int mouseX, int mouseY) {
      lqq farm = bot.f3ref();
      vdn font = medium(6.5F);
      float inner = ax + 6.0F;
      float innerW = aw - 12.0F;
      if (farm.isVip()) {
         float cx = ax + aw / 2.0F;
         float cy = ay + ah / 2.0F;
         float pulse = 0.5F + 0.5F * (float)Math.sin(System.nanoTime() / 4.5E8);
         uut.shadow(this.ctx, cx - 11.0F, cy - 37.0F, 22.0F, 22.0F, 11.0F, 6.0F, accent((int)(50.0F + 60.0F * pulse)));
         uut.round(this.ctx, cx - 11.0F, cy - 37.0F, 22.0F, 22.0F, 11.0F, iov.field);
         vjf.draw(this.ctx, vhz.CROWN, cx, cy - 26.0F, 12.0F, accent());
         vdn vipFont = veo.bold(6.0F);
         this.vipBadge(cx + (vipFont.width("VIP") + 11.0F) / 2.0F, cy - 6.0F, 11.0F, vipFont);
         vdn bold = semibold(7.5F);
         this.centered(bold, trim(bold, "Фарм обломков доступен только с VIP", innerW), cx, cy + 9.0F, text());
         this.centered(font, trim(font, "запуск на ботах закрыт", innerW), cx, cy + 20.0F, textDim());
      } else {
         boolean running = bot.f3Run();
         boolean canRun = bot.getPlayer() != null;
         this.button(inner, ay + 6.0F, innerW, 18.0F, (running ? "Остановить" : "Запустить") + " фарм обломков", !running && canRun, mouseX, mouseY, b -> {
            this.commitSettingFields();
            bot.setF3(!running);
         });
         String state = running ? farm.status() : (!canRun ? "бот не в игре" : (bot.f3Want() ? "запустится после входа" : "остановлен"));
         this.text(font, trim(font, state, innerW), inner, ay + 32.0F, running ? text() : textDim());
         String note = farm.lastNote() == null ? "" : farm.lastNote();
         String stats = "добыто " + farm.mined() + "  ·  взрывов " + farm.blasts() + (note.isEmpty() ? "" : "   " + note);
         this.text(font, trim(font, stats, innerW), inner, ay + 43.0F, textDim());
         float rowY = ay + 52.0F;
         int shown = 0;

         for (vmo setting : farm.botSettings()) {
            if (isVisible(setting) && shown++ >= this.mineScroll) {
               if (rowY + 18.0F > ay + ah - 12.0F) {
                  break;
               }

               this.settingRow(() -> {}, setting, wap.t(setting.getName()), inner, rowY, innerW, mouseX, mouseY);
               rowY += 20.0F;
            }
         }

         vdn tiny = medium(5.5F);
         this.text(tiny, trim(tiny, "колесо - листать; сундуки на складе: таблички «Сброс» и «Ресурсы»", innerW), inner, ay + ah - 7.0F, textDim());
      }
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
      vdn font = medium(7.0F);
      float cy = ry + 8.0F;
      if (setting instanceof vkl bool) {
         this.text(font, trim(font, label, rw - 30.0F), rx, cy, textDim());
         this.toggle(rx + rw - 20.0F, cy - 5.5F, bool.get(), mouseX, mouseY, b -> {
            bool.set(!bool.get());
            changed.run();
         });
      } else if (setting instanceof vmc number) {
         String value = number.display();
         vdn valueFont = semibold(6.5F);
         float boxW = Math.max(44.0F, valueFont.width(value) + 30.0F);
         this.text(font, trim(font, label, rw - boxW - 6.0F), rx, cy, textDim());
         float sx = rx + rw - boxW;
         uut.round(this.ctx, sx, cy - 7.0F, boxW, 14.0F, 4.5F, iov.field);
         vdn sign = medium(8.0F);
         this.centered(sign, "-", sx + 6.5F, cy, textDim());
         this.centered(sign, "+", sx + boxW - 6.5F, cy, textDim());
         this.centered(valueFont, value, sx + boxW / 2.0F, cy, text());
         this.zone(sx, cy - 7.0F, 13.0F, 14.0F, b -> {
            number.set(number.get() - number.getStep());
            changed.run();
         });
         this.zone(sx + boxW - 13.0F, cy - 7.0F, 13.0F, 14.0F, b -> {
            number.set(number.get() + number.getStep());
            changed.run();
         });
      } else if (setting instanceof vmu textSetting) {
         float labelW = Math.min(62.0F, font.width(label) + 4.0F);
         this.text(font, trim(font, label, labelW), rx, cy, textDim());
         BotScreen.Field field = this.settingFields.computeIfAbsent(textSetting, s -> {
            BotScreen.Field created = new BotScreen.Field(64, "");
            created.setText(s.get());
            created.onCommit = valuex -> {
               s.set(valuex.trim());
               changed.run();
            };
            return created;
         });
         if (field != this.focused && !field.text.equals(textSetting.get())) {
            field.setText(textSetting.get());
         }

         field.render(rx + labelW + 4.0F, ry, rw - labelW - 4.0F, 16.0F, mouseX, mouseY);
      } else if (setting instanceof vlv mode) {
         this.text(font, trim(font, label, rw - 70.0F), rx, cy, textDim());
         String value = mode.get() == null ? "-" : wap.value(mode.get());
         float bw = Math.max(40.0F, medium(6.5F).width(value) + 14.0F);
         this.smallButton(rx + rw - bw, cy - 7.0F, bw, 14.0F, value, mouseX, mouseY, b -> {
            if (!mode.getModes().isEmpty()) {
               mode.cycle();
               changed.run();
            }
         });
      }
   }

   private static vlj openPicker(dtv bot) {
      if (lootPicker && bot != null) {
         return tab == BotScreen.Tab.TAB_E ? bot.f0ref().lootList() : (tab == BotScreen.Tab.TAB_W ? bot.f1ref().lootList() : null);
      } else {
         return null;
      }
   }

   private void renderPicker(vlj pick, float px, float py, float pw, float ph, int mouseX, int mouseY) {
      uut.round(this.ctx, px, py, pw, ph, 7.0F, iov.card);
      vdn bold = semibold(7.5F);
      vdn font = medium(6.5F);
      this.text(bold, tab == BotScreen.Tab.TAB_W ? "Что лутать: " + vup.w() : "Что лутать: " + vup.e(), px + 7.0F, py + 9.0F, text());
      this.smallButton(px + pw - 50.0F, py + 3.0F, 44.0F, 12.0F, "готово", mouseX, mouseY, b -> {
         lootPicker = false;
         ConfigManager.autoSaveLater();
      });
      List<ppn> entries = ppu.entries();
      int cols = 10;
      float gx = px + (pw - cols * 20.0F) / 2.0F;
      float gy = py + 19.0F;
      float footer = 34.0F;
      int visibleRows = Math.max(1, (int)((ph - 19.0F - footer) / 20.0F));
      int rows = (entries.size() + cols - 1) / cols;
      this.pickerRow = MathHelper.clamp(this.pickerRow, 0, Math.max(0, rows - visibleRows));
      int first = this.pickerRow * cols;
      int last = Math.min(entries.size(), (this.pickerRow + visibleRows) * cols);

      for (int i = first; i < last; i++) {
         ppn entry = entries.get(i);
         int local = i - first;
         float sx = gx + local % cols * 20.0F;
         float sy = gy + local / cols * 20.0F;
         boolean chosen = pick.contains(entry.id);
         boolean hover = hovered(mouseX, mouseY, sx, sy, 19.0F, 19.0F);
         if (chosen) {
            uut.round(this.ctx, sx - 1.0F, sy - 1.0F, 21.0F, 21.0F, 5.0F, accent(230));
            uut.round(this.ctx, sx, sy, 19.0F, 19.0F, 4.5F, ujt.withAlpha(iov.window, 220));
         }

         int fill = hover ? iov.fieldHover : (chosen ? ujt.lerp(iov.field, iov.accent(), 0.28F) : ujt.shade(iov.field, 0.6F));
         uut.round(this.ctx, sx, sy, 19.0F, 19.0F, 4.5F, fill);
         ItemStack icon = entry.icon();
         this.ctx.drawItem(icon, Math.round(sx + 1.5F), Math.round(sy + 1.5F));
         if (chosen) {
            uut.round(this.ctx, sx + 20.0F - 8.0F, sy + 1.5F, 5.5F, 5.5F, 2.75F, accent());
         }

         if (hover) {
            this.hoveredStack = icon;
         }

         this.zone(sx, sy, 19.0F, 19.0F, b -> pick.toggle(entry.id));
      }

      vdn tiny = medium(5.5F);
      if (rows > visibleRows) {
         String pages = this.pickerRow + 1 + "-" + Math.min(rows, this.pickerRow + visibleRows) + " из " + rows + " рядов, колесо";
         this.text(tiny, pages, px + 7.0F, py + ph - footer + 2.0F, textDim());
      }

      float fy = py + ph - 20.0F;
      this.text(font, "отмечено " + pick.size() + " из " + entries.size(), px + 7.0F, fy + 8.0F, textDim());
      float bw = 38.0F;
      float bx = px + pw - 6.0F - bw * 3.0F - 4.0F;
      this.smallButton(bx, fy + 1.0F, bw, 14.0F, "все", mouseX, mouseY, b -> {
         List<String> all = new ArrayList<>();

         for (ppn e : entries) {
            all.add(e.id);
         }

         pick.set(all);
      });
      this.smallButton(bx + bw + 2.0F, fy + 1.0F, bw, 14.0F, "снять", mouseX, mouseY, b -> pick.clear());
      this.smallButton(bx + bw * 2.0F + 4.0F, fy + 1.0F, bw, 14.0F, "сброс", mouseX, mouseY, b -> pick.reset());
   }

   private void renderBotTab(dtv bot, float bx, float by, float bw, float bh, int mouseX, int mouseY) {
      vdn font = medium(7.0F);
      float inner = bx + 6.0F;
      float innerW = bw - 12.0F;
      float rowY = by + 6.0F;
      this.text(font, "Автопереподключение", inner, rowY + 8.0F, textDim());
      this.toggle(inner + innerW - 20.0F, rowY + 2.5F, bot.isAutoReconnect(), mouseX, mouseY, b -> bot.setAutoReconnect(!bot.isAutoReconnect()));
      rowY += 20.0F;
      this.text(font, bot.hasLoginCommand() ? "/login запомнен, сохранён" : "/login не запомнен", inner, rowY + 8.0F, textDim());
      if (bot.hasLoginCommand()) {
         this.smallButton(inner + innerW - 44.0F, rowY + 1.0F, 44.0F, 14.0F, "забыть", mouseX, mouseY, b -> bot.forgetLogin());
      }

      rowY += 20.0F;
      this.text(font, "Прогрузка чанков", inner, rowY + 8.0F, textDim());
      float sx = inner + innerW - 44.0F;
      uut.round(this.ctx, sx, rowY + 1.0F, 44.0F, 14.0F, 4.5F, iov.field);
      vdn sign = medium(8.0F);
      this.centered(sign, "-", sx + 6.5F, rowY + 8.0F, textDim());
      this.centered(sign, "+", sx + 37.5F, rowY + 8.0F, textDim());
      this.centered(semibold(6.5F), String.valueOf(egq.get().getViewDistance()), sx + 22.0F, rowY + 8.0F, text());
      this.zone(sx, rowY + 1.0F, 13.0F, 14.0F, b -> this.changeViewDistance(-1));
      this.zone(sx + 31.0F, rowY + 1.0F, 13.0F, 14.0F, b -> this.changeViewDistance(1));
      rowY += 20.0F;
      this.text(font, "Адрес", inner, rowY + 8.0F, textDim());
      this.botAddressField.render(inner + 32.0F, rowY, innerW - 32.0F, 16.0F, mouseX, mouseY);
      rowY += 24.0F;
      boolean connected = bot.getStatus() != dts.OFFLINE && bot.getStatus() != dts.FAILED;
      float half = (innerW - 4.0F) / 2.0F;
      this.button(inner, rowY, half, 16.0F, connected ? "Отключить" : "Подключить", false, mouseX, mouseY, b -> {
         this.commitSettingFields();
         if (connected) {
            bot.disconnect();
         } else {
            bot.connect();
         }
      });
      this.button(inner + half + 4.0F, rowY, half, 16.0F, "Переподключить", false, mouseX, mouseY, b -> {
         this.commitSettingFields();
         bot.disconnect();
         bot.connect();
      });
      rowY += 20.0F;
      this.button(inner, rowY, half, 16.0F, "Возродить", false, mouseX, mouseY, b -> bot.respawn());
      this.button(inner + half + 4.0F, rowY, half, 16.0F, "Закрыть экран", false, mouseX, mouseY, b -> bot.closeScreen());
      rowY += 20.0F;
      this.button(inner, rowY, innerW, 16.0F, "Удалить бота", false, mouseX, mouseY, b -> {
         egq.get().remove(bot);
         selected = egq.get().getBots().isEmpty() ? null : egq.get().getBots().get(0);
         this.syncBotFields();
      });
      rowY += 26.0F;
      vdn small = medium(6.5F);
      String stats = String.format(
         Locale.ROOT, "тик %.2f мс   очередь %d   пинг %s", bot.getTickMillis(), bot.getPendingPackets(), bot.getPing() < 0 ? "-" : bot.getPing() + " мс"
      );
      this.text(small, trim(small, stats, innerW), inner, rowY, textDim());
      this.text(small, trim(small, "статус: " + bot.getStatusText(), innerW), inner, rowY + 10.0F, textDim());
   }

   private void renderAll(float ax, float ay, float aw, float ah, int mouseX, int mouseY) {
      vdn font = medium(6.5F);
      vdn bold = semibold(6.5F);
      vdn title = semibold(7.5F);
      float inner = ax + 6.0F;
      float innerW = aw - 12.0F;
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
            online++;
         }

         if (bot.isActive()) {
            running++;
         }
      }

      float rowY = ay + 6.0F;
      this.text(title, "Все боты", inner, rowY + 5.0F, text());
      this.text(font, "фармят " + running + " из " + online, inner + title.width("Все боты") + 6.0F, rowY + 5.0F, textDim());
      this.smallButton(inner + innerW - 34.0F, rowY - 1.0F, 34.0F, 12.0F, "сброс", mouseX, mouseY, b -> egq.get().resetFarmStats());
      if (online < bots.size()) {
         this.smallButton(inner + innerW - 34.0F - 4.0F - 52.0F, rowY - 1.0F, 52.0F, 12.0F, "войти всем", mouseX, mouseY, b -> {
            int count = egq.get().connectAll();
            this.notice(count == 0 ? "все уже в игре или заходят" : "по очереди заходят: " + count);
         });
      }

      rowY += 16.0F;
      float half = (innerW - 4.0F) / 2.0F;
      this.statRow("Время фарма", duration(farm), inner, rowY, half);
      this.statRow("Сундуков", String.valueOf(chests), inner + half + 4.0F, rowY, half);
      rowY += 11.0F;
      this.statRow("Ваз", String.valueOf(vases), inner, rowY, half);
      this.statRow("Кистей", String.valueOf(brushes), inner + half + 4.0F, rowY, half);
      rowY += 13.0F;
      float third = (innerW - 8.0F) / 3.0F;
      this.button(inner, rowY, third, 16.0F, vup.e() + " всем", true, mouseX, mouseY, b -> {
         this.commitSettingFields();
         this.notice("запуск у " + egq.get().setF0All(true) + " ботов, по очереди");
      });
      this.button(inner + third + 4.0F, rowY, third, 16.0F, "Варден всем", true, mouseX, mouseY, b -> {
         this.commitSettingFields();
         this.notice(vup.w() + " у " + egq.get().setF1All(true) + " ботов, анархии лута вразнобой");
      });
      this.button(inner + third * 2.0F + 8.0F, rowY, third, 16.0F, "Шахта всем", true, mouseX, mouseY, b -> {
         this.commitSettingFields();
         this.notice(vup.m() + " у " + egq.get().setF2All(true) + " ботов, по очереди");
      });
      rowY += 19.0F;
      float half2 = (innerW - 4.0F) / 2.0F;
      lqq farmer = lqq.get();
      boolean farmerVip = farmer == null || farmer.isVip();
      this.button(inner, rowY, half2, 16.0F, "Обломки всем", !farmerVip, mouseX, mouseY, b -> {
         this.commitSettingFields();
         this.notice(farmerVip ? "фарм обломков доступен только с VIP" : "фарм обломков у " + egq.get().setF3All(true) + " ботов, по очереди");
      });
      if (farmerVip) {
         this.vipBadge(inner + half2 - 1.0F, rowY, 7.0F, veo.bold(4.5F));
      }

      this.button(
         inner + half2 + 4.0F, rowY, half2, 16.0F, "Стоп всем", false, mouseX, mouseY, b -> this.notice("остановка у " + egq.get().stopAll() + " ботов")
      );
      rowY += 22.0F;
      float fieldY = ay + ah - 20.0F;
      float listBottom = fieldY - 12.0F;
      long since = egq.get().getLastBroadcast();
      boolean replies = since > 0L && System.currentTimeMillis() - since < 30000L;
      int shown = 0;

      for (dtv bot : bots) {
         if (rowY + 10.0F > listBottom) {
            this.text(font, "и ещё " + (bots.size() - shown), inner, rowY + 4.0F, textDim());
            break;
         }

         float cy = rowY + 5.0F;
         uut.round(this.ctx, inner, cy - 2.5F, 5.0F, 5.0F, 2.0F, statusColor(bot.getStatus()));
         String name = trim(bold, bot.getName(), innerW * 0.45F);
         this.text(bold, name, inner + 8.0F, cy, text());
         float restX = inner + 8.0F + bold.width(name) + 6.0F;
         float restW = inner + innerW - restX;
         boolean target = replies && egq.get().wasBroadcastTarget(bot);
         if (bot.getStatus() == dts.ONLINE && bot.getCaptcha().isPresent()) {
            this.text(font, "капча", restX, cy, -1526966);
         } else if (target && bot.getLastSent() < since) {
            this.text(font, "в очереди", restX, cy, textDim());
         } else if (target) {
            Text reply = bot.replyToLastSent();
            if (reply != null) {
               this.styled(reply, restX, cy, 6.0F, restW);
            } else {
               this.text(font, "отправлено", restX, cy, textDim());
            }
         } else if (bot.f2Run()) {
            String line = "шахта  ·  " + bot.f2ref().mined() + "  ·  " + mineStatus(bot);
            this.text(font, trim(font, line, restW), restX, cy, textDim());
         } else if (bot.f3Run()) {
            String line = "обломки  ·  " + bot.f3ref().mined() + "  ·  " + bot.f3ref().status();
            this.text(font, trim(font, line, restW), restX, cy, textDim());
         } else if (!bot.f1Run() && bot.f1ref().getTotalChests() <= 0) {
            mpq fE = bot.f0ref();
            String line = duration(fE.getFarmMillis())
               + "  ·  "
               + fE.getTotalVases()
               + " ваз"
               + (fE.getTotalBrushes() > 0 ? "  ·  " + fE.getTotalBrushes() + " кист." : "");
            this.text(font, trim(font, line, restW), restX, cy, textDim());
         } else {
            nxa fW = bot.f1ref();
            String line = fW.getCurrentLootAnarchy()
               + "  ·  "
               + duration(fW.getFarmMillis())
               + "  ·  "
               + fW.getTotalChests()
               + " сунд."
               + (fW.isEnabled() ? "  ·  " + f1StateLabel(fW.getStateIndex()) : "");
            this.text(font, trim(font, line, restW), restX, cy, textDim());
         }

         this.zone(inner, rowY, innerW, 10.0F, b -> {
            selected = bot;
            this.chatScroll = 0.0F;
            this.syncBotFields();
         });
         rowY += 11.0F;
         shown++;
      }

      boolean fresh = this.allNotice != null && System.currentTimeMillis() - this.allNoticeTime < 5000L;
      String hint = fresh ? this.allNotice : "Enter - всем в игре, по очереди";
      vdn tiny = medium(5.5F);
      this.text(tiny, trim(tiny, hint, innerW), inner, fieldY - 6.0F, fresh ? text() : textDim());
      this.broadcastField.render(ax + 4.0F, fieldY, aw - 8.0F, 16.0F, mouseX, mouseY);
   }

   private void statRow(String label, String value, float rx, float ry, float rw) {
      vdn font = medium(6.5F);
      vdn bold = semibold(6.5F);
      float cy = ry + 5.0F;
      this.text(font, label, rx, cy, textDim());
      this.text(bold, value, rx + rw - bold.width(value), cy, text());
   }

   private void notice(String message) {
      this.allNotice = message;
      this.allNoticeTime = System.currentTimeMillis();
   }

   private void broadcast() {
      String message = this.broadcastField.text.trim();
      if (!message.isEmpty()) {
         int count = egq.get().broadcast(message);
         this.notice(count == 0 ? "никого нет в игре" : "\"" + message + "\" - " + count + " " + bots(count) + ", по очереди");
         this.remember(message);
         this.broadcastField.setText("");
         this.historyIndex = -1;
      }
   }

   private static String bots(int count) {
      int mod10 = count % 10;
      int mod100 = count % 100;
      return mod10 == 1 && mod100 != 11 ? "боту" : "ботам";
   }

   private static String duration(long millis) {
      long seconds = Math.max(0L, millis / 1000L);
      long hours = seconds / 3600L;
      long minutes = seconds / 60L % 60L;
      if (hours > 0L) {
         return hours + " ч " + minutes + " мин";
      } else {
         return minutes > 0L ? minutes + " мин " + seconds % 60L + " с" : seconds + " с";
      }
   }

   private void changeViewDistance(int delta) {
      egq.get().setViewDistance(egq.get().getViewDistance() + delta);

      for (dtv bot : egq.get().getBots()) {
         bot.syncOptionsLive();
      }
   }

   private void button(float bx, float by, float bw, float bh, String label, boolean primary, int mouseX, int mouseY, IntConsumer action) {
      boolean hover = hovered(mouseX, mouseY, bx, by, bw, bh);
      vdn font = medium(7.0F);
      if (primary) {
         uut.round(this.ctx, bx, by, bw, bh, 5.0F, accent(hover ? 255 : 220));
         this.centered(font, label, bx + bw / 2.0F, by + bh / 2.0F, iov.onAccent());
      } else {
         uut.round(this.ctx, bx, by, bw, bh, 5.0F, hover ? iov.cardHover : iov.field);
         this.centered(font, label, bx + bw / 2.0F, by + bh / 2.0F, text());
      }

      this.zone(bx, by, bw, bh, action);
   }

   private void vipBadge(float right, float top, float height, vdn font) {
      float bw = font.width("VIP") + height;
      float bx = right - bw;
      float by = top - height / 2.0F;
      float r = height / 2.0F;
      uut.shadow(this.ctx, bx, by, bw, height, r, 2.5F, accent(110));
      uut.gradientH(this.ctx, bx, by, bw, height, r, iov.accent(), iov.accent2());
      this.centered(font, "VIP", bx + bw / 2.0F, by + height / 2.0F, iov.onAccent());
   }

   private void smallButton(float bx, float by, float bw, float bh, String label, int mouseX, int mouseY, IntConsumer action) {
      boolean hover = hovered(mouseX, mouseY, bx, by, bw, bh);
      uut.round(this.ctx, bx, by, bw, bh, 4.0F, hover ? iov.fieldHover : iov.field);
      this.centered(medium(6.5F), label, bx + bw / 2.0F, by + bh / 2.0F, text());
      this.zone(bx, by, bw, bh, action);
   }

   private void chip(float bx, float by, String label, boolean active, int mouseX, int mouseY, IntConsumer action) {
      vdn font = medium(6.0F);
      float bw = font.width(label) + 10.0F;
      boolean hover = hovered(mouseX, mouseY, bx, by, bw, 12.0F);
      uut.round(this.ctx, bx, by, bw, 12.0F, 4.0F, active ? accent(220) : (hover ? 687865855 : 385875967));
      this.centered(font, label, bx + bw / 2.0F, by + 6.0F, active ? iov.onAccent() : -1644306);
      this.zone(bx, by, bw, 12.0F, action);
   }

   private void toggle(float tx, float ty, boolean value, int mouseX, int mouseY, IntConsumer action) {
      boolean hover = hovered(mouseX, mouseY, tx - 4.0F, ty - 3.0F, 28.0F, 17.0F);
      int track = value ? accent(245) : (hover ? iov.fieldHover : iov.track);
      int knob = value ? iov.onAccent() : iov.knob;
      uut.round(this.ctx, tx, ty, 20.0F, 11.0F, 4.625F, track);
      uut.round(this.ctx, tx + 1.5F + (value ? 9.0F : 0.0F), ty + 1.5F, 8.0F, 8.0F, 3.125F, knob);
      this.zone(tx - 4.0F, ty - 3.0F, 28.0F, 17.0F, action);
   }

   private void zone(float zx, float zy, float zw, float zh, IntConsumer action) {
      this.zones.add(new BotScreen.Zone(zx, zy, zw, zh, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, action));
   }

   private void zoneClip(float zx, float zy, float zw, float zh, float clipTop, float clipBottom, IntConsumer action) {
      this.zones.add(new BotScreen.Zone(zx, zy, zw, zh, clipTop, clipBottom, action));
   }

   private void setControl(boolean on) {
      this.control = on;
      this.keyForward = this.keyBack = this.keyLeft = this.keyRight = this.keyJump = this.keySneak = this.keySprint = false;
      this.mouseAttack = this.mouseUse = false;
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

   @Override
   public boolean mouseClicked(Click click, boolean doubled) {
      double mouseX = click.x() / this.scale;
      double mouseY = click.y() / this.scale;
      int button = click.button();
      BotScreen.Field previous = this.focused;
      this.focused = null;

      for (BotScreen.Field field : this.allFields()) {
         if (field.visible && hovered(mouseX, mouseY, field.x, field.y, field.w, field.h)) {
            this.focused = field;
            field.cursor = field.text.length();
            break;
         }
      }

      if (previous != null && previous != this.focused) {
         previous.commit();
      }

      if (this.focused != null) {
         return true;
      }

      if (this.control && this.viewShown && selected != null && hovered(mouseX, mouseY, this.viewX, this.viewY + 16.0F, this.viewW, this.viewH - 16.0F)) {
         if (button == 0) {
            this.mouseAttack = true;
         } else if (button == 1) {
            this.mouseUse = true;
         } else if (button == 2) {
            this.rotating = true;
         }

         selected.getControl().setMouse(this.mouseAttack, this.mouseUse);
         return true;
      } else {
         for (int i = this.zones.size() - 1; i >= 0; i--) {
            BotScreen.Zone zone = this.zones.get(i);
            if (zone.contains(mouseX, mouseY)) {
               zone.action.accept(button);
               return true;
            }
         }

         if (hovered(mouseX, mouseY, this.x, this.y, 600.0F, 20.0F)) {
            this.dragging = true;
            this.dragX = mouseX - posX;
            this.dragY = mouseY - posY;
            return true;
         } else {
            return hovered(mouseX, mouseY, this.x, this.y, 600.0F, 318.0F) || super.mouseClicked(click, doubled);
         }
      }
   }

   @Override
   public boolean mouseReleased(Click click) {
      int button = click.button();
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

      return super.mouseReleased(click);
   }

   @Override
   public boolean mouseDragged(Click click, double offsetX, double offsetY) {
      if (this.dragging) {
         posX = (float)(click.x() / this.scale - this.dragX);
         posY = (float)(click.y() / this.scale - this.dragY);
         return true;
      } else if (this.rotating && this.control && selected != null && this.client != null) {
         double scale = this.client.getWindow().getScaleFactor();
         selected.getControl().addLook(offsetX * scale, offsetY * scale);
         return true;
      } else {
         return super.mouseDragged(click, offsetX, offsetY);
      }
   }

   @Override
   public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
      double mouseXx = mouseX / this.scale;
      double mouseYx = mouseY / this.scale;
      float listRight = this.x + 6.0F + 146.0F;
      if (mouseXx < listRight && hovered(mouseXx, mouseYx, this.x, this.y, 600.0F, 318.0F)) {
         this.listScroll += (float)verticalAmount * 20.0F;
         return true;
      }

      float middle = this.x + 6.0F + 146.0F + 6.0F;
      if (openPicker(selected) != null && mouseXx >= middle && mouseXx <= middle + 226.0F && hovered(mouseXx, mouseYx, this.x, this.y, 600.0F, 318.0F)) {
         this.pickerRow = this.pickerRow - (int)Math.signum(verticalAmount);
         return true;
      }

      if ((tab == BotScreen.Tab.TAB_M || tab == BotScreen.Tab.TAB_D) && mouseXx > this.x + 6.0F + 146.0F + 6.0F + 226.0F && selected != null) {
         int count = 0;

         for (vmo setting : tab == BotScreen.Tab.TAB_D ? selected.f3ref().botSettings() : selected.f2ref().botSettings()) {
            if (isVisible(setting)) {
               count++;
            }
         }

         this.mineScroll = MathHelper.clamp(this.mineScroll - (int)Math.signum(verticalAmount), 0, Math.max(0, count - 5));
         return true;
      } else if (tab == BotScreen.Tab.CHAT && mouseXx > this.x + 6.0F + 146.0F + 6.0F + 226.0F) {
         this.chatScroll += (float)verticalAmount * 17.0F;
         return true;
      } else if (this.control
         && this.viewShown
         && selected != null
         && selected.getPlayer() != null
         && hovered(mouseXx, mouseYx, this.viewX, this.viewY, this.viewW, this.viewH)) {
         int slot = selected.getPlayer().getInventory().getSelectedSlot();
         slot = Math.floorMod(slot - (int)Math.signum(verticalAmount), 9);
         selected.selectSlot(slot);
         return true;
      } else {
         return super.mouseScrolled(mouseX, mouseY, horizontalAmount, verticalAmount);
      }
   }

   @Override
   public boolean keyPressed(KeyInput input) {
      int keyCode = input.key();
      int modifiers = input.modifiers();
      if (this.focused != null) {
         if (keyCode == 256) {
            this.focused.commit();
            this.focused = null;
            return true;
         }

         if (keyCode != 257 && keyCode != 335) {
            if ((this.focused == this.chatField || this.focused == this.broadcastField) && (keyCode == 265 || keyCode == 264)) {
               this.browseHistory(this.focused, keyCode == 265 ? 1 : -1);
               return true;
            } else {
               this.focused.key(keyCode, modifiers);
               return true;
            }
         } else {
            this.submit(this.focused);
            return true;
         }
      } else {
         if (keyCode == 256) {
            this.close();
            return true;
         }

         boolean ctrl = (modifiers & 2) != 0;
         if (selected != null && selected.getPlayer() != null) {
            if (keyCode >= 49 && keyCode <= 57) {
               int index = keyCode - 49;
               if (this.hoveredSlot != null && this.hoveredHandler != null) {
                  selected.clickSlot(this.hoveredHandler.syncId, this.hoveredHandler.slots.indexOf(this.hoveredSlot), index, SlotActionType.SWAP);
               } else if (this.control) {
                  selected.selectSlot(index);
               }

               return true;
            }

            if (keyCode == 81) {
               if (this.hoveredSlot != null && this.hoveredHandler != null) {
                  selected.clickSlot(this.hoveredHandler.syncId, this.hoveredHandler.slots.indexOf(this.hoveredSlot), ctrl ? 1 : 0, SlotActionType.THROW);
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
            BotScreen.Field target;
            if (tab == BotScreen.Tab.ALL) {
               target = this.broadcastField;
            } else if (keyCode == 84 && selected.getCaptcha().isShown()) {
               target = this.captchaField;
            } else {
               tab = BotScreen.Tab.CHAT;
               target = this.chatField;
            }

            this.focused = target;
            if (keyCode == 47 && target.text.isEmpty()) {
               target.setText("/");
            }

            return true;
         } else {
            return super.keyPressed(input);
         }
      }
   }

   @Override
   public boolean keyReleased(KeyInput input) {
      return this.control && this.movementKey(input, false) ? true : super.keyReleased(input);
   }

   @Override
   public boolean charTyped(CharInput input) {
      if (this.focused == null) {
         return super.charTyped(input);
      }

      if (input.isValidChar()) {
         for (char c : input.asString().toCharArray()) {
            this.focused.type(c);
         }
      }

      return true;
   }

   private boolean movementKey(KeyInput input, boolean down) {
      if (this.client == null) {
         return false;
      }

      GameOptions options = this.client.options;
      if (options.forwardKey.matchesKey(input)) {
         this.keyForward = down;
      } else if (options.backKey.matchesKey(input)) {
         this.keyBack = down;
      } else if (options.leftKey.matchesKey(input)) {
         this.keyLeft = down;
      } else if (options.rightKey.matchesKey(input)) {
         this.keyRight = down;
      } else if (options.jumpKey.matchesKey(input)) {
         this.keyJump = down;
      } else if (options.sneakKey.matchesKey(input)) {
         this.keySneak = down;
      } else {
         if (!options.sprintKey.matchesKey(input)) {
            return false;
         }

         this.keySprint = down;
      }

      return true;
   }

   private void submit(BotScreen.Field field) {
      if (field == this.chatField) {
         String message = this.chatField.text.trim();
         if (!message.isEmpty() && selected != null) {
            selected.sendChat(message);
            this.remember(message);
            this.chatScroll = 0.0F;
         }

         this.chatField.setText("");
         this.historyIndex = -1;
      } else if (field == this.broadcastField) {
         this.broadcast();
      } else if (field == this.captchaField) {
         this.submitCaptcha();
      } else if (field != this.nickField && field != this.addressField) {
         field.commit();
         this.focused = null;
      } else {
         this.addBot();
      }
   }

   private void remember(String message) {
      this.sentHistory.remove(message);
      this.sentHistory.add(0, message);
      if (this.sentHistory.size() > 50) {
         this.sentHistory.remove(this.sentHistory.size() - 1);
      }
   }

   private void browseHistory(BotScreen.Field field, int direction) {
      if (!this.sentHistory.isEmpty()) {
         this.historyIndex = MathHelper.clamp(this.historyIndex + direction, -1, this.sentHistory.size() - 1);
         field.setText(this.historyIndex < 0 ? "" : this.sentHistory.get(this.historyIndex));
      }
   }

   private List<BotScreen.Field> allFields() {
      List<BotScreen.Field> fields = new ArrayList<>();
      fields.add(this.nickField);
      fields.add(this.addressField);
      fields.add(this.chatField);
      fields.add(this.botAddressField);
      fields.add(this.broadcastField);
      fields.add(this.captchaField);
      fields.addAll(this.settingFields.values());
      return fields;
   }

   private List<List<BotScreen.Seg>> wrapChat(List<ech> source, float maxWidth) {
      vdn font = medium(6.5F);
      List<List<BotScreen.Seg>> out = new ArrayList<>();

      for (ech line : source) {
         int base = line.kind == ece.SYSTEM ? -6643542 : (line.kind == ece.OWN ? -4663041 : -1644306);
         List<BotScreen.Seg> segments = segments(line.text, base);
         List<BotScreen.Seg> current = new ArrayList<>();
         float used = 0.0F;

         for (BotScreen.Seg seg : segments) {
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < seg.text.length(); i++) {
               char c = seg.text.charAt(i);
               float cw = font.width(String.valueOf(c));
               if (used + cw > maxWidth && used > 0.0F) {
                  if (builder.length() > 0) {
                     current.add(new BotScreen.Seg(builder.toString(), seg.color));
                     builder.setLength(0);
                  }

                  out.add(current);
                  current = new ArrayList<>();
                  used = 0.0F;
               }

               builder.append(c);
               used += cw;
            }

            if (builder.length() > 0) {
               current.add(new BotScreen.Seg(builder.toString(), seg.color));
            }
         }

         out.add(current);
      }

      return out;
   }

   private static List<BotScreen.Seg> segments(Text text, int base) {
      List<BotScreen.Seg> out = new ArrayList<>();
      text.visit((style, string) -> {
         TextColor color = style.getColor();
         int styleColor = color == null ? base : 0xFF000000 | color.getRgb();
         legacy(string, styleColor, out);
         return Optional.empty();
      }, Style.EMPTY);
      return out;
   }

   private static void legacy(String string, int start, List<BotScreen.Seg> out) {
      int color = start;
      StringBuilder builder = new StringBuilder();

      for (int i = 0; i < string.length(); i++) {
         char c = string.charAt(i);
         if (c == 167 && i + 1 < string.length()) {
            char code = Character.toLowerCase(string.charAt(i + 1));
            int next = color;
            int skip = 1;
            if (code == 'x' && i + 13 < string.length()) {
               StringBuilder hex = new StringBuilder();

               for (int k = 0; k < 6; k++) {
                  hex.append(string.charAt(i + 3 + k * 2));
               }

               try {
                  next = 0xFF000000 | Integer.parseInt(hex.toString(), 16);
                  skip = 13;
               } catch (NumberFormatException var12) {
               }
            } else if (code >= '0' && code <= '9') {
               next = LEGACY[code - '0'];
            } else if (code >= 'a' && code <= 'f') {
               next = LEGACY['\n' + code - 97];
            } else if (code == 'r') {
               next = start;
            }

            if (builder.length() > 0) {
               out.add(new BotScreen.Seg(builder.toString(), color));
               builder.setLength(0);
            }

            color = next;
            i += skip;
         } else {
            builder.append(c);
         }
      }

      if (builder.length() > 0) {
         out.add(new BotScreen.Seg(builder.toString(), color));
      }
   }

   private void drawSegments(List<BotScreen.Seg> segments, float sx, float centerY, float size) {
      vdn font = medium(size);
      float cursor = sx;

      for (BotScreen.Seg seg : segments) {
         this.text(font, seg.text, cursor, centerY, seg.color);
         cursor += font.width(seg.text);
      }
   }

   private void styled(Text value, float left, float centerY, float size, float maxWidth) {
      vdn font = medium(size);
      float cursor = left;
      float end = left + maxWidth;

      for (BotScreen.Seg seg : segments(value, -1644306)) {
         String part = trim(font, seg.text, end - cursor);
         this.text(font, part, cursor, centerY, seg.color);
         cursor += font.width(part);
         if (cursor >= end || part.endsWith("..")) {
            break;
         }
      }
   }

   private void styledCentered(Text value, float centerX, float centerY, float size, float maxWidth) {
      vdn font = medium(size);
      List<BotScreen.Seg> segments = segments(value, -1);
      float total = 0.0F;

      for (BotScreen.Seg seg : segments) {
         total += font.width(seg.text);
      }

      float cursor = centerX - Math.min(total, maxWidth) / 2.0F;
      float end = cursor + maxWidth;

      for (BotScreen.Seg seg : segments) {
         String part = trim(font, seg.text, end - cursor);
         this.text(font, part, cursor, centerY, seg.color);
         cursor += font.width(part);
         if (cursor >= end) {
            break;
         }
      }
   }

   private static int statusColor(dts status) {
      return switch (status) {
         case ONLINE -> -10758549;
         case QUEUED, CONNECTING, LOGIN, JOINING -> -1526966;
         case FAILED -> -2073765;
         default -> -7630435;
      };
   }

   private static String dimensionName(String path) {
      if (path.contains("end")) {
         return "Энд";
      } else if (path.contains("nether")) {
         return "Ад";
      } else {
         return path.contains("overworld") ? "Обычный мир" : path;
      }
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
      return mouseX >= hx && mouseX <= hx + hw && mouseY >= hy && mouseY <= hy + hh;
   }

   private void text(vdn font, String string, float tx, float centerY, int color) {
      if (string != null && !string.isEmpty()) {
         font.draw(this.ctx, string, Math.round(tx), font.centerTop(centerY), color);
      }
   }

   private void centered(vdn font, String string, float centerX, float centerY, int color) {
      this.text(font, string, centerX - font.width(string) / 2.0F, centerY, color);
   }

   private static String trim(vdn font, String string, float maxWidth) {
      if (string == null) {
         return "";
      }

      if (!(maxWidth <= 0.0F) && !(font.width(string) <= maxWidth)) {
         StringBuilder builder = new StringBuilder();

         for (char c : string.toCharArray()) {
            if (font.width(builder.toString() + c + "..") > maxWidth) {
               break;
            }

            builder.append(c);
         }

         return builder + "..";
      } else {
         return string;
      }
   }

   private record ChatCache(dtv bot, int revision, float width, List<List<BotScreen.Seg>> lines) {
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
            uut.round(BotScreen.this.ctx, fx - 1.0F, fy - 1.0F, fw + 2.0F, fh + 2.0F, 5.5F, BotScreen.accent(170));
         }

         uut.round(BotScreen.this.ctx, fx, fy, fw, fh, 5.0F, isFocused ? ujt.withAlpha(iov.window, 240) : (hover ? iov.fieldHover : iov.field));
         vdn font = BotScreen.medium(7.0F);
         float inner = fw - 10.0F;
         float cy = fy + fh / 2.0F;
         if (this.text.isEmpty() && !isFocused) {
            BotScreen.this.text(font, BotScreen.trim(font, this.placeholder, inner), fx + 5.0F, cy, BotScreen.textDim());
         } else {
            String before = this.text.substring(0, Math.min(this.cursor, this.text.length()));
            float caret = font.width(before);
            float shift = Math.max(0.0F, caret - inner + 2.0F);
            uut.pushScissor(BotScreen.this.ctx, fx + 3.0F, fy, fw - 6.0F, fh);
            BotScreen.this.text(font, this.text, fx + 5.0F - shift, cy, BotScreen.text());
            if (isFocused && System.currentTimeMillis() / 500L % 2L == 0L) {
               uut.rect(BotScreen.this.ctx, fx + 5.0F - shift + caret, cy - 4.5F, 1.0F, 9.0F, BotScreen.text());
            }

            uut.popScissor(BotScreen.this.ctx);
         }
      }

      void key(int keyCode, int modifiers) {
         boolean ctrl = (modifiers & 2) != 0;
         if (keyCode == 259 && this.cursor > 0) {
            this.text = this.text.substring(0, this.cursor - 1) + this.text.substring(this.cursor);
            this.cursor--;
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
         } else if (ctrl && keyCode == 86 && BotScreen.this.client != null) {
            String clip = BotScreen.this.client.keyboard.getClipboard();
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
         if (chr >= ' ' && chr != 127 && chr != 167 && this.text.length() < this.max) {
            this.text = this.text.substring(0, this.cursor) + chr + this.text.substring(this.cursor);
            this.cursor++;
         }
      }
   }

   private record Seg(String text, int color) {
   }

   private enum Tab {
      CHAT,
      TAB_E,
      TAB_W,
      TAB_M,
      TAB_D,
      BOT,
      ALL;
   }

   private record Zone(float x, float y, float w, float h, float clipTop, float clipBottom, IntConsumer action) {
      boolean contains(double mouseX, double mouseY) {
         return !(mouseY < this.clipTop) && !(mouseY > this.clipBottom) ? BotScreen.hovered(mouseX, mouseY, this.x, this.y, this.w, this.h) : false;
      }
   }
}
