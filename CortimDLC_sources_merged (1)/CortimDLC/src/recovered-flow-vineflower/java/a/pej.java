package a;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import flow.dev.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;

public final class pej {
   private static final Gson pek = new GsonBuilder().setPrettyPrinting().create();
   private static List<pdr> pel;
   private static int pem;

   private pej() {
   }

   public static List<pdr> items() {
      if (pel == null) {
         ArrayList var0 = new ArrayList();

         for (pdr var2 : pex()) {
            var0.add(var2.init());
         }

         pel = Collections.unmodifiableList(var0);
         peq();
      }

      return pel;
   }

   public static int version() {
      return pem;
   }

   public static int activeCount() {
      int var0 = 0;

      for (pdr var2 : items()) {
         if (var2.active()) {
            var0++;
         }
      }

      return var0;
   }

   public static void changed() {
      pem++;
      ewk.put(a.c(2107505088, "寧耗ે钶Ὠ駟⎛ꩱ㐳"), pek.toJson(pep()));
   }

   public static void resetAll() {
      for (pdr var1 : items()) {
         var1.reset();
      }

      changed();
   }

   private static JsonObject pep() {
      JsonObject var0 = new JsonObject();

      for (pdr var2 : pel) {
         JsonObject var3 = new JsonObject();
         var3.addProperty(a.d("褤\uf097穓\ue43f濷\ue955", 1483791487, -1086499524), var2.active());
         var3.addProperty(a.d("ꥧ탚娓쑹侴", -1754642389, 160096554), var2.count());
         JsonObject var4 = new JsonObject();

         for (phm var6 : var2.rules()) {
            JsonObject var7 = new JsonObject();
            var7.addProperty(a.c(947154806, "漀ᚶ鱰Ȕ角"), var6.state().name());
            var7.addProperty(a.c(-1548910883, "纴܌跌Ꭾ顰"), var6.level());
            var4.add(var6.key(), var7);
         }

         var3.add(a.b("贗\uf4a1繫\ue013毒", 1473809760), var4);
         var0.add(var2.name(), var3);
      }

      return var0;
   }

   private static void peq() {
      String var0 = ewk.get(a.b("\ue768黕ᐅ詴ƪ蜝㵙뒳⫱", -43587838));
      if (var0 != null && !var0.isBlank()) {
         try {
            JsonObject var1 = JsonParser.parseString(var0).getAsJsonObject();

            for (pdr var3 : pel) {
               JsonElement var4 = var1.get(var3.name());
               if (var4 != null && var4.isJsonObject()) {
                  JsonObject var5 = var4.getAsJsonObject();
                  if (var5.has(a.b("脶\uf885牁\uec2d查\ue147", 1654554961))) {
                     var3.setActive(var5.get(a.d("ퟔ깧⒣뫏ㄇ랥", -663213301, 808844472)).getAsBoolean());
                  }

                  if (var5.has(a.d("누쮹䅰\udf1a哗", 1782203586, 1099495072))) {
                     var3.setCount(var5.get(a.b("铩\ued54枝立爺", -1518037873)).getAsInt());
                  }

                  JsonObject var6 = var5.has(a.b("舻ﮍ煇\uef3f擾", -1869577652)) && var5.get(a.d("첀딶㿼ꆄ⩅", 206802968, -812360465)).isJsonObject()
                     ? var5.getAsJsonObject(a.d("᥉惿\uea35瑍ﾌ", -221201454, -1305697556))
                     : null;
                  if (var6 != null) {
                     for (phm var8 : var3.rules()) {
                        JsonElement var9 = var6.get(var8.key());
                        if (var9 != null && var9.isJsonObject()) {
                           JsonObject var10 = var9.getAsJsonObject();

                           for (Entry var12 : var10.entrySet()) {
                              if (((String)var12.getKey()).equals(a.c(-837813406, "ﬔ芢ࡤ阀᷆"))) {
                                 try {
                                    var8.setState(phj.valueOf(((JsonElement)var12.getValue()).getAsString()));
                                 } catch (IllegalArgumentException var14) {
                                 }
                              } else if (((String)var12.getKey()).equals(a.d("\ue599鰡ᛡ袃͝", -1502334077, -552872333))) {
                                 var8.setLevel(((JsonElement)var12.getValue()).getAsInt());
                              }
                           }
                        }
                     }
                  }
               }
            }
         } catch (Exception var15) {
            System.out.println(a.d("鰡\ue592潎\uf176竲ﰗ䘖쿰冫\udb1f岈ꚺ⡡뇓㮀뵸ܱ裷\u125f鐓ᶶ枫\ue91d狖\uf4ae縱잘", -792484746, 1364670511) + var15);
         }
      }
   }

   private static phm[] per(phm... var0) {
      phm[] var1 = new phm[var0.length + 4];
      System.arraycopy(var0, 0, var1, 0, var0.length);
      var1[var0.length] = phm.denyEnchant(Enchantments.field_9097);
      var1[var0.length + 1] = phm.denyEnchant(Enchantments.field_9121);
      var1[var0.length + 2] = phm.denyEnchant(Enchantments.field_9113);
      var1[var0.length + 3] = phm.denyEnchant(Enchantments.field_9109);
      return var1;
   }

   private static phm[] pes(phm... var0) {
      phm[] var1 = new phm[var0.length + 2];
      System.arraycopy(var0, 0, var1, 0, var0.length);
      var1[var0.length] = phm.denyLore(a.b("摲ᷢ霰ा苢Ы븈㞇", -377003931));
      var1[var0.length + 1] = phm.denyLore(a.b("\ude86ꜟⶸ돊㡯뻟҅起፟馟Ḻ\ue439滷", -276702570));
      return var1;
   }

   private static phm[] pet(phm[] var0, phm[] var1) {
      phm[] var2 = new phm[var0.length + var1.length];
      System.arraycopy(var0, 0, var2, 0, var0.length);
      System.arraycopy(var1, 0, var2, var0.length, var1.length);
      return var2;
   }

   private static phm peu(RegistryKey<Enchantment> var0, int var1) {
      return phm.enchant(var0, var1);
   }

   private static phm pev(String var0, int var1) {
      return phm.lore(var0, var1, true);
   }

   private static phm pew(String var0) {
      return phm.lore(var0, 0, true);
   }

