/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dry;
import a.ewk;
import a.hhf;
import a.hia;
import a.hlc;
import a.hyv;
import a.hzv;
import a.iov;
import a.isv;
import a.izx;
import a.kbm;
import a.kbs;
import a.ucg;
import a.vkl;
import a.vlv;
import a.vmc;
import a.vmo;
import a.vza;
import a.wap;
import a.whl;
import a.wlk;
import flow.Flow;
import flow.config.ConfigManager;
import flow.cosmetic.Cosmetics;
import flow.dev.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public final class hyz {
    private static final String hza = a.d("\u28bb\u5118\udbd7\u45e1\uce6b\u48ca\uf288\u7b64\ue538\u6f89\ue818", -958074736, 2118965319);
    private static final String hzb = a.b("\uba4c\uc3b4\u496d\ud71f\u5cd0\uda39\u6021\ue9d1\u778d\ufd3b\u7afc\u8094\u0e5b\u97b3\u1daa\u9b49\u211a\uae8c\u3461\ub232\u3bd8\u4196\ucf30\u54f6\ud28f\u5843\ue1fc\u6fbb", -1462453633);
    private static final int hzc = 4;
    private static final int hzd = 1;
    private static final int hze = 1;
    private static final int hzf = 1;
    private static /* synthetic */ long hzg;
    private static /* synthetic */ long hzh;

    private hyz() {
    }

    static Path gameDir() {
        return ConfigManager.gameDir();
    }

    private static List<Object[]> hzi() {
        ArrayList<Object[]> arrayList = new ArrayList<Object[]>();
        for (vmo object : iov.ALL) {
            arrayList.add(new Object[]{a.b("\u4525\u3c88\ub656\u282f\ua3f0\u250a", -971946665) + object.getName(), object});
        }
        for (vmo vmo2 : hyv.ALL) {
            arrayList.add(new Object[]{a.d("\uad45\ud4ff\u5e21\uc042\u4b95\ucd79", -1960490982, -2094078658) + vmo2.getName(), vmo2});
        }
        for (vmo vmo3 : wlk.ALL) {
            arrayList.add(new Object[]{a.c(1059159555, "\u7e7e\u07d9\u8d12\u136a\u98a2\u1e15\ua441\u2daa\ub3f2\u391e") + vmo3.getName(), vmo3});
        }
        for (vmo vmo4 : hhf.ALL) {
            arrayList.add(new Object[]{a.d("\u4368\u3acd\ub005\u2e78\ua5a4\u231f\u995b\u10f7", -2115709623, 1374721615) + vmo4.getName(), vmo4});
        }
        for (vmo vmo5 : ucg.ALL) {
            arrayList.add(new Object[]{a.b("\u3877\u41d7\ucb17\u5560\udeba\u585c", -480495615) + vmo5.getName(), vmo5});
        }
        for (vmo vmo6 : Cosmetics.ALL) {
            arrayList.add(new Object[]{a.b("\u742e\u0d93\u875c\u1933\u92ec\u144c\uae02\u27f9\ub9b6\u335a", -150178745) + vmo6.getName(), vmo6});
        }
        for (vmo vmo7 : kbm.ALL) {
            arrayList.add(new Object[]{a.b("\ue66f\u9fd6\u150e\u8b64\u00e8\u861b\u3c4b\ub5ba\u2be1\ua115", 797369864) + vmo7.getName(), vmo7});
        }
        arrayList.add(new Object[]{a.c(974428212, "\u984e\ue1e9\u6b37\uf546\u7e8d\uf82d\u426f\ucb8b\u55c3\udf2e\u58b5\ua2cb\u2c01"), isv.FIT});
        arrayList.add(new Object[]{a.c(1321085846, "\u2bf1\u5256\ud888\u46f9\ucd32\u4b92\uf1d0\u7834\ue67c\u6c91\ueb08\u117c\u9fb8\u0610\u8c4d\u0ab7"), isv.DARKEN});
        arrayList.add(new Object[]{a.d("\ua99b\ud03c\u5ae2\uc493\u4f58\uc9f8\u73ba\ufa5e\u6416\ueefb\u696b\u9318\u1dd4\u8478\u0e2d\u88dd", -191903814, 581267014), isv.MOTION});
        arrayList.add(new Object[]{a.d("\u944b\uedec\u6732\uf943\u7288\uf428\u4e6a\uc78e\u59c6\ud32b\u54a6\uaec6\u2002\ub9b5\u33fb\ub500\u0f40\u8098\u1a3d", 450299864, 1928106999), isv.PARTICLES});
        arrayList.add(new Object[]{a.b("\uccee\ub553\u3f81\ua1f8\u2a20\uac9f\u1685\u9f3b\u0170\u8bc0\u0c08\uf665\u78a0\ue106\u6b46", -878588798), ConfigManager.AUTO_SAVE});
        arrayList.add(new Object[]{a.c(836122142, "\u366f\u4fd2\uc500\u5b79\ud0a1\u561e\uec04\u65b7\ufbeb\u7154\uf682\u0cf8\u822e\u1b82\u91d6\u1732\uad6e\u22b9"), ConfigManager.LOAD_ON_START});
        for (Map.Entry entry : izx.persisted().entrySet()) {
            arrayList.add(new Object[]{entry.getKey(), entry.getValue()});
        }
        return arrayList;
    }

    public static void load() {
        int n;
        String string;
        Object object22;
        String string2 = ewk.get(a.c(-2030287407, "\u45b5\u3c16\ub6d9"));
        boolean bl = string2 == null || string2.isBlank();
        Properties properties = new Properties();
        try (InputStream inputStream = bl ? hyz.class.getResourceAsStream(a.d("\u70c6\u093e\u83e7\u1d95\u965a\u10b3\uaaab\u235b\ubd07\u37b1\ub076\u4a1e\uc4d1\u5d39\ud720\u51c3\ueb90\u6406\ufeeb\u78b8\uf152\u8b1c\u05ba\u9e7c\u1805\u92c9\u2b76\ua531", -1790576267, 1112377728)) : new ByteArrayInputStream(string2.getBytes(StandardCharsets.ISO_8859_1));){
            if (inputStream == null) {
                return;
            }
            properties.load(inputStream);
        }
        catch (Exception exception) {
            System.out.println(a.c(-927025624, "\ub651\ucfe2\u453e\udb06\u5082\ud667\u6c66\ue580\u7bdb\uf16f\u76f8\u8cc4\u021b\u9ba1\u11e9\u974d\u2d51\ua296\u3834\ube65\u378f\u4dd9\uc363\u58a6\ude90\u545b") + exception);
            return;
        }
        for (Object object22 : hyz.hzi()) {
            string = properties.getProperty((String)object22[0]);
            if (string == null) continue;
            try {
                vmo vmo2 = (vmo)object22[1];
                if (vmo2 instanceof vkl) {
                    vkl vkl2 = (vkl)vmo2;
                    vkl2.set(Boolean.parseBoolean(string));
                    continue;
                }
                if (vmo2 instanceof vmc) {
                    vmc object3 = (vmc)vmo2;
                    object3.set(Double.parseDouble(string));
                    continue;
                }
                if (!(vmo2 instanceof vlv)) continue;
                vlv vlv2 = (vlv)vmo2;
                vlv2.set(string);
            }
            catch (RuntimeException runtimeException) {}
        }
        try {
            n = Integer.parseInt(properties.getProperty(a.c(1810183108, "\u33a6\u4a16\uc0d3\u5eb8\ud561\u53d9"), a.b("\ua574", 1397925189)).trim());
        }
        catch (NumberFormatException numberFormatException) {
            n = 0;
        }
        object22 = properties.getProperty(a.c(1138738276, "\uc41a\ubdbd\u3763\ua912\u22d9\ua479\u1e3b\u97df\u0997"));
        if (object22 != null) {
            isv.select((String)object22);
        }
        if (n < 4) {
            iov.resetLook();
            hyv.ENABLED.reset();
            izx.BACKGROUND.reset();
            isv.select(a.d("\ue34b\u9ae2\u102c\u8e43\u059c", -680255380, 2134098773));
        }
        if (!String.valueOf(1).equals(properties.getProperty(a.d("\ua5cb\udc6c\u56b2\uc8c3\u4308\uc5a8\u7fea\uf60e\u6846\ue2d7\u6533\u9f51", 818388974, -1271186850)))) {
            isv.select(a.d("\u193a\u6094\uea4a\u743a\uffe7\u7903\uc30c\u4af7\ud4ab\u5e02\ud98b\u23b3\uad61\u34c3\ube89", 77651275, 1295238152));
        }
        if (!String.valueOf(1).equals(properties.getProperty(a.c(-150025691, "\uca5f\ub3f3\u393a\ua750\u2c8d\uaa0a\u106e\u998c")))) {
            iov.ROUNDNESS.reset();
        }
        iov.loadColors(properties);
        izx.load(properties);
        hzv.load(properties);
        wap.load(properties.getProperty(a.b("\u8fae\uf612\u7cce\ue2b6\u6973\uefd6\u5583\udc70", 139890634)));
        kbs.load(properties.getProperty(a.d("\u1394\u6a2d\ue0f5\u7e9f\uf513\u73ee\uc9be\u404d\ude1a\u54a7\ud361\u290d\ua7c0\u3e6a\ub433", 1949172507, 571805933)));
        if (!String.valueOf(1).equals(properties.getProperty(a.c(638471757, "\u4e2c\u3797\ubd47\u232e\ua8dc\u2e5a\u941a")))) {
            iov.choose(a.d("\u8a92\uf309\u79d9\ue7b0\u6c30\ueae3\u509e\ud962\u473f\ucd86", 33375682, 2096156444));
            kbs.select(kbs.DEFAULT);
        }
        whl.warm(kbs.selected().key, isv.selected());
        hia.select(properties.getProperty(a.c(-838486858, "\ub4d1\ucd77\u47b3\ud9d7\u5215\ud4b7")));
        hia.seenOwn(properties.getProperty(a.d("\u8845\uf1e3\u7b27\ue543\u6e81\ue823\u522c\udb9c\u45db\ucf73", -1473135370, -1760676648)));
        Cosmetics.load(properties);
        string = properties.getProperty(a.b("\u15bf\u6c02\ue6d0\u78a9\uf371\u75ce\ucfd4\u466a\ud837\u5291\ud55f\u2f31\ua1f5", -1194125871));
        if (string != null && ConfigManager.exists(string)) {
            ConfigManager.setActive(string);
        }
        try {
            int n2 = Integer.parseInt(properties.getProperty(a.d("\u2649\u5ff0\ud528\u4b42\uc0ab\u4634\ufc7b", -1140560141, -685094704), ""));
            if (n2 > 0) {
                Flow.getInstance().setOpenGuiKey(n2);
            }
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        String string3 = properties.getProperty(a.d("\uc50d\ubcae\u3661\ua857\u23da\ua57e\u1f2e", -1709446922, 57683355));
        if (string3 != null) {
            hlc.setTabKey(string3);
        }
        for (String string4 : properties.stringPropertyNames()) {
            if (!string4.startsWith(a.d("\u1100\u68a3\ue26c\u7c5a\uf7d0\u7171\ucb33\u42df\udc83\u5632\ud1a3", 1607151036, -354665264))) continue;
            try {
                hlc.scrolls().put(string4.substring(a.c(956124704, "\u4e4c\u37ef\ubd20\u2316\ua89c\u2e3d\u947f\u1d93\u83cf\u097e\u8eef").length()), Float.valueOf(Float.parseFloat(properties.getProperty(string4))));
            }
            catch (NumberFormatException numberFormatException) {}
        }
        try {
            float f = Float.parseFloat(properties.getProperty(a.c(-772639102, "\u76e0\u0f43\u858c\u1bba\u903b"), a.b("\ucf2f\ub6b1\u3c4d", -2071867550)));
            float f2 = Float.parseFloat(properties.getProperty(a.b("\u1378\u6adb\ue014\u7e22\uf5a2", 224006938), a.b("\u6d5d\u14c3\u9e3f", -267031280)));
            hlc.setWindowPos(f, f2);
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
    }

    public static void save() {
        if (dry.armed()) {
            return;
        }
        hyz.hzk(hyz.hzj());
    }

    public static void saveLater() {
        if (dry.armed()) {
            return;
        }
        Properties properties = hyz.hzj();
        vza.later(a.b("\u46c9\u3f70\ub5a8\u2bc2\ua040\u26a2\u9ce7\u1507\u8b58\u01f4\u8620\u7c58\uf29b", 796739241), () -> hyz.hzk(properties));
    }

    private static Properties hzj() {
        Properties properties = new Properties();
        for (Object[] object : hyz.hzi()) {
            String string;
            vmo vmo2 = (vmo)object[1];
            if (vmo2 instanceof vkl) {
                vkl vkl2 = (vkl)vmo2;
                string = String.valueOf(vkl2.get());
            } else if (vmo2 instanceof vmc) {
                vmc vmc2 = (vmc)vmo2;
                string = String.valueOf(vmc2.get());
            } else {
                if (!(vmo2 instanceof vlv)) continue;
                vlv vlv2 = (vlv)vmo2;
                string = vlv2.get();
            }
            properties.setProperty((String)object[0], string);
        }
        properties.setProperty(a.c(-1891167040, "\u14a2\u6d12\ue7d7\u79bc\uf265\u74dd"), String.valueOf(4));
        properties.setProperty(a.c(1649862408, "\ue776\u9ed1\u140f\u8a7e\u01b5\u8715\u3d57\ub4b3\u2afb"), isv.selected());
        properties.setProperty(a.d("\u6a3a\u139d\u9943\u0732\u8cf9\u0a59\ub01b\u39ff\ua7b7\u2d26\uaac2\u50a0", 898543414, -304298633), String.valueOf(1));
        properties.setProperty(a.b("\u2ebb\u5700\uddd0\u43b9\uc84b\u4ecd\uf48d", 289156826), String.valueOf(1));
        properties.setProperty(a.d("\u814b\uf8e7\u722e\uec44\u6799\ue11e\u5b7a\ud298", 495926758, -1786463017), String.valueOf(1));
        iov.saveColors(properties);
        izx.save(properties);
        hzv.save(properties);
        if (wap.chosen()) {
            properties.setProperty(a.d("\u251d\u5ca1\ud67d\u4805\uc3c0\u4565\uff30\u76c3", 478029325, 1712915316), wap.code());
        }
        properties.setProperty(a.c(377766346, "\u41ad\u380b\ub2cf\u2cab\ua769\u21cb"), hia.selected());
        properties.setProperty(a.c(-383488861, "\u6cc8\u156e\u9faa\u01ce\u8a0c\u0cae\ub6a1\u3f11\ua156\u2bfe"), hia.seenOwn());
        Cosmetics.save(properties);
        properties.setProperty(a.b("\u81de\uf867\u72bf\uecd5\u6759\ue1a4\u5bf4\ud207\u4c50\uc6ed\u412b\ubb47\u358a\uac20\u2679", -1065451076), kbs.selected().key);
        properties.setProperty(a.b("\uabef\ud256\u588e\uc6e4\u4d0d\ucb92\u71dd", -1710904443), String.valueOf(Flow.getInstance().getOpenGuiKey()));
        if (ConfigManager.active() != null) {
            properties.setProperty(a.d("\u8bfa\uf247\u7895\ue6ec\u6d34\ueb8b\u5191\ud82f\u4672\uccd4\u4b1a\ub174\u3fb0", 337429835, -194097441), ConfigManager.active());
        }
        if (hlc.tabKey() != null) {
            properties.setProperty(a.d("\u0872\u71d1\ufb1e\u6528\ueea5\u6801\ud251", -187041966, -1365573824), hlc.tabKey());
        }
        for (Map.Entry entry : hlc.scrolls().entrySet()) {
            properties.setProperty(a.b("\u43db\u3a78\ub0b7\u2e81\ua50b\u23aa\u99e8\u1004\u8e58\u04e9\u8378", -698989641) + (String)entry.getKey(), String.valueOf(entry.getValue()));
        }
        if (!Float.isNaN(hlc.windowX())) {
            properties.setProperty(a.d("\ub825\uc186\u4b49\ud57f\u5efe", -345268276, 441984907), String.valueOf(hlc.windowX()));
            properties.setProperty(a.c(918637187, "\u4ae1\u3342\ub98d\u27bb\uac3b"), String.valueOf(hlc.windowY()));
        }
        return properties;
    }

    private static void hzk(Properties properties) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            properties.store(byteArrayOutputStream, a.d("\udf44\ua6df\u2c0f\ub266\u39f4\ubf57\u0549\u8cb0\u12e4\u984e\u1fc8\ue5b1\u6b22\uf290\u78c3\ufe36\u443e\ucbe3\u5113\ud74e\u5eb8\u24e1\uaa5d\u3182\ub7ba\u3d24\u8488\u0add\u9037\u1660\u9dd2\u631e\ue90e\u70f3\uf6f7\u7c50\uc39f\u49e7\ucf2b\u569c\udcc4\ua22f\u2828\uafdd\u3507\ubb6c\u02bc\u8811\u0e53\u959a\u1bbc\ue161\u689a\ueec6\u7427\ufa71\u419a\uc71b\u4d77\ud4ba\u5a17\u205b\ua7b5\u2de2\ub32c\u3ada", -915220363, -635500747));
            ewk.put(a.c(-735331213, "\ubc17\uc5b4\u4f7b"), byteArrayOutputStream.toString(StandardCharsets.ISO_8859_1));
        }
        catch (Exception exception) {
            System.out.println(a.b("\uf694\u8f27\u05fb\u9bc3\u1047\u96a2\u2ca2\ua541\u3b09\ub1ab\u363d\ucc01\u42de\udb64\u512c\ud788\u6d94\ue253\u78f1\ufea0\u774a\u0d1c\u83a6\u1863\u9e55\u149e", 1133115117) + exception);
        }
    }

    private static /* synthetic */ int aeb(int n, int n2) {
        return n * n2 + -33371183;
    }

    private static /* synthetic */ int aec(int n, int n2) {
        return n + n2 + 1756919990;
    }
}

