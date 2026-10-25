package a;

import flow.dev.a;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;

public final class tkc {
   private static final int tkd = 1200;
   private static final long tke = 180000L;
   public final tiq profile;
   private final tmh tkf = new tmh();
   private final List<tme> tkg = new ArrayList<>();
   private final String tkh;
   private final ArrayDeque<Integer> tki = new ArrayDeque<>();
   private boolean tkj = true;
   private int tkk;
   private int tkl;
   private float tkm;
   private float tkn;
   private int tko;
   private int tkp;
   private int tkq;
   private boolean tkr;
   private boolean tks;
   private long tkt = System.currentTimeMillis();
   public int hits;
   public int samples;
   public int failures;
   private int tku;
   public int recorded;
   public boolean paused;
   public String pauseReason = "";

   public tkc(tiq var1, int var2, Vec3d var3, float var4) {
      this.profile = var1;
      this.tkh = var1.newTapeName();
      this.tkf.created = System.currentTimeMillis();
      this.tkf.source = var2;
      this.tkf.originX = Math.floor(var3.field_1352);
      this.tkf.originY = Math.floor(var3.field_1351);
      this.tkf.originZ = Math.floor(var3.field_1350);
      this.tkf.unit = var4;
   }

   public void presses(int var1) {
      this.tkk += var1;
   }

   public void hit(Entity var1, Vec3d var2, ClientPlayerEntity var3) {
      if (this.tkl == 0) {
         Box var4 = var1.method_5829();
         double var5 = (var4.field_1323 + var4.field_1320) * 0.5;
         double var7 = (var4.field_1321 + var4.field_1324) * 0.5;
         Vec3d var9 = var3.method_33571();
         this.tkl = var1.method_5628() == 0 ? 1 : var1.method_5628();
         this.tkm = (float)tbp.hitU(var9.field_1352, var9.field_1350, var5, var7, (var4.field_1320 - var4.field_1323) * 0.5, var2.field_1352, var2.field_1350);
         this.tkn = (float)tbp.hitV(var4.field_1322, var4.field_1325 - var4.field_1322, var2.field_1351);
      }
   }

   public void aim(MinecraftClient var1, List<? extends Entity> var2) {
      ClientPlayerEntity var3 = var1.field_1724;
      if (this.tkl == 0 && var3 != null && var1.field_1687 != null) {
         Vec3d var4 = var3.method_33571();
         Vec3d var5 = var4.method_1019(var3.method_5828(1.0F).method_1021(8.0));
         double var6 = 8.0;
         BlockHitResult var8 = var1.field_1687.method_17742(new RaycastContext(var4, var5, ShapeType.field_17558, FluidHandling.field_1348, var3));
         if (var8.method_17783() != Type.field_1333) {
            var6 = var8.method_17784().method_1022(var4);
         }

         Entity var9 = null;
         Vec3d var10 = null;
         double var11 = var6;

         for (Entity var14 : var2) {
            Box var15 = var14.method_5829().method_1014(var14.method_5871());
            Optional var16 = var15.method_992(var4, var5);
            if (var16.isPresent() && ((Vec3d)var16.get()).method_1022(var4) < var11) {
               var11 = ((Vec3d)var16.get()).method_1022(var4);
               var9 = var14;
               var10 = (Vec3d)var16.get();
            }
         }

         if (var9 != null) {
            this.hit(var9, var10, var3);
         }
      }
   }

   public void pause(String var1) {
      this.paused = true;
      this.pauseReason = var1;
      this.tkj = true;
      this.tkk = 0;
      this.tkl = 0;
   }

