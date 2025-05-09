package funnymap.features.extras;

import funnymap.FunnyMap;
import funnymap.config.Config;
import funnymap.core.EntityPosition;
import funnymap.events.ClickEvent;
import funnymap.utils.Vec3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovementInput;
import net.minecraft.util.MovingObjectPosition;
import net.minecraftforge.event.world.WorldEvent.Unload;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bV\u0010\nJ'\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\nJ\u0015\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\nJ\r\u0010\u0018\u001a\u00020\b¢\u0006\u0004\b\u0018\u0010\nJ\u0015\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0019\u0010\u0016J\r\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\nJ\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001fH\u0007¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\"H\u0007¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\b¢\u0006\u0004\b%\u0010\nJ\u0017\u0010'\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020&H\u0007¢\u0006\u0004\b'\u0010(J\u001d\u0010)\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b)\u0010*J\u0015\u0010.\u001a\u00020-2\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b.\u0010/R\u0014\u00100\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00102\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u00101R\u0014\u00103\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b3\u00101R\"\u00104\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0016\u0010:\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00105R\u0016\u0010;\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00101R\u0014\u0010=\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010@\u001a\u00020?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u00101R\u0016\u0010C\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR$\u0010F\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0016\u0010M\u001a\u00020L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010P\u001a\u00020O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010R\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u00105R\u0014\u0010S\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010>R\u0016\u0010T\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u00105R\u0016\u0010U\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u00101¨\u0006W"},
   d2 = {"Lfunnymap/features/extras/FreeCam;", "", "", "velocity", "impulse", "frameTime", "calculateVelocity", "(DDD)D", "", "disable", "()V", "enable", "", "pitch", "yaw", "Lfunnymap/utils/Vec3;", "getVecFromRotation", "(FF)Lfunnymap/utils/Vec3;", "onAfterRenderEntities", "Lnet/minecraft/entity/Entity;", "entity", "onAfterRenderEntity", "(Lnet/minecraft/entity/Entity;)V", "onAfterRenderWorld", "onBeforeRenderEntities", "onBeforeRenderEntity", "onBeforeRenderWorld", "Lfunnymap/events/ClickEvent;", "event", "onClick", "(Lfunnymap/events/ClickEvent;)V", "Lnet/minecraftforge/fml/common/gameevent/TickEvent$ClientTickEvent;", "onClientTick", "(Lnet/minecraftforge/fml/common/gameevent/TickEvent$ClientTickEvent;)V", "Lnet/minecraftforge/fml/common/gameevent/TickEvent$RenderTickEvent;", "onRenderTick", "(Lnet/minecraftforge/fml/common/gameevent/TickEvent$RenderTickEvent;)V", "onToggleKey", "Lnet/minecraftforge/event/world/WorldEvent$Unload;", "onWorldUnload", "(Lnet/minecraftforge/event/world/WorldEvent$Unload;)V", "setAngles", "(FF)V", "Lnet/minecraft/client/entity/AbstractClientPlayer;", "player", "", "shouldOverrideSpectator", "(Lnet/minecraft/client/entity/AbstractClientPlayer;)Z", "ACCELERATION", "D", "MAX_SPEED", "SLOWDOWN", "enabled", "Z", "getEnabled", "()Z", "setEnabled", "(Z)V", "entitiesRendering", "forwardVelocity", "Lfunnymap/core/EntityPosition;", "freeCamPosition", "Lfunnymap/core/EntityPosition;", "", "lastTime", "J", "leftVelocity", "lookVec", "Lfunnymap/utils/Vec3;", "Lnet/minecraft/util/MovingObjectPosition;", "looking", "Lnet/minecraft/util/MovingObjectPosition;", "getLooking", "()Lnet/minecraft/util/MovingObjectPosition;", "setLooking", "(Lnet/minecraft/util/MovingObjectPosition;)V", "", "oldCameraType", "I", "Lnet/minecraft/util/MovementInput;", "oldInput", "Lnet/minecraft/util/MovementInput;", "oldNoClip", "playerPosition", "shouldOverride", "upVelocity", "<init>", "FunnyMapExtras"}
)
public final class FreeCam {
   @NotNull
   public static final FreeCam INSTANCE = new FreeCam();
   private static final double ACCELERATION = 20.0D;
   private static final double MAX_SPEED = 35.0D;
   private static final double SLOWDOWN = 0.05D;
   private static boolean enabled;
   @NotNull
   private static Vec3 lookVec = new Vec3(0.0D, 0.0D, 0.0D);
   private static double forwardVelocity;
   private static double leftVelocity;
   private static double upVelocity;
   private static long lastTime;
   private static int oldCameraType;
   @NotNull
   private static MovementInput oldInput = new MovementInput();
   private static boolean oldNoClip;
   @NotNull
   private static final EntityPosition freeCamPosition = new EntityPosition();
   @NotNull
   private static final EntityPosition playerPosition = new EntityPosition();
   private static boolean shouldOverride;
   private static boolean entitiesRendering;
   @Nullable
   private static MovingObjectPosition looking;

