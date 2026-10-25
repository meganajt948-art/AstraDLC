package a;

import flow.dev.a;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.ClientBossBar;
import net.minecraft.client.gui.screen.DeathScreen;
import net.minecraft.client.gui.screen.DeathScreen.TitleScreenConfirmScreen;
import net.minecraft.client.input.KeyboardInput;
import net.minecraft.client.network.ClientConnectionState;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.recipebook.ClientRecipeBook;
import net.minecraft.client.search.SearchManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.world.ClientWorld.Properties;
import net.minecraft.component.type.MapIdComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.Entity.RemovalReason;
import net.minecraft.entity.boss.BossBar.Color;
import net.minecraft.entity.boss.BossBar.Style;
import net.minecraft.entity.vehicle.AbstractBoatEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.map.MapState;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.DisconnectionInfo;
import net.minecraft.network.NetworkThreadUtils;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.common.ResourcePackStatusC2SPacket;
import net.minecraft.network.packet.c2s.common.ResourcePackStatusC2SPacket.Status;
import net.minecraft.network.packet.c2s.play.AcknowledgeReconfigurationC2SPacket;
import net.minecraft.network.packet.c2s.play.ClientStatusC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerLoadedC2SPacket;
import net.minecraft.network.packet.c2s.play.ClientStatusC2SPacket.Mode;
import net.minecraft.network.packet.s2c.common.ClearDialogS2CPacket;
import net.minecraft.network.packet.s2c.common.ResourcePackRemoveS2CPacket;
import net.minecraft.network.packet.s2c.common.ResourcePackSendS2CPacket;
import net.minecraft.network.packet.s2c.common.ServerTransferS2CPacket;
import net.minecraft.network.packet.s2c.common.ShowDialogS2CPacket;
import net.minecraft.network.packet.s2c.play.AdvancementUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.BossBarS2CPacket;
import net.minecraft.network.packet.s2c.play.ChatMessageS2CPacket;
import net.minecraft.network.packet.s2c.play.ChunkDataS2CPacket;
import net.minecraft.network.packet.s2c.play.ChunkLoadDistanceS2CPacket;
import net.minecraft.network.packet.s2c.play.ClearTitleS2CPacket;
import net.minecraft.network.packet.s2c.play.CommonPlayerSpawnInfo;
import net.minecraft.network.packet.s2c.play.DeathMessageS2CPacket;
import net.minecraft.network.packet.s2c.play.DebugSampleS2CPacket;
import net.minecraft.network.packet.s2c.play.EnterReconfigurationS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityPassengersSetS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityStatusS2CPacket;
import net.minecraft.network.packet.s2c.play.ExplosionS2CPacket;
import net.minecraft.network.packet.s2c.play.GameJoinS2CPacket;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import net.minecraft.network.packet.s2c.play.GameStateChangeS2CPacket;
import net.minecraft.network.packet.s2c.play.GameTestHighlightPosS2CPacket;
import net.minecraft.network.packet.s2c.play.ItemPickupAnimationS2CPacket;
import net.minecraft.network.packet.s2c.play.MapUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.OpenScreenS2CPacket;
import net.minecraft.network.packet.s2c.play.OpenWrittenBookS2CPacket;
import net.minecraft.network.packet.s2c.play.OverlayMessageS2CPacket;
import net.minecraft.network.packet.s2c.play.ParticleS2CPacket;
import net.minecraft.network.packet.s2c.play.PlaySoundFromEntityS2CPacket;
import net.minecraft.network.packet.s2c.play.PlaySoundS2CPacket;
import net.minecraft.network.packet.s2c.play.PlayerListHeaderS2CPacket;
import net.minecraft.network.packet.s2c.play.PlayerRespawnS2CPacket;
import net.minecraft.network.packet.s2c.play.ProfilelessChatMessageS2CPacket;
import net.minecraft.network.packet.s2c.play.RecipeBookAddS2CPacket;
import net.minecraft.network.packet.s2c.play.RemoveMessageS2CPacket;
import net.minecraft.network.packet.s2c.play.SelectAdvancementTabS2CPacket;
import net.minecraft.network.packet.s2c.play.ServerMetadataS2CPacket;
import net.minecraft.network.packet.s2c.play.SetCameraEntityS2CPacket;
import net.minecraft.network.packet.s2c.play.StopSoundS2CPacket;
import net.minecraft.network.packet.s2c.play.SubtitleS2CPacket;
import net.minecraft.network.packet.s2c.play.TitleFadeS2CPacket;
import net.minecraft.network.packet.s2c.play.TitleS2CPacket;
import net.minecraft.network.packet.s2c.play.WorldEventS2CPacket;
import net.minecraft.network.packet.s2c.play.BossBarS2CPacket.Consumer;
import net.minecraft.network.packet.s2c.play.GameStateChangeS2CPacket.Reason;
import net.minecraft.network.packet.s2c.play.RecipeBookAddS2CPacket.Entry;
import net.minecraft.network.state.ConfigurationStates;
import net.minecraft.registry.RegistryKey;
import net.minecraft.stat.StatHandler;
import net.minecraft.text.Text;
import net.minecraft.util.PlayerInput;
import net.minecraft.world.Difficulty;
import net.minecraft.world.chunk.WorldChunk;

