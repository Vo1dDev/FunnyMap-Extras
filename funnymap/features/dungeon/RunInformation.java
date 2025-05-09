package funnymap.features.dungeon;

import com.mojang.authlib.GameProfile;
import funnymap.core.map.Puzzle;
import funnymap.core.map.Room;
import funnymap.core.map.RoomState;
import funnymap.core.map.Tile;
import funnymap.events.ChatEvent;
import funnymap.events.ScoreboardEvent;
import funnymap.events.TabListEvent;
import funnymap.utils.Location;
import funnymap.utils.Utils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.jdk8.RegexExtensionsJDK8Kt;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.network.play.server.S38PacketPlayerListItem.Action;
import net.minecraft.network.play.server.S38PacketPlayerListItem.AddPlayerData;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b3\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b]\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u001a\u001a\u00020\u00042\u0018\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00120\u00170\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001f\u001a\u0004\u0018\u00010\u0012*\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0011\u0010.\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0011\u00103\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b1\u00102R\"\u00104\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00100\u001a\u0004\b5\u0010-\"\u0004\b6\u00107R\u0014\u00108\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\"\u0010:\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u00100\u001a\u0004\b;\u0010-\"\u0004\b<\u00107R\u0014\u0010=\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u00109R\u0014\u0010>\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u00109R\u0014\u0010?\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u00109R\"\u0010@\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010#\u001a\u0004\bA\u0010%\"\u0004\bB\u0010'R\"\u0010C\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u00100\u001a\u0004\bD\u0010-\"\u0004\bE\u00107R\u0014\u0010F\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u00109R\u0014\u0010G\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u00109R\"\u0010H\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010*\u001a\u0004\bI\u00102\"\u0004\bJ\u0010KR\u0011\u0010M\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\bL\u0010-R\"\u0010N\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u00100\u001a\u0004\bO\u0010-\"\u0004\bP\u00107R\u0014\u0010Q\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u00109R\u0014\u0010R\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u00109R\u0014\u0010S\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u00109R\"\u0010T\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u00100\u001a\u0004\bU\u0010-\"\u0004\bV\u00107R\u0014\u0010W\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u00109R\"\u0010X\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u00100\u001a\u0004\bY\u0010-\"\u0004\bZ\u00107R\u0014\u0010\\\u001a\u00020+8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b[\u0010-¨\u0006^"},
   d2 = {"Lfunnymap/features/dungeon/RunInformation;", "", "Lfunnymap/events/ChatEvent;", "event", "", "onChat", "(Lfunnymap/events/ChatEvent;)V", "Lnet/minecraftforge/event/entity/living/LivingDeathEvent;", "onEntityDeath", "(Lnet/minecraftforge/event/entity/living/LivingDeathEvent;)V", "Lfunnymap/events/ScoreboardEvent;", "onScoreboard", "(Lfunnymap/events/ScoreboardEvent;)V", "Lfunnymap/events/TabListEvent;", "onTabList", "(Lfunnymap/events/TabListEvent;)V", "reset", "()V", "", "text", "updateFromTabList", "(Ljava/lang/String;)V", "", "Lkotlin/Pair;", "Lnet/minecraft/client/network/NetworkPlayerInfo;", "tabList", "updatePuzzleCount", "(Ljava/util/List;)V", "Lkotlin/text/Regex;", "", "input", "firstResult", "(Lkotlin/text/Regex;Ljava/lang/CharSequence;)Ljava/lang/String;", "", "bloodDone", "Z", "getBloodDone", "()Z", "setBloodDone", "(Z)V", "", "clearedPercentage", "F", "", "getCompletedPuzzles", "()I", "completedPuzzles", "completedRooms", "I", "getCompletedRoomsPercentage", "()F", "completedRoomsPercentage", "cryptsCount", "getCryptsCount", "setCryptsCount", "(I)V", "cryptsPattern", "Lkotlin/text/Regex;", "deathCount", "getDeathCount", "setDeathCount", "deathsRegex", "dungeonClearedPattern", "failedPuzzleRegex", "mimicKilled", "getMimicKilled", "setMimicKilled", "minSecrets", "getMinSecrets", "setMinSecrets", "puzzleCountRegex", "roomCompletedPattern", "secretPercentage", "getSecretPercentage", "setSecretPercentage", "(F)V", "getSecretTotal", "secretTotal", "secretsFound", "getSecretsFound", "setSecretsFound", "secretsFoundPattern", "secretsFoundPercentagePattern", "solvedPuzzleRegex", "timeElapsed", "getTimeElapsed", "setTimeElapsed", "timeElapsedPattern", "totalPuzzles", "getTotalPuzzles", "setTotalPuzzles", "getTotalRooms", "totalRooms", "<init>", "FunnyMapExtras"}
)
@SourceDebugExtension({"SMAP\nRunInformation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RunInformation.kt\nfunnymap/features/dungeon/RunInformation\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,209:1\n204#2,4:210\n1855#3,2:214\n1855#3:216\n1856#3:220\n1855#3,2:221\n1#4:217\n1282#5,2:218\n*S KotlinDebug\n*F\n+ 1 RunInformation.kt\nfunnymap/features/dungeon/RunInformation\n*L\n29#1:210,4\n106#1:214,2\n113#1:216\n113#1:220\n142#1:221,2\n118#1:218,2\n*E\n"})
public final class RunInformation {
   @NotNull
   public static final RunInformation INSTANCE = new RunInformation();
   private static int deathCount;
   private static int totalPuzzles;
   private static int cryptsCount;
   private static int secretsFound;
   private static float secretPercentage;
   private static int minSecrets;
   private static boolean mimicKilled;
   private static int completedRooms;
   private static boolean bloodDone;
   private static float clearedPercentage;
   private static int timeElapsed;
   @NotNull
   private static final Regex deathsRegex = new Regex("§r§a§lTeam Deaths: §r§f(?<deaths>\\d+)§r");
   @NotNull
   private static final Regex puzzleCountRegex = new Regex("§r§b§lPuzzles: §r§f\\((?<count>\\d)\\)§r");
   @NotNull
   private static final Regex failedPuzzleRegex = new Regex("§r (?<puzzle>.+): §r§7\\[§r§c§l✖§r§7] §.+");
   @NotNull
   private static final Regex solvedPuzzleRegex = new Regex("§r (?<puzzle>.+): §r§7\\[§r§a§l✔§r§7] §.+");
   @NotNull
   private static final Regex cryptsPattern = new Regex("§r Crypts: §r§6(?<crypts>\\d+)§r");
   @NotNull
   private static final Regex secretsFoundPattern = new Regex("§r Secrets Found: §r§b(?<secrets>\\d+)§r");
   @NotNull
   private static final Regex secretsFoundPercentagePattern = new Regex("§r Secrets Found: §r§[ae](?<percentage>[\\d.]+)%§r");
   @NotNull
   private static final Regex roomCompletedPattern = new Regex("§r Completed Rooms: §r§d(?<count>\\d+)§r");
   @NotNull
   private static final Regex dungeonClearedPattern = new Regex("Cleared: (?<percentage>\\d+)% \\(\\d+\\)");
   @NotNull
   private static final Regex timeElapsedPattern = new Regex("Time Elapsed: (?:(?<hrs>\\d+)h )?(?:(?<min>\\d+)m )?(?:(?<sec>\\d+)s)?");

