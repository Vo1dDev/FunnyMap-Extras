package funnymap.utils;

import funnymap.FunnyMap;
import funnymap.config.Config;
import funnymap.core.map.RoomState;
import funnymap.features.dungeon.MapRender;
import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b+\u0010\u000bJ%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\u000bJ3\u0010\u0013\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0003\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J5\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0018\u0010\u0019J=\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u0007¢\u0006\u0004\b\u001e\u0010\u000bJ\u0013\u0010\u001f\u001a\u00020\u0007*\u00020\u0011H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0011\u0010\u001f\u001a\u00020\u0007*\u00020!¢\u0006\u0004\b\u001f\u0010\"R\u0016\u0010#\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006,"},
   d2 = {"Lfunnymap/utils/RenderUtilsGL;", "", "", "x", "y", "Lfunnymap/core/map/RoomState;", "state", "", "drawCheckmark", "(FFLfunnymap/core/map/RoomState;)V", "postDraw", "()V", "preDraw", "", "", "text", "", "Ljava/awt/Color;", "color", "renderCenteredText", "(Ljava/util/List;IILjava/awt/Color;)V", "", "w", "h", "renderRect", "(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/awt/Color;)V", "", "thickness", "renderRectBorder", "(DDDDDLjava/awt/Color;)V", "unbindTexture", "bind", "(Ljava/awt/Color;)V", "Lnet/minecraft/util/ResourceLocation;", "(Lnet/minecraft/util/ResourceLocation;)V", "currentTexture", "I", "Lnet/minecraft/client/renderer/Tessellator;", "tessellator", "Lnet/minecraft/client/renderer/Tessellator;", "Lnet/minecraft/client/renderer/WorldRenderer;", "worldRenderer", "Lnet/minecraft/client/renderer/WorldRenderer;", "<init>", "FunnyMapExtras"}
)
@SourceDebugExtension({"SMAP\nRenderUtilsGL.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RenderUtilsGL.kt\nfunnymap/utils/RenderUtilsGL\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,136:1\n1855#2,2:137\n*S KotlinDebug\n*F\n+ 1 RenderUtilsGL.kt\nfunnymap/utils/RenderUtilsGL\n*L\n80#1:137,2\n*E\n"})
public final class RenderUtilsGL {
   @NotNull
   public static final RenderUtilsGL INSTANCE = new RenderUtilsGL();
   @NotNull
   private static final Tessellator tessellator;
   @NotNull
   private static final WorldRenderer worldRenderer;
   private static int currentTexture;

   private RenderUtilsGL() {
   }

   public final void preDraw() {
      GL11.glEnable(3008);
      GL11.glEnable(3042);
      GL11.glDisable(2929);
      GL11.glDisable(2896);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
   }

   public final void postDraw() {
      GL11.glDisable(3042);
      GL11.glEnable(2929);
      GL11.glEnable(3553);
   }

   public final void renderRect(@NotNull Number x, @NotNull Number y, @NotNull Number w, @NotNull Number h, @NotNull Color color) {
      Intrinsics.checkNotNullParameter(x, "x");
      Intrinsics.checkNotNullParameter(y, "y");
      Intrinsics.checkNotNullParameter(w, "w");
      Intrinsics.checkNotNullParameter(h, "h");
      Intrinsics.checkNotNullParameter(color, "color");
      if (color.getAlpha() != 0) {
         this.preDraw();
         this.bind(color);
         worldRenderer.func_181668_a(7, DefaultVertexFormats.field_181705_e);
         RenderUtils.INSTANCE.addQuadVertices(x.doubleValue(), y.doubleValue(), w.doubleValue(), h.doubleValue());
         tessellator.func_78381_a();
         this.postDraw();
      }
   }

   public final void renderRectBorder(double x, double y, double w, double h, double thickness, @NotNull Color color) {
      Intrinsics.checkNotNullParameter(color, "color");
      if (color.getAlpha() != 0) {
         this.preDraw();
         this.bind(color);
         worldRenderer.func_181668_a(7, DefaultVertexFormats.field_181705_e);
         RenderUtils.INSTANCE.addQuadVertices(x - thickness, y, thickness, h);
         RenderUtils.INSTANCE.addQuadVertices(x - thickness, y - thickness, w + thickness * (double)2, thickness);
         RenderUtils.INSTANCE.addQuadVertices(x + w, y, thickness, h);
         RenderUtils.INSTANCE.addQuadVertices(x - thickness, y + h, w + thickness * (double)2, thickness);
         tessellator.func_78381_a();
         this.postDraw();
      }
   }

