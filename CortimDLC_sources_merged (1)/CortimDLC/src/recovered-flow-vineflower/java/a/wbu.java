package a;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import flow.dev.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.option.SimpleOption;

public final class wbu<T> {
   private static final List<wbu<?>> wbv = new ArrayList<>();
   private static Field wbw;
   private static Field wbx;
   private static boolean wby;
   private final Function<MinecraftClient, SimpleOption<T>> wbz;
   private SimpleOption<T> wca;
   private volatile boolean wcb;
   private volatile T wcc;
   private Object wcd;

   public wbu(Function<MinecraftClient, SimpleOption<T>> var1) {
      this.wbz = var1;
      synchronized (wbv) {
         wbv.add(this);
      }
   }

   public boolean override(T var1) {
      SimpleOption var2 = this.wcg();
      if (var2 != null && this.wch(var2)) {
         try {
            Object var3 = wbw.get(var2);
            if (!this.wcb || !Objects.equals(var3, this.wcd)) {
               this.wcc = (T)var3;
            }

            this.wcb = true;
            if (!Objects.equals(var3, var1)) {
               wbw.set(var2, var1);
            }

            this.wcd = var1;
            return true;
         } catch (RuntimeException | ReflectiveOperationException var5) {
            wcj(var5);
            return false;
         }
      } else {
         return false;
      }
   }

   public void release() {
      if (this.wcb) {
         this.wcb = false;
         SimpleOption var1 = this.wcg();
         if (var1 != null && wbw != null) {
            try {
               wbw.set(var1, this.wcc);
            } catch (RuntimeException | ReflectiveOperationException var3) {
               wcj(var3);
            }
         }
      }
   }

   public boolean active() {
      return this.wcb;
   }

   public T own() {
      if (this.wcb) {
         return this.wcc;
      } else {
         SimpleOption var1 = this.wcg();
         return (T)(var1 == null ? null : var1.method_41753());
      }
   }

   public static void releaseAll() {
      synchronized (wbv) {
         for (wbu var2 : wbv) {
            var2.release();
         }
      }
   }

   public static boolean suspended(MinecraftClient var0) {
      return var0.field_1755 instanceof GameOptionsScreen;
   }

   private SimpleOption<T> wcg() {
      MinecraftClient var1 = MinecraftClient.method_1551();
      return var1 != null && var1.field_1690 != null ? this.wbz.apply(var1) : null;
   }

   private boolean wch(SimpleOption<T> var1) {
      if (wby) {
         return false;
      } else {
         if (wbw == null) {
            wbw = vxr.find(
               SimpleOption.class,
               a.d("\uf4e7赝ޟ馴ሠ钕⻁ꜻ㥢돂㐂카䂱\ud95a卄햺濸\ue03b窈ﳵ番༽膈ᩜ", -316789129, -887170330),
               a.c(-2120991219, "㹠䟞촁卹\ud8a6帬\ue413淦\uf3b6礉ﻔ"),
               a.d("ۅ罒\uf58a毬\ue02c曓\udcc3唿쭯䇗왌㱝늧⬞ꅂ➵鷭ታ", 342774442, -1189129167)
            );
            wbx = vxr.find(
               SimpleOption.class,
               a.b("呇ⷽꜿ㤔늀㐵蹡ޛ駂።钢滔\ue011秺\uf3e4甚콘䂛\uda28展헊꾝ℨ뫼", 1812616241),
               a.c(-275416092, "箉ȷ裨ᚐ鵏ᯅꇺ⠀뙕㳡물"),
               a.b("䯭㉳뢬⛟굊⮹釨\u181c虈\u0cf6謬焕ﾞ昹\uec7d檗탐弌얺䏸쨔끐㻾ꔩ⍗꧇ဘ鹥ҙ苉ॼ\uf7f5", -262714495)
            );
            if (wbw == null) {
               wby = true;
               return false;
            }
         }

         if (this.wca != var1) {
            this.wca = var1;
            this.wci(var1);
         }

         return true;
      }
   }

   private void wci(SimpleOption<T> var1) {
      if (wbx != null) {
         try {
            final Codec var2 = var1.method_42404();
            wbx.set(var1, new Codec<T>() {
               public <R> DataResult<R> encode(T var1, DynamicOps<R> var2x, R var3x) {
                  return var2.encode(wbu.this.wcb && wbu.this.wcc != null ? wbu.this.wcc : var1, var2x, var3x);
               }

               public <R> DataResult<Pair<T, R>> decode(DynamicOps<R> var1, R var2x) {
                  return var2.decode(var1, var2x);
               }
            });
         } catch (RuntimeException | ReflectiveOperationException var3) {
            System.out
               .println(a.c(-603311661, "ㆅ䠻슦岘흐凥\uebab扜ﰂ盽\uf167ଌ薈ᱪ阫Ⴭꪑ╁뾶㦦끃쩁䒻\udf77奜폄橭\ue46f经\uf881猳跧ޡ鸕᠇鋷\u2d6dꜞ⇆롦㈠䳘웎䄼\udbe0喘\uec44曼\ue0b1筶\uf556࿎虤{骒") + var3);
         }
      }
   }

   private static void wcj(Throwable var0) {
      if (!wby) {
         wby = true;
         System.out.println(a.b("ⳃ啭\udfba䇖쨇䲷\uf6f9罛\ue151毻\uec27ᙁ颁ĸ譮ඒ럞㠁ꊻ⒵굘", 660810937) + var0);
      }
   }
}
