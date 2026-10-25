package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.KeyInput;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

public final class iwf extends Screen {
   private static final float iwg = (float) (Math.PI * 2);
   private static final float iwh = 30.0F;
   private static final float iwi = 12.0F;
   private static final float iwj = 19.0F;
   private static final float iwk = 9.0F;
   private static final long iwl = 240000000L;
   private final ivw iwm;
   private final int iwn;
   private final long iwo = System.nanoTime();
   private final vcj iwp = new vcj(20.0F);
   private final vcj iwq = new vcj(18.0F);
   private final List<vcj> iwr = new ArrayList<>();
   private List<ivx> iws = List.of();
   private int iwt = -1;
   private int iwu = -1;
   private int iwv;
   private boolean iww;
   private boolean iwx = true;
   private boolean iwy;
   private long iwz = -1L;
   private float ixa = 0.016666668F;
   private static final int ixb = 37;

   public iwf(ivw var1, int var2) {
      super(Text.method_43470(a.b("ࠦ熨ﭶ攇\ueed9", 251660404)));
      this.iwm = var1;
      this.iwn = var2;
      this.iww = var2 == -1;
   }

   private void ixe(DrawContext var1) {
      unf.observe(var1);
      if (unf.frame() != this.iwz) {
         this.iwz = unf.frame();
         this.ixa = unf.delta() * (float)iov.ANIMATION.get();
         iov.update(this.ixa);
         this.iwp.step(true, this.ixa);
      }
   }

   public void method_25420(DrawContext var1, int var2, int var3, float var4) {
      uut.beginFrame();
      this.ixe(var1);
      hyv.skip();
      uut.rect(var1, 0.0F, 0.0F, this.field_22789, this.field_22790, ujt.withAlpha(0, Math.round(64.0F * vcq.outCubic(this.iwp.get()))));
   }

   public void method_25394(DrawContext var1, int var2, int var3, float var4) {
      this.ixe(var1);
      this.iws = this.iwm.slots();
      int var5 = this.iws.size();
      if (var5 == 0) {
         this.ixl();
      } else {
         while (this.iwr.size() < var5) {
            this.iwr.add(new vcj(18.0F));
         }

         float var6 = vcq.outCubic(this.iwp.get());
         float var7 = this.field_22789 * 0.5F;
         float var8 = this.field_22790 * 0.5F;
         float var9 = this.iwq.step(this.iwu >= 0, this.ixa);
         this.iwt = this.iwu < 0 && !this.iwy ? ixg(var2 - var7, var3 - var8, var5) : -1;
         this.ixi();
         uut.pushAlpha(var6 * (1.0F - 0.6F * var9));

         try {
            this.ixh(var1, var7, var8, var5, 0.9F + 0.1F * var6);
         } finally {
            uut.popAlpha();
         }

         if (var9 > 0.01F) {
            uut.pushAlpha(var9);

            try {
               this.ixr(var1, var2, var3, var9);
            } finally {
               uut.popAlpha();
            }
         }
      }
   }

   private static float ixf(int var0) {
      return Math.max(50.0F, var0 * 42.0F / (float) (Math.PI * 2));
   }

   private static int ixg(float var0, float var1, int var2) {
      if (var0 * var0 + var1 * var1 < 144.0F) {
         return -1;
      } else {
         float var3 = (float)(Math.atan2(var0, -var1) / (float) (Math.PI * 2));
         if (var3 < 0.0F) {
            var3++;
         }

         return (int)Math.floor(var3 * var2 + 0.5F) % var2;
      }
   }

