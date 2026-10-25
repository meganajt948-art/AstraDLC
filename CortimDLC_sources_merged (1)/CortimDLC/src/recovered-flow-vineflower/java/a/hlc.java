package a;

import com.mojang.blaze3d.textures.GpuTextureView;
import flow.Flow;
import flow.config.ConfigManager;
import flow.cosmetic.Cosmetics;
import flow.dev.a;
import flow.util.LoaderInfo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.CharInput;
import net.minecraft.client.input.KeyInput;
import net.minecraft.text.Text;

public class hlc extends Screen {
   static final float W = 540.0F;
   static final float H = 409.0F;
   static final float hld = 136.0F;
   static final float hle = 46.0F;
   static final float hlf = 14.0F;
   static final float hlg = 10.0F;
   static final float hlh = 23.0F;
   static final float hli = 25.0F;
   static final float hlj = 62.0F;
   static final float hlk = 136.0F;
   static final float hll = 20.0F;
   static final float hlm = 20.0F;
   static int hln;
   static String hlo;
   static float hlp = Float.NaN;
   static float hlq = Float.NaN;
   static final Map<String, Float> hlr = new HashMap<>();
   static final Map<kfe, hjg> hls = new IdentityHashMap<>();
   static List<hjg> hlt;
   static List<hjg> hlu;
   static List<hjg> hlv;
   static List<hjg> hlw;
   static List<hjg> hlx;
   static List<hjg> hly;
   final List<hkv> hlz = new ArrayList<>();
   int hma;
   List<hjg> hmb = new ArrayList<>();
   final vdc hmc = new vdc(0.3F, 0.0F);
   final vdc hmd = new vdc(0.42F, 0.0F);
   final vdc hme = new vdc(0.32F, 1.0F);
   final vdc hmf = new vdc(0.18F, 1.0F);
   final vcj hmg = new vcj(16.0F);
   final List<vcj> hmh = new ArrayList<>();
   final List<vcj> hmi = new ArrayList<>();
   final List<vcj> hmj = new ArrayList<>();
   int[] hmk = new int[0];
   final vcj hml = new vcj(16.0F);
   final vcj hmm = new vcj(8.0F);
   final vcj hmn = new vcj(14.0F);
   final vcj hmo = new vcj(8.0F);
   float hmp;
   float hmq;
   long hmr;
   int hms;
   String hmt = "";
   String hmu = "";
   String hmv = "";
   String hmw = "";
   boolean hmx;
   boolean hmy;
   boolean hmz;
   float hna;
   float hnb;
   imn hnc;
   hxi hnd;
   ijy hne;
   irk hnf;
   String hng = "";
   int hnh = -1;
   String hni = "";
   vhz hnj = vhz.INFO;
   boolean hnk;
   long hnl;
   String hnm;
   String hnn;
   static final long hno = 350L;
   static final float hnp = 220.0F;
   static final float hnq = 7.0F;
   final vcj hnr = new vcj(14.0F);
   hjg hns;
   long hnt;
   hjg hnu;
   hjg hnv;
   List<String> hnw = List.of();
   hjg hnx;
   wam hny;
   float hnz;
   static String hoa = "";
   static final Set<hjg> hob = new HashSet<>();
   static final int hoc = 4;
   String hod = "";
   final iah hoe = new iah(a.c(1134752445, "\uf2e8譯Ƹ鿚ᐜ銦"), vhz.SEARCH, 24, iah.ANY);
   iah hof;
   final vcj hog = new vcj(16.0F);
   final vcj hoh = new vcj(14.0F);
   final vcj[] hoi = new vcj[]{new vcj(16.0F), new vcj(16.0F), new vcj(16.0F), new vcj(16.0F)};
   long hoj;
   final vcj hok = new vcj(14.0F);
   final vcj hol = new vcj(9.0F);
   final vcj hom = new vcj(13.0F);
   boolean hon;
   long hoo = -1L;
   float hop = 0.016666668F;
   float hoq = 1.0F;
   float hor = 1.0F;
   float hos;
   float hot;
   float hou;
   float hov;
   GpuTextureView how;
   static final float hox = 18.0F;
   static final float hoy = 24.0F;
   static final float hoz = 7.0F;
   static final float hpa = 18.0F;
   static final int hpb = -1750963;
   static final float hpc = 46.0F;

   public hlc() {
      super(Text.literal(a.d("씘벃㙓\ua83a⎨", -449570389, 2014764272)));
      evi.refresh();
      this.hod = hoa;
      this.hoe.text = hoa;
      this.hoe.onChange = this::hri;
      this.hoe.onSubmit = () -> this.focus(null);
   }

   static String tabKey() {
      return hlo;
   }

   static void setTabKey(String var0) {
      hlo = var0;
   }

   static Map<String, Float> scrolls() {
      return hlr;
   }

   static float windowX() {
      return hlp;
   }

   static float windowY() {
      return hlq;
   }

   static void setWindowPos(float var0, float var1) {
      hlp = var0;
      hlq = var1;
   }

   static float contentCenterX() {
      return 0.6259259F;
   }

   static float contentCenterY() {
      return 0.5562347F;
   }

   @Override
   protected void init() {
      if (!this.hlz.isEmpty()) {
         this.hpj();
      } else {
         this.hlz.clear();
         this.hmh.clear();
         this.hmi.clear();
         this.hmj.clear();

         for (kfa var4 : kfa.values()) {
            this.hlz.add(new hkv(var4.title(), iconFor(var4), var4, hks.MODULES));
         }

         this.hma = this.hlz.size();
         this.hlz.add(new hkv(a.d("ⷷ呺\udea4䃝쬂", -1645092832, -1342845562), vhz.THEME, null, hks.THEME));
         this.hlz.add(new hkv(a.b("\udba9ꈅ⣇", 796384226), vhz.LAYOUT, null, hks.HUD));
         this.hlz.add(new hkv(a.c(-1061324256, "穤Ϲ褫ᝒ鲊ᨵꁲ"), vhz.LAYERS, null, hks.CONFIGS));
         this.hlz.add(new hkv(a.c(812099683, "\ua83d톺孱씉仁졶爢\ufbc9斑"), vhz.PIN, null, hks.WAYPOINTS));
         this.hlz.add(new hkv(a.c(3977682, "놓젖䋞\udca3坿퇄殀"), vhz.FRIENDS, null, hks.FRIENDS));
         this.hlz.add(new hkv(a.d("\uddd8ꑅ⺊냥㬺붚ߔ踯ၠ", -235192492, -2048204090), vhz.CROWN, null, hks.COSMETICS));

         for (int var5 = 0; var5 < this.hlz.size(); var5++) {
            this.hmh.add(new vcj(16.0F));
            this.hmi.add(new vcj(7.0F));
            this.hmj.add(new vcj(7.0F));
         }

         this.hmk = new int[this.hlz.size()];
         if (hlo != null) {
            for (int var6 = 0; var6 < this.hlz.size(); var6++) {
               if (this.hlz.get(var6).hkw.equals(hlo)) {
                  hln = var6;
               }
            }
         }

         hln = Math.max(0, Math.min(hln, this.hlz.size() - 1));
         hlo = this.hlz.get(hln).hkw;

         for (kfe var8 : Flow.getInstance().getModuleManager().getModules()) {
            hls.computeIfAbsent(var8, hjg::new);
         }

         if (hlt == null) {
            hpf();
         }

         isv.rescan();
         this.hpm(false);
         this.hpq();
         this.hmg.set(this.hqa(hln));
         this.hpj();
      }
   }

