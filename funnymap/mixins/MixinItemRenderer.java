package funnymap.mixins;

import funnymap.features.extras.FreeCam;
import net.minecraft.client.renderer.ItemRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({ItemRenderer.class})
public class MixinItemRenderer {
   @Inject(
      method = {"renderItemInFirstPerson"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void renderItemInFirstPerson(float partialTicks, CallbackInfo ci) {
      if (FreeCam.INSTANCE.getEnabled()) {
         ci.cancel();
      }

   }
}
