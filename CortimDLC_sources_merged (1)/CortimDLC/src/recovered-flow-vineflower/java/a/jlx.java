package a;

import flow.dev.a;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.PlayerListEntry;

public final class jlx extends jcs {
   public static final vkl FPS = new vkl(a.b("⥡僆\uda16", 1679108388), true);
   public static final vkl PING = new vkl(a.d("쑪뷢㜶ꥎ", -1682029326, 396067020), true);
   public static final vkl TPS = new vkl(a.d("팊꪿\u206f", -659267123, 1132507792), true);
   public static final vkl BPS = new vkl(a.c(2073813160, "\ue0e9饊\u139a"), true);
   public static final vkl COORDS = new vkl(a.d("\u0ad8獅練柺\uec3b檇탓夭읧䷇쨂", -20895621, 105980651), true);
   public static final vkl TIME = new vkl(a.b("촔뒘㹏ꀶ", 1931791684), false);
   public static final vkl ACCOUNT = new vkl(a.c(1738676770, "ᩤ揷\ue924睙ﲔ稾쁷"), true);
   public static final vkl ALERTS = new vkl(a.b("ἒ暘\uec43爲燐罖앀䳰튢堚\udfde▩ꭹ", 1326718795), true);
   public static final List<vmo> ISLAND = List.of(ACCOUNT, FPS, PING, TPS, BPS, COORDS, TIME, ALERTS);
   public static final vkl MUSIC = new vkl(a.d("濲ᙻ鲮˅褘", 918243743, 1191716389), true);
   public static final vlv VIEW = new vlv(
      a.b("鸺\ue7b4浫\uf308", -1132421528),
      a.d("݃绞\uf40f橣\ue1a5朖\udd52", -903719624, -2038148545),
      a.d("꓂\udd5f垎짢䈤쒗结", -1093632467, -337126741),
      a.c(-2002372180, "㧮䁬쪦哗")
   );
   public static final vkl EXPAND = new vkl(a.d("⥻僷\uda2c䑌쾔䤯\uf338窆\ue4d8渧\ue9baᏀ鴅ӣ軤ࠓ뉏㶜ꜧ", -406075007, -1233461076), true);
   public static final vkl COVER = new vkl(a.d("隿\uef22旨ﮊ灊", 1922162144, 787958553), true);
   public static final List<vmo> MUSIC_SETTINGS = List.of(VIEW, EXPAND, COVER);
   private static final float jly = 17.0F;
   private static final float jlz = 7.0F;
   private static final float jma = 11.0F;
   private static final float jmb = 11.0F;
   private static final float jmc = 200.0F;
   private static final float jmd = 44.0F;
   private static final float jme = 30.0F;
   private static final float jmf = 12.0F;
   private static final long jmg = 1700L;
   private static final long jmh = 4500L;
   private static final long jmi = 15000L;
   private static final long jmj = 200L;
   private static final long jmk = 2500L;
   private static final String jml = a.d("䞚㸉듍⪯ꅧ⟚鶛", 1448827076, 1952521993);
   private final vct jmm = new vct(190.0F, 0.8F);
   private final vct jmn = new vct(190.0F, 0.8F);
   private final vdc jmo = new vdc(0.38F, 1.0F);
   private jlr jmp = jlr.BASE;
   private jlr jmq = jlr.BASE;
   private final List<jlu> jmr = new ArrayList<>();
   private final jlu[] jms = new jlu[]{new jlu(), new jlu(), new jlu(), new jlu(), new jlu(), new jlu()};
   private long jmt;
   private String jmu = "";
   private static final int jmv = 6;
   private static final float jmw = 12.0F;
   private static final float jmx = 11.0F;
   private static final float jmy = 4.0F;
   private final List<jlo> jmz = new ArrayList<>();
   private jgd jna;
   private long jnb;
   private uok jnc;
   private final vcj jnd = new vcj(7.0F, 1.0F);
   private final vcj[] jne = new vcj[]{new vcj(14.0F), new vcj(14.0F), new vcj(14.0F), new vcj(14.0F)};
   private final vcj[] jnf = new vcj[]{new vcj(16.0F), new vcj(16.0F), new vcj(16.0F)};
   private final vcj[] jng = new vcj[]{new vcj(9.0F), new vcj(9.0F), new vcj(9.0F)};
   private final float[] jnh = new float[3];
   private float jni = -100.0F;
   private static final float jnj = 9.0F;
   private String jnk;
   private String jnl = "";
   private String jnm = "";
   private String jnn = "";
   private static final float jno = 2.3F;

