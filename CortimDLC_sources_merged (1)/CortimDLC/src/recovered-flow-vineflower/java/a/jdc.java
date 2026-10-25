package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public final class jdc extends jcs {
   private static final float jdd = 14.0F;
   private static final float jde = 5.0F;
   private static final float jdf = 9.0F;
   private static final float jdg = 5.0F;
   private static final float jdh = 40.0F;
   private List<jcz> jdi = new ArrayList<>();
   private final Map<String, jcz> jdj = new HashMap<>();
   private final vcj jdk = new vcj(13.0F, 40.0F);
   private boolean jdl;
   private boolean jdm;
   private long jdn;
   private boolean jdo;
   private boolean jdp;

   jdc() {
      super(a.d("ჽ楑\ue393緪\uf623", 2012081028, -2140669163), a.b("䛷㽻떹⯀ꀉ", 929056443), true, 1, 2, 0.0F, 72.0F);
   }

   private static List<oxi> jds(boolean var0) {
      ArrayList var1 = new ArrayList();
      oxw var2 = oxw.get();
      if (var2 != null && var2.isEnabled()) {
         var1.addAll(var2.entries(MinecraftClient.getInstance().getRenderTickCounter().getTickProgress(true)));
      }

      if (var1.isEmpty() && var0) {
         var1.add(jdt(a.d("ॡ烄塚摲", 40181496, -368830468), new ItemStack(Items.PHANTOM_MEMBRANE, 15), 90));
         var1.add(jdt(a.d("\ue670鿐ᔅ譳", -940031681, -401496273), new ItemStack(Items.SUGAR, 20), 89));
         var1.add(jdt(a.b("鸺\ue78d浍\uf32d", 1707449930), new ItemStack(Items.NETHERITE_SCRAP, 15), 86));
         var1.add(jdt(a.b("\ue7fe鹓ᒍ諮ľ", 186640267), new ItemStack(Items.DRIED_KELP, 18), 66));
         var1.add(jdt(a.b("ﱘ藮༾酚᪃鰤♢꾂㇊", -341509063), new ItemStack(Items.SPLASH_POTION, 2), vzz.combo(50, 2)));
      }

      return var1;
   }

   private static oxi jdt(String var0, ItemStack var1, int var2) {
      return new oxi(a.c(1120294939, "塣⇐ꬔ㕶뺾㠃艂\u0bfe") + var0, var0, var1, var1.getCount(), var2, 0.0F, 0L, false);
   }

   @Override
   void update(float var1, boolean var2) {
      long var3 = System.nanoTime();
      boolean var5 = this.enabled.get();
      if (var3 - this.jdn >= 50000000L || var2 != this.jdo || var5 != this.jdp) {
         this.jdn = var3;
         this.jdo = var2;
         this.jdp = var5;
         this.jdu(var5, var2);
      }

      float var6 = 0.0F;

      for (jcz var8 : this.jdi) {
         float var9 = vcq.outCubic(var8.appear.step(var8.alive, var1));
         var8.owned.step(var8.item.count() > 0, var1);
         var8.busy.step(var8.item.active(), var1);
         var6 += (jdw(var8.item) + 5.0F) * var9;
      }

      this.jdi.removeIf(var0 -> !var0.alive && var0.appear.get() <= 0.01F);
      this.jdk.set(Math.max(40.0F, var6 - 5.0F));
   }

   private void jdu(boolean var1, boolean var2) {
      List var3 = var1 ? jds(false) : List.of();
      this.jdm = false;
      if (var3.isEmpty() && var2 && var1) {
         var3 = jds(true);
         this.jdm = !var3.isEmpty();
      }

      this.jdj.clear();

      for (jcz var5 : this.jdi) {
         this.jdj.put(var5.id, var5);
      }

      ArrayList var8 = new ArrayList();

      for (oxi var6 : var3) {
         jcz var7 = this.jdj.remove(var6.id());
         if (var7 == null) {
            var7 = new jcz(var6.id());
            var7.owned.set(var6.count() > 0 ? 1.0F : 0.0F);
         }

         var7.item = var6;
         var7.alive = true;
         var8.add(var7);
      }

      for (int var10 = 0; var10 < this.jdi.size(); var10++) {
         jcz var11 = this.jdi.get(var10);
         if (this.jdj.containsKey(var11.id)) {
            var11.alive = false;
            var8.add(Math.min(var10, var8.size()), var11);
         }
      }

      this.jdi = var8;
      this.jdl = !var3.isEmpty();
   }

   @Override
   boolean hasContent(boolean var1) {
      return this.jdl;
   }

   @Override
   boolean canGhost() {
      return true;
   }

   @Override
   boolean isSample() {
      return this.jdm;
   }

   @Override
   float width() {
      return this.jdk.get();
   }

   @Override
   float height() {
      return 14.0F;
   }

   private static String jdv(oxi var0) {
      return a.b("焢", -1168215717) + var0.count();
   }

   private static float jdw(oxi var0) {
      return 17.5F + izx.TEXT.width(jdv(var0)) + 6.0F + izx.TEXT.width(irr.keyName(var0.key())) + 5.0F;
   }

   @Override
   void draw(DrawContext var1, float var2, boolean var3) {
      long var4 = System.currentTimeMillis();
      float var6 = 0.0F;

      for (jcz var8 : this.jdi) {
         var6 += (jdw(var8.item) + 5.0F) * vcq.outCubic(var8.appear.get());
      }

      float var16 = (this.width() - Math.max(0.0F, var6 - 5.0F)) * 0.5F;

      for (jcz var9 : this.jdi) {
         float var10 = vcq.outCubic(var9.appear.get());
         float var11 = jdw(var9.item);
         if (var10 > 0.02F) {
            uut.pushAlpha(Math.min(1.0F, var10 * 1.2F) * (0.45F + 0.55F * var9.owned.get()));
            var1.getMatrices().pushMatrix();
            float var12 = 0.8F + 0.2F * var10;
            var1.getMatrices().translate(var16 + var11 * var10 * 0.5F, 7.0F);
            var1.getMatrices().scale(var12, var12);
            var1.getMatrices().translate(-var11 * 0.5F, -7.0F);

            try {
               this.jdx(var1, var9, var11, var10, var4);
            } finally {
               var1.getMatrices().popMatrix();
               uut.popAlpha();
            }
         }

         var16 += (var11 + 5.0F) * var10;
      }
   }

   private void jdx(DrawContext var1, jcz var2, float var3, float var4, long var5) {
      oxi var7 = var2.item;
      float var8 = iov.r(4.0F);
      float var9 = Math.max(var2.busy.get(), 1.0F - vcq.outCubic(Math.min(1.0F, (float)(var5 - var7.usedAt()) / 700.0F)));
      if (var9 > 0.01F) {
         uut.shadow(var1, 0.0F, 0.0F, var3, 14.0F, var8, 6.0F, iov.accent((int)(110.0F * var9)));
      }

      izx.chip(var1, 0.0F, 0.0F, var3, 14.0F, var8);
      if (var9 > 0.01F) {
         uut.round(var1, 0.0F, 0.0F, var3, 14.0F, var8, iov.accent((int)(45.0F * var9)));
         uut.outline(var1, 0.0F, 0.0F, var3, 14.0F, var8, 1.0F, iov.accent((int)(190.0F * var9)));
      }

      float var10 = 7.0F;
      float var11 = 0.5625F * var4;
      var1.getMatrices().pushMatrix();
      var1.getMatrices().translate(9.5F, var10);
      var1.getMatrices().scale(var11, var11);
      var1.drawItem(var7.icon(), -8, -8);
      var1.getMatrices().popMatrix();
      float var12 = jdy(var7);
      float var13 = 17.5F;
      String var14 = jdv(var7);
      int var15 = var7.count() > 0 ? ujt.lerp(iov.text, iov.textDim, var12 > 0.001F ? 0.6F : 0.0F) : -1096636;
      var13 = izx.TEXT.draw(var1, var14, var13, izx.TEXT.centerTop(var10), var15);
      izx.TEXT.draw(var1, irr.keyName(var7.key()), var13 + 6.0F, izx.TEXT.centerTop(var10), ujt.lerp(iov.textDim, iov.text, 0.55F + 0.45F * var9));
      if (var12 > 0.001F) {
         float var16 = var3 - var8 * 2.0F;
         uut.round(var1, var8, 11.8F, var16, 1.2F, 0.6F, ujt.withAlpha(16777215, 30));
         uut.gradientH(var1, var8, 11.8F, Math.max(1.2F, var16 * var12), 1.2F, 0.6F, iov.accent(), iov.accent2());
      }
   }

   private static float jdy(oxi var0) {
      MinecraftClient var1 = MinecraftClient.getInstance();
      ClientPlayerEntity var2 = var1.player;
      return var2 != null && var0.count() > 0 && !var0.id().startsWith(a.c(1906302599, "\udeffꝌⶈ돪㠢뺟Ӟ赢"))
         ? var2.getItemCooldownManager().getCooldownProgress(var0.icon(), var1.getRenderTickCounter().getTickProgress(true))
         : var0.cooldown();
   }
}
