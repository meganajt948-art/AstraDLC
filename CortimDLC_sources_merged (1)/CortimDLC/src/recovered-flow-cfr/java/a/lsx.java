/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback
 *  net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents
 *  net.fabricmc.fabric.api.client.screen.v1.ScreenEvents
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.font.TextRenderer
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.hud.ClientBossBar
 *  net.minecraft.client.gui.hud.InGameHud
 *  net.minecraft.client.gui.hud.PlayerListHud
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.network.ClientPlayNetworkHandler
 *  net.minecraft.client.network.PlayerListEntry
 *  net.minecraft.client.render.entity.state.EntityRenderState
 *  net.minecraft.client.render.entity.state.PlayerEntityRenderState
 *  net.minecraft.client.render.state.WorldRenderState
 *  net.minecraft.entity.boss.BossBar
 *  net.minecraft.item.ItemStack
 *  net.minecraft.scoreboard.AbstractTeam
 *  net.minecraft.scoreboard.Scoreboard
 *  net.minecraft.scoreboard.ScoreboardDisplaySlot
 *  net.minecraft.scoreboard.ScoreboardEntry
 *  net.minecraft.scoreboard.ScoreboardObjective
 *  net.minecraft.scoreboard.Team
 *  net.minecraft.scoreboard.number.NumberFormat
 *  net.minecraft.scoreboard.number.StyledNumberFormat
 *  net.minecraft.text.MutableText
 *  net.minecraft.text.StringVisitable
 *  net.minecraft.text.Style
 *  net.minecraft.text.Text
 *  net.minecraft.util.Formatting
 */
package a;

