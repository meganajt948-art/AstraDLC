package a;

import com.google.common.collect.ImmutableMultimap;
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
   private final List<phm> pea = new ArrayList<>();
   private final List<pia> peb = new ArrayList<>();
   private final List<pig> pec = new ArrayList<>();
   private boolean ped;
   private int pee;
   private ItemStack pef;

   private pdr(Item var1, int var2, String var3) {
      this.pds = var1;
      this.pdt = var3;
      this.pdu = var2;
      this.pee = var2;
   }

   public static pdr of(Item var0, int var1, String var2) {
      return new pdr(var0, var1, var2);
   }

   public pdr query(String var1) {
      this.pdv = var1;
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

   public pdr color(int var1) {
      this.pdy = var1;
      return this;
   }

   public pdr skin(String var1) {
      this.pdz = var1;
      return this;
   }

   public pdr rules(phm... var1) {
      this.pea.addAll(Arrays.asList(var1));
      return this;
   }

   public pdr attrs(pia... var1) {
      this.peb.addAll(Arrays.asList(var1));
      return this;
   }

   public pdr effects(pig... var1) {
      this.pec.addAll(Arrays.asList(var1));
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

   public void setActive(boolean var1) {
      this.ped = var1;
   }

   public int count() {
      return this.pee;
   }

   public void setCount(int var1) {
      this.pee = Math.max(1, Math.min(this.maxCount(), var1));
   }

   public List<phm> rules() {
      return this.pea;
   }

   public List<phm> shownRules() {
      ArrayList var1 = new ArrayList();

      for (phm var3 : this.pea) {
         if (var3.state() != phj.DENY || var3.hasLevel() || !pei(var3)) {
            var1.add(var3);
         }
      }

      return var1;
   }

   private static boolean pei(phm var0) {
      String var1 = var0.key();
      return var1.equals(a.d("䧮ま몬⒢꽾⦷鎔ᨛ", -532829695, -1318197256))
         || var1.equals(a.b("㼷䚮찉剻\ud9de彮\ue534泆\uf2ee砮ﾋֈ轆", 1551252263))
         || var1.equals(a.d("ⴥ咐\ude44䀾쯯䵏\uf70f绹\ue0b4橋\uedd6ុ饫Ç誈\u0c64", 1462260902, 1758624254))
         || var1.equals(a.d("稗\u03a2襶ᜌ鳝\u1a7dꀽ⧋랆㵹뫻䂏칙埤\uddbf孇\ue10b滘\uf463", 519287640, -1057568463))
         || var1.equals(a.d("ᗖ汣\ue6b7磍\uf31c疼쿼䘊\ud847劸픳⽉ꆙ㠢뉼㒊軌ĥ鮪ᷭ鐝\uee4d惨", 972903649, -342015667))
         || var1.equals(a.b("싽뭈㆜꿦\u2437ꊗᣗ鄡ཬ薓Ȍ\uf86a皲\uef04敍\ue3a7姩혿䲅쫬䌧㥠럔Ⰴꩭ", -1063665015));
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
      } else if (this.pds == Items.POTION) {
         return 16;
      } else {
         return this.pds != Items.TOTEM_OF_UNDYING && !this.isPotion() ? this.pds.getMaxCount() : 6;
      }
   }

   public boolean changed() {
      if (this.ped == this.pdw && this.pee == this.pdu) {
         for (phm var2 : this.pea) {
            if (var2.changed()) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }

   public void reset() {
      this.ped = this.pdw;
      this.pee = this.pdu;

      for (phm var2 : this.pea) {
         var2.reset();
      }
   }

   public boolean matches(ItemStack var1) {
      return this.matches(var1, new pey(var1));
   }

   public boolean matches(ItemStack var1, pey var2) {
      if (!var1.isOf(this.pds)) {
         return false;
      }

      if (!this.peb.isEmpty() && !pim.attrs(var1, this.peb)) {
         return false;
      }

      if (!this.pec.isEmpty() && !pim.effects(var1, this.pec)) {
         return false;
      }

      for (phm var4 : this.pea) {
         if (!var4.matches(var1, var2)) {
            return false;
         }
      }

      return true;
   }

   public ItemStack icon() {
      if (this.pef == null) {
         ItemStack var1 = new ItemStack(this.pds);
         if (this.pdz != null) {
            GameProfile var2 = new GameProfile(
               UUID.nameUUIDFromBytes(this.pdz.getBytes(StandardCharsets.UTF_8)),
               a.d("㳡", -79550546, 1747458861) + Math.abs(this.pdt.hashCode() % 100000),
               new PropertyMap(ImmutableMultimap.of(a.b("呮ⷎ꜀㥽늫㐝蹙\u07be", 2066895890), new Property(a.b("ᖸ氘\ue6d6碫\uf37d痋쾏䙨", -399305276), this.pdz)))
            );
            var1.set(DataComponentTypes.PROFILE, ProfileComponent.ofStatic(var2));
         }

         if (this.pdy != 0) {
            ArrayList var5 = new ArrayList();

            for (pig var4 : this.pec) {
               var5.add(new StatusEffectInstance(var4.effect(), Math.max(1, var4.duration()), Math.max(0, var4.level() - 1)));
            }

            var1.set(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Optional.empty(), Optional.of(this.pdy), var5, Optional.empty()));
         }

         this.pef = var1;
      }

      return this.pef;
   }

   public String searchText() {
      return (this.pdt + a.c(-1393256477, "韂") + this.query()).toLowerCase(Locale.ROOT);
   }
}
