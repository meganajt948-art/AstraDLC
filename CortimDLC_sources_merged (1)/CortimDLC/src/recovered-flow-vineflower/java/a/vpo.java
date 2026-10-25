package a;

import flow.config.ConfigManager;
import flow.dev.a;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.lwjgl.stb.STBVorbis;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.libc.LibCStdlib;

public final class vpo {
   static final List<String> vpp = List.of(
      a.b("Ⲫ唍\udfc9", 1895836894),
      a.b("罁۸谤ቕ", -1964343516),
      a.c(-9902984, "\ue41a鶣\u177f"),
      a.c(342130811, "耞獵獻\ued0f"),
      a.c(-675841240, "筈˻蠯"),
      a.d("ꆷ\ud80e勝", -1995638541, 153704744)
   );
   static final long vpq = 25165824L;
   static final int vpr = 12;
   static final int vps = 12;
   static final Map<String, Object[]> vpt = new HashMap<>();
   static volatile voq vpu;
   static volatile int vpv;
   static boolean vpw;
   static final Set<String> vpx;
   static final int[] vpy;
   static final int[] vpz;
   static final String vqa = a.d(
      "쟣빸㒨꫁⅓\ua7f0ᶮ鑒บ蒮̌滑矑\uea78怤\ue6da峆팋䦢쿨䘕㱓늙⥿꼀◑鱢ሳ裄ຕ蔦篷\uf1b8桉\uee1a撫\udb7c儍ퟞ乯쐰뫁を뜣ⷴꎲᩡ铅ካ西܉\ufdd0瑩\uf620梲\ue6ec崩\udbfc喟젪䛩㲱뭀ㅡꯅ♣鰵᪵邛༮藱ޒ﹀瓼\ueacc愒\ue740巽퐥䩎삦䛋㵢뎨⧕ꀓ⛳颳\u173e贘ப舌簙\uf6d0浨\ueb4a懵\udff6嘫죶䪹섵묃㖠걱⨉ꂮἜ锷៘觪(ﻫ璼\uf332洈\ue39b幤퐍劢쥡䜼㶽믥㘣골⋬餫έ閸౧艷碨６畅\uebde憍\ud85f庎퓸䭅쇸䟄㸽둲⫊ꅷ❋鶡᎓証\u008f蚉紭\uf3ff榣\ue059戗\ud8ae圊촰䯆솒렢㛹ꢐ⭑ꗲᯚ鈽ࡹ躰Ճגּ痳\uec66橚\ue4e4廳핖叨즻䁃㨂날㝬꤈⟜鸚ᐲ雛ಂ蜥緡﮴牎\ue860曒\udd03弒퇕䱼왏볎㫨념⿳ꗺ᱀騙Ⴏ轳đ菝穦\uf422滏\ue49c挩\ud9f3埲쩁䃡욪봡㍆ꦈ…\ua62d᳐鋓ॽ辽\u0590ﱏ犬\ue8e0漈\ue55b寶툰䠨컗䓂㭴놷㞟깂Ⓙ髠ᄐ靁෩葤稛\uf09a盉\ued7d掩\ud9dd偍훰䳰쌝륉㿽뙣Ⱎꊊ\u193d齧ᖟ识Ȑ\uf8be继\uf51d欌\ue1b3堠\ude48咎쬽䅢잜분㐻ꪾ\u20f2ꜝᵉ鏽ਭ聕۩殺眳\uedc7毣\ue224壷튘䵟쯡䇚㱤똅Ⳝ꭪ⅎ龴ᖗ谠\u0af4胰筎\uf1f6瞨\uea49恡\udedf啯퍉䦱잔븭㓻닽ⵗꏼᦳ鑆ሕ裗͵便羚\uf5ca氷\ue2e9墑\udf5c凫쾾䘲㠒뻀㔡ꭟ\u218e须Ḣ郸ຄ蕘Ζ惡灌\uee16擒\ue76d嵞펚䨼쁫䚔㳎덅⦺꿢☑鰈ዦ褡ཅ藋米\uf206泮\uea9b愮\udbe8嗺챘䨛삡뽴㔈럁⸏ꑬ᪔郋\u173c觽ߵ\ufe53瓣\uf2c5椽\ue700巙푯刳쳑䚘㴠뮂ㆍꡙ⚝颮ᬻ鄖࿙艪簳贈璇\uef21旳\ue3f3婙퓲亰알䜏㧜끷⸅ꃋ⍧餭៲趂H蛛碛\uf73d洓\ueba3扵\udc1f囚촙䭋쇈뾔㙜ꣴ⫃ꅆἘ閫ࡣ踚Ðｬ田\uf3be榑\ue024廾퓺坕쵉䏮㩫끂㚏괦⍬香ᾂ陨ಯ苏祁\ufffb熵\ue87b晻\udcd5孮텃侱여렲㫿뒜⼮ꗡ⎱騹ထ躯ŵ茳秅\uf7e5渫\ue4fe抁\udd42埢춲䑋옎룘㝺괅⯒ꆙᰴ雿ಊ譔ǭﾶ癎\ue803準\ue150开헓䱨츫䃆㺀땙㎙궦⁏鹢ᒩ錂ॶ螮繡\uf022盙\ue8ec末\uddf3宾툿䰇용뵿㬄놦⡠\ua63dᲾ髤ᄬ迹\u05f6ﰩ窛\uf0da此\ue576揖\uda6d倸쫓䂊쌥맷㞇\uaa4eⓣꊵ᥅霕ෟ葤اﳔ皿\ued21毾\ue18c塟훤䳍쬲䔋㮸뙹⠚꺶Ⓢ魾ᆣ韟ด蒀竭\uf108睂\uedfb搽\uda10僆흑䴀쎕링〓뛶Ⳳꌟᥖ鿼ᘩ谜ʉ路罥\uf59d毘\ue23a墽\udee1唅쭃䆱㠡빝㒆ꭽ⅏ꞓ᷇鑼દ胏ܹ﵊珡\uea29恒\ue692嵰퍳䦞쿌䙥㲼늞⤝꾰◮鰗ሕ袍༹蕵箅\uf1c5桲\ueea6撝\udb03冹\ud7ae丐쑜뫨ㅪ띪ⶃꏉᨸ郡ᛧ财΄說灜\uf66e泗\ue30f奾\udfc7噺챖䊅㣱뽊㗱ꯏ∴顥ẳ镆\u0b79膇砵\ufe6d瓛\ueac4愄\ue7b9巢푖䨜산䜰㵝뎘⨲ꁫ⛄鲉፼覹࿕蘅簈\uf2b7椶\uef5e斐\udc7f刢좏仅앯뮾㇕ꠍ\u2ef7꒪ᬡ酑ថ蹺С朗烏\uf77d涢\ue3cc婃탾囹촔䍂㧴뀾㘨곗⋕饾ᾤ闒\u0c4e苽磯：畂\uebfc戻\ud84f広퓄䭸쇫䞖㸃뒥⫡ꄐ❁鷹ᑣ訞\u009d蜯絢\uf394槞\ue008暲\udca8卑줜俽옣뱐㊉ꥡ⽑ꖖᯆ鈻ࣥ躥Ոשּ燷\ue82c湕\ue4dd嬍텢垚췉䐾㪯냗㜙귺⏺騪ၒ集ഹ荡禟ￄ瘽\ueca3拑\ud902徠햦䱱쉫뢋㼭딧⮙ꇕᡸ麦ᓀ譍ƺ蟦縒\uf44c檸\ue129束\udd96友쩺䂣웂뵀㎲ꦢ\u200eꙃᳪ錠ढ़迈شﱬ狥\ue8dd漓\ue5a5审툟䡔컼䕡㬜놚⠰깭⒝髙ᄺ鞼\u0df0萄稆\uf0ff眡\ued5e掇\uda73倆",
      -1450911383,
      1527455158
   );

