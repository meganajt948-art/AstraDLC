package a;

import flow.dev.a;
import java.util.Collection;
import java.util.List;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.gui.hud.ChatHudLine;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

final class lqy extends lqu<ChatHudLine> {
   final ChatHud lqz;

   lqy(Collection<ChatHudLine> var1, ChatHud var2) {
      super(var1);
      this.lqz = var2;
   }

   @Override
   public void clear() {
      if (!lre.lrw() || !lre.lrf.lri.get()) {
         super.clear();
      }
   }

   public void addFirst(ChatHudLine var1) {
      var1 = this.lrd(var1);
      if (!lre.lrw() || !lre.lrf.lrj.get() || this.isEmpty() || !this.lrc(var1)) {
         lre.lrr = null;
         super.addFirst(var1);
      }
   }

   boolean lrc(ChatHudLine var1) {
      String var2 = var1.content().getString();
      ChatHudLine var3 = this.getFirst();
      int var4;
      if (var3 == lre.lrr && var2.equals(lre.lrs)) {
         var4 = lre.lrt + 1;
      } else {
         if (!var3.content().getString().equals(var2)) {
            return false;
         }

         var4 = 2;
      }

      try {
         List var5 = (List)lre.lrn.get(this.lqz);
         int var6 = lre.lsc(var5, 0);
         int var7 = lre.lsc(var5, var6);
         if (var6 > 0 && var7 > 0 && var6 + var7 <= var5.size()) {
            for (int var8 = 0; var8 < var6 + var7; var8++) {
               var5.removeFirst();
            }

            MutableText var11 = Text.empty()
               .append(var1.content())
               .append(Text.literal(a.b("⎦娟킜", 1396777861) + var4 + a.c(2105677155, "ᕋ")).formatted(Formatting.GRAY));
            ChatHudLine var9 = new ChatHudLine(var1.creationTick(), var11, var1.signature(), var1.indicator());
            lre.lrz(var5, var9);
            this.set(0, var9);
            lre.lrr = var9;
            lre.lrs = var2;
            lre.lrt = var4;
            return true;
         } else {
            return false;
         }
      } catch (Throwable var10) {
         return false;
      }
   }

   ChatHudLine lrd(ChatHudLine var1) {
      Text var2 = wjw.link(var1.content());
      if (var2 == var1.content()) {
         return var1;
      }

      try {
         List var3 = (List)lre.lrn.get(this.lqz);
         int var4 = lre.lsc(var3, 0);
         if (var4 > 0 && lre.lsa(var3, var4).equals(lre.lsb(var1.content().getString()))) {
            for (int var5 = 0; var5 < var4; var5++) {
               var3.removeFirst();
            }

            ChatHudLine var7 = new ChatHudLine(var1.creationTick(), var2, var1.signature(), var1.indicator());
            lre.lrz(var3, var7);
            return var7;
         } else {
            return var1;
         }
      } catch (Throwable var6) {
         return var1;
      }
   }
}
