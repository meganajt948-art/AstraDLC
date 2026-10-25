package a;

public final class dxe {
   final String dxf;
   final float dxg;
   final float dxh;
   final int dxi;

   public dxe(String text, float x, float y, int color) {
      this.dxf = text;
      this.dxg = x;
      this.dxh = y;
      this.dxi = color;
   }

   public String text() {
      return this.dxf;
   }

   public float x() {
      return this.dxg;
   }

   public float y() {
      return this.dxh;
   }

   public int color() {
      return this.dxi;
   }
}