   vpo() {
   }

   public static Path dir() {
      return ConfigManager.gameDir().resolve(a.c(628241496, "㐻䶀읐夹튫")).resolve(a.b("⌄媩큠上엗䍱", -1625480335));
   }

   public static int version() {
      return vpv;
   }

   public static List<String> extras() {
      return vpu.extras();
   }

   public static synchronized boolean scan() {
      ArrayList var0 = new ArrayList();
      StringBuilder var1 = new StringBuilder();
      var0.sort((var0x, var1x) -> {
         int var2 = vqf(var0x).compareToIgnoreCase(vqf(var1x));
         return var2 != 0 ? var2 : vpp.indexOf(vqg(var0x)) - vpp.indexOf(vqg(var1x));
      });

      for (Path var3 : var0) {
         try {
            var1.append(var3.getFileName()).append('|').append(Files.size(var3)).append('|').append(Files.getLastModifiedTime(var3).toMillis()).append('\n');
         } catch (IOException var14) {
            var1.append(var3.getFileName()).append('\n');
         }
      }

      String var15 = var1.toString();
      if (var15.equals(vpu.signature())) {
         return false;
      }

      HashMap var16 = new HashMap();
      ArrayList var4 = new ArrayList();

      for (Path var6 : var0) {
         String var7 = vqf(var6);
         String var8 = vqd(var7);
         Boolean var9 = null;
         if (var8.endsWith(a.d("龒\ue613況", 705246752, 672377326))) {
            var9 = Boolean.TRUE;
            var8 = var8.substring(0, var8.length() - 3);
            var7 = var7.substring(0, var7.length() - 3);
         } else if (var8.endsWith(a.c(-335423594, "ퟍ까⒖뫧"))) {
            var9 = Boolean.FALSE;
            var8 = var8.substring(0, var8.length() - 4);
            var7 = var7.substring(0, var7.length() - 4);
         }

         if (!var8.isEmpty() && !var8.equals(a.b("퉖\uabeeℽ", -1041116614)) && !var8.equals(a.c(719615023, "瑛\u0dfd蜪ᥞ銀ᐹ"))) {
            Object[] var10 = vpt.get(var8);
            String var11 = var7.strip();
            if (var10 != null) {
               var11 = (String)var10[0];
               if (var9 == null) {
                  var9 = (Boolean)var10[1];
               }
            } else if (!var16.containsKey(var8)) {
               if (var4.size() >= 12) {
                  continue;
               }

               var4.add(var11);
            }

            String var12 = var10 != null ? vqd(var11) : var8;
            vow var13 = var16.getOrDefault(var12, new vow(var11, null, null, null));
            var16.put(var12, var13.with(var9, var6));
         }
      }

      var4.sort(String.CASE_INSENSITIVE_ORDER);
      vpu = new voq(var15, Map.copyOf(var16), List.copyOf(var4));
      vpv++;
      if (!var0.isEmpty()) {
         System.out.println(a.b("唔ⲹ꙰㠚돇㔲輧ۙ颃ሻ闾濆\ue10b", -564963990) + var16.keySet());
      }

      return true;
   }

