/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.PlayerInventory
 *  net.minecraft.item.ItemStack
 *  net.minecraft.screen.ScreenHandler
 *  net.minecraft.screen.slot.Slot
 *  net.minecraft.screen.slot.SlotActionType
 *  net.minecraft.util.math.MathHelper
 */
package a;

import a.ply;
import a.plz;
import a.pmc;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Predicate;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.math.MathHelper;

public final class pmf {
    private static final int pmg = 6;
    private final Predicate<ItemStack> pmh;
    private final PlayerInventory pmi;
    private final Random pmj;
    private final int pmk;
    private plz pml = plz.PICK;
    private int pmm;
    private int pmn;
    private int pmo;
    private int pmp;
    private int pmq;
    private long pmr;
    private boolean pms;
    private static /* synthetic */ long pmt;
    private static /* synthetic */ long pmu;

    private pmf(Predicate<ItemStack> predicate, PlayerInventory playerInventory, Random random, int n, int n2, int n3) {
        this.pmh = predicate;
        this.pmi = playerInventory;
        this.pmj = random;
        this.pmk = Math.max(1, n);
        this.pmm = n2;
        this.pmn = n3;
    }

    public static pmf plan(ScreenHandler screenHandler, PlayerInventory playerInventory, Predicate<ItemStack> predicate, int n, Random random, long l) {
        int n2 = pmf.pmz(screenHandler, playerInventory, predicate, random);
        if (n2 == -1) {
            return null;
        }
        int n3 = pmf.pna(screenHandler, playerInventory, ((Slot)screenHandler.slots.get(n2)).getStack(), random);
        if (n3 == -1) {
            return null;
        }
        pmf pmf2 = new pmf(predicate, playerInventory, random, n, n2, n3);
        pmf2.pmr = l + pmf.travelDelay(random);
        return pmf2;
    }

    public pmc drive(ScreenHandler screenHandler, long l, ply ply2) {
        if (this.pml == plz.DONE) {
            return this.pms ? pmc.GAVE_UP : pmc.DONE;
        }
        if (l < this.pmr) {
            return pmc.WAIT;
        }
        if (this.pmq > this.pmk + 2 + 6) {
            if (screenHandler.getCursorStack().isEmpty() || this.pmp >= 8) {
                return this.pmv(true);
            }
            ++this.pmp;
            this.pml = plz.RETURN;
        }
        ItemStack itemStack = screenHandler.getCursorStack();
        switch (this.pml.ordinal()) {
            case 0: {
                if (!itemStack.isEmpty()) {
                    this.pml = plz.RETURN;
                    return pmc.WAIT;
                }
                if (!this.pmx(screenHandler, this.pmm)) {
                    this.pmm = pmf.pmz(screenHandler, this.pmi, this.pmh, this.pmj);
                    if (this.pmm == -1) {
                        return this.pmv(true);
                    }
                }
                int n = ((Slot)screenHandler.slots.get(this.pmm)).getStack().getCount();
                this.pmw(ply2, this.pmm, 0, l);
                this.pml = n <= this.pmk ? plz.PLACE_ALL : plz.PLACE_ONE;
                return pmc.CLICKED;
            }
            case 1: 
            case 2: {
                if (itemStack.isEmpty()) {
                    if (++this.pmp > 2) {
                        return this.pmv(true);
                    }
                    this.pml = plz.PICK;
                    this.pmr = l + pmf.clickDelay(this.pmj);
                    return pmc.WAIT;
                }
                if (!this.pmh.test(itemStack)) {
                    this.pml = plz.RETURN;
                    return pmc.WAIT;
                }
                if (!pmf.pmy(screenHandler, this.pmi, this.pmn, itemStack)) {
                    this.pmn = pmf.pna(screenHandler, this.pmi, itemStack, this.pmj);
                    if (this.pmn == -1) {
                        this.pml = plz.RETURN;
                        return pmc.WAIT;
                    }
                }
                if (this.pml == plz.PLACE_ALL) {
                    this.pmw(ply2, this.pmn, 0, l);
                    this.pml = plz.VERIFY;
                    this.pmr = l + pmf.settleDelay(this.pmj);
                } else {
                    this.pmw(ply2, this.pmn, 1, l);
                    if (++this.pmo >= this.pmk) {
                        this.pml = plz.RETURN;
                    }
                }
                return pmc.CLICKED;
            }
            case 3: {
                if (itemStack.isEmpty()) {
                    this.pml = plz.VERIFY;
                    this.pmr = l + pmf.settleDelay(this.pmj);
                    return pmc.WAIT;
                }
                int n = pmf.stashSlot(screenHandler, this.pmi, itemStack, this.pmm);
                if (n == -1) {
                    return this.pmv(true);
                }
                this.pmw(ply2, n, 0, l);
                this.pml = plz.VERIFY;
                this.pmr = l + pmf.settleDelay(this.pmj);
                return pmc.CLICKED;
            }
            case 4: {
                if (!itemStack.isEmpty()) {
                    if (++this.pmp > 3) {
                        return this.pmv(true);
                    }
                    this.pml = plz.RETURN;
                    this.pmr = l + pmf.clickDelay(this.pmj);
                    return pmc.WAIT;
                }
                return this.pmv(false);
            }
        }
        return this.pmv(true);
    }

    public void abort() {
        if (this.pml != plz.DONE) {
            this.pml = plz.RETURN;
            this.pmr = 0L;
        }
    }

    public boolean isDone() {
        return this.pml == plz.DONE;
    }

    private pmc pmv(boolean bl) {
        this.pml = plz.DONE;
        this.pms = bl;
        return bl ? pmc.GAVE_UP : pmc.DONE;
    }

