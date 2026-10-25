package a;

record jbj(String label, vhz icon, Runnable action, jcs element, float x, float w) {
   private final String jbk;
   private final vhz jbl;
   private final Runnable jbm;
   private final jcs jbn;
   private final float jbo;
   private final float jbp;

   private jbj(String label, vhz icon, Runnable action, jcs element, float x, float w) {
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
