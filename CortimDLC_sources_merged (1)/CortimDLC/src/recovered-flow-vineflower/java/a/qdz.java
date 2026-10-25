package a;

import flow.dev.a;
import it.unimi.dsi.fastutil.doubles.DoubleArrayList;
import it.unimi.dsi.fastutil.longs.Long2DoubleOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2IntOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2LongOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongArrayList;
import it.unimi.dsi.fastutil.longs.LongIterator;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.Long2LongMap.Entry;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.util.InputUtil.Key;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.util.math.Direction.Axis;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;

public final class qdz {
   private static final double qea = 4.4;
   private static final int qeb = 20;
   private static final int qec = 30;
   private static final int qed = 50;
   private static final double qee = 0.12;
   private static final double qef = 0.35;
   private static final int qeg = 32;
   private static final int qeh = 10;
   private static final double[][] qei = new double[][]{{0.14, 0.0}, {-0.14, 0.0}, {0.0, 0.14}, {0.0, -0.14}};
   private static final double[][] qej = new double[][]{
      {0.0, 0.0}, {0.27, 0.27}, {-0.27, 0.27}, {0.27, -0.27}, {-0.27, -0.27}, {0.3, 0.0}, {-0.3, 0.0}, {0.0, 0.3}, {0.0, -0.3}
   };
   private static final Field qek = vxr.find(
      ClientPlayerEntity.class, a.c(1534863791, "⧖偬\udaae䒅켑䦤\uf3f0稊\ue453滳\ue933ፅ鶀ѫ蹵ࢋ닉㴊ꞹ⇄ꡛ툉岸"), a.c(-1377249660, "훨꽖▉믱〮뚤ಛ蕠ᬲ醆"), a.b("周", 1570591791)
   );
   private static final Field qel = vxr.find(
      ClientPlayerEntity.class,
      a.c(709615511, "\udfeeꙔⲖ늽㤩뾜\u05c8谲ቫ飋Ἃ\ue57d殸\uf253硍ﺳ䓱쬲冁\ud7fc幣\u2431ꪀ"),
      a.c(-1832242657, "㉳䯍섒彪풵刿\ue800懻ﾯ甙"),
      a.d("敎", -1690170895, 1491758328)
   );
   private static final double qem = 0.9;
   private static final int qen = 3;
   private static final int qeo = 6;
   private final Random qep = new Random();
   private final qnd qeq = new qnd();
   private final qsc qer = new qsc();
   private final qln qes = new qln();
   private final qrm qet = new qrm();
   private boolean qeu;
   private final LongOpenHashSet qev = new LongOpenHashSet();
   private final Long2LongOpenHashMap qew = new Long2LongOpenHashMap();
   private final LongOpenHashSet qex = new LongOpenHashSet();
   private final List<qcu> qey = new ArrayList<>();
   private final Long2IntOpenHashMap qez = new Long2IntOpenHashMap();
   private final Long2IntOpenHashMap qfa = new Long2IntOpenHashMap();
   private final Long2IntOpenHashMap qfb = new Long2IntOpenHashMap();
   private final LongOpenHashSet qfc = new LongOpenHashSet();
   private final List<qdo> qfd = new ArrayList<>();
   public static volatile Consumer<String> trace;
   private Predicate<BlockState> qfe = var0 -> false;
   private Predicate<ItemStack> qff = var0 -> false;
   private pzc qfg;
   private qdw qfh = qdw.IDLE;
   private int qfi;
   private qmx qfj;
   private int qfk;
   private boolean qfl = true;
   private int qfm;
   private int qfn;
   private boolean qfo;
   private int qfp;
   private int qfq;
   private BlockPos qfr;
   private Block qfs;
   private boolean qft;
   private Vec3d qfu;
   private Object qfv;
   private int qfw;
   private Vec3d qfx;
   private boolean qfy;
   private boolean qfz;
   private Vec3d qga;
   private Object qgb;
   private long qgc = Long.MIN_VALUE;
   private boolean qgd;
   private int qge;
   private BlockPos qgf;
   private BlockPos qgg;
   private Direction qgh;
   private float qgi;
   private float qgj;
   private int qgk;
   private boolean qgl;
   private Vec3d qgm;
   private int qgn;
   private int qgo;
   private Vec3d qgp;
   private int qgq;
   private qmh qgr;
   private toq qgs;
   private double qgt;
   private boolean qgu;
   private int qgv;
   private int qgw;
   private boolean qgx;
   private boolean qgy;
   private boolean qgz;
   private boolean qha;
   private boolean qhb;
   private BlockPos qhc;
   private boolean qhd;
   private boolean qhe;
   private boolean qhf;
   private boolean qhg;
   private BlockPos qhh;
   private Vec3d qhi;
   private Object qhj;
   private int qhk;
   private int qhl;
   private Runnable qhm = () -> {};
   private static final int qhn = Integer.MIN_VALUE;
   private int qho = Integer.MIN_VALUE;
   private int qhp;
   private long qhq = Long.MIN_VALUE;
   private int qhr;
   private static final List<Box> qhs = new ArrayList<>();
   private static final int qht = 4;
   private static final int qhu = 14;
   private static final double qhv = 3.6;
   private static final int[][] qhw = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
   private static final int qhx = 0;
   private static final int qhy = 1;
   private static final int qhz = 2;
   private static final int qia = 3;
   private static final int qib = 4;
   private static final int qic = 5;
   private static final int qid = 6;
   private final int[] qie = new int[7];
   private int qif = Integer.MIN_VALUE;
   private static final int qig = 4;
   private int qih;
   private int qii = -1;

   public void configure(qmh var1, boolean var2, boolean var3) {
      this.qgr = var1;
      this.qgx = var2;
      this.qgy = var3;
      this.qes.wide(var3);
      this.qeq.tune(var2 ? 3.6F : 4.6F, var1 == null ? 4.0F : (var3 ? 0.8F : 1.5F), var1 != null ? var1.cap() : 22.0, var3 ? 0.6F : 0.0F);
   }

   public void target(Predicate<BlockState> var1) {
      this.qfe = var1;
   }

   public void brain(ttb var1) {
      if (var1 == null) {
         this.qgs = null;
         this.qgu = false;
      } else if (this.qgs == null || this.qgs.model != var1) {
         this.qgs = new toq(var1);
      }

      if (this.qgs != null) {
         this.qgs.boost(this.qgt);
      }
   }

   public void boost(double var1) {
      this.qgt = var1;
      if (this.qgs != null) {
         this.qgs.boost(var1);
      }
   }

   public boolean hasBrain() {
      return this.qgs != null;
   }

   public toq brain() {
      return this.qgs;
   }

   private double qil() {
      return this.qgr != null ? this.qgr.cap() : (this.qgs != null ? this.qgs.turnRate() : 22.0);
   }

   private static double qim(ClientPlayerEntity var0, Vec3d var1) {
      Vec3d var2 = var1.method_1020(var0.method_33571());
      double var3 = tbp.yawTo(var2.field_1352, var2.field_1350);
      double var5 = tbp.pitchTo(var2.field_1351, Math.sqrt(var2.field_1352 * var2.field_1352 + var2.field_1350 * var2.field_1350));
      return Math.hypot(MathHelper.method_15338(var3 - var0.method_36454()), var5 - var0.method_36455());
   }

   public void predict(boolean var1, MinecraftClient var2) {
      if (this.qeu && !var1 && var2 != null) {
         this.qet.restore(var2.field_1687);
      }

      this.qeu = var1;
   }

   public void echo(Packet<?> var1) {
      this.qet.echo(var1);
   }

   public String predicted() {
      return this.qet.describe();
   }

   public void junk(Predicate<ItemStack> var1) {
      this.qff = var1;
   }

   public void onSit(Runnable var1) {
      this.qhm = var1;
   }

   public void park(pzc var1, BlockPos var2, boolean var3) {
      this.start(var1);
      this.qhc = var2.method_10062();
      this.qhg = var3;
   }

   public boolean parking() {
      return this.qhc != null;
   }

   public boolean parked() {
      return this.qhc != null && this.qhd;
   }

   public boolean parkLost() {
      return this.qhc != null && this.qhe;
   }

   public void guard(pzc var1) {
      this.start(var1);
      this.qhf = true;
   }

   public boolean guarding() {
      return this.qhf && this.qfh == qdw.WORKING;
   }

   public void start(pzc var1) {
      this.qhf = false;
      this.qhc = null;
      this.qhd = false;
      this.qhe = false;
      this.qhh = null;
      this.qhi = null;
      this.qhk = 0;
      this.qhl = 0;
      this.qho = Integer.MIN_VALUE;
      this.qhq = Long.MIN_VALUE;
      this.qhr = 0;
      this.qif = Integer.MIN_VALUE;
      this.qii = -1;
      this.qih = 0;
      if (this.qfg == null || var1 == null || !this.qfg.covers(var1) || !var1.covers(this.qfg)) {
         this.qev.clear();
      }

      this.qfa.clear();
      this.qez.clear();
      this.qer.clear();
      this.qfg = var1;
      this.qfh = var1 == null ? qdw.IDLE : qdw.WORKING;
      this.qew.clear();
      this.qfb.clear();
      this.qey.clear();
      this.qfd.clear();
      this.qfc.clear();
      this.qfj = null;
      this.qfl = true;
      this.qfn = 0;
      this.qfo = false;
      this.qfr = null;
      this.qfx = null;
      this.qgo = 0;
   }

   public void avoid(Vec3d var1, int var2) {
      this.qgp = var1;
      this.qgq = this.qfi + var2;
      this.qfl = true;
   }

   public pzc area() {
      return this.qfg;
   }

   public qdw status() {
      return this.qfh;
   }

   public int mined() {
      return this.qfp;
   }

   public int reverts() {
      return this.qfq;
   }

   public boolean breaking() {
      return this.qfr != null;
   }

   public String dozer() {
      return this.qes.describe();
   }

   public BlockPos focus() {
      if (this.qfh != qdw.WORKING || this.qhc != null || this.qhf) {
         return null;
      } else if (this.qfr != null && this.qft) {
         return this.qfr;
      } else {
         return this.qfj == null ? null : this.qfj.target();
      }
   }

   public String action() {
      if (this.qfr != null) {
         return a.b("쳛땺㾾ꇋ⨖곬", 262851775) + this.qfr.method_23854() + a.c(1916832265, "訬\uf3dc礇\ue772注") + qin(this.qfu);
      } else {
         return this.qfx != null
            ? a.c(-550039396, "ხ楉\ue397緡\uf67d") + qin(this.qfx) + a.c(327677930, "\uf7cc踱ӡ骐ᅃ鞹") + qin(this.qga)
            : a.c(-1713369827, "൷瓇︕息");
      }
   }

   private static String qin(Vec3d var0) {
      return var0 == null
         ? a.d("쫞", -819785257, 1821563685)
         : String.format(Locale.ROOT, a.c(681747764, "ꔟ\udca5噪졏䏒앪缲\uf6df棔\ue22f旵龏ᅄ袡"), var0.field_1352, var0.field_1351, var0.field_1350);
   }

   public void resetCounters() {
      this.qfp = 0;
      this.qfq = 0;
      Arrays.fill(this.qie, 0);
   }

   public void stop(MinecraftClient var1) {
      this.qfh = qdw.IDLE;
      this.qer.clear();
      this.qfg = null;
      this.qfj = null;
      this.qfr = null;
      this.qfx = null;
      this.qfc.clear();
      if (var1 != null) {
         this.qet.restore(var1.field_1687);
      }

      this.releaseKeys(var1);
   }

   public void endTick(MinecraftClient var1, ClientPlayerEntity var2, tel var3) {
      this.qfi++;
      this.qgu = false;
      ClientWorld var4 = var1.field_1687;
      if (var4 != null) {
         this.qet.tick(var4, this.qfi);
      }

      if (this.qfg != null && var4 != null && this.qfh != qdw.IDLE) {
         qkz(var4, var2);
         this.qlh(var4);
         this.qjc(var4, var2);
         this.qfd.removeIf(var1x -> this.qfi - var1x.tick() > this.qes.lag() + 6);
         if (this.qgs != null) {
            this.qgs.tick(var4, var2, this.qfg);
         }

         if (this.qfg.distanceTo(var2.method_73189()) > 40.0) {
            this.qfh = qdw.FAR;
            this.qfr = null;
            this.qfx = null;
            this.qiq(var1, var2, var3, null, null);
         } else if (var1.field_1755 == null && var2.method_5805()) {
            this.qlg(var2);
            if (this.qfr != null && this.qhc == null && !this.qhf) {
               this.qjf(6);
            }

            if (this.qfr != null && !this.qiy(var4, var2)) {
               this.qfr = null;
               this.qfl = this.qfl || this.qgr == null;
            }

            this.qes.tick(this.qfi, var2x -> !this.qet.isGhost(var2x) && var4.method_8320(BlockPos.method_10092(var2x)).method_26215());
            BlockPos var5 = trapped(var4, var2);
            if (var5 != null && this.qfg.maxX >= this.qfg.minX && !this.qfg.contains(var5)) {
               var5 = null;
            }

            if (var5 != null && !var5.equals(this.qfr)) {
               this.qlj(a.b("ᥠ惗\uea17瑷ﾠ礄썖䫣퓵幃\ud9de", -2055792353) + var5.method_23854());
               this.qku(var5, var4.method_8320(var5).method_26204(), false, qkw(var2, var5));
               PlayerInventory var6 = var2.method_31548();
               if (!var2.method_6047().method_31573(ItemTags.field_42614)) {
                  for (int var7 = 0; var7 < 9; var7++) {
                     if (var6.method_5438(var7).method_31573(ItemTags.field_42614)) {
                        var6.method_61496(var7);
                        break;
                     }
                  }
               }
            }

            if (this.qfr == null) {
               this.qjd(var4, var2);
            }

            if (this.qhd && this.qhg && this.qfr == null && this.qfx == null && !var2.method_5765()) {
               this.qiu(var4, var2);
               Vec3d var8 = var2.method_33571();
               if (this.qhi != null && Math.hypot(this.qhi.field_1352 - var8.field_1352, this.qhi.field_1350 - var8.field_1350) > 1.2) {
                  this.qiq(var1, var2, var3, this.qhj, new Vec3d(this.qhi.field_1352, var8.field_1351 - 0.35, this.qhi.field_1350));
               } else {
                  this.qiq(var1, var2, var3, null, null);
               }
            } else {
               if (this.qfr != null) {
                  if (!this.qgz) {
                     this.qfx = null;
                  }

                  this.qiq(var1, var2, var3, this.qfv, this.qfu);
                  if (this.qgr == null) {
                     this.qir(var1, var2, var3);
                  }
               } else if (this.qga != null) {
                  this.qiq(var1, var2, var3, this.qgb, this.qga);
               } else {
                  this.qiq(var1, var2, var3, null, null);
               }

               this.qio(var4, var2);
            }
         } else {
            this.qfr = null;
            this.qfx = null;
            this.qiq(var1, var2, var3, null, null);
         }
      } else {
         this.qiq(var1, var2, var3, null, null);
      }
   }

