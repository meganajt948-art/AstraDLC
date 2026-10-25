package a;

import flow.dev.a;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.lwjgl.openal.AL10;
import org.lwjgl.openal.AL11;
import org.lwjgl.openal.ALC10;
import org.lwjgl.openal.EXTEfx;
import org.lwjgl.openal.EXTThreadLocalContext;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

final class vsj {
   final long device;
   final long context;
   final boolean efx;
   final boolean hrtf;
   final Map<String, Integer> buffers = new HashMap<>();
   final Map<String, Float> lengths = new HashMap<>();
   final Map<Integer, Float> lengthOf = new HashMap<>();
   final List<vrs> pending = new ArrayList<>();
   final int sends;
   int bedHeavy;
   int bedLight;
   int low;
   final int[] ringHeavy = new int[4];
   final int[] ringLight = new int[4];
   final int[] thunder = new int[6];
   final float[] around = new float[]{1.0F, 1.0F, 1.0F, 1.0F};
   int filter;
   int nearEffect;
   int farEffect;
   int nearSlot;
   int farSlot;
   boolean eax;
   int nextThunder;
   float heavy;
   float light;
   float muffle;
   float clock;

   private vsj(long var1, long var3, boolean var5, int var6, boolean var7) {
      this.device = var1;
      this.context = var3;
      this.efx = var5;
      this.sends = var6;
      this.hrtf = var7;
   }

   static vsj open(String var0, boolean var1) {
      long var2 = 0L;
      if (var0 != null && !var0.isEmpty()) {
         var2 = ALC10.alcOpenDevice(var0);
      }

      if (var2 == 0L) {
         var2 = ALC10.alcOpenDevice((ByteBuffer)null);
      }

      if (var2 == 0L) {
         throw new IllegalStateException(a.d("\uf505貵ة頷Ꮯ镻⼣\ua6fd㢯뉲㗥쾕䅑\ud8ff劦푑", 1763258389, 964937070));
      } else {
         boolean var4 = false;
         boolean var5 = false;

         try {
            var4 = ALC10.alcIsExtensionPresent(var2, a.b("㳽䕁쾝凰\uda3d岑\ue6ce漴\uf171篃ﰎ", -2057683785));
            var5 = ALC10.alcIsExtensionPresent(var2, a.b("仺㝆붚⏷꠬⺁铛ᴸ荬\u09ca踃瑴缾", 1325485750));
         } catch (Throwable var18) {
         }

         MemoryStack var8 = MemoryStack.stackPush();

         long var6;
         try {
            IntBuffer var9 = var8.mallocInt(5);
            if (var4) {
               var9.put(131075).put(2);
            }

            if (var5) {
               var9.put(6546).put(var1 ? 1 : 0);
            }

            var9.put(0).flip();
            var6 = ALC10.alcCreateContext(var2, var9);
         } catch (Throwable var19) {
            if (var8 != null) {
               try {
                  var8.close();
               } catch (Throwable var14) {
                  var19.addSuppressed(var14);
               }
            }

            throw var19;
         }

         if (var8 != null) {
            var8.close();
         }

         if (var6 == 0L) {
            ALC10.alcCloseDevice(var2);
            throw new IllegalStateException(a.b("⇟塯틳䳭윅䆡ﯹ爧\uec75暨\ue138ᭅ間స虺\u0096뫕", -316923488));
         } else if (!EXTThreadLocalContext.alcSetThreadContext(var6)) {
            ALC10.alcDestroyContext(var6);
            ALC10.alcCloseDevice(var2);
            throw new UnsupportedOperationException(a.c(-1002985363, "ꠝ톭嬱씔仟존爰\ufbc5斟\uef67棵銇ᱜ藯ྱ褌㌬볂♤ꀾ⧦厺\udd65䛷삄䩔\uf3fd綽\ue757愊"));
         } else {
            int var20 = 0;
            if (var4) {
               try {
                  var20 = ALC10.alcGetInteger(var2, 131075);
               } catch (Throwable var17) {
               }
            }

            boolean var21 = false;
            if (var5) {
               try {
                  var21 = ALC10.alcGetInteger(var2, 6546) == 1;
               } catch (Throwable var16) {
               }
            }

            vsj var10 = new vsj(var2, var6, var4, var20, var21);

            try {
               var10.vsm();
               return var10;
            } catch (Throwable var15) {
               try {
                  var10.close();
               } catch (Throwable var13) {
               }

               throw var15;
            }
         }
      }
   }

