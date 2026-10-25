package a;

import flow.dev.a;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.WeakHashMap;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents.BeforeRender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.gui.widget.CyclingButtonWidget;
import net.minecraft.client.gui.widget.EntryListWidget;
import net.minecraft.client.gui.widget.SliderWidget;
import net.minecraft.client.gui.widget.ButtonWidget.Text;
import net.minecraft.text.Style;
import org.joml.Matrix3x2fStack;
import org.lwjgl.glfw.GLFW;

public final class kej {
   public static final boolean ENABLED = !a.c(55813747, "ꘐ\udfa6啸쬖䃗").equalsIgnoreCase(System.getProperty(a.b("笭ʖ衆ᘯ鶽ᬐꄏ⣩뚷㰆믎䆾콴", -716801210)));
   private static final Map<ClickableWidget, keg> kek = new WeakHashMap<>();
   private static Field kel;
   private static Field kem;
   private static boolean ken;
   private static boolean keo;

   private kej() {
   }

   public static void attach(Screen var0) {
      if (ENABLED && !keo && !(var0 instanceof jte) && !dry.armed()) {
         try {
            ker(var0);
            ScreenEvents.beforeRender(var0).register((BeforeRender)(var0x, var1, var2x, var3, var4) -> ker(var0x));
         } catch (Throwable var2) {
            keo = true;
            System.out.println(a.b("妦 \uaad2㒣뽯㧟菂\u0a60鐧Ẕ饀捿\uede7瑟︌碡싴", -968861227) + var2);
         }
      }
   }

   private static void ker(Screen var0) {
      if (!keo && !dry.armed()) {
         if (!ken) {
            ken = true;
            kel = vxr.find(
               Screen.class,
               a.b("킛ꤡ⏣뷈㙜냩ઽ荇ᴞ鞾ၾ\uea08操ﴦ眸\uf1c6䮄쑇廴\ud889儕⭃ꗴ", 324980962),
               a.c(-1693225583, "淼ᑂ麝å謺ධ랏㹾ꀪ⪒굆"),
               a.c(-1427972898, "\udc82ꔕ⿍놫㩫범ڝ轭ᄯ鮛ᰋ\ue619棫\uf140笔ﶪ")
            );
            kem = vxr.find(
               SliderWidget.class,
               a.b("頦\ue19c歞\uf575绡\uf854䈀쯺喣\udf03壃ꊵⱰ떛㾅륻̹賺ᙉ逴\u19af揸\ued49", 1020500063),
               a.b("集\uef78斧ﯟ瀀\uf68a䲴악嬟톬噹", -1888053589),
               a.d("碗", -1806554427, 1878348311)
            );
         }

         if (kel == null) {
            keo = true;
         } else {
            List var1;
            try {
               var1 = (List)kel.get(var0);
            } catch (IllegalAccessException var7) {
               keo = true;
               return;
            }

            int var2 = 0;

            for (int var3 = 0; var3 < var1.size(); var3++) {
               Drawable var4 = (Drawable)var1.get(var3);
               if (!(var4 instanceof kdv) && !(var4 instanceof keb)) {
                  if (var4 instanceof ClickableWidget var5 && kes(var5)) {
                     var1.set(var3, new kdv(var0, var5, Math.min(var2++, 14) * 0.018F));
                  } else if (var4 instanceof EntryListWidget var6) {
                     var1.set(var3, new keb(var0, var6));
                  }
               } else {
                  var2++;
               }
            }
         }
      }
   }

   private static boolean kes(ClickableWidget var0) {
      Class var1 = var0.getClass();
      return var1 == Text.class || var1 == CyclingButtonWidget.class || var0 instanceof SliderWidget;
   }

   private static void ket(DrawContext var0, ClickableWidget var1, int var2, int var3, float var4, float var5) {
      if (var1.field_22764) {
         float var6 = var1.method_75798();
         var1.method_25350(0.0F);

         try {
            var1.method_25394(var0, var2, var3, var4);
         } finally {
            var1.method_25350(var6);
         }

         keu(var0, var1, var2, var3, var6, var5);
      }
   }

