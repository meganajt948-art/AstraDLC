/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.network.PlayerListEntry
 */
package a;

import a.hia;
import a.hlc;
import a.iov;
import a.izx;
import a.jcs;
import a.jeq;
import a.jgd;
import a.jgn;
import a.jip;
import a.jlo;
import a.jlr;
import a.jlu;
import a.kfe;
import a.ujt;
import a.uok;
import a.upt;
import a.uqe;
import a.uut;
import a.vcj;
import a.vcq;
import a.vct;
import a.vdc;
import a.vdn;
import a.vhz;
import a.vjf;
import a.vkl;
import a.vlv;
import a.vmo;
import a.vxu;
import a.wap;
import flow.dev.a;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.PlayerListEntry;

public final class jlx
extends jcs {
    public static final vkl FPS;
    public static final vkl PING;
    public static final vkl TPS;
    public static final vkl BPS;
    public static final vkl COORDS;
    public static final vkl TIME;
    public static final vkl ACCOUNT;
    public static final vkl ALERTS;
    public static final List<vmo> ISLAND;
    public static final vkl MUSIC;
    public static final vlv VIEW;
    public static final vkl EXPAND;
    public static final vkl COVER;
    public static final List<vmo> MUSIC_SETTINGS;
    private static final float jly = 17.0f;
    private static final float jlz = 7.0f;
    private static final float jma = 11.0f;
    private static final float jmb = 11.0f;
    private static final float jmc = 200.0f;
    private static final float jmd = 44.0f;
    private static final float jme = 30.0f;
    private static final float jmf = 12.0f;
    private static final long jmg = 1700L;
    private static final long jmh = 4500L;
    private static final long jmi = 15000L;
    private static final long jmj = 200L;
    private static final long jmk = 2500L;
    private static final String jml;
    private final vct jmm = new vct(190.0f, 0.8f);
    private final vct jmn = new vct(190.0f, 0.8f);
    private final vdc jmo = new vdc(0.38f, 1.0f);
    private jlr jmp = jlr.BASE;
    private jlr jmq = jlr.BASE;
    private final List<jlu> jmr = new ArrayList<jlu>();
    private final jlu[] jms = new jlu[]{new jlu(), new jlu(), new jlu(), new jlu(), new jlu(), new jlu()};
    private long jmt;
    private String jmu = "";
    private static final int jmv = 6;
    private static final float jmw = 12.0f;
    private static final float jmx = 11.0f;
    private static final float jmy = 4.0f;
    private final List<jlo> jmz = new ArrayList<jlo>();
    private jgd jna;
    private long jnb;
    private uok jnc;
    private final vcj jnd = new vcj(7.0f, 1.0f);
    private final vcj[] jne = new vcj[]{new vcj(14.0f), new vcj(14.0f), new vcj(14.0f), new vcj(14.0f)};
    private final vcj[] jnf = new vcj[]{new vcj(16.0f), new vcj(16.0f), new vcj(16.0f)};
    private final vcj[] jng = new vcj[]{new vcj(9.0f), new vcj(9.0f), new vcj(9.0f)};
    private final float[] jnh = new float[3];
    private float jni = -100.0f;
    private static final float jnj = 9.0f;
    private String jnk;
    private String jnl = "";
    private String jnm = "";
    private String jnn = "";
    private static final float jno = 2.3f;
    private static /* synthetic */ String jnp;
    private static /* synthetic */ String jnq;

    jlx() {
        super(a.d("\uda56\ua3f1\u2937\ub757\u3c97\uba39f\u8984\u17c2", -1824401247, -722533751), a.d("\ufb18\u829f\u0859\u9639\u1df9\u9b57\u2108\ua8ea\u36ac", 1696813896, -24205298), true, 1, 0, 0.0f, 6.0f);
    }

    @Override
    public List<vmo> settings() {
        ArrayList<vmo> arrayList = new ArrayList<vmo>(ISLAND);
        arrayList.add(MUSIC);
        arrayList.addAll(MUSIC_SETTINGS);
        return arrayList;
    }

    void toggled(kfe kfe2) {
        this.alert(kfe2.getDisplayName(), kfe2.isAction() ? wap.s(a.b("\u863b\uffa8\u756c\ueb00\u60c8\ue66e\u5c28\ud5c8\u4b96", -881031565), a.b("\ufeb9\u8722\u0d89\u9382\u185f\u9ee4\u24cf\uad40\u3313\ub9a0\u3e7e", 1266416290)) : wap.s(kfe2.isEnabled() ? a.d("\u7efc\u076c", -387643594, 1657239943) : a.b("\u7b6a\u02f2\u8821", 484801318), kfe2.isEnabled() ? a.d("\ud576\uacef\u263d\ub839\u33e7\ub540\u0f7f", -426125500, -1548220889) : a.d("\uebde\u9236\u1894\u86e4\u0d46\u8bfe\u31df\ub826", 1512158149, -186164223)), hlc.iconFor(kfe2.getCategory()), kfe2.isEnabled());
    }

    void alert(String string, String string2, vhz vhz2, boolean bl) {
        if (!ALERTS.get()) {
            return;
        }
        long l = System.currentTimeMillis();
        jlo jlo2 = null;
        for (jlo jlo3 : this.jmz) {
            if (!jlo3.name.equals(string) || l - jlo3.at >= 1700L) continue;
            jlo2 = jlo3;
            break;
        }
        if (jlo2 == null) {
            jlo2 = new jlo();
            jlo2.name = string;
            jlo2.flip.set(bl ? 0.0f : 1.0f);
            jlo2.shown.set(this.jnr(l) ? 0.0f : 1.0f);
            this.jmz.add(jlo2);
            if (this.jmz.size() > 6) {
                this.jmz.remove(0);
            }
        }
        jlo2.on = bl;
        jlo2.state = string2;
        jlo2.icon = vhz2;
        jlo2.at = l;
    }

    private boolean jnr(long l) {
        for (jlo jlo2 : this.jmz) {
            if (l - jlo2.at >= 1700L) continue;
            return true;
        }
        return false;
    }

    @Override
    void update(float f, boolean bl) {
        uok uok2;
        float f2;
        boolean bl2;
        long l = System.currentTimeMillis();
        jgd jgd2 = this.jna = MUSIC.get() ? jgn.track() : null;
        if (this.jna == null && bl && MUSIC.get()) {
            this.jna = new jgd(a.d("\uc1d5\ub846\u3282\uace0\u2728\ua195\u1bd4", 1493875464, -1626244470), a.c(1023874074, "\u145a\u6dcf\ue711\u796a\uf2ba\u7405\uce59\u47b4\ud9bf\u536d\ud494\u2ef8\ua022"), a.b("\u5ce1\u2525\uaffd", 1806064815), true, 0L, 243000L, l - l % 243000L);
        }
        if (this.jna != null && !this.jna.playing()) {
            if (this.jnb == 0L) {
                this.jnb = l;
            }
        } else {
            this.jnb = 0L;
        }
        boolean bl3 = this.jna != null && (this.jna.playing() || l - this.jnb < 15000L);
        boolean bl4 = this.jna != null && (izx.pointer() || bl3 && (VIEW.is(a.b("\uf5dd\u8c5f\u0695\u98e4", 221246879)) || EXPAND.get() && l - jgn.changedAt() < 4500L && !a.b("\u09fb\u7068\ufaac\u64ce\uef06\u69bb\ud3fa", 75696556).equals(this.jna.app())));
        boolean bl5 = bl2 = ALERTS.get() && this.jnr(l);
        jlr jlr2 = bl2 ? jlr.ALERT : (bl4 ? jlr.MUSIC : jlr.BASE);
        if (jlr2 != this.jmp) {
            this.jmq = this.jmp;
            this.jmp = jlr2;
            this.jmo.restart();
        }
        this.jmo.update(f);
        this.jns(l);
        this.joe(l, bl2, f);
        float f3 = 17.0f;
        switch (this.jmp.ordinal()) {
            case 1: {
                f2 = this.jog(l);
                f3 = this.joh();
                break;
            }
            case 2: {
                f2 = 200.0f;
                f3 = 44.0f;
                break;
            }
            default: {
                f2 = this.jnw(null, 0.0f, 0.0f, bl3);
            }
        }
        this.jmm.step(f2, f);
        this.jmn.step(f3, f);
        boolean bl6 = this.jna != null && this.jna.playing();
        double d = (double)System.nanoTime() / 1.0E9;
        for (int i = 0; i < this.jne.length; ++i) {
            float f4 = (float)(0.5 + 0.25 * Math.sin(d * (7.1 + (double)i * 2.3) + (double)i * 1.7) + 0.25 * Math.sin(d * (11.3 - (double)i * 1.9) + (double)i * 0.6));
            this.jne[i].step(bl6 ? 0.25f + 0.75f * f4 : 0.18f, f);
        }
        uok uok3 = uok2 = COVER.get() ? jgn.cover() : null;
        if (uok2 != this.jnc) {
            this.jnc = uok2;
            if (uok2 != null) {
                this.jnd.set(0.0f);
            }
        }
        this.jnd.step(1.0f, f);
        for (int i = 0; i < 3; ++i) {
            this.jng[i].step(0.0f, f);
        }
    }

    private void jns(long l) {
        ClientPlayerEntity clientPlayerEntity;
        boolean bl;
        String string = (FPS.get() ? a.d("\uf1b6", 6791450, -581873461) : "") + (PING.get() ? a.c(-1508093659, "\u5154") : "") + (TPS.get() ? a.b("\uf26f", 182055450) : "") + (BPS.get() ? a.c(-193094021, "\u9e18") : "") + (COORDS.get() ? a.c(-1752659453, "\u8a61") : "") + (TIME.get() ? a.c(-1626529438, "\u210b") : "");
        boolean bl2 = bl = !string.equals(this.jmu);
        if (!bl && l - this.jmt < 200L) {
            return;
        }
        this.jmt = l;
        this.jmu = string;
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        this.jmr.clear();
        int n = 0;
        if (FPS.get()) {
            clientPlayerEntity = this.jms[n++];
            jlx.jnt((jlu)clientPlayerEntity, "", String.valueOf(minecraftClient.getCurrentFps()), a.b("\u54a7\u2d00\ua7d0", -1889971006), 0, 0);
            this.jmr.add((jlu)clientPlayerEntity);
        }
        if (PING.get()) {
            int n2 = jlx.joc(minecraftClient);
            jlu object2 = this.jms[n++];
            jlx.jnt(object2, "", String.valueOf(n2), wap.unit(a.b("\u375e\u4ef1", -103532751)), 0, n2 < 80 ? -12595334 : (n2 < 160 ? -865972 : -1092784));
            this.jmr.add(object2);
        }
        if (TPS.get()) {
            float f = jip.tps();
            jlu jlu2 = this.jms[n++];
            int n2 = f < 0.0f || f >= 18.0f ? 0 : (f >= 12.0f ? -865972 : -1092784);
            jlx.jnt(jlu2, "", f < 0.0f ? a.b("\uab8b", 731548569) : jlx.jnu(f), a.b("\u6c4b\u15fe\u9f2e", -1273861060), n2, 0);
            this.jmr.add(jlu2);
        }
        if (BPS.get()) {
            clientPlayerEntity = this.jms[n++];
            jlx.jnt((jlu)clientPlayerEntity, "", jlx.jnu(jip.bps()), wap.s(a.c(675383233, "\u87a0\ufe03\u74d3"), a.b("\u036d\u7ad6\uf411\u6e0e", -1138030760)), 0, 0);
            this.jmr.add((jlu)clientPlayerEntity);
        }
        if (COORDS.get()) {
            clientPlayerEntity = minecraftClient.player;
            String string2 = clientPlayerEntity == null ? a.b("\u23bf\u5a1e\ud0dd\u4ebc\uc57b", -1454627958) : clientPlayerEntity.getBlockX() + a.d("\u49bf", 125077958, -661274536) + clientPlayerEntity.getBlockY() + a.c(1154353709, "\u0a0c") + clientPlayerEntity.getBlockZ();
            jlu jlu3 = this.jms[n++];
            jlx.jnt(jlu3, a.c(501304440, "\u4c23\u3593\ubf43"), string2, "", 0, 0);
            this.jmr.add(jlu3);
        }
        if (TIME.get()) {
            clientPlayerEntity = LocalTime.now();
            jlu jlu4 = this.jms[n];
            jlx.jnt(jlu4, "", vxu.hoursMinutes(clientPlayerEntity.getHour(), clientPlayerEntity.getMinute()), "", 0, 0);
            this.jmr.add(jlu4);
        }
        for (jlu jlu5 : this.jmr) {
            float f = jlu5.natural();
            if (!bl && !(f >= jlu5.wide) && l - jlu5.wideAt <= 2500L) continue;
            jlu5.wide = f;
            jlu5.wideAt = l;
        }
    }

    private static void jnt(jlu jlu2, String string, String string2, String string3, int n, int n2) {
        jlu2.label = string;
        jlu2.value = string2;
        jlu2.unit = string3;
        jlu2.color = n;
        jlu2.dot = n2;
    }

    private static String jnu(float f) {
        return f >= 100.0f ? String.valueOf(Math.round(f)) : vxu.fixed(f, 1);
    }

    @Override
    boolean hasContent(boolean bl) {
        return true;
    }

    @Override
    float width() {
        return Math.max(17.0f, this.jmm.get());
    }

    @Override
    float height() {
        return Math.max(8.0f, this.jmn.get());
    }

    @Override
    void draw(DrawContext drawContext, float f, boolean bl) {
        float f2;
        float f3 = this.width();
        float f4 = this.height();
        float f5 = Math.min(f4 * 0.5f, iov.r(11.0f));
        izx.panel(drawContext, f3, f4, f5);
        uut.pushScissor(drawContext, 0.0f, 0.0f, f3, f4);
        float f6 = this.jmo.linear();
        if (this.jmq != this.jmp && f6 < 1.0f && (f2 = 1.0f - vcq.outCubic(Math.min(1.0f, f6 / 0.45f))) > 0.01f) {
            this.jnv(drawContext, this.jmq, f3, f4, f2, f);
        }
        float f7 = f2 = this.jmq == this.jmp ? 1.0f : vcq.outCubic(Math.max(0.0f, (f6 - 0.25f) / 0.75f));
        if (f2 > 0.01f) {
            drawContext.getMatrices().pushMatrix();
            drawContext.getMatrices().translate(0.0f, (1.0f - f2) * 3.0f);
            this.jnv(drawContext, this.jmp, f3, f4, f2, f);
            drawContext.getMatrices().popMatrix();
        }
        uut.popScissor(drawContext);
    }

    private void jnv(DrawContext drawContext, jlr jlr2, float f, float f2, float f3, float f4) {
        uut.pushAlpha(f3);
        switch (jlr2.ordinal()) {
            case 1: {
                this.joi(drawContext, f, f2);
                break;
            }
            case 2: {
                this.joj(drawContext, f, f2, f4);
                break;
            }
            default: {
                boolean bl = this.jna != null && (this.jna.playing() || System.currentTimeMillis() - this.jnb < 15000L);
                float f5 = this.jnw(null, 0.0f, 0.0f, bl);
                this.jnw(drawContext, (f - f5) * 0.5f, f2 * 0.5f, bl);
            }
        }
        uut.popAlpha();
    }

    private float jnw(DrawContext drawContext, float f, float f2, boolean bl) {
        float f3 = f + 7.0f - 1.0f;
        if (drawContext != null && !uqe.draw(drawContext, f3 - 0.5f, f2 - 5.5f - 0.5f, 12.0f, iov.isLight(), -1) && !upt.draw(drawContext, f3, f2 - 5.5f, 11.0f, iov.logoTint())) {
            vjf.draw(drawContext, vhz.LOGO, f3 + 5.5f, f2, 8.6f, iov.text);
        }
        f3 += 14.5f;
        f3 = jlx.joa(drawContext, izx.BRAND, a.b("\ucd8f\ub414\u3ec4\ua0ad", -1968779827), f3, f2, iov.text);
        if (ACCOUNT.get()) {
            f3 = this.jnx(drawContext, jlx.job(drawContext, f3, f2), f2);
        }
        for (jlu jlu2 : this.jmr) {
            f3 = jlx.job(drawContext, f3, f2);
            float f4 = f3 + jlu2.wide;
            if (drawContext != null) {
                float f5 = f3;
                if (!jlu2.label.isEmpty()) {
                    f5 = izx.SMALL.draw(drawContext, jlu2.label, f5, izx.SMALL.centerTop(f2), iov.textMuted) + 3.0f;
                }
                if (jlu2.dot != 0) {
                    uut.circle(drawContext, f5 + 1.6f, f2, 1.6f, jlu2.dot);
                    f5 += 6.2f;
                }
                f5 = izx.VALUE.draw(drawContext, jlu2.value, f5, izx.VALUE.centerTop(f2), jlu2.color == 0 ? iov.text : jlu2.color);
                if (!jlu2.unit.isEmpty()) {
                    izx.SMALL.draw(drawContext, jlu2.unit, f5 + 2.0f, izx.SMALL.centerTop(f2), iov.textMuted);
                }
            }
            f3 = f4;
        }
        if (bl && this.jna != null) {
            f3 = jlx.job(drawContext, f3, f2);
            uok uok2 = this.jnc;
            if (uok2 != null) {
                if (drawContext != null) {
                    uut.image(drawContext, uok2.view, f3, f2 - 5.5f, 11.0f, 11.0f, Math.min(5.5f, iov.r(3.0f)), -1);
                }
                f3 += 16.0f;
            }
            if (this.jna.playing()) {
                f3 = this.jod(drawContext, f3, f2, 3, 7.0f) + 5.0f;
            } else {
                if (drawContext != null) {
                    vjf.draw(drawContext, vhz.PAUSE, f3 + 3.5f, f2, 7.0f, iov.textDim);
                }
                f3 += 11.0f;
            }
            f3 = jlx.joa(drawContext, izx.TEXT, this.jnz(this.jna), f3, f2, iov.text);
        }
        return f3 + 7.0f - f;
    }

    private float jnx(DrawContext drawContext, float f, float f2) {
        String string = this.jny();
        float f3 = 13.0f + izx.VALUE.width(string);
        if (drawContext == null) {
            return f + f3;
        }
        float f4 = f2 - 4.5f;
        if (!hia.drawSelected(drawContext, f, f4, 9.0f)) {
            uut.circle(drawContext, f + 4.5f, f2, 4.5f, iov.accent());
            izx.TINY.drawCentered(drawContext, string.substring(0, 1).toUpperCase(Locale.ROOT), f + 4.5f, izx.TINY.centerTop(f2), iov.onAccent());
        }
        izx.VALUE.draw(drawContext, string, f + 9.0f + 4.0f, izx.VALUE.centerTop(f2), iov.text);
        return f + f3;
    }

    private String jny() {
        String string = hia.account();
        if (!string.equals(this.jnk)) {
            this.jnk = string;
            this.jnl = izx.VALUE.ellipsize(string.isEmpty() ? a.b("\u9fec\ue677\u6ca7\uf2ce", -209674322) : string, 70.0f);
        }
        return this.jnl;
    }

    private String jnz(jgd jgd2) {
        String string;
        String string2 = string = jgd2.artist().isEmpty() ? jgd2.title() : jgd2.title() + a.d("\uba5a\uc37c\u4938", 1447740147, 955414666) + jgd2.artist();
        if (!string.equals(this.jnm)) {
            this.jnm = string;
            this.jnn = izx.TEXT.ellipsize(string, 110.0f);
        }
        return this.jnn;
    }

    private static float joa(DrawContext drawContext, vdn vdn2, String string, float f, float f2, int n) {
        if (drawContext != null) {
            return vdn2.draw(drawContext, string, f, vdn2.centerTop(f2), n);
        }
        return f + vdn2.width(string);
    }

    private static float job(DrawContext drawContext, float f, float f2) {
        float f3 = 5.5f;
        if (drawContext != null) {
            uut.circle(drawContext, f + f3, f2, 0.85f, ujt.mulAlpha(iov.textMuted, 0.6f));
        }
        return f + 11.0f;
    }

    private static int joc(MinecraftClient minecraftClient) {
        if (minecraftClient.getNetworkHandler() == null || minecraftClient.player == null) {
            return 0;
        }
        PlayerListEntry playerListEntry = minecraftClient.getNetworkHandler().getPlayerListEntry(minecraftClient.player.getUuid());
        return playerListEntry != null ? Math.max(0, playerListEntry.getLatency()) : 0;
    }

    private float jod(DrawContext drawContext, float f, float f2, int n, float f3) {
        float f4 = 1.5f;
        float f5 = 1.2f;
        if (drawContext != null) {
            for (int i = 0; i < n; ++i) {
                float f6 = Math.max(f4, f3 * this.jne[i].get());
                uut.round(drawContext, f + (float)i * (f4 + f5), f2 - f6 * 0.5f, f4, f6, f4 * 0.5f, iov.accent());
            }
        }
        return f + (float)n * f4 + (float)(n - 1) * f5;
    }

    private void joe(long l, boolean bl, float f) {
        for (int i = this.jmz.size() - 1; i >= 0; --i) {
            boolean bl2;
            jlo jlo2 = this.jmz.get(i);
            boolean bl3 = l - jlo2.at < 1700L;
            jlo2.shown.step(bl3 || !bl ? 1.0f : 0.0f, f);
            if (l - jlo2.at > 140L) {
                jlo2.flip.step(jlo2.on ? 1.0f : 0.0f, f);
            }
            boolean bl4 = bl ? jlo2.shown.get() <= 0.01f : (bl2 = this.jmp != jlr.ALERT && this.jmo.linear() >= 1.0f);
            if (bl3 || !bl2) continue;
            this.jmz.remove(i);
        }
    }

    private static float jof(jlo jlo2) {
        return 21.1f + izx.HEAD.width(jlo2.name) + 5.0f + izx.VALUE.width(jlo2.state) + 11.0f;
    }

    private float jog(long l) {
        float f = 17.0f;
        for (jlo jlo2 : this.jmz) {
            float f2 = jlx.jof(jlo2);
            f = Math.max(f, l - jlo2.at < 1700L ? f2 : f2 * jlo2.shown.get());
        }
        return f;
    }

    private float joh() {
        float f = 0.0f;
        for (jlo jlo2 : this.jmz) {
            f += jlo2.shown.get();
        }
        return Math.max(17.0f, 8.0f + f * 12.0f);
    }

    private void joi(DrawContext drawContext, float f, float f2) {
        float f3;
        long l = System.currentTimeMillis();
        float f4 = this.jog(l);
        float f5 = (f - f4) * 0.5f + 11.0f;
        float f6 = (f2 - this.joh()) * 0.5f + 4.0f;
        float f7 = vcq.clamp01(1.0f - Math.max(0.0f, f4 - f) / 6.0f);
        float f8 = izx.HEAD.capHeight() * 0.5f + 1.5f;
        int n = iov.accent();
        long l2 = 0L;
        for (jlo jlo2 : this.jmz) {
            float f9;
            float f10;
            l2 = Math.max(l2, jlo2.at);
            f3 = jlo2.shown.get();
            float f11 = f6 + 12.0f * f3 * 0.5f;
            f6 += 12.0f * f3;
            if (f3 <= 0.01f || (f10 = f7 * vcq.clamp01(1.0f - Math.max(0.0f, f9 = Math.max(2.5f - (f11 - f8), f11 + f8 - (f2 - 2.5f))) / 3.0f)) <= 0.01f) continue;
            float f12 = vcq.outCubic(f3);
            uut.pushAlpha(Math.min(1.0f, f3 * 1.4f) * f10);
            drawContext.getMatrices().pushMatrix();
            drawContext.getMatrices().translate(0.0f, (1.0f - f12) * 3.0f);
            float f13 = vcq.clamp01(jlo2.flip.get());
            float f14 = vcq.outBack(vcq.clamp01((float)(l - jlo2.at) / 320.0f));
            float f15 = f5 + 2.3f;
            if (f13 > 0.01f) {
                uut.circle(drawContext, f15, f11, 2.3f * (1.6f + 0.5f * f14), ujt.withAlpha(n, Math.round(46.0f * f13)));
            }
            uut.circle(drawContext, f15, f11, 2.3f * Math.max(0.2f, f14), ujt.lerp(iov.textMuted, n, f13));
            float f16 = f5 + 4.6f + 5.5f;
            f16 = izx.HEAD.draw(drawContext, jlo2.name, f16, izx.HEAD.centerTop(f11), iov.text) + 5.0f;
            izx.VALUE.draw(drawContext, jlo2.state, f16, izx.VALUE.centerTop(f11), ujt.lerp(iov.textMuted, n, f13));
            drawContext.getMatrices().popMatrix();
            uut.popAlpha();
        }
        float f17 = 1.0f - vcq.clamp01((float)(l - l2) / 1700.0f);
        if (l2 > 0L && f17 > 0.0f) {
            float f18 = Math.min(f2 * 0.5f, iov.r(11.0f));
            f3 = (f - f18 * 2.0f) * f17;
            uut.round(drawContext, (f - f3) * 0.5f, f2 - 1.6f, f3, 0.8f, 0.4f, ujt.withAlpha(n, 110));
        }
    }

    private void joj(DrawContext drawContext, float f, float f2, float f3) {
        float f4;
        float f5;
        jgd jgd2 = this.jna;
        if (jgd2 == null) {
            return;
        }
        float f6 = (f - 200.0f) * 0.5f;
        float f7 = (f2 - 44.0f) * 0.5f;
        float f8 = f6 + 7.0f;
        float f9 = f7 + 7.0f;
        float f10 = Math.min(15.0f, iov.r(6.0f));
        uok uok2 = this.jnc;
        float f11 = 0.9f + 0.1f * vcq.outCubic(this.jnd.get());
        drawContext.getMatrices().pushMatrix();
        drawContext.getMatrices().translate(f8 + 15.0f, f9 + 15.0f);
        drawContext.getMatrices().scale(f11, f11);
        uut.shadow(drawContext, -15.0f, -13.5f, 30.0f, 30.0f, f10, 5.0f, 0x70000000);
        if (uok2 != null) {
            uut.image(drawContext, uok2.view, -15.0f, -15.0f, 30.0f, 30.0f, f10, -1);
        } else {
            uut.round(drawContext, -15.0f, -15.0f, 30.0f, 30.0f, f10, iov.field);
            vjf.draw(drawContext, vhz.MUSIC, 0.0f, 0.0f, 13.0f, iov.textDim);
        }
        uut.outlineGradientV(drawContext, -15.0f, -15.0f, 30.0f, 30.0f, f10, 1.0f, 0x30FFFFFF, 0x8FFFFFF);
        drawContext.getMatrices().popMatrix();
        float f12 = f8 + 30.0f + 8.0f;
        float f13 = f6 + 200.0f - 8.0f;
        boolean bl = izx.pointer();
        float f14 = bl ? 40.0f : 17.0f;
        float f15 = f13 - f14 - 6.0f;
        jlx.jok(drawContext, izx.TITLE, jgd2.title(), f12, f7 + 12.0f, f15 - f12, iov.text);
        String string = jgd2.artist().isEmpty() ? jgd2.source() : jgd2.artist() + a.d("\u40c2\u3973\ub337\u2dd1\ua606", -1413652610, 1241194393) + jgd2.source();
        izx.SUB.draw(drawContext, izx.SUB.ellipsize(string, f15 - f12), f12, izx.SUB.centerTop(f7 + 22.0f), iov.textDim);
        float f16 = f7 + 34.0f;
        float f17 = jgd2.progress();
        String string2 = jlx.jol(jgd2.position());
        String string3 = jgd2.duration() > 0L ? jlx.jol(jgd2.duration()) : "";
        float f18 = izx.SMALL.width(string2);
        izx.SMALL.draw(drawContext, string2, f12, izx.SMALL.centerTop(f16), iov.textMuted);
        if (!string3.isEmpty()) {
            izx.SMALL.drawRight(drawContext, string3, f13, izx.SMALL.centerTop(f16), iov.textMuted);
            f5 = f12 + f18 + 5.0f;
            float f19 = f13 - izx.SMALL.width(string3) - 5.0f - f5;
            jeq.bar(drawContext, f5, f16 - 0.75f, f19, f17, iov.accent(), iov.accent2());
            if (f17 >= 0.0f) {
                f4 = f5 + f19 * f17;
                uut.shadow(drawContext, f4 - 2.0f, f16 - 1.6f, 4.0f, 4.0f, 2.0f, 1.5f, Integer.MIN_VALUE);
                uut.circle(drawContext, f4, f16, 2.0f, -1);
            }
        }
        if (bl) {
            f5 = f7 + 17.0f;
            this.jni = f5 - 6.0f;
            vhz[] vhzArray = new vhz[]{vhz.PREV, jgd2.playing() ? vhz.PAUSE : vhz.PLAY, vhz.NEXT};
            f4 = izx.localMouseX(this);
            float f20 = izx.localMouseY(this);
            for (int i = 0; i < 3; ++i) {
                boolean bl2;
                float f21;
                this.jnh[i] = f21 = f13 - 12.0f * (float)(3 - i) - 2.0f * (float)(2 - i);
                float f22 = this.jnf[i].step(f4 >= f21 && f4 < f21 + 12.0f && f20 >= this.jni && f20 < this.jni + 12.0f, f3);
                float f23 = 1.0f - 0.12f * this.jng[i].get();
                drawContext.getMatrices().pushMatrix();
                drawContext.getMatrices().translate(f21 + 6.0f, f5);
                drawContext.getMatrices().scale(f23, f23);
                boolean bl3 = bl2 = i == 1;
                if (bl2) {
                    uut.shadow(drawContext, -6.0f, -5.2f, 12.0f, 12.0f, 6.0f, 2.0f, 0x70000000);
                    uut.circle(drawContext, 0.0f, 0.0f, 6.0f, ujt.lerp(iov.accent(), -1, 0.12f * f22));
                } else if (f22 > 0.01f) {
                    uut.circle(drawContext, 0.0f, 0.0f, 6.0f, ujt.withAlpha(iov.hover, Math.min(255, Math.round((float)ujt.alpha(iov.hover) * 3.0f * f22))));
                }
                vjf.draw(drawContext, vhzArray[i], bl2 && !jgd2.playing() ? 0.6f : 0.0f, 0.0f, bl2 ? 6.5f : 7.0f, bl2 ? iov.onAccent() : ujt.lerp(iov.textDim, iov.text, f22));
                drawContext.getMatrices().popMatrix();
            }
        } else {
            this.jni = -100.0f;
            this.jod(drawContext, f13 - 6.0f - 3.6000001f, f7 + 17.0f, 4, 12.0f);
        }
    }

    private static void jok(DrawContext drawContext, vdn vdn2, String string, float f, float f2, float f3, int n) {
        float f4 = vdn2.width(string);
        float f5 = vdn2.centerTop(f2);
        if (f4 <= f3) {
            vdn2.draw(drawContext, string, f, f5, n);
            return;
        }
        float f6 = 24.0f;
        float f7 = 18.0f;
        float f8 = 1.6f;
        float f9 = (f4 + f6) / f7 + f8;
        float f10 = (float)((double)System.nanoTime() / 1.0E9 % (double)f9);
        float f11 = Math.max(0.0f, f10 - f8) * f7;
        uut.pushScissor(drawContext, f, f5 - 2.0f, f3, vdn2.height() + 4.0f);
        vdn2.draw(drawContext, string, f - f11, f5, n);
        vdn2.draw(drawContext, string, f - f11 + f4 + f6, f5, n);
        uut.popScissor(drawContext);
    }

    private static String jol(long l) {
        return vxu.clock(Math.max(0L, l / 1000L));
    }

    @Override
    boolean mouseClicked(float f, float f2, int n) {
        if (n != 0 || this.jmp != jlr.MUSIC || this.jni < -50.0f || f2 < this.jni || f2 >= this.jni + 12.0f) {
            return false;
        }
        String[] stringArray = new String[]{a.c(-76210768, "\u1dc4\u6477\ueeb3\u70d1"), a.d("\uf630\u8f9a\u0541\u9b30\u10ec\u9654", -1932836641, 552449693), a.c(1264873060, "\u6e0e\u17b4\u9d7a\u0307")};
        for (int i = 0; i < 3; ++i) {
            if (!(f >= this.jnh[i]) || !(f < this.jnh[i] + 12.0f)) continue;
            this.jng[i].set(1.0f);
            jgn.command(stringArray[i]);
            return true;
        }
        return false;
    }

    static {
        jml = a.d("\u479a\u3e09\ub4cd\u2aaf\ua167\u27da\u9d9b", 1448827076, 1952521993);
        FPS = new vkl(a.b("\u2961\u50c6\uda16", 1679108388), true);
        PING = new vkl(a.d("\uc46a\ubde2\u3736\ua94e", -1682029326, 396067020), true);
        TPS = new vkl(a.d("\ud30a\uaabf\u206f", -659267123, 1132507792), true);
        BPS = new vkl(a.c(2073813160, "\ue0e9\u994a\u139a"), true);
        COORDS = new vkl(a.d("\u0ad8\u7345\uf996\u67fa\uec3b\u6a87\ud0d3\u592d\uc767\u4dc7\uca02", -20895621, 105980651), true);
        TIME = new vkl(a.b("\ucd14\ub498\u3e4f\ua036", 1931791684), false);
        ACCOUNT = new vkl(a.c(1738676770, "\u1a64\u63f7\ue924\u7759\ufc94\u7a3e\uc077"), true);
        ALERTS = new vkl(a.b("\u1f12\u6698\uec43\u7232\uf9ee\u7f56\uc540\u4cf0\ud2a2\u581a\udfde\u25a9\uab79", 1326718795), true);
        ISLAND = List.of(ACCOUNT, FPS, PING, TPS, BPS, COORDS, TIME, ALERTS);
        MUSIC = new vkl(a.d("\u6ff2\u167b\u9cae\u02c5\u8918", 918243743, 1191716389), true);
        VIEW = new vlv(a.b("\u9e3a\ue7b4\u6d6b\uf308", -1132421528), a.d("\u0743\u7ede\uf40f\u6a63\ue1a5\u6716\udd52", -903719624, -2038148545), a.d("\ua4c2\udd5f\u578e\uc9e2\u4224\uc497\u7ed3", -1093632467, -337126741), a.c(-2002372180, "\u39ee\u406c\ucaa6\u54d7"));
        EXPAND = new vkl(a.d("\u297b\u50f7\uda2c\u444c\ucf94\u492f\uf338\u7a86\ue4d8\u6e27\ue9ba\u13c0\u9d05\u04e3\u8ee4\u0813\ub24f\u3d9c\ua727", -406075007, -1233461076), true);
        COVER = new vkl(a.d("\u96bf\uef22\u65e8\ufb8a\u704a", 1922162144, 787958553), true);
        MUSIC_SETTINGS = List.of(VIEW, EXPAND, COVER);
    }

    private static /* synthetic */ int aox(int n, int n2) {
        return n + n2 | 0xFC77DC4B;
    }

    private static /* synthetic */ int aoy(int n, int n2) {
        return jlx.aox(n, n2) * n2;
    }

    private static /* synthetic */ int aoz(int n, int n2) {
        return jlx.aoy(n, n2) + n;
    }
}

