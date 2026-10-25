/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
 *  net.fabricmc.fabric.api.event.client.player.ClientPlayerBlockBreakEvents
 *  net.fabricmc.fabric.api.event.player.AttackBlockCallback
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.option.KeyBinding
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Entity$RemovalReason
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.particle.ParticleEffect
 *  net.minecraft.particle.ParticleTypes
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.sound.SoundEvents
 *  net.minecraft.util.ActionResult
 *  net.minecraft.util.hit.EntityHitResult
 *  net.minecraft.util.math.Vec3d
 */
package a;

import a.dry;
import a.ejp;
import a.hhf;
import a.kfe;
import a.kmy;
import a.kwf;
import a.lfa;
import a.lqq;
import a.nfl;
import a.ovh;
import a.qof;
import a.szk;
import a.tck;
import a.tct;
import a.tcw;
import a.tiq;
import a.tkc;
import a.tkx;
import a.tmh;
import a.tmk;
import a.tmt;
import a.tnl;
import a.ttl;
import a.tyd;
import a.vxr;
import a.vza;
import a.vzz;
import flow.Flow;
import flow.dev.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.event.client.player.ClientPlayerBlockBreakEvents;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;

public final class tcz {
    private static final int tda = -789577728;
    private static final String[] tdb = new String[]{a.d("\ub834\uc1b4\u4b7f\ud50e\u5ecd\ud85a\u6217\uebc4\u759d", -788012186, 793074463), a.c(801353398, "\uaef8\ud778\u5db3\uc3c2\u4801\uce96\u74d8\ufd04\u6358\ue9f1"), a.d("\ub060\uc9e0\u432b\udd5a\u5699\ud00e\u6a41\ue381\u7dc3\uf76a", -877860424, -602449514), a.b("\ucb85\ub205\u38ce\ua6bf\u2d7c\uabeb\u11a3\u9863\u063a\u8c93", -1118712885)};
    private static final List<tkx> tdc = new ArrayList<tkx>();
    private static final Random tdd = new Random();
    private static tcw tde = tcw.NONE;
    private static tiq tdf;
    private static tkc tdg;
    private static ttl tdh;
    private static tyd tdi;
    private static kfe tdj;
    private static tkc tdk;
    private static ClientWorld tdl;
    private static Field tdm;
    private static boolean tdn;
    private static boolean tdo;
    private static volatile tct tdp;
    private static volatile tiq tdq;
    private static /* synthetic */ long tdr;
    private static /* synthetic */ boolean tds;

    private tcz() {
    }

    public static void install() {
        ClientTickEvents.START_CLIENT_TICK.register(tcz::tea);
        ClientTickEvents.END_CLIENT_TICK.register(tcz::teb);
        try {
            AttackBlockCallback.EVENT.register((playerEntity, world, hand, blockPos, direction) -> {
                ttl ttl2 = tdh;
                MinecraftClient minecraftClient = MinecraftClient.getInstance();
                if (ttl2 != null && world.isClient() && playerEntity == minecraftClient.player && !ejp.isActive()) {
                    ttl2.attack(minecraftClient, blockPos, direction);
                }
                return ActionResult.PASS;
            });
            ClientPlayerBlockBreakEvents.AFTER.register((clientWorld, clientPlayerEntity, blockPos, blockState) -> {
                ttl ttl2 = tdh;
                if (ttl2 != null && clientPlayerEntity == MinecraftClient.getInstance().player && !ejp.isActive()) {
                    ttl2.broken(blockState);
                }
            });
        }
        catch (Throwable throwable) {
            System.out.println(a.c(320079134, "\u0551\u7ce4\uf630\u684a\ue3d8\u653b\udf7f\u5688\uc8db\u4277\uc5b2\u3fce\ub11e\u28a6\ua2b2\u240b\u9e43\u1192\u8b25\u0d6c\u84c8\ufecc\u7064\uebba\u6dd2\ue714\u5eaf\ud0fb\u4a01\ucc53\u47ee\ub936\u3326\uaacd") + throwable);
        }
    }

