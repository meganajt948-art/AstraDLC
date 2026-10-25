package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;

final class ibf extends ijy {
   static final float W = 430.0F;
   static final float H = 318.0F;
   static final float ibg = 12.0F;
   static final float ibh = 30.0F;
   static final float ibi = 22.0F;
   static final float ibj = 22.0F;
   static final float ibk = 20.0F;
   static final float ibl = 3.0F;
   static final float ibm = 16.0F;
   static final Map<vlg, List<iay>> ibn = new EnumMap<>(vlg.class);
   final vlj setting;
   final iah search = new iah(a.b("\ue7ed鹪ᒽ諟ę螣", -1955862600), vhz.SEARCH, 32, iah.ANY);
   final float ibo;
   final float ibp;
   final vcj ibq = new vcj(16.0F);
   final vcj ibr = new vcj(18.0F);
   final vcj[] ibs = new vcj[]{new vcj(16.0F), new vcj(16.0F), new vcj(16.0F), new vcj(16.0F), new vcj(16.0F)};
   final vcj ibt = new vcj(16.0F);
   float ibu;
   boolean ibv;
   boolean ibw;
   List<iay> ibx = List.of();
   String iby;
   String ibz;
   int ica = -1;
   final vcj icb = new vcj(20.0F);

   ibf(vlj var1, float var2, float var3) {
      this.setting = var1;
      this.ibo = (var2 - 430.0F) * 0.5F;
      this.ibp = (var3 - 318.0F) * 0.5F;
      this.search.onChange = var1x -> this.icg();
      this.icg();
   }

   static List<iay> ice(vlg var0) {
      if (var0 != vlg.LOOT) {
         return ibn.computeIfAbsent(var0, var0x -> {
            ArrayList var1x = new ArrayList();
            if (var0x == vlg.MOBS) {
               for (EntityType var3x : Registries.ENTITY_TYPE) {
                  SpawnEggItem var4 = SpawnEggItem.forEntity(var3x);
                  if (var4 != null) {
                     var1x.add(icf(Registries.ENTITY_TYPE.getId(var3x).toString(), new ItemStack(var4), var3x.getName().getString()));
                  }
               }

               var1x.sort((var0xx, var1xx) -> var0xx.ibb.compareToIgnoreCase(var1xx.ibb));
            } else if (var0x == vlg.BLOCKS) {
               for (Block var8 : Registries.BLOCK) {
                  if (var8 != Blocks.AIR && var8 != Blocks.CAVE_AIR && var8 != Blocks.VOID_AIR) {
                     Item var10 = var8.asItem();
                     if (var8 == Blocks.WATER) {
                        var10 = Items.WATER_BUCKET;
                     } else if (var8 == Blocks.LAVA) {
                        var10 = Items.LAVA_BUCKET;
                     } else if (var8 == Blocks.NETHER_PORTAL || var8 == Blocks.END_PORTAL) {
                        var10 = Items.ENDER_EYE;
                     }

                     if (var10 != Items.AIR) {
                        String var5 = Registries.BLOCK.getId(var8).toString();
                        var1x.add(icf(var5, new ItemStack(var10), var8.getName().getString()));
                     }
                  }
               }
            } else {
               for (Item var9 : Registries.ITEM) {
                  if (var9 != Items.AIR) {
                     ItemStack var11 = new ItemStack(var9);
                     var1x.add(icf(Registries.ITEM.getId(var9).toString(), var11, var11.getName().getString()));
                  }
               }
            }

            return var1x;
         });
      }

      ArrayList var1 = new ArrayList();

      for (ppn var3 : ppu.entries()) {
         var1.add(
            new iay(
               var3.id, var3.icon(), var3.shownName(), var3.name + a.c(1303515078, "\u0fe7") + var3.nameEn + a.b("캵", -420884844) + var3.id.replace('_', ' ')
            )
         );
      }

      return var1;
   }

   static iay icf(String var0, ItemStack var1, String var2) {
      String var3 = var0.startsWith(a.c(-467973585, "䩈㏽뤩❓겂⨢遢ᦔ蟙ദ")) ? var0.substring(10) : var0;
      return new iay(var0, var1, var2, var2 + a.d("戠", 1869347576, 1312856313) + var3 + a.c(-1647638294, "࣋") + var3.replace('_', ' '));
   }

   static ItemStack iconOf(vlg var0, String var1) {
      for (iay var3 : ice(var0)) {
         if (var3.iaz.equals(var1)) {
            return var3.iba;
         }
      }

      return ItemStack.EMPTY;
   }

