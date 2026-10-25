/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.fabricmc.fabric.api.event.player.AttackEntityCallback
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.option.KeyBinding
 *  net.minecraft.client.util.InputUtil$Key
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.mob.HuskEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.Items
 *  net.minecraft.util.ActionResult
 *  net.minecraft.util.Hand
 *  net.minecraft.util.hit.EntityHitResult
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.world.World
 */
package a;

import a.gaq;
import a.kfe;
import a.kmy;
import a.lmn;
import a.lnb;
import a.vxr;
import flow.Flow;
import flow.dev.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HuskEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

final class gax {
    private static final int gay = 40;
    private static final int gaz = 24;
    private static final int gba = 140;
    private static final List<gaq> gbb = new ArrayList<gaq>();
    private static final Field gbc = vxr.find(ClientPlayerEntity.class, a.c(-1274661362, "\u3677\u4fcd\uc50f\u5b24\ud0b0\u5605\uec51\u65ab\ufbf2\u7152\uf692\u0ce4\u8221\u1bca\u91d4\u172a\uad68\u22ab\ub818\u3e65\ub7fa\ucda8\u4319"), a.d("\u6c2e\u1590\u9f4f\u0137\u8ae8\u0c62\ub65d\u3fa6\ua1f4\u2b40", 665238109, -1623730657), a.b("\ubc1d", 1812118618));
    private static final Field gbd = vxr.find(ClientPlayerEntity.class, a.d("\u1e03\u67b9\ued7b\u7350\uf8c4\u7e71\uc425\u4ddf\ud386\u5926\udee6\u2490\uaa55\u33be\ub9a0\u3f5e\u851c\u0adf\u906c\u1611\u9f8e\ue5dc\u6b6d", -1022138324, -978356650), a.c(-489357927, "\ufdf5\u844b\u0e94\u90ec\u1b33\u9db9\u2786\uae7d\u3029\uba9f"), a.d("\u880f", 866256624, -1860202824));
    private static final double gbe = 25.0;
    private static final double gbf = 45.0;
    private static final double gbg = 10.0;
    private static final double gbh = 10.0;
    private static final double[] gbi = new double[256];
    private static final double[] gbj = new double[256];
    private static final double[] gbk = new double[256];
    private static float gbl = Float.NaN;
    private static float gbm;
    private static int gbn;
    private static int gbo;
    private static final int[] gbp;
    private static final int[] gbq;
    private static final int[] gbr;
    private static final double[] gbs;
    private static final boolean[] gbt;
    private static final boolean[] gbu;
    private static final double[] gbv;
    private static final double[] gbw;
    private static final int[] gbx;
    private static final int[] gby;
    private static volatile int gbz;
    private static volatile int gca;
    private static boolean gcb;
    private static int gcc;
    private static double gcd;
    private static double gce;
    private static double gcf;
    private static int gcg;
    private static int gch;
    private static int gci;
    private static int gcj;
    private static float gck;
    private static float gcl;
    private static float gcm;
    private static float gcn;
    private static double gco;
    private static boolean gcp;
    private static boolean gcq;
    private static boolean gcr;
    private static final List<Double> gcs;
    private static final lnb gct;
    private static final lmn gcu;
    private static final Random gcv;
    private static /* synthetic */ boolean gcw;
    private static /* synthetic */ String gcx;

    private gax() {
    }

