/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_11653
 *  net.minecraft.class_2535
 *  net.minecraft.class_2547
 *  net.minecraft.class_2561
 *  net.minecraft.class_2596
 *  net.minecraft.class_2803
 *  net.minecraft.class_2817
 *  net.minecraft.class_2896
 *  net.minecraft.class_2899
 *  net.minecraft.class_2901
 *  net.minecraft.class_2905
 *  net.minecraft.class_2907
 *  net.minecraft.class_2909
 *  net.minecraft.class_2913
 *  net.minecraft.class_2917
 *  net.minecraft.class_310
 *  net.minecraft.class_3515
 *  net.minecraft.class_5455$class_6890
 *  net.minecraft.class_7648
 *  net.minecraft.class_7701
 *  net.minecraft.class_7756
 *  net.minecraft.class_7965
 *  net.minecraft.class_7975
 *  net.minecraft.class_8593
 *  net.minecraft.class_8675
 *  net.minecraft.class_8709
 *  net.minecraft.class_8710
 *  net.minecraft.class_9088
 *  net.minecraft.class_9091
 *  net.minecraft.class_9157
 *  net.minecraft.class_9782
 *  net.minecraft.class_9812
 *  net.minecraft.client.ClientBrandRetriever
 */
package a;

import a.Bot;
import a.BotConfigHandler;
import com.mojang.authlib.GameProfile;
import flow.dev.StringDecryptor;
import java.security.Key;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import net.minecraft.class_11653;
import net.minecraft.class_2535;
import net.minecraft.class_2547;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_2803;
import net.minecraft.class_2817;
import net.minecraft.class_2896;
import net.minecraft.class_2899;
import net.minecraft.class_2901;
import net.minecraft.class_2905;
import net.minecraft.class_2907;
import net.minecraft.class_2909;
import net.minecraft.class_2913;
import net.minecraft.class_2917;
import net.minecraft.class_310;
import net.minecraft.class_3515;
import net.minecraft.class_5455;
import net.minecraft.class_7648;
import net.minecraft.class_7701;
import net.minecraft.class_7756;
import net.minecraft.class_7965;
import net.minecraft.class_7975;
import net.minecraft.class_8593;
import net.minecraft.class_8675;
import net.minecraft.class_8709;
import net.minecraft.class_8710;
import net.minecraft.class_9088;
import net.minecraft.class_9091;
import net.minecraft.class_9157;
import net.minecraft.class_9782;
import net.minecraft.class_9812;
import net.minecraft.client.ClientBrandRetriever;

final class BotLoginHandler
implements class_2896 {
    private final Bot egg;
    private final class_2535 egh;
    private final class_310 egi = class_310.method_1551();
    private static /* synthetic */ int egj;
    private static /* synthetic */ String egk;

    BotLoginHandler(Bot dtv2, class_2535 class_25352) {
        this.egg = dtv2;
        this.egh = class_25352;
    }

    public void method_12587(class_2905 class_29052) {
        if (class_29052.method_56013()) {
            this.egh.method_10747((class_2561)class_2561.method_43470((String)"Сервер требует лицензионный аккаунт"));
            return;
        }
        try {
            SecretKey secretKey = class_3515.method_15239();
            PublicKey publicKey = class_29052.method_12611();
            Cipher cipher = class_3515.method_15235((int)2, (Key)secretKey);
            Cipher cipher2 = class_3515.method_15235((int)1, (Key)secretKey);
            class_2917 class_29172 = new class_2917(secretKey, publicKey, class_29052.method_12613());
            this.egh.method_10752((class_2596)class_29172, class_7648.method_45084(() -> this.egh.method_10746(cipher, cipher2)));
        }
        catch (Exception exception) {
            this.egh.method_10747((class_2561)class_2561.method_43470((String)"Ошибка шифрования"));
        }
    }

    public void method_12588(class_2901 class_29012) {
        GameProfile gameProfile = class_29012.comp_2363();
        class_7975 class_79752 = new class_7975(class_7965.field_41434, false, null, null);
        class_5455.class_6890 class_68902 = class_7756.method_45738().method_45926();
        HashMap hashMap = new HashMap();
        class_8675 class_86752 = new class_8675(new class_11653(), gameProfile, class_79752, class_68902, class_7701.field_40183, null, this.egg.serverInfo(), null, hashMap, null, Map.of(), class_9782.field_51977, new HashMap(), false);
        this.egh.method_56330(class_9157.field_48699, (class_2547)BotConfigHandler.create(this.egi, this.egh, class_86752, this.egg, gameProfile, class_68902));
        this.egh.method_10743((class_2596)class_8593.field_48252);
        this.egh.method_56329(class_9157.field_48698);
        this.egh.method_10743((class_2596)new class_2817((class_8710)new class_8709(ClientBrandRetriever.getClientModName())));
        this.egh.method_10743((class_2596)new class_2803(this.egg.syncedOptions()));
        this.egg.onLoginSuccess(gameProfile);
    }

    public void method_12584(class_2909 class_29092) {
        this.egh.method_10747(class_29092.comp_4195());
    }

    public void method_12585(class_2907 class_29072) {
        if (!this.egh.method_10756()) {
            this.egh.method_10760(class_29072.method_12634(), false);
        }
    }

    public void method_12586(class_2899 class_28992) {
        this.egh.method_10743((class_2596)new class_2913(class_28992.comp_1567(), null));
    }

    public void method_55845(class_9088 class_90882) {
        this.egh.method_10743((class_2596)new class_9091(class_90882.comp_2194(), null));
    }

    public void method_10839(class_9812 class_98122) {
        this.egg.onDisconnected(class_98122.comp_2853());
    }

    public boolean method_48106() {
        return this.egh.method_10758();
    }

    private static /* synthetic */ int ds(int n, int n2) {
        return (n ^ n2) + 2145155849;
    }
}

