package funnymap.mixins;

import funnymap.features.extras.FreeCam;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin({EntityPlayerSP.class})
public abstract class MixinEntityPlayerSP extends Entity {
   public MixinEntityPlayerSP(World world) {
      super(world);
   }

   public void func_70082_c(float yaw, float pitch) {
      if (FreeCam.INSTANCE.getEnabled()) {
         FreeCam.INSTANCE.setAngles(yaw, pitch);
      } else {
         super.func_70082_c(yaw, pitch);
      }

   }
}
