package funnymap.core.map;

import funnymap.config.Config;
import funnymap.features.dungeon.Dungeon;
import funnymap.features.dungeon.MapRender;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0005¢\u0006\u0004\b7\u0010\tJ%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ'\u0010\r\u001a\u00020\u00072\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\tJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0013J%\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\tR\"\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\u00058F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R5\u0010\f\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000b0\u000b0/8\u0006¢\u0006\f\n\u0004\b\f\u00100\u001a\u0004\b1\u00102R.\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010\u001a\u001a\u0004\b4\u0010\u0013\"\u0004\b5\u00106¨\u00068"},
   d2 = {"Lfunnymap/core/map/UniqueRoom;", "", "", "x", "y", "Lfunnymap/core/map/Room;", "tile", "", "addTile", "(IILfunnymap/core/map/Room;)V", "", "Lkotlin/Pair;", "tiles", "addTiles", "(Ljava/lang/Iterable;)V", "addToTiles", "calculateCenter", "()V", "getCheckmarkPosition", "()Lkotlin/Pair;", "getNamePosition", "arrX", "arrY", "room", "init", "center", "Lkotlin/Pair;", "", "hasMimic", "Z", "getHasMimic", "()Z", "setHasMimic", "(Z)V", "mainRoom", "Lfunnymap/core/map/Room;", "getMainRoom", "()Lfunnymap/core/map/Room;", "setMainRoom", "(Lfunnymap/core/map/Room;)V", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "", "Ljava/util/List;", "getTiles", "()Ljava/util/List;", "topLeft", "getTopLeft", "setTopLeft", "(Lkotlin/Pair;)V", "<init>", "FunnyMapExtras"}
)
@SourceDebugExtension({"SMAP\nUniqueRoom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UniqueRoom.kt\nfunnymap/core/map/UniqueRoom\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,120:1\n1#2:121\n1#2:134\n1855#3,2:122\n1603#3,9:124\n1855#3:133\n1856#3:135\n1612#3:136\n1477#3:137\n1502#3,3:138\n1505#3,3:148\n1054#3:151\n1477#3:152\n1502#3,3:153\n1505#3,3:163\n1054#3:166\n372#4,7:141\n372#4,7:156\n*S KotlinDebug\n*F\n+ 1 UniqueRoom.kt\nfunnymap/core/map/UniqueRoom\n*L\n92#1:134\n51#1:122,2\n92#1:124,9\n92#1:133\n92#1:135\n92#1:136\n100#1:137\n100#1:138,3\n100#1:148,3\n100#1:151\n101#1:152\n101#1:153,3\n101#1:163,3\n101#1:166\n100#1:141,7\n101#1:156,7\n*E\n"})
public final class UniqueRoom {
   @NotNull
   private String name;
   @NotNull
   private Pair<Integer, Integer> topLeft;
   @NotNull
   private Pair<Integer, Integer> center;
   @NotNull
   private Room mainRoom;
   @NotNull
   private final List<Pair<Room, Pair<Integer, Integer>>> tiles;
   private boolean hasMimic;

   public UniqueRoom(int arrX, int arrY, @NotNull Room room) {
      Intrinsics.checkNotNullParameter(room, "room");
      super();
      this.topLeft = new Pair(arrX, arrY);
      this.center = new Pair(arrX, arrY);
      this.mainRoom = room;
      Pair[] var4 = new Pair[]{TuplesKt.to(room, new Pair(arrX, arrY))};
      this.tiles = CollectionsKt.mutableListOf(var4);
      if (Intrinsics.areEqual(room.getData().getName(), "Unknown")) {
         this.name = "Unknown_" + arrX + '_' + arrY;
      } else {
         this.name = room.getData().getName();
         this.init(arrX, arrY, room);
      }

      room.setUniqueRoom(this);
      Dungeon.Info.INSTANCE.getUniqueRooms().add(this);
   }

   @NotNull
   public final String getName() {
      return this.name;
   }

   public final void setName(@NotNull String <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.name = var1;
   }

   @NotNull
   public final Pair<Integer, Integer> getTopLeft() {
      return this.topLeft;
   }

