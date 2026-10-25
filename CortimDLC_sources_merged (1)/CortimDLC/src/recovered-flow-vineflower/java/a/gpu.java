package a;

import com.mojang.authlib.GameProfile;
import flow.Flow;
import flow.dev.a;
import java.awt.Color;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.MouseInput;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.option.NarratorMode;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.Entity.RemovalReason;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWKeyCallbackI;

final class gpu {
   private static final String[] gpv = new String[]{
      a.b("\ud83bꆾ⭬딆㻭롿Ȯ评ᖜ鼷", 304863344), a.c(536155090, "᎗樇\ue0f1线\uf570珜즻䁫\ude3d咁퍊"), a.c(2074543756, "ێ罂\uf580毹\ue013暚\udcd8唣쭦䇝옞")
   };
   private static String gpw;
   private static String gpx;
   private static double gpy;
   private static NarratorMode gpz;
   private static Object gqa;
   private static Entity gqb;
   private static float gqc;

   private gpu() {
   }

   static boolean tick(MinecraftClient var0, int var1) throws Exception {
      Screen var2 = var0.field_1755;
      kfx var3 = Flow.getInstance().getModuleManager();
      switch (var1) {
         case 1:
            gpw = iov.PRESET.get();
            gpx = iov.ACCENT.get();
            gqf(var0, a.b("䶢㐤뻼₇ꭑⷷ", 1573211638));
            break;
         case 30:
            gqt(var0, a.d("ጠ櫑\ue003繮\uf5e6獀줘䃣\udebd君", -1822503475, -853483881));
            break;
         case 31:
            gqm(var2, 330.0F, 200.0F, -14.0);
            break;
         case 50:
            gqt(var0, a.c(-708541587, "茌\ufafd瀬\uee42旊\ue36c头탏云쐷䎻릅㝟껵⒦ꉌ᠁"));
            break;
         case 51:
            gqf(var0, a.d("㔡䲬왲堋폔", 1594758315, -758701605));

            for (Object var31 : gqg(a.b("쀱릜㍂괻⛤ꁳᨂ鏠ඩ蜏", 1765982287))) {
               gqi(var31);
            }
            break;
         case 70:
            gqt(var0, a.c(-1969739727, "⡑冠\udb70䔟캑䠼\uf262箛\ue5cc漵\ue8adዕ鰁ָ迪च"));
            break;
         case 71:
            Object var22 = gqh(a.d("\u0cba甗\uffc9憰\uea6f泸횉彫섢䮄", 1488029648, -588084460), a.c(1464981453, "힂긅ⓐ몦ㅪ럙\u0dc7葢ᨡ邝ᝆ\ued3f"));
            gql(var2, gqq(var22, a.d("㌪", 1354136845, -1395110306)) + 30.0F, gqq(var22, a.d("뜗", 1103271034, -493018347)) + 12.0F, 0);
            break;
         case 90:
            gqt(var0, a.c(914011781, "뛺켋䗜\udbb4倭횊泟\ue529筭\uf1de癍豾ʶ鬒ᅊ"));
            break;
         case 91:
            Object var21 = gqj();
            gql(var2, gqq(var21, a.c(1038792006, "딿")) + 30.0F, gqq(var21, a.c(1900469402, "\udce2")) + 2.0F + 32.0F + 8.0F, 0);
            break;
         case 104:
            Object var20 = gqj();
            float var30 = gqq(var20, a.d("먀", 557677529, 1735311776));
            float var37 = gqq(var20, a.d("쬟", 1865184292, 2124201805));
            float var41 = gqq(var20, a.c(-461887444, "⡔")) + 2.0F + 48.0F + 4.0F;
            float var42 = var37 - 30.0F;
            gql(var2, var30 + var42 + 6.0F + 4.5F, var41 + 34.72F, 0);
            var2.method_25406(new Click(0.0, 0.0, new MouseInput(0, 0)));
            gql(var2, var30 + var42 * 0.55F, var41 + 40.32F, 0);
            var2.method_25406(new Click(0.0, 0.0, new MouseInput(0, 0)));
            gqk(a.d("㨙䎠쥸園\udccf婱\ue033槊\uf792紹\ufaed", -794702008, -1149962985), 15, -34215);
            break;
         case 122:
            gqt(var0, a.c(-1243937170, "؎翿\uf529歀\ue0d9晤\udc34嗆쮄䅪웱㲁뉛⯷ꆿ❓"));
            System.out
               .println(
                  a.c(-2038487157, "⟶幖풍䫻섶䟓\ufdd0琣\uea6b惌\ue709ᵩ鏷")
                     + iov.PRESET.get()
                     + a.d("㩽䎏쥞圼\udcfd娕", -1731730544, 510843339)
                     + gqs(iov.card)
                     + a.b("콩뚙㱈ꈹ⧨꽒ᔛ鲣", 2081279809)
                     + gqs(iov.accent())
               );
            break;
         case 123:
            ((vlv)gqo(iov.class, a.c(276722641, "玄ਤ胿ẉ镄"))).set(a.c(-185896915, "灦\u09ca茈"));
            gqk(a.d("࿏癣ﲡ拋\ue913澳헨尞쉛䣭", 238713769, -1026788316), 0, -14019520);
            gqk(a.b("⇑塽튿䳕윍䆭ﯶ爀\uec45曳", -264625773), 1, -5900);
            gqk(a.d("腾\uf8d2爐\uec7a枢\ue102孙튯䳪왜", -1265229535, 1049731101), 4, -10556716);
            break;
         case 140:
            gqt(var0, a.d("싢묓㇆꾬\u243eꊒᣐ酨ཹ藄Ȕ\uf866皬\uef1c攑\ue3a0姧혽䲕", -1420103590, -1746390309));
            break;
         case 141:
            var0.method_1507(null);
            break;
         case 160:
            gqt(var0, a.c(-237381433, "\ud8a4ꅕ⮁뗪㹸룔ʖ謮ᔿ龂ᡒ\ue220泪\uf55a罗溺䎥챸囃"));
            System.out
               .println(
                  a.d("⤏傯\uda74䐂쿏䤪\uf334竍\ue499渳\ue9b5ᎇ鵜Ӯ躾ࡕ눝㷍ꜭℳ\ua8de튎尺쟱䆃쭓犥ﲠ晋\ue017毡镘Ἂ蛪Ç詬㗬뾃㥗ꃬ⪸呑\ude48", -1941230849, 440730539)
                     + gqs(iov.window)
                     + a.b("輮\uf6de簏\ue27e榯\uef15啜\udce4", 263753478)
                     + gqs(iov.accent())
               );
            break;
         case 161:
            for (String var40 : new String[]{gpv[0], gpv[1]}) {
               var3.getByName(var40).toggle();
            }
            break;
         case 170:
            gqt(var0, a.c(1308651422, "濠ᘑ鳊ʮ褵ྉ뗓㰵ꉬ⣚꽗啿\udbab䈂"));
            break;
         case 171:
            var3.getByName(gpv[2]).toggle();
            break;
         case 180:
            gqt(var0, a.c(-1769408246, "索肛ੁ鐤᾿餃⍙꪿㓦빐㧝쏵䴾풕廑\ud820"));
            break;
         case 185:
            long var18 = var0.method_22683().method_4490();
            GLFWKeyCallback var35 = GLFW.glfwSetKeyCallback(var18, null);
            GLFW.glfwSetKeyCallback(var18, var35);
            gpz = (NarratorMode)var0.field_1690.method_42476().method_41753();
            var35.invoke(var18, 66, 48, 1, 2);
            var35.invoke(var18, 66, 48, 0, 2);
            break;
         case 190:
            gqa = var0.field_1690.method_42476().method_41753();
            long var17 = var0.method_22683().method_4490();
            GLFWKeyCallbackI var34 = (GLFWKeyCallbackI)gqo(wek.class, a.c(-99010379, "㣒䅾쮶嗉\ude10墦\ue2fa欆"));
            var34.invoke(var17, 66, 48, 1, 2);
            var34.invoke(var17, 66, 48, 0, 2);
            break;
         case 195:
            Object var16 = var0.field_1690.method_42476().method_41753();
            var0.field_1690.method_42476().method_41748(gpz);
            System.out
               .println(
                  a.b("蹢\uf7c2紙\ue36f梢\uee47呗\uddb1䏨쥇仓듫㩤ꏏ⧒꼬ᕰ骡\u0001虅ྩ痥ﬄ", 2110426629)
                     + gpz
                     + a.b("㲛䔦쾴凂\uda07岧\ue6e3潀\uf17c篺ﰯـ裐ᄈ鬹", -1484440392)
                     + gqa
                     + a.c(1968977813, "㞯丒쒆嫱턪垓\ued85搷頻烖\uf705ൺ莮\u1a1d遆\u16fc곲⌮릞㿎똲찦")
                     + var16
                     + a.b("Ҙ紡\uf7b4槊\ue20e撿\udeff圛쥟䏳쑲㹂낂⤤ꍿ▋鿉ရ誦\u0cfe蕑", 596247725)
                     + var0.method_44713().method_1791()
                     + a.b("\uf184蠹ʢ鳔\u1718醶⯫ꈆ㰀뛾ㄲ쭇䖍\udc3a器탊", 1499525560)
                     + var0.field_1690.method_53530().method_41753()
                     + a.c(-2146941349, "䙳")
               );
            System.out.println(a.b("謽\uf29d硆\ue630淽\ueb18儛\ud8fb䚰찇䯂놙㽯\ua6fcⲌꩡဩ鿊Ր茍૬炻﹆", 2048428890) + var0.field_1690.field_1837);
            var0.method_15995(false);
            break;
         case 225:
            System.out
               .println(
                  a.b("ꢓ턳寨얞乓좶犣ﭛ攈\uefaf桺鉘᳃蕱༾览㏓밓⚿ꃵ⤗匕\uddef䘤쀈䫉\uf36b紭\ue7da憀\uea60", 1248372988)
                     + (var0.field_1755 == null ? a.d("居◵꼧ㅝ", -1992056527, 1063845150) : var0.field_1755.getClass().getSimpleName())
               );
            var0.method_15995(true);
            break;
         case 230:
            gqt(var0, a.d("喃ⱳꚡ㣍덖㗪辰ٖ頏ኹ锴漏\ue1d0硠\uf238", -2000150747, -1730065703));
            break;
         case 231:
            kfe var15 = var3.getByName(a.b("顺\ue1e4欲\uf54f纓\uf838䉌쮁嗄\udf6e墷ꋑ", 420911157));
            var15.setEnabled(true);
            gpy = (Double)var0.field_1690.method_45578(SoundCategory.field_15250).method_41753();
            var0.field_1690.method_45578(SoundCategory.field_15250).method_41748(0.0);
            Files.write(vpo.dir().resolve(a.b("薎ﰒ盖\ue8ba挬\ue5c4征홧", 1410827726)), gqn(660.0, 0.4));
            vpo.scan();
            break;
         case 232:
         case 238:
         case 244:
         case 250:
         case 256:
         case 262:
         case 268:
            int var14 = (var1 - 232) / 6;
            String[] var28 = new String[]{
               a.c(-154676651, "툟ꮈ⅒뼪㓫뉝ࠓ自Ᾰ"),
               a.c(966350796, "垟⸍꓀㪶녤㟒趈"),
               a.c(-1394751329, "죛녝㮙ꗨ⸱ꢉ"),
               a.c(487994317, "㎇䨐샊庲핳叅\ue98b恲︠"),
               a.c(895871449, "\ue98a逘\u1ad5蒣ཱ觇㎝"),
               a.b("쓍뵋㞏ꧾ∧꒟", 1311753353),
               a.c(835843764, "\uf6fe轩ֳ鯋ည隼Ⳳꔋ㭙")
            };
            voa.play(var28[var14], var14 % 2 == 0, 0.6F);
            break;
         case 235:
         case 241:
         case 247:
         case 253:
         case 259:
         case 265:
         case 271:
         case 277:
            System.out
               .println(
                  a.c(-1210629745, "䇫㡋느⳦ꜫ⇎鯎ሣ豦ی脕笠\uf5ff氋\ue654悷\udaff唿쾛䦘")
                     + var0.field_1690.method_45578(SoundCategory.field_15250).method_41753()
                     + a.d("୴狖\uf81f", 1899963230, 360458240)
                     + voa.report()
               );
            break;
         case 274:
            voa.play(a.b("绻ݧ趣Ꮟ", -786923849), true, 0.6F);
            System.out
               .println(
                  a.b("洢ᒂ鹙/询ഇ뜇㻪ꂯ⨅규埩\ud978䃆쪐䱨\uf631禩\ue300", -892179135)
                     + vpo.extras()
                     + a.d("㮰䉕좝囤\udd33安\ue1d3桧\uf674糀\ufb09ſ迦ᙍ", -5785692, 1836813370)
                     + ((vlv)gqr(var3.getByName(a.c(-1472115067, "今㝔붂⏿ꠣ⺈铼ᴱ荴\u09de踇瑡")), a.c(-143748775, "鄋\ue881扚ﰫ矷\uf14f"))).getModes()
               );
            break;
         case 280:
            var0.field_1690.method_45578(SoundCategory.field_15250).method_41748(gpy);
            var0.field_1724.method_5673(EquipmentSlot.field_6173, new ItemStack(Items.field_8802));
            float var13 = var0.field_1724.method_36454();
            Vec3d var27 = Vec3d.method_1030(0.0F, var13 + 180.0F).method_1021(3.0);
            OtherClientPlayerEntity var33 = new OtherClientPlayerEntity(
               var0.field_1687, new GameProfile(UUID.randomUUID(), a.d("앚볌㘒ꡢ⎲ꔉ", -431405035, 1883147531))
            );
            var33.method_5808(
               var0.field_1724.method_23317() + var27.field_1352,
               var0.field_1724.method_23318(),
               var0.field_1724.method_23321() + var27.field_1350,
               var13,
               0.0F
            );
            var0.field_1687.method_53875(var33);
            gqb = var33;
            kfe var39 = var3.getByName(a.b("樄\u139d饊ܗ賲\u0a43뀊㧡ꞹ", 97086028));
            ((vmc)gqr(var39, a.c(1812985404, "\uf679迁ԋ"))).set(360.0);
            var39.setEnabled(true);
            gqc = var13;
            break;
         case 330:
            Vec3d var12 = gqb.method_73189().method_1020(var0.field_1724.method_73189());
            double var26 = Math.toDegrees(Math.atan2(var12.field_1350, var12.field_1352)) - 90.0;
            double var38 = Math.abs(MathHelper.method_15338(var26 - var0.field_1724.method_36454()));
            double var9 = Math.abs(MathHelper.method_15338(var26 - gqc));
            System.out
               .println(
                  a.c(-1078022794, "괈풨平쀅䯈촭眿ﻆ悝\uea72涤韓ᤎ肥")
                     + Math.round(var9)
                     + a.c(1905824567, "鎉\ueaa8怴﹌疛\uf36c䥽삋廗푯厡꧇❙뻤")
                     + Math.round(var38)
                     + a.d("옴뼕㖉꯱…ꛑ᳃锵\u0b78臘\u061cﰿ狺\ueb57感\ue7fb巧퉥䣞컁䜿㵢돇⠐깹⒩鵃", 1102463177, 312116822)
                     + var0.method_1569()
                     + a.c(-795068820, "㙐俭약嬚탊噺\uec35旙ﯔ焩\uf6f9಄艛ᯤ醶\u171e")
                     + var0.field_1729.method_1613()
                     + a.c(1702414066, "웚")
               );
            gqt(var0, a.d("뭿슏䡜혱嶪\udb13慄\ue8eb皱ﰆ", -673350509, -618477674));
            break;
         case 331:
            kfe var11 = var3.getByName(a.c(244368731, "씓벊㙝ꠀ⏥ꕔἝ零ࢮ"));
            var11.setEnabled(false);
            ((vmc)gqr(var11, a.d("٥翝\uf517", -1530284642, 1256108990))).reset();
            if (gqb != null) {
               var0.field_1687.method_2945(gqb.method_5628(), RemovalReason.field_26999);
            }

            for (String var8 : gpv) {
               var3.getByName(var8).toggle();
            }

            vlv var25 = (vlv)gqo(iov.class, a.c(-1369982333, "뫖썶䦭ퟛ尖"));
            Method var32 = iov.class.getDeclaredMethod(a.d("ᜪ溌\ue449種\uf1e8睮촋䓼\udaa4倎ퟟ", -2095351634, 35549181));
            var32.setAccessible(true);
            var25.set(a.d("摢᷎霌", -1914647647, 428519304));
            var32.invoke(null);
            var25.set(a.d("闏\uec56暎\uf8e4", 504480369, 1749178359));
            var32.invoke(null);
            iov.PRESET.set(gpw);
            iov.ACCENT.set(gpx);
            hyz.save();
            break;
         case 332:
            gqf(var0, a.c(1823932915, "ƺ砯\uf2e6沇"));
            break;
         case 334:
            Object var4 = ((Map)gqo(hlc.class, a.b("蜥ﺖ瑖\uea31懱", -1257666717))).get(var3.getByName(a.c(144768215, "ﲘ蔆࿐醭ᩱ鳚⚮꽣ㄦ뮌㱕옳")));
            Field var5 = var4.getClass().getDeclaredField(a.d("ϕ穨\uf0b8滉\ue513掳\ud9e3倄칚", 1160585272, 451421063));
            var5.setAccessible(true);
            var5.setBoolean(var4, false);
            break;
         case 350:
            gqt(var0, a.d("\ue79a鹪ᒺ諔ō蟳㶥둘⨌ꂧ✭\udd02叉쩢䀪웑粉", 1735798482, -1837971159));
            break;
         case 351:
            var0.method_1507(null);
            Files.deleteIfExists(vpo.dir().resolve(a.b("曒\u1f4e閊௦聰ژ볝㔻", -94214510)));
            vpo.scan();
            break;
         case 360:
            return true;
      }

      return false;
   }

