package a;

import com.mojang.blaze3d.textures.GpuTextureView;
import flow.dev.a;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.BossBarHud;
import net.minecraft.client.gui.hud.ClientBossBar;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.util.InputUtil;

public final class izx {
   public static final vkl ENABLED = new vkl(a.d("너좤䉦", -607459147, 801397238), true);
   public static final vlv BACKGROUND = new vlv(
      a.b("硭ǿ謮ᕗ麌ᠨꉦ⮍뗉㽲", 353073189), a.b("櫡፬馼߈谒", -879924553), a.b("攡\u1cbb陥ࠆ菑", -267819677), a.d("즛뀖㫆꒲⽨", 1581166602, 1982495175)
   );
   public static final vmc OPACITY = new vmc(a.c(604394798, "啦⳨ꘪ㡙뎄㔨轶"), 0.75, 0.3, 1.0, 0.05).percent();
   public static final vmc SCALE = new vmc(a.d("趇\uf40c绌\ue0a2", 250645634, 1982595410), 1.0, 0.6, 1.6, 0.05).percent();
   public static final vkl ARRANGE = new vkl(a.c(1293471158, "췸둺㺩ꃋ⬓궫\u17fa鹎X諮൳\uf741禝\ue025橣"), true);
   public static final List<vmo> LOOK = List.of(BACKGROUND, OPACITY, SCALE, ARRANGE);
   public static final jlx WATERMARK = new jlx();
   public static final jjx TARGET = new jjx();
   public static final jef KEYBINDS = new jef();
   public static final jie POTIONS = new jie();
   public static final izj COOLDOWNS = new izj();
   public static final jdc ITEMS = new jdc();
   public static final ixu ARMOR = new ixu();
   public static final List<jcs> ELEMENTS = List.of(KEYBINDS, POTIONS, COOLDOWNS, ITEMS, ARMOR, TARGET, WATERMARK);
   private static final int izy = 2;
   static final vdn BRAND = veo.semibold(7.6F);
   static final vdn HEAD = veo.semibold(6.8F);
   static final vdn TEXT = veo.medium(6.6F);
   static final vdn VALUE = veo.semibold(6.2F);
   static final vdn SMALL = veo.medium(5.2F);
   static final vdn TITLE = veo.semibold(7.2F);
   static final vdn SUB = veo.regular(6.1F);
   static final vdn RING = veo.semibold(7.4F);
   static final vdn TINY = veo.medium(4.4F);
   private static final float izz = 4.0F;
   private static final float jaa = 4.0F;
   private static final float jab = 4.0F;
   private static final float jac = 5.0F;
   private static long jad = -1L;
   private static GpuTextureView jae;
   private static boolean jaf = true;
   private static boolean jag;
   private static float jah = -1000.0F;
   private static float jai = -1000.0F;
   private static float jaj = 1.0F;
   private static jcs jak;
   private static float jal;
   private static float jam;
   private static float jan = Float.NaN;
   private static float jao = Float.NaN;
   private static final Map<jcs, vcj> jap = new LinkedHashMap<>();
   private static Field jaq;
   private static boolean jar;
   private static float jas;
   private static long jat;
   private static int jau;
   private static jcs jav;
   private static float jaw;
   private static float jax;

   private izx() {
   }

   public static void render(DrawContext var0, RenderTickCounter var1) {
      MinecraftClient var2 = MinecraftClient.getInstance();
      if (!(var2.currentScreen instanceof hlc) && !(var2.currentScreen instanceof jbs)) {
         uut.beginFrame();
         boolean var3 = var2.currentScreen instanceof ChatScreen;
         float var4 = var3 ? (float)var2.mouse.getScaledX(var2.getWindow()) : -1000.0F;
         float var5 = var3 ? (float)var2.mouse.getScaledY(var2.getWindow()) : -1000.0F;
         if (!var3) {
            mouseReleased();
         }

         long var6 = System.nanoTime();
         jba(var0, false, var3, var4, var5);
         jat = jat + (System.nanoTime() - var6);
         jau++;
      }
   }

   public static double cpuMicros() {
      double var0 = jau == 0 ? 0.0 : jat / 1000.0 / jau;
      jat = 0L;
      jau = 0;
      return var0;
   }

