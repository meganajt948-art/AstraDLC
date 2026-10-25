package a;

enum nmc {
   IDLE(0L),
   TAKE(6000L),
   SEARCH(5000L),
   SCAN(6000L),
   SEND(6000L),
   CONFIRM(7000L),
   RESTORE(4000L),
   FULL_WAIT(0L),
   AH_OPEN(8000L),
   AH_STORAGE(6000L),
   AH_RELIST(6000L),
   CHEST_OPEN(6000L),
   CHEST_LOOT(40000L);

   private final long nmd;

   private nmc(long var3) {
      this.nmd = var3;
   }
}
