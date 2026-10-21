#version 330

uniform sampler2D InSampler;

in vec2 texCoord;

layout(std140) uniform SamplerInfo {
    vec2 OutSize;
    vec2 InSize;
};

layout(std140) uniform SaturationConfig {
    float Saturation;
};

out vec4 fragColor;

void main(){
    vec4 color = texture(InSampler, texCoord);
    float gray = dot(color.rgb, vec3(0.299, 0.587, 0.114));
    vec3 result = mix(vec3(gray), color.rgb, Saturation);
    fragColor = vec4(result, color.a);
}