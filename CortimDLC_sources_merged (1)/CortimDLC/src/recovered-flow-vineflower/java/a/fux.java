package a;

import io.netty.channel.Channel;
import io.netty.channel.embedded.EmbeddedChannel;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.NetworkSide;
import net.minecraft.network.listener.PacketListener;
import net.minecraft.network.state.NetworkState;

final class fux extends ClientConnection {
   private final EmbeddedChannel fuy = new EmbeddedChannel();

   fux() {
      super(NetworkSide.field_11941);

      try {
         for (Field var4 : ClientConnection.class.getDeclaredFields()) {
            if (!Modifier.isStatic(var4.getModifiers()) && var4.getType() == Channel.class) {
               var4.setAccessible(true);
               var4.set(this, this.fuy);
            }
         }
      } catch (ReflectiveOperationException var5) {
         throw new IllegalStateException(var5);
      }
   }

   void drain() {
      this.fuy.releaseOutbound();
   }

   public <T extends PacketListener> void method_56330(NetworkState<T> var1, T var2) {
   }

   public void method_56329(NetworkState<?> var1) {
   }

   public void method_10768() {
   }

   public void method_10757() {
   }
}
