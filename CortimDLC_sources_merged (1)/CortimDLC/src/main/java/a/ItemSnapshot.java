/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1799
 *  net.minecraft.class_2561
 */
package a;

import a.ClaimTooltipParser;
import a.EnchantNameUtil;
import java.util.List;
import net.minecraft.class_1799;
import net.minecraft.class_2561;

public final class ItemSnapshot {
    private final class_1799 pez;
    private String pfa;
    private static /* synthetic */ long pfb;
    private static /* synthetic */ String pfc;

    public ItemSnapshot(class_1799 class_17992) {
        this.pez = class_17992;
    }

    public class_1799 stack() {
        return this.pez;
    }

    public String lore() {
        if (this.pfa == null) {
            List<class_2561> list = ClaimTooltipParser.tooltip(this.pez);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 1; i < list.size(); ++i) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('\n');
                }
                stringBuilder.append(EnchantNameUtil.normalize(list.get(i).getString()));
            }
            this.pfa = stringBuilder.toString();
        }
        return this.pfa;
    }

    private static /* synthetic */ int bho(int n, int n2) {
        return n * n2 + 296907057;
    }
}

