package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.DrawContext;

public final class jfw extends jeq<jfn> {
   static final float jfx = 12.0F;
   static final int jfy = -4932924;
   static final int jfz = -4160260;
   static final int jga = -278748;

   jfw() {
      super(a.c(-1080403275, "嫝⍨ꦼ㟆밇"), a.b("俶㙣벷⋍ꤌ", -1290252354), vhz.CLOCK, true, 2, 1, 6.0F, 0.0F);
   }

   @Override
   List<jfn> items(boolean var1) {
      ArrayList var2 = new ArrayList();
      String var3 = nfl.hudStatus();
      if (var3 == null) {
         if (var1) {
            long var6 = System.currentTimeMillis();
            var2.add(
               new jfn(
                  a.c(-1486869909, "⨞厨\ud96e䜊쳜䩫"),
                  wap.s(
                     a.d("휐꺗\u244c먠\u31ea띜ആ蒰᪩逑\u17df\uedfc捆遲炝\uf670䰾쏥夕\udfd3嚳Ⳳꉋ㦑뿦", -616192624, -584813874),
                     a.d("欍ኞ頺Ȩ跃ୖ녹㣴ꛔⰗꮰ冺\udf67䚩좕仳\uf42b篪\ue153有\ueef6", 384601243, -2132417643)
                  ),
                  0,
                  null,
                  0L,
                  false
               )
            );
            var2.add(new jfn(a.b("\uec98锨ῳ", -1853494102), null, 108, qwj.MYTHIC, var6 + 19000L, true));
            var2.add(new jfn(a.c(-1543425592, "ㇺ䡋슛"), null, 112, qwj.LEGENDARY, var6 + 95000L, false));
            var2.add(new jfn(a.c(956041969, "ૃ獳囹"), null, 109, qwj.COMMON, var6 + 141000L, false));
         }

         return var2;
      } else {
         var2.add(new jfn(a.d("槕ၣ骥Ӂ輗ঠ", 1598294290, 1359700146), var3, 0, null, 0L, false));

         for (ney var5 : nfl.hudRows()) {
            var2.add(new jfn(String.valueOf(var5.id()), null, var5.id(), var5.tier(), var5.refreshAt(), var5.focus()));
         }

         return var2;
      }
   }

   String key(jfn var1) {
      return var1.jfo;
   }

   @Override
   float rowHeight() {
      return 12.0F;
   }

   @Override
   long refreshNanos() {
      return 250000000L;
   }

   float rowWidth(jfn var1) {
      return var1.jfp != null
         ? 8.0F + izx.TEXT.width(var1.jfp)
         : 8.0F
            + izx.TEXT.width(a.d("崡⒐깃", 2038937710, 526640508))
            + 8.0F
            + izx.TEXT.width(wap.value(var1.jfr.title()))
            + 14.0F
            + izx.VALUE.width(a.c(-1802246097, "\ue81a醫᭲蔉ໞ"));
   }

   // $VF: Unable to simplify switch on enum
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   void drawRow(DrawContext var1, jfn var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      float var9 = var4 + var6 * 0.5F;
      if (var2.jfp != null) {
         uut.circle(var1, var3 + 1.8F, var9, 1.7F, iov.accent());
         izx.TEXT.draw(var1, izx.TEXT.ellipsize(var2.jfp, var5 - 8.0F), var3 + 7.0F, izx.TEXT.centerTop(var9), iov.text);
      } else {
         if (var2.jft) {
            uut.shadow(var1, var3 - 0.2F, var9 - 2.0F, 4.0F, 4.0F, 2.0F, 3.0F, iov.accent(90));
            uut.circle(var1, var3 + 1.8F, var9, 1.7F, iov.accent());
         }

         String var10 = String.valueOf(var2.jfq);
         float var11 = var3 + 7.0F;
         izx.TEXT.draw(var1, var10, var11, izx.TEXT.centerTop(var9), var2.jft ? iov.text : iov.textDim);
         var11 += izx.TEXT.width(a.b("\udffbꙊⲙ", 2063917000)) + 8.0F;

         int var12 = switch (var2.jfr) {
            case LEGENDARY -> -278748;
            case MYTHIC -> -4160260;
            default -> -4932924;
         };
         izx.TEXT.draw(var1, wap.value(var2.jfr.title()), var11, izx.TEXT.centerTop(var9), var12);
         long var13 = var2.jfs - System.currentTimeMillis();
         String var15 = var13 > 0L ? nfl.clock(var13) : wap.s(a.c(318425386, "쥇냷㨼"), a.c(-346669913, "㣠䄥쯺嗵\ude55墕"));
         int var16 = expiring(var2.jft ? iov.text : ujt.lerp(iov.textDim, iov.text, 0.4F), (float)var13 / 1000.0F);
         izx.VALUE.draw(var1, var15, var3 + var5 - izx.VALUE.width(var15), izx.VALUE.centerTop(var9), var16);
      }
   }
}
