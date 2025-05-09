package funnymap.features.dungeon;

import funnymap.FunnyMap;
import funnymap.core.DungeonPlayer;
import funnymap.core.RoomData;
import funnymap.core.map.Room;
import funnymap.core.map.RoomState;
import funnymap.core.map.RoomType;
import funnymap.core.map.Tile;
import funnymap.utils.APIUtils;
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
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.Ref.LongRef;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlin.time.Duration.Companion;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import net.minecraft.event.HoverEvent;
import net.minecraft.event.HoverEvent.Action;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.IChatComponent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001c\u0010\rJ%\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014R)\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00170\u00158\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"},
   d2 = {"Lfunnymap/features/dungeon/PlayerTracker;", "", "", "name", "Lfunnymap/core/DungeonPlayer;", "player", "", "secrets", "Lnet/minecraft/util/IChatComponent;", "getStatMessage", "(Ljava/lang/String;Lfunnymap/core/DungeonPlayer;I)Lnet/minecraft/util/IChatComponent;", "", "onDungeonEnd", "()V", "Lfunnymap/core/map/Tile;", "room", "Lfunnymap/core/map/RoomState;", "state", "newState", "roomStateChange", "(Lfunnymap/core/map/Tile;Lfunnymap/core/map/RoomState;Lfunnymap/core/map/RoomState;)V", "", "Lfunnymap/core/RoomData;", "", "roomClears", "Ljava/util/Map;", "getRoomClears", "()Ljava/util/Map;", "<init>", "FunnyMapExtras"}
)
@SourceDebugExtension({"SMAP\nPlayerTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayerTracker.kt\nfunnymap/features/dungeon/PlayerTracker\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,126:1\n125#2:127\n152#2,3:128\n215#2,2:138\n766#3:131\n857#3,2:132\n1549#3:134\n1620#3,3:135\n766#3:154\n857#3,2:155\n1477#3:157\n1502#3,3:158\n1505#3,3:168\n526#4:140\n511#4,6:141\n526#4:147\n511#4,6:148\n372#4,7:161\n*S KotlinDebug\n*F\n+ 1 PlayerTracker.kt\nfunnymap/features/dungeon/PlayerTracker\n*L\n31#1:127\n31#1:128,3\n39#1:138,2\n33#1:131\n33#1:132,2\n33#1:134\n33#1:135,3\n74#1:154\n74#1:155,2\n110#1:157\n110#1:158,3\n110#1:168,3\n64#1:140\n64#1:141,6\n65#1:147\n65#1:148,6\n110#1:161,7\n*E\n"})
public final class PlayerTracker {
   @NotNull
   public static final PlayerTracker INSTANCE = new PlayerTracker();
   @NotNull
   private static final Map<RoomData, Set<String>> roomClears = (Map)(new LinkedHashMap());

   private PlayerTracker() {
   }

   @NotNull
   public final Map<RoomData, Set<String>> getRoomClears() {
      return roomClears;
   }