   public static void renderInMenu(DrawContext var0, boolean var1) {
      jba(var0, var1, false, -1000.0F, -1000.0F);
   }

   static void renderEditor(DrawContext var0) {
      jba(var0, true, false, -1000.0F, -1000.0F);
   }

   private static void jba(DrawContext var0, boolean var1, boolean var2, float var3, float var4) {
      MinecraftClient var5 = MinecraftClient.getInstance();
      unf.observe(var0);
      if (unf.frame() != jad) {
         jad = unf.frame();
         boolean var6 = ENABLED.get() && var5.player != null && var5.world != null;
         jgn.tick(var6 && WATERMARK.enabled.get() && jlx.MUSIC.get() || var5.player != null && var5.world != null && shx.wantsMusic());
         if (var6 && !var5.options.hudHidden) {
            float var7 = unf.delta() * (float)iov.ANIMATION.get();
            iov.update(var7);
            jag = var2;
            jah = var3;
            jai = var4;
            iov.beginHud();

            try {
               jbb(var0, var1, var2, var7);
            } finally {
               iov.endHud();
            }
         }
      }
   }

   private static void jbb(DrawContext var0, boolean var1, boolean var2, float var3) {
      MinecraftClient var4 = MinecraftClient.getInstance();
      jae = null;
      if (jaf && BACKGROUND.is(a.c(-1330669848, "險\uef30旮ﮍ灚")) && hyv.ENABLED.get() && uij.HUD.capture(var0, hyv.FROST.getInt(), null)) {
         jae = uij.HUD.result(var0);
      }

      jaj = (float)SCALE.get();
      float var5 = var0.getScaledWindowWidth();
      float var6 = var0.getScaledWindowHeight();
      float var7 = Math.max(1, var4.getWindow().getScaleFactor());
      float var8 = jbe(var4, var5, var6);
      boolean var9 = var2 && ARRANGE.get();
      boolean var10 = false;

      try {
         for (jcs var12 : ELEMENTS) {
            boolean var13 = var9 && var12.canGhost();
            var12.update(var3, var1 || var13);
            float var14 = var12.shown.step(var12.enabled.get() && var12.hasContent(var1 || var13), var3);
            if (var14 <= 0.004F) {
               var12.w = 0.0F;
            } else {
               var10 = true;
               float var15 = Math.max(0.25F, Math.round(jaj * var12.size * var7 * 4.0F) / 4.0F) / var7;
               var12.scale = var15;
               vdn.setRenderScale(var15);
               var12.place(var5, var6, var12.width() * var15, var12.height() * var15, var7);
               var12.y = var12.y + var12.push.step(var12 != jak ? jbg(var12, var5, var8) : 0.0F, var3);
               var12.y = Math.round(Math.min(var6 - var12.h, var12.y) * var7) / var7;
               float var16 = vcq.outCubic(var14);
               float var17 = 0.96F + 0.04F * var16;
               float var18 = 0.88F + 0.12F * var16;
               float var19 = (1.0F - var16) * 5.0F * (var12.ay == 2 ? 1.0F : -1.0F);
               float var20 = var12.pivotX();
               float var21 = var12.pivotY();
               var0.getMatrices().pushMatrix();
               var0.getMatrices().translate(var12.x + var20, var12.y + var21 + var19);
               var0.getMatrices().scale(var17, var18);
               var0.getMatrices().translate(-var20, -var21);
               var0.getMatrices().scale(var15, var15);
               uut.pushAlpha(var14 * (var13 && var12.isSample() ? 0.4F : 1.0F));

               try {
                  var12.draw(var0, var3, var1);
               } finally {
                  uut.popAlpha();
                  var0.getMatrices().popMatrix();
               }
            }
         }
      } finally {
         vdn.setRenderScale(1.0F);
      }

      jaf = var10;
      if (var2) {
         jbc(var0, var3, var7);
      }
   }

