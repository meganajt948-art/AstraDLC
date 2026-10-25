package a;

import flow.dev.a;
import net.minecraft.client.gui.DrawContext;

final class inu extends imn {
   private static final float inv = 22.0F;
   private static final float inw = 8.0F;
   private static final float inx = 16.0F;
   private final vmu iny;
   private final iah inz;
   private String ioa = "";
   private String iob = "";
   private float ioc;

   inu(vmu var1) {
      super(var1);
      this.iny = var1;
      this.inz = new iah("", null, var1.maxLength(), iah.ANY);
      this.inz.setText(var1.get());
      this.inz.onChange = var1::set;
   }

   @Override
   float height() {
      return this.iof() == null ? 22.0F : 30.0F;
   }

   private String iof() {
      String var1 = this.iny.example();
      if (var1 != null) {
         return var1.isBlank() ? null : var1;
      } else {
         String var2 = wap.s(a.c(225904688, "ࠖ熧כּ敗\ueed2档"), a.c(-1963959744, "婧⏖괝㍯뢻㨒聁"));
         String var4 = this.iny.getName();

         String var3 = switch (var4) {
            case a.c(-884420857, "콃뛞㰏ꉾ⦥꼛ᕂ") -> a.c(931407257, "▿展횂䣢쌷䖆ￓ瘷\ue86c");
            case a.d("ꁛ\ud9d8匜쵾䛬쀸穀\uf3bb", 224578958, 1097624974) -> a.c(215445015, "湳៍鵅̱裡");
            case a.c(-741730780, "ᙠ濲\ue521筋\uf0c8瘜챤䖟") -> a.c(56430322, "ຖ眨ﶠ揔\ue80b") + var2 + a.b("菪穀烜\ueea8敷\ue3d2妍퀽乭쒇䍑뤩", -1376025721);
            case a.d("\uda16ꎕ⥑뜳㲡멑\r觳ឿ鴟᫇\ue0a7", 1548987762, 356677435) -> a.d("ﮒ般ࢣ雓ᴏ", -1346770965, -1266344931);
            case a.d("萈ﶚ睉\ue923抠\ue450希ퟲ䦾쌞䓆뺦", 181055312, 354757400) -> a.d("䝾㻀둏⨿ꇢ", 2099399850, 1236405168)
               + var2
               + a.d("筪˔衛ᘫ鷶᭒ꄍ⢽뛭㰀믕䆠", 743706698, -203199667);
            case a.b("榉ဟ髎ҷ輥\u09da뎆㩻ꐬ", 23554504) -> a.c(981471633, "ᇠ桇\ue287糠\uf736熌") + var2 + a.b("\uf698轮ֺ鯉ဖ離⳦ꔁ㭍뇪㘸챂", -22808901);
            case a.b("ઠ猧裏枔\uec13櫬킰奍윚", -1464661250) -> this.iny.defaultValue() + var2 + a.d("ꥏ킦婣쐁俔줵", 571990985, -1976808785) + this.iny.defaultValue();
            case a.d("⪆匚\ud9ce䞵졲䪢\uf08a祺\ue72e涛\uea4c", 1048690443, -315321962) -> a.b("튛ꬮ⇽", 1475728045) + var2 + a.c(859180212, "\u0cd0畮￦憓\uea44");
            case a.b("䵳㓯븻⁀꾇ⴭ霆Ỷ胛", -473937558) -> a.d("蜣ﺖ瑆", -675210342, 834051215) + var2 + a.d("츿랁㴉ꍼ⢨", -1705401737, -2048562132);
            case a.d("\ue9eb遾\u1aaf蓒༈覰㏧븆\u243c껸⤪퍚", 2021124161, 386139580) -> a.d("㨁䎭쥩", -872946942, -1034036888);
            default -> null;
         };
         if (var3 != null) {
            return var3;
         } else {
            var4 = this.iny.defaultValue();
            return var4 != null && !var4.isBlank() ? var4 : null;
         }
      }
   }

   @Override
   void render(DrawContext var1, hlc var2, float var3, float var4, float var5) {
      if (var2.focusedField() != this.inz && !this.inz.text.equals(this.iny.get())) {
         this.inz.setText(this.iny.get());
      }

      float var6 = this.hover.step(this.hovered(var3, var4) && var2.canHover(), var5);
      float var7 = this.y + 11.0F;
      String var8 = wap.t(this.setting.getName());
      irr.LABEL.draw(var1, var8, this.x, irr.LABEL.centerTop(var7), ujt.lerp(iov.textDim, iov.text, var6));
      float var9 = Math.min(this.w * 0.58F, Math.max(90.0F, this.w - irr.LABEL.width(var8) - 12.0F));
      this.inz.x = this.x + this.w - var9;
      this.inz.y = var7 - 8.0F;
      this.inz.w = var9;
      this.inz.h = 16.0F;
      this.inz.render(var1, var2, var3, var4, var5);
      String var10 = this.iof();
      if (var10 != null) {
         String var11 = wap.s(a.d("빕쟙䴓퍮墤\ude09摓\uedfd玸", 663534903, 691274542), a.d("邎\ue960揋ﶾ癠\uf0a4亍읦", 619989351, -754721282)) + var10;
         if (!var11.equals(this.ioa) || var9 != this.ioc) {
            this.ioa = var11;
            this.ioc = var9;
            this.iob = irr.SMALL.ellipsize(var11, var9 - 6.0F);
         }

         irr.SMALL.draw(var1, this.iob, this.inz.x + 6.0F, irr.SMALL.centerTop(this.y + 22.0F + 4.0F - 1.5F), iov.textMuted);
      }
   }

   @Override
   boolean mouseClicked(hlc var1, float var2, float var3, int var4) {
      return this.inz.mouseClicked(var1, var2, var3, var4);
   }
}
