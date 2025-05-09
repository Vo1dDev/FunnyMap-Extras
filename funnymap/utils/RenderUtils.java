package funnymap.utils;

import funnymap.FunnyMap;
import funnymap.config.Config;
import funnymap.core.DungeonPlayer;
import funnymap.core.map.RoomState;
import funnymap.features.dungeon.MapRender;
import gg.essential.elementa.utils.ExtensionsKt;
import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bV\u0010-J-\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ=\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u001c\u0010\u001bJ\u001d\u0010!\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"JM\u0010(\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u0012¢\u0006\u0004\b(\u0010)J-\u0010+\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u0002¢\u0006\u0004\b+\u0010\tJ\u000f\u0010,\u001a\u00020\u0007H\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0007H\u0002¢\u0006\u0004\b.\u0010-J3\u00100\u001a\u00020\u00072\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001d0/2\u0006\u0010\u0003\u001a\u00020%2\u0006\u0010\u0004\u001a\u00020%2\u0006\u0010\r\u001a\u00020%¢\u0006\u0004\b0\u00101J5\u00103\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u0002022\u0006\u0010\u0004\u001a\u0002022\u0006\u0010\u0005\u001a\u0002022\u0006\u0010\u0006\u001a\u0002022\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b3\u00104J=\u00106\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b6\u00107J\u0011\u00108\u001a\u00020\u0007*\u00020\f¢\u0006\u0004\b8\u00109J\u0019\u0010;\u001a\u00020\f*\u00020\f2\u0006\u0010:\u001a\u00020\u000e¢\u0006\u0004\b;\u0010<J+\u0010@\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020?*\u00020=2\u0006\u0010>\u001a\u00020\u000e¢\u0006\u0004\b@\u0010AJ\u0011\u0010B\u001a\u00020\f*\u00020\f¢\u0006\u0004\bB\u0010CR\u0017\u0010E\u001a\u00020D8\u0006¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u0017\u0010I\u001a\u00020D8\u0006¢\u0006\f\n\u0004\bI\u0010F\u001a\u0004\bJ\u0010HR\u0014\u0010L\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0017\u0010N\u001a\u00020D8\u0006¢\u0006\f\n\u0004\bN\u0010F\u001a\u0004\bO\u0010HR\u0014\u0010Q\u001a\u00020P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010T\u001a\u00020S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010U¨\u0006W"},
   d2 = {"Lfunnymap/utils/RenderUtils;", "", "", "x", "y", "w", "h", "", "addQuadVertices", "(DDDD)V", "Lnet/minecraft/util/AxisAlignedBB;", "aabb", "Ljava/awt/Color;", "color", "", "width", "outline", "fill", "", "ignoreDepth", "drawBox", "(Lnet/minecraft/util/AxisAlignedBB;Ljava/awt/Color;FFFZ)V", "Lfunnymap/core/map/RoomState;", "state", "drawCheckmark", "(FFLfunnymap/core/map/RoomState;)V", "drawFilledAABB", "(Lnet/minecraft/util/AxisAlignedBB;Ljava/awt/Color;)V", "drawOutlinedAABB", "", "name", "Lfunnymap/core/DungeonPlayer;", "player", "drawPlayerHead", "(Ljava/lang/String;Lfunnymap/core/DungeonPlayer;)V", "text", "scale", "", "shadow", "center", "drawText", "(Ljava/lang/String;FFDIZZ)V", "height", "drawTexturedQuad", "postDraw", "()V", "preDraw", "", "renderCenteredText", "(Ljava/util/List;III)V", "", "renderRect", "(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/awt/Color;)V", "thickness", "renderRectBorder", "(DDDDDLjava/awt/Color;)V", "bind", "(Ljava/awt/Color;)V", "factor", "darken", "(Ljava/awt/Color;F)Ljava/awt/Color;", "Lnet/minecraft/entity/Entity;", "partialTicks", "Lkotlin/Triple;", "getInterpolatedPosition", "(Lnet/minecraft/entity/Entity;F)Lkotlin/Triple;", "grayScale", "(Ljava/awt/Color;)Ljava/awt/Color;", "Lfunnymap/utils/CheckmarkSet;", "defaultCheckmarks", "Lfunnymap/utils/CheckmarkSet;", "getDefaultCheckmarks", "()Lfunnymap/utils/CheckmarkSet;", "legacyCheckmarks", "getLegacyCheckmarks", "Lnet/minecraft/util/ResourceLocation;", "mapIcons", "Lnet/minecraft/util/ResourceLocation;", "neuCheckmarks", "getNeuCheckmarks", "Lnet/minecraft/client/renderer/Tessellator;", "tessellator", "Lnet/minecraft/client/renderer/Tessellator;", "Lnet/minecraft/client/renderer/WorldRenderer;", "worldRenderer", "Lnet/minecraft/client/renderer/WorldRenderer;", "<init>", "FunnyMapExtras"}
)
@SourceDebugExtension({"SMAP\nRenderUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RenderUtils.kt\nfunnymap/utils/RenderUtils\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,372:1\n1855#2,2:373\n1855#2,2:375\n*S KotlinDebug\n*F\n+ 1 RenderUtils.kt\nfunnymap/utils/RenderUtils\n*L\n123#1:373,2\n267#1:375,2\n*E\n"})
public final class RenderUtils {
   @NotNull
   public static final RenderUtils INSTANCE = new RenderUtils();
   @NotNull
   private static final Tessellator tessellator;
   @NotNull
   private static final WorldRenderer worldRenderer;
   @NotNull
   private static final CheckmarkSet neuCheckmarks;
   @NotNull
   private static final CheckmarkSet defaultCheckmarks;
   @NotNull
   private static final CheckmarkSet legacyCheckmarks;
   @NotNull
   private static final ResourceLocation mapIcons;

