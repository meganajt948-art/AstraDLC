package a;

import flow.dev.a;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents.AfterRender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.math.BlockPos;

public class oqv extends kfe {
   static oqv oqw;
   final vlj oqx = this.add(
      new vlj(
         a.c(-1554001738, "탺ꥶ⎴뷍㘄"),
         vlg.ITEMS,
         a.d("땻쳎䘚\ud860厱픑潑\ue6a7磪\uf215疘迤Ļ领\u12d7鐧\u2e62", -255549696, -1580520953),
         a.c(-1207447122, "퇔ꡡ⊵볏㜞놾\u0bfe興᱅隺ᄷ\ueb4b斔ﰩ癸\uf088䫍씧復\ud9f6倂⩟ꓤ"),
         a.c(2014320639, "ឋ渾\ue4ea窐\uf141矡춡䑗\uda1a僥흢ⴘꏞ㩳뀭㛋貟͓駱ᾚ陛\uec0d抷葉缊"),
         a.c(-1298387162, "⽒囧\udc33䉉즘伸\uf578粎\ue2c3格\uefbbᗁ鬇ʪ裴ฒ둆㮊ꄨ❃꺘퓙婻솹䟗"),
         a.b("ࡔ燡וּ敏\uee9e栾퉾守업伺좲㋌밖▭꿲⤈鍝Ყ蘯\u007f規\uf3ce給\ue6ad", -1232205791),
         a.d("鏵\uea40悔ﻮ甿\uf39f䧟쀩幤풛匕ꥬ➸븁㑓늩ࣗ蜸ᶚ鯋ሠ桸", -1718916658, 1646262848),
         a.c(768483773, "⇰塅튑䳫윺䆚ﯚ爬\uec61暞\ue112᭨閲ఈ虒¬뫹㔹꾋⧡ꀮ\uda77哇켞䥠쎺稸\uf457溱\ue8e0捏鶗"),
         a.c(706481648, "ඇ琲ﻦ悜\ueb4d淭\ud7ad幛쀖䫩쵴㜞맒\u2072ꨩ⳪隕᥍菇ּ豐\uf60b碥\ue364攜\uefc4"),
         a.c(-478939211, "\uf7c8蹽ҩ髓ᄂ鞢ⷢꐔ㩙낦㜪쵒䎐\uda2c偹횛"),
         a.b("꿠확岁싻䤪쾊痊ﰼ扱\ue88e漂镸ᮥ舕ࡑ躍㓭묩↞\ua7dc⸵", -1566855272),
         a.d("★徰핤䬞샏䙯ﰯ痙\ueb94慫\ue6e7Პ鉁௧膧ݛ봜", -336112991, -1909492520),
         a.d("벻씎俚토婱\udcd1暑\uef67焪ﯕ籛蘢ࣶ酏ᬧ鷠➨ꡰ㋋뒁", -1525612503, -1076577045),
         a.d("舭ﮘ煌\uef36擧\ue247堇퇱侼앃䋏뢣㙼꿘▜ꍶᤵ雯\u0c51訆ϋ禧\uf719泓\ueaac恥\ud9df", 1080055806, -1795500635),
         a.b("㺯䜚췎厴\ud865廅\ue485浳\uf33e私﹛б諻ፓ餇Ὸꖠ⩜냒㚎뽮", 1316437719),
         a.d("ﶝ萨\u0efc邆᭗鷷➷깁「뫳㵷윊䧟큨", 1940026685, 286099651)
      )
   );
   final vlq oqy = this.add(new vlq(a.b("礃\u009c詓", -1838319285), 71));
   final vmc oqz = this.add(new vmc(a.b("簻֫轱ᄍ髂", -1273594758), 85.0, 30.0, 300.0, 5.0).suffix(a.c(1541256811, "똄쾫")));
   final vkl ora = this.add(new vkl(a.b("힊긔Ⓞ목ㅨ랜ඌ葶ᨤ邃\u1757", 693688258), true));
   final vkl orb = this.add(new vkl(a.c(-89836003, "㙛俆씆孮탲嘀\uec58斤ﯭ煛\uf68f"), true));
   final vkl orc = this.add(new vkl(a.b("ҩ紹\uf7f1榝\ue245擫", -1553333023), true));
   final vkw ord = this.add(new vkw(a.b("쥙냄㨄ꑬ⾣", 297126161), new vkq(a.b("\u0aca獔年査\uec3f櫜탂夿읳䷛쨐", -428537214), vhz.TRASH, oqv::osi)));
   static final int ore = 1;
   static final int orf = 2;
   static final int org = -45730;
   static final int orh = -15795;
   static final int ori = 1024;
   static final double orj = 160.0;
   static final vdn ork = veo.medium(6.0F);
   static final Map<BlockPos, oqq> orl = new HashMap<>();
   static ClientWorld orm;
   static BlockPos orn;
   static long oro;
   final ArrayDeque<Integer> orp = new ArrayDeque<>();
   boolean orq;
   boolean orr;
   int ors = -1;
   int ort;
   int oru;
   int orv;
   long orw;
   BlockPos orx;
   String ory;
   long orz;
   long osa = -1L;
   final float[] osb = new float[2];
   final float[] osc = new float[4];
   final float[] osd = new float[2];
   public static final int MARK_NONE = 0;
   public static final int MARK_DONE = 1;
   public static final int MARK_LEFT = 2;
   static final int[][] ose = new int[][]{{0, 1}, {2, 3}, {4, 5}, {6, 7}, {0, 2}, {1, 3}, {4, 6}, {5, 7}, {0, 4}, {1, 5}, {2, 6}, {3, 7}};
   final double[][] osf = new double[8][3];

