package funnymap.features.dungeon;

import funnymap.FunnyMap;
import funnymap.core.DungeonPlayer;
import funnymap.core.map.Door;
import funnymap.core.map.DoorType;
import funnymap.core.map.Room;
import funnymap.core.map.RoomState;
import funnymap.core.map.RoomType;
import funnymap.core.map.Tile;
import funnymap.core.map.UniqueRoom;
import funnymap.core.map.Unknown;
import funnymap.utils.MapUtils;
import funnymap.utils.TabList;
import funnymap.utils.Utils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;
import net.minecraft.util.Vec4b;
import net.minecraft.world.storage.MapData;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001b\u0010\u000bJ1\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\u000bJ'\u0010\u0010\u001a\u00020\t2\u0018\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u00060\u0005¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u000bJ\r\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u000bR\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001c"},
   d2 = {"Lfunnymap/features/dungeon/MapUpdate;", "", "", "arrayX", "arrayY", "", "Lkotlin/Pair;", "getConnectedIndices", "(II)Ljava/util/List;", "", "getPlayers", "()V", "preloadHeads", "Lnet/minecraft/client/network/NetworkPlayerInfo;", "", "tabEntries", "updatePlayers", "(Ljava/util/List;)V", "updateRooms", "updateUniques", "", "roomAdded", "Z", "getRoomAdded", "()Z", "setRoomAdded", "(Z)V", "<init>", "FunnyMapExtras"}
)
@SourceDebugExtension({"SMAP\nMapUpdate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapUpdate.kt\nfunnymap/features/dungeon/MapUpdate\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,229:1\n1#2:230\n215#3,2:231\n288#4,2:233\n1855#4,2:235\n1855#4,2:237\n*S KotlinDebug\n*F\n+ 1 MapUpdate.kt\nfunnymap/features/dungeon/MapUpdate\n*L\n84#1:231,2\n183#1:233,2\n194#1:235,2\n217#1:237,2\n*E\n"})
public final class MapUpdate {
   @NotNull
   public static final MapUpdate INSTANCE = new MapUpdate();
   private static boolean roomAdded;

   private MapUpdate() {
   }

   public final boolean getRoomAdded() {
      return roomAdded;
   }

   public final void setRoomAdded(boolean <set-?>) {
      roomAdded = var1;
   }

   public final void preloadHeads() {
      List var10000 = TabList.INSTANCE.getDungeonTabList();
      if (var10000 != null) {
         List tabEntries = var10000;
         Integer[] var3 = new Integer[]{5, 9, 13, 17, 1};
         Iterator var2 = CollectionsKt.listOf(var3).iterator();

         while(var2.hasNext()) {
            int i = ((Number)var2.next()).intValue();
            ((NetworkPlayerInfo)((Pair)tabEntries.get(i)).getFirst()).func_178837_g();
         }

      }
   }

   public final void getPlayers() {
      List var10000 = TabList.INSTANCE.getDungeonTabList();
      if (var10000 != null) {
         List tabEntries = var10000;
         Dungeon.INSTANCE.getDungeonTeammates().clear();
         int iconNum = 0;
         Integer[] var4 = new Integer[]{5, 9, 13, 17, 1};
         Iterator var3 = CollectionsKt.listOf(var4).iterator();

         while(var3.hasNext()) {
            int i = ((Number)var3.next()).intValue();
            Pair $this$getPlayers_u24lambda_u242 = (Pair)tabEntries.get(i);
            int var6 = false;
            String var17 = StringUtils.func_76338_a((String)$this$getPlayers_u24lambda_u242.getSecond());
            Intrinsics.checkNotNullExpressionValue(var17, "stripControlCodes(...)");
            CharSequence var18 = (CharSequence)StringsKt.substringAfterLast$default(StringsKt.trim((CharSequence)var17).toString(), "] ", (String)null, 2, (Object)null);
            String[] var7 = new String[]{" "};
            String name = (String)StringsKt.split$default(var18, var7, false, 0, 6, (Object)null).get(0);
            if (!Intrinsics.areEqual(name, "")) {
               Map var16 = Dungeon.INSTANCE.getDungeonTeammates();
               ResourceLocation var10002 = ((NetworkPlayerInfo)$this$getPlayers_u24lambda_u242.getFirst()).func_178837_g();
               Intrinsics.checkNotNullExpressionValue(var10002, "getLocationSkin(...)");
               DungeonPlayer var9 = new DungeonPlayer(var10002);
               int var11 = false;
               EntityPlayer var12 = FunnyMap.INSTANCE.getMc().field_71441_e.func_72924_a(name);
               if (var12 != null) {
                  Intrinsics.checkNotNull(var12);
                  int var14 = false;
                  var9.setData(var12);
               }

               var9.setColorPrefix(StringsKt.last((CharSequence)StringsKt.substringBefore((String)$this$getPlayers_u24lambda_u242.getSecond(), name, "f")));
               var9.setName(name);
               var9.setIcon("icon-" + iconNum);
               var16.put(name, var9);
               ++iconNum;
            }
         }

      }
   }