   private FreeCam() {
   }

   public final boolean getEnabled() {
      return enabled;
   }

   public final void setEnabled(boolean <set-?>) {
      enabled = var1;
   }

   @Nullable
   public final MovingObjectPosition getLooking() {
      return looking;
   }

   public final void setLooking(@Nullable MovingObjectPosition <set-?>) {
      looking = var1;
   }

   @SubscribeEvent
   public final void onRenderTick(@NotNull RenderTickEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      if (event.phase == Phase.START && enabled) {
         long currTime = System.nanoTime();
         float frameTime = (float)(currTime - lastTime) / 1.0E9F;
         lastTime = currTime;
         MovementInput input = oldInput;
         float forwardImpulse = input.field_78900_b;
         float leftImpulse = input.field_78902_a;
         int upImpulse = (input.field_78901_c ? 1 : 0) + (input.field_78899_d ? -1 : 0);
         forwardVelocity = this.calculateVelocity(forwardVelocity, (double)forwardImpulse, (double)frameTime);
         leftVelocity = this.calculateVelocity(leftVelocity, (double)leftImpulse, (double)frameTime);
         upVelocity = this.calculateVelocity(upVelocity, (double)upImpulse, (double)frameTime);
         Vec3 forward = Config.INSTANCE.getFreeCamSpectatorMovement() ? lookVec : (new Vec3(lookVec.getX(), 0.0D, lookVec.getZ())).normalize();
         Vec3 left = (new Vec3(lookVec.getZ(), 0.0D, -lookVec.getX())).normalize();
         Vec3 moveDelta = forward.scale(forwardVelocity).add(left.scale(leftVelocity)).add(0.0D, upVelocity, 0.0D).scale((double)frameTime);
         double speed = moveDelta.length() / (double)frameTime;
         if (speed > 35.0D) {
            double factor = 35.0D / speed;
            forwardVelocity *= factor;
            leftVelocity *= factor;
            upVelocity *= factor;
            moveDelta.scale(factor);
         }

         EntityPosition var16 = freeCamPosition;
         var16.setX(var16.getX() + moveDelta.getX());
         var16 = freeCamPosition;
         var16.setY(var16.getY() + moveDelta.getY());
         var16 = freeCamPosition;
         var16.setZ(var16.getZ() + moveDelta.getZ());
      }
   }

   @SubscribeEvent
   public final void onClientTick(@NotNull ClientTickEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      if (event.phase == Phase.START && enabled) {
         while(FunnyMap.INSTANCE.getMc().field_71474_y.field_151457_aa.func_151468_f()) {
         }

         oldInput.func_78898_a();
      }
   }

   @SubscribeEvent
   public final void onWorldUnload(@NotNull Unload event) {
      Intrinsics.checkNotNullParameter(event, "event");
      this.disable();
   }

   @SubscribeEvent
   public final void onClick(@NotNull ClickEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      if (enabled) {
         event.setCanceled(true);
      }

   }

   public final void onToggleKey() {
      if (FunnyMap.INSTANCE.getMc().field_71439_g != null && FunnyMap.INSTANCE.getMc().field_71462_r == null) {
         if (enabled) {
            this.disable();
         } else {
            this.enable();
         }

      }
   }

   public final void setAngles(float yaw, float pitch) {
      EntityPosition $this$setAngles_u24lambda_u240 = freeCamPosition;
      int var4 = false;
      $this$setAngles_u24lambda_u240.setPitch($this$setAngles_u24lambda_u240.getPitch() - pitch * 0.15F);
      $this$setAngles_u24lambda_u240.setYaw($this$setAngles_u24lambda_u240.getYaw() + yaw * 0.15F);
      $this$setAngles_u24lambda_u240.setPitch(MathHelper.func_76131_a($this$setAngles_u24lambda_u240.getPitch(), -90.0F, 90.0F));
      FreeCam var10000 = INSTANCE;
      lookVec = INSTANCE.getVecFromRotation($this$setAngles_u24lambda_u240.getPitch(), $this$setAngles_u24lambda_u240.getYaw());
   }

   public final void onBeforeRenderWorld() {
      if (enabled) {
         Entity var10000 = FunnyMap.INSTANCE.getMc().func_175606_aa();
         if (var10000 != null) {
            Entity it = var10000;
            int var2 = false;
            FreeCam var3 = INSTANCE;
            shouldOverride = true;
            playerPosition.copyFromEntity(it, true);
            freeCamPosition.copyToEntity(it, false);
            var3 = INSTANCE;
            oldNoClip = it.field_70145_X;
            it.field_70145_X = true;
         }

      }
   }

