package a;

import flow.dev.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttackRangeComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MaceItem;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;

public class kmy extends kfe {
   private static final int kmz = 10;
   private static final int kna = 1;
   private static final int knb = 3;
   private static final double knc = 0.05;
   private static final boolean knd = true;
   private static final int kne = 3;
   private static final Field knf = vxr.find(
      MinecraftClient.class,
      a.d("綖Ь軮Ⴥ魑ᷤꞰ⹊뀓㪳뵳䜅지倫\uda35峋\ue689楊\uf3f9疄ﰟ虌ࣾ", 1766787167, -810322512),
      a.d("ፕ櫫\ue034繌\uf593猙줤䃓\ude8c吻", 1705560683, 1537530194),
      a.d("ೳ", -2017127155, 1556879798)
   );
   private static kmy kng;
   private final vmc knh = this.add(new vmc(a.b("⍃嫩퀾丱얘䍖句烹", -113629334), 1.0, 0.3, 1.6, 0.05).percent());
   private final vmc kni = this.add(new vmc(a.c(397464573, "ퟚ깻⒯뫘ㅾ랱ඝ"), 0.6, 0.0, 0.9, 0.05).percent());
   private final vmc knj = this.add(new vmc(a.d("䊗㬊놠⿒ꑷ⋋飣ᅬ轄", 1686978973, 893191959), 3.0, 2.0, 3.0, 0.05).suffix(a.b("㠁", -379307923)));
   private final vmc knk = this.add(new vmc(a.b("馅\ue010櫆\uf0a4筽吏䏴쨏启\udee2奃Ꜣⶖ두㸇뢆ʹ", -1993892472), 3.0, 1.5, 40.0, 0.5).suffix(a.c(-187357720, "▄")));
   private final vmc knl = this.add(new vmc(a.b("焾ࢣ艺ᱰ鏈ᕷꬶ⊾볫㘥놊䮉셎岜횸偍\uea72旓", 435713328), 40.0, 2.0, 60.0, 0.5).suffix(a.b("㥘", -2037892812)));
   private final vkl knm = this.add(new vkl(a.c(1402713290, "냕줾䎕\udd9e噀"), true));
   private final vkl knn = this.add(new vkl(a.d("\udee0Ꝃⶓ돭㰥뺉ӗ褶፸馻Ḑ\ue46a檿\uf37f", -642277140, 1133476387), true));
   private final vkl kno = this.add(new vkl(a.d("\ue0c8饞ᏸ跴ٝ胭㪰뜭ⴓꟘ\u200e\uda03", -791007058, -576596872), true));
   private final vkl knp = this.add(new vkl(a.c(-1069338552, "㑊䶩윂奸튭吞\uea5d枳吝猣\uf48a\u0ef5萷ᦑ鏅ᕄ꼄₮먙"), true));
   private final vkl knq = this.add(new vkl(a.b("\uee60鞃ᴨ荒ࢇ踴ぷ붔⟙ꥷ⺫퓞娈쎱䧧켖", -1743328671), false));
   private final vkl knr = this.add(new vkl(a.d("迤\uf67e糞\ue2d1椂\uefb1", -1494324824, 1028776530), true));
   private final vkl kns = this.add(new vkl(a.b("ퟅ깖⒊몁", 1696256989), false));
   private final lnb knt = new lnb();
   private final lpy knu = new lpy();
   private final lng knv = new lng();
   private final wdt knw = new wdt();
   private final Random knx = new Random();
   private lpp kny;
   private LivingEntity knz;
   private int koa = 10;
   private int kob = -1;
   private int koc = -1;
   private int kod;
   private String koe = a.c(-21950159, "ᄝ");
   private static final int kof = 0;
   private static final int kog = 1;
   private static final int koh = 2;
   private static ItemStack koi;
   private final vyn koj = new vyn();
   private boolean kok;
   private boolean kol;
   private int kom = -1;
   private int kon = -1;
   private int koo = 0;
   private boolean kop;
   private boolean koq;
   private int kor;
   private long kos;
   private boolean kot;
   private final vyn kou = new vyn();
   private boolean kov;
   private boolean kow;
   private int kox = -1;
   private int koy = -1;
   private int koz;

   public kmy() {
      super(a.d("Ｗ蚲ౠ鈊᧿齢┳계", 1216519042, -1916115716), a.d("鎾\uea23惲ﺅ甗\uf3f5䦸쁅师풢匹ꤜ⟖빣㐸니ࣃ蝆ᷮ鯰\u125e栙\ue6b0給וֹ燜졨䘴\udcc3", -1802970944, -1741993170), kfa.COMBAT);
      kng = this;
      this.kno.visibleWhen(this.knn::get);
      this.knq.visibleWhen(this.knn::get);
   }

