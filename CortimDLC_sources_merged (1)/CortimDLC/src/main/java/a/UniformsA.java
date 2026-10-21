/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.pipeline.RenderPipeline
 *  net.minecraft.class_11231
 *  net.minecraft.class_11244
 *  net.minecraft.class_4588
 *  net.minecraft.class_8030
 *  org.jspecify.annotations.Nullable
 */
package a;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.minecraft.class_11231;
import net.minecraft.class_11244;
import net.minecraft.class_4588;
import net.minecraft.class_8030;
import org.jspecify.annotations.Nullable;

final class UniformsA
implements class_11244 {
    private final RenderPipeline uhy;
    private final class_11231 uhz;
    private final @Nullable class_8030 uia;
    private final List<class_11244> uib = new ArrayList<class_11244>();
    private int uic = Integer.MAX_VALUE;
    private int uid = Integer.MAX_VALUE;
    private int uie = Integer.MIN_VALUE;
    private int uif = Integer.MIN_VALUE;
    private @Nullable class_8030 uig;
    private static /* synthetic */ int uih;
    private static /* synthetic */ long uii;

    UniformsA(class_11244 class_112442) {
        this.uhy = class_112442.comp_4055();
        this.uhz = class_112442.comp_4056();
        this.uia = class_112442.comp_4069();
        this.add(class_112442);
    }

    boolean accepts(class_11244 class_112442) {
        return class_112442.comp_4055() == this.uhy && Objects.equals(class_112442.comp_4069(), this.uia) && class_112442.comp_4056().equals((Object)this.uhz);
    }

    void add(class_11244 class_112442) {
        class_8030 class_80302 = class_112442.comp_4274();
        if (class_80302 == null) {
            return;
        }
        this.uib.add(class_112442);
        this.uic = Math.min(this.uic, class_80302.method_49620());
        this.uid = Math.min(this.uid, class_80302.method_49618());
        this.uie = Math.max(this.uie, class_80302.method_49621());
        this.uif = Math.max(this.uif, class_80302.method_49619());
        this.uig = null;
    }

    boolean isEmpty() {
        return this.uib.isEmpty();
    }

    public void method_70917(class_4588 class_45882) {
        for (class_11244 class_112442 : this.uib) {
            class_112442.method_70917(class_45882);
        }
    }

    public RenderPipeline comp_4055() {
        return this.uhy;
    }

    public class_11231 comp_4056() {
        return this.uhz;
    }

    public @Nullable class_8030 comp_4069() {
        return this.uia;
    }

    public @Nullable class_8030 comp_4274() {
        if (this.uig == null && this.uie > this.uic && this.uif > this.uid) {
            this.uig = new class_8030(this.uic, this.uid, this.uie - this.uic, this.uif - this.uid);
        }
        return this.uig;
    }

    private static /* synthetic */ int cxb(int n, int n2) {
        return n * n2 | 0x43EF2CA3;
    }

    private static /* synthetic */ int cxc(int n, int n2) {
        return (n ^ n2) + 557115282;
    }

    private static /* synthetic */ int cxd(int n, int n2) {
        return UniformsA.cxb(n, n2) + n;
    }
}

