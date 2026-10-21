/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMultimap
 *  com.google.common.collect.Multimap
 *  com.mojang.authlib.GameProfile
 *  com.mojang.authlib.properties.Property
 *  com.mojang.authlib.properties.PropertyMap
 *  net.minecraft.class_1291
 *  net.minecraft.class_1293
 *  net.minecraft.class_1320
 *  net.minecraft.class_1322$class_1323
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_9635
 *  net.minecraft.class_1799
 *  net.minecraft.class_1836
 *  net.minecraft.class_1844
 *  net.minecraft.class_1887
 *  net.minecraft.class_1935
 *  net.minecraft.class_310
 *  net.minecraft.class_5321
 *  net.minecraft.class_6880
 *  net.minecraft.class_7924
 *  net.minecraft.class_9285
 *  net.minecraft.class_9285$class_9287
 *  net.minecraft.class_9296
 *  net.minecraft.class_9304
 *  net.minecraft.class_9334
 */
package a;

import a.elw;
import a.emc;
import a.emi;
import a.emo;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import flow.dev.StringDecryptor;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1320;
import net.minecraft.class_1322;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1836;
import net.minecraft.class_1844;
import net.minecraft.class_1887;
import net.minecraft.class_1935;
import net.minecraft.class_310;
import net.minecraft.class_5321;
import net.minecraft.class_6880;
import net.minecraft.class_7924;
import net.minecraft.class_9285;
import net.minecraft.class_9296;
import net.minecraft.class_9304;
import net.minecraft.class_9334;

public final class ItemRuleParser {
    private static final String[] emv;
    private static final String emw;
    private static final String emx;
    private static final double emy = 9.9999942618434E-4;
    private final String emz;
    private final class_1792 ena;
    private final List<elw> enb = new ArrayList<elw>();
    private final List<emi> enc = new ArrayList<emi>();
    private final List<emo> end = new ArrayList<emo>();
    private final List<emc> ene = new ArrayList<emc>();
    private int enf;
    private String eng;
    private static /* synthetic */ boolean enh;
    private static /* synthetic */ long eni;

    private ItemRuleParser(String string, class_1792 class_17922) {
        this.emz = string;
        this.ena = class_17922;
    }

    public static ItemRuleParser of(String string, class_1792 class_17922) {
        return new ItemRuleParser(string, class_17922);
    }

    public ItemRuleParser attr(class_6880<class_1320> class_68802, double d, class_1322.class_1323 class_13232) {
        this.enb.add(new elw(class_68802, d, class_13232));
        return this;
    }

    public ItemRuleParser flat(class_6880<class_1320> class_68802, double d) {
        return this.attr(class_68802, d, class_1322.class_1323.field_6328);
    }

    public ItemRuleParser scaled(class_6880<class_1320> class_68802, double d) {
        return this.attr(class_68802, d, class_1322.class_1323.field_6330);
    }

    public ItemRuleParser ench(class_5321<class_1887> class_53212, int n) {
        this.enc.add(new emi(class_53212, n, false));
        return this;
    }

    public ItemRuleParser denyEnch(class_5321<class_1887> class_53212) {
        this.enc.add(new emi(class_53212, 0, true));
        return this;
    }

    public ItemRuleParser lore(String string) {
        this.end.add(new emo(string, 0, false));
        return this;
    }

    public ItemRuleParser lore(String string, int n) {
        this.end.add(new emo(string, n, false));
        return this;
    }

    public ItemRuleParser denyLore(String string) {
        this.end.add(new emo(string, 0, true));
        return this;
    }

    public ItemRuleParser effect(class_6880<class_1291> class_68802, int n, int n2) {
        this.ene.add(new emc(class_68802, n, n2));
        return this;
    }

    public ItemRuleParser color(int n) {
        this.enf = n;
        return this;
    }

    public ItemRuleParser profile(String string) {
        this.eng = string;
        return this;
    }

    public String getName() {
        return this.emz;
    }

    public class_1792 getItem() {
        return this.ena;
    }

    public String getSearchQuery() {
        return this.emz.replaceAll("\\[\\d+x\\d+]", "").replace("⚡", "").replace("xxx", "").replace("[", "").replace("]", "").replace("★", "").trim().replaceAll("\\s+", " ");
    }

    public boolean matches(class_1799 class_17992) {
        return class_17992.method_31574(this.ena) && this.enj(class_17992) && this.enk(class_17992) && this.enl(class_17992) && this.enm(class_17992);
    }

    private boolean enj(class_1799 class_17992) {
        if (this.enb.isEmpty()) {
            return true;
        }
        class_9285 class_92852 = (class_9285)class_17992.method_58695(class_9334.field_49636, (Object)class_9285.field_49326);
        for (elw elw2 : this.enb) {
            boolean bl = false;
            for (class_9285.class_9287 class_92872 : class_92852.comp_2393()) {
                if (!class_92872.comp_2395().equals(elw2.attribute()) || !(Math.abs(class_92872.comp_2396().comp_2449() - elw2.amount()) < 9.9999942618434E-4) || class_92872.comp_2396().comp_2450() != elw2.operation()) continue;
                bl = true;
                break;
            }
            if (bl) continue;
            return false;
        }
        return true;
    }