   private static void gqf(MinecraftClient var0, String var1) throws Exception {
      ((Map)gqo(hlc.class, a.d("큓꧲⌰뵜㚈뀹ੵ", -2023371267, -579789318))).clear();

      for (String var5 : new String[]{a.b("⟙并풢䫙섅䞬\ufdd0", 32712617), a.b("蕟ﳰ瘤\ue85f掃\ue52a彗", 98796847)}) {
         Field var6 = hlc.class.getDeclaredField(var5);
         var6.setAccessible(true);
         var6.setFloat(null, Float.NaN);
      }

      Field var7 = hlc.class.getDeclaredField(a.c(-882047409, "ؽ羙\uf549欑\ue0e8晅"));
      var7.setAccessible(true);
      var7.set(null, var1);
      var0.method_1507(new hlc());
   }

   private static List<?> gqg(String var0) throws Exception {
      return (List<?>)gqo(hlc.class, var0);
   }

   private static Object gqh(String var0, String var1) throws Exception {
      for (Object var3 : gqg(var0)) {
         if (var1.equals(gqp(var3, a.d("尥▉꽇ㄮ뫰", 1102343416, 1941385388)))) {
            return var3;
         }
      }

      throw new IllegalStateException(a.d("\ufada荪৶韄ᰑ骳\u20f6ꥃ", 1569691067, 1720217351) + var1);
   }

