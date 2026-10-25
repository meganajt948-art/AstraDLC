/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.util.ScreenshotRecorder
 */
package a;

import a.hlc;
import a.iov;
import flow.dev.a;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ScreenshotRecorder;

final class heb {
    private static final String[] hec = new String[]{a.b("\ufb64\u82ef\u0827\u9651\u1d91\u9b22\u2174\ua89e\u36c4", -939066578), a.b("\uede2\u9466\u1ea6\u80c6\u0b09\u8db9\u37f7\ube17", 1918037421), a.b("\ud172\ua8f2\u223a\ubc4f\u3786\ub12b\u0b79", -2077634250), a.b("\u0d5e\u74c7\ufe1c\u607a\uebbe\u6d02\ud759", 745147676), a.c(-1839367964, "\u78ae\u0133\u8be6\u1593\u9e4b"), a.d("\u61c3\u1846\u9288\u0ce5\u8735", -1608849160, -655455880), a.c(-480886768, "\u4042\u39cc\ub31e\u2d72\ua6b4")};
    private static final String[] hed = new String[]{a.b("\u8922\uf09b\u7a4c", 2198801), a.d("\ub1da\uc867\u42b0", 880101766, -907871205), a.c(210480402, "\ua925\ud0e6\u5a4d\uc437\u4fe2\uc951"), a.b("\u14b7\u6d0f\ue7d0\u79d9", 794955919), a.d("\ud60d\uafbe\u251d\ubb10", -207522360, 1905108977), a.c(-2088760150, "\u089c\u7159\ufbf4"), a.c(-2070144800, "\u1886\u6121\uebf1"), a.c(1583004346, "\ube89\uc73d\u4d9f\ud397"), a.c(-411916651, "\ua2a7\udb13\u51b1\ucfb9\u446c"), a.b("\u5259\u2be2\ua124", -1483517380), a.c(2088467662, "\u7cae"), a.b("\ua18a\ud839", 1642177970), a.d("\u8a97\uf352\u7986\ue780", -701569400, 604006493), a.b("\u4487\u3d41\ub79b\u29e6", 268714177), a.d("\u6fa3\u161d\u9ccd\u02b0\u896d\u0fd2\ub58b", -1132606835, 1292476695), a.c(-628079578, "\u4457\u3dfd\ub735\u2955\ua28a"), a.b("\ua218\udbd5\u517a\ucf7c\u44a2", -1028282785), a.c(292867745, "\uca98\ub32a\u3980\ua7fa"), a.b("\ud816\ua1a4\u2b75\ub51f\u3ecf\ub864", 1203099747), a.b("\u1d96\u6459\ueef5\u70fc\ufb2e\u7de0", 1599019473), a.d("\u8bfd\uf251\u7893", -520010442, 539283104), a.d("\uea25\u9392\u1936", -100435229, -101346176), a.c(-938264574, "\u3c30\u45f5\ucf25\u5120\uda8c\u5c3e"), a.b("\ucdbf\ub471\u3ea9\ua0a5\u2b7a\uadcf", -569063034), a.d("\ube34\uc797\u4d40\ud324\u58ef\ude53\u6417", 904556202, -1059794706), a.d("\uef9d\u9650\u1c8b\u82fc", -1417314016, -146707720), a.b("\ufdc9\u847a\u0ed7\u90af\u1b0f\u9dc7", -913966706), a.c(-1767390145, "\uc459\ubde3\u373d\ua95a\u228a"), a.b("\u29dd\u5062\udaa8\u44de", 203958715), a.d("\ufa70\u83c7\u091d\u9765\u1ca4\u9a12\u205c\ua9a5\u37f7", -765110387, -1591038569), a.c(-1119767893, "\ub6ec\ucf5e\u45fa\udb84\u5052\ud6e6"), a.b("\u54d7\u2d6d\ua7b3\u39d0\ub207", 1248744629), a.d("\ufdf3\u8440\u0ee3\u90ee\u1f27\u9d87\u27a6\uae2f\u307b\ubac8\u3d19", 2091562247, 2117881039), a.d("\u0a52\u7391\uf93a\u6740\uec95\u6a26\ud465\u5984\uc7d9\u4d18\ucab7", -1386540558, -174448742), a.b("\u933e\ueaf6\u602f\ufe21\u758a\uf349", 1775277834), a.b("B\u79f7\uf35c\u6d2f\ue6f2\u604f", -499448832), a.d("\u7829\u018c\u8b48\u1539\u9eab\u1859\ua208\u2bf5", -2101182347, 1492121650), a.b("\u913d\ue899\u624a\ufc39", -1891135165), a.b("\u37ef\u4e2a\uc486", 1262564315), a.d("\ud610\uafa0\u2570\ubb03", 185538655, 908511857), a.c(-1244882043, "\u9fb0\ue608\u6cde\uf2a6"), a.d("\u400c\u39b5\ub361\u2d6e\ua6c2\u2072", -66853711, 462266608)};
    private static String hee;
    private static /* synthetic */ String hef;
    private static /* synthetic */ int heg;