   jlx() {
      super(a.d("\uda56ꏱ⤷띗㲗먹f覄ែ", -1824401247, -722533751), a.d("\ufb18芟࡙阹᷹魗℈꣪㚬", 1696813896, -24205298), true, 1, 0, 0.0F, 6.0F);
   }

   @Override
   public List<vmo> settings() {
      ArrayList var1 = new ArrayList<>(ISLAND);
      var1.add(MUSIC);
      var1.addAll(MUSIC_SETTINGS);
      return var1;
   }

   void toggled(kfe var1) {
      this.alert(
         var1.getDisplayName(),
         var1.isAction()
            ? wap.s(a.b("蘻ﾨ畬\ueb00惈\ue66e尨허䮖", -881031565), a.b("ﺹ蜢ඉ鎂ᡟ黤Ⓩ굀㌓릠㹾", 1266416290))
            : wap.s(
               var1.isEnabled() ? a.d("综ݬ", -387643594, 1657239943) : a.b("筪˲蠡", 484801318),
               var1.isEnabled() ? a.d("핶곯☽령㏧땀ཿ", -426125500, -1548220889) : a.d("\uebde鈶ᢔ蛤െ课㇟렦", 1512158149, -186164223)
            ),
         hlc.iconFor(var1.getCategory()),
         var1.isEnabled()
      );
   }

   void alert(String var1, String var2, vhz var3, boolean var4) {
      if (ALERTS.get()) {
         long var5 = System.currentTimeMillis();
         jlo var7 = null;

         for (jlo var9 : this.jmz) {
            if (var9.name.equals(var1) && var5 - var9.at < 1700L) {
               var7 = var9;
               break;
            }
         }

         if (var7 == null) {
            var7 = new jlo();
            var7.name = var1;
            var7.flip.set(var4 ? 0.0F : 1.0F);
            var7.shown.set(this.jnr(var5) ? 0.0F : 1.0F);
            this.jmz.add(var7);
            if (this.jmz.size() > 6) {
               this.jmz.remove(0);
            }
         }

         var7.on = var4;
         var7.state = var2;
         var7.icon = var3;
         var7.at = var5;
      }
   }

   private boolean jnr(long var1) {
      for (jlo var4 : this.jmz) {
         if (var1 - var4.at < 1700L) {
            return true;
         }
      }

      return false;
   }