   private void vsm() {
      AL10.alListenerf(4106, 1.0F);
      AL10.alListener3f(4100, 0.0F, 0.0F, 0.0F);
      this.bedHeavy = this.loop(a.c(943412742, "噾\u2fdcꔇ㭱낗㘑豏ֺ鯲ᅌ"), true);
      this.bedLight = this.loop(a.c(-693097230, "Ⲋ唨\udff3䆅쩣䳡\uf6b7罈\ue118段"), true);
      this.low = this.loop(a.b("鴳\ue491湊\uf03c篚ﵜ䜂컷傿\uda01", 1827577163), true);
      AL10.alSourcef(this.low, 4099, 0.62F);

      for (int var1 = 0; var1 < 4; var1++) {
         this.ringHeavy[var1] = this.loop(a.b("嗨ⱊꚑ㣧댁㖇这ج顤ዚ镓潬\ue1b9砉\uf25b", 132535701), false);
         this.ringLight[var1] = this.loop(a.b("剂⯠ꄻ㽍뒫㈩衿ƀ鿐ᕽ鋹棆\ue613羣\uf5f1", 1046958655), false);

         for (int var5 : new int[]{this.ringHeavy[var1], this.ringLight[var1]}) {
            AL10.alSource3f(var5, 4100, vss.vsz[var1][0] * 2.0F, 0.6F, vss.vsz[var1][1] * 2.0F);
         }
      }

      if (this.efx) {
         try {
            this.filter = EXTEfx.alGenFilters();
            EXTEfx.alFilteri(this.filter, 32769, 1);
         } catch (Throwable var7) {
            System.out.println(a.b("႑椲\ue3e5綁\uf64a烶쪲䌑\udd1d垰큹⨓\ua4ce㵨띨㇎讟ѓ黼ᢪ酇\ueb17旰\ufe67砗\uf2c3䭨씨忈\ud998剢격", -1732243258) + var7);
            this.filter = 0;
         }

         if (this.filter != 0 && this.sends > 0) {
            try {
               this.vsn();
            } catch (Throwable var6) {
               System.out.println(a.d("⚿弜헋䮯쁤䛘ﲜ甿\ueb33憞\ue657᰽鋠\u0b46腆ߠ붱㉽꣒⺄ꝩ\udd39叞졝丵쓷絗\uf311槶\uefff摖", 1478716138, 11488317) + var6);
               this.nearSlot = 0;
               this.farSlot = 0;
            }
         }
      }

      for (int var8 = 0; var8 < 6; var8++) {
         int var9 = AL10.alGenSources();
         AL10.alSourcei(var9, 514, 0);
         AL10.alSourcef(var9, 4129, 0.0F);
         AL10.alSourcef(var9, 4110, 2.0F);
         this.thunder[var8] = var9;
      }
   }

   private void vsn() {
      this.farEffect = EXTEfx.alGenEffects();
      this.nearEffect = EXTEfx.alGenEffects();
      AL10.alGetError();
      EXTEfx.alEffecti(this.farEffect, 32769, 32768);
      this.eax = AL10.alGetError() == 0;
      int var1 = this.eax ? '耀' : 1;
      EXTEfx.alEffecti(this.farEffect, 32769, var1);
      EXTEfx.alEffecti(this.nearEffect, 32769, var1);
      this.vso(this.farEffect, 1.0F, 0.6F, 0.5F, 0.2F, 1.0F, 5.5F, 0.35F, 0.25F, 0.22F, 1.2F, 0.09F, 0.25F, 0.35F);
      this.vso(this.nearEffect, 0.8F, 0.9F, 0.32F, 0.5F, 1.0F, 1.6F, 0.6F, 0.35F, 0.02F, 0.9F, 0.03F, 0.1F, 0.0F);
      if (AL10.alGetError() != 0) {
         throw new IllegalStateException(a.c(1816605253, "㈭䮋셋弩퓩剈\ue859懸ﾶ甔\uf2d4ࢩ虶ῖ閔፲ꤼ⚾뱟㨙돡즿䜊\udccc媢큲"));
      } else {
         this.farSlot = EXTEfx.alGenAuxiliaryEffectSlots();
         EXTEfx.alAuxiliaryEffectSloti(this.farSlot, 1, this.farEffect);
         this.nearSlot = EXTEfx.alGenAuxiliaryEffectSlots();
         EXTEfx.alAuxiliaryEffectSloti(this.nearSlot, 1, this.nearEffect);
      }
   }

