package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;

public final class jie extends jeq<jht> {
   public static final vkl HIDE_VANILLA = new vkl(a.b("뵐쓀丞큮导\udd1b束\ueea1烹祉綞蟢ॴ邌\u1ad5鰨♦ꦪ", -604521206), true);
   public static final vkl BARS = new vkl(a.b("ᄌ梀\ue257簮\uf7bc煏쬟䋽\udca3", -1391849135), true);
   public static final vlv COLORS = new vlv(
      a.b("ꑛ\uddc9圉줪䊾쐃繓\uf7a1槤\ue352", -786389997), a.d("砷Ƥ護ᔀ黜ᡷ", -416103728, -554845536), a.b("\uf54a賙؊顽Ꭱ锊", 550106381), a.b("䖙㰋뛘⢪ꍻ◝", -1880013350)
   );
   private static final float jif = 15.0F;
   private static final float jig = 10.0F;
   private final Map<String, Integer> jih = new HashMap<>();

   jie() {
      super(a.b("ﾏ蘡೩銅ᥔ鿤▪", -783024136), a.c(-1335372626, "퓹굷➿맓㈂뒲\u0efc"), vhz.POTION, true, 2, 0, 6.0F, 6.0F);
   }

   @Override
   public List<vmo> settings() {
      return List.of(HIDE_VANILLA, BARS, COLORS);
   }

   public static boolean hidesVanilla() {
      return izx.ENABLED.get() && izx.POTIONS.enabled.get() && HIDE_VANILLA.get();
   }

   @Override
   List<jht> items(boolean var1) {
      MinecraftClient var2 = MinecraftClient.method_1551();
      ArrayList var3 = new ArrayList();
      HashSet var4 = new HashSet();
      if (var2.field_1724 != null) {
         for (StatusEffectInstance var6 : var2.field_1724.method_6026()) {
            if (var6.method_5592()) {
               String var7 = var6.method_5579().method_55840();
               var4.add(var7);
               int var8 = var6.method_5584();
               int var9 = Math.max(var8, this.jih.getOrDefault(var7, 0));
               this.jih.put(var7, var9);
               var3.add(
                  jik(var7, var6.method_5579(), var6.method_5578(), var8, var6.method_48559(), var6.method_48559() ? 1.0F : (float)var8 / Math.max(1, var9))
               );
            }
         }
      }

      this.jih.keySet().retainAll(var4);
      if (var3.isEmpty() && var1) {
         var3.add(jik(a.d("퇬ꡟ⊛볹㜱놌்艱ᱧ雕ᄓ\ueb62斴", -1872825723, 1786848020), StatusEffects.field_5904, 1, 1640, false, 0.72F));
         var3.add(jik(a.b("襰\uf0c3稇\ue465澭\ue910卑\udaed䓻칍䦘돾㴢꒚⻚꠷", -592672496), StatusEffects.field_5910, 0, 780, false, 0.35F));
         var3.add(jik(a.c(-60203935, "尝▮꽪ㄈ뫀㱽蘼ྀ醃ᬽ鳵暓"), StatusEffects.field_5918, 0, 150, false, 0.08F));
      }

      var3.sort(Comparator.<jht, Boolean>comparing(var0 -> !var0.jhy).thenComparing(var0 -> -var0.jhx));
      return var3;
   }

   private static jht jik(String var0, RegistryEntry<StatusEffect> var1, int var2, int var3, boolean var4, float var5) {
      StatusEffect var6 = (StatusEffect)var1.comp_349();
      String var7 = var6.method_5560().getString();
      if (var2 > 0) {
         var7 = var7 + a.b("잏", -1793538130) + jil(var2 + 1);
      }

      return new jht(var0, var1, var7, var3, var4, var5, 0xFF000000 | var6.method_5556(), var6.method_18792() == StatusEffectCategory.field_18272);
   }

   private static String jil(int var0) {
      String[] var1 = new String[]{
         a.d("랬", 281513375, 1300314747),
         a.b("ﶇ萶", -2023293492),
         a.d("劘⬩ꇺ", -1097380966, 1829640520),
         a.d("⣽兓", -1882600902, -579345780),
         a.c(-593828193, "\ue6c8"),
         a.c(-1122112025, "\uedb3鐝"),
         a.d("⼒嚼\udc6f", -83604543, -543136634),
         a.b("回⽰ꖣ㯒", -984787316),
         a.c(583954004, "渟ឿ"),
         a.d("聛", -1924490571, 122952375)
      };
      return var0 >= 1 && var0 <= var1.length ? var1[var0 - 1] : String.valueOf(var0);
   }

   static String time(int var0, boolean var1) {
      return var1 ? a.c(-2142459201, "袠") : vxu.clock(Math.max(0, var0 / 20));
   }

   String key(jht var1) {
      return var1.jhu;
   }

   @Override
   float rowHeight() {
      return 15.0F;
   }

   float rowWidth(jht var1) {
      return 14.0F + izx.TEXT.width(var1.jhw) + 12.0F + izx.VALUE.width(time(var1.jhx, var1.jhy));
   }

   void drawRow(DrawContext var1, jht var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      boolean var9 = BARS.get();
      float var10 = var4 + (var9 ? 6.0F : var6 * 0.5F);
      int var11 = ujt.withAlpha(16777215, Math.round(255.0F * uut.alpha()));
      var1.method_51448().pushMatrix();
      var1.method_51448().translate(var3, var10 - 5.0F);
      var1.method_51448().scale(0.5555556F, 0.5555556F);
      var1.method_52707(RenderPipelines.field_56883, InGameHud.method_71644(var2.jhv), 0, 0, 18, 18, var11);
      var1.method_51448().popMatrix();
      float var12 = var3 + 10.0F + 4.0F;
      String var13 = time(var2.jhx, var2.jhy);
      float var14 = izx.VALUE.width(var13);
      izx.TEXT
         .draw(
            var1,
            izx.TEXT.ellipsize(var2.jhw, var5 - (var12 - var3) - var14 - 8.0F),
            var12,
            izx.TEXT.centerTop(var10),
            var2.jib ? ujt.lerp(iov.text, -1096636, 0.35F) : iov.text
         );
      float var15 = var2.jhy ? -1.0F : var2.jhx / 20.0F;
      izx.VALUE.drawRight(var1, var13, var3 + var5, izx.VALUE.centerTop(var10), expiring(iov.textDim, var15));
      if (var9) {
         int var16;
         int var17;
         if (COLORS.is(a.b("䏥㩷낤⻖ꔇ⎡", -297909338))) {
            var16 = var2.jia;
            var17 = ujt.lerp(var2.jia, -1, 0.3F);
         } else if (var2.jib) {
            var16 = -1096636;
            var17 = -429290;
         } else {
            var16 = iov.accent();
            var17 = iov.accent2();
         }

         bar(var1, var12, var4 + var6 - 3.6F, var5 - (var12 - var3), var2.jhy ? 1.0F : var2.jhz, var16, var17);
      }
   }
}
