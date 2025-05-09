package funnymap.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.io.Closeable;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"},
   d2 = {"Lfunnymap/utils/APIUtils;", "", "", "uri", "fetch", "(Ljava/lang/String;)Ljava/lang/String;", "uuid", "", "getSecrets", "(Ljava/lang/String;)I", "", "hasBonusPaulScore", "()Z", "<init>", "()V", "FunnyMapExtras"}
)
@SourceDebugExtension({"SMAP\nAPIUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 APIUtils.kt\nfunnymap/utils/APIUtils\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,44:1\n1747#2,3:45\n*S KotlinDebug\n*F\n+ 1 APIUtils.kt\nfunnymap/utils/APIUtils\n*L\n36#1:45,3\n*E\n"})
public final class APIUtils {
   @NotNull
   public static final APIUtils INSTANCE = new APIUtils();

   private APIUtils() {
   }

   @Nullable
   public final String fetch(@NotNull String uri) {
      Intrinsics.checkNotNullParameter(uri, "uri");
      Closeable var2 = (Closeable)HttpClients.createMinimal();
      Throwable var3 = null;

      Object var8;
      try {
         CloseableHttpClient it = (CloseableHttpClient)var2;
         boolean var5 = false;

         try {
            HttpGet httpGet = new HttpGet(uri);
            String var9 = EntityUtils.toString(it.execute((HttpUriRequest)httpGet).getEntity());
            return var9;
         } catch (Exception var13) {
            var8 = null;
         }
      } catch (Throwable var14) {
         var3 = var14;
         throw var14;
      } finally {
         CloseableKt.closeFinally(var2, var3);
      }

      return (String)var8;
   }

   public final int getSecrets(@NotNull String uuid) {
      Intrinsics.checkNotNullParameter(uuid, "uuid");
      String var10000 = this.fetch("http://18.116.11.192:2820/secrets/" + uuid);
      if (var10000 == null) {
         return 0;
      } else {
         String response = var10000;
         JsonElement var4 = (new JsonParser()).parse(response);
         Intrinsics.checkNotNullExpressionValue(var4, "parse(...)");
         JsonObject var5 = JsonUtilsKt.toJsonObject(var4);
         if (var5 == null) {
            return 0;
         } else {
            JsonObject jsonObject = var5;
            JsonPrimitive var6 = JsonUtilsKt.getJsonPrimitive(jsonObject, "success");
            if (var6 != null ? var6.getAsBoolean() : false) {
               var6 = JsonUtilsKt.getJsonPrimitive(jsonObject, "secrets");
               return var6 != null ? var6.getAsInt() : 0;
            } else {
               return 0;
            }
         }
      }
   }

   public final boolean hasBonusPaulScore() {
      String var10000 = this.fetch("https://api.hypixel.net/resources/skyblock/election");
      if (var10000 == null) {
         return false;
      } else {
         String response = var10000;
         JsonElement var11 = (new JsonParser()).parse(response);
         Intrinsics.checkNotNullExpressionValue(var11, "parse(...)");
         JsonObject var12 = JsonUtilsKt.toJsonObject(var11);
         if (var12 == null) {
            return false;
         } else {
            JsonObject jsonObject = var12;
            JsonPrimitive var13 = JsonUtilsKt.getJsonPrimitive(jsonObject, "success");
            if (var13 != null ? var13.getAsBoolean() : false) {
               var12 = JsonUtilsKt.getJsonObject(jsonObject, "mayor");
               if (var12 == null) {
                  return false;
               }

               JsonObject mayor = var12;
               var13 = JsonUtilsKt.getJsonPrimitive(mayor, "name");
               String name = var13 != null ? var13.getAsString() : null;
               if (Intrinsics.areEqual(name, "Paul")) {
                  JsonArray var14 = JsonUtilsKt.getJsonArray(mayor, "perks");
                  boolean var15;
                  if (var14 != null) {
                     Iterable $this$any$iv = (Iterable)var14;
                     int $i$f$any = false;
                     if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                        var15 = false;
                     } else {
                        Iterator var7 = $this$any$iv.iterator();

                        while(true) {
                           if (!var7.hasNext()) {
                              var15 = false;
                              break;
                           }

                           label47: {
                              Object element$iv = var7.next();
                              JsonElement it = (JsonElement)element$iv;
                              int var10 = false;
                              Intrinsics.checkNotNull(it);
                              var12 = JsonUtilsKt.toJsonObject(it);
                              if (var12 != null) {
                                 var13 = JsonUtilsKt.getJsonPrimitive(var12, "name");
                                 if (var13 != null) {
                                    var10000 = var13.getAsString();
                                    break label47;
                                 }
                              }

                              var10000 = null;
                           }

                           if (Intrinsics.areEqual(var10000, "EZPZ")) {
                              var15 = true;
                              break;
                           }
                        }
                     }
                  } else {
                     var15 = false;
                  }

                  return var15;
               }
            }

            return false;
         }
      }
   }
}
