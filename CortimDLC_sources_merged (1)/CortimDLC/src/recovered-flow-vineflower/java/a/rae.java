package a;

import it.unimi.dsi.fastutil.longs.Long2IntOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongIterator;
import it.unimi.dsi.fastutil.longs.LongLinkedOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongListIterator;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.ChunkDataS2CPacket;
import net.minecraft.network.packet.s2c.play.ChunkDeltaUpdateS2CPacket;
import net.minecraft.registry.Registries;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.chunk.ChunkSection;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.chunk.WorldChunk;

public class rae extends kfe {
   private static rae raf;
   private final vlj rag = this.add(
      new vlj(
         "Blocks",
         vlg.BLOCKS,
         "minecraft:diamond_ore",
         "minecraft:deepslate_diamond_ore",
         "minecraft:ancient_debris",
         "minecraft:emerald_ore",
         "minecraft:deepslate_emerald_ore",
         "minecraft:gold_ore",
         "minecraft:deepslate_gold_ore",
         "minecraft:spawner",
         "minecraft:chest",
         "minecraft:trapped_chest",
         "minecraft:ender_chest",
         "minecraft:barrel"
      )
   );
   private final vlv rah = this.add(new vlv("Mode", "Box", "Box", "Corners", "Fill"));
   private final vkl rai = this.add(new vkl("Block colors", true));
   private final vla raj = this.add(new vla("Color", "Theme"));
   private final vmc rak = this.add(new vmc("Range", 48.0, 16.0, 128.0, 8.0).suffix("blocks"));
   private final vmc ral = this.add(new vmc("Fill", 0.18, 0.0, 0.6, 0.02).percent());
   private final vmc ram = this.add(new vmc("Width", 1.0, 0.5, 2.5, 0.1));
   private final vmc ran = this.add(new vmc("Limit", 300.0, 50.0, 1000.0, 50.0));
   private static final long rao = 1500000L;
   private final Long2IntOpenHashMap rap = new Long2IntOpenHashMap();
   private static final int[][] raq = new int[][]{{0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}, {-1, 0, 0}, {1, 0, 0}};
   private final Long2ObjectOpenHashMap<List<qzt>> rar = new Long2ObjectOpenHashMap();
   private final LongLinkedOpenHashSet ras = new LongLinkedOpenHashSet();
   private final LongLinkedOpenHashSet rat = new LongLinkedOpenHashSet();
   private static final Set<Long> rau = ConcurrentHashMap.newKeySet();
   private boolean[] rav = new boolean[0];
   private int raw = -1;
   private ClientWorld rax;
   private final List<qzt> ray = new ArrayList<>();
   private int raz;
   private long rba = -1L;
   private final double[][] rbb = new double[8][3];
   private final float[][] rbc = new float[8][2];
   private final boolean[] rbd = new boolean[8];
   private final boolean[] rbe = new boolean[6];
   private final float[] rbf = new float[4];
   private final float[] rbg = new float[2];
   private static final int[][] rbh = new int[][]{{0, 1, 5, 4}, {2, 6, 7, 3}, {0, 2, 3, 1}, {4, 5, 7, 6}, {0, 4, 6, 2}, {1, 3, 7, 5}};
   private static final int[][] rbi = new int[][]{
      {0, 1, 0, 2},
      {2, 3, 1, 2},
      {4, 5, 0, 3},
      {6, 7, 1, 3},
      {0, 2, 2, 4},
      {1, 3, 2, 5},
      {4, 6, 3, 4},
      {5, 7, 3, 5},
      {0, 4, 0, 4},
      {1, 5, 0, 5},
      {2, 6, 1, 4},
      {3, 7, 1, 5}
   };
   private boolean rbj;

   public rae() {
      super(new String(new char[]{'B', 'l', 'o', 'c', 'k', 'E', 'S', 'P'}), "Chosen blocks seen through walls", kfa.RENDER);
      raf = this;
      wcn.listen(rae::rbm);
      this.raj.visibleWhen(() -> !this.rai.get());
      this.ral.visibleWhen(() -> this.rah.is("Fill") || this.rah.is("Box"));
      this.ram.visibleWhen(() -> !this.rah.is("Fill"));
   }

