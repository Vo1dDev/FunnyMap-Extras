package funnymap.core.map;

import funnymap.config.Config;
import funnymap.features.dungeon.MapRender;
import java.awt.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010 \u001a\u00020\u001b\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\"\u0010#R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001c\u001a\u00020\u001b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u001b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010\u001d\u001a\u0004\b!\u0010\u001f¨\u0006$"},
   d2 = {"Lfunnymap/core/map/Door;", "Lfunnymap/core/map/Tile;", "Ljava/awt/Color;", "getColor", "()Ljava/awt/Color;", "color", "", "opened", "Z", "getOpened", "()Z", "setOpened", "(Z)V", "Lfunnymap/core/map/RoomState;", "state", "Lfunnymap/core/map/RoomState;", "getState", "()Lfunnymap/core/map/RoomState;", "setState", "(Lfunnymap/core/map/RoomState;)V", "Lfunnymap/core/map/DoorType;", "type", "Lfunnymap/core/map/DoorType;", "getType", "()Lfunnymap/core/map/DoorType;", "setType", "(Lfunnymap/core/map/DoorType;)V", "", "x", "I", "getX", "()I", "z", "getZ", "<init>", "(IILfunnymap/core/map/DoorType;)V", "FunnyMapExtras"}
)
public final class Door implements Tile {
   private final int x;
   private final int z;
   @NotNull
   private DoorType type;
   private boolean opened;
   @NotNull
   private RoomState state;

   public Door(int x, int z, @NotNull DoorType type) {
      Intrinsics.checkNotNullParameter(type, "type");
      super();
      this.x = x;
      this.z = z;
      this.type = type;
      this.state = RoomState.UNDISCOVERED;
   }

   public int getX() {
      return this.x;
   }

   public int getZ() {
      return this.z;
   }

   @NotNull
   public final DoorType getType() {
      return this.type;
   }

   public final void setType(@NotNull DoorType <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.type = var1;
   }

   public final boolean getOpened() {
      return this.opened;
   }

   public final void setOpened(boolean <set-?>) {
      this.opened = var1;
   }

   @NotNull
   public RoomState getState() {
      return this.state;
   }

   public void setState(@NotNull RoomState <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.state = var1;
   }

   @NotNull
   public Color getColor() {
      Color var10000;
      if (MapRender.INSTANCE.getLegitRender() && this.getState() == RoomState.UNOPENED) {
         var10000 = Config.INSTANCE.getColorUnopenedDoor();
      } else {
         switch(Door.WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()]) {
         case 1:
            var10000 = Config.INSTANCE.getColorBloodDoor();
            break;
         case 2:
            var10000 = Config.INSTANCE.getColorEntranceDoor();
            break;
         case 3:
            var10000 = this.opened ? Config.INSTANCE.getColorOpenWitherDoor() : Config.INSTANCE.getColorWitherDoor();
            break;
         default:
            var10000 = Config.INSTANCE.getColorRoomDoor();
         }
      }

      return var10000;
   }

   // $FF: synthetic class
   @Metadata(
      mv = {1, 9, 0},
      k = 3,
      xi = 48
   )
   public class WhenMappings {
      // $FF: synthetic field
      public static final int[] $EnumSwitchMapping$0;

      static {
         int[] var0 = new int[DoorType.values().length];

         try {
            var0[DoorType.BLOOD.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[DoorType.ENTRANCE.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[DoorType.WITHER.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
