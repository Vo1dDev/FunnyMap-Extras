package funnymap.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b?\u0010!B\u001b\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b?\u0010\u0018B/\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b?\u0010@J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJB\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0019\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0016H\u0002¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010&R\u0016\u0010(\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010&R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010)\u001a\u0004\b*\u0010\t\"\u0004\b+\u0010,R\"\u0010-\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010)\u001a\u0004\b.\u0010\t\"\u0004\b/\u0010,R\u0016\u00100\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010&R\u0016\u00101\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010&R\"\u00102\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010)\u001a\u0004\b3\u0010\t\"\u0004\b4\u0010,R\u0016\u00105\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010&R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010&\u001a\u0004\b6\u0010\u0004\"\u0004\b7\u00108R\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010&\u001a\u0004\b9\u0010\u0004\"\u0004\b:\u00108R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010)\u001a\u0004\b;\u0010\t\"\u0004\b<\u0010,R\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010&\u001a\u0004\b=\u0010\u0004\"\u0004\b>\u00108¨\u0006A"},
   d2 = {"Lfunnymap/core/EntityPosition;", "", "", "component1", "()D", "component2", "component3", "", "component4", "()F", "component5", "x", "y", "z", "pitch", "yaw", "copy", "(DDDFF)Lfunnymap/core/EntityPosition;", "Lnet/minecraft/entity/Entity;", "entity", "", "full", "", "copyFromEntity", "(Lnet/minecraft/entity/Entity;Z)V", "copyToEntity", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "setDefault", "()V", "", "toString", "()Ljava/lang/String;", "lastX", "D", "lastY", "lastZ", "F", "getPitch", "setPitch", "(F)V", "prevPitch", "getPrevPitch", "setPrevPitch", "prevX", "prevY", "prevYaw", "getPrevYaw", "setPrevYaw", "prevZ", "getX", "setX", "(D)V", "getY", "setY", "getYaw", "setYaw", "getZ", "setZ", "<init>", "(DDDFF)V", "FunnyMapExtras"}
)
public final class EntityPosition {
   private double x;
   private double y;
   private double z;
   private float pitch;
   private float yaw;
   private double lastX;
   private double lastY;
   private double lastZ;
   private double prevX;
   private double prevY;
   private double prevZ;
   private float prevPitch;
   private float prevYaw;

