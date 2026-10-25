/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.MapColor
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.component.DataComponentTypes
 *  net.minecraft.component.type.MapIdComponent
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.decoration.ItemFrameEntity
 *  net.minecraft.item.FilledMapItem
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.map.MapState
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Direction$Axis
 *  net.minecraft.world.World
 */
package a;

import a.dtv;
import a.egq;
import a.elb;
import a.enq;
import a.erc;
import a.erh;
import a.erp;
import a.eso;
import a.esz;
import flow.dev.a;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import net.minecraft.block.MapColor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.MapIdComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.ItemFrameEntity;
import net.minecraft.item.FilledMapItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.map.MapState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public final class eao {
    private static final MinecraftClient eap = MinecraftClient.method_1551();
    private static final int eaq = 128;
    private static final int ear = 8;
    private static final long eas = 120000L;
    private static final long eat = 60000L;
    private static final int eau = 40;
    private static final int eav = 3;
    private final dtv eaw;
    private long eax;
    private int eay;
    private int eaz;
    private boolean eba;
    private long ebb;
    private long ebc;
    private int[] ebd;
    private int ebe;
    private int ebf;
    private int ebg;
    private int ebh;
    private boolean ebi;
    private boolean ebj;
    private long ebk;
    private boolean ebl;
    private int ebm;
    private int ebn;
    private int ebo;
    private volatile String ebp = "";
    private volatile String ebq = "";
    private String ebr;
    private long ebs;
    private elb ebt;
    private static /* synthetic */ int ebu;
    private static /* synthetic */ boolean ebv;

    eao(dtv dtv2) {
        this.eaw = dtv2;
    }

    static eso recognize(BufferedImage bufferedImage) {
        try {
            erc erc2 = erp.solve(bufferedImage);
            if (!erc2.code().isEmpty()) {
                return new eso(erc2.code(), erc2.message());
            }
            eso eso2 = esz.solve(bufferedImage);
            return eso2.code().isEmpty() ? new eso("", erc2.message()) : eso2;
        }
        catch (erh erh2) {
            eso eso3 = esz.solve(bufferedImage);
            return eso3.code().isEmpty() ? new eso("", erh2.getMessage()) : eso3;
        }
    }

    void arm() {
        this.eax = System.currentTimeMillis() + 120000L;
        this.reset();
    }

    void onHint(String string) {
        String string2 = string.toLowerCase(Locale.ROOT);
        if (string2.contains(a.b("\ua4c4\udd7f\u57a3\uc9aa", 1306042618)) || string2.contains(a.d("\u1a10\u63a3\ue961\u7714\ufcd4\u7a6e\uc034", -651566329, -1603733133))) {
            this.eax = Math.max(this.eax, System.currentTimeMillis() + 60000L);
        }
    }

    void onMap() {
        this.eba = true;
    }

    void reset() {
        this.ecd();
        this.ebd = null;
        this.ebe = 0;
        this.ebf = 0;
        this.ebg = 0;
        this.ebh = 0;
        this.ebi = false;
        this.ebj = false;
        this.ebb = 0L;
        this.ebc = 0L;
        this.eaz = 0;
        this.eba = true;
        this.ebn = 0;
        this.ebo = 0;
        this.ebr = null;
        this.ebp = "";
        this.ebq = "";
    }

    void tick() {
        boolean bl;
        if (++this.eay % 4 != 0) {
            return;
        }
        ClientPlayerEntity clientPlayerEntity = eao.eap.field_1724;
        ClientWorld clientWorld = eao.eap.field_1687;
        if (clientPlayerEntity == null || clientWorld == null) {
            return;
        }
        if (this.ebd == null && System.currentTimeMillis() > this.eax) {
            return;
        }
        boolean bl2 = bl = this.ebw(clientPlayerEntity, clientWorld) || this.eby(clientPlayerEntity, clientWorld);
        if (bl) {
            this.eaz = 0;
            return;
        }
        this.eaz += 4;
        if (this.ebd != null && this.eaz >= 40) {
            this.reset();
            this.eaw.onCaptchaGone();
        }
    }

    private boolean ebw(ClientPlayerEntity clientPlayerEntity, ClientWorld clientWorld) {
        for (List<ItemFrameEntity> list : enq.findWalls((World)clientWorld, (Entity)clientPlayerEntity, 16.0)) {
            if (!this.ebx(list, clientWorld)) continue;
            return true;
        }
        return false;
    }

    private boolean ebx(List<ItemFrameEntity> list, ClientWorld clientWorld) {
        int n;
        Direction direction = list.get(0).method_5735();
        boolean bl = direction.method_10166() == Direction.Axis.field_11051;
        boolean bl2 = direction == Direction.field_11043 || direction == Direction.field_11034;
        int n2 = Integer.MAX_VALUE;
        int n3 = Integer.MIN_VALUE;
        int n4 = Integer.MAX_VALUE;
        int n5 = Integer.MIN_VALUE;
        long l = direction.ordinal();
        for (ItemFrameEntity itemFrameEntity : list) {
            BlockPos blockPos = itemFrameEntity.method_59940();
            n = bl ? blockPos.method_10263() : blockPos.method_10260();
            n2 = Math.min(n2, n);
            n3 = Math.max(n3, n);
            n4 = Math.min(n4, blockPos.method_10264());
            n5 = Math.max(n5, blockPos.method_10264());
            l = l * 31L + (long)itemFrameEntity.method_5628();
            l = l * 31L + blockPos.method_10063();
            l = l * 31L + (long)itemFrameEntity.method_6934();
            l = l * 31L + (long)eao.ebz(itemFrameEntity.method_6940());
        }
        int n6 = n3 - n2 + 1;
        int n7 = n5 - n4 + 1;
        if (n6 > 8 || n7 > 8) {
            return false;
        }
        if (l == this.ebb && !this.eba && this.ebd != null) {
            return true;
        }
        if (l == this.ebc && !this.eba) {
            return false;
        }
        int n8 = n6 * 128;
        n = n7 * 128;
        int[] nArray = new int[n8 * n];
        int n9 = 0;
        for (ItemFrameEntity itemFrameEntity : list) {
            MapState mapState = FilledMapItem.method_8001((ItemStack)itemFrameEntity.method_6940(), (World)clientWorld);
            if (mapState == null || mapState.field_122 == null || mapState.field_122.length != 16384) continue;
            ++n9;
            BlockPos blockPos = itemFrameEntity.method_59940();
            int n10 = bl ? blockPos.method_10263() : blockPos.method_10260();
            int n11 = (bl2 ? n3 - n10 : n10 - n2) * 128;
            int n12 = (n5 - blockPos.method_10264()) * 128;
            eao.eca(mapState.field_122, itemFrameEntity.method_6934() & 3, nArray, n8, n11, n12);
        }
        if (n9 == list.size() && enq.seamRatio(nArray, n8, n) > 2.0) {
            this.ebc = l;
            return false;
        }
        boolean bl3 = l != this.ebb;
        this.ebb = l;
        this.eba = false;
        this.ecb(nArray, n8, n, n9, list.size(), bl3);
        return true;
    }

    private boolean eby(ClientPlayerEntity clientPlayerEntity, ClientWorld clientWorld) {
        ItemStack itemStack = clientPlayerEntity.method_6047();
        if (!(itemStack.method_7909() instanceof FilledMapItem)) {
            return false;
        }
        MapState mapState = FilledMapItem.method_8001((ItemStack)itemStack, (World)clientWorld);
        if (mapState == null || mapState.field_122 == null || mapState.field_122.length != 16384) {
            return false;
        }
        long l = 55150044793L + (long)eao.ebz(itemStack);
        if (l == this.ebb && !this.eba && this.ebd != null) {
            return true;
        }
        boolean bl = l != this.ebb;
        this.ebb = l;
        this.eba = false;
        int[] nArray = new int[16384];
        eao.eca(mapState.field_122, 0, nArray, 128, 0, 0);
        this.ecb(nArray, 128, 128, 1, 1, bl);
        return true;
    }

    private static int ebz(ItemStack itemStack) {
        MapIdComponent mapIdComponent = (MapIdComponent)itemStack.method_58694(DataComponentTypes.field_49646);
        return mapIdComponent == null ? -1 : mapIdComponent.comp_2315();
    }

    private static void eca(byte[] byArray, int n, int[] nArray, int n2, int n3, int n4) {
        for (int i = 0; i < 128; ++i) {
            for (int j = 0; j < 128; ++j) {
                int n5 = byArray[i * 128 + j] & 0xFF;
                int n6 = n5 < 4 ? 0 : MapColor.method_38480((int)n5);
                switch (n) {
                    case 1: {
                        int n7 = 127 - i;
                        int n8 = j;
                        break;
                    }
                    case 2: {
                        int n7 = 127 - j;
                        int n8 = 127 - i;
                        break;
                    }
                    case 3: {
                        int n7 = i;
                        int n8 = 127 - j;
                        break;
                    }
                    default: {
                        int n7 = j;
                        int n8 = i;
                    }
                }
                nArray[(n4 + n8) * n2 + n3 + n7] = n6;
            }
        }
    }

    private void ecb(int[] nArray, int n, int n2, int n3, int n4, boolean bl) {
        this.ebd = nArray;
        this.ebe = n;
        this.ebf = n2;
        this.ebg = n3;
        this.ebh = n4;
        this.ebl = true;
        if (bl) {
            this.ebi = true;
            this.ebk = System.currentTimeMillis();
            this.ebj = false;
            this.ebm = 0;
        }
        if (n3 == n4) {
            int n5 = Arrays.hashCode(nArray);
            if (n5 != this.ebm) {
                if (this.ebm != 0) {
                    this.ebi = true;
                    this.ebk = System.currentTimeMillis();
                    this.ebj = false;
                    if (this.ebr != null && System.currentTimeMillis() - this.ebs > 1500L) {
                        this.eaw.chat.system(a.d("\uee98\u9775\u1dd6\u83a0\u0800\u8ad3", 1879153064, 2019521320) + this.ebr + a.c(-965145357, "\u0cc9\u7165\ufbbe\u61da\uee12\u68dc\ud2f7\u5b03\uc52e\u4f92\ucc2f\u3652\ubc98\u252a\uaf75\u2986\u93b6\u1808\u86a1\u00fa\u897d\uf32e\u7de7\ue633\u604b\uea90"));
                        this.ebr = null;
                    }
                }
                this.ebm = n5;
            }
            this.ecc(nArray, n, n2, n5);
        }
        if (!this.ebj && n3 * 2 >= n4) {
            this.ebj = true;
            this.eaw.onCaptcha();
        }
    }

    private void ecc(int[] nArray, int n, int n2, int n3) {
        if (n3 == this.ebn || !egq.get().isSolvingCaptcha()) {
            return;
        }
        this.ebn = n3;
        if (this.ebo >= 3) {
            this.ebp = "";
            this.ebq = a.c(1842486206, "\u1fd7\u6612\uecb6\u72c9\ufd72\u7fdc\uc5f0\u4c7f\ud222\u589f\udf39\u2530\uab99\u3250\ub808\u3e88\u84ca\u0f77\u95d7\u1395\u9e02\ue423\u6a97\uf141\u732e\uf9f2\u404c\uca0f\u50f8\ud6ae\u5d1c\ua3c1\u2d96\ub07d\u362a\ubc91\u0752\u8942\u0fe0\u965d");
            return;
        }
        this.ebp = "";
        this.ebq = a.b("\u8a94\uf351\u79f5\ue78a\u6831\ueae7\u50cb\ud940\u476d\ucdd9\u4a7d\ub46e\u3ea3\ua718\u2d3b\uabc8\u11fd\u9e29\u049d\u82b5\u0f2f\u757e\ufbcd", -727413054);
        BufferedImage bufferedImage = new BufferedImage(n, n2, 2);
        bufferedImage.setRGB(0, 0, n, n2, nArray, 0, n);
        Thread.ofVirtual().start(() -> {
            eso eso2;
            try {
                eso2 = eao.recognize(bufferedImage);
            }
            catch (Throwable throwable) {
                eso2 = new eso("", String.valueOf(throwable.getMessage()));
            }
            eso eso3 = eso2;
            eap.execute(() -> {
                if (n3 != this.ebm) {
                    return;
                }
                if (!eso3.code().isEmpty()) {
                    ++this.ebo;
                    this.ebp = eso3.code();
                    this.ebq = "";
                    this.answered(eso3.code());
                    this.eaw.onCaptchaSolved(eso3.code());
                } else {
                    this.ebq = "";
                    this.eaw.onCaptchaUnsolved(eso3.message());
                }
            });
        });
    }

    private void ecd() {
        if (this.ebr != null && System.currentTimeMillis() - this.ebs < 60000L) {
            this.eaw.chat.system(a.d("\u3014\u498f\uc353\u5d5a\ud6fa\u545b\uea17\u6399\ufdbe\u770a\uf0ab\u0ad7\u8472\u19c9\u9380", 545135425, 1064316736) + this.ebr);
        }
        this.ebr = null;
    }

    public void answered(String string) {
        if (this.ebd == null || string == null || !string.matches(a.b("\u6619\u1f90\u955c\u0b65\u80ad\u0608\ubc1e", 394094146))) {
            return;
        }
        this.ebr = string;
        this.ebs = System.currentTimeMillis();
    }

    public String getAutoCode() {
        return this.ebp;
    }

    public String getAutoState() {
        return this.ebq;
    }

    public boolean isShown() {
        return this.ebd != null && this.ebi;
    }

    public boolean isPresent() {
        return this.ebd != null;
    }

    public void dismiss() {
        this.ebi = false;
    }

    public void show() {
        if (this.ebd != null) {
            this.ebi = true;
        }
    }

    public int getWidth() {
        return this.ebe;
    }

    public int getHeight() {
        return this.ebf;
    }

    public int getFilledTiles() {
        return this.ebg;
    }

    public int getTotalTiles() {
        return this.ebh;
    }

    public long getShownAt() {
        return this.ebk;
    }

    public elb texture() {
        int[] nArray = this.ebd;
        if (nArray == null) {
            return null;
        }
        if (this.ebt != null && (this.ebt.width != this.ebe || this.ebt.height != this.ebf)) {
            this.close();
        }
        if (this.ebt == null) {
            this.ebt = new elb(a.c(-129124801, "\ub65b\ucfe8\u452a\udb5f\u509f\ud625\u6c7f"), this.ebe, this.ebf);
            this.ebl = true;
        }
        if (this.ebl) {
            for (int i = 0; i < this.ebf; ++i) {
                for (int j = 0; j < this.ebe; ++j) {
                    int n = nArray[i * this.ebe + j];
                    this.ebt.set(j, i, n == 0 ? -15066078 : n);
                }
            }
            this.ebt.upload();
            this.ebl = false;
        }
        return this.ebt;
    }

    void close() {
        if (this.ebt != null) {
            this.ebt.close();
        }
        this.ebt = null;
    }

    private static /* synthetic */ int cf(int n, int n2) {
        return n + n2 | 0x4F646D07;
    }

    private static /* synthetic */ int cg(int n, int n2) {
        return eao.cf(n, n2) ^ 0xF59C6142;
    }

    private static /* synthetic */ int ch(int n, int n2) {
        return n + n2 ^ 0x6231C9A7;
    }
}