final class ehy extends ClientPlayNetworkHandler {
   static final long ehz = ejl.offset(ClientPlayNetworkHandler.class, ClientWorld.class);
   static final long eia = ejl.offset(ClientPlayNetworkHandler.class, Properties.class);
   static final long eib = ejl.offset(ClientPlayNetworkHandler.class, SearchManager.class);
   static final Field eic = vxr.find(
      ClientPlayNetworkHandler.class,
      a.c(-1291259695, "\uf0a8褒ϐ鷻ᙯ郚⪎ꍴ㴭랍き쨻䓾\udd15國퇵殷\ue474织\uf8ba焤୰藄"),
      a.d("⽛囥\udc3a䉂증众\uf52d糞\ue283栳\uefe3", -946701221, 1768641389),
      a.d("뚋", -1562936494, 647286146)
   );
   final dtv eid;
   Properties eie;
   int eif = 3;
   int eig = 3;

   ehy(MinecraftClient var1, ClientConnection var2, ClientConnectionState var3, dtv var4) {
      super(var1, var2, var3);
      this.eid = var4;
      ejl.put(this, eib, eky.SEARCH);
   }

   static ehy create(MinecraftClient var0, ClientConnection var1, ClientConnectionState var2, dtv var3) {
      boolean var4 = ejp.current() == var3;
      Object[] var5 = ega.saveAddons();

      try {
         ehy var6 = new ehy(var0, var1, var2, var3);
         var3.fabricAddons = ega.created(var5, var3.fabricAddons);
         var3.onPlayHandler(var6);
         return var6;
      } finally {
         if (!var4) {
            ega.restoreAddons(var5);
         }
      }
   }

   void eij(ClientWorld var1) {
      ejl.put(this, ehz, var1);
      ejl.put(this, eia, this.eie);
   }

   void setPlayerLoaded(boolean var1) {
      if (eic != null) {
         try {
            eic.setBoolean(this, var1);
         } catch (IllegalAccessException var3) {
         }
      }
   }

   void markLoaded() {
      if (!this.method_76760()) {
         this.sendPacket(new PlayerLoadedC2SPacket());
         this.setPlayerLoaded(true);
      }
   }