   public oqv() {
      super(
         a.d("དྷ盈ﰖ扱\ue9a1漨하岩십䡍쾉", 290488070, -194744292),
         a.d("ﲩ蔭\u0ff4醋ᩊ鲨⚢꽅\u3100뮶㰷옊䣘텳嬧\uddc7枉\ue81c狦\uf4aa経ܕ覸ሺ鐃ỆꝨ⤻뎁㖓븫䃷쪮単플", 927626731, -1760261835),
         kfa.PLAYER
      );
      oqw = this;
   }

   public static boolean busy() {
      return oqw != null && oqw.orq;
   }

   public static void onUseBlock(BlockPos var0) {
      orn = var0.toImmutable();
      oro = System.currentTimeMillis();
   }

   public static boolean wantsItem(Item var0) {
      return oqw != null && oqw.oqx.contains(Registries.ITEM.getId(var0).toString());
   }

   public static boolean listEmpty() {
      return oqw == null || oqw.oqx.size() == 0;
   }

   public static int markState(ClientWorld var0, BlockPos var1) {
      if (var0 != null && var1 != null && orm == var0) {
         oqq var2 = orl.get(var1);
         return var2 == null ? 0 : var2.state();
      } else {
         return 0;
      }
   }

   public static void markFromOutside(ClientWorld var0, BlockPos var1, boolean var2) {
      if (oqw != null && oqw.orb.get() && var0 != null && var1 != null) {
         if (orm != var0) {
            orl.clear();
            orm = var0;
         }

         if (orl.size() >= 1024) {
            Iterator var3 = orl.keySet().iterator();
            var3.next();
            var3.remove();
         }

         orl.put(var1.toImmutable(), new oqq(var2 ? 2 : 1, System.currentTimeMillis()));
      }
   }

   static void osi() {
      orl.clear();
   }

   public static void attach(Screen var0) {
      if (var0 instanceof HandledScreen && vxl.isStorage(var0)) {
         ScreenEvents.afterRender(var0).register((AfterRender)(var0x, var1, var2, var3, var4) -> {
            if (oqw != null && oqw.isEnabled()) {
               oqw.oso(var1);
            }
         });
      }
   }

