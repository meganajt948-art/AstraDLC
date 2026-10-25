package a;

import flow.Flow;
import flow.dev.a;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.lang.reflect.Field;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.packet.c2s.play.ClickSlotC2SPacket;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInputC2SPacket;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket.Mode;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.server.network.ServerCommonNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.PlayerInput;
import net.minecraft.util.math.Vec3d;

final class fyl {
   static final int fym = 170;
   static final Set<Integer> fyn = ConcurrentHashMap.newKeySet();
   static final AtomicInteger fyo = new AtomicInteger();
   static final AtomicInteger fyp = new AtomicInteger();
   static final AtomicInteger fyq = new AtomicInteger();
   static final StringBuffer fyr = new StringBuffer();
   static volatile boolean fys;
   static volatile boolean fyt;
   static volatile boolean fyu;
   static int fyv;
   static int fyw;
   static int fyx;
   static int fyy;
   static double fyz;
   static Vec3d fza;
   static int fzb;
   static boolean fzc;

   fyl() {
   }

   static boolean tick(MinecraftClient var0, int var1) throws Exception {
      if (var1 == 1) {
         vzz.simulated = fyn::contains;
         kfe var2 = Flow.getInstance().getModuleManager().getByName(a.b("ﹿ蟼ള鍦ᢓ鸻⑻", -483525057));
         var2.setEnabled(true);
         kfe var3 = Flow.getInstance().getModuleManager().getByName(a.b("\uf724躡ѳ騙ᇲ靠ⴱꓛ㪃뀨", -115083409));
         if (var3 != null) {
            var3.setEnabled(false);
         }

         var0.getNetworkHandler().sendChatCommand(a.c(1970304928, "矖\u0e61蒾᫇鄘ឫ귳␃먙・뜮䵘쎋娥큩嚏\ueccd"));
         var0.getNetworkHandler().sendChatCommand(a.b("ገ檺\ue069縛\uf5ca獬쥫䃝\ude8c吢폢⧖ꝡ㻣듣㉀蠘ߟ鵶ᬽ鋍\ue889昵\ufde9箐\uf104䢡웶封\uda40凧꼢┹볎㪚뀻", 1362367305));
         var0.getNetworkHandler().sendChatCommand(a.d("ƕ砧\uf2f4沆\ue757懱\udbf6剀찑䚿셿㭋뗼Ȿ꙾⃜骁ᕅ迷ড聅度璯\uef78椆\ue399娼푫亜죝䍺붿㞤깓⠇ꊦ", -1219211482, -1724428558));
      }

      if (var1 == 5) {
         fzj(var0);
      }

      if (var1 < 10) {
         return false;
      } else {
         int var5 = var1 - 10;
         int var6 = var5 / 170;
         int var4 = var5 % 170;
         if (var6 >= 2) {
            vzz.simulated = null;
            System.out
               .println(
                  a.d("\ued5b铸ḷ聂\u0b97贿㝿뻋⃀ꩠⶥퟓ奐", 1133453017, 1659499496)
                     + (fzb == 0 ? a.b("퐺궚❛뤪", -1509763986) : a.c(1999730949, "祅ó訨ᑜ鿧ᥞ") + fzb + a.c(1527971416, "ﹰ"))
               );
            return true;
         } else {
            fzf(var0, var6 == 0, var4);
            return false;
         }
      }
   }

