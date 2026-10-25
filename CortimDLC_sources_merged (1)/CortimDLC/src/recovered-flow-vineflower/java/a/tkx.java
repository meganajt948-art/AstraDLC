package a;

import com.mojang.authlib.GameProfile;
import flow.dev.a;
import java.util.Random;
import java.util.UUID;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MovementType;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public final class tkx extends OtherClientPlayerEntity {
   private static final double tky = 0.216;
   private static final double tkz = 0.28;
   private final Random tla;
   private final String tlb;
   private final double tlc;
   private final double tld;
   private final double tle;
   private String tlf;
   private int tlg;
   private double tlh;
   private double tli;
   private double tlj;
   private double tlk = 1.0;
   private int tll;
   private int tlm;
   private double tln;
   private int tlo;
   private double tlp;
   private double tlq;
   private boolean tlr;
   private int tls;
   private float tlt;
   private float tlu;
   private int tlv;

   public tkx(ClientWorld var1, String var2, long var3, String var5, double var6, double var8, double var10) {
      super(var1, new GameProfile(UUID.nameUUIDFromBytes((a.b("힙긢⓲몛ㄉ랧ඪ葜ᨖ邨\u1771\ued49", 542365683) + var2).getBytes()), var2));
      this.tla = new Random(var3);
      this.tlb = var5;
      this.tlc = var6;
      this.tld = var8;
      this.tle = var10;
      this.tlf = var5;
      this.tln = var6 + this.tla.nextDouble() * (var8 - var6);
      this.tly();
   }

   @Override
   public boolean isPushable() {
      return false;
   }

   @Override
   public void pushAwayFrom(Entity entity) {
   }

   @Override
   protected void tickCramming() {
   }

   @Override
   public void tick() {
      ClientPlayerEntity var1 = MinecraftClient.getInstance().player;
      if (var1 != null && !this.isRemoved()) {
         this.tlz(var1);
         this.tma();
      }

      super.tick();
      this.noClip = true;
      if (var1 != null) {
         this.tmb(var1);
      }
   }

   public void knock(Vec3d var1, boolean var2) {
      double var3 = this.getX() - var1.x;
      double var5 = this.getZ() - var1.z;
      double var7 = Math.max(0.001, Math.sqrt(var3 * var3 + var5 * var5));
      double var9 = var2 ? 0.55 : 0.4;
      this.tlh = this.tlh * 0.5 + var3 / var7 * var9;
      this.tlj = this.tlj * 0.5 + var5 / var7 * var9;
      if (this.isOnGround()) {
         this.tli = Math.min(0.4, this.tli * 0.5 + 0.36);
      }

      this.tlv = 8 + this.tla.nextInt(8);
      this.animateDamage((float)Math.toDegrees(Math.atan2(var5, var3)));
   }

   private void tly() {
      if (this.tlb.equals(a.d("끸짭䌯", 1254660201, -608819105))) {
         String[] var1 = new String[]{
            a.c(1224692643, "口⩣ꂠ㻘"),
            a.c(-1468450982, "㜏亙쑌娮퇾坌"),
            a.c(512138217, "鮦\ue228棣\uf68f絑"),
            a.c(-983578585, "존뇳㬭ꕛ"),
            a.c(126396001, "꘡\udfa1啢쬚"),
            a.c(277563843, "䦖　뫕Ⓑ꽧⧕"),
            a.c(-2119522390, "ꟼ\ude6a咤쫐䄇")
         };
         this.tlf = var1[this.tla.nextInt(var1.length)];
         this.tlg = 60 + this.tla.nextInt(140);
      } else {
         this.tlf = this.tlb;
         this.tlg = Integer.MAX_VALUE;
      }
   }

   private void tlz(ClientPlayerEntity var1) {
      if (--this.tlg <= 0) {
         this.tly();
      }

      if (--this.tll <= 0) {
         double var2 = this.tla.nextDouble();
         this.tlk = var2 < 0.12 ? 0.0 : (var2 < 0.56 ? -this.tlk : this.tlk);
         if (this.tlk == 0.0 && var2 >= 0.12) {
            this.tlk = this.tla.nextBoolean() ? 1.0 : -1.0;
         }

         this.tll = 5 + (int)(-Math.log(1.0 - this.tla.nextDouble()) * 14.0);
      }

      if (--this.tlo <= 0) {
         this.tln = this.tlc + this.tla.nextDouble() * (this.tld - this.tlc);
         this.tlo = 30 + this.tla.nextInt(80);
      }

      if (this.tlv > 0) {
         this.tlv--;
      }
   }

   private void tma() {
      ClientPlayerEntity var1 = MinecraftClient.getInstance().player;
      double var2 = var1.getX();
      double var4 = var1.getZ();
      double var6 = this.getX() - var2;
      double var8 = this.getZ() - var4;
      double var10 = Math.max(0.05, Math.sqrt(var6 * var6 + var8 * var8));
      double var12 = var6 / var10;
      double var14 = var8 / var10;
      double var16 = -var14;
      double var18 = var12;
      double var20 = 0.0;
      double var22 = 0.0;
      double var24 = 0.0;
      boolean var26 = false;
      switch (this.tlf) {
         case a.c(-1479931684, "ࢊ焜\ufbd2斦\uee71"):
            var22 = 0.0;
            var24 = 0.0;
            break;
         case a.c(1149394098, "峡╦꾸㇎"):
            if (!this.tlr || Math.hypot(this.tlp - this.getX(), this.tlq - this.getZ()) < 0.4) {
               double var41 = this.tla.nextDouble() * Math.PI * 2.0;
               double var44 = this.tlc + this.tla.nextDouble() * (this.tld - this.tlc);
               this.tlp = var2 + Math.cos(var41) * var44;
               this.tlq = var4 + Math.sin(var41) * var44;
               this.tlr = true;
            }

            double var42 = this.tlp - this.getX();
            double var45 = this.tlq - this.getZ();
            double var47 = Math.max(0.001, Math.sqrt(var42 * var42 + var45 * var45));
            var22 = var42 / var47;
            var24 = var45 / var47;
            var20 = 0.216;
            break;
         default:
            double var29 = MathHelper.clamp((this.tln - var10) * 0.9, -1.0, 1.0);
            var22 = var16 * this.tlk + var12 * var29;
            var24 = var18 * this.tlk + var14 * var29;
            double var31 = Math.sqrt(var22 * var22 + var24 * var24);
            if (var31 > 1.0) {
               var22 /= var31;
               var24 /= var31;
            }

            var20 = this.tlf.equals(a.b("䣸ㅸ뮻◃", -197310280)) ? 0.28 : 0.216;
            if (this.tlf.equals(a.d("餗\ue097橔\uf42c", 284568698, -1601129171)) && this.tlv > 0) {
               var22 = var12 * 0.8 + var16 * this.tlk * 0.4;
               var24 = var14 * 0.8 + var18 * this.tlk * 0.4;
            }
            double var33 = switch (this.tlf) {
               case a.c(1063187964, "\uf5b3谽۶颚ፄ") -> 0.55;
               case a.c(-519171975, "္榹\ue37a紂") -> var10 < 3.6 ? 0.2 : 0.04;
               default -> 0.03;
            };
            var26 = this.tla.nextDouble() < var33;
      }

      if (var10 > this.tld + 2.5) {
         var22 = -var12;
         var24 = -var14;
         var20 = 0.28;
      } else if (var10 < 1.2) {
         var22 = var12;
         var24 = var14;
         var20 = 0.216;
      }

      if (this.tlm > 0) {
         this.tlm--;
         var20 = 0.0;
      } else if (!this.tlf.equals(a.b("擣ᵵ鞻\u09cf舘", 375743669)) && this.tla.nextDouble() < 0.012) {
         this.tlm = 3 + this.tla.nextInt(6);
      }

      var20 *= this.tle;
      double var40 = var22 * var20;
      double var43 = var24 * var20;
      double var46 = this.isOnGround() ? 0.42 : 0.08;
      this.tlh = this.tlh + (var40 - this.tlh) * var46;
      this.tlj = this.tlj + (var43 - this.tlj) * var46;
      if (var26 && this.isOnGround()) {
         this.tli = 0.42;
      }

      this.tli = (this.tli - 0.08) * 0.98;
      Vec3d var48 = this.getEntityPos();
      this.noClip = false;
      this.move(MovementType.SELF, new Vec3d(this.tlh, this.tli, this.tlj));
      this.noClip = true;
      if (this.verticalCollision && this.tli < 0.0) {
         this.tli = 0.0;
      }

      if (this.verticalCollision && this.tli > 0.0) {
         this.tli = 0.0;
      }

      if (this.horizontalCollision) {
         Vec3d var34 = this.getEntityPos().subtract(var48);
         if (Math.abs(var34.x) < Math.abs(this.tlh) * 0.5) {
            this.tlh = 0.0;
         }

         if (Math.abs(var34.z) < Math.abs(this.tlj) * 0.5) {
            this.tlj = 0.0;
         }

         if (this.isOnGround()) {
            this.tli = 0.42;
         }

         this.tlk = -this.tlk;
         this.tlr = false;
         this.tls++;
      } else {
         this.tls = Math.max(0, this.tls - 1);
      }

      if (this.getY() < var1.getY() - 6.0 || var10 > this.tld + 10.0 || this.tls > 40) {
         this.relocate(var1);
      }
   }

   private void tmb(ClientPlayerEntity var1) {
      Vec3d var2 = var1.getEyePos();
      double var3 = var2.x - this.getX();
      double var5 = var2.z - this.getZ();
      double var7 = var2.y - this.getEyeY();
      float var9 = (float)(Math.toDegrees(Math.atan2(var5, var3)) - 90.0);
      float var10 = (float)(-Math.toDegrees(Math.atan2(var7, Math.sqrt(var3 * var3 + var5 * var5))));
      this.tlt = this.tlt + MathHelper.wrapDegrees(var9 + (float)this.tla.nextGaussian() * 4.0F - this.tlt) * 0.45F;
      this.tlu = this.tlu + (var10 + (float)this.tla.nextGaussian() * 2.0F - this.tlu) * 0.4F;
      this.setYaw(this.tlt);
      this.setPitch(MathHelper.clamp(this.tlu, -60.0F, 60.0F));
      this.setHeadYaw(this.tlt);
   }

   public void relocate(ClientPlayerEntity var1) {
      double var2 = Math.toRadians(var1.getYaw() + 90.0);

      for (int var4 = 0; var4 < 24; var4++) {
         double var5 = var2 + (this.tla.nextDouble() - 0.5) * Math.PI * (var4 < 12 ? 1.2 : 2.0);
         double var7 = this.tlc + this.tla.nextDouble() * (this.tld - this.tlc);
         double var9 = var1.getX() + Math.cos(var5) * var7;
         double var11 = var1.getZ() + Math.sin(var5) * var7;
         Double var13 = this.tmc(var1, var9, var11);
         if (var13 != null) {
            this.tmd(var9, var13, var11);
            return;
         }
      }

      this.tmd(var1.getX() + Math.cos(var2) * this.tlc, var1.getY(), var1.getZ() + Math.sin(var2) * this.tlc);
   }

   private Double tmc(ClientPlayerEntity var1, double var2, double var4) {
      double var6 = this.getWidth() * 0.5;

      for (int var8 = 2; var8 >= -4; var8--) {
         double var9 = Math.floor(var1.getY()) + var8;
         Box var11 = new Box(var2 - var6, var9, var4 - var6, var2 + var6, var9 + this.getHeight(), var4 + var6);
         Box var12 = var11.offset(0.0, -0.2, 0.0);
         if (this.getEntityWorld().isSpaceEmpty(this, var11) && !this.getEntityWorld().isSpaceEmpty(this, var12)) {
            return var9;
         }
      }

      return null;
   }

   private void tmd(double var1, double var3, double var5) {
      this.tlh = this.tli = this.tlj = 0.0;
      this.refreshPositionAndAngles(var1, var3, var5, this.getYaw(), this.getPitch());
      this.lastRenderX = var1;
      this.lastRenderY = var3;
      this.lastRenderZ = var5;
      this.tls = 0;
      this.tlr = false;
   }
}
