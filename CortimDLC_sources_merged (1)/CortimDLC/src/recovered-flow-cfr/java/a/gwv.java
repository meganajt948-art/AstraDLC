/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.builder.LiteralArgumentBuilder
 *  net.minecraft.block.Blocks
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.decoration.ArmorStandEntity
 *  net.minecraft.server.command.CommandManager
 *  net.minecraft.server.command.ServerCommandSource
 *  net.minecraft.server.integrated.IntegratedServer
 *  net.minecraft.server.network.ServerPlayerEntity
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package a;

import a.pzc;
import a.qdz;
import a.qmh;
import a.tck;
import a.tel;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import flow.dev.a;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

final class gwv {
    private static final AtomicInteger gww = new AtomicInteger();
    private static qdz gwx;
    private static final tel gwy;
    private static final qmh gwz;
    private static BlockPos gxa;
    private static volatile BlockPos gxb;
    private static int gxc;
    private static /* synthetic */ long gxd;
    private static /* synthetic */ boolean gxe;

    private gwv() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        if (n == 1) {
            minecraftClient.field_1690.field_1837 = false;
            minecraftClient.method_1562().method_45730(a.d("\ud4e1\uad56\u2789\ub9f0\u322f\ub49c\u0ec4\u8734\u192e\u93cc\u1419\uee6f\u60bc\uf912\u735e\uf5b8\u4ffa", 1271200836, -182769453));
            BlockPos blockPos = clientPlayerEntity.method_24515();
            gxa = blockPos.method_10069(4, 0, 3);
            minecraftClient.method_1576().execute(() -> {
                IntegratedServer integratedServer = minecraftClient.method_1576();
                ServerWorld serverWorld = integratedServer.method_30002();
                for (int i = -2; i <= 7; ++i) {
                    for (int j = -2; j <= 6; ++j) {
                        serverWorld.method_8501(blockPos.method_10069(i, -1, j), Blocks.field_10340.method_9564());
                        for (int k = 0; k <= 2; ++k) {
                            serverWorld.method_8501(blockPos.method_10069(i, k, j), Blocks.field_10124.method_9564());
                        }
                    }
                }
                serverWorld.method_8501(gxa, Blocks.field_10563.method_9564());
                integratedServer.method_3734().method_9235().register((LiteralArgumentBuilder)CommandManager.method_9247((String)a.c(2116723422, "\ua2ae\udb05\u51cb")).executes(commandContext -> {
                    ServerPlayerEntity serverPlayerEntity = ((ServerCommandSource)commandContext.getSource()).method_9207();
                    gww.incrementAndGet();
                    gxb = serverPlayerEntity.method_24515();
                    ArmorStandEntity armorStandEntity = new ArmorStandEntity((World)serverPlayerEntity.method_51469(), serverPlayerEntity.method_23317(), serverPlayerEntity.method_23318() - 0.3, serverPlayerEntity.method_23321());
                    armorStandEntity.method_5648(true);
                    armorStandEntity.method_5875(true);
                    serverPlayerEntity.method_51469().method_8649((Entity)armorStandEntity);
                    serverPlayerEntity.method_5873((Entity)armorStandEntity, true, true);
                    return 1;
                }));
                ServerPlayerEntity serverPlayerEntity = integratedServer.method_3760().method_14566(clientPlayerEntity.method_5477().getString());
                integratedServer.method_3760().method_14576(serverPlayerEntity);
            });
        }
        if (n == 30) {
            gwx = new qdz();
            gwx.onSit(() -> minecraftClient.method_1562().method_45730(a.d("\u6eaf\u1704\u9dca", 1057153687, 1625656392)));
            gwx.park(pzc.empty(gxa), gxa, true);
            System.out.println(a.d("\u6040\u19eb\u9325\u0d00\u8683#\uba66\u3390\uad81\u272a\ua0aa\u5adc\ud41e\u4da7\uc7ef\u411f\ufb03\u7493\uee35\u6830", 1777071297, -681011994) + gxa.method_23854() + a.b("\u0857\u71ea\ufb69\u6504\ueede\u6877\ud238\u5bde\uc5d3\u4f23\uc8e5\u32c0", -630519689) + clientPlayerEntity.method_24515().method_23854());
        }
        if (gwx != null && gxc < 0) {
            gwy.newTick();
            gwy.use(tck.profile1());
            gwy.tune(1.0, 1.0, 1.0);
            gwy.cap(0.0);
            gwz.cap(110.0);
            gwx.configure(gwz, false, false);
            gwx.startTick(minecraftClient, clientPlayerEntity);
            gwx.endTick(minecraftClient, clientPlayerEntity, gwy);
            if (n % 10 == 0) {
                System.out.println(a.b("\ud847\ua1ec\u2b22\ub507\u3e84\ub824\u0261\u8b97\u159c\u9f79\u18e3", 1533597759) + n + a.d("\u3c53\u45b2\ucf7e\u5113\uda8a", 1269333822, -228506808) + clientPlayerEntity.method_24515().method_23854() + a.c(1955799927, "\u235f\u5abe\ud07c\u4e1e\uc5d0\u436f\uf93d\u7095") + gwx.parked() + a.c(1510448127, "\u9bd6\ue231\u68f1\uf68d\u7d5b\ufbe0\u41bc\uc844\u5643") + clientPlayerEntity.method_5765() + a.d("\u80b4\uf956\u739f\uedf3\u6623\ue0dc", -1365753403, 1041678679) + gww.get());
            }
            if (clientPlayerEntity.method_5765()) {
                gxc = n;
                gwx.stop(minecraftClient);
            }
        }
        if (gxc > 0 && n == gxc + 10 || n > 530) {
            boolean bl = gxc > 0 && gww.get() >= 1 && gxb != null && (gxb.equals((Object)gxa) || gxb.equals((Object)gxa.method_10084()));
            System.out.println(a.d("\uce84\ub72f\u3de1\ua3c4\u2847\uaee7\u14a2\u9d54\u0345\u89ee\u0e32\uf41f\u7ad2\ue37e\u6979\uefdb\u5582\uda58\u40f1\uc6f4", -221304489, -126359628) + gww.get() + a.d("\uf479\u8d9c\u0743\u9961\u12b1\u941b\u2e48\ua7b2\u39a9\ub359\u349f\uceba", -849370414, 2022332127) + (gxb == null ? a.b("\uf978", -56231596) : gxb.method_23854()) + a.d("\u636e\u1ad7\u905f\u0e29\u85eb\u0352\ub91a\u30ea\uaee6", 1856133228, 2128100139) + gxa.method_23854() + a.d("\u62ea", 462614382, -1590325844));
            System.out.println(a.c(383882426, "\u94c0\ued6b\u67a5\uf980\u7203\uf4a3\u4ee6\uc710\u591b") + (bl ? a.b("\u4d47\u34e7\ube26\u2057", -2077405933) : a.b("\u74b6\u0d00\u87db\u19af", -2048035596)));
            if (gwx != null) {
                gwx.stop(minecraftClient);
            }
            return true;
        }
        return false;
    }

    static {
        gwy = new tel();
        gwz = new qmh();
        gxc = -1;
    }

    private static /* synthetic */ int xf(int n, int n2) {
        return n - n2 + 524443562;
    }

    private static /* synthetic */ int xg(int n, int n2) {
        return gwv.xf(n, n2) * n2;
    }
}

