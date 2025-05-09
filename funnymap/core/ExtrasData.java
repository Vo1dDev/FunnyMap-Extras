package funnymap.core;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\u001a\b\u0002\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0007¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\"\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0007HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJJ\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\u001a\b\u0002\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0007HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001d\u0010\u0004R)\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00078\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u001f\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b \u0010\u0004¨\u0006#"},
   d2 = {"Lfunnymap/core/ExtrasData;", "", "", "component1", "()I", "component2", "component3", "", "Lnet/minecraft/block/state/IBlockState;", "", "Lnet/minecraft/util/BlockPos;", "component4", "()Ljava/util/Map;", "baseCore", "rotationCore", "coreDistance", "preBlocks", "copy", "(IIILjava/util/Map;)Lfunnymap/core/ExtrasData;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getBaseCore", "getCoreDistance", "Ljava/util/Map;", "getPreBlocks", "getRotationCore", "<init>", "(IIILjava/util/Map;)V", "FunnyMapExtras"}
)
public final class ExtrasData {
   private final int baseCore;
   private final int rotationCore;
   private final int coreDistance;
   @NotNull
   private final Map<IBlockState, Set<BlockPos>> preBlocks;

   public ExtrasData(int baseCore, int rotationCore, int coreDistance, @NotNull Map<IBlockState, Set<BlockPos>> preBlocks) {
      Intrinsics.checkNotNullParameter(preBlocks, "preBlocks");
      super();
      this.baseCore = baseCore;
      this.rotationCore = rotationCore;
      this.coreDistance = coreDistance;
      this.preBlocks = preBlocks;
   }

   // $FF: synthetic method
   public ExtrasData(int var1, int var2, int var3, Map var4, int var5, DefaultConstructorMarker var6) {
      if ((var5 & 1) != 0) {
         var1 = 0;
      }

      if ((var5 & 2) != 0) {
         var2 = 0;
      }

      if ((var5 & 4) != 0) {
         var3 = 2;
      }

      if ((var5 & 8) != 0) {
         var4 = (Map)(new LinkedHashMap());
      }

      this(var1, var2, var3, var4);
   }

   public final int getBaseCore() {
      return this.baseCore;
   }

   public final int getRotationCore() {
      return this.rotationCore;
   }

   public final int getCoreDistance() {
      return this.coreDistance;
   }

   @NotNull
   public final Map<IBlockState, Set<BlockPos>> getPreBlocks() {
      return this.preBlocks;
   }

   public final int component1() {
      return this.baseCore;
   }

   public final int component2() {
      return this.rotationCore;
   }

   public final int component3() {
      return this.coreDistance;
   }

   @NotNull
   public final Map<IBlockState, Set<BlockPos>> component4() {
      return this.preBlocks;
   }

   @NotNull
   public final ExtrasData copy(int baseCore, int rotationCore, int coreDistance, @NotNull Map<IBlockState, Set<BlockPos>> preBlocks) {
      Intrinsics.checkNotNullParameter(preBlocks, "preBlocks");
      return new ExtrasData(baseCore, rotationCore, coreDistance, preBlocks);
   }

   // $FF: synthetic method
   public static ExtrasData copy$default(ExtrasData var0, int var1, int var2, int var3, Map var4, int var5, Object var6) {
      if ((var5 & 1) != 0) {
         var1 = var0.baseCore;
      }

      if ((var5 & 2) != 0) {
         var2 = var0.rotationCore;
      }

      if ((var5 & 4) != 0) {
         var3 = var0.coreDistance;
      }

      if ((var5 & 8) != 0) {
         var4 = var0.preBlocks;
      }

      return var0.copy(var1, var2, var3, var4);
   }

   @NotNull
   public String toString() {
      return "ExtrasData(baseCore=" + this.baseCore + ", rotationCore=" + this.rotationCore + ", coreDistance=" + this.coreDistance + ", preBlocks=" + this.preBlocks + ')';
   }

   public int hashCode() {
      int result = Integer.hashCode(this.baseCore);
      result = result * 31 + Integer.hashCode(this.rotationCore);
      result = result * 31 + Integer.hashCode(this.coreDistance);
      result = result * 31 + this.preBlocks.hashCode();
      return result;
   }

   public boolean equals(@Nullable Object other) {
      if (this == other) {
         return true;
      } else if (!(other instanceof ExtrasData)) {
         return false;
      } else {
         ExtrasData var2 = (ExtrasData)other;
         if (this.baseCore != var2.baseCore) {
            return false;
         } else if (this.rotationCore != var2.rotationCore) {
            return false;
         } else if (this.coreDistance != var2.coreDistance) {
            return false;
         } else {
            return Intrinsics.areEqual(this.preBlocks, var2.preBlocks);
         }
      }
   }

   public ExtrasData() {
      this(0, 0, 0, (Map)null, 15, (DefaultConstructorMarker)null);
   }
}
