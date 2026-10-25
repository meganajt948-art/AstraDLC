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
import net.minecraft.network.state.PlayStateFactories.PacketCodecModifierContext;
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
      this.ecx = var3.comp_1614();
   }

   static ecr create(MinecraftClient var0, ClientConnection var1, ClientConnectionState var2, dtv var3, GameProfile var4, Immutable var5) {
      boolean var6 = ejp.current() == var3;
      Object[] var7 = ega.saveAddons();

      ecr var9;
      try {
         ecr var8 = new ecr(var0, var1, var2, var3, var4, var5);
         var3.fabricAddons = ega.created(var7, var6 ? var3.fabricAddons : null);
         var9 = var8;
      } finally {
         if (!var6) {
            ega.restoreAddons(var7);
         }
      }

      return var9;
   }

   public void method_52795(DynamicRegistriesS2CPacket var1) {
      NetworkThreadUtils.method_11074(var1, this, this.field_45588.method_74186());
      this.ecv.method_56583(var1.comp_2258(), var1.comp_2259());
   }

   public void method_11126(SynchronizeTagsS2CPacket var1) {
      NetworkThreadUtils.method_11074(var1, this, this.field_45588.method_74186());
      this.ecv.method_56586(var1.method_12000());
   }

   public void method_52796(FeaturesS2CPacket var1) {
      super.method_52796(var1);
      this.ecx = FeatureFlags.field_40180.method_45387(var1.comp_1113());
   }

   public void method_57045(SelectKnownPacksS2CPacket var1) {
      NetworkThreadUtils.method_11074(var1, this, this.field_45588.method_74186());
      if (this.ecw == null) {
         this.ecw = new ClientDataPackManager();
      }

      this.method_52787(new SelectKnownPacksC2SPacket(this.ecw.method_57049(var1.comp_2356())));
   }

   public void method_73257(CodeOfConductS2CPacket var1) {
      NetworkThreadUtils.method_11074(var1, this, this.field_45588.method_74186());
      this.method_52787(AcceptCodeOfConductC2SPacket.field_62060);
      this.ecs.chat.system(a.d("⏫婎탨仫씻䏿\ufdcc瀢\uee02擋\ue361ᥪ鞶ฌ聄ʪ뢚㜻궊⯑ꈥ\ud87f勜준佲솼硰\uf659沫\uea88愶鿮", 294139560, -444001982));
   }

   public void method_52794(ReadyS2CPacket var1) {
      NetworkThreadUtils.method_11074(var1, this, this.field_45588.method_74186());
      Immutable var2 = this.eda();
      ClientConnectionState var3 = new ClientConnectionState(
         null,
         this.ect,
         this.field_45592,
         var2,
         this.ecx,
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
      ega.clearConfiguration();
      ehy var4 = ehy.create(this.field_45588, this.field_45589, var3, this.ecs);
      NetworkState var5 = PlayStateFactories.field_48173.method_68874(RegistryByteBuf.method_56350(var2));
      NetworkState var6 = PlayStateFactories.field_48172.method_68875(RegistryByteBuf.method_56350(var2), (PacketCodecModifierContext)() -> true);
      ClientConnection var7 = this.field_45589;
      ((edb)var7).runInLoop(() -> {
         var7.method_56330(var5, var4);
         var7.method_10743(ReadyC2SPacket.field_48700);
         var7.method_56329(var6);
      });
   }

   private Immutable eda() {
      if (this.ecw == null) {
         return this.ecv.method_56585(ResourceFactory.field_49043, this.ecu, this.field_45589.method_10756());
      } else {
         LifecycledResourceManager var1 = this.ecw.method_57046();

         Immutable var2;
         try {
            var2 = this.ecv.method_56585(var1, this.ecu, this.field_45589.method_10756());
         } catch (Throwable var5) {
            if (var1 != null) {
               try {
                  var1.close();
               } catch (Throwable var4) {
                  var5.addSuppressed(var4);
               }
            }

            throw var5;
         }

         if (var1 != null) {
            var1.close();
         }

         return var2;
      }
   }

   public void method_52784(ResourcePackSendS2CPacket var1) {
      this.ecs.packs.offer(var1, this.field_45589);
   }

   public void method_55512(ResourcePackRemoveS2CPacket var1) {
   }

   public void method_56150(ServerTransferS2CPacket var1) {
      this.field_45589
         .method_10747(
            Text.method_43470(
               a.c(-1161073812, "潯ᛊ鱬ɯ覿ཻ녈㲦ꋳ⠷꾑嗯\udb3a䊎좣个\uf07e箲\ue10c捍\ueeae钋ᨻ膚ߨ贾ゔ뫕…ꘃⷅ퍠嵔쒿") + var1.comp_2240() + a.c(2064868421, "摾") + var1.comp_2241()
            )
         );
   }

   public void method_71666(ShowDialogS2CPacket var1) {
      this.ecs.chat.system(a.d("赾\uf4db繽\ue07e殮\ued6a卙\udeb7䃩쩜䶅럳㤣ꂙ⻑갴ᙷ馮̖蕂ಸ狺ﱄ枘\ue5f8潖횛壋쉀䐛쿔ㄍ", 1411637423, 1611622864));
   }

   public void method_71665(ClearDialogS2CPacket var1) {
   }

   public void method_18784() {
      super.method_18784();
      this.ecs.packs.tick(this.field_45589);
   }

   public void method_10839(DisconnectionInfo var1) {
      this.ecs.onDisconnected(var1.comp_2853());
   }

   public DisconnectionInfo method_60881(Text var1, Throwable var2) {
      return new DisconnectionInfo(var1);
   }

   public void method_59807(Packet var1, Exception var2) {
      this.ecs.onPacketError(var1, var2);
   }
}