   private void qio(World var1, ClientPlayerEntity var2) {
      this.qgu = false;
      if (this.qgs != null) {
         boolean var3 = this.qgs.hasLegs()
            && this.qgr == null
            && this.qhc == null
            && !this.qhf
            && this.qfg.maxX >= this.qfg.minX
            && this.qho == Integer.MIN_VALUE
            && this.qfx == null
            && this.qfi >= this.qgw
            && !var2.method_5765();
         double var4 = var2.method_23317();
         double var6 = var2.method_23321();
         if (var3 && (var4 < this.qfg.minX - 0.5 || var4 > this.qfg.maxX + 1.5 || var6 < this.qfg.minZ - 0.5 || var6 > this.qfg.maxZ + 1.5)) {
            var3 = false;
         }

         if (!var3) {
            this.qgs.stopLegs();
            this.qgv = 0;
         } else {
            int var8 = this.qgs.move();
            double var9 = Math.hypot(var2.method_23317() - var2.field_6014, var2.method_23321() - var2.field_5969);
            if (var8 != 0 && var9 < 0.02) {
               if (++this.qgv >= 20) {
                  this.qgv = 0;
                  this.qgw = this.qfi + 30;
                  this.qgs.stopLegs();
                  this.qlj(a.d("㷄䑼캭僈\udb4c嶮\ue7fa渊\uf043竺ﵢݒ覐ၵ", 1504850795, -1538978099) + var2.method_24515().method_23854());
                  return;
               }
            } else {
               this.qgv = 0;
            }

            this.qgs.planLegs(var1, var2, this.qfr);
            this.qgu = true;
         }
      }
   }

   private static boolean qip(World var0, ClientPlayerEntity var1, int var2) {
      double var3 = Math.toRadians(var1.method_36454());
      double var5 = trj.FWD[var2] * -Math.sin(var3) + trj.LEFT[var2] * Math.cos(var3);
      double var7 = trj.FWD[var2] * Math.cos(var3) + trj.LEFT[var2] * Math.sin(var3);
      double var9 = Math.hypot(var5, var7);
      if (var9 < 1.0E-6) {
         return false;
      } else {
         int var11 = MathHelper.method_15357(var1.method_23317() + var5 / var9 * 0.9);
         int var12 = MathHelper.method_15357(var1.method_23321() + var7 / var9 * 0.9);
         int var13 = standing(var0, var1).method_10264();

         for (int var14 = var13 - 1; var14 >= var13 - 4; var14--) {
            if (!qjs(var0, new BlockPos(var11, var14, var12))) {
               return false;
            }
         }

         return true;
      }
   }

   private void qiq(MinecraftClient var1, ClientPlayerEntity var2, tel var3, Object var4, Vec3d var5) {
      if (this.qgr != null) {
         var3.assistAt(var1, var2, null, null, 1);
         this.qgr.aim(var1, var2, var4, var5);
      } else if (this.qgs != null && var4 != null && var4 == this.qfv && this.qfr != null) {
         var3.assistBlock(var1, var2, var4, new Box(this.qfr), var5, -1);
      } else {
         var3.assistAt(var1, var2, var4, var5, this.qgs != null ? -1 : 1);
      }
   }

   private void qir(MinecraftClient var1, ClientPlayerEntity var2, tel var3) {
      if (this.qgk >= 3 && this.qfi - this.qfw >= 4) {
         Vec3d var4 = this.qfu.method_1020(var2.method_33571());
         double var5 = tbp.yawTo(var4.field_1352, var4.field_1350);
         double var7 = tbp.pitchTo(var4.field_1351, Math.sqrt(var4.field_1352 * var4.field_1352 + var4.field_1350 * var4.field_1350));
         double var9 = MathHelper.method_15338(var5 - var2.method_36454());
         double var11 = var7 - var2.method_36455();
         double var13 = Math.hypot(var9, var11);
         if (!(var13 > 9.0) && !(var13 < 0.05)) {
            double var15 = Math.min(0.55 + this.qep.nextDouble() * 0.3, Math.min(3.5, var3.budgetLeft()) / var13);
            if (!(var15 <= 0.0)) {
               double var17 = tcz.unit(var1);
               if (!(var17 <= 0.0)) {
                  long var19 = Math.round(var9 * var15 / var17);
                  long var21 = Math.round(var11 * var15 / var17);
                  if (var19 == 0L && var21 == 0L) {
                     if (Math.abs(var9) >= Math.abs(var11)) {
                        var19 = (long)Math.signum(var9);
                     } else {
                        var21 = (long)Math.signum(var11);
                     }
                  }

                  double var23 = var17 / 0.15;
                  var2.method_5872(var19 * var23, var21 * var23);
                  var3.spent(Math.hypot(var19 * var17, var21 * var17));
               }
            }
         }
      }
   }

   public void startTick(MinecraftClient var1, ClientPlayerEntity var2) {
      if (this.qfh == qdw.WORKING && var1.field_1755 == null && var2 != null && var2.method_5805()) {
         GameOptions var3 = var1.field_1690;
         if (var2.method_5765() && this.qhc == null) {
            var3.field_1894.method_23481(false);
            var3.field_1881.method_23481(false);
            var3.field_1913.method_23481(false);
            var3.field_1849.method_23481(false);
            var3.field_1903.method_23481(false);
            this.qix(var1, false);
            this.qis(var1, true);
            this.qgl = true;
            if (this.qgd) {
               var3.field_1886.method_23481(false);
               this.qgd = false;
            }
         } else {
            if (this.qhb) {
               this.qis(var1, false);
            }

            if (this.qhd && this.qhg && !var2.method_5765()) {
               this.qit(var1, var2);
            } else {
               boolean var4 = false;
               boolean var5 = false;
               boolean var6 = false;
               boolean var7 = false;
               boolean var8 = false;
               boolean var9 = false;
               boolean var10 = false;
               if ((this.qfr == null || this.qgz) && this.qfx != null) {
                  Vec3d var26 = var2.method_73189();
                  double var12 = this.qfx.field_1352 - var26.field_1352;
                  double var14 = this.qfx.field_1350 - var26.field_1350;
                  double var16 = Math.sqrt(var12 * var12 + var14 * var14);
                  Vec3d var18 = var2.method_18798();
                  double var19 = Math.sqrt(var18.field_1352 * var18.field_1352 + var18.field_1350 * var18.field_1350);
                  boolean var21 = this.qfz && var2.method_24828() && var16 < var19 * 1.3 + 0.05;
                  if (var16 > 0.12 && !var21) {
                     double var22 = tbp.yawTo(var12, var14);
                     double var24 = MathHelper.method_15338(var22 - var2.method_36454());
                     var4 = Math.abs(var24) < 67.5;
                     var5 = Math.abs(var24) > 112.5;
                     var7 = var24 > 22.5 && var24 < 157.5;
                     var6 = var24 < -22.5 && var24 > -157.5;
                  }

                  var9 = this.qfz && var16 < 1.6;
                  var8 = this.qfy && var2.method_24828() && var16 < 1.25
                     || this.qgn >= 10 && this.qgn % 10 == 0 && var2.method_24828() && (var4 || var5 || var6 || var7);
               } else if (this.qgu && this.qgs != null && var1.field_1687 != null) {
                  int var11 = this.qgs.move();
                  var4 = trj.FWD[var11] > 0;
                  var5 = trj.FWD[var11] < 0;
                  var6 = trj.LEFT[var11] > 0;
                  var7 = trj.LEFT[var11] < 0;
                  if ((var4 || var5 || var6 || var7) && qip(var1.field_1687, var2, var11)) {
                     var7 = false;
                     var6 = false;
                     var5 = false;
                     var4 = false;
                  }

                  var8 = this.qgs.jump() && var2.method_24828();
                  var10 = true;
               }

               var3.field_1894.method_23481(var4);
               var3.field_1881.method_23481(var5);
               var3.field_1913.method_23481(var6);
               var3.field_1849.method_23481(var7);
               var3.field_1903.method_23481(var8);
               this.qgl = var4 || var5 || var6 || var7 || var8;
               this.qix(var1, var10 ? this.qgs.sprint() && var4 && !var5 : this.qgx && var4 && !var5 && !var9);
               KeyBinding var27 = var3.field_1886;
               boolean var28 = false;
               BlockHitResult var13 = null;
               if (this.qfr != null) {
                  var1.field_1773.method_3190(1.0F);
                  HitResult var30 = var1.field_1765;
                  if (var30 instanceof BlockHitResult var15 && var30.method_17783() == Type.field_1332 && var15.method_17777().equals(this.qfr)) {
                     var28 = true;
                     var13 = var15;
                  }
               }

               if (var28 && this.qhr > 0) {
                  this.qhr--;
                  var28 = false;
                  this.qgk = 0;
                  if (this.qgd) {
                     var27.method_23481(false);
                     this.qgd = false;
                  }
               } else {
                  this.qgk = this.qfr != null && !var28 ? this.qgk + 1 : 0;
                  if (var28 && this.qgd && this.qfr.equals(this.qgf) && !var1.field_1761.method_2923()) {
                     if (++this.qge >= 2) {
                        this.qge = 0;
                        var28 = false;
                        this.qgf = null;
                     }
                  } else {
                     this.qge = 0;
                  }

                  if (var28) {
                     if (!this.qfr.equals(this.qgf)) {
                        Key var31 = KeyBindingHelper.getBoundKeyOf(var27);
                        if (!var31.equals(InputUtil.field_16237)) {
                           KeyBinding.method_1420(var31);
                        }

                        this.qgf = this.qfr.method_10062();
                        this.qgg = this.qgf;
                        this.qgh = var13.method_17780();
                        this.qgi = vxr.getFloat(qek, var2, var2.method_36454());
                        this.qgj = vxr.getFloat(qel, var2, var2.method_36455());
                     }

                     var27.method_23481(true);
                     this.qgd = true;
                  } else if (this.qgd) {
                     var27.method_23481(false);
                     this.qgd = false;
                  }
               }
            }
         }
      } else {
         this.releaseKeys(var1);
      }
   }

   private void qis(MinecraftClient var1, boolean var2) {
      KeyBinding var3 = var1.field_1690.field_1832;
      if ((Boolean)var1.field_1690.method_42449().method_41753()) {
         if (var2 != var3.method_1434()) {
            var3.method_23481(true);
         }
      } else {
         var3.method_23481(var2);
      }

      this.qhb = var2;
   }

   private void qit(MinecraftClient var1, ClientPlayerEntity var2) {
      GameOptions var3 = var1.field_1690;
      this.qix(var1, false);
      if (this.qgd) {
         var3.field_1886.method_23481(false);
         this.qgd = false;
      }

      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      boolean var8 = false;
      boolean var9 = false;
      if (this.qhi != null && this.qhk < 3) {
         double var10 = this.qhi.field_1352 - var2.method_23317();
         double var12 = this.qhi.field_1350 - var2.method_23321();
         double var14 = Math.sqrt(var10 * var10 + var12 * var12);
         Vec3d var16 = var2.method_18798();
         double var17 = Math.sqrt(var16.field_1352 * var16.field_1352 + var16.field_1350 * var16.field_1350);
         if (var14 > 0.2) {
            double var19 = MathHelper.method_15338(tbp.yawTo(var10, var12) - var2.method_36454());
            boolean var21 = var2.method_24828() && var14 < var17 * 1.5 + 0.04;
            if (!var21) {
               var4 = Math.abs(var19) < 67.5;
               var5 = Math.abs(var19) > 112.5;
               var7 = var19 > 22.5 && var19 < 157.5;
               var6 = var19 < -22.5 && var19 > -157.5;
            }

            var9 = var14 < 0.9;
            var8 = var2.method_24828() && var2.field_5976 && this.qhi.field_1351 > var2.method_23318() + 0.6;
            this.qhl = Math.max(this.qhl, 6);
         } else if (var2.method_24828()
            && var17 < 0.02
            && Math.abs(var2.method_23317() - var2.field_6014) + Math.abs(var2.method_23321() - var2.field_5969) < 0.003) {
            if (this.qhl > 0) {
               this.qhl--;
            } else {
               this.qhm.run();
               this.qhk++;
               this.qhl = 40;
               this.qlj(a.b("ﾔ虹ರ鋜ᥟ龯◩걌", 1763049395) + var2.method_24515().method_23854() + a.b("༮盋ﰞ扤\ue9ea", 313003787) + this.qhk);
            }
         }
      }

      var3.field_1894.method_23481(var4);
      var3.field_1881.method_23481(var5);
      var3.field_1913.method_23481(var6);
      var3.field_1849.method_23481(var7);
      var3.field_1903.method_23481(var8);
      this.qgl = var4 || var5 || var6 || var7 || var8;
      this.qis(var1, var9);
   }

