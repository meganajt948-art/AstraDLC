package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.render.model.BakedModelManager;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteContents;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.DisplayEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

public final class dyh {
   public static final int WIDTH = 256;
   public static final int HEIGHT = 170;
   private static final double dyi = 56.0;
   private static final long dyj = 45000000L;
   private static final int dyk = Math.max(1, Math.min(6, Runtime.getRuntime().availableProcessors() - 1));
   private static final ExecutorService dyl = Executors.newFixedThreadPool(dyk, var0 -> {
      Thread var1 = new Thread(var0, a.b("涻ᐠ黰\u0099謋ඨ랹㹅ꀁ⫤굴圇\ud9dc䁥쨡䳃", 422145517));
      var1.setDaemon(true);
      var1.setPriority(5);
      return var1;
   });
   private static final Map<BlockState, dxq> dym = new ConcurrentHashMap<>();
   private static final Map<Sprite, dxy> dyn = new ConcurrentHashMap<>();
   private static final long dyo = ead();
   private static final Direction[] dyp = Direction.values();
   private static final MinecraftClient dyq = MinecraftClient.getInstance();
   private static final Set<dyh> dyr = Collections.newSetFromMap(new IdentityHashMap<>());
   private static final double[] dys = eac();
   private final dtv dyt;
   private final int[] dyu = new int[43520];
   private final float[] dyv = new float[43520];
   private final List<dxe> dyw = new ArrayList<>();
   private final dye[] dyx = new dye[dyk * 3];
   private final long[] dyy = new long[dyk * 3];
   private List<Future<?>> dyz;
   private ClientWorld dza;
   private ClientPlayerEntity dzb;
   private float dzc;
   private long dzd;
   private int dze;
   private elb dzf;
   private long dzg;
   private long dzh;
   private boolean dzi;
   private String dzj = a.c(-1071423468, "携ᶁ非द芄х먆㟥ꦲ⌂꒤廜큼䧈쏬䔞｟瓯\uee5c栍");
   private Object dzk;
   private float dzl;
   private float dzm;
   private double dzn;
   private double dzo;
   private double dzp;
   private double dzq;
   private double dzr;
   private double dzs;
   private double dzt;
   private double dzu;
   private double dzv;
   private double dzw;
   private double dzx;
   private double dzy;
   private double dzz;

   dyh(dtv var1) {
      this.dyt = var1;
   }

   private static double[] eac() {
      double[] var0 = new double[61];

      for (int var1 = 0; var1 < var0.length; var1++) {
         var0[var1] = 0.18 + 0.82 * Math.pow(var1 / 60.0, 1.25);
      }

      return var0;
   }

   private static long ead() {
      try {
         return ejl.offset(SpriteContents.class, NativeImage.class);
      } catch (Throwable var1) {
         return -1L;
      }
   }

   public void demand() {
      this.dzh = System.currentTimeMillis() + 1000L;
   }

   public boolean isReady() {
      return this.dzi;
   }

   public float getRenderMillis() {
      return this.dzl;
   }

   public float getTraceMillis() {
      return this.dzm;
   }

   public String getStatus() {
      return this.dzj;
   }

   public List<dxe> labels() {
      return this.dyw;
   }

   public elb texture() {
      if (this.dyz != null) {
         for (Future var2 : this.dyz) {
            if (!var2.isDone()) {
               return this.dzi ? this.dzf : null;
            }
         }

         this.eaf();
      }

      long var5 = System.nanoTime();
      if (System.currentTimeMillis() <= this.dzh && var5 - this.dzg >= 45000000L) {
         this.dzg = var5;

         try {
            this.eah();
         } catch (Throwable var4) {
            this.dzj = a.d("錋\ueacc息︗痋\uf370䴳샘庍퐰只ꧮ✲뫲セ", -1631684451, -307171417) + var4.getClass().getSimpleName();
            this.dzi = false;
            this.dyz = null;
            dyr.remove(this);
         }
      }

      return this.dzi ? this.dzf : null;
   }

   static void awaitAll() {
      if (!dyr.isEmpty()) {
         for (dyh var1 : new ArrayList<>(dyr)) {
            var1.eae();
         }
      }
   }

   private void eae() {
      List var1 = this.dyz;
      if (var1 == null) {
         dyr.remove(this);
      } else {
         for (Future var3 : var1) {
            try {
               var3.get();
            } catch (Throwable var5) {
            }
         }
      }
   }

