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
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (runnable == null || pth2.ptn.size() >= 4) {
            return;
        }
        pth2.ptn.add(runnable);
        pth2.pto = minecraftClient.player != null ? minecraftClient.player.age : 0;
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
        if (minecraftClient == null || minecraftClient.player == null || minecraftClient.world == null || minecraftClient.player.age - pth2.pto > 3 || minecraftClient.player.age < pth2.pto) {
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
        if (minecraftClient == null || minecraftClient.player == null || minecraftClient.world == null) {
            return;
        }
        Vec3d vec3d = minecraftClient.player.getEyePos();
        Vec3d vec3d2 = Vec3d.fromPolar((float)pth2.ptk, (float)pth2.ptj);
        double d = minecraftClient.player.getBlockInteractionRange();
        Vec3d vec3d3 = vec3d.add(vec3d2.x * d, vec3d2.y * d, vec3d2.z * d);
        if (pth2.ptm) {
            minecraftClient.crosshairTarget = BlockHitResult.createMissed((Vec3d)vec3d3, (Direction)Direction.UP, (BlockPos)BlockPos.ofFloored((Position)vec3d3));
            return;
        }
        BlockHitResult blockHitResult = minecraftClient.world.raycast(new RaycastContext(vec3d, vec3d3, RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, (Entity)minecraftClient.player));
        minecraftClient.crosshairTarget = blockHitResult.getType() == HitResult.Type.BLOCK && blockHitResult.getBlockPos().equals((Object)pth2.pti) ? blockHitResult : BlockHitResult.createMissed((Vec3d)vec3d3, (Direction)Direction.UP, (BlockPos)BlockPos.ofFloored((Position)vec3d3));
    }

    private static void pty(pth pth2, MinecraftClient minecraftClient) {
        if (pth2.ptl <= 0 || pth2.pti == null && !pth2.ptm) {
            return;
        }
        --pth2.ptl;
        if (minecraftClient == null || minecraftClient.player == null || minecraftClient.world == null || minecraftClient.options == null || minecraftClient.interactionManager == null) {
            return;
        }
        if (pth2.ptm) {
            ptr.ptz(minecraftClient);
            return;
        }
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        Vec3d vec3d2 = Vec3d.fromPolar((float)clientPlayerEntity.getPitch(), (float)clientPlayerEntity.getYaw());
        double d = clientPlayerEntity.getBlockInteractionRange();
        Vec3d vec3d3 = vec3d.add(vec3d2.x * d, vec3d2.y * d, vec3d2.z * d);
        BlockHitResult blockHitResult = minecraftClient.world.raycast(new RaycastContext(vec3d, vec3d3, RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, (Entity)clientPlayerEntity));
        if (blockHitResult.getType() == HitResult.Type.BLOCK && blockHitResult.getBlockPos().equals((Object)pth2.pti)) {
            return;
        }
        minecraftClient.options.attackKey.setPressed(false);
        minecraftClient.options.useKey.setPressed(false);
        while (minecraftClient.options.attackKey.wasPressed()) {
        }
        while (minecraftClient.options.useKey.wasPressed()) {
        }
    }

    private static void ptz(MinecraftClient minecraftClient) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        while (minecraftClient.options.useKey.wasPressed()) {
        }
        if (!minecraftClient.options.useKey.isPressed() || clientPlayerEntity.isUsingItem()) {
            return;
        }
        int n = vxr.getInt(pts, minecraftClient, 0);
        if (n <= 0 && !minecraftClient.interactionManager.isBreakingBlock() && !clientPlayerEntity.isRiding()) {
            Hand hand;
            ItemStack itemStack;
            Hand[] handArray = Hand.values();
            int n2 = handArray.length;
            for (int i = 0; i < n2 && (itemStack = clientPlayerEntity.getStackInHand(hand = handArray[i])).isItemEnabled(minecraftClient.world.getEnabledFeatures()); ++i) {
                ActionResult actionResult;
                if (itemStack.isEmpty() || !((actionResult = minecraftClient.interactionManager.interactItem((PlayerEntity)clientPlayerEntity, hand)) instanceof ActionResult.Success)) continue;
                ActionResult.Success success = (ActionResult.Success)actionResult;
                if (success.swingSource() != ActionResult.SwingSource.CLIENT) break;
                clientPlayerEntity.swingHand(hand);
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

