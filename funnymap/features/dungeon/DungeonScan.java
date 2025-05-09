package funnymap.features.dungeon;

import funnymap.FunnyMap;
import funnymap.config.Config;
import funnymap.core.RoomData;
import funnymap.core.map.Door;
import funnymap.core.map.DoorType;
import funnymap.core.map.Room;
import funnymap.core.map.RoomType;
import funnymap.core.map.Tile;
import funnymap.core.map.UniqueRoom;
import funnymap.core.map.Unknown;
import funnymap.features.extras.ExtrasDungeon;
import funnymap.features.extras.ExtrasScan;
import funnymap.utils.Location;
import funnymap.utils.Utils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001f\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J1\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001c\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0011R\u0014\u0010\u001d\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001a¨\u0006 "},
   d2 = {"Lfunnymap/features/dungeon/DungeonScan;", "", "", "scan", "()V", "", "x", "z", "row", "column", "Lfunnymap/core/map/Tile;", "scanRoom", "(IIII)Lfunnymap/core/map/Tile;", "", "hasScanned", "Z", "getHasScanned", "()Z", "setHasScanned", "(Z)V", "isScanning", "setScanning", "", "lastScanTime", "J", "roomSize", "I", "getShouldScan", "shouldScan", "startX", "startZ", "<init>", "FunnyMapExtras"}
)
@SourceDebugExtension({"SMAP\nDungeonScan.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DungeonScan.kt\nfunnymap/features/dungeon/DungeonScan\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,180:1\n2624#2,3:181\n3792#3:184\n4307#3,2:185\n1#4:187\n*S KotlinDebug\n*F\n+ 1 DungeonScan.kt\nfunnymap/features/dungeon/DungeonScan\n*L\n67#1:181,3\n111#1:184\n111#1:185,2\n*E\n"})
public final class DungeonScan {
   @NotNull
   public static final DungeonScan INSTANCE = new DungeonScan();
   public static final int roomSize = 32;
   public static final int startX = -185;
   public static final int startZ = -185;
   private static long lastScanTime;
   private static boolean isScanning;
   private static boolean hasScanned;

   private DungeonScan() {
   }

   public final boolean isScanning() {
      return isScanning;
   }

   public final void setScanning(boolean <set-?>) {
      isScanning = var1;
   }

   public final boolean getHasScanned() {
      return hasScanned;
   }

   public final void setHasScanned(boolean <set-?>) {
      hasScanned = var1;
   }

   public final boolean getShouldScan() {
      return Config.INSTANCE.getAutoScan() && !isScanning && !hasScanned && System.currentTimeMillis() - lastScanTime >= 250L && Location.INSTANCE.getDungeonFloor() != -1;
   }