    private heb() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) throws Exception {
        int n2;
        if (n == 1) {
            heb.hek(minecraftClient, a.d("\uca6e\ub3c2\u3915\ua76c\u2cfe\uaa1c\u1059\u99b9\u07b2\u8d15\u0ac0\uf0b1\u7e66", -921631153, 279563352));
            hee = iov.PRESET.get();
            heb.hej(minecraftClient, a.d("\u7996\u001b\u8ac5\u14bc\u9f63", -501449164, 1740769267));
        }
        int n3 = 24;
        int n4 = 30;
        for (n2 = 0; n2 < hec.length; ++n2) {
            if (n == n4 + n2 * n3) {
                iov.PRESET.set(hec[n2]);
            }
            if (n != n4 + n2 * n3 + n3 - 2) continue;
            heb.hel(minecraftClient, a.c(-892032214, "\uab59\ud2f4\u582a\uc653\u4d8c\ucb2b\u7126") + hec[n2].toLowerCase(Locale.ROOT).replace(' ', '-'));
        }
        n2 = n4 + hec.length * n3;
        if (n == n2) {
            iov.PRESET.set(a.b("\u034a\u7aca\uf002\u6e77\ue5be\u6313\ud941", 101450510));
            heb.hej(minecraftClient, a.b("\u7104\u0899\u8248\u1c36\u97e2\u1146", -1452969663));
        }
        if (n == n2 + 24) {
            heb.hel(minecraftClient, a.d("\uca30\ub39d\u3943\ua73a\u2ce5\uaa42\u104f\u99f0\u07be\u8d14\u0ac3\uf0ac\u7e67\ue7d7\u6dc7\ueb78\u513b\udee8\u4454\uc206\u4be4", -2034779261, 1176990162));
            minecraftClient.setScreen(null);
        }
        if (n == n2 + 50) {
            heb.hel(minecraftClient, a.c(-1045055429, "\ub85d\uc1f0\u4b2e\ud557\u5e88\ud82f\u6222\ueb9d\u75d3\uff79\u78ae\u82c1\u0c0a\u95ba\u1faa\u991e\u234c\uac8c"));
            iov.PRESET.set(a.b("\u3baa\u4233\uc8e8\u568e\udd4a\u5bf6\ue1ad", -1303233560));
        }
        if (n == n2 + 76) {
            heb.hel(minecraftClient, a.c(2000554611, "\u0a15\u73b8\uf966\u671f\uecc0\u6a67\ud06a\u59d3\uc784\u4d3d\ucaf9\u309b\ube41\u27f8\uade2\u2b56\u9104\u1ec4"));
            iov.PRESET.set(a.c(1483371279, "\u734c\u0ac9\u8007\u1e6a\u95ba"));
        }
        if (n == n2 + 102) {
            heb.hel(minecraftClient, a.d("\u22fd\u5b50\ud18e\u4ff7\uc428\u428f\uf882\u7138\uef73\u65df\ue210\u1866\u96e8\u0f1c\u8552\u03b2", -2016978591, 282688504));
            heb.hej(minecraftClient, a.b("\u111d\u6880\ue251\u7c2f\uf7fb\u715f", 1537872216));
        }
        if (n == n2 + 110) {
            iov.PRESET.set(a.c(1013557707, "\ua98f\ud00f\u5ac7\uc4b2\u4f7b\uc9d6\u7384"));
            heb.heh(minecraftClient);
        }
        if (n == n2 + 134) {
            heb.hel(minecraftClient, a.d("\u7408\u0da5\u877b\u1902\u92dd\u147a\uae77\u27d8\ub991\u3324\ub4e4\u4e84\uc058\u59ac\ud3ba\u5546\uef05\u60da\ufa66\u7c2b", -2012478648, -257198304));
            heb.hei(minecraftClient);
        }
        if (n == n2 + 150) {
            heb.hel(minecraftClient, a.c(-1063172167, "\u47d8\u3e75\ub4ab\u2ad2\ua10d\u27aa\u9da7\u1408\u8a41\u00f4\u8734\u7d54\uf388\u6a7c\ue061\u669f\udcd9\u530c\uc9ac\u4fea\uc61c"));
            iov.PRESET.set(hee);
            minecraftClient.setScreen(null);
        }
        return n >= n2 + 154;
    }

    private static void heh(MinecraftClient minecraftClient) throws Exception {
        Object object = minecraftClient.currentScreen;
        if (!(object instanceof hlc)) {
            System.out.println(a.b("\ub44b\ucdec\u473b\ud959\u529f\ud425\u6e3e\ue79b\u79d5\uf372\u74a6\u8e99T\u99ab\u13f9\u9547\u2f45\ua09c\u3a24\ubc6e", -1087523796));
            return;
        }
        hlc hlc2 = (hlc)((Object)object);
        object = hlc.class.getDeclaredMethod(a.b("\ua2c5\udb62\u51a0\ucff6\u4417\uc2a2\u78e2\uf102\u6f56", 264282815), String.class);
        ((Method)object).setAccessible(true);
        Field field = hlc.class.getDeclaredField(a.c(-1496376009, "\u1d46\u64e8\uee21\u704a\ufb96\u7d29\uc773"));
        field.setAccessible(true);
        for (String string : hed) {
            ((Method)object).invoke((Object)hlc2, string);
            ArrayList<String> arrayList = new ArrayList<String>();
            for (Object e : (List)field.get((Object)hlc2)) {
                Field field2 = e.getClass().getDeclaredField(a.d("\u902b\ue987\u6349\ufd20\u76fe", 1923380511, 1096607045));
                field2.setAccessible(true);
                Method method = e.getClass().getDeclaredMethod(a.c(-1779915702, "\ua428\udd83\u5760\uc93d\u42e9\uc458\u7e06\uf7e6\u69ba\ue31d\u64cf"), new Class[0]);
                method.setAccessible(true);
                Field field3 = e.getClass().getDeclaredField(a.d("\ueb1f\u92b3\u1878\u860d", -157676220, -1388714451));
                field3.setAccessible(true);
                boolean bl = (Boolean)method.invoke(e, new Object[0]) == false && !((List)field3.get(e)).isEmpty();
                arrayList.add(field2.get(e) + (bl ? a.c(-1908481402, "\ue2a1\u9b18\u118c\u8fe2\u0420\u829a\u388e") : ""));
            }
            System.out.println(a.d("\u613e\u1899\u924e\u0c2c\u87ea\u0150\ubb4b\u32bd", 2056485920, 1008737637) + string + a.b("\u6b90\u1226\u98f8\u069a\u8d53", -516199502) + arrayList.size() + a.c(2002630231, "\ub66f\ucfc4") + String.join((CharSequence)a.c(-396098735, "\u037f\u7ac2"), arrayList));
        }
        ((Method)object).invoke((Object)hlc2, a.b("\ud72a\uaee2\u243b\uba35\u319e\ub75d", -1775578338));
    }

    private static void hei(MinecraftClient minecraftClient) throws Exception {
        Object object = minecraftClient.currentScreen;
        if (object instanceof hlc) {
            hlc hlc2 = (hlc)((Object)object);
            object = hlc.class.getDeclaredMethod(a.d("\uacc7\ud560\u5fa2\uc1f4\u4a15\ucca0\u76e0\uff00\u6154", -2031593148, -955124231), String.class);
            ((Method)object).setAccessible(true);
            ((Method)object).invoke((Object)hlc2, "");
        }
    }

    private static void hej(MinecraftClient minecraftClient, String string) throws Exception {
        Field field = hlc.class.getDeclaredField(a.b("\ud4ee\uad4a\u279a\ub9c2\u323b\ub496", 903861404));
        field.setAccessible(true);
        field.set(null, string);
        for (String string2 : new String[]{a.b("\u3b24\u428b\uc85f\u5624\uddf8\u5b51\ue12d", 1386756948), a.b("\udf21\ua68e\u2c5a\ub221\u39fd\ubf54\u0529", -1384849583)}) {
            Field field2 = hlc.class.getDeclaredField(string2);
            field2.setAccessible(true);
            field2.setFloat(null, Float.NaN);
        }
        Field field3 = hlc.class.getDeclaredField(a.b("\u4555\u3cf4\ub636\u285a\ua38e\u253f\u9f73", 1361921281));
        field3.setAccessible(true);
        ((Map)field3.get(null)).clear();
        minecraftClient.setScreen((Screen)new hlc());
    }

    private static void hek(MinecraftClient minecraftClient, String string) {
        minecraftClient.getNetworkHandler().sendChatCommand(string);
    }

    private static void hel(MinecraftClient minecraftClient, String string) {
        System.out.println(a.b("\ubad2\uc375\u49af\ud7d4\u5c45\udaa0\u60e2\ue905\u775d\ufdb8", -414729557) + string + a.c(787828274, "\u4e11\u37c0\ubd73") + minecraftClient.getCurrentFps() + a.c(-1513143353, "\u43e3\u3a14\ub0d1\u2ea3"));
        ScreenshotRecorder.saveScreenshot((File)minecraftClient.runDirectory, (String)(a.b("\uafb0\ud60b\u5cdb\uc2b2\u4920\ucf8e", -1970556976) + string + a.c(-1948281975, "\u93a3\uea4c\u6081\ufef9")), (Framebuffer)minecraftClient.getFramebuffer(), (int)1, text -> System.out.println("" + text.getString()));
    }

    private static /* synthetic */ int zh(int n, int n2) {
        return n - n2 + 239775150;
    }

    private static /* synthetic */ int zi(int n, int n2) {
        return heb.zh(n, n2) ^ 0x1B7EC35E;
    }
}

