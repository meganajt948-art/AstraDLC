/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_437
 *  ru.vidtu.ias.IAS
 *  ru.vidtu.ias.account.Account
 *  ru.vidtu.ias.account.MicrosoftAccount
 *  ru.vidtu.ias.account.OfflineAccount
 *  ru.vidtu.ias.auth.LoginData
 *  ru.vidtu.ias.auth.handlers.LoginHandler
 *  ru.vidtu.ias.config.IASStorage
 *  ru.vidtu.ias.screen.AccountScreen
 */
package a;

import a.jyi;
import a.jyq;
import a.jyv;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_310;
import net.minecraft.class_437;
import ru.vidtu.ias.IAS;
import ru.vidtu.ias.account.Account;
import ru.vidtu.ias.account.MicrosoftAccount;
import ru.vidtu.ias.account.OfflineAccount;
import ru.vidtu.ias.auth.LoginData;
import ru.vidtu.ias.auth.handlers.LoginHandler;
import ru.vidtu.ias.config.IASStorage;
import ru.vidtu.ias.screen.AccountScreen;

final class IasAccounts {
    private static /* synthetic */ long jyx;
    private static /* synthetic */ long jyy;

    private IasAccounts() {
    }

    static boolean disabled() {
        return IAS.disabled();
    }

    static List<jyi> accounts() {
        ArrayList<jyi> arrayList = new ArrayList<jyi>();
        for (Account account : IASStorage.ACCOUNTS) {
            arrayList.add(new jyi(account.name(), account.uuid(), account.skin(), account instanceof MicrosoftAccount, account));
        }
        return arrayList;
    }

    static boolean addOffline(String string) {
        for (Account account : IASStorage.ACCOUNTS) {
            if (!(account instanceof OfflineAccount) || !account.name().equalsIgnoreCase(string)) continue;
            return false;
        }
        IASStorage.ACCOUNTS.add(new OfflineAccount(string, OfflineAccount.uuid((String)string)));
        IasAccounts.jyz();
        return true;
    }

    static void remove(jyi jyi2) {
        IASStorage.ACCOUNTS.remove(jyi2.handle());
        IasAccounts.jyz();
    }

    private static void jyz() {
        try {
            IAS.disclaimersStorage();
            IAS.saveStorage();
        }
        catch (Throwable throwable) {
            System.out.println("IAS can't save the accounts: " + throwable);
        }
    }

    static void openOriginal(class_437 class_4372) {
        class_310.method_1551().method_1507((class_437)new AccountScreen(class_4372));
    }

    static void login(jyi jyi2, jyv jyv2) {
        Account account = (Account)jyi2.handle();
        jyq jyq2 = new jyq(jyv2);
        if (!account.canLogin()) {
            String string = account.name();
            jyq2.success(new LoginData(string, OfflineAccount.uuid((String)string), "ias:offline", false), false);
            return;
        }
        IAS.executor().execute(() -> {
            try {
                account.login((LoginHandler)jyq2, () -> {});
            }
            catch (Throwable throwable) {
                jyq2.error(throwable);
            }
        });
    }

    private static /* synthetic */ int aqs(int n, int n2) {
        return n + n2 ^ 0xC1BD524E;
    }
}