   private void qiu(World var1, ClientPlayerEntity var2) {
      if (!var2.method_5765() && this.qhc != null) {
         if (this.qhi == null || this.qhh != null && !qiw(var1.method_8320(this.qhh))) {
            this.qhh = null;
            if (qiw(var1.method_8320(this.qhc)) && qiv(var1, this.qhc)) {
               this.qhh = this.qhc;
            } else if (qiw(var1.method_8320(this.qhc.method_10074())) && qiv(var1, this.qhc.method_10074())) {
               this.qhh = this.qhc.method_10074();
            } else {
               Vec3d var3 = Vec3d.method_24953(this.qhc);
               double var4 = Double.MAX_VALUE;

               for (int var6 = -3; var6 <= 3; var6++) {
                  for (int var7 = -2; var7 <= 2; var7++) {
                     for (int var8 = -3; var8 <= 3; var8++) {
                        BlockPos var9 = this.qhc.method_10069(var6, var7, var8);
                        BlockState var10 = var1.method_8320(var9);
                        if (qiw(var10) && qiv(var1, var9)) {
                           double var11 = Vec3d.method_24953(var9).method_1022(var3) + (var10.method_26204() instanceof StairsBlock ? 0.0 : 1.5);
                           if (var11 < var4) {
                              var4 = var11;
                              this.qhh = var9.method_10062();
                           }
                        }
                     }
                  }
               }
            }

            if (this.qhh != null) {
               VoxelShape var13 = var1.method_8320(this.qhh).method_26220(var1, this.qhh);
               double var14 = var13.method_1110() ? 0.0 : var13.method_1105(Axis.field_11052);
               this.qhi = new Vec3d(this.qhh.method_10263() + 0.5, this.qhh.method_10264() + var14, this.qhh.method_10260() + 0.5);
            } else {
               this.qhi = new Vec3d(this.qhc.method_10263() + 0.5, this.qhc.method_10264(), this.qhc.method_10260() + 0.5);
            }

            this.qhj = new Object();
            this.qlj(
               a.d("╲峕혂䡦쏥", -1718510172, 2050734240)
                  + (this.qhh == null ? a.d("䕮㳜또⡺ꏹ", 1785730449, 419385481) + this.qhc.method_23854() : this.qhh.method_23854())
            );
         }
      }
   }

   private static boolean qiv(World var0, BlockPos var1) {
      return var0.method_8320(var1.method_10084()).method_26220(var0, var1.method_10084()).method_1110()
         && var0.method_8320(var1.method_10086(2)).method_26220(var0, var1.method_10086(2)).method_1110();
   }

   private static boolean qiw(BlockState var0) {
      return var0.method_26204() instanceof StairsBlock || var0.method_26204() instanceof SlabBlock;
   }

   private void qix(MinecraftClient var1, boolean var2) {
      KeyBinding var3 = var1.field_1690.field_1867;
      if ((Boolean)var1.field_1690.method_42450().method_41753()) {
         if (var2 != var3.method_1434()) {
            var3.method_23481(true);
         }
      } else {
         var3.method_23481(var2);
      }

      this.qha = var2;
   }

   public void releaseKeys(MinecraftClient var1) {
      if (var1 != null && var1.field_1690 != null && var1.method_22683() != null) {
         GameOptions var2 = var1.field_1690;
         if (this.qhb) {
            if ((Boolean)var2.method_42449().method_41753()) {
               if (var2.field_1832.method_1434()) {
                  var2.field_1832.method_23481(true);
               }
            } else {
               var2.field_1832.method_23481(vzz.isPhysicallyDown(var1, var2.field_1832));
            }

            this.qhb = false;
         }

         if (this.qha) {
            if ((Boolean)var2.method_42450().method_41753()) {
               if (var2.field_1867.method_1434()) {
                  var2.field_1867.method_23481(true);
               }
            } else {
               var2.field_1867.method_23481(vzz.isPhysicallyDown(var1, var2.field_1867));
            }

            this.qha = false;
         }

         if (this.qgl) {
            for (KeyBinding var6 : new KeyBinding[]{var2.field_1894, var2.field_1881, var2.field_1913, var2.field_1849, var2.field_1903}) {
               var6.method_23481(vzz.isPhysicallyDown(var1, var6));
            }

            this.qgl = false;
         }

         if (this.qgd) {
            var2.field_1886.method_23481(vzz.isPhysicallyDown(var1, var2.field_1886));
            this.qgd = false;
         }

         this.qgf = null;
      }
   }

   private boolean qiy(World var1, ClientPlayerEntity var2) {
      BlockState var3 = var1.method_8320(this.qfr);
      if (!var3.method_26215() && var3.method_26204() == this.qfs && qld(var1, this.qfr)) {
         if (this.qfi - this.qfw <= 200 && this.qgk <= (this.qgr != null ? 12 : (this.qgs != null ? 14 : 80))) {
            if (this.qgr != null ? this.qgk == 4 || this.qgk == 8 : (this.qgs != null ? this.qgk == 5 || this.qgk == 10 : this.qgk == 30 || this.qgk == 55)) {
               Vec3d var4 = this.qkx(var1, var2, this.qfr);
               if (var4 == null) {
                  return false;
               }

               this.qfu = var4;
               this.qfv = new Object();
            }

            if ((this.qfi - this.qfw) % 5 == 0 || this.qgr != null && this.qgk > 0) {
               Vec3d var6 = var2.method_33571();
               if (this.qfu.method_1022(var6) > 4.4 || !qky(var1, var2, var6, this.qfr, this.qfu)) {
                  Vec3d var5 = this.qkx(var1, var2, this.qfr);
                  if (var5 == null) {
                     return false;
                  }

                  this.qfu = var5;
               }
            }

            return true;
         } else {
            this.qlj(
               (this.qfi - this.qfw > 200 ? a.d("쑉뷨㜬\ua959⊄ꑾṹ鞕ৎ荷Үﻅ瀓\ue9f6", 419097087, 1869688282) : a.c(2012211012, "\ue72e麗ᑀ詼ǭ蝛㴀듴⪢ꀒ➅"))
                  + this.qfr.method_23854()
            );
            this.qlf(this.qfr, this.qgr != null ? 100 : (this.qgs != null ? 200 : 600));
            if (this.qfj != null && this.qgr == null && this.qgs == null) {
               this.qlf(this.qfj.target(), 600);
            }

            return false;
         }
      } else {
         if (var3.method_26215()) {
            this.qiz(var1, var2);
         }

         return false;
      }
   }

   private void qiz(World var1, ClientPlayerEntity var2) {
      long var3 = this.qfr.method_10063();
      this.qey.add(new qcu(var3, this.qfs, this.qfi));
      if (this.qgy && this.qgh != null && this.qfr.equals(this.qgg)) {
         this.qgg = null;
         int var16 = this.qgh.method_10166().ordinal();
         double[] var6 = qln.lookAxes(this.qgi, this.qgj);
         LongOpenHashSet var7 = new LongOpenHashSet();
         int var8 = this.qes.lag() + 3;

         for (int var9 = -1; var9 <= 1; var9++) {
            for (int var10 = -1; var10 <= 1; var10++) {
               for (int var11 = -1; var11 <= 1; var11++) {
                  if (var9 != 0 || var10 != 0 || var11 != 0) {
                     int[] var12 = new int[]{var9, var10, var11};
                     boolean var13 = var12[var16] == 0;

                     for (int var14 = 0; var14 < 3 && !var13; var14++) {
                        var13 = var6[var14] > 0.0 && var12[var14] == 0;
                     }

                     long var20 = BlockPos.method_10096(var3, var9, var10, var11);
                     if (var13 && this.qfg.contains(BlockPos.method_10061(var20), BlockPos.method_10071(var20), BlockPos.method_10083(var20))) {
                        var7.add(var20);
                        if (this.qes.expect(var20, var3, var16, var6) >= 0.5) {
                           this.qfb.put(var20, this.qfi + var8);
                        }
                     }
                  }
               }
            }
         }

         var7.add(var3);
         this.qes.exclude(var7);
         if (!this.qes.probing()) {
            LongOpenHashSet var17 = new LongOpenHashSet();

            for (qdo var19 : this.qfd) {
               var17.addAll(var19.blocks());
            }

            this.qes.open(var3, this.qfi, var16, var6, var2x -> this.qjb(var1, var2x), var17);
         }

         this.qfd.add(new qdo(this.qfi, var7));
         this.qja(var1, var2, var3, var16, var6, var7);
      } else {
         LongOpenHashSet var5 = new LongOpenHashSet();
         var5.add(var3);
         this.qes.exclude(var5);
      }
   }

   private void qja(World var1, ClientPlayerEntity var2, long var3, int var5, double[] var6, LongOpenHashSet var7) {
      if (this.qeu && this.qes.votes() >= 3 && var2 != null) {
         LongOpenHashSet var8 = qjp(var1, var2, standing(var1, var2).method_10264());
         Box var9 = var2.method_5829().method_1014(0.05);
         int var10 = this.qfi + this.qes.lag() * 2 + 6;
         LongIterator var11 = var7.iterator();

         while (var11.hasNext()) {
            long var12 = var11.nextLong();
            if (var12 != var3 && !var8.contains(var12) && this.qjb(var1, var12) && !(this.qes.expect(var12, var3, var5, var6) < 0.9)) {
               BlockPos var14 = BlockPos.method_10092(var12);
               if (!new Box(var14).method_994(var9)) {
                  this.qet.ghost(var1, var14, var10);
               }
            }
         }
      }
   }

   private boolean qjb(World var1, long var2) {
      BlockPos var4 = BlockPos.method_10092(var2);
      if (this.qfg != null && this.qfg.contains(var4) && !this.qev.contains(var2)) {
         BlockState var5 = var1.method_8320(var4);
         return !var5.method_26215() && var5.method_26227().method_15769() && var5.method_26214(var1, var4) >= 0.0F;
      } else {
         return false;
      }
   }

   private void qjc(World var1, ClientPlayerEntity var2) {
      if (!this.qfc.isEmpty()) {
         Vec3d var3 = var2.method_33571();
         LongIterator var4 = this.qfc.iterator();

         while (var4.hasNext()) {
            long var5 = var4.nextLong();
            BlockPos var7 = BlockPos.method_10092(var5);
            BlockState var8 = var1.method_8320(var7);
            if (var8.method_26215()) {
               if (!this.qet.isGhost(var5)) {
                  this.qfp++;
                  var4.remove();
               }
            } else if (!this.qfe.test(var8) || Vec3d.method_24953(var7).method_1025(var3) > 81.0) {
               var4.remove();
            }
         }
      }
   }

   private void qjd(World var1, ClientPlayerEntity var2) {
      if (this.qhf) {
         this.qfx = null;
         this.qga = null;
      } else if (this.qhc != null && this.qhd && standing(var1, var2).method_10262(this.qhc) <= 25.0) {
         this.qfx = null;
         this.qga = null;
      } else if (this.qhc == null && (this.qgr != null || this.qgs != null) && this.qfg.maxX >= this.qfg.minX) {
         this.qje(var1, var2);
      } else if (this.qhc == null && this.qgr != null && this.qke(var1, var2)) {
         this.qfn = 0;
      } else if (var2.method_24828() || var2.method_5799() || var2.method_6101()) {
         BlockPos var3 = standing(var1, var2);
         if (this.qfj != null && !this.qfl && this.qfi < this.qfm) {
            int var4 = this.qkm(var3);
            if (var4 < 0) {
               this.qlj(a.d("탍ꥵ⎦붑㘖낶૰茝ᴊ韺ြ\uea19", -142309247, 481187887) + var3.method_23854());
               this.qfl = true;
            } else {
               this.qfk = var4;
            }
         }

         if (this.qhc == null && this.qfj != null && !this.qfl && !this.qkr(var1, this.qfj.target())) {
            this.qlj(a.d("뜟캻䑻\uda1f凊흪浭\ue4db窌\uf03c矤跐", 1816040736, 167584327) + this.qfj.target().method_23854());
            this.qfl = true;
         }

         if (this.qfj == null || this.qfl || this.qfi >= this.qfm) {
            this.qkq(var1, var2);
         }

         if (this.qhc != null) {
            if (this.qfj == null) {
               this.qfx = null;
               this.qga = null;
               if (var3.method_10262(this.qhc) <= 25.0) {
                  this.qhd = true;
               } else if (!this.qhd) {
                  this.qhe = true;
               }
            } else if (this.qfk >= this.qkl() - 1) {
               if (!this.qhd) {
                  this.qlj(a.d("迆\uf666粦\ue2ce椗\uefa7喰\udc00䉊좯", 1472536667, -1142247449) + var3.method_23854());
               }

               this.qhd = true;
               this.qfx = null;
               this.qga = null;
            } else {
               this.qhd = false;
               this.qjw(var1, var2, false);
            }
         } else if (this.qfj == null) {
            this.qfx = null;
            this.qga = null;
            if (!this.qfo && ++this.qfn > 30) {
               this.qfh = qdw.DONE;
            }
         } else {
            this.qfn = 0;
            BlockPos var9 = this.qfj.target();
            if (this.qfb.getOrDefault(var9.method_10063(), 0) > this.qfi) {
               this.qfx = null;
            } else {
               Vec3d var5 = var2.method_33571();
               boolean var6 = this.qfk >= this.qkl() - 1;
               if (var6 || Vec3d.method_24953(var9).method_1022(var5) <= 4.2) {
                  Vec3d var7 = this.qkx(var1, var2, var9);
                  if (var7 != null) {
                     this.qku(var9, var1.method_8320(var9).method_26204(), true, var7);
                     return;
                  }

                  if (var6) {
                     BlockPos var8 = qla(var1, var2, var5, var9);
                     if (var8 != null && this.qlc(var1, var8)) {
                        this.qkt(var1, var2, var8, false);
                        if (this.qfr != null) {
                           return;
                        }
                     }

                     this.qlf(var9, 400);
                     this.qfl = true;
                     this.qfx = null;
                     return;
                  }
               }

               this.qjw(var1, var2, true);
            }
         }
      }
   }

