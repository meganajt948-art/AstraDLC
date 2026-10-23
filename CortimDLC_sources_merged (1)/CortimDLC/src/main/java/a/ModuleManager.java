/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.ints.Int2BooleanOpenHashMap
 *  it.unimi.dsi.fastutil.ints.IntLinkedOpenHashSet
 *  it.unimi.dsi.fastutil.ints.IntListIterator
 *  it.unimi.dsi.fastutil.ints.IntOpenHashSet
 *  net.minecraft.class_310
 */
package a;

import a.hzq;
import a.HotkeyStore;
import a.ModuleCategory;
import a.Module;
import a.AimAssist;
import a.AutoMace;
import a.TotemSwap;
import a.AutoTotem;
import a.KeyPearl;
import a.AutoMine;
import a.NoFriendDamage;
import a.AutoCrits;
import a.AncientFarmer;
import a.ChatPlus;
import a.SoundsModule;
import a.NameProtect;
import a.FpsLimiter;
import a.AncientDebrisEsp;
import a.AutoSprint;
import a.DragonFly;
import a.CtrlSprint;
import a.NoJumpDelay;
import a.ContainerSearch;
import a.AutoTpAccept;
import a.AutoArmor;
import a.AutoCollector;
import a.AutoEnd;
import a.AutoMines;
import a.AuctionSellerAlt;
import a.AutoMend;
import a.AutoWarden;
import a.BotsModule;
import a.AutoLoot;
import a.InventorySorter;
import a.ChestStealer;
import a.ElytraSwap;
import a.AutoRepair;
import a.FreeCam;
import a.ItemScroller;
import a.ServerHelper;
import a.ShulkerPreview;
import a.StructureTimers;
import a.SmoothUi;
import a.RangeIndicator;
import a.AspectRatio;
import a.OreEsp;
import a.BlockOutline;
import a.TimeChanger;
import a.Freelook;
import a.Fullbright;
import a.HitColor;
import a.Nametags;
import a.ItemPhysics;
import a.TargetRing;
import a.MobEsp;
import a.MotionBlur;
import a.HealthBar;
import a.NoRender;
import a.PlayerEsp;
import a.ColorGrading;
import a.Trajectories;
import a.EnchantGlow;
import a.SkyShader;
import a.SeeInvisible;
import a.KillEffects;
import a.HandAnimations;
import a.HitParticles;
import a.TransparentFriends;
import a.ItemTransform;
import a.SnowRender;
import a.WardenTimers;
import a.SeasonWeather;
import a.MusicAnchor;
import a.Zoom;
import a.KeySetting;
import a.Setting;
import a.KeyUtil;
import a.Lang;
import it.unimi.dsi.fastutil.ints.Int2BooleanOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntLinkedOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntListIterator;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.class_310;

public class ModuleManager {
    private final List<Module> kfy = new ArrayList<Module>();
    private final Int2BooleanOpenHashMap kfz = new Int2BooleanOpenHashMap();
    private final IntLinkedOpenHashSet kga = new IntLinkedOpenHashSet();
    private final IntLinkedOpenHashSet kgb = new IntLinkedOpenHashSet();
    private final IntOpenHashSet kgc = new IntOpenHashSet();
    private static boolean kgd;
    private final Freelook kge = new Freelook();
    private static /* synthetic */ String kgf;
    private static /* synthetic */ String kgg;

    public ModuleManager() {
        this.kgh(this.kge);
        this.kgh(new CtrlSprint());
        this.kgh(new AutoCrits());
        this.kgh(new AutoMace());
        this.kgh(new AimAssist());
        this.kgh(new AutoMine());
        this.kgh(new TotemSwap());
        this.kgh(new AutoTotem());
        this.kgh(new NoFriendDamage());
        this.kgh(new NoJumpDelay());
        this.kgh(new AutoSprint());
        this.kgh(new DragonFly());
        this.kgh(new NoRender());
        this.kgh(new HealthBar());
        this.kgh(new Nametags());
        this.kgh(new HitParticles());
        this.kgh(new Trajectories());
        this.kgh(new RangeIndicator());
        this.kgh(new BlockOutline());
        this.kgh(new OreEsp());
        this.kgh(new PlayerEsp());


        this.kgh(new SeeInvisible());
        this.kgh(new TargetRing());
        this.kgh(new MusicAnchor());

        this.kgh(new ItemTransform());
        this.kgh(new HandAnimations());
        this.kgh(new EnchantGlow());
        this.kgh(new HitColor());
        this.kgh(new Fullbright());
        this.kgh(new TimeChanger());
        this.kgh(new SkyShader());
        this.kgh(new SeasonWeather());
        this.kgh(new SnowRender());

        this.kgh(new ColorGrading());
        this.kgh(new ItemPhysics());
        this.kgh(new SmoothUi());
        this.kgh(new Zoom());
        this.kgh(new AspectRatio());
        this.kgh(new StructureTimers());
        this.kgh(new FreeCam());
        this.kgh(new AutoMend());
        this.kgh(new AutoMines());
        this.kgh(new AncientDebrisEsp());

        this.kgh(new AutoRepair());
        this.kgh(new AutoArmor());
        this.kgh(new ElytraSwap());
        this.kgh(new ItemScroller());
        this.kgh(new ShulkerPreview());

        this.kgh(new AutoLoot());

        this.kgh(new AutoTpAccept());
        this.kgh(new AutoCollector());
        this.kgh(new AuctionSellerAlt());
        this.kgh(new ContainerSearch());
        this.kgh(new AutoEnd());
        AutoWarden nxa2 = new AutoWarden();
        nxa2.registerAsMain();
        this.kgh(nxa2);
        this.kgh(new WardenTimers());
        this.kgh(new BotsModule());
        this.kgh(new KeyPearl());
        this.kgh(new SoundsModule());
        this.kgh(new ChatPlus());
        this.kgh(new NameProtect());
        this.kgh(new FpsLimiter());
        this.kgh(new ServerHelper());
    }