   private RunInformation() {
   }

   public final int getDeathCount() {
      return deathCount;
   }

   public final void setDeathCount(int <set-?>) {
      deathCount = var1;
   }

   public final int getCompletedPuzzles() {
      Map $this$count$iv = Dungeon.Info.INSTANCE.getPuzzles();
      int $i$f$count = false;
      int var10000;
      if ($this$count$iv.isEmpty()) {
         var10000 = 0;
      } else {
         int count$iv = 0;
         Iterator var4 = $this$count$iv.entrySet().iterator();

         while(var4.hasNext()) {
            Entry element$iv = (Entry)var4.next();
            int var7 = false;
            if ((Boolean)element$iv.getValue()) {
               ++count$iv;
            }
         }

         var10000 = count$iv;
      }

      return var10000;
   }

   public final int getTotalPuzzles() {
      return totalPuzzles;
   }

   public final void setTotalPuzzles(int <set-?>) {
      totalPuzzles = var1;
   }

   public final int getCryptsCount() {
      return cryptsCount;
   }

   public final void setCryptsCount(int <set-?>) {
      cryptsCount = var1;
   }

   public final int getSecretsFound() {
      return secretsFound;
   }

   public final void setSecretsFound(int <set-?>) {
      secretsFound = var1;
   }

   public final float getSecretPercentage() {
      return secretPercentage;
   }

