package funnymap.ui;

import funnymap.FunnyMap;
import funnymap.utils.RenderUtils;
import java.awt.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0014\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b8\u0010\u0015J%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u000bJ\u000f\u0010\u0019\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001b\u0010\u0015R\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0014\u0010$\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\"\u0010&\u001a\u00020%8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010#R\u001c\u0010\u0016\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b.\u0010#\"\u0004\b/\u0010\u0011R\u001c\u00102\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b0\u0010#\"\u0004\b1\u0010\u0011R\u001c\u0010\u0017\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b3\u0010#\"\u0004\b4\u0010\u0011R\u001c\u00107\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b5\u0010#\"\u0004\b6\u0010\u0011¨\u00069"},
   d2 = {"Lfunnymap/ui/MovableGuiElement;", "", "", "mouseX", "mouseY", "Lfunnymap/ui/CornerButton$Corner;", "corner", "", "cornerDrag", "(IILfunnymap/ui/CornerButton$Corner;)V", "draw", "(II)V", "", "isHovered", "(II)Z", "keyCode", "keyTyped", "(I)V", "direction", "mouseScroll", "render", "()V", "x", "y", "setLocation", "shouldRender", "()Z", "updateCorners", "", "Lfunnymap/ui/CornerButton;", "corners", "[Lfunnymap/ui/CornerButton;", "getCorners", "()[Lfunnymap/ui/CornerButton;", "getH", "()I", "h", "", "scale", "F", "getScale", "()F", "setScale", "(F)V", "getW", "w", "getX", "setX", "getX2", "setX2", "x2", "getY", "setY", "getY2", "setY2", "y2", "<init>", "FunnyMapExtras"}
)
@SourceDebugExtension({"SMAP\nMovableGuiElement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovableGuiElement.kt\nfunnymap/ui/MovableGuiElement\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,135:1\n13309#2,2:136\n*S KotlinDebug\n*F\n+ 1 MovableGuiElement.kt\nfunnymap/ui/MovableGuiElement\n*L\n44#1:136,2\n*E\n"})
public abstract class MovableGuiElement {
   @NotNull
   private final CornerButton[] corners;
   private float scale;

   public MovableGuiElement() {
      CornerButton[] var1 = new CornerButton[]{new CornerButton(0.0D, 0.0D, CornerButton.Corner.TOP_LEFT), new CornerButton(0.0D, 0.0D, CornerButton.Corner.TOP_RIGHT), new CornerButton(0.0D, 0.0D, CornerButton.Corner.BOTTOM_LEFT), new CornerButton(0.0D, 0.0D, CornerButton.Corner.BOTTOM_RIGHT)};
      this.corners = var1;
      this.scale = 1.0F;
   }

   @NotNull
   public final CornerButton[] getCorners() {
      return this.corners;
   }

   public abstract int getX();

   public abstract void setX(int var1);

   public abstract int getY();

   public abstract void setY(int var1);

   public abstract int getX2();

   public abstract void setX2(int var1);

   public abstract int getY2();

   public abstract void setY2(int var1);

   public abstract int getW();

   public abstract int getH();

   public float getScale() {
      return this.scale;
   }

   public void setScale(float <set-?>) {
      this.scale = var1;
   }

   public void draw(int mouseX, int mouseY) {
      GlStateManager.func_179094_E();
      GlStateManager.func_179109_b((float)this.getX(), (float)this.getY(), 0.0F);
      GlStateManager.func_179152_a(this.getScale(), this.getScale(), 1.0F);
      this.render();
      GlStateManager.func_179121_F();
      RenderUtils.INSTANCE.renderRectBorder((double)this.getX(), (double)this.getY(), (double)this.getW() * (double)this.getScale(), (double)this.getH() * (double)this.getScale(), 0.5D, new Color(255, 255, 255));
      this.updateCorners();
      Object[] $this$forEach$iv = this.corners;
      int $i$f$forEach = false;
      int var5 = 0;

      for(int var6 = $this$forEach$iv.length; var5 < var6; ++var5) {
         Object element$iv = $this$forEach$iv[var5];
         int var9 = false;
         element$iv.draw();
      }

   }

   public void render() {
   }

   public boolean shouldRender() {
      return true;
   }

   public final boolean isHovered(int mouseX, int mouseY) {
      int var3 = this.getX();
      boolean var10000;
      if (mouseX <= this.getX2() ? var3 <= mouseX : false) {
         var3 = this.getY();
         if (mouseY <= this.getY2() ? var3 <= mouseY : false) {
            var10000 = true;
            return var10000;
         }
      }

      var10000 = false;
      return var10000;
   }

   private final void updateCorners() {
      this.corners[0].setX((double)this.getX() - 3.0D);
      this.corners[0].setY((double)this.getY() - 3.0D);
      this.corners[1].setX((double)this.getX2() - 3.0D);
      this.corners[1].setY((double)this.getY() - 3.0D);
      this.corners[2].setX((double)this.getX() - 3.0D);
      this.corners[2].setY((double)this.getY2() - 3.0D);
      this.corners[3].setX((double)this.getX2() - 3.0D);
      this.corners[3].setY((double)this.getY2() - 3.0D);
   }

