package a;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElement;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents.AfterRender;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents.BeforeRender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.gui.hud.ChatHudLine.Visible;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardDisplaySlot;
import net.minecraft.scoreboard.ScoreboardObjective;
import org.joml.Matrix3x2fStack;

public class qxi extends kfe {
   private static qxi qxj;
   private static boolean qxk;
   private final vkl qxl = this.add(new vkl("Tab", true));
   private final vkl qxm = this.add(new vkl("Chat", true));
   private final vkl qxn = this.add(new vkl("Inventory", true));
   private final vmc qxo = this.add(new vmc("Speed", 1.0, 0.5, 2.0, 0.1));
   private static float qxp;
   private static long qxq;
   private static Field qxr;
   private static boolean qxs;
   private static Object qxt;
   private static long qxu;
   private static final Map<Screen, Long> qxv = new WeakHashMap<>();
   private static boolean qxw;

   public qxi() {
      super(new String(new char[]{'A', 'n', 'i', 'm', 'a', 't', 'i', 'o', 'n', 's'}), "Smooth tab list, chat and inventories", kfa.RENDER);
      qxj = this;
      this.setEnabled(true);
      qyb();
   }

   private static boolean qxz(vkl var0) {
      return qxj != null && qxj.isEnabled() && var0.get();
   }

   private static float qya(float var0) {
      return var0 / (float)Math.max(0.2, qxj.qxo.get());
   }

   private static void qyb() {
      if (!qxk) {
         qxk = true;

         try {
            HudElementRegistry.replaceElement(VanillaHudElements.PLAYER_LIST, var0 -> qyc(var0));
            HudElementRegistry.replaceElement(VanillaHudElements.CHAT, var0 -> qye(var0));
         } catch (Throwable var1) {
            System.out.println("tab / chat animations unavailable: " + var1);
         }
      }
   }

   private static HudElement qyc(HudElement var0) {
      return (var1, var2) -> {
         if (qxj != null && qxz(qxj.qxl)) {
            try {
               qyd(var1, var2, var0);
            } catch (Throwable var4) {
               System.out.println("tab animation failed: " + var4);
               qxj.qxl.set(false);
            }
         } else {
            qxp = 0.0F;
            var0.render(var1, var2);
         }
      };
   }

   private static void qyd(DrawContext var0, RenderTickCounter var1, HudElement var2) {
      MinecraftClient var3 = MinecraftClient.getInstance();
      long var4 = System.nanoTime();
      float var6 = qxq == 0L ? 0.0F : Math.min(0.1F, (float)(var4 - qxq) / 1.0E9F);
      qxq = var4;
      Scoreboard var7 = var3.world.getScoreboard();
      ScoreboardObjective var8 = var7.getObjectiveForSlot(ScoreboardDisplaySlot.LIST);
      int var9 = var3.player.networkHandler.getListedPlayerListEntries().size();
      boolean var10 = var3.options.playerListKey.isPressed() && (!var3.isInSingleplayer() || var9 > 1 || var8 != null);
      qxp = vcq.clamp01(qxp + (var10 ? var6 / qya(0.24F) : -var6 / qya(0.16F)));
      if (!(qxp <= 0.0F) && (!(qxp >= 1.0F) || !var10)) {
         float var11 = qxp * qxp * (3.0F - 2.0F * qxp);
         int var12 = var0.getScaledWindowWidth();
         int var13 = var9;

         for (int var14 = 1; var13 > 20; var13 = (var9 + var14 - 1) / var14) {
            var14++;
         }

         float var15 = 10.0F + var13 * 9.0F + 50.0F;
         var0.enableScissor(0, 0, var12, Math.max(1, Math.round(4.0F + var11 * var15)));
         Matrix3x2fStack var16 = var0.getMatrices();
         var16.pushMatrix();
         float var17 = 0.94F + 0.06F * var11;
         var16.translate(var12 * 0.5F, 10.0F - (1.0F - var11) * 6.0F);
         var16.scale(var17, var17);
         var16.translate(-var12 * 0.5F, -10.0F);

         try {
            if (var10) {
               var2.render(var0, var1);
            } else {
               var0.createNewRootLayer();
               var3.inGameHud.getPlayerListHud().render(var0, var12, var7, var8);
            }
         } finally {
            var16.popMatrix();
            var0.disableScissor();
         }
      } else {
         var2.render(var0, var1);
      }
   }

   private static HudElement qye(HudElement var0) {
      return (var1, var2) -> {
         if (qxj != null && qxz(qxj.qxm) && !qxs) {
            float var3 = 0.0F;

            try {
               var3 = qyf(MinecraftClient.getInstance());
            } catch (Throwable var9) {
               qxs = true;
               System.out.println("chat animation unavailable: " + var9);
            }

            if (var3 < 0.05F) {
               var0.render(var1, var2);
            } else {
               Matrix3x2fStack var4 = var1.getMatrices();
               var4.pushMatrix();
               var4.translate(0.0F, var3);

               try {
                  var0.render(var1, var2);
               } finally {
                  var4.popMatrix();
               }
            }
         } else {
            var0.render(var1, var2);
         }
      };
   }

