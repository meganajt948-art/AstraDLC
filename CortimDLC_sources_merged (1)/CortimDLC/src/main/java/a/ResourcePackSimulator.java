/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2535
 *  net.minecraft.class_2596
 *  net.minecraft.class_2720
 *  net.minecraft.class_2856
 *  net.minecraft.class_2856$class_2857
 */
package a;

import a.ehn;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.class_2535;
import net.minecraft.class_2596;
import net.minecraft.class_2720;
import net.minecraft.class_2856;

final class ResourcePackSimulator {
    private final List<ehn> ehr = new ArrayList<ehn>();
    private final Random ehs = new Random();
    private static /* synthetic */ String eht;
    private static /* synthetic */ long ehu;

    ResourcePackSimulator() {
    }

    void offer(class_2720 class_27202, class_2535 class_25352) {
        String string = class_27202.comp_2159();
        if (string == null || !string.startsWith("http://") && !string.startsWith("https://")) {
            class_25352.method_10743((class_2596)new class_2856(class_27202.comp_2158(), class_2856.class_2857.field_47667));
            return;
        }
        class_25352.method_10743((class_2596)new class_2856(class_27202.comp_2158(), class_2856.class_2857.field_13016));
        this.ehr.add(new ehn(class_27202.comp_2158(), 24 + this.ehs.nextInt(46)));
    }

    void tick(class_2535 class_25352) {
        Iterator<ehn> iterator = this.ehr.iterator();
        while (iterator.hasNext()) {
            ehn ehn2 = iterator.next();
            if (--ehn2.ticks > 0) continue;
            if (ehn2.stage == 0) {
                class_25352.method_10743((class_2596)new class_2856(ehn2.id, class_2856.class_2857.field_47704));
                ehn2.stage = 1;
                ehn2.ticks = 6 + this.ehs.nextInt(14);
                continue;
            }
            class_25352.method_10743((class_2596)new class_2856(ehn2.id, class_2856.class_2857.field_13017));
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

