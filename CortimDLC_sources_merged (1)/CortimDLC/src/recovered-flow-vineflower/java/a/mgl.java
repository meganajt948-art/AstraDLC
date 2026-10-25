package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents.AfterRender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.GenericContainerScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

public class mgl extends kfe {
   private static final String[] mgm = mil(
      a.b("긹힊崧썟䣿츷", -1699894658),
      a.d("Ⰸ喲\udf6c䄋쫛", 1549428332, -1373943294),
      a.c(-501856924, "䅕㣡눽ⱋꞔ⅚魻ዺ販"),
      a.d("Z秬\uf327浅\ue699怲\uda7a厖췂", 1940162698, 945326256),
      a.b("䯕㉫룁⛍괐", -1503834143),
      a.c(1333841394, "춖됤㻤ꂕ⭕귭"),
      a.d("\uf61e辴պ鬒Ⴢ陽ⰹ", 1879978402, -263665720),
      a.b("苖ײַ燇\uefb7摯\ue2ab", -1705212264)
   );
   private static final String[] mgn = mil(
      a.d("\u20cc夎펤䶩였䂷\ufae7", 73553294, -882282123),
      a.d("\udb51ꋴ⠱뙗㶝묪Ÿ", 928332889, 1487988590),
      a.d("玱\u0a0b肮Ờ锏", -1030424861, -908164841),
      a.c(-625441604, "蓗ﵪ瞪\ue9c2戛\ue4bb"),
      a.c(341076834, "潚ᛪ鱉Ɉ觪༠땶㲆ꋓ")
   );
   private static final String[] mgo = mil(
      a.d("\u1f7e曊\uec69爕劉罵씥䲥튆", -1531460758, -2086283176),
      a.b("ﳑ蕭ྐྵ量\u1a1c", -1611073303),
      a.b("塌⇰ꬩ㔭뺏㠿", -1824695176),
      a.d("⸙垥\udd7c䍸좾乪", -700579097, 2006198474),
      a.c(-236048234, "㒬䴜쟉姁퉭"),
      a.d("䘱㾃땒⭓ꂉ☽鰐", 1052481280, -1937123977),
      a.b("⺛圥\uddfa䎈졓仨\uf4c1紾", 75377325),
      a.c(-89106608, "卣⫘ꁹ㹿떮㌒褿¶黩"),
      a.c(-1864491677, "ᥑ惥\uea4f瑄￭礠썿䫸퓙帟"),
      a.c(1898666972, "忨♕겇㊉뤠㿮")
   );
   private static final String[] mgp = mil(
      a.c(463964444, "败\uf4eb繆\ue03d毮\ued5d"),
      a.d("\ue991遙᪉蒏བྷ", 1141578203, 1656353911),
      a.b("뚂콊䖚\udbf8偄", 648655551),
      a.c(805961385, "瞧茥৽鞈ᱞ髡"),
      a.b("䎿㩱낡⺢ꕾ⏊駦ယ", -1654044791),
      a.b("뮟숸䣢횓嵍\udbeb", -1393574934),
      a.d("螃︯瓴\uea9c慐\ue7f6", -1780167643, -2121970747)
   );
   private static final String[] mgq = mil(
      a.d("碇ń询ᗦ鸳", -1804951348, -1844126711),
      a.c(2086678681, "㓛䴞쟂"),
      a.d("ꙏ\udffa唬", -1459795198, 2059266418),
      a.c(-1412124009, "뛓켕䖷"),
      a.d("誴\uf30c", 364700285, -1524929281)
   );
   private static final String[] mgr = mil(
      a.b("덩쫐䐖\ude77喪퍣椱\ue0b3继", -1201096867), a.b("ﳀ蔎ྣ釘ᨋ鲷⛧", -841746184), a.b("\uf4fa赌ޝ駫\u1249铰⻞ꜧ", 829026501), a.d("ꪊ팼姭잛䰹쪀烊綾", -817246295, 880042268)
   );
   private static final String[] mgs = mil(a.b("⼶图\udc2e䈨짰", 1934437131), a.d("⽿嚷\udc67䈅즹", -1590878761, -968345963));
   private static final String mgt = pfl.title(a.c(-78853994, "첦땮㾾ꆸ⩠곛ᚍ鼋"));
   private static final int mgu = -16711936;
   private static final int mgv = -29696;
   private static final int mgw = -52429;
   private static final int mgx = -16711681;
   private static final int mgy = 75;
   private static final int mgz = 153;
   private static mgl mha;
   private final vlq mhb = this.add(new vlq(a.c(1364434846, "鮏\ue21f棊\uf6c2絮ￅ䆉졹券\udc98孂ꄶ\u2fe8눔"), -1));
   private final vkl mhc = this.add(new vkl(a.c(-1946309766, "꽢훷尦와䧿켾番ﲚ拉"), true));
   private final vkl mhd = this.add(new vkl(a.c(1252869609, "䇙㡴늢Ⲥ꜅↰鿽ሳ谳ۼ腖筝\uf589汇\ue617惨\udecb儏"), false));
   private final vkl mhe = this.add(new vkl(a.d("ভ瀀𥳐擐\uef71槄힉婏쐷仿쥝㍖뷳⁒ꨔ", 1103173673, -1211689559), false));
   private final vkl mhf = this.add(new vkl(a.b("ꚏ\udf22嗴쯲䁓웦碫\uf565欛\ue1a0晵鰈ዕ譭ĳ螽㦝눩⣡꺺✵崙펫䱪쨆", 53650100), false));
   private final vkl mhg = this.add(new vkl(a.d("⠰冝\udb4b䕍컬䡙\uf614篺\ue5a4漐\ue8c5ኹ鰑Ǐ较ऍ댼㲔ꙝ\u200fꦇ폕嵨", -939559462, -1568515617), false));
   private final vkl mhh = this.add(new vkl(a.b("\ue13a题ቃ谿ϸ腞㬊뛫Ⳝꙧ↵\udbbd唓", 312665361), false));
   private final vkl mhi = this.add(new vkl(a.b("揽ᩭ邴ະ蔔\u03a2릆』깚\u20fbꌶ奈ퟧ个쑿䊃ﳒ真\ueda8毼\ue20e顛ᚗ费\u0b4a", 154429435), true));
   private final vmc mhj = this.add(new vmc(a.d("멫쏻䤮휦岊\uda3f恠\ued83矎省窢胗ฅ韊ᶘ魨", 486382694, -1367989758), 20.0, 4.0, 40.0, 1.0));
   private String mhk = "";
   private long mhl;
   private Slot mhm;
   private Slot mhn;
   private Slot mho;
   private Slot mhp;
   private int mhq = -1;
   private int mhr;
   private long mhs;
   private boolean mht;
   private boolean mhu;
   private boolean mhv;