   private void ixh(DrawContext var1, float var2, float var3, int var4, float var5) {
      float var6 = ixf(var4) * var5;
      float var7 = 30.0F * var5;
      float var8 = var6 + var7 * 0.5F;
      float var9 = var7 * 0.5F / var6 / (float) (Math.PI * 2);
      float var10 = Math.max(0.004F, 1.0F / var4 - 2.0F * var9 - 0.012F);
      int var11 = ujt.withAlpha(iov.window, 236);
      int var12 = ujt.withAlpha(ujt.lerp(iov.window, iov.accent(), 0.32F), 246);

      for (int var13 = 0; var13 < var4; var13++) {
         ivx var14 = this.iws.get(var13);
         float var15 = this.iwr.get(var13).step(var13 == this.iwt, this.ixa);
         float var16 = (float)var13 / var4 - var10 * 0.5F;
         float var17 = 3.0F * var15;
         uut.arc(var1, var2, var3, var8 + var17 + 0.8F, var7 + var17 + 1.6F, var16, var10, ujt.lerp(ujt.withAlpha(16777215, 26), iov.accent(210), var15));
         uut.arc(var1, var2, var3, var8 + var17, var7 + var17, var16, var10, ujt.lerp(var11, var12, var15));
         float var18 = (float)var13 / var4 * (float) (Math.PI * 2);
         float var19 = var6 + var17 * 0.5F;
         float var20 = var2 + (float)Math.sin(var18) * var19;
         float var21 = var3 - (float)Math.cos(var18) * var19;
         boolean var22 = var14.note() != null && !var14.note().isEmpty();
         if (var14.icon().method_7960()) {
            vjf.draw(var1, vhz.PLUS, var20, var21, 9.0F * var5, ujt.lerp(iov.textMuted, iov.accent(), var15));
         } else if (!(this.iwq.get() > 0.01F)) {
            float var23 = (var14.usable() ? 1.15F + 0.15F * var15 : 0.8F) * var5 * uut.alpha();
            float var24 = var22 ? 3.0F : 0.0F;
            var1.method_51448().pushMatrix();
            var1.method_51448().translate(var20, var21 - var24);
            var1.method_51448().scale(var23, var23);
            var1.method_51427(var14.icon(), -8, -8);
            var1.method_51448().popMatrix();
            if (var14.cooldown() > 0.001F) {
               uut.arc(
                  var1,
                  var20,
                  var21 - var24,
                  11.0F * var5,
                  1.5F,
                  0.0F,
                  Math.min(1.0F, var14.cooldown()),
                  iov.accent(),
                  iov.accent2(),
                  iov.accent2(),
                  iov.accent()
               );
            }

            if (var22) {
               irr.SMALL
                  .drawCentered(
                     var1, var14.note(), var20, irr.SMALL.centerTop(var21 + 10.5F * var5), var14.usable() ? ujt.lerp(iov.textDim, iov.text, var15) : -1096636
                  );
            }
         }
      }

      float var25 = Math.min(22.0F, var6 - var7 * 0.5F - 6.0F);
      uut.circle(var1, var2, var3, var25, ujt.withAlpha(iov.window, 236));
      uut.circleOutline(var1, var2, var3, var25, 1.0F, ujt.withAlpha(16777215, 26));
      if (this.iwt >= 0) {
         float var26 = Math.min(0.2F, 0.8F / var4);
         uut.arc(var1, var2, var3, var25 + 2.4F, 1.6F, (float)this.iwt / var4 - var26 * 0.5F, var26, iov.accent());
      }

      irr.SMALL
         .drawCentered(
            var1, irr.SMALL.ellipsize(this.iwm.title(), var25 * 2.0F - 6.0F), var2, irr.SMALL.centerTop(var3), this.iwt >= 0 ? iov.text : iov.textDim
         );
      float var27 = var3 + var8 + 16.0F;
      if (this.iwt >= 0 && !this.iws.get(this.iwt).icon().method_7960()) {
         ivx var29 = this.iws.get(this.iwt);
         String var30 = irr.NAME.ellipsize(var29.title(), 170.0F);
         float var31 = irr.NAME.width(var30) + 18.0F;
         uut.round(var1, var2 - var31 * 0.5F, var27 - 8.0F, var31, 16.0F, 8.0F, ujt.withAlpha(iov.window, 236));
         uut.outline(var1, var2 - var31 * 0.5F, var27 - 8.0F, var31, 16.0F, 8.0F, 1.0F, iov.accent(150));
         irr.NAME.drawCentered(var1, var30, var2, irr.NAME.centerTop(var27), var29.usable() ? iov.text : iov.textDim);
      } else {
         String var28 = this.iwt >= 0
            ? wap.s(
               a.d("國⺕ꑃ㨸뇧㜇赎Ӽ骨သ韍涠\ue361窕\uf087癹챸䏠\ud94e弎훱", 1038676911, 1279173874), a.d("湿\u17ef鴿͌貛ਰ둱㷹ꏜ⤜꺿咼\uda65䞸짴佺\uf540窐\ue02b晳\ueff3", 69050018, 1100346578)
            )
            : (
               this.iwm.editable()
                  ? wap.s(
                     a.c(505175437, "巹⑳꺮バ묛㷾蟮ฐ遊\u1af1鴪朐\ue986灶勇粑웜䤇펼嗦\udc0bꘔ⢽댯㕛뾃ؿ衧ኒ钆ὼ\ue1b0毸\uf25a瑀ﻬ䄪쭓"),
                     a.b("㶉䐽컨咥\udb6d川\ue390渎\uf059窚﵅ܷ觯ᑑ鸘ᲈꚺ⥢동㖍밀왟䲀퍎啎\udfea晘\ue801狿\uf4d9", 415316360)
                  )
                  : (
                     this.iww
                        ? wap.s(a.b("䯤㉺뢬⛗괈⯲釠\u181e蘏\u0cf7謹煙ﾆ", -1182839894), a.d("蟃\ufe53璃\ueaf0愠\ue794嶽퐻乱샟䜍륢㎪ꩤ⁂ꚲᳵ錭৩边", -1787070255, 56163100))
                        : wap.s(
                           a.c(990576780, "Ó祋\uf389涬\ue63c悅\uda99匧쵡䟃쀇㨤뒲ⴌ꜑↩鯻ᐻ躀"),
                           a.c(1612343526, "泦ᔋ龥ƨ詽\u0ccf뛦㽭ꅅ\u2fe1갨噞\ud88a䄺쭬䷤\uf3c8砄\ue2ba擯\ue90c靂ᦎ航є躍㜷뤑⎚ꗉ")
                        )
                  )
            );
         irr.SMALL.drawCentered(var1, var28, var2, irr.SMALL.centerTop(var27), ujt.withAlpha(16777215, 170));
      }
   }

