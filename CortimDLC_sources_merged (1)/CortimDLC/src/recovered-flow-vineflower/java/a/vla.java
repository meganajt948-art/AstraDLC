package a;

import flow.dev.a;

public class vla extends vlv {
   public static final String THEME = a.c(1358628362, "ٛ翖\uf508歱\ue0ae");
   static final String[] vlb = new String[]{
      a.c(-22177671, "頨\ue1a5死\uf502绝"),
      a.b("胑凜玀\uedec昦\ue084", 949649558),
      a.b("販\uf52a翳\ue19c橌\uecee", 620465404),
      a.d("ꏷ\uda6c傹", -755050020, -929858975),
      a.c(-1182953181, "酳\ue8fd戨ﱚ瞄\uf124"),
      a.b("仉㝞붖⏺\ua83b⺛", -1894953316),
      a.c(912669246, "㩷䏢줶坝"),
      a.c(47580972, "ݨ绨\uf420橕\ue19c朱\udd63"),
      a.b("읬뻵㐥꩜", 907331375),
      a.c(699486684, "冋⠇ꋕ㲼")
   };
   static final int[][] vlc = new int[][]{
      null,
      {-10556716, -5796870},
      {-28744, -14630},
      {-8599297, -1837825},
      {-7635722, -3688193},
      {-26035, -41334},
      {-12723049, -4852266},
      {-45730, -25948},
      {-538296, -5208},
      {-723720, -4209712}
   };

   public vla(String var1, String var2) {
      super(var1, var2, vlb);
   }

   public static int[] pair(int var0) {
      int var1 = Math.max(0, Math.min(vlc.length - 1, var0));
      return vlc[var1] == null ? new int[]{iov.accent(), iov.accent2()} : vlc[var1];
   }

   public int color() {
      return pair(this.index())[0];
   }

   public int[] vivid(int[] var1) {
      if (this.index() == 0) {
         int var2 = iov.accent();
         int var3 = var2 >> 16 & 0xFF;
         int var4 = var2 >> 8 & 0xFF;
         int var5 = var2 & 0xFF;
         int var6 = Math.max(var3, Math.max(var4, var5));
         int var7 = Math.min(var3, Math.min(var4, var5));
         if (var6 == 0 || (float)(var6 - var7) / var6 < 0.18F) {
            return var1;
         }
      }

      return new int[]{this.color() | 0xFF000000, this.color2() | 0xFF000000};
   }

   public int color2() {
      int[] var1 = pair(this.index());
      return this.index() == 0 && var1[0] == var1[1] ? vlf(var1[0]) : var1[1];
   }

   static int vlf(int var0) {
      int var1 = var0 >> 16 & 0xFF;
      int var2 = var0 >> 8 & 0xFF;
      int var3 = var0 & 0xFF;
      return var0 & 0xFF000000 | var1 + (255 - var1) / 2 << 16 | var2 + (255 - var2) / 2 << 8 | var3 + (255 - var3) / 2;
   }
}
