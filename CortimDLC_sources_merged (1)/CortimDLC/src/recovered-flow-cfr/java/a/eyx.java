/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 */
package a;

import a.eul;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import flow.dev.a;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class eyx {
    private static final long eyy = 60L;
    private static final int eyz = 6;
    private static final String[] eza = new String[]{a.c(773155805, "\u6bbf\u1206\u98de\u06b4\u8d39\u0bc6\ub181\u3871\ua62f\u2c86\uab56\u5167\udff4\u465f\ucc1b"), a.d("\ue5b7\u9c0e\u16d6\u88bc\u0331\u85dc\u3f8c\ub67f\u283b\ua28d\u2557\udf6f\u51fc\uc857\u4213", -1713857707, 676429440), a.c(2066134992, "\ub7b2\uce0b\u44d3\udab9\u5134\ud7d9\u6d8c\ue465\u7a3a\uf083\u7747\u8d6a\u03f9\u9a52\u1016"), a.c(-2126358501, "\u5879\u21c0\uab18\u3572\ubeff\u3816\u825b\u0bad\u95e8\u1f48\u988c\u62a1\uec32\u7599\uffdd"), a.c(-1873148842, "\u0429\u7d90\uf748\u6922\ue2af\u6446\ude03\u57e7\uc9a9\u430f\uc4c8\u3ebe\ub064\u29d5\ua3c4\u2571\u9f24\u10e2"), a.c(1260921856, "\u247f\u5dc6\ud71e\u4974\uc2f9\u4410\ufe55\u77b1\ue9ff\u6359\ue49e\u1ee8\u9032\u0983\u8392\u053d\ubf6c\u30b4"), a.c(943375943, "\uc629\ubf8f\u354b\uab2f\u20ed\ua64f\u1c1d\u95b0\u0ba3\u8110\u06d6\ufcfd\u7274\uebdb\u6181"), a.d("\u375c\u4efa\uc43e\u5a5a\ud198\u573a\ued68\u64c5\ufad8\u706b\uf7b9\u0dcd\u8314\u1ab9\u90bd\u1612\uac43\u239b", -1570280711, -1892459050), a.b("\u3fbf\u4619\uccdd\u52b9\ud97b\u5fd9\ue58b\u6c26\uf226\u7892\uff53\u056b\u8be2\u124d\u9817", -1962721327), a.b("\ud361\uaacf\u2011\ube61\u35bc\ub34d\u0957\u80ac\u1ef0\u9459\u13d0\ue9e8\u673a\ufe98\u74d2\uf266\u486a\uc7a6\u5d51", -778841340), a.b("\ue0a5\u990b\u13d5\u8da5\u0678\u8089\u3a93\ub368\u2d34\ua79d\u2014\uda24\u54f6\ucd49\u4715\uc1f8\u7bed\uf47f\u6ed1\ue8c4", 2012537031), a.c(-1057257160, "\u895d\uf0f3\u7a2d\ue45d\u6f80\ue971\u536b\uda90\u44cc\uce65\u49ec\ub3d4\u3d06\ua4a4\u2eee\ua85a\u1251\u9d9a\u073e"), a.d("\u1215\u6bbb\ue165\u7f15\uf4c8\u7239\uc823\u41d8\udf84\u552d\ud2a4\u2894\ua646\u3ff9\ub5a5\u3348\u895d\u06c8\u9c61\u1a27", -1569195355, -1802049326), a.d("\uffce\u8660\u0cbe\u92ce\u1913\u9fe2\u25ff\uac1a\u3244\ub8f4\u3f3f\uc54d\u4bd9\ud226\u5877\ude93\u64db\ueb57\u71a0\uf7eb\u7e0b", -174133769, -454487462), a.c(1836650660, "\u10c2\u696c\ue3b2\u7dc2\uf61f\u70ee\ucaf1\u4302\udd4f\u57f9\ud032\u2a4a\ua4d6\u3d23\ub76a\u318c"), a.d("\ud231\uab9f\u2141\ubf31\u34ec\ub21d\u0802\u81f8\u1faa\u950c\u12df\ue8a5\u6625\uffd0\u7599\uf37f", 1511790504, 1594344959), a.d("\uecf4\u955a\u1f84\u81f4\u0a29\u8cd8\u36c1\ubf39\u216c\uab95\u2c02\ud669\u58a9", 628019952, -1798095233), a.d("\uaed8\ud776\u5da8\uc3d8\u4805\ucef4\u74ee\ufd18\u6354\ue9fa\u6e6a\u945f\u1a92\u8334", 1447675886, 373451086), a.b("\u5844\u21ea\uab34\u3544\ube99\u3868\u8272\u0b89\u95d5\u1f7c\u98bd\u62db\uec0d\u75e1\ufff6\u791d\uc345", 1827887139), a.b("\u0958\u70f6\ufa28\u6458\uef85\u6974\ud360\u5a8a\uc4d4\u4e3a\uc9b7\u33de\ubd1b\u24fd\uaeea\u2801\u9259", -732821185), a.c(-473679258, "\u3a01\u43af\uc971\u5701\udcdc\u5a2d\ue022\u69c1\uf792\u7d3b\ufaef\u008d\u8e52\u17a4\u9db3\u1b58\ua100"), a.c(1250566233, "\u2021\u598f\ud351\u4d21\uc6fc\u400d\ufa02\u73ee\uedb0\u6719\ue093\u1aa6\u946b\u0dcd"), a.d("\u0c85\u752b\ufff5\u6185\uea58\u6ca9\ud6a6\u5f54\uc11a\u4bb8\ucc72\u3604\ub8da\u2120\uab37\u2ddc\u9784", 1224355336, -75488534), a.b("\u030a\u7aa7\uf06e\u6e04\ue5d9\u637f\ud970\u50d9\uce94\u4421\uc3e7\u398a\ub750\u2ef6\ua4f8\u2254\u9808\u17d1\u8d65\u0b05\u82c5\uf899\u762e\uede8\u6b98\ue11e\u58ec\ud6b5\u4c42", -912522396), a.c(990709497, "\u0697\u7f3a\uf5f3\u6b99\ue044\u66e2\udced\u5544\ucb09\u41bc\uc67a\u3c17\ub2cd\u2b6b\ua165\u27c9\u9d95\u124c\u88f8\u0e98\u875c\ufd08\u73b5\ue86b\u6e08\ue483\u5d71\ud328\u49df"), a.c(721109836, "\u431f\u3ab2\ub07b\u2e11\ua5cc\u236a\u9965\u10cc\u8e81\u0434\u83f2\u799f\uf745\u6ee3\ue4ed\u6247\ud814\u57d8\ucd70\u4b2b\uc2dd\ub89b\u3605\uaded\u2b95\ua157\u18c9\u96f6\u0c1e\u8a0e\u01b5\uff64"), a.c(-985709079, "\u45ba\u3c17\ub6de\u28b4\ua369\u25cf\u9fc0\u1669\u8824\u0291\u8557\u7f3a\uf1e0\u6846\ue248\u64e2\udeb1\u517d\ucbd5\u4d8e\uc478\ube3e\u30a0\uab48\u2d30\ua7f2\u1e6c\u9050\u0abb\u8cab\u0710\uf9c1"), a.c(1055358175, "\u7c8c\u0521\u8fe8\u1182\u9a5f\u1cf9\ua6f6\u2f5f\ub112\u3ba7\ubc61\u460c\uc8d6\u5170\udb7e\u5dd4\ue787\u684b\uf2e3\u74b8\ufd4e\u8708\u0996\u927e\u1406\u9ec4\u275a\ua967\u338d\ub59d\u3e26\uc0f7"), a.c(1103242283, "\u2478\u5dd5\ud71c\u4976\uc2ab\u440d\ufe02\u77ab\ue9e6\u6353\ue495\u1ef8\u9022\u0984\u838a\u0520\ubf73\u30bf\uaa17\u2c4c\ua5ba\udffc\u5162\uca81\u4cfa\uc626\u7fae\uf191\u6b79\ued69\u66d2\u9803"), a.d("\u9cf2\ue55f\u6f96\uf1fc\u7a21\ufc87\u4688\ucf21\u516c\udbd9\u5c1f\ua672\u28a8\ub10e\u3b00\ubdaa\u07f9\u8835\u129d\u94c6\u1d30\u6776\ue9e8\u720b\uf470\u7eac\uc724\u4918\ud3f3\u55e3\ude58\u2089", -278567405, 179632818), a.d("\u80e5\uf948\u7381\uedeb\u6636\ue090\u5a9f\ud336\u4d7b\uc7ce\u4008\uba65\u34bf\uad19\u2717\ua1bd\u1bee\u9422\u0e8a\u88d1\u0127\u7b61\uf5ff\u6e1f\ue86b\u62be\udb1e\u5562\ucffb\u49b5\uc247\u3c9e\ub6d1", -171015507, 921109018), a.b("\u7ec1\u076c\u8da5\u13cf\u9812\u1eb4\ua4bb\u2d12\ub35f\u39ea\ube2c\u4441\uca9b\u533d\ud933\u5f99\ue5ca\u6a06\uf0ae\u76f5\uff03\u8545\u0bdb\u903b\u164f\u9c9a\u253a\uab46\u31dc\ub791\u3c63\uc2ba\u48f5", -83722605), a.c(1455659978, "\u9b98\ue235\u68fc\uf696\u7d4b\ufbed\u41e2\uc84b\u5606\udcb3\u5b75\ua118\u2fc2\ub664\u3c6a\ubac0\u0093\u8f5f\u15f7\u93ac\u1a5a\u601c\uee82\u7562\uf316\u79c3\uc063\u4e1f\ud484\u52c8\ud93a\u27e3\uadac"), a.b("\u32b3\u4b1e\uc1d7\u5fbd\ud460\u52c6\ue8c9\u6160\uff2d\u7598\uf25e\u0833\u86e9\u1f4f\u9541\u13eb\ua9b8\u2674\ubcdc\u3a87\ub371\uc937\u47a9\udc49\u5a3d\ud0e8\u6948\ue734\u7da8\ufbe3\u7011\u8ec8\u0487", 1255617249), a.c(1573259651, "\u09f3\u7040\ufa82\u64f7\uef37\u698d\ud3d7\u5a68\uc47c\u4ec0\uc91d\u3362\ubda8\u241e\uae10\u28a0\u92ee\u1d3f\u879a"), a.d("\u543b\u2d9c\ua742\u3933\ub2f8\u3458\u8e1a\u07fe\u99b6\u1306\u9489\u6eb6\ue06c\u79c1\uf38b\u757d\ucf39\u40a0\uda50\u5c06\ud5ff\uafa1\u210e\uba85\u3cbe\ub675\u0fd1", -478533927, 487486094), a.c(493720107, "\u9249\uebee\u6130\uff41\u748a\uf22a\u4868\uc18c\u5fc4\ud574\u52fb\ua8c4\u2607\ubfb1\u35ff\ub313\u094f\u86d1\u1c26\u9a6d\u138d"), a.c(1604825227, "\ub0e8\uc94f\u4391\udde0\u562b\ud08b\u6ac9\ue32d\u7d65\uf7d5\u705a\u8a66\u04bf\u9d0d\u175e\u91ad\u2ba1\ua434\u3e9d\ub8db"), a.c(1914491472, "\ud234\uab93\u214d\ubf3c\u34f7\ub257\u0815\u81f1\u1fb9\u9509\u1286\ue8bb\u666e\uffca\u759e\uf332\u4939\uc6f2\u5c56"), a.d("\uca26\ub381\u395f\ua72e\u2ce5\uaa45\u1007\u99e3\u07ab\u8d1b\u0a94\uf0ae\u7e68\ue7c2\u6d9a\ueb7d\u516f\udefa\u4453\uc215", 1101015236, 1022157441), a.d("\u2a4e\u53e9\ud937\u4746\ucc8d\u4a2d\uf06f\u798b\ue7c3\u6d73\ueafc\u10c6\u9e00\u07b7\u8dfc\u0b48\ub143\u3e88\ua42c", -775457528, 1403412258), a.c(-1259484363, "\ucb5a\ub2fd\u3823\ua652\u2d99\uab39\u117b\u989f\u06d7\u8c67\u0be8\uf1d3\u7f00\ue6a2\u6cf7\uea1a\u504f\udf85\u452c\uc36b\u4ad7\u30c2\ube6b\u25ad"), a.d("\ub009\uc9ae\u4370\udd01\u56ca\ud06a\u6a28\ue3cc\u7d84\uf734\u70bb\u8a80\u0451\u9def\u17b9\u9151\u2b1d\ua4da\u3e22\ub837\u31da\u4b9c", 2104518826, -628434750), a.c(-931677795, "\ub9fe\uc059\u4a87\ud4f6\u5f3d\ud99d\u63df\uea3b\u7473\ufec3\u794c\u8377\u0da8\u9416\u1e42\u98a4\u22b7\uad22\u378b\ub1cd"), a.d("\ue5b0\u9c17\u16c9\u88b8\u0373\u85d3\u3f91\ub675\u283d\ua28d\u2502\udf39\u51e6\uc85f\u421b\uc4f9\u7ebb\uf162\u6b98\ued88\u6472\u1e29\u9094\u0b0e\u8d35\u07fe\ube5a", -1936319473, -2008286765), a.d("\ud514\uacb3\u266d\ub81c\u33d7\ub577\u0f35\u86d1\u1899\u9229\u15a6\uef9f\u6143\uf8ff\u72ae\uf455\u4e16\uc1d0\u5b3c\udd2c\u54d6\u2e8d\ua030\u3baa\ubd91\u375a\u8efe", 904040836, -498514692), a.c(1717678244, "\ub0ca\uc96d\u43b3\uddc2\u5609\ud0a9\u6aeb\ue30f\u7d47\uf7f7\u7078\u8a41\u049e\u9d2c\u1777\u9187\u2bc3\ua451\u3ebc\ub8fb\u3108\u4b16\uc5e1\u5e2a\ud842"), a.c(-1864955464, "\u09da\u707d\ufaa3\u64d2\uef19\u69b9\ud3fb\u5a1f\uc457\u4ee7\uc968\u335e\ubd80\u243e\uae62\u289f\u92d4\u1d42\u87b5\u01fe\u881e"), a.d("\u2399\u5a3e\ud0e0\u4e91\uc55a\u43fa\uf9b8\u705c\uee14\u64a4\ue32b\u191c\u97d1\u0e7f\u8425\u02c2\ub8d0\u3745\uadec\u2baa", -1170917016, -720823662), a.d("\u754c\u0ceb\u8635\u1844\u938f\u152f\uaf6d\u2689\ub8c1\u3271\ub5fe\u4fcc\uc116\u58a8\ud2e1\u5401\uee59\u6194\ufb3a\u7d36\uf485\u8ecej", 621400466, -511073090), a.b("\ue2cd\u9b6a\u11b4\u8fc5\u040e\u82ae\u38ec\ub108\u2f40\ua5f0\u227f\ud84d\u569f\ucf36\u4561\uc38c\u79ce\uf655\u6ca2\ueae9\u6309", -478551377), a.c(-55776814, "\ue9bf\u9018\u1ac6\u84b7\u0f7c\u89dc\u339e\uba7a\u2432\uae82\u290d\ud33e\u5ded\uc459\u4e0d\uc8ee\u72f5\ufd6a\u67d5\ue18a\u686f\u1239\u9cd0\u0745\u8120\u0be6"), a.d("\udf90\ua637\u2ce9\ub298\u3953\ubff3\u05b1\u8c55\u121d\u98ad\u1f22\ue511\u6bc2\uf269\u783d\ufec1\u44da\ucb56\u51fc\ud7aa\u5e56\u2411\uaaff\u316a\ub70f\u3dc9", 830227825, 220830348), a.d("\u934e\ueae9\u6037\ufe46\u758d\uf32d\u496f\uc08b\u5ec3\ud473\u53fc\ua9cc\u2710\ubea6\u34e2\ub20a\u0848\u87d6\u1d21\u9b6a\u128a", -811271738, 1948543722), a.b("\uc5ff\ubc58\u3686\ua8f7\u233c\ua59c\u1fde\u963a\u0872\u82c2\u054d\uff7d\u71ad\ue812\u624e\ue4a3\u5eb5\ud128\u4b96\ucdc7\u4439\u3e74\ub090\u2b05\uad60\u27a6", 583976338), a.b("\uf5d1\u8c76\u06a8\u98d9\u1312\u95b2\u2ff0\ua614\u385c\ub2ec\u3563\ucf4d\u418f\ud83a\u5263\ud48a\u6e98\ue10d\u7ba4\ufde2", -194841166), a.c(-2079037106, "\u692d\u108a\u9a54\u0425\u8fee\u094e\ub30c\u3ae8\ua4a0\u2e10\ua99f\u53b1\udd64\u44ce\uce87\u4868\uf264\u7df1\ue758\u611e"), a.b("\u317f\u48d8\uc206\u5c77\ud7bc\u511c\ueb5e\u62ba\ufcf2\u7642\uf1cd\u0be0\u8525\u1c9e\u96d3\u1025\uaa79\u25e4\ubf14\u3942\ub0bb\ucae5\u444a\udfc1\u59fa\ud331\u6a95", 1924215059), a.c(-330742117, "\u46fa\u3f5d\ub583\u2bf2\ua039\u2699\u9cdb\u153f\u8b77\u01c7\u8648\u7c65\uf2a9\u6b19\ue141\u67a7\udde4\u522d\uc8d1\u4ec4\uc729\ubd6f"), a.b("\u0a54\u73f3\uf92d\u675c\uec97\u6a37\ud075\u5991\uc7d9\u4d69\ucae6\u30cb\ube1b\u27bf\uadff\u2b1a\u9152\u1e8e\u843d\u022e\u8b9d\uf1d6\u7f72", 658246196), a.b("\u719d\u083a\u82e4\u1c95\u975e\u11fe\uabbc\u2258\ubc10\u36a0\ub12f\u4b02\uc5d2\u5c76\ud636\u50d9\uea93\u655f\uffb5\u79a5\uf05f\u8a04\u04b9\u9f23\u1918\u93d3\u2a77", 153514481), a.c(-1907942152, "\u1c95\u6532\uefec\u719d\ufa56\u7cf6\uc6b4\u4f50\ud118\u5ba8\udc27\u260d\ua8c1\u3174\ubb35\u3dd2\u87df\u0857\u92ff\u14b6\u9d53\ue715\u69fa\uf26f\u740a\ufecc"), a.c(931609648, "\u3c53\u45f4\ucf2a\u515b\uda90\u5c30\ue672\u6f96\uf1de\u7b6e\ufce1\u06c8\u8809\u11af\u9bef\u1d08\ua71a\u288f\ub226\u3460")};
    private static volatile boolean ezb;
    private static final AtomicInteger ezc;
    private static volatile int ezd;
    private static /* synthetic */ boolean eze;
    private static /* synthetic */ boolean ezf;

    private eyx() {
    }

    public static boolean done() {
        return ezb;
    }

    public static String progress() {
        return ezc.get() + a.c(204724958, "\udaf0") + Math.max(ezd, ezc.get());
    }

    public static int loaded() {
        return ezc.get();
    }

    public static int total() {
        return ezd;
    }

    public static float fraction() {
        int n = ezd;
        return ezb ? 1.0f : (n <= 0 ? 0.0f : Math.min(1.0f, (float)ezc.get() / (float)n));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void run() {
        if (ezb) {
            return;
        }
        long l = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(6, runnable -> {
            Thread thread = new Thread(runnable, a.d("\ub877\uc1ec\u4b3c\ud555\u5ec7\ud864\u6267\ueb94\u75dc\uff6e\u78be\u82de\u0c1e\u95a4", 3439610, -1981168699));
            thread.setDaemon(true);
            return thread;
        });
        try {
            LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>(List.of(eza));
            linkedHashSet.addAll(eyx.ezg(l));
            ezd = linkedHashSet.size();
            ArrayList arrayList = new ArrayList();
            for (String object : linkedHashSet) {
                arrayList.add(executorService.submit(() -> {
                    try {
                        eul.bytes(object);
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                    ezc.incrementAndGet();
                }));
            }
            for (Future future : arrayList) {
                long l2 = 60000L - (System.currentTimeMillis() - l);
                if (l2 <= 0L) break;
                try {
                    future.get(l2, TimeUnit.MILLISECONDS);
                }
                catch (Throwable throwable) {}
            }
            executorService.shutdownNow();
        }
        catch (Throwable throwable) {
            try {
                System.out.println(a.c(75486110, "\ud3df\uaa73\u208a\ubef8\u3537\ub3c3\u09ff\u8073\u1e7c\u94cf\u130b\ue979\u67ad\ufe0d\u7449\uf2b3\u48b4\uc736\u5d82\udbc8\u5220\u2871\ua6d7\u3d07\ubb26\u31ed") + throwable);
                executorService.shutdownNow();
            }
            catch (Throwable throwable2) {
                executorService.shutdownNow();
                ezb = true;
                System.out.println(a.b("\u0c64\u75c8\uff31\u6143\uea8c\u6c78\ud644\u5fc8\uc1d6\u4b75\ucca6\u36c1\ub807\u21b1\uabb1\u2d12\u974a\u189f\u8229\u0465\u8dcb", 1628507178) + eyx.progress() + a.d("\ue3b2\u9a4a\u109e\u8ea1", -1966466613, -234423715) + (System.currentTimeMillis() - l) + a.b("\u3f82\u467e\uccb3", 444678049));
                throw throwable2;
            }
            ezb = true;
            System.out.println(a.c(-1624167542, "\u2bc4\u5268\ud891\u46e3\ucd2c\u4bd8\uf1e4\u7868\ue676\u6cd5\ueb06\u1161\u9fa7\u0611\u8c11\u0ab2\ub0ea\u3f3f\ua589\u23c5\uaa6b") + eyx.progress() + a.c(-1750403267, "\uf719\u8ee1\u0435\u9a0a") + (System.currentTimeMillis() - l) + a.d("\u8e2a\uf7d6\u7d1b", -1681195175, 1905029456));
        }
        ezb = true;
        System.out.println(a.b("\u289e\u5132\udbcb\u45b9\uce76\u4882\uf2be\u7b32\ue52c\u6f8f\ue85c\u123b\u9cfd\u054b\u8f4b\u09e8\ub3b0\u3c65\ua6d3\u209f\ua931", 650782928) + eyx.progress() + a.d("\ub88a\uc172\u4ba6\ud599", -841421513, -1820109415) + (System.currentTimeMillis() - l) + a.d("\ub040\uc9bc\u4371", -528082445, 1656269200));
    }

    private static Set<String> ezg(long l) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        try {
            JsonObject jsonObject = eyx.ezh(a.d("\ua5c2\udc7f\u56b0\uc8df\u4300\uc5a0\u7fee\uf615\u685a\ue2b7\u6522\u9f54\u1189\u8839\u0277\u84d0\u3edb\ub113\u2bbc\uadec", 22812734, 2056961419));
            if (jsonObject == null || !jsonObject.has(a.b("\u8169\uf8c5\u7207\uec7e\u67b7", 1745060101))) {
                return linkedHashSet;
            }
            linkedHashSet.add(a.b("\u15ca\u6c77\ue6b8\u78d7\uf308\u75a8\ucfe6\u461d\ud852\u52bf\ud52a\u2f5c\ua181\u3831\ub27f\u34d8\u8ed3\u011b\u9bb4\u1de4", 384112061));
            for (JsonElement jsonElement : jsonObject.getAsJsonArray(a.d("\ue1e3\u984f\u128d\u8cf4\u073d", 1110167293, 1224552306))) {
                if (System.currentTimeMillis() - l <= 30000L) {
                    String string = jsonElement.getAsString();
                    linkedHashSet.add(a.c(92248170, "\u9803\ue1be\u6b71\uf51e\u7ec1\uf861\u422f\ucbd4\u559b\udf76") + string + a.b("\u9326\uead3\u6019\ufe74\u75a2", 359568141));
                    linkedHashSet.add(a.d("\u00a4\u7919\uf3d6\u6db9\ue666\u60c6\uda88\u5373\ucd3c\u47d1\uc059\u3a34\ub4fe\u2d57\ua70b\u21eb\u9bf8", -725425680, 1036247334) + string + a.c(292516492, "\u72a6\u0b49\u8184\u1ffc"));
                    JsonObject jsonObject2 = eyx.ezh(a.c(-345977182, "\ucecb\ub776\u3db9\ua3d6\u2809\uaea9\u14e7\u9d1c\u0353\u89be") + string + a.c(118349066, "\udd21\ua4d4\u2e1e\ub073\u3ba5"));
                    if (jsonObject2 == null) continue;
                    eyx.ezi((JsonElement)jsonObject2, linkedHashSet);
                    if (!jsonObject2.has(a.b("\u196d\u60c3\uea1d\u746d\uffb0", 1686968606)) || !jsonObject2.get(a.c(756998073, "\udfca\ua664\u2cba\ub2ca\u3917")).isJsonObject() || !jsonObject2.getAsJsonObject(a.c(-622626688, "\u78f3\u015d\u8b83\u15f3\u9e2e")).has(a.b("\ue9af\u9011\u1ace\u84b7", 1447946693))) continue;
                    String string2 = jsonObject2.getAsJsonObject(a.d("\ub5fb\ucc55\u468b\ud8fb\u5326", 181884249, -216473391)).get(a.b("\ue508\u9cb6\u1669\u8810", 1691805026)).getAsString();
                    linkedHashSet.add(a.c(-1773309975, "\u6f99\u1637\u9ce9\u0299\u8944\u0fb5") + string2 + a.d("\ueadc\u9329\u19e0\u8786", -308391678, -610354188));
                    linkedHashSet.add(a.d("\u1c44\u65ea\uef34\u7144\ufa99\u7c68", -1552289242, 42397202) + string2 + a.b("\uf17f\u888d\u0243\u9c76", -1776029355));
                    continue;
                }
                break;
            }
        }
        catch (Throwable throwable) {
            System.out.println(a.c(1525932562, "\ue26d\u9bc1\u1138\u8f4a\u0485\u8271\u384d\ub1c1\u2fdd\ua560\u22af\ud8c0\u561f\ucfbf\u45f1\uc30a\u7955\uf6d7\u6c28\uea7c\u6391\u19c7\u9720\u0ca4\u8ac0\u001e\ub9ba\u37fc\uad03\u2b57\ua0e9\u5e3b\ud47a\u4d82\ucb8e\u4125") + throwable);
        }
        return linkedHashSet;
    }

    private static JsonObject ezh(String string) {
        try {
            return JsonParser.parseString((String)new String(eul.bytes(string), StandardCharsets.UTF_8)).getAsJsonObject();
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private static void ezi(JsonElement jsonElement, Set<String> set) {
        String string;
        String string2;
        if (jsonElement == null || jsonElement.isJsonNull()) {
            return;
        }
        if (jsonElement.isJsonObject()) {
            for (Map.Entry entry : jsonElement.getAsJsonObject().entrySet()) {
                eyx.ezi((JsonElement)entry.getValue(), set);
            }
        } else if (jsonElement.isJsonArray()) {
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            for (JsonElement jsonElement2 : jsonArray) {
                eyx.ezi(jsonElement2, set);
            }
        } else if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isString() && ((string2 = (string = jsonElement.getAsString().trim()).toLowerCase(Locale.ROOT)).endsWith(a.d("\ue49f\u9d70\u17bd\u89c5", -1693094604, -1134261887)) || string2.endsWith(a.b("\ucebc\ub749\u3d80\ua3e6", -646132074)) || string2.endsWith(a.c(-221285030, "\u7570\u0c82\u864c\u1879")) || string2.endsWith(a.b("\u2e23\u57d3\udd08\u4379", 985738761)) || string2.endsWith(a.c(-1269268093, "\u81a8\uf85d\u7297\uecfa\u672c")) || string2.endsWith(a.d("\uef82\u966a\u1cab\u82dd\u0905", -1978794281, -499117698)))) {
            while (string.startsWith(a.d("\uabf4", -709828656, -1070304246))) {
                string = string.substring(1);
            }
            if (string.startsWith(a.c(-2110123573, "\u11a8\u6813\ue2c3\u7caa\uf725"))) {
                string = string.substring(5);
            }
            set.add(string.startsWith(a.b("\u744f\u0df2\u873d\u1952\u928d\u142d\uae63\u2798\ub9d7\u333a", 458257446)) ? string : a.b("\u4d4e\u34f3\ube3c\u2053\uab8c\u2d2c\u9762\u1e99\u80d6\u0a3b", -180335321) + string);
        }
    }

    static {
        ezc = new AtomicInteger();
    }

    private static /* synthetic */ int mm(int n, int n2) {
        return (n ^ n2) + 2133302440;
    }

    private static /* synthetic */ int mn(int n, int n2) {
        return n - n2 | 0x9D524606;
    }
}

