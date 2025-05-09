package funnymap.features.dungeon;

import funnymap.FunnyMap;
import funnymap.config.Config;
import funnymap.core.DungeonPlayer;
import funnymap.core.map.Door;
import funnymap.core.map.Puzzle;
import funnymap.core.map.Tile;
import funnymap.core.map.UniqueRoom;
import funnymap.core.map.Unknown;
import funnymap.events.ChatEvent;
import funnymap.features.extras.ExtrasDungeon;
import funnymap.utils.Location;
import funnymap.utils.MapUtils;
import funnymap.utils.TabList;
import funnymap.utils.Utils;
import gg.essential.universal.UChat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.ClickEvent.Action;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.storage.MapData;
import net.minecraftforge.event.world.WorldEvent.Unload;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\"B\t\b\u0002¢\u0006\u0004\b!\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR#\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00108\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001aR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001a¨\u0006#"},
   d2 = {"Lfunnymap/features/dungeon/Dungeon;", "", "Lfunnymap/events/ChatEvent;", "event", "", "onChatPacket", "(Lfunnymap/events/ChatEvent;)V", "onTick", "()V", "Lnet/minecraftforge/event/world/WorldEvent$Unload;", "onWorldLoad", "(Lnet/minecraftforge/event/world/WorldEvent$Unload;)V", "reset", "", "shouldSearchMimic", "()Z", "", "", "Lfunnymap/core/DungeonPlayer;", "dungeonTeammates", "Ljava/util/Map;", "getDungeonTeammates", "()Ljava/util/Map;", "", "Lfunnymap/core/map/Door;", "espDoors", "Ljava/util/List;", "getEspDoors", "()Ljava/util/List;", "", "Lkotlin/text/Regex;", "keyGainRegex", "keyUseRegex", "<init>", "Info", "FunnyMapExtras"}
)
@SourceDebugExtension({"SMAP\nDungeon.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Dungeon.kt\nfunnymap/features/dungeon/Dungeon\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,166:1\n1747#2,3:167\n1747#2,3:170\n1747#2,3:173\n*S KotlinDebug\n*F\n+ 1 Dungeon.kt\nfunnymap/features/dungeon/Dungeon\n*L\n84#1:167,3\n95#1:170,3\n99#1:173,3\n*E\n"})
public final class Dungeon {
   @NotNull
   public static final Dungeon INSTANCE = new Dungeon();
   @NotNull
   private static final Map<String, DungeonPlayer> dungeonTeammates = (Map)(new LinkedHashMap());
   @NotNull
   private static final List<Door> espDoors = (List)(new ArrayList());
   @NotNull
   private static final List<Regex> keyGainRegex;
   @NotNull
   private static final List<Regex> keyUseRegex;

   private Dungeon() {
   }

   @NotNull
   public final Map<String, DungeonPlayer> getDungeonTeammates() {
      return dungeonTeammates;
   }

   @NotNull
   public final List<Door> getEspDoors() {
      return espDoors;
   }