   public final void updatePlayers(@NotNull List<? extends Pair<? extends NetworkPlayerInfo, String>> tabEntries) {
      Intrinsics.checkNotNullParameter(tabEntries, "tabEntries");
      if (!Dungeon.INSTANCE.getDungeonTeammates().isEmpty()) {
         long time = System.currentTimeMillis() - Dungeon.Info.INSTANCE.getStartTime();
         int iconNum = 0;
         Integer[] var6 = new Integer[]{5, 9, 13, 17, 1};
         Iterator var5 = CollectionsKt.listOf(var6).iterator();

         while(true) {
            String tabText;
            String name;
            boolean var15;
            DungeonPlayer var34;
            do {
               do {
                  if (!var5.hasNext()) {
                     MapData var35 = MapUtils.INSTANCE.getMapData();
                     Map var36 = var35 != null ? var35.field_76203_h : null;
                     if (var36 == null) {
                        return;
                     }

                     Map decor = var36;
                     Map $this$forEach$iv = Dungeon.INSTANCE.getDungeonTeammates();
                     int $i$f$forEach = false;
                     Iterator var24 = $this$forEach$iv.entrySet().iterator();

                     while(var24.hasNext()) {
                        Entry element$iv = (Entry)var24.next();
                        int var26 = false;
                        String name = (String)element$iv.getKey();
                        DungeonPlayer player = (DungeonPlayer)element$iv.getValue();
                        Iterable var14 = (Iterable)decor.entrySet();
                        Iterator var31 = var14.iterator();

                        Object var37;
                        while(true) {
                           if (!var31.hasNext()) {
                              var37 = null;
                              break;
                           }

                           Object var16 = var31.next();
                           Entry var17 = (Entry)var16;
                           int var18 = false;
                           String icon = (String)var17.getKey();
                           if (Intrinsics.areEqual(icon, player.getIcon())) {
                              var37 = var16;
                              break;
                           }
                        }

                        Entry var38 = (Entry)var37;
                        if ((Entry)var37 != null) {
                           Entry var30 = var38;
                           var15 = false;
                           Vec4b vec4b = (Vec4b)var30.getValue();
                           player.setPlayer(vec4b.func_176110_a() == 1);
                           MapUtils var10001 = MapUtils.INSTANCE;
                           Intrinsics.checkNotNull(vec4b);
                           player.setMapX(var10001.getMapX(vec4b));
                           player.setMapZ(MapUtils.INSTANCE.getMapZ(vec4b));
                           player.setYaw(MapUtils.INSTANCE.getYaw(vec4b));
                        }

                        if (player.isPlayer() || Intrinsics.areEqual(name, FunnyMap.INSTANCE.getMc().field_71439_g.func_70005_c_())) {
                           player.setYaw(FunnyMap.INSTANCE.getMc().field_71439_g.field_70177_z);
                           player.setMapX(MathKt.roundToInt((FunnyMap.INSTANCE.getMc().field_71439_g.field_70165_t - (double)-185 + (double)15) * MapUtils.INSTANCE.getCoordMultiplier() + ((Number)MapUtils.INSTANCE.getStartCorner().getFirst()).doubleValue()));
                           player.setMapZ(MathKt.roundToInt((FunnyMap.INSTANCE.getMc().field_71439_g.field_70161_v - (double)-185 + (double)15) * MapUtils.INSTANCE.getCoordMultiplier() + ((Number)MapUtils.INSTANCE.getStartCorner().getSecond()).doubleValue()));
                        }
                     }

                     return;
                  }

                  int i = ((Number)var5.next()).intValue();
                  String var10000 = StringUtils.func_76338_a((String)((Pair)tabEntries.get(i)).getSecond());
                  Intrinsics.checkNotNullExpressionValue(var10000, "stripControlCodes(...)");
                  tabText = StringsKt.trim((CharSequence)var10000).toString();
                  CharSequence var32 = (CharSequence)StringsKt.substringAfterLast$default(tabText, "] ", (String)null, 2, (Object)null);
                  String[] var9 = new String[]{" "};
                  name = (String)StringsKt.split$default(var32, var9, false, 0, 6, (Object)null).get(0);
               } while(Intrinsics.areEqual(name, ""));

               var34 = (DungeonPlayer)Dungeon.INSTANCE.getDungeonTeammates().get(name);
            } while(var34 == null);

            DungeonPlayer $this$updatePlayers_u24lambda_u244 = var34;
            int var12 = false;
            $this$updatePlayers_u24lambda_u244.setDead(StringsKt.contains$default((CharSequence)tabText, (CharSequence)"(DEAD)", false, 2, (Object)null));
            if ($this$updatePlayers_u24lambda_u244.getDead()) {
               $this$updatePlayers_u24lambda_u244.setIcon("");
            } else {
               $this$updatePlayers_u24lambda_u244.setIcon("icon-" + iconNum);
               ++iconNum;
            }

            if (!$this$updatePlayers_u24lambda_u244.getPlayerLoaded()) {
               EntityPlayer var13 = FunnyMap.INSTANCE.getMc().field_71441_e.func_72924_a(name);
               if (var13 != null) {
                  Intrinsics.checkNotNull(var13);
                  var15 = false;
                  $this$updatePlayers_u24lambda_u244.setData(var13);
               }
            }

            String room = $this$updatePlayers_u24lambda_u244.getCurrentRoom();
            if (!Intrinsics.areEqual(room, "Error") || time > 1000L) {
               if (Intrinsics.areEqual($this$updatePlayers_u24lambda_u244.getLastRoom(), "")) {
                  $this$updatePlayers_u24lambda_u244.setLastRoom(room);
               } else if (!Intrinsics.areEqual($this$updatePlayers_u24lambda_u244.getLastRoom(), room)) {
                  $this$updatePlayers_u24lambda_u244.getRoomVisits().add(new Pair(time - $this$updatePlayers_u24lambda_u244.getLastTime(), $this$updatePlayers_u24lambda_u244.getLastRoom()));
                  $this$updatePlayers_u24lambda_u244.setLastTime(time);
                  $this$updatePlayers_u24lambda_u244.setLastRoom(room);
               }
            }
         }
      }
   }