   @Override
   public void onGameJoin(GameJoinS2CPacket packet) {
      NetworkThreadUtils.forceMainThread(packet, this, this.client.getPacketApplyBatcher());
      ClientPlayerInteractionManager var2 = new ClientPlayerInteractionManager(this.client, this);
      this.client.interactionManager = var2;
      CommonPlayerSpawnInfo var3 = packet.commonPlayerSpawnInfo();
      this.eif = packet.viewDistance();
      this.eig = packet.simulationDistance();
      this.eie = new Properties(Difficulty.NORMAL, packet.hardcore(), var3.isFlat());
      elh var4 = new elh(
         this, this.eie, var3.dimension(), var3.dimensionType(), this.eif, this.eig, eky.WORLD_RENDERER, var3.isDebug(), var3.seed(), var3.seaLevel(), this.eid
      );
      this.eij(var4);
      this.client.world = var4;
      this.setPlayerLoaded(false);
      eik var5 = new eik(this.client, var4, this, new StatHandler(), new ClientRecipeBook(), PlayerInput.DEFAULT, false, this.eid);
      var5.setYaw(-180.0F);
      var5.init();
      var5.setId(packet.playerEntityId());
      var4.addEntity(var5);
      var5.input = new KeyboardInput(this.client.options);
      this.client.player = var5;
      edj.camera(var5);
      var2.copyAbilities(var5);
      var5.setReducedDebugInfo(packet.reducedDebugInfo());
      var5.setShowsDeathScreen(packet.showDeathScreen());
      var5.setLimitedCraftingEnabled(packet.doLimitedCrafting());
      var5.setLastDeathPos(var3.lastDeathLocation());
      var5.setPortalCooldown(var3.portalCooldown());
      var2.setGameModes(var3.gameMode(), var3.lastGameMode());
      this.worldSession.setGameMode(var3.gameMode(), packet.hardcore());
      this.eid.onJoinWorld(var4, var5);
   }

   @Override
   public void onPlayerRespawn(PlayerRespawnS2CPacket packet) {
      NetworkThreadUtils.forceMainThread(packet, this, this.client.getPacketApplyBatcher());
      CommonPlayerSpawnInfo var2 = packet.commonPlayerSpawnInfo();
      RegistryKey var3 = var2.dimension();
      ClientPlayerEntity var4 = this.client.player;
      ClientWorld var5 = this.getWorld();
      boolean var6 = var4 == null || var5 == null || var3 != var4.getEntityWorld().getRegistryKey();
      if (var6) {
         Map var7 = var5 instanceof elh var8 ? var8.maps() : null;
         Difficulty var12 = this.eie == null ? Difficulty.NORMAL : this.eie.getDifficulty();
         boolean var9 = this.eie != null && this.eie.isHardcore();
         this.eie = new Properties(var12, var9, var2.isFlat());
         elh var10 = new elh(
            this, this.eie, var3, var2.dimensionType(), this.eif, this.eig, eky.WORLD_RENDERER, var2.isDebug(), var2.seed(), var2.seaLevel(), this.eid
         );
         if (var7 != null) {
            var10.copyMaps(var7);
         }

         this.eij(var10);
         this.client.world = var10;
         var5 = var10;
      }

      edj.camera(null);
      if (var4 != null && var4.shouldCloseHandledScreenOnRespawn()) {
         var4.closeHandledScreen();
      }

      boolean var11 = packet.hasFlag((byte)2);
      eik var13 = new eik(
         this.client,
         var5,
         this,
         var4 == null ? new StatHandler() : var4.getStatHandler(),
         var4 == null ? new ClientRecipeBook() : var4.getRecipeBook(),
         var11 && var4 != null ? var4.getLastPlayerInput() : PlayerInput.DEFAULT,
         var11 && var4 != null && var4.isSprinting(),
         this.eid
      );
      this.setPlayerLoaded(false);
      if (var4 != null) {
         var13.setId(var4.getId());
      }

      this.client.player = var13;
      edj.camera(var13);
      if (var11 && var4 != null) {
         List var14 = var4.getDataTracker().getChangedEntries();
         if (var14 != null) {
            var13.getDataTracker().writeUpdatedEntries(var14);
         }

         var13.setVelocity(var4.getVelocity());
         var13.setYaw(var4.getYaw());
         var13.setPitch(var4.getPitch());
      } else {
         var13.init();
         var13.setYaw(-180.0F);
      }

      if (var4 != null) {
         if (packet.hasFlag((byte)1)) {
            var13.getAttributes().setFrom(var4.getAttributes());
         } else {
            var13.getAttributes().setBaseFrom(var4.getAttributes());
         }
      }

      var5.addEntity(var13);
      var13.input = new KeyboardInput(this.client.options);
      this.client.interactionManager.copyAbilities(var13);
      if (var4 != null) {
         var13.setReducedDebugInfo(var4.hasReducedDebugInfo());
         var13.setShowsDeathScreen(var4.showsDeathScreen());
         var13.nauseaIntensity = var4.nauseaIntensity;
         var13.lastNauseaIntensity = var4.lastNauseaIntensity;
      }

      var13.setLastDeathPos(var2.lastDeathLocation());
      var13.setPortalCooldown(var2.portalCooldown());
      if (this.client.currentScreen instanceof DeathScreen || this.client.currentScreen instanceof TitleScreenConfirmScreen) {
         this.client.setScreen(null);
      }

      this.client.interactionManager.setGameModes(var2.gameMode(), var2.lastGameMode());
      this.eid.onRespawn(var5, var13, var6);
   }