   public EntityPosition(double x, double y, double z, float pitch, float yaw) {
      this.x = x;
      this.y = y;
      this.z = z;
      this.pitch = pitch;
      this.yaw = yaw;
      this.lastX = this.x;
      this.lastY = this.y;
      this.lastZ = this.z;
      this.prevX = this.x;
      this.prevY = this.y;
      this.prevZ = this.z;
      this.prevPitch = this.pitch;
      this.prevYaw = this.yaw;
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

   public final float getPitch() {
      return this.pitch;
   }

   public final void setPitch(float <set-?>) {
      this.pitch = var1;
   }

   public final float getYaw() {
      return this.yaw;
   }

   public final void setYaw(float <set-?>) {
      this.yaw = var1;
   }

   public final float getPrevPitch() {
      return this.prevPitch;
   }

   public final void setPrevPitch(float <set-?>) {
      this.prevPitch = var1;
   }

   public final float getPrevYaw() {
      return this.prevYaw;
   }

   public final void setPrevYaw(float <set-?>) {
      this.prevYaw = var1;
   }

   public EntityPosition() {
      this(0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
   }

   public EntityPosition(@NotNull Entity entity, boolean full) {
      Intrinsics.checkNotNullParameter(entity, "entity");
      this(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, entity.field_70125_A, entity.field_70177_z);
      if (full) {
         this.lastX = entity.field_70142_S;
         this.lastY = entity.field_70137_T;
         this.lastZ = entity.field_70136_U;
         this.prevX = entity.field_70169_q;
         this.prevY = entity.field_70167_r;
         this.prevZ = entity.field_70166_s;
         this.prevPitch = entity.field_70127_C;
         this.prevYaw = entity.field_70126_B;
      }

   }

   // $FF: synthetic method
   public EntityPosition(Entity var1, boolean var2, int var3, DefaultConstructorMarker var4) {
      if ((var3 & 2) != 0) {
         var2 = false;
      }

      this(var1, var2);
   }

   private final void setDefault() {
      this.lastX = this.x;
      this.lastY = this.y;
      this.lastZ = this.z;
      this.prevX = this.x;
      this.prevY = this.y;
      this.prevZ = this.z;
      this.prevPitch = this.pitch;
      this.prevYaw = this.yaw;
   }

   public final void copyFromEntity(@NotNull Entity entity, boolean full) {
      Intrinsics.checkNotNullParameter(entity, "entity");
      this.x = entity.field_70165_t;
      this.y = entity.field_70163_u;
      this.z = entity.field_70161_v;
      this.yaw = entity.field_70177_z;
      this.pitch = entity.field_70125_A;
      if (full) {
         this.lastX = entity.field_70142_S;
         this.lastY = entity.field_70137_T;
         this.lastZ = entity.field_70136_U;
         this.prevX = entity.field_70169_q;
         this.prevY = entity.field_70167_r;
         this.prevZ = entity.field_70166_s;
         this.prevPitch = entity.field_70127_C;
         this.prevYaw = entity.field_70126_B;
      } else {
         this.setDefault();
      }

   }

   // $FF: synthetic method
   public static void copyFromEntity$default(EntityPosition var0, Entity var1, boolean var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = false;
      }

      var0.copyFromEntity(var1, var2);
   }

   public final void copyToEntity(@NotNull Entity entity, boolean full) {
      Intrinsics.checkNotNullParameter(entity, "entity");
      entity.func_70012_b(this.x, this.y, this.z, this.yaw, this.pitch);
      if (full) {
         entity.field_70142_S = this.lastX;
         entity.field_70137_T = this.lastY;
         entity.field_70136_U = this.lastZ;
         entity.field_70169_q = this.prevX;
         entity.field_70167_r = this.prevY;
         entity.field_70166_s = this.prevZ;
         entity.field_70127_C = this.prevPitch;
         entity.field_70126_B = this.prevYaw;
      } else {
         entity.field_70142_S = this.x;
         entity.field_70137_T = this.y;
         entity.field_70136_U = this.z;
         entity.field_70169_q = this.x;
         entity.field_70167_r = this.y;
         entity.field_70166_s = this.z;
         entity.field_70127_C = this.pitch;
         entity.field_70126_B = this.yaw;
      }

   }

   // $FF: synthetic method
   public static void copyToEntity$default(EntityPosition var0, Entity var1, boolean var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = false;
      }

      var0.copyToEntity(var1, var2);
   }

   public final double component1() {
      return this.x;
   }

   public final double component2() {
      return this.y;
   }

   public final double component3() {
      return this.z;
   }

   public final float component4() {
      return this.pitch;
   }

   public final float component5() {
      return this.yaw;
   }

   @NotNull
   public final EntityPosition copy(double x, double y, double z, float pitch, float yaw) {
      return new EntityPosition(x, y, z, pitch, yaw);
   }

   // $FF: synthetic method
   public static EntityPosition copy$default(EntityPosition var0, double var1, double var3, double var5, float var7, float var8, int var9, Object var10) {
      if ((var9 & 1) != 0) {
         var1 = var0.x;
      }

      if ((var9 & 2) != 0) {
         var3 = var0.y;
      }

      if ((var9 & 4) != 0) {
         var5 = var0.z;
      }

      if ((var9 & 8) != 0) {
         var7 = var0.pitch;
      }

      if ((var9 & 16) != 0) {
         var8 = var0.yaw;
      }

      return var0.copy(var1, var3, var5, var7, var8);
   }

   @NotNull
   public String toString() {
      return "EntityPosition(x=" + this.x + ", y=" + this.y + ", z=" + this.z + ", pitch=" + this.pitch + ", yaw=" + this.yaw + ')';
   }

   public int hashCode() {
      int result = Double.hashCode(this.x);
      result = result * 31 + Double.hashCode(this.y);
      result = result * 31 + Double.hashCode(this.z);
      result = result * 31 + Float.hashCode(this.pitch);
      result = result * 31 + Float.hashCode(this.yaw);
      return result;
   }

   public boolean equals(@Nullable Object other) {
      if (this == other) {
         return true;
      } else if (!(other instanceof EntityPosition)) {
         return false;
      } else {
         EntityPosition var2 = (EntityPosition)other;
         if (Double.compare(this.x, var2.x) != 0) {
            return false;
         } else if (Double.compare(this.y, var2.y) != 0) {
            return false;
         } else if (Double.compare(this.z, var2.z) != 0) {
            return false;
         } else if (Float.compare(this.pitch, var2.pitch) != 0) {
            return false;
         } else {
            return Float.compare(this.yaw, var2.yaw) == 0;
         }
      }
   }
}
