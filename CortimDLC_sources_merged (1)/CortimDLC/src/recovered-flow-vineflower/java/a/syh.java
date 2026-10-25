package a;

import java.util.ArrayList;
import java.util.List;

final class syh {
   int events;
   int ticks;
   final List<Double> depth = new ArrayList<>();

   double rate() {
      return this.ticks == 0 ? 0.0 : 100.0 * this.events / this.ticks;
   }
}
