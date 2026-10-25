/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.item.Items
 */
package a;

import a.kfa;
import a.kfe;
import a.vlq;
import a.vzh;
import a.wap;
import flow.dev.a;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.Items;

public class kvz
extends kfe {
    private static kvz kwa;
    private final vlq kwb = this.add(new vlq(a.b("\ueb9c\u920a\u18da\u86aa\u0d78\u8bc3\u3580\ub860\u264e\uac81\u2b2d\ud127\u5ffa", 66842507)));
    private final vzh kwc = new vzh(Items.ENDER_PEARL, true);
    private static /* synthetic */ boolean kwd;
    private static /* synthetic */ long kwe;

    public kvz() {
        super(a.d("\uae17\ud788\u5d47\uc31f\u48fd\uce48\u7408\ufde7", 667402227, 1502744999), a.c(-2080823843, "\u2597\u5c1a\ud6d3\u48bf\uc370\u45c5\uffc5\u7675\ue825\u62da\ue54c\u1f36\u91eb\u085b\u821f\u04bc\ubea3\u3167\uabd0\u2d92\ua47b\ude66\u509a\ucb4a\u4d7b\uc7eb\u7e19\uf003\u6afa\uecb7"), kfa.COMBAT);
        kwa = this;
    }

    public static boolean busy() {
        return kwa != null && kvz.kwa.kwc.busy();
    }

    @Override
    protected void onEnable() {
        this.kwc.reset(this.mc);
    }

    @Override
    protected void onDisable() {
        this.kwc.reset(this.mc);
    }

    @Override
    public void onKey(MinecraftClient minecraftClient, int n) {
        if (n == this.kwb.get()) {
            this.kwc.press(minecraftClient, n, this.getName(), wap.s(a.d("\u24b6\u5d26\ud7ba\u499b\uc259\u44ec\ufeac\u7743\ue903", 361902441, -7268968), a.c(-411156954, "\u3a30\u43a9\uc90d\u531e\udcdf\u5a6d\ue037\u69bd\uf7e6\u7d27\ufaf7")));
        }
    }

    @Override
    public void onStartTick(MinecraftClient minecraftClient) {
        this.kwc.startTick(minecraftClient);
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        this.kwc.endTick(minecraftClient);
    }

    private static /* synthetic */ int avi(int n, int n2) {
        return n + n2 ^ 0xD5357292;
    }

    private static /* synthetic */ int avj(int n, int n2) {
        return kvz.avi(n, n2) ^ 0xE948822C;
    }
}

