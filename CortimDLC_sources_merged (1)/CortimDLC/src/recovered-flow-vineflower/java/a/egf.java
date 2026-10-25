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
   private final MinecraftClient egi = MinecraftClient.method_1551();

   egf(dtv var1, ClientConnection var2) {
      this.egg = var1;
      this.egh = var2;
   }

   public void method_12587(LoginHelloS2CPacket var1) {
      if (var1.method_56013()) {
         this.egh.method_10747(Text.method_43470(a.d("毎ቫ飍ێ贞\u0bda뗩㡺꘧ⳣꬴ儷\udf96䙐졡䪋\uf0c7罨\ue5a8揱\uea0c遒ủ蔵͊觭〬멤⒃ꋘ⥫ힰ嶌쐃䈯", 100695473, -339996035)));
      } else {
         try {
            SecretKey var2 = NetworkEncryptionUtils.method_15239();
            PublicKey var3 = var1.method_12611();
            Cipher var4 = NetworkEncryptionUtils.method_15235(2, var2);
            Cipher var5 = NetworkEncryptionUtils.method_15235(1, var2);
            LoginKeyC2SPacket var6 = new LoginKeyC2SPacket(var2, var3, var1.method_12613());
            this.egh.method_10752(var6, PacketCallbacks.method_45084(() -> this.egh.method_10746(var4, var5)));
         } catch (Exception var7) {
            this.egh.method_10747(Text.method_43470(a.b("侁㙦볅⊽ꥡ\u2fda醙ᰀ舯\u08e2輵町ﯡ扒\ue80c滸퓀", -1950332018)));
         }
      }
   }

   public void method_12588(LoginSuccessS2CPacket var1) {
      GameProfile var2 = var1.comp_2363();
      WorldSession var3 = new WorldSession(TelemetrySender.field_41434, false, null, null);
      Immutable var4 = ClientDynamicRegistryType.method_45738().method_45926();
      HashMap var5 = new HashMap();
      ClientConnectionState var6 = new ClientConnectionState(
         new ClientChunkLoadProgress(),
         var2,
         var3,
         var4,
         FeatureFlags.field_40183,
         null,
         this.egg.serverInfo(),
         null,
         var5,
         null,
         Map.of(),
         ServerLinks.field_51977,
         new HashMap(),
         false
      );
      this.egh.method_56330(ConfigurationStates.field_48699, ecr.create(this.egi, this.egh, var6, this.egg, var2, var4));
      this.egh.method_10743(EnterConfigurationC2SPacket.field_48252);
      this.egh.method_56329(ConfigurationStates.field_48698);
      this.egh.method_10743(new CustomPayloadC2SPacket(new BrandCustomPayload(ClientBrandRetriever.getClientModName())));
      this.egh.method_10743(new ClientOptionsC2SPacket(this.egg.syncedOptions()));
      this.egg.onLoginSuccess(var2);
   }

   public void method_12584(LoginDisconnectS2CPacket var1) {
      this.egh.method_10747(var1.comp_4195());
   }

   public void method_12585(LoginCompressionS2CPacket var1) {
      if (!this.egh.method_10756()) {
         this.egh.method_10760(var1.method_12634(), false);
      }
   }

   public void method_12586(LoginQueryRequestS2CPacket var1) {
      this.egh.method_10743(new LoginQueryResponseC2SPacket(var1.comp_1567(), null));
   }

   public void method_55845(CookieRequestS2CPacket var1) {
      this.egh.method_10743(new CookieResponseC2SPacket(var1.comp_2194(), null));
   }

   public void method_10839(DisconnectionInfo var1) {
      this.egg.onDisconnected(var1.comp_2853());
   }

   public boolean method_48106() {
      return this.egh.method_10758();
   }
}
