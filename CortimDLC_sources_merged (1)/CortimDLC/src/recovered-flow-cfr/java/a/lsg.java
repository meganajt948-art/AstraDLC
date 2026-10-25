/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 */
package a;

import a.hlc;
import a.kfa;
import a.kfe;
import a.vkl;
import a.vlv;
import a.vmc;
import a.voa;
import a.vpo;
import flow.dev.a;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

public class lsg
extends kfe {
    private static lsg lsh;
    private final vlv lsi = this.add(new vlv(a.d("\u770a\u0e80\u845b\u1a2a\u91f6\u174e", -1385517365, 1254218131), a.d("\ufa90\u8307\u09dd\u97a5\u1c64\u9ad2\u209c\ua965\u3737", 760641135, 1036029109), (String[])lsg.lst(false).toArray(String[]::new)));
    private final vkl lsj = this.add(new vkl(a.c(562964867, "\u29ca\u5053\uda8b\u44e1"), true));
    private final vlv lsk = this.add(new vlv(a.b("\ude10\ua780\u2d4e", 138731099), a.b("\ue9b9\u9021\u1af2", -481695243), (String[])lsg.lst(true).toArray(String[]::new)));
    private final vmc lsl = this.add(new vmc(a.d("\uf796\u8e1e\u04ce\u9aa6\u1169\u97d0", 522986322, -1863920492), 0.6, 0.0, 1.5, 0.05).percent());
    private long lsm;
    private long lsn;
    private int lso = vpo.version();
    private String lsp;
    private String lsq;
    private static /* synthetic */ boolean lsr;
    private static /* synthetic */ long lss;

    public lsg() {
        super(a.d("\u8fc9\uf657\u7c81\ue2fc\u6920\uef8b\u55ff\udc32\u4277\uc8dd\u4f04\ub562", -925663867, 1116205571), a.c(1724206838, "\u4ebe\u3733\ubdfa\u2390\ua84d\u2eeb\u94eb\u1d5c\u830a\u09a6\u8e27\u7402\uface\u6377\ue924\u6fde\ud598\u5a5f\uc0bf\u46af\ucf57\ub50c\u3bfb\ua062\u261c\uacd0\u1564"), kfa.MISC);
        lsh = this;
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        boolean bl = minecraftClient.currentScreen instanceof hlc;
        long l = System.currentTimeMillis();
        if (bl && l - this.lsn > 1200L) {
            this.lsn = l;
            vpo.scan();
        }
        if (this.lso != vpo.version()) {
            this.lsu();
        }
        if (this.lsp != null && !this.lsi.is(this.lsp) && bl && !this.lsi.is(a.d("\ue0f2\u996a\u13b9", 1333226027, 1328777877))) {
            voa.play(this.lsi.get(), true, (float)this.lsl.get());
        } else if (this.lsq != null && !this.lsk.is(this.lsq) && bl && !this.lsk.is(a.c(-1571883179, "\uf719\u8e81\u0452"))) {
            voa.play(this.lsk.get(), true, (float)this.lsl.get());
        }
        this.lsp = this.lsi.get();
        this.lsq = this.lsk.get();
    }

    private static List<String> lst(boolean bl) {
        vpo.scan();
        ArrayList<String> arrayList = new ArrayList<String>();
        if (bl) {
            arrayList.add(a.c(1391280322, "\u408e\u3916\ub3c5"));
        }
        arrayList.addAll(voa.BUILT_IN);
        arrayList.addAll(vpo.extras());
        if (!bl) {
            arrayList.add(a.c(1263274936, "\u0bf4\u726c\uf8bf"));
        }
        return arrayList;
    }

    private void lsu() {
        this.lsi.setModes(lsg.lst(false));
        this.lsk.setModes(lsg.lst(true));
        this.lso = vpo.version();
    }

    private static void lsv() {
        lsg lsg2 = lsh;
        vpo.scan();
        if (lsg2 != null) {
            lsg2.lsu();
            if (!lsg2.lsi.is(a.c(-2024810460, "\ud868\ua1f0\u2b23"))) {
                voa.play(lsg2.lsi.get(), true, (float)lsg2.lsl.get());
            }
        }
    }

    private static boolean lsw() {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        return lsh != null && lsh.isEnabled() && minecraftClient.player != null;
    }

    public static void toggled(kfe kfe2) {
        lsg lsg2 = lsh;
        if (!lsg.lsw() || kfe2 == lsg2 && !kfe2.isEnabled() || lsg2.lsi.is(a.d("\u82a5\ufb3d\u71ee", -935904730, 1123596495))) {
            return;
        }
        long l = System.currentTimeMillis();
        if (l - lsg2.lsm < 60L) {
            return;
        }
        lsg2.lsm = l;
        voa.play(lsg2.lsi.get(), kfe2.isEnabled(), (float)lsg2.lsl.get());
    }

    public static void menu(boolean bl) {
        lsg lsg2 = lsh;
        if (!lsg.lsw() || !lsg2.lsj.get() || lsg2.lsi.is(a.b("\u4ded\u3475\ubea6", -633451103))) {
            return;
        }
        voa.menu(lsg2.lsi.get(), bl, (float)lsg2.lsl.get());
    }

    public static void hit(Entity entity) {
        lsg lsg2 = lsh;
        if (!lsg.lsw() || lsg2.lsk.is(a.b("\u3563\u4cfb\uc628", 2053059887)) || !(entity instanceof LivingEntity)) {
            return;
        }
        voa.play(lsg2.lsk.get(), true, (float)lsg2.lsl.get());
    }

    private static /* synthetic */ int azf(int n, int n2) {
        return n + n2 + -1273447958;
    }
}