   static void hpf() {
      hjg var0 = new hjg(a.b("泤ᕩ龷ǎ訑", 988769461), a.c(-710839456, "猛ઈ职ḫ闪ፊꤞ₲뻣㐵돍䦱이廅퓅剻\ue835柯﵊筈\uf2f3被؉鶌ᮧ酪⣔ꛀ㱧먯㆖콐䔞\udce8媬큘濛\ue5b6捿䀘炖\u0e75萩")).row(new iqp());
      var0.wide = true;
      hjg var1 = new hjg(a.c(476446350, "ﻉ蝚ඉ鏾ᠢ麉"), a.c(-1509108493, "풝괘⟊릠㈸득ປ蝠ᤱ鎖ᐖ\uee33惸籠獒\uf5f7侤쁸嫃\udc9a唯⼪ꇊ㩔밳㛻輈ŗ鯏ᶣ陂棃\ue295筮ﴵ矏졁䈦쓯嵙흔ꧦ⎹ꐋ㻟내ॠ"))
         .row(new hhs())
         .settings(List.of(iov.GRADIENT))
         .row(new ilz().visibleWhen(() -> iov.ACCENT.is(a.b("錐\uea97恂︴痸\uf34b", 1253675861))));
      var1.home = 0;
      hjg var2 = new hjg(
            a.d("⊔嬓퇆侰쑼䋏\uf8d1煴\uef37斋\ue250ᠩ", -1355660557, 1751343144),
            a.d("馚\ue018櫘\uf4be罢力䎚쩧吻\ude89奀ꌶⶳ둍㸗뢠ʻ赶ៈ釜ᡦ房\uec87睍\uf167篷쉋䰐횣傦\udb09◕꿟㙆뀈㪨蔕ཪ觜၌騞\ue4f2溼\ue90a珔\ufde2䑢컗䢆퍊崮ꟴ⹎ꠉ㊩벬܈膖\u0bac鉠", 1537400249, 802047066)
         )
         .settings(List.of(iov.PAINT))
         .row(new htj())
         .settings(iov.CUSTOM_SLIDERS)
         .row(
            new hiv(
               new hip(a.d("ភ渒\ue4dc窯\uf135矇춂䑴\uda2b傍흕ⴾ", 1235718949, 1595901176), vhz.LAYERS, iov::customFromCurrent),
               new hip(a.b("斎ᰈ雍ࢪ荬", -214604327), vhz.RESET, iov::resetCustom)
            )
         );

      for (vmo var4 : iov.CUSTOM_SLIDERS) {
         imn var5 = var2.rowFor(var4);
         if (var5 != null) {
            var5.visibleWhen(() -> iov.PAINT.is(a.d("蛵ｬ疴\uebde", 1460955132, 1895948608)));
         }
      }

      var2.home = 1;
      hjg var42 = new hjg(
            a.b("\ue431鶶ᝨ褙˒葲㸰럔⦜", -351673233), a.d("ᇣ桺\ue2a2糈\uf74a熹쯩䈚\udc4d困턶⭚ꖗ㰽뙤ニ語ԃ龵᧻速\uea0b擫Ｂ祟\uf382䨧쐩廒\ud8ce卿궷⟧븑㡋늽ഺ蝓Ƈ頭ቩ沄", 962982580, 2029183792)
         )
         .row(new irv())
         .settings(List.of(isv.FIT, isv.DARKEN, isv.MOTION, isv.PARTICLES));
      var42.wide = true;

      for (vmo var45 : List.of(isv.FIT, isv.DARKEN, isv.MOTION, isv.PARTICLES)) {
         imn var6 = var42.rowFor(var45);
         if (var6 != null) {
            if (var45 == isv.DARKEN) {
               var6.activeWhen(() -> !isv.selected().equals(a.d("ⱙ嗰\udf3e䅑쪎", -2140909545, 1649572924)));
            } else if (var45 == isv.PARTICLES) {
               var6.activeWhen(() -> isv.photoSelected() && isv.MOTION.get() > 0.001);
            } else {
               var6.activeWhen(isv::photoSelected);
            }
         }
      }

      hjg var44 = new hjg(
            a.d("Ԯ粺\uf671栄\ue3cf敳\udf64囲좆䈺엻㾊", 1183169093, -1892303061),
            a.d("폎ꩈₘ뻽㔹뎊ৎ耢ṻ铋ፖ\ue968枦︄瑀\uf2e3䣸융嶋\udb9f券⡰ꛉ㴏뭱ㆧ蠃ؗ鲡\u1aff酆濓\ue5c8簥嗢炏켏䕦쎨娇큐", 1121285147, -481362)
         )
         .toggle(hyv.ENABLED)
         .settings(hyv.OPTICS)
         .row(new hiv(a.b("ｻ蛽స鉟ᦙ齼╨겒㋀롣㾰", 77397794), vhz.RESET, hyv::resetAll));

      for (vmo var48 : hyv.LIQUID_ONLY) {
         imn var7 = var44.rowFor(var48);
         if (var7 != null) {
            var7.activeWhen(hyv::liquid);
         }
      }

      var44.home = 1;
      hjg var47 = new hjg(a.b("菥奔炡\ueec2攕\ue3f7姴퀔乘쓯䌻", -539262039), a.b("ࣁ煏ﮝ旦\uee3a棃틀嬠앬俛젏㈭벻┙꽝⧩鏡᰻蚅Æ褱", -315488125)).settings(hyv.TARGETS);
      var47.home = 1;
      hjg var49 = new hjg(
            a.c(-46430020, "裼\uf16a箣\ue5c3渃\ue8a6勲\udb01䕘"), a.b("ꢡ턪寪얄业좧犷תּ攈\uefa5桽鈛\u1ccd蔣ོ觀㎍뱇⛩ꂾ⥈卛\udde4䙡쀂䫞\uf328紾\ue7cf憒\uea29ᒽ麰݆脘ந둸㸃", 555460820)
         )
         .settings(iov.INTERFACE);
      var49.home = 0;
      hlt = List.of(var0, var1, var2, var42, var49, var44, var47);
      hjg var50 = new hjg(
            a.b("蠗\uf1bb筹", -365590436), a.b("ࠩ熿ﬢ攇\ueecc桰퉦寔얀伸죾㋁밌◹꾼⥞錗ᲁ虢\"视\uf391紥\ue6a7悌\uea46厺\udda6䝓섛䪻됣㹠ꟃ↋ꬴᓬ麁᠆至\u0bba畘－磻\ue278氒햎彬\ud939䋻첗", -1757149101)
         )
         .toggle(izx.ENABLED)
         .settings(izx.LOOK)
         .row(
            new hiv(
               new hip(a.b("Ǽ硬\uf2b2泞\ue75d憠\udbfe列챞䛵섧", 1960444338), vhz.MOVE, izx::openEditor),
               new hip(a.b("杞Ộ鐝\u0a7a膼", 1573283593), vhz.RESET, izx::resetLayout)
            )
         );
      var50.home = 0;
      hjg var8 = new hjg(
            a.d("ﵾ蓹฿遟ᮟ鴱❮꺌ナ", -1177384458, 1691579606), a.d("뢙섾䯮헠帻\ud8da抐\ueb66田ￊ砕舐ೃ镱Ὕ馠⎼걮㛈낙㥯䍺춈噖퀣媶\ue355洛\uf7f0熻凞ә躐ᝠ酱ᯌꑏ⸥꣩ㄈ묔엣侻점勁\udca7", 1801362239, 930948046)
         )
         .toggle(izx.WATERMARK.enabled)
         .settings(jlx.ISLAND);
      var8.home = 0;
      hjg var9 = new hjg(a.c(-1673705586, "䟜㹘뒘⫼ꄩ➉"), a.c(-1867740893, "襙\uf0d7稃\ue43d澳\ue914卝\udaf9䓮칞䦐뎵㴭ꒁ⺀\ua83dቱ鶠ܗ脍ࢻ狿ﰂ柉\ue1fe欢튕峉옦䁫쮜㕁뽏⚭ꃡ⩒閟Ῡ饤Ù諎\uf436繪六挑"))
         .toggle(izx.TARGET.enabled)
         .settings(jjx.OPTIONS);
      var9.home = 0;
      hjg var10 = new hjg(
            a.d("\ue72c麥ᑰ訛ǆ", -1390041138, -1106427734),
            a.d("憕᠇鋋ಡ蝫Ǖ뮙㈽걮⚦ꅍ嬳헮䱞옐䂹瀞畲\uefc7榌\ue071驯ᓐ轀ॾ菭㩎됂⻭ꢸ⌝\udddb埈츷䠇슚経\uf727燲\ue85e戂ᳬ雬ᄔ评\u05fb뱼㛑낓⬇ꔷ忭홓倗", -547974978, 1567289678)
         )
         .toggle(jlx.MUSIC)
         .settings(jlx.MUSIC_SETTINGS)
         .row(new iab(a.c(1206071205, "\u2fe8噸\udcb3"), jgn::summary))
         .row(
            new hiv(
               new hip("", vhz.PREV, () -> jgn.command(a.b("추됧㻣ꂁ", 965332448))),
               new hip(a.d("ڛ编\uf5c8殡\ue02f暑\udccd啌쬢䆇왒㰵", -2103087337, -1488557616), vhz.PLAY, () -> jgn.command(a.d("㓾䵔잏姾툢咚", -1171931506, -1780839934))),
               new hip("", vhz.NEXT, () -> jgn.command(a.c(1313567013, "煏ࣵ舻᱆")))
            )
         );
      var10.home = 1;
      hjg var11 = new hjg(a.b("斢ᰬ雤࢈荙ש뾧", -1613011467), a.d("ҡ紲\uf7f6榚\ue252擰\udee6坒줎䎿쑯㸘냘⥮ꍮ◞龞၅課ಷ蕝（熳\uea27气\ue6cc彼턿", 1641680279, -152893077))
         .toggle(izx.POTIONS.enabled)
         .settings(izx.POTIONS.settings());
      var11.home = 1;
      hjg var12 = new hjg(
            a.b("Ⲿ唡\udfee䆄쩘䳮\uf6b7网", 1503079677), a.b("♼忯픷䭗삙䘡ﱤ痆\uebce慡\ue6af᳂鉝\u0bad膿܅뵄㊉ꡭ⸲Ꞩ\udddd卣좲仅쐝緫\uf3f9椁\uef55擬騵ေ要ྒྷ蕯㪺냀㘂꾪◼孈텏囥챽䉎ﮖ焠\uf765", -2044123648)
         )
         .toggle(izx.KEYBINDS.enabled)
         .settings(izx.KEYBINDS.settings());
      var12.home = 1;
      hjg var13 = new hjg(a.d("⸁垜\udd4f䌽죢乘\uf413緻\ue3b9", 383224983, 322937564), a.c(536093212, "≐寔턃佡쒨䈆\uf80a燷\uefeb救\ue285ᣩ阹ྎ薂Ϳ륧㚨개⩇ꏴ\ud9e6坞첆䫪쀮禟\uf7d8"))
         .toggle(izx.COOLDOWNS.enabled);
      var13.home = 1;
      hjg var14 = new hjg(
            a.c(-874342685, "隯\uef23旡ﮘ灑"), a.d("弼⚻걿㈊많㽨蔁ೝ銋ᠦ鿠斆\ueb03狻\uf8b5繕쐒䮎텶圩\udec2꒙⩣놨㞞뵒Ӱ誩ဟ陂ᶲ\ue36f椺\uf0d0皙ﱰ䎫즙但훷岫≒ꠊ⾣땭㭞芁ࡻ踺ᗷ", 1174188374, 834137611)
         )
         .toggle(izx.ITEMS.enabled);
      var14.home = 1;
      hjg var15 = new hjg(a.b("ࠨ熪ﭦ攕\ueedf", -883750804), a.b("ᦞ怙\uead0璦Ｃ秓쎓䩽퐠庋\ud95f⍼귪㑔븍㢸芿൩韂ᇄ顾\ue237沒\uf748煿ﯡ䉛챌囲킾孙ꗁ⾔똶〩몑Յ輦", 1217796577))
         .toggle(izx.ARMOR.enabled)
         .settings(ixu.OPTIONS);
      var15.home = 0;
      hlu = List.of(var50, var8, var9, var10, var11, var12, var13, var14, var15);
      hur var16 = new hur();
      hjg var17 = new hjg(
            a.d("뽑워䰞퉧妿\udf00敇", 1105821329, 1722597764),
            a.c(-918286282, "၉槚\ue302絢\uf6ac瀔쩑䏿\uddac坎킋⫫ꐼ㶐럄ㄼ譧ӥ鸗ᡉ醴\ueba1敐ﺊ磲\uf229䮍얁彸\ud95a勒갊♖뾰㦦던ಎ蛴b馄Ꮕ洩\ue766悟降琹충䜔셐媀")
         )
         .row(var16)
         .row(new hva())
         .row(new hvq(var16));
      var17.wide = true;
      irk var18 = new irk(
         a.d("\uec39閠ὸ脒", -1076211280, 909884864), () -> Flow.getInstance().getOpenGuiKey(), var0x -> Flow.getInstance().setOpenGuiKey(var0x), false
      );
      hjg var19 = new hjg(
            a.d("乍㟃봔⍸ꢩ⸙鑗", -957799645, 2093116710),
            a.c(771796920, "꿎홋岙싳䥦쾉痈ﰮ扢\ue896漒镦᮪舆ࡄ躣㒿묺↕Ꟊ\u2e7b呫\udada䄜읾䶰\uf410稄\ue0b0曭\ued5fᎆ駆9蘭ೋ댃㥿뾧♘걓튾壠\udf14䖎쯷爯\uf885纟\ue50d歱醣᠈鹏Ҫ")
         )
         .settings(List.of(ConfigManager.AUTO_SAVE, ConfigManager.LOAD_ON_START))
         .row(new ict(a.d("粃Ԛ迂ᆨ騪᳐ꚍ⽠", 1150198634, 603512748), var18));
      var19.home = 0;
      hjg var20 = new hjg(a.c(2006385436, "͚竄\uf014湿\ue5b9"), a.b("턯ꢬ≨밊㟜넩ମ苄᳔阼ᇹ\ueb92敂ﲡ皳\uf040䨏엒彻\ud931僜⫕ꑪ㿵릋㍁諮Ҿ鹎᠖鏢浠\ue728绂\uf88c爪췼䟉셕壥틴걑☞ꆮ㭣땁ೢ虀", 729403724))
         .row(
            new iab(
               a.c(-1276006031, "넶좥䉡\udc0d埅텧"),
               () -> ConfigManager.active() != null ? ConfigManager.active() : wap.t(a.d("\uaad1퍡妳쟉", -848074203, -1115176802))
            )
         )
         .row(new iab(a.c(-1299063529, "\udd41꓂⸆끤㮲"), () -> String.valueOf(ConfigManager.list().size())))
         .row(
            new iab(
               a.d("ベ䥏쎉巭혻傌", 1763394684, 1760457968),
               () -> ewk.online()
                  ? wap.s(a.c(-847508880, "ਅ玾梁朆\uecd7橧"), a.b("⅒峱툼䱂잟䄥ﭼ犂", 2011506024))
                  : wap.s(a.d("纮ܖ跅Ꮎ顬Ớꒂ", -148016702, 1673727748), a.b("┰峻혨䠦쏺䕂５", -1322573559))
            )
         )
         .row(new hiv(new hip(a.b("\ue228鮳ᅷ輋ҟ艠㠲뇛", -1590828429), vhz.FOLDER, hlc::hpg)));
      var20.home = 1;
      hjg var21 = new hjg(
         a.b("\ue3fb驭Ⴅ軋Ԓ莿㧦", -429005900),
         a.d("\ue04f駑ጇ赺ڦ耍㨊뎽ⷱꝛ₅\udae3吩춞䟌선笼\uf4a2渐\ue80f憳ᯬ镃ຘ袺ɥ뮹㗉꼵⤡ꋙ将확俽짭䍞ﲆ皹\uf038榎\ue3ca鵵ᝫ郖\u0a0e葨㷢뜇ㅔꪄ⓰\ude28型", -687659874, -73087833)
      );

      for (hzq var23 : hzv.ALL) {
         var21.row(new ict(var23.name, var23.bind));
      }

      var21.home = 0;
      hlv = List.of(var17, var19, var20, var21);
      iui var51 = new iui();
      hjg var52 = new hjg(
            a.b("㵓䓉츈倮\udbae崉\ue742溺\uf0fa積ﶙ߲", -1933558511),
            a.d("\uf23a讧Ŵ鼘ᓙ鉥⠱ꇏ㾅딥㋠죂䙚\udff6嗷퍮椌\ue6ca籮充玍ন蜮\u1cfc髁ၝꧬ➤뵀㬇냫丶쐜巆\udb8f儯\ueeef擌\ue25e篪\uf1b5轓", 321512269, -1672539874)
         )
         .row(var51);
      var52.home = 0;
      hjg var24 = new hjg(a.b("筻˧蠮ᙜ鶗ᬫꅠ", 1808890680), a.b("\u0b4f狒\uf812智\ueda3欅텗壵웣䱕쯈\u31ed뼦⚚게⨪遽ᾱ蔜ͅ", -1962931434)).toggle(wlk.ENABLED).settings(wlk.DISPLAY);
      var24.home = 0;
      hjg var25 = new hjg(a.b("扇ᯀ鄋ཱི蒻Ȍ롘ㆳ꿫", 706634265), a.d("籚ח輅ᅮ髪ᰌꙇ⾫뇪㭓볊䚵적冟\udbc9崲\ue775棯\uf213瑃ﶿ螫ौ銆ᒶ鸢➐꧌㌦", 457067506, -140494879)).row(new ivk(var51));
      var25.home = 1;
      hlw = List.of(var52, var24, var25);
      hjg var26 = new hjg(
            a.d("⸥垱\udd62䍗죆乣\uf42b緖\ue382椹", 593143733, -1572173349),
            a.c(-1476261834, "࡚燐ﭚ敥\ueebd栀퉛寡얰佮좀㊣밹▌꿒⤣鍤\u1cbc虊X覠\uf3f4絍\ue694悠\uea30参\uddc3䜨셴䫟됒㹊\ua7e9⇳ꭅᓜ黹ᠶ膊ஐ甶ｽ磑\ue218污")
         )
         .row(new hxv());
      var26.home = 0;
      hjg var27 = new hjg(
            a.b("띌컖䐁\uda63冤휎", 830191364), a.b("轋\uf6c6簘\ue271榺\uef1c啎\udcec䋲졐侞뗵㬹ꊂ⢕긽ᑤ鮯Ň蜘ຌ瓲梅憟\ue7e8浲풎嫞쀢䘶췑㌛뤛₫\ua6fdⱌ鏟᧡鼯ی賁\uf227硼ￏ攁\ueb63", 371887925)
         )
         .row(new ifj());
      var27.home = 0;
      hjg var28 = new hjg(
            a.b("Α稏\uf0d9溢\ue57d掇\ud992偷츳䒎썖㤭", -1229585442),
            a.d(
               "赤\uf4e9縷\ue003殒\ued37坿\ude82䃖쩭䷺럀㤙ꂴ⪾갎ᙄ馕̱蔳ಋ盇\uf826接\ue5cd演횥壭숉䑎쾮ㄫ뭸⊄꒒\u2e73醸ᯄ鴏Ң軪\uf049穃\ufde4朩\ue90d傟\uda26屭쟱䧃댇㫪벵☩ꡑᏮ镣Ἂ蚒࠸爽\uf58a翐\ue115梲튲名\ude5b䇱쬾䵎뒖㸮",
               -212839524,
               1552408294
            )
         )
         .toggle(hhf.CLICK)
         .settings(hhf.CLICK_OPTIONS)
         .row(new ict(a.b("迚\uf65f粗\ue2ea椶\uef8d喚\udc20䉱죜", -1296199786), hzv.friendKey().bind))
         .unfolded();
      var28.home = 0;
      hjg var29 = new hjg(a.b("\u085c燒ﬅ敩\ueeb8栈퉆", 2098399252), a.b("ᘬ澱\ue560笞\uf0ca癮챩䗕\udb88儲훰Ⲙꉆ㯡뇡㝞贚˘顸Ḿ鞛\ued8d挶\uf8a8纑\uf449䷧쏤奕\udf10咸ꩥ‡맚㾞", 1420826188))
         .settings(hhf.OPTIONS);
      var29.home = 0;
      hjg var30 = new hjg(a.b("邔\ue911揙ﶤ癸\uf0c3䪇", 68718805), a.c(1073911263, "閱\uec33曳\uf895獉\uf5f6侺왆堎튨唲꽏⇚롰㉺듅\u0e85腘ᯣ鷹᐀渹\ue0ad筥ﴉ矏츮䀰\udac6岜흪⧯ꎻ㨅밄㚢襽̎藄ᱦ陼\ue8c4把"))
         .row(new hyj());
      var30.home = 1;
      hjg var31 = new hjg(
            a.c(-1729426625, "୪狪\uf82a晝\ued87"), a.b("뮌숋䣂횴崱\udbc3憜\ue866瘸ﳖ笟脽\u0ffc陆ᰟ骪€꽠㖇뎂㩮䁰캂唒팫姮\ue046減\uf4e7犼聾ޚ趺ᑶ鉷ᢏꝟⴶ\uabfa㉖렘욬䲫쬆凜\udfa1晩\uecd9", 103463909)
         )
         .toggle(ucg.ENABLED)
         .row(new ike())
         .row(new iks());
      var31.home = 0;
      hjg var32 = new hjg(
            a.b("\uf5e1象ڡ飖ጌ闤⿺ꘃ㡔닪㔾콘䆎", 1993471420), a.b("ᘧ澱\ue57a笔\uf0de百찻䖙\udb87儹훠ⳕꉕ㯻놯㜑贗˜頼Ḥ韔\uedc5捸\uf8c4纗\uf455䷿쎶夈\udf43咤ꩩ\u202b릟㾁딼\u0af8肐؈鿲ᖣ歎", 1322456644)
         )
         .row(new ild());
      var32.home = 1;
      hjg var33 = new hjg(
            a.b("ᄀ梀\ue240簷\uf7ed焅쬅䋢\udcac嘝퇓⮥ꕻ㳞", -1379921570),
            a.b("ﵞ蓃ฃ遫ᮤ鵈✕꺀ヴ멟㶛쟤䤺탎嫍\udc3e晦\ue9a1猒\uf50a糧۲衄\u139a闬Ἷꚛ⢖뉯㑛뿛䄙쭁劻퓥幈\ue19e毨\ued32瓄ﻒ耹ਹ跍ᜑ饪⃰ꨘⱌ럟㧤쌾䪃첖嘠\ud87a揈\ue508潰\uf6a8砛ɛ薩", -612958932)
         )
         .settings(ucg.OPTIONS)
         .row(new ict(a.b("\udeaaꜷⷷ뎟㠃뻹Ҥ赉", -1450257), hzv.partyMarkKey().bind));
      var33.home = 1;
      hlx = List.of(var31, var26, var28, var27, var29, var32, var30, var33);
      hjg var34 = new hjg(
            a.d("ꠌ톑孞씱仮졎爀ﯻ斴", 1017010501, 2128670979),
            a.b(
               "蓐ﵟ瞋\ue9f3戰\ue4de庁휠䥪쏊䐞븰ルꤒ⍈ꖬῤ遪\u0ad5賆Բ罡\uf1da樐\uec7e暭\udf16兟쯻䷫왗㢌늇⬵굤⟄順ቡ铯\u0d50蝼僚珨\uf452滋\ue0f3大폘嗱칓䀹뫤㌚때⿱ꇴᩗ鲋ᚽ輥ƕ篜ﰼ癦\ue8b3愙\udb57嶭힣䡓슏䓴뵯㞜꧔≼ꑲổ霜४菷\u05f6織\uf096櫧\ue33b",
               -2072935215
            )
         )
         .toggle(Cosmetics.ENABLED)
         .settings(Cosmetics.OPTIONS)
         .row(new hiv(a.c(1437213168, "↷堳틪䲕윇䇳﮳牑\uec19暣\ue17dᬐ闆\u0c70蘪\u009c몜㕄꿷"), vhz.RESET, Cosmetics::clearAll))
         .unfolded();
      var34.wide = true;
      ArrayList var35 = new ArrayList();
      var35.add(var34);
      String[][] var36 = new String[][]{
         {
               a.b("\ue828醎ᭊ蔮\u0eec衎", 1217325135),
               a.c(1602922647, "꣑텗宓엷丵좗狅"),
               a.c(
                  -1770745891,
                  "迌\uf64a粌\ue2e1椻\uef88嗝\udc3a䈶죞伛땰㮠ꉃ⡇꺩ᓡ鬳Ɖ螝ฺ瑷韛愀\ue763涥푄婘삭䛷쵅㎝름\u206f꙽ⳃ錓ᥦ龹؝豟\uf2a8磺ｖ旞\ueba3删\ud889廗씌䭥놾㠙븛⒩\uaaf7ᅂ韗ᷴ萴ઐ烇\uf729絲\ue3b2樊큏"
               )
         },
         {
               a.b("屽◒꼆ㅾ몽", 2129878031),
               a.d("╺峵혡䡙쎚", 1867974363, 1837179891),
               a.b("옱뾯㕹ꬂ⃝꘧ᰠ闊\u0bda脻ۭﲝ爞\uebe0憲\ue701嵂틐䡬츸䟅㶜덤⣴꺍\u245a鷡Ꮇ褎་蒣稽\uf026槂\uef9b攤\udab6傈홒俣", 10733146)
         },
         {
               a.c(380102869, "\ue8a6鄂ᯀ"),
               a.d("茠瘝灦\uee10", -1938261083, 1757542609),
               a.b("猽ષ耽ḕ闔\u137f꤫₈뺄㐮돺䦑읟廦풴剒\ue843枞ﵢ笮\uf28b袈ؼ鷶ᮉ酟⣫ꚳ㰃먓ㆧ콤䔺\udcdc嫝퀵濴\ue59f挙\ufae7点ฆ萁ά饶ᝂ껖⑲ꈠ㧫랃䵘쒱䋺\ud879嘝\uedb3欶\ue108磛\uf667谷\u0b81膑Ὕ雡ⲫꩉ", -1681755333)
         },
         {a.d("㥤䃜쨚", -1996207927, 2077848006), a.c(1744382818, "⬮劶\ud870䘆"), a.c(1185687239, "⚓弃햞䮶쁷䛜ﲈ甫\ueb3c憀\ue657ᰣ銼ଁ脆߶붾㉳\ua8dd⻟ꝿ\udd30厞졓乤쓼絒")},
         {
               a.c(-527808851, "䛏㽹떨⯟"),
               a.b("딓첉䙗\ud834口필漁", 2003678547),
               a.d("\ue7ef鹿ᓢ諊ċ螠㷴둗⩎ꃸ✩\udd5e叀쩽䁹욐糂\uf30f槲\ueff7昛᱂鋳ळ轐\u058c밨㈫ꢋ⻄ꕪ宧토䠐칌䓪ﭤ煝\uf787渣", 326968481, 1668203305)
         },
         {
               a.b("\u19ca恸\ueaa9瓐", -893314644),
               a.c(-20869273, "輬\uf6be籯\ue216槚\uef7a唫\udcd2䊕"),
               a.b("㘮侾씣嬋탊噡\uec35斖ﮋ焹\uf6e8\u0c91舁ᮼ醸\u1757괅⋈렳㸵럜춊䌰\ud8f5廙푇淩\ue3ea祊％璫試.駅ᾗ", -1968949694)
         },
         {
               a.b("⬝劮\ud86c䘈", -1660671110),
               a.c(-1938407675, "㽃䛐찒剶\ud9b7"),
               a.d("䈟㮁녕⼠ꓻ≟頝ᇭ迶Ԇ苚碡\uf632濏\ue599捷\ud92b嚿챚䨔쏮릾㜇겙⪥ꁶ᧔鞐൱譿À﹃琛\uedff殰\ue10c廙풮券쯐䆙㽲딦㋅ꡝ☴鿾ᔁ錍ࣞ蚼籸\uf58a玌\ue960朰\udc8a婒큤䧢읍봁㫮", 795116135, 772718598)
         }
      };

      for (String[] var40 : var36) {
         hjg var41 = new hjg(var40[1], var40[2]).row(new hwr(var40[0])).unfolded();
         var41.wide = true;
         var35.add(var41);
      }

      hly = List.copyOf(var35);
   }

