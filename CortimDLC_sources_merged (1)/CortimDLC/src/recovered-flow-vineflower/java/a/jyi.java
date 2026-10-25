package a;

import java.util.UUID;

record jyi(String name, UUID uuid, UUID skin, boolean microsoft, Object handle) {
   private final String jyj;
   private final UUID jyk;
   private final UUID jyl;
   private final boolean jym;
   private final Object jyn;

   jyi(String name, UUID uuid, UUID skin, boolean microsoft, Object handle) {
      this.jyj = name;
      this.jyk = uuid;
      this.jyl = skin;
      this.jym = microsoft;
      this.jyn = handle;
   }

   public String name() {
      return this.jyj;
   }

   public UUID uuid() {
      return this.jyk;
   }

   public UUID skin() {
      return this.jyl;
   }

   public boolean microsoft() {
      return this.jym;
   }

   public Object handle() {
      return this.jyn;
   }
}