   public final void renderCenteredText(@NotNull List<String> text, int x, int y, @NotNull Color color) {
      Intrinsics.checkNotNullParameter(text, "text");
      Intrinsics.checkNotNullParameter(color, "color");
      if (!text.isEmpty()) {
         GlStateManager.func_179094_E();
         GlStateManager.func_179109_b((float)x, (float)y, 0.0F);
         GlStateManager.func_179152_a(Config.INSTANCE.getTextScale(), Config.INSTANCE.getTextScale(), 1.0F);
         if (Config.INSTANCE.getMapRotate()) {
            GlStateManager.func_179114_b(FunnyMap.INSTANCE.getMc().field_71439_g.field_70177_z + 180.0F, 0.0F, 0.0F, 1.0F);
         } else if (Config.INSTANCE.getMapDynamicRotate()) {
            GlStateManager.func_179114_b(-MapRender.INSTANCE.getDynamicRotation(), 0.0F, 0.0F, 1.0F);
         }

         int fontHeight = 10;
         float yTextOffset = (float)(text.size() * fontHeight) / -2.0F;
         Iterable $this$forEach$iv = CollectionsKt.withIndex((Iterable)text);
         int $i$f$forEach = false;
         Iterator var9 = $this$forEach$iv.iterator();

         while(var9.hasNext()) {
            Object element$iv = var9.next();
            IndexedValue var11 = (IndexedValue)element$iv;
            int var12 = false;
            int index = var11.component1();
            String text = (String)var11.component2();
            SimpleFontRenderer.INSTANCE.drawString(text, (float)SimpleFontRenderer.INSTANCE.getStringWidth(text) / -2.0F, yTextOffset + (float)(index * fontHeight), color, true);
         }

         GlStateManager.func_179121_F();
      }
   }

   public final void drawCheckmark(float x, float y, @NotNull RoomState state) {
      Intrinsics.checkNotNullParameter(state, "state");
      Pair var10000;
      switch(Config.INSTANCE.getMapCheckmark()) {
      case 1:
         var10000 = TuplesKt.to(RenderUtils.INSTANCE.getDefaultCheckmarks().getCheckmark(state), (double)RenderUtils.INSTANCE.getDefaultCheckmarks().getSize());
         break;
      case 2:
         var10000 = TuplesKt.to(RenderUtils.INSTANCE.getNeuCheckmarks().getCheckmark(state), (double)RenderUtils.INSTANCE.getNeuCheckmarks().getSize());
         break;
      case 3:
         var10000 = TuplesKt.to(RenderUtils.INSTANCE.getLegacyCheckmarks().getCheckmark(state), (double)RenderUtils.INSTANCE.getLegacyCheckmarks().getSize());
         break;
      default:
         return;
      }

      Pair var4 = var10000;
      ResourceLocation checkmark = (ResourceLocation)var4.component1();
      double size = ((Number)var4.component2()).doubleValue();
      if (checkmark != null) {
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glEnable(3008);
         GL11.glEnable(3553);
         this.bind(checkmark);
         RenderUtils.INSTANCE.drawTexturedQuad((double)x + ((double)MapUtils.INSTANCE.getRoomSize() - size) / (double)2, (double)y + ((double)MapUtils.INSTANCE.getRoomSize() - size) / (double)2, size, size);
      }

   }

   private final void bind(Color $this$bind) {
      GL11.glColor4f((float)$this$bind.getRed() / 255.0F, (float)$this$bind.getGreen() / 255.0F, (float)$this$bind.getBlue() / 255.0F, (float)$this$bind.getAlpha() / 255.0F);
   }

   public final void bind(@NotNull ResourceLocation $this$bind) {
      Intrinsics.checkNotNullParameter($this$bind, "<this>");
      ITextureObject tex = FunnyMap.INSTANCE.getMc().func_110434_K().func_110581_b($this$bind);
      if (tex == null) {
         tex = (ITextureObject)(new SimpleTexture($this$bind));
         FunnyMap.INSTANCE.getMc().func_110434_K().func_110579_a($this$bind, tex);
      }

      if (tex.func_110552_b() != currentTexture) {
         GL11.glBindTexture(3553, tex.func_110552_b());
         currentTexture = tex.func_110552_b();
      }

   }

   public final void unbindTexture() {
      GL11.glBindTexture(3553, 0);
      currentTexture = 0;
   }

   static {
      Tessellator var10000 = Tessellator.func_178181_a();
      Intrinsics.checkNotNullExpressionValue(var10000, "getInstance(...)");
      tessellator = var10000;
      WorldRenderer var0 = tessellator.func_178180_c();
      Intrinsics.checkNotNullExpressionValue(var0, "getWorldRenderer(...)");
      worldRenderer = var0;
   }
}