   static void fzf(MinecraftClient var0, boolean var1, int var2) {
      ClientPlayerEntity var3 = var0.player;
      String var4 = var1 ? a.c(-844494835, "ࡆ熞ﬂ敵\ueeb7栗툁宿엡众") : a.b("忖☍겑㋦뤤㾄薒బ鉺ᣋ齗", 1356554143);
      switch (var2) {
         case 0:
            fzi(var1);
            var0.getNetworkHandler().sendChatCommand(a.b("␃嶽흧䤒싖䐵︆矄", 288564328));
            var0.getNetworkHandler().sendChatCommand(a.b("\uef2a隆᱄舽ধ轄㔀볤⊧ꠛ⿊햽嬯싛䢃침琺ﯶ慈\ue740滗ᒵ驕ǌ螴ൾ듛㪉ꁭ♠귍匌\ud914䃻욵䰘\uf387离ｬ曚\uec8e鉹ᠻ龙Չ謪㊷롏㸇ꗍ⮿텥増\uded0䐡", 89255796));
            var0.getNetworkHandler()
               .sendChatCommand(a.b("ꕄ\udce8嘪졓䏉씪置\uf68a棉\ue275斤鿓ᅁ袵˭萆㹔놘⬦괮Ⓓ廛퀻䮢췚䜐ﺵ烧\uea03氎\ue7a2ᥢ鍺ક賛ٶ맩㏕딂Ⲵꛠ\ud817剕헷伧셄磙\uf236瑴\uefbe懋魎ዯ钼", -643652325));
            var0.getNetworkHandler()
               .sendChatCommand(a.c(-846622283, "釥\ue849抋ﳲ睨\uf18b䯏숫屨훔儅ꭲ◠바㙌낧\u0af5蔹ᾇ馏ဘ橺\ue49a缃糧玱쨔䑆\udea2墯팀ⷃ\ua7db㸴롺㋗赈ݴ膣᠕鉁\uecb6更\ue156箆\uf5e5䱸욜䃝\udb06啁꾣☗ꁎ㫺뒽ༀ"));
            var0.getNetworkHandler()
               .sendChatCommand(a.c(1143088105, "⎽娑탓亪씰䏓聯灳\uee30撌\ue35dᤪ鞸์萔˿뢭㝡귟⯗ꉀ\ud822囂쵛䬣쇩硌\uf61e泺\ueaf7慙龛ᖃ豬ਢ肏㼐딬㏻ꩍ’廮풬匎짞䞽︠瓈\uf28b楗\ue724᷻鑅ሂ裶ڼ봂㯘뇮⠩ꚜ"));
            var3.setYaw(var3.age * 37.0F % 360.0F);
            break;
         case 5:
            fyn.add(87);
            fyn.add(341);
            var0.options.forwardKey.setPressed(true);
            var0.options.sprintKey.setPressed(true);
            break;
         case 20:
            fyo.set(0);
            fyp.set(0);
            fyq.set(0);
            fyr.setLength(0);
            fyv = 0;
            fyw = 0;
            fyx = 0;
            fyy = 0;
            fyz = 0.0;
            fza = var3.getEntityPos();
            System.out
               .println(
                  a.d("渰ន鵜̩裼๔됔㶠", -1896455195, -2055926342)
                     + var4
                     + a.b("씖볥㘱ꡃ⎝ꔱή雁࣑艿ֹￃ煀\ue8eb拫\ue419幔톞䬪쵡䒋㻝끧⯬", 1946207534)
                     + var3.isSprinting()
                     + a.b("灛হ荼ᴚ雉ၫꨯ⏿붃㜰냸䪎쑃嶻", -662736779)
                     + wdt.serverSprinting(var3)
               );
            var0.setScreen(new InventoryScreen(var3));
            break;
         case 30:
            fzg(var0, 36, 0, SlotActionType.PICKUP);
            break;
         case 38:
            fzg(var0, 10, 0, SlotActionType.PICKUP);
            break;
         case 46:
            fzg(var0, 37, 0, SlotActionType.PICKUP);
            break;
         case 54:
            fzg(var0, 11, 0, SlotActionType.PICKUP);
            break;
         case 62:
            fzg(var0, 38, 0, SlotActionType.PICKUP);
            fzg(var0, 12, 0, SlotActionType.PICKUP);
            fzg(var0, 12, 0, SlotActionType.PICKUP);
            fzg(var0, 13, 0, SlotActionType.PICKUP);
            break;
         case 70:
            fyn.add(340);
            break;
         case 74:
            fzg(var0, 39, 0, SlotActionType.QUICK_MOVE);
            break;
         case 75:
            fzg(var0, 10, 0, SlotActionType.QUICK_MOVE);
            break;
         case 80:
            fyn.remove(340);
            break;
         case 86:
         case 87:
         case 88:
         case 89:
            fzg(var0, 11 + (var2 - 86) % 2, 0, SlotActionType.PICKUP);
            break;
         case 100:
            fyn.add(32);
            break;
         case 104:
            fzg(var0, 13, 1, SlotActionType.PICKUP);
            break;
         case 106:
            fzg(var0, 14, 0, SlotActionType.PICKUP);
            break;
         case 110:
            fyn.remove(32);
            break;
         case 120:
            if (!var3.currentScreenHandler.getCursorStack().isEmpty()) {
               fzg(var0, 15, 0, SlotActionType.PICKUP);
            }
            break;
         case 125:
            var3.closeHandledScreen();
            break;
         case 145:
            fyn.clear();
            var0.options.forwardKey.setPressed(false);
            var0.options.sprintKey.setPressed(false);
            break;
         case 160:
            fzh(var4, var1, var3);
      }

      if (var2 > 20 && var2 <= 125 && var0.currentScreen instanceof InventoryScreen) {
         fyw++;
         Vec3d var5 = var3.getEntityPos();
         fyz = fyz + Math.hypot(var5.x - fza.x, var5.z - fza.z);
         fza = var5;
         if (wdt.serverSprinting(var3)) {
            fyx++;
         }

         if (PlayerInput.DEFAULT.equals(vyn.lastSent(var3))) {
            fyy++;
         }
      }

      if (var2 == 131 && var0.currentScreen == null) {
         System.out
            .println(
               a.d("䓲㵑랞⧫ꈾ⒖黖ᝢ", -149613077, -1440067210)
                  + var4
                  + a.c(-390081916, "튲ꭂ↖뿵㐳늕\u0894脦ὶ闄ላ\ue86c曤ｏ畚\uf3a2䧰오岁\udac3匢⤪")
                  + var0.options.forwardKey.isPressed()
                  + a.c(1798920197, "堮⇌\uab1c㕯뺣㠕艜ர门ὐ飙")
                  + var3.isSprinting()
                  + a.b("势⭇ꆓ㿼됮㊞袄", -1664265576)
                  + vyn.lastSent(var3)
            );
      }
   }