   public final void roomStateChange(@NotNull Tile room, @NotNull RoomState state, @NotNull RoomState newState) {
      Intrinsics.checkNotNullParameter(room, "room");
      Intrinsics.checkNotNullParameter(state, "state");
      Intrinsics.checkNotNullParameter(newState, "newState");
      if (room instanceof Room) {
         Utils var10000 = Utils.INSTANCE;
         Object[] var4 = new Object[]{RoomState.CLEARED, RoomState.GREEN};
         if (var10000.equalsOneOf(newState, var4) && state != RoomState.CLEARED) {
            Map $this$map$iv = Dungeon.INSTANCE.getDungeonTeammates();
            int $i$f$map = false;
            Collection destination$iv$iv = (Collection)(new ArrayList($this$map$iv.size()));
            int $i$f$mapTo = false;
            Iterator var10 = $this$map$iv.entrySet().iterator();

            while(var10.hasNext()) {
               Entry item$iv$iv = (Entry)var10.next();
               int var13 = false;
               destination$iv$iv.add(new Pair(((DungeonPlayer)item$iv$iv.getValue()).getFormattedName(), ((DungeonPlayer)item$iv$iv.getValue()).getCurrentRoom()));
            }

            List currentRooms = (List)destination$iv$iv;
            $this$map$iv = roomClears;
            RoomData var18 = ((Room)room).getData();
            Iterable $this$map$iv = (Iterable)currentRooms;
            int $i$f$map = false;
            Collection destination$iv$iv = (Collection)(new ArrayList());
            int $i$f$mapTo = false;
            Iterator var12 = $this$map$iv.iterator();

            Pair it;
            boolean var15;
            Object item$iv$iv;
            while(var12.hasNext()) {
               item$iv$iv = var12.next();
               it = (Pair)item$iv$iv;
               var15 = false;
               if (!Intrinsics.areEqual(it.getFirst(), "") && Intrinsics.areEqual(it.getSecond(), ((Room)room).getData().getName())) {
                  destination$iv$iv.add(item$iv$iv);
               }
            }

            $this$map$iv = (Iterable)((List)destination$iv$iv);
            $i$f$map = false;
            destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10)));
            $i$f$mapTo = false;
            var12 = $this$map$iv.iterator();

            while(var12.hasNext()) {
               item$iv$iv = var12.next();
               it = (Pair)item$iv$iv;
               var15 = false;
               destination$iv$iv.add((String)it.getFirst());
            }

