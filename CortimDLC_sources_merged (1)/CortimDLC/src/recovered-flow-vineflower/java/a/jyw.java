package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import ru.vidtu.ias.IAS;
import ru.vidtu.ias.account.Account;
import ru.vidtu.ias.account.MicrosoftAccount;
import ru.vidtu.ias.account.OfflineAccount;
import ru.vidtu.ias.auth.LoginData;
import ru.vidtu.ias.config.IASStorage;
import java.lang.reflect.Constructor;

final class jyw {
   jyw() {
   }

   static boolean disabled() {
      return IAS.disabled();
   }

   static List<jyi> accounts() {
      ArrayList var0 = new ArrayList();

      for (Account var2 : IASStorage.ACCOUNTS) {
         var0.add(new jyi(var2.name(), var2.uuid(), var2.skin(), var2 instanceof MicrosoftAccount, var2));
      }

      return var0;
   }

   static boolean addOffline(String var0) {
      for (Account var2 : IASStorage.ACCOUNTS) {
         if (var2 instanceof OfflineAccount && var2.name().equalsIgnoreCase(var0)) {
            return false;
         }
      }

      IASStorage.ACCOUNTS.add(new OfflineAccount(var0, OfflineAccount.uuid(var0)));
      jyz();
      return true;
   }

   static void remove(jyi var0) {
      IASStorage.ACCOUNTS.remove(var0.handle());
      jyz();
   }

   static void jyz() {
      try {
         IAS.disclaimersStorage();
         IAS.saveStorage();
      } catch (Throwable var1) {
         System.out.println(a.b("ꛧ\udf5e喟쮝䀉욺糦\uf55e歒\ue1b7昷鱔ኔ謶Ġ螅㷖눊⣼껬✙嵈폷䠼치䒓ﴧ猿\ue9d2", -526342477) + var1);
      }
   }

   static void openOriginal(Screen var0) {
      try {
         Class<?> screenClass = Class.forName("ru.vidtu.ias.screen.AccountScreen");
         Constructor<?> constructor = java.util.Arrays.stream(screenClass.getConstructors())
            .filter(candidate -> candidate.getParameterCount() == 1 && candidate.getParameterTypes()[0].isInstance(var0))
            .findFirst()
            .orElseThrow(() -> new NoSuchMethodException("Compatible IAS AccountScreen constructor not found"));
         Object screen = constructor.newInstance(var0);
         if (screen instanceof Screen compatibleScreen) {
            MinecraftClient.getInstance().setScreen(compatibleScreen);
         } else {
            throw new IllegalStateException("IAS returned a screen with an incompatible runtime type");
         }
      } catch (ReflectiveOperationException error) {
         throw new IllegalStateException("Failed to open IAS account screen", error);
      }
   }

   static void login(jyi var0, jyv var1) {
      Account var2 = (Account)var0.handle();
      jyq var3 = new jyq(var1);
      if (!var2.canLogin()) {
         String var4 = var2.name();
         var3.success(new LoginData(var4, OfflineAccount.uuid(var4), a.b("\uf403趺ݻ饃\u12c1鑹⸪ꟑ㦋댽㓥", 2010707041), false), false);
      } else {
         IAS.executor().execute(() -> {
            try {
               var2.login(var3, () -> {});
            } catch (Throwable var3x) {
               var3.error(var3x);
            }
         });
      }
   }
}
