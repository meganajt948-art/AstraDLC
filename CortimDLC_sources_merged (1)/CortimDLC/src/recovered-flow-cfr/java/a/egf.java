/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.client.ClientBrandRetriever
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientConnectionState
 *  net.minecraft.client.network.ClientDynamicRegistryType
 *  net.minecraft.client.session.telemetry.TelemetrySender
 *  net.minecraft.client.session.telemetry.WorldSession
 *  net.minecraft.client.world.ClientChunkLoadProgress
 *  net.minecraft.network.ClientConnection
 *  net.minecraft.network.DisconnectionInfo
 *  net.minecraft.network.PacketCallbacks
 *  net.minecraft.network.encryption.NetworkEncryptionUtils
 *  net.minecraft.network.listener.ClientLoginPacketListener
 *  net.minecraft.network.listener.PacketListener
 *  net.minecraft.network.packet.BrandCustomPayload
 *  net.minecraft.network.packet.CustomPayload
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.c2s.common.ClientOptionsC2SPacket
 *  net.minecraft.network.packet.c2s.common.CookieResponseC2SPacket
 *  net.minecraft.network.packet.c2s.common.CustomPayloadC2SPacket
 *  net.minecraft.network.packet.c2s.login.EnterConfigurationC2SPacket
 *  net.minecraft.network.packet.c2s.login.LoginKeyC2SPacket
 *  net.minecraft.network.packet.c2s.login.LoginQueryResponseC2SPacket
 *  net.minecraft.network.packet.s2c.common.CookieRequestS2CPacket
 *  net.minecraft.network.packet.s2c.login.LoginCompressionS2CPacket
 *  net.minecraft.network.packet.s2c.login.LoginDisconnectS2CPacket
 *  net.minecraft.network.packet.s2c.login.LoginHelloS2CPacket
 *  net.minecraft.network.packet.s2c.login.LoginQueryRequestS2CPacket
 *  net.minecraft.network.packet.s2c.login.LoginSuccessS2CPacket
 *  net.minecraft.network.state.ConfigurationStates
 *  net.minecraft.registry.DynamicRegistryManager$Immutable
 *  net.minecraft.resource.featuretoggle.FeatureFlags
 *  net.minecraft.server.ServerLinks
 *  net.minecraft.text.Text
 */
package a;

import a.dtv;
import a.ecr;
import com.mojang.authlib.GameProfile;
import flow.dev.a;
import java.security.Key;
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
import net.minecraft.network.listener.PacketListener;
import net.minecraft.network.packet.BrandCustomPayload;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.network.packet.Packet;
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
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.server.ServerLinks;
import net.minecraft.text.Text;

final class egf
implements ClientLoginPacketListener {
    private final dtv egg;
    private final ClientConnection egh;
    private final MinecraftClient egi = MinecraftClient.method_1551();
    private static /* synthetic */ int egj;
    private static /* synthetic */ String egk;

    egf(dtv dtv2, ClientConnection clientConnection) {
        this.egg = dtv2;
        this.egh = clientConnection;
    }

    public void method_12587(LoginHelloS2CPacket loginHelloS2CPacket) {
        if (loginHelloS2CPacket.method_56013()) {
            this.egh.method_10747((Text)Text.method_43470((String)a.d("\u6bce\u126b\u98cd\u06ce\u8d1e\u0bda\ub5e9\u387a\ua627\u2ce3\uab34\u5137\udf96\u4650\uc861\u4a8b\uf0c7\u7f68\ue5a8\u63f1\uea0c\u9052\u1ee7\u8535\u034a\u89ed\u302c\uba64\u2483\ua2d8\u296b\ud7b0\u5d8c\uc403\u422f", 100695473, -339996035)));
            return;
        }
        try {
            SecretKey secretKey = NetworkEncryptionUtils.method_15239();
            PublicKey publicKey = loginHelloS2CPacket.method_12611();
            Cipher cipher = NetworkEncryptionUtils.method_15235((int)2, (Key)secretKey);
            Cipher cipher2 = NetworkEncryptionUtils.method_15235((int)1, (Key)secretKey);
            LoginKeyC2SPacket loginKeyC2SPacket = new LoginKeyC2SPacket(secretKey, publicKey, loginHelloS2CPacket.method_12613());
            this.egh.method_10752((Packet)loginKeyC2SPacket, PacketCallbacks.method_45084(() -> this.egh.method_10746(cipher, cipher2)));
        }
        catch (Exception exception) {
            this.egh.method_10747((Text)Text.method_43470((String)a.b("\u4f81\u3666\ubcc5\u22bd\ua961\u2fda\u9199\u1c00\u822f\u08e2\u8f35\u753a\ufbe1\u6252\ue80c\u6ef8\ud4c0", -1950332018)));
        }
    }

    public void method_12588(LoginSuccessS2CPacket loginSuccessS2CPacket) {
        GameProfile gameProfile = loginSuccessS2CPacket.comp_2363();
        WorldSession worldSession = new WorldSession(TelemetrySender.field_41434, false, null, null);
        DynamicRegistryManager.Immutable immutable = ClientDynamicRegistryType.method_45738().method_45926();
        HashMap hashMap = new HashMap();
        ClientConnectionState clientConnectionState = new ClientConnectionState(new ClientChunkLoadProgress(), gameProfile, worldSession, immutable, FeatureFlags.field_40183, null, this.egg.serverInfo(), null, hashMap, null, Map.of(), ServerLinks.field_51977, new HashMap(), false);
        this.egh.method_56330(ConfigurationStates.field_48699, (PacketListener)ecr.create(this.egi, this.egh, clientConnectionState, this.egg, gameProfile, immutable));
        this.egh.method_10743((Packet)EnterConfigurationC2SPacket.field_48252);
        this.egh.method_56329(ConfigurationStates.field_48698);
        this.egh.method_10743((Packet)new CustomPayloadC2SPacket((CustomPayload)new BrandCustomPayload(ClientBrandRetriever.getClientModName())));
        this.egh.method_10743((Packet)new ClientOptionsC2SPacket(this.egg.syncedOptions()));
        this.egg.onLoginSuccess(gameProfile);
    }

    public void method_12584(LoginDisconnectS2CPacket loginDisconnectS2CPacket) {
        this.egh.method_10747(loginDisconnectS2CPacket.comp_4195());
    }

    public void method_12585(LoginCompressionS2CPacket loginCompressionS2CPacket) {
        if (!this.egh.method_10756()) {
            this.egh.method_10760(loginCompressionS2CPacket.method_12634(), false);
        }
    }

    public void method_12586(LoginQueryRequestS2CPacket loginQueryRequestS2CPacket) {
        this.egh.method_10743((Packet)new LoginQueryResponseC2SPacket(loginQueryRequestS2CPacket.comp_1567(), null));
    }

    public void method_55845(CookieRequestS2CPacket cookieRequestS2CPacket) {
        this.egh.method_10743((Packet)new CookieResponseC2SPacket(cookieRequestS2CPacket.comp_2194(), null));
    }

    public void method_10839(DisconnectionInfo disconnectionInfo) {
        this.egg.onDisconnected(disconnectionInfo.comp_2853());
    }

    public boolean method_48106() {
        return this.egh.method_10758();
    }

    private static /* synthetic */ int ds(int n, int n2) {
        return (n ^ n2) + 2145155849;
    }
}