   public mgl() {
      super(a.c(1955199244, "鹿胅\u0a00鑦ᾬ餛⍉ꪞ㓬빔㦛쏿䴿"), a.c(-456709628, "⩬叼\ud921䝟첌䨸\uf065禛\ue7d8浮\ueaee\u10cb鸀\u07bc趪ଘ녜㺀ꐷ≷ꮕ퇒彦쓣䊓젌熶ﾯ攔\ue346森阸"), kfa.PLAYER);
      mha = this;
   }

   @Override
   protected void onEnable() {
      this.mih();
      this.mhq = -1;
      this.mhr = 0;
      this.mhs = 0L;
   }

   @Override
   protected void onDisable() {
      this.mih();
   }

   public static void onMessage(Text var0) {
   }

   public static void attach(Screen var0) {
      if (var0 instanceof GenericContainerScreen var1) {
         ScreenEvents.afterRender(var0).register((AfterRender)(var1x, var2, var3, var4, var5) -> {
            mgl var6 = mha;
            if (var6 != null && var6.isEnabled() && var6.mid(var1, var2)) {
               var6.mhy(var1, var2, var3, var4);
            }
         });
      }
   }

   private void mhy(GenericContainerScreen var1, DrawContext var2, int var3, int var4) {
      if (!((GenericContainerScreenHandler)var1.method_17577()).method_34255().method_7960()) {
         var1.method_71083(var2, var3, var4);
      } else {
         Slot var5 = vxl.hovered(var1);
         if (var5 != null && var5.method_7681()) {
            ItemStack var6 = var5.method_7677();
            var2.method_51437(
               this.mc.field_1772,
               Screen.method_25408(this.mc, var6),
               var6.method_32347(),
               var3,
               var4,
               (Identifier)var6.method_58694(DataComponentTypes.field_54198)
            );
            var2.method_73199();
         }
      }
   }

