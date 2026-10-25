/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.PlayerInventory
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.text.Text
 */
package a;

import a.pfl;
import a.pjd;
import a.pof;
import flow.dev.a;
import java.util.function.Consumer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;

public final class poi {
    private static final long poj = 1500L;
    private static final int pok = 9;
    private static final EquipmentSlot[] pol = new EquipmentSlot[]{EquipmentSlot.field_6169, EquipmentSlot.field_6174, EquipmentSlot.field_6172, EquipmentSlot.field_6166};
    private static final long pom = 1000L;
    private static final long pon = 15000L;
    private static final int poo = 3;
    private static final long pop = 4000L;
    private static final long poq = 30000L;
    private pof por = pof.NONE;
    private long pos;
    private long pot;
    private long pou;
    private long pov;
    private int pow;
    private String pox = "";
    private boolean poy;
    private boolean poz;
    private boolean ppa;
    private Object ppb;
    private boolean ppc;
    private String ppd = "";
    private Consumer<String> ppe = string -> {};
    private static /* synthetic */ String ppf;
    private static /* synthetic */ long ppg;

    public void notes(Consumer<String> consumer) {
        this.ppe = consumer;
    }

    public static boolean inLobby(PlayerEntity playerEntity) {
        PlayerInventory playerInventory = playerEntity.method_31548();
        boolean bl = playerEntity.method_6079().method_31574(Items.field_8251);
        int n = playerEntity.method_6079().method_7960() ? 0 : 1;
        for (int i = 0; i < 36; ++i) {
            ItemStack itemStack = playerInventory.method_5438(i);
            if (itemStack.method_7960()) continue;
            ++n;
            bl |= itemStack.method_31574(Items.field_8251);
        }
        if (!bl) {
            return false;
        }
        for (EquipmentSlot equipmentSlot : pol) {
            if (playerEntity.method_6118(equipmentSlot).method_7960()) continue;
            ++n;
        }
        return n <= 9;
    }

    public boolean active() {
        return this.por != pof.NONE;
    }

    public String status() {
        return this.por == pof.NONE ? "" : this.ppd;
    }

    public boolean takeReturned() {
        boolean bl = this.poy;
        this.poy = false;
        return bl;
    }

    public String target() {
        return this.pox;
    }

    public void reset(Object object) {
        if (this.por == pof.WAIT && object != null) {
            pjd.cancel(object);
        }
        this.por = pof.NONE;
        this.pos = 0L;
        this.poy = false;
        this.poz = false;
        this.ppa = false;
        this.ppc = false;
        this.ppd = "";
    }

    public void onChat(Text text) {
        if (text == null || this.por != pof.HOP) {
            return;
        }
        String string = pfl.title(text.getString());
        if (string.contains(a.c(338120793, "\u5419\u2ddd\ua70d")) && (string.contains(a.b("\u72c5\u0b00\u81a6\u1fa5\u9475\u12b1", 1730311810)) || string.contains(a.d("\ucedf\ub76f\u3db6\ua3c9\u281f\uaedb\u1481", -208382017, 2071960920)) || string.contains(a.c(678453728, "\u65da\u1c66\u96c0\u08ca\u8317\u05aa\ubf83"))) || string.contains(a.d("\u9a9a\ue326\u69eb\uf78d\u7c5e\ufaea\u40a4\uc90c\u5710\uddad\u5a7f\ua00e\u2ed2\ub765\u3d21\ubbc1\u018f", -1334311888, -2130141478))) {
            this.ppa = true;
            this.ppb = MinecraftClient.method_1551().field_1687;
        } else if (string.contains(a.b("\u1a1e\u63a7\ue975\u770e\ufca6\u7a14\uc046\u49cb", -638509525)) || string.contains(a.b("\uc7d5\ube6c\u30aa\uaab8\u2118\ua7ad\u1df5\u9401\u0a21\u809d\u0322\ufd4c\u739a\uea21\u607c\ue68c\u5cb6\ud36e", -799161350)) || string.contains(a.d("\ud5c8\uac78\u26b0\ub895\u3303\ub5a5\u0fe1\u8618\u1842\u92fe\u152e\uef51\u618f", 1422492475, 1200182928)) || string.contains(a.b("\u8cf0\uf54b\u7fed\ue1e9\u6a34\uec84\u56d2\udf25\u4172\ucbcb", -383285051)) || string.contains(a.c(1600547158, "\u6d63\u14d8\u9e7ez\u8baf\u0d19\ub749\u3ecb\ua097\u2a53"))) {
            this.poz = true;
        }
    }

