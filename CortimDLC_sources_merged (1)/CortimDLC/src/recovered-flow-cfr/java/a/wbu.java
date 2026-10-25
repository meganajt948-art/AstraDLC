/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.screen.option.GameOptionsScreen
 *  net.minecraft.client.option.SimpleOption
 */
package a;

import a.vxr;
import a.wbr;
import com.mojang.serialization.Codec;
import flow.dev.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.option.SimpleOption;

public final class wbu<T> {
    private static final List<wbu<?>> wbv = new ArrayList();
    private static Field wbw;
    private static Field wbx;
    private static boolean wby;
    private final Function<MinecraftClient, SimpleOption<T>> wbz;
    private SimpleOption<T> wca;
    private volatile boolean wcb;
    private volatile T wcc;
    private Object wcd;
    private static /* synthetic */ int wce;
    private static /* synthetic */ String wcf;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public wbu(Function<MinecraftClient, SimpleOption<T>> function) {
        this.wbz = function;
        List<wbu<?>> list = wbv;
        synchronized (list) {
            wbv.add(this);
        }
    }

    public boolean override(T t) {
        SimpleOption<T> simpleOption = this.wcg();
        if (simpleOption == null || !this.wch(simpleOption)) {
            return false;
        }
        try {
            Object object = wbw.get(simpleOption);
            if (!this.wcb || !Objects.equals(object, this.wcd)) {
                Object object2 = object;
                this.wcc = object2;
            }
            this.wcb = true;
            if (!Objects.equals(object, t)) {
                wbw.set(simpleOption, t);
            }
            this.wcd = t;
            return true;
        }
        catch (ReflectiveOperationException | RuntimeException exception) {
            wbu.wcj(exception);
            return false;
        }
    }

    public void release() {
        if (!this.wcb) {
            return;
        }
        this.wcb = false;
        SimpleOption<T> simpleOption = this.wcg();
        if (simpleOption != null && wbw != null) {
            try {
                wbw.set(simpleOption, this.wcc);
            }
            catch (ReflectiveOperationException | RuntimeException exception) {
                wbu.wcj(exception);
            }
        }
    }

    public boolean active() {
        return this.wcb;
    }

    public T own() {
        if (this.wcb) {
            return this.wcc;
        }
        SimpleOption<T> simpleOption = this.wcg();
        return (T)(simpleOption == null ? null : simpleOption.getValue());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void releaseAll() {
        List<wbu<?>> list = wbv;
        synchronized (list) {
            for (wbu<?> wbu2 : wbv) {
                wbu2.release();
            }
        }
    }

    public static boolean suspended(MinecraftClient minecraftClient) {
        return minecraftClient.currentScreen instanceof GameOptionsScreen;
    }

    private SimpleOption<T> wcg() {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        return minecraftClient == null || minecraftClient.options == null ? null : this.wbz.apply(minecraftClient);
    }

    private boolean wch(SimpleOption<T> simpleOption) {
        if (wby) {
            return false;
        }
        if (wbw == null) {
            wbw = vxr.find(SimpleOption.class, a.d("\uf4e7\u8d5d\u079f\u99b4\u1220\u9495\u2ec1\ua73b\u3962\ub3c2\u3402\uce74\u40b1\ud95a\u5344\ud5ba\u6ff8\ue03b\u7a88\ufcf5\u756a\u0f3d\u8188\u1a5c", -316789129, -887170330), a.c(-2120991219, "\u3e60\u47de\ucd01\u5379\ud8a6\u5e2c\ue413\u6de6\uf3b6\u7909\ufed4"), a.d("\u06c5\u7f52\uf58a\u6bec\ue02c\u66d3\udcc3\u553f\ucb6f\u41d7\uc64c\u3c5d\ub2a7\u2b1e\ua142\u27b5\u9ded\u1273", 342774442, -1189129167));
            wbx = vxr.find(SimpleOption.class, a.b("\u5447\u2dfd\ua73f\u3914\ub280\u3435\u8e61\u079b\u99c2\u1362\u94a2\u6ed4\ue011\u79fa\uf3e4\u751a\ucf58\u409b\uda28\u5c55\ud5ca\uaf9d\u2128\ubafc", 1812616241), a.c(-275416092, "\u7b89\u0237\u88e8\u1690\u9d4f\u1bc5\ua1fa\u2800\ub655\u3ce1\ubb3c"), a.b("\u4bed\u3273\ub8ac\u26df\uad4a\u2bb9\u91e8\u181c\u8648\u0cf6\u8b2c\u7115\uff9e\u6639\uec7d\u6a97\ud0d0\u5f0c\uc5ba\u43f8\uca14\ub050\u3efe\ua529\u2357\ua9c7\u1018\u9e65\u0499\u82c9\u097c\uf7f5", -262714495));
            if (wbw == null) {
                wby = true;
                return false;
            }
        }
        if (this.wca != simpleOption) {
            this.wca = simpleOption;
            this.wci(simpleOption);
        }
        return true;
    }

    private void wci(SimpleOption<T> simpleOption) {
        if (wbx == null) {
            return;
        }
        try {
            Codec codec = simpleOption.getCodec();
            wbx.set(simpleOption, new wbr(this, codec));
        }
        catch (ReflectiveOperationException | RuntimeException exception) {
            System.out.println(a.c(-603311661, "\u3185\u483b\uc2a6\u5c98\ud750\u51e5\uebab\u625c\ufc02\u76fd\uf167\u0b0c\u8588\u1c6a\u962b\u10cd\uaa91\u2541\ubfb6\u39a6\ub043\uca41\u44bb\udf77\u595c\ud3c4\u6a6d\ue46f\u7ecf\uf881\u7333\u8de7\u07a1\u9e15\u1807\u92f7\u2d6d\ua71e\u21c6\ub866\u3220\u4cd8\uc6ce\u413c\udbe0\u5598\uec44\u66fc\ue0b1\u7b76\uf556\u0fce\u8664{\u9a92") + exception);
        }
    }

    private static void wcj(Throwable throwable) {
        if (!wby) {
            wby = true;
            System.out.println(a.b("\u2cc3\u556d\udfba\u41d6\uca07\u4cb7\uf6f9\u7f5b\ue151\u6bfb\uec27\u1641\u9881\u0138\u8b6e\u0d92\ub7de\u3801\ua2bb\u24b5\uad58", 660810937) + throwable);
        }
    }

    private static /* synthetic */ int don(int n, int n2) {
        return n - n2 | 0xA2860A78;
    }
}

