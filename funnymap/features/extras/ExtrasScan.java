package funnymap.features.extras;

import funnymap.FunnyMap;
import funnymap.core.ExtrasData;
import funnymap.core.RoomData;
import funnymap.core.map.Room;
import funnymap.core.map.Tile;
import funnymap.features.dungeon.Dungeon;
import funnymap.features.dungeon.ScanUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.GroupingKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000e\u001a\u00020\b*\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0011"},
   d2 = {"Lfunnymap/features/extras/ExtrasScan;", "", "", "extrasScan", "()V", "Lfunnymap/core/map/Room;", "room", "Lkotlin/Pair;", "", "getUniqueCore", "(Lfunnymap/core/map/Room;)Lkotlin/Pair;", "Lfunnymap/core/ExtrasData;", "x", "z", "getRoomRotations", "(Lfunnymap/core/ExtrasData;II)I", "<init>", "FunnyMapExtras"}
)
@SourceDebugExtension({"SMAP\nExtrasScan.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExtrasScan.kt\nfunnymap/features/extras/ExtrasScan\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,47:1\n13309#2:48\n13310#2:60\n1747#3,3:49\n1549#3:61\n1620#3,3:62\n1536#3:65\n766#3:66\n857#3,2:67\n2333#3,14:69\n1855#3,2:83\n372#4,3:52\n375#4,4:56\n1#5:55\n*S KotlinDebug\n*F\n+ 1 ExtrasScan.kt\nfunnymap/features/extras/ExtrasScan\n*L\n12#1:48\n12#1:60\n14#1:49,3\n24#1:61\n24#1:62,3\n28#1:65\n29#1:66\n29#1:67,2\n30#1:69,14\n38#1:83,2\n15#1:52,3\n15#1:56,4\n*E\n"})
public final class ExtrasScan {
   @NotNull
   public static final ExtrasScan INSTANCE = new ExtrasScan();

   private ExtrasScan() {
   }