   @Override
   public void onKey(MinecraftClient var1, int var2) {
      if (var2 == this.mhb.get()) {
         this.mia(var1);
      }
   }

   @Override
   public void onStartTick(MinecraftClient var1) {
      if (var1.field_1724 != null) {
         this.mhz(var1);
      }
   }

   private void mhz(MinecraftClient var1) {
      if (var1.method_22683() == null) {
         this.mhv = false;
      } else {
         boolean var2 = GLFW.glfwGetMouseButton(var1.method_22683().method_4490(), 2) == 1;
         boolean var3 = var2 && !this.mhv && var1.field_1755 instanceof GenericContainerScreen;
         this.mhv = var2;
         if (var3) {
            GenericContainerScreen var4 = (GenericContainerScreen)var1.field_1755;
            String var5 = pfl.title(var4.method_25440().getString());
            if (!mij(var5)) {
               Slot var6 = vxl.hovered(var4);
               if (var6 != null && var6.method_7681()) {
                  String var7 = cleanQuery(var6.method_7677().method_7964().getString());
                  if (!var7.isEmpty()) {
                     this.mhk = var7;
                     izx.alert(this.getName(), wap.s(a.b("ᇠ桼\ue2b5糟\uf702燭쮤", 1057362341), a.b("ꪏ팙始잳䱡쫛炋沈挪\ue981", -1549816174)) + this.mhk, vhz.PIN, true);
                  }
               }
            }
         }
      }
   }

   private void mia(MinecraftClient var1) {
      if (var1.field_1724 != null && var1.method_1562() != null) {
         long var2 = System.currentTimeMillis();
         if (var2 - this.mhl >= 500L) {
            if (!this.mib(var2)) {
               izx.alert(
                  this.getName(),
                  wap.s(a.d("ቾ毼\ue13a罚\uf4c8爵졣䆖\udfcd啡", -1126204088, -646484114), a.c(1479946693, "㗩䱂욒墓팶喃\uefd2房\uf807狁\uf563༑膺")),
                  vhz.CLOCK,
                  false
               );
            } else {
               String var4 = this.mic(var1.field_1724);
               if (var4.isEmpty()) {
                  izx.alert(
                     this.getName(),
                     wap.s(a.d("\udbffꉯ⢧뛊㴜뮪ǰ衆ᙍ鳧᭻\ue159澘\uf62d籭揄䃉", 1204759264, 2038100288), a.c(316499322, "慶ᣯ阩ొ蟤į묍㊌곞≲ꆾ宰픒䲢웹䀁塀")),
                     vhz.INFO,
                     false
                  );
               } else {
                  this.mhl = var2;
                  var1.method_1562().method_45730(a.b("錝\ueaa5怾\ufe1c痝\uf368䤨새府푥", -569339018) + var4);
               }
            }
         }
      }
   }

   private boolean mib(long var1) {
      return pdi.nextFree(0, this.mhj.getInt(), var1) <= var1;
   }

