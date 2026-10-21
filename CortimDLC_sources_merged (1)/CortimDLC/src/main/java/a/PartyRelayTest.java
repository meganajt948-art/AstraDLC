/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_1297
 *  net.minecraft.class_1297$class_5529
 *  net.minecraft.class_243
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  net.minecraft.class_318
 *  net.minecraft.class_437
 *  net.minecraft.class_745
 */
package a;

import a.gqu;
import a.ClickGuiScreen;
import a.GuiConfig;
import a.ubg;
import a.ubm;
import a.PartyClient;
import a.PartyCrypto;
import a.Waypoints;
import com.mojang.authlib.GameProfile;
import flow.dev.StringDecryptor;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.UUID;
import net.minecraft.class_1297;
import net.minecraft.class_243;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_318;
import net.minecraft.class_437;
import net.minecraft.class_745;

final class PartyRelayTest {
    private static final String gre = System.getenv().getOrDefault("FLOW2_PARTY_RELAY", "ws://127.0.0.1:8787");
    private static gqu grf;
    private static gqu grg;
    private static class_745 grh;
    private static int gri;
    private static int grj;
    private static int grk;
    private static String grl;
    private static int grm;
    private static /* synthetic */ long grn;
    private static /* synthetic */ String gro;

    private PartyRelayTest() {
    }

