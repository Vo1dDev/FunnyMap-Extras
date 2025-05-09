package funnymap.utils;

import funnymap.FunnyMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.S34PacketMaps;
import net.minecraft.util.Vec4b;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bA\u0010BJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00068\u0006X\u0086D¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0017\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010$R$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010,\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0012\u001a\u0004\b-\u0010\u0004\"\u0004\b.\u0010\u0015R\"\u0010/\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0017\u001a\u0004\b0\u0010\u0019\"\u0004\b1\u0010$R.\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u0010\b\"\u0004\b5\u00106R\u0015\u0010:\u001a\u00020\u0006*\u0002078F¢\u0006\u0006\u001a\u0004\b8\u00109R\u0015\u0010<\u001a\u00020\u0006*\u0002078F¢\u0006\u0006\u001a\u0004\b;\u00109R\u0015\u0010@\u001a\u00020=*\u0002078F¢\u0006\u0006\u001a\u0004\b>\u0010?¨\u0006C"},
   d2 = {"Lfunnymap/utils/MapUtils;", "", "", "calibrateMap", "()Z", "Lkotlin/Pair;", "", "findEntranceCorner", "()Lkotlin/Pair;", "Lnet/minecraft/item/ItemStack;", "getMapItem", "()Lnet/minecraft/item/ItemStack;", "Lnet/minecraft/network/play/server/S34PacketMaps;", "packet", "", "updateMapData", "(Lnet/minecraft/network/play/server/S34PacketMaps;)V", "calibrated", "Z", "getCalibrated", "setCalibrated", "(Z)V", "connectorSize", "I", "getConnectorSize", "()I", "", "coordMultiplier", "D", "getCoordMultiplier", "()D", "setCoordMultiplier", "(D)V", "halfRoomSize", "getHalfRoomSize", "setHalfRoomSize", "(I)V", "Lnet/minecraft/world/storage/MapData;", "mapData", "Lnet/minecraft/world/storage/MapData;", "getMapData", "()Lnet/minecraft/world/storage/MapData;", "setMapData", "(Lnet/minecraft/world/storage/MapData;)V", "mapDataUpdated", "getMapDataUpdated", "setMapDataUpdated", "roomSize", "getRoomSize", "setRoomSize", "startCorner", "Lkotlin/Pair;", "getStartCorner", "setStartCorner", "(Lkotlin/Pair;)V", "Lnet/minecraft/util/Vec4b;", "getMapX", "(Lnet/minecraft/util/Vec4b;)I", "mapX", "getMapZ", "mapZ", "", "getYaw", "(Lnet/minecraft/util/Vec4b;)F", "yaw", "<init>", "()V", "FunnyMapExtras"}
)
@SourceDebugExtension({"SMAP\nMapUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapUtils.kt\nfunnymap/utils/MapUtils\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,97:1\n13384#2,3:98\n*S KotlinDebug\n*F\n+ 1 MapUtils.kt\nfunnymap/utils/MapUtils\n*L\n83#1:98,3\n*E\n"})
public final class MapUtils {
   @NotNull
   public static final MapUtils INSTANCE = new MapUtils();
   @Nullable
   private static MapData mapData;
   @NotNull
   private static Pair<Integer, Integer> startCorner = new Pair(5, 5);
   private static double coordMultiplier = 0.625D;
   private static int roomSize = 16;
   private static int halfRoomSize;
   private static final int connectorSize;
   private static boolean calibrated;
   private static boolean mapDataUpdated;

   private MapUtils() {
   }

   public final int getMapX(@NotNull Vec4b $this$mapX) {
      Intrinsics.checkNotNullParameter($this$mapX, "<this>");
      return $this$mapX.func_176112_b() + 128 >> 1;
   }

   public final int getMapZ(@NotNull Vec4b $this$mapZ) {
      Intrinsics.checkNotNullParameter($this$mapZ, "<this>");
      return $this$mapZ.func_176113_c() + 128 >> 1;
   }

   public final float getYaw(@NotNull Vec4b $this$yaw) {
      Intrinsics.checkNotNullParameter($this$yaw, "<this>");
      return (float)$this$yaw.func_176111_d() * 22.5F;
   }

   @Nullable
   public final MapData getMapData() {
      return mapData;
   }

   public final void setMapData(@Nullable MapData <set-?>) {
      mapData = var1;
   }

   @NotNull
   public final Pair<Integer, Integer> getStartCorner() {
      return startCorner;
   }

   public final void setStartCorner(@NotNull Pair<Integer, Integer> <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      startCorner = var1;
   }

   public final double getCoordMultiplier() {
      return coordMultiplier;
   }

   public final void setCoordMultiplier(double <set-?>) {
      coordMultiplier = var1;
   }

   public final int getRoomSize() {
      return roomSize;
   }

