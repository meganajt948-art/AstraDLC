package a;

import com.mojang.authlib.GameProfile;
import flow.dev.a;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientConfigurationNetworkHandler;
import net.minecraft.client.network.ClientConnectionState;
import net.minecraft.client.network.ClientRegistries;
import net.minecraft.client.resource.ClientDataPackManager;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.DisconnectionInfo;
import net.minecraft.network.NetworkThreadUtils;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.config.AcceptCodeOfConductC2SPacket;
import net.minecraft.network.packet.c2s.config.ReadyC2SPacket;
import net.minecraft.network.packet.c2s.config.SelectKnownPacksC2SPacket;
import net.minecraft.network.packet.s2c.common.ClearDialogS2CPacket;
import net.minecraft.network.packet.s2c.common.ResourcePackRemoveS2CPacket;
import net.minecraft.network.packet.s2c.common.ResourcePackSendS2CPacket;
import net.minecraft.network.packet.s2c.common.ServerTransferS2CPacket;
import net.minecraft.network.packet.s2c.common.ShowDialogS2CPacket;
import net.minecraft.network.packet.s2c.common.SynchronizeTagsS2CPacket;
import net.minecraft.network.packet.s2c.config.CodeOfConductS2CPacket;
import net.minecraft.network.packet.s2c.config.DynamicRegistriesS2CPacket;
import net.minecraft.network.packet.s2c.config.FeaturesS2CPacket;
import net.minecraft.network.packet.s2c.config.ReadyS2CPacket;
import net.minecraft.network.packet.s2c.config.SelectKnownPacksS2CPacket;
import net.minecraft.network.state.NetworkState;
import net.minecraft.network.state.PlayStateFactories;
import net.minecraft.registry.DynamicRegistryManager.Immutable;
import net.minecraft.resource.LifecycledResourceManager;
import net.minecraft.resource.ResourceFactory;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.text.Text;

final class ecr extends ClientConfigurationNetworkHandler {
   private final dtv ecs;
   private final GameProfile ect;
   private final Immutable ecu;
   private final ClientRegistries ecv = new ClientRegistries();
   private ClientDataPackManager ecw;
   private FeatureSet ecx;

   private ecr(MinecraftClient var1, ClientConnection var2, ClientConnectionState var3, dtv var4, GameProfile var5, Immutable var6) {
      super(var1, var2, var3);
      this.ecs = var4;
      this.ect = var5;
      this.ecu = var6;
      this.ecx = var3.enabledFeatures();
   }

   static ecr create(MinecraftClient var0, ClientConnection var1, ClientConnectionState var2, dtv var3, GameProfile var4, Immutable var5) {
      boolean var6 = ejp.current() == var3;
      Object[] var7 = ega.saveAddons();

      try {
         ecr var8 = new ecr(var0, var1, var2, var3, var4, var5);
         var3.fabricAddons = ega.created(var7, var6 ? var3.fabricAddons : null);
         return var8;
      } finally {
         if (!var6) {
            ega.restoreAddons(var7);
         }
      }
   }

   @Override
   public void onDynamicRegistries(DynamicRegistriesS2CPacket packet) {
      NetworkThreadUtils.forceMainThread(packet, this, this.client.getPacketApplyBatcher());
      this.ecv.putDynamicRegistry(packet.registry(), packet.entries());
   }

   @Override
   public void onSynchronizeTags(SynchronizeTagsS2CPacket packet) {
      NetworkThreadUtils.forceMainThread(packet, this, this.client.getPacketApplyBatcher());
      this.ecv.putTags(packet.getGroups());
   }

   @Override
   public void onFeatures(FeaturesS2CPacket packet) {
      super.onFeatures(packet);
      this.ecx = FeatureFlags.FEATURE_MANAGER.featureSetOf(packet.features());
   }

