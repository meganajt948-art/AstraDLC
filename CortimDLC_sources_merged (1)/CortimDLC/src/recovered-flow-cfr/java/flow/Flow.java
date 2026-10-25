/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.ClientModInitializer
 *  net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents
 *  net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
 *  net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents
 *  net.fabricmc.fabric.api.client.message.v1.ClientSendMessageEvents
 *  net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback
 *  net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry
 *  net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements
 *  net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents
 *  net.fabricmc.fabric.api.client.screen.v1.ScreenEvents
 *  net.fabricmc.fabric.api.client.screen.v1.ScreenMouseEvents
 *  net.fabricmc.fabric.api.event.player.AttackBlockCallback
 *  net.fabricmc.fabric.api.event.player.AttackEntityCallback
 *  net.fabricmc.fabric.api.event.player.UseBlockCallback
 *  net.fabricmc.fabric.api.event.player.UseEntityCallback
 *  net.fabricmc.fabric.api.event.player.UseItemCallback
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.screen.ChatScreen
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.TitleScreen
 *  net.minecraft.client.gui.screen.option.GameOptionsScreen
 *  net.minecraft.client.util.InputUtil
 *  net.minecraft.client.util.Window
 *  net.minecraft.util.ActionResult
 *  net.minecraft.util.Identifier
 */
package flow;

import a.dry;
import a.egq;
import a.ejp;
import a.ell;
import a.ett;
import a.ewk;
import a.fwl;
import a.fzl;
import a.gah;
import a.gdh;
import a.gtq;
import a.gyv;
import a.hem;
import a.hlc;
import a.hyz;
import a.ida;
import a.ifv;
import a.izx;
import a.jgn;
import a.jie;
import a.jip;
import a.jjx;
import a.jte;
import a.kct;
import a.kej;
import a.kfe;
import a.kfx;
import a.lfu;
import a.lqq;
import a.lre;
import a.lsg;
import a.lsx;
import a.lub;
import a.lvp;
import a.lwx;
import a.mgl;
import a.mix;
import a.mkl;
import a.mpq;
import a.nfl;
import a.nmg;
import a.oqv;
import a.ovh;
import a.owo;
import a.pbe;
import a.pbz;
import a.pdi;
import a.pnr;
import a.psu;
import a.pud;
import a.qwo;
import a.qxi;
import a.qyk;
import a.qze;
import a.rae;
import a.rby;
import a.rfy;
import a.rhf;
import a.rhs;
import a.rkh;
import a.rky;
import a.rnk;
import a.rqv;
import a.rrx;
import a.ruv;
import a.rwo;
import a.rzy;
import a.sbp;
import a.shx;
import a.sus;
import a.swh;
import a.tcz;
import a.ucg;
import a.ugg;
import a.ukl;
import a.vbb;
import a.voa;
import a.vss;
import a.vup;
import a.vza;
import a.wap;
import a.wbu;
import a.wdt;
import a.wek;
import a.wkw;
import flow.config.ConfigManager;
import flow.cosmetic.Cosmetics;
import flow.splash.ClientLoad;
import flow.splash.Splash;
import java.util.concurrent.atomic.AtomicBoolean;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents;
import net.fabricmc.fabric.api.client.message.v1.ClientSendMessageEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenMouseEvents;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.util.Window;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;