   @Override
   public void onEnterReconfiguration(EnterReconfigurationS2CPacket packet) {
      NetworkThreadUtils.forceMainThread(packet, this, this.client.getPacketApplyBatcher());
      ClientConnectionState var2 = new ClientConnectionState(
         null,
         this.getProfile(),
         this.worldSession,
         this.getRegistryManager(),
         this.getEnabledFeatures(),
         this.brand,
         this.serverInfo,
         null,
         this.serverCookies,
         null,
         this.customReportDetails,
         this.getServerLinks(),
         this.seenPlayers,
         this.seenInsecureChatWarning
      );
      ecr var3 = ecr.create(this.client, this.connection, var2, this.eid, this.getProfile(), this.getRegistryManager());
      ClientConnection var4 = this.connection;
      ((edb)var4).runInLoop(() -> {
         var4.transitionInbound(ConfigurationStates.S2C, var3);
         var4.send(AcknowledgeReconfigurationC2SPacket.INSTANCE);
         var4.transitionOutbound(ConfigurationStates.C2S);
      });
      this.eid.onReconfigure();
   }

   @Override
   public void onSetCameraEntity(SetCameraEntityS2CPacket packet) {
      NetworkThreadUtils.forceMainThread(packet, this, this.client.getPacketApplyBatcher());
      Entity var2 = packet.getEntity(this.getWorld());
      if (var2 != null) {
         edj.camera(var2);
      }
   }

   @Override
   public void onEntityPassengersSet(EntityPassengersSetS2CPacket packet) {
      NetworkThreadUtils.forceMainThread(packet, this, this.client.getPacketApplyBatcher());
      ClientWorld var2 = this.getWorld();
      Entity var3 = var2.getEntityById(packet.getEntityId());
      if (var3 != null) {
         boolean var4 = var3.hasPassengerDeep(this.client.player);
         var3.removeAllPassengers();

         for (int var8 : packet.getPassengerIds()) {
            Entity var9 = var2.getEntityById(var8);
            if (var9 != null) {
               var9.startRiding(var3, true, false);
               if (var9 == this.client.player && !var4 && var3 instanceof AbstractBoatEntity) {
                  this.client.player.lastYaw = var3.getYaw();
                  this.client.player.setYaw(var3.getYaw());
                  this.client.player.setHeadYaw(var3.getYaw());
               }
            }
         }
      }
   }

   @Override
   public void onEntityStatus(EntityStatusS2CPacket packet) {
      if (packet.getStatus() == 35) {
         NetworkThreadUtils.forceMainThread(packet, this, this.client.getPacketApplyBatcher());
         Entity var2 = packet.getEntity(this.getWorld());
         if (var2 != null && var2 == this.client.player) {
            this.eid.onTotemPop();
         }
      } else {
         super.onEntityStatus(packet);
      }
   }

