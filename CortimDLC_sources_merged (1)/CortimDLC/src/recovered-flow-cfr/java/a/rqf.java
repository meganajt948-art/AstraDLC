/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.enums.CameraSubmersionType
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.render.Camera
 *  net.minecraft.world.dimension.DimensionType$Skybox
 *  org.joml.Matrix4f
 *  org.joml.Quaternionfc
 */
package a;

import a.kfa;
import a.kfe;
import a.ujl;
import a.uxi;
import a.uxt;
import a.vkl;
import a.vla;
import a.vlv;
import a.vmc;
import net.minecraft.block.enums.CameraSubmersionType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.world.dimension.DimensionType;
import org.joml.Matrix4f;
import org.joml.Quaternionfc;

public class rqf
extends kfe {
    private static final String rqg = "Own";
    private final vlv rqh;
    private final vlv rqi;
    private final vla rqj;
    private final vmc rqk;
    private final vmc rql;
    private final vmc rqm;
    private final vmc rqn;
    private final vkl rqo;
    private final vlv rqp;
    private final Matrix4f rqq;
    private long rqr;
    private float rqs;
    private static /* synthetic */ int rqt;
    private static /* synthetic */ long rqu;

    public rqf() {
        super(new String(new char[]{'S', 'h', 'a', 'd', 'e', 'r', 'S', 'k', 'y'}), "Animated shader sky", kfa.RENDER);
        this.rqh = this.add(new vlv("Sky", uxt.AURORA.title, uxt.titles()));
        this.rqi = this.add(new vlv("Palette", rqg, rqg, "Custom"));
        this.rqj = this.add(new vla("Colour", "Violet"));
        this.rqk = this.add(new vmc("Brightness", 1.0, 0.3, 1.6, 0.05).percent());
        this.rql = this.add(new vmc("Speed", 1.0, 0.0, 4.0, 0.1).unit("x"));
        this.rqm = this.add(new vmc("Stars", 1.0, 0.0, 2.0, 0.05).percent());
        this.rqn = this.add(new vmc("Horizon blend", 1.0, 0.0, 1.0, 0.05).percent());
        this.rqo = this.add(new vkl("Hide clouds", true));
        this.rqp = this.add(new vlv("Quality", "High", "Low", "High"));
        this.rqq = new Matrix4f();
        this.rqj.visibleWhen(() -> this.rqi.is("Custom"));
        this.rqm.activeWhen(() -> uxt.of((String)this.rqh.get()).stars > 0.0f);
    }

    @Override
    protected void onEnable() {
        this.rqr = 0L;
        uxi.release();
    }

    @Override
    protected void onDisable() {
        ujl.hide(this, false);
    }

    @Override
    public void onWorldRender(MinecraftClient minecraftClient) {
        Camera camera = minecraftClient.gameRenderer.getCamera();
        DimensionType.Skybox skybox = minecraftClient.world.getDimension().skybox();
        boolean bl = skybox != DimensionType.Skybox.NONE && camera.isReady() && camera.getSubmersionType() == CameraSubmersionType.NONE;
        ujl.hide(this, bl && this.rqo.get());
        long l = System.nanoTime();
        this.rqs += this.rqr == 0L ? 0.0f : Math.min(0.1f, (float)(l - this.rqr) / 1.0E9f) * (float)this.rql.get();
        this.rqr = l;
        if (!bl) {
            return;
        }
        uxt uxt2 = uxt.of(this.rqh.get());
        int n = uxt2.color1;
        int n2 = uxt2.color2;
        if (this.rqi.is("Custom")) {
            int[] nArray = this.rqj.vivid(new int[]{uxt2.color1, uxt2.color2});
            n = nArray[0];
            n2 = nArray[1];
        }
        this.rqq.rotation((Quaternionfc)camera.getRotation());
        float f = skybox == DimensionType.Skybox.OVERWORLD ? (float)this.rqn.get() : 0.0f;
        uxi.draw(this.rqq, uxt2, 40.0f + this.rqs, (float)this.rqk.get(), f, n, n2, this.rqp.is("Low") ? 3 : 4, uxt2.stars * (float)this.rqm.get());
    }

    private static /* synthetic */ int cax(int n, int n2) {
        return n ^ n2 | 0x7CA23A98;
    }
}

