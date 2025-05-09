package funnymap.core.map;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"},
   d2 = {"Lfunnymap/core/map/RoomState;", "", "<init>", "(Ljava/lang/String;I)V", "GREEN", "CLEARED", "FAILED", "DISCOVERED", "UNOPENED", "UNDISCOVERED", "FunnyMapExtras"}
)
public enum RoomState {
   GREEN,
   CLEARED,
   FAILED,
   DISCOVERED,
   UNOPENED,
   UNDISCOVERED;

   // $FF: synthetic field
   private static final EnumEntries $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);

   @NotNull
   public static EnumEntries<RoomState> getEntries() {
      return $ENTRIES;
   }

   // $FF: synthetic method
   private static final RoomState[] $values() {
      RoomState[] var0 = new RoomState[]{GREEN, CLEARED, FAILED, DISCOVERED, UNOPENED, UNDISCOVERED};
      return var0;
   }
}