   public final void scan() {
      isScanning = true;
      boolean allChunksLoaded = true;

      int z;
      int minSecrets;
      for(int x = 0; x < 11; ++x) {
         for(z = 0; z < 11; ++z) {
            minSecrets = -185 + x * 16;
            int zPos = -185 + z * 16;
            if (!FunnyMap.INSTANCE.getMc().field_71441_e.func_72964_e(minSecrets >> 4, zPos >> 4).func_177410_o()) {
               allChunksLoaded = false;
            } else {
               boolean var33;
               label141: {
                  Tile $this$scan_u24lambda_u240 = Dungeon.Info.INSTANCE.getDungeonList()[x + z * 11];
                  int var8 = false;
                  if (!($this$scan_u24lambda_u240 instanceof Unknown)) {
                     String var32;
                     label137: {
                        Room var10000 = $this$scan_u24lambda_u240 instanceof Room ? (Room)$this$scan_u24lambda_u240 : null;
                        if (($this$scan_u24lambda_u240 instanceof Room ? (Room)$this$scan_u24lambda_u240 : null) != null) {
                           RoomData var31 = var10000.getData();
                           if (var31 != null) {
                              var32 = var31.getName();
                              break label137;
                           }
                        }

                        var32 = null;
                     }

                     if (!Intrinsics.areEqual(var32, "Unknown")) {
                        var33 = true;
                        break label141;
                     }
                  }

                  var33 = false;
               }

               if (!var33) {
                  Tile var34 = this.scanRoom(minSecrets, zPos, z, x);
                  if (var34 != null) {
                     Tile it = var34;
                     int var9 = false;
                     Tile prev = Dungeon.Info.INSTANCE.getDungeonList()[z * 11 + x];
                     if (it instanceof Room) {
                        if (((prev instanceof Room ? (Room)prev : null) != null ? (prev instanceof Room ? (Room)prev : null).getUniqueRoom() : null) != null) {
                           UniqueRoom var35 = ((Room)prev).getUniqueRoom();
                           if (var35 != null) {
                              var35.addTile(x, z, (Room)it);
                           }
                        } else {
                           Iterable $this$none$iv = (Iterable)Dungeon.Info.INSTANCE.getUniqueRooms();
                           int $i$f$none = false;
                           if ($this$none$iv instanceof Collection && ((Collection)$this$none$iv).isEmpty()) {
                              var33 = true;
                           } else {
                              Iterator var13 = $this$none$iv.iterator();

                              while(true) {
                                 if (!var13.hasNext()) {
                                    var33 = true;
                                    break;
                                 }

                                 Object element$iv = var13.next();
                                 UniqueRoom unique = (UniqueRoom)element$iv;
                                 int var16 = false;
                                 if (Intrinsics.areEqual(unique.getName(), ((Room)it).getData().getName())) {
                                    var33 = false;
                                    break;
                                 }
                              }
                           }

                           if (var33) {
                              new UniqueRoom(x, z, (Room)it);
                           }
                        }

                        MapUpdate.INSTANCE.setRoomAdded(true);
                     }

                     Dungeon.Info.INSTANCE.getDungeonList()[z * 11 + x] = it;
                     MapRenderList.INSTANCE.setRenderUpdated(true);
                  }
               }
            }
         }

         if (FunnyMap.INSTANCE.getExtras().getEnabled()) {
            ExtrasScan.INSTANCE.extrasScan();
            ExtrasDungeon.INSTANCE.updateAllBlocks();
         }
      }

      if (MapUpdate.INSTANCE.getRoomAdded()) {
         MapUpdate.INSTANCE.updateUniques();
      }

      if (allChunksLoaded) {
         if (Config.INSTANCE.getScanChatInfo()) {
            float maxSecrets = (float)Math.ceil((double)((float)Dungeon.Info.INSTANCE.getSecretCount() * ScoreCalculation.INSTANCE.getSecretPercent()));
            z = 5;
            Utils var36 = Utils.INSTANCE;
            Integer var10001 = Location.INSTANCE.getDungeonFloor();
            Object[] var20 = new Object[]{6, 7};
            if (var36.equalsOneOf(var10001, var20)) {
               z += 2;
            }

            if (ScoreCalculation.INSTANCE.getPaul()) {
               z += 10;
            }

            minSecrets = (int)((float)Math.ceil((double)(maxSecrets * (float)(40 - z) / (float)40)));
            String[] var6 = new String[]{"&aScan Finished!", "&aPuzzles (&c" + Dungeon.Info.INSTANCE.getPuzzles().size() + "&a):", CollectionsKt.joinToString$default((Iterable)Dungeon.Info.INSTANCE.getPuzzles().entrySet(), (CharSequence)"\n&b- &d", (CharSequence)"&b- &d", (CharSequence)null, 0, (CharSequence)null, (Function1)null.INSTANCE, 28, (Object)null), "&6Trap: &a" + Dungeon.Info.INSTANCE.getTrapType(), "&8Wither Doors: &7" + (Dungeon.Info.INSTANCE.getWitherDoors() - 1), "&7Total Crypts: &6" + Dungeon.Info.INSTANCE.getCryptCount(), "&7Total Secrets: &b" + Dungeon.Info.INSTANCE.getSecretCount(), "&7Minimum Secrets: &e" + minSecrets};
            List lines = CollectionsKt.mutableListOf(var6);
            Utils.INSTANCE.modMessage(CollectionsKt.joinToString$default((Iterable)lines, (CharSequence)"\n", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null, 62, (Object)null));
         }

         Dungeon.Info var37 = Dungeon.Info.INSTANCE;
         Object[] $this$filter$iv = Dungeon.Info.INSTANCE.getDungeonList();
         Dungeon.Info var17 = var37;
         int $i$f$filter = false;
         Tile[] $this$filterTo$iv$iv = $this$filter$iv;
         Collection destination$iv$iv = (Collection)(new ArrayList());
         int $i$f$filterTo = false;
         int var26 = 0;

         for(int var28 = $this$filter$iv.length; var26 < var28; ++var26) {
            Object element$iv$iv = $this$filterTo$iv$iv[var26];
            int var30 = false;
            if (element$iv$iv instanceof Room && !((Room)element$iv$iv).isSeparator()) {
               destination$iv$iv.add(element$iv$iv);
            }
         }

         var17.setRoomCount(((List)destination$iv$iv).size());
         hasScanned = true;
      }

      lastScanTime = System.currentTimeMillis();
      isScanning = false;
   }

