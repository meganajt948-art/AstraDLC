package a;

import flow.dev.a;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import net.minecraft.block.MapColor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.MapIdComponent;
import net.minecraft.entity.decoration.ItemFrameEntity;
import net.minecraft.item.FilledMapItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.map.MapState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Direction.Axis;

public final class eao {
   private static final MinecraftClient eap = MinecraftClient.getInstance();
   private static final int eaq = 128;
   private static final int ear = 8;
   private static final long eas = 120000L;
   private static final long eat = 60000L;
   private static final int eau = 40;
   private static final int eav = 3;
   private final dtv eaw;
   private long eax;
   private int eay;
   private int eaz;
   private boolean eba;
   private long ebb;
   private long ebc;
   private int[] ebd;
   private int ebe;
   private int ebf;
   private int ebg;
   private int ebh;
   private boolean ebi;
   private boolean ebj;
   private long ebk;
   private boolean ebl;
   private int ebm;
   private int ebn;
   private int ebo;
   private volatile String ebp = "";
   private volatile String ebq = "";
   private String ebr;
   private long ebs;
   private elb ebt;

   eao(dtv var1) {
      this.eaw = var1;
   }

   static eso recognize(BufferedImage var0) {
      try {
         erc var1 = erp.solve(var0);
         if (!var1.code().isEmpty()) {
            return new eso(var1.code(), var1.message());
         }

         eso var4 = esz.solve(var0);
         return var4.code().isEmpty() ? new eso("", var1.message()) : var4;
      } catch (erh var3) {
         eso var2 = esz.solve(var0);
         return var2.code().isEmpty() ? new eso("", var3.getMessage()) : var2;
      }
   }

   void arm() {
      this.eax = System.currentTimeMillis() + 120000L;
      this.reset();
   }

   void onHint(String var1) {
      String var2 = var1.toLowerCase(Locale.ROOT);
      if (var2.contains(a.b("꓄\udd7f垣즪", 1306042618)) || var2.contains(a.d("ᨐ掣\ue961眔ﳔ穮쀴", -651566329, -1603733133))) {
         this.eax = Math.max(this.eax, System.currentTimeMillis() + 60000L);
      }
   }

   void onMap() {
      this.eba = true;
   }

   void reset() {
      this.ecd();
      this.ebd = null;
      this.ebe = 0;
      this.ebf = 0;
      this.ebg = 0;
      this.ebh = 0;
      this.ebi = false;
      this.ebj = false;
      this.ebb = 0L;
      this.ebc = 0L;
      this.eaz = 0;
      this.eba = true;
      this.ebn = 0;
      this.ebo = 0;
      this.ebr = null;
      this.ebp = "";
      this.ebq = "";
   }

   void tick() {
      if (++this.eay % 4 == 0) {
         ClientPlayerEntity var1 = eap.player;
         ClientWorld var2 = eap.world;
         if (var1 != null && var2 != null) {
            if (this.ebd != null || System.currentTimeMillis() <= this.eax) {
               boolean var3 = this.ebw(var1, var2) || this.eby(var1, var2);
               if (var3) {
                  this.eaz = 0;
               } else {
                  this.eaz += 4;
                  if (this.ebd != null && this.eaz >= 40) {
                     this.reset();
                     this.eaw.onCaptchaGone();
                  }
               }
            }
         }
      }
   }

   private boolean ebw(ClientPlayerEntity var1, ClientWorld var2) {
      for (List var4 : enq.findWalls(var2, var1, 16.0)) {
         if (this.ebx(var4, var2)) {
            return true;
         }
      }

      return false;
   }