   public final void setSecretPercentage(float <set-?>) {
      secretPercentage = var1;
   }

   public final int getSecretTotal() {
      return (int)((double)((float)secretsFound / (secretPercentage + 1.0E-4F)) + 0.5D);
   }

   public final int getMinSecrets() {
      return minSecrets;
   }

   public final void setMinSecrets(int <set-?>) {
      minSecrets = var1;
   }

   public final boolean getMimicKilled() {
      return mimicKilled;
   }

   public final void setMimicKilled(boolean <set-?>) {
      mimicKilled = var1;
   }

   public final float getCompletedRoomsPercentage() {
      return (float)(completedRooms + (!Location.INSTANCE.getInBoss() ? 1 : 0) + (!bloodDone ? 1 : 0)) / (float)(this.getTotalRooms() == 0 ? 36 : this.getTotalRooms());
   }

   public final boolean getBloodDone() {
      return bloodDone;
   }

   public final void setBloodDone(boolean <set-?>) {
      bloodDone = var1;
   }

   private final int getTotalRooms() {
      return (int)((double)((float)completedRooms / (clearedPercentage + 1.0E-4F)) + 0.4D);
   }

   public final int getTimeElapsed() {
      return timeElapsed;
   }

   public final void setTimeElapsed(int <set-?>) {
      timeElapsed = var1;
   }

   public final void reset() {
      deathCount = 0;
      totalPuzzles = 0;
      cryptsCount = 0;
      secretsFound = 0;
      secretPercentage = 0.0F;
      mimicKilled = false;
      completedRooms = 0;
      bloodDone = false;
      clearedPercentage = 0.0F;
      timeElapsed = 0;
      ScoreCalculation.INSTANCE.setMessage270(false);
      ScoreCalculation.INSTANCE.setMessage300(false);
      MimicDetector.INSTANCE.setMimicPos((BlockPos)null);
      MimicDetector.INSTANCE.setMimicOpenTime(0L);
   }

