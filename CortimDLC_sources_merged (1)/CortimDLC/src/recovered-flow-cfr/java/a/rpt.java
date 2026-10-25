/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.registry.Registries
 */
package a;

import a.kfa;
import a.kfe;
import a.ujt;
import a.vgj;
import a.vhe;
import a.vhf;
import a.vkl;
import a.vla;
import a.vmc;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;

public class rpt
extends kfe
implements vhe {
    private final vla rpu = this.add(new vla("Color", "Aurora"));
    private final vkl rpv = this.add(new vkl("Item color", false));
    private final vmc rpw = this.add(new vmc("Fill", 0.4, 0.0, 1.0, 0.05).percent());
    private final vmc rpx = this.add(new vmc("Glow", 0.6, 0.0, 1.0, 0.05).percent());
    private final vmc rpy = this.add(new vmc("Edge", 0.7, 0.0, 1.0, 0.05).percent());
    private final vmc rpz = this.add(new vmc("Speed", 1.0, 0.2, 3.0, 0.1).unit("x"));
    private float rqa;
    private long rqb;
    private static /* synthetic */ String rqc;
    private static /* synthetic */ String rqd;

    public rpt() {
        super(new String(new char[]{'S', 'h', 'a', 'd', 'e', 'r', 'H', 'a', 'n', 'd', 's'}), "A soft glow around your hands", kfa.RENDER);
        vhf.register(this);
        this.rpu.visibleWhen(() -> !this.rpv.get());
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        vgj.ensureInstalled(minecraftClient);
    }

    @Override
    public boolean active() {
        return this.isEnabled();
    }

    @Override
    public float time() {
        long l = System.nanoTime();
        if (this.rqb != 0L) {
            this.rqa += Math.min(0.1f, (float)(l - this.rqb) / 1.0E9f) * (float)this.rpz.get();
        }
        this.rqb = l;
        return this.rqa % 3600.0f;
    }

    @Override
    public float fill() {
        return (float)this.rpw.get();
    }

    @Override
    public float glow() {
        return (float)this.rpx.get();
    }

    @Override
    public float rim() {
        return (float)this.rpy.get();
    }

    @Override
    public int[] colors(ClientPlayerEntity clientPlayerEntity) {
        int n;
        if (this.rpv.get() && (n = rpt.rqe(clientPlayerEntity.method_6047().method_7960() ? clientPlayerEntity.method_6079() : clientPlayerEntity.method_6047())) != 0) {
            return new int[]{n, ujt.lerp(n, -1, 0.45f)};
        }
        return new int[]{this.rpu.color() | 0xFF000000, this.rpu.color2() | 0xFF000000};
    }

    private static int rqe(ItemStack itemStack) {
        if (itemStack.method_7960()) {
            return 0;
        }
        String string = Registries.field_41178.method_10221((Object)itemStack.method_7909()).method_12832();
        if (string.contains("netherite")) {
            return -7573584;
        }
        if (string.contains("diamond")) {
            return -11149328;
        }
        if (string.contains("gold")) {
            return -11443;
        }
        if (string.contains("iron")) {
            return -2564890;
        }
        if (string.contains("emerald")) {
            return -12723068;
        }
        if (string.contains("mace") || string.contains("wind")) {
            return -4601601;
        }
        if (string.contains("trident")) {
            return -10559288;
        }
        if (string.contains("totem")) {
            return -8090;
        }
        return 0;
    }

    private static /* synthetic */ int cas(int n, int n2) {
        return n * n2 | 0xC6F65A43;
    }

    private static /* synthetic */ int cat(int n, int n2) {
        return rpt.cas(n, n2) ^ 0x2D7D1DFD;
    }

    private static /* synthetic */ int cau(int n, int n2) {
        return n ^ n2 | 0xADD2BB5F;
    }
}