   private void qje(World var1, ClientPlayerEntity var2) {
      boolean var3 = var2.method_24828() || var2.method_5799() || var2.method_6101();
      if (!var3) {
         this.qfx = null;
         this.qga = null;
         if (this.qho != Integer.MIN_VALUE) {
            int var8 = this.qjj(var1, var2);
            if (var8 != Integer.MIN_VALUE && var8 + 1 > this.qho) {
               this.qjk(var1, var2, this.qji(var1, var2, var8));
            }
         }

         this.qjf(4);
      } else {
         BlockPos var4 = standing(var1, var2);
         int var5 = var4.method_10264();
         if (this.qho != Integer.MIN_VALUE) {
            if (var5 > this.qho && this.qjk(var1, var2, this.qji(var1, var2, var5 - 1))) {
               this.qfn = 0;
               this.qjf(3);
               return;
            }

            this.qho = Integer.MIN_VALUE;
         }

         if (this.qfi >= this.qih) {
            this.qih = this.qfi + 20;
            this.qii = this.qjg(var1);
         }

         if (this.qii >= 0 && this.qii <= 4) {
            this.qlj(a.d("枴Ḅ铕\u0ab1脿", -1744326495, 1724438399) + this.qii + a.b("菓都烸\uee81敚\ue3e9妻큀丈쓪䍵뤍㟙깺⑧ꊌᢇ靝෯讵", 375161831));
            this.qfx = null;
            this.qga = null;
            this.qfh = qdw.DONE;
         } else {
            boolean var6 = this.qfx != null && this.qfi - this.qhp < 8;
            if (this.qgs != null ? !this.qjm(var1, var2, var5, var6) && !this.qjl(var1, var2, var5, var6) : !this.qjl(var1, var2, var5, var6)) {
               if (this.qjt(var1, var2, var5)) {
                  this.qfn = 0;
                  this.qjf(1);
               } else if (this.qjh(var1, var5)) {
                  this.qjf(5);
               } else {
                  if (var5 > this.qfg.minY) {
                     BlockPos var7 = this.qji(var1, var2, var5 - 1);
                     if (var7 != null && this.qjk(var1, var2, var7)) {
                        this.qho = Math.max(this.qfg.minY, var5 - 3);
                        this.qfn = 0;
                        this.qlj(a.d("䙙㿣딨⭀ꃙ☮鱩ᖅ诘Ĥ", -1066751725, -636358876) + var5 + a.c(-1990803626, "뽲욗䱟퉡") + this.qho);
                        this.qjf(3);
                        return;
                     }

                     if (this.qju(var1, var2, var5)) {
                        this.qfn = 0;
                        this.qjf(1);
                        return;
                     }
                  }

                  this.qfx = null;
                  this.qga = null;
                  this.qjf(5);
                  if (++this.qfn > 30) {
                     this.qfh = qdw.DONE;
                  }
               }
            } else {
               this.qfn = 0;
               this.qjf(0);
            }
         }
      }
   }

   private void qjf(int var1) {
      this.qie[var1]++;
   }

   private int qjg(World var1) {
      int var2 = 0;
      Mutable var3 = new Mutable();

      for (int var4 = this.qfg.minX; var4 <= this.qfg.maxX; var4++) {
         for (int var5 = this.qfg.minZ; var5 <= this.qfg.maxZ; var5++) {
            for (int var6 = this.qfg.minY; var6 <= this.qfg.maxY; var6++) {
               if (this.qfe.test(var1.method_8320(var3.method_10103(var4, var6, var5))) && !this.qev.contains(var3.method_10063())) {
                  var2++;
               }
            }
         }
      }

      return var2;
   }

   public int diamondsLeft() {
      return this.qii;
   }

   public String sweepStats() {
      String[] var1 = new String[]{
         a.b("쑎뷦㜿ꥆ", 1490011194),
         a.b("挆᪡避ฉ", 103310197),
         a.c(1836456759, "᭓拮\ue83e癏\ufd91符셢"),
         a.c(-224282623, "롡쇛䬐핸"),
         a.c(-414068310, "퇈\ua87e⊠병"),
         a.c(-43629126, "䗗㱫뚰⣈"),
         a.c(1320217503, "\uebf5鉔ᢐ蛥സ讋㇟렧")
      };
      StringBuilder var2 = new StringBuilder();

      for (int var3 = 0; var3 < var1.length; var3++) {
         var2.append(var1[var3]).append(' ').append(this.qie[var3]).append(var3 + 1 < var1.length ? a.b("ꚭ", 367896204) : "");
      }

      return var2.toString();
   }

   private boolean qjh(World var1, int var2) {
      if (this.qif == var2) {
         return false;
      } else {
         this.qif = var2;
         boolean var3 = false;
         int var4 = Math.min(this.qfg.maxY, var2 + 4);
         ObjectIterator var5 = this.qew.long2LongEntrySet().fastIterator();

         while (var5.hasNext()) {
            Entry var6 = (Entry)var5.next();
            int var7 = BlockPos.method_10071(var6.getLongKey());
            if (var6.getLongValue() > this.qfi && var7 >= var2 && var7 <= var4) {
               var5.remove();
               var3 = true;
            }
         }

         return var3;
      }
   }

   private BlockPos qji(World var1, ClientPlayerEntity var2, int var3) {
      Box var4 = var2.method_5829();
      BlockPos var5 = null;
      double var6 = Double.MAX_VALUE;

      for (int var8 = MathHelper.method_15357(var4.field_1323 + 0.001); var8 <= MathHelper.method_15357(var4.field_1320 - 0.001); var8++) {
         for (int var9 = MathHelper.method_15357(var4.field_1321 + 0.001); var9 <= MathHelper.method_15357(var4.field_1324 - 0.001); var9++) {
            BlockPos var10 = new BlockPos(var8, var3, var9);
            BlockState var11 = var1.method_8320(var10);
            if (!var11.method_26220(var1, var10).method_1110()) {
               if (!this.qfg.contains(var10)
                  || !qjq(var1, var10, var11)
                  || this.qev.contains(var10.method_10063())
                  || this.qew.getOrDefault(var10.method_10063(), 0L) > this.qfi) {
                  return null;
               }

               double var12 = (var8 + 0.5 - var2.method_23317()) * (var8 + 0.5 - var2.method_23317())
                  + (var9 + 0.5 - var2.method_23321()) * (var9 + 0.5 - var2.method_23321());
               if (var12 < var6) {
                  var6 = var12;
                  var5 = var10;
               }
            }
         }
      }

      return var5;
   }

   private int qjj(World var1, ClientPlayerEntity var2) {
      Box var3 = var2.method_5829();
      int var4 = MathHelper.method_15357(var2.method_23318() - 0.001);

      for (int var5 = var4; var5 >= var4 - 4; var5--) {
         for (int var6 = MathHelper.method_15357(var3.field_1323 + 0.001); var6 <= MathHelper.method_15357(var3.field_1320 - 0.001); var6++) {
            for (int var7 = MathHelper.method_15357(var3.field_1321 + 0.001); var7 <= MathHelper.method_15357(var3.field_1324 - 0.001); var7++) {
               BlockPos var8 = new BlockPos(var6, var5, var7);
               if (!var1.method_8320(var8).method_26220(var1, var8).method_1110()) {
                  return var5;
               }
            }
         }
      }

      return Integer.MIN_VALUE;
   }

   private boolean qjk(World var1, ClientPlayerEntity var2, BlockPos var3) {
      if (var3 == null) {
         return false;
      } else if (this.qfb.getOrDefault(var3.method_10063(), 0) > this.qfi) {
         this.qfx = null;
         return true;
      } else {
         Vec3d var4 = null;

         for (qda var6 : this.qki(var1, var2, var3)) {
            if (var6.axis() == Axis.field_11052.ordinal() && var6.point().field_1351 < var2.method_23320()) {
               var4 = var6.point();
               break;
            }
         }

         if (var4 == null) {
            var4 = this.qkx(var1, var2, var3);
         }

         if (var4 == null) {
            return false;
         } else {
            BlockState var7 = var1.method_8320(var3);
            this.qku(var3, var7.method_26204(), this.qfe.test(var7), var4);
            this.qfx = null;
            this.qga = null;
            return true;
         }
      }
   }

   private boolean qjl(World var1, ClientPlayerEntity var2, int var3, boolean var4) {
      Vec3d var5 = var2.method_33571();
      int var6 = MathHelper.method_15357(var5.field_1352);
      int var7 = MathHelper.method_15357(var5.field_1350);
      int var8 = Math.max(this.qfg.minY, var3);
      int var9 = Math.min(this.qfg.maxY, MathHelper.method_15357(var5.field_1351 + 4.4));
      LongOpenHashSet var10 = qjp(var1, var2, var3);
      LongArrayList var11 = new LongArrayList();
      DoubleArrayList var12 = new DoubleArrayList();
      Mutable var13 = new Mutable();
      double var14 = 24.010000000000005;

      for (int var16 = var6 - 5; var16 <= var6 + 5; var16++) {
         for (int var17 = var7 - 5; var17 <= var7 + 5; var17++) {
            for (int var18 = var8; var18 <= var9; var18++) {
               if (this.qfg.contains(var16, var18, var17)) {
                  BlockState var19 = var1.method_8320(var13.method_10103(var16, var18, var17));
                  if (qjq(var1, var13, var19)) {
                     long var20 = BlockPos.method_10064(var16, var18, var17);
                     if (this.qfe.test(var19)) {
                        this.qfc.add(var20);
                     }

                     double var22 = var16 + 0.5 - var5.field_1352;
                     double var24 = var18 + 0.5 - var5.field_1351;
                     double var26 = var17 + 0.5 - var5.field_1350;
                     if (!(var22 * var22 + var24 * var24 + var26 * var26 > var14) && !this.qkb(var20) && qjr(var1, var13)) {
                        double var28 = qim(var2, new Vec3d(var16 + 0.5, var18 + 0.5, var17 + 0.5));
                        double var30 = var18 == var3 + 1 ? 3.0 : (var18 == var3 ? 1.2 : 1.8);
                        var11.add(var20);
                        var12.add(this.qka(var19) * var30 / qjo(var28));
                     }
                  }
               }
            }
         }
      }

      if (var11.isEmpty()) {
         return false;
      } else {
         Integer[] var36 = new Integer[var11.size()];

         for (int var37 = 0; var37 < var36.length; var37++) {
            var36[var37] = var37;
         }

         Arrays.sort(var36, (var1x, var2x) -> Double.compare(var12.getDouble(var2x), var12.getDouble(var1x)));
         qda var38 = null;
         double var39 = 0.0;
         boolean var40 = false;

         for (int var21 = 0; var21 < Math.min(14, var36.length); var21++) {
            long var42 = var11.getLong(var36[var21]);
            BlockPos var43 = BlockPos.method_10092(var42);
            BlockState var25 = var1.method_8320(var43);

            for (qda var27 : this.qki(var1, var2, var43)) {
               double var45 = qjo(var27.turn());
               double var46 = this.qjn(var1, var43, var25, var27.axis(), var27.look(), var3, var10, var13) / var45;
               double var32 = var27.turn() < 2.0
                  ? 0.0
                  : this.qjn(var1, var43, var25, var27.axis(), qln.lookAxes(var27.yaw(), var27.pitch()), var3, var10, var13) / (var45 + 1.0);
               double var34 = Math.max(var46, var32);
               if (var34 > var39) {
                  var39 = var34;
                  var38 = var27;
                  var40 = var32 > var46;
               }
            }
         }

         if (var38 == null) {
            return false;
         } else {
            BlockState var41 = var1.method_8320(var38.pos());
            this.qkv(var38.pos(), var41.method_26204(), this.qfe.test(var41), var38.point(), var4);
            this.qhr = var40 ? 1 : 0;
            return true;
         }
      }
   }

   private boolean qjm(World var1, ClientPlayerEntity var2, int var3, boolean var4) {
      BlockPos var5 = null;
      if (!this.qey.isEmpty()) {
         qcu var6 = this.qey.get(this.qey.size() - 1);
         if (this.qfi - var6.tick() <= 40) {
            var5 = BlockPos.method_10092(var6.pos());
         }
      }

      long[] var30 = this.qgs
         .rank(
            var1,
            var2,
            this.qfg,
            var1x -> this.qew.getOrDefault(var1x, 0L) > this.qfi || this.qev.contains(var1x),
            var1x -> this.qfb.getOrDefault(var1x, 0) > this.qfi,
            var5,
            6
         );
      if (var30.length == 0) {
         return false;
      } else {
         LongOpenHashSet var7 = qjp(var1, var2, var3);
         Mutable var8 = new Mutable();

         for (long var12 : var30) {
            BlockPos var14 = BlockPos.method_10092(var12);
            BlockState var15 = var1.method_8320(var14);
            if (this.qfg.contains(var14) && !this.qkb(var12) && qjq(var1, var14, var15)) {
               qda var16 = null;
               double var17 = Double.NEGATIVE_INFINITY;
               boolean var19 = false;

               for (qda var21 : this.qki(var1, var2, var14)) {
                  double var22 = qjo(var21.turn());
                  double var24 = this.qjn(var1, var14, var15, var21.axis(), var21.look(), var3, var7, var8) / var22;
                  double var26 = var21.turn() < 2.0
                     ? Double.NEGATIVE_INFINITY
                     : this.qjn(var1, var14, var15, var21.axis(), qln.lookAxes(var21.yaw(), var21.pitch()), var3, var7, var8) / (var22 + 1.0);
                  double var28 = Math.max(var24, var26);
                  if (var16 == null || var28 > var17) {
                     var16 = var21;
                     var17 = var28;
                     var19 = var26 > var24;
                  }
               }

               if (var16 != null) {
                  this.qkv(var14, var15.method_26204(), this.qfe.test(var15), var16.point(), var4);
                  this.qhr = var19 ? 1 : 0;
                  return true;
               }
            }
         }

         return false;
      }
   }

