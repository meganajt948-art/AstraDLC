package a;

final class jlu {
   String label = "";
   String value = "";
   String unit = "";
   int color;
   int dot;
   float wide;
   long wideAt;

   private jlu() {
   }

   float natural() {
      float var1 = izx.VALUE.width(this.value);
      if (!this.label.isEmpty()) {
         var1 += izx.SMALL.width(this.label) + 3.0F;
      }

      if (!this.unit.isEmpty()) {
         var1 += 2.0F + izx.SMALL.width(this.unit);
      }

      if (this.dot != 0) {
         var1 += 6.2F;
      }

      return var1;
   }
}