   @Override
   void update(float var1, boolean var2) {
      long var3 = System.currentTimeMillis();
      this.jna = MUSIC.get() ? jgn.track() : null;
      if (this.jna == null && var2 && MUSIC.get()) {
         this.jna = new jgd(
            a.d("쇕롆㊂고✨ꆕᯔ", 1493875464, -1626244470),
            a.c(1023874074, "ᑚ淏\ue711祪\uf2ba琅칙䞴\ud9bf卭풔\u2ef8ꀢ"),
            a.b("峡┥꿽", 1806064815),
            true,
            0L,
            243000L,
            var3 - var3 % 243000L
         );
      }

      if (this.jna == null || this.jna.playing()) {
         this.jnb = 0L;
      } else if (this.jnb == 0L) {
         this.jnb = var3;
      }

      boolean var5 = this.jna != null && (this.jna.playing() || var3 - this.jnb < 15000L);
      boolean var6 = this.jna != null
         && (
            izx.pointer()
               || var5
                  && (
                     VIEW.is(a.b("\uf5dd豟ڕ飤", 221246879))
                        || EXPAND.get() && var3 - jgn.changedAt() < 4500L && !a.b("৻灨窱擎\uef06榻폺", 75696556).equals(this.jna.app())
                  )
         );
      boolean var7 = ALERTS.get() && this.jnr(var3);
      jlr var8;
      if (var7) {
         var8 = jlr.ALERT;
      } else if (var6) {
         var8 = jlr.MUSIC;
      } else {
         var8 = jlr.BASE;
      }

      if (var8 != this.jmp) {
         this.jmq = this.jmp;
         this.jmp = var8;
         this.jmo.restart();
      }

      this.jmo.update(var1);
      this.jns(var3);
      this.joe(var3, var7, var1);
      float var10 = 17.0F;
      float var9;
      switch (this.jmp) {
         case ALERT:
            var9 = this.jog(var3);
            var10 = this.joh();
            break;
         case MUSIC:
            var9 = 200.0F;
            var10 = 44.0F;
            break;
         default:
            var9 = this.jnw(null, 0.0F, 0.0F, var5);
      }

      this.jmm.step(var9, var1);
      this.jmn.step(var10, var1);
      boolean var11 = this.jna != null && this.jna.playing();
      double var12 = System.nanoTime() / 1.0E9;

      for (int var14 = 0; var14 < this.jne.length; var14++) {
         float var15 = (float)(0.5 + 0.25 * Math.sin(var12 * (7.1 + var14 * 2.3) + var14 * 1.7) + 0.25 * Math.sin(var12 * (11.3 - var14 * 1.9) + var14 * 0.6));
         this.jne[var14].step(var11 ? 0.25F + 0.75F * var15 : 0.18F, var1);
      }

      uok var16 = COVER.get() ? jgn.cover() : null;
      if (var16 != this.jnc) {
         this.jnc = var16;
         if (var16 != null) {
            this.jnd.set(0.0F);
         }
      }

      this.jnd.step(1.0F, var1);

      for (int var17 = 0; var17 < 3; var17++) {
         this.jng[var17].step(0.0F, var1);
      }
   }

   private void jns(long var1) {
      String var3 = (FPS.get() ? a.d("\uf1b6", 6791450, -581873461) : "")
         + (PING.get() ? a.c(-1508093659, "兔") : "")
         + (TPS.get() ? a.b("\uf26f", 182055450) : "")
         + (BPS.get() ? a.c(-193094021, "鸘") : "")
         + (COORDS.get() ? a.c(-1752659453, "詡") : "")
         + (TIME.get() ? a.c(-1626529438, "ℋ") : "");
      boolean var4 = !var3.equals(this.jmu);
      if (var4 || var1 - this.jmt >= 200L) {
         this.jmt = var1;
         this.jmu = var3;
         MinecraftClient var5 = MinecraftClient.method_1551();
         this.jmr.clear();
         int var6 = 0;
         if (FPS.get()) {
            jlu var7 = this.jms[var6++];
            jnt(var7, "", String.valueOf(var5.method_47599()), a.b("咧ⴀꟐ", -1889971006), 0, 0);
            this.jmr.add(var7);
         }

         if (PING.get()) {
            int var10 = joc(var5);
            jlu var8 = this.jms[var6++];
            jnt(var8, "", String.valueOf(var10), wap.unit(a.b("㝞仱", -103532751)), 0, var10 < 80 ? -12595334 : (var10 < 160 ? -865972 : -1092784));
            this.jmr.add(var8);
         }

         if (TPS.get()) {
            float var11 = jip.tps();
            jlu var16 = this.jms[var6++];
            int var9 = !(var11 < 0.0F) && !(var11 >= 18.0F) ? (var11 >= 12.0F ? -865972 : -1092784) : 0;
            jnt(var16, "", var11 < 0.0F ? a.b("ꮋ", 731548569) : jnu(var11), a.b("汋ᗾ鼮", -1273861060), var9, 0);
            this.jmr.add(var16);
         }

         if (BPS.get()) {
            jlu var12 = this.jms[var6++];
            jnt(var12, "", jnu(jip.bps()), wap.s(a.c(675383233, "螠︃瓓"), a.b("ͭ竖\uf411渎", -1138030760)), 0, 0);
            this.jmr.add(var12);
         }

         if (COORDS.get()) {
            ClientPlayerEntity var13 = var5.field_1724;
            String var17 = var13 == null
               ? a.b("⎿娞택亼앻", -1454627958)
               : var13.method_31477() + a.d("䦿", 125077958, -661274536) + var13.method_31478() + a.c(1154353709, "\u0a0c") + var13.method_31479();
            jlu var20 = this.jms[var6++];
            jnt(var20, a.c(501304440, "䰣㖓뽃"), var17, "", 0, 0);
            this.jmr.add(var20);
         }

         if (TIME.get()) {
            LocalTime var14 = LocalTime.now();
            jlu var18 = this.jms[var6];
            jnt(var18, "", vxu.hoursMinutes(var14.getHour(), var14.getMinute()), "", 0, 0);
            this.jmr.add(var18);
         }

         for (jlu var19 : this.jmr) {
            float var21 = var19.natural();
            if (var4 || var21 >= var19.wide || var1 - var19.wideAt > 2500L) {
               var19.wide = var21;
               var19.wideAt = var1;
            }
         }
      }
   }

