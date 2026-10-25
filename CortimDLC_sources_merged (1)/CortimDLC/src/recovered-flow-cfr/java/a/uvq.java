/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.pipeline.BlendFunction
 *  com.mojang.blaze3d.pipeline.CompiledRenderPipeline
 *  com.mojang.blaze3d.pipeline.RenderPipeline
 *  com.mojang.blaze3d.pipeline.RenderPipeline$Builder
 *  com.mojang.blaze3d.pipeline.RenderPipeline$Snippet
 *  com.mojang.blaze3d.platform.DepthTestFunction
 *  com.mojang.blaze3d.shaders.ShaderType
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.vertex.VertexFormat
 *  com.mojang.blaze3d.vertex.VertexFormat$DrawMode
 *  com.mojang.blaze3d.vertex.VertexFormatElement
 *  net.minecraft.client.gl.ShaderSourceGetter
 *  net.minecraft.client.gl.UniformType
 *  net.minecraft.client.render.VertexFormats
 *  net.minecraft.util.Identifier
 */
package a;

import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.CompiledRenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.shaders.ShaderType;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormatElement;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import net.minecraft.client.gl.ShaderSourceGetter;
import net.minecraft.client.gl.UniformType;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;

public final class uvq {
    public static final String NAMESPACE = "flow2";
    public static final VertexFormat RECT_FORMAT = VertexFormat.builder().add("Position", VertexFormatElement.POSITION).add("Color", VertexFormatElement.COLOR).add("UV0", VertexFormatElement.UV0).add("UV1", VertexFormatElement.UV1).add("UV2", VertexFormatElement.UV2).add("LineWidth", VertexFormatElement.LINE_WIDTH).build();
    public static final RenderPipeline RECT = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/rect")).withVertexShader(uvq.id("core/rect")).withFragmentShader(uvq.id("core/rect")).withUniform("DynamicTransforms", UniformType.field_60031).withUniform("Projection", UniformType.field_60031).withBlend(BlendFunction.TRANSLUCENT).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withCull(false).withVertexFormat(RECT_FORMAT, VertexFormat.DrawMode.field_27382).build();
    public static final RenderPipeline ARC = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/arc")).withVertexShader(uvq.id("core/rect")).withFragmentShader(uvq.id("core/arc")).withUniform("DynamicTransforms", UniformType.field_60031).withUniform("Projection", UniformType.field_60031).withBlend(BlendFunction.TRANSLUCENT).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withCull(false).withVertexFormat(RECT_FORMAT, VertexFormat.DrawMode.field_27382).build();
    public static final RenderPipeline GLASS = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/glass")).withVertexShader(uvq.id("core/rect")).withFragmentShader(uvq.id("core/glass")).withUniform("DynamicTransforms", UniformType.field_60031).withUniform("Projection", UniformType.field_60031).withUniform("Globals", UniformType.field_60031).withSampler("Sampler0").withBlend(BlendFunction.TRANSLUCENT).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withCull(false).withVertexFormat(RECT_FORMAT, VertexFormat.DrawMode.field_27382).build();
    public static final RenderPipeline LIQUID = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/liquid")).withVertexShader(uvq.id("core/rect")).withFragmentShader(uvq.id("core/liquid")).withUniform("DynamicTransforms", UniformType.field_60031).withUniform("Projection", UniformType.field_60031).withUniform("Globals", UniformType.field_60031).withSampler("Sampler0").withBlend(BlendFunction.TRANSLUCENT).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withCull(false).withVertexFormat(RECT_FORMAT, VertexFormat.DrawMode.field_27382).build();
    public static final RenderPipeline IMAGE = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/image")).withVertexShader(uvq.id("core/rect")).withFragmentShader(uvq.id("core/image")).withUniform("DynamicTransforms", UniformType.field_60031).withUniform("Projection", UniformType.field_60031).withSampler("Sampler0").withBlend(BlendFunction.TRANSLUCENT).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withCull(false).withVertexFormat(RECT_FORMAT, VertexFormat.DrawMode.field_27382).build();
    public static final RenderPipeline RECT_ADD = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/rect_add")).withVertexShader(uvq.id("core/rect")).withFragmentShader(uvq.id("core/rect")).withUniform("DynamicTransforms", UniformType.field_60031).withUniform("Projection", UniformType.field_60031).withBlend(BlendFunction.LIGHTNING).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withCull(false).withVertexFormat(RECT_FORMAT, VertexFormat.DrawMode.field_27382).build();
    public static final RenderPipeline IMAGE_ADD = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/image_add")).withVertexShader(uvq.id("core/rect")).withFragmentShader(uvq.id("core/image")).withUniform("DynamicTransforms", UniformType.field_60031).withUniform("Projection", UniformType.field_60031).withSampler("Sampler0").withBlend(BlendFunction.LIGHTNING).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withCull(false).withVertexFormat(RECT_FORMAT, VertexFormat.DrawMode.field_27382).build();
    public static final RenderPipeline PATTERN = uvq.uvy("pattern", BlendFunction.TRANSLUCENT);
    public static final RenderPipeline PATTERN_ADD = uvq.uvy("pattern_add", BlendFunction.LIGHTNING);
    public static final RenderPipeline QUAD = uvq.uvx("quad", BlendFunction.TRANSLUCENT);
    public static final RenderPipeline QUAD_ADD = uvq.uvx("quad_add", BlendFunction.LIGHTNING);
    public static final RenderPipeline GRADE = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/grade")).withVertexShader(uvq.id("core/blur")).withFragmentShader(uvq.id("core/grade")).withSampler("InSampler").withSampler("BloomSampler").withUniform("FlowGrade", UniformType.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.field_60033, VertexFormat.DrawMode.field_27379).build();
    public static final RenderPipeline BLUR_DOWN = uvq.uvz("blur_down");
    public static final RenderPipeline BLUR_UP = uvq.uvz("blur_up");
    public static final RenderPipeline BLUR_COPY = uvq.uvz("blur_copy");
    public static final RenderPipeline COMPOSITE = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/composite")).withVertexShader(uvq.id("core/blur")).withFragmentShader(uvq.id("core/composite")).withSampler("InSampler").withSampler("WallSampler").withUniform("FlowComposite", UniformType.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.field_60033, VertexFormat.DrawMode.field_27379).build();
    public static final RenderPipeline FOG_MARCH = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/fog_march")).withVertexShader(uvq.id("core/fog")).withFragmentShader(uvq.id("core/fog_march")).withSampler("DepthSampler").withSampler("NoiseSampler").withUniform("Projection", UniformType.field_60031).withUniform("Fog", UniformType.field_60031).withUniform("FlowFog", UniformType.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.field_60033, VertexFormat.DrawMode.field_27379).build();
    public static final RenderPipeline FOG_RESOLVE = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/fog_resolve")).withVertexShader(uvq.id("core/fog")).withFragmentShader(uvq.id("core/fog_resolve")).withSampler("RawSampler").withSampler("HistorySampler").withSampler("DepthSampler").withUniform("Projection", UniformType.field_60031).withUniform("FlowFog", UniformType.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.field_60033, VertexFormat.DrawMode.field_27379).build();
    public static final RenderPipeline FOG_COMPOSITE = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/fog_composite")).withVertexShader(uvq.id("core/fog")).withFragmentShader(uvq.id("core/fog_composite")).withSampler("FogSampler").withSampler("DepthSampler").withUniform("Projection", UniformType.field_60031).withUniform("FlowFog", UniformType.field_60031).withBlend(BlendFunction.TRANSLUCENT_PREMULTIPLIED_ALPHA).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.field_60033, VertexFormat.DrawMode.field_27379).build();
    public static final RenderPipeline WET = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/wet")).withVertexShader(uvq.id("core/fog")).withFragmentShader(uvq.id("core/wet")).withSampler("SceneSampler").withSampler("DepthSampler").withSampler("NoiseSampler").withSampler("HeightSampler").withUniform("Projection", UniformType.field_60031).withUniform("Fog", UniformType.field_60031).withUniform("FlowWet", UniformType.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.field_60033, VertexFormat.DrawMode.field_27379).build();
    public static final RenderPipeline SEASON = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/season")).withVertexShader(uvq.id("core/fog")).withFragmentShader(uvq.id("core/season")).withSampler("SceneSampler").withSampler("DepthSampler").withSampler("NoiseSampler").withSampler("HeightSampler").withSampler("TerrainDepthSampler").withSampler("EntityDepthSampler").withUniform("Projection", UniformType.field_60031).withUniform("Fog", UniformType.field_60031).withUniform("FlowSeason", UniformType.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.field_60033, VertexFormat.DrawMode.field_27379).build();
    public static final RenderPipeline SEASON_PARTICLES = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/season_particles")).withVertexShader(uvq.id("core/season_particles")).withFragmentShader(uvq.id("core/season_particles")).withSampler("HeightSampler").withUniform("Projection", UniformType.field_60031).withUniform("FlowSeason", UniformType.field_60031).withBlend(BlendFunction.TRANSLUCENT_PREMULTIPLIED_ALPHA).withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.field_60033, VertexFormat.DrawMode.field_27379).build();
    public static final RenderPipeline SEASON_GRADE = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/season_grade")).withVertexShader(uvq.id("core/fog")).withFragmentShader(uvq.id("core/season_grade")).withSampler("SceneSampler").withUniform("Projection", UniformType.field_60031).withUniform("FlowSeason", UniformType.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.field_60033, VertexFormat.DrawMode.field_27379).build();
    public static final RenderPipeline STORM_SKY = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/storm_sky")).withVertexShader(uvq.id("core/fog")).withFragmentShader(uvq.id("core/storm_sky")).withSampler("DepthSampler").withSampler("NoiseSampler").withUniform("Projection", UniformType.field_60031).withUniform("FlowStorm", UniformType.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.field_60033, VertexFormat.DrawMode.field_27379).build();
    public static final RenderPipeline STORM_SKY_COMPOSITE = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/storm_sky_composite")).withVertexShader(uvq.id("core/fog")).withFragmentShader(uvq.id("core/storm_sky")).withShaderDefine("COMPOSITE").withSampler("DepthSampler").withSampler("HalfSampler").withUniform("Projection", UniformType.field_60031).withUniform("FlowStorm", UniformType.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.field_60033, VertexFormat.DrawMode.field_27379).build();
    public static final RenderPipeline STORM_PROBE = uvq.uwa(false);
    public static final RenderPipeline STORM_PROBE_BLUR = uvq.uwa(true);
    public static final RenderPipeline STORM_BOLT = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/storm_bolt")).withVertexShader(uvq.id("core/storm_bolt")).withFragmentShader(uvq.id("core/storm_bolt")).withSampler("DepthSampler").withUniform("Projection", UniformType.field_60031).withUniform("FlowStorm", UniformType.field_60031).withBlend(BlendFunction.TRANSLUCENT_PREMULTIPLIED_ALPHA).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.field_60033, VertexFormat.DrawMode.field_27379).build();
    public static final RenderPipeline STORM_WET = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/storm_wet")).withVertexShader(uvq.id("core/fog")).withFragmentShader(uvq.id("core/storm_wet")).withSampler("SceneSampler").withSampler("DepthSampler").withSampler("NoiseSampler").withSampler("HeightSampler").withSampler("ProbeSampler").withSampler("ProbeBlurSampler").withSampler("TerrainDepthSampler").withSampler("EntityDepthSampler").withUniform("Projection", UniformType.field_60031).withUniform("Fog", UniformType.field_60031).withUniform("FlowStorm", UniformType.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.field_60033, VertexFormat.DrawMode.field_27379).build();
    public static final RenderPipeline RAIN = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/rain")).withVertexShader(uvq.id("core/rain")).withFragmentShader(uvq.id("core/rain")).withSampler("HeightSampler").withUniform("Projection", UniformType.field_60031).withUniform("FlowStorm", UniformType.field_60031).withBlend(BlendFunction.TRANSLUCENT_PREMULTIPLIED_ALPHA).withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.field_60033, VertexFormat.DrawMode.field_27379).build();
    public static final RenderPipeline STORM_GRADE = uvq.uwb("storm_grade");
    public static final RenderPipeline STORM_DROPS = uvq.uwb("storm_drops");
    public static final RenderPipeline CLOUD_NOISE = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/cloud_noise")).withVertexShader(uvq.id("core/blur")).withFragmentShader(uvq.id("core/cloud_noise")).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.field_60033, VertexFormat.DrawMode.field_27379).build();
    public static final RenderPipeline CLOUD_W = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/cloud_w")).withVertexShader(uvq.id("core/blur")).withFragmentShader(uvq.id("core/cloud_noise")).withShaderDefine("WEATHER").withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.field_60033, VertexFormat.DrawMode.field_27379).build();
    public static final RenderPipeline CLOUD_MARCH = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/cloud_march")).withVertexShader(uvq.id("core/fog")).withFragmentShader(uvq.id("core/cloud_march")).withSampler("DepthSampler").withSampler("CloudNoise").withSampler("CloudW").withSampler("HeightSampler").withUniform("Projection", UniformType.field_60031).withUniform("Fog", UniformType.field_60031).withUniform("FlowCloud", UniformType.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.field_60033, VertexFormat.DrawMode.field_27379).build();
    public static final RenderPipeline CLOUD_RESOLVE = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/cloud_resolve")).withVertexShader(uvq.id("core/fog")).withFragmentShader(uvq.id("core/cloud_resolve")).withSampler("RawSampler").withSampler("HistorySampler").withSampler("DepthSampler").withUniform("Projection", UniformType.field_60031).withUniform("FlowCloud", UniformType.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.field_60033, VertexFormat.DrawMode.field_27379).build();
    public static final RenderPipeline CLOUD_RAYS = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/cloud_rays")).withVertexShader(uvq.id("core/fog")).withFragmentShader(uvq.id("core/cloud_rays")).withSampler("CloudSampler").withSampler("DepthSampler").withUniform("Projection", UniformType.field_60031).withUniform("FlowCloud", UniformType.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.field_60033, VertexFormat.DrawMode.field_27379).build();
    public static final RenderPipeline CLOUD_COMPOSITE = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/cloud_composite")).withVertexShader(uvq.id("core/fog")).withFragmentShader(uvq.id("core/cloud_composite")).withSampler("CloudSampler").withSampler("RaysSampler").withSampler("DepthSampler").withSampler("CloudNoise").withSampler("CloudW").withSampler("HeightSampler").withUniform("Projection", UniformType.field_60031).withUniform("FlowCloud", UniformType.field_60031).withBlend(BlendFunction.TRANSLUCENT_PREMULTIPLIED_ALPHA).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.field_60033, VertexFormat.DrawMode.field_27379).build();
    public static final RenderPipeline SKY = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/sky")).withVertexShader(uvq.id("core/fog")).withFragmentShader(uvq.id("core/sky")).withSampler("DepthSampler").withUniform("Projection", UniformType.field_60031).withUniform("Fog", UniformType.field_60031).withUniform("FlowSky", UniformType.field_60031).withBlend(BlendFunction.TRANSLUCENT).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.field_60033, VertexFormat.DrawMode.field_27379).build();
    public static final RenderPipeline WALL_SKY = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/wall_sky")).withVertexShader(uvq.id("core/blur")).withFragmentShader(uvq.id("core/wall_sky")).withUniform("FlowWall", UniformType.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.field_60033, VertexFormat.DrawMode.field_27379).build();
    public static final RenderPipeline WALL_PHOTO = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/wall_photo")).withVertexShader(uvq.id("core/blur")).withFragmentShader(uvq.id("core/wall_photo")).withSampler("InSampler").withUniform("FlowWall", UniformType.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.field_60033, VertexFormat.DrawMode.field_27379).build();
    public static final RenderPipeline VIDEO = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/video")).withVertexShader(uvq.id("core/blur")).withFragmentShader(uvq.id("core/video")).withSampler("YSampler").withSampler("UVSampler").withUniform("FlowVideo", UniformType.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.field_60033, VertexFormat.DrawMode.field_27379).build();
    public static final RenderPipeline MENU_SCENE = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/menu_scene")).withVertexShader(uvq.id("core/blur")).withFragmentShader(uvq.id("core/menu_scene")).withSampler("InSampler").withSampler("BlurSampler").withUniform("FlowScene", UniformType.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.field_60033, VertexFormat.DrawMode.field_27379).build();
    public static final RenderPipeline MOTION = uvq.uwc("motion", false);
    public static final RenderPipeline MOTION_FINE = uvq.uwc("motion_fine", true);
    public static final VertexFormat SHATTER_FORMAT = VertexFormat.builder().add("Position", VertexFormatElement.POSITION).add("Color", VertexFormatElement.COLOR).add("UV0", VertexFormatElement.UV0).add("Normal", VertexFormatElement.NORMAL).padding(1).build();
    public static final RenderPipeline SHATTER_BACK = uvq.uwd("shatter_back", true);
    public static final RenderPipeline SHATTER_FRONT = uvq.uwd("shatter_front", false);
    private static final Map<String, String> uvr = new HashMap<String, String>();
    private static final Map<RenderPipeline, Boolean> uvs = new IdentityHashMap<RenderPipeline, Boolean>();
    private static final ShaderSourceGetter uvt = (identifier, shaderType) -> {
        if (!NAMESPACE.equals(identifier.method_12836())) {
            return null;
        }
        String string = "/flow/shaders/" + identifier.method_12832() + (shaderType == ShaderType.VERTEX ? ".vsh" : ".fsh");
        return uvr.computeIfAbsent(string, uvq::uwe);
    };
    private static final String uvu = "#flow_include";
    private static /* synthetic */ long uvv;
    private static /* synthetic */ boolean uvw;

