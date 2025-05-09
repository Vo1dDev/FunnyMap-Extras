package funnymap.mixins;

import funnymap.features.extras.FreeCam;
import net.minecraft.client.entity.AbstractClientPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({AbstractClientPlayer.class})
public abstract class MixinAbstractClientPlayer {
   @Inject(
      at = {@At("HEAD")},
      method = {"isSpectator()Z"},
      cancellable = true
   )
   private void isSpectator(CallbackInfoReturnable<Boolean> info) {
      if (FreeCam.INSTANCE.shouldOverrideSpectator((AbstractClientPlayer)this)) {
         info.setReturnValue(true);
      }

   }
}
