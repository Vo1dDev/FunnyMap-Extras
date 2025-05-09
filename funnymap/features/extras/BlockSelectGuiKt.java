package funnymap.features.extras;

import funnymap.utils.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a!\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"},
   d2 = {"Lnet/minecraft/item/ItemStack;", "Lnet/minecraft/block/Block;", "block", "", "meta", "", "matches", "(Lnet/minecraft/item/ItemStack;Lnet/minecraft/block/Block;I)Z", "FunnyMapExtras"}
)
public final class BlockSelectGuiKt {
   public static final boolean matches(@NotNull ItemStack $this$matches, @NotNull Block block, int meta) {
      Intrinsics.checkNotNullParameter($this$matches, "<this>");
      Intrinsics.checkNotNullParameter(block, "block");
      Item var4 = $this$matches.func_77973_b();
      if (!Intrinsics.areEqual((var4 instanceof ItemBlock ? (ItemBlock)var4 : null) != null ? (var4 instanceof ItemBlock ? (ItemBlock)var4 : null).field_150939_a : null, block)) {
         return false;
      } else {
         Utils var10000 = Utils.INSTANCE;
         Object[] var6 = new Object[8];
         Block var10004 = Blocks.field_150460_al;
         Intrinsics.checkNotNullExpressionValue(var10004, "furnace");
         var6[0] = var10004;
         var10004 = Blocks.field_150470_am;
         Intrinsics.checkNotNullExpressionValue(var10004, "lit_furnace");
         var6[1] = var10004;
         var10004 = Blocks.field_150468_ap;
         Intrinsics.checkNotNullExpressionValue(var10004, "ladder");
         var6[2] = var10004;
         BlockChest var5 = Blocks.field_150486_ae;
         Intrinsics.checkNotNullExpressionValue(var5, "chest");
         var6[3] = var5;
         var10004 = Blocks.field_150447_bR;
         Intrinsics.checkNotNullExpressionValue(var10004, "trapped_chest");
         var6[4] = var10004;
         var10004 = Blocks.field_150477_bB;
         Intrinsics.checkNotNullExpressionValue(var10004, "ender_chest");
         var6[5] = var10004;
         var10004 = Blocks.field_150478_aa;
         Intrinsics.checkNotNullExpressionValue(var10004, "torch");
         var6[6] = var10004;
         var10004 = Blocks.field_150429_aA;
         Intrinsics.checkNotNullExpressionValue(var10004, "redstone_torch");
         var6[7] = var10004;
         boolean ignoreMeta = var10000.equalsOneOf(block, var6);
         return ignoreMeta ? true : $this$matches.func_77960_j() == meta;
      }
   }
}
