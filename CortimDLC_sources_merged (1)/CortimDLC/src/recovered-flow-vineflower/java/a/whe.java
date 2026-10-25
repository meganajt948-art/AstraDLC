package a;

import java.nio.ByteBuffer;

final class whe {
   final ByteBuffer y;
   final ByteBuffer uv;
   final int width;
   final int height;
   long pts;

   whe(int var1, int var2) {
      this.width = var1;
      this.height = var2;
      this.y = ByteBuffer.allocateDirect(var1 * var2);
      this.uv = ByteBuffer.allocateDirect(var1 * var2 / 2);
   }
}