   private static void jbc(DrawContext var0, float var1, float var2) {
      jcs var3 = jak != null ? jak : jav;
      jcs var4 = var3 != null ? var3 : at(jah, jai);

      for (jcs var6 : ELEMENTS) {
         float var7 = jap.computeIfAbsent(var6, var0x -> new vcj(16.0F)).step(var6 == var4 && var6.w > 0.0F, var1);
         if (!(var7 <= 0.01F) && !(var6.w <= 0.0F)) {
            float var8 = iov.r(8.0F);
            int var9 = Math.round((var6 == var3 ? 150.0F : 80.0F) * var7);
            uut.outline(var0, var6.x - 2.5F, var6.y - 2.5F, var6.w + 5.0F, var6.h + 5.0F, var8 + 2.5F, 1.0F, ujt.withAlpha(16777215, var9));
            if (var6 == var4) {
               jbd(var0, var6, var7, var6 == jav);
            }
         }
      }

      if (jak != null) {
         int var10 = iov.accent(170);
         float var11 = 1.0F / var2;
         if (!Float.isNaN(jan)) {
            uut.rect(var0, jan - var11 * 0.5F, 0.0F, var11, var0.getScaledWindowHeight(), var10);
         }

         if (!Float.isNaN(jao)) {
            uut.rect(var0, 0.0F, jao - var11 * 0.5F, var0.getScaledWindowWidth(), var11, var10);
         }
      }
   }

   private static void jbd(DrawContext var0, jcs var1, float var2, boolean var3) {
      String var4 = var3
         ? Math.round(var1.size * 100.0F) + a.d("㠅", -221134532, -1448937187)
         : (
            var1.size != 1.0F
               ? Math.round(var1.size * 100.0F)
                  + wap.s(a.c(146640362, "跙\uf46d纾\ue058欘\ueda9垨\ude42䀓쪭䵢띇㧔ꁳ⨳계ᛖ餝Ͻ薶\u0c52瘜"), a.b("귞푪庹쁟䬟춮珂喝摯\ueaf8洱錠ᶇ萱\u0e69袑㊫", -2086752790))
               : wap.s(a.b("뵒쓘丅큻宰\udd55杂\ueea5烩艹緐螻ि邔\u1ad4鰺", -1425031920), a.b("藍ﱹ皬\uece1朽\ue187徶홊䡧슨䕺뼅㖤갏∼꒽ỵ鄯க趱", -1353743930))
         );
      float var5 = SMALL.width(var4) + 10.0F;
      float var6 = 11.0F;
      MinecraftClient var7 = MinecraftClient.getInstance();
      float var8 = var7.getWindow().getScaledWidth();
      float var9 = Math.max(2.0F, Math.min(var8 - var5 - 2.0F, var1.x + (var1.w - var5) * 0.5F));
      boolean var10 = var1.y < var6 + 8.0F;
      float var11 = var10 ? var1.y + var1.h + 5.0F : var1.y - var6 - 5.0F;
      uut.pushAlpha(var2);
      uut.round(var0, var9, var11, var5, var6, Math.min(var6 * 0.5F, iov.r(5.5F)), var3 ? iov.accent() : ujt.withAlpha(iov.window, 210));
      SMALL.drawCentered(var0, var4, var9 + var5 * 0.5F, SMALL.centerTop(var11 + var6 * 0.5F), var3 ? iov.onAccent() : iov.textDim);
      uut.popAlpha();
   }

   private static float jbe(MinecraftClient var0, float var1, float var2) {
      jas = 0.0F;
      Map var3 = jbf(var0);
      if (var3 != null && !var3.isEmpty()) {
         byte var4 = 12;
         int var5 = 0;
         float var6 = 91.0F;

         for (Object var8 : var3.values()) {
            var5++;
            if (var8 instanceof ClientBossBar var9) {
               var6 = Math.max(var6, var0.textRenderer.getWidth(var9.getName()) * 0.5F);
            }

            var4 += 19;
            if (var4 >= var2 / 3.0F) {
               break;
            }
         }

         jas = var6 + 4.0F;
         return 12 + (var5 - 1) * 19 + 5;
      } else {
         return 0.0F;
      }
   }

