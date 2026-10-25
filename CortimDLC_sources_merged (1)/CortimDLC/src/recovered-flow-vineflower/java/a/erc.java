package a;

public record erc(String code, String message) {
   private final String erd;
   private final String ere;

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