   public final void updateRooms() {
      if (!Dungeon.Info.INSTANCE.getEnded()) {
         DungeonMap var10000 = new DungeonMap;
         MapData var10002 = MapUtils.INSTANCE.getMapData();
         byte[] var8 = var10002 != null ? var10002.field_76198_e : null;
         if (var8 != null) {
            var10000.<init>(var8);
            DungeonMap map = var10000;
            Dungeon.INSTANCE.getEspDoors().clear();

            for(int x = 0; x < 11; ++x) {
               for(int z = 0; z < 11; ++z) {
                  Tile room = Dungeon.Info.INSTANCE.getDungeonList()[z * 11 + x];
                  Tile mapTile = map.getTile(x, z);
                  if (room instanceof Unknown) {
                     MapRenderList.INSTANCE.setRenderUpdated(true);
                     roomAdded = true;
                     Dungeon.Info.INSTANCE.getDungeonList()[z * 11 + x] = mapTile;
                  } else {
                     if (mapTile.getState().ordinal() < room.getState().ordinal()) {
                        MapRenderList.INSTANCE.setRenderUpdated(true);
                        PlayerTracker.INSTANCE.roomStateChange(room, room.getState(), mapTile.getState());
                        if (room instanceof Room && ((Room)room).getData().getType() == RoomType.BLOOD && mapTile.getState() == RoomState.GREEN) {
                           RunInformation.INSTANCE.setBloodDone(true);
                        }

                        room.setState(mapTile.getState());
                     }

                     if (mapTile instanceof Room && room instanceof Room && ((Room)room).getData().getType() != ((Room)mapTile).getData().getType() && ((Room)mapTile).getData().getType() != RoomType.NORMAL) {
                        MapRenderList.INSTANCE.setRenderUpdated(true);
                        ((Room)room).getData().setType(((Room)mapTile).getData().getType());
                     }

                     if (mapTile instanceof Door && room instanceof Door && ((Door)mapTile).getType() == DoorType.WITHER && ((Door)room).getType() != DoorType.WITHER) {
                        MapRenderList.INSTANCE.setRenderUpdated(true);
                        ((Door)room).setType(((Door)mapTile).getType());
                     }

                     if (room instanceof Door) {
                        Utils var7 = Utils.INSTANCE;
                        DoorType var10001 = ((Door)room).getType();
                        Object[] var6 = new Object[]{DoorType.ENTRANCE, DoorType.WITHER, DoorType.BLOOD};
                        if (var7.equalsOneOf(var10001, var6)) {
                           if (mapTile instanceof Door && ((Door)mapTile).getType() == DoorType.WITHER) {
                              if (((Door)room).getOpened()) {
                                 MapRenderList.INSTANCE.setRenderUpdated(true);
                                 ((Door)room).setOpened(false);
                              }
                           } else if (!((Door)room).getOpened() && FunnyMap.INSTANCE.getMc().field_71441_e.func_72964_e(room.getX() >> 4, room.getZ() >> 4).func_177410_o() && Intrinsics.areEqual(FunnyMap.INSTANCE.getMc().field_71441_e.func_180495_p(new BlockPos(room.getX(), 69, room.getZ())).func_177230_c(), Blocks.field_150350_a)) {
                              MapRenderList.INSTANCE.setRenderUpdated(true);
                              ((Door)room).setOpened(true);
                           }

                           if (!((Door)room).getOpened()) {
                              Dungeon.INSTANCE.getEspDoors().add(room);
                           }
                        }
                     }
                  }
               }
            }

            if (roomAdded) {
               this.updateUniques();
            }

         }
      }
   }

