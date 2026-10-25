/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.entity.LivingEntity
 */
package a;

import a.kfa;
import a.kfe;
import a.vxr;
import flow.dev.a;
import java.lang.reflect.Field;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;

public class lxp
extends kfe {
    private static final Field lxq = vxr.find(LivingEntity.class, a.c(-241501356, "\ufb22\u8298\u085a\u9671\u1de5\u9b50\u2104\ua8fe\u36a7\ubc07\u3bc7\uc1b1\u4f74\ud69f\u5c81\uda7f\u603d\ueffe\u754d\uf330\u7aa9\u00fa\u8e4a\u1592"), a.d("\u47e0\u3e5e\ub481\u2af9\ua126\u27ac\u9d96\u1463\u8a3c\u0087", -1290091562, -794459046), a.d("\u93f1", 225365363, 564092618));
    private static lxp lxr;
    private static /* synthetic */ int lxs;
    private static /* synthetic */ String lxt;

    public lxp() {
        super(a.d("\u60bc\u192c\u93da\u0d94\u865b\u00f7\uba90\u3340\uad16\u27aa\ua061", -639606957, 800866218), a.d("\udd41\ua4cf\u2e04\ub068\u3bef\ubd1f\u074a\u8ebd\u10ea\u9a5c\u1dc1\ue7e4\u692f\uf093\u7a85\ufc3d\u4675\uc9b9\u530d\ud549\u5cb1\u26fa\ua81d\u3395\ub5fc\u3f37\u86d1\u08cc\u9236\u1468\u9fd1", -1951112554, -424755326), kfa.MOVEMENT);
        lxr = this;
    }

    public static boolean active() {
        return lxr != null && lxr.isEnabled();
    }

    @Override
    public void onStartTick(MinecraftClient minecraftClient) {
        if (vxr.getInt(lxq, minecraftClient.field_1724, 0) > 0) {
            vxr.setInt(lxq, minecraftClient.field_1724, 0);
        }
    }

    private static /* synthetic */ int bah(int n, int n2) {
        return n + n2 ^ 0x3EF6B226;
    }

    private static /* synthetic */ int bai(int n, int n2) {
        return lxp.bah(n, n2) ^ 0xEDEAEEB7;
    }
}

