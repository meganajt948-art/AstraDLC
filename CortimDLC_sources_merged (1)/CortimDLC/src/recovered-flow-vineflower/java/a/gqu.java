package a;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import flow.dev.a;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.net.http.WebSocket.Listener;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.util.HexFormat;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

final class gqu implements Listener {
   final String name;
   final List<String> raw = new CopyOnWriteArrayList<>();
   final List<String> plain = new CopyOnWriteArrayList<>();
   final Map<String, String> pubs = new ConcurrentHashMap<>();
   final Map<Integer, byte[]> keys = new ConcurrentHashMap<>();
   final KeyPair pair;
   final String pub;
   volatile String code;
   volatile String world;
   volatile String party;
   volatile int epoch;
   volatile JsonObject pendingInvite;
   volatile int keyBoxes;
   volatile int lastMarkAt;
   volatile WebSocket ws;
   final StringBuilder gqv = new StringBuilder();

   gqu(String var1) {
      this.name = var1;

      try {
         this.pair = ufw.generate();
      } catch (Exception var4) {
         throw new IllegalStateException(var4);
      }

      this.pub = ufw.b64(this.pair.getPublic().getEncoded());
      this.keys.put(1, ufw.randomKey());
      this.epoch = 1;
      byte[] var2 = new byte[16];
      new Random().nextBytes(var2);
      URI var3 = URI.create(
         grd.gre + a.b("铬\ued05柒璘牱\uf48b仗윲夠펟呐깥", 2108069071) + HexFormat.of().formatHex(var2) + a.d("盋༬藺ᮜ途", -1539968583, -30963887) + this.pub
      );
      HttpClient.newHttpClient().newWebSocketBuilder().buildAsync(var3, this).thenAccept(var1x -> this.ws = var1x);
   }

   synchronized void send(String var1) {
      WebSocket var2 = this.ws;
      if (var2 != null) {
         var2.sendText(var1, true).join();
      }
   }

   void sendStatus() {
      JsonObject var1 = new JsonObject();
      var1.addProperty(a.c(1038243039, "咰"), this.name);
      var1.addProperty(a.c(-1447792017, "爙"), wlk.worldId());
      var1.addProperty(a.d("\u07b4", -2136714895, -1287367008), wlk.dimensionId());
      JsonObject var2 = new JsonObject();
      var2.addProperty(a.c(-2099774373, "ﰮ"), a.d("➧帑퓗䪳셥䟒", 4525429, -1593759065));
      var2.addProperty(a.b("\ue8d3", 1165486241), this.gqy(a.b("\ueb22銔ᡏ", 373091154) + this.party + a.b("\udaaf", 1019206354) + this.code, var1));
      this.send(var2.toString());
   }

   void mark(int var1, double var2, double var4, double var6, int var8, String var9) {
      JsonObject var10 = new JsonObject();
      var10.addProperty(a.d("矧", 312543999, -1984922259), a.d("侄㘹볹⊑", 2044393956, -652036599));
      var10.addProperty(a.d("藝ﱡ", 399168598, -1110355488), var1);
      var10.addProperty(a.b("쇠", -1186217575), var2);
      var10.addProperty(a.c(1046468301, "횵"), var4);
      var10.addProperty(a.d("뉜", 249194085, 1586025538), var6);
      var10.addProperty(a.c(1294379913, "\uabff"), this.world != null ? this.world : wlk.worldId());
      var10.addProperty(a.b("܁", 225380196), wlk.dimensionId());
      var10.addProperty(a.d("䬷", -1544406560, -319786307), var8);
      var10.addProperty(a.d("\uf3d2", 268344697, 2145676996), this.name);
      if (var9 != null) {
         var10.addProperty(a.c(2086459824, "\ud9c1"), var9);
      }

      JsonObject var11 = new JsonObject();
      var11.addProperty(a.d("不", -1371876977, -1913544713), a.c(1854036913, "察≰ꢷ"));
      var11.addProperty(a.d("⒛", -790782089, 1317780366), this.gqy(a.c(-1910397069, "ꜚ\udeb5呲쨘") + this.party + a.b("샴", 1297858697) + this.code, var10));
      this.send(var11.toString());
   }

