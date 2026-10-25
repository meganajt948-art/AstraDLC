package a;

import com.mojang.blaze3d.textures.GpuTextureView;
import flow.dev.a;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.BossBarHud;
import net.minecraft.client.gui.hud.ClientBossBar;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.boss.BossBar.Color;
import net.minecraft.entity.boss.BossBar.Style;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.ChunkDeltaUpdateS2CPacket;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;

public class pbz extends kfe {
   private static final Set<Block> pca = Set.of(
      Blocks.field_10153,
      Blocks.field_10614,
      Blocks.field_10480,
      Blocks.field_10505,
      Blocks.field_10462,
      Blocks.field_10266,
      Blocks.field_23880,
      Blocks.field_10006,
      Blocks.field_10295,
      Blocks.field_10541,
      Blocks.field_23152,
      Blocks.field_22108,
      Blocks.field_10087,
      Blocks.field_10458,
      Blocks.field_23151
   );
   private static final int pcb = 2;
   private static final int pcc = 2;
   private static final long pcd = 200L;
   private static final long pce = 400L;
   private static final vdn pcf = veo.semibold(6.4F);
   private static final float pcg = 13.0F;
   private static final float pch = 4.5F;
   private static final float pci = 9.0F;
   private static final float pcj = 3.5F;
   private static pbz pck;
   private static Field pcl;
   private static boolean pcm;
   private final Set<BlockPos> pcn = ConcurrentHashMap.newKeySet();
   private final Map<BlockPos, Integer> pco = new HashMap<>();
   private final List<pbw> pcp = new ArrayList<>();
   private volatile boolean pcq;
   private ClientWorld pcr;
   private int pcs;

   public pbz() {
      super(a.c(-772048336, "穩Ͽ褪\u175c鲝ᨻꁩ⦟럗㵰"), a.c(456087106, "嘊⾆ꕑ㬨냨㙘豘צ鮠ᄂ集泥\ue266篑\uf191睱촽䊿\ud84d帓ퟮ귻⌘룕㺧둤ැ莆"), kfa.PLAYER);
      pck = this;
      wcn.listen(this::pcw);
   }

   @Override
   protected void onEnable() {
      this.pcr = this.mc.field_1687;
      this.pcq = true;
      if (this.mc.field_1687 != null) {
         wcn.ensure(this.mc);
      }
   }

   @Override
   protected void onDisable() {
      this.pcq = false;
      this.pcv();
      this.pcn.clear();
   }

   private void pcv() {
      for (pbw var2 : this.pcp) {
         pdd(var2);
      }

      this.pcp.clear();
      this.pco.clear();
   }

   private void pcw(Packet<?> var1) {
      if (this.pcq) {
         if (var1 instanceof ChunkDeltaUpdateS2CPacket var2) {
            var2.method_30621(this::pcx);
         } else if (var1 instanceof BlockUpdateS2CPacket var3) {
            this.pcx(var3.method_11309(), var3.method_11308());
         }
      }
   }

   private void pcx(BlockPos var1, BlockState var2) {
      ClientWorld var3 = this.mc.field_1687;
      if (var3 != null && pca.contains(var2.method_26204())) {
         if (var3.method_8393(var1.method_10263() >> 4, var1.method_10260() >> 4) && !pca.contains(var3.method_8320(var1).method_26204())) {
            this.pcn.add(var1.method_10062());
         }
      }
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      wcn.ensure(var1);
      this.pcs++;
      if (var1.field_1687 != this.pcr) {
         this.pcv();
         this.pcr = var1.field_1687;
      }

      Iterator var2 = this.pcn.iterator();

      while (var2.hasNext()) {
         this.pco.put((BlockPos)var2.next(), this.pcs);
         var2.remove();
      }

      if (!this.pco.isEmpty()) {
         this.pcy();
      }

      this.pda(var1);
   }

   private void pcy() {
      HashSet var1 = new HashSet<>(this.pco.keySet());
      ArrayDeque var2 = new ArrayDeque();

      while (!var1.isEmpty()) {
         BlockPos var3 = (BlockPos)var1.iterator().next();
         var1.remove(var3);
         var2.add(var3);
         ArrayList var4 = new ArrayList();
         int var5 = Integer.MAX_VALUE;
         int var6 = Integer.MIN_VALUE;

         while (!var2.isEmpty()) {
            BlockPos var7 = (BlockPos)var2.poll();
            var4.add(var7);
            int var8 = this.pco.get(var7);
            var5 = Math.min(var5, var8);
            var6 = Math.max(var6, var8);

            for (int var9 = -2; var9 <= 2; var9++) {
               for (int var10 = -2; var10 <= 2; var10++) {
                  for (int var11 = -2; var11 <= 2; var11++) {
                     BlockPos var12 = var7.method_10069(var9, var10, var11);
                     if (var1.remove(var12)) {
                        var2.add(var12);
                     }
                  }
               }
            }
         }

         if (this.pcs - var6 >= 2) {
            for (BlockPos var14 : var4) {
               this.pco.remove(var14);
            }

            this.pcz(var4, System.currentTimeMillis() - (this.pcs - var5) * 50L);
         }
      }
   }