   private void ixi() {
      if (!this.iwy && this.iwu < 0 && this.field_22787 != null) {
         boolean var1 = this.iwn != -1 && vzz.isDown(this.field_22787, this.iwn);
         if (this.iww) {
            if (var1 && !this.iwx) {
               this.ixl();
            }
         } else if (!var1) {
            if (this.iwt >= 0) {
               this.ixj(this.iwt);
            } else if (System.nanoTime() - this.iwo < 240000000L) {
               this.iww = true;
            } else {
               this.ixl();
            }
         }

         this.iwx = var1;
      }
   }

   private void ixj(int var1) {
      if (!this.iwy && var1 >= 0 && var1 < this.iws.size()) {
         if (this.iwm.editable() && this.iws.get(var1).icon().method_7960()) {
            this.ixk(var1);
         } else {
            this.iwm.pick(var1);
            this.ixl();
         }
      }
   }

   private void ixk(int var1) {
      this.iwu = var1;
      this.iwv = var1;
      this.iww = true;
      this.iwx = true;
   }

   private void ixl() {
      if (!this.iwy) {
         this.iwy = true;
         if (this.field_22787 != null) {
            this.field_22787.method_63588(() -> {
               if (this.field_22787.field_1755 == this) {
                  this.field_22787.method_1507(null);
               }
            });
         }
      }
   }

   public boolean method_25402(Click var1, boolean var2) {
      if (this.iwy) {
         return true;
      } else if (this.iwu >= 0) {
         this.ixt((float)var1.comp_4798(), (float)var1.comp_4799(), var1.method_74245());
         return true;
      } else {
         int var3 = this.iws.isEmpty()
            ? -1
            : ixg((float)var1.comp_4798() - this.field_22789 * 0.5F, (float)var1.comp_4799() - this.field_22790 * 0.5F, this.iws.size());
         if (var3 < 0) {
            return true;
         } else {
            if (var1.method_74245() == 1 && this.iwm.editable()) {
               this.ixk(var3);
            } else if (var1.method_74245() == 0 && (!vzz.isMouse(this.iwn) || vzz.mouseButton(this.iwn) != 0)) {
               this.ixj(var3);
            }

            return true;
         }
      }
   }

   public boolean method_25404(KeyInput var1) {
      int var2 = var1.comp_4795();
      if (var2 == 256) {
         if (this.iwu >= 0) {
            this.iwu = -1;
         } else {
            this.ixl();
         }
      } else if (this.iwu < 0 && var2 >= 49 && var2 <= 57 && var2 != vzz.baseKey(this.iwn)) {
         this.ixj(var2 - 49);
      }

      return true;
   }

   private static int ixm(int var0) {
      return var0 < 27 ? 9 + var0 : (var0 < 36 ? var0 - 27 : 40);
   }

   private float ixn() {
      return 189.0F;
   }

   private float ixo() {
      return 130.0F;
   }

   private float ixp(int var1) {
      return this.field_22789 * 0.5F - this.ixn() * 0.5F + 9.0F + (var1 < 36 ? var1 % 9 : 0) * 19.0F;
   }

   private float ixq(int var1) {
      float var2 = this.field_22790 * 0.5F - this.ixo() * 0.5F + 17.0F;
      return var1 < 27 ? var2 + var1 / 9 * 19.0F : (var1 < 36 ? var2 + 57.0F + 4.0F : var2 + 76.0F + 9.0F);
   }

