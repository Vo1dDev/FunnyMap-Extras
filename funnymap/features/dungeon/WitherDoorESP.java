package funnymap.features.dungeon;

import funnymap.FunnyMap;
import funnymap.config.Config;
import funnymap.core.map.Door;
import funnymap.core.map.RoomState;
import funnymap.utils.Location;
import funnymap.utils.RenderUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"},
   d2 = {"Lfunnymap/features/dungeon/WitherDoorESP;", "", "Lnet/minecraftforge/client/event/RenderWorldLastEvent;", "event", "", "onRender", "(Lnet/minecraftforge/client/event/RenderWorldLastEvent;)V", "<init>", "()V", "FunnyMapExtras"}
)
@SourceDebugExtension({"SMAP\nWitherDoorESP.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WitherDoorESP.kt\nfunnymap/features/dungeon/WitherDoorESP\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,41:1\n1855#2,2:42\n*S KotlinDebug\n*F\n+ 1 WitherDoorESP.kt\nfunnymap/features/dungeon/WitherDoorESP\n*L\n24#1:42,2\n*E\n"})
public final class WitherDoorESP {
   @NotNull
   public static final WitherDoorESP INSTANCE = new WitherDoorESP();

   private WitherDoorESP() {
   }

   @SubscribeEvent
   public final void onRender(@NotNull RenderWorldLastEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      if (Location.INSTANCE.getInDungeons() && !Location.INSTANCE.getInBoss() && Config.INSTANCE.getWitherDoorESP() != 0) {
         FunnyMap.INSTANCE.getMc().field_71424_I.func_76320_a("funnymap-3d");
         RenderUtils var10000 = RenderUtils.INSTANCE;
         Entity var10001 = FunnyMap.INSTANCE.getMc().func_175606_aa();
         Intrinsics.checkNotNullExpressionValue(var10001, "getRenderViewEntity(...)");
         Triple var2 = var10000.getInterpolatedPosition(var10001, event.partialTicks);
         double x = ((Number)var2.component1()).doubleValue();
         double y = ((Number)var2.component2()).doubleValue();
         double z = ((Number)var2.component3()).doubleValue();
         GlStateManager.func_179137_b(-x, -y, -z);
         Iterable $this$forEach$iv = (Iterable)Dungeon.INSTANCE.getEspDoors();
         int $i$f$forEach = false;
         Iterator var11 = $this$forEach$iv.iterator();

         while(var11.hasNext()) {
            Object element$iv = var11.next();
            Door door = (Door)element$iv;
            int var14 = false;
            if (Config.INSTANCE.getWitherDoorESP() != 1 || door.getState() != RoomState.UNDISCOVERED) {
               AxisAlignedBB aabb = new AxisAlignedBB((double)door.getX() - 1.0D, 69.0D, (double)door.getZ() - 1.0D, (double)door.getX() + 2.0D, 73.0D, (double)door.getZ() + 2.0D);
               RenderUtils.INSTANCE.drawBox(aabb, Dungeon.Info.INSTANCE.getKeys() > 0 ? Config.INSTANCE.getWitherDoorKeyColor() : Config.INSTANCE.getWitherDoorNoKeyColor(), Config.INSTANCE.getWitherDoorOutlineWidth(), Config.INSTANCE.getWitherDoorOutline(), Config.INSTANCE.getWitherDoorFill(), true);
            }
         }

         GlStateManager.func_179137_b(x, y, z);
         FunnyMap.INSTANCE.getMc().field_71424_I.func_76319_b();
      }
   }
}
