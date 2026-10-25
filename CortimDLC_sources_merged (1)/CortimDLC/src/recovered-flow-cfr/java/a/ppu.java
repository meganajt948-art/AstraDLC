/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.component.DataComponentTypes
 *  net.minecraft.component.type.PotionContentsComponent
 *  net.minecraft.entity.effect.StatusEffectInstance
 *  net.minecraft.entity.effect.StatusEffects
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 */
package a;

import a.ppi;
import a.ppn;
import flow.dev.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public final class ppu {
    private static final List<ppn> ppv = new ArrayList<ppn>();
    public static final String[] WARDEN_DEFAULTS;
    public static final String[] END_DEFAULTS;
    private static /* synthetic */ boolean ppw;
    private static /* synthetic */ long ppx;

    private ppu() {
    }

    private static void ppy(String string, String string2, String string3, Item item, Predicate<ppi> predicate) {
        ppv.add(new ppn(string, string2, string3, item, null, predicate));
    }

    private static void ppz(String string, String string2, String string3, Item item, String string4, Predicate<ppi> predicate) {
        ppv.add(new ppn(string, string2, string3, item, string4, predicate));
    }

    private static void pqa(String string, String string2, String string3, String string4) {
        ppu.ppz(string, string2, string3, Items.field_8288, a.d("\uc0d0\u9f3f\u33b4\uadb8", -45210801, 1910498240) + string2, ppi2 -> ppi2.is(Items.field_8288) && ppi2.named(a.b("\uaca6\ud565\u5fbd\uc1cf\u4a61\uccad\u76f2\uff0e", 1504749804)) && ppi2.named(string4));
    }

    private static void pqb(String string, String string2, String string3, String string4) {
        ppu.ppz(string, string2, string3, Items.field_8575, a.d("\ud5b2\u8a5d\u26d6\ub8da", -945253084, 1679638729) + string2, ppi2 -> ppi2.is(Items.field_8575) && ppi2.named(a.c(-303489311, "\u1aa4\u6310\ue9b2\u77b6")) && ppi2.named(string4));
    }

    private static boolean pqc(ppi ppi2) {
        return ppi2.is(Items.field_8626) && (ppi2.named(a.c(551348825, "\uee6f\u97dc\u1d06\u830c")) || ppi2.lore().contains(a.c(-1636467348, "\u794e\u04ed\u8e2f\u105f\u9b98\u1949\ua36a\u2a9c\ub0d4\u3e04\ub9ae\u43dc\ucd7c\u54bc\udee7\u5816"))) && !ppi2.lore().contains(a.c(-747489610, "\u32ed\u4b22\uc1f0\u5ffe\ud456\u52e8\ue8bf\u6146\ufb04\u75a7\uf271\u0809\u86a0\u1f63\u9532\u13b1\ua9f0\u224d\ubce0\u3abe\ub339\uc911\u47ae\udc73\u5a04\ud0d8"));
    }

    private static boolean pqd(ppi ppi2) {
        return ppi2.is(Items.field_8626) && (ppi2.named(a.d("\u77c2\u0e79\u84dc\u1ada", -47719745, 847882568)) || ppi2.lore().contains(a.b("\u7824\u01eb\u8b39\u1537\u9e9f\u1821\ua276\u2b8f\ub1cd\u3f6e\ub8b8\u42c0\ucc69\u55aa\udffb\u5978\ue339\u6884\uf629\u7077\uf9f0\u83d8\u0d67\u96ba\u10cd\u9a11", -2080015233)));
    }

    private static boolean pqe(ItemStack itemStack) {
        PotionContentsComponent potionContentsComponent = (PotionContentsComponent)itemStack.method_58694(DataComponentTypes.field_49651);
        if (potionContentsComponent == null) {
            return false;
        }
        boolean bl = false;
        boolean bl2 = false;
        for (StatusEffectInstance statusEffectInstance : potionContentsComponent.method_57397()) {
            if (statusEffectInstance.method_5579() == StatusEffects.field_5909 && statusEffectInstance.method_5578() >= 5) {
                bl = true;
                continue;
            }
            if (statusEffectInstance.method_5579() != StatusEffects.field_5901) continue;
            bl2 = true;
        }
        return bl && bl2;
    }

    static String norm(String string) {
        return string == null ? "" : string.replaceAll(a.d("\uaf8c\ud6b4", -971103781, 1691913970), "").toLowerCase(Locale.ROOT).replace('\u0451', '\u0435');
    }

    public static List<ppn> entries() {
        return Collections.unmodifiableList(ppv);
    }

    public static ppn byId(String string) {
        for (ppn ppn2 : ppv) {
            if (!ppn2.id.equals(string)) continue;
            return ppn2;
        }
        return null;
    }

    public static boolean known(ItemStack itemStack) {
        if (itemStack == null || itemStack.method_7960()) {
            return false;
        }
        ppi ppi2 = new ppi(itemStack);
        for (ppn ppn2 : ppv) {
            if (!ppn2.test(ppi2)) continue;
            return true;
        }
        return false;
    }

    public static boolean picked(ItemStack itemStack, Collection<String> collection) {
        if (itemStack == null || itemStack.method_7960() || collection == null || collection.isEmpty()) {
            return false;
        }
        ppi ppi2 = new ppi(itemStack);
        for (ppn ppn2 : ppv) {
            if (!collection.contains(ppn2.id) || !ppn2.test(ppi2)) continue;
            return true;
        }
        return false;
    }

    static {
        ppu.ppy(a.b("\u5f88\u2630\uacf6\u328a\ub95b\u3ff9", 1992122347), a.b("\u2fe4\u5643\udc93\u4298\uc94d\u4ff7", 8072143), a.b("\u7aa3\u033b\u89fd\u1781\u9c50\u1af2", 1621129952), Items.field_8833, ppi2 -> ppi2.is(Items.field_8833));
        ppu.ppy(a.d("\ud526\uac9c\u265e\ub833\u33e9\ub54f\u0f07\u86eb\u18a5\u922e\u15c3\uefa1\u6169\uf8da\u7294", 1179686682, 2135245405), a.b("\u9cb7\ue52e\u6fff\uf18c\u7a2e\ufce7\u46ce\ucf43\u5110\udba3\u5c0f\ua211\u28d7\ub117\u3b3a\ubdc8\u07f5", -632710981), a.c(1554930742, "\u5c68\u25f2\uaf30\u315d\uba87\u3c21\u8669\u0f85\u91cb\u1b3f\u9cad\u66cf\ue807\u71b4\ufbfd\u7d0b"), Items.field_22028, ppi2 -> ppi2.is(Items.field_22027, Items.field_22028, Items.field_22029, Items.field_22030));
        ppu.ppy(a.d("\ud8c6\ua17c\u2ba2\ub5d8\u3e06\ub8b8\u02f1\u8b11\u154f\u9fc5\u1828\ue248\u6c9f\uf532\u7f68", -982452078, -1805901762), a.c(-1467032061, "\uda21\ua387\u2924\ub72f\u3cf2"), a.d("\u86ae\uff34\u75ea\ueb90\u604e\ue6f0\u5cb9\ud559\u4b07\uc1f2\u4666\ubc1f\u32cb\uab72\u2120\ua7da\u1ddb\u924b\u08e9\u8eb8\u0753\u7d0b", 825121515, -1441276906), Items.field_8367, ppi2 -> ppi2.is(Items.field_8367));
        ppu.ppy(a.c(493346155, "\udd00\ua4b9\u2e69\ub010\u3bc6\ubd7c\u071e\u8ed1\u109f\u9a2e\u1de1\ue799"), a.d("\u7900\u00ef\u8a4e\u143b", -1441007588, 1837270283), a.b("\ua19d\ud804\u52d4\uccad\u477b\uc1c1\u7bdc\uf26c\u6c22\ue693\u615c\u9b24", 370778582), Items.field_8463, ppi2 -> ppi2.is(Items.field_8463));
        ppu.ppz(a.c(-1205783175, "\u3506\u4ca8\uc660\u580c\ud3dd\u556d\uef0f\u66c0\uf88d\u723c\uf5fd\u0f9e\u8149\u18e2\u92b6"), a.b("\u09d1\u7042\ufa9f\u6499\uef37\u6d93\ud3f0\u5a50\uc40f\u4ecf\uc96d\u3365\ubdb7\u240b", 1725959624), a.b("\u6a89\u130a\u99d9\u07ba\u8c7f\u0ace\ub087\u3971\ua760\u2d81\uaa4d\u5027\udeed\u475a\ucd08", -1256953145), Items.field_8436, a.b("\u26f8\u7917\ud59c\u4b90\uc470\u42e3\uf8be\u7138\uef1e\u61ba\ue259\u1879\u96ae\u0f6e\u854c\u03c4\ub98e\u3652", 1828595377), ppi2 -> ppi2.potion() && ppi2.named(a.d("\u75e0\u0c20\u86f3\u18f3\u9355\u159d\uafcb", 1985594937, 1800189934)));
        ppu.ppz(a.b("\u0155\u78fb\uf233\u6c5f\ue78e\u613e\udb5c\u5282\ucccc\u4670\uc1ae\u3bda\ub500\u2cb6", 435224875), a.c(1619101214, "\u8206\ufb95\u7148\uef4e\u64e0\ue644\u5828\ud1f6\u4fa2\uc513\u42cb\ub8be\u3665\uafd1\u258f"), a.c(-1366289518, "\u13cc\u6a4c\ue092\u7eee\uf53c\u7380\uc9d4\u406b\ude64\u54ca\ud302\u296e\ua7bf\u3e0f"), Items.field_8436, a.d("\uf474\uab9b\u0710\u991c\u16fc\u906f\u2a32\ua3b4\u3d92\ub336\u30da\uca84\u4458\udde9\u57b1\ud144\u6b07\ue4d3\u7e6d", 123527339, -1655171945), ppi2 -> ppi2.potion() && ppi2.named(a.c(-993828030, "\u6774\u1ece\u9416\u0a63\u81b8\u070c")));
        ppu.ppz(a.c(-38489841, "\ub16d\uc8db\u420b\udc6f\u579e\ud107\u6b42\ue2a6\u7ce8\uf64e"), a.d("\u5c3e\u259c\uaf32\u314e\ubaeb\u3c25\u8219\u0ffa\u91a9\u1b12\u9cc5", -653846741, 951930687), a.c(-1117748023, "\u848b\ufd1d\u77cd\ue9a9\u6227\ue4c1\u5e84\ud760\u492e\uc388"), Items.field_8436, a.c(1261188329, "\u34bd\u6b52\uc7d9\u59d5\ud603\u50a1\uea8f\u6373\ufd5e\u7790\uf42c\u0a4f\u8494\u1d2f\u9778"), ppi2 -> ppi2.potion() && ppi2.named(a.b("\ub393\uca51\u40ff\ude83", 10270678), a.b("\u1d46\u64fb\uee22", 2127305079)));
        ppu.ppz(a.d("\u4235\u3b9b\ub153\u2f3f\ua4ee\u225e\u983c\u11e0\u8fac\u0518\u82c6\u78bf\uf67d\u6fd1\ue584\u6374", 1245408680, 1400319997), a.d("\u9c31\ue5a2\u6f7f\uf179\u7ad7\uf873\u4620\ucfc1\u519a\udb27\u5cfc\ua6fb\u2852\ub1e3", -522086188, -1452080900), a.c(1706467736, "\ua1da\ud858\u528e\uccf2\u472d\uc189\u7bc7\uf230\u6c6e\ue691\u6112\u9b7c\u15b0\u8c1c\u0649\u80b9"), Items.field_8436, a.c(-1338719422, "\uc30b\u9ce4\u306f\uae63\u2183\ua710\u1d4d\u94cb\u0aed\u8449\u079a\ufdfb\u7328\uea95\u60ce\ue649\u5c78\ud3a9"), ppi2 -> ppi2.potion() && ppi2.named(a.c(-293906100, "\u5d0a\u24cb\uae1c\u3061\ubbbe\u3d79")));
        ppu.ppy(a.b("\ua318\udaa4\u507f\uce02\u45d7\uc367\u793e", 1674945403), a.d("\u517d\u28e7\ua233\u3c4e\ub79e", 985145774, -1207536442), a.c(2001530860, "\uefaf\u9633\u1ce8\u8295\u0940\u8ff0\u35a9"), Items.field_8477, ppi2 -> ppi2.is(Items.field_8477));
        ppu.ppy(a.b("\u3ced\u4546\ucf90\u51fb\uda3f\u5c99", -80069480), a.c(-1975569187, "\u30fb\u495e\uc3f8\u5dfc\ud62f\u50ef\ueac2"), a.d("\ub3aa\uca21\u40f7\ude9c\u5558\ud3fe", -401249092, -181149885), Items.field_8675, ppi2 -> ppi2.is(Items.field_8675) || ppi2.named(a.c(2048451876, "\ue163\u98a6\u1200\u8c04\u07d7\u8117")));
        ppu.ppy(a.d("\uf42d\u8d97\u0755\u9938\u12e2\u9444\u2e0c\ua7e0\u39ae\ub325\u34da\ucebb\u407d\ud9df\u539d", -1801098853, 1785634263), a.c(-1856546800, "\u5c02\u259b\uaf4a\u3139\uba9b\u3c52\u867b\u0ff6\u91a5\u1b6d\u9ccc\u62a4\ue868\u71dc\ufb8d"), a.c(-1039906447, "\u4930\u30aa\uba68\u2405\uafdf\u2979\u9331\u1add\u8493\u0e67\u89e7\u7386\ufd40\u64e2\ueea0"), Items.field_22021, ppi2 -> ppi2.is(Items.field_22021) && !ppi2.says(a.c(-1745747946, "\u0451\u7de2\uf741\u693f\ue2ed")) && !ppi2.says(a.b("\u76c4\u0f7d\u85db\u1ba9\u9075\u16b4\uace3\u251e\ubb3e\u35e0\ub629\u4c59\uc280\u5b46\ud16d\u5796", 1498378985)));
        ppu.ppy(a.d("\u6ad8\u1362\u99a0\u07cd\u8c17\u0ab1\ub0f9\u3915\ua75b\u2dd0\uaa35\u5043\ude9d\u4724\ucd6c", 541523191, -287271346), a.c(2086506760, "\u9507\uec9e\u664f\uf83c\u739e\uf557\u4f7e\uc6f3\u58a0\ud268\u55c9\uaba1\u2117\ub8dc\u328c\ub407\u0e34\u81e1"), a.c(-1676022844, "\ueb85\u921f\u18dd\u86b0\u0d6a\u8bcc\u3184\ub868\u2626\uacd2\u2b48\ud13e\u5fe0\uc659\u4c11"), Items.field_22020, ppi2 -> ppi2.is(Items.field_22020));
        ppu.ppz(a.b("\u6ff1\u165c\u9c82\u02e1\u8931", 1170173828), a.c(-1120623904, "\ua6fa\udf6f\u55b7\ucbb7\u4063"), a.b("\u9298\ueb15\u61cb\uffa8\u7478", -2040098099), Items.field_8551, a.d("\ua1af\ufe40\u52cb\uccc7\u432f\uc5ba\u7fe2\uf662\u683e", 618015154, -1402042289), ppi2 -> ppi2.named(a.d("\uf3bc\u8a09\u00d1\u9ed1\u1505", 726831236, -714971390)) || ppi2.lore().contains(a.b("\u19be\u6007\ueaa1\u74d3\uff0f\u79ce\uc399\u4a64\ud444\u5a9a\ud928\u235a\uadfa\u3443\ube1d", -1005904500)));
        ppu.ppz(a.d("\ub7f5\uce42\u4482\udae2", 538464726, 639100499), a.d("\u4d67\u34b4\ube17\u2069\uabbb\u2d00", -1732131992, -45446613), a.d("\u9028\ue9bf\u637f\ufd1f", -1391792039, 296968225), Items.field_22021, a.d("\u959e\uca71\u66fa\uf8f6\u7723\uf1f0\u4bd3\uc22d\u5c77\ud6cc", 223401160, 2008105223), ppi2 -> ppi2.named(a.d("\ufa59\u83ea\u0949\u9737\u1ce5", 1371283130, -955719516)) || ppi2.lore().contains(a.d("\u46a0\u3f19\ub5bf\u2bcd\ua011\u26d0\u9c87\u157a\u8b5a\u0584\u864d\u7c3d\uf2e4\u6b22\ue109\u67f2", -1292669463, 1684352868)));
        ppu.ppz(a.b("\ufd4f\u84f3\u0e3a\u9057\u1b9d\u9d37\u2768\uae92\u30d7", 1104084258), a.b("\u29f7\u5067\udab6\u44ce\ucf67\u49ae\uf3f0\u7a09\ue429\u6eea\ue94f\u1340\u9de0", -1809633810), a.c(1409999717, "\ue32f\u9ab3\u107a\u8e17\u05dd\u8377\u3928\ub0d2\u2e97\ua433\u23f5\ud999\u5748\ucef8"), Items.field_8449, a.d("\u6a98\u3577\u99fc\u07f0\u8813\u0e83\ub4d2\u3d2a\ua30b\u29c2\uae1c\u5465\udacd\u430e\uc92b\u4fa4\uf59c", 1423153719, 1119613157), ppi2 -> ppi2.named(a.d("\u961f\uefaf\u657e\ufb06\u70af\uf666\u4c38\uc5c1\u5be1", 1310121864, 1058622890)) || ppi2.lore().contains(a.b("\u1b1a\u62ae\ue80c\u7604\ufdd7\u7b6a\uc13b\u48b5\ud285\u5c26\udbf9\u218d\uaf5c\u36e0", -747495645)));
        ppu.ppz(a.b("\u9ddd\ue47d\u6ea8\uf0de", -1126916675), a.c(435515271, "\u6ba2\u120e\u98d2\u06ae\u8d06\u0fd8\ub194\u3811\ua63e\u2cf8"), a.b("\uea63\u93fd\u1927\u8752\u0c96\u8a75\u3062\ub982\u27db\uad6d", 3729962), Items.field_8479, a.d("\uc5d3\u9a3c\u36b7\ua8bb\u2763\ua1cf\u1b93\u926f\u0c4f\u8291\u015d\ufb58\u75ff\uec39", 1022584, 851927038), ppi2 -> ppi2.named(a.c(-228622604, "\u7ab1\u037d\u89a1\u17dd\u9c75\u1eab\ua0e7\u2962\ub74d\u3d8b")) || ppi2.lore().contains(a.b("\u2d62\u54a0\ude74\u4072\ucbd9\u4d64\uf735\u7ebb\ue48b\u6a28\ued88\u1787\u9924\u0096\u8ab7\u0c4c", 469510451)));
        ppu.ppy(a.b("\u4a2c\u3396\ub954\u2739\uace3\u2a45\u900d\u19e1\u87af\u0d24\u8adb\u70ae\ufe61\u67cd\ued88", -1395963315), a.c(1631283885, "\u6ebf\u1726\u9df7\u0384\u8826\u0eef\ub4c6\u3d4b\ua318\u29d0\uae71\u5019\udad2\u436a\uc94b"), a.b("\u9886\ue11c\u6bde\uf5b3\u7e69\uf8cf\u4287\ucb6b\u5525\udfd1\u5851\ua224\u2ceb\ub547\u3f02", -184510265), Items.field_22022, ppi2 -> ppi2.is(Items.field_22022));
        ppu.ppy(a.d("\u1b72\u62db\ue806\u767e\ufda0\u7b00\uc148\u48b8\ud6d6\u5c4b\udb80\u21ef\uaf21\u3690", 711787658, 909975429), a.b("\u4cd5\u3576\ubfd0\u21d4\uaa09\u28a7\u9695\u1f1f\u814f\u0bf0\u8c2d\u762b\uf88e", 950683903), a.d("\u231e\u5a97\ud04a\u4e32\uc5ec\u434c\uf904\u70f4\ueee5\u6407\ue3cc\u19a3\u976d\u0edc", 2002283328, -263305213), Items.field_8398, ppi2 -> ppi2.is(Items.field_8398));
        ppu.ppy(a.d("\u41f2\u385d\ub293\u2cfe\ua724\u2182\u9bfc\u1221\u8c66\u06c9\u8103\u7b72", 961595070, -282228937), a.c(950326828, "\ud218\uabbb\u211d\ubf19\u34c4\ub66a\u082b\u81d0\u1f80\u9533\u1295\uec89\u6632\ufff8\u75a4\uf35b\u491a\uc6bc\u5c7d"), a.c(594610565, "\u09c7\u7048\ufa86\u64eb\uef31\u6997\ud396\u5a34\uc473\u4ecc\uc916\u336e\ubda8\u2402\uae50\u28ef\u92f3\u1d3a\u8797\u01df\u8828"), Items.field_8791, ppi2 -> ppi2.is(Items.field_8791));
        ppu.ppy(a.b("\ua360\udac7\u5007\uce70\u45af\uc31f\u797d\uf0bb\u6ee9\ue45c\u638a", 1792058127), a.b("\u69dc\u1040\u9a96\u04e2\u8f39\u098a\ub7c9\u3a2c\ua407\u2ec6\ua91f\u536a\uddbe\u4402", -1890751039), a.d("\u35a7\u4c20\uc6e0\u5897\ud348\u55f8\uefe5\u665c\uf80e\u72bb\uf56d", 1475361449, -266858687), Items.field_8712, ppi2 -> ppi2.is(Items.field_8712));
        ppu.ppy(a.b("\ub9bc\uc01c\u4ad8\ud4a9\u5f6b\ud9cf\u638b\uea57\u743f\ufe83\u7954\u8320", 376617427), a.c(257180978, "\u412f\u38b3\ub265\u2c11\ua7ca\u2179\u9f3a\u12d1\u8cf4\u063d\u81e9\u7b92\uf530\u6cf1"), a.d("\uda82\ua302\u29c6\ub7b7\u3c75\ubad1\u0095\u8936\u1721\u9d9d\u1a4a\ue03e", -1828484852, -1606331455), Items.field_8681, ppi2 -> ppi2.is(Items.field_8681));
        ppu.ppy(a.b("\u468c\u3f28\ub5f9\u2b87\ua05b\u26e6\u9c8f\u1549\u8b1b\u01ae\u8678", -715569411), a.c(1583419353, "\u0bc6\u725a\uf88c\u66f8\ued23\u6b90\ud5d3\u5835\uc663\u4cd0\ucb0e\u3176"), a.b("\ueae3\u9367\u19b6\u87c8\u0c14\u8aa9\u30bf\ub906\u2754\uade1\u2a37", -161158478), Items.field_8470, ppi2 -> ppi2.is(Items.field_8470));
        ppu.pqa(a.b("\uc311\ubab5\u306b\uae1f\u25d2\ua37d\u1922\u90dc\u0eb2\u8428\u03f6\uf98c\u7748\ueef6\u64bf", -1533623446), a.d("\ub402\ucda1\u4779\ud90b\u52a5\ud469\u6e36\ue7ca\u7d88\uf33b\u74f2\u8efb\\\u99e0\u13be", 1666285515, 1609748452), a.b("\u1434\u6da8\ue770\u7912\uf2ca\u7461\uce66\u47c3\ud989\u5335\ud4e3\u2e88\ua041\u39fc\ub3a0", -944368529), a.c(575781703, "\ubf00\uc6cb\u4c60\ud261\u59bb"));
        ppu.pqa(a.d("\u1568\u6ccc\ue612\u7866\uf3ab\u7504\ucf5b\u46a5\ud8cb\u5241\ud59f\u2ff4\ua133\u388e\ub2c0\u3427", 375966693, 150134505), a.c(225563974, "\ud174\ua8d7\u220f\ubc7d\u37d3\ub11f\u0b40\u82bc\u18fe\u964f\u118c\uebfa\u652e\ufc95\u76b8\uf039"), a.c(490772696, "\u988c\ue110\u6bd9\uf5b8\u7e63\uf8cf\u428a\ucb3f\u5534\udf90\u584e\ua23a\u2cf7\ub558\u3f07\ub9f9"), a.b("\u1ea8\u6769\uedbd\u73cf\uf812\u7edd", -886105362));
        ppu.pqa(a.b("\u999f\ue03b\u6ae5\uf491\u7f5c\uf9f3\u43ac\uca52\u543c\udeb5\u596d\ua31f\u2dc8\ub47b", 2044762597), a.d("\u3862\u41c1\ucb19\u556b\udec5\u5809\ue256\u6baa\uf1e8\u7f65\uf8ea\u02eb\u8c36\u158d", -253363394, 1813694320), a.c(-1484232133, "\u6a72\u13e8\u9938\u0749\u8c9c\u0a60\ub067\u3983\ua7d1\u2d65\uaaac\u50c3\ude18\u47a6"), a.c(-2082699703, "\u8271\ufbbc\u711f\uef64"));
        ppu.pqa(a.b("\u7f1f\u06bb\u8c65\u1211\u99dc\u1f73\ua52c\u2cd2\ub2bc\u3825\ubfe9\u4599\ucb55\u52fa", -1517584539), a.b("\u08a3\u7100\ufbd8\u65aa\uee04\u68c8\ud297\u5b6b\uc129\u4faa\uc853\u325f\ubc8d\u2533", 207490191), a.c(-1650061035, "\u114c\u68c2\ue210\u7c7a\uf7b3\u714e\ucb49\u42ad\udcff\u564b\ud182\u2bed\ua536\u3c88"), a.c(781903205, "\ue153\u98e8\u1246\u8c32"));
        ppu.pqa(a.b("\ud2e0\uab44\u219a\ubfee\u3423\ub28c\u08d3\u812d\u1f43\u95c9\u121b\ue862\u66b7\uff07", 2014827162), a.d("\u1cd6\u6575\uefad\u71df\ufa71\u7cbd\uc6e2\u4f1e\ud55c\u5bd9\udc2b\u2653\ua886\u3134\ubb6a", -1969584396, -1259954673), a.b("\ud1af\ua83f\u22e4\ubc97\u3741\ub1be\u0bb9\u825d\u1c0f\u96bb\u1172\ueb1d\u65c6\ufc78", 1642123749), a.d("\ude96\ua726\u2dfc\ub38f\u385b", -324348246, -2045965299));
        ppu.pqb(a.d("\u8cee\uf55c\u7f97\ue1eb\u6a2b\uec8d\u56e4\udf28\u4170\ucbc5\u4c04\ub672", -2038242190, 1179609315), a.d("\u3ece\u471a\ucdb8\u53bc\ud81b\u5aba\ue4d8\u6d0d\uf326\u7994\ufe3d\u044c", -974556827, 1299336070), a.b("\ua756\udec0\u5417\uca74\u41a4\uc741\u7d41\uf4b3\u6af4\ue048\u678c\u9dea", 1689167640), a.c(-697467885, "\u7827\u0192\u8b35\u1547\u9eea"));
        ppu.pqb(a.d("\u1d81\u6433\ueef8\u7084\ufb44\u7de2\uc78b\u4e4c\ud019\u5aaa\udd6a\u271c\ua9cd", 302369294, -465315855), a.c(1911423427, "\u05e9\u7c3d\uf69f\u689b\ue33c\u619d\udff6\u5625\uc870\u42b1\uc512"), a.c(-506034797, "\u85d7\ufc4c\u769d\ue8ff\u632f\ue598\u5f98\ud63a\u4866\uc2cf\u4511\ubf77\u31b7"), a.b("\u5666\u2fd5\ua50c\u3b0d", -1762241958));
        ppu.pqb(a.c(-1142328475, "\u731a\u0aa8\u8063\u1e1f\u95df\u1379\ua910\u20cd\ube80\u3424\ub3fa\u4980"), a.c(2047740562, "\u0ebf\u776b\ufdc9\u63cd\ue86a\u6acb\ud499\u5d79\uc354\u499f\uce34\u3435"), a.c(-1716747717, "\u8264\ufbe7\u7121\uef5d\u6481\ue262\u5862\ud190\u4fd7\uc56b\u42af\ub8c9"), a.c(400786432, "\u8044\uf984\u7325\ued2e\u6681"));
        ppu.pqb(a.c(-235941052, "\ud33c\uaa8e\u2045\ube39\u35f9\ub35f\u0936\u80f9\u1eb5\u9413\u13d6"), a.d("\uccae\ub57a\u3fd8\ua1dc\u2a7b\ua8da\u16b9\u9f18\u0132\u8bf7\u0c55", -336948477, 142826375), a.b("\u36de\u4f5c\uc598\u5bff\ud07b\u5699\uecc9\u6520\ufb72\u71d4\uf610", -1960823148), a.b("\ubd7f\uc4be\u4e18\ud01d", 1200863563));
        ppu.pqb(a.b("\uc90f\ub0bd\u3a76\ua40a\u2fca\ua96c\u1305\u9ac8\u049c\u8e24\u09f9\uf394", -1306998416), a.c(2050139772, "\ua256\udb82\u5120\ucf24\u4483\uc622\u7874\uf190\u6fc1\ue50f\u62ad"), a.d("\u428d\u3b17\ub1cd\u2fb2\ua479\u229b\u989b\u1169\u8f2e\u0592\u8256\u7830", 1567420290, 1948560704), a.c(323029787, "\u0f5a\u769e\ufc43\u624d"));
        ppu.pqb(a.c(-1284985063, "\uaf66\ud6d4\u5c1f\uc263\u49a3\ucf05\u756c\ufcaa\u62e4\ue848\u6f8d\u95ef"), a.d("\u7938\u00ec\u8a4e\u144a\u9fed\u1d4c\ua32c\u2af6\ub4a5\u3e60\ub9b8", -333958042, 537545076), a.c(-1114907422, "\udca6\ua526\u2fe8\ub18f\u3a4b\ubcbb\u06bb\u8f49\u110e\u9bb2\u1c76\ue610"), a.b("\u3049\u49f3\uc32c\u5d29", 1415066750));
        ppu.ppz(a.b("\ubb7c\uc2c7\u4812\ud659\u5db0\udb12\u6141\ue8ad\u76ea", -666518756), a.c(-1717581917, "\uc390\uba42\u3093\uae97\u254e\ua3f4\u1db7\u9058\u0e08\u84b3\u036e\uf91e\u77c8\uee71\u642a\ue2d3\u5899\ud73f"), a.d("\ub513\ucc88\u465d\ud869\u53ff\ud55d\u6f0e\ue6e2\u78a5", -502354647, 1982732410), Items.field_8087, a.b("\ua7c0\ude12\u54c3\ucac7\u411e\uc7a4\u79e7\uf408\u6a58\ue0e3\u673e\u9d4e\u1398\u8a21z\u8683\u3cc9\ub36f", -87251981), ppi2 -> ppi2.is(Items.field_8087, Items.field_8107, Items.field_8236) && (ppi2.named(a.b("\u27fe\u5e40\ud499\u4ae6\uc130\u4780\ufddb", 483009479)) || ppu.pqe(ppi2.stack)));
        ppu.ppy(a.d("\u7a73\u03ca\u891a\u1763\u9cb5\u1a0f\ua06d\u29a0\ub7fd\u3d5f\uba8c\u40e0\uce2c", 1241889509, 581746940), a.c(-528931311, "\u2209\u5b91\ud147\u4f33\uc498\u425b\uf877\u75e9\uefaa\u6519\ue2b4\u18bf\u966c\u0fd1\u85fc"), a.c(28539829, "\u7bff\u0266\u88b6\u16cf\u9d19\u1ba3\ua1be\u280c\ub651\u3cf3\ubb20\u414c\ucf80"), Items.field_8071, ppi2 -> ppi2.is(Items.field_8071));
        ppu.ppz(a.c(788737602, "\u2e2d\u5794\udd4c\u4306\uc8ef\u4e4a\uf41e\u7dfc"), a.c(1620625019, "\uc260\ubbfe\u3125\uaf2e\u24fa\ua624\u1867\u91e5\u0fb9\u8578"), a.c(-600921045, "\uac66\ud5ff\u5f27\uc115\u4a96\ucc74\u7666\uff83\u61db\ueb79"), Items.field_8614, a.d("\u879e\ud871\u74fa\ueaf6\u6510\ue38e\u59d5\ud05e\u4e02\uc0dc\u431f\ub91d\u37c9\uae08", 1201463737, 1944413810), ppi2 -> ppi2.named(a.b("\uee39\u9787\u1d5c\u8357\u0883\u8a5d\u341e\ubd9c\u23c0\ua901", 801040898)) || ppi2.lore().contains(a.c(-401036654, "\uaeb2\ud70c\u5dd7\uc3a5\u4806\uceb4\u7497\ufd61\u6336\ue987\u6e59\u9457\u1eef\u834e\u096e\u8f9c\u35a3")));
        ppu.ppy(a.d("\u08c3\u717a\ufb86\u65ca\uee10\u68ba\ud2e9\u5b00\uc556", -331341151, 433662483), a.d("\u3f0a\u469a\ucc3d\u5245\uddf0\u5b49\ue500\u6c82\uf2a9\u7c0d\uffc1\u05cc\u8b6f\u12a2\u98fa\u1e73\ua02d", -158234232, -423054707), a.b("\u117e\u68c7\ue264\u7c1d\uf783\u713f\ucb6c\u42d1\udccc\u5670\ud1b8\u2bc9\ua506\u3cbe\ub6fb\u3050", 1904021814), Items.field_8287, ppi2 -> ppi2.is(Items.field_8287) || ppi2.named(a.d("\u28e8\u5125\udb82\u458f\uce53", -64566524, -1095505962), a.b("\ue8de\u916e\u1bc9\u85b1", 1190259940)));
        ppu.ppz(a.d("\uc23c\ubb8f\u3157\uaf1d\u24f3\ua24d\u180f", 1526512223, 578320393), a.d("\u36d9\u4f4a\uc593\u5bee\ud045\u5688\uecd9\u6522\ufb0f\u71c2\uf66f\u087e\u82b6\u1b06\u912c\u17a2\uade8\u223e\ub88f", -266329091, -417328853), a.b("\uf920\u80a6\u0a60\u9400\u1fdf\u9975\u2374\uaac8\u3495\ube2f\u39f1\uc38f\u4d57\ud4ea\u5eae", -1977222787), Items.field_27063, a.c(830177205, "\u7ff9\u20b2\u8c9d\u1291\u9d7a\u1be9\ua1b0\u284d\ub66e\u3ca3\ubb72\u4109\ucfac\u5661\udc4c\u5edd\ue08d\u6f5d\uf597\u73b9\ufa4b\u801d\u0eac"), ppi2 -> ppi2.named(a.b("\u63c5\u1a76\u90af\u0ed2\u8579", -318347268), a.c(-1471142272, "\u22b9\u5b09\ud1a3\u4fad\uc47f\u42c9")) || ppi2.lore().contains(a.d("\uc543\ubcbb\u3667\ua807", -2043381265, 1998896263)));
        ppu.ppy(a.c(752452763, "\u84ff\ufd4c\u7794\ue9de\u6237\ue489\u5ec2\ud72c\u4976"), a.b("\u972c\ueebf\u6466\ufa1b\u71b0\uf77d\u4d2c\uc4d7\u5afa\ud037\u579a\ua98b\u2341\ubafd\u30a4\ub651\u0c12\u83c1\u1979\u9f5f\u16d9\u6c8d", -1486449882), a.d("\uc49e\ubd00\u37cb\ua9a5\u2277\ua48a\u1e94\u9767\u0933\u838f\u0453\ufe2d\u70f6\ue950", -15122157, -919697982), Items.field_8782, ppi2 -> ppi2.named(a.c(-177161691, "\ube1c\uc7af\u4d76\ud30b\u58a0"), a.c(864407516, "\ucbe8\ub254\u388d\ua6f8\u2d23\uab90\u11c8\u984e\u0660")) || ppi2.lore().contains(a.c(258996763, "\ufa32\u83cd\u0911\u9778\u1cb0\u9a04")));
        ppu.ppz(a.d("\ue00c\u99bf\u1367\u8d2d\u06c3\u8078\u3a3e", 670561634, -1379920636), a.b("\ud365\uaaf6\u202f\ube52\u35f9\ub334\u0965\u809e\u1eb3\u947e\u13d3\uedc2\u670a\ufeba\u74ec\uf277\u482b\uc788", 1080219499), a.c(-1926107569, "\uee06\u979d\u1d4b\u8334\u08ec\u8e41\u3446\ubdfa\u23a7\ua91d\u2ec3\ud4bd\u5a65\uc3d8\u499c"), Items.field_8153, a.d("\u9e76\uc13d\u6d12\uf31e\u7cf5\ufa66\u403f\uc9c2\u57e1\udd2c\u5afd\ua086\u2e23\ub7ee\u3dc3\ubf52\u0102\u8ed2\u1464\u925f\u1bbb\u6198", -1022346221, -1282235864), ppi2 -> ppi2.named(a.b("\u723f\u0b8c\u8155\u1f28\u9483", -397642234), a.b("\u5e75\u27c5\uad13\u336c\ub8cc", 387471951)) || ppi2.lore().contains(a.c(-370318277, "\u6410\u1de8\u9731\u0955")));
        ppu.ppy(a.b("\uab54\ud2e2\u5835\uc646\u4d9d\ucb2d", -1246909648), a.c(1413715739, "\u9303\uea9e\u6032\ufe36"), a.c(475317492, "\uc4b0\ubd26\u37f1\ua982\u2259\ua4e9"), Items.field_8668, ppi2 -> ppi2.is(Items.field_8668));
        ppu.ppz(a.b("\u76a4\u0f1d\u85d5\u1bb2\u9073\u16df\uac93", -1470138686), a.c(1717550364, "\ub90b\uc092\u4a39\ud43c\u5f9f\ud950\u6302"), a.c(1213492644, "\u6de2\u147b\u9eb3\u00d4\u8b15\u0db9\ub7f5"), Items.field_8530, a.b("\u3e8b\u6164\ucdef\u53e3\udc04\u5a9d\ue0b6\u6933\uf718\u7dd7\ufa05", -487244069), ppi2 -> ppi2.says(a.d("\u067e\u7fc7\uf56c\u6b69\ue0ca\u6605\udc57", 515868926, -46495049)) || ppi2.says(a.b("\u7e20\u0799\u8d51\u1336\u98f7\u1e5b\ua417", 429293126)));
        ppu.ppy(a.b("\u3205\u4baf\uc176\u5f06\ud4d5\u5261\ue809\u61c6\uff94\u753d\uf2fb\u0899", -890883460), a.b("\u091c\u7086\ufa2c\u642f\uef88\u6935\ud70a\u5ae6\uc4b1\u4e03\uc9de\u33d5\ubd78", -1270739711), a.b("\u505d\u29d7\ua30e\u3d7e\ub6ad\u3019\u8a0e\u03be\u9dec\u1745\u9083\u6ae1", -46379004), Items.field_23141, ppi2 -> ppi2.named(a.b("\ucf51\ub6eb\u3c41\ua242\u29e5", 371575652)));
        ppu.ppz(a.d("\ud6ef\uaf41\u2593\ubbff\u3039\ub6b2\u0cca\u8521\u1b64", 728374698, 17746747), a.b("\u5198\u280b\ua2d1\u3cdb", 1076254094), a.c(161929615, "\ud9d1\ua05f\u2a8d\ub4e1\u3f27\ub9d3\u03f4\u8a1f\u145a"), Items.field_8626, a.b("\ue16c\ube83\u1208\u8c04\u03e1\u8572\u3f28\ub6a2", -2079465153), ppu::pqc);
        ppu.ppz(a.c(511588213, "\u371e\u4ea1\uc47f\u5a0c\ud1d3\u5756\ued2e\u64c5\ufa80"), a.d("\uc7d3\ube48\u34ed\uaaeb", 1907055573, 1403361299), a.d("\ue194\u980b\u12d5\u8ca6\u0779\u8183\u3ba4\ub24f\u2c0a", -766324956, -1867567365), Items.field_8626, a.d("\u660d\u39e2\u9569\u0b65\u8483\u0218\ub83d\u31bb", 1187915557, 757285243), ppu::pqd);
        ppu.ppy(a.d("\uf3fb\u8a50\u0099", 433585094, -543225782), a.b("\ubd20\uc4ae\u4e42", 1654700289), a.d("\u49cc\u3067\ubaae", -2040388159, 2130472026), Items.field_8626, ppi2 -> ppi2.is(Items.field_8626) && !ppu.pqc(ppi2) && !ppu.pqd(ppi2));
        ppu.ppy(a.b("\u7b92\u022b\u88f0\u1696\u9d52\u1bee\ua1b5\u287f\ub610\u3cbc\ubb78", -507806724), a.b("\uff48\u86d6\u0c71\u927f\u19d4\u9f66\u2542\uacba\u32e8\ub826\u3b9a\uc58b\u4b5f\ud299\u58ce", 305920863), a.d("\u68a4\u113d\u9be6\u0580\u8e44\u08f8\ub2a3\u3b16\ua506\u2faa\ua86e", 80330609, -229779557), Items.field_8837, ppi2 -> ppi2.is(Items.field_8837, Items.field_29216));
        ppu.ppy(a.b("\u8638\uff81\u7551\ueb28\u60c4\ue643\u5c17\ud5ef\u4bb8\uc112", 28804693), a.b("\u6aa3\u133b\u99ed\u0799\u8c32\u0a8a\ub0a7\u3d43\ua77d\u2db6\uaa66\u506d\udec2\u4771", -1885835590), a.b("\u7353\u0aca\u801a\u1e63\u95f0\u1308\ua95c\u20a4\ubef3\u3459\ub38d", 1948218143), Items.field_8695, ppi2 -> ppi2.is(Items.field_8695));
        ppu.ppz(a.b("\u524c\u2bfe\ua121\u3f58\ub494\u323c\u8865\u019c", 1919111720), a.b("\u24ac\u5d41\ud7ec\u49ea\uc231\u44fd\ufeac\u7345\ued12\u63b9\ue419\u1e1c\u94d7", 1502093503), a.d("\u8c6c\uf5fe\u7f21\ue158\u6a94\uec3c\u5665\udf9c\u41db\ucb39\u4ce2\ub6da\u3800\ua1b1\u2ba7", 755428469, 1054367834), Items.field_8366, a.b("\u672e\u38c1\u944a\u0a46\u85af\u0342\ub96f\u30e9\uaeba\u2476\ua3af\u5dce\ud703\u4aa8\uc4fa\u426e\uf850\u77f4\ued37\u6b6a", 568747873), ppi2 -> ppi2.named(a.c(1071882697, "\ua5f1\udc3c\u5691\uc897\u434c\uc580")));
        ppu.ppy(a.d("\u8ff0\uf654\u7c85\ue2fb\u6927\uef9a\u55f3\udc2b\u426b\uc8df\u4f0c\ub570\u3ba1\ua212\u2856\uae8a\u14ff\u9b2c\u019f", -481212018, -1144207849), a.c(706705522, "\u7c43\u05e4\u8f48\u1141\u9e88\u1c26\ua60a\u2f83\ub1d3\u3b1e\ubcb4\u46c7\ucc00\u51a6\udbfc\u5d0f\ue74d\u6895\uf633\u7475\ufdf8\u87dc\u091b\u92c9\u14b8\u9e6a\u27ab\ua9ff\u330d\ub551"), a.d("\ub048\uc9cc\u431d\udd63\u56bf\ud002\u6a14\ue3b3\u7df3\uf747\u7094\u8ae8\u0439\u9d8a\u17ce\u916d\u2b71\ua4a3\u3e01\ub846\u31a8\u4bb7\uc541\u5e92\ud8ed", -1488811659, 1166227838), Items.field_8136, ppi2 -> ppi2.is(Items.field_8136));
        ppu.ppy(a.c(1406428896, "\u669a\u1f34\u95e2\u0b93\u8049\u06fe\ubcaf\u3549\uab3b\u21b0\ua661\u5c10"), a.c(-1263965053, "\u68b4\u1113\u9bbf\u05b6\u8a7f\u08d1\ub2fd\u3b74\ua524\u2fe9\ua843\u5230\ud8f7\u455c\ucf75\u49f1\uf3ca\u7c18\ue6a5\u60f7\ue972\u9326\u1d90\u864c"), a.d("\u4423\u3dad\ub77b\u290a\ua2d0\u2467\u9e36\u17d0\u89dd\u033f\u84ef\u7e8f\uf04e\u69e6\ue3fb\u654f\udf02\u50d3", -389978299, 0x25332322), Items.field_8086, ppi2 -> ppi2.is(Items.field_8086));
        ppu.ppy(a.b("\ue074\u99ce\u130c\u8d61\u06bb\u801d\u3a63\ub3be\u2de6\ua742\u2082", -1796284399), a.d("\u3150\u48c4\uc210\u5c63\ud7b7\u5102\uef41\u628d\ufcfa\u7649\uf198\u0b9c\u853b", -1818981322, 2138093948), a.d("\uee32\u97a8\u1d6a\u8307\u08dd\u8e7b\u347a\ubdd8\u2380\ua924\u2ee4", 213035091, -2069936604), Items.field_8137, ppi2 -> ppi2.is(Items.field_8137));
        ppu.ppz(a.c(1657008156, "\uf073\u89d4\u0314\u9d63\u16bc\u900c\u2a6e\ua3b3\u3df4\ub747\u3093"), a.c(-1972314615, "\uda10\ua3f5\u2956\ub72d\u3cfe\uba4c\u001a\u89ea\u13ac\u9d7c\u1ad4\ue0a7\u6e75"), a.c(1838766282, "\u5885\u2102\uabc2\u35b5\ube6a\u38da\u82c7\u0b65\u9522\u1f91\u9845"), Items.field_8407, a.c(1738150982, "\u140c\u4be3\ue768\u7964\uf687\u7062\uca41\u43ba\udde1\u5753\ud085\u2af5\ua03b\u3deb\ub7c3\u3130\u8b7a"), ppi2 -> ppi2.says(a.d("\u849f\ufd5a\u77f9\ue982\u6251\ue4e3\u5eb5\ud745\u4d03\uc3d3\u447b\ube08\u30da", -770411799, -487198129)));
        ppu.ppz(a.d("\ud4f4\uad42\u279a\ub9f8\u3230\ub49c\u0eda\u8728\u1979\u93c1\u1428\uee75\u60ba\uf909\u735d", -1694811504, 349367810), a.d("\u0298\u7b01\uf1df\u6fa1\ue470\u62c5\ud895\u516f\ucf46\u4585\uc64f\u385f\ub6f3\u2f40\ua516", 2008182811, 1051096721), a.d("\u3b09\u429f\uc847\u5625\udded\u5b41\ue107\u68f5\uf6a4\u7c1c\ufb8a\u01a8\u8f67\u16d4\u9c80", 130342645, -543627846), Items.field_8407, a.d("\u4032\u1fdd\ub356\u2d5a\ua2b0\u2429\u9e77\u1789\u89d0\u0365\u84b5\u7ecf\uf06e\u69ad\ue7e7\u6577\udf43\u5090\uca26", -2022593794, 885713540), ppi2 -> ppi2.says(a.c(210283351, "\uaf65\ud6dc\u5c02\uc27c\u49ad\ucf18\u7548\ufcb2\u629b\ue858\u6b92\u9582\u1b2e\u829d\u08cb")));
        ppu.ppy(a.b("\u9c51\ue5f2\u6f3a\uf155\u7a9d\ufc34\u4674\ucf84\u51cc", 954113087), a.b("\u221c\u5b8c\ud121\u4f2e\uc482", 1477649926), a.c(-571710519, "\u6387\u1a04\u90cc\u0ea3\u856b\u03c2\ub982\u3072\uae3a"), Items.field_8054, ppi2 -> ppi2.is(Items.field_8054));
        ppu.ppy(a.b("\u5812\u21b4\uab6b\u351d\ubec2\u387a\u8234\u0bd4\u958d\u1f3d\u98d5\u629f\uec49\u75f8\uffbe\u794c\uc31c\u4cc0\ud666\u5026", 420829300), a.b("\u6f75\u16dd\u9c74\u0270\u89ad\u0f18\ub521\u3cbc\ua2e3\u2824\uaf85\u51ed\udb29\u4290\uc8bb\u4e38\uf47e\u7baa\ue119\u673e\ueebb\u90f3\u1a21\u818a\u07fe\u8d22\u3499\ubabb", -1404802230), a.c(1705574857, "\u018f\u7809\uf2d6\u6ca0\ue77f\u61c7\udb89\u5269\ucc30\u4680\uc117\u3b22\ub5f4\u2c45\ua603\u20f1\u9aa1\u157d\u8fdb\u099b"), Items.field_38418, ppi2 -> ppi2.is(Items.field_38418));
        ppu.ppy(a.b("\u9772\ueec0\u6404\ufa6a\u71b5\uf70f\u4d46\uc4a6\u5af8\ud072\u579b\uadf6\u233d", 226400025), a.d("\uaeae\ud733\u5d90\uc399\u484b\ucef9\u74a6\ufd55\u6307\ue9b6\u6e13\u9410\u1ede\u8370\u092c\u8fae\u35e5\uba4b\u20f9\ua2b1\u2f55\u550c\udbb4\u4062", 78109679, 1977643333), a.b("\u2b8c\u521e\ud8da\u46b4\ucd6b\u4bd1\uf198\u7878\ue626\u6cd3\ueb53\u1121\u9fef\u0653\u8c01\u0ae7\ub0fa\u3f6e\ua5c1\u238c", 1132800990), Items.field_8711, ppi2 -> ppi2.is(Items.field_8711));
        ppu.pqa(a.c(-1308272221, "\u59da\u207e\uaaa0\u34d4\ubf19\u39b6\u83e9\u0a17\u9479\u1ef1\u9931\u6347\ued9b"), a.c(1122483047, "\ubf4a\uc6e9\u4c31\ud243\u59ed\udf21\u657e\uec82\u76c0\uf87e\u7fc2\u85cd\u0b65\u92d7\u18fe"), a.d("\u45a2\u3c20\ub6f4\u288e\ua300\u25e5\u9fa3\u165f\u8805\u02ae\u8563\u7f1e\uf1c6", -709624419, 1210038388), a.b("\u5f1c\u26a2\uac0f\u3201\ub9d5", 1336302422));
        ppu.ppy(a.c(189845985, "\ud185\ua838\u22e9\ubc9e\u3773\ub1f5\u0bab\u825e\u1c04"), a.c(-14872251, "\u1557\u6ccb\ue61a\u786c\uf3ce\u7577\ucf54\u46a8\udce2\u5242\ud5e3\u2fea\ua136\u3885\ub2af"), a.b("\u6d80\u141d\u9ecc\u00bb\u8b29\u0dd0\ub78e\u3e7b\ua021", -1637585468), Items.field_49813, ppi2 -> ppi2.is(Items.field_49813) || ppi2.named(a.c(-1450786264, "\uc61d\ubfa1\u3570\uab06\u20a4\ua61d\u1c3e\u95c2")));
        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayList<String> arrayList2 = new ArrayList<String>();
        for (ppn ppn2 : ppv) {
            if (!ppn2.id.equals(a.b("\u76b2\u0f16\u85c8\u1bbc\u9071\u16de\uac81\u257f\ubb11\u3199\ub659\u4c2f\uc2f3", -943360309)) && !ppn2.id.equals(a.c(564215680, "\u3fe4\u4659\ucc88\u52ff\ud912\u5f94\ue5ca\u6c3f\uf265"))) {
                arrayList.add(ppn2.id);
            }
            arrayList2.add(ppn2.id);
        }
        WARDEN_DEFAULTS = arrayList.toArray(new String[0]);
        END_DEFAULTS = arrayList2.toArray(new String[0]);
    }

    private static /* synthetic */ int bmk(int n, int n2) {
        return n ^ n2 ^ 0x4314B8CE;
    }

    private static /* synthetic */ int bml(int n, int n2) {
        return ppu.bmk(n, n2) * n2;
    }
}

