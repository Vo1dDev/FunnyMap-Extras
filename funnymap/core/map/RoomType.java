package funnymap.core.map;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"},
   d2 = {"Lfunnymap/core/map/RoomType;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "BLOOD", "CHAMPION", "ENTRANCE", "FAIRY", "NORMAL", "PUZZLE", "RARE", "TRAP", "FunnyMapExtras"}
)
public enum RoomType {
   @NotNull
   public static final RoomType.Companion Companion = new RoomType.Companion((DefaultConstructorMarker)null);
   BLOOD,
   CHAMPION,
   ENTRANCE,
   FAIRY,
   NORMAL,
   PUZZLE,
   RARE,
   TRAP;

   // $FF: synthetic field
   private static final EnumEntries $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);

   @NotNull
   public static EnumEntries<RoomType> getEntries() {
      return $ENTRIES;
   }

   // $FF: synthetic method
   private static final RoomType[] $values() {
      RoomType[] var0 = new RoomType[]{BLOOD, CHAMPION, ENTRANCE, FAIRY, NORMAL, PUZZLE, RARE, TRAP};
      return var0;
   }

   @Metadata(
      mv = {1, 9, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"},
      d2 = {"Lfunnymap/core/map/RoomType$Companion;", "", "", "color", "Lfunnymap/core/map/RoomType;", "fromMapColor", "(I)Lfunnymap/core/map/RoomType;", "<init>", "()V", "FunnyMapExtras"}
   )
   public static final class Companion {
      private Companion() {
      }

      @Nullable
      public final RoomType fromMapColor(int color) {
         RoomType var10000;
         switch(color) {
         case 18:
            var10000 = RoomType.BLOOD;
            break;
         case 30:
            var10000 = RoomType.ENTRANCE;
            break;
         case 62:
            var10000 = RoomType.TRAP;
            break;
         case 63:
         case 85:
            var10000 = RoomType.NORMAL;
            break;
         case 66:
            var10000 = RoomType.PUZZLE;
            break;
         case 74:
            var10000 = RoomType.CHAMPION;
            break;
         case 82:
            var10000 = RoomType.FAIRY;
            break;
         default:
            var10000 = null;
         }

         return var10000;
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}
