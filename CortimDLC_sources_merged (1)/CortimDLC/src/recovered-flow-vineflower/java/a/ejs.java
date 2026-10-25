package a;

final class ejs {
   final String ejt;
   final String eju;
   final String ejv;
   final boolean ejw;

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