   public final void setLocation(int x, int y) {
      this.setX(RangesKt.coerceIn(x, 0, (int)((float)FunnyMap.INSTANCE.getMc().field_71443_c - (float)this.getW() * this.getScale())));
      this.setY(RangesKt.coerceIn(y, 0, (int)((float)FunnyMap.INSTANCE.getMc().field_71440_d - (float)this.getH() * this.getScale())));
      this.setX2((int)((float)x + (float)this.getW() * this.getScale()));
      this.setY2((int)((float)y + (float)this.getH() * this.getScale()));
   }

   public final void mouseScroll(int direction) {
      if (direction != 0) {
         float increment = (float)direction * 0.01F;
         if (!GuiScreen.func_146272_n()) {
            increment *= (float)5;
         }

         this.setScale(RangesKt.coerceAtLeast(this.getScale() + increment, 0.1F));
         this.setX2((int)((float)this.getX() + (float)this.getW() * this.getScale()));
         this.setY2((int)((float)this.getY() + (float)this.getH() * this.getScale()));
      }

   }

   public final void cornerDrag(int mouseX, int mouseY, @NotNull CornerButton.Corner corner) {
      Intrinsics.checkNotNullParameter(corner, "corner");
      float maxScaleLeft = (float)this.getX2() / (float)this.getW();
      float maxScaleTop = (float)this.getY2() / (float)this.getH();
      float maxScaleRight = (float)(FunnyMap.INSTANCE.getMc().field_71443_c - this.getX()) / (float)this.getW();
      float maxScaleBottom = (float)(FunnyMap.INSTANCE.getMc().field_71440_d - this.getY()) / (float)this.getH();
      float s;
      switch(MovableGuiElement.WhenMappings.$EnumSwitchMapping$0[corner.ordinal()]) {
      case 1:
         s = ((Number)RangesKt.coerceIn((Comparable)Math.max((float)(this.getX2() - mouseX) / (float)this.getW(), (float)(this.getY2() - mouseY) / (float)this.getH()), RangesKt.rangeTo(0.1F, Math.min(maxScaleTop, maxScaleLeft)))).floatValue();
         s = (float)((int)(s * (float)100)) / 100.0F;
         this.setX((int)((float)this.getX2() - (float)this.getW() * s));
         this.setY((int)((float)this.getY2() - (float)this.getH() * s));
         this.setScale(s);
         break;
      case 2:
         s = ((Number)RangesKt.coerceIn((Comparable)Math.max((float)(mouseX - this.getX()) / (float)this.getW(), (float)(this.getY2() - mouseY) / (float)this.getH()), RangesKt.rangeTo(0.1F, Math.min(maxScaleTop, maxScaleRight)))).floatValue();
         s = (float)((int)(s * (float)100)) / 100.0F;
         this.setX2((int)((float)this.getX() + (float)this.getW() * s));
         this.setY((int)((float)this.getY2() - (float)this.getH() * s));
         this.setScale(s);
         break;
      case 3:
         s = ((Number)RangesKt.coerceIn((Comparable)Math.max((float)(this.getX2() - mouseX) / (float)this.getW(), (float)(mouseY - this.getY()) / (float)this.getH()), RangesKt.rangeTo(0.1F, Math.min(maxScaleBottom, maxScaleLeft)))).floatValue();
         s = (float)((int)(s * (float)100)) / 100.0F;
         this.setX((int)((float)this.getX2() - (float)this.getW() * s));
         this.setY2((int)((float)this.getY() + (float)this.getH() * s));
         this.setScale(s);
         break;
      case 4:
         s = ((Number)RangesKt.coerceIn((Comparable)Math.max((float)(mouseX - this.getX()) / (float)this.getW(), (float)(mouseY - this.getY()) / (float)this.getH()), RangesKt.rangeTo(0.1F, Math.min(maxScaleBottom, maxScaleRight)))).floatValue();
         s = (float)((int)(s * (float)100)) / 100.0F;
         this.setX2((int)((float)this.getX() + (float)this.getW() * s));
         this.setY2((int)((float)this.getY() + (float)this.getH() * s));
         this.setScale(s);
      }

   }

   public final void keyTyped(int keyCode) {
      int increment = GuiScreen.func_146272_n() ? 5 : 1;
      switch(keyCode) {
      case 200:
         this.setLocation(this.getX(), this.getY() - increment);
         break;
      case 203:
         this.setLocation(this.getX() - increment, this.getY());
         break;
      case 205:
         this.setLocation(this.getX() + increment, this.getY());
         break;
      case 208:
         this.setLocation(this.getX(), this.getY() + increment);
      }

   }

   // $FF: synthetic class
   @Metadata(
      mv = {1, 9, 0},
      k = 3,
      xi = 48
   )
   public class WhenMappings {
      // $FF: synthetic field
      public static final int[] $EnumSwitchMapping$0;

      static {
         int[] var0 = new int[CornerButton.Corner.values().length];

         try {
            var0[CornerButton.Corner.TOP_LEFT.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[CornerButton.Corner.TOP_RIGHT.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[CornerButton.Corner.BOTTOM_LEFT.ordinal()] = 3;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[CornerButton.Corner.BOTTOM_RIGHT.ordinal()] = 4;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
