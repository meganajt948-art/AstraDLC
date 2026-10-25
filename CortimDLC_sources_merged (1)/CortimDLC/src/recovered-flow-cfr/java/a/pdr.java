/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMultimap
 *  com.google.common.collect.Multimap
 *  com.mojang.authlib.GameProfile
 *  com.mojang.authlib.properties.Property
 *  com.mojang.authlib.properties.PropertyMap
 *  net.minecraft.component.DataComponentTypes
 *  net.minecraft.component.type.PotionContentsComponent
 *  net.minecraft.component.type.ProfileComponent
 *  net.minecraft.entity.effect.StatusEffectInstance
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 */
package a;

import a.pey;
import a.phj;
import a.phm;
import a.pia;
import a.pig;
import a.pim;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import flow.dev.a;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.component.type.ProfileComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public final class pdr {
    private final Item pds;
    private final String pdt;
    private final int pdu;
    private String pdv;
    private boolean pdw = true;
    private boolean pdx;
    private int pdy;
    private String pdz;
    private final List<phm> pea = new ArrayList<phm>();
    private final List<pia> peb = new ArrayList<pia>();
    private final List<pig> pec = new ArrayList<pig>();
    private boolean ped;
    private int pee;
    private ItemStack pef;
    private static /* synthetic */ int peg;
    private static /* synthetic */ long peh;

    private pdr(Item item, int n, String string) {
        this.pds = item;
        this.pdt = string;
        this.pdu = n;
        this.pee = n;
    }

    public static pdr of(Item item, int n, String string) {
        return new pdr(item, n, string);
    }

    public pdr query(String string) {
        this.pdv = string;
        return this;
    }

    public pdr off() {
        this.pdw = false;
        return this;
    }

    public pdr deep() {
        this.pdx = true;
        return this;
    }

    public pdr color(int n) {
        this.pdy = n;
        return this;
    }

    public pdr skin(String string) {
        this.pdz = string;
        return this;
    }

    public pdr rules(phm ... phmArray) {
        this.pea.addAll(Arrays.asList(phmArray));
        return this;
    }

    public pdr attrs(pia ... piaArray) {
        this.peb.addAll(Arrays.asList(piaArray));
        return this;
    }

    public pdr effects(pig ... pigArray) {
        this.pec.addAll(Arrays.asList(pigArray));
        return this;
    }

    pdr init() {
        this.ped = this.pdw;
        return this;
    }

    public Item item() {
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

    public List<phm> rules() {
        return this.pea;
    }

    public List<phm> shownRules() {
        ArrayList<phm> arrayList = new ArrayList<phm>();
        for (phm phm2 : this.pea) {
            if (phm2.state() == phj.DENY && !phm2.hasLevel() && pdr.pei(phm2)) continue;
            arrayList.add(phm2);
        }
        return arrayList;
    }

    private static boolean pei(phm phm2) {
        String string = phm2.key();
        return string.equals(a.d("\u49ee\u307e\ubaac\u24a2\uaf7e\u29b7\u9394\u1a1b", -532829695, -1318197256)) || string.equals(a.b("\u3f37\u46ae\ucc09\u527b\ud9de\u5f6e\ue534\u6cc6\uf2ee\u782e\uff8b\u0588\u8f46", 1551252263)) || string.equals(a.d("\u2d25\u5490\ude44\u403e\ucbef\u4d4f\uf70f\u7ef9\ue0b4\u6a4b\uedd6\u17bb\u996b\u00c7\u8a88\u0c64", 1462260902, 1758624254)) || string.equals(a.d("\u7a17\u03a2\u8976\u170c\u9cdd\u1a7d\ua03d\u29cb\ub786\u3d79\ubafb\u408f\uce59\u57e4\uddbf\u5b47\ue10b\u6ed8\uf463", 519287640, -1057568463)) || string.equals(a.d("\u15d6\u6c63\ue6b7\u78cd\uf31c\u75bc\ucffc\u460a\ud847\u52b8\ud533\u2f49\ua199\u3822\ub27c\u348a\u8ecc\u0125\u9baa\u1ded\u941d\uee4d\u60e8", 972903649, -342015667)) || string.equals(a.b("\uc2fd\ubb48\u319c\uafe6\u2437\ua297\u18d7\u9121\u0f6c\u8593\u020c\uf86a\u76b2\uef04\u654d\ue3a7\u59e9\ud63f\u4c85\ucaec\u4327\u3960\ub7d4\u2c04\uaa6d", -1063665015));
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
        return this.pds == Items.POTION || this.pds == Items.SPLASH_POTION || this.pds == Items.LINGERING_POTION;
    }

    public boolean stackable() {
        return this.peb.isEmpty() && (this.pds.getMaxCount() > 1 || this.pds == Items.TOTEM_OF_UNDYING || this.isPotion());
    }

    public int maxCount() {
        if (!this.stackable()) {
            return 1;
        }
        if (this.pds == Items.POTION) {
            return 16;
        }
        if (this.pds == Items.TOTEM_OF_UNDYING || this.isPotion()) {
            return 6;
        }
        return this.pds.getMaxCount();
    }

    public boolean changed() {
        if (this.ped != this.pdw || this.pee != this.pdu) {
            return true;
        }
        for (phm phm2 : this.pea) {
            if (!phm2.changed()) continue;
            return true;
        }
        return false;
    }

    public void reset() {
        this.ped = this.pdw;
        this.pee = this.pdu;
        for (phm phm2 : this.pea) {
            phm2.reset();
        }
    }

    public boolean matches(ItemStack itemStack) {
        return this.matches(itemStack, new pey(itemStack));
    }

    public boolean matches(ItemStack itemStack, pey pey2) {
        if (!itemStack.isOf(this.pds)) {
            return false;
        }
        if (!this.peb.isEmpty() && !pim.attrs(itemStack, this.peb)) {
            return false;
        }
        if (!this.pec.isEmpty() && !pim.effects(itemStack, this.pec)) {
            return false;
        }
        for (phm phm2 : this.pea) {
            if (phm2.matches(itemStack, pey2)) continue;
            return false;
        }
        return true;
    }

    public ItemStack icon() {
        if (this.pef == null) {
            GameProfile gameProfile;
            ItemStack itemStack = new ItemStack((ItemConvertible)this.pds);
            if (this.pdz != null) {
                gameProfile = new GameProfile(UUID.nameUUIDFromBytes(this.pdz.getBytes(StandardCharsets.UTF_8)), a.d("\u3ce1", -79550546, 1747458861) + Math.abs(this.pdt.hashCode() % 100000), new PropertyMap((Multimap)ImmutableMultimap.of((Object)a.b("\u546e\u2dce\ua700\u397d\ub2ab\u341d\u8e59\u07be", 2066895890), (Object)new Property(a.b("\u15b8\u6c18\ue6d6\u78ab\uf37d\u75cb\ucf8f\u4668", -399305276), this.pdz))));
                itemStack.set(DataComponentTypes.PROFILE, (Object)ProfileComponent.ofStatic((GameProfile)gameProfile));
            }
            if (this.pdy != 0) {
                gameProfile = new ArrayList();
                for (pig pig2 : this.pec) {
                    gameProfile.add(new StatusEffectInstance(pig2.effect(), Math.max(1, pig2.duration()), Math.max(0, pig2.level() - 1)));
                }
                itemStack.set(DataComponentTypes.POTION_CONTENTS, (Object)new PotionContentsComponent(Optional.empty(), Optional.of(this.pdy), gameProfile, Optional.empty()));
            }
            this.pef = itemStack;
        }
        return this.pef;
    }

    public String searchText() {
        return (this.pdt + a.c(-1393256477, "\u97c2") + this.query()).toLowerCase(Locale.ROOT);
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

