/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Position
 *  net.minecraft.world.LightType
 *  net.minecraft.world.attribute.EnvironmentAttributes
 */
package a;

import a.kfa;
import a.kfe;
import a.vlv;
import a.vmc;
import a.vxz;
import a.wbu;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Position;
import net.minecraft.world.LightType;
import net.minecraft.world.attribute.EnvironmentAttributes;

public class reo
extends kfe {
    private final vlv rep = this.add(new vlv("Mode", "Auto", "Auto", "Full"));
    private final vmc req = this.add(new vmc("Night", 0.25, 0.0, 1.0, 0.05).percent());
    private final vmc rer = this.add(new vmc("Caves", 0.6, 0.0, 1.0, 0.05).percent());
    private final vmc res = this.add(new vmc("Strength", 1.0, 0.1, 1.0, 0.05).percent());
    private double ret = -1.0;
    private double reu = -1.0;
    private static /* synthetic */ boolean rev;
    private static /* synthetic */ boolean rew;

    public reo() {
        super(new String(new char[]{'F', 'u', 'l', 'l', 'B', 'r', 'i', 'g', 'h', 't'}), "Brighter nights and caves", kfa.RENDER);
        this.req.visibleWhen(() -> this.rep.is("Auto"));
        this.rer.visibleWhen(() -> this.rep.is("Auto"));
        this.res.visibleWhen(() -> this.rep.is("Full"));
    }

    @Override
    protected void onDisable() {
        vxz.release();
        this.ret = -1.0;
        this.reu = -1.0;
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        double d;
        double d2;
        if (wbu.suspended(minecraftClient)) {
            vxz.release();
            this.ret = -1.0;
            return;
        }
        double d3 = vxz.own();
        if (this.rep.is("Full")) {
            d2 = Math.max(d3, 1.0 + 15.0 * this.res.get());
            d = 0.35;
            this.reu = -1.0;
        } else {
            d2 = this.rex(minecraftClient, d3);
            d = 0.12;
        }
        if (this.ret < 0.0) {
            this.ret = d3;
        }
        this.ret += (d2 - this.ret) * d;
        vxz.override(this.ret);
    }

    private double rex(MinecraftClient minecraftClient, double d) {
        ClientWorld clientWorld = minecraftClient.field_1687;
        BlockPos blockPos = minecraftClient.field_1724.method_24515();
        BlockPos blockPos2 = BlockPos.method_49638((Position)minecraftClient.field_1724.method_33571());
        int n = Math.max(clientWorld.method_8314(LightType.field_9282, blockPos), clientWorld.method_8314(LightType.field_9282, blockPos2));
        int n2 = Math.max(clientWorld.method_8314(LightType.field_9284, blockPos), clientWorld.method_8314(LightType.field_9284, blockPos2));
        double d2 = Math.max((float)n, (float)n2 * reo.rey(minecraftClient));
        this.reu = this.reu < 0.0 ? d2 : this.reu + (d2 - this.reu) * 0.15;
        double d3 = 1.0 - reo.rez(2.0, 12.0, this.reu);
        double d4 = 1.0 - reo.rez(4.0, 10.0, n2);
        double d5 = 1.0 + 2.0 * this.req.get();
        double d6 = 1.0 + 11.0 * this.rer.get();
        double d7 = d5 + (d6 - d5) * d4;
        return Math.max(d, d + (d7 - d) * d3);
    }

    private static float rey(MinecraftClient minecraftClient) {
        try {
            Float f = (Float)minecraftClient.field_1773.method_19418().method_75756().method_75689(EnvironmentAttributes.field_64346, 1.0f);
            return f == null ? 1.0f : Math.max(0.0f, Math.min(1.0f, f.floatValue()));
        }
        catch (RuntimeException runtimeException) {
            return 1.0f;
        }
    }

    private static double rez(double d, double d2, double d3) {
        double d4 = Math.max(0.0, Math.min(1.0, (d3 - d) / (d2 - d)));
        return d4 * d4 * (3.0 - 2.0 * d4);
    }

    private static /* synthetic */ int bxt(int n, int n2) {
        return n + n2 + -1251300477;
    }

    private static /* synthetic */ int bxu(int n, int n2) {
        return n - n2 ^ 0x7BC5C500;
    }
}

