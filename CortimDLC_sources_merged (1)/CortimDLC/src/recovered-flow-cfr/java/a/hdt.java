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
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.scoreboard.Scoreboard
 *  net.minecraft.scoreboard.Team
 *  net.minecraft.text.Text
 *  net.minecraft.util.Formatting
 *  net.minecraft.util.math.Vec3d
 */
package a;

import a.hhf;
import a.hyz;
import a.rjy;
import com.mojang.authlib.GameProfile;
import flow.dev.a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.Team;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;

final class hdt {
    private static final List<Entity> hdu = new ArrayList<Entity>();
    private static Team hdv;
    private static /* synthetic */ String hdw;
    private static /* synthetic */ String hdx;

    private hdt() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) {
        rjy rjy2 = rjy.get();
        hdt.hdy(minecraftClient);
        switch (n) {
            case 1: {
                rjy2.setEnabled(true);
                rjy2.background.set(a.d("\u79c0M\u8a9d\u14e9\u9f33", 2138941933, 1150865531));
                rjy2.items.set(a.b("\u11bf\u682d\ue2f3\u7c9b\uf75f", 1484198395));
                rjy2.health.set(a.b("\u9e84\ue704\u6dca\uf3b7", 1930862292));
                rjy2.size.set(2.0);
                rjy2.shrink.set(0.0);
                PlayerEntity playerEntity = hdt.hdz(minecraftClient, a.c(-1339486958, "\u0d7b\u74dd\ufe19\u607f\uebbd\u6d0e\ud74c\u5ea3\uc0fe\u4a42\ucd86\u37f1"), 4.0, 0.9);
                hdt.hdz(minecraftClient, a.c(1551262735, "\u644f\u1dd5\u970d\u0974\u82b7"), 4.6, -1.4);
                Scoreboard scoreboard = minecraftClient.field_1687.method_8428();
                hdv = scoreboard.method_1171(a.b("\u4943\u30f8\uba28\u2441\uafd3\u2924\u9362\u1a95", 522340653));
                hdv.method_1139((Text)Text.method_43470((String)a.d("\u2c64\u55b2\udf54\u413e\ucaed", 2005490548, 412448565)).method_27692(Formatting.field_1060));
                scoreboard.method_1172(playerEntity.method_7334().name(), hdv);
                hhf.add(a.d("\u92fc\ueb5a\u619e\ufff8\u743a\uf289\u48cb\uc124\u5f79\ud5c5\u5201\ua876", 881614664, 9686493));
                break;
            }
            case 30: {
                hdt.hea(minecraftClient, a.c(-1480700372, "\u4e4b\u37ef\ubd3a\u2301\ua89d\u2e38\u9470\u1d8d\u83d9\u0962\u8ef8\u74d7\ufa1c\u63ae\ue9f8\u6f04\ud502\u5a86\uc07f"));
                break;
            }
            case 31: {
                rjy2.background.set(a.d("\ufbca\u8250\u088e\u96ed\u1d3a", 1540755239, -200739665));
                break;
            }
            case 45: {
                hdt.hea(minecraftClient, a.b("\ueef7\u9753\u1d86\u83bd\u0821\u8e84\u34cc\ubd31\u2365\ua9de\u2e44\ud47f\u5aa3\uc31f\u495e\ucfaf\u75be\ufa3a\u60c3", -1662587248));
                break;
            }
            case 46: {
                rjy2.background.set(a.c(757350136, "\u3eb2\u4726\ucded\u5398\ud853\u5eef"));
                break;
            }
            case 60: {
                hdt.hea(minecraftClient, a.b("\uddc7\ua463\u2eb6\ub08d\u3b11\ubdb4\u07fc\u8e01\u1055\u9aee\u1d74\ue744\u6996\uf03f\u7a68\ufc85\u46c7\uc95f\u53b9\ud5a2", 1853283751));
                break;
            }
            case 61: {
                rjy2.background.set(a.c(-1613307956, "\udf86\ua616\u2cc4\ub2be"));
                break;
            }
            case 75: {
                hdt.hea(minecraftClient, a.b("\u4765\u3ec1\ub414\u2a2f\ua1b3\u2716\u9d5e\u14a3\u8af7L\u87d6\u7de4\uf332\u6a82\ue0da\u6663\udc79\u53e2", 1471366915));
                break;
            }
            case 76: {
                rjy2.background.set(a.c(2057023957, "\ub183\uc80e\u42de\udcaa\u5770"));
                rjy2.items.set(a.d("\u0578\u7cee\uf63f\u684b\ue39b\u6521", -2061395244, 1738186723));
                rjy2.size.set(1.0);
                break;
            }
            case 90: {
                hdt.hea(minecraftClient, a.d("\u5d50\u24f4\uae21\u301a\ubb86\u3d23\u876b\u0e96\u90c2\u1a79\u9de3\u67cc\ue907\u70b5\ufae3\u7c1f\uc619\u499d\ud367", 650538331, 1302605932));
                break;
            }
            case 91: {
                for (Entity entity : hdu) {
                    minecraftClient.field_1687.method_2945(entity.method_5628(), Entity.RemovalReason.field_26999);
                }
                hdu.clear();
                minecraftClient.field_1687.method_8428().method_1191(hdv);
                hhf.remove(a.d("\u740d\u0dab\u876f\u1909\u92cb\u1478\uae3a\u27d5\ub988\u3334\ub4f0\u4e87", -686412065, -1281074501));
                rjy2.background.set(a.b("\u321c\u4b91\uc141\u5f35\ud4ef", -1401474486));
                rjy2.items.set(a.c(-725481712, "\u075f\u7ec9\uf418\u6a6c\ue1bc\u6706"));
                rjy2.size.set(1.0);
                rjy2.shrink.set(0.7);
                hyz.save();
                return true;
            }
        }
        return false;
    }

    private static void hdy(MinecraftClient minecraftClient) {
        minecraftClient.field_1724.method_36456(0.0f);
        minecraftClient.field_1724.method_36457(-4.0f);
        minecraftClient.field_1724.field_5982 = 0.0f;
        minecraftClient.field_1724.field_6004 = -4.0f;
    }

    private static PlayerEntity hdz(MinecraftClient minecraftClient, String string, double d, double d2) {
        OtherClientPlayerEntity otherClientPlayerEntity = new OtherClientPlayerEntity(minecraftClient.field_1687, new GameProfile(UUID.randomUUID(), string));
        Vec3d vec3d = minecraftClient.field_1724.method_73189().method_1019(new Vec3d(0.0, 0.0, 1.0).method_1021(d)).method_1019(new Vec3d(-1.0, 0.0, 0.0).method_1021(d2));
        otherClientPlayerEntity.method_5808(vec3d.field_1352, minecraftClient.field_1724.method_23318(), vec3d.field_1350, 180.0f, 0.0f);
        otherClientPlayerEntity.method_5636(180.0f);
        otherClientPlayerEntity.method_5847(180.0f);
        otherClientPlayerEntity.field_6220 = 180.0f;
        otherClientPlayerEntity.field_6259 = 180.0f;
        otherClientPlayerEntity.method_5673(EquipmentSlot.field_6169, new ItemStack((ItemConvertible)Items.field_22027));
        otherClientPlayerEntity.method_5673(EquipmentSlot.field_6174, new ItemStack((ItemConvertible)Items.field_22028));
        otherClientPlayerEntity.method_5673(EquipmentSlot.field_6172, new ItemStack((ItemConvertible)Items.field_22029));
        otherClientPlayerEntity.method_5673(EquipmentSlot.field_6166, new ItemStack((ItemConvertible)Items.field_22030));
        otherClientPlayerEntity.method_5673(EquipmentSlot.field_6173, new ItemStack((ItemConvertible)Items.field_22022));
        otherClientPlayerEntity.method_5673(EquipmentSlot.field_6171, new ItemStack((ItemConvertible)Items.field_8367, 64));
        otherClientPlayerEntity.method_6033(15.0f);
        minecraftClient.field_1687.method_53875((Entity)otherClientPlayerEntity);
        hdu.add((Entity)otherClientPlayerEntity);
        return otherClientPlayerEntity;
    }

    private static void hea(MinecraftClient minecraftClient, String string) {
        System.out.println(a.d("\uf6e8\u8f4f\u0595\u9bee\u107f\u969a\u2cd8\ua53f\u3b67\ub182", 461015729, -2098299872) + string + a.b("\ub5bd\ucc6c\u46df", 1227863454) + minecraftClient.method_47599() + a.c(-514856328, "\uea5c\u93ab\u196e\u871c"));
        ScreenshotRecorder.method_22690((File)minecraftClient.field_1697, (String)(a.b("\ud2a9\uab12\u21c2\ubfab\u3439\ub297", -1494756663) + string + a.b("\u2495\u5d7a\ud7b7\u49cf", 704324799)), (Framebuffer)minecraftClient.method_1522(), (int)1, text -> System.out.println("" + text.getString()));
    }

    private static /* synthetic */ int zc(int n, int n2) {
        return n + n2 + 2029322376;
    }

    private static /* synthetic */ int zd(int n, int n2) {
        return hdt.zc(n, n2) ^ 0x71EAF5E6;
    }

    private static /* synthetic */ int ze(int n, int n2) {
        return hdt.zc(n, n2) * n2;
    }
}