    static boolean tick(class_310 class_3102, int n) {
        if (class_3102.field_1724 == null) {
            return false;
        }
        if (gri != 6 || n - grj < 41) {
            class_3102.field_1724.method_36456(0.0f);
            class_3102.field_1724.field_5982 = 0.0f;
        }
        if (gri < 6) {
            class_3102.field_1724.method_36457(10.0f);
            class_3102.field_1724.field_6004 = 10.0f;
        }
        switch (gri) {
            case 0: {
                grl = System.getProperty("flow2.party.relay");
                System.setProperty("flow2.party.relay", gre);
                PartyRelayTest.grr(PartyClient.sameServer("mp:Skytime.su", "mp:mc.skytime.su:25565"), "Skytime.su = mc.skytime.su:25565");
                PartyRelayTest.grr(!PartyClient.sameServer("mp:funtime.su", "mp:skytime.su"), "funtime.su != skytime.su");
                PartyRelayTest.grr(PartyClient.sameServer("mp:play.example.com", "mp:EXAMPLE.com."), "play.example.com = EXAMPLE.com.");
                PartyClient.ENABLED.set(true);
                PartyClient.reconnect();
                PartyRelayTest.grp(n);
                break;
            }
            case 1: {
                if (PartyClient.code() != null) {
                    PartyRelayTest.grs("AutoRepair code " + PartyClient.prettyCode() + ", key " + PartyClient.fingerprint());
                    grf = new gqu("Kirill_PvP");
                    grg = new gqu("Sasha");
                    PartyRelayTest.grp(n);
                    break;
                }
                if (n - grj <= 300) break;
                return PartyRelayTest.grq("no hello from relay: " + (Object)((Object)PartyClient.status()) + " " + PartyClient.lastError());
            }
            case 2: {
                if (PartyRelayTest.grf.code != null && PartyRelayTest.grg.code != null) {
                    grf.send("{\"t\":\"lookup\",\"code\":\"" + PartyClient.code() + "\"}");
                    grf.send("{\"t\":\"lookup\",\"code\":\"" + PartyRelayTest.grg.code + "\"}");
                    PartyRelayTest.grp(n);
                    break;
                }
                if (n - grj <= 200) break;
                return PartyRelayTest.grq("peers got no code");
            }
            case 3: {
                if (!PartyClient.invites().isEmpty()) {
                    ubg ubg2 = PartyClient.invites().get(0);
                    PartyRelayTest.grr(ubg2.name.equals("Kirill_PvP"), "invite name decrypted from the box (" + ubg2.name + ")");
                    PartyRelayTest.grr(ubg2.fingerprint.equals(PartyCrypto.fingerprint(PartyRelayTest.grf.pub)), "invite fingerprint matches");
                    PartyRelayTest.grr(PartyRelayTest.grf.raw.stream().noneMatch(string -> string.contains("Kirill_PvP")), "relay never saw the name");
                    PartyRelayTest.grt(class_3102);
                    PartyRelayTest.grp(n);
                    break;
                }
                if (n - grj <= 200) break;
                return PartyRelayTest.grq("no invite arrived");
            }
            case 4: {
                if (n - grj == 40) {
                    PartyRelayTest.grv(class_3102, "party-invite");
                    PartyClient.accept(PartyClient.invites().get(0));
                }
                if (n - grj > 40 && PartyClient.members().size() == 2 && PartyClient.secured()) {
                    PartyRelayTest.grr(PartyClient.leader().equals(PartyRelayTest.grf.code), "friend is leader, party key adopted");
                    grf.sendStatus();
                    grg.acceptPending();
                    PartyRelayTest.grp(n);
                    break;
                }
                if (n - grj <= 240) break;
                return PartyRelayTest.grq("join failed (secured=" + PartyClient.secured() + ")");
            }
            case 5: {
                if (PartyClient.members().size() == 3 && n - grj == 30) {
                    grg.sendStatus();
                }
                if (n - grj != 50) break;
                ubm ubm2 = PartyClient.member(PartyRelayTest.grf.code);
                PartyRelayTest.grr(ubm2 != null && "Kirill_PvP".equals(ubm2.name) && Waypoints.worldId().equals(ubm2.world), "friend's encrypted status decrypted (" + (ubm2 != null ? ubm2.name : null) + ")");
                PartyRelayTest.grr(PartyClient.members().size() == 3, "Sasha joined (" + PartyClient.members().size() + ")");
                PartyRelayTest.grv(class_3102, "party-members");
                class_3102.method_1507(null);
                class_3102.field_1690.method_42474().method_41748((Object)grm);
                class_3102.method_15993();
                PartyRelayTest.gru(class_3102);
                class_243 class_2432 = class_3102.field_1724.method_73189();
                double d = Math.floor(class_2432.field_1351);
                grf.mark(1, class_2432.field_1352 - 4.0, d, class_2432.field_1350 + 14.0, 0, null);
                grf.mark(2, class_2432.field_1352 + 6.0, d, class_2432.field_1350 + 22.0, 1, null);
                grf.mark(3, class_2432.field_1352 + 2.0, d, class_2432.field_1350 - 30.0, 0, null);
                PartyRelayTest.grf.world = Waypoints.worldId().toUpperCase(Locale.ROOT);
                grf.mark(4, grh.method_23317(), grh.method_23318(), grh.method_23321(), 0, "Enemy_123");
                PartyRelayTest.grp(n);
                break;
            }
            case 6: {
                class_3102.field_1724.method_36457(18.0f);
                class_3102.field_1724.field_6004 = 18.0f;
                if (n - grj == 10) {
                    PartyRelayTest.grr(PartyClient.marks().size() == 3, "3 newest of 4 encrypted marks kept (" + PartyClient.marks().size() + ")");
                    PartyRelayTest.grr(PartyClient.marks().stream().allMatch(PartyClient::visible), "marks visible, incl. differently written address");
                    PartyClient.markKey();
                }
                if (n - grj == 25) {
                    PartyRelayTest.grv(class_3102, "party-marks");
                }
                if (n - grj == 40) {
                    PartyRelayTest.grr(grf.plainHas("mark"), "friend decrypted AutoRepair mark");
                    PartyRelayTest.grr(PartyRelayTest.grf.raw.stream().filter(string -> string.contains("\"msg\"")).noneMatch(string -> string.contains("mark")), "relay saw only ciphertext");
                    PartyClient.markKey();
                }
                if (n - grj == 41) {
                    class_3102.field_1724.method_36456(-25.0f);
                    class_3102.field_1724.field_5982 = -25.0f;
                }
                if (n - grj == 42) {
                    PartyClient.markKey();
                    PartyClient.markKey();
                }
                if (n - grj == 50) {
                    PartyRelayTest.grr(grf.plainHas("unmark"), "press on own mark removes it");
                    PartyRelayTest.grr(grf.plainHas("\"k\":1"), "double press sent danger");
                    PartyRelayTest.grv(class_3102, "party-danger");
                }
                if (n - grj != 60) break;
                PartyRelayTest.grp(n);
                break;
            }
            case 7: {
                class_3102.field_1724.method_36456(160.0f);
                class_3102.field_1724.field_5982 = 160.0f;
                if (n - grj == 15) {
                    PartyRelayTest.grv(class_3102, "party-edge");
                    grf.send("{\"t\":\"leave\"}");
                }
                if (n - grj > 15 && PartyClient.members().size() == 2 && PartyClient.isLeader()) {
                    PartyRelayTest.grr(true, "friend left, we lead");
                    PartyRelayTest.grp(n);
                    break;
                }
                if (n - grj <= 200) break;
                return PartyRelayTest.grq("leave not seen");
            }
            case 8: {
                if (PartyRelayTest.grg.epoch == 2 && PartyRelayTest.grg.keyBoxes > 0) {
                    PartyRelayTest.grr(true, "Sasha got the new key (epoch 2) from us");
                    class_3102.field_1724.method_36456(30.0f);
                    class_3102.field_1724.field_5982 = 30.0f;
                    PartyRelayTest.grg.plain.clear();
                    PartyClient.markKey();
                    PartyRelayTest.grp(n);
                    break;
                }
                if (n - grj <= 200) break;
                return PartyRelayTest.grq("no rekey after leave");
            }
            case 9: {
                if (grg.plainHas("mark")) {
                    PartyRelayTest.grr(true, "Sasha decrypts marks with the new key");
                    PartyRelayTest.grr(!PartyRelayTest.grf.keys.containsKey(2), "the friend who left has no new key");
                    PartyRelayTest.grg.keys.put(2, PartyCrypto.randomKey());
                    PartyRelayTest.grg.keyBoxes = 0;
                    PartyRelayTest.grg.plain.clear();
                    class_243 class_2433 = class_3102.field_1724.method_73189();
                    grg.mark(7, class_2433.field_1352 + 3.0, Math.floor(class_2433.field_1351), class_2433.field_1350 + 9.0, 0, null);
                    PartyRelayTest.grp(n);
                    break;
                }
                if (n - grj <= 200) break;
                return PartyRelayTest.grq("Sasha can't read epoch 2");
            }
            case 10: {
                if (PartyRelayTest.grg.keyBoxes > 0 && n - grj > 5 && n - grj < 100 && PartyRelayTest.grg.lastMarkAt == 0) {
                    PartyRelayTest.grr(true, "leader pushed the right key to Sasha after her unreadable mark");
                    class_243 class_2434 = class_3102.field_1724.method_73189();
                    grg.mark(8, class_2434.field_1352 - 3.0, Math.floor(class_2434.field_1351), class_2434.field_1350 + 9.0, 0, null);
                    PartyRelayTest.grg.lastMarkAt = n;
                }
                if (PartyRelayTest.grg.lastMarkAt > 0 && n - PartyRelayTest.grg.lastMarkAt == 20) {
                    PartyRelayTest.grr(PartyClient.marks().stream().anyMatch(ubj2 -> ubj2.id == 8), "Sasha's mark readable after the fix");
                    PartyRelayTest.grr(PartyClient.marks().stream().noneMatch(ubj2 -> ubj2.id == 7), "her broken mark was dropped");
                    class_3102.field_1724.method_36456(55.0f);
                    class_3102.field_1724.field_5982 = 55.0f;
                    PartyClient.markKey();
                }
                if (PartyRelayTest.grg.lastMarkAt > 0 && n - PartyRelayTest.grg.lastMarkAt == 40) {
                    PartyRelayTest.grr(grg.plainHas("\"id\""), "Sasha reads AutoRepair marks again");
                    PartyRelayTest.grp(n);
                    break;
                }
                if (n - grj <= 200) break;
                return PartyRelayTest.grq("key mismatch not healed (boxes " + PartyRelayTest.grg.keyBoxes + ")");
            }
            case 11: {
                PartyClient.leave();
                grf.close();
                grg.close();
                if (grh != null) {
                    class_3102.field_1687.method_2945(grh.method_5628(), class_1297.class_5529.field_26999);
                }
                if (grl == null) {
                    System.clearProperty("flow2.party.relay");
                } else {
                    System.setProperty("flow2.party.relay", grl);
                }
                PartyClient.reconnect();
                GuiConfig.save();
                System.out.println("party test " + (grk == 0 ? "PASS" : "FAIL " + grk));
                return true;
            }
        }
        return false;
    }

