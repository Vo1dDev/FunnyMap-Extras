package funnymap.core.adapters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.util.BlockPos;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"},
   d2 = {"Lfunnymap/core/adapters/BlockPosAdapter;", "Lcom/google/gson/JsonSerializer;", "Lnet/minecraft/util/BlockPos;", "Lcom/google/gson/JsonDeserializer;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lnet/minecraft/util/BlockPos;", "src", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "serialize", "(Lnet/minecraft/util/BlockPos;Ljava/lang/reflect/Type;Lcom/google/gson/JsonSerializationContext;)Lcom/google/gson/JsonElement;", "<init>", "()V", "FunnyMapExtras"}
)
public final class BlockPosAdapter implements JsonSerializer<BlockPos>, JsonDeserializer<BlockPos> {
   @NotNull
   public JsonElement serialize(@NotNull BlockPos src, @NotNull Type typeOfSrc, @NotNull JsonSerializationContext context) {
      Intrinsics.checkNotNullParameter(src, "src");
      Intrinsics.checkNotNullParameter(typeOfSrc, "typeOfSrc");
      Intrinsics.checkNotNullParameter(context, "context");
      return (JsonElement)(new JsonPrimitive(src.func_177958_n() + ", " + src.func_177956_o() + ", " + src.func_177952_p()));
   }

   @NotNull
   public BlockPos deserialize(@NotNull JsonElement json, @NotNull Type typeOfT, @NotNull JsonDeserializationContext context) {
      Intrinsics.checkNotNullParameter(json, "json");
      Intrinsics.checkNotNullParameter(typeOfT, "typeOfT");
      Intrinsics.checkNotNullParameter(context, "context");
      BlockPos var10000;
      if (json.isJsonObject()) {
         var10000 = new BlockPos(json.getAsJsonObject().get("x").getAsInt(), json.getAsJsonObject().get("y").getAsInt(), json.getAsJsonObject().get("z").getAsInt());
      } else if (json.isJsonPrimitive() && json.getAsJsonPrimitive().isString()) {
         List arr;
         int var9;
         label36: {
            String var6 = json.getAsString();
            Intrinsics.checkNotNullExpressionValue(var6, "getAsString(...)");
            CharSequence var7 = (CharSequence)var6;
            String[] var5 = new String[]{", "};
            arr = StringsKt.split$default(var7, var5, false, 0, 6, (Object)null);
            var10000 = new BlockPos;
            String var10002 = (String)CollectionsKt.getOrNull(arr, 0);
            if (var10002 != null) {
               Integer var8 = StringsKt.toIntOrNull(var10002);
               if (var8 != null) {
                  var9 = var8;
                  break label36;
               }
            }

            var9 = 0;
         }

         int var11;
         label31: {
            String var10003 = (String)CollectionsKt.getOrNull(arr, 1);
            if (var10003 != null) {
               Integer var10 = StringsKt.toIntOrNull(var10003);
               if (var10 != null) {
                  var11 = var10;
                  break label31;
               }
            }

            var11 = 0;
         }

         int var13;
         label26: {
            String var10004 = (String)CollectionsKt.getOrNull(arr, 2);
            if (var10004 != null) {
               Integer var12 = StringsKt.toIntOrNull(var10004);
               if (var12 != null) {
                  var13 = var12;
                  break label26;
               }
            }

            var13 = 0;
         }

         var10000.<init>(var9, var11, var13);
      } else {
         var10000 = new BlockPos(0, 0, 0);
      }

      return var10000;
   }
}
