package funnymap.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004J%\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u0003\u0010\tJ\r\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0000¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\u0014R\"\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\u0014¨\u0006\u001b"},
   d2 = {"Lfunnymap/utils/Vec3;", "", "v", "add", "(Lfunnymap/utils/Vec3;)Lfunnymap/utils/Vec3;", "", "x", "y", "z", "(DDD)Lfunnymap/utils/Vec3;", "length", "()D", "normalize", "()Lfunnymap/utils/Vec3;", "s", "scale", "(D)Lfunnymap/utils/Vec3;", "D", "getX", "setX", "(D)V", "getY", "setY", "getZ", "setZ", "<init>", "(DDD)V", "FunnyMapExtras"}
)
public final class Vec3 {
   private double x;
   private double y;
   private double z;

   public Vec3(double x, double y, double z) {
      this.x = x;
      this.y = y;
      this.z = z;
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

   public final double getZ() {
      return this.z;
   }

   public final void setZ(double <set-?>) {
      this.z = var1;
   }

   @NotNull
   public final Vec3 add(@NotNull Vec3 v) {
      Intrinsics.checkNotNullParameter(v, "v");
      this.x += v.x;
      this.y += v.y;
      this.z += v.z;
      return this;
   }

   @NotNull
   public final Vec3 add(double x, double y, double z) {
      this.x += x;
      this.y += y;
      this.z += z;
      return this;
   }

   public final double length() {
      return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
   }

   @NotNull
   public final Vec3 normalize() {
      double length = this.length();
      if (length == 0.0D) {
         return this;
      } else {
         this.x /= length;
         this.y /= length;
         this.z /= length;
         return this;
      }
   }

   @NotNull
   public final Vec3 scale(double s) {
      this.x *= s;
      this.y *= s;
      this.z *= s;
      return this;
   }
}