   private static float qyf(MinecraftClient var0) throws IllegalAccessException {
      ChatHud var1 = var0.inGameHud.getChatHud();
      if (qxr == null) {
         for (Field var5 : ChatHud.class.getDeclaredFields()) {
            if (!Modifier.isStatic(var5.getModifiers())
               && var5.getType() == List.class
               && var5.getGenericType() instanceof ParameterizedType var7
               && var7.getActualTypeArguments().length == 1
               && var7.getActualTypeArguments()[0] == Visible.class) {
               var5.setAccessible(true);
               qxr = var5;
            }
         }

         if (qxr == null) {
            throw new IllegalStateException("chat lines not found");
         }
      }

      List var12 = (List)qxr.get(var1);
      Object var13 = var12.isEmpty() ? null : var12.get(0);
      long var14 = System.nanoTime();
      if (var13 != qxt) {
         if (qxt != null && var13 != null) {
            qxu = var14;
         }

         qxt = var13;
      }

      float var15 = vcq.clamp01((float)(var14 - qxu) / 1.0E9F / qya(0.28F));
      if (var15 >= 1.0F) {
         return 0.0F;
      }

      double var16 = var0.options.getChatLineSpacing().getValue();
      double var9 = var0.options.getChatScale().getValue();
      float var11 = (float)(9.0 * (var16 + 1.0) * var9);
      return (1.0F - vcq.outCubic(var15)) * var11;
   }

   public static void attach(Screen var0) {
      if (qxj != null && (var0 instanceof HandledScreen || var0 instanceof ChatScreen)) {
         qxv.putIfAbsent(var0, System.nanoTime());
         ScreenEvents.beforeRender(var0).register((BeforeRender)(var0x, var1, var2, var3, var4) -> qyg(var0x, var1));
         ScreenEvents.afterRender(var0).register((AfterRender)(var0x, var1, var2, var3, var4) -> qyj(var1));
      }
   }

   private static void qyg(Screen var0, DrawContext var1) {
      qxw = false;
      Long var2 = qxv.get(var0);
      if (var2 != null) {
         boolean var3 = var0 instanceof ChatScreen;
         if (qxz(var3 ? qxj.qxm : qxj.qxn)) {
            float var4 = vcq.clamp01((float)(System.nanoTime() - var2) / 1.0E9F / qya(var3 ? 0.2F : 0.26F));
            if (!(var4 >= 1.0F)) {
               Matrix3x2fStack var5 = var1.getMatrices();
               var5.pushMatrix();
               qxw = true;
               if (var3) {
                  var5.translate(0.0F, (1.0F - vcq.outCubic(var4)) * 16.0F);
               } else {
                  float var6 = vcq.outBack(var4);
                  int var7 = var0.width;
                  int var8 = var0.height;
                  float var9 = 0.9F + 0.1F * var6;
                  float var10 = (1.0F - vcq.outCubic(var4)) * 10.0F;
                  if (var9 < 1.0F) {
                     int var11 = (int)Math.ceil(var7 * 0.5F - var7 * 0.5F * var9);
                     int var12 = (int)Math.floor(var7 * 0.5F + var7 * 0.5F * var9);
                     int var13 = (int)Math.ceil(var8 * 0.5F + var10 - var8 * 0.5F * var9);
                     int var14 = (int)Math.floor(var8 * 0.5F + var10 + var8 * 0.5F * var9);
                     qyh(var1, 0, 0, var7, var13, var8);
                     qyh(var1, 0, var14, var7, var8, var8);
                     qyh(var1, 0, var13, var11, var14, var8);
                     qyh(var1, var12, var13, var7, var14, var8);
                  }

                  var5.translate(var7 * 0.5F, var8 * 0.5F + var10);
                  var5.scale(var9, var9);
                  var5.translate(-var7 * 0.5F, -var8 * 0.5F);
               }
            }
         }
      }
   }

   private static void qyh(DrawContext var0, int var1, int var2, int var3, int var4, int var5) {
      if (var3 > var1 && var4 > var2) {
         var0.fillGradient(var1, var2, var3, var4, qyi((float)var2 / var5), qyi((float)var4 / var5));
      }
   }

   private static int qyi(float var0) {
      int var1 = Math.round(192.0F + 16.0F * Math.max(0.0F, Math.min(1.0F, var0)));
      return var1 << 24 | 1052688;
   }

   private static void qyj(DrawContext var0) {
      if (qxw) {
         qxw = false;
         var0.getMatrices().popMatrix();
      }
   }
}
