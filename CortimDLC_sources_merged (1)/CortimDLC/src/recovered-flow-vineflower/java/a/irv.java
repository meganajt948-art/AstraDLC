package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.DrawContext;

final class irv extends imn {
   private static final float irw = 54.0F;
   private static final float irx = 6.0F;
   private static final float iry = 10.0F;
   private final List<vcj> irz = new ArrayList<>();
   private final List<vcj> isa = new ArrayList<>();

   irv() {
      super(null);
   }

   private List<isn> isd() {
      List var1 = isv.entries();

      while (this.irz.size() < var1.size()) {
         this.irz.add(new vcj(16.0F));
         this.isa.add(new vcj(14.0F));
      }

      return var1;
   }

   private int ise() {
      float var1 = this.w > 0.0F ? this.w : 376.0F;
      return Math.max(3, (int)((var1 + 6.0F) / 60.0F));
   }

   private float isf() {
      int var1 = this.ise();
      return (this.w - 6.0F * (var1 - 1)) / var1;
   }

   private float isg() {
      return this.isf() * 9.0F / 16.0F;
   }

   private int ish() {
      return (this.isd().size() + this.ise() - 1) / this.ise();
   }

   @Override
   float height() {
      float var1 = this.w > 0.0F ? this.isf() : 54.0F;
      float var2 = var1 * 9.0F / 16.0F + 10.0F;
      return 3.0F + this.ish() * var2 + (this.ish() - 1) * 6.0F;
   }

   private float isi(int var1) {
      return this.x + var1 % this.ise() * (this.isf() + 6.0F);
   }

   private float isj(int var1) {
      return this.y + 3.0F + var1 / this.ise() * (this.isg() + 10.0F + 6.0F);
   }