   void icg() {
      ArrayList var1 = new ArrayList();
      String var2 = this.search.text;

      for (iay var4 : ice(this.setting.kind())) {
         if ((!this.ibv || this.setting.contains(var4.iaz)) && wap.matches(var4.ibc, var2)) {
            var1.add(var4);
         }
      }

      this.ibx = var1;
      this.ibu = Math.min(this.ibu, this.icr());
   }

   float ich() {
      return this.ibo + 12.0F;
   }

   float ici() {
      return this.ibp + 30.0F + 22.0F + 8.0F;
   }

   float icj() {
      return 406.0F;
   }

   float ick() {
      return 318.0F - (this.ici() - this.ibp) - 16.0F - 6.0F;
   }

   boolean icl() {
      return this.setting.kind() == vlg.LOOT || this.setting.kind() == vlg.MOBS;
   }

   int icm() {
      return this.icl() ? 2 : Math.max(1, (int)((this.icj() + 3.0F) / 25.0F));
   }

   float icn() {
      return this.icl() ? (this.icj() - 3.0F) * 0.5F : 22.0F;
   }

   float ico() {
      return this.icl() ? 20.0F : 22.0F;
   }

   float icp() {
      int var1 = this.icm();
      if (this.icl()) {
         return this.icn() + 3.0F;
      } else {
         return var1 <= 1 ? 25.0F : (this.icj() - 22.0F) / (var1 - 1);
      }
   }

   float icq() {
      int var1 = (this.ibx.size() + this.icm() - 1) / this.icm();
      return var1 * (this.ico() + 3.0F);
   }

   float icr() {
      return Math.max(0.0F, this.icq() - this.ick());
   }

   boolean contains(float var1, float var2) {
      return irr.inside(var1, var2, this.ibo, this.ibp, 430.0F, 318.0F);
   }

   @Override
   iah field() {
      return this.search;
   }

   @Override
   boolean gone() {
      return this.ibw && this.ibq.get() <= 0.01F;
   }

   @Override
   boolean closing() {
      return this.ibw;
   }

   @Override
   void close() {
      this.ibw = true;
   }

