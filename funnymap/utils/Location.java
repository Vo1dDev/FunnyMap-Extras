package funnymap.utils;

import funnymap.FunnyMap;
import funnymap.config.Config;
import funnymap.events.ChatEvent;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Result.Companion;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraftforge.event.world.WorldEvent.Unload;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent.ClientConnectedToServerEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent.ClientDisconnectionFromServerEvent;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u00019B\t\b\u0002¢\u0006\u0004\b8\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010%\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b$\u0010!R\"\u0010&\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u001f\u001a\u0004\b'\u0010!\"\u0004\b(\u0010#R\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\"\u00103\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010\u001f\u001a\u0004\b4\u0010!\"\u0004\b5\u0010#R\u0016\u00106\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010\u001fR\u0016\u00107\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010\u0014¨\u0006:"},
   d2 = {"Lfunnymap/utils/Location;", "", "Lfunnymap/events/ChatEvent;", "event", "", "onChat", "(Lfunnymap/events/ChatEvent;)V", "Lnet/minecraftforge/fml/common/network/FMLNetworkEvent$ClientConnectedToServerEvent;", "onConnect", "(Lnet/minecraftforge/fml/common/network/FMLNetworkEvent$ClientConnectedToServerEvent;)V", "Lnet/minecraftforge/fml/common/network/FMLNetworkEvent$ClientDisconnectionFromServerEvent;", "onDisconnect", "(Lnet/minecraftforge/fml/common/network/FMLNetworkEvent$ClientDisconnectionFromServerEvent;)V", "onTick", "()V", "Lnet/minecraftforge/event/world/WorldEvent$Unload;", "onWorldUnload", "(Lnet/minecraftforge/event/world/WorldEvent$Unload;)V", "", "dungeonFloor", "I", "getDungeonFloor", "()I", "setDungeonFloor", "(I)V", "", "", "entryMessages", "Ljava/util/List;", "", "inBoss", "Z", "getInBoss", "()Z", "setInBoss", "(Z)V", "getInDungeons", "inDungeons", "inSkyblock", "getInSkyblock", "setInSkyblock", "Lfunnymap/utils/Location$Island;", "island", "Lfunnymap/utils/Location$Island;", "getIsland", "()Lfunnymap/utils/Location$Island;", "setIsland", "(Lfunnymap/utils/Location$Island;)V", "Lkotlin/text/Regex;", "islandRegex", "Lkotlin/text/Regex;", "masterMode", "getMasterMode", "setMasterMode", "onHypixel", "tickCount", "<init>", "Island", "FunnyMapExtras"}
)
@SourceDebugExtension({"SMAP\nLocation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Location.kt\nfunnymap/utils/Location\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,119:1\n1#2:120\n1747#3,3:121\n*S KotlinDebug\n*F\n+ 1 Location.kt\nfunnymap/utils/Location\n*L\n71#1:121,3\n*E\n"})
public final class Location {
   @NotNull
   public static final Location INSTANCE = new Location();
   private static boolean onHypixel;
   private static boolean inSkyblock;
   @NotNull
   private static Location.Island island;
   private static int dungeonFloor;
   private static boolean masterMode;
   private static boolean inBoss;
   @NotNull
   private static Regex islandRegex;
   @NotNull
   private static final List<String> entryMessages;
   private static int tickCount;

   private Location() {
   }

   public final boolean getInSkyblock() {
      return inSkyblock;
   }

   public final void setInSkyblock(boolean <set-?>) {
      inSkyblock = var1;
   }

   @NotNull
   public final Location.Island getIsland() {
      return island;
   }

   public final void setIsland(@NotNull Location.Island <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      island = var1;
   }

   public final boolean getInDungeons() {
      return island == Location.Island.Dungeon;
   }

   public final int getDungeonFloor() {
      return dungeonFloor;
   }

   public final void setDungeonFloor(int <set-?>) {
      dungeonFloor = var1;
   }

   public final boolean getMasterMode() {
      return masterMode;
   }

   public final void setMasterMode(boolean <set-?>) {
      masterMode = var1;
   }

   public final boolean getInBoss() {
      return inBoss;
   }

   public final void setInBoss(boolean <set-?>) {
      inBoss = var1;
   }