   private static void jnt(jlu var0, String var1, String var2, String var3, int var4, int var5) {
      var0.label = var1;
      var0.value = var2;
      var0.unit = var3;
      var0.color = var4;
      var0.dot = var5;
   }

   private static String jnu(float var0) {
      return var0 >= 100.0F ? String.valueOf(Math.round(var0)) : vxu.fixed(var0, 1);
   }

   @Override
   boolean hasContent(boolean var1) {
      return true;
   }

   @Override
   float width() {
      return Math.max(17.0F, this.jmm.get());
   }

   @Override
   float height() {
      return Math.max(8.0F, this.jmn.get());
   }

   @Override
   void draw(DrawContext var1, float var2, boolean var3) {
      float var4 = this.width();
      float var5 = this.height();
      float var6 = Math.min(var5 * 0.5F, iov.r(11.0F));
      izx.panel(var1, var4, var5, var6);
      uut.pushScissor(var1, 0.0F, 0.0F, var4, var5);
      float var7 = this.jmo.linear();
      if (this.jmq != this.jmp && var7 < 1.0F) {
         float var8 = 1.0F - vcq.outCubic(Math.min(1.0F, var7 / 0.45F));
         if (var8 > 0.01F) {
            this.jnv(var1, this.jmq, var4, var5, var8, var2);
         }
      }

      float var9 = this.jmq == this.jmp ? 1.0F : vcq.outCubic(Math.max(0.0F, (var7 - 0.25F) / 0.75F));
      if (var9 > 0.01F) {
         var1.method_51448().pushMatrix();
         var1.method_51448().translate(0.0F, (1.0F - var9) * 3.0F);
         this.jnv(var1, this.jmp, var4, var5, var9, var2);
         var1.method_51448().popMatrix();
      }

      uut.popScissor(var1);
   }

   private void jnv(DrawContext var1, jlr var2, float var3, float var4, float var5, float var6) {
      uut.pushAlpha(var5);
      switch (var2) {
         case ALERT:
            this.joi(var1, var3, var4);
            break;
         case MUSIC:
            this.joj(var1, var3, var4, var6);
            break;
         default:
            boolean var7 = this.jna != null && (this.jna.playing() || System.currentTimeMillis() - this.jnb < 15000L);
            float var8 = this.jnw(null, 0.0F, 0.0F, var7);
            this.jnw(var1, (var3 - var8) * 0.5F, var4 * 0.5F, var7);
      }

      uut.popAlpha();
   }