   public final void onTick() {
      if (Location.INSTANCE.getInSkyblock()) {
         if (!Location.INSTANCE.getInDungeons()) {
            if (FunnyMap.INSTANCE.getExtras().getEnabled() && Config.INSTANCE.getEnableGlobalExtras()) {
               ExtrasDungeon.INSTANCE.setIslandBlocks();
            }

         } else {
            boolean var3;
            if (this.shouldSearchMimic()) {
               String var10000 = MimicDetector.INSTANCE.findMimic();
               if (var10000 != null) {
                  String it = var10000;
                  var3 = false;
                  if (Config.INSTANCE.getScanChatInfo()) {
                     UChat.chat("&7Mimic Room: &c" + it);
                  }

                  Dungeon.Info.INSTANCE.setMimicFound(true);
               }
            }

            if (!MapUtils.INSTANCE.getCalibrated()) {
               MapUtils.INSTANCE.setCalibrated(MapUtils.INSTANCE.calibrateMap());
            }

            if (MapUtils.INSTANCE.getMapDataUpdated()) {
               MapUpdate.INSTANCE.updateRooms();
               MapUtils.INSTANCE.setMapDataUpdated(false);
            }

            Utils var5 = Utils.INSTANCE;
            Integer var10001 = Location.INSTANCE.getDungeonFloor();
            Object[] var1 = new Object[]{6, 7};
            if (var5.equalsOneOf(var10001, var1)) {
               MimicDetector.INSTANCE.checkMimicDead();
            }

            ScoreCalculation.INSTANCE.updateScore();
            List var6 = TabList.INSTANCE.getDungeonTabList();
            if (var6 != null) {
               List it = var6;
               var3 = false;
               MapUpdate.INSTANCE.updatePlayers(it);
               RunInformation.INSTANCE.updatePuzzleCount(it);
            }

            if (FunnyMap.INSTANCE.getExtras().getEnabled()) {
               ExtrasDungeon.INSTANCE.setBlocks();
            }

            if (DungeonScan.INSTANCE.getShouldScan()) {
               DungeonScan.INSTANCE.scan();
            }

         }
      }
   }

   @SubscribeEvent
   public final void onChatPacket(@NotNull ChatEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      if (Location.INSTANCE.getInDungeons()) {
         List var10000 = event.getPacket().func_148915_c().func_150253_a();
         Intrinsics.checkNotNullExpressionValue(var10000, "getSiblings(...)");
         Iterable $this$any$iv = (Iterable)var10000;
         int $i$f$any = false;
         Iterator var4;
         Object element$iv;
         boolean var7;
         boolean var16;
         if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
            var16 = false;
         } else {
            var4 = $this$any$iv.iterator();

            while(true) {
               if (!var4.hasNext()) {
                  var16 = false;
                  break;
               }

               label97: {
                  element$iv = var4.next();
                  IChatComponent it = (IChatComponent)element$iv;
                  var7 = false;
                  ChatStyle var15 = it.func_150256_b();
                  if (var15 != null) {
                     ClickEvent var8 = var15.func_150235_h();
                     if (var8 != null) {
                        Intrinsics.checkNotNull(var8);
                        int var10 = false;
                        var16 = var8.func_150669_a() == Action.RUN_COMMAND && Intrinsics.areEqual(var8.func_150668_b(), "/showextrastats");
                        break label97;
                     }
                  }

                  var16 = false;
               }

               if (var16) {
                  var16 = true;
                  break;
               }
            }
         }

         if (var16) {
            Dungeon.Info.INSTANCE.setEnded(true);
            if (Config.INSTANCE.getTeamInfo()) {
               PlayerTracker.INSTANCE.onDungeonEnd();
            }
         }

         $this$any$iv = (Iterable)keyGainRegex;
         $i$f$any = false;
         Regex it;
         String var10001;
         if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
            var16 = false;
         } else {
            var4 = $this$any$iv.iterator();

            while(true) {
               if (!var4.hasNext()) {
                  var16 = false;
                  break;
               }

               element$iv = var4.next();
               it = (Regex)element$iv;
               var7 = false;
               var10001 = event.getPacket().func_148915_c().func_150254_d();
               Intrinsics.checkNotNullExpressionValue(var10001, "getFormattedText(...)");
               if (it.matches((CharSequence)var10001)) {
                  var16 = true;
                  break;
               }
            }
         }

         Dungeon.Info var11;
         int var12;
         if (var16) {
            var11 = Dungeon.Info.INSTANCE;
            var12 = var11.getKeys();
            var11.setKeys(var12 + 1);
         }

