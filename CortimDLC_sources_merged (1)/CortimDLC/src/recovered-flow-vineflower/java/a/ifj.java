package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;

final class ifj extends imn {
   static final int ifk = 6;
   static final float ifl = 24.0F;
   static final float ifm = 2.0F;
   static final float ifn = 16.0F;
   static final float ifo = 18.0F;
   final Map<Integer, vcj[]> ifp = new HashMap<>();

   ifj() {
      super(null);
   }

   static List<PlayerEntity> ifs() {
      MinecraftClient var0 = MinecraftClient.getInstance();
      ArrayList<PlayerEntity> var1 = new ArrayList<>();
      if (var0.world != null && var0.player != null) {
         for (PlayerEntity var3 : var0.world.getPlayers()) {
            if (var3 != var0.player && !var3.isSpectator()) {
               var1.add(var3);
            }
         }

         var1.sort(Comparator.comparingDouble(var1x -> var1x.squaredDistanceTo(var0.player)));
         return var1.size() > 6 ? var1.subList(0, 6) : var1;
      } else {
         return var1;
      }
   }

   @Override
   float height() {
      int var1 = ifs().size();
      return var1 == 0 ? 30.0F : 2.0F + var1 * 26.0F;
   }

   float ift(int var1) {
      return this.y + 2.0F + var1 * 26.0F;
   }

   float ifu() {
      return this.x + this.w - 5.0F - 18.0F;
   }

   @Override
   void render(DrawContext var1, hlc var2, float var3, float var4, float var5) {
      List var6 = ifs();
      if (var6.isEmpty()) {
         this.ifp.clear();
         vjf.draw(var1, vhz.PLAYER, this.x + 8.0F, this.y + 15.0F, 9.0F, iov.textMuted);
         irr.LABEL
            .draw(
               var1,
               wap.s(a.c(1733954015, "জ瀌㮝撮\uef72槞폔婤쐨亄쥍㌧뷺"), a.b("䭌㋑렆☍귙⬘镘ᢴ蛮ౝ變燶Ｌ", 439045971)),
               this.x + 18.0F,
               irr.LABEL.centerTop(this.y + 15.0F),
               iov.textDim
            );
      } else {
         MinecraftClient var7 = MinecraftClient.getInstance();
         float var8 = iov.r(6.0F);

         for (int var9 = 0; var9 < var6.size(); var9++) {
            PlayerEntity var10 = (PlayerEntity)var6.get(var9);
            vcj[] var11 = this.ifp.computeIfAbsent(var10.getId(), var0 -> new vcj[]{new vcj(14.0F), new vcj(18.0F)});
            float var12 = this.ift(var9);
            float var13 = var12 + 12.0F;
            boolean var14 = var2.canHover() && irr.inside(var3, var4, this.x, var12, this.w, 24.0F);
            float var15 = var11[0].step(var14, var5);
            if (var15 > 0.01F) {
               uut.round(var1, this.x, var12, this.w, 24.0F, var8, ujt.withAlpha(iov.hover, (int)(ujt.alpha(iov.hover) * 1.6F * var15)));
            }

            String var16 = hhf.nameOf(var10);
            boolean var17 = hhf.isFriend(var16);
            hyj.face(var1, var16, var10 instanceof AbstractClientPlayerEntity var18 ? var18.getSkin() : null, this.x + 4.0F, var13 - 8.0F, false);
            float var24 = this.x + 4.0F + 16.0F + 7.0F;
            String var19 = Math.round(Math.sqrt(var10.squaredDistanceTo(var7.player))) + wap.unit(a.d("㯻", -2040818452, 657698683));
            float var20 = this.ifu() - var24 - irr.SMALL.width(var19) - 10.0F;
            float var21 = irr.NAME.draw(var1, irr.NAME.ellipsize(lsx.protect(var16), var20), var24, irr.NAME.centerTop(var13), var17 ? -11870592 : iov.text);
            irr.SMALL.draw(var1, var19, var21 + 5.0F, irr.SMALL.centerTop(var13 + 0.4F), iov.textMuted);
            boolean var22 = var2.canHover() && irr.inside(var3, var4, this.ifu(), var13 - 9.0F, 18.0F, 18.0F);
            float var23 = var11[1].step(var22, var5);
            if (var17) {
               uut.round(var1, this.ifu(), var13 - 9.0F, 18.0F, 18.0F, iov.r(4.0F), ujt.withAlpha(-11870592, (int)(40.0F + 30.0F * var23)));
               vjf.draw(var1, var23 > 0.5F ? vhz.CLOSE : vhz.HEART, this.ifu() + 9.0F, var13, 7.5F, -11870592);
            } else {
               irr.iconButton(var1, vhz.USER_PLUS, this.ifu(), var13 - 9.0F, 18.0F, var23, false, 0.55F + 0.45F * Math.max(var15, var23));
            }

            if (var22) {
               var2.hint(
                  var17
                     ? wap.s(
                        a.b("\ud92aꂬ⩷됄㿊륨;", 466278783) + var16 + a.d("땇첰䙷\ud81b収픲漧\ue6c2碆\uf23b痣辘Ř", -1681526194, 716261156),
                        a.d("䦼〟몽Ⓖ꼙⦦鞙", 503321214, -1036689434) + var16 + a.b("Ჶ感\uebc3熥﹦碣싳䭶픫徖", -123986788)
                     )
                     : wap.s(
                        a.b("\ufb3f芫ࡸ降", 1699937146) + var16 + a.b("\ude4fꞪⵢ덜㣍빨Р距ᎉ餲Ỷ", 57990756),
                        a.d("\uf800膛େ锷Ợ顙≰ꮏㆼ", 601182943, 1303228098) + var16 + a.c(43683827, "迚\uf279粸\ue6dd浾\uebcc凫\ud861䘽")
                     )
               );
            }
         }
      }
   }

   @Override
   boolean mouseClicked(hlc var1, float var2, float var3, int var4) {
      List var5 = ifs();

      for (int var6 = 0; var6 < var5.size(); var6++) {
         float var7 = this.ift(var6);
         if (irr.inside(var2, var3, this.x, var7, this.w, 24.0F)) {
            if (var4 == 0) {
               String var8 = hhf.nameOf((PlayerEntity)var5.get(var6));
               boolean var9 = hhf.toggle(var8);
               var1.toast(
                  var9
                     ? wap.s(a.c(2106396642, "ྥ瘱ﳢ抒\ue944澱"), a.d("镸\uece3昿\uf84f玚\uf522使욆峄", 1401265260, -1967059703)) + var8
                     : wap.s(a.d("밎얈体턠嫮\udc4c昞\uefab", -972813567, -79644843), a.b("剪⯌ꄛ㽡드㈁豏", -913090994)) + var8,
                  var9 ? vhz.FRIENDS : vhz.TRASH,
                  false
               );
            }

            return true;
         }
      }

      return false;
   }
}
