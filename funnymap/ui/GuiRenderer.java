package funnymap.ui;

import funnymap.FunnyMap;
import funnymap.utils.Location;
import funnymap.utils.RenderUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.client.event.RenderGameOverlayEvent.Pre;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0010R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001a"},
   d2 = {"Lfunnymap/ui/GuiRenderer;", "", "", "clearTitle", "()V", "", "title", "", "ticks", "displayTitle", "(Ljava/lang/String;I)V", "Lnet/minecraftforge/client/event/RenderGameOverlayEvent$Pre;", "event", "onOverlay", "(Lnet/minecraftforge/client/event/RenderGameOverlayEvent$Pre;)V", "onTick", "Ljava/lang/String;", "", "Lfunnymap/ui/MovableGuiElement;", "elements", "Ljava/util/List;", "getElements", "()Ljava/util/List;", "titleTicks", "I", "<init>", "FunnyMapExtras"}
)
@SourceDebugExtension({"SMAP\nGuiRenderer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GuiRenderer.kt\nfunnymap/ui/GuiRenderer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,67:1\n1855#2,2:68\n*S KotlinDebug\n*F\n+ 1 GuiRenderer.kt\nfunnymap/ui/GuiRenderer\n*L\n39#1:68,2\n*E\n"})
public final class GuiRenderer {
   @NotNull
   public static final GuiRenderer INSTANCE = new GuiRenderer();
   @NotNull
   private static final List<MovableGuiElement> elements;
   @NotNull
   private static String displayTitle;
   private static int titleTicks;

   private GuiRenderer() {
   }

   @NotNull
   public final List<MovableGuiElement> getElements() {
      return elements;
   }

   public final void displayTitle(@NotNull String title, int ticks) {
      Intrinsics.checkNotNullParameter(title, "title");
      displayTitle = title;
      titleTicks = ticks;
   }

   public final void clearTitle() {
      displayTitle = "";
      titleTicks = 0;
   }

   @SubscribeEvent
   public final void onOverlay(@NotNull Pre event) {
      Intrinsics.checkNotNullParameter(event, "event");
      if (event.type == ElementType.ALL && Location.INSTANCE.getInDungeons()) {
         if (!(FunnyMap.INSTANCE.getMc().field_71462_r instanceof EditLocationGui)) {
            FunnyMap.INSTANCE.getMc().field_71424_I.func_76320_a("funnymap-2d");
            FunnyMap.INSTANCE.getMc().field_71460_t.func_78478_c();
            Iterable $this$forEach$iv = (Iterable)elements;
            int $i$f$forEach = false;
            Iterator var4 = $this$forEach$iv.iterator();

            while(var4.hasNext()) {
               Object element$iv = var4.next();
               MovableGuiElement it = (MovableGuiElement)element$iv;
               int var7 = false;
               if (it.shouldRender()) {
                  GlStateManager.func_179094_E();
                  GlStateManager.func_179109_b((float)it.getX(), (float)it.getY(), 0.0F);
                  GlStateManager.func_179152_a(it.getScale(), it.getScale(), 1.0F);
                  it.render();
                  GlStateManager.func_179121_F();
               }
            }

            if (titleTicks > 0) {
               ScaledResolution sr = new ScaledResolution(FunnyMap.INSTANCE.getMc());
               RenderUtils.drawText$default(RenderUtils.INSTANCE, displayTitle, (float)sr.func_78326_a() / 2.0F, (float)sr.func_78328_b() / 4.0F, 4.0D, 16733525, false, true, 32, (Object)null);
            }

            FunnyMap.INSTANCE.getMc().field_71424_I.func_76319_b();
         }
      }
   }

   public final void onTick() {
      if (titleTicks > 0) {
         int var1 = titleTicks;
         titleTicks = var1 + -1;
      }

   }

   static {
      MovableGuiElement[] var0 = new MovableGuiElement[]{new EditModeElement(), new MapElement(), new ScoreElement()};
      elements = CollectionsKt.mutableListOf(var0);
      displayTitle = "";
   }
}