   private static Map<?, ?> jbf(MinecraftClient var0) {
      if (!jar && var0.inGameHud != null) {
         try {
            BossBarHud var1 = var0.inGameHud.getBossBarHud();
            if (jaq == null) {
               for (Field var5 : BossBarHud.class.getDeclaredFields()) {
                  if (!Modifier.isStatic(var5.getModifiers()) && Map.class.isAssignableFrom(var5.getType())) {
                     var5.setAccessible(true);
                     jaq = var5;
                     break;
                  }
               }

               if (jaq == null) {
                  throw new IllegalStateException(a.d("ꕙ\udce5嘪졛䏟씬罼\uf69e梓\ue26f新鿐ᅗ袨˺萐㸋놜⬦국⒁廚", -1129476197, -882365770));
               }
            }

            return (Map<?, ?>)jaq.get(var1);
         } catch (Throwable var6) {
            jar = true;
            System.out.println(a.c(-2038236450, "摒茳ৼ鞍ᰉ髺₪ꥈ㜖뷴㩲쀘今흾崬\udbc5憓\uee00璿\uf2ba筑č迻ᑂ鈠ᣠꄷ⼱뗞㎎롴䛶쳭問팛妻\ue679汘\ueaca獨浪蟁ඉ訲Ⴁ麄❋귷⮰뀶㹟") + var6);
            return null;
         }
      } else {
         return null;
      }
   }

   private static float jbg(jcs var0, float var1, float var2) {
      if (!(var2 <= 0.0F) && var0.ay == 0) {
         float var3 = var1 * 0.5F;
         return !(var0.x > var3 + jas) && !(var0.x + var0.w < var3 - jas) ? Math.max(0.0F, var2 + 5.0F - var0.y) : 0.0F;
      } else {
         return 0.0F;
      }
   }

   public static boolean mouseClicked(double var0, double var2, int var4) {
      if (!ENABLED.get()) {
         return false;
      }

      jcs var5 = at((float)var0, (float)var2);
      if (var5 == null) {
         return false;
      }

      if (var5.mouseClicked((float)((var0 - var5.x) / var5.scale), (float)((var2 - var5.y) / var5.scale), var4)) {
         return true;
      }

      if (var4 == 0) {
         jak = var5;
         jal = (float)var0 - var5.x;
         jam = (float)var2 - var5.y;
         var5.push.set(0.0F);
      } else if (var4 == 1) {
         startResize(var5, (float)var0, (float)var2);
      }

      return true;
   }

   static void startResize(jcs var0, float var1, float var2) {
      jav = var0;
      jaw = var0.size;
      float var3 = var0.x + var0.pivotX();
      float var4 = var0.y + var0.pivotY();
      jax = Math.max(Math.max(var0.w, var0.h) * 0.35F, (float)Math.hypot(var1 - var3, var2 - var4));
   }

   static void resize(float var0, float var1, boolean var2) {
      jcs var3 = jav;
      float var4 = var3.x + var3.pivotX();
      float var5 = var3.y + var3.pivotY();
      float var6 = (float)Math.hypot(var0 - var4, var1 - var5);
      float var7 = jaw * var6 / jax;
      var7 = Math.max(0.5F, Math.min(2.0F, Math.round(var7 * 100.0F) / 100.0F));
      if (!var2 && Math.abs(var7 - 1.0F) < 0.04F) {
         var7 = 1.0F;
      }

      var3.size = var7;
   }

   static jcs resizing() {
      return jav;
   }

   static void endResize() {
      jav = null;
   }

   public static boolean mouseDragged(double var0, double var2) {
      if (jav != null) {
         MinecraftClient var9 = MinecraftClient.getInstance();
         resize((float)var0, (float)var2, InputUtil.isKeyPressed(var9.getWindow(), 342) || InputUtil.isKeyPressed(var9.getWindow(), 346));
         return true;
      }

      if (jak == null) {
         return false;
      }

      MinecraftClient var4 = MinecraftClient.getInstance();
      float var5 = var4.getWindow().getScaledWidth();
      float var6 = var4.getWindow().getScaledHeight();
      boolean var7 = InputUtil.isKeyPressed(var4.getWindow(), 342) || InputUtil.isKeyPressed(var4.getWindow(), 346);
      float[] var8 = drag(jak, (float)var0 - jal, (float)var2 - jam, var5, var6, var7);
      jan = var8[0];
      jao = var8[1];
      return true;
   }

   public static boolean mouseReleased() {
      if (jav != null) {
         jav = null;
         hyz.saveLater();
         return true;
      }

      if (jak == null) {
         return false;
      }

      jak = null;
      jan = Float.NaN;
      jao = Float.NaN;
      hyz.saveLater();
      return true;
   }

