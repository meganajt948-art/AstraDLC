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
   private static final long ehz = ejl.offset(ClientPlayNetworkHandler.class, ClientWorld.class);
   private static final long eia = ejl.offset(ClientPlayNetworkHandler.class, Properties.class);
   private static final long eib = ejl.offset(ClientPlayNetworkHandler.class, SearchManager.class);
   private static final Field eic = vxr.find(
      ClientPlayNetworkHandler.class,
      a.c(-1291259695, "\uf0a8褒ϐ鷻ᙯ郚⪎ꍴ㴭랍き쨻䓾\udd15國퇵殷\ue474织\uf8ba焤୰藄"),
      a.d("⽛囥\udc3a䉂증众\uf52d糞\ue283栳\uefe3", -946701221, 1768641389),
      a.d("뚋", -1562936494, 647286146)
   );
   private final dtv eid;
   private Properties eie;
   private int eif = 3;
   private int eig = 3;

   private ehy(MinecraftClient var1, ClientConnection var2, ClientConnectionState var3, dtv var4) {
      super(var1, var2, var3);
      this.eid = var4;
      ejl.put(this, eib, eky.SEARCH);
   }

   static ehy create(MinecraftClient var0, ClientConnection var1, ClientConnectionState var2, dtv var3) {
      boolean var4 = ejp.current() == var3;
      Object[] var5 = ega.saveAddons();

      ehy var7;
      try {
         ehy var6 = new ehy(var0, var1, var2, var3);
         var3.fabricAddons = ega.created(var5, var3.fabricAddons);
         var3.onPlayHandler(var6);
         var7 = var6;
      } finally {
         if (!var4) {
            ega.restoreAddons(var5);
         }
      }

      return var7;
   }

   private void eij(ClientWorld var1) {
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
         this.method_52787(new PlayerLoadedC2SPacket());
         this.setPlayerLoaded(true);
      }
   }

   public void method_11120(GameJoinS2CPacket var1) {
      NetworkThreadUtils.method_11074(var1, this, this.field_45588.method_74186());
      ClientPlayerInteractionManager var2 = new ClientPlayerInteractionManager(this.field_45588, this);
      this.field_45588.field_1761 = var2;
      CommonPlayerSpawnInfo var3 = var1.comp_1727();
      this.eif = var1.comp_98();
      this.eig = var1.comp_169();
      this.eie = new Properties(Difficulty.field_5802, var1.comp_89(), var3.comp_1559());
      elh var4 = new elh(
         this,
         this.eie,
         var3.comp_1554(),
         var3.comp_1553(),
         this.eif,
         this.eig,
         eky.WORLD_RENDERER,
         var3.comp_1558(),
         var3.comp_1555(),
         var3.comp_2893(),
         this.eid
      );
      this.eij(var4);
      this.field_45588.field_1687 = var4;
      this.setPlayerLoaded(false);
      eik var5 = new eik(this.field_45588, var4, this, new StatHandler(), new ClientRecipeBook(), PlayerInput.field_54098, false, this.eid);
      var5.method_36456(-180.0F);
      var5.method_33689();
      var5.method_5838(var1.comp_88());
      var4.method_53875(var5);
      var5.field_3913 = new KeyboardInput(this.field_45588.field_1690);
      this.field_45588.field_1724 = var5;
      edj.camera(var5);
      var2.method_2903(var5);
      var5.method_7268(var1.comp_99());
      var5.method_22420(var1.comp_100());
      var5.method_53848(var1.comp_1964());
      var5.method_43120(var3.comp_1560());
      var5.method_51850(var3.comp_1561());
      var2.method_32790(var3.comp_1556(), var3.comp_1557());
      this.field_45592.method_47772(var3.comp_1556(), var1.comp_89());
      this.eid.onJoinWorld(var4, var5);
   }

   public void method_11117(PlayerRespawnS2CPacket var1) {
      NetworkThreadUtils.method_11074(var1, this, this.field_45588.method_74186());
      CommonPlayerSpawnInfo var2 = var1.comp_1728();
      RegistryKey var3 = var2.comp_1554();
      ClientPlayerEntity var4 = this.field_45588.field_1724;
      Object var5 = this.method_2890();
      boolean var6 = var4 == null || var5 == null || var3 != var4.method_73183().method_27983();
      if (var6) {
         Map var7 = var5 instanceof elh var8 ? var8.maps() : null;
         Difficulty var12 = this.eie == null ? Difficulty.field_5802 : this.eie.method_207();
         boolean var9 = this.eie != null && this.eie.method_152();
         this.eie = new Properties(var12, var9, var2.comp_1559());
         elh var10 = new elh(
            this, this.eie, var3, var2.comp_1553(), this.eif, this.eig, eky.WORLD_RENDERER, var2.comp_1558(), var2.comp_1555(), var2.comp_2893(), this.eid
         );
         if (var7 != null) {
            var10.copyMaps(var7);
         }

         this.eij(var10);
         this.field_45588.field_1687 = var10;
         var5 = var10;
      }

      edj.camera(null);
      if (var4 != null && var4.method_45015()) {
         var4.method_7346();
      }

      boolean var11 = var1.method_48016((byte)2);
      eik var13 = new eik(
         this.field_45588,
         (ClientWorld)var5,
         this,
         var4 == null ? new StatHandler() : var4.method_3143(),
         var4 == null ? new ClientRecipeBook() : var4.method_3130(),
         var11 && var4 != null ? var4.method_71091() : PlayerInput.field_54098,
         var11 && var4 != null && var4.method_5624(),
         this.eid
      );
      this.setPlayerLoaded(false);
      if (var4 != null) {
         var13.method_5838(var4.method_5628());
      }

      this.field_45588.field_1724 = var13;
      edj.camera(var13);
      if (var11 && var4 != null) {
         List var14 = var4.method_5841().method_46357();
         if (var14 != null) {
            var13.method_5841().method_12779(var14);
         }

         var13.method_18799(var4.method_18798());
         var13.method_36456(var4.method_36454());
         var13.method_36457(var4.method_36455());
      } else {
         var13.method_33689();
         var13.method_36456(-180.0F);
      }

      if (var4 != null) {
         if (var1.method_48016((byte)1)) {
            var13.method_6127().method_26846(var4.method_6127());
         } else {
            var13.method_6127().method_60614(var4.method_6127());
         }
      }

      var5.method_53875(var13);
      var13.field_3913 = new KeyboardInput(this.field_45588.field_1690);
      this.field_45588.field_1761.method_2903(var13);
      if (var4 != null) {
         var13.method_7268(var4.method_7302());
         var13.method_22420(var4.method_22419());
         var13.field_44911 = var4.field_44911;
         var13.field_44912 = var4.field_44912;
      }

      var13.method_43120(var2.comp_1560());
      var13.method_51850(var2.comp_1561());
      if (this.field_45588.field_1755 instanceof DeathScreen || this.field_45588.field_1755 instanceof TitleScreenConfirmScreen) {
         this.field_45588.method_1507(null);
      }

      this.field_45588.field_1761.method_32790(var2.comp_1556(), var2.comp_1557());
      this.eid.onRespawn((ClientWorld)var5, var13, var6);
   }

   public void method_52798(EnterReconfigurationS2CPacket var1) {
      NetworkThreadUtils.method_11074(var1, this, this.field_45588.method_74186());
      ClientConnectionState var2 = new ClientConnectionState(
         null,
         this.method_2879(),
         this.field_45592,
         this.method_29091(),
         this.method_45735(),
         this.field_45591,
         this.field_45590,
         null,
         this.field_48399,
         null,
         this.field_52154,
         this.method_72016(),
         this.field_62019,
         this.field_62020
      );
      ecr var3 = ecr.create(this.field_45588, this.field_45589, var2, this.eid, this.method_2879(), this.method_29091());
      ClientConnection var4 = this.field_45589;
      ((edb)var4).runInLoop(() -> {
         var4.method_56330(ConfigurationStates.field_48699, var3);
         var4.method_10743(AcknowledgeReconfigurationC2SPacket.field_48186);
         var4.method_56329(ConfigurationStates.field_48698);
      });
      this.eid.onReconfigure();
   }

   public void method_11111(SetCameraEntityS2CPacket var1) {
      NetworkThreadUtils.method_11074(var1, this, this.field_45588.method_74186());
      Entity var2 = var1.method_11800(this.method_2890());
      if (var2 != null) {
         edj.camera(var2);
      }
   }

   public void method_11080(EntityPassengersSetS2CPacket var1) {
      NetworkThreadUtils.method_11074(var1, this, this.field_45588.method_74186());
      ClientWorld var2 = this.method_2890();
      Entity var3 = var2.method_8469(var1.method_11841());
      if (var3 != null) {
         boolean var4 = var3.method_5821(this.field_45588.field_1724);
         var3.method_5772();

         for (int var8 : var1.method_11840()) {
            Entity var9 = var2.method_8469(var8);
            if (var9 != null) {
               var9.method_5873(var3, true, false);
               if (var9 == this.field_45588.field_1724 && !var4 && var3 instanceof AbstractBoatEntity) {
                  this.field_45588.field_1724.field_5982 = var3.method_36454();
                  this.field_45588.field_1724.method_36456(var3.method_36454());
                  this.field_45588.field_1724.method_5847(var3.method_36454());
               }
            }
         }
      }
   }

   public void method_11148(EntityStatusS2CPacket var1) {
      if (var1.method_11470() == 35) {
         NetworkThreadUtils.method_11074(var1, this, this.field_45588.method_74186());
         Entity var2 = var1.method_11469(this.method_2890());
         if (var2 != null && var2 == this.field_45588.field_1724) {
            this.eid.onTotemPop();
         }
      } else {
         super.method_11148(var1);
      }
   }

   public void method_11085(GameStateChangeS2CPacket var1) {
      NetworkThreadUtils.method_11074(var1, this, this.field_45588.method_74186());
      Reason var2 = var1.method_11491();
      if (var2 == GameStateChangeS2CPacket.field_25649) {
         this.method_52787(new ClientStatusC2SPacket(Mode.field_12774));
      } else {
         if (var2 == GameStateChangeS2CPacket.field_25650) {
            return;
         }

         if (var2 == GameStateChangeS2CPacket.field_46637) {
            this.eid.onChunksComing();
         } else if (var2 == GameStateChangeS2CPacket.field_25645) {
            this.eid.chat.system(Text.method_43471(a.c(-1616684029, "屾◁꼑ㅬ몳㱇虗ྡྷ釺ᭀ鲕曵\ue831熇\ufbc6絭읿䢭툏呈\udda6ꞷ⥄는㓰븊ސ觖ጬ镸Ệ")).getString());
         } else {
            super.method_11085(var1);
         }
      }
   }

   public void method_11124(ExplosionS2CPacket var1) {
      NetworkThreadUtils.method_11074(var1, this, this.field_45588.method_74186());
      if (this.field_45588.field_1724 != null) {
         var1.comp_2884().ifPresent(this.field_45588.field_1724::method_45319);
      }
   }

   public void method_34075(DeathMessageS2CPacket var1) {
      NetworkThreadUtils.method_11074(var1, this, this.field_45588.method_74186());
      Entity var2 = this.method_2890().method_8469(var1.comp_2275());
      if (var2 != null && var2 == this.field_45588.field_1724) {
         this.eid.onDeath(var1.comp_2276());
      }

      super.method_34075(var1);
   }

   public void method_17587(OpenScreenS2CPacket var1) {
      super.method_17587(var1);
      this.eid.onScreenOpened(var1.method_17594());
   }

   public void method_17186(OpenWrittenBookS2CPacket var1) {
   }

   public void method_11150(ItemPickupAnimationS2CPacket var1) {
      NetworkThreadUtils.method_11074(var1, this, this.field_45588.method_74186());
      ClientWorld var2 = this.method_2890();
      Entity var3 = var2.method_8469(var1.method_11915());
      if (var3 != null) {
         if (var3 instanceof ItemEntity var4) {
            ItemStack var5 = var4.method_6983();
            if (!var5.method_7960()) {
               var5.method_7934(var1.method_11913());
            }

            if (var5.method_7960()) {
               var2.method_2945(var1.method_11915(), RemovalReason.field_26999);
            }
         } else if (!(var3 instanceof ExperienceOrbEntity)) {
            var2.method_2945(var1.method_11915(), RemovalReason.field_26999);
         }
      }
   }

   public void method_11128(ChunkDataS2CPacket var1) {
      super.method_11128(var1);
      ClientWorld var2 = this.method_2890();
      int var3 = var1.method_11523();
      int var4 = var1.method_11524();
      var2.method_38536(() -> {
         WorldChunk var4x = var2.method_2935().method_12126(var3, var4, false);
         if (var4x != null) {
            this.eid.onChunkLoaded(var4x);
         }
      });
   }

   public void method_20203(ChunkLoadDistanceS2CPacket var1) {
      NetworkThreadUtils.method_11074(var1, this, this.field_45588.method_74186());
      this.eif = var1.method_20206();
      this.method_2890().method_2935().method_20180(var1.method_20206());
   }

   public void method_43596(GameMessageS2CPacket var1) {
      NetworkThreadUtils.method_11074(var1, this, this.field_45588.method_74186());
      this.eid.onServerMessage(var1.comp_763(), var1.comp_906());
   }

   public void method_43595(ChatMessageS2CPacket var1) {
      NetworkThreadUtils.method_11074(var1, this, this.field_45588.method_74186());
      Object var2 = var1.comp_1103() != null ? var1.comp_1103() : Text.method_43470(var1.comp_1102().comp_1090());

      Object var3;
      try {
         var3 = var1.comp_943().method_44837((Text)var2);
      } catch (Throwable var5) {
         var3 = var2;
      }

      this.eid.onServerMessage((Text)var3, false, true);
   }

   public void method_45724(ProfilelessChatMessageS2CPacket var1) {
      NetworkThreadUtils.method_11074(var1, this, this.field_45588.method_74186());

      Text var2;
      try {
         var2 = var1.comp_1098().method_44837(var1.comp_1097());
      } catch (Throwable var4) {
         var2 = var1.comp_1097();
      }

      this.eid.onServerMessage(var2, false, true);
   }

   public void method_44814(RemoveMessageS2CPacket var1) {
   }

   public void method_34076(OverlayMessageS2CPacket var1) {
      NetworkThreadUtils.method_11074(var1, this, this.field_45588.method_74186());
      this.eid.onServerMessage(var1.comp_2279(), true);
   }

   public void method_34083(TitleS2CPacket var1) {
      NetworkThreadUtils.method_11074(var1, this, this.field_45588.method_74186());
      this.eid.onTitle(var1.comp_2281(), false);
   }

   public void method_34082(SubtitleS2CPacket var1) {
      NetworkThreadUtils.method_11074(var1, this, this.field_45588.method_74186());
      this.eid.onTitle(var1.comp_2280(), true);
   }

   public void method_34084(TitleFadeS2CPacket var1) {
   }

   public void method_34071(ClearTitleS2CPacket var1) {
      NetworkThreadUtils.method_11074(var1, this, this.field_45588.method_74186());
      this.eid.onTitle(null, false);
   }

   public void method_11105(PlayerListHeaderS2CPacket var1) {
      NetworkThreadUtils.method_11074(var1, this, this.field_45588.method_74186());
      this.eid.tabHeader = var1.comp_2282();
      this.eid.tabFooter = var1.comp_2283();
   }

   public void method_11078(BossBarS2CPacket var1) {
      NetworkThreadUtils.method_11074(var1, this, this.field_45588.method_74186());
      final Map var2 = this.eid.bossBars;
      var1.method_34091(new Consumer() {
         public void method_34103(UUID var1, Text var2x, float var3, Color var4, Style var5, boolean var6, boolean var7, boolean var8) {
            var2.put(var1, new ClientBossBar(var1, var2x, var3, var4, var5, var6, var7, var8));
         }

         public void method_34099(UUID var1) {
            var2.remove(var1);
         }

         public void method_34100(UUID var1, float var2x) {
            ClientBossBar var3 = (ClientBossBar)var2.get(var1);
            if (var3 != null) {
               var3.method_5408(var2x);
            }
         }

         public void method_34102(UUID var1, Text var2x) {
            ClientBossBar var3 = (ClientBossBar)var2.get(var1);
            if (var3 != null) {
               var3.method_5413(var2x);
            }
         }

         public void method_34101(UUID var1, Color var2x, Style var3) {
            ClientBossBar var4 = (ClientBossBar)var2.get(var1);
            if (var4 != null) {
               var4.method_5416(var2x);
               var4.method_5409(var3);
            }
         }

         public void method_34104(UUID var1, boolean var2x, boolean var3, boolean var4) {
            ClientBossBar var5 = (ClientBossBar)var2.get(var1);
            if (var5 != null) {
               var5.method_5406(var2x);
               var5.method_5410(var3);
               var5.method_5411(var4);
            }
         }
      });
   }

   public void method_11130(AdvancementUpdateS2CPacket var1) {
   }

   public void method_11161(SelectAdvancementTabS2CPacket var1) {
   }

   public void method_64555(RecipeBookAddS2CPacket var1) {
      NetworkThreadUtils.method_11074(var1, this, this.field_45588.method_74186());
      if (this.field_45588.field_1724 != null) {
         ClientRecipeBook var2 = this.field_45588.field_1724.method_3130();
         if (var1.comp_3294()) {
            var2.method_65018();
         }

         for (Entry var4 : var1.comp_3232()) {
            var2.method_64849(var4.comp_3233());
            if (var4.method_64562()) {
               var2.method_64857(var4.comp_3233().comp_3262());
            }
         }

         var2.method_64853();
      }
   }

   public void method_44075(ServerMetadataS2CPacket var1) {
      NetworkThreadUtils.method_11074(var1, this, this.field_45588.method_74186());
      this.eid.serverLabel = var1.comp_2277();
   }

   public void method_11088(MapUpdateS2CPacket var1) {
      NetworkThreadUtils.method_11074(var1, this, this.field_45588.method_74186());
      ClientWorld var2 = this.method_2890();
      MapIdComponent var3 = var1.comp_2270();
      MapState var4 = var2.method_17891(var3);
      if (var4 == null) {
         var4 = MapState.method_32362(var1.comp_2271(), var1.comp_2272(), var2.method_27983());
         var2.method_47437(var3, var4);
      }

      var1.method_11642(var4);
      this.eid.onMapUpdated(var3);
   }

   public void method_56607(DebugSampleS2CPacket var1) {
   }

   public void method_74459(GameTestHighlightPosS2CPacket var1) {
   }

   public void method_11152(CustomPayload var1) {
   }

   public void method_11146(PlaySoundS2CPacket var1) {
   }

   public void method_11125(PlaySoundFromEntityS2CPacket var1) {
   }

   public void method_11082(StopSoundS2CPacket var1) {
   }

   public void method_11077(ParticleS2CPacket var1) {
   }

   public void method_11098(WorldEventS2CPacket var1) {
   }

   public void method_52784(ResourcePackSendS2CPacket var1) {
      this.eid.packs.offer(var1, this.field_45589);
   }

   public void method_55512(ResourcePackRemoveS2CPacket var1) {
   }

   public void method_56150(ServerTransferS2CPacket var1) {
      this.field_45589
         .method_10747(
            Text.method_43470(
               a.d("崖⒳긕〖믆㴂茱ໟ邊ᩎ鷨枖\ue943烷\ufada籓숇䧋퍵儴\udcd7꛲⡂돣㖑뽇˭袬\u125f鑺ᾼ\ue119漭\uf6c6", 114528081, 77125188)
                  + var1.comp_2240()
                  + a.c(33784368, "舋")
                  + var1.comp_2241()
            )
         );
   }

   public void method_71666(ShowDialogS2CPacket var1) {
      this.eid.chat.system(a.d("혁꾤│묁パ똕ࠦ藈ᮖ鄣\u16fa\uec8c扜ﯦ疮\uf74b䴈싑塩\ude3d埇⦅ꜻ㳧뺇㐩跤δ餿ὤ钫橲", -251789824, 1043409920));
   }

   public void method_71665(ClearDialogS2CPacket var1) {
   }

   public void method_18784() {
      this.method_52789();
      this.field_45592.method_47770();
      this.eid.packs.tick(this.field_45589);
      this.eid.tickLoading(this);
   }

   public void method_10839(DisconnectionInfo var1) {
      this.field_45592.method_47776();
      this.eid.onDisconnected(var1.comp_2853());
   }

   public DisconnectionInfo method_60881(Text var1, Throwable var2) {
      return new DisconnectionInfo(var1);
   }

   public void method_59807(Packet var1, Exception var2) {
      this.eid.onPacketError(var1, var2);
   }

   int loadDistance() {
      return this.eif;
   }

   void acceptPack(UUID var1, Status var2) {
      this.method_52787(new ResourcePackStatusC2SPacket(var1, var2));
   }
}
