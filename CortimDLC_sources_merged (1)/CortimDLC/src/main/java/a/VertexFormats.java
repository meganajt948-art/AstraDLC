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
 *  com.mojang.blaze3d.vertex.VertexFormat$class_5596
 *  com.mojang.blaze3d.vertex.VertexFormatElement
 *  net.minecraft.class_10789
 *  net.minecraft.class_12289
 *  net.minecraft.class_290
 *  net.minecraft.class_2960
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
import net.minecraft.class_10789;
import net.minecraft.class_12289;
import net.minecraft.class_290;
import net.minecraft.class_2960;

public final class VertexFormats {
    public static final String NAMESPACE = "flow2";
    public static final VertexFormat RECT_FORMAT = VertexFormat.builder().add("Position", VertexFormatElement.POSITION).add("Color", VertexFormatElement.COLOR).add("UV0", VertexFormatElement.UV0).add("UV1", VertexFormatElement.UV1).add("UV2", VertexFormatElement.UV2).add("LineWidth", VertexFormatElement.LINE_WIDTH).build();
    public static final RenderPipeline RECT = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/rect")).withVertexShader(VertexFormats.id("core/rect")).withFragmentShader(VertexFormats.id("core/rect")).withUniform("DynamicTransforms", class_10789.field_60031).withUniform("Projection", class_10789.field_60031).withBlend(BlendFunction.TRANSLUCENT).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withCull(false).withVertexFormat(RECT_FORMAT, VertexFormat.class_5596.field_27382).build();
    public static final RenderPipeline ARC = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/arc")).withVertexShader(VertexFormats.id("core/rect")).withFragmentShader(VertexFormats.id("core/arc")).withUniform("DynamicTransforms", class_10789.field_60031).withUniform("Projection", class_10789.field_60031).withBlend(BlendFunction.TRANSLUCENT).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withCull(false).withVertexFormat(RECT_FORMAT, VertexFormat.class_5596.field_27382).build();
    public static final RenderPipeline GLASS = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/glass")).withVertexShader(VertexFormats.id("core/rect")).withFragmentShader(VertexFormats.id("core/glass")).withUniform("DynamicTransforms", class_10789.field_60031).withUniform("Projection", class_10789.field_60031).withUniform("Globals", class_10789.field_60031).withSampler("Sampler0").withBlend(BlendFunction.TRANSLUCENT).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withCull(false).withVertexFormat(RECT_FORMAT, VertexFormat.class_5596.field_27382).build();
    public static final RenderPipeline LIQUID = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/liquid")).withVertexShader(VertexFormats.id("core/rect")).withFragmentShader(VertexFormats.id("core/liquid")).withUniform("DynamicTransforms", class_10789.field_60031).withUniform("Projection", class_10789.field_60031).withUniform("Globals", class_10789.field_60031).withSampler("Sampler0").withBlend(BlendFunction.TRANSLUCENT).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withCull(false).withVertexFormat(RECT_FORMAT, VertexFormat.class_5596.field_27382).build();
    public static final RenderPipeline IMAGE = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/image")).withVertexShader(VertexFormats.id("core/rect")).withFragmentShader(VertexFormats.id("core/image")).withUniform("DynamicTransforms", class_10789.field_60031).withUniform("Projection", class_10789.field_60031).withSampler("Sampler0").withBlend(BlendFunction.TRANSLUCENT).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withCull(false).withVertexFormat(RECT_FORMAT, VertexFormat.class_5596.field_27382).build();
    public static final RenderPipeline RECT_ADD = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/rect_add")).withVertexShader(VertexFormats.id("core/rect")).withFragmentShader(VertexFormats.id("core/rect")).withUniform("DynamicTransforms", class_10789.field_60031).withUniform("Projection", class_10789.field_60031).withBlend(BlendFunction.LIGHTNING).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withCull(false).withVertexFormat(RECT_FORMAT, VertexFormat.class_5596.field_27382).build();
    public static final RenderPipeline IMAGE_ADD = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/image_add")).withVertexShader(VertexFormats.id("core/rect")).withFragmentShader(VertexFormats.id("core/image")).withUniform("DynamicTransforms", class_10789.field_60031).withUniform("Projection", class_10789.field_60031).withSampler("Sampler0").withBlend(BlendFunction.LIGHTNING).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withCull(false).withVertexFormat(RECT_FORMAT, VertexFormat.class_5596.field_27382).build();
    public static final RenderPipeline PATTERN = VertexFormats.uvy("pattern", BlendFunction.TRANSLUCENT);
    public static final RenderPipeline PATTERN_ADD = VertexFormats.uvy("pattern_add", BlendFunction.LIGHTNING);
    public static final RenderPipeline QUAD = VertexFormats.uvx("quad", BlendFunction.TRANSLUCENT);
    public static final RenderPipeline QUAD_ADD = VertexFormats.uvx("quad_add", BlendFunction.LIGHTNING);
    public static final RenderPipeline GRADE = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/grade")).withVertexShader(VertexFormats.id("core/blur")).withFragmentShader(VertexFormats.id("core/grade")).withSampler("InSampler").withSampler("BloomSampler").withUniform("FlowGrade", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379).build();
    public static final RenderPipeline BLUR_DOWN = VertexFormats.uvz("blur_down");
    public static final RenderPipeline BLUR_UP = VertexFormats.uvz("blur_up");
    public static final RenderPipeline BLUR_COPY = VertexFormats.uvz("blur_copy");
    public static final RenderPipeline COMPOSITE = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/composite")).withVertexShader(VertexFormats.id("core/blur")).withFragmentShader(VertexFormats.id("core/composite")).withSampler("InSampler").withSampler("WallSampler").withUniform("FlowComposite", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379).build();
    public static final RenderPipeline FOG_MARCH = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/fog_march")).withVertexShader(VertexFormats.id("core/fog")).withFragmentShader(VertexFormats.id("core/fog_march")).withSampler("DepthSampler").withSampler("NoiseSampler").withUniform("Projection", class_10789.field_60031).withUniform("Fog", class_10789.field_60031).withUniform("FlowFog", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379).build();
    public static final RenderPipeline FOG_RESOLVE = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/fog_resolve")).withVertexShader(VertexFormats.id("core/fog")).withFragmentShader(VertexFormats.id("core/fog_resolve")).withSampler("RawSampler").withSampler("HistorySampler").withSampler("DepthSampler").withUniform("Projection", class_10789.field_60031).withUniform("FlowFog", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379).build();
    public static final RenderPipeline FOG_COMPOSITE = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/fog_composite")).withVertexShader(VertexFormats.id("core/fog")).withFragmentShader(VertexFormats.id("core/fog_composite")).withSampler("FogSampler").withSampler("DepthSampler").withUniform("Projection", class_10789.field_60031).withUniform("FlowFog", class_10789.field_60031).withBlend(BlendFunction.TRANSLUCENT_PREMULTIPLIED_ALPHA).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379).build();
    public static final RenderPipeline WET = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/MediaFoundationVideo")).withVertexShader(VertexFormats.id("core/fog")).withFragmentShader(VertexFormats.id("core/MediaFoundationVideo")).withSampler("SceneSampler").withSampler("DepthSampler").withSampler("NoiseSampler").withSampler("HeightSampler").withUniform("Projection", class_10789.field_60031).withUniform("Fog", class_10789.field_60031).withUniform("FlowWet", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379).build();
    public static final RenderPipeline SEASON = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/season")).withVertexShader(VertexFormats.id("core/fog")).withFragmentShader(VertexFormats.id("core/season")).withSampler("SceneSampler").withSampler("DepthSampler").withSampler("NoiseSampler").withSampler("HeightSampler").withSampler("TerrainDepthSampler").withSampler("EntityDepthSampler").withUniform("Projection", class_10789.field_60031).withUniform("Fog", class_10789.field_60031).withUniform("FlowSeason", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379).build();
    public static final RenderPipeline SEASON_PARTICLES = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/season_particles")).withVertexShader(VertexFormats.id("core/season_particles")).withFragmentShader(VertexFormats.id("core/season_particles")).withSampler("HeightSampler").withUniform("Projection", class_10789.field_60031).withUniform("FlowSeason", class_10789.field_60031).withBlend(BlendFunction.TRANSLUCENT_PREMULTIPLIED_ALPHA).withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379).build();
    public static final RenderPipeline SEASON_GRADE = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/season_grade")).withVertexShader(VertexFormats.id("core/fog")).withFragmentShader(VertexFormats.id("core/season_grade")).withSampler("SceneSampler").withUniform("Projection", class_10789.field_60031).withUniform("FlowSeason", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379).build();
    public static final RenderPipeline STORM_SKY = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/storm_sky")).withVertexShader(VertexFormats.id("core/fog")).withFragmentShader(VertexFormats.id("core/storm_sky")).withSampler("DepthSampler").withSampler("NoiseSampler").withUniform("Projection", class_10789.field_60031).withUniform("FlowStorm", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379).build();
    public static final RenderPipeline STORM_SKY_COMPOSITE = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/storm_sky_composite")).withVertexShader(VertexFormats.id("core/fog")).withFragmentShader(VertexFormats.id("core/storm_sky")).withShaderDefine("COMPOSITE").withSampler("DepthSampler").withSampler("HalfSampler").withUniform("Projection", class_10789.field_60031).withUniform("FlowStorm", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379).build();
    public static final RenderPipeline STORM_PROBE = VertexFormats.uwa(false);
    public static final RenderPipeline STORM_PROBE_BLUR = VertexFormats.uwa(true);
    public static final RenderPipeline STORM_BOLT = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/storm_bolt")).withVertexShader(VertexFormats.id("core/storm_bolt")).withFragmentShader(VertexFormats.id("core/storm_bolt")).withSampler("DepthSampler").withUniform("Projection", class_10789.field_60031).withUniform("FlowStorm", class_10789.field_60031).withBlend(BlendFunction.TRANSLUCENT_PREMULTIPLIED_ALPHA).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379).build();
    public static final RenderPipeline STORM_WET = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/storm_wet")).withVertexShader(VertexFormats.id("core/fog")).withFragmentShader(VertexFormats.id("core/storm_wet")).withSampler("SceneSampler").withSampler("DepthSampler").withSampler("NoiseSampler").withSampler("HeightSampler").withSampler("ProbeSampler").withSampler("ProbeBlurSampler").withSampler("TerrainDepthSampler").withSampler("EntityDepthSampler").withUniform("Projection", class_10789.field_60031).withUniform("Fog", class_10789.field_60031).withUniform("FlowStorm", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379).build();
    public static final RenderPipeline RAIN = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/rain")).withVertexShader(VertexFormats.id("core/rain")).withFragmentShader(VertexFormats.id("core/rain")).withSampler("HeightSampler").withUniform("Projection", class_10789.field_60031).withUniform("FlowStorm", class_10789.field_60031).withBlend(BlendFunction.TRANSLUCENT_PREMULTIPLIED_ALPHA).withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379).build();
    public static final RenderPipeline STORM_GRADE = VertexFormats.uwb("storm_grade");
    public static final RenderPipeline STORM_DROPS = VertexFormats.uwb("storm_drops");
    public static final RenderPipeline CLOUD_NOISE = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/cloud_noise")).withVertexShader(VertexFormats.id("core/blur")).withFragmentShader(VertexFormats.id("core/cloud_noise")).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379).build();
    public static final RenderPipeline CLOUD_W = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/cloud_w")).withVertexShader(VertexFormats.id("core/blur")).withFragmentShader(VertexFormats.id("core/cloud_noise")).withShaderDefine("WEATHER").withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379).build();
    public static final RenderPipeline CLOUD_MARCH = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/cloud_march")).withVertexShader(VertexFormats.id("core/fog")).withFragmentShader(VertexFormats.id("core/cloud_march")).withSampler("DepthSampler").withSampler("CloudNoise").withSampler("CloudW").withSampler("HeightSampler").withUniform("Projection", class_10789.field_60031).withUniform("Fog", class_10789.field_60031).withUniform("FlowCloud", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379).build();
    public static final RenderPipeline CLOUD_RESOLVE = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/cloud_resolve")).withVertexShader(VertexFormats.id("core/fog")).withFragmentShader(VertexFormats.id("core/cloud_resolve")).withSampler("RawSampler").withSampler("HistorySampler").withSampler("DepthSampler").withUniform("Projection", class_10789.field_60031).withUniform("FlowCloud", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379).build();
    public static final RenderPipeline CLOUD_RAYS = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/cloud_rays")).withVertexShader(VertexFormats.id("core/fog")).withFragmentShader(VertexFormats.id("core/cloud_rays")).withSampler("CloudSampler").withSampler("DepthSampler").withUniform("Projection", class_10789.field_60031).withUniform("FlowCloud", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379).build();
    public static final RenderPipeline CLOUD_COMPOSITE = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/cloud_composite")).withVertexShader(VertexFormats.id("core/fog")).withFragmentShader(VertexFormats.id("core/cloud_composite")).withSampler("CloudSampler").withSampler("RaysSampler").withSampler("DepthSampler").withSampler("CloudNoise").withSampler("CloudW").withSampler("HeightSampler").withUniform("Projection", class_10789.field_60031).withUniform("FlowCloud", class_10789.field_60031).withBlend(BlendFunction.TRANSLUCENT_PREMULTIPLIED_ALPHA).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379).build();
    public static final RenderPipeline SKY = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/sky")).withVertexShader(VertexFormats.id("core/fog")).withFragmentShader(VertexFormats.id("core/sky")).withSampler("DepthSampler").withUniform("Projection", class_10789.field_60031).withUniform("Fog", class_10789.field_60031).withUniform("FlowSky", class_10789.field_60031).withBlend(BlendFunction.TRANSLUCENT).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379).build();
    public static final RenderPipeline WALL_SKY = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/wall_sky")).withVertexShader(VertexFormats.id("core/blur")).withFragmentShader(VertexFormats.id("core/wall_sky")).withUniform("FlowWall", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379).build();
    public static final RenderPipeline WALL_PHOTO = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/wall_photo")).withVertexShader(VertexFormats.id("core/blur")).withFragmentShader(VertexFormats.id("core/wall_photo")).withSampler("InSampler").withUniform("FlowWall", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379).build();
    public static final RenderPipeline VIDEO = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/video")).withVertexShader(VertexFormats.id("core/blur")).withFragmentShader(VertexFormats.id("core/video")).withSampler("YSampler").withSampler("UVSampler").withUniform("FlowVideo", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379).build();
    public static final RenderPipeline MENU_SCENE = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/menu_scene")).withVertexShader(VertexFormats.id("core/blur")).withFragmentShader(VertexFormats.id("core/menu_scene")).withSampler("InSampler").withSampler("BlurSampler").withUniform("FlowScene", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379).build();
    public static final RenderPipeline MOTION = VertexFormats.uwc("motion", false);
    public static final RenderPipeline MOTION_FINE = VertexFormats.uwc("motion_fine", true);
    public static final VertexFormat SHATTER_FORMAT = VertexFormat.builder().add("Position", VertexFormatElement.POSITION).add("Color", VertexFormatElement.COLOR).add("UV0", VertexFormatElement.UV0).add("Normal", VertexFormatElement.NORMAL).padding(1).build();
    public static final RenderPipeline SHATTER_BACK = VertexFormats.uwd("shatter_back", true);
    public static final RenderPipeline SHATTER_FRONT = VertexFormats.uwd("shatter_front", false);
    private static final Map<String, String> uvr = new HashMap<String, String>();
    private static final Map<RenderPipeline, Boolean> uvs = new IdentityHashMap<RenderPipeline, Boolean>();
    private static final class_12289 uvt = (class_29602, shaderType) -> {
        if (!NAMESPACE.equals(class_29602.method_12836())) {
            return null;
        }
        String string = "/flow/shaders/" + class_29602.method_12832() + (shaderType == ShaderType.VERTEX ? ".vsh" : ".fsh");
        return uvr.computeIfAbsent(string, VertexFormats::uwe);
    };
    private static final String uvu = "#flow_include";
    private static /* synthetic */ long uvv;
    private static /* synthetic */ boolean uvw;