   private void vso(
      int var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      float var13,
      float var14
   ) {
      if (this.eax) {
         EXTEfx.alEffectf(var1, 1, var2);
         EXTEfx.alEffectf(var1, 2, var3);
         EXTEfx.alEffectf(var1, 3, var4);
         EXTEfx.alEffectf(var1, 4, var5);
         EXTEfx.alEffectf(var1, 5, var6);
         EXTEfx.alEffectf(var1, 6, var7);
         EXTEfx.alEffectf(var1, 7, var8);
         EXTEfx.alEffectf(var1, 9, var9);
         EXTEfx.alEffectf(var1, 10, var10);
         EXTEfx.alEffectf(var1, 12, var11);
         EXTEfx.alEffectf(var1, 13, var12);
         EXTEfx.alEffectf(var1, 15, var13);
         EXTEfx.alEffectf(var1, 16, var14);
      } else {
         EXTEfx.alEffectf(var1, 1, var2);
         EXTEfx.alEffectf(var1, 2, var3);
         EXTEfx.alEffectf(var1, 3, var4);
         EXTEfx.alEffectf(var1, 4, var5);
         EXTEfx.alEffectf(var1, 5, var7);
         EXTEfx.alEffectf(var1, 6, var8);
         EXTEfx.alEffectf(var1, 7, var9);
         EXTEfx.alEffectf(var1, 8, var10);
         EXTEfx.alEffectf(var1, 9, var11);
         EXTEfx.alEffectf(var1, 10, var12);
      }
   }

   int buffer(String var1) {
      Integer var2 = this.buffers.get(var1);
      if (var2 != null) {
         return var2;
      } else {
         boolean var3 = var1.endsWith(a.c(-1464036961, "醹\ue846抗ﳧ眱"));
         vsd var4 = vss.vtx(var3 ? var1.substring(0, var1.length() - a.b("읥뺚㑋\uaa3b⇭", 557565763).length()) : var1);
         if (var4 == null) {
            throw new IllegalStateException(a.d("Ⅴ壔퉈䱪잡䄊\ufb42犹\ueca2", -1660836609, -660568580) + var1);
         } else {
            if (var3) {
               var4 = vss.vty(var4);
            }

            float var5 = (float)var4.data().remaining() / var4.channels() / var4.rate();

            int var6;
            try {
               var6 = AL10.alGenBuffers();
               AL10.alBufferData(var6, var4.channels() == 2 ? 4355 : 4353, var4.data(), var4.rate());
            } finally {
               MemoryUtil.memFree(var4.data());
            }

            this.buffers.put(var1, var6);
            this.lengths.put(var1, var5);
            return var6;
         }
      }
   }

   int loop(String var1, boolean var2) {
      int var3 = AL10.alGenSources();
      AL10.alSourcei(var3, 514, var2 ? 1 : 0);
      AL10.alSource3f(var3, 4100, 0.0F, 0.0F, 0.0F);
      AL10.alSourcef(var3, 4129, 0.0F);
      AL10.alSourcei(var3, 4103, 1);
      AL10.alSourcei(var3, 4105, this.buffer(var1));
      AL10.alSourcef(var3, 4106, 0.0F);
      this.lengthOf.put(var3, this.lengths.getOrDefault(var1, 10.0F));
      return var3;
   }

   String describe() {
      int var1 = 0;

      for (int var5 : this.thunder) {
         if (AL10.alGetSourcei(var5, 4112) == 4114) {
            var1++;
         }
      }

      int var6 = 0;

      for (int var7 = 0; var7 < 4; var7++) {
         if (AL10.alGetSourcei(this.ringHeavy[var7], 4112) == 4114 || AL10.alGetSourcei(this.ringLight[var7], 4112) == 4114) {
            var6++;
         }
      }

      boolean var8 = AL10.alGetSourcei(this.bedHeavy, 4112) == 4114 || AL10.alGetSourcei(this.bedLight, 4112) == 4114;
      return String.format(
         Locale.ROOT,
         a.b(
            "픫겅♃령㎠땔༄蛫ᣱ鉘ᗝ\uefff慺\uf8dc犜\uf47e並쇧嬋\udd42哣⻡ꀗ㯂붤㜰躛\u009c騸\u1c3a鞟楅\ue300竦ﳻ癒진䏱앪峁횘\ua87b≳ꗚ㽛녹ࣸ艚Н鿋ᇫ\ueb22拃\ue4c1繠\uf02a䮒쵊䝣\udeaa停⩉귲➮륥ッ誟ప虥᧟錑ᔵ\uecac晑\uf807珸\uf5a0伍욗壾툺呶⾐ꄇ㬽담㑔踅ǰ鮨ᵃ钊滶\ue03b篜\ufdcb睅줧䃩\uda42導ퟵ\ua9ff⍖몂㳯뙨ঐ菍Է齸\u169d\ue81b所\ue5b8翵\uf116䢎싷䐭\udf8e冋⬾괻⒐빜〴误ඡ蜇ẛ郲橤\ued91枒略猢쪙䱇옱姯팄問⳿꛴㡧돃㖁轶Ĥ颀ቐ鑡澨\ue15a",
            -1199909409
         ),
         this.filter != 0,
         this.farSlot != 0,
         this.eax,
         this.sends,
         this.hrtf,
         var8,
         var6,
         this.heavy,
         this.light,
         this.muffle,
         this.around[0],
         this.around[1],
         this.around[2],
         this.around[3],
         var1,
         this.pending.size(),
         this.buffers.size()
      );
   }

