package funnymap.core.map;

import funnymap.utils.Utils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"},
   d2 = {"Lfunnymap/core/map/Puzzle;", "", "", "roomDataName", "Ljava/lang/String;", "getRoomDataName", "()Ljava/lang/String;", "tabName", "getTabName", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "Companion", "BOMB_DEFUSE", "BOULDER", "CREEPER_BEAMS", "HIGHER_BLAZE", "ICE_FILL", "ICE_PATH", "LOWER_BLAZE", "QUIZ", "TELEPORT_MAZE", "THREE_WEIRDOS", "TIC_TAC_TOE", "WATER_BOARD", "FunnyMapExtras"}
)
public enum Puzzle {
   @NotNull
   public static final Puzzle.Companion Companion = new Puzzle.Companion((DefaultConstructorMarker)null);
   @NotNull
   private final String roomDataName;
   @NotNull
   private final String tabName;
   BOMB_DEFUSE("Bomb Defuse", (String)null, 2, (DefaultConstructorMarker)null),
   BOULDER("Boulder", (String)null, 2, (DefaultConstructorMarker)null),
   CREEPER_BEAMS("Creeper Beams", (String)null, 2, (DefaultConstructorMarker)null),
   HIGHER_BLAZE("Higher Blaze", "Higher Or Lower"),
   ICE_FILL("Ice Fill", (String)null, 2, (DefaultConstructorMarker)null),
   ICE_PATH("Ice Path", (String)null, 2, (DefaultConstructorMarker)null),
   LOWER_BLAZE("Lower Blaze", "Higher Or Lower"),
   QUIZ("Quiz", (String)null, 2, (DefaultConstructorMarker)null),
   TELEPORT_MAZE("Teleport Maze", (String)null, 2, (DefaultConstructorMarker)null),
   THREE_WEIRDOS("Three Weirdos", (String)null, 2, (DefaultConstructorMarker)null),
   TIC_TAC_TOE("Tic Tac Toe", (String)null, 2, (DefaultConstructorMarker)null),
   WATER_BOARD("Water Board", (String)null, 2, (DefaultConstructorMarker)null);

   // $FF: synthetic field
   private static final EnumEntries $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);

   private Puzzle(String roomDataName, String tabName) {
      this.roomDataName = roomDataName;
      this.tabName = tabName;
   }

   // $FF: synthetic method
   Puzzle(String var3, String var4, int var5, DefaultConstructorMarker var6) {
      if ((var5 & 2) != 0) {
         var4 = var3;
      }

      this(var3, var4);
   }

   @NotNull
   public final String getRoomDataName() {
      return this.roomDataName;
   }

   @NotNull
   public final String getTabName() {
      return this.tabName;
   }

   @NotNull
   public static EnumEntries<Puzzle> getEntries() {
      return $ENTRIES;
   }

   // $FF: synthetic method
   private static final Puzzle[] $values() {
      Puzzle[] var0 = new Puzzle[]{BOMB_DEFUSE, BOULDER, CREEPER_BEAMS, HIGHER_BLAZE, ICE_FILL, ICE_PATH, LOWER_BLAZE, QUIZ, TELEPORT_MAZE, THREE_WEIRDOS, TIC_TAC_TOE, WATER_BOARD};
      return var0;
   }

   @Metadata(
      mv = {1, 9, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"},
      d2 = {"Lfunnymap/core/map/Puzzle$Companion;", "", "", "name", "Lfunnymap/core/map/Puzzle;", "fromName", "(Ljava/lang/String;)Lfunnymap/core/map/Puzzle;", "<init>", "()V", "FunnyMapExtras"}
   )
   @SourceDebugExtension({"SMAP\nPuzzle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Puzzle.kt\nfunnymap/core/map/Puzzle$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,25:1\n1#2:26\n*E\n"})
   public static final class Companion {
      private Companion() {
      }

      @Nullable
      public final Puzzle fromName(@NotNull String name) {
         Intrinsics.checkNotNullParameter(name, "name");
         Iterable var2 = (Iterable)Puzzle.getEntries();
         Iterator var3 = var2.iterator();

         Object var10000;
         while(true) {
            if (var3.hasNext()) {
               Object var4 = var3.next();
               Puzzle it = (Puzzle)var4;
               int var6 = false;
               Utils var8 = Utils.INSTANCE;
               Object[] var7 = new Object[]{it.getRoomDataName(), it.getTabName()};
               if (!var8.equalsOneOf(name, var7)) {
                  continue;
               }

               var10000 = var4;
               break;
            }

            var10000 = null;
            break;
         }

         return (Puzzle)var10000;
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}