   public void tick(MinecraftClient var1, List<? extends Entity> var2) {
      ClientPlayerEntity var3 = var1.field_1724;
      if (var3 != null) {
         this.paused = false;
         this.pauseReason = "";
         tme var4 = new tme();
         var4.flags = 1 | (var3.method_24828() ? 2 : 0) | (this.tkj ? 4 : 0);
         this.tkj = false;
         var4.yaw = var3.method_36454();
         var4.pitch = var3.method_36455();
         Vec3d var5 = var3.method_33571();
         var4.eyeX = (float)(var5.field_1352 - this.tkf.originX);
         var4.eyeY = (float)(var5.field_1351 - this.tkf.originY);
         var4.eyeZ = (float)(var5.field_1350 - this.tkf.originZ);
         var4.cooldown = var3.method_7261(0.5F);
         var4.presses = this.tkk;
         var4.hitId = this.tkl;
         var4.hitU = this.tkm;
         var4.hitV = this.tkn;
         int var6 = Math.min(var2.size(), 6);
         var4.ids = new int[var6];
         var4.boxes = new float[var6 * 5];

         for (int var7 = 0; var7 < var6; var7++) {
            Entity var8 = (Entity)var2.get(var7);
            Box var9 = var8.method_5829();
            var4.ids[var7] = var8.method_5628() == 0 ? 1 : var8.method_5628();
            var4.boxes[var7 * 5] = (float)((var9.field_1323 + var9.field_1320) * 0.5 - this.tkf.originX);
            var4.boxes[var7 * 5 + 1] = (float)(var9.field_1322 - this.tkf.originY);
            var4.boxes[var7 * 5 + 2] = (float)((var9.field_1321 + var9.field_1324) * 0.5 - this.tkf.originZ);
            var4.boxes[var7 * 5 + 3] = (float)((var9.field_1320 - var9.field_1323) * 0.5);
            var4.boxes[var7 * 5 + 4] = (float)(var9.field_1325 - var9.field_1322);
         }

         int var10 = this.tkg.size();
         this.tkg.add(var4);
         this.recorded++;
         if ((var4.flags & 4) != 0) {
            this.tku = var10;
         }

         if (this.tkl != 0) {
            this.hits++;
            this.samples = this.samples + Math.max(0, Math.min(var10 - this.tku, 60));
            this.tku = var10;
            this.tki.clear();
         }

         int var11 = this.tkk - (this.tkl != 0 ? 1 : 0);
         if (this.tkl == 0 && var11 > 0) {
            this.tki.add(var10);
         }

         while (!this.tki.isEmpty() && var10 - this.tki.peekFirst() > 8) {
            this.tku = Math.max(this.tku, this.tki.pollFirst());
            this.failures++;
         }

         this.tkk = 0;
         this.tkl = 0;
         if (this.tkg.size() - this.tko >= 1200) {
            this.save();
         }
      }
   }

   public void save() {
      if (this.tkg.size() > this.tko || this.failures != this.tkq || this.tks) {
         boolean var1 = this.tkg.size() > this.tko || this.tks;
         ArrayList var2 = new ArrayList<>(this.tkg);
         this.profile.add(a.d("鲡\ue50d濔\uf1ad穢", 563037651, 962517251), var2.size() - this.tko);
         this.profile.add(a.c(1583620581, "↉堹틷䲁"), this.hits - this.tkp);
         this.profile.add(a.d("\uf231讏ř鼰ᓶ鉐⠔ꇤ", -674687841, -1441601856), this.failures - this.tkq);
         this.tko = var2.size();
         this.tkp = this.hits;
         this.tkq = this.failures;
         this.profile.save();
         if (var1) {
            tmh var3 = new tmh();
            var3.created = this.tkf.created;
            var3.unit = this.tkf.unit;
            var3.originX = this.tkf.originX;
            var3.originY = this.tkf.originY;
            var3.originZ = this.tkf.originZ;
            var3.source = this.tkf.source;
            var3.ticks.addAll(var2);
            this.profile.putTape(this.tkh, var3);
            long var4 = System.currentTimeMillis();
            if (this.tks || var4 - this.tkt > 180000L) {
               this.tks = false;
               this.tkt = var4;
               this.profile.uploadTape(this.tkh, var3);
            }
         }
      }
   }

   public void finish() {
      while (!this.tki.isEmpty()) {
         this.tki.pollFirst();
         this.failures++;
      }

      if (this.recorded > 0 && !this.tkr) {
         this.tkr = true;
         this.profile.add(a.c(-1345304403, "䣖ㅱ뮴◅금⢿鋭ᬁ"), 1L);
      }

      this.tks = this.recorded > 0;
      this.save();
   }

   public int seconds() {
      return this.recorded / 20;
   }
}