   private double qjn(World var1, BlockPos var2, BlockState var3, int var4, double[] var5, int var6, LongOpenHashSet var7, Mutable var8) {
      long var9 = var2.method_10063();
      double var11 = this.qka(var3);

      for (int var13 = -1; var13 <= 1; var13++) {
         for (int var14 = -1; var14 <= 1; var14++) {
            for (int var15 = -1; var15 <= 1; var15++) {
               if (var13 != 0 || var14 != 0 || var15 != 0) {
                  int var16 = var2.method_10263() + var13;
                  int var17 = var2.method_10264() + var14;
                  int var18 = var2.method_10260() + var15;
                  if (this.qfg.contains(var16, var17, var18)) {
                     long var19 = BlockPos.method_10064(var16, var17, var18);
                     if (!this.qkb(var19)) {
                        BlockState var21 = var1.method_8320(var8.method_10103(var16, var17, var18));
                        if (qjq(var1, var8, var21)) {
                           double var22 = this.qes.expect(var19, var9, var4, var5);
                           if (!(var22 <= 0.0)) {
                              if (var17 < var6) {
                                 var11 -= (var7.contains(var19) ? 8.0 : 0.7) * var22;
                              } else {
                                 var11 += this.qka(var21) * var22;
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return var11;
   }

   private static double qjo(double var0) {
      return 1.0 + var0 / 55.0 + Math.max(0.0, var0 - 60.0) / 40.0;
   }

   private static LongOpenHashSet qjp(World var0, ClientPlayerEntity var1, int var2) {
      LongOpenHashSet var3 = new LongOpenHashSet();
      Box var4 = var1.method_5829();

      for (int var5 = MathHelper.method_15357(var4.field_1323 + 0.001); var5 <= MathHelper.method_15357(var4.field_1320 - 0.001); var5++) {
         for (int var6 = MathHelper.method_15357(var4.field_1321 + 0.001); var6 <= MathHelper.method_15357(var4.field_1324 - 0.001); var6++) {
            var3.add(BlockPos.method_10064(var5, var2 - 1, var6));
         }
      }

      return var3;
   }

   private static boolean qjq(World var0, BlockPos var1, BlockState var2) {
      return !var2.method_26215()
         && var2.method_26227().method_15769()
         && var2.method_26214(var0, var1) >= 0.0F
         && !var2.method_26220(var0, var1).method_1110();
   }

   private static boolean qjr(World var0, BlockPos var1) {
      for (Direction var5 : Direction.values()) {
         BlockPos var6 = var1.method_10093(var5);
         if (var0.method_8320(var6).method_26218(var0, var6).method_1110()) {
            return true;
         }
      }

      return false;
   }

   private static boolean qjs(World var0, BlockPos var1) {
      return var0.method_8320(var1).method_26220(var0, var1).method_1110();
   }

   private boolean qjt(World var1, ClientPlayerEntity var2, int var3) {
      qdk var4 = new qdk(this, var1, var2, var3);
      if (var4.start < 0) {
         return false;
      } else {
         long[] var5 = new long[var4.w * var4.d];
         Arrays.fill(var5, Long.MIN_VALUE);
         Mutable var6 = new Mutable();
         int var7 = Math.min(this.qfg.maxY, var3 + 4);
         boolean var8 = false;

         for (int var9 = this.qfg.minX; var9 <= this.qfg.maxX; var9++) {
            for (int var10 = this.qfg.minZ; var10 <= this.qfg.maxZ; var10++) {
               for (int var11 = Math.max(this.qfg.minY, var3); var11 <= var7; var11++) {
                  long var12 = BlockPos.method_10064(var9, var11, var10);
                  if (!this.qkb(var12) && qjq(var1, var6.method_10103(var9, var11, var10), var1.method_8320(var6))) {
                     var8 = true;

                     for (int var14 = var9 - 3; var14 <= var9 + 3; var14++) {
                        for (int var15 = var10 - 3; var15 <= var10 + 3; var15++) {
                           int var16 = var4.index(var14, var15);
                           if (var16 >= 0 && var5[var16] == Long.MIN_VALUE) {
                              double var17 = var9 - var14;
                              double var19 = var11 + 0.5 - (var3 + 1.62);
                              double var21 = var10 - var15;
                              if (var17 * var17 + var19 * var19 + var21 * var21 <= 12.96) {
                                 var5[var16] = var12;
                              }
                           }
                        }
                     }
                     break;
                  }
               }
            }
         }

         if (!var8) {
            return false;
         } else {
            if (this.qhq != Long.MIN_VALUE && this.qfi - this.qhp <= 2) {
               BlockPos var23 = BlockPos.method_10092(this.qhq);
               if (Vec3d.method_24953(var23).method_1022(var2.method_33571()) <= 3.9) {
                  this.qlf(var23, 400);
                  this.qhq = Long.MIN_VALUE;
               }
            }

            int[] var24 = var4.path(var3x -> var3x != var4.start && var5[var3x] != Long.MIN_VALUE && this.qew.getOrDefault(var5[var3x], 0L) <= this.qfi);
            if (var24 == null) {
               return false;
            } else {
               long var25 = var5[var24[var24.length - 1]];
               this.qjv(var4.waypoint(var2, var24), var24.length <= 3, var25, Vec3d.method_24953(BlockPos.method_10092(var25)));
               return true;
            }
         }
      }
   }

   private boolean qju(World var1, ClientPlayerEntity var2, int var3) {
      qdk var4 = new qdk(this, var1, var2, var3);
      if (var4.start < 0) {
         return false;
      } else {
         Mutable var5 = new Mutable();
         int[] var6 = var4.path(
            var5x -> {
               if (var5x == var4.start) {
                  return false;
               } else {
                  int var6x = var4.cellX(var5x);
                  int var7x = var4.cellZ(var5x);
                  return this.qfg.contains(var6x, var3 - 1, var7x) && !this.qkb(BlockPos.method_10064(var6x, var3 - 1, var7x))
                     ? qjq(var1, var5.method_10103(var6x, var3 - 1, var7x), var1.method_8320(var5))
                     : false;
               }
            }
         );
         if (var6 == null) {
            return false;
         } else {
            int var7 = var6[var6.length - 1];
            Vec3d var8 = var6.length <= 2 ? new Vec3d(var4.cellX(var7) + 0.5, var3, var4.cellZ(var7) + 0.5) : var4.waypoint(var2, var6);
            this.qjv(
               var8,
               true,
               BlockPos.method_10064(var4.cellX(var7), var3 - 1, var4.cellZ(var7)),
               new Vec3d(var4.cellX(var7) + 0.5, var3 - 0.5, var4.cellZ(var7) + 0.5)
            );
            return true;
         }
      }
   }

   private void qjv(Vec3d var1, boolean var2, long var3, Vec3d var5) {
      if (var3 != this.qhq) {
         this.qhq = var3;
         this.qgb = new Object();
      } else if (this.qgn > 40) {
         this.qgn = 0;
         this.qlf(BlockPos.method_10092(var3), 400);
      }

      this.qfx = var1;
      this.qhp = this.qfi;
      this.qfy = false;
      this.qfz = var2;
      this.qga = var5;
   }

   private void qjw(World var1, ClientPlayerEntity var2, boolean var3) {
      BlockPos var4 = this.qfj.target();
      int var5 = this.qfj.path()[this.qfk * 3];
      int var6 = this.qfj.path()[this.qfk * 3 + 1];
      int var7 = this.qfj.path()[this.qfk * 3 + 2];
      int var8 = this.qfj.path()[(this.qfk + 1) * 3];
      int var9 = this.qfj.path()[(this.qfk + 1) * 3 + 1];
      int var10 = this.qfj.path()[(this.qfk + 1) * 3 + 2];
      int var11 = this.qjy(var1, var5, var6, var7, var8, var9, var10);
      int var12 = this.qfj.path()[var11 * 3];
      int var13 = this.qfj.path()[var11 * 3 + 2];
      Vec3d var14 = new Vec3d(var12 + 0.5, var9, var13 + 0.5);
      if (var3 && this.qjz()) {
         int var34 = this.qkk(var1, var2);
         if (var34 < 0) {
            this.qlj(
               a.d("剮⯑ꄁ㽼뒣㈜衎ǻ鿷ᕁ銃棧\ue660", -687595192, 1631875913)
                  + var5
                  + a.b("｜", 1678311281)
                  + var6
                  + a.c(-101397769, "쫚")
                  + var7
                  + a.c(1345220264, "溌ᜰ鷰Ο")
                  + var8
                  + a.d("婱", 2084715363, 1591501119)
                  + var9
                  + a.d("뱣", 1987281718, -294174856)
                  + var10
            );
            this.qfl = true;
            this.qfx = null;
            return;
         }

         if (var34 > 0) {
            this.qfx = var34 == 2 ? null : var14;
            this.qfy = var9 > var6;
            this.qfz = true;
            return;
         }
      } else {
         for (BlockPos var16 : this.qks(var5, var6, var7, var8, var9, var10)) {
            if (qle(var1, var16)) {
               if (!this.qlc(var1, var16)) {
                  this.qlj(
                     a.b("㼿䚀챐刭\ud9f2彍\ue51f沪", -702202027)
                        + var16.method_23854()
                        + a.c(178799320, "䋾㬜뇈⾨ꑪ⊋")
                        + var5
                        + a.d("놮", 296989217, 626197410)
                        + var6
                        + a.d("㕞", 227536667, -1637885336)
                        + var7
                        + a.d("艚ﯦ焦\uef49", 10353374, 732068000)
                        + var8
                        + a.b("賈", 756152622)
                        + var9
                        + a.d("⫤", 298627232, -1451976087)
                        + var10
                  );
                  this.qfl = true;
                  this.qfx = null;
                  return;
               }

               this.qkt(var1, var2, var16, false);
               if (this.qfr != null) {
                  return;
               }

               this.qlj(
                  a.b("亇㜷붫⎛ꡄ⻱铯", -1146532114)
                     + var16.method_23854()
                     + a.b("㠁䇣쬷啗\ude95塴", -731826137)
                     + var5
                     + a.b("\uf6fb", -170592554)
                     + var6
                     + a.b("핃", -775694994)
                     + var7
                     + a.b("졣뇟㬟ꕰ", 783534151)
                     + var8
                     + a.d("\ue21e", 1966740213, 1608052934)
                     + var9
                     + a.c(-1758479877, "맖")
                     + var10
               );
               this.qfl = true;
               return;
            }
         }
      }

      if (this.qgn > 50) {
         this.qlj(
            a.b("磉ſ训ᗊ鸕ᣯꋽ⬙딒", 855406771)
               + var2.method_24515().method_23854()
               + a.d("崏⓪긢〜", 1758371912, 667549027)
               + var8
               + a.c(-1347100770, "\udfb3")
               + var9
               + a.d("뎅", -657149490, -474611098)
               + var10
         );
         this.qgn = 0;
         if (++this.qgo >= 3) {
            if (this.qhc != null) {
               this.qhd = true;
            } else {
               this.qlf(var4, 600);
            }

            this.qgo = 0;
         }

         this.qfl = true;
         this.qfx = null;
      } else {
         this.qfz = var9 <= var6 && (var11 >= this.qkl() - 1 || this.qko(var11));
         if (this.qfx == null || this.qfx.field_1352 != var14.field_1352 || this.qfx.field_1351 != var14.field_1351 || this.qfx.field_1350 != var14.field_1350) {
            this.qlj(
               a.b("픶겑♏령㎥", 224449860)
                  + var5
                  + a.c(-593811850, "♛")
                  + var6
                  + a.c(865264831, "\ue492")
                  + var7
                  + a.b("倉⦵ꍵ㴚", -978956243)
                  + var12
                  + a.c(-389982549, "嚆")
                  + var9
                  + a.b("氱", -1629328356)
                  + var13
            );
         }

         this.qfx = var14;
         this.qfy = var9 > var6;
         int var35 = Math.min(this.qkl() - 1, this.qfk + 3);
         int var36 = this.qfj.path()[var35 * 3];
         int var17 = this.qfj.path()[var35 * 3 + 1];
         int var18 = this.qfj.path()[var35 * 3 + 2];
         Vec3d var19 = var2.method_33571();
         if (var3 && this.qgr != null && qjx(var19, var36, var18, var4)) {
            long var37 = var4.method_10063() ^ 25214903917L;
            if (var37 != this.qgc || this.qga == null) {
               this.qgc = var37;
               this.qgb = new Object();
               this.qga = Vec3d.method_24953(var4);
            }
         } else {
            long var20 = BlockPos.method_10064(var36, var17, var18);
            if (var20 != this.qgc || this.qga == null) {
               this.qgc = var20;
               this.qgb = new Object();
               Vec3d var22 = new Vec3d(var36 + 0.5, var17 + (this.qgr != null ? 1.45 : 0.9), var18 + 0.5);
               Vec3d var23 = var22.method_1020(var19);
               double var24 = Math.sqrt(var23.field_1352 * var23.field_1352 + var23.field_1350 * var23.field_1350);
               if (var24 < 1.5) {
                  double var26 = var8 - var5;
                  double var28 = var10 - var7;
                  double var30 = Math.sqrt(var26 * var26 + var28 * var28);
                  if (var30 < 0.5) {
                     double var32 = Math.toRadians(var2.method_36454());
                     var26 = -Math.sin(var32);
                     var28 = Math.cos(var32);
                     var30 = 1.0;
                  }

                  var22 = new Vec3d(
                     var19.field_1352 + var26 / var30 * 3.0, var19.field_1351 - (var9 < var6 ? 1.6 : 0.4), var19.field_1350 + var28 / var30 * 3.0
                  );
               }

               this.qga = var22;
            }
         }
      }
   }

   private static boolean qjx(Vec3d var0, int var1, int var2, BlockPos var3) {
      double var4 = var1 + 0.5 - var0.field_1352;
      double var6 = var2 + 0.5 - var0.field_1350;
      double var8 = var3.method_10263() + 0.5 - var0.field_1352;
      double var10 = var3.method_10260() + 0.5 - var0.field_1350;
      double var12 = Math.sqrt(var4 * var4 + var6 * var6);
      double var14 = Math.sqrt(var8 * var8 + var10 * var10);
      return !(var12 < 0.5) && !(var14 < 0.5) && !(Math.abs(var3.method_10264() + 0.5 - var0.field_1351) > var14 * 0.7)
         ? (var4 * var8 + var6 * var10) / (var12 * var14) > 0.34
         : false;
   }

   private int qjy(World var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8 = this.qfk + 1;
      if (var6 != var3) {
         return var8;
      } else {
         int var9 = var5 - var2;
         int var10 = var7 - var4;
         int var11 = var8;

         for (int[] var12 = this.qfj.path(); var11 + 1 < this.qkl() && var11 + 1 <= this.qfk + 4; var11++) {
            int var13 = var12[var11 * 3];
            int var14 = var12[var11 * 3 + 1];
            int var15 = var12[var11 * 3 + 2];
            int var16 = var12[(var11 + 1) * 3];
            int var17 = var12[(var11 + 1) * 3 + 1];
            int var18 = var12[(var11 + 1) * 3 + 2];
            if (var17 != var14 || var16 - var13 != var9 || var18 - var15 != var10) {
               break;
            }

            boolean var19 = true;

            for (BlockPos var21 : this.qks(var13, var14, var15, var16, var17, var18)) {
               if (qle(var1, var21)) {
                  var19 = false;
                  break;
               }
            }

            if (!var19 || !qle(var1, new BlockPos(var16, var17 - 1, var18))) {
               break;
            }
         }

         return var11;
      }
   }

   private boolean qjz() {
      return this.qgr != null && this.qgy;
   }

   private double qka(BlockState var1) {
      return 1.0 + qnd.value(var1) / 15.0;
   }

   private boolean qkb(long var1) {
      return this.qfb.getOrDefault(var1, 0) > this.qfi || this.qew.getOrDefault(var1, 0L) > this.qfi || this.qev.contains(var1);
   }

   private int qkc(World var1, ClientPlayerEntity var2, BlockPos var3, BlockState var4) {
      float var5 = var4.method_26165(var2, var1, var3);
      return var5 <= 0.0F ? 600 : Math.max(1, (int)Math.ceil(1.0F / var5));
   }

   private double qkd(double var1) {
      return var1 / Math.max(10.0, this.qil());
   }

   private boolean qke(World var1, ClientPlayerEntity var2) {
      if (this.qfg != null && this.qfg.maxX >= this.qfg.minX) {
         Vec3d var3 = var2.method_33571();
         int var4 = MathHelper.method_15357(var3.field_1352);
         int var5 = MathHelper.method_15357(var3.field_1351);
         int var6 = MathHelper.method_15357(var3.field_1350);
         double var7 = 6.0;
         Long2DoubleOpenHashMap var9 = new Long2DoubleOpenHashMap();
         Mutable var10 = new Mutable();

         for (int var11 = var4 - 6; var11 <= var4 + 6; var11++) {
            for (int var12 = var5 - 6; var12 <= var5 + 5; var12++) {
               for (int var13 = var6 - 6; var13 <= var6 + 6; var13++) {
                  if (this.qfg.contains(var11, var12, var13)) {
                     double var14 = var11 + 0.5 - var3.field_1352;
                     double var16 = var12 + 0.5 - var3.field_1351;
                     double var18 = var13 + 0.5 - var3.field_1350;
                     if (!(var14 * var14 + var16 * var16 + var18 * var18 > var7 * var7)) {
                        long var20 = BlockPos.method_10064(var11, var12, var13);
                        if (!this.qkb(var20)) {
                           BlockState var22 = var1.method_8320(var10.method_10103(var11, var12, var13));
                           if (!var22.method_26215() && this.qfe.test(var22)) {
                              var9.put(var20, this.qka(var22));
                              this.qfc.add(var20);
                           }
                        }
                     }
                  }
               }
            }
         }

         if (var9.isEmpty()) {
            return false;
         } else {
            Long2DoubleOpenHashMap var38 = new Long2DoubleOpenHashMap();
            LongOpenHashSet var39 = new LongOpenHashSet();
            ObjectIterator var40 = var9.long2DoubleEntrySet().iterator();

            while (var40.hasNext()) {
               it.unimi.dsi.fastutil.longs.Long2DoubleMap.Entry var42 = (it.unimi.dsi.fastutil.longs.Long2DoubleMap.Entry)var40.next();
               long var15 = var42.getLongKey();

               for (int var17 = -1; var17 <= 1; var17++) {
                  for (int var49 = -1; var49 <= 1; var49++) {
                     for (int var19 = -1; var19 <= 1; var19++) {
                        if (var17 == 0 && var49 == 0 && var19 == 0 || this.qgy) {
                           var39.add(BlockPos.method_10096(var15, var17, var49, var19));
                        }
                     }
                  }
               }

               BlockPos var47 = BlockPos.method_10092(var15);
               if (Vec3d.method_24953(var47).method_1022(var3) <= 4.7) {
                  BlockPos var50 = qla(var1, var2, var3, var47);
                  if (var50 != null && qkg(var50.method_10063(), var15) > (this.qgy ? 1 : 0)) {
                     var39.add(var50.method_10063());
                     double var52 = 0.45 * var42.getDoubleValue();
                     if (var52 > var38.get(var50.method_10063())) {
                        var38.put(var50.method_10063(), var52);
                     }
                  }
               }
            }

            boolean var41 = this.qgy && this.qes.p(2) < 0.98;
            LongArrayList var43 = new LongArrayList();
            Long2DoubleOpenHashMap var44 = new Long2DoubleOpenHashMap();
            LongIterator var45 = var39.iterator();

            while (var45.hasNext()) {
               long var48 = var45.nextLong();
               BlockPos var53 = BlockPos.method_10092(var48);
               if (this.qfg.contains(var53) && !this.qkb(var48)) {
                  Vec3d var55 = Vec3d.method_24953(var53);
                  double var21 = var55.method_1022(var3);
                  if (!(var21 > 4.45)) {
                     BlockState var23 = var1.method_8320(var53);
                     if (!var23.method_26215() && var23.method_26227().method_15769() && !(var23.method_26214(var1, var53) < 0.0F)) {
                        double var24 = var9.get(var48) + var38.get(var48);
                        if (var41) {
                           ObjectIterator var26 = var9.long2DoubleEntrySet().iterator();

                           while (var26.hasNext()) {
                              it.unimi.dsi.fastutil.longs.Long2DoubleMap.Entry var27 = (it.unimi.dsi.fastutil.longs.Long2DoubleMap.Entry)var26.next();
                              long var28 = var27.getLongKey();
                              if (var28 != var48 && qkg(var28, var48) <= 1 && qkh(var28, var48)) {
                                 var24 += var27.getDoubleValue();
                              }
                           }
                        }

                        if (!(var24 <= 0.0)) {
                           double var67 = Math.toDegrees(Math.atan2(0.6, Math.max(0.6, var21)));
                           double var70 = this.qkc(var1, var2, var53, var23) + this.qkd(Math.max(0.0, this.qgr.error(var2, var55) - var67)) + 0.35;
                           var44.put(var48, var24 / var70);
                           var43.add(var48);
                        }
                     }
                  }
               }
            }

            if (var43.isEmpty()) {
               return false;
            } else {
               var43.sort((var1x, var3x) -> Double.compare(var44.get(var3x), var44.get(var1x)));
               long var46 = standing(var1, var2).method_10074().method_10063();
               ArrayList var51 = new ArrayList();
               int var54 = 0;

               for (int var56 = 0; var56 < var43.size() && var54 < 32; var56++) {
                  long var58 = var43.getLong(var56);
                  if (var51.size() >= 10 && var44.get(var58) <= ((qdt)var51.get(9)).rate()) {
                     break;
                  }

                  var54++;
                  BlockPos var60 = BlockPos.method_10092(var58);
                  BlockState var63 = var1.method_8320(var60);
                  double var25 = this.qkc(var1, var2, var60, var63);
                  qdt var68 = null;

                  for (qda var29 : this.qki(var1, var2, var60)) {
                     qdt var30 = new qdt(var29, var9.get(var58) + var38.get(var58), var25);
                     var30.value = var30.own;
                     if (var9.containsKey(var58)) {
                        var30.caught.add(var58);
                        var30.chance.add(1.0);
                     }

                     if (var41) {
                        ObjectIterator var31 = var9.long2DoubleEntrySet().iterator();

                        while (var31.hasNext()) {
                           it.unimi.dsi.fastutil.longs.Long2DoubleMap.Entry var32 = (it.unimi.dsi.fastutil.longs.Long2DoubleMap.Entry)var31.next();
                           long var33 = var32.getLongKey();
                           if (var33 != var58 && qkg(var33, var58) <= 1) {
                              double var35 = this.qes.expect(var33, var58, var29.axis(), var29.look());
                              if (var35 > 0.0) {
                                 var30.value = var30.value + var32.getDoubleValue() * var35;
                                 var30.caught.add(var33);
                                 var30.chance.add(var35);
                              }
                           }
                        }
                     }

                     double var76 = var46 == var58 ? 1.0 : (var41 ? this.qes.expect(var46, var58, var29.axis(), var29.look()) : 0.0);
                     var30.time = var25 + this.qkd(var29.turn()) + 0.35 + var76 * 0.8;
                     if (var68 == null || var30.rate() > var68.rate()) {
                        var68 = var30;
                     }
                  }

                  if (var68 != null && !(var68.value <= 0.0)) {
                     int var72 = 0;

                     while (var72 < var51.size() && ((qdt)var51.get(var72)).rate() >= var68.rate()) {
                        var72++;
                     }

                     var51.add(var72, var68);
                     if (var51.size() > 10) {
                        var51.remove(var51.size() - 1);
                     }
                  }
               }

               if (var51.isEmpty()) {
                  return false;
               } else {
                  qdt var57 = null;
                  double var59 = 0.0;

                  for (qdt var64 : var51) {
                     double var66 = var64.rate();

                     for (qdt var73 : var51) {
                        if (var73 != var64
                           && !(var64.chanceOf(var73.key) >= 0.5)
                           && (!var41 || !(this.qes.expect(var73.key, var64.key, var64.hit.axis(), var64.hit.look()) >= 0.5))) {
                           double[] var74 = qln.lookAxes(var64.hit.yaw(), var64.hit.pitch());
                           double var75 = var73.own * (1.0 - var64.chanceOf(var73.key));
                           if (var41) {
                              ObjectIterator var77 = var9.long2DoubleEntrySet().iterator();

                              while (var77.hasNext()) {
                                 it.unimi.dsi.fastutil.longs.Long2DoubleMap.Entry var79 = (it.unimi.dsi.fastutil.longs.Long2DoubleMap.Entry)var77.next();
                                 long var34 = var79.getLongKey();
                                 if (var34 != var73.key && qkg(var34, var73.key) <= 1) {
                                    double var36 = this.qes.expect(var34, var73.key, var73.hit.axis(), var74);
                                    var75 += var79.getDoubleValue() * var36 * (1.0 - var64.chanceOf(var34));
                                 }
                              }
                           }

                           double var78 = qkf(var3, var64.hit.point(), var73.hit.point());
                           double var80 = (var64.value + var75) / (var64.time + var73.ticks + this.qkd(var78) + 0.35);
                           var66 = Math.max(var66, var80);
                        }
                     }

                     if (var66 > var59) {
                        var59 = var66;
                        var57 = var64;
                     }
                  }

                  if (var57 != null && !(var59 < 0.12)) {
                     BlockPos var62 = var57.hit.pos();
                     BlockState var65 = var1.method_8320(var62);
                     this.qkv(var62, var65.method_26204(), var9.containsKey(var57.key), var57.hit.point(), this.qfx != null && this.qfj != null);
                     if (trace != null) {
                        this.qlj(
                           String.format(
                              Locale.ROOT,
                              a.c(-894157631, "㲄䔬쿵册\uda10岤\ue6a1漃\uf10a篰ﰻف袊ᅯ魺ᷟꟙ⠐늨㓥뵆응䦶퉦吞\uded3朳\ue97a玆\uf5c9縬肻ધ鍆ᔙ龵⁵꩜ⲗ딭㽮䇋쯞䰠훾壉\ue11f毯\uede4瘽\uf843˄謩"),
                              var62.method_23854(),
                              var57.value,
                              var57.time,
                              var57.hit.turn(),
                              var59,
                              var51.size(),
                              this.qes.describe()
                           )
                        );
                     }

                     return true;
                  } else {
                     return false;
                  }
               }
            }
         }
      } else {
         return false;
      }
   }

   private static double qkf(Vec3d var0, Vec3d var1, Vec3d var2) {
      Vec3d var3 = var1.method_1020(var0).method_1029();
      Vec3d var4 = var2.method_1020(var0).method_1029();
      return Math.toDegrees(Math.acos(MathHelper.method_15350(var3.method_1026(var4), -1.0, 1.0)));
   }

   private static int qkg(long var0, long var2) {
      return Math.max(
         Math.abs(BlockPos.method_10061(var0) - BlockPos.method_10061(var2)),
         Math.max(Math.abs(BlockPos.method_10071(var0) - BlockPos.method_10071(var2)), Math.abs(BlockPos.method_10083(var0) - BlockPos.method_10083(var2)))
      );
   }

   private static boolean qkh(long var0, long var2) {
      return BlockPos.method_10061(var0) == BlockPos.method_10061(var2)
         || BlockPos.method_10071(var0) == BlockPos.method_10071(var2)
         || BlockPos.method_10083(var0) == BlockPos.method_10083(var2);
   }

   private List<qda> qki(World var1, ClientPlayerEntity var2, BlockPos var3) {
      ArrayList var4 = new ArrayList(3);
      Vec3d var5 = var2.method_33571();
      double var6 = (this.qep.nextDouble() - 0.5) * 0.3;
      double var8 = (this.qep.nextDouble() - 0.5) * 0.3;

      for (Direction var13 : Direction.values()) {
         BlockPos var14 = var3.method_10093(var13);
         if (var1.method_8320(var14).method_26218(var1, var14).method_1110()) {
            Vec3d var15 = new Vec3d(var13.method_10148(), var13.method_10164(), var13.method_10165());
            Vec3d var16 = Vec3d.method_24953(var3).method_1019(var15.method_1021(0.5));
            if (!(var5.method_1020(var16).method_1026(var15) <= 0.02)) {
               Vec3d var17 = var13.method_10166() == Axis.field_11048 ? new Vec3d(0.0, 0.0, 1.0) : new Vec3d(1.0, 0.0, 0.0);
               Vec3d var18 = var13.method_10166() == Axis.field_11052 ? new Vec3d(0.0, 0.0, 1.0) : new Vec3d(0.0, 1.0, 0.0);

               for (double[] var22 : qej) {
                  double var23 = var22[0] == 0.0 && var22[1] == 0.0 ? var6 : var22[0];
                  double var25 = var22[0] == 0.0 && var22[1] == 0.0 ? var8 : var22[1];
                  Vec3d var27 = var16.method_1019(var17.method_1021(var23)).method_1019(var18.method_1021(var25));
                  Vec3d var28 = var27.method_1020(var5);
                  double var29 = var28.method_1033();
                  if (!(var29 > 4.4) && !(var29 < 0.3)) {
                     double var31 = Math.sqrt(var28.field_1352 * var28.field_1352 + var28.field_1350 * var28.field_1350);
                     if (!(var31 < 0.25) && qky(var1, var2, var5, var3, var27)) {
                        float var33 = (float)tbp.yawTo(var28.field_1352, var28.field_1350);
                        float var34 = (float)tbp.pitchTo(var28.field_1351, var31);
                        double var35 = Math.hypot(MathHelper.method_15393(var33 - var2.method_36454()), var34 - var2.method_36455());
                        var4.add(new qda(var3.method_10062(), var27, var13.method_10166().ordinal(), this.qkj(var2, var33, var34, var35), var35, var33, var34));
                        break;
                     }
                  }
               }
            }
         }
      }

      return var4;
   }

   private double[] qkj(ClientPlayerEntity var1, float var2, float var3, double var4) {
      float var6 = var1.method_36454();
      float var7 = var1.method_36455();
      double var8 = this.qil();
      if (var4 <= var8 * 0.97) {
         return qln.lookAxes(var6, var7);
      } else {
         double var10 = var8 / var4;
         return qln.lookAxes((float)(var6 + MathHelper.method_15393(var2 - var6) * var10), (float)(var7 + (var3 - var7) * var10));
      }
   }

   private int qkk(World var1, ClientPlayerEntity var2) {
      int var3 = this.qkl();
      int[] var4 = this.qfj.path();
      LongArrayList var5 = new LongArrayList();
      DoubleArrayList var6 = new DoubleArrayList();
      boolean var7 = false;

      label151:
      for (int var8 = this.qfk; var8 < Math.min(var3 - 1, this.qfk + 3); var8++) {
         for (BlockPos var10 : this.qks(
            var4[var8 * 3], var4[var8 * 3 + 1], var4[var8 * 3 + 2], var4[(var8 + 1) * 3], var4[(var8 + 1) * 3 + 1], var4[(var8 + 1) * 3 + 2]
         )) {
            if (qle(var1, var10)) {
               long var11 = var10.method_10063();
               if (this.qfb.getOrDefault(var11, 0) > this.qfi) {
                  var7 |= var8 == this.qfk;
               } else {
                  if (!this.qlc(var1, var10)) {
                     if (var8 == this.qfk) {
                        return -1;
                     }
                     break label151;
                  }

                  if (!var5.contains(var11)) {
                     var5.add(var11);
                     var6.add(var8 == this.qfk ? 1.5 : (var8 == this.qfk + 1 ? 1.0 : 0.6));
                  }
               }
            }
         }
      }

      if (var5.isEmpty()) {
         return var7 ? 2 : 0;
      } else {
         LongOpenHashSet var29 = new LongOpenHashSet();
         var29.add(standing(var1, var2).method_10074().method_10063());

         for (int var30 = this.qfk; var30 < Math.min(var3, this.qfk + 5); var30++) {
            var29.add(BlockPos.method_10064(var4[var30 * 3], var4[var30 * 3 + 1] - 1, var4[var30 * 3 + 2]));
         }

         for (int var31 = 0; var31 < var5.size(); var31++) {
            var29.remove(var5.getLong(var31));
         }

         LongOpenHashSet var32 = new LongOpenHashSet();

         for (int var33 = 0; var33 < var5.size(); var33++) {
            long var35 = var5.getLong(var33);
            var32.add(var35);
            if (this.qgy) {
               var32.add(BlockPos.method_10096(var35, 0, 1, 0));
               var32.add(BlockPos.method_10096(var35, 0, -1, 0));
            }
         }

         Vec3d var34 = var2.method_33571();
         qda var36 = null;
         double var12 = 0.0;
         LongIterator var14 = var32.iterator();

         while (var14.hasNext()) {
            long var15 = var14.nextLong();
            BlockPos var17 = BlockPos.method_10092(var15);
            if (!var29.contains(var15)
               && this.qfb.getOrDefault(var15, 0) <= this.qfi
               && this.qlc(var1, var17)
               && !(Vec3d.method_24953(var17).method_1022(var34) > 4.5)) {
               BlockState var18 = var1.method_8320(var17);
               double var19 = this.qkc(var1, var2, var17, var18);

               for (qda var22 : this.qki(var1, var2, var17)) {
                  double var23 = 0.0;

                  for (int var25 = 0; var25 < var5.size(); var25++) {
                     var23 += var6.getDouble(var25) * this.qes.expect(var5.getLong(var25), var15, var22.axis(), var22.look());
                  }

                  double var39 = 0.0;
                  LongIterator var27 = var29.iterator();

                  while (var27.hasNext()) {
                     var39 += this.qes.expect(var27.nextLong(), var15, var22.axis(), var22.look());
                  }

                  double var40 = (var23 - 2.5 * var39) / (var19 + this.qkd(var22.turn()) + 0.35);
                  if (var40 > var12) {
                     var12 = var40;
                     var36 = var22;
                  }
               }
            }
         }

         if (var36 == null) {
            BlockPos var38 = BlockPos.method_10092(var5.getLong(0));
            this.qkt(var1, var2, var38, false);
            if (this.qfr == null) {
               return -1;
            } else {
               this.qgz = true;
               return 1;
            }
         } else {
            BlockState var37 = var1.method_8320(var36.pos());
            this.qkv(var36.pos(), var37.method_26204(), this.qfe.test(var37), var36.point(), true);
            return 1;
         }
      }
   }

   private int qkl() {
      return this.qfj.path().length / 3;
   }

   private int qkm(BlockPos var1) {
      int var2 = this.qkl();

      for (int var3 = this.qfk; var3 < Math.min(var2, this.qfk + 4); var3++) {
         int var4 = this.qfj.path()[var3 * 3];
         int var5 = this.qfj.path()[var3 * 3 + 1];
         int var6 = this.qfj.path()[var3 * 3 + 2];
         if (var1.method_10263() == var4 && var1.method_10264() == var5 && var1.method_10260() == var6) {
            if (var3 != this.qfk && this.qko(var3) && !this.qkn(var1, var4, var6)) {
               return var3 - 1;
            }

            return var3;
         }

         if (var3 > 0
            && var1.method_10263() == var4
            && var1.method_10260() == var6
            && var1.method_10264() > var5
            && var1.method_10264() <= this.qfj.path()[(var3 - 1) * 3 + 1]) {
            return var3 - 1;
         }
      }

      return -1;
   }

   private boolean qkn(BlockPos var1, int var2, int var3) {
      return this.qgm != null && Math.abs(this.qgm.field_1352 - (var2 + 0.5)) < 0.32 && Math.abs(this.qgm.field_1350 - (var3 + 0.5)) < 0.32;
   }

   private boolean qko(int var1) {
      int var2 = this.qkl();
      if (var1 > 0 && var1 < var2 - 1) {
         int[] var3 = this.qfj.path();
         int var4 = var3[var1 * 3] - var3[(var1 - 1) * 3];
         int var5 = var3[var1 * 3 + 2] - var3[(var1 - 1) * 3 + 2];
         int var6 = var3[(var1 + 1) * 3] - var3[var1 * 3];
         int var7 = var3[(var1 + 1) * 3 + 2] - var3[var1 * 3 + 2];
         return var4 != var6 || var5 != var7;
      } else {
         return false;
      }
   }

   private List<Vec3d> qkp(World var1) {
      ArrayList var2 = new ArrayList();
      if (this.qgp != null && this.qfi < this.qgq) {
         var2.add(this.qgp);
      }

      Box var3 = new Box(this.qfg.minX - 4, this.qfg.minY - 2, this.qfg.minZ - 4, this.qfg.maxX + 5, this.qfg.maxY + 6, this.qfg.maxZ + 5);
      if (this.qhc != null) {
         var3 = var3.method_991(new Box(this.qhc).method_1014(6.0));
      }

      for (ItemEntity var5 : var1.method_8390(ItemEntity.class, var3, var1x -> this.qff.test(var1x.method_6983()))) {
         if (var2.size() < 40) {
            var2.add(var5.method_73189());
         }
      }

      return var2;
   }

   private void qkq(World var1, ClientPlayerEntity var2) {
      this.qfl = false;
      this.qfm = this.qfi + 20;
      this.qfo = false;
      this.qex.clear();
      LongOpenHashSet var3 = new LongOpenHashSet();
      ObjectIterator var4 = this.qfb.long2IntEntrySet().fastIterator();

      while (var4.hasNext()) {
         it.unimi.dsi.fastutil.longs.Long2IntMap.Entry var5 = (it.unimi.dsi.fastutil.longs.Long2IntMap.Entry)var4.next();
         if (var5.getIntValue() <= this.qfi) {
            var4.remove();
         } else {
            this.qex.add(var5.getLongKey());
         }
      }

      var4 = this.qew.long2LongEntrySet().fastIterator();

      while (var4.hasNext()) {
         Entry var16 = (Entry)var4.next();
         if (var16.getLongValue() <= this.qfi) {
            var4.remove();
         } else {
            this.qex.add(var16.getLongKey());
            var3.add(var16.getLongKey());
         }
      }

      if (this.qhc != null) {
         this.qeq.build(var1, var2, this.qfg, this.qfe, this.qev, this.qkp(var1), this.qhc);
         this.qeq.search(standing(var1, var2));
         this.qfj = this.qeq.toward(this.qhc, 3);
         this.qfk = 0;
         this.qgc = Long.MIN_VALUE;
         this.qlj(
            this.qfj == null
               ? a.c(1041995744, "鞀\uee20擠愈焎\uf7a5䶸쑈婘킾坻괒⎜멹〱뚏") + this.qhc.method_23854()
               : a.c(-117214198, "瑱ෑ蜑\u1979鋿ᑔ깗➷맽㍐듋") + this.qfj.path().length / 3 + a.c(-92191881, "䍝㪢끰⸊ꗜ⍻饻პ躚Ѥ") + this.qhc.method_23854()
         );
      } else {
         this.qeq.build(var1, var2, this.qfg, this.qfe, this.qev, this.qkp(var1));
         this.qeq.search(standing(var1, var2));
         Vec3d var15 = var2.method_33571();
         Vec3d var17 = var2.method_5828(1.0F);
         LongArrayList var6 = new LongArrayList();

         for (int var7 = 0; var7 < this.qeq.targetCount(); var7++) {
            long var8 = this.qeq.targetKey(var7);
            if (!var3.contains(var8)) {
               var6.add(var8);
            }
         }

         Vec3d var18 = var2.method_73189();
         this.qer.update(var6, var18.field_1352, var18.field_1351, var18.field_1350);
         this.qfj = null;

         for (int var19 = 0; var19 < 4 && this.qfj == null && !this.qer.isEmpty(); var19++) {
            LongOpenHashSet var9 = this.qer.head();
            this.qfj = this.qeq.best(var15, var17, this.qex, var9);
            if (this.qfj != null) {
               break;
            }

            boolean var10 = true;
            LongIterator var11 = var9.iterator();

            while (var11.hasNext() && var10) {
               var10 = this.qfb.getOrDefault(var11.nextLong(), 0) > this.qfi;
            }

            if (var10) {
               this.qfo = true;
               break;
            }

            this.qlj(a.c(-97302964, "䘥㾉땀⬰ꃶ☘鱑ᗣ设Ā蚚粸\uf23b毘\ue19c杩\udd24勾젅万쟷붽㌑ꢐ⺮ꑪᶍ") + this.qer.headCenter().method_23854());
            var11 = var9.iterator();

            while (var11.hasNext()) {
               long var12 = var11.nextLong();
               if (this.qfb.getOrDefault(var12, 0) <= this.qfi) {
                  this.qlf(BlockPos.method_10092(var12), 600);
                  this.qex.add(var12);
               }
            }

            this.qer.dropHead();
         }

         if (this.qfj == null && !this.qfo) {
            this.qfj = this.qeq.best(var15, var17, this.qex);
         }

         if (this.qfj == null) {
            this.qfm = this.qfi + 4;
         }

         this.qfk = 0;
         if (trace != null) {
            this.qlj(
               this.qfj == null
                  ? a.c(-550309427, "\uf1b6蠛˅鲻ᜢ針⮏ꉿ㰫뛟\u3104")
                     + this.qeq.targetCount()
                     + a.d("⻩圌\uddca䎨졪仙\uf49b絭", 662695574, 420134999)
                     + (this.qfo ? a.b("쳪땗㾗ꆭ⨱겓ᚐ齴Ġ讛\u0c45\uf633磭", 1169476811) : "")
                     + a.c(-481008132, "旔")
                  : a.c(19509695, "뇊졧䊹\udcc7坞")
                     + this.qfj.target().method_23854()
                     + a.c(-106514153, "뤰샏䨝푧徱\ud916挋")
                     + this.qfj.path().length / 3
                     + a.c(-462008687, "亷㝅붚⏷ꠧ⻟")
                     + (int)this.qfj.cost()
                     + a.b("붅쑠亦탄嬆\uddb5柷\uee01瀐", 1665056172)
                     + this.qeq.targetCount()
                     + a.b("\udd4c꒮\u2e7a뀐㯘뵪ݷ", 1148312939)
                     + this.qer.size()
                     + a.b("梜ᅬ鮪֏", 2061134008)
                     + var2.method_24515().method_23854()
            );
         }

         this.qgc = Long.MIN_VALUE;
      }
   }

   private boolean qkr(World var1, BlockPos var2) {
      BlockState var3 = var1.method_8320(var2);
      return !var3.method_26215() && this.qfe.test(var3) && !this.qew.containsKey(var2.method_10063());
   }

   private List<BlockPos> qks(int var1, int var2, int var3, int var4, int var5, int var6) {
      ArrayList var7 = new ArrayList(3);
      if (var4 == var1 && var6 == var3) {
         if (var5 < var2) {
            var7.add(new BlockPos(var1, var2 - 1, var3));
         }

         return var7;
      } else if (var5 > var2) {
         var7.add(new BlockPos(var1, var2 + 2, var3));
         var7.add(new BlockPos(var4, var5 + 1, var6));
         var7.add(new BlockPos(var4, var5, var6));
         return var7;
      } else {
         var7.add(new BlockPos(var4, var2 + 1, var6));
         var7.add(new BlockPos(var4, var2, var6));
         return var7;
      }
   }

   private void qkt(World var1, ClientPlayerEntity var2, BlockPos var3, boolean var4) {
      Vec3d var5 = this.qkx(var1, var2, var3);
      if (var5 == null) {
         BlockPos var6 = qla(var1, var2, var2.method_33571(), var3);
         if (var6 != null && !var6.equals(var3) && this.qlc(var1, var6)) {
            var5 = this.qkx(var1, var2, var6);
            if (var5 != null) {
               this.qku(var6, var1.method_8320(var6).method_26204(), this.qfe.test(var1.method_8320(var6)), var5);
            }
         }
      } else {
         this.qku(var3, var1.method_8320(var3).method_26204(), var4 || this.qfe.test(var1.method_8320(var3)), var5);
      }
   }

   private void qku(BlockPos var1, Block var2, boolean var3, Vec3d var4) {
      this.qkv(var1, var2, var3, var4, false);
   }

   private void qkv(BlockPos var1, Block var2, boolean var3, Vec3d var4, boolean var5) {
      if (!var1.equals(this.qfr)) {
         this.qgz = var5;
         this.qlj(
            a.d("⏦婇킃件씫䏑", -296734278, -1279978952)
               + var1.method_23854()
               + a.c(1884253044, "歕")
               + var2.method_63499().replace(a.d("鷀\ue47f溯\uf0d2笍ﷹ䟩츜偄\udafe崫ꝋ⦏뀹㩸볓", -1621958378, -237470556), "")
               + (var3 ? a.d("탭ꤨ", -1642896548, 1212593043) : "")
         );
         this.qfr = var1.method_10062();
         this.qfs = var2;
         this.qft = var3;
         if (var3) {
            this.qfc.add(this.qfr.method_10063());
         }

         this.qfu = var4;
         this.qfv = new Object();
         this.qfw = this.qfi;
         this.qgk = 0;
         if (!var5) {
            this.qfx = null;
         }
      }
   }

   private static Vec3d qkw(ClientPlayerEntity var0, BlockPos var1) {
      Vec3d var2 = var0.method_33571();
      Vec3d var3 = var0.method_5828(1.0F);
      if (BlockPos.method_49638(var2).equals(var1)) {
         return var2.method_1031(var3.field_1352 * 0.6, -0.3, var3.field_1350 * 0.6);
      } else {
         double var4 = Math.max(0.001, Math.sqrt(var3.field_1352 * var3.field_1352 + var3.field_1350 * var3.field_1350));
         return new Vec3d(
            var1.method_10263() + 0.5 + var3.field_1352 / var4 * 0.25, var1.method_10264() + 1.0, var1.method_10260() + 0.5 + var3.field_1350 / var4 * 0.25
         );
      }
   }

   private Vec3d qkx(World var1, ClientPlayerEntity var2, BlockPos var3) {
      Vec3d var4 = var2.method_33571();
      Vec3d var5 = var2.method_5828(1.0F);
      Vec3d var6 = null;
      double var7 = Double.MAX_VALUE;
      double var9 = (this.qep.nextDouble() - 0.5) * 0.3;
      double var11 = (this.qep.nextDouble() - 0.5) * 0.3;

      for (Direction var16 : Direction.values()) {
         BlockPos var17 = var3.method_10093(var16);
         if (var1.method_8320(var17).method_26218(var1, var17).method_1110()) {
            Vec3d var18 = new Vec3d(var16.method_10148(), var16.method_10164(), var16.method_10165());
            Vec3d var19 = Vec3d.method_24953(var3).method_1019(var18.method_1021(0.5));
            if (!(var4.method_1020(var19).method_1026(var18) <= 0.02)) {
               Vec3d var20 = var16.method_10166() == Axis.field_11048 ? new Vec3d(0.0, 0.0, 1.0) : new Vec3d(1.0, 0.0, 0.0);
               Vec3d var21 = var16.method_10166() == Axis.field_11052 ? new Vec3d(0.0, 0.0, 1.0) : new Vec3d(0.0, 1.0, 0.0);

               for (double[] var25 : qej) {
                  double var26 = var25[0] == 0.0 && var25[1] == 0.0 ? var9 : var25[0];
                  double var28 = var25[0] == 0.0 && var25[1] == 0.0 ? var11 : var25[1];
                  Vec3d var30 = var19.method_1019(var20.method_1021(var26)).method_1019(var21.method_1021(var28));
                  Vec3d var31 = var30.method_1020(var4);
                  double var32 = var31.method_1033();
                  if (!(var32 > 4.4) && !(var32 < 0.3)) {
                     double var34 = Math.sqrt(var31.field_1352 * var31.field_1352 + var31.field_1350 * var31.field_1350);
                     if (!(var34 < 0.25) && qky(var1, var2, var4, var3, var30)) {
                        int var36 = 0;

                        for (double[] var40 : qei) {
                           double var41 = MathHelper.method_15350(var26 + var40[0], -0.47, 0.47);
                           double var43 = MathHelper.method_15350(var28 + var40[1], -0.47, 0.47);
                           if (qky(var1, var2, var4, var3, var19.method_1019(var20.method_1021(var41)).method_1019(var21.method_1021(var43)))) {
                              var36++;
                           }
                        }

                        double var45 = Math.acos(MathHelper.method_15350(var31.method_1021(1.0 / var32).method_1026(var5), -1.0, 1.0));
                        double var46 = var34 / Math.max(0.05, Math.abs(var31.field_1351));
                        double var47 = var45 + (qei.length - var36) * 0.35 + (var46 < 0.4 ? (0.4 - var46) * 2.0 : 0.0);
                        if (var47 < var7) {
                           var7 = var47;
                           var6 = var30;
                        }

                        if (var36 == qei.length) {
                           break;
                        }
                     }
                  }
               }
            }
         }
      }

      return var6;
   }

   private static boolean qky(World var0, ClientPlayerEntity var1, Vec3d var2, BlockPos var3, Vec3d var4) {
      Vec3d var5 = var4.method_1020(var2);
      double var6 = var5.method_1033();
      if (var6 < 1.0E-4) {
         return false;
      } else {
         Vec3d var8 = var4.method_1019(var5.method_1021(0.08 / var6));
         BlockHitResult var9 = var0.method_17742(new RaycastContext(var2, var8, ShapeType.field_17559, FluidHandling.field_1348, var1));
         if (var9.method_17783() == Type.field_1332 && var9.method_17777().equals(var3)) {
            for (Box var11 : qhs) {
               if (var11.method_1006(var2) || var11.method_992(var2, var8).isPresent()) {
                  return false;
               }
            }

            return true;
         } else {
            return false;
         }
      }
   }

   private static void qkz(World var0, ClientPlayerEntity var1) {
      qhs.clear();

      for (Entity var3 : var0.method_8333(var1, var1.method_5829().method_1014(7.0), EntityPredicates.field_52443)) {
         qhs.add(var3.method_5829().method_1014(var3.method_5871()));
      }
   }

   private static BlockPos qla(World var0, ClientPlayerEntity var1, Vec3d var2, BlockPos var3) {
      BlockHitResult var4 = var0.method_17742(new RaycastContext(var2, Vec3d.method_24953(var3), ShapeType.field_17559, FluidHandling.field_1348, var1));
      return var4.method_17783() == Type.field_1332 && !var4.method_17777().equals(var3) ? var4.method_17777() : null;
   }

   static BlockPos standing(World var0, ClientPlayerEntity var1) {
      BlockPos var2 = var1.method_24515();
      return var1.method_23318() - var2.method_10264() >= 0.49 && !var0.method_8320(var2).method_26220(var0, var2).method_1110() ? var2.method_10084() : var2;
   }

   public static BlockPos trapped(World var0, ClientPlayerEntity var1) {
      Box var2 = var1.method_5829().method_1011(0.001);
      if (!var0.method_8587(var1, var2)) {
         BlockPos var7 = BlockPos.method_49638(var1.method_33571());
         if (qlb(var0, var7)) {
            return var7;
         } else {
            BlockPos var4 = BlockPos.method_49637(var1.method_23317(), var2.field_1322, var1.method_23321());
            if (qlb(var0, var4)) {
               return var4;
            } else {
               for (BlockPos var6 : BlockPos.method_10097(
                  BlockPos.method_49637(var2.field_1323, var2.field_1322, var2.field_1321),
                  BlockPos.method_49637(var2.field_1320, var2.field_1325, var2.field_1324)
               )) {
                  if (qlb(var0, var6) && var0.method_8320(var6).method_26220(var0, var6).method_1107().method_996(var6).method_994(var2)) {
                     return var6.method_10062();
                  }
               }

               return null;
            }
         }
      } else {
         BlockPos var3 = BlockPos.method_49637(var1.method_23317(), var2.field_1322, var1.method_23321()).method_10084();
         return var1.method_20448() && qlb(var0, var3) ? var3 : null;
      }
   }

   private static boolean qlb(World var0, BlockPos var1) {
      BlockState var2 = var0.method_8320(var1);
      return !var2.method_26215() && var2.method_26227().method_15769() && var2.method_26214(var0, var1) >= 0.0F && var2.method_26234(var0, var1);
   }

   private boolean qlc(World var1, BlockPos var2) {
      if (this.qfg != null && this.qfg.contains(var2) && !this.qev.contains(var2.method_10063())) {
         BlockState var3 = var1.method_8320(var2);
         return !var3.method_26215() && var3.method_26227().method_15769() && var3.method_26214(var1, var2) >= 0.0F;
      } else {
         return false;
      }
   }

   private static boolean qld(World var0, BlockPos var1) {
      return !var0.method_8320(var1).method_26220(var0, var1).method_1110();
   }

   private static boolean qle(World var0, BlockPos var1) {
      VoxelShape var2 = var0.method_8320(var1).method_26220(var0, var1);
      return !var2.method_1110() && var2.method_1105(Axis.field_11052) > 0.25;
   }

   private void qlf(BlockPos var1, int var2) {
      this.qlj(a.c(-564323151, "᳇敮\uefbf燗祖") + var1.method_23854() + a.d("줨", 1780711411, -1700415750) + var2);
      this.qew.put(var1.method_10063(), this.qfi + var2);
   }

   private void qlg(ClientPlayerEntity var1) {
      Vec3d var2 = var1.method_73189();
      if (this.qfx != null && this.qfr == null && this.qgm != null && var2.method_1025(this.qgm) < 4.0E-4) {
         this.qgn++;
      } else {
         this.qgn = 0;
      }

      this.qgm = var2;
   }

   private void qlh(World var1) {
      Iterator var2 = this.qey.iterator();

      while (var2.hasNext()) {
         qcu var3 = (qcu)var2.next();
         if (this.qfi - var3.tick() > 60) {
            var2.remove();
         } else {
            BlockPos var4 = BlockPos.method_10092(var3.pos());
            if (var1.method_8320(var4).method_26204() != var3.block()) {
               this.qez.remove(var3.pos());
            } else {
               int var5 = this.qez.getOrDefault(var3.pos(), -1);
               if (var5 < 0) {
                  this.qez.put(var3.pos(), this.qfi);
                  int var6 = this.qfa.addTo(var3.pos(), 1) + 1;
                  if (var6 >= 2) {
                     this.qli(var3.pos(), a.b("\ue29e鬬ᇡ辚ы", 2091639535));
                     var2.remove();
                  }
               } else if (this.qfi - var5 > 25) {
                  this.qli(var3.pos(), a.c(8754864, "雅\uef73斵ﯜ瀗\uf6a7"));
                  var2.remove();
               }
            }
         }
      }
   }

   private void qli(long var1, String var3) {
      this.qev.add(var1);
      this.qez.remove(var1);
      this.qfq++;
      this.qfl = true;
      this.qlj(a.b("㡿䇍쬑售", -1674627047) + BlockPos.method_10092(var1).method_23854() + a.b("쉢", 1437909571) + var3);
   }

   private void qlj(String var1) {
      Consumer var2 = trace;
      if (var2 != null) {
         var2.accept(this.qfi + a.d("ሾ", 9087797, -99043030) + var1);
      }
   }
}
