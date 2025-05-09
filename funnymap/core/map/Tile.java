package funnymap.core.map;

import java.awt.Color;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\u000b\u001a\u00020\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0012"},
   d2 = {"Lfunnymap/core/map/Tile;", "", "Ljava/awt/Color;", "getColor", "()Ljava/awt/Color;", "color", "Lfunnymap/core/map/RoomState;", "getState", "()Lfunnymap/core/map/RoomState;", "setState", "(Lfunnymap/core/map/RoomState;)V", "state", "", "getX", "()I", "x", "getZ", "z", "FunnyMapExtras"}
)
public interface Tile {
   int getX();

   int getZ();

   @NotNull
   RoomState getState();

   void setState(@NotNull RoomState var1);

   @NotNull
   Color getColor();
}
