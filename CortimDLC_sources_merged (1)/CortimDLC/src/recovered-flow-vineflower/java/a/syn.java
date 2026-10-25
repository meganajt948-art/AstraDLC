package a;

import java.util.ArrayList;
import java.util.List;

public final class syn {
   final List<double[]> dx = new ArrayList<>();
   final List<double[]> dy = new ArrayList<>();
   final List<double[]> ex = new ArrayList<>();
   final List<double[]> ey = new ArrayList<>();
   List<tmn> episodes = List.of();

   public int ticks() {
      int var1 = 0;

      for (double[] var3 : this.dx) {
         var1 += var3.length;
      }

      return var1;
   }
}
