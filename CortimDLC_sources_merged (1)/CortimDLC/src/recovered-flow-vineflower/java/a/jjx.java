package a;

import flow.dev.a;
import java.util.List;
import java.util.Locale;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.SkinTextures;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.Vec3d;

public final class jjx extends jcs {
   public static final vkl PLAYERS_ONLY = new vkl(a.b("ʦ笫\uf1f5澜\ue457拱\ud8a3儁켑䖡쉰㠔", -1863122182), true);
   public static final vkl ITEMS = new vkl(a.c(-1917470152, "멶쏴䤸흋岁\uda62恰\ue98e矛ﴮ窵胍ต鞮ᷪ"), true);
   public static final List<vmo> OPTIONS = List.of(PLAYERS_ONLY, ITEMS);
   private static final float jjy = 168.0F;
   private static final float jjz = 46.0F;
   private static final float jka = 40.0F;
   private static final float jkb = 8.0F;
   private static final float jkc = 30.0F;
   private static final float jkd = 15.0F;
   private static final float jke = 2.4F;
   private static final float jkf = 10.5F;
   private static final long jkg = 6000L;
   private static final long jkh = 900L;
   private static final double jki = 10.0;
   private static final int jkj = -12595334;
   private static final int jkk = -865972;
   private static final int jkl = -1092784;
   private static final int jkm = -670639;
   private static final EquipmentSlot[] jkn = new EquipmentSlot[]{
      EquipmentSlot.field_6169, EquipmentSlot.field_6174, EquipmentSlot.field_6172, EquipmentSlot.field_6166
   };
   private static LivingEntity jko;
   private static long jkp;
   private LivingEntity jkq;
   private long jkr;
   private jjj jks;
   private boolean jkt;
   private int jku;
   private final vcj jkv = new vcj(9.0F, 1.0F);
   private final vcj jkw = new vcj(4.5F, 1.0F);
   private final vcj jkx = new vcj(9.0F);
   private final vcj jky = new vcj(6.0F);
   private final vcj jkz = new vcj(10.0F);
   private final vcj jla = new vcj(9.0F);
   private long jlb;

   jjx() {
      super(a.d("끯짋䌋\udd6f嚺퀚", -1709636020, 78624337), a.b("倰⦴ꍴ㴐뛅づ", 787959906), true, 1, 1, 0.0F, 44.0F);
   }

   @Override
   public List<vmo> settings() {
      return OPTIONS;
   }

   public static void onAttack(Entity var0) {
      if (var0 instanceof LivingEntity var1) {
         jko = var1;
         jkp = System.currentTimeMillis();
      }
   }

   @Override
   void update(float var1, boolean var2) {
      MinecraftClient var3 = MinecraftClient.method_1551();
      long var4 = System.currentTimeMillis();
      LivingEntity var6 = this.enabled.get() ? jle(var3, var4) : null;
      if (var6 != null) {
         this.jkr = var4;
         if (var6 != this.jkq) {
            if (this.jkq != null) {
               this.jla.set(1.0F);
            }

            this.jkq = var6;
            this.jku = var6.field_6235;
            vyd var7 = vyk.of(var6);
            float var8 = var7.fraction();
            this.jkv.set(var8);
            this.jkw.set(var8);
            this.jkx.set(var7.unknown() ? 0.0F : Math.min(1.0F, var7.absorption() / var7.max()));
            this.jkz.set(var8 < 0.3F ? 1.0F : 0.0F);
         }
      } else if (this.jkq != null && (var4 - this.jkr > 900L || !jlf(var3, this.jkq))) {
         this.jkq = null;
      }

      this.jkt = false;
      if (this.jkq != null) {
         this.jks = jlg(this.jkq, var3);
      } else if (var2 && var3.field_1724 != null) {
         this.jks = jlh(var3.field_1724);
         this.jkt = true;
      }

      if (this.jks != null) {
         float var9 = this.jks.jjp ? 1.0F : Math.min(1.0F, this.jks.jjm / Math.max(1.0F, this.jks.jjn));
         float var10 = this.jkv.get();
         if (var9 < var10 - 0.001F && this.jkw.get() <= var10 + 0.001F) {
            this.jlb = var4 + 350L;
            this.jkw.set(Math.max(this.jkw.get(), var10));
         }

         this.jkv.step(var9, var1);
         if (var9 > this.jkw.get() || var4 > this.jlb) {
            this.jkw.step(Math.max(var9, this.jkv.get()), var1);
         }

         this.jkx.step(this.jks.jjp ? 0.0F : Math.min(1.0F, this.jks.jjo / Math.max(1.0F, this.jks.jjn)), var1);
         this.jkz.step(var9 < 0.3F ? 1.0F : 0.0F, var1);
         if (this.jkq != null && this.jkq.field_6235 > this.jku) {
            this.jky.set(1.0F);
         }

         this.jku = this.jkq != null ? this.jkq.field_6235 : 0;
         this.jky.step(0.0F, var1);
         this.jla.step(0.0F, var1);
      }
   }

