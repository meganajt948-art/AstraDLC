/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.render.entity.state.EntityRenderState
 *  net.minecraft.client.render.entity.state.PlayerEntityRenderState
 *  net.minecraft.client.render.state.WorldRenderState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 */
package a;

import a.hhf;
import a.kfa;
import a.kfe;
import a.ukl;
import a.vla;
import a.vmc;
import flow.cosmetic.Cosmetics;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.client.render.state.WorldRenderState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;

public class rwo
extends kfe {
    private static rwo rwp;
    private final vmc rwq = this.add(new vmc("Transparency", 0.6, 0.0, 1.0, 0.05).percent());
    private final vla rwr = this.add(new vla("Color", "Mint"));
    private final vmc rws = this.add(new vmc("Outline", 0.9, 0.0, 1.0, 0.05).percent());
    private final vmc rwt = this.add(new vmc("Width", 1.5, 0.5, 4.0, 0.1));
    private final vmc rwu = this.add(new vmc("Fill", 0.0, 0.0, 0.6, 0.01).percent());
    private final vmc rwv = this.add(new vmc("Glow", 0.35, 0.0, 1.0, 0.05).percent());
    private final vmc rww = this.add(new vmc("Glow size", 0.4, 0.0, 1.0, 0.05).percent());
    private final vmc rwx = this.add(new vmc("Animation", 1.0, 0.0, 3.0, 0.1).unit("x"));
    private static /* synthetic */ boolean rwy;
    private static /* synthetic */ long rwz;

    public rwo() {
        super(new String(new char[]{'T', 'r', 'a', 'n', 's', 'p', 'a', 'r', 'e', 'n', 't', 'F', 'r', 'i', 'e', 'n', 'd', 's'}), "Friends turn see-through", kfa.RENDER);
        rwp = this;
        this.rwt.visibleWhen(() -> this.rws.get() > 0.0);
        this.rww.visibleWhen(() -> this.rwv.get() > 0.0);
    }

    public static void afterExtraction(WorldRenderState worldRenderState) {
        rwo rwo2 = rwp;
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (rwo2 == null || !rwo2.isEnabled() || minecraftClient.world == null) {
            return;
        }
        ukl.style(1).set((float)rwo2.rwu.get(), (float)rwo2.rws.get(), (float)rwo2.rwt.get(), (float)rwo2.rwv.get(), (float)rwo2.rww.get(), (float)rwo2.rwx.get());
        int n = rwo2.rwr.color() | 0xFF000000;
        int n2 = rwo2.rwr.color2() | 0xFF000000;
        boolean bl = ukl.canFade();
        for (EntityRenderState entityRenderState : worldRenderState.entityRenderStates) {
            PlayerEntity playerEntity;
            if (!(entityRenderState instanceof PlayerEntityRenderState)) continue;
            PlayerEntityRenderState playerEntityRenderState = (PlayerEntityRenderState)entityRenderState;
            Entity entity = minecraftClient.world.getEntityById(playerEntityRenderState.id);
            if (!(entity instanceof PlayerEntity) || (playerEntity = (PlayerEntity)entity) == minecraftClient.player || !hhf.isFriend((Entity)playerEntity)) continue;
            boolean bl2 = Cosmetics.hidesBody((EntityRenderState)playerEntityRenderState);
            if (bl) {
                if (!bl2) {
                    playerEntityRenderState.invisible = false;
                    playerEntityRenderState.invisibleToPlayer = false;
                }
                ukl.fade(entityRenderState, 1.0f - (float)rwo2.rwq.get());
            } else if (rwo2.rwq.get() > 0.0 && !bl2) {
                playerEntityRenderState.invisible = true;
                playerEntityRenderState.invisibleToPlayer = false;
            }
            ukl.paint(entityRenderState, 1, n, n2);
        }
    }

    private static /* synthetic */ int ccc(int n, int n2) {
        return n - n2 + -797118068;
    }

    private static /* synthetic */ int ccd(int n, int n2) {
        return n ^ n2 ^ 0xA904A24E;
    }

    private static /* synthetic */ int cce(int n, int n2) {
        return n - n2 | 0xDDCAD6B0;
    }
}

