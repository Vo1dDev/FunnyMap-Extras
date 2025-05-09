package funnymap.features.extras;

import funnymap.FunnyMap;
import funnymap.config.Config;
import funnymap.core.ExtrasData;
import funnymap.core.RoomData;
import funnymap.core.map.Room;
import funnymap.features.dungeon.ScanUtils;
import funnymap.utils.Location;
import funnymap.utils.Utils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import net.minecraft.block.state.IBlockState;
import net.minecraft.network.play.server.S23PacketBlockChange;
import net.minecraft.util.BlockPos;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\"\u0010\rJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\rJ\r\u0010\u0014\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\rJ\u0015\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000f¢\u0006\u0004\b\u0016\u0010\u0012R2\u0010\u001b\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u001a0\u00180\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR#\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u00178\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010!¨\u0006#"},
   d2 = {"Lfunnymap/features/extras/ExtrasDungeon;", "", "Lnet/minecraft/network/play/server/S23PacketBlockChange;", "packet", "", "handleSetBlock", "(Lnet/minecraft/network/play/server/S23PacketBlockChange;)Z", "Lnet/minecraft/util/BlockPos;", "pos", "isCustomBlock", "(Lnet/minecraft/util/BlockPos;)Z", "", "reset", "()V", "setBlocks", "", "name", "setIslandBlock", "(Ljava/lang/String;)V", "setIslandBlocks", "updateAllBlocks", "roomName", "updateBlocks", "", "", "Lnet/minecraft/block/state/IBlockState;", "", "extraBlocks", "Ljava/util/Map;", "Lfunnymap/core/map/Room;", "", "roomRotations", "getRoomRotations", "()Ljava/util/Map;", "<init>", "FunnyMapExtras"}
)
@SourceDebugExtension({"SMAP\nExtrasDungeon.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExtrasDungeon.kt\nfunnymap/features/extras/ExtrasDungeon\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,95:1\n215#2:96\n216#2:99\n215#2:100\n216#2:103\n1855#3,2:97\n1855#3,2:101\n1179#3,2:105\n1253#3,2:107\n1549#3:109\n1620#3,3:110\n1256#3:113\n1747#3,3:114\n1747#3,3:117\n1#4:104\n*S KotlinDebug\n*F\n+ 1 ExtrasDungeon.kt\nfunnymap/features/extras/ExtrasDungeon\n*L\n26#1:96\n26#1:99\n39#1:100\n39#1:103\n27#1:97,2\n40#1:101,2\n61#1:105,2\n61#1:107,2\n62#1:109\n62#1:110,3\n61#1:113\n82#1:114,3\n87#1:117,3\n*E\n"})
public final class ExtrasDungeon {
   @NotNull
   public static final ExtrasDungeon INSTANCE = new ExtrasDungeon();
   @NotNull
   private static final Map<Room, Integer> roomRotations = (Map)(new LinkedHashMap());
   @NotNull
   private static final Map<String, Map<IBlockState, Set<BlockPos>>> extraBlocks = (Map)(new LinkedHashMap());

   private ExtrasDungeon() {
   }

   @NotNull
   public final Map<Room, Integer> getRoomRotations() {
      return roomRotations;
   }

   public final void setBlocks() {
      String var18;
      label42: {
         ScanUtils var10000 = ScanUtils.INSTANCE;
         BlockPos var10001 = FunnyMap.INSTANCE.getMc().field_71439_g.func_180425_c();
         Intrinsics.checkNotNullExpressionValue(var10001, "getPosition(...)");
         Room var16 = var10000.getRoomFromPos(var10001);
         if (var16 != null) {
            RoomData var17 = var16.getData();
            if (var17 != null) {
               var18 = var17.getName();
               break label42;
            }
         }

         var18 = null;
      }

      String room = var18;
      if (room == null) {
         this.setIslandBlock(String.valueOf(Location.INSTANCE.getDungeonFloor()));
      } else {
         if (EditMode.INSTANCE.getEnabled()) {
            this.updateBlocks(room);
         }

         Map var19 = (Map)extraBlocks.get(room);
         if (var19 != null) {
            Map $this$forEach$iv = var19;
            int $i$f$forEach = false;
            Iterator var4 = $this$forEach$iv.entrySet().iterator();

            while(var4.hasNext()) {
               Entry element$iv = (Entry)var4.next();
               int var7 = false;
               IBlockState blockState = (IBlockState)element$iv.getKey();
               Set blocks = (Set)element$iv.getValue();
               Iterable $this$forEach$iv = (Iterable)blocks;
               int $i$f$forEach = false;
               Iterator var12 = $this$forEach$iv.iterator();

               while(var12.hasNext()) {
                  Object element$iv = var12.next();
                  BlockPos blockPos = (BlockPos)element$iv;
                  int var15 = false;
                  FunnyMap.INSTANCE.getMc().field_71441_e.func_175656_a(blockPos, blockState);
               }
            }
         }
      }

   }

