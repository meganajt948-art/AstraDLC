/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.network.OtherClientPlayerEntity
 *  net.minecraft.client.option.InactivityFpsLimit
 *  net.minecraft.client.util.ScreenshotRecorder
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Entity$RemovalReason
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.util.math.Vec3d
 */
package a;

import a.hhf;
import a.kfe;
import a.kfx;
import a.ruv;
import a.ukl;
import com.mojang.authlib.GameProfile;
import flow.Flow;
import flow.dev.a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.option.InactivityFpsLimit;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.Vec3d;

final class grw {
    private static final String[] grx = new String[]{a.b("\u923c\uebb8\u6178\uff1c\u74c9\uf269\u480b\uc1ec\u5fb0", -1853123999), a.c(-226916625, "\u86a1\uff2d\u75ef\ueb96\u6069\ue6ce\u5c9e"), a.b("\u66d2\u1f4c\u9593\u0bea\u802c\u0688\ubcdd\u3538", 408970900), a.b("\u8d83\uf410\u7ed4\ue0a4\u6b7e\uedc5\u5781\ude6d\u4034\uca84\u4d4a", -679375400), a.c(1961655275, "\u7bac\u022e\u88fd\u1691\u9d5e\u1beb"), a.b("\uec4e\u95d1\u1f01\u817c\u0aa3\u8c36\u365f\ubfaf\u21e8\uab5c\u2c88\ud6f2", 1774382080), a.c(-1211053333, "\ucaa1\ub33e\u39ee\ua793\u2c4c\uaad3\u1096\u9964"), a.b("\u3756\u4edb\uc405\u5a6c\ud1a7\u5701\ued65\u6482\ufade", 1040463631), a.c(-1055867935, "\ubba7\uc230\u48f0\ud68e\u5d44\udbf6\u61b4\ue856\u761e\ufca4\u7b6d\u812e\u0fcd\u9667\u1c38\u9ac2\u2087\uaf41"), a.b("\ucfc9\ub647\u3c8c\ua2e0\u2904\uaf9f\u15d7\u9c37\u0267\u88df\u0f1a", -1509830776), a.d("\u9009\ue984\u634d\ufd25\u76db\uf07c\u4a2c", 752462177, 62732604), a.d("\u1368\u6ae2\ue038\u7e4c\uf59a\u733c\uc955\u408d\udedd\u5466\ud3a2", -1125916194, -286854418), a.d("\u8989\uf007\u7ad8\ue4bb\u6f56\ue9c5\u539d\uda6d\u443b", 1581976532, 1096385026), a.c(30929469, "\uf27d\u8bed\u0123\u9f65\u149e\u922c\u287c\ua190"), a.c(1064544947, "\uaafa\ud360\u59ba\uc7de\u4c29\ucabb\u70fa\uf90f\u675a\uedf3"), a.c(-689713143, "\ud054\ua9de\u2310\ubd78\u36a8\ub017\u0a53\u8380\u1dfd\u975b\u109b\ueaf5\u642e\ufd8d")};
    private static final String[][] gry = new String[][]{new String[0], {a.c(-1996219661, "\u1aaa\u6327\ue9f9\u7790\ufc5b\u7afd\uc099\u497e\ud722")}, {a.d("\ud79a\uae17\u24c9\ubaa0\u316b\ub7cd\u0da9\u844e\u1a12", 1152539954, 743738097)}, new String[0], {a.d("\udaa0\ua32d\u29f3\ub79a\u3c51\ubaf7\u0093\u8974\u1728", -1580600793, 1931028702)}, {a.d("\uafd2\ud65f\u5c81\uc2e8\u4923\ucf85\u75e1\ufc06\u625a", 1071476880, -2131566821)}, new String[0], {a.b("\u245c\u5dd1\ud70f\u4966\uc2ad\u440b\ufe6f\u7788\ue9d4", -469818363), a.c(337061205, "\u2513\u5c8d\ud652\u482b\uc3ed\u4549\uff1c\u76f9")}, grx, new String[0]};
    private static final Set<Integer> grz = Set.of(Integer.valueOf(2), Integer.valueOf(5));
    private static final Set<Integer> gsa = Set.of();
    private static final int gsb = 100;
    private static final List<Entity> gsc = new ArrayList<Entity>();
    private static long gsd;
    private static long gse;
    private static boolean gsf;
    private static /* synthetic */ String gsg;
    private static /* synthetic */ String gsh;

