/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.screen.v1.ScreenEvents
 *  net.minecraft.class_1661
 *  net.minecraft.class_1703
 *  net.minecraft.class_1713
 *  net.minecraft.class_1735
 *  net.minecraft.class_1792
 *  net.minecraft.class_2338
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_437
 *  net.minecraft.class_465
 *  net.minecraft.class_638
 *  net.minecraft.class_7923
 *  net.minecraft.class_9779
 */
package a;

import a.ClickGuiScreen;
import a.Theme;
import a.Hud;
import a.ModuleCategory;
import a.Module;
import a.oqq;
import a.InventorySorter;
import a.ColorUtil;
import a.FrameDelta;
import a.ScreenProjection;
import a.DrawUtil;
import a.FontFace;
import a.Fonts;
import a.Icon;
import a.BoolSetting;
import a.vkq;
import a.ButtonSetting;
import a.vlg;
import a.ListSetting;
import a.KeySetting;
import a.NumberSetting;
import a.SlotUtil;
import a.KeyUtil;
import a.Lang;
import flow.dev.StringDecryptor;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1792;
import net.minecraft.class_2338;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_437;
import net.minecraft.class_465;
import net.minecraft.class_638;
import net.minecraft.class_7923;
import net.minecraft.class_9779;

public class AutoLoot
extends Module {
    private static AutoLoot oqw;
    private final ListSetting oqx = this.add(new ListSetting("Items", vlg.ITEMS, "minecraft:diamond", "minecraft:diamond_block", "minecraft:netherite_ingot", "minecraft:netherite_scrap", "minecraft:ancient_debris", "minecraft:golden_apple", "minecraft:enchanted_golden_apple", "minecraft:totem_of_undying", "minecraft:elytra", "minecraft:ender_pearl", "minecraft:emerald", "minecraft:gold_ingot", "minecraft:experience_bottle", "minecraft:shulker_box", "minecraft:mace"));
    private final KeySetting oqy = this.add(new KeySetting("Key", 71));
    private final NumberSetting oqz = this.add(new NumberSetting("Delay", 85.0, 30.0, 300.0, 5.0).suffix("ms"));
    private final BoolSetting ora = this.add(new BoolSetting("Close chest", true));
    private final BoolSetting orb = this.add(new BoolSetting("Mark chests", true));
    private final BoolSetting orc = this.add(new BoolSetting("Notify", true));
    private final ButtonSetting ord = this.add(new ButtonSetting("Marks", new vkq("Clear marks", Icon.TRASH, AutoLoot::osi)));
    private static final int ore = 1;
    private static final int orf = 2;
    private static final int org = -45730;
    private static final int orh = -15795;
    private static final int ori = 1024;
    private static final double orj = 160.0;
    private static final FontFace ork;
    private static final Map<class_2338, oqq> orl;
    private static class_638 orm;
    private static class_2338 orn;
    private static long oro;
    private final ArrayDeque<Integer> orp = new ArrayDeque();
    private boolean orq;
    private boolean orr;
    private int ors = -1;
    private int ort;
    private int oru;
    private int orv;
    private long orw;
    private class_2338 orx;
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

    public AutoLoot() {
        super("ChestLooter", "Takes your listed items from chests", ModuleCategory.PLAYER);
        oqw = this;
    }

    public static boolean busy() {
        return oqw != null && AutoLoot.oqw.orq;
    }

    public static void onUseBlock(class_2338 class_23382) {
        orn = class_23382.method_10062();
        oro = System.currentTimeMillis();
    }

    public static boolean wantsItem(class_1792 class_17922) {
        return oqw != null && AutoLoot.oqw.oqx.contains(class_7923.field_41178.method_10221((Object)class_17922).toString());
    }

    public static boolean listEmpty() {
        return oqw == null || AutoLoot.oqw.oqx.size() == 0;
    }

    public static int markState(class_638 class_6382, class_2338 class_23382) {
        if (class_6382 == null || class_23382 == null || orm != class_6382) {
            return 0;
        }
        oqq oqq2 = orl.get(class_23382);
        return oqq2 == null ? 0 : oqq2.state();
    }

    public static void markFromOutside(class_638 class_6382, class_2338 class_23382, boolean bl) {
        if (oqw == null || !AutoLoot.oqw.orb.get() || class_6382 == null || class_23382 == null) {
            return;
        }
        if (orm != class_6382) {
            orl.clear();
            orm = class_6382;
        }
        if (orl.size() >= 1024) {
            Iterator<class_2338> iterator = orl.keySet().iterator();
            iterator.next();
            iterator.remove();
        }
        orl.put(class_23382.method_10062(), new oqq(bl ? 2 : 1, System.currentTimeMillis()));
    }

    private static void osi() {
        orl.clear();
    }

    public static void attach(class_437 class_4373) {
        if (!(class_4373 instanceof class_465) || !SlotUtil.isStorage(class_4373)) {
            return;
        }
        ScreenEvents.afterRender((class_437)class_4373).register((class_4372, class_3322, n, n2, f) -> {
            if (oqw != null && oqw.isEnabled()) {
                oqw.oso(class_3322);
            }
        });
    }

    @Override
    protected void onDisable() {
        this.orq = false;
        this.orp.clear();
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        class_465 class_4652;
        block11: {
            block10: {
                boolean bl;
                if (class_3102.field_1687 != orm) {
                    orm = class_3102.field_1687;
                    orl.clear();
                }
                boolean bl2 = class_3102.field_1755 instanceof class_465 && SlotUtil.isStorage(class_3102.field_1755);
                boolean bl3 = bl = bl2 && this.oqy.isBound() && KeyUtil.isDown(class_3102, this.oqy.get());
                if (bl && !this.orr && !this.orq && !InventorySorter.busy()) {
                    this.osk(class_3102);
                }
                this.orr = bl;
                if (!this.orq) {
                    return;
                }
                class_437 class_4372 = class_3102.field_1755;
                if (!(class_4372 instanceof class_465)) break block10;
                class_4652 = (class_465)class_4372;
                if (class_4652.method_17577().field_7763 == this.ors) break block11;
            }
            this.orq = false;
            return;
        }
        long l = System.currentTimeMillis();
        if (l < this.orw) {
            return;
        }
        class_1703 class_17032 = class_4652.method_17577();
        class_1661 class_16612 = class_3102.field_1724.method_31548();
        while (!this.orp.isEmpty()) {
            int n = this.orp.poll();
            class_1735 class_17352 = (class_1735)class_17032.field_7761.get(n);
            if (!class_17352.method_7681() || !this.osj(class_17352)) continue;
            if (!SlotUtil.hasRoom(class_17032, class_16612, class_17352.method_7677())) {
                ++this.orv;
                continue;
            }
            SlotUtil.click(class_3102, class_17032, n, 0, class_1713.field_7794);
            if (class_17352.method_7681() && this.osj(class_17352)) {
                ++this.orv;
            }
            ++this.ort;
            this.ory = Lang.s("Looter · taking ", "Лутер · забираю ") + this.ort + Lang.s(" of ", " из ") + this.oru;
            this.orz = l + 1500L;
            this.orw = l + (long)this.oqz.getInt();
            return;
        }
        this.osl(class_3102, class_4652);
    }

    private boolean osj(class_1735 class_17352) {
        return this.oqx.contains(class_7923.field_41178.method_10221((Object)class_17352.method_7677().method_7909()).toString());
    }

    private void osk(class_310 class_3102) {
        class_465 class_4652 = (class_465)class_3102.field_1755;
        class_1703 class_17032 = class_4652.method_17577();
        long l = System.currentTimeMillis();
        this.orx = orn != null && l - oro < 5000L ? orn : null;
        this.orp.clear();
        this.ort = 0;
        this.orv = 0;
        if (this.oqx.size() == 0) {
            this.osn(Lang.s("The list is empty: pick items in the module", "Список пуст — выберите предметы в модуле"), false);
            return;
        }
        if (!class_17032.method_34255().method_7960()) {
            this.osn(Lang.s("Put the item on the cursor down", "Уберите предмет с курсора"), false);
            return;
        }
        for (class_1735 class_17352 : SlotUtil.own(class_17032, class_3102.field_1724.method_31548())) {
            if (!class_17352.method_7681() || !this.osj(class_17352)) continue;
            this.orp.add(class_17352.field_7874);
        }
        this.oru = this.orp.size();
        if (this.oru == 0) {
            this.ory = Lang.s("Looter · nothing to take", "Лутер · брать нечего");
            this.orz = l + 1800L;
            this.osm(1);
            return;
        }
        this.orq = true;
        this.ors = class_17032.field_7763;
        this.orw = l;
    }

    private void osl(class_310 class_3102, class_465<?> class_4652) {
        this.orq = false;
        long l = System.currentTimeMillis();
        if (this.orv > 0) {
            this.ory = Lang.s("Looter · left ", "Лутер · осталось ") + this.orv + Lang.s(" (no room)", " (нет места)");
            this.osm(2);
            this.osn(Lang.s("Taken ", "Забрано ") + this.ort + Lang.s(", no room for ", ", не влезло: ") + this.orv, false);
        } else {
            this.ory = Lang.s("Looter · taken ", "Лутер · забрано ") + this.ort;
            this.osm(1);
            this.osn(Lang.s("Taken ", "Забрано ") + this.ort, true);
            if (this.ora.get()) {
                class_4652.method_25419();
            }
        }
        this.orz = l + 2000L;
    }

    private void osm(int n) {
        if (this.orx == null || !this.orb.get()) {
            return;
        }
        if (orl.size() >= 1024) {
            Iterator<class_2338> iterator = orl.keySet().iterator();
            iterator.next();
            iterator.remove();
        }
        orl.put(this.orx, new oqq(n, System.currentTimeMillis()));
    }

    private void osn(String string, boolean bl) {
        if (this.orc.get()) {
            Hud.alert(this.getName(), string, bl ? Icon.CHECK : Icon.INFO, bl);
        }
    }

    private void oso(class_332 class_3322) {
        if (this.ory == null || System.currentTimeMillis() > this.orz) {
            return;
        }
        DrawUtil.beginFrame();
        float f = ork.width(this.ory) + 16.0f;
        float f2 = 13.0f;
        float f3 = ((float)class_3322.method_51421() - f) * 0.5f;
        float f4 = 6.0f;
        DrawUtil.shadow(class_3322, f3, f4 + 1.0f, f, f2, f2 * 0.5f, 6.0f, 0x60000000);
        DrawUtil.round(class_3322, f3, f4, f, f2, f2 * 0.5f, ColorUtil.withAlpha(Theme.window, 240));
        DrawUtil.outline(class_3322, f3, f4, f, f2, f2 * 0.5f, 1.0f, Theme.accent(150));
        ork.drawCentered(class_3322, this.ory, f3 + f * 0.5f, ork.centerTop(f4 + f2 * 0.5f), -855307);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void render(class_332 class_3322, class_9779 class_97792) {
        ScreenProjection usn2;
        AutoLoot oqv2 = oqw;
        class_310 class_3102 = class_310.method_1551();
        if (oqv2 == null || !oqv2.isEnabled() || !oqv2.orb.get() || orl.isEmpty() || class_3102.field_1687 == null || class_3102.field_1724 == null || class_3102.field_1690.field_1842 || class_3102.field_1755 instanceof ClickGuiScreen) {
            return;
        }
        FrameDelta.observe(class_3322);
        if (FrameDelta.frame() == oqv2.osa) {
            return;
        }
        oqv2.osa = FrameDelta.frame();
        try {
            usn2 = ScreenProjection.capture(class_97792.method_60637(true), class_3322.method_51421(), class_3322.method_51443());
        }
        catch (Throwable throwable) {
            return;
        }
        DrawUtil.beginFrame();
        DrawUtil.beginBatch();
        try {
            long l = System.currentTimeMillis();
            for (Map.Entry<class_2338, oqq> entry : orl.entrySet()) {
                class_2338 class_23382 = entry.getKey();
                if (usn2.distance((double)class_23382.method_10263() + 0.5, (double)class_23382.method_10264() + 0.5, (double)class_23382.method_10260() + 0.5) > 160.0) continue;
                float f = Math.min(1.0f, (float)(l - entry.getValue().at()) / 650.0f);
                int n = entry.getValue().state() == 1 ? -45730 : -15795;
                oqv2.osp(class_3322, usn2, class_23382, n, f);
            }
        }
        finally {
            DrawUtil.endBatch();
        }
    }

    private void osp(class_332 class_3322, ScreenProjection usn2, class_2338 class_23382, int n, float f) {
        double d = 0.06 * (1.0 - (double)f);
        double d2 = (double)class_23382.method_10263() + 0.0625 - d;
        double d3 = (double)class_23382.method_10264() - d;
        double d4 = (double)class_23382.method_10260() + 0.0625 - d;
        double d5 = (double)class_23382.method_10263() + 0.9375 + d;
        double d6 = (double)class_23382.method_10264() + 0.875 + d;
        double d7 = (double)class_23382.method_10260() + 0.9375 + d;
        int n2 = ColorUtil.withAlpha(n, Math.round(210.0f * f));
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
            DrawUtil.line(class_3322, this.osc[0], this.osc[1], this.osc[2], this.osc[3], 1.1f, n2);
        }
        if (usn2.project((double)class_23382.method_10263() + 0.5, (double)class_23382.method_10264() + 1.15, (double)class_23382.method_10260() + 0.5, this.osb)) {
            DrawUtil.circle(class_3322, this.osb[0], this.osb[1], 2.2f, ColorUtil.withAlpha(n, Math.round(230.0f * f)));
        }
    }

    static {
        ork = Fonts.medium(6.0f);
        orl = new HashMap<class_2338, oqq>();
        ose = new int[][]{{0, 1}, {2, 3}, {4, 5}, {6, 7}, {0, 2}, {1, 3}, {4, 6}, {5, 7}, {0, 4}, {1, 5}, {2, 6}, {3, 7}};
    }

    private static /* synthetic */ int beo(int n, int n2) {
        return n - n2 ^ 0xEB2BA46E;
    }

    private static /* synthetic */ int bep(int n, int n2) {
        return n * n2 ^ 0x59696E3B;
    }
}

