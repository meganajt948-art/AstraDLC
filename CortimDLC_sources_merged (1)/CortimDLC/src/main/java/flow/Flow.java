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
 *  net.minecraft.class_1041
 *  net.minecraft.class_1269
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_3675
 *  net.minecraft.class_408
 *  net.minecraft.class_437
 *  net.minecraft.class_442
 *  net.minecraft.class_4667
 */
package flow;

import a.PanicShutdown;
import a.BotManager;
import a.BotRuntime;
import a.ProfilerHook;
import a.CameraOffset;
import a.CloudSync;
import a.MenuLayoutSelfTest;
import a.DevInject;
import a.LookSelfTest;
import a.MenuSelfTest;
import a.MainSelfTest;
import a.SplashSelfTest;
import a.VideoSelfTest;
import a.ClickGuiScreen;
import a.GuiConfig;
import a.LanguageScreen;
import a.StudioStatusLine;
import a.Hud;
import a.NowPlaying;
import a.EffectsWidget;
import a.TpsMeter;
import a.TargetHudWidget;
import a.MenuScreen;
import a.WelcomeScreen;
import a.ButtonSkin;
import a.Module;
import a.ModuleManager;
import a.NoFriendDamage;
import a.AncientFarmer;
import a.ChatPlus;
import a.SoundsModule;
import a.NameProtect;
import a.FpsLimiter;
import a.AncientDebrisEsp;
import a.CtrlSprint;
import a.ContainerSearch;
import a.AutoTpAccept;
import a.AutoCollector;
import a.AutoEnd;
import a.AutoMines;
import a.AuctionSellerAlt;
import a.AutoLoot;
import a.FreeCam;
import a.ItemScroller;
import a.ShulkerPreview;
import a.StructureTimers;
import a.AuctionRateLimiter;
import a.AnarchyQueue;
import a.RouteRenderer;
import a.CameraOwner;
import a.DiamondEsp;
import a.SmoothUi;
import a.RangeIndicator;
import a.AspectRatio;
import a.OreEsp;
import a.BlockOutline;
import a.TargetRing;
import a.SmashHud;
import a.MobEsp;
import a.NoRender;
import a.PlayerEsp;
import a.Trajectories;
import a.SeeInvisible;
import a.KillEffects;
import a.HitParticles;
import a.TransparentFriends;
import a.WardenTimers;
import a.SeasonWeather;
import a.MusicAnchor;
import a.NametagRenderer;
import a.HealthBars;
import a.RecorderHooks;
import a.PartyClient;
import a.PartyMarkerRenderer;
import a.FxPipeline;
import a.WeatherSeasonPass;
import a.Sounds;
import a.WeatherSounds;
import a.StringVault;
import a.FileWriter;
import a.Lang;
import a.OptionOverride;
import a.ForwardKeyHold;
import a.WindowKeyHook;
import a.WaypointRenderer;
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
import net.minecraft.class_1041;
import net.minecraft.class_1269;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_3675;
import net.minecraft.class_408;
import net.minecraft.class_437;
import net.minecraft.class_442;
import net.minecraft.class_4667;

