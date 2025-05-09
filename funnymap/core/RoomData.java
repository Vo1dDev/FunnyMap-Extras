package funnymap.core;

import funnymap.core.map.RoomType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u0000 ,2\u00020\u0001:\u0001,B=\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\t¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u000f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJR\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00052\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001c\u0010\rJ\u0010\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0004R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u001f\u0010\u000bR\u0017\u0010\u0013\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b!\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b#\u0010\u0004R\u0017\u0010\u0014\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b$\u0010\rR\u0017\u0010\u0015\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b%\u0010\rR\"\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010&\u001a\u0004\b'\u0010\u0007\"\u0004\b(\u0010)¨\u0006-"},
   d2 = {"Lfunnymap/core/RoomData;", "", "", "component1", "()Ljava/lang/String;", "Lfunnymap/core/map/RoomType;", "component2", "()Lfunnymap/core/map/RoomType;", "", "", "component3", "()Ljava/util/List;", "component4", "()I", "component5", "component6", "name", "type", "cores", "crypts", "secrets", "trappedChests", "copy", "(Ljava/lang/String;Lfunnymap/core/map/RoomType;Ljava/util/List;III)Lfunnymap/core/RoomData;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/util/List;", "getCores", "I", "getCrypts", "Ljava/lang/String;", "getName", "getSecrets", "getTrappedChests", "Lfunnymap/core/map/RoomType;", "getType", "setType", "(Lfunnymap/core/map/RoomType;)V", "<init>", "(Ljava/lang/String;Lfunnymap/core/map/RoomType;Ljava/util/List;III)V", "Companion", "FunnyMapExtras"}
)
public final class RoomData {
   @NotNull
   public static final RoomData.Companion Companion = new RoomData.Companion((DefaultConstructorMarker)null);
   @NotNull
   private final String name;
   @NotNull
   private RoomType type;
   @NotNull
   private final List<Integer> cores;
   private final int crypts;
   private final int secrets;
   private final int trappedChests;

   public RoomData(@NotNull String name, @NotNull RoomType type, @NotNull List<Integer> cores, int crypts, int secrets, int trappedChests) {
      Intrinsics.checkNotNullParameter(name, "name");
      Intrinsics.checkNotNullParameter(type, "type");
      Intrinsics.checkNotNullParameter(cores, "cores");
      super();
      this.name = name;
      this.type = type;
      this.cores = cores;
      this.crypts = crypts;
      this.secrets = secrets;
      this.trappedChests = trappedChests;
   }

   @NotNull
   public final String getName() {
      return this.name;
   }

   @NotNull
   public final RoomType getType() {
      return this.type;
   }

   public final void setType(@NotNull RoomType <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.type = var1;
   }

   @NotNull
   public final List<Integer> getCores() {
      return this.cores;
   }

   public final int getCrypts() {
      return this.crypts;
   }

   public final int getSecrets() {
      return this.secrets;
   }

   public final int getTrappedChests() {
      return this.trappedChests;
   }

   @NotNull
   public final String component1() {
      return this.name;
   }

   @NotNull
   public final RoomType component2() {
      return this.type;
   }

   @NotNull
   public final List<Integer> component3() {
      return this.cores;
   }

   public final int component4() {
      return this.crypts;
   }

   public final int component5() {
      return this.secrets;
   }

   public final int component6() {
      return this.trappedChests;
   }

   @NotNull
   public final RoomData copy(@NotNull String name, @NotNull RoomType type, @NotNull List<Integer> cores, int crypts, int secrets, int trappedChests) {
      Intrinsics.checkNotNullParameter(name, "name");
      Intrinsics.checkNotNullParameter(type, "type");
      Intrinsics.checkNotNullParameter(cores, "cores");
      return new RoomData(name, type, cores, crypts, secrets, trappedChests);
   }

   // $FF: synthetic method
   public static RoomData copy$default(RoomData var0, String var1, RoomType var2, List var3, int var4, int var5, int var6, int var7, Object var8) {
      if ((var7 & 1) != 0) {
         var1 = var0.name;
      }

      if ((var7 & 2) != 0) {
         var2 = var0.type;
      }

      if ((var7 & 4) != 0) {
         var3 = var0.cores;
      }

      if ((var7 & 8) != 0) {
         var4 = var0.crypts;
      }

      if ((var7 & 16) != 0) {
         var5 = var0.secrets;
      }

      if ((var7 & 32) != 0) {
         var6 = var0.trappedChests;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6);
   }

   @NotNull
   public String toString() {
      return "RoomData(name=" + this.name + ", type=" + this.type + ", cores=" + this.cores + ", crypts=" + this.crypts + ", secrets=" + this.secrets + ", trappedChests=" + this.trappedChests + ')';
   }

   public int hashCode() {
      int result = this.name.hashCode();
      result = result * 31 + this.type.hashCode();
      result = result * 31 + this.cores.hashCode();
      result = result * 31 + Integer.hashCode(this.crypts);
      result = result * 31 + Integer.hashCode(this.secrets);
      result = result * 31 + Integer.hashCode(this.trappedChests);
      return result;
   }

   public boolean equals(@Nullable Object other) {
      if (this == other) {
         return true;
      } else if (!(other instanceof RoomData)) {
         return false;
      } else {
         RoomData var2 = (RoomData)other;
         if (!Intrinsics.areEqual(this.name, var2.name)) {
            return false;
         } else if (this.type != var2.type) {
            return false;
         } else if (!Intrinsics.areEqual(this.cores, var2.cores)) {
            return false;
         } else if (this.crypts != var2.crypts) {
            return false;
         } else if (this.secrets != var2.secrets) {
            return false;
         } else {
            return this.trappedChests == var2.trappedChests;
         }
      }
   }

   @Metadata(
      mv = {1, 9, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"},
      d2 = {"Lfunnymap/core/RoomData$Companion;", "", "Lfunnymap/core/map/RoomType;", "type", "Lfunnymap/core/RoomData;", "createUnknown", "(Lfunnymap/core/map/RoomType;)Lfunnymap/core/RoomData;", "<init>", "()V", "FunnyMapExtras"}
   )
   public static final class Companion {
      private Companion() {
      }

      @NotNull
      public final RoomData createUnknown(@NotNull RoomType type) {
         Intrinsics.checkNotNullParameter(type, "type");
         return new RoomData("Unknown", type, CollectionsKt.emptyList(), 0, 0, 0);
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}
