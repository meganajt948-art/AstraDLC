package a;

import flow.dev.a;
import io.netty.channel.Channel;
import io.netty.channel.ChannelPipeline;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.packet.BundlePacket;
import net.minecraft.network.packet.Packet;

public final class wcn {
   static final String wco = a.d("㲆䔽쿭冄\uda16峊\ue6b4潒\uf109箽ﱯ؉", 437783686, -1226887062);
   static final String wcp = a.d("⦙倹\udae8䒑콈䧨\uf390穖\ue400溾\ue967ጞ鷀Ѧ", -652043958, 908439725);
   static final List<Consumer<Packet<?>>> wcq = new CopyOnWriteArrayList<>();
   static final List<UnaryOperator<Packet<?>>> wcr = new CopyOnWriteArrayList<>();
   static Field wcs;
   static boolean wct;

   wcn() {
   }

   public static void listen(Consumer<Packet<?>> var0) {
      wcq.add(var0);
   }

   public static void rewrite(UnaryOperator<Packet<?>> var0) {
      wcr.add(var0);
   }

   public static void ensure(MinecraftClient var0) {
      ClientPlayNetworkHandler var1 = var0.getNetworkHandler();
      if (var1 != null && !wct && !ejp.isActive()) {
         Channel var2 = channel(var1.getConnection());
         if (var2 != null && var2.isOpen()) {
            ChannelPipeline var3 = var2.pipeline();
            if (var3.get(a.c(2101498861, "厇⨼ꃬ㺅딗㏋覵S鸈ᒼ鍮椈")) == null && var3.get(a.d("垝⸽ꓬ㪕녌㟬趔ђ騄Ⴚ靣洚\ue3c4穢", -2063449462, 55645545)) != null) {
               try {
                  var3.addBefore(a.c(475920570, "\uf8c4腤வ闌ḕ颵⋍ꬋ㕝뿣㠺쉃䲝픻"), a.b("㎍䨶샦序픝叁\ue9bf恙︂璶\uf364ं", -960744473), new wck());
               } catch (RuntimeException var5) {
               }
            }
         }
      }
   }

   static Channel channel(ClientConnection var0) {
      try {
         if (wcs == null) {
            for (Field var4 : ClientConnection.class.getDeclaredFields()) {
               if (!Modifier.isStatic(var4.getModifiers()) && Channel.class.isAssignableFrom(var4.getType())) {
                  var4.setAccessible(true);
                  wcs = var4;
                  break;
               }
            }

            if (wcs == null) {
               throw new IllegalStateException(a.b("\ue403鶳ᜯ褝ˁ葹㸥럔⦀ꌸ⒧\ude90偈짵䎯앖", 520610941));
            }
         }

         return (Channel)wcs.get(var0);
      } catch (ReflectiveOperationException | RuntimeException var5) {
         wct = true;
         System.out.println(a.d("\ud93aꂚ⩋됲㿫륋͌諵ᒭ鸜\u19cb\ue3f1浳\uf4d9纅\uf863䈻췢坔턈壼⊣같㞗뇲", -2125612801, 506683820) + var5);
         return null;
      }
   }

   static void wcw(Packet<?> var0) {
      if (var0 instanceof BundlePacket var5) {
         for (Packet<?> var3 : var5.getPackets()) {
            wcw(var3);
         }
      } else {
         for (Consumer<Packet<?>> var2 : wcq) {
            try {
               var2.accept(var0);
            } catch (Throwable var4) {
            }
         }
      }
   }

   static Packet<?> wcx(Packet<?> var0) {
      for (UnaryOperator<Packet<?>> var2 : wcr) {
         try {
            Packet<?> var3 = var2.apply(var0);
            if (var3 != null) {
               var0 = var3;
            }
         } catch (Throwable var4) {
         }
      }

      return var0;
   }
}
