package dev.dj.cortim.render;

import dev.dj.cortim.Cortim;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;

import java.nio.file.Files;
import java.nio.file.Path;

public final class AmbienceFogPack {

    private static final String PACK_ID = "cortim_ambience";
    private static int lastColor = -1;
    private static float lastDensity = -1, lastCoverage = -1, lastDistance = -1;
    private static float lastStart = -1, lastHeight = -1, lastThickness = -1;
    private static boolean initialized = false;

    private AmbienceFogPack() {}

    public static boolean isInitialized() { return initialized; }

    public static void update(int color, float density, float coverage, float distance,
                              float start, float height, float thickness) {
        if (color == lastColor && density == lastDensity && coverage == lastCoverage
                && distance == lastDistance && start == lastStart
                && height == lastHeight && thickness == lastThickness) {
            initialized = true;
            return;
        }
        try {
            Path root = FabricLoader.getInstance().getGameDir().resolve("resourcepacks").resolve(PACK_ID);
            Path meta = root.resolve("pack.mcmeta");
            Path postDir = root.resolve("assets").resolve("cortim").resolve("post_effect");
            Path shaderDir = root.resolve("assets").resolve("cortim").resolve("shaders").resolve("post");

            Files.createDirectories(postDir);
            Files.createDirectories(shaderDir);

            Files.writeString(meta, """
                    {
                      "pack": {
                        "pack_format": 46,
                        "description": "Cortim Ambience Fog"
                      }
                    }
                    """);

            Files.writeString(postDir.resolve("ambience_fog.json"),
                    buildJson(color, density, coverage, distance, start, height, thickness));
            Files.writeString(shaderDir.resolve("ambience_fog.fsh"), FOG_FSH);

            activatePack();

            lastColor = color;
            lastDensity = density;
            lastCoverage = coverage;
            lastDistance = distance;
            lastStart = start;
            lastHeight = height;
            lastThickness = thickness;
            initialized = true;
        } catch (Throwable t) {
            Cortim.LOG.warn("AmbienceFogPack update failed", t);
            initialized = true;
        }
    }

    private static void activatePack() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc == null || mc.options == null) return;
        try {
            var packs = mc.options.resourcePacks;
            if (!packs.contains(PACK_ID)) {
                packs.add(PACK_ID);
                mc.options.write();
            }
        } catch (Throwable t) {
            Cortim.LOG.warn("activateFogPack failed", t);
        }
    }

    private static String buildJson(int color, float density, float coverage, float distance,
                                    float start, float height, float thickness) {
        float r = ((color >> 16) & 0xFF) / 255f;
        float g = ((color >> 8) & 0xFF) / 255f;
        float b = (color & 0xFF) / 255f;
        return """
                {
                  "targets": { "cortim:fog_swap": {} },
                  "passes": [
                    {
                      "vertex_shader": "minecraft:core/screenquad",
                      "fragment_shader": "cortim:post/ambience_fog",
                      "inputs": [
                        { "sampler_name": "In", "target": "minecraft:main" },
                        { "sampler_name": "DepthSampler", "target": "minecraft:main", "use_depth_buffer": true }
                      ],
                      "output": "cortim:fog_swap",
                      "uniforms": {
                        "AmbienceFogConfig": [
                          { "name": "FogColor", "type": "vec3", "value": [ %f, %f, %f ] },
                          { "name": "Density", "type": "float", "value": %f },
                          { "name": "Coverage", "type": "float", "value": %f },
                          { "name": "Distance", "type": "float", "value": %f },
                          { "name": "FogStart", "type": "float", "value": %f },
                          { "name": "FogHeight", "type": "float", "value": %f },
                          { "name": "FogThickness", "type": "float", "value": %f }
                        ]
                      }
                    },
                    {
                      "vertex_shader": "minecraft:core/screenquad",
                      "fragment_shader": "minecraft:post/blit",
                      "inputs": [ { "sampler_name": "In", "target": "cortim:fog_swap" } ],
                      "uniforms": {
                        "BlitConfig": [
                          { "name": "ColorModulate", "type": "vec4", "value": [ 1.0, 1.0, 1.0, 1.0 ] }
                        ]
                      },
                      "output": "minecraft:main"
                    }
                  ]
                }
                """.formatted(r, g, b, density, coverage, distance, start, height, thickness);
    }

    private static final String FOG_FSH = """
            #version 330

            uniform sampler2D InSampler;
            uniform sampler2D DepthSampler;

            in vec2 texCoord;

            layout(std140) uniform SamplerInfo {
                vec2 OutSize;
                vec2 InSize;
            };

            layout(std140) uniform AmbienceFogConfig {
                vec3  FogColor;
                float Density;
                float Coverage;
                float Distance;
                float FogStart;
                float FogHeight;
                float FogThickness;
            };

            out vec4 fragColor;

            void main() {
                vec4 base = texture(InSampler, texCoord);
                float d = texture(DepthSampler, texCoord).r;

                // 0.0 = очень близко, 1.0 = очень далеко (небо)
                // normalизация: ближе 0.3 — без тумана, дальше — с туманом
                float fogFactor = smoothstep(0.3, 1.0, d);

                // покрытие сдвигает границу начала тумана
                float coverageBias = 1.0 - Coverage;
                fogFactor = smoothstep(0.3 + coverageBias * 0.4, 1.0, d);

                // плотность общий множитель
                float strength = fogFactor * clamp(Density, 0.0, 1.0);

                // дальность отсекает — если слишком далеко, туман максимальный
                // (сейчас у нас нет world pos, поэтому только через depth)

                vec3 result = mix(base.rgb, FogColor, strength);
                fragColor = vec4(result, base.a);
            }
            """;
}