    private void kgh(Module kfe2) {
        this.kfy.add(kfe2);
    }

    public List<Module> getModules() {
        return this.kfy;
    }

    public List<Module> getByCategory(ModuleCategory kfa2) {
        ArrayList<Module> arrayList = new ArrayList<Module>();
        for (Module kfe2 : this.kfy) {
            if (kfe2.getCategory() != kfa2) continue;
            arrayList.add(kfe2);
        }
        return arrayList;
    }

    public <T extends Module> T get(Class<T> clazz) {
        for (Module kfe2 : this.kfy) {
            if (!clazz.isInstance(kfe2)) continue;
            return (T)((Module)clazz.cast(kfe2));
        }
        return null;
    }

    public Module getByName(String string) {
        for (Module kfe2 : this.kfy) {
            if (!kfe2.getName().equalsIgnoreCase(string)) continue;
            return kfe2;
        }
        return null;
    }

    public void onStartTick(class_310 class_3102) {
        for (Module kfe2 : this.kfy) {
            if (!kfe2.isEnabled() && !kfe2.ticksWhenOff()) continue;
            kfe2.onStartTick(class_3102);
        }
    }

    public void onEndTick(class_310 class_3102) {
        for (Module kfe2 : this.kfy) {
            if (!kfe2.isEnabled() && !kfe2.ticksWhenOff() || kfe2 == this.kge) continue;
            kfe2.onEndTick(class_3102);
        }
        if (this.kge.isEnabled()) {
            this.kge.onEndTick(class_3102);
        }
    }

    public void onWorldRender(class_310 class_3102) {
        for (Module kfe2 : this.kfy) {
            if (!kfe2.isEnabled()) continue;
            kfe2.onWorldRender(class_3102);
        }
        for (Module kfe2 : this.kfy) {
            if (!kfe2.isEnabled()) continue;
            kfe2.onWorldRenderLate(class_3102);
        }
        for (Module kfe2 : this.kfy) {
            if (!kfe2.isEnabled()) continue;
            kfe2.onWorldRenderFinal(class_3102);
        }
    }

    public void pollKeys(class_310 class_3102) {
        if (class_3102.method_22683() == null) {
            return;
        }
        IntLinkedOpenHashSet intLinkedOpenHashSet = this.kgb;
        intLinkedOpenHashSet.clear();
        for (Module object : this.kfy) {
            intLinkedOpenHashSet.add(object.getKey());
            if (!object.isEnabled()) continue;
            for (Setting vmo2 : object.getSettings()) {
                if (!(vmo2 instanceof KeySetting)) continue;
                KeySetting vlq2 = (KeySetting)vmo2;
                intLinkedOpenHashSet.add(vlq2.get());
            }
        }
        for (hzq hzq2 : HotkeyStore.ALL) {
            intLinkedOpenHashSet.add(hzq2.key());
        }
        intLinkedOpenHashSet.remove(-1);
        Iterator<Object> iterator = intLinkedOpenHashSet.iterator();
        while (iterator.hasNext()) {
            int n = iterator.nextInt();
            boolean bl = KeyUtil.isDown(class_3102, n);
            boolean bl2 = this.kfz.put(n, bl);
            if (!bl || bl2) continue;
            this.kga.add(n);
        }
    }

    public void onKeys(class_310 class_3102) {
        this.pollKeys(class_3102);
        IntListIterator intListIterator = this.kga.iterator();
        while (intListIterator.hasNext()) {
            int n = intListIterator.nextInt();
            for (Module kfe2 : this.kfy) {
                if (kfe2.getKey() != n) continue;
                kfe2.toggle();
            }
            boolean bl = this.kgc.contains(n);
            for (Module kfe3 : this.kfy) {
                if (!kfe3.isEnabled() || !ModuleManager.kgi(kfe3, n) || bl && kfe3.keysAtStart()) continue;
                kfe3.onKey(class_3102, n);
            }
            HotkeyStore.run(n);
        }
        this.kga.clear();
        this.kgc.clear();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void onStartKeys(class_310 class_3102) {
        this.pollKeys(class_3102);
        if (this.kga.isEmpty()) {
            return;
        }
        kgd = true;
        try {
            IntListIterator intListIterator = this.kga.iterator();
            while (intListIterator.hasNext()) {
                int n = intListIterator.nextInt();
                if (this.kgc.contains(n)) continue;
                for (Module kfe2 : this.kfy) {
                    if (!kfe2.keysAtStart() || !kfe2.isEnabled() || !ModuleManager.kgi(kfe2, n)) continue;
                    this.kgc.add(n);
                    kfe2.onKey(class_3102, n);
                }
            }
        }
        finally {
            kgd = false;
        }
    }

    public static boolean startPhase() {
        return kgd;
    }

    private static boolean kgi(Module kfe2, int n) {
        for (Setting vmo2 : kfe2.getSettings()) {
            KeySetting vlq2;
            if (!(vmo2 instanceof KeySetting) || (vlq2 = (KeySetting)vmo2).get() != n) continue;
            return true;
        }
        return false;
    }

    public void dropKeys() {
        this.kga.clear();
        this.kgc.clear();
    }

    static {
        Lang.get();
    }

    private static /* synthetic */ int ate(int n, int n2) {
        return n - n2 + 821234885;
    }
}

