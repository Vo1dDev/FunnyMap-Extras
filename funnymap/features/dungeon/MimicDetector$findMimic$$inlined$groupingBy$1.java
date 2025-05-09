package funnymap.features.dungeon;

import funnymap.core.RoomData;
import funnymap.core.map.Room;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.Grouping;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u0017\u0010\u0003\u001a\u00028\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b¸\u0006\t"},
   d2 = {"kotlin/collections/CollectionsKt___CollectionsKt.groupingBy.1", "Lkotlin/collections/Grouping;", "element", "keyOf", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "sourceIterator", "()Ljava/util/Iterator;", "kotlin-stdlib", "kotlin/collections/CollectionsKt___CollectionsKt$groupingBy$1"}
)
@SourceDebugExtension({"SMAP\n_Collections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt$groupingBy$1\n+ 2 MimicDetector.kt\nfunnymap/features/dungeon/MimicDetector\n*L\n1#1,3683:1\n57#2:3684\n*E\n"})
public final class MimicDetector$findMimic$$inlined$groupingBy$1 implements Grouping<TileEntity, String> {
   // $FF: synthetic field
   final Iterable $this_groupingBy;

   public MimicDetector$findMimic$$inlined$groupingBy$1(Iterable $receiver) {
      this.$this_groupingBy = $receiver;
   }

   @NotNull
   public Iterator<TileEntity> sourceIterator() {
      return this.$this_groupingBy.iterator();
   }

   public String keyOf(TileEntity element) {
      TileEntity it = (TileEntity)element;
      int var3 = false;
      ScanUtils var10000 = ScanUtils.INSTANCE;
      BlockPos var10001 = it.func_174877_v();
      Intrinsics.checkNotNullExpressionValue(var10001, "getPos(...)");
      Room var4 = var10000.getRoomFromPos(var10001);
      String var6;
      if (var4 != null) {
         RoomData var5 = var4.getData();
         if (var5 != null) {
            var6 = var5.getName();
            return var6;
         }
      }

      var6 = null;
      return var6;
   }
}
