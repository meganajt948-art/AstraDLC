/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_310
 *  net.minecraft.class_437
 *  net.minecraft.class_746
 */
package a;

import a.ivw;
import a.ivx;
import a.WheelScreen;
import a.Hud;
import a.ModuleCategory;
import a.Module;
import a.kpx;
import a.kqa;
import a.AutoTotem;
import a.KeyPearl;
import a.ServerHelper;
import a.Icon;
import a.KeySetting;
import a.ModeSetting;
import a.TextSetting;
import a.IdleTracker;
import a.Lang;
import a.InventoryClicks;
import flow.dev.StringDecryptor;
import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_310;
import net.minecraft.class_437;
import net.minecraft.class_746;

public class TotemSwap
extends Module
implements ivw {
    private static final int kqi = 3;
    private static final int kqj = -1;
    private final ModeSetting kqk = this.add(new ModeSetting("From", "Sphere", kpx.names()));
    private final ModeSetting kql = this.add(new ModeSetting("To", "Totem", kpx.names()));
    private final KeySetting kqm = this.add(new KeySetting("Swap key"));
    private final KeySetting kqn = this.add(new KeySetting("Wheel key"));
    private final TextSetting[] kqo = new TextSetting[3];
    private static final int kqp = 10;
    private final IdleTracker kqq = new IdleTracker();
    private final EnumMap<kpx, class_1799> kqr = new EnumMap(kpx.class);
    private boolean kqs;
    private int kqt = -1;
    private int kqu;
    private static /* synthetic */ String kqv;
    private static /* synthetic */ long kqw;

    public TotemSwap() {
        super("AutoSwap", "Offhand swap and a 3-item wheel on a key", ModuleCategory.COMBAT);
        for (int i = 0; i < 3; ++i) {
            this.kqo[i] = this.add(new TextSetting("Wheel item " + (i + 1), "", 160));
            this.kqo[i].visibleWhen(() -> false);
        }
    }

    @Override
    public void onConfigLoaded(boolean bl) {
        if (!bl && this.getKey() != -1 && !this.kqm.isBound()) {
            this.kqm.set(this.getKey());
            this.setKey(-1);
            this.setEnabled(true);
        }
    }

    @Override
    protected void onEnable() {
        this.kqs = false;
    }

    @Override
    protected void onDisable() {
        this.kqs = false;
        this.kqq.release(this.mc);
    }

    @Override
    public boolean keysAtStart() {
        return true;
    }

    @Override
    public void onKey(class_310 class_3102, int n) {
        if (class_3102.field_1724 == null) {
            return;
        }
        if (n == this.kqn.get()) {
            if (class_3102.field_1755 == null) {
                class_3102.method_1507((class_437)new WheelScreen(this, n));
            }
            return;
        }
        if (n == this.kqm.get()) {
            this.kqt = -1;
            this.kqs = true;
            this.kqu = 0;
            if (TotemSwap.kqx(class_3102.field_1724) && !ServerHelper.busy() && !KeyPearl.busy()) {
                this.kqz(class_3102);
            }
        }
    }

    @Override
    public void onStartTick(class_310 class_3102) {
        if (!this.kqs) {
            return;
        }
        class_746 class_7462 = class_3102.field_1724;
        if (++this.kqu > 10) {
            this.kqy(class_3102);
            return;
        }
        if (!InventoryClicks.canClick(class_7462) || ServerHelper.busy() || KeyPearl.busy()) {
            return;
        }
        if (TotemSwap.kqx(class_7462)) {
            this.kqz(class_3102);
            return;
        }
        this.kqq.hold(class_3102);
        if (class_7462.method_6115()) {
            class_3102.field_1761.method_2897((class_1657)class_7462);
        }
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        if (this.kqs && TotemSwap.kqx(class_3102.field_1724) && !ServerHelper.busy() && !KeyPearl.busy()) {
            this.kqz(class_3102);
        }
    }

    @Override
    public String title() {
        return Lang.s("Swap", "Свап");
    }

    @Override
    public boolean editable() {
        return true;
    }

    @Override
    public List<ivx> slots() {
        ArrayList<ivx> arrayList = new ArrayList<ivx>(3);
        class_746 class_7462 = this.mc.field_1724;
        for (int i = 0; i < 3; ++i) {
            String string;
            class_1799 class_17992;
            int n;
            kqa kqa2 = kqa.parse(this.kqo[i].get());
            if (kqa2 == null || class_7462 == null) {
                arrayList.add(new ivx(class_1799.field_8037, "", "", 0.0f, false));
                continue;
            }
            class_1799 class_17993 = class_7462.method_6079();
            boolean bl = kqa2.matches(class_17993);
            int n2 = n = bl ? -1 : TotemSwap.krc(class_7462, kqa2::matches);
            class_1799 class_17994 = bl ? class_17993 : (n >= 0 ? class_7462.method_31548().method_5438(n) : class_1799.field_8037);
            class_1799 class_17995 = class_17992 = class_17994.method_7960() ? new class_1799((class_1935)kqa2.item()) : class_17994;
            String string2 = !class_17994.method_7960() ? class_17994.method_7964().getString() : (string = kqa2.name().isEmpty() ? class_17992.method_7964().getString() : kqa2.name());
            String string3 = bl ? Lang.s("held", "в руке") : (class_17994.method_7960() ? Lang.s("none", "нет") : "");
            arrayList.add(new ivx(class_17992, string, string3, 0.0f, !class_17994.method_7960() && !bl));
        }
        return arrayList;
    }

    @Override
    public void pick(int n) {
        if (!this.isEnabled() || n < 0 || n >= 3 || kqa.parse(this.kqo[n].get()) == null) {
            return;
        }
        this.kqt = n;
        this.kqs = true;
        this.kqu = 0;
    }

    @Override
    public void assign(int n, class_1799 class_17992) {
        if (n >= 0 && n < 3) {
            this.kqo[n].set(class_17992.method_7960() ? "" : kqa.of(class_17992).text());
        }
    }

    private static boolean kqx(class_746 class_7462) {
        return InventoryClicks.canClick(class_7462) && IdleTracker.serverIdle(class_7462) && !class_7462.method_6115();
    }

    private void kqy(class_310 class_3102) {
        this.kqs = false;
        this.kqq.release(class_3102);
    }

    /*
     * Could not resolve type clashes
     * Unable to fully structure code
     */
    private void kqz(class_310 var1_1) {
        block9: {
            block8: {
                var2_2 = var1_1.field_1724;
                var3_3 = var2_2.method_6079();
                if (this.kqt != -1) break block8;
                var6_4 = kpx.of(this.kqk);
                var7_5 = kpx.of(this.kql);
                var8_7 = var7_5.matches(var3_3) != false || var7_5.isTotem() != false && var3_3.method_31574(class_1802.field_8288) != false && var6_4.matches(var3_3) == false ? 1 : 0;
                var9_8 = var8_7 != 0 ? var6_4 : var7_5;
                var5_9 = var9_8.isTotem();
                var4_10 = var5_9 != false || TotemSwap.kra(var3_3) == false ? this.krb(var2_2, (kpx)var9_8, var3_3) : -1;
                break block9;
            }
            var6_4 = kqa.parse(this.kqo[this.kqt].get());
            if (var6_4 == null || var6_4.matches(var3_3)) {
                this.kqy(var1_1);
                return;
            }
            v0 = var5_9 = var6_4.item() == class_1802.field_8288;
            if (var5_9) ** GOTO lbl22
            if (!TotemSwap.kra(var3_3)) {
lbl22:
                // 2 sources

                v1 = TotemSwap.krc(var2_2, (Predicate<class_1799>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, matches(net.minecraft.class_1799 ), (Lnet/minecraft/class_1799;)Z)((kqa)var6_4));
            } else {
                v1 = var4_10 = -1;
            }
            if (var4_10 < 0 && (var5_9 || !TotemSwap.kra(var3_3))) {
                Hud.alert(this.getName(), Lang.s("Not in the inventory", "Нет в инвентаре"), Icon.INFO, false);
            }
        }
        if (!var5_9 && TotemSwap.kra(var3_3)) {
            Hud.alert(this.getName(), Lang.s("AutoTotem keeps the totem", "AutoTotem держит тотем"), Icon.INFO, false);
        } else if (var4_10 >= 0) {
            for (Object var9_8 : kpx.values()) {
                if (!var9_8.matches(var3_3)) continue;
                this.kqr.put((kpx)var9_8, var3_3.method_7972());
            }
            InventoryClicks.swap(var1_1, var4_10, 40);
        }
        this.kqy(var1_1);
    }

    private static boolean kra(class_1799 class_17992) {
        return AutoTotem.needsTotem() && class_17992.method_31574(class_1802.field_8288);
    }

    private int krb(class_746 class_7462, kpx kpx2, class_1799 class_17994) {
        int n;
        Predicate<class_1799> predicate = class_17993 -> !class_1799.method_31577((class_1799)class_17993, (class_1799)class_17994);
        class_1799 class_17995 = this.kqr.getOrDefault((Object)kpx2, class_1799.field_8037);
        if (!class_17995.method_7960() && predicate.test(class_17995) && (n = TotemSwap.krc(class_7462, class_17993 -> class_1799.method_31577((class_1799)class_17993, (class_1799)class_17995))) >= 0) {
            return n;
        }
        n = TotemSwap.krc(class_7462, class_17992 -> kpx2.matches((class_1799)class_17992) && predicate.test((class_1799)class_17992));
        if (n < 0 && kpx2.isTotem()) {
            n = TotemSwap.krc(class_7462, class_17992 -> class_17992.method_31574(class_1802.field_8288) && predicate.test((class_1799)class_17992));
        }
        return n;
    }

    private static int krc(class_746 class_7462, Predicate<class_1799> predicate) {
        int n;
        class_1661 class_16612 = class_7462.method_31548();
        int n2 = class_16612.method_67532();
        for (n = 9; n < 36; ++n) {
            if (!predicate.test(class_16612.method_5438(n))) continue;
            return n;
        }
        for (n = 0; n < 9; ++n) {
            if (n == n2 || !predicate.test(class_16612.method_5438(n))) continue;
            return n;
        }
        return predicate.test(class_16612.method_5438(n2)) ? n2 : -1;
    }

    private static /* synthetic */ int aug(int n, int n2) {
        return n * n2 ^ 0x4B56BF5B;
    }
}

