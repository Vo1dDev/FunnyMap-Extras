package funnymap.features.extras;

import funnymap.FunnyMap;
import funnymap.config.Config;
import funnymap.core.EditAction;
import funnymap.core.ExtrasData;
import funnymap.core.RoomData;
import funnymap.core.map.Room;
import funnymap.events.ClickEvent;
import funnymap.features.dungeon.ScanUtils;
import funnymap.utils.Location;
import funnymap.utils.Utils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3i;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b0\u00101J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u0018\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u0018\u0010\u001cJ\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0007*\u00020\u0002H\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010\u0019R\"\u0010$\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010*\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00062"},
   d2 = {"Lfunnymap/features/extras/EditMode;", "", "Lnet/minecraft/util/MovingObjectPosition;", "getObjectMouseOver", "()Lnet/minecraft/util/MovingObjectPosition;", "", "leftClick", "Lnet/minecraft/util/BlockPos;", "blockPos", "handleEdit", "(ZLnet/minecraft/util/BlockPos;)Z", "Lfunnymap/events/ClickEvent$Left;", "event", "", "onLeftClick", "(Lfunnymap/events/ClickEvent$Left;)V", "Lfunnymap/events/ClickEvent$Middle;", "onMiddleClick", "(Lfunnymap/events/ClickEvent$Middle;)V", "Lfunnymap/events/ClickEvent$Right;", "onRightClick", "(Lfunnymap/events/ClickEvent$Right;)V", "Lnet/minecraft/block/state/IBlockState;", "blockState", "setCurrentBlock", "(Lnet/minecraft/block/state/IBlockState;)V", "Lnet/minecraft/item/ItemStack;", "itemBlock", "(Lnet/minecraft/item/ItemStack;)V", "getHitBlock", "(Lnet/minecraft/util/MovingObjectPosition;)Lnet/minecraft/util/BlockPos;", "currentBlockState", "Lnet/minecraft/block/state/IBlockState;", "getCurrentBlockState", "()Lnet/minecraft/block/state/IBlockState;", "setCurrentBlockState", "enabled", "Z", "getEnabled", "()Z", "setEnabled", "(Z)V", "lastPlacePos", "Lnet/minecraft/util/BlockPos;", "getLastPlacePos", "()Lnet/minecraft/util/BlockPos;", "setLastPlacePos", "(Lnet/minecraft/util/BlockPos;)V", "<init>", "()V", "FunnyMapExtras"}
)
@SourceDebugExtension({"SMAP\nEditMode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EditMode.kt\nfunnymap/features/extras/EditMode\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,148:1\n372#2,7:149\n372#2,7:156\n372#2,7:167\n372#2,7:174\n1#3:163\n187#4,3:164\n*S KotlinDebug\n*F\n+ 1 EditMode.kt\nfunnymap/features/extras/EditMode\n*L\n82#1:149,7\n88#1:156,7\n125#1:167,7\n136#1:174,7\n102#1:164,3\n*E\n"})
public final class EditMode {
   @NotNull
   public static final EditMode INSTANCE = new EditMode();
   private static boolean enabled;
   @NotNull
   private static IBlockState currentBlockState;
   @Nullable
   private static BlockPos lastPlacePos;

   private EditMode() {
   }

   public final boolean getEnabled() {
      return enabled;
   }

   public final void setEnabled(boolean <set-?>) {
      enabled = var1;
   }

   @NotNull
   public final IBlockState getCurrentBlockState() {
      return currentBlockState;
   }

   public final void setCurrentBlockState(@NotNull IBlockState <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      currentBlockState = var1;
   }

   @Nullable
   public final BlockPos getLastPlacePos() {
      return lastPlacePos;
   }

   public final void setLastPlacePos(@Nullable BlockPos <set-?>) {
      lastPlacePos = var1;
   }

   private final MovingObjectPosition getObjectMouseOver() {
      return FreeCam.INSTANCE.getEnabled() ? FreeCam.INSTANCE.getLooking() : FunnyMap.INSTANCE.getMc().field_71476_x;
   }

   private final BlockPos getHitBlock(MovingObjectPosition $this$getHitBlock) {
      return $this$getHitBlock.field_72313_a == MovingObjectType.BLOCK ? $this$getHitBlock.func_178782_a() : null;
   }

