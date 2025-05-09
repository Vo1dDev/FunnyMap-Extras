package funnymap.utils;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import funnymap.FunnyMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.world.WorldSettings.GameType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0006\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002¢\u0006\u0004\b\b\u0010\u0007R8\u0010\u000b\u001a&\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00040\u0004 \n*\u0012\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\t0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"},
   d2 = {"Lfunnymap/utils/TabList;", "", "", "Lkotlin/Pair;", "Lnet/minecraft/client/network/NetworkPlayerInfo;", "", "getDungeonTabList", "()Ljava/util/List;", "getTabList", "Lcom/google/common/collect/Ordering;", "kotlin.jvm.PlatformType", "tabListOrder", "Lcom/google/common/collect/Ordering;", "<init>", "()V", "FunnyMapExtras"}
)
@SourceDebugExtension({"SMAP\nTabList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TabList.kt\nfunnymap/utils/TabList\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,30:1\n1#2:31\n1549#3:32\n1620#3,3:33\n*S KotlinDebug\n*F\n+ 1 TabList.kt\nfunnymap/utils/TabList\n*L\n23#1:32\n23#1:33,3\n*E\n"})
public final class TabList {
   @NotNull
   public static final TabList INSTANCE = new TabList();
   private static final Ordering<NetworkPlayerInfo> tabListOrder = Ordering.from(TabList::tabListOrder$lambda$0);

   private TabList() {
   }

   @NotNull
   public final List<Pair<NetworkPlayerInfo, String>> getTabList() {
      EntityPlayerSP var1 = FunnyMap.INSTANCE.getMc().field_71439_g;
      List var10000;
      if (var1 != null) {
         NetHandlerPlayClient var2 = var1.field_71174_a;
         if (var2 != null) {
            Collection var3 = var2.func_175106_d();
            if (var3 != null) {
               int $i$f$map = false;
               ImmutableList var4 = tabListOrder.immutableSortedCopy((Iterable)var3);
               if (var4 != null) {
                  Iterable $this$map$iv = (Iterable)var4;
                  $i$f$map = false;
                  Collection destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10)));
                  int $i$f$mapTo = false;
                  Iterator var10 = $this$map$iv.iterator();

                  while(var10.hasNext()) {
                     Object item$iv$iv = var10.next();
                     NetworkPlayerInfo it = (NetworkPlayerInfo)item$iv$iv;
                     int var13 = false;
                     destination$iv$iv.add(new Pair(it, FunnyMap.INSTANCE.getMc().field_71456_v.func_175181_h().func_175243_a(it)));
                  }

                  var10000 = (List)destination$iv$iv;
                  return var10000;
               }
            }
         }
      }

      var10000 = CollectionsKt.emptyList();
      return var10000;
   }

   @Nullable
   public final List<Pair<NetworkPlayerInfo, String>> getDungeonTabList() {
      List it = this.getTabList();
      int var2 = false;
      return it.size() > 18 && StringsKt.contains$default((CharSequence)((Pair)it.get(0)).getSecond(), (CharSequence)"§r§b§lParty §r§f(", false, 2, (Object)null) ? it : null;
   }

   private static final int tabListOrder$lambda$0(NetworkPlayerInfo o1, NetworkPlayerInfo o2) {
      if (o1 == null) {
         return -1;
      } else if (o2 == null) {
         return 0;
      } else {
         ComparisonChain var10000 = ComparisonChain.start().compareTrueFirst(o1.func_178848_b() != GameType.SPECTATOR, o2.func_178848_b() != GameType.SPECTATOR);
         ScorePlayerTeam var10001 = o1.func_178850_i();
         String var2 = var10001 != null ? var10001.func_96661_b() : null;
         if (var2 == null) {
            var2 = "";
         }

         Comparable var3 = (Comparable)var2;
         ScorePlayerTeam var10002 = o2.func_178850_i();
         String var4 = var10002 != null ? var10002.func_96661_b() : null;
         if (var4 == null) {
            var4 = "";
         }

         return var10000.compare(var3, (Comparable)var4).compare((Comparable)o1.func_178845_a().getName(), (Comparable)o2.func_178845_a().getName()).result();
      }
   }
}