   static void hpg() {
      Thread var0 = new Thread(ewk::flushNow, a.b("ဂ榙\ue349素\uf6b2瀑쨁䏿\udda3圈탊⫿ꑻ㷀랄ㅸ", -1738993580));
      var0.setDaemon(true);
      var0.start();
   }

   // $VF: Unable to simplify switch on enum
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public static vhz iconFor(kfa var0) {
      return switch (var0) {
         case COMBAT -> vhz.COMBAT;
         case MOVEMENT -> vhz.MOVEMENT;
         case PLAYER -> vhz.PLAYER;
         case RENDER -> vhz.RENDER;
         case MISC -> vhz.MISC;
      };
   }

   static int hph(kfa var0) {
      int var1 = 0;

      for (kfe var3 : Flow.getInstance().getModuleManager().getModules()) {
         if (var3.isEnabled() && !var3.isHidden() && (var0 == null || var3.getCategory() == var0)) {
            var1++;
         }
      }

      return var1;
   }

   float hpi() {
      float var1 = Math.min((this.width - 16.0F) / 540.0F, (this.height - 16.0F) / 409.0F);
      return Math.max(0.3F, Math.min((float)iov.SCALE.get(), var1));
   }

   void hpj() {
      if (this.width >= 64 && this.height >= 64) {
         float var1 = this.hpi();
         float var2 = 540.0F * var1;
         float var3 = 409.0F * var1;
         if (Float.isNaN(hlp) || Float.isNaN(hlq)) {
            hlp = (this.width - var2) * 0.5F;
            hlq = (this.height - var3) * 0.5F;
         }

         hlp = Math.max(60.0F - var2, Math.min(this.width - 60.0F, hlp));
         hlq = Math.max(0.0F, Math.min(this.height - 30.0F, hlq));
      }
   }