    private uvq() {
    }

    private static RenderPipeline uvx(String string, BlendFunction blendFunction) {
        return RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/" + string)).withVertexShader(uvq.id("core/quad")).withFragmentShader(uvq.id("core/quad")).withUniform("DynamicTransforms", UniformType.field_60031).withUniform("Projection", UniformType.field_60031).withBlend(blendFunction).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withCull(false).withVertexFormat(VertexFormats.field_1576, VertexFormat.DrawMode.field_27382).build();
    }

    private static RenderPipeline uvy(String string, BlendFunction blendFunction) {
        return RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/" + string)).withVertexShader(uvq.id("core/pattern")).withFragmentShader(uvq.id("core/pattern")).withUniform("DynamicTransforms", UniformType.field_60031).withUniform("Projection", UniformType.field_60031).withBlend(blendFunction).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withCull(false).withVertexFormat(RECT_FORMAT, VertexFormat.DrawMode.field_27382).build();
    }

    private static RenderPipeline uvz(String string) {
        return RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/" + string)).withVertexShader(uvq.id("core/blur")).withFragmentShader(uvq.id("core/" + string)).withSampler("InSampler").withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.field_60033, VertexFormat.DrawMode.field_27379).build();
    }

    private static RenderPipeline uwa(boolean bl) {
        RenderPipeline.Builder builder = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id(bl ? "pipeline/storm_probe_blur" : "pipeline/storm_probe")).withVertexShader(uvq.id("core/blur")).withFragmentShader(uvq.id("core/storm_probe")).withSampler(bl ? "ProbeSampler" : "NoiseSampler").withUniform("FlowStorm", UniformType.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.field_60033, VertexFormat.DrawMode.field_27379);
        if (bl) {
            builder.withShaderDefine("BLUR");
        }
        return builder.build();
    }

    private static RenderPipeline uwb(String string) {
        return RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/" + string)).withVertexShader(uvq.id("core/blur")).withFragmentShader(uvq.id("core/" + string)).withSampler("SceneSampler").withUniform("FlowStorm", UniformType.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.field_60033, VertexFormat.DrawMode.field_27379).build();
    }

    private static RenderPipeline uwc(String string, boolean bl) {
        RenderPipeline.Builder builder = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/" + string)).withVertexShader(uvq.id("core/fog")).withFragmentShader(uvq.id("core/motion")).withSampler("InSampler").withSampler("DepthSampler").withUniform("Projection", UniformType.field_60031).withUniform("FlowMotion", UniformType.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.field_60033, VertexFormat.DrawMode.field_27379);
        if (bl) {
            builder.withShaderDefine("FINE");
        }
        return builder.build();
    }

    private static RenderPipeline uwd(String string, boolean bl) {
        RenderPipeline.Builder builder = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/" + string)).withVertexShader(uvq.id("core/shatter")).withFragmentShader(uvq.id("core/shatter")).withSampler("SceneSampler").withUniform("Projection", UniformType.field_60031).withUniform("FlowShatter", UniformType.field_60031).withBlend(BlendFunction.TRANSLUCENT).withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withDepthWrite(!bl).withDepthBias(-1.0f, -2.0f).withCull(false).withVertexFormat(SHATTER_FORMAT, VertexFormat.DrawMode.field_27379);
        if (bl) {
            builder.withShaderDefine("BACK");
        }
        return builder.build();
    }

    public static Identifier id(String string) {
        return Identifier.method_60655((String)NAMESPACE, (String)string);
    }

    public static boolean ensure(RenderPipeline renderPipeline) {
        try {
            CompiledRenderPipeline compiledRenderPipeline = RenderSystem.getDevice().precompilePipeline(renderPipeline, uvt);
            boolean bl = compiledRenderPipeline.isValid();
            if (!bl && uvs.put(renderPipeline, Boolean.TRUE) == null) {
                System.out.println("pipeline " + renderPipeline.getLocation() + " failed to compile, using fallback");
            }
            return bl;
        }
        catch (Throwable throwable) {
            if (uvs.put(renderPipeline, Boolean.TRUE) == null) {
                System.out.println("pipeline " + renderPipeline.getLocation() + " unavailable: " + throwable);
            }
            return false;
        }
    }

    private static String uwe(String string) {
        String string2 = uvq.uwf(string);
        if (string2 == null || !string2.contains(uvu)) {
            return string2;
        }
        StringBuilder stringBuilder = new StringBuilder(string2.length() + 8192);
        for (String string3 : string2.split("\n", -1)) {
            String string4 = string3.trim();
            if (string4.startsWith(uvu)) {
                String string5;
                int n = string4.indexOf(34);
                int n2 = string4.lastIndexOf(34);
                String string6 = string5 = n2 > n ? uvq.uwf("/flow/shaders/core/" + string4.substring(n + 1, n2)) : null;
                if (string5 == null) {
                    return null;
                }
                stringBuilder.append(string5).append('\n');
                continue;
            }
            stringBuilder.append(string3).append('\n');
        }
        return stringBuilder.toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String uwf(String string) {
        try (InputStream inputStream = uvq.class.getResourceAsStream(string);){
            if (inputStream == null) {
                System.out.println("missing shader " + string);
                String string3 = null;
                return string3;
            }
            String string2 = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            return string2;
        }
        catch (IOException iOException) {
            System.out.println("can't read shader " + string + ": " + iOException);
            return null;
        }
    }

    private static /* synthetic */ int dbg(int n, int n2) {
        return n + n2 | 0x71E78441;
    }

    private static /* synthetic */ int dbh(int n, int n2) {
        return (n ^ n2) + 1491820409;
    }

    private static /* synthetic */ int dbi(int n, int n2) {
        return uvq.dbg(n, n2) ^ 0x743941D5;
    }
}

