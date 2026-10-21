/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1304
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_746
 */
package a;

import a.EnchantNameUtil;
import a.InstanceQueue;
import a.pof;
import flow.dev.StringDecryptor;
import java.util.function.Consumer;
import net.minecraft.class_1304;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_746;

public final class LobbyWatcher {
    private static final long poj = 1500L;
    private static final int pok = 9;
    private static final class_1304[] pol = new class_1304[]{class_1304.field_6169, class_1304.field_6174, class_1304.field_6172, class_1304.field_6166};
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

    public static boolean inLobby(class_1657 class_16572) {
        class_1661 class_16612 = class_16572.method_31548();
        boolean bl = class_16572.method_6079().method_31574(class_1802.field_8251);
        int n = class_16572.method_6079().method_7960() ? 0 : 1;
        for (int i = 0; i < 36; ++i) {
            class_1799 class_17992 = class_16612.method_5438(i);
            if (class_17992.method_7960()) continue;
            ++n;
            bl |= class_17992.method_31574(class_1802.field_8251);
        }
        if (!bl) {
            return false;
        }
        for (class_1304 class_13042 : pol) {
            if (class_16572.method_6118(class_13042).method_7960()) continue;
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
            InstanceQueue.cancel(object);
        }
        this.por = pof.NONE;
        this.pos = 0L;
        this.poy = false;
        this.poz = false;
        this.ppa = false;
        this.ppc = false;
        this.ppd = "";
    }

    public void onChat(class_2561 class_25612) {
        if (class_25612 == null || this.por != pof.HOP) {
            return;
        }
        String string = EnchantNameUtil.title(class_25612.getString());
        if (string.contains("уже") && (string.contains("сервер") || string.contains("подключ") || string.contains("находит")) || string.contains("already connected")) {
            this.ppa = true;
            this.ppb = class_310.method_1551().field_1687;
        } else if (string.contains("недоступ") || string.contains("не удалось подключ") || string.contains("not available") || string.contains("переполнен") || string.contains("перезагруж")) {
            this.poz = true;
        }
    }

    public boolean tick(class_310 class_3102, class_746 class_7462, Object object, String string, long l) {
        String string2;
        if (class_7462 == null || class_3102.method_1562() == null) {
            return false;
        }
        if (!LobbyWatcher.inLobby((class_1657)class_7462)) {
            if (this.por == pof.HOP) {
                this.poy = true;
                InstanceQueue.at(object, this.pox);
                this.ppe.accept("Вышел из лобби на склад " + this.pox);
            } else if (this.por == pof.WAIT) {
                InstanceQueue.cancel(object);
            }
            this.por = pof.NONE;
            this.pos = 0L;
            this.ppa = false;
            this.ppc = false;
            this.ppd = "";
            return false;
        }
        if (this.ppa && class_3102.field_1687 != this.ppb) {
            this.ppa = false;
        }
        if (this.ppa) {
            if (this.por != pof.NONE) {
                this.ppe.accept("Компас в инвентаре, но это не лобби — продолжаю");
                InstanceQueue.at(object, this.pox);
                this.por = pof.NONE;
            }
            return false;
        }
        if (this.pos == 0L) {
            this.pos = l;
        }
        if ((string2 = InstanceQueue.key(string)).isEmpty() || !string2.chars().allMatch(Character::isDigit)) {
            if (!this.ppc && l - this.pos >= 1500L) {
                this.ppc = true;
                this.ppe.accept("В лобби (компас в слотах), но анка склада не задана");
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
            InstanceQueue.leave(object);
            this.ppe.accept("В лобби (компас в слотах) — иду на склад " + string2);
        }
        switch (this.por.ordinal()) {
            case 1: {
                if (l < this.pov) {
                    this.ppd = "Лобби: склад " + this.pox + " не пускает, повтор через " + (this.pov - l + 999L) / 1000L + " с";
                    break;
                }
                if (l < this.pou) break;
                this.pou = l + 1000L;
                if (InstanceQueue.enter(object, this.pox)) {
                    this.pph(class_3102, l);
                    break;
                }
                this.ppd = "Лобби: на складе " + this.pox + " уже " + 3 + " наших — жду очереди (" + Math.max(1, InstanceQueue.position(object)) + "-й)";
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
                InstanceQueue.leave(object);
                this.ppe.accept("Не пустило из лобби на склад " + this.pox + " — повтор через 30 с");
                break;
            }
        }
        return true;
    }

    private void pph(class_310 class_3102, long l) {
        this.por = pof.HOP;
        this.pot = l;
        this.poz = false;
        this.ppd = "Лобби: захожу на склад " + this.pox + (this.pow > 0 ? " (повтор " + this.pow + ")" : "");
        class_3102.method_1562().method_45730("an" + this.pox);
    }

    private static /* synthetic */ int blz(int n, int n2) {
        return n - n2 + -1133737027;
    }
}