    private void pmw(ply ply2, int n, int n2, long l) {
        ply2.click(n, n2, SlotActionType.PICKUP);
        ++this.pmq;
        this.pmr = l + pmf.clickDelay(this.pmj);
    }

    private boolean pmx(ScreenHandler screenHandler, int n) {
        if (n < 0 || n >= screenHandler.slots.size()) {
            return false;
        }
        Slot slot = (Slot)screenHandler.slots.get(n);
        return slot.inventory != this.pmi && slot.hasStack() && this.pmh.test(slot.getStack());
    }

    private static boolean pmy(ScreenHandler screenHandler, PlayerInventory playerInventory, int n, ItemStack itemStack) {
        if (n < 0 || n >= screenHandler.slots.size()) {
            return false;
        }
        Slot slot = (Slot)screenHandler.slots.get(n);
        if (slot.inventory != playerInventory || slot.getIndex() >= 36) {
            return false;
        }
        if (!slot.hasStack()) {
            return true;
        }
        ItemStack itemStack2 = slot.getStack();
        return ItemStack.areItemsAndComponentsEqual((ItemStack)itemStack2, (ItemStack)itemStack) && itemStack2.getCount() < itemStack2.getMaxCount();
    }

    private static int pmz(ScreenHandler screenHandler, PlayerInventory playerInventory, Predicate<ItemStack> predicate, Random random) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < screenHandler.slots.size(); ++i) {
            Slot slot = (Slot)screenHandler.slots.get(i);
            if (slot.inventory == playerInventory || !slot.hasStack() || !predicate.test(slot.getStack())) continue;
            arrayList.add(i);
        }
        return arrayList.isEmpty() ? -1 : (Integer)arrayList.get(random.nextInt(arrayList.size()));
    }

    private static int pna(ScreenHandler screenHandler, PlayerInventory playerInventory, ItemStack itemStack, Random random) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<Integer> arrayList3 = new ArrayList<Integer>();
        for (int i = 0; i < screenHandler.slots.size(); ++i) {
            Slot slot = (Slot)screenHandler.slots.get(i);
            if (slot.inventory != playerInventory || slot.getIndex() >= 36) continue;
            if (!slot.hasStack()) {
                (slot.getIndex() < 9 ? arrayList : arrayList2).add(i);
                continue;
            }
            if (!ItemStack.areItemsAndComponentsEqual((ItemStack)slot.getStack(), (ItemStack)itemStack) || slot.getStack().getCount() >= slot.getStack().getMaxCount()) continue;
            arrayList3.add(i);
        }
        ArrayList<Integer> arrayList4 = !arrayList.isEmpty() ? arrayList : (!arrayList2.isEmpty() ? arrayList2 : arrayList3);
        return arrayList4.isEmpty() ? -1 : (Integer)arrayList4.get(random.nextInt(arrayList4.size()));
    }

    public static int stashSlot(ScreenHandler screenHandler, PlayerInventory playerInventory, ItemStack itemStack, int n) {
        int n2;
        if (itemStack.isEmpty()) {
            return -1;
        }
        if (pmf.pnb(screenHandler, playerInventory, n, itemStack, false)) {
            return n;
        }
        int n3 = -1;
        for (n2 = 0; n2 < screenHandler.slots.size(); ++n2) {
            Slot slot = (Slot)screenHandler.slots.get(n2);
            if (slot.inventory == playerInventory) continue;
            if (!slot.hasStack()) {
                return n2;
            }
            if (n3 != -1 || !pmf.pnb(screenHandler, playerInventory, n2, itemStack, false)) continue;
            n3 = n2;
        }
        if (n3 != -1) {
            return n3;
        }
        for (n2 = 0; n2 < screenHandler.slots.size(); ++n2) {
            if (!pmf.pnb(screenHandler, playerInventory, n2, itemStack, true)) continue;
            return n2;
        }
        return -1;
    }

    private static boolean pnb(ScreenHandler screenHandler, PlayerInventory playerInventory, int n, ItemStack itemStack, boolean bl) {
        if (n < 0 || n >= screenHandler.slots.size()) {
            return false;
        }
        Slot slot = (Slot)screenHandler.slots.get(n);
        if (slot.inventory == playerInventory != bl || bl && slot.getIndex() >= 36) {
            return false;
        }
        if (!slot.hasStack()) {
            return slot.canInsert(itemStack);
        }
        ItemStack itemStack2 = slot.getStack();
        return ItemStack.areItemsAndComponentsEqual((ItemStack)itemStack2, (ItemStack)itemStack) && itemStack2.getCount() < Math.min(itemStack2.getMaxCount(), slot.getMaxItemCount(itemStack2));
    }

    public static long clickDelay(Random random) {
        double d = 72.0 * Math.exp(random.nextGaussian() * 0.28);
        if (random.nextDouble() < 0.05) {
            d += 100.0 + random.nextDouble() * 160.0;
        }
        return Math.round(MathHelper.clamp((double)d, (double)45.0, (double)320.0));
    }

    public static long travelDelay(Random random) {
        return Math.round(MathHelper.clamp((double)(160.0 * Math.exp(random.nextGaussian() * 0.25)), (double)110.0, (double)300.0));
    }

    public static long settleDelay(Random random) {
        return Math.round(MathHelper.clamp((double)(150.0 * Math.exp(random.nextGaussian() * 0.2)), (double)110.0, (double)260.0));
    }

    private static /* synthetic */ int ble(int n, int n2) {
        return n + n2 + 896081784;
    }
}

