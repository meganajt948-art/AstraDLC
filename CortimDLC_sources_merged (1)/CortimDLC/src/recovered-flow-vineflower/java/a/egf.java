package a;

import com.mojang.authlib.GameProfile;
import flow.dev.a;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientConnectionState;
import net.minecraft.client.network.ClientDynamicRegistryType;
import net.minecraft.client.session.telemetry.TelemetrySender;
import net.minecraft.client.session.telemetry.WorldSession;
import net.minecraft.client.world.ClientChunkLoadProgress;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.DisconnectionInfo;
import net.minecraft.network.PacketCallbacks;
import net.minecraft.network.encryption.NetworkEncryptionUtils;
import net.minecraft.network.listener.ClientLoginPacketListener;
import net.minecraft.network.packet.BrandCustomPayload;
import net.minecraft.network.packet.c2s.common.ClientOptionsC2SPacket;
import net.minecraft.network.packet.c2s.common.CookieResponseC2SPacket;
import net.minecraft.network.packet.c2s.common.CustomPayloadC2SPacket;
import net.minecraft.network.packet.c2s.login.EnterConfigurationC2SPacket;
import net.minecraft.network.packet.c2s.login.LoginKeyC2SPacket;
import net.minecraft.network.packet.c2s.login.LoginQueryResponseC2SPacket;
import net.minecraft.network.packet.s2c.common.CookieRequestS2CPacket;
import net.minecraft.network.packet.s2c.login.LoginCompressionS2CPacket;
import net.minecraft.network.packet.s2c.login.LoginDisconnectS2CPacket;
import net.minecraft.network.packet.s2c.login.LoginHelloS2CPacket;
import net.minecraft.network.packet.s2c.login.LoginQueryRequestS2CPacket;
import net.minecraft.network.packet.s2c.login.LoginSuccessS2CPacket;
import net.minecraft.network.state.ConfigurationStates;
import net.minecraft.registry.DynamicRegistryManager.Immutable;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.server.ServerLinks;
import net.minecraft.text.Text;

final class egf implements ClientLoginPacketListener {
   private final dtv egg;
   private final ClientConnection egh;
   private final MinecraftClient egi = MinecraftClient.getInstance();

   egf(dtv var1, ClientConnection var2) {
      this.egg = var1;
      this.egh = var2;
   }

   @Override
   public void onHello(LoginHelloS2CPacket packet) {
      if (packet.needsAuthentication()) {
         this.egh.disconnect(Text.literal(a.d("毎ቫ飍ێ贞\u0bda뗩㡺꘧ⳣꬴ儷\udf96䙐졡䪋\uf0c7罨\ue5a8揱\uea0c遒ủ蔵͊觭〬멤⒃ꋘ⥫ힰ嶌쐃䈯", 100695473, -339996035)));
      } else {
         try {
            SecretKey var2 = NetworkEncryptionUtils.generateSecretKey();
            PublicKey var3 = packet.getPublicKey();
            Cipher var4 = NetworkEncryptionUtils.cipherFromKey(2, var2);
            Cipher var5 = NetworkEncryptionUtils.cipherFromKey(1, var2);
            LoginKeyC2SPacket var6 = new LoginKeyC2SPacket(var2, var3, packet.getNonce());
            this.egh.send(var6, PacketCallbacks.always(() -> this.egh.setupEncryption(var4, var5)));
         } catch (Exception var7) {
            this.egh.disconnect(Text.literal(a.b("侁㙦볅⊽ꥡ\u2fda醙ᰀ舯\u08e2輵町ﯡ扒\ue80c滸퓀", -1950332018)));
         }
      }
   }

   @Override
   public void onSuccess(LoginSuccessS2CPacket packet) {
      GameProfile var2 = packet.profile();
      WorldSession var3 = new WorldSession(TelemetrySender.NOOP, false, null, null);
      Immutable var4 = ClientDynamicRegistryType.createCombinedDynamicRegistries().getCombinedRegistryManager();
      HashMap var5 = new HashMap();
      ClientConnectionState var6 = new ClientConnectionState(
         new ClientChunkLoadProgress(),
         var2,
         var3,
         var4,
         FeatureFlags.DEFAULT_ENABLED_FEATURES,
         null,
         this.egg.serverInfo(),
         null,
         var5,
         null,
         Map.of(),
         ServerLinks.EMPTY,
         new HashMap<>(),
         false
      );
      this.egh.transitionInbound(ConfigurationStates.S2C, ecr.create(this.egi, this.egh, var6, this.egg, var2, var4));
      this.egh.send(EnterConfigurationC2SPacket.INSTANCE);
      this.egh.transitionOutbound(ConfigurationStates.C2S);
      this.egh.send(new CustomPayloadC2SPacket(new BrandCustomPayload(ClientBrandRetriever.getClientModName())));
      this.egh.send(new ClientOptionsC2SPacket(this.egg.syncedOptions()));
      this.egg.onLoginSuccess(var2);
   }

   @Override
   public void onDisconnect(LoginDisconnectS2CPacket packet) {
      this.egh.disconnect(packet.reason());
   }

   @Override
   public void onCompression(LoginCompressionS2CPacket packet) {
      if (!this.egh.isLocal()) {
         this.egh.setCompressionThreshold(packet.getCompressionThreshold(), false);
      }
   }

   @Override
   public void onQueryRequest(LoginQueryRequestS2CPacket packet) {
      this.egh.send(new LoginQueryResponseC2SPacket(packet.queryId(), null));
   }

   @Override
   public void onCookieRequest(CookieRequestS2CPacket packet) {
      this.egh.send(new CookieResponseC2SPacket(packet.key(), null));
   }

   @Override
   public void onDisconnected(DisconnectionInfo info) {
      this.egg.onDisconnected(info.reason());
   }

   @Override
   public boolean isConnectionOpen() {
      return this.egh.isOpen();
   }
}