   private float jnw(DrawContext var1, float var2, float var3, boolean var4) {
      float var5 = var2 + 7.0F - 1.0F;
      if (var1 != null
         && !uqe.draw(var1, var5 - 0.5F, var3 - 5.5F - 0.5F, 12.0F, iov.isLight(), -1)
         && !upt.draw(var1, var5, var3 - 5.5F, 11.0F, iov.logoTint())) {
         vjf.draw(var1, vhz.LOGO, var5 + 5.5F, var3, 8.6F, iov.text);
      }

      var5 += 14.5F;
      var5 = joa(var1, izx.BRAND, a.b("춏됔㻄ꂭ", -1968779827), var5, var3, iov.text);
      if (ACCOUNT.get()) {
         var5 = this.jnx(var1, job(var1, var5, var3), var3);
      }

      for (jlu var7 : this.jmr) {
         var5 = job(var1, var5, var3);
         float var8 = var5 + var7.wide;
         if (var1 != null) {
            float var9 = var5;
            if (!var7.label.isEmpty()) {
               var9 = izx.SMALL.draw(var1, var7.label, var5, izx.SMALL.centerTop(var3), iov.textMuted) + 3.0F;
            }

            if (var7.dot != 0) {
               uut.circle(var1, var9 + 1.6F, var3, 1.6F, var7.dot);
               var9 += 6.2F;
            }

            var9 = izx.VALUE.draw(var1, var7.value, var9, izx.VALUE.centerTop(var3), var7.color == 0 ? iov.text : var7.color);
            if (!var7.unit.isEmpty()) {
               izx.SMALL.draw(var1, var7.unit, var9 + 2.0F, izx.SMALL.centerTop(var3), iov.textMuted);
            }
         }

         var5 = var8;
      }

      if (var4 && this.jna != null) {
         var5 = job(var1, var5, var3);
         uok var15 = this.jnc;
         if (var15 != null) {
            if (var1 != null) {
               uut.image(var1, var15.view, var5, var3 - 5.5F, 11.0F, 11.0F, Math.min(5.5F, iov.r(3.0F)), -1);
            }

            var5 += 16.0F;
         }

         if (this.jna.playing()) {
            var5 = this.jod(var1, var5, var3, 3, 7.0F) + 5.0F;
         } else {
            if (var1 != null) {
               vjf.draw(var1, vhz.PAUSE, var5 + 3.5F, var3, 7.0F, iov.textDim);
            }

            var5 += 11.0F;
         }

         var5 = joa(var1, izx.TEXT, this.jnz(this.jna), var5, var3, iov.text);
      }

      return var5 + 7.0F - var2;
   }

   private float jnx(DrawContext var1, float var2, float var3) {
      String var4 = this.jny();
      float var5 = 13.0F + izx.VALUE.width(var4);
      if (var1 == null) {
         return var2 + var5;
      } else {
         float var6 = var3 - 4.5F;
         if (!hia.drawSelected(var1, var2, var6, 9.0F)) {
            uut.circle(var1, var2 + 4.5F, var3, 4.5F, iov.accent());
            izx.TINY.drawCentered(var1, var4.substring(0, 1).toUpperCase(Locale.ROOT), var2 + 4.5F, izx.TINY.centerTop(var3), iov.onAccent());
         }

         izx.VALUE.draw(var1, var4, var2 + 9.0F + 4.0F, izx.VALUE.centerTop(var3), iov.text);
         return var2 + var5;
      }
   }

   private String jny() {
      String var1 = hia.account();
      if (!var1.equals(this.jnk)) {
         this.jnk = var1;
         this.jnl = izx.VALUE.ellipsize(var1.isEmpty() ? a.b("鿬\ue677沧\uf2ce", -209674322) : var1, 70.0F);
      }

      return this.jnl;
   }

   private String jnz(jgd var1) {
      String var2 = var1.artist().isEmpty() ? var1.title() : var1.title() + a.d("멚썼䤸", 1447740147, 955414666) + var1.artist();
      if (!var2.equals(this.jnm)) {
         this.jnm = var2;
         this.jnn = izx.TEXT.ellipsize(var2, 110.0F);
      }

      return this.jnn;
   }

   private static float joa(DrawContext var0, vdn var1, String var2, float var3, float var4, int var5) {
      return var0 != null ? var1.draw(var0, var2, var3, var1.centerTop(var4), var5) : var3 + var1.width(var2);
   }

   private static float job(DrawContext var0, float var1, float var2) {
      float var3 = 5.5F;
      if (var0 != null) {
         uut.circle(var0, var1 + var3, var2, 0.85F, ujt.mulAlpha(iov.textMuted, 0.6F));
      }

      return var1 + 11.0F;
   }

