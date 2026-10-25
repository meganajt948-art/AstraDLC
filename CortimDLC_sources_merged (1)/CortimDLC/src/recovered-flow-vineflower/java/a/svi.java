package a;

import net.minecraft.text.Text;

final class svi {
   final String svj;
   final int svk;
   final boolean svl;
   final Text svm;

   svi(String text, int color, boolean bold, Text vanilla) {
      this.svj = text;
      this.svk = color;
      this.svl = bold;
      this.svm = vanilla;
   }

   public String text() {
      return this.svj;
   }

   public int color() {
      return this.svk;
   }

   public boolean bold() {
      return this.svl;
   }

   public Text vanilla() {
      return this.svm;
   }
}
