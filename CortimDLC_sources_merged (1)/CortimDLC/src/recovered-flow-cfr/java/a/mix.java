/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayNetworkHandler
 *  net.minecraft.client.network.PlayerListEntry
 *  net.minecraft.text.ClickEvent
 *  net.minecraft.text.ClickEvent$RunCommand
 *  net.minecraft.text.ClickEvent$SuggestCommand
 *  net.minecraft.text.Style
 *  net.minecraft.text.Text
 */
package a;

import a.hhf;
import a.izx;
import a.kfa;
import a.kfe;
import a.vhz;
import a.vlv;
import a.vmc;
import a.vmu;
import a.wap;
import flow.dev.a;
import java.util.Optional;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.Style;
import net.minecraft.text.Text;

public class mix
extends kfe {
    private static mix miy;
    private final vlv miz = this.add(new vlv(a.c(-1743153279, "\u97c3\uee46\u6488\ufafb"), a.b("\u5570\u2cf5\ua63d\u3840\ub39c\u3527\u8f63", -1848421071), a.c(-1420424538, "\u0ae7\u7362\uf9aa\u67d7\uec0b\u6ab0\ud0f4"), a.c(1839720274, "\ue71f\u9e9d\u145d\u8a3b\u01e7\u8740\u3d12\ub4e8")));
    private final vmu mja = this.add(new vmu(a.b("\uc232\ubbaf\u317e\uaf0f\u24d4\ua26a\u1833", -510147978), a.d("\ue7e8\u9e02\u14d5\u8ab5\u0160\u87d1\u3d84\ub460\u2a3b", -327898782, -321630548), 64));
    private final vmc mjb = this.add(new vmc(a.c(1289003425, "\ua1e0\ud870\u52aa\uccd6\u4719"), 0.6, 0.0, 3.0, 0.1).suffix(a.d("\u350c", 1307179338, -488453068)));
    private static final int mjc = 322;
    private static final Pattern mjd;
    private static final Pattern mje;
    private static final Pattern mjf;
    private static final Pattern mjg;
    private static final Pattern mjh;
    private static final Pattern mji;
    private static final Random mjj;
    private String mjk;
    private long mjl;
    private long mjm;
    private static /* synthetic */ boolean mjn;
    private static /* synthetic */ long mjo;

    public mix() {
        super(a.b("\u36a3\u4f26\uc5f4\u5b9e\ud067\u56f4\ueca7\u6550\ufb1a\u71af", 310982376), a.d("\u00e8\u797b\uf3a8\u6ddf\ue61d\u60a8\udafc\u535e\ucd55\u47f5\uc02f\u3a57\ub495\u2d3b\ua775\u2182\u9b99\u141a\u8ebe\u08fb\u8108\ufb49\u75ec\uee3a\u6842\ue2c0\u5b31\ud57b\u4fd5\uc9cd\u4263\ubcb5\u36ec\uaf14\u294d", -135872204, 1622393278), kfa.PLAYER);
        miy = this;
    }

    public static void onMessage(Text text) {
        mix mix2 = miy;
        if (mix2 == null || !mix2.isEnabled() || text == null) {
            return;
        }
        mix2.mjp(text);
    }

    private void mjp(Text text) {
        String string = text.getString().replace('\u0451', '\u0435').replace('\u0401', '\u0415');
        if (string.isEmpty() || !mix.looksLikeRequest(string)) {
            return;
        }
        String string2 = mix.mjq(text, string);
        if (this.miz.is(a.c(157044971, "\u50aa\u292f\ua3e7\u3d9a\ub646\u30fd\u8ab9")) ? string2 == null || !hhf.isFriend(string2) : string2 == null && this.mja.get().contains(a.b("\u98ee\ue14a\u6b96\uf5eb\u7e34\uf89d", 2088278163))) {
            return;
        }
        this.mjk = string2 == null ? "" : string2;
        this.mjl = System.currentTimeMillis() + Math.round(this.mjb.get() * 1000.0) + (long)mjj.nextInt(250);
    }

    static boolean looksLikeRequest(String string) {
        return mjd.matcher(string).find() && mje.matcher(string).find() && !mjf.matcher(string).find() && !mjg.matcher(string).find();
    }

    private static String mjq(Text text, String string) {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        ClientPlayNetworkHandler clientPlayNetworkHandler = minecraftClient.getNetworkHandler();
        if (clientPlayNetworkHandler == null || minecraftClient.player == null) {
            return null;
        }
        String string3 = minecraftClient.player.getName().getString();
        String[] stringArray = new String[1];
        text.visit((style, string2) -> {
            String string3;
            Object object;
            ClickEvent clickEvent = style.getClickEvent();
            if (clickEvent instanceof ClickEvent.RunCommand) {
                ClickEvent.RunCommand runCommand = (ClickEvent.RunCommand)clickEvent;
                v0 = runCommand.command();
            } else {
                clickEvent = style.getClickEvent();
                if (clickEvent instanceof ClickEvent.SuggestCommand) {
                    object = (ClickEvent.SuggestCommand)clickEvent;
                    v0 = object.command();
                } else {
                    v0 = string3 = null;
                }
            }
            if (string3 != null && ((Matcher)(object = mji.matcher(string3.trim()))).find() && !((Matcher)object).group(3).equalsIgnoreCase(string3)) {
                stringArray[0] = ((Matcher)object).group(3);
                return Optional.of(Boolean.TRUE);
            }
            return Optional.empty();
        }, Style.EMPTY);
        if (stringArray[0] != null) {
            PlayerListEntry playerListEntry = clientPlayNetworkHandler.getCaseInsensitivePlayerInfo(stringArray[0]);
            return playerListEntry != null ? playerListEntry.getProfile().name() : stringArray[0];
        }
        Matcher matcher = mjh.matcher(string);
        while (matcher.find()) {
            String string4 = matcher.group();
            if (string4.equalsIgnoreCase(string3)) continue;
            if (hhf.isFriend(string4)) {
                return string4;
            }
            PlayerListEntry playerListEntry = clientPlayNetworkHandler.getCaseInsensitivePlayerInfo(string4);
            if (playerListEntry == null) continue;
            return playerListEntry.getProfile().name();
        }
        return null;
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        if (this.mjk == null || System.currentTimeMillis() < this.mjl) {
            return;
        }
        String string = this.mjk;
        this.mjk = null;
        if (System.currentTimeMillis() - this.mjm < 1500L || minecraftClient.getNetworkHandler() == null) {
            return;
        }
        String string2 = this.mja.get().trim().replace(a.c(-152315449, "\ud9ba\ua01e\u2ac2\ub4bf\u3f60\ub9c9"), string);
        if (string2.isEmpty()) {
            return;
        }
        this.mjm = System.currentTimeMillis();
        if (string2.startsWith(a.c(1948725704, "\u31e6"))) {
            minecraftClient.getNetworkHandler().sendChatCommand(string2.substring(1));
        } else {
            minecraftClient.getNetworkHandler().sendChatMessage(string2);
        }
        izx.alert(string.isEmpty() ? this.getName() : string, wap.s(a.c(283939839, "\u93ba\uea3a\u60e0\ufe98\u755a\uf3f4\u49ba\uc04d\u5e46\ud4b6\u5367\ua916\u27c7\ube63\u3434\ub2d4\u089a"), a.b("\uf193\u8835\u02e8\u9c97\u174a\u91fa\u2bd7\ua224\u3819\ub6b7\u311b\ucb12\u45c0\udc03\u565d", -2016348738)), vhz.FRIENDS, true);
    }

    static {
        mjd = Pattern.compile(a.d("\u8808\uf1e5\u7b32\ue552\u6e98\ue821\u5276\udb96\u45c0\ucf7c\u48b8\ub2de\u3c10\ua5a9\u2feb\ua913\u1355\u9c91\u063d\u8071\u0980\u73d9\uf954\u62f2\ue483\u6e5c\ud7e5\u59b5\uc33c\u456f\ucae2\u3413\ube62\u23b3\ua59d\u2b4f\u94a6\u1e9c", -1767481266, 1618470984), 322);
        mje = Pattern.compile(a.b("\u0162\u7889\uf24d\u6c28\ue7fb\u615a\udb1f\u52e9\uccbe\u4244\uc590\u3fee\ub146\u2889\ua2a5\u2069\u9a2d\u15ea\u8f56\u091d\u80ed\ufab3\u7039\ueb93\u6d95\ue736\u5ef2\ud49d\u4a29\ucc07\u47ca\ub964\u3352\uaad9\u28b4\ua218\u1ddd\u97b4\u117f\u88c1\u0283\u7c60\uf62b\u7194\ueb42\u652b\udcf0\u565a\ud05a\u4bd2\uc5b7\u3f7c\ub6c2\u34d5\uaa3c\u207f\u9bc2\u1d1f\u932c\u0ebb\u8416\ufa26\u7da1\uf7f4\u693f\ue4c7\u5e9c\ud869\u522f\ucd9c\u474f\uc138\u38f2\ub247\u2c1c\ua7e5\u21b6\u9b0e\u12c1\u8ca6\u0666\u8064\ufb8c\u7559\uef3f\u66d3\ue05e\u5a11\ud1ad\u4b83\ucd48\u449c\ube99\u3045\uabf8\u2999\ua34b\u1d38\u94eb\u0e5c\u881e\u03eb\u7de5", 746193197), 322);
        mjf = Pattern.compile(a.d("\u68a5\u150e\u9fa4\u05be\u8a77\u0cba\ub694\u3f1a\ua135\u2b86\uac5f\u562d\ud8f9\u450c\ucb11\u4d99\uf3bd\u787b\ue2cf\u6491\ued19\u9736\u19fa\u8252\u042e\u8efc\u330b\ub911\u23e1\ua5bf\u2e73\ud0dc\u5aec\uc707\u453f\ucb93\u7026\ufe38\u7896\ue101\u6b15\u15f8\u9fb5\u1802\u829c\u08ae\ub101\u3bcd\ubdfd\u265c\ua82d\u52f5\udb4c\u5d15\uc3f3\u4db5\uf614\u70c4\ufea5\u6776\ue9cd\u9789\u102f\u9e3c\u008f\u8943\u336f\ub5ee\u3fbb\ua003\u2ade\uaca7\u5165\udfcc\u4194\uca16\u4c3f\uf68a\u7f20\ue56e\u6fa4\ue9e3\u924a\u1cce\u86ea\u0f2d\u8995\u33de\ubc29\u267d\ua0d8\u2913\ud331\u5da8\uc612\u4054\uca88\u74bc\ufd3c\u679b\ue1c7\u6a2c\u1477\u9ec3\u070a\u8161\u0be0\ub400\u3e44\ub8f0\u22f0\uab57\u5593\udfd8\u5823\uc27c\u4cdc\uf519\u7f6e\uf9af\u6206\uec50\u96f7\u10f5\u9954\u038e\u8de7\u363e\ub07e\u3ad9\ua301\u2d6a\ud7e9\u5050\uda4a\u44fa\ucef9\u774d\uf188\u7be3\ue433\u6ed0\ue88a\u916d\u1b35\u85b8\u0e1a\u8842\u32bc\ubcf8\u2554\uaf98\u29e1\ud264\u5c8b\uc6d2\u4f21\uc961\u7393\ufc4b\u6612\ue0ae\u6aea\u134f\u9d9c\u07fd\u8038\u0a8e\ub485\u3d20\ua768\u21ca\uaa13\u5475\udeb2\u4707\uc158\u4b9f\uf5eb\u7e6e\uf88d\u62c7\ueb7b\u9556\u1fc2\u984f\u0237\u8cee\u3506\ubf41\u39a0\ua3a2\u2c31\ud694\u50ce\ud92d\u4329\ucdda\u760e\uf07f\u7aab\ue354\u6d0e\u17e9\u91f2\u1a55\u848d\u0ee6\ub774", -1263867414, 2085978550), 322);
        mjg = Pattern.compile(a.b("\ub728\ucea7\u443e\ude58\u55f0\ud339\u696f\ue0ec\u7ebe\uf031\u73a1\u89af\u0700\u9eb4\u1495\u9269\u2854\ua3c9\u3d39\ubb17\u3298\u48cc\uc60d\u5da8\udf90\u5102\ue8ce\u66e7\ufc15\u7a36\uf1f1\u0f23\u8128\u18c4\u9e95\u1424\uabf5\u2191\ua746\u3ee6\ub4b8\uca51\u401a\uc7aa\u5d76\ud300\u6adf\ue06f\u6638\uf9ab\u77a4\u8d0d\u04bb\u82ef\u181f\u9646\u2df1\uaf41\u2519\ubc95\u3274\u4c67\ucbe8\u41c1\udf0f\u56bb\ueceb\u6a1f\ue04b\u7b9d\uf165\u7749\u8ec0\u0468\u9a26\u11df\u9791\u2d3b\ua4ff\u3a8f\ub058\u324d\u4987\uc755\u5d55\ud48b\u567e\ue86b\u67ed\ufdbf\u7b7b\uf2a5\u08d3\u8262\u1dba\u9be5\u112c\uab38\u22ca\ubc39\u3a12\ub19d\ucfc7\u457e\udca9\u5ad0\ud462\u6bf8\ue1f2\u6755\uf944\u7089\u8e38\u0460\u839b\u19cf\u977b\u2acd\ua095\u2619\ubdf0\u33be\u494f\ucf11\u46ab\udc7c\u5206\ue9d7\u6fcb\ue520\u7cf2\uf29b\u0844\u8fe8\u05bf\u9b46\u1118\ua8ed\u2e71\ua41a\u3bcc\ub120\u3706\u4ec9", 1771485156), 322);
        mjh = Pattern.compile(a.c(-33075852, "\u4d6f\u34c9\ube19\u2075\uabd8\u2d73\u974c\u1eca\u80ae\u0a53\u8dd7\u77ec\uf926\u6083\ueab6\u6c45\ud67e\u59dd\uc374\u4549\uccc9\ub6a3\u385c\ua3da\u25ef\uaf23\u1684\u98b3\u0246\u8431\u0fca\uf104\u7b56\ue2a0\u64b8\uee5c\u519c\udbf3\u5d5a\uc4f1\u4ec2\u3044\uba2c\u3dd1\ua751\u296a\u90a4\u1a01\u9c28\u07fb\u89fc"));
        mji = Pattern.compile(a.d("\u04fc\u7d3c\uf7ff\u6999\ue23a\u6484\udeae\u575d\uc95e\u43eb\uc429\u3e5a\ub08d\u293a\ua37c\u2589\u9fce\u1017\u8aa0\u0cf8\u8513\uff54\u71e8\uea31\u6c4a\ue68a\u5f39\ud16a\u4b9d\ucdca\u466c\ub8b9\u32fe\uab12\u2d43\ua7f2\u1823\u9247\u1490\u8d7c\u0756\u79a8\uf382\u7430\uee92\u60cc\ud947\u53f5\ud5c9\u4e02\uc01d\u3abb\ub337\u352a\uaf8e\u2195\u9a37\u1cf2\u96e7\u0f34\u81a5\ufbbc\u7c50\uf61c\u68d4\ue12e\u5b29", -711632342, -424059189), 2);
        mjj = new Random();
    }

    private static /* synthetic */ int bbe(int n, int n2) {
        return n + n2 + -1860425755;
    }
}

