package a;

import flow.Flow;
import flow.dev.a;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public final class ign extends ijy {
   static final float igo = 510.0F;
   static final float igp = 360.0F;
   static final float igq = 12.0F;
   static final float igr = 30.0F;
   static final float igs = 16.0F;
   static final float igt = 146.0F;
   static final float igu = 30.0F;
   static final float igv = 16.0F;
   static final float igw = 10.0F;
   final iah igx = new iah(a.d("㶂䐘컙僿\udb78巋\ue785湽\uf02d窙﵃", -1238865262, -1338288299), vhz.PLUS, 24, iah.ANY);
   final float igy;
   final float igz;
   final vcj iha = new vcj(16.0F);
   final vcj ihb = new vcj(18.0F);
   final List<ige> ihc = new ArrayList<>();
   List<tiq> ihd = new ArrayList<>();
   tiq ihe;
   float ihf;
   boolean ihg;
   float ihh;
   float ihi;
   float ihj;
   float ihk;
   String ihl;
   long ihm;
   boolean ihn;
   String iho;
   tiq ihp;
   long ihq;
   long ihr;
   tct ihs;
   hlc iht;

   ign(float var1, float var2) {
      this.igy = (var1 - 510.0F) * 0.5F;
      this.igz = (var2 - 360.0F) * 0.5F;
      this.igx.onSubmit = this::iia;
      this.ihy();
      tiq var3 = lfa.activeProfile();
      this.ihe = var3 != null ? this.ihz(var3.name) : (this.ihd.isEmpty() ? null : this.ihd.get(this.ihd.size() - 1));
      this.ihs = tcz.job();
      if (this.ihe != null) {
         this.ihe.prefetch();
      }
   }

   public static void open() {
      if (MinecraftClient.getInstance().currentScreen instanceof hlc var0) {
         var0.openOverlay(new ign(540.0F, 409.0F));
      }
   }

   public static void openMine() {
      if (MinecraftClient.getInstance().currentScreen instanceof hlc var0) {
         ign var2 = new ign(540.0F, 409.0F);
         var2.ihx();
         var0.openOverlay(var2);
      }
   }

   public static void openWalk(String var0) {
      if (MinecraftClient.getInstance().currentScreen instanceof hlc var1) {
         ign var3 = new ign(540.0F, 409.0F);
         var3.ihw(var0);
         var1.openOverlay(var3);
      }
   }

   void ihw(String var1) {
      tiq var2 = lfa.walkProfile();
      if (var2 == null) {
         for (tiq var4 : this.ihd) {
            if (var4.walk()) {
               var2 = var4;
            }
         }
      }

      for (int var6 = 1; var2 == null && var6 <= 9; var6++) {
         try {
            var2 = tiq.create(wap.s(a.c(1734040499, "寣≤ꢺ㛌봙㮯臵"), a.c(-1066654891, "❶廜퐅䨌솦䜖")) + (var6 == 1 ? "" : a.b("\ued54", 740879733) + var6));
            var2.set(a.b("☒徦핲䬁색䙤ﰡ", 1480402533), a.c(1099822469, "\uf5d6豑ڏ飹"));
            var2.save();
         } catch (IOException var5) {
         }
      }

      if (var2 != null && var1 != null) {
         var2.set(a.b("Ẻ朝\uedc3玵\uf827经쒂䵮팭", 1780096708), var1);
         var2.save();
      }

      this.ihy();
      if (var2 != null) {
         this.ihe = this.ihz(var2.name);
         if (this.ihe != null) {
            this.ihe.prefetch();
         }
      }
   }

   void ihx() {
      tiq var1 = lfa.mineProfile();
      if (var1 == null) {
         for (tiq var3 : this.ihd) {
            if (var3.mine()) {
               var1 = var3;
            }
         }
      }

      for (int var5 = 1; var1 == null && var5 <= 9; var5++) {
         try {
            var1 = tiq.create(wap.s(a.c(-342309608, "앑별㘐ꡪ"), a.c(1468783058, "\uddffꑖ⻰낆㬣")) + (var5 == 1 ? "" : a.c(-974853394, "\ueacf") + var5));
            var1.set(a.c(164164299, "\uf2bc謈ǜ龯ᑧ鋊⢏"), a.c(444192252, "햵갠⛴뢎"));
            var1.save();
         } catch (IOException var4) {
         }
      }

      this.ihy();
      if (var1 != null) {
         this.ihe = this.ihz(var1.name);
         if (this.ihe != null) {
            this.ihe.prefetch();
         }
      }
   }

   void ihy() {
      this.ihd = tiq.list();
      if (this.ihe != null) {
         this.ihe = this.ihz(this.ihe.name);
      }
   }

   tiq ihz(String var1) {
      for (tiq var3 : this.ihd) {
         if (var3.name.equals(var1)) {
            return var3;
         }
      }

      return null;
   }

   void iia() {
      String var1 = this.igx.text;
      if (tiq.clean(var1).isEmpty()) {
         var1 = wap.s(a.c(-1830752251, "\uf05d觎̀鵸ᚠ途⩎ꏺ"), a.c(1964932682, "穝γ褞᜕鲾ᨌꀨⶵ")) + (this.ihd.size() + 1);
      }

      try {
         tiq var2 = tiq.create(var1);
         this.igx.setText("");
         this.ihy();
         this.ihe = this.ihz(var2.name);
         if (lfa.activeProfile() == null) {
            lfa.activate(this.ihe);
         }

         this.iib(wap.s(a.c(-2061143946, "瀩\u09ba荴ᴌ雔ၠ\uaa3a⎎붒㜲냶䪃쑁巡ힳ"), a.d("㰏䗡콌兇\udaec属\ue67a毧\uf1d9笗ﳍڿ衬ᇐ", -138793607, -1921116825)), vhz.CHECK, false);
      } catch (IOException var3) {
         this.igx.error();
         this.iib(
            a.b("\u20c2奮펬䷇옗䂡", 1233199265).equals(var3.getMessage())
               ? wap.s(a.d("Ꭲ樯\ue0f5纑\uf512班즱䁌\ude1b哯퍵⤞Ꞛ㹿됹㋂袃ݙ", 478702284, -2119861976), a.b("紒ұ蹨ဝ鯁ᥥꜮ⻛냷㸩붙䞝쥉哭\udaab尮\ue662榽", 1911847202))
               : wap.s(a.c(520224493, "ﺡ蜲෮鏖ᡒ麷⒧굇㌏릺㹼쐜䪎퍶夸"), a.d("엉뱐㊖꣸⌮ꖚᾱ附ࡤ苖Ԁ．燔\uec09戻\ue4b5廳턡䮖춵䑌", -1804286611, -2082339668)),
            vhz.CLOSE,
            true
         );
      }
   }

   void iib(String var1, vhz var2, boolean var3) {
      if (this.iht != null) {
         this.iht.toast(var1, var2, var3);
      }
   }

   @Override
   iah field() {
      return this.igx;
   }

   @Override
   boolean gone() {
      return this.ihn && this.iha.get() <= 0.01F;
   }

   @Override
   boolean closing() {
      return this.ihn;
   }

   @Override
   void close() {
      this.ihn = true;
   }

   @Override
   void render(DrawContext var1, hlc var2, float var3, float var4, float var5, float var6, float var7) {
      this.iht = var2;
      this.ihj = var3;
      this.ihk = var4;
      float var8 = vcq.outCubic(this.iha.step(this.ihn ? 0.0F : 1.0F, var5));
      if (!(var8 <= 0.01F)) {
         if (this.ihn) {
            var3 = -10000.0F;
            var4 = -10000.0F;
         }

         this.iic();
         this.ihc.clear();
         this.iho = null;
         float var9 = iov.r(10.0F);
         float var10 = iov.lightness();
         uut.round(var1, 0.0F, 0.0F, var6, var7, iov.r(12.0F), ujt.withAlpha(0, Math.round(110.0F * var8)));
         uut.pushAlpha(var8);
         var1.getMatrices().pushMatrix();
         float var11 = 0.96F + 0.04F * var8;
         var1.getMatrices().translate(this.igy + 255.0F, this.igz + 180.0F + (1.0F - var8) * 6.0F);
         var1.getMatrices().scale(var11, var11);
         var1.getMatrices().translate(-(this.igy + 255.0F), -(this.igz + 180.0F));
         uut.shadow(var1, this.igy, this.igz + 4.0F, 510.0F, 360.0F, var9, 18.0F, iov.shadow);
         uut.round(var1, this.igy, this.igz, 510.0F, 360.0F, var9, ujt.withAlpha(iov.window, 252));
         uut.round(var1, this.igy, this.igz, 510.0F, 360.0F, var9, iov.card);
         ukf.sheen(var1, this.igy, this.igz, 510.0F, 50.0F, var9, 0.8F * (1.0F - 0.7F * var10));
         uut.outline(var1, this.igy, this.igz, 510.0F, 360.0F, var9, 1.0F, iov.stroke);
         ukf.rim(var1, this.igy, this.igz, 510.0F, 360.0F, var9, var10, 1.0F);
         this.iie(var1, var3, var4);
         this.iii(var1, var2, var3, var4, var5);
         if (this.ihe == null) {
            this.iik(var1);
         } else {
            float var12 = this.igy + 12.0F + 146.0F + 10.0F;
            float var13 = this.igy + 510.0F - 12.0F - var12;
            float var14 = (var13 - 10.0F) * 0.5F;
            float var15 = this.igz + 30.0F + 4.0F;
            this.iiq(var1, var3, var4, var12, var15, var14);
            this.iir(var1, var3, var4, var12 + var14 + 10.0F, var15, var14);
         }

         this.iju(var1);
         var1.getMatrices().popMatrix();
         uut.popAlpha();
      }
   }

   void iic() {
      tct var1 = tcz.job();
      if (var1 != null && var1 != this.ihs && var1.done) {
         this.ihs = var1;
         if (var1.error == null && var1.walkResult != null) {
            this.iib(
               wap.s(
                     a.b("ﳀ蕇ྙ釯ᨺ鲌⛖꽠ㅲ믁㰙왩䢷텊孋\uddad柦\ue832犜\uf494練ܲ觊ሕ鑶ậꝍ⥐뎢㗱빌䃘쫎匩할径", 1134230707),
                     a.c(1673252074, "죜녏㮖ꗦ⸿꣹ᛆ魒ն迍ࡦ\uf26a糇\ue11d潝\ue9a1厒\udc3f䚀샓䴴㟲맖☝ꁣ⪹錈ᵓ蟔ǵ蹞璕ﻐ末\ue562殰퀄帗\ud8b3䄆쬧놹")
                  )
                  + Math.round(var1.walkResult.keysAcc)
                  + a.c(136269812, "俕㙡밥⋃")
                  + wap.s(a.d("\udc3aꖊ⽞넳㫹받", -2053189472, -1936192280), a.b("ি瀏𢡄播\uef04構폤幷", -298447480))
                  + Math.round(var1.walkResult.yawSim)
                  + a.d("Ԃ", 811147162, -188278084),
               vhz.CHECK,
               false
            );
         } else if (var1.error == null && var1.mineResult != null) {
            this.iib(
               wap.s(
                     a.d("푲귧✳륉㋛됧\u0e76螌᧒鍪ᓵ\ueed6怖念珵\uf519伏쁉婭\udc6c喂\u2fd9ꅢ㪫벇㘚辬ǿ鬆ᴒ雸栿\ue26a篎", -749649914, 599495707),
                     a.b("\ua8df테宕엥丼죺盅ﭜ敻\uefbf桫鈓\u18af蔍ན觞㏭배⚁꓀ⶠ坦\uddc7䙯쁪䪴\uf379祈\ue7a5懾\uea47ႌ麠̲脃\u0bc5됖㸙벥", 98610404)
                  )
                  + Math.round(var1.mineResult.top1)
                  + a.d("ᔜ沨\ue6ec砊", -411567031, -1919555212)
                  + wap.s(a.c(-757838934, "䯇㉿뢣⛘굋"), a.d("⁉姻퍑䴪십", -778182381, 1057473823))
                  + Math.round(var1.mineResult.hand.similarity)
                  + a.d("䣝", 542328263, 1925451070),
               vhz.CHECK,
               false
            );
         } else if (var1.error == null && var1.result != null && var1.aura) {
            this.iib(
               wap.s(a.b("䮶㈳룧⚅괓⯯醾ᡄ蘚ಢ謽焞\uffde晫\uec3d櫑탇征얥䎌쨃", 542198754), a.b("鰆\ue595潌\uf13c童ﰣ䈜쿽凑\udb63岻ꊡ⡥뇙㯶뵻ܸ裫ᙈ邎᧮揇\ued0c", 909154317))
                  + ijd(var1.result.axisScore(0))
                  + a.b("ং炤\ufae0擨\uef46", 1283393959)
                  + ijd(var1.result.axisScore(1)),
               vhz.CHECK,
               false
            );
         } else if (var1.error == null && var1.result != null) {
            this.iib(
               wap.s(a.b("\uf62f込դ鬔\u10ca阷ⰶꗐ㮋넿㛱쳙䊙\udbbf冿흔洟\ue2ca硼︠矄ඎ茠\u18fc黚", -1908017541), a.b("⩍叞\ud907䝷첮䩨\uf457禵\ue7e7洪\uea85ჸ鸭Ό襈༮넀㻕ꐝ≆ꯄ톖录쒈䛩", 294334024))
                  + Math.round(var1.result.similarity)
                  + a.c(-685405161, "谳"),
               vhz.CHECK,
               false
            );
         } else if (var1.error != null) {
            this.iib(iid(var1.error, var1.aura, var1.mine, var1.walk), vhz.CLOSE, !a.d("\uefa8阛᳇芻४迒", 2060540614, 1874113803).equals(var1.error));
         }
      }
   }

   static String iid(String var0, boolean var1, boolean var2, boolean var3) {
      return switch (var0) {
         case a.d("䀜㦮덯", 1327956262, -548847265) -> var3
            ? wap.s(
               a.d("끤짮䌽\udd03嚘퀬橢\ue393緔\uf76c烺諏Н鶹\u17ff酕⬀ꒆ㸣롿\u318f䮕앲庿\ud8cd剙\ueba6旲＂祘\uf2fd౿虶ᾎ駀ጣ겵⛑ꁖ㦫돽초䝉샿婼퐞䷭\ue77a愠謁瓋踝ޱ臡ᬃ镄", 636694457, 2026282929),
               a.b("Ｐ蚭\u0c75鈁᷈齭┺곆㊙롞㾃속佀틮墼\ude36搂\uebd9煦\uf32f织җ踺ᇰ鞌ᵘꓮ⫈끌㈁뷗䍽쥎傲튎尮\ue383涙\ueb59勈\uf8b1處ࠚ辯ᕽ魲⊠", -1907885309)
            )
            : (
               var2
                  ? wap.s(
                     a.c(1239427568, "⦊倀\udad3䓭콶䧂\uf38c穽\ue43a溂\ue914ጡ鷳ї踑ࢻ닮㵲Ʂ↓ꡯ퉻岎읖䄴쮷牅ﰁ暢\ue0bf欅闐ᾍ虻|諞ᔩ뽾㦸ꁄ⨟哩\udea1夑쏗䶰"),
                     a.d("㫏䍒즊埾\ud837媒\ue0c5椹\uf766綡塚Ѳ調ᜑ鵃᮶ꇽ⸭뒑㋉뼧섓俛푶刄\udcba愘\uef33熯\uf7ed屾芉࣓锾፩駝♴간", 1641179901, -155757560)
                  )
                  : (
                     var1
                        ? wap.s(
                           a.b("엊뱀㚓ꢭ⌶ꖂῌ阽ࡺ苂Ք｡熳\ue817扑\ue4fb庮턭䮉췞䐥㹩냌⭙굧➣鹄ၙ誧ೲ蝓禅\uf39e橽\uec3c曀\ud913卥햭䰝왓뢴㊴땊⾔ꆣᠶ銈ᓉ輗Ÿ﮴爄\uf45c", -674708056),
                           a.c(-1317903127, "惝᥀鎘෬舥\u0080뫗㌫굴➳ꁮ幠킭䴋읟䆡ﯩ瑈\uee8b泂\ue150魺ᖵ蹩౹芹㭰녊⮯귬≃\udc96囜콓䤁쎹砅\uf665点\ue979")
                        )
                        : wap.s(
                           a.d("牊ீ脓Ἥ钶ሂꡌ↽뿺㕂닔䣡옳得헑卻\ue92e暭ﰉ穞\uf3a5觩\u074c鳙\u1ae7連⧄ꟙ㴧뭲ビ츅䐞\uddfc宬턍溝\ue4e4户ﮍ熖༯蕽ˑ頁", 165657065, -1441936422),
                           a.d("\uf858臅ଝ镩᪠項≒ꮮ㗱뼶㣫웥䠨햎忚\ud924捬\ueccd瘎\uf447秕Ͽ贰᛬铼ᨼꏵ⧏댫㕹뻚䑨칐垥톁孊\ue4eb溔\uec22燰ﯘ蔭༎裁ሚ", -638747049, -1258061250)
                        )
                  )
            );
         case a.d("✆庶푤䨞", -717993960, 940207988) -> wap.s(a.b("暤ἴ閨\u0b8b聋ۼ벣㕏ꬆ↺ꙮ尖틕䬷섽䟐ﶎ", 892102395), a.b("삮뤸㏤궒☼ꃹ᪦靎എ螾i晴烕\ued79朢\ue1a4", -1159281495));
         case a.b("ỹ杊\ued96珪\uf83b纃", -1336074596) -> wap.s(a.b("ᬨ抿\ue87f瘆\ufdd6筠섴䣌훔尦\udbf7↉꽓㛤벾㩏耉࿙", 154147694), a.b("\uebe4鉺ᣛ蚮ഋ讲\u31e4렘≒곽⭒텝徃옺䱡쪘烔", 1419964395));
         default -> wap.s(
            a.d("兤⣳ꈳ㱊랚ㄬ譸ʀ鲘ᙯ醻毂\ue510粨\uf6fa灏쨈䖂\udf27奶탄꫁⑮뾲㦈댕થ蓼ṅ", 2090659804, 681557745), a.b("罔ڳ谐ቨ馴Ἇꅌⲣ닳㠰뿧䗤쬻劏\ud8ab娵\ue072毊\uf104獇諭蓴ੂ醞ᏻ", -548308141)
         );
      };
   }

   void iie(DrawContext var1, float var2, float var3) {
      float var4 = this.igz + 15.0F + 1.0F;
      vjf.draw(var1, vhz.LAYERS, this.igy + 12.0F + 5.0F, var4, 10.0F, iov.accent());
      String var5 = wap.s(a.c(899444391, "滥\u177f鶼ϊ蠀\u0efe듾㴈ꍖ⧶긨呟"), a.c(-748384553, "諆\uf35f禀\ue788氡\uee83傼\ud94e䜐췖䨉뀏"));
      irr.CARD_TITLE.draw(var1, var5, this.igy + 12.0F + 16.0F, irr.CARD_TITLE.centerTop(var4), iov.text);
      boolean var6 = this.ihe != null && this.ihe.aura();
      boolean var7 = this.ihe != null && this.ihe.mine();
      boolean var8 = this.ihe != null && this.ihe.walk();
      tiq var9 = var6 ? kwf.studioProfile() : (var7 ? lfa.mineProfile() : (var8 ? lfa.walkProfile() : lfa.activeProfile()));
      boolean var10 = var6 && this.ihe != null && kwf.usesStudio(kwf.studioProfile());
      String var11;
      if (var8) {
         var11 = var9 == null
            ? wap.s(
               a.b("鎁\uea04惖ﺼ畁\uf3db䦂쀷幧퓙卫꤮⟸빒㐹닾ࢢ蝥ᷗ鮍ሮ桥\ue694絒בּ燥졎䙆\udcf5媣텞\u2fd8ꖁ㱽먩゚轊Բ", -1185115162),
               a.b("㑉䷌윞奴튉吓\uee4a柿羚猑\uf4a3\u0ee6耰ᦚ鏱ᔶ꽪₭먟㱅뗦쾭䕿\udedd墮툎濒\ue5e6罪櫓狺豖ؘ", -1268763607)
            )
            : wap.s(a.c(-64077689, "䃾㥙뎇ⷱ꘤ₒ髈\u137e赴߃耆穡\uf4ff浔"), a.b("颂\ue148殑\uf598縲\uf882䛁쬡啺\udfbe塼ꈞ⢱넚", 608476361)) + var9.name;
      } else if (var6) {
         var11 = var10 && var9 != null
            ? wap.s(a.d("令㝁붕⏷ꡡ⺅铐ᴷ荾আ蹏", 1154806936, 533510678), a.b("㛼伾엮寯퐨嚈\uecdf敛ﬕ熷\uf21cࡷ", -687197504)) + var9.name
            : wap.s(a.b("춓됶㻢ꂀ⬖귲ឧ鹀\t諱സ\uf739秌\ue060樺\uecc4嚎\ud956䎠엠", -808595994), a.d("瓕ഗ蟇ᧆ阁ᒡ껶❲뤼㎞뀵䩞삶奘퍵嗾\uefcd怟\ufadb磦\uf100", 1893285274, -719368854));
      } else if (var7) {
         var11 = var9 == null
            ? wap.s(a.d("듋쵎䞜\ud9f6刃풖滂\ue738礸\uf393琂蹤¯餛ፐ闸⿳ꀥ", 734141702, -1965315682), a.d("\ue90c邉ᩛ萱࿄襑㌅뫿⓿깔ⶕ힗奃샰䫝찧癠鈴捴\ue557", -875013439, -109988968))
            : wap.s(a.b("㵣䓦츴偞\udbab崾\ue76a源\uf08a穮ﶻߜ褝ქ骬", -1418773203), a.c(-97913195, "\uf6c4轁֓鯹ဌ隙ⳍꔷ㬭떍㉚졞䚘\udf3a儑ퟺ")) + var9.name;
      } else {
         var11 = var9 == null
            ? wap.s(a.c(1965248429, "俒㙢볾⋎ꤛ⾽闳ᰝ艑ࢥ輦畕ﮟ戧\ue87b溏퓉"), a.d("㚚伣얇徔큓囨\uecc3效יִ熣\uf673ఏ苕ὺ鄶ី궉∢룭㺿뜼", -1875522976, 1270675666))
            : wap.s(a.c(-1934162682, "խ糔\uf603栿\ue3bd攊\udf4f嚨좾䈕"), a.b("\uedd1鑨ế蓒ଔ趡㞇빧\u202b껢⤫", -232134166)) + var9.name;
      }

      boolean var12 = var6 ? var10 : var9 != null;
      float var13 = this.igy + 12.0F + 16.0F + irr.CARD_TITLE.width(var5) + 8.0F + Math.max(16.0F, irr.SMALL.width(var11) + 9.0F);
      irr.drawChip(var1, var11, var13, var4, var12 ? iov.accent() : iov.textMuted, iov.stroke, 0.0F);
      kfe var14 = var6 ? Flow.getInstance().getModuleManager().getByName(a.c(1469056758, "ڵ缦\uf5f0殁\ue07b曾\udcaa啈")) : lfa.get();
      if (var14 != null) {
         String var15 = var14.getDisplayName();
         String var16 = var15
            + (
               var14.isEnabled()
                  ? wap.s(a.b("ᣰ愎\uebdc", -1209132845), a.d("ﲾ脝ெ閶", 269147324, -1263001562))
                  : wap.s(a.c(-382497617, "貋\uf575羯\ue1de"), a.c(125804501, "鿰\ue253棹\uf6f9累"))
            );
         float var17 = Math.max(16.0F, irr.SMALL.width(var16) + 9.0F);
         float var18 = var13 + 6.0F;
         boolean var19 = irr.inside(var2, var3, var18, var4 - 5.5F, var17, 11.0F);
         irr.drawChip(var1, var16, var18 + var17, var4, var14.isEnabled() ? iov.accent() : iov.textMuted, iov.stroke, var19 ? 1.0F : 0.0F);
         this.ihc.add(new ige(var18, var4 - 5.5F, var17, 11.0F, var14::toggle, null));
         if (var19) {
            this.iho = var6
               ? wap.s(
                  a.d("\uf188蠖ˀ鲻ᝤ醞௹ꈼ㰷뚇ㅓ쬾䖧\udc7d嘌탸檷\ue54b翌連灾੮蒒ὂ饳Ꭽꨑ␏뻱㢠", 2141198855, -675615790),
                  a.c(-37986884, "如‒ꫂ㒱뭼᷹螞\u0a7d鐪ẚ餼捄\uedec琧ﹺ糧욧䥹ퟘ凰\ud876ꈦⳠ뜸ㄸ뮓Ȯ蠓\u128f铼Ὂ\ue19b毹\uf23c瑨ﻊ")
               )
               : (
                  var8
                     ? wap.s(
                        a.c(
                           -1329969351,
                           "䜥㺻둭⨖ꇉ✳뵔ᒑ誠:蟹綏\uf345櫉\ue0a7晍\udc17叓쥽伪웜볃㈿ꧯ\u2fdeꔀ\u1cbc銢\u085c踍ע﬩焇\ue8c2源\ue43a寇톝坄캱䒯㩑뀈㟽굋⌎髜ၶ阁෦莆祁\uf0f7皭\uec10或\ud9bf彣픗䲍쉭렢㿌떁⬆ꋮ\u18ab鹀ᐐ诳ŭ蜞绊\uf47a樠\ue19d枅\udd35哤쪀䀖옐붼㍬ꤞ\u20c6\ua630ᰨ鏊\u09cf輵۾ﳚ牄\ue9f6"
                        ),
                        a.b(
                           "Ԯ精\uf66e栝\ue7d0䅕\udb32囑좆䈶쇾㮀땘⣻ꋑ\u2451鸟ᗕ輈ॲ肕遲瑭\uef81槃\ue309媯퓫丁졖䏤뵡㜴꺤⣃ꉳᶿ韤ᄜ袧ʼ硕\uf61e燎\ueb2d敝\udc95嘜큥䮧엂㼒뚮ケ긧\u200d鮸ᴒ靬\u0adf耊飼緔\uf78e楍\ue4e5媪\udc59嘄즴䍩앯㲲뉡ⰾꎭ▆鼲ᚖ袑ɚ耕ﾹ煩\ueb1a拁\ue062席퇑依촼䓥뺓〷ꮍⷊꝩ",
                           1863975253
                        )
                     )
                     : (
                        var7
                           ? wap.s(
                              a.b(
                                 "圱⺯ꑹ㨂뇝㜧굀҅骴ီ韭涛\ue351竝\uf0b3癙찃䏇\ud969弾훈곗∫맻㿊디ನ芶ᡈ鸙ᗶ\ueb3d愓\uf8d6纄\uf42e䯛솎䝚\udee0哺⩏ꀑ➮뵭㍏請d蘶᷻鏀楈\ue0e9暢ﱖ牕즧佴씌峜퉢\ua87f⿃ꖓ㭞닺ࣰ蹖О鮮ᅸ需溚\ue462稬\uf189瞗촼䒼\uda82偌",
                                 -549497053
                              ),
                              a.c(
                                 -1038897286,
                                 "ꬶ튦塶옅䧈\uef4d甪\uf8c9暞\uec2e濦閘ᭀ蛣\u0cc9詉〇믍ℐꝪ⺍哛\uda75䆙쟛䴑\uf4b7竳\ue019晎\uedfc፹餬¼蛛౫뎧㧴뼃⚵곡퉕尜\udba9䅿켁盗ﰑ縼\ue18f澌镑᳭骰њ踗㖪덱㤃ꃜ⸜呏ퟞ嶃윮代\uf4b5爳\uf812枧\ue96a欄鋚ᡯ蘶ৗ讞ㄬ볢⚁걆⨖凐\udf08䕩쳔"
                              )
                           )
                           : wap.s(
                              a.b("跷\uf469线\ue0c4欛\uede1瞆\ude43䁈쫸䴬띁㧘ꀽ⩲겎ᚄ餔ί藺ీ癞\uf8ec捳\ue503濝혡塹슎", -758084183),
                              a.d("僿⥯ꎿ㷌눁ᒄ軣̀鵗៧遁樹\ue491絚\uf707疚쿚䀄\udea5墍턋꭛▝빅㡅닮\u0b53腮ᾉ駐ቧ", 547069426, 1963641096)
                           )
                     )
               );
         }
      }

      float var20 = 16.0F;
      float var21 = this.igy + 510.0F - 12.0F - var20;
      float var22 = this.igz + (30.0F - var20) * 0.5F + 1.0F;
      boolean var23 = irr.inside(var2, var3, var21, var22, var20, var20);
      irr.iconButton(var1, vhz.CLOSE, var21, var22, var20, var23 ? 1.0F : 0.0F, false, 1.0F);
      this.ihc.add(new ige(var21, var22, var20, var20, this::close, null));
   }

   float iif() {
      return this.igz + 30.0F + 16.0F;
   }

   float iig() {
      return this.igz + 360.0F - 16.0F - 8.0F - 26.0F - this.iif();
   }

   float iih() {
      return Math.max(0.0F, this.ihd.size() * 34.0F - 4.0F - this.iig());
   }

   void iii(DrawContext var1, hlc var2, float var3, float var4, float var5) {
      float var6 = this.igy + 12.0F;
      this.ijn(var1, wap.s(a.c(969497074, "妪‹\uaaf7㒏뽗㧣莹ਫ਼"), a.b("ຑ睿\ufdd2揙\ue872滀풐", -1234892151)), var6, this.igz + 30.0F + 4.0F);
      float var7 = this.iif();
      float var8 = this.iig();
      float var9 = this.ihb.step(Math.max(0.0F, Math.min(this.ihf, this.iih())), var5);
      tiq var10 = lfa.activeProfile();
      tct var11 = tcz.job();
      uut.pushScissor(var1, var6 - 2.0F, var7 - 2.0F, 150.0F, var8 + 4.0F);
      float var12 = iov.r(6.0F);

      for (int var13 = 0; var13 < this.ihd.size(); var13++) {
         tiq var14 = this.ihd.get(var13);
         boolean var15 = var14.aura();
         float var16 = var7 + var13 * 34.0F - var9;
         if (!(var16 + 30.0F < var7 - 2.0F) && !(var16 > var7 + var8 + 2.0F)) {
            boolean var17 = irr.inside(var3, var4, var6, var16, 146.0F, 30.0F) && irr.inside(var3, var4, var6, var7, 146.0F, var8);
            boolean var18 = var14 == this.ihe;
            int var19 = var18 ? ujt.lerp(iov.field, iov.accent(), 0.18F) : iov.field;
            uut.round(var1, var6, var16, 146.0F, 30.0F, var12, var17 ? ujt.lerp(var19, iov.fieldHover, 0.6F) : var19);
            if (var18) {
               uut.outline(var1, var6, var16, 146.0F, 30.0F, var12, 1.1F, iov.accent(200));
            }

            float var20 = var6 + 8.0F;
            if (var15 ? kwf.usesStudio(var14) : (var14.mine() ? lfa.mineProfile() == var14 : (var14.walk() ? lfa.walkProfile() == var14 : var10 == var14))) {
               uut.circle(var1, var6 + 7.0F, var16 + 15.0F, 2.5F, iov.accent());
               var20 = var6 + 14.0F;
            }

            irr.NAME.draw(var1, irr.NAME.ellipsize(var14.name, 146.0F - (var20 - var6) - 22.0F), var20, irr.NAME.centerTop(var16 + 10.0F), iov.text);
            boolean var22 = var11 != null && !var11.done && var11.profile == var14;
            String var21;
            if (var22) {
               var21 = wap.s(a.d("줸낏㩏ꐶ\u2fe6ꥐጄ髼Ӥ", 1218271590, 333680675), a.b("轼\uf6c2籣\ue216榳\uef0a啜\udca0䛪", -672691381))
                  + (var11.progress.epoch + 1)
                  + a.b("畋", 340424037)
                  + var11.progress.epochs;
            } else if (tcz.mode() == tcw.RECORD && tcz.sessionProfile() == var14) {
               var21 = wap.s(a.c(-604133362, "꡶퇐嬅앸亲정牋﮽旫켛"), a.b("啈\u2cf5ꙃ㠡랔㔲车ژ飀ለ闖䯍", 1521504636));
            } else if (var14.walk()) {
               txs var23 = var14.walkModel();
               var21 = ijv(var14.getLong(a.b("搸ᶟ靁ष芥ю븀㟻ꦬ⌅", -2075171771), 0L) / 20L)
                  + a.d("글ힱ巵쌓䣄", 581625681, -1350547084)
                  + (
                     var23 == null
                        ? wap.s(a.b("飩\ue14e殐\uf5e6繺\uf885䋗쬧啳", -1563912041), a.d("卌⪆ꁟ㹖뗼㍌贏ã麴ᑲ", 1774888596, -173084265))
                        : wap.s(a.d("ꆾ\ud819勇첱䜭", -611569873, -1474392349), a.d("罕ڟ豆\u124f駥ὕꄖ", 1007447672, 1772164463))
                           + Math.round(var23.keysAcc)
                           + a.b("샯", 1345765579)
                  );
            } else if (var14.mine()) {
               ttb var32 = var14.mineModel();
               var21 = var14.getLong(a.d("\uf538貍ٙ頣Ꮏ镂⼟ꛭ㢾눇㗌", -193767527, -1738431801), 0L)
                  + wap.s(a.d("ᥨ悛\uea46琴\uffef祖쌝", -1653700464, 652382687), a.b("콾닞㠇ꉣ", -1973694630))
                  + a.b("ṧ柖\ued92獴\uf8a3", -314106302)
                  + (
                     var32 == null
                        ? wap.s(a.c(1665505669, "駡\ue054檀\uf4fa罨聯䏅쨵呡"), a.d("\uec63閪Ἄ腺\u0adf衾㘰뿉⇡", -1854572402, -1733390164))
                        : wap.s(a.d("遒\ue9e7挳﵉盛", 2020620565, -1138906833), a.d("⼥囬\udc4a䈼즙䬸", 1382442395, -514109712))
                           + Math.round(var32.top1)
                           + a.d("\uda1f", -1416232799, 1890572954)
                  );
            } else {
               tck var33 = var14.model(var15);
               String var24 = var15
                  ? wap.s(a.c(-788243818, "嫲⍗ꦃ㟡뱷"), a.d("\ue9fd逿\u1aef蓮\u0b29", -1789341751, -1941364223))
                  : wap.s(a.d("嚃⼰ꗨ㮘끆㚻", -2083212475, -107682387), a.d("ꍰ\udac3倚칪䖳썵絊", -1109710946, -1155301163));
               var21 = var14.getLong(a.d("ຬ眜\ufdd2掤", -1527014033, -1917480017), 0L)
                  + wap.s(a.b("ꄫ\ud8d2刀챬䞼", -691363570), a.b("峿ℭꮉ㇢", -1726587685))
                  + a.d("勗⭦ꄢ㿄됓", 1911368126, 693205836)
                  + (
                     var33 == null
                        ? var24 + wap.s(a.b("ᾅ昵\uece7犝", -1916788753), a.c(1127715917, "遳\ue9ca据"))
                        : var24 + Math.round(var33.similarity) + a.b("\ue4cf", 491578603)
                  );
            }

            irr.SMALL
               .draw(
                  var1,
                  irr.SMALL.ellipsize(var21, 146.0F - (var20 - var6) - 8.0F),
                  var20,
                  irr.SMALL.centerTop(var16 + 20.5F),
                  var22 ? iov.accent() : iov.textMuted
               );
            tiq var34 = var14;
            if (var17 || this.ihp == var14) {
               float var35 = 14.0F;
               float var25 = var6 + 146.0F - var35 - 5.0F;
               float var26 = var16 + (30.0F - var35) * 0.5F;
               boolean var27 = this.ihp == var14 && System.currentTimeMillis() - this.ihq < 3000L;
               boolean var28 = irr.inside(var3, var4, var25, var26, var35, var35);
               irr.iconButton(var1, vhz.TRASH, var25, var26, var35, var28 ? 1.0F : 0.0F, var27, 1.0F);
               this.ihc.add(new ige(var25, var26, var35, var35, () -> this.iij(var34), null));
               if (var28) {
                  this.iho = var27
                     ? wap.s(
                        a.b("珫ੵ肣Ộ锇ᏽꧯ‘빁㓸댬䤓자帺퐦劓\ue8dd朅ﶿ篿\uf219蠍۷鴻ᬐ醖⠻ꙷ㲜명ㅷ쾫䗤\udc59婘탾漯\ue552掜層灩ຟ蓅͠", -65506428),
                        a.b("峪┇꿌㗌먁㲱蛡༒镗㿒頵昧\ue887焲ﭪ綘잭䡲횭哮\udd17ꝏ⦈뉚㑒몖݄赴᎔闂Ṿ\ue0a8檞\uf361畁\ufff4", 1195661531)
                     )
                     : wap.s(a.b("诀\uf250碊\ue6f2洴\ueb94冂\ud827䙤쳘䭎녯㾺ꘖⱌꪲჸ鼠", 692882326), a.b("淦ᑀ麗í謹ෲ랯㨲ꁲ⪼광圚\ud9b1䀃쨧", -1218483766));
               }
            }

            this.ihc.add(new ige(var6, var16, 146.0F, 30.0F, () -> this.iiw(var34), () -> {
               this.iiw(var34);
               if (var34.aura()) {
                  kwf.useStudio(var34);
               } else if (var34.walk()) {
                  lfa.useForWalk(var34);
               } else if (var34.mine()) {
                  lfa.useForMine(var34);
               } else {
                  lfa.activate(var34);
               }
            }));
            if (var17 && this.iho == null) {
               this.iho = var15
                  ? wap.s(
                     a.b("紙҇蹑ဪ鯵ᴏ蝨⺭낽㨓뷕䞯줶傇\uda43尥\ue66a槩\uf341甞ﳦ蚫ࡌ鏞ᖮ齺⛃ꢚ㈦鑃㿄셾䬓틧咴\ude28懋\uebbd浽\uf48d纇p訵ඒ霖\u192eꃠ", 264338805),
                     a.b("Պ糚\uf60a桹\ue7b4䄱\udb56嚹좚䉓엺㾀녞⣡ꛞ 髷ᖱ輂൬蒞ﻉ瑆쾣槨\ue352嫃풗习제䎛뵍㜑꺡ⳣꙖ᧴鎔ᕔ袇ۍ砺\uf264", 338821499)
                  )
                  : (
                     var14.mine()
                        ? wap.s(
                           a.d("㮐䈎죘嚣\udd7c宆쇡栤\uf634粚ﭜĦ辿ᘎ鳊᪬ꃣ⽠뗈㎗멯쀢仅핗匧\ud9f3恊\uee13璯틊祍蟽ආ鑶ሾ颭❞괨⯰누㠟䛣첾䬛톟徹\ue674泘\uea8b焒Ｈפ", 875168632, 254359711),
                           a.b("쇡롱㊡곒⌟薚´鈒ఱ蛸őשׂ痵\uec4a扵\ue484幜턚䮩짇䀵㩢냭ଈ굃⟳鹴ဤ諈\u0cbb蜬秺\uf3be樊\ue843拶\udd20坞톈䡎왳벚㛍", 1328793040)
                        )
                        : (
                           var14.walk()
                              ? wap.s(
                                 a.c(
                                    -1480747758,
                                    "锑\uec8f晙\uf822珽\uf507潠욥墵툛嗝꾧ℾ뢏㉋됭\u0e62臡ᭉ鴖ᓮ溣\ue044篖ﶦ睲컋䂒\uda2e籋ퟌ⥼ꌇ㫷벿㘤觘Σ蔴\u1c8a雚\ue84a戭\ue59d网\uf118䣽쉟䐆\udfd6冮ꬱ⋑꒖㹨뀾ொ赌ܡ黭၆機\uede5枩"
                                 ),
                                 a.d(
                                    "额\ue10d毝\uf5ae穣\udce6䚁쭮啍\udf84堭ꉗⲉ딶㬉뷸ܠ衦ዕ邻᥉挞\ue991剴\uf43f纏윈䥘펴嗏\ude57₌ꪇ㍹딥㿵耖੦貮ᔧ齎\ue1ac毩\uec59皅\uf8ba䔌쿆䦃툩屗ꋤ⽋ꤞ",
                                    -1108927814,
                                    1695516171
                                 )
                              )
                              : wap.s(
                                 a.d("嫆⍘ꦎ㟵밪㫐ꂷॲ面᷌騊恰\ueee9睘ﶜ篺솵丶풞勁\udb39ꅴ⾓됁㉱뢥Ĝ轅ᗹ뎜\u181b\ue69e泍\uf531猧輪䘈챽䫣팇奞➹근⨞낀㻬", -408788184, 150747523),
                                 a.b("ᑫ添\ue72b祘\uf695倐쩷䞘\ud9bb卲퓛⺡ꁿ㧀럿ㄎ诖Ґ鸣ᱍ閿\uefe8敧\ude82磉\uf608侳쇦弍\udd4d固ꡞ∀믢㧓띷ࢦ苚", 1611337815)
                              )
                        )
                  );
            }
         }
      }

      if (this.ihd.isEmpty()) {
         irr.SMALL
            .draw(
               var1,
               wap.s(a.c(1982243185, "ꄰ\ud8a0刼찝䟈셤笾\uf2c0沚\ue622懧鯅ᕋ賦ڤ"), a.b("苉ﬧ熊\uef81搪\ue298壅털䭾에䈂롷㚪ꬋ╅ꎼᦄ", -1272871225)),
               var6 + 4.0F,
               irr.SMALL.centerTop(var7 + 10.0F),
               iov.textMuted
            );
      }

      uut.popScissor(var1);
      float var29 = this.igz + 360.0F - 16.0F - 8.0F - 20.0F;
      this.igx.x = var6;
      this.igx.y = var29;
      this.igx.w = 124.0F;
      this.igx.h = 18.0F;
      this.igx.render(var1, var2, var3, var4, 0.016F);
      float var30 = var6 + 146.0F - 18.0F;
      boolean var31 = irr.inside(var3, var4, var30, var29, 18.0F, 18.0F);
      irr.primaryButton(var1, "", vhz.PLUS, var30, var29, 18.0F, 18.0F, var31 ? 1.0F : 0.0F, 0.0F);
      this.ihc.add(new ige(var30, var29, 18.0F, 18.0F, this::iia, null));
      if (var31) {
         this.iho = wap.s(a.d("몒쌒䧖힣屡\udac1惗\ue967睹ﶘ穉耥\u0efb靅ᴓ鯫", -1230215616, -1830757247), a.b("륥샋䨑푣徰\ud973挮\ueeb3瓳︽禐莛ര钂Ầ", -1923629749));
      }
   }

   void iij(tiq var1) {
      long var2 = System.currentTimeMillis();
      if (this.ihp == var1 && var2 - this.ihq <= 3000L) {
         this.ihp = null;
         if (tcz.sessionProfile() == var1) {
            tcz.stop();
         }

         if (tcz.training() && tcz.job().profile == var1) {
            tcz.cancelTraining();
         }

         if (lfa.activeProfile() == var1) {
            lfa.activate(null);
         }

         if (lfa.mineProfile() == var1) {
            lfa.activateMine(null);
         }

         if (lfa.walkProfile() == var1) {
            lfa.activateWalk(null);
         }

         if (kwf.studioProfile() == var1) {
            kwf.useStudio(null);
         }

         try {
            tiq.delete(var1);
            this.iib(wap.s(a.c(335641629, "籂ב輟ᅧ骿ᰋꙑ\u2fe5뇾㭎범䛬젪冊\udbd8"), a.b("ࡊ熤\ufb09攂\ueea9栛툿徢얞佘좏㋵뱈▕", -1448276901)), vhz.TRASH, false);
         } catch (IOException var5) {
            this.iib(
               wap.s(a.b("\uec88锛ῇ臿\u0a7b貞㚉뽹ℯꮗⱕ혵墧셟䬑", 808512708), a.d("㦟䀆컀咮\udf78姌\ue3e7樒\uf432纀稜͘趂ၟ鹯ᣩꊢ\u2d78럈㇣렚", 523230564, 2013192435)), vhz.CLOSE, true
            );
         }

         this.ihy();
         if (this.ihe == null && !this.ihd.isEmpty()) {
            this.ihe = this.ihd.get(0);
         }
      } else {
         this.ihp = var1;
         this.ihq = var2;
      }
   }

   void iik(DrawContext var1) {
      float var2 = this.igy + 12.0F + 146.0F + 10.0F;
      float var3 = this.igy + 510.0F - 12.0F - var2;
      float var4 = this.igz + 180.0F - 10.0F;
      irr.CARD_TITLE
         .drawCentered(
            var1,
            wap.s(a.d("䙨㿨딬⭙ꂛ☻鰭ᖝ讃Ţ蚳糟\uf201殿\ue1e9朑\udd1b劅젷丨잋뷆㍸꣬⻟ꐇᶷ鏴", 1062706679, -1231037504), a.b("驏\ue3e1椻\uf749粚諸䑨즆垦\udd69嫀ꃍ⸙럟㧠뭰Ņ躚ᐮ鉽", 429170298)),
            var2 + var3 * 0.5F,
            irr.CARD_TITLE.centerTop(var4),
            iov.textDim
         );
      irr.SMALL
         .drawCentered(
            var1,
            wap.s(
               a.d("춊됚㻂ꃶ⭱귂ឌ鹴$誐ൊ\uf77e禴\ue018樄\uecf4嚰\ud924䏖얏䱼㙠뢀⍖ꔤ\u2fe0陚ᡔ芹Һ輞燉ﮊ扦\ue423滚턁嬤\uddf1䑓츄냲㫣뵞⟜ꦫၮ", 1844047522, 1879843656),
               a.c(1183032676, "ꅌ\ud8a2刏찄䞯석笹\uf6a4棦\ue24a憇鯼ᔧ貓˝聍㨁떪⼚ꤼ⒧嫦푝侈짻䜠ﺉ瓏\uee3f桡\ue3d5ᵽ靃ູ賽ـ붉㟷녖⣣ꋃ\udc31創허䬀앰粦\uf660灔\uebf1旴齘᛫邷\u0a4a")
            ),
            var2 + var3 * 0.5F,
            irr.SMALL.centerTop(var4 + 14.0F),
            iov.textMuted
         );
   }

   void iil(DrawContext var1, float var2, float var3, float var4, float var5, float var6) {
      tiq var7 = this.ihe;
      float var8 = this.ijn(var1, wap.s(a.c(156140754, "蒏ﴚ矎\ue9b8扨\ue4d0廄흧䤯쎘䑇븫リ\ua956⌂ꗺ"), a.b("㷯䑹캥僓\udb7d巁\ue3fe渕\uf04e竾ﴢݞ覌၊", 164248054)), var4, var5);
      ttl var9 = tcz.mineRecorder();
      boolean var10 = var9 != null && tcz.sessionProfile() == var7;
      long var11 = var7.getLong(a.c(110343323, "듽쵈䞜\ud9e6剺풇滚\ue728祻\uf3c2琉"), 0L);
      long var13 = var7.getLong(a.b("꽙훬尸쉂䧞켥畷ﲀ拕\ue87e澷闀ᬖ芺", 1844293434), 0L);
      long var15 = var7.getLong(a.b("巪\u245f꺋ヱ뭭㶆蟈ำ遤ᫍ", -637313651), 0L);
      long var17 = var7.getLong(a.c(1628411721, "霩\uee9c摈免熮\uf755䴋쓲媡퀒埀궻⍻"), 0L);
      long var19 = var7.getLong(a.d("\udc9fꔪ\u2ffe놄㨘볡ڵ轗ᄗ鮮ᱼ", -1987851495, 1224153056), 0L);
      if (var10) {
         int[] var21 = var9.unsaved();
         var11 += var21[0];
         var13 += var21[1];
         var15 += var21[2];
         var17 += var21[3];
         var19 += var21[4];
      }

      float var42 = (var6 - 6.0F) * 0.5F;
      this.ijo(
         var1,
         wap.s(a.c(2119547992, "밴얋佛턦嫹\udc50晐\uefe2熲ﬆ糟蚦ࡿ量"), a.d("✣库푃䨰쇣䝞蘭瓱\ueaaf搀\ue7c2ᶹ鍫\u0ade肇ٺ", 510766758, -2050191953)),
         String.valueOf(var11),
         var4,
         var8,
         var42,
         false
      );
      this.ijo(
         var1,
         wap.s(a.b("ﵬ蓚บ遴᮫鴛✌꺪ル멇㶈잱䥵킏媗", -588514043), a.b("ꑩ\uddd5坲쥷䋐쐝繉\uf7b6槡\ue353悞麎ᐸ趚ܭ脸", -630611900)),
         String.valueOf(var19),
         var4 + var42 + 6.0F,
         var8,
         var42,
         true
      );
      var8 += 30.0F;
      this.ijo(var1, wap.s(a.d("龦\ue600法\uf2a8祢ￅ䖗챧", 1295928807, 2010436155), a.c(-380377515, "\ue26a鯜ᄀ轶Ә舘㡆놴")), ijv(var15 / 20L), var4, var8, var42, false);
      this.ijo(
         var1,
         wap.s(a.b("莑鶴烶\uee8b敞\ue3ee妷큑", -460880899), a.d("\ue2d6魬ᆸ迅Е芭㣲", -343853188, 458805661)),
         String.valueOf(var17),
         var4 + var42 + 6.0F,
         var8,
         var42,
         false
      );
      var8 += 32.0F;
      float var22 = 18.0F;
      float var23 = var6 - 50.0F;
      boolean var24 = irr.inside(var2, var3, var4, var8, var23, var22);
      if (var10) {
         irr.primaryButton(
            var1,
            wap.s(a.b("\ue8f4酢᮪藄", -1462835037), a.d("\ue5d1鰃ᚬ補", -1711507964, -806316048)),
            vhz.PAUSE,
            var4,
            var8,
            var23,
            var22,
            var24 ? 1.0F : 0.0F,
            0.0F
         );
         this.ihc.add(new ige(var4, var8, var23, var22, tcz::stop, null));
      } else {
         irr.primaryButton(
            var1,
            wap.s(a.c(-1941248366, "\ue6cd齋ᖞ诣)蚎㲙딥⭾ꇈ☜\udc6a労"), a.d("營ࡉ芕᳣靍ᆍꮬ≓론㛋넜䭬어專홞傢", -1528462020, 2139156708)),
            vhz.PLAY,
            var4,
            var8,
            var23,
            var22,
            var24 ? 1.0F : 0.0F,
            0.0F
         );
         this.ihc.add(new ige(var4, var8, var23, var22, () -> {
            tcz.startMining(var7);
            this.close();
            if (this.iht != null) {
               this.iht.close();
            }
         }, null));
      }

      if (var24) {
         this.iho = wap.s(
            a.b(
               "⽶団\udc37䉍짟伷\uf572粙\ue2c1桱\uefb4ᗌ鬑˦裢ญ둟㮒ꅩ❹껏퓎婤솿䟈촓璹\ufaf5恝\ue616淲錼\u197a肞ڙ豱㎰맛㽝ꚮⳡ切\ud850快앻䬆\uf28c砫ﹾ斨\ueb89ᄌ颺Ử萃\u0a4f놣㜳뵏⒔ꩧ큡垄\uddd8䌐쪣烷\uf60f簟\ue3ef椯\uef49ᛓ鰰ɴ覃࿘땴㲱ꋁ⠏",
               -2005520534
            ),
            a.c(
               -765054698,
               "㕊䳟옍塳펭儅\uef37暷\uf8e4癉\uf580\u0ff3腜ᢗ鋀ᐶꩺ▱묝㵋듌컠䀤\udbf6嶇팹滭\ue0b9稲\uf87d矕褁͌骱᳧阫⧸\ua7e9ℶ벝㛈䠳왺䗑\udf7c儎\ue8dc戗\ue428翽\uf5e2\u0b29芔Ӊ鸳ဗꮫ⤙ꝲ㪻뀖쩍䶴쏿奕킟櫆\uec3b昜囹"
            )
         );
      }

      float var25 = var4 + var23 + 6.0F;
      float var26 = var6 - var23 - 6.0F;
      boolean var27 = System.currentTimeMillis() - this.ihr < 3000L;
      boolean var28 = irr.inside(var2, var3, var25, var8, var26, var22);
      irr.secondaryButton(
         var1,
         var27 ? wap.s(a.b("ໝ睊ﶞ揸\ue875", -741077365), a.c(259230552, "轼\uf6d1类\ue270榤\ueb14")) : "",
         vhz.TRASH,
         var25,
         var8,
         var26,
         var22,
         var28 ? 1.0F : 0.0F,
         0.0F
      );
      this.ihc.add(new ige(var25, var8, var26, var22, () -> this.ije(var7), null));
      if (var28) {
         this.iho = wap.s(
            a.c(-1961075022, "廁❑궋㏳렵㺕蒃ള鍡᧐鹏摬\ueaac猛籠羨엱䨭킙囁\udf22ꔠ⯜뀄㘽벸ԗ譇ᆪ鞨\u1c4b\ue298棊\uf132睮\ufdda䈄젰仫휆嵅⎹ꦯ⹓뒆㫼茮খ辕ᐗ驣悧\ue908潓\uf5fa"),
            a.c(141237100, "ὢ曄\uec13物尿罶씫䢶틻堹\udf9e⇺ꬺ㊌룐㸦萐ஸ锓\u175d黕\ue4fa樳\uf19e矢﵇䂛컂倡홲巋ꌛ⥚냜㋣뱌Ϥ視༷隋᳜扚\ue80a澵\uf104")
         );
      }

      var8 += var22 + 6.0F;
      String var29;
      int var30;
      if (var10 && var9.paused) {
         var29 = wap.s(a.d("㼝䚝챚刭\ud9ec彜\ue551沺", 140130587, -751434146), a.b("\uda0dꎓ⤳뜶㳦빝Д", -434905579)) + ifv.reasonText(var9.pauseReason);
         var30 = -678620;
      } else if (var10) {
         var29 = (
               var9.mineFound()
                  ? wap.s(
                     a.d("﹗蟂ഖ鍬\u18fe鸉\u2453궸㏼륇㻐쐶䩶펕姑\udf26敥\ueaa9瀌\uf650羠\u05f8", 251022582, -559500550), a.b("㟓乺쓜媪턏厮\uede0搜琢烶\uf724൝莇Ḧ铢ኄ곔⌂링㾛", -1824967697)
                  )
                  : wap.s(
                     a.d("Ȃ箒\uf10e漲\ue4e1扗\ud80f冻쾦䔚싇㢥뙤⾑ꖌ⍶餽\u16ff谞\u0ad8莸僚真\uecc8檻\ue077姒힎䵾쬦䃒빂㐀귱⯮ꄝỄ钶ቩ诐Ɨ", 1741279942, -391720797),
                     a.b("\u187a懙\ueb0b異ﺤ硪쉄䮿퇰弩\ud882⊆걖㗮믖㤺荽ࢹ阘၃馸\ue3e0浞\uf29f瑷︱䎝췋坌턖廆ꐅ⸹랼㗺뭚҇軳ࠤ醗", -1566630800)
                  )
            )
            + wap.s(a.c(1602356101, "ή窈\uf0cc滾\ue522掔\ud9c1债칣䓄썄"), a.c(1109554251, "瑠െ蜂ᴓ隱ၽ꩓⎪뷰㝀뒊"))
            + var13;
         var30 = var9.mineFound() ? iov.accent() : iov.textDim;
      } else {
         var29 = var13 > 0L
            ? wap.s(a.c(2125619598, "懚ᡀ銔ೣ蜾Ɖ믌㉮걥⛏ꅓ孮햰䰅왅䂨睊甾\uef99槕\ue020騦ᒏ"), a.b("趗\uf433纝\ue091歎\uedfa垨\uda40䀋쪵䴒댌㦸ꀍ⩈곙᛬鵌ߥ", -1991603804)) + var13
            : wap.s(
               a.b("ᰠ䖷\uef46然\ufaf1簍왚侬퇨存\udc9a⛽\ua879ㆇ믝㵪蝨ࢽ鈉ᑟ鶯\ue7f7椃\uf29b瓾ﹼ䞊짐匦항廌ꀒ⨕뎰㗸뼆\u0085諲ల開ΐ", 513023036),
               a.c(130258196, "鄦\ue8b8戟\uf801矈\uf176䭗슢岏혶几ꯦ⅞벊㚮끝\u0a60藋ἂ鴱ᓓ交\ue035篥ﶊ獇쫰䒤\ude2d塽\ud7acⵧꜬ㻜뢀㈼跮ߨ")
            );
         var30 = iov.textMuted;
      }

      irr.SMALL.draw(var1, irr.SMALL.ellipsize(var29, var6), var4, irr.SMALL.centerTop(var8 + 4.0F), var30);
      var8 += 16.0F;
      var8 = this.ijn(var1, wap.s(a.c(-19668677, "\ue17c飲ረ豌ߏ脷㭾닜ⳑꙷ↢\udbdf唕첲䛠쀐"), a.d("\uf7a7蹳Ӝ麳ᅻ韍ⷮꑢ㩊냸㜥", 1427615357, 2013224438)), var4, var8);
      String[] var31 = new String[]{
         wap.s(a.c(1867084795, "玭ਃ胙ẽ锾Ꮦꦓ⁸빲㒁덂䤤쟷幌푔勤\ue8a4板ﶈ箐\uf260衿ڛ鵕ᬫ釰⡈ꙑ㳩몥\u3100쿐䖈"), a.c(1409377163, "柑ṥ铊ລ腩ߝ붌㑱ꨫ⃧ꜰ夭폢之쀊䋩ﲼ獧\ue9de澋\ue67e頳ኟ襏ཎ薐㱘눇⣿")),
         wap.s(
            a.d("ぴ䧓쌚嵬훩倌\uea5e推\ufdeb睇\uf0ddશ萲ᶀ韆ᄷꭹⓠ빟㡝놭쯩䕉\ude9e墹퉤殘\ue5d0缴沈狀谊ق龳᧻鍍", -1161038464, 2007090601),
            a.b("萩ﶙ睆\ue93b抒\ue45d干폡䦤쌟䓀뺸〚ꦠ➂ꅩ\u1f47郭ਗ਼豵\u05fc習\uf162檽\ue8a2承\udfac再쭽䴨욖㡄똚\u2fe7궫✐颲\u12b6鑫ධ蟼滑", 811368508)
         ),
         wap.s(
            a.d("\ue4d5鵦ឬ觎ȑ蒨㻰뜛⤊ꎡ␅\ude03債쥥䍅엇翬\uf055櫪\uecf1攙ὐ釾ਬ谌ۑ뼱ㅣꮖⷜꙨ墣", 313694786, -686981414),
            a.d("灍৺茣ᵜ隈ေꩧ⎛맋㍠듄仂쁴妤펄唆\uef2d悔飼硥\uf1ed讷չ麤ᣙ阜⾣ꖓ㼚뤴㋿찫䘛", 1947253947, -811022109)
         ),
         wap.s(
            a.c(1048495236, "쓞뵨㞣ꦅ∟꒶ỳ霉ञ菶г﹘烚\ue92d捹\ue59b忋퀒䪠첯䕂㽟뇥⨰걜⚑鼿ᄽ讌\u0dc9虧碴\uf2b6欞\ued5b柰\ud820刃풒䴤읭릛㎜둠⺵ꃆᤝ鎧ᗲ踤"),
            a.c(-1378472830, "⣲儸\udbef䖛츻䣼\uf2ab罄\ue506澺\ue81dመ鲿ղ輥ৗ랙㡒Ꚃ⃗꥟퍴巄옛䐋쫇獹露枭\ue18c樳铤Ỗ荂Ċ诃㐐빮㣍ꄁ⼻嗖\udf87場싪䲓\uf53f翼阮")
         ),
         wap.s(
            a.b("ᔟ泯\ue62f砩\uf39a畸켶䛈\ud886刴헼⾊ꅆ㢣늿㑇蹎ǋ魤ᴸ钊\uee99怤ﯶ綅\uf75c价샵婃\udc01垯ꥤ⌰뫋㳜똴৵莞Ԙ鳬ᚠ桂\ue206於Ｒ焗죙䉢쐥", 1554060623),
            a.c(763637502, "⻯圩\udd93䞎찥䪑\uf0c6礵\ue76e槅\uea07ၼ麮ܛ赌ற뗬㸯꒐⋅ꭈ턚忙쀛䉾좥焐ｃ旋\ue3e8求雱᳄蔷")
         )
      };

      for (String var35 : var31) {
         uut.circle(var1, var4 + 2.0F, var8 + 5.5F, 1.4F, iov.accent());
         irr.SMALL.draw(var1, irr.SMALL.ellipsize(var35, var6 - 8.0F), var4 + 7.0F, irr.SMALL.centerTop(var8 + 5.5F), iov.textDim);
         var8 += 11.0F;
      }

      var8 += 4.0F;
      double var43 = tcz.unit(MinecraftClient.getInstance());
      ttb var44 = var7.mineModel();
      String var45 = wap.s(a.b("⦬倫\udaf3䒟콒䧾\uf3b0穞\ue41e溲\ue96c፞鶓", -1348982286), a.c(-1070830805, "漍ᚨ鱳ɾ觘ୣ넪"))
         + ijx(var43)
         + wap.s(a.b("ദ琈ﺗ惪\ueb27涍ퟄ", 175771025), a.b("妻ₕ깗ず뮎㴹蝼ພ", -1261938429))
         + iix(var7);
      if (var44 != null && var44.hand.unit > 0.0F && Math.abs(var44.hand.unit - var43) / var44.hand.unit > 0.15) {
         var45 = var45 + wap.s(a.c(-845924040, "㤔䂥쫡吇\udfd0夬\ue37d檇\uf4d9繡理Ώ"), a.b("ꆃ\ud832剶첐䝇얕箥\uf648栕\ue2ae敼鼃ᇗ豤ح", -1462722132)) + ijx(var44.hand.unit);
      }

      irr.SMALL.draw(var1, irr.SMALL.ellipsize(var45, var6), var4, irr.SMALL.centerTop(var8 + 5.0F), iov.textMuted);
   }

   static String iim(tiq var0) {
      return a.b("Ź磼\uf22e汄\ue7ab愬\udb6c劋쳕䙯", 1552089394)
            .equals(var0.get(a.d("㺔䜳췭厛\ud809廡\ue4ac浀\uf303", 2109866907, -1940112015), a.c(1484887688, "雎\uef4b料ﯳ瀎\uf694䳍")))
         ? a.d("䌂㪇끕⸿ꗐ⍗餗ჰ躮Д", -621873166, 435401915)
         : a.d("뢌섉䯛햱幌\ud8d6抏", 679289206, -334390852);
   }

   void iin(DrawContext var1, float var2, float var3, float var4, float var5, float var6) {
      tiq var7 = this.ihe;
      float var8 = this.ijn(var1, wap.s(a.c(-1002744357, "喝Ⱊꛄ㢲덧㗑辋ؽ頰ኖ镃漾\ue1f4硓\uf20d瓻캽"), a.b("ↁ堗틋䲽윓䆯ﾐ爄\uec20暛\ue130ᬼ閑", 1152198043)), var4, var5);
      tyd var9 = tcz.walkRecorder();
      boolean var10 = var9 != null && tcz.sessionProfile() == var7;
      long var11 = var7.getLong(a.d("鸧\ue780浞\uf328確﹑䐟췤厳\ud91a", -1500738065, 314839989), 0L);
      long var13 = var7.getLong(a.b("É祮\uf3b0淆\ue654悦\udafd匝쵓䟵쀧", -729284427), 0L);
      long var15 = var7.getLong(a.d("㲫䔌쿒冤\uda36峛\ue695潾\uf120简ﱅ", -1763818375, -1916962642), 0L);
      long var17 = var7.getLong(a.c(-338760064, "\ueefd靚ᶄ菲ࡠ躕㓙봰⍲꧀"), 0L);
      if (var10) {
         double[] var19 = var9.unsaved();
         var11 += Math.round(var19[0]);
         var13 += Math.round(var19[1]);
         var15 += Math.round(var19[2]);
         var17 += Math.round(var19[3]);
      }

      float var42 = (var6 - 6.0F) * 0.5F;
      this.ijo(var1, wap.s(a.b("ⲩ唏\udfda䆧쩭䳊\uf698罨", 586427603), a.d("ᑐ淦\ue73a祌\uf2e2琢칼䞎", -325390788, -1774125485)), ijv(var11 / 20L), var4, var8, var42, true);
      this.ijo(
         var1,
         wap.s(a.d("줮낉㩗ꐡ⿸ꥈ", 2059237127, -1937195432), a.c(-794473393, "䡸ㆶ묛╭꺷⠇鉜ᮮ")),
         var13 + wap.s(a.c(-977576553, "嶵⑉"), a.b("橞៳", -2013173124)),
         var4 + var42 + 6.0F,
         var8,
         var42,
         false
      );
      var8 += 30.0F;
      this.ijo(var1, wap.s(a.d("튨ꬄ⇍뾽㑻닜", 812318509, 897002993), a.c(-69523901, "≶寋텨休쓎䉼\uf82e熣\ueff0")), String.valueOf(var15), var4, var8, var42, false);
      this.ijo(
         var1, wap.s(a.c(1728247516, "\uf6b3輝ז鮺ၮ"), a.b("铻\ued35柭李爺\uf48f仐", -1426222909)), String.valueOf(var17), var4 + var42 + 6.0F, var8, var42, false
      );
      var8 += 32.0F;
      String var20 = var10 ? var9.module : iim(var7);
      this.ijr(
         var1,
         var2,
         var3,
         wap.s(a.b("Ⴂ椶\ue3e2綘\uf659炻쪮䍋\udd09垺", 1710756068), a.b("䕽㳯똹⡍ꎚℳ齾ᛳ", 1903182190)),
         var20,
         var4,
         var8,
         var6,
         () -> {
            if (!var10) {
               var7.set(
                  a.c(-512873262, "Ⲭ唋\udfd5䆣쨱䳙\uf694罸\ue13b"),
                  a.c(-2061156837, "㹝䟘촊占\ud89d帇\ue45e").equals(iim(var7)) ? a.b("ℨ墭퉿䰕쟺䅽\ufb3d狚\uec84显", -1708056221) : a.b("≖寓턁佫쒖䈌\uf855", 1520574992)
               );
               var7.save();
            }
         },
         () -> {
            if (!var10) {
               var7.set(
                  a.c(-2104034611, "荒茔\u09ca鞼ᰮ髆₋ꥧ㜤"),
                  a.c(-121406317, "糕Ր辂ᇨ騕\u1c8fꛖ").equals(iim(var7)) ? a.c(1964304519, "\ue8cc酉ᮛ藱พ袙㋙묾╠꿚") : a.d("痝ౘ蚊ᣠ錝ᖇ꿞", -95495921, 222014612)
               );
               var7.save();
            }
         },
         wap.s(
            a.c(-1746986687, "ᥗ惙\uea0b瑰ﾬ祕썋䪸퓬幌\ud986⏾구㒍뻂㠾艾\u0db2青ᅗ颼\ue2e0氖\uf795燷לּ䊎쳎嘯퀭察ꔁ⽄뛱ユ멜ց迦०邃ᫀ搼\uee2a槗\uf303絲쒺世졞历\uddb2✴꺜⣌눺㱢螘Đ譵ኾ鱜\ue65a憿\uebe3甫"),
            a.b("䥵ヮ먷⑂꾒ⴺ鍵᪆蓓ต覾玸賈擓\uee83桰퉁嶖읟䕬좇닚㰙Ꟁ↷ꭥ\u12d7鲏ȓ聚\u0ff1\uf53b缌\ue6fc惝\uea69嗉\udbd6崉삧䫹㐌빕㷴ꍁⴹ邁Ḩ顫ϟ趵睠", -127054501)
         )
      );
      var8 += 20.0F;
      float var21 = 18.0F;
      float var22 = var6 - 50.0F;
      boolean var23 = irr.inside(var2, var3, var4, var8, var22, var21);
      if (var10) {
         irr.primaryButton(
            var1,
            wap.s(a.d("╓峅혍䡣", 1514693325, -1911207991), a.d("ﾘ虊\u0ce5銕", -744627058, -1657725133)),
            vhz.PAUSE,
            var4,
            var8,
            var22,
            var21,
            var23 ? 1.0F : 0.0F,
            0.0F
         );
         this.ihc.add(new ige(var4, var8, var22, var21, tcz::stop, null));
      } else {
         irr.primaryButton(
            var1,
            wap.s(a.c(-206198143, "ꫝ퍛妎쟳䰹쪞炉勞杦\uedda樎遽ậ蜕"), a.c(433288826, "牢௴脨\u1f5e铰ሰꠑ⇮믝㔉늡䣚왵徹햘")),
            vhz.PLAY,
            var4,
            var8,
            var22,
            var21,
            var23 ? 1.0F : 0.0F,
            0.0F
         );
         this.ihc.add(new ige(var4, var8, var22, var21, () -> {
            tcz.startWalking(var7, iim(var7));
            this.close();
            if (this.iht != null) {
               this.iht.close();
            }
         }, null));
      }

      if (var23) {
         this.iho = wap.s(
            a.b(
               "\uea56鏛ᤅ蜱ಫ記\u3040릠⟦굞⫈탽帼잞䷛쬮焲ﺷ搘\ue244毶ᇵ齛Ґ苮\u082e뇔㾉ꔧ⍠\ua8c9噍\udc55䖲쏬䥚\uf6c6糾侮揕\ue9d3霴ᵽ髋\u001d蹺㞠봛㬉ꃃ\u2ef9퐵巖\udbcb䄻콪瓎\uf218砸\ue1ab漇ᔏ銵\u18f9蘱ྖ뗌㌷",
               1569516102
            ),
            a.d("᭙拊\ue813瘕ﶺ筼앃䣒훵尽\udbec⇫꽋㊘볗㨪耕࿌長ጥ髓\ue4ec橓\uf59a珩諾䃷캢倹퉷姅ꌊⵘ뒡㋻렵\u0381趑ଳ銎᳖戼\uec74殽\uf16b罨욾䱸칕冚\udfeaΩ곰⫐뀯", 704888019, -1495620703)
         );
      }

      float var24 = var4 + var22 + 6.0F;
      float var25 = var6 - var22 - 6.0F;
      boolean var26 = System.currentTimeMillis() - this.ihr < 3000L;
      boolean var27 = irr.inside(var2, var3, var24, var8, var25, var21);
      irr.secondaryButton(
         var1,
         var26 ? wap.s(a.d("븈잟䵋팭墠", -1794287713, -368252479), a.b("\uf6f0轝\u05f7鯼ဨ銘", 884142804)) : "",
         vhz.TRASH,
         var24,
         var8,
         var25,
         var21,
         var27 ? 1.0F : 0.0F,
         0.0F
      );
      this.ihc.add(new ige(var24, var8, var25, var21, () -> this.ije(var7), null));
      if (var27) {
         this.iho = wap.s(
            a.d("ℼ墬퉶䰎쟈䅨ﭾ狎\uec9c昭\ue1b2ᮑ镑೦蚹U먌㗐꽤⤼ꃟ\udadd吡쿹䧀썅竪\uf4ba湗\ue855掶鵥\u1737軏\u0893舧㷹럍ㄖꣻ⊸屄홒冮쭻䔁ﳓ癫\uf068毪\ue59e\u1f5a雵Ⴎ訇", -311922363, -1038856182),
            a.c(-1048733834, "鍸\ueade怉ﹳ疧\uf36c䤱쒬廡퐣厄균✠뺖㓊눼ࠊ螢ᤉ魇ዏ棠\ue629綄ﯸ煝첁䋘\udc3b婨퇑⼁ꕀ㳆뻹ざ迾\u058c茭᪑郆\uee40搐\ue3af紞")
         );
      }

      var8 += var21 + 6.0F;
      String var28;
      int var29;
      if (var10 && var9.paused) {
         var28 = wap.s(a.b("⿕噕\udc92䋥줤侔\uf599籲", 511061901), a.c(-1966910357, "偳⧭ꍍ㵈뚘㐣蹪")) + ifv.reasonText(var9.pauseReason);
         var29 = -678620;
      } else if (var10) {
         var28 = wap.s(a.c(-95841273, "鑍\uedca朔異狾\uf40e乐잢姼퍄哐껵‾릂㎔딩ལ肵ᨍ鰙ᕹ澿\ue15e窒ﳷ瘧쾅䇂\udb66"), a.d("룗셊䮕퇼帴\ud884曉\ueb23畿ￋ砝艬ࢣ醅ᭁ馬⏯걎㛵났㥘䌈췇嘚푷", -265059750, 198196876))
            + var15;
         var29 = iov.accent();
      } else {
         var28 = var11 > 0L
            ? wap.s(a.d("섮뢨㉽가⟊ꅭᬿ鋏\u0cce虥", 2027799747, 1229391285), a.d("䈡㮷녫⼝꒳≳頭ᇟ讄į", -875935486, 1054543678)) + ijv(var11 / 20L)
            : wap.s(
               a.b("៵乢\ue493竣\uf124矘춏䑹\uda3d傍흏\u2d28ꎬ㩒뀈㚿貧͠駞ᾈ陽\uec2b抑龜缱\uf5fa䰚숎売\udea2唋ꯈↈ렱㸶뒜\u0b04脡ߴ鹖ᐁ櫷", 1736120298),
               a.c(-1667811486, "㍓䫍쁪婴햽匃\ue922惗ﻺ瑃\uf395ও茫ỿ铛ረꠕ➾뵷㽄뚦\uecd1䉀\ud990忿턲梅\ue6d1籘行痙轭ՙ鲢᪉遅\u2fe8")
            );
         var29 = iov.textMuted;
      }

      irr.SMALL.draw(var1, irr.SMALL.ellipsize(var28, var6), var4, irr.SMALL.centerTop(var8 + 4.0F), var29);
      var8 += 16.0F;
      var8 = this.ijn(var1, wap.s(a.b("\uee63韭ᴷ荓࣐踨㑡뷃⏎ꥨ⺽퓀娊쎭䧿켏", 423947812), a.d("\uf67c辨ԇ齨Ⴀ阖ⰵꖹ㮑넣㛾", 1374774384, -313944544)), var4, var8);
      String[] var30 = new String[]{
         wap.s(
            a.d("⇟塩튢䲄윊䆭ﯤ牀\uec59曡\ue131ᭀ閔ఽ蘹\u009c뫏㔓꿥⧸ꀊ\uda5c哤콪䤏쎩穭\uf45d滋\ue8e9挩鶜ុ蹆ࡆ苴㴡띋㆟꠴∳峎훗兹쮶䗚ﰊ", 329303172, -799611620),
            a.d("㈷䮌셕嬾퓱剌\ue87a憒\uffc9焔\uf2d8ࢨ艡Ή閛፯ꤥ⛴롅㸎랎춨䍺\ud8ca廆푤涳\ue38a祱סּ炌踢Е鷡ᯍ锒⫉꒧∋뮱㆓佮씿", 425941720, 723741950)
         ),
         wap.s(
            a.c(1019366043, "䫌㍫릢⟔걑⪳郣ᤇ蝘෨詿灏ﺗ本\ued3b殓퇊币쒵䊶쬂녑㿮ꐷ≟ꢝᅯ齪֜菊ࡥ\uf6a9粵\ue513损\ue9ef嘽\udc45嫓쌵䥼㞀뷔㩧ꂷ⻏"),
            a.d("伮㛯배∰궈⽘镰ᲅ芤\u086b过疵ﭬ暱\ue8fa樓푃宓섬䝱컸듗㨘ꖫ⟎괕ᒪ髲p蘪৲\uf33c礌\ue085拎\uec1a厶\ud9cd彦욪䳱", -1726419269, -1761696258)
         ),
         wap.s(
            a.c(2074456815, "늠쬖䇝\udffb呵틒梛\ue13f缣\uf59e牐蠡ۡ齖ᔒ鎷⦯ꙡ㳟명㌼䤴작屚\uda70僭\ue957朂\ufde2箠\uf056໓蒀ᵼ魪ᆗ깅\u2433ꋫ"),
            a.c(1400379055, "\u12b1權\ue1d3箸\uf470狀좒䄜\udf33喀퉚⡟꛲㼾땩㎕觔ɦ飙\u1a9d錞\ue935枅\uf84c穐\uf08a䤠윛姷\udbc7吕껟⒓뵧㬱놀")
         ),
         wap.s(
            a.b("뚔켦䗵\udb9f偕훣油\ue50f笙\uf1b2瘲谍˛魱ᅶ韕ⶍꉚ㣥뺩㝈䴘쎪堥\ude40哅\ued6a挶濾羗\uf429ૣ胸᥍鼕ᖮꩯ⁍ꛗ㽻", -1301236016),
            a.b("餦\ue0ef樽\uf43e翤縷䌎컪咨\ude11巗ꎹ\u2d69뒨㺆렀Ɍ趓ፕ锞\u18fc披\uec15珚\uf1b1筡시䲆홴偒\udf83╃꼃㚎", 300784959)
         )
      };

      for (String var34 : var30) {
         uut.circle(var1, var4 + 2.0F, var8 + 5.5F, 1.4F, iov.accent());
         irr.SMALL.draw(var1, irr.SMALL.ellipsize(var34, var6 - 8.0F), var4 + 7.0F, irr.SMALL.centerTop(var8 + 5.5F), iov.textDim);
         var8 += 11.0F;
      }

      var8 += 4.0F;
      double var43 = tcz.unit(MinecraftClient.getInstance());
      String var44 = wap.s(a.c(-792372005, "岅│꿚ㆶ멻㳗蚙ཷ鄷ᮛ鱅晷\ue8ba"), a.b("襦\uf0c3稘\ue415澳\ued08坁", 1492356416))
         + ijx(var43)
         + wap.s(a.c(1616488958, "ꥉ큧嫸쒅佈짢玫"), a.b("ꢏ톡彣셮䪺찍癈ﾪ", 1520347191))
         + iix(var7);
      irr.SMALL.draw(var1, irr.SMALL.ellipsize(var44, var6), var4, irr.SMALL.centerTop(var8 + 5.0F), iov.textMuted);
   }

   void iio(DrawContext var1, float var2, float var3, tiq var4, float var5, float var6, float var7) {
      txs var8 = var4.walkModel();
      if (var8 == null) {
         boolean var25 = a.c(1353163000, "ꂔ\ud926叽").equals(var4.walkIssue());
         irr.LABEL
            .draw(
               var1,
               var25
                  ? wap.s(
                     a.b("ஒ爀\uf8db曮\ued74毇톟塯옹䳞쬗ㄲ뿣♁갚⫬郭ώ藈Ο詠\uf036", 1720257483), a.b("聪隸猙\ued18暿\ue071幍펠䷽읆䂔뫫㑋ꦌ⏅ꄪ᭪铉\u0e7e衐ֿ篹\uf54d溑\ue8ed戰\udb8f", -1586658224)
                  )
                  : wap.s(a.b("욞뼎㗆ꯣ\u2060ꛗᲗ镮ଶ膌ٞﱫ狥\ueb48愊", 645973727), a.c(261866376, "잓빾㒵꺵ⅿꟆᦀ鑯ਿ胼ܫﴨ珷\uea4b")),
               var5,
               irr.LABEL.centerTop(var6 + 6.0F),
               iov.textMuted
            );
         var6 += 16.0F;
         irr.SMALL
            .draw(
               var1,
               irr.SMALL
                  .ellipsize(
                     wap.s(
                        a.b("⮀切\ud8d9䚯촳䯖\uf199硥\ue67f沂\ueb54ᄢ鿾ٙ豙૱남㽣ꗗ⎇ꩦ퀾庇씐䌩짱灟﹜撾싉楘鞈ᷗ葫ȼ袊㝆봶㯴ꉓ⡓嚮\udca9嬄쇞侤\uf639糜歹慗\uef2cᗺ", 1524771811),
                        a.d("Ρ稱\uf099溓\ue54e揳\uddb8偖츈䂧썯㤝럏\u2e7bꑟ⋝鲎\u173e跼\u0ba1虊ﰎ力\ue968漖\ue5d7塸혭䳟쫰䅂믽ㆾ걐⨂ꃏὤ锗៘詷'纤\uf4f3猽", 328496231, -561220619)
                     ),
                     var7
                  ),
               var5,
               irr.SMALL.centerTop(var6 + 4.0F),
               iov.textMuted
            );
      } else {
         String var9 = new SimpleDateFormat(a.d("볙앨俱퇣娴\udce8曓\uef22焏ﯩ簺", -534635936, -1474386218), Locale.ROOT).format(new Date(var8.created));
         irr.LABEL
            .draw(
               var1,
               wap.s(a.b("覩\uf02e竰\ue486潉\ue9ab厴\uda40䐝캢䤴댜㷝ꑶ\u2e70", 586451441), a.c(797861510, "抱ᬛ釂࿋葡ˑ벒ㅹ꼬▗Ꙟ塌틸伫씏䏺溜牵"))
                  + Math.round(var8.keysAcc)
                  + a.b("ࠫ", -261945329),
               var5,
               irr.LABEL.centerTop(var6 + 6.0F),
               var8.keysAcc > var8.keysBase + 5.0 ? iov.accent() : iov.text
            );
         irr.SMALL
            .drawRight(
               var1,
               var9 + a.d("\ue837醆ᯂ蔤\u0ef3", -840447058, 1217012668) + ijv(var8.samples / 20),
               var5 + var7,
               irr.SMALL.centerTop(var6 + 6.0F),
               iov.textMuted
            );
         var6 += 15.0F;
         txp var10 = var8.style;
         this.ijp(
            var1,
            wap.s(a.c(-377017069, "ⵍ哒\ude1d䁦쯢䷄\uf700纻\ue0fb橌\ued98ួ餾\u0093諍౹뙣㦴ꌁ╄겾"), a.d("\ude01ꞑⵉ댺㣧븦Ѕ觬ᜤ鴂Ỏ\ue4c0橩\uf3a7秷ｺ䄫쫤偘홳很▣ꭦド", -1371753526, -1912378935)),
            ijd(var8.keysAcc) + a.c(-1179419371, "紶А蹔") + ijd(var8.keysBase),
            var5,
            var6,
            var7
         );
         var6 += 12.0F;
         this.ijp(
            var1,
            wap.s(a.b("\uf6f8轫ִ鯍ဍ隯ⲽꔘ㭆뇰㘿챓䋗\udbf1儵힇淎\ue213碥ﻱ省൙", 1816524461), a.b("艁\ufbd1焎\uef73據\ue215堺햩俬앗䊈룰㙒꿨⇐Ꞷᵮ隠ఒ訿δ秠\uf756沃", 1540851270)),
            ijd(var8.yawSim) + a.b("爉ଯ腫", 1170305578) + ijd(var8.yawCeil),
            var5,
            var6,
            var7
         );
         var6 += 12.0F;
         this.ijp(
            var1,
            wap.s(a.d("译\uf242碝\ue6e4洤\ueb86冔\ud835䙳쳟䬛녡", -613411121, 1865784657), a.c(1962264956, "쵬듰㸩ꁙ⮋괹፷麜É詴ථ\uf7aa祶")),
            ijd(var8.pitchSim),
            var5,
            var6,
            var7
         );
         var6 += 12.0F;
         this.ijp(
            var1,
            wap.s(a.d("癫\u0fe5蔮ᭂ邖ᙴ결◖믚ㅨ뚹䳓숃宨", 1263517987, 333297420), a.b("앤벊㙒ꡞ⎅ꔶ᭽鈛\u0cd3舃֮ﾠ焏\ue8bb抗", -1030569612)),
            ijd(var8.jumpAcc) + a.b("㓯䷉잍", 59847884) + ijd(var8.sprintAcc),
            var5,
            var6,
            var7
         );
         var6 += 12.0F;
         this.ijp(
            var1,
            wap.s(a.c(1328343975, "\uebec鉫ᢢ蛔\u0d51记ㇲ렁♘견⯨턎徊옸䱩쪃烋\uff00"), a.c(-1605097522, "⏾婟킀件세䏫紐瀷\uee6b情\ue781ᵧ韑พ萲ʻ룱㝟")),
            ijw(var10.speed)
               + wap.s(a.c(417530513, "ʶ筊\uf1db濶\ue472扔\ud890"), a.b("鲖\ue13b濻\uf5e4穒ﱴ䚰", -611738447))
               + Math.round(var10.sprintShare * 100.0F)
               + a.d("ẑ", -698866516, 1394162201),
            var5,
            var6,
            var7
         );
         var6 += 12.0F;
         double var11 = iip(var8);
         this.ijp(
            var1,
            wap.s(a.b("퇹ꡥ⊭번㜑놡௪", -746270276), a.d("ἦ暸\uec17瘄零罷씨䲧튏塏", -1879058441, -1555837750)),
            var11 < 0.0
               ? wap.s(a.c(-1123496452, "춝됭㻥ꃀ⭀귧ឹ鹏\u0012誤ൾ\uf748秆\ue06b権"), a.b("⣡儬\udbe7䇧츭䢔\uf6d2筆\ue562濙\ue806ቴ", -414896936))
               : ijw(var11) + wap.s(a.b("蒴﵈矙\ue9f4", -24607600), a.c(610902530, "ꈦ\udf8b克쭔")),
            var5,
            var6,
            var7
         );
         var6 += 12.0F;
         irr.SMALL
            .draw(
               var1,
               irr.SMALL
                  .ellipsize(
                     wap.s(
                        a.c(-1969002264, "梔ᄮ鯰և蹘ࣧ늵㬀ꔐ⾠\ua83d创\udcda䕦켲䧁\uf389籑\ue6a5悽\ue957鍒ᶯ虵\u0019諛㍿뵼⟘ꆛ⨾"),
                        a.d("㘹俷앚嬧탷嘳\uec15旬ﮰ生\uf6d1ಭ虪ᮾ醖\u176d굚⋶롁㨉돲춹䌎\ud8a3庠퐏淂\ue394絺Ｖ璍蹉\u0014駯ᾰ销⫙ꂣ", -219000085, 90464459)
                     ),
                     var7
                  ),
               var5,
               irr.SMALL.centerTop(var6 + 4.0F),
               iov.textMuted
            );
         var6 += 13.0F;
         float var13 = 18.0F;
         boolean var14 = lfa.walksWith(var4);
         boolean var15 = irr.inside(var2, var3, var5, var6, var7, var13);
         if (var14) {
            irr.secondaryButton(
               var1,
               wap.s(
                  a.d("鎟\uea1a惈ﺢ畟\uf3c5䦜쀩幹퓇卵ꤰ⟦빌㐧닠ࢼ蝻᷉鮓ሪ栬\ue689絕שּׂ熷졓䘜\udcf6媻텀\u2fd8ꖊ", 1534695411, 1921319948),
                  a.c(509993946, "\ue386騃ბ躻Ն菜㦅뀰\u2e60ꓞ⍬\ud929埿칕䐾싹碥\uf762淐\ueb8a戳ᰇ鋏औ輐\u05cc렝㉙ꢢ")
               ),
               vhz.CHECK,
               var5,
               var6,
               var7,
               var13,
               var15 ? 1.0F : 0.0F,
               0.0F
            );
            this.ihc
               .add(
                  new ige(
                     var5,
                     var6,
                     var7,
                     var13,
                     () -> {
                        lfa.activateWalk(null);
                        this.iib(
                           wap.s(
                              a.b("肄契珗\uede3晹\ue0ca媒퍲䴴잌䁉멫㓫굌✒ꇤᯠ鑾໌裓Ű笽\uf583湞\ue83a抹\udb45唌쿢䧽숏㳘뚑⽨ꤼ", -668761869),
                              a.b("쨎뎝㥄ꝂⳭ꩟ᐔ馄ާ贕\u0aca\uf0b9穾\ue7aa涂\ueb79免\ude91䁀쉰䯶ㆫ뼜", 333303301)
                           ),
                           vhz.INFO,
                           false
                        );
                     },
                     null
                  )
               );
            if (var15) {
               this.iho = wap.s(
                  a.c(-1066715547, "㘂侜않嬱탮嘔챳斶ﮫ焙\uf6c8ಱ舭ᯈ醀\u173e괥⋨롖㹂럷춱䌞\ud8ca庭퐥淒\ue384礽［璞詂\n駹ᾭ锕"),
                  a.c(473529472, "確Ī诺ᖉ驄㳁ꚦ⭅딝㿙롷䉸첮唑\udb2e姍\ue3f1氣\uf692炽論茘ණ阄ၶ黉⌟괵㟈뇡㨯쒌")
               );
            }
         } else {
            irr.primaryButton(
               var1,
               wap.s(
                  a.b("\uf0fe襩ά鶘ᘆ邰⪭ꌽ㵖럦〮쩵䒉\udd32圥퇛殛\ue42b纬\uf8fc焐\u0b79藼Ḿ顗ኇꬿ", 42201264),
                  a.d("\ue69c齴ᗙ让{蚽㲕땭⬾ꆍ☬\udc53囨쭋䔊쎚秡\uf631沙\ueae2挾ᥥ鞒ౌ証\u008c뤋㝛궷⯞ꁛ庙퓀䴰쭨", 1745599005, -1536599878)
               ),
               vhz.CHECK,
               var5,
               var6,
               var7,
               var13,
               var15 ? 1.0F : 0.0F,
               0.0F
            );
            this.ihc
               .add(
                  new ige(
                     var5,
                     var6,
                     var7,
                     var13,
                     () -> {
                        lfa.useForWalk(var4);
                        this.iib(
                           wap.s(
                              a.c(-1949945616, "り䤏쏝嶷홊僐\uea89挼ﴢ瞜\uf045ੰ蓆ᵃ霑ᇻꮌ⑫뻋㢌녺쬠䗝\ude5b堲틮歚\ue540翻羚爞賁ۋ齣ᤦ鎍Ⰿ\ua630⃢륋㍃䶺잏䀕\udad2咤\ued6a柦\ue194穞\uf438\u0efc蝖ā鯳ᗬ긜⣌ꋸ"),
                              a.b("᩺揿\ue92d睇ﲺ稠쁹䧌펋崢\uda90⃕긃㞩뷂㬅腙ພ鐬ቶ鯏\ue5fb欳\uf0e8盬ﰰ䇡쮪兗휌墥ꈖ⡐뗊㎑륆ں賛ਏ鎣ᧁ服\ued45櫡\uf023繏잚䴪쬫哨\uda93⁃ꦁ\u2fd9딼㬁蒪", -1923212798)
                           ),
                           vhz.CHECK,
                           false
                        );
                     },
                     null
                  )
               );
            if (var15) {
               this.iho = wap.s(
                  a.c(726348237, "ㆴ䠹싧峓흉出\ueba2扂ﰄ皼\uf179\u0b5b藛ᱼ阢ე\uaad0╕뿺㦦끝쨗䓶\udf75夗폜橮\ue42e经\uf8cd猩跦\u07b4鹙ᡂ銧\u2d6cꜜ⇕렷㈥䳖욎䄾\udbe0"),
                  a.b("᠓憀\ueb59畟ﻰ硂옉䮝햹异\ud8aa⋖ꡣ㗍뾟㵰茣\u0cfe阽ၤ馛\ue3c9浻\uf6d8炫﹦䎸췦坭턻庑ꑜ⸑럪ㆸ묇ҧ軔", -1347871703)
               );
            }
         }
      }
   }

   static double iip(txs var0) {
      double var1 = -1.0;

      for (tvz var6 : new tvz[]{
         mpq.mainInstance() == null ? null : mpq.mainInstance().walkBrain(), nxa.mainInstance() == null ? null : nxa.mainInstance().walkBrain()
      }) {
         if (var6 != null && var6.model == var0) {
            var1 = Math.max(var1, var6.speed());
         }
      }

      return var1;
   }

   void iiq(DrawContext var1, float var2, float var3, float var4, float var5, float var6) {
      tiq var7 = this.ihe;
      if (var7.walk()) {
         this.iin(var1, var2, var3, var4, var5, var6);
      } else if (var7.mine()) {
         this.iil(var1, var2, var3, var4, var5, var6);
      } else {
         float var8 = this.ijn(var1, wap.s(a.c(22363561, "㷲䑴캡僜\udb16嶱\ue7ef渙\uf04f"), a.d("퍏\uaad9 빳㗝덡", -1052623169, 1499720161)), var4, var5);
         long var9 = var7.getLong(a.d("\ud8eaꅚ⮔뗢", 641116134, 1717272416), 0L);
         long var11 = var7.getLong(a.d("\ue76b黕ᐃ詪Ƭ蜊㵎뒾", 1935427227, 448242078), 0L);
         long var13 = var7.getLong(a.d("臑\uf87d犤\uecdd朒", -343667184, -104689744), 0L);
         boolean var15 = tcz.mode() == tcw.RECORD && tcz.sessionProfile() == var7 && tcz.recorder() != null;
         if (var15) {
            var9 += tcz.recorder().hits;
            var11 += tcz.recorder().failures;
            var13 += tcz.recorder().recorded;
         }

         float var16 = (var6 - 6.0F) * 0.5F;
         this.ijo(var1, wap.s(a.c(-1716408675, "껳흊嶙쏣䡰캉瓛ﴷ捯"), a.b("紬Ӫ踽ျ鮖ᵑ꜌⪘낤㩢붵䞴줝傠", 1596815713)), String.valueOf(var9), var4, var8, var16, true);
         this.ijo(
            var1,
            wap.s(a.b("飳\ue146殏\uf5fe縿\uf898䊘쬯啿\udfcb堀ꉠⲠ딆㽔", 914004113), a.b("磷Ĺ讔ᗧ鸼\u18f8ꋐ⬭녠㿏론䈒첱啺\udf5b妩", 707099864)),
            String.valueOf(var11),
            var4 + var16 + 6.0F,
            var8,
            var16,
            false
         );
         var8 += 30.0F;
         this.ijo(var1, wap.s(a.b("畬ೊ蘟ᡢ鎨ᔏ꽝⚭", 2064676118), a.b("箲Ȅ裘ᚮ鴀ᯀꆞ⡬", -1208385651)), ijv(var13 / 20L), var4, var8, var16, false);
         this.ijo(
            var1,
            wap.s(a.d("ﵢ蓅\u0e00遱ᮼ鴋❙꺵", -348315450, -1418076705), a.c(-456505159, "䳾㔻뾜⇭ꩃⳳ")),
            String.valueOf(var7.getLong(a.c(-906276409, "冼⠛ꋞ㲯띢㇕讇ɫ"), 0L)),
            var4 + var16 + 6.0F,
            var8,
            var16,
            false
         );
         var8 += 32.0F;
         float var17 = 18.0F;
         float var18 = var6 - 50.0F;
         boolean var19 = irr.inside(var2, var3, var4, var8, var18, var17);
         if (var15) {
            irr.primaryButton(
               var1,
               wap.s(a.d("脔\uf882牊\uec24", -1432357890, 2126525), a.b("邌\ue95e揱ﶁ", 201954473)),
               vhz.PAUSE,
               var4,
               var8,
               var18,
               var17,
               var19 ? 1.0F : 0.0F,
               0.0F
            );
            this.ihc.add(new ige(var4, var8, var18, var17, tcz::stop, null));
         } else {
            irr.primaryButton(
               var1,
               wap.s(a.d("卨⫮ꀻ㹆떌㌫褼\u0082黜ᐣ鎣槕\ue717纩\uf4f0爖", 1744584573, 1547201623), a.d("င榒\ue34e紸\uf696瀪츕䎅\udda5匊킸⫊ꑪ㷓랉ㅼ謿Ӫ", -1113599634, -1444887185)),
               vhz.PLAY,
               var4,
               var8,
               var18,
               var17,
               var19 ? 1.0F : 0.0F,
               0.0F
            );
            this.ihc.add(new ige(var4, var8, var18, var17, () -> {
               tcz.startRecording(var7);
               this.close();
               if (this.iht != null) {
                  this.iht.close();
               }
            }, null));
         }

         if (var19) {
            this.iho = wap.s(
               a.c(1737059567, "泹ᕯ龩Ǘ訊ಬ뚬㼜ꅒ⯣갥噐\ud894䅷쭥䶇\uf7d5砞\ue2b6擭\ued5e靖᧳舸Ј軃㜸륨⎂ꖇ\u2e60킭嫯쌖䔈쿠瀡琢粞\ue52e潧ᆟ鯆᰽蛦ࣘ넊㮹뷣♫ꡟ劆\udb31嵫쟜䧌\uf27b璮ﻙ朏\ue9b1鎧ᐝ鹖Ê褰㍭떉㿚"),
               a.d(
                  "啺⳧\ua630㠻돯㔮譮ڀ飞ሞ閰澼\ue166磔\uf289瀗츹䇫\udb2f嵶품꺦⑤뾯㷁뜔ຫ蓣ᨌ鰠\u13f6\ue946捸徭磆\uf27b䦾쟝䔐\udcae嚃⡶ꉗ◮뼼ㅀ貆ȯ葬Ὴ醸漋\ue2de擳︅瀣쯪䴿썒廠퀠ꩵⷱ\ua7da㥣났\u0eea谆ٜ駯ጻ镋沕\ue62c硺\uf3fc",
                  22231354,
                  1298622494
               )
            );
         }

         float var20 = var4 + var18 + 6.0F;
         float var21 = var6 - var18 - 6.0F;
         boolean var22 = System.currentTimeMillis() - this.ihr < 3000L;
         boolean var23 = irr.inside(var2, var3, var20, var8, var21, var17);
         irr.secondaryButton(
            var1,
            var22 ? wap.s(a.b("桌ᇛ鬏թ軤", 794781722), a.d("澜ᘱ鲛ʐ襄௴", -486026419, 115521781)) : "",
            vhz.TRASH,
            var20,
            var8,
            var21,
            var17,
            var23 ? 1.0F : 0.0F,
            0.0F
         );
         this.ihc.add(new ige(var20, var8, var21, var17, () -> this.ije(var7), null));
         if (var23) {
            this.iho = wap.s(
               a.b("僢⥲ꎨ㷐똖ザ誠̐鵂៳遬橏\ue48f紸\uf767熋쯒䐎\udeba壢턁ꬃ◿븧㠞늛\u0b34蕤ᾉ馋ቨ\uecbb曩１祍\uf3f9䰧옓䃈\ud925卦\u2d9aꞌ⁰몥㓟贍\u07b5膶ᨴ鑀溄\ue72b慰ﯙ", -724414319),
               a.b("鮳\ue215棂\uf6b8絬ﮧ䇺챧嘪\udce8孏ꔫ\u2feb뙝㰁뫷Á轩ᇂ鎌ᨄ怫\ueee2畏\uf333禖쑊䨓퓰劣\ud91a⟊궋㐍똲㢝蜵േ详ቚ頍\ue68b泛\ueb64痕", -1779130435)
            );
         }

         var8 += var17 + 6.0F;
         this.ijq(
            var1,
            var2,
            var3,
            wap.s(a.c(-125093505, "㤿䂹쩬向\udfdb奼\ue36b櫈\uf480縵匿ϖ赇ᓹ麤ᡚꈉ\u2ddf"), a.b("\ueb61鋷ᡝ虝\u0df8譇㕸룩⛃걷⮯톩式웈䳥츁灟ﾁ攴", -1898582163)),
            var7.fights(),
            var4,
            var8,
            var6,
            () -> {
               var7.set(a.d("帬➒굏㌱룺㹌", -21585824, 543686188), !var7.fights());
               var7.save();
            },
            wap.s(
               a.c(
                  -1991706054,
                  "﨟莃ॏ霢Ჺ驙”ꧪ㞹봕㫐삶串ퟚ嶟\udb74愼\ueebf瑊\uf214篭Ƴ輜ᓊ鋦ᡠꇍ⾁땪㍳뢐䙝찟嗶펹够\ue6c9泫\uea6f珁烈蝫റ諅ၳ鸪⟽굠⬝냌㺥쑮䷞쯛兩\udf37撂\ue217栰\uf1fd罇Փ苢ࢾ陪\u1fdcꗜ⍬ꤨ㚎반㨦쏰䥁흔岭\udabb怍\ue9c4瞮ﴮ笫\u0084蹘ᑪ鷫᭚ꄖ⻠뒾㈈믐䇢콺哎틑塋\ue63c濹\uf504"
               ),
               a.c(
                  -339504338,
                  "靯\ueef9摚節燶\uf325䵮삇媺큻垤귓✜몼ム똗ࡀ菰ᴢ齫ᚗ沵\ue278禭\uffd8甅첲䛷\udc0c幂헰⬥ꅠ㲁몳〪迹֤荅\u1af4邱\uee5a搎\ue3eb紤\uf74d䪏쀱䘂\uddda埂꤁\u20cfꛯ㰝눹এ輬\u0557鳰ᘬ汵\uef9c懟\ufb0f狁죬乧쑌対텚卋ꪘ\u2433멤\u31e9럂\u0d0d蓕\u1ad6鐀ᙉ涃\ue32c祚\uf08e癊챠䏫\ud9cc弈훚ⲣꘔ"
               )
            )
         );
         var8 += 22.0F;
         var8 = this.ijn(var1, wap.s(a.c(254767929, "獬ૺ耼Ṃ閟ጹ"), a.b("켴뛦㱂ꈻ⧥꼫", -478229741)), var4, var8);
         this.ijs(
            var1,
            var2,
            var3,
            wap.s(a.d("㩋䏖줟坵\udcb8", -2004408969, 134422394), a.d("\uef4b雞ᰈ艺\u09d2輑㔶별⋫ꡖ", -1428462991, 1983416618)),
            String.valueOf(var7.standCount()),
            var4,
            var8,
            var6,
            () -> ijg(var7, a.c(1367169997, "宲∄ꣂ㚼뵡㯇臉ࡵ阦\u1c8d魅愮"), var7.standCount() - 1),
            () -> ijg(var7, a.d("刔⮢ꅤ㼚듇㉡衯Ǔ龀ᔫ鋣梈", 866488164, -1991713521), var7.standCount() + 1),
            wap.s(
               a.c(293975801, "뚘켋䗅\udba3倱훓沇\ue563笳\uf188癌豮⊍鬈ᄖ韥\u2db7ꉱ㢇뺅㝶䴹쎗塑\ude25哵\ued41挙囹羺\uf40e\u0ace肂ᥡ鼲ᖈꨑ‴꛲㽐딚쯩䆫옝"),
               a.d("ﮢ舼࣪雬ᴿ鯳▵ꠥ㙹벿㭤서俁홼堽ﻸ撃\uef43痿\uf3ab稫~躰ᅴ錔\u19cfꀉ⸭득㊀뤹䟢춡偂툍墵\ue761洒\uebb6癤\uf85d蛟ಂ譇ᇣ龖", -286961977, -618286758)
            )
         );
         var8 += 16.0F;
         this.ijr(
            var1,
            var2,
            var3,
            wap.s(a.b("\uf33d誫u鸍ᗍ鍣⤶ꃝ㺅", -1933380746), a.b("湓ៃ鴜ͪ袼ฌ둗㶣ꏱ", -1659082171)),
            ijk(var7.standMode()),
            var4,
            var8,
            var6,
            () -> ijj(var7, a.b("ఱ疇ａ愿\ueae2汄홊忸솥䬟쳍", -1385034679), tiq.STAND_MODES, var7.standMode(), 1),
            () -> ijj(var7, a.d("쮎눸㣾Ꚁⵝ\uabfbᇵ顇ؚ負୲", -597092648, -1580344018), tiq.STAND_MODES, var7.standMode(), -1),
            wap.s(
               a.d("吀ⶕꝗ㥾닺㑏踂߮馦ጜ铂溥\ue021秒\uf386畦켪䃩\uda5a尀햹꾬ℎ뫏㲹똨ྗ膕᭥鴲ᚒ\ue844戈ﮰ緯\uf714䣜습䑻\uddc9埉⤴ꌰ⒗빍〻觪͜蔚", -879997274, -1050862886),
               a.d("\uf624辱ՠ魪ᓜ阊Ⱛꖯ㮅넵㚑첖䈶\udfe5冢휤浥\ue2c2砆嘆珌\u0dfc荌ᢟ麕ᑈ궆➿뵄㼊듆䨜쀮姓\udf82儧\ueefc惨\ue640翻\uf5dc譐ű", -1748401118, -1193380303)
            )
         );
         var8 += 16.0F;
         String var24 = ijw(var7.standNear()) + a.b("ᘵ", -1136380377) + ijw(var7.standFar()) + wap.s(a.c(1497293172, "\ue156颪"), a.c(1991262027, "㽩䋄"));
         this.ijs(
            var1,
            var2,
            var3,
            wap.s(a.c(172739429, "쬩늵㡼ꘊⷈꭶᄨ食"), a.b("⾌嘑\udcbb䋉쥬俐\uf5f8籷\ue25f", 833760145)),
            var24,
            var4,
            var8,
            var6,
            () -> iji(var7, -0.3),
            () -> iji(var7, 0.3),
            wap.s(
               a.d("\ua87e퇨嬣씅五젢牢﯁旊\uef67梹銍ᰉ薿\u0ff9複㍂버♤ꁾ⦇取\udd70䛪삎䨞\uf3a5緰\ue703慕\ueaefᑹ鹵ވ臁୫뒦㻐롐↤ꯨ픊归\ud8ad䈵챞疌ｩ祩\ue2b1沄阇ᾧ駲̃赙", -1844638268, 1003726282),
               a.b("坧\u2efcꐥ㹎농㜸赠ҟ髏ၺ鎷淒\ue304竀\uf0e5瘒찯䏽\ud940孾훨겺≾릧㿑땿ࢼ蛶\u181c鹀ᗱ\ueb27慩\uf899绂\uf476䮬었䜌\udeba咔⩣ꁏ➄뵚㍒誃7蘏ᷝ鎠洞\ue0b1拸ﰙ片짰䬴앓岈퉀ꠟ⾐ꗂ㬈늰࣡蹯л鯰", -1645587653)
            )
         );
         var8 += 16.0F;
         this.ijs(
            var1,
            var2,
            var3,
            wap.s(a.b("㾋䘙쳟劮\ud978", 1965440989), a.c(883786078, "蕷ﳝ瘊\ue805掬\ue562弲훍")),
            Math.round(var7.standSpeed() * 100.0) + a.c(-1366367728, "\ue234"),
            var4,
            var8,
            var6,
            () -> ijh(var7, a.c(-88483189, "\udaf4ꍂ⦄럺㰧몁\u008f褣\u177f鷛ᨈ\ue078"), Math.max(0.3, var7.standSpeed() - 0.1)),
            () -> ijh(var7, a.c(1807697629, "䚢㼔뗒⮬ꁱ⛗鳙ᕵ謩ƍ虞簮"), Math.min(1.6, var7.standSpeed() + 0.1)),
            wap.s(
               a.d("甁ಗ虜\u187a鏫ᕝ꼜⛪룡㈄뗋侷섥壇튓呷\uee37懬רּ絊\uf4f0躣\t鯋", -1886890339, -1365564468),
               a.d("͉竒\uf00b橠\ue5a6捭\ud934僆캛䑔잙㧼뜭⺖\ua4ce∼頍័赠ି蚧\uf897瘧\ued81毶\ue12e壢", 1030979002, -1473873166)
            )
         );
         var8 += 20.0F;
         double var25 = tcz.unit(MinecraftClient.getInstance());
         tck var27 = var7.model(var7.aura());
         String var28 = wap.s(a.b("倔⦓ꍋ㴧뛪う計Ϧ鶦ᜊ郔櫦\ue42b", -1297592246), a.d("囱⽔ꖏ㮂뀤㊟裖", 1389692553, 1133597790))
            + ijx(var25)
            + wap.s(a.b("䋚㯴녫⼖ꓛ≱頸", 1917534829), a.c(616350100, "섬렂㛀\ua8cd⌙ꖮΎ阉"))
            + iix(var7);
         if (var27 != null && var27.unit > 0.0F && Math.abs(var27.unit - var25) / var27.unit > 0.15) {
            var28 = var28
               + wap.s(a.d("\uec36閇ῃ脥\u0af2谎㙟뾥⇻ꭃⳆ횭", 1147380396, -1819324746), a.d("\"禓\uf3d7洱\ue6e6搴\uda04埩즴䌏쓝㺢끶ⷅꞌ", -218499956, -1473121151))
               + ijx(var27.unit);
         }

         irr.SMALL.draw(var1, irr.SMALL.ellipsize(var28, var6), var4, irr.SMALL.centerTop(var8 + 5.0F), iov.textMuted);
      }
   }

   void iir(DrawContext var1, float var2, float var3, float var4, float var5, float var6) {
      tiq var7 = this.ihe;
      boolean var8 = var7.aura();
      boolean var9 = var7.mine();
      boolean var10 = var7.walk();
      boolean var11 = var9 || var10;
      float var12 = var5;
      if (!var11 || var9) {
         var12 = this.ijn(var1, wap.s(a.b("ᷰ摧\ueea7烞\ufb0e綴쟰", 759373219), a.d("ቝ殎\ue128网\uf48e牊", 463380721, -426133880)), var4, var5);
      }

      if (!var11) {
         var12 = this.iis(var1, var2, var3, var7, var8, var9, var10, var4, var12, var6);
      }

      if (!var8 && !var10) {
         this.ijq(
            var1,
            var2,
            var3,
            wap.s(a.d("좲넵㯻ꖕ⸒꣬ኦ魄Ԍ込ࡴ\uf202糕\ue57f漫", -608835866, 789786143), a.c(358794894, "슒묇㇖ꮰ⑸ꋃᣥ酡༰藫ȫ\uf826盽")),
            var7.clean(),
            var4,
            var12,
            var6,
            () -> {
               var7.set(a.c(1206694895, "뎖쨡䃡\ude98啈폲榶\ue01b縉\uf4b7獭褘߀"), !var7.clean());
               var7.save();
            },
            wap.s(
               a.c(-934462373, "㰡䖦콴儂\uda86屣\ue62c濐\uf1ca笶ﳧڔ衋ᇱ鮸ᵎꝒ⣚뉿㐴붖잁䤸틠咍\ude0b柨\ue9a8獍\uf51b综聹ਪ鏖ᗀ鼥⃧ꪅⱃ뗰㾾䄛쬇䲬홺塟\ue1c3死\ued72盷\uf898Ʉ讶ඣ靕ᤑꊻ"),
               a.c(-1993555729, "쓍봥㟽꧹∬꒚Ọ靊൷菞Ђ賓炧\ue912捌\ue5bd径큛亍쳀䔵㽦뇜⨅갅⛝鬉ᕔ记෦虔粐\uf2bd歅\ue97d染\ud87b剴풢䴝융릶㏮끄\u2ef5ꃷᤪ鏬")
            )
         );
         var12 += 16.0F;
      }

      if (var9) {
         int var13 = var7.mineBoost();
         this.ijr(
            var1,
            var2,
            var3,
            wap.s(a.d("\ue0eb饱Ꮃ趖\u0603肿㫬댁ⵙ", -987290832, -327957604), a.c(-2037654888, "\ude80ꝣⶲ돀㱵뺥҂贄ጡ")),
            var13 == 0 ? wap.s(a.d("戽ᮅ酖", 859721277, 966274156), a.b("\udd9aꑒ⻰낀", 1744230828)) : a.c(-505192682, "弼") + var13 + a.b("᠌", -1179445208),
            var4,
            var12,
            var6,
            () -> ijf(var7, 1),
            () -> ijf(var7, -1),
            wap.s(
               a.c(
                  494344611,
                  "ᦋ思\uead6瓰ｪ秃쎆䩼푫庘\ud94c⌬귻㑛븟㢼芧൪韐ᆎ頷\ue23f沚\uf751煡ﮪ䉟찉囬킺嬘ꗞ⿃뙺〠몞Ճ轶\u09e4遚ᨏ撺\ueebb椝\uf3ce綽쑹仕좜卌\udd7d➠깚⠉닧㲡蝛ǅ访ረ鳆\ue681慨\ueb3e疣ﱐ䘄샣䪳핖忈\ud9bb⁽꫟㒚뼸㥧莜\u0a54鑼Ụ颪\ue310淔\uf7f7繿\uf8da䊑촻圬톘塚ꈲⳫ띙ㅅ"
               ),
               a.d(
                  "⚨弴퇷䯧쁋䛾ﲨ甮\ueb07憲\ue27fᰕ銺ଏ腓ߟ릅㈶ꣲ⺧Ꜯ\ud90a垣졣书쒽納\uf35e槜\uef8d怫骚ზ襞༇膦㩩됀㚳꽷┭寖퇹嘶첖䚄｛燻\uf7bb汯\ue26bᢾ酴ጰ趡\u0380렳㻤듪⥞ꎈ\ud9a8幗푱䪰읤祔ￒ疁\uea47惮\ue6e9Ἰ釬\u0bdf聛ٱ벽㕦ꬒ⇜ꎔ\ud82f勩좟䕐쟾綢\uf229栌\ueecf杢鴒Ꮝ衶ว蓫㪘댴ⷯ",
                  1146801412,
                  168095701
               )
            )
         );
         var12 += 16.0F;
      }

      if (!var11 || var9) {
         var12 += 6.0F;
      }

      this.iit(var1, var2, var3, var7, var4, var12, var6);
   }

   float iis(DrawContext var1, float var2, float var3, tiq var4, boolean var5, boolean var6, boolean var7, float var8, float var9, float var10) {
      this.ijr(
         var1,
         var2,
         var3,
         wap.s(a.d("瘱ྥ蕱ᬂ郊ᙧ갢", -1010810048, 672412966), a.b("\ud86aꇶ⬢땙㺃롅ɤ讝ᗇ齻", 927521917)),
         var5
            ? a.b("톉ꠚ⋌벽㝇뇂\u0b96艴", -412954166)
            : (
               var6
                  ? wap.s(a.c(94574961, "ᤸ悭\uea79球"), a.b("迢\uf64b糭\ue29b椾", 332106703))
                  : (
                     var7
                        ? wap.s(a.d("먌쎋䥕휣島\uda40怚", -959535018, -866577910), a.c(1256704016, "찳떙㽀ꅉ⫣걓"))
                        : wap.s(a.d("雗\uef4b斃ﯵ", -1360493367, 1912869464), a.d("Ꮰ橾\ue0d1纩", -1940454708, -1580591815))
                  )
            ),
         var8,
         var9,
         var10,
         () -> ijj(var4, a.c(420686242, "⧕偡\udab5䓆켎䦣\uf3e6"), tiq.PURPOSES, var4.purpose(), 1),
         () -> ijj(var4, a.c(-168794731, "既᱖隂ࣱ茹֔뿑"), tiq.PURPOSES, var4.purpose(), -1),
         var5
            ? wap.s(
               a.b(
                  "슂묑㇇꾶\u244cꋉᢝ酿ཻ藐ɏ\uf837盤\uef46攉\ue3e5姹황䳗쪆䌽㤵랐ⱛꨣ₠饇ᜐ跴\u0ba7耜经\uf487浿\ueb6b憔\ude48吽틽䬞섀뾰㖷눓⣗ꚳὢ闂Ꮥ蠈بﳣ畐\uf305槳\ue7af尃\udac9傧쥻䞕㶔멲〴꺩❙鴓᯳醾\u0e5c蓷˾אַ熐\uefba",
                  1216004738
               ),
               a.c(-645264353, "ఒ疁ｗ愦\ueadc汙혍忯쇫䭀죰㊅밭◦ꯗ⤴鍼᳙虧њ觏\uf3ee絑\ue687擡\uea52口\uddc7䜿셬䫚됅㩙ꟈ↔ꭞᒃ黰᰿臯࿑畆ｦ磙\ue279氊톻嬆\ud928䋽쳵㘮뿬㦾ꌽⵠ鋁ဏ驽\u07b2贛\uf735烈\ufaea怹\ue9f0叛픥彽삵")
            )
            : (
               var7
                  ? wap.s(
                     a.b(
                        "ڢ缥\uf5fb殍\ue058曮\udcb4唘쭝䆠왺㰏닋⭦ꄨ➊鶍ቛ裰\u0ef6蝘ﴟ玶\ue832渋\ue4d3嵣팲䧆쾏䑫뫻ヵ\ua956⼘ꖳᩥ逅ᚓ꼖ս篇\uf19a瘷\uecea拄\udb1b出\ud7a4䱷숂㢚넡㜳귂⎟頨Ữ钎ഒ莩僚繄\uf408櫇\ue361头\udfd2喘쨯䃽욑㼆떬⮞ꁛ☍鲧ᕞ謄ǁ蟔ﰦ狸\ue885愐\ue7c2嶧퉙䠓캘䝿봛㏜ꡮ⸴꒵᪓鍖৪辺Ѐ稄\uf0ab楩\uef04斟\uda67倭",
                        1267599000
                     ),
                     a.c(
                        1844290076,
                        "Ꙟ\udff4唭쬤䂎옾硧\uf18c殰\ue105暩鲢ᘗ讼ǥ蜞㥋닸⡂꩸➗巊팜䣔캯䀒ﶾ珮\ued07潊\ue4f5ᩔ逓৪辺Ԋ뫜㓎鈩⮬ꗩ\udb19允훲䰯숮箍\uf528獫\uecd8拜頄ᆰ鏲ऍ荆㣳븮㑔귰⌷嵺\uda85哋쨅䎵蓮缘\uf54d櫴\ue025扗鮓ᕀ譡\u009a苗㰃떫⯐ꅤ✸壩홙䰚엊䍢酪盍\uec96橡\ue7a8ᧇ靷\u0cf0誠t븽㟘굺⬻ꃋ\ude93"
                     )
                  )
                  : (
                     var6
                        ? wap.s(
                           a.b(
                              "\u1979惬\uea38瑂ￊ祡썾䪆퓝广\ud9b0⏜굘㒡뻵㠜舄ඌ霩ᅢ飀\ue2d5汫\uf7b4熌\udb69䋮쳨嘀큐審ꔳ⼴뚇ペ멨ֳ迊॒邭\u1af9搕\uee4a榣\uf378結쒕举졶叵\uddd2✂꺲⣿눑㰟螬Ĥ譁ኊ鰺\ue639憝\uebda甘ﲮ䛿쀉䩗햺彲\ud962₉\uaa39㑱뾢㧑荧િ钋Ḁ顜\ue3e1洤\uf700纆\uf82b䉧춄垝텧墫",
                              1224677736
                           ),
                           a.d(
                              "嶨␁꺧パ뭴㧏莆ด遏᪁鴨挻\ue9f6灍﨔磿웒䤊ퟒ喙\udc6a\ua63a⢆덒㕐뾅ɚ갿\u16fc钷Ἆ\ue1d5殞\uf268瀢ﺂ䅟쬫䷼큗幩⃢꪿ⴏ랯㧓耇ે貉ፍ鴲揼\uea4a気\uf6e8磇쌆䖫쮺噳\udcdcꋨ╠꼻ㆌ례ɡ胨ત酷ᯖ鶭恨\ueec3炔ﭤ紼있丬퐿庑\ud8f4ꍆⶌ럙㸬뢘˂",
                              1796492818,
                              1224021962
                           )
                        )
                        : wap.s(
                           a.c(
                              -649613974,
                              "굿퓣師쁝䯃쵨睷ﺏ惔\uea76涹韕ᥑ肴ૻ谇㘍릝⌦ꕳⲀ囖\ud86c䏺엑伜\uf6a6磢\ue241摕\uefedᄶ魸ʈ蒟\u0e67놷㮈봚⓪껽퀍婃\uddbd䝱쥡炆喝籢\ue791槆錐᪬鲴ً衻㏰딠㽈ꚳ⠯剴헏徒센䢹\uf2eb琁\ufe6e懩\ueb29济钐Ḫ耷ஒ跄㝲뺽₂ꨚⱕ埻\ud936䌉쪑䰿"
                           ),
                           a.b(
                              "蓺ﵤ矋\ue9b3昕\ue0be庎흻䥛쎐䀡빍\u3097ꤤ⍰ꖀ῎逗ડ賽ē筎\uf1e7樲\uec31暜\udf51兾쮂䧆왢㢴닱⬄굔➟頷ቅ钓൝蜏ﶒ玢\uf464溷\ue0b6夛펨几쨪䁁몔㜿땴\u2ffdꆯᨑ鳍ᚳ謀ז羳\uf841爋\uece6敳\udf27姝폃䱾워䂉륗㏽궄♞ꀃ\u1afa錥വ蟎ƞ稶\uf4df溞\ue75c懹\udba9呝",
                              951943346
                           )
                        )
                  )
            )
      );
      var9 += 16.0F;
      this.ijr(
         var1,
         var2,
         var3,
         wap.s(a.b("Ҧ紳\uf7f4榈\ue25a擶\udea8", -498858768), a.c(1246535197, "騏\ue394椰\uf733粐諸䀁짼")),
         ijl(var4.quality()),
         var8,
         var9,
         var10,
         () -> ijj(var4, a.c(-557547567, "羪؝賝ኤ饴῎ꖊⰧ눧㢒뽕䔩쯻剗\ud809"), tiq.QUALITIES, var4.quality(), 1),
         () -> ijj(var4, a.c(885248157, "탦ꥑ⎑뷨㘸낂\u0ac6荫ᵫ韞မ\uea65撷ﴛ睅"), tiq.QUALITIES, var4.quality(), -1),
         wap.s(
            a.c(-1646320013, "☚徉핇䬡삳䙇ﰁ痯\uebbc愆\ue6ceᳬ鉷\u0bcf膘ݺ봩㊶ꡃ⸝\ua7ed\uddb7匓좜仯쑪緌\uf397楮\uef7a撅驗မ觡ྰ蔖"),
            a.d("‾妠퍶䵰욣䁯︩玵\ued98木\ue080Ẕ끷৲蟃Ŏ뭸㓓깨⠹ꗗ\udf8a唤컶䲗쉒篫\uf5bf漿\ue96a护", 694826851, 1192629075)
         )
      );
      var9 += 16.0F;
      this.ijr(
         var1,
         var2,
         var3,
         wap.s(a.b("ᅷ棭\ue22f籝\uf792焾쭴", 2008617278), a.d("\ue6a2鼇ᖣ诜", 471947178, 1095087405)),
         ijm(var4.size()),
         var8,
         var9,
         var10,
         () -> ijj(var4, a.b("｢蛕క鉬ᦼ鼆╂곯㋭롆㾆엨", 1161625370), tiq.SIZES, var4.size(), 1),
         () -> ijj(var4, a.b("耖說獡\ued18曈\ue072娶펛䶙윲䃲몜", 1350533230), tiq.SIZES, var4.size(), -1),
         wap.s(
            a.b("壝ⅇꮚ㗫븾㢘芙ଦ镲ῃ頑扷\uecf3甏～禲쏪䱾횉僝\ud93fꍻⶒ뙘な몳́赝ា釿ᨁ\ue483滊\uf727煩ﯟ䑛칧䢶턛孃", 198269110),
            a.b("ỉ杗\ued81率\uf854纓쓇䤯퍭妢\ude04⑾ꪪ㜅륇㾹藳\u0a55郢ᛎ鬬\ue569毞\uf002白ﳚ䕧콈喤힔尦ꊂ⣌넴㜕붤\u061c衲ຠ霛ᴵ掿\ue9e6湛\uf4f6绥쌩䦙쾯呻\uda72Ⓕꤞ⼼떻㯣", -999548192)
         )
      );
      var9 += 16.0F;
      this.ijq(
         var1,
         var2,
         var3,
         wap.s(a.d("\uf7c1蹔Ҝ髭ᄧ鞋ⶊꐷ㩡냓㜒촷䏯\uda51偐횺泻\ue325禊", -1990584004, 606269091), a.c(-981070867, "\u0fec癿ﳙ拒\ue90f澵헥屮숿䳢켪㕕뮅∸걵⪋郋ᬅ臉ߨ踝\uf440")),
         var4.mirror(),
         var8,
         var9,
         var10,
         () -> {
            var4.set(a.c(-211966549, "ꗑ\udc66嚦죟䌏억翱\uf65c桀\ue2f5攽齌ᆆ蠪"), !var4.mirror());
            var4.save();
         },
         wap.s(
            a.b("㥪䃲쨥呇\udf8c夠\ue320檓\uf4c1繫捻Ν贎ᒲ黺\u181cꉕⶓ뜽ㅪ뢜싐䰰\ud7a7凌\udb00抱\uecad瘟\uf04a篻蔡༦隑\u10c8驼□꿘⥚냱㫺䐈칅䧾팯崛\ue49c渱\ue873珧\ufdd0܄躦\u08e2", 1674983696),
            a.b("君ⷎꝢ㥩뛜㑳踯ߟ鶐ጼ铢溜\ue034秵\uf3a4畜켝䃄\uda72屔퇌꾅ℹ뻿㲚뙁\u0ff4膧᭚鴆ᚸ\uec77扜\ufbd2綂\uf731䣬욗䁞\uddfb垠⥜ꌏⓈ븑㐅规ͳ蔺ủ邟湛\ue3fd斣ｕ煳쫈䱤", 1914982402)
         )
      );
      return var9 + 16.0F;
   }

   void iit(DrawContext var1, float var2, float var3, tiq var4, float var5, float var6, float var7) {
      boolean var8 = var4.aura();
      boolean var9 = var4.mine();
      boolean var10 = var4.walk();
      tct var11 = tcz.job();
      boolean var12 = var11 != null && !var11.done && var11.profile == var4;
      float var13 = 18.0F;
      if (var12) {
         tmw var14 = var11.progress;
         float var15 = var14.epochs <= 0 ? 0.0F : Math.min(1.0F, (var14.epoch + (a.b("ㆨ䠒싌岻흤", 1634152910).equals(var14.phase) ? 1.0F : 0.5F)) / var14.epochs);
         float var16 = var7 - 56.0F;
         uut.round(var1, var5, var6 + 6.0F, var16, 6.0F, 3.0F, iov.track);
         uut.gradientH(var1, var5, var6 + 6.0F, Math.max(6.0F, var16 * var15), 6.0F, 3.0F, iov.accent(), iov.accent2());

         String var17 = switch (var14.phase) {
            case a.c(-335544366, "ﾲ蘆ೀ銤") -> wap.s(a.b("ἇ暡\uec76爂律置씴䲂튙堭\udfeb▏謟", -368238728), a.d("䖝㱓뛺⣹ꍐ\u218f鿈ᘽ衯˞蕻罴햰", 1032756526, -775234311));
            case a.d("ɇ篹\uf129潂\ue484", 1297481786, 860029467) -> wap.s(
               a.d("뷫쑙亄탰嬪\udd9c柆\uee70災\ufadb紎蝳হ逞ᩀ鲶⛰ꤵ㏕뗂㰡䙭죜區핫徦\ue618栌\uf2b8瓦ｖƝ诃㉰", -1946036247, 2013358668),
               a.c(-539488386, "\u0b53狥\uf835昷\uede3欧텲壽싌䱪쮾㇀뼐⛘곲⸛遌ᾒ脶\u0379誁\uf0da繢\ue5b9揌촋")
            );
            case a.c(-1415119186, "ﻉ蝨ඨ鏑᠁") -> wap.s(
                  a.c(387235986, "샪륒㎅귧☬ꂚᫎ錶മ蟆\u0003難璸\ued5b杘\ue1b0寵퐬亇종"), a.d("쉔믡ㄶꬤⓡꈩ᠀釾\u0fdf脎ˌ\uf8b7癥\uefd0文\ue37a崧", 1375153314, 866970276)
               )
               + (var14.epoch + 1)
               + a.b("〨", -2147143674)
               + var14.epochs;
            case a.d("䊵㬍뇜⾹", 1228418593, 1934388476), a.b("涡ᐆ默®", -2023985710) -> wap.s(
                  a.b("ꭾ틆堑왳䶸쬎煚\uf8a2暺\uec52殗釼Ἤ蛏ೋ訬の뾸┉ꍟ⪡傷", -835343612), a.b("揖ᩣ邴દ蔔Ϟ릇『긬⓯ꝟ", 1716676510)
               )
               + (var14.epoch + 1)
               + a.d("ኴ", -1541322962, -1504881228)
               + var14.epochs;
            case a.c(-1819083866, "﯀艺ࢤ雓ᴌ") -> wap.s(
               a.c(-725794218, "䈮㮔녊⼽ꓢ≑項ᇽ迥ԛ苉磶\uf674濞\ue590捷\ud938团찟䨙쏸릤㜐곃⪻ꁣ㦑"), a.b("両㟯뵂⌿꣯⸫鑷ᶇ螶च軄炥\ufa6f揝\ue982潿픷廿쀩䘃쿾뗗㬙ꃌʠ", -1760081401)
            );
            case a.d("枣ḓ铛ડ", -1376311180, -442478681) -> wap.s(
               a.d("ひ䧏쌉嵯횳倃\uea57掯ﶷ睾\uf0d5ફ葳ᶻ鞑ᄴ꭪⒦븙㡉놹쯿攏", 1802689158, 2040326798), a.b("틠ꭐ↉뿿㐥늗ࢶ腆᭷閤ሀ\ue87e曒｠甲\uf3c0䦌숾壵\udedc圤\u2d7aꎰ\u181e", 28694215)
            );
            case a.b("ਲ玌菱朮\uece3橉", -1367668142) -> wap.s(a.b("\ud97cꃂ⨖둠㾭뤇͕誣ᓵ븅", 1049418000), a.d("\uef65雓ᰊ艱ফ轠㕌벷⋪ꠥஞ", -164430388, -281340267));
            default -> wap.s(a.d("촹뒝㹑ꀬ⯰괉", 366773150, -1567732028), a.b("ꃗ\ud914叆췌䙮쓏", 942843036))
               + (var14.epoch + 1)
               + a.b("脋", 2035581221)
               + var14.epochs
               + a.c(-309641056, "䂅㤴데ⶖꙁ")
               + wap.s(a.b("몕쌣䧭힇屃\udae7悵\ue90a", -2083865867), a.d("\ue9c2遾\u1ad3蓚༂覺㏪멤⁙", -1747570440, -2022253312))
               + var14.horizon;
         };
         irr.SMALL.draw(var1, var17, var5, irr.SMALL.centerTop(var6 + 17.0F), iov.textDim);
         float var40 = var5 + var7 - 50.0F;
         boolean var42 = irr.inside(var2, var3, var40, var6, 50.0F, var13);
         irr.secondaryButton(
            var1, wap.s(a.c(-1171372214, "䜏㺜둀⨼ꇭ❕"), a.c(361281513, "돱쨜䂱\udec9唖펪")), vhz.CLOSE, var40, var6, 50.0F, var13, var42 ? 1.0F : 0.0F, 0.0F
         );
         this.ihc.add(new ige(var40, var6, 50.0F, var13, tcz::cancelTraining, null));
         var6 += 24.0F;
         this.ijt(var1, var14.curve, var5, var6, var7, 16.0F);
         var6 += 20.0F;
      } else {
         boolean var31 = tcz.training();
         boolean var35 = irr.inside(var2, var3, var5, var6, var7, var13);
         if (var31) {
            irr.secondaryButton(
               var1,
               wap.s(a.c(-1810833605, "\udf61\ua6ffⰭ뉇㦌뼰մ賗ዘ顫ᾥ\ue5dd欅\uf2b1磫﹟䑙쮒兲흷庆Ⓞꩿㆩ럑㴇蒽"), a.c(-418475463, "阿\uefa1攀ﭵ烕\uf661䱅얷實픸囿곺∮믯ㆱ띇ऑ苟᠓鸼ឱ涜\ue32c碊")),
               vhz.CLOCK,
               var5,
               var6,
               var7,
               var13,
               0.0F,
               0.0F
            );
         } else {
            irr.primaryButton(
               var1, wap.s(a.b("ᱢ旵\uef35煌煮", -1861870541), a.c(-1321525188, "␥嶻휚䥯싇䐌﹑")), vhz.REFRESH, var5, var6, var7, var13, var35 ? 1.0F : 0.0F, 0.0F
            );
            this.ihc.add(new ige(var5, var6, var7, var13, () -> {
               tcz.train(var4);
               this.ihs = null;
            }, null));
            if (var35) {
               this.iho = wap.s(
                  a.d("箮ȹ裹 鵐᯼ꇼ⡄똜㳣뭤䄉쿓嘧\udc36嫄\ue089潐\uf5ef玫敏耊ຢ镹ፎ馓⁹긾㓓닗㤧쟴䶴퐋刓\ud8ac杻\ued1f殜\uf27d砾ۂ貉ନ釸ᾀ", -2049461, 1375322527),
                  a.d("䶿㐡뺀\u20f5ꭕⷡ韅ḷ聦ຸ赹猚囹恢\uea32泋튝嵀쏯䖼챃똙㢩Ꝧ━꿛ᘛ頺ʿ蓠ି\uf1fa箱\ue24b摯\ueeda兰", 2030040809, 247644013)
               );
            }
         }

         var6 += var13 + 6.0F;
         if (var11 != null && var11.done && var11.profile == var4 && var11.error != null && !a.c(787047196, "捹᫊逖\u0e6a薻̃").equals(var11.error)) {
            irr.SMALL
               .draw(var1, irr.SMALL.ellipsize(iid(var11.error, var11.aura, var11.mine, var11.walk), var7), var5, irr.SMALL.centerTop(var6 + 4.0F), -1750963);
            var6 += 12.0F;
         }
      }

      if (var10) {
         float var34 = var6 + 2.0F;
         var6 = this.ijn(var1, wap.s(a.b("␈嶏흑䤧싲䑄\ufe1e瞨\ue9ba按\ue4d1ạ避", 1892951122), a.c(-1205892081, "蠞\uf18d答\ue524滽\ue83b嘄\udb90䖴켏䢤늨㰅")), var5, var34);
         this.iiz(var1, var2, var3, var4, var5 + var7, var34 + 5.0F);
         if (this.ihg) {
            this.ija(var1, var2, var3, var4, var5, var6, var7);
         } else {
            this.iio(var1, var2, var3, var4, var5, var6, var7);
         }
      } else if (var9) {
         float var33 = var6 + 2.0F;
         var6 = this.ijn(var1, wap.s(a.c(1596907526, "\ue041駔ጀ赺ۨ耔㩅뎿ⷡꝙ"), a.d("付㝋붒⏢\ua83b\u2efd郂ᵛ荼স蹬琔", 367014970, -1121026318)), var5, var33);
         this.iiz(var1, var2, var3, var4, var5 + var7, var33 + 5.0F);
         if (this.ihg) {
            this.ija(var1, var2, var3, var4, var5, var6, var7);
         } else {
            this.iiv(var1, var2, var3, var4, var5, var6, var7);
         }
      } else {
         float var32 = var6 + 2.0F;
         var6 = this.ijn(
            var1,
            var8
               ? wap.s(a.c(-866030307, "浖ᓓ鸇e诳ഏ띞㺤ꃺ⩂"), a.b("鹑\ue7c2洛\uf36b碲ﹴ䁋춪历\ud934廬", 1300208198))
               : wap.s(a.d("쀾릭㍵괅⛛", 1636910534, 1297778096), a.b("ㅒ䣁수屨ힱ具", -596232888)),
            var5,
            var32
         );
         this.iiz(var1, var2, var3, var4, var5 + var7, var32 + 5.0F);
         if (this.ihg) {
            this.ija(var1, var2, var3, var4, var5, var6, var7);
         } else {
            tck var36 = var4.model(var8);
            if (var36 == null) {
               irr.LABEL
                  .draw(
                     var1,
                     wap.s(a.d("妡‱\uaaf9㓜뽟㧨莨ੑ鐉ẳ饡捔\uedda瑷︵", 25745971, -1942191149), a.b("嵧⒊깁㑁뮋㴲荴ປ郋ᨈ鷟柜\ue903炿", -1606854276)),
                     var5,
                     irr.LABEL.centerTop(var6 + 6.0F),
                     iov.textMuted
                  );
               var6 += 16.0F;
               String var38 = var8
                  ? wap.s(
                     a.b("冁⠟ꋂ㲼띷㆒讒ɤ鰮ᚐ酉欯\ue5ab簒\uf62d热쪲䕪\udf95始퀳ꨑ⒅뽒㤾돨\u0a58葅ẻ颬\u1316\uedda柇︥塖\uf2c1䴃윿䇨\ud85e刚⳪ꚨℏ뮇㗺豽ې肒ᭈ镵濰\ue641怃\ufaf8璮", 1486705151),
                     a.c(-473276067, "敾ᳮ阷ࡇ菥Ԭ뼆㛺곉∙ꖵ寚텬䣞싺䐃﹅熐\ueb2f浺\ue095髌၃诅ප蜓㻗듪⸒ꡌ⟾\ud94c匁쪅䳚옖綬\uf7d4焔종拼ᰘ鉗ᗢ輰Ŀ룭㘲끱⾿ꇍ孠튫哸쨗䁘ﯨ絋\uf73c溒")
                  )
                  : wap.s(
                     a.b("沽ᔻ鿮Ɠ詙\u0cfe뛩㼋腴⯣갥嘙\ud8ca䅼쬴䷄\uf79a硝\ue2bd撣\ued55靊ᦪ艼Ж軈㝱뤷⎟ꗂ⸥탨媪썐䕍쾨灹福糀\ue576", -858428217),
                     a.b("뎻쨭䃱\ude87唠폡涪\ue448娷\uf0a0睦褋ߘ鹬ᑁ銱ⲜꝐ㷮뾯㈹䡫욯嵶\udb00凕\ue813戫\uf8d0窞\uf12cཱྀ薲᱁鸎Ⴁ꽹╺ꎭ㩣", 169523076)
                  );
               irr.SMALL.draw(var1, irr.SMALL.ellipsize(var38, var7), var5, irr.SMALL.centerTop(var6 + 4.0F), iov.textMuted);
            } else if (var8) {
               this.iiu(var1, var2, var3, var4, var36, var5, var6, var7);
            } else {
               String var37 = new SimpleDateFormat(a.d("괅풴席쀿䯨촴眏\ufefe惓\uea35淦", 1922382964, 1240699166), Locale.ROOT).format(new Date(var36.created));
               irr.LABEL
                  .draw(
                     var1,
                     wap.s(a.b("️螄\u0d53錦ᣴ鹈␈귢㎠뤜㺖", -1925513641), a.c(-1020402257, "\ue187顒ዺ貁ܣ膑㮲뉏⠎"))
                        + Math.round(var36.similarity)
                        + a.b("\uf357", -1877740685),
                     var5,
                     irr.LABEL.centerTop(var6 + 6.0F),
                     iov.text
                  );
               irr.SMALL
                  .drawRight(
                     var1,
                     var37 + a.c(332999207, "⨂厳\ud9f7䜑쳆") + var36.hits + wap.s(a.c(-756912217, "澂ᙻ鲩˅褕"), a.d("쓇뤕㎱\ua9da", -502749969, 1684693004)),
                     var5 + var7,
                     irr.SMALL.centerTop(var6 + 6.0F),
                     iov.textMuted
                  );
               var6 += 15.0F;
               this.ijp(
                  var1,
                  wap.s(a.d("盈ཌ薛ᯠ遼\u169e곎┪뭵㇅", 34652988, -1552566866), a.c(705397090, "蕱ﳧ瘶\uec5d揫\ue521彶훹䣘숖䗆뿍")),
                  ijw(var36.userPeak) + a.d("蒌ﴲ矮", -1957409845, -1958949020) + ijw(var36.modelPeak) + a.d("꣄", 1893359900, -1030698647),
                  var5,
                  var6,
                  var7
               );
               var6 += 12.0F;
               this.ijp(
                  var1,
                  wap.s(a.d("\uf523貯ٸ頁᎓镶⼾Ꚁ㢋눯㗯쾋䅞\ud8fe", -1201795939, 13171172), a.b("㘻俘앾嬆킢剼\uec32旎ﮓ焥\uf6f7ಇ艘ᯬ釈", -775409114)),
                  ijw(var36.userEntry)
                     + a.d("\udaf4ꍊ⦖", -401633876, -1441245317)
                     + ijw(var36.modelEntry)
                     + wap.s(a.d("쀍맨", -1658048343, 1239412870), a.d("\ueaf3霠", 1203149270, 1068528391)),
                  var5,
                  var6,
                  var7
               );
               var6 += 12.0F;
               this.ijp(
                  var1,
                  wap.s(a.b("矧\u0e6f蒯᫉鄟឵귡␐메モ", 219314082), a.d("窌̗覱឵鱬᪷ꃷ⤏", -1587328061, 2049455448)),
                  Math.round(var36.overshootUser * 100.0) + a.c(-325196964, "\ue37d髉ပ蹫") + Math.round(var36.overshootModel * 100.0) + a.c(-60969966, "갶"),
                  var5,
                  var6,
                  var7
               );
               var6 += 12.0F;
               if (var36.axes.length >= 21) {
                  this.ijp(
                     var1,
                     wap.s(a.d("➅帎퓙䪬셾䟂ﶂ瑨\uea2a悖\ue71cᴕ鎺\u0a04聘ې", 1317615994, -545775940), a.b("깿\ud7aa崂썹䣛칩瑊ﶷ柶\ued3f檔郪Ḳ蟺", 1245817424)),
                     ijd(var36.axisScore(0)) + a.b("썖뫨〴", -1027226763) + ijd(var36.axisScore(1)),
                     var5,
                     var6,
                     var7
                  );
                  var6 += 12.0F;
               }

               irr.SMALL
                  .draw(
                     var1,
                     wap.s(a.b("ￛ虼ವ銑᥉鿷◩갚㉎룾㼤", 193200041), a.c(-90796519, "詐\uf3e8結\ue32e棶\uea5b倊\ud9f1䞯촐䪴")),
                     var5,
                     irr.SMALL.centerTop(var6 + 4.0F),
                     iov.textMuted
                  );
               var6 += 12.0F;
               boolean var39 = lfa.activeProfile() == var4;
               boolean var41 = irr.inside(var2, var3, var5, var6, var7, var13);
               if (var39) {
                  irr.secondaryButton(var1, wap.s(a.b("쓥뵳㟮꧊∛꒼", 2933930), a.c(-14062185, "榃ၫ髆Ҷ轤ঢ뎊㨏ꐦ⻠ꤰ协")), vhz.CHECK, var5, var6, var7, var13, 0.0F, 0.0F);
               } else {
                  irr.primaryButton(
                     var1,
                     wap.s(a.c(-1920658571, "ጣ檴\ue071"), a.d("\uebeb鈃\u18ae蛞ഌ诊㇢렚♉곺⭛턤", -1373156965, 566601316)),
                     vhz.CHECK,
                     var5,
                     var6,
                     var7,
                     var13,
                     var41 ? 1.0F : 0.0F,
                     0.0F
                  );
                  this.ihc.add(new ige(var5, var6, var7, var13, () -> lfa.activate(var4), null));
                  if (var41) {
                     this.iho = wap.s(
                        a.d(
                           "섥뢠㉲갘⟭ꅸᬬ鋖ೀ虽Ǐﮊ畜\uecf6暏\ue055娐햅佷줩䃔㫁됓⿶ꦈ⍂髉ᒮ蹊ࠍ莿絥\uf764滁\ue893戥\uddee埑텕䣺슸뱕㙎놶⭼ꕙ᳝陳ွ诩֓＇盞\uf0a4橇\ue411徳\ud95f匑쫛䑹㸽맓㎄굊⒵麯ᡄ鉀\u0dbe蝬",
                           1196539074,
                           1127841249
                        ),
                        a.c(
                           2096662482,
                           "蟗﹒璀\ueaea感\ue78a州퐤䨲삏䜽뵸㎮ꨄ⁽ꚧ᳢鍷ො辕\u0603籦\uf2d4椞\uef59斾\udc1e剙좯仵씈㿃뗶Ⰴ꩖⃪鼰ᄣ鏨\u0a5d萒\ufaef璣\uf313槀\ue7bb婸퓛劜쥌䝊붒㐳눎Ⳡꋟ᥋龊ᗾ谲ʸ磔＼畸\ueba2戎\ud85b庫"
                        )
                     );
                  }
               }
            }
         }
      }
   }

   void iiu(DrawContext var1, float var2, float var3, tiq var4, tck var5, float var6, float var7, float var8) {
      String var9 = new SimpleDateFormat(a.b("萮ﶟ眆\ue914拃\ue41f帤ퟕ䧸쌞䓍", 714703937), Locale.ROOT).format(new Date(var5.created));
      irr.LABEL
         .draw(
            var1,
            wap.s(a.c(-1525810970, "\uf8be脵\u0be2閗ṅ飹⊹ꭓ㔑뾭㠧"), a.b("遙\ue98c挤ﵟ盽\uf04f䩬쎑姐", -175008655)) + Math.round(var5.similarity) + a.b("Ꮙ", -2094328851),
            var6,
            irr.LABEL.centerTop(var7 + 6.0F),
            iov.text
         );
      irr.SMALL
         .drawRight(
            var1, var9 + a.d("ᖹ氈\ue64c碪\uf37d", -962245186, 611342370) + ijv(var5.steps / 20), var6 + var8, irr.SMALL.centerTop(var7 + 6.0F), iov.textMuted
         );
      var7 += 15.0F;
      if (var5.axes.length >= 21) {
         this.ijc(
            var1,
            a.d("ᛵ", -859179266, 1370808402),
            wap.s(a.d("\uedd9鑰ẵ", 1299345056, 1178501891), a.d("⧁偱\udebc䓞켄䧋\uf3e0稞\ue448滺\ue956ፕ鶉л", -1001090146, -2084389266)),
            var5.axisScore(0),
            var5.axisScore(2),
            var6,
            var7,
            var8
         );
         var7 += 12.0F;
         this.ijc(
            var1,
            a.b("ꎏ", -1510169641),
            wap.s(a.d("汽ᗕ鼛Ž誡", 936968239, -783389657), a.c(1074416940, "䤟ク빢␁꿑⤕鍄\u1acf蒒ษ觱玃")),
            var5.axisScore(1),
            var5.axisScore(3),
            var6,
            var7,
            var8
         );
         var7 += 13.0F;
         String[] var10 = new String[]{
            wap.s(a.b("ᢄ愔\uebce疧﹥碕싎䭤픸徜\ud84f∿겥", -918284083), a.b("暥ἵ门௮耷۴뢷ㅎꭸ↲ꙥ屪틃䬍셝䞢麗", -163159392)),
            wap.s(a.b("\u000e禝\uf34e洹\ue6e7恟\uda1b叹춳䜟샊㪺", -1061748669), a.c(162241702, "颌\ue15f毷\uf582縫\uf8ef䊴쭀唒")),
            wap.s(a.c(-370200691, "⿃噝\udc99䋱"), a.d("\uec76閬ἆ腻ન", -1226949723, -837233674)),
            wap.s(a.b("\ue76c黵ᐢ訞ƌ蜪㵹뒕⫗", -2055805148), a.b("\ue1b1顖ድ貍ݑ自㾩뉇Ⱨꚮ℃\udb01嗘챢", 2137187745)),
            wap.s(a.d("륌샃䨒푣徯\ud902捗\ueaad瓤﹕", -1349898096, 1178175877), a.c(1877222170, "✌庙푁䨲쇪䝘ﵴ璆\uead7")),
            wap.s(a.c(762737251, "爦ம腮Ἀ铞ቴꠠ⇑뾕㔣"), a.d("힓금⒮몪ㅳ램෨萐", -1949673771, -1046313647))
         };

         for (int var11 = 0; var11 < 6; var11++) {
            this.ijp(
               var1,
               var10[var11],
               a.d("\uf7ad蹤", 1914156840, -660979489) + ijd(var5.axisScore(4 + var11)) + a.c(684739161, "䩼㏍뤞✖겸") + ijd(var5.axisScore(10 + var11)),
               var6,
               var7,
               var8
            );
            var7 += 11.0F;
         }

         this.ijp(
            var1,
            wap.s(
               a.b("\ud934ꂼ⩼됚㿌륦̲諃ᒇ鸱ᦱ\ue3cf洗\uf4b7绥\uf814䉋췎坠턻壄⊍걡㞼놚㭝苴\u0cf0隐ၖ鮨敻\uef3f盏\uf095", -2112759464),
               a.c(1698091578, "혻꾠┆묂ホ똀ీ薸ᾌ鄠\u16fe\ue89f晙￩疺\uf35b䵶웉屶\ude45垻⦁ꞥ㳣뺀㑓跪κ饃ὥ")
            ),
            ijw(var5.axisScore(16)) + a.b("듻췝䞙", 806139096) + ijw(var5.axisScore(17)),
            var6,
            var7,
            var8
         );
         var7 += 11.0F;
         double var24 = var5.axisScore(20);
         this.ijp(
            var1,
            wap.s(a.c(-473149712, "亽㜻뷬⎟ꡟ⻳钦ᵖ荋৶蹤琝龜挲\ue931濟햖婀샩䚿켗땊㮭ꁧ☇겆ᕦ鬴ǖ螇వ"), a.d("\ue6cb齯ᖹ诂i蚦㲂널⽃ꆐ☿\udc37劝쬮䕩쎔緇\uf21a梣\uee89挑᥎鎜࠶蹍Ӣ봯㌁꧵⾪", 2066553507, -3082154)),
            (
                  Double.isNaN(var24)
                     ? a.d("빀", 782033448, -197755779)
                     : Math.round(var24 * 50.0) + wap.s(a.d("诎\uf232磿", -1692441948, -515249847), a.d("䃹㵔럺", -1694059114, -1071450804))
               )
               + a.d("踼\uf71a絞", 87971415, 8247368)
               + (var5.ownAim() ? wap.s(a.c(-1396352263, "媅⌢ꧫ㞝뱋"), a.d("\ud9aeꁯ⪰듇", -39509654, -31720318)) : a.b("뷰", 442015205))
               + a.c(871674103, "냔짲䎶")
               + (
                  var5.turnCap > 0.0F
                     ? Math.round(var5.turnCap) + a.d("仹㟗", -90679721, 992286748) + wap.s(a.d("т", -1579685006, -1672876219), a.c(1694679263, "쒜"))
                     : a.c(-1170564793, "륒")
               ),
            var6,
            var7,
            var8
         );
         var7 += 11.0F;
         irr.SMALL
            .draw(
               var1,
               irr.SMALL
                  .ellipsize(
                     wap.s(
                        a.b("ꢊ턺宧얐么죷犫צּ攞\ueffc桦鈊\u1c89蕶༮觌㎐뱖⚷ꂵ⥐北\uddf3䚵쁝䫏\uf37a紧\ue7d5憁\uea35ᓭ黥܉腇ய둮㸅뢃Ⅴꬾ햜徖\ud831䋼", -1949980472),
                        a.c(-958360717, "靡\ueedd怞奄熦\uf766䴿삧廴큟垈궅⌮뫡ス뙆\u086c莠ᤛ魟ᚺ泡\ue25e禎\uffff甥좆䙀\udc20幮헜⭱ꅂ㢶뻠㑕辘״茺ứ钿\uee25搠\ue394礐\uf303䫙")
                     ),
                     var8
                  ),
               var6,
               irr.SMALL.centerTop(var7 + 4.0F),
               iov.textMuted
            );
         var7 += 13.0F;
      } else {
         irr.SMALL
            .draw(
               var1,
               irr.SMALL
                  .ellipsize(
                     wap.s(
                        a.c(-1238740512, "冓⠁ꋚ㳯띵㇆讞ɮ鰸ᛟ鄖欵\ue5f5籕\uf600烢쪥䕳\udf8e妙큧ꨫⓊ뽂㤫돠\u0a54著Ỳ颴ጃ\uedd0枈﹤砱\uf281䴔읩䇻\ud842则ⲥꚦ℈믙㖯豦ې胀ᬝ锡濩\ue64d怋\ufaf9璳켋䧚쎲婤"),
                        a.c(-2120926882, "㵁䒓츲倳\udb94嵚\ue366溋\uf0d6穭ﶿ߀襠ᒧ黮ᰀꙅ⧡댧㕽벅욦䠑펿凘\ufb3d抺\ue8fa牿\uf459羝腍འ鋳ᓐ鹭↼꿕ⵦ뒢㻸䀃쨬䷣흃嵑\ue48e橝\uec6e矆杻̛躸ࣥ阉ᡒꎘ┼꽁㛺롞숆")
                     ),
                     var8
                  ),
               var6,
               irr.SMALL.centerTop(var7 + 4.0F),
               -1727155
            );
         var7 += 13.0F;
      }

      float var23 = 18.0F;
      float var25 = (var8 - 6.0F) * 0.5F;
      boolean var12 = kwf.usesStudio(var4);
      boolean var13 = irr.inside(var2, var3, var6, var7, var25, var23);
      if (var12) {
         irr.secondaryButton(
            var1, wap.s(a.d("䣏ㅙ믄◞긫⢟鋌ᬐ蕻\u0fcd蠍", 849321226, 992925063), a.c(-718933591, "\uf5b1蠲ʊ鳙ᜋ醺⯄ꈁ㱙뛻")), vhz.CHECK, var6, var7, var25, var23, 0.0F, 0.0F
         );
      } else {
         irr.primaryButton(
            var1,
            wap.s(a.b("ꬋ튜塙왭䷳쭅煘\uf8c2暿\uec0b毘醄ὧ蛑\u0c91", 790080337), a.c(463568266, "禒Б躩ჺ鬨ᶙ\ua7e7⸢끺㫘")),
            vhz.CHECK,
            var6,
            var7,
            var25,
            var23,
            var13 ? 1.0F : 0.0F,
            0.0F
         );
         this.ihc.add(new ige(var6, var7, var25, var23, () -> kwf.useStudio(var4), null));
         if (var13) {
            this.iho = wap.s(
               a.d("蛰｣疵\uebc4怾\ue6bb峯픍䬓쇶䘤뱒㊙ꬵℵꞓ᷂鈎ࢡ躸ܛ絖\uf3e4栯\uee03撟\udd2e却즂俚쐥㪽냵⤙꽍◭騾၊雝༣蕵﯂燡\uf672沸\ue2c0嬜톨埮챺䈘", 1007212306, -1918283366),
               a.c(-266210480, "\uf32f誼j鸛ᗡ鍤⤰ꃒ㻌끬㟍췋䌝\udadb哪혁水\ue3e6祔ｿ盲ಭ虲\u19ce龾ᔓ겧⛯렄㹗뗮䬾셿壹\udea8偷\uebb2懍\ue717绒\uf48e訃ю蟀ᵈ鍇⫮ꀣ♯뷊㟖촖")
            );
         }
      }

      float var14 = var6 + var25 + 6.0F;
      boolean var15 = tcz.mode() == tcw.TEST && tcz.sessionProfile() == var4;
      boolean var16 = irr.inside(var2, var3, var14, var7, var25, var23);
      irr.secondaryButton(
         var1,
         var15
            ? wap.s(a.c(799418159, "❵廣퐫䩅쇂䜧ﵥ璂\ueada"), a.c(-1937424961, "㦔䁆쫩咙\udb51如\ue3a6樣\uf47f纼"))
            : wap.s(a.b("흪껪\u242f멙㇚뜤൶蓉᫅遳឵\uedcb挖練", 676583216), a.c(178939321, "憔ᠲ銕೧荒Ǿ뮠㙁걿⛍ꅩ嬐헎䱻왝")),
         var15 ? vhz.PAUSE : vhz.PLAY,
         var14,
         var7,
         var25,
         var23,
         var16 ? 1.0F : 0.0F,
         0.0F
      );
      this.ihc.add(new ige(var14, var7, var25, var23, () -> {
         if (var15) {
            tcz.stop();
         } else {
            kwf.useStudio(var4);
            kfe var3x = Flow.getInstance().getModuleManager().getByName(a.b("㋷䭤솲心퐹劼\ue8e8愊", 1777349300));
            if (var3x != null && !var3x.isEnabled()) {
               var3x.setEnabled(true);
            }

            tcz.startTest(var4);
            this.close();
            if (this.iht != null) {
               this.iht.close();
            }
         }
      }, null));
      if (var16) {
         this.iho = wap.s(
            a.c(1638427405, "武ደ頶و趕ଳ넳㢁ꛒⱡꮺ冎\udf16䚽쳯䩊\uf044羚\ue523挶\ueaaa郙ṯ薾Ϭ褉ソ뻿⑉ꉞ⧢휽嵽쒐䋄젦瞥\ufdc8笖\ue2af梽ᘛ鱖\u1bfa脱༈뚏㰢멬↧꾇唛\udcae嫴쀆乞"),
            a.d("\uf6a0轈ש鮕ဵ隅⢴ꔤ㭸놾㙥찝䊵\udf63唼펦構\ue61f粬𢡄猓ॅ蟥ᱵ鸛ᒸ굼⌬리㮟됽䫥샐夯\udf71嗎\uee76恦\ue2d4罸\uf522诗ƀ舩Დ鋭⭂ꇴ⎢뱯㈞죅䅳윬嶨폻", -895036441, -9690771)
         );
      }
   }

   void iiv(DrawContext var1, float var2, float var3, tiq var4, float var5, float var6, float var7) {
      ttb var8 = var4.mineModel();
      if (var8 == null) {
         boolean var27 = a.b("먨쎚䥁", -109462972).equals(var4.mineIssue());
         irr.LABEL
            .draw(
               var1,
               var27
                  ? wap.s(a.b("훎꽜▇뮲〨뚛ೃ蔳᭥醂ᙋ\uec6e抿יִ煆\uf7b0䶱숡墔\udec3圼\u2d6a", -1400056169), a.c(-357345062, "峠┲꾓㆒먵㳻苇༪酷ᯌ鰞晡\ue8c1甆ｏ綠쟠䡃틴哚\ud935ꝳ⧇눛㑧뺺܅"))
                  : wap.s(a.c(-1041252721, "뻎읞䶖펳堰\ude87擇\ued3e獦隆縎萻વ錘ᥚ"), a.b("䏂㨯냤⫤ꔮ⎗鷑ှ蹮ҭ荺祹\uf7a6渚", -1303820327)),
               var5,
               irr.LABEL.centerTop(var6 + 6.0F),
               iov.textMuted
            );
         var6 += 16.0F;
         irr.SMALL
            .draw(
               var1,
               irr.SMALL
                  .ellipsize(
                     wap.s(
                        a.b("뺣윶䷢페堊\udefa擨\ued54猏惡繡葕\u0adb鍼ᤵ鿃▍ꩊヰ뚫㼚䔍쮷偻홖岒씇歴\uf182矃ﰽ˨袠ᅊ霘ᶸꉹ⡗꺈㝭봮쏒䦊칵哶\uda81捁\ue9f8澰", -2062762273),
                        a.d("囱⽡ꖶ㯃뀕㚫賱ę鬮ᇧ陁氷\ue2e1缳\uf101瞁췂䘏\udca9竞팋\ua95b⟸렵㹎뒚ൗ茇ᶞ鯃ᑯ\ueabf悌更罐\uf1fd䨴쁊䛫\udf5e啾", -772146821, -900879428)
                     ),
                     var7
                  ),
               var5,
               irr.SMALL.centerTop(var6 + 4.0F),
               iov.textMuted
            );
      } else {
         String var9 = new SimpleDateFormat(a.d("ꙿ\udfce啗쭅䂒왎籵\uf584殩\ue14f暜", 785467307, -690167365), Locale.ROOT).format(new Date(var8.created));
         irr.LABEL
            .draw(
               var1,
               wap.s(a.b("㺺䜲췫厒\ud85d庿\ue4a0浔\uf309禶︠Ј諉።饤", -1829880091), a.d("칰래㴱ꍏ⣦\uaa37ᑾ鶅ϐ赻໋\uf0d9穬\ue3aa槽\uef72兒", 443686884, 1163187607))
                  + Math.round(var8.top1)
                  + a.d("⤦", -1367214904, -646193718),
               var5,
               irr.LABEL.centerTop(var6 + 6.0F),
               var8.top1 > var8.base1 + 5.0 ? iov.accent() : iov.text
            );
         irr.SMALL
            .drawRight(
               var1,
               var9 + a.b("\ue65d鿬ᖨ譎\u0099", 220456568) + var8.events + wap.s(a.b("\ue296魷ᆽ迆Й芰", 1457644208), a.d("ꨭ\ud7fc嵚썖䳧", -1599955923, 2007971365)),
               var5 + var7,
               irr.SMALL.centerTop(var6 + 6.0F),
               iov.textMuted
            );
         var6 += 15.0F;
         tvq var10 = var8.style;
         this.ijp(
            var1,
            wap.s(a.c(1517859111, "녫죡䈭\udc0c埈텪殮\ue2c8糝\uf673熦诐Փ鲶\u16f9逅⨏ꖐ㼨륽゙䫟쑺徬"), a.b("毃ቮ颼˟褖ྴ땰㰖ꙖⲘꬵ儻\udfef䘢졯䪏\uf0ca缘\ue5a5揲\uea0c逬ữ蔿", 1908502521)),
            ijd(var8.top3) + a.b("턖꠰≴", 1367855413) + ijd(var8.base1),
            var5,
            var6,
            var7
         );
         var6 += 12.0F;
         this.ijp(
            var1,
            wap.s(
               a.b("ዼ死\ue1a5翓\uf41c狾죡䄕\udf48嗷퉡⡉Ꚉ㼣딥㍃覛؟鲪\u1afd錞\ue942枽ﰡ穜\uf094䤴", 2127565488),
               a.d("쐾붔㝍ꥄ⋮ꑞ\u1a1d韶ণ茘Ñﻃ瑷\ue9a4掀\ue575彄퓺仞젘䗱㾯녦⪻겾♬", -100957715, -930266644)
            ),
            var8.legs == null
               ? wap.s(a.b("巩\u245b꺚ゼ묯㶛蟝ู", -299147897), a.d("葞\ufde3眻\ue94f暆\ue423年히䧗쌐䓍", 205198078, -2126867817))
               : ijd(var8.legsAcc) + a.d("ꡬ텊嬎", 654358248, 570171047) + ijd(var8.legsBase),
            var5,
            var6,
            var7
         );
         var6 += 12.0F;
         this.ijp(
            var1,
            wap.s(
               a.b("껽흥嶹쏂䡑칷璳ﴍ捋\ue9e9渭鑝᪑茧ॴ辞㗖메₾\ua6f9⼔唐\udbac䁲와䲓\uf52b筻\ue185", -1807569240),
               a.d("\uee9b靉ᷣ莘\u0c5f詹ソ뵓⌆꧂\u2e64퐛媦쌄䥞쯄痩僧擩\ue2b7歏ᔂ鮳h蘖\u0cc9딍", -231409272, -340258008)
            ),
            Math.round(var8.hand.similarity)
               + a.c(1839032658, "楳Ⴧ骃ѥ")
               + Math.round(var8.hand.overshootUser * 100.0)
               + a.c(-281004273, "㜮亚쑆娸")
               + Math.round(var8.hand.overshootModel * 100.0)
               + a.c(-214381563, "찡"),
            var5,
            var6,
            var7
         );
         var6 += 12.0F;
         this.ijp(
            var1,
            wap.s(a.c(-149377262, "꽝훚尓숷䦦켐畐ﲾ抬\ue84a澆闶ᬤ芜ࢊ踬㑻뮷ℝꝎ⺾哦"), a.c(-1345077492, "물슝䡂혴姺\udb2f愈\ue889皪\uf807篆薥༒雓ᲁ驿⁌꿪")),
            Math.round(var10.activeRate)
               + wap.s(a.b("㻃䜰췭叟\ud84a廿\ue4ab洔\uf3dc秺", 1578450665), a.d("΅扎\ue897狲ﴶ箃쇕䰹틱壗", -1659909765, 1975047871))
               + ijw(var10.activeDia)
               + wap.s(a.c(-929178004, "\ude48ꞽⵣ댚"), a.c(564916801, "\uf265迄Ԝ魪")),
            var5,
            var6,
            var7
         );
         var6 += 12.0F;
         toq var11 = nfl.neuroBrain();
         double var12 = var11 != null && var11.model == var8 ? var11.rate() : -1.0;
         String var14 = var12 < 0.0
            ? wap.s(a.c(-1593790030, "뇒졢䊪\udc8f圕토毴\ue202籚\uf6e2煶譞֕鰵"), a.b("兂⢏ꉄ㡄랎ㄷ轱ʚ鳁ᙱ醭毗", -99527301))
            : Math.round(var12)
               + wap.s(a.d("⟟帬퓱䫃셖䟣ﶷ", 1163230869, -162571923), a.b("샪뵊㞓귶∲ꒇố", -930496307))
               + (
                  var10.activeRate > 0.0F
                     ? a.b("鞫\uee12", 259823497)
                        + (var12 >= var10.activeRate ? a.c(-31107558, "嘰") : "")
                        + Math.round((var12 / var10.activeRate - 1.0) * 100.0)
                        + a.c(-262667615, "ʆ笻")
                     : ""
               );
         this.ijp(var1, wap.s(a.d("혙꾅╍뭨ヱ뙁ఊ", 1786752846, 875395346), a.c(-884013130, "έ稳\uf09c檏\ue539揼\ud9a3倬츄䓄")), var14, var5, var6, var7);
         var6 += 12.0F;
         this.ijp(
            var1,
            wap.s(
               a.d("췷둱㺦ꃕ⬕궹\u17ec鸜\r訫൯\uf758禅\ue031橨\uec91嚕\ud9d3䏷엵䰁㙒룺⌬ꕉ", -366178488, -1193655564),
               a.c(-1363358810, "쾑똵㳣ꊘ⤳꿼ᗘ顆ڎ貨༟\uf511篅\ue276氿\uea59傁\udb31䇼쟒九㐉뫅")
            ),
            (var10.reactionMs > 0 ? var10.reactionMs + wap.s(a.d("䓹㴅럈", 1583793228, -1275494250), a.c(516046238, "㶽䀐쪾")) : a.b("\uf571", -1790847644))
               + a.c(1183741745, "眒ิ葰")
               + Math.round(var10.turnRate)
               + a.b("\ue66b齅", 1018357465)
               + wap.s(a.d("湟", -494887186, 1816719556), a.b("킀", 1635964099))
               + a.c(-382177298, "濍᛫鲯")
               + Math.round(var10.sprintShare * 100.0F)
               + a.b("\ued55", -1000018575),
            var5,
            var6,
            var7
         );
         var6 += 12.0F;
         irr.SMALL
            .draw(
               var1,
               irr.SMALL
                  .ellipsize(
                     wap.s(
                        a.b("䎇㨽냣⺔ꕋ⏴馦ဓ踃ҳ茮礜\uf7c0湶\ue423拘\ud891坖춶䮮쉄롁㚼굦⬊ꇈᡬ陯ೋ誈ĭ", -1824111621),
                        a.b("\udf2cꛢⱏ눲㧢뼦Ԁ賹እ鰊ῄ\ue5b8潿\uf2ae碈︄䐶쯯兙흿庂₺긅㇎략㴘蓗\u0af8逄ᙛ馍捁\ue906瓢\uf6a3簘쏃䦳콮囔", -2031363269)
                     ),
                     var7
                  ),
               var5,
               irr.SMALL.centerTop(var6 + 4.0F),
               iov.textMuted
            );
         var6 += 13.0F;
         float var15 = 18.0F;
         boolean var16 = lfa.minesWith(var4);
         boolean var17 = irr.inside(var2, var3, var5, var6, var7, var15);
         if (var16) {
            irr.secondaryButton(
               var1,
               wap.s(a.c(1578366292, "\uf500貅ٗ頽Ꮘ镝⼉꛳㣩눜㗂쾽䅾\ud89c劘푷渥\ue1e8笓ﴋ瓡"), a.b("銘\ueb1d懏ﾥ瑐\uf2c5䢑셫影퇚嘍걽⊥묑ㄵ뎦\u0dfc舡", -1223257397)),
               vhz.CHECK,
               var5,
               var6,
               var7,
               var15,
               var17 ? 1.0F : 0.0F,
               0.0F
            );
            this.ihc
               .add(
                  new ige(
                     var5,
                     var6,
                     var7,
                     var15,
                     () -> {
                        lfa.activateMine(null);
                        this.iib(
                           wap.s(
                              a.c(-284355723, "\u1317檒\ue040縪\uf5df獊줞䃤\udefe吆폏⧭ꝸ㻊뒛㉢衦ߣ鵋᭕鋫\ue8a7易\ufd91管\uf168䣂웝屮\uda32冏꽞┟볩㪳"),
                              a.d("绣ݦ趴Ꮮ頫Ếꓪⴐ댊㷚멵䀇컜坯\ud92c寇\ue18c湜\uf4e0犴הּ蔇࿕鑵ሆ", -74604138, -1113465043)
                           ),
                           vhz.INFO,
                           false
                        );
                     },
                     null
                  )
               );
            if (var17) {
               this.iho = wap.s(
                  a.b("\uf8b1脯௹閂ṝ颧ˀꬅ㔻뾾㡬숆䳳핦弲\ud9c8揂\uec54盯\uf0b4祕͗趦ᙴ选\u1ad0ꌨⴭ럁㇟머䓵캷圃턒宴\ue47f渋\ue8c0焨דּ藅࿘蠭ዷ鲈╛꿤⦬뉴", 696252608),
                  a.b("䎇㨗냇⺴ꅹ\u07fc鶛ၸ踠Ӥ荊祅\uf793測\ue013暃\udcf8匨즀俳옠뱶㋎\ua95a⬷ꆕᠥ陶\u0cff誥Ğￏ疃\uec79渿\ue094彇픷叫쩗䀍㻱", -1737734217)
               );
            }
         } else {
            irr.primaryButton(
               var1,
               wap.s(a.b("\ue164飳ሶ谂ޜ脪㬷늧Ⳍ꙼↴\udbe7唔첢䛺", 991420734), a.c(-594688726, "섥룍㉠감⟂ꄄᬬ鋔ಇ蘴ƕﯪ煑\uecf2抳\ue423幘톈䬠쵓䒀㻖끮")),
               vhz.CHECK,
               var5,
               var6,
               var7,
               var15,
               var17 ? 1.0F : 0.0F,
               0.0F
            );
            this.ihc
               .add(
                  new ige(
                     var5,
                     var6,
                     var7,
                     var15,
                     () -> {
                        lfa.useForMine(var4);
                        this.iib(
                           wap.s(
                              a.c(690019623, "\udd4b\ua4ce⸜끶㮃봖݂躸Ⴂ驗ᶉ\ue7f6椵\uf0d7竈ﰼ䙱즮単핐岱⛺ꠜ㎃뗽㼴蛐ࢉ鈘ᑢ鿁愗\ueb45犉\uf4e7繍솏䯫촥咒\udeccꁳ⩯귟㝏"),
                              a.b("镼\uecf9昫\uf841玴\uf521併욏墕혾凩ꮙ╁복㛑둂ਗ藌ή鴾Ⴋ櫳\ue02b篲\ufdeb眑캲䃤\uda0e屢ퟬ⤦ꍼ㪘볖㙡覷Έ腉ᣰ銮\uec2a晰\ue1d7筬\uf109", -2020895469)
                           ),
                           vhz.CHECK,
                           false
                        );
                     },
                     null
                  )
               );
            if (var17) {
               this.iho = wap.s(
                  a.c(-1398004916, "⌻媾크丆엳䍦爐烈\ueed2搳\ue3f9ᦂ靝\u0ef4蓴ɇ렆㟔굫⬲ꋝ\ud8d3噬췩䮗셁磮\uf6a2氆\uea16憪齱ᕺ賜ઙ耥㿵떜㌜\uaafa₻幗퐘叡쥢䜏ﻝ瑶\uf26a槶\ue787ᵝ铫ኳ"),
                  a.d("ⲱ唴\udfe6䆌쩹䳬\uf6b8罂\ue158濻\ue851ቚ鲄Ս轮চ뎢㠑ꚳ⃨ꤚ퍏巾숻䑈쪃獊ﴘ柮\ue1c5樌邿Ứ茁ķ诽㐠빝㣴ꔧ⬕嗫\udfc4塲욼䳑\uf500羻淋截\uec2e\u16fd", -985249691, 163013793)
               );
            }
         }
      }
   }

   void iiw(tiq var1) {
      if (this.ihe != var1) {
         this.ihg = false;
         this.ihi = 0.0F;
      }

      this.ihe = var1;
      if (var1 != null) {
         var1.prefetch();
      }
   }

   static String iix(tiq var0) {
      if (!eyn.online()) {
         return wap.s(a.d("횄꼵╱뮗\u3040뚲೮蔜᭙釹᙮\uec50抎\ufb3f", 385415165, -1842273961), a.b("固⽋ꔏ㯩뀾㊑裍Ķ齢ᗙ鈎污\ue6a4罬\uf54e玾", 1968199370));
      } else if (var0.recordingsLoading()) {
         int var2 = Math.max(0, var0.recordingsTotal());
         return wap.s(a.c(766482002, "陹\uefc8斌ﭪ炽\uf64f䰓엡室턄嚓"), a.d("熩࠘艜Ჺ靭ᗂ꾞♥렱㊊땝䬲", 262629721, 700651740))
            + var0.recordingsLoaded()
            + a.d("뉕", -1427641815, 295458898)
            + var2;
      } else {
         int var1 = var0.recordingsTotal();
         return var1 < 0
            ? ""
            : wap.s(a.c(-1166224843, "툚ꮫ⇯뼉㓞눦ࡲ臍ῑ镯\u12bf\ue8d4昒�疴"), a.b("量\ue87e戺ﳜ看\uf5a8䯩옆塖틭唵꽎↖밨㙡", -133852704))
               + var1
               + wap.s(a.c(-171662096, "ꓕ\udd36埲즅䈟"), a.c(-1060228833, "ㄺ䲜왈堶ퟰ"));
      }
   }

   List<eyg> iiy(tiq var1) {
      ArrayList var2 = new ArrayList();
      String var3 = var1.kind();

      for (eyg var5 : var1.versions()) {
         if (var3.equals(var5.meta().get(a.c(-390641499, "䣊ㅹ뮭◖")))) {
            var2.add(var5);
         }
      }

      return var2;
   }

   void iiz(DrawContext var1, float var2, float var3, tiq var4, float var5, float var6) {
      int var7 = this.iiy(var4).size();
      tik var8 = var4.cloud(var4.kind());
      String var9 = this.ihg
         ? wap.s(a.d("駜\ue06e檿\uf4c6", 1848586782, -139482204), a.b("⋧孛톏俹쐪", 483272415))
         : (
               var8 == tik.SAVING
                  ? wap.s(a.c(-1476346665, "벭씎俊톤婴\udccc曘\uefbe煶"), a.d("嶃\u244d껥ゑ묶㶊螫๛鑪Ṍ餈", 1807612696, -1274699055))
                  : (var8 == tik.FAILED ? wap.s(a.c(938319265, "鷃\ue473溻\uf09e笚ﶹ䟽츟偁\udab4巰꜖"), a.d("ﭕ苬ప阺ᶒ魘ℎꢏ㛝뱤㮿쇃䬄툢壦", 1213467905, -708775322)) : "")
            )
            + wap.s(a.b("䮽\u321f룛⚫굦⯑醃ᡯ虣", -1984017470), a.c(1355796776, "픝겫☍롽㏓땢\u0b29"))
            + var7;
      float var10 = Math.max(16.0F, irr.SMALL.width(var9) + 9.0F);
      boolean var11 = irr.inside(var2, var3, var5 - var10, var6 - 5.5F, var10, 11.0F);
      int var12 = var8 == tik.FAILED && !this.ihg ? -1750963 : (!this.ihg && !var11 ? iov.textMuted : iov.accent());
      irr.drawChip(var1, var9, var5, var6, var12, iov.stroke, var11 ? 1.0F : 0.0F);
      this.ihc.add(new ige(var5 - var10, var6 - 5.5F, var10, 11.0F, () -> {
         this.ihg = !this.ihg;
         this.ihi = 0.0F;
         if (this.ihg) {
            var4.refreshVersions(true);
         }
      }, null));
      if (var11) {
         this.iho = this.ihg
            ? wap.s(a.b("옣뾱㕠\uab19₅Ꙡᰨ閖\u0b9d脰ۮﳚ牀\uebf3憫\ue75b崝", 226543216), a.d("褓\uf08f穛\ue42d濾\ued5b匒\udef9䒺츉䧐뎠㵹\ua4cb", 834514197, -1008787435))
            : wap.s(
               a.b("ﲶ蔴\u0ff4醒ᩎ鲦⚡꽖ㄚ뮣㱷옍䣛턮嬰\uddc3枇\ue857狭\uf4f0絎܅觥ቿ鐎ỊꝽ⥸돆㖐빭䃨쪻升핑徣\ue07b樉\uecc0畠｡膊உ谡\u16fc颅ℝꯣⶭ뙷㡁싄䭨쵶埉\ud99b截\ue4fe滅\uf718秫λ葁น郇ᥧꍱ●꾛〢몵㲋압俯톪", 697433272),
               a.b(
                  "匘⪃ꁖ㸥뗶㌸贄ë麻ᑸ鎯榬\ue773绂\uf49c爒찲䟿\udd4e嬕틣ꢼ♸맅㯟넋ࣈ蚔ᱦ驍ᇽ\uef22愂ﳡ纠\uf00f俗얬䍴\udacf傟⩡ꀨ⎋뤥㜮軹н舊᷃鞨楡\ue4c1抗\uf867癅췹䭜선峩홃걬⯪ꆰ㼁뚽ࢌ蹱E龃ᕔ錮櫲\ue45b縓\uf5e1珆줂䃔\udea8",
                  -81373358
               )
            );
      }
   }

   void ija(DrawContext var1, float var2, float var3, tiq var4, float var5, float var6, float var7) {
      float var8 = this.igz + 360.0F - 16.0F - 12.0F;
      if (!eyn.online()) {
         irr.SMALL
            .draw(
               var1,
               irr.SMALL
                  .ellipsize(
                     wap.s(
                        a.c(-744393332, "痠౾蚮ᣅ錃ᗶ꿬☇렋㋵딯佞쇕塾퉾咈\ueed2愐ﮥ綠\uf403蹎ð魤ᵜ鞋⸴ꁭ㫟볚㝵즾䏬\uda07屆훸楧\ue342斍ﰱ瘫\u0896苆չ龫ᇛꠟ"),
                        a.c(2106771448, "쏊메ろ껷┪ꎟ᷒逾\u0e69蓙̀癩矚\uee6a摅\ue2b6壺팯䦆쯀䈰㡮뚡\u2d72ꬎ↥鰎ᙇ費ઙ脩箛\uf5b3氰\uea16惒\udf07兡펩䨝쁌뺹㓫댯")
                     ),
                     var7
                  ),
               var5,
               irr.SMALL.centerTop(var6 + 6.0F),
               iov.textMuted
            );
      } else {
         List var9 = this.iiy(var4);
         if (var9.isEmpty()) {
            irr.SMALL
               .draw(
                  var1,
                  irr.SMALL
                     .ellipsize(
                        var4.versionsLoading()
                           ? wap.s(a.c(-686614763, "ᝈ滚\ue407穳\uf1a9真쵅䓳\udaf8偕힋\u2dbfꌤ㪐냙㘯갲"), a.b("ᄷ梡\ue271米\uf7a7煣쬶䊹\ud888噘퇵⮃ꔭ㳣뚴ᑙ", -729213648))
                           : wap.s(
                              a.d("엙뱉㛕ꣷ⌲ꖔ\u1fd4阤\u083f苘Ԙｾ熨\ue803扖\ue4a6廴텶䮜췑䐷㸨낁⬄굽➿鸄ၒ諫\u0cfb蜉禕\uf3d8樢\uec70曈", -760468193, -1115952980),
                              a.b("⺺圔\uddbc䏈졯仓\uf4ec統\ue32e槩\uee34ဠ髥͓襵྅떳㩣\ua4c9⚇꽱픤宝쑜䘾쳧産＊旧\ue7a8气銷\u18fc腲̹趔㉁렺㻨ꝗ⵿", -1722602830)
                           ),
                        var7
                     ),
                  var5,
                  irr.SMALL.centerTop(var6 + 6.0F),
                  iov.textMuted
               );
         } else {
            float var10 = 24.0F;
            float var11 = var8 - var6;
            float var12 = Math.max(0.0F, var9.size() * var10 - 2.0F - var11);
            this.ihi = Math.min(this.ihi, var12);
            this.ihh = this.ihh + (this.ihi - this.ihh) * 0.35F;
            String var13 = var4.activeKey(var4.kind());
            uut.pushScissor(var1, var5 - 2.0F, var6, var7 + 4.0F, var11);
            float var14 = iov.r(5.0F);

            for (int var15 = 0; var15 < var9.size(); var15++) {
               eyg var16 = (eyg)var9.get(var15);
               float var17 = var6 + var15 * var10 - this.ihh;
               if (!(var17 + var10 < var6) && !(var17 > var8)) {
                  boolean var18 = var4.ownVersion(var16);
                  boolean var19 = var18 && var16.key().equals(var13);
                  boolean var20 = irr.inside(var2, var3, var5, var17, var7, var10 - 2.0F) && irr.inside(var2, var3, var5, var6, var7, var11);
                  int var21 = var19 ? ujt.lerp(iov.field, iov.accent(), 0.16F) : iov.field;
                  uut.round(var1, var5, var17, var7, var10 - 2.0F, var14, var20 ? ujt.lerp(var21, iov.fieldHover, 0.5F) : var21);
                  if (var19) {
                     uut.outline(var1, var5, var17, var7, var10 - 2.0F, var14, 1.0F, iov.accent(180));
                  }

                  long var22;
                  try {
                     var22 = Long.parseLong(var16.meta().getOrDefault(a.c(782589513, "席➍굉㌼룾㹞萌"), a.d("쐕", 897037790, 1952084474)));
                  } catch (NumberFormatException var33) {
                     var22 = 0L;
                  }

                  if (var22 <= 0L) {
                     var22 = var16.uploaded() * 1000L;
                  }

                  String var24 = new SimpleDateFormat(a.c(137798745, "ꐶ\udd87圞줌䋛쐇縼\uf7cd槠\ue306擕"), Locale.ROOT).format(new Date(var22));
                  String var25 = var18
                     ? ""
                     : wap.s(a.c(-197554323, "轇\uf6f6粲\ue254榃\uef74唳\udcdf䊂졾"), a.c(45716222, "鋖\ueb67愣ￅ琒\uf6bb䳧섁"))
                        + var16.meta().getOrDefault(a.c(1648956708, "ᕓ泠\ue62e硖\uf38e町콠"), a.b("㲧", -1428472679));
                  float var26 = 52.0F;
                  float var27 = var7 - var26 - 30.0F;
                  irr.SMALL
                     .draw(var1, irr.SMALL.ellipsize(var24 + var25, var27), var5 + 6.0F, irr.SMALL.centerTop(var17 + 7.0F), var19 ? iov.accent() : iov.text);
                  irr.SMALL
                     .draw(
                        var1,
                        irr.SMALL
                           .ellipsize(
                              ijb(var16)
                                 + a.d("ㆀ䠱쉵岓흄", -531317001, -463302830)
                                 + Math.max(1, Math.round((float)var16.size() / 1024.0F))
                                 + wap.s(a.b("鼏\ue6d5氏", 2039979820), a.d("䷔た몇", 1713517249, 1286111030)),
                              var27
                           ),
                        var5 + 6.0F,
                        irr.SMALL.centerTop(var17 + 16.0F),
                        iov.textMuted
                     );
                  float var28 = var5 + var7 - var26 - (var18 ? 22.0F : 4.0F);
                  float var29 = var17 + 4.0F;
                  if (var19) {
                     irr.drawChip(
                        var1,
                        wap.s(a.c(1899300375, "ٸ翎\uf553歷\ue0a6昁"), a.c(-502326169, "ᡓ憛\ueb36畆ﺔ硒쉺䯿헖弐\ud8c0⊿")),
                        var28 + var26,
                        var17 + 11.0F,
                        iov.accent(),
                        iov.stroke,
                        0.0F
                     );
                  } else {
                     boolean var30 = irr.inside(var2, var3, var28, var29, var26, 14.0F) && irr.inside(var2, var3, var5, var6, var7, var11);
                     irr.secondaryButton(
                        var1,
                        wap.s(a.c(-678056241, "꺇휕巈쎼"), a.d("衱\uf1e7笷\ue535满\ue824剸\udbf3䖢", -1934437717, 409034436)),
                        null,
                        var28,
                        var29,
                        var26,
                        14.0F,
                        var30 ? 1.0F : 0.0F,
                        0.0F
                     );
                     if (var17 >= var6 - 1.0F && var17 + var10 <= var8 + 1.0F) {
                        this.ihc
                           .add(
                              new ige(
                                 var28,
                                 var29,
                                 var26,
                                 14.0F,
                                 () -> {
                                    var4.useVersion(var16);
                                    this.iib(
                                       wap.s(a.d("廡❳궮㏚렀㺶蓬൚鍑᧼鸮摅\ueac1猦復羀엎䨅킰因｟", -573824609, -1897496793), a.c(-1694610078, "䥡ヷ먧␥꿱⤵鍠\u1aef胞ข觞玮駱撹\ueeed桩툧嶏읊敳")),
                                       vhz.REFRESH,
                                       false
                                    );
                                 },
                                 null
                              )
                           );
                     }

                     if (var30) {
                        this.iho = var18
                           ? wap.s(
                              a.d("㸮䞹쵼午\ud8cb幦\ue434淟\uf3d3礴ﻴҒ詄Ꮿ馺Ὂꕋ⫕끯㙸뿛얖䬨킼嚎\udc5d日\uebb5煋", -1429811384, -274140882),
                              a.c(-529193473, "⇹堑튼䳌윞䇘ﯰ爈\uec5b曨\ue149ᬶ醍\u0c51蘍ý뻑㔒꾦⦂ꁴ\uda5c咙쬦䥅쎖稯\uf47f溆\ue8d4")
                           )
                           : wap.s(
                              a.b("⮎刓\ud8df䚧촩䯌\uf183硳\ue636泔\ueb4aᄹ鿥ٕ谏લ내㽢ꗋ⎁\uaa39퀼库앃䌦즤灇︔擾\ue2a6椚韎ᶈ萼Ȯ袐㝍뵸㯾ꉉ⠀嚴\udcae嬂", -2069746719),
                              a.b("腃\uf8e9爾\uec4e枞\ue157孺튇䳚옙䇄뿙㕣곝⚏ꐝᩎ閝༤襴\u008d窫\uf074澷\uedda挔\udad8哷칺䡗쏧㵁덢⺋곀≩鷇ៈ鄚ࢮ芆ﰌ癖\uf1eb款\ue53d峠", -1136491187)
                           );
                     }
                  }

                  if (var18) {
                     float var34 = var5 + var7 - 18.0F;
                     boolean var31 = var16.key().equals(this.ihl) && System.currentTimeMillis() - this.ihm < 3000L;
                     boolean var32 = irr.inside(var2, var3, var34, var29, 14.0F, 14.0F) && irr.inside(var2, var3, var5, var6, var7, var11);
                     irr.iconButton(var1, vhz.TRASH, var34, var29, 14.0F, var32 ? 1.0F : 0.0F, var31, 1.0F);
                     if (var17 >= var6 - 1.0F && var17 + var10 <= var8 + 1.0F) {
                        this.ihc.add(new ige(var34, var29, 14.0F, 14.0F, () -> {
                           if (var16.key().equals(this.ihl) && System.currentTimeMillis() - this.ihm <= 3000L) {
                              this.ihl = null;
                              var4.deleteVersion(var16);
                              this.iib(wap.s(a.c(-422768564, "ပ榗\ue353紣\uf6ee灙쨋䎴\uddaf土탅⪽ꑻ㷛랉"), a.b("괯풹帟쁯䯁촇猻ﺩ悁\uea34淬鞓᥌胰", 1788782899)), vhz.TRASH, false);
                           } else {
                              this.ihl = var16.key();
                              this.ihm = System.currentTimeMillis();
                           }
                        }, null));
                     }

                     if (var32) {
                        this.iho = var31
                           ? wap.s(
                              a.d("Ჯ攱\uefe7熜暑粹욫作턅宼\udc68♗꣔ㅾ뭢㷗螙ࡁ鋻ᒻ鵝\ue749榳\uf27f瑔ﻃ䝤줨叝헁带ꃫ⪩댝㔍뾳g訌\u0cce", 157443967, -63210572),
                              a.d("ৎ瀣\ufae8惨\uef25榕폅娶쁳櫶촑㌃붣␖깎⢼銉ᵖ莉ǀ蠸\uf67e糓\ue70d慸\ueba2创\udc40", 1486666695, -549341696)
                           )
                           : wap.s(a.b("뀧즷䍭\udd15囓큳橥\ue3c0綃\uf733烺諘љ鷻ឿ酏⬚\ua4cd㹿", 62959728), a.b("კ楿\ue3a8緒\uf606烍쪐䜍\udd3f垁큓⹁ꒄ㴲뜔\u31e4诒ѵ", 151000296));
                     }
                  }
               }
            }

            uut.popScissor(var1);
         }
      }
   }

   static String ijb(eyg var0) {
      Map var1 = var0.meta();
      if (a.d("ꟃ\ude64咺쫌", -356377622, 1701755994).equals(var1.get(a.d("뮣숐䣄횿", -1053645378, 2131566194)))) {
         return wap.s(a.d("馢\ue01d櫒\uf4a9缭", -1354311621, -1253424649), a.c(841166283, "⧹偉\uda91䓢켿䧾\uf3dd縴"))
            + var1.getOrDefault(a.b("\ue32a骕ၚ踡", -1249451195), a.c(-687272553, "ඩ"))
            + a.b("꾏혻峨숎䥎쿿", 1031778220)
            + wap.s(a.d("垊⸺ꓮ㪃녉㞫", 184725874, 2121655946), a.b("厶⨆ꃙ㺤딍㏂觭Ѿ", -350267519))
            + var1.getOrDefault(a.b("䌺㪊끞⸳", 1642021706), a.d("\uee70", 869288391, 2111219593))
            + a.d("\uf380", 1223426748, -833687272);
      } else if (a.c(-1848527316, "뙅쿰䔤\udb5e").equals(var1.get(a.c(-478166536, "솗려㋰겋")))) {
         String var2 = var1.getOrDefault(a.d("ퟲ깊⒛뫾", 193331248, -906045526), "");
         String var3 = var1.getOrDefault(a.b("㹖䟪촹協\ud884", 2141535793), a.b("䠚", -1822472149));
         return wap.s(a.c(-1782852913, "특ꬑ⇈뾱㑾늜"), a.b("\uf2f4謼ƕ鿫ᑂ隓", -1180895552))
            + var1.getOrDefault(a.d("牴\u0bde脒ἢ", 295050168, -1694209604), a.c(-979148384, "憞"))
            + a.c(266419620, "㶇䐳컠倆\udb46巷")
            + wap.s(a.d("粢Ԛ迆ᆽ騮", -874869118, -1868500403), a.b("憸᠊銠\u0cdb茜", -1816304131))
            + var1.getOrDefault(a.d("\uf1d5衭ʱ鳊", 1465591735, -1639590386), a.c(-943317316, "Ẃ"))
            + a.d("⏯", 1030898029, -1430494554)
            + (
               var2.isEmpty()
                  ? ""
                  : a.c(-579725755, "ᙠ濑\ue595筳\uf0a4")
                     + wap.s(a.b("駷\ue050檎\uf4f8罤", -1861445243), a.b("\u0ade猔留柄\uec6e櫞풝", 16977564))
                     + var2
                     + a.c(2133358322, "盖")
            )
            + (a.d("ꎫ", 401392358, -189505156).equals(var3) ? "" : a.b("ਜ玭里朏\uecd8橢", -136312262) + var3 + a.d("饌", -699890809, 536025839));
      } else {
         return wap.s(a.d("\udacdꍦ⦱럄㰖몪ê褀ᝂ鷾ᩴ", 277948855, 2142171906), a.b("瑉\u0dfc蝔\u192f銍ᐿ긜⟡붠", 1437167617))
            + var1.getOrDefault(a.b("⨅厮\ud979䜌쳞䩢\uf022秈\ue78a洶", -534369668), a.d("䩖", 1487695359, -1655887977))
            + a.b("헎", 265082346);
      }
   }

   void ijc(DrawContext var1, String var2, String var3, double var4, double var6, float var8, float var9, float var10) {
      irr.SMALL.draw(var1, var2 + a.d("업뱴", 1573951842, 768433285) + var3, var8, irr.SMALL.centerTop(var9 + 5.0F), iov.textDim);
      String var11 = Double.isNaN(var6)
         ? ""
         : wap.s(a.d("♲心핓䬤샿䙋ﰝ痫\uebbd態", 829366800, -1274280888), a.d(".禟\uf753椣\ue288摅\ude13埧즼䜗", -340973526, 1688348718)) + ijd(var6);
      float var12 = irr.SMALL.width(var11);
      irr.SMALL.drawRight(var1, var11, var8 + var10, irr.SMALL.centerTop(var9 + 5.0F), iov.textMuted);
      int var13 = var4 >= 90.0 ? iov.accent() : iov.text;
      irr.LABEL.drawRight(var1, ijd(var4), var8 + var10 - var12, irr.LABEL.centerTop(var9 + 5.0F), var13);
   }

   static String ijd(double var0) {
      return Double.isNaN(var0) ? a.b("蝎", -1833982117) : Math.round(var0) + a.b("朋", -232036561);
   }

   void ije(tiq var1) {
      long var2 = System.currentTimeMillis();
      if (var2 - this.ihr > 3000L) {
         this.ihr = var2;
      } else {
         this.ihr = 0L;
         if (tcz.sessionProfile() == var1) {
            tcz.stop();
         }

         try {
            var1.clearRecordings();
            this.iib(
               wap.s(a.d("鷞\ue458溍\uf0f0笺ﶝ䟃층偣\udac6嵆ꝳ⦥뀝㩇벧۹褩", 516351889, 906787343), a.d("錨\ueabe恢︔疺\uf372䴹삫広퐶叮ꦑ❎뺉", 1945965674, -1790868645)),
               vhz.TRASH,
               false
            );
         } catch (IOException var5) {
            this.iib(
               wap.s(a.c(-1328573303, "铛\ued48枔怜爨\uf4cd仚윪奼폄吆깦\u20f4뤑㍞떢\u0fe5"), a.b("誀\uf319緟\ue7b1汧\uead3僸\ud90d䜭춟䩉끇㺝ꍀ⵰꯶ᆽ鹧ӗ苼ଅ", -2079617400)), vhz.CLOSE, true
            );
         }
      }
   }

   static void ijf(tiq var0, int var1) {
      int[] var2 = tiq.BOOSTS;
      int var3 = 0;

      for (int var4 = 0; var4 < var2.length; var4++) {
         if (var2[var4] == var0.mineBoost()) {
            var3 = var4;
         }
      }

      var0.set(a.c(1971236830, "꾹혌峘슢䤾쿃疝ﱬ戯\ue899"), var2[(var3 + var1 + var2.length) % var2.length]);
      var0.save();
   }

   static void ijg(tiq var0, String var1, int var2) {
      var0.set(var1, var2);
      var0.save();
   }

   static void ijh(tiq var0, String var1, double var2) {
      var0.set(var1, Math.round(var2 * 100.0) / 100.0);
      var0.save();
   }

   static void iji(tiq var0, double var1) {
      double var3 = Math.max(2.6, Math.min(6.5, var0.standFar() + var1));
      var0.set(a.c(-334764225, "\ue746黰ᐶ詈ƕ蜳㴽뒄⫝̸ꁾ"), Math.round(var3 * 10.0) / 10.0);
      var0.set(a.d("∻宍텋伵쓨䉎\uf840燱\uefa5攐\ue2d0", 660026003, -313782064), Math.round(Math.max(2.0, var3 - 1.2) * 10.0) / 10.0);
      var0.save();
   }

   static void ijj(tiq var0, String var1, String[] var2, String var3, int var4) {
      int var5 = 0;

      for (int var6 = 0; var6 < var2.length; var6++) {
         if (var2[var6].equals(var3)) {
            var5 = var6;
         }
      }

      var0.set(var1, var2[(var5 + var4 + var2.length) % var2.length]);
      var0.save();
   }

   static String ijk(String var0) {
      return switch (var0) {
         case a.c(-1369665500, "遤\ue9e4挧ﵟ") -> wap.s(a.b("ꭤ틤堧왟", 1368238884), a.b("볅씣俾퇹婙", 1242478804));
         case a.d("ߍ繛\uf48e櫬\ue13c枎", 1144288218, 39810114) -> wap.s(a.b("ꠔ톂字씵以졗", -823285695), a.d("뗇찕䛄\ud8c0匛헗", -565333163, -873725259));
         case a.d("㕍䳃예塤펺", 1510993894, 1263590116) -> wap.s(a.d("鮴\ue23a棱\uf69d絉", -518275283, 170927318), a.c(-2126759907, "㰄䗪켲儾\udae5屖"));
         case a.d("\u0e77矰ﴮ捘", 502026242, -1245422042) -> wap.s(a.c(-465240696, "\ufdd8葟ກ郷ᬢ鶔⟎"), a.c(312283921, "ᜲ溘\ue441穈\uf1e2睒"));
         case a.d("Ɛ砆\uf2c8沼\ue76b", -968460628, 2000516970) -> wap.s(a.c(1659239501, "ﰖ薀ཆ鄸\u1ae5鱙☍꿵"), a.b("馵\ue067櫈\uf4c8缒", -552362607));
         default -> wap.s(a.d("궩퐼廾", -477836962, 1862427833), a.b("變荕\u0984鞎", -62718248));
      };
   }

   static String ijl(String var0) {
      return switch (var0) {
         case a.b("뛕콃䖂\udbf4", -1503349097) -> wap.s(a.d("땱쳧䘦\ud850", -1495355796, -1639834785), a.c(691533611, "\uf33c諗\u000e鹼ᖩ鍦"));
         case a.d("ࣉ煔ﮞ", -432960288, 919503975) -> wap.s(a.d("琉ඔ蝞", -2064260870, 719295677), a.d("ᯪ扷\ue8ae皤ﴊ箿솓䠝", 419407606, -38029048));
         default -> wap.s(a.b("⓰嵠\ud7ae䧀숛䒧", 1354966200), a.d("㍚䫈쁥幨햳", -389830146, -217997636));
      };
   }

   static String ijm(String var0) {
      return switch (var0) {
         case a.c(1802573855, "ᡉ懆\ueb19略ﺲ") -> wap.s(a.c(452122618, "\ud7ac긣⓼몀ㅗ"), a.c(819771376, "돩쩴䂬\uded6啾"));
         case a.c(466998349, "퐄궘❘뤼㋩") -> wap.s(a.d("鬣\ue2bf桿\uf61b緎", 1665900776, 359349122), a.b("\uf31c誂T鹒ᖁ鍈⥤", -1924729078));
         default -> wap.s(a.b("\ue5ee鱷ᚥ裙̒薻", 702473637), a.d("㌲䫢쁄帴헪匩\ue97a", -1059400110, -1884823226));
      };
   }

   float ijn(DrawContext var1, String var2, float var3, float var4) {
      irr.SECTION.draw(var1, var2.toUpperCase(Locale.ROOT), var3, irr.SECTION.centerTop(var4 + 5.0F), iov.textMuted);
      return var4 + 12.0F;
   }

   void ijo(DrawContext var1, String var2, String var3, float var4, float var5, float var6, boolean var7) {
      float var8 = 26.0F;
      uut.round(var1, var4, var5, var6, var8, iov.r(6.0F), iov.field);
      irr.CARD_TITLE.draw(var1, var3, var4 + 7.0F, irr.CARD_TITLE.centerTop(var5 + 9.0F), var7 ? iov.accent() : iov.text);
      irr.SMALL.draw(var1, irr.SMALL.ellipsize(var2, var6 - 10.0F), var4 + 7.0F, irr.SMALL.centerTop(var5 + 19.5F), iov.textMuted);
   }

   void ijp(DrawContext var1, String var2, String var3, float var4, float var5, float var6) {
      irr.SMALL.draw(var1, var2, var4, irr.SMALL.centerTop(var5 + 5.0F), iov.textDim);
      irr.SMALL.drawRight(var1, var3, var4 + var6, irr.SMALL.centerTop(var5 + 5.0F), iov.text);
   }

   void ijq(DrawContext var1, float var2, float var3, String var4, boolean var5, float var6, float var7, float var8, Runnable var9, String var10) {
      boolean var11 = irr.inside(var2, var3, var6, var7, var8, 16.0F);
      irr.LABEL.draw(var1, irr.LABEL.ellipsize(var4, var8 - 17.0F - 6.0F), var6, irr.LABEL.centerTop(var7 + 8.0F), var11 ? iov.text : iov.textDim);
      irr.drawSwitch(var1, var6 + var8 - 17.0F, var7 + 3.25F, var5 ? 1.0F : 0.0F, var11 ? 1.0F : 0.0F);
      this.ihc.add(new ige(var6, var7, var8, 16.0F, var9, null));
      if (var11) {
         this.iho = var10;
      }
   }

   void ijr(
      DrawContext var1, float var2, float var3, String var4, String var5, float var6, float var7, float var8, Runnable var9, Runnable var10, String var11
   ) {
      boolean var12 = irr.inside(var2, var3, var6, var7, var8, 16.0F);
      irr.LABEL.draw(var1, var4, var6, irr.LABEL.centerTop(var7 + 8.0F), var12 ? iov.text : iov.textDim);
      String var13 = var5 + a.b("\uf46c距✔", 706212943);
      irr.drawChip(var1, var13, var6 + var8, var7 + 8.0F, iov.text, iov.stroke, var12 ? 1.0F : 0.0F);
      this.ihc.add(new ige(var6, var7, var8, 16.0F, var9, var10));
      if (var12) {
         this.iho = var11 + wap.s(a.c(719918621, "ᘪ澛\ue5df笹\uf0ee瘍책䖺\udbea兇훀Ⳳꈪ㮞뇇㜾贺⋟願ṋ鞿\uedec捗"), a.c(-926265589, "伻㚊볎∨\ua9ff⭱鄧ᣐ芳⠶近熽ｧ曑\uec85橰"));
      }
   }

   void ijs(
      DrawContext var1, float var2, float var3, String var4, String var5, float var6, float var7, float var8, Runnable var9, Runnable var10, String var11
   ) {
      irr.LABEL.draw(var1, var4, var6, irr.LABEL.centerTop(var7 + 8.0F), iov.textDim);
      float var12 = 12.0F;
      float var13 = Math.max(22.0F, irr.VALUE.width(var5) + 6.0F);
      float var14 = var6 + var8 - var12;
      float var15 = var14 - var13;
      float var16 = var15 - var12;
      float var17 = var7 + (16.0F - var12) * 0.5F;
      boolean var18 = irr.inside(var2, var3, var16, var17, var12, var12);
      boolean var19 = irr.inside(var2, var3, var14, var17, var12, var12);
      uut.round(var1, var16, var17, var12, var12, iov.r(3.0F), var18 ? iov.fieldHover : iov.field);
      uut.round(var1, var14, var17, var12, var12, iov.r(3.0F), var19 ? iov.fieldHover : iov.field);
      irr.VALUE.drawCentered(var1, a.c(1068799768, "霴"), var16 + var12 * 0.5F, irr.VALUE.centerTop(var17 + var12 * 0.5F), var18 ? iov.text : iov.textDim);
      vjf.draw(var1, vhz.PLUS, var14 + var12 * 0.5F, var17 + var12 * 0.5F, 6.0F, var19 ? iov.text : iov.textDim);
      irr.VALUE.drawCentered(var1, var5, var15 + var13 * 0.5F, irr.VALUE.centerTop(var17 + var12 * 0.5F), iov.text);
      this.ihc.add(new ige(var16, var17, var12, var12, var9, null));
      this.ihc.add(new ige(var14, var17, var12, var12, var10, null));
      if (irr.inside(var2, var3, var6, var7, var8, 16.0F)) {
         this.iho = var11;
      }
   }

   void ijt(DrawContext var1, float[] var2, float var3, float var4, float var5, float var6) {
      uut.round(var1, var3, var4, var5, var6, iov.r(4.0F), iov.field);
      if (var2.length >= 2) {
         float var7 = Float.MAX_VALUE;
         float var8 = -Float.MAX_VALUE;

         for (float var12 : var2) {
            if (Float.isFinite(var12)) {
               var7 = Math.min(var7, var12);
               var8 = Math.max(var8, var12);
            }
         }

         if (!(var8 > var7)) {
            var8 = var7 + 1.0F;
         }

         float var14 = 0.0F;
         float var15 = 0.0F;

         for (int var16 = 0; var16 < var2.length; var16++) {
            float var17 = var3 + 3.0F + (var5 - 6.0F) * var16 / (var2.length - 1.0F);
            float var13 = var4 + 3.0F + (var6 - 6.0F) * (1.0F - (var2[var16] - var7) / (var8 - var7));
            if (var16 > 0) {
               uut.line(var1, var14, var15, var17, var13, 1.2F, iov.accent());
            }

            var14 = var17;
            var15 = var13;
         }
      }
   }

   void iju(DrawContext var1) {
      float var2 = this.igz + 360.0F - 8.0F - 5.0F;
      uut.rect(var1, this.igy + 12.0F, this.igz + 360.0F - 16.0F - 8.0F, 486.0F, 1.0F, iov.divider);
      boolean var3 = this.ihe != null && this.ihe.aura();
      boolean var4 = this.ihe != null && this.ihe.mine();
      boolean var5 = this.ihe != null && this.ihe.walk();
      String var6 = this.iho != null
         ? this.iho
         : (
            var5
               ? wap.s(
                  a.b(
                     "䆬㠪닿ⲂꝈ⇯鯸㎻豖ڳ腦笄\uf5db汭\ue670䄳\udace啾쿹䦩쁅먾㒦꽽⥆ꎘᨤ鐔໗袇̯ﷆ瞿\uee5d栘\ue2a8嵴흅冘졐䈹㳒뛔ㄲ꯳▏鱛ᚡ邺୷蔉羝\uf66e瀩\ueac9撎\udf28妷펖䩚쓷뺧㥅덝\u2d9eꑻḴ飈ዚ账߷膍硓\uf2eb泴\ue749愗\udba2剢찏䛝샟묤㗲꾝☛ꃱ᪶镓བྷ観t﨎瓘",
                     -1931394656
                  ),
                  a.b(
                     "呝ⷋꜗ㥡닏㑳詌∏鷢ፍ钑溒\ue041禂\uf3d9甭콯䒫ﾪ塉퇟ꮺ┈뻂㢗뉭\u0bd4藁Ἱ饧ኵ\uec50昞\ufff4禟\uf318䳜욻䁩\ud9d3双ⴳꍘⓅ빷〟览ܕ蕅ẕ铸樴\ue38e斯Ｄ焌쫌䰑왠徼턋ꭙⲨꚆ㰪놇\u0bd8赙܆颿ቯ鐟淁\ue31f絀\uf2ad瓸칃䞑\ud9ee卖텫꺻\u206e멦㏍넜བྷ肢\u1af9顐ᗣ\uef9d攧\ufaf1糛\uf61e䡣쇀孵",
                     -450867154
                  )
               )
               : (
                  var4
                     ? wap.s(
                        a.d(
                           "癟࿙蔌᭱邻ᘜ갋ш뮥ㅀ뚕䳷숨实톃盀\ued3d抍\uf80a繚\uf7b6跅͒预Ự鑪\u2dd7ꏪ㤴뽡㓁쨌䁞\ud9fc忸핖檈\ue0ec晫ﾃ痊ଡ脧۔鰓ትꮢℙ꜑㳌닷䠡솎䞈\udd22卥\ue8c0湄\ue463綳\uf303襎\u0ef3蓣ᨣ鎘⦏꼶╦뫏か뙣侪씁嬇킡因\uec5c斈",
                           1727698663,
                           -5054299
                        ),
                        a.b(
                           "࣋煝ﮁ旷\uee59棥훚纙셴俛젇㈄볗└꽏⦻鏹ᠽꌼӟ赉\uf72c禞\ue254搉\ueefc坈\ud912䎮엱䩁듴㻄ꝏ╾ꮨᑺ鹷Ჺ腩ି熥￭硙\ue28c泱픧快\ud9a0䘑졮㚥뼘㥃Ɦⷡ阤ჶ骄̯跨\uf7bd琢響撬\ued11坋퇏宛쁉亂쳫ㄮ뮕◌ꨧ⠕鋟ᬆ蕻࿄覑",
                           260246670
                        )
                     )
                     : (
                        var3
                           ? wap.s(
                              a.b(
                                 "燌ࡊ芟᳢霨ᆏꮘϛ밶㛓넆䭤얻對혐煓\ueaae攔ﾅ科\uf026詚ӝ鼋ᥧ鏹⩄ꑰ㺴룶㍒춈䞞\ude3b塵틎洑\ue72b憶\uf80c牗ವ蚴ń鯒ᗷ갱⚓ꃉ㬚땸俽옃䁈\udae8哵\uef43榖\ue3f6稻\uf487軗ॻ茱ᶭ鐆⹑ꢤ⋶뵊㞊뇠䠢슞岔휵具\uebd1扐ﱠ皶\uf0f6譟ם鿒ᙻ郇⪙ꔟ",
                                 1758884295
                              ),
                              a.b(
                                 "뤝삋䩗퐡徏\ud933朌콏炢︍科菒ഁ铂ẙ顭∯ꧫዪ딉㲕䛦졐厁헓弶\ue682检\uf278琧ﮗԢ輒ᚙ郉᩶ꇎ⾥ꥼニ몖쐘丹춑匤\udd2f擾\uea55桺\uf3a4綬蝷ໂ貏ም頭⟴ꅖ⬫늍㰸䈜열䯄픏峅\ue69c怘\uea4c疍ｒ紽能੍退`駇⍸\uaad8サ먂㰫䞗쥉升",
                                 1073986911
                              )
                           )
                           : wap.s(
                              a.c(
                                 534676034,
                                 "艄﯂焗\uef6a撠\ue207堐\uf053侾앛䊎룬㘳꾅▘苛ᤦ隢గ詐Ϭ禳\uf76f沟\ueae2怦\ud9cc埜촣䭶상㸗둑ⷧꯠ⅍麓ᓷ鉰\u0b84臐Ｋ畹\uf2c9桚\ue662徶핉升죗䛬밼㖖뎓⤩Ꝣ\u1c8e験ၩ覼ܘ絕節烽\uee7a柇\uddd9嬬텡仐쐕䉲믾ㄎ꽎⒨ꊺᡏ醊\u0fe6蔶ͧ磁\uf611"
                              ),
                              a.c(
                                 -2089571789,
                                 "깎ퟘ崄썲䣜칠灟\ud81c柱\ue95e溂钁ᩒ莑\u09ca輾㕼뺸ֹꉚ⾵喝\udb50䂀웺䱜\uf594篌\ue137杤\ueca5ቺ鱗֨蟸ഭ늅㢎빞⟡꧑퍂奭\uded9䑹쩾玩ﴆ罔\ue488櫹逯ᦙ鿉Բ警ピ눜㡣ꖨ⬛儶횹岖숧䮝\uf5db眽ﵭ拖\ue801湳韖ᴘ荈ࢼ躔㐨릗⎅ꤽ⽨咫\uda04䁱춰䬏\uf541竁\ue0ee晟\uef82ᖀ鬬҇蛈౻눉㮮ꄒ❏겼튑堬쇰䞏"
                              )
                           )
                     )
               )
         );
      irr.SMALL.draw(var1, irr.SMALL.ellipsize(var6, 486.0F), this.igy + 12.0F, irr.SMALL.centerTop(var2), this.iho != null ? iov.text : iov.textMuted);
   }

   static String ijv(long var0) {
      return var0 / 60L + a.b("齞", -1501126811) + String.format(Locale.ROOT, a.c(1057187625, "月Ậ鑽ਗ਼"), var0 % 60L);
   }

   static String ijw(double var0) {
      return String.format(Locale.ROOT, a.d("䚰㼊뗆⯠", -393168842, 1176698535), var0);
   }

   static String ijx(double var0) {
      return String.format(Locale.ROOT, a.d("ꉇ\udbfd儳켗", -407176391, 37443935), var0);
   }

   @Override
   boolean mouseClicked(hlc var1, float var2, float var3, int var4) {
      if (this.ihn) {
         return true;
      }

      if (!irr.inside(var2, var3, this.igy, this.igz, 510.0F, 360.0F)) {
         this.close();
         return true;
      }

      if (this.igx.mouseClicked(var1, var2, var3, var4)) {
         return true;
      }

      var1.focus(null);

      for (int var5 = this.ihc.size() - 1; var5 >= 0; var5--) {
         ige var6 = this.ihc.get(var5);
         if (irr.inside(var2, var3, var6.x(), var6.y(), var6.w(), var6.h())) {
            Runnable var7 = var4 == 1 ? var6.right() : (var4 == 0 ? var6.left() : null);
            if (var7 != null) {
               var7.run();
               return true;
            }
         }
      }

      return true;
   }

   @Override
   void scrolled(double var1) {
      if (this.ihg && this.ihj > this.igy + 12.0F + 146.0F + 10.0F) {
         this.ihi = Math.max(0.0F, this.ihi - (float)var1 * 22.0F);
      } else {
         this.ihf = Math.max(0.0F, Math.min(this.iih(), this.ihf - (float)var1 * 34.0F));
      }
   }

   @Override
   boolean keyPressed(hlc var1, int var2, int var3) {
      if (var2 != 256) {
         if (var1.focusedField() == this.igx) {
            this.igx.keyPressed(var1, var2, var3);
            return true;
         } else {
            return true;
         }
      } else {
         if (var1.focusedField() == this.igx && !this.igx.text.isEmpty()) {
            this.igx.setText("");
         } else {
            this.close();
         }

         return true;
      }
   }
}
