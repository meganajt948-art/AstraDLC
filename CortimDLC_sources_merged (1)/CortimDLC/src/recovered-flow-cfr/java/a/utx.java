/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.pipeline.RenderPipeline
 *  net.minecraft.client.gui.ScreenRect
 *  net.minecraft.client.gui.render.state.SimpleGuiElementRenderState
 *  net.minecraft.client.render.VertexConsumer
 *  net.minecraft.client.texture.TextureSetup
 *  org.joml.Matrix3x2f
 *  org.joml.Vector2f
 *  org.jspecify.annotations.Nullable
 */
package a;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import net.minecraft.client.gui.ScreenRect;
import net.minecraft.client.gui.render.state.SimpleGuiElementRenderState;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.texture.TextureSetup;
import org.joml.Matrix3x2f;
import org.joml.Vector2f;
import org.jspecify.annotations.Nullable;

final class utx
extends Record
implements SimpleGuiElementRenderState {
    private final RenderPipeline uty;
    private final TextureSetup utz;
    private final Matrix3x2f uua;
    private final float uub;
    private final float uuc;
    private final float uud;
    private final float uue;
    private final int uuf;
    private final int uug;
    private final int uuh;
    private final int uui;
    private final int uuj;
    private final int uuk;
    private final float uul;
    private final float uum;
    private final float uun;
    private final @Nullable ScreenRect uuo;
    private final @Nullable ScreenRect uup;
    private static /* synthetic */ long uuq;
    private static /* synthetic */ int uur;

    utx(RenderPipeline renderPipeline, TextureSetup textureSetup, Matrix3x2f matrix3x2f, float f, float f2, float f3, float f4, int n, int n2, int n3, int n4, int n5, int n6, float f5, float f6, float f7, @Nullable ScreenRect screenRect, @Nullable ScreenRect screenRect2) {
        this.uty = renderPipeline;
        this.utz = textureSetup;
        this.uua = matrix3x2f;
        this.uub = f;
        this.uuc = f2;
        this.uud = f3;
        this.uue = f4;
        this.uuf = n;
        this.uug = n2;
        this.uuh = n3;
        this.uui = n4;
        this.uuj = n5;
        this.uuk = n6;
        this.uul = f5;
        this.uum = f6;
        this.uun = f7;
        this.uuo = screenRect;
        this.uup = screenRect2;
    }

    static float pad(float f) {
        return f + 1.5f;
    }

    public void setupVertices(VertexConsumer vertices) {
        float f = this.uub - this.uum;
        float f2 = this.uuc - this.uum;
        float f3 = this.uub + this.uud + this.uum;
        float f4 = this.uuc + this.uue + this.uum;
        float f5 = this.uub + this.uud * 0.5f;
        float f6 = this.uuc + this.uue * 0.5f;
        int n = Math.min(Short.MAX_VALUE, Math.round(this.uud * 4.0f));
        int n2 = Math.min(Short.MAX_VALUE, Math.round(this.uue * 4.0f));
        Vector2f vector2f = new Vector2f();
        this.uus(vertices, vector2f, f, f2, f - f5, f2 - f6, this.uuf, n, n2);
        this.uus(vertices, vector2f, f, f4, f - f5, f4 - f6, this.uui, n, n2);
        this.uus(vertices, vector2f, f3, f4, f3 - f5, f4 - f6, this.uuh, n, n2);
        this.uus(vertices, vector2f, f3, f2, f3 - f5, f2 - f6, this.uug, n, n2);
    }

    private void uus(VertexConsumer vertexConsumer, Vector2f vector2f, float f, float f2, float f3, float f4, int n, int n2, int n3) {
        this.uua.transformPosition(f, f2, vector2f);
        vertexConsumer.vertex(vector2f.x, vector2f.y, this.uul).color(n).texture(f3, f4).overlay(n2, n3).light(this.uuj, this.uuk).lineWidth(this.uun);
    }

    static int packRadii(float f, float f2) {
        int n = Math.max(0, Math.min(255, Math.round(f * 2.0f)));
        int n2 = Math.max(0, Math.min(255, Math.round(f2 * 2.0f)));
        return n | n2 << 8;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{utx.class, "pipeline;textureSetup;pose;x;y;w;h;cTL;cTR;cBR;cBL;radiiA;radiiB;z;pad;param;scissorArea;bounds", "uty", "utz", "uua", "uub", "uuc", "uud", "uue", "uuf", "uug", "uuh", "uui", "uuj", "uuk", "uul", "uum", "uun", "uuo", "uup"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{utx.class, "pipeline;textureSetup;pose;x;y;w;h;cTL;cTR;cBR;cBL;radiiA;radiiB;z;pad;param;scissorArea;bounds", "uty", "utz", "uua", "uub", "uuc", "uud", "uue", "uuf", "uug", "uuh", "uui", "uuj", "uuk", "uul", "uum", "uun", "uuo", "uup"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{utx.class, "pipeline;textureSetup;pose;x;y;w;h;cTL;cTR;cBR;cBL;radiiA;radiiB;z;pad;param;scissorArea;bounds", "uty", "utz", "uua", "uub", "uuc", "uud", "uue", "uuf", "uug", "uuh", "uui", "uuj", "uuk", "uul", "uum", "uun", "uuo", "uup"}, this, object);
    }

    public RenderPipeline pipeline() {
        return this.uty;
    }

    public TextureSetup textureSetup() {
        return this.utz;
    }

    public Matrix3x2f pose() {
        return this.uua;
    }

    public float x() {
        return this.uub;
    }

    public float y() {
        return this.uuc;
    }

    public float w() {
        return this.uud;
    }

    public float h() {
        return this.uue;
    }

    public int cTL() {
        return this.uuf;
    }

    public int cTR() {
        return this.uug;
    }

    public int cBR() {
        return this.uuh;
    }

    public int cBL() {
        return this.uui;
    }

    public int radiiA() {
        return this.uuj;
    }

    public int radiiB() {
        return this.uuk;
    }

    public float z() {
        return this.uul;
    }

    public float pad() {
        return this.uum;
    }

    public float param() {
        return this.uun;
    }

    public @Nullable ScreenRect scissorArea() {
        return this.uuo;
    }

    public @Nullable ScreenRect bounds() {
        return this.uup;
    }

    private static /* synthetic */ int daw(int n, int n2) {
        return (n ^ n2) + 1203766112;
    }

    private static /* synthetic */ int dax(int n, int n2) {
        return utx.daw(n, n2) + n;
    }

    private static /* synthetic */ int day(int n, int n2) {
        return utx.daw(n, n2) ^ 0xDDE2E323;
    }
}