   public final void onTick() {
      if (FunnyMap.INSTANCE.getMc().field_71441_e != null) {
         int var1 = tickCount++;
         if (tickCount % 20 == 0) {
            if (Config.INSTANCE.getForceSkyblock()) {
               inSkyblock = true;
               island = Location.Island.Dungeon;
               dungeonFloor = 7;
            } else {
               boolean var29;
               label114: {
                  if (onHypixel) {
                     String var28;
                     label111: {
                        net.minecraft.scoreboard.Scoreboard var10000 = FunnyMap.INSTANCE.getMc().field_71441_e.func_96441_U();
                        if (var10000 != null) {
                           ScoreObjective var27 = var10000.func_96539_a(1);
                           if (var27 != null) {
                              var28 = var27.func_96679_b();
                              break label111;
                           }
                        }

                        var28 = null;
                     }

                     if (Intrinsics.areEqual(var28, "SBScoreboard")) {
                        var29 = true;
                        break label114;
                     }
                  }

                  var29 = false;
               }

               inSkyblock = var29;
               String areaName;
               Object var31;
               Location var33;
               if (island == Location.Island.Unknown) {
                  Iterator var3 = ((Iterable)TabList.INSTANCE.getTabList()).iterator();

                  MatchResult var30;
                  while(true) {
                     if (!var3.hasNext()) {
                        var30 = null;
                        break;
                     }

                     Pair it = (Pair)var3.next();
                     int var5 = false;
                     MatchResult var16 = Regex.find$default(islandRegex, (CharSequence)it.getSecond(), 0, 2, (Object)null);
                     if (var16 != null) {
                        var30 = var16;
                        break;
                     }
                  }

                  MatchResult var12 = var30;
                  if (var12 != null) {
                     List var2 = var12.getGroupValues();
                     if (var2 != null) {
                        String var14 = (String)CollectionsKt.getOrNull(var2, 1);
                        if (var14 != null) {
                           areaName = var14;
                           int var6 = false;
                           Iterable var7 = (Iterable)Location.Island.getEntries();
                           Iterator var8 = var7.iterator();

                           while(true) {
                              if (!var8.hasNext()) {
                                 var31 = null;
                                 break;
                              }

                              Object var9 = var8.next();
                              Location.Island it = (Location.Island)var9;
                              int var11 = false;
                              if (Intrinsics.areEqual(it.getDisplayName(), areaName)) {
                                 var31 = var9;
                                 break;
                              }
                           }

                           Location.Island var32 = (Location.Island)var31;
                           if (var32 != null) {
                              Location.Island it = var32;
                              int var24 = false;
                              var33 = INSTANCE;
                              island = it;
                           }
                        }
                     }
                  }
               }

               if (island == Location.Island.Dungeon && dungeonFloor == -1) {
                  Iterable var15 = (Iterable)Scoreboard.INSTANCE.getLines();
                  Iterator var17 = var15.iterator();

                  while(true) {
                     if (!var17.hasNext()) {
                        var31 = null;
                        break;
                     }

                     Object var20 = var17.next();
                     String it = (String)var20;
                     int var23 = false;
                     String $this$onTick_u24lambda_u245_u24lambda_u244 = Scoreboard.INSTANCE.cleanLine(it);
                     int var26 = false;
                     if (StringsKt.contains$default((CharSequence)$this$onTick_u24lambda_u245_u24lambda_u244, (CharSequence)"The Catacombs (", false, 2, (Object)null) && !StringsKt.contains$default((CharSequence)$this$onTick_u24lambda_u245_u24lambda_u244, (CharSequence)"Queue", false, 2, (Object)null)) {
                        var31 = var20;
                        break;
                     }
                  }

                  String var13 = (String)var31;
                  if (var13 != null) {
                     int var36;
                     label67: {
                        int var18 = false;
                        areaName = StringsKt.substringBefore$default(var13, ")", (String)null, 2, (Object)null);
                        var33 = INSTANCE;
                        Character var34 = StringsKt.lastOrNull((CharSequence)areaName);
                        if (var34 != null) {
                           Integer var35 = CharsKt.digitToIntOrNull(var34);
                           if (var35 != null) {
                              var36 = var35;
                              break label67;
                           }
                        }

                        var36 = 0;
                     }

                     dungeonFloor = var36;
                     var33 = INSTANCE;
                     masterMode = areaName.charAt(areaName.length() - 2) == 'M';
                  }
               }

            }
         }
      }
   }