   @Override
   void render(DrawContext var1, hlc var2, float var3, float var4, float var5, float var6, float var7) {
      float var8 = vcq.outCubic(this.ibq.step(this.ibw ? 0.0F : 1.0F, var5));
      if (!(var8 <= 0.01F)) {
         boolean var9 = !this.ibw;
         float var10 = iov.r(10.0F);
         float var11 = iov.lightness();
         uut.round(var1, 0.0F, 0.0F, var6, var7, iov.r(12.0F), ujt.withAlpha(0, Math.round(110.0F * var8)));
         uut.pushAlpha(var8);
         var1.getMatrices().pushMatrix();
         float var12 = 0.96F + 0.04F * var8;
         var1.getMatrices().translate(this.ibo + 215.0F, this.ibp + 159.0F + (1.0F - var8) * 6.0F);
         var1.getMatrices().scale(var12, var12);
         var1.getMatrices().translate(-(this.ibo + 215.0F), -(this.ibp + 159.0F));
         uut.shadow(var1, this.ibo, this.ibp + 4.0F, 430.0F, 318.0F, var10, 18.0F, iov.shadow);
         uut.round(var1, this.ibo, this.ibp, 430.0F, 318.0F, var10, ujt.withAlpha(iov.window, 252));
         uut.round(var1, this.ibo, this.ibp, 430.0F, 318.0F, var10, iov.card);
         ukf.sheen(var1, this.ibo, this.ibp, 430.0F, 50.0F, var10, 0.8F * (1.0F - 0.7F * var11));
         uut.outline(var1, this.ibo, this.ibp, 430.0F, 318.0F, var10, 1.0F, iov.stroke);
         ukf.rim(var1, this.ibo, this.ibp, 430.0F, 318.0F, var10, var11, 1.0F);
         vjf.draw(var1, this.setting.kind() == vlg.BLOCKS ? vhz.LAYERS : vhz.MISC, this.ibo + 12.0F + 5.0F, this.ibp + 15.0F + 1.0F, 10.0F, iov.accent());
         String var13 = wap.t(this.setting.getName());
         irr.CARD_TITLE.draw(var1, var13, this.ibo + 12.0F + 16.0F, irr.CARD_TITLE.centerTop(this.ibp + 15.0F + 1.0F), iov.text);
         String var14 = this.setting.size() + wap.s(a.b("\ud9cdꀬ⫦뒝㽂맽ί", -167650838), a.b("擀ᥣ鏉ෂ虤¥뫻㌉", -1317706520));
         irr.drawChip(
            var1,
            var14,
            this.ibo + 12.0F + 16.0F + irr.CARD_TITLE.width(var13) + 8.0F + Math.max(16.0F, irr.SMALL.width(var14) + 9.0F),
            this.ibp + 15.0F + 1.0F,
            iov.textDim,
            iov.stroke,
            0.0F
         );
         float var15 = 16.0F;
         float var16 = this.ibo + 430.0F - 12.0F - var15;
         float var17 = this.ibp + (30.0F - var15) * 0.5F + 1.0F;
         float var18 = this.ibt.step(var9 && irr.inside(var3, var4, var16, var17, var15, var15), var5);
         irr.iconButton(var1, vhz.CLOSE, var16, var17, var15, var18, false, 1.0F);
         float var19 = this.ibp + 30.0F + 2.0F;
         this.search.x = this.ibo + 12.0F;
         this.search.y = var19 + 3.0F;
         this.search.w = 170.0F;
         this.search.h = 16.0F;
         this.search.render(var1, var2, var3, var4, var5);
         float var20 = this.search.x + this.search.w + 8.0F;
         String[] var21 = new String[]{
            wap.s(a.c(-2047299948, "껖흊嶙"), a.c(-856559916, "\ueac5錧ᦀ")), wap.s(a.d("ﱱ藶༬酔᪅鰣♡꾑", 212294413, 1885579047), a.b("\uf712軺ѓ驓ᇴ靈ⴛ꒜㪽", 1180889865))
         };
         float var22 = 128.0F;
         float var23 = 16.0F;
         float var24 = var19 + (22.0F - var23) * 0.5F;
         uut.round(var1, var20, var24, var22, var23, iov.r(5.0F), iov.field);
         float var25 = var22 * 0.5F;
         float var26 = this.ibv ? var25 : 0.0F;
         uut.round(var1, var20 + var26 + 1.5F, var24 + 1.5F, var25 - 3.0F, var23 - 3.0F, iov.r(4.0F), iov.accent(60));

         for (int var27 = 0; var27 < 2; var27++) {
            boolean var28 = var27 == 1 == this.ibv;
            float var29 = this.ibs[var27].step(var9 && irr.inside(var3, var4, var20 + var27 * var25, var24, var25, var23), var5);
            irr.VALUE
               .drawCentered(
                  var1,
                  var21[var27],
                  var20 + var27 * var25 + var25 * 0.5F,
                  irr.VALUE.centerTop(var24 + var23 * 0.5F),
                  var28 ? iov.text : ujt.lerp(iov.textMuted, iov.textDim, var29)
               );
         }

         float var32 = (this.ibo + 430.0F - 12.0F - (var20 + var22 + 8.0F) - 6.0F) * 0.5F;
         float var33 = var20 + var22 + 8.0F;
         float var34 = var33 + var32 + 6.0F;
         irr.secondaryButton(
            var1,
            wap.s(a.c(1186083138, "\u3104䢚쉀尵ퟱ"), a.c(770587570, "㾤䙌쳠勨\ud93c忷\ue5de氡")),
            vhz.TRASH,
            var33,
            var24,
            var32,
            var23,
            this.ibs[2].step(var9 && irr.inside(var3, var4, var33, var24, var32, var23), var5),
            0.0F
         );
         irr.secondaryButton(
            var1,
            wap.s(a.d("\udb89ꈏ⣊뚭㵫", 300393715, -1186103507), a.c(1302542582, "㳒䕳쿑凞\uda76")),
            vhz.RESET,
            var34,
            var24,
            var32,
            var23,
            this.ibs[3].step(var9 && irr.inside(var3, var4, var34, var24, var32, var23), var5),
            0.0F
         );
         this.ics(var1, var3, var4, var5, var9);
         float var30 = this.ibp + 318.0F - 8.0F - 5.0F;
         uut.rect(var1, this.ibo + 12.0F, this.ibp + 318.0F - 16.0F - 8.0F, 406.0F, 1.0F, iov.divider);
         if (this.iby != null) {
            irr.LABEL.draw(var1, irr.LABEL.ellipsize(this.iby, 236.5F), this.ibo + 12.0F, irr.LABEL.centerTop(var30), iov.text);
            irr.SMALL.draw(var1, this.ibz, this.ibo + 430.0F - 12.0F - irr.SMALL.width(this.ibz), irr.SMALL.centerTop(var30), iov.textMuted);
         } else {
            String var31 = this.ibx.isEmpty()
               ? wap.s(a.d("ឩ渹\ue4f1窜\uf14a矼춦䐐\uda09傱흸ⴒꏏ", 820329225, -1529598749), a.b("᭛拏\ue863癠ﶱ笍앀䢬훻塟\udb91⇭꼳㚏볝㨤聨", -461103273))
               : wap.s(a.c(-488482956, "圬⺲ꑤ㨟뇀㜺贽ӗ髇့韡涐\ue303竽\uf0b3瘐찍䏋\ud970弣훍겏≹릨㽀딆ವ"), a.b("緲Ѣ躲Ⴡ鼌㦉ꏮ⸋끞㫠봲䝁즜偗\uda0a増\ue6c0椒\uf3a2燫ﱿ虜࢞錿ᔲ鿭∲걣㘃냅㭶", 1206352375))
                  + this.ibx.size()
                  + wap.s(a.c(-1919566204, "뺢은䶈폾報\ude99"), a.c(-278559244, "藝\uf873犡\uecd4有\ue1bf寫툗䱋"));
            irr.SMALL.draw(var1, var31, this.ibo + 12.0F, irr.SMALL.centerTop(var30), iov.textMuted);
         }

         var1.getMatrices().popMatrix();
         uut.popAlpha();
      }
   }

