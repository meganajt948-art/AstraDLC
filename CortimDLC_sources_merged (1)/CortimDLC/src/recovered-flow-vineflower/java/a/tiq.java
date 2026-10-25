package a;

import flow.dev.a;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public final class tiq {
   public static final String[] STAND_MODES = new String[]{
      a.c(1448350795, "ᐅ涐\ue752"),
      a.d("쥋냋㨈ꑰ", -1386301318, -1696042639),
      a.d("\uf68a輜\u05c9鮫ၻ雉", 95415482, 1708923493),
      a.c(-1277893349, "\ue554鳚ᘑ衽Σ"),
      a.b("ፐ櫗\ue009繿", -1004530941),
      a.b("⊑嬇퇉侽쑪", -1697504569)
   };
   public static final String[] QUALITIES = new String[]{a.b("쿤뙲㲳ꋅ", 284151718), a.b("Ⅾ壾툰䱞입䄹", 1386422566), a.b("訄\uf399祓", -1195079094)};
   public static final String[] SIZES = new String[]{a.c(1516049024, "ዖ歙\ue186翺\uf42d"), a.c(311310460, "㠷䆮쭼唀\udecb塢"), a.c(1029090452, "곝핁征쇥䨰")};
   public static final String[] PURPOSES = new String[]{
      a.d("伢㚻뱬", 2146427560, -1210470968), a.b("舫ﮮ煺\uef18", -1961196946), a.c(902521595, "抲ᬧ釳ྉ"), a.c(1198959546, "ꯩ퉮墰웆")
   };
   public static final int[] BOOSTS = new int[]{0, 10, 20};
   public static final String AIM = a.b("⚑弨헿", -466737421);
   public static final String AURA = a.b("墟℺\uabee㖌", -281454342);
   public static final String MINE = a.d("䯔㉡뢵⛏", -748936263, -1389926396);
   public static final String WALK = a.b("寞≹ꢧ㛑", 318790573);
   private static final String tir = a.b("쉻믁\u3102꽴Ⓘꉎᡚ醬\u0ff9蕉ʇ", 335069726);
   private static final String tis = a.b("㿏䙵첶勀\ud90a忺\ue5f7汘", -544653399);
   private static final String[] tit = new String[]{a.c(457859688, "戆᮲酴༐蒈ɤ렰㇔꾇┫")};
   private static final Map<String, tiq> tiu = new LinkedHashMap<>();
   private static boolean tiv;
   public final String name;
   private final Properties tiw = new Properties();
   private final Map<String, tmh> tix = new LinkedHashMap<>();
   private final Map<String, tvc> tiy = new LinkedHashMap<>();
   private final Map<String, tzs> tiz = new LinkedHashMap<>();
   private final Map<String, tin> tja = new LinkedHashMap<>();
   private final Set<String> tjb = new HashSet<>();
   private volatile List<eyg> tjc = List.of();
   private volatile long tjd;
   private volatile boolean tje;
   private volatile int tjf = -1;
   private volatile int tjg;
   private volatile boolean tjh;
   private volatile CompletableFuture<Void> tji;

   private tiq(String var1, String var2) {
      this.name = var1;
      if (var2 != null && !var2.isEmpty()) {
         try {
            this.tiw.load(new StringReader(var2));
         } catch (IOException var7) {
         }
      }

      for (String var6 : tit) {
         this.tiw.remove(var6);
      }

      this.tja.put(a.b("⅘壡툶", -616750790), new tin());
      this.tja.put(a.d("邟\ue93a揮ﶌ", -37485955, 1229820551), new tin());
      this.tja.put(a.c(-1575776998, "赳\uf4c6縒\ue068"), new tin());
      this.tja.put(a.b("䋋㭬놲⿄", -498449736), new tin());
   }

   public static synchronized List<tiq> list() {
      tjl();
      ArrayList var0 = new ArrayList<>(tiu.values());
      var0.sort(Comparator.<tiq>comparingLong(var0x -> var0x.getLong(a.d("ꨅ펥奡윔䳖쩶瀤", -283848049, 851540206), 0L)).thenComparing(var0x -> var0x.name));
      return var0;
   }

   public static synchronized tiq open(String var0) {
      if (var0 != null && !var0.isBlank()) {
         tjl();
         return tiu.get(var0);
      } else {
         return null;
      }
   }

   private static void tjl() {
      if (!tiv) {
         tiv = true;
         String var0 = ewk.get(a.b("䀫㦑덒ⴤꛮ„騊ᏼ趩ܙ胗", 920731726));
         if (var0 != null) {
            for (String var4 : var0.split(a.d("醙", -1670556772, 45197651))) {
               String var5 = var4.trim();
               if (!var5.isEmpty() && !tiu.containsKey(var5)) {
                  String var6 = ewk.get(a.b("\uf84c臶ଵ镃ẉ项≴ꯛ", -582027222) + var5);
                  if (var6 != null && !var6.isEmpty()) {
                     tiu.put(var5, new tiq(var5, var6));
                  }
               }
            }
         }
      }
   }

   private static void tjm() {
      ewk.put(a.c(1661195665, "헴걎⚍룻㌱뗁࿕蘣ᡶ鋆ᔈ"), String.join(a.d("⻟", -669535535, -330130427), tiu.keySet()));
   }

   public static String clean(String var0) {
      StringBuilder var1 = new StringBuilder();

      for (char var5 : var0.trim().toCharArray()) {
         if (Character.isLetterOrDigit(var5) || var5 == ' ' || var5 == '-' || var5 == '_') {
            var1.append(var5);
         }
      }

      String var6 = var1.toString().trim();
      return var6.length() > 24 ? var6.substring(0, 24).trim() : var6;
   }

   public static synchronized tiq create(String var0) throws IOException {
      String var1 = clean(var0);
      if (var1.isEmpty()) {
         throw new IOException(a.d("裎\uf177箹\ue5cc渖", -2025652906, 599356920));
      }

      tjl();
      if (tiu.containsKey(var1)) {
         throw new IOException(a.c(-524366033, "콌뛠㰢ꉉ⦙꼯"));
      }

      tiq var2 = new tiq(var1, null);
      var2.set(a.b("⤬傌\uda48䐽쿿䥟\uf30d", -1691080376), System.currentTimeMillis());
      var2.id();
      tiu.put(var1, var2);
      tjm();
      var2.saveNow();
      return var2;
   }

   public static synchronized void delete(tiq var0) throws IOException {
      if (var0 != null && tiu.remove(var0.name) != null) {
         tjm();
         ewk.put(a.c(-1995015756, "秒h誫ᓝ鼗᧧ꏪ⩅") + var0.name, "");
         String var1 = var0.id();
         eyn.delete(null, a.d("勮⬀", 1275229792, -1100208900) + var1 + a.c(683397036, "쾂")).exceptionally(var0x -> false);
         eyn.delete(null, a.c(1788165606, "㶖䑺") + var1 + a.d("⟹", 709960583, -230947760)).exceptionally(var0x -> false);
         synchronized (var0) {
            var0.tix.clear();
            var0.tiy.clear();
            var0.tiz.clear();
         }
      }
   }

   public synchronized String id() {
      String var1 = this.tiw.getProperty(a.c(646700316, "\udd77\ua4cb"));
      if (var1 == null || !var1.matches(a.b("鿈\ue612泜\uf2b9礶ￋ䗓찙剠\ud89b彋ꕵ", -133193825))) {
         var1 = String.format(Locale.ROOT, a.c(2140544107, "\u1c4b旯\uef3d煏㮝"), new SecureRandom().nextLong() & 281474976710655L);
         this.tiw.setProperty(a.c(-680354530, "鵵\ue4c9"), var1);
         this.save();
      }

      return var1;
   }

   public String purpose() {
      String var1 = this.get(a.b("ꇺ\ud84e劚쳩䜡소築", 1575461261), a.c(-510745178, "ꗤ\udc7d嚪"));
      return var1.equalsIgnoreCase(a.b("ų磶\uf222汀", -70319818))
         ? a.d("壐⅕ꮁ㗣", 1023131792, -1668114427)
         : (
            var1.equalsIgnoreCase(a.b("䶕㐀뻔₮", 1234128348))
               ? a.d("ۇ罒\uf586毼", 1264114334, 356572176)
               : (var1.equalsIgnoreCase(a.d("क़烟度摷", 352925755, 1488531760)) ? a.c(-1518855434, "᪥挢\ue9fc瞊") : a.c(-1900459237, "䭙㋀렗"))
         );
   }

   public boolean aura() {
      return this.purpose().equals(a.b("픩견♸렚", -477506196));
   }

   public boolean mine() {
      return this.purpose().equals(a.b("㒀䴕쟁妻", -1416809271));
   }

   public boolean walk() {
      return this.purpose().equals(a.d("ٹ翾\uf520歖", 742740286, -422291692));
   }

   public String kind() {
      return this.aura()
         ? a.d("끵짐䌄\udd66", 1376639233, -255694575)
         : (this.mine() ? a.c(1890417392, "窙̬觸គ") : (this.walk() ? a.d("삜뤻㏥궓", -739278935, 1197850438) : a.c(-1145304177, "௭牔\uf883")));
   }

   public synchronized List<tzs> walkTapes() {
      return new ArrayList<>(this.tiz.values());
   }

   public synchronized void putWalkTape(String var1, tzs var2) {
      this.tiz.put(var1, var2);
   }

   public void uploadWalkTape(String var1, tzs var2) {
      LinkedHashMap var3 = new LinkedHashMap();
      var3.put(a.c(-1565600200, "홗꿤┰뭋"), a.c(-196229532, "옗뾰㕮\uab18"));
      var3.put(a.b("闖\uec65暫\uf8d3猋\uf5bf俥", 1828361633), this.name);
      var3.put(a.d("‖妺퍣䴚웕", -118673187, -2126966598), String.valueOf(var2.ticks.size()));
      var3.put(a.d("슊묶\u31ea꾐\u2451", 1908193975, 1012168788), String.valueOf(var2.lanes.size()));
      this.tjn(a.d("␠巌", 1138090501, 1248904789) + this.id() + a.b("㵌", 378092898) + var1, var2::bytes, var3);
   }

   public synchronized List<tvc> mineTapes() {
      return new ArrayList<>(this.tiy.values());
   }

   public synchronized void putMineTape(String var1, tvc var2) {
      this.tiy.put(var1, var2);
   }

   public synchronized List<tmh> tapes() {
      return new ArrayList<>(this.tix.values());
   }

   public synchronized void putTape(String var1, tmh var2) {
      this.tix.put(var1, var2);
   }

   public void uploadTape(String var1, tmh var2) {
      LinkedHashMap var3 = new LinkedHashMap();
      var3.put(a.c(763723078, "紩Қ蹎ဵ"), a.d("趫\uf40f绍\ue0a9", -9721957, -1193530816));
      var3.put(a.b("䢿ㄌ믂►깢⣖銌", -125744952), this.name);
      var3.put(a.b("\ue5cd鱡ᚸ裁̎", 1365501372), String.valueOf(var2.ticks.size()));
      this.tjn(a.d("췲됞", -607764113, -527201043) + this.id() + a.d("仗", -1829497613, -1688380918) + var1, var2::bytes, var3);
   }

   public void uploadMineTape(String var1, tvc var2) {
      LinkedHashMap var3 = new LinkedHashMap();
      var3.put(a.c(848136781, "訢\uf391祅\ue73e"), a.d("趸\uf40d给\ue0a3", 2140676203, -1379029574));
      var3.put(a.b("Ꝭ\udedf向쩩䆱윅絟", 1694476059), this.name);
      var3.put(a.c(-1023636954, "詗\uf3fb礢\ue75b沔"), String.valueOf(var2.ticks.size()));
      var3.put(a.b("搄ᶴ靺ऌ", -1491049368), String.valueOf(var2.hits.size()));
      this.tjn(a.d("醈\ue864", 1458554316, -1267575756) + this.id() + a.b("蚧", 1821148809) + var1, var2::bytes, var3);
   }

   private void tjn(String var1, tij var2, Map<String, String> var3) {
      if (eyn.online()) {
         CompletableFuture.runAsync(() -> {
            try {
               byte[] var3x = var2.get();
               eyn.put(var1, var3x, var3).exceptionally(var0x -> false);
            } catch (IOException var4) {
            }
         });
      }
   }

   public void prefetch() {
      this.loadRecordings(false);
      this.refreshVersions(false);
   }

   public int recordingsTotal() {
      return this.tjf;
   }

   public int recordingsLoaded() {
      return this.tjg;
   }

   public boolean recordingsLoading() {
      return this.tjh;
   }

   public void loadRecordings(boolean var1) {
      CompletableFuture var2;
      synchronized (this) {
         if (this.tji == null || this.tji.isCompletedExceptionally()) {
            if (!eyn.online()) {
               return;
            }

            this.tjh = true;
            String var4 = a.b("嶒⑾", -375366174) + this.id() + a.d("菱", -1101908915, 1980681531);
            this.tji = eyn.list(var4).thenCompose(var2x -> {
               this.tjf = var2x.size();
               ArrayList var3 = new ArrayList();

               for (eyg var5 : var2x) {
                  String var6x = var5.key().substring(var4.length());
                  synchronized (this) {
                     if (this.tix.containsKey(var6x) || this.tiy.containsKey(var6x) || this.tiz.containsKey(var6x) || !this.tjb.add(var6x)) {
                        this.tjg++;
                        continue;
                     }
                  }

                  boolean var7 = a.b("乭㟘봌⍶", -118731260).equals(var5.meta().get(a.b("ꮀ툳壧욜", -1546867729)));
                  boolean var8 = a.d("Ԑ粷\uf669栟", -1482623788, 1593831863).equals(var5.meta().get(a.c(1178722652, "\ue133颀ቔ谯")));
                  var3.add(eyn.get(var5.key()).thenAccept(var4x -> {
                     try {
                        if (var7) {
                           tvc var5x = tvc.read(new ByteArrayInputStream(var4x));
                           synchronized (this) {
                              this.tiy.putIfAbsent(var6x, var5x);
                           }
                        } else if (var8) {
                           tzs var14 = tzs.read(new ByteArrayInputStream(var4x));
                           synchronized (this) {
                              this.tiz.putIfAbsent(var6x, var14);
                           }
                        } else {
                           tmh var15 = tmh.read(new ByteArrayInputStream(var4x));
                           synchronized (this) {
                              this.tix.putIfAbsent(var6x, var15);
                           }
                        }
                     } catch (IOException | RuntimeException var13) {
                     }

                     this.tjg++;
                  }).exceptionally(var0 -> null));
               }

               return CompletableFuture.allOf(var3.toArray(new CompletableFuture[0]));
            }).whenComplete((var1x, var2x) -> this.tjh = false);
         }

         var2 = this.tji;
      }

      if (var1) {
         try {
            var2.get(180L, TimeUnit.SECONDS);
         } catch (Exception var6) {
         }
      }
   }

   public List<eyg> versions() {
      return this.tjc;
   }

   public boolean versionsLoading() {
      return this.tje;
   }

   public void refreshVersions(boolean var1) {
      long var2 = System.currentTimeMillis();
      if (!this.tje && (var1 || var2 - this.tjd >= 30000L) && eyn.online()) {
         this.tje = true;
         this.tjd = var2;
         eyn.list(a.c(1357005596, "䍮㪀")).whenComplete((var1x, var2x) -> {
            if (var1x != null) {
               ArrayList var3 = new ArrayList<>((Collection<? extends eyg>)var1x);
               var3.sort(Comparator.comparingLong(eyg::uploaded).reversed());
               this.tjc = var3;
            }

            this.tje = false;
         });
      }
   }

   public boolean ownVersion(eyg var1) {
      return var1.key().startsWith(a.b("귁퐯", 790212019) + this.id() + a.c(1260879211, "絅"));
   }

   public String activeKey(String var1) {
      return this.get(a.b("楘ძ騳у辝८", 1089431859) + var1, "");
   }

   public synchronized tik cloud(String var1) {
      return this.tja.get(var1).cloud;
   }

   public void useVersion(eyg var1) {
      String var2 = var1.meta().getOrDefault(a.c(1188281822, "붱쐂他킭"), this.kind());
      if (this.ownVersion(var1)) {
         this.set(a.b("딲첁䙙\ud829号프", -1615940263) + var2, var1.key());
         this.save();
         synchronized (this) {
            tin var4 = this.tja.get(var2);
            if (var4 != null) {
               var4.key = null;
               var4.cloud = tik.SAVED;
            }
         }
      } else {
         eyn.get(var1.key())
            .thenAccept(
               var3 -> {
                  String var4x = a.d("\u31ed䠃", -1017956678, -1077278939)
                     + this.id()
                     + a.d("㖵", 370849568, 532710075)
                     + var2
                     + a.c(1839649552, "팾")
                     + System.currentTimeMillis();
                  LinkedHashMap var5 = new LinkedHashMap<>(var1.meta());
                  var5.put(a.c(-1683324403, "艺\ufbc9焇\uef7f撧\ue213塉"), this.name);
                  var5.put(a.d("硓Ƕ謸ᕋ", -1118507602, 1747621279), var1.meta().getOrDefault(a.b("錔\ueaa7恩︑痉\uf37d䤧", -293235869), ""));
                  eyn.put(var4x, var3, var5).thenAccept(var3x -> {
                     this.set(a.c(-1978569401, "洬ᒟ鹇7诩ച") + var2, var4x);
                     this.save();
                     synchronized (this) {
                        tin var5x = this.tja.get(var2);
                        if (var5x != null) {
                           var5x.key = null;
                           var5x.cloud = tik.SAVED;
                        }
                     }

                     this.refreshVersions(true);
                  });
               }
            )
            .exceptionally(var0 -> null);
      }
   }

   public void deleteVersion(eyg var1) {
      if (this.ownVersion(var1)) {
         String var2 = var1.meta().getOrDefault(a.b("⩒叡\ud935䝎", -1365562819), this.kind());
         if (var1.key().equals(this.activeKey(var2))) {
            this.set(a.c(-37335931, "䳮㕝뾅⇵ꨫⳘ") + var2, "");
            this.save();
            synchronized (this) {
               tin var4 = this.tja.get(var2);
               if (var4 != null) {
                  var4.model = null;
                  var4.key = null;
                  var4.cloud = tik.NONE;
               }
            }
         }

         ArrayList var3 = new ArrayList<>(this.tjc);
         var3.removeIf(var1x -> var1x.key().equals(var1.key()));
         this.tjc = var3;
         eyn.delete(List.of(var1.key()), null).whenComplete((var1x, var2x) -> this.refreshVersions(true));
      }
   }

   public void clearRecordings() throws IOException {
      synchronized (this) {
         this.tix.clear();
         this.tiy.clear();
         this.tiz.clear();
         this.tjb.clear();
         this.tji = null;
         this.tjf = 0;
         this.tjg = 0;
      }

      eyn.delete(null, a.d("灙\u09b5", 1432763628, -46445371) + this.id() + a.d("\uf865", 1543416720, 1262048219)).exceptionally(var0 -> false);
      this.set(a.d("Ɡ\ude1c哒쪤", -980692008, 651129880), 0);
      this.set(a.b("쭈닶㠠ꙉⶏꬩᅭ额", 183028518), 0);
      this.set(a.d("弥⚉걐㈩맦", 267263412, 1969242848), 0);
      this.set(a.b("ና欴\ue1f1羀\uf44d狺좨䅄", -1536748824), 0);
      this.set(a.d("坬⻙ꐍ㩷뇫㜖赋ҹ髪ၓ鞘", -263271357, -1787061431), 0);
      this.set(a.c(201243991, "봴쒁乕퀯害\udd48朚\ueeed炸﨓線螭ॻ郗"), 0);
      this.set(a.d("莿見烞\ueea4攸\ue3d3妝큦丱쒘", 429348554, -196422382), 0);
      this.set(a.d("\u20c2奷펣䷙왅䂾\ufae0猙\ued4a柹\ue02bᩐ钐", -1489106829, 838674641), 0);
      this.set(a.b("딌첹䙭\ud817压핲漦\ue6c4碄\uf23d痯", 1605809514), 0);
      this.set(a.d("驤\ue3c3椝\uf76b糹晴䁜즧埰\udd59", -1127158206, 1505719387), 0);
      this.set(a.b("\ue4b4鴓៍覻ȩ蓛㺀띠⤮ꎈ\u245a", 1436411080), 0);
      this.set(a.b("\uee15鞲ᵬ茚࢈蹥㐫뷀⎞ꤾ\u2efb", -775819671), 0);
      this.set(a.b("㌙䪾쁠帖햄危\ue93d惔ﺖ琤", 2022847332), 0);
      this.save();
   }

   public int mineBoost() {
      int var1 = this.getInt(a.b("❿廊퐞䩤쇸䜅ﵛ璪\ueae9恟", 248784664), 10);
      return var1 >= 20 ? 20 : (var1 >= 10 ? 10 : 0);
   }

   public tck model() {
      return (tck)this.tjo(a.c(1756416358, "줄낽㩪"));
   }

   public tck auraModel() {
      return (tck)this.tjo(a.d("㪳䌖짂垠", -1694031378, 1534270264));
   }

   public tck model(boolean var1) {
      return var1 ? this.auraModel() : this.model();
   }

   public ttb mineModel() {
      return (ttb)this.tjo(a.d("螘︭瓹\uea83", -98668667, 1159719028));
   }

   public txs walkModel() {
      return (txs)this.tjo(a.d("嫘⍿ꦡ㟗", -55819186, -132636955));
   }

   public synchronized String walkIssue() {
      this.tjo(a.d("恻\u19dc錂൴", 1864286154, 1775755202));
      return this.tja.get(a.d("\uf3d7詰®默", 473141132, 1554938920)).issue;
   }

   public synchronized String modelIssue(boolean var1) {
      this.tjo(var1 ? a.b("귂푧庳샑", -568611417) : a.c(-1352913341, "⸡垘\udd4f"));
      return this.tja.get(var1 ? a.c(-1108886205, "봦쒃乗퀵") : a.d("聂炙猬", -1658015775, 433008577)).issue;
   }

   public synchronized String mineIssue() {
      this.tjo(a.c(1436060964, "赍\uf4f8縬\ue056"));
      return this.tja.get(a.d("⠂冷\udb63䔙", 1665687304, 988706659)).issue;
   }

   public synchronized boolean modelLoading(String var1) {
      return this.tja.get(var1).loading;
   }

   private synchronized Object tjo(String var1) {
      tin var2 = this.tja.get(var1);
      String var3 = this.activeKey(var1);
      if (var3.isEmpty() || var3.equals(var2.key) || var2.loading || System.currentTimeMillis() < var2.retryAt) {
         return var2.model;
      }

      if (!eyn.online()) {
         return var2.model;
      }

      var2.loading = true;
      eyn.get(var3)
         .whenComplete(
            (var4, var5) -> {
               Object var6 = null;
               String var7 = "";
               if (var4 != null) {
                  try {
                     var6 = a.b("捼᫉逝\u0e67", -689741035).equals(var1)
                        ? ttb.read(new ByteArrayInputStream(var4))
                        : (a.b("\udf04ꚣⱽ눋", 912318327).equals(var1) ? txs.read(new ByteArrayInputStream(var4)) : tck.read(new ByteArrayInputStream(var4)));
                  } catch (IOException | RuntimeException var11) {
                     var7 = String.valueOf(var11.getMessage()).startsWith(a.d("Ģ碐\uf24b汾\ue7e4慗\udb0f勿첩", -2022362133, 2130129583))
                        ? a.d("臘肔\u0a4f", 147274160, 497271034)
                        : a.c(-184036973, "퇷ꡖ⊘볭㜴놎");
                  }
               } else {
                  var7 = a.d("炫ञ菗ᶦ陫ოꪇ", -1749288695, 635013576);
               }

               synchronized (this) {
                  var2.loading = false;
                  if (var4 == null) {
                     var2.retryAt = System.currentTimeMillis() + 30000L;
                     var2.issue = var7;
                  } else if (var3.equals(this.activeKey(var1))) {
                     var2.key = var3;
                     var2.issue = var7;
                     if (var6 != null) {
                        var2.model = var6;
                        var2.cloud = tik.SAVED;
                     }
                  }
               }
            }
         );
      return var2.model;
   }

   public String dataStamp() {
      long var1 = 0L;
      List var3 = this.tapes();

      for (tmh var5 : var3) {
         var1 += var5.ticks.size();
      }

      return var3.size()
         + a.b("ᆙ", -618917470)
         + var1
         + a.d("\udb71", -1335435073, 39926773)
         + this.clean()
         + a.d("\udb13", -1503161413, 317147283)
         + 60
         + a.b("띛", -37374112)
         + this.purpose();
   }

   public int needSamples() {
      return switch (this.size()) {
         case a.c(1981057923, "试\uf25a碅\ue6f9洮") -> 3000;
         case a.b("荦\ufafa瀺\uee5e斋", -225541329) -> 10000;
         default -> 6000;
      };
   }

   public int needFlicks() {
      return switch (this.size()) {
         case a.d("喚Ⱅꛊ㢶덡", 1381759222, -210064070) -> 60;
         case a.d("\ue6ad鼱ᗱ讕@", -1644740379, -913463807) -> 200;
         default -> 120;
      };
   }

   public int needTracking() {
      return switch (this.size()) {
         case a.c(-788209363, "\ue17b飴ራ豗ހ") -> 1000;
         case a.d("廮❲궲㏖렃", -387769901, 609634164) -> 3500;
         default -> 2000;
      };
   }

   public void saveModel(tck var1, boolean var2) throws IOException {
      LinkedHashMap var3 = new LinkedHashMap();
      var3.put(a.b("禬\u0007諐ᒥ齷\u19cbꎋ⩡됣㺟", -1891337771), String.valueOf(Math.round(var1.similarity)));
      this.tjp(var2 ? a.b("\uebc0鉥ᢱ蛓", -1720390747) : a.d("蟦﹟璈", 223986326, -1290779374), var1, var1.bytes(), var3, var1.created);
   }

   public void saveMineModel(ttb var1) throws IOException {
      LinkedHashMap var2 = new LinkedHashMap();
      var2.put(a.b("㿋䙡청劝", -1957937221), String.valueOf(Math.round(var1.top1)));
      var2.put(a.b("ᱍ旵\uef29煒", -1244914655), String.valueOf(Math.round(var1.hand.similarity)));
      var2.put(a.c(-1786798455, "黡\ue759消\uf3ed"), var1.legs == null ? "" : String.valueOf(Math.round(var1.legsAcc)));
      var2.put(a.d("潣ᛟ鰌ɡ覱", -37230266, 1505658434), String.valueOf(var1.boost));
      this.tjp(a.b("扂\u1bf7鄣ཙ", -2081398229), var1, var1.bytes(), var2, var1.created);
   }

   public void saveWalkModel(txs var1) throws IOException {
      LinkedHashMap var2 = new LinkedHashMap();
      var2.put(a.c(1126803187, "ꚜ\udf23嗬쮗"), String.valueOf(Math.round(var1.keysAcc)));
      var2.put(a.d("榍ွ髩҄", -14755708, -1152798343), String.valueOf(Math.round(var1.yawSim)));
      var2.put(a.b("됪춉䝖\ud93a勱푉渌", 562082910), String.valueOf(var1.samples));
      this.tjp(a.d("쇳롔㊊과", 1375617296, -579501936), var1, var1.bytes(), var2, var1.created);
   }

   private void tjp(String var1, Object var2, byte[] var3, Map<String, String> var4, long var5) {
      String var7 = a.b("䉧㮉", -380026347) + this.id() + a.d("㠝", 188684499, -1589436192) + var1 + a.d("㌈", 1693892526, 548244616) + var5;
      var4.put(a.b("縙ު赾ጅ", -1427734922), var1);
      var4.put(a.c(-849418035, "\ue8ba鄉ᯇ薿\u0e67裓㊉"), this.name);
      var4.put(a.b("\u318f䠯싫岞흜凼\uebae", -1029688853), String.valueOf(var5));
      synchronized (this) {
         tin var9 = this.tja.get(var1);
         var9.model = var2;
         var9.key = var7;
         var9.issue = "";
         var9.loading = false;
         var9.cloud = eyn.online() ? tik.SAVING : tik.NONE;
      }

      if (eyn.online()) {
         eyn.put(var7, var3, var4).whenComplete((var3x, var4x) -> {
            boolean var5x = var3x != null && var3x;
            if (var5x) {
               this.set(a.b("\u05f7籄\uf69c棬\ue332旁", -2000091748) + var1, var7);
               this.save();
            }

            synchronized (this) {
               tin var7x = this.tja.get(var1);
               if (var7.equals(var7x.key)) {
                  var7x.cloud = var5x ? tik.SAVED : tik.FAILED;
               }
            }

            this.refreshVersions(true);
         });
      }
   }

   public String get(String var1, String var2) {
      String var3 = this.tiw.getProperty(var1);
      return var3 == null ? var2 : var3;
   }

   public int getInt(String var1, int var2) {
      try {
         return Integer.parseInt(this.tiw.getProperty(var1, String.valueOf(var2)).trim());
      } catch (NumberFormatException var4) {
         return var2;
      }
   }

   public long getLong(String var1, long var2) {
      try {
         return Long.parseLong(this.tiw.getProperty(var1, String.valueOf(var2)).trim());
      } catch (NumberFormatException var5) {
         return var2;
      }
   }

   public double getDouble(String var1, double var2) {
      try {
         return Double.parseDouble(this.tiw.getProperty(var1, String.valueOf(var2)).trim());
      } catch (NumberFormatException var5) {
         return var2;
      }
   }

   public boolean getBool(String var1, boolean var2) {
      String var3 = this.tiw.getProperty(var1);
      return var3 == null ? var2 : Boolean.parseBoolean(var3.trim());
   }

   public synchronized void set(String var1, Object var2) {
      this.tiw.setProperty(var1, String.valueOf(var2));
   }

   public void add(String var1, long var2) {
      this.set(var1, this.getLong(var1, 0L) + var2);
   }

   public int standCount() {
      return Math.max(1, Math.min(4, this.getInt(a.c(-577448753, "풰괆⟀릾㉣듅໋蝷ᤤ鎏ᑇ\uee2c"), 2)));
   }

   public String standMode() {
      String var1 = this.get(a.c(-1563874357, "⮳刅\ud8c3䚽쵠䯆\uf1c8硺\ue627沝\ueb4f"), a.c(1536221333, "\ue0db饎ᎌ"));

      for (String var5 : STAND_MODES) {
         if (var5.equalsIgnoreCase(var1)) {
            return var5;
         }
      }

      return a.b("꣖텃宁", -1164007272);
   }

   public double standNear() {
      return Math.max(2.0, Math.min(6.0, this.getDouble(a.d("绦ݐ趖Ꮸ頵ẓ꒝\u2d2c델㧍븍", -36564154, 889548248), 2.3)));
   }

   public double standFar() {
      return Math.max(this.standNear(), Math.min(7.0, this.getDouble(a.c(-1411967840, "ᓙ浯\ue7a9秗\uf20a璬캢䜛\ud943叡"), 3.5)));
   }

   public double standSpeed() {
      return Math.max(0.3, Math.min(1.6, this.getDouble(a.c(-1462535373, "筌˺蠼ᙂ鶟ᬹꄷ⢛뛇㱣뮰䇀"), 1.0)));
   }

   public String quality() {
      String var1 = this.get(a.b("戀耧૧钞\u1f4e駴⎰ꨝ㐝뺨㥯쌓䷁푭帳", 1042610667), a.c(-468626219, "咝ⴍꟃ㦭뉶㓊"));

      for (String var5 : QUALITIES) {
         if (var5.equalsIgnoreCase(var1)) {
            return var5;
         }
      }

      return a.b("银\ued66枨阮爝\uf4a1", -1597139778);
   }

   public String size() {
      String var1 = this.get(a.b("ḥ枒\ued52猫\uf8fb繁쐅䶨펪夁\udec1⒯", 460136029), a.c(377851639, "躼\uf725緷\ue38b桀\ueee9"));

      for (String var5 : SIZES) {
         if (var5.equalsIgnoreCase(var1)) {
            return var5;
         }
      }

      return a.d("컓띊㶘ꏤ⠯꺆", -663971051, -1042131571);
   }

   public boolean mirror() {
      return this.getBool(a.d("賉\uf57e羾\ue1c7樗\uecad囩\udf44䅘쯭䰥뙔㢞ꄲ", -1747340207, -487114526), true);
   }

   public boolean clean() {
      return this.getBool(a.d("髛\ue36c榬\uf7d5簅謹䃻쥖坄\uddfa娠ꁕ⺍", 844367052, -1475699090), true);
   }

   public boolean fights() {
      return this.getBool(a.d("ҥ紛\uf7c6榸\ue273擅", -2019782119, -1957062948), false);
   }

   public tmk trainerConfig() {
      tmk var1 = new tmk();

      var1.epochs = switch (this.quality()) {
         case a.b("沒ᔄ鿅Ƴ", -561877808) -> 20;
         case a.c(-1936267523, "\ue6b3鼮ᗤ") -> 70;
         default -> 40;
      };

      var1.members = switch (this.quality()) {
         case a.b("绁ݗ趖Ꮰ", -1716879741) -> 1;
         case a.c(-273186366, "膌\uf811狛") -> 3;
         default -> 2;
      };

      var1.hidden = switch (this.size()) {
         case a.d("覊\uf005竚\ue4a6潱", -332008564, 1855027792) -> 32;
         case a.d("침럴㴴ꍐ⢅", -560761412, -1502233699) -> 80;
         default -> 48;
      };
      var1.mirror = this.mirror();
      var1.track = this.aura();
      var1.dropOvershoot = !var1.track && this.clean();
      var1.threads = Math.max(1, Math.min(4, Runtime.getRuntime().availableProcessors() - 2));
      return var1;
   }

   public void save() {
      String var1 = this.tjr();
      vza.later(a.b("\ua7df\ude65咦쫐䄚쟤緧\uf414橖\ue0ee朲鵆᎘詬", -471095361) + this.name, () -> this.tjq(var1));
   }

   public void saveNow() throws IOException {
      this.tjq(this.tjr());
   }

   private void tjq(String var1) {
      synchronized (tiq.class) {
         if (tiu.get(this.name) == this) {
            ewk.put(a.d("硥ǟ謜ᕪ麠ᡐꉝ⯲", 250720199, 1750390724) + this.name, var1);
         }
      }
   }

   private synchronized String tjr() {
      StringBuilder var1 = new StringBuilder();
      this.tiw
         .stringPropertyNames()
         .stream()
         .sorted()
         .forEach(
            var2 -> var1.append(var2)
               .append('=')
               .append(this.tiw.getProperty(var2).replace(a.b("罙", -1151041788), a.d("贏\uf4be", 405367201, -416750352)))
               .append('\n')
         );
      return var1.toString();
   }

   public String newTapeName() {
      return String.format(Locale.ROOT, a.c(-1063314654, "ᬂ拲\ue868瘑ﶇ"), System.currentTimeMillis(), System.nanoTime() & 65535L);
   }
}