    public static ttl mineRecorder() {
        return tdh;
    }

    public static tyd walkRecorder() {
        return tdi;
    }

    public static boolean walkGuide() {
        return tdi != null && !dry.armed();
    }

    public static void startWalking(tiq tiq2, String string) {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient.player == null || minecraftClient.world == null || tiq2 == null) {
            return;
        }
        tcz.stop();
        tcz.tdw();
        tdf = tiq2;
        tde = tcw.RECORD;
        tdl = minecraftClient.world;
        String string2 = a.b("\ua8ad\ud128\u5bfa\uc590\u4e7f\uc8f8\u72b8\ufb5f\u6501\uefbb", 1396812006).equals(string) ? a.b("\u2ecf\u574a\udd98\u43f2\uc81d\u4e9a\uf4da\u7d3d\ue363\u69d9", -1905250684) : a.d("\u25e7\u5c62\ud6b0\u48da\uc327\u45bd\uffe4", 613483270, 1031153319);
        tdi = new tyd(tiq2, string2, (float)tcz.unit(minecraftClient));
        kfe kfe2 = tcz.tee(string2);
        tdj = null;
        if (kfe2 != null && !kfe2.isEnabled()) {
            kfe2.setEnabled(true);
            tdj = kfe2;
        }
    }

    private static String tdt(MinecraftClient minecraftClient) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (minecraftClient.currentScreen != null) {
            return a.b("\u66fe\u1f5f\u959d\u0bfb\u802c\u0696", 1756063371);
        }
        if (!minecraftClient.isWindowFocused()) {
            return a.b("\u40d8\u3960\ub3bf\u2dd8\ua609", -1324400453);
        }
        if (!clientPlayerEntity.isAlive() || clientPlayerEntity.isSpectator()) {
            return a.b("\udac1\ua371\u29a6\ub7d2", -2033395039);
        }
        if (ovh.active()) {
            return a.d("\u33db\u4a7e\uc0ba\u5ecb\ud51a\u53a9\ue9f6", 1038296086, 1988040620);
        }
        return null;
    }

    public static boolean mining() {
        return tdh != null;
    }

    public static void startMining(tiq tiq2) {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient.player == null || minecraftClient.world == null || tiq2 == null) {
            return;
        }
        tcz.stop();
        tcz.tdw();
        tdf = tiq2;
        tde = tcw.RECORD;
        tdl = minecraftClient.world;
        tdh = new ttl(tiq2, (float)tcz.unit(minecraftClient));
    }

    private static String tdu(MinecraftClient minecraftClient) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (minecraftClient.currentScreen != null) {
            return a.d("\uca11\ub3b0\u3972\ua714\u2cc3\uaa79", -2106492669, -767773849);
        }
        if (!minecraftClient.isWindowFocused()) {
            return a.d("\u4c3a\u3582\ubf5d\u213a\uaaeb", 367600820, -1607833363);
        }
        if (!clientPlayerEntity.isAlive() || clientPlayerEntity.isSpectator()) {
            return a.c(-1806067046, "\u9afa\ue34a\u699d\uf7e9");
        }
        kfe kfe2 = tcz.tee(a.d("\u6ada\u135f\u998d\u07e7\u8c12\u0a87\ub0d3\u3929", -10262202, -87489579));
        if (nfl.busy() || kfe2 != null && kfe2.isEnabled()) {
            return a.b("\u915e\ue8fb\u6229\ufc43\u7796\uf123\u4b77\uc28d", -320958153);
        }
        if (lqq.busy()) {
            return a.c(-1481305268, "\u132c\u6a9a\ue05a\u7e34\uf5eb\u734d");
        }
        if (ovh.active()) {
            return a.d("\ud61a\uafbf\u257b\ubb0a\u30db\ub668\u0c37", -257904309, 1792370480);
        }
        if (!qof.holdsPickaxe(clientPlayerEntity)) {
            return a.c(1821855018, "\u4d5d\u34f5\ube2c\u2055\uab88\u2d20\u976e");
        }
        return null;
    }

    public static tcw mode() {
        return tde;
    }

    public static tiq sessionProfile() {
        return tdf;
    }

    public static tkc recorder() {
        return tdg;
    }

    public static tkc fightRecorder() {
        return tdk;
    }

    public static boolean recording() {
        return tde == tcw.RECORD || tdk != null;
    }

    public static boolean standsOut() {
        return tde != tcw.NONE;
    }

    public static List<tkx> stands() {
        return tdc;
    }

    public static tct job() {
        return tdp;
    }

    public static boolean training() {
        tct tct2 = tdp;
        return tct2 != null && !tct2.done;
    }

    public static void startRecording(tiq tiq2) {
        tcz.tdv(tiq2, tcw.RECORD);
    }

    public static void startTest(tiq tiq2) {
        tcz.tdv(tiq2, tcw.TEST);
    }

    private static void tdv(tiq tiq2, tcw tcw2) {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient.player == null || minecraftClient.world == null || tiq2 == null) {
            return;
        }
        tcz.stop();
        tcz.tdw();
        tdf = tiq2;
        tde = tcw2;
        tdl = minecraftClient.world;
        tcz.tdx(minecraftClient, tiq2);
        if (tcw2 == tcw.RECORD) {
            tdg = new tkc(tiq2, 0, minecraftClient.player.getEntityPos(), (float)tcz.unit(minecraftClient));
        }
    }

    public static void stop() {
        if (tdg != null) {
            tdg.finish();
            tdg = null;
        }
        if (tdh != null) {
            tdh.finish();
            tdh = null;
        }
        if (tdi != null) {
            tdi.finish();
            tdi = null;
            kfe kfe2 = tdj;
            tdj = null;
            if (kfe2 != null && kfe2.isEnabled()) {
                kfe2.setEnabled(false);
            }
        }
        tcz.tdy(MinecraftClient.getInstance());
        tde = tcw.NONE;
        tdf = null;
    }

    private static void tdw() {
        if (tdk != null) {
            tdk.finish();
            tdk = null;
        }
    }

    public static double unit(MinecraftClient minecraftClient) {
        double d = (Double)minecraftClient.options.getMouseSensitivity().getValue() * 0.6 + 0.2;
        return d * d * d * 8.0 * 0.15;
    }

    private static void tdx(MinecraftClient minecraftClient, tiq tiq2) {
        tcz.tdy(minecraftClient);
        int n = tiq2.standCount();
        for (int i = 0; i < n; ++i) {
            tkx tkx2 = new tkx(minecraftClient.world, tdb[i % tdb.length], tdd.nextLong(), tiq2.standMode(), tiq2.standNear(), tiq2.standFar(), tiq2.standSpeed());
            tkx2.setId(-789577728 - i);
            tkx2.equipStack(EquipmentSlot.HEAD, new ItemStack((ItemConvertible)Items.DIAMOND_HELMET));
            tkx2.equipStack(EquipmentSlot.CHEST, new ItemStack((ItemConvertible)Items.DIAMOND_CHESTPLATE));
            tkx2.equipStack(EquipmentSlot.LEGS, new ItemStack((ItemConvertible)Items.DIAMOND_LEGGINGS));
            tkx2.equipStack(EquipmentSlot.FEET, new ItemStack((ItemConvertible)Items.DIAMOND_BOOTS));
            tkx2.equipStack(EquipmentSlot.MAINHAND, new ItemStack((ItemConvertible)Items.DIAMOND_SWORD));
            tkx2.relocate(minecraftClient.player);
            minecraftClient.world.addEntity((Entity)tkx2);
            tdc.add(tkx2);
        }
    }

    private static void tdy(MinecraftClient minecraftClient) {
        if (minecraftClient.world != null && minecraftClient.world == tdl) {
            for (tkx tkx2 : tdc) {
                if (tkx2.isRemoved()) continue;
                minecraftClient.world.removeEntity(tkx2.getId(), Entity.RemovalReason.DISCARDED);
            }
        }
        tdc.clear();
    }

    public static boolean onAttack(PlayerEntity playerEntity, Entity entity, EntityHitResult entityHitResult) {
        Vec3d vec3d;
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (!(playerEntity instanceof ClientPlayerEntity)) {
            return false;
        }
        ClientPlayerEntity clientPlayerEntity = (ClientPlayerEntity)playerEntity;
        Vec3d vec3d2 = vec3d = entityHitResult != null ? entityHitResult.getPos() : entity.getBoundingBox().getCenter();
        if (entity instanceof tkx) {
            tkx tkx2 = (tkx)entity;
            if (tdg != null) {
                tdg.hit(entity, vec3d, clientPlayerEntity);
            }
            boolean bl = clientPlayerEntity.fallDistance > 0.0 && !clientPlayerEntity.isOnGround() && !clientPlayerEntity.isClimbing() && !clientPlayerEntity.isTouchingWater() && !clientPlayerEntity.isSprinting();
            tkx2.knock(clientPlayerEntity.getEntityPos(), clientPlayerEntity.isSprinting());
            clientPlayerEntity.resetTicksSince();
            if (minecraftClient.world != null) {
                minecraftClient.world.playSoundClient(tkx2.getX(), tkx2.getEyeY(), tkx2.getZ(), bl ? SoundEvents.ENTITY_PLAYER_ATTACK_CRIT : SoundEvents.ENTITY_PLAYER_ATTACK_STRONG, SoundCategory.PLAYERS, 0.8f, 0.95f + tdd.nextFloat() * 0.1f, false);
                minecraftClient.world.playSoundClient(tkx2.getX(), tkx2.getEyeY(), tkx2.getZ(), SoundEvents.ENTITY_PLAYER_HURT, SoundCategory.PLAYERS, 0.6f, 0.9f + tdd.nextFloat() * 0.2f, false);
                if (bl) {
                    minecraftClient.particleManager.addEmitter((Entity)tkx2, (ParticleEffect)ParticleTypes.CRIT);
                }
            }
            return true;
        }
        if (tdk != null && tcz.teg(clientPlayerEntity, entity)) {
            tdk.hit(entity, vec3d, clientPlayerEntity);
        }
        return false;
    }

    private static int tdz(MinecraftClient minecraftClient) {
        if (!tdn) {
            tdn = true;
            tdm = vxr.find(KeyBinding.class, a.d("\udd9a\ua420\u2ee2\ub0c9\u3b5d\ubde8\u07bc\u8e46\u101f\u9abf\u1d7f\ue709\u69cc\uf027\u7a39\ufcc7\u4685\uc946\u53f5\ud588\u5c13\u2641\ua8f6", -779239710, 1212900097), a.c(2048388231, "\ueceb\u9555\u1f8a\u81f2\u0a2d\u8ca7\u369a\ubf6c\u2133\uab85"), a.d("\u01a9", 978839039, -2096896994));
        }
        return Math.max(0, vxr.getInt(tdm, minecraftClient.options.attackKey, 0));
    }

    private static void tea(MinecraftClient minecraftClient) {
        int n;
        if (minecraftClient.player == null || minecraftClient.currentScreen != null) {
            return;
        }
        int n2 = n = tdg != null || tdk != null ? tcz.tdz(minecraftClient) : 0;
        if (n <= 0) {
            return;
        }
        if (tdg != null) {
            tdg.presses(n);
            tdg.aim(minecraftClient, tdc);
        }
        if (tdk != null) {
            tdk.presses(n);
            tdk.aim(minecraftClient, tcz.teh(minecraftClient));
        }
    }

    private static void teb(MinecraftClient minecraftClient) {
        Object object;
        Object object2;
        tct tct2;
        if ((tdh != null || tdi != null) && dry.armed()) {
            tcz.stop();
        }
        if ((tdh != null || tdi != null) && minecraftClient.world != null && minecraftClient.world != tdl) {
            tdl = minecraftClient.world;
        }
        if (minecraftClient.world != tdl && tde != tcw.NONE && tdh == null && tdi == null) {
            if (tdg != null) {
                tdg.finish();
                tdg = null;
            }
            tdc.clear();
            tde = tcw.NONE;
            tdf = null;
        }
        if (minecraftClient.player == null || minecraftClient.world == null) {
            tcz.tdw();
            return;
        }
        if (tde != tcw.NONE) {
            tcz.tec(minecraftClient);
        }
        if ((tct2 = tdp) != null && tct2.done && !tct2.applied) {
            tct2.applied = true;
            if (tct2.mineResult != null) {
                if (lfa.mineProfile() == null) {
                    lfa.activateMine(tct2.profile);
                }
            } else if (tct2.walkResult != null) {
                if (lfa.walkProfile() == null) {
                    lfa.activateWalk(tct2.profile);
                }
            } else if (tct2.result != null && tct2.aura && kwf.studioProfile() == null) {
                kwf.useStudio(tct2.profile);
            } else if (tct2.result != null && !tct2.aura && lfa.activeProfile() == null) {
                lfa.activate(tct2.profile);
            }
        }
        tcz.tei(minecraftClient);
        if (tdg != null) {
            object2 = tcz.ted(minecraftClient);
            if (object2 != null) {
                tdg.pause((String)object2);
            } else {
                tdg.tick(minecraftClient, tdc);
            }
        }
        if ((object2 = tdh) != null) {
            object = tcz.tdu(minecraftClient);
            if (object != null) {
                ((ttl)object2).pause((String)object);
            } else {
                ((ttl)object2).tick(minecraftClient);
            }
        }
        if ((object = tdi) != null) {
            String string = tcz.tdt(minecraftClient);
            if (string != null) {
                ((tyd)object).pause(string);
            } else {
                ((tyd)object).tick(minecraftClient);
            }
        }
        tcz.tef(minecraftClient);
    }

    private static void tec(MinecraftClient minecraftClient) {
        for (int i = 0; i < tdc.size(); ++i) {
            tkx tkx2 = tdc.get(i);
            if (!tkx2.isRemoved() && minecraftClient.world.getEntityById(tkx2.getId()) == tkx2) continue;
            tkx tkx3 = new tkx(minecraftClient.world, tdb[i % tdb.length], tdd.nextLong(), tdf.standMode(), tdf.standNear(), tdf.standFar(), tdf.standSpeed());
            tkx3.setId(-789577728 - i);
            for (EquipmentSlot equipmentSlot : EquipmentSlot.values()) {
                tkx3.equipStack(equipmentSlot, tkx2.getEquippedStack(equipmentSlot).copy());
            }
            tkx3.relocate(minecraftClient.player);
            minecraftClient.world.addEntity((Entity)tkx3);
            tdc.set(i, tkx3);
        }
    }

    private static String ted(MinecraftClient minecraftClient) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (minecraftClient.currentScreen != null) {
            return a.b("\u738b\u0a2a\u80e8\u1e8e\u9559\u13e3", -987335682);
        }
        if (!minecraftClient.isWindowFocused()) {
            return a.c(-239097764, "\ua83f\ud187\u5b58\uc53f\u4eee");
        }
        if (!clientPlayerEntity.isAlive() || clientPlayerEntity.isSpectator()) {
            return a.d("\ua5a9\udc19\u56ce\uc8ba", -382912701, -1206807926);
        }
        kfe kfe2 = tcz.tee(a.c(168907861, "\u541d\u2d84\ua753\u390e\ub2eb\u345a\u8e13\u07f8\u99a0"));
        if (kfe2 != null && kfe2.isEnabled()) {
            return a.b("\u7ffb\u0642\u8c95\u12e8\u992d\u1f9c\ua5d5\u2c3e\ub266", 1637842835);
        }
        if (kmy.busy()) {
            return a.d("\u0b3b\u7286\uf857\u6620", 549180726, 357097060);
        }
        return null;
    }

    private static kfe tee(String string) {
        Flow flow = Flow.getInstance();
        return flow.getModuleManager() == null ? null : flow.getModuleManager().getByName(string);
    }

    private static void tef(MinecraftClient minecraftClient) {
        boolean bl;
        tiq tiq2 = lfa.activeProfile();
        boolean bl2 = bl = tde == tcw.NONE && tiq2 != null && tiq2.fights() && !lfa.turning();
        if (!bl) {
            tcz.tdw();
            return;
        }
        if (tdk != null && tcz.tdk.profile != tiq2) {
            tcz.tdw();
        }
        if (tdk == null) {
            tdk = new tkc(tiq2, 1, minecraftClient.player.getEntityPos(), (float)tcz.unit(minecraftClient));
        }
        String string = tcz.ted(minecraftClient);
        List<Entity> list = tcz.teh(minecraftClient);
        if (string != null) {
            tdk.pause(string);
        } else if (list.isEmpty()) {
            tdk.pause(a.c(-516308133, "\uc336\uba8a\u3051\uae29"));
        } else {
            tdk.tick(minecraftClient, list);
        }
    }

    private static boolean teg(ClientPlayerEntity clientPlayerEntity, Entity entity) {
        PlayerEntity playerEntity;
        return entity instanceof PlayerEntity && (playerEntity = (PlayerEntity)entity) != clientPlayerEntity && playerEntity.isAlive() && !playerEntity.isSpectator() && !(entity instanceof tkx) && !hhf.protects((Entity)playerEntity);
    }

    private static List<Entity> teh(MinecraftClient minecraftClient) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (PlayerEntity playerEntity : minecraftClient.world.getPlayers()) {
            if (!tcz.teg(clientPlayerEntity, (Entity)playerEntity) || !(playerEntity.squaredDistanceTo((Entity)clientPlayerEntity) < 64.0)) continue;
            arrayList.add(playerEntity);
        }
        arrayList.sort(Comparator.comparingDouble(entity -> entity.squaredDistanceTo((Entity)clientPlayerEntity)));
        return arrayList.size() > 4 ? new ArrayList<Object>(arrayList.subList(0, 4)) : arrayList;
    }

    private static void tei(MinecraftClient minecraftClient) {
        boolean bl;
        int n = lfa.stopKey();
        boolean bl2 = bl = minecraftClient.currentScreen == null && n != -1 && vzz.isDown(minecraftClient, n);
        if (bl && !tdo && tde != tcw.NONE) {
            tcz.stop();
        }
        tdo = bl;
    }

    public static void train(tiq tiq2) {
        tct tct2;
        if (tcz.training() || tiq2 == null) {
            return;
        }
        if (tde == tcw.RECORD && tdf == tiq2) {
            tcz.stop();
        }
        if (tdk != null && tcz.tdk.profile == tiq2) {
            tdk.save();
        }
        tdp = tct2 = new tct(tiq2);
        if (tct2.mine) {
            tcz.tej(tct2);
            return;
        }
        if (tct2.walk) {
            tcz.tek(tct2);
            return;
        }
        Thread thread = new Thread(() -> {
            try {
                vza.flush();
                tct2.progress.phase = a.b("\u5c0a\u25b4\uaf64\u310f\ubac9", -1257022356);
                tiq2.loadRecordings(true);
                List<tmh> list = tiq2.tapes();
                if (list.isEmpty()) {
                    throw new tmt(a.c(1269784160, "\u5e0a\u27ba\uad68\u3312"));
                }
                tmk tmk2 = tiq2.trainerConfig();
                tmk2.track = tct2.aura;
                tmk2.dropOvershoot = !tct2.aura && tiq2.clean();
                tck tck2 = tnl.run(list, tmk2, tct2.progress);
                tiq2.saveModel(tck2, tct2.aura);
                tiq2.set(tct2.aura ? a.d("\u3034\u4991\uc345\u5d27\ud6bf\u5054\uea01\u63e3\ufdb4\u7702\uf0da\u0aaa", -1691500114, 695398903) : a.c(-1162083566, "\u0372\u7ac1\uf019\u6e69\ue5b7\u6344\ud94d\u50ba\ucef6\u444f\uc39b\u39e1\ub737"), tck2.created);
                tiq2.save();
                tct2.result = tck2;
            }
            catch (tmt tmt2) {
                tct2.error = tmt2.code;
            }
            catch (Throwable throwable) {
                tct2.error = a.c(2119501731, "\u07c3\u7e65\uf4b6\u6ada\ue110");
                System.out.println(a.d("\u5bfe\u2244\ua887\u36f1\ubd3b\u3bc5\u81c2\u0835\u9679\u1cc0\u9b14\u6162\uefb2\u760a\ufc1e\u7aa9\uc0e1\u4f38\ud58e\u53d6\uda20\ua02f\u2e86", 561938874, 783604285) + throwable);
                throwable.printStackTrace();
            }
            tct2.finished = System.currentTimeMillis();
            tct2.done = true;
        }, a.d("\u7519\u0c82\u8652\u183b\u93a9\u150a\uaf17\u26ed\ub8a2\u3214\ub5da\u4fe4\uc167\u58d0\ud290\u5469\uee21\u61fb\ufb5f", 1784547679, -265651181));
        thread.setDaemon(true);
        thread.setPriority(1);
        thread.start();
    }

    private static void tej(tct tct2) {
        tiq tiq2 = tct2.profile;
        Thread thread = new Thread(() -> {
            /*
             * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
             * 
             * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$TooOptimisticMatchException
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.getString(SwitchStringRewriter.java:404)
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.access$600(SwitchStringRewriter.java:53)
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$SwitchStringMatchResultCollector.collectMatches(SwitchStringRewriter.java:368)
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:24)
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.KleeneN.match(KleeneN.java:24)
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.MatchSequence.match(MatchSequence.java:26)
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:23)
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewriteComplex(SwitchStringRewriter.java:201)
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewrite(SwitchStringRewriter.java:73)
             *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:881)
             *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
             *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
             *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
             *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
             *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1050)
             *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
             *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
             *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
             *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
             *     at org.benf.cfr.reader.Main.main(Main.java:54)
             */
            throw new IllegalStateException("Decompilation failed");
        }, a.c(1464331003, "\uea9a\u932f\u19fb\u8781\u0c13\u8af6\u30a3\ub941\u2716\uada0\u2a78\ud01e"));
        thread.setDaemon(true);
        thread.setPriority(1);
        thread.start();
    }

    private static void tek(tct tct2) {
        tiq tiq2 = tct2.profile;
        Thread thread = new Thread(() -> {
            /*
             * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
             * 
             * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$TooOptimisticMatchException
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.getString(SwitchStringRewriter.java:404)
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.access$600(SwitchStringRewriter.java:53)
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$SwitchStringMatchResultCollector.collectMatches(SwitchStringRewriter.java:368)
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:24)
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.KleeneN.match(KleeneN.java:24)
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.MatchSequence.match(MatchSequence.java:26)
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:23)
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewriteComplex(SwitchStringRewriter.java:201)
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewrite(SwitchStringRewriter.java:73)
             *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:881)
             *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
             *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
             *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
             *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
             *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1050)
             *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
             *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
             *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
             *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
             *     at org.benf.cfr.reader.Main.main(Main.java:54)
             */
            throw new IllegalStateException("Decompilation failed");
        }, a.d("\u9a5a\ue3fd\u6923\uf755\u7cc9\ufa2c\u4079\uc99b\u57cc\udd7a\u5aa2\ua0c4", 435801118, -549366209));
        thread.setDaemon(true);
        thread.setPriority(1);
        thread.start();
    }

    public static boolean analyzing(tiq tiq2) {
        return tdq == tiq2;
    }

    public static void analyze(tiq tiq2) {
        if (tiq2 == null || tdq != null) {
            return;
        }
        String string = tiq2.dataStamp();
        if (string.equals(tiq2.get(a.c(1091782165, "\u467b\u3fcf\ub509\u2b6d\ua0f5\u2619\u9c4d\u15a9\u8bfa\u0156"), ""))) {
            return;
        }
        tdq = tiq2;
        Thread thread = new Thread(() -> {
            try {
                vza.flush();
                List<tmh> list = tiq2.tapes();
                szk szk2 = tiq2.aura() ? szk.track(list, false) : szk.build(list, tiq2.clean());
                tiq2.set(a.d("\u1efa\u674e\ued88\u73ec\uf874\u7e98\uc4d9\u4d24\ud366\u59cb\ude11\u2476", -626500076, 1636778118), szk2.stats.steps);
                tiq2.set(a.c(1008761909, "\u7c5a\u05ee\u8f28\u114c\u9ad4\u1c2d\ua674\u2f80\ub1d5\u3b6c\ubca7"), szk2.stats.flicks);
                tiq2.set(a.b("\ub912\uc0a6\u4a60\ud404\u5f9c\ud977\u6322\ueac0\u749d\ufe24\u79f5\u8383\u0d5d", 2140846459), szk2.stats.tracking);
                tiq2.set(a.d("\uc208\ubbbc\u317a\uaf1e\u2486\ua26f\u182f\u91c9\u0f90\u853c\u02e5\uf896\u764c", 225404567, -2075876106), szk2.stats.vertical);
                tiq2.set(a.b("\u43dd\u3a69\ub0af\u2ecb\ua553\u23b9\u99ec\u100b\u8e55", 1649886128), szk2.stats.usedHits);
                tiq2.set(a.c(-1253442422, "\ufce1\u8555\u0f93\u91f7\u1a6f\u9c9f\u26d5\uaf37\u317f\ubbcf\u3c07\uc671\u48a6\ud10c\u5b58"), szk2.stats.overshoots);
                tiq2.set(a.c(-761765962, "\u5fd8\u266c\uacaa\u32ce\ub956\u3fba\u85ee\u0c0a\u9259\u18f5"), string);
                tiq2.save();
            }
            catch (Throwable throwable) {
                System.out.println(a.c(-1807142355, "\u325f\u4be5\uc126\u5f50\ud49a\u5264\ue873\u6187\uffcd\u7569\uf2fb\u08cb\u8613\u1fad\u95f3\u1317\ua952\u2699\ubc30\u3a32\ub383\uc9d5\u476e\udcba\u5acc\ud01c\u69f1\ue7ba") + throwable);
            }
            finally {
                tdq = null;
            }
        }, a.b("\uf565\u8cfe\u062e\u9847\u13d5\u9576\u2f6b\ua691\u38de\ub268\u35a6\ucf98\u410e\ud8b0\u52ec\ud410\u6e4a\ue191\u7b38\ufd73", -1615596233));
        thread.setDaemon(true);
        thread.setPriority(1);
        thread.start();
    }

    public static void cancelTraining() {
        tct tct2 = tdp;
        if (tct2 != null && !tct2.done) {
            tct2.progress.cancel = true;
        }
    }

    private static /* synthetic */ int ckw(int n, int n2) {
        return n * n2 ^ 0x5A6BCA43;
    }

    private static /* synthetic */ int ckx(int n, int n2) {
        return n * n2 + -1809635349;
    }
}