   private void eaf() {
      List var1 = this.dyz;
      this.dyz = null;
      dyr.remove(this);

      try {
         for (Future var11 : var1) {
            var11.get();
         }

         long var10 = this.dzd;

         for (long var7 : this.dyy) {
            var10 = Math.max(var10, var7);
         }

         this.dzm = this.dzm * 0.8F + (float)(var10 - this.dzd) / 1000000.0F * 0.2F;
         long var12 = System.nanoTime();
         this.eak(this.dza, this.dzb, this.dzc);
         this.eag();
         this.dzl = this.dzl * 0.8F + (float)(System.nanoTime() - var12) / 1000000.0F * 0.2F;
         this.dzi = true;
      } catch (Throwable var9) {
         Throwable var3 = var9.getCause() != null ? var9.getCause() : var9;
         this.dzj = a.c(-1517101114, "\udbf7ꈰ⢓뛫㴷뮌\u05cf蠤ᙱ鳌ᬖ\ue112濎\uf20e硇") + var3.getClass().getSimpleName();
         this.dzi = false;
      }

      this.dza = null;
      this.dzb = null;
   }

   private void eag() {
      if (this.dzf == null) {
         this.dzf = new elb(a.b("ែ湱\ue4ae竗\uf117瞵", -1310582873), 256, 170);
      }

      for (int var1 = 0; var1 < 170; var1++) {
         int var2 = var1 * 256;

         for (int var3 = 0; var3 < 256; var3++) {
            this.dzf.set(var3, var1, this.dyu[var2 + var3]);
         }
      }

      this.dzf.upload();
   }

   void reset() {
      this.dzi = false;
      this.dzj = a.b("歖ይ頲ي跨\u0b29땪㢉ꛞⱮꯈ冰\udf10䚤첀䩲\uf033箃\ue130条", -1364955272);
      this.dyw.clear();
   }

   void close() {
      this.eae();
      this.dyz = null;
      dyr.remove(this);
      if (this.dzf != null) {
         this.dzf.close();
         this.dzf = null;
      }

      this.dzi = false;
   }

   private boolean eah() {
      ClientPlayerEntity var1 = this.dyt.getPlayer();
      ClientWorld var2 = this.dyt.getWorld();
      if (var1 != null && var2 != null) {
         BakedModelManager var3 = dyq.getBakedModelManager();
         if (var3 != this.dzk) {
            this.dzk = var3;
            dym.clear();
            dyn.clear();
         }

         float var4 = this.dyt.partialTick();
         Vec3d var5 = var1.getCameraPosVec(var4);
         float var6 = var1.getYaw(var4);
         float var7 = var1.getPitch(var4);
         this.dzn = var5.x;
         this.dzo = var5.y;
         this.dzp = var5.z;
         double var8 = Math.toRadians(var6);
         double var10 = Math.toRadians(var7);
         this.dzq = -Math.sin(var8) * Math.cos(var10);
         this.dzr = -Math.sin(var10);
         this.dzs = Math.cos(var8) * Math.cos(var10);
         this.dzt = -Math.cos(var8);
         this.dzu = -Math.sin(var8);
         this.dzv = -this.dzu * this.dzr;
         this.dzw = this.dzu * this.dzq - this.dzt * this.dzs;
         this.dzx = this.dzt * this.dzr;
         double var12 = dyq.options == null ? 70.0 : dyq.options.getFov().getValue().intValue();
         this.dzz = Math.tan(Math.toRadians(var12) * 0.5);
         this.dzy = this.dzz * 256.0 / 170.0;
         dxv var14 = new dxv(var2, var1, this.dyt.crosshair);
         int var15 = this.dyx.length;
         boolean var16 = ++this.dze % 40 == 0;

         for (int var17 = 0; var17 < var15; var17++) {
            if (this.dyx[var17] == null) {
               this.dyx[var17] = new dye();
            }

            this.dyx[var17].begin(var14, var16);
         }

         this.dza = var2;
         this.dzb = var1;
         this.dzc = var4;
         this.dzd = System.nanoTime();
         ArrayList var20 = new ArrayList(var15);

         for (int var18 = 0; var18 < var15; var18++) {
            int var19 = var18;
            this.dyy[var19] = this.dzd;
            var20.add(dyl.submit(() -> {
               dye var3x = this.dyx[var19];
               int var4x = var19;

               while (var4x < 170) {
                  this.eai(var3x, var4x);
                  var4x += var15;
               }

               this.dyy[var19] = System.nanoTime();
            }));
         }

         this.dyz = var20;
         dyr.add(this);
         return true;
      } else {
         this.dzj = a.d("옭뾓㔼꼯⃥Ꙝ\u181a闹ྴ脝ۅﳇ牥", -630914101, 1761526234);
         return false;
      }
   }

