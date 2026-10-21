/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10185
 *  net.minecraft.class_10255
 *  net.minecraft.class_10266
 *  net.minecraft.class_10266$class_10267
 *  net.minecraft.class_10387
 *  net.minecraft.class_1124
 *  net.minecraft.class_11406
 *  net.minecraft.class_11407
 *  net.minecraft.class_11980
 *  net.minecraft.class_11986
 *  net.minecraft.class_1267
 *  net.minecraft.class_1297
 *  net.minecraft.class_1297$class_5529
 *  net.minecraft.class_1303
 *  net.minecraft.class_1542
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_1937
 *  net.minecraft.class_22
 *  net.minecraft.class_2535
 *  net.minecraft.class_2547
 *  net.minecraft.class_2561
 *  net.minecraft.class_2596
 *  net.minecraft.class_2600
 *  net.minecraft.class_2629
 *  net.minecraft.class_2629$class_5881
 *  net.minecraft.class_2663
 *  net.minecraft.class_2664
 *  net.minecraft.class_2668
 *  net.minecraft.class_2668$class_5402
 *  net.minecraft.class_2672
 *  net.minecraft.class_2673
 *  net.minecraft.class_2675
 *  net.minecraft.class_2678
 *  net.minecraft.class_2683
 *  net.minecraft.class_2720
 *  net.minecraft.class_2724
 *  net.minecraft.class_2729
 *  net.minecraft.class_2734
 *  net.minecraft.class_2752
 *  net.minecraft.class_2765
 *  net.minecraft.class_2767
 *  net.minecraft.class_2770
 *  net.minecraft.class_2772
 *  net.minecraft.class_2775
 *  net.minecraft.class_2779
 *  net.minecraft.class_2799
 *  net.minecraft.class_2799$class_2800
 *  net.minecraft.class_2818
 *  net.minecraft.class_2856
 *  net.minecraft.class_2856$class_2857
 *  net.minecraft.class_2874
 *  net.minecraft.class_299
 *  net.minecraft.class_310
 *  net.minecraft.class_345
 *  net.minecraft.class_3469
 *  net.minecraft.class_3895
 *  net.minecraft.class_3944
 *  net.minecraft.class_418
 *  net.minecraft.class_418$class_8183
 *  net.minecraft.class_4273
 *  net.minecraft.class_5321
 *  net.minecraft.class_5888
 *  net.minecraft.class_5892
 *  net.minecraft.class_5894
 *  net.minecraft.class_5903
 *  net.minecraft.class_5904
 *  net.minecraft.class_5905
 *  net.minecraft.class_634
 *  net.minecraft.class_636
 *  net.minecraft.class_638
 *  net.minecraft.class_638$class_5271
 *  net.minecraft.class_6880
 *  net.minecraft.class_743
 *  net.minecraft.class_7438
 *  net.minecraft.class_7439
 *  net.minecraft.class_746
 *  net.minecraft.class_7495
 *  net.minecraft.class_7617
 *  net.minecraft.class_7827
 *  net.minecraft.class_8588
 *  net.minecraft.class_8589
 *  net.minecraft.class_8591
 *  net.minecraft.class_8675
 *  net.minecraft.class_8710
 *  net.minecraft.class_9053
 *  net.minecraft.class_9151
 *  net.minecraft.class_9157
 *  net.minecraft.class_9178
 *  net.minecraft.class_9209
 *  net.minecraft.class_9812
 */
package a;