   @Override
   public void onGameStateChange(GameStateChangeS2CPacket packet) {
      NetworkThreadUtils.forceMainThread(packet, this, this.client.getPacketApplyBatcher());
      Reason var2 = packet.getReason();
      if (var2 == GameStateChangeS2CPacket.GAME_WON) {
         this.sendPacket(new ClientStatusC2SPacket(Mode.PERFORM_RESPAWN));
      } else {
         if (var2 == GameStateChangeS2CPacket.DEMO_MESSAGE_SHOWN) {
            return;
         }

         if (var2 == GameStateChangeS2CPacket.INITIAL_CHUNKS_COMING) {
            this.eid.onChunksComing();
         } else if (var2 == GameStateChangeS2CPacket.NO_RESPAWN_BLOCK) {
            this.eid.chat.system(Text.translatable(a.c(-1616684029, "屾◁꼑ㅬ몳㱇虗ྡྷ釺ᭀ鲕曵\ue831熇\ufbc6絭읿䢭툏呈\udda6ꞷ⥄는㓰븊ސ觖ጬ镸Ệ")).getString());
         } else {
            super.onGameStateChange(packet);
         }
      }
   }

   @Override
   public void onExplosion(ExplosionS2CPacket packet) {
      NetworkThreadUtils.forceMainThread(packet, this, this.client.getPacketApplyBatcher());
      if (this.client.player != null) {
         packet.playerKnockback().ifPresent(this.client.player::addVelocityInternal);
      }
   }

   @Override
   public void onDeathMessage(DeathMessageS2CPacket packet) {
      NetworkThreadUtils.forceMainThread(packet, this, this.client.getPacketApplyBatcher());
      Entity var2 = this.getWorld().getEntityById(packet.playerId());
      if (var2 != null && var2 == this.client.player) {
         this.eid.onDeath(packet.message());
      }

      super.onDeathMessage(packet);
   }

   @Override
   public void onOpenScreen(OpenScreenS2CPacket packet) {
      super.onOpenScreen(packet);
      this.eid.onScreenOpened(packet.getName());
   }

   @Override
   public void onOpenWrittenBook(OpenWrittenBookS2CPacket packet) {
   }

   @Override
   public void onItemPickupAnimation(ItemPickupAnimationS2CPacket packet) {
      NetworkThreadUtils.forceMainThread(packet, this, this.client.getPacketApplyBatcher());
      ClientWorld var2 = this.getWorld();
      Entity var3 = var2.getEntityById(packet.getEntityId());
      if (var3 != null) {
         if (var3 instanceof ItemEntity var4) {
            ItemStack var5 = var4.getStack();
            if (!var5.isEmpty()) {
               var5.decrement(packet.getStackAmount());
            }

            if (var5.isEmpty()) {
               var2.removeEntity(packet.getEntityId(), RemovalReason.DISCARDED);
            }
         } else if (!(var3 instanceof ExperienceOrbEntity)) {
            var2.removeEntity(packet.getEntityId(), RemovalReason.DISCARDED);
         }
      }
   }

   @Override
   public void onChunkData(ChunkDataS2CPacket packet) {
      super.onChunkData(packet);
      ClientWorld var2 = this.getWorld();
      int var3 = packet.getChunkX();
      int var4 = packet.getChunkZ();
      var2.enqueueChunkUpdate(() -> {
         WorldChunk var4x = var2.getChunkManager().getWorldChunk(var3, var4, false);
         if (var4x != null) {
            this.eid.onChunkLoaded(var4x);
         }
      });
   }

   @Override
   public void onChunkLoadDistance(ChunkLoadDistanceS2CPacket packet) {
      NetworkThreadUtils.forceMainThread(packet, this, this.client.getPacketApplyBatcher());
      this.eif = packet.getDistance();
      this.getWorld().getChunkManager().updateLoadDistance(packet.getDistance());
   }

   @Override
   public void onGameMessage(GameMessageS2CPacket packet) {
      NetworkThreadUtils.forceMainThread(packet, this, this.client.getPacketApplyBatcher());
      this.eid.onServerMessage(packet.content(), packet.overlay());
   }

   @Override
   public void onChatMessage(ChatMessageS2CPacket packet) {
      NetworkThreadUtils.forceMainThread(packet, this, this.client.getPacketApplyBatcher());
      Text var2 = packet.unsignedContent() != null ? packet.unsignedContent() : Text.literal(packet.body().content());

      Text var3;
      try {
         var3 = packet.serializedParameters().applyChatDecoration(var2);
      } catch (Throwable var5) {
         var3 = var2;
      }

      this.eid.onServerMessage(var3, false, true);
   }