   private String mic(ClientPlayerEntity var1) {
      if (this.mc.field_1755 instanceof HandledScreen var2) {
         Slot var6 = vxl.hovered(var2);
         if (var6 != null && var6.method_7681()) {
            String var4 = cleanQuery(var6.method_7677().method_7964().getString());
            if (!var4.isEmpty()) {
               return var4;
            }
         }
      }

      ItemStack var5 = var1.method_6047();
      if (var5 != null && !var5.method_7960()) {
         String var7 = cleanQuery(var5.method_7964().getString());
         if (!var7.isEmpty()) {
            return var7;
         }
      }

      return this.mhk;
   }

   public static String cleanQuery(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         String var1 = var0.replaceAll(a.d("삾릆", -665444366, -659103767), "");
         StringBuilder var2 = new StringBuilder(var1.length());
         boolean var3 = true;

         for (int var4 = 0; var4 < var1.length(); var4++) {
            char var5 = var1.charAt(var4);
            boolean var6 = var5 >= 'a' && var5 <= 'z' || var5 >= 'A' && var5 <= 'Z' || var5 >= 1024 && var5 <= 1279 || var5 >= '0' && var5 <= '9';
            if (var6) {
               var2.append(Character.toLowerCase(var5));
               var3 = false;
            } else if (!var3) {
               var2.append(' ');
               var3 = true;
            }
         }

         return var2.toString().trim();
      } else {
         return "";
      }
   }

   public String getBound() {
      return this.mhk;
   }

   private boolean mid(GenericContainerScreen var1, DrawContext var2) {
      int var3 = ((GenericContainerScreenHandler)var1.method_17577()).field_7763;
      if (var3 != this.mhq) {
         this.mih();
         this.mhq = var3;
         this.mhr = 0;
         this.mhs = 0L;
      }

      String var4 = pfl.title(var1.method_25440().getString());
      if (mij(var4)) {
         this.mih();
         return false;
      } else {
         boolean var5 = this.mhh.get() != this.mht || this.mhi.get() != this.mhu;
         int var6 = this.mif(var1);
         long var7 = System.currentTimeMillis();
         if (var5 || var6 != this.mhr || var7 - this.mhs > 500L) {
            this.mie(var1, var4);
            this.mhr = var6;
            this.mhs = var7;
            this.mht = this.mhh.get();
            this.mhu = this.mhi.get();
         }

         int[] var9 = this.mii(var1);
         boolean var10 = this.mhi.get() && this.mig(var2, this.mhp, var9, -16711681);
         var10 |= this.mig(var2, this.mhm, var9, -16711936);
         var10 |= this.mig(var2, this.mhn, var9, -29696);
         return var10 | this.mig(var2, this.mho, var9, -52429);
      }
   }

   private void mie(GenericContainerScreen var1, String var2) {
      ArrayList var3 = new ArrayList();
      Slot var4 = null;
      int var5 = Integer.MAX_VALUE;
      int var6 = ((GenericContainerScreenHandler)var1.method_17577()).method_17388();
      int var7 = var6 * 9;
      boolean var8 = mik(var2);

      for (Slot var10 : ((GenericContainerScreenHandler)var1.method_17577()).field_7761) {
         if (var10.field_7874 < var7) {
            ItemStack var11 = var10.method_7677();
            if (!var11.method_7960()) {
               List var12 = pfd.lines(var11);
               if (!var12.isEmpty() && !mim((String)var12.get(0), mgo)) {
                  int var13 = pfd.total(var11);
                  if (var13 > 0
                     && (var8 || min(var12, mgp))
                     && (!this.mhc.get() || !mip(var11, var12, a.c(689709357, "╡岠홴䡱"), a.d("雤\uef49斝ﯱ瀺\uf696", -534221121, -2065500119)))
                     && (!this.mhd.get() || !mis(var11) || miq(var12, a.b("䍝㪓뀾⸶ꖛ〈餅ჷ躦", -1228978325), a.c(-2105282421, "\uf0f4襞\u0381鷠ᘠ邕⫌ꌿ㵧럟"), 5))
                     && (!this.mhe.get() || !mis(var11) || miq(var12, a.b("蔐ﲦ瘌\ue80c採\ue562", 340885793), a.d("\udd39ꒊ⹄뀮㯨뵟ܛ軷Ⴎ騞", 1366089607, 415826628), 5))
                     && (
                        !this.mhf.get()
                           || !miw(var11)
                           || miq(var12, a.c(-1470047695, "\ude1eꞮ\u2d77대㣛빠к跆Ꮶ鴸Ẏ\ue484橙\uf390禾ｎ"), a.d("弹⚉걏㈺맱㼈蔈\u0cfe銧᠍鿓斣\ueb63", -1457165316, -647351124), 3)
                     )
                     && (!this.mhg.get() || !var11.method_7963() || !var11.method_7986())
                     && !mio(var12)) {
                     if (var13 < var5) {
                        var5 = var13;
                        var4 = var10;
                     }

                     int var14 = this.mhh.get() && var11.method_7947() > 1 ? var13 / var11.method_7947() : var13;
                     var3.add(new mgg(var10, var14));
                  }
               }
            }
         }
      }

      Collections.sort(var3);
      this.mhm = var3.isEmpty() ? null : ((mgg)var3.get(0)).mgh;
      this.mhn = var3.size() > 1 ? ((mgg)var3.get(1)).mgh : null;
      this.mho = var3.size() > 2 ? ((mgg)var3.get(2)).mgh : null;
      this.mhp = var4;
   }

   private int mif(GenericContainerScreen var1) {
      int var2 = 1;
      int var3 = ((GenericContainerScreenHandler)var1.method_17577()).method_17388();
      int var4 = var3 * 9;

      for (Slot var6 : ((GenericContainerScreenHandler)var1.method_17577()).field_7761) {
         if (var6.field_7874 < var4) {
            ItemStack var7 = var6.method_7677();
            if (!var7.method_7960()) {
               var2 = 31 * var2 + Registries.field_41178.method_10206(var7.method_7909());
               var2 = 31 * var2 + var7.method_7947();
               if (var7.method_57826(DataComponentTypes.field_49631)) {
                  var2 = 31 * var2 + var7.method_7964().hashCode();
               }

               if (var7.method_57826(DataComponentTypes.field_49632)) {
                  var2 = 31 * var2 + ((LoreComponent)var7.method_58694(DataComponentTypes.field_49632)).hashCode();
               }
            }
         }
      }

      return var2;
   }

   private boolean mig(DrawContext var1, Slot var2, int[] var3, int var4) {
      if (var2 != null && !var2.method_7677().method_7960()) {
         int var5 = 1258291200 | var4 & 16777215;
         int var6 = -1728053248 | var4 & 16777215;
         int var7 = var3[0] + var2.field_7873;
         int var8 = var3[1] + var2.field_7872;
         int var9 = var7 + 16;
         int var10 = var8 + 16;
         var1.method_25294(var7, var8, var9, var10, var5);
         var1.method_25294(var7 - 1, var8 - 1, var9 + 1, var8, var6);
         var1.method_25294(var7 - 1, var10, var9 + 1, var10 + 1, var6);
         var1.method_25294(var7 - 1, var8, var7, var10, var6);
         var1.method_25294(var9, var8, var9 + 1, var10, var6);
         return true;
      } else {
         return false;
      }
   }

   private void mih() {
      this.mhm = null;
      this.mhn = null;
      this.mho = null;
      this.mhp = null;
   }

   private int[] mii(GenericContainerScreen var1) {
      int var2 = ((GenericContainerScreenHandler)var1.method_17577()).method_17388();
      short var3 = 176;
      int var4 = 114 + var2 * 18;
      int var5 = (var1.field_22789 - var3) / 2;
      int var6 = (var1.field_22790 - var4) / 2;
      return new int[]{var5, var6};
   }

   private static boolean mij(String var0) {
      return mim(var0, mgm);
   }

   private static boolean mik(String var0) {
      return mim(var0, mgn);
   }

   private static String[] mil(String... var0) {
      String[] var1 = new String[var0.length];

      for (int var2 = 0; var2 < var0.length; var2++) {
         var1[var2] = pfl.title(var0[var2]);
      }

      return var1;
   }

   private static boolean mim(String var0, String[] var1) {
      for (String var5 : var1) {
         if (var0.contains(var5)) {
            return true;
         }
      }

      return false;
   }

   private static boolean min(List<String> var0, String[] var1) {
      for (String var3 : var0) {
         if (mim(var3, var1)) {
            return true;
         }
      }

      return false;
   }

   private static boolean mio(List<String> var0) {
      for (String var2 : var0) {
         if (!mim(var2, mgq) && (mim(var2, mgr) || mim(var2, mgs) && !var2.contains(mgt))) {
            return true;
         }
      }

      return false;
   }

   private static boolean mip(ItemStack var0, List<String> var1, String var2, String var3) {
      if (min(var1, mil(var2, var3))) {
         return true;
      } else {
         try {
            ItemEnchantmentsComponent var4 = (ItemEnchantmentsComponent)var0.method_58694(DataComponentTypes.field_49633);
            if (var4 != null && var4.toString().toLowerCase(Locale.ROOT).contains(var3)) {
               return true;
            }

            ItemEnchantmentsComponent var5 = (ItemEnchantmentsComponent)var0.method_58694(DataComponentTypes.field_49643);
            if (var5 != null && var5.toString().toLowerCase(Locale.ROOT).contains(var3)) {
               return true;
            }
         } catch (Throwable var6) {
         }

         return false;
      }
   }

   private static boolean miq(List<String> var0, String var1, String var2, int var3) {
      String var4 = mir(var3);
      return min(
         var0,
         mil(
            var1 + a.c(1336492141, "䁌") + var3,
            var2 + a.b("⯝", 415640572) + var3,
            var1 + a.d("\ue739", 255596838, -1669988802) + var4,
            var2 + a.d("埻", 720464742, 2106866876) + var4
         )
      );
   }

   private static String mir(int var0) {
      return switch (var0) {
         case 1 -> a.b("\ue9d2", 82897338);
         case 2 -> a.d("竨͙", -1291992651, 1824897846);
         case 3 -> a.c(-708144682, "醼\ue80d拞");
         case 4 -> a.d("\uda73ꏝ", -574700615, 887626145);
         case 5 -> a.d("걇", 1171017352, -2047155528);
         default -> String.valueOf(var0);
      };
   }

   private static boolean mis(ItemStack var0) {
      return mit(var0) || miu(var0) || miv(var0) || miw(var0);
   }

   private static boolean mit(ItemStack var0) {
      return var0.method_31574(Items.field_22027)
         || var0.method_31574(Items.field_8805)
         || var0.method_31574(Items.field_8743)
         || var0.method_31574(Items.field_8862)
         || var0.method_31574(Items.field_8283)
         || var0.method_31574(Items.field_8267)
         || var0.method_31574(Items.field_8090);
   }

   private static boolean miu(ItemStack var0) {
      return var0.method_31574(Items.field_22028)
         || var0.method_31574(Items.field_8058)
         || var0.method_31574(Items.field_8523)
         || var0.method_31574(Items.field_8678)
         || var0.method_31574(Items.field_8873)
         || var0.method_31574(Items.field_8577);
   }

   private static boolean miv(ItemStack var0) {
      return var0.method_31574(Items.field_22029)
         || var0.method_31574(Items.field_8348)
         || var0.method_31574(Items.field_8396)
         || var0.method_31574(Items.field_8416)
         || var0.method_31574(Items.field_8218)
         || var0.method_31574(Items.field_8570);
   }

   private static boolean miw(ItemStack var0) {
      return var0.method_31574(Items.field_22030)
         || var0.method_31574(Items.field_8285)
         || var0.method_31574(Items.field_8660)
         || var0.method_31574(Items.field_8753)
         || var0.method_31574(Items.field_8313)
         || var0.method_31574(Items.field_8370);
   }
}
