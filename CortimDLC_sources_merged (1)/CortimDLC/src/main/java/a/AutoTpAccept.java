/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2558
 *  net.minecraft.class_2558$class_10609
 *  net.minecraft.class_2558$class_10610
 *  net.minecraft.class_2561
 *  net.minecraft.class_2583
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_640
 */
package a;

import a.Friends;
import a.Hud;
import a.ModuleCategory;
import a.Module;
import a.Icon;
import a.ModeSetting;
import a.NumberSetting;
import a.TextSetting;
import a.Lang;
import flow.dev.StringDecryptor;
import java.util.Optional;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.class_2558;
import net.minecraft.class_2561;
import net.minecraft.class_2583;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_640;

public class AutoTpAccept
extends Module {
    private static AutoTpAccept miy;
    private final ModeSetting miz = this.add(new ModeSetting("From", "Friends", "Friends", "Everyone"));
    private final TextSetting mja = this.add(new TextSetting("Command", "/tpaccept", 64));
    private final NumberSetting mjb = this.add(new NumberSetting("Delay", 0.6, 0.0, 3.0, 0.1).suffix("s"));
    private static final int mjc = 322;
    private static final Pattern mjd;
    private static final Pattern mje;
    private static final Pattern mjf;
    private static final Pattern mjg;
    private static final Pattern mjh;
    private static final Pattern mji;
    private static final Random mjj;
    private String mjk;
    private long mjl;
    private long mjm;
    private static /* synthetic */ boolean mjn;
    private static /* synthetic */ long mjo;

    public AutoTpAccept() {
        super("AutoAccept", "Accepts teleport requests by itself", ModuleCategory.PLAYER);
        miy = this;
    }

    public static void onMessage(class_2561 class_25612) {
        AutoTpAccept mix2 = miy;
        if (mix2 == null || !mix2.isEnabled() || class_25612 == null) {
            return;
        }
        mix2.mjp(class_25612);
    }

    private void mjp(class_2561 class_25612) {
        String string = class_25612.getString().replace('\u0451', '\u0435').replace('\u0401', '\u0415');
        if (string.isEmpty() || !AutoTpAccept.looksLikeRequest(string)) {
            return;
        }
        String string2 = AutoTpAccept.mjq(class_25612, string);
        if (this.miz.is("Friends") ? string2 == null || !Friends.isFriend(string2) : string2 == null && this.mja.get().contains("{name}")) {
            return;
        }
        this.mjk = string2 == null ? "" : string2;
        this.mjl = System.currentTimeMillis() + Math.round(this.mjb.get() * 1000.0) + (long)mjj.nextInt(250);
    }

    static boolean looksLikeRequest(String string) {
        return mjd.matcher(string).find() && mje.matcher(string).find() && !mjf.matcher(string).find() && !mjg.matcher(string).find();
    }

    private static String mjq(class_2561 class_25612, String string) {
        class_310 class_3102 = class_310.method_1551();
        class_634 class_6342 = class_3102.method_1562();
        if (class_6342 == null || class_3102.field_1724 == null) {
            return null;
        }
        String string3 = class_3102.field_1724.method_5477().getString();
        String[] stringArray = new String[1];
        class_25612.method_27658((class_25832, string2) -> {
            String string3;
            Object object;
            class_2558 class_25582 = class_25832.method_10970();
            if (class_25582 instanceof class_2558.class_10609) {
                class_2558.class_10609 class_106092 = (class_2558.class_10609)class_25582;
                v0 = class_106092.comp_3506();
            } else {
                class_25582 = class_25832.method_10970();
                if (class_25582 instanceof class_2558.class_10610) {
                    object = (class_2558.class_10610)class_25582;
                    v0 = object.comp_3507();
                } else {
                    v0 = string3 = null;
                }
            }
            if (string3 != null && ((Matcher)(object = mji.matcher(string3.trim()))).find() && !((Matcher)object).group(3).equalsIgnoreCase(string3)) {
                stringArray[0] = ((Matcher)object).group(3);
                return Optional.of(Boolean.TRUE);
            }
            return Optional.empty();
        }, class_2583.field_24360);
        if (stringArray[0] != null) {
            class_640 class_6402 = class_6342.method_73471(stringArray[0]);
            return class_6402 != null ? class_6402.method_2966().name() : stringArray[0];
        }
        Matcher matcher = mjh.matcher(string);
        while (matcher.find()) {
            String string4 = matcher.group();
            if (string4.equalsIgnoreCase(string3)) continue;
            if (Friends.isFriend(string4)) {
                return string4;
            }
            class_640 class_6403 = class_6342.method_73471(string4);
            if (class_6403 == null) continue;
            return class_6403.method_2966().name();
        }
        return null;
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        if (this.mjk == null || System.currentTimeMillis() < this.mjl) {
            return;
        }
        String string = this.mjk;
        this.mjk = null;
        if (System.currentTimeMillis() - this.mjm < 1500L || class_3102.method_1562() == null) {
            return;
        }
        String string2 = this.mja.get().trim().replace("{name}", string);
        if (string2.isEmpty()) {
            return;
        }
        this.mjm = System.currentTimeMillis();
        if (string2.startsWith("/")) {
            class_3102.method_1562().method_45730(string2.substring(1));
        } else {
            class_3102.method_1562().method_45729(string2);
        }
        Hud.alert(string.isEmpty() ? this.getName() : string, Lang.s("Teleport accepted", "Телепорт принят"), Icon.FRIENDS, true);
    }

    static {
        mjd = Pattern.compile("(tpa|tpahere|teleport|телепорт|\\bтп\\b)", 322);
        mje = Pattern.compile("(request|запрос|wants|хочет|просит|asks|asked|to you|к вам|к себе|tpaccept|tpyes|/tpa\\b|принять|accept)", 322);
        mjf = Pattern.compile("(вы отправили|вы запросили|запрос[а-я ]{0,24}отправлен(?! вам)|отправлен игроку|you sent|you have sent|you've sent|request sent|sent (a |your )?(teleport |tpa )?request to|request to \\w+ (was |has been )?sent)", 322);
        mjg = Pattern.compile("\\b(принят|принята|принял|приняли|accepted|denied|отклонен\\w*|отклонил\\w*|expired|истек|истекл[аои]|отменен\\w*|отменил\\w*|cancell?ed|timed out)\\b", 322);
        mjh = Pattern.compile("(?<![A-Za-z0-9_])[A-Za-z0-9_]{3,16}(?![A-Za-z0-9_])");
        mji = Pattern.compile("^/?(\\S*(tpaccept|tpyes|tpaaccept|accept)\\S*)\\s+([A-Za-z0-9_]{3,16})", 2);
        mjj = new Random();
    }

    private static /* synthetic */ int bbe(int n, int n2) {
        return n + n2 + -1860425755;
    }
}

