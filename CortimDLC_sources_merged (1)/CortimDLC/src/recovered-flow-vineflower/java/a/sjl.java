package a;

import java.lang.reflect.Field;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWScrollCallback;
import org.lwjgl.glfw.GLFWScrollCallbackI;

public class sjl extends kfe {
   private static sjl sjm;
   private final vlq sjn = this.add(new vlq("Key", 67));
   private final vlv sjo = this.add(new vlv("Press", "Hold", "Hold", "Toggle"));
   private final vmc sjp = this.add(new vmc(new String(new char[]{'Z', 'o', 'o', 'm'}), 4.0, 1.5, 15.0, 0.5).unit("x"));
   private final vmc sjq = this.add(new vmc("Speed", 1.0, 0.3, 3.0, 0.1).unit("x"));
   private final vkl sjr = this.add(new vkl("Scroll", true));
   private final vkl sjs = this.add(new vkl("Slow mouse", true));
   private final vkl sjt = this.add(new vkl("Cinematic", false));
   private static final wbu<Double> sju = new wbu<>(var0 -> var0.options.getMouseSensitivity());
   private static Field sjv;
   private static Field sjw;
   private static boolean sjx;
   private boolean sjy;
   private double sjz;
   private double ska = 1.0;
   private long skb;
   private boolean skc;
   private boolean skd;
   private boolean ske;
   private static GLFWScrollCallback skf;
   private static GLFWScrollCallbackI skg;
   private static long skh;
   private boolean ski;

   public sjl() {
      super(new String(new char[]{'Z', 'o', 'o', 'm'}), "Smooth zoom on a key", kfa.RENDER);
      sjm = this;
      this.sjz = this.sjp.get();
   }

   public static boolean zooming() {
      return sjm != null && sjm.isEnabled() && sjm.ska > 1.01;
   }

   @Override
   protected void onDisable() {
      this.sjy = false;
      this.ska = 1.0;
      this.skn(MinecraftClient.getInstance());
   }

   @Override
   public void onKey(MinecraftClient var1, int var2) {
      if (var2 == this.sjn.get() && this.sjo.is("Toggle")) {
         this.sjy = !this.sjy;
         this.sjz = this.sjp.get();
      }
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      this.skm(var1);
   }

   @Override
   public void onWorldRender(MinecraftClient var1) {
      long var2 = System.nanoTime();
      double var4 = this.skb == 0L ? 0.0 : Math.min(0.1, (var2 - this.skb) / 1.0E9);
      this.skb = var2;
      boolean var6 = this.skl(var1);
      if (var6 && !this.ski) {
         this.sjz = this.sjp.get();
         skp(var1);
      }

      this.ski = var6;
      double var7 = var6 ? this.sjz : 1.0;
      double var9 = 1.0 - Math.exp(-var4 * 13.0 * this.sjq.get());
      this.ska = Math.exp(Math.log(this.ska) + (Math.log(var7) - Math.log(this.ska)) * var9);
      if (Math.abs(this.ska - var7) < 0.002) {
         this.ska = var7;
      }

      this.skm(var1);
   }

   private boolean skl(MinecraftClient var1) {
      if (var1.currentScreen == null && var1.player != null) {
         return this.sjo.is("Toggle") ? this.sjy : vzz.isDown(var1, this.sjn.get());
      } else {
         return this.sjo.is("Toggle") && this.sjy;
      }
   }

   private void skm(MinecraftClient var1) {
      if (var1.player != null && var1.gameRenderer != null) {
         if (this.ska <= 1.001) {
            this.skn(var1);
         } else if (sko()) {
            this.skc = true;
            float var2 = var1.player.getFovMultiplier(var1.options.getPerspective().isFirstPerson(), var1.options.getFovEffectScale().getValue().floatValue());
            float var3 = (float)(var2 / this.ska);

            try {
               sjv.setFloat(var1.gameRenderer, var3);
               sjw.setFloat(var1.gameRenderer, var3);
            } catch (IllegalAccessException | RuntimeException var9) {
               sjx = true;
            }

            if (this.sjs.get() && !wbu.suspended(var1)) {
               Double var4 = sju.own();
               if (var4 != null) {
                  double var5 = var4 * 0.6 + 0.2;
                  double var7 = var5 * Math.cbrt(1.0 / this.ska);
                  sju.override(Math.max(0.0, (var7 - 0.2) / 0.6));
               }
            } else {
               sju.release();
            }

            if (this.sjt.get() && !this.ske) {
               this.skd = var1.options.smoothCameraEnabled;
               var1.options.smoothCameraEnabled = true;
               this.ske = true;
            }
         }
      }
   }

   private void skn(MinecraftClient var1) {
      if (this.skc && var1.player != null && var1.gameRenderer != null && sko()) {
         float var2 = var1.player.getFovMultiplier(var1.options.getPerspective().isFirstPerson(), var1.options.getFovEffectScale().getValue().floatValue());

         try {
            sjv.setFloat(var1.gameRenderer, var2);
            sjw.setFloat(var1.gameRenderer, var2);
         } catch (IllegalAccessException | RuntimeException var4) {
         }
      }

      this.skc = false;
      sju.release();
      if (this.ske) {
         var1.options.smoothCameraEnabled = this.skd;
         this.ske = false;
      }
   }

   private static boolean sko() {
      if (sjv == null && !sjx) {
         sjv = vxr.find(GameRenderer.class, "net.minecraft.class_757", "field_4019", "F");
         sjw = vxr.find(GameRenderer.class, "net.minecraft.class_757", "field_3999", "F");
         sjx = sjv == null || sjw == null;
      }

      return !sjx;
   }

   private static void skp(MinecraftClient var0) {
      if (var0.getWindow() != null) {
         long var1 = var0.getWindow().getHandle();
         if (skh != var1 || skf == null) {
            try {
               if (skf == null) {
                  skf = GLFWScrollCallback.create(sjl::skq);
               }

               GLFWScrollCallback var3 = GLFW.glfwSetScrollCallback(var1, skf);
               skg = var3;
               skh = var1;
            } catch (Throwable var4) {
               System.out
                  .println(new String(new char[]{'[', 'F', 'l', 'o', 'w', '2', ']', ' ', 'w', 'h', 'e', 'e', 'l', ' ', 'h', 'o', 'o', 'k', ':', ' '}) + var4);
               skh = var1;
            }
         }
      }
   }

   private static void skq(long var0, double var2, double var4) {
      sjl var6 = sjm;
      MinecraftClient var7 = MinecraftClient.getInstance();
      if (var6 != null && var6.isEnabled() && var6.sjr.get() && var7.currentScreen == null && var6.ski && var4 != 0.0) {
         var6.sjz = Math.max(1.5, Math.min(40.0, var6.sjz * Math.pow(1.18, var4)));
      } else {
         if (skg != null) {
            skg.invoke(var0, var2, var4);
         }
      }
   }
}
