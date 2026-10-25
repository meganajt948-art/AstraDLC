package a;

import com.mojang.blaze3d.textures.GpuTextureView;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.block.Block;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.Entity;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.decoration.DisplayEntity.TextDisplayEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos.Mutable;

public class rzy extends kfe {
   private static final Pattern rzz = Pattern.compile("(\\d{1,2})\\s*:\\s*(\\d{2})");
   private static final Pattern saa = Pattern.compile("(?i)§.|&#[0-9a-f]{6}|<#?[0-9a-f]{6}>");
   private static final Pattern sab = Pattern.compile("(?i)(готов|забирай|награда|собирай)");
   private static final vdn sac = veo.medium(6.5F);
   private static rzy sad;
   private static TrackedData<?> sae;
   private static boolean saf;
   private final vkl sag = this.add(new vkl("Hide timer", true));
   private final vkl sah = this.add(new vkl("Blur", true));
   private final List<rzv> sai = new ArrayList<>();
   private final Map<Integer, String[]> saj = new HashMap<>();
   private static final Map<Block, Boolean> sak = new IdentityHashMap<>();
   private final boolean sal;

   public rzy() {
      this(true);
   }

   public rzy(boolean var1) {
      super(new String(new char[]{'W', 'a', 'r', 'd', 'e', 'n', 'H', 'e', 'l', 'p', 'e', 'r'}), "Timers over the Warden chests", kfa.RENDER);
      this.sal = var1;
      if (var1) {
         sad = this;
      }
   }

   @Override
   protected void onEnable() {
      this.sai.clear();
   }

   @Override
   protected void onDisable() {
      this.sai.clear();
      this.saj.clear();
   }

   @Override
   public void onStartTick(MinecraftClient var1) {
      this.tickTimers(true);
   }

   private boolean sao() {
      return this.mc.field_1724 == null || this.mc.field_1687 == null;
   }