   void acceptPending() {
      JsonObject var1 = this.pendingInvite;
      if (var1 == null) {
         grd.grs(a.d("壪⅜ꮇ㗳빈", 532128457, -848299424) + this.name + a.b("癉ྰ蕪ᬉ邍ᙲ갠▞뮈ㄾ뛵䲛쉑寱", 1693808231));
      } else {
         JsonObject var2 = this.grb(
            var1.get(a.d("긥힀嵎쌽", 1184755602, -27180587)).getAsString(),
            var1.get(a.c(-600850698, "뺅윱䷵")).getAsString(),
            var1.get(a.d("찕떩㽭", -729143243, -1945050047)).getAsString()
         );
         if (var2 != null) {
            this.keys.clear();
            this.epoch = var2.get(a.b("썭", 641385225)).getAsInt();
            this.keys.put(this.epoch, ufw.unb64(var2.get(a.b("⨟", 399452789)).getAsString()));
         }

         this.send(
            a.d("ﯲ舚࢟隸ᵷ鯞⇎\ua83d㙢볕㬓셦俧환尅\udaa6惸\uef3a疏\uf3d3穿6躝", 860109517, -192495277)
               + var1.get(a.b("မ榹\ue379紎\uf6d4", 1814827116)).getAsString()
               + a.c(-1912032708, "눜쯲")
         );
      }
   }

   boolean plainHas(String var1) {
      return this.plain.stream().anyMatch(var1x -> var1x.contains(var1));
   }

   void close() {
      WebSocket var1 = this.ws;
      if (var1 != null) {
         var1.abort();
      }
   }

   String gqy(String var1, JsonObject var2) {
      try {
         return this.epoch
            + a.b("冡", -555658866)
            + ufw.seal(this.keys.get(this.epoch), var1 + a.d("扬", 1647419492, -1011367307) + this.epoch, var2.toString().getBytes(StandardCharsets.UTF_8));
      } catch (Exception var4) {
         throw new IllegalStateException(var4);
      }
   }

   String gqz(String var1, String var2) {
      int var3 = var2.indexOf(46);
      int var4 = Integer.parseInt(var2.substring(0, var3));
      byte[] var5 = this.keys.get(var4);
      if (var5 == null) {
         return null;
      }

      byte[] var6 = ufw.open(var5, var1 + a.d("\uf125", 1570583658, -1593326286) + var4, var2.substring(var3 + 1));
      return var6 == null ? null : new String(var6, StandardCharsets.UTF_8);
   }

   String gra(String var1, String var2) {
      try {
         JsonObject var3 = new JsonObject();
         var3.addProperty(a.b("蜿", 833128277), ufw.b64(this.keys.get(this.epoch)));
         var3.addProperty(a.b("谝", -1925280647), this.epoch);
         var3.addProperty(a.b("␁", 643048558), this.name);
         byte[] var4 = ufw.boxKey(this.pair.getPrivate(), this.pub, var2);
         return ufw.seal(
            var4, a.b("鳭\ue551澕\uf1e0", -438920053) + this.code + a.d("饃", 110865096, -1983826954) + var1, var3.toString().getBytes(StandardCharsets.UTF_8)
         );
      } catch (Exception var5) {
         throw new IllegalStateException(var5);
      }
   }

   JsonObject grb(String var1, String var2, String var3) {
      try {
         byte[] var4 = ufw.boxKey(this.pair.getPrivate(), this.pub, var2);
         byte[] var5 = ufw.open(var4, a.b("\ue8ac鄐ᯔ薡", 1510729930) + var1 + a.c(1825670474, "蔷") + this.code, var3);
         return var5 == null ? null : JsonParser.parseString(new String(var5, StandardCharsets.UTF_8)).getAsJsonObject();
      } catch (Exception var6) {
         return null;
      }
   }