   private static void rbm(Packet<?> var0) {
      rae var1 = raf;
      if (var1 != null && var1.isEnabled()) {
         if (var0 instanceof BlockUpdateS2CPacket var2) {
            BlockPos var5 = var2.getPos();
            rau.add(ChunkPos.toLong(var5.getX() >> 4, var5.getZ() >> 4));
         } else if (var0 instanceof ChunkDeltaUpdateS2CPacket var3) {
            long[] var6 = new long[]{Long.MIN_VALUE};
            var3.visitUpdates((var1x, var2x) -> {
               long var3x = ChunkPos.toLong(var1x.getX() >> 4, var1x.getZ() >> 4);
               if (var3x != var6[0]) {
                  var6[0] = var3x;
                  rau.add(var3x);
               }
            });
         } else if (var0 instanceof ChunkDataS2CPacket var4) {
            rau.add(ChunkPos.toLong(var4.getChunkX(), var4.getChunkZ()));
         }
      }
   }

   @Override
   protected void onEnable() {
      this.rbn();
   }

   @Override
   protected void onDisable() {
      this.rbn();
   }

   private void rbn() {
      this.rar.clear();
      this.ras.clear();
      this.rat.clear();
      this.ray.clear();
      this.rap.clear();
      rau.clear();
      this.raw = -1;
   }

   private void rbo() {
      boolean[] var1 = new boolean[Registries.BLOCK.size()];

      for (String var3 : this.rag.ids()) {
         Identifier var4 = Identifier.tryParse(var3);
         if (var4 != null && Registries.BLOCK.containsId(var4)) {
            Block var5 = Registries.BLOCK.get(var4);
            int var6 = Registries.BLOCK.getRawId(var5);
            if (var6 >= 0 && var6 < var1.length) {
               var1[var6] = true;
            }
         }
      }

      this.rav = var1;
      this.raw = this.rag.version();
   }

   private boolean rbp(BlockState var1) {
      int var2 = Registries.BLOCK.getRawId(var1.getBlock());
      return var2 >= 0 && var2 < this.rav.length && this.rav[var2];
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      wcn.ensure(var1);
      if (var1.world != this.rax) {
         this.rax = var1.world;
         this.rbn();
      }

      if (this.raw != this.rag.version()) {
         this.rbn();
         this.rbo();
      }

      int var2 = var1.player.getBlockX() >> 4;
      int var3 = var1.player.getBlockZ() >> 4;
      int var4 = (int)Math.ceil(this.rak.get() / 16.0) + 1;
      LongIterator var5 = this.rar.keySet().iterator();

      while (var5.hasNext()) {
         long var6 = var5.nextLong();
         if (Math.abs(ChunkPos.getPackedX(var6) - var2) > var4 + 1 || Math.abs(ChunkPos.getPackedZ(var6) - var3) > var4 + 1) {
            var5.remove();
         }
      }

      LongListIterator var10 = this.rat.iterator();

      while (var10.hasNext()) {
         long var14 = var10.nextLong();
         if (Math.abs(ChunkPos.getPackedX(var14) - var2) > var4 + 1 || Math.abs(ChunkPos.getPackedZ(var14) - var3) > var4 + 1) {
            var10.remove();
         }
      }

      for (Long var15 : rau) {
         rau.remove(var15);
         if (this.rat.remove(var15)) {
            this.ras.add(var15);
         }
      }

      for (int var12 = -var4; var12 <= var4; var12++) {
         for (int var16 = -var4; var16 <= var4; var16++) {
            long var7 = ChunkPos.toLong(var2 + var16, var3 + var12);
            if (!this.rat.contains(var7)) {
               this.ras.add(var7);
            }
         }
      }

      long var13 = System.nanoTime();
      this.rbj = false;

      while (!this.ras.isEmpty() && System.nanoTime() - var13 < 1500000L) {
         long var17 = this.ras.removeFirstLong();
         if (Math.abs(ChunkPos.getPackedX(var17) - var2) <= var4 && Math.abs(ChunkPos.getPackedZ(var17) - var3) <= var4) {
            WorldChunk var9 = var1.world.getChunkManager().getChunk(ChunkPos.getPackedX(var17), ChunkPos.getPackedZ(var17), ChunkStatus.FULL, false);
            if (var9 != null) {
               this.rbq(var1.world, var9, var17);
               this.rat.add(var17);
            }
         }
      }

      if (--this.raz <= 0 || this.rbj) {
         this.raz = 10;
         this.rbs(var1);
      }
   }