   static vpd find(String var0, boolean var1) {
      vow var2 = vpu.sounds().get(vqd(var0));
      if (var2 == null) {
         return null;
      }

      Path var3 = var1 ? var2.on() : var2.off();
      if (var3 != null) {
         return new vpd(var3, true);
      }

      if (var2.both() != null) {
         return new vpd(var2.both(), false);
      }

      Path var4 = var1 ? var2.off() : var2.on();
      return var4 != null ? new vpd(var4, false) : null;
   }

   public static void openFolder() {
   }

   static String vqd(String var0) {
      return var0.toLowerCase(Locale.ROOT).strip().replace(' ', '_').replace('-', '_');
   }

   static void vqe(String var0, Boolean var1, String... var2) {
      for (String var6 : var2) {
         vpt.putIfAbsent(vqd(var6), new Object[]{var0, var1});
      }
   }

   static String vqf(Path var0) {
      String var1 = var0.getFileName().toString();
      int var2 = var1.lastIndexOf(46);
      return var2 > 0 ? var1.substring(0, var2) : var1;
   }

   static String vqg(Path var0) {
      String var1 = var0.getFileName().toString();
      int var2 = var1.lastIndexOf(46);
      return var2 > 0 ? var1.substring(var2 + 1).toLowerCase(Locale.ROOT) : "";
   }

   static vpi decode(Path var0) {
      try {
         if (Files.size(var0) > 25165824L) {
            throw new IOException(a.c(1262043665, "䉢㯈넛⼥꒰∊顗"));
         } else {
            return decode(Files.readAllBytes(var0));
         }
      } catch (Exception var2) {
         if (vpx.add(var0.getFileName() + a.c(-1445792464, "\uf54d") + var2.getMessage())) {
            System.out.println(a.d("蚗Ｄ痸\uebc0恄\ue6a1岢핏䬝솴䘾", -595427607, -1781467114) + var0.getFileName() + a.b("磎ť", -93030154) + var2.getMessage());
         }

         return null;
      }
   }