   @Override
   public void onProfilelessChatMessage(ProfilelessChatMessageS2CPacket packet) {
      NetworkThreadUtils.forceMainThread(packet, this, this.client.getPacketApplyBatcher());

      Text var2;
      try {
         var2 = packet.chatType().applyChatDecoration(packet.message());
      } catch (Throwable var4) {
         var2 = packet.message();
      }

      this.eid.onServerMessage(var2, false, true);
   }

   @Override
   public void onRemoveMessage(RemoveMessageS2CPacket packet) {
   }

   @Override
   public void onOverlayMessage(OverlayMessageS2CPacket packet) {
      NetworkThreadUtils.forceMainThread(packet, this, this.client.getPacketApplyBatcher());
      this.eid.onServerMessage(packet.text(), true);
   }

   @Override
   public void onTitle(TitleS2CPacket packet) {
      NetworkThreadUtils.forceMainThread(packet, this, this.client.getPacketApplyBatcher());
      this.eid.onTitle(packet.text(), false);
   }

   @Override
   public void onSubtitle(SubtitleS2CPacket packet) {
      NetworkThreadUtils.forceMainThread(packet, this, this.client.getPacketApplyBatcher());
      this.eid.onTitle(packet.text(), true);
   }

   @Override
   public void onTitleFade(TitleFadeS2CPacket packet) {
   }

   @Override
   public void onTitleClear(ClearTitleS2CPacket packet) {
      NetworkThreadUtils.forceMainThread(packet, this, this.client.getPacketApplyBatcher());
      this.eid.onTitle(null, false);
   }

   @Override
   public void onPlayerListHeader(PlayerListHeaderS2CPacket packet) {
      NetworkThreadUtils.forceMainThread(packet, this, this.client.getPacketApplyBatcher());
      this.eid.tabHeader = packet.header();
      this.eid.tabFooter = packet.footer();
   }

   @Override
   public void onBossBar(BossBarS2CPacket packet) {
      NetworkThreadUtils.forceMainThread(packet, this, this.client.getPacketApplyBatcher());
      final Map var2 = this.eid.bossBars;
      packet.accept(new Consumer() {
         @Override
         public void add(UUID uuid, Text name, float percent, Color color, Style style, boolean darkenSky, boolean dragonMusic, boolean thickenFog) {
            var2.put(uuid, new ClientBossBar(uuid, name, percent, color, style, darkenSky, dragonMusic, thickenFog));
         }

         @Override
         public void remove(UUID uuid) {
            var2.remove(uuid);
         }

         @Override
         public void updateProgress(UUID uuid, float percent) {
            ClientBossBar var3 = (ClientBossBar)var2.get(uuid);
            if (var3 != null) {
               var3.setPercent(percent);
            }
         }

         @Override
         public void updateName(UUID uuid, Text name) {
            ClientBossBar var3 = (ClientBossBar)var2.get(uuid);
            if (var3 != null) {
               var3.setName(name);
            }
         }

         @Override
         public void updateStyle(UUID id, Color color, Style style) {
            ClientBossBar var4 = (ClientBossBar)var2.get(id);
            if (var4 != null) {
               var4.setColor(color);
               var4.setStyle(style);
            }
         }

         @Override
         public void updateProperties(UUID uuid, boolean darkenSky, boolean dragonMusic, boolean thickenFog) {
            ClientBossBar var5 = (ClientBossBar)var2.get(uuid);
            if (var5 != null) {
               var5.setDarkenSky(darkenSky);
               var5.setDragonMusic(dragonMusic);
               var5.setThickenFog(thickenFog);
            }
         }
      });
   }

   @Override
   public void onAdvancements(AdvancementUpdateS2CPacket packet) {
   }

   @Override
   public void onSelectAdvancementTab(SelectAdvancementTabS2CPacket packet) {
   }