   private void rbq(ClientWorld var1, WorldChunk var2, long var3) {
      ArrayList var5 = null;
      ChunkSection[] var6 = var2.getSectionArray();
      int var7 = var2.getBottomSectionCoord();
      int var8 = ChunkPos.getPackedX(var3) << 4;
      int var9 = ChunkPos.getPackedZ(var3) << 4;
      Mutable var10 = new Mutable();

      for (int var11 = 0; var11 < var6.length; var11++) {
         ChunkSection var12 = var6[var11];
         if (var12 != null && !var12.isEmpty() && var12.hasAny(this::rbp)) {
            int var13 = var7 + var11 << 4;

            for (int var14 = 0; var14 < 16; var14++) {
               for (int var15 = 0; var15 < 16; var15++) {
                  for (int var16 = 0; var16 < 16; var16++) {
                     BlockState var17 = var12.getBlockState(var16, var14, var15);
                     if (this.rbp(var17)) {
                        var10.set(var8 + var16, var13 + var14, var9 + var15);
                        if (var5 == null) {
                           var5 = new ArrayList();
                        }

                        var5.add(this.rbr(var1, var10, var17));
                     }
                  }
               }
            }
         }
      }

      if (var5 == null) {
         this.rbj = this.rbj | this.rar.remove(var3) != null;
      } else {
         this.rar.put(var3, var5);
         this.rbj = true;
      }
   }

   private qzt rbr(ClientWorld var1, BlockPos var2, BlockState var3) {
      Box var4 = new Box(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);

      try {
         VoxelShape var5 = var3.getOutlineShape(var1, var2);
         if (!var5.isEmpty()) {
            var4 = var5.getBoundingBox();
         }
      } catch (RuntimeException var6) {
      }

      return new qzt(var2.asLong(), this.rbu(var3), (float)var4.minX, (float)var4.minY, (float)var4.minZ, (float)var4.maxX, (float)var4.maxY, (float)var4.maxZ);
   }

   private void rbs(MinecraftClient var1) {
      this.ray.clear();
      double var2 = this.rak.get();
      double var4 = var2 * var2;
      Vec3d var6 = var1.player.getEyePos();
      ArrayList var7 = new ArrayList();
      ObjectIterator var8 = this.rar.values().iterator();

      while (var8.hasNext()) {
         List var9 = (List)var8.next();

         for (qzt var11 : var9) {
            double var12 = BlockPos.unpackLongX(var11.qzu) + 0.5 - var6.x;
            double var14 = BlockPos.unpackLongY(var11.qzu) + 0.5 - var6.y;
            double var16 = BlockPos.unpackLongZ(var11.qzu) + 0.5 - var6.z;
            if (var12 * var12 + var14 * var14 + var16 * var16 <= var4) {
               var7.add(var11);
            }
         }
      }

      int var19 = this.ran.getInt();
      if (var7.size() > var19) {
         double[] var20 = new double[var7.size()];
         Integer[] var22 = new Integer[var7.size()];

         for (int var24 = 0; var24 < var7.size(); var24++) {
            qzt var26 = (qzt)var7.get(var24);
            double var13 = BlockPos.unpackLongX(var26.qzu) - var6.x;
            double var15 = BlockPos.unpackLongY(var26.qzu) - var6.y;
            double var17 = BlockPos.unpackLongZ(var26.qzu) - var6.z;
            var20[var24] = var13 * var13 + var15 * var15 + var17 * var17;
            var22[var24] = var24;
         }

         Arrays.sort(var22, (var1x, var2x) -> Double.compare(var20[var1x], var20[var2x]));

         for (int var25 = 0; var25 < var19; var25++) {
            this.ray.add((qzt)var7.get(var22[var25]));
         }
      } else {
         this.ray.addAll(var7);
      }

      this.rap.clear();

      for (qzt var23 : this.ray) {
         if (var23.fullCube()) {
            this.rap.put(var23.qzu, var23.qzv);
         }
      }
   }

   private boolean rbt(long var1, int var3, int var4, int var5, int var6, boolean var7) {
      long var8 = BlockPos.add(var1, var3, var4, var5);
      return this.rap.containsKey(var8) && (var7 || this.rap.get(var8) == var6);
   }