   static float[] drag(jcs var0, float var1, float var2, float var3, float var4, boolean var5) {
      float var6 = Float.NaN;
      float var7 = Float.NaN;
      if (!var5) {
         float[] var8 = jbh(var0, var1, var0.w, var3, true);
         var1 = var8[0];
         var6 = var8[1];
         float[] var9 = jbh(var0, var2, var0.h, var4, false);
         var2 = var9[0];
         var7 = var9[1];
      }

      var1 = Math.max(0.0F, Math.min(var3 - var0.w, var1));
      var2 = Math.max(0.0F, Math.min(var4 - var0.h, var2));
      var0.moveTo(var1, var2, var3, var4);
      return new float[]{var6, var7};
   }

   private static float[] jbh(jcs var0, float var1, float var2, float var3, boolean var4) {
      ArrayList var5 = new ArrayList();
      var5.add(new float[]{4.0F, 4.0F});
      var5.add(new float[]{(var3 - var2) * 0.5F, var3 * 0.5F});
      var5.add(new float[]{var3 - var2 - 4.0F, var3 - 4.0F});

      for (jcs var7 : ELEMENTS) {
         if (var7 != var0 && !(var7.w <= 0.0F)) {
            float var8 = var4 ? var7.x : var7.y;
            float var9 = var4 ? var7.w : var7.h;
            var5.add(new float[]{var8, var8});
            var5.add(new float[]{var8 + var9 - var2, var8 + var9});
            var5.add(new float[]{var8 + (var9 - var2) * 0.5F, var8 + var9 * 0.5F});
            var5.add(new float[]{var8 + var9 + 4.0F, var8 + var9 + 4.0F});
            var5.add(new float[]{var8 - var2 - 4.0F, var8 - 4.0F});
         }
      }

      float var11 = 4.0F;
      float[] var12 = new float[]{var1, Float.NaN};

      for (float[] var14 : var5) {
         float var10 = Math.abs(var14[0] - var1);
         if (var10 < var11) {
            var11 = var10;
            var12 = new float[]{var14[0], var14[1]};
         }
      }

      return var12;
   }

   static jcs at(float var0, float var1) {
      for (int var2 = ELEMENTS.size() - 1; var2 >= 0; var2--) {
         jcs var3 = ELEMENTS.get(var2);
         if (var3.w > 0.0F && var0 >= var3.x - 2.0F && var0 < var3.x + var3.w + 2.0F && var1 >= var3.y - 2.0F && var1 < var3.y + var3.h + 2.0F) {
            return var3;
         }
      }

      return null;
   }

   static boolean pointer() {
      return jag;
   }

   static float localMouseX(jcs var0) {
      return jag ? (jah - var0.x) / var0.scale : -1000.0F;
   }

   static float localMouseY(jcs var0) {
      return jag ? (jai - var0.y) / var0.scale : -1000.0F;
   }

   static void chip(DrawContext var0, float var1, float var2, float var3, float var4, float var5) {
      float var6 = (float)OPACITY.get();
      int var7 = ujt.withAlpha(iov.window, Math.round(255.0F * Math.min(1.0F, var6 * 0.55F)));
      if (jae == null || !uut.glass(var0, jae, var1, var2, var3, var4, var5, var7, 1.0F)) {
         uut.round(var0, var1, var2, var3, var4, var5, iov.hudFill(var6 * 0.6F));
      }

      uut.outline(var0, var1, var2, var3, var4, var5, 1.0F, iov.hudEdge());
   }

