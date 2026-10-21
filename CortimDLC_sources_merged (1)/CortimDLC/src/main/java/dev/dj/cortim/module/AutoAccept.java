package dev.dj.cortim.module;

import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;

import java.util.regex.Pattern;

public class AutoAccept extends Module {

    // "Друзья" пока не работает — список друзей ещё не реализован
    private final ModeSetting fromMode = add(new ModeSetting("От", "Чьи запросы телепорта принимать", 1, "Друзья", "Все").asSegmented());
    private final TextSetting command  = add(new TextSetting("Команда", "Команда, принимающая телепорт", "/tpaccept"));
    private final FloatSetting delay   = add(new FloatSetting("Задержка", "Задержка перед отправкой команды, сек", 0.6f, 0f, 5f, 0.1f));

    // широкий паттерн — под конкретный сервер может понадобиться правка
    private static final Pattern TPA_REQUEST = Pattern.compile(
            "(?iu)(запросил[аи]?\\s+телепорт|хочет\\s+телепортироват|tpa\\s*request|teleport\\s+request)");

    private int pendingTicks = -1;

    public AutoAccept() {
        super("AutoAccept", Category.MISC);
        ClientReceiveMessageEvents.GAME.register((message, overlay) -> {
            if (overlay || !isEnabled()) return;
            if (!TPA_REQUEST.matcher(message.getString()).find()) return;

            if (fromMode.get() == 0) return; // "Друзья" пока отключено — нет списка

            pendingTicks = Math.round(delay.get() * 20f); // секунды -> тики
        });
    }

    @Override
    public void onTick() {
        if (!isEnabled() || pendingTicks < 0) return;

        if (pendingTicks == 0) {
            MinecraftClient client = MinecraftClient.getInstance();
            ClientPlayerEntity player = client.player;
            if (player != null) {
                String cmd = command.get();
                if (cmd != null && !cmd.isBlank()) {
                    player.networkHandler.sendChatCommand(cmd.startsWith("/") ? cmd.substring(1) : cmd);
                }
            }
            pendingTicks = -1;
            return;
        }
        pendingTicks--;
    }
}