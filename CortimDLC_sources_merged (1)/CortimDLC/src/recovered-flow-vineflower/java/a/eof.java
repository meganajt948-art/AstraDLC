package a;

final class eof {
   final float[] eog;
   final float[] eoh;
   final int eoi;
   final int eoj;
   final int eok;
   final int eol;
   final int eom;
   final int eon;
   final int eoo;
   final int eop;
   final int eoq;
   final int eor;

   eof(float[] w, float[] b, int co, int ci, int kh, int kw, int pt, int pl, int sh, int sw, int ho, int wo) {
      this.eog = w;
      this.eoh = b;
      this.eoi = co;
      this.eoj = ci;
      this.eok = kh;
      this.eol = kw;
      this.eom = pt;
      this.eon = pl;
      this.eoo = sh;
      this.eop = sw;
      this.eoq = ho;
      this.eor = wo;
   }

   public float[] w() {
      return this.eog;
   }

   public float[] b() {
      return this.eoh;
   }

   public int co() {
      return this.eoi;
   }

   public int ci() {
      return this.eoj;
   }

   public int kh() {
      return this.eok;
   }

   public int kw() {
      return this.eol;
   }

   public int pt() {
      return this.eom;
   }

   public int pl() {
      return this.eon;
   }

   public int sh() {
      return this.eoo;
   }

   public int sw() {
      return this.eop;
   }

   public int ho() {
      return this.eoq;
   }

   public int wo() {
      return this.eor;
   }
}