   private int rbu(BlockState var1) {
      Block var2 = var1.getBlock();
      if (var2 instanceof ShulkerBoxBlock var6) {
         DyeColor var7 = var6.getColor();
         return var7 != null ? 0xFF000000 | var7.getEntityColor() : -4944682;
      } else {
         String var3 = Registries.BLOCK.getId(var2).getPath();
         if (var3.contains("diamond")) {
            return -11541505;
         } else if (var3.contains("emerald")) {
            return -12723068;
         } else if (var3.contains("gold") || var3.equals("gilded_blackstone")) {
            return -11443;
         } else if (var3.contains("ancient_debris") || var3.contains("netherite")) {
            return -4158870;
         } else if (var3.contains("iron")) {
            return -1521234;
         } else if (var3.contains("redstone")) {
            return -45747;
         } else if (var3.contains("lapis")) {
            return -11699201;
         } else if (var3.contains("copper")) {
            return -26022;
         } else if (var3.contains("coal")) {
            return -7697770;
         } else if (var3.contains("quartz")) {
            return -856604;
         } else if (var3.contains("spawner")) {
            return -41334;
         } else if (var3.equals("ender_chest")) {
            return -5018625;
         } else if (var3.contains("chest") || var3.contains("barrel")) {
            return -1529776;
         } else if (!var3.contains("beacon") && !var3.contains("conduit")) {
            int var4 = var2.getDefaultMapColor().color;
            int var5 = 0xFF000000 | var4;
            return ujt.luminance(var5) < 0.4F ? ujt.lerp(var5, -1, 0.45F) : var5;
         } else {
            return -8587265;
         }
      }
   }

   public static void render(DrawContext var0, RenderTickCounter var1) {
      rae var2 = raf;
      MinecraftClient var3 = MinecraftClient.getInstance();
      if (var2 != null
         && var2.isEnabled()
         && !var2.ray.isEmpty()
         && var3.world != null
         && var3.player != null
         && !var3.options.hudHidden
         && !(var3.currentScreen instanceof hlc)) {
         unf.observe(var0);
         if (unf.frame() != var2.rba) {
            var2.rba = unf.frame();

            usn var4;
            try {
               var4 = usn.capture(var1.getTickProgress(true), var0.getScaledWindowWidth(), var0.getScaledWindowHeight());
            } catch (Throwable var34) {
               return;
            }

            uut.beginFrame();
            Vec3d var5 = var4.camera();
            int var6 = var2.raj.color() | 0xFF000000;
            boolean var7 = var2.rah.is("Fill");
            boolean var8 = var2.rah.is("Corners");
            float var9 = (float)var2.ral.get();
            float var10 = (float)var2.ram.get();
            boolean var11 = !var2.rai.get();
            float var12 = var4.width();
            float var13 = var4.height();
            float[] var14 = var2.rbg;
            uut.beginBatch();

            try {
               for (qzt var16 : var2.ray) {
                  double var17 = BlockPos.unpackLongX(var16.qzu);
                  double var19 = BlockPos.unpackLongY(var16.qzu);
                  double var21 = BlockPos.unpackLongZ(var16.qzu);
                  double var23 = var17 + (var16.qzw + var16.qzz) * 0.5;
                  double var25 = var19 + (var16.qzx + var16.raa) * 0.5;
                  double var27 = var21 + (var16.qzy + var16.rab) * 0.5;
                  float var29 = var4.depth(var23, var25, var27);
                  if (!(var29 < -1.0F)) {
                     if (var29 > 2.0F && var4.project(var23, var25, var27, var14)) {
                        float var30 = var4.unitsPerBlock(var23, var25, var27) * 0.9F;
                        if (var14[0] < -var30 || var14[1] < -var30 || var14[0] > var12 + var30 || var14[1] > var13 + var30) {
                           continue;
                        }
                     }

                     int var36 = var11 ? var6 : var16.qzv;
                     var2.rbv(var0, var4, var5, var16, var17, var19, var21, var36, var7, var8, var9, var10, var11);
                  }
               }
            } finally {
               uut.endBatch();
            }
         }
      }
   }

