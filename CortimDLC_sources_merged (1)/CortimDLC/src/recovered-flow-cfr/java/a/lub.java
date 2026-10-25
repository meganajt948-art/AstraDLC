/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.option.CloudRenderMode
 *  net.minecraft.client.render.entity.state.ArmedEntityRenderState
 *  net.minecraft.client.render.entity.state.BlockDisplayEntityRenderState
 *  net.minecraft.client.render.entity.state.EntityRenderState
 *  net.minecraft.client.render.entity.state.ItemDisplayEntityRenderState
 *  net.minecraft.client.render.entity.state.PlayerEntityRenderState
 *  net.minecraft.client.render.state.WorldRenderState
 *  net.minecraft.particle.ParticlesMode
 */
package a;

import a.kfa;
import a.kfe;
import a.vkl;
import a.vlv;
import a.vmc;
import a.wbu;
import flow.dev.a;
import java.util.Iterator;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.CloudRenderMode;
import net.minecraft.client.render.entity.state.ArmedEntityRenderState;
import net.minecraft.client.render.entity.state.BlockDisplayEntityRenderState;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.entity.state.ItemDisplayEntityRenderState;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.client.render.state.WorldRenderState;
import net.minecraft.particle.ParticlesMode;

public class lub
extends kfe {
    private final vlv luc = this.add(new vlv(a.c(-494823657, "\u975a\ueedf\u641f\ufa62\u71bd\uf749\u4d56\uc4a2\u5af9\ud04c\u5782"), a.c(-767722965, "\u7a77\u03fd\u892c\u1758\u9c8b\u1a3e\ua070\u2990\ub7ce"), a.b("\u8612\uff98\u7549\ueb3d\u60ee\ue65b\u5c15\ud5f5\u4bab", 285902414), a.b("\u8bec\uf27f\u78ad\ue6db\u6d11\uebbb\u51f5", 1356958630), a.b("\u6dbb\u142c\u9ef3\u008a", -2112721416)));
    private final vkl lud = this.add(new vkl(a.c(204055694, "\ua4c8\udd58\u57c4\uc9e3\u4231\uc48a\u7ece\uf732"), true));
    private final vkl lue = this.add(new vkl(a.d("\ufaad\u833d\u09a1\u9795\u1c49\u9ae2\u20ac\ua940\u3712\ubdfa\u3a7a\uc010\u4ece\ud77a\u5d22\udbcb\u6180", 654949909, 262489319), true));
    private final vkl luf = this.add(new vkl(a.d("\u13b4\u6a24\ue0b8\u7e8a\uf552\u73e0\uc9a9\u4049\ude01", 1454330699, 1758019768), true));
    private final vkl lug = this.add(new vkl(a.d("\ud091\ua903\u23c2\ubda1\u3661\ub082\u0a81\u8361\u1d2d\u979a\u1054\uea2f\u64f7\ufd4f\u770a", 802527693, 445204757), true));
    private final vkl luh = this.add(new vkl(a.c(1178039888, "\u7610\u0f80\u851c\u1b2f\u90f3\u1644\uac15\u25ec\ubbf6\u3105\ub6d8\u4ca0\uc27c\u5bc7"), true));
    private final vkl lui = this.add(new vkl(a.c(-1878324811, "\u09f7\u7067\ufafb\u64c7\uef18\u69a2\ud3ea\u5a4e\uc453\u4eec\uc926\u3350"), true));
    private final vkl luj = this.add(new vkl(a.d("\ub477\ucde7\u477b\ud943\u5290\ud43c\u6e6d\ue781\u79c7\uf365\u74b7\u8e82\u0001\u99b6\u13f6\u9508\u2f5a\ua088\u3a2a\ubc68\u3588\u4fd2\uc16c\u5aa7", 484727756, -1159663635), true));
    private final vkl luk = this.add(new vkl(a.c(1787067349, "\u7b81\u0213\u88d2\u16b1\u9d71\u1b92\ua187\u2871\ub63d\u3cde\ubb48\u4132\ucfff\u5653\udc1d\u5af1\ue0b2\u6f75"), true));
    private final vkl lul = this.add(new vkl(a.b("\u6b25\u12b1\u986c\u0612\u8dd9\u0b3c\ub129\u38df\ua693\u2c70\uabf3\u519e\udf44\u46ed\ucca2\u4a44\uf00a", 103377784), true));
    private final vmc lum = this.add(new vmc(a.d("\ub0ec\uc978\u43a5\udddb\u5610\ud0f5\u6ae0\ue305\u7d47\uf7f4", 1274602420, 668160798), 24.0, 8.0, 64.0, 4.0).suffix(a.b("\u0667\u7fd8\uf508\u6b75\ue0aa\u6603", 311887363)));
    private final vkl lun = this.add(new vkl(a.b("\u0cd1\u7541\uff9f\u61ef\uea7d\u6c8a\ud6de\u5f3c\uc131\u4bc4\ucc1a\u3671\ub8a5\u2108\uab56\u2dbf\u97fa", 858066056), true));
    private final vmc luo = this.add(new vmc(a.d("\u57f7\u2e6b\ua4a2\u3ad0\ub11b\u37a7\u8dec\u0417\u9a1b\u10ff\u9729\u6d08\ue38b\u7a21", 1269412753, -2100960212), 32.0, 8.0, 96.0, 4.0).suffix(a.c(-295833461, "\uf0ef\u8950\u0380\u9dfd\u1622\u908b")));
    private final vkl lup = this.add(new vkl(a.b("\u8ba7\uf231\u78f0\ue686\u6d05\uebf8\u51a2\ud857\u461f\uccbd\u4b78", 986090474), false));
    private final vkl luq = this.add(new vkl(a.b("\u4b7d\u32ed\ub871\u2653\uad9a\u2b29\u917a\u1890\u86d3\u0c2a\u8bb5\u71c1\uff18\u66a6\uece9\u6a05\ud04d\u5f95", 54479649), false));
    private static lub lur;
    private static final wbu<Integer> lus;
    private static final wbu<Boolean> lut;
    private static final wbu<Boolean> luu;
    private static final wbu<CloudRenderMode> luv;
    private static final wbu<ParticlesMode> luw;
    private static final wbu<Integer> lux;
    private static final wbu<Integer> luy;
    private static final wbu<Boolean> luz;
    private static final wbu<Double> lva;
    private static final wbu<Boolean> lvb;
    private static final wbu<Boolean> lvc;
    private static final int lvd = 260;
    private int lve = -1;
    private int lvf = -1;
    private Boolean lvg;
    private static final wbu<?>[] lvh;
    private static /* synthetic */ boolean lvi;
    private static /* synthetic */ long lvj;

    public lub() {
        super(a.d("\ue52e\u9ca0\u1677\u881b\u03c8\u857d\u3f3d\ub6d7\u289d\ua231\u25e4\udf94", -1093607958, 337918087), a.b("\u9791\uee02\u64cc\ufaaa\u7138\uf7ef\u4daa\uc458\u5a6e\ud0c5\u5743\uad29\u23f3\uba40\u3002\ub6f0\u0cec\u837b\u19dc\u9f9e\u1665\u6c3c\ue299\u7917\uff64\u75fd\ucc43\u4216\ud8f6\u5ea8\ud542\u2bd6\ua19a\u386b\ube3b\u348c\u8b4c\u013a\u87ba\u1e44\u9412\ueae3", 1014536182), kfa.MISC);
        lur = this;
        this.lum.visibleWhen(this.lul::get);
        this.luo.visibleWhen(this.lun::get);
        this.setEnabled(true);
    }

    public static void afterExtraction(WorldRenderState worldRenderState) {
        lub lub2 = lur;
        if (lub2 == null || !lub2.isEnabled() || worldRenderState == null) {
            return;
        }
        boolean bl = lub2.lul.get();
        boolean bl2 = lub2.lun.get();
        if (!bl && !bl2) {
            return;
        }
        double d = lub2.lum.get() * lub2.lum.get();
        double d2 = lub2.luo.get() * lub2.luo.get();
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        int n = minecraftClient.player != null ? minecraftClient.player.getId() : Integer.MIN_VALUE;
        Iterator iterator = worldRenderState.entityRenderStates.iterator();
        while (iterator.hasNext()) {
            EntityRenderState entityRenderState = (EntityRenderState)iterator.next();
            if (bl2 && entityRenderState.squaredDistanceToCamera > d2 && (entityRenderState instanceof ItemDisplayEntityRenderState || entityRenderState instanceof BlockDisplayEntityRenderState)) {
                iterator.remove();
                continue;
            }
            if (!bl || !(entityRenderState.squaredDistanceToCamera > d) || !(entityRenderState instanceof ArmedEntityRenderState)) continue;
            ArmedEntityRenderState armedEntityRenderState = (ArmedEntityRenderState)entityRenderState;
            if (entityRenderState instanceof PlayerEntityRenderState) {
                PlayerEntityRenderState playerEntityRenderState = (PlayerEntityRenderState)entityRenderState;
                if (playerEntityRenderState.id == n) continue;
            }
            armedEntityRenderState.rightHandItemState.clear();
            armedEntityRenderState.leftHandItemState.clear();
            armedEntityRenderState.headItemRenderState.clear();
        }
    }

    private static void lvk() {
        for (wbu<?> wbu2 : lvh) {
            wbu2.release();
        }
    }

    @Override
    protected void onDisable() {
        lub.lvk();
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient != null && minecraftClient.options != null) {
            this.lvm(minecraftClient);
            if (this.lve >= 0 && this.lve != lub.lvl()) {
                lub.lvn(minecraftClient);
            }
        }
        this.lve = -1;
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        int n;
        boolean bl = wbu.suspended(minecraftClient);
        if (bl) {
            lub.lvk();
            this.lvm(minecraftClient);
            return;
        }
        int n2 = n = minecraftClient.getWindow() != null ? minecraftClient.getWindow().getRefreshRate() : 0;
        if (this.luc.is(a.c(-597070565, "\u6d47\u14cd\u9e1ch\u8bbb\u0d0e\ub740\u3ea0\ua0fe"))) {
            lub.lvo(lus, true, 260);
        } else {
            lub.lvo(lus, this.luc.is(a.d("\u6c9a\u1509\u9fdb\u01ad\u8a67\u0ccd\ub683", 1805209597, 1108091693)) && n >= 30, Math.max(30, Math.min(260, n)));
        }
        lub.lvo(lut, this.lud.get() || this.luc.is(a.c(-2029731414, "\uc1f6\ub87c\u32ad\uacd9\u270a\ua1bf\u1bf1\u9211\u0c4f")), false);
        lub.lvo(luu, this.lue.get(), false);
        lub.lvo(luv, this.luf.get(), CloudRenderMode.OFF);
        lub.lvo(luw, this.lug.get() && luw.own() == ParticlesMode.ALL, ParticlesMode.DECREASED);
        lub.lvo(luy, this.lui.get(), 0);
        Double d = lva.own();
        lub.lvo(lva, this.luk.get() && d != null && d > 0.75, 0.75);
        lub.lvo(lux, this.luh.get(), 0);
        lub.lvo(luz, this.luj.get(), false);
        lub.lvo(lvb, this.lup.get(), false);
        lub.lvo(lvc, this.luq.get(), false);
        this.lvm(minecraftClient);
        int n3 = (Boolean.TRUE.equals(minecraftClient.options.getImprovedTransparency().getValue()) ? 1 : 0) | (Boolean.TRUE.equals(minecraftClient.options.getCutoutLeaves().getValue()) ? 2 : 0) | (Boolean.TRUE.equals(minecraftClient.options.getAo().getValue()) ? 4 : 0);
        if (this.lve < 0) {
            this.lve = lub.lvl();
        }
        if (n3 != this.lve) {
            lub.lvn(minecraftClient);
            this.lve = n3;
        }
    }

    private static int lvl() {
        return (Boolean.TRUE.equals(luz.own()) ? 1 : 0) | (Boolean.TRUE.equals(lvb.own()) ? 2 : 0) | (Boolean.TRUE.equals(lvc.own()) ? 4 : 0);
    }

    private void lvm(MinecraftClient minecraftClient) {
        Boolean bl;
        Integer n = (Integer)minecraftClient.options.getMaxFps().getValue();
        if (n != null && n != this.lvf) {
            this.lvf = n;
            minecraftClient.getInactivityFpsLimiter().setMaxFps(n.intValue());
        }
        if ((bl = (Boolean)minecraftClient.options.getEnableVsync().getValue()) != null && !bl.equals(this.lvg) && minecraftClient.getWindow() != null) {
            this.lvg = bl;
            minecraftClient.getWindow().setVsync(bl.booleanValue());
        }
    }

    private static void lvn(MinecraftClient minecraftClient) {
        if (minecraftClient.worldRenderer != null && minecraftClient.world != null) {
            minecraftClient.worldRenderer.reload();
        }
    }

    private static <T> void lvo(wbu<T> wbu2, boolean bl, T t) {
        if (bl) {
            wbu2.override(t);
        } else {
            wbu2.release();
        }
    }

    static {
        lus = new wbu(minecraftClient -> minecraftClient.options.getMaxFps());
        lut = new wbu(minecraftClient -> minecraftClient.options.getEnableVsync());
        luu = new wbu(minecraftClient -> minecraftClient.options.getEntityShadows());
        luv = new wbu(minecraftClient -> minecraftClient.options.getCloudRenderMode());
        luw = new wbu(minecraftClient -> minecraftClient.options.getParticles());
        lux = new wbu(minecraftClient -> minecraftClient.options.getBiomeBlendRadius());
        luy = new wbu(minecraftClient -> minecraftClient.options.getMenuBackgroundBlurriness());
        luz = new wbu(minecraftClient -> minecraftClient.options.getImprovedTransparency());
        lva = new wbu(minecraftClient -> minecraftClient.options.getEntityDistanceScaling());
        lvb = new wbu(minecraftClient -> minecraftClient.options.getCutoutLeaves());
        lvc = new wbu(minecraftClient -> minecraftClient.options.getAo());
        lvh = new wbu[]{lus, lut, luu, luv, luw, lux, luy, luz, lva, lvb, lvc};
    }

    private static /* synthetic */ int azn(int n, int n2) {
        return n ^ n2 | 0x8037E1F2;
    }
}

