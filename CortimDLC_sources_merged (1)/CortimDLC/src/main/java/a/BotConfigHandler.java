/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_11406
 *  net.minecraft.class_11407
 *  net.minecraft.class_11751
 *  net.minecraft.class_11752
 *  net.minecraft.class_11980
 *  net.minecraft.class_2535
 *  net.minecraft.class_2547
 *  net.minecraft.class_2561
 *  net.minecraft.class_2596
 *  net.minecraft.class_2600
 *  net.minecraft.class_2720
 *  net.minecraft.class_2790
 *  net.minecraft.class_310
 *  net.minecraft.class_5455
 *  net.minecraft.class_5455$class_6890
 *  net.minecraft.class_5912
 *  net.minecraft.class_6860
 *  net.minecraft.class_7699
 *  net.minecraft.class_7701
 *  net.minecraft.class_7832
 *  net.minecraft.class_8674
 *  net.minecraft.class_8675
 *  net.minecraft.class_8733
 *  net.minecraft.class_8734
 *  net.minecraft.class_8736
 *  net.minecraft.class_9053
 *  net.minecraft.class_9095
 *  net.minecraft.class_9127
 *  net.minecraft.class_9129
 *  net.minecraft.class_9151
 *  net.minecraft.class_9173
 *  net.minecraft.class_9220
 *  net.minecraft.class_9247
 *  net.minecraft.class_9250
 *  net.minecraft.class_9812
 */
package a;

import a.Bot;
import a.BotConnection;
import a.FabricAddonsBridge;
import a.BotPlayHandler;
import a.BotRuntime;
import com.mojang.authlib.GameProfile;
import flow.dev.StringDecryptor;
import net.minecraft.class_11406;
import net.minecraft.class_11407;
import net.minecraft.class_11751;
import net.minecraft.class_11752;
import net.minecraft.class_11980;
import net.minecraft.class_2535;
import net.minecraft.class_2547;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_2600;
import net.minecraft.class_2720;
import net.minecraft.class_2790;
import net.minecraft.class_310;
import net.minecraft.class_5455;
import net.minecraft.class_5912;
import net.minecraft.class_6860;
import net.minecraft.class_7699;
import net.minecraft.class_7701;
import net.minecraft.class_7832;
import net.minecraft.class_8674;
import net.minecraft.class_8675;
import net.minecraft.class_8733;
import net.minecraft.class_8734;
import net.minecraft.class_8736;
import net.minecraft.class_9053;
import net.minecraft.class_9095;
import net.minecraft.class_9127;
import net.minecraft.class_9129;
import net.minecraft.class_9151;
import net.minecraft.class_9173;
import net.minecraft.class_9220;
import net.minecraft.class_9247;
import net.minecraft.class_9250;
import net.minecraft.class_9812;

