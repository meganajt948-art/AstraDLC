package a;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import flow.cosmetic.Cosmetics;
import flow.dev.a;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.HexFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.Vec3d;

public final class ucg {
   public static final String DEFAULT_RELAY = new String(
      new char[]{
         'h',
         't',
         't',
         'p',
         's',
         ':',
         '/',
         '/',
         'f',
         'l',
         'o',
         'w',
         '2',
         '-',
         'r',
         'e',
         'l',
         'a',
         'y',
         '.',
         'f',
         'l',
         'o',
         'w',
         '-',
         'c',
         '0',
         'd',
         '8',
         '7',
         '.',
         'w',
         'o',
         'r',
         'k',
         'e',
         'r',
         's',
         '.',
         'd',
         'e',
         'v'
      }
   );
   public static final int MAX_MEMBERS = 8;
   public static final int CODE_LEN = 6;
   public static final String ALPHABET = a.d("\uf4a2贐߂馴ቢ铐⺂ꝼ㤡뎑㑅층䃡\ud94e匜헮澠\ue076竄ﲖ畠༾膌ᩞ鱉ᚙ꼭ⅽ뮉㷙뙥䢵", 1253873194, -2119015703);
   public static final int DANGER = -1096636;
   public static final int[] COLORS = new int[]{-14494738, -340971, -5796870, -11870592, -290244, -757066, -10443270, -1906448};
   public static final vkl ENABLED = new vkl(a.c(-1905978108, "ᕑ泑\ue611硦\uf3bc"), true);
   public static final vmc MARK_TIME = new vmc(a.d("ᓃ浞\ue79e秶\uf26a璏컁䜴\ud963", -1408149912, 1505575663), 20.0, 5.0, 60.0, 1.0).unit(a.b("푱", -1856842749));
   public static final vkl SOUNDS = new vkl(a.c(754926299, "䊎㬃뇊⾠ꑽ⋛"), true);
   public static final vmc VOLUME = new vmc(a.b("\udda2ꐪ\u2efa낒㭝뷤", -86974990), 0.7, 0.05, 1.5, 0.05).percent();
   public static final vkw LISTEN = new vkw(
      a.d("䶗㐃뻊₼ꭺⷀ", -431682840, 1737115445),
      new vkq(a.c(1372051355, "ퟒ깏⒏뫧"), vhz.PIN, () -> ueg(a.c(766393945, "㸍䞅쵑匩"), null)),
      new vkq(a.c(-1986211021, "퍱ꫥ‹빁㖔댲"), vhz.ALERT, () -> ueg(a.b("䬝㊉롕☭그⭞", 1254050655), null)),
      new vkq(a.b("\uece2镯ᾱ臘ਓ貵", 383118516), vhz.COMBAT, () -> ueg(a.d("㩣䏱줮块", -1432095208, 1896270899), null))
   );
   public static final List<vmo> OPTIONS = List.of(MARK_TIME, SOUNDS, VOLUME, LISTEN);
   public static final List<vmo> ALL = List.of(ENABLED, MARK_TIME, SOUNDS, VOLUME);
   private static final double uch = 400.0;
   private static final long uci = 400L;
   private static final int ucj = 3;
   private static final long uck = 25000L;
   private static final long ucl = 1000L;
   private static final long ucm = 10000L;
   private static final int ucn = 3;
   private static final int uco = 1000;
   private static final long ucp = 15000L;
   private static final int ucq = 32;
   private static final List<ubm> ucr = new ArrayList<>();
   private static final List<ubg> ucs = new ArrayList<>();
   private static final List<ubj> uct = new ArrayList<>();
   private static final Map<Integer, byte[]> ucu = new TreeMap<>();
   private static final Set<String> ucv = new HashSet<>();
   private static final List<ubs> ucw = new ArrayList<>();
   private static final List<ubx> ucx = new ArrayList<>();
   private static final Set<String> ucy = new HashSet<>();
   private static final Map<String, ubg> ucz = new HashMap<>();
   private static final Map<String, Long> uda = new HashMap<>();
   private static String udb;
   private static PrivateKey udc;
   private static String udd;
   private static String ude;
   private static int udf;
   private static byte[] udg;
   private static uhg udh;
   private static String udi;
   private static ucd udj = ucd.OFF;
   private static String udk;
   private static String udl;
   private static String udm;
   private static String udn;
   private static long udo;
   private static int udp;
   private static long udq;
   private static long udr;
   private static String uds;
   private static long udt;
   private static long udu;
   private static long udv;
   private static ubj udw;
   private static int udx;
   private static String udy;
   private static String udz;
   private static boolean uea;
   private static int ueb;

   private ucg() {
   }

   public static int version() {
      return udx;
   }

   public static ucd status() {
      return udj;
   }

   public static String lastError() {
      return udn;
   }

   public static String code() {
      return udk;
   }

   public static String prettyCode() {
      return pretty(udk);
   }

   public static String pretty(String var0) {
      return var0 != null && var0.length() == 6 ? var0.substring(0, 3) + a.b("\uf229", -346951163) + var0.substring(3) : var0;
   }

   public static String fingerprint() {
      return udd == null ? null : ufw.fingerprint(udd);
   }

   public static boolean inParty() {
      return udl != null;
   }

   public static boolean secured() {
      return udl != null && udl.equals(ude) && ucu.containsKey(udf);
   }

   public static String leader() {
      return udm;
   }

   public static boolean isLeader() {
      return udk != null && udk.equals(udm);
   }

   public static List<ubm> members() {
      return Collections.unmodifiableList(ucr);
   }

   public static List<ubg> invites() {
      long var0 = System.currentTimeMillis();
      ucs.removeIf(var2 -> var2.until < var0);
      return Collections.unmodifiableList(ucs);
   }

   public static List<ubj> marks() {
      return uct;
   }

   public static int noticeSeq() {
      return ueb;
   }

   public static String notice() {
      return udz;
   }

   public static boolean noticeError() {
      return uea;
   }

   public static boolean online() {
      return udj == ucd.ONLINE;
   }

   public static String relay() {
      return System.getProperty(a.b("穐ϫ褻ᝒ鳀ᩭꁠ⦀럌㵻몥䂃츈垮\uddf4嬈\ue15f", -1630832089), DEFAULT_RELAY);
   }

   public static String normalize(String var0) {
      if (var0 == null) {
         return null;
      }

      StringBuilder var1 = new StringBuilder();

      for (char var5 : var0.toUpperCase(Locale.ROOT).toCharArray()) {
         if (a.d("럍칿䒭\udadb儍ힿ淭\ue413穎\uf0fe眪赚Ύ騡ၳ隁ⳏꌙ㦫뿹㘏䱑싣失\udf26嗶\uec42戒\uf8e6纶\uf50a\u0bda", 1691561230, 1900911266).indexOf(var5) >= 0) {
            var1.append(var5);
         } else if (Character.isLetterOrDigit(var5)) {
            return null;
         }
      }

      return var1.length() == 6 ? var1.toString() : null;
   }

   public static ubm member(String var0) {
      for (ubm var2 : ucr) {
         if (var2.code.equals(var0)) {
            return var2;
         }
      }

      return null;
   }