    private static void grp(int n) {
        ++gri;
        grj = n;
    }

    private static boolean grq(String string) {
        ++grk;
        PartyRelayTest.grs("FAIL " + string);
        gri = 11;
        return false;
    }

    private static void grr(boolean bl, String string) {
        if (!bl) {
            ++grk;
        }
        PartyRelayTest.grs((bl ? "ok " : "FAIL ") + string);
    }

    private static void grs(String string) {
        System.out.println("party test: " + string);
    }

    private static void grt(class_310 class_3102) {
        grm = (Integer)class_3102.field_1690.method_42474().method_41753();
        class_3102.field_1690.method_42474().method_41748((Object)1);
        class_3102.method_15993();
        try {
            Method method = ClickGuiScreen.class.getDeclaredMethod("setTabKey", String.class);
            method.setAccessible(true);
            method.invoke(null, "Friends");
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            PartyRelayTest.grs("can't pick the tab: " + reflectiveOperationException);
        }
        class_3102.method_1507((class_437)new ClickGuiScreen());
    }

    private static void gru(class_310 class_3102) {
        grh = new class_745(class_3102.field_1687, new GameProfile(UUID.randomUUID(), "Enemy_123"));
        class_243 class_2432 = class_3102.field_1724.method_73189().method_1031(5.0, 0.0, 11.0);
        grh.method_5808(class_2432.field_1352, class_3102.field_1724.method_23318(), class_2432.field_1350, 180.0f, 0.0f);
        class_3102.field_1687.method_53875((class_1297)grh);
    }

    private static void grv(class_310 class_3102, String string) {
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> System.out.println("" + class_25612.getString()));
    }

    static {
        grm = -1;
    }

    private static /* synthetic */ int wg(int n, int n2) {
        return n - n2 | 0x9981293E;
    }

    private static /* synthetic */ int wh(int n, int n2) {
        return n - n2 + 159413610;
    }

    private static /* synthetic */ int wi(int n, int n2) {
        return PartyRelayTest.wg(n, n2) + n;
    }
}

