package funnymap.utils;

import funnymap.FunnyMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Team;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"},
   d2 = {"Lfunnymap/utils/Scoreboard;", "", "", "scoreboard", "cleanLine", "(Ljava/lang/String;)Ljava/lang/String;", "", "getLines", "()Ljava/util/List;", "<init>", "()V", "FunnyMapExtras"}
)
@SourceDebugExtension({"SMAP\nScoreboard.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Scoreboard.kt\nfunnymap/utils/Scoreboard\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,19:1\n429#2:20\n502#2,5:21\n766#3:26\n857#3,2:27\n1549#3:30\n1620#3,3:31\n1#4:29\n*S KotlinDebug\n*F\n+ 1 Scoreboard.kt\nfunnymap/utils/Scoreboard\n*L\n8#1:20\n8#1:21,5\n13#1:26\n13#1:27,2\n15#1:30\n15#1:31,3\n*E\n"})
public final class Scoreboard {
   @NotNull
   public static final Scoreboard INSTANCE = new Scoreboard();

   private Scoreboard() {
   }

   @NotNull
   public final String cleanLine(@NotNull String scoreboard) {
      Intrinsics.checkNotNullParameter(scoreboard, "scoreboard");
      String $this$filter$iv = Utils.INSTANCE.removeFormatting(scoreboard);
      int $i$f$filter = false;
      CharSequence $this$filterTo$iv$iv = (CharSequence)$this$filter$iv;
      Appendable destination$iv$iv = (Appendable)(new StringBuilder());
      int $i$f$filterTo = false;
      int index$iv$iv = 0;

      for(int var8 = $this$filterTo$iv$iv.length(); index$iv$iv < var8; ++index$iv$iv) {
         char element$iv$iv = $this$filterTo$iv$iv.charAt(index$iv$iv);
         int var11 = false;
         if (' ' <= element$iv$iv ? element$iv$iv < 127 : false) {
            destination$iv$iv.append(element$iv$iv);
         }
      }

      String var10000 = ((StringBuilder)destination$iv$iv).toString();
      Intrinsics.checkNotNullExpressionValue(var10000, "toString(...)");
      return var10000;
   }

   @NotNull
   public final List<String> getLines() {
      WorldClient var10000 = FunnyMap.INSTANCE.getMc().field_71441_e;
      List var17;
      if (var10000 != null) {
         net.minecraft.scoreboard.Scoreboard var16 = var10000.func_96441_U();
         if (var16 != null) {
            net.minecraft.scoreboard.Scoreboard $this$getLines_u24lambda_u244 = var16;
            int var2 = false;
            ScoreObjective var3 = $this$getLines_u24lambda_u244.func_96539_a(1);
            if (var3 == null) {
               return CollectionsKt.emptyList();
            }

            Intrinsics.checkNotNull(var3);
            Collection var18 = $this$getLines_u24lambda_u244.func_96534_i(var3);
            Intrinsics.checkNotNullExpressionValue(var18, "getSortedScores(...)");
            Iterable $this$map$iv = (Iterable)var18;
            int $i$f$map = false;
            Collection destination$iv$iv = (Collection)(new ArrayList());
            int $i$f$mapTo = false;
            Iterator var8 = $this$map$iv.iterator();

            Object element$iv$iv;
            Score it;
            boolean var11;
            while(var8.hasNext()) {
               boolean var19;
               label44: {
                  element$iv$iv = var8.next();
                  it = (Score)element$iv$iv;
                  var11 = false;
                  if (it != null) {
                     String var12 = it.func_96653_e();
                     if (var12 != null) {
                        Intrinsics.checkNotNull(var12);
                        var19 = !StringsKt.startsWith$default(var12, "#", false, 2, (Object)null);
                        break label44;
                     }
                  }

                  var19 = false;
               }

               if (var19) {
                  destination$iv$iv.add(element$iv$iv);
               }
            }

            List it = (List)destination$iv$iv;
            int var5 = false;
            $this$map$iv = (Iterable)(it.size() > 15 ? CollectionsKt.drop((Iterable)it, 15) : it);
            $i$f$map = false;
            destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10)));
            $i$f$mapTo = false;
            var8 = $this$map$iv.iterator();

            while(var8.hasNext()) {
               element$iv$iv = var8.next();
               it = (Score)element$iv$iv;
               var11 = false;
               destination$iv$iv.add(ScorePlayerTeam.func_96667_a((Team)$this$getLines_u24lambda_u244.func_96509_i(it.func_96653_e()), it.func_96653_e()));
            }

            var17 = (List)destination$iv$iv;
            return var17;
         }
      }

      var17 = CollectionsKt.emptyList();
      return var17;
   }
}