   private static void keu(DrawContext var0, ClickableWidget var1, int var2, int var3, float var4, float var5) {
      if (!(var4 <= 0.003F)) {
         unf.observe(var0);
         keg var6 = kek.computeIfAbsent(var1, var1x -> new keg(var5));
         float var7 = kap.clock();
         float var8 = unf.delta();
         float var9 = vcq.outCubic(vcq.clamp01((var7 - var6.born - var6.delay) / 0.26F));
         if (!(var9 <= 0.0F)) {
            boolean var10 = var1.field_22763;
            MinecraftClient var11 = MinecraftClient.method_1551();
            boolean var12 = var1.method_25370() && var11.method_48186().method_48183();
            float var13 = var6.hover.step(var10 && (var1.method_49606() || var12), var8);
            boolean var14 = GLFW.glfwGetMouseButton(var11.method_22683().method_4490(), 0) == 1;
            if (var14 && !var6.down && var10 && var1.method_49606()) {
               var6.pressAt = var7;
               var6.px = var2 - var1.method_46426();
            }

            var6.down = var14;
            float var15 = vcq.clamp01((var7 - var6.pressAt) / 0.5F);
            float var16 = var15 < 1.0F ? (float)Math.sin(Math.PI * vcq.clamp01(var15 * 2.6F)) : 0.0F;
            float var17 = var1.method_25368();
            float var18 = var1.method_25364();
            float var19 = Math.min(var18 * 0.5F, 5.0F);
            int var20 = kbs.selected().accent;
            float var21 = 1.0F - 0.035F * var16;
            Matrix3x2fStack var22 = var0.method_51448();
            var22.pushMatrix();
            var22.translate(var1.method_46426() + var17 * 0.5F, var1.method_46427() + var18 * 0.5F + (1.0F - var9) * 4.0F);
            var22.scale(var21, var21);
            var22.translate(-var17 * 0.5F, -var18 * 0.5F);
            float var23 = var4 * var9;
            uut.pushAlpha(var23);

            try {
               uut.shadow(var0, 0.0F, 1.5F, var17, var18, var19, 7.0F, kez(0, 0.2F + 0.1F * var13));
               uut.round(var0, 0.0F, 0.0F, var17, var18, var19, kez(658965, var10 ? 0.5F + 0.12F * var13 : 0.3F));
               if (var13 > 0.01F) {
                  uut.round(var0, 0.0F, 0.0F, var17, var18, var19, kez(var20, 0.11F * var13));
               }

               uut.gradient(
                  var0,
                  0.0F,
                  0.0F,
                  var17,
                  var18 * 0.5F,
                  var19,
                  var19,
                  0.0F,
                  0.0F,
                  kez(16777215, 0.06F),
                  kez(16777215, 0.06F),
                  kez(16777215, 0.0F),
                  kez(16777215, 0.0F)
               );
               if (var1 instanceof SliderWidget) {
                  kev(var0, var1, var17, var18, var19, var13, var20, var10);
               }

               int var24 = kce.mix(16777215, var20, var13);
               uut.outlineGradientV(
                  var0,
                  0.0F,
                  0.0F,
                  var17,
                  var18,
                  var19,
                  0.6F,
                  kez(var24, (var10 ? 0.17F : 0.08F) + 0.45F * var13),
                  kez(var24, (var10 ? 0.05F : 0.03F) + 0.25F * var13)
               );
               if (var15 < 1.0F) {
                  float var25 = var17 * vcq.outCubic(var15);
                  float var26 = Math.max(0.0F, var6.px - var25);
                  float var27 = Math.min(var17, var6.px + var25);
                  uut.round(var0, var26, 0.0F, var27 - var26, var18, var19, kez(kce.mix(16777215, var20, 0.4F), 0.24F * (1.0F - var15)));
                  float var28 = 5.0F * vcq.outCubic(var15);
                  uut.outline(var0, -var28, -var28, var17 + 2.0F * var28, var18 + 2.0F * var28, var19 + var28, 0.8F, kez(var20, 0.6F * (1.0F - var15)));
               }

               kew(var0, var1, var17, var18, var13, var10, var23);
            } finally {
               uut.popAlpha();
               var22.popMatrix();
            }
         }
      }
   }

