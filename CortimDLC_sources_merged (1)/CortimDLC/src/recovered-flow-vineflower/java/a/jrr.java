package a;

import flow.dev.a;
import java.lang.reflect.Field;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.CubeMapRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.RotatingCubeMapRenderer;
import net.minecraft.client.render.GameRenderer;

public final class jrr extends RotatingCubeMapRenderer {
   static boolean jrs;
   static boolean jrt;
   static kap jru;
   static long jrv;
   static RotatingCubeMapRenderer jrw;
   static Field jrx;
   final kam jry = new kam();
   float jrz;
   float jsa;
   long jsb;

   jrr(CubeMapRenderer var1) {
      super(var1);
   }

   public static void tick(MinecraftClient var0) {
      if (!jrt) {
         try {
            if (!jrs) {
               jrs = true;
               jse(var0.gameRenderer);
            }

            if (jru != null && unf.frame() - jrv > 30L) {
               jru.close();
               jru = null;
            }
         } catch (Throwable var2) {
            jrt = true;
            System.out.println(a.c(1885684234, "䉔㯭넵⽟ꓝ∮顾ᆍ迚դ芡磍\uf605濤\ue5e2挈\ud948嚎찪䩳쎁망㝭겲⫄ꁜ᧣韤ഄ譚î︺瑵\ued89殛\ue17a庼퓂刐쮼䇰㼍땒㊢ꠦ♐龖ᔿ鍺\u08e2蚋") + var2);
         }
      }
   }

   static void jse(GameRenderer var0) throws IllegalAccessException {
      Field var1 = vxr.find(
         GameRenderer.class,
         a.d("ꚾ\udf04嗆쯭䁹워粘\uf562欻\ue19b晛鰭የ謃ĝ蟣㶡뉢⣑꺬✳嵠폑", -73438213, -786313924),
         a.d("심뭒ㆍ꿵\u242aꊠᢚ酭༷薋ɐ", 2098788631, -875873386),
         a.d("誗\uf304秜\ue7bc氰\ueac3傔\ud962䜶춁䩃뀡㻱Ꝓⵚꯧᆧ鹻Ӛ芋\u0b50煩ￛ搊\ue278", 1219864353, 275656163)
      );
      Field var2 = vxr.find(
         GameRenderer.class,
         a.d("햸갂⛀룫㍿뗊ྞ虤ᠽ銝ᕝ\uef2b懮\uf805爛\uf4e5产셤寗\uddaa吵\u2e66ꃗ", -901702366, -269760285),
         a.d("Ԥ粚\uf645栽\ue3e2敨\udf52嚥죿䉌양", -1696417882, 1115468527),
         a.d("Ꮇ樤\ue0fc纜\uf510珣즴䁂\ude16咡퍣⤁ꟑ㹲둺㋇袇ݛ鷺᮫鉰\ue849書ﴭ筘", -1674335628, -586565226)
      );
      if (var1 != null && var2 != null && !(var1.get(var0) instanceof jrr)) {
         jrx = var1;
         jrw = (RotatingCubeMapRenderer)var1.get(var0);
         var1.set(var0, new jrr((CubeMapRenderer)var2.get(var0)));
      }
   }

   public static void uninstall(MinecraftClient var0) {
      jrt = true;

      try {
         if (jrx != null && jrw != null && var0 != null && var0.gameRenderer != null && jrx.get(var0.gameRenderer) instanceof jrr) {
            jrx.set(var0.gameRenderer, jrw);
         }
      } catch (Throwable var3) {
      }

      if (jru != null) {
         try {
            jru.close();
         } catch (Throwable var2) {
         }

         jru = null;
      }
   }

   @Override
   public void render(DrawContext context, int width, int height, boolean rotate) {
      if (dry.armed()) {
         super.render(context, width, height, rotate);
      } else {
         jza var5 = jrt ? null : jzh.get(kbs.selected().key);
         if (var5 == null) {
            super.render(context, width, height, rotate);
         } else {
            try {
               unf.observe(context);
               jrv = unf.frame();
               if (jru == null) {
                  jru = new kap();
               }

               MinecraftClient var6 = MinecraftClient.getInstance();
               long var7 = System.nanoTime();
               float var9 = this.jsb == 0L ? 0.0F : Math.min(0.1F, (float)(var7 - this.jsb) / 1.0E9F);
               this.jsb = var7;
               float var10 = 1.0F - (float)Math.exp(-var9 * 2.2F);
               double var11 = Math.max(1, var6.getWindow().getWidth());
               double var13 = Math.max(1, var6.getWindow().getHeight());
               this.jrz = this.jrz + ((float)(var6.mouse.getX() / var11) - 0.5F - this.jrz) * var10;
               this.jsa = this.jsa + ((float)(var6.mouse.getY() / var13) - 0.5F - this.jsa) * var10;
               kbs var15 = kbs.selected();
               this.jry.time = kap.clock();
               this.jry.zoom = 1.05F;
               this.jry.panX = -this.jrz * 0.014F;
               this.jry.panY = -this.jsa * 0.01F;
               this.jry.blur = 0.3F;
               this.jry.dim = 0.14F;
               this.jry.tint = var15.tint;
               this.jry.tintAmount = 0.3F;
               this.jry.fall = null;
               this.jry.pool = null;
               if (!jru.draw(context, var5, this.jry, width, height, 1.0F, false)) {
                  super.render(context, width, height, rotate);
               }
            } catch (Throwable var16) {
               jrt = true;
               System.out.println(a.b("瘟ྦ蕾ᬔ邖ᙥ갵◆뮑ㄯ뛪䲆쉎宯톺坌\ued0b拟\uf865縵\uf78a跗̦飴ẉ鑐ⶨꎭ㥁뽟㒸쩵䀷\ud983往픠櫸\ue088晆￤疷\u0b4a腂۩", 29193822) + var16);
               super.render(context, width, height, rotate);
            }
         }
      }
   }
}
