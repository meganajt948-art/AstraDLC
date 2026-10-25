package a;

import flow.dev.a;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.HashMap;
import java.util.Map;
import org.lwjgl.openal.AL10;
import org.lwjgl.openal.ALC10;
import org.lwjgl.openal.EXTThreadLocalContext;
import org.lwjgl.system.MemoryUtil;

final class vne {
   final long device;
   final long context;
   final int[] sources = new int[8];
   final Map<String, vnv> voices = new HashMap<>();
   int filesVersion = -1;
   int next;

   private vne(long var1, long var3) {
      this.device = var1;
      this.context = var3;
   }

   static vne open(String var0) {
      long var1 = 0L;
      if (var0 != null && !var0.isEmpty()) {
         var1 = ALC10.alcOpenDevice(var0);
      }

      if (var1 == 0L) {
         var1 = ALC10.alcOpenDevice((ByteBuffer)null);
      }

      if (var1 == 0L) {
         throw new IllegalStateException(a.d("\ud809ꆹ⬥딻㻓롷ȯ诱ᖣ齾ᣩ\ue299汝\uf5f3羪諾", -1404293519, -681380346));
      }

      long var3 = ALC10.alcCreateContext(var1, (IntBuffer)null);
      if (var3 == 0L) {
         ALC10.alcCloseDevice(var1);
         throw new IllegalStateException(a.d("\uef43雳ᱯ艱ঙ輽㕥벻⋩꠴⾤헙嬏스䣦츊瑉", -1524178242, 1076235650));
      }

      if (!EXTThreadLocalContext.alcSetThreadContext(var3)) {
         ALC10.alcDestroyContext(var3);
         ALC10.alcCloseDevice(var1);
         throw new UnsupportedOperationException(a.c(1091838944, "⎐娠킼亙앒䏹尿灈\uee12擪\ue378ᤊ韑\u0e62萼ʁ뢡㝏귩⮳ꉫ\ud837囨쵺䬉쇙硰\uf630泚\uea87"));
      }

      vne var5 = new vne(var1, var3);
      AL10.alListenerf(4106, 1.0F);

      for (int var6 = 0; var6 < 8; var6++) {
         int var7 = AL10.alGenSources();
         AL10.alSourcei(var7, 514, 1);
         AL10.alSource3f(var7, 4100, 0.0F, 0.0F, 0.0F);
         AL10.alSourcef(var7, 4129, 0.0F);
         AL10.alSourcef(var7, 4110, 2.0F);
         var5.sources[var6] = var7;
      }

      String var8 = ALC10.alcGetString(var1, 4101);
      System.out
         .println(
            a.c(813833815, "ḗ枩\ued7f猂\uf8de繵쑲䷐펓夸\udef0⒋ꩋ㎩릵㽅蕄ુ遮ᘲ鿉\ue583止\uf0fc皛ﱓ䖮쮰兝휍岺ꉮ⠠놟㟖")
               + var8
               + (AL10.alGetError() == 0 ? "" : a.b("㛛佢엮宁큋囦\uecfd敭\ufb3f燢\uf674ఒ苅᭩鄧ៗ귂", -1753073942))
         );
      return var5;
   }

   int playing() {
      int var1 = 0;

      for (int var5 : this.sources) {
         if (AL10.alGetSourcei(var5, 4112) == 4114) {
            var1++;
         }
      }

      return var1;
   }

   boolean connected() {
      try {
         return ALC10.alcGetInteger(this.device, 787) != 0;
      } catch (Throwable var2) {
         return true;
      }
   }

   void play(String var1, boolean var2, float var3, float var4, float var5) {
      vnv var6 = this.vnh(var1, var2);
      int var7 = this.vnk();
      AL10.alSourceStop(var7);
      AL10.alSourcei(var7, 4105, var6.buffer());
      AL10.alSourcef(var7, 4106, var3);
      AL10.alSource3f(var7, 4100, var4, 0.0F, var5);
      AL10.alSourcef(var7, 4099, var6.pitch());
      AL10.alSourcePlay(var7);
   }

   private vnv vnh(String var1, boolean var2) {
      if (this.filesVersion != vpo.version()) {
         this.vnj();
         this.filesVersion = vpo.version();
      }

      String var3 = var1 + (var2 ? 43 : 45);
      vnv var4 = this.voices.get(var3);
      if (var4 != null) {
         return var4;
      }

      vpi var5 = null;
      boolean var6 = var2;
      if (var1.startsWith(a.b("\ua957탰娳쐝", 2129570096))) {
         var5 = vni(vqu.cue(var1.substring(a.c(-1731556794, "訡\uf386祅\ue76b").length())));
         if (var5 == null) {
            throw new IllegalStateException(a.b("뿼왌䳐틲夹\udf92旚\uec21爺", 1918943131) + var1);
         }
      }

      vpd var7 = var5 == null ? vpo.find(var1, var2) : null;
      if (var7 != null) {
         var5 = vpo.decode(var7.file());
         var6 = var2 || var7.own();
      }

      if (var5 == null) {
         var5 = vnb.load(vnb.has(var1) ? var1 : vnb.NAMES.get(0), var2);
         var6 = true;
      }

      if (var5 == null) {
         throw new IllegalStateException(a.b("蕜ﳬ癰\ue852掙\ue532彺횁䢚", -291011269) + var1);
      }

      ShortBuffer var8 = MemoryUtil.memAllocShort(var5.data().length);

      int var9;
      try {
         var8.put(var5.data()).flip();
         var9 = AL10.alGenBuffers();
         AL10.alBufferData(var9, var5.channels() == 2 ? 4355 : 4353, var8, var5.rate());
      } finally {
         MemoryUtil.memFree(var8);
      }

      var4 = new vnv(var9, var6 ? 1.0F : 0.8909F);
      this.voices.put(var3, var4);
      return var4;
   }

   private static vpi vni(float[] var0) {
      if (var0 == null) {
         return null;
      }

      short[] var1 = new short[var0.length];

      for (int var2 = 0; var2 < var0.length; var2++) {
         var1[var2] = (short)Math.max(-32767, Math.min(32767, Math.round(var0[var2] * 32767.0F)));
      }

      return new vpi(var1, 1, 44100);
   }

   private void vnj() {
      if (!this.voices.isEmpty()) {
         for (int var4 : this.sources) {
            AL10.alSourceStop(var4);
            AL10.alSourcei(var4, 4105, 0);
         }

         for (vnv var6 : this.voices.values()) {
            AL10.alDeleteBuffers(var6.buffer());
         }

         this.voices.clear();
      }
   }

   private int vnk() {
      for (int var1 = 0; var1 < 8; var1++) {
         int var2 = this.sources[(this.next + var1) % 8];
         if (AL10.alGetSourcei(var2, 4112) != 4114) {
            this.next = (this.next + var1 + 1) % 8;
            return var2;
         }
      }

      int var3 = this.sources[this.next];
      this.next = (this.next + 1) % 8;
      return var3;
   }

   void close() {
      try {
         for (int var4 : this.sources) {
            if (var4 != 0) {
               AL10.alSourceStop(var4);
               AL10.alDeleteSources(var4);
            }
         }

         for (vnv var9 : this.voices.values()) {
            AL10.alDeleteBuffers(var9.buffer());
         }
      } finally {
         EXTThreadLocalContext.alcSetThreadContext(0L);
         ALC10.alcDestroyContext(this.context);
         ALC10.alcCloseDevice(this.device);
      }
   }
}