   @Override
   protected void onDisable() {
      this.orq = false;
      this.orp.clear();
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      if (var1.world != orm) {
         orm = var1.world;
         orl.clear();
      }

      boolean var2 = var1.currentScreen instanceof HandledScreen && vxl.isStorage(var1.currentScreen);
      boolean var3 = var2 && this.oqy.isBound() && vzz.isDown(var1, this.oqy.get());
      if (var3 && !this.orr && !this.orq && !osq.busy()) {
         this.osk(var1);
      }

      this.orr = var3;
      if (this.orq) {
         if (var1.currentScreen instanceof HandledScreen var4 && var4.getScreenHandler().syncId == this.ors) {
            long var11 = System.currentTimeMillis();
            if (var11 >= this.orw) {
               ScreenHandler var7 = var4.getScreenHandler();
               PlayerInventory var8 = var1.player.getInventory();

               while (!this.orp.isEmpty()) {
                  int var9 = this.orp.poll();
                  Slot var10 = var7.slots.get(var9);
                  if (var10.hasStack() && this.osj(var10)) {
                     if (vxl.hasRoom(var7, var8, var10.getStack())) {
                        vxl.click(var1, var7, var9, 0, SlotActionType.QUICK_MOVE);
                        if (var10.hasStack() && this.osj(var10)) {
                           this.orv++;
                        }

                        this.ort++;
                        this.ory = wap.s(a.b("佷㛥밶≜ꦚ⼼锽ᱛ芓ࡶ辰痋ﬞ抨\ue8f2湄", 1334398763), a.b("╡岈홚䡜쏾䄯ﯫ犍\ue8c5扳\ue5a1Ῑ酶ࢷ芚\u0005", -907861654))
                           + this.ort
                           + wap.s(a.b("偂⦼ꍦ㵑", 1554600038), a.d("判⾍ꕑ㼷", 1201455093, -1192301067))
                           + this.oru;
                        this.orz = var11 + 1500L;
                        this.orw = var11 + this.oqz.getInt();
                        return;
                     }

                     this.orv++;
                  }
               }

               this.osl(var1, var4);
            }
         } else {
            this.orq = false;
         }
      }
   }

   boolean osj(Slot var1) {
      return this.oqx.contains(Registries.ITEM.getId(var1.getStack().getItem()).toString());
   }

   void osk(MinecraftClient var1) {
      HandledScreen var2 = (HandledScreen)var1.currentScreen;
      ScreenHandler var3 = var2.getScreenHandler();
      long var4 = System.currentTimeMillis();
      this.orx = orn != null && var4 - oro < 5000L ? orn : null;
      this.orp.clear();
      this.ort = 0;
      this.orv = 0;
      if (this.oqx.size() == 0) {
         this.osn(
            wap.s(
               a.d("挦᪫遵แ藚ͮ뤧パ껚␢ꏫ姉흛仢쒬䉙\uf81b瞉\ued20次\ue2cf颔ᘯ趵ஃ腏㣭뚴ⱝ꩟↥\udf73啲쳗䪘쀤羶\uf58a獛\ueae1悯ṇ鐝", -2071066928, 2003592585),
               a.d("䦣「뫘ⓐ꽸⧍鞄ᩪ葉\u0efa褪眹\ud9da恟\uee1e梖튣嵶잰䆙젔눲㢔Ꝛ⅚\uabfeቌ鰕۫胍୷\uf1cd羐\ue273怼\uea8f啒\udf54姿쁀", 463319755, 718405473)
            ),
            false
         );
      } else if (!var3.getCursorStack().isEmpty()) {
         this.osn(
            wap.s(a.d("튽ꬩ⇻뿞㑝닰ࢮ脚Ἄ閠ቢ\ue81b暁ｿ甭\uf392䦉완峺\udaee博⤝ꞩ㱹먚ブ褷ܢ鷞ᮗ逽", 183186264, 446685610), a.b("笨ʋ衜ᙘ鷷ᬼꄘ⳼뚼㱲믔䆤콻囃\udce7年\ue05a毪\uf543獫犯胏ฃ閬Ꭳ", 356351762)),
            false
         );
      } else {
         for (Slot var7 : vxl.own(var3, var1.player.getInventory())) {
            if (var7.hasStack() && this.osj(var7)) {
               this.orp.add(var7.id);
            }
         }

         this.oru = this.orp.size();
         if (this.oru == 0) {
            this.ory = wap.s(a.d("幖⟄괗㍽뢻㸝萜ൺ鎲᥍麟擵\uea3e玎栗缢씪䪯퀇嘙\udfbaꗾ⭇나", -251786765, -178235407), a.c(676280743, "㶨䑁캓傕\udb37姦\ue322橄\uf00a竊ﵩݪ観ᑮ騠᳙ꛤ⥇돲㖮"));
            this.orz = var4 + 1800L;
            this.osm(1);
         } else {
            this.orq = true;
            this.ors = var3.syncId;
            this.orw = var4;
         }
      }
   }

