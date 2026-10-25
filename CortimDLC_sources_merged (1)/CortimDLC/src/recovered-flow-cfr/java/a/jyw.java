/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.screen.Screen
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
import ru.vidtu.ias.auth.handlers.LoginHandler;
import ru.vidtu.ias.config.IASStorage;
import ru.vidtu.ias.screen.AccountScreen;

final class jyw {
    private static /* synthetic */ long jyx;
    private static /* synthetic */ long jyy;

    private jyw() {
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
        jyw.jyz();
        return true;
    }

    static void remove(jyi jyi2) {
        IASStorage.ACCOUNTS.remove(jyi2.handle());
        jyw.jyz();
    }

    private static void jyz() {
        try {
            IAS.disclaimersStorage();
            IAS.saveStorage();
        }
        catch (Throwable throwable) {
            System.out.println(a.b("\ua6e7\udf5e\u559f\ucb9d\u4009\uc6ba\u7ce6\uf55e\u6b52\ue1b7\u6637\u9c54\u1294\u8b36\u0120\u8785\u3dd6\ub20a\u28fc\uaeec\u2719\u5d48\ud3f7\u483c\uce58\u4493\ufd27\u733f\ue9d2", -526342477) + throwable);
        }
    }

    static void openOriginal(Screen screen) {
        MinecraftClient.method_1551().method_1507((Screen)new AccountScreen(screen));
    }

    static void login(jyi jyi2, jyv jyv2) {
        Account account = (Account)jyi2.handle();
        jyq jyq2 = new jyq(jyv2);
        if (!account.canLogin()) {
            String string = account.name();
            jyq2.success(new LoginData(string, OfflineAccount.uuid((String)string), a.b("\uf403\u8dba\u077b\u9943\u12c1\u9479\u2e2a\ua7d1\u398b\ub33d\u34e5", 2010707041), false), false);
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