   public final void updateUniques() {
      boolean[] visited = new boolean[121];

      for(int x = 0; x < 11; ++x) {
         for(int z = 0; z < 11; ++z) {
            int index = z * 11 + x;
            if (!visited[index]) {
               visited[index] = true;
               Tile room = Dungeon.Info.INSTANCE.getDungeonList()[index];
               if (room instanceof Room) {
                  List connected = this.getConnectedIndices(x, z);
                  UniqueRoom unique = ((Room)room).getUniqueRoom();
                  Iterable $this$forEach$iv;
                  boolean $i$f$forEach;
                  Iterator var11;
                  Object element$iv;
                  Pair it;
                  boolean var14;
                  UniqueRoom var20;
                  if (unique == null || StringsKt.startsWith$default(unique.getName(), "Unknown", false, 2, (Object)null)) {
                     $this$forEach$iv = (Iterable)connected;
                     $i$f$forEach = false;
                     var11 = $this$forEach$iv.iterator();

                     Object var23;
                     label88: {
                        while(var11.hasNext()) {
                           boolean var22;
                           label84: {
                              element$iv = var11.next();
                              it = (Pair)element$iv;
                              var14 = false;
                              Tile var15 = Dungeon.Info.INSTANCE.getDungeonList()[((Number)it.getSecond()).intValue() * 11 + ((Number)it.getFirst()).intValue()];
                              Room var10000 = var15 instanceof Room ? (Room)var15 : null;
                              if ((var15 instanceof Room ? (Room)var15 : null) != null) {
                                 var20 = var10000.getUniqueRoom();
                                 if (var20 != null) {
                                    String var21 = var20.getName();
                                    if (var21 != null) {
                                       var22 = !StringsKt.startsWith$default(var21, "Unknown", false, 2, (Object)null);
                                       break label84;
                                    }
                                 }
                              }

                              var22 = false;
                           }

                           if (var22) {
                              var23 = element$iv;
                              break label88;
                           }
                        }

                        var23 = null;
                     }

                     label73: {
                        Pair var8 = (Pair)var23;
                        if (var8 != null) {
                           int var18 = false;
                           Tile var19 = Dungeon.Info.INSTANCE.getDungeonList()[((Number)var8.getSecond()).intValue() * 11 + ((Number)var8.getFirst()).intValue()];
                           UniqueRoom var17 = (var19 instanceof Room ? (Room)var19 : null) != null ? (var19 instanceof Room ? (Room)var19 : null).getUniqueRoom() : null;
                           if (var17 != null) {
                              var20 = var17;
                              break label73;
                           }
                        }

                        var20 = unique;
                     }

                     unique = var20;
                  }

                  var20 = unique;
                  if (unique == null) {
                     var20 = new UniqueRoom(x, z, (Room)room);
                  }

                  UniqueRoom finalUnique = var20;
                  finalUnique.addTiles((Iterable)connected);
                  $this$forEach$iv = (Iterable)connected;
                  $i$f$forEach = false;

                  for(var11 = $this$forEach$iv.iterator(); var11.hasNext(); visited[((Number)it.getSecond()).intValue() * 11 + ((Number)it.getFirst()).intValue()] = true) {
                     element$iv = var11.next();
                     it = (Pair)element$iv;
                     var14 = false;
                  }
               }
            }
         }
      }

      roomAdded = false;
   }