   public void tickTimers(boolean var1) {
      if (!this.sao()) {
         long var2 = System.currentTimeMillis();
         String var4 = this.mc.field_1687.method_27983().method_29177().toString();
         this.sai.removeIf(var4x -> {
            if (!var4x.dimension.equals(var4)) {
               return false;
            } else {
               if (this.mc.field_1724 != null) {
                  double var5 = var4x.pos.method_1025(this.mc.field_1724.method_73189());
                  if (var5 > 40000.0) {
                     return true;
                  }

                  if (var5 < 2500.0 && !this.saq(BlockPos.method_49637(var4x.pos.field_1352, var4x.pos.field_1351 - 1.0, var4x.pos.field_1350))) {
                     return true;
                  }
               }

               return var4x.isReady && var2 - var4x.lastSeen > 300000L ? true : !var4x.isReady && var4x.expirationTime + 10000L <= var2;
            }
         });

         for (Entity var6 : this.mc.field_1687.method_18112()) {
            if (var6 instanceof ArmorStandEntity || var6 instanceof TextDisplayEntity) {
               String var7 = "";
               if (var6 instanceof ArmorStandEntity var8) {
                  if (var8.method_16914() && var8.method_5797() != null) {
                     var7 = var8.method_5797().getString();
                  }
               } else {
                  Text var9 = sar((TextDisplayEntity)var6);
                  if (var9 != null) {
                     var7 = var9.getString();
                  }
               }

               if (!var7.isEmpty()) {
                  String var28 = this.sap(var6.method_5628(), var7);
                  if (var28 != null) {
                     Matcher var29 = rzz.matcher(var28);
                     boolean var10 = sab.matcher(var28).find();
                     if (var29.find() || var10) {
                        if (var1 && this.sag.get()) {
                           var6.method_5648(true);
                           if (var6 instanceof ArmorStandEntity var11) {
                              var11.method_5880(false);
                           }
                        }

                        double var30 = var6 instanceof ArmorStandEntity ? 1.8 : 0.5;
                        Vec3d var13 = new Vec3d(var6.method_23317(), var6.method_23318() + var30, var6.method_23321());
                        Vec3d var14 = new Vec3d(Math.floor(var13.field_1352) + 0.5, var13.field_1351, Math.floor(var13.field_1350) + 0.5);
                        if (this.saq(BlockPos.method_49637(var14.field_1352, var14.field_1351 - 1.0, var14.field_1350))) {
                           rzv var15 = null;

                           for (rzv var17 : this.sai) {
                              if (var17.dimension.equals(var4) && this.sau(var17.pos, var14) < 1.0) {
                                 var15 = var17;
                                 break;
                              }
                           }

                           if (var29.find(0)) {
                              int var31 = 0;
                              int var33 = 0;

                              try {
                                 var31 = Integer.parseInt(var29.group(1));
                                 var33 = Integer.parseInt(var29.group(2));
                              } catch (NumberFormatException var23) {
                              }

                              long var18 = var31 * 60L + var33;
                              long var20 = var2 + var18 * 1000L;
                              rzv var22 = var15;
                              if (var15 != null) {
                                 var15.expirationTime = var20;
                                 var15.isReady = false;
                                 var15.lastSeen = var2;
                                 var15.lastNumericUpdate = var2;
                              } else {
                                 var22 = new rzv(var14, var20, var4, var2);
                                 var22.lastNumericUpdate = var2;
                                 this.sai.add(var22);
                              }

                              var22.untimed = false;
                              if (var18 > 0L) {
                                 var22.zeroSince = 0L;
                              } else if (var22.zeroSince == 0L) {
                                 var22.zeroSince = var2;
                              }
                           } else if (var10) {
                              if (var15 != null) {
                                 if (var2 - var15.lastNumericUpdate > 1000L) {
                                    if (!var15.isReady && !var15.notifiedReady) {
                                       this.sav(var1, "Chest", "ready", true);
                                       var15.notifiedReady = true;
                                    }

                                    var15.isReady = true;
                                    var15.untimed = false;
                                    var15.lastSeen = var2;
                                 }
                              } else {
                                 rzv var32 = new rzv(var14, var2, var4, var2);
                                 var32.isReady = true;
                                 var32.notifiedReady = true;
                                 this.sai.add(var32);
                                 this.sav(var1, "Chest", "ready", true);
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         for (rzv var26 : this.sai) {
            long var27 = var26.expirationTime - var2;
            if (!var26.isReady && var27 > 0L && var27 <= 10000L && !var26.notifiedTen) {
               this.sav(var1, "Chest", "10 sec", false);
               var26.notifiedTen = true;
            }

            if (!var26.isReady && var27 <= 0L && !var26.countdownShown(var2) && !var26.notifiedReady) {
               this.sav(var1, "Chest", "ready", true);
               var26.notifiedReady = true;
               var26.isReady = true;
            }
         }

         if (this.mc.field_1724 != null) {
            Vec3d var25 = this.mc.field_1724.method_73189();
            this.sai.sort((var1x, var2x) -> Double.compare(var2x.pos.method_1025(var25), var1x.pos.method_1025(var25)));
         }
      }
   }

   private String sap(int var1, String var2) {
      String[] var3 = this.saj.get(var1);
      if (var3 != null && var3[0].equals(var2)) {
         return var3[1];
      } else {
         String var4 = saa.matcher(var2).replaceAll("");
         var4 = var4.replace("Ø", "0").replace("∅", "0");
         String var5 = var4.toLowerCase(Locale.ROOT);
         String var6 = var4;
         if (var5.contains("кейс") || var5.contains("ключей") || var5.contains("нажми") || !rzz.matcher(var4).find() && !sab.matcher(var4).find()) {
            var6 = null;
         }

         if (this.saj.size() > 4096) {
            this.saj.clear();
         }

         this.saj.put(var1, new String[]{var2, var6});
         return var6;
      }
   }

   private boolean saq(BlockPos var1) {
      Mutable var2 = new Mutable();

      for (int var3 = -1; var3 <= 1; var3++) {
         for (int var4 = -2; var4 <= 1; var4++) {
            for (int var5 = -1; var5 <= 1; var5++) {
               Block var6 = this.mc.field_1687.method_8320(var2.method_25504(var1, var3, var4, var5)).method_26204();
               Boolean var7 = sak.get(var6);
               if (var7 == null) {
                  String var8 = var6.method_63499().toLowerCase(Locale.ROOT);
                  var7 = var8.contains("chest") || var8.contains("barrel") || var8.contains("shulker");
                  sak.put(var6, var7);
               }

               if (var7) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   private static Text sar(TextDisplayEntity var0) {
      if (!saf) {
         saf = true;

         for (Field var4 : TextDisplayEntity.class.getDeclaredFields()) {
            if (Modifier.isStatic(var4.getModifiers()) && var4.getType() == TrackedData.class) {
               try {
                  var4.setAccessible(true);
                  TrackedData var5 = (TrackedData)var4.get(null);
                  if (var5 != null && var5.comp_2328() == TrackedDataHandlerRegistry.field_13317) {
                     sae = var5;
                     break;
                  }
               } catch (RuntimeException | ReflectiveOperationException var7) {
               }
            }
         }
      }

      if (sae == null) {
         return null;
      } else {
         try {
            return var0.method_5841().method_12789(sae) instanceof Text var9 ? var9 : null;
         } catch (RuntimeException var6) {
            return null;
         }
      }
   }

   public static void render(DrawContext var0, RenderTickCounter var1) {
      rzy var2 = sad;
      MinecraftClient var3 = MinecraftClient.method_1551();
      if (var2 != null && var2.isEnabled() && !var2.sai.isEmpty() && var3.field_1687 != null && var3.field_1724 != null && !var3.field_1690.field_1842) {
         unf.observe(var0);
         float var4 = var0.method_51421();
         float var5 = var0.method_51443();

         usn var6;
         try {
            var6 = usn.capture(var1.method_60637(true), var4, var5);
         } catch (Throwable var33) {
            return;
         }

         uut.beginFrame();
         GpuTextureView var7 = null;
         boolean var8 = false;
         long var9 = System.currentTimeMillis();
         String var11 = var3.field_1687.method_27983().method_29177().toString();
         float[] var12 = new float[2];
         int var13 = 0;

         for (rzv var15 : var2.sai) {
            if (var15.dimension.equals(var11)
               && var13 < 30
               && var6.project(var15.pos.field_1352, var15.pos.field_1351, var15.pos.field_1350, var12)
               && !(var12[0] < 0.0F)
               && !(var12[0] > var4)
               && !(var12[1] < 0.0F)
               && !(var12[1] > var5)) {
               if (!var8) {
                  var8 = true;
                  if (var2.sah.get() && uij.HUD.capture(var0, 2, null)) {
                     var7 = uij.HUD.result(var0);
                  }
               }

               long var16 = var15.expirationTime - var9;
               boolean var18 = var15.isReady || var16 <= 0L && !var15.countdownShown(var9);
               long var19 = Math.abs(var16) / 1000L;
               String var21 = var18 ? "READY" : sat(var19 / 60L) + ":" + sat(var19 % 60L);
               float var22 = var18 ? 1.0F : Math.min((float)var16 / 180000.0F, 1.0F);
               int var23 = var18 ? 60 : (int)(255.0F + -255.0F * var22);
               int var24 = var18 ? 255 : (int)(40.0F + 215.0F * var22);
               int var25 = var18 ? 90 : 0;
               int var26 = 0xFF000000 | sas(var23) << 16 | sas(var24) << 8 | sas(var25);
               float var27 = sac.width(var21) + 10.0F;
               float var28 = 13.0F;
               float var29 = var12[0] - var27 / 2.0F;
               float var30 = var12[1] - 4.0F;
               int var31 = var18 ? -938185186 : -1275068416;
               int var32 = var18 ? -1944144836 : 2013265920;
               if (var7 == null || !uut.glass(var0, var7, var29, var30, var27, var28, 3.0F, var32, 1.0F)) {
                  uut.round(var0, var29, var30, var27, var28, 3.0F, var31);
               }

               sac.draw(var0, var21, var29 + 5.0F, sac.centerTop(var30 + var28 / 2.0F), var26);
               var13++;
            }
         }
      }
   }

   private static int sas(int var0) {
      return Math.max(0, Math.min(255, var0));
   }

   private static String sat(long var0) {
      return var0 < 10L ? "0" + var0 : String.valueOf(var0);
   }

   private double sau(Vec3d var1, Vec3d var2) {
      double var3 = var1.field_1352 - var2.field_1352;
      double var5 = var1.field_1350 - var2.field_1350;
      return var3 * var3 + var5 * var5;
   }

   private void sav(boolean var1, String var2, String var3, boolean var4) {
      if (var1 && this.sal) {
         try {
            izx.alert(var2, var3, vhz.INFO, var4);
         } catch (Throwable var6) {
         }
      }
   }

   public void clearTimers() {
      this.sai.clear();
   }

   public rzv markUntimedReady(BlockPos var1, String var2) {
      long var3 = System.currentTimeMillis();
      Vec3d var5 = new Vec3d(var1.method_10263() + 0.5, var1.method_10264() + 1.5, var1.method_10260() + 0.5);

      for (rzv var7 : this.sai) {
         if (var7.dimension.equals(var2) && this.sau(var7.pos, var5) < 1.0 && Math.abs(var7.pos.field_1351 - var5.field_1351) < 4.0) {
            return var7;
         }
      }

      rzv var8 = new rzv(var5, var3, var2, var3);
      var8.isReady = true;
      var8.notifiedReady = true;
      var8.untimed = true;
      this.sai.add(var8);
      return var8;
   }

   public List<rzv> getCachedTimers() {
      return this.sai;
   }
}