   boolean busy() {
      if (!(this.heavy > 0.002F) && !(this.light > 0.002F) && this.pending.isEmpty()) {
         for (int var4 : this.thunder) {
            if (AL10.alGetSourcei(var4, 4112) == 4114) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }

   boolean connected() {
      try {
         return ALC10.alcGetInteger(this.device, 787) != 0;
      } catch (Throwable var2) {
         return true;
      }
   }

   void update(float var1, float var2, float var3, float var4, float[] var5, float var6, float var7) {
      this.clock = (this.clock + var1) % 3600.0F;
      float var8 = Math.min(1.0F, var1 * 1.6F);
      this.heavy = this.heavy + (var2 - this.heavy) * var8;
      this.light = this.light + (var3 - this.light) * var8;
      this.muffle = this.muffle + (var4 - this.muffle) * Math.min(1.0F, var1 * 3.0F);

      for (int var9 = 0; var9 < 4; var9++) {
         this.around[var9] = this.around[var9] + (var5[var9] - this.around[var9]) * Math.min(1.0F, var1 * 2.5F);
      }

      MemoryStack var19 = MemoryStack.stackPush();

      try {
         FloatBuffer var10 = var19.floats(new float[]{var6, 0.0F, var7, 0.0F, 1.0F, 0.0F});
         AL10.alListenerfv(4111, var10);
      } catch (Throwable var18) {
         if (var19 != null) {
            try {
               var19.close();
            } catch (Throwable var17) {
               var18.addSuppressed(var17);
            }
         }

         throw var18;
      }

      if (var19 != null) {
         var19.close();
      }

      boolean var20 = this.filter != 0;
      float var21 = var20 ? 1.0F - 0.45F * this.muffle : 1.0F - 0.7F * this.muffle;
      float var11 = 0.62F;
      this.vsp(this.bedHeavy, 1.0F, 1.0F - 0.93F * this.muffle);
      this.vsp(this.bedLight, 1.0F, 1.0F - 0.93F * this.muffle);
      this.vsq(this.bedHeavy, this.nearSlot, 0.1F + 0.35F * this.muffle, 0.6F);
      this.vsq(this.bedLight, this.nearSlot, 0.1F + 0.35F * this.muffle, 0.6F);
      this.vsr(this.bedHeavy, this.heavy * var21 * var11);
      this.vsr(this.bedLight, this.light * var21 * var11);
      this.vsp(this.low, 1.0F, 0.05F);
      this.vsr(this.low, this.heavy * 0.42F * (1.0F - 0.3F * this.muffle));

      for (int var12 = 0; var12 < 4; var12++) {
         float var13 = this.around[var12];
         float var14 = 1.0F + 0.18F * (float)Math.sin(this.clock * 0.37F + var12 * 1.7F) + 0.1F * (float)Math.sin(this.clock * 0.91F + var12 * 2.9F);
         float var15 = (0.2F + 0.8F * var13) * var14 * 0.36F;
         float var16 = var20 ? 0.18F + 0.82F * var13 : 1.0F;
         this.vsp(this.ringHeavy[var12], 1.0F, var16);
         this.vsp(this.ringLight[var12], 1.0F, var16);
         this.vsq(this.ringHeavy[var12], this.nearSlot, 0.18F + 0.3F * this.muffle, 0.7F);
         this.vsq(this.ringLight[var12], this.nearSlot, 0.18F + 0.3F * this.muffle, 0.7F);
         this.vsr(this.ringHeavy[var12], this.heavy * var15 * (var20 ? 1.0F : 0.6F + 0.4F * var13));
         this.vsr(this.ringLight[var12], this.light * var15 * (var20 ? 1.0F : 0.6F + 0.4F * var13));
      }
   }

   private void vsp(int var1, float var2, float var3) {
      if (this.filter != 0) {
         EXTEfx.alFilterf(this.filter, 1, var2);
         EXTEfx.alFilterf(this.filter, 2, Math.max(0.0F, Math.min(1.0F, var3)));
         AL10.alSourcei(var1, 131077, this.filter);
      }
   }

   private void vsq(int var1, int var2, float var3, float var4) {
      if (this.filter != 0 && var2 != 0) {
         EXTEfx.alFilterf(this.filter, 1, Math.max(0.0F, Math.min(1.0F, var3)));
         EXTEfx.alFilterf(this.filter, 2, Math.max(0.0F, Math.min(1.0F, var4)));
         AL11.alSource3i(var1, 131078, var2, 0, this.filter);
      }
   }

   private void vsr(int var1, float var2) {
      int var3 = AL10.alGetSourcei(var1, 4112);
      if (var2 <= 0.0015F) {
         if (var3 == 4114) {
            AL10.alSourcePause(var1);
         }

         AL10.alSourcef(var1, 4106, 0.0F);
      } else {
         AL10.alSourcef(var1, 4106, Math.min(2.0F, var2));
         if (var3 != 4114) {
            if (var3 == 4113) {
               float var4 = this.lengthOf.getOrDefault(var1, 10.0F);
               AL10.alSourcef(var1, 4132, vss.vte.nextFloat() * Math.max(0.0F, var4 - 0.5F));
            }

            AL10.alSourcePlay(var1);
         }
      }
   }

   void fire(long var1) {
      for (int var3 = this.pending.size() - 1; var3 >= 0; var3--) {
         vrs var4 = this.pending.get(var3);
         if (var4.due() <= var1) {
            this.pending.remove(var3);
            this.clap(var4);
         }
      }
   }

   void clap(vrs var1) {
      int var2 = -1;

      for (int var3 = 0; var3 < 6; var3++) {
         int var4 = this.thunder[(this.nextThunder + var3) % 6];
         if (AL10.alGetSourcei(var4, 4112) != 4114) {
            var2 = (this.nextThunder + var3) % 6;
            break;
         }
      }

      if (var2 < 0) {
         var2 = this.nextThunder;
      }

      this.nextThunder = (var2 + 1) % 6;
      int var7 = this.thunder[var2];
      AL10.alSourceStop(var7);
      AL10.alSourcei(var7, 4105, this.buffer(var1.name()));
      float var8 = (float)Math.sqrt(var1.x() * var1.x() + var1.z() * var1.z());
      float var5 = var8 > 0.001F ? var1.x() / var8 : 0.0F;
      float var6 = var8 > 0.001F ? var1.z() / var8 : 1.0F;
      AL10.alSource3f(var7, 4100, var5 * 10.0F, 3.0F, var6 * 10.0F);
      AL10.alSourcef(var7, 4106, Math.min(2.0F, var1.gain()));
      AL10.alSourcef(var7, 4099, var1.pitch());
      this.vsp(var7, 1.0F, var1.high() * (1.0F - 0.8F * this.muffle));
      this.vsq(var7, this.farSlot, var1.wet() * (1.0F - 0.5F * this.muffle), 0.55F);
      AL10.alSourcePlay(var7);
   }

   void close() {
      try {
         ArrayList var1 = new ArrayList<>(List.of(this.bedHeavy, this.bedLight, this.low));

         for (int var2 = 0; var2 < 4; var2++) {
            var1.add(this.ringHeavy[var2]);
            var1.add(this.ringLight[var2]);
         }

         for (int var5 : this.thunder) {
            var1.add(var5);
         }

         for (int var16 : var1) {
            if (var16 != 0) {
               AL10.alSourceStop(var16);
               AL10.alDeleteSources(var16);
            }
         }

         if (this.efx) {
            try {
               for (int var22 : new int[]{this.nearSlot, this.farSlot}) {
                  if (var22 != 0) {
                     EXTEfx.alAuxiliaryEffectSloti(var22, 1, 0);
                     EXTEfx.alDeleteAuxiliaryEffectSlots(var22);
                  }
               }

               for (int var23 : new int[]{this.nearEffect, this.farEffect}) {
                  if (var23 != 0) {
                     EXTEfx.alDeleteEffects(var23);
                  }
               }

               if (this.filter != 0) {
                  EXTEfx.alDeleteFilters(this.filter);
               }
            } catch (Throwable var9) {
            }
         }

         for (int var19 : this.buffers.values()) {
            AL10.alDeleteBuffers(var19);
         }
      } finally {
         EXTThreadLocalContext.alcSetThreadContext(0L);
         ALC10.alcDestroyContext(this.context);
         ALC10.alcCloseDevice(this.device);
      }
   }
}
