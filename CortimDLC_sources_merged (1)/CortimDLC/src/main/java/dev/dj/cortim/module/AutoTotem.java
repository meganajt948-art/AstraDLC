package dev.dj.cortim.module;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Locale;

/**
 * Когда здоровье падает до порога, ставит тотем в левую руку. После того как опасность прошла,
 * может вернуть прежний предмет.
 */
public class AutoTotem extends Module {

    private final FloatSetting threshold = add(new FloatSetting("Порог здоровья",
            "Ниже этого здоровья ставится тотем", 6.0f, 1.0f, 20.0f, 0.5f) {
        @Override public String display() { return String.format(Locale.ROOT, "%.1f HP", get()); }
    });

    private final BoolSetting restore = add(new BoolSetting("Возвращать предмет",
            "Вернуть прежний предмет, когда опасность прошла", true));

    private final BoolSetting plainFirst = add(new BoolSetting("Сначала обычные тотемы",
            "Сначала тратить обычные тотемы, потом зачарованные", true));

    private final BoolSetting notEating = add(new BoolSetting("Не во время еды",
            "Не менять предмет, пока ешь", false));

    private final BoolSetting smart = add(new BoolSetting("Умное перемещение",
            "Обмен с рукой одним пакетом (иначе тремя кликами)", true));

    private int cooldown = 0;
    private int sinceEquip = 0;
    private int returnSlot = -1;
    private Item returnItem = null;

    public AutoTotem() { super("AutoTotem", Category.COMBAT); }

    @Override
    public void onTick() {
        if (!isEnabled()) { reset(); return; }

        MinecraftClient client = MinecraftClient.getInstance();
        ClientPlayerEntity player = client.player;
        if (player == null || client.world == null || client.interactionManager == null) return;
        if (client.currentScreen != null || player.isDead()) return;

        if (cooldown > 0) { cooldown--; return; }

        float hp = player.getHealth() + player.getAbsorptionAmount();
        ItemStack off = player.getOffHandStack();
        PlayerInventory inv = player.getInventory();

        if (hp <= threshold.get()) {
            if (InvUtil.isTotem(off)) { sinceEquip = 0; return; }
            if (notEating.get() && eating(player)) return;

            int slot = findTotem(inv);
            if (slot < 0) return;

            // прежний предмет из левой руки окажется в том слоте, откуда взяли тотем
            if (!off.isEmpty()) {
                returnSlot = slot;
                returnItem = off.getItem();
            }
            move(client, player, slot);
            cooldown = 3;
            sinceEquip = 0;
            return;
        }

        // опасность прошла — возвращаем прежний предмет
        if (restore.get() && returnSlot >= 0) {
            sinceEquip++;
            if (hp > threshold.get() + 3.0f && sinceEquip > 15 && InvUtil.isTotem(off)) {
                ItemStack at = inv.getStack(returnSlot);
                if (!at.isEmpty() && at.getItem() == returnItem) {
                    move(client, player, returnSlot);
                    cooldown = 3;
                }
                returnSlot = -1;
                returnItem = null;
            }
        } else if (!restore.get()) {
            returnSlot = -1;
            returnItem = null;
        }
    }

    private void reset() {
        cooldown = 0;
        sinceEquip = 0;
        returnSlot = -1;
        returnItem = null;
    }

    private boolean eating(ClientPlayerEntity player) {
        return player.isUsingItem() && player.getActiveItem().contains(DataComponentTypes.FOOD);
    }

    private int findTotem(PlayerInventory inv) {
        boolean plainPass = plainFirst.get();
        for (int pass = 0; pass < 2; pass++) {
            boolean plain = (pass == 0) == plainPass;
            for (int i = 0; i < 36; i++) {
                ItemStack s = inv.getStack(i);
                if (plain ? InvUtil.isPlainTotem(s) : InvUtil.isEnchantedTotem(s)) return i;
            }
        }
        return -1;
    }

    private void move(MinecraftClient client, ClientPlayerEntity player, int invIndex) {
        if (smart.get()) InvUtil.swapOffhand(client, player, invIndex);
        else InvUtil.swapOffhandPickup(client, player, invIndex);
    }
}