   public static boolean busy() {
      return kng != null && kng.isEnabled() && (kng.kny != null || !kng.knv.idle());
   }

   public static boolean takesWindMace() {
      return kng != null && kng.isEnabled() && kng.knp.get();
   }

   public static int strikes() {
      return kng == null ? 0 : kng.kod;
   }

   public static String debug() {
      if (kng == null) {
         return a.d("厜⨤ꃷ", -1192130798, -1300310814);
      } else {
         lpp var0 = kng.kny;
         ClientPlayerEntity var1 = MinecraftClient.method_1551().field_1724;
         String var2 = var1 == null ? "" : String.format(Locale.ROOT, a.c(-2091713341, "ﳬ蔋࿇醺᩿鲄⛏꼵ㅵ뮓㰉왲䢮턀嬄"), kng.knv.serverYaw(var1), kng.knv.serverPitch(var1));
         return (
               var0 == null
                  ? a.b("싿뭒ㆌ꿲⑶ꊔᣆ鄶ར", -283721082)
                  : a.c(430627158, "\ud923ꂎ⩐됮㾪")
                     + var0.tick()
                     + (var0.crit() ? a.d("峙", 2031811795, 496279656) : "")
                     + a.c(112238335, "黗\ue732淴\uf396硔ﻧ䒥총")
                     + var0.target().method_5628()
                     + String.format(Locale.ROOT, a.b("蓬ﴜ矇\ue9b2戵\ue49c廄휪䤢쏚䐃빹ケ\ua957", -79985470), var0.yaw(), var0.pitch())
            )
            + var2
            + a.d("ꂔ\ud968县췔䘃샼", 1830141145, 741743723)
            + kng.koe
            + a.b("큙ꦧ⍽봌㛎끩ਫ莓", 599969905)
            + String.format(Locale.ROOT, a.c(-1347338979, "㴼䒆칊偬"), kng.knv.offset())
            + a.d("ᝍ溺\ue46e稒\uf1c5眥", -121085666, 225408629)
            + String.format(Locale.ROOT, a.c(128587733, "៴湎\ue481窤"), kng.knt.get())
            + a.d("辖\uf674粠\ue2d7椛\uefa8嗵\udc12䈃", -1738929872, 1088915087)
            + kng.kod;
      }
   }

   @Override
   protected void onEnable() {
      this.knt.reset();
      this.kny = null;
      this.knu.forget();
      this.knv.reset();
      this.koa = 10;
      this.kob = -1;
      this.koc = -1;
      this.kol = false;
      this.kom = -1;
      this.koo = 0;
      this.kok = this.mc.field_1724 != null && kpg(this.mc.field_1724);
      this.kot = false;
      this.kox = -1;
      this.kow = false;
   }

   @Override
   protected void onDisable() {
      this.knv.end(this.mc.field_1724);
      this.knv.reset();
      this.knw.release(this.mc);
      this.kny = null;
      this.knu.forget();
      this.kob = -1;
      if (this.kop) {
         this.koj.release(this.mc);
         this.kop = false;
      }

      this.kol = false;
      this.kom = -1;
      this.koo = 0;
      if (this.mc.field_1724 != null) {
         this.kpe(this.mc, this.mc.field_1724, true);
      }

      this.kow = false;
      if (this.kov) {
         this.kou.release(this.mc);
         this.kov = false;
      }
   }

   @Override
   public void onStartTick(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.field_1724;
      if (this.koo != 0 && !this.kop) {
         this.koj.hold(var1);
         this.kop = true;
      }

      if (this.kow && !this.kov && !this.kop && var2 != null) {
         this.kou.hold(var1);
         this.kov = true;
         this.koz = 0;
      }

      this.knv.mode(true, var2);
      this.knv.begin(var2);
      if (this.koa < 10) {
         this.koa++;
      }

      lpp var3 = this.kny;
      if (var3 == null || var3.tick() > 1) {
         this.kpo(var2);
      }

      if (var3 != null && this.kpq(var1, var2)) {
         if (var3.crit() && var3.tick() <= 1) {
            this.knw.hold(var1);
         } else {
            this.knw.release(var1);
         }

         if (var3.tick() == 0) {
            this.kpl(var1, var2, var3);
         }
      } else {
         this.knw.release(var1);
      }
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.field_1724;
      this.kpc(var1, var2);
      this.kpd(var1, var2);
   }