   private static List<pdr> pex() {
      return List.of(
         pdr.of(Items.field_22022, 1, a.d("鑮\uedf7朦凌狷\uf43e丗잚姉팁咠\uaac8 릻㎚", 203294002, 1893504334))
            .deep()
            .rules(
               pet(
                  per(peu(Enchantments.field_9118, 7), peu(Enchantments.field_9124, 2)),
                  pes(
                     pev(a.d("ረ殂", 274560307, -1303092426), 3),
                     pev(a.c(-2066946083, "\ue3c6驕ႊ軸Ԩ菡㧊뀴\u2e60"), 2),
                     pev(a.b("⼧嚲\udc63䉫짆佹\uf522糖\ue284", -1507054800), 2),
                     phm.lore(a.d("셬룼㉛갣➋ꅌ᭭", 1669768812, -459054311), 3, false),
                     pev(a.b("\u12c1歑\ue1f5翳\uf42b狦죋䅍", 2142639837), 3)
                  )
               )
            ),
         pdr.of(Items.field_49814, 1, a.c(-1857174550, "쟽븞㒵\uaacfℚꞩ"))
            .deep()
            .rules(pet(per(peu(Enchantments.field_9118, 7), peu(Enchantments.field_50158, 3), peu(Enchantments.field_50157, 5)), pes())),
         pdr.of(Items.field_8547, 1, a.c(1990404211, "ⱙ喊\udf2c䅟쫼䰿\uf668翪"))
            .deep()
            .rules(
               pes(
                  pev(a.d("邺\ue968掺ﶷ癡\uf0ae", 1948500406, -1053731541), 3),
                  pev(a.c(351539390, "ᒫ浅\ue7ee秥\uf23f瓷캧䝞\ud904厸"), 2),
                  pev(a.b("⇦塌튕䲗읁", 1652237762), 3),
                  pew(a.c(300112763, "形⛿갥㉑맴㼵蔟ಒ鋅ᡱ龯")),
                  pew(a.b("룱셡䮸햽幡\ud8a9拵\ueb01畜", -1123762969))
               )
            ),
         pdr.of(Items.field_22027, 1, a.b("幮⟷괦㍕룷㸾萗ක鏉ᤁ麠惈\uea77玵裡缐", -973841821))
            .deep()
            .rules(per(peu(Enchantments.field_9111, 5), peu(Enchantments.field_9119, 5), peu(Enchantments.field_9127, 3), peu(Enchantments.field_9101, 1))),
         pdr.of(Items.field_22028, 1, a.c(1094441149, "\udcb5ꔬ\u2ffd놎㨬볥ی轁ᄒ鯚ᱻ\ue213棙\uf165笵ﶷ䟻졝勧풳嵆"))
            .deep()
            .rules(per(peu(Enchantments.field_9111, 5), peu(Enchantments.field_9119, 5), peu(Enchantments.field_9101, 1))),
         pdr.of(Items.field_22029, 1, a.d("梱ᄨ鯹֊踨࣡니㭅ꔖ\u2fdeꡳ嘗\udcdf䕯켿䧍\uf38a籕", 853925532, -1189039582))
            .deep()
            .rules(per(peu(Enchantments.field_9111, 5), peu(Enchantments.field_9119, 5), peu(Enchantments.field_9101, 1))),
         pdr.of(Items.field_22030, 1, a.b("㏌䩕삄廷핕厜\ue9b5怸﹫璣\uf30e൪螬Ḓ鐽\u12b6꣼✪붛", -1080019006))
            .deep()
            .rules(per(peu(Enchantments.field_9111, 5), peu(Enchantments.field_9119, 5), peu(Enchantments.field_9128, 3), peu(Enchantments.field_9101, 1))),
         pdr.of(Items.field_22021, 8, a.d("糟Ԍ辯ᇑ騃Ჸ", 379193225, -1190822030)).rules(pes(pew(a.b("䈬㮷넕⽧ꃈ♣頍ᇔ迾Ռ芔碕\uf646濻\ue5d7杉\ud91c囌챱䩗쏘릃", -1731901920)))),
         pdr.of(Items.field_8479, 12, a.d("㎿䨓샏庳픛埅\ue989怌︣瓥", -415094037, -1671094927))
            .rules(pes(pew(a.b("⢋儐\udbb2䗀쩯䳄\uf296筴\ue52c濪\ue845ሸ鳭ԣ謟ৼ돀㱯ꚨ\u20fa\ua97f팤", -1200280441)))),
         pdr.of(Items.field_8614, 4, a.b("\udbe9ꉷ⢬뚧㵳뾭Ǯ衬ᘰ鳱", -2048925710)).rules(pes(pew(a.b("妑 ꪨ㓚뭵㷞莼\u0a62鐵ẇ餠捒\uedf5瑃︘磩슫䴅폙冘\ud81cꉎⲍ", 394223004)))),
         pdr.of(Items.field_8449, 16, a.b("齎\ue6de氏\uf277秞７䕉첰劐\ud853忶ꗹ⭙", 1010277207))
            .rules(pes(pew(a.d("謜\uf287砥\ue657槸\uef53儷\ud8e3䛍찅䯒놯㽺ꚴ⢈ꩫဨ鿼Չ茕", 1331551435, 105141209)))),
         pdr.of(Items.field_49098, 32, a.b("ﶼ萪ຉ郷᭛駾➿깉ち뫒㵱", -859309664)),
         pdr.of(Items.field_8551, 16, a.c(-1931205238, "←堅틝䳝윉")).rules(pes(pew(a.d("∠宻턙佫샄䙯\uf801燘\ueff2敀\ue298ᢙ陊\u0ff7藛݅륫㚹걽⨤ꏞ", -398967956, -1606607549)))),
         pdr.of(Items.field_8543, 4, a.c(241640080, "⚡弌헗䮥쁺䛏\uf886畠\ueb38憅\ue654ᱛ鋲\u0b4a脔߯")).rules(pes(pew(a.b("柿Ṥ铆\u0ab4蔛ΰ뷘㐇꩙ₓꜲ嵎폦丸쀊䛾ﳀ獤\ue9a7", -5938186)))),
         pdr.of(Items.field_8288, 1, a.c(-2038713672, "뚊켧䖈\udb8e偐틽沿\ue54a筡\uf1d0百谆ʤ鬗ᄾ鞸")),
         pdr.of(Items.field_8399, 1, a.c(-1848324022, "푝궼✞륮㊲됍ษ"))
            .rules(per(peu(Enchantments.field_9098, 3), peu(Enchantments.field_9101, 1), peu(Enchantments.field_9108, 1))),
         pdr.of(Items.field_8463, 16, a.b("᤻患\uea75琁ﾪ祧쌿仛퓫帤\ud9fd⎉굚㓯", -903013086)),
         pdr.of(Items.field_8367, 8, a.c(-2078364425, "ꣷ텡寅엃乤좫狴\ufb07敕\uefe4栴鉎ᢌ蔪\u0f70覄㏎뱣⚬ꃶⴔ匪\udde7")),
         pdr.of(Items.field_8071, 64, a.d("㑎䷖윀奴틟吜\uee30掮吝獞\uf4f3\u0ef8耫ᦖ鎻", -1827240336, -1257589210)),
         pdr.of(Items.field_8233, 64, a.c(-1284661750, "騪\ue380椭\uf75f粊")),
         pdr.of(Items.field_8833, 1, a.c(-782763084, "ﾟ蘸೨鋣ᤶ龌")),
         pdr.of(Items.field_8639, 64, a.c(772165441, "䭬㋌렓♮귌⬏酛ᣟ蛺")),
         pdr.of(Items.field_8436, 1, a.b("\uf423趌ݚ餪ኁ鐻⸚\ua7e1", 1651372046))
            .color(16711680)
            .effects(
               pim.effect(StatusEffects.field_5909, 10, 200),
               pim.effect(StatusEffects.field_5904, 5, 300),
               pim.effect(StatusEffects.field_5919, 10, 100),
               pim.effect(StatusEffects.field_5912, 1, 3600)
            ),
         pdr.of(Items.field_8436, 1, a.b("鋽\ueb5f懱ﾍ琨\uf2e6䳚섹彪헑分", -1472882985))
            .color(16777215)
            .effects(pim.effect(StatusEffects.field_5924, 2, 900), pim.effect(StatusEffects.field_5905, 2, 12000), pim.effect(StatusEffects.field_5915, 2, 0)),
         pdr.of(Items.field_8436, 1, a.d("\u0e7a矩ﴴ挲\ue89c樸푘嶇쏐䥦캷", -57942152, -1133652706))
            .deep()
            .color(10040115)
            .effects(pim.effect(StatusEffects.field_5910, 5, 600), pim.effect(StatusEffects.field_5909, 4, 600)),
         pdr.of(Items.field_8436, 1, a.c(692416365, "歵ዦ頻ؽ趓༷녛㢅ꛑⱠꮸ凍\udf16䚢쳼"))
            .color(65535)
            .effects(
               pim.effect(StatusEffects.field_5907, 1, 12000),
               pim.effect(StatusEffects.field_5918, 1, 12000),
               pim.effect(StatusEffects.field_5914, 3, 1200),
               pim.effect(StatusEffects.field_5905, 1, 18000)
            ),
         pdr.of(Items.field_8436, 1, a.b("武ድ頨خ趀༤녇㣧ꚸⱸꯚ凒\udf00䚼", 1739091839))
            .color(3355443)
            .effects(
               pim.effect(StatusEffects.field_5910, 4, 1200),
               pim.effect(StatusEffects.field_5904, 3, 6000),
               pim.effect(StatusEffects.field_5917, 1, 1200),
               pim.effect(StatusEffects.field_5921, 2, 0)
            ),
         pdr.of(Items.field_8436, 1, a.b("喧ⰴꛩ㣯덁\u31e5辶ٗ頌\u12b1镪潭\ue1c4硵", -779988546))
            .color(3329330)
            .effects(
               pim.effect(StatusEffects.field_5899, 2, 300),
               pim.effect(StatusEffects.field_5920, 2, 300),
               pim.effect(StatusEffects.field_5909, 3, 300),
               pim.effect(StatusEffects.field_5903, 5, 300),
               pim.effect(StatusEffects.field_5912, 1, 300)
            ),
         pdr.of(Items.field_8436, 1, a.d("ᰶ斛\uef4b煆\ufae1籜왱俽톡嬛", -281771746, 1163630851))
            .color(4737096)
            .effects(
               pim.effect(StatusEffects.field_5911, 2, 1800),
               pim.effect(StatusEffects.field_5901, 2, 200),
               pim.effect(StatusEffects.field_5920, 3, 1800),
               pim.effect(StatusEffects.field_5919, 1, 200)
            ),
         pdr.of(Items.field_8574, 1, a.b("附\uefd7攊\ufb0c炢", 891064918))
            .query(a.d("\ue2fd鬵ᇥ辕ш", 905002598, -2078680865))
            .effects(pim.effect(StatusEffects.field_5910, 3, 3600), pim.effect(StatusEffects.field_5904, 3, 3600)),
         pdr.of(Items.field_8574, 1, a.c(-1367766924, "豲\uf5e1缼\ue13a檔\ue830嘃\udf87䇞쭩䲲뛋㡩ꆨ⮍괂ᝍ"))
            .query(a.c(1451822281, "ࣴ焼ﯨ旪\uee33"))
            .effects(pim.effect(StatusEffects.field_5915, 2, 0), pim.effect(StatusEffects.field_5924, 1, 900)),
         pdr.of(Items.field_8087, 32, a.c(755972333, "㳸䔓쾾凃\uda16岥\ue6f4潺\uf54a箚ﱊع袛ᄤ魼"))
            .effects(
               pim.effect(StatusEffects.field_5911, 3, 60),
               pim.effect(StatusEffects.field_5919, 1, 40),
               pim.effect(StatusEffects.field_5901, 1, 40),
               pim.effect(StatusEffects.field_5916, 1, 100)
            ),
         pdr.of(Items.field_8087, 64, a.d("䧃】뫀Ⓞ꼝⦧韤ᨋ葛\u0ee0褽獍ﶛ搢\uee79梀틊嵬", 406160219, -1813786965))
            .off()
            .effects(pim.effect(StatusEffects.field_5909, 10, 100), pim.effect(StatusEffects.field_5901, 3, 40)),
         pdr.of(Items.field_8087, 64, a.b("솞롰㊧격✄ꇂᮟ鈙ష蚋ħＹ疏\uec3d晬\ue0e8媩핳", 103335312))
            .off()
            .effects(pim.effect(StatusEffects.field_5909, 3, 100), pim.effect(StatusEffects.field_5920, 3, 100), pim.effect(StatusEffects.field_5899, 3, 100)),
         pdr.of(Items.field_8288, 1, a.b("赑\uf4f2縪\ue058毶\ued3a坥\ude99䓛쩐䷙랫㥷ꂶ⪟같ᙘ駽", 247499105))
            .off()
            .deep()
            .attrs(
               pim.flat(EntityAttributes.field_23716, 4.0),
               pim.flat(EntityAttributes.field_23721, 3.0),
               pim.flat(EntityAttributes.field_23725, 2.0),
               pim.flat(EntityAttributes.field_23724, 2.0)
            ),
         pdr.of(Items.field_8288, 1, a.d("\u0acf獬領柆\uec68檤탻备썅䷴쨷ぁ뺕✮괃⮂", -798848842, 973178443))
            .off()
            .deep()
            .attrs(
               pim.flat(EntityAttributes.field_23721, 4.0),
               pim.flat(EntityAttributes.field_23716, 2.0),
               pim.scaled(EntityAttributes.field_23719, 0.10000001817743467),
               pim.scaled(EntityAttributes.field_23723, 0.10000001817743467),
               pim.flat(EntityAttributes.field_23724, -3.0)
            ),
         pdr.of(Items.field_8288, 1, a.c(1366396821, "许\uf21b磃\ue6b1洟\uebd3册\ud870䈲첁䭈녁㿦ꙚⰄ"))
            .off()
            .deep()
            .attrs(pim.flat(EntityAttributes.field_23721, 2.0), pim.flat(EntityAttributes.field_23724, 2.0), pim.flat(EntityAttributes.field_23716, -4.0)),
         pdr.of(Items.field_8288, 1, a.d("炦अ菝ᶯ阁Ⴭꪒ⍮뤬㞒뀮䨡쒉崻휒", -1235384766, 1483862729))
            .off()
            .deep()
            .attrs(pim.flat(EntityAttributes.field_23721, 5.0), pim.flat(EntityAttributes.field_23716, -4.0)),
         pdr.of(Items.field_8288, 1, a.c(-1333460296, "ڔ缷\uf5ef殝\ue033替\udca0啜켞䆝왤㱨늺⬄"))
            .off()
            .deep()
            .attrs(
               pim.flat(EntityAttributes.field_23716, 2.0),
               pim.scaled(EntityAttributes.field_23719, 0.1500000347540806),
               pim.scaled(EntityAttributes.field_23723, 0.1500000347540806)
            ),
         pdr.of(Items.field_8288, 1, a.b("⡚凹\udb21䕓컽䠱\uf26e箒\ue1d0潝\ue8d2ዓ鰎ֵ", 109194358))
            .off()
            .deep()
            .attrs(pim.flat(EntityAttributes.field_23724, 1.5), pim.flat(EntityAttributes.field_23716, 1.5)),
         pdr.of(Items.field_8288, 1, a.c(-534412169, "聚粒猡\ued53曽\ue031婮펒䧐읕䂧뫟㐊궸⟦"))
            .off()
            .deep()
            .attrs(pim.flat(EntityAttributes.field_23721, 2.5), pim.scaled(EntityAttributes.field_23723, 0.10000001817743467)),
         pdr.of(Items.field_8288, 1, a.d("鷩\ue44a溒\uf0e0筎ﶂ䟝측呣\udae8崑꜐⦷끴㩐벯ڔ", -653624167, 935585091))
            .off()
            .deep()
            .attrs(
               pim.flat(EntityAttributes.field_23721, 7.0),
               pim.flat(EntityAttributes.field_23716, -4.0),
               pim.scaled(EntityAttributes.field_23719, 0.10000001817743467)
            ),
         pdr.of(Items.field_8575, 1, a.c(-831847836, "َ羚\uf538欼\ue09b戺\udc6c喈쯙䄗욵"))
            .off()
            .deep()
            .skin(
               a.c(
                  1649305901,
                  "梬ᄏ鯄ֽ蹄ࣿ능㬮ꔠ⾧ꠒ刾\udce6䔇켵䧾\uf3bb籐\ue6fa悃\ue954錈ᶐ虉\u001c諔㍐뵓⟘ꆀ⨾풕度읜䄒쯊瑠︈磤\ue149欬ᗓ龴ᠹ苬ಗ땆㿟릚≠갑囼\udf67夁쏳䶽\uf62b烵謹捩\uedfc鞍ၖ驰Ӏ赻㜢뇢㮃ꐆ\u2efdꢴ兛\udbdd䖱칻䠋\uf2b3筢\ue52c激\ue9fa鈲Ლ蚐༾觶㏟뱈☭ꂩ⥈팏巃왢䁖쫤璲ﵙ某\ue1a0樮ᐅ麗ݬ脽\u0bce됀㸿룇⊎ꬅ嗺\udf81塚숭䲴\uf542缝立打\uec52雉Ⴒ餗ϣ趁㙉뀐㪯ꌚⴶퟄ偕\uda2e䒨캈眳\uf1e9箦\ue45c滬\ue8ad酾ᬃ藟์蠒㋒벏┶꿝⦒퉩峲욅作줪玹ﱖ昳\ue0aa櫾ጒ鷉ޔ聙ે뒻㵆꜉↞ꩆ同\uded1䝆섚䯅\uf58d繡\uf8f4抅\ueb5e镸Ᾰ顨ȁ賻㕑뼳㧂ꎵⱊ훑傪\ud97d䌄춒白\uf032竤\ue378洱ឣ醦ᨙ蓱ຬ띐ㄡ뮺␜긔⣄테嬥엘侃젲狅ﲜ敇\ueffd榲ቺ鱨ۧ轵त돵㶎Ꙉ⃨ꪘ印\uddf9䞬쁗䨆\uf491絰\ue72b懚\uebad鐴Ể颉ŷ诓㖣빚㠥ꊺ⭍픖忯\ud9a8䈰쳹盪ｮ秸\ue380汨ᘍ郃ᥱ茾\u0de0뙼〵몧Ⓔ굥埭톐婑쐡从\uf75e焳ﯭ摥\uee08棶ኩ鬱\u05cb辍࡛뉾㲏ꕷ⼄꧞剈\udc05䛗삕䥆\uf3c1綜\ue651惏\ueaa3鍻ᵢ蟦s詞㓚뻽✨ꇷ⮆퐱廬\ud8d6䅅쬬痓﹒砲\ue2e2沃ᔑ鿺᧪艘\u0cda뚇㽺뤋⎰걮嘯탔媟쌾䶘\uf790灦\ufaf9撇\ued5c霪ᆢ驘Л軐㝔녗㯤ꗪ⹆ꢈ加\udb5b䔙쾕䡯\uf23d糆\ue54b漫\ue9c0鎯ᰚ蛠¼襚㍸붰♫ꀍ⫦퍫崴쟞䆵쨸瓠ﺝ杫\ue113殕ᑾ鹯ᣗ腨ଦ떪㾈렙⋔겙啌\udff7妦쉱䰐\uf6cb罺懶揔\ueda1陎Ⴢ骵͇践㞉끌㨜꒥ⵎ휠凱\udb8a䑌커䢔\uf17c篵\ue5a8湓\ue802銕᭬蔗࿆衑㈰볫⚚꽣⧟펻尦옥䂫쥷猤\ufdeb晼\ue020櫸ᒡ鵀ߖ膥੩됬㺫ꜟℷꯂ呙\ude22壵슌䬷\uf5e6羱\uf850戀\ueccb镡ἔ駏ɾ谉㛘낈㥃ꏩ\u2d9c홇僵\udadf䍪촶瞻\uf007"
               )
            )
            .attrs(
               pim.flat(EntityAttributes.field_23716, -4.0),
               pim.flat(EntityAttributes.field_23724, 1.5),
               pim.flat(EntityAttributes.field_23721, 2.5),
               pim.scaled(EntityAttributes.field_23719, 0.07000004566537438),
               pim.scaled(EntityAttributes.field_23723, 0.13000000024761527),
               pim.scaled(EntityAttributes.field_49078, 0.09000001839414021)
            ),
         pdr.of(Items.field_8575, 1, a.c(731667733, "夸⃬\uaa4e㑊뿭㵌茞૾铓Ḙ馳掲"))
            .off()
            .deep()
            .skin(
               a.b(
                  "\ueec7靤ᶯ菖\u082f躔㓎뵅⍋꧌\u2e79푕媍썬䥞쾕痐層悑\ue6e8漿ᕣ鯻\"虷ಿ딻㬸ꆳ⟫걕勾\ud8cd䄷읹䷦\uf209硳ﺱ本\ued45鎸᧟鹒҇諼㌭릴㿱ꐋ⩺킗夌\udf6a䖘쯖灀\uf69e糔\ue502殗ᇦ阽ᰛ芫ଐ녊㞚뷫≃ꢕ⺁휤嶱쏎䠐칣璭ﴙ捊\ue9a8濎ᑝ髱ø褍྿떰㨵ꁿ⛞꼥啳\udbbb䀿왴䲌\uf2e7笌\ue1bd柋\uec0d鉀\u18fc脐ݑ趲㈱롔㺼ꓥ\u2d6e펑姪\ude31䑆쫟猩略羜\ue438樹Ⴂ雙ὼ薈௪뀢㙻별╱ꭝ冯혾居싃䣣\uf158瞂ﷀ户\ue887滤ᜍ鵖Τ衩\u0e6b뒔㫤ꍝ⦶꿹吂\uda99䃮줷佁\uf5d2稽\ue058曁\uec95镹ᮢ臿ز責㋐묭ⅢꟵⰭ퉧墺섭䝱춮珦\uf80a纟\ue4ee洵ጓ駓ḃ葪ઐ댺㥘뾩◞ꨡ傺훁弖앯䯹\uf016癙ﲏ攓\ueb5a釈៍鱲ʚ裇ㄻ띊㷑ꉷ⡿꺯圧\udd4e䎳짨乙\uf4ae竷\ue32c榖\uefd9鐑ᨃ肌ञ轏㖞믥‣ꚃⳳ픛宒쇇䘼챭狺\ufb1b慀\ue7b1淆\u125f颩Ợ蜜ම돈㠱빎ⓑ괦卽\ud984心쑛䪒\uf081礅ﾓ旫\uea03遦ᚨ鼚Օ讋〗뙞㳌ꋑ⬎톆埻\udc3a䉊좥焵\uf758綆\ue20e档\uee9d铂ᵚ莠০踰㐕뫤⌜ꥯ⾵퐣婮삼䛾켭疪ﯷ怺\ue6a4泈ᔐ鬈ǒ蘘౽늲㣍ꅕ➜귽剙\ud891廛윔䵄\uf3ac研﹚撙\ueae8鍀ᦒ鿟Ф誟ャ뤃㽠ꗵ⨆큐嚽\udcf4䕚쮫燹\uf623粼\ue2e9欠ᅬ韝ᱹ艤ࢅ넉㝴붛⏙ꠡ⻡퓜崰썱䦥츅瑬調捪\ue940澨ᗪ驵\u009f蚱༾땉㯛ꀽ♹겜唃\udb5f䆾쟄䱄\uf298磹\ue115杻\uedc4鈅ᡆ麼܃赑㏆맣㹲꒿⫲팧妜\udfcd䐚쩻炠螺罦\ue5bf毊ဥ隩᳞蔬ஞ뇢㘧뱷⋎ꬥ克힚巡숧䢏컿眗ﶞ揃\ue838湩ᓾ鴇ͼ覭ฺ둛㪀ꃱ⤈꾴嗐\uda4d䁎움伜\uf54f简\ue017晋\uec93鋊ᬫ膽ߎ谂㉇룀ⅴꝜⶩ툲塉\ude9e䓧최玍栗縻\ue46b檠ጊ饿ᾤ萕\u0a62낳㛣뼨▂꯷倬횞岴씁䭝\uf1d0癬",
                  984215366
               )
            )
            .attrs(
               pim.flat(EntityAttributes.field_23721, 2.0),
               pim.scaled(EntityAttributes.field_23728, -0.10000000768432185),
               pim.scaled(EntityAttributes.field_23723, 0.1500000347540806)
            ),
         pdr.of(Items.field_8575, 1, a.c(431571327, "䕒㲆똤⠠ꎇΩ齄ᚑ袺Ȉ薡翐"))
            .off()
            .deep()
            .skin(
               a.d(
                  "訯\uf38c祇\ue73e泇\uea7c倦\ud9ad䞣촤䪑낽㹥Ꞅⶶꭽᄸ黓ѹ舀ௗ熋３擊\ue29f桗퇓忐앛䌃좹㘕밧◡ꎯ⤃雠Მ驧χ覯\uf750紷諸息\uee14埅\udd5c嬙샣互둿㷤뮂ⅰ꼾ᒨ鉶ᠼ自ཿ甎\uf2d5磳\ue643濸햡匨\ud903䚅챹䨧돌㥤ꜩ⳩ꪈ၅駩ߥ赀ଏ炡︙搐\uedd8歭텝廋쒔䈥쯖\u318f뼵ⓡꋗ⡰阱\u1fc5蔍̴裵\uf6a7籍\ue5ec掇\ue946四\udcbf婄쀍䦆띹㴂뫙₮긷េ鶞᭴胐໑瑊\uf231箔\ue160漂퓊劓\ud82c䆙쾵㕇닖㢭ꘫⰋ閰፪餇۟豚ਈ玧僚杓\uecf5檀큒帎잓䵊쬛ダ빺␛귷⮐鄐Ố蒳Ƀ蠚\uf1c8罍\ue532拚\ue86e嘸\udfcb䖆썀䣇뚏㱎ꗙ⎠ꥨᜑ鳮ᩱ耆\u09de矽ﴑ竍\ue086湭ퟺ嶦\udb7b䄢컃㑸눢㮩ꆔ⼧铄ይ顦ǫ辪\uf57d猥\uf88e晭\uec32嗕펢夺욞䲝쩦㏽릊❛관⪱遈ḃ螷ീ謯\uf0fe纲\ue441淞\ueba1其\udf0e䓊쉡䠺뇁㽖ꔯ⋔ꢅᘒ鿳֨荒ॸ皝ﱂ稫\ue3e4楻휧峿\udaa6䀿짊㞼봵㬮ꂳ\u2e69鑯᷂魆ŕ躭\uf498爫\ufbc8懡\uef62哯튮塹옹俲딍㌝룿⚘걉ᗁ鎋ᤰ蛺ಉ詌\uf029禥\ue750洈\ueaf6傞\ude49䟢췬䭞냑㺇ꑛ−ꯀᅅ鼺ӑ艃࠴燿ﾉ敱\ue2f3梸홚尧얿䍷줳㛻뱹㨣ꏒ⦬靅ᳬ骲s踔\uf7ab絀הּ惛\uee64吩\uddeb実섍仇뒬㉃렜↢꽂ᔇ鋥ᡘ蘀\u0fdf疗\uf31b碕\ue698汓헗厒\ud970䜜쳎䩔뀠㧛ꞯⴇꫯႾ鹊ߚ趩\u0b53焁ﺍ摠\ue22f毕톱弧쓕䊕존ㇼ뿑╁ꍵ⢻陠ᰎ藭·褁\uf6c4粰暑揬\ue9a5坮\udd01媚쁡丶럏㵴묥\u20f2꺓ᑈ鷲ᮝ腄༗璮\uf245砈\ue1c4潶핑勏\ud894䘽쿂㖥덲㤊ꛎⱭꨶᏍ饚ܫ賐ઁ瀖璘枔\ued45櫒킳幆쑩䷿쭤ㄨ뻊Ⓘꈻ⯊醑ἷ蓿ʤ衞\uf63f翨\ue57c挄\ue8ed嚇\udc18䗃쎺䥋뛰㲡멶\u200fꦴᝦ鵬\u1ad9肢ู矎ﶗ筌\ue0fe滔푑刪\udbb1䅆켰㓖뉄㡜",
                  -604419871,
                  -1556954293
               )
            )
            .attrs(
               pim.flat(EntityAttributes.field_23724, 1.0),
               pim.flat(EntityAttributes.field_23716, 4.0),
               pim.scaled(EntityAttributes.field_23719, 0.10000001817743467),
               pim.scaled(EntityAttributes.field_23723, 0.10000001817743467)
            ),
         pdr.of(Items.field_8575, 1, a.d("অ灑\ufaf3擷\uef50深펒娳쐙仜쥾", -356596800, 1681444463))
            .off()
            .deep()
            .skin(
               a.b(
                  "脡\uf882牉\uec30柉\ue172嬨튣䲭옪䆟뮳㕫겊⚸ꁳᨶ闝ཷ褎Ù窅\uf41d濄\ue991捙\udadd哞칕䠍쎷㴛뜩⻯ꢥ≄鷮ផ酋ࢂ芢ﱎ瘹\uf1b4歡\ue51a峋홒倗쯭䖜뽱㛪낌⩾ꐰᾦ饸ጲ諤ѱ縀率珽\ued4d擶\udeac塿툙䶦읯䄫룕㉗갯➭ꆇᬮ鋤ರ虙/箳\uf517漞\ue6d6恷\uda51嗓쾉䤰샃㪖둳\u2febꦓ⍪鴯ᓃ踃࠭菕ﶡ看\ueee1梚\ue25b嶋\ud7a5兰쬃䊈뱷㘌뇗⮠ꔹ\u1ccf隐ၺ诞ן罄錄炚\uea6e搌\udfc4妝팢䪗쒻㹉맘㎣괥✅麾ᡤ鈮෬蝡Ĥ磳\uf2b6汝\ue7e3憎\udb5c唀첝䙄쀕㯎땴⼕\ua6f9\u209e騞ᗞ辽्茔陼瑃\uee3c槔\ue360崶퓅予졎䏉북㝀껗⢮ꉦᰟ韠ᅿ謈ː糳\uf61f燃\ueb88散\udcf4嚨큵䨬엍㽶뤬ェꪚ\u2429鿊᧣鍨\u0ae5蒤ﹳ砫\uf380浣\ue73c廛\ud8ac刴춐䞓셨㣳늄ⱕ꘎↿魆ᔍ貹َ耡ﯰ疼\uef4f曐\ue0af婸퐀俄쥯䌴뫏㑘긡⧚ꎋᴜ铽\u0ea6衜ɶ經\uf74c焥\ue8ea扵\udc29埱톨䬱싄㲲똻〠ꮽ╧齡ᛌ遈ਜ਼薣ﾖ礥\uf0c6櫯\ue46c忡\ud9a0卷촷䓼븃㠓돱ⶖꝇỏ颅ሾ跴އ腂ﬧ犫\uec5e昆\ue1f8宐핇䳬웢䁐믟㖉꽕⤜ꃎᩋ鐴\u0fdf襍̭竟\uf493渵\ue9e9掶\udd40圩캲䡀숔㷧띢\u3104꣔⊢鱊១醂\u0b7a蔚ﲵ癁\uf024毂\ue50f弼훳傒쨭䗎뾰㥎댁⪬ꑏḞ駻\u137f赑ӆ纠\uf82b珗\ued95杣\udee3壘퉩䰁쟀䅜묮㋅게☛ꇡᮊ镔\u0cd4蚦t稄\uf597潺\ue91f惱\udaf2吪쿦䦗쌳㫱뒺⹗꠵⎡鵄ᜏ軳ࢉ艇﷿瞮\uf159棢\ue2ab屠혏冔쭯䔸볁㙺뀫⯼ꖝ\u1f46雼႓詊Й羠屢猆\ueaca摸\ude5f姁펚䴳쓌㺫롼㈄귀❣ꄸᣃ鉔థ蟞Ə笘\uf2e1沚\ue64b懜\udbbd啈콧䛱쁪㨦뗄⾰ꤵ\u20c4骟ᐹ迱প荐ﴱ瓦\uee72栊\ue3e3嶉휖仍좴䉅뷾㞯노⬁ꊺᱨ院ᇗ讬Է糀\uf699灂\uebf0旚\udf5f夤킿䩈쐾㿘륊㍒",
                  1495892132
               )
            )
            .attrs(pim.flat(EntityAttributes.field_23721, 6.0), pim.flat(EntityAttributes.field_23724, -2.0), pim.flat(EntityAttributes.field_23716, -2.0)),
         pdr.of(Items.field_8575, 1, a.b("皜\u0f48藪ᯮ遉የ겈╒묁㇄똜", -206671178))
            .off()
            .deep()
            .skin(
               a.b(
                  "횆꼥◮뮗の뛕ಏ蔄ᬊ醍ᘸ\uec14拌שּׂ焟\uf7d4䶑쉺壐\udea9坾ⴢꎺ㡣븶㓾赺\u0379駲ᾪ鐔檿\ue08c祶Ｔ疪쩊䀜웠张픆ꯃ↞ꘓ㳆늽୬臵ް鱊ሻ\ue8d6慍\ue72b緙\uf397䠁컟䒕\udd43取⦧깼\u245a뫪㍑褈ཱྀ薨ᨑ郟ᚙ\uef71旍ﮀ瀍\uf621䲊앀嬄퇽垥Ⰰꊰ㢸녢㟶足ɢ頾Ẉ靿洦\ue3c4硋︦瓚쪘䍰\ud9e9徝푲\uaa37₸륒㼮뗼ਭ耀۽鲤ᔯ\uebd0憫\ue670簇\uf29e䭨섷䟝\udc79剸⣣꺘✽뷉㎫衣ฺ蒅ᴰ錜槮\uee7f搄廒炢줙促얬婎킬嚡⽉ꔡ㯧끛㘵賭ʾ鬄ᇭ鞷汫\ue2f6碯\uf176眭춗䉶\ud822廥풅괥⏞릮㹷뒥ન荗\u193f龋ᑕ\uea26惫來缲\uf5da䮻쁌䛍\udc85啼⬃ꆔ♣밻㊘譼Ġ蟫ᶀ鉯棓\ueeae杗ﴮ玕졏乄쓱嵂팡ꦈ⾋ꐆ㫇낐ॐ輛֘驧း雏潗\ue573篸\uf183瘘쳯䊶\udb6d凜\ud7a5걖≂룕ㅚ뜓ෟ莬ᠳ黄ᒓ\ued6b掯歷繗\uf42c䪻썚夁\udff0喇⨞ꃅ⚿뼕㗸讧N蘁Ზ镊欒\ue1cb枪ﰿ狩죀䅃쟞嶄툂ꠧ⺣ꜰ㵈돵ࡆ踥Ҍ骗፺\ue9db澬\ue454稟\uf0e0䥰켚䗽\uda2c値훦곝┗믤㆙뙜ర芥᭥鄛៳\uec24戇\uf889纻\uf734䷪쎶塿\udead咰ⵯꌤ㧖빚㑴諠\u009e餂\u1ff0閼橐\ue0d0暉ｬ畞쯬䁆옛峛튨ꬂ⇀ꞃ㱱닎࢜脈ܵ鶙ቘ\ue80b滾\ue48f紟\uf3e8䦹칡䓄\udaf0卶⤮꾺\u2439먱リ襓༡藌ᮥ遨ᛨ\uec88敱ﬨ熣\uf646䰾싁孲턀埪ⶊꈦ㣜뺅㝠贙\u038d顫Ḭ钖浔\ue31e秴ￛ琑쫴䂤\ud955弮햿\uaa5b’ꛪ㽁디\u0bce膦س鳀ኋ\ueb6c懷\ue78c籛\uf23a䣡셐䜧\uddfe厥⠟껰⒡뵲㏋覠\u0e65萩\u1a9b錼椚\uefe1斨嘆烈\uf69f佧얣守큓嘨ⲿꕆ㬽뇬㙻谚ˁ颰ᅇ韞涫\ue204砒ﺁ睍촯䏛\ud856帧퓼\uaada⍪맑㾋둊ਅ肑ᥩ鼀ᗢ\uea7d怦\ue6df粦\uf51d䯌솛䙺\udc21劓⬹ꄴ⟏뱔㈣裲ຩ蜛ᶱ鎼桇\ueedc撫ﵥ猣집丩",
                  47437575
               )
            )
            .attrs(
               pim.flat(EntityAttributes.field_23716, 4.0),
               pim.flat(EntityAttributes.field_23724, 2.0),
               pim.scaled(EntityAttributes.field_51576, 0.5),
               pim.scaled(EntityAttributes.field_51583, 0.5)
            ),
         pdr.of(Items.field_8575, 1, a.d("鐮\uedfa杘樂狻\uf05a丱쟢妷퍶哕", -1201787394, -1297433094))
            .off()
            .deep()
            .skin(
               a.b(
                  "렲솑䭚픣廚\ud861戻\uebb0疾Ｙ碌芠౸閙ᾫ饠⌥곎㙤뀝㧊䎖촎囗킂婊\ue3ce淍\uf746焞猪Ћ踸ែ醀᭐꓾⺨ꡀ㆕뮲앝伪좧割\udc09旘\uef41椄\uf2fe粏虢\u0ff9覟፭鴣⚵ꁫ⨡돷㵢䜓새䫮푞工\ue7bf慬\ueb09璵ﹿ砫臐୪锴Ỵ颁∾ꯨ㖱뽞㤬䊠찄嘙\udfd6奫\ue31c泀\uf68a瀅六΅赎ᛨ郉᩸ꐒⷲ뜕ㄾ뫕쒘乕ퟰ写\udb50擖\ueeb5桳\uf210箛蕤༟裄ኳ鰪◜꾃⥩닍㳌䙗쀬䦉퍽崟\ue6d7悎\uea31玄ﶨݚ胋ર鐶ḖꞭⅷ\uab1f㓹븘㠫䇱쮦啀\udec2墍\ue24e氖\uf582缁句˷豚ᘷ鿂ᦙꌨⳑ뚔〴먹쎊䵑휯僗\uda10搛\uedd6瞗\uf100竮蒧๏韐ᆃ魡┩껭⡹눥㯐䖹켦䣺튢屻\ue5cf澲\ue943獩ﳍٵ耂\u09cf鎚ᴡ꛰₩ꩻ㏩붫윸䄿쪢呯\ude31柝\ue18e欨\uf4dd纊\uf856ǎ讗ᕪ鼩ᢂꉛⰂ뗙㽨뤟싾䲪홛忨\ud9a0捗\ued65皉\uf076稊菲ോ霞ჽ骶␏귮㞵년㬳䒪칱䠀퇹孋\ue526滇\ue8af爢ﯓֈ輮ञ銥᱿ꘫ⿷ꥪ㌣볷욐䀇즅厺\udd7f曭\ue0af樼\uf423緞蝳č諙ᒊ鸬⟅ꆭ⭉듁㺉롑숍䮧핁弮\ud8d1抏\uec54痿ﾯ礤苌ಛ降ၤ駜⍡괒㛱뀘㨃䏮춏坸탯嫀\ue44c湢\uf7a0煺\ufb0cӦ蹱\u082e釓᮳ꕙ⻲ꢬ㈶밝에佴줹勅\udc6a昤\ueff4榖\uf32e糠蚱H訑Ꭿ鵞✎ꂠ⩨됊㷂䞳섴䪈풅幰\ue7e7憒\ueb6d甁ﻐ研舼\u0bd6閇Ἂ飱⊊걄㖝뾵㥠䌜쳚噽퀱姐\ue3e6洭\uf6e6炗喙϶趔ᝀ鄥᪤ꑮ⸢럢㆚뭔쓼件졞凵\udbb7敭\uef11梔\uf25e簥藗ཫ褖ዯ鲎♕꿤⦓덊㴑䚠쁙䨭평嵻\ue74c惒\uea8d琻\ufdd0ޓ腁ଐ钍Ṻ順⇾ꭇ㔚뻹㢲䈋쯲喉\udf58壏\ue2ae汵\uf604翳索̱賋ᚤ逍ᦌꎟ⵰뛉ス멀쐿䷘흏儴\udaed撰\uee50矉\uf1b0筽蓽ິ衇ሒ鮩╸꼯⣎늕㰤䗓쾥䥃틎岗\ue646思\ue9ac獛ﴭۋ聆ਟ鏾ᶎꜥ⃯ꪕ㑓빬쟝",
                  750434751
               )
            )
            .attrs(pim.flat(EntityAttributes.field_23721, 2.0), pim.flat(EntityAttributes.field_23716, 2.0)),
         pdr.of(Items.field_8575, 1, a.b("\uf417跃ݡ饥ዂ遣⸽ꞡ㦆댻㓬", -682954691))
            .off()
            .deep()
            .skin(
               a.d(
                  "薃ﰠ盫\ue892捫\ue5d0徊혁䠏슈䔽뼑㇉꠨√ꓑẔ酿\u0bd5趬ѻ縧\uf0bf武\ued33査\ude7f偼쫷䲯윕㦹뎋⩍갃⛧饏ጧ闥థ蘀\uf8c6犛\uf516濃\ue1b8塩티咵콏䄾믓㉈됮⻜ꂒᬄ鷚ថ蹆Ó窢ﵹ睟\ue9ef恔\uda0e峙횸䤔쏕䖈뱷㛥ꢨ⍕ꔧᾜ陎ࠓ苸ҍ缙\uf1b5殿\ue277擞\udea8內쬅䶝쐸㸠냯⭖괤⟋馰ၮ諹ಘ蝧奈玽\uea57氅\ue6c4奱팓嗂쾡䘪룕㊮땵⼂ꆛᡭ鈲ᓘ轼Ž篦ﶝ琸\ueecc悮\udb66崿힀丵쀙㫫뵺㜁ꦇ⎧騜᳆雍ो菜֞籼\uf62c棿\ue34e攎\udfeb冴젂䋭쒷㽆뇫⮆ꉳ\u2428麙ᅠ謥අ螈︻烠\uea9e浦\ue7a1妪큧䨦첱䝟뤖㏾ꩡⰲꛐᢘ鍜ᗈ辔١砈\uf297畋\uef13懊\ud87e刃퓲付셼㯄붳㑾긫ₐ魁ᴘ韊๘耚憎粎\uf713槞\ue380婬\udc3f嚙쥬䌻엧㱿똦⣛ꊘ┳鿪ᆳ表˙蒮ｏ焛\uebea扙\ue411廦탔䬸췇䞻빃ヺꪯⵌ꜇ᦾ遟\u0a04賵ڂ礛\uf3c0疱\uec48曺\ud897卶픞侓왢㠹늟㒯꼔⇎鮚ቆ铛ຒ腆ﬡ綶\uf434渋\ue0ce孜\udd1e垍즒䁯뫂㲼띨⤻ꎝᩴ鰜ᛸ襰̸藠ﾼ瘖\ue8f0抟\ue560弾퇥䡎숞䒕뽽ㄪ\uabfcⷕꑭỐ那ୀ趩\u07b2繟\uf03e櫉\ued5e朹\ud9ea厍쨐䳈용㥔돀㖡걽☞飨ፓ锠࿘膯\uf861狖\uf49b潠\ue1f2宙툈吰캏䅙뭈㷹랳⸑ꂱ᪼鵧៳覻q稸ﲉ睷\ue937掙\uda51屺훟䢍썢䗸뾛㙉꠹⊫ꕗἨ釽ࠩ與ӑ纩\uf120每\uedaa摦\ude0d傋쭩䴜쟌㹓뀋⫵곝✔駟Ꮉ訝ి蚀稜猞\uf5ef汹\ue60e壝튠唈쿅䆔롦㋚뒧⽞ꄿᯤ鉕ᐢ軻 笑\ufde8瞜\uee78惊\udafd嵣휼䦊쁡㨢볰㚡ꤼ⏋ꖷᱏ零ࢫ荈ԃ羺\uf643核\ue2e9敾\udf1f凄쮵䉂쓛㺀녺⬕궼\u243d鸮Ⴡ譸ഈ蟱年灩\ueafe沅\ue75c夁폡䩸찁䛌륌㌅뗶⾣ꘘᣉ銞ᕿ輤ƕ硢\uf214瓲\uef7f愦\udbf7嶬퐝仪삜㭺뷷㞮깏‿骔ᵞ霤ৢ菝𤋮",
                  -1955532823,
                  2109631463
               )
            )
            .attrs(pim.flat(EntityAttributes.field_23726, 1.0), pim.flat(EntityAttributes.field_23716, 2.0), pim.flat(EntityAttributes.field_47758, 1.0)),
         pdr.of(Items.field_8575, 1, a.c(234194207, "脲\uf8e6牄\uec40柧\ue546嬗틼䳙옚䇄뮸"))
            .off()
            .deep()
            .skin(
               a.d(
                  "塠⇃\uab08㕱뺈㠳艩\u0be2闬Ὣ飞拲\uec2a痋\ufff9礲썷䲜혶偏\ud998ꏄⵜ뚅バ먘Μ趟᜔酌\u1af6\ue45b湫\uf790燖\ufb07䒯컄䠆퇇寠┵꽸⣵눠㱛薊༓襖ኬ鳝昰\uefab槍\uf33f統웧䀹쩳厥\udd30ꝁₚꪼ㐌붷߭脽\u0b4e铤Ḁ顥憔\ueb06番ﺤ磓쉬䮦햮弌\ud953ꋾⱖ뙟㾺뤟͊貒ᛘ遦᧟\ue3d6洏\uf6b6炛憎䑐춖均텬媺ⓙ깙㞠뇈㬂蓎\u0ef0蠱ቂ鯉收\uef4d梖\uf2e1籸얎俑줻功\udc9eꘅ⁾\ua9db㌯뵍څ胜\u0a63鏖᷺\ue708悙\ueae2瑤﹄䟿섥䭚풪帕\ud847ꆮ⯶딌㺛룫Ȉ豗ᗽ鼎ᥒ\ue288氪\uf656羔梨䍘첃囩퀕婨⏑괨㝓낉㨈葌උ韫ᅋ骰擀\uee19矋\uf1d6笉앁井젫剸\udb95ꖳ⽜ꢴ㋕밢֣迫ऒ鍭\u1c8a\ue61d恥\ue9e6珢ﵞ䚵샾䨁펽巀✹ꅀ⫻됡㸪螏ǜ譟ᓖ黵᠘\ue1b9毎\uf53e罵\uf8f6䈉챖喡\udf39夝⊦곽㘆뾑㧨茓ൂ雛း騬掻\ued34睽\uf0b1竂쑝䶺ퟍ儕\udb31ꓲ⸉ꡒㆥ무կ躞ࣩ鉰᮫\ue5d1潻\ue966狙ﰐ䙿쾈䤴퍌岵⛄ꁑ⦇뎮㴭蚰ê詬ᑙ鶽李\ue116檋\uf4d8繛쟒䇹쬔咵\udec2堺≱ꮎ㔞뽄㢃芲ౚ閸ᾣ餉抚\uecf7瘲\uf05e秋쌋䵵횝偊\uda79ꏗⷅ뜪ゔ뫨Ё踳\u17de鄁ᭊ\ue4b8渶\ue86c熝ﯦ䔊캠䣾퉣屎◴꼲⤣늂㰻虦\u0fed视፼鲺曢\ue00c橾\uf3dc絔읈䂗쨦吒\udd87\ua7e6ⅶ꫞㓃븟\u07b6膞ଫ镓ẁ頚扬\ueb94痆！碠싶䰞햆忤\ud91cꍊⲈ똻だ릑Ϭ赿ᚴ郊ᩲ\ue3a7淸\uf715煦\ufaf7䑚칒垲퇊孰⒱껻⠏놴㯢蕠བྷ裨ሇ鱲斓\uef3c楢\uf2a0糜옭侀짭匘\udd43꛲ ꩔㎏봾݉肐\u0ae5鐊ᶆ\ue7c1愓\ueb41瓝︸硈솑䬚핤庵\ud8ceꈈ⮠뗐㼸뢱˼谧ᙖ龡ᤸ\ue363沒\uf6e5灴羚䏞촧嚛탿婢②궟㜣념㪿蓈\u0e74鞌ᇵ鬄撒\ueee1栭\uf268篯앛佳좖勭\udc76ꖁ\u2fd8꤃㊲볅ؔ聄এ錥ᵐ\ue68b怺\uea4d玬\ufddc䝷삽䫨퐓幁➋ꄮ⭲듿㹃",
                  1168596291,
                  -219085654
               )
            )
            .attrs(
               pim.flat(EntityAttributes.field_23724, 2.5),
               pim.flat(EntityAttributes.field_23725, 2.5),
               pim.scaled(EntityAttributes.field_23719, -0.15000007945819008)
            )
      );
   }
}
