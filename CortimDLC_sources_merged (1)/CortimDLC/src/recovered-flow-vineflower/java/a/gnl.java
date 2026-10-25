package a;

import java.util.ArrayList;
import java.util.List;

final class gnl {
   int ticks;
   int ready;
   int readyHit;
   int heldAimed;
   int heldCrit;
   int heldOther;
   int notAimed;
   int aimedTicks;
   int hits;
   int serverHits;
   int serverCrits;
   int jumps;
   int jumpsHit;
   int jumpsChance;
   int jumpsChanceHit;
   int bursts;
   int knocks;
   int jumpsCrit;
   int lostTicks;
   int farTicks;
   int nearTicks;
   final int[] wait = new int[7];
   final List<Double> turns = new ArrayList<>();
   double radius;
   double spin;
   int orbitTicks;

   gnl() {
   }
}