final class BotConfigHandler
extends class_8674 {
    private final Bot ecs;
    private final GameProfile ect;
    private final class_5455.class_6890 ecu;
    private final class_9173 ecv = new class_9173();
    private class_9247 ecw;
    private class_7699 ecx;
    private static /* synthetic */ String ecy;
    private static /* synthetic */ String ecz;

    private BotConfigHandler(class_310 class_3102, class_2535 class_25352, class_8675 class_86752, Bot dtv2, GameProfile gameProfile, class_5455.class_6890 class_68902) {
        super(class_3102, class_25352, class_86752);
        this.ecs = dtv2;
        this.ect = gameProfile;
        this.ecu = class_68902;
        this.ecx = class_86752.comp_1614();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static BotConfigHandler create(class_310 class_3102, class_2535 class_25352, class_8675 class_86752, Bot dtv2, GameProfile gameProfile, class_5455.class_6890 class_68902) {
        boolean bl = BotRuntime.current() == dtv2;
        Object[] objectArray = FabricAddonsBridge.saveAddons();
        try {
            BotConfigHandler ecr2 = new BotConfigHandler(class_3102, class_25352, class_86752, dtv2, gameProfile, class_68902);
            dtv2.fabricAddons = FabricAddonsBridge.created(objectArray, bl ? dtv2.fabricAddons : null);
            BotConfigHandler ecr3 = ecr2;
            return ecr3;
        }
        finally {
            if (!bl) {
                FabricAddonsBridge.restoreAddons(objectArray);
            }
        }
    }

    public void method_52795(class_8734 class_87342) {
        class_2600.method_11074((class_2596)class_87342, (class_2547)this, (class_11980)this.field_45588.method_74186());
        this.ecv.method_56583(class_87342.comp_2258(), class_87342.comp_2259());
    }

    public void method_11126(class_2790 class_27902) {
        class_2600.method_11074((class_2596)class_27902, (class_2547)this, (class_11980)this.field_45588.method_74186());
        this.ecv.method_56586(class_27902.method_12000());
    }

    public void method_52796(class_7832 class_78322) {
        super.method_52796(class_78322);
        this.ecx = class_7701.field_40180.method_45387((Iterable)class_78322.comp_1113());
    }

    public void method_57045(class_9250 class_92502) {
        class_2600.method_11074((class_2596)class_92502, (class_2547)this, (class_11980)this.field_45588.method_74186());
        if (this.ecw == null) {
            this.ecw = new class_9247();
        }
        this.method_52787((class_2596)new class_9220(this.ecw.method_57049(class_92502.comp_2356())));
    }

    public void method_73257(class_11751 class_117512) {
        class_2600.method_11074((class_2596)class_117512, (class_2547)this, (class_11980)this.field_45588.method_74186());
        this.method_52787((class_2596)class_11752.field_62060);
        this.ecs.chat.system("Сервер прислал правила - приняты");
    }

    public void method_52794(class_8733 class_87332) {
        class_2600.method_11074((class_2596)class_87332, (class_2547)this, (class_11980)this.field_45588.method_74186());
        class_5455.class_6890 class_68902 = this.eda();
        class_8675 class_86752 = new class_8675(null, this.ect, this.field_45592, class_68902, this.ecx, this.field_45591, this.field_45590, null, this.field_48399, null, this.field_52154, this.method_72016(), this.field_62019, this.field_62020);
        FabricAddonsBridge.clearConfiguration();
        BotPlayHandler ehy2 = BotPlayHandler.create(this.field_45588, this.field_45589, class_86752, this.ecs);
        class_9127 class_91272 = class_9095.field_48173.method_68874(class_9129.method_56350((class_5455)class_68902));
        class_9127 class_91273 = class_9095.field_48172.method_68875(class_9129.method_56350((class_5455)class_68902), () -> true);
        class_2535 class_25352 = this.field_45589;
        ((BotConnection)class_25352).runInLoop(() -> {
            class_25352.method_56330(class_91272, (class_2547)ehy2);
            class_25352.method_10743((class_2596)class_8736.field_48700);
            class_25352.method_56329(class_91273);
        });
    }

    private class_5455.class_6890 eda() {
        if (this.ecw == null) {
            return this.ecv.method_56585(class_5912.field_49043, this.ecu, this.field_45589.method_10756());
        }
        try (class_6860 class_68602 = this.ecw.method_57046();){
            class_5455.class_6890 class_68902 = this.ecv.method_56585((class_5912)class_68602, this.ecu, this.field_45589.method_10756());
            return class_68902;
        }
    }

    public void method_52784(class_2720 class_27202) {
        this.ecs.packs.offer(class_27202, this.field_45589);
    }

    public void method_55512(class_9053 class_90532) {
    }

    public void method_56150(class_9151 class_91512) {
        this.field_45589.method_10747((class_2561)class_2561.method_43470((String)("Сервер перекинул на другой адрес: " + class_91512.comp_2240() + ":" + class_91512.comp_2241())));
    }

    public void method_71666(class_11407 class_114072) {
        this.ecs.chat.system("Сервер показал диалог - пропущен");
    }

    public void method_71665(class_11406 class_114062) {
    }

    public void method_18784() {
        super.method_18784();
        this.ecs.packs.tick(this.field_45589);
    }

    public void method_10839(class_9812 class_98122) {
        this.ecs.onDisconnected(class_98122.comp_2853());
    }

    public class_9812 method_60881(class_2561 class_25612, Throwable throwable) {
        return new class_9812(class_25612);
    }

    public void method_59807(class_2596 class_25962, Exception exception) {
        this.ecs.onPacketError(class_25962, exception);
    }

    private static /* synthetic */ int cv(int n, int n2) {
        return n - n2 ^ 0xA65696DD;
    }

    private static /* synthetic */ int cw(int n, int n2) {
        return BotConfigHandler.cv(n, n2) + n;
    }
}

