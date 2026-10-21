/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.screen.v1.ScreenEvents
 *  net.minecraft.class_1707
 *  net.minecraft.class_1735
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_2561
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_437
 *  net.minecraft.class_465
 *  net.minecraft.class_476
 *  net.minecraft.class_746
 *  net.minecraft.class_7923
 *  net.minecraft.class_9290
 *  net.minecraft.class_9304
 *  net.minecraft.class_9334
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.Hud;
import a.ModuleCategory;
import a.Module;
import a.mgg;
import a.AuctionRateLimiter;
import a.ClaimTooltipParser;
import a.EnchantNameUtil;
import a.Icon;
import a.BoolSetting;
import a.KeySetting;
import a.NumberSetting;
import a.SlotUtil;
import a.Lang;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.class_1707;
import net.minecraft.class_1735;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_437;
import net.minecraft.class_465;
import net.minecraft.class_476;
import net.minecraft.class_746;
import net.minecraft.class_7923;
import net.minecraft.class_9290;
import net.minecraft.class_9304;
import net.minecraft.class_9334;
import org.lwjgl.glfw.GLFW;

public class ContainerSearch
extends Module {
    private static final String[] mgm = ContainerSearch.mil("сундук", "chest", "инвентарь", "inventory", "бочка", "barrel", "shulker", "шалкер");
    private static final String[] mgn = ContainerSearch.mil("аукцион", "auction", "рынок", "market", "барахолка");
    private static final String[] mgo = ContainerSearch.mil("хранилище", "назад", "вперед", "вперёд", "поиск", "страниц", "обновить", "категории", "информация", "вопрос");
    private static final String[] mgp = ContainerSearch.mil("продав", "истек", "истёк", "владел", "осталось", "seller", "expire");
    private static final String[] mgq = ContainerSearch.mil("через", "сек", "мин", "час", "дн");
    private static final String[] mgr = ContainerSearch.mil("не актуал", "продано", "завершен", "завершён");
    private static final String[] mgs = ContainerSearch.mil("истек", "истёк");
    private static final String mgt = EnchantNameUtil.title("истекает");
    private static final int mgu = -16711936;
    private static final int mgv = -29696;
    private static final int mgw = -52429;
    private static final int mgx = -16711681;
    private static final int mgy = 75;
    private static final int mgz = 153;
    private static ContainerSearch mha;
    private final KeySetting mhb = this.add(new KeySetting("Поиск по биндy", -1));
    private final BoolSetting mhc = this.add(new BoolSetting("Без шипов", true));
    private final BoolSetting mhd = this.add(new BoolSetting("Только Прочность 5", false));
    private final BoolSetting mhe = this.add(new BoolSetting("Только Защита 5", false));
    private final BoolSetting mhf = this.add(new BoolSetting("Только Подводная ходьба 3", false));
    private final BoolSetting mhg = this.add(new BoolSetting("Только полная прочность", false));
    private final BoolSetting mhh = this.add(new BoolSetting("Цена за штуку", false));
    private final BoolSetting mhi = this.add(new BoolSetting("Подсветка общего минимума", true));
    private final NumberSetting mhj = this.add(new NumberSetting("Поисков в минуту", 20.0, 4.0, 40.0, 1.0));
    private String mhk = "";
    private long mhl;
    private class_1735 mhm;
    private class_1735 mhn;
    private class_1735 mho;
    private class_1735 mhp;
    private int mhq = -1;
    private int mhr;
    private long mhs;
    private boolean mht;
    private boolean mhu;
    private boolean mhv;
    private static /* synthetic */ String mhw;
    private static /* synthetic */ String mhx;

    public ContainerSearch() {
        super("AuctionHelper", "Highlights the cheapest /ah lots", ModuleCategory.PLAYER);
        mha = this;
    }

    @Override
    protected void onEnable() {
        this.mih();
        this.mhq = -1;
        this.mhr = 0;
        this.mhs = 0L;
    }

    @Override
    protected void onDisable() {
        this.mih();
    }

    public static void onMessage(class_2561 class_25612) {
    }

    public static void attach(class_437 class_4373) {
        if (!(class_4373 instanceof class_476)) {
            return;
        }
        class_476 class_4762 = (class_476)class_4373;
        ScreenEvents.afterRender((class_437)class_4373).register((class_4372, class_3322, n, n2, f) -> {
            ContainerSearch mgl2 = mha;
            if (mgl2 != null && mgl2.isEnabled() && mgl2.mid(class_4762, class_3322)) {
                mgl2.mhy(class_4762, class_3322, n, n2);
            }
        });
    }

    private void mhy(class_476 class_4762, class_332 class_3322, int n, int n2) {
        if (!((class_1707)class_4762.method_17577()).method_34255().method_7960()) {
            class_4762.method_71083(class_3322, n, n2);
            return;
        }
        class_1735 class_17352 = SlotUtil.hovered(class_4762);
        if (class_17352 == null || !class_17352.method_7681()) {
            return;
        }
        class_1799 class_17992 = class_17352.method_7677();
        class_3322.method_51437(this.mc.field_1772, class_437.method_25408((class_310)this.mc, (class_1799)class_17992), class_17992.method_32347(), n, n2, (class_2960)class_17992.method_58694(class_9334.field_54198));
        class_3322.method_73199();
    }

    @Override
    public void onKey(class_310 class_3102, int n) {
        if (n != this.mhb.get()) {
            return;
        }
        this.mia(class_3102);
    }

    @Override
    public void onStartTick(class_310 class_3102) {
        if (class_3102.field_1724 == null) {
            return;
        }
        this.mhz(class_3102);
    }

    private void mhz(class_310 class_3102) {
        if (class_3102.method_22683() == null) {
            this.mhv = false;
            return;
        }
        boolean bl = GLFW.glfwGetMouseButton((long)class_3102.method_22683().method_4490(), (int)2) == 1;
        boolean bl2 = bl && !this.mhv && class_3102.field_1755 instanceof class_476;
        this.mhv = bl;
        if (!bl2) {
            return;
        }
        class_476 class_4762 = (class_476)class_3102.field_1755;
        String string = EnchantNameUtil.title(class_4762.method_25440().getString());
        if (ContainerSearch.mij(string)) {
            return;
        }
        class_1735 class_17352 = SlotUtil.hovered(class_4762);
        if (class_17352 == null || !class_17352.method_7681()) {
            return;
        }
        String string2 = ContainerSearch.cleanQuery(class_17352.method_7677().method_7964().getString());
        if (string2.isEmpty()) {
            return;
        }
        this.mhk = string2;
        Hud.alert(this.getName(), Lang.s("Bound: ", "Забинжен: ") + this.mhk, Icon.PIN, true);
    }

    private void mia(class_310 class_3102) {
        if (class_3102.field_1724 == null || class_3102.method_1562() == null) {
            return;
        }
        long l = System.currentTimeMillis();
        if (l - this.mhl < 500L) {
            return;
        }
        if (!this.mib(l)) {
            Hud.alert(this.getName(), Lang.s("Rate limit", "Слишком часто"), Icon.CLOCK, false);
            return;
        }
        String string = this.mic(class_3102.field_1724);
        if (string.isEmpty()) {
            Hud.alert(this.getName(), Lang.s("Nothing to search", "Не выбран предмет"), Icon.INFO, false);
            return;
        }
        this.mhl = l;
        class_3102.method_1562().method_45730("ah search " + string);
    }

    private boolean mib(long l) {
        return AuctionRateLimiter.nextFree(0, this.mhj.getInt(), l) <= l;
    }

    private String mic(class_746 class_7462) {
        String string;
        class_465 class_4652;
        Object object = this.mc.field_1755;
        if (object instanceof class_465 && (object = SlotUtil.hovered(class_4652 = (class_465)object)) != null && object.method_7681() && !(string = ContainerSearch.cleanQuery(object.method_7677().method_7964().getString())).isEmpty()) {
            return string;
        }
        class_4652 = class_7462.method_6047();
        if (class_4652 != null && !class_4652.method_7960() && !((String)(object = ContainerSearch.cleanQuery(class_4652.method_7964().getString()))).isEmpty()) {
            return object;
        }
        return this.mhk;
    }

    public static String cleanQuery(String string) {
        if (string == null || string.isEmpty()) {
            return "";
        }
        String string2 = string.replaceAll("§.", "");
        StringBuilder stringBuilder = new StringBuilder(string2.length());
        boolean bl = true;
        for (int i = 0; i < string2.length(); ++i) {
            boolean bl2;
            char c = string2.charAt(i);
            boolean bl3 = bl2 = c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '\u0400' && c <= '\u04ff' || c >= '0' && c <= '9';
            if (bl2) {
                stringBuilder.append(Character.toLowerCase(c));
                bl = false;
                continue;
            }
            if (bl) continue;
            stringBuilder.append(' ');
            bl = true;
        }
        return stringBuilder.toString().trim();
    }

    public String getBound() {
        return this.mhk;
    }

    private boolean mid(class_476 class_4762, class_332 class_3322) {
        String string;
        int n = ((class_1707)class_4762.method_17577()).field_7763;
        if (n != this.mhq) {
            this.mih();
            this.mhq = n;
            this.mhr = 0;
            this.mhs = 0L;
        }
        if (ContainerSearch.mij(string = EnchantNameUtil.title(class_4762.method_25440().getString()))) {
            this.mih();
            return false;
        }
        boolean bl = this.mhh.get() != this.mht || this.mhi.get() != this.mhu;
        int n2 = this.mif(class_4762);
        long l = System.currentTimeMillis();
        if (bl || n2 != this.mhr || l - this.mhs > 500L) {
            this.mie(class_4762, string);
            this.mhr = n2;
            this.mhs = l;
            this.mht = this.mhh.get();
            this.mhu = this.mhi.get();
        }
        int[] nArray = this.mii(class_4762);
        boolean bl2 = this.mhi.get() && this.mig(class_3322, this.mhp, nArray, -16711681);
        bl2 |= this.mig(class_3322, this.mhm, nArray, -16711936);
        bl2 |= this.mig(class_3322, this.mhn, nArray, -29696);
        return bl2 |= this.mig(class_3322, this.mho, nArray, -52429);
    }

    private void mie(class_476 class_4762, String string) {
        ArrayList<mgg> arrayList = new ArrayList<mgg>();
        class_1735 class_17352 = null;
        int n = Integer.MAX_VALUE;
        int n2 = ((class_1707)class_4762.method_17577()).method_17388();
        int n3 = n2 * 9;
        boolean bl = ContainerSearch.mik(string);
        for (class_1735 class_17353 : ((class_1707)class_4762.method_17577()).field_7761) {
            int n4;
            List<String> list;
            class_1799 class_17992;
            if (class_17353.field_7874 >= n3 || (class_17992 = class_17353.method_7677()).method_7960() || (list = ClaimTooltipParser.lines(class_17992)).isEmpty() || ContainerSearch.mim(list.get(0), mgo) || (n4 = ClaimTooltipParser.total(class_17992)) <= 0 || !bl && !ContainerSearch.min(list, mgp) || this.mhc.get() && ContainerSearch.mip(class_17992, list, "шипы", "thorns") || this.mhd.get() && ContainerSearch.mis(class_17992) && !ContainerSearch.miq(list, "прочность", "unbreaking", 5) || this.mhe.get() && ContainerSearch.mis(class_17992) && !ContainerSearch.miq(list, "защита", "protection", 5) || this.mhf.get() && ContainerSearch.miw(class_17992) && !ContainerSearch.miq(list, "подводная ходьба", "depth strider", 3) || this.mhg.get() && class_17992.method_7963() && class_17992.method_7986() || ContainerSearch.mio(list)) continue;
            if (n4 < n) {
                n = n4;
                class_17352 = class_17353;
            }
            int n5 = this.mhh.get() && class_17992.method_7947() > 1 ? n4 / class_17992.method_7947() : n4;
            arrayList.add(new mgg(class_17353, n5));
        }
        Collections.sort(arrayList);
        this.mhm = arrayList.isEmpty() ? null : ((mgg)arrayList.get((int)0)).mgh;
        this.mhn = arrayList.size() > 1 ? ((mgg)arrayList.get((int)1)).mgh : null;
        this.mho = arrayList.size() > 2 ? ((mgg)arrayList.get((int)2)).mgh : null;
        this.mhp = class_17352;
    }

    private int mif(class_476 class_4762) {
        int n = 1;
        int n2 = ((class_1707)class_4762.method_17577()).method_17388();
        int n3 = n2 * 9;
        for (class_1735 class_17352 : ((class_1707)class_4762.method_17577()).field_7761) {
            class_1799 class_17992;
            if (class_17352.field_7874 >= n3 || (class_17992 = class_17352.method_7677()).method_7960()) continue;
            n = 31 * n + class_7923.field_41178.method_10206((Object)class_17992.method_7909());
            n = 31 * n + class_17992.method_7947();
            if (class_17992.method_57826(class_9334.field_49631)) {
                n = 31 * n + class_17992.method_7964().hashCode();
            }
            if (!class_17992.method_57826(class_9334.field_49632)) continue;
            n = 31 * n + ((class_9290)class_17992.method_58694(class_9334.field_49632)).hashCode();
        }
        return n;
    }

    private boolean mig(class_332 class_3322, class_1735 class_17352, int[] nArray, int n) {
        if (class_17352 == null || class_17352.method_7677().method_7960()) {
            return false;
        }
        int n2 = 0x4B000000 | n & 0xFFFFFF;
        int n3 = 0x99000000 | n & 0xFFFFFF;
        int n4 = nArray[0] + class_17352.field_7873;
        int n5 = nArray[1] + class_17352.field_7872;
        int n6 = n4 + 16;
        int n7 = n5 + 16;
        class_3322.method_25294(n4, n5, n6, n7, n2);
        class_3322.method_25294(n4 - 1, n5 - 1, n6 + 1, n5, n3);
        class_3322.method_25294(n4 - 1, n7, n6 + 1, n7 + 1, n3);
        class_3322.method_25294(n4 - 1, n5, n4, n7, n3);
        class_3322.method_25294(n6, n5, n6 + 1, n7, n3);
        return true;
    }

    private void mih() {
        this.mhm = null;
        this.mhn = null;
        this.mho = null;
        this.mhp = null;
    }

    private int[] mii(class_476 class_4762) {
        int n = ((class_1707)class_4762.method_17577()).method_17388();
        int n2 = 176;
        int n3 = 114 + n * 18;
        int n4 = (class_4762.field_22789 - n2) / 2;
        int n5 = (class_4762.field_22790 - n3) / 2;
        return new int[]{n4, n5};
    }

    private static boolean mij(String string) {
        return ContainerSearch.mim(string, mgm);
    }

    private static boolean mik(String string) {
        return ContainerSearch.mim(string, mgn);
    }

    private static String[] mil(String ... stringArray) {
        String[] stringArray2 = new String[stringArray.length];
        for (int i = 0; i < stringArray.length; ++i) {
            stringArray2[i] = EnchantNameUtil.title(stringArray[i]);
        }
        return stringArray2;
    }

    private static boolean mim(String string, String[] stringArray) {
        for (String string2 : stringArray) {
            if (!string.contains(string2)) continue;
            return true;
        }
        return false;
    }

    private static boolean min(List<String> list, String[] stringArray) {
        for (String string : list) {
            if (!ContainerSearch.mim(string, stringArray)) continue;
            return true;
        }
        return false;
    }

    private static boolean mio(List<String> list) {
        for (String string : list) {
            if (ContainerSearch.mim(string, mgq) || !ContainerSearch.mim(string, mgr) && (!ContainerSearch.mim(string, mgs) || string.contains(mgt))) continue;
            return true;
        }
        return false;
    }

    private static boolean mip(class_1799 class_17992, List<String> list, String string, String string2) {
        if (ContainerSearch.min(list, ContainerSearch.mil(string, string2))) {
            return true;
        }
        try {
            class_9304 class_93042 = (class_9304)class_17992.method_58694(class_9334.field_49633);
            if (class_93042 != null && class_93042.toString().toLowerCase(Locale.ROOT).contains(string2)) {
                return true;
            }
            class_9304 class_93043 = (class_9304)class_17992.method_58694(class_9334.field_49643);
            if (class_93043 != null && class_93043.toString().toLowerCase(Locale.ROOT).contains(string2)) {
                return true;
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return false;
    }

    private static boolean miq(List<String> list, String string, String string2, int n) {
        String string3 = ContainerSearch.mir(n);
        return ContainerSearch.min(list, ContainerSearch.mil(string + " " + n, string2 + " " + n, string + " " + string3, string2 + " " + string3));
    }

    private static String mir(int n) {
        return switch (n) {
            case 1 -> "i";
            case 2 -> "ii";
            case 3 -> "iii";
            case 4 -> "iv";
            case 5 -> "v";
            default -> String.valueOf(n);
        };
    }

    private static boolean mis(class_1799 class_17992) {
        return ContainerSearch.mit(class_17992) || ContainerSearch.miu(class_17992) || ContainerSearch.miv(class_17992) || ContainerSearch.miw(class_17992);
    }

    private static boolean mit(class_1799 class_17992) {
        return class_17992.method_31574(class_1802.field_22027) || class_17992.method_31574(class_1802.field_8805) || class_17992.method_31574(class_1802.field_8743) || class_17992.method_31574(class_1802.field_8862) || class_17992.method_31574(class_1802.field_8283) || class_17992.method_31574(class_1802.field_8267) || class_17992.method_31574(class_1802.field_8090);
    }

    private static boolean miu(class_1799 class_17992) {
        return class_17992.method_31574(class_1802.field_22028) || class_17992.method_31574(class_1802.field_8058) || class_17992.method_31574(class_1802.field_8523) || class_17992.method_31574(class_1802.field_8678) || class_17992.method_31574(class_1802.field_8873) || class_17992.method_31574(class_1802.field_8577);
    }

    private static boolean miv(class_1799 class_17992) {
        return class_17992.method_31574(class_1802.field_22029) || class_17992.method_31574(class_1802.field_8348) || class_17992.method_31574(class_1802.field_8396) || class_17992.method_31574(class_1802.field_8416) || class_17992.method_31574(class_1802.field_8218) || class_17992.method_31574(class_1802.field_8570);
    }

    private static boolean miw(class_1799 class_17992) {
        return class_17992.method_31574(class_1802.field_22030) || class_17992.method_31574(class_1802.field_8285) || class_17992.method_31574(class_1802.field_8660) || class_17992.method_31574(class_1802.field_8753) || class_17992.method_31574(class_1802.field_8313) || class_17992.method_31574(class_1802.field_8370);
    }

    private static /* synthetic */ int bba(int n, int n2) {
        return n * n2 | 0xED112588;
    }

    private static /* synthetic */ int bbb(int n, int n2) {
        return ContainerSearch.bba(n, n2) + n;
    }
}

