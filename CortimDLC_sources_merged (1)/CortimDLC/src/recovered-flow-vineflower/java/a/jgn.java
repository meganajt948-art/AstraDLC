package a;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import flow.dev.a;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.ProcessBuilder.Redirect;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.imageio.ImageIO;
import net.minecraft.util.Util;
import net.minecraft.util.Util.OperatingSystem;

public final class jgn {
   private static final String jgo = a.d("\ueb81鉹ᢠ蛒ഝ说\u31e5렜♂곾⬥턚後옼䱷쫜烎＃施\ue3f4樓၅黿է荆ঔ끥", -1695641948, 591226129);
   private static final long jgp = 8000L;
   private static final int jgq = 5;
   private static final int jgr = 96;
   private static final ExecutorService jgs = Executors.newSingleThreadExecutor(var0 -> {
      Thread var1 = new Thread(var0, a.c(-1395982246, "\u0005禞\uf34e洧\ue6b5怖\uda0b叻춼䝚샙㪴둮\u2dc7Ꞅⅲ鬴ᒢ蹒ࠏ臹﮲甇\ueecb梷"));
      var1.setDaemon(true);
      return var1;
   });
   private static volatile jgd jgt;
   private static volatile String jgu = a.b("뽌월䰇", -2098348288);
   private static volatile long jgv;
   private static volatile BufferedImage jgw;
   private static volatile String jgx;
   private static volatile int jgy;
   private static uok jgz;
   private static String jha;
   private static int jhb;
   private static final List<Object[]> jhc = new ArrayList<>();
   private static Process jhd;
   private static Writer jhe;
   private static long jhf;
   private static int jhg;
   private static boolean jhh;

   private jgn() {
   }

   public static jgd track() {
      return jgt;
   }

   public static long changedAt() {
      return jgv;
   }

   public static String summary() {
      jgd var0 = jgt;
      if (var0 == null) {
         return wap.t(jgu);
      }

      String var1 = var0.jgg.isEmpty() ? var0.jgf : var0.jgf + a.c(-1089893826, "訝페祿") + var0.jgg;
      return (var0.jgh ? "" : wap.s(a.b("醸\ue838拿ﲈ睉\uf1f9䯮슈局", -1635806751), a.c(1549672490, "\u243d嶣휃䤆싖䁷荒珕"))) + var1;
   }

   public static boolean supported() {
      return Util.getOperatingSystem() == OperatingSystem.WINDOWS;
   }

   public static synchronized void tick(boolean var0) {
      jhs();
      if (!supported()) {
         jgu = a.d("筰˿蠫ᙐ鶌ᬥꅲ⣐뛀㱰뮡䇅", -2001992774, 1127839889);
      } else if (!var0) {
         if (jhd != null) {
            jhl();
         }

         jgu = a.c(-1717896586, "墨莢ॱ");
      } else {
         long var1 = System.currentTimeMillis();
         if (jhd == null && var1 >= jhf) {
            if (jhg >= 5) {
               jgu = a.b("蕗ﳝ瘁\ue867控\ue51e彈횴䣨쉗䖍", -336100087);
               return;
            }

            jhk();
         }

         BufferedImage var3 = jgw;
         if (var3 != null) {
            jgw = null;
            if (jgz != null) {
               jhc.add(new Object[]{jgz, unf.frame()});
            }

            jgz = uok.upload(a.b("ࢫ焖ﯜ斾\uee7e", -1611396915), var3, false);
            jha = jgx;
            jhb = jgy;
         }
      }
   }

   public static uok cover() {
      jgd var0 = jgt;
      if (var0 != null && jgz != null) {
         boolean var1 = var0.key().equals(jha) || System.currentTimeMillis() - jgv < 3000L;
         return var1 ? jgz : null;
      } else {
         return null;
      }
   }

   public static int coverColor() {
      return jhb;
   }

