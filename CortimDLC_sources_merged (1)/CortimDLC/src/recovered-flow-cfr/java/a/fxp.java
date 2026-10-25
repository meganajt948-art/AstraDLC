/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.network.OtherClientPlayerEntity
 *  net.minecraft.client.option.Perspective
 *  net.minecraft.client.util.ScreenshotRecorder
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Entity$RemovalReason
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.util.Hand
 *  net.minecraft.util.math.Vec3d
 */
package a;

import a.izx;
import a.kfe;
import a.kfx;
import a.rrx;
import a.vkl;
import a.vlv;
import a.vmo;
import com.mojang.authlib.GameProfile;
import flow.Flow;
import flow.dev.a;
import java.io.File;
import java.util.UUID;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.option.Perspective;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;

final class fxp {
    private static final int fxq = 40;
    private static final int fxr = 120;
    private static final int fxs = 200;
    private static final int fxt = 280;
    private static final int fxu = 360;
    private static OtherClientPlayerEntity fxv;
    private static int fxw;
    private static /* synthetic */ long fxx;
    private static /* synthetic */ boolean fxy;

    private fxp() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) {
        kfx kfx2 = Flow.getInstance().getModuleManager();
        kfe kfe2 = kfx2.getByName(a.b("\ub533\uccbe\u4677\ud81f\u53e1\ud546\u6f16", -2097236633));
        if (n == 1) {
            fxp.fyg(minecraftClient, a.b("\uf380\u8a37\u00e8\u9e91\u154e\u93fd\u29a5\ua055\u3e4f\ub4bd\u337f\uc919\u47ca\ude6e\u5420\ud2ce\u6892", 1738470390));
            fxp.fyg(minecraftClient, a.b("\u9f6b\ue6c7\u6c10\uf269\u79fb\uff19\u455c\uccbc\u52b7\ud810\u5fc5\ua5b4\u2b63", 1007001362));
            fxp.fyg(minecraftClient, a.c(1002655668, "\u4fce\u366d\ubcba\u22de\ua915\u2fa9\u95ed\u1c4e\u8252\u08ec\u8f36\u7543\ufb87"));
            fxp.fyg(minecraftClient, a.c(2059212729, "\u17cc\u6e7f\ue4a9\u7ad8\uf143\u7792\ucde4\u442b\uda5b\u50e7\ud73d\u2d59\ua3d6\u3a37\ub060\u3696\u8cd2\u0305\u99a7\u1fe5\u9615\uec56\u62ab\uf93a\u7f50\uf583\u4c3f\uc265\u589e\udef7"));
            fxp.fyg(minecraftClient, a.d("\u2112\u58ac\ud27a\u4c0b\uc790\u417f\ufb7f\u7296\uecdc\u6633\ue1be\u1b91\u9500\u0ca9\u86a4\u001e\uba44\u35cb\uaf33\u2977\ua0de\udac9\u5462\ucffe\u4985\uc353\u7aeb\uf4bc\u6e5a\ue818\u63ac\u9d6f\u176e\u8ed6\u0882\u8228\u3dfe\ub784\u316d\ua8e1\u22ae\u5c44\ud61d\u51a4\ucb6b", -2038915320, -1933132207));
            fxp.fyg(minecraftClient, a.b("\uc420\ubd9e\u3748\ua939\u22a2\ua44d\u1e4d\u97a5\u09ee\u8301\u049d\ufefd\u7074\ue983\u63c8\ue567\u5f7b\ud0b4\u4a14\ucc1b\u45a1\u3fe3\ub10e\u2a99\uacfe\u2662\u9fd5\u1183\u8b7f\u0d28\u868a\u7848\uf200\u6be3\uedfe\u6707\ud8c7\u52b7\ud45f\u4dc6\uc781\ub970\u3320", -741161875));
            fxp.fyg(minecraftClient, a.c(-1161171553, "\uedd3\u946d\u1ebb\u80ca\u0b51\u8dbe\u37a0\ube42\u2043\uaabd\u2d7f\ud750\u59c1\uc068\u4a65\uccde\u7685\uf90a\u63f4\ue5b6\u6c1f\u1608\u98a3\u033f\u8544\u0f92\ub62a\u387d\ua29b\u24d9\uaf6d\u51ae\udbaf\u4206\uc45b\u4ef3\uf134\u7b7f\ufd84\u642d\uee72\u9080"));
            fxp.fyg(minecraftClient, a.d("\u0cc6\u7578\uffae\u61df\uea44\u6cab\ud6ab\u5f46\uc108\u4be7\ucc78\u361b\ub892\u2165\uab2e\u2d81\u9781\u1841\u82ac\u04b1\u8d54\uf75b\u79ae\ue267\u6455\uee80\u5734\ud96e\u439f\uc5df\u4e7f\ub0a9\u3af4\ua34b\u2545\uafff\u102b\u9a42\u1c95\u8523\u0f67\u7197\ufbcf", -1276858182, 1699068977));
            minecraftClient.options.setPerspective(Perspective.FIRST_PERSON);
            izx.TARGET.enabled.set(false);
            fxp.fyd(kfe2, a.d("\u06cf\u7f59\uf587\u6be3\ue03d", 1073549776, -1348921527), a.d("\u9e77\ue7ed\u6d33\uf350\u7887", -1888879784, 1472423277));
            fxp.fyd(kfe2, a.b("\u1ef0\u6778\ueda7\u73d0\uf801\u7ea6", 1969692326), a.c(1151542322, "\u2467\u5ded\ud737\u4955\uc294\u4432"));
            ((vkl)fxp.fye(kfe2, a.c(1187056185, "\u0a79\u73e9\uf938\u675c\uecd2\u6a2e\ud069\u59c1\uc7ca\u4d6e\ucaae\u30ca\ube1f\u27bf\uadeb"))).set(false);
            ((vkl)fxp.fye(kfe2, a.c(21345384, "\ub421\ucdb2\u476c\ud90c"))).set(true);
            kfe2.setEnabled(true);
        }
        if (n == 20) {
            fxp.fyf(minecraftClient, 0.0f, 12.0f);
        }
        if (n >= 40 && n < 280) {
            fxp.fyf(minecraftClient, 0.0f, 12.0f);
        }
        if (n == 34) {
            fxv = fxp.fyb(minecraftClient, a.d("\u6dcd\u1443\u9e9a\u00fc\u8b36\u0d83", -1956033962, -728487989), 3.6);
        }
        if (n == 38 && fxv != null) {
            fxv.swingHand(Hand.MAIN_HAND);
        }
        if (n == 40) {
            fxp.fya(fxv, false);
        }
        fxp.fxz(minecraftClient, n, 40, a.b("\u345b\u4de8\uc73e\u594f", -720554956), new int[]{4, 10, 18, 27, 33, 44});
        if (n == 62) {
            fxp.fyc(minecraftClient, (Entity)fxv);
        }
        if (n == 114) {
            fxv = fxp.fyb(minecraftClient, a.d("\u25ed\u5c67\ud6af\u48cf\uc310", -1442629553, -1582883341), 3.6);
        }
        if (n == 120) {
            fxp.fya(fxv, true);
        }
        fxp.fxz(minecraftClient, n, 120, a.c(1899136404, "\u85e5\ufc4f\u7687\ue8e7\u6338"), new int[]{6, 18, 28, 40});
        if (n == 176) {
            fxp.fyc(minecraftClient, (Entity)fxv);
        }
        if (n == 192) {
            fxp.fyd(kfe2, a.c(-1565606375, "\ube4f\uc7c7\u4d18\ud36f\u58be\ude19"), a.d("\u8110\uf897\u7253\uec25\u67e4", 777564224, -634965738));
            fxv = fxp.fyb(minecraftClient, a.d("\u55c5\u2c42\ua686\u38f0\ub331", 234749729, 653830818), 3.6);
        }
        if (n == 200) {
            fxp.fya(fxv, false);
        }
        fxp.fxz(minecraftClient, n, 200, a.b("\uf5c0\u8c67\u06a3\u98d5\u1314", 618460582), new int[]{18, 27, 33, 44});
        if (n == 222) {
            fxp.fyc(minecraftClient, (Entity)fxv);
        }
        if (n == 270) {
            fxp.fyd(kfe2, a.b("\u452a\u3ca2\ub67d\u280a\ua3db\u257c", -577223300), a.b("\u68ca\u1140\u9b9a\u05f8\u8e39\u089f", -1195808609));
            fxp.fyf(minecraftClient, 0.0f, 8.0f);
            fxp.fyg(minecraftClient, a.c(-475689322, "\u8ea0\uf717\u7ddc\ue3ad\u6878\ueec8\u54d5\udd69\u4332\uc984\u4e5c\ub42b\u3aed\ua34f\u291b\uaff8\u15f9\u9a68\u00ce\u869d\u0f65\u753f\ufb80\u6014\ue635\u6cba\ud557\u5b58\uc1f1\u47ea\ucc4d\u32c7\ub8bd\u216d\ua710\u2da9\u920d\u1877\u9ef7\u0708\u8d28\uf3e3\u79b5\ufe0d\u64d1\ueaba\u5327\ud99d\u5f81\uc41e\u4a13\ub0ff\u3953\ubf17\u25f1\uabbd\u1004\u96d4\u1cf3\u8543\u0b9e\u71c6\uf63d\u7c3a\ue2bf\u6b12\ud117\u57dd\uddaa"));
        }
        if (n == 280) {
            fxp.fyg(minecraftClient, a.b("\u26ce\u5f7d\ud5ab\u4bda\uc041\u4690\ufce6\u7529\ueb59\u61e5\ue63f\u1c5b\u92d4\u0b35\u8162\u0794\ubdd0\u3207\ua8a5\u2ee7\ua717\udd54\u53a9\uc838\u4e52\uc481\u7d3d\uf367\u699c\ueff5", 1750345403));
        }
        fxp.fxz(minecraftClient, n, 280, a.b("\u8a54\uf3f0\u7921\ue75f\u6c83\uea3e", 727091752), new int[]{8, 20, 28, 36});
        if (rrx.activeGlass() > 0) {
            ++fxw;
        }
        if (n >= 360) {
            kfe2.setEnabled(false);
            fxp.fyd(kfe2, a.d("\ufbf5\u8263\u08bd\u96d9\u1d07", 2078330447, -359975444), a.d("\u821f\ufb81\u715b\uef28\u64f6", -205464936, 1829460163));
            fxp.fyg(minecraftClient, a.c(-1474666347, "\u60d7\u1969\u93bf\u0dce\u8655\u00ba\ubaba\u3353\uad19\u27f6\ua07b\u5a54\ud4c5\u4d6c\uc761\u41db\ufb81\u740e\ueef6\u68b2\ue11b\u9b0c\u15a7\u8e3b\u0840\u8296\u3b2e\ub579\u2f9f\ua9dd\u2269\udcaa\u56ab\ucf01\u495a\uc3f0"));
            izx.TARGET.enabled.set(true);
            System.out.println(a.b("\uc4f5\ubd4f\u3791\ua9f2\u2225\ua4c7\u1ec0\u9720\u0969\u83df\u0458", 687850649) + (fxw > 100 ? a.c(-1828161181, "\u7937\u0097\u8a56\u1427") : a.b("\u9116\ue8a0\u627b\ufc0f", -476933804)) + a.d("\u8a9e\uf327\u79bb\ue7c1\u6c1b\ueab8\u50eb\ud949\u4745\ucde2\u4a31\ub04b\u3ed2", 905027743, -836556244) + fxw + a.c(1792759892, "\u5873\u2196\uab58\u3523\ubefc\u3855\u825c"));
            return true;
        }
        return false;
    }

    private static void fxz(MinecraftClient minecraftClient, int n, int n2, String string, int[] nArray) {
        for (int n3 : nArray) {
            if (n != n2 + n3) continue;
            fxp.fyh(minecraftClient, a.c(121960390, "\uf7a7\u8e1d\u04c3\u9aa0\u1177\u9798") + string + a.c(616281542, "\ub5ea") + String.format(a.c(-440113776, "\u65b1\u1c15\u96c4\u08e3"), n3));
        }
    }

    private static void fya(OtherClientPlayerEntity otherClientPlayerEntity, boolean bl) {
        if (otherClientPlayerEntity == null) {
            return;
        }
        rrx.onAttack((Entity)otherClientPlayerEntity);
        rrx.trigger((LivingEntity)otherClientPlayerEntity, bl);
        if (!bl) {
            otherClientPlayerEntity.setHealth(0.0f);
        }
    }

    private static OtherClientPlayerEntity fyb(MinecraftClient minecraftClient, String string, double d) {
        OtherClientPlayerEntity otherClientPlayerEntity = new OtherClientPlayerEntity(minecraftClient.world, new GameProfile(UUID.randomUUID(), string));
        Vec3d vec3d = minecraftClient.player.getEntityPos().add(0.0, 0.0, d);
        otherClientPlayerEntity.refreshPositionAndAngles(vec3d.x, minecraftClient.player.getY(), vec3d.z, 160.0f, 0.0f);
        otherClientPlayerEntity.setBodyYaw(160.0f);
        otherClientPlayerEntity.setHeadYaw(170.0f);
        otherClientPlayerEntity.lastBodyYaw = 160.0f;
        otherClientPlayerEntity.lastHeadYaw = 170.0f;
        otherClientPlayerEntity.equipStack(EquipmentSlot.CHEST, new ItemStack((ItemConvertible)Items.DIAMOND_CHESTPLATE));
        otherClientPlayerEntity.equipStack(EquipmentSlot.MAINHAND, new ItemStack((ItemConvertible)Items.NETHERITE_SWORD));
        minecraftClient.world.addEntity((Entity)otherClientPlayerEntity);
        return otherClientPlayerEntity;
    }

    private static void fyc(MinecraftClient minecraftClient, Entity entity) {
        if (entity != null && minecraftClient.world.getEntityById(entity.getId()) != null) {
            minecraftClient.world.removeEntity(entity.getId(), Entity.RemovalReason.DISCARDED);
        }
    }

    private static void fyd(kfe kfe2, String string, String string2) {
        ((vlv)fxp.fye(kfe2, string)).set(string2);
    }

    private static vmo fye(kfe kfe2, String string) {
        for (vmo vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            return vmo2;
        }
        throw new IllegalStateException(kfe2.getName() + a.d("\ue85a\u91a3\u1b79\u851a\u0e9e\u8861\u3233\ubb8d", -2056775358, -1550520016) + string);
    }

    private static void fyf(MinecraftClient minecraftClient, float f, float f2) {
        minecraftClient.player.setYaw(f);
        minecraftClient.player.setPitch(f2);
        minecraftClient.player.lastYaw = f;
        minecraftClient.player.lastPitch = f2;
    }

    private static void fyg(MinecraftClient minecraftClient, String string) {
        minecraftClient.getNetworkHandler().sendChatCommand(string);
    }

    private static void fyh(MinecraftClient minecraftClient, String string) {
        System.out.println(a.c(-129992095, "\u7a18\u03bf\u8965\u171e\u9c8f\u1a6a\ua028\u29cf\ub797\u3d72") + string + a.b("\u741f\u0dce\u877d", -861309892) + minecraftClient.getCurrentFps() + a.c(1440106112, "\u46a4\u3f53\ub596\u2be4"));
        ScreenshotRecorder.saveScreenshot((File)minecraftClient.runDirectory, (String)(a.d("\u03d4\u7a6f\uf0bf\u6ed6\ue544\u63ea", 1691498866, 1212037830) + string + a.d("\uea83\u936c\u19a1\u87d9", 439445360, -1020031527)), (Framebuffer)minecraftClient.getFramebuffer(), (int)1, text -> System.out.println("" + text.getString()));
    }

    private static /* synthetic */ int sc(int n, int n2) {
        return n + n2 ^ 0x140EC34F;
    }

    private static /* synthetic */ int sd(int n, int n2) {
        return fxp.sc(n, n2) + n;
    }
}