            Set var19 = CollectionsKt.toSet((Iterable)((List)destination$iv$iv));
            $this$map$iv.put(var18, var19);
         }

      }
   }

   public final void onDungeonEnd() {
      long time = System.currentTimeMillis() - Dungeon.Info.INSTANCE.getStartTime();
      Map $this$forEach$iv = Dungeon.INSTANCE.getDungeonTeammates();
      int $i$f$forEach = false;
      Iterator var5 = $this$forEach$iv.entrySet().iterator();

      while(var5.hasNext()) {
         Entry element$iv = (Entry)var5.next();
         int var8 = false;
         ((DungeonPlayer)element$iv.getValue()).getRoomVisits().add(new Pair(time - ((DungeonPlayer)element$iv.getValue()).getLastTime(), ((DungeonPlayer)element$iv.getValue()).getLastRoom()));
      }

      BuildersKt.launch$default(FunnyMap.INSTANCE.getScope(), (CoroutineContext)null, (CoroutineStart)null, (Function2)(new Function2<CoroutineScope, Continuation<? super Unit>, Object>((Continuation)null) {
         Object L$1;
         Object L$2;
         int label;
         // $FF: synthetic field
         private Object L$0;

         @Nullable
         public final Object invokeSuspend(@NotNull Object $result) {
            Object var17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            boolean $i$f$forEach;
            Collection destination$iv$iv;
            boolean $i$f$mapTo;
            Iterator var8;
            boolean var11;
            Triple var12;
            String name;
            DungeonPlayer playerx;
            int secrets;
            Iterable $this$forEach$iv;
            switch(this.label) {
            case 0:
               ResultKt.throwOnFailure($result);
               CoroutineScope $this$launch = (CoroutineScope)this.L$0;
               Map $this$map$iv = Dungeon.INSTANCE.getDungeonTeammates();
               $i$f$forEach = false;
               destination$iv$iv = (Collection)(new ArrayList($this$map$iv.size()));
               $i$f$mapTo = false;
               var8 = $this$map$iv.entrySet().iterator();

               while(var8.hasNext()) {
                  Entry item$iv$iv = (Entry)var8.next();
                  var11 = false;
                  final DungeonPlayer player = (DungeonPlayer)item$iv$iv.getValue();
                  destination$iv$iv.add(BuildersKt.async$default($this$launch, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, (Function2)(new Function2<CoroutineScope, Continuation<? super Triple<? extends String, ? extends DungeonPlayer, ? extends Integer>>, Object>((Continuation)null) {
                     int label;

                     @Nullable
                     public final Object invokeSuspend(@NotNull Object $result) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch(this.label) {
                        case 0:
                           ResultKt.throwOnFailure(var1);
                           return new Triple(player.getFormattedName(), player, Boxing.boxInt(APIUtils.INSTANCE.getSecrets(player.getUuid())));
                        default:
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                     }

                     @NotNull
                     public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                        return (Continuation)(new <anonymous constructor>($completion));
                     }

                     @Nullable
                     public final Object invoke(@NotNull CoroutineScope p1, @Nullable Continuation<? super Triple<String, DungeonPlayer, Integer>> p2) {
                        return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                     }
                  }), 2, (Object)null));
               }

               $this$forEach$iv = (Iterable)((List)destination$iv$iv);
               $i$f$forEach = false;
               destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($this$forEach$iv, 10)));
               $i$f$mapTo = false;
               var8 = $this$forEach$iv.iterator();
               break;
            case 1:
               $i$f$forEach = false;
               $i$f$mapTo = false;
               var11 = false;
               Collection var16 = (Collection)this.L$2;
               var8 = (Iterator)this.L$1;
               destination$iv$iv = (Collection)this.L$0;
               ResultKt.throwOnFailure($result);
               var12 = (Triple)$result;
               name = (String)var12.component1();
               playerx = (DungeonPlayer)var12.component2();
               secrets = ((Number)var12.component3()).intValue();
               var16.add(PlayerTracker.INSTANCE.getStatMessage(name, playerx, secrets));
               break;
            default:
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            while(var8.hasNext()) {
               Object item$iv$ivx = var8.next();
               Deferred it = (Deferred)item$iv$ivx;
               var11 = false;
               this.L$0 = destination$iv$iv;
               this.L$1 = var8;
               this.L$2 = destination$iv$iv;
               this.label = 1;
               Object var10000 = it.await(this);
               if (var10000 == var17) {
                  return var17;
               }

               var12 = (Triple)var10000;
               name = (String)var12.component1();
               playerx = (DungeonPlayer)var12.component2();
               secrets = ((Number)var12.component3()).intValue();
               destination$iv$iv.add(PlayerTracker.INSTANCE.getStatMessage(name, playerx, secrets));
            }

            $this$forEach$iv = (Iterable)((List)destination$iv$iv);
            $i$f$forEach = false;
            Iterator var5 = $this$forEach$iv.iterator();

            while(var5.hasNext()) {
               Object element$iv = var5.next();
               IChatComponent itx = (IChatComponent)element$iv;
               int var22 = false;
               FunnyMap.INSTANCE.getMc().field_71439_g.func_145747_a(itx);
            }

            return Unit.INSTANCE;
         }

         @NotNull
         public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
            Function2 var3 = new <anonymous constructor>($completion);
            var3.L$0 = value;
            return (Continuation)var3;
         }

         @Nullable
         public final Object invoke(@NotNull CoroutineScope p1, @Nullable Continuation<? super Unit> p2) {
            return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
         }
      }), 3, (Object)null);
   }

   @NotNull
   public final IChatComponent getStatMessage(@NotNull String name, @NotNull DungeonPlayer player, int secrets) {
      Intrinsics.checkNotNullParameter(name, "name");
      Intrinsics.checkNotNullParameter(player, "player");
      ChatComponentText secretsComponent = new ChatComponentText("§b" + (secrets - player.getStartingSecrets()) + " §3secrets");
      Map $this$filter$iv = roomClears;
      int $i$f$filter = false;
      Map destination$iv$iv = (Map)(new LinkedHashMap());
      int $i$f$filterTo = false;
      Iterator var11 = $this$filter$iv.entrySet().iterator();

      boolean var14;
      while(var11.hasNext()) {
         Entry element$iv$iv = (Entry)var11.next();
         var14 = false;
         if (((Set)element$iv$iv.getValue()).contains(name)) {
            destination$iv$iv.put(element$iv$iv.getKey(), element$iv$iv.getValue());
         }
      }

      int $i$f$filter = false;
      Map destination$iv$iv = (Map)(new LinkedHashMap());
      int $i$f$filterTo = false;
      Iterator var49 = destination$iv$iv.entrySet().iterator();

      boolean var15;
      while(var49.hasNext()) {
         Entry element$iv$iv = (Entry)var49.next();
         var15 = false;
         if (((Set)element$iv$iv.getValue()).size() == 1) {
            destination$iv$iv.put(element$iv$iv.getKey(), element$iv$iv.getValue());
         }
      }

      int max = destination$iv$iv.size();
      int min = destination$iv$iv.size();
      ChatComponentText var46 = new ChatComponentText("§b" + (destination$iv$iv.size() != destination$iv$iv.size() ? "" + min + '-' + max : max) + " §3rooms cleared");
      int var50 = false;
      ChatStyle var10001 = new ChatStyle();
      Action var10002 = Action.SHOW_TEXT;
      PlayerTracker var10003 = INSTANCE;
      Iterable $this$filter$iv = (Iterable)roomClears.entrySet();
      Action var16 = var10002;
      ChatStyle var17 = var10001;
      int $i$f$filter = false;
      Collection destination$iv$iv = (Collection)(new ArrayList());
      int $i$f$groupBy = false;
      Iterator var23 = $this$filter$iv.iterator();

      while(var23.hasNext()) {
         Object element$iv$iv = var23.next();
         Entry it = (Entry)element$iv$iv;
         int var26 = false;
         Utils var10000 = Utils.INSTANCE;
         RoomType var57 = ((RoomData)it.getKey()).getType();
         Object[] var27 = new Object[]{RoomType.BLOOD, RoomType.ENTRANCE, RoomType.FAIRY};
         if (!var10000.equalsOneOf(var57, var27) && ((Set)it.getValue()).contains(name)) {
            destination$iv$iv.add(element$iv$iv);
         }
      }

      List list$iv$iv = (List)destination$iv$iv;
      String var36 = CollectionsKt.joinToString$default((Iterable)list$iv$iv, (CharSequence)"\n", (CharSequence)(name + "'s §eRooms Cleared:\n"), (CharSequence)null, 0, (CharSequence)null, (Function1)(new Function1<Entry<RoomData, Set<? extends String>>, CharSequence>() {
         @NotNull
         public final CharSequence invoke(@NotNull Entry<RoomData, Set<String>> var1) {
            Intrinsics.checkNotNullParameter(var1, "<name for destructuring parameter 0>");
            RoomData room = (RoomData)var1.getKey();
            Set players = (Set)var1.getValue();
            CharSequence var10000;
            if (players.size() == 1) {
               var10000 = (CharSequence)("§6" + room.getName());
            } else {
               StringBuilder var15 = (new StringBuilder()).append("§6").append(room.getName()).append(" §7with ");
               Iterable $this$filter$iv = (Iterable)players;
               String var5 = name;
               StringBuilder var14 = var15;
               int $i$f$filter = false;
               Collection destination$iv$iv = (Collection)(new ArrayList());
               int $i$f$filterTo = false;
               Iterator var10 = $this$filter$iv.iterator();

               while(var10.hasNext()) {
                  Object element$iv$iv = var10.next();
                  String it = (String)element$iv$iv;
                  int var13 = false;
                  if (!Intrinsics.areEqual(it, var5)) {
                     destination$iv$iv.add(element$iv$iv);
                  }
               }

               var10000 = (CharSequence)var14.append(CollectionsKt.joinToString$default((Iterable)((List)destination$iv$iv), (CharSequence)"§r, ", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null, 62, (Object)null)).toString();
            }

            return var10000;
         }
      }), 28, (Object)null);
      IChatComponent var37 = (IChatComponent)(new ChatComponentText(var36));
      var46.func_150255_a(var17.func_150209_a(new HoverEvent(var16, var37)));
      ChatComponentText roomComponent = var46;
      final LongRef lastTime = new LongRef();
      ChatComponentText var51 = new ChatComponentText("§3Splits");
      var14 = false;
      var51.func_150255_a((new ChatStyle()).func_150209_a(new HoverEvent(Action.SHOW_TEXT, (IChatComponent)(new ChatComponentText(CollectionsKt.joinToString$default((Iterable)player.getRoomVisits(), (CharSequence)"\n", (CharSequence)(name + "'s §eRoom Splits:\n"), (CharSequence)null, 0, (CharSequence)null, (Function1)(new Function1<Pair<? extends Long, ? extends String>, CharSequence>() {
         @NotNull
         public final CharSequence invoke(@NotNull Pair<Long, String> var1) {
            Intrinsics.checkNotNullParameter(var1, "<name for destructuring parameter 0>");
            long elapsed = ((Number)var1.component1()).longValue();
            String room = (String)var1.component2();
            Companion var10000 = Duration.Companion;
            long start = DurationKt.toDuration(lastTime.element, DurationUnit.MILLISECONDS);
            lastTime.element += elapsed;
            var10000 = Duration.Companion;
            long end = DurationKt.toDuration(lastTime.element, DurationUnit.MILLISECONDS);
            return (CharSequence)("§b" + Duration.toString-impl(start) + " §7- §b" + Duration.toString-impl(end) + " §6" + room);
         }
      }), 28, (Object)null))))));
      ChatComponentText var53 = new ChatComponentText("§3Times");
      var15 = false;
      var10001 = new ChatStyle();
      var10002 = Action.SHOW_TEXT;
      Iterable $this$groupBy$iv = (Iterable)player.getRoomVisits();
      Action var56 = var10002;
      ChatStyle var20 = var10001;
      $i$f$groupBy = false;
      Map destination$iv$iv = (Map)(new LinkedHashMap());
      int $i$f$groupByTo = false;
      Iterator var61 = $this$groupBy$iv.iterator();

      while(var61.hasNext()) {
         Object element$iv$iv = var61.next();
         Pair it = (Pair)element$iv$iv;
         int var29 = false;
         Object key$iv$iv = (String)it.getSecond();
         int $i$f$getOrPut = false;
         Object value$iv$iv$iv = destination$iv$iv.get(key$iv$iv);
         Object var55;
         if (value$iv$iv$iv == null) {
            int var34 = false;
            Object answer$iv$iv$iv = (List)(new ArrayList());
            destination$iv$iv.put(key$iv$iv, answer$iv$iv$iv);
            var55 = answer$iv$iv$iv;
         } else {
            var55 = value$iv$iv$iv;
         }

         list$iv$iv = (List)var55;
         list$iv$iv.add(element$iv$iv);
      }

      String var39 = CollectionsKt.joinToString$default((Iterable)destination$iv$iv.entrySet(), (CharSequence)"\n", (CharSequence)(name + "'s §eRoom Times:\n"), (CharSequence)null, 0, (CharSequence)null, (Function1)null.INSTANCE, 28, (Object)null);
      IChatComponent var40 = (IChatComponent)(new ChatComponentText(var39));
      var53.func_150255_a(var20.func_150209_a(new HoverEvent(var56, var40)));
      IChatComponent var58 = (new ChatComponentText(FunnyMap.INSTANCE.getCHAT_PREFIX() + " §3" + name + " §f> ")).func_150257_a((IChatComponent)secretsComponent).func_150258_a(" §6| ").func_150257_a((IChatComponent)roomComponent).func_150258_a(" §6| ").func_150257_a((IChatComponent)var51).func_150258_a(" §6| ").func_150257_a((IChatComponent)var53);
      Intrinsics.checkNotNullExpressionValue(var58, "appendSibling(...)");
      return var58;
   }
}
