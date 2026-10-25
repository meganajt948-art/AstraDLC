/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.rendering.v1.hud.HudElement
 *  net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry
 *  net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements
 *  net.fabricmc.fabric.api.client.screen.v1.ScreenEvents
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.hud.ChatHud
 *  net.minecraft.client.gui.hud.ChatHudLine$Visible
 *  net.minecraft.client.gui.screen.ChatScreen
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.ingame.HandledScreen
 *  net.minecraft.client.render.RenderTickCounter
 *  net.minecraft.scoreboard.Scoreboard
 *  net.minecraft.scoreboard.ScoreboardDisplaySlot
 *  net.minecraft.scoreboard.ScoreboardObjective
 *  net.minecraft.util.Identifier
 *  org.joml.Matrix3x2fStack
 */
package a;

import a.kfa;
import a.kfe;
import a.vcq;
import a.vkl;
import a.vmc;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElement;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.gui.hud.ChatHudLine;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardDisplaySlot;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.util.Identifier;
import org.joml.Matrix3x2fStack;

public class qxi
extends kfe {
    private static qxi qxj;
    private static boolean qxk;
    private final vkl qxl = this.add(new vkl("Tab", true));
    private final vkl qxm = this.add(new vkl("Chat", true));
    private final vkl qxn = this.add(new vkl("Inventory", true));
    private final vmc qxo = this.add(new vmc("Speed", 1.0, 0.5, 2.0, 0.1));
    private static float qxp;
    private static long qxq;
    private static Field qxr;
    private static boolean qxs;
    private static Object qxt;
    private static long qxu;
    private static final Map<Screen, Long> qxv;
    private static boolean qxw;
    private static /* synthetic */ long qxx;
    private static /* synthetic */ int qxy;

    public qxi() {
        super(new String(new char[]{'A', 'n', 'i', 'm', 'a', 't', 'i', 'o', 'n', 's'}), "Smooth tab list, chat and inventories", kfa.RENDER);
        qxj = this;
        this.setEnabled(true);
        qxi.qyb();
    }

    private static boolean qxz(vkl vkl2) {
        return qxj != null && qxj.isEnabled() && vkl2.get();
    }

    private static float qya(float f) {
        return f / (float)Math.max(0.2, qxi.qxj.qxo.get());
    }

    private static void qyb() {
        if (qxk) {
            return;
        }
        qxk = true;
        try {
            HudElementRegistry.replaceElement((Identifier)VanillaHudElements.PLAYER_LIST, hudElement -> qxi.qyc(hudElement));
            HudElementRegistry.replaceElement((Identifier)VanillaHudElements.CHAT, hudElement -> qxi.qye(hudElement));
        }
        catch (Throwable throwable) {
            System.out.println("tab / chat animations unavailable: " + throwable);
        }
    }

    private static HudElement qyc(HudElement hudElement) {
        return (drawContext, renderTickCounter) -> {
            if (qxj == null || !qxi.qxz(qxi.qxj.qxl)) {
                qxp = 0.0f;
                hudElement.render(drawContext, renderTickCounter);
                return;
            }
            try {
                qxi.qyd(drawContext, renderTickCounter, hudElement);
            }
            catch (Throwable throwable) {
                System.out.println("tab animation failed: " + throwable);
                qxi.qxj.qxl.set(false);
            }
        };
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void qyd(DrawContext drawContext, RenderTickCounter renderTickCounter, HudElement hudElement) {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        long l = System.nanoTime();
        float f = qxq == 0L ? 0.0f : Math.min(0.1f, (float)(l - qxq) / 1.0E9f);
        qxq = l;
        Scoreboard scoreboard = minecraftClient.world.getScoreboard();
        ScoreboardObjective scoreboardObjective = scoreboard.getObjectiveForSlot(ScoreboardDisplaySlot.LIST);
        int n = minecraftClient.player.networkHandler.getListedPlayerListEntries().size();
        boolean bl = minecraftClient.options.playerListKey.isPressed() && (!minecraftClient.isInSingleplayer() || n > 1 || scoreboardObjective != null);
        if ((qxp = vcq.clamp01(qxp + (bl ? f / qxi.qya(0.24f) : -f / qxi.qya(0.16f)))) <= 0.0f || qxp >= 1.0f && bl) {
            hudElement.render(drawContext, renderTickCounter);
            return;
        }
        float f2 = qxp * qxp * (3.0f - 2.0f * qxp);
        int n2 = drawContext.getScaledWindowWidth();
        int n3 = n;
        int n4 = 1;
        while (n3 > 20) {
            n3 = (n + ++n4 - 1) / n4;
        }
        float f3 = 10.0f + (float)n3 * 9.0f + 50.0f;
        drawContext.enableScissor(0, 0, n2, Math.max(1, Math.round(4.0f + f2 * f3)));
        Matrix3x2fStack matrix3x2fStack = drawContext.getMatrices();
        matrix3x2fStack.pushMatrix();
        float f4 = 0.94f + 0.06f * f2;
        matrix3x2fStack.translate((float)n2 * 0.5f, 10.0f - (1.0f - f2) * 6.0f);
        matrix3x2fStack.scale(f4, f4);
        matrix3x2fStack.translate((float)(-n2) * 0.5f, -10.0f);
        try {
            if (bl) {
                hudElement.render(drawContext, renderTickCounter);
            } else {
                drawContext.createNewRootLayer();
                minecraftClient.inGameHud.getPlayerListHud().render(drawContext, n2, scoreboard, scoreboardObjective);
            }
        }
        finally {
            matrix3x2fStack.popMatrix();
            drawContext.disableScissor();
        }
    }

    private static HudElement qye(HudElement hudElement) {
        return (drawContext, renderTickCounter) -> {
            if (qxj == null || !qxi.qxz(qxi.qxj.qxm) || qxs) {
                hudElement.render(drawContext, renderTickCounter);
                return;
            }
            float f = 0.0f;
            try {
                f = qxi.qyf(MinecraftClient.getInstance());
            }
            catch (Throwable throwable) {
                qxs = true;
                System.out.println("chat animation unavailable: " + throwable);
            }
            if (f < 0.05f) {
                hudElement.render(drawContext, renderTickCounter);
                return;
            }
            Matrix3x2fStack matrix3x2fStack = drawContext.getMatrices();
            matrix3x2fStack.pushMatrix();
            matrix3x2fStack.translate(0.0f, f);
            try {
                hudElement.render(drawContext, renderTickCounter);
            }
            finally {
                matrix3x2fStack.popMatrix();
            }
        };
    }

    private static float qyf(MinecraftClient minecraftClient) throws IllegalAccessException {
        float f;
        Object object;
        ChatHud chatHud = minecraftClient.inGameHud.getChatHud();
        if (qxr == null) {
            object = ChatHud.class.getDeclaredFields();
            int n = ((Field[])object).length;
            for (int i = 0; i < n; ++i) {
                ParameterizedType parameterizedType;
                Type type;
                Object object2 = object[i];
                if (Modifier.isStatic(((Field)object2).getModifiers()) || ((Field)object2).getType() != List.class || !((type = ((Field)object2).getGenericType()) instanceof ParameterizedType) || (parameterizedType = (ParameterizedType)type).getActualTypeArguments().length != 1 || parameterizedType.getActualTypeArguments()[0] != ChatHudLine.Visible.class) continue;
                ((Field)object2).setAccessible(true);
                qxr = object2;
            }
            if (qxr == null) {
                throw new IllegalStateException("chat lines not found");
            }
        }
        Object var3_4 = (object = (List)qxr.get(chatHud)).isEmpty() ? null : object.get(0);
        long l = System.nanoTime();
        if (var3_4 != qxt) {
            if (qxt != null && var3_4 != null) {
                qxu = l;
            }
            qxt = var3_4;
        }
        if ((f = vcq.clamp01((float)(l - qxu) / 1.0E9f / qxi.qya(0.28f))) >= 1.0f) {
            return 0.0f;
        }
        double d = (Double)minecraftClient.options.getChatLineSpacing().getValue();
        double d2 = (Double)minecraftClient.options.getChatScale().getValue();
        float f2 = (float)(9.0 * (d + 1.0) * d2);
        return (1.0f - vcq.outCubic(f)) * f2;
    }

    public static void attach(Screen screen2) {
        if (qxj == null || !(screen2 instanceof HandledScreen) && !(screen2 instanceof ChatScreen)) {
            return;
        }
        qxv.putIfAbsent(screen2, System.nanoTime());
        ScreenEvents.beforeRender((Screen)screen2).register((screen, drawContext, n, n2, f) -> qxi.qyg(screen, drawContext));
        ScreenEvents.afterRender((Screen)screen2).register((screen, drawContext, n, n2, f) -> qxi.qyj(drawContext));
    }

    private static void qyg(Screen screen, DrawContext drawContext) {
        qxw = false;
        Long l = qxv.get(screen);
        if (l == null) {
            return;
        }
        boolean bl = screen instanceof ChatScreen;
        if (!qxi.qxz(bl ? qxi.qxj.qxm : qxi.qxj.qxn)) {
            return;
        }
        float f = vcq.clamp01((float)(System.nanoTime() - l) / 1.0E9f / qxi.qya(bl ? 0.2f : 0.26f));
        if (f >= 1.0f) {
            return;
        }
        Matrix3x2fStack matrix3x2fStack = drawContext.getMatrices();
        matrix3x2fStack.pushMatrix();
        qxw = true;
        if (bl) {
            matrix3x2fStack.translate(0.0f, (1.0f - vcq.outCubic(f)) * 16.0f);
            return;
        }
        float f2 = vcq.outBack(f);
        int n = screen.width;
        int n2 = screen.height;
        float f3 = 0.9f + 0.1f * f2;
        float f4 = (1.0f - vcq.outCubic(f)) * 10.0f;
        if (f3 < 1.0f) {
            int n3 = (int)Math.ceil((float)n * 0.5f - (float)n * 0.5f * f3);
            int n4 = (int)Math.floor((float)n * 0.5f + (float)n * 0.5f * f3);
            int n5 = (int)Math.ceil((float)n2 * 0.5f + f4 - (float)n2 * 0.5f * f3);
            int n6 = (int)Math.floor((float)n2 * 0.5f + f4 + (float)n2 * 0.5f * f3);
            qxi.qyh(drawContext, 0, 0, n, n5, n2);
            qxi.qyh(drawContext, 0, n6, n, n2, n2);
            qxi.qyh(drawContext, 0, n5, n3, n6, n2);
            qxi.qyh(drawContext, n4, n5, n, n6, n2);
        }
        matrix3x2fStack.translate((float)n * 0.5f, (float)n2 * 0.5f + f4);
        matrix3x2fStack.scale(f3, f3);
        matrix3x2fStack.translate((float)(-n) * 0.5f, (float)(-n2) * 0.5f);
    }

    private static void qyh(DrawContext drawContext, int n, int n2, int n3, int n4, int n5) {
        if (n3 <= n || n4 <= n2) {
            return;
        }
        drawContext.fillGradient(n, n2, n3, n4, qxi.qyi((float)n2 / (float)n5), qxi.qyi((float)n4 / (float)n5));
    }

    private static int qyi(float f) {
        int n = Math.round(192.0f + 16.0f * Math.max(0.0f, Math.min(1.0f, f)));
        return n << 24 | 0x101010;
    }

    private static void qyj(DrawContext drawContext) {
        if (qxw) {
            qxw = false;
            drawContext.getMatrices().popMatrix();
        }
    }

    static {
        qxv = new WeakHashMap<Screen, Long>();
    }

    private static /* synthetic */ int bwo(int n, int n2) {
        return n + n2 ^ 0xD37C6E14;
    }
}