   public final void onAfterRenderWorld() {
      if (shouldOverride) {
         looking = FunnyMap.INSTANCE.getMc().field_71476_x;
         Entity var10000 = FunnyMap.INSTANCE.getMc().func_175606_aa();
         if (var10000 != null) {
            Entity it = var10000;
            int var2 = false;
            playerPosition.copyToEntity(it, true);
            FreeCam var3 = INSTANCE;
            shouldOverride = false;
            it.field_70145_X = oldNoClip;
         }

      }
   }

   public final void onBeforeRenderEntity(@NotNull Entity entity) {
      Intrinsics.checkNotNullParameter(entity, "entity");
      if (FunnyMap.INSTANCE.getMc().func_175606_aa() == entity && shouldOverride) {
         playerPosition.copyToEntity(entity, true);
      }

   }

   public final void onAfterRenderEntity(@NotNull Entity entity) {
      Intrinsics.checkNotNullParameter(entity, "entity");
      if (FunnyMap.INSTANCE.getMc().func_175606_aa() == entity && shouldOverride) {
         freeCamPosition.copyToEntity(entity, false);
      }

   }

   public final void onBeforeRenderEntities() {
      entitiesRendering = true;
      if (shouldOverride) {
         FunnyMap.INSTANCE.getMc().field_71474_y.field_74320_O = 1;
      }

   }

   public final void onAfterRenderEntities() {
      entitiesRendering = false;
      if (shouldOverride) {
         FunnyMap.INSTANCE.getMc().field_71474_y.field_74320_O = 0;
      }

   }

   public final boolean shouldOverrideSpectator(@NotNull AbstractClientPlayer player) {
      Intrinsics.checkNotNullParameter(player, "player");
      return FunnyMap.INSTANCE.getMc().func_175606_aa() == player && shouldOverride && !entitiesRendering;
   }

   private final void enable() {
      if (!enabled) {
         enabled = true;
         oldCameraType = FunnyMap.INSTANCE.getMc().field_71474_y.field_74320_O;
         MovementInput var10000 = FunnyMap.INSTANCE.getMc().field_71439_g.field_71158_b;
         Intrinsics.checkNotNullExpressionValue(var10000, "movementInput");
         oldInput = var10000;
         FunnyMap.INSTANCE.getMc().field_71439_g.field_71158_b = new MovementInput();
         FunnyMap.INSTANCE.getMc().field_71474_y.field_74320_O = 0;
         Entity var4 = FunnyMap.INSTANCE.getMc().func_175606_aa();
         if (var4 != null) {
            Entity it = var4;
            int var2 = false;
            net.minecraft.util.Vec3 pos = it.func_174824_e(1.0F);
            FreeCam var5 = INSTANCE;
            lookVec = INSTANCE.getVecFromRotation(it.field_70125_A, it.field_70177_z);
            freeCamPosition.setX(pos.field_72450_a + lookVec.getX() * -1.5D);
            freeCamPosition.setY(pos.field_72448_b + lookVec.getY() * -1.5D);
            freeCamPosition.setZ(pos.field_72449_c + lookVec.getZ() * -1.5D);
            freeCamPosition.setPitch(it.field_70125_A);
            freeCamPosition.setYaw(it.field_70177_z);
         }

         lastTime = System.nanoTime();
      }
   }

   private final void disable() {
      if (enabled) {
         enabled = false;
         FunnyMap.INSTANCE.getMc().field_71474_y.field_74320_O = oldCameraType;
         FunnyMap.INSTANCE.getMc().field_71439_g.field_71158_b = oldInput;
         shouldOverride = false;
         forwardVelocity = 0.0D;
         leftVelocity = 0.0D;
         upVelocity = 0.0D;
         FunnyMap.INSTANCE.getMc().field_71438_f.func_72712_a();
      }
   }

   private final Vec3 getVecFromRotation(float pitch, float yaw) {
      double f = Math.cos((double)(-yaw) * 0.017453292519943295D - 3.141592653589793D);
      double f1 = Math.sin((double)(-yaw) * 0.017453292519943295D - 3.141592653589793D);
      double f2 = -Math.cos((double)(-pitch) * 0.017453292519943295D);
      double f3 = Math.sin((double)(-pitch) * 0.017453292519943295D);
      return new Vec3(f1 * f2, f3, f * f2);
   }

   private final double calculateVelocity(double velocity, double impulse, double frameTime) {
      if (impulse == 0.0D) {
         return velocity * Math.pow(0.05D, frameTime);
      } else {
         double newVelocity = 20.0D * impulse * frameTime;
         if (Math.signum(impulse) == Math.signum(velocity)) {
            newVelocity += velocity;
         }

         return newVelocity;
      }
   }
}
