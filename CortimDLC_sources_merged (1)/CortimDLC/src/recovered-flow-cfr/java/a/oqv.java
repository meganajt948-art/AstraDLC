/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.screen.v1.ScreenEvents
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.ingame.HandledScreen
 *  net.minecraft.client.render.RenderTickCounter
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.entity.player.PlayerInventory
 *  net.minecraft.item.Item
 *  net.minecraft.registry.Registries
 *  net.minecraft.screen.ScreenHandler
 *  net.minecraft.screen.slot.Slot
 *  net.minecraft.screen.slot.SlotActionType
 *  net.minecraft.util.math.BlockPos
 */
package a;

import a.hlc;
import a.iov;
import a.izx;
import a.kfa;
import a.kfe;
import a.oqq;
import a.osq;
import a.ujt;
import a.unf;
import a.usn;
import a.uut;
import a.vdn;
import a.veo;
import a.vhz;
import a.vkl;
import a.vkq;
import a.vkw;
import a.vlg;
import a.vlj;
import a.vlq;
import a.vmc;
import a.vxl;
import a.vzz;
import a.wap;
import flow.dev.a;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.math.BlockPos;

public class oqv
extends kfe {
    private static oqv oqw;
    private final vlj oqx = this.add(new vlj(a.c(-1554001738, "\ud0fa\ua976\u23b4\ubdcd\u3604"), vlg.ITEMS, a.d("\ub57b\uccce\u461a\ud860\u53b1\ud511\u6f51\ue6a7\u78ea\uf215\u7598\u8fe4\u013b\u9886\u12d7\u9427\u2e62", -255549696, -1580520953), a.c(-1207447122, "\ud1d4\ua861\u22b5\ubccf\u371e\ub1be\u0bfe\u8208\u1c45\u96ba\u1137\ueb4b\u6594\ufc29\u7678\uf088\u4acd\uc527\u5fa9\ud9f6\u5002\u2a5f\ua4e4"), a.c(2014320639, "\u178b\u6e3e\ue4ea\u7a90\uf141\u77e1\ucda1\u4457\uda1a\u50e5\ud762\u2d18\ua3de\u3a73\ub02d\u36cb\u8c9f\u0353\u99f1\u1f9a\u965b\uec0d\u62b7\uf96e\u7f0a"), a.c(-1298387162, "\u2f52\u56e7\udc33\u4249\uc998\u4f38\uf578\u7c8e\ue2c3\u683c\uefbb\u15c1\u9b07\u02aa\u88f4\u0e12\ub446\u3b8a\ua128\u2743\uae98\ud4d9\u5a7b\uc1b9\u47d7"), a.b("\u0854\u71e1\ufb35\u654f\uee9e\u683e\ud27e\u5b88\uc5c5\u4f3a\uc8b2\u32cc\ubc16\u25ad\uaff2\u2908\u935d\u1ca7\u862f\u007f\u898f\uf3ce\u7d66\ue6ad", -1232205791), a.d("\u93f5\uea40\u6094\ufeee\u753f\uf39f\u49df\uc029\u5e64\ud49b\u5315\ua96c\u27b8\ube01\u3453\ub2a9\u08d7\u8738\u1d9a\u9bcb\u1220\u6878", -1718916658, 1646262848), a.c(768483773, "\u21f0\u5845\ud291\u4ceb\uc73a\u419a\ufbda\u722c\uec61\u669e\ue112\u1b68\u95b2\u0c08\u8652\u00ac\ubaf9\u3539\uaf8b\u29e1\ua02e\uda77\u54c7\ucf1e\u4960\uc3ba\u7a38\uf457\u6eb1\ue8e0\u634f\u9d97"), a.c(706481648, "\u0d87\u7432\ufee6\u609c\ueb4d\u6ded\ud7ad\u5e5b\uc016\u4ae9\ucd74\u371e\ub9d2\u2072\uaa29\u2cea\u9695\u194d\u83c7\u05bc\u8c50\uf60b\u78a5\ue364\u651c\uefc4"), a.c(-478939211, "\uf7c8\u8e7d\u04a9\u9ad3\u1102\u97a2\u2de2\ua414\u3a59\ub0a6\u372a\ucd52\u4390\uda2c\u5079\ud69b"), a.b("\uafe0\ud655\u5c81\uc2fb\u492a\ucf8a\u75ca\ufc3c\u6271\ue88e\u6f02\u9578\u1ba5\u8215\u0851\u8e8d\u34ed\ubb29\u219e\ua7dc\u2e35", -1566855272), a.d("\u2605\u5fb0\ud564\u4b1e\uc0cf\u466f\ufc2f\u75d9\ueb94\u616b\ue6e7\u1c9e\u9241\u0be7\u81a7\u075b\ubd1c", -336112991, -1909492520), a.d("\ubcbb\uc50e\u4fda\ud1a0\u5a71\udcd1\u6691\uef67\u712a\ufbd5\u7c5b\u8622\u08f6\u914f\u1b27\u9de0\u27a8\ua870\u32cb\ub481", -1525612503, -1076577045), a.d("\u822d\ufb98\u714c\uef36\u64e7\ue247\u5807\ud1f1\u4fbc\uc543\u42cf\ub8a3\u367c\uafd8\u259c\ua376\u1935\u96ef\u0c51\u8a06\u03cb\u79a7\uf719\u6cd3\ueaac\u6065\ud9df", 1080055806, -1795500635), a.b("\u3eaf\u471a\ucdce\u53b4\ud865\u5ec5\ue485\u6d73\uf33e\u79c1\ufe5b\u0431\u8afb\u1353\u9907\u1ff8\ua5a0\u2a5c\ub0d2\u368e\ubf6e", 1316437719), a.d("\ufd9d\u8428\u0efc\u9086\u1b57\u9df7\u27b7\uae41\u300c\ubaf3\u3d77\uc70a\u49df\ud068", 1940026685, 286099651)));
    private final vlq oqy = this.add(new vlq(a.b("\u7903\u009c\u8a53", -1838319285), 71));
    private final vmc oqz = this.add(new vmc(a.b("\u7c3b\u05ab\u8f71\u110d\u9ac2", -1273594758), 85.0, 30.0, 300.0, 5.0).suffix(a.c(1541256811, "\ub604\ucfab")));
    private final vkl ora = this.add(new vkl(a.b("\ud78a\uae14\u24c4\ubaa9\u3168\ub79c\u0d8c\u8476\u1a24\u9083\u1757", 693688258), true));
    private final vkl orb = this.add(new vkl(a.c(-89836003, "\u365b\u4fc6\uc506\u5b6e\ud0f2\u5600\uec58\u65a4\ufbed\u715b\uf68f"), true));
    private final vkl orc = this.add(new vkl(a.b("\u04a9\u7d39\uf7f1\u699d\ue245\u64eb", -1553333023), true));
    private final vkw ord = this.add(new vkw(a.b("\uc959\ub0c4\u3a04\ua46c\u2fa3", 297126161), new vkq(a.b("\u0aca\u7354\uf98e\u67fb\uec3f\u6adc\ud0c2\u593f\uc773\u4ddb\uca10", -428537214), vhz.TRASH, oqv::osi)));
    private static final int ore = 1;
    private static final int orf = 2;
    private static final int org = -45730;
    private static final int orh = -15795;
    private static final int ori = 1024;
    private static final double orj = 160.0;
    private static final vdn ork;
    private static final Map<BlockPos, oqq> orl;
    private static ClientWorld orm;
    private static BlockPos orn;
    private static long oro;
    private final ArrayDeque<Integer> orp = new ArrayDeque();
    private boolean orq;
    private boolean orr;
    private int ors = -1;
    private int ort;
    private int oru;
    private int orv;
    private long orw;
    private BlockPos orx;
    private String ory;
    private long orz;
    private long osa = -1L;
    private final float[] osb = new float[2];
    private final float[] osc = new float[4];
    private final float[] osd = new float[2];
    public static final int MARK_NONE = 0;
    public static final int MARK_DONE = 1;
    public static final int MARK_LEFT = 2;
    private static final int[][] ose;
    private final double[][] osf = new double[8][3];
    private static /* synthetic */ boolean osg;
    private static /* synthetic */ int osh;

    public oqv() {
        super(a.d("\u0f52\u76c8\ufc16\u6271\ue9a1\u6f28\ud558\u5ca9\uc2ed\u484d\ucf89", 290488070, -194744292), a.d("\ufca9\u852d\u0ff4\u918b\u1a4a\u9ca8\u26a2\uaf45\u3100\ubbb6\u3c37\uc60a\u48d8\ud173\u5b27\uddc7\u6789\ue81c\u72e6\uf4aa\u7d4c\u0715\u89b8\u123a\u9403\u1ec6\ua768\u293b\ub381\u3593\ube2b\u40f7\ucaae\u5358\ud50c", 927626731, -1760261835), kfa.PLAYER);
        oqw = this;
    }

    public static boolean busy() {
        return oqw != null && oqv.oqw.orq;
    }

    public static void onUseBlock(BlockPos blockPos) {
        orn = blockPos.method_10062();
        oro = System.currentTimeMillis();
    }

    public static boolean wantsItem(Item item) {
        return oqw != null && oqv.oqw.oqx.contains(Registries.field_41178.method_10221((Object)item).toString());
    }

    public static boolean listEmpty() {
        return oqw == null || oqv.oqw.oqx.size() == 0;
    }

    public static int markState(ClientWorld clientWorld, BlockPos blockPos) {
        if (clientWorld == null || blockPos == null || orm != clientWorld) {
            return 0;
        }
        oqq oqq2 = orl.get(blockPos);
        return oqq2 == null ? 0 : oqq2.state();
    }

    public static void markFromOutside(ClientWorld clientWorld, BlockPos blockPos, boolean bl) {
        if (oqw == null || !oqv.oqw.orb.get() || clientWorld == null || blockPos == null) {
            return;
        }
        if (orm != clientWorld) {
            orl.clear();
            orm = clientWorld;
        }
        if (orl.size() >= 1024) {
            Iterator<BlockPos> iterator = orl.keySet().iterator();
            iterator.next();
            iterator.remove();
        }
        orl.put(blockPos.method_10062(), new oqq(bl ? 2 : 1, System.currentTimeMillis()));
    }

    private static void osi() {
        orl.clear();
    }

    public static void attach(Screen screen2) {
        if (!(screen2 instanceof HandledScreen) || !vxl.isStorage(screen2)) {
            return;
        }
        ScreenEvents.afterRender((Screen)screen2).register((screen, drawContext, n, n2, f) -> {
            if (oqw != null && oqw.isEnabled()) {
                oqw.oso(drawContext);
            }
        });
    }

    @Override
    protected void onDisable() {
        this.orq = false;
        this.orp.clear();
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        HandledScreen handledScreen;
        block11: {
            block10: {
                boolean bl;
                if (minecraftClient.field_1687 != orm) {
                    orm = minecraftClient.field_1687;
                    orl.clear();
                }
                boolean bl2 = minecraftClient.field_1755 instanceof HandledScreen && vxl.isStorage(minecraftClient.field_1755);
                boolean bl3 = bl = bl2 && this.oqy.isBound() && vzz.isDown(minecraftClient, this.oqy.get());
                if (bl && !this.orr && !this.orq && !osq.busy()) {
                    this.osk(minecraftClient);
                }
                this.orr = bl;
                if (!this.orq) {
                    return;
                }
                Screen screen = minecraftClient.field_1755;
                if (!(screen instanceof HandledScreen)) break block10;
                handledScreen = (HandledScreen)screen;
                if (handledScreen.method_17577().field_7763 == this.ors) break block11;
            }
            this.orq = false;
            return;
        }
        long l = System.currentTimeMillis();
        if (l < this.orw) {
            return;
        }
        ScreenHandler screenHandler = handledScreen.method_17577();
        PlayerInventory playerInventory = minecraftClient.field_1724.method_31548();
        while (!this.orp.isEmpty()) {
            int n = this.orp.poll();
            Slot slot = (Slot)screenHandler.field_7761.get(n);
            if (!slot.method_7681() || !this.osj(slot)) continue;
            if (!vxl.hasRoom(screenHandler, playerInventory, slot.method_7677())) {
                ++this.orv;
                continue;
            }
            vxl.click(minecraftClient, screenHandler, n, 0, SlotActionType.field_7794);
            if (slot.method_7681() && this.osj(slot)) {
                ++this.orv;
            }
            ++this.ort;
            this.ory = wap.s(a.b("\u4f77\u36e5\ubc36\u225c\ua99a\u2f3c\u953d\u1c5b\u8293\u0876\u8fb0\u75cb\ufb1e\u62a8\ue8f2\u6e44", 1334398763), a.b("\u2561\u5c88\ud65a\u485c\uc3fe\u412f\ufbeb\u728d\ue8c5\u6273\ue5a1\u1fd9\u9176\u08b7\u829a\u0005", -907861654)) + this.ort + wap.s(a.b("\u5042\u29bc\ua366\u3d51", 1554600038), a.d("\u5224\u2f8d\ua551\u3f37", 1201455093, -1192301067)) + this.oru;
            this.orz = l + 1500L;
            this.orw = l + (long)this.oqz.getInt();
            return;
        }
        this.osl(minecraftClient, handledScreen);
    }

    private boolean osj(Slot slot) {
        return this.oqx.contains(Registries.field_41178.method_10221((Object)slot.method_7677().method_7909()).toString());
    }

    private void osk(MinecraftClient minecraftClient) {
        HandledScreen handledScreen = (HandledScreen)minecraftClient.field_1755;
        ScreenHandler screenHandler = handledScreen.method_17577();
        long l = System.currentTimeMillis();
        this.orx = orn != null && l - oro < 5000L ? orn : null;
        this.orp.clear();
        this.ort = 0;
        this.orv = 0;
        if (this.oqx.size() == 0) {
            this.osn(wap.s(a.d("\u6326\u1aab\u9075\u0e41\u85da\u036e\ub927\u30d1\uaeda\u2422\ua3eb\u59c9\ud75b\u4ee2\uc4ac\u4259\uf81b\u7789\ued20\u6b21\ue2cf\u9894\u162f\u8db5\u0b83\u814f\u38ed\ub6b4\u2c5d\uaa5f\u21a5\udf73\u5572\uccd7\u4a98\uc024\u7fb6\uf58a\u735b\ueae1\u60af\u1e47\u941d", -2071066928, 2003592585), a.d("\u49a3\u300c\ubad8\u24d0\uaf78\u29cd\u9784\u1a6a\u8449\u0efa\u892a\u7739\ud9da\u605f\uee1e\u6896\ud2a3\u5d76\uc7b0\u4199\uc814\ub232\u3894\ua75a\u215a\uabfe\u124c\u9c15\u06eb\u80cd\u0b77\uf1cd\u7f90\ue273\u603c\uea8f\u5552\udf54\u59ff\uc040", 463319755, 718405473)), false);
            return;
        }
        if (!screenHandler.method_34255().method_7960()) {
            this.osn(wap.s(a.d("\ud2bd\uab29\u21fb\ubfde\u345d\ub2f0\u08ae\u811a\u1f0c\u95a0\u1262\ue81b\u6681\uff7f\u752d\uf392\u4989\uc644\u5cfa\udaee\u535a\u291d\ua7a9\u3c79\uba1a\u30d6\u8937\u0722\u9dde\u1b97\u903d", 183186264, 446685610), a.b("\u7b28\u028b\u885c\u1658\u9df7\u1b3c\ua118\u2cfc\ub6bc\u3c72\ubbd4\u41a4\ucf7b\u56c3\udce7\u5e74\ue05a\u6bea\uf543\u736b\ufa9f\u80cf\u0e03\u95ac\u13a3", 356351762)), false);
            return;
        }
        for (Slot slot : vxl.own(screenHandler, minecraftClient.field_1724.method_31548())) {
            if (!slot.method_7681() || !this.osj(slot)) continue;
            this.orp.add(slot.field_7874);
        }
        this.oru = this.orp.size();
        if (this.oru == 0) {
            this.ory = wap.s(a.d("\u5e56\u27c4\uad17\u337d\ub8bb\u3e1d\u841c\u0d7a\u93b2\u194d\u9e9f\u64f5\uea3e\u738e\uf9da\u7f22\uc52a\u4aaf\ud007\u5619\udfba\ua5fe\u2b47\ub098", -251786765, -178235407), a.c(676280743, "\u3da8\u4441\uce93\u5095\udb37\u59e6\ue322\u6a44\uf00a\u7aca\ufd69\u076a\u89b3\u146e\u9a20\u1cd9\ua6e4\u2947\ub3f2\u35ae"));
            this.orz = l + 1800L;
            this.osm(1);
            return;
        }
        this.orq = true;
        this.ors = screenHandler.field_7763;
        this.orw = l;
    }

    private void osl(MinecraftClient minecraftClient, HandledScreen<?> handledScreen) {
        this.orq = false;
        long l = System.currentTimeMillis();
        if (this.orv > 0) {
            this.ory = wap.s(a.c(634812094, "\u76fc\u0f6e\u85bd\u1bd7\u9011\u16b7\uacb6\u25d0\ubb18\u31e5\ub63f\u4c4d\uc288\u5b6d"), a.d("\u582a\u21c3\uab11\u3517\ubeb5\u3c64\u86a0\u0fc6\u9587\u1f49\u9899\u629a\uec46\u75f2\uffde\u7922\uc701", 66498771, -1906512653)) + this.orv + wap.s(a.d("\u19a7\u601e\uea8b\u74fb\uff63\u7980\uc3ce\u4a3f\ud462\u5e97", 196401980, -609631567), a.d("\ud2d0\uab69\u25af\ubbd6\u3076\ub2a5\u0cea\u8512\u1b39\u918b\u162a\ue842", -108027712, 630878780));
            this.osm(2);
            this.osn(wap.s(a.c(-21013775, "\u5aa3\u2327\ua9fe\u3781\ubc5d\u3aa2"), a.d("\ua12c\ud8ba\u5268\ucc68\u47cf\uc173\u7b23\uf6cc", -770554322, 69722909)) + this.ort + wap.s(a.c(-2037248044, "\u0ff6\u764b\ufcd6\u62a6\ue93e\u6fdd\ud593\u5c62\uc23f\u48c3\ucf56\u352e\ubbe4\u2207"), a.b("\uf1f8\u8845\u068b\u98f2\u1730\u9593\u2fc9\ua636\u386b\ub2d6\u3500\ucb75\u45b8", -1236471335)) + this.orv, false);
        } else {
            this.ory = wap.s(a.d("\uf4d3\u8d41\u0792\u99f8\u123e\u9498\u2e99\ua7ff\u3937\ub3d2\u3414\uce6f\u40b6\ud90c\u5311", -1878490636, 1029797220), a.d("\ua4e6\udd0f\u57dd\uc9db\u4279\uc0a8\u7a6c\uf30a\u6942\ue3f4\u6426\u9e26\u1081\u893d\u036d\u8182", -353586963, -406515712)) + this.ort;
            this.osm(1);
            this.osn(wap.s(a.d("\ud98f\ua00b\u2ad2\ub4ad\u3f71\ub98e", -1728190778, -1501020389), a.b("\u6586\u1c10\u96c2\u08c2\u8365\u05d9\ubf89\u3266", 1918591385)) + this.ort, true);
            if (this.ora.get()) {
                handledScreen.method_25419();
            }
        }
        this.orz = l + 2000L;
    }

    private void osm(int n) {
        if (this.orx == null || !this.orb.get()) {
            return;
        }
        if (orl.size() >= 1024) {
            Iterator<BlockPos> iterator = orl.keySet().iterator();
            iterator.next();
            iterator.remove();
        }
        orl.put(this.orx, new oqq(n, System.currentTimeMillis()));
    }

    private void osn(String string, boolean bl) {
        if (this.orc.get()) {
            izx.alert(this.getName(), string, bl ? vhz.CHECK : vhz.INFO, bl);
        }
    }

    private void oso(DrawContext drawContext) {
        if (this.ory == null || System.currentTimeMillis() > this.orz) {
            return;
        }
        uut.beginFrame();
        float f = ork.width(this.ory) + 16.0f;
        float f2 = 13.0f;
        float f3 = ((float)drawContext.method_51421() - f) * 0.5f;
        float f4 = 6.0f;
        uut.shadow(drawContext, f3, f4 + 1.0f, f, f2, f2 * 0.5f, 6.0f, 0x60000000);
        uut.round(drawContext, f3, f4, f, f2, f2 * 0.5f, ujt.withAlpha(iov.window, 240));
        uut.outline(drawContext, f3, f4, f, f2, f2 * 0.5f, 1.0f, iov.accent(150));
        ork.drawCentered(drawContext, this.ory, f3 + f * 0.5f, ork.centerTop(f4 + f2 * 0.5f), -855307);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void render(DrawContext drawContext, RenderTickCounter renderTickCounter) {
        usn usn2;
        oqv oqv2 = oqw;
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        if (oqv2 == null || !oqv2.isEnabled() || !oqv2.orb.get() || orl.isEmpty() || minecraftClient.field_1687 == null || minecraftClient.field_1724 == null || minecraftClient.field_1690.field_1842 || minecraftClient.field_1755 instanceof hlc) {
            return;
        }
        unf.observe(drawContext);
        if (unf.frame() == oqv2.osa) {
            return;
        }
        oqv2.osa = unf.frame();
        try {
            usn2 = usn.capture(renderTickCounter.method_60637(true), drawContext.method_51421(), drawContext.method_51443());
        }
        catch (Throwable throwable) {
            return;
        }
        uut.beginFrame();
        uut.beginBatch();
        try {
            long l = System.currentTimeMillis();
            for (Map.Entry<BlockPos, oqq> entry : orl.entrySet()) {
                BlockPos blockPos = entry.getKey();
                if (usn2.distance((double)blockPos.method_10263() + 0.5, (double)blockPos.method_10264() + 0.5, (double)blockPos.method_10260() + 0.5) > 160.0) continue;
                float f = Math.min(1.0f, (float)(l - entry.getValue().at()) / 650.0f);
                int n = entry.getValue().state() == 1 ? -45730 : -15795;
                oqv2.osp(drawContext, usn2, blockPos, n, f);
            }
        }
        finally {
            uut.endBatch();
        }
    }

    private void osp(DrawContext drawContext, usn usn2, BlockPos blockPos, int n, float f) {
        double d = 0.06 * (1.0 - (double)f);
        double d2 = (double)blockPos.method_10263() + 0.0625 - d;
        double d3 = (double)blockPos.method_10264() - d;
        double d4 = (double)blockPos.method_10260() + 0.0625 - d;
        double d5 = (double)blockPos.method_10263() + 0.9375 + d;
        double d6 = (double)blockPos.method_10264() + 0.875 + d;
        double d7 = (double)blockPos.method_10260() + 0.9375 + d;
        int n2 = ujt.withAlpha(n, Math.round(210.0f * f));
        double[][] dArray = this.osf;
        for (int i = 0; i < 8; ++i) {
            dArray[i][0] = (i & 1) == 0 ? d2 : d5;
            dArray[i][1] = (i & 2) == 0 ? d3 : d6;
            dArray[i][2] = (i & 4) == 0 ? d4 : d7;
        }
        for (int[] nArray : ose) {
            double[] dArray2 = dArray[nArray[0]];
            double[] dArray3 = dArray[nArray[1]];
            if (!usn2.projectSegment(dArray2[0], dArray2[1], dArray2[2], dArray3[0], dArray3[1], dArray3[2], 0.05f, this.osc, this.osd)) continue;
            uut.line(drawContext, this.osc[0], this.osc[1], this.osc[2], this.osc[3], 1.1f, n2);
        }
        if (usn2.project((double)blockPos.method_10263() + 0.5, (double)blockPos.method_10264() + 1.15, (double)blockPos.method_10260() + 0.5, this.osb)) {
            uut.circle(drawContext, this.osb[0], this.osb[1], 2.2f, ujt.withAlpha(n, Math.round(230.0f * f)));
        }
    }

    static {
        ork = veo.medium(6.0f);
        orl = new HashMap<BlockPos, oqq>();
        ose = new int[][]{{0, 1}, {2, 3}, {4, 5}, {6, 7}, {0, 2}, {1, 3}, {4, 6}, {5, 7}, {0, 4}, {1, 5}, {2, 6}, {3, 7}};
    }

    private static /* synthetic */ int beo(int n, int n2) {
        return n - n2 ^ 0xEB2BA46E;
    }

    private static /* synthetic */ int bep(int n, int n2) {
        return n * n2 ^ 0x59696E3B;
    }
}

