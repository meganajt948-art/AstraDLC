/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 */
package a;

import a.hhf;
import a.kfa;
import a.kfe;
import flow.dev.a;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;

public class lfu
extends kfe {
    private static lfu lfv;
    private static /* synthetic */ String lfw;
    private static /* synthetic */ boolean lfx;

    public lfu() {
        super(a.b("\u07d5\u7e45\uf4bf\u6afa\ue136\u678b\uddd3\u5428\uca57\u40c3\uc71c\u3d61\ub3b0\u2a03", 2132412309), a.b("\u8999\uf01e\u7ad7\ue4a1\u6f24\ue9dd\u538f\uda63\u443b\uced9\u4944\ub33e\u3dfa\ua458\u2e1c\ua8bf\u12bc\u9d60\u07dc\u8187\u0834\u722a\ufc98\u6707\ue13e\u6bfb\ud253\u5c0e\uc6f2\u40a9\ucb0d", -43415073), kfa.COMBAT);
        lfv = this;
    }

    public static boolean blocks(Entity entity) {
        return lfv != null && lfv.isEnabled() && entity instanceof PlayerEntity && hhf.isFriend(entity);
    }

    private static /* synthetic */ int awk(int n, int n2) {
        return (n ^ n2) + -790638836;
    }

    private static /* synthetic */ int awl(int n, int n2) {
        return lfu.awk(n, n2) + n;
    }
}

