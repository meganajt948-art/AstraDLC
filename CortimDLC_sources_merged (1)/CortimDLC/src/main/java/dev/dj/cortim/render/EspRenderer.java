package dev.dj.cortim.render;

import dev.dj.cortim.module.Freecam;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderContext;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;

public class EspRenderer {

    public static void register() {
        WorldRenderEvents.AFTER_ENTITIES.register(EspRenderer::onRenderAfterEntities);
    }

    private static void onRenderAfterEntities(WorldRenderContext context) {
        if (!Freecam.active) return;

        MinecraftClient client = MinecraftClient.getInstance();
        ClientPlayerEntity player = client.player;
        if (player == null || client.gameRenderer == null) return;

        Vec3d camPos = client.gameRenderer.getCamera().getCameraPos();
        MatrixStack matrices = context.matrices();
        if (matrices == null) return;

        VertexConsumerProvider consumers = context.consumers();
        if (consumers == null) return;

        VertexConsumer vc = consumers.getBuffer(RenderLayers.lines());

        double x = player.getX() - camPos.x;
        double y = player.getY() - camPos.y;
        double z = player.getZ() - camPos.z;

        float half = player.getWidth() / 2f + 0.02f;
        float height = player.getHeight() + 0.02f;

        matrices.push();
        matrices.translate(x, y, z);
        Matrix4f pose = matrices.peek().getPositionMatrix();

        Box box = new Box(-half, 0, -half, half, height, half);
        drawBoxOutline(vc, pose, box, 1f, 0.84f, 0f, 0.85f); // золотистый контур

        matrices.pop();
    }

    private static void drawBoxOutline(VertexConsumer vc, Matrix4f pose, Box box,
                                       float r, float g, float b, float a) {
        float minX = (float) box.minX, minY = (float) box.minY, minZ = (float) box.minZ;
        float maxX = (float) box.maxX, maxY = (float) box.maxY, maxZ = (float) box.maxZ;

        line(vc, pose, minX, minY, minZ, maxX, minY, minZ, r, g, b, a);
        line(vc, pose, maxX, minY, minZ, maxX, minY, maxZ, r, g, b, a);
        line(vc, pose, maxX, minY, maxZ, minX, minY, maxZ, r, g, b, a);
        line(vc, pose, minX, minY, maxZ, minX, minY, minZ, r, g, b, a);

        line(vc, pose, minX, maxY, minZ, maxX, maxY, minZ, r, g, b, a);
        line(vc, pose, maxX, maxY, minZ, maxX, maxY, maxZ, r, g, b, a);
        line(vc, pose, maxX, maxY, maxZ, minX, maxY, maxZ, r, g, b, a);
        line(vc, pose, minX, maxY, maxZ, minX, maxY, minZ, r, g, b, a);

        line(vc, pose, minX, minY, minZ, minX, maxY, minZ, r, g, b, a);
        line(vc, pose, maxX, minY, minZ, maxX, maxY, minZ, r, g, b, a);
        line(vc, pose, maxX, minY, maxZ, maxX, maxY, maxZ, r, g, b, a);
        line(vc, pose, minX, minY, maxZ, minX, maxY, maxZ, r, g, b, a);
    }

    private static void line(VertexConsumer vc, Matrix4f pose,
                             float x1, float y1, float z1, float x2, float y2, float z2,
                             float r, float g, float b, float a) {
        float nx = x2 - x1, ny = y2 - y1, nz = z2 - z1;
        float len = (float) Math.sqrt(nx * nx + ny * ny + nz * nz);
        if (len > 0) { nx /= len; ny /= len; nz /= len; }

        vc.vertex(pose, x1, y1, z1).color(r, g, b, a).normal(nx, ny, nz);
        vc.vertex(pose, x2, y2, z2).color(r, g, b, a).normal(nx, ny, nz);
    }
}