   @SubscribeEvent
   public final void onLeftClick(@NotNull ClickEvent.Left event) {
      Intrinsics.checkNotNullParameter(event, "event");
      if (enabled) {
         MovingObjectPosition var10000 = this.getObjectMouseOver();
         if (var10000 != null) {
            BlockPos var3 = this.getHitBlock(var10000);
            if (var3 != null) {
               BlockPos blockPos = var3;
               event.setCanceled(this.handleEdit(true, blockPos));
               return;
            }
         }

      }
   }

   @SubscribeEvent
   public final void onMiddleClick(@NotNull ClickEvent.Middle event) {
      Intrinsics.checkNotNullParameter(event, "event");
      if (enabled) {
         MovingObjectPosition var10000 = this.getObjectMouseOver();
         if (var10000 != null) {
            BlockPos var4 = this.getHitBlock(var10000);
            if (var4 != null) {
               BlockPos blockPos = var4;
               IBlockState state = FunnyMap.INSTANCE.getMc().field_71441_e.func_180495_p(blockPos);
               if (Intrinsics.areEqual(state.func_177230_c(), Blocks.field_150350_a)) {
                  return;
               }

               Intrinsics.checkNotNull(state);
               this.setCurrentBlock(state);
               event.setCanceled(true);
               return;
            }
         }

      }
   }

   @SubscribeEvent
   public final void onRightClick(@NotNull ClickEvent.Right event) {
      Intrinsics.checkNotNullParameter(event, "event");
      if (enabled) {
         MovingObjectPosition var10000 = this.getObjectMouseOver();
         if (var10000 != null) {
            MovingObjectPosition movingObjectPosition = var10000;
            BlockPos var5 = this.getHitBlock(movingObjectPosition);
            if (var5 != null) {
               BlockPos blockPos = var5;
               EnumFacing var6 = movingObjectPosition.field_178784_b;
               Vec3i var7 = var6 != null ? var6.func_176730_m() : null;
               if (var7 != null) {
                  Vec3i hitVec = var7;
                  BlockPos var10003 = blockPos.func_177971_a(hitVec);
                  Intrinsics.checkNotNullExpressionValue(var10003, "add(...)");
                  event.setCanceled(this.handleEdit(false, var10003));
               }
            }
         }
      }
   }

   public final void setCurrentBlock(@NotNull ItemStack itemBlock) {
      IBlockState var4;
      label20: {
         Intrinsics.checkNotNullParameter(itemBlock, "itemBlock");
         Item var2 = itemBlock.func_77973_b();
         ItemBlock var10000 = var2 instanceof ItemBlock ? (ItemBlock)var2 : null;
         if ((var2 instanceof ItemBlock ? (ItemBlock)var2 : null) != null) {
            Block var3 = var10000.field_150939_a;
            if (var3 != null) {
               var4 = var3.func_176203_a(itemBlock.func_77960_j());
               break label20;
            }
         }

         var4 = null;
      }

      if (var4 != null) {
         currentBlockState = var4;
         Utils.INSTANCE.modMessage("Set block to: §a" + itemBlock.func_82833_r());
      }
   }

   public final void setCurrentBlock(@NotNull IBlockState blockState) {
      Intrinsics.checkNotNullParameter(blockState, "blockState");
      currentBlockState = blockState;
      Iterable var5 = (Iterable)BlockSelectGui.Companion.getBlocks();
      Iterator var6 = var5.iterator();

      Object var10000;
      while(true) {
         if (var6.hasNext()) {
            Object var7 = var6.next();
            ItemStack it = (ItemStack)var7;
            int var9 = false;
            Block var10001 = blockState.func_177230_c();
            Intrinsics.checkNotNullExpressionValue(var10001, "getBlock(...)");
            if (!BlockSelectGuiKt.matches(it, var10001, blockState.func_177230_c().func_176201_c(blockState))) {
               continue;
            }

            var10000 = var7;
            break;
         }

         var10000 = null;
         break;
      }

      String var10;
      label17: {
         ItemStack var3 = (ItemStack)var10000;
         if (var3 != null) {
            String var4 = var3.func_82833_r();
            if (var4 != null) {
               var10 = var4;
               break label17;
            }
         }

         var10 = blockState.func_177230_c().func_149732_F();
      }

      String name = var10;
      Utils.INSTANCE.modMessage("Set block to: §a" + name);
   }