   public final void setRoomSize(int <set-?>) {
      roomSize = var1;
   }

   public final int getHalfRoomSize() {
      return halfRoomSize;
   }

   public final void setHalfRoomSize(int <set-?>) {
      halfRoomSize = var1;
   }

   public final int getConnectorSize() {
      return connectorSize;
   }

   public final boolean getCalibrated() {
      return calibrated;
   }

   public final void setCalibrated(boolean <set-?>) {
      calibrated = var1;
   }

   public final boolean getMapDataUpdated() {
      return mapDataUpdated;
   }

   public final void setMapDataUpdated(boolean <set-?>) {
      mapDataUpdated = var1;
   }

   private final ItemStack getMapItem() {
      ItemStack var3;
      label22: {
         EntityPlayerSP var10000 = FunnyMap.INSTANCE.getMc().field_71439_g;
         if (var10000 != null) {
            InventoryPlayer var2 = var10000.field_71071_by;
            if (var2 != null) {
               var3 = var2.func_70301_a(8);
               break label22;
            }
         }

         var3 = null;
      }

      if (var3 == null) {
         return null;
      } else {
         ItemStack map = var3;
         if (map.func_77973_b() instanceof ItemMap) {
            String var4 = map.func_82833_r();
            Intrinsics.checkNotNullExpressionValue(var4, "getDisplayName(...)");
            if (StringsKt.contains$default((CharSequence)var4, (CharSequence)"Magical Map", false, 2, (Object)null)) {
               return map;
            }
         }

         return null;
      }
   }

   public final void updateMapData(@NotNull S34PacketMaps packet) {
      Intrinsics.checkNotNullParameter(packet, "packet");
      if (Location.INSTANCE.getInDungeons()) {
         Utils.INSTANCE.runMinecraftThread((Function0)(new Function0<Unit>() {
            public final void invoke() {
               ItemStack map = MapUtils.INSTANCE.getMapItem();
               if (map != null) {
                  MapUtils var10000 = MapUtils.INSTANCE;
                  Item var10001 = map.func_77973_b();
                  Intrinsics.checkNotNull(var10001, "null cannot be cast to non-null type net.minecraft.item.ItemMap");
                  var10000.setMapData(((ItemMap)var10001).func_77873_a(map, (World)FunnyMap.INSTANCE.getMc().field_71441_e));
               }

               if (MapUtils.INSTANCE.getMapData() == null) {
                  MapUtils.INSTANCE.setMapData(new MapData("map_" + packet.func_149188_c()));
               }

               packet.func_179734_a(MapUtils.INSTANCE.getMapData());
               MapUtils.INSTANCE.setMapDataUpdated(true);
            }
         }));
      }
   }

   public final boolean calibrateMap() {
      Pair var1 = this.findEntranceCorner();
      int start = ((Number)var1.component1()).intValue();
      int size = ((Number)var1.component2()).intValue();
      Utils var10000 = Utils.INSTANCE;
      Integer var10001 = size;
      Object[] var4 = new Object[]{16, 18};
      if (var10000.equalsOneOf(var10001, var4)) {
         roomSize = size;
         halfRoomSize = roomSize / 2;
         Pair var7;
         switch(Location.INSTANCE.getDungeonFloor()) {
         case 0:
            var7 = new Pair(22, 22);
            break;
         case 1:
            var7 = new Pair(22, 11);
            break;
         case 2:
         case 3:
            var7 = new Pair(11, 11);
            break;
         default:
            int startX = start & 127;
            int startZ = start >> 7;
            var7 = new Pair(startX % (roomSize + 4), startZ % (roomSize + 4));
         }

         startCorner = var7;
         coordMultiplier = (double)(roomSize + connectorSize) / (double)32;
         return true;
      } else {
         return false;
      }
   }

   private final Pair<Integer, Integer> findEntranceCorner() {
      int start = 0;
      int currLength = 0;
      MapData var10000 = mapData;
      if (var10000 != null) {
         byte[] var12 = var10000.field_76198_e;
         if (var12 != null) {
            byte[] $this$forEachIndexed$iv = var12;
            int $i$f$forEachIndexed = false;
            int index$iv = 0;
            int var6 = 0;

            for(int var7 = $this$forEachIndexed$iv.length; var6 < var7; ++var6) {
               byte item$iv = $this$forEachIndexed$iv[var6];
               int index = index$iv++;
               int var11 = false;
               if (item$iv == 30) {
                  if (currLength == 0) {
                     start = index;
                  }

                  ++currLength;
               } else {
                  if (currLength >= 16) {
                     return new Pair(start, currLength);
                  }

                  currLength = 0;
               }
            }
         }
      }

      return new Pair(start, currLength);
   }

   static {
      MapUtils var10000 = INSTANCE;
      halfRoomSize = roomSize / 2;
      connectorSize = 4;
   }
}