   static void panel(DrawContext var0, float var1, float var2, float var3) {
      float var4 = iov.lightness();
      ukf.shadow(var0, 0.0F, 0.0F, var1, var2, var3, 1.4F, var4);
      float var5 = (float)OPACITY.get();
      boolean var6 = false;
      if (jae != null) {
         float var7 = Math.max(0.4F, Math.min(1.0F, var5 * iov.tintScale()));
         int var8 = hyv.tint(iov.window, var7);
         var6 = hyv.liquid()
            ? uut.liquid(var0, jae, 0.0F, 0.0F, var1, var2, var3, var8, 1.0F, hyv.lens(Math.min((float)hyv.EDGE.get(), var2 * 0.42F)))
            : uut.glass(var0, jae, 0.0F, 0.0F, var1, var2, var3, var8, 1.0F);
      }

      if (!var6) {
         uut.round(var0, 0.0F, 0.0F, var1, var2, var3, iov.hudFill(var5));
      }

      ukf.sheen(var0, 0.0F, 0.0F, var1, var2, var3, 1.0F - 0.7F * var4);
      ukf.rim(var0, 0.0F, 0.0F, var1, var2, var3, var4, var6 && hyv.liquid() ? 0.6F : 1.0F);
      if (!var6 || !hyv.liquid()) {
         uut.outline(var0, 0.0F, 0.0F, var1, var2, var3, 1.0F, iov.hudEdge());
      }
   }

   public static void moduleToggled(kfe var0) {
      MinecraftClient var1 = MinecraftClient.getInstance();
      if (var1.player != null && var1.world != null && (!var0.isAction() || var0.isEnabled())) {
         WATERMARK.toggled(var0);
      }
   }

   public static void alert(String var0, String var1, vhz var2, boolean var3) {
      MinecraftClient var4 = MinecraftClient.getInstance();
      if (!var4.isOnThread()) {
         var4.execute(() -> alert(var0, var1, var2, var3));
      } else {
         if (ENABLED.get() && WATERMARK.enabled.get() && jlx.ALERTS.get()) {
            WATERMARK.alert(var0, var1, var2, var3);
         }
      }
   }

   public static void notify(String var0, String var1) {
      alert(var0, var1, vhz.INFO, true);
   }

   public static void openEditor() {
      MinecraftClient.getInstance().setScreen(new jbs());
   }

   public static void resetLayout() {
      for (jcs var1 : ELEMENTS) {
         var1.resetPosition();
      }
   }

   public static Map<String, vmo> persisted() {
      LinkedHashMap var0 = new LinkedHashMap();
      var0.put(a.d("蹐\uf7fc紾\ue305梙\uee23呿\udd8d䏜쥤亶", -1775606424, -1715934373), ENABLED);

      for (vmo var2 : LOOK) {
         var0.put(a.b("껱흝嶟쎤", 783593117) + jbi(var2), var2);
      }

      for (jcs var6 : ELEMENTS) {
         var0.put(a.d("洑ᒽ鹿D", 803970647, -556797142) + var6.id + a.b("\ude6fꞕⵍ댳㣧빘Ђ跲", -1976050103), var6.enabled);

         for (vmo var4 : var6.settings()) {
            var0.put(a.d("冀菙छ霠", 549113076, 405616365) + var6.id + a.b("\uead9", -755045642) + jbi(var4), var4);
         }
      }

      return var0;
   }

   private static String jbi(vmo var0) {
      return var0.getName().toLowerCase(Locale.ROOT).replace(' ', '-');
   }

   public static void save(Properties var0) {
      var0.setProperty(a.d("\ue012馾፼赇ے聮㨥돂ⶇꜷ", 1706126024, -195392840), String.valueOf(2));

      for (jcs var2 : ELEMENTS) {
         var0.setProperty(a.b("㨄䎨쥪坑\udcd8婶\ue039榕", 938949220) + var2.id, var2.savePosition());
      }
   }

   public static void load(Properties var0) {
      int var1;
      try {
         var1 = Integer.parseInt(var0.getProperty(a.c(52465729, "連\ue98f捍ﵶ監\uf05f䨔쏳嶶휆"), a.b("倨", -1874112488)).trim());
      } catch (NumberFormatException var5) {
         var1 = 1;
      }

      for (jcs var3 : ELEMENTS) {
         if (var1 >= 2 || var3 != WATERMARK) {
            String var4 = var0.getProperty(a.b("⎱娝탟令앭䏃歷瀠", -830659631) + var3.id);
            if (var4 != null) {
               var3.loadPosition(var4);
            }
         }
      }
   }

   public static int enabledCount() {
      int var0 = 0;

      for (jcs var2 : ELEMENTS) {
         if (var2.enabled.get()) {
            var0++;
         }
      }

      return ENABLED.get() ? var0 : 0;
   }
}