   public static String cosmeticsOf(String var0) {
      if (var0 != null && udk != null) {
         for (ubm var2 : ucr) {
            if (!var2.code.equals(udk)
               && var2.online
               && var2.cosmetics != null
               && var0.equalsIgnoreCase(var2.name)
               && (var2.world == null || sameWorld(var2) || onThisServer(var2.name))) {
               return var2.cosmetics;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   static boolean onThisServer(String var0) {
      return var0 != null && hhf.listEntry(var0) != null;
   }

   public static ubm self() {
      return udk == null ? null : member(udk);
   }

   public static boolean sameWorld(ubm var0) {
      return var0.world != null && sameServer(var0.world, wlk.worldId());
   }

   public static boolean sameServer(String var0, String var1) {
      return var0 != null && var1 != null && serverKey(var0).equals(serverKey(var1));
   }

   static String serverKey(String var0) {
      String var1 = var0.trim().toLowerCase(Locale.ROOT);
      if (!var1.startsWith(a.d("塵⇙ꭀ", -1084236287, 2018412058))) {
         return var1;
      }

      String var2 = var1.substring(3);
      int var3 = var2.indexOf(58);
      if (var3 > 0 && var3 == var2.lastIndexOf(58)) {
         var2 = var2.substring(0, var3);
      }

      while (var2.endsWith(a.d("且", 352354821, 278580286))) {
         var2 = var2.substring(0, var2.length() - 1);
      }

      if (!var2.matches(a.b("윕뻏㐁ꩤ↤Ꝧᵃ", -2125412535)) && var2.indexOf(58) < 0) {
         String[] var4 = var2.split(a.c(-1424519500, "軬\uf728綈"));
         if (var4.length > 2) {
            var2 = var4[var4.length - 2] + a.d("\ue3c9", 751045315, 226027813) + var4[var4.length - 1];
         }

         return a.d("쮅눩㢰", -1927787039, -1108179446) + var2;
      } else {
         return a.b("齀\ue6ec汵", 980524846) + var2;
      }
   }

   public static boolean visible(ubj var0) {
      if (!Objects.equals(var0.dim, wlk.dimensionId())) {
         return false;
      } else {
         return !var0.mine && !sameServer(var0.world, wlk.worldId()) ? var0.name != null && (hhf.inWorld(var0.name) != null || onThisServer(var0.name)) : true;
      }
   }

   public static void invite(String var0) {
      String var1 = normalize(var0);
      if (var1 == null) {
         ufb(wap.s(a.c(-1620059397, "\udaafꌲ⧪랚㱛몹¦襔ᜋ鶾ᨦ\ue01b滉\uf77a紧ﮓ䆽칯哝틢嬊⅚꿮"), a.c(-1777579415, "乫㟾봧❂ꢇ⹏鑤ᶝ莶ॼ躣璨\ufe1d掶\ue9ef演텁廱쑁䈑쮈뇆㽴꒢")), true);
      } else if (var1.equals(udk)) {
         ufb(wap.s(a.c(-1108440088, "讨\uf225磿\ue69b洟\uebfa出\ud852䘛첰䭤녇㿟ꙶⰼꪃႏ齒ת莺"), a.c(-631557808, "㕶䲨옇屨펭唞\uef35抬\uf8e9牜\uf585")), true);
      } else if (inParty() && !secured()) {
         uev();
         ufb(
            wap.s(
               a.b("眗ຐ葋ᨧ釭\u175b괁Ⓑ몮〖럘䷻썸嫕킋嘿\uec20揠鹿缗\uf6ed賥ȝ駂ᾡ锥Ⲛꊟ㡮븴㗞쭎䄇\ud8f0庫퐝", -762480796),
               a.b("䵞㓍빻\u2067꾬ⴇ靕ố肇๑趝矣牢悍\ueeca样홧妷쌅䔫첢뛼㠽ꎖ▒꼴ኒ飖ɝ萔\u0bd6\uf167筘\ue2ae", 77285738)
            ),
            true
         );
      } else if (!ufn(ufm(a.b("\ue572鳀ᘓ衦ί蔛", 1555752216)).put(a.c(943068775, "ᘀ澽\ue565笕"), var1))) {
         ufb(ufa(), true);
      } else {
         ucv.add(var1);
      }
   }

   public static void accept(ubg var0) {
      ucs.remove(var0);
      if (var0.key != null) {
         ucz.put(var0.party, var0);
      }

      udx++;
      ufn(ufm(a.d("⼤嚗\udc44䈳짱佄", 249660738, 100772353)).put(a.d("沬ᔌ鿌ƻ詡", -1171721546, -106389905), var0.party));
   }

   public static void decline(ubg var0) {
      ucs.remove(var0);
      udx++;
      ufn(ufm(a.c(-1850897683, "誎\uf33e秫\ue795汇\ueaf1傩")).put(a.d("祚ú診ᑍ龗", 1358596396, 1460137987), var0.party));
   }

   public static void leave() {
      if (ufn(ufm(a.b("麼\ue704淓\uf3b5硱", -641949995)))) {
         uek();
         ufb(wap.s(a.b("㿠䙧첮劊\ud911復\ue5f9氚\uf211磴［Շ试ሴ顶Ẕꓝ⬁", -1934999637), a.c(-625457952, "䃢㤊랲ⷑꙿ\u20cd髭ጟ襘߱耭繋\uf483洽\ue71c憗")), false);
      }
   }

   public static void kick(ubm var0) {
      ufn(ufm(a.d("狈\u0b7b膢Ί", -1669726946, -878473287)).put(a.b("\uf490购ߵ馅", 142931191), var0.code));
   }

   public static void newCode() {
      if (!ufn(ufm(a.d("켍뚷㱶ꈓ⧈꽲ᔠ", 1205723358, 1522741178)))) {
         ufb(ufa(), true);
      }
   }

   public static void reconnect() {
      uej();
      udj = ucd.OFF;
      udo = 0L;
      udp = 0;
   }

   public static void markKey() {
      MinecraftClient var0 = MinecraftClient.getInstance();
      Entity var1 = var0.getCameraEntity();
      if (var0.player != null && var0.world != null && var1 != null) {
         if (!inParty()) {
            ufc(
               wap.s(
                  a.c(-1455420972, "স瀨\ufae0擅\uef5b槭폰婀쑞亿쥽㌟뷎⑲깢⢉銠ᵅ蟭ư行\uf217粳\ue731愚\uebde剮\udc71䚊삫䬩뗫㾢Ꙟ"),
                  a.d("\uda84ꍬⷔ랸㱧뻃\u0082赡ᜡ鶟ᨾ\ue035櫠\uf34b紊ﯳ䆽칧哐튏孲┳꾴㐱뉍㣨脠ི釦ុ頷曉\uecf4畿", 130464024, 1311008684)
               )
            );
         } else if (!secured()) {
            uev();
            ufc(wap.s(a.d("∰宷텬伀쓊䉼\uf826熐\uef89攱\ue2ffᣜ陟\u0ff2薬̘뤇㛇걧⨰ꏊ\ud9c2场쳥䪆", -764912477, -150241571), a.b("ꪼ팯妙입䡎쫥炷盧来\ue9b3橿送Ấ蝯", -960909660)));
         } else {
            long var2 = System.currentTimeMillis();
            String var4 = wlk.worldId();
            String var5 = wlk.dimensionId();
            if (udw != null && !udw.danger() && var2 - udv < 400L && uct.contains(udw)) {
               udw.kind = 1;
               udw.born = var2;
               udw.color = -1096636;
               udv = 0L;
               uee(udw);
               ueg(a.c(1192402223, "鵭\ue4f9渥\uf05d箈ﴮ"), null);
            } else {
               Vec3d var6 = var1.getCameraPosVec(1.0F);
               Vec3d var7 = var1.getRotationVec(1.0F);
               ubj var8 = null;
               double var9 = Math.cos(Math.toRadians(2.5));

               for (ubj var12 : uct) {
                  if (var12.mine && visible(var12)) {
                     Vec3d var13 = ugg.anchor(var12, 1.0F).subtract(var6);
                     double var14 = var13.length();
                     if (!(var14 < 0.001)) {
                        double var16 = var13.dotProduct(var7) / var14;
                        if (var16 > var9) {
                           var9 = var16;
                           var8 = var12;
                        }
                     }
                  }
               }

               if (var8 != null) {
                  uct.remove(var8);
                  JsonObject var19 = new JsonObject();
                  var19.addProperty(a.b("㱯", 1922382874), a.c(924666675, "䭀㋪렺♇궃⬫"));
                  var19.addProperty(a.b("뽪웖", -262357247), var8.id);
                  ufj(var19);
                  udw = null;
                  ueg(a.c(2050216759, "퍤ꫮ‣빋㖛댣"), null);
               } else {
                  ubj var18 = new ubj();
                  PlayerEntity var20 = hhf.aimed(var0, 160.0);
                  if (var20 != null) {
                     var18.target = hhf.nameOf(var20);
                     var18.x = var20.getX();
                     var18.y = var20.getY();
                     var18.z = var20.getZ();
                  } else {
                     HitResult var21 = var1.raycast(400.0, 1.0F, false);
                     if (var21 == null || var21.getType() == Type.MISS) {
                        ufc(
                           wap.s(
                              a.d("⾤嘮\udcfd䋃쥒俤\uf5a4簇\ue20c梦\uef3aᔆ鯝ɿ蠵", 119151263, 1794061664),
                              a.d("뿴왟䲏튎夫\udf9e族\ue822物\uf8dc缄蕻ண鈖ᱛ麾⓾꭛㖇럊㸴䐒쫙儊", -2128539552, -774263891)
                           )
                        );
                        return;
                     }

                     Vec3d var23 = var21.getPos();
                     var18.x = var23.x;
                     var18.y = var23.y;
                     var18.z = var23.z;
                  }

                  var18.from = udk;
                  var18.name = var0.getSession().getUsername();
                  var18.id = ufw.RANDOM.nextInt(Integer.MAX_VALUE);
                  var18.world = var4;
                  var18.dim = var5;
                  var18.born = var2;
                  var18.life = Math.round(MARK_TIME.get() * 1000.0);
                  var18.mine = true;
                  ubm var22 = self();
                  var18.color = var22 != null ? var22.color : COLORS[0];
                  uef(var18);
                  uee(var18);
                  System.out
                     .println(
                        a.c(-1179129077, "\ueb6e鋎\u180e虹ඣ譋ㅕ뢨⛤걌⯔퇵弾욂䳓쨤灪\uffff攍\ue349櫪")
                           + Math.round(var18.x)
                           + a.c(-2010279857, "遮")
                           + Math.round(var18.y)
                           + a.c(1191341364, "洕")
                           + Math.round(var18.z)
                           + (var18.target != null ? a.b("滢\u171c鷎ϱ", -1544851770) + var18.target : "")
                           + a.c(-1132331781, "ﳟ蔧\u0ff3里")
                           + var4
                           + a.b("蛤", 645039813)
                           + var5
                     );
                  udw = var18;
                  udv = var2;
                  ueg(var18.target != null ? a.c(1633200831, "\uaaf7퍥妺쟃") : a.c(-2016494012, "븐잘䵌팴"), null);
               }
            }
         }
      }
   }

   private static void uee(ubj var0) {
      JsonObject var1 = new JsonObject();
      var1.addProperty(a.b("ﶛ", 1478426094), a.b("綦Л軛Ⴓ", -1413382705));
      var1.addProperty(a.d("첵딉", -1667400072, 346862246), var0.id);
      var1.addProperty(a.c(-110346972, "㵝"), var0.x);
      var1.addProperty(a.b("뻜", 1546043044), var0.y);
      var1.addProperty(a.b("鎢", -857697319), var0.z);
      var1.addProperty(a.b("陗", -877488607), var0.world);
      var1.addProperty(a.c(2139100089, "Ꮬ"), var0.dim);
      var1.addProperty(a.d("崽", -561629143, -51223170), var0.kind);
      var1.addProperty(a.b("㔑", 832124286), var0.name);
      if (var0.target != null) {
         var1.addProperty(a.b("勝", 214717100), var0.target);
      }

      ufj(var1);
   }

   private static void uef(ubj var0) {
      uct.removeIf(var1x -> var1x.from.equals(var0.from) && var1x.id == var0.id);
      int var1 = 0;

      for (ubj var3 : uct) {
         if (var3.from.equals(var0.from)) {
            var1++;
         }
      }

      if (var1 >= 3) {
         for (ubj var5 : uct) {
            if (var5.from.equals(var0.from)) {
               uct.remove(var5);
               break;
            }
         }
      }

      uct.add(var0);
   }

   private static void ueg(String var0, Vec3d var1) {
      if (SOUNDS.get()) {
         float var2 = 0.0F;
         float var3 = 0.0F;
         MinecraftClient var4 = MinecraftClient.getInstance();
         if (var1 != null && var4.player != null) {
            Vec3d var5 = var4.player.getEyePos();
            double var6 = var1.x - var5.x;
            double var8 = var1.z - var5.z;
            double var10 = Math.toRadians(var4.player.getYaw());
            double var12 = -var6 * Math.cos(var10) - var8 * Math.sin(var10);
            double var14 = -var6 * Math.sin(var10) + var8 * Math.cos(var10);
            double var16 = Math.hypot(var12, var14);
            if (var16 > 1.5) {
               var2 = (float)(var12 / var16 * 0.85);
               var3 = (float)(-var14 / var16);
            }
         }

         voa.cue(var0, (float)VOLUME.get(), var2, var3);
      }
   }

   public static void tick(MinecraftClient var0) {
      long var1 = System.currentTimeMillis();
      uct.removeIf(var2 -> var1 - var2.born > var2.life);
      String var3 = relay();
      if (ENABLED.get() && !var3.isEmpty()) {
         if (udh != null && !var3.equals(udi)) {
            uej();
            udo = 0L;
            udp = 0;
            udj = ucd.OFF;
         }

         if (udj != ucd.REPLACED) {
            if (udh == null) {
               if (var1 >= udo) {
                  uei(var3);
               }
            } else if (udj == ucd.ONLINE) {
               if (var1 - udq > 25000L) {
                  udq = var1;
                  udh.send(a.c(-816469766, "ꢎ턦寲얊"));
               }

               if (var1 - udr > 1000L) {
                  udr = var1;
                  ueh(var0);
               }
            }
         }
      } else {
         if (udh != null) {
            uej();
         }

         udj = ENABLED.get() ? ucd.NO_SERVER : ucd.OFF;
      }
   }

   private static void ueh(MinecraftClient var0) {
      if (secured()) {
         String var1 = var0.getSession().getUsername();
         String var2 = wlk.worldId();
         String var3 = wlk.dimensionId();
         String var4 = Cosmetics.shareCode();
         String var5 = udl
            + a.c(288595394, "鶿")
            + udf
            + a.c(760738530, "\uf29f")
            + var1
            + a.c(1609173600, "ਝ")
            + var2
            + a.b("ං", -1977283073)
            + var3
            + a.d("풀", 269737888, 117312349)
            + var4;
         if (!var5.equals(uds)) {
            JsonObject var6 = new JsonObject();
            var6.addProperty(a.d("裏", 1881689319, 1385677895), var1);
            var6.addProperty(a.b("勘", 2014991022), var2);
            var6.addProperty(a.d("卧", -370634754, -348005124), var3);
            if (!var4.isEmpty()) {
               var6.addProperty(a.b("䢪", 189614280), var4);
            }

            String var7 = ufh(a.c(-661584550, "Ԫ粜\uf647") + udl + a.c(92065336, "칅") + udk, var6);
            if (var7 != null && ufn(ufm(a.b("㚜伪여守큞囩", 546256617)).put(a.c(-188813788, "\uee56"), var7))) {
               uds = var5;
            }
         }
      }
   }

   private static void uei(String var0) {
      URI var1;
      try {
         ufu();
         var1 = uri(var0, udb, udd);
      } catch (Exception var3) {
         udj = ucd.RETRY;
         udn = wap.s(a.d("\u2efd坯\uddb9䎌절亯\uf4eb紞\ue352槴\uee75ᑅ骗̦襣྅뗜㨍", 627487357, -1087267632), a.c(896299574, "瘽ྤ蕰ᬆ邤ᙨ걍◎뾈ㄩ뛾䳻쉙宜햮圾\ued05抡\uf860縶\uf7b4趕"))
            + a.c(-2079809720, "齰\ue6db")
            + var3.getMessage();
         udo = System.currentTimeMillis() + 60000L;
         return;
      }

      udj = ucd.CONNECTING;
      udi = var0;
      uds = null;
      udh = new uhg(
         var1,
         new uhc() {
            @Override
            public void opened(uhg var1) {
               if (var1 == ucg.udh) {
                  ucg.udq = System.currentTimeMillis();
               }
            }

            @Override
            public void message(uhg var1, JsonObject var2) {
               if (var1 == ucg.udh) {
                  try {
                     ucg.uel(var2);
                  } catch (RuntimeException var4) {
                     System.out.println(a.c(1901217984, "䢦ㄆ믆▱깫⢃銝᭤蔭ྜ衝爪ﳿ攋\uef1e槨펯屻웁䂑줸덳") + var4);
                  }
               }
            }

            @Override
            public void closed(uhg var1, int var2, String var3) {
               if (var1 == ucg.udh) {
                  ucg.udh = null;
                  if (var2 == 4000) {
                     ucg.udj = ucd.REPLACED;
                     ucg.udn = wap.s(
                        a.b("⑺巧휵䥄슘䐯﹫瞋\ue9d5挠\ue4b5Ố通\u09a9获ԇ뽇\u3097\uaa3fⱲꖈ\udfce儯쪹䳀옝羦", 1303585826),
                        a.b("臌\uf85c犅\uecfa本\ue1e8宲툱䱦월䔙뭰㖨ꠎ♉ꃌ᪀锡ྟ觉Ч穮\uf4d6潴\ue900", 736658890)
                     );
                  } else {
                     ucg.udj = ucd.RETRY;
                     ucg.udn = var3 != null && !var3.isBlank() ? var3 : wap.s(a.b("堣↞ꭆ㔶뺤", 1172854853), a.c(-624158042, "ẘ札\uedf4瞑")) + var2;
                     ucg.udp++;
                     ucg.udo = System.currentTimeMillis() + Math.min(60000L, 2000L << Math.min(5, ucg.udp - 1));
                  }

                  ucg.udx++;
               }
            }
         }
      );
      udx++;
   }

   static URI uri(String var0, String var1, String var2) {
      String var3 = var0.trim();

      while (var3.endsWith(a.d("\u218c", 857071688, -1719287318))) {
         var3 = var3.substring(0, var3.length() - 1);
      }

      if (var3.startsWith(a.c(1575317668, "烄३莺᷏阛უꪥ⍔"))) {
         var3 = a.b("䊌㬹뇪⿒ꐐ⊡", -797097219) + var3.substring(8);
      } else if (var3.startsWith(a.d("쩤돉㤚ꝯⳲ꩖စ", -1667171017, 2056206140))) {
         var3 = a.d("駡\ue054櫎\uf4aa罽", -1656623614, 133003153) + var3.substring(7);
      } else if (!var3.startsWith(a.b("ᔞ沫\ue678础\uf382申", -335604369)) && !var3.startsWith(a.c(1974744584, "㙺俏압嬱탦"))) {
         var3 = a.b("Һ紏\uf7dc槤\ue226撗", 112592075) + var3;
      }

      if (!var3.endsWith(a.d("ཨ皁ﱖ", 2094417396, -1788261712))) {
         var3 = var3 + a.b("፴檝\ue04a", 392631128);
      }

      return URI.create(var3 + a.c(-827551249, "釙\ue821抹ﳇ眄\uf1f8䮥쉈屓") + var1 + a.b("떟챸䚮\ud8c8區", 504411580) + var2);
   }

   private static void uej() {
      if (udh != null) {
         uhg var0 = udh;
         udh = null;
         var0.close();
      }

      udk = null;
      udl = null;
      udm = null;
      ucr.clear();
      uct.removeIf(var0x -> !var0x.mine);
      ucs.clear();
      ucv.clear();
      ucw.clear();
      ucx.clear();
      udx++;
   }

   private static void uek() {
      udl = null;
      udm = null;
      ucr.clear();
      uct.removeIf(var0 -> !var0.mine);
      ucw.clear();
      ucx.clear();
      ucy.clear();
      udy = null;
      ucu.clear();
      ude = null;
      udf = 0;
      uds = null;
      ufv();
      udx++;
   }

   private static void uel(JsonObject var0) {
      String var1 = ufq(var0, a.b("갿", 2077535306));
      if (var1 != null) {
         switch (var1) {
            case a.c(877672540, "㠱䆍쭗唦\udef2"):
               boolean var9 = udk != null && !udk.equals(ufq(var0, a.b("\ue57a鳇ᘟ衯", 202106141)));
               udk = ufq(var0, a.d("ʚ笧\uf1ff澏", -1531850247, -1140010236));
               udj = ucd.ONLINE;
               udp = 0;
               udn = null;
               uds = null;
               udr = 0L;
               if (var9) {
                  ufb(wap.s(a.c(-959931773, "髄\ue35e榟\uf7b9簭敖䃈줸圢"), a.d("㐥䶷읨奠틅偭\uee24柑濾眡", 1825569576, -615462118)) + prettyCode(), false);
               }
               break;
            case a.b("ۅ罥\uf5a5毒\ue008", -2110126416):
               uem(var0);
               break;
            case a.d("ᯛ扭\ue8a6盈ﴂ箢", 1594211433, 1487644637):
               ubg var8 = ueq(var0);
               if (var8 != null) {
                  ucs.removeIf(var1x -> var1x.party.equals(var8.party));
                  ucs.add(var8);
                  ufb(
                     var8.name
                        + wap.s(a.c(-227057068, "扣ᮛ酏༦蓮ɂ렀\u31e7꿫┃ꋆ墭혯俊얂䌼爐皢\uec41樁\ue3e5馲ᜌ"), a.d("ជ模\ue0fb纆\uf532玐춡䁂\ude1f哟흭⤎ꏋ㹥됹㊺袏", -730210055, 1141897039)),
                     false
                  );
                  ufc(
                     var8.name
                        + wap.s(
                           a.d("憯ᡗ銃೪蜢Ǝ믌㈫갧⛏ꄊ孡헣䰆왎䃰\ufafe畮\uef8d槍\ue029驾ᓀ轆ष莋㨐둊⺦ꢮ⌑\udda6埝츷䡨싒紏\uf769", -147111627, -393142116),
                           a.d("炌പ蟰ᦍ鈹ᒛꪪ❉봄㎪둶乵샘嵿휢嗯\uef89恐敖碣\uf158輛Ơ驰ᰄ雑⽬ꄷ㿐붵㙒좀䊻\udb31嵡", 1546414788, -561178037)
                        )
                  );
                  ueg(a.b("\u0098礎\uf3c5涫\ue661惁", 711327959), null);
               }
               break;
            case a.b("༁皷ﱼ戒\ue9d8潸픽", 47124335):
               ucs.clear();

               for (JsonElement var10 : ufp(var0, a.b("崄⒰깹』", 1030249836))) {
                  if (var10.isJsonObject()) {
                     ubg var6 = ueq(var10.getAsJsonObject());
                     if (var6 != null) {
                        ucs.add(var6);
                     }
                  }
               }
               break;
            case a.c(-1417419674, "\ue415鶡ᝥ"):
               uep(var0);
               break;
            case a.b("ࣩ煎ﮖ旽", -1689450338):
               ufb(
                  wap.s(a.d("最ẖ鑝ਲ਼臹ݙ뵏㓭ꪤ„ꟗ已퍱䫛샇", 1541824298, -1435944852), a.b("ം瓬﹇怽\uebe2浘흳廿삨䨜췂㎦륯₢ꪌⰂ阽᧮荔ԋ賴\uf6a6簑\ue7da", -2016278267))
                     + pretty(ufq(var0, a.b("述\uf64d粕\ue2e5", 1184731031)))
                     + (ufr(var0, a.b("\ue5cc鱼ᚭ裙̉薳", 1555031461)) ? "" : wap.s(a.c(-698149011, "ᝇ滾\ue46a稒\uf1c5睾촨䓞\uda8a偷"), a.c(1074396798, "﹒蟫भ靔ᢖ騵⑴ꧤ㟏봉㪠쓀"))),
                  false
               );
               break;
            case a.b("鬳\ue283桖\uf628緺בֿ䄔죤", -978478241):
               ufb(
                  pretty(ufq(var0, a.b("捻᫆逞\u0e6e", -935435492)))
                     + wap.s(a.d("猵ી耒ṥ閽ጉ\ua95d₧뻹", -887925578, 417671082), a.b("\uebae阁Ხ芧ॱ迅㖕뱡∽겗⽛핕寺쉀䠛컡瓖ﭺ懁\ue795湯", -542905445)),
                  true
               );
               break;
            case a.d("ꫳ퍀妙쟠䰹쪉", -1764129750, -184406348):
               ufb(
                  wap.s(
                     a.c(-1877262937, "㷡䑦캯傋\udb0b嶨\ue7ec渊\uf010竳ﴷݎ覛ဳ驳ᲃꚈ⤟뎸㗴밁옝䣺팷啅\udfd1昲\ue872犖\uf4c1罿"),
                     a.d("\ue015馆ጤ褴ۻ耳㨛돫ⷁꝹ⃕\udaa7味짚䞑셯缷\uf4f9湅\ue866懫", -1759177277, -1664224815)
                  ),
                  true
               );
               break;
            case a.d("Җ細\uf7e3", -6388362, 1476559238):
               if (a.c(1574023984, "덚쫨䀻\ude4e喇팳").equals(ufq(var0, a.d("碏ķ诹", 611692598, -2058893092)))) {
                  ucv.clear();
               }

               ufb(uez(ufq(var0, a.d("▵", -1803117829, -1930510558))), true);
               break;
            case a.c(48522051, "挫᪔遛"):
               ucw.add(new ubs(ufq(var0, a.c(1616143161, "捛\u1afe逰ใ")), ufq(var0, a.c(-1552871141, "ᅺ棆\ue202"))));
               uer();

               for (ubm var5 : ucr) {
                  if (var5.sealed && !var5.code.equals(udk)) {
                     ueo(var5, var5.blob);
                  }
               }

               uex();
               uen();
               break;
            case a.c(1801689423, "餦\ue09c橏\uf43f翧菱䌗"):
               ues(ufq(var0, a.c(300585381, "采\ue862抬ﳟ")));
               break;
            case a.b("\udd42ꓭ⸪", -905388756):
               uew(ufq(var0, a.b("梁胟\u0a11鑢", 1657731352)), ufq(var0, a.c(-680061006, "័")));
         }

         udx++;
      }
   }

   private static void uem(JsonObject var0) {
      String var1 = ufq(var0, a.c(232011783, "㡬䇐"));
      if (var1 == null) {
         if (udl != null || ude != null) {
            uek();
         }
      } else {
         boolean var2 = !var1.equals(udl);
         HashSet var3 = new HashSet();
         if (!var2) {
            for (ubm var5 : ucr) {
               var3.add(var5.code);
            }
         }

         udl = var1;
         udm = ufq(var0, a.d("鵄\ue4fc渫\uf05f箉ﴯ", -1794037002, -602949672));
         if (!var1.equals(ude)) {
            ubg var9 = ucz.remove(var1);
            if (var9 != null) {
               ufd(var1, var9.epoch, var9.key);
            } else if (udg != null && udk != null && udk.equals(udm)) {
               ufd(var1, 1, udg);
            } else {
               ucu.clear();
               ude = null;
               udf = 0;
            }

            udg = null;
            ucz.clear();
         }

         ucr.clear();
         int var10 = 0;

         for (JsonElement var6 : ufp(var0, a.c(1209103821, "疧ఞ蛅ᢻ鍫ᗍ꾟"))) {
            if (var6.isJsonObject()) {
               JsonObject var7 = var6.getAsJsonObject();
               ubm var8 = new ubm();
               var8.code = ufq(var7, a.d("￤虙ಁ鋱", 1257698033, 464063858));
               if (var8.code != null) {
                  var8.online = ufr(var7, a.d("女耱ૠ钔ὄ駾", 2019226283, 1642990403));
                  var8.pub = ufq(var7, a.c(-1795488763, "Ѷ緂\uf706"));
                  var8.fingerprint = var8.pub != null ? ufw.fingerprint(var8.pub) : null;
                  var8.color = COLORS[var10++ % COLORS.length];
                  ueo(var8, ufq(var7, a.d("翧", -1412333055, -1509687916)));
                  if (var8.code.equals(udk)) {
                     var8.name = MinecraftClient.getInstance().getSession().getUsername();
                  }

                  if (var8.name == null) {
                     var8.name = pretty(var8.code);
                  }

                  ucr.add(var8);
               }
            }
         }

         for (ubj var17 : uct) {
            ubm var22 = member(var17.from);
            if (var22 != null && !var17.danger()) {
               var17.color = var22.color;
            }
         }

         uer();

         for (ubm var18 : ucr) {
            if (var18.sealed && !var18.code.equals(udk)) {
               ueo(var18, var18.blob);
               if (var18.name == null) {
                  var18.name = pretty(var18.code);
               }
            }
         }

         if (!secured() && ucr.size() > 1) {
            uev();
         }

         if (isLeader() && secured()) {
            for (ubm var19 : ucr) {
               if (var19.sealed && var19.online && !var19.code.equals(udk)) {
                  uet(var19);
               }
            }
         } else if (secured()) {
            ubm var14 = member(udm);
            if (var14 != null && var14.sealed && var14.online) {
               uev();
            }
         }

         boolean var16 = false;

         for (String var23 : var3) {
            if (member(var23) == null) {
               var16 = true;
               break;
            }
         }

         if (var16 && isLeader() && secured()) {
            ueu();
         }

         if (var2 && ucr.size() > 1) {
            ufb(wap.s(a.b("껥흢嶫쎏䠙캻瓿﵋捝\ue9eb湶鑆\u1ad0茱ॳ辑㗘먄", 540323502), a.b("ꭌ튤尜왿䦺쬔煈\uf8cb曮", 721334103)), false);
            ueg(a.d("ꢏ턛寎언", -1872309860, -447186595), null);
         } else if (!var2) {
            for (ubm var24 : ucr) {
               if (!var3.contains(var24.code) && !var24.code.equals(udk)) {
                  ufb(
                     wap.s(
                        a.d("忂♏겞㋧뤺㾊藒౦鉳ᣇ鼒敤\uebb8爈\uf81f纺쓩䬵퇃埂\ude24ꑦ⫓넏", -1732892488, 661288753), a.d("㏺乹삵廋핮厥\uedee怂﹞瓣\uf349ॊ莄Ṗ鐁ኇꢹ❫붧㯳눆", 1010525076, 1309627497)
                     ),
                     false
                  );
                  ueg(a.b("쮴눠㣵ꚃ", 394185722), null);
               }
            }
         }

         uex();
         uen();
      }
   }

   private static void uen() {
      if (udl != null) {
         if (!udl.equals(udy)) {
            ucy.clear();
            udy = udl;
         }

         for (ubm var1 : ucr) {
            if (!var1.code.equals(udk)
               && !var1.sealed
               && var1.blob != null
               && var1.name != null
               && !var1.name.equals(pretty(var1.code))
               && ucy.add(var1.name.toLowerCase(Locale.ROOT))
               && hhf.add(var1.name)) {
               System.out.println(a.b("\ufff9虙ಙ鋮ᤴ鿜◂갻㉬룒㼆애䯥", -1725169788) + var1.name + a.d("똹쿉䔟\udb6e傸혈氟\ue5ba篾\uf100皕賰ȼ鮁ᇙ霢\u2d7a", -1160025395, 785177797));
               izx.alert(
                  var1.name, wap.s(a.c(-1839272840, "\uec30閵ώ脀\u0adc豧㙰뾉\u218eꬮⳮ횙塃솢"), a.d("\uebc1鈤ᣴ蛵ऱ辈㇌렲☟곔⼖", 1228766420, 1596756746)), vhz.FRIENDS, true
               );
            }
         }
      }
   }

   private static void ueo(ubm var0, String var1) {
      var0.blob = var1;
      if (var1 != null) {
         JsonObject var2 = ufi(a.d("⍉嫿퀤", -2131953694, -1070213925) + udl + a.c(-934315034, "箛") + var0.code, var1);
         if (var2 == null) {
            var0.sealed = true;
         } else {
            var0.sealed = false;
            var0.name = ufk(ufq(var2, a.d("뼻", 866537257, 1266020477)));
            var0.world = ufq(var2, a.d("\udd50", 1672495030, -906960240));
            var0.dim = ufq(var2, a.c(-454085540, "㐹"));
            String var3 = ufl(ufq(var2, a.b("\u0eec", 634523278)));
            var0.cosmetics = var3 != null && var3.length() <= 1000 ? var3 : null;
         }
      }
   }

   private static void uep(JsonObject var0) {
      String var1 = ufq(var0, a.c(480155086, "閩\uec14曌\uf8bc"));
      String var2 = ufq(var0, a.d("麮\ue71a淞", -238690597, 1506557958));
      if (var1 != null && var2 != null && ucv.remove(var1)) {
         byte[] var3;
         int var4;
         if (inParty()) {
            if (!secured()) {
               uev();
               ufb(
                  wap.s(
                     a.b("\uf8f6腱ப闆Ḍ颺⋠ꭖ㕏뿷㠹숚䲙픴彪\ud9de揁\uec01皡\uf0f6礌̄跼ᘣ遀᫄ꍻ\u2d7e랏㇕먿䒯컦圑텊导", 1387853957),
                     a.d("똸쾫䔝\udb01哊홡氳\ue5b7篡\uf537盻貅Ƞ鯫ᖬ鍑ⴁꋑ㡣빍㟄䶚썛声\udef4呒\ue9f4掰碌署\uf0b0ਁ耾ᧈ", 1267966958, -1048768030)
                  ),
                  true
               );
               return;
            }

            var3 = ucu.get(udf);
            var4 = udf;
         } else {
            if (udg == null) {
               udg = ufw.randomKey();
            }

            var3 = udg;
            var4 = 1;
         }

         String var5 = uff(var1, var2, var3, var4);
         if (var5 == null) {
            ufb(wap.s(a.b("厅⨟ꃁ㺡땽㏅覒~鸧ᒗ錊椽\ue7ed織\uf402狺좴", 121918417), a.c(1060484968, "덧쪀䀣\ude5b喇팼浿\ue0e6绉\uf404珓觜܇麴ᓪ鈞⠦")), true);
         } else {
            ufn(ufm(a.c(1845064652, "玣ਕ胞Ằ镺Ꮪ")).put(a.d("꽰훍尕쉥", -916492147, -410132582), var1).put(a.d("\uf123袟ɛ", 1390307510, 1703451124), var5));
         }
      }
   }

   private static ubg ueq(JsonObject var0) {
      String var1 = ufq(var0, a.d("\uf1dd衽ʽ鳊ᜐ", 692882414, -1739883962));
      String var2 = ufq(var0, a.c(710334805, "\ud937ꂒ⩜됯"));
      String var3 = ufq(var0, a.d("䛸㽌떈", 1564022613, -414494242));
      if (var1 != null && var2 != null && var3 != null) {
         ubg var4 = new ubg();
         var4.party = var1;
         var4.from = var2;
         var4.pub = var3;
         var4.fingerprint = ufw.fingerprint(var3);
         long var5 = var0.has(a.c(-51630087, "⾖嘹")) ? var0.get(a.c(-1477948808, "䨗㎸")).getAsLong() : 120000L;
         var4.until = System.currentTimeMillis() + Math.min(var5, 120000L);
         JsonObject var7 = ufg(var2, var3, ufq(var0, a.d("\u0e5e矢ﴦ", -703467185, -838074512)));
         if (var7 != null) {
            var4.name = ufk(ufq(var7, a.b("뿏", 631095200)));
            var4.key = uft(var7, a.b("柘", 1877108658));
            var4.epoch = var7.has(a.c(-1087966319, "\uf3f5")) ? var7.get(a.b("竖", 1477081778)).getAsInt() : 1;
         }

         if (var4.name == null) {
            var4.name = pretty(var2);
         }

         return var4;
      } else {
         return null;
      }
   }

   private static void uer() {
      if (!ucw.isEmpty() && udl != null) {
         ArrayList var0 = new ArrayList<>(ucw);
         ucw.clear();

         for (ubs var2 : var0) {
            ubm var3 = member(var2.from());
            if (var3 != null && var3.pub != null) {
               JsonObject var4 = ufg(var3.code, var3.pub, var2.box());
               byte[] var5 = var4 != null ? uft(var4, a.d("䘼", -626217581, 1104931781)) : null;
               if (var5 != null && var5.length == 32) {
                  int var6 = var4.has(a.d("\ued9f", 222481316, -219732385)) ? var4.get(a.b("Ѫ", -329579506)).getAsInt() : 1;
                  boolean var7 = var3.code.equals(udm);
                  if (secured() && !var7 && var6 <= udf) {
                     System.out
                        .println(
                           a.d("괗풷幷쀀䯚촲眪ﻕ悖\uea7e淫鞎᥄胷૩", -1961329465, -7024209)
                              + var3.name
                              + a.c(-1193532603, "⍵媍큐丨엾䍒烙烦\ueee7摌\ue3daᦾ靶໋蒓Ȫ")
                              + var6
                              + a.d("\ue47d鷀\u175c褷˧著㹗", -951616276, 1306892474)
                              + udf
                        );
                  } else {
                     System.out
                        .println(
                           a.b("\u0601羡\uf561欖\ue0cc昤\udc3c嗃쮀䅨웽㲘뉒⯡ꇿ", -1288960386)
                              + var3.name
                              + (var7 ? a.d("铏\ued76柡蓮牊\uf4fe京읊奎", 54935476, 1167174482) : "")
                              + a.d("䪈㌵릣⟇갏⪲郪ᥓ", 1293059768, -1912484844)
                              + var6
                        );
                     if (!udl.equals(ude)) {
                        ucu.clear();
                        udf = 0;
                     }

                     ude = udl;
                     ucu.put(var6, var5);
                     if (var6 >= udf) {
                        udf = var6;
                     }

                     ufe();
                     uds = null;
                     ufv();
                  }
               }
            } else if (ucr.isEmpty()) {
               ucw.add(var2);
            }
         }
      }
   }

   private static void ues(String var0) {
      if (var0 != null && secured() && member(var0) != null) {
         String var1 = null;
         ubm var2 = member(udm);
         if (var2 != null && var2.online && !var2.code.equals(var0)) {
            var1 = var2.code;
         } else {
            for (ubm var4 : ucr) {
               if (var4.online && !var4.code.equals(var0)) {
                  var1 = var4.code;
                  break;
               }
            }
         }

         if (Objects.equals(var1, udk)) {
            ubm var8 = member(var0);
            String var9 = var8.pub != null ? uff(var8.code, var8.pub, ucu.get(udf), udf) : null;
            if (var9 != null) {
               JsonObject var5 = new JsonObject();
               var5.addProperty(a.c(718353779, "㔅䲯"), var8.code);
               var5.addProperty(a.d("\uf4ba贆߂", 638702489, -351459518), var9);
               JsonArray var6 = new JsonArray();
               var6.add(var5);
               JsonObject var7 = new JsonObject();
               var7.addProperty(a.b("\ue1cb", -618470978), a.d("䜣㺜둓⨨", 88882088, 1933540580));
               var7.add(a.b("\uf101袽ɹ鰕។", -1606553242), var6);
               ufo(var7);
            }
         }
      }
   }

   private static void uet(ubm var0) {
      long var1 = System.currentTimeMillis();
      Long var3 = uda.get(var0.code);
      if (var0.pub != null && (var3 == null || var1 - var3 >= 5000L)) {
         uda.put(var0.code, var1);
         String var4 = uff(var0.code, var0.pub, ucu.get(udf), udf);
         if (var4 != null) {
            System.out.println(a.b("嫼⍜ꦜ㟫백㫙胁ा靽ᶕ騕恲\ueeae眅ﴂ箧쇳乭", 163338910) + var0.name + a.c(209410092, "堈↵ꬣ㕇뺏㠲艪\u0bd3") + udf);
            JsonObject var5 = new JsonObject();
            var5.addProperty(a.d("︐螺", -789603430, 1647535612), var0.code);
            var5.addProperty(a.d("霔\ueea8摬", 244818284, -2055653863), var4);
            JsonArray var6 = new JsonArray();
            var6.add(var5);
            JsonObject var7 = new JsonObject();
            var7.addProperty(a.d("\u09db", -1127566947, -1806583757), a.c(493089885, "\uf432趍݂餹"));
            var7.add(a.d("唅ⲹ꙽㠑돐", -708313941, 1786423753), var6);
            ufo(var7);
         }
      }
   }

   private static void ueu() {
      byte[] var0 = ufw.randomKey();
      int var1 = udf + 1;
      JsonArray var2 = new JsonArray();

      for (ubm var4 : ucr) {
         if (!var4.code.equals(udk) && var4.pub != null) {
            String var5 = uff(var4.code, var4.pub, var0, var1);
            if (var5 != null) {
               JsonObject var6 = new JsonObject();
               var6.addProperty(a.b("닚쭰", 1370206892), var4.code);
               var6.addProperty(a.b("ꉇ\udbfb儿", 1503437350), var5);
               var2.add(var6);
            }
         }
      }

      ucu.put(var1, var0);
      udf = var1;
      ufe();
      uds = null;
      ufv();
      if (!var2.isEmpty()) {
         JsonObject var7 = new JsonObject();
         var7.addProperty(a.b("膄", 461275633), a.d("\ue6c2齽ᖲ诉", -1253718917, -1449319722));
         var7.add(a.c(-1469888047, "䦶《뫎⒢꽣"), var2);
         ufo(var7);
      }
   }

   private static void uev() {
      long var0 = System.currentTimeMillis();
      if (inParty() && var0 - udt > 10000L) {
         udt = var0;
         ufn(ufm(a.c(-1368825945, "忎♴겧㋗뤏㾰藿")));
      }
   }

   private static void uew(String var0, String var1) {
      if (var0 != null && var1 != null) {
         if (!uey(var0, var1, System.currentTimeMillis())) {
            ucx.add(new ubx(var0, var1, System.currentTimeMillis()));

            while (ucx.size() > 32) {
               ucx.removeFirst();
            }
         }
      }
   }

   private static void uex() {
      if (!ucx.isEmpty()) {
         long var0 = System.currentTimeMillis();
         ArrayList var2 = new ArrayList<>(ucx);
         ucx.clear();

         for (ubx var4 : var2) {
            if (var0 - var4.at() < 15000L && ufi(a.d("媫⌄꧃㞩", 1240828612, -693448698) + udl + a.b("⧺", 1916021127) + var4.from(), var4.c()) != null) {
               System.out
                  .println(
                     a.d("ﶻ萛\u0edb邬᭶鶞➀깹〰몁㵀윷䧢퀖娃\udce6暴\ue967玙", -725496307, -925158443)
                        + pretty(var4.from())
                        + a.c(-2085343544, "⻤圇\uddc3䎶졤云\uf48e絲\ue338榘\uee02ᑿ")
                        + (var0 - var4.at())
                        + a.d("ᰫ旗\uef1a焸类簘왙侹퇱嬒\udc88⛤ꡧ㆕믄㴹蝾", 933241639, -1999945923)
                  );
               uey(var4.from(), var4.c(), var4.at());
            } else if (var0 - var4.at() < 15000L) {
               ucx.add(var4);
            }
         }
      }
   }

   private static boolean uey(String var0, String var1, long var2) {
      ubm var4 = member(var0);
      if (var4 == null) {
         System.out
            .println(
               a.d("ힹ긙ⓙ몮ㅴ랜ං葻ᨲ邃ᝂ\ued35揠﨔瀁\uf6e4䲶썥妛", 1481048882, -887827224)
                  + pretty(var0)
                  + a.d("\uf635迓ԟ魩ჱ阉ⱀꖬ㮺녘㛟쳧䈷\udbc8凔휿海\ue2f4砋﹟瞲\u0de4茏ᣒ黬ᐯ궄⏗뤧㽿뒋䨜쁚妶\udfb7問\uea85", -1317949243, 1105020661)
            );
         uds = null;
         udr = 0L;
      }

      JsonObject var5 = ufi(a.b("鬳\ue29c桛\uf631", -445605030) + udl + a.b("膝", 1687716320) + var0, var1);
      if (var5 == null) {
         long var10 = System.currentTimeMillis();
         if (var10 - udu > 3000L) {
            udu = var10;
            System.out
               .println(
                  a.c(1064012635, "謺\uf29a硚\ue62d混\ueb1f儏\ud8fc䚬챔䯔뇱㽴ꛒⲅꩱၺ")
                     + (var4 != null ? var4.name : pretty(var0))
                     + a.b("䍛㪾뀾⸂ꗝ⍺餩\u10ca躓Р莶", 76497783)
                     + var1.substring(0, Math.max(0, var1.indexOf(46)))
                     + a.b("泻ᕆ鿚Ʊ詡\u0cd1뛑㽥ꄯ⮁걞嘤\ud8bb", 908487898)
                     + udf
                     + a.c(1993638936, "萹")
                     + ucu.keySet()
                     + (udl != null && udl.equals(ude) ? "" : a.c(1310200806, "Ꮡ橨\ue0f8纇\uf54c玤즸䁀\ude59咩퍵⤅Ꟊ㹤됺㋜裁݀鷢ᮠ鉑\ue80d曮"))
               );
         }

         if (var4 != null && isLeader() && secured()) {
            uet(var4);
         } else {
            uev();
         }

         return false;
      } else {
         if (var4 == null) {
            var4 = new ubm();
            var4.code = var0;
            var4.name = pretty(var0);
            var4.color = COLORS[ucr.size() % COLORS.length];
         }

         String var6 = ufq(var5, a.b("㴤", -1102234287));
         if (a.c(1888864260, "졷뇝㬍ꕰ⺴ꠜ").equals(var6)) {
            int var11 = var5.has(a.b("膎\uf832", 2081849829)) ? var5.get(a.c(-1138001272, "竣͟")).getAsInt() : -1;
            uct.removeIf(var2x -> !var2x.mine && var2x.from.equals(var0) && var2x.id == var11);
            return true;
         }

         if (!a.c(1163071052, "ล瞘ﵘ挰").equals(var6)) {
            return true;
         }

         ubj var7 = new ubj();
         var7.from = var0;
         var7.name = Objects.requireNonNullElse(ufk(ufq(var5, a.c(2031128102, "蹉"))), var4.name);
         var7.id = var5.has(a.b("\uec36閊", 1583148125)) ? var5.get(a.d("Σ稟", 1673600585, -1482154623)).getAsInt() : 0;
         var7.x = ufs(var5, a.b("ퟻ", 1022547842));
         var7.y = ufs(var5, a.d("䫺", 1457857990, 790785860));
         var7.z = ufs(var5, a.b("\ue1fa", 1703338369));
         if (Double.isFinite(var7.x)
            && Double.isFinite(var7.y)
            && Double.isFinite(var7.z)
            && !(Math.abs(var7.x) > 3.1E7)
            && !(Math.abs(var7.z) > 3.1E7)
            && !(Math.abs(var7.y) > 100000.0)) {
            var7.world = ufq(var5, a.d("瓫", 874631018, -83772425));
            var7.dim = ufq(var5, a.b("ﮂ", 624819175));
            var7.kind = var5.has(a.c(887694828, "▆")) && var5.get(a.c(1534983530, "ﴀ")).getAsInt() == 1 ? 1 : 0;
            var7.target = ufk(ufq(var5, a.c(22947168, "┑")));
            var7.born = var2;
            var7.life = Math.round(MARK_TIME.get() * 1000.0);
            var7.color = var7.danger() ? -1096636 : var4.color;
            String var8 = MinecraftClient.getInstance().getSession().getUsername();
            if (var7.target != null && var7.target.equalsIgnoreCase(var8)) {
               ufc(
                  var7.name
                     + (
                        var7.danger()
                           ? wap.s(
                              a.c(-912299550, "槛ွ髸Қ轑৽돧㨌ꐊ⺭ꥤ區\uddd6䑴츰䢄\uf282絔\ue7a9憼\ue84e鈐Ც蝹đ"),
                              a.d("뗶졘䋴\udcf0圦퇠每\ue241籫\uf6d9焈譽֯鱩ቂ钩⫴ꕜ㮄맇㐢䩭쓟弁\ud90f厢\uea12搼ﻈ磣", -449334283, -1490614723)
                           )
                           : wap.s(a.c(1734139359, "\uddf4ꐈ⻗낵㭻뷄ޖ踣ဥ骂ᵋ"), a.d("ㆊ䰥욊墅퍛喝\uefb4晆ﰂ犡\uf570\u0f70", -381938098, -1965021208))
                     )
               );
               ueg(var7.danger() ? a.d("䬉㊝롁☹귬⭊", -1702779158, 1913515425) : a.d("ﭳ苡࠾陇", 2099081318, -452162723), null);
               return true;
            }

            uef(var7);
            boolean var9 = visible(var7);
            System.out
               .println(
                  a.c(-1276939888, "燰ࡐ芐᳧霽ᇕꯋ∶뱺㛒녊䭽얾尒홃僿")
                     + var7.name
                     + (
                        var9
                           ? a.b("Ჭ敏\uef87燱慨粖", 1606098059)
                           : a.d("\ue2ad魔ᆆ迺Э芝㣅녠⼥ꗀ∏\ud873嚨켂䕐쏲", -677880369, 399097682)
                              + var7.world
                              + a.c(2078797588, "\uef35")
                              + var7.dim
                              + a.b("曯ὒ闎\u0ba5聵ۅ볅", 838166212)
                              + wlk.worldId()
                              + a.b("뉡", -12406208)
                              + wlk.dimensionId()
                     )
               );
            if (var9) {
               ueg(
                  var7.danger()
                     ? a.d("棝ᅉ鮕\u05ed踸࢞", -250277879, -684033898)
                     : (var7.target != null ? a.c(-799743579, "\ue1ed顿አ賙") : a.d("\ude06ꞎⵚ댢", 680133214, 841538572)),
                  ugg.anchor(var7, 1.0F)
               );
            } else if (!Objects.equals(var7.dim, wlk.dimensionId())) {
               ufc(
                  var7.name
                     + wap.s(
                        a.d("譊\uf2b6硩\ue60b淅\ueb7a儨\ud89d䚑찼䯭놔㽒\ua6ffⲭ\uaa5bဝ龋ձ茧ઞ炎︲既\ue386楋탵庳쐖䈃즽㝨봯ⓕꊛ⠰韡ᶑ", 1846823731, 776781951),
                        a.d("⅍峣혱䠿쏫䔨ｹ皂\ue8de晴\ue5bbῃ酣ࢪ芀\u0012빏㖌ꬫⴎꓺ\udedb健쮶䧕윜纠\uf0fa樄\uec20柦餿፵誄", -2080034760, 928649591)
                     )
               );
            } else {
               ufc(
                  var7.name
                     + wap.s(
                        a.d("듙촥䟺\ud998剖퓩溻\ue70e礂\uf3af瑾踇Á饬ጾ闈⾎ꀘ㫤벴㔍伝송婱\udc15囘\uef66愠ﮅ綇\uf622ࣤ芯\u1b4d鴉", -740283824, -1599103350),
                        a.b("댂캬䑾\uda70冤흧洶\ue4cd窑\uf43b矴趌̬髥\u10cf鉝Ⰿꏓ㵰뼵㚶䳤숧姻\udf86克\uec99押\uf83e縝\uf5a9\u0b0d脷", -2116177149)
                     )
               );
            }

            return true;
         } else {
            return true;
         }
      }
   }

   private static String uez(String var0) {
      if (var0 == null) {
         return wap.s(a.c(-1788251526, "爽ர腡Ἐ铞ታꠡ⇗뾁㕷닳䢐왌忧헠卆\ue90c曀ﱲ稪"), a.b("ᖨ汼\ue6d3粱\uf309痄쮉䙧\ud839勾핞⼪ꗣ㡏눔ヰ軝ž鯇", 1470370204));
      }

      return switch (var0) {
         case a.b("塸⇈\uab00㕚뺴㠌艅ய闺", -1184475105) -> wap.s(
            a.d("⁰姠퍼䵝욖䀪視玌\uedc4朧\ue0a3ᫌ鐆ණ螰ĕ뭆㒞길⠽ꆉ\udbd4啬캼", 43648304, 2071405846),
            a.d("룒셈䯨헧帴\udc9f抭\uef3d甀ￃ砚艩\u0cba鄗\u1f5e馫⏮갵㚄듉㤣䍺짜嘐큢媺\ue304浔\uf7ab", -1735175926, -432411171)
         );
         case a.d("쟕빲㒨\uaad3", 1330296986, -1200783560) -> wap.s(
            a.d("乹㟴봮⍊꣎⸫鐫ᶃ菊ॡ躵璖﨎控\ue9ed潒핞媃쀻䙫", 104054894, -177631657), a.b("芠ﭾ燑\uebbe摻\ue2c8壣핺伿얊䉓", 1080788614)
         );
         case a.b("ꁢ\ud9de匓쵵䚦쀒穜", 419471364) -> wap.s(
            a.d("Ч綻\uf776椐\ue2c3摷\ude39垑즇䌱쒬㺄끅⧮ꎺ┙鼆\u10c6試ఱ藋", 1565644642, -1838951663), a.d("%禁\uf351椵\ue6f0摓\uda12叡췆䜊샕㺽둵ⷋ\ua7eaⅡ", -92837965, 1458398117)
         );
         case a.d("⮀刢\ud8e8䚙", 1800896292, 1665094854) -> wap.s(
            a.d("欗ኗ顗ؠ跺\u0b12너㣣ꛯⰘꯘ冰\udf67䚚쳁䨠\uf07e", 977892761, 240197327), a.c(-1880539269, "㭶䋨졉噂\ud98d嬫\ue17f梁\uf6df籫﮾Ǉ輘ᚪ飧Ḟꑁ⮁")
         );
         case a.b("㿟䙭첻勱\ud91a徧\ue5ff氏", 732774325) -> wap.s(
            a.b("霅\uee98摀侮燱\uf713䴌쓾媡퀔垌궱⍣뫐ろ똹గ菅\u1977齈ᚠ泰\ue244", 1508611921), a.d("棪ᅿ鮦ǃ踆࣎닥㬜ꔷ\u2ffdꠢ利\ud89c䔷콮䦕\uf7c0硰\ue2c0撐\ued09靇᧵舣", 1439868495, -1287533913)
         );
         case a.c(-355883863, "\ua4cb\udd67垼짔䈘쒾绬") -> wap.s(
            a.d("兎⣃ꈝ㰩랷\u3101譊ʤ鳦ᙆ釐毩\ue537粔\uf694瀠쩲䖫\udf01奋킫\uaafb", -1833990894, 898880542),
            a.d("ⱎ喠\udf0b䅱쪮䰔\uf63f羳\ue1e4歐\uec8eዪ頥ǭ讽഻띻㢫ꈝ", 1919251925, -228762217)
         );
         case a.b("潈ᛱ鰣ə", 2101440299) -> wap.s(
            a.c(-1447696641, "\ue6b0鼽ᗧ讃\u0000蛡㲣땁⬘ꆤ☮\udc11勇쬹䄦쟔続\uf242棳\ueeb5朐ᴄ鎪ࡪ踏ә뵭"), a.c(1402594158, "\ue757麉ᐦ詐֞蜰㵬듯⫊ꑣ➡\udddf匍쫋䂜옐硊\uf386椽\uef1b")
         );
         case a.b("㕿䳝옛塻", -1776536311) -> wap.s(
            a.c(756061446, "镅\ueccf昜\uf822玳\uf505佄욲墵툈喌꿫ℴ뢘㊟됯ม膽ᬌ鵟ᒠ滺\ue053"), a.b("諹\uf352禂\ue783氦\uea93僂\udd2f䜗췑䩳뀁㺪ꌉ⥖ꮸᇶ鸭Ҕ苍ସ煥ﾬ搊", -1664119104)
         );
         case a.c(470606186, "\ue10c颼\u125f谁߇腥㬰닌") -> wap.s(a.b("꩔폓多윾䲨쨊灎狀柫\ued5b檓邶Ḩ螞ඃ謳ㄽ뺼␞ꉜ⮭凱", 835496475), a.c(856530375, "駙\ue031溉\uf4e5缺ﶞ䏟츼呼\udec2奣ꍨ"));
         case a.d("懇ᡷ銿\u0ce5蜁ƹ믮㈚걄⛢", -1647263274, -56647563) -> wap.s(
            a.d("ᙽ濭\ue53c筘\uf0d6瘳챼䖀\udb9a內횽Ⳉꈚ㮪뇮㝍赁ʒ頮ḱ鞂\uedd8挤\uf8a1绂\uf41a䶼", -951635846, 529278547),
            a.c(-1115870439, "⼢囼\udc53䘼짷佄\uf51f糭\ue2c5氖\uefa7ᖪ魸ʾ袛\u0e6e뀿㯵ꅅ✘껮퓊")
         );
         default -> var0;
      };
   }

   private static String ufa() {
      return udj == ucd.NO_SERVER
         ? wap.s(
            a.d("ၺ槽\ue33f級\uf699瀴쩪䏞\uddd1坱킱⫆ꐜ㷴럴ㄓ譋Ҟ鸾ᡸ針\uebca敶ﺼ磂\uf214", -1612297663, 1967020658),
            a.c(911845268, "ꎮ\uda03僝컛䕻쏁禙\uf478湄\ue48c捕餢\u17fb踰Д蛰㣞띻ⶽꮞ≮塊튙䵗쬧䆄\uf84d")
         )
         : wap.s(
            a.c(-1600476692, "ꦃ퀓嫛쓾佪짗玅充搠\uee97楓錳ᷥ萐ท製㋽뵸⟗ꆋ⠹券\udc9a䝘섡䯽\uf217簕\ue6f4悲\ueb05ᗇ龟"),
            a.d("灂\u09db荿ᥬ雚ဘꨶ⎿뷯㍆냴令쑒嶗ힱ儲\ueb7a擞︓础\uf5ab该ՙ黺\u18ff", 392071030, -899812560)
         );
   }

   private static void ufb(String var0, boolean var1) {
      udz = var0;
      uea = var1;
      ueb++;
      MinecraftClient var2 = MinecraftClient.getInstance();
      if (!(var2.currentScreen instanceof hlc) && var2.world != null) {
         izx.alert(wap.s(a.d("襯\uf0ef稯\ue458澂", -1940308102, 1139062336), a.d("ꭓ틍塬왧", -1262502738, 297341926)), var0, vhz.FRIENDS, !var1);
      }
   }

   private static void ufc(String var0) {
      izx.alert(wap.s(a.c(-568203025, "\ue8ba鄺\u1bfa薍๗"), a.d("\uee8e霐ᶱ莺", 2116546724, -391636431)), var0, vhz.FRIENDS, true);
   }

   private static void ufd(String var0, int var1, byte[] var2) {
      ucu.clear();
      ude = var0;
      udf = var1;
      ucu.put(var1, var2);
      uds = null;
      ufv();
   }

   private static void ufe() {
      while (ucu.size() > 3) {
         ucu.remove(((TreeMap)ucu).firstKey());
      }
   }

   private static String uff(String var0, String var1, byte[] var2, int var3) {
      try {
         JsonObject var4 = new JsonObject();
         var4.addProperty(a.d("㲉", -1628388570, 664338373), ufw.b64(var2));
         var4.addProperty(a.d("袠", 1904953047, -1038889453), var3);
         var4.addProperty(a.b("㇗", -1492635208), MinecraftClient.getInstance().getSession().getUsername());
         byte[] var5 = ufw.boxKey(udc, udd, var1);
         return ufw.seal(var5, a.c(-1790445640, "\uf7de蹢Ҧ髓") + udk + a.c(-178260090, "\uf7fb") + var0, var4.toString().getBytes(StandardCharsets.UTF_8));
      } catch (Exception var6) {
         System.out.println(a.c(1280651134, "⼜嚼\udc7c䈋집伹\uf528糔\ue29c桵\uefe0ᖖ魉˽袧๗둆㮍") + var6);
         return null;
      }
   }

   private static JsonObject ufg(String var0, String var1, String var2) {
      if (var2 != null && udc != null) {
         try {
            byte[] var3 = ufw.boxKey(udc, udd, var1);
            byte[] var4 = ufw.open(var3, a.d("罭ۑ谕በ", -239002140, -1935252753) + var0 + a.b("䚤", 2072528601) + udk, var2);
            return var4 == null ? null : JsonParser.parseString(new String(var4, StandardCharsets.UTF_8)).getAsJsonObject();
         } catch (Exception var5) {
            return null;
         }
      } else {
         return null;
      }
   }

   private static String ufh(String var0, JsonObject var1) {
      byte[] var2 = ucu.get(udf);
      if (var2 != null && secured()) {
         try {
            return udf + a.c(1730819222, "㒹") + ufw.seal(var2, var0 + a.d("豱", -2067285017, 937244651) + udf, var1.toString().getBytes(StandardCharsets.UTF_8));
         } catch (GeneralSecurityException var4) {
            return null;
         }
      } else {
         uev();
         return null;
      }
   }

   private static JsonObject ufi(String var0, String var1) {
      int var2 = var1.indexOf(46);
      if (var2 > 0 && udl != null && udl.equals(ude)) {
         int var3;
         try {
            var3 = Integer.parseInt(var1.substring(0, var2));
         } catch (NumberFormatException var8) {
            return null;
         }

         byte[] var4 = ucu.get(var3);
         if (var4 == null) {
            return null;
         }

         byte[] var5 = ufw.open(var4, var0 + a.c(1193674539, "ݖ") + var3, var1.substring(var2 + 1));
         if (var5 == null) {
            return null;
         }

         try {
            return JsonParser.parseString(new String(var5, StandardCharsets.UTF_8)).getAsJsonObject();
         } catch (RuntimeException var7) {
            return null;
         }
      } else {
         return null;
      }
   }

   private static void ufj(JsonObject var0) {
      String var1 = ufh(a.d("瓀൯螨ᧂ", -196674301, -1225815638) + udl + a.b("鬒", -1756259473) + udk, var0);
      if (var1 != null) {
         ufn(ufm(a.d("馛\ue034櫳", 1465524378, -573589137)).put(a.c(1802278384, "閒"), var1));
      }
   }

   private static String ufk(String var0) {
      String var1 = ufl(var0);
      if (var1 != null && var1.length() > 20) {
         var1 = var1.substring(0, 20);
      }

      return var1;
   }

   private static String ufl(String var0) {
      if (var0 == null) {
         return null;
      }

      StringBuilder var1 = new StringBuilder();

      for (char var5 : var0.toCharArray()) {
         if (var5 >= ' ' && var5 != 127 && var5 != 167) {
            var1.append(var5);
         }
      }

      String var6 = var1.toString().trim();
      return var6.isEmpty() ? null : var6;
   }

   private static ubp ufm(String var0) {
      return new ubp().put(a.d("k", 1310780117, -477173045), var0);
   }

   private static boolean ufn(ubp var0) {
      return ufo(var0.json);
   }

   private static boolean ufo(JsonObject var0) {
      if (udh != null && udj == ucd.ONLINE) {
         udh.send(var0.toString());
         return true;
      } else {
         return false;
      }
   }

   private static JsonArray ufp(JsonObject var0, String var1) {
      JsonElement var2 = var0.get(var1);
      return var2 != null && var2.isJsonArray() ? var2.getAsJsonArray() : new JsonArray();
   }

   private static String ufq(JsonObject var0, String var1) {
      JsonElement var2 = var0.get(var1);
      return var2 != null && var2.isJsonPrimitive() ? var2.getAsString() : null;
   }

   private static boolean ufr(JsonObject var0, String var1) {
      JsonElement var2 = var0.get(var1);
      return var2 != null && var2.isJsonPrimitive() && var2.getAsBoolean();
   }

   private static double ufs(JsonObject var0, String var1) {
      JsonElement var2 = var0.get(var1);
      return var2 != null && var2.isJsonPrimitive() ? var2.getAsDouble() : Double.NaN;
   }

   private static byte[] uft(JsonObject var0, String var1) {
      String var2 = ufq(var0, var1);
      if (var2 == null) {
         return null;
      }

      try {
         return ufw.unb64(var2);
      } catch (IllegalArgumentException var4) {
         return null;
      }
   }

   private static void ufu() throws GeneralSecurityException {
      if (udb == null || udc == null) {
         try {
            String var0 = ewk.get(a.c(1787517127, "墲ℒꯒ㖥빿"));
            if (var0 != null && !var0.isBlank()) {
               JsonObject var1 = JsonParser.parseString(var0).getAsJsonObject();
               String var2 = ufq(var1, a.c(571179594, "舢ﮝ煒"));
               String var3 = ufq(var1, a.d("犉\u0b3a臲ᾜ", 813051247, 1869832082));
               String var4 = ufq(var1, a.b("킗ꤣ⏧", 1077792996));
               if (var2 != null && var2.matches(a.c(9408076, "踘\uf7c2紌\ue369棦\uee1b吃\uddc9䎰쥉些듴㨹ꎊ⦐")) && var3 != null && var4 != null) {
                  udc = ufw.privateKey(var3);
                  ufw.publicKey(var4);
                  udb = var2;
                  udd = var4;
                  ude = ufq(var1, a.d("玟ਿ胿Ẉ镒", 1407920835, -1487906519));
                  udf = var1.has(a.b("焔ࢰ艼ᰁ韝", 521498996)) ? var1.get(a.c(-1525678925, "ﳓ蕷ྻ釆ᨚ")).getAsInt() : 0;
                  ucu.clear();
                  JsonElement var5 = var1.get(a.c(-2067369153, "獐૯耠ṛ"));
                  if (var5 != null && var5.isJsonObject()) {
                     for (Entry var7 : var5.getAsJsonObject().entrySet()) {
                        ucu.put(Integer.parseInt((String)var7.getKey()), ufw.unb64(((JsonElement)var7.getValue()).getAsString()));
                     }
                  }

                  return;
               }

               if (var2 != null && var2.matches(a.b("菮勤烺\uee9f攐\ue3ed姵퀿乆쒿䍭뤂㟏깼⑦", -200834118))) {
                  udb = var2;
               }
            }
         } catch (Exception var8) {
            System.out.println(a.c(1080872504, "칌럿㴣ꌛ⢟깺ᑻ鶝φ襲\u0ee5\uf4c4稂\ue3a0槵\uef09唑\uda84䀮왣侕㖐묹") + var8);
         }

         if (udb == null) {
            byte[] var9 = new byte[32];
            ufw.RANDOM.nextBytes(var9);
            udb = HexFormat.of().formatHex(var9);
         }

         KeyPair var10 = ufw.generate();
         udc = var10.getPrivate();
         udd = ufw.b64(var10.getPublic().getEncoded());
         ucu.clear();
         ude = null;
         udf = 0;
         ufv();
      }
   }

   private static void ufv() {
      if (udb != null && udc != null) {
         JsonObject var0 = new JsonObject();
         var0.addProperty(a.d("\ue7e6鹙ᒖ", 2039475014, 1497697480), udb);
         var0.addProperty(a.b("\uaacb퍸妰쟞", 1798613695), ufw.b64(udc.getEncoded()));
         var0.addProperty(a.b("큂꧶⌲", 1589694513), udd);
         if (ude != null) {
            var0.addProperty(a.d("ؼ羜\uf55c欫\ue0f1", -856379613, 1219602794), ude);
            var0.addProperty(a.b("쒄봠㟬ꦑ≍", -1408776988), udf);
            JsonObject var1 = new JsonObject();

            for (Entry var3 : ucu.entrySet()) {
               var1.addProperty(String.valueOf(var3.getKey()), ufw.b64((byte[])var3.getValue()));
            }

            var0.add(a.c(1312137900, "ꋃ\udb7c决쿈"), var1);
         }

         ewk.put(a.d("퇒ꡲ⊲볅㜟", -1570721030, 1748394845), var0.toString());
      }
   }

   static {
      VOLUME.visibleWhen(SOUNDS::get);
      LISTEN.visibleWhen(SOUNDS::get);
   }
}