   static vpi decode(byte[] var0) throws Exception {
      vpi var1;
      if (vqn(var0, 0, a.d("㝺仐쐌婽", 1510737535, -1430245037)) && vqn(var0, 8, a.d("˓筴\uf1b0濒", 218297335, -439684745))) {
         var1 = vqh(var0);
      } else if (!vqn(var0, 0, a.d("⎝娥탫亅", -556881577, 118327944))
         || !vqn(var0, 8, a.d("清ូ鵠̑", 537474056, -395158968)) && !vqn(var0, 8, a.b("\uddc3ꑺ⺦냒", -1010115194))) {
         if (vqn(var0, 0, a.c(1987347617, "蓆ﵵ瞡\ue9d0"))) {
            var1 = vqj(var0);
         } else {
            if (!vqn(var0, 0, a.d("嗑ⱈꚛ㣞", 1564389092, 1580661630))) {
               throw new IOException(
                  a.b("셓룣㈫갎➮ꄉ\u1b4d鋆ಕ虅ƞﯠ男\uecec暳\ue021婬햺佯쥱䂛㪘둄⾝ꧢ⍔骮ᓸ踒࡙菧紷\uf73d滄\ue8f2扞\uddea垈텔䣪싘뱐㙶놼⭱ꕃᲜ阬ၻ讹ם＊盩\uf0f1樟\ue41a忱\ud93b匇쪡䐀㹆맊", 1946665218)
               );
            }

            var1 = vqk(var0);
         }
      } else {
         var1 = vqi(var0, vqn(var0, 8, a.c(-148082017, "狚ୣ膿Ή")));
      }

      if (var1.data().length == 0) {
         throw new IOException(a.b("\ue3c5驵ჩ軋Ԁ莫㧣뀘⸃ꓻ⌯\ud910垎츢", -1530207323));
      } else {
         return var1;
      }
   }

   static vpi vqh(byte[] var0) throws IOException {
      int var1 = -1;
      int var2 = 0;
      int var3 = 0;
      int var4 = 0;
      int var5 = -1;
      byte var6 = 0;
      int var7 = 12;

      while (var7 + 8 <= var0.length) {
         int var8 = vqp(var0, var7 + 4);
         int var9 = var7 + 8;
         if (vqn(var0, var7, a.d("渑ឫ鵡̈́", 397683529, -1392491206)) && var9 + 16 <= var0.length) {
            var1 = vqo(var0, var9);
            var2 = vqo(var0, var9 + 2);
            var3 = vqp(var0, var9 + 4);
            var4 = vqo(var0, var9 + 14);
            if (var1 == 65534 && var8 >= 26 && var9 + 26 <= var0.length) {
               var1 = vqo(var0, var9 + 24);
            }
         } else if (vqn(var0, var7, a.c(646063297, "⒡崕ퟓ䦷"))) {
            var5 = var9;
            var6 = (byte)(var8 >= 0 && var8 <= var0.length - var9 ? var8 : var0.length - var9);
            break;
         }

         if (var8 < 0 || var8 > var0.length) {
            break;
         }

         var7 = var9 + var8 + (var8 & 1);
      }

      if (var5 >= 0 && var2 > 0 && var3 > 0) {
         return switch (var1) {
            case 1 -> vql(var0, var5, var6, var2, var4, true, false, var4 == 8, var3);
            case 3 -> vql(var0, var5, var6, var2, var4, true, true, false, var3);
            default -> throw new IOException(
               a.d("䋇㭠놤⾣ꐲ⊊飄ᄪ轹ם艚", -1771256324, -1848015001) + var1 + a.b("ᖚ氣\ue6b7磇\uf312疶쾼䘝\ud85e勢픹⽏ꇖ㠗뉗㒨躊Ĕ鮺ᶹ鐈\uee53惣לּ絖\uf7da乺쀱媅\udcd8坪ꦣ⏿먙㱌뚩ष荛", 78452124)
            );
         };
      } else {
         throw new IOException(a.d("軰\uf751綟\ue3ea栳\uee89咔\udd12䍛짽", -471103408, 1877280456));
      }
   }