   private static LivingEntity jle(MinecraftClient var0, long var1) {
      if (jko != null && var1 - jkp < 6000L && jlf(var0, jko)) {
         return jko;
      } else if (var0.field_1692 instanceof LivingEntity var3 && !(var3 instanceof ArmorStandEntity) && jlf(var0, var3)) {
         return var3;
      } else {
         ClientPlayerEntity var16 = var0.field_1724;
         if (var16 != null && var0.field_1687 != null) {
            Vec3d var17 = var16.method_33571();
            Vec3d var5 = var16.method_5828(1.0F);
            PlayerEntity var6 = null;
            double var7 = Math.cos(Math.toRadians(5.0));

            for (PlayerEntity var10 : var0.field_1687.method_18456()) {
               if (var10 != var16 && jlf(var0, var10)) {
                  Vec3d var11 = var10.method_5829().method_1005().method_1020(var17);
                  double var12 = var11.method_1033();
                  if (!(var12 > 10.0) && !(var12 < 0.01)) {
                     double var14 = var11.method_1021(1.0 / var12).method_1026(var5);
                     if (var14 > var7 && var16.method_6057(var10)) {
                        var7 = var14;
                        var6 = var10;
                     }
                  }
               }
            }

            return var6;
         } else {
            return null;
         }
      }
   }

   private static boolean jlf(MinecraftClient var0, LivingEntity var1) {
      if (var0.field_1687 == null
         || var0.field_1724 == null
         || var1 == var0.field_1724
         || !var1.method_5805()
         || var1.method_31481()
         || var0.field_1687.method_8469(var1.method_5628()) != var1) {
         return false;
      } else {
         return PLAYERS_ONLY.get() && !(var1 instanceof PlayerEntity) ? false : var0.field_1724.method_5858(var1) < 576.0;
      }
   }

   private static jjj jlg(LivingEntity var0, MinecraftClient var1) {
      SkinTextures var2 = var0 instanceof AbstractClientPlayerEntity var3 ? var3.method_52814() : null;
      vyd var6 = vyk.of(var0);
      ItemStack[] var4 = new ItemStack[4];

      for (int var5 = 0; var5 < 4; var5++) {
         var4[var5] = var0.method_6118(jkn[var5]);
      }

      float var7 = var1.field_1724 != null ? (float)Math.sqrt(var1.field_1724.method_5858(var0)) : 0.0F;
      return new jjj(
         lsx.protect(var0.method_5477().getString()),
         var2,
         var6.health(),
         var6.max(),
         var6.absorption(),
         var6.unknown(),
         var4,
         var0.method_6047(),
         var0.method_6079(),
         var7,
         var0.field_6235
      );
   }

   private static jjj jlh(ClientPlayerEntity var0) {
      ItemStack[] var1 = new ItemStack[]{
         jli(Items.field_22027, 0.08F), jli(Items.field_22028, 0.35F), jli(Items.field_8348, 0.62F), jli(Items.field_8285, 0.86F)
      };
      return new jjj(
         lsx.protect(var0.method_5477().getString()),
         var0.method_52814(),
         13.5F,
         20.0F,
         4.0F,
         false,
         var1,
         jli(Items.field_22022, 0.2F),
         new ItemStack(Items.field_8288),
         3.4F,
         0
      );
   }

   private static ItemStack jli(Item var0, float var1) {
      ItemStack var2 = new ItemStack(var0);
      if (var2.method_7963()) {
         var2.method_7974(Math.round(var2.method_7936() * var1));
      }

      return var2;
   }

