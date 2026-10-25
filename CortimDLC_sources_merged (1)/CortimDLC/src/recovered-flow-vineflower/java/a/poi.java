package a;

import flow.dev.a;
import java.util.function.Consumer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;

public final class poi {
   private static final long poj = 1500L;
   private static final int pok = 9;
   private static final EquipmentSlot[] pol = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
   private static final long pom = 1000L;
   private static final long pon = 15000L;
   private static final int poo = 3;
   private static final long pop = 4000L;
   private static final long poq = 30000L;
   private pof por = pof.NONE;
   private long pos;
   private long pot;
   private long pou;
   private long pov;
   private int pow;
   private String pox = "";
   private boolean poy;
   private boolean poz;
   private boolean ppa;
   private Object ppb;
   private boolean ppc;
   private String ppd = "";
   private Consumer<String> ppe = var0 -> {};

   public void notes(Consumer<String> var1) {
      this.ppe = var1;
   }

   public static boolean inLobby(PlayerEntity var0) {
      PlayerInventory var1 = var0.getInventory();
      boolean var2 = var0.getOffHandStack().isOf(Items.COMPASS);
      int var3 = var0.getOffHandStack().isEmpty() ? 0 : 1;

      for (int var4 = 0; var4 < 36; var4++) {
         ItemStack var5 = var1.getStack(var4);
         if (!var5.isEmpty()) {
            var3++;
            var2 |= var5.isOf(Items.COMPASS);
         }
      }

      if (!var2) {
         return false;
      }

      for (EquipmentSlot var7 : pol) {
         if (!var0.getEquippedStack(var7).isEmpty()) {
            var3++;
         }
      }

      return var3 <= 9;
   }

   public boolean active() {
      return this.por != pof.NONE;
   }

   public String status() {
      return this.por == pof.NONE ? "" : this.ppd;
   }

   public boolean takeReturned() {
      boolean var1 = this.poy;
      this.poy = false;
      return var1;
   }

   public String target() {
      return this.pox;
   }

   public void reset(Object var1) {
      if (this.por == pof.WAIT && var1 != null) {
         pjd.cancel(var1);
      }

      this.por = pof.NONE;
      this.pos = 0L;
      this.poy = false;
      this.poz = false;
      this.ppa = false;
      this.ppc = false;
      this.ppd = "";
   }

   public void onChat(Text var1) {
      if (var1 != null && this.por == pof.HOP) {
         String var2 = pfl.title(var1.getString());
         if ((
               !var2.contains(a.c(338120793, "吙ⷝ꜍"))
                  || !var2.contains(a.b("狅\u0b00膦ᾥ鑵\u12b1", 1730311810))
                     && !var2.contains(a.d("컟띯㶶ꏉ⠟껛ᒁ", -208382017, 2071960920))
                     && !var2.contains(a.c(678453728, "旚ᱦ雀࣊茗֪뾃"))
            )
            && !var2.contains(a.d("骚\ue326槫\uf78d籞\ufaea䂤줌圐\uddad婿ꀎ⻒띥㴡믁Ə", -1334311888, -2130141478))) {
            if (var2.contains(a.b("᨞控\ue975眎ﲦ稔쁆䧋", -638509525))
               || var2.contains(a.b("쟕빬オꪸ℘Ɬ᷵鐁ਡ肝̢﵌玚\uea21恼\ue68c岶퍮", -799161350))
               || var2.contains(a.d("허걸⚰뢕㌃떥\u0fe1蘘ᡂ鋾ᔮ\uef51憏", 1422492475, 1200182928))
               || var2.contains(a.b("賰\uf54b翭\ue1e9樴\uec84囒\udf25䅲쯋", -383285051))
               || var2.contains(a.c(1600547158, "浣ᓘ鹾z讯ങ띉㻋ꂗ⩓"))) {
               this.poz = true;
            }
         } else {
            this.ppa = true;
            this.ppb = MinecraftClient.getInstance().world;
         }
      }
   }