import a.Bot;
import a.BotConfigHandler;
import a.BotConnection;
import a.ClientContextSwitcher;
import a.FabricAddonsBridge;
import a.ehv;
import a.BotPlayerEntity;
import a.UnsafeUtil;
import a.BotRuntime;
import a.DummyClientParts;
import a.BotWorld;
import a.Reflect;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.minecraft.class_10185;
import net.minecraft.class_10255;
import net.minecraft.class_10266;
import net.minecraft.class_10387;
import net.minecraft.class_1124;
import net.minecraft.class_11406;
import net.minecraft.class_11407;
import net.minecraft.class_11980;
import net.minecraft.class_11986;
import net.minecraft.class_1267;
import net.minecraft.class_1297;
import net.minecraft.class_1303;
import net.minecraft.class_1542;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_22;
import net.minecraft.class_2535;
import net.minecraft.class_2547;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_2600;
import net.minecraft.class_2629;
import net.minecraft.class_2663;
import net.minecraft.class_2664;
import net.minecraft.class_2668;
import net.minecraft.class_2672;
import net.minecraft.class_2673;
import net.minecraft.class_2675;
import net.minecraft.class_2678;
import net.minecraft.class_2683;
import net.minecraft.class_2720;
import net.minecraft.class_2724;
import net.minecraft.class_2729;
import net.minecraft.class_2734;
import net.minecraft.class_2752;
import net.minecraft.class_2765;
import net.minecraft.class_2767;
import net.minecraft.class_2770;
import net.minecraft.class_2772;
import net.minecraft.class_2775;
import net.minecraft.class_2779;
import net.minecraft.class_2799;
import net.minecraft.class_2818;
import net.minecraft.class_2856;
import net.minecraft.class_2874;
import net.minecraft.class_299;
import net.minecraft.class_310;
import net.minecraft.class_345;
import net.minecraft.class_3469;
import net.minecraft.class_3895;
import net.minecraft.class_3944;
import net.minecraft.class_418;
import net.minecraft.class_4273;
import net.minecraft.class_5321;
import net.minecraft.class_5888;
import net.minecraft.class_5892;
import net.minecraft.class_5894;
import net.minecraft.class_5903;
import net.minecraft.class_5904;
import net.minecraft.class_5905;
import net.minecraft.class_634;
import net.minecraft.class_636;
import net.minecraft.class_638;
import net.minecraft.class_6880;
import net.minecraft.class_743;
import net.minecraft.class_7438;
import net.minecraft.class_7439;
import net.minecraft.class_746;
import net.minecraft.class_7495;
import net.minecraft.class_7617;
import net.minecraft.class_7827;
import net.minecraft.class_8588;
import net.minecraft.class_8589;
import net.minecraft.class_8591;
import net.minecraft.class_8675;
import net.minecraft.class_8710;
import net.minecraft.class_9053;
import net.minecraft.class_9151;
import net.minecraft.class_9157;
import net.minecraft.class_9178;
import net.minecraft.class_9209;
import net.minecraft.class_9812;

