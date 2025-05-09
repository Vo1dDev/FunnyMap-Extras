package funnymap.features.dungeon;

import funnymap.core.RoomData;
import funnymap.core.map.Door;
import funnymap.core.map.DoorType;
import funnymap.core.map.Room;
import funnymap.core.map.RoomState;
import funnymap.core.map.RoomType;
import funnymap.core.map.Tile;
import funnymap.core.map.Unknown;
import funnymap.utils.MapUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011¨\u0006\u0016"},
   d2 = {"Lfunnymap/features/dungeon/DungeonMap;", "", "", "arrayX", "arrayY", "Lfunnymap/core/map/Tile;", "getTile", "(II)Lfunnymap/core/map/Tile;", "worldX", "worldZ", "scanTile", "(IIII)Lfunnymap/core/map/Tile;", "", "cacheTiles", "[Lfunnymap/core/map/Tile;", "", "centerColors", "[B", "sideColors", "mapColors", "<init>", "([B)V", "FunnyMapExtras"}
)
public final class DungeonMap {
   @NotNull
   private byte[] centerColors;
   @NotNull
   private byte[] sideColors;
   @NotNull
   private final Tile[] cacheTiles;

   public DungeonMap(@NotNull byte[] mapColors) {
      Intrinsics.checkNotNullParameter(mapColors, "mapColors");
      super();
      this.centerColors = new byte[121];
      this.sideColors = new byte[121];
      int halfRoom = 0;

      Tile[] var3;
      for(var3 = new Tile[121]; halfRoom < 121; ++halfRoom) {
         var3[halfRoom] = null;
      }

      this.cacheTiles = var3;
      halfRoom = MapUtils.INSTANCE.getRoomSize() / 2;
      int halfTile = halfRoom + 2;
      int startX = ((Number)MapUtils.INSTANCE.getStartCorner().getFirst()).intValue() + halfRoom;
      int startY = ((Number)MapUtils.INSTANCE.getStartCorner().getSecond()).intValue() + halfRoom;

      for(int y = 0; y < 11; ++y) {
         for(int x = 0; x < 11; ++x) {
            int mapX = startX + x * halfTile;
            int mapY = startY + y * halfTile;
            if (mapX < 128 && mapY < 128) {
               this.centerColors[y * 11 + x] = mapColors[mapY * 128 + mapX];
               int var10000;
               if (x % 2 == 0 && y % 2 == 0) {
                  int topX = mapX - halfRoom;
                  int topY = mapY - halfRoom;
                  var10000 = topY * 128 + topX;
               } else {
                  boolean horizontal = y % 2 == 1;
                  var10000 = horizontal ? mapY * 128 + mapX - 4 : (mapY - 4) * 128 + mapX;
               }

               int sideIndex = var10000;
               this.sideColors[y * 11 + x] = mapColors[sideIndex];
            }
         }
      }

   }

   @NotNull
   public final Tile getTile(int arrayX, int arrayY) {
      int index = arrayY * 11 + arrayX;
      if (!(0 <= index ? index < this.cacheTiles.length : false)) {
         return (Tile)(new Unknown(0, 0));
      } else {
         if (this.cacheTiles[index] == null) {
            int xPos = -185 + arrayX * 16;
            int zPos = -185 + arrayY * 16;
            this.cacheTiles[index] = this.scanTile(arrayX, arrayY, xPos, zPos);
         }

         Tile var10000 = this.cacheTiles[index];
         if (var10000 == null) {
            var10000 = (Tile)(new Unknown(0, 0));
         }

         return var10000;
      }
   }

   private final Tile scanTile(int arrayX, int arrayY, int worldX, int worldZ) {
      int centerColor = this.centerColors[arrayY * 11 + arrayX];
      int sideColor = this.sideColors[arrayY * 11 + arrayX];
      if (centerColor == 0) {
         return (Tile)(new Unknown(worldX, worldZ));
      } else {
         boolean var10;
         RoomType type;
         Room var12;
         Tile var13;
         RoomType var14;
         if (arrayX % 2 == 0 && arrayY % 2 == 0) {
            var14 = RoomType.Companion.fromMapColor(sideColor);
            if (var14 == null) {
               return (Tile)(new Unknown(worldX, worldZ));
            }

            RoomState var10001;
            type = var14;
            var12 = new Room(worldX, worldZ, RoomData.Companion.createUnknown(type));
            var10 = false;
            label42:
            switch(centerColor) {
            case 18:
               switch(DungeonMap.WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
               case 1:
                  var10001 = RoomState.DISCOVERED;
                  break label42;
               case 2:
                  var10001 = RoomState.FAILED;
                  break label42;
               default:
                  var10001 = var12.getState();
                  break label42;
               }
            case 30:
               var10001 = DungeonMap.WhenMappings.$EnumSwitchMapping$0[type.ordinal()] == 3 ? RoomState.DISCOVERED : RoomState.GREEN;
               break;
            case 34:
               var10001 = RoomState.CLEARED;
               break;
            case 85:
            case 119:
               var10001 = RoomState.UNOPENED;
               break;
            default:
               var10001 = RoomState.DISCOVERED;
            }

            var12.setState(var10001);
            var13 = (Tile)var12;
         } else if (sideColor == 0) {
            DoorType var10000 = DoorType.Companion.fromMapColor(centerColor);
            if (var10000 == null) {
               return (Tile)(new Unknown(worldX, worldZ));
            }

            DoorType type = var10000;
            Door var8 = new Door(worldX, worldZ, type);
            var10 = false;
            var8.setState(centerColor == 85 ? RoomState.UNOPENED : RoomState.DISCOVERED);
            var13 = (Tile)var8;
         } else {
            var14 = RoomType.Companion.fromMapColor(sideColor);
            if (var14 == null) {
               return (Tile)(new Unknown(worldX, worldZ));
            }

            type = var14;
            var12 = new Room(worldX, worldZ, RoomData.Companion.createUnknown(type));
            var10 = false;
            var12.setState(RoomState.DISCOVERED);
            var12.setSeparator(true);
            var13 = (Tile)var12;
         }

         return var13;
      }
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
         int[] var0 = new int[RoomType.values().length];

         try {
            var0[RoomType.BLOOD.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[RoomType.PUZZLE.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[RoomType.ENTRANCE.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