    private VertexFormats() {
    }

    private static RenderPipeline uvx(String string, BlendFunction blendFunction) {
        return RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/" + string)).withVertexShader(VertexFormats.id("core/quad")).withFragmentShader(VertexFormats.id("core/quad")).withUniform("DynamicTransforms", class_10789.field_60031).withUniform("Projection", class_10789.field_60031).withBlend(blendFunction).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withCull(false).withVertexFormat(class_290.field_1576, VertexFormat.class_5596.field_27382).build();
    }

    private static RenderPipeline uvy(String string, BlendFunction blendFunction) {
        return RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/" + string)).withVertexShader(VertexFormats.id("core/pattern")).withFragmentShader(VertexFormats.id("core/pattern")).withUniform("DynamicTransforms", class_10789.field_60031).withUniform("Projection", class_10789.field_60031).withBlend(blendFunction).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withCull(false).withVertexFormat(RECT_FORMAT, VertexFormat.class_5596.field_27382).build();
    }

    private static RenderPipeline uvz(String string) {
        return RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/" + string)).withVertexShader(VertexFormats.id("core/blur")).withFragmentShader(VertexFormats.id("core/" + string)).withSampler("InSampler").withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379).build();
    }

    private static RenderPipeline uwa(boolean bl) {
        RenderPipeline.Builder builder = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id(bl ? "pipeline/storm_probe_blur" : "pipeline/storm_probe")).withVertexShader(VertexFormats.id("core/blur")).withFragmentShader(VertexFormats.id("core/storm_probe")).withSampler(bl ? "ProbeSampler" : "NoiseSampler").withUniform("FlowStorm", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379);
        if (bl) {
            builder.withShaderDefine("BLUR");
        }
        return builder.build();
    }

    private static RenderPipeline uwb(String string) {
        return RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/" + string)).withVertexShader(VertexFormats.id("core/blur")).withFragmentShader(VertexFormats.id("core/" + string)).withSampler("SceneSampler").withUniform("FlowStorm", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379).build();
    }

    private static RenderPipeline uwc(String string, boolean bl) {
        RenderPipeline.Builder builder = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/" + string)).withVertexShader(VertexFormats.id("core/fog")).withFragmentShader(VertexFormats.id("core/motion")).withSampler("InSampler").withSampler("DepthSampler").withUniform("Projection", class_10789.field_60031).withUniform("FlowMotion", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379);
        if (bl) {
            builder.withShaderDefine("FINE");
        }
        return builder.build();
    }

    private static RenderPipeline uwd(String string, boolean bl) {
        RenderPipeline.Builder builder = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/" + string)).withVertexShader(VertexFormats.id("core/shatter")).withFragmentShader(VertexFormats.id("core/shatter")).withSampler("SceneSampler").withUniform("Projection", class_10789.field_60031).withUniform("FlowShatter", class_10789.field_60031).withBlend(BlendFunction.TRANSLUCENT).withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withDepthWrite(!bl).withDepthBias(-1.0f, -2.0f).withCull(false).withVertexFormat(SHATTER_FORMAT, VertexFormat.class_5596.field_27379);
        if (bl) {
            builder.withShaderDefine("BACK");
        }
        return builder.build();
    }

    public static class_2960 id(String string) {
        return class_2960.method_60655((String)NAMESPACE, (String)string);
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
        String string2 = VertexFormats.uwf(string);
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
                String string6 = string5 = n2 > n ? VertexFormats.uwf("/flow/shaders/core/" + string4.substring(n + 1, n2)) : null;
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
        try (InputStream inputStream = VertexFormats.class.getResourceAsStream(string);){
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
        return VertexFormats.dbg(n, n2) ^ 0x743941D5;
    }
}