final class BotPlayHandler
extends class_634 {
    private static final long ehz = UnsafeUtil.offset(class_634.class, class_638.class);
    private static final long eia = UnsafeUtil.offset(class_634.class, class_638.class_5271.class);
    private static final long eib = UnsafeUtil.offset(class_634.class, class_1124.class);
    private static final Field eic = Reflect.find(class_634.class, "net.minecraft.class_634", "field_64674", "Z");
    private final Bot eid;
    private class_638.class_5271 eie;
    private int eif = 3;
    private int eig = 3;
    private static /* synthetic */ String eih;
    private static /* synthetic */ boolean eii;

    private BotPlayHandler(class_310 class_3102, class_2535 class_25352, class_8675 class_86752, Bot dtv2) {
        super(class_3102, class_25352, class_86752);
        this.eid = dtv2;
        UnsafeUtil.put((Object)this, eib, DummyClientParts.SEARCH);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static BotPlayHandler create(class_310 class_3102, class_2535 class_25352, class_8675 class_86752, Bot dtv2) {
        boolean bl = BotRuntime.current() == dtv2;
        Object[] objectArray = FabricAddonsBridge.saveAddons();
        try {
            BotPlayHandler ehy2 = new BotPlayHandler(class_3102, class_25352, class_86752, dtv2);
            dtv2.fabricAddons = FabricAddonsBridge.created(objectArray, dtv2.fabricAddons);
            dtv2.onPlayHandler(ehy2);
            BotPlayHandler ehy3 = ehy2;
            return ehy3;
        }
        finally {
            if (!bl) {
                FabricAddonsBridge.restoreAddons(objectArray);
            }
        }
    }

    private void eij(class_638 class_6382) {
        UnsafeUtil.put((Object)this, ehz, class_6382);
        UnsafeUtil.put((Object)this, eia, this.eie);
    }

    void setPlayerLoaded(boolean bl) {
        if (eic == null) {
            return;
        }
        try {
            eic.setBoolean((Object)this, bl);
        }
        catch (IllegalAccessException illegalAccessException) {
            // empty catch block
        }
    }

    void markLoaded() {
        if (!this.method_76760()) {
            this.method_52787((class_2596)new class_10387());
            this.setPlayerLoaded(true);
        }
    }

    public void method_11120(class_2678 class_26782) {
        class_636 class_6362;
        class_2600.method_11074((class_2596)class_26782, (class_2547)this, (class_11980)this.field_45588.method_74186());
        this.field_45588.field_1761 = class_6362 = new class_636(this.field_45588, (class_634)this);
        class_8589 class_85892 = class_26782.comp_1727();
        this.eif = class_26782.comp_98();
        this.eig = class_26782.comp_169();
        this.eie = new class_638.class_5271(class_1267.field_5802, class_26782.comp_89(), class_85892.comp_1559());
        BotWorld elh2 = new BotWorld(this, this.eie, (class_5321<class_1937>)class_85892.comp_1554(), (class_6880<class_2874>)class_85892.comp_1553(), this.eif, this.eig, DummyClientParts.WORLD_RENDERER, class_85892.comp_1558(), class_85892.comp_1555(), class_85892.comp_2893(), this.eid);
        this.eij(elh2);
        this.field_45588.field_1687 = elh2;
        this.setPlayerLoaded(false);
        BotPlayerEntity eik2 = new BotPlayerEntity(this.field_45588, elh2, this, new class_3469(), new class_299(), class_10185.field_54098, false, this.eid);
        eik2.method_36456(-180.0f);
        eik2.method_33689();
        eik2.method_5838(class_26782.comp_88());
        elh2.method_53875((class_1297)eik2);
        eik2.field_3913 = new class_743(this.field_45588.field_1690);
        this.field_45588.field_1724 = eik2;
        ClientContextSwitcher.camera((class_1297)eik2);
        class_6362.method_2903((class_1657)eik2);
        eik2.method_7268(class_26782.comp_99());
        eik2.method_22420(class_26782.comp_100());
        eik2.method_53848(class_26782.comp_1964());
        eik2.method_43120(class_85892.comp_1560());
        eik2.method_51850(class_85892.comp_1561());
        class_6362.method_32790(class_85892.comp_1556(), class_85892.comp_1557());
        this.field_45592.method_47772(class_85892.comp_1556(), class_26782.comp_89());
        this.eid.onJoinWorld(elh2, eik2);
    }

    public void method_11117(class_2724 class_27242) {
        Object object;
        boolean bl;
        class_2600.method_11074((class_2596)class_27242, (class_2547)this, (class_11980)this.field_45588.method_74186());
        class_8589 class_85892 = class_27242.comp_1728();
        class_5321 class_53212 = class_85892.comp_1554();
        class_746 class_7462 = this.field_45588.field_1724;
        class_638 class_6382 = this.method_2890();
        boolean bl2 = bl = class_7462 == null || class_6382 == null || class_53212 != class_7462.method_73183().method_27983();
        if (bl) {
            Map<class_9209, class_22> map;
            if (class_6382 instanceof BotWorld) {
                object = (BotWorld)class_6382;
                map = object.maps();
            } else {
                map = null;
            }
            Map<class_9209, class_22> map2 = map;
            object = this.eie == null ? class_1267.field_5802 : this.eie.method_207();
            boolean bl3 = this.eie != null && this.eie.method_152();
            this.eie = new class_638.class_5271((class_1267)object, bl3, class_85892.comp_1559());
            BotWorld elh2 = new BotWorld(this, this.eie, (class_5321<class_1937>)class_53212, (class_6880<class_2874>)class_85892.comp_1553(), this.eif, this.eig, DummyClientParts.WORLD_RENDERER, class_85892.comp_1558(), class_85892.comp_1555(), class_85892.comp_2893(), this.eid);
            if (map2 != null) {
                elh2.copyMaps(map2);
            }
            this.eij(elh2);
            this.field_45588.field_1687 = elh2;
            class_6382 = elh2;
        }
        ClientContextSwitcher.camera(null);
        if (class_7462 != null && class_7462.method_45015()) {
            class_7462.method_7346();
        }
        boolean bl4 = class_27242.method_48016((byte)2);
        object = new BotPlayerEntity(this.field_45588, class_6382, this, class_7462 == null ? new class_3469() : class_7462.method_3143(), class_7462 == null ? new class_299() : class_7462.method_3130(), bl4 && class_7462 != null ? class_7462.method_71091() : class_10185.field_54098, bl4 && class_7462 != null && class_7462.method_5624(), this.eid);
        this.setPlayerLoaded(false);
        if (class_7462 != null) {
            object.method_5838(class_7462.method_5628());
        }
        this.field_45588.field_1724 = object;
        ClientContextSwitcher.camera((class_1297)object);
        if (bl4 && class_7462 != null) {
            List list = class_7462.method_5841().method_46357();
            if (list != null) {
                object.method_5841().method_12779(list);
            }
            object.method_18799(class_7462.method_18798());
            object.method_36456(class_7462.method_36454());
            object.method_36457(class_7462.method_36455());
        } else {
            object.method_33689();
            object.method_36456(-180.0f);
        }
        if (class_7462 != null) {
            if (class_27242.method_48016((byte)1)) {
                object.method_6127().method_26846(class_7462.method_6127());
            } else {
                object.method_6127().method_60614(class_7462.method_6127());
            }
        }
        class_6382.method_53875((class_1297)object);
        ((BotPlayerEntity)((Object)object)).field_3913 = new class_743(this.field_45588.field_1690);
        this.field_45588.field_1761.method_2903((class_1657)object);
        if (class_7462 != null) {
            object.method_7268(class_7462.method_7302());
            object.method_22420(class_7462.method_22419());
            ((BotPlayerEntity)((Object)object)).field_44911 = class_7462.field_44911;
            ((BotPlayerEntity)((Object)object)).field_44912 = class_7462.field_44912;
        }
        object.method_43120(class_85892.comp_1560());
        object.method_51850(class_85892.comp_1561());
        if (this.field_45588.field_1755 instanceof class_418 || this.field_45588.field_1755 instanceof class_418.class_8183) {
            this.field_45588.method_1507(null);
        }
        this.field_45588.field_1761.method_32790(class_85892.comp_1556(), class_85892.comp_1557());
        this.eid.onRespawn(class_6382, (class_746)object, bl);
    }

    public void method_52798(class_8588 class_85882) {
        class_2600.method_11074((class_2596)class_85882, (class_2547)this, (class_11980)this.field_45588.method_74186());
        class_8675 class_86752 = new class_8675(null, this.method_2879(), this.field_45592, this.method_29091(), this.method_45735(), this.field_45591, this.field_45590, null, this.field_48399, null, this.field_52154, this.method_72016(), this.field_62019, this.field_62020);
        BotConfigHandler ecr2 = BotConfigHandler.create(this.field_45588, this.field_45589, class_86752, this.eid, this.method_2879(), this.method_29091());
        class_2535 class_25352 = this.field_45589;
        ((BotConnection)class_25352).runInLoop(() -> {
            class_25352.method_56330(class_9157.field_48699, (class_2547)ecr2);
            class_25352.method_10743((class_2596)class_8591.field_48186);
            class_25352.method_56329(class_9157.field_48698);
        });
        this.eid.onReconfigure();
    }

    public void method_11111(class_2734 class_27342) {
        class_2600.method_11074((class_2596)class_27342, (class_2547)this, (class_11980)this.field_45588.method_74186());
        class_1297 class_12972 = class_27342.method_11800((class_1937)this.method_2890());
        if (class_12972 != null) {
            ClientContextSwitcher.camera(class_12972);
        }
    }

    public void method_11080(class_2752 class_27522) {
        class_2600.method_11074((class_2596)class_27522, (class_2547)this, (class_11980)this.field_45588.method_74186());
        class_638 class_6382 = this.method_2890();
        class_1297 class_12972 = class_6382.method_8469(class_27522.method_11841());
        if (class_12972 == null) {
            return;
        }
        boolean bl = class_12972.method_5821((class_1297)this.field_45588.field_1724);
        class_12972.method_5772();
        for (int n : class_27522.method_11840()) {
            class_1297 class_12973 = class_6382.method_8469(n);
            if (class_12973 == null) continue;
            class_12973.method_5873(class_12972, true, false);
            if (class_12973 != this.field_45588.field_1724 || bl || !(class_12972 instanceof class_10255)) continue;
            this.field_45588.field_1724.field_5982 = class_12972.method_36454();
            this.field_45588.field_1724.method_36456(class_12972.method_36454());
            this.field_45588.field_1724.method_5847(class_12972.method_36454());
        }
    }

    public void method_11148(class_2663 class_26632) {
        if (class_26632.method_11470() == 35) {
            class_2600.method_11074((class_2596)class_26632, (class_2547)this, (class_11980)this.field_45588.method_74186());
            class_1297 class_12972 = class_26632.method_11469((class_1937)this.method_2890());
            if (class_12972 != null && class_12972 == this.field_45588.field_1724) {
                this.eid.onTotemPop();
            }
            return;
        }
        super.method_11148(class_26632);
    }

    public void method_11085(class_2668 class_26682) {
        class_2600.method_11074((class_2596)class_26682, (class_2547)this, (class_11980)this.field_45588.method_74186());
        class_2668.class_5402 class_54022 = class_26682.method_11491();
        if (class_54022 == class_2668.field_25649) {
            this.method_52787((class_2596)new class_2799(class_2799.class_2800.field_12774));
        } else {
            if (class_54022 == class_2668.field_25650) {
                return;
            }
            if (class_54022 == class_2668.field_46637) {
                this.eid.onChunksComing();
            } else if (class_54022 == class_2668.field_25645) {
                this.eid.chat.system(class_2561.method_43471((String)"block.minecraft.spawn.not_valid").getString());
            } else {
                super.method_11085(class_26682);
            }
        }
    }

    public void method_11124(class_2664 class_26642) {
        class_2600.method_11074((class_2596)class_26642, (class_2547)this, (class_11980)this.field_45588.method_74186());
        if (this.field_45588.field_1724 != null) {
            class_26642.comp_2884().ifPresent(arg_0 -> ((class_746)this.field_45588.field_1724).method_45319(arg_0));
        }
    }

    public void method_34075(class_5892 class_58922) {
        class_2600.method_11074((class_2596)class_58922, (class_2547)this, (class_11980)this.field_45588.method_74186());
        class_1297 class_12972 = this.method_2890().method_8469(class_58922.comp_2275());
        if (class_12972 != null && class_12972 == this.field_45588.field_1724) {
            this.eid.onDeath(class_58922.comp_2276());
        }
        super.method_34075(class_58922);
    }

    public void method_17587(class_3944 class_39442) {
        super.method_17587(class_39442);
        this.eid.onScreenOpened(class_39442.method_17594());
    }

    public void method_17186(class_3895 class_38952) {
    }

    public void method_11150(class_2775 class_27752) {
        class_2600.method_11074((class_2596)class_27752, (class_2547)this, (class_11980)this.field_45588.method_74186());
        class_638 class_6382 = this.method_2890();
        class_1297 class_12972 = class_6382.method_8469(class_27752.method_11915());
        if (class_12972 == null) {
            return;
        }
        if (class_12972 instanceof class_1542) {
            class_1542 class_15422 = (class_1542)class_12972;
            class_1799 class_17992 = class_15422.method_6983();
            if (!class_17992.method_7960()) {
                class_17992.method_7934(class_27752.method_11913());
            }
            if (class_17992.method_7960()) {
                class_6382.method_2945(class_27752.method_11915(), class_1297.class_5529.field_26999);
            }
        } else if (!(class_12972 instanceof class_1303)) {
            class_6382.method_2945(class_27752.method_11915(), class_1297.class_5529.field_26999);
        }
    }

    public void method_11128(class_2672 class_26722) {
        super.method_11128(class_26722);
        class_638 class_6382 = this.method_2890();
        int n = class_26722.method_11523();
        int n2 = class_26722.method_11524();
        class_6382.method_38536(() -> {
            class_2818 class_28182 = class_6382.method_2935().method_12126(n, n2, false);
            if (class_28182 != null) {
                this.eid.onChunkLoaded(class_28182);
            }
        });
    }

    public void method_20203(class_4273 class_42732) {
        class_2600.method_11074((class_2596)class_42732, (class_2547)this, (class_11980)this.field_45588.method_74186());
        this.eif = class_42732.method_20206();
        this.method_2890().method_2935().method_20180(class_42732.method_20206());
    }

    public void method_43596(class_7439 class_74392) {
        class_2600.method_11074((class_2596)class_74392, (class_2547)this, (class_11980)this.field_45588.method_74186());
        this.eid.onServerMessage(class_74392.comp_763(), class_74392.comp_906());
    }

    public void method_43595(class_7438 class_74382) {
        class_2561 class_25612;
        class_2600.method_11074((class_2596)class_74382, (class_2547)this, (class_11980)this.field_45588.method_74186());
        class_2561 class_25613 = class_74382.comp_1103() != null ? class_74382.comp_1103() : class_2561.method_43470((String)class_74382.comp_1102().comp_1090());
        try {
            class_25612 = class_74382.comp_943().method_44837(class_25613);
        }
        catch (Throwable throwable) {
            class_25612 = class_25613;
        }
        this.eid.onServerMessage(class_25612, false, true);
    }

    public void method_45724(class_7827 class_78272) {
        class_2561 class_25612;
        class_2600.method_11074((class_2596)class_78272, (class_2547)this, (class_11980)this.field_45588.method_74186());
        try {
            class_25612 = class_78272.comp_1098().method_44837(class_78272.comp_1097());
        }
        catch (Throwable throwable) {
            class_25612 = class_78272.comp_1097();
        }
        this.eid.onServerMessage(class_25612, false, true);
    }

    public void method_44814(class_7617 class_76172) {
    }

    public void method_34076(class_5894 class_58942) {
        class_2600.method_11074((class_2596)class_58942, (class_2547)this, (class_11980)this.field_45588.method_74186());
        this.eid.onServerMessage(class_58942.comp_2279(), true);
    }

    public void method_34083(class_5904 class_59042) {
        class_2600.method_11074((class_2596)class_59042, (class_2547)this, (class_11980)this.field_45588.method_74186());
        this.eid.onTitle(class_59042.comp_2281(), false);
    }

    public void method_34082(class_5903 class_59032) {
        class_2600.method_11074((class_2596)class_59032, (class_2547)this, (class_11980)this.field_45588.method_74186());
        this.eid.onTitle(class_59032.comp_2280(), true);
    }

    public void method_34084(class_5905 class_59052) {
    }

    public void method_34071(class_5888 class_58882) {
        class_2600.method_11074((class_2596)class_58882, (class_2547)this, (class_11980)this.field_45588.method_74186());
        this.eid.onTitle(null, false);
    }

    public void method_11105(class_2772 class_27722) {
        class_2600.method_11074((class_2596)class_27722, (class_2547)this, (class_11980)this.field_45588.method_74186());
        this.eid.tabHeader = class_27722.comp_2282();
        this.eid.tabFooter = class_27722.comp_2283();
    }

    public void method_11078(class_2629 class_26292) {
        class_2600.method_11074((class_2596)class_26292, (class_2547)this, (class_11980)this.field_45588.method_74186());
        Map<UUID, class_345> map = this.eid.bossBars;
        class_26292.method_34091((class_2629.class_5881)new ehv(this, map));
    }

    public void method_11130(class_2779 class_27792) {
    }

    public void method_11161(class_2729 class_27292) {
    }

    public void method_64555(class_10266 class_102662) {
        class_2600.method_11074((class_2596)class_102662, (class_2547)this, (class_11980)this.field_45588.method_74186());
        if (this.field_45588.field_1724 == null) {
            return;
        }
        class_299 class_2992 = this.field_45588.field_1724.method_3130();
        if (class_102662.comp_3294()) {
            class_2992.method_65018();
        }
        for (class_10266.class_10267 class_102672 : class_102662.comp_3232()) {
            class_2992.method_64849(class_102672.comp_3233());
            if (!class_102672.method_64562()) continue;
            class_2992.method_64857(class_102672.comp_3233().comp_3262());
        }
        class_2992.method_64853();
    }

    public void method_44075(class_7495 class_74952) {
        class_2600.method_11074((class_2596)class_74952, (class_2547)this, (class_11980)this.field_45588.method_74186());
        this.eid.serverLabel = class_74952.comp_2277();
    }

    public void method_11088(class_2683 class_26832) {
        class_2600.method_11074((class_2596)class_26832, (class_2547)this, (class_11980)this.field_45588.method_74186());
        class_638 class_6382 = this.method_2890();
        class_9209 class_92092 = class_26832.comp_2270();
        class_22 class_222 = class_6382.method_17891(class_92092);
        if (class_222 == null) {
            class_222 = class_22.method_32362((byte)class_26832.comp_2271(), (boolean)class_26832.comp_2272(), (class_5321)class_6382.method_27983());
            class_6382.method_47437(class_92092, class_222);
        }
        class_26832.method_11642(class_222);
        this.eid.onMapUpdated(class_92092);
    }

    public void method_56607(class_9178 class_91782) {
    }

    public void method_74459(class_11986 class_119862) {
    }

    public void method_11152(class_8710 class_87102) {
    }

    public void method_11146(class_2767 class_27672) {
    }

    public void method_11125(class_2765 class_27652) {
    }

    public void method_11082(class_2770 class_27702) {
    }

    public void method_11077(class_2675 class_26752) {
    }

    public void method_11098(class_2673 class_26732) {
    }

    public void method_52784(class_2720 class_27202) {
        this.eid.packs.offer(class_27202, this.field_45589);
    }

    public void method_55512(class_9053 class_90532) {
    }

    public void method_56150(class_9151 class_91512) {
        this.field_45589.method_10747((class_2561)class_2561.method_43470((String)("Сервер перекинул на другой адрес: " + class_91512.comp_2240() + ":" + class_91512.comp_2241())));
    }

    public void method_71666(class_11407 class_114072) {
        this.eid.chat.system("Сервер показал диалог - пропущен");
    }

    public void method_71665(class_11406 class_114062) {
    }

    public void method_18784() {
        this.method_52789();
        this.field_45592.method_47770();
        this.eid.packs.tick(this.field_45589);
        this.eid.tickLoading(this);
    }

    public void method_10839(class_9812 class_98122) {
        this.field_45592.method_47776();
        this.eid.onDisconnected(class_98122.comp_2853());
    }

    public class_9812 method_60881(class_2561 class_25612, Throwable throwable) {
        return new class_9812(class_25612);
    }

    public void method_59807(class_2596 class_25962, Exception exception) {
        this.eid.onPacketError(class_25962, exception);
    }

    int loadDistance() {
        return this.eif;
    }

    void acceptPack(UUID uUID, class_2856.class_2857 class_28572) {
        this.method_52787((class_2596)new class_2856(uUID, class_28572));
    }

    private static /* synthetic */ int em(int n, int n2) {
        return n * n2 ^ 0x48A76302;
    }

    private static /* synthetic */ int en(int n, int n2) {
        return BotPlayHandler.em(n, n2) ^ 0xBB33819B;
    }

    private static /* synthetic */ int eo(int n, int n2) {
        return BotPlayHandler.en(n, n2) * n2;
    }
}