   private final List<Pair<Integer, Integer>> getConnectedIndices(int arrayX, int arrayY) {
      Tile tile = Dungeon.Info.INSTANCE.getDungeonList()[arrayY * 11 + arrayX];
      if (!(tile instanceof Room)) {
         return CollectionsKt.emptyList();
      } else {
         Pair[] var5 = new Pair[]{new Pair(0, 1), new Pair(1, 0), new Pair(0, -1), new Pair(-1, 0)};
         List directions = CollectionsKt.listOf(var5);
         List connected = (List)(new ArrayList());
         Pair[] var7 = new Pair[]{new Pair(arrayX, arrayY)};
         List queue = CollectionsKt.mutableListOf(var7);

         while(true) {
            Pair current;
            do {
               if (((Collection)queue).isEmpty()) {
                  return connected;
               }

               current = (Pair)CollectionsKt.removeFirst(queue);
            } while(connected.contains(current));

            connected.add(current);
            Iterable $this$forEach$iv = (Iterable)directions;
            int $i$f$forEach = false;
            Iterator var10 = $this$forEach$iv.iterator();

            while(var10.hasNext()) {
               Object element$iv = var10.next();
               Pair it = (Pair)element$iv;
               int var13 = false;
               int x = ((Number)current.getFirst()).intValue() + ((Number)it.getFirst()).intValue();
               int y = ((Number)current.getSecond()).intValue() + ((Number)it.getSecond()).intValue();
               if ((0 <= x ? x < 11 : false) && (0 <= y ? y < 11 : false) && Dungeon.Info.INSTANCE.getDungeonList()[y * 11 + x] instanceof Room) {
                  queue.add(new Pair(x, y));
               }
            }
         }
      }
   }
}