   public final void extrasScan() {
      Object[] $this$forEach$iv = Dungeon.Info.INSTANCE.getDungeonList();
      int $i$f$forEach = false;
      int var3 = 0;

      for(int var4 = $this$forEach$iv.length; var3 < var4; ++var3) {
         Object element$iv = $this$forEach$iv[var3];
         Tile room = element$iv;
         int var7 = false;
         if (element$iv instanceof Room && !ExtrasDungeon.INSTANCE.getRoomRotations().containsKey(element$iv)) {
            Iterable $this$any$iv = (Iterable)ScanUtils.INSTANCE.getRoomList();
            int $i$f$any = false;
            boolean var10000;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
               var10000 = false;
            } else {
               label65: {
                  Iterator var10 = $this$any$iv.iterator();

                  while(var10.hasNext()) {
                     Object element$iv = var10.next();
                     RoomData it = (RoomData)element$iv;
                     int var13 = false;
                     if (((Number)it.getCores().get(0)).intValue() == ((Room)room).getCore()) {
                        var10000 = true;
                        break label65;
                     }
                  }

                  var10000 = false;
               }
            }

            if (var10000) {
               Map var18 = ExtrasDungeon.INSTANCE.getRoomRotations();
               ExtrasScan var25 = INSTANCE;
               Map $this$getOrPut$iv = FunnyMap.INSTANCE.getExtras().getConfig();
               Object key$iv = ((Room)room).getData().getName();
               int $i$f$getOrPut = false;
               Object value$iv = $this$getOrPut$iv.get(key$iv);
               Object var26;
               if (value$iv == null) {
                  ExtrasScan var14 = var25;
                  int var15 = false;
                  Pair it = INSTANCE.getUniqueCore((Room)room);
                  int var17 = false;
                  ExtrasData var10001 = new ExtrasData(((Room)room).getCore(), ((Number)it.getFirst()).intValue(), ((Number)it.getSecond()).intValue(), (Map)null, 8, (DefaultConstructorMarker)null);
                  var25 = var14;
                  Object answer$iv = var10001;
                  $this$getOrPut$iv.put(key$iv, answer$iv);
                  var26 = answer$iv;
               } else {
                  var26 = value$iv;
               }

               Integer var20 = var25.getRoomRotations((ExtrasData)var26, room.getX(), room.getZ());
               var18.put(room, var20);
            }
         }
      }

   }

   private final Pair<Integer, Integer> getUniqueCore(Room room) {
      for(int i = 1; i < 8; ++i) {
         Pair[] var4 = new Pair[]{TuplesKt.to(0, -i), TuplesKt.to(i, 0), TuplesKt.to(0, i), TuplesKt.to(-i, 0)};
         Iterable $this$map$iv = (Iterable)CollectionsKt.listOf(var4);
         int $i$f$map = false;
         Collection destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10)));
         int $i$f$mapTo = false;
         Iterator var9 = $this$map$iv.iterator();

         while(var9.hasNext()) {
            Object item$iv$iv = var9.next();
            Pair var11 = (Pair)item$iv$iv;
            int var12 = false;
            int x = ((Number)var11.component1()).intValue();
            int z = ((Number)var11.component2()).intValue();
            destination$iv$iv.add(ScanUtils.INSTANCE.getCore(room.getX() + x, room.getZ() + z));
         }

         List cores = (List)destination$iv$iv;
         Iterable $this$minByOrNull$iv = (Iterable)cores;
         int $i$f$minByOrNull = false;
         $this$minByOrNull$iv = (Iterable)GroupingKt.eachCount((Grouping)(new ExtrasScan$getUniqueCore$$inlined$groupingBy$1($this$minByOrNull$iv))).entrySet();
         $i$f$minByOrNull = false;
         Collection destination$iv$iv = (Collection)(new ArrayList());
         int $i$f$filterTo = false;
         Iterator var25 = $this$minByOrNull$iv.iterator();

         while(var25.hasNext()) {
            Object element$iv$iv = var25.next();
            Entry it = (Entry)element$iv$iv;
            int var33 = false;
            if (((Number)it.getValue()).intValue() == 1) {
               destination$iv$iv.add(element$iv$iv);
            }
         }

         $this$minByOrNull$iv = (Iterable)((List)destination$iv$iv);
         $i$f$minByOrNull = false;
         Iterator iterator$iv = $this$minByOrNull$iv.iterator();
         Object var10000;
         if (!iterator$iv.hasNext()) {
            var10000 = null;
         } else {
            Object minElem$iv = iterator$iv.next();
            if (!iterator$iv.hasNext()) {
               var10000 = minElem$iv;
            } else {
               Entry it = (Entry)minElem$iv;
               int var26 = false;
               int minValue$iv = ((Number)it.getKey()).intValue();

               while(true) {
                  Object e$iv = iterator$iv.next();
                  Entry it = (Entry)e$iv;
                  int var32 = false;
                  int v$iv = ((Number)it.getKey()).intValue();
                  if (minValue$iv > v$iv) {
                     minElem$iv = e$iv;
                     minValue$iv = v$iv;
                  }

                  if (!iterator$iv.hasNext()) {
                     var10000 = minElem$iv;
                     break;
                  }
               }
            }
         }

         Entry var34 = (Entry)var10000;
         if ((Entry)var10000 != null) {
            int minCore = ((Number)var34.getKey()).intValue();
            return new Pair(minCore, i);
         }
      }

      return new Pair(ScanUtils.INSTANCE.getCore(room.getX(), room.getZ() - 2), 2);
   }

   private final int getRoomRotations(ExtrasData $this$getRoomRotations, int x, int z) {
      Pair[] var4 = new Pair[]{TuplesKt.to(0, -$this$getRoomRotations.getCoreDistance()), TuplesKt.to($this$getRoomRotations.getCoreDistance(), 0), TuplesKt.to(0, $this$getRoomRotations.getCoreDistance()), TuplesKt.to(-$this$getRoomRotations.getCoreDistance(), 0)};
      Iterable $this$forEach$iv = CollectionsKt.withIndex((Iterable)CollectionsKt.listOf(var4));
      int $i$f$forEach = false;
      Iterator var6 = $this$forEach$iv.iterator();

      int index;
      Pair pair;
      do {
         if (!var6.hasNext()) {
            System.out.println("No matching rotation core found.");
            return 0;
         }

         Object element$iv = var6.next();
         IndexedValue var8 = (IndexedValue)element$iv;
         int var9 = false;
         index = var8.component1();
         pair = (Pair)var8.component2();
      } while(ScanUtils.INSTANCE.getCore(x + ((Number)pair.getFirst()).intValue(), z + ((Number)pair.getSecond()).intValue()) != $this$getRoomRotations.getRotationCore());

      return index * 90;
   }
}
