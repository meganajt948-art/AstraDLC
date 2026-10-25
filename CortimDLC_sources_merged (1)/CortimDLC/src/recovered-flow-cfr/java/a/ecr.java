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
        this.ecx = clientConnectionState.comp_1614();
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

    public void method_52795(DynamicRegistriesS2CPacket dynamicRegistriesS2CPacket) {
        NetworkThreadUtils.method_11074((Packet)dynamicRegistriesS2CPacket, (PacketListener)this, (PacketApplyBatcher)this.field_45588.method_74186());
        this.ecv.method_56583(dynamicRegistriesS2CPacket.comp_2258(), dynamicRegistriesS2CPacket.comp_2259());
    }

    public void method_11126(SynchronizeTagsS2CPacket synchronizeTagsS2CPacket) {
        NetworkThreadUtils.method_11074((Packet)synchronizeTagsS2CPacket, (PacketListener)this, (PacketApplyBatcher)this.field_45588.method_74186());
        this.ecv.method_56586(synchronizeTagsS2CPacket.method_12000());
    }

    public void method_52796(FeaturesS2CPacket featuresS2CPacket) {
        super.method_52796(featuresS2CPacket);
        this.ecx = FeatureFlags.field_40180.method_45387((Iterable)featuresS2CPacket.comp_1113());
    }

    public void method_57045(SelectKnownPacksS2CPacket selectKnownPacksS2CPacket) {
        NetworkThreadUtils.method_11074((Packet)selectKnownPacksS2CPacket, (PacketListener)this, (PacketApplyBatcher)this.field_45588.method_74186());
        if (this.ecw == null) {
            this.ecw = new ClientDataPackManager();
        }
        this.method_52787((Packet)new SelectKnownPacksC2SPacket(this.ecw.method_57049(selectKnownPacksS2CPacket.comp_2356())));
    }

    public void method_73257(CodeOfConductS2CPacket codeOfConductS2CPacket) {
        NetworkThreadUtils.method_11074((Packet)codeOfConductS2CPacket, (PacketListener)this, (PacketApplyBatcher)this.field_45588.method_74186());
        this.method_52787((Packet)AcceptCodeOfConductC2SPacket.field_62060);
        this.ecs.chat.system(a.d("\u23eb\u5a4e\ud0e8\u4eeb\uc53b\u43ff\ufdcc\u7022\uee02\u64cb\ue361\u196a\u97b6\u0e0c\u8044\u02aa\ub89a\u373b\uad8a\u2bd1\ua225\ud87f\u52dc\uc900\u4f72\uc1bc\u7870\uf659\u6cab\uea88\u6136\u9fee", 294139560, -444001982));
    }

    public void method_52794(ReadyS2CPacket readyS2CPacket) {
        NetworkThreadUtils.method_11074((Packet)readyS2CPacket, (PacketListener)this, (PacketApplyBatcher)this.field_45588.method_74186());
        DynamicRegistryManager.Immutable immutable = this.eda();
        ClientConnectionState clientConnectionState = new ClientConnectionState(null, this.ect, this.field_45592, immutable, this.ecx, this.field_45591, this.field_45590, null, this.field_48399, null, this.field_52154, this.method_72016(), this.field_62019, this.field_62020);
        ega.clearConfiguration();
        ehy ehy2 = ehy.create(this.field_45588, this.field_45589, clientConnectionState, this.ecs);
        NetworkState networkState = PlayStateFactories.field_48173.method_68874(RegistryByteBuf.method_56350((DynamicRegistryManager)immutable));
        NetworkState networkState2 = PlayStateFactories.field_48172.method_68875(RegistryByteBuf.method_56350((DynamicRegistryManager)immutable), () -> true);
        ClientConnection clientConnection = this.field_45589;
        ((edb)clientConnection).runInLoop(() -> {
            clientConnection.method_56330(networkState, (PacketListener)ehy2);
            clientConnection.method_10743((Packet)ReadyC2SPacket.field_48700);
            clientConnection.method_56329(networkState2);
        });
    }

    private DynamicRegistryManager.Immutable eda() {
        if (this.ecw == null) {
            return this.ecv.method_56585(ResourceFactory.field_49043, this.ecu, this.field_45589.method_10756());
        }
        try (LifecycledResourceManager lifecycledResourceManager = this.ecw.method_57046();){
            DynamicRegistryManager.Immutable immutable = this.ecv.method_56585((ResourceFactory)lifecycledResourceManager, this.ecu, this.field_45589.method_10756());
            return immutable;
        }
    }

    public void method_52784(ResourcePackSendS2CPacket resourcePackSendS2CPacket) {
        this.ecs.packs.offer(resourcePackSendS2CPacket, this.field_45589);
    }

    public void method_55512(ResourcePackRemoveS2CPacket resourcePackRemoveS2CPacket) {
    }

    public void method_56150(ServerTransferS2CPacket serverTransferS2CPacket) {
        this.field_45589.method_10747((Text)Text.method_43470((String)(a.c(-1161073812, "\u6f6f\u16ca\u9c6c\u026f\u89bf\u0f7b\ub148\u3ca6\ua2f3\u2837\uaf91\u55ef\udb3a\u428e\uc8a3\u4e2a\uf07e\u7bb2\ue10c\u634d\ueeae\u948b\u1a3b\u819a\u07e8\u8d3e\u3094\ubad5\u2026\ua603\u2dc5\ud360\u5d54\uc4bf") + serverTransferS2CPacket.comp_2240() + a.c(2064868421, "\u647e") + serverTransferS2CPacket.comp_2241())));
    }

    public void method_71666(ShowDialogS2CPacket showDialogS2CPacket) {
        this.ecs.chat.system(a.d("\u8d7e\uf4db\u7e7d\ue07e\u6bae\ued6a\u5359\udeb7\u40e9\uca5c\u4d85\ub7f3\u3923\ua099\u2ed1\uac34\u1677\u99ae\u0316\u8542\u0cb8\u72fa\ufc44\u6798\ue5f8\u6f56\ud69b\u58cb\uc240\u441b\ucfd4\u310d", 1411637423, 1611622864));
    }

    public void method_71665(ClearDialogS2CPacket clearDialogS2CPacket) {
    }

    public void method_18784() {
        super.method_18784();
        this.ecs.packs.tick(this.field_45589);
    }

    public void method_10839(DisconnectionInfo disconnectionInfo) {
        this.ecs.onDisconnected(disconnectionInfo.comp_2853());
    }

    public DisconnectionInfo method_60881(Text text, Throwable throwable) {
        return new DisconnectionInfo(text);
    }

    public void method_59807(Packet packet, Exception exception) {
        this.ecs.onPacketError(packet, exception);
    }

    private static /* synthetic */ int cv(int n, int n2) {
        return n - n2 ^ 0xA65696DD;
    }

    private static /* synthetic */ int cw(int n, int n2) {
        return ecr.cv(n, n2) + n;
    }
}

