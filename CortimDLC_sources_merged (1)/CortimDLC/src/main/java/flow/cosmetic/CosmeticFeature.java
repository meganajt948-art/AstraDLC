/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10055
 *  net.minecraft.class_11659
 *  net.minecraft.class_3883
 *  net.minecraft.class_3887
 *  net.minecraft.class_4587
 *  net.minecraft.class_591
 */
package flow.cosmetic;

import flow.cosmetic.Cosmetics;
import net.minecraft.class_10055;
import net.minecraft.class_11659;
import net.minecraft.class_3883;
import net.minecraft.class_3887;
import net.minecraft.class_4587;
import net.minecraft.class_591;

public final class CosmeticFeature
extends class_3887<class_10055, class_591> {
    private final boolean lead;

    public CosmeticFeature(class_3883<class_10055, class_591> context, boolean lead) {
        super(context);
        this.lead = lead;
    }

    public void render(class_4587 matrices, class_11659 queue, int light, class_10055 state, float limbAngle, float limbDistance) {
        if (this.lead) {
            Cosmetics.renderWorn((class_591)this.method_17165(), matrices, queue, light, state);
        } else {
            Cosmetics.restoreArms();
        }
    }
}