   static void fzg(MinecraftClient var0, int var1, int var2, SlotActionType var3) {
      ClientPlayerEntity var4 = var0.player;
      var0.interactionManager.clickSlot(var4.currentScreenHandler.syncId, var1, var2, var3, var4);
      fyv++;
   }

   static void fzh(String var0, boolean var1, ClientPlayerEntity var2) {
      double var3 = fyw == 0 ? 0.0 : fyz / fyw * 20.0;
      System.out
         .println(
            a.d("嬕⊶\ua879㘌뷙㭱脱ࢅ", 935414950, 1024464860)
               + var0
               + a.b("떔찿䚯\ud8d1匃햸濣\ue60a砆\uf2fa甥轑Ƈ顮", 1423816096)
               + fyv
               + a.d("㹻䞙최匭\ud8f1帓", 601385455, 1102534578)
               + fyo.get()
               + a.b("期ử鐱\u0a43膈ܯ뵪㓕", 585066295)
               + fyp.get()
               + a.c(-1301177844, "騠\ue3c7椋\uf77c粨﨔䁒즾埧\udd57媙ꂦ")
               + fyq.get()
               + a.c(1451297089, "५炝臭搱\uefdb楗팎嫷쒰乏")
               + fyw
               + a.d("鸭\ue7cf洟\uf36c碠︖䑟춎召\ud957庌ꓥ⩼", 327794909, -1483043)
               + fyx
               + a.c(-697959434, "ﯝ舥ࣻ隂ᵜ鯜↲ꡉ㘞벷㬪")
               + fyy
               + String.format(a.d("ß礽\uf3ed涉\ue65e惮\udae4匍쵙䟴쁳㩄듑ⴭꜢ", 375287929, 1427206281), var3)
               + a.b("큊ꦸ⍽봋㛝끰ਾ莀", -495660958)
               + var2.currentScreenHandler.getCursorStack()
         );
      if (!fyr.isEmpty()) {
         System.out.println(a.d("䥺ベ먖④꾶⤞鍞\u1aea", 311087375, 58562586) + var0 + a.b("祽\u009a詖ᐡ鿵᥉ꌏ⫣뒺㸊맄䏼", 2126608721) + fyr);
      }

      if (fyo.get() != fyv || fyp.get() != 1) {
         fzb++;
         System.out.println(a.b("䲵㔖뿙↬꩹ⳑ隑ἥ", 1040207066) + var0 + a.d("觓\uf004竐\ue4a9潻\ue9a6厥\uda45䐘캡䥼댜㷌ꐮ⸱ꣃነ鵆ޡ膿ࡕ牖ﲡ条\ue11b毖퉠尻웎䂊쬨㗸", -1214472341, -1374546248));
      }

      if (var1) {
         if (fyq.get() != 0) {
            fzb++;
            System.out.println(a.c(-1702930156, "奻⃘ꨗ㑢뾷㤟荟૫") + var0 + a.b("\u1ad1挆\ue9d2瞫ﱹ窤삚䥓휕嶼\uda72\u202b껞㝸봶㯁膏ใ钣እ魊\ue101澫\uf472牉\uf8de䅧켻嗊", 955914988));
         }

         if (var3 < 4.0 || fyx < fyw * 0.7) {
            fzb++;
            System.out.println(a.c(-288621834, "滋茺৵鞀᱕髽₽꤉") + var0 + a.c(-419089244, "㒛䵌잘姡툳哮\ueee9會樂玢\uf422์肘ᤱ錵ᖍ꿅⁚몽㳰딊켞䇤\uda32展횗漯\ue164箈ﷄ發"));
         }
      } else if (fyq.get() == 0) {
         fzb++;
         System.out
            .println(
               a.d("幃⟠괯㍚뢏㸧葧ී", -2022943659, -1978791303)
                  + var0
                  + a.d("矈ฟ蓋᪲酠ួ궭\u2450먎ゥ띰䴜쏈娵퀴囂\uec96按里羪\uf64b豍ʰ饠ὐ闗ⱻꈬ㣘뺄㔢쯮䆧\ud857帙퓻欤\ue10f柋ﹼ琯ૃ肆ܶ鷶Ꮥꩄ⃥ꚷ㵢댟䧅쀣䙤", 148357246, 1315092384)
            );
      }
   }