   private final boolean handleEdit(boolean leftClick, BlockPos blockPos) {
      lastPlacePos = blockPos;
      int rotation = 0;
      Map blockList;
      boolean $i$f$getOrPut;
      boolean $i$f$any;
      Object var42;
      Pair var47;
      if (!Location.INSTANCE.getInDungeons()) {
         if (!Config.INSTANCE.getEnableGlobalExtras() || Location.INSTANCE.getIsland() == Location.Island.Unknown) {
            return false;
         }

         blockList = FunnyMap.INSTANCE.getExtras().getFloorsConfig();
         Object key$iv = Location.INSTANCE.getIsland().name();
         int $i$f$getOrPut = false;
         Object value$iv = blockList.get(key$iv);
         if (value$iv == null) {
            int var26 = false;
            Object answer$iv = (Map)(new LinkedHashMap());
            blockList.put(key$iv, answer$iv);
            var42 = answer$iv;
         } else {
            var42 = value$iv;
         }

         var47 = TuplesKt.to(var42, blockPos);
      } else {
         String var38;
         label125: {
            Room var10000 = ScanUtils.INSTANCE.getRoomFromPos(blockPos);
            if (var10000 != null) {
               RoomData var36 = var10000.getData();
               if (var36 != null) {
                  var38 = var36.getName();
                  break label125;
               }
            }

            var38 = null;
         }

         String currentRoomName = var38;
         if (currentRoomName == null) {
            if (Location.INSTANCE.getDungeonFloor() == -1) {
               return false;
            }

            Map $this$getOrPut$iv = FunnyMap.INSTANCE.getExtras().getFloorsConfig();
            Object key$iv = String.valueOf(Location.INSTANCE.getDungeonFloor());
            $i$f$getOrPut = false;
            Object value$iv = $this$getOrPut$iv.get(key$iv);
            if (value$iv == null) {
               $i$f$any = false;
               Object answer$iv = (Map)(new LinkedHashMap());
               $this$getOrPut$iv.put(key$iv, answer$iv);
               var42 = answer$iv;
            } else {
               var42 = value$iv;
            }

            var47 = TuplesKt.to(var42, blockPos);
         } else {
            label136: {
               Iterable var8 = (Iterable)ExtrasDungeon.INSTANCE.getRoomRotations().entrySet();
               Iterator var9 = var8.iterator();

               while(true) {
                  if (var9.hasNext()) {
                     Object var10 = var9.next();
                     Entry it = (Entry)var10;
                     int var12 = false;
                     if (!Intrinsics.areEqual(((Room)it.getKey()).getData().getName(), currentRoomName)) {
                        continue;
                     }

                     var42 = var10;
                     break;
                  }

                  var42 = null;
                  break;
               }

               Entry roomRotation = (Entry)var42;
               if (roomRotation == null) {
                  return false;
               }

               rotation = ((Number)roomRotation.getValue()).intValue();
               ExtrasData var45 = (ExtrasData)FunnyMap.INSTANCE.getExtras().getConfig().get(currentRoomName);
               if (var45 != null) {
                  Map var46 = var45.getPreBlocks();
                  if (var46 != null) {
                     RotationUtils var10001 = RotationUtils.INSTANCE;
                     BlockPos var10002 = blockPos.func_177973_b(new Vec3i(((Room)roomRotation.getKey()).getX(), 0, ((Room)roomRotation.getKey()).getZ()));
                     Intrinsics.checkNotNullExpressionValue(var10002, "subtract(...)");
                     var47 = TuplesKt.to(var46, var10001.getRotatedPos(var10002, 360 - ((Number)roomRotation.getValue()).intValue()));
                     break label136;
                  }
               }

               return false;
            }
         }
      }

      Pair var4 = var47;
      blockList = (Map)var4.component1();
      BlockPos relativePos = (BlockPos)var4.component2();
      $i$f$getOrPut = false;
      boolean $i$f$getOrPut;
      boolean var48;
      EditAction var49;
      if (leftClick) {
         $i$f$any = false;
         if (blockList.isEmpty()) {
            var48 = false;
         } else {
            Iterator var30 = blockList.entrySet().iterator();

            while(true) {
               if (!var30.hasNext()) {
                  var48 = false;
                  break;
               }

               Entry element$iv = (Entry)var30.next();
               $i$f$getOrPut = false;
               if (((Set)element$iv.getValue()).remove(relativePos)) {
                  var48 = true;
                  break;
               }
            }
         }

         var49 = var48 ? EditAction.RemoveCustomBlock : EditAction.AddGhostBlock;
      } else {
         Set var50 = (Set)blockList.get(Blocks.field_150350_a.func_176223_P());
         var49 = (var50 != null ? var50.remove(relativePos) : false) && !FunnyMap.INSTANCE.getMc().field_71439_g.func_70093_af() ? EditAction.RemoveGhostBlock : EditAction.PlaceCustomBlock;
      }

      EditAction action = var49;
      IBlockState blockState;
      switch(EditMode.WhenMappings.$EnumSwitchMapping$0[action.ordinal()]) {
      case 1:
         MovingObjectPosition var53 = INSTANCE.getObjectMouseOver();
         if (var53 == null) {
            return false;
         }

         MovingObjectPosition objectMouseOver = var53;
         BlockStateUtils var54 = BlockStateUtils.INSTANCE;
         EditMode var40 = INSTANCE;
         Block var43 = currentBlockState.func_177230_c();
         World var44 = (World)FunnyMap.INSTANCE.getMc().field_71441_e;
         BlockPos var10003 = objectMouseOver.func_178782_a();
         EnumFacing var10004 = objectMouseOver.field_178784_b;
         float var10005 = (float)(objectMouseOver.field_72307_f.field_72450_a - (double)objectMouseOver.func_178782_a().func_177958_n());
         float var10006 = (float)(objectMouseOver.field_72307_f.field_72448_b - (double)objectMouseOver.func_178782_a().func_177956_o());
         float var10007 = (float)(objectMouseOver.field_72307_f.field_72449_c - (double)objectMouseOver.func_178782_a().func_177952_p());
         EditMode var10008 = INSTANCE;
         Block var51 = currentBlockState.func_177230_c();
         EditMode var10009 = INSTANCE;
         IBlockState var34 = var43.func_180642_a(var44, var10003, var10004, var10005, var10006, var10007, var51.func_176201_c(currentBlockState), (EntityLivingBase)FunnyMap.INSTANCE.getMc().field_71439_g);
         Intrinsics.checkNotNullExpressionValue(var34, "onBlockPlaced(...)");
         blockState = var54.withRotation(var34, -rotation);
         $i$f$getOrPut = false;
         Object value$iv = blockList.get(blockState);
         if (value$iv == null) {
            int var17 = false;
            Object answer$iv = (Set)(new LinkedHashSet());
            blockList.put(blockState, answer$iv);
            var42 = answer$iv;
         } else {
            var42 = value$iv;
         }

         ((Set)var42).add(relativePos);
         FunnyMap.INSTANCE.getMc().field_71441_e.func_175656_a(blockPos, blockState);
         var48 = true;
         break;
      case 2:
         FunnyMap.INSTANCE.getMc().field_71441_e.func_175698_g(blockPos);
         var48 = true;
         break;
      case 3:
         IBlockState var52 = Blocks.field_150350_a.func_176223_P();
         Intrinsics.checkNotNullExpressionValue(var52, "getDefaultState(...)");
         blockState = var52;
         int $i$f$getOrPut = false;
         Object value$iv = blockList.get(blockState);
         if (value$iv == null) {
            int var16 = false;
            Object answer$iv = (Set)(new LinkedHashSet());
            blockList.put(blockState, answer$iv);
            var42 = answer$iv;
         } else {
            var42 = value$iv;
         }

         ((Set)var42).add(relativePos);
         FunnyMap.INSTANCE.getMc().field_71441_e.func_175698_g(blockPos);
         var48 = true;
         break;
      case 4:
         var48 = false;
         break;
      default:
         throw new NoWhenBranchMatchedException();
      }

      return var48;
   }

   static {
      IBlockState var10000 = Blocks.field_150399_cn.func_176223_P();
      Intrinsics.checkNotNullExpressionValue(var10000, "getDefaultState(...)");
      currentBlockState = var10000;
   }

   // $FF: synthetic class
   @Metadata(
      mv = {1, 9, 0},
      k = 3,
      xi = 48
   )
   public class WhenMappings {
      // $FF: synthetic field
      public static final int[] $EnumSwitchMapping$0;

      static {
         int[] var0 = new int[EditAction.values().length];

         try {
            var0[EditAction.PlaceCustomBlock.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[EditAction.RemoveCustomBlock.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[EditAction.AddGhostBlock.ordinal()] = 3;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[EditAction.RemoveGhostBlock.ordinal()] = 4;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