   @Override
   boolean hasContent(boolean var1) {
      return this.jkq != null || var1 && this.jks != null;
   }

   @Override
   boolean canGhost() {
      return true;
   }

   @Override
   boolean isSample() {
      return this.jkt;
   }

   @Override
   float width() {
      return 168.0F;
   }

   @Override
   float height() {
      return ITEMS.get() ? 46.0F : 40.0F;
   }

   @Override
   void draw(DrawContext var1, float var2, boolean var3) {
      jjj var4 = this.jks;
      if (var4 != null) {
         float var5 = 168.0F;
         float var6 = this.height();
         float var7 = iov.r(9.0F);
         izx.panel(var1, var5, var6, var7);
         float var8 = vcq.outCubic(this.jla.get());
         var1.method_51448().pushMatrix();
         var1.method_51448().translate(0.0F, var6 * 0.5F);
         var1.method_51448().scale(1.0F, 1.0F - 0.18F * var8);
         var1.method_51448().translate(0.0F, -var6 * 0.5F);
         uut.pushAlpha(1.0F - 0.85F * var8);
         this.jlj(var1, var4, 8.0F, (var6 - 30.0F) * 0.5F);
         this.jlk(var1, var4, 46.0F, var6);
         this.jln(var1, var4, var5 - 8.0F - 15.0F, var6 * 0.5F);
         uut.popAlpha();
         var1.method_51448().popMatrix();
      }
   }

   private void jlj(DrawContext var1, jjj var2, float var3, float var4) {
      float var5 = Math.min(15.0F, iov.r(7.0F));
      float var6 = vcq.outCubic(this.jky.get());
      float var7 = 1.0F - 0.07F * var6;
      var1.method_51448().pushMatrix();
      var1.method_51448().translate(var3 + 15.0F, var4 + 15.0F);
      var1.method_51448().scale(var7, var7);
      float var8 = -15.0F;
      ukf.shadow(var1, var8, var8, 30.0F, 30.0F, var5, 0.8F, iov.lightness());
      int var9 = ujt.lerp(-1, -34182, var6);
      boolean var10 = var2.jjl != null && uog.draw(var1, var2.jjl, var8, var8, 30.0F, var5, var9);
      if (!var10) {
         uut.round(var1, var8, var8, 30.0F, 30.0F, var5, iov.field);
         String var11 = var2.jjk.isEmpty() ? a.c(597743189, "홫") : var2.jjk.substring(0, 1).toUpperCase(Locale.ROOT);
         izx.RING.drawCentered(var1, var11, 0.0F, izx.RING.centerTop(0.0F), iov.textDim);
      }

      uut.outlineGradientV(var1, var8, var8, 30.0F, 30.0F, var5, 1.0F, 956301311, 184549375);
      var1.method_51448().popMatrix();
   }

   private void jlk(DrawContext var1, jjj var2, float var3, float var4) {
      float var5 = 123.0F;
      boolean var6 = ITEMS.get();
      float var7 = var6 ? 12.5F : var4 * 0.5F - 4.0F;
      String var8 = wap.unit(a.c(1013091579, "貗"));
      String var9 = var2.jjt < 10.0F ? vxu.fixed(var2.jjt, 1) + var8 : Math.round(var2.jjt) + var8;
      float var10 = izx.SMALL.width(var9);
      String var11 = izx.TITLE.ellipsize(var2.jjk, var5 - var3 - var10 - 5.0F);
      float var12 = izx.TITLE.draw(var1, var11, var3, izx.TITLE.centerTop(var7), iov.text);
      izx.SMALL.draw(var1, var9, var12 + 4.0F, izx.SMALL.centerTop(var7 + 0.4F), iov.textMuted);
      if (!var6) {
         String var19 = var2.jjp
            ? wap.s(a.c(1260143208, "䈨㮾녵⼛ꓖ≽頥ᇚ辌"), a.d("ϋ穒\uf086滽\ue526掛\ud9cc倻칮", 2016193710, -1402164367))
            : (var2.jjo > 0.05F ? wap.s(a.c(-2051821588, "꾤혶峴슙䥓쿲疪ﱜ戊"), a.d("\u3040䧐쌎嵷횥偣\uea4c掵\ufdef睓", -776127170, -600110741)) : "");
         if (!var19.isEmpty()) {
            izx.SUB.draw(var1, var19, var3, izx.SUB.centerTop(var7 + 9.0F), iov.textMuted);
         }
      } else {
         float var13 = 22.5F;
         float var14 = var3;

         for (ItemStack var18 : var2.jjq) {
            this.jll(var1, var18, var14, var13);
            var14 += 12.0F;
         }

         var14 += 2.0F;
         uut.rect(var1, var14 - 0.5F, var13 + 2.0F, 1.0F, 7.5F, ujt.mulAlpha(iov.textMuted, 0.3F));
         var14 += 3.5F;
         this.jll(var1, var2.jjr, var14, var13);
         var14 += 12.0F;
         this.jll(var1, var2.jjs, var14, var13);
      }
   }