   private final Tile scanRoom(int x, int z, int row, int column) {
      int height = FunnyMap.INSTANCE.getMc().field_71441_e.func_72964_e(x >> 4, z >> 4).func_76611_b(x & 15, z & 15);
      if (height == 0) {
         return null;
      } else {
         boolean rowEven = (row & 1) == 0;
         boolean columnEven = (column & 1) == 0;
         Tile var21;
         Room var22;
         if (rowEven && columnEven) {
            int roomCore = ScanUtils.INSTANCE.getCore(x, z);
            var22 = new Room;
            RoomData var23 = ScanUtils.INSTANCE.getRoomData(roomCore);
            if (var23 == null) {
               return null;
            }

            var22.<init>(x, z, var23);
            Room var17 = var22;
            int var19 = false;
            var17.setCore(roomCore);
            var21 = (Tile)var17;
         } else {
            Room var11;
            boolean var13;
            Tile it;
            boolean var18;
            if (!rowEven && !columnEven) {
               it = Dungeon.Info.INSTANCE.getDungeonList()[column - 1 + (row - 1) * 11];
               var18 = false;
               if (it instanceof Room) {
                  var11 = new Room(x, z, ((Room)it).getData());
                  var13 = false;
                  var11.setSeparator(true);
                  var22 = var11;
               } else {
                  var22 = null;
               }

               var21 = (Tile)var22;
            } else {
               Utils var10000 = Utils.INSTANCE;
               Integer var10001 = height;
               Object[] var8 = new Object[]{74, 82};
               if (var10000.equalsOneOf(var10001, var8)) {
                  Door var20 = new Door;
                  Block var14 = FunnyMap.INSTANCE.getMc().field_71441_e.func_180495_p(new BlockPos(x, 69, z)).func_177230_c();
                  DoorType var10004;
                  if (Intrinsics.areEqual(var14, Blocks.field_150402_ci)) {
                     Dungeon.Info var9 = Dungeon.Info.INSTANCE;
                     int var10 = var9.getWitherDoors();
                     var9.setWitherDoors(var10 + 1);
                     var10004 = DoorType.WITHER;
                  } else {
                     var10004 = Intrinsics.areEqual(var14, Blocks.field_150418_aU) ? DoorType.ENTRANCE : (Intrinsics.areEqual(var14, Blocks.field_150406_ce) ? DoorType.BLOOD : DoorType.NORMAL);
                  }

                  var20.<init>(x, z, var10004);
                  var21 = (Tile)var20;
               } else {
                  it = Dungeon.Info.INSTANCE.getDungeonList()[rowEven ? row * 11 + column - 1 : (row - 1) * 11 + column];
                  var18 = false;
                  if (!(it instanceof Room)) {
                     var21 = null;
                  } else if (((Room)it).getData().getType() == RoomType.ENTRANCE) {
                     var21 = (Tile)(new Door(x, z, DoorType.ENTRANCE));
                  } else {
                     var11 = new Room(x, z, ((Room)it).getData());
                     var13 = false;
                     var11.setSeparator(true);
                     var21 = (Tile)var11;
                  }
               }
            }
         }

         return var21;
      }
   }
}