   void osl(MinecraftClient var1, HandledScreen<?> var2) {
      this.orq = false;
      long var3 = System.currentTimeMillis();
      if (this.orv > 0) {
         this.ory = wap.s(a.c(634812094, "盼\u0f6e薽ᯗ逑ᚷ겶◐묘\u31e5똿䱍슈孭"), a.d("堪⇃ꬑ㔗뺵㱤蚠࿆閇Ὁ颙抚\uec46痲\uffde礢윁", 66498771, -1906512653))
            + this.orv
            + wap.s(a.d("ᦧ怞\uea8b瓻｣禀쏎䨿푢店", 196401980, -609631567), a.d("틐ꭩ▯믖ぶ능೪蔒ᬹ醋ᘪ\ue842", -108027712, 630878780));
         this.osm(2);
         this.osn(
            wap.s(a.c(-21013775, "媣⌧ꧾ㞁뱝㪢"), a.d("ꄬ\ud8ba剨챨䟏셳笣\uf6cc", -770554322, 69722909))
               + this.ort
               + wap.s(a.c(-2037248044, "\u0ff6癋ﳖ抦\ue93e濝햓屢숿䣃콖㔮믤∇"), a.b("\uf1f8衅ڋ飲ᜰ間⿉\ua636㡫닖㔀쭵䖸", -1236471335))
               + this.orv,
            false
         );
      } else {
         this.ory = wap.s(a.d("\uf4d3赁ޒ駸ሾ钘⺙ꟿ㤷돒㐔칯䂶\ud90c匑", -1878490636, 1029797220), a.d("ꓦ\udd0f埝짛䉹삨穬\uf30a楂\ue3f4搦鸦ႁ褽ͭ膂", -353586963, -406515712)) + this.ort;
         this.osm(1);
         this.osn(wap.s(a.d("\ud98fꀋ⫒뒭㽱릎", -1728190778, -1501020389), a.b("斆ᰐ雂ࣂ荥י뾉㉦", 1918591385)) + this.ort, true);
         if (this.ora.get()) {
            var2.close();
         }
      }

      this.orz = var3 + 2000L;
   }

   void osm(int var1) {
      if (this.orx != null && this.orb.get()) {
         if (orl.size() >= 1024) {
            Iterator var2 = orl.keySet().iterator();
            var2.next();
            var2.remove();
         }

         orl.put(this.orx, new oqq(var1, System.currentTimeMillis()));
      }
   }

   void osn(String var1, boolean var2) {
      if (this.orc.get()) {
         izx.alert(this.getName(), var1, var2 ? vhz.CHECK : vhz.INFO, var2);
      }
   }

