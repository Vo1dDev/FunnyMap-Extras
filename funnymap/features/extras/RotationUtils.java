package funnymap.features.extras;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.BlockPos;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"},
   d2 = {"Lfunnymap/features/extras/RotationUtils;", "", "", "rotation", "getNormalizedRotation", "(I)I", "", "direction", "getRotatedDirection", "(Ljava/lang/String;I)Ljava/lang/String;", "Lnet/minecraft/util/BlockPos;", "blockPos", "getRotatedPos", "(Lnet/minecraft/util/BlockPos;I)Lnet/minecraft/util/BlockPos;", "", "directions", "Ljava/util/List;", "<init>", "()V", "FunnyMapExtras"}
)
public final class RotationUtils {
   @NotNull
   public static final RotationUtils INSTANCE = new RotationUtils();
   @NotNull
   private static final List<String> directions;

   private RotationUtils() {
   }

   @NotNull
   public final BlockPos getRotatedPos(@NotNull BlockPos blockPos, int rotation) {
      Intrinsics.checkNotNullParameter(blockPos, "blockPos");
      BlockPos var10000;
      switch(this.getNormalizedRotation(rotation)) {
      case 90:
         var10000 = new BlockPos(-blockPos.func_177952_p(), blockPos.func_177956_o(), blockPos.func_177958_n());
         break;
      case 180:
         var10000 = new BlockPos(-blockPos.func_177958_n(), blockPos.func_177956_o(), -blockPos.func_177952_p());
         break;
      case 270:
         var10000 = new BlockPos(blockPos.func_177952_p(), blockPos.func_177956_o(), -blockPos.func_177958_n());
         break;
      default:
         var10000 = blockPos;
      }

      return var10000;
   }

   @NotNull
   public final String getRotatedDirection(@NotNull String direction, int rotation) {
      Intrinsics.checkNotNullParameter(direction, "direction");
      int index = directions.indexOf(direction);
      int rotates = rotation / 90;
      return (String)directions.get((index + rotates + 4) % 4);
   }

   private final int getNormalizedRotation(int rotation) {
      return rotation % 360 + (rotation < 0 ? 360 : 0);
   }

   static {
      String[] var0 = new String[]{"north", "east", "south", "west"};
      directions = CollectionsKt.listOf(var0);
   }
}