   @SubscribeEvent
   public final void onScoreboard(@NotNull ScoreboardEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      if (Location.INSTANCE.getInDungeons() && event.getPacket().func_149307_h() == 2) {
         float maxSecrets = (float)Math.ceil((double)((float)this.getSecretTotal() * ScoreCalculation.INSTANCE.getSecretPercent()));
         minSecrets = (int)((float)Math.ceil((double)(maxSecrets * (float)(40 - ScoreCalculation.INSTANCE.getBonusScore() + ScoreCalculation.INSTANCE.getDeathDeduction()) / (float)40)));
         Utils var10000 = Utils.INSTANCE;
         Collection var10001 = event.getPacket().func_149310_g();
         Intrinsics.checkNotNullExpressionValue(var10001, "getPlayers(...)");
         Iterable var11 = (Iterable)var10001;
         CharSequence var10002 = (CharSequence)" ";
         String var10003 = event.getPacket().func_149311_e();
         Intrinsics.checkNotNullExpressionValue(var10003, "getPrefix(...)");
         CharSequence var15 = (CharSequence)var10003;
         String var10004 = event.getPacket().func_149309_f();
         Intrinsics.checkNotNullExpressionValue(var10004, "getSuffix(...)");
         String line = var10000.removeFormatting(CollectionsKt.joinToString$default(var11, var10002, var15, (CharSequence)var10004, 0, (CharSequence)null, (Function1)null, 56, (Object)null));
         MatchGroupCollection match;
         MatchResult var8;
         MatchGroupCollection var9;
         MatchGroup var10;
         String var12;
         if (StringsKt.startsWith$default(line, "Cleared: ", false, 2, (Object)null)) {
            var8 = dungeonClearedPattern.matchEntire((CharSequence)line);
            if (var8 != null) {
               var9 = var8.getGroups();
               if (var9 != null) {
                  float var17;
                  label60: {
                     match = var9;
                     var10 = RegexExtensionsJDK8Kt.get(match, "percentage");
                     if (var10 != null) {
                        var12 = var10.getValue();
                        if (var12 != null) {
                           Float var16 = StringsKt.toFloatOrNull(var12);
                           if (var16 != null) {
                              var17 = var16 / 100.0F;
                              break label60;
                           }
                        }
                     }

                     var17 = clearedPercentage;
                  }

                  clearedPercentage = var17;
                  return;
               }
            }

            return;
         } else if (StringsKt.startsWith$default(line, "Time Elapsed:", false, 2, (Object)null)) {
            var8 = timeElapsedPattern.matchEntire((CharSequence)line);
            if (var8 == null) {
               return;
            }

            var9 = var8.getGroups();
            if (var9 == null) {
               return;
            }

            Integer var13;
            int var14;
            label54: {
               match = var9;
               var10 = RegexExtensionsJDK8Kt.get(match, "hrs");
               if (var10 != null) {
                  var12 = var10.getValue();
                  if (var12 != null) {
                     var13 = StringsKt.toIntOrNull(var12);
                     if (var13 != null) {
                        var14 = var13;
                        break label54;
                     }
                  }
               }

               var14 = 0;
            }

            int hours;
            label48: {
               hours = var14;
               var10 = RegexExtensionsJDK8Kt.get(match, "min");
               if (var10 != null) {
                  var12 = var10.getValue();
                  if (var12 != null) {
                     var13 = StringsKt.toIntOrNull(var12);
                     if (var13 != null) {
                        var14 = var13;
                        break label48;
                     }
                  }
               }

               var14 = 0;
            }

            int minutes;
            label42: {
               minutes = var14;
               var10 = RegexExtensionsJDK8Kt.get(match, "sec");
               if (var10 != null) {
                  var12 = var10.getValue();
                  if (var12 != null) {
                     var13 = StringsKt.toIntOrNull(var12);
                     if (var13 != null) {
                        var14 = var13;
                        break label42;
                     }
                  }
               }

               var14 = 0;
            }

            int seconds = var14;
            timeElapsed = hours * 3600 + minutes * 60 + seconds;
         }

      }
   }