   public final void setTopLeft(@NotNull Pair<Integer, Integer> <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.topLeft = var1;
   }

   @NotNull
   public final Room getMainRoom() {
      Tile var1 = Dungeon.Info.INSTANCE.getDungeonList()[((Number)this.topLeft.getSecond()).intValue() * 11 + ((Number)this.topLeft.getFirst()).intValue()];
      Room var10000 = var1 instanceof Room ? (Room)var1 : null;
      if ((var1 instanceof Room ? (Room)var1 : null) == null) {
         var10000 = this.mainRoom;
      }

      return var10000;
   }

   public final void setMainRoom(@NotNull Room <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.mainRoom = var1;
   }

   @NotNull
   public final List<Pair<Room, Pair<Integer, Integer>>> getTiles() {
      return this.tiles;
   }

   public final boolean getHasMimic() {
      return this.hasMimic;
   }

   public final void setHasMimic(boolean <set-?>) {
      this.hasMimic = var1;
   }

   public final void init(int arrX, int arrY, @NotNull Room room) {
      Intrinsics.checkNotNullParameter(room, "room");
      Dungeon.Info var4 = Dungeon.Info.INSTANCE;
      var4.setCryptCount(var4.getCryptCount() + room.getData().getCrypts());
      var4 = Dungeon.Info.INSTANCE;
      var4.setSecretCount(var4.getSecretCount() + room.getData().getSecrets());
      switch(UniqueRoom.WhenMappings.$EnumSwitchMapping$0[room.getData().getType().ordinal()]) {
      case 1:
         MapRender.INSTANCE.setDynamicRotation(arrY == 0 ? 180.0F : (arrX == 0 ? -90.0F : (arrX > arrY ? 90.0F : 0.0F)));
         break;
      case 2:
         Dungeon.Info var9 = Dungeon.Info.INSTANCE;
         CharSequence var10001 = (CharSequence)room.getData().getName();
         String[] var5 = new String[]{" "};
         var9.setTrapType((String)StringsKt.split$default(var10001, var5, false, 0, 6, (Object)null).get(0));
         break;
      case 3:
         Puzzle var10000 = Puzzle.Companion.fromName(room.getData().getName());
         if (var10000 != null) {
            Puzzle it = var10000;
            int var7 = false;
            Boolean var8 = (Boolean)Dungeon.Info.INSTANCE.getPuzzles().putIfAbsent(it, false);
         }
      }

   }

   public final void addTile(int x, int y, @NotNull Room tile) {
      Intrinsics.checkNotNullParameter(tile, "tile");
      this.addToTiles(x, y, tile);
      this.calculateCenter();
   }

   public final void addTiles(@NotNull Iterable<Pair<Integer, Integer>> tiles) {
      Intrinsics.checkNotNullParameter(tiles, "tiles");
      int $i$f$forEach = false;
      Iterator var4 = tiles.iterator();

      while(var4.hasNext()) {
         Object element$iv = var4.next();
         Pair var6 = (Pair)element$iv;
         int var7 = false;
         int x = ((Number)var6.component1()).intValue();
         int y = ((Number)var6.component2()).intValue();
         Tile var10 = Dungeon.Info.INSTANCE.getDungeonList()[y * 11 + x];
         Room var10000 = var10 instanceof Room ? (Room)var10 : null;
         if ((var10 instanceof Room ? (Room)var10 : null) != null) {
            Room room = var10000;
            if (room.getUniqueRoom() != this) {
               Collection var12 = (Collection)Dungeon.Info.INSTANCE.getUniqueRooms();
               UniqueRoom var13 = room.getUniqueRoom();
               TypeIntrinsics.asMutableCollection(var12).remove(var13);
               this.addToTiles(x, y, room);
            }
         }
      }

      this.calculateCenter();
   }