   static vpi vqi(byte[] var0, boolean var1) throws IOException {
      int var2 = 0;
      int var3 = 0;
      double var4 = 0.0;
      String var6 = a.b("ঋ瀻\ufae9撓", -10876479);
      int var7 = -1;
      int var8 = 0;
      int var9 = 12;

      while (var9 + 8 <= var0.length) {
         int var10 = vqr(var0, var9 + 4);
         int var11 = var9 + 8;
         if (vqn(var0, var9, a.b("怑\u19ac鍽ഌ", -1331077034)) && var11 + 18 <= var0.length) {
            var2 = vqq(var0, var11);
            var3 = vqq(var0, var11 + 6);
            var4 = vqt(var0, var11 + 8);
            if (var1 && var11 + 22 <= var0.length) {
               var6 = new String(var0, var11 + 18, 4, StandardCharsets.ISO_8859_1);
            }
         } else if (vqn(var0, var9, a.b("ᕊ泻\ue635硎", -1965157091)) && var11 + 8 <= var0.length) {
            int var12 = vqr(var0, var11);
            var7 = var11 + 8 + Math.max(0, var12);
            var8 = Math.max(0, Math.min(var10 - 8 - Math.max(0, var12), var0.length - var7));
         }

         if (var10 < 0 || var10 > var0.length) {
            break;
         }

         var9 = var11 + var10 + (var10 & 1);
      }

      if (var7 >= 0 && var2 > 0 && !(var4 <= 0.0)) {
         int var13 = (int)Math.round(var4);

                  if (java.util.Objects.equals(var6, a.d("ᇔ桤\ue2b6糌", 810014142, 1535755296), a.c(1049836232, "㪸䌊직垬"))) {
            return vql(var0, var7, var8, var2, var3, false, false, false, var13);
         }
         else if (java.util.Objects.equals(var6, a.c(-750946055, "碎ģ诨ᖚ"))) {
            return vql(var0, var7, var8, var2, var3, true, false, false, var13);
         }
         else if (java.util.Objects.equals(var6, a.d("蛳ｈ痄\uebb4", 1408371962, -257324437), a.b("㈘䮣섏彿", -1269550502))) {
            return vql(var0, var7, var8, var2, 32, false, true, false, var13);
         }
         else if (java.util.Objects.equals(var6, a.b("Ṋ柱\ued78猋", -649519576), a.c(-426492421, "㶹䐂캫僘"))) {
            return vql(var0, var7, var8, var2, 64, false, true, false, var13);
         }
         else if (java.util.Objects.equals(var6, a.d("\ue9c2遷᪨蒌", -38802511, -1615658466))) {
            return vqm(var0, var7, var8, var2, var13);
         }
         else {
            throw new IOException(a.d("菕𤋮炰\ueec4数\ue3c6", -776412564, 704078334) + var6 + a.c(-532476311, "๚矶﴿挍\ue8d6湦퐭巏쎇䤰캷㒏멅⎠ꦧ⽍镍\u1aeb聎؈"));
         }
      } else {
         throw new IOException(a.c(839068523, "⬂劣\ud86d䘘췁䭻\uf166磶\ue6a1氟\uebcc"));
      }
   }

   static vpi vqj(byte[] var0) throws IOException {
      double var1 = 0.0;
      String var3 = "";
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      int var7 = -1;
      int var8 = 0;
      int var9 = 8;

      while (var9 + 12 <= var0.length) {
         long var10 = vqs(var0, var9 + 4);
         int var12 = var9 + 12;
         if (vqn(var0, var9, a.c(-1783213966, "倒⦢ꍧ㴆")) && var12 + 32 <= var0.length) {
            var1 = Double.longBitsToDouble(vqs(var0, var12));
            var3 = new String(var0, var12 + 8, 4, StandardCharsets.ISO_8859_1);
            var4 = vqr(var0, var12 + 12);
            var5 = vqr(var0, var12 + 24);
            var6 = vqr(var0, var12 + 28);
         } else if (vqn(var0, var9, a.d("\ue51d鲩ᙯ蠋", -86101395, 1910560528))) {
            var7 = var12 + 4;
            long var13 = var10 < 0L ? var0.length - var7 : var10 - 4L;
            var8 = (int)Math.max(0L, Math.min(var13, var0.length - var7));
            if (var10 < 0L) {
               break;
            }
         }

         if (var10 < 0L || var10 > var0.length) {
            break;
         }

         var9 = var12 + (int)var10;
      }

      if (var7 >= 0 && var5 > 0 && !(var1 <= 0.0)) {
         int var15 = (int)Math.round(var1);

                  if (java.util.Objects.equals(var3, a.c(1837340961, "饉\ue0e4樤\uf45b"))) {
            return vql(var0, var7, var8, var5, var6, (var4 & 2) != 0, (var4 & 1) != 0, false, var15);
         }
         else if (java.util.Objects.equals(var3, a.d("曉ὼ閣இ", -34549989, -1552438849))) {
            return vqm(var0, var7, var8, var5, var15);
         }
         else {
            throw new IOException(
               a.d("频\ue122毶\uf5e1縱", 323443688, -1692744897) + var3.strip() + a.c(-437898082, "㒭䴁쟈姺툡咑\ueeda朸殺珇\uf440\u0e78育ᥗ鍐ᖺ꾺“몹㳿")
            );
         }
      } else {
         throw new IOException(a.b("鳚\ue57b澵\uf1c0稙ﲣ䚾켬共\udbc7", -1522295630));
      }
   }

