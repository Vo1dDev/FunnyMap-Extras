package funnymap.ui;

import funnymap.utils.RenderUtils;
import java.awt.Color;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u001cB\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006\u001d"},
   d2 = {"Lfunnymap/ui/CornerButton;", "", "", "draw", "()V", "", "mouseX", "mouseY", "", "isHovered", "(II)Z", "Lfunnymap/ui/CornerButton$Corner;", "corner", "Lfunnymap/ui/CornerButton$Corner;", "getCorner", "()Lfunnymap/ui/CornerButton$Corner;", "", "x", "D", "getX", "()D", "setX", "(D)V", "y", "getY", "setY", "<init>", "(DDLfunnymap/ui/CornerButton$Corner;)V", "Corner", "FunnyMapExtras"}
)
public final class CornerButton {
   private double x;
   private double y;
   @NotNull
   private final CornerButton.Corner corner;

   public CornerButton(double x, double y, @NotNull CornerButton.Corner corner) {
      Intrinsics.checkNotNullParameter(corner, "corner");
      super();
      this.x = x;
      this.y = y;
      this.corner = corner;
   }

   public final double getX() {
      return this.x;
   }

   public final void setX(double <set-?>) {
      this.x = var1;
   }

   public final double getY() {
      return this.y;
   }

   public final void setY(double <set-?>) {
      this.y = var1;
   }

   @NotNull
   public final CornerButton.Corner getCorner() {
      return this.corner;
   }

   public final boolean isHovered(int mouseX, int mouseY) {
      double var3 = this.x;
      double var5 = this.x + 6.0D;
      double var7 = (double)mouseX;
      boolean var10000;
      if (var3 <= var7 ? var7 <= var5 : false) {
         var3 = this.y;
         var5 = this.y + 6.0D;
         var7 = (double)mouseY;
         if (var3 <= var7 ? var7 <= var5 : false) {
            var10000 = true;
            return var10000;
         }
      }

      var10000 = false;
      return var10000;
   }

   public final void draw() {
      RenderUtils.INSTANCE.renderRect((Number)this.x, (Number)this.y, (Number)6.0D, (Number)6.0D, new Color(255, 255, 255));
   }

   @Metadata(
      mv = {1, 9, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"},
      d2 = {"Lfunnymap/ui/CornerButton$Corner;", "", "<init>", "(Ljava/lang/String;I)V", "TOP_LEFT", "TOP_RIGHT", "BOTTOM_LEFT", "BOTTOM_RIGHT", "FunnyMapExtras"}
   )
   public static enum Corner {
      TOP_LEFT,
      TOP_RIGHT,
      BOTTOM_LEFT,
      BOTTOM_RIGHT;

      // $FF: synthetic field
      private static final EnumEntries $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);

      @NotNull
      public static EnumEntries<CornerButton.Corner> getEntries() {
         return $ENTRIES;
      }

      // $FF: synthetic method
      private static final CornerButton.Corner[] $values() {
         CornerButton.Corner[] var0 = new CornerButton.Corner[]{TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT};
         return var0;
      }
   }
}
