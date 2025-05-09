package funnymap.mixins;

import funnymap.features.extras.FreeCam;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({RenderManager.class})
public abstract class MixinRenderManager {
   @Inject(
      at = {@At("HEAD")},
      method = {"renderEntitySimple(Lnet/minecraft/entity/Entity;F)Z"}
   )
   private void beforeRenderEntitySimple(Entity entity, float partialTicks, CallbackInfoReturnable<Boolean> info) {
      FreeCam.INSTANCE.onBeforeRenderEntity(entity);
   }

   @Inject(
      at = {@At("TAIL")},
      method = {"renderEntitySimple(Lnet/minecraft/entity/Entity;F)Z"}
   )
   private void afterRenderEntitySimple(Entity entity, float partialTicks, CallbackInfoReturnable<Boolean> info) {
      FreeCam.INSTANCE.onAfterRenderEntity(entity);
   }
}
