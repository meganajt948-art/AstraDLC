package a;

public final class erc {
   final String erd;
   final String ere;

   public erc(String code, String message) {
      this.erd = code;
      this.ere = message;
   }

   public String code() {
      return this.erd;
   }

   public String message() {
      return this.ere;
   }
}
