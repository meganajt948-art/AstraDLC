// volumetric_fog_simple.fsh
#version 330

uniform sampler2D InSampler;
uniform sampler2D DepthSampler;
in vec2 texCoord;
layout(std140) uniform SamplerInfo { vec2 OutSize; vec2 InSize; };
layout(std140) uniform VolumetricFogConfig {
    vec3  FogColor;
    float Density;
    float Coverage;
};
out vec4 fragColor;

void main() {
    vec4 base = texture(InSampler, texCoord);
    float d = texture(DepthSampler, texCoord).r;

    // небо — максимальный туман
    // ближние объекты — без тумана
    // переход в зависимости от depth
    float f = smoothstep(0.3, 1.0, d) * Density;
    vec3 result = mix(base.rgb, FogColor, f);
    fragColor = vec4(result, base.a);
}