   private RenderUtils() {
   }

   @NotNull
   public final CheckmarkSet getNeuCheckmarks() {
      return neuCheckmarks;
   }

   @NotNull
   public final CheckmarkSet getDefaultCheckmarks() {
      return defaultCheckmarks;
   }

   @NotNull
   public final CheckmarkSet getLegacyCheckmarks() {
      return legacyCheckmarks;
   }

   private final void preDraw() {
      GlStateManager.func_179141_d();
      GlStateManager.func_179147_l();
      GlStateManager.func_179097_i();
      GlStateManager.func_179140_f();
      GlStateManager.func_179090_x();
      GlStateManager.func_179120_a(770, 771, 1, 0);
   }

   private final void postDraw() {
      GlStateManager.func_179084_k();
      GlStateManager.func_179126_j();
      GlStateManager.func_179098_w();
   }

   public final void addQuadVertices(double x, double y, double w, double h) {
      worldRenderer.func_181662_b(x, y + h, 0.0D).func_181675_d();
      worldRenderer.func_181662_b(x + w, y + h, 0.0D).func_181675_d();
      worldRenderer.func_181662_b(x + w, y, 0.0D).func_181675_d();
      worldRenderer.func_181662_b(x, y, 0.0D).func_181675_d();
   }

   public final void drawTexturedQuad(double x, double y, double width, double height) {
      worldRenderer.func_181668_a(7, DefaultVertexFormats.field_181707_g);
      worldRenderer.func_181662_b(x, y + height, 0.0D).func_181673_a(0.0D, 1.0D).func_181675_d();
      worldRenderer.func_181662_b(x + width, y + height, 0.0D).func_181673_a(1.0D, 1.0D).func_181675_d();
      worldRenderer.func_181662_b(x + width, y, 0.0D).func_181673_a(1.0D, 0.0D).func_181675_d();
      worldRenderer.func_181662_b(x, y, 0.0D).func_181673_a(0.0D, 0.0D).func_181675_d();
      tessellator.func_78381_a();
   }

   public final void drawBox(@NotNull AxisAlignedBB aabb, @NotNull Color color, float width, float outline, float fill, boolean ignoreDepth) {
      Intrinsics.checkNotNullParameter(aabb, "aabb");
      Intrinsics.checkNotNullParameter(color, "color");
      GlStateManager.func_179094_E();
      this.preDraw();
      GlStateManager.func_179132_a(!ignoreDepth);
      GL11.glLineWidth(width);
      this.drawOutlinedAABB(aabb, ExtensionsKt.withAlpha(color, outline));
      this.drawFilledAABB(aabb, ExtensionsKt.withAlpha(color, fill));
      GlStateManager.func_179132_a(true);
      this.postDraw();
      GlStateManager.func_179121_F();
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
         this.addQuadVertices(x.doubleValue(), y.doubleValue(), w.doubleValue(), h.doubleValue());
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
         this.addQuadVertices(x - thickness, y, thickness, h);
         this.addQuadVertices(x - thickness, y - thickness, w + thickness * (double)2, thickness);
         this.addQuadVertices(x + w, y, thickness, h);
         this.addQuadVertices(x - thickness, y + h, w + thickness * (double)2, thickness);
         tessellator.func_78381_a();
         this.postDraw();
      }
   }

   public final void renderCenteredText(@NotNull List<String> text, int x, int y, int color) {
      Intrinsics.checkNotNullParameter(text, "text");
      if (!text.isEmpty()) {
         GlStateManager.func_179094_E();
         GlStateManager.func_179109_b((float)x, (float)y, 0.0F);
         GlStateManager.func_179152_a(Config.INSTANCE.getTextScale(), Config.INSTANCE.getTextScale(), 1.0F);
         if (Config.INSTANCE.getMapRotate()) {
            GlStateManager.func_179114_b(FunnyMap.INSTANCE.getMc().field_71439_g.field_70177_z + 180.0F, 0.0F, 0.0F, 1.0F);
         } else if (Config.INSTANCE.getMapDynamicRotate()) {
            GlStateManager.func_179114_b(-MapRender.INSTANCE.getDynamicRotation(), 0.0F, 0.0F, 1.0F);
         }

         int fontHeight = FunnyMap.INSTANCE.getMc().field_71466_p.field_78288_b + 1;
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
            FunnyMap.INSTANCE.getMc().field_71466_p.func_175065_a(text, (float)FunnyMap.INSTANCE.getMc().field_71466_p.func_78256_a(text) / -2.0F, yTextOffset + (float)(index * fontHeight), color, true);
         }

         if (Config.INSTANCE.getMapDynamicRotate()) {
            GlStateManager.func_179114_b(MapRender.INSTANCE.getDynamicRotation(), 0.0F, 0.0F, 1.0F);
         }

         GlStateManager.func_179121_F();
      }
   }

   public final void drawCheckmark(float x, float y, @NotNull RoomState state) {
      Intrinsics.checkNotNullParameter(state, "state");
      Pair var10000;
      switch(Config.INSTANCE.getMapCheckmark()) {
      case 1:
         var10000 = TuplesKt.to(defaultCheckmarks.getCheckmark(state), (double)defaultCheckmarks.getSize());
         break;
      case 2:
         var10000 = TuplesKt.to(neuCheckmarks.getCheckmark(state), (double)neuCheckmarks.getSize());
         break;
      case 3:
         var10000 = TuplesKt.to(legacyCheckmarks.getCheckmark(state), (double)legacyCheckmarks.getSize());
         break;
      default:
         return;
      }

      Pair var4 = var10000;
      ResourceLocation checkmark = (ResourceLocation)var4.component1();
      double size = ((Number)var4.component2()).doubleValue();
      if (checkmark != null) {
         GlStateManager.func_179141_d();
         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
         FunnyMap.INSTANCE.getMc().func_110434_K().func_110577_a(checkmark);
         this.drawTexturedQuad((double)x + ((double)MapUtils.INSTANCE.getRoomSize() - size) / (double)2, (double)y + ((double)MapUtils.INSTANCE.getRoomSize() - size) / (double)2, size, size);
         GlStateManager.func_179118_c();
      }

   }

   public final void drawPlayerHead(@NotNull String name, @NotNull DungeonPlayer player) {
      Intrinsics.checkNotNullParameter(name, "name");
      Intrinsics.checkNotNullParameter(player, "player");
      GlStateManager.func_179094_E();

      try {
         label70: {
            if (!player.isPlayer() && !Intrinsics.areEqual(name, FunnyMap.INSTANCE.getMc().field_71439_g.func_70005_c_())) {
               GlStateManager.func_179109_b((float)player.getMapX(), (float)player.getMapZ(), 0.0F);
            } else {
               GlStateManager.func_179137_b((FunnyMap.INSTANCE.getMc().field_71439_g.field_70165_t - (double)-185 + (double)15) * MapUtils.INSTANCE.getCoordMultiplier() + ((Number)MapUtils.INSTANCE.getStartCorner().getFirst()).doubleValue(), (FunnyMap.INSTANCE.getMc().field_71439_g.field_70161_v - (double)-185 + (double)15) * MapUtils.INSTANCE.getCoordMultiplier() + ((Number)MapUtils.INSTANCE.getStartCorner().getSecond()).doubleValue(), 0.0D);
            }

            GlStateManager.func_179114_b(player.getYaw() + 180.0F, 0.0F, 0.0F, 1.0F);
            GlStateManager.func_179152_a(Config.INSTANCE.getPlayerHeadScale(), Config.INSTANCE.getPlayerHeadScale(), 1.0F);
            GlStateManager.func_179141_d();
            if (Config.INSTANCE.getMapVanillaMarker() && (player.isPlayer() || Intrinsics.areEqual(name, FunnyMap.INSTANCE.getMc().field_71439_g.func_70005_c_()))) {
               GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
               GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
               FunnyMap.INSTANCE.getMc().func_110434_K().func_110577_a(mapIcons);
               worldRenderer.func_181668_a(7, DefaultVertexFormats.field_181707_g);
               worldRenderer.func_181662_b(-6.0D, 6.0D, 0.0D).func_181673_a(0.0D, 0.0D).func_181675_d();
               worldRenderer.func_181662_b(6.0D, 6.0D, 0.0D).func_181673_a(1.0D, 0.0D).func_181675_d();
               worldRenderer.func_181662_b(6.0D, -6.0D, 0.0D).func_181673_a(1.0D, 1.0D).func_181675_d();
               worldRenderer.func_181662_b(-6.0D, -6.0D, 0.0D).func_181673_a(0.0D, 1.0D).func_181675_d();
               tessellator.func_78381_a();
               GlStateManager.func_179114_b(-180.0F, 0.0F, 0.0F, 1.0F);
            } else {
               this.renderRectBorder(-6.0D, -6.0D, 12.0D, 12.0D, 1.0D, new Color(0, 0, 0, 255));
               this.preDraw();
               GlStateManager.func_179098_w();
               GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
               FunnyMap.INSTANCE.getMc().func_110434_K().func_110577_a(player.getSkin());
               Gui.func_152125_a(-6, -6, 8.0F, 8.0F, 8, 8, 12, 12, 64.0F, 64.0F);
               if (player.getRenderHat()) {
                  Gui.func_152125_a(-6, -6, 40.0F, 8.0F, 8, 8, 12, 12, 64.0F, 64.0F);
               }

               this.postDraw();
            }

            if (Config.INSTANCE.getPlayerHeads() != 2) {
               if (Config.INSTANCE.getPlayerHeads() != 1) {
                  break label70;
               }

               Utils var10000 = Utils.INSTANCE;
               ItemStack var10001 = FunnyMap.INSTANCE.getMc().field_71439_g.func_70694_bm();
               String var5 = var10001 != null ? Utils.INSTANCE.getItemID(var10001) : null;
               Object[] var3 = new Object[]{"SPIRIT_LEAP", "INFINITE_SPIRIT_LEAP", "HAUNT_ABILITY"};
               if (!var10000.equalsOneOf(var5, var3)) {
                  break label70;
               }
            }

            if (!Config.INSTANCE.getMapRotate()) {
               GlStateManager.func_179114_b(-player.getYaw() + 180.0F, 0.0F, 0.0F, 1.0F);
            }

            GlStateManager.func_179109_b(0.0F, 10.0F, 0.0F);
            GlStateManager.func_179152_a(Config.INSTANCE.getPlayerNameScale(), Config.INSTANCE.getPlayerNameScale(), 1.0F);
            FunnyMap.INSTANCE.getMc().field_71466_p.func_175065_a(name, (float)(-FunnyMap.INSTANCE.getMc().field_71466_p.func_78256_a(name)) / 2.0F, 0.0F, 16777215, true);
         }
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      GlStateManager.func_179121_F();
   }

   public final void bind(@NotNull Color $this$bind) {
      Intrinsics.checkNotNullParameter($this$bind, "<this>");
      GlStateManager.func_179131_c((float)$this$bind.getRed() / 255.0F, (float)$this$bind.getGreen() / 255.0F, (float)$this$bind.getBlue() / 255.0F, (float)$this$bind.getAlpha() / 255.0F);
   }

   @NotNull
   public final Color grayScale(@NotNull Color $this$grayScale) {
      Intrinsics.checkNotNullParameter($this$grayScale, "<this>");
      int gray = MathKt.roundToInt((double)$this$grayScale.getRed() * 0.299D + (double)$this$grayScale.getGreen() * 0.587D + (double)$this$grayScale.getBlue() * 0.114D);
      return new Color(gray, gray, gray, $this$grayScale.getAlpha());
   }

   @NotNull
   public final Color darken(@NotNull Color $this$darken, float factor) {
      Intrinsics.checkNotNullParameter($this$darken, "<this>");
      return new Color(MathKt.roundToInt((float)$this$darken.getRed() * factor), MathKt.roundToInt((float)$this$darken.getGreen() * factor), MathKt.roundToInt((float)$this$darken.getBlue() * factor), $this$darken.getAlpha());
   }

   @NotNull
   public final Triple<Double, Double, Double> getInterpolatedPosition(@NotNull Entity $this$getInterpolatedPosition, float partialTicks) {
      Intrinsics.checkNotNullParameter($this$getInterpolatedPosition, "<this>");
      return new Triple($this$getInterpolatedPosition.field_70142_S + ($this$getInterpolatedPosition.field_70165_t - $this$getInterpolatedPosition.field_70142_S) * (double)partialTicks, $this$getInterpolatedPosition.field_70137_T + ($this$getInterpolatedPosition.field_70163_u - $this$getInterpolatedPosition.field_70137_T) * (double)partialTicks, $this$getInterpolatedPosition.field_70136_U + ($this$getInterpolatedPosition.field_70161_v - $this$getInterpolatedPosition.field_70136_U) * (double)partialTicks);
   }

   public final void drawText(@NotNull String text, float x, float y, double scale, int color, boolean shadow, boolean center) {
      Intrinsics.checkNotNullParameter(text, "text");
      GlStateManager.func_179094_E();
      GlStateManager.func_179147_l();
      GlStateManager.func_179120_a(770, 771, 1, 0);
      GlStateManager.func_179109_b(x, y, 0.0F);
      GlStateManager.func_179139_a(scale, scale, scale);
      float yOffset = 0.0F;
      yOffset = y - (float)FunnyMap.INSTANCE.getMc().field_71466_p.field_78288_b;
      CharSequence var10000 = (CharSequence)text;
      String[] var10 = new String[]{"\n"};
      Iterable $this$forEach$iv = (Iterable)StringsKt.split$default(var10000, var10, false, 0, 6, (Object)null);
      int $i$f$forEach = false;
      Iterator var12 = $this$forEach$iv.iterator();

      while(var12.hasNext()) {
         Object element$iv = var12.next();
         String it = (String)element$iv;
         int var15 = false;
         yOffset += (float)FunnyMap.INSTANCE.getMc().field_71466_p.field_78288_b;
         float xOffset = center ? (float)FunnyMap.INSTANCE.getMc().field_71466_p.func_78256_a(it) / -2.0F : 0.0F;
         FunnyMap.INSTANCE.getMc().field_71466_p.func_175065_a(it, xOffset, 0.0F, color, shadow);
      }

      GlStateManager.func_179084_k();
      GlStateManager.func_179121_F();
   }

   // $FF: synthetic method
   public static void drawText$default(RenderUtils var0, String var1, float var2, float var3, double var4, int var6, boolean var7, boolean var8, int var9, Object var10) {
      if ((var9 & 8) != 0) {
         var4 = 1.0D;
      }

      if ((var9 & 16) != 0) {
         var6 = 16777215;
      }

      if ((var9 & 32) != 0) {
         var7 = true;
      }

      if ((var9 & 64) != 0) {
         var8 = false;
      }

      var0.drawText(var1, var2, var3, var4, var6, var7, var8);
   }

   public final void drawFilledAABB(@NotNull AxisAlignedBB aabb, @NotNull Color color) {
      Intrinsics.checkNotNullParameter(aabb, "aabb");
      Intrinsics.checkNotNullParameter(color, "color");
      this.bind(color);
      worldRenderer.func_181668_a(7, DefaultVertexFormats.field_181705_e);
      worldRenderer.func_181662_b(aabb.field_72340_a, aabb.field_72338_b, aabb.field_72339_c).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72340_a, aabb.field_72337_e, aabb.field_72339_c).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72336_d, aabb.field_72338_b, aabb.field_72339_c).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72336_d, aabb.field_72337_e, aabb.field_72339_c).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72336_d, aabb.field_72338_b, aabb.field_72334_f).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72336_d, aabb.field_72337_e, aabb.field_72334_f).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72340_a, aabb.field_72338_b, aabb.field_72334_f).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72340_a, aabb.field_72337_e, aabb.field_72334_f).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72336_d, aabb.field_72337_e, aabb.field_72339_c).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72336_d, aabb.field_72338_b, aabb.field_72339_c).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72340_a, aabb.field_72337_e, aabb.field_72339_c).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72340_a, aabb.field_72338_b, aabb.field_72339_c).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72340_a, aabb.field_72337_e, aabb.field_72334_f).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72340_a, aabb.field_72338_b, aabb.field_72334_f).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72336_d, aabb.field_72337_e, aabb.field_72334_f).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72336_d, aabb.field_72338_b, aabb.field_72334_f).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72340_a, aabb.field_72337_e, aabb.field_72339_c).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72336_d, aabb.field_72337_e, aabb.field_72339_c).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72336_d, aabb.field_72337_e, aabb.field_72334_f).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72340_a, aabb.field_72337_e, aabb.field_72334_f).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72340_a, aabb.field_72337_e, aabb.field_72339_c).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72340_a, aabb.field_72337_e, aabb.field_72334_f).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72336_d, aabb.field_72337_e, aabb.field_72334_f).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72336_d, aabb.field_72337_e, aabb.field_72339_c).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72340_a, aabb.field_72338_b, aabb.field_72339_c).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72336_d, aabb.field_72338_b, aabb.field_72339_c).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72336_d, aabb.field_72338_b, aabb.field_72334_f).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72340_a, aabb.field_72338_b, aabb.field_72334_f).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72340_a, aabb.field_72338_b, aabb.field_72339_c).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72340_a, aabb.field_72338_b, aabb.field_72334_f).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72336_d, aabb.field_72338_b, aabb.field_72334_f).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72336_d, aabb.field_72338_b, aabb.field_72339_c).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72340_a, aabb.field_72338_b, aabb.field_72339_c).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72340_a, aabb.field_72337_e, aabb.field_72339_c).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72340_a, aabb.field_72338_b, aabb.field_72334_f).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72340_a, aabb.field_72337_e, aabb.field_72334_f).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72336_d, aabb.field_72338_b, aabb.field_72334_f).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72336_d, aabb.field_72337_e, aabb.field_72334_f).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72336_d, aabb.field_72338_b, aabb.field_72339_c).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72336_d, aabb.field_72337_e, aabb.field_72339_c).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72340_a, aabb.field_72337_e, aabb.field_72334_f).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72340_a, aabb.field_72338_b, aabb.field_72334_f).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72340_a, aabb.field_72337_e, aabb.field_72339_c).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72340_a, aabb.field_72338_b, aabb.field_72339_c).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72336_d, aabb.field_72337_e, aabb.field_72339_c).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72336_d, aabb.field_72338_b, aabb.field_72339_c).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72336_d, aabb.field_72337_e, aabb.field_72334_f).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72336_d, aabb.field_72338_b, aabb.field_72334_f).func_181675_d();
      tessellator.func_78381_a();
   }

   public final void drawOutlinedAABB(@NotNull AxisAlignedBB aabb, @NotNull Color color) {
      Intrinsics.checkNotNullParameter(aabb, "aabb");
      Intrinsics.checkNotNullParameter(color, "color");
      this.bind(color);
      worldRenderer.func_181668_a(3, DefaultVertexFormats.field_181705_e);
      worldRenderer.func_181662_b(aabb.field_72340_a, aabb.field_72338_b, aabb.field_72339_c).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72340_a, aabb.field_72338_b, aabb.field_72334_f).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72336_d, aabb.field_72338_b, aabb.field_72334_f).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72336_d, aabb.field_72338_b, aabb.field_72339_c).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72340_a, aabb.field_72338_b, aabb.field_72339_c).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72340_a, aabb.field_72337_e, aabb.field_72339_c).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72340_a, aabb.field_72337_e, aabb.field_72334_f).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72336_d, aabb.field_72337_e, aabb.field_72334_f).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72336_d, aabb.field_72337_e, aabb.field_72339_c).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72340_a, aabb.field_72337_e, aabb.field_72339_c).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72340_a, aabb.field_72337_e, aabb.field_72334_f).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72340_a, aabb.field_72338_b, aabb.field_72334_f).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72336_d, aabb.field_72338_b, aabb.field_72334_f).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72336_d, aabb.field_72337_e, aabb.field_72334_f).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72336_d, aabb.field_72337_e, aabb.field_72339_c).func_181675_d();
      worldRenderer.func_181662_b(aabb.field_72336_d, aabb.field_72338_b, aabb.field_72339_c).func_181675_d();
      tessellator.func_78381_a();
   }

   static {
      Tessellator var10000 = Tessellator.func_178181_a();
      Intrinsics.checkNotNullExpressionValue(var10000, "getInstance(...)");
      tessellator = var10000;
      WorldRenderer var0 = tessellator.func_178180_c();
      Intrinsics.checkNotNullExpressionValue(var0, "getWorldRenderer(...)");
      worldRenderer = var0;
      neuCheckmarks = new CheckmarkSet(10, "neu");
      defaultCheckmarks = new CheckmarkSet(16, "default");
      legacyCheckmarks = new CheckmarkSet(8, "legacy");
      mapIcons = new ResourceLocation("funnymap", "marker.png");
   }
}
