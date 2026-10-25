package a;

import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.CompiledRenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Builder;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.shaders.ShaderType;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormatElement;
import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
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
   public static final VertexFormat RECT_FORMAT = VertexFormat.builder()
      .add("Position", VertexFormatElement.POSITION)
      .add("Color", VertexFormatElement.COLOR)
      .add("UV0", VertexFormatElement.UV0)
      .add("UV1", VertexFormatElement.UV1)
      .add("UV2", VertexFormatElement.UV2)
      .add("LineWidth", VertexFormatElement.LINE_WIDTH)
      .build();
   public static final RenderPipeline RECT = RenderPipeline.builder()
      .withLocation(id("pipeline/rect"))
      .withVertexShader(id("core/rect"))
      .withFragmentShader(id("core/rect"))
      .withUniform("DynamicTransforms", UniformType.UNIFORM_BUFFER)
      .withUniform("Projection", UniformType.UNIFORM_BUFFER)
      .withBlend(BlendFunction.TRANSLUCENT)
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withCull(false)
      .withVertexFormat(RECT_FORMAT, DrawMode.QUADS)
      .build();
   public static final RenderPipeline ARC = RenderPipeline.builder()
      .withLocation(id("pipeline/arc"))
      .withVertexShader(id("core/rect"))
      .withFragmentShader(id("core/arc"))
      .withUniform("DynamicTransforms", UniformType.UNIFORM_BUFFER)
      .withUniform("Projection", UniformType.UNIFORM_BUFFER)
      .withBlend(BlendFunction.TRANSLUCENT)
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withCull(false)
      .withVertexFormat(RECT_FORMAT, DrawMode.QUADS)
      .build();
   public static final RenderPipeline GLASS = RenderPipeline.builder()
      .withLocation(id("pipeline/glass"))
      .withVertexShader(id("core/rect"))
      .withFragmentShader(id("core/glass"))
      .withUniform("DynamicTransforms", UniformType.UNIFORM_BUFFER)
      .withUniform("Projection", UniformType.UNIFORM_BUFFER)
      .withUniform("Globals", UniformType.UNIFORM_BUFFER)
      .withSampler("Sampler0")
      .withBlend(BlendFunction.TRANSLUCENT)
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withCull(false)
      .withVertexFormat(RECT_FORMAT, DrawMode.QUADS)
      .build();
   public static final RenderPipeline LIQUID = RenderPipeline.builder()
      .withLocation(id("pipeline/liquid"))
      .withVertexShader(id("core/rect"))
      .withFragmentShader(id("core/liquid"))
      .withUniform("DynamicTransforms", UniformType.UNIFORM_BUFFER)
      .withUniform("Projection", UniformType.UNIFORM_BUFFER)
      .withUniform("Globals", UniformType.UNIFORM_BUFFER)
      .withSampler("Sampler0")
      .withBlend(BlendFunction.TRANSLUCENT)
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withCull(false)
      .withVertexFormat(RECT_FORMAT, DrawMode.QUADS)
      .build();
   public static final RenderPipeline IMAGE = RenderPipeline.builder()
      .withLocation(id("pipeline/image"))
      .withVertexShader(id("core/rect"))
      .withFragmentShader(id("core/image"))
      .withUniform("DynamicTransforms", UniformType.UNIFORM_BUFFER)
      .withUniform("Projection", UniformType.UNIFORM_BUFFER)
      .withSampler("Sampler0")
      .withBlend(BlendFunction.TRANSLUCENT)
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withCull(false)
      .withVertexFormat(RECT_FORMAT, DrawMode.QUADS)
      .build();
   public static final RenderPipeline RECT_ADD = RenderPipeline.builder()
      .withLocation(id("pipeline/rect_add"))
      .withVertexShader(id("core/rect"))
      .withFragmentShader(id("core/rect"))
      .withUniform("DynamicTransforms", UniformType.UNIFORM_BUFFER)
      .withUniform("Projection", UniformType.UNIFORM_BUFFER)
      .withBlend(BlendFunction.LIGHTNING)
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withCull(false)
      .withVertexFormat(RECT_FORMAT, DrawMode.QUADS)
      .build();
   public static final RenderPipeline IMAGE_ADD = RenderPipeline.builder()
      .withLocation(id("pipeline/image_add"))
      .withVertexShader(id("core/rect"))
      .withFragmentShader(id("core/image"))
      .withUniform("DynamicTransforms", UniformType.UNIFORM_BUFFER)
      .withUniform("Projection", UniformType.UNIFORM_BUFFER)
      .withSampler("Sampler0")
      .withBlend(BlendFunction.LIGHTNING)
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withCull(false)
      .withVertexFormat(RECT_FORMAT, DrawMode.QUADS)
      .build();
   public static final RenderPipeline PATTERN = uvy("pattern", BlendFunction.TRANSLUCENT);
   public static final RenderPipeline PATTERN_ADD = uvy("pattern_add", BlendFunction.LIGHTNING);
   public static final RenderPipeline QUAD = uvx("quad", BlendFunction.TRANSLUCENT);
   public static final RenderPipeline QUAD_ADD = uvx("quad_add", BlendFunction.LIGHTNING);
   public static final RenderPipeline GRADE = RenderPipeline.builder()
      .withLocation(id("pipeline/grade"))
      .withVertexShader(id("core/blur"))
      .withFragmentShader(id("core/grade"))
      .withSampler("InSampler")
      .withSampler("BloomSampler")
      .withUniform("FlowGrade", UniformType.UNIFORM_BUFFER)
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withDepthWrite(false)
      .withCull(false)
      .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES)
      .build();
   public static final RenderPipeline BLUR_DOWN = uvz("blur_down");
   public static final RenderPipeline BLUR_UP = uvz("blur_up");
   public static final RenderPipeline BLUR_COPY = uvz("blur_copy");
   public static final RenderPipeline COMPOSITE = RenderPipeline.builder()
      .withLocation(id("pipeline/composite"))
      .withVertexShader(id("core/blur"))
      .withFragmentShader(id("core/composite"))
      .withSampler("InSampler")
      .withSampler("WallSampler")
      .withUniform("FlowComposite", UniformType.UNIFORM_BUFFER)
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withDepthWrite(false)
      .withCull(false)
      .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES)
      .build();
   public static final RenderPipeline FOG_MARCH = RenderPipeline.builder()
      .withLocation(id("pipeline/fog_march"))
      .withVertexShader(id("core/fog"))
      .withFragmentShader(id("core/fog_march"))
      .withSampler("DepthSampler")
      .withSampler("NoiseSampler")
      .withUniform("Projection", UniformType.UNIFORM_BUFFER)
      .withUniform("Fog", UniformType.UNIFORM_BUFFER)
      .withUniform("FlowFog", UniformType.UNIFORM_BUFFER)
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withDepthWrite(false)
      .withCull(false)
      .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES)
      .build();
   public static final RenderPipeline FOG_RESOLVE = RenderPipeline.builder()
      .withLocation(id("pipeline/fog_resolve"))
      .withVertexShader(id("core/fog"))
      .withFragmentShader(id("core/fog_resolve"))
      .withSampler("RawSampler")
      .withSampler("HistorySampler")
      .withSampler("DepthSampler")
      .withUniform("Projection", UniformType.UNIFORM_BUFFER)
      .withUniform("FlowFog", UniformType.UNIFORM_BUFFER)
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withDepthWrite(false)
      .withCull(false)
      .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES)
      .build();
   public static final RenderPipeline FOG_COMPOSITE = RenderPipeline.builder()
      .withLocation(id("pipeline/fog_composite"))
      .withVertexShader(id("core/fog"))
      .withFragmentShader(id("core/fog_composite"))
      .withSampler("FogSampler")
      .withSampler("DepthSampler")
      .withUniform("Projection", UniformType.UNIFORM_BUFFER)
      .withUniform("FlowFog", UniformType.UNIFORM_BUFFER)
      .withBlend(BlendFunction.TRANSLUCENT_PREMULTIPLIED_ALPHA)
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withDepthWrite(false)
      .withCull(false)
      .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES)
      .build();
   public static final RenderPipeline WET = RenderPipeline.builder()
      .withLocation(id("pipeline/wet"))
      .withVertexShader(id("core/fog"))
      .withFragmentShader(id("core/wet"))
      .withSampler("SceneSampler")
      .withSampler("DepthSampler")
      .withSampler("NoiseSampler")
      .withSampler("HeightSampler")
      .withUniform("Projection", UniformType.UNIFORM_BUFFER)
      .withUniform("Fog", UniformType.UNIFORM_BUFFER)
      .withUniform("FlowWet", UniformType.UNIFORM_BUFFER)
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withDepthWrite(false)
      .withCull(false)
      .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES)
      .build();
   public static final RenderPipeline SEASON = RenderPipeline.builder()
      .withLocation(id("pipeline/season"))
      .withVertexShader(id("core/fog"))
      .withFragmentShader(id("core/season"))
      .withSampler("SceneSampler")
      .withSampler("DepthSampler")
      .withSampler("NoiseSampler")
      .withSampler("HeightSampler")
      .withSampler("TerrainDepthSampler")
      .withSampler("EntityDepthSampler")
      .withUniform("Projection", UniformType.UNIFORM_BUFFER)
      .withUniform("Fog", UniformType.UNIFORM_BUFFER)
      .withUniform("FlowSeason", UniformType.UNIFORM_BUFFER)
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withDepthWrite(false)
      .withCull(false)
      .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES)
      .build();
   public static final RenderPipeline SEASON_PARTICLES = RenderPipeline.builder()
      .withLocation(id("pipeline/season_particles"))
      .withVertexShader(id("core/season_particles"))
      .withFragmentShader(id("core/season_particles"))
      .withSampler("HeightSampler")
      .withUniform("Projection", UniformType.UNIFORM_BUFFER)
      .withUniform("FlowSeason", UniformType.UNIFORM_BUFFER)
      .withBlend(BlendFunction.TRANSLUCENT_PREMULTIPLIED_ALPHA)
      .withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST)
      .withDepthWrite(false)
      .withCull(false)
      .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES)
      .build();
   public static final RenderPipeline SEASON_GRADE = RenderPipeline.builder()
      .withLocation(id("pipeline/season_grade"))
      .withVertexShader(id("core/fog"))
      .withFragmentShader(id("core/season_grade"))
      .withSampler("SceneSampler")
      .withUniform("Projection", UniformType.UNIFORM_BUFFER)
      .withUniform("FlowSeason", UniformType.UNIFORM_BUFFER)
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withDepthWrite(false)
      .withCull(false)
      .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES)
      .build();
   public static final RenderPipeline STORM_SKY = RenderPipeline.builder()
      .withLocation(id("pipeline/storm_sky"))
      .withVertexShader(id("core/fog"))
      .withFragmentShader(id("core/storm_sky"))
      .withSampler("DepthSampler")
      .withSampler("NoiseSampler")
      .withUniform("Projection", UniformType.UNIFORM_BUFFER)
      .withUniform("FlowStorm", UniformType.UNIFORM_BUFFER)
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withDepthWrite(false)
      .withCull(false)
      .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES)
      .build();
   public static final RenderPipeline STORM_SKY_COMPOSITE = RenderPipeline.builder()
      .withLocation(id("pipeline/storm_sky_composite"))
      .withVertexShader(id("core/fog"))
      .withFragmentShader(id("core/storm_sky"))
      .withShaderDefine("COMPOSITE")
      .withSampler("DepthSampler")
      .withSampler("HalfSampler")
      .withUniform("Projection", UniformType.UNIFORM_BUFFER)
      .withUniform("FlowStorm", UniformType.UNIFORM_BUFFER)
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withDepthWrite(false)
      .withCull(false)
      .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES)
      .build();
   public static final RenderPipeline STORM_PROBE = uwa(false);
   public static final RenderPipeline STORM_PROBE_BLUR = uwa(true);
   public static final RenderPipeline STORM_BOLT = RenderPipeline.builder()
      .withLocation(id("pipeline/storm_bolt"))
      .withVertexShader(id("core/storm_bolt"))
      .withFragmentShader(id("core/storm_bolt"))
      .withSampler("DepthSampler")
      .withUniform("Projection", UniformType.UNIFORM_BUFFER)
      .withUniform("FlowStorm", UniformType.UNIFORM_BUFFER)
      .withBlend(BlendFunction.TRANSLUCENT_PREMULTIPLIED_ALPHA)
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withDepthWrite(false)
      .withCull(false)
      .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES)
      .build();
   public static final RenderPipeline STORM_WET = RenderPipeline.builder()
      .withLocation(id("pipeline/storm_wet"))
      .withVertexShader(id("core/fog"))
      .withFragmentShader(id("core/storm_wet"))
      .withSampler("SceneSampler")
      .withSampler("DepthSampler")
      .withSampler("NoiseSampler")
      .withSampler("HeightSampler")
      .withSampler("ProbeSampler")
      .withSampler("ProbeBlurSampler")
      .withSampler("TerrainDepthSampler")
      .withSampler("EntityDepthSampler")
      .withUniform("Projection", UniformType.UNIFORM_BUFFER)
      .withUniform("Fog", UniformType.UNIFORM_BUFFER)
      .withUniform("FlowStorm", UniformType.UNIFORM_BUFFER)
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withDepthWrite(false)
      .withCull(false)
      .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES)
      .build();
   public static final RenderPipeline RAIN = RenderPipeline.builder()
      .withLocation(id("pipeline/rain"))
      .withVertexShader(id("core/rain"))
      .withFragmentShader(id("core/rain"))
      .withSampler("HeightSampler")
      .withUniform("Projection", UniformType.UNIFORM_BUFFER)
      .withUniform("FlowStorm", UniformType.UNIFORM_BUFFER)
      .withBlend(BlendFunction.TRANSLUCENT_PREMULTIPLIED_ALPHA)
      .withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST)
      .withDepthWrite(false)
      .withCull(false)
      .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES)
      .build();
   public static final RenderPipeline STORM_GRADE = uwb("storm_grade");
   public static final RenderPipeline STORM_DROPS = uwb("storm_drops");
   public static final RenderPipeline CLOUD_NOISE = RenderPipeline.builder()
      .withLocation(id("pipeline/cloud_noise"))
      .withVertexShader(id("core/blur"))
      .withFragmentShader(id("core/cloud_noise"))
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withDepthWrite(false)
      .withCull(false)
      .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES)
      .build();
   public static final RenderPipeline CLOUD_W = RenderPipeline.builder()
      .withLocation(id("pipeline/cloud_w"))
      .withVertexShader(id("core/blur"))
      .withFragmentShader(id("core/cloud_noise"))
      .withShaderDefine("WEATHER")
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withDepthWrite(false)
      .withCull(false)
      .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES)
      .build();
   public static final RenderPipeline CLOUD_MARCH = RenderPipeline.builder()
      .withLocation(id("pipeline/cloud_march"))
      .withVertexShader(id("core/fog"))
      .withFragmentShader(id("core/cloud_march"))
      .withSampler("DepthSampler")
      .withSampler("CloudNoise")
      .withSampler("CloudW")
      .withSampler("HeightSampler")
      .withUniform("Projection", UniformType.UNIFORM_BUFFER)
      .withUniform("Fog", UniformType.UNIFORM_BUFFER)
      .withUniform("FlowCloud", UniformType.UNIFORM_BUFFER)
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withDepthWrite(false)
      .withCull(false)
      .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES)
      .build();
   public static final RenderPipeline CLOUD_RESOLVE = RenderPipeline.builder()
      .withLocation(id("pipeline/cloud_resolve"))
      .withVertexShader(id("core/fog"))
      .withFragmentShader(id("core/cloud_resolve"))
      .withSampler("RawSampler")
      .withSampler("HistorySampler")
      .withSampler("DepthSampler")
      .withUniform("Projection", UniformType.UNIFORM_BUFFER)
      .withUniform("FlowCloud", UniformType.UNIFORM_BUFFER)
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withDepthWrite(false)
      .withCull(false)
      .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES)
      .build();
   public static final RenderPipeline CLOUD_RAYS = RenderPipeline.builder()
      .withLocation(id("pipeline/cloud_rays"))
      .withVertexShader(id("core/fog"))
      .withFragmentShader(id("core/cloud_rays"))
      .withSampler("CloudSampler")
      .withSampler("DepthSampler")
      .withUniform("Projection", UniformType.UNIFORM_BUFFER)
      .withUniform("FlowCloud", UniformType.UNIFORM_BUFFER)
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withDepthWrite(false)
      .withCull(false)
      .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES)
      .build();
   public static final RenderPipeline CLOUD_COMPOSITE = RenderPipeline.builder()
      .withLocation(id("pipeline/cloud_composite"))
      .withVertexShader(id("core/fog"))
      .withFragmentShader(id("core/cloud_composite"))
      .withSampler("CloudSampler")
      .withSampler("RaysSampler")
      .withSampler("DepthSampler")
      .withSampler("CloudNoise")
      .withSampler("CloudW")
      .withSampler("HeightSampler")
      .withUniform("Projection", UniformType.UNIFORM_BUFFER)
      .withUniform("FlowCloud", UniformType.UNIFORM_BUFFER)
      .withBlend(BlendFunction.TRANSLUCENT_PREMULTIPLIED_ALPHA)
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withDepthWrite(false)
      .withCull(false)
      .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES)
      .build();
   public static final RenderPipeline SKY = RenderPipeline.builder()
      .withLocation(id("pipeline/sky"))
      .withVertexShader(id("core/fog"))
      .withFragmentShader(id("core/sky"))
      .withSampler("DepthSampler")
      .withUniform("Projection", UniformType.UNIFORM_BUFFER)
      .withUniform("Fog", UniformType.UNIFORM_BUFFER)
      .withUniform("FlowSky", UniformType.UNIFORM_BUFFER)
      .withBlend(BlendFunction.TRANSLUCENT)
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withDepthWrite(false)
      .withCull(false)
      .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES)
      .build();
   public static final RenderPipeline WALL_SKY = RenderPipeline.builder()
      .withLocation(id("pipeline/wall_sky"))
      .withVertexShader(id("core/blur"))
      .withFragmentShader(id("core/wall_sky"))
      .withUniform("FlowWall", UniformType.UNIFORM_BUFFER)
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withDepthWrite(false)
      .withCull(false)
      .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES)
      .build();
   public static final RenderPipeline WALL_PHOTO = RenderPipeline.builder()
      .withLocation(id("pipeline/wall_photo"))
      .withVertexShader(id("core/blur"))
      .withFragmentShader(id("core/wall_photo"))
      .withSampler("InSampler")
      .withUniform("FlowWall", UniformType.UNIFORM_BUFFER)
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withDepthWrite(false)
      .withCull(false)
      .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES)
      .build();
   public static final RenderPipeline VIDEO = RenderPipeline.builder()
      .withLocation(id("pipeline/video"))
      .withVertexShader(id("core/blur"))
      .withFragmentShader(id("core/video"))
      .withSampler("YSampler")
      .withSampler("UVSampler")
      .withUniform("FlowVideo", UniformType.UNIFORM_BUFFER)
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withDepthWrite(false)
      .withCull(false)
      .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES)
      .build();
   public static final RenderPipeline MENU_SCENE = RenderPipeline.builder()
      .withLocation(id("pipeline/menu_scene"))
      .withVertexShader(id("core/blur"))
      .withFragmentShader(id("core/menu_scene"))
      .withSampler("InSampler")
      .withSampler("BlurSampler")
      .withUniform("FlowScene", UniformType.UNIFORM_BUFFER)
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withDepthWrite(false)
      .withCull(false)
      .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES)
      .build();
   public static final RenderPipeline MOTION = uwc("motion", false);
   public static final RenderPipeline MOTION_FINE = uwc("motion_fine", true);
   public static final VertexFormat SHATTER_FORMAT = VertexFormat.builder()
      .add("Position", VertexFormatElement.POSITION)
      .add("Color", VertexFormatElement.COLOR)
      .add("UV0", VertexFormatElement.UV0)
      .add("Normal", VertexFormatElement.NORMAL)
      .padding(1)
      .build();
   public static final RenderPipeline SHATTER_BACK = uwd("shatter_back", true);
   public static final RenderPipeline SHATTER_FRONT = uwd("shatter_front", false);
   private static final Map<String, String> uvr = new HashMap<>();
   private static final Map<RenderPipeline, Boolean> uvs = new IdentityHashMap<>();
   private static final ShaderSourceGetter uvt = (var0, var1) -> {
      if (!"flow2".equals(var0.getNamespace())) {
         return null;
      }

      String var2 = "/flow/shaders/" + var0.getPath() + (var1 == ShaderType.VERTEX ? ".vsh" : ".fsh");
      return uvr.computeIfAbsent(var2, uvq::uwe);
   };
   private static final String uvu = "#flow_include";

   private uvq() {
   }

   private static RenderPipeline uvx(String var0, BlendFunction var1) {
      return RenderPipeline.builder()
         .withLocation(id("pipeline/" + var0))
         .withVertexShader(id("core/quad"))
         .withFragmentShader(id("core/quad"))
         .withUniform("DynamicTransforms", UniformType.UNIFORM_BUFFER)
         .withUniform("Projection", UniformType.UNIFORM_BUFFER)
         .withBlend(var1)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withCull(false)
         .withVertexFormat(VertexFormats.POSITION_COLOR, DrawMode.QUADS)
         .build();
   }

   private static RenderPipeline uvy(String var0, BlendFunction var1) {
      return RenderPipeline.builder()
         .withLocation(id("pipeline/" + var0))
         .withVertexShader(id("core/pattern"))
         .withFragmentShader(id("core/pattern"))
         .withUniform("DynamicTransforms", UniformType.UNIFORM_BUFFER)
         .withUniform("Projection", UniformType.UNIFORM_BUFFER)
         .withBlend(var1)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withCull(false)
         .withVertexFormat(RECT_FORMAT, DrawMode.QUADS)
         .build();
   }

   private static RenderPipeline uvz(String var0) {
      return RenderPipeline.builder()
         .withLocation(id("pipeline/" + var0))
         .withVertexShader(id("core/blur"))
         .withFragmentShader(id("core/" + var0))
         .withSampler("InSampler")
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES)
         .build();
   }

   private static RenderPipeline uwa(boolean var0) {
      Builder var1 = RenderPipeline.builder()
         .withLocation(id(var0 ? "pipeline/storm_probe_blur" : "pipeline/storm_probe"))
         .withVertexShader(id("core/blur"))
         .withFragmentShader(id("core/storm_probe"))
         .withSampler(var0 ? "ProbeSampler" : "NoiseSampler")
         .withUniform("FlowStorm", UniformType.UNIFORM_BUFFER)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES);
      if (var0) {
         var1.withShaderDefine("BLUR");
      }

      return var1.build();
   }

   private static RenderPipeline uwb(String var0) {
      return RenderPipeline.builder()
         .withLocation(id("pipeline/" + var0))
         .withVertexShader(id("core/blur"))
         .withFragmentShader(id("core/" + var0))
         .withSampler("SceneSampler")
         .withUniform("FlowStorm", UniformType.UNIFORM_BUFFER)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES)
         .build();
   }

   private static RenderPipeline uwc(String var0, boolean var1) {
      Builder var2 = RenderPipeline.builder()
         .withLocation(id("pipeline/" + var0))
         .withVertexShader(id("core/fog"))
         .withFragmentShader(id("core/motion"))
         .withSampler("InSampler")
         .withSampler("DepthSampler")
         .withUniform("Projection", UniformType.UNIFORM_BUFFER)
         .withUniform("FlowMotion", UniformType.UNIFORM_BUFFER)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES);
      if (var1) {
         var2.withShaderDefine("FINE");
      }

      return var2.build();
   }

   private static RenderPipeline uwd(String var0, boolean var1) {
      Builder var2 = RenderPipeline.builder()
         .withLocation(id("pipeline/" + var0))
         .withVertexShader(id("core/shatter"))
         .withFragmentShader(id("core/shatter"))
         .withSampler("SceneSampler")
         .withUniform("Projection", UniformType.UNIFORM_BUFFER)
         .withUniform("FlowShatter", UniformType.UNIFORM_BUFFER)
         .withBlend(BlendFunction.TRANSLUCENT)
         .withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST)
         .withDepthWrite(!var1)
         .withDepthBias(-1.0F, -2.0F)
         .withCull(false)
         .withVertexFormat(SHATTER_FORMAT, DrawMode.TRIANGLES);
      if (var1) {
         var2.withShaderDefine("BACK");
      }

      return var2.build();
   }

   public static Identifier id(String var0) {
      return Identifier.of("flow2", var0);
   }

   public static boolean ensure(RenderPipeline var0) {
      try {
         CompiledRenderPipeline var1 = RenderSystem.getDevice().precompilePipeline(var0, uvt);
         boolean var2 = var1.isValid();
         if (!var2 && uvs.put(var0, Boolean.TRUE) == null) {
            System.out.println("pipeline " + var0.getLocation() + " failed to compile, using fallback");
         }

         return var2;
      } catch (Throwable var3) {
         if (uvs.put(var0, Boolean.TRUE) == null) {
            System.out.println("pipeline " + var0.getLocation() + " unavailable: " + var3);
         }

         return false;
      }
   }

   private static String uwe(String var0) {
      String var1 = uwf(var0);
      if (var1 != null && var1.contains("#flow_include")) {
         StringBuilder var2 = new StringBuilder(var1.length() + 8192);

         for (String var6 : var1.split("\n", -1)) {
            String var7 = var6.trim();
            if (var7.startsWith("#flow_include")) {
               int var8 = var7.indexOf(34);
               int var9 = var7.lastIndexOf(34);
               String var10 = var9 > var8 ? uwf("/flow/shaders/core/" + var7.substring(var8 + 1, var9)) : null;
               if (var10 == null) {
                  return null;
               }

               var2.append(var10).append('\n');
            } else {
               var2.append(var6).append('\n');
            }
         }

         return var2.toString();
      } else {
         return var1;
      }
   }

   private static String uwf(String var0) {
      try (InputStream var1 = uvq.class.getResourceAsStream(var0)) {
         if (var1 == null) {
            System.out.println("missing shader " + var0);
            return null;
         } else {
            return new String(var1.readAllBytes(), StandardCharsets.UTF_8);
         }
      } catch (IOException var6) {
         System.out.println("can't read shader " + var0 + ": " + var6);
         return null;
      }
   }
}
