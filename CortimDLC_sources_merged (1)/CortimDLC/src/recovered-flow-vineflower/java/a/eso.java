package a;

public final class eso {
   final String esp;
   final String esq;

   public eso(String code, String message) {
      this.esp = code;
      this.esq = message;
   }

   public String code() {
      return this.esp;
   }

   public String message() {
      return this.esq;
   }
}
