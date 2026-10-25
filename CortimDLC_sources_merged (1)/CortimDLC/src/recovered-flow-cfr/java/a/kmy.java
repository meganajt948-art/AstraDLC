/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.option.KeyBinding
 *  net.minecraft.client.util.InputUtil$Key
 *  net.minecraft.component.DataComponentTypes
 *  net.minecraft.component.type.AttackRangeComponent
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.mob.MobEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.PlayerInventory
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.item.MaceItem
 *  net.minecraft.util.hit.EntityHitResult
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 */
package a;

import a.hhf;
import a.kfa;
import a.kfe;
import a.kvz;
import a.lme;
import a.lmn;
import a.lnb;
import a.lng;
import a.lpc;
import a.lpp;
import a.lpy;
import a.nuo;
import a.ovh;
import a.oxw;
import a.tck;
import a.vkl;
import a.vmc;
import a.vxr;
import a.vyn;
import a.wdq;
import a.wdt;
import flow.dev.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttackRangeComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MaceItem;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class kmy
extends kfe {
    private static final int kmz = 10;
    private static final int kna = 1;
    private static final int knb = 3;
    private static final double knc = 0.05;
    private static final boolean knd = true;
    private static final int kne = 3;
    private static final Field knf = vxr.find(MinecraftClient.class, a.d("\u7d96\u042c\u8eee\u10c5\u9b51\u1de4\ua7b0\u2e4a\ub013\u3ab3\ubd73\u4705\uc9c0\u502b\uda35\u5ccb\ue689\u694a\uf3f9\u7584\ufc1f\u864c\u08fe", 1766787167, -810322512), a.d("\u1355\u6aeb\ue034\u7e4c\uf593\u7319\uc924\u40d3\ude8c\u543b", 1705560683, 1537530194), a.d("\u0cf3", -2017127155, 1556879798));
    private static kmy kng;
    private final vmc knh = this.add(new vmc(a.b("\u2343\u5ae9\ud03e\u4e31\uc598\u4356\uf906\u70f9", -113629334), 1.0, 0.3, 1.6, 0.05).percent());
    private final vmc kni = this.add(new vmc(a.c(397464573, "\ud7da\uae7b\u24af\ubad8\u317e\ub7b1\u0d9d"), 0.6, 0.0, 0.9, 0.05).percent());
    private final vmc knj = this.add(new vmc(a.d("\u4297\u3b0a\ub1a0\u2fd2\ua477\u22cb\u98e3\u116c\u8f44", 1686978973, 893191959), 3.0, 2.0, 3.0, 0.05).suffix(a.b("\u3801", -379307923)));
    private final vmc knk = this.add(new vmc(a.b("\u9985\ue010\u6ac6\uf0a4\u7b7d\uf9de\u43f4\uca0f\u542f\udee2\u5943\ua722\u2d96\ub450\u3e07\ub886\u02b9", -1993892472), 3.0, 1.5, 40.0, 0.5).suffix(a.c(-187357720, "\u2584")));
    private final vmc knl = this.add(new vmc(a.b("\u713e\u08a3\u827a\u1c70\u93c8\u1577\uab36\u22be\ubceb\u3625\ub18a\u4b89\uc14e\u5c9c\ud6b8\u504d\uea72\u65d3", 435713328), 40.0, 2.0, 60.0, 0.5).suffix(a.b("\u3958", -2037892812)));
    private final vkl knm = this.add(new vkl(a.c(1402713290, "\ub0d5\uc93e\u4395\udd9e\u5640"), true));
    private final vkl knn = this.add(new vkl(a.d("\udee0\ua742\u2d93\ub3ed\u3c25\ube89\u04d7\u8936\u1378\u99bb\u1e10\ue46a\u6abf\uf37f", -642277140, 1133476387), true));
    private final vkl kno = this.add(new vkl(a.d("\ue0c8\u995e\u13f8\u8df4\u065d\u80ed\u3ab0\ub72d\u2d13\ua7d8\u200e\uda03", -791007058, -576596872), true));
    private final vkl knp = this.add(new vkl(a.c(-1069338552, "\u344a\u4da9\uc702\u5978\ud2ad\u541e\uea5d\u67b3\uf9ed\u7323\uf48a\u0ef5\u8437\u1991\u93c5\u1544\uaf04\u20ae\uba19"), true));
    private final vkl knq = this.add(new vkl(a.b("\uee60\u9783\u1d28\u8352\u0887\u8e34\u3077\ubd94\u27d9\ua977\u2eab\ud4de\u5a08\uc3b1\u49e7\ucf16", -1743328671), false));
    private final vkl knr = this.add(new vkl(a.d("\u8fe4\uf67e\u7cde\ue2d1\u6902\uefb1", -1494324824, 1028776530), true));
    private final vkl kns = this.add(new vkl(a.b("\ud7c5\uae56\u248a\uba81", 1696256989), false));
    private final lnb knt = new lnb();
    private final lpy knu = new lpy();
    private final lng knv = new lng();
    private final wdt knw = new wdt();
    private final Random knx = new Random();
    private lpp kny;
    private LivingEntity knz;
    private int koa = 10;
    private int kob = -1;
    private int koc = -1;
    private int kod;
    private String koe = a.c(-21950159, "\u111d");
    private static final int kof = 0;
    private static final int kog = 1;
    private static final int koh = 2;
    private static ItemStack koi;
    private final vyn koj = new vyn();
    private boolean kok;
    private boolean kol;
    private int kom = -1;
    private int kon = -1;
    private int koo = 0;
    private boolean kop;
    private boolean koq;
    private int kor;
    private long kos;
    private boolean kot;
    private final vyn kou = new vyn();
    private boolean kov;
    private boolean kow;
    private int kox = -1;
    private int koy = -1;
    private int koz;
    private static /* synthetic */ String kpa;
    private static /* synthetic */ String kpb;

    public kmy() {
        super(a.d("\uff37\u86b2\u0c60\u920a\u19ff\u9f62\u2533\uacc4", 1216519042, -1916115716), a.d("\u93be\uea23\u60f2\ufe85\u7517\uf3f5\u49b8\uc045\u5e08\ud4a2\u5339\ua91c\u27d6\ube63\u3438\ub2c8\u08c3\u8746\u1dee\u9bf0\u125e\u6819\ue6b0\u7d66\ufb4b\u71dc\uc868\u4634\udcc3", -1802970944, -1741993170), kfa.COMBAT);
        kng = this;
        this.kno.visibleWhen(this.knn::get);
        this.knq.visibleWhen(this.knn::get);
    }

    public static boolean busy() {
        return kng != null && kng.isEnabled() && (kmy.kng.kny != null || !kmy.kng.knv.idle());
    }

    public static boolean takesWindMace() {
        return kng != null && kng.isEnabled() && kmy.kng.knp.get();
    }

    public static int strikes() {
        return kng == null ? 0 : kmy.kng.kod;
    }

    public static String debug() {
        if (kng == null) {
            return a.d("\u539c\u2a24\ua0f7", -1192130798, -1300310814);
        }
        lpp lpp2 = kmy.kng.kny;
        ClientPlayerEntity clientPlayerEntity = MinecraftClient.getInstance().player;
        String string = clientPlayerEntity == null ? "" : String.format(Locale.ROOT, a.c(-2091713341, "\ufcec\u850b\u0fc7\u91ba\u1a7f\u9c84\u26cf\uaf35\u3175\ubb93\u3c09\uc672\u48ae\ud100\u5b04"), Float.valueOf(kmy.kng.knv.serverYaw(clientPlayerEntity)), Float.valueOf(kmy.kng.knv.serverPitch(clientPlayerEntity)));
        return (lpp2 == null ? a.b("\uc2ff\ubb52\u318c\uaff2\u2476\ua294\u18c6\u9136\u0f62", -283721082) : a.c(430627158, "\ud923\ua08e\u2a50\ub42e\u3faa") + lpp2.tick() + (lpp2.crit() ? a.d("\u5cd9", 2031811795, 496279656) : "") + a.c(112238335, "\u9ed7\ue732\u6df4\uf396\u7854\ufee7\u44a5\ucd1d") + lpp2.target().getId() + String.format(Locale.ROOT, a.b("\u84ec\ufd1c\u77c7\ue9b2\u6235\ue49c\u5ec4\ud72a\u4922\uc3da\u4403\ube79\u30b1\ua957", -79985470), Float.valueOf(lpp2.yaw()), Float.valueOf(lpp2.pitch()))) + string + a.d("\ua094\ud968\u53bf\ucdd4\u4603\uc0fc", 1830141145, 741743723) + kmy.kng.koe + a.b("\ud059\ua9a7\u237d\ubd0c\u36ce\ub069\u0a2b\u8393", 599969905) + String.format(Locale.ROOT, a.c(-1347338979, "\u3d3c\u4486\uce4a\u506c"), kmy.kng.knv.offset()) + a.d("\u174d\u6eba\ue46e\u7a12\uf1c5\u7725", -121085666, 225408629) + String.format(Locale.ROOT, a.c(128587733, "\u17f4\u6e4e\ue481\u7aa4"), kmy.kng.knt.get()) + a.d("\u8f96\uf674\u7ca0\ue2d7\u691b\uefa8\u55f5\udc12\u4203", -1738929872, 1088915087) + kmy.kng.kod;
    }

    @Override
    protected void onEnable() {
        this.knt.reset();
        this.kny = null;
        this.knu.forget();
        this.knv.reset();
        this.koa = 10;
        this.kob = -1;
        this.koc = -1;
        this.kol = false;
        this.kom = -1;
        this.koo = 0;
        this.kok = this.mc.player != null && kmy.kpg(this.mc.player);
        this.kot = false;
        this.kox = -1;
        this.kow = false;
    }

    @Override
    protected void onDisable() {
        this.knv.end(this.mc.player);
        this.knv.reset();
        this.knw.release(this.mc);
        this.kny = null;
        this.knu.forget();
        this.kob = -1;
        if (this.kop) {
            this.koj.release(this.mc);
            this.kop = false;
        }
        this.kol = false;
        this.kom = -1;
        this.koo = 0;
        if (this.mc.player != null) {
            this.kpe(this.mc, this.mc.player, true);
        }
        this.kow = false;
        if (this.kov) {
            this.kou.release(this.mc);
            this.kov = false;
        }
    }

    @Override
    public void onStartTick(MinecraftClient minecraftClient) {
        lpp lpp2;
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (this.koo != 0 && !this.kop) {
            this.koj.hold(minecraftClient);
            this.kop = true;
        }
        if (this.kow && !this.kov && !this.kop && clientPlayerEntity != null) {
            this.kou.hold(minecraftClient);
            this.kov = true;
            this.koz = 0;
        }
        this.knv.mode(true, clientPlayerEntity);
        this.knv.begin(clientPlayerEntity);
        if (this.koa < 10) {
            ++this.koa;
        }
        if ((lpp2 = this.kny) == null || lpp2.tick() > 1) {
            this.kpo(clientPlayerEntity);
        }
        if (lpp2 == null || !this.kpq(minecraftClient, clientPlayerEntity)) {
            this.knw.release(minecraftClient);
            return;
        }
        if (lpp2.crit() && lpp2.tick() <= 1) {
            this.knw.hold(minecraftClient);
        } else {
            this.knw.release(minecraftClient);
        }
        if (lpp2.tick() == 0) {
            this.kpl(minecraftClient, clientPlayerEntity, lpp2);
        }
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        this.kpc(minecraftClient, clientPlayerEntity);
        this.kpd(minecraftClient, clientPlayerEntity);
    }

    private void kpc(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        Box box;
        this.kph(minecraftClient, clientPlayerEntity);
        this.knv.end(clientPlayerEntity);
        this.knv.newTick(clientPlayerEntity);
        this.knt.update(clientPlayerEntity);
        if (clientPlayerEntity.isOnGround()) {
            this.kot = false;
        }
        this.knv.use(tck.profile1(), this.knh.get());
        if (!this.kpq(minecraftClient, clientPlayerEntity)) {
            this.kny = null;
            this.knu.forget();
            if (!clientPlayerEntity.isAlive()) {
                this.knv.forget();
            } else {
                this.kpn(minecraftClient, clientPlayerEntity);
            }
            return;
        }
        double d = this.kpt(clientPlayerEntity);
        lpc lpc2 = new lpc(d, this.knm.get(), wdt.serverSprinting(clientPlayerEntity), true, this.kni.get(), this.knv.serverYaw(clientPlayerEntity), this.knv.serverPitch(clientPlayerEntity), this.knv.maxTurn(), this.knk.get(), Math.max(this.knl.get(), this.knk.get() + 0.5));
        this.kny = this.knu.plan(clientPlayerEntity, (World)minecraftClient.world, this.knt.get(), this.kpu(minecraftClient, clientPlayerEntity, d), this::kpp, lpc2);
        this.kpi(clientPlayerEntity);
        if (this.kny == null) {
            this.kpn(minecraftClient, clientPlayerEntity);
            return;
        }
        Box box2 = box = this.kny.tick() <= 3 ? this.kny.box() : this.kny.target().getBoundingBox();
        if (!this.knv.approach(minecraftClient, clientPlayerEntity, this.kny, box)) {
            this.kpn(minecraftClient, clientPlayerEntity);
        }
    }

    private void kpd(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        boolean bl;
        if (clientPlayerEntity == null) {
            return;
        }
        if (this.kov) {
            ++this.koz;
        }
        if (!(this.kox < 0 || this.kny != null && this.kny.tick() <= 1 && this.koz <= 8 && clientPlayerEntity.isAlive())) {
            this.kpe(minecraftClient, clientPlayerEntity, false);
        }
        this.kow = bl = this.kox < 0 && this.knn.get() && this.kny != null && this.kny.tick() <= 2 && clientPlayerEntity.isAlive() && this.kpr(clientPlayerEntity) < 0 && kmy.kpf(clientPlayerEntity) >= 0 && this.koo == 0;
        if (this.kov && this.kox < 0 && (!bl || this.koz > 8)) {
            this.kou.release(minecraftClient);
            this.kov = false;
        }
    }

    private void kpe(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, boolean bl) {
        if (this.kox < 0) {
            return;
        }
        PlayerInventory playerInventory = clientPlayerEntity.getInventory();
        if (clientPlayerEntity.isAlive() && kmy.kps(playerInventory.getStack(this.koy)) && wdq.canClick(clientPlayerEntity) && minecraftClient.currentScreen == null && (bl || vyn.serverIdle(clientPlayerEntity))) {
            wdq.swap(minecraftClient, this.kox, this.koy);
        }
        this.kox = -1;
        this.koy = -1;
    }

    private static int kpf(ClientPlayerEntity clientPlayerEntity) {
        PlayerInventory playerInventory = clientPlayerEntity.getInventory();
        for (int i = 9; i < 36; ++i) {
            if (!kmy.kps(playerInventory.getStack(i))) continue;
            return i;
        }
        return -1;
    }

    private static boolean kpg(ClientPlayerEntity clientPlayerEntity) {
        if (koi == null) {
            koi = new ItemStack((ItemConvertible)Items.WIND_CHARGE);
        }
        return clientPlayerEntity.getItemCooldownManager().isCoolingDown(koi);
    }

    private void kph(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        boolean bl;
        if (this.kop) {
            if (clientPlayerEntity.isAlive() && wdq.canClick(clientPlayerEntity) && vyn.serverIdle(clientPlayerEntity) && minecraftClient.currentScreen == null) {
                PlayerInventory playerInventory = clientPlayerEntity.getInventory();
                if (this.koo == 1 && kmy.kps(playerInventory.getStack(this.kom))) {
                    wdq.swap(minecraftClient, this.kom, this.kon);
                } else if (this.koo == 2 && kmy.kps(playerInventory.getStack(this.kon))) {
                    wdq.swap(minecraftClient, this.kom, this.kon);
                    this.kom = -1;
                } else {
                    this.kom = -1;
                }
            } else if (this.koo == 1) {
                this.kom = -1;
            }
            this.koj.release(minecraftClient);
            this.kop = false;
            this.koo = 0;
        }
        if ((bl = kmy.kpg(clientPlayerEntity)) && !this.kok && this.knp.get() && clientPlayerEntity.isAlive()) {
            this.kos = System.currentTimeMillis();
            this.koq = !clientPlayerEntity.isOnGround();
            this.kor = 0;
            if (this.kom < 0) {
                this.kol = true;
            }
        }
        this.kok = bl;
        if (!this.knp.get() && !this.knq.get() || !clientPlayerEntity.isAlive()) {
            this.kol = false;
            if (!clientPlayerEntity.isAlive()) {
                this.kom = -1;
            }
            return;
        }
        if (this.kol && this.koo == 0 && !oxw.busy() && !kvz.busy() && minecraftClient.currentScreen == null && wdq.canClick(clientPlayerEntity)) {
            this.kol = false;
            this.kpj(clientPlayerEntity);
        } else if (this.kom >= 0 && this.koo == 0) {
            boolean bl2;
            if (!clientPlayerEntity.isOnGround()) {
                this.koq = true;
                this.kor = 0;
            } else {
                ++this.kor;
            }
            long l = System.currentTimeMillis() - this.kos;
            boolean bl3 = this.koq && this.kor >= 2;
            boolean bl4 = bl2 = !this.koq && l > 1500L;
            if ((bl3 || bl2 || l > 8000L) && clientPlayerEntity.isOnGround() && this.kny == null) {
                this.kpk(clientPlayerEntity);
            }
        }
    }

    private void kpi(ClientPlayerEntity clientPlayerEntity) {
        if (!this.knq.get() || !this.knn.get() || this.kot || clientPlayerEntity.isOnGround() || this.kom >= 0 || this.kol || this.koo != 0 || clientPlayerEntity.getVelocity().y >= 0.0 || this.knt.get() < this.knk.get()) {
            return;
        }
        this.kot = true;
        if (kmy.kps(clientPlayerEntity.getMainHandStack())) {
            return;
        }
        this.kos = System.currentTimeMillis();
        this.koq = true;
        this.kor = 0;
        if (this.kpr(clientPlayerEntity) >= 0 || wdq.canClick(clientPlayerEntity)) {
            this.kpj(clientPlayerEntity);
        } else {
            this.kol = true;
        }
    }

    private void kpj(ClientPlayerEntity clientPlayerEntity) {
        int n;
        PlayerInventory playerInventory = clientPlayerEntity.getInventory();
        if (kmy.kps(playerInventory.getStack(n = playerInventory.getSelectedSlot()))) {
            return;
        }
        for (int i = 0; i < 36; ++i) {
            if (!kmy.kps(playerInventory.getStack(i))) continue;
            if (i < 9) {
                this.kom = i;
                this.kon = n;
                playerInventory.setSelectedSlot(i);
            } else {
                this.kom = i;
                this.kon = n;
                this.koo = 1;
            }
            return;
        }
    }

    private void kpk(ClientPlayerEntity clientPlayerEntity) {
        PlayerInventory playerInventory = clientPlayerEntity.getInventory();
        if (this.kom < 9) {
            if (playerInventory.getSelectedSlot() == this.kom && this.kon >= 0) {
                playerInventory.setSelectedSlot(this.kon);
            }
            this.kom = -1;
            return;
        }
        if (kmy.kps(playerInventory.getStack(this.kon)) && wdq.canClick(clientPlayerEntity)) {
            this.koo = 2;
        } else {
            this.kom = -1;
        }
    }

    private void kpl(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, lpp lpp2) {
        int n;
        PlayerInventory playerInventory = clientPlayerEntity.getInventory();
        int n2 = this.kpr(clientPlayerEntity);
        if (n2 < 0) {
            int n3 = n = this.knn.get() ? kmy.kpf(clientPlayerEntity) : -1;
            if (!(n >= 0 && this.kov && wdq.canClick(clientPlayerEntity) && vyn.serverIdle(clientPlayerEntity))) {
                this.koe = a.c(1514223336, "\u369f\u4f2a\uc5ef\u5b8f");
                return;
            }
            int n4 = playerInventory.getSelectedSlot();
            wdq.swap(minecraftClient, n, n4);
            this.kox = n;
            this.koy = n4;
            n2 = n4;
        }
        if (n2 != (n = playerInventory.getSelectedSlot())) {
            playerInventory.setSelectedSlot(n2);
            this.koc = n2;
            if (this.kno.get() && this.kob < 0) {
                this.kob = n;
            }
        }
        minecraftClient.gameRenderer.updateCrosshairTarget(1.0f);
        if (!kmy.kpm(minecraftClient, lpp2)) {
            Vec3d vec3d = this.knu.aimNow((World)minecraftClient.world, clientPlayerEntity, lpp2.target(), this.kpt(clientPlayerEntity));
            if (vec3d == null) {
                vec3d = lpp2.aim();
            }
            Vec3d vec3d2 = clientPlayerEntity.getEyePos();
            this.knv.snap(minecraftClient, clientPlayerEntity, lme.yaw(vec3d2, vec3d), lme.pitch(vec3d2, vec3d));
            minecraftClient.gameRenderer.updateCrosshairTarget(1.0f);
        }
        String string = !kmy.kpm(minecraftClient, lpp2) ? a.b("\u6091\u1928\u93ff", -2145361677) : (!kmy.kpw(minecraftClient, clientPlayerEntity) ? a.c(-825155715, "\u1f18\u66a2\uec78\u721a\uf9d8\u7f6b") : (this.koe = this.knt.get() <= this.knu.path().threshold() || clientPlayerEntity.isOnGround() ? a.c(-1580107221, "\u7a49\u03ff\u8921\u1750") : a.d("\u3ca9", -1090070510, -339811177)));
        if (!a.d("\u7d35", 671782830, 1383918263).equals(this.koe)) {
            return;
        }
        KeyBinding.onKeyPressed((InputUtil.Key)KeyBindingHelper.getBoundKeyOf((KeyBinding)minecraftClient.options.attackKey));
        this.knv.hit(1 + this.knx.nextInt(3));
        this.knt.landed();
        this.knz = lpp2.target();
        this.koa = 0;
        ++this.kod;
        this.kny = null;
        this.knu.hit();
        this.knw.release(minecraftClient);
    }

    private static boolean kpm(MinecraftClient minecraftClient, lpp lpp2) {
        EntityHitResult entityHitResult;
        HitResult hitResult = minecraftClient.crosshairTarget;
        return hitResult instanceof EntityHitResult && (entityHitResult = (EntityHitResult)hitResult).getEntity() == lpp2.target();
    }

    private void kpn(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        this.knv.home(minecraftClient, clientPlayerEntity);
    }

    private void kpo(ClientPlayerEntity clientPlayerEntity) {
        if (this.kob < 0) {
            return;
        }
        PlayerInventory playerInventory = clientPlayerEntity.getInventory();
        if (playerInventory.getSelectedSlot() == this.koc) {
            playerInventory.setSelectedSlot(this.kob);
        }
        this.kob = -1;
        this.koc = -1;
    }

    private int kpp(LivingEntity livingEntity) {
        int n = livingEntity == this.knz ? 10 - this.koa - 1 : 0;
        return Math.max(livingEntity.hurtTime, n);
    }

    private boolean kpq(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        return minecraftClient.currentScreen == null && clientPlayerEntity.isAlive() && !clientPlayerEntity.isSpectator() && !clientPlayerEntity.isUsingItem() && !clientPlayerEntity.isRiding() && !ovh.active() && !oxw.busy() && !kvz.busy() && !nuo.busy() && (minecraftClient.interactionManager == null || !minecraftClient.interactionManager.isBreakingBlock()) && (this.kpr(clientPlayerEntity) >= 0 || this.kox >= 0 || this.knn.get() && kmy.kpf(clientPlayerEntity) >= 0) && lmn.environment(clientPlayerEntity, (World)minecraftClient.world);
    }

    private int kpr(ClientPlayerEntity clientPlayerEntity) {
        PlayerInventory playerInventory = clientPlayerEntity.getInventory();
        if (kmy.kps(clientPlayerEntity.getMainHandStack())) {
            return playerInventory.getSelectedSlot();
        }
        if (!this.knn.get()) {
            return -1;
        }
        for (int i = 0; i < PlayerInventory.getHotbarSize(); ++i) {
            if (!kmy.kps(playerInventory.getStack(i))) continue;
            return i;
        }
        return -1;
    }

    private static boolean kps(ItemStack itemStack) {
        return itemStack.isOf(Items.MACE) || itemStack.getItem() instanceof MaceItem;
    }

    private double kpt(ClientPlayerEntity clientPlayerEntity) {
        int n = this.kpr(clientPlayerEntity);
        if (n < 0 && this.knn.get()) {
            n = kmy.kpf(clientPlayerEntity);
        }
        ItemStack itemStack = n >= 0 ? clientPlayerEntity.getInventory().getStack(n) : clientPlayerEntity.getMainHandStack();
        AttackRangeComponent attackRangeComponent = (AttackRangeComponent)itemStack.get(DataComponentTypes.ATTACK_RANGE);
        double d = attackRangeComponent != null ? (double)attackRangeComponent.getEffectiveMaxRange((Entity)clientPlayerEntity) : clientPlayerEntity.getEntityInteractionRange();
        return Math.min(this.knj.get(), d) - 0.05;
    }

    private List<LivingEntity> kpu(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, double d) {
        double d2 = Math.max(4.0, Math.abs(Math.min(0.0, clientPlayerEntity.getVelocity().y)) * 16.0 + 8.0);
        Box box = clientPlayerEntity.getBoundingBox().stretch(0.0, -d2, 0.0).expand(d + 2.5);
        ArrayList<LivingEntity> arrayList = new ArrayList<LivingEntity>();
        for (Entity entity2 : minecraftClient.world.getOtherEntities((Entity)clientPlayerEntity, box, entity -> this.kpv(clientPlayerEntity, (Entity)entity))) {
            arrayList.add((LivingEntity)entity2);
        }
        return arrayList;
    }

    private boolean kpv(ClientPlayerEntity clientPlayerEntity, Entity entity) {
        LivingEntity livingEntity;
        if (!(entity != clientPlayerEntity && entity instanceof LivingEntity && (livingEntity = (LivingEntity)entity).isAlive() && entity.isAttackable())) {
            return false;
        }
        if (entity instanceof PlayerEntity) {
            PlayerEntity playerEntity = (PlayerEntity)entity;
            return this.knr.get() && !playerEntity.isSpectator() && !hhf.protects((Entity)playerEntity);
        }
        return this.kns.get() && entity instanceof MobEntity;
    }

    private static boolean kpw(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        if (vxr.getInt(knf, minecraftClient, 0) > 0) {
            return false;
        }
        ItemStack itemStack = clientPlayerEntity.getMainHandStack();
        if (clientPlayerEntity.isBelowMinimumAttackCharge(itemStack, 0)) {
            return false;
        }
        AttackRangeComponent attackRangeComponent = (AttackRangeComponent)itemStack.get(DataComponentTypes.ATTACK_RANGE);
        return attackRangeComponent == null || attackRangeComponent.isWithinRange((LivingEntity)clientPlayerEntity, minecraftClient.crosshairTarget.getPos());
    }

    private static /* synthetic */ int att(int n, int n2) {
        return n ^ n2 | 0x37FEDC1A;
    }
}

