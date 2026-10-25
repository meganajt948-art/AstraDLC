/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.ActionResult
 *  net.minecraft.util.ActionResult$Success
 *  net.minecraft.util.ActionResult$SwingSource
 *  net.minecraft.util.Hand
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Position
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.RaycastContext
 *  net.minecraft.world.RaycastContext$FluidHandling
 *  net.minecraft.world.RaycastContext$ShapeType
 */
package a;

import a.pth;
import a.vxr;
import flow.dev.a;
import java.lang.reflect.Field;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;

public final class ptr {
    private static final Field pts = vxr.find(MinecraftClient.class, a.d("\u8947\uf0fd\u7a3f\ue414\u6f80\ue935\u5361\uda9b\u44c2\uce62\u49a2\ub3d4\u3d11\ua4fa\u2ee4\ua81a\u1258\u9d9b\u0728\u8155\u08ce\u729d\ufc2f", -1390575708, 2014508698), a.c(-1826627949, "\udeff\ua741\u2d9e\ub3e6\u3839\ubeb3\u048e\u8d79\u1324\u9992"), a.b("\u6803", 841246795));
    private static pth ptt = new pth();
    private static /* synthetic */ long ptu;
    private static /* synthetic */ int ptv;

    private ptr() {
    }

    public static pth swap(pth pth2) {
        pth pth3 = ptt;
        ptt = pth2 == null ? new pth() : pth2;
        return pth3;
    }

    public static void aimAt(BlockPos blockPos, float f, float f2) {
        pth pth2 = ptt;
        pth2.pti = blockPos;
        pth2.ptj = f;
        pth2.ptk = f2;
        pth2.ptm = false;
        pth2.ptl = 2;
    }

    public static void miss() {
        pth pth2 = ptt;
        pth2.pti = null;
        pth2.ptm = true;
        pth2.ptl = 2;
    }

    public static void clear() {
        pth pth2 = ptt;
        pth2.pti = null;
        pth2.ptm = false;
        pth2.ptl = 0;
        pth2.ptn.clear();
    }

    public static void later(Runnable runnable) {
        pth pth2 = ptt;
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        if (runnable == null || pth2.ptn.size() >= 4) {
            return;
        }
        pth2.ptn.add(runnable);
        pth2.pto = minecraftClient.field_1724 != null ? minecraftClient.field_1724.field_6012 : 0;
    }

    public static boolean isOrdered() {
        pth pth2 = ptt;
        return pth2.ptl > 0 && (pth2.pti != null || pth2.ptm);
    }

    public static void apply(MinecraftClient minecraftClient) {
        pth pth2 = ptt;
        try {
            ptr.ptx(pth2, minecraftClient);
        }
        finally {
            ptr.ptw(pth2, minecraftClient);
        }
    }

    public static void applyOwn(MinecraftClient minecraftClient) {
        pth pth2 = ptt;
        try {
            ptr.pty(pth2, minecraftClient);
        }
        finally {
            ptr.ptw(pth2, minecraftClient);
        }
    }

    private static void ptw(pth pth2, MinecraftClient minecraftClient) {
        Runnable runnable;
        if (pth2.ptn.isEmpty()) {
            return;
        }
        if (minecraftClient == null || minecraftClient.field_1724 == null || minecraftClient.field_1687 == null || minecraftClient.field_1724.field_6012 - pth2.pto > 3 || minecraftClient.field_1724.field_6012 < pth2.pto) {
            pth2.ptn.clear();
            return;
        }
        while ((runnable = pth2.ptn.poll()) != null) {
            try {
                runnable.run();
            }
            catch (Exception exception) {}
        }
    }