   public boolean tick(MinecraftClient var1, ClientPlayerEntity var2, Object var3, String var4, long var5) {
      if (var2 == null || var1.getNetworkHandler() == null) {
         return false;
      }

      if (!inLobby(var2)) {
         if (this.por == pof.HOP) {
            this.poy = true;
            pjd.at(var3, this.pox);
            this.ppe.accept(a.d("䃧㤏돟ⷓꘊ⒠髫ጕ襝߷耡穟\uf488洰\ue37b憗\udbd5倔컆䣬섚뭀㗷ꨲ", 1689199579, -123181258) + this.pox);
         } else if (this.por == pof.WAIT) {
            pjd.cancel(var3);
         }

         this.por = pof.NONE;
         this.pos = 0L;
         this.ppa = false;
         this.ppc = false;
         this.ppd = "";
         return false;
      } else {
         if (this.ppa && var1.world != this.ppb) {
            this.ppa = false;
         }

         if (this.ppa) {
            if (this.por != pof.NONE) {
               this.ppe.accept(a.c(218653959, "愲ᢧ鉶ఄ蟜Ĝ뼮㋍ꢀ☩ꇿ宁핑䳨웄䁇喝痜\ueb76洫\ue0c1骓ှ辂৲荟㻲뒾⹁갅⎭\udd79圹컈䢒옻姘\uf39d煑\ue89f抾᱅阜ᆨ譲ԅ벨"));
               pjd.at(var3, this.pox);
               this.por = pof.NONE;
            }

            return false;
         } else {
            if (this.pos == 0L) {
               this.pos = var5;
            }

            String var7 = pjd.key(var4);
            if (!var7.isEmpty() && var7.chars().allMatch(Character::isDigit)) {
               if (this.por == pof.NONE && var5 - this.pos < 1500L) {
                  return true;
               }

               if (this.por == pof.NONE) {
                  this.por = pof.WAIT;
                  this.pot = var5;
                  this.pox = var7;
                  this.pou = 0L;
                  this.pov = 0L;
                  this.pow = 0;
                  pjd.leave(var3);
                  this.ppe.accept(a.c(109342932, "瓯६螤᧐鈈ᒹ껣⌊뵝㏾됩乚삎夰팒冂\uefdf搜龜糥\uf517輺ǻ驟ᡌ銔ଓꕶ㮙뷄㘀첲䋠\udb1c奟힏栣\ue253撋﴾獵") + var7);
               }

               switch (this.por) {
                  case WAIT:
                     if (var5 < this.pov) {
                        this.ppd = a.b("룲셦䮺헋帕\udca6曯\ueb7f畛￫砳艆ࢅ", -1135559452)
                           + this.pox
                           + a.d("䎍㸡듺⺞ꅖ➛鷊ᑀ訕¡蜅礚\uf7c1橯\ue03d曀\udcff卒즟䮮옾밝㋛\ua97f⼂ꇄ", -955300825, 1681262480)
                           + (this.pov - var5 + 999L) / 1000L
                           + a.d("踁\uf3d1", 617470108, 267540159);
                     } else if (var5 >= this.pou) {
                        this.pou = var5 + 1000L;
                        if (pjd.enter(var3, this.pox)) {
                           this.pph(var1, var5);
                        } else {
                           this.ppd = a.d("旝᱉隕ࣤ茺Ɖ므㘬\ua87e⛟ꕭ彧톱䠋쉜䒬\ufaf6", 1246302321, 1179611558)
                              + this.pox
                              + a.d("\ue8d3锁ᾧ臕ท", -1157833919, -1735052361)
                              + 3
                              + a.d("\ue852闾ἠ脩\u0a8e豂㉴鮱◚ꭽⲬ횪尞솱䮛촘眢\uf886戴\ue469榆Ꮯ", -702390510, 1903277942)
                              + Math.max(1, pjd.position(var3))
                              + a.b("ꩪퟏ夌", 874228292);
                        }
                     }
                     break;
                  case HOP:
                     if (this.poz || var5 - this.pot > 15000L) {
                        this.por = pof.WAIT;
                        this.pov = this.poz ? var5 + 4000L : 0L;
                        this.poz = false;
                        if (++this.pow >= 3) {
                           this.pow = 0;
                           this.pov = var5 + 30000L;
                           pjd.leave(var3);
                           this.ppe
                              .accept(
                                 a.b("罼ۥ蠣ቍ駦ὕꔅⲎ닒㡦뮫䗂쬚嚼\ud8f4帀\ue440殑\uf12b獢ﺈ蓔\u0e77采ៃ鴓⒫\uaafe㐝", -1399096452)
                                    + this.pox
                                    + a.b("ꈌﮉ兮쬀䃖왫籈\uf5c5毤\ue535暁鲂ሠ诤Ƶ荓㤏뛝Ȿ깎", -1156734408)
                              );
                        }
                     }
               }

               return true;
            } else {
               if (!this.ppc && var5 - this.pos >= 1500L) {
                  this.ppc = true;
                  this.ppe.accept(a.b("清ᎆ鵎̺裢๓됉㧠ꞷ⤔껃咰\uda64䏚째䭨\uf535绶\ue024昏\ueffd闐ᬑ肵ʦ衲㇍뮁ⅵꌺⲙ퉅堍쇶䎵쵥狉\uf8b9繡\ue7d4涏ᝮ餠ẙ聛\u0a3d돩㥜뼗Ⓥꪵ", 565602852));
               }

               return false;
            }
         }
      }
   }

   private void pph(MinecraftClient var1, long var2) {
      this.por = pof.HOP;
      this.pot = var2;
      this.poz = false;
      this.ppd = a.d("\udd22꒶\u2e6a뀛㯅륶̿軙ႁ驅ᷭ\ue794椶\uf4e4窪ﱖ䈉즹危픡峝⚈갯", -1660041644, 1776361338)
         + this.pox
         + (this.pow > 0 ? a.d("囿⽆ꆂ㿲됩㋨裇ň魷", 966225484, -167102310) + this.pow + a.b("俞", -809611274) : "");
      var1.getNetworkHandler().sendChatCommand(a.d("ᛍ潳", -1990197013, -282651067) + this.pox);
   }
}
