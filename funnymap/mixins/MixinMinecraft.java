package funnymap.mixins;

import funnymap.events.ClickEvent;
import funnymap.features.extras.EditMode;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({Minecraft.class})
public abstract class MixinMinecraft {
   @Inject(
      method = {"clickMouse"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void leftClickEvent(CallbackInfo ci) {
      if (MinecraftForge.EVENT_BUS.post(new ClickEvent.Left())) {
         ci.cancel();
      }

   }

   @ModifyVariable(
      method = {"sendClickBlockToController"},
      at = @At("HEAD"),
      ordinal = 0,
      argsOnly = true
   )
   public boolean holdLeftClick(boolean leftClick) {
      return EditMode.INSTANCE.getEnabled() ? false : leftClick;
   }

   @Inject(
      method = {"middleClickMouse"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void middleClickEvent(CallbackInfo ci) {
      if (MinecraftForge.EVENT_BUS.post(new ClickEvent.Middle())) {
         ci.cancel();
      }

   }

   @Inject(
      method = {"rightClickMouse"},
      at = {@At(
   value = "FIELD",
   target = "Lnet/minecraft/client/Minecraft;rightClickDelayTimer:I",
   shift = Shift.AFTER
)},
      cancellable = true
   )
   public void rightClickEvent(CallbackInfo ci) {
      if (MinecraftForge.EVENT_BUS.post(new ClickEvent.Right())) {
         ci.cancel();
      }

   }
}
