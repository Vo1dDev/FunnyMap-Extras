package funnymap.ui;

import funnymap.config.Config;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import net.minecraft.client.gui.GuiScreen;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010\u000bJ'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0018\u0010\u0014J\u000f\u0010\u0019\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u000bR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010$¨\u0006'"},
   d2 = {"Lfunnymap/ui/EditLocationGui;", "Lnet/minecraft/client/gui/GuiScreen;", "", "mouseX", "mouseY", "", "partialTicks", "", "drawScreen", "(IIF)V", "handleMouseInput", "()V", "initGui", "", "typedChar", "keyCode", "keyTyped", "(CI)V", "mouseButton", "mouseClicked", "(III)V", "mouseDrag", "(II)V", "state", "mouseReleased", "onGuiClosed", "Lfunnymap/ui/MovableGuiElement;", "hovered", "Lfunnymap/ui/MovableGuiElement;", "", "isDragging", "Z", "Lfunnymap/ui/CornerButton;", "resizingCorner", "Lfunnymap/ui/CornerButton;", "startOffsetX", "I", "startOffsetY", "<init>", "FunnyMapExtras"}
)
@SourceDebugExtension({"SMAP\nEditLocationGui.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EditLocationGui.kt\nfunnymap/ui/EditLocationGui\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,88:1\n1855#2,2:89\n288#2,2:92\n1#3:91\n*S KotlinDebug\n*F\n+ 1 EditLocationGui.kt\nfunnymap/ui/EditLocationGui\n*L\n24#1:89,2\n48#1:92,2\n*E\n"})
public final class EditLocationGui extends GuiScreen {
   @Nullable
   private MovableGuiElement hovered;
   private int startOffsetX;
   private int startOffsetY;
   private boolean isDragging;
   @Nullable
   private CornerButton resizingCorner;

   public void func_73866_w_() {
      Keyboard.enableRepeatEvents(true);
      super.func_73866_w_();
   }

   public void func_73863_a(int mouseX, int mouseY, float partialTicks) {
      this.func_146276_q_();
      Iterable $this$forEach$iv = (Iterable)GuiRenderer.INSTANCE.getElements();
      int $i$f$forEach = false;
      Iterator var6 = $this$forEach$iv.iterator();

      Object element$iv;
      MovableGuiElement it;
      boolean var9;
      while(var6.hasNext()) {
         element$iv = var6.next();
         it = (MovableGuiElement)element$iv;
         var9 = false;
         it.draw(mouseX, mouseY);
      }

      if (!this.isDragging && this.resizingCorner == null) {
         $this$forEach$iv = (Iterable)GuiRenderer.INSTANCE.getElements();
         var6 = $this$forEach$iv.iterator();

         Object var10000;
         while(true) {
            if (!var6.hasNext()) {
               var10000 = null;
               break;
            }

            element$iv = var6.next();
            it = (MovableGuiElement)element$iv;
            var9 = false;
            if (it.isHovered(mouseX, mouseY)) {
               var10000 = element$iv;
               break;
            }
         }

         this.hovered = (MovableGuiElement)var10000;
      }

      this.mouseDrag(mouseX, mouseY);
      super.func_73863_a(mouseX, mouseY, partialTicks);
   }

   public final void mouseDrag(int mouseX, int mouseY) {
      if (this.hovered != null) {
         MovableGuiElement var10000;
         if (this.isDragging) {
            var10000 = this.hovered;
            if (var10000 != null) {
               var10000.setLocation(mouseX - this.startOffsetX, mouseY - this.startOffsetY);
            }
         } else {
            CornerButton var5 = this.resizingCorner;
            if (var5 != null) {
               CornerButton.Corner var6 = var5.getCorner();
               if (var6 != null) {
                  CornerButton.Corner it = var6;
                  int var4 = false;
                  var10000 = this.hovered;
                  if (var10000 != null) {
                     var10000.cornerDrag(mouseX, mouseY, it);
                  }
               }
            }
         }

      }
   }

   protected void func_73864_a(int mouseX, int mouseY, int mouseButton) {
      if (mouseButton == 0) {
         this.resizingCorner = null;
         Iterable $this$firstOrNull$iv = (Iterable)GuiRenderer.INSTANCE.getElements();
         int $i$f$firstOrNull = false;
         Iterator var7 = $this$firstOrNull$iv.iterator();

         Object var21;
         while(true) {
            if (!var7.hasNext()) {
               var21 = null;
               break;
            }

            Object element$iv = var7.next();
            MovableGuiElement guiElement = (MovableGuiElement)element$iv;
            int var10 = false;
            CornerButton[] var11 = guiElement.getCorners();
            CornerButton[] var13 = var11;
            int var14 = 0;
            int var15 = var11.length;

            CornerButton var10000;
            while(true) {
               if (var14 >= var15) {
                  var10000 = null;
                  break;
               }

               CornerButton var16 = var13[var14];
               int var18 = false;
               if (var16.isHovered(mouseX, mouseY)) {
                  var10000 = var16;
                  break;
               }

               ++var14;
            }

            this.resizingCorner = var10000;
            if (this.resizingCorner != null) {
               var21 = element$iv;
               break;
            }
         }

         MovableGuiElement var4 = (MovableGuiElement)var21;
         boolean var20;
         if (var4 != null) {
            var20 = false;
            this.hovered = var4;
         }

         if (this.resizingCorner == null) {
            MovableGuiElement var22 = this.hovered;
            if (var22 != null) {
               MovableGuiElement it = var22;
               var20 = false;
               this.startOffsetX = mouseX - it.getX();
               this.startOffsetY = mouseY - it.getY();
               this.isDragging = true;
            }
         }
      }

      super.func_73864_a(mouseX, mouseY, mouseButton);
   }

   protected void func_146286_b(int mouseX, int mouseY, int state) {
      this.isDragging = false;
      this.resizingCorner = null;
      super.func_146286_b(mouseX, mouseY, state);
   }

   public void func_146274_d() {
      int i = RangesKt.coerceIn(Mouse.getEventDWheel(), (ClosedRange)(new IntRange(-1, 1)));
      MovableGuiElement var10000 = this.hovered;
      if (var10000 != null) {
         var10000.mouseScroll(i);
      }

      super.func_146274_d();
   }

   protected void func_73869_a(char typedChar, int keyCode) {
      MovableGuiElement var10000 = this.hovered;
      if (var10000 != null) {
         var10000.keyTyped(keyCode);
      }

      super.func_73869_a(typedChar, keyCode);
   }

   public void func_146281_b() {
      Keyboard.enableRepeatEvents(false);
      Config.INSTANCE.markDirty();
      Config.INSTANCE.writeData();
      super.func_146281_b();
   }
}