   static void fzi(boolean var0) {
      kfe var1 = Flow.getInstance().getModuleManager().getByName(a.b("䗏㱌뚃⣖ꌣ▋鿋", 726156687));

      for (vmo var3 : var1.getSettings()) {
         if (var3 instanceof vkl var4 && var4.getName().equals(a.b("ﶬ萲\u0efb邗ᬉ鷕➾깖】몽㵆윕䧕큹娬\udcdc暎", -1766457860))) {
            var4.set(var0);
         }
      }
   }

   static void fzj(MinecraftClient var0) throws Exception {
      if (!fzc) {
         IntegratedServer var1 = var0.getServer();
         ServerPlayerEntity var2 = var1.getPlayerManager().getPlayer(var0.player.getUuid());
         ClientConnection var3 = null;

         for (Field var7 : ServerCommonNetworkHandler.class.getDeclaredFields()) {
            if (var7.getType() == ClientConnection.class) {
               var7.setAccessible(true);
               var3 = (ClientConnection)var7.get(var2.networkHandler);
            }
         }

         Channel var9 = null;

         for (Field var8 : ClientConnection.class.getDeclaredFields()) {
            if (Channel.class.isAssignableFrom(var8.getType())) {
               var8.setAccessible(true);
               var9 = (Channel)var8.get(var3);
            }
         }

         var9.pipeline()
            .addBefore(
               a.b("ញ温\ue4f8突\uf158矸춀䑆\uda10傮흷ⴎꏐ㩶", -947316745),
               a.d("⳿啄\udf94䇽쩯䲳\uf6cb缫\ue162比\uec2cᙰ颰ć識ප럭㠽ꊙ", -1162050249, 166242749),
               new ChannelInboundHandlerAdapter() {
                  public void channelRead(ChannelHandlerContext var1, Object var2x) throws Exception {
                     fyl.fzk(var2x);
                     super.channelRead(var1, var2x);
                  }
               }
            );
         fzc = true;
         System.out.println(a.b("优㚻뱴∁꧔⽼锼ᲈ芅ࠣ迶疋סּ拦\ue8b4湒푏寑셣䝼", 477777771) + var9.getClass().getSimpleName());
      }
   }

   static void fzk(Object var0) {
      if (var0 instanceof PlayerInputC2SPacket var1) {
         PlayerInput var3 = var1.input();
         fys = var3.forward() || var3.backward() || var3.left() || var3.right() || var3.jump();
         fyt = var3.sneak();
      } else if (var0 instanceof ClientCommandC2SPacket var2) {
         if (var2.getMode() == Mode.START_SPRINTING) {
            fyu = true;
         } else if (var2.getMode() == Mode.STOP_SPRINTING) {
            fyu = false;
         }
      } else if (var0 instanceof ClickSlotC2SPacket || var0 instanceof CloseHandledScreenC2SPacket) {
         if (var0 instanceof ClickSlotC2SPacket) {
            fyo.incrementAndGet();
         } else {
            fyp.incrementAndGet();
         }

         if (fys || fyt || fyu) {
            fyq.incrementAndGet();
            if (fyr.length() < 400) {
               fyr.append(a.c(-427077049, "剥⮯"))
                  .append(var0.getClass().getSimpleName())
                  .append(a.c(-330412030, "倪⧖ꌇ㵯뚧】詋Ϡ"))
                  .append(fys)
                  .append(a.d("궚푸庶샌䬟춤瞡", -1539528017, -32045294))
                  .append(fyt)
                  .append(a.c(-2105552321, "툗꯵℥뽖㒚눬ࡥ臝"))
                  .append(fyu)
                  .append(']');
            }
         }
      }
   }
}