    private boolean enk(class_1799 class_17992) {
        if (this.enc.isEmpty()) {
            return true;
        }
        class_310 class_3102 = class_310.method_1551();
        class_9304 class_93042 = (class_9304)class_17992.method_58695(class_9334.field_49633, (Object)class_9304.field_49385);
        for (emi emi2 : this.enc) {
            int n;
            if (class_3102.field_1687 == null) {
                if (emi2.deny()) continue;
                return false;
            }
            Optional optional = class_3102.field_1687.method_30349().method_30530(class_7924.field_41265).method_46746(emi2.key());
            int n2 = optional.map(arg_0 -> ((class_9304)class_93042).method_57536(arg_0)).orElse(0);
            int n3 = n = emi2.level() == 0 ? 1 : emi2.level();
            if (!(emi2.deny() ? n2 >= n : class_93042.method_57543() || n2 < n)) continue;
            return false;
        }
        return true;
    }

    private boolean enl(class_1799 class_17992) {
        String string;
        if (this.end.isEmpty()) {
            return true;
        }
        class_310 class_3102 = class_310.method_1551();
        try {
            string = class_17992.method_7950(class_1792.class_9635.field_51353, (class_1657)class_3102.field_1724, (class_1836)class_1836.field_41070).stream().skip(1L).map(class_25612 -> ItemRuleParser.normalize(class_25612.getString())).collect(Collectors.joining("\n"));
        }
        catch (RuntimeException runtimeException) {
            return false;
        }
        for (emo emo2 : this.end) {
            String string2 = ItemRuleParser.normalize(emo2.text());
            if (!(emo2.deny() ? string.contains(string2) : (emo2.level() == 0 ? !string.contains(string2) : ItemRuleParser.enn(string, string2) < emo2.level()))) continue;
            return false;
        }
        return true;
    }

    private boolean enm(class_1799 class_17992) {
        if (this.ene.isEmpty()) {
            return true;
        }
        class_1844 class_18442 = (class_1844)class_17992.method_58694(class_9334.field_49651);
        if (class_18442 == null) {
            return false;
        }
        for (emc emc2 : this.ene) {
            boolean bl = StreamSupport.stream(class_18442.method_57397().spliterator(), false).anyMatch(class_12932 -> class_12932.method_5579().equals(emc2.effect()) && class_12932.method_5578() + 1 == emc2.level() && class_12932.method_5584() >= emc2.duration());
            if (bl) continue;
            return false;
        }
        return StreamSupport.stream(class_18442.method_57397().spliterator(), false).count() == (long)this.ene.size();
    }

    public class_1799 buildStack() {
        GameProfile gameProfile;
        class_1799 class_17992 = new class_1799((class_1935)this.ena);
        if (this.enf != 0 && !this.ene.isEmpty()) {
            gameProfile = new ArrayList();
            for (emc emc2 : this.ene) {
                gameProfile.add(new class_1293(emc2.effect(), Math.max(1, emc2.duration()), Math.max(0, emc2.level() - 1)));
            }
            class_17992.method_57379(class_9334.field_49651, (Object)new class_1844(Optional.empty(), Optional.of(this.enf), gameProfile, Optional.empty()));
        }
        if (this.eng != null) {
            gameProfile = new GameProfile(UUID.nameUUIDFromBytes(this.eng.getBytes(StandardCharsets.UTF_8)), "c" + Math.abs(this.emz.hashCode() % 100000), new PropertyMap((Multimap)ImmutableMultimap.of((Object)"textures", (Object)new Property("textures", this.eng))));
            class_17992.method_57379(class_9334.field_49617, (Object)class_9296.method_73307((GameProfile)gameProfile));
        }
        return class_17992;
    }

    static String normalize(String string) {
        if (string == null) {
            return "";
        }
        return string.replaceAll("§.", "").toLowerCase(Locale.ROOT).replaceAll("\\s+", "").trim();
    }

    private static int enn(String string, String string2) {
        if (string.isEmpty() || string2.isEmpty()) {
            return 0;
        }
        int n = 0;
        int n2 = string.indexOf(string2);
        while (n2 >= 0) {
            n = Math.max(n, Math.max(1, ItemRuleParser.eno(string, n2 + string2.length())));
            n2 = string.indexOf(string2, n2 + string2.length());
        }
        return n;
    }

    private static int eno(String string, int n) {
        int n2;
        for (n2 = n; n2 < string.length() && ":.-–—·»>|=".indexOf(string.charAt(n2)) >= 0; ++n2) {
        }
        int n3 = n2;
        while (n2 < string.length() && "ivx0123456789".indexOf(string.charAt(n2)) >= 0) {
            ++n2;
        }
        return n2 == n3 ? 0 : ItemRuleParser.enp(string.substring(n3, n2));
    }

    private static int enp(String string) {
        int n;
        if (string == null || string.isBlank()) {
            return 0;
        }
        String string2 = ItemRuleParser.normalize(string);
        for (int i = 0; i < emv.length; ++i) {
            if (!string2.equals(emv[i])) continue;
            return i + 1;
        }
        String string3 = string2.replaceAll("[^0-9]", "");
        if (!string3.isEmpty()) {
            try {
                n = Integer.parseInt(string3);
                if (n >= 1 && n <= 10) {
                    return n;
                }
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
        }
        for (n = emv.length - 1; n >= 0; --n) {
            if (!string2.contains(emv[n])) continue;
            return n + 1;
        }
        return 0;
    }

    static {
        emw = "ivx0123456789";
        emx = ":.-–—·»>|=";
        emv = new String[]{"i", "ii", "iii", "iv", "v", "vi", "SvgPathParser", "viii", "ix", "x"};
    }

    private static /* synthetic */ int ia(int n, int n2) {
        return n ^ n2 ^ 0xBB3EA316;
    }

    private static /* synthetic */ int ib(int n, int n2) {
        return n * n2 | 0xCA8E8BBD;
    }

    private static /* synthetic */ int ic(int n, int n2) {
        return ItemRuleParser.ia(n, n2) * n2;
    }
}

