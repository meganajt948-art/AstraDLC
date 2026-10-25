package a;

final class jbj {
   final String jbk;
   final vhz jbl;
   final Runnable jbm;
   final jcs jbn;
   final float jbo;
   final float jbp;

   jbj(String label, vhz icon, Runnable action, jcs element, float x, float w) {
      this.jbk = label;
      this.jbl = icon;
      this.jbm = action;
      this.jbn = element;
      this.jbo = x;
      this.jbp = w;
   }

   public String label() {
      return this.jbk;
   }

   public vhz icon() {
      return this.jbl;
   }

   public Runnable action() {
      return this.jbm;
   }

   public jcs element() {
      return this.jbn;
   }

   public float x() {
      return this.jbo;
   }

   public float w() {
      return this.jbp;
   }
}
