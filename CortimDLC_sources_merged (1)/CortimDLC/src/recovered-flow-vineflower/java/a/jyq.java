package a;

import flow.dev.a;
import java.util.concurrent.CompletableFuture;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import ru.vidtu.ias.IASMinecraft;
import ru.vidtu.ias.auth.LoginData;
import ru.vidtu.ias.auth.handlers.LoginHandler;
import ru.vidtu.ias.utils.exceptions.FriendlyException;

final class jyq implements LoginHandler {
   private final jyv jyr;
   private final MinecraftClient jys = MinecraftClient.method_1551();

   jyq(jyv var1) {
      this.jyr = var1;
   }

   public boolean cancelled() {
      return false;
   }

   public void stage(String var1, Object... var2) {
      String var3 = Text.method_43469(var1, var2).getString();
      this.jys.execute(() -> this.jyr.stage(var3));
   }

   public CompletableFuture<String> password() {
      return CompletableFuture.failedFuture(new IllegalStateException(a.c(319179556, "䭜㋼렽♌궟⬶酸ᢟ")));
   }

   public void success(LoginData var1, boolean var2) {
      if (var2) {
         jyw.jyz();
      }

      this.jys.execute(() -> this.jyr.stage(Text.method_43471(a.c(1226454407, "㗼䱅욄墨팽喏\uefd4昫\uf873犂\uf50cཫ膫\u181e鉒ᒩ껠℧")).getString()));
      IASMinecraft.account(this.jys, var1).thenRunAsync(() -> this.jyr.done(var1.name()), this.jys).exceptionally(var1x -> {
         this.error(var1x);
         return null;
      });
   }

   public void error(Throwable var1) {
      String var2;
      if ((!(var1 instanceof IllegalStateException) || !a.d("茦惘灇\uee36日\ue34c夂탥", -1180101964, -2141416982).equals(var1.getMessage()))
         && (!(var1.getCause() instanceof IllegalStateException) || !a.d("䩬㏌뤍❼겯⨆遈\u19af", -769308786, -1914630758).equals(var1.getCause().getMessage()))) {
         FriendlyException var3 = FriendlyException.friendlyInChain(var1);
         var2 = var3 != null ? Text.method_43471(var3.key()).getString() : String.valueOf(var1.getMessage() != null ? var1.getMessage() : var1);
      } else {
         var2 = wap.s(
            a.d("睻\u0ef6萤ᩏ釋\u173b굪⒛뫈っ랫䷀썃媺탠嘃\uec1f掏諒罼\uf69a賙ɪ馿Ῐ锔ⲱꊾ㡓빑㗸쬧䅡\ud8de廄푲毫\ue1ce朁ﺪ瓨ਃ聂\u07fc鵣፻ꪠ ", -1780845877, 1007224276),
            a.b("퍳껁 빹㖮댕व肺ẚ鑙រ\ue9fe杝ﻯ璲\uf62f䡿잡嵢\udb4d势⢙ꉜ㦗믺ㄧ袓ۏ鰴᨟釛欟\ue537粴朗灖쾃䇥읟廦풫", 1105975161)
         );
      }

      System.out.println(a.b("䪖㌯맮⟬걷⫅邞ᥡ蜹ෆ詓瀥ﻺ李\ued14毤퇵帾", -1525331251) + var1);
      this.jys.execute(() -> this.jyr.failed(var2));
   }
}