    private grw() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) throws Exception {
        int n2;
        kfx kfx2 = Flow.getInstance().getModuleManager();
        if (n == 1) {
            grw.gsj(minecraftClient, a.d("\u3497\u4d20\uc7ff\u5986\ud259\u54ea\ueeb2\u6742\uf958\u73aa\uf468\u0e0e\u80dd\u1979\u9337\u15d9\uaf85", -1829215174, 537809115));
            grw.gsj(minecraftClient, a.c(963842908, "\u1325\u6a89\ue05e\u7e27\uf5b5\u7357\uc912\u40f2\udef9\u545e\ud38b\u29fa\ua72d"));
            minecraftClient.player.setYaw(0.0f);
            minecraftClient.player.setPitch(10.0f);
            for (n2 = 0; n2 < 14; ++n2) {
                double d = (double)n2 * 0.45;
                gsc.add(grw.gsi(minecraftClient, a.b("\u8985", 1239910868) + n2, 25.0 + (double)n2 * 1.5 * Math.cos(d), 6.0 * Math.sin(d)));
            }
            hhf.add(a.c(-748082992, "\u2882\u5150"));
            ruv.onAttack(gsc.get(0));
            for (n2 = 0; n2 < 8; ++n2) {
                grw.gsj(minecraftClient, a.d("\ud87b\ua1cc\u2b07\ub576\u3ea3\ub813\u020e\u8bb2\u15e9\u9f5f\u1887\ue2f0\u6c36\uf594\u7fc0\uf923\u4322\ucca0\u560e\ud04e\u59b1\u23ad\uad40", -1565602536, 1064244487) + (n2 - 4) + a.b("\u8421\ufdce\u7753\ue93c\u62f0\ue454\u5e59", -645692410) + (5 + n2 % 3) + a.b("\ubd9c\uc476\u4e97\ud0db\u5b1d\udda4\u67a0\uee10\u705d\ufae1\u7d6c\u8705\u099d\u9028\u1a7c\u9c86\u26cf\ua90f\u33af\ub5f9\u3c1c\u4603\uc8ee\u5332\ud545\u5f98\ue629\u6879\uf284\u7493\uff2e\u01b0\u8bf3\u1218\u9450\u1efb\ua162", -1788822119) + (n2 + 1) + a.c(-1639075978, "\uaf1f\ud6ff\u5c50\uc218\u49c5\ucf7c\u7531\ufcc5\u62ae\ue83e\u6fe4\u9598\u1b57\u82a5\u08ff\u8e0f\u3445\ubb95\u2127\ua73c"));
            }
            grw.gsj(minecraftClient, a.d("\u7bf5\u024b\u889d\u16ec\u9d77\u1b98\ua198\u2872\ub63b\u3cd4\ubb54\u413b\ucfff\u5610\udc05\u5aec\ue0fd\u6f64\uf5c1\u73ce\ufa6a\u8027\u0e85\u950a\u133a\u99ee\u2049\uae55\u34a6\ub2f0\u3948\uc79f\u4dc1\ud423\u5277\ud8d4\u674d\ued62\u6bbc\uf205\u7856\u06a5\u8cf7\u0b4c\u91a0\u1fe1\ua62f\u2c89", -1222931860, 682750415));
            minecraftClient.player.getInventory().setStack(0, new ItemStack((ItemConvertible)Items.ENDER_PEARL, 16));
            minecraftClient.player.getInventory().setSelectedSlot(0);
            minecraftClient.options.getInactivityFpsLimit().setValue((Object)InactivityFpsLimit.MINIMIZED);
            if (!gsf) {
                gsf = true;
                HudRenderCallback.EVENT.register((drawContext, renderTickCounter) -> ++gsd);
            }
        }
        if (n > 20 && n <= 20 + 100 * gry.length) {
            n2 = (n - 21) / 100;
            int n3 = (n - 21) % 100;
            if (n3 == 0) {
                List<String> list = List.of(gry[n2]);
                boolean bl = !list.isEmpty();
                ukl.noScissor = grz.contains(n2);
                ukl.devMode = gsa.contains(n2) ? 1 : (grz.contains(n2) ? 2 : 0);
                for (String string : grx) {
                    kfe kfe2 = kfx2.getByName(string);
                    if (kfe2 == null) continue;
                    kfe2.setEnabled(list.contains(string));
                }
                if (bl && minecraftClient.player.isOnGround()) {
                    minecraftClient.player.jump();
                }
            } else if (n3 == 20) {
                gsd = 0L;
                gse = System.nanoTime();
                if (n2 == 1 || n2 == 2) {
                    ScreenshotRecorder.saveScreenshot((File)minecraftClient.runDirectory, (String)(a.d("\u61ca\u1871\u92a1\u0cc8\u875a\u01f4\ubbfa\u321e\uac56\u26f3\ua16b\u5b52\ud593\u4c21\uc62f", 200820232, 1278093227) + n2 + a.c(573334041, "\u6233\u1bdc\u9111\u0f69")), (Framebuffer)minecraftClient.getFramebuffer(), (int)1, text -> {});
                }
            } else if (n3 == 99) {
                double d = (double)(System.nanoTime() - gse) / 1.0E9;
                String string = gry[n2].length == 0 ? a.d("\uf6fd\u8f45\u0596", -1479661058, 463069039) : (gry[n2] == grx ? a.c(-84850699, "\u4797\u3e2b\ub4f8") : String.join((CharSequence)a.c(-1642051974, "\u4650"), gry[n2]) + (grz.contains(n2) ? a.c(20097405, "\ua957\ud0ee\u5a7a\uc408\u4fd7\uc922\u7326\ufac1\u6486\uee67") : "") + (gsa.contains(n2) ? a.c(2007089533, "\uc14a\ub8f3\u327e\uac18\u27c0\ua176\u1b20\u92d1\u0c83\u8673\u01ef\ufb84\u7552\uecfb\u66ad\ue05b\u5a1f\ud58b\u4f77\uc927\u40d2\u3a96\ub475") : ""));
                System.out.println(a.d("\ue9ab\u900f\u1acb\u84ae\u0f3f", -519932977, 691837457) + string + a.c(-628159723, "\u0b2d\u7286") + String.format(Locale.ROOT, a.d("\u57b6\u2e0c\ua4c3\u3ae6", 824613083, -1516515508), d * 1000.0 / (double)Math.max(1L, gsd)) + a.b("\u369f\u4f63\uc5ae\u5b83\ud01d\u56b8\uecf8\u6505\ufb52\u71a6\uf67d", 1289696948) + Math.round((double)gsd / d) + a.d("\u6a48\u13bf\u997a\u0708\u8c85", 1742544855, 1514173882));
            }
        }
        if (n > 20 + 100 * gry.length) {
            ukl.noScissor = false;
            ukl.devMode = 0;
            for (String string : grx) {
                kfe kfe3 = kfx2.getByName(string);
                if (kfe3 == null) continue;
                kfe3.setEnabled(false);
            }
            for (Entity entity : gsc) {
                minecraftClient.world.removeEntity(entity.getId(), Entity.RemovalReason.DISCARDED);
            }
            gsc.clear();
            hhf.remove(a.b("\u3f8b\u4659", -1709162535));
            grw.gsj(minecraftClient, a.c(-398590876, "\ufc1d\u85ae\u0f78\u9109\u1a92\u9c43\u2635\uaffa\u318a\ubb36\u3cec\uc688\u4807\ud1e2\u5bac\udd4c\u670b\ue8ea"));
            grw.gsj(minecraftClient, a.c(126412072, "\ue564\u9cda\u160c\u887d\u03e6\u8509\u3f09\ub6e3\u28aa\ua245\u25c5\udfaa\u516e\uc881\u4294\uc47d\u7e6c\uf1f5\u6b50\ued5f\u64fb\u1eb6\u9014\u0b9b\u8dab\u077f\ubed8\u30c4\uaa37\u2c61\ua7d9\u590e\ud350\u4ab2\ucce6\u4645\uf9dc\u73e4\uf530\u6c9a\ue6c4\u983e"));
            return true;
        }
        return false;
    }

    private static Entity gsi(MinecraftClient minecraftClient, String string, double d, double d2) {
        OtherClientPlayerEntity otherClientPlayerEntity = new OtherClientPlayerEntity(minecraftClient.world, new GameProfile(UUID.randomUUID(), string));
        Vec3d vec3d = minecraftClient.player.getEntityPos().add(-d2, 0.0, d);
        otherClientPlayerEntity.refreshPositionAndAngles(vec3d.x, minecraftClient.player.getY(), vec3d.z, 180.0f, 0.0f);
        otherClientPlayerEntity.equipStack(EquipmentSlot.HEAD, new ItemStack((ItemConvertible)Items.DIAMOND_HELMET));
        otherClientPlayerEntity.equipStack(EquipmentSlot.CHEST, new ItemStack((ItemConvertible)Items.NETHERITE_CHESTPLATE));
        otherClientPlayerEntity.equipStack(EquipmentSlot.MAINHAND, new ItemStack((ItemConvertible)Items.DIAMOND_SWORD));
        minecraftClient.world.addEntity((Entity)otherClientPlayerEntity);
        return otherClientPlayerEntity;
    }

    private static void gsj(MinecraftClient minecraftClient, String string) {
        minecraftClient.getNetworkHandler().sendChatCommand(string);
    }

    private static /* synthetic */ int wl(int n, int n2) {
        return n * n2 | 0xBACFB3EE;
    }

    private static /* synthetic */ int wm(int n, int n2) {
        return grw.wl(n, n2) + n;
    }

    private static /* synthetic */ int wn(int n, int n2) {
        return grw.wm(n, n2) ^ 0xA9333246;
    }
}

