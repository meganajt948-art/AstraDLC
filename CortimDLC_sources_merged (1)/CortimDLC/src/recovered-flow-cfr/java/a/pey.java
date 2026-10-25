/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 *  net.minecraft.text.Text
 */
package a;

import a.pfd;
import a.pfl;
import java.util.List;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

public final class pey {
    private final ItemStack pez;
    private String pfa;
    private static /* synthetic */ long pfb;
    private static /* synthetic */ String pfc;

    public pey(ItemStack itemStack) {
        this.pez = itemStack;
    }

    public ItemStack stack() {
        return this.pez;
    }

    public String lore() {
        if (this.pfa == null) {
            List<Text> list = pfd.tooltip(this.pez);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 1; i < list.size(); ++i) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('\n');
                }
                stringBuilder.append(pfl.normalize(list.get(i).getString()));
            }
            this.pfa = stringBuilder.toString();
        }
        return this.pfa;
    }

    private static /* synthetic */ int bho(int n, int n2) {
        return n * n2 + 296907057;
    }
}

