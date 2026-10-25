/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.text.Text
 */
package a;

import a.efz;
import a.kfa;
import a.pnc;
import a.vmo;
import flow.Flow;
import flow.dev.a;
import net.minecraft.network.packet.Packet;
import net.minecraft.text.Text;

public class lqq
extends pnc {
    private static lqq lqr;
    private static /* synthetic */ boolean lqs;
    private static /* synthetic */ String lqt;

    public lqq() {
        super(a.d("\ua46c\uddf2\u572c\uc957\u428c\uc436\u7e7f\uf7bc\u69c4\ue366\u64aa\u9ed3\u1013", -1636428255, -796413439), a.b("\u72aa\u0b3c\u81fc\u1f92\u945b\u12b9\ua8ab\u2155\ubf07\u35bc\ub263\u4819\uc6d4\u5f31\ud526\u53d6\ue99e\u665f\ufcf7\u7abc\uf318\u8900\u07b4\u9c2b\u1a12\u90c9\u297f\ua720\u3dd8\ubb95\u3068\ucea3\u44ae\udd51\u5b01\ud1a8\u6e7b\ue459\u62df\ufb6b\u7164\u0fe1\u85a8\u0203\u98a0\u1690\uaf4c\u25f7\ua3fc\u3869\ub617\u4cc8\uc56b\u4369\ud9d5\u579e\uec20\u6aa5\ue081\u794f\uf7f1\u8db5\u0a12\u8017\u1ec4\u9778\u2d6e\uabdd\u2184\ube38\u34f9\ub28f\u4b04\uc1e7\u5fa3\ud441\u5205\ue8b0\u616e\uff00", -1704889668), kfa.MISC);
        if (lqr == null) {
            lqr = this;
        }
    }

    @Override
    public boolean isMaintenance() {
        return false;
    }

    public static boolean busy() {
        return false;
    }

    public static lqq get() {
        lqq lqq2 = lqr;
        if (lqq2 == null) {
            Flow flow = Flow.getInstance();
            lqq2 = flow == null || flow.getModuleManager() == null ? null : flow.getModuleManager().get(lqq.class);
        }
        return lqq2;
    }

    public int mined() {
        return 0;
    }

    public int blasts() {
        return 0;
    }

    public String lastNote() {
        return null;
    }

    public String status() {
        return "";
    }

    @Override
    public void attachBot(efz efz2) {
        super.attachBot(efz2);
        if (lqr == this) {
            lqr = null;
        }
    }

    @Override
    public void setBotRunning(boolean bl) {
        if (!bl) {
            super.setBotRunning(false);
        }
    }

    public vmo[] botSettings() {
        return new vmo[0];
    }

    public void copySettingsFrom(lqq lqq2) {
    }

    public void onPacket(Packet<?> packet) {
    }

    public static void onMessage(Text text) {
    }

    public void onChat(Text text) {
    }

    private static /* synthetic */ int ayq(int n, int n2) {
        return n + n2 ^ 0x320E8C99;
    }

    private static /* synthetic */ int ayr(int n, int n2) {
        return lqq.ayq(n, n2) ^ 0x3F14498D;
    }

    private static /* synthetic */ int ays(int n, int n2) {
        return lqq.ayq(n, n2) * n2;
    }
}

