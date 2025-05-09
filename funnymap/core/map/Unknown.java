package funnymap.core.map;

import java.awt.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0017"},
   d2 = {"Lfunnymap/core/map/Unknown;", "Lfunnymap/core/map/Tile;", "Ljava/awt/Color;", "color", "Ljava/awt/Color;", "getColor", "()Ljava/awt/Color;", "Lfunnymap/core/map/RoomState;", "state", "Lfunnymap/core/map/RoomState;", "getState", "()Lfunnymap/core/map/RoomState;", "setState", "(Lfunnymap/core/map/RoomState;)V", "", "x", "I", "getX", "()I", "z", "getZ", "<init>", "(II)V", "FunnyMapExtras"}
)
public final class Unknown implements Tile {
   private final int x;
   private final int z;
   @NotNull
   private final Color color;
   @NotNull
   private RoomState state;

   public Unknown(int x, int z) {
      this.x = x;
      this.z = z;
      this.color = new Color(0, 0, 0, 0);
      this.state = RoomState.UNDISCOVERED;
   }

   public int getX() {
      return this.x;
   }

   public int getZ() {
      return this.z;
   }

   @NotNull
   public Color getColor() {
      return this.color;
   }

   @NotNull
   public RoomState getState() {
      return this.state;
   }

   public void setState(@NotNull RoomState <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.state = var1;
   }
}
