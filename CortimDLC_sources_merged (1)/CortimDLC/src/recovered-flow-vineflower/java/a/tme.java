package a;

public final class tme {
   public int flags;
   public float yaw;
   public float pitch;
   public float eyeX;
   public float eyeY;
   public float eyeZ;
   public float cooldown;
   public int presses;
   public int hitId;
   public float hitU;
   public float hitV;
   public int[] ids = new int[0];
   public float[] boxes = new float[0];

   public int count() {
      return this.ids.length;
   }

   public int indexOf(int var1) {
      for (int var2 = 0; var2 < this.ids.length; var2++) {
         if (this.ids[var2] == var1) {
            return var2;
         }
      }

      return -1;
   }
}