   private static void gqi(Object var0) throws Exception {
      Field var1 = var0.getClass().getDeclaredField(a.c(-1359154353, "\uf325誘H鸹ᗣ鍃⤓ꃴ㺪"));
      var1.setAccessible(true);
      var1.setBoolean(var0, true);
      Object var2 = gqp(var0, a.b("푀귬✷륗㊏됴", -1236610013));
      var2.getClass().getMethod(a.c(2013756832, "緐ѷ躵"), float.class).invoke(var2, 0.0F);
   }

   private static Object gqj() throws Exception {
      for (Object var1 : (List)gqp(gqh(a.c(-301995437, "\uea2d鎀ᥞ蜧\u0cf8詯〞맼➵괓"), a.c(53910478, "鮁\ue206棓\uf6a5絩ﯚ䇄졡嘢\udc9e孅ꄼ")), a.c(1447823760, "০灊嬨擴"))) {
         if (var1.getClass().getSimpleName().equals(a.c(1578460042, "揀ᩝ邍\u0eff蔵΅맷〻깼"))) {
            return var1;
         }
      }

      throw new IllegalStateException(a.b("滞ᝮ鷲π蠛ຩ듹㴒ꍊ⧺깺呙\uda93䌺", -1101566274));
   }

   private static void gqk(String var0, int var1, int var2) throws Exception {
      Object var3 = Array.get(gqo(iov.class, var0), var1);
      float[] var4 = Color.RGBtoHSB(var2 >> 16 & 0xFF, var2 >> 8 & 0xFF, var2 & 0xFF, null);
      Method var5 = iov.class
         .getDeclaredMethod(a.d("㦺䀝쫟咊\udf6c姕\ue381橪", -1934536655, 2139384304), var3.getClass(), int.class, float.class, float.class, float.class);
      var5.setAccessible(true);
      var5.invoke(null, var3, var2, var4[0], var4[1], var4[2]);
   }