   private static int joc(MinecraftClient var0) {
      if (var0.method_1562() != null && var0.field_1724 != null) {
         PlayerListEntry var1 = var0.method_1562().method_2871(var0.field_1724.method_5667());
         return var1 != null ? Math.max(0, var1.method_2959()) : 0;
      } else {
         return 0;
      }
   }

   private float jod(DrawContext var1, float var2, float var3, int var4, float var5) {
      float var6 = 1.5F;
      float var7 = 1.2F;
      if (var1 != null) {
         for (int var8 = 0; var8 < var4; var8++) {
            float var9 = Math.max(var6, var5 * this.jne[var8].get());
            uut.round(var1, var2 + var8 * (var6 + var7), var3 - var9 * 0.5F, var6, var9, var6 * 0.5F, iov.accent());
         }
      }

      return var2 + var4 * var6 + (var4 - 1) * var7;
   }

   private void joe(long var1, boolean var3, float var4) {
      for (int var5 = this.jmz.size() - 1; var5 >= 0; var5--) {
         jlo var6 = this.jmz.get(var5);
         boolean var7 = var1 - var6.at < 1700L;
         var6.shown.step(!var7 && var3 ? 0.0F : 1.0F, var4);
         if (var1 - var6.at > 140L) {
            var6.flip.step(var6.on ? 1.0F : 0.0F, var4);
         }

         boolean var8 = var3 ? var6.shown.get() <= 0.01F : this.jmp != jlr.ALERT && this.jmo.linear() >= 1.0F;
         if (!var7 && var8) {
            this.jmz.remove(var5);
         }
      }
   }

   private static float jof(jlo var0) {
      return 21.1F + izx.HEAD.width(var0.name) + 5.0F + izx.VALUE.width(var0.state) + 11.0F;
   }

   private float jog(long var1) {
      float var3 = 17.0F;

      for (jlo var5 : this.jmz) {
         float var6 = jof(var5);
         var3 = Math.max(var3, var1 - var5.at < 1700L ? var6 : var6 * var5.shown.get());
      }

      return var3;
   }

   private float joh() {
      float var1 = 0.0F;

      for (jlo var3 : this.jmz) {
         var1 += var3.shown.get();
      }

      return Math.max(17.0F, 8.0F + var1 * 12.0F);
   }

   private void joi(DrawContext var1, float var2, float var3) {
      long var4 = System.currentTimeMillis();
      float var6 = this.jog(var4);
      float var7 = (var2 - var6) * 0.5F + 11.0F;
      float var8 = (var3 - this.joh()) * 0.5F + 4.0F;
      float var9 = vcq.clamp01(1.0F - Math.max(0.0F, var6 - var2) / 6.0F);
      float var10 = izx.HEAD.capHeight() * 0.5F + 1.5F;
      int var11 = iov.accent();
      long var12 = 0L;

      for (jlo var15 : this.jmz) {
         var12 = Math.max(var12, var15.at);
         float var16 = var15.shown.get();
         float var17 = var8 + 12.0F * var16 * 0.5F;
         var8 += 12.0F * var16;
         if (!(var16 <= 0.01F)) {
            float var18 = Math.max(2.5F - (var17 - var10), var17 + var10 - (var3 - 2.5F));
            float var19 = var9 * vcq.clamp01(1.0F - Math.max(0.0F, var18) / 3.0F);
            if (!(var19 <= 0.01F)) {
               float var20 = vcq.outCubic(var16);
               uut.pushAlpha(Math.min(1.0F, var16 * 1.4F) * var19);
               var1.method_51448().pushMatrix();
               var1.method_51448().translate(0.0F, (1.0F - var20) * 3.0F);
               float var21 = vcq.clamp01(var15.flip.get());
               float var22 = vcq.outBack(vcq.clamp01((float)(var4 - var15.at) / 320.0F));
               float var23 = var7 + 2.3F;
               if (var21 > 0.01F) {
                  uut.circle(var1, var23, var17, 2.3F * (1.6F + 0.5F * var22), ujt.withAlpha(var11, Math.round(46.0F * var21)));
               }

               uut.circle(var1, var23, var17, 2.3F * Math.max(0.2F, var22), ujt.lerp(iov.textMuted, var11, var21));
               float var24 = var7 + 4.6F + 5.5F;
               var24 = izx.HEAD.draw(var1, var15.name, var24, izx.HEAD.centerTop(var17), iov.text) + 5.0F;
               izx.VALUE.draw(var1, var15.state, var24, izx.VALUE.centerTop(var17), ujt.lerp(iov.textMuted, var11, var21));
               var1.method_51448().popMatrix();
               uut.popAlpha();
            }
         }
      }

      float var25 = 1.0F - vcq.clamp01((float)(var4 - var12) / 1700.0F);
      if (var12 > 0L && var25 > 0.0F) {
         float var26 = Math.min(var3 * 0.5F, iov.r(11.0F));
         float var27 = (var2 - var26 * 2.0F) * var25;
         uut.round(var1, (var2 - var27) * 0.5F, var3 - 1.6F, var27, 0.8F, 0.4F, ujt.withAlpha(var11, 110));
      }
   }