   @Override
   void render(DrawContext var1, hlc var2, float var3, float var4, float var5) {
      List var6 = this.isd();
      float var7 = this.isf();
      float var8 = this.isg();
      float var9 = iov.r(5.0F);

      for (int var10 = 0; var10 < var6.size(); var10++) {
         isn var11 = (isn)var6.get(var10);
         float var12 = this.isi(var10);
         float var13 = this.isj(var10);
         boolean var14 = var2.canHover() && irr.inside(var3, var4, var12, var13, var7, var8 + 10.0F);
         float var15 = this.irz.get(var10).step(var14, var5);
         float var16 = this.isa.get(var10).step(var11.key.equals(isv.selected()), var5);
         float var17 = var13 - var15;
         if (var14) {
            var2.hint(
               var11.isWorld()
                  ? wap.s(
                     a.b("픛겋☗렱㏰때༟蛲ᢼ鈜ᗚ\uefbc愹\ud8bc狛\uf47e中쇱嬇\udd11哠⺽ꀆ㮒붺㝳軝\u0092驭ᱸ鞉楟\ue31d竭ﲹ瘂즑䎴앻峇훝ꡡ∺ꖀ㽌", -1832790664),
                     a.d("䉭㯸넩⭏ꒆ∸顤ᆞ迆ťꚂ糇\uf607澱\ue1f2挟\ud959嚀챀乿쎚링㝾겮⫙ꐕᦺ韯ൠ轑ú︠琜\uede6", -1981584058, 2132683544)
                  )
                  : isv.label(var11)
                     + (
                        var11.isLive()
                           ? wap.s(a.c(1108563249, "唀ⲱ꛵㠓도㔴轨ڞ飅ቸ閾濞\ue108磽\uf2fd琔칉"), a.c(-417826806, "砥Ɣ诐ᔶ黡᱆ꘛ\u2fe0놳㬉룏䚣졼凉\udb95"))
                           : (
                              var11.isVideo()
                                 ? wap.s(a.b("쫖덧㤣ꟅⰒꫵႹ饅ܛ趠", -410727684), a.d("\uea34鎅ᧁ蜧\u0cf0蹓㐊뷷⎩ꤓ", -740380589, -1646699955))
                                 : (
                                    var11.isUser()
                                       ? wap.s(
                                          a.c(573754177, "쭮닟㢛꙽ⶪꭂᄇ飬ڴ豗்\uf1b8罣\ue6d4沅"),
                                          a.d("貌\uf53d罹\ue19f橈\ue8eb劺\udb33䔔쮵䡼눇㲠ꔓ⼺\ua9ceᎆ鱝", 296825892, -1182746470)
                                       )
                                       : wap.s(a.c(-1581872748, "覹\uf008穌\ue4aa潽\ue98e及\uda27䑽컔䥞덫㶻"), a.c(-245705572, "풳괂❆릠㉷냔\u0af4茆ᵛ鞔၌\uea35擢ﵞ睲"))
                                 )
                           )
                     )
            );
         }

         if (var16 > 0.01F) {
            uut.shadow(var1, var12, var17, var7, var8, var9, 7.0F, iov.accent((int)(70.0F * var16)));
         }

         if (var11.isWorld()) {
            uut.gradient(var1, var12, var17, var7, var8, var9, -12882264, -8408864, -9728178, -13280722);
            vjf.draw(var1, vhz.GLOBE, var12 + var7 * 0.5F, var17 + var8 * 0.5F, 11.0F, -419430401);
         } else {
            uok var18 = isv.thumbnail(var11);
            if (var18 != null) {
               uut.image(var1, var18.view, var12, var17, var7, var8, var9, -1);
            } else {
               uut.round(var1, var12, var17, var7, var8, var9, iov.field);
               vjf.draw(var1, vhz.IMAGE, var12 + var7 * 0.5F, var17 + var8 * 0.5F, 10.0F, var11.failed ? -1750963 : iov.textMuted);
            }
         }

         if (var11.isLive() || var11.isVideo()) {
            uut.circle(var1, var12 + 6.0F, var17 + var8 - 6.0F, 3.6F, -1728053248);
            vjf.draw(var1, vhz.PLAY, var12 + 6.2F, var17 + var8 - 6.0F, 4.6F, -218103809);
         }

         uut.outline(var1, var12, var17, var7, var8, var9, 1.0F, ujt.lerp(ujt.lerp(iov.stroke, iov.textMuted, var15 * 0.5F), iov.accent(), var16));
         if (var16 > 0.02F) {
            float var21 = var12 + var7 - 5.5F;
            float var19 = var17 + 5.5F;
            float var20 = vcq.outBack(var16);
            uut.pushAlpha(var16);
            var1.getMatrices().pushMatrix();
            var1.getMatrices().translate(var21, var19);
            var1.getMatrices().scale(var20, var20);
            uut.circle(var1, 0.0F, 0.0F, 3.8F, iov.accent());
            vjf.draw(var1, vhz.CHECK, 0.0F, 0.0F, 5.5F, iov.onAccent());
            var1.getMatrices().popMatrix();
            uut.popAlpha();
         }

         irr.SMALL
            .drawCentered(
               var1,
               irr.SMALL.ellipsize(isv.label(var11), var7),
               var12 + var7 * 0.5F,
               irr.SMALL.centerTop(var13 + var8 + 5.0F + 1.0F),
               ujt.lerp(ujt.lerp(iov.textMuted, iov.textDim, var15), iov.text, var16)
            );
      }
   }

   @Override
   boolean mouseClicked(hlc var1, float var2, float var3, int var4) {
      if (var4 != 0) {
         return false;
      }

      List var5 = this.isd();
      float var6 = this.isf();
      float var7 = this.isg();

      for (int var8 = 0; var8 < var5.size(); var8++) {
         if (irr.inside(var2, var3, this.isi(var8), this.isj(var8), var6, var7 + 10.0F)) {
            isv.select(((isn)var5.get(var8)).key);
            return true;
         }
      }

      return false;
   }
}