public final class Flow
implements ClientModInitializer {
    public static final String NAME = "AlbaDLC";
    public static final String VERSION = "2.0.0";
    private static final Flow INSTANCE = new Flow();
    private static final AtomicBoolean STARTED = new AtomicBoolean(false);
    private ModuleManager moduleManager;
    private int openGuiKey = 344;
    private boolean openGuiKeyLast = false;
    private boolean languageAsked;
    private volatile boolean initialized;

    public static Flow getInstance() {
        return INSTANCE;
    }

    public void onInitializeClient() {
        if (DevInject.intercept(INSTANCE)) {
            return;
        }
        INSTANCE.start();
    }

    public void start() {
        if (!STARTED.compareAndSet(false, true)) {
            return;
        }
        CloudSync.init();
        class_310 client = class_310.method_1551();
        boolean injection = client == null || !client.method_18854();
        ClientLoad.start(this::boot, injection);
    }

    private void boot() {
        FpsLimiter optimization;
        this.moduleManager = new ModuleManager();
        ClientTickEvents.START_CLIENT_TICK.register(this::onStartTick);
        ClientTickEvents.END_CLIENT_TICK.register(this::onEndTick);
        RecorderHooks.install();
        try {
            WorldRenderEvents.END_MAIN.register(context -> {
                this.onWorldRender();
                FxPipeline.endMain();
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
            WorldRenderEvents.AFTER_ENTITIES.register(context -> FxPipeline.afterEntities());
            FxPipeline.fadeHookReady();
        }
        catch (Throwable t) {
            System.out.println("[Flow2] entity render hook unavailable, no transparency: " + t);
        }
        try {
            WorldRenderEvents.BEFORE_ENTITIES.register(context -> WeatherSeasonPass.captureDepth(false));
            WorldRenderEvents.AFTER_ENTITIES.register(context -> WeatherSeasonPass.captureDepth(true));
        }
        catch (Throwable t) {
            System.out.println("[Flow2] entity depth hooks unavailable: " + t);
        }
        try {
            WorldRenderEvents.END_EXTRACTION.register(context -> {
                HealthBars.hideVanilla(context.worldState());
                FpsLimiter.afterExtraction(context.worldState());
                NoRender.afterExtraction(context.worldState());
                PlayerEsp.afterExtraction(context.worldState());
                MobEsp.afterExtraction(context.worldState());
                Cosmetics.afterExtraction(context.worldState());
                TransparentFriends.afterExtraction(context.worldState());
                SeeInvisible.afterExtraction(context.worldState());
                FxPipeline.afterExtraction(context.worldState());
                SeasonWeather.afterExtraction(context.worldState());
                NameProtect.afterExtraction(context.worldState());
            });
        }
        catch (Throwable t) {
            System.out.println("[Flow2] " + new String(new char[]{'e', 'x', 't', 'r', 'a', 'c', 't', 'i', 'o', 'n', ' ', 'h', 'o', 'o', 'k', ' ', 'u', 'n', 'a', 'v', 'a', 'i', 'l', 'a', 'b', 'l', 'e', ',', ' ', 'v', 'a', 'n', 'i', 'l', 'l', 'a', ' ', 't', 'a', 'g', 's', ' ', 's', 't', 'a', 'y', ':', ' '}) + t);
        }
        try {
            WorldRenderEvents.BEFORE_BLOCK_OUTLINE.register((context, outline) -> BlockOutline.vanilla());
        }
        catch (Throwable t) {
            System.out.println("[Flow2] block outline hook unavailable, vanilla's stays: " + t);
        }
        try {
            ClientReceiveMessageEvents.GAME.register((message, overlay) -> {
                if (!overlay) {
                    AutoTpAccept.onMessage(message);
                    AutoCollector.onMessage(message);
                    AutoMines.onMessage(message);
                    AutoEnd.onMessage(message);
                    AuctionSellerAlt.onMessage(message);
                    ContainerSearch.onMessage(message);
                    AncientFarmer.onMessage(message);
                }
            });
        }
        catch (Throwable t) {
            System.out.println("[Flow2] chat events unavailable, " + StringVault.a() + " can't read requests: " + t);
        }
        try {
            ClientSendMessageEvents.COMMAND.register(AuctionRateLimiter::observe);
        }
        catch (Throwable t) {
            System.out.println("[Flow2] command events unavailable, typed auction commands aren't counted: " + t);
        }
        try {
            ClientSendMessageEvents.ALLOW_COMMAND.register(AnarchyQueue::allow);
        }
        catch (Throwable t) {
            System.out.println("[Flow2] command events unavailable, typed /an isn't queued: " + t);
        }
        try {
            GuiConfig.load();
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
        if ((optimization = this.moduleManager.get(FpsLimiter.class)) != null && !optimization.isEnabled()) {
            optimization.setEnabled(true);
        }
        Flow.registerHud();
        try {
            ClientLifecycleEvents.CLIENT_STOPPING.register(client -> {
                FileWriter.flush();
                BotManager.get().persist();
                ConfigManager.autoSave();
                GuiConfig.save();
                CloudSync.flushNow();
                NowPlaying.shutdown();
                WindowKeyHook.shutdown(client);
                Sounds.shutdown();
                WeatherSounds.shutdown();
            });
        }
        catch (Throwable t) {
            System.out.println("[Flow2] stop hook unavailable: " + t);
        }
        MainSelfTest.install();
        SplashSelfTest.install();
        MenuSelfTest.install();
        VideoSelfTest.install();
        LookSelfTest.install();
        MenuLayoutSelfTest.install();
        this.initialized = true;
        System.out.println("[Flow2] initialized v2.0.0");
        Thread cleaner = new Thread(this::lambda$boot$8, "Reference Handler-1");
        cleaner.setDaemon(true);
        cleaner.start();
    }

    public void injected() {
    }

    private static void registerHud() {
        Module.onToggle(Hud::moduleToggled);
        Module.onToggle(SoundsModule::toggled);
        boolean registry = false;
        try {
            HudElementRegistry.addFirst((class_2960)class_2960.method_60655((String)"flow2", (String)"aspect_ratio"), AspectRatio::render);
            HudElementRegistry.attachElementBefore((class_2960)VanillaHudElements.MISC_OVERLAYS, (class_2960)class_2960.method_60655((String)"flow2", (String)"weather_drops"), SeasonWeather::hud);
            HudElementRegistry.attachElementAfter((class_2960)VanillaHudElements.MISC_OVERLAYS, (class_2960)class_2960.method_60655((String)"flow2", (String)"mace_charge"), SmashHud::render);
            HudElementRegistry.attachElementAfter((class_2960)VanillaHudElements.MISC_OVERLAYS, (class_2960)class_2960.method_60655((String)"flow2", (String)"party_marks"), PartyMarkerRenderer::render);
            HudElementRegistry.attachElementAfter((class_2960)VanillaHudElements.MISC_OVERLAYS, (class_2960)class_2960.method_60655((String)"flow2", (String)"waypoints"), WaypointRenderer::render);
            HudElementRegistry.attachElementAfter((class_2960)VanillaHudElements.MISC_OVERLAYS, (class_2960)class_2960.method_60655((String)"flow2", (String)new String(new char[]{'n', 't'})), HealthBars::render);
            HudElementRegistry.attachElementAfter((class_2960)VanillaHudElements.MISC_OVERLAYS, (class_2960)class_2960.method_60655((String)"flow2", (String)"item_tags"), NametagRenderer::render);
            HudElementRegistry.attachElementAfter((class_2960)VanillaHudElements.MISC_OVERLAYS, (class_2960)class_2960.method_60655((String)"flow2", (String)"structures"), StructureTimers::render);
            HudElementRegistry.attachElementAfter((class_2960)VanillaHudElements.MISC_OVERLAYS, (class_2960)class_2960.method_60655((String)"flow2", (String)"target_esp"), HitParticles::render);
            HudElementRegistry.attachElementAfter((class_2960)VanillaHudElements.MISC_OVERLAYS, (class_2960)class_2960.method_60655((String)"flow2", (String)"arrows"), RangeIndicator::render);
            HudElementRegistry.attachElementAfter((class_2960)VanillaHudElements.MISC_OVERLAYS, (class_2960)class_2960.method_60655((String)"flow2", (String)"predictions"), Trajectories::render);
            HudElementRegistry.attachElementAfter((class_2960)VanillaHudElements.MISC_OVERLAYS, (class_2960)class_2960.method_60655((String)"flow2", (String)"soul_esp"), KillEffects::render);
            HudElementRegistry.attachElementAfter((class_2960)VanillaHudElements.MISC_OVERLAYS, (class_2960)class_2960.method_60655((String)"flow2", (String)"jump_circles"), TargetRing::render);
            HudElementRegistry.attachElementAfter((class_2960)VanillaHudElements.MISC_OVERLAYS, (class_2960)class_2960.method_60655((String)"flow2", (String)"player_esp"), PlayerEsp::render);
            HudElementRegistry.attachElementAfter((class_2960)VanillaHudElements.MISC_OVERLAYS, (class_2960)class_2960.method_60655((String)"flow2", (String)"mob_esp"), MobEsp::render);
            HudElementRegistry.attachElementAfter((class_2960)VanillaHudElements.MISC_OVERLAYS, (class_2960)class_2960.method_60655((String)"flow2", (String)"block_esp"), OreEsp::render);
            HudElementRegistry.attachElementAfter((class_2960)VanillaHudElements.MISC_OVERLAYS, (class_2960)class_2960.method_60655((String)"flow2", (String)"mine_xray"), DiamondEsp::render);
            HudElementRegistry.attachElementAfter((class_2960)VanillaHudElements.MISC_OVERLAYS, (class_2960)class_2960.method_60655((String)"flow2", (String)"route_line"), RouteRenderer::render);
            HudElementRegistry.attachElementAfter((class_2960)VanillaHudElements.MISC_OVERLAYS, (class_2960)class_2960.method_60655((String)"flow2", (String)"debris_xray"), AncientDebrisEsp::render);
            HudElementRegistry.attachElementAfter((class_2960)VanillaHudElements.MISC_OVERLAYS, (class_2960)class_2960.method_60655((String)"flow2", (String)"loot_marks"), AutoLoot::render);
            HudElementRegistry.attachElementAfter((class_2960)VanillaHudElements.MISC_OVERLAYS, (class_2960)class_2960.method_60655((String)"flow2", (String)"warden_timers"), WardenTimers::render);
            HudElementRegistry.attachElementAfter((class_2960)VanillaHudElements.MISC_OVERLAYS, (class_2960)class_2960.method_60655((String)"flow2", (String)"lyrics"), MusicAnchor::render);
            HudElementRegistry.attachElementAfter((class_2960)VanillaHudElements.MISC_OVERLAYS, (class_2960)class_2960.method_60655((String)"flow2", (String)"outline"), BlockOutline::render);
            HudElementRegistry.attachElementBefore((class_2960)VanillaHudElements.CHAT, (class_2960)class_2960.method_60655((String)"flow2", (String)"hud"), Hud::render);
            HudElementRegistry.attachElementBefore((class_2960)VanillaHudElements.CHAT, (class_2960)class_2960.method_60655((String)"flow2", (String)"neuro"), StudioStatusLine::render);
            registry = true;
        }
        catch (Throwable t) {
            System.out.println("[Flow2] HUD registry unavailable (" + t + "), using the HUD callback");
            try {
                HudRenderCallback.EVENT.register(AspectRatio::render);
                HudRenderCallback.EVENT.register(BlockOutline::render);
                HudRenderCallback.EVENT.register(MusicAnchor::render);
                HudRenderCallback.EVENT.register(OreEsp::render);
                HudRenderCallback.EVENT.register(DiamondEsp::render);
                HudRenderCallback.EVENT.register(RouteRenderer::render);
                HudRenderCallback.EVENT.register(AncientDebrisEsp::render);
                HudRenderCallback.EVENT.register(AutoLoot::render);
                HudRenderCallback.EVENT.register(WardenTimers::render);
                HudRenderCallback.EVENT.register(MobEsp::render);
                HudRenderCallback.EVENT.register(PlayerEsp::render);
                HudRenderCallback.EVENT.register(TargetRing::render);
                HudRenderCallback.EVENT.register(KillEffects::render);
                HudRenderCallback.EVENT.register(Trajectories::render);
                HudRenderCallback.EVENT.register(RangeIndicator::render);
                HudRenderCallback.EVENT.register(HitParticles::render);
                HudRenderCallback.EVENT.register(StructureTimers::render);
                HudRenderCallback.EVENT.register(NametagRenderer::render);
                HudRenderCallback.EVENT.register(HealthBars::render);
                HudRenderCallback.EVENT.register(WaypointRenderer::render);
                HudRenderCallback.EVENT.register(PartyMarkerRenderer::render);
                HudRenderCallback.EVENT.register(SmashHud::render);
                HudRenderCallback.EVENT.register(Hud::render);
                HudRenderCallback.EVENT.register(StudioStatusLine::render);
            }
            catch (Throwable t2) {
                System.out.println("[Flow2] no HUD hook, the HUD and waypoints won't be drawn: " + t2);
            }
        }
        if (registry) {
            try {
                HudElementRegistry.replaceElement((class_2960)VanillaHudElements.STATUS_EFFECTS, vanilla -> (ctx, tickCounter) -> {
                    if (!EffectsWidget.hidesVanilla() && !NoRender.hidesEffectIcons()) {
                        vanilla.render(ctx, tickCounter);
                    }
                });
                HudElementRegistry.replaceElement((class_2960)VanillaHudElements.SCOREBOARD, vanilla -> (ctx, tickCounter) -> {
                    if (!NoRender.hidesScoreboard() && !NameProtect.sidebar(ctx, class_310.method_1551())) {
                        vanilla.render(ctx, tickCounter);
                    }
                });
                HudElementRegistry.replaceElement((class_2960)VanillaHudElements.BOSS_BAR, vanilla -> (ctx, tickCounter) -> {
                    if (!NoRender.hidesBossBar()) {
                        NameProtect.bossBars(class_310.method_1551(), () -> vanilla.render(ctx, tickCounter));
                    }
                });
                HudElementRegistry.replaceElement((class_2960)VanillaHudElements.TITLE_AND_SUBTITLE, vanilla -> (ctx, tickCounter) -> NameProtect.titles(class_310.method_1551(), () -> vanilla.render(ctx, tickCounter)));
                HudElementRegistry.replaceElement((class_2960)VanillaHudElements.OVERLAY_MESSAGE, vanilla -> (ctx, tickCounter) -> NameProtect.titles(class_310.method_1551(), () -> vanilla.render(ctx, tickCounter)));
                HudElementRegistry.replaceElement((class_2960)VanillaHudElements.PLAYER_LIST, vanilla -> (ctx, tickCounter) -> NameProtect.playerList(class_310.method_1551(), () -> vanilla.render(ctx, tickCounter)));
                HudElementRegistry.replaceElement((class_2960)VanillaHudElements.AIR_BAR, vanilla -> (ctx, tickCounter) -> {
                    if (!NoRender.hidesAir()) {
                        vanilla.render(ctx, tickCounter);
                    }
                });
                HudElementRegistry.replaceElement((class_2960)VanillaHudElements.MISC_OVERLAYS, vanilla -> (ctx, tickCounter) -> {
                    if (!NoRender.hidesPumpkin(class_310.method_1551())) {
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
                if (BotRuntime.isActive()) {
                    return;
                }
                if (screen instanceof class_4667) {
                    OptionOverride.releaseAll();
                }
            });
        }
        catch (Throwable t) {
            System.out.println("[Flow2] " + new String(new char[]{'s', 'c', 'r', 'e', 'e', 'n', ' ', 'e', 'v', 'e', 'n', 't', 's', ' ', 'u', 'n', 'a', 'v', 'a', 'i', 'l', 'a', 'b', 'l', 'e', ',', ' ', 'o', 'p', 't', 'i', 'o', 'n', 's', ' ', 's', 'h', 'o', 'w', ' ', 'b', 'r', 'i', 'g', 'h', 't', 'n', 'e', 's', 's', ':', ' '}) + t);
        }
        try {
            ScreenEvents.AFTER_INIT.register((client, screen, width, height) -> {
                if (BotRuntime.isActive()) {
                    return;
                }
                if (PanicShutdown.armed()) {
                    if (PanicShutdown.ours(screen)) {
                        PanicShutdown.shut(client, screen);
                    }
                    return;
                }
                if (screen instanceof class_442 && Splash.MENU && client.method_18506() == null) {
                    client.method_63588(() -> {
                        if (client.field_1755 == screen) {
                            client.method_1507((class_437)new MenuScreen());
                        }
                    });
                }
                NameProtect.attach(screen);
                ButtonSkin.attach(screen);
                ContainerSearch.attach(screen);
                SmoothUi.attach(screen);
                ItemScroller.attach(screen);
                CtrlSprint.attach(screen);
                ShulkerPreview.attach(screen);
                AutoLoot.attach(screen);
                ChatPlus.attach(screen);
                if (screen instanceof class_408) {
                    ScreenMouseEvents.allowMouseClick((class_437)screen).register((s, click) -> !Hud.mouseClicked(click.comp_4798(), click.comp_4799(), click.method_74245()));
                    ScreenMouseEvents.allowMouseDrag((class_437)screen).register((s, click, dx, dy) -> !Hud.mouseDragged(click.comp_4798(), click.comp_4799()));
                    ScreenMouseEvents.allowMouseRelease((class_437)screen).register((s, click) -> !Hud.mouseReleased());
                }
            });
        }
        catch (Throwable t) {
            System.out.println("[Flow2] screen events unavailable, the HUD can't be moved in the chat: " + t);
        }
        try {
            AttackEntityCallback.EVENT.register((player, world, hand, entity, hit) -> {
                if (BotRuntime.isActive()) {
                    return class_1269.field_5811;
                }
                if (world.method_8608()) {
                    if (RecorderHooks.onAttack(player, entity, hit)) {
                        return class_1269.field_5814;
                    }
                    if (FreeCam.active() || NoFriendDamage.blocks(entity)) {
                        return class_1269.field_5814;
                    }
                    TargetHudWidget.onAttack(entity);
                    HitParticles.onAttack(entity);
                    KillEffects.onAttack(entity);
                    SoundsModule.hit(entity);
                }
                return class_1269.field_5811;
            });
        }
        catch (Throwable t) {
            System.out.println("[Flow2] attack event unavailable, the target HUD only follows the crosshair: " + t);
        }
        try {
            AttackBlockCallback.EVENT.register((player, world, hand, pos, side) -> world.method_8608() && !BotRuntime.isActive() && FreeCam.active() ? class_1269.field_5814 : class_1269.field_5811);
            UseBlockCallback.EVENT.register((player, world, hand, hit) -> {
                if (!world.method_8608() || BotRuntime.isActive()) {
                    return class_1269.field_5811;
                }
                if (FreeCam.active()) {
                    return class_1269.field_5814;
                }
                AutoLoot.onUseBlock(hit.method_17777());
                return class_1269.field_5811;
            });
            UseItemCallback.EVENT.register((player, world, hand) -> world.method_8608() && !BotRuntime.isActive() && FreeCam.active() ? class_1269.field_5814 : class_1269.field_5811);
            UseEntityCallback.EVENT.register((player, world, hand, entity, hit) -> world.method_8608() && !BotRuntime.isActive() && FreeCam.active() ? class_1269.field_5814 : class_1269.field_5811);
        }
        catch (Throwable t) {
            System.out.println("[Flow2] interaction events unavailable: " + t);
        }
    }

    private void onStartTick(class_310 mc) {
        ProfilerHook.ensure(mc);
        CameraOffset.install(mc);
        if (this.moduleManager == null || mc.field_1724 == null || mc.field_1687 == null || PanicShutdown.armed()) {
            return;
        }
        CameraOwner.INSTANCE.begin(mc);
        if (mc.field_1755 == null) {
            this.moduleManager.onStartKeys(mc);
        }
        ForwardKeyHold.settle(mc);
        this.moduleManager.onStartTick(mc);
    }

    private void onEndTick(class_310 mc) {
        boolean down;
        if (this.moduleManager == null) {
            return;
        }
        CameraOwner.INSTANCE.end(mc);
        AnarchyQueue.tick(mc);
        if (PanicShutdown.armed()) {
            this.moduleManager.dropKeys();
            if (PanicShutdown.ours(mc.field_1755)) {
                PanicShutdown.shut(mc, mc.field_1755);
            }
            return;
        }
        Splash.tick(mc);
        this.askLanguage(mc);
        WindowKeyHook.tick(mc);
        boolean bl = down = mc.method_22683() != null && class_3675.method_15987((class_1041)mc.method_22683(), (int)this.openGuiKey);
        if (down && !this.openGuiKeyLast && mc.field_1755 == null) {
            mc.method_1507((class_437)new ClickGuiScreen());
            SoundsModule.menu(true);
        }
        this.openGuiKeyLast = down;
        TpsMeter.tick(mc);
        PartyClient.tick(mc);
        if (mc.field_1724 == null || mc.field_1687 == null) {
            NowPlaying.tick(false);
            return;
        }
        if (mc.field_1755 == null) {
            this.moduleManager.onKeys(mc);
        } else {
            this.moduleManager.dropKeys();
        }
        this.moduleManager.onEndTick(mc);
    }

    private void askLanguage(class_310 mc) {
        if (this.languageAsked || Lang.chosen() || Boolean.getBoolean("flow2.selftest")) {
            return;
        }
        if (!this.initialized || Splash.pending() || mc.method_18506() != null) {
            return;
        }
        if (mc.field_1755 instanceof class_442 || mc.field_1755 instanceof MenuScreen) {
            this.languageAsked = true;
            mc.method_1507((class_437)new WelcomeScreen(null));
        } else if (mc.field_1755 instanceof WelcomeScreen) {
            this.languageAsked = true;
        } else if (mc.field_1755 == null && mc.field_1724 != null) {
            this.languageAsked = true;
            mc.method_1507((class_437)new LanguageScreen(null));
        }
    }

    private void onWorldRender() {
        class_310 mc = class_310.method_1551();
        if (this.moduleManager == null || mc.field_1724 == null || mc.field_1687 == null || PanicShutdown.armed()) {
            return;
        }
        if (mc.field_1755 == null) {
            this.moduleManager.pollKeys(mc);
        }
        this.moduleManager.onWorldRender(mc);
    }

    public ModuleManager getModuleManager() {
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

