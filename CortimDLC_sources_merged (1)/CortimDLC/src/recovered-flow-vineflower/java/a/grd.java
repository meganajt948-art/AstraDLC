package a;

import com.mojang.authlib.GameProfile;
import flow.dev.a;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.UUID;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.entity.Entity.RemovalReason;
import net.minecraft.util.math.Vec3d;

final class grd {
   static final String gre = System.getenv()
      .getOrDefault(a.d("賭\uf556羆\ue1ef橝\uec81囝\udf3d䅱쯆䰘뙯㢵ꄓ⭉궵២", 636141468, 1158230822), a.b("㴳䒆츜偸\udbaf崀\ue750溤\uf0e2積ﶀ߯褦ႈ髐ᰣꙣ⦽댁", -999604905));
   static gqu grf;
   static gqu grg;
   static OtherClientPlayerEntity grh;
   static int gri;
   static int grj;
   static int grk;
   static String grl;
   static int grm = -1;

   grd() {
   }

   static boolean tick(MinecraftClient var0, int var1) {
      if (var0.player == null) {
         return false;
      }

      if (gri != 6 || var1 - grj < 41) {
         var0.player.setYaw(0.0F);
         var0.player.lastYaw = 0.0F;
      }

      if (gri < 6) {
         var0.player.setPitch(10.0F);
         var0.player.lastPitch = 10.0F;
      }

      switch (gri) {
         case 0:
            grl = System.getProperty(a.d("듶쵍䞝\ud9f4剦퓋滆\ue726祪\uf3dd球踥®餈ፒ閮⿹", -347989485, -1854230894));
            System.setProperty(a.b("蕅ﳾ瘮\ue847揕\ue578彵횕䣙쉮䖰뾖ㄝꢻ⋡ꐝṊ", -730823374), gre);
            grr(
               ucg.sameServer(a.b("炉थ莼ᶤ陋შꪶ⍚봁㞸뀠䨌쓝", 1162178793), a.b("䒬㴀랙⦿ꉦ⒚麔\u177d褰Ό葂縷\uf0e8椒\ue31c旫\udfeb倲쪆䳗씣뽱", 438060247)),
               a.b("稠Ω襨᜔鳞ᩫꀰ⦊랈㴿몹䃕츟埣\uddbe嬂\ue110滙\uf478爤\ufbce膛༠钺ኘ顏↳꿪㔚덋㣻옩", 268991059)
            );
            grr(
               !ucg.sameServer(a.b("浬ᓀ鹙t记ച띓㺿ꃤ⩝귅埩\ud938", -995660532), a.c(-718851104, "㎀䨬삵庍핂叡\ue9bf恓︈璱\uf329अ蟔")),
               a.d("≼寞턖佽쒷䈂\uf859燣\uefe1敖\ue2d0ᢠ陫࿇藇̮륳㚯각⩔ꎫ\ud9b1坟첈", -2037514651, -944251801)
            );
            grr(
               ucg.sameServer(a.c(808902453, "\udf4bꛧⱾ뉅㦎뼲չ賟ዋ顧ᾭ\ue5d0欚\uf2b7磭﹗䑕쮈儹"), a.c(-1857349272, "ᤊ悦\uea3f琱\ufffb祓쌌䫠풣帛\ud9a3⎟굄㓷뻧")),
               a.d("ꏿ\uda52傌컥䕥쎟科\uf039湪\ue4c6按饱\u17ed踑ю芽㢿띳ⷝꯩ∃塋훴䴸쭛䆃\uf85b癇\uecbc櫯\ue11f", 1812745021, -1021974355)
            );
            ucg.ENABLED.set(true);
            ucg.reconnect();
            grp(var1);
            break;
         case 1:
            if (ucg.code() != null) {
               grs(a.c(772065183, "쟹빒㒆ꪥℱꞌᷔ鐤ਾ") + ucg.prettyCode() + a.d("敋ᳶ陮ࠑ菚Բ", 546202852, -1570831995) + ucg.fingerprint());
               grf = new gqu(a.b("ඳ琠ﻨ悂\ueb50淡힁广쀆䪑", 318377458));
               grg = new gqu(a.c(-674777803, "땣쳠䘡\ud84b厕"));
               grp(var1);
            } else if (var1 - grj > 300) {
               return grq(a.c(-1196166559, "\uf21a讪Ķ鼏ᓕ鉭⠾ꇌ㿜딫㋬좀䙕\udfa9喨퍎椈\ue6d4籿舘玀") + ucg.status() + a.d("鸃", 283720835, -189029727) + ucg.lastError());
            }
            break;
         case 2:
            if (grf.code != null && grg.code != null) {
               grf.send(a.b("\uef25雍᱈良ঠ載㔔볦⊹ꠌ⿁햵嬰슏䣒칢琡ﯻ慉\ue75f溰ᓹ", -488050872) + ucg.code() + a.d("藥ﰋ", 2039525003, -215471282));
               grf.send(a.b("鯙\ue231梴\uf693絜ﯵ䇨젚噅\udcf0嬽ꅉ⿌뙳㰮몞Ý輇ᖵ鎣ᩌ怅", 32283572) + grg.code + a.b("穕λ", -642024843));
               grp(var1);
            } else if (var1 - grj > 200) {
               return grq(a.c(121859461, "淤ᑀ麓õ謣ශ럕㸬ꁨ⪍괐坠\ud9f8䀊쩕䲯\uf6e1"));
            }
            break;
         case 3:
            if (!ucg.invites().isEmpty()) {
               ubg var8 = ucg.invites().get(0);
               grr(
                  var8.name.equals(a.c(-719603602, "렯솼䭴픞廌\ud87d戝\uebe3疚－")),
                  a.d("\ud81cꆪ⭡딏㻅롥ɳ诌ᖜ鼡\u18fa\ue2ce汝\uf5ed羸菱䌜쳄噳퀳姅⏐괥㛠낂㩑莯ඪ靁ᄝ髫摸\uee3a矜\uf1d7筮", -1238344263, 208897512) + var8.name + a.c(1902383877, "ጭ")
               );
               grr(var8.fingerprint.equals(ufw.fingerprint(grf.pub)), a.b("끰짆䌍\udd63嚩퀉樟\ue3a8緸\uf74e炔諧Ч鶔ៅ鄯⭧꒬㹋롗ㆬ䯨알庖\ud8e4刣", -313544701));
               grr(
                  grf.raw.stream().noneMatch(var0x -> var0x.contains(a.d("诿\uf26c碤\ue6ce洜\uebad凍\ud833䙊쳝", -1821868532, -131992142))),
                  a.b("뛥콃䖙\udbe5倪훂泟\ue525筩\uf1cb瘏谬ʨ鬋ᅎ韨ⷳꈾ㢀뺔㜭䵳쏌堕", 748664463)
               );
               grt(var0);
               grp(var1);
            } else if (var1 - grj > 200) {
               return grq(a.d("\uf383訳¯麗ᕇ鏮⦢ꁎ㸀듴㍦줄䟓\ude79吵틗梙", -358673776, -1787109012));
            }
            break;
         case 4:
            if (var1 - grj == 40) {
               grv(var0, a.b("諛\uf37b离\ue7cc氖\ueaf3僤\ud912䝕췻䨵끕", -1802204505));
               ucg.accept(ucg.invites().get(0));
            }

            if (var1 - grj > 40 && ucg.members().size() == 2 && ucg.secured()) {
               grr(ucg.leader().equals(grf.code), a.d("縲ޗ赟ጢ飾ṅꑒⷪ뎯㥍뻒䒪쩹反\ud99f役\ue568檵\uf056瘖\ufff2薥ଛ邓ᚧ鱸◗ꯟㅩ뜽㲅쉋䠀퇠垲", -673029832, 308617039));
               grf.sendStatus();
               grg.acceptPending();
               grp(var1);
            } else if (var1 - grj > 240) {
               return grq(a.c(578573897, "嘶⾂ꕗ㬡낸㙏谛ע鮸ᄀ雒泧\ue238篒\uf197睠촹䋯\ud84b帛ힵ") + ucg.secured() + a.c(-685454174, "첊"));
            }
            break;
         case 5:
            if (ucg.members().size() == 3 && var1 - grj == 30) {
               grg.sendStatus();
            }

            if (var1 - grj == 50) {
               ubm var7 = ucg.member(grf.code);
               grr(
                  var7 != null && a.b("誔\uf307秏\ue7a5汷\ueac6傦\ud958䜡춶", -141587755).equals(var7.name) && wlk.worldId().equals(var7.world),
                  a.d("盲བྷ薟ᯢ逾ᚅ겕┰물㇈또䱬슪嬐텊垿\uede1戱\uf8c6组\uf734走ϖ順ṿ铽ⴊꍚ㦫뿫㑓쪋䃀\ud920彲햇橘", 2088342378, 1091429851)
                     + (var7 != null ? var7.name : null)
                     + a.c(-988069135, "䋙")
               );
               grr(ucg.members().size() == 3, a.c(-739757558, "㉗䯔섕彿풡剑\ue848憼￥畓\uf28bࣻ虨ῑ") + ucg.members().size() + a.b("ৼ", 1381108180));
               grv(var0, a.b("ꐪ\udd8a坊줽䋧쐂縑\uf7e8榿\ue301擕麳ၥ", -1954634665));
               var0.setScreen(null);
               var0.options.getGuiScale().setValue(grm);
               var0.onResolutionChanged();
               gru(var0);
               Vec3d var3 = var0.player.getEntityPos();
               double var4 = Math.floor(var3.y);
               grf.mark(1, var3.x - 4.0, var4, var3.z + 14.0, 0, null);
               grf.mark(2, var3.x + 6.0, var4, var3.z + 22.0, 1, null);
               grf.mark(3, var3.x + 2.0, var4, var3.z - 30.0, 0, null);
               grf.world = wlk.worldId().toUpperCase(Locale.ROOT);
               grf.mark(4, grh.getX(), grh.getY(), grh.getZ(), 0, a.d("讜\uf206磞\ue6a7浤\uebf3凎\ud83c䙢", 1719492828, -972362996));
               grp(var1);
            }
            break;
         case 6:
            var0.player.setPitch(18.0F);
            var0.player.lastPitch = 18.0F;
            if (var1 - grj == 10) {
               grr(
                  ucg.marks().size() == 3,
                  a.d("珯੍胐Ẫ镯Ꮜꦉⁿ빴㒊덐䥧잤币퐗勭\ue8af杯\ufdd7箏\uf27c蠼ڎ鴛ᬩ釴⡔ꘜ㳳뫱ㄉ쿖䖌\udc79婾탇", 1782170486, 1166192782)
                     + ucg.marks().size()
                     + a.d("賩", -807549251, 1513704060)
               );
               grr(
                  ucg.marks().stream().allMatch(ucg::visible),
                  a.b("뱓엮伮텆媉\udc6b普\uef80燅ﭮ粶蛉ࠗ釯᮰鴈❀ꢜ㈠됳㷊䟟쥡势퓀帒\ue7b6槰\uf30c畇ﻬ(訾᎘闎ὤꂮ⫟객㖧뾶섆䭐쳡嘠\ud846憃\ueb32", 1617411086)
               );
               ucg.markKey();
            }

            if (var1 - grj == 25) {
               grv(var0, a.c(-95160246, "\uf831膑\u0b51锦Ỽ頙∊꯷㖻뼓㣘"));
            }

            if (var1 - grj == 40) {
               grr(grf.plainHas(a.c(-988628317, "뫊썷䦷ퟟ")), a.d("뜂캧䑯\uda12凎흵浢\ue4d7窉\uf03e矼趆͘髭Ⴏ陟ⱔꏊ㥣뼵㚐䲌숳姱\udf97", 336335244, -1404066063));
               grr(
                  grf.raw
                     .stream()
                     .filter(var0x -> var0x.contains(a.c(1277670447, "됈췶䜻\ud95e勌")))
                     .noneMatch(var0x -> var0x.contains(a.d("\uda87ꌺ⧺랒", -336331136, 2020680814))),
                  a.c(721917538, "阉\uefaf敵\ufb09烆\uf62e䰮엍宄텢图겎≛믿ㇵ띇ം苊ᡡ鸽៝涊\ue328磤ﺗ")
               );
               ucg.markKey();
            }

            if (var1 - grj == 41) {
               var0.player.setYaw(-25.0F);
               var0.player.lastYaw = -25.0F;
            }

            if (var1 - grj == 42) {
               ucg.markKey();
               ucg.markKey();
            }

            if (var1 - grj == 50) {
               grr(grf.plainHas(a.b("紽җ蹇်鯾ᵖ", 1298562382)), a.b("왽뿎㔊\uab6d₺Ꙙ᱄閴\u0ba5腛ڐﳸ牡\ueb9d懂\ue720嵶틬䠍칋䞴㷧덍⢏껦⑤鶞Ꮢ", -1228945903));
               grr(grf.plainHas(a.c(-1747119822, "ᄕ棭\ue277簞\uf7c2")), a.b("ﳤ蕞ྗ釱ᨨ鲐⚆꼧ㅺ믜㰙왨䣬턎孋\uddb1柤\ue861犖\uf4c2紺ݢ觓ሕ", 1623260312));
               grv(var0, a.b("㽌䛬찬剛\ud981彤\ue57e沊\uf2da硢ﾳו", 1582382896));
            }

            if (var1 - grj == 60) {
               grp(var1);
            }
            break;
         case 7:
            var0.player.setYaw(160.0F);
            var0.player.lastYaw = 160.0F;
            if (var1 - grj == 15) {
               grv(var0, a.d("舅ﮥ煥\uef12擈\ue22d堶퇆侚씩", 1530695197, -904917918));
               grf.send(a.b("彲⚚갟㈸맷㽞蕃\u0cbb鋠ᡆ龆新\ueb38", 525229828));
            }

            if (var1 - grj > 15 && ucg.members().size() == 2 && ucg.isLeader()) {
               grr(true, a.c(-444316058, "䘔㾱땹⬄ꃘ♣鱴ᗉ讟ĭ蛬糅\uf21e毸\ue1b9服\udd0e勖졡丵"));
               grp(var1);
            } else if (var1 - grj > 200) {
               return grq(a.b("絝ӥ踲ၔ鮐ᵤꝹ⺉냍㨨붨䟏줘傢", 1431141695));
            }
            break;
         case 8:
            if (grg.epoch == 2 && grg.keyBoxes > 0) {
               grr(true, a.b("俣㙠벡⋋ꤕ\u2fe5闱ᰈ艌ࢩ輮畃ﮙ扭\ue870溊퓗孑솩䟶츝됕㪮ꄲ❘궖ᐩ驳Ì蚏ധ\uf3ff秶\ue013晝\uecee却\ud950待", 13782935));
               var0.player.setYaw(30.0F);
               var0.player.lastYaw = 30.0F;
               grg.plain.clear();
               ucg.markKey();
               grp(var1);
            } else if (var1 - grj > 200) {
               return grq(a.c(552365243, "況ᕱ鿭ǎ討ಱ뛬㼁ꄇ⯷갣噀\ud886䄠쬡䶜\uf7da砏\ue2ab擩"));
            }
            break;
         case 9:
            if (grg.plainHas(a.d("漊ᚷ鱷ȟ", 999172139, -1508554936))) {
               grr(true, a.c(-348872756, "龺\ue639泸\uf292祌ﾼ䖫챛刂\ud8a2彺ꔂ⯑뉧㡧뻛Ҙ譚ᇰ鞹ḝ搛\ueab6煺\uf719綀쑧䨪탐囄\udd39⏣ꦾ〘똀㲿荴"));
               grr(!grf.keys.containsKey(2), a.c(-1090424186, "狐\u0b7d膣ᾗ鐆ኣ꣫№뽂㗹뉮䡈욀弶픪厗\ue9d1昃ﲢ窧\uf318襀ߡ鱣ᩒ邂⥾ꝡ㶝믞〺캠䓡\udd0c"));
               grg.keys.put(2, ufw.randomKey());
               grg.keyBoxes = 0;
               grg.plain.clear();
               Vec3d var6 = var0.player.getEntityPos();
               grg.mark(7, var6.x + 3.0, Math.floor(var6.y), var6.z + 9.0, 0, null);
               grp(var1);
            } else if (var1 - grj > 200) {
               return grq(a.b("ꀑ\ud992卓촹䛧쀗稇\uf3f4涤\ue75c惜髹ᑼ跚ލ腹㭲듦⹀ꠎ⇵宯핔亗", 14917722));
            }
            break;
         case 10:
            if (grg.keyBoxes > 0 && var1 - grj > 5 && var1 - grj < 100 && grg.lastMarkAt == 0) {
               grr(true, a.c(-1500163963, "僗⥯ꎸ㷌똚ゼ誽̜鵆៱逹橅\ue493給\uf761熌쯎䑚\udebb壱턈ꭖ◹빼㡈늗ସ蔰ᾓ駙ሥ\uec87曺９祑\uf3e9䱿왏䂛\ud938卶ⶐꞑ\u2068몲㓔赕ޱ臥ᨨ鑌溙\ue72b慿ﮏ痐칦䣲싌嬑햵꿽"));
               Vec3d var2 = var0.player.getEntityPos();
               grg.mark(8, var2.x - 3.0, Math.floor(var2.y), var2.z + 9.0, 0, null);
               grg.lastMarkAt = var1;
            }

            if (grg.lastMarkAt > 0 && var1 - grg.lastMarkAt == 20) {
               grr(ucg.marks().stream().anyMatch(var0x -> var0x.id == 8), a.b("燺ࡹ芸᳒霌ᇻ\uabfc≞뱌㛱넱䭙업尦홢傗\ueadd攉ﾹ秦\uf018訌Ӿ鼨᥅鎅⨡ꐢ㺁료㍲췦䟯\ude11塓", -139169398));
               grr(ucg.marks().stream().noneMatch(var0x -> var0x.id == 7), a.d("\ue80c醰᭴蕗ໂ衣㈭믘▉꼳⢮튒屉엫価줛猃ﳄ晥\ue067槔᎓鴽۳肌ੈ돺", 632354234, 858332613));
               var0.player.setYaw(55.0F);
               var0.player.lastYaw = 55.0F;
               ucg.markKey();
            }

            if (grg.lastMarkAt > 0 && var1 - grg.lastMarkAt == 40) {
               grr(grg.plainHas(a.d("ᔙ泣\ue63d砊", 564811536, 116539951)), a.c(1020107732, "鮜\ue21f棞\uf6b4絪ﮚ䆛졽嘦\udc92孖ꅴ\u2fec뙇㰓몰²软ᗏ鎇ᩨ恪\uee98畏\uf336积쁛"));
               grp(var1);
            } else if (var1 - grj > 200) {
               return grq(a.b("袜\uf123篬\ue5c4湞\ue8eb劢\udb4d䔞쾺䡾누㲛ꕤ⼶\ua9dcᏇ鱞۠肵ॏ猗ﶥ昰\ue047櫜퍢崤쟎䆉쩩", 2024442088) + grg.keyBoxes + a.b("疇", 1060926895));
            }
            break;
         case 11:
            ucg.leave();
            grf.close();
            grg.close();
            if (grh != null) {
               var0.world.removeEntity(grh.getId(), RemovalReason.DISCARDED);
            }

            if (grl == null) {
               System.clearProperty(a.d("\ue5e9鱒ᚂ裫\u0379藔㿙똹⡵ꋂ├\udf3a冱젗䉍쒱绦", -479145804, -1809107670));
            } else {
               System.setProperty(a.c(74375914, "\ue29d鬦ᇶ辟Ѝ芠㢭녍⼁ꖶ≨\ud84e囅콣䔹쏅禒"), grl);
            }

            ucg.reconnect();
            hyz.save();
            System.out.println(a.b("\uf444跤ܤ饓\u1289鑡\u2e66Ꞇ㧏덹㓾", -1321798593) + (grk == 0 ? a.c(-835032905, "棣ᅃ鮂׳") : a.c(-1602072281, "兤⣒ꈉ㱽럆") + grk));
            return true;
      }

      return false;
   }

