package a;

import java.awt.image.BufferedImage;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

final class isn {
   final String key;
   final String name;
   final String resource;
   final Path file;
   final uxt sky;
   final String video;
   CompletableFuture<BufferedImage> thumbLoad;
   uok thumb;
   boolean failed;
   int fill = -1;

   isn(String var1, String var2, String var3, Path var4) {
      this(var1, var2, var3, var4, null);
   }

   isn(String var1, String var2, String var3, Path var4, uxt var5) {
      this(var1, var2, var3, var4, var5, null);
   }

   isn(String var1, String var2, String var3, Path var4, uxt var5, String var6) {
      this.key = var1;
      this.name = var2;
      this.resource = var3;
      this.file = var4;
      this.sky = var5;
      this.video = var6;
   }

   boolean isWorld() {
      return this.resource == null && this.file == null && this.sky == null;
   }

   boolean isLive() {
      return this.sky != null;
   }

   boolean isUser() {
      return this.file != null;
   }

   boolean isVideo() {
      return this.video != null;
   }
}