   @SubscribeEvent
   public final void onChat(@NotNull ChatEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      if (!mimicKilled) {
         if (StringsKt.startsWith$default(event.getText(), "Party > ", false, 2, (Object)null) || StringsKt.contains$default((CharSequence)event.getText(), (CharSequence)":", false, 2, (Object)null) && !StringsKt.contains$default((CharSequence)event.getText(), (CharSequence)">", false, 2, (Object)null)) {
            String[] var2 = new String[]{"$SKYTILS-DUNGEON-SCORE-MIMIC$", "mimic dead", "mimic killed"};
            Iterable $this$forEach$iv = (Iterable)CollectionsKt.listOf(var2);
            int $i$f$forEach = false;
            Iterator var4 = $this$forEach$iv.iterator();

            Object element$iv;
            String it;
            boolean var7;
            while(var4.hasNext()) {
               element$iv = var4.next();
               it = (String)element$iv;
               var7 = false;
               if (StringsKt.contains((CharSequence)event.getText(), (CharSequence)it, true)) {
                  RunInformation var10000 = INSTANCE;
                  mimicKilled = true;
                  return;
               }
            }

            var2 = new String[]{"blaze done", "blaze puzzle finished"};
            $this$forEach$iv = (Iterable)CollectionsKt.listOf(var2);
            $i$f$forEach = false;
            var4 = $this$forEach$iv.iterator();

            while(var4.hasNext()) {
               element$iv = var4.next();
               it = (String)element$iv;
               var7 = false;
               if (StringsKt.contains((CharSequence)event.getText(), (CharSequence)it, true)) {
                  Iterable var8 = (Iterable)Dungeon.Info.INSTANCE.getPuzzles().keySet();
                  Iterator var9 = var8.iterator();

                  Object var24;
                  while(true) {
                     if (var9.hasNext()) {
                        Object var10 = var9.next();
                        Puzzle puzzle = (Puzzle)var10;
                        int var12 = false;
                        if (!Intrinsics.areEqual(puzzle.getTabName(), "Higher Or Lower")) {
                           continue;
                        }

                        var24 = var10;
                        break;
                     }

                     var24 = null;
                     break;
                  }

                  Puzzle var25 = (Puzzle)var24;
                  if ((Puzzle)var24 == null) {
                     return;
                  }

                  Puzzle puzzle = var25;
                  Dungeon.Info.INSTANCE.getPuzzles().put(puzzle, true);
                  Object[] $this$firstOrNull$iv = Dungeon.Info.INSTANCE.getDungeonList();
                  int $i$f$firstOrNull = false;
                  int var21 = 0;
                  int var22 = $this$firstOrNull$iv.length;

                  Tile var28;
                  while(true) {
                     if (var21 >= var22) {
                        var28 = null;
                        break;
                     }

                     Tile element$iv;
                     boolean var27;
                     label60: {
                        element$iv = $this$firstOrNull$iv[var21];
                        int var15 = false;
                        if (element$iv instanceof Room) {
                           Utils var26 = Utils.INSTANCE;
                           String var10001 = ((Room)element$iv).getData().getName();
                           Object[] var16 = new Object[]{"Lower Blaze", "Higher Blaze"};
                           if (var26.equalsOneOf(var10001, var16)) {
                              var27 = true;
                              break label60;
                           }
                        }

                        var27 = false;
                     }

                     if (var27) {
                        var28 = element$iv;
                        break;
                     }

                     ++var21;
                  }

                  if (var28 == null) {
                     return;
                  }

                  Tile room = var28;
                  PlayerTracker.INSTANCE.roomStateChange(room, room.getState(), RoomState.CLEARED);
                  room.setState(RoomState.CLEARED);
               }
            }
         }

      }
   }

   @SubscribeEvent
   public final void onEntityDeath(@NotNull LivingDeathEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      if (Location.INSTANCE.getInDungeons() && event.entity instanceof EntityZombie && !mimicKilled) {
         MimicDetector var10000 = MimicDetector.INSTANCE;
         Entity var10001 = event.entity;
         Intrinsics.checkNotNullExpressionValue(var10001, "entity");
         if (var10000.isMimic(var10001)) {
            MimicDetector.INSTANCE.setMimicKilled();
         }

      }
   }

   @SubscribeEvent
   public final void onTabList(@NotNull TabListEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      if (Location.INSTANCE.getInDungeons()) {
         Utils var10000 = Utils.INSTANCE;
         Action var10001 = event.getPacket().func_179768_b();
         Object[] var2 = new Object[]{Action.UPDATE_DISPLAY_NAME, Action.ADD_PLAYER};
         if (var10000.equalsOneOf(var10001, var2)) {
            List var10 = event.getPacket().func_179767_a();
            Intrinsics.checkNotNullExpressionValue(var10, "getEntries(...)");
            Iterable $this$forEach$iv = (Iterable)var10;
            int $i$f$forEach = false;
            Iterator var4 = $this$forEach$iv.iterator();

            while(var4.hasNext()) {
               String var12;
               label43: {
                  Object element$iv = var4.next();
                  AddPlayerData it = (AddPlayerData)element$iv;
                  int var7 = false;
                  if (it != null) {
                     IChatComponent var11 = it.func_179961_d();
                     if (var11 != null) {
                        var12 = var11.func_150254_d();
                        if (var12 != null) {
                           break label43;
                        }
                     }
                  }

                  label27: {
                     if (it != null) {
                        GameProfile var13 = it.func_179962_a();
                        if (var13 != null) {
                           var12 = var13.getName();
                           break label27;
                        }
                     }

                     var12 = null;
                  }

                  if (var12 == null) {
                     continue;
                  }
               }

               String text = var12;
               INSTANCE.updateFromTabList(text);
            }

            return;
         }
      }

   }

