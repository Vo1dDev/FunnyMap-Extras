package funnymap.core.map;

import funnymap.config.Config;
import funnymap.core.RoomData;
import funnymap.features.dungeon.MapRender;
import java.awt.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010(\u001a\u00020\u0006\u0012\u0006\u0010*\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b,\u0010-R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b(\u0010\b\u001a\u0004\b)\u0010\nR\u001a\u0010*\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b*\u0010\b\u001a\u0004\b+\u0010\n¨\u0006."},
   d2 = {"Lfunnymap/core/map/Room;", "Lfunnymap/core/map/Tile;", "Ljava/awt/Color;", "getColor", "()Ljava/awt/Color;", "color", "", "core", "I", "getCore", "()I", "setCore", "(I)V", "Lfunnymap/core/RoomData;", "data", "Lfunnymap/core/RoomData;", "getData", "()Lfunnymap/core/RoomData;", "setData", "(Lfunnymap/core/RoomData;)V", "", "isSeparator", "Z", "()Z", "setSeparator", "(Z)V", "Lfunnymap/core/map/RoomState;", "state", "Lfunnymap/core/map/RoomState;", "getState", "()Lfunnymap/core/map/RoomState;", "setState", "(Lfunnymap/core/map/RoomState;)V", "Lfunnymap/core/map/UniqueRoom;", "uniqueRoom", "Lfunnymap/core/map/UniqueRoom;", "getUniqueRoom", "()Lfunnymap/core/map/UniqueRoom;", "setUniqueRoom", "(Lfunnymap/core/map/UniqueRoom;)V", "x", "getX", "z", "getZ", "<init>", "(IILfunnymap/core/RoomData;)V", "FunnyMapExtras"}
)
public final class Room implements Tile {
   private final int x;
   private final int z;
   @NotNull
   private RoomData data;
   private int core;
   private boolean isSeparator;
   @Nullable
   private UniqueRoom uniqueRoom;
   @NotNull
   private RoomState state;

   public Room(int x, int z, @NotNull RoomData data) {
      Intrinsics.checkNotNullParameter(data, "data");
      super();
      this.x = x;
      this.z = z;
      this.data = data;
      this.state = RoomState.UNDISCOVERED;
   }

   public int getX() {
      return this.x;
   }

   public int getZ() {
      return this.z;
   }

   @NotNull
   public final RoomData getData() {
      return this.data;
   }

   public final void setData(@NotNull RoomData <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.data = var1;
   }

   public final int getCore() {
      return this.core;
   }

   public final void setCore(int <set-?>) {
      this.core = var1;
   }

   public final boolean isSeparator() {
      return this.isSeparator;
   }

   public final void setSeparator(boolean <set-?>) {
      this.isSeparator = var1;
   }

   @Nullable
   public final UniqueRoom getUniqueRoom() {
      return this.uniqueRoom;
   }

   public final void setUniqueRoom(@Nullable UniqueRoom <set-?>) {
      this.uniqueRoom = var1;
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
         var10000 = Config.INSTANCE.getColorUnopened();
      } else {
         switch(Room.WhenMappings.$EnumSwitchMapping$0[this.data.getType().ordinal()]) {
         case 1:
            var10000 = Config.INSTANCE.getColorBlood();
            break;
         case 2:
            var10000 = Config.INSTANCE.getColorMiniboss();
            break;
         case 3:
            var10000 = Config.INSTANCE.getColorEntrance();
            break;
         case 4:
            var10000 = Config.INSTANCE.getColorFairy();
            break;
         case 5:
            var10000 = Config.INSTANCE.getColorPuzzle();
            break;
         case 6:
            var10000 = Config.INSTANCE.getColorRare();
            break;
         case 7:
            var10000 = Config.INSTANCE.getColorTrap();
            break;
         default:
            UniqueRoom var1 = this.uniqueRoom;
            var10000 = (var1 != null ? var1.getHasMimic() : false) ? Config.INSTANCE.getColorRoomMimic() : Config.INSTANCE.getColorRoom();
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
         int[] var0 = new int[RoomType.values().length];

         try {
            var0[RoomType.BLOOD.ordinal()] = 1;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[RoomType.CHAMPION.ordinal()] = 2;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[RoomType.ENTRANCE.ordinal()] = 3;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[RoomType.FAIRY.ordinal()] = 4;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[RoomType.PUZZLE.ordinal()] = 5;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[RoomType.RARE.ordinal()] = 6;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[RoomType.TRAP.ordinal()] = 7;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
