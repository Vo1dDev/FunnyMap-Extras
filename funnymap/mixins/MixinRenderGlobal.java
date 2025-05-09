package funnymap.mixins;

import funnymap.features.extras.FreeCam;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({RenderGlobal.class})
public abstract class MixinRenderGlobal {
   @Inject(
      at = {@At("HEAD")},
      method = {"renderEntities(Lnet/minecraft/entity/Entity;Lnet/minecraft/client/renderer/culling/ICamera;F)V"}
   )
   private void beforeRenderEntities(Entity p_renderEntities_1_, ICamera p_renderEntities_2_, float p_renderEntities_3_, CallbackInfo ci) {
      FreeCam.INSTANCE.onBeforeRenderEntities();
   }

   @Inject(
      at = {@At("TAIL")},
      method = {"renderEntities(Lnet/minecraft/entity/Entity;Lnet/minecraft/client/renderer/culling/ICamera;F)V"}
   )
   private void afterRenderEntities(Entity p_renderEntities_1_, ICamera p_renderEntities_2_, float p_renderEntities_3_, CallbackInfo ci) {
      FreeCam.INSTANCE.onAfterRenderEntities();
   }
}
