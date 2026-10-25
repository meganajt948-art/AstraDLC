/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientConfigurationNetworkHandler
 *  net.minecraft.client.network.ClientConnectionState
 *  net.minecraft.client.network.ClientRegistries
 *  net.minecraft.client.resource.ClientDataPackManager
 *  net.minecraft.network.ClientConnection
 *  net.minecraft.network.DisconnectionInfo
 *  net.minecraft.network.NetworkThreadUtils
 *  net.minecraft.network.PacketApplyBatcher
 *  net.minecraft.network.RegistryByteBuf
 *  net.minecraft.network.listener.PacketListener
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.c2s.config.AcceptCodeOfConductC2SPacket
 *  net.minecraft.network.packet.c2s.config.ReadyC2SPacket
 *  net.minecraft.network.packet.c2s.config.SelectKnownPacksC2SPacket
 *  net.minecraft.network.packet.s2c.common.ClearDialogS2CPacket
 *  net.minecraft.network.packet.s2c.common.ResourcePackRemoveS2CPacket
 *  net.minecraft.network.packet.s2c.common.ResourcePackSendS2CPacket
 *  net.minecraft.network.packet.s2c.common.ServerTransferS2CPacket
 *  net.minecraft.network.packet.s2c.common.ShowDialogS2CPacket
 *  net.minecraft.network.packet.s2c.common.SynchronizeTagsS2CPacket
 *  net.minecraft.network.packet.s2c.config.CodeOfConductS2CPacket
 *  net.minecraft.network.packet.s2c.config.DynamicRegistriesS2CPacket
 *  net.minecraft.network.packet.s2c.config.FeaturesS2CPacket
 *  net.minecraft.network.packet.s2c.config.ReadyS2CPacket
 *  net.minecraft.network.packet.s2c.config.SelectKnownPacksS2CPacket
 *  net.minecraft.network.state.NetworkState
 *  net.minecraft.network.state.PlayStateFactories
 *  net.minecraft.registry.DynamicRegistryManager
 *  net.minecraft.registry.DynamicRegistryManager$Immutable
 *  net.minecraft.resource.LifecycledResourceManager
 *  net.minecraft.resource.ResourceFactory
 *  net.minecraft.resource.featuretoggle.FeatureFlags
 *  net.minecraft.resource.featuretoggle.FeatureSet
 *  net.minecraft.text.Text
 */
package a;

import a.dtv;
import a.edb;
import a.ega;
import a.ehy;
import a.ejp;
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
import net.minecraft.network.PacketApplyBatcher;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.listener.PacketListener;
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
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.resource.LifecycledResourceManager;
import net.minecraft.resource.ResourceFactory;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.text.Text;