   void oso(DrawContext var1) {
      if (this.ory != null && System.currentTimeMillis() <= this.orz) {
         uut.beginFrame();
         float var2 = ork.width(this.ory) + 16.0F;
         float var3 = 13.0F;
         float var4 = (var1.getScaledWindowWidth() - var2) * 0.5F;
         float var5 = 6.0F;
         uut.shadow(var1, var4, var5 + 1.0F, var2, var3, var3 * 0.5F, 6.0F, 1610612736);
         uut.round(var1, var4, var5, var2, var3, var3 * 0.5F, ujt.withAlpha(iov.window, 240));
         uut.outline(var1, var4, var5, var2, var3, var3 * 0.5F, 1.0F, iov.accent(150));
         ork.drawCentered(var1, this.ory, var4 + var2 * 0.5F, ork.centerTop(var5 + var3 * 0.5F), -855307);
      }
   }

   public static void render(DrawContext var0, RenderTickCounter var1) {
      oqv var2 = oqw;
      MinecraftClient var3 = MinecraftClient.getInstance();
      if (var2 != null
         && var2.isEnabled()
         && var2.orb.get()
         && !orl.isEmpty()
         && var3.world != null
         && var3.player != null
         && !var3.options.hudHidden
         && !(var3.currentScreen instanceof hlc)) {
         unf.observe(var0);
         if (unf.frame() != var2.osa) {
            var2.osa = unf.frame();

            usn var4;
            try {
               var4 = usn.capture(var1.getTickProgress(true), var0.getScaledWindowWidth(), var0.getScaledWindowHeight());
            } catch (Throwable var15) {
               return;
            }

            uut.beginFrame();
            uut.beginBatch();

            try {
               long var5 = System.currentTimeMillis();

               for (Entry var8 : orl.entrySet()) {
                  BlockPos var9 = (BlockPos)var8.getKey();
                  if (!(var4.distance(var9.getX() + 0.5, var9.getY() + 0.5, var9.getZ() + 0.5) > 160.0)) {
                     float var10 = Math.min(1.0F, (float)(var5 - ((oqq)var8.getValue()).at()) / 650.0F);
                     int var11 = ((oqq)var8.getValue()).state() == 1 ? -45730 : -15795;
                     var2.osp(var0, var4, var9, var11, var10);
                  }
               }
            } finally {
               uut.endBatch();
            }
         }
      }
   }

   void osp(DrawContext var1, usn var2, BlockPos var3, int var4, float var5) {
      double var6 = 0.06 * (1.0 - var5);
      double var8 = var3.getX() + 0.0625 - var6;
      double var10 = var3.getY() - var6;
      double var12 = var3.getZ() + 0.0625 - var6;
      double var14 = var3.getX() + 0.9375 + var6;
      double var16 = var3.getY() + 0.875 + var6;
      double var18 = var3.getZ() + 0.9375 + var6;
      int var20 = ujt.withAlpha(var4, Math.round(210.0F * var5));
      double[][] var21 = this.osf;

      for (int var22 = 0; var22 < 8; var22++) {
         var21[var22][0] = (var22 & 1) == 0 ? var8 : var14;
         var21[var22][1] = (var22 & 2) == 0 ? var10 : var16;
         var21[var22][2] = (var22 & 4) == 0 ? var12 : var18;
      }

      for (int[] var25 : ose) {
         double[] var26 = var21[var25[0]];
         double[] var27 = var21[var25[1]];
         if (var2.projectSegment(var26[0], var26[1], var26[2], var27[0], var27[1], var27[2], 0.05F, this.osc, this.osd)) {
            uut.line(var1, this.osc[0], this.osc[1], this.osc[2], this.osc[3], 1.1F, var20);
         }
      }

      if (var2.project(var3.getX() + 0.5, var3.getY() + 1.15, var3.getZ() + 0.5, this.osb)) {
         uut.circle(var1, this.osb[0], this.osb[1], 2.2F, ujt.withAlpha(var4, Math.round(230.0F * var5)));
      }
   }
}