   void grc(JsonObject var1) {
            if (java.util.Objects.equals(var1.get(a.d("싗", 51045068, -1407180690)).getAsString(), a.c(-2046880061) || java.util.Objects.equals(var1.get(a.d("싗", 51045068, -1407180690)).getAsString(), "ᚮ漒\ue5c8箹\uf06d"))) {
         this.code = var1.get(a.d("勺菊ऒ面", -901148505, 1856596663)).getAsString();
      }
      else if (java.util.Objects.equals(var1.get(a.d("싗", 51045068, -1407180690)).getAsString(), a.d("\uf745軱е") || java.util.Objects.equals(var1.get(a.d("싗", 51045068, -1407180690)).getAsString(), -540801502) || java.util.Objects.equals(var1.get(a.d("싗", 51045068, -1407180690)).getAsString(), -1071582956))) {
         String var10 = var1.get(a.b("邂\ue93f揧ﶗ", -291925787)).getAsString();
                     JsonObject var12 = new JsonObject();
                     var12.addProperty(a.d("ᝐ", -1738727736, 1001130477), a.d("\uf63a辌Շ鬩უ陃", 804180212, 1635198625));
                     var12.addProperty(a.c(1804040746, "積ϰ褨\u1758"), var10);
                     var12.addProperty(a.c(1922785991, "抦ᬚ釞"), this.gra(var10, var1.get(a.d("\udd9aꐮ⻪", -1906812785, 19432806)).getAsString()));
                     new Thread(() -> this.send(var12.toString())).start();
      }
      else if (java.util.Objects.equals(var1.get(a.d("싗", 51045068, -1407180690)).getAsString(), a.c(-1812342966) || java.util.Objects.equals(var1.get(a.d("싗", 51045068, -1407180690)).getAsString(), "휥꺓\u2458먶ㇼ띜"))) {
         this.pendingInvite = var1;
      }
      else if (java.util.Objects.equals(var1.get(a.d("싗", 51045068, -1407180690)).getAsString(), a.c(362697104) || java.util.Objects.equals(var1.get(a.d("싗", 51045068, -1407180690)).getAsString(), "凥⡅ꊅ㳲뜨"))) {
         JsonElement var9 = var1.get(a.c(-519134740, "ꆇ\ud83b"));
                     this.party = var9 != null && !var9.isJsonNull() ? var9.getAsString() : null;
                     if (var1.has(a.b("뗹챀䚛\ud8e5匵햓濁", -224741997))) {
                        for (JsonElement var13 : var1.getAsJsonArray(a.d("䥽ツ먟②꾱⤗鍅", -1814073187, 2049718666))) {
                           JsonObject var7 = var13.getAsJsonObject();
                           if (var7.has(a.c(-1993025020, "\uda77ꏃ⤇")) && !var7.get(a.d("ྴ瘀ﳄ", 694997300, -310649101)).isJsonNull()) {
                              this.pubs.put(var7.get(a.c(-1149277202, "殉ሴ飬ڜ")).getAsString(), var7.get(a.d("\u0cdb畯ﾫ", 1760809879, 495705919)).getAsString());
                           }
                        }
                     }
      }
      else if (java.util.Objects.equals(var1.get(a.d("싗", 51045068, -1407180690)).getAsString(), a.c(1423508301) || java.util.Objects.equals(var1.get(a.d("싗", 51045068, -1407180690)).getAsString(), "̥窚\uf055"))) {
         String var8 = var1.get(a.d("窶̓觝ឮ", 924207934, 1319907818)).getAsString();
                     JsonObject var5 = this.grb(var8, this.pubs.get(var8), var1.get(a.c(-1044277530, "隇\uef3b旿")).getAsString());
                     if (var5 != null) {
                        int var6 = var5.get(a.d("⍞", 230059673, -1770566237)).getAsInt();
                        this.keys.put(var6, ufw.unb64(var5.get(a.c(795055713, "阋")).getAsString()));
                        this.epoch = Math.max(this.epoch, var6);
                        this.keyBoxes++;
                     }
      }
      else if (java.util.Objects.equals(var1.get(a.d("싗", 51045068, -1407180690)).getAsString(), a.c(-1774961781) || java.util.Objects.equals(var1.get(a.d("싗", 51045068, -1407180690)).getAsString(), "㯥䉊좍"))) {
         String var4 = this.gqz(
                        a.c(-1739553134, "蛻ｔ疓\uebf9") + this.party + a.d("셳", 1146297548, -909976126) + var1.get(a.b("ᮇ戢\ue8ec皟", -1608508443)).getAsString(),
                        var1.get(a.b("銧", -435252539)).getAsString()
                     );
                     if (var4 != null) {
                        this.plain.add(var4);
                     }
      }
   }

   @Override
   public void onOpen(WebSocket var1) {
      this.ws = var1;
      var1.request(1L);
   }

   @Override
   public CompletionStage<?> onText(WebSocket var1, CharSequence var2, boolean var3) {
      this.gqv.append(var2);
      if (var3) {
         String var4 = this.gqv.toString();
         this.gqv.setLength(0);
         this.raw.add(var4);

         try {
            this.grc(JsonParser.parseString(var4).getAsJsonObject());
         } catch (RuntimeException var6) {
            grd.grs(this.name + a.d("熊ࡳ芩᳗霊ᆳꯩ≝뱄㛲넩䭝얃尳혾僕", -1758766465, 501623749) + var6);
         }
      }

      var1.request(1L);
      return null;
   }
}
