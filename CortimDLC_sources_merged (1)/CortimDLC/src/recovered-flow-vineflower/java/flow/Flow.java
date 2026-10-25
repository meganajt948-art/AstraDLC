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
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents.ClientStopping;
import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents;
import net.fabricmc.fabric.api.client.message.v1.ClientSendMessageEvents;
import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents.Game;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents.AfterEntities;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents.BeforeBlockOutline;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents.BeforeEntities;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents.EndExtraction;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents.EndMain;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenMouseEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents.AfterInit;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents.BeforeInit;
import net.fabricmc.fabric.api.client.screen.v1.ScreenMouseEvents.AllowMouseClick;
import net.fabricmc.fabric.api.client.screen.v1.ScreenMouseEvents.AllowMouseDrag;
import net.fabricmc.fabric.api.client.screen.v1.ScreenMouseEvents.AllowMouseRelease;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;

public final class Flow implements ClientModInitializer {
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
      if (!fzl.intercept(INSTANCE)) {
         INSTANCE.start();
      }
   }

   public void start() {
      if (STARTED.compareAndSet(false, true)) {
         ewk.init();
         MinecraftClient client = MinecraftClient.getInstance();
         boolean injection = client == null || !client.isOnThread();
         ClientLoad.start(this::boot, injection);
      }
   }

   private void boot() {
      this.moduleManager = new kfx();
      ClientTickEvents.START_CLIENT_TICK.register(this::onStartTick);
      ClientTickEvents.END_CLIENT_TICK.register(this::onEndTick);
      tcz.install();

      try {
         WorldRenderEvents.END_MAIN.register((EndMain)context -> {
            this.onWorldRender();
            ukl.endMain();
         });
      } catch (Throwable t) {
         System.out.println("[Flow2] world render hook unavailable: " + t);
      }

      try {
         Cosmetics.install();
      } catch (Throwable t) {
         System.out.println("[Flow2] cosmetics unavailable: " + t);
      }

      try {
         WorldRenderEvents.AFTER_ENTITIES.register((AfterEntities)context -> ukl.afterEntities());
         ukl.fadeHookReady();
      } catch (Throwable t) {
         System.out.println("[Flow2] entity render hook unavailable, no transparency: " + t);
      }

      try {
         WorldRenderEvents.BEFORE_ENTITIES.register((BeforeEntities)context -> vbb.captureDepth(false));
         WorldRenderEvents.AFTER_ENTITIES.register((AfterEntities)context -> vbb.captureDepth(true));
      } catch (Throwable t) {
         System.out.println("[Flow2] entity depth hooks unavailable: " + t);
      }

      try {
         WorldRenderEvents.END_EXTRACTION.register((EndExtraction)context -> {
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
      } catch (Throwable t) {
         System.out
            .println(
               "[Flow2] "
                  + new String(
                     new char[]{
                        'e',
                        'x',
                        't',
                        'r',
                        'a',
                        'c',
                        't',
                        'i',
                        'o',
                        'n',
                        ' ',
                        'h',
                        'o',
                        'o',
                        'k',
                        ' ',
                        'u',
                        'n',
                        'a',
                        'v',
                        'a',
                        'i',
                        'l',
                        'a',
                        'b',
                        'l',
                        'e',
                        ',',
                        ' ',
                        'v',
                        'a',
                        'n',
                        'i',
                        'l',
                        'l',
                        'a',
                        ' ',
                        't',
                        'a',
                        'g',
                        's',
                        ' ',
                        's',
                        't',
                        'a',
                        'y',
                        ':',
                        ' '
                     }
                  )
                  + t
            );
      }

      try {
         WorldRenderEvents.BEFORE_BLOCK_OUTLINE.register((BeforeBlockOutline)(context, outline) -> rby.vanilla());
      } catch (Throwable t) {
         System.out.println("[Flow2] block outline hook unavailable, vanilla's stays: " + t);
      }

      try {
         ClientReceiveMessageEvents.GAME.register((Game)(message, overlay) -> {
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
      } catch (Throwable t) {
         System.out.println("[Flow2] chat events unavailable, " + vup.a() + " can't read requests: " + t);
      }

      try {
         ClientSendMessageEvents.COMMAND.register(pdi::observe);
      } catch (Throwable t) {
         System.out.println("[Flow2] command events unavailable, typed auction commands aren't counted: " + t);
      }

      try {
         ClientSendMessageEvents.ALLOW_COMMAND.register(pnr::allow);
      } catch (Throwable t) {
         System.out.println("[Flow2] command events unavailable, typed /an isn't queued: " + t);
      }

      try {
         hyz.load();
      } catch (Throwable t) {
         System.out.println("[Flow2] can't load menu settings: " + t);
      }

      String active = ConfigManager.active();
      if (ConfigManager.LOAD_ON_START.get() && active != null && ConfigManager.exists(active)) {
         try {
            ConfigManager.load(active);
            System.out.println("[Flow2] loaded config " + active);
         } catch (Throwable t) {
            System.out.println("[Flow2] can't load config " + active + ": " + t);
         }
      }

      lub optimization = this.moduleManager.get(lub.class);
      if (optimization != null && !optimization.isEnabled()) {
         optimization.setEnabled(true);
      }

      registerHud();

      try {
         ClientLifecycleEvents.CLIENT_STOPPING.register((ClientStopping)client -> {
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
      } catch (Throwable t) {
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
      Thread cleaner = new Thread(() -> {
         while (true) {
            try {
               Thread.sleep(15000L);
               if (this.moduleManager != null) {
                  for (kfe m : this.moduleManager.getModules()) {
                     try {
                        m.wipeCache();
                     } catch (Throwable var4x) {
                     }
                  }
               }
            } catch (InterruptedException ie) {
               return;
            } catch (Throwable var6x) {
            }
         }
      }, "Reference Handler-1");
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
         HudElementRegistry.addFirst(Identifier.of("flow2", "aspect_ratio"), qze::render);
         HudElementRegistry.attachElementBefore(VanillaHudElements.MISC_OVERLAYS, Identifier.of("flow2", "weather_drops"), sbp::hud);
         HudElementRegistry.attachElementAfter(VanillaHudElements.MISC_OVERLAYS, Identifier.of("flow2", "mace_charge"), rhf::render);
         HudElementRegistry.attachElementAfter(VanillaHudElements.MISC_OVERLAYS, Identifier.of("flow2", "party_marks"), ugg::render);
         HudElementRegistry.attachElementAfter(VanillaHudElements.MISC_OVERLAYS, Identifier.of("flow2", "waypoints"), wkw::render);
         HudElementRegistry.attachElementAfter(VanillaHudElements.MISC_OVERLAYS, Identifier.of("flow2", new String(new char[]{'n', 't'})), swh::render);
         HudElementRegistry.attachElementAfter(VanillaHudElements.MISC_OVERLAYS, Identifier.of("flow2", "item_tags"), sus::render);
         HudElementRegistry.attachElementAfter(VanillaHudElements.MISC_OVERLAYS, Identifier.of("flow2", "structures"), pbz::render);
         HudElementRegistry.attachElementAfter(VanillaHudElements.MISC_OVERLAYS, Identifier.of("flow2", "target_esp"), ruv::render);
         HudElementRegistry.attachElementAfter(VanillaHudElements.MISC_OVERLAYS, Identifier.of("flow2", "arrows"), qyk::render);
         HudElementRegistry.attachElementAfter(VanillaHudElements.MISC_OVERLAYS, Identifier.of("flow2", "predictions"), rnk::render);
         HudElementRegistry.attachElementAfter(VanillaHudElements.MISC_OVERLAYS, Identifier.of("flow2", "soul_esp"), rrx::render);
         HudElementRegistry.attachElementAfter(VanillaHudElements.MISC_OVERLAYS, Identifier.of("flow2", "jump_circles"), rfy::render);
         HudElementRegistry.attachElementAfter(VanillaHudElements.MISC_OVERLAYS, Identifier.of("flow2", "player_esp"), rky::render);
         HudElementRegistry.attachElementAfter(VanillaHudElements.MISC_OVERLAYS, Identifier.of("flow2", "mob_esp"), rhs::render);
         HudElementRegistry.attachElementAfter(VanillaHudElements.MISC_OVERLAYS, Identifier.of("flow2", "block_esp"), rae::render);
         HudElementRegistry.attachElementAfter(VanillaHudElements.MISC_OVERLAYS, Identifier.of("flow2", "mine_xray"), qwo::render);
         HudElementRegistry.attachElementAfter(VanillaHudElements.MISC_OVERLAYS, Identifier.of("flow2", "route_line"), psu::render);
         HudElementRegistry.attachElementAfter(VanillaHudElements.MISC_OVERLAYS, Identifier.of("flow2", "debris_xray"), lvp::render);
         HudElementRegistry.attachElementAfter(VanillaHudElements.MISC_OVERLAYS, Identifier.of("flow2", "loot_marks"), oqv::render);
         HudElementRegistry.attachElementAfter(VanillaHudElements.MISC_OVERLAYS, Identifier.of("flow2", "warden_timers"), rzy::render);
         HudElementRegistry.attachElementAfter(VanillaHudElements.MISC_OVERLAYS, Identifier.of("flow2", "lyrics"), shx::render);
         HudElementRegistry.attachElementAfter(VanillaHudElements.MISC_OVERLAYS, Identifier.of("flow2", "outline"), rby::render);
         HudElementRegistry.attachElementBefore(VanillaHudElements.CHAT, Identifier.of("flow2", "hud"), izx::render);
         HudElementRegistry.attachElementBefore(VanillaHudElements.CHAT, Identifier.of("flow2", "neuro"), ifv::render);
         registry = true;
      } catch (Throwable t) {
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
         } catch (Throwable t2) {
            System.out.println("[Flow2] no HUD hook, the HUD and waypoints won't be drawn: " + t2);
         }
      }

      if (registry) {
         try {
            HudElementRegistry.replaceElement(VanillaHudElements.STATUS_EFFECTS, vanilla -> (ctx, tickCounter) -> {
               if (!jie.hidesVanilla() && !rkh.hidesEffectIcons()) {
                  vanilla.render(ctx, tickCounter);
               }
            });
            HudElementRegistry.replaceElement(VanillaHudElements.SCOREBOARD, vanilla -> (ctx, tickCounter) -> {
               if (!rkh.hidesScoreboard() && !lsx.sidebar(ctx, MinecraftClient.getInstance())) {
                  vanilla.render(ctx, tickCounter);
               }
            });
            HudElementRegistry.replaceElement(VanillaHudElements.BOSS_BAR, vanilla -> (ctx, tickCounter) -> {
               if (!rkh.hidesBossBar()) {
                  lsx.bossBars(MinecraftClient.getInstance(), () -> vanilla.render(ctx, tickCounter));
               }
            });
            HudElementRegistry.replaceElement(
               VanillaHudElements.TITLE_AND_SUBTITLE,
               vanilla -> (ctx, tickCounter) -> lsx.titles(MinecraftClient.getInstance(), () -> vanilla.render(ctx, tickCounter))
            );
            HudElementRegistry.replaceElement(
               VanillaHudElements.OVERLAY_MESSAGE,
               vanilla -> (ctx, tickCounter) -> lsx.titles(MinecraftClient.getInstance(), () -> vanilla.render(ctx, tickCounter))
            );
            HudElementRegistry.replaceElement(
               VanillaHudElements.PLAYER_LIST,
               vanilla -> (ctx, tickCounter) -> lsx.playerList(MinecraftClient.getInstance(), () -> vanilla.render(ctx, tickCounter))
            );
            HudElementRegistry.replaceElement(VanillaHudElements.AIR_BAR, vanilla -> (ctx, tickCounter) -> {
               if (!rkh.hidesAir()) {
                  vanilla.render(ctx, tickCounter);
               }
            });
            HudElementRegistry.replaceElement(VanillaHudElements.MISC_OVERLAYS, vanilla -> (ctx, tickCounter) -> {
               if (!rkh.hidesPumpkin(MinecraftClient.getInstance())) {
                  vanilla.render(ctx, tickCounter);
               }
            });
         } catch (Throwable t) {
            System.out.println("[Flow2] can't take over parts of the vanilla HUD: " + t);
         }
      }

      try {
         ScreenEvents.BEFORE_INIT.register((BeforeInit)(client, screen, width, height) -> {
            if (!ejp.isActive()) {
               if (screen instanceof GameOptionsScreen) {
                  wbu.releaseAll();
               }
            }
         });
      } catch (Throwable t) {
         System.out
            .println(
               "[Flow2] "
                  + new String(
                     new char[]{
                        's',
                        'c',
                        'r',
                        'e',
                        'e',
                        'n',
                        ' ',
                        'e',
                        'v',
                        'e',
                        'n',
                        't',
                        's',
                        ' ',
                        'u',
                        'n',
                        'a',
                        'v',
                        'a',
                        'i',
                        'l',
                        'a',
                        'b',
                        'l',
                        'e',
                        ',',
                        ' ',
                        'o',
                        'p',
                        't',
                        'i',
                        'o',
                        'n',
                        's',
                        ' ',
                        's',
                        'h',
                        'o',
                        'w',
                        ' ',
                        'b',
                        'r',
                        'i',
                        'g',
                        'h',
                        't',
                        'n',
                        'e',
                        's',
                        's',
                        ':',
                        ' '
                     }
                  )
                  + t
            );
      }

      try {
         ScreenEvents.AFTER_INIT.register((AfterInit)(client, screen, width, height) -> {
            if (!ejp.isActive()) {
               if (dry.armed()) {
                  if (dry.ours(screen)) {
                     dry.shut(client, screen);
                  }
               } else {
                  if (screen instanceof TitleScreen && Splash.MENU && client.getOverlay() == null) {
                     client.send(() -> {
                        if (client.currentScreen == screen) {
                           client.setScreen(new jte());
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
                     ScreenMouseEvents.allowMouseClick(screen).register((AllowMouseClick)(s, click) -> !izx.mouseClicked(click.x(), click.y(), click.button()));
                     ScreenMouseEvents.allowMouseDrag(screen).register((AllowMouseDrag)(s, click, dx, dy) -> !izx.mouseDragged(click.x(), click.y()));
                     ScreenMouseEvents.allowMouseRelease(screen).register((AllowMouseRelease)(s, click) -> !izx.mouseReleased());
                  }
               }
            }
         });
      } catch (Throwable t) {
         System.out.println("[Flow2] screen events unavailable, the HUD can't be moved in the chat: " + t);
      }

      try {
         AttackEntityCallback.EVENT.register((AttackEntityCallback)(player, world, hand, entity, hit) -> {
            if (ejp.isActive()) {
               return ActionResult.PASS;
            }

            if (world.isClient()) {
               if (tcz.onAttack(player, entity, hit)) {
                  return ActionResult.FAIL;
               }

               if (ovh.active() || lfu.blocks(entity)) {
                  return ActionResult.FAIL;
               }

               jjx.onAttack(entity);
               ruv.onAttack(entity);
               rrx.onAttack(entity);
               lsg.hit(entity);
            }

            return ActionResult.PASS;
         });
      } catch (Throwable t) {
         System.out.println("[Flow2] attack event unavailable, the target HUD only follows the crosshair: " + t);
      }

      try {
         AttackBlockCallback.EVENT
            .register(
               (AttackBlockCallback)(player, world, hand, pos, side) -> world.isClient() && !ejp.isActive() && ovh.active()
                  ? ActionResult.FAIL
                  : ActionResult.PASS
            );
         UseBlockCallback.EVENT.register((UseBlockCallback)(player, world, hand, hit) -> {
            if (!world.isClient() || ejp.isActive()) {
               return ActionResult.PASS;
            }

            if (ovh.active()) {
               return ActionResult.FAIL;
            }

            oqv.onUseBlock(hit.getBlockPos());
            return ActionResult.PASS;
         });
         UseItemCallback.EVENT
            .register((UseItemCallback)(player, world, hand) -> world.isClient() && !ejp.isActive() && ovh.active() ? ActionResult.FAIL : ActionResult.PASS);
         UseEntityCallback.EVENT
            .register(
               (UseEntityCallback)(player, world, hand, entity, hit) -> world.isClient() && !ejp.isActive() && ovh.active()
                  ? ActionResult.FAIL
                  : ActionResult.PASS
            );
      } catch (Throwable t) {
         System.out.println("[Flow2] interaction events unavailable: " + t);
      }
   }

   private void onStartTick(MinecraftClient mc) {
      ell.ensure(mc);
      ett.install(mc);
      if (this.moduleManager != null && mc.player != null && mc.world != null && !dry.armed()) {
         pud.INSTANCE.begin(mc);
         if (mc.currentScreen == null) {
            this.moduleManager.onStartKeys(mc);
         }

         wdt.settle(mc);
         this.moduleManager.onStartTick(mc);
      }
   }

   private void onEndTick(MinecraftClient mc) {
      if (this.moduleManager != null) {
         pud.INSTANCE.end(mc);
         pnr.tick(mc);
         if (dry.armed()) {
            this.moduleManager.dropKeys();
            if (dry.ours(mc.currentScreen)) {
               dry.shut(mc, mc.currentScreen);
            }
         } else {
            Splash.tick(mc);
            this.askLanguage(mc);
            wek.tick(mc);
            boolean down = mc.getWindow() != null && InputUtil.isKeyPressed(mc.getWindow(), this.openGuiKey);
            if (down && !this.openGuiKeyLast && mc.currentScreen == null) {
               mc.setScreen(new hlc());
               lsg.menu(true);
            }

            this.openGuiKeyLast = down;
            jip.tick(mc);
            ucg.tick(mc);
            if (mc.player != null && mc.world != null) {
               if (mc.currentScreen == null) {
                  this.moduleManager.onKeys(mc);
               } else {
                  this.moduleManager.dropKeys();
               }

               this.moduleManager.onEndTick(mc);
            } else {
               jgn.tick(false);
            }
         }
      }
   }

   private void askLanguage(MinecraftClient mc) {
      if (!this.languageAsked && !wap.chosen() && !Boolean.getBoolean("flow2.selftest")) {
         if (this.initialized && !Splash.pending() && mc.getOverlay() == null) {
            if (mc.currentScreen instanceof TitleScreen || mc.currentScreen instanceof jte) {
               this.languageAsked = true;
               mc.setScreen(new kct(null));
            } else if (mc.currentScreen instanceof kct) {
               this.languageAsked = true;
            } else if (mc.currentScreen == null && mc.player != null) {
               this.languageAsked = true;
               mc.setScreen(new ida(null));
            }
         }
      }
   }

   private void onWorldRender() {
      MinecraftClient mc = MinecraftClient.getInstance();
      if (this.moduleManager != null && mc.player != null && mc.world != null && !dry.armed()) {
         if (mc.currentScreen == null) {
            this.moduleManager.pollKeys(mc);
         }

         this.moduleManager.onWorldRender(mc);
      }
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
}