   private final void updateFromTabList(String text) {
      Integer var11;
      int var12;
      String var10000;
      if (StringsKt.contains$default((CharSequence)text, (CharSequence)"Team Deaths:", false, 2, (Object)null)) {
         label124: {
            var10000 = this.firstResult(deathsRegex, (CharSequence)text);
            if (var10000 != null) {
               var11 = StringsKt.toIntOrNull(var10000);
               if (var11 != null) {
                  var12 = var11;
                  break label124;
               }
            }

            var12 = deathCount;
         }

         deathCount = var12;
      } else {
         String puzzleName;
         Puzzle puzzle;
         Iterable var4;
         Iterator var5;
         Object var6;
         Puzzle it;
         boolean var8;
         Puzzle it;
         boolean var10;
         Object var13;
         Puzzle var14;
         Boolean var15;
         if (StringsKt.contains$default((CharSequence)text, (CharSequence)"✔", false, 2, (Object)null)) {
            var10000 = this.firstResult(solvedPuzzleRegex, (CharSequence)text);
            if (var10000 == null) {
               return;
            }

            puzzleName = var10000;
            if (Intrinsics.areEqual(puzzleName, "???")) {
               return;
            }

            var4 = (Iterable)Dungeon.Info.INSTANCE.getPuzzles().keySet();
            var5 = var4.iterator();

            while(true) {
               if (!var5.hasNext()) {
                  var13 = null;
                  break;
               }

               var6 = var5.next();
               it = (Puzzle)var6;
               var8 = false;
               if (Intrinsics.areEqual(it.getTabName(), puzzleName)) {
                  var13 = var6;
                  break;
               }
            }

            puzzle = (Puzzle)var13;
            if (puzzle == null) {
               if (Dungeon.Info.INSTANCE.getPuzzles().size() < totalPuzzles) {
                  var14 = Puzzle.Companion.fromName(puzzleName);
                  if (var14 != null) {
                     it = var14;
                     var10 = false;
                     var15 = (Boolean)Dungeon.Info.INSTANCE.getPuzzles().putIfAbsent(it, true);
                  }
               }
            } else {
               Dungeon.Info.INSTANCE.getPuzzles().put(puzzle, true);
            }
         } else if (StringsKt.contains$default((CharSequence)text, (CharSequence)"✖", false, 2, (Object)null)) {
            var10000 = this.firstResult(failedPuzzleRegex, (CharSequence)text);
            if (var10000 == null) {
               return;
            }

            puzzleName = var10000;
            if (Intrinsics.areEqual(puzzleName, "???")) {
               return;
            }

            var4 = (Iterable)Dungeon.Info.INSTANCE.getPuzzles().keySet();
            var5 = var4.iterator();

            while(true) {
               if (!var5.hasNext()) {
                  var13 = null;
                  break;
               }

               var6 = var5.next();
               it = (Puzzle)var6;
               var8 = false;
               if (Intrinsics.areEqual(it.getTabName(), puzzleName)) {
                  var13 = var6;
                  break;
               }
            }

            puzzle = (Puzzle)var13;
            if (puzzle == null) {
               if (Dungeon.Info.INSTANCE.getPuzzles().size() < totalPuzzles) {
                  var14 = Puzzle.Companion.fromName(puzzleName);
                  if (var14 != null) {
                     it = var14;
                     var10 = false;
                     var15 = (Boolean)Dungeon.Info.INSTANCE.getPuzzles().putIfAbsent(it, false);
                  }
               }
            } else {
               Dungeon.Info.INSTANCE.getPuzzles().put(puzzle, false);
            }
         } else if (StringsKt.contains$default((CharSequence)text, (CharSequence)"Crypts:", false, 2, (Object)null)) {
            label116: {
               var10000 = this.firstResult(cryptsPattern, (CharSequence)text);
               if (var10000 != null) {
                  var11 = StringsKt.toIntOrNull(var10000);
                  if (var11 != null) {
                     var12 = var11;
                     break label116;
                  }
               }

               var12 = cryptsCount;
            }

            cryptsCount = var12;
         } else if (StringsKt.contains$default((CharSequence)text, (CharSequence)"Secrets Found:", false, 2, (Object)null)) {
            if (StringsKt.contains$default((CharSequence)text, (CharSequence)"%", false, 2, (Object)null)) {
               float var17;
               label109: {
                  var10000 = this.firstResult(secretsFoundPercentagePattern, (CharSequence)text);
                  if (var10000 != null) {
                     Float var16 = StringsKt.toFloatOrNull(var10000);
                     if (var16 != null) {
                        var17 = var16 / 100.0F;
                        break label109;
                     }
                  }

                  var17 = secretPercentage;
               }

               secretPercentage = var17;
            } else {
               label104: {
                  var10000 = this.firstResult(secretsFoundPattern, (CharSequence)text);
                  if (var10000 != null) {
                     var11 = StringsKt.toIntOrNull(var10000);
                     if (var11 != null) {
                        var12 = var11;
                        break label104;
                     }
                  }

                  var12 = secretsFound;
               }

               secretsFound = var12;
            }
         } else if (StringsKt.contains$default((CharSequence)text, (CharSequence)"Completed Rooms", false, 2, (Object)null)) {
            label98: {
               var10000 = this.firstResult(roomCompletedPattern, (CharSequence)text);
               if (var10000 != null) {
                  var11 = StringsKt.toIntOrNull(var10000);
                  if (var11 != null) {
                     var12 = var11;
                     break label98;
                  }
               }

               var12 = completedRooms;
            }

            completedRooms = var12;
         }
      }

   }

