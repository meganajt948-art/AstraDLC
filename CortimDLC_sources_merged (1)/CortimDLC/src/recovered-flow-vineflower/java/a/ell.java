package a;

import flow.dev.a;
import java.lang.reflect.Field;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.util.profiler.Recorder;

public final class ell implements Recorder {
   private static final Field elm = vxr.find(
      MinecraftClient.class,
      a.d("渴ណ鵌ͧ裳ๆ됒㷨ꎱ⤑껑咧\uda62䎉즗佩\uf52b竨\ue05b昦\uefbd问᭜", -19234698, 1910828603),
      a.d("쁁맿㌠굘⚇ꀍᨳ鏉ක蜨ô", -931353639, 1638689781),
      a.b("⊂嬑퇉侩쐥䋖\uf881煷\uef23斔\ue256ᠴ雤ཇ蕏ϲ릲㙮곏⪞ꍅ\ud97e埁찟䩤삼", 778904276)
   );
   private final Recorder eln;

   private ell(Recorder var1) {
      this.eln = var1;
   }

   public static void ensure(MinecraftClient var0) {
      if (elm != null && var0 != null) {
         try {
            Object var1 = elm.get(var0);
            if (var1 instanceof ell || !(var1 instanceof Recorder var2)) {
               return;
            }

            elm.set(var0, new ell(var2));
         } catch (RuntimeException | ReflectiveOperationException var3) {
         }
      }
   }

   public void method_34770() {
      this.eln.method_34770();
   }

   public void method_41320() {
      this.eln.method_41320();
   }

   public void method_34771() {
      this.eln.method_34771();
   }

   public boolean method_34773() {
      return this.eln.method_34773();
   }

   public Profiler method_34774() {
      return this.eln.method_34774();
   }

   public void method_34772() {
      this.eln.method_34772();
      if (!ejp.isActive()) {
         try {
            nxa.onFrame();
         } catch (Throwable var3) {
         }

         try {
            egq.onFrame();
         } catch (Throwable var2) {
         }
      }
   }
}