   private static void kev(DrawContext var0, ClickableWidget var1, float var2, float var3, float var4, float var5, int var6, boolean var7) {
      double var8 = 0.0;

      try {
         var8 = kem != null ? kem.getDouble(var1) : 0.0;
      } catch (IllegalAccessException var15) {
      }

      float var10 = (float)Math.max(0.0, Math.min(1.0, var8));
      float var11 = Math.max(var4, 5.0F);
      float var12 = var2 - var11 * 2.0F;
      float var13 = var11 + var12 * var10;
      uut.round(var0, 0.0F, 0.0F, Math.max(var4 * 2.0F, var13), var3, var4, kez(var6, (var7 ? 0.12F : 0.06F) + 0.08F * var5));
      float var14 = var3 - 3.6F;
      uut.round(var0, var11, var14 - 0.5F, var12, 1.0F, 0.5F, kez(16777215, 0.14F));
      uut.round(var0, var11, var14 - 0.5F, var13 - var11, 1.0F, 0.5F, kez(var6, var7 ? 0.9F : 0.4F));
      uut.circle(var0, var13, var14, 1.7F + 0.5F * var5, kez(kce.mix(16777215, var6, 0.2F), var7 ? 1.0F : 0.5F));
   }

   private static void kew(DrawContext var0, ClickableWidget var1, float var2, float var3, float var4, boolean var5, float var6) {
      net.minecraft.text.Text var7 = var1.method_25369();
      String var8 = var7.getString();
      int var9 = var5 ? kce.mix(15133683, 16777215, var4) : 8028814;
      vdn var10 = veo.semibold(6.9F);
      if ((!var5 || kex(var7)) && key(var10, var8)) {
         String var15 = var10.ellipsize(var8, var2 - 8.0F);
         var10.drawCentered(var0, var15, var2 * 0.5F, var10.centerTop(var3 * 0.5F), kez(var9, 1.0F));
      } else {
         TextRenderer var11 = MinecraftClient.method_1551().field_1772;
         int var12 = Math.round(255.0F * Math.max(0.0F, Math.min(1.0F, var6)));
         if (var12 >= 5) {
            int var13 = var11.method_27525(var7);
            if (var13 <= var2 - 6.0F) {
               var0.method_51439(var11, var7, Math.round((var2 - var13) * 0.5F), Math.round(var3 * 0.5F - 4.0F), var12 << 24 | 16777215, false);
            } else {
               String var14 = var11.method_27523(var8, Math.max(0, Math.round(var2 - 6.0F) - var11.method_1727(a.b("泳ᕂ龑", -825398050))))
                  + a.b("㬱䊀졓", -478790884);
               var0.method_51433(
                  var11, var14, Math.round((var2 - var11.method_1727(var14)) * 0.5F), Math.round(var3 * 0.5F - 4.0F), var12 << 24 | var9 & 16777215, false
               );
            }
         }
      }
   }

   private static boolean kex(net.minecraft.text.Text var0) {
      Optional var1 = var0.method_27658((var0x, var1x) -> var0x.method_10973() != null ? Optional.of(Boolean.TRUE) : Optional.empty(), Style.field_24360);
      return var1.isEmpty();
   }

   private static boolean key(vdn var0, String var1) {
      int var2 = 0;

      while (var2 < var1.length()) {
         int var3 = var1.codePointAt(var2);
         if (!Character.isWhitespace(var3) && !var0.canDisplay(var3)) {
            return false;
         }

         var2 += Character.charCount(var3);
      }

      return true;
   }

   private static int kez(int var0, float var1) {
      return kce.rgba(var0, var1);
   }
}