   static List<kfe> hpk(List<kfe> var0) {
      ArrayList var1 = new ArrayList(var0);
      var1.removeIf(kfe::isHidden);
      var1.sort(Comparator.comparing(var0x -> var0x.getName().toLowerCase(Locale.ROOT)));
      return var1;
   }

   List<hjg> hpl(hkv var1) {
      return switch (var1.hkz) {
         case MODULES -> {
            ArrayList var2 = new ArrayList();

            for (kfe var4 : hpk(Flow.getInstance().getModuleManager().getByCategory(var1.hky))) {
               var2.add(hls.get(var4));
            }

            yield var2;
         }
         case THEME -> hlt;
         case HUD -> hlu;
         case CONFIGS -> hlv;
         case WAYPOINTS -> hlw;
         case FRIENDS -> hlx;
         case COSMETICS -> hly;
      };
   }

   void hpm(boolean var1) {
      ArrayList var2 = new ArrayList();
      HashSet var3 = new HashSet();
      if (!this.hod.isEmpty()) {
         String var4 = this.hod.trim();
         ArrayList var5 = new ArrayList();

         for (kfe var7 : hpk(Flow.getInstance().getModuleManager().getModules())) {
            var5.add(hls.get(var7));
         }

         for (List var17 : List.of(hlt, hlu, hlv, hlw, hlx, hly)) {
            var5.addAll(var17);
         }

         HashMap var16 = new HashMap();

         for (hjg var8 : var5) {
            int var9 = hpn(var8, var4);
            if (var9 > 0) {
               var2.add(var8);
               var16.put(var8, var9);
               if (var9 <= 60 && var9 > 40 && (var8.isCollapsed() || hob.contains(var8))) {
                  var3.add(var8);
               }
            }
         }

         if (var3.size() > 4) {
            var3.clear();
         }

         var2.sort(Comparator.comparingInt(var1x -> -(Integer)var16.get(var1x)));
      } else {
         var2.addAll(this.hpl(this.hlz.get(hln)));
      }

      for (hjg var13 : hob) {
         if (!var3.contains(var13)) {
            var13.setCollapsed(true);
         }
      }

      for (hjg var14 : var3) {
         var14.setCollapsed(false);
      }

      hob.clear();
      hob.addAll(var3);
      boolean var12 = !var2.equals(this.hmb);
      this.hmb = var2;
      this.hpo();
      if (var12 && var1) {
         this.hmd.restart();
         this.hmp = 0.0F;
         this.hml.set(0.0F);
      }
   }

   static int hpn(hjg var0, String var1) {
      StringBuilder var2 = new StringBuilder();
      if (var0.module != null) {
         var2.append(wap.both(var0.module.getCategory().title()));
      }

      for (imn var4 : var0.rows) {
         if (var4.setting != null && !(var4.targetHeight() <= 0.0F)) {
            var2.append(' ').append(wap.both(var4.setting.getName()));
            if (var4.setting instanceof vlv var5 && !(var4.setting instanceof vla)) {
               for (String var7 : var5.getModes()) {
                  var2.append(' ').append(wap.both(var7));
               }
            }
         }
      }

      String var8 = var0.module != null ? var0.module.getName() : var0.title;
      String var9 = var0.module != null ? wap.aliases(var8) : null;
      return wap.score(var1, wap.names(var8), var9, var2.toString(), var0.searchDescription());
   }

   void hpo() {
      boolean var1 = this.hod.isEmpty() && this.hlz.get(hln).hkz != hks.MODULES;
      if (var1) {
         for (hjg var10 : this.hmb) {
            var10.column = Math.max(0, var10.home);
         }
      } else {
         int var2 = this.hmb.size();
         float var3 = 0.0F;

         for (hjg var5 : this.hmb) {
            var3 += var5.targetHeight() + 10.0F;
         }

         int var11 = var2;
         float var12 = 0.0F;
         float var6 = Float.MAX_VALUE;

         for (int var7 = 0; var7 <= var2; var7++) {
            float var8 = Math.max(var12, var3 - var12);
            if (var8 <= var6 + 0.01F) {
               var6 = var8;
               var11 = var7;
            }

            if (var7 < var2) {
               var12 += this.hmb.get(var7).targetHeight() + 10.0F;
            }
         }

         for (int var13 = 0; var13 < var2; var13++) {
            this.hmb.get(var13).column = var13 < var11 ? 0 : 1;
         }
      }
   }

   void hpp() {
      if (this.hod.isEmpty() && !this.hlz.isEmpty()) {
         hlr.put(this.hlz.get(hln).hkw, this.hmp);
      }
   }

   void hpq() {
      float var1 = hlr.getOrDefault(this.hlz.get(hln).hkw, 0.0F);
      this.hmp = var1;
      this.hml.set(var1);
   }

   boolean canHover() {
      return !this.hmx && !this.hpr() && !this.hmz && this.hnc == null && this.hnf == null;
   }

   boolean hpr() {
      return this.hnd != null && !this.hnd.closing();
   }

   boolean isDragging(imn var1) {
      return this.hnc == var1;
   }

   void startDrag(imn var1) {
      this.hnc = var1;
   }

   boolean isDropdownFor(vlv var1) {
      return this.hnd != null && !this.hnd.closing() && this.hnd.mode == var1;
   }

   void openDropdown(vlv var1, float var2, float var3, float var4, float var5) {
      this.hnd = new hxi(var1, var2, var3, var4, var5, 403.0F);
   }

   void openPicker(vlj var1) {
      this.hnd = null;
      ibf var2 = new ibf(var1, 540.0F, 409.0F);
      this.hne = var2;
      this.focus(var2.search);
   }

   void openOverlay(ijy var1) {
      this.hnd = null;
      this.hne = var1;
      this.focus(var1.field());
   }

   boolean hps() {
      return this.hne != null && !this.hne.closing();
   }

   irk binding() {
      return this.hnf;
   }

   void startBinding(irk var1) {
      this.hnf = var1;
      this.hnh = -1;
      this.focus(null);
      this.hng = (
            var1.clearable()
               ? wap.s(
                  a.d("☆徕핑䬶샡䘃ﰑ疡\uebb5愊\ue6c5᳭鈲௨膌ݻ봪㊷ꠋ⹕ꟑ\uddbb匉죗人쐿綃\uf3dd楋\uef37撜騙ၝ覧྿蔀㫋냣㙧꿎▌孤턯囄찚䈤ﯪ焉\uf70b泘\ue2b1ᡦ采៓赢̤뢚㹋됣ⷳꌊ\ud91d廧풫䨶", 176670650, 1154277805),
                  a.b(
                     "ﰷ薫ཾ鄅\u1ad6鰝☹ꯝ㆘묮㳾욎䡜톔徤\ud95d朆\ue8d5牮\uf434緀Ώ赟ᚹ郀ᨏꏰⶮ띖ㅴ뫼䐬칬垏톈嬶\ue4ee滾\ue800熩ﮢ蕘ༀ貫ᙻ頉⇛\uab6f\u2d2a닢㲘쉑䯥춷卜\ud917抯\ue47d渏\uf7db礕ܧ蓈\u0eee逢᧣Ꞩ╍꼕バ빬",
                     1327560813
                  )
               )
               : wap.s(a.d("⏬婿킻仜씋䏩炙灋\uee5f擠\ue32fᤇ鞖ฮ葠˃", 848639040, 863901676), a.c(-27743035, "\ua8cb텗宂엹个죡狅Ａ敤\uefd2栂鉲Რ蕨\u0b58覽㏽뱘⊄"))
         )
         + wap.t(var1.name())
         + (
            var1.clearable()
               ? wap.s(a.d("ᯑ扠\ue824盂ﴕ篁솤䡅홙岫\udb77ℏ꿜㙾밬", 740210913, -627596513), a.c(767408464, "륣샒䪖푰徧\ud973挖\ueaf7瓫\ude6e禉螙ा郾\u1ad3鱝♫꧀㍽"))
               : wap.s(a.c(923389750, "켆뚷㳳ꈕ⧂꼖ᕳ鲒ʎ衼ྭ\uf5d3笉\ue2be棤\uee0a"), a.b("㲋䔺콾冘\uda4f岛\ue6fe漟\uf103宆ﱡȎ貥ᕪ鼰ᧉꎋ", 532298938))
         );
   }

   void hpt(int var1) {
      this.hnf.set(var1);
      List var2 = this.hnf.clearable() ? hzv.boundTo(var1, this.hnf.name()) : List.of();
      if (!var2.isEmpty()) {
         this.toast(
            irr.keyName(var1)
               + wap.s(a.c(431181292, "䷇㐷뻩₇ꭌⶲ鞳ṅ老ભ购"), a.b("㹆䎕줴坏\udc94娦\ue460榆\uf7de絠𢡊¼踐ឫ鷽᭻ꕖ", 623066743))
               + String.join(a.d("⩗只", -239454005, 343872178), var2),
            vhz.KEYBOARD,
            false
         );
      }

      this.hnf = null;
   }

   iah focusedField() {
      return this.hof;
   }

   public boolean typing() {
      return this.hof != null || this.hnf != null;
   }

   void focus(iah var1) {
      this.hof = var1;
      if (var1 != null) {
         var1.focusGained();
      }
   }

   void toast(String var1, vhz var2, boolean var3) {
      this.hni = var1;
      this.hnj = var2;
      this.hnk = var3;
      this.hnl = System.currentTimeMillis() + (var3 ? 3200L : 2200L);
      this.hmo.set(1.0F);
   }

   void hint(String var1) {
      this.hnn = var1;
   }

   void hpu(DrawContext var1) {
      unf.observe(var1);
      if (unf.frame() != this.hoo) {
         this.hoo = unf.frame();
         this.hop = unf.delta() * (float)iov.ANIMATION.get();
         this.hnm = this.hnn;
         this.hnn = null;
         iov.update(this.hop);
         this.hmc.update(this.hop);
         this.hmd.update(this.hop);
         this.hme.update(this.hop);
         this.hmf.update(this.hop);
         if (this.hnd != null && this.hnd.gone()) {
            this.hnd = null;
         }

         if (this.hne != null && this.hne.gone()) {
            if (this.hof == this.hne.field()) {
               this.hof = null;
            }

            this.hne = null;
         }

         if (this.hmx && this.hmc.finished() && !this.hmy && this.client != null) {
            this.hmy = true;
            this.client.send(() -> access$001(this));
         }
      }
   }

   float hpv() {
      float var1 = this.hmc.linear();
      return this.hmx ? vcq.outCubic(var1) : vcq.outQuint(var1);
   }

   @Override
   public void renderBackground(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
      uut.beginFrame();
      this.hpu(context);
      float var5 = this.hpv();
      float var6 = (float)iov.DIM.get();
      if (this.client != null && this.client.world != null) {
         this.hpw();
         float var7 = Math.max(1, this.client.getWindow().getScaleFactor());
         float var8 = this.hpi();
         this.how = isv.frame(Math.round(540.0F * var8 * var7), Math.round(409.0F * var8 * var7));
         GpuTextureView var9 = null;
         if (this.how != null) {
            var9 = ujw.worldWith(
               this.how, this.hos * var7, this.hot * var7, (this.hos + 540.0F * this.hoq) * var7, (this.hot + 409.0F * this.hor) * var7, var5, iov.photoTone()
            );
         }

         hyv.capture(context, iov.BG_BLUR.getInt(), var5, var9);
         uut.gradientV(
            context,
            0.0F,
            0.0F,
            this.width,
            this.height,
            0.0F,
            ujt.withAlpha(0, (int)(255.0F * var6 * 0.65F * var5)),
            ujt.withAlpha(0, (int)(255.0F * var6 * var5))
         );
         swh.renderInMenu(context);
         izx.renderInMenu(context, this.hod.isEmpty() && this.hlz.get(hln).hkz == hks.HUD);
      } else {
         this.how = null;
         hyv.skip();
         this.renderPanoramaBackground(context, deltaTicks);
         if (iov.BG_BLUR.getInt() > 0) {
            context.applyBlur();
         }

         uut.rect(context, 0.0F, 0.0F, this.width, this.height, ujt.withAlpha(0, (int)(255.0F * Math.max(0.3F, var6) * var5)));
      }
   }

