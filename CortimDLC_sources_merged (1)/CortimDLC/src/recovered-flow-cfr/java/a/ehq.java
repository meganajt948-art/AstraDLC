/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.ClientConnection
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.c2s.common.ResourcePackStatusC2SPacket
 *  net.minecraft.network.packet.c2s.common.ResourcePackStatusC2SPacket$Status
 *  net.minecraft.network.packet.s2c.common.ResourcePackSendS2CPacket
 */
package a;

import a.ehn;
import flow.dev.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.common.ResourcePackStatusC2SPacket;
import net.minecraft.network.packet.s2c.common.ResourcePackSendS2CPacket;

final class ehq {
    private final List<ehn> ehr = new ArrayList<ehn>();
    private final Random ehs = new Random();
    private static /* synthetic */ String eht;
    private static /* synthetic */ long ehu;

    ehq() {
    }

    void offer(ResourcePackSendS2CPacket resourcePackSendS2CPacket, ClientConnection clientConnection) {
        String string = resourcePackSendS2CPacket.url();
        if (string == null || !string.startsWith(a.d("\ud5df\uac72\u26a1\ub8d4\u3349\ub5ed\u0fbe", 1891259999, -444169233)) && !string.startsWith(a.c(-975468472, "\u8828\uf185\u7b56\ue523\u6ef7\ue80f\u5249\udbb8"))) {
            clientConnection.send((Packet)new ResourcePackStatusC2SPacket(resourcePackSendS2CPacket.id(), ResourcePackStatusC2SPacket.Status.INVALID_URL));
            return;
        }
        clientConnection.send((Packet)new ResourcePackStatusC2SPacket(resourcePackSendS2CPacket.id(), ResourcePackStatusC2SPacket.Status.ACCEPTED));
        this.ehr.add(new ehn(resourcePackSendS2CPacket.id(), 24 + this.ehs.nextInt(46)));
    }

    void tick(ClientConnection clientConnection) {
        Iterator<ehn> iterator = this.ehr.iterator();
        while (iterator.hasNext()) {
            ehn ehn2 = iterator.next();
            if (--ehn2.ticks > 0) continue;
            if (ehn2.stage == 0) {
                clientConnection.send((Packet)new ResourcePackStatusC2SPacket(ehn2.id, ResourcePackStatusC2SPacket.Status.DOWNLOADED));
                ehn2.stage = 1;
                ehn2.ticks = 6 + this.ehs.nextInt(14);
                continue;
            }
            clientConnection.send((Packet)new ResourcePackStatusC2SPacket(ehn2.id, ResourcePackStatusC2SPacket.Status.SUCCESSFULLY_LOADED));
            iterator.remove();
        }
    }

    void clear() {
        this.ehr.clear();
    }

    private static /* synthetic */ int ee(int n, int n2) {
        return (n ^ n2) + -1172675686;
    }
}