   private void eai(dye var1, int var2) {
      double var3 = (1.0 - 2.0 * (var2 + 0.5) / 170.0) * this.dzz;
      int var5 = var2 * 256;

      for (int var6 = 0; var6 < 256; var6++) {
         double var7 = (2.0 * (var6 + 0.5) / 256.0 - 1.0) * this.dzy;
         double var9 = this.dzq + this.dzt * var7 + this.dzv * var3;
         double var11 = this.dzr + this.dzw * var3;
         double var13 = this.dzs + this.dzu * var7 + this.dzx * var3;
         double var15 = Math.sqrt(var9 * var9 + var11 * var11 + var13 * var13);
         var9 /= var15;
         var11 /= var15;
         var13 /= var15;
         this.dyu[var5 + var6] = var1.trace(this.dzn, this.dzo, this.dzp, var9, var11, var13);
         this.dyv[var5 + var6] = (float)var1.hitDistance;
      }
   }

   private boolean eaj(double var1, double var3, double var5, double[] var7) {
      double var8 = var1 - this.dzn;
      double var10 = var3 - this.dzo;
      double var12 = var5 - this.dzp;
      double var14 = var8 * this.dzq + var10 * this.dzr + var12 * this.dzs;
      if (var14 <= 0.05) {
         return false;
      }

      double var16 = var8 * this.dzt + var12 * this.dzu;
      double var18 = var8 * this.dzv + var10 * this.dzw + var12 * this.dzx;
      var7[0] = (var16 / var14 / this.dzy + 1.0) * 0.5 * 256.0;
      var7[1] = (1.0 - var18 / var14 / this.dzz) * 0.5 * 170.0;
      var7[2] = var14;
      return true;
   }

   private void eak(ClientWorld var1, ClientPlayerEntity var2, float var3) {
      this.dyw.clear();
      double[] var4 = new double[3];
      Entity var5 = var2.getRootVehicle();

      for (Entity var7 : var1.getEntities()) {
         if (var7 != var2 && var7 != var5 && !var7.isRemoved() && !(var7 instanceof DisplayEntity) && !var7.isInvisible()) {
            Vec3d var8 = var7.getLerpedPos(var3);
            double var9 = var8.x - this.dzn;
            double var11 = var8.y - this.dzo;
            double var13 = var8.z - this.dzp;
            if (!(var9 * var9 + var11 * var11 + var13 * var13 > 3136.0)) {
               Box var15 = var7.getBoundingBox().offset(var8.subtract(var7.getEntityPos()));
               int var16 = eal(var7);
               if (var7 instanceof OtherClientPlayerEntity) {
                  double var17 = Math.min(0.5, var15.getLengthY() * 0.28);
                  this.eam(var15.withMinY(var15.maxY - var17).expand(0.02, 0.0, 0.02), -2050932);
                  this.eam(var15.withMaxY(var15.maxY - var17), var16);
                  if (this.eaj(var8.x, var15.maxY + 0.35, var8.z, var4) && var4[0] >= 0.0 && var4[0] < 256.0 && var4[1] >= 0.0 && var4[1] < 170.0) {
                     int var19 = (int)var4[1] * 256 + (int)var4[0];
                     if (this.dyv[var19] + 0.5 >= var4[2] || var4[2] < 6.0) {
                        this.dyw.add(new dxe(var7.getName().getString(), (float)(var4[0] / 256.0), (float)(var4[1] / 170.0), -1));
                     }
                  }
               } else {
                  this.eam(var15, var16);
               }
            }
         }
      }
   }

   private static int eal(Entity var0) {
      if (var0 instanceof OtherClientPlayerEntity) {
         return -12685352;
      } else if (var0 instanceof ItemEntity) {
         return -863670;
      } else if (var0 instanceof HostileEntity) {
         return -8408516;
      } else {
         return var0 instanceof LivingEntity ? -3630230 : -6249300;
      }
   }