final class ecr
extends ClientConfigurationNetworkHandler {
    private final dtv ecs;
    private final GameProfile ect;
    private final DynamicRegistryManager.Immutable ecu;
    private final ClientRegistries ecv = new ClientRegistries();
    private ClientDataPackManager ecw;
    private FeatureSet ecx;
    private static /* synthetic */ String ecy;
    private static /* synthetic */ String ecz;

    private ecr(MinecraftClient minecraftClient, ClientConnection clientConnection, ClientConnectionState clientConnectionState, dtv dtv2, GameProfile gameProfile, DynamicRegistryManager.Immutable immutable) {
        super(minecraftClient, clientConnection, clientConnectionState);
        this.ecs = dtv2;
        this.ect = gameProfile;
        this.ecu = immutable;
        this.ecx = clientConnectionState.enabledFeatures();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static ecr create(MinecraftClient minecraftClient, ClientConnection clientConnection, ClientConnectionState clientConnectionState, dtv dtv2, GameProfile gameProfile, DynamicRegistryManager.Immutable immutable) {
        boolean bl = ejp.current() == dtv2;
        Object[] objectArray = ega.saveAddons();
        try {
            ecr ecr2 = new ecr(minecraftClient, clientConnection, clientConnectionState, dtv2, gameProfile, immutable);
            dtv2.fabricAddons = ega.created(objectArray, bl ? dtv2.fabricAddons : null);
            ecr ecr3 = ecr2;
            return ecr3;
        }
        finally {
            if (!bl) {
                ega.restoreAddons(objectArray);
            }
        }
    }

    public void onDynamicRegistries(DynamicRegistriesS2CPacket packet) {
        NetworkThreadUtils.forceMainThread((Packet)packet, (PacketListener)this, (PacketApplyBatcher)this.client.getPacketApplyBatcher());
        this.ecv.putDynamicRegistry(packet.registry(), packet.entries());
    }

    public void onSynchronizeTags(SynchronizeTagsS2CPacket packet) {
        NetworkThreadUtils.forceMainThread((Packet)packet, (PacketListener)this, (PacketApplyBatcher)this.client.getPacketApplyBatcher());
        this.ecv.putTags(packet.getGroups());
    }

    public void onFeatures(FeaturesS2CPacket packet) {
        super.onFeatures(packet);
        this.ecx = FeatureFlags.FEATURE_MANAGER.featureSetOf((Iterable)packet.features());
    }

    public void onSelectKnownPacks(SelectKnownPacksS2CPacket packet) {
        NetworkThreadUtils.forceMainThread((Packet)packet, (PacketListener)this, (PacketApplyBatcher)this.client.getPacketApplyBatcher());
        if (this.ecw == null) {
            this.ecw = new ClientDataPackManager();
        }
        this.sendPacket((Packet)new SelectKnownPacksC2SPacket(this.ecw.getCommonKnownPacks(packet.knownPacks())));
    }

    public void onCodeOfConduct(CodeOfConductS2CPacket packet) {
        NetworkThreadUtils.forceMainThread((Packet)packet, (PacketListener)this, (PacketApplyBatcher)this.client.getPacketApplyBatcher());
        this.sendPacket((Packet)AcceptCodeOfConductC2SPacket.INSTANCE);
        this.ecs.chat.system(a.d("\u23eb\u5a4e\ud0e8\u4eeb\uc53b\u43ff\ufdcc\u7022\uee02\u64cb\ue361\u196a\u97b6\u0e0c\u8044\u02aa\ub89a\u373b\uad8a\u2bd1\ua225\ud87f\u52dc\uc900\u4f72\uc1bc\u7870\uf659\u6cab\uea88\u6136\u9fee", 294139560, -444001982));
    }

    public void onReady(ReadyS2CPacket packet) {
        NetworkThreadUtils.forceMainThread((Packet)packet, (PacketListener)this, (PacketApplyBatcher)this.client.getPacketApplyBatcher());
        DynamicRegistryManager.Immutable immutable = this.eda();
        ClientConnectionState clientConnectionState = new ClientConnectionState(null, this.ect, this.worldSession, immutable, this.ecx, this.brand, this.serverInfo, null, this.serverCookies, null, this.customReportDetails, this.getServerLinks(), this.seenPlayers, this.seenInsecureChatWarning);
        ega.clearConfiguration();
        ehy ehy2 = ehy.create(this.client, this.connection, clientConnectionState, this.ecs);
        NetworkState networkState = PlayStateFactories.S2C.bind(RegistryByteBuf.makeFactory((DynamicRegistryManager)immutable));
        NetworkState networkState2 = PlayStateFactories.C2S.bind(RegistryByteBuf.makeFactory((DynamicRegistryManager)immutable), () -> true);
        ClientConnection clientConnection = this.connection;
        ((edb)clientConnection).runInLoop(() -> {
            clientConnection.transitionInbound(networkState, (PacketListener)ehy2);
            clientConnection.send((Packet)ReadyC2SPacket.INSTANCE);
            clientConnection.transitionOutbound(networkState2);
        });
    }

    private DynamicRegistryManager.Immutable eda() {
        if (this.ecw == null) {
            return this.ecv.createRegistryManager(ResourceFactory.MISSING, this.ecu, this.connection.isLocal());
        }
        try (LifecycledResourceManager lifecycledResourceManager = this.ecw.createResourceManager();){
            DynamicRegistryManager.Immutable immutable = this.ecv.createRegistryManager((ResourceFactory)lifecycledResourceManager, this.ecu, this.connection.isLocal());
            return immutable;
        }
    }

    public void onResourcePackSend(ResourcePackSendS2CPacket packet) {
        this.ecs.packs.offer(packet, this.connection);
    }

    public void onResourcePackRemove(ResourcePackRemoveS2CPacket packet) {
    }

    public void onServerTransfer(ServerTransferS2CPacket packet) {
        this.connection.disconnect((Text)Text.literal((String)(a.c(-1161073812, "\u6f6f\u16ca\u9c6c\u026f\u89bf\u0f7b\ub148\u3ca6\ua2f3\u2837\uaf91\u55ef\udb3a\u428e\uc8a3\u4e2a\uf07e\u7bb2\ue10c\u634d\ueeae\u948b\u1a3b\u819a\u07e8\u8d3e\u3094\ubad5\u2026\ua603\u2dc5\ud360\u5d54\uc4bf") + packet.host() + a.c(2064868421, "\u647e") + packet.port())));
    }

    public void onShowDialog(ShowDialogS2CPacket packet) {
        this.ecs.chat.system(a.d("\u8d7e\uf4db\u7e7d\ue07e\u6bae\ued6a\u5359\udeb7\u40e9\uca5c\u4d85\ub7f3\u3923\ua099\u2ed1\uac34\u1677\u99ae\u0316\u8542\u0cb8\u72fa\ufc44\u6798\ue5f8\u6f56\ud69b\u58cb\uc240\u441b\ucfd4\u310d", 1411637423, 1611622864));
    }

    public void onClearDialog(ClearDialogS2CPacket packet) {
    }

    public void tick() {
        super.tick();
        this.ecs.packs.tick(this.connection);
    }

    public void onDisconnected(DisconnectionInfo info) {
        this.ecs.onDisconnected(info.reason());
    }

    public DisconnectionInfo createDisconnectionInfo(Text reason, Throwable exception) {
        return new DisconnectionInfo(reason);
    }

    public void onPacketException(Packet packet, Exception exception) {
        this.ecs.onPacketError(packet, exception);
    }

    private static /* synthetic */ int cv(int n, int n2) {
        return n - n2 ^ 0xA65696DD;
    }

    private static /* synthetic */ int cw(int n, int n2) {
        return ecr.cv(n, n2) + n;
    }
}