   private void pcz(List<BlockPos> var1, long var2) {
      BlockBox var4 = (BlockBox)BlockBox.method_35411(var1).orElse(null);
      if (var4 != null) {
         for (pbs var8 : pbs.values()) {
            if (var8.matches(var4, var1)) {
               this.pcp.removeIf(var1x -> {
                  if (var1x.box.equals(var4)) {
                     pdd(var1x);
                     return true;
                  } else {
                     return false;
                  }
               });
               this.pcp.add(new pbw(var8, var4, var1, var2));
               return;
            }
         }
      }
   }

   private void pda(MinecraftClient var1) {
      long var2 = System.currentTimeMillis();
      BlockPos var4 = var1.field_1724.method_24515();
      Iterator var5 = this.pcp.iterator();

      while (var5.hasNext()) {
         pbw var6 = (pbw)var5.next();
         if (var6.deadAt == 0L && pdb(var1.field_1687, var6)) {
            var6.deadAt = var2;
         }

         if (var6.left(var2) > 0L && (var6.deadAt == 0L || var2 - var6.deadAt <= 400L)) {
            if (var6.deadAt == 0L && var6.box.method_14662(var4)) {
               pdc(var6, var2);
            } else {
               pdd(var6);
            }
         } else {
            pdd(var6);
            var5.remove();
         }
      }
   }

   private static boolean pdb(ClientWorld var0, pbw var1) {
      int var2 = 0;

      for (BlockPos var4 : var1.blocks) {
         if (!var0.method_8393(var4.method_10263() >> 4, var4.method_10260() >> 4)) {
            return false;
         }

         if (!pca.contains(var0.method_8320(var4).method_26204())) {
            var2++;
         }
      }

      return var2 * 2 > var1.blocks.size();
   }

   private static void pdc(pbw var0, long var1) {
      Map var3 = pde();
      if (var3 != null) {
         long var4 = Math.max(0L, var0.left(var1));
         MutableText var6 = Text.method_43470(
            wap.t(var0.kind.title) + a.c(131093714, "哱൴ꞓ") + pdf(var4) + wap.s(a.b("3科", -857604079), a.c(1154097681, "∵忥핂䬼"))
         );
         float var7 = Math.min(1.0F, (float)var4 / (float)var0.kind.duration);
         if (var0.bar == null) {
            var0.bar = new ClientBossBar(UUID.randomUUID(), var6, var7, Color.field_5786, Style.field_5795, false, false, false);
         } else {
            var0.bar.method_5413(var6);
            var0.bar.method_5408(var7);
         }

         var3.putIfAbsent(var0.bar.method_5407(), var0.bar);
      }
   }

   private static void pdd(pbw var0) {
      if (var0.bar != null) {
         Map var1 = pde();
         if (var1 != null) {
            var1.remove(var0.bar.method_5407());
         }

         var0.bar = null;
      }
   }

   private static Map<UUID, ClientBossBar> pde() {
      MinecraftClient var0 = MinecraftClient.method_1551();
      if (!pcm && var0.field_1705 != null) {
         try {
            if (pcl == null) {
               for (Field var4 : BossBarHud.class.getDeclaredFields()) {
                  if (!Modifier.isStatic(var4.getModifiers()) && Map.class.isAssignableFrom(var4.getType())) {
                     var4.setAccessible(true);
                     pcl = var4;
                     break;
                  }
               }

               if (pcl == null) {
                  throw new IllegalStateException(a.b("｢蛞\u0c11鉠᧤鼗╇겥㊨롔㾋엫䭬튓壁\ude2b搰\ueba7焝\uf756纺ӡ", 1754070806));
               }
            }

            return (Map<UUID, ClientBossBar>)pcl.get(var0.field_1705.method_1740());
         } catch (Throwable var5) {
            pcm = true;
            System.out.println(a.c(1286892570, "汯ᗓ鼜ŭ諩చ뙊㾨ꇶ⬔겒囸\ud820䆆쯂䴻\uf771碭\ue21d摂\uedbc鞲ᤛ") + var5);
            return null;
         }
      } else {
         return null;
      }
   }

   private static String pdf(long var0) {
      long var2 = Math.round(var0 / 100.0);
      return var2 / 10L + a.c(-1547351786, "䤹") + var2 % 10L;
   }

   public static pbz get() {
      return pck;
   }

   public int count() {
      return this.pcp.size();
   }