   private boolean ebx(List<ItemFrameEntity> var1, ClientWorld var2) {
      Direction var3 = ((ItemFrameEntity)var1.get(0)).getHorizontalFacing();
      boolean var4 = var3.getAxis() == Axis.Z;
      boolean var5 = var3 == Direction.NORTH || var3 == Direction.EAST;
      int var6 = Integer.MAX_VALUE;
      int var7 = Integer.MIN_VALUE;
      int var8 = Integer.MAX_VALUE;
      int var9 = Integer.MIN_VALUE;
      long var10 = var3.ordinal();

      for (ItemFrameEntity var13 : var1) {
         BlockPos var14 = var13.getAttachedBlockPos();
         int var15 = var4 ? var14.getX() : var14.getZ();
         var6 = Math.min(var6, var15);
         var7 = Math.max(var7, var15);
         var8 = Math.min(var8, var14.getY());
         var9 = Math.max(var9, var14.getY());
         var10 = var10 * 31L + var13.getId();
         var10 = var10 * 31L + var14.asLong();
         var10 = var10 * 31L + var13.getRotation();
         var10 = var10 * 31L + ebz(var13.getHeldItemStack());
      }

      int var28 = var7 - var6 + 1;
      int var29 = var9 - var8 + 1;
      if (var28 > 8 || var29 > 8) {
         return false;
      }

      if (var10 == this.ebb && !this.eba && this.ebd != null) {
         return true;
      }

      if (var10 == this.ebc && !this.eba) {
         return false;
      }

      int var30 = var28 * 128;
      int var31 = var29 * 128;
      int[] var16 = new int[var30 * var31];
      int var17 = 0;

      for (ItemFrameEntity var19 : var1) {
         MapState var20 = FilledMapItem.getMapState(var19.getHeldItemStack(), var2);
         if (var20 != null && var20.colors != null && var20.colors.length == 16384) {
            var17++;
            BlockPos var21 = var19.getAttachedBlockPos();
            int var22 = var4 ? var21.getX() : var21.getZ();
            int var23 = (var5 ? var7 - var22 : var22 - var6) * 128;
            int var24 = (var9 - var21.getY()) * 128;
            eca(var20.colors, var19.getRotation() & 3, var16, var30, var23, var24);
         }
      }

      if (var17 == var1.size() && enq.seamRatio(var16, var30, var31) > 2.0) {
         this.ebc = var10;
         return false;
      } else {
         boolean var32 = var10 != this.ebb;
         this.ebb = var10;
         this.eba = false;
         this.ecb(var16, var30, var31, var17, var1.size(), var32);
         return true;
      }
   }

   private boolean eby(ClientPlayerEntity var1, ClientWorld var2) {
      ItemStack var3 = var1.getMainHandStack();
      if (!(var3.getItem() instanceof FilledMapItem)) {
         return false;
      }

      MapState var4 = FilledMapItem.getMapState(var3, var2);
      if (var4 != null && var4.colors != null && var4.colors.length == 16384) {
         long var5 = 55150044793L + ebz(var3);
         if (var5 == this.ebb && !this.eba && this.ebd != null) {
            return true;
         }

         boolean var7 = var5 != this.ebb;
         this.ebb = var5;
         this.eba = false;
         int[] var8 = new int[16384];
         eca(var4.colors, 0, var8, 128, 0, 0);
         this.ecb(var8, 128, 128, 1, 1, var7);
         return true;
      } else {
         return false;
      }
   }

   private static int ebz(ItemStack var0) {
      MapIdComponent var1 = var0.get(DataComponentTypes.MAP_ID);
      return var1 == null ? -1 : var1.id();
   }

   private static void eca(byte[] var0, int var1, int[] var2, int var3, int var4, int var5) {
      for (int var6 = 0; var6 < 128; var6++) {
         for (int var7 = 0; var7 < 128; var7++) {
            int var8 = var0[var6 * 128 + var7] & 255;
            int var9 = var8 < 4 ? 0 : MapColor.getRenderColor(var8);
            int var10;
            int var11;
            switch (var1) {
               case 1:
                  var10 = 127 - var6;
                  var11 = var7;
                  break;
               case 2:
                  var10 = 127 - var7;
                  var11 = 127 - var6;
                  break;
               case 3:
                  var10 = var6;
                  var11 = 127 - var7;
                  break;
               default:
                  var10 = var7;
                  var11 = var6;
            }

            var2[(var5 + var11) * var3 + var4 + var10] = var9;
         }
      }
   }

   private void ecb(int[] var1, int var2, int var3, int var4, int var5, boolean var6) {
      this.ebd = var1;
      this.ebe = var2;
      this.ebf = var3;
      this.ebg = var4;
      this.ebh = var5;
      this.ebl = true;
      if (var6) {
         this.ebi = true;
         this.ebk = System.currentTimeMillis();
         this.ebj = false;
         this.ebm = 0;
      }

      if (var4 == var5) {
         int var7 = Arrays.hashCode(var1);
         if (var7 != this.ebm) {
            if (this.ebm != 0) {
               this.ebi = true;
               this.ebk = System.currentTimeMillis();
               this.ebj = false;
               if (this.ebr != null && System.currentTimeMillis() - this.ebs > 1500L) {
                  this.eaw
                     .chat
                     .system(a.d("\uee98靵ᷖ莠ࠀ諓", 1879153064, 2019521320) + this.ebr + a.c(-965145357, "\u0cc9煥﮾懚\uee12棜틷嬃씮侒찯㙒벘┪꽵⦆鎶᠈蚡ú襽\uf32e緧\ue633恋\uea90"));
                  this.ebr = null;
               }
            }

            this.ebm = var7;
         }

         this.ecc(var1, var2, var3, var7);
      }

      if (!this.ebj && var4 * 2 >= var5) {
         this.ebj = true;
         this.eaw.onCaptcha();
      }
   }

