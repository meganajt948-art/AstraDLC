/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 */
package a;

import a.Friends;
import a.ModuleCategory;
import a.Module;
import flow.dev.StringDecryptor;
import net.minecraft.class_1297;
import net.minecraft.class_1657;

public class NoFriendDamage
extends Module {
    private static NoFriendDamage lfv;
    private static /* synthetic */ String lfw;
    private static /* synthetic */ boolean lfx;

    public NoFriendDamage() {
        super("NoFriendDamage", "Your hits never land on friends", ModuleCategory.COMBAT);
        lfv = this;
    }

    public static boolean blocks(class_1297 class_12972) {
        return lfv != null && lfv.isEnabled() && class_12972 instanceof class_1657 && Friends.isFriend(class_12972);
    }

    private static /* synthetic */ int awk(int n, int n2) {
        return (n ^ n2) + -790638836;
    }

    private static /* synthetic */ int awl(int n, int n2) {
        return NoFriendDamage.awk(n, n2) + n;
    }
}

