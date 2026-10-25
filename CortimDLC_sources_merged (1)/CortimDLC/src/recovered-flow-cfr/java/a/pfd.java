/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.Item$TooltipContext
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.item.tooltip.TooltipType
 *  net.minecraft.text.Text
 */
package a;

import a.pfl;
import flow.dev.a;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

public final class pfd {
    private static final String pfe = a.c(-235674391, "\ue0ab\u9969\u13b2\u8dce");
    private static final String pff = a.b("\uda38\ua381\u2d47\ub726\u3cfb\uba32`\u89e2\u17b6\u9d09\u1ad2", 1628560910);
    private static final String pfg = a.d("\u406a\u39de\ub371\u2d0f\ua6a2\u2478\u9a3c\u13ca\u8d94\u0754\u80f7\u7af4\uf42d", 2081749670, -116146554);
    private static final Pattern pfh = Pattern.compile(a.c(1902488767, "\uac9a\ud55f\u5fb4\uc1fa\u4a2a\ucca3\u76c8\uff16\u6114\ueba7\u6c05\u9603\u18d7"));
    private static /* synthetic */ boolean pfi;
    private static /* synthetic */ String pfj;

    private pfd() {
    }

    public static int of(ItemStack itemStack) {
        long l = pfd.pfk(itemStack);
        return l > 0L ? (int)Math.min(Integer.MAX_VALUE, l / (long)Math.max(1, itemStack.method_7947())) : -1;
    }

    public static int total(ItemStack itemStack) {
        long l = pfd.pfk(itemStack);
        return l > 0L ? (int)Math.min(Integer.MAX_VALUE, l) : -1;
    }

    private static long pfk(ItemStack itemStack) {
        if (itemStack.method_7960() || itemStack.method_31574(Items.field_8298)) {
            return -1L;
        }
        List<String> list = pfd.lines(itemStack);
        for (int i = 0; i < list.size(); ++i) {
            String string = list.get(i);
            if (i == 0) {
                if (!string.contains(a.b("\ud458\uade1\u2327\ub946\u329b\ub452\u0e00\u8782\u19d6\u9369\u14b2", -688467858))) continue;
                return -1L;
            }
            int n = string.indexOf(a.d("\uc8fc\ub13e\u3be5\ua599", -530983088, 47848430));
            if (n < 0) continue;
            Matcher matcher = pfh.matcher(string.substring(n + a.d("\udf0c\ua6ce\u2c15\ub269", -1458059680, -1503781586).length()));
            long l = -1L;
            while (matcher.find()) {
                String string2 = matcher.group(1).replaceAll(a.d("\uc13e\ub88a\u3237\uac5b\u2798\ua14d", 376427464, 237638315), "");
                if (string2.isEmpty() || string2.length() > 12) continue;
                l = Math.max(l, Long.parseLong(string2));
            }
            if (l <= 0L) continue;
            return l;
        }
        return -1L;
    }

    public static boolean claimed(ItemStack itemStack) {
        for (String string : pfd.lines(itemStack)) {
            if (!string.contains(a.b("\u60ac\u1918\u93b7\u0dc9\u8664\u04be\ubafa\u330c\uad52\u2792\ua031\u5a32\ud4eb", -745970458))) continue;
            return true;
        }
        return false;
    }

    static List<Text> tooltip(ItemStack itemStack) {
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        return itemStack.method_7950(Item.TooltipContext.field_51353, (PlayerEntity)minecraftClient.field_1724, (TooltipType)TooltipType.field_41070);
    }

    public static List<String> lines(ItemStack itemStack) {
        List<Text> list = pfd.tooltip(itemStack);
        ArrayList<String> arrayList = new ArrayList<String>(list.size());
        for (Text text : list) {
            arrayList.add(pfl.title(text.getString()));
        }
        return arrayList;
    }

    private static /* synthetic */ int bhr(int n, int n2) {
        return (n ^ n2) + -579635674;
    }

    private static /* synthetic */ int bhs(int n, int n2) {
        return pfd.bhr(n, n2) * n2;
    }
}