   private void joj(DrawContext var1, float var2, float var3, float var4) {
      jgd var5 = this.jna;
      if (var5 != null) {
         float var6 = (var2 - 200.0F) * 0.5F;
         float var7 = (var3 - 44.0F) * 0.5F;
         float var8 = var6 + 7.0F;
         float var9 = var7 + 7.0F;
         float var10 = Math.min(15.0F, iov.r(6.0F));
         uok var11 = this.jnc;
         float var12 = 0.9F + 0.1F * vcq.outCubic(this.jnd.get());
         var1.method_51448().pushMatrix();
         var1.method_51448().translate(var8 + 15.0F, var9 + 15.0F);
         var1.method_51448().scale(var12, var12);
         uut.shadow(var1, -15.0F, -13.5F, 30.0F, 30.0F, var10, 5.0F, 1879048192);
         if (var11 != null) {
            uut.image(var1, var11.view, -15.0F, -15.0F, 30.0F, 30.0F, var10, -1);
         } else {
            uut.round(var1, -15.0F, -15.0F, 30.0F, 30.0F, var10, iov.field);
            vjf.draw(var1, vhz.MUSIC, 0.0F, 0.0F, 13.0F, iov.textDim);
         }

         uut.outlineGradientV(var1, -15.0F, -15.0F, 30.0F, 30.0F, var10, 1.0F, 822083583, 150994943);
         var1.method_51448().popMatrix();
         float var13 = var8 + 30.0F + 8.0F;
         float var14 = var6 + 200.0F - 8.0F;
         boolean var15 = izx.pointer();
         float var16 = var15 ? 40.0F : 17.0F;
         float var17 = var14 - var16 - 6.0F;
         jok(var1, izx.TITLE, var5.title(), var13, var7 + 12.0F, var17 - var13, iov.text);
         String var18 = var5.artist().isEmpty() ? var5.source() : var5.artist() + a.d("䃂㥳댷ⷑꘆ", -1413652610, 1241194393) + var5.source();
         izx.SUB.draw(var1, izx.SUB.ellipsize(var18, var17 - var13), var13, izx.SUB.centerTop(var7 + 22.0F), iov.textDim);
         float var19 = var7 + 34.0F;
         float var20 = var5.progress();
         String var21 = jol(var5.position());
         String var22 = var5.duration() > 0L ? jol(var5.duration()) : "";
         float var23 = izx.SMALL.width(var21);
         izx.SMALL.draw(var1, var21, var13, izx.SMALL.centerTop(var19), iov.textMuted);
         if (!var22.isEmpty()) {
            izx.SMALL.drawRight(var1, var22, var14, izx.SMALL.centerTop(var19), iov.textMuted);
            float var24 = var13 + var23 + 5.0F;
            float var25 = var14 - izx.SMALL.width(var22) - 5.0F - var24;
            jeq.bar(var1, var24, var19 - 0.75F, var25, var20, iov.accent(), iov.accent2());
            if (var20 >= 0.0F) {
               float var26 = var24 + var25 * var20;
               uut.shadow(var1, var26 - 2.0F, var19 - 1.6F, 4.0F, 4.0F, 2.0F, 1.5F, Integer.MIN_VALUE);
               uut.circle(var1, var26, var19, 2.0F, -1);
            }
         }

         if (var15) {
            float var33 = var7 + 17.0F;
            this.jni = var33 - 6.0F;
            vhz[] var34 = new vhz[]{vhz.PREV, var5.playing() ? vhz.PAUSE : vhz.PLAY, vhz.NEXT};
            float var35 = izx.localMouseX(this);
            float var27 = izx.localMouseY(this);

            for (int var28 = 0; var28 < 3; var28++) {
               float var29 = var14 - 12.0F * (3 - var28) - 2.0F * (2 - var28);
               this.jnh[var28] = var29;
               float var30 = this.jnf[var28].step(var35 >= var29 && var35 < var29 + 12.0F && var27 >= this.jni && var27 < this.jni + 12.0F, var4);
               float var31 = 1.0F - 0.12F * this.jng[var28].get();
               var1.method_51448().pushMatrix();
               var1.method_51448().translate(var29 + 6.0F, var33);
               var1.method_51448().scale(var31, var31);
               boolean var32 = var28 == 1;
               if (var32) {
                  uut.shadow(var1, -6.0F, -5.2F, 12.0F, 12.0F, 6.0F, 2.0F, 1879048192);
                  uut.circle(var1, 0.0F, 0.0F, 6.0F, ujt.lerp(iov.accent(), -1, 0.12F * var30));
               } else if (var30 > 0.01F) {
                  uut.circle(var1, 0.0F, 0.0F, 6.0F, ujt.withAlpha(iov.hover, Math.min(255, Math.round(ujt.alpha(iov.hover) * 3.0F * var30))));
               }

               vjf.draw(
                  var1,
                  var34[var28],
                  var32 && !var5.playing() ? 0.6F : 0.0F,
                  0.0F,
                  var32 ? 6.5F : 7.0F,
                  var32 ? iov.onAccent() : ujt.lerp(iov.textDim, iov.text, var30)
               );
               var1.method_51448().popMatrix();
            }
         } else {
            this.jni = -100.0F;
            this.jod(var1, var14 - 6.0F - 3.6000001F, var7 + 17.0F, 4, 12.0F);
         }
      }
   }