    public boolean tick(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, Object object, String string, long l) {
        String string2;
        if (clientPlayerEntity == null || minecraftClient.method_1562() == null) {
            return false;
        }
        if (!poi.inLobby((PlayerEntity)clientPlayerEntity)) {
            if (this.por == pof.HOP) {
                this.poy = true;
                pjd.at(object, this.pox);
                this.ppe.accept(a.d("\u40e7\u390f\ub3df\u2dd3\ua60a\u24a0\u9aeb\u1315\u895d\u07f7\u8021\u7a5f\uf488\u6d30\ue37b\u6197\udbd5\u5014\ucec6\u48ec\uc11a\ubb40\u35f7\uaa32", 1689199579, -123181258) + this.pox);
            } else if (this.por == pof.WAIT) {
                pjd.cancel(object);
            }
            this.por = pof.NONE;
            this.pos = 0L;
            this.ppa = false;
            this.ppc = false;
            this.ppd = "";
            return false;
        }
        if (this.ppa && minecraftClient.field_1687 != this.ppb) {
            this.ppa = false;
        }
        if (this.ppa) {
            if (this.por != pof.NONE) {
                this.ppe.accept(a.c(218653959, "\u6132\u18a7\u9276\u0c04\u87dc\u011c\ubf2e\u32cd\ua880\u2629\ua1ff\u5b81\ud551\u4ce8\uc6c4\u4047\ufa78\u75dc\ueb76\u6d2b\ue0c1\u9a93\u103e\u8f82\u09f2\u835f\u3ef2\ub4be\u2e41\uac05\u23ad\udd79\u5739\ucec8\u4892\uc63b\u59d8\uf39d\u7151\ue89f\u62be\u1c45\u961c\u11a8\u8b72\u0505\ubca8"));
                pjd.at(object, this.pox);
                this.por = pof.NONE;
            }
            return false;
        }
        if (this.pos == 0L) {
            this.pos = l;
        }
        if ((string2 = pjd.key(string)).isEmpty() || !string2.chars().allMatch(Character::isDigit)) {
            if (!this.ppc && l - this.pos >= 1500L) {
                this.ppc = true;
                this.ppe.accept(a.b("\u6e05\u1386\u9d4e\u033a\u88e2\u0e53\ub409\u39e0\ua7b7\u2914\uaec3\u54b0\uda64\u43da\uc9f8\u4b68\uf535\u7ef6\ue024\u660f\ueffd\u95d0\u1b11\u80b5\u02a6\u8872\u31cd\ubb81\u2175\ua33a\u2c99\ud245\u580d\uc1f6\u43b5\ucd65\u72c9\uf8b9\u7e61\ue7d4\u6d8f\u176e\u9920\u1e99\u805b\u0a3d\ub3e9\u395c\ubf17\u24cb\uaab5", 565602852));
            }
            return false;
        }
        if (this.por == pof.NONE && l - this.pos < 1500L) {
            return true;
        }
        if (this.por == pof.NONE) {
            this.por = pof.WAIT;
            this.pot = l;
            this.pox = string2;
            this.pou = 0L;
            this.pov = 0L;
            this.pow = 0;
            pjd.leave(object);
            this.ppe.accept(a.c(109342932, "\u74ef\u096c\u87a4\u19d0\u9208\u14b9\uaee3\u230a\ubd5d\u33fe\ub429\u4e5a\uc08e\u5930\ud312\u5182\uefdf\u641c\uface\u7ce5\uf517\u8f3a\u01fb\u9a5f\u184c\u9294\u0b13\ua576\u3b99\ubdc4\u3600\uccb2\u42e0\udb1c\u595f\ud78f\u6823\ue253\u648b\ufd3e\u7375") + string2);
        }
        switch (this.por.ordinal()) {
            case 1: {
                if (l < this.pov) {
                    this.ppd = a.b("\ub8f2\uc166\u4bba\ud5cb\u5e15\udca6\u66ef\ueb7f\u755b\uffeb\u7833\u8246\u0885", -1135559452) + this.pox + a.d("\u438d\u3e21\ub4fa\u2e9e\ua156\u279b\u9dca\u1440\u8a15\u00a1\u8705\u791a\uf7c1\u6a6f\ue03d\u66c0\udcff\u5352\uc99f\u4bae\uc63e\ubc1d\u32db\ua97f\u2f02\ua1c4", -955300825, 1681262480) + (this.pov - l + 999L) / 1000L + a.d("\u8e01\uf3d1", 617470108, 267540159);
                    break;
                }
                if (l < this.pou) break;
                this.pou = l + 1000L;
                if (pjd.enter(object, this.pox)) {
                    this.pph(minecraftClient, l);
                    break;
                }
                this.ppd = a.d("\u65dd\u1c49\u9695\u08e4\u833a\u0189\ubbc0\u362c\ua87e\u26df\ua56d\u5f67\ud1b1\u480b\uc25c\u44ac\ufaf6", 1246302321, 1179611558) + this.pox + a.d("\ue8d3\u9501\u1fa7\u81d5\u0e17", -1157833919, -1735052361) + 3 + a.d("\ue852\u95fe\u1f20\u8129\u0a8e\u8c42\u3274\u9bb1\u25da\uab7d\u2cac\ud6aa\u5c1e\uc1b1\u4b9b\ucd18\u7722\uf886\u6234\ue469\u6986\u13df", -702390510, 1903277942) + Math.max(1, pjd.position(object)) + a.b("\uaa6a\ud7cf\u590c", 874228292);
                break;
            }
            case 2: {
                if (!this.poz && l - this.pot <= 15000L) break;
                this.por = pof.WAIT;
                this.pov = this.poz ? l + 4000L : 0L;
                this.poz = false;
                if (++this.pow < 3) break;
                this.pow = 0;
                this.pov = l + 30000L;
                pjd.leave(object);
                this.ppe.accept(a.b("\u7f7c\u06e5\u8823\u124d\u99e6\u1f55\ua505\u2c8e\ub2d2\u3866\ubbab\u45c2\ucb1a\u56bc\ud8f4\u5e00\ue440\u6b91\uf12b\u7362\ufe88\u84d4\u0e77\u91c7\u17c3\u9d13\u24ab\uaafe\u341d", -1399096452) + this.pox + a.b("\ua20c\ufb89\u516e\ucb00\u40d6\uc66b\u7c48\uf5c5\u6be4\ue535\u6681\u9c82\u1220\u8be4\u01b5\u8353\u390f\ub6dd\u2c7e\uae4e", -1156734408));
                break;
            }
        }
        return true;
    }

    private void pph(MinecraftClient minecraftClient, long l) {
        this.por = pof.HOP;
        this.pot = l;
        this.poz = false;
        this.ppd = a.d("\udd22\ua4b6\u2e6a\ub01b\u3bc5\ub976\u033f\u8ed9\u1081\u9a45\u1ded\ue794\u6936\uf4e4\u7aaa\ufc56\u4209\uc9b9\u5371\ud521\u5cdd\u2688\uac2f", -1660041644, 1776361338) + this.pox + (this.pow > 0 ? a.d("\u56ff\u2f46\ua182\u3ff2\ub429\u32e8\u88c7\u0148\u9b77", 966225484, -167102310) + this.pow + a.b("\u4fde", -809611274) : "");
        minecraftClient.method_1562().method_45730(a.d("\u16cd\u6f73", -1990197013, -282651067) + this.pox);
    }

    private static /* synthetic */ int blz(int n, int n2) {
        return n - n2 + -1133737027;
    }
}