   @SubscribeEvent
   public final void onChat(@NotNull ChatEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      if (event.getPacket().func_179841_c() != 2 && this.getInDungeons()) {
         if (StringsKt.startsWith$default(event.getText(), "[BOSS] Maxor: ", false, 2, (Object)null)) {
            inBoss = true;
         }

         Iterable $this$any$iv = (Iterable)entryMessages;
         int $i$f$any = false;
         boolean var10000;
         if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
            var10000 = false;
         } else {
            Iterator var4 = $this$any$iv.iterator();

            while(true) {
               if (!var4.hasNext()) {
                  var10000 = false;
                  break;
               }

               Object element$iv = var4.next();
               String it = (String)element$iv;
               int var7 = false;
               if (Intrinsics.areEqual(it, event.getText())) {
                  var10000 = true;
                  break;
               }
            }
         }

         if (var10000) {
            inBoss = true;
         }

      }
   }

   @SubscribeEvent
   public final void onConnect(@NotNull ClientConnectedToServerEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      Minecraft var2 = FunnyMap.INSTANCE.getMc();

      Object var3;
      Companion var10000;
      try {
         boolean var14;
         label42: {
            var10000 = Result.Companion;
            int var4 = false;
            if (!event.isLocal) {
               Boolean var13;
               label48: {
                  EntityPlayerSP var10 = var2.field_71439_g;
                  String var11;
                  if (var10 != null) {
                     String var5 = var10.func_142021_k();
                     if (var5 != null) {
                        Intrinsics.checkNotNull(var5);
                        var11 = var5.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(var11, "toLowerCase(...)");
                        if (var11 != null) {
                           var13 = StringsKt.contains$default((CharSequence)var11, (CharSequence)"hypixel", false, 2, (Object)null);
                           break label48;
                        }
                     }
                  }

                  ServerData var12 = var2.func_147104_D();
                  if (var12 != null) {
                     String var6 = var12.field_78845_b;
                     if (var6 != null) {
                        Intrinsics.checkNotNull(var6);
                        var11 = var6.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(var11, "toLowerCase(...)");
                        if (var11 != null) {
                           var13 = StringsKt.contains$default((CharSequence)var11, (CharSequence)"hypixel", false, 2, (Object)null);
                           break label48;
                        }
                     }
                  }

                  var13 = null;
               }

               if (Intrinsics.areEqual(var13, true)) {
                  var14 = true;
                  break label42;
               }
            }

            var14 = false;
         }

         var3 = Result.constructor-impl(var14);
      } catch (Throwable var7) {
         var10000 = Result.Companion;
         var3 = Result.constructor-impl(ResultKt.createFailure(var7));
      }

      Object var8 = var3;
      Boolean var9 = false;
      onHypixel = (Boolean)(Result.isFailure-impl(var8) ? var9 : var8);
   }

   @SubscribeEvent
   public final void onWorldUnload(@NotNull Unload event) {
      Intrinsics.checkNotNullParameter(event, "event");
      island = Location.Island.Unknown;
      dungeonFloor = -1;
      inBoss = false;
   }

   @SubscribeEvent
   public final void onDisconnect(@NotNull ClientDisconnectionFromServerEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      onHypixel = false;
      inSkyblock = false;
      island = Location.Island.Unknown;
      dungeonFloor = -1;
      inBoss = false;
   }

   static {
      island = Location.Island.Unknown;
      dungeonFloor = -1;
      islandRegex = new Regex("^§r§b§l(?:Area|Dungeon): §r§7(.+)§r$");
      String[] var0 = new String[]{"[BOSS] Bonzo: Gratz for making it this far, but I'm basically unbeatable.", "[BOSS] Scarf: This is where the journey ends for you, Adventurers.", "[BOSS] The Professor: I was burdened with terrible news recently...", "[BOSS] Thorn: Welcome Adventurers! I am Thorn, the Spirit! And host of the Vegan Trials!", "[BOSS] Livid: Welcome, you've arrived right on time. I am Livid, the Master of Shadows.", "[BOSS] Sadan: So you made it all the way here... Now you wish to defy me? Sadan?!"};
      entryMessages = CollectionsKt.listOf(var0);
   }

   @Metadata(
      mv = {1, 9, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"},
      d2 = {"Lfunnymap/utils/Location$Island;", "", "", "displayName", "Ljava/lang/String;", "getDisplayName", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "PrivateIsland", "Garden", "SpiderDen", "CrimsonIsle", "TheEnd", "GoldMine", "DeepCaverns", "DwarvenMines", "CrystalHollows", "FarmingIsland", "ThePark", "Dungeon", "DungeonHub", "Hub", "DarkAuction", "JerryWorkshop", "Kuudra", "Unknown", "FunnyMapExtras"}
   )
   public static enum Island {
      @NotNull
      private final String displayName;
      PrivateIsland("Private Island"),
      Garden("Garden"),
      SpiderDen("Spider's Den"),
      CrimsonIsle("Crimson Isle"),
      TheEnd("The End"),
      GoldMine("Gold Mine"),
      DeepCaverns("Deep Caverns"),
      DwarvenMines("Dwarven Mines"),
      CrystalHollows("Crystal Hollows"),
      FarmingIsland("The Farming Islands"),
      ThePark("The Park"),
      Dungeon("Catacombs"),
      DungeonHub("Dungeon Hub"),
      Hub("Hub"),
      DarkAuction("Dark Auction"),
      JerryWorkshop("Jerry's Workshop"),
      Kuudra("Kuudra"),
      Unknown("(Unknown)");

      // $FF: synthetic field
      private static final EnumEntries $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);

      private Island(String displayName) {
         this.displayName = displayName;
      }

      @NotNull
      public final String getDisplayName() {
         return this.displayName;
      }

      @NotNull
      public static EnumEntries<Location.Island> getEntries() {
         return $ENTRIES;
      }

      // $FF: synthetic method
      private static final Location.Island[] $values() {
         Location.Island[] var0 = new Location.Island[]{PrivateIsland, Garden, SpiderDen, CrimsonIsle, TheEnd, GoldMine, DeepCaverns, DwarvenMines, CrystalHollows, FarmingIsland, ThePark, Dungeon, DungeonHub, Hub, DarkAuction, JerryWorkshop, Kuudra, Unknown};
         return var0;
      }
   }
}