   static vpi vqk(byte[] var0) throws IOException {
      ByteBuffer var1 = MemoryUtil.memAlloc(var0.length);

      vpi var26;
      try {
         MemoryStack var2 = MemoryStack.stackPush();

         try {
            var1.put(var0).flip();
            IntBuffer var3 = var2.mallocInt(1);
            IntBuffer var4 = var2.mallocInt(1);
            ShortBuffer var5 = STBVorbis.stb_vorbis_decode_memory(var1, var3, var4);
            if (var5 == null) {
               throw new IOException(a.b("莰﨑烟\ueeaa敳\ue3c9委큊丝쒬", 912884696));
            }

            try {
               int var6 = var3.get(0);
               int var7 = Math.min(2, var6);
               int var8 = Math.min(var5.remaining() / var6, var4.get(0) * 12);
               short[] var9 = new short[var8 * var7];

               for (int var10 = 0; var10 < var8; var10++) {
                  for (int var11 = 0; var11 < var7; var11++) {
                     var9[var10 * var7 + var11] = var5.get(var10 * var6 + var11);
                  }
               }

               var26 = new vpi(var9, var7, var4.get(0));
            } finally {
               LibCStdlib.free(var5);
            }
         } catch (Throwable var24) {
            if (var2 != null) {
               try {
                  var2.close();
               } catch (Throwable var22) {
                  var24.addSuppressed(var22);
               }
            }

            throw var24;
         }

         if (var2 != null) {
            var2.close();
         }
      } finally {
         MemoryUtil.memFree(var1);
      }

      return var26;
   }

   static vpi vql(byte[] var0, int var1, int var2, int var3, int var4, boolean var5, boolean var6, boolean var7, int var8) throws IOException {
      int var9 = (var4 + 7) / 8;
      if (var9 >= 1 && var9 <= 8 && (!var6 || var9 == 4 || var9 == 8)) {
         int var10 = Math.min(2, var3);
         int var11 = Math.min(var2 / (var9 * var3), var8 * 12);
         short[] var12 = new short[var11 * var10];

         for (int var13 = 0; var13 < var11; var13++) {
            for (int var14 = 0; var14 < var10; var14++) {
               int var15 = var1 + (var13 * var3 + var14) * var9;
               long var16 = 0L;

               for (int var18 = 0; var18 < var9; var18++) {
                  int var19 = var0[var15 + (var5 ? var9 - 1 - var18 : var18)] & 255;
                  var16 = var16 << 8 | var19;
               }

               int var22;
               if (var6) {
                  double var23 = var9 == 4 ? Float.intBitsToFloat((int)var16) : Double.longBitsToDouble(var16);
                  var22 = (int)Math.round(Math.max(-1.0, Math.min(1.0, var23)) * 32767.0);
               } else if (var7) {
                  var22 = (int)(var16 - 128L) << 8;
               } else {
                  int var24 = 64 - var9 * 8;
                  long var20 = var16 << var24 >> var24;
                  var22 = var9 >= 2 ? (int)(var20 >> var9 * 8 - 16) : (int)(var20 << 8);
               }

               var12[var13 * var10 + var14] = (short)var22;
            }
         }

         return new vpi(var12, var10, var8);
      } else {
         throw new IOException(var4 + a.d("祈莰२霄ᲇ驥․꧙㞛봶㫬삋", -2090071957, 868807172));
      }
   }