   public final void setIslandBlocks() {
      if (Location.INSTANCE.getIsland() != Location.Island.Unknown) {
         this.setIslandBlock(Location.INSTANCE.getIsland().toString());
      }

   }

   private final void setIslandBlock(String name) {
      Map var10000 = (Map)FunnyMap.INSTANCE.getExtras().getFloorsConfig().get(name);
      if (var10000 != null) {
         Map $this$forEach$iv = var10000;
         int $i$f$forEach = false;
         Iterator var4 = $this$forEach$iv.entrySet().iterator();

         while(var4.hasNext()) {
            Entry element$iv = (Entry)var4.next();
            int var7 = false;
            IBlockState blockState = (IBlockState)element$iv.getKey();
            Set blocks = (Set)element$iv.getValue();
            Iterable $this$forEach$iv = (Iterable)blocks;
            int $i$f$forEach = false;
            Iterator var12 = $this$forEach$iv.iterator();

            while(var12.hasNext()) {
               Object element$iv = var12.next();
               BlockPos blockPos = (BlockPos)element$iv;
               int var15 = false;
               FunnyMap.INSTANCE.getMc().field_71441_e.func_175656_a(blockPos, blockState);
            }
         }
      }

   }

   public final void updateAllBlocks() {
      Utils.INSTANCE.runMinecraftThread((Function0)null.INSTANCE);
   }

   public final void updateBlocks(@NotNull String roomName) {
      Intrinsics.checkNotNullParameter(roomName, "roomName");
      Iterable var2 = (Iterable)roomRotations.entrySet();
      Iterator var3 = var2.iterator();

      Object var10000;
      while(true) {
         if (var3.hasNext()) {
            Object var4 = var3.next();
            Entry it = (Entry)var4;
            int var6 = false;
            if (!Intrinsics.areEqual(((Room)it.getKey()).getData().getName(), roomName)) {
               continue;
            }

            var10000 = var4;
            break;
         }

         var10000 = null;
         break;
      }

      Entry var38 = (Entry)var10000;
      if (var38 != null) {
         Entry var33 = var38;
         int var34 = false;
         Room room = (Room)var33.getKey();
         int rotation = ((Number)var33.getValue()).intValue();
         ExtrasData var39 = (ExtrasData)FunnyMap.INSTANCE.getExtras().getConfig().get(room.getData().getName());
         if (var39 != null) {
            ExtrasData $this$updateBlocks_u24lambda_u248_u24lambda_u247 = var39;
            int var7 = false;
            Map var8 = extraBlocks;
            Iterable $this$associate$iv = (Iterable)$this$updateBlocks_u24lambda_u248_u24lambda_u247.getPreBlocks().entrySet();
            int $i$f$associate = false;
            int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
            Map destination$iv$iv = (Map)(new LinkedHashMap(capacity$iv));
            int $i$f$associateTo = false;
            Iterator var15 = $this$associate$iv.iterator();

            while(var15.hasNext()) {
               Object element$iv$iv = var15.next();
               Entry var18 = (Entry)element$iv$iv;
               int var19 = false;
               IBlockState blockState = (IBlockState)var18.getKey();
               Set blocks = (Set)var18.getValue();
               IBlockState var40 = BlockStateUtils.INSTANCE.withRotation(blockState, rotation);
               Iterable $this$map$iv = (Iterable)blocks;
               IBlockState var23 = var40;
               int $i$f$map = false;
               Collection destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10)));
               int $i$f$mapTo = false;
               Iterator var28 = $this$map$iv.iterator();

               while(var28.hasNext()) {
                  Object item$iv$iv = var28.next();
                  BlockPos blockPos = (BlockPos)item$iv$iv;
                  int var32 = false;
                  destination$iv$iv.add(RotationUtils.INSTANCE.getRotatedPos(blockPos, rotation).func_177982_a(room.getX(), 0, room.getZ()));
               }

               Pair var41 = TuplesKt.to(var23, CollectionsKt.toSet((Iterable)((List)destination$iv$iv)));
               destination$iv$iv.put(var41.getFirst(), var41.getSecond());
            }

