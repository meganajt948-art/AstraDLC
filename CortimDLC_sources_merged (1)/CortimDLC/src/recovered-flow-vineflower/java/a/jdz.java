package a;

final class jdz {
   final String jea;
   final int jeb;
   final boolean jec;

   jdz(String name, int key, boolean on) {
      this.jea = name;
      this.jeb = key;
      this.jec = on;
   }

   public String name() {
      return this.jea;
   }

   public int key() {
      return this.jeb;
   }

   public boolean on() {
      return this.jec;
   }
}