   private void ixr(DrawContext var1, float var2, float var3, float var4) {
      float var5 = this.ixn();
      float var6 = this.ixo();
      float var7 = this.field_22789 * 0.5F - var5 * 0.5F;
      float var8 = this.field_22790 * 0.5F - var6 * 0.5F + (1.0F - var4) * 5.0F;
      float var9 = iov.r(8.0F);
      uut.shadow(var1, var7, var8 + 3.0F, var5, var6, var9, 14.0F, iov.shadow);
      uut.round(var1, var7, var8, var5, var6, var9, ujt.withAlpha(iov.window, 255));
      uut.outline(var1, var7, var8, var5, var6, var9, 1.0F, iov.stroke);
      irr.VALUE
         .draw(
            var1,
            wap.s(a.b("㝮仩쐸婃톜圦\ued6f擊", -699320523), a.b("ￍ蘔ವ鋈ᤜ龧⇤", 196148197))
               + (this.iwv + 1)
               + wap.s(a.b("℃墨툫䱃잞䄧\ufb3f犏\uecdf映\ue1baᯖ锐\u0ca9", 2117804343), a.b("㚗似쇽念푘勭\ue8cb慂ｧ疡\uf667ࠉ蚡ὥ锷Ꮞꦈ☮", -689621313)),
            var7 + 9.0F,
            irr.VALUE.centerTop(var8 + 9.5F),
            iov.text
         );
      PlayerInventory var10 = this.field_22787 != null && this.field_22787.field_1724 != null ? this.field_22787.field_1724.method_31548() : null;
      float var11 = iov.r(3.5F);

      for (int var12 = 0; var12 < 37; var12++) {
         float var13 = this.ixp(var12);
         float var14 = this.ixq(var12) + (1.0F - var4) * 5.0F;
         ItemStack var15 = var10 == null ? ItemStack.field_8037 : var10.method_5438(ixm(var12));
         boolean var16 = !var15.method_7960() && irr.inside(var2, var3, var13, var14, 17.5F, 17.5F);
         uut.round(var1, var13, var14, 17.5F, 17.5F, var11, var16 ? iov.fieldHover : iov.field);
         if (var16) {
            uut.outline(var1, var13, var14, 17.5F, 17.5F, var11, 1.0F, iov.accent());
         }

         if (!var15.method_7960() && var4 > 0.5F) {
            var1.method_51448().pushMatrix();
            var1.method_51448().translate(var13 + 8.75F, var14 + 8.75F);
            var1.method_51427(var15, -8, -8);
            var1.method_51448().popMatrix();
         }
      }

      float var17 = this.ixq(36) + (1.0F - var4) * 5.0F + 8.75F;
      irr.SMALL
         .draw(
            var1,
            wap.s(a.d("큀꧸⌫뵔㚊뀴੭", -1775130896, -1335134504), a.c(-1056576496, "\ue829釨ᭇ蕈\u0eef蠡㘝뮌◐꼘⣁")),
            this.ixp(36) + 19.0F + 3.0F,
            irr.SMALL.centerTop(var17),
            iov.textMuted
         );
      float var18 = this.ixs();
      float var19 = var7 + var5 - 9.0F - var18;
      boolean var20 = irr.inside(var2, var3, var19, var17 - 7.0F, var18, 14.0F);
      uut.round(var1, var19, var17 - 7.0F, var18, 14.0F, iov.r(4.0F), var20 ? iov.fieldHover : iov.field);
      irr.VALUE
         .drawCentered(
            var1,
            wap.s(a.b("ℵ墫퉱䰄쟀", 986980723), a.c(1785362391, "珁\u0a29肅ẍ镙᎒ꦻ⁄")),
            var19 + var18 * 0.5F,
            irr.VALUE.centerTop(var17),
            var20 ? iov.text : iov.textDim
         );
   }

   private float ixs() {
      return irr.VALUE.width(wap.s(a.c(-671545764, "ؚ羄\uf55e欫\ue0ef"), a.c(2096318454, "䏠㨈낤⺬ꕸ⎳馚ၥ"))) + 14.0F;
   }

   private void ixt(float var1, float var2, int var3) {
      float var4 = this.ixn();
      float var5 = this.ixo();
      float var6 = this.field_22789 * 0.5F - var4 * 0.5F;
      float var7 = this.field_22790 * 0.5F - var5 * 0.5F;
      if (var3 == 0 && irr.inside(var1, var2, var6, var7, var4, var5)) {
         float var8 = this.ixq(36) + 8.75F;
         float var9 = this.ixs();
         if (irr.inside(var1, var2, var6 + var4 - 9.0F - var9, var8 - 7.0F, var9, 14.0F)) {
            this.iwm.assign(this.iwu, ItemStack.field_8037);
            this.iwu = -1;
         } else if (this.field_22787 != null && this.field_22787.field_1724 != null) {
            PlayerInventory var10 = this.field_22787.field_1724.method_31548();

            for (int var11 = 0; var11 < 37; var11++) {
               ItemStack var12 = var10.method_5438(ixm(var11));
               if (!var12.method_7960() && irr.inside(var1, var2, this.ixp(var11), this.ixq(var11), 17.5F, 17.5F)) {
                  this.iwm.assign(this.iwu, var12);
                  this.iwu = -1;
                  return;
               }
            }
         }
      } else {
         this.iwu = -1;
      }
   }

   public boolean method_25421() {
      return false;
   }

   public boolean method_25422() {
      return false;
   }
}