   private static void gql(Screen var0, float var1, float var2, int var3) throws Exception {
      float var4 = gqq(var0, a.c(1598578063, "巧\u244b꺃ー묥㶓蟶"));
      float var5 = gqq(var0, a.d("崦⒊깂〽믤㵒蜶", -924067320, 1131251526));
      float var6 = gqq(var0, a.d("啧Ⳇꘗ㡫뎵", -161907536, -1335088735));
      var0.method_25402(new Click(var4 + var1 * var6, var5 + var2 * var6, new MouseInput(var3, 0)), false);
   }

   private static void gqm(Screen var0, float var1, float var2, double var3) throws Exception {
      float var5 = gqq(var0, a.c(-1251054510, "氺ᖖ齞ġ諸\u0c4e똫"));
      float var6 = gqq(var0, a.b("뉷쯛䄓\udf6c咵툃桧", 1314304543));
      float var7 = gqq(var0, a.b("\uf0ee襏Ξ鷢ᘼ", -331157352));
      var0.method_25401(var5 + var1 * var7, var6 + var2 * var7, 0.0, var3);
   }

   private static byte[] gqn(double var0, double var2) {
      char var4 = '뮀';
      int var5 = (int)(var4 * var2);
      ByteBuffer var6 = ByteBuffer.allocate(44 + var5 * 2).order(ByteOrder.LITTLE_ENDIAN);
      var6.put(a.d("\u20ce奤편䷉", 31118921, -927402287).getBytes()).putInt(36 + var5 * 2).put(a.b("毂ብ颡ۃ", -480351343).getBytes());
      var6.put(a.c(1421371797, "槷၍骇Ң").getBytes())
         .putInt(16)
         .putShort((short)1)
         .putShort((short)1)
         .putInt(var4)
         .putInt(var4 * 2)
         .putShort((short)2)
         .putShort((short)16);
      var6.put(a.b("㡋䇿쬹啝", 1806907435).getBytes()).putInt(var5 * 2);

      for (int var7 = 0; var7 < var5; var7++) {
         var6.putShort((short)(Math.sin((Math.PI * 2) * var0 * var7 / var4) * 12000.0 * (1.0 - (double)var7 / var5)));
      }

      return var6.array();
   }