    static boolean tick(MinecraftClient minecraftClient) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        gax.gde();
        if (++gcc == 1) {
            gax.gcy();
            int n = MathHelper.method_15357((double)clientPlayerEntity.method_23317());
            int n2 = MathHelper.method_15357((double)clientPlayerEntity.method_23318());
            int n3 = MathHelper.method_15357((double)clientPlayerEntity.method_23321());
            gcd = (double)n + 4.5;
            gce = n2;
            gcf = (double)n3 + 0.5;
            gax.gdg(minecraftClient, a.d("\ubc4c\uc5fb\u4f24\ud15d\u5a82\udc31\u6669\uef99\u7183\ufb61\u7cb4\u86c2\u0811\u91bf\u1bf3\u9d15\u2757", -1552956524, 2093973422));
            gax.gdg(minecraftClient, a.b("\u24e8\u5d44\ud793\u49ea\uc278\u449a\ufedf\u773f\ue934\u63c1\ue417\u1e7e", -1149492080));
            gax.gdg(minecraftClient, a.c(1660717034, "\u87ab\ufe19\u74ca\ueab8\u6169\ue7cf\u5dc8\ud47e\u4a2f\uc081\u4741\ubd75\u33c2\uaa40\u2040\ua6e3\u1cbb\u937c\u09d5\u8f9e\u066e\u7c2a\uf296\u694a\uef33\u65a7\udc0d\u5255\uc8a2\u4ee3\uc544\u3b81\ub19a\u286d\uae39\u2498"));
            gax.gdg(minecraftClient, a.b("\uee81\u9733\u1de0\u8392\u0843\u8ee5\u34e2\ubd54\u2305\ua9ab\u2e6b\ud45f\u5ae8\uc36a\u496a\ucfc8\u7595\ufa51\u60e3\ue6b5\u6f51\u1515\u9bbbl\u8612\u0c8d\ub527\u3b7f\ua188\u27c9\uac6e\u52ab\ud8b0\u4147\uc713\u4db2", 1691086528));
            gax.gdg(minecraftClient, a.b("\u9282\ueb3c\u61e6\uff93\u7457\uf2b4\u4887\uc145", -294743319));
            gax.gdg(minecraftClient, a.d("\ucc1c\ub5af\u3f79\ua108\u2a93\uac42\u1634\u9ffb\u018b\u8b37\u0ced\uf689\u7806\ue1ab\u6ba9\ued44\u5706\ud8cf\u4260\uc426\u4dfe", 1151680984, -1641509446));
            gax.gdg(minecraftClient, System.getenv(a.c(1307863766, "\u6a9e\u1325\u99f5\u079c\u8c2e\u0af2\ub0b3\u394e\ua713\u2da4\uaa6d\u500a\udeda\u4773")) != null ? a.b("\uca40\ub3ec\u392e\ua757\u2ccd\uaa2e\u106a\u998e\u07cd\u8d71\u0aa0\uf0d7\u7e45\ue7b1\u6de9\ueb02\u5150\ude9c\u4422\uc22a\u4bbd\u31df\ubf3f\u24a7\ua2df\u2816\u91b6\u1fec\u8501\u034b\u88e5\u763f\ufc27\u65c8\ue38b\u696d\ud6a4\u5cc8\uda07\u43fe\uc9ec\ub719\u3d4d\ubaf7\u2026\uae46\u1786\u9d30\u1b6d\u80f2\u0ed6\uf40b\u7dbe\ufbe9", -584267233) : a.b("\u6ecd\u1761\u9da3\u03da\u8840\u0ea3\ub4e7\u3d03\ua340\u29fc\uae2d\u545a\udac8\u433c\uc964\u4f8f\uf5dd\u7a11\ue0af\u66a7\uef30\u9552\u1bb2\u802b\u0653\u8c99\u353c\ubb6e\u218a\ua787\u2c2a\ud2eb\u58f3\uc11c\u4752\ucdff\u7260\uf85c\u7e8b\ue73d\u6d69\u139e\u99dc\u1e7e\u84ae\u0acd\ub350\u39b6\ubff5\u2426\uaa53", 1203793559));
            gax.gdg(minecraftClient, a.d("\u9a0e\ue3a2\u6960\uf719\u7c83\ufa60\u4024\uc9c0\u5783\udd3f\u5aee\ua099\u2e0b\ub7ff\u3da7\ubb4c\u011e\u8ed2\u146c\u9264\u1bf3\u6191\uef71\u74e8\uf290\u785a\uc1ff\u4fad\ud549\u5344\ud8e8\u2628\uac30\u35df\ub391\u393c\u86a3\u0c9f\u8a48\u13fe\u99aa\ue75d\u6d1f\ueabd\u706d\ufe0e\u4793\ucd7c\u4b3e\ud0e7\u5e98\ua44b\u2dfd\uaba6\u316e\ubf13\u04a8\u8261\u080f\u91c8", -253393274, 876027101));
            gax.gdg(minecraftClient, String.format(Locale.ROOT, a.c(-1336177453, "\u8cbf\uf50a\u7f89\ue198\u6a7c\uec9e\u56c8\udf32\u4172\ucb94\u4c01\ub675\u38e3\ua116\u2b40\uadba\u17ea\u986c\u0299\u84c5\u0d26\u777e\uf9dd\u621c"), (double)n + 0.5, n2, (double)n3 + 0.5));
            gax.gdg(minecraftClient, String.format(Locale.ROOT, a.d("\u4122\u3895\ub25e\u2c2f\ua7fa\u214a\u9b57\u12eb\u8cb0\u0606\u81de\u7ba9\uf56f\u6ccd\ue699\u607a\uda7b\u55f8\ucf56\u4901\uc0ee\ubaf4\u3442\uaf98\u29fb\ua37e\u1a8b\u94df\u0e69\u887c\u03ca\ufd10\u7743\ueee6\u68f3\ue219\u5dfb\ud7ab\u5156\uc8ef\u42c3\u3c39\ub639\u31c6\uab6e\u2525\u9cf3\u164b\u900f\u0bc4\u85f9\u7f23\uf6c7\u70d8\uea57\u6433\udf9b\u594b\ud322\u4ae9\uc459\ube19\u39e1\ub3bd\u2d74\ua4f2\u1e96\u9873\u1220\u8d8d\u0745\u8123\u78fd\uf212\u6c4a\ue7e8\u61f1\udb0d\u52cb\uccba\u4673\uc039\ubb81\u3547\uaf31\u26f1\ua054\u1a4c\u95d2\u0fa3\u8902\u00de\ufaf7\u743e\uefc2\u6997\ue35f\u5d25\ud4f0\u4e50\uc814\u43e2\u3da3\ub75c\u2ed4\ua8a9\u2263\u9df5\u1795\u9169\u0b3e\u8282\u7c55\uf618\u71a1\uebfe\u6507\udcd5\u56b4\ud073\u4b93\uc5c9\ubf3b\u3968\ub0d9\u2a12\ua47f\u1fe3\u998c\u134c\u8afb\u04a7\ufe74\u79c8\uf383\u6d6e\ue763\u5ed9\ud80b\u5278\ucda9\u474a\uc102", -1308396412, 109720922), gcd, n2, gcf));
            gax.gdg(minecraftClient, a.d("\u42f6\u3b44\ub197\u2fe5\ua434\u2292\u9895\u1123\u8f72\u05dc\u821c\u7828\uf69f\u6f0b\ue566\u63b8\ud9fa\u5622\ucc84\u4a8d\uc32a\ub97f\u37cb\uac11\u2a68\ua0a8\u1908\u975e\u0dbb\u8ba4E\ufe89\u74c0\ued29\u6b4c\ue180\u5e05\ud463\u52a6\ucb0d\u4148\u3fbe\ub5f8\u3246\ua89c\u26eb\u9f7d\u1585\u93cd\u0814\u8668\u7cbe\uf50e\u7342\ue9a0\u67b4\udc18\u5ada\ud0fd\u492a\uc79a\ubddb", -956233788, -1948367511));
            clientPlayerEntity.method_31548().method_61496(1);
            return false;
        }
        if (gcc == 30) {
            for (Entity entity : minecraftClient.field_1687.method_18112()) {
                if (!(entity instanceof HuskEntity)) continue;
                gca = entity.method_5628();
                gcd = entity.method_23317();
                gce = entity.method_23318();
                gcf = entity.method_23321();
            }
            if (gca < 0) {
                System.out.println(a.c(1195040937, "\ue0d2\u9977\u13a5\u8dcf\u061a\u80a7\u3af6\ub301\u2d1b\ua7fe\u203c\uda5b\u548b\ucd6e\u475b\uc1ad\u7bea\uf43e\u6ee1\ue8fe\u6108\u1b16\u95ed\u0e21\u8858\u0291"));
                return true;
            }
            gax.gdf(a.b("\u6724\u1eb3\u947b\u0a04\u81d3\u0760\ubd24\u34e5\uaa97\u203d", -1939380358));
            gax.gdf(a.d("\uec6d\u95f4\u1f23\u817e\u0a9b\u8c2a\u3663\ubf88\u21d0", 631584224, 1476843973));
            gax.gdf(a.d("\ue366\u9ae3\u1031\u8e5b\u05b0\u8322\u3973\ub099\u2ec1\ua46a", -338757580, -708699367));
            return false;
        }
        if (gcc < 40) {
            return false;
        }
        gct.update(clientPlayerEntity);
        if (minecraftClient.field_1729.method_1613()) {
            minecraftClient.field_1729.method_1610();
        }
        if (gcg < 0 || gch == 3) {
            if (++gcg >= gbb.size()) {
                return gax.gdb();
            }
            gax.gcz(minecraftClient, clientPlayerEntity, gbb.get(gcg));
            return false;
        }
        gax.gda(minecraftClient, clientPlayerEntity, gbb.get(gcg));
        return false;
    }

    private static void gcy() {
        String string = System.getenv(a.c(1402896268, "\u7fc5\u067e\u8cae\u12c7\u9975\u1fa9\ua5e8\u2c15\ub248\u38ff\ubf36\u4557\ucb81\u5232\ud874"));
        if (string == null || string.contains(a.d("\u59fe\u204b\uaa8a\u34fb\ubf39", -1649138588, 1874099692))) {
            for (int i = 1; i <= 4; ++i) {
                for (int j = 0; j < 3; ++j) {
                    gbb.add(new gaq(a.c(583375262, "\u99e8\ue05d\u6a9c\uf4ed\u7f2f"), 8.0, 0.15, i));
                }
            }
        }
        double[] dArray = new double[]{6.0, 9.0, 13.0, 20.0};
        double[] dArray2 = new double[]{0.3, 1.5, 2.3};
        if (string == null || string.contains(a.b("\u778d\u0e33\u84e5\u1a98\u9144\u17ef", 1613723624))) {
            for (double d : dArray) {
                for (double d2 : dArray2) {
                    gbb.add(new gaq(a.d("\u1b07\u62b9\ue86f\u7612\ufdce\u7b65", 1778768718, -1663975380), d, d2, 0));
                }
            }
        }
        if (string == null || string.contains(a.c(2019133105, "\u86c4\uff6f\u75b9\uebc1\u601d\ue6b6"))) {
            for (double d : dArray) {
                for (double d2 : dArray2) {
                    gbb.add(new gaq(a.c(-1980040361, "\ufb22\u8289\u085f\u9627\u1dfb\u9b50"), d, d2, 0));
                }
            }
        }
        if (string == null || string.contains(a.b("\u7ac4\u0377\u89bd\u17d3\u9c03\u1abb", 1920301743))) {
            for (int i = 0; i < 8; ++i) {
                gbb.add(new gaq(a.b("\u089f\u712c\ufbe6\u6588\uee58\u68e0", 887752948), 12.0, 0.0, 0));
            }
        }
        if (string == null || string.contains(a.c(1019759958, "\u4d31\u3497\ube43\u2033\uabe3"))) {
            gbb.add(new gaq(a.b("\ued44\u94e2\u1e36\u8046\u0b96", 651554083), 12.0, 0.4, 0));
        }
        if (string == null || string.contains(a.b("\u80f7\uf959\u7389\uede0", -464617344))) {
            for (double d : new double[]{9.0, 13.0, 20.0}) {
                for (double d2 : dArray2) {
                    gbb.add(new gaq(a.d("\u0399\u7a37\uf0e7\u6e8e", -182661321, 1978059993), d, d2, 0));
                }
            }
        }
        if (string == null || string.contains(a.c(678014557, "\uae33\ud78f\u5d50\uc32f\u48f7\uce5a"))) {
            for (double d : new double[]{6.0, 9.0, 13.0, 20.0}) {
                for (double d2 : new double[]{0.3, 1.5}) {
                    gbb.add(new gaq(a.c(901603260, "\u5fd2\u266e\uacb1\u32ce\ub916\u3fbb"), d, d2, 0));
                }
            }
        }
    }

    private static void gcz(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, gaq gaq2) {
        boolean bl = gaq2.phase().equals(a.d("\u5413\u2da6\ua767\u3916\ub2d4", -553690804, 1237519657));
        kfe kfe2 = Flow.getInstance().getModuleManager().getByName(a.d("\uc042\ub9c7\u3315\uad7f\u268a\ua017\u1a46\u93b1", -691619115, -1359119650));
        gax.gdd(kfe2, gaq2.phase().equals(a.c(56380044, "\u4af9\u3352\ub984\u27fc\uac20\u2a8b")) || gaq2.phase().equals(a.d("\u6f04\u16aa\u9c7a\u0213", -197957066, 266601797)), gaq2.phase().equals(a.d("\u76a9\u0f07\u85d7\u1bbe", 1226154320, -1036200050)), gaq2.phase().equals(a.d("\ufd7a\u84c6\u0e19\u9066\u1bbe\u9d13", 1993216269, -1765610471)) ? 10.0 : 1.5);
        kfe2.setEnabled(!bl);
        if (gaq2.phase().equals(a.d("\u6530\u1c96\u9642\u0832\u83e2", 311657617, 1640292806))) {
            gax.gdg(minecraftClient, a.c(-577265585, "\ua07a\ud9d6\u5314\ucd6d\u46f7\uc014\u7a50\uf3b4\u6df7\ue74b\u609a\u9aed\u147f\u8d8b\u07d3\u8138\u3b6a\ub4a6\u2e18\ua810\u2187\u5be5\ud505\u4e9c\uc8e4\u422e\ufb8b\u75d9\uef3d\u6930\ue29d\u1c5c\u9644\u0fab\u89e5\u0348\ubcd7\u36eb\ub03c\u298a\ua3de\udd29\u576b\ud0c9\u4a19\uc47a\u7de7\uf701\u7142\uea91\u64e4\u9e0b\u1782\u91d8\u0b26\u857c\u3eca\ub814\u327d\uabb5\u250a\u5f50\ud8b9\u52ef\ucc6e\u4599\uff93\u792d\uf37e\u6cc8\ue610\u6067\u99a9\u130b\u8d5f\u06bc\u80a5\u3a59\ub394\u2de2\ua727\u214d\u5ac3\ud405\u4e75\uc7a5\u4111\ufb16\u74f1\ueea9\u6854\ue1a5"));
        }
        clientPlayerEntity.method_31548().method_61496(bl ? 0 : 1);
        double d = gcv.nextDouble() * Math.PI * 2.0;
        double d2 = gcd + Math.cos(d) * gaq2.offset();
        double d3 = gcf + Math.sin(d) * gaq2.offset();
        gck = bl ? 0.0f : (float)Math.round(gcv.nextDouble() * 3600.0 - 1800.0) / 10.0f;
        gcl = bl ? 90.0f : -90.0f;
        gax.gdg(minecraftClient, String.format(Locale.ROOT, a.d("\u5b98\u222d\ua8ae\u36bf\ubd5b\u3bb9\u81ef\u0815\u9657\u1cb3\u9b26\u6152\uef8e\u7622\ufc24\u7a93\uc0d9\u4f03\ud5ad\u53a9\uda18\ua04c\u2ef4\ub53a\u3312\ub9853\u8e69\u1481\u9287", -1121577348, -1570222706), d2, gce + gaq2.height(), d3, Float.valueOf(gck), Float.valueOf(gcl)));
        gbz = gcg;
        gch = 0;
        gci = 0;
        gcj = 0;
        gcq = false;
        gcr = false;
        gcp = true;
        gax.gbv[gax.gcg] = 0.0;
        gax.gbw[gax.gcg] = 0.0;
        gbl = Float.NaN;
    }

    private static void gda(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, gaq gaq2) {
        boolean bl;
        ++gci;
        if (gaq2.phase().equals(a.d("\u2278\u5bcb\ud101\u4f6f\uc4bf\u4207", 713464405, -679167930))) {
            gax.gdg(minecraftClient, String.format(Locale.ROOT, a.c(1034511288, "\u63e5\u1a50\u90d3\u0ec2\u8530\u03bf\ub9c3\u303f\uae69\u24cd\ua346\u5967\ud7b4\u4e02\uc45a\u42ad\uf8f3\u7731\ued85\u6bc6\ue27f\u987c\u16d2\u8d05\u0b62\u8185\u384b\ub61f\u2ce3\uaaaf\u2149\udfde\u5594\ucc6e\u4a20\uc0c4\u7f55\uf521\u73f9\uea55\u605f"), gcd + Math.cos(gco += 0.1388888888888889) * 1.8, gce, gcf + Math.sin(gco) * 1.8));
        }
        if (gch == 0) {
            if (clientPlayerEntity.method_23318() > gce + gaq2.height() - 0.5 || gci > 20) {
                gch = 1;
                gci = 0;
                gcm = clientPlayerEntity.method_36454();
                gcn = clientPlayerEntity.method_36455();
            }
            return;
        }
        boolean bl2 = clientPlayerEntity.method_24828();
        if (!bl2) {
            gcq = true;
        }
        float f = gax.gdc(gbc, clientPlayerEntity);
        float f2 = gax.gdc(gbd, clientPlayerEntity);
        int n = kmy.strikes();
        gbo = n != gbn ? 0 : gbo + 1;
        gbn = n;
        if (!Float.isNaN(gbl) && gci > 2 && gaq2.sweep() == 0) {
            double d = Math.sqrt(MathHelper.method_27285((float)MathHelper.method_15393((float)(f - gbl))) + MathHelper.method_27285((float)(f2 - gbm)));
            gax.gbi[gax.gcg] = Math.max(gbi[gcg], d);
            if (gbo == 0) {
                gax.gbj[gax.gcg] = Math.max(gbj[gcg], d);
            } else if (gbo == 1) {
                gax.gbk[gax.gcg] = Math.max(gbk[gcg], d);
            }
        }
        gbl = f;
        gbm = f2;
        if (bl2 && !gcp && gcq) {
            int n2 = gcg;
            gby[n2] = gby[n2] + 1;
        }
        gcp = bl2;
        float f3 = clientPlayerEntity.method_36454();
        float f4 = clientPlayerEntity.method_36455();
        double d = MathHelper.method_15393((float)(f3 - gck));
        double d2 = f4 - gcl;
        double d3 = Math.sqrt(d * d + d2 * d2);
        if (gaq2.phase().equals(a.c(1458140965, "\u7750\u0efb\u842d\u1a55\u9189\u1722"))) {
            gax.gbw[gax.gcg] = Math.max(gbw[gcg], d3);
            if (!bl2 && System.getenv(a.b("\u115b\u68e0\ue230\u7c59\uf7eb\u7137\ucb76\u428b\udcd6\u5661\ud1a8\u2bd2\ua503\u3ca1\ub6f0\u3007", 797118733)) != null) {
                System.out.println(String.format(Locale.ROOT, a.d("\u34d1\u4d74\uc7a6\u59cc\ud219\u54a4\ueef5\u6702\uf918\u73fd\uf428\u0e4a\u809f\u1928\u933e\u158b\uafd2\u201e\ubab2\u3cae\ub541\ucf51\u41a6\uda23\u5c15\ud6dc\u6f2e\ue13b\u7b9f\ufdd8\u7660\u88ab\u02ad\u9b44\u1d1c\u97b2\u2832\ua20a\u24d3\ubd69\u3729\u498f\uc39a\u4477\udefc\u5088\ue90d", -204931405, -1388983764), gcg, gci, Float.valueOf(f), Float.valueOf(f2), kmy.debug()));
            }
        } else if (!gaq2.phase().equals(a.b("\u41bd\u3808\ub2c9\u2cb8\ua77a", -1508032053))) {
            double d4;
            gax.gbv[gax.gcg] = Math.max(gbv[gcg], d3);
            if (d3 > 0.5) {
                int n3 = gcg;
                gbx[n3] = gbx[n3] + 1;
            }
            if ((d4 = Math.sqrt(MathHelper.method_27285((float)MathHelper.method_15393((float)(f3 - gcm))) + MathHelper.method_27285((float)(f4 - gcn)))) > 2.0) {
                gcs.add(d4);
            }
            if (d4 > 0.5 && System.getenv(a.d("\u6975\u10ce\u9a1e\u0477\u8fc5\u0919\ub358\u3aa5\ua4f8\u2e4f\ua986\u53fc\udd2d\u448f\ucede\u4829", -1813186387, -2118086258)) != null) {
                System.out.println(String.format(Locale.ROOT, a.d("\u9830\ue195\u6b47\uf52d\u7ef8\uf845\u4214\ucbe3\u55f9\udf1c\u58c9\ua2ab\u2c7e\ub5c9\u3fdf\ub96a\u0333\u8cff\u1653\u904f\u19a0\u63b0\ued47\u76c2\uf0f4\u7a3d\uc3cf\u4dda\ud774\u513d\uda98\u2403\uae54\u37ae\ub1e2\u3b04\u8495\u0eb4\u887e\u11d2\u9b9a\ue560\u6f66\ue8cf\u7213\ufc7d\u45f9\ucf0e\u4912\ud2c4\u5ca6\ua662\u2f98\ua9d1\u3329\ubd67\u068f\u8018\u0a2c\u93e8\u1d42\u6709\ue0e1\u6aba\uf42c\u7d85\uc780\u4122\ucb29\u54c4\ude12\u5835", -1926042877, -1517849830), gcg, gci, Float.valueOf(f3), Float.valueOf(f4), d4, bl2, kmy.debug()));
            }
        }
        gcm = f3;
        gcn = f4;
        if (gaq2.sweep() > 0) {
            gcu.predict(clientPlayerEntity, (World)minecraftClient.field_1687, gct.get());
            if (!bl2 && !gcr && gcu.landing() == gaq2.sweep()) {
                gcr = true;
                KeyBinding.method_1420((InputUtil.Key)KeyBindingHelper.getBoundKeyOf((KeyBinding)minecraftClient.field_1690.field_1886));
            }
        }
        boolean bl3 = gaq2.phase().equals(a.c(-1360991899, "\ue902\u90a4\u1a70\u8400\u0fd0")) ? gci > 420 : (bl = gcq && bl2);
        gcj = bl ? ++gcj : 0;
        if (gcj > 24 || gci > (gaq2.phase().equals(a.c(-72865706, "\u2831\u5197\udb43\u4533\ucee3")) ? 440 : 140)) {
            gax.gbt[gax.gcg] = d3 < 1.5;
            gax.gbu[gax.gcg] = clientPlayerEntity.method_31548().method_67532() == (gaq2.sweep() > 0 ? 0 : 1);
            System.out.println(String.format(Locale.ROOT, a.c(-2125728045, "\uf601\u8fa4\u0576\u9b1c\u10c9\u9674\u2c25\ua5d2\u3bc8\ub13d\u36f8\ucc94\u425c\udbbd\u51eb\ud75b\u6d50\ue284\u7861\ufe63\u77dc\u0dd8\u8373\u18a9\u9ec8\u144f\uadba\u23a4\ub95a\u3f0b\ub4e3\u4a2a\uc06e\u5980\udf84\u5573\ueaf7\u6082\ue643\u7ff2\uf5b8\u8b04\u014f\u86bf\u1c36\u925d\u2bcf\ua16b\u2724\ubce0\u3291\uc848\u41e7\uc7f8\u5d13\ud303\u68f8\uee7a\u6417\ufdca\u736f\u0925\u8e83\u04ca\u9a44\u13b1\ua9a1\u2f41\ua50d\u3aa1\ub03b\u3652\ucfcc\u4539\udb2c\u50da\ud680\u6c31\ue5b3\u7bda\uf11e\u7753\u0cb4\u8223\u1806\u91c0\u1762\uad32\u22ca\ub887\u3e3f\ub7ef\u4dc1\uc308\u58ed\udeef\u5473\uea1d\u63cd\uf967\u7f79\uf490\u8a95w\u99e5\u1f98\u9552\u2ad4\ua0aa\u265b\ubc53\u35fa\ucb3e\u4170\uc6d4\u5cc3\ud235\u6bf2\ue197\u675e\ufca5\u72ec\u085e\u8e4b\u07bf\u9d6c\u1313\ua892\u2ec5\ua47f\u3db0\ub395\u4904\ucef9\u44a7\uda59\u500c\ue9b0\u6f64\ue51c\u7adf\uf020\u766b\u0fdb\u85d0\u1b52\u90f7\u16ad\uac40\u2258\ubbf3\u3129\ub749\u4ccf\uc23a\u582a\ud1c8\u5786\ued63\u62aa\uf8ee\u7e00\uf404\u8df3\u0365\u9913\u1ed2\u9472\u2a3a\ua384\u39cf\ubf75\u34bd\uca9b\u400e\ud9e3\u5ff0\ud524\u6b01"), gcg, gaq2.phase(), gaq2.height(), gaq2.offset(), gaq2.sweep(), gbp[gcg], gbq[gcg], gbr[gcg], gbs[gcg], gbt[gcg], gbu[gcg], gbv[gcg], gbx[gcg], gbw[gcg], gby[gcg], gbi[gcg], gbj[gcg], gbk[gcg], kmy.debug()));
            gbz = -1;
            gch = 3;
        }
    }

    /*
     * Exception decompiling
     */
    private static boolean gdb() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$TooOptimisticMatchException
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.getString(SwitchStringRewriter.java:404)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.access$600(SwitchStringRewriter.java:53)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$SwitchStringMatchResultCollector.collectMatches(SwitchStringRewriter.java:368)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.KleeneN.match(KleeneN.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.MatchSequence.match(MatchSequence.java:26)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:23)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewriteComplex(SwitchStringRewriter.java:201)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewrite(SwitchStringRewriter.java:73)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:881)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private static float gdc(Field field, ClientPlayerEntity clientPlayerEntity) {
        try {
            return field.getFloat(clientPlayerEntity);
        }
        catch (ReflectiveOperationException | RuntimeException exception) {
            return 0.0f;
        }
    }

    /*
     * Exception decompiling
     */
    private static void gdd(kfe var0, boolean var1_1, boolean var2_2, double var3_3) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$TooOptimisticMatchException
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.getString(SwitchStringRewriter.java:404)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.access$600(SwitchStringRewriter.java:53)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$SwitchStringMatchResultCollector.collectMatches(SwitchStringRewriter.java:368)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.KleeneN.match(KleeneN.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.MatchSequence.match(MatchSequence.java:26)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:23)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewriteComplex(SwitchStringRewriter.java:201)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewrite(SwitchStringRewriter.java:73)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:881)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private static void gde() {
        if (gcb) {
            return;
        }
        gcb = true;
        AttackEntityCallback.EVENT.register(gax::lambda$hook$0);
    }

    private static void gdf(String string) {
        kfe kfe2 = Flow.getInstance().getModuleManager().getByName(string);
        if (kfe2 != null) {
            kfe2.setEnabled(false);
        }
    }

    private static void gdg(MinecraftClient minecraftClient, String string) {
        minecraftClient.method_1562().method_45730(string);
    }

    /*
     * Unable to fully structure code
     */
    private static /* synthetic */ ActionResult lambda$hook$0(PlayerEntity var0, World var1_1, Hand var2_2, Entity var3_3, EntityHitResult var4_4) {
        var5_5 = gax.gbz;
        if (var1_1.method_8608() || var5_5 < 0 || var3_3.method_5628() != gax.gca) {
            return ActionResult.field_5811;
        }
        var6_6 = var0.method_7261(0.5f);
        var7_7 = var6_6 > 0.9f && var0.field_6017 > 0.0 && var0.method_24828() == false && var0.method_5624() == false;
        v0 = var8_8 = var0.method_6047().method_31574(Items.field_49814) != false && var0.field_6017 > 1.5 && var0.method_6128() == false;
        if (!(var3_3 instanceof LivingEntity)) ** GOTO lbl-1000
        var10_9 = (LivingEntity)var3_3;
        if (var10_9.field_6008 > 10) {
            v1 = true;
        } else lbl-1000:
        // 2 sources

        {
            v1 = false;
        }
        var9_10 = v1;
        v2 = var5_5;
        gax.gbp[v2] = gax.gbp[v2] + 1;
        if (var8_8) {
            v3 = var5_5;
            gax.gbq[v3] = gax.gbq[v3] + 1;
        }
        if (var7_7) {
            v4 = var5_5;
            gax.gbr[v4] = gax.gbr[v4] + 1;
        }
        gax.gbs[var5_5] = var0.field_6017;
        System.out.println(String.format(Locale.ROOT, a.d("\u0bdc\u7279\uf8ab\u66c1\ued14\u6ba9\ud1f8\u580f\uc615\u4cf7\ucb32\u3154\ubf87\u2625\uac61\u2ac2\u90cc\u1f08\u85bb\u03ff\u8a0a\uf053\u7eab\ue53e\u6357\ue99b\u5037\ude2b\u44c4\uc2d4\u4923\ub7ab\u3da0\ua449\u2211\ua8bc\u173f\u9d08\u1b9d\u822b\u0879\u7688\ufc8a\u7b23\ue1ff\u6f92\ud615\u5ce2\udaea\u412e\ucf40\u358b\ubc27\u3a7c\ua0d6\u2e9f\u9576\u13f4\u99c4\u001e\u8ea0\uf4e2\u7304\uf957\u67c0\uee69\u5431\ud2dc\u58df\uc728\u4da8\ucbc7\u3214\ub8b7\u26ff\uad5b\u2b14\u91f3\u1873\u8641\u0c9f\u8ad5\uf17b\u7fe3\ue58c\u6c0b\ueaeb\u50f3\udf03\u4546\uc3e6\u4a3b\ub044\u3e83\ua57e\u2337\ua9ae", 1329275695, -645060365), new Object[]{var5_5, var0.method_23318() - gax.gce, var0.field_6017, var0.method_24828(), Float.valueOf(var6_6), var8_8, var7_7, var9_10}));
        return ActionResult.field_5811;
    }

    static {
        gbo = 99;
        gbp = new int[256];
        gbq = new int[256];
        gbr = new int[256];
        gbs = new double[256];
        gbt = new boolean[256];
        gbu = new boolean[256];
        gbv = new double[256];
        gbw = new double[256];
        gbx = new int[256];
        gby = new int[256];
        gbz = -1;
        gca = -1;
        gcg = -1;
        gcs = new ArrayList<Double>();
        gct = new lnb();
        gcu = new lmn();
        gcv = new Random(11L);
    }

    private static /* synthetic */ int tc(int n, int n2) {
        return n * n2 + 2060365132;
    }

    private static /* synthetic */ int td(int n, int n2) {
        return gax.tc(n, n2) * n2;
    }
}

