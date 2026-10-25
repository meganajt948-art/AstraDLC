/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.network.OtherClientPlayerEntity
 *  net.minecraft.client.util.ScreenshotRecorder
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Entity$RemovalReason
 *  net.minecraft.entity.EquipmentSlot
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
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;

final class hdj {
    private static final String[] hdk = new String[]{a.b("\u61c7\u1848\u9299\u0ce8\u8724\u0189", 1309303186), a.d("\u7569\u0cff\u8639\u185d\u9397\u152c", -1636847984, -1280910420), a.b("\u95ec\uec76\u66bd\uf8d5", 1901172140), a.c(1216785013, "\uaa21\ud3af\u5978\uc707"), a.c(314991719, "\u643c\u1dbb\u9761\u091a\u82e9\u047b\ube2a\u37d3"), a.d("\uffb4\u8626\u0cf1\u9292\u1942", 607229871, 1605593176), a.b("\uf8be\u8134\u0bca\u9598\u1e4d\u98f4", -663553812), a.c(1683305060, "\u3223\u4bbc\uc16c\u5f11\ud4ce"), a.b("\u38af\u4134\ucbfe\u5594\ude4f\u58f5", 79247592), a.b("\u01d0\u7851\uf295\u6ce0\ue73d", -1825242729), a.d("\u481b\u319b\ubb47\u253c\uaeea\u284c", 138220016, -1947051587), a.d("\ufeca\u8744\u0d9a\u93e4\u1829", -1017444188, 1637086776)};
    private static Entity hdl;
    private static /* synthetic */ boolean hdm;
    private static /* synthetic */ long hdn;