   void ics(DrawContext var1, float var2, float var3, float var4, boolean var5) {
      float var6 = this.ich();
      float var7 = this.ici();
      float var8 = this.icj();
      float var9 = this.ick();
      float var10 = this.ibr.step(Math.max(0.0F, Math.min(this.ibu, this.icr())), var4);
      int var11 = this.icm();
      float var12 = this.icp();
      this.iby = null;
      this.ibz = null;
      int var13 = -1;
      uut.pushScissor(var1, var6 - 2.0F, var7 - 2.0F, var8 + 4.0F, var9 + 4.0F);
      float var14 = this.icn();
      float var15 = this.ico();
      boolean var16 = this.icl();
      int var17 = Math.max(0, (int)(var10 / (var15 + 3.0F)));
      int var18 = (int)((var10 + var9) / (var15 + 3.0F)) + 1;
      float var19 = iov.r(5.0F);

      for (int var20 = var17; var20 <= var18; var20++) {
         for (int var21 = 0; var21 < var11; var21++) {
            int var22 = var20 * var11 + var21;
            if (var22 >= this.ibx.size()) {
               break;
            }

            iay var23 = this.ibx.get(var22);
            float var24 = var6 + var21 * var12;
            float var25 = var7 + var20 * (var15 + 3.0F) - var10;
            boolean var26 = var5 && irr.inside(var2, var3, var24, var25, var14, var15) && irr.inside(var2, var3, var6, var7, var8, var9);
            boolean var27 = this.setting.contains(var23.iaz);
            float var28 = 0.0F;
            if (var26) {
               var13 = var22;
               this.iby = var23.ibb;
               this.ibz = var23.iaz;
               var28 = var16 ? 0.0F : this.icb.get();
            }

            int var29 = var27 ? ujt.lerp(iov.field, iov.accent(), 0.28F) : iov.field;
            uut.round(var1, var24, var25 - var28, var14, var15, var19, var26 ? ujt.lerp(var29, iov.fieldHover, 0.6F) : var29);
            if (var27) {
               uut.outline(var1, var24, var25 - var28, var14, var15, var19, 1.0F, iov.accent(200));
            }

            var1.getMatrices().pushMatrix();
            var1.getMatrices().translate(var24 + (var16 ? 2.0F : 3.0F), var25 + (var15 - 16.0F) * 0.5F - var28);
            var1.drawItem(var23.iba, 0, 0);
            var1.getMatrices().popMatrix();
            if (var16) {
               float var30 = var24 + 21.0F;
               float var31 = var14 - 21.0F - (var27 ? 14.0F : 4.0F);
               irr.LABEL.draw(var1, irr.LABEL.ellipsize(var23.ibb, var31), var30, irr.LABEL.centerTop(var25 + var15 * 0.5F), var27 ? iov.text : iov.textDim);
            }

            if (var27) {
               float var35 = var16 ? var24 + var14 - 7.0F : var24 + 22.0F - 3.5F;
               float var36 = var16 ? var25 + var15 * 0.5F : var25 + 3.5F - var28;
               uut.circle(var1, var35, var36, 3.0F, iov.accent());
               vjf.draw(var1, vhz.CHECK, var35, var36, 4.5F, iov.onAccent());
            }
         }
      }

      uut.popScissor(var1);
      if (var13 != this.ica) {
         this.ica = var13;
         this.icb.set(0.0F);
      }

      this.icb.step(var13 >= 0 ? 1.5F : 0.0F, var4);
      float var32 = this.icr();
      if (var32 > 0.0F) {
         float var33 = Math.max(18.0F, var9 * var9 / this.icq());
         float var34 = var7 + (var9 - var33) * (var10 / var32);
         uut.round(var1, var6 + var8 + 4.0F, var34, 2.5F, var33, 1.25F, ujt.withAlpha(iov.textMuted, 110));
      }
   }

