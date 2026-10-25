package a;

import flow.dev.a;
import java.util.Iterator;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.CloudRenderMode;
import net.minecraft.client.render.entity.state.ArmedEntityRenderState;
import net.minecraft.client.render.entity.state.BlockDisplayEntityRenderState;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.entity.state.ItemDisplayEntityRenderState;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.client.render.state.WorldRenderState;
import net.minecraft.particle.ParticlesMode;

public class lub extends kfe {
   private final vlv luc = this.add(
      new vlv(
         a.c(-494823657, "靚\ueedf搟謁熽\uf749䵖쒢嫹큌垂"),
         a.c(-767722965, "穷Ͻ褬\u1758鲋ᨾꁰ⦐럎"),
         a.b("蘒ﾘ畉\ueb3d惮\ue65b尕헵䮫", 285902414),
         a.b("诬\uf27f碭\ue6db洑\uebbb凵", 1356958630),
         a.b("涻ᐬ黳\u008a", -2112721416)
      )
   );
   private final vkl lud = this.add(new vkl(a.c(204055694, "\ua4c8\udd58埄짣䈱쒊绎\uf732"), true));
   private final vkl lue = this.add(new vkl(a.d("節茽ড鞕᱉髢€ꥀ㜒뷺㩺쀐从흺崢\udbcb憀", 654949909, 262489319), true));
   private final vkl luf = this.add(new vkl(a.d("Ꮄ樤\ue0b8纊\uf552珠즩䁉\ude01", 1454330699, 1758019768), true));
   private final vkl lug = this.add(new vkl(a.d("킑꤃⏂붡㙡낂ઁ荡ᴭ鞚ၔ\uea2f擷﵏眊", 802527693, 445204757), true));
   private final vkl luh = this.add(new vkl(a.c(1178039888, "瘐ྀ蔜ᬯ郳ᙄ강◬믶ㄅ뛘䲠쉼寇"), true));
   private final vkl lui = this.add(new vkl(a.c(-1878324811, "৷灧\ufafb擇\uef18榢폪婎쑓们줦㍐"), true));
   private final vkl luj = this.add(new vkl(a.d("둷췧䝻\ud943劐퐼湭\ue781秇\uf365璷躂\u0001馶\u13f6锈⽚ꂈ㨪뱨㖈俒셬媧", 484727756, -1159663635), true));
   private final vkl luk = this.add(new vkl(a.c(1787067349, "箁ȓ裒ᚱ鵱ᮒꆇ⡱똽㳞뭈䄲쿿噓\udc1d嫱\ue0b2潵"), true));
   private final vkl lul = this.add(new vkl(a.b("欥\u12b1顬ؒ跙଼넩㣟ꚓⱰ꯳冞\udf44䛭첢䩄\uf00a", 103377784), true));
   private final vmc lum = this.add(
      new vmc(a.d("냬쥸䎥\udddb嘐탵櫠\ue305絇\uf7f4", 1274602420, 668160798), 24.0, 8.0, 64.0, 4.0).suffix(a.b("٧翘\uf508歵\ue0aa昃", 311887363))
   );
   private final vkl lun = this.add(new vkl(a.b("\u0cd1畁ﾟ懯\uea7d沊훞弼성䯄찚㙱뢥℈ꭖ\u2dbf韺", 858066056), true));
   private final vmc luo = this.add(
      new vmc(a.d("執\u2e6b꒢㫐넛㞧跬З騛ჿ霩洈\ue38b稡", 1269412753, -2100960212), 32.0, 8.0, 96.0, 4.0).suffix(a.c(-295833461, "\uf0ef襐\u0380鷽ᘢ邋"))
   );
   private final vkl lup = this.add(new vkl(a.b("讧\uf231磰\ue686洅\uebf8冢\ud857䘟첽䭸", 986090474), false));
   private final vkl luq = this.add(new vkl(a.b("䭽㋭롱♓궚⬩酺ᢐ蛓ప讵燁８暦\uece9樅큍徕", 54479649), false));
   private static lub lur;
   private static final wbu<Integer> lus = new wbu<>(var0 -> var0.field_1690.method_42524());
   private static final wbu<Boolean> lut = new wbu<>(var0 -> var0.field_1690.method_42433());
   private static final wbu<Boolean> luu = new wbu<>(var0 -> var0.field_1690.method_42435());
   private static final wbu<CloudRenderMode> luv = new wbu<>(var0 -> var0.field_1690.method_42528());
   private static final wbu<ParticlesMode> luw = new wbu<>(var0 -> var0.field_1690.method_42475());
   private static final wbu<Integer> lux = new wbu<>(var0 -> var0.field_1690.method_41805());
   private static final wbu<Integer> luy = new wbu<>(var0 -> var0.field_1690.method_57702());
   private static final wbu<Boolean> luz = new wbu<>(var0 -> var0.field_1690.method_75337());
   private static final wbu<Double> lva = new wbu<>(var0 -> var0.field_1690.method_42517());
   private static final wbu<Boolean> lvb = new wbu<>(var0 -> var0.field_1690.method_75334());
   private static final wbu<Boolean> lvc = new wbu<>(var0 -> var0.field_1690.method_41792());
   private static final int lvd = 260;
   private int lve = -1;
   private int lvf = -1;
   private Boolean lvg;
   private static final wbu<?>[] lvh = new wbu[]{lus, lut, luu, luv, luw, lux, luy, luz, lva, lvb, lvc};