   private final void addToTiles(int x, int y, Room tile) {
      if (Intrinsics.areEqual(this.getMainRoom().getData().getName(), "Unknown")) {
         if (!Intrinsics.areEqual(tile.getData().getName(), "Unknown")) {
            this.init(x, y, tile);
            this.name = tile.getData().getName();
            this.getMainRoom().setData(tile.getData());
         }
      } else if (Intrinsics.areEqual(tile.getData().getName(), "Unknown")) {
         tile.setData(this.getMainRoom().getData());
      }

      tile.setUniqueRoom(this);
      this.tiles.removeIf(UniqueRoom::addToTiles$lambda$2);
      this.tiles.add(TuplesKt.to(tile, new Pair(x, y)));
      if (x < ((Number)this.topLeft.getFirst()).intValue() || x == ((Number)this.topLeft.getFirst()).intValue() && y < ((Number)this.topLeft.getSecond()).intValue()) {
         this.topLeft = new Pair(x, y);
         this.mainRoom = tile;
         if (StringsKt.startsWith$default(this.name, "Unknown", false, 2, (Object)null)) {
            this.name = "Unknown_" + x + '_' + y;
         }
      }

   }

   private final void calculateCenter() {
      if (this.tiles.size() == 1) {
         this.center = (Pair)((Pair)CollectionsKt.first(this.tiles)).getSecond();
      } else {
         Iterable $this$mapNotNull$iv = (Iterable)this.tiles;
         int $i$f$mapNotNull = false;
         Collection destination$iv$iv = (Collection)(new ArrayList());
         int $i$f$mapNotNullTo = false;
         int $i$f$groupByTo = false;
         Iterator var9 = $this$mapNotNull$iv.iterator();

         Object element$iv$iv;
         boolean var12;
         boolean $i$f$getOrPut;
         Object value$iv$iv$iv;
         boolean var17;
         while(var9.hasNext()) {
            element$iv$iv = var9.next();
            var12 = false;
            Pair it = (Pair)element$iv$iv;
            $i$f$getOrPut = false;
            value$iv$iv$iv = it.getSecond();
            Pair var16 = (Pair)value$iv$iv$iv;
            var17 = false;
            int arrX = ((Number)var16.component1()).intValue();
            int arrZ = ((Number)var16.component2()).intValue();
            Pair var10000 = (Pair)(arrX % 2 == 0 && arrZ % 2 == 0 ? value$iv$iv$iv : null);
            if ((Pair)(arrX % 2 == 0 && arrZ % 2 == 0 ? value$iv$iv$iv : null) != null) {
               Object it$iv$iv = var10000;
               int var21 = false;
               destination$iv$iv.add(it$iv$iv);
            }
         }

         List positions = (List)destination$iv$iv;
         if (!positions.isEmpty()) {
            Iterable $this$sortedByDescending$iv = (Iterable)positions;
            int $i$f$sortedByDescending = false;
            Map destination$iv$iv = (Map)(new LinkedHashMap());
            int $i$f$groupByTo = false;
            Iterator var36 = $this$sortedByDescending$iv.iterator();

            Object var47;
            while(var36.hasNext()) {
               Object element$iv$iv = var36.next();
               Pair it = (Pair)element$iv$iv;
               int var11 = false;
               Object key$iv$iv = ((Number)it.getFirst()).intValue();
               $i$f$getOrPut = false;
               value$iv$iv$iv = destination$iv$iv.get(key$iv$iv);
               if (value$iv$iv$iv == null) {
                  int var48 = false;
                  Object answer$iv$iv$iv = (List)(new ArrayList());
                  destination$iv$iv.put(key$iv$iv, answer$iv$iv$iv);
                  var47 = answer$iv$iv$iv;
               } else {
                  var47 = value$iv$iv$iv;
               }

               List list$iv$iv = (List)var47;
               list$iv$iv.add(element$iv$iv);
            }

            $this$sortedByDescending$iv = (Iterable)destination$iv$iv.entrySet();
            $i$f$sortedByDescending = false;
            List xRooms = CollectionsKt.sortedWith($this$sortedByDescending$iv, (Comparator)(new UniqueRoom$calculateCenter$$inlined$sortedByDescending$1()));
            Iterable $this$sortedByDescending$iv = (Iterable)positions;
            int $i$f$sortedByDescending = false;
            Map destination$iv$iv = (Map)(new LinkedHashMap());
            $i$f$groupByTo = false;
            var9 = $this$sortedByDescending$iv.iterator();

            while(var9.hasNext()) {
               element$iv$iv = var9.next();
               Pair it = (Pair)element$iv$iv;
               var12 = false;
               Object key$iv$iv = ((Number)it.getSecond()).intValue();
               int $i$f$getOrPut = false;
               Object value$iv$iv$iv = destination$iv$iv.get(key$iv$iv);
               if (value$iv$iv$iv == null) {
                  var17 = false;
                  Object answer$iv$iv$iv = (List)(new ArrayList());
                  destination$iv$iv.put(key$iv$iv, answer$iv$iv$iv);
                  var47 = answer$iv$iv$iv;
               } else {
                  var47 = value$iv$iv$iv;
               }

               List list$iv$iv = (List)var47;
               list$iv$iv.add(element$iv$iv);
            }

            $this$sortedByDescending$iv = (Iterable)destination$iv$iv.entrySet();
            $i$f$sortedByDescending = false;
            List zRooms = CollectionsKt.sortedWith($this$sortedByDescending$iv, (Comparator)(new UniqueRoom$calculateCenter$$inlined$sortedByDescending$2()));
            UniqueRoom var53 = this;
            Pair var10001;
            int var31;
            Iterator var33;
            Object var35;
            Entry it;
            boolean var39;
            if (zRooms.size() != 1 && ((List)((Entry)zRooms.get(0)).getValue()).size() == ((List)((Entry)zRooms.get(1)).getValue()).size()) {
               if (xRooms.size() != 1 && ((List)((Entry)xRooms.get(0)).getValue()).size() == ((List)((Entry)xRooms.get(1)).getValue()).size()) {
                  var10001 = TuplesKt.to((((Number)((Entry)xRooms.get(0)).getKey()).intValue() + ((Number)((Entry)xRooms.get(1)).getKey()).intValue()) / 2, (((Number)((Entry)zRooms.get(0)).getKey()).intValue() + ((Number)((Entry)zRooms.get(1)).getKey()).intValue()) / 2);
               } else {
                  Object var51 = ((Entry)xRooms.get(0)).getKey();
                  $this$sortedByDescending$iv = (Iterable)zRooms;
                  Object var23 = var51;
                  var31 = 0;

                  int var25;
                  for(var33 = $this$sortedByDescending$iv.iterator(); var33.hasNext(); var31 += var25) {
                     var35 = var33.next();
                     it = (Entry)var35;
                     var39 = false;
                     var25 = ((Number)it.getKey()).intValue();
                  }

                  var53 = this;
                  var10001 = TuplesKt.to(var23, var31 / zRooms.size());
               }
            } else {
               $this$sortedByDescending$iv = (Iterable)xRooms;
               var31 = 0;

               int var24;
               for(var33 = $this$sortedByDescending$iv.iterator(); var33.hasNext(); var31 += var24) {
                  var35 = var33.next();
                  it = (Entry)var35;
                  var39 = false;
                  var24 = ((Number)it.getKey()).intValue();
               }

               var53 = this;
               var10001 = TuplesKt.to(var31 / xRooms.size(), ((Entry)zRooms.get(0)).getKey());
            }

            var53.center = var10001;
         }
      }
   }

   @NotNull
   public final Pair<Integer, Integer> getNamePosition() {
      return Config.INSTANCE.getMapCenterRoomName() ? this.center : this.topLeft;
   }

   @NotNull
   public final Pair<Integer, Integer> getCheckmarkPosition() {
      return Config.INSTANCE.getMapCenterCheckmark() ? this.center : this.topLeft;
   }

   private static final boolean addToTiles$lambda$2(Function1 $tmp0, Object p0) {
      Intrinsics.checkNotNullParameter($tmp0, "$tmp0");
      return (Boolean)$tmp0.invoke(p0);
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
            var0[RoomType.ENTRANCE.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[RoomType.TRAP.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[RoomType.PUZZLE.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