public final class Flow
implements ClientModInitializer {
    public static final String NAME = "Flow2";
    public static final String VERSION = "2.0.0";
    private static final Flow INSTANCE = new Flow();
    private static final AtomicBoolean STARTED = new AtomicBoolean(false);
    private kfx moduleManager;
    private int openGuiKey = 344;
    private boolean openGuiKeyLast = false;
    private boolean languageAsked;
    private volatile boolean initialized;

    public static Flow getInstance() {
        return INSTANCE;
    }

    public void onInitializeClient() {
        if (fzl.intercept(INSTANCE)) {
            return;
        }
        INSTANCE.start();
    }

    public void start() {
        if (!STARTED.compareAndSet(false, true)) {
            return;
        }
        ewk.init();
        MinecraftClient client = MinecraftClient.method_1551();
        boolean injection = client == null || !client.method_18854();
        ClientLoad.start(this::boot, injection);
    }

    private void boot() {
        lub optimization;
        this.moduleManager = new kfx();
        ClientTickEvents.START_CLIENT_TICK.register(this::onStartTick);
        ClientTickEvents.END_CLIENT_TICK.register(this::onEndTick);
        tcz.install();
        try {
            WorldRenderEvents.END_MAIN.register(context -> {
                this.onWorldRender();
                ukl.endMain();
            });
        }
        catch (Throwable t) {
            System.out.println("[Flow2] world render hook unavailable: " + t);
        }
        try {
            Cosmetics.install();
        }
        catch (Throwable t) {
            System.out.println("[Flow2] cosmetics unavailable: " + t);
        }
        try {
            WorldRenderEvents.AFTER_ENTITIES.register(context -> ukl.afterEntities());
            ukl.fadeHookReady();
        }
        catch (Throwable t) {
            System.out.println("[Flow2] entity render hook unavailable, no transparency: " + t);
        }
        try {
            WorldRenderEvents.BEFORE_ENTITIES.register(context -> vbb.captureDepth(false));
            WorldRenderEvents.AFTER_ENTITIES.register(context -> vbb.captureDepth(true));
        }
        catch (Throwable t) {
            System.out.println("[Flow2] entity depth hooks unavailable: " + t);
        }
        try {
            WorldRenderEvents.END_EXTRACTION.register(context -> {
                swh.hideVanilla(context.worldState());
                lub.afterExtraction(context.worldState());
                rkh.afterExtraction(context.worldState());
                rky.afterExtraction(context.worldState());
                rhs.afterExtraction(context.worldState());
                Cosmetics.afterExtraction(context.worldState());
                rwo.afterExtraction(context.worldState());
                rqv.afterExtraction(context.worldState());
                ukl.afterExtraction(context.worldState());
                sbp.afterExtraction(context.worldState());
                lsx.afterExtraction(context.worldState());
            });
        }
        catch (Throwable t) {
            System.out.println("[Flow2] " + new String(new char[]{'e', 'x', 't', 'r', 'a', 'c', 't', 'i', 'o', 'n', ' ', 'h', 'o', 'o', 'k', ' ', 'u', 'n', 'a', 'v', 'a', 'i', 'l', 'a', 'b', 'l', 'e', ',', ' ', 'v', 'a', 'n', 'i', 'l', 'l', 'a', ' ', 't', 'a', 'g', 's', ' ', 's', 't', 'a', 'y', ':', ' '}) + t);
        }
        try {
            WorldRenderEvents.BEFORE_BLOCK_OUTLINE.register((context, outline) -> rby.vanilla());
        }
        catch (Throwable t) {
            System.out.println("[Flow2] block outline hook unavailable, vanilla's stays: " + t);
        }
        try {
            ClientReceiveMessageEvents.GAME.register((message, overlay) -> {
                if (!overlay) {
                    mix.onMessage(message);
                    mkl.onMessage(message);
                    nfl.onMessage(message);
                    mpq.onMessage(message);
                    nmg.onMessage(message);
                    mgl.onMessage(message);
                    lqq.onMessage(message);
                }
            });
        }
        catch (Throwable t) {
            System.out.println("[Flow2] chat events unavailable, " + vup.a() + " can't read requests: " + t);
        }
        try {
            ClientSendMessageEvents.COMMAND.register(pdi::observe);
        }
        catch (Throwable t) {
            System.out.println("[Flow2] command events unavailable, typed auction commands aren't counted: " + t);
        }
        try {
            ClientSendMessageEvents.ALLOW_COMMAND.register(pnr::allow);
        }
        catch (Throwable t) {
            System.out.println("[Flow2] command events unavailable, typed /an isn't queued: " + t);
        }
        try {
            hyz.load();
        }
        catch (Throwable t) {
            System.out.println("[Flow2] can't load menu settings: " + t);
        }
        String active = ConfigManager.active();
        if (ConfigManager.LOAD_ON_START.get() && active != null && ConfigManager.exists(active)) {
            try {
                ConfigManager.load(active);
                System.out.println("[Flow2] loaded config " + active);
            }
            catch (Throwable t) {
                System.out.println("[Flow2] can't load config " + active + ": " + t);
            }
        }
        if ((optimization = this.moduleManager.get(lub.class)) != null && !optimization.isEnabled()) {
            optimization.setEnabled(true);
        }
        Flow.registerHud();
        try {
            ClientLifecycleEvents.CLIENT_STOPPING.register(client -> {
                vza.flush();
                egq.get().persist();
                ConfigManager.autoSave();
                hyz.save();
                ewk.flushNow();
                jgn.shutdown();
                wek.shutdown(client);
                voa.shutdown();
                vss.shutdown();
            });
        }
        catch (Throwable t) {
            System.out.println("[Flow2] stop hook unavailable: " + t);
        }
        gtq.install();
        gyv.install();
        gdh.install();
        hem.install();
        gah.install();
        fwl.install();
        this.initialized = true;
        System.out.println("[Flow2] initialized v2.0.0");
        Thread cleaner = new Thread(this::lambda$boot$8, "Reference Handler-1");
        cleaner.setDaemon(true);
        cleaner.start();
    }

    public void injected() {
    }

    private static void registerHud() {
        kfe.onToggle(izx::moduleToggled);
        kfe.onToggle(lsg::toggled);
        boolean registry = false;
        try {
            HudElementRegistry.addFirst((Identifier)Identifier.method_60655((String)"flow2", (String)"aspect_ratio"), qze::render);
            HudElementRegistry.attachElementBefore((Identifier)VanillaHudElements.MISC_OVERLAYS, (Identifier)Identifier.method_60655((String)"flow2", (String)"weather_drops"), sbp::hud);
            HudElementRegistry.attachElementAfter((Identifier)VanillaHudElements.MISC_OVERLAYS, (Identifier)Identifier.method_60655((String)"flow2", (String)"mace_charge"), rhf::render);
            HudElementRegistry.attachElementAfter((Identifier)VanillaHudElements.MISC_OVERLAYS, (Identifier)Identifier.method_60655((String)"flow2", (String)"party_marks"), ugg::render);
            HudElementRegistry.attachElementAfter((Identifier)VanillaHudElements.MISC_OVERLAYS, (Identifier)Identifier.method_60655((String)"flow2", (String)"waypoints"), wkw::render);
            HudElementRegistry.attachElementAfter((Identifier)VanillaHudElements.MISC_OVERLAYS, (Identifier)Identifier.method_60655((String)"flow2", (String)new String(new char[]{'n', 't'})), swh::render);
            HudElementRegistry.attachElementAfter((Identifier)VanillaHudElements.MISC_OVERLAYS, (Identifier)Identifier.method_60655((String)"flow2", (String)"item_tags"), sus::render);
            HudElementRegistry.attachElementAfter((Identifier)VanillaHudElements.MISC_OVERLAYS, (Identifier)Identifier.method_60655((String)"flow2", (String)"structures"), pbz::render);
            HudElementRegistry.attachElementAfter((Identifier)VanillaHudElements.MISC_OVERLAYS, (Identifier)Identifier.method_60655((String)"flow2", (String)"target_esp"), ruv::render);
            HudElementRegistry.attachElementAfter((Identifier)VanillaHudElements.MISC_OVERLAYS, (Identifier)Identifier.method_60655((String)"flow2", (String)"arrows"), qyk::render);
            HudElementRegistry.attachElementAfter((Identifier)VanillaHudElements.MISC_OVERLAYS, (Identifier)Identifier.method_60655((String)"flow2", (String)"predictions"), rnk::render);
            HudElementRegistry.attachElementAfter((Identifier)VanillaHudElements.MISC_OVERLAYS, (Identifier)Identifier.method_60655((String)"flow2", (String)"soul_esp"), rrx::render);
            HudElementRegistry.attachElementAfter((Identifier)VanillaHudElements.MISC_OVERLAYS, (Identifier)Identifier.method_60655((String)"flow2", (String)"jump_circles"), rfy::render);
            HudElementRegistry.attachElementAfter((Identifier)VanillaHudElements.MISC_OVERLAYS, (Identifier)Identifier.method_60655((String)"flow2", (String)"player_esp"), rky::render);
            HudElementRegistry.attachElementAfter((Identifier)VanillaHudElements.MISC_OVERLAYS, (Identifier)Identifier.method_60655((String)"flow2", (String)"mob_esp"), rhs::render);
            HudElementRegistry.attachElementAfter((Identifier)VanillaHudElements.MISC_OVERLAYS, (Identifier)Identifier.method_60655((String)"flow2", (String)"block_esp"), rae::render);
            HudElementRegistry.attachElementAfter((Identifier)VanillaHudElements.MISC_OVERLAYS, (Identifier)Identifier.method_60655((String)"flow2", (String)"mine_xray"), qwo::render);
            HudElementRegistry.attachElementAfter((Identifier)VanillaHudElements.MISC_OVERLAYS, (Identifier)Identifier.method_60655((String)"flow2", (String)"route_line"), psu::render);
            HudElementRegistry.attachElementAfter((Identifier)VanillaHudElements.MISC_OVERLAYS, (Identifier)Identifier.method_60655((String)"flow2", (String)"debris_xray"), lvp::render);
            HudElementRegistry.attachElementAfter((Identifier)VanillaHudElements.MISC_OVERLAYS, (Identifier)Identifier.method_60655((String)"flow2", (String)"loot_marks"), oqv::render);
            HudElementRegistry.attachElementAfter((Identifier)VanillaHudElements.MISC_OVERLAYS, (Identifier)Identifier.method_60655((String)"flow2", (String)"warden_timers"), rzy::render);
            HudElementRegistry.attachElementAfter((Identifier)VanillaHudElements.MISC_OVERLAYS, (Identifier)Identifier.method_60655((String)"flow2", (String)"lyrics"), shx::render);
            HudElementRegistry.attachElementAfter((Identifier)VanillaHudElements.MISC_OVERLAYS, (Identifier)Identifier.method_60655((String)"flow2", (String)"outline"), rby::render);
            HudElementRegistry.attachElementBefore((Identifier)VanillaHudElements.CHAT, (Identifier)Identifier.method_60655((String)"flow2", (String)"hud"), izx::render);
            HudElementRegistry.attachElementBefore((Identifier)VanillaHudElements.CHAT, (Identifier)Identifier.method_60655((String)"flow2", (String)"neuro"), ifv::render);
            registry = true;
        }
        catch (Throwable t) {
            System.out.println("[Flow2] HUD registry unavailable (" + t + "), using the HUD callback");
            try {
                HudRenderCallback.EVENT.register(qze::render);
                HudRenderCallback.EVENT.register(rby::render);
                HudRenderCallback.EVENT.register(shx::render);
                HudRenderCallback.EVENT.register(rae::render);
                HudRenderCallback.EVENT.register(qwo::render);
                HudRenderCallback.EVENT.register(psu::render);
                HudRenderCallback.EVENT.register(lvp::render);
                HudRenderCallback.EVENT.register(oqv::render);
                HudRenderCallback.EVENT.register(rzy::render);
                HudRenderCallback.EVENT.register(rhs::render);
                HudRenderCallback.EVENT.register(rky::render);
                HudRenderCallback.EVENT.register(rfy::render);
                HudRenderCallback.EVENT.register(rrx::render);
                HudRenderCallback.EVENT.register(rnk::render);
                HudRenderCallback.EVENT.register(qyk::render);
                HudRenderCallback.EVENT.register(ruv::render);
                HudRenderCallback.EVENT.register(pbz::render);
                HudRenderCallback.EVENT.register(sus::render);
                HudRenderCallback.EVENT.register(swh::render);
                HudRenderCallback.EVENT.register(wkw::render);
                HudRenderCallback.EVENT.register(ugg::render);
                HudRenderCallback.EVENT.register(rhf::render);
                HudRenderCallback.EVENT.register(izx::render);
                HudRenderCallback.EVENT.register(ifv::render);
            }
            catch (Throwable t2) {
                System.out.println("[Flow2] no HUD hook, the HUD and waypoints won't be drawn: " + t2);
            }
        }
        if (registry) {
            try {
                HudElementRegistry.replaceElement((Identifier)VanillaHudElements.STATUS_EFFECTS, vanilla -> (ctx, tickCounter) -> {
                    if (!jie.hidesVanilla() && !rkh.hidesEffectIcons()) {
                        vanilla.render(ctx, tickCounter);
                    }
                });
                HudElementRegistry.replaceElement((Identifier)VanillaHudElements.SCOREBOARD, vanilla -> (ctx, tickCounter) -> {
                    if (!rkh.hidesScoreboard() && !lsx.sidebar(ctx, MinecraftClient.method_1551())) {
                        vanilla.render(ctx, tickCounter);
                    }
                });
                HudElementRegistry.replaceElement((Identifier)VanillaHudElements.BOSS_BAR, vanilla -> (ctx, tickCounter) -> {
                    if (!rkh.hidesBossBar()) {
                        lsx.bossBars(MinecraftClient.method_1551(), () -> vanilla.render(ctx, tickCounter));
                    }
                });
                HudElementRegistry.replaceElement((Identifier)VanillaHudElements.TITLE_AND_SUBTITLE, vanilla -> (ctx, tickCounter) -> lsx.titles(MinecraftClient.method_1551(), () -> vanilla.render(ctx, tickCounter)));
                HudElementRegistry.replaceElement((Identifier)VanillaHudElements.OVERLAY_MESSAGE, vanilla -> (ctx, tickCounter) -> lsx.titles(MinecraftClient.method_1551(), () -> vanilla.render(ctx, tickCounter)));
                HudElementRegistry.replaceElement((Identifier)VanillaHudElements.PLAYER_LIST, vanilla -> (ctx, tickCounter) -> lsx.playerList(MinecraftClient.method_1551(), () -> vanilla.render(ctx, tickCounter)));
                HudElementRegistry.replaceElement((Identifier)VanillaHudElements.AIR_BAR, vanilla -> (ctx, tickCounter) -> {
                    if (!rkh.hidesAir()) {
                        vanilla.render(ctx, tickCounter);
                    }
                });
                HudElementRegistry.replaceElement((Identifier)VanillaHudElements.MISC_OVERLAYS, vanilla -> (ctx, tickCounter) -> {
                    if (!rkh.hidesPumpkin(MinecraftClient.method_1551())) {
                        vanilla.render(ctx, tickCounter);
                    }
                });
            }
            catch (Throwable t) {
                System.out.println("[Flow2] can't take over parts of the vanilla HUD: " + t);
            }
        }
        try {
            ScreenEvents.BEFORE_INIT.register((client, screen, width, height) -> {
                if (ejp.isActive()) {
                    return;
                }
                if (screen instanceof GameOptionsScreen) {
                    wbu.releaseAll();
                }
            });
        }
        catch (Throwable t) {
            System.out.println("[Flow2] " + new String(new char[]{'s', 'c', 'r', 'e', 'e', 'n', ' ', 'e', 'v', 'e', 'n', 't', 's', ' ', 'u', 'n', 'a', 'v', 'a', 'i', 'l', 'a', 'b', 'l', 'e', ',', ' ', 'o', 'p', 't', 'i', 'o', 'n', 's', ' ', 's', 'h', 'o', 'w', ' ', 'b', 'r', 'i', 'g', 'h', 't', 'n', 'e', 's', 's', ':', ' '}) + t);
        }
        try {
            ScreenEvents.AFTER_INIT.register((client, screen, width, height) -> {
                if (ejp.isActive()) {
                    return;
                }
                if (dry.armed()) {
                    if (dry.ours(screen)) {
                        dry.shut(client, screen);
                    }
                    return;
                }
                if (screen instanceof TitleScreen && Splash.MENU && client.method_18506() == null) {
                    client.method_63588(() -> {
                        if (client.field_1755 == screen) {
                            client.method_1507((Screen)new jte());
                        }
                    });
                }
                lsx.attach(screen);
                kej.attach(screen);
                mgl.attach(screen);
                qxi.attach(screen);
                owo.attach(screen);
                lwx.attach(screen);
                pbe.attach(screen);
                oqv.attach(screen);
                lre.attach(screen);
                if (screen instanceof ChatScreen) {
                    ScreenMouseEvents.allowMouseClick((Screen)screen).register((s, click) -> !izx.mouseClicked(click.comp_4798(), click.comp_4799(), click.method_74245()));
                    ScreenMouseEvents.allowMouseDrag((Screen)screen).register((s, click, dx, dy) -> !izx.mouseDragged(click.comp_4798(), click.comp_4799()));
                    ScreenMouseEvents.allowMouseRelease((Screen)screen).register((s, click) -> !izx.mouseReleased());
                }
            });
        }
        catch (Throwable t) {
            System.out.println("[Flow2] screen events unavailable, the HUD can't be moved in the chat: " + t);
        }
        try {
            AttackEntityCallback.EVENT.register((player, world, hand, entity, hit) -> {
                if (ejp.isActive()) {
                    return ActionResult.field_5811;
                }
                if (world.method_8608()) {
                    if (tcz.onAttack(player, entity, hit)) {
                        return ActionResult.field_5814;
                    }
                    if (ovh.active() || lfu.blocks(entity)) {
                        return ActionResult.field_5814;
                    }
                    jjx.onAttack(entity);
                    ruv.onAttack(entity);
                    rrx.onAttack(entity);
                    lsg.hit(entity);
                }
                return ActionResult.field_5811;
            });
        }
        catch (Throwable t) {
            System.out.println("[Flow2] attack event unavailable, the target HUD only follows the crosshair: " + t);
        }
        try {
            AttackBlockCallback.EVENT.register((player, world, hand, pos, side) -> world.method_8608() && !ejp.isActive() && ovh.active() ? ActionResult.field_5814 : ActionResult.field_5811);
            UseBlockCallback.EVENT.register((player, world, hand, hit) -> {
                if (!world.method_8608() || ejp.isActive()) {
                    return ActionResult.field_5811;
                }
                if (ovh.active()) {
                    return ActionResult.field_5814;
                }
                oqv.onUseBlock(hit.method_17777());
                return ActionResult.field_5811;
            });
            UseItemCallback.EVENT.register((player, world, hand) -> world.method_8608() && !ejp.isActive() && ovh.active() ? ActionResult.field_5814 : ActionResult.field_5811);
            UseEntityCallback.EVENT.register((player, world, hand, entity, hit) -> world.method_8608() && !ejp.isActive() && ovh.active() ? ActionResult.field_5814 : ActionResult.field_5811);
        }
        catch (Throwable t) {
            System.out.println("[Flow2] interaction events unavailable: " + t);
        }
    }

    private void onStartTick(MinecraftClient mc) {
        ell.ensure(mc);
        ett.install(mc);
        if (this.moduleManager == null || mc.field_1724 == null || mc.field_1687 == null || dry.armed()) {
            return;
        }
        pud.INSTANCE.begin(mc);
        if (mc.field_1755 == null) {
            this.moduleManager.onStartKeys(mc);
        }
        wdt.settle(mc);
        this.moduleManager.onStartTick(mc);
    }

    private void onEndTick(MinecraftClient mc) {
        boolean down;
        if (this.moduleManager == null) {
            return;
        }
        pud.INSTANCE.end(mc);
        pnr.tick(mc);
        if (dry.armed()) {
            this.moduleManager.dropKeys();
            if (dry.ours(mc.field_1755)) {
                dry.shut(mc, mc.field_1755);
            }
            return;
        }
        Splash.tick(mc);
        this.askLanguage(mc);
        wek.tick(mc);
        boolean bl = down = mc.method_22683() != null && InputUtil.method_15987((Window)mc.method_22683(), (int)this.openGuiKey);
        if (down && !this.openGuiKeyLast && mc.field_1755 == null) {
            mc.method_1507((Screen)new hlc());
            lsg.menu(true);
        }
        this.openGuiKeyLast = down;
        jip.tick(mc);
        ucg.tick(mc);
        if (mc.field_1724 == null || mc.field_1687 == null) {
            jgn.tick(false);
            return;
        }
        if (mc.field_1755 == null) {
            this.moduleManager.onKeys(mc);
        } else {
            this.moduleManager.dropKeys();
        }
        this.moduleManager.onEndTick(mc);
    }

    private void askLanguage(MinecraftClient mc) {
        if (this.languageAsked || wap.chosen() || Boolean.getBoolean("flow2.selftest")) {
            return;
        }
        if (!this.initialized || Splash.pending() || mc.method_18506() != null) {
            return;
        }
        if (mc.field_1755 instanceof TitleScreen || mc.field_1755 instanceof jte) {
            this.languageAsked = true;
            mc.method_1507((Screen)new kct(null));
        } else if (mc.field_1755 instanceof kct) {
            this.languageAsked = true;
        } else if (mc.field_1755 == null && mc.field_1724 != null) {
            this.languageAsked = true;
            mc.method_1507((Screen)new ida(null));
        }
    }

    private void onWorldRender() {
        MinecraftClient mc = MinecraftClient.method_1551();
        if (this.moduleManager == null || mc.field_1724 == null || mc.field_1687 == null || dry.armed()) {
            return;
        }
        if (mc.field_1755 == null) {
            this.moduleManager.pollKeys(mc);
        }
        this.moduleManager.onWorldRender(mc);
    }

    public kfx getModuleManager() {
        return this.moduleManager;
    }

    public int getOpenGuiKey() {
        return this.openGuiKey;
    }

    public void setOpenGuiKey(int openGuiKey) {
        this.openGuiKey = openGuiKey;
    }

    /*
     * Unable to fully structure code
     */
    private /* synthetic */ void lambda$boot$8() {
        while (true) {
            try {
                block6: while (true) {
                    Thread.sleep(15000L);
                    if (this.moduleManager == null) continue;
                    var1_1 = this.moduleManager.getModules().iterator();
                    while (true) {
                        if (var1_1.hasNext()) ** break;
                        continue block6;
                        m = var1_1.next();
                        try {
                            m.wipeCache();
                        }
                        catch (Throwable var3_5) {}
                    }
                    break;
                }
            }
            catch (InterruptedException ie) {
                return;
            }
            catch (Throwable var1_3) {
                continue;
            }
            break;
        }
    }
}