   public lub() {
      super(
         a.d("\ue52e鲠ᙷ蠛ψ蕽㼽뛗⢝ꈱ◤\udf94", -1093607958, 337918087),
         a.b("鞑\uee02擌着焸\uf7ef䶪쑘婮탅坃괩⏳멀。뛰೬荻\u19dc龞ᙥ氼\ue299礗､痽챃䈖\ud8f6庨핂⯖ꆚ㡫븻㒌譌ĺ螺Ṅ鐒\ueae3", 1014536182),
         kfa.MISC
      );
      lur = this;
      this.lum.visibleWhen(this.lul::get);
      this.luo.visibleWhen(this.lun::get);
      this.setEnabled(true);
   }

   public static void afterExtraction(WorldRenderState var0) {
      lub var1 = lur;
      if (var1 != null && var1.isEnabled() && var0 != null) {
         boolean var2 = var1.lul.get();
         boolean var3 = var1.lun.get();
         if (var2 || var3) {
            double var4 = var1.lum.get() * var1.lum.get();
            double var6 = var1.luo.get() * var1.luo.get();
            MinecraftClient var8 = MinecraftClient.method_1551();
            int var9 = var8.field_1724 != null ? var8.field_1724.method_5628() : Integer.MIN_VALUE;
            Iterator var10 = var0.field_61735.iterator();

            while (var10.hasNext()) {
               EntityRenderState var11 = (EntityRenderState)var10.next();
               if (!var3
                  || !(var11.field_53332 > var6)
                  || !(var11 instanceof ItemDisplayEntityRenderState) && !(var11 instanceof BlockDisplayEntityRenderState)) {
                  if (var2
                     && var11.field_53332 > var4
                     && var11 instanceof ArmedEntityRenderState var12
                     && !(var11 instanceof PlayerEntityRenderState var13 && var13.field_53528 == var9)) {
                     var12.field_55305.method_65605();
                     var12.field_55307.method_65605();
                     var12.field_53467.method_65605();
                  }
               } else {
                  var10.remove();
               }
            }
         }
      }
   }

   private static void lvk() {
      for (wbu var3 : lvh) {
         var3.release();
      }
   }

   @Override
   protected void onDisable() {
      lvk();
      MinecraftClient var1 = MinecraftClient.method_1551();
      if (var1 != null && var1.field_1690 != null) {
         this.lvm(var1);
         if (this.lve >= 0 && this.lve != lvl()) {
            lvn(var1);
         }
      }

      this.lve = -1;
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      boolean var2 = wbu.suspended(var1);
      if (var2) {
         lvk();
         this.lvm(var1);
      } else {
         int var3 = var1.method_22683() != null ? var1.method_22683().method_22092() : 0;
         if (this.luc.is(a.c(-597070565, "浇ᓍ鸜h讻എ띀㺠ꃾ"))) {
            lvo(lus, true, 260);
         } else {
            lvo(lus, this.luc.is(a.d("沚ᔉ鿛ƭ詧್뚃", 1805209597, 1108091693)) && var3 >= 30, Math.max(30, Math.min(260, var3)));
         }

         lvo(lut, this.lud.get() || this.luc.is(a.c(-2029731414, "쇶롼㊭곙✊ꆿᯱ鈑\u0c4f")), false);
         lvo(luu, this.lue.get(), false);
         lvo(luv, this.luf.get(), CloudRenderMode.field_18162);
         lvo(luw, this.lug.get() && luw.own() == ParticlesMode.field_18197, ParticlesMode.field_18198);
         lvo(luy, this.lui.get(), 0);
         Double var4 = lva.own();
         lvo(lva, this.luk.get() && var4 != null && var4 > 0.75, 0.75);
         lvo(lux, this.luh.get(), 0);
         lvo(luz, this.luj.get(), false);
         lvo(lvb, this.lup.get(), false);
         lvo(lvc, this.luq.get(), false);
         this.lvm(var1);
         int var5 = (Boolean.TRUE.equals(var1.field_1690.method_75337().method_41753()) ? 1 : 0)
            | (Boolean.TRUE.equals(var1.field_1690.method_75334().method_41753()) ? 2 : 0)
            | (Boolean.TRUE.equals(var1.field_1690.method_41792().method_41753()) ? 4 : 0);
         if (this.lve < 0) {
            this.lve = lvl();
         }

         if (var5 != this.lve) {
            lvn(var1);
            this.lve = var5;
         }
      }
   }

   private static int lvl() {
      return (Boolean.TRUE.equals(luz.own()) ? 1 : 0) | (Boolean.TRUE.equals(lvb.own()) ? 2 : 0) | (Boolean.TRUE.equals(lvc.own()) ? 4 : 0);
   }

   private void lvm(MinecraftClient var1) {
      Integer var2 = (Integer)var1.field_1690.method_42524().method_41753();
      if (var2 != null && var2 != this.lvf) {
         this.lvf = var2;
         var1.method_61964().method_61938(var2);
      }

      Boolean var3 = (Boolean)var1.field_1690.method_42433().method_41753();
      if (var3 != null && !var3.equals(this.lvg) && var1.method_22683() != null) {
         this.lvg = var3;
         var1.method_22683().method_4497(var3);
      }
   }

   private static void lvn(MinecraftClient var0) {
      if (var0.field_1769 != null && var0.field_1687 != null) {
         var0.field_1769.method_3279();
      }
   }

   private static <T> void lvo(wbu<T> var0, boolean var1, T var2) {
      if (var1) {
         var0.override(var2);
      } else {
         var0.release();
      }
   }
}