   private static Object gqo(Class<?> var0, String var1) throws Exception {
      Field var2 = var0.getDeclaredField(var1);
      var2.setAccessible(true);
      return var2.get(null);
   }

   private static Object gqp(Object var0, String var1) throws Exception {
      for (Class var2 = var0.getClass(); var2 != null; var2 = var2.getSuperclass()) {
         try {
            Field var3 = var2.getDeclaredField(var1);
            var3.setAccessible(true);
            return var3.get(var0);
         } catch (NoSuchFieldException var4) {
         }
      }

      throw new NoSuchFieldException(var1);
   }

   private static float gqq(Object var0, String var1) throws Exception {
      return ((Number)gqp(var0, var1)).floatValue();
   }

   private static vmo gqr(kfe var0, String var1) {
      for (vmo var3 : var0.getSettings()) {
         if (var3.getName().equals(var1)) {
            return var3;
         }
      }

      throw new IllegalStateException(a.d("ش羄\uf518欺\ue0fb晛\udc08嗤쮼䄄욐", 929969473, 2026582800) + var1);
   }

   private static String gqs(int var0) {
      return String.format(a.d("ㅉ䣭숶尧", -2062390563, 916675509), var0);
   }

   private static void gqt(MinecraftClient var0, String var1) {
      System.out
         .println(a.d("䑲㷕뜏⥴ꋥ␀鹂ឥ觽̘", 1518544043, -8626016) + var1 + a.d("棺ᄫ鮘", -383990543, -261837784) + var0.method_47599() + a.b("늨쭟䆚\udfe8", 715305612));
      ScreenshotRecorder.method_22690(
         var0.field_1697,
         a.b("晴莩ॹ霐ᲂ騬", 1393293938) + var1 + a.c(1472288848, "塺↕ꭘ㔠"),
         var0.method_1522(),
         1,
         var0x -> System.out.println("" + var0x.getString())
      );
   }
}