   public String describe() {
      StringBuilder var1 = new StringBuilder();
      long var2 = System.currentTimeMillis();

      for (pbw var5 : this.pcp) {
         var1.append(var5.kind.name())
            .append('@')
            .append(var5.box.method_22874().method_23854())
            .append(' ')
            .append(pdf(Math.max(0L, var5.left(var2))))
            .append(var5.bar != null ? a.b("䗦㰕뛅⢧", -488553022) : "")
            .append(var5.deadAt != 0L ? a.d("棗ᄢ鯰օ蹗", -1429805639, -1315271349) : "")
            .append(a.c(-1740534363, "趜\uf436"));
      }

      return var1.toString();
   }

   public static void render(DrawContext var0, RenderTickCounter var1) {
      pbz var2 = pck;
      MinecraftClient var3 = MinecraftClient.method_1551();
      if (var2 != null && var2.isEnabled() && !var2.pcp.isEmpty() && var3.field_1687 != null && var3.field_1724 != null && !var3.field_1690.field_1842) {
         unf.observe(var0);
         float var4 = unf.delta();
         iov.update(var4 * (float)iov.ANIMATION.get());
         float var5 = var0.method_51421();
         float var6 = var0.method_51443();

         usn var7;
         try {
            var7 = usn.capture(var1.method_60637(true), var5, var6);
         } catch (Throwable var18) {
            return;
         }

         uut.beginFrame();
         GpuTextureView var8 = null;
         if (izx.BACKGROUND.is(a.d("新ᰪ雴\u0897荀", -1974128899, -433304817)) && hyv.ENABLED.get() && uij.HUD.capture(var0, hyv.FROST.getInt(), null)) {
            var8 = uij.HUD.result(var0);
         }

         long var9 = System.currentTimeMillis();
         ArrayList var11 = new ArrayList<>(var2.pcp);
         var11.sort((var1x, var2x) -> Double.compare(pdg(var7, var2x), pdg(var7, var1x)));
         float var12 = Math.max(1, var3.method_22683().method_4495());
         float[] var13 = new float[2];

         for (pbw var15 : var11) {
            float var16 = var15.shown.step(var15.deadAt == 0L && var15.left(var9) > 200L, var4);
            BlockPos var17 = var15.box.method_22874();
            if (!(var16 < 0.01F) && var7.project(var17.method_10263() + 0.5, var17.method_10264() + 0.5, var17.method_10260() + 0.5, var13)) {
               pdh(var0, var15, Math.round(var13[0] * var12) / var12, Math.round(var13[1] * var12) / var12, var16, var9, var8);
            }
         }
      }
   }

   private static double pdg(usn var0, pbw var1) {
      BlockPos var2 = var1.box.method_22874();
      return var0.distance(var2.method_10263() + 0.5, var2.method_10264() + 0.5, var2.method_10260() + 0.5);
   }

   private static void pdh(DrawContext var0, pbw var1, float var2, float var3, float var4, long var5, GpuTextureView var7) {
      long var8 = Math.max(0L, var1.left(var5));
      String var10 = pdf(var8);
      float var11 = 17.0F + pcf.width(var10) + 4.5F;
      float var12 = iov.r(4.0F);
      float var13 = vcq.outCubic(var4);
      float var14 = 0.8F + 0.2F * var13;
      var0.method_51448().pushMatrix();
      var0.method_51448().translate(var2, var3);
      var0.method_51448().scale(var14, var14);
      var0.method_51448().translate(-var11 * 0.5F, -6.5F);
      uut.pushAlpha(var4);

      try {
         float var15 = (float)izx.OPACITY.get();
         int var16 = ujt.withAlpha(iov.window, Math.round(255.0F * Math.min(1.0F, var15 * 0.55F)));
         if (var7 == null || !uut.glass(var0, var7, 0.0F, 0.0F, var11, 13.0F, var12, var16, 1.0F)) {
            uut.round(var0, 0.0F, 0.0F, var11, 13.0F, var12, ujt.withAlpha(iov.window, Math.round(255.0F * var15 * 0.6F)));
         }

         uut.outline(var0, 0.0F, 0.0F, var11, 13.0F, var12, 1.0F, ujt.withAlpha(16777215, Math.round(14.0F + 16.0F * iov.lightness())));
         float var17 = 6.5F;
         float var18 = 0.5625F * var13;
         var0.method_51448().pushMatrix();
         var0.method_51448().translate(9.0F, var17);
         var0.method_51448().scale(var18, var18);
         var0.method_51427(var1.icon, -8, -8);
         var0.method_51448().popMatrix();
         pcf.draw(var0, var10, 17.0F, pcf.centerTop(var17), iov.text);
         float var19 = var11 - var12 * 2.0F;
         float var20 = Math.min(1.0F, (float)var8 / (float)var1.kind.duration);
         uut.round(var0, var12, 10.8F, var19, 1.2F, 0.6F, ujt.withAlpha(16777215, 30));
         uut.gradientH(var0, var12, 10.8F, Math.max(1.2F, var19 * var20), 1.2F, 0.6F, iov.accent(), iov.accent2());
      } finally {
         uut.popAlpha();
         var0.method_51448().popMatrix();
      }
   }
}