    private hdj() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) {
        int n2;
        kfx kfx2 = Flow.getInstance().getModuleManager();
        if (n == 1) {
            hdj.hdr(minecraftClient, a.d("\u50ac\u291b\ua3c4\u3dbd\ub662\u30d1\u8a89\u0379\u9d63\u1791\u9053\u6a35\ue4e6\u7d42\uf70c\u71e2\ucbbe", 819305885, -668938937));
            hdj.hdr(minecraftClient, a.d("\ud5c3\uac6f\u26b8\ub8c1\u3353\ub5b1\u0ff4\u8614\u181f\u92b8\u156d\uef1c\u61cb", -716155402, 261390412));
            hdj.hdr(minecraftClient, a.c(-632811462, "\u1040\u69e3\ue334\u7d50\uf69b\u7027\uca63\u43c0\udddc\u5762\ud0b8\u2acd\ua409"));
            izx.TARGET.enabled.set(false);
        }
        if (n == 6) {
            hdj.hdq(minecraftClient, 0.0f, 6.0f);
            hdl = hdj.hdo(minecraftClient, a.b("\u3b27\u42b9\uc86d\u5600\uddd0", -838714523), 3.0);
            kfx2.getByName(a.d("\u8a73\uf3f9\u792d\ue744\u6cad\uea3b\u5070\ud99e\u47db\ucd70\u4aa8\ub0d7\u3e09", 516418130, -1419485057)).setEnabled(true);
        }
        if (n == 16) {
            hdj.hds(minecraftClient, a.b("\u1322\u6a97\ue05a\u7e2c\uf5f2\u7309\uc91e\u40e8\udeaf\u5401\ud3c8\u29a3\ua77f\u3ec0\ub49a\u3223\u8820\u07e2\u9d4e\u1b1d\u92f0\ue8a6", -358083769));
        }
        if (n == 18) {
            kfx2.getByName(a.c(1960988967, "\u5179\u28f3\ua227\u3c4e\ub7a7\u3131\u8b7a\u0294\u9cd1\u167a\u91a2\u6bdd\ue503")).setEnabled(false);
            minecraftClient.field_1687.method_2945(hdl.method_5628(), Entity.RemovalReason.field_26999);
            minecraftClient.field_1724.method_31548().method_61496(0);
            minecraftClient.field_1724.method_31548().method_5447(0, new ItemStack((ItemConvertible)Items.field_8802));
            kfx2.getByName(a.c(1310351504, "\u60cc\u1959\u9394\u0de2\u863c\u00ab\ubad7\u3321\uad7a\u27c7\ua001\u5a6d\ud4bc\u4d0c\uc742")).setEnabled(true);
        }
        if (n == 22) {
            hdj.hds(minecraftClient, a.c(1647135115, "\u49f2\u3047\uba8a\u24fc\uaf22\u29d9\u93d5\u1a33\u847a\u0ecc"));
        }
        for (n2 = 0; n2 < hdk.length; ++n2) {
            int n3 = 26 + n2 * 14;
            if (n == n3) {
                ((vlv)hdj.hdp(kfx2.getByName(a.b("\u1aba\u632f\ue9e2\u7794\ufc4a\u7add\uc0a1\u4957\ud70c\u5db1\uda77\u201b\uaeca\u377a\ubd34", 1090919142)), a.d("\ud30c\uaa9f\u2047\ube37", 1042341301, 2102464240))).set(hdk[n2]);
                continue;
            }
            if (n == n3 + 2) {
                minecraftClient.field_1724.method_6104(Hand.field_5808);
                continue;
            }
            if (n != n3 + 5) continue;
            hdj.hds(minecraftClient, a.d("\ue437\u9d82\u174f\u8939\u02e7\u841c", -328261857, -1850606755) + hdk[n2].toLowerCase());
        }
        n2 = 26 + hdk.length * 14 + 30;
        if (n == n2 - 28) {
            minecraftClient.field_1724.method_31548().method_5447(0, new ItemStack((ItemConvertible)Items.field_49814));
        }
        if (n == n2 - 2) {
            hdj.hds(minecraftClient, a.c(1319480217, "\uabe5\ud250\u589d\uc6eb\u4d35\ucbce\u71dd\uf820\u667d\uecca\u6b51\u917f\u1fbf\u8618\u0c4c"));
        }
        if (n == n2) {
            hdj.hdr(minecraftClient, a.d("\uc797\ube20\u34ff\uaa86\u2159\ua7ea\u1db2\u9442\u0a58\u80ba\u076f\ufd19\u73ca\uea64\u6028\ue6ce\u5c8c", 1873316609, -510112544));
            hdj.hdr(minecraftClient, a.d("\ue918\u90aa\u1a79\u840b\u0fda\u897c\u337b\ubacd\u249c\uae32\u29f2\ud3c6\u5d71\uc4f3\u4ef3\uc84f\u7204\ufdd2\u676a\ue13d\u68db\u1299\u9c2d\u07ee\u81df\u0b46\ub2e2\u3ca5\ua648\u2003\uabb7\u5573\udf33\u46cf\uc09a\u4a6e\uf5aa\u7fd8\uf91b\u60bb\ueae5\u9404\u1e03\u99b4\u0364\u8d05", 1941496049, -1330706014));
            hdj.hdr(minecraftClient, a.b("\uc976\ub0c3\u3a40\ua451\u2fb5\ua957\u135a\u9af5\u04f4\u8e0a\u09dc\uf3b9\u7d30", 2079639823));
        }
        if (n == n2 + 22) {
            hdj.hds(minecraftClient, a.b("\u69b3\u1006\u9acb\u04bd\u8f63\u0998\ub38b\u3a76\ua42b\u2e9c\ua907\u5338\udde4\u445c\uce1c\u48f8\uf2b5", -579900975));
        }
        if (n == n2 + 60) {
            hdj.hdr(minecraftClient, a.b("\u06b4\u7f03\uf5dc\u6ba5\ue07a\u66c9\udc91\u5561\ucb7b\u4189\uc64b\u3c2d\ub2fe\u2b5a\ua114\u27fa\u9da6", -1445853502));
            kfx2.getByName(a.b("\ub5fb\ucc6e\u46a3\ud8d5\u530b\ud59c\u6fe0\ue616\u784d\uf2f0\u7536\u8f5a\u018b\u983b\u1275", -1569868377)).setEnabled(false);
            System.out.println(a.b("\u742b\u0d9e\u8753\u1925\u92fb\u140d\uae0a\u27ea\ub9a3\u3315\ub492\u4ea7\uc07b\u59cb\ud393", 53113943));
            return true;
        }
        return false;
    }

    private static Entity hdo(MinecraftClient minecraftClient, String string, double d) {
        OtherClientPlayerEntity otherClientPlayerEntity = new OtherClientPlayerEntity(minecraftClient.field_1687, new GameProfile(UUID.randomUUID(), string));
        Vec3d vec3d = minecraftClient.field_1724.method_73189().method_1031(0.0, 0.0, d);
        otherClientPlayerEntity.method_5808(vec3d.field_1352, minecraftClient.field_1724.method_23318(), vec3d.field_1350, 180.0f, 0.0f);
        otherClientPlayerEntity.method_5636(180.0f);
        otherClientPlayerEntity.method_5847(180.0f);
        otherClientPlayerEntity.field_6220 = 180.0f;
        otherClientPlayerEntity.field_6259 = 180.0f;
        otherClientPlayerEntity.method_5673(EquipmentSlot.field_6169, new ItemStack((ItemConvertible)Items.field_8805));
        otherClientPlayerEntity.method_5673(EquipmentSlot.field_6174, new ItemStack((ItemConvertible)Items.field_8058));
        otherClientPlayerEntity.method_5673(EquipmentSlot.field_6172, new ItemStack((ItemConvertible)Items.field_8348));
        otherClientPlayerEntity.method_5673(EquipmentSlot.field_6166, new ItemStack((ItemConvertible)Items.field_8285));
        otherClientPlayerEntity.method_5673(EquipmentSlot.field_6173, new ItemStack((ItemConvertible)Items.field_22022));
        otherClientPlayerEntity.method_5648(true);
        minecraftClient.field_1687.method_53875((Entity)otherClientPlayerEntity);
        return otherClientPlayerEntity;
    }

    private static vmo hdp(kfe kfe2, String string) {
        for (vmo vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            return vmo2;
        }
        throw new IllegalStateException(kfe2.getName() + a.d("\uc9dc\ub025\u3aff\ua49c\u2f18\ua9e7\u13b5\u9a0b", 1095687915, -1256384737) + string);
    }

    private static void hdq(MinecraftClient minecraftClient, float f, float f2) {
        minecraftClient.field_1724.method_36456(f);
        minecraftClient.field_1724.method_36457(f2);
        minecraftClient.field_1724.field_5982 = f;
        minecraftClient.field_1724.field_6004 = f2;
    }

    private static void hdr(MinecraftClient minecraftClient, String string) {
        minecraftClient.method_1562().method_45730(string);
    }

    private static void hds(MinecraftClient minecraftClient, String string) {
        System.out.println(a.c(-136605166, "\u926b\uebcc\u6116\uff6d\u74fc\uf219\u485b\uc1bc\u5fe4\ud501") + string);
        ScreenshotRecorder.method_22690((File)minecraftClient.field_1697, (String)(a.c(954352280, "\u42f8\u3b43\ub193\u2ffa\ua468\u22c6") + string + a.d("\u519a\u2875\ua2b8\u3cc0", -1991321152, -537884560)), (Framebuffer)minecraftClient.method_1522(), (int)1, text -> System.out.println("" + text.getString()));
    }

    private static /* synthetic */ int yx(int n, int n2) {
        return (n ^ n2) + -1577085075;
    }

    private static /* synthetic */ int yy(int n, int n2) {
        return hdj.yx(n, n2) * n2;
    }

    private static /* synthetic */ int yz(int n, int n2) {
        return n + n2 | 0x3EAB6485;
    }
}

