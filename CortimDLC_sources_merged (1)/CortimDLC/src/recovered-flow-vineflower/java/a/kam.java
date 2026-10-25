package a;

import org.jspecify.annotations.Nullable;

public final class kam {
   public float time;
   public float motion = 1.0F;
   public float zoom = 1.04F;
   public float panX;
   public float panY;
   public float blur;
   public float dim;
   public int tint = 16777215;
   public float tintAmount;
   public float grain = 1.5F;
   public float @Nullable [] fall;
   public float @Nullable [] shape;
   public float @Nullable [] pool;
   public float logoX = 0.5F;
   public float logoY = 0.5F;
   public float logoSize;

   public void logo(float var1, float var2, float var3) {
      this.logoX = var1;
      this.logoY = var2;
      this.logoSize = var3;
   }

   public void logoF(float var1, float var2, float var3, float var4) {
      this.logo(var1 - 0.016F * var3 / var4, var2 - -0.011F * var3, var3);
   }
}
