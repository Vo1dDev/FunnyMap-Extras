package funnymap.mixins;

import funnymap.features.extras.FreeCam;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({EntityRenderer.class})
public abstract class MixinEntityRenderer implements IResourceManagerReloadListener {
   @Inject(
      at = {@At("HEAD")},
      method = {"renderWorld"}
   )
   public void beforeRenderWorld(float partialTicks, long nanoTime, CallbackInfo info) {
      FreeCam.INSTANCE.onBeforeRenderWorld();
   }

   @Inject(
      at = {@At("TAIL")},
      method = {"renderWorld"}
   )
   public void afterRenderWorld(float partialTicks, long nanoTime, CallbackInfo info) {
      FreeCam.INSTANCE.onAfterRenderWorld();
   }
}