         $this$any$iv = (Iterable)keyUseRegex;
         $i$f$any = false;
         if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
            var16 = false;
         } else {
            var4 = $this$any$iv.iterator();

            while(true) {
               if (!var4.hasNext()) {
                  var16 = false;
                  break;
               }

               element$iv = var4.next();
               it = (Regex)element$iv;
               var7 = false;
               var10001 = event.getPacket().func_148915_c().func_150254_d();
               Intrinsics.checkNotNullExpressionValue(var10001, "getFormattedText(...)");
               if (it.matches((CharSequence)var10001)) {
                  var16 = true;
                  break;
               }
            }
         }

         if (var16) {
            var11 = Dungeon.Info.INSTANCE;
            var12 = var11.getKeys();
            var11.setKeys(var12 + -1);
         }

         String var13 = event.getText();
         if (Intrinsics.areEqual(var13, "Starting in 4 seconds.")) {
            MapUpdate.INSTANCE.preloadHeads();
         } else if (Intrinsics.areEqual(var13, "[NPC] Mort: Here, I found this map when I first entered the dungeon.")) {
            MapUpdate.INSTANCE.getPlayers();
            Dungeon.Info.INSTANCE.setStartTime(System.currentTimeMillis());
         }

      }
   }

   @SubscribeEvent
   public final void onWorldLoad(@NotNull Unload event) {
      Intrinsics.checkNotNullParameter(event, "event");
      this.reset();
   }

   public final void reset() {
      ExtrasDungeon.INSTANCE.reset();
      Dungeon.Info.INSTANCE.reset();
      dungeonTeammates.clear();
      espDoors.clear();
      PlayerTracker.INSTANCE.getRoomClears().clear();
      MapUtils.INSTANCE.setCalibrated(false);
      MapUtils.INSTANCE.setMapData((MapData)null);
      DungeonScan.INSTANCE.setHasScanned(false);
      RunInformation.INSTANCE.reset();
   }

   private final boolean shouldSearchMimic() {
      boolean var2;
      if (!Dungeon.Info.INSTANCE.getMimicFound()) {
         Utils var10000 = Utils.INSTANCE;
         Integer var10001 = Location.INSTANCE.getDungeonFloor();
         Object[] var1 = new Object[]{6, 7};
         if (var10000.equalsOneOf(var10001, var1) && !Config.INSTANCE.getLegitMode()) {
            var2 = true;
            return var2;
         }
      }

      var2 = false;
      return var2;
   }

   static {
      Regex[] var0 = new Regex[]{new Regex(".+ §r§ehas obtained §r§a§r§.+ Key§r§e!§r"), new Regex("§r§eA §r§a§r§.+ Key§r§e was picked up!§r")};
      keyGainRegex = CollectionsKt.listOf(var0);
      var0 = new Regex[]{new Regex("§r§cThe §r§c§lBLOOD DOOR§r§c has been opened!§r"), new Regex("§r§a.+§r§a opened a §r§8§lWITHER §r§adoor!§r")};
      keyUseRegex = CollectionsKt.listOf(var0);
   }

   @Metadata(
      mv = {1, 9, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bB\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0007\u001a\u0004\b\u001a\u0010\t\"\u0004\b\u001b\u0010\u000bR\"\u0010\u001c\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R#\u0010!\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00120\u001f8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\"\u0010%\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0007\u001a\u0004\b&\u0010\t\"\u0004\b'\u0010\u000bR\"\u0010(\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0007\u001a\u0004\b)\u0010\t\"\u0004\b*\u0010\u000bR\"\u0010,\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001d\u0010;\u001a\b\u0012\u0004\u0012\u00020:098\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\"\u0010?\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010\u0007\u001a\u0004\b@\u0010\t\"\u0004\bA\u0010\u000b¨\u0006C"},
      d2 = {"Lfunnymap/features/dungeon/Dungeon$Info;", "", "", "reset", "()V", "", "cryptCount", "I", "getCryptCount", "()I", "setCryptCount", "(I)V", "", "Lfunnymap/core/map/Tile;", "dungeonList", "[Lfunnymap/core/map/Tile;", "getDungeonList", "()[Lfunnymap/core/map/Tile;", "", "ended", "Z", "getEnded", "()Z", "setEnded", "(Z)V", "keys", "getKeys", "setKeys", "mimicFound", "getMimicFound", "setMimicFound", "", "Lfunnymap/core/map/Puzzle;", "puzzles", "Ljava/util/Map;", "getPuzzles", "()Ljava/util/Map;", "roomCount", "getRoomCount", "setRoomCount", "secretCount", "getSecretCount", "setSecretCount", "", "startTime", "J", "getStartTime", "()J", "setStartTime", "(J)V", "", "trapType", "Ljava/lang/String;", "getTrapType", "()Ljava/lang/String;", "setTrapType", "(Ljava/lang/String;)V", "", "Lfunnymap/core/map/UniqueRoom;", "uniqueRooms", "Ljava/util/Set;", "getUniqueRooms", "()Ljava/util/Set;", "witherDoors", "getWitherDoors", "setWitherDoors", "<init>", "FunnyMapExtras"}
   )
   public static final class Info {
      @NotNull
      public static final Dungeon.Info INSTANCE = new Dungeon.Info();
      @NotNull
      private static final Tile[] dungeonList;
      @NotNull
      private static final Set<UniqueRoom> uniqueRooms;
      private static int roomCount;
      @NotNull
      private static final Map<Puzzle, Boolean> puzzles;
      @NotNull
      private static String trapType;
      private static int witherDoors;
      private static int cryptCount;
      private static int secretCount;
      private static boolean mimicFound;
      private static long startTime;
      private static boolean ended;
      private static int keys;

      private Info() {
      }

      @NotNull
      public final Tile[] getDungeonList() {
         return dungeonList;
      }

      @NotNull
      public final Set<UniqueRoom> getUniqueRooms() {
         return uniqueRooms;
      }

      public final int getRoomCount() {
         return roomCount;
      }

      public final void setRoomCount(int <set-?>) {
         roomCount = var1;
      }

      @NotNull
      public final Map<Puzzle, Boolean> getPuzzles() {
         return puzzles;
      }

      @NotNull
      public final String getTrapType() {
         return trapType;
      }

      public final void setTrapType(@NotNull String <set-?>) {
         Intrinsics.checkNotNullParameter(var1, "<set-?>");
         trapType = var1;
      }

      public final int getWitherDoors() {
         return witherDoors;
      }

      public final void setWitherDoors(int <set-?>) {
         witherDoors = var1;
      }

      public final int getCryptCount() {
         return cryptCount;
      }

      public final void setCryptCount(int <set-?>) {
         cryptCount = var1;
      }

      public final int getSecretCount() {
         return secretCount;
      }

      public final void setSecretCount(int <set-?>) {
         secretCount = var1;
      }

      public final boolean getMimicFound() {
         return mimicFound;
      }

      public final void setMimicFound(boolean <set-?>) {
         mimicFound = var1;
      }

      public final long getStartTime() {
         return startTime;
      }

      public final void setStartTime(long <set-?>) {
         startTime = var1;
      }

      public final boolean getEnded() {
         return ended;
      }

      public final void setEnded(boolean <set-?>) {
         ended = var1;
      }

      public final int getKeys() {
         return keys;
      }

      public final void setKeys(int <set-?>) {
         keys = var1;
      }

      public final void reset() {
         ArraysKt.fill$default(dungeonList, new Unknown(0, 0), 0, 0, 6, (Object)null);
         uniqueRooms.clear();
         roomCount = 0;
         puzzles.clear();
         trapType = "";
         witherDoors = 0;
         cryptCount = 0;
         secretCount = 0;
         mimicFound = false;
         startTime = 0L;
         ended = false;
         keys = 0;
      }

      static {
         int var0 = 0;

         Tile[] var1;
         for(var1 = new Tile[121]; var0 < 121; ++var0) {
            var1[var0] = new Unknown(0, 0);
         }

         dungeonList = var1;
         uniqueRooms = (Set)(new LinkedHashSet());
         puzzles = (Map)(new LinkedHashMap());
         trapType = "";
      }
   }
}