   public static synchronized void command(String var0) {
      Writer var1 = jhe;
      if (var1 != null) {
         jgd var2 = jgt;
         if (var2 != null && var0.equals(a.d("테꣦∽뱌㞐넨", 1453051872, -1753997602))) {
            jgt = new jgd(var2.jge, var2.jgf, var2.jgg, !var2.jgh, var2.position(), var2.jgj, System.currentTimeMillis());
         }

         jgs.execute(() -> {
            try {
               var1.write(var0 + a.c(1933145530, "疱"));
               var1.flush();
            } catch (Exception var3) {
            }
         });
      }
   }

   public static synchronized void shutdown() {
      jhl();
      jhf = Long.MAX_VALUE;
   }

   private static void jhk() {
      try {
         String var0;
         try (InputStream var1 = jgn.class.getResourceAsStream(a.d("壟℧\uabfe㖌빃㢪芻ୂ锜ᾠ须扄\uecd2畢Ｉ禂쎐䱝훣傪\ud94dꌛⶡ똹〘뫊̻", -632328891, -770624082))) {
            if (var1 == null) {
               throw new IllegalStateException(a.d("눋쮾䅷\udf06哋퉽栧\ue191翁\uf539狠袒ٝ龴ᖥ鍜⤒ꛎ㱵멪㏜䦌윧岬\uda8e偃\ue9fd枴ﵓ笅\uf0bfว萶᷄鯕", -468076586, -1715141229));
            }

            var0 = new String(var1.readAllBytes(), StandardCharsets.UTF_8);
         }

         StringBuilder var10 = new StringBuilder(var0.length());

         for (String var5 : var0.split(a.b("霁\uee82摤", 461412111))) {
            String var6 = var5.strip();
            if (!var6.isEmpty() && !var6.startsWith(a.b("ࢋ", 272173225))) {
               var10.append(var5).append('\n');
            }
         }

         String var11 = Base64.getEncoder().encodeToString(var10.toString().getBytes(StandardCharsets.UTF_16LE));
         ProcessBuilder var12 = new ProcessBuilder(
            jhn(),
            a.d("鯂\ue210棢\uf6ac絙ﯵ䆯졑嘋\udcb3", 1278059558, -2044969021),
            a.c(-1377521813, "꽉횛屩숙䧩콿甶ﳖ択\ue83c濭開ᭁ苯ࢯ"),
            a.b("᳀攙\ueff7熛琢糭욿体턊宺\udc57☙\ua8cdㅹ묠㷋", 330308861),
            a.d("혶꾼╦묆ッ뙲", -1178783379, 390719263),
            a.c(664564522, "猈\u0ad1耩ṕ閎ጴꥦₖ뻮㑳뎢䧓윈庶퓯"),
            var11
         );
         var12.redirectError(Redirect.DISCARD);
         Process var13 = var12.start();
         jhd = var13;
         jhe = new OutputStreamWriter(var13.getOutputStream(), StandardCharsets.UTF_8);
         jgu = a.b("疘ఎ蛈ᢪ鍻ᗗ꾃♻顥", 2044753346);
         Thread var14 = new Thread(() -> jho(var13), a.d("鷺股ੱ鐘ᾊ餩⌴\uaac4㒃빥㧦쎋䵑퓸庻\ud84d戋", 1080463459, -1569298162));
         var14.setDaemon(true);
         var14.start();
         if (!jhh) {
            jhh = true;
            Runtime.getRuntime().addShutdownHook(new Thread(jgn::shutdown, a.d("셾룥㈵걜⟎ꅭ᭰銀ೇ蘡Ƣ\ufbcf甕\uecbc替\ue009婏헙伹쥯䂃㫍", 903492702, -837946000)));
         }
      } catch (Exception var9) {
         System.out.println(a.c(-2065117516, "컎띢㶛ꏩ⠦껒ᓮ鵢ͳ觃จ\uf42e窩\ue304楚\uefb3嗬\uda3a䂀욖伴㕾믂 Ꙭⲵ锃᭟膫ߴ豎狀\uf895") + var9);
         jhm();
      }
   }