   private void ecc(int[] var1, int var2, int var3, int var4) {
      if (var4 != this.ebn && egq.get().isSolvingCaptcha()) {
         this.ebn = var4;
         if (this.ebo >= 3) {
            this.ebp = "";
            this.ebq = a.c(1842486206, "ῗ昒\uecb6狉ﵲ翜연䱿툢墟\udf39┰ꮙ㉐레㺈蓊ཷ闗᎕鸂\ue423檗\uf141献鱗䁌쨏僸횮崜ꏁⶖ끽㘪벑ݒ襂\u0fe0陝");
         } else {
            this.ebp = "";
            this.ebq = a.b("誔\uf351秵\ue78a栱\ueae7僋\ud940䝭췙䩽둮㺣ꜘⴻꯈᇽ鸩ҝ芵༯畾\ufbcd", -727413054);
            BufferedImage var5 = new BufferedImage(var2, var3, 2);
            var5.setRGB(0, 0, var2, var3, var1, 0, var2);
            Thread.ofVirtual().start(() -> {
               eso var3x;
               try {
                  var3x = recognize(var5);
               } catch (Throwable var5x) {
                  var3x = new eso("", String.valueOf(var5x.getMessage()));
               }

               eso var4x = var3x;
               eap.execute(() -> {
                  if (var4 == this.ebm) {
                     if (!var4x.code().isEmpty()) {
                        this.ebo++;
                        this.ebp = var4x.code();
                        this.ebq = "";
                        this.answered(var4x.code());
                        this.eaw.onCaptchaSolved(var4x.code());
                     } else {
                        this.ebq = "";
                        this.eaw.onCaptchaUnsolved(var4x.message());
                     }
                  }
               });
            });
         }
      }
   }

   private void ecd() {
      if (this.ebr != null && System.currentTimeMillis() - this.ebs < 60000L) {
         this.eaw.chat.system(a.d("〔䦏썓嵚훺呛\uea17掙ﶾ眊\uf0ab\u0ad7葲ᧉ鎀", 545135425, 1064316736) + this.ebr);
      }

      this.ebr = null;
   }

   public void answered(String var1) {
      if (this.ebd != null && var1 != null && var1.matches(a.b("昙ᾐ镜\u0b65肭؈밞", 394094146))) {
         this.ebr = var1;
         this.ebs = System.currentTimeMillis();
      }
   }

   public String getAutoCode() {
      return this.ebp;
   }

   public String getAutoState() {
      return this.ebq;
   }

   public boolean isShown() {
      return this.ebd != null && this.ebi;
   }

   public boolean isPresent() {
      return this.ebd != null;
   }

   public void dismiss() {
      this.ebi = false;
   }

   public void show() {
      if (this.ebd != null) {
         this.ebi = true;
      }
   }

   public int getWidth() {
      return this.ebe;
   }

   public int getHeight() {
      return this.ebf;
   }

   public int getFilledTiles() {
      return this.ebg;
   }

   public int getTotalTiles() {
      return this.ebh;
   }

   public long getShownAt() {
      return this.ebk;
   }

   public elb texture() {
      int[] var1 = this.ebd;
      if (var1 == null) {
         return null;
      }

      if (this.ebt != null && (this.ebt.width != this.ebe || this.ebt.height != this.ebf)) {
         this.close();
      }

      if (this.ebt == null) {
         this.ebt = new elb(a.c(-129124801, "뙛쿨䔪\udb5f傟혥汿"), this.ebe, this.ebf);
         this.ebl = true;
      }

      if (this.ebl) {
         for (int var2 = 0; var2 < this.ebf; var2++) {
            for (int var3 = 0; var3 < this.ebe; var3++) {
               int var4 = var1[var2 * this.ebe + var3];
               this.ebt.set(var3, var2, var4 == 0 ? -15066078 : var4);
            }
         }

         this.ebt.upload();
         this.ebl = false;
      }

      return this.ebt;
   }

   void close() {
      if (this.ebt != null) {
         this.ebt.close();
      }

      this.ebt = null;
   }
}
