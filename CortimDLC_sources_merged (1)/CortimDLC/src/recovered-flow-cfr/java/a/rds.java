/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.option.Perspective
 */
package a;

import a.ett;
import a.kfa;
import a.kfe;
import a.ovh;
import a.vlq;
import a.vlv;
import a.vmc;
import a.vzz;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.Perspective;

public class rds
extends kfe {
    private final vlq rdt = this.add(new vlq("Key", 342));
    private final vlv rdu = this.add(new vlv("Press", "Hold", "Hold", "Toggle"));
    private final vlv rdv = this.add(new vlv("View", "Back", "Back", "Front", "First person"));
    private final vmc rdw = this.add(new vmc("Distance", 4.0, 1.0, 12.0, 0.5).suffix("blocks"));
    private final vmc rdx = this.add(new vmc("Sensitivity", 1.0, 0.2, 2.0, 0.05).unit("x"));
    private boolean rdy;
    private boolean rdz;
    private float rea;
    private float reb;
    private float rec;
    private float red;
    private float ree;
    private float ref;
    private Perspective reg;
    private Perspective reh;
    private static /* synthetic */ String rei;
    private static /* synthetic */ int rej;

    public rds() {
        super(new String(new char[]{'F', 'r', 'e', 'e', 'L', 'o', 'o', 'k'}), "Look around without turning your player", kfa.RENDER);
        this.rdw.visibleWhen(() -> !this.rdv.is("First person"));
    }

    @Override
    protected void onDisable() {
        this.rdz = false;
        this.ren(MinecraftClient.method_1551());
    }

    @Override
    public void onKey(MinecraftClient minecraftClient, int n) {
        if (n == this.rdt.get() && this.rdu.is("Toggle")) {
            this.rdz = !this.rdz;
        }
    }

    @Override
    public void onWorldRender(MinecraftClient minecraftClient) {
        boolean bl;
        if (!this.rdu.is("Toggle")) {
            this.rdz = false;
        }
        boolean bl2 = minecraftClient.field_1755 == null && !ovh.active() && minecraftClient.field_1724 != null && (this.rdu.is("Toggle") ? this.rdz : vzz.isDown(minecraftClient, this.rdt.get())) ? true : (bl = false);
        if (bl && !this.rdy) {
            this.rem(minecraftClient);
        } else if (!bl && this.rdy) {
            this.ren(minecraftClient);
        }
        if (this.rdy) {
            Perspective perspective = this.rel();
            if (perspective != this.reh) {
                this.reh = perspective;
                minecraftClient.field_1690.method_31043(perspective);
            }
            ett.distance(this.rdv.is("First person") ? 0.0f : (float)this.rdw.get());
            this.rek(minecraftClient.field_1724);
        }
    }

    private void rek(ClientPlayerEntity clientPlayerEntity) {
        double d = this.rdx.get();
        float f = clientPlayerEntity.method_36454();
        float f2 = clientPlayerEntity.method_36455();
        if (d != 1.0) {
            f = this.ree + (float)((double)(f - this.ree) * d);
            f2 = Math.max(-90.0f, Math.min(90.0f, this.ref + (float)((double)(f2 - this.ref) * d)));
            clientPlayerEntity.method_36456(f);
            clientPlayerEntity.method_36457(f2);
        }
        this.ree = f;
        this.ref = f2;
    }

    @Override
    public void onStartTick(MinecraftClient minecraftClient) {
        if (!this.rdy) {
            return;
        }
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        this.rec = clientPlayerEntity.method_36454();
        this.red = clientPlayerEntity.method_36455();
        clientPlayerEntity.method_36456(this.rea);
        clientPlayerEntity.method_36457(this.reb);
        clientPlayerEntity.field_5982 = this.rea;
        clientPlayerEntity.field_6004 = this.reb;
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        if (!this.rdy) {
            return;
        }
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        this.rea = clientPlayerEntity.method_36454();
        this.reb = clientPlayerEntity.method_36455();
        clientPlayerEntity.method_36456(this.rec);
        clientPlayerEntity.method_36457(this.red);
        clientPlayerEntity.field_5982 = this.rec;
        clientPlayerEntity.field_6004 = this.red;
        this.ree = this.rec;
        this.ref = this.red;
    }

    private Perspective rel() {
        return switch (this.rdv.get()) {
            case "Front" -> Perspective.field_26666;
            case "First person" -> Perspective.field_26664;
            default -> Perspective.field_26665;
        };
    }

    private void rem(MinecraftClient minecraftClient) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        if (clientPlayerEntity == null) {
            return;
        }
        this.rdy = true;
        this.rea = clientPlayerEntity.method_36454();
        this.reb = clientPlayerEntity.method_36455();
        this.rec = this.rea;
        this.red = this.reb;
        this.ree = this.rea;
        this.ref = this.reb;
        this.reg = minecraftClient.field_1690.method_31044();
        this.reh = this.rel();
        minecraftClient.field_1690.method_31043(this.reh);
    }

    private void ren(MinecraftClient minecraftClient) {
        if (!this.rdy) {
            return;
        }
        this.rdy = false;
        ett.distance(0.0f);
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        if (clientPlayerEntity != null) {
            clientPlayerEntity.method_36456(this.rea);
            clientPlayerEntity.method_36457(this.reb);
            clientPlayerEntity.field_5982 = this.rea;
            clientPlayerEntity.field_6004 = this.reb;
        }
        if (this.reg != null) {
            minecraftClient.field_1690.method_31043(this.reg);
            this.reg = null;
        }
        this.reh = null;
    }

    private static /* synthetic */ int bxp(int n, int n2) {
        return n * n2 ^ 0x8971386D;
    }

    private static /* synthetic */ int bxq(int n, int n2) {
        return rds.bxp(n, n2) * n2;
    }
}