   private static synchronized void jhl() {
      Process var0 = jhd;
      jhd = null;
      jgt = null;
      if (jhe != null) {
         try {
            jhe.close();
         } catch (Exception var2) {
         }

         jhe = null;
      }

      if (var0 != null) {
         var0.destroy();
      }
   }

   private static synchronized void jhm() {
      jhg++;
      jhd = null;
      jhe = null;
      jgt = null;
      jgu = jhg >= 5 ? a.d("샏륅㎙귿☿ꂆ\u1ad0錬൰蟏\u0015", 1542419032, 1380430537) : a.c(1058830915, "稚Μ襙ᜯ鳭ᩏꀚ⧶랮㴖骄");
      jhf = System.currentTimeMillis() + 8000L * jhg;
   }

   private static String jhn() {
      String var0 = System.getenv(a.c(1726359160, "☡徺핣䬕샓䙪ﰆ痊\ueb95愿"));
      if (var0 != null) {
         Path var1 = Path.of(
            var0,
            a.d("녩죲䈫\udc5d垛턢欯\ue2df", -1418368008, 1055185610),
            a.b("퉃ꯌ℘뽣㒿눖ࡁ膓ῳ镚ኛ\ue8fd昋ﾁ痟\uf327䥨", -591146491),
            a.d("觘\uf02e竢\ue48d", -1058817277, 505098921),
            a.b("쳅땫㾠ꇃ⨃겳\u16fb鼇ő诠\u0c71\uf64b碁\ue12d", -1450980165)
         );
         if (Files.isRegularFile(var1)) {
            return var1.toString();
         }
      }

      return a.b("\u0df5瑛ﺐ想\ueb33涃ퟋ帷쁡䫐쵁㝻릱”", 1977617803);
   }

   private static void jho(Process var0) {
      boolean var1 = false;

      String var3;
      try (BufferedReader var2 = new BufferedReader(new InputStreamReader(var0.getInputStream(), StandardCharsets.UTF_8))) {
         while ((var3 = var2.readLine()) != null) {
            if (!var3.isEmpty() && var3.charAt(0) == '\ufeff') {
               var3 = var3.substring(1);
            }

            var1 = true;
            if (var3.startsWith(a.c(567076173, "\ue518鲮ᙨ蠌ϊ蔞"))) {
               jhp(var3.substring(6));
            } else if (var3.startsWith(a.c(-1934398473, "殲ሐ飅ۀ"))) {
               jhq(var3.substring(4));
            } else if (var3.equals(a.c(870339501, "叧⩗ꂅ㻿"))) {
               jgt = null;
               jgu = a.b("먐쎀䥈휥峳\uda45怟\ue9a9瞦ﴋ竕肼\u0e7b韍ᶗ", -339494319);
            } else if (var3.startsWith(a.b("\uf2b3謕ǆ鿅", -877006094))) {
               System.out.println(a.c(-510638193, "䟁㹭뒔⫦ꄩ⟝鷡ᑭ詼Ì蜇紡\uf3a6樋\ue055暼\udce3匵즏侃왮") + var3.substring(4));
            }
         }
      } catch (Exception var9) {
      }

      synchronized (jgn.class) {
         if (jhd == var0) {
            if (var1) {
               jhg = 0;
            }

            jhm();
         }
      }
   }

