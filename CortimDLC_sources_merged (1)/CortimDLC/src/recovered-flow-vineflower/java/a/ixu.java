package a;

import flow.dev.a;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public final class ixu extends jcs {
   public static final vlv LAYOUT = new vlv(
      a.b("ᎃ樟\ue0d4纳\uf57e珎", -1985014839), a.d("鍹\ueaf5怾", 1991046311, -148215921), a.c(-1104902861, "蕢ﳮ瘥"), a.c(1910023134, "ꎛ\uda06僖캾䕱쏃")
   );
   public static final vlv DURABILITY = new vlv(
      a.b("䷙㑙뺍⃯ꬻⶁ韗ḣ聡\u0add", 96161175),
      a.b("觺\uf07e窺\ue4da漋\ue9b1司", -1136031315),
      a.d("\uf1af蠫˯鲏\u175e釤⮭", -148116399, 1340677545),
      a.b("ﭖ苄ࠄ", 1578760983),
      a.c(1111048219, "䁝㧁댉ⵤ")
   );
   public static final vkl HANDS = new vkl(a.c(1656836280, "僵⥭ꎱ㷊똊"), false);
   public static final List<vmo> OPTIONS = List.of(LAYOUT, DURABILITY, HANDS);
   private static final float ixv = 5.0F;
   private static final float ixw = 12.0F;
   private static final float ixx = 21.0F;
   private static final float ixy = 1.5F;
   private static final float ixz = 16.0F;
   private static final int iya = -12595334;
   private static final int iyb = -865972;
   private static final int iyc = -1092784;
   private static final EquipmentSlot[] iyd = new EquipmentSlot[]{
      EquipmentSlot.field_6169,
      EquipmentSlot.field_6174,
      EquipmentSlot.field_6172,
      EquipmentSlot.field_6166,
      EquipmentSlot.field_6173,
      EquipmentSlot.field_6171
   };
   private final ItemStack[] iye = new ItemStack[iyd.length];
   private final int[] iyf = new int[iyd.length];
   private final vcj[] iyg = new vcj[iyd.length];
   private final vcj iyh = new vcj(13.0F, 60.0F);
   private final vcj iyi = new vcj(13.0F, 30.0F);
   private int iyj;
   private boolean iyk;
   private boolean iyl;
   private static ItemStack[] iym;

   ixu() {
      super(a.c(1506693919, "卻⫙ꀕ㹦떬"), a.c(-1430329951, "\ue5e5鱧ᚫ裘̒"), true, 1, 2, 152.0F, 3.0F);

      for (int var1 = 0; var1 < iyd.length; var1++) {
         this.iye[var1] = ItemStack.field_8037;
         this.iyg[var1] = new vcj(5.0F);
      }
   }

   @Override
   public List<vmo> settings() {
      return OPTIONS;
   }

   @Override
   void update(float var1, boolean var2) {
      this.iyj = HANDS.get() ? 6 : 4;
      ClientPlayerEntity var3 = MinecraftClient.method_1551().field_1724;
      boolean var4 = false;
      if (var3 != null) {
         for (int var5 = 0; var5 < 4; var5++) {
            var4 |= !var3.method_6118(iyd[var5]).method_7960();
         }
      }

      this.iyl = !var4 && var2;

      for (int var8 = 0; var8 < iyd.length; var8++) {
         ItemStack var6 = var8 >= this.iyj
            ? ItemStack.field_8037
            : (this.iyl ? iyp(var8) : (var3 != null ? var3.method_6118(iyd[var8]) : ItemStack.field_8037));
         int var7 = var6.method_7963() ? var6.method_7919() : 0;
         if (!this.iyl && var6.method_7909() == this.iye[var8].method_7909() && var7 > this.iyf[var8]) {
            this.iyg[var8].set(1.0F);
         }

         this.iye[var8] = var6;
         this.iyf[var8] = var7;
         this.iyg[var8].step(0.0F, var1);
      }

      this.iyk = var4 || this.iyl;
      this.iyh.step(iyq() ? 27.0F + izx.VALUE.width(a.b("\ueb85鈵ᣦ蚂", -91362384)) : 10.0F + this.iyj * 21.0F + (this.iyj - 1) * 1.5F, var1);
      this.iyi.step(iyq() ? 10.0F + this.iyj * 16.0F - 2.0F : 22.0F + (iyr() ? (iys() ? 10.5F : 8.5F) : 4.0F), var1);
   }

   private static ItemStack iyp(int var0) {
      if (iym == null) {
         Item[] var1 = new Item[]{Items.field_22027, Items.field_22028, Items.field_8348, Items.field_8285, Items.field_22022, Items.field_8288};
         float[] var2 = new float[]{0.06F, 0.31F, 0.64F, 0.9F, 0.15F, 0.0F};
         iym = new ItemStack[var1.length];

         for (int var3 = 0; var3 < var1.length; var3++) {
            ItemStack var4 = new ItemStack(var1[var3]);
            if (var4.method_7963()) {
               var4.method_7974(Math.round(var4.method_7936() * var2[var3]));
            }

            iym[var3] = var4;
         }
      }

      return iym[var0];
   }

   private static boolean iyq() {
      return LAYOUT.is(a.d("\uee9b霆ᷖ莾ࡱ軃", 1881489591, 1098100329));
   }

   private static boolean iyr() {
      return !DURABILITY.is(a.c(1506710165, "鋔\ueb46憆"));
   }

   private static boolean iys() {
      return !DURABILITY.is(a.c(-1587663214, "⻅坁\udd85䏥젴于\uf4c7"));
   }

   @Override
   boolean hasContent(boolean var1) {
      return this.iyk;
   }

   @Override
   boolean canGhost() {
      return true;
   }

   @Override
   boolean isSample() {
      return this.iyl;
   }

   @Override
   float width() {
      return this.iyh.get();
   }

   @Override
   float height() {
      return this.iyi.get();
   }

   @Override
   void draw(DrawContext var1, float var2, boolean var3) {
      float var4 = this.width();
      float var5 = this.height();
      izx.panel(var1, var4, var5, iov.r(7.0F));
      uut.pushScissor(var1, 0.0F, 0.0F, var4, var5);

      for (int var6 = 0; var6 < this.iyj; var6++) {
         if (iyq()) {
            this.iyu(var1, var6, 5.0F, 5.0F + var6 * 16.0F, var4 - 10.0F);
         } else {
            this.iyt(var1, var6, 5.0F + var6 * 22.5F, 5.0F);
         }
      }

      uut.popScissor(var1);
   }

   private void iyt(DrawContext var1, int var2, float var3, float var4) {
      ItemStack var5 = this.iye[var2];
      float var6 = var3 + 10.5F;
      if (var2 == 4) {
         uut.rect(var1, var3 - 0.75F - 0.5F, var4 + 2.0F, 1.0F, this.height() - 10.0F - 4.0F, ujt.mulAlpha(iov.textMuted, 0.3F));
      }

      if (var5.method_7960()) {
         uut.circle(var1, var6, var4 + 6.0F, 1.3F, ujt.mulAlpha(iov.textMuted, 0.4F));
      } else {
         iyv(var1, var5, var6, var4 + 6.0F);
         float var7 = iyw(var5);
         if (iyr()) {
            String var8 = iyx(var5, var7);
            izx.SMALL.drawCentered(var1, var8, var6, izx.SMALL.centerTop(var4 + 12.0F + 4.4F), this.iyy(var2, var7));
         }

         if (iys() && var7 >= 0.0F) {
            float var10 = 14.0F;
            float var9 = var4 + 12.0F + (iyr() ? 8.6F : 2.2F);
            iyz(var1, var6 - var10 * 0.5F, var9, var10, var7);
         }
      }
   }

   private void iyu(DrawContext var1, int var2, float var3, float var4, float var5) {
      ItemStack var6 = this.iye[var2];
      float var7 = var4 + 6.0F + 0.5F;
      if (var6.method_7960()) {
         uut.circle(var1, var3 + 6.0F, var7, 1.3F, ujt.mulAlpha(iov.textMuted, 0.4F));
      } else {
         iyv(var1, var6, var3 + 6.0F, var7);
         float var8 = iyw(var6);
         if (iyr()) {
            izx.VALUE.drawRight(var1, iyx(var6, var8), var3 + var5, izx.VALUE.centerTop(var7), this.iyy(var2, var8));
         }

         if (iys() && var8 >= 0.0F) {
            float var9 = var3 + 12.0F + 4.0F;
            float var10 = iyr() ? var5 - (var9 - var3) - izx.VALUE.width(a.c(428345310, "߫繛\uf488櫬")) - 4.0F : var5 - (var9 - var3);
            iyz(var1, var9, var7 - 0.65F, var10, var8);
         }
      }
   }

   private static void iyv(DrawContext var0, ItemStack var1, float var2, float var3) {
      float var4 = 0.75F * Math.min(1.0F, uut.alpha() * 2.5F);
      if (var4 > 0.02F) {
         var0.method_51448().pushMatrix();
         var0.method_51448().translate(var2, var3);
         var0.method_51448().scale(var4, var4);
         var0.method_51427(var1, -8, -8);
         var0.method_51448().popMatrix();
      }
   }

   private static float iyw(ItemStack var0) {
      return var0.method_7963() && var0.method_7936() > 0 ? Math.max(0.0F, 1.0F - (float)var0.method_7919() / var0.method_7936()) : -1.0F;
   }

   private static String iyx(ItemStack var0, float var1) {
      if (var1 < 0.0F) {
         return var0.method_7947() > 1 ? a.b("鏼", 2119340933) + var0.method_7947() : "";
      } else {
         return Math.round(var1 * 100.0F) + a.d("폯", 471154364, 1698557303);
      }
   }

   private int iyy(int var1, float var2) {
      int var3 = iov.text;
      if (var2 >= 0.0F && var2 < 0.5F) {
         var3 = var2 < 0.2F ? -1092784 : ujt.lerp(iov.text, -865972, (0.5F - var2) / 0.3F);
      }

      if (var2 >= 0.0F && var2 < 0.12F) {
         float var4 = 0.5F + 0.5F * (float)Math.cos(System.nanoTime() / 1.0E9 * Math.PI * 3.0);
         var3 = ujt.lerp(-1092784, -1, 0.35F * var4);
      }

      return ujt.lerp(var3, -1, this.iyg[var1].get());
   }

   private static void iyz(DrawContext var0, float var1, float var2, float var3, float var4) {
      float var5 = 1.3F;
      uut.round(var0, var1, var2, var3, var5, var5 * 0.5F, iov.track);
      uut.round(var0, var1, var2, Math.max(var5, var3 * var4), var5, var5 * 0.5F, iza(var4));
   }

   private static int iza(float var0) {
      return var0 > 0.5F ? ujt.lerp(-865972, -12595334, (var0 - 0.5F) * 2.0F) : ujt.lerp(-1092784, -865972, var0 * 2.0F);
   }
}