   @Override
   public void onRecipeBookAdd(RecipeBookAddS2CPacket packet) {
      NetworkThreadUtils.forceMainThread(packet, this, this.client.getPacketApplyBatcher());
      if (this.client.player != null) {
         ClientRecipeBook var2 = this.client.player.getRecipeBook();
         if (packet.replace()) {
            var2.clear();
         }

         for (Entry var4 : packet.entries()) {
            var2.add(var4.contents());
            if (var4.isHighlighted()) {
               var2.markHighlighted(var4.contents().id());
            }
         }

         var2.refresh();
      }
   }

   @Override
   public void onServerMetadata(ServerMetadataS2CPacket packet) {
      NetworkThreadUtils.forceMainThread(packet, this, this.client.getPacketApplyBatcher());
      this.eid.serverLabel = packet.description();
   }

   @Override
   public void onMapUpdate(MapUpdateS2CPacket packet) {
      NetworkThreadUtils.forceMainThread(packet, this, this.client.getPacketApplyBatcher());
      ClientWorld var2 = this.getWorld();
      MapIdComponent var3 = packet.mapId();
      MapState var4 = var2.getMapState(var3);
      if (var4 == null) {
         var4 = MapState.of(packet.scale(), packet.locked(), var2.getRegistryKey());
         var2.putClientsideMapState(var3, var4);
      }

      packet.apply(var4);
      this.eid.onMapUpdated(var3);
   }

   @Override
   public void onDebugSample(DebugSampleS2CPacket packet) {
   }

   @Override
   public void onGameTestHighlightPos(GameTestHighlightPosS2CPacket packet) {
   }

   @Override
   public void onCustomPayload(CustomPayload payload) {
   }

   @Override
   public void onPlaySound(PlaySoundS2CPacket packet) {
   }

   @Override
   public void onPlaySoundFromEntity(PlaySoundFromEntityS2CPacket packet) {
   }

   @Override
   public void onStopSound(StopSoundS2CPacket packet) {
   }

   @Override
   public void onParticle(ParticleS2CPacket packet) {
   }

   @Override
   public void onWorldEvent(WorldEventS2CPacket packet) {
   }

   @Override
   public void onResourcePackSend(ResourcePackSendS2CPacket packet) {
      this.eid.packs.offer(packet, this.connection);
   }

   @Override
   public void onResourcePackRemove(ResourcePackRemoveS2CPacket packet) {
   }

   @Override
   public void onServerTransfer(ServerTransferS2CPacket packet) {
      this.connection
         .disconnect(
            Text.literal(
               a.d("崖⒳긕〖믆㴂茱ໟ邊ᩎ鷨枖\ue943烷\ufada籓숇䧋퍵儴\udcd7꛲⡂돣㖑뽇˭袬\u125f鑺ᾼ\ue119漭\uf6c6", 114528081, 77125188)
                  + packet.host()
                  + a.c(33784368, "舋")
                  + packet.port()
            )
         );
   }

   @Override
   public void onShowDialog(ShowDialogS2CPacket packet) {
      this.eid.chat.system(a.d("혁꾤│묁パ똕ࠦ藈ᮖ鄣\u16fa\uec8c扜ﯦ疮\uf74b䴈싑塩\ude3d埇⦅ꜻ㳧뺇㐩跤δ餿ὤ钫橲", -251789824, 1043409920));
   }

   @Override
   public void onClearDialog(ClearDialogS2CPacket packet) {
   }

   @Override
   public void tick() {
      this.sendQueuedPackets();
      this.worldSession.tick();
      this.eid.packs.tick(this.connection);
      this.eid.tickLoading(this);
   }

   @Override
   public void onDisconnected(DisconnectionInfo info) {
      this.worldSession.onUnload();
      this.eid.onDisconnected(info.reason());
   }

   @Override
   public DisconnectionInfo createDisconnectionInfo(Text reason, Throwable exception) {
      return new DisconnectionInfo(reason);
   }

   @Override
   public void onPacketException(Packet packet, Exception exception) {
      this.eid.onPacketError(packet, exception);
   }

   int loadDistance() {
      return this.eif;
   }

   void acceptPack(UUID var1, Status var2) {
      this.sendPacket(new ResourcePackStatusC2SPacket(var1, var2));
   }
}
