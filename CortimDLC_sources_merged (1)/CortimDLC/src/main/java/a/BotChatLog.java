/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_124
 *  net.minecraft.class_2561
 */
package a;

import a.ece;
import a.ech;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.class_124;
import net.minecraft.class_2561;

public final class BotChatLog {
    private static final int ecl = 200;
    private final ArrayDeque<ech> ecm = new ArrayDeque();
    private int ecn;
    private static /* synthetic */ long eco;
    private static /* synthetic */ long ecp;

    void server(class_2561 class_25612, boolean bl) {
        this.ecq(new ech(class_25612, bl ? ece.CHAT : ece.SERVER));
    }

    void own(String string) {
        this.ecq(new ech((class_2561)class_2561.method_43470((String)string).method_27692(class_124.field_1068), ece.OWN));
    }

    void system(String string) {
        this.ecq(new ech((class_2561)class_2561.method_43470((String)string).method_27692(class_124.field_1080), ece.SYSTEM));
    }

    private void ecq(ech ech2) {
        this.ecm.addLast(ech2);
        while (this.ecm.size() > 200) {
            this.ecm.removeFirst();
        }
        ++this.ecn;
    }

    public List<ech> lines() {
        return new ArrayList<ech>(this.ecm);
    }

    ech firstServerAfter(long l, long l2) {
        ech ech2 = null;
        Iterator<ech> iterator = this.ecm.descendingIterator();
        while (iterator.hasNext()) {
            ech ech3 = iterator.next();
            if (ech3.time < l) break;
            if (ech3.kind != ece.SERVER || ech3.time > l + l2 || ech3.text.getString().isBlank()) continue;
            ech2 = ech3;
        }
        return ech2;
    }

    public int revision() {
        return this.ecn;
    }

    public int size() {
        return this.ecm.size();
    }

    private static /* synthetic */ int cs(int n, int n2) {
        return n + n2 ^ 0x2C08DB3A;
    }
}