   @Override
   public void onSelectKnownPacks(SelectKnownPacksS2CPacket packet) {
      NetworkThreadUtils.forceMainThread(packet, this, this.client.getPacketApplyBatcher());
      if (this.ecw == null) {
         this.ecw = new ClientDataPackManager();
      }

      this.sendPacket(new SelectKnownPacksC2SPacket(this.ecw.getCommonKnownPacks(packet.knownPacks())));
   }

   @Override
   public void onCodeOfConduct(CodeOfConductS2CPacket packet) {
      NetworkThreadUtils.forceMainThread(packet, this, this.client.getPacketApplyBatcher());
      this.sendPacket(AcceptCodeOfConductC2SPacket.INSTANCE);
      this.ecs.chat.system(a.d("⏫婎탨仫씻䏿\ufdcc瀢\uee02擋\ue361ᥪ鞶ฌ聄ʪ뢚㜻궊⯑ꈥ\ud87f勜준佲솼硰\uf659沫\uea88愶鿮", 294139560, -444001982));
   }

   @Override
   public void onReady(ReadyS2CPacket packet) {
      NetworkThreadUtils.forceMainThread(packet, this, this.client.getPacketApplyBatcher());
      Immutable var2 = this.eda();
      ClientConnectionState var3 = new ClientConnectionState(
         null,
         this.ect,
         this.worldSession,
         var2,
         this.ecx,
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
      ega.clearConfiguration();
      ehy var4 = ehy.create(this.client, this.connection, var3, this.ecs);
      NetworkState var5 = PlayStateFactories.S2C.bind(RegistryByteBuf.makeFactory(var2));
      NetworkState var6 = PlayStateFactories.C2S.bind(RegistryByteBuf.makeFactory(var2), () -> true);
      ClientConnection var7 = this.connection;
      ((edb)var7).runInLoop(() -> {
         var7.transitionInbound(var5, var4);
         var7.send(ReadyC2SPacket.INSTANCE);
         var7.transitionOutbound(var6);
      });
   }

   private Immutable eda() {
      if (this.ecw == null) {
         return this.ecv.createRegistryManager(ResourceFactory.MISSING, this.ecu, this.connection.isLocal());
      }

      try (LifecycledResourceManager var1 = this.ecw.createResourceManager()) {
         return this.ecv.createRegistryManager(var1, this.ecu, this.connection.isLocal());
      }
   }

   @Override
   public void onResourcePackSend(ResourcePackSendS2CPacket packet) {
      this.ecs.packs.offer(packet, this.connection);
   }

   @Override
   public void onResourcePackRemove(ResourcePackRemoveS2CPacket packet) {
   }

   @Override
   public void onServerTransfer(ServerTransferS2CPacket packet) {
      this.connection
         .disconnect(
            Text.literal(a.c(-1161073812, "潯ᛊ鱬ɯ覿ཻ녈㲦ꋳ⠷꾑嗯\udb3a䊎좣个\uf07e箲\ue10c捍\ueeae钋ᨻ膚ߨ贾ゔ뫕…ꘃⷅ퍠嵔쒿") + packet.host() + a.c(2064868421, "摾") + packet.port())
         );
   }

   @Override
   public void onShowDialog(ShowDialogS2CPacket packet) {
      this.ecs.chat.system(a.d("赾\uf4db繽\ue07e殮\ued6a卙\udeb7䃩쩜䶅럳㤣ꂙ⻑갴ᙷ馮̖蕂ಸ狺ﱄ枘\ue5f8潖횛壋쉀䐛쿔ㄍ", 1411637423, 1611622864));
   }

   @Override
   public void onClearDialog(ClearDialogS2CPacket packet) {
   }

   @Override
   public void tick() {
      super.tick();
      this.ecs.packs.tick(this.connection);
   }

   @Override
   public void onDisconnected(DisconnectionInfo info) {
      this.ecs.onDisconnected(info.reason());
   }

   @Override
   public DisconnectionInfo createDisconnectionInfo(Text reason, Throwable exception) {
      return new DisconnectionInfo(reason);
   }

   @Override
   public void onPacketException(Packet packet, Exception exception) {
      this.ecs.onPacketError(packet, exception);
   }
}
