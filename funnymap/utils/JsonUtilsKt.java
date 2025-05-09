package funnymap.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001b\u0010\t\u001a\u0004\u0018\u00010\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\t\u0010\n\u001a\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003*\u00020\u000b¢\u0006\u0004\b\f\u0010\r\u001a\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0000*\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0013\u0010\u0010\u001a\u0004\u0018\u00010\b*\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"},
   d2 = {"Lcom/google/gson/JsonObject;", "", "member", "Lcom/google/gson/JsonArray;", "getJsonArray", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Lcom/google/gson/JsonArray;", "getJsonObject", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Lcom/google/gson/JsonObject;", "Lcom/google/gson/JsonPrimitive;", "getJsonPrimitive", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Lcom/google/gson/JsonPrimitive;", "Lcom/google/gson/JsonElement;", "toJsonArray", "(Lcom/google/gson/JsonElement;)Lcom/google/gson/JsonArray;", "toJsonObject", "(Lcom/google/gson/JsonElement;)Lcom/google/gson/JsonObject;", "toJsonPrimitive", "(Lcom/google/gson/JsonElement;)Lcom/google/gson/JsonPrimitive;", "FunnyMapExtras"}
)
public final class JsonUtilsKt {
   @Nullable
   public static final JsonArray toJsonArray(@NotNull JsonElement $this$toJsonArray) {
      Intrinsics.checkNotNullParameter($this$toJsonArray, "<this>");
      return $this$toJsonArray instanceof JsonArray ? (JsonArray)$this$toJsonArray : null;
   }

   @Nullable
   public static final JsonObject toJsonObject(@NotNull JsonElement $this$toJsonObject) {
      Intrinsics.checkNotNullParameter($this$toJsonObject, "<this>");
      return $this$toJsonObject instanceof JsonObject ? (JsonObject)$this$toJsonObject : null;
   }

   @Nullable
   public static final JsonPrimitive toJsonPrimitive(@NotNull JsonElement $this$toJsonPrimitive) {
      Intrinsics.checkNotNullParameter($this$toJsonPrimitive, "<this>");
      return $this$toJsonPrimitive instanceof JsonPrimitive ? (JsonPrimitive)$this$toJsonPrimitive : null;
   }

   @Nullable
   public static final JsonArray getJsonArray(@NotNull JsonObject $this$getJsonArray, @NotNull String member) {
      Intrinsics.checkNotNullParameter($this$getJsonArray, "<this>");
      Intrinsics.checkNotNullParameter(member, "member");
      JsonElement var10000 = $this$getJsonArray.get(member);
      return var10000 != null ? toJsonArray(var10000) : null;
   }

   @Nullable
   public static final JsonObject getJsonObject(@NotNull JsonObject $this$getJsonObject, @NotNull String member) {
      Intrinsics.checkNotNullParameter($this$getJsonObject, "<this>");
      Intrinsics.checkNotNullParameter(member, "member");
      JsonElement var10000 = $this$getJsonObject.get(member);
      return var10000 != null ? toJsonObject(var10000) : null;
   }

   @Nullable
   public static final JsonPrimitive getJsonPrimitive(@NotNull JsonObject $this$getJsonPrimitive, @NotNull String member) {
      Intrinsics.checkNotNullParameter($this$getJsonPrimitive, "<this>");
      Intrinsics.checkNotNullParameter(member, "member");
      JsonElement var10000 = $this$getJsonPrimitive.get(member);
      return var10000 != null ? toJsonPrimitive(var10000) : null;
   }
}