   private void kpc(MinecraftClient var1, ClientPlayerEntity var2) {
      this.kph(var1, var2);
      this.knv.end(var2);
      this.knv.newTick(var2);
      this.knt.update(var2);
      if (var2.method_24828()) {
         this.kot = false;
      }

      this.knv.use(tck.profile1(), this.knh.get());
      if (!this.kpq(var1, var2)) {
         this.kny = null;
         this.knu.forget();
         if (!var2.method_5805()) {
            this.knv.forget();
         } else {
            this.kpn(var1, var2);
         }
      } else {
         double var3 = this.kpt(var2);
         lpc var5 = new lpc(
            var3,
            this.knm.get(),
            wdt.serverSprinting(var2),
            true,
            this.kni.get(),
            this.knv.serverYaw(var2),
            this.knv.serverPitch(var2),
            this.knv.maxTurn(),
            this.knk.get(),
            Math.max(this.knl.get(), this.knk.get() + 0.5)
         );
         this.kny = this.knu.plan(var2, var1.field_1687, this.knt.get(), this.kpu(var1, var2, var3), this::kpp, var5);
         this.kpi(var2);
         if (this.kny == null) {
            this.kpn(var1, var2);
         } else {
            Box var6 = this.kny.tick() <= 3 ? this.kny.box() : this.kny.target().method_5829();
            if (!this.knv.approach(var1, var2, this.kny, var6)) {
               this.kpn(var1, var2);
            }
         }
      }
   }

   private void kpd(MinecraftClient var1, ClientPlayerEntity var2) {
      if (var2 != null) {
         if (this.kov) {
            this.koz++;
         }

         if (this.kox >= 0 && (this.kny == null || this.kny.tick() > 1 || this.koz > 8 || !var2.method_5805())) {
            this.kpe(var1, var2, false);
         }

         boolean var3 = this.kox < 0
            && this.knn.get()
            && this.kny != null
            && this.kny.tick() <= 2
            && var2.method_5805()
            && this.kpr(var2) < 0
            && kpf(var2) >= 0
            && this.koo == 0;
         this.kow = var3;
         if (this.kov && this.kox < 0 && (!var3 || this.koz > 8)) {
            this.kou.release(var1);
            this.kov = false;
         }
      }
   }

   private void kpe(MinecraftClient var1, ClientPlayerEntity var2, boolean var3) {
      if (this.kox >= 0) {
         PlayerInventory var4 = var2.method_31548();
         if (var2.method_5805() && kps(var4.method_5438(this.koy)) && wdq.canClick(var2) && var1.field_1755 == null && (var3 || vyn.serverIdle(var2))) {
            wdq.swap(var1, this.kox, this.koy);
         }

         this.kox = -1;
         this.koy = -1;
      }
   }

   private static int kpf(ClientPlayerEntity var0) {
      PlayerInventory var1 = var0.method_31548();

      for (int var2 = 9; var2 < 36; var2++) {
         if (kps(var1.method_5438(var2))) {
            return var2;
         }
      }

      return -1;
   }

   private static boolean kpg(ClientPlayerEntity var0) {
      if (koi == null) {
         koi = new ItemStack(Items.field_49098);
      }

      return var0.method_7357().method_7904(koi);
   }

   private void kph(MinecraftClient var1, ClientPlayerEntity var2) {
      if (this.kop) {
         if (var2.method_5805() && wdq.canClick(var2) && vyn.serverIdle(var2) && var1.field_1755 == null) {
            PlayerInventory var3 = var2.method_31548();
            if (this.koo == 1 && kps(var3.method_5438(this.kom))) {
               wdq.swap(var1, this.kom, this.kon);
            } else if (this.koo == 2 && kps(var3.method_5438(this.kon))) {
               wdq.swap(var1, this.kom, this.kon);
               this.kom = -1;
            } else {
               this.kom = -1;
            }
         } else if (this.koo == 1) {
            this.kom = -1;
         }

         this.koj.release(var1);
         this.kop = false;
         this.koo = 0;
      }

      boolean var8 = kpg(var2);
      if (var8 && !this.kok && this.knp.get() && var2.method_5805()) {
         this.kos = System.currentTimeMillis();
         this.koq = !var2.method_24828();
         this.kor = 0;
         if (this.kom < 0) {
            this.kol = true;
         }
      }

      this.kok = var8;
      if ((this.knp.get() || this.knq.get()) && var2.method_5805()) {
         if (this.kol && this.koo == 0 && !oxw.busy() && !kvz.busy() && var1.field_1755 == null && wdq.canClick(var2)) {
            this.kol = false;
            this.kpj(var2);
         } else if (this.kom >= 0 && this.koo == 0) {
            if (!var2.method_24828()) {
               this.koq = true;
               this.kor = 0;
            } else {
               this.kor++;
            }

            long var4 = System.currentTimeMillis() - this.kos;
            boolean var6 = this.koq && this.kor >= 2;
            boolean var7 = !this.koq && var4 > 1500L;
            if ((var6 || var7 || var4 > 8000L) && var2.method_24828() && this.kny == null) {
               this.kpk(var2);
            }
         }
      } else {
         this.kol = false;
         if (!var2.method_5805()) {
            this.kom = -1;
         }
      }
   }