   static void grp(int var0) {
      gri++;
      grj = var0;
   }

   static boolean grq(String var0) {
      grk++;
      grs(a.c(1838124791, "躴\uf702緙\ue3ad栖") + var0);
      gri = 11;
      return false;
   }

   static void grr(boolean var0, String var1) {
      if (!var0) {
         grk++;
      }

      grs((var0 ? a.d("\ue8df酪᯲", -677187390, -369747855) : a.d("ᶭ搛\ueec0炴\ufb0f", -1253918060, -1242126470)) + var1);
   }

   static void grs(String var0) {
      System.out.println(a.c(-1176557621, "➷帗퓗䪠셺䞒ﶕ瑵\uea3c悊\ue717ᵼ") + var0);
   }

   static void grt(MinecraftClient var0) {
      grm = var0.options.getGuiScale().getValue();
      var0.options.getGuiScale().setValue(1);
      var0.onResolutionChanged();

      try {
         Method var1 = hlc.class.getDeclaredMethod(a.c(-2092456402, "Ꙕ\udff3唱쭠䂂옰籊\uf595毖"), String.class);
         var1.setAccessible(true);
         var1.invoke(null, a.d("ᠩ憬\ueb64甙ﻅ硾숺", 348247764, -35336516));
      } catch (ReflectiveOperationException var2) {
         grs(a.c(261307740, "㴫䒘칄偼\udbf8崝\ue71e滶\uf0a3稚ﶂާ襬ა髆ᱣ\ua639⧫대㕋") + var2);
      }

      var0.setScreen(new hlc());
   }

   static void gru(MinecraftClient var0) {
      grh = new OtherClientPlayerEntity(var0.world, new GameProfile(UUID.randomUUID(), a.d("搵ᶯ靷ऎ苍њ빧㞕꧋", 1445288478, 869875303)));
      Vec3d var1 = var0.player.getEntityPos().add(5.0, 0.0, 11.0);
      grh.refreshPositionAndAngles(var1.x, var0.player.getY(), var1.z, 180.0F, 0.0F);
      var0.world.addEntity(grh);
   }

   static void grv(MinecraftClient var0, String var1) {
      ScreenshotRecorder.saveScreenshot(
         var0.runDirectory,
         a.c(331466319, "옯뾔㕄ꬭ₿ꘑ") + var1 + a.d("䀽㧒댟ⵧ", 983932876, 2032132059),
         var0.getFramebuffer(),
         1,
         var0x -> System.out.println("" + var0x.getString())
      );
   }
}
