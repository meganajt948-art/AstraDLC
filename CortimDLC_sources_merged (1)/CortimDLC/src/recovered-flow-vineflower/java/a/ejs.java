package a;

record ejs(String name, String address, String password, boolean autoReconnect) {
   private final String ejt;
   private final String eju;
   private final String ejv;
   private final boolean ejw;

   ejs(String name, String address, String password, boolean autoReconnect) {
      this.ejt = name;
      this.eju = address;
      this.ejv = password;
      this.ejw = autoReconnect;
   }

   public String name() {
      return this.ejt;
   }

   public String address() {
      return this.eju;
   }

   public String password() {
      return this.ejv;
   }

   public boolean autoReconnect() {
      return this.ejw;
   }
}