   void hpw() {
      float var1 = this.hpv();
      float var2 = this.hpi();
      this.hoq = var2 * (0.95F + 0.05F * var1);
      this.hor = this.hoq * (0.93F + 0.07F * var1);
      float var3 = hlp + 540.0F * var2 * 0.5F;
      float var4 = hlq + 409.0F * var2 * 0.5F + (1.0F - var1) * 10.0F;
      this.hos = var3 - 270.0F * this.hoq;
      this.hot = var4 - 204.5F * this.hor;
      if (var1 >= 0.999F && var2 == 1.0F && this.client != null) {
         float var5 = Math.max(1, this.client.getWindow().getScaleFactor());
         this.hos = Math.round(this.hos * var5) / var5;
         this.hot = Math.round(this.hot * var5) / var5;
      }
   }

   @Override
   public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
      this.hpu(context);
      float var5 = this.hpv();
      float var6 = this.hpi();
      this.hpw();
      this.hou = this.hpx(mouseX);
      this.hov = this.hpy(mouseY);
      vdn.setRenderScale(var6);
      context.getMatrices().pushMatrix();
      context.getMatrices().translate(this.hos, this.hot);
      context.getMatrices().scale(this.hoq, this.hor);
      uut.pushAlpha(var5);

      try {
         this.hpz(context);
      } finally {
         uut.popAlpha();
         context.getMatrices().popMatrix();
         vdn.setRenderScale(1.0F);
      }
   }

   float hpx(double var1) {
      return (float)((var1 - this.hos) / this.hoq);
   }

   float hpy(double var1) {
      return (float)((var1 - this.hot) / this.hor);
   }

   void hpz(DrawContext var1) {
      float var2 = this.hne != null ? -10000.0F : this.hou;
      float var3 = this.hne != null ? -10000.0F : this.hov;
      float var4 = iov.r(12.0F);
      float var5 = iov.lightness();
      float var6 = 2.5F + 1.5F * this.hpv();
      uut.shadow(var1, 0.0F, 2.0F, 540.0F, 409.0F, var4, 4.0F, ujt.withAlpha(0, Math.round(90.0F - 50.0F * var5)));
      uut.shadow(var1, 0.0F, 4.0F + 3.0F * var6, 540.0F, 409.0F, var4, 12.0F + 6.0F * var6, iov.shadow);
      boolean var7;
      if (this.how != null) {
         uut.image(var1, this.how, 0.0F, 0.0F, 540.0F, 409.0F, var4, iov.photoTone());
         uut.round(var1, 0.0F, 0.0F, 540.0F, 409.0F, var4, hyv.tint(iov.window, iov.photoDarken()));
         uut.round(var1, 0.0F, 0.0F, 136.0F, 409.0F, var4, 0.0F, 0.0F, var4, hyv.tint(iov.window, 0.4F));
         var7 = false;
      } else {
         var7 = hyv.surface(
            var1, 0.0F, 0.0F, 540.0F, 409.0F, var4, hyv.tint(iov.window, iov.windowTint()), ujt.withAlpha(iov.window, 255), (float)hyv.EDGE.get(), hyv.WINDOW
         );
      }

      uut.round(var1, 0.0F, 0.0F, 136.0F, 409.0F, var4, 0.0F, 0.0F, var4, iov.panel);
      uut.rect(var1, 136.0F, 0.0F, 1.0F, 409.0F, iov.divider);
      ukf.sheen(var1, 0.0F, 0.0F, 540.0F, 90.0F, var4, 0.8F * (1.0F - 0.7F * var5));
      if (!var7 || !hyv.liquid()) {
         uut.outline(var1, 0.0F, 0.0F, 540.0F, 409.0F, var4, 1.0F, !var7 && this.how == null ? iov.stroke : ujt.withAlpha(16777215, 24));
      }

      ukf.rim(var1, 0.0F, 0.0F, 540.0F, 409.0F, var4, var5, 1.1F);
      this.hqc(var1, var2, var3);
      this.hqx(var1, var2, var3);
      this.hrd(var1, var2, var3);
      this.hrf(var1, var2, var3);
      if (this.hnd != null) {
         this.hnd.render(var1, var2, var3, this.hop);
      }

      this.hqr(var1, var2, var3);
      this.hqq(var1);
      if (this.hne != null) {
         this.hne.render(var1, this, this.hou, this.hov, this.hop, 540.0F, 409.0F);
      }

      this.hrh(var1);
   }

   float hqa(int var1) {
      return var1 < this.hma ? 62.0F + var1 * 25.0F : this.hqb() + (var1 - this.hma) * 25.0F;
   }

   float hqb() {
      return 62.0F + this.hma * 25.0F + 20.0F;
   }

   void hqc(DrawContext var1, float var2, float var3) {
      float var4 = 24.0F;
      float var5 = 19.0F;
      if (!uqe.draw(var1, 13.0F, var4 - var5 * 0.5F, var5, iov.isLight(), -1) && !upt.draw(var1, 15.0F, var4 - 8.5F, 17.0F, iov.logoTint())) {
         vjf.draw(var1, vhz.LOGO, 23.0F, var4, 13.0F, iov.accent());
      }

      irr.LOGO.draw(var1, irr.LOGO.ellipsize(vvi.get(), 94.0F), 35.0F, irr.LOGO.centerTop(var4), iov.text);
      uut.rect(var1, 16.0F, this.hqb() - 11.0F, 104.0F, 1.0F, iov.divider);
      boolean var6 = !this.hod.isEmpty();
      float var7 = this.hmg.step(this.hqa(hln), this.hop);
      float var8 = 120.0F;
      float var9 = iov.r(6.0F);
      uut.pushAlpha(var6 ? 0.35F : 1.0F);
      float var10 = iov.lightness();
      ukf.shadow(var1, 8.0F, var7, var8, 23.0F, var9, 0.9F, var10);
      boolean var11 = hyv.surface(
         var1,
         8.0F,
         var7,
         var8,
         23.0F,
         var9,
         hyv.tint(iov.window, Math.min(0.92F, iov.windowTint() * 0.85F)),
         ujt.lerp(iov.fieldHover, -1, 0.9F * var10),
         11.5F,
         hyv.TABS
      );
      if (var11) {
         int var12 = ujt.withAlpha(ujt.lerp(-1, iov.accent(), 0.5F), 24);
         uut.round(var1, 8.0F, var7, var8, 23.0F, var9, ujt.lerp(var12, -2130706433, var10));
      }

      ukf.sheen(var1, 8.0F, var7, var8, 23.0F, var9, 1.4F * (1.0F - 0.7F * var10));
      ukf.rim(var1, 8.0F, var7, var8, 23.0F, var9, var10, 1.2F);
      uut.round(var1, 8.0F, var7 + 11.5F - 4.0F, 2.0F, 8.0F, 1.0F, iov.accent());
      uut.popAlpha();
      float var27 = this.hmc.linear();

      for (int var13 = 0; var13 < this.hlz.size(); var13++) {
         hkv var14 = this.hlz.get(var13);
         float var15 = this.hqa(var13);
         float var16 = vcq.outCubic((var27 * 1.5F - var13 * 0.045F) / 0.55F);
         boolean var17 = this.canHover() && irr.inside(var2, var3, 8.0F, var15, var8, 23.0F);
         float var18 = this.hmh.get(var13).step(var17, this.hop);
         float var19 = var13 == hln && !var6 ? 1.0F : 0.0F;
         uut.pushAlpha(var16);
         var1.getMatrices().pushMatrix();
         var1.getMatrices().translate(-(1.0F - var16) * 10.0F, 0.0F);
         if (var18 > 0.01F && var19 < 1.0F) {
            uut.round(var1, 8.0F, var15, var8, 23.0F, var9, ujt.withAlpha(iov.hover, Math.round(ujt.alpha(iov.hover) * var18)));
         }

         float var20 = var15 + 11.5F;
         float var21 = this.hmi.get(var13).step(0.0F, this.hop);
         int var22 = ujt.lerp(ujt.lerp(iov.textMuted, iov.textDim, var18), iov.text, var19);
         vjf.draw(var1, var14.hkx, 25.0F + var18 * 0.5F, var20, 9.5F * (1.0F + 0.2F * var21), var22);
         irr.TAB.draw(var1, wap.t(var14.hkw), 37.0F + var18 * 1.5F, irr.TAB.centerTop(var20), ujt.lerp(iov.textDim, iov.text, Math.max(var19, var18)));
         int var23 = var14.hky != null
            ? hph(var14.hky)
            : (
               var14.hkz == hks.WAYPOINTS
                  ? wlk.inWorld().size()
                  : (
                     var14.hkz == hks.FRIENDS
                        ? hhf.all().size()
                        : (var14.hkz == hks.HUD ? izx.enabledCount() : (var14.hkz == hks.COSMETICS ? Cosmetics.wornCount() : 0))
                  )
            );
         if (var23 != this.hmk[var13]) {
            this.hmk[var13] = var23;
            this.hmj.get(var13).set(1.0F);
         }

         float var24 = this.hmj.get(var13).step(0.0F, this.hop);
         if (var23 > 0) {
            String var25 = String.valueOf(var23);
            float var26 = 1.0F + 0.25F * var24;
            var1.getMatrices().pushMatrix();
            var1.getMatrices().translate(116.0F, var20);
            var1.getMatrices().scale(var26, var26);
            irr.SMALL.drawCentered(var1, var25, 0.0F, irr.SMALL.centerTop(0.0F), ujt.lerp(iov.textMuted, iov.text, Math.max(var24, var19 * 0.6F)));
            var1.getMatrices().popMatrix();
         }

         var1.getMatrices().popMatrix();
         uut.popAlpha();
      }

      this.hqm(var1, var2, var3);
   }

   float hqd() {
      return 365.0F;
   }

   float hqe() {
      return 26.0F;
   }

   float hqf() {
      return this.hqd() + 22.0F;
   }

   float hqg() {
      return 12.0F;
   }

   float hqh() {
      return hia.SLOTS.length * 24.0F + (hia.SLOTS.length - 1) * 7.0F + 16.0F;
   }

   float hqi() {
      return this.hqd() - 24.0F - 20.0F;
   }

   float hqj(int var1) {
      return this.hqg() + 8.0F + var1 * 31.0F;
   }

   boolean hqk(float var1, float var2) {
      return irr.inside(var1, var2, this.hqe() - 9.0F - 3.0F, this.hqf() - 9.0F - 3.0F, 24.0F, 24.0F);
   }

   boolean hql(float var1, float var2) {
      return irr.inside(var1, var2, this.hqg(), this.hqi(), this.hqh(), 40.0F);
   }

   void hqm(DrawContext var1, float var2, float var3) {
      float var4 = this.hqd();
      uut.rect(var1, 14.0F, var4, 108.0F, 1.0F, iov.divider);
      String var5 = LoaderInfo.login();
      long var6 = LoaderInfo.uid();
      String var8 = var5.isEmpty() ? hia.windowsUser() : var5;
      String var9 = var6 > 0L ? a.d("鏇\uea6a悴ﺡ", -14539492, 1412675210) + var6 : a.d("⋤孿톯俆쐳䊤\uf8e1焇", -39430625, -1997507403);
      float var10 = this.hqe();
      float var11 = this.hqf();
      float var12 = this.hoh.get();
      float var13 = 18.0F + 1.5F * var12;
      float var14 = var13 * 0.5F;
      ukf.shadow(var1, var10 - var13 * 0.5F, var11 - var13 * 0.5F, var13, var13, var14, 0.6F + 0.4F * var12, iov.lightness());
      if (!hia.draw(var1, hia.selected(), var10 - var13 * 0.5F, var11 - var13 * 0.5F, var13, 19.5F)) {
         uut.round(var1, var10 - var13 * 0.5F, var11 - var13 * 0.5F, var13, var13, var14, iov.field);
         irr.AVATAR.drawCentered(var1, var8.substring(0, 1).toUpperCase(Locale.ROOT), var10, irr.AVATAR.centerTop(var11), iov.textDim);
      }

      uut.circleOutline(var1, var10, var11, var13 * 0.5F, 1.0F, ujt.lerp(889192447, iov.accent(200), var12));
      float var15 = this.hqn() - 9.0F - 5.0F - 41.0F;
      irr.NAME.draw(var1, irr.NAME.ellipsize(var8, var15), 41.0F, irr.NAME.centerTop(var11 - 4.0F), iov.text);
      irr.SUBTITLE.draw(var1, irr.SUBTITLE.ellipsize(var9, var15), 41.0F, irr.SUBTITLE.centerTop(var11 + 5.0F), iov.textMuted);
      this.hqp(var1, var2, var3);
   }

   float hqn() {
      return 113.0F;
   }

   boolean hqo(float var1, float var2) {
      return irr.inside(var1, var2, this.hqn() - 9.0F - 2.0F, this.hqf() - 9.0F - 2.0F, 22.0F, 22.0F);
   }

   void hqp(DrawContext var1, float var2, float var3) {
      this.hon = this.canHover() && this.hqo(var2, var3);
      float var4 = vcq.outCubic(this.hok.step(this.hon, this.hop));
      float var5 = this.hol.step(0.0F, this.hop);
      float var6 = iov.lightness();
      float var7 = 18.0F * (1.0F - 0.06F * var5);
      float var8 = this.hqn() - var7 * 0.5F;
      float var9 = this.hqf() - var7 * 0.5F - 0.5F * var4;
      float var10 = iov.r(6.0F);
      ukf.shadow(var1, var8, var9, var7, var7, var10, 0.2F + 0.7F * var4, var6);
      uut.round(var1, var8, var9, var7, var7, var10, ujt.lerp(iov.field, -1750963, 0.14F * var4));
      uut.outline(var1, var8, var9, var7, var7, var10, 1.0F, ujt.lerp(iov.stroke, ujt.withAlpha(-1750963, 150), var4));
      ukf.rim(var1, var8, var9, var7, var7, var10, var6, 0.8F + 0.4F * var4);
      vjf.draw(var1, vhz.POWER, var8 + var7 * 0.5F, var9 + var7 * 0.5F, 9.0F, ujt.lerp(iov.textDim, -1750963, var4));
   }

   void hqq(DrawContext var1) {
      float var2 = vcq.outCubic(this.hom.step(this.hon, this.hop));
      if (!(var2 <= 0.01F)) {
         String var3 = wap.s(a.b("銖\ueb16懊ﾼ瑡", 334533315), a.b("闬\uec72暬\uf8d8猍", -1241869834));
         String var4 = wap.s(
            a.d("㡏䇾쮺啜\ude8b塵\ue22f毞\uf5c7缣\uf8ebʀ豊ᗾ鿡\u1942ꌚⳝ뙩〭막쎞", -2035486916, -1725114555),
            a.b("⏽婌퀈仮씹䞚ﶰ琰\uea6e悪\ue770ᵾ鏓੬葓ڶ볳㜼ꦐ⿋ꙉ\udc6d勜줊佺엗籦\uf24c梱", 374940608)
         );
         float var5 = irr.SUBTITLE.width(var3);
         float var6 = var5 + irr.SUBTITLE.width(var4) + 14.0F + 9.0F;
         float var7 = irr.SUBTITLE.height() + 10.0F;
         float var8 = Math.max(6.0F, Math.min(534.0F - var6, this.hqn() - var6 * 0.5F));
         float var9 = this.hqf() - 9.0F - 6.0F - var7;
         float var10 = iov.r(6.0F);
         float var11 = var9 + var7 * 0.5F;
         uut.pushAlpha(var2);
         var1.getMatrices().pushMatrix();
         var1.getMatrices().translate(0.0F, (1.0F - var2) * 3.0F);
         uut.shadow(var1, var8, var9 + 2.0F, var6, var7, var10, 12.0F, iov.shadow);
         hyv.surface(
            var1,
            var8,
            var9,
            var6,
            var7,
            var10,
            hyv.tint(iov.window, Math.min(1.0F, iov.windowTint() + 0.08F)),
            ujt.withAlpha(iov.cardHover, 250),
            6.0F,
            hyv.POPUPS
         );
         uut.outline(var1, var8, var9, var6, var7, var10, 1.0F, iov.stroke);
         uut.circle(var1, var8 + 7.0F + 2.0F, var11, 2.0F, -1750963);
         irr.SUBTITLE.draw(var1, var3, var8 + 7.0F + 9.0F, irr.SUBTITLE.centerTop(var11), iov.text);
         irr.SUBTITLE.draw(var1, var4, var8 + 7.0F + 9.0F + var5, irr.SUBTITLE.centerTop(var11), iov.textMuted);
         var1.getMatrices().popMatrix();
         uut.popAlpha();
      }
   }

   void hqr(DrawContext var1, float var2, float var3) {
      boolean var4 = this.canHover() && (this.hqk(var2, var3) || this.hoh.get() > 0.3F && this.hql(var2, var3));
      long var5 = System.currentTimeMillis();
      if (var4) {
         this.hoj = var5 + 250L;
      }

      float var7 = vcq.outCubic(this.hoh.step(var4 || var5 < this.hoj, this.hop));
      if (!(var7 <= 0.01F)) {
         float var8 = this.hqg();
         float var9 = this.hqi() + (1.0F - var7) * 6.0F;
         float var10 = this.hqh();
         float var11 = 40.0F;
         float var12 = iov.r(8.0F);
         uut.pushAlpha(var7);
         uut.shadow(var1, var8, var9 + 2.0F, var10, var11, var12, 12.0F, iov.shadow);
         uut.round(var1, var8, var9, var10, var11, var12, ujt.withAlpha(iov.cardHover, 250));
         uut.outline(var1, var8, var9, var10, var11, var12, 1.0F, iov.stroke);
         String var13 = null;

         for (int var14 = 0; var14 < hia.SLOTS.length; var14++) {
            String var15 = hia.SLOTS[var14];
            float var16 = this.hqj(var14);
            float var17 = var9 + 8.0F;
            boolean var18 = irr.inside(var2, var3, var16 - 2.0F, var17 - 2.0F, 28.0F, 28.0F);
            float var19 = this.hoi[var14].step(var18, this.hop);
            float var20 = 24.0F * (1.0F + 0.08F * var19);
            float var21 = var16 + 12.0F;
            float var22 = var17 + 12.0F - var19;
            boolean var23 = var15.equals(hia.selected());
            if (var23) {
               uut.circleOutline(var1, var21, var22, var20 * 0.5F + 2.2F, 1.4F, iov.accent());
            }

            if (a.c(-960941453, "\u321f䮶셼").equals(var15) && !hia.ownReady()) {
               uut.circle(var1, var21, var22, var20 * 0.5F, ujt.lerp(iov.field, iov.accent(60), var19));
               uut.circleOutline(var1, var21, var22, var20 * 0.5F, 1.0F, ujt.lerp(iov.stroke, iov.accent(160), var19));
               vjf.draw(var1, vhz.PLUS, var21, var22, 9.0F, ujt.lerp(iov.textDim, iov.accent(), var19));
            } else if (!hia.draw(var1, var15, var21 - var20 * 0.5F, var22 - var20 * 0.5F, var20, 25.920002F)) {
               uut.circle(var1, var21, var22, var20 * 0.5F, iov.field);
            }

            if (var18) {
               var13 = hia.label(var15);
            }
         }

         uut.popAlpha();
         if (var13 != null) {
            this.hint(var13);
         }
      }
   }

   float hqs() {
      return 480.0F;
   }

   float hqt() {
      return this.hqs() - 8.0F - 136.0F;
   }

   float hqu() {
      return 13.0F;
   }

   float hqv() {
      return 13.0F;
   }

   String hqw(hkv var1, float var2, float var3) {
      if (this.hnm != null) {
         return this.hnm;
      }

      if (!this.hod.isEmpty()) {
         int var10 = this.hmb.size();
         return var10
            + wap.s(
               var10 == 1 ? a.b("駾\ue01d櫙\uf4be罯劉䎌", 1929681369) : a.b("轠\uf683籇\ue220槱\uef59唒\udce4", -979923128),
               a.b("勛", -634170630)
                  + plural(
                     var10, a.c(-2057249334, "\ud983ꁇ⪖뒓㼼맺Χ訤ᐉ"), a.d("컼뜸㷩ꏬ⡃꺅ᓘ鵛Ͷ覵", -820053705, -477023359), a.d("簽\u05f9輨ᄭ骂᱄ꘙ⾚놷㭺벥", 1225019192, -815188146)
                  )
            );
      }

      return switch (var1.hkz) {
         case MODULES -> {
            int var9 = 0;

            for (hjg var6 : this.hmb) {
               if (var6.module != null && var6.module.isEnabled()) {
                  var9++;
               }
            }

            yield var9
               + wap.s(a.d("ꑶ\udd88坒쥥", 814882692, 1111473110), a.b("ᘷ殞\ue142笤", 543495699))
               + this.hmb.size()
               + wap.s(a.d("㓦䴘쟊", 1557234015, 1883354522), a.b("冰Ⱃꛈ㢸", 372265364));
         }
         case THEME -> iov.shownName(iov.presetName());
         case HUD -> izx.enabledCount() + wap.s(a.c(-314033867, "㤖䃨쨺"), a.b("垳⨐ꃋ㺻", -1123526761));
         case CONFIGS -> ConfigManager.active() != null
            ? ConfigManager.active()
            : wap.s(a.d("ꙹ\udfe9啵쭇䂜올籷\uf589毘\ue12e暤鳉ሏ", -859376192, 1181963258), a.b("\uf6d8轍֝鮕ှ隄Ⳕꄵ㭵뇅㘒챩䚮\udb02兙ퟟ", -1952714030));
         case WAYPOINTS -> {
            int var8 = wlk.inWorld().size();
            yield var8
               + wap.s(
                  var8 == 1 ? a.c(-1404173969, "Ł碧\uf262氋\ue7d5慻\udb2e勘첝䙸쇣㮟땟⳹") : a.c(598118076, "躓\uf775綰\ue3d9标\ueea9哼\udd0a䍏짹乹둀㪚ꌼ⥸"),
                  a.b("≓", 328802930)
                     + plural(var8, a.c(1050864595, "\uefea陒ᳶ苿ढ"), a.b("翀ٸ賜ዕ餀", 326990841), a.b("黠\ue758淼\uf3f1砢", -1746887975))
                     + a.c(1767930853, "篃٥貵ዅ饦Ὶ")
               );
         }
         case FRIENDS -> {
            int var7 = hhf.all().size();
            yield var7 == 0
               ? wap.s(a.b("\uf2f1譡Ƴ鿉ᑛ銳⣼ꄜ㼗떦㋢전䛓", 1888219826), a.c(1881814284, "ㄞ䢎쉙尢폥光\ueb12抔\uf8a9爘\uf55cྺ腭"))
                  + irr.keyName(hzv.friendKey().key())
                  + wap.s(a.d("蝷ﺉ瑛\uea64懲\ue702崁퓬䪾쀗䟘붾", -1903316659, -2057488874), a.c(208684447, "䖵㠛닉⢦ꝩ⇓鯳ቼ谧ۯ"))
               : var7
                  + wap.s(
                     var7 == 1 ? a.d("ꥭ킚婝쐷俬쥖猏", 60846475, 34920641) : a.d("Ӟ紩\uf7ee榄\ue25f擥\udebc坚", 647252734, 1621839368),
                     a.c(-1963512272, "⸑") + plural(var7, a.c(-2125725809, "﮿艺ࢪ隫"), a.c(204096617, "䁘㦝덍ⵌꚘ"), a.c(-767416036, "\u2d2e哫\ude3b䀾쯫䵖"))
                  );
         }
         case COSMETICS -> {
            int var4 = Cosmetics.wornCount();
            yield var4 == 0
               ? wap.s(a.b("硕ǅ謍ᕠ麶᠀ꉚ⯬뗼㽌룑䋹찲喒", 1464694805), a.b("\ue9ea遺᪭蓖\u0b11覽㏫멥⑈껿⤡흎嶄쐽䩻좗狕ﴀ枲\ue194栟", 64876000))
               : var4
                  + wap.s(
                     a.c(-358461486, "俷㘑볚⊶\ua97d"),
                     a.d("䵒", 1144395020, 812472447)
                        + plural(var4, a.c(-1283386946, "ᖇ氱\ue69e磪\uf751痽쾣䙖\ud808勎핯"), a.c(-1380457530, "\ue7ff鹉ᓦ諦ԩ螅㷛됮⩰ꂶ❬"), a.c(-1713351746, "垀⸶꒙㪔녏㏧趩ѕ騎Ⴞ霚洗"))
                  );
         }
      };
   }

   static String plural(int var0, String var1, String var2, String var3) {
      int var4 = var0 % 10;
      int var5 = var0 % 100;
      if (var4 == 1 && var5 != 11) {
         return var1;
      } else {
         return var4 < 2 || var4 > 4 || var5 >= 12 && var5 <= 14 ? var3 : var2;
      }
   }

   void hqx(DrawContext var1, float var2, float var3) {
      float var4 = 152.0F;
      hkv var5 = this.hlz.get(hln);
      String var6 = wap.t(this.hod.isEmpty() ? var5.hkw : a.b("헦걡⚶룔㌒떨", -586033741));
      if (!var6.equals(this.hmt)) {
         this.hmu = this.hmt;
         this.hmt = var6;
         this.hme.restart();
      }

      float var7 = vcq.outCubic(this.hme.linear());
      if (var7 < 1.0F && !this.hmu.isEmpty()) {
         uut.pushAlpha(1.0F - var7);
         irr.TITLE.draw(var1, this.hmu, var4, irr.TITLE.centerTop(18.0F) - 6.0F * var7, iov.text);
         uut.popAlpha();
      }

      uut.pushAlpha(var7);
      irr.TITLE.draw(var1, this.hmt, var4, irr.TITLE.centerTop(18.0F) + 6.0F * (1.0F - var7), iov.text);
      uut.popAlpha();
      float var8 = this.hqt() - var4 - 12.0F;
      String var9 = irr.SUBTITLE.ellipsize(this.hqw(var5, var2, var3), var8);
      if (!var9.equals(this.hmv)) {
         this.hmw = this.hmv;
         this.hmv = var9;
         this.hmf.restart();
      }

      float var10 = vcq.outCubic(this.hmf.linear());
      if (var10 < 1.0F && !this.hmw.isEmpty()) {
         uut.pushAlpha(1.0F - var10);
         irr.SUBTITLE.draw(var1, this.hmw, var4, irr.SUBTITLE.centerTop(31.0F), iov.textMuted);
         uut.popAlpha();
      }

      uut.pushAlpha(var10);
      irr.SUBTITLE.draw(var1, this.hmv, var4 + 3.0F * (1.0F - var10), irr.SUBTITLE.centerTop(31.0F), iov.textMuted);
      uut.popAlpha();
      this.hoe.x = this.hqt();
      this.hoe.y = this.hqu();
      this.hoe.w = 136.0F;
      this.hoe.h = 20.0F;
      this.hoe.render(var1, this, var2, var3, this.hop);
      if (this.hoe.text.isEmpty() && this.hof != this.hoe) {
         irr.SMALL
            .drawRight(
               var1, a.c(-337651266, "\ud9fbꁽ⪨듇㽜릋"), this.hqt() + 136.0F - 8.0F, irr.SMALL.centerTop(this.hqu() + 10.0F), ujt.mulAlpha(iov.textMuted, 0.8F)
            );
      }

      float var11 = this.hqv();
      float var12 = iov.lightness();
      float var13 = this.hog.step(this.canHover() && irr.inside(var2, var3, this.hqs(), var11, 46.0F, 20.0F), this.hop);
      float var14 = iov.r(6.0F);
      float var15 = this.hqs();
      float var16 = var11 - 0.5F * var13;
      ukf.shadow(var1, var15, var16, 46.0F, 20.0F, var14, 0.2F + 0.7F * var13, var12);
      uut.round(var1, var15, var16, 46.0F, 20.0F, var14, ujt.lerp(iov.field, iov.fieldHover, var13));
      uut.outline(var1, var15, var16, 46.0F, 20.0F, var14, 1.0F, ujt.lerp(iov.stroke, iov.accent(150), var13));
      ukf.rim(var1, var15, var16, 46.0F, 20.0F, var14, var12, 0.8F + 0.4F * var13);
      int var17 = ujt.lerp(iov.textDim, iov.text, var13);
      var1.getMatrices().pushMatrix();
      var1.getMatrices().translate(var15 + 11.0F, var16 + 10.0F);
      var1.getMatrices().rotate(0.50265485F * var13);
      vjf.draw(var1, vhz.GLOBE, 0.0F, 0.0F, 9.0F, var17);
      var1.getMatrices().popMatrix();
      irr.VALUE.draw(var1, wap.ru() ? a.c(-823456020, "ຼ眊") : a.c(1388713720, "ᚿ漅"), var15 + 20.0F, irr.VALUE.centerTop(var16 + 10.0F), var17);
      vjf.draw(var1, vhz.CHEVRON_DOWN, var15 + 46.0F - 8.0F, var16 + 10.0F + 0.5F, 6.0F, ujt.lerp(iov.textMuted, iov.accent(), var13));
      if (var13 > 0.5F) {
         this.hint(wap.s(a.c(-1260149072, "ꛨ\udf74喨쯐䀕우糥\uf516欌\ue1bd曹鰟ወ謜Ť螜㷘눌⢥껯"), a.c(437828725, "롊쇣䭌핌媁\udc30更\uef92燍ｼ磌芿౨関ῳ餃")));
      }

      uut.rect(var1, 137.0F, 46.0F, 403.0F, 1.0F, iov.divider);
   }

   float hqy() {
      return 150.0F;
   }

   float hqz() {
      return 56.0F;
   }

   float hra() {
      return 399.0F;
   }

   float hrb() {
      return 183.0F;
   }

   hjg hrc(float var1, float var2) {
      if (this.canHover() && irr.inside(var1, var2, 136.0F, 46.0F, 404.0F, 363.0F)) {
         for (hjg var4 : this.hmb) {
            if (var4.hovered(var1, var2)) {
               return var4;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   void hrd(DrawContext var1, float var2, float var3) {
      float var4 = this.hqz();
      float var5 = this.hra() - var4;
      float var6 = this.hrb();
      int var7 = this.hmb.size();
      float[] var8 = new float[var7];
      float[] var9 = new float[var7];
      float[] var10 = new float[]{0.0F, 0.0F};

      for (int var11 = 0; var11 < var7; var11++) {
         hjg var12 = this.hmb.get(var11);
         float var13 = var12.height();
         if (var12.wide && this.hod.isEmpty()) {
            float var14 = Math.max(var10[0], var10[1]);
            var8[var11] = this.hqy();
            var9[var11] = var14;
            var12.w = var6 * 2.0F + 10.0F;
            var10[0] = var10[1] = var14 + var13 + 10.0F;
         } else {
            var8[var11] = this.hqy() + var12.column * (var6 + 10.0F);
            var9[var11] = var10[var12.column];
            var12.w = var6;
            var10[var12.column] = var10[var12.column] + (var13 + 10.0F);
         }
      }

      this.hmq = Math.max(var10[0], var10[1]) - 10.0F;
      float var23 = Math.max(0.0F, this.hmq - var5);
      this.hmp = Math.max(0.0F, Math.min(var23, this.hmp));
      float var24 = this.hml.step(this.hmp, this.hop);
      uut.pushScissor(var1, 137.0F, 47.0F, 402.0F, 361.0F);
      if (this.hmb.isEmpty()) {
         this.hre(var1);
      }

      float var25 = this.hmd.linear();
      boolean var26 = irr.inside(var2, var3, 136.0F, 46.0F, 404.0F, 363.0F);
      float var15 = var26 ? var2 : -1000.0F;
      float var16 = var26 ? var3 : -1000.0F;
      int var17 = 0;

      for (int var18 = 0; var18 < var7; var18++) {
         hjg var19 = this.hmb.get(var18);
         var19.x = var8[var18];
         var19.y = var4 + var9[var18] - var24;
         float var20 = var19.height();
         if (!(var19.y > 409.0F) && !(var19.y + var20 < 46.0F)) {
            float var21 = vcq.outCubic((var25 * 1.9F - Math.min(var17++, 9) * 0.12F) / 0.8F);
            if (!(var21 <= 0.01F)) {
               uut.pushAlpha(var21);
               var1.getMatrices().pushMatrix();
               var1.getMatrices().translate((1.0F - var21) * 16.0F * this.hms, (1.0F - var21) * 10.0F);
               var19.render(var1, this, var15, var16, this.hop);
               var1.getMatrices().popMatrix();
               uut.popAlpha();
            }
         }
      }

      boolean var27 = System.nanoTime() - this.hmr < 900000000L;
      float var28 = this.hmm.step(var23 > 0.0F && (var27 || irr.inside(var2, var3, 528.0F, var4, 12.0F, var5)), this.hop);
      if (var23 > 0.0F) {
         float var29 = Math.max(18.0F, var5 * var5 / this.hmq);
         float var30 = var4 + (var5 - var29) * (var24 / var23);
         float var22 = 2.5F + 1.5F * var28;
         uut.round(var1, 536.0F - var22, var30, var22, var29, var22 * 0.5F, ujt.mulAlpha(iov.textMuted, 0.35F + 0.5F * var28));
      }

      uut.popScissor(var1);
   }

   void hre(DrawContext var1) {
      float var2 = 338.0F;
      float var3 = 217.5F;
      float var4 = vcq.outCubic(this.hmd.linear() * 1.5F);
      float var5 = (float)Math.sin(System.nanoTime() / 5.0E8) * 1.5F;
      uut.pushAlpha(var4);
      uut.circle(var1, var2, var3 - 6.0F + var5, 22.0F * (0.8F + 0.2F * var4), iov.hover);
      vhz var6 = this.hod.isEmpty() ? this.hlz.get(hln).hkx : vhz.SEARCH;
      vjf.draw(var1, var6, var2, var3 - 6.0F + var5, 20.0F, iov.textMuted);
      String var7 = this.hod.isEmpty()
         ? wap.s(a.c(1867619923, "鸍\ue79d浕\uf338磮﹘䐂춴厣\ud91f廛꒽⨯돇㦈뽨"), a.b("⣞兎\udb99䗢쨥䢋\uf2a4筗\ue50b濆", -1228460853))
         : wap.s(a.d("닌쭜䆔\udff9启튙棃\ue175罬\uf5d4爝衷ڪ", -1600026941, -1633405876), a.b("꽷훣屏쉌䦝켡煬ﲀ拗\uec73澽闁ᬟ芣ࣱ踈㑄", -284644485));
      String var8 = this.hod.isEmpty()
         ? wap.s(
            a.d("\ue263鯰ᄨ轈҆舾㡻뇙⿀ꕸ⊶\ud895嘖쾻䗩쌂礞\uf68c氽\uea79掟\u19cc靷\u0cbb諏G릵㟷괗⬃ꃿ帯퐮䶋쯄䅸ﻪ瓌\uf209殠", -314374952, 1701308126),
            a.b("䶥㐶뻯⃩ꭆⷴ鎿ḣ聳ા赪猂紐恴\uea55泓횚奆쎋䖢챕눜㣎ꍤ┟꾰ᙽ鰲˚蒊\u0f48\uf1e4篖\ue22a摺\ueec5", 1154304413)
         )
         : wap.s(
            a.b("ᇍ桚\ue282粪\uf73c熂쯐䈺\udc79囅턁⬢ꖻ㰅뙚ィ誩Է龙ᦚ逾\uea79擛＊票\uf3be䨄", 941035906),
            a.b("榓ဃ髑ӟ轶ৈ돩㩢ꑆ⺀굆匣\udd80䐲츑䣭\uf2a9祭\ue7c3憟\ue86f鈻\u1c8a蝖Ĭ诰㙖밟⛫ꂹ⼒헞徜옜䁌쫿畖＠称\ue038", 714042788)
         );
      irr.CARD_TITLE.drawCentered(var1, var7, var2, irr.CARD_TITLE.centerTop(var3 + 28.0F), iov.textDim);
      irr.SUBTITLE.drawCentered(var1, var8, var2, irr.SUBTITLE.centerTop(var3 + 40.0F), iov.textMuted);
      uut.popAlpha();
   }

   void hrf(DrawContext var1, float var2, float var3) {
      hjg var4 = null;
      if (this.canHover() && this.hne == null && irr.inside(var2, var3, 136.0F, 46.0F, 404.0F, 363.0F)) {
         for (hjg var6 : this.hmb) {
            if (var6.headerHovered(var2, var3)) {
               var4 = var6;
               break;
            }
         }
      }

      long var19 = System.currentTimeMillis();
      if (var4 != this.hns) {
         this.hns = var4;
         this.hnt = var19;
      }

      if (var4 != this.hnv) {
         this.hnv = null;
      }

      boolean var7 = var4 != null && var4 != this.hnv && var19 - this.hnt >= 350L;
      if (var7 && var4 != this.hnu) {
         this.hnu = var4;
         this.hnr.set(0.0F);
      }

      float var8 = vcq.outCubic(this.hnr.step(var7 && var4 == this.hnu, this.hop));
      if (this.hnu != null && !(var8 <= 0.01F) && this.hmb.contains(this.hnu)) {
         if (this.hnu != this.hnx || wap.get() != this.hny) {
            this.hnx = this.hnu;
            this.hny = wap.get();
            this.hnw = hrg(this.hnu.description(), 220.0F);
            this.hnz = 0.0F;

            for (String var10 : this.hnw) {
               this.hnz = Math.max(this.hnz, irr.SUBTITLE.width(var10));
            }
         }

         if (!this.hnw.isEmpty()) {
            float var20 = irr.SUBTITLE.height() + 1.5F;
            float var21 = 5.0F;
            float var11 = this.hnz + 14.0F;
            float var12 = this.hnw.size() * var20 + var21 * 2.0F;
            float var13 = Math.max(142.0F, Math.min(534.0F - var11, this.hnu.x + 8.0F));
            float var14 = this.hnu.headBottom() - 2.0F;
            if (var14 + var12 > 403.0F) {
               var14 = this.hnu.y - var12 - 3.0F;
            }

            var14 = Math.max(50.0F, Math.min(403.0F - var12, var14));
            float var15 = iov.r(6.0F);
            uut.pushAlpha(var8);
            var1.getMatrices().pushMatrix();
            var1.getMatrices().translate(0.0F, (1.0F - var8) * -3.0F);
            uut.shadow(var1, var13, var14 + 2.0F, var11, var12, var15, 12.0F, iov.shadow);
            hyv.surface(
               var1,
               var13,
               var14,
               var11,
               var12,
               var15,
               hyv.tint(iov.window, Math.min(1.0F, iov.windowTint() + 0.08F)),
               ujt.withAlpha(iov.cardHover, 250),
               6.0F,
               hyv.POPUPS
            );
            uut.outline(var1, var13, var14, var11, var12, var15, 1.0F, iov.stroke);
            int var16 = ujt.lerp(iov.textDim, iov.text, 0.6F);

            for (int var17 = 0; var17 < this.hnw.size(); var17++) {
               float var18 = var14 + var21 + var20 * (var17 + 0.5F);
               irr.SUBTITLE.draw(var1, this.hnw.get(var17), var13 + 7.0F, irr.SUBTITLE.centerTop(var18), var16);
            }

            var1.getMatrices().popMatrix();
            uut.popAlpha();
         }
      }
   }

   static List<String> hrg(String var0, float var1) {
      ArrayList var2 = new ArrayList();
      if (var0 != null && !var0.isBlank()) {
         for (String var6 : var0.split(a.d("秐", 289488599, 865879820))) {
            StringBuilder var7 = new StringBuilder();

            for (String var11 : var6.trim().split(a.b("敄᳚陑", 1657038107))) {
               if (!var11.isEmpty()) {
                  if (!var7.isEmpty() && irr.SUBTITLE.width(var7 + a.d("\uf6e6", -1051700899, 32155546) + var11) > var1) {
                     var2.add(irr.SUBTITLE.ellipsize(var7.toString(), var1));
                     var7.setLength(0);
                  }

                  if (!var7.isEmpty()) {
                     var7.append(' ');
                  }

                  var7.append(var11);
               }
            }

            if (!var7.isEmpty()) {
               var2.add(irr.SUBTITLE.ellipsize(var7.toString(), var1));
            }
         }

         return var2;
      } else {
         return var2;
      }
   }

   void hrh(DrawContext var1) {
      boolean var2 = this.hnf != null || System.currentTimeMillis() < this.hnl;
      float var3 = vcq.outCubic(this.hmn.step(var2, this.hop));
      if (!(var3 <= 0.01F)) {
         String var4 = this.hnf != null ? this.hng : this.hni;
         vhz var5 = this.hnf != null ? vhz.KEYBOARD : this.hnj;
         boolean var6 = this.hnf == null && this.hnk;
         int var7 = var6 ? -1750963 : iov.accent();
         float var8 = Math.min(374.0F, irr.LABEL.width(var4) + 34.0F);
         float var9 = 21.0F;
         float var10 = 136.0F + (404.0F - var8) * 0.5F;
         float var11 = 393.0F - var9 + (1.0F - var3) * 10.0F;
         float var12 = iov.r(7.0F);
         float var13 = 1.0F + 0.05F * this.hmo.step(0.0F, this.hop);
         uut.pushAlpha(var3);
         var1.getMatrices().pushMatrix();
         var1.getMatrices().translate(var10 + var8 * 0.5F, var11 + var9 * 0.5F);
         var1.getMatrices().scale(var13, var13);
         var1.getMatrices().translate(-var8 * 0.5F, -var9 * 0.5F);
         uut.shadow(var1, 0.0F, 0.0F, var8, var9, var12, 12.0F, iov.shadow);
         hyv.surface(
            var1,
            0.0F,
            0.0F,
            var8,
            var9,
            var12,
            hyv.tint(iov.window, Math.min(1.0F, iov.windowTint() + 0.1F)),
            ujt.withAlpha(iov.cardHover, 250),
            var9 * 0.5F,
            hyv.POPUPS
         );
         uut.outline(var1, 0.0F, 0.0F, var8, var9, var12, 1.0F, ujt.withAlpha(var7, 130));
         vjf.draw(var1, var5, 14.0F, var9 * 0.5F, 9.0F, var7);
         irr.LABEL.draw(var1, irr.LABEL.ellipsize(var4, var8 - 32.0F), 24.0F, irr.LABEL.centerTop(var9 * 0.5F), iov.text);
         var1.getMatrices().popMatrix();
         uut.popAlpha();
      }
   }

   @Override
   public boolean mouseClicked(Click click, boolean doubled) {
      if (this.hmx) {
         return true;
      }

      float var3 = this.hpx(click.x());
      float var4 = this.hpy(click.y());
      int var5 = click.button();
      this.hnv = this.hns;
      if (this.hnf != null) {
         if (var5 >= 2 && this.hnf.clearable()) {
            this.hpt(vzz.mouse(var5));
         } else {
            this.hnf = null;
         }

         return true;
      } else if (this.hne != null) {
         if (this.hps()) {
            this.hne.mouseClicked(this, var3, var4, var5);
         }

         return true;
      } else if (this.hpr()) {
         if (!this.hnd.mouseClicked(var3, var4)) {
            this.hnd.close();
         }

         return true;
      } else {
         this.hof = null;
         if (!irr.inside(var3, var4, 0.0F, 0.0F, 540.0F, 409.0F)) {
            return true;
         }

         if (this.hoh.get() > 0.5F && this.hql(var3, var4)) {
            for (int var9 = 0; var9 < hia.SLOTS.length; var9++) {
               String var10 = hia.SLOTS[var9];
               if (var5 == 0 && irr.inside(var3, var4, this.hqj(var9) - 2.0F, this.hqi() + 6.0F, 28.0F, 28.0F)) {
                  if (a.b("౻痒８", -1606874089).equals(var10) && !hia.ownReady()) {
                     evi.refresh();
                  } else {
                     hia.select(var10);
                     hyz.saveLater();
                  }
               }
            }

            return true;
         } else {
            if (this.hoe.mouseClicked(this, var3, var4, var5)) {
               return true;
            }

            if (var5 == 0 && this.hqo(var3, var4)) {
               this.hol.set(1.0F);
               dry.trigger();
               if (this.client != null) {
                  this.client.setScreen(null);
               }

               return true;
            } else if (var5 == 0 && irr.inside(var3, var4, this.hqs(), this.hqv(), 46.0F, 20.0F)) {
               if (this.client != null) {
                  this.client.setScreen(new ida(this));
               }

               return true;
            } else {
               for (int var6 = 0; var6 < this.hlz.size(); var6++) {
                  if (irr.inside(var3, var4, 8.0F, this.hqa(var6), 120.0F, 23.0F)) {
                     this.hrj(var6);
                     return true;
                  }
               }

               if (var5 != 0 || !(var4 < 46.0F) && (!(var3 < 136.0F) || !(var4 < 46.0F))) {
                  if (irr.inside(var3, var4, 136.0F, 46.0F, 404.0F, 363.0F)) {
                     for (hjg var7 : this.hmb) {
                        if (var7.mouseClicked(this, var3, var4, var5)) {
                           return true;
                        }
                     }
                  }

                  return true;
               } else {
                  this.hmz = true;
                  this.hna = (float)click.x() - hlp;
                  this.hnb = (float)click.y() - hlq;
                  return true;
               }
            }
         }
      }
   }

   @Override
   public boolean mouseReleased(Click click) {
      this.hmz = false;
      this.hnc = null;
      return true;
   }

   @Override
   public boolean mouseDragged(Click click, double offsetX, double offsetY) {
      if (this.hmz) {
         hlp = (float)click.x() - this.hna;
         hlq = (float)click.y() - this.hnb;
         this.hpj();
         return true;
      } else if (this.hnc != null) {
         this.hnc.mouseDragged(this.hpx(click.x()), this.hpy(click.y()));
         return true;
      } else {
         return true;
      }
   }

   @Override
   public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
      float var9 = this.hpx(mouseX);
      float var10 = this.hpy(mouseY);
      if (this.hne != null) {
         this.hne.scrolled(verticalAmount);
         return true;
      }

      if (this.hpr()) {
         return true;
      }

      if (irr.inside(var9, var10, 136.0F, 46.0F, 404.0F, 363.0F)) {
         this.hmp -= (float)verticalAmount * 32.0F;
         this.hmr = System.nanoTime();
      }

      return true;
   }

   @Override
   public boolean keyReleased(KeyInput input) {
      if (this.hnf != null && this.hnh != -1 && input.key() == this.hnh) {
         this.hnh = -1;
         this.hpt(input.key());
         return true;
      } else {
         return super.keyReleased(input);
      }
   }

   @Override
   public boolean keyPressed(KeyInput input) {
      int var2 = input.key();
      if (this.hmx) {
         return true;
      }

      if (this.hnf == null) {
         if (this.hpr() && var2 == 256) {
            this.hnd.close();
            return true;
         }

         if (this.hne != null) {
            if (this.hps()) {
               this.hne.keyPressed(this, var2, input.modifiers());
            }

            return true;
         } else if (this.hof != null) {
            if (this.hof == this.hoe && var2 == 256 && !this.hoe.text.isEmpty()) {
               this.hoe.setText("");
               return true;
            } else {
               this.hof.keyPressed(this, var2, input.modifiers());
               return true;
            }
         } else {
            boolean var5 = (input.modifiers() & 2) != 0;
            if (var5 && var2 == 70) {
               this.focus(this.hoe);
               return true;
            }

            if (var2 == 256 || var2 == Flow.getInstance().getOpenGuiKey()) {
               this.close();
               return true;
            }

            if (var2 != 265 && var2 != 264) {
               return true;
            }

            int var4 = hln + (var2 == 265 ? -1 : 1);
            this.hrj((var4 + this.hlz.size()) % this.hlz.size());
            return true;
         }
      } else {
         boolean var3 = var2 == 256 || var2 == 261 || var2 == 259;
         if (var3) {
            if (this.hnf.clearable()) {
               this.hnf.set(-1);
            }

            this.hnf = null;
            return true;
         } else {
            if (this.hnf.clearable() && vzz.isModifier(var2)) {
               this.hnh = var2;
            } else {
               this.hpt(this.hnf.clearable() ? vzz.combo(var2, input.modifiers() | vzz.heldMods(this.client)) : var2);
            }

            return true;
         }
      }
   }

   @Override
   public boolean charTyped(CharInput input) {
      if (!this.hmx && this.hnf == null && this.hof != null && input.isValidChar()) {
         this.hof.charTyped(input.asString());
         return true;
      } else {
         return false;
      }
   }

   void hri(String var1) {
      if (!var1.equals(this.hod)) {
         boolean var2 = this.hod.isEmpty();
         if (var2 && !var1.isEmpty()) {
            this.hpp();
         }

         this.hod = var1;
         hoa = var1;
         this.hpm(true);
         if (var1.isEmpty() && !var2) {
            this.hpq();
         }
      }
   }

   void hrj(int var1) {
      this.hnd = null;
      this.hne = null;
      if (!this.hod.isEmpty()) {
         this.hoe.setText("");
         this.focus(null);
      }

      if (var1 == hln && this.hmd.linear() > 0.0F) {
         this.hpm(false);
      } else {
         this.hpp();
         this.hms = Integer.signum(var1 - hln);
         hln = var1;
         hlo = this.hlz.get(var1).hkw;
         this.hmi.get(var1).set(1.0F);
         this.hpm(true);
         this.hmd.restart();
         this.hpq();
      }
   }

   @Override
   public void close() {
      if (!this.hmx) {
         this.hmx = true;
         lsg.menu(false);
         this.hpp();
         this.hmc.backward();
         this.hof = null;
         this.hnd = null;
         this.hne = null;
         this.hnc = null;
         this.hmz = false;
      }
   }

   @Override
   public void removed() {
      vdn.setRenderScale(1.0F);
      this.hpp();
      ConfigManager.autoSaveLater();
      hyz.saveLater();
   }

   @Override
   public boolean shouldPause() {
      return false;
   }

   @Override
   public boolean shouldCloseOnEsc() {
      return false;
   }
}