    private static void ptx(pth pth2, MinecraftClient minecraftClient) {
        if (pth2.ptl <= 0 || pth2.pti == null && !pth2.ptm) {
            return;
        }
        --pth2.ptl;
        if (minecraftClient == null || minecraftClient.field_1724 == null || minecraftClient.field_1687 == null) {
            return;
        }
        Vec3d vec3d = minecraftClient.field_1724.method_33571();
        Vec3d vec3d2 = Vec3d.method_1030((float)pth2.ptk, (float)pth2.ptj);
        double d = minecraftClient.field_1724.method_55754();
        Vec3d vec3d3 = vec3d.method_1031(vec3d2.field_1352 * d, vec3d2.field_1351 * d, vec3d2.field_1350 * d);
        if (pth2.ptm) {
            minecraftClient.field_1765 = BlockHitResult.method_17778((Vec3d)vec3d3, (Direction)Direction.field_11036, (BlockPos)BlockPos.method_49638((Position)vec3d3));
            return;
        }
        BlockHitResult blockHitResult = minecraftClient.field_1687.method_17742(new RaycastContext(vec3d, vec3d3, RaycastContext.ShapeType.field_17559, RaycastContext.FluidHandling.field_1348, (Entity)minecraftClient.field_1724));
        minecraftClient.field_1765 = blockHitResult.method_17783() == HitResult.Type.field_1332 && blockHitResult.method_17777().equals((Object)pth2.pti) ? blockHitResult : BlockHitResult.method_17778((Vec3d)vec3d3, (Direction)Direction.field_11036, (BlockPos)BlockPos.method_49638((Position)vec3d3));
    }

    private static void pty(pth pth2, MinecraftClient minecraftClient) {
        if (pth2.ptl <= 0 || pth2.pti == null && !pth2.ptm) {
            return;
        }
        --pth2.ptl;
        if (minecraftClient == null || minecraftClient.field_1724 == null || minecraftClient.field_1687 == null || minecraftClient.field_1690 == null || minecraftClient.field_1761 == null) {
            return;
        }
        if (pth2.ptm) {
            ptr.ptz(minecraftClient);
            return;
        }
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        Vec3d vec3d = clientPlayerEntity.method_33571();
        Vec3d vec3d2 = Vec3d.method_1030((float)clientPlayerEntity.method_36455(), (float)clientPlayerEntity.method_36454());
        double d = clientPlayerEntity.method_55754();
        Vec3d vec3d3 = vec3d.method_1031(vec3d2.field_1352 * d, vec3d2.field_1351 * d, vec3d2.field_1350 * d);
        BlockHitResult blockHitResult = minecraftClient.field_1687.method_17742(new RaycastContext(vec3d, vec3d3, RaycastContext.ShapeType.field_17559, RaycastContext.FluidHandling.field_1348, (Entity)clientPlayerEntity));
        if (blockHitResult.method_17783() == HitResult.Type.field_1332 && blockHitResult.method_17777().equals((Object)pth2.pti)) {
            return;
        }
        minecraftClient.field_1690.field_1886.method_23481(false);
        minecraftClient.field_1690.field_1904.method_23481(false);
        while (minecraftClient.field_1690.field_1886.method_1436()) {
        }
        while (minecraftClient.field_1690.field_1904.method_1436()) {
        }
    }

    private static void ptz(MinecraftClient minecraftClient) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        while (minecraftClient.field_1690.field_1904.method_1436()) {
        }
        if (!minecraftClient.field_1690.field_1904.method_1434() || clientPlayerEntity.method_6115()) {
            return;
        }
        int n = vxr.getInt(pts, minecraftClient, 0);
        if (n <= 0 && !minecraftClient.field_1761.method_2923() && !clientPlayerEntity.method_3144()) {
            Hand hand;
            ItemStack itemStack;
            Hand[] handArray = Hand.values();
            int n2 = handArray.length;
            for (int i = 0; i < n2 && (itemStack = clientPlayerEntity.method_5998(hand = handArray[i])).method_45435(minecraftClient.field_1687.method_45162()); ++i) {
                ActionResult actionResult;
                if (itemStack.method_7960() || !((actionResult = minecraftClient.field_1761.method_2919((PlayerEntity)clientPlayerEntity, hand)) instanceof ActionResult.Success)) continue;
                ActionResult.Success success = (ActionResult.Success)actionResult;
                if (success.comp_2909() != ActionResult.SwingSource.field_52427) break;
                clientPlayerEntity.method_6104(hand);
                break;
            }
            n = 4;
        }
        vxr.setInt(pts, minecraftClient, Math.max(n, 2));
    }

    private static /* synthetic */ int boo(int n, int n2) {
        return n + n2 ^ 0x2116848F;
    }

    private static /* synthetic */ int bop(int n, int n2) {
        return ptr.boo(n, n2) * n2;
    }
}

