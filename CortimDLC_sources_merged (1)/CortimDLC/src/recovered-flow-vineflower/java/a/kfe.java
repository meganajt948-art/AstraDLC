package a;

import flow.dev.a;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import net.minecraft.client.MinecraftClient;
import sun.misc.Unsafe;

public abstract class kfe {
   private static Consumer<kfe> kff = var0 -> {};
   protected final MinecraftClient mc = MinecraftClient.method_1551();
   private final byte[] kfg;
   private final byte[] kfh;
   private final int kfi;
   private final int kfj;
   private transient SoftReference<String> kfk;
   private transient SoftReference<String> kfl;
   private final kfa kfm;
   private final List<vmo> kfn = new ArrayList<>();
   private boolean kfo;
   private int kfp = -1;
   private boolean kfq;

   protected kfe(String var1, String var2, kfa var3) {
      this.kfi = (int)(System.nanoTime() ^ System.identityHashCode(this));
      this.kfg = kft(var1, this.kfi);
      this.kfh = kft(var2, this.kfi);
      this.kfj = var1 == null ? 0 : var1.hashCode();
      this.kfm = var3;
      kfv(var1);
      kfv(var2);
   }

   private static byte[] kft(String var0, int var1) {
      if (var0 != null && !var0.isEmpty()) {
         byte[] var2 = var0.getBytes(StandardCharsets.UTF_8);

         for (int var3 = 0; var3 < var2.length; var3++) {
            var2[var3] ^= (byte)(var1 >>> (var3 & 3) * 8);
         }

         return var2;
      } else {
         return new byte[0];
      }
   }

   private static String kfu(byte[] var0, int var1) {
      if (var0 != null && var0.length != 0) {
         byte[] var2 = new byte[var0.length];

         for (int var3 = 0; var3 < var0.length; var3++) {
            var2[var3] = (byte)(var0[var3] ^ (byte)(var1 >>> (var3 & 3) * 8));
         }

         return new String(var2, StandardCharsets.UTF_8);
      } else {
         return "";
      }
   }

   private static void kfv(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         try {
            Field var1 = String.class.getDeclaredField(a.d("\udfc3ꙥⲻ닓㤔", -1992117635, -1157075507));
            Field var2 = Unsafe.class.getDeclaredField(a.c(-1497305792, "\ued3d钐Ṏ耏\u0be3赏㜎뻸₤"));
            var2.setAccessible(true);
            Unsafe var3 = (Unsafe)var2.get(null);
            Object var4 = var3.getObject(var0, var3.objectFieldOffset(var1));
            if (var4 instanceof byte[] var5) {
               Arrays.fill(var5, (byte)0);
            } else if (var4 instanceof char[] var6) {
               Arrays.fill(var6, '\u0000');
            }
         } catch (Throwable var7) {
         }
      }
   }

   protected <T extends vmo> T add(T var1) {
      this.kfn.add(var1);
      return (T)var1;
   }

   public String getName() {
      return kfu(this.kfg, this.kfi);
   }

   public int getNameHash() {
      return this.kfj;
   }

   public String getDisplayName() {
      SoftReference var1 = this.kfk;
      if (var1 != null) {
         String var2 = (String)var1.get();
         if (var2 != null) {
            return var2;
         }
      }

      String var3 = kfw(this.kfg, this.kfi);
      this.kfk = new SoftReference<>(var3);
      return var3;
   }

   public String getDescription() {
      return kfu(this.kfh, this.kfi);
   }

   public String getDisplayDescription() {
      SoftReference var1 = this.kfl;
      if (var1 != null) {
         String var2 = (String)var1.get();
         if (var2 != null) {
            return var2;
         }
      }

      String var3 = kfw(this.kfh, this.kfi);
      this.kfl = new SoftReference<>(var3);
      return var3;
   }

   public void wipeCache() {
      this.kfk = null;
      this.kfl = null;
   }

   private static String kfw(byte[] var0, int var1) {
      if (var0 != null && var0.length != 0) {
         byte[] var2 = new byte[var0.length];

         for (int var3 = 0; var3 < var0.length; var3++) {
            var2[var3] = (byte)(var0[var3] ^ (byte)(var1 >>> (var3 & 3) * 8));
         }

         boolean var8 = true;

         for (byte var7 : var2) {
            if ((var7 & 128) != 0) {
               var8 = false;
               break;
            }
         }

         if (var8) {
            StringBuilder var10 = new StringBuilder(var2.length * 2 - 1);

            for (int var12 = 0; var12 < var2.length; var12++) {
               if (var12 > 0) {
                  var10.append('\u200c');
               }

               var10.append((char)(var2[var12] & 255));
            }

            Arrays.fill(var2, (byte)0);
            return var10.toString();
         } else {
            String var9 = new String(var2, StandardCharsets.UTF_8);
            Arrays.fill(var2, (byte)0);
            StringBuilder var11 = new StringBuilder(var9.length() * 2 - 1);

            for (int var13 = 0; var13 < var9.length(); var13++) {
               if (var13 > 0) {
                  var11.append('\u200c');
               }

               var11.append(var9.charAt(var13));
            }

            kfv(var9);
            return var11.toString();
         }
      } else {
         return "";
      }
   }

   public kfa getCategory() {
      return this.kfm;
   }

   public List<vmo> getSettings() {
      return this.kfn;
   }

   public boolean isEnabled() {
      return this.kfo;
   }

   public int getKey() {
      return this.kfp;
   }

   public void setKey(int var1) {
      this.kfp = var1;
   }

   public boolean isExpanded() {
      return this.kfq;
   }

   public void setExpanded(boolean var1) {
      this.kfq = var1;
   }

   public boolean isAction() {
      return false;
   }

   public boolean isVip() {
      return false;
   }

   public boolean isMaintenance() {
      return false;
   }

   public final boolean isLocked() {
      return this.isVip() || this.isMaintenance();
   }

   public boolean isHidden() {
      return false;
   }

   public void onConfigLoaded(boolean var1) {
   }

   public void toggle() {
      this.setEnabled(!this.kfo);
   }

   public void setEnabled(boolean var1) {
      if (this.kfo != var1 && (!var1 || !dry.armed() && !this.isLocked())) {
         this.kfo = var1;
         if (var1) {
            this.onEnable();
         } else {
            this.onDisable();
         }

         kff.accept(this);
      }
   }

   public void setEnabledSilently(boolean var1) {
      if (this.kfo != var1 && (!var1 || !dry.armed() && !this.isLocked())) {
         this.kfo = var1;
         if (var1) {
            this.onEnable();
         } else {
            this.onDisable();
         }
      }
   }

   public static void onToggle(Consumer<kfe> var0) {
      kff = kff.andThen(var0);
   }

   protected void onEnable() {
   }

   protected void onDisable() {
   }

   public boolean ticksWhenOff() {
      return false;
   }

   public void onStartTick(MinecraftClient var1) {
   }

   public void onEndTick(MinecraftClient var1) {
   }

   public void onKey(MinecraftClient var1, int var2) {
   }

   public boolean keysAtStart() {
      return false;
   }

   public void onWorldRender(MinecraftClient var1) {
   }

   public void onWorldRenderLate(MinecraftClient var1) {
   }

   public void onWorldRenderFinal(MinecraftClient var1) {
   }
}
