package funnymap.config;

import gg.essential.vigilance.data.Category;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(
   mv = {1, 9, 0},
   k = 3,
   xi = 48,
   d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"},
   d2 = {"T", "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2", "<anonymous>"}
)
@SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n+ 2 Config.kt\nfunnymap/config/Config$CategorySorting\n*L\n1#1,328:1\n913#2:329\n*E\n"})
public final class Config$CategorySorting$getCategoryComparator$$inlined$compareBy$1<T> implements Comparator {
   public final int compare(T a, T b) {
      Category it = (Category)a;
      int var4 = false;
      Comparable var10000 = (Comparable)Config.CategorySorting.access$getConfigCategories$p().indexOf(it.getName());
      it = (Category)b;
      Comparable var5 = var10000;
      var4 = false;
      return ComparisonsKt.compareValues(var5, (Comparable)Config.CategorySorting.access$getConfigCategories$p().indexOf(it.getName()));
   }
}