import a.hhc;
import a.hhf;
import a.kfa;
import a.kfe;
import a.pjn;
import a.vkl;
import a.vmu;
import flow.dev.a;
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
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
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
import net.minecraft.scoreboard.AbstractTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardDisplaySlot;
import net.minecraft.scoreboard.ScoreboardEntry;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.scoreboard.Team;
import net.minecraft.scoreboard.number.NumberFormat;
import net.minecraft.scoreboard.number.StyledNumberFormat;
import net.minecraft.text.MutableText;
import net.minecraft.text.StringVisitable;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class lsx
extends kfe {
    private static lsx lsy;
    private final vmu lsz = this.add(new vmu(a.d("\uf589\u8c1f\u06c6\u98b9\u132b\u95d4\u2f88\ua675\u3822", 2089744475, 1544293789), a.b("\u1ba1\u623a\ue8ea\u7683", -2001527837), 16));
    private final vkl lta = this.add(new vkl(a.c(-1965125330, "\u9163\ue8e6\u622e\ufc53\u778f\uf134\u4b70\uc2d2\u5cd9\ud673\u51a0"), false));
    private final vmu ltb = this.add(new vmu(a.d("\u3f45\u46c0\ucc08\u5275\ud9a9\u5f12\ue556\u6cf3\uf2ab\u7854\uff88\u05f5\u8b2a", -1788343796, 708654338), a.c(1923590349, "\ua88d\ud108\u5bc0\uc5bd\u4e61\uc8da"), 16));
    private static boolean ltc;
    private String ltd = "";
    private Pattern lte;
    private int ltf = -1;
    private final Map<UUID, Text> ltg = new HashMap<UUID, Text>();
    private static final StackWalker lth;
    private static Field[] lti;
    private static Field[] ltj;
    private static Field ltk;
    private static Comparator<ScoreboardEntry> ltl;
    private static final Map<Screen, Text> ltm;
    private static /* synthetic */ int ltn;
    private static /* synthetic */ int lto;

    public lsx() {
        super(a.c(-2116352962, "\u047b\u7de5\uf73a\u6943\ue2a1\u6432\ude7c\u5796\uc9d8\u436f\uc4ab"), a.c(-244801339, "\ua0de\ud94e\u5390\ucde0\u4621\uc0c3\u7ac9\uf32e\u6d6b\ue7dd\u605c\u9a63\u14b3\u8d08\u0753\u81a7\u3be7\ub43a\u2e81\ua895\u2127\u5b65\ud5c5\u4e03\uc877\u42a8\ufb04\u7558\uefb8\u69fe\ue208\u1c96\u96d8\u0f67\u896d\u03ca\ubc07\u3671\ub0f0\u2912\ua35d\uddbd\u57f9\ud048\u4a94\uc4b1\u7d78\uf78a\u71ce\uea16\u6470\u9ef9\u1742\u9147\u0ba1\u85f3\u3e02\ub8df\u32ff\uab3e\u2585\u5fc9\ud82d\u527b\uccb9\u4506\uff46\u79a1\uf3be\u6c03\ue69e\u60e0\u9933\u138a\u8dc8\u062c\u807d\u3ad8\ub354\u2d29\ua78e\u21c2\u5a60"), kfa.MISC);
        lsy = this;
        this.ltb.visibleWhen(this.lta::get);
    }

    @Override
    protected void onEnable() {
        lsx.ltp();
    }

    @Override
    protected void onDisable() {
        this.ltt();
    }

    private static void ltp() {
        if (ltc) {
            return;
        }
        ltc = true;
        try {
            ClientReceiveMessageEvents.MODIFY_GAME.register((text, bl) -> lsx.protect(text));
            ClientReceiveMessageEvents.ALLOW_CHAT.register((text, signedMessage, gameProfile, parameters, instant) -> {
                lsx lsx2 = lsy;
                if (lsx2 == null || !lsx2.isEnabled() || !lsx2.ltq(text.getString())) {
                    return true;
                }
                MinecraftClient minecraftClient = MinecraftClient.getInstance();
                Text text2 = parameters == null ? text : parameters.applyChatDecoration(text);
                minecraftClient.inGameHud.getChatHud().addMessage(lsx.protect(text2));
                return false;
            });
        }
        catch (Throwable throwable) {
            System.out.println(a.c(571382688, "\u9bd5\ue279\u6880\uf6f2\u7d3d\ufbc9\u41f5\uc879\u5668\udcd6\u5b09\ua170\u2fe2\ub603\u3c52\ubabe\u00ea\u8f2a\u159f\u93d9\u1a60\u602b\ueedb\u7501\uf377\u79b3\uc054\u4e4d\ud4bd\u52ec\ud95b\u2792\uad8e\u342a\ub262\u38dc\u871c\u0d7a\u8ba1\u1215\u9847\ue6b5\u6ce8\ueb50\u71d8\uffb3") + throwable);
        }
        try {
            ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, list) -> lsx.ltu(itemStack, list));
        }
        catch (Throwable throwable) {
            System.out.println(a.d("7\u799b\uf362\u6d10\ue6df\u602b\uda17\u539b\ucd8a\u4734\uc0eb\u3a92\ub400\u2de1\ua7b0\u215c\u9b08\u14c8\u8e7d\u083b\u8182\ufbc9\u752e\ueee4\u689b\ue249\u5be2\ud5ae\u4f40\uc941\u42ba\ubc6c\u3623\uafd6\u29ce\ua32a\u1ce6\u9698\u105c\u89fa\u03ad\u7d59\uf707\u70b5\uea6c\u6414\udd98\u5733", 1439267683, 683375423) + throwable);
        }
    }

    public static Text protect(Text text) {
        lsx lsx2 = lsy;
        if (lsx2 == null || !lsx2.isEnabled() || text == null || !lsx2.ltq(text.getString())) {
            return text;
        }
        MutableText mutableText = Text.empty();
        text.visit((style, string) -> {
            mutableText.append((Text)Text.literal((String)lsx2.ltr(string)).setStyle(style));
            return Optional.empty();
        }, Style.EMPTY);
        return mutableText;
    }

    public static String protect(String string) {
        lsx lsx2 = lsy;
        return lsx2 == null || !lsx2.isEnabled() || string == null ? string : lsx2.ltr(string);
    }

    public static boolean active() {
        lsx lsx2 = lsy;
        return lsx2 != null && lsx2.isEnabled();
    }

    private boolean ltq(String string) {
        Pattern pattern = this.lts();
        return pattern != null && string != null && pattern.matcher(string).find();
    }

    private String ltr(String string) {
        Pattern pattern = this.lts();
        if (pattern == null || string.isEmpty()) {
            return string;
        }
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        String string2 = minecraftClient.getSession() == null ? "" : minecraftClient.getSession().getUsername();
        Matcher matcher = pattern.matcher(string);
        StringBuilder stringBuilder = null;
        while (matcher.find()) {
            String string3;
            if (stringBuilder == null) {
                stringBuilder = new StringBuilder(string.length());
            }
            String string4 = (string3 = matcher.group()).equalsIgnoreCase(string2) ? this.lsz.get() : this.ltb.get();
            matcher.appendReplacement(stringBuilder, Matcher.quoteReplacement(string4));
        }
        if (stringBuilder == null) {
            return string;
        }
        matcher.appendTail(stringBuilder);
        return stringBuilder.toString();
    }

    private Pattern lts() {
        int n;
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        String string = minecraftClient.getSession() == null ? "" : minecraftClient.getSession().getUsername();
        int n2 = n = this.lta.get() ? hhf.version() : -2;
        if (!string.equals(this.ltd) || n != this.ltf) {
            this.ltd = string;
            this.ltf = n;
            StringBuilder stringBuilder = new StringBuilder(string);
            if (this.lta.get()) {
                for (hhc object2 : hhf.all()) {
                    stringBuilder.append('|').append(object2.name);
                }
            }
            String string2 = stringBuilder.toString();
            StringBuilder stringBuilder2 = new StringBuilder();
            for (String string3 : string2.split(a.d("\u8af5\uf364", -567073835, -1891718786))) {
                if (string3.length() < 3) continue;
                if (stringBuilder2.length() > 0) {
                    stringBuilder2.append('|');
                }
                stringBuilder2.append(Pattern.quote(string3));
            }
            this.lte = stringBuilder2.length() == 0 ? null : Pattern.compile(a.d("\u1ee8\u674e\ued9e\u73f2\uf85f\u7ef4\uc4cb\u4d4d\ud329\u59d4\ude50\u246b\uaaa1\u3304\ub931\u3fc2\u85f9\u0a29\u908d\u16d9", 117284702, 577339786) + stringBuilder2 + a.b("\uc7b2\ube02\u34c6\uaaa9\u2104\ua7af\u1d90\u9416\u0a72\u808f\u070b\ufd30\u73fa\uea5f\u606a\ue699\u5ca2", -1442199670), 2);
        }
        return this.lte;
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        ClientPlayNetworkHandler clientPlayNetworkHandler = minecraftClient.getNetworkHandler();
        if (clientPlayNetworkHandler == null) {
            return;
        }
        for (PlayerListEntry playerListEntry : clientPlayNetworkHandler.getPlayerList()) {
            Text text;
            String string = playerListEntry.getProfile().name();
            if (!this.ltq(string) || (text = playerListEntry.getDisplayName()) != null && !this.ltq(text.getString())) continue;
            this.ltg.putIfAbsent(playerListEntry.getProfile().id(), text);
            playerListEntry.setDisplayName((Text)(text == null ? Text.literal((String)this.ltr(string)) : lsx.protect(text)));
        }
    }

    private void ltt() {
        ClientPlayNetworkHandler clientPlayNetworkHandler = this.mc.getNetworkHandler();
        if (clientPlayNetworkHandler != null) {
            for (PlayerListEntry playerListEntry : clientPlayNetworkHandler.getPlayerList()) {
                if (!this.ltg.containsKey(playerListEntry.getProfile().id())) continue;
                playerListEntry.setDisplayName(this.ltg.get(playerListEntry.getProfile().id()));
            }
        }
        this.ltg.clear();
    }

    private static void ltu(ItemStack itemStack, List<Text> list) {
        lsx lsx2 = lsy;
        if (lsx2 == null || !lsx2.isEnabled() || list.isEmpty()) {
            return;
        }
        boolean bl = false;
        for (Text text : list) {
            if (text == null || !lsx2.ltq(text.getString())) continue;
            bl = true;
            break;
        }
        if (!bl || !lsx.ltv()) {
            return;
        }
        for (int i = 0; i < list.size(); ++i) {
            list.set(i, lsx.protect(list.get(i)));
        }
    }

    private static boolean ltv() {
        try {
            CodeSource codeSource = lsx.class.getProtectionDomain().getCodeSource();
            if (codeSource == null) {
                return true;
            }
            return lth.walk(stream -> {
                boolean bl = false;
                Iterator iterator = stream.iterator();
                while (iterator.hasNext()) {
                    Class<?> clazz = ((StackWalker.StackFrame)iterator.next()).getDeclaringClass();
                    if (clazz == ItemStack.class) {
                        bl = true;
                        continue;
                    }
                    if (!bl) continue;
                    CodeSource codeSource2 = clazz.getProtectionDomain().getCodeSource();
                    return codeSource2 == null || !codeSource.getLocation().equals(codeSource2.getLocation());
                }
                return true;
            });
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    public static void attach(Screen screen2) {
        try {
            ScreenEvents.beforeRender((Screen)screen2).register((screen, drawContext, n, n2, f) -> lsx.ltw(screen, true));
            ScreenEvents.afterRender((Screen)screen2).register((screen, drawContext, n, n2, f) -> lsx.ltw(screen, false));
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private static void ltw(Screen screen, boolean bl) {
        Field field = lsx.ltx();
        if (field == null) {
            return;
        }
        try {
            if (!bl) {
                Text text = ltm.remove(screen);
                if (text != null) {
                    field.set(screen, text);
                }
                return;
            }
            lsx lsx2 = lsy;
            Text text = (Text)field.get(screen);
            if (lsx2 != null && lsx2.isEnabled() && text != null && lsx2.ltq(text.getString())) {
                ltm.put(screen, text);
                field.set(screen, lsx.protect(text));
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private static Field ltx() {
        if (ltk == null) {
            for (Field field : Screen.class.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers()) || field.getType() != Text.class) continue;
                field.setAccessible(true);
                ltk = field;
                break;
            }
        }
        return ltk;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void bossBars(MinecraftClient minecraftClient, Runnable runnable) {
        lsx lsx2 = lsy;
        if (lsx2 == null || !lsx2.isEnabled()) {
            runnable.run();
            return;
        }
        IdentityHashMap<ClientBossBar, Text> identityHashMap = new IdentityHashMap<ClientBossBar, Text>();
        for (ClientBossBar clientBossBar : pjn.of(minecraftClient).values()) {
            Text text = clientBossBar.getName();
            if (text == null || !lsx2.ltq(text.getString())) continue;
            identityHashMap.put(clientBossBar, text);
            clientBossBar.setName(lsx.protect(text));
        }
        try {
            runnable.run();
        }
        finally {
            identityHashMap.forEach(BossBar::setName);
        }
    }

    public static void titles(MinecraftClient minecraftClient, Runnable runnable) {
        if (lti == null) {
            lti = lsx.ltz(InGameHud.class);
        }
        lsx.lty(minecraftClient.inGameHud, lti, runnable);
    }

    public static void playerList(MinecraftClient minecraftClient, Runnable runnable) {
        if (ltj == null) {
            ltj = lsx.ltz(PlayerListHud.class);
        }
        lsx.lty(minecraftClient.inGameHud == null ? null : minecraftClient.inGameHud.getPlayerListHud(), ltj, runnable);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void lty(Object object, Field[] fieldArray, Runnable runnable) {
        int n;
        lsx lsx2 = lsy;
        if (lsx2 == null || !lsx2.isEnabled() || object == null || fieldArray.length == 0) {
            runnable.run();
            return;
        }
        Object[] objectArray = new Object[fieldArray.length];
        for (n = 0; n < fieldArray.length; ++n) {
            try {
                Text text = (Text)fieldArray[n].get(object);
                if (text == null || !lsx2.ltq(text.getString())) continue;
                objectArray[n] = text;
                fieldArray[n].set(object, lsx.protect(text));
                continue;
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        try {
            runnable.run();
        }
        finally {
            for (n = 0; n < fieldArray.length; ++n) {
                if (objectArray[n] == null) continue;
                try {
                    fieldArray[n].set(object, objectArray[n]);
                    continue;
                }
                catch (Throwable throwable) {}
            }
        }
    }

    private static Field[] ltz(Class<?> clazz) {
        ArrayList<Field> arrayList = new ArrayList<Field>();
        for (Field field : clazz.getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers()) || field.getType() != Text.class) continue;
            try {
                field.setAccessible(true);
                arrayList.add(field);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        return arrayList.toArray(new Field[0]);
    }

    public static boolean sidebar(DrawContext drawContext, MinecraftClient minecraftClient) {
        int n;
        int n2;
        ScoreboardDisplaySlot scoreboardDisplaySlot;
        lsx lsx2 = lsy;
        if (lsx2 == null || !lsx2.isEnabled() || minecraftClient.world == null || minecraftClient.player == null) {
            return false;
        }
        Scoreboard scoreboard = minecraftClient.world.getScoreboard();
        ScoreboardObjective scoreboardObjective = null;
        Team team = scoreboard.getScoreHolderTeam(minecraftClient.player.getNameForScoreboard());
        if (team != null && (scoreboardDisplaySlot = ScoreboardDisplaySlot.fromFormatting((Formatting)team.getColor())) != null) {
            scoreboardObjective = scoreboard.getObjectiveForSlot(scoreboardDisplaySlot);
        }
        if (scoreboardObjective == null) {
            scoreboardObjective = scoreboard.getObjectiveForSlot(ScoreboardDisplaySlot.SIDEBAR);
        }
        if (scoreboardObjective == null) {
            return false;
        }
        scoreboardDisplaySlot = scoreboardObjective.getNumberFormatOr((NumberFormat)StyledNumberFormat.RED);
        List<ScoreboardEntry> list = scoreboard.getScoreboardEntries(scoreboardObjective).stream().filter(scoreboardEntry -> !scoreboardEntry.hidden()).sorted(lsx.lua()).limit(15L).toList();
        int n3 = list.size();
        Text text = scoreboardObjective.getDisplayName();
        Text[] textArray = new Text[n3];
        Text[] textArray2 = new Text[n3];
        boolean bl = lsx2.ltq(text.getString());
        for (int i = 0; i < n3; ++i) {
            ScoreboardEntry scoreboardEntry2 = list.get(i);
            textArray[i] = Team.decorateName((AbstractTeam)scoreboard.getScoreHolderTeam(scoreboardEntry2.owner()), (Text)scoreboardEntry2.name());
            textArray2[i] = scoreboardEntry2.formatted((NumberFormat)scoreboardDisplaySlot);
            bl |= lsx2.ltq(textArray[i].getString()) || lsx2.ltq(textArray2[i].getString());
        }
        if (!bl) {
            return false;
        }
        TextRenderer textRenderer = minecraftClient.textRenderer;
        text = lsx.protect(text);
        int n4 = n2 = textRenderer.getWidth((StringVisitable)text);
        int n5 = textRenderer.getWidth(a.c(1642204628, "\u0dec\u7447"));
        int[] nArray = new int[n3];
        for (n = 0; n < n3; ++n) {
            textArray[n] = lsx.protect(textArray[n]);
            textArray2[n] = lsx.protect(textArray2[n]);
            nArray[n] = textRenderer.getWidth((StringVisitable)textArray2[n]);
            n4 = Math.max(n4, textRenderer.getWidth((StringVisitable)textArray[n]) + (nArray[n] > 0 ? n5 + nArray[n] : 0));
        }
        drawContext.createNewRootLayer();
        Objects.requireNonNull(textRenderer);
        n = 9;
        int n6 = drawContext.getScaledWindowHeight() / 2 + n3 * n / 3;
        int n7 = drawContext.getScaledWindowWidth() - n4 - 3;
        int n8 = drawContext.getScaledWindowWidth() - 3 + 2;
        int n9 = n6 - n3 * n;
        drawContext.fill(n7 - 2, n9 - n - 1, n8, n9 - 1, minecraftClient.options.getTextBackgroundColor(0.4f));
        drawContext.fill(n7 - 2, n9 - 1, n8, n6, minecraftClient.options.getTextBackgroundColor(0.3f));
        drawContext.drawText(textRenderer, text, n7 + n4 / 2 - n2 / 2, n9 - n, -1, false);
        for (int i = 0; i < n3; ++i) {
            int n10 = n6 - (n3 - i) * n;
            drawContext.drawText(textRenderer, textArray[i], n7, n10, -1, false);
            drawContext.drawText(textRenderer, textArray2[i], n8 - nArray[i], n10, -1, false);
        }
        return true;
    }

    private static Comparator<ScoreboardEntry> lua() {
        if (ltl == null) {
            for (Field field : InGameHud.class.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers()) || !Comparator.class.isAssignableFrom(field.getType())) continue;
                try {
                    field.setAccessible(true);
                    ltl = (Comparator)field.get(null);
                }
                catch (Throwable throwable) {}
                break;
            }
            if (ltl == null) {
                ltl = Comparator.comparing(ScoreboardEntry::value, Comparator.reverseOrder()).thenComparing(ScoreboardEntry::owner, String.CASE_INSENSITIVE_ORDER);
            }
        }
        return ltl;
    }

    public static void afterExtraction(WorldRenderState worldRenderState) {
        lsx lsx2 = lsy;
        if (lsx2 == null || !lsx2.isEnabled() || worldRenderState == null) {
            return;
        }
        for (EntityRenderState entityRenderState : worldRenderState.entityRenderStates) {
            if (entityRenderState.displayName != null && lsx2.ltq(entityRenderState.displayName.getString())) {
                entityRenderState.displayName = lsx.protect(entityRenderState.displayName);
            }
            if (!(entityRenderState instanceof PlayerEntityRenderState)) continue;
            PlayerEntityRenderState playerEntityRenderState = (PlayerEntityRenderState)entityRenderState;
            if (playerEntityRenderState.playerName == null || !lsx2.ltq(playerEntityRenderState.playerName.getString())) continue;
            playerEntityRenderState.playerName = lsx.protect(playerEntityRenderState.playerName);
        }
    }

    static {
        lth = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
        ltm = new WeakHashMap<Screen, Text>();
    }

    private static /* synthetic */ int azi(int n, int n2) {
        return n + n2 | 0xF2AF585B;
    }

    private static /* synthetic */ int azj(int n, int n2) {
        return n - n2 ^ 0x2251601C;
    }

    private static /* synthetic */ int azk(int n, int n2) {
        return lsx.azi(n, n2) * n2;
    }
}