   private void eam(Box var1, int var2) {
      double[] var3 = new double[3];
      double var4 = Double.MAX_VALUE;
      double var6 = Double.MAX_VALUE;
      double var8 = -Double.MAX_VALUE;
      double var10 = -Double.MAX_VALUE;
      int var12 = 0;

      for (int var13 = 0; var13 < 8; var13++) {
         double var14 = (var13 & 1) == 0 ? var1.minX : var1.maxX;
         double var16 = (var13 & 2) == 0 ? var1.minY : var1.maxY;
         double var18 = (var13 & 4) == 0 ? var1.minZ : var1.maxZ;
         if (this.eaj(var14, var16, var18, var3)) {
            var12++;
            var4 = Math.min(var4, var3[0]);
            var8 = Math.max(var8, var3[0]);
            var6 = Math.min(var6, var3[1]);
            var10 = Math.max(var10, var3[1]);
         }
      }

      if (var12 >= 8) {
         int var48 = Math.max(0, (int)Math.floor(var4));
         int var49 = Math.min(255, (int)Math.ceil(var8));
         int var15 = Math.max(0, (int)Math.floor(var6));
         int var50 = Math.min(169, (int)Math.ceil(var10));

         for (int var17 = var15; var17 <= var50; var17++) {
            double var51 = (1.0 - 2.0 * (var17 + 0.5) / 170.0) * this.dzz;

            for (int var20 = var48; var20 <= var49; var20++) {
               double var21 = (2.0 * (var20 + 0.5) / 256.0 - 1.0) * this.dzy;
               double var23 = this.dzq + this.dzt * var21 + this.dzv * var51;
               double var25 = this.dzr + this.dzw * var51;
               double var27 = this.dzs + this.dzu * var21 + this.dzx * var51;
               double var29 = Math.sqrt(var23 * var23 + var25 * var25 + var27 * var27);
               var23 /= var29;
               var25 /= var29;
               var27 /= var29;
               double var31 = -Double.MAX_VALUE;
               double var33 = Double.MAX_VALUE;
               int var35 = -1;
               double[] var36 = new double[]{this.dzn, this.dzo, this.dzp};
               double[] var37 = new double[]{var23, var25, var27};
               double[] var38 = new double[]{var1.minX, var1.minY, var1.minZ};
               double[] var39 = new double[]{var1.maxX, var1.maxY, var1.maxZ};
               boolean var40 = false;

               for (int var41 = 0; var41 < 3; var41++) {
                  if (Math.abs(var37[var41]) < 1.0E-9) {
                     if (var36[var41] < var38[var41] || var36[var41] > var39[var41]) {
                        var40 = true;
                        break;
                     }
                  } else {
                     double var42 = (var38[var41] - var36[var41]) / var37[var41];
                     double var44 = (var39[var41] - var36[var41]) / var37[var41];
                     if (var42 > var44) {
                        double var46 = var42;
                        var42 = var44;
                        var44 = var46;
                     }

                     if (var42 > var31) {
                        var31 = var42;
                        var35 = var41;
                     }

                     var33 = Math.min(var33, var44);
                  }
               }

               if (!var40 && !(var31 > var33) && !(var31 <= 0.0)) {
                  int var55 = var17 * 256 + var20;
                  if (!(var31 >= this.dyv[var55])) {
                     double var56 = var35 == 1 ? (var37[1] < 0.0 ? 1.0 : 0.55) : (var35 == 0 ? 0.72 : 0.86);
                     double var57 = Math.min(1.0, var31 / 56.0);
                     int var58 = scale(var2, var56);
                     this.dyu[var55] = mix(var58, this.dyu[var55], var57 * var57 * 0.6);
                     this.dyv[var55] = (float)var31;
                  }
               }
            }
         }
      }
   }

   static int scale(int var0, double var1) {
      int var3 = (int)Math.min(255.0, (var0 >> 16 & 0xFF) * var1);
      int var4 = (int)Math.min(255.0, (var0 >> 8 & 0xFF) * var1);
      int var5 = (int)Math.min(255.0, (var0 & 0xFF) * var1);
      return 0xFF000000 | var3 << 16 | var4 << 8 | var5;
   }

   static int mul(int var0, int var1) {
      int var2 = (var0 >> 16 & 0xFF) * (var1 >> 16 & 0xFF) / 255;
      int var3 = (var0 >> 8 & 0xFF) * (var1 >> 8 & 0xFF) / 255;
      int var4 = (var0 & 0xFF) * (var1 & 0xFF) / 255;
      return var0 & 0xFF000000 | var2 << 16 | var3 << 8 | var4;
   }

   static int mix(int var0, int var1, double var2) {
      double var4 = 1.0 - var2;
      int var6 = (int)((var0 >> 16 & 0xFF) * var4 + (var1 >> 16 & 0xFF) * var2);
      int var7 = (int)((var0 >> 8 & 0xFF) * var4 + (var1 >> 8 & 0xFF) * var2);
      int var8 = (int)((var0 & 0xFF) * var4 + (var1 & 0xFF) * var2);
      return 0xFF000000 | var6 << 16 | var7 << 8 | var8;
   }

   private static dxy ean(Sprite var0) {
      return var0 != null && dyo >= 0L ? dyn.computeIfAbsent(var0, var0x -> {
         try {
            SpriteContents var1 = var0x.getContents();
            NativeImage var2 = (NativeImage)ejl.get(var1, dyo);
            int var3 = var1.getWidth();
            int var4 = var1.getHeight();
            if (var2 != null && var3 > 0 && var4 > 0) {
               int[] var5 = new int[var3 * var4];

               for (int var6 = 0; var6 < var4; var6++) {
                  for (int var7 = 0; var7 < var3; var7++) {
                     var5[var6 * var3 + var7] = var2.getColorArgb(var7, var6);
                  }
               }

               return new dxy(var3, var4, var5);
            } else {
               return null;
            }
         } catch (Throwable var8) {
            return null;
         }
      }) : null;
   }
}
