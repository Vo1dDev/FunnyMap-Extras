package funnymap.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraftforge.fml.common.versioning.ArtifactVersion;
import net.minecraftforge.fml.common.versioning.DefaultArtifactVersion;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"},
   d2 = {"Lfunnymap/utils/UpdateChecker;", "", "", "hasUpdate", "()I", "<init>", "()V", "FunnyMapExtras"}
)
public final class UpdateChecker {
   @NotNull
   public static final UpdateChecker INSTANCE = new UpdateChecker();

   private UpdateChecker() {
   }

   public final int hasUpdate() {
      String var10;
      label20: {
         String response = APIUtils.INSTANCE.fetch("https://api.github.com/repos/Harry282/FunnyMap/releases");
         JsonElement var10000 = (new JsonParser()).parse(response);
         Intrinsics.checkNotNullExpressionValue(var10000, "parse(...)");
         JsonArray var4 = JsonUtilsKt.toJsonArray(var10000);
         if (var4 != null) {
            JsonElement var5 = var4.get(0);
            if (var5 != null) {
               JsonObject var6 = JsonUtilsKt.toJsonObject(var5);
               if (var6 != null) {
                  JsonPrimitive var7 = JsonUtilsKt.getJsonPrimitive(var6, "tag_name");
                  if (var7 != null) {
                     var10 = var7.getAsString();
                     break label20;
                  }
               }
            }
         }

         var10 = null;
      }

      String var3 = var10;
      if (var3 == null) {
         return 0;
      } else {
         String version = var3;
         DefaultArtifactVersion current = new DefaultArtifactVersion(StringsKt.replace$default("0.7.8", "pre", "beta", false, 4, (Object)null));
         DefaultArtifactVersion latest = new DefaultArtifactVersion(StringsKt.replace$default(version, "pre", "beta", false, 4, (Object)null));
         return latest.compareTo((ArtifactVersion)current);
      }
   }
}
