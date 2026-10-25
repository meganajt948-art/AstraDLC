/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayNetworkHandler
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.recipebook.ClientRecipeBook
 *  net.minecraft.client.sound.BiomeEffectSoundPlayer
 *  net.minecraft.client.sound.BubbleColumnSoundPlayer
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.entity.Entity
 *  net.minecraft.stat.StatHandler
 *  net.minecraft.text.Text
 *  net.minecraft.util.PlayerInput
 */
package a;

import a.dtv;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.recipebook.ClientRecipeBook;
import net.minecraft.client.sound.BiomeEffectSoundPlayer;
import net.minecraft.client.sound.BubbleColumnSoundPlayer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.stat.StatHandler;
import net.minecraft.text.Text;
import net.minecraft.util.PlayerInput;

public final class eik
extends ClientPlayerEntity {
    private final dtv eil;
    private static /* synthetic */ long eim;
    private static /* synthetic */ String ein;

    eik(MinecraftClient minecraftClient, ClientWorld clientWorld, ClientPlayNetworkHandler clientPlayNetworkHandler, StatHandler statHandler, ClientRecipeBook clientRecipeBook, PlayerInput playerInput, boolean bl, dtv dtv2) {
        super(minecraftClient, clientWorld, clientPlayNetworkHandler, statHandler, clientRecipeBook, playerInput, bl);
        this.eil = dtv2;
        this.eio();
    }

    private void eio() {
        for (Field field : ClientPlayerEntity.class.getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers()) || !List.class.isAssignableFrom(field.getType())) continue;
            try {
                field.setAccessible(true);
                Object object2 = field.get((Object)this);
                if (!(object2 instanceof List)) continue;
                List list = (List)object2;
                list.removeIf(object -> object instanceof BubbleColumnSoundPlayer || object instanceof BiomeEffectSoundPlayer);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    public dtv getBot() {
        return this.eil;
    }

    public void method_7353(Text text, boolean bl) {
        this.eil.onLocalMessage(text, bl);
    }

    public void method_7277(Entity entity) {
    }

    public void method_7304(Entity entity) {
    }

    private static /* synthetic */ int er(int n, int n2) {
        return n * n2 ^ 0xB786C8FC;
    }

    private static /* synthetic */ int es(int n, int n2) {
        return n + n2 | 0xDD28BB31;
    }

    private static /* synthetic */ int et(int n, int n2) {
        return eik.es(n, n2) ^ 0xE2382334;
    }
}

