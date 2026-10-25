package a;

import flow.dev.a;
import java.lang.reflect.Field;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.input.Input;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.option.Perspective;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class ovh extends kfe {
   private static ovh ovi;
   private final vmc ovj = this.add(new vmc(a.b("䈌㮞녘⼩꓿", -1405140390), 10.0, 1.0, 50.0, 1.0).suffix(a.d("渧៛鵔", -937067049, 1378358161)));
   private final vmc ovk = this.add(new vmc(a.b("鏐\uea5f悎\ufeff申\uf39e", 683971461), 0.5, 0.0, 1.0, 0.05).percent());
   private static Field ovl;
   private static Field ovm;
   private static Field ovn;
   private static Field[] ovo;
   private static boolean ovp;
   private ove ovq;
   private Input ovr;
   private Perspective ovs;
   private boolean ovt = true;
   private boolean ovu;
   private float ovv;
   private float ovw;
   private float ovx;
   private float ovy;
   private double ovz;
   private double owa;
   private double owb;
   private long owc;
   private long owd;
   private long owe = -1L;

   public ovh() {
      super(a.d("턾ꢻ≿밎㟿녬ଳ", 891867848, -1659108425), a.b("ꃮ\ud975厳춛䘘삵竫\uf35f浃\ue7f0怯驖ᒖ贴ܪ臗㯁됆⺯꣹⅜孝헲丮졉䊄ﬠ産\uef87槑\ue277Ჾ電", -27615095), kfa.PLAYER);
      ovi = this;
   }

   public static boolean active() {
      return ovi != null && ovi.isEnabled() && ovi.ovq != null;
   }

   @Override
   protected void onEnable() {
      MinecraftClient var1 = MinecraftClient.method_1551();
      ClientPlayerEntity var2 = var1.field_1724;
      if (var2 != null && var1.field_1687 != null) {
         owm();
         this.ovv = var2.method_36454();
         this.ovw = var2.method_36455();
         this.ovx = this.ovv;
         this.ovy = this.ovw;
         this.ovz = this.owa = this.owb = 0.0;
         this.owc = 0L;
         Vec3d var3 = var2.method_5836(1.0F);
         this.ovq = new ove(this, var1.field_1687);
         this.ovq.method_5814(var3.field_1352, var3.field_1351, var3.field_1350);
         this.ovq.field_6014 = var3.field_1352;
         this.ovq.field_6036 = var3.field_1351;
         this.ovq.field_5969 = var3.field_1350;
         this.ovr = var2.field_3913;
         var2.field_3913 = new Input();
         var2.method_5728(false);
         this.ovs = var1.field_1690.method_31044();
         var1.field_1690.method_31043(Perspective.field_26664);
         this.ovt = var1.field_1730;
         var1.field_1730 = false;
         var1.method_1504(this.ovq);
         own(var1, 0.0F);
      } else {
         this.setEnabled(false);
      }
   }

   @Override
   protected void onDisable() {
      MinecraftClient var1 = MinecraftClient.method_1551();
      ClientPlayerEntity var2 = var1.field_1724;
      this.owh(var2);
      if (this.ovq != null && var2 != null) {
         var1.method_1504(var2);
         if (this.ovr != null) {
            var2.field_3913 = this.ovr;
         }

         var2.method_36456(this.ovv);
         var2.method_36457(this.ovw);
         var2.field_5982 = this.ovv;
         var2.field_6004 = this.ovw;
         own(var1, var2.method_5751());
      }

      if (this.ovq != null) {
         var1.field_1730 = this.ovt;
      }

      if (this.ovs != null) {
         var1.field_1690.method_31043(this.ovs);
      }

      this.ovq = null;
      this.ovr = null;
      this.ovs = null;
   }

   @Override
   public void onStartTick(MinecraftClient var1) {
      if (this.ovq != null) {
         this.owh(var1.field_1724);
         if (this.ovq.method_73183() == var1.field_1687 && var1.method_1560() == this.ovq) {
            owi(var1, var1.field_1724);

            for (KeyBinding var5 : new KeyBinding[]{
               var1.field_1690.field_1886, var1.field_1690.field_1904, var1.field_1690.field_1871, var1.field_1690.field_1869, var1.field_1690.field_1831
            }) {
               while (var5.method_1436()) {
               }

               var5.method_23481(false);
            }

            if (var1.field_1724.field_3913 != null && var1.field_1724.field_3913.getClass() != Input.class) {
               this.ovr = var1.field_1724.field_3913;
               var1.field_1724.field_3913 = new Input();
            }
         } else {
            this.setEnabled(false);
         }
      }
   }

   @Override
   public void onWorldRender(MinecraftClient var1) {
      this.owd++;
      this.owl(var1);
      ClientPlayerEntity var2 = var1.field_1724;
      if (this.ovq != null && var2 != null && !var2.field_5960) {
         var2.field_5960 = true;
         this.ovu = true;
      }
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      if (this.ovq != null && var1.method_1560() == var1.field_1724) {
         owi(var1, this.ovq);
      }

      this.owl(var1);
   }

   private void owh(ClientPlayerEntity var1) {
      if (this.ovu && var1 != null) {
         var1.field_5960 = false;
      }

      this.ovu = false;
   }

   private static void owi(MinecraftClient var0, Entity var1) {
      if (var1 != null) {
         try {
            if (ovn != null) {
               ovn.set(var0, var1);
               return;
            }
         } catch (RuntimeException | IllegalAccessException var3) {
         }

         var0.method_1504(var1);
      }
   }

   private void owj() {
      if (this.owe != this.owd) {
         this.owe = this.owd;
         MinecraftClient var1 = MinecraftClient.method_1551();
         ClientPlayerEntity var2 = var1.field_1724;
         if (var2 != null && this.ovq != null) {
            this.ovx = this.ovx + (var2.method_36454() - this.ovv);
            this.ovy = MathHelper.method_15363(this.ovy + var2.method_36455() - this.ovw, -90.0F, 90.0F);
            var2.method_36456(this.ovv);
            var2.method_36457(this.ovw);
            var2.field_5982 = this.ovv;
            var2.field_6004 = this.ovw;
            long var3 = System.nanoTime();
            double var5 = this.owc == 0L ? 0.0 : Math.min(0.1, (var3 - this.owc) / 1.0E9);
            this.owc = var3;
            double var7 = owk(var1.field_1690.field_1894, var1.field_1690.field_1881);
            double var9 = owk(var1.field_1690.field_1913, var1.field_1690.field_1849);
            double var11 = owk(var1.field_1690.field_1903, var1.field_1690.field_1832);
            double var13 = this.ovj.get() * (var1.field_1690.field_1867.method_1434() ? 2.5 : 1.0);
            double var15 = Math.toRadians(this.ovx);
            double var17 = Math.sin(var15);
            double var19 = Math.cos(var15);
            double var21 = Math.sqrt(var7 * var7 + var9 * var9);
            double var23 = 0.0;
            double var25 = 0.0;
            if (var21 > 0.0) {
               var7 /= var21;
               var9 /= var21;
               var23 = (-var17 * var7 + var19 * var9) * var13;
               var25 = (var19 * var7 + var17 * var9) * var13;
            }

            double var27 = var11 * var13;
            double var29 = this.ovk.get() <= 0.01 ? 1.0 : 1.0 - Math.exp(-var5 * (4.0 + 26.0 * (1.0 - this.ovk.get())));
            this.ovz = this.ovz + (var23 - this.ovz) * var29;
            this.owa = this.owa + (var27 - this.owa) * var29;
            this.owb = this.owb + (var25 - this.owb) * var29;
            double var31 = this.ovq.method_23317() + this.ovz * var5;
            double var33 = this.ovq.method_23318() + this.owa * var5;
            double var35 = this.ovq.method_23321() + this.owb * var5;
            this.ovq.method_5814(var31, var33, var35);
            this.ovq.field_6014 = var31;
            this.ovq.field_6036 = var33;
            this.ovq.field_5969 = var35;
         }
      }
   }

   private static double owk(KeyBinding var0, KeyBinding var1) {
      return (var0.method_1434() ? 1 : 0) - (var1.method_1434() ? 1 : 0);
   }

   private void owl(MinecraftClient var1) {
      if (this.ovq != null && ovo != null) {
         HeldItemRenderer var2 = var1.method_1561().method_43336();

         for (Field var6 : ovo) {
            vxr.setFloat(var6, var2, 0.0F);
         }
      }
   }

   private static void owm() {
      if (!ovp) {
         ovp = true;
         ovl = vxr.find(
            Camera.class, a.b("\uf055觯̭鴆ᚒ逧⩳ꎉ㷐띰グ쫆䐃\udde8埶턈歊\ue489縺\uf847燛ஏ蔵Ứ", 666103843), a.b("菈勇炩\ueed1攎\ue384妹큁丑쒥䍵", 2094171045), a.c(661490767, "谈")
         );
         ovm = vxr.find(
            Camera.class, a.d("\uf279诃ā鼪ᒾ鈋⡟ꆥ㿼땜㊜죪䘯\udfc4嗚팤楦\ue6a5簖恵珷ণ蜙᳄", 425939087, -1650417024), a.b("ꡯ퇑嬎앶亩젣爞ﯦ斶\uef02棑", -1930582014), a.b("ᅞ", -1970925287)
         );
         ovn = vxr.find(
            MinecraftClient.class,
            a.b("帣➙굛㍰룤㹑萅\u0dff鎦ᤆ黆撰\uea75玞呂罾씼䫿큌嘱\udfaaꗹ⭋", 836394586),
            a.c(922977124, "茈襁灩\uee11旎\ue344她킎仗쑮"),
            a.b("⁜姏팗䵷웻䀈著玩\uedfd杊\ue088\u1aea鐺\u0d99螑Ĭ뭬㒰긑⡀ꆛ\udba4唔컎䢿쉢", -720297974)
         );
         Field[] var0 = new Field[]{
            vxr.find(
               HeldItemRenderer.class, a.c(-1214325488, "\udd69ꓓ⸑뀺㮮봛ݏ躵წ驌ᶌ\ue7fa椿\uf0d4竊ﰴ䙶즵匆핻峤⚷ꠈ"), a.c(-1460459750, "❶廈퐗䩯솰䜺ﴂ瓷\ueaac怚"), a.c(-1165832429, "코")
            ),
            vxr.find(
               HeldItemRenderer.class,
               a.c(-114415152, "⦩倓\udad1䓺콮䧛\uf38f穵\ue42c溌\ue94cጺ鷿Д踊ࣴ늶㵵Ᶎ↻ꠤ퉷峈"),
               a.d("䒤㴚럅⦽ꉢⓨ黐ᜥ西ψ", 1331739662, -1702102842),
               a.c(-1619893418, "挑")
            ),
            vxr.find(
               HeldItemRenderer.class,
               a.d("烟॥莧ᶌ阘Ⴍ\uaaf9⌃뵚㟺뀺䩌쒉嵢흼冂\uebc0搃ﺰ磍\uf152謁־", -101199147, -1763990925),
               a.c(-1004550912, "앬볒㘍꡵⎪ꔠἘ雭ࢷ舁"),
               a.b("뺞", -1271546151)
            ),
            vxr.find(
               HeldItemRenderer.class,
               a.d("藫ﱑ皓\ue8b8挬\ue599忍혷䡮싎䔎뽸ㆽꡖ≈꒶Ỵ鄷\u0b84跹Ѧ縵\uf08a", 417296199, -3740971),
               a.d("叆⩸ꂧ㻟딀㎊覲G鸝ᒨ", -1189539635, 1719550823),
               a.d("闃", -605564791, -63879923)
            )
         };
         ovo = var0[0] != null && var0[1] != null && var0[2] != null && var0[3] != null ? var0 : null;
      }
   }

   private static void own(MinecraftClient var0, float var1) {
      Camera var2 = var0.field_1773.method_19418();
      vxr.setFloat(ovl, var2, var1);
      vxr.setFloat(ovm, var2, var1);
   }
}
