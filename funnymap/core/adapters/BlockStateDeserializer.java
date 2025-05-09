package funnymap.core.adapters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import funnymap.features.extras.BlockStateUtils;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"},
   d2 = {"Lfunnymap/core/adapters/BlockStateDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lnet/minecraft/block/state/IBlockState;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lnet/minecraft/block/state/IBlockState;", "<init>", "()V", "FunnyMapExtras"}
)
public final class BlockStateDeserializer implements JsonDeserializer<IBlockState> {
   @NotNull
   public IBlockState deserialize(@NotNull JsonElement json, @NotNull Type typeOfT, @NotNull JsonDeserializationContext context) {
      Intrinsics.checkNotNullParameter(json, "json");
      Intrinsics.checkNotNullParameter(typeOfT, "typeOfT");
      Intrinsics.checkNotNullParameter(context, "context");
      IBlockState var4 = Blocks.field_150350_a.func_176223_P();
      if (!json.isJsonPrimitive()) {
         Intrinsics.checkNotNull(var4);
         return var4;
      } else {
         String string = json.getAsString();
         Intrinsics.checkNotNull(string);
         boolean hasArgs = StringsKt.contains$default((CharSequence)string, (CharSequence)"[", false, 2, (Object)null) && StringsKt.contains$default((CharSequence)string, (CharSequence)"]", false, 2, (Object)null);
         Block var10000;
         IBlockState var21;
         if (!hasArgs) {
            var10000 = Block.func_149684_b(string);
            var21 = var10000 != null ? var10000.func_176223_P() : null;
            if (var21 == null) {
               Intrinsics.checkNotNull(var4);
               var21 = var4;
            }

            return var21;
         } else {
            label57: {
               var10000 = Block.func_149684_b(StringsKt.substringBefore$default(string, "[", (String)null, 2, (Object)null));
               if (var10000 != null) {
                  var21 = var10000.func_176223_P();
                  if (var21 != null) {
                     break label57;
                  }
               }

               var21 = var4;
            }

            IBlockState blockState = var21;
            CharSequence var22 = (CharSequence)StringsKt.substringBefore$default(StringsKt.substringAfter$default(string, "[", (String)null, 2, (Object)null), "]", (String)null, 2, (Object)null);
            String[] var9 = new String[]{","};
            List args = StringsKt.split$default(var22, var9, false, 0, 6, (Object)null);
            Iterator var19 = args.iterator();

            while(true) {
               List data;
               do {
                  if (!var19.hasNext()) {
                     Intrinsics.checkNotNull(blockState);
                     return blockState;
                  }

                  String arg = (String)var19.next();
                  var22 = (CharSequence)arg;
                  String[] var12 = new String[]{"="};
                  data = StringsKt.split$default(var22, var12, false, 0, 6, (Object)null);
               } while(data.size() != 2);

               Set var23 = blockState.func_177228_b().keySet();
               Intrinsics.checkNotNullExpressionValue(var23, "<get-keys>(...)");
               Iterable var14 = (Iterable)var23;
               Iterator var15 = var14.iterator();

               Object var24;
               while(true) {
                  if (!var15.hasNext()) {
                     var24 = null;
                     break;
                  }

                  Object var16 = var15.next();
                  IProperty it = (IProperty)var16;
                  int var18 = false;
                  if (Intrinsics.areEqual(it.func_177701_a(), data.get(0))) {
                     var24 = var16;
                     break;
                  }
               }

               IProperty var25 = (IProperty)var24;
               if (var25 != null) {
                  IProperty property = var25;
                  BlockStateUtils var26 = BlockStateUtils.INSTANCE;
                  Intrinsics.checkNotNull(blockState);
                  blockState = var26.withProperty(blockState, property, (String)data.get(1));
               }
            }
         }
      }
   }
}