   static vpi vqm(byte[] var0, int var1, int var2, int var3, int var4) {
      int var5 = 34 * var3;
      int var6 = Math.min(var2 / var5, (var4 * 12 + 63) / 64);
      int var7 = Math.min(2, var3);
      short[] var8 = new short[var6 * 64 * var7];

      for (int var9 = 0; var9 < var6; var9++) {
         for (int var10 = 0; var10 < var7; var10++) {
            int var11 = var1 + var9 * var5 + var10 * 34;
            int var12 = (var0[var11] & 255) << 8 | var0[var11 + 1] & 255;
            int var13 = (short)(var12 & 65408);
            int var14 = Math.min(88, var12 & 127);

            for (int var15 = 0; var15 < 64; var15++) {
               int var16 = var0[var11 + 2 + var15 / 2] & 255;
               int var17 = (var15 & 1) == 0 ? var16 & 15 : var16 >> 4;
               int var18 = vpy[var14];
               int var19 = var18 >> 3;
               if ((var17 & 4) != 0) {
                  var19 += var18;
               }

               if ((var17 & 2) != 0) {
                  var19 += var18 >> 1;
               }

               if ((var17 & 1) != 0) {
                  var19 += var18 >> 2;
               }

               int var20 = var13 + ((var17 & 8) != 0 ? -var19 : var19);
               var13 = Math.max(-32768, Math.min(32767, var20));
               var14 = Math.max(0, Math.min(88, var14 + vpz[var17]));
               var8[(var9 * 64 + var15) * var7 + var10] = (short)var13;
            }
         }
      }

      return new vpi(var8, var7, var4);
   }

   static boolean vqn(byte[] var0, int var1, String var2) {
      if (var1 + 4 > var0.length) {
         return false;
      }

      for (int var3 = 0; var3 < 4; var3++) {
         if (var0[var1 + var3] != (byte)var2.charAt(var3)) {
            return false;
         }
      }

      return true;
   }

   static int vqo(byte[] var0, int var1) {
      return var0[var1] & 0xFF | (var0[var1 + 1] & 0xFF) << 8;
   }

   static int vqp(byte[] var0, int var1) {
      return vqo(var0, var1) | vqo(var0, var1 + 2) << 16;
   }

   static int vqq(byte[] var0, int var1) {
      return (var0[var1] & 0xFF) << 8 | var0[var1 + 1] & 0xFF;
   }

   static int vqr(byte[] var0, int var1) {
      return vqq(var0, var1) << 16 | vqq(var0, var1 + 2);
   }

   static long vqs(byte[] var0, int var1) {
      return (long)vqr(var0, var1) << 32 | vqr(var0, var1 + 4) & 4294967295L;
   }

   static double vqt(byte[] var0, int var1) {
      int var2 = (var0[var1] & 127) << 8 | var0[var1 + 1] & 255;
      long var3 = 0L;

      for (int var5 = 0; var5 < 8; var5++) {
         var3 = var3 << 8 | var0[var1 + 2 + var5] & 0xFF;
      }

      if (var2 == 0 && var3 == 0L) {
         return 0.0;
      }

      double var7 = (var3 >>> 1) * Math.pow(2.0, var2 - 16383 - 62);
      return (var0[var1] & 128) != 0 ? -var7 : var7;
   }

   static {
      for (String var1 : voa.BUILT_IN) {
         vqe(var1, null, vqd(var1));
      }

      vpu = new voq(null, Map.of(), List.of());
      vpx = Collections.synchronizedSet(new HashSet<>());
      vpy = new int[]{
         7,
         8,
         9,
         10,
         11,
         12,
         13,
         14,
         16,
         17,
         19,
         21,
         23,
         25,
         28,
         31,
         34,
         37,
         41,
         45,
         50,
         55,
         60,
         66,
         73,
         80,
         88,
         97,
         107,
         118,
         130,
         143,
         157,
         173,
         190,
         209,
         230,
         253,
         279,
         307,
         337,
         371,
         408,
         449,
         494,
         544,
         598,
         658,
         724,
         796,
         876,
         963,
         1060,
         1166,
         1282,
         1411,
         1552,
         1707,
         1878,
         2066,
         2272,
         2499,
         2749,
         3024,
         3327,
         3660,
         4026,
         4428,
         4871,
         5358,
         5894,
         6484,
         7132,
         7845,
         8630,
         9493,
         10442,
         11487,
         12635,
         13899,
         15289,
         16818,
         18500,
         20350,
         22385,
         24623,
         27086,
         29794,
         32767
      };
      vpz = new int[]{-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
   }
}