            var8.put(roomName, destination$iv$iv);
         }
      }

   }

   public final boolean handleSetBlock(@NotNull S23PacketBlockChange packet) {
      Intrinsics.checkNotNullParameter(packet, "packet");
      if (Config.INSTANCE.getPreventBlockReset() && FunnyMap.INSTANCE.getExtras().getEnabled()) {
         BlockPos var10001 = packet.func_179827_b();
         Intrinsics.checkNotNullExpressionValue(var10001, "getBlockPosition(...)");
         if (this.isCustomBlock(var10001)) {
            return true;
         }
      }

      return false;
   }

   private final boolean isCustomBlock(BlockPos pos) {
      String var17;
      label89: {
         Room var10000 = ScanUtils.INSTANCE.getRoomFromPos(pos);
         if (var10000 != null) {
            RoomData var16 = var10000.getData();
            if (var16 != null) {
               var17 = var16.getName();
               break label89;
            }
         }

         var17 = null;
      }

      String room = var17;
      Map var18;
      Set var19;
      boolean var20;
      if (room != null) {
         var18 = (Map)extraBlocks.get(room);
         if (var18 != null) {
            var19 = var18.entrySet();
            if (var19 != null) {
               Iterable $this$any$iv = (Iterable)var19;
               int $i$f$any = false;
               if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                  var20 = false;
               } else {
                  Iterator var12 = $this$any$iv.iterator();

                  while(true) {
                     if (!var12.hasNext()) {
                        var20 = false;
                        break;
                     }

                     Object element$iv = var12.next();
                     Entry it = (Entry)element$iv;
                     int var15 = false;
                     if (((Set)it.getValue()).contains(pos)) {
                        var20 = true;
                        break;
                     }
                  }
               }

               var20 = var20;
               return var20;
            }
         }

         var20 = false;
         return var20;
      } else {
         if (Location.INSTANCE.getInDungeons()) {
            if (Location.INSTANCE.getDungeonFloor() == -1) {
               return false;
            }

            var17 = String.valueOf(Location.INSTANCE.getDungeonFloor());
         } else {
            if (Location.INSTANCE.getIsland() == Location.Island.Unknown) {
               return false;
            }

            var17 = Location.INSTANCE.getIsland().toString();
         }

         String location = var17;
         var18 = (Map)FunnyMap.INSTANCE.getExtras().getFloorsConfig().get(location);
         if (var18 != null) {
            var19 = var18.entrySet();
            if (var19 != null) {
               Iterable $this$any$iv = (Iterable)var19;
               int $i$f$any = false;
               if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                  var20 = false;
               } else {
                  Iterator var7 = $this$any$iv.iterator();

                  while(true) {
                     if (!var7.hasNext()) {
                        var20 = false;
                        break;
                     }

                     Object element$iv = var7.next();
                     Entry it = (Entry)element$iv;
                     int var10 = false;
                     if (((Set)it.getValue()).contains(pos)) {
                        var20 = true;
                        break;
                     }
                  }
               }

               var20 = var20;
               return var20;
            }
         }

         var20 = false;
         return var20;
      }
   }

   public final void reset() {
      roomRotations.clear();
      extraBlocks.clear();
   }
}