   private static void jok(DrawContext var0, vdn var1, String var2, float var3, float var4, float var5, int var6) {
      float var7 = var1.width(var2);
      float var8 = var1.centerTop(var4);
      if (var7 <= var5) {
         var1.draw(var0, var2, var3, var8, var6);
      } else {
         float var9 = 24.0F;
         float var10 = 18.0F;
         float var11 = 1.6F;
         float var12 = (var7 + var9) / var10 + var11;
         float var13 = (float)(System.nanoTime() / 1.0E9 % var12);
         float var14 = Math.max(0.0F, var13 - var11) * var10;
         uut.pushScissor(var0, var3, var8 - 2.0F, var5, var1.height() + 4.0F);
         var1.draw(var0, var2, var3 - var14, var8, var6);
         var1.draw(var0, var2, var3 - var14 + var7 + var9, var8, var6);
         uut.popScissor(var0);
      }
   }

   private static String jol(long var0) {
      return vxu.clock(Math.max(0L, var0 / 1000L));
   }

   @Override
   boolean mouseClicked(float var1, float var2, int var3) {
      if (var3 == 0 && this.jmp == jlr.MUSIC && !(this.jni < -50.0F) && !(var2 < this.jni) && !(var2 >= this.jni + 12.0F)) {
         String[] var4 = new String[]{a.c(-76210768, "᷄摷\ueeb3烑"), a.d("\uf630辚Ձ鬰წ陔", -1932836641, 552449693), a.c(1264873060, "渎឴鵺̇")};

         for (int var5 = 0; var5 < 3; var5++) {
            if (var1 >= this.jnh[var5] && var1 < this.jnh[var5] + 12.0F) {
               this.jng[var5].set(1.0F);
               jgn.command(var4[var5]);
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }
}
