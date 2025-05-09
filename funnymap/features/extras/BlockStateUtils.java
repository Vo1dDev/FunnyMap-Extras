package funnymap.features.extras;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J7\u0010\t\u001a\u00020\u0004\"\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u0002*\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"},
   d2 = {"Lfunnymap/features/extras/BlockStateUtils;", "", "", "T", "Lnet/minecraft/block/state/IBlockState;", "Lnet/minecraft/block/properties/IProperty;", "property", "", "valueString", "withProperty", "(Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/block/properties/IProperty;Ljava/lang/String;)Lnet/minecraft/block/state/IBlockState;", "", "rotation", "withRotation", "(Lnet/minecraft/block/state/IBlockState;I)Lnet/minecraft/block/state/IBlockState;", "<init>", "()V", "FunnyMapExtras"}
)
@SourceDebugExtension({"SMAP\nBlockStateUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BlockStateUtils.kt\nfunnymap/features/extras/BlockStateUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,23:1\n1#2:24\n*E\n"})
public final class BlockStateUtils {
   @NotNull
   public static final BlockStateUtils INSTANCE = new BlockStateUtils();

   private BlockStateUtils() {
   }

   @NotNull
   public final IBlockState withRotation(@NotNull IBlockState $this$withRotation, int rotation) {
      Intrinsics.checkNotNullParameter($this$withRotation, "<this>");
      Set var10000 = $this$withRotation.func_177228_b().keySet();
      Intrinsics.checkNotNullExpressionValue(var10000, "<get-keys>(...)");
      Iterable var5 = (Iterable)var10000;
      Iterator var6 = var5.iterator();

      Object var10;
      while(true) {
         if (var6.hasNext()) {
            Object var7 = var6.next();
            IProperty it = (IProperty)var7;
            int var9 = false;
            if (!(it instanceof PropertyDirection)) {
               continue;
            }

            var10 = var7;
            break;
         }

         var10 = null;
         break;
      }

      IProperty var11 = (IProperty)var10;
      if (var11 == null) {
         return $this$withRotation;
      } else {
         IProperty directionProperty = var11;
         String direction = RotationUtils.INSTANCE.getRotatedDirection(String.valueOf($this$withRotation.func_177228_b().get(directionProperty)), rotation);
         return this.withProperty($this$withRotation, directionProperty, direction);
      }
   }

   @NotNull
   public final <T extends Comparable<? super T>> IBlockState withProperty(@NotNull IBlockState $this$withProperty, @NotNull IProperty<T> property, @NotNull String valueString) {
      Intrinsics.checkNotNullParameter($this$withProperty, "<this>");
      Intrinsics.checkNotNullParameter(property, "property");
      Intrinsics.checkNotNullParameter(valueString, "valueString");
      Collection var10000 = property.func_177700_c();
      Intrinsics.checkNotNullExpressionValue(var10000, "getAllowedValues(...)");
      Iterable var5 = (Iterable)var10000;
      Iterator var6 = var5.iterator();

      Object var10;
      while(true) {
         if (var6.hasNext()) {
            Object var7 = var6.next();
            Comparable it = (Comparable)var7;
            int var9 = false;
            if (!Intrinsics.areEqual(property.func_177702_a(it), valueString)) {
               continue;
            }

            var10 = var7;
            break;
         }

         var10 = null;
         break;
      }

      Comparable var11 = (Comparable)var10;
      if (var11 == null) {
         return $this$withProperty;
      } else {
         Comparable value = var11;
         IBlockState var12 = $this$withProperty.func_177226_a(property, value);
         Intrinsics.checkNotNullExpressionValue(var12, "withProperty(...)");
         return var12;
      }
   }
}