   private void kpi(ClientPlayerEntity var1) {
      if (this.knq.get()
         && this.knn.get()
         && !this.kot
         && !var1.method_24828()
         && this.kom < 0
         && !this.kol
         && this.koo == 0
         && !(var1.method_18798().field_1351 >= 0.0)
         && !(this.knt.get() < this.knk.get())) {
         this.kot = true;
         if (!kps(var1.method_6047())) {
            this.kos = System.currentTimeMillis();
            this.koq = true;
            this.kor = 0;
            if (this.kpr(var1) < 0 && !wdq.canClick(var1)) {
               this.kol = true;
            } else {
               this.kpj(var1);
            }
         }
      }
   }

   private void kpj(ClientPlayerEntity var1) {
      PlayerInventory var2 = var1.method_31548();
      int var3 = var2.method_67532();
      if (!kps(var2.method_5438(var3))) {
         for (int var4 = 0; var4 < 36; var4++) {
            if (kps(var2.method_5438(var4))) {
               if (var4 < 9) {
                  this.kom = var4;
                  this.kon = var3;
                  var2.method_61496(var4);
               } else {
                  this.kom = var4;
                  this.kon = var3;
                  this.koo = 1;
               }

               return;
            }
         }
      }
   }

   private void kpk(ClientPlayerEntity var1) {
      PlayerInventory var2 = var1.method_31548();
      if (this.kom < 9) {
         if (var2.method_67532() == this.kom && this.kon >= 0) {
            var2.method_61496(this.kon);
         }

         this.kom = -1;
      } else {
         if (kps(var2.method_5438(this.kon)) && wdq.canClick(var1)) {
            this.koo = 2;
         } else {
            this.kom = -1;
         }
      }
   }

   private void kpl(MinecraftClient var1, ClientPlayerEntity var2, lpp var3) {
      PlayerInventory var4 = var2.method_31548();
      int var5 = this.kpr(var2);
      if (var5 < 0) {
         int var6 = this.knn.get() ? kpf(var2) : -1;
         if (var6 < 0 || !this.kov || !wdq.canClick(var2) || !vyn.serverIdle(var2)) {
            this.koe = a.c(1514223336, "㚟伪엯宏");
            return;
         }

         int var7 = var4.method_67532();
         wdq.swap(var1, var6, var7);
         this.kox = var6;
         this.koy = var7;
         var5 = var7;
      }

      int var9 = var4.method_67532();
      if (var5 != var9) {
         var4.method_61496(var5);
         this.koc = var5;
         if (this.kno.get() && this.kob < 0) {
            this.kob = var9;
         }
      }

      var1.field_1773.method_3190(1.0F);
      if (!kpm(var1, var3)) {
         Vec3d var10 = this.knu.aimNow(var1.field_1687, var2, var3.target(), this.kpt(var2));
         if (var10 == null) {
            var10 = var3.aim();
         }

         Vec3d var8 = var2.method_33571();
         this.knv.snap(var1, var2, lme.yaw(var8, var10), lme.pitch(var8, var10));
         var1.field_1773.method_3190(1.0F);
      }

      this.koe = !kpm(var1, var3)
         ? a.b("悑ᤨ鏿", -2145361677)
         : (
            !kpw(var1, var2)
               ? a.c(-825155715, "Ἐ暢\uec78爚律罫")
               : (!(this.knt.get() <= this.knu.path().threshold()) && !var2.method_24828() ? a.d("㲩", -1090070510, -339811177) : a.c(-1580107221, "穉Ͽ褡ᝐ"))
         );
      if (a.d("紵", 671782830, 1383918263).equals(this.koe)) {
         KeyBinding.method_1420(KeyBindingHelper.getBoundKeyOf(var1.field_1690.field_1886));
         this.knv.hit(1 + this.knx.nextInt(3));
         this.knt.landed();
         this.knz = var3.target();
         this.koa = 0;
         this.kod++;
         this.kny = null;
         this.knu.hit();
         this.knw.release(var1);
      }
   }

