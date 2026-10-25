package a;

import flow.dev.a;
import net.fabricmc.loader.api.FabricLoader;

public final class jrn {
   public static final String DOWNLOAD = a.d(
      "횑꼼◯뮚ぎ뚶\u0cf0蔁ᬜ醯ᙷ\uec10拜ﭪ焣\uf7ce䷇쉛壤\udeb7圂ⴑꎠ㡺빎㓙赭Ϳ駂ᾕ鐪櫳\ue0f4祉８疩쩲䀙웑彺핼ꯓↄꘫ㳡늇ୟ臣\u07bb鰷ም\ue8df慿\ue72f緆\uf391䠯컣䓜\udd55厸⧥급⑄몈㌦襪ྛ藛ᨠ邢ᚈ\uef50既ﮡ灋\uf616",
      -1517792795,
      982288209
   );
   private static Boolean jro;

   private jrn() {
   }

   public static boolean available() {
      if (jro == null) {
         boolean var0;
         try {
            var0 = FabricLoader.getInstance().isModLoaded(a.c(2009649252, "퀎ꦷ⍶"));
            if (var0) {
               Class.forName(a.b("璣ക螝ᦴ鉼ᓀ꺃❳륷㎁둚丹삳奏판嗠\uefa7恹醙糜\uf54c輕ƴ驥᰽雷⽙ꄛ㯪붹", -451119921), false, jrn.class.getClassLoader());
            }
         } catch (Throwable var2) {
            var0 = false;
         }

         jro = var0;
      }

      return jro;
   }
}