   @Override
   boolean mouseClicked(hlc var1, float var2, float var3, int var4) {
      if (this.ibw) {
         return true;
      }

      if (!this.contains(var2, var3)) {
         this.close();
         return true;
      }

      float var5 = 16.0F;
      if (var4 == 0 && irr.inside(var2, var3, this.ibo + 430.0F - 12.0F - var5, this.ibp + (30.0F - var5) * 0.5F + 1.0F, var5, var5)) {
         this.close();
         return true;
      }

      if (this.search.mouseClicked(var1, var2, var3, var4)) {
         return true;
      }

      var1.focus(null);
      float var6 = this.ibp + 30.0F + 2.0F;
      float var7 = this.search.x + this.search.w + 8.0F;
      float var8 = 128.0F;
      float var9 = var6 + 3.0F;
      if (var4 == 0 && irr.inside(var2, var3, var7, var9, var8, 16.0F)) {
         this.ibv = var2 >= var7 + var8 * 0.5F;
         this.ibu = 0.0F;
         this.icg();
         return true;
      }

      float var10 = (this.ibo + 430.0F - 12.0F - (var7 + var8 + 8.0F) - 6.0F) * 0.5F;
      float var11 = var7 + var8 + 8.0F;
      if (var4 == 0 && irr.inside(var2, var3, var11, var9, var10, 16.0F)) {
         this.setting.clear();
         this.icg();
         var1.toast(wap.s(a.d("빴쟠䴩퍟壜\ude2e摲\ued8a珑拾纷蓇", -2126027166, -1186277290), a.b("癲\u0fdd蔉ᬁ邩ᘜꡕ►뮜ㅒ뛰䳽숢", -1979026850)), vhz.TRASH, false);
         return true;
      }

      if (var4 == 0 && irr.inside(var2, var3, var11 + var10 + 6.0F, var9, var10, 16.0F)) {
         this.setting.reset();
         this.icg();
         var1.toast(
            wap.s(a.c(-492904007, "\ue1e3顱አ賙݅膠㯨뉖ⱝ꛰℮\udb1a喉찹䙩삟竄\uf50c澧\ue9a2怙ᩍ铤༲"), a.b("肟契环\ueda3昊\ue0c3媓흺䵄잋䁟멗㓿굊⌃ꇭᮣ遬ຼ袒ŧ笳\uf5fc湚\ue828拼\udb39", -107510634)),
            vhz.RESET,
            false
         );
         return true;
      }

      if (var4 == 0 && irr.inside(var2, var3, this.ich(), this.ici(), this.icj(), this.ick()) && this.ica >= 0 && this.ica < this.ibx.size()) {
         iay var12 = this.ibx.get(this.ica);
         this.setting.toggle(var12.iaz);
         if (this.ibv && !this.setting.contains(var12.iaz)) {
            this.icg();
         }

         return true;
      } else {
         return true;
      }
   }

   @Override
   void scrolled(double var1) {
      this.ibu = Math.max(0.0F, Math.min(this.icr(), this.ibu - (float)var1 * (this.ico() + 3.0F) * 2.0F));
   }

   @Override
   boolean keyPressed(hlc var1, int var2, int var3) {
      if (var2 != 256) {
         if (var1.focusedField() == this.search) {
            this.search.keyPressed(var1, var2, var3);
            return true;
         }

         boolean var4 = (var3 & 2) != 0;
         if (var4 && var2 == 70) {
            var1.focus(this.search);
         }

         return true;
      } else {
         if (var1.focusedField() == this.search && !this.search.text.isEmpty()) {
            this.search.setText("");
         } else {
            this.close();
         }

         return true;
      }
   }

   static String idPath(String var0) {
      return var0.toLowerCase(Locale.ROOT).startsWith(a.c(-1261067002, "ꕡ\udcd4嘀졺䎫씋罋\uf6bd棰\ue20f")) ? var0.substring(10) : var0;
   }
}