   private void jll(DrawContext var1, ItemStack var2, float var3, float var4) {
      if (var2 != null && !var2.method_7960()) {
         float var5 = uut.alpha();
         float var6 = 0.65625F * Math.min(1.0F, var5 * 2.5F);
         if (var6 > 0.02F) {
            var1.method_51448().pushMatrix();
            var1.method_51448().translate(var3 + 5.25F, var4 + 5.25F);
            var1.method_51448().scale(var6, var6);
            var1.method_51427(var2, -8, -8);
            var1.method_51448().popMatrix();
         }

         if (var2.method_7963() && var2.method_7936() > 0) {
            float var7 = 1.0F - (float)var2.method_7919() / var2.method_7936();
            float var8 = 8.5F;
            float var9 = var4 + 10.5F + 2.2F;
            uut.round(var1, var3 + 1.0F, var9, var8, 1.3F, 0.65F, iov.track);
            uut.round(var1, var3 + 1.0F, var9, Math.max(1.3F, var8 * var7), 1.3F, 0.65F, jlm(var7));
         }
      } else {
         uut.round(var1, var3 + 5.25F - 1.2F, var4 + 5.25F - 1.2F, 2.4F, 2.4F, 1.2F, ujt.mulAlpha(iov.textMuted, 0.35F));
      }
   }

   private static int jlm(float var0) {
      return var0 > 0.5F ? ujt.lerp(-865972, -12595334, (var0 - 0.5F) * 2.0F) : ujt.lerp(-1092784, -865972, var0 * 2.0F);
   }

   private void jln(DrawContext var1, jjj var2, float var3, float var4) {
      uut.arc(var1, var3, var4, 15.0F, 2.4F, 0.0F, 1.0F, ujt.mulAlpha(iov.text, 0.12F));
      if (var2.jjp) {
         float var11 = (float)(System.nanoTime() / 1.0E9 * 0.6 % 1.0);
         uut.arc(var1, var3, var4, 15.0F, 2.4F, var11, 0.22F, ujt.mulAlpha(iov.textMuted, 0.9F));
         izx.RING.drawCentered(var1, a.c(580886078, "鸀"), var3, izx.RING.centerTop(var4), iov.text);
      } else {
         float var5 = this.jkv.get();
         float var6 = this.jkw.get();
         if (var6 > var5 + 0.002F) {
            uut.arc(var1, var3, var4, 15.0F, 2.4F, 0.0F, var6, ujt.withAlpha(-1092784, 150));
         }

         int var7 = ujt.lerp(iov.accent(), -1092784, this.jkz.get());
         uut.arc(var1, var3, var4, 15.0F, 2.4F, 0.0F, var5, var7);
         float var8 = this.jkx.get();
         if (var8 > 0.003F) {
            uut.arc(var1, var3, var4, 17.6F, 1.1F, 0.0F, var8, -670639);
         }

         float var9 = var2.jjm + var2.jjo;
         String var10 = !(var9 >= 100.0F) && !(Math.abs(var9 - Math.round(var9)) < 0.05F) ? vxu.fixed(var9, 1) : String.valueOf(Math.round(var9));
         izx.RING.drawCentered(var1, var10, var3, izx.RING.centerTop(var4 - 1.8F), var2.jjo > 0.05F ? -670639 : iov.text);
         izx.TINY
            .drawCentered(var1, wap.s(a.d("ꯅ퉬", -1149007518, 1856840397), a.c(1542228651, "軬\uf727")), var3, izx.TINY.centerTop(var4 + 5.2F), iov.textMuted);
      }
   }
}
