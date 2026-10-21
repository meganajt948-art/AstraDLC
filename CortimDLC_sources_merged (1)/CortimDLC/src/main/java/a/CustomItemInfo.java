/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMultimap
 *  com.google.common.collect.Multimap
 *  com.mojang.authlib.GameProfile
 *  com.mojang.authlib.properties.Property
 *  com.mojang.authlib.properties.PropertyMap
 *  net.minecraft.class_1293
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1844
 *  net.minecraft.class_1935
 *  net.minecraft.class_9296
 *  net.minecraft.class_9334
 */
package a;

import a.ItemSnapshot;
import a.phj;
import a.ItemRule;
import a.pia;
import a.pig;
import a.ModifierFactory;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import flow.dev.StringDecryptor;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import net.minecraft.class_1293;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1844;
import net.minecraft.class_1935;
import net.minecraft.class_9296;
import net.minecraft.class_9334;

public final class CustomItemInfo {
    private final class_1792 pds;
    private final String pdt;
    private final int pdu;
    private String pdv;
    private boolean pdw = true;
    private boolean pdx;
    private int pdy;
    private String pdz;
    private final List<ItemRule> pea = new ArrayList<ItemRule>();
    private final List<pia> peb = new ArrayList<pia>();
    private final List<pig> pec = new ArrayList<pig>();
    private boolean ped;
    private int pee;
    private class_1799 pef;
    private static /* synthetic */ int peg;
    private static /* synthetic */ long peh;

    private CustomItemInfo(class_1792 class_17922, int n, String string) {
        this.pds = class_17922;
        this.pdt = string;
        this.pdu = n;
        this.pee = n;
    }

    public static CustomItemInfo of(class_1792 class_17922, int n, String string) {
        return new CustomItemInfo(class_17922, n, string);
    }

    public CustomItemInfo query(String string) {
        this.pdv = string;
        return this;
    }

    public CustomItemInfo off() {
        this.pdw = false;
        return this;
    }

    public CustomItemInfo deep() {
        this.pdx = true;
        return this;
    }

    public CustomItemInfo color(int n) {
        this.pdy = n;
        return this;
    }

    public CustomItemInfo skin(String string) {
        this.pdz = string;
        return this;
    }

    public CustomItemInfo rules(ItemRule ... phmArray) {
        this.pea.addAll(Arrays.asList(phmArray));
        return this;
    }

    public CustomItemInfo attrs(pia ... piaArray) {
        this.peb.addAll(Arrays.asList(piaArray));
        return this;
    }

    public CustomItemInfo effects(pig ... pigArray) {
        this.pec.addAll(Arrays.asList(pigArray));
        return this;
    }

    CustomItemInfo init() {
        this.ped = this.pdw;
        return this;
    }

    public class_1792 item() {
        return this.pds;
    }

    public String name() {
        return this.pdt;
    }

    public String query() {
        return this.pdv == null ? this.pdt : this.pdv;
    }

    public boolean hasQuery() {
        return this.pdv != null;
    }

    public boolean deepScan() {
        return this.pdx;
    }

    public boolean active() {
        return this.ped;
    }

    public void setActive(boolean bl) {
        this.ped = bl;
    }

    public int count() {
        return this.pee;
    }

    public void setCount(int n) {
        this.pee = Math.max(1, Math.min(this.maxCount(), n));
    }

    public List<ItemRule> rules() {
        return this.pea;
    }

    public List<ItemRule> shownRules() {
        ArrayList<ItemRule> arrayList = new ArrayList<ItemRule>();
        for (ItemRule phm2 : this.pea) {
            if (phm2.state() == phj.DENY && !phm2.hasLevel() && CustomItemInfo.pei(phm2)) continue;
            arrayList.add(phm2);
        }
        return arrayList;
    }

    private static boolean pei(ItemRule phm2) {
        String string = phm2.key();
        return string.equals("Попрыгун") || string.equals("Нестабильный ") || string.equals("minecraft:thorns") || string.equals("minecraft:knockback") || string.equals("minecraft:binding_curse") || string.equals("minecraft:vanishing_curse");
    }

    public boolean hasAttrs() {
        return !this.peb.isEmpty();
    }

    public List<pig> effects() {
        return this.pec;
    }

    public boolean hasEffects() {
        return !this.pec.isEmpty();
    }

    public boolean isPotion() {
        return this.pds == class_1802.field_8574 || this.pds == class_1802.field_8436 || this.pds == class_1802.field_8150;
    }

    public boolean stackable() {
        return this.peb.isEmpty() && (this.pds.method_7882() > 1 || this.pds == class_1802.field_8288 || this.isPotion());
    }

    public int maxCount() {
        if (!this.stackable()) {
            return 1;
        }
        if (this.pds == class_1802.field_8574) {
            return 16;
        }
        if (this.pds == class_1802.field_8288 || this.isPotion()) {
            return 6;
        }
        return this.pds.method_7882();
    }

    public boolean changed() {
        if (this.ped != this.pdw || this.pee != this.pdu) {
            return true;
        }
        for (ItemRule phm2 : this.pea) {
            if (!phm2.changed()) continue;
            return true;
        }
        return false;
    }

    public void reset() {
        this.ped = this.pdw;
        this.pee = this.pdu;
        for (ItemRule phm2 : this.pea) {
            phm2.reset();
        }
    }

    public boolean matches(class_1799 class_17992) {
        return this.matches(class_17992, new ItemSnapshot(class_17992));
    }

    public boolean matches(class_1799 class_17992, ItemSnapshot pey2) {
        if (!class_17992.method_31574(this.pds)) {
            return false;
        }
        if (!this.peb.isEmpty() && !ModifierFactory.attrs(class_17992, this.peb)) {
            return false;
        }
        if (!this.pec.isEmpty() && !ModifierFactory.effects(class_17992, this.pec)) {
            return false;
        }
        for (ItemRule phm2 : this.pea) {
            if (phm2.matches(class_17992, pey2)) continue;
            return false;
        }
        return true;
    }

    public class_1799 icon() {
        if (this.pef == null) {
            GameProfile gameProfile;
            class_1799 class_17992 = new class_1799((class_1935)this.pds);
            if (this.pdz != null) {
                gameProfile = new GameProfile(UUID.nameUUIDFromBytes(this.pdz.getBytes(StandardCharsets.UTF_8)), "c" + Math.abs(this.pdt.hashCode() % 100000), new PropertyMap((Multimap)ImmutableMultimap.of((Object)"textures", (Object)new Property("textures", this.pdz))));
                class_17992.method_57379(class_9334.field_49617, (Object)class_9296.method_73307((GameProfile)gameProfile));
            }
            if (this.pdy != 0) {
                gameProfile = new ArrayList();
                for (pig pig2 : this.pec) {
                    gameProfile.add(new class_1293(pig2.effect(), Math.max(1, pig2.duration()), Math.max(0, pig2.level() - 1)));
                }
                class_17992.method_57379(class_9334.field_49651, (Object)new class_1844(Optional.empty(), Optional.of(this.pdy), gameProfile, Optional.empty()));
            }
            this.pef = class_17992;
        }
        return this.pef;
    }

    public String searchText() {
        return (this.pdt + " " + this.query()).toLowerCase(Locale.ROOT);
    }

    private static /* synthetic */ int bhg(int n, int n2) {
        return n ^ n2 | 0xAF946FAF;
    }

    private static /* synthetic */ int bhh(int n, int n2) {
        return n * n2 | 0xE091F432;
    }

    private static /* synthetic */ int bhi(int n, int n2) {
        return n + n2 + 1359796126;
    }
}

