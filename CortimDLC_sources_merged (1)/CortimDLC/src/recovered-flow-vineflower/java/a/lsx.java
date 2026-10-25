package a;

import flow.dev.a;
import java.lang.StackWalker.Option;
import java.lang.StackWalker.StackFrame;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents;
import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents.AllowChat;
import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents.ModifyGame;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents.AfterRender;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents.BeforeRender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.ClientBossBar;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.gui.hud.PlayerListHud;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.client.render.state.WorldRenderState;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.item.ItemStack;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardDisplaySlot;
import net.minecraft.scoreboard.ScoreboardEntry;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.scoreboard.Team;
import net.minecraft.scoreboard.number.NumberFormat;
import net.minecraft.scoreboard.number.StyledNumberFormat;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;

public class lsx extends kfe {
   private static lsx lsy;
   private final vmu lsz = this.add(new vmu(a.d("\uf589谟ۆ颹ጫ闔⾈ꙵ㠢", 2089744475, 1544293789), a.b("ᮡ戺\ue8ea皃", -2001527837), 16));
   private final vkl lta = this.add(new vkl(a.c(-1965125330, "酣\ue8e6戮ﱓ瞏\uf134䭰싒峙홳冠"), false));
   private final vmu ltb = this.add(new vmu(a.d("㽅䛀찈創\ud9a9弒\ue556泳\uf2ab硔ﾈ\u05f5謪", -1788343796, 708654338), a.c(1923590349, "ꢍ턈寀얽乡죚"), 16));
   private static boolean ltc;
   private String ltd = "";
   private Pattern lte;
   private int ltf = -1;
   private final Map<UUID, Text> ltg = new HashMap<>();
   private static final StackWalker lth = StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE);
   private static Field[] lti;
   private static Field[] ltj;
   private static Field ltk;
   private static Comparator<ScoreboardEntry> ltl;
   private static final Map<Screen, Text> ltm = new WeakHashMap<>();

   public lsx() {
      super(
         a.c(-2116352962, "ѻ緥\uf73a楃\ue2a1搲\ude7c垖짘䍯쒫"),
         a.c(
            -244801339,
            "ꃞ\ud94e厐췠䘡샃竉\uf32e浫\ue7dd恜驣ᒳ贈ݓ膧㯧됺⺁ꢕ℧孥헅七졷䊨ﬄ畘\uefb8槾\ue208Ზ雘ཧ襭ϊ밇㙱냰⤒ꍝ\uddbd培큈䪔쒱絸\uf78a燎\uea16摰黹ᝂ酇\u0ba1藳㸂룟㋿ꬾ▅忉\ud82d剻첹䔆ｆ禡\uf3be氃\ue69e惠餳ᎊ跈ج聽㫘더\u2d29ꞎ⇂婠"
         ),
         kfa.MISC
      );
      lsy = this;
      this.ltb.visibleWhen(this.lta::get);
   }

   @Override
   protected void onEnable() {
      ltp();
   }

   @Override
   protected void onDisable() {
      this.ltt();
   }

   private static void ltp() {
      if (!ltc) {
         ltc = true;

         try {
            ClientReceiveMessageEvents.MODIFY_GAME.register((ModifyGame)(var0, var1x) -> protect(var0));
            ClientReceiveMessageEvents.ALLOW_CHAT.register((AllowChat)(var0, var1x, var2x, var3, var4) -> {
               lsx var5 = lsy;
               if (var5 != null && var5.isEnabled() && var5.ltq(var0.getString())) {
                  MinecraftClient var6 = MinecraftClient.getInstance();
                  Text var7 = var3 == null ? var0 : var3.applyChatDecoration(var0);
                  var6.inGameHud.getChatHud().addMessage(protect(var7));
                  return false;
               } else {
                  return true;
               }
            });
         } catch (Throwable var2) {
            System.out.println(a.c(571382688, "鯕\ue279梀\uf6f2紽\ufbc9䇵졹器\udcd6嬉ꅰ\u2fe2똃㱒몾ê輪ᖟ鏙᩠怫\ueedb甁\uf377禳쁔乍풽勬\ud95b➒궎㐪뉢㣜蜜ൺ计ሕ顇\ue6b5注\ueb50燘ﾳ") + var2);
         }

         try {
            ItemTooltipCallback.EVENT.register((ItemTooltipCallback)(var0, var1x, var2x, var3) -> ltu(var0, var3));
         } catch (Throwable var1) {
            System.out
               .println(a.d("7禛\uf362洐\ue6df怫\uda17厛춊䜴샫㪒됀ⷡꞰ⅜鬈ᓈ蹽࠻膂\ufbc9甮\ueee4梛\ue249寢햮佀쥁䊺뱬㘣꿖⧎ꌪ᳦隘ၜ觺έ絙\uf707炵\uea6c搔\udd98圳", 1439267683, 683375423) + var1);
         }
      }
   }

   public static Text protect(Text var0) {
      lsx var1 = lsy;
      if (var1 != null && var1.isEnabled() && var0 != null && var1.ltq(var0.getString())) {
         MutableText var2 = Text.empty();
         var0.visit((var2x, var3) -> {
            var2.append(Text.literal(var1.ltr(var3)).setStyle(var2x));
            return Optional.empty();
         }, Style.EMPTY);
         return var2;
      } else {
         return var0;
      }
   }

   public static String protect(String var0) {
      lsx var1 = lsy;
      return var1 != null && var1.isEnabled() && var0 != null ? var1.ltr(var0) : var0;
   }

   public static boolean active() {
      lsx var0 = lsy;
      return var0 != null && var0.isEnabled();
   }

   private boolean ltq(String var1) {
      Pattern var2 = this.lts();
      return var2 != null && var1 != null && var2.matcher(var1).find();
   }

   private String ltr(String var1) {
      Pattern var2 = this.lts();
      if (var2 != null && !var1.isEmpty()) {
         MinecraftClient var3 = MinecraftClient.getInstance();
         String var4 = var3.getSession() == null ? "" : var3.getSession().getUsername();
         Matcher var5 = var2.matcher(var1);
         StringBuilder var6 = null;

         while (var5.find()) {
            if (var6 == null) {
               var6 = new StringBuilder(var1.length());
            }

            String var7 = var5.group();
            String var8 = var7.equalsIgnoreCase(var4) ? this.lsz.get() : this.ltb.get();
            var5.appendReplacement(var6, Matcher.quoteReplacement(var8));
         }

         if (var6 == null) {
            return var1;
         }

         var5.appendTail(var6);
         return var6.toString();
      } else {
         return var1;
      }
   }

   private Pattern lts() {
      MinecraftClient var1 = MinecraftClient.getInstance();
      String var2 = var1.getSession() == null ? "" : var1.getSession().getUsername();
      int var3 = this.lta.get() ? hhf.version() : -2;
      if (!var2.equals(this.ltd) || var3 != this.ltf) {
         this.ltd = var2;
         this.ltf = var3;
         StringBuilder var4 = new StringBuilder(var2);
         if (this.lta.get()) {
            for (hhc var6 : hhf.all()) {
               var4.append('|').append(var6.name);
            }
         }

         String var11 = var4.toString();
         StringBuilder var12 = new StringBuilder();

         for (String var10 : var11.split(a.d("諵\uf364", -567073835, -1891718786))) {
            if (var10.length() >= 3) {
               if (var12.length() > 0) {
                  var12.append('|');
               }

               var12.append(Pattern.quote(var10));
            }
         }

         this.lte = var12.length() == 0
            ? null
            : Pattern.compile(
               a.d("Ứ李\ued9e珲\uf85f维쓋䵍팩委\ude50⑫ꪡ㌄뤱㿂藹\u0a29邍ᛙ", 117284702, 577339786) + var12 + a.b("잲븂㓆ꪩ℄ꞯᶐ鐖ੲ肏܋ﴰ珺\uea5f恪\ue699岢", -1442199670), 2
            );
      }

      return this.lte;
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      ClientPlayNetworkHandler var2 = var1.getNetworkHandler();
      if (var2 != null) {
         for (PlayerListEntry var4 : var2.getPlayerList()) {
            String var5 = var4.getProfile().name();
            if (this.ltq(var5)) {
               Text var6 = var4.getDisplayName();
               if (var6 == null || this.ltq(var6.getString())) {
                  this.ltg.putIfAbsent(var4.getProfile().id(), var6);
                  var4.setDisplayName(var6 == null ? Text.literal(this.ltr(var5)) : protect(var6));
               }
            }
         }
      }
   }

   private void ltt() {
      ClientPlayNetworkHandler var1 = this.mc.getNetworkHandler();
      if (var1 != null) {
         for (PlayerListEntry var3 : var1.getPlayerList()) {
            if (this.ltg.containsKey(var3.getProfile().id())) {
               var3.setDisplayName(this.ltg.get(var3.getProfile().id()));
            }
         }
      }

      this.ltg.clear();
   }

   private static void ltu(ItemStack var0, List<Text> var1) {
      lsx var2 = lsy;
      if (var2 != null && var2.isEnabled() && !var1.isEmpty()) {
         boolean var3 = false;

         for (Text var5 : var1) {
            if (var5 != null && var2.ltq(var5.getString())) {
               var3 = true;
               break;
            }
         }

         if (var3 && ltv()) {
            for (int var6 = 0; var6 < var1.size(); var6++) {
               var1.set(var6, protect((Text)var1.get(var6)));
            }
         }
      }
   }

   private static boolean ltv() {
      try {
         CodeSource var0 = lsx.class.getProtectionDomain().getCodeSource();
         return var0 == null ? true : lth.walk(var1x -> {
            boolean var2 = false;
            Iterator var3 = var1x.iterator();

            while (var3.hasNext()) {
               Class var4 = ((StackFrame)var3.next()).getDeclaringClass();
               if (var4 == ItemStack.class) {
                  var2 = true;
               } else if (var2) {
                  CodeSource var5 = var4.getProtectionDomain().getCodeSource();
                  return var5 == null || !var0.getLocation().equals(var5.getLocation());
               }
            }

            return true;
         });
      } catch (Throwable var1) {
         return false;
      }
   }

   public static void attach(Screen var0) {
      try {
         ScreenEvents.beforeRender(var0).register((BeforeRender)(var0x, var1, var2x, var3, var4) -> ltw(var0x, true));
         ScreenEvents.afterRender(var0).register((AfterRender)(var0x, var1, var2x, var3, var4) -> ltw(var0x, false));
      } catch (Throwable var2) {
      }
   }

   private static void ltw(Screen var0, boolean var1) {
      Field var2 = ltx();
      if (var2 != null) {
         try {
            if (!var1) {
               Text var6 = ltm.remove(var0);
               if (var6 != null) {
                  var2.set(var0, var6);
               }

               return;
            }

            lsx var3 = lsy;
            Text var4 = (Text)var2.get(var0);
            if (var3 != null && var3.isEnabled() && var4 != null && var3.ltq(var4.getString())) {
               ltm.put(var0, var4);
               var2.set(var0, protect(var4));
            }
         } catch (Throwable var5) {
         }
      }
   }

   private static Field ltx() {
      if (ltk == null) {
         for (Field var3 : Screen.class.getDeclaredFields()) {
            if (!Modifier.isStatic(var3.getModifiers()) && var3.getType() == Text.class) {
               var3.setAccessible(true);
               ltk = var3;
               break;
            }
         }
      }

      return ltk;
   }

   public static void bossBars(MinecraftClient var0, Runnable var1) {
      lsx var2 = lsy;
      if (var2 != null && var2.isEnabled()) {
         IdentityHashMap var3 = new IdentityHashMap();

         for (ClientBossBar var5 : pjn.of(var0).values()) {
            Text var6 = var5.getName();
            if (var6 != null && var2.ltq(var6.getString())) {
               var3.put(var5, var6);
               var5.setName(protect(var6));
            }
         }

         try {
            var1.run();
         } finally {
            var3.forEach(BossBar::setName);
         }
      } else {
         var1.run();
      }
   }

   public static void titles(MinecraftClient var0, Runnable var1) {
      if (lti == null) {
         lti = ltz(InGameHud.class);
      }

      lty(var0.inGameHud, lti, var1);
   }

   public static void playerList(MinecraftClient var0, Runnable var1) {
      if (ltj == null) {
         ltj = ltz(PlayerListHud.class);
      }

      lty(var0.inGameHud == null ? null : var0.inGameHud.getPlayerListHud(), ltj, var1);
   }

   private static void lty(Object var0, Field[] var1, Runnable var2) {
      lsx var3 = lsy;
      if (var3 != null && var3.isEnabled() && var0 != null && var1.length != 0) {
         Object[] var4 = new Object[var1.length];

         for (int var5 = 0; var5 < var1.length; var5++) {
            try {
               Text var6 = (Text)var1[var5].get(var0);
               if (var6 != null && var3.ltq(var6.getString())) {
                  var4[var5] = var6;
                  var1[var5].set(var0, protect(var6));
               }
            } catch (Throwable var16) {
            }
         }

         try {
            var2.run();
         } finally {
            int var8 = 0;

            while (true) {
               if (var8 >= var1.length) {
                  ;
               } else {
                  if (var4[var8] != null) {
                     try {
                        var1[var8].set(var0, var4[var8]);
                     } catch (Throwable var14) {
                     }
                  }

                  var8++;
               }
            }
         }
      } else {
         var2.run();
      }
   }

   private static Field[] ltz(Class<?> var0) {
      ArrayList var1 = new ArrayList();

      for (Field var5 : var0.getDeclaredFields()) {
         if (!Modifier.isStatic(var5.getModifiers()) && var5.getType() == Text.class) {
            try {
               var5.setAccessible(true);
               var1.add(var5);
            } catch (Throwable var7) {
            }
         }
      }

      return var1.toArray(new Field[0]);
   }

   public static boolean sidebar(DrawContext var0, MinecraftClient var1) {
      lsx var2 = lsy;
      if (var2 != null && var2.isEnabled() && var1.world != null && var1.player != null) {
         Scoreboard var3 = var1.world.getScoreboard();
         ScoreboardObjective var4 = null;
         Team var5 = var3.getScoreHolderTeam(var1.player.getNameForScoreboard());
         if (var5 != null) {
            ScoreboardDisplaySlot var6 = ScoreboardDisplaySlot.fromFormatting(var5.getColor());
            if (var6 != null) {
               var4 = var3.getObjectiveForSlot(var6);
            }
         }

         if (var4 == null) {
            var4 = var3.getObjectiveForSlot(ScoreboardDisplaySlot.SIDEBAR);
         }

         if (var4 == null) {
            return false;
         }

         NumberFormat var25 = var4.getNumberFormatOr(StyledNumberFormat.RED);
         List var7 = var3.getScoreboardEntries(var4).stream().filter(var0x -> !var0x.hidden()).sorted(lua()).limit(15L).toList();
         int var8 = var7.size();
         Text var9 = var4.getDisplayName();
         Text[] var10 = new Text[var8];
         Text[] var11 = new Text[var8];
         boolean var12 = var2.ltq(var9.getString());

         for (int var13 = 0; var13 < var8; var13++) {
            ScoreboardEntry var14 = (ScoreboardEntry)var7.get(var13);
            var10[var13] = Team.decorateName(var3.getScoreHolderTeam(var14.owner()), var14.name());
            var11[var13] = var14.formatted(var25);
            var12 |= var2.ltq(var10[var13].getString()) || var2.ltq(var11[var13].getString());
         }

         if (!var12) {
            return false;
         }

         TextRenderer var27 = var1.textRenderer;
         var9 = protect(var9);
         int var28 = var27.getWidth(var9);
         int var15 = var28;
         int var16 = var27.getWidth(a.c(1642204628, "෬瑇"));
         int[] var17 = new int[var8];

         for (int var18 = 0; var18 < var8; var18++) {
            var10[var18] = protect(var10[var18]);
            var11[var18] = protect(var11[var18]);
            var17[var18] = var27.getWidth(var11[var18]);
            var15 = Math.max(var15, var27.getWidth(var10[var18]) + (var17[var18] > 0 ? var16 + var17[var18] : 0));
         }

         var0.createNewRootLayer();
         byte var29 = 9;
         int var19 = var0.getScaledWindowHeight() / 2 + var8 * var29 / 3;
         int var20 = var0.getScaledWindowWidth() - var15 - 3;
         int var21 = var0.getScaledWindowWidth() - 3 + 2;
         int var22 = var19 - var8 * var29;
         var0.fill(var20 - 2, var22 - var29 - 1, var21, var22 - 1, var1.options.getTextBackgroundColor(0.4F));
         var0.fill(var20 - 2, var22 - 1, var21, var19, var1.options.getTextBackgroundColor(0.3F));
         var0.drawText(var27, var9, var20 + var15 / 2 - var28 / 2, var22 - var29, -1, false);

         for (int var23 = 0; var23 < var8; var23++) {
            int var24 = var19 - (var8 - var23) * var29;
            var0.drawText(var27, var10[var23], var20, var24, -1, false);
            var0.drawText(var27, var11[var23], var21 - var17[var23], var24, -1, false);
         }

         return true;
      } else {
         return false;
      }
   }

   private static Comparator<ScoreboardEntry> lua() {
      if (ltl == null) {
         for (Field var3 : InGameHud.class.getDeclaredFields()) {
            if (Modifier.isStatic(var3.getModifiers()) && Comparator.class.isAssignableFrom(var3.getType())) {
               try {
                  var3.setAccessible(true);
                  ltl = (Comparator<ScoreboardEntry>)var3.get(null);
               } catch (Throwable var5) {
               }
               break;
            }
         }

         if (ltl == null) {
            ltl = Comparator.comparing(ScoreboardEntry::value, Comparator.reverseOrder()).thenComparing(ScoreboardEntry::owner, String.CASE_INSENSITIVE_ORDER);
         }
      }

      return ltl;
   }

   public static void afterExtraction(WorldRenderState var0) {
      lsx var1 = lsy;
      if (var1 != null && var1.isEnabled() && var0 != null) {
         for (EntityRenderState var3 : var0.entityRenderStates) {
            if (var3.displayName != null && var1.ltq(var3.displayName.getString())) {
               var3.displayName = protect(var3.displayName);
            }

            if (var3 instanceof PlayerEntityRenderState var4 && var4.playerName != null && var1.ltq(var4.playerName.getString())) {
               var4.playerName = protect(var4.playerName);
            }
         }
      }
   }
}