   private void rbv(
      DrawContext var1,
      usn var2,
      Vec3d var3,
      qzt var4,
      double var5,
      double var7,
      double var9,
      int var11,
      boolean var12,
      boolean var13,
      float var14,
      float var15,
      boolean var16
   ) {
      boolean var17 = var4.fullCube();
      int var18 = 0;
      if (var17) {
         for (int var19 = 0; var19 < 6; var19++) {
            int[] var20 = raq[var19];
            if (this.rbt(var4.qzu, var20[0], var20[1], var20[2], var4.qzv, var16)) {
               var18 |= 1 << var19;
            }
         }
      }

      double var40 = 0.003;
      double var21 = var5 + var4.qzw - var40;
      double var23 = var7 + var4.qzx - var40;
      double var25 = var9 + var4.qzy - var40;
      double var27 = var5 + var4.qzz + var40;
      double var29 = var7 + var4.raa + var40;
      double var31 = var9 + var4.rab + var40;

      for (int var33 = 0; var33 < 8; var33++) {
         this.rbb[var33][0] = (var33 & 1) == 0 ? var21 : var27;
         this.rbb[var33][1] = (var33 & 2) == 0 ? var23 : var29;
         this.rbb[var33][2] = (var33 & 4) == 0 ? var25 : var31;
         this.rbd[var33] = var2.depth(this.rbb[var33][0], this.rbb[var33][1], this.rbb[var33][2]) > 0.05F
            && var2.project(this.rbb[var33][0], this.rbb[var33][1], this.rbb[var33][2], this.rbc[var33]);
      }

      this.rbe[0] = var3.y < var23;
      this.rbe[1] = var3.y > var29;
      this.rbe[2] = var3.z < var25;
      this.rbe[3] = var3.z > var31;
      this.rbe[4] = var3.x < var21;
      this.rbe[5] = var3.x > var27;
      if ((var12 || !var13) && var14 > 0.005F) {
         int var41 = ujt.withAlpha(var11, Math.round(255.0F * var14));

         for (int var34 = 0; var34 < 6; var34++) {
            int[] var35 = rbh[var34];
            if (this.rbe[var34] && (var18 & 1 << var34) == 0 && this.rbd[var35[0]] && this.rbd[var35[1]] && this.rbd[var35[2]] && this.rbd[var35[3]]) {
               uut.quad(
                  var1,
                  this.rbc[var35[0]][0],
                  this.rbc[var35[0]][1],
                  var41,
                  this.rbc[var35[1]][0],
                  this.rbc[var35[1]][1],
                  var41,
                  this.rbc[var35[2]][0],
                  this.rbc[var35[2]][1],
                  var41,
                  this.rbc[var35[3]][0],
                  this.rbc[var35[3]][1],
                  var41
               );
            }
         }
      }

      if (!var12) {
         int var42 = ujt.withAlpha(var11, 230);

         for (int[] var37 : rbi) {
            if (var17 && var18 != 0 ? this.rbw(var4, var37[2], var37[3], var18, var16) : this.rbe[var37[2]] || this.rbe[var37[3]]) {
               double[] var38 = this.rbb[var37[0]];
               double[] var39 = this.rbb[var37[1]];
               if (var13) {
                  this.rbx(var1, var2, var38, var39, 0.0, 0.25, var15, var42);
                  this.rbx(var1, var2, var38, var39, 0.75, 1.0, var15, var42);
               } else if (this.rbd[var37[0]] && this.rbd[var37[1]]) {
                  uut.line(var1, this.rbc[var37[0]][0], this.rbc[var37[0]][1], this.rbc[var37[1]][0], this.rbc[var37[1]][1], var15, var42);
               } else {
                  this.rbx(var1, var2, var38, var39, 0.0, 1.0, var15, var42);
               }
            }
         }
      }
   }

   private boolean rbw(qzt var1, int var2, int var3, int var4, boolean var5) {
      boolean var6 = (var4 & 1 << var2) != 0;
      boolean var7 = (var4 & 1 << var3) != 0;
      int[] var8 = raq[var2];
      int[] var9 = raq[var3];
      boolean var10 = this.rbt(var1.qzu, var8[0] + var9[0], var8[1] + var9[1], var8[2] + var9[2], var1.qzv, var5);
      if (!var6 && !var7 && !var10) {
         return this.rbe[var2] || this.rbe[var3];
      }

      if ((var6 == var7 || var10) && (!var6 || !var7 || !var10)) {
         long var11 = var1.qzu;
         if (var6) {
            var11 = Math.min(var11, BlockPos.add(var1.qzu, var8[0], var8[1], var8[2]));
         }

         if (var7) {
            var11 = Math.min(var11, BlockPos.add(var1.qzu, var9[0], var9[1], var9[2]));
         }

         if (var10) {
            var11 = Math.min(var11, BlockPos.add(var1.qzu, var8[0] + var9[0], var8[1] + var9[1], var8[2] + var9[2]));
         }

         return var11 == var1.qzu;
      } else {
         return false;
      }
   }

   private void rbx(DrawContext var1, usn var2, double[] var3, double[] var4, double var5, double var7, float var9, int var10) {
      if (var2.projectSegment(
         var3[0] + (var4[0] - var3[0]) * var5,
         var3[1] + (var4[1] - var3[1]) * var5,
         var3[2] + (var4[2] - var3[2]) * var5,
         var3[0] + (var4[0] - var3[0]) * var7,
         var3[1] + (var4[1] - var3[1]) * var7,
         var3[2] + (var4[2] - var3[2]) * var7,
         0.05F,
         this.rbf,
         this.rbg
      )) {
         uut.line(var1, this.rbf[0], this.rbf[1], this.rbf[2], this.rbf[3], var9, var10);
      }
   }
}
