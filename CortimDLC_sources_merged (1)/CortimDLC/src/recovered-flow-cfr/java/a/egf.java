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
    private final MinecraftClient egi = MinecraftClient.getInstance();
    private static /* synthetic */ int egj;
    private static /* synthetic */ String egk;

    egf(dtv dtv2, ClientConnection clientConnection) {
        this.egg = dtv2;
        this.egh = clientConnection;
    }

    public void onHello(LoginHelloS2CPacket packet) {
        if (packet.needsAuthentication()) {
            this.egh.disconnect((Text)Text.literal((String)a.d("\u6bce\u126b\u98cd\u06ce\u8d1e\u0bda\ub5e9\u387a\ua627\u2ce3\uab34\u5137\udf96\u4650\uc861\u4a8b\uf0c7\u7f68\ue5a8\u63f1\uea0c\u9052\u1ee7\u8535\u034a\u89ed\u302c\uba64\u2483\ua2d8\u296b\ud7b0\u5d8c\uc403\u422f", 100695473, -339996035)));
            return;
        }
        try {
            SecretKey secretKey = NetworkEncryptionUtils.generateSecretKey();
            PublicKey publicKey = packet.getPublicKey();
            Cipher cipher = NetworkEncryptionUtils.cipherFromKey((int)2, (Key)secretKey);
            Cipher cipher2 = NetworkEncryptionUtils.cipherFromKey((int)1, (Key)secretKey);
            LoginKeyC2SPacket loginKeyC2SPacket = new LoginKeyC2SPacket(secretKey, publicKey, packet.getNonce());
            this.egh.send((Packet)loginKeyC2SPacket, PacketCallbacks.always(() -> this.egh.setupEncryption(cipher, cipher2)));
        }
        catch (Exception exception) {
            this.egh.disconnect((Text)Text.literal((String)a.b("\u4f81\u3666\ubcc5\u22bd\ua961\u2fda\u9199\u1c00\u822f\u08e2\u8f35\u753a\ufbe1\u6252\ue80c\u6ef8\ud4c0", -1950332018)));
        }
    }

    public void onSuccess(LoginSuccessS2CPacket packet) {
        GameProfile gameProfile = packet.profile();
        WorldSession worldSession = new WorldSession(TelemetrySender.NOOP, false, null, null);
        DynamicRegistryManager.Immutable immutable = ClientDynamicRegistryType.createCombinedDynamicRegistries().getCombinedRegistryManager();
        HashMap hashMap = new HashMap();
        ClientConnectionState clientConnectionState = new ClientConnectionState(new ClientChunkLoadProgress(), gameProfile, worldSession, immutable, FeatureFlags.DEFAULT_ENABLED_FEATURES, null, this.egg.serverInfo(), null, hashMap, null, Map.of(), ServerLinks.EMPTY, new HashMap(), false);
        this.egh.transitionInbound(ConfigurationStates.S2C, (PacketListener)ecr.create(this.egi, this.egh, clientConnectionState, this.egg, gameProfile, immutable));
        this.egh.send((Packet)EnterConfigurationC2SPacket.INSTANCE);
        this.egh.transitionOutbound(ConfigurationStates.C2S);
        this.egh.send((Packet)new CustomPayloadC2SPacket((CustomPayload)new BrandCustomPayload(ClientBrandRetriever.getClientModName())));
        this.egh.send((Packet)new ClientOptionsC2SPacket(this.egg.syncedOptions()));
        this.egg.onLoginSuccess(gameProfile);
    }

    public void onDisconnect(LoginDisconnectS2CPacket packet) {
        this.egh.disconnect(packet.reason());
    }

    public void onCompression(LoginCompressionS2CPacket packet) {
        if (!this.egh.isLocal()) {
            this.egh.setCompressionThreshold(packet.getCompressionThreshold(), false);
        }
    }

    public void onQueryRequest(LoginQueryRequestS2CPacket packet) {
        this.egh.send((Packet)new LoginQueryResponseC2SPacket(packet.queryId(), null));
    }

    public void onCookieRequest(CookieRequestS2CPacket packet) {
        this.egh.send((Packet)new CookieResponseC2SPacket(packet.key(), null));
    }

    public void onDisconnected(DisconnectionInfo info) {
        this.egg.onDisconnected(info.reason());
    }

    public boolean isConnectionOpen() {
        return this.egh.isOpen();
    }

    private static /* synthetic */ int ds(int n, int n2) {
        return (n ^ n2) + 2145155849;
    }
}