   private static void jhp(String var0) {
      try {
         JsonObject var1 = JsonParser.parseString(var0).getAsJsonObject();
         String var2 = var1.get(a.c(-1347011835, "㭴䋘젖噿\udda1")).getAsString().trim();
         if (var2.isEmpty()) {
            jgt = null;
            jgu = a.d("챦뗶㼾ꅓ⪅갳ᙩ鿟ǐ譽ಣ\uf6ca砍\ue1bb毡", 187430479, -1875166616);
            return;
         }

         jgd var3 = new jgd(
            var1.get(a.d("⏷婗킄", 634680625, -1137027420)).getAsString(),
            var2,
            var1.get(a.c(-1811997005, "Ổ杶\ueda3珏\uf802纴")).getAsString().trim(),
            var1.get(a.d("麈\ue725添\uf392硕ﻣ䒹", -279964226, 1437305665)).getAsBoolean(),
            var1.get(a.b("ꋢ\udb4c冃", 459121297)).getAsLong(),
            var1.get(a.b("䘕㾵땡", 244008562)).getAsLong(),
            System.currentTimeMillis()
         );
         jgd var4 = jgt;
         if (var4 == null || !var4.key().equals(var3.key())) {
            jgv = System.currentTimeMillis();
         }

         jgt = var3;
         jgu = var3.jgh ? a.b("两㞩뵷⌞꣙\u2e6f鐵", 779112051) : a.b("兢⣢ꈥ㱒랓ㄣ", -331919052);
      } catch (RuntimeException var5) {
         System.out.println(a.b("릜쀰䫉풻彴\ud980掼\uea30琡ﺑ祚荼\u0dfb鑖Ḉ飡⊾굨㟒뇞㠳䈠첐坄텿导\ue258氜\uf6f4炸\ufb0dֈ", -788940313) + var5);
      }
   }

   private static void jhq(String var0) {
      jgd var1 = jgt;

      try {
         BufferedImage var2 = ImageIO.read(new ByteArrayInputStream(Base64.getDecoder().decode(var0)));
         if (var2 == null || var1 == null) {
            return;
         }

         int var3 = Math.min(var2.getWidth(), var2.getHeight());
         BufferedImage var4 = new BufferedImage(96, 96, 1);
         Graphics2D var5 = var4.createGraphics();
         var5.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
         var5.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
         int var6 = (var2.getWidth() - var3) / 2;
         int var7 = (var2.getHeight() - var3) / 2;
         var5.drawImage(var2, 0, 0, 96, 96, var6, var7, var6 + var3, var7 + var3, null);
         var5.dispose();
         jgy = jhr(var4);
         jgx = var1.key();
         jgw = var4;
      } catch (Exception var8) {
      }
   }

   private static int jhr(BufferedImage var0) {
      double var1 = 0.0;
      double var3 = 0.0;
      double var5 = 0.0;
      double var7 = 0.0;

      for (byte var9 = 0; var9 < var0.getHeight(); var9 += 3) {
         for (byte var10 = 0; var10 < var0.getWidth(); var10 += 3) {
            int var11 = var0.getRGB(var10, var9);
            int var12 = var11 >> 16 & 0xFF;
            int var13 = var11 >> 8 & 0xFF;
            int var14 = var11 & 0xFF;
            int var15 = Math.max(var12, Math.max(var13, var14));
            int var16 = Math.min(var12, Math.min(var13, var14));
            double var17 = 0.05 + (var15 - var16) / 255.0 * (0.3 + var15 / 255.0);
            var1 += var12 * var17;
            var3 += var13 * var17;
            var5 += var14 * var17;
            var7 += var17;
         }
      }

      if (var7 <= 0.0) {
         return -1;
      }

      float[] var19 = Color.RGBtoHSB((int)(var1 / var7), (int)(var3 / var7), (int)(var5 / var7), null);
      return 0xFF000000 | Color.HSBtoRGB(var19[0], Math.min(1.0F, var19[1] * 1.25F), Math.max(0.75F, var19[2])) & 16777215;
   }

   private static void jhs() {
      long var0 = unf.frame();
      jhc.removeIf(var2 -> {
         if (var0 - (Long)var2[1] > 2L) {
            ((uok)var2[0]).close();
            return true;
         } else {
            return false;
         }
      });
   }
}
