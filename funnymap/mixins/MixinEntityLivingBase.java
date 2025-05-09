package funnymap.mixins;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({EntityLivingBase.class})
public abstract class MixinEntityLivingBase extends Entity {
   public MixinEntityLivingBase(World worldIn) {
      super(worldIn);
   }

   @Inject(
      method = {"getLook"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void mouseDelayFix(float partialTicks, CallbackInfoReturnable<Vec3> cir) {
      if ((EntityLivingBase)this instanceof EntityPlayerSP) {
         cir.setReturnValue(super.func_70676_i(partialTicks));
      }

   }
}
