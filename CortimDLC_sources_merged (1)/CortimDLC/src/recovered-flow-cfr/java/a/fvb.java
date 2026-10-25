/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.gui.Click
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.input.CharInput
 *  net.minecraft.client.input.MouseInput
 *  net.minecraft.client.util.ScreenshotRecorder
 *  net.minecraft.component.DataComponentTypes
 *  net.minecraft.component.type.LoreComponent
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.text.Text
 *  net.minecraft.util.math.BlockPos
 *  org.lwjgl.glfw.GLFW
 *  org.lwjgl.glfw.GLFWCursorPosCallback
 *  org.lwjgl.glfw.GLFWCursorPosCallbackI
 */
package a;

import a.hlc;
import a.kfe;
import a.kfx;
import a.mpq;
import a.nxa;
import a.oqv;
import a.pjd;
import a.pnr;
import a.ppu;
import a.pte;
import a.vlj;
import a.wam;
import a.wap;
import flow.Flow;
import flow.dev.a;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.CharInput;
import net.minecraft.client.input.MouseInput;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWCursorPosCallbackI;

final class fvb {
    private static int fvc;
    private static BlockPos fvd;
    private static /* synthetic */ boolean fve;
    private static /* synthetic */ String fvf;

    private fvb() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) throws Exception {
        kfx kfx2 = Flow.getInstance().getModuleManager();
        if (n == 1) {
            fvb.fvu(minecraftClient, a.d("\ueab6\u9301\u19de\u87a7\u0c78\u8acb\u3093\ub963\u2779\uad8b\u2a49\ud02f\u5efc\uc758\u4d16\ucbf8\u71a4", 359719877, -728954619));
            fvb.fvu(minecraftClient, a.d("\u4b65\u32c9\ub81e\u2667\uadf5\u2b17\u9152\u18b2\u86b9\u0c1e\u8bcb\u71ba\uff6d", -561393896, 721847300));
            fvb.fvu(minecraftClient, a.b("\ub59e\ucc3d\u46ea\ud88e\u5345\ud5f9\u6fbd\ue61e\u7802\uf2bc\u7566\u8f13\u01d7", 1172813284));
            fvb.fvl();
            fvb.fvp();
            fvb.fvq(kfx2);
            fvd = minecraftClient.field_1724.method_24515();
            fvb.fvu(minecraftClient, a.b("\ub13d\uc89a\u4258\udc3f\u57e6\ud154\u6b0b\ue2f2\u7ce6\uf609\u7196\u8bf5\u057c\u9c93\u169e\u9025\u2a7e\ua5e2\u3f55\ub903\u30ff\u4aa8\uc40a\u5fc8\ud9b0\u5373\uea8e\u6486\ufe7a\u7826\uf383\u0d55", -744246930));
            fvb.fvu(minecraftClient, a.b("\uf2e3\u8b44\u0186\u9fe1\u1438\u928a\u28d5\ua12c\u3f38\ub5d7\u3248\uc82b\u46a2\udf5c\u551e\ud3b1\u69b4\ue671\u7c8f\ufada\u732a\u0970\u87c5\u1c05\u9a69\u10bf\ua91e\u2701\ubdaf\u3bf5\ub04b\u4e8c\uc4c4", 291369649));
            fvb.fvu(minecraftClient, a.c(2137639030, "\uc864\ub1c3\u3b01\ua566\u2ebf\ua80d\u1252\u9bab\u05bf\u8f50\u08cf\uf2ac\u7c25\ue5db\u6f99\ue936\u5334\udcf6\u4608\uc05d\u49ad\u33f7\ubd42\u2682\ua0ee\u2a38\u9399\u1d86\u8724\u017b\u8ac2\u7427\ufe40\u67a7\ue1f9\u6b48\ud4ac\u5ef1\ud838\u4187\ucbd1\ub515\u3f7b\ub8cd\u2218\uac63\u15b7\u9f0f\u191a\u8298\u0cea\uf626\u7f97\uf9da\u631c\ued6b\u56c9\ud00c\u5a62\uc3b2\u4d1f\u3765\ub0bd\u3afd\ua42f\u2d92\u978f\u113f\u9b7e\u04c7\u8e02\u0873\uf1be\u7b09\ue558\u6ebf\ue8a1\u5271\udbdb\u41b0\ucb7a\u4d24\u369d\ub843\u2621\uaffe\u2943\u9312\u1ce3\u86bc\u000f\u89d0\u73a9\ufd78\u66b4\ue0c5\u6a0a"));
            fvb.fvu(minecraftClient, a.b("\u9122\ue885\u6247\ufc20\u77f9\uf14b\u4b14\uc2ed\u5cf9\ud616\u5196\uabf8\u253d\ubcd2\u36df\ub070\u0a75\u85b0\u1f4e\u991b\u10eb\u6ab1\ue404\u7fc4\uf9a8\u737e\ucadf\u44c0\ude6e\u5834\ud38a\u2d4d\ua705", -1173909136));
            fvb.fvu(minecraftClient, a.c(1219345604, "\ubcf8\uc55f\u4f9d\ud1fa\u5a23\udc91\u66ce\uef37\u7123\ufbcc\u7c4c\u8622\u08e7\u9108\u1b14\u9df4\u27e5\ua87e\u32d9\ub4c5\u3d36\u4760\uc9d8\u520f\ud461\u5ea3\ue717\u6954\uf3ed\u75e9\ufe54\u008f\u8af4\u1329\u9560\u1fdf\ua001\u2a65\uacab\u350e\ubf4c\uc1bc\u4bf5\ucc6f\u5693\ud8f3\u613d\ueb80\u6d81\uf611\u7874\u82ad\u0b0c\u8d5d\u17bc\u99eb\u2256\ua491\u2eab\ub71b\u39d5\u4787\uc064\u4a44\ud4f5\u5d3b\ue30b\u65f4\uefad\u701c\ufac1\u7cbe\u8561\u0fde\u9183\u1a72\u9c5a\u26cb\uaf18"));
        }
        if (n == 20) {
            BlockPos blockPos = pte.find(minecraftClient, fvd, a.c(1428921349, "\u9838\ue18c\u6b50\uf52b\u7ef3"), a.b("\u0da8\u7411\ufec5\u60be\ueb65\u6dd8\ud78f", -2026829422));
            BlockPos blockPos2 = pte.find(minecraftClient, fvd, a.b("\u75ee\u0c2f\u868d\u1882\u932a", 173896106));
            fvb.fvr(a.c(-1752077886, "\u6990\u1037\u9ae9\u0498\u8f03\u09e1\ub3a8\u3a57\ua401\u2efe\ua960\u531d\uddd9\u4471\uce3a\u4898\uf283\u7d4e\ue7f0\u61e4\ue850\u920a\u1cb4\u8773\u010b\u8b8e\u3274\ubc38\u269b\ua082\u2b38\ud5e6\u5fa0\uc645\u4045\ucabb\u756d"), fvd.method_10069(2, 1, 4).equals((Object)blockPos), String.valueOf(blockPos));
            fvb.fvr(a.c(-1459945252, "\u0089\u793f\uf3f9\u6d87\ue65a\u60e6\udab2\u534a\ucd52\u47b0\uc079\u3a06\ub4d8\u2d27\ua739\u21c4\u9b98\u1450\u8efb\u08f9\u815a\ufb17\u75a9\uee3d\u6801\ue2db\u5b65\ud522\u4fd2\uc9d7\u4231\ubcfb\u36be\uaf4e\u290a\ua3e9\u1c77\u961b"), fvd.method_10069(-2, 0, 4).equals((Object)blockPos2), String.valueOf(blockPos2));
        }
        if (n == 24) {
            wap.set(wam.EN);
            fvb.fvs(minecraftClient, kfx2.get(nxa.class).lootList());
        }
        if (n == 36) {
            fvb.fvv(minecraftClient, a.b("\u2498\u5d2e\ud7ee\u4980\uc217\u44e7\ufeb7\u7746\ue902\u63ea\ue463\u1e04\u90c0\u0967\u8335\u05cf\ubfc3\u305a\uaae2", 1708270829));
        }
        if (n == 37) {
            minecraftClient.method_1507(null);
            wap.set(wam.RU);
            fvb.fvs(minecraftClient, kfx2.get(mpq.class).lootList());
        }
        if (n == 49) {
            fvb.fvv(minecraftClient, a.d("\u2ce0\u5556\udf96\u41f8\uca6f\u4c9f\uf6cf\u7f3e\ue17a\u6b92\uec09\u1673\u98ae\u0156\u8b5a\u0dac", 528783803, -796609235));
        }
        if (n == 50) {
            fvb.fvt(minecraftClient.field_1755, a.d("\ud56d\uacae\u2676\ub804\u33aa", -69843545, -1833200499));
        }
        if (n == 58) {
            fvb.fvv(minecraftClient, a.c(-432105100, "\u9906\ue0b0\u6a70\uf41e\u7f89\uf979\u4329\ucad8\u549c\ude74\u59ef\ua395\u2d48\ub4b0\u3ebd\ub85a\u0211\u8dd3\u1771\u912b"));
            minecraftClient.method_1507(null);
        }
        if (n == 60 || n == 116) {
            wap.set(n == 60 ? wam.RU : wam.EN);
            fvb.fvk(minecraftClient, a.d("\u19bc\u6031\ueaef\u7486\uff4d\u79eb", 518154455, 2137813309));
        }
        if (n == 70 || n == 126) {
            fvb.fvi(minecraftClient, nxa.class);
        }
        if (n == 86) {
            fvb.fvv(minecraftClient, a.c(-1099881592, "\u23e1\u5a57\ud097\u4ef9\uc56e\u4386\uf9ce\u703f\uee63\u64ca\ue304\u196c\u97e6\u0e08\u845c"));
        }
        if (n == 87) {
            fvb.fvh(minecraftClient, nxa.class, 1);
        }
        if (n == 100) {
            fvb.fvv(minecraftClient, a.b("\uf5df\u8c69\u06a9\u98c7\u1350\u95af\u2ffe\ua61c\u3855\ub2ad\u3521\ucf57", 542242229));
        }
        if (n == 101) {
            fvb.fvh(minecraftClient, oqv.class, 1);
        }
        if (n == 112) {
            fvb.fvv(minecraftClient, a.d("\u0217\u7ba1\uf161\u6f0f\ue498\u6267\ud836\u51d4\ucf9d\u4565\uc2f7\u3885\ub652\u2ff8\ua5ba\u235c", 1928486297, 1694916600));
        }
        if (n == 142) {
            fvb.fvv(minecraftClient, a.b("\u34fb\u4d4d\uc78d\u59e3\ud274\u549c\ueed4\u6725\uf979\u73d0\uf41e\u0e76\u80fc\u1905\u935d", -469748590));
            minecraftClient.method_1507(null);
            wap.set(wam.RU);
        }
        if (n == 146) {
            System.out.println(a.c(-704239828, "\u2741\u5ef7\ud437\u4a59\uc1c3\u4726\ufd64\u7483\ueadb\u6024\ue7ed") + (fvc == 0 ? a.b("\u5cef\u2553\uaf80\u319d\uba3a\u3c9a\u86db\u0f2a\u9163\u1bd3", 1468161188) : fvc + a.b("\u520e\u2bd9\ua10d\u3f74\ub4a6\u321e\u884c", 1795838505)));
            return true;
        }
        return false;
    }

    private static double[] fvg(MinecraftClient minecraftClient, Class<? extends kfe> clazz) throws Exception {
        Object object = minecraftClient.field_1755;
        if (!(object instanceof hlc)) {
            return null;
        }
        hlc hlc2 = (hlc)((Object)object);
        object = hlc.class.getDeclaredField(a.d("\uf24a\u8be4\u012d\u9f46\u149a\u9225\u287f", 113480592, -554737237));
        ((Field)object).setAccessible(true);
        for (Object e : (List)((Field)object).get((Object)hlc2)) {
            if (!clazz.isInstance(fvb.fvj(e, a.d("\u8b72\uf2c1\u7819\ue679\u6db7\ueb0f", -2012826531, 1957642052)))) continue;
            float f = ((Float)fvb.fvj(e, a.d("\ufbff", -2116758154, 944778992))).floatValue() + 24.0f;
            float f2 = ((Float)fvb.fvj(e, a.d("\u45b8", -1359732373, -507812693))).floatValue() + 10.0f;
            float f3 = ((Float)fvb.fvj((Object)hlc2, a.c(-1149644514, "\ud176\ua8da\u2212\ubc6d\u37b4\ub102\u0b67"))).floatValue();
            float f4 = ((Float)fvb.fvj((Object)hlc2, a.d("\ua945\ud0e9\u5a21\uc45e\u4f87\uc931\u7355", -2147268934, -1005195369))).floatValue();
            float f5 = ((Float)fvb.fvj((Object)hlc2, a.b("\u4eb4\u3715\ubdc4\u23b8\ua866", -1361228094))).floatValue();
            return new double[]{f3 + f * f5, f4 + f2 * f5};
        }
        System.out.println(a.d("\ua03d\ud98b\u534b\ucd25\u46bf\uc05a\u7a18\uf3ff\u6da7\ue758\u6091\u9aae\u1478\u8d86\u0796\u8165\u3b39\ub4fe\u2e09\ua81e\u21e0\u5bac\ud54d", 1530949356, -269431136) + clazz.getSimpleName());
        return null;
    }

    private static void fvh(MinecraftClient minecraftClient, Class<? extends kfe> clazz, int n) throws Exception {
        double[] dArray = fvb.fvg(minecraftClient, clazz);
        if (dArray != null) {
            minecraftClient.field_1755.method_25402(new Click(dArray[0], dArray[1], new MouseInput(n, 0)), false);
        }
    }

    private static void fvi(MinecraftClient minecraftClient, Class<? extends kfe> clazz) throws Exception {
        double[] dArray = fvb.fvg(minecraftClient, clazz);
        if (dArray != null) {
            double d = minecraftClient.method_22683().method_4495();
            double d2 = dArray[0] * d;
            double d3 = dArray[1] * d;
            long l = minecraftClient.method_22683().method_4490();
            GLFWCursorPosCallback gLFWCursorPosCallback = GLFW.glfwSetCursorPosCallback((long)l, null);
            GLFW.glfwSetCursorPosCallback((long)l, (GLFWCursorPosCallbackI)gLFWCursorPosCallback);
            GLFW.glfwSetCursorPos((long)l, (double)d2, (double)d3);
            if (gLFWCursorPosCallback != null) {
                gLFWCursorPosCallback.invoke(l, d2, d3);
            }
        }
    }

    private static Object fvj(Object object, String string) throws Exception {
        for (Class<?> clazz = object.getClass(); clazz != null; clazz = clazz.getSuperclass()) {
            try {
                Field field = clazz.getDeclaredField(string);
                field.setAccessible(true);
                return field.get(object);
            }
            catch (NoSuchFieldException noSuchFieldException) {
                continue;
            }
        }
        throw new NoSuchFieldException(string);
    }

    private static void fvk(MinecraftClient minecraftClient, String string) throws Exception {
        Field field = hlc.class.getDeclaredField(a.c(192585945, "\ua0ab\ud90f\u53df\ucd87\u467e\uc0d3"));
        field.setAccessible(true);
        field.set(null, string);
        for (String string2 : new String[]{a.c(-826463788, "\u29a4\u500b\udadf\u44a4\ucf78\u49d1\uf3ad"), a.b("\ub258\ucbf7\u4123\udf58\u5484\ud22d\u6850", -430788056)}) {
            Field field2 = hlc.class.getDeclaredField(string2);
            field2.setAccessible(true);
            field2.setFloat(null, Float.NaN);
        }
        minecraftClient.method_1507((Screen)new hlc());
    }

    private static void fvl() {
        List<String> list = List.of(ppu.WARDEN_DEFAULTS);
        List<String> list2 = List.of(ppu.END_DEFAULTS);
        fvb.fvr(a.d("\uee70\u97d7\u1d17\u8370\u08a6\u8e1c\u3401\ubdbc\u23e6\ua94d\u2e99\ud4bc\u5a23\uc39b\u49da\ucf78\u7522\ufaf1\u6055\ue648\u6fba\u15ec\u9b54\u0093", 1971120378, 1994196709), list.size() == 57, String.valueOf(list.size()));
        fvb.fvr(a.c(981350604, "\u38bc\u4106\ucbdf\u55ea\ude71\u58c5\ue28c\u6b7a\uf571\u7f88\uf852\u0231\u8cb5\u1511\u9f4e\u19a6\ua3a5\u2c71\ub6c5\u309f\ub97e"), list2.size() == 59, String.valueOf(list2.size()));
        fvb.fvm(a.d("\u181a\u61a2\ueb64\u7518\ufec9\u786b", -1562568576, 1620639993), new ItemStack((ItemConvertible)Items.field_8833), true, true);
        fvb.fvm(a.c(-876147091, "\u0e0c\u77b6\ufd74\u6319\ue8c3\u6e65\ud42d\u5dc1\uc38f\u497b\uceea\u3496\uba41\u23eb\ua9bf"), new ItemStack((ItemConvertible)Items.field_22030), true, true);
        fvb.fvm(a.c(-54121679, "\u2b5b\u52e1\ud83f\u4645\ucd9b\u4b25\uf16c\u788c\ue6d2\u6c27\uebb5\u11d5\u9f02\u06af\u8cf5"), new ItemStack((ItemConvertible)Items.field_8367), true, true);
        fvb.fvm(a.c(-102886311, "\u1422\u6d9e\ue746\u7924\uf2fc\u7457\uce50\u47f5\ud9bf\u5303\ud4d5\u2ebe\ua077\u39ca\ub396"), fvb.fvn(Items.field_8288, a.c(-1371863710, "\u052a\u5ac5\uf64e\u6842\ue797\u6134\udb6c\u529e\uccb8\u4674\uc1ab\u3bd7\ub11d\u2cae\ua6e7\u206e\u9a51\u158d\u8f33")), true, true);
        fvb.fvm(a.b("\uf454\u8df6\u0722\u9958\u12d6\u9433\u2e75\ua789\u39d3\ub378\u34b5\ucec8\u4010\ud9f5\u53bc\ud528\u6f4c\ue097\u7a60\ufc7e\u7588\u0fdb\u817d", 1648882725), fvb.fvn(Items.field_8288, a.c(-1202624810, "\u669e\u3971\u95fa\u0bf6\u8423\u0280\ub8d8\u312a\uaf0c\u25c0\ua21f\u5863\ud2a9\u4f17\uc52b\u43a4\uf994\u7646\uec8f")), false, true);
        fvb.fvm(a.d("\u26fe\u5f43\ud592\u4be5\uc077\u468e\ufcd0\u7525\ueb7f\u6190\ue659\u1c4d\u92b1\u0b0a\u811d\u07a3\ubded\u323e\ua898", -1636613435, 184837189), new ItemStack((ItemConvertible)Items.field_49813), false, true);
        fvb.fvm(a.c(-48757466, "\u0542\u7ce2\uf62c\u684b\ue38f\u657f\udf7f\u568d\uc8ca\u4276\uc5b2\u3fd4"), fvb.fvn(Items.field_8575, a.d("\uda37\u85d8\u2953\ub75f\u3889\ube5d\u047f\u8dfb\u13d4\u9d75\u1e95\ue4cf\u6a14\uf3d1\u7989", 1016128547, 1326267968)), true, true);
        fvb.fvm(a.c(-608273165, "\u7c98\u052f\u8fef\u118f\u9a08\u1cb1\ua6b9\u2f58\ub116\u3bb4\ubc76\u4657\uc8d7\u5178\udb36\u5ddb\ue7dc\u6859\uf2f6\u74aa\ufd18\u870a\u09bb\u926c\u1411\u9e85\u2775\ua926\u33c3\ub595\u3e7b"), fvb.fvo(Items.field_22021, a.c(-885893216, "\u57f1\u081e\ua495\u3a99\ub54c\u339f\u89bcB\u9e18\u14a3"), a.b("\u38e7\u417c\ucbde\u55ac\uda03\u5ca8\ue2c6\u6b1f\uf535\u7f87\uf85f\u025e\u8c8d\u1530\u9f1c\u1d82\ua3d7\u2c07\ub6ba\u309c\ub913\uc348", 1345207531)), true, true);
        fvb.fvr(a.c(-1230220475, "\u5339\u2ac9\ua04e\u3e39\ub5fd\u335d\u895e\u00e6\u9ea3\u1441\u93dc\u69ac\ue760\u7e85\uf498\u7262\uc83c\u47f1\udd4f\u5b09\ud2e5\ua8a9\u260b\ubd9f\u3bb3\ub172\u08d0\u8692\u1c74"), !ppu.picked(fvb.fvo(Items.field_22021, a.c(-1588496992, "\u75f1\u2a1e\u8695\u1899\u974c\u119f\uabbc\u2242\ubc18\u36a3"), a.c(1158358909, "\u2371\u5aea\ud048\u4e3a\uc195\u473e\uf950\u7089\ueea3\u6411\ue3c9\u19c8\u971b\u0ea6\u848a\u0614\ub841\u3791\uad2c\u2b0a\ua285\ud8de")), Set.of(a.c(1106050426, "\ufd1b\u84a1\u0e63\u900e\u1bd4\u9d72\u273a\uaed6\u3098\uba13\u3dec\uc78d\u494b\ud0e9\u5aab"))), "");
        fvb.fvr(a.d("\u55af\u2c02\ua6dc\u38a5\ub375\u358a\u8f8a\u066b\u9825\u1287\u9545\u6f64\ue1fa\u7851\uf251\u74ee\uceaa\u416a\udbc5\u5d99\ud479\uae33\u209d\ubb5d\u3d67\ub7e5\u0e46\u8006\u1ae2\u9ca2", 1943216333, 1028748556), ppu.picked(new ItemStack((ItemConvertible)Items.field_22021), Set.of(a.c(-874594990, "\ubd33\uc489\u4e4b\ud026\u5bfc\udd5a\u6712\ueefe\u70b0\ufa3b\u7dc4\u87a5\u0963\u90c1\u1a83"))), "");
        ItemStack itemStack = fvb.fvo(Items.field_8626, a.b("\u3eef\u6100\ucd8b\u5387\udc61\u5afa\ue0df\u6959", -692568388), a.b("\u35a3\u4c0c\uc6de\u58d0\ud378\u55c6\uef91\u6668\ufc2a\u7289\uf55f\u0f27\u818e\u184d\u921c\u149f\uaede\u2563\ubbce\u3d90\ub417\uce3f\u4080\udb5d\u5d2a\ud7f6", -1549127272));
        fvb.fvr(a.d("\ubc99\uc526\u4ff8\ud18b\u5a54\udcae\u6689\uef62\u7127\ufbe2\u7c78\u8613\u0897\u9164\u1b39\u9dc5\u2788\ua851\u32a5\ub4f8\u3d41\u4711\uc9b9\u523c\ud414\u5eda\ue768\u6924\uf3c2\u75d6\ufe2a\u00e6\u8afb\u135a\u9515\u1fa9\ua076\u2a00", -216373198, 974509295), ppu.picked(itemStack, Set.of(a.d("\u3f4a\u46f5\ucc2b\u5258\ud987\u5f02\ue57a\u6c91\uf2d4", -1934723647, -360166688))) && !ppu.picked(itemStack, Set.of(a.c(-1383198576, "\u10ee\u6940\ue392\u7dfe\uf638\u70b3\ucacb\u4320\udd65"), a.c(548423481, "\u474e\u3ee5\ub42c"))), "");
        fvb.fvr(a.b("\ua15f\ud8f2\u522c\ucc55\u4785\uc17a\u7b5d\uf2b6\u6cf3\ue636\u61ac\u9bc7\u1543\u8ca2\u06ed\u8011\u3a56\ub580\u2f7d\ua958\u20b5\u5afe", 927506745), ppu.picked(new ItemStack((ItemConvertible)Items.field_8626), Set.of(a.d("\u8ec7\uf76c\u7da5", -1160098614, 1384891002))) && !ppu.picked(new ItemStack((ItemConvertible)Items.field_8626), Set.of(a.b("\u624c\u1be2\u9130\u0f5c\u849a\u0211\ub869\u3182\uafc7", 325935666), a.d("\u4f36\u3689\ubc57\u2224\ua9fb\u2f7e\u9506\u1ced\u82a8", -2025542650, -326442149))), "");
        fvb.fvm(a.c(-1371588117, "\u398f\u403d\ucae2\u549b\udf57\u59ff\ue3a6\u6a5f"), fvb.fvn(Items.field_8366, a.c(-855751823, "\u433e\u1cd1\ub05a\u2e56\ua1bf\u2752\u9d7f\u14f9\u8aaaf\u87bf\u79de\uf313\u6eb8\ue0ea\u667e\udc40\u53e4\uc927\u4f7a")), true, true);
        fvb.fvm(a.b("\ue2ab\u9b0c\u11cc\u8fbb\u0464\u82d4\u38c9\ub16b\u2f2c\ua59f\u224b", 1116594884), fvb.fvo(Items.field_8407, a.d("\uc095\u9f7a\u33f1\uadfd\u221e\ua4fb\u1ed8\u9723\u0978\u83ca\u041c\ufe6c\u74a2\ue972\u635a\ue5a9\u5fe3", -1523819686, -96953467), a.b("\ub7d2\uce4e\u449b\udae0\u5133\ud7f8\u6ddc\ue034\u7e67\uf0b1\u7767\u8d6a\u03b2\u9a79\u1441\u96af\u2ce1\ua335\u39fe\ubfab\u3623\u4c08\uc2b5\u5d08\udf43\u55c6\uec05\u625e\uf8ad\u7eff\uf549\u0b99\u85cf\u185f\u9e77\u14c4\uab16", 2072753130)), true, true);
        fvb.fvm(a.c(-1393361415, "\ufd93\u8428\u0eee\u90c6\u1b5c\u9def\u27b7\uae4b\u301b\ubaa5\u3d7a\uc71c"), fvb.fvo(Items.field_8153, a.d("\u7d1e\u2255\u8e7a\u1076\u9f9d\u190e\ua357\u2aaa\ub489\u3e44\ub995\u43ee\ucd4b\u5486\udeab\u5c3a\ue26a\u6dba\uf70c\u7137\uf8d3\u82f0", -55062592, -731794797), a.d("\u77d8\u0e43\u84ef\u1a9d\u914b\u1786\ua9ca\u2421\ube64\u34da\ub340\u493b\uc7f9", 848060730, -256896261)), true, true);
        fvb.fvm(a.c(565637939, "\uf359\u8ae00\u9e49\u159f\u9325\u2938\ua08a\u3ed7\ub475\u33a6\uc9ca\u4706"), new ItemStack((ItemConvertible)Items.field_8071), true, true);
        fvb.fvm(a.d("\u620e\u1bbc\u9178\u0f16\u84c9\u0273\ub83a\u31da\uaf84\u2571\ua2e7\u588a\ud641", -431120216, -969096499), new ItemStack((ItemConvertible)Items.field_8711), true, true);
        fvb.fvr(a.d("\u8c30\uf5c0\u7f43\ue12e\u6af4\uec4d\u5619\udfa6\u41ad\ucb07\u4ccf\ub6af\u3870\ua18c\u2b96\uad7d\u1761\u98fe\u024c\u8452\u0de9\u77bd\uf909\u62d3", -1178905405, -1584473974), !ppu.known(new ItemStack((ItemConvertible)Items.field_8288)), "");
        fvb.fvr(a.b("\u9a83\ue33f\u69f7\uf780\u7c03\ufafb\u40b2\uc910\u5701\uddb1\u5a2d\ua010\u2ec2\ub774\u3d2c", -1386439960), !ppu.known(new ItemStack((ItemConvertible)Items.field_8831)), "");
        fvb.fvr(a.c(-1379258625, "\u2e84\u5774\uddf7\u439a\uc840\u4ef9\uf4ad\u7d12\ue30b\u69b9\uee6e\u140a\u9ac1\u037d\u8939\u0f9a\ub59c\u3a57\ua0b7\u26a8\uaf5e\ud540\u5bbf\uc06b\u4613\uccc9"), !ppu.known(new ItemStack((ItemConvertible)Items.field_8153)), "");
        fvb.fvr(a.d("\u9b4a\ue2e7\u6839\uf60d\u7da8\ufb3e\u416b\uc89a\u56df\udc66\u5bba\ua185\u2f1c\ub6a2\u3cfd\uba04\u000e\u8f96\u1522\u933d\u1ab8\u60ce\uee7b\u75aa\uf3cf\u7916\uc0aa", 895776694, -602608493), ppu.byId((String)a.d((String)"\uc4ff\ubd5b\u3785\ua9f1\u223c\ua493\u1ecc\u9732\u095c\u83c6\u0418\ufe62\u70a6\ue918\u6351", (int)-158138273, (int)1121240283)).name.equals(a.c(-50827258, "\u742b\u0d88\u8750\u1922\u928c\u1440\uae1f\u27e3\ubda1\u3312\ub4db\u4ed2\uc075\u59c9\ud397")), "");
    }

    private static void fvm(String string, ItemStack itemStack, boolean bl, boolean bl2) {
        boolean bl3 = ppu.picked(itemStack, Set.of(ppu.WARDEN_DEFAULTS));
        boolean bl4 = ppu.picked(itemStack, Set.of(ppu.END_DEFAULTS));
        fvb.fvr(string, bl3 == bl && bl4 == bl2, a.b("\u6ca6\u1501\u9fc1\u01a6\u8a70\u0cca\ub6ca", -383357738) + bl3 + a.c(-233890183, "\u1e5c\u67a8\ued70\u730b\uf885") + bl4);
    }

    private static ItemStack fvn(Item item, String string) {
        ItemStack itemStack = new ItemStack((ItemConvertible)item);
        itemStack.method_57379(DataComponentTypes.field_49631, (Object)Text.method_43470((String)string));
        return itemStack;
    }

    private static ItemStack fvo(Item item, String string, String string2) {
        ItemStack itemStack = fvb.fvn(item, string);
        itemStack.method_57379(DataComponentTypes.field_49632, (Object)new LoreComponent(List.of(Text.method_43470((String)string2))));
        return itemStack;
    }

    private static void fvp() {
        Object object = new Object();
        Object object2 = new Object();
        Object object3 = new Object();
        Object object4 = new Object();
        Object object5 = new Object();
        fvb.fvr(a.c(-821206589, "\u61f4\u1807\u92d3\u0cf6\u8768\u01de"), pjd.enter(object, a.c(449629999, "\ucf4b\ub6f5\u3c7a\ua20a\u29d6")), "");
        fvb.fvr(a.b("\ude7e\ua793\u2d4a\ub37f\u38e1\ube57", 251780682), pjd.enter(object2, a.c(-723595278, "\ucfdb\ub624\u3cf8\ua2d5\u2903\uafb9")), "");
        fvb.fvr(a.c(-409328469, "\u249e\u5d6e\ud7ab\u499e\uc200\u44b6"), pjd.enter(object3, a.c(-612345464, "\u59b9\u2009\uaad1")), "");
        fvb.fvr(a.b("\ubdbb\uc44a\u4e85\ud0bc\u5b3c\udd9b\u67c0\uee2c\u7074", -1312309882), !pjd.enter(object4, a.b("\u3a2d\u4393\uc91c\u576c\udcb0", -1496040887)), "");
        fvb.fvr(a.d("\u36b0\u4f41\uc58e\u5bb7\ud029\u5682\uec82\u6535\ufb65\u71cf\uf61d\u0c6b\u82e8\u1b10\u9144\u17fb\uadf8\u222c\ub898\u3ec2", 613815792, -1604443296), pjd.position(object4) == 1, String.valueOf(pjd.position(object4)));
        fvb.fvr(a.d("\u6de3\u1413\u9edc\u00e5\u8b65\u0dc2\ub799\u3e75\ua02d\u2acf\uad5e\u5728\ud9f2\u4042\uca16\u4ced\uf6e6\u797e\ue3d0", 713278384, 1481354869), !pjd.enter(object5, a.d("\u4ed1\u376f\ubde0\u2390\ua84c", -1112946602, -78215453)) && pjd.position(object5) == 2, "");
        fvb.fvr(a.b("\uee87\u9739\u1deb\u8381\u084a\u8ef6\u34b2\ubd11\u230f\ua9b1\u2e6d\ud40f\u5ac9\uc373\u4931\ucf99\u759f\ufa54\u60b4\ue6a3\u6f40\u1506\u9bb5", -302715151), pjd.hasRoom(a.d("\u1682\u6f3c\ue5b3\u7bc3\uf01e", -768327130, -676506432), object5), "");
        fvb.fvr(a.b("\u107d\u69cd\ue315\u7d21\uf6ba\u7002\uca55\u43b3\uddff\u5758\ud0d8\u2aef\ua431\u3d9d\ub79c\u3139\u8b6a\u04b6\u9e40\u185d\u91a9\uebf8\u6550", 83169285), pjd.enter(object, a.c(-1441462124, "\u08f0\u714e\ufbc1\u65b1\uee6c")), "");
        fvb.fvr(a.b("\ud8dd\ua170\u2bae\ub59a\u3e58\ub8a8\u02e7\u8b5e\u1552\u9fe4\u182a\ue25e\u6c89\uf574\u7f70\uf997\u43d0\ucc1c\u56a8\ud0aa\u5955\u2358\uadf7\u362b\ub011\u3ad4\u8327\u0d6a\u97d5\u11d3\u9a76\u64b5\ueea9\u771e\uf142\u7be8\uc43e\u4e48\uc8c6", 1663031438), !pjd.enter(object5, a.b("\u4803\u31bd\ubb32\u2542\uae9e", -1650702233)), "");
        fvb.fvr(a.d("\ub161\uc8cc\u4212\udc26\u57e5\ud114\u6b5b\ue2e2\u7cfa\uf643\u719a\u8bfd\u0579\u9c81\u16d5", -1397053933, 1635391241), pjd.enter(object4, a.c(-764753887, "\uc845\ub1fb\u3b74\ua504\u2ed8")), "");
        fvb.fvr(a.c(-472222224, "\u7597\u0c3a\u86e4\u18d0\u9312\u15e2\uafad\u2614\ub802\u32a9\ub529\u4f16\uc1ca\u5866\ud239\u549c\uee9d\u614d\ufbe6"), pjd.position(object5) == 1, String.valueOf(pjd.position(object5)));
        pjd.leave(object2);
        fvb.fvr(a.d("\u7cb2\u051f\u8fc1\u11f5\u9a37\u1cc7\ua688\u2f31\ub129\u3b90\ubc49\u462e\uc8aa\u5152\udb06\u5db9\ue7b7\u6861\uf2c0\u7480\ufd60\u8763\u0991\u9201\u1432\u9ee0\u275b\ua940\u33f5\ub5ad\u3e1e", 6992128, -150090279), pjd.enter(object5, a.d("\u2236\u5b88\ud107\u4f77\uc4ab", -412624489, -1325532219)), "");
        fvb.fvr(a.d("\ue4da\u9d77\u17be\u89d8\u020f\u84fb\u3efc\ub711\u2943\ua3e5\u2421", -111416696, -223736275), pjd.count(a.c(-1335151233, "\u351b\u4ca5\uc62a\u585a\ud386"), null) == 3, String.valueOf(pjd.count(a.c(-1967262715, "\uf461\u8ddf\u0750\u9920\u12fc"), null)));
        for (Object object6 : new Object[]{object, object2, object3, object4, object5}) {
            pjd.leave(object6);
        }
        fvb.fvr(a.b("\ua63b\udf87\u555d\ucb39\u40ef\uc61a\u7c01\uf5f7\u6bb7\ue156\u66d5\u9cb5\u1271\u8bc1\u0184\u8774", -1246124449), a.c(1432350839, "\uf046\u89f6\u032e").equals(pnr.anarchy(a.b("\ue111\u98af\u1232\u8c51\u0787\u813d", 1370481014))) && a.d("\u79a3\u0013\u8acb", 88447192, -986914486).equals(pnr.anarchy(a.d("\u5eca\u2715\uadc9\u33c4\ub812\u3ea8", -283733531, -1693462778))), "");
        fvb.fvr(a.d("\u6bf9\u1253\u989c\u06e0\u8d20\u0bc3\ub1d3\u382e\ua673\u2cc2\uab1d\u5163\udfbe\u464b\ucc51\u4aba\uf0a6\u7f39\ue58b\u6395\uea2a\u907c\u1ed0", -182273133, 1339412498), pnr.anarchy(a.d("\uc97a\ub0cc\u3a1d\ua464", -709315761, -1728087463)) == null && pnr.anarchy(a.d("\u7d24\u049c\u8e07\u1064\u9bb2\u1d08", 112504933, -1120547546)) == null, "");
        fvb.fvr(a.c(1670257366, "\u1ab7\u631e\ue9d4\u77eb\ufc7d\u7ace\uc09d\u4960\ud725\u5d8f\uda46\u2063\uaefd\u374b"), pnr.allow(a.d("\ub2a4\ucb1a\u4195\udfe5\u5439", 1178038860, -759775092)), "");
        fvb.fvr(a.b("\u10f9\u694b\ue380\u7dbe\uf62b\u7097\ucadf\u4329\udd25\u57de\ud008\u2a7f\ua4af\u3d50\ub74a\u31a6", 883429533), pjd.enter(object, a.b("\u0399\u7a27\uf0a8\u6ed8\ue504", -1681587203)) && pjd.enter(object2, a.d("\u2904\u50ba\uda35\u4445\ucf99", 575934141, -962254883)), "");
        fvb.fvr(a.d("\u6ef2\u1702\u9dc2\u03f2\u8833\u0ec6\ub4d7\u3d2b\ua36f\u298a\uae0e\u5469\udab6\u431a\uc94e\u4fec\uf5e1\u7a37\ue089\u66d9\uef29\u9572\u1b85\u8000\u0663\u8cbf\u3549\ubb57\u21b8\ua7f0\u2c0d\ud29d\u58d0\uc121\u477e\ucdd5\u7219\uf872", -525093227, -271460320), !pjd.enter(object3, a.d("\u7fd1\u066f\u8ce0\u1290\u994c", -356192282, -1772318637)), "");
        pjd.leave(object);
        pjd.leave(object2);
        pjd.enter(object, a.b("\ua748\udef6\u5479\uca0e\u41dd", -1366907092));
        pjd.enter(object2, a.c(2116194217, "\u8fcd\uf673\u7cfc\ue28b\u6958"));
        pjd.enter(object3, a.b("\uff12\u86ac\u0c23\u9254\u1987", -92405898));
        fvb.fvr(a.c(1354888291, "\uf43a\u8d93\u0759\u9966\u12f0\u9443\u2e10\ua7ed\u39a8\ub302\u34cb\ucee9\u406a\ud988\u538f\ud573\u6f35\ue0f1\u7a43\ufc56\u75e9\u0fbf\u8113\u1a92\u9cb9\u1673\uaf8f\u219f\ubb29\u3d3e\ub69e\u4856\uc219\u5ba4\uddb6\u5708\ue8d0\u62b2\ue470\u7dca\uf784\u892c\u0336\u849d\u1e19\u9020\u29fe\ua346\u2501\ube94\u30a5\uca77\u43c2\uc59b"), !pnr.allow(a.d("\u1672\u6fcc\ue543\u7b34\uf0e7", -529951476, -789871846)), "");
        fvb.fvr(a.b("\u5124\u2898\ua242\u3c2a\ub7fa\u3142\u8b56\u02ee\u9cac\u1649\u91db\u6bac\ue57d\u7cc4\uf690\u702f\uca23\u45f0\udf4c\u5910\ud0e1\uaab9\u2415\ubf97\u39bc\ub371\u0acf\u84db\u1e7b\u983c\u1387\ued4b", 1494241648), !pnr.allow(a.c(-1673381854, "\u3846\u41f8\ucb77\u5500\uded3")) && pjd.position(pjd.MAIN) == 0, "");
        for (Object object6 : new Object[]{object, object2, object3, pjd.MAIN}) {
            pjd.leave(object6);
        }
    }

    private static void fvq(kfx kfx2) {
        wap.set(wam.RU);
        int n2 = 0;
        for (kfe kfe2 : kfx2.getModules()) {
            String string = wap.t(kfe2.getDescription());
            boolean bl = string.chars().anyMatch(n -> n >= 1024 && n <= 1279);
            if (bl) continue;
            ++n2;
            System.out.println(a.d("\u2284\u5b32\ud1f2\u4f9c\uc406\u42e3\uf8a1\u7146\uef1e\u65e1\ue228\u1817\u96c1\u0f3f\u851e\u03c8\ub981\u3650\uacf9\u2aa0\ua358\ud947\u57b0\ucc60\u4a09\uc0c8\u796a\uf720\u6dce\ueb9b\u6035\u9ee2\u14ac\u8d13\u0b06\u81be\u3e74\ub457", -28806999, -2116595091) + kfe2.getName() + a.b("\uec3b\u9590", 893578243) + string);
        }
        fvb.fvr(a.b("\ufc89\u852b\u0feb\u918d\u1a51\u9cb9\u26a7\uaf54\u3100\ubba0\u3c6a\uc612\u4880\ud175\u5b27\uddc0\u679f\ue85f\u72f7\uf4ad\u7d5d\u070d\u89fa\u1262\u941a\u1e85\ua744\u2932\ub3c3\u3592\ube3b\u40e2\ucaa2", 269941965), n2 == 0, n2 + a.c(445628220, "\ubf17\uc6ef\u4c3b\ud204\u59b6\udf2c\u6576\uec8c\u72d6\uf87d\u7fb5"));
    }

    private static void fvr(String string, boolean bl, String string2) {
        if (!bl) {
            ++fvc;
        }
        System.out.println(a.d("\ub2a9\ucb1f\u41df\udfb1\u542b\ud2ce\u688c\ue16b\u7f33\uf5d6", -1988455556, 1892360633) + (bl ? a.c(-156007812, "\u8229\ufb89\u7148\uef39\u649d") : a.d("\u6bea\u125c\u9887\u06f3\u8d48", 1067866807, -1804717794)) + string + (bl || string2.isEmpty() ? "" : a.c(-907926006, "\u2628\u5f91") + string2 + a.c(395055268, "\u108c")));
    }

    private static void fvs(MinecraftClient minecraftClient, vlj vlj2) throws Exception {
        fvb.fvk(minecraftClient, a.b("\u5b54\u22d9\ua807\u366e\ubda5\u3b03", 1179540226));
        Method method = hlc.class.getDeclaredMethod(a.b("\u8253\ufbfd\u713b\uef41\u64a8\ue220\u5879\ud180\u4fd1\uc577", -2008448458), vlj.class);
        method.setAccessible(true);
        method.invoke((Object)minecraftClient.field_1755, vlj2);
    }

    private static void fvt(Screen screen, String string) {
        if (screen != null) {
            for (char c : string.toCharArray()) {
                screen.method_25400(new CharInput((int)c, 0));
            }
        }
    }

    private static void fvu(MinecraftClient minecraftClient, String string) {
        minecraftClient.method_1562().method_45730(string);
    }

    private static void fvv(MinecraftClient minecraftClient, String string) {
        System.out.println(a.d("\uec53\u95f4\u1f2e\u8155\u0ac4\u8c21\u3663\ubf84\u21dc\uab39", -1513393298, 2127535940) + string + a.c(-1309758798, "\uaa91\ud340\u59f3") + minecraftClient.method_47599() + a.d("\u25a3\u5c54\ud691\u48e3", 820680132, -1706774461));
        ScreenshotRecorder.method_22690((File)minecraftClient.field_1697, (String)(a.c(-1820769666, "\u421e\u3ba5\ub175\u2f1c\ua48e\u2220") + string + a.b("\u6b39\u12d6\u981b\u0663", 1241148179)), (Framebuffer)minecraftClient.method_1522(), (int)1, text -> System.out.println("" + text.getString()));
    }

    private static /* synthetic */ int ri(int n, int n2) {
        return n ^ n2 ^ 0x1E9BD093;
    }

    private static /* synthetic */ int rj(int n, int n2) {
        return n - n2 | 0x9336326D;
    }

    private static /* synthetic */ int rk(int n, int n2) {
        return fvb.rj(n, n2) + n;
    }
}

