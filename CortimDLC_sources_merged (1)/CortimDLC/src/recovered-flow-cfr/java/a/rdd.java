/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.s2c.play.WorldTimeUpdateS2CPacket
 */
package a;

import a.kfa;
import a.kfe;
import a.vmc;
import a.wcn;
import java.util.Locale;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.WorldTimeUpdateS2CPacket;

public class rdd
extends kfe {
    private static final long rde = 24000L;
    private final vmc rdf = this.add(new vmc("Time", 12.0, 0.0, 24.0, 0.25).format(rdd::rdr));
    private static volatile boolean rdg;
    private static volatile long rdh;
    private static volatile long rdi;
    private static volatile boolean rdj;
    private static volatile long rdk;
    private static /* synthetic */ boolean rdl;
    private static /* synthetic */ int rdm;

    public rdd() {
        super(new String(new char[]{'C', 'u', 's', 't', 'o', 'm', 'T', 'i', 'm', 'e'}), "Your own time of day, on your screen", kfa.RENDER);
        wcn.rewrite(rdd::rdo);
    }

    @Override
    protected void onEnable() {
        ClientWorld clientWorld = this.mc.field_1687;
        if (clientWorld != null) {
            rdi = clientWorld.method_8532();
            rdj = true;
            rdk = clientWorld.method_75260();
            wcn.ensure(this.mc);
        }
        rdh = this.rdq();
        rdg = true;
        rdd.rdn(this.mc);
    }

    @Override
    protected void onDisable() {
        rdg = false;
        ClientWorld clientWorld = this.mc.field_1687;
        if (clientWorld != null) {
            long l = rdj ? Math.max(0L, clientWorld.method_75260() - rdk) : 0L;
            clientWorld.method_29089(clientWorld.method_75260(), rdi + l, rdj);
        }
    }

    @Override
    public void onStartTick(MinecraftClient minecraftClient) {
        wcn.ensure(minecraftClient);
        rdh = this.rdq();
        rdd.rdn(minecraftClient);
    }

    private static void rdn(MinecraftClient minecraftClient) {
        ClientWorld clientWorld = minecraftClient.field_1687;
        if (clientWorld == null) {
            return;
        }
        long l = rdd.rdp(clientWorld.method_8532());
        if (clientWorld.method_8532() != l) {
            clientWorld.method_29089(clientWorld.method_75260(), l, false);
        }
    }

    private static Packet<?> rdo(Packet<?> packet) {
        if (!rdg || !(packet instanceof WorldTimeUpdateS2CPacket)) {
            return packet;
        }
        WorldTimeUpdateS2CPacket worldTimeUpdateS2CPacket = (WorldTimeUpdateS2CPacket)packet;
        rdi = worldTimeUpdateS2CPacket.comp_3220();
        rdj = worldTimeUpdateS2CPacket.comp_3221();
        rdk = worldTimeUpdateS2CPacket.comp_3219();
        return new WorldTimeUpdateS2CPacket(worldTimeUpdateS2CPacket.comp_3219(), rdd.rdp(worldTimeUpdateS2CPacket.comp_3220()), false);
    }

    private static long rdp(long l) {
        return Math.floorDiv(l, 24000L) * 24000L + rdh;
    }

    private long rdq() {
        return Math.floorMod(Math.round((this.rdf.get() - 6.0) * 1000.0), 24000L);
    }

    private static String rdr(double d) {
        int n = (int)Math.round(d * 60.0) % 1440;
        return String.format(Locale.ROOT, "%02d:%02d", n / 60, n % 60);
    }

    static {
        rdj = true;
    }

    private static /* synthetic */ int bxl(int n, int n2) {
        return n * n2 | 0x34EFBC0D;
    }

    private static /* synthetic */ int bxm(int n, int n2) {
        return n - n2 + 1913111389;
    }
}