   private static boolean kpm(MinecraftClient var0, lpp var1) {
      return var0.field_1765 instanceof EntityHitResult var2 && var2.method_17782() == var1.target();
   }

   private void kpn(MinecraftClient var1, ClientPlayerEntity var2) {
      this.knv.home(var1, var2);
   }

   private void kpo(ClientPlayerEntity var1) {
      if (this.kob >= 0) {
         PlayerInventory var2 = var1.method_31548();
         if (var2.method_67532() == this.koc) {
            var2.method_61496(this.kob);
         }

         this.kob = -1;
         this.koc = -1;
      }
   }

   private int kpp(LivingEntity var1) {
      int var2 = var1 == this.knz ? 10 - this.koa - 1 : 0;
      return Math.max(var1.field_6235, var2);
   }

   private boolean kpq(MinecraftClient var1, ClientPlayerEntity var2) {
      return var1.field_1755 == null
         && var2.method_5805()
         && !var2.method_7325()
         && !var2.method_6115()
         && !var2.method_3144()
         && !ovh.active()
         && !oxw.busy()
         && !kvz.busy()
         && !nuo.busy()
         && (var1.field_1761 == null || !var1.field_1761.method_2923())
         && (this.kpr(var2) >= 0 || this.kox >= 0 || this.knn.get() && kpf(var2) >= 0)
         && lmn.environment(var2, var1.field_1687);
   }

   private int kpr(ClientPlayerEntity var1) {
      PlayerInventory var2 = var1.method_31548();
      if (kps(var1.method_6047())) {
         return var2.method_67532();
      } else if (!this.knn.get()) {
         return -1;
      } else {
         for (int var3 = 0; var3 < PlayerInventory.method_7368(); var3++) {
            if (kps(var2.method_5438(var3))) {
               return var3;
            }
         }

         return -1;
      }
   }

   private static boolean kps(ItemStack var0) {
      return var0.method_31574(Items.field_49814) || var0.method_7909() instanceof MaceItem;
   }

   private double kpt(ClientPlayerEntity var1) {
      int var2 = this.kpr(var1);
      if (var2 < 0 && this.knn.get()) {
         var2 = kpf(var1);
      }

      ItemStack var3 = var2 >= 0 ? var1.method_31548().method_5438(var2) : var1.method_6047();
      AttackRangeComponent var4 = (AttackRangeComponent)var3.method_58694(DataComponentTypes.field_64680);
      double var5 = var4 != null ? var4.method_76739(var1) : var1.method_55755();
      return Math.min(this.knj.get(), var5) - 0.05;
   }

   private List<LivingEntity> kpu(MinecraftClient var1, ClientPlayerEntity var2, double var3) {
      double var5 = Math.max(4.0, Math.abs(Math.min(0.0, var2.method_18798().field_1351)) * 16.0 + 8.0);
      Box var7 = var2.method_5829().method_1012(0.0, -var5, 0.0).method_1014(var3 + 2.5);
      ArrayList var8 = new ArrayList();

      for (Entity var10 : var1.field_1687.method_8333(var2, var7, var2x -> this.kpv(var2, var2x))) {
         var8.add((LivingEntity)var10);
      }

      return var8;
   }

   private boolean kpv(ClientPlayerEntity var1, Entity var2) {
      if (!(var2 != var1 && var2 instanceof LivingEntity var3) || !var3.method_5805() || !var2.method_5732()) {
         return false;
      } else {
         return var2 instanceof PlayerEntity var4 ? this.knr.get() && !var4.method_7325() && !hhf.protects(var4) : this.kns.get() && var2 instanceof MobEntity;
      }
   }

   private static boolean kpw(MinecraftClient var0, ClientPlayerEntity var1) {
      if (vxr.getInt(knf, var0, 0) > 0) {
         return false;
      } else {
         ItemStack var2 = var1.method_6047();
         if (var1.method_75202(var2, 0)) {
            return false;
         } else {
            AttackRangeComponent var3 = (AttackRangeComponent)var2.method_58694(DataComponentTypes.field_64680);
            return var3 == null || var3.method_76736(var1, var0.field_1765.method_17784());
         }
      }
   }
}