   public final void updatePuzzleCount(@NotNull List<? extends Pair<? extends NetworkPlayerInfo, String>> tabList) {
      Intrinsics.checkNotNullParameter(tabList, "tabList");
      if (totalPuzzles == 0) {
         Iterable var3 = (Iterable)tabList;
         Iterator var4 = var3.iterator();

         Object var10000;
         while(true) {
            if (var4.hasNext()) {
               Object var5 = var4.next();
               Pair it = (Pair)var5;
               int var7 = false;
               if (!StringsKt.contains$default((CharSequence)it.getSecond(), (CharSequence)"Puzzles:", false, 2, (Object)null)) {
                  continue;
               }

               var10000 = var5;
               break;
            }

            var10000 = null;
            break;
         }

         Pair var8 = (Pair)var10000;
         if (var8 != null) {
            String var9 = (String)var8.getSecond();
            if (var9 != null) {
               int var11;
               label24: {
                  String puzzleCount = var9;
                  var9 = this.firstResult(puzzleCountRegex, (CharSequence)puzzleCount);
                  if (var9 != null) {
                     Integer var10 = StringsKt.toIntOrNull(var9);
                     if (var10 != null) {
                        var11 = var10;
                        break label24;
                     }
                  }

                  var11 = totalPuzzles;
               }

               totalPuzzles = var11;
               return;
            }
         }

      }
   }

   private final String firstResult(Regex $this$firstResult, CharSequence input) {
      MatchResult var10000 = $this$firstResult.matchEntire(input);
      String var5;
      if (var10000 != null) {
         MatchGroupCollection var3 = var10000.getGroups();
         if (var3 != null) {
            MatchGroup var4 = var3.get(1);
            if (var4 != null) {
               var5 = var4.getValue();
               return var5;
            }
         }
      }

      var5 = null;
      return var5;
   }
}
