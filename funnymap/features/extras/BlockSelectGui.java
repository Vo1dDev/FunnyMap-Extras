package funnymap.features.extras;

import funnymap.FunnyMap;
import funnymap.utils.RenderUtils;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.RegistryNamespaced;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\f\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0002,-B\u0007¢\u0006\u0004\b+\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001a\u0010\u0010J\u000f\u0010\u001b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001b\u0010\u0010R\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\"\u0010!R\u0016\u0010#\u001a\u00020\u001c8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b#\u0010\u001eR\u0016\u0010$\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010!R\u0016\u0010%\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010!¨\u0006."},
   d2 = {"Lfunnymap/features/extras/BlockSelectGui;", "Lnet/minecraft/client/gui/GuiScreen;", "", "doesGuiPauseGame", "()Z", "", "mouseX", "mouseY", "", "partialTicks", "", "drawScreen", "(IIF)V", "getHoveredIndex", "(II)I", "handleMouseInput", "()V", "initGui", "", "typedChar", "keyCode", "keyTyped", "(CI)V", "mouseButton", "mouseClicked", "(III)V", "onGuiClosed", "updateSearch", "Lfunnymap/features/extras/BlockSelectGui$TabButton;", "allTabButton", "Lfunnymap/features/extras/BlockSelectGui$TabButton;", "", "containerHeight", "D", "containerWidth", "favouriteTabButton", "left", "scrollAmount", "I", "Lnet/minecraft/client/gui/GuiTextField;", "search", "Lnet/minecraft/client/gui/GuiTextField;", "top", "<init>", "Companion", "TabButton", "FunnyMapExtras"}
)
@SourceDebugExtension({"SMAP\nBlockSelectGui.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BlockSelectGui.kt\nfunnymap/features/extras/BlockSelectGui\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,242:1\n766#2:243\n857#2,2:244\n1855#2,2:246\n1855#2,2:248\n*S KotlinDebug\n*F\n+ 1 BlockSelectGui.kt\nfunnymap/features/extras/BlockSelectGui\n*L\n68#1:243\n68#1:244,2\n128#1:246,2\n188#1:248,2\n*E\n"})
public final class BlockSelectGui extends GuiScreen {
   @NotNull
   public static final BlockSelectGui.Companion Companion = new BlockSelectGui.Companion((DefaultConstructorMarker)null);
   private double left;
   private double top;
   private final double containerWidth = 340.0D;
   private final double containerHeight = 260.0D;
   private BlockSelectGui.TabButton allTabButton;
   private BlockSelectGui.TabButton favouriteTabButton;
   private GuiTextField search;
   private int scrollAmount;
   @NotNull
   private static final List<ItemStack> blocks = (List)(new ArrayList());
   @NotNull
   private static final List<ItemStack> displayed = (List)(new ArrayList());
   @NotNull
   private static List<String> favourites = (List)(new ArrayList());
   private static boolean inFavourites;

   public void func_73866_w_() {
      super.func_73866_w_();
      FunnyMap.INSTANCE.getExtras().loadFavBlocks();
      this.left = ((double)this.field_146294_l - this.containerWidth) / (double)2;
      this.top = ((double)this.field_146295_m - this.containerHeight) / (double)2;
      GuiTextField var1 = new GuiTextField(0, this.field_146289_q, (int)(this.left + this.containerWidth / (double)4), (int)(this.top - (double)40), (int)(this.containerWidth / (double)2), 20);
      int var3 = false;
      var1.func_146185_a(true);
      var1.func_146203_f(20);
      var1.func_146195_b(true);
      var1.func_146205_d(false);
      this.search = var1;
      this.allTabButton = new BlockSelectGui.TabButton("All Blocks", this.left, this.top + this.containerHeight + (double)2, this.containerWidth / (double)2 - (double)1, 20.0D);
      this.favouriteTabButton = new BlockSelectGui.TabButton("Favourite Blocks", this.left + this.containerWidth / (double)2 + (double)1, this.top + this.containerHeight + (double)2, this.containerWidth / (double)2 - (double)1, 20.0D);
      this.updateSearch();
   }

   protected void func_73869_a(char typedChar, int keyCode) {
      super.func_73869_a(typedChar, keyCode);
      GuiTextField var10000 = this.search;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("search");
         var10000 = null;
      }

      if (var10000.func_146201_a(typedChar, keyCode)) {
         this.updateSearch();
      }

   }

   private final void updateSearch() {
      displayed.clear();
      Iterable $this$filter$iv = (Iterable)blocks;
      List var10 = displayed;
      int $i$f$filter = false;
      Collection destination$iv$iv = (Collection)(new ArrayList());
      int $i$f$filterTo = false;
      Iterator var6 = $this$filter$iv.iterator();

      while(var6.hasNext()) {
         Object element$iv$iv = var6.next();
         ItemStack it = (ItemStack)element$iv$iv;
         int var9 = false;
         boolean var11;
         if (inFavourites && !favourites.contains(it.func_77973_b().getRegistryName() + it.func_77960_j())) {
            var11 = false;
         } else {
            GuiTextField var10000 = this.search;
            if (var10000 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("search");
               var10000 = null;
            }

            if (Intrinsics.areEqual(var10000.func_146179_b(), "")) {
               var11 = true;
            } else {
               String var12 = it.func_82833_r();
               Intrinsics.checkNotNullExpressionValue(var12, "getDisplayName(...)");
               CharSequence var13 = (CharSequence)var12;
               GuiTextField var10001 = this.search;
               if (var10001 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("search");
                  var10001 = null;
               }

               String var14 = var10001.func_146179_b();
               Intrinsics.checkNotNullExpressionValue(var14, "getText(...)");
               var11 = StringsKt.contains(var13, (CharSequence)var14, true);
            }
         }

         if (var11) {
            destination$iv$iv.add(element$iv$iv);
         }
      }

      var10.addAll((Collection)((List)destination$iv$iv));
   }

   private final int getHoveredIndex(int mouseX, int mouseY) {
      ClosedFloatingPointRange xRange = RangesKt.rangeTo(this.left + (double)10, this.left + this.containerWidth - 10.0D);
      ClosedFloatingPointRange yRange = RangesKt.rangeTo(this.top + (double)10, this.top + this.containerHeight - 10.0D);
      if (xRange.contains((Comparable)(double)mouseX) && yRange.contains((Comparable)(double)mouseY)) {
         int x = (mouseX - (int)this.left - 10) / 20;
         int y = (mouseY - (int)this.top + this.scrollAmount - 10) / 20;
         int blockIndex = x + y * 16;
         return blockIndex > displayed.size() ? -1 : blockIndex;
      } else {
         return -1;
      }
   }

   public void func_146274_d() {
      super.func_146274_d();
      int i = Mouse.getEventDWheel();
      if (i != 0) {
         this.scrollAmount = RangesKt.coerceIn(this.scrollAmount - RangesKt.coerceIn(i, (ClosedRange)(new IntRange(-1, 1))) * 20, (ClosedRange)(new IntRange(0, RangesKt.coerceAtLeast(displayed.size() / 16 - 11, 0) * 20)));
      }

   }

   public void func_73863_a(int mouseX, int mouseY, float partialTicks) {
      super.func_73863_a(mouseX, mouseY, partialTicks);
      this.func_146276_q_();
      RenderUtils var10000 = RenderUtils.INSTANCE;
      double var10001 = this.left;
      double var10002 = this.top;
      double var10003 = this.containerWidth;
      double var10004 = this.containerHeight;
      Color var10006 = Color.WHITE;
      Intrinsics.checkNotNullExpressionValue(var10006, "WHITE");
      var10000.renderRectBorder(var10001, var10002, var10003, var10004, 2.0D, var10006);
      GuiTextField var24 = this.search;
      if (var24 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("search");
         var24 = null;
      }

      var24.func_146194_f();
      BlockSelectGui.TabButton var25;
      if (inFavourites) {
         var25 = this.allTabButton;
         if (var25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("allTabButton");
            var25 = null;
         }

         var25.render(mouseX, mouseY, false);
         var25 = this.favouriteTabButton;
         if (var25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favouriteTabButton");
            var25 = null;
         }

         var25.render(mouseX, mouseY, true);
      } else {
         var25 = this.favouriteTabButton;
         if (var25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favouriteTabButton");
            var25 = null;
         }

         var25.render(mouseX, mouseY, false);
         var25 = this.allTabButton;
         if (var25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("allTabButton");
            var25 = null;
         }

         var25.render(mouseX, mouseY, true);
      }

      GlStateManager.func_179137_b(this.left + (double)10, this.top + (double)10, 0.0D);
      RenderHelper.func_74520_c();
      int scale = (new ScaledResolution(this.field_146297_k)).func_78325_e();
      GL11.glEnable(3089);
      GL11.glScissor((int)(this.left * (double)scale) + 10, (int)((double)this.field_146297_k.field_71440_d - this.top * (double)scale - this.containerHeight * (double)scale) + 10, (int)(this.containerWidth * (double)scale) - 10, (int)(this.containerWidth * (double)scale) - 10);
      Block current = EditMode.INSTANCE.getCurrentBlockState().func_177230_c();
      int meta = EditMode.INSTANCE.getCurrentBlockState().func_177230_c().func_176201_c(EditMode.INSTANCE.getCurrentBlockState());
      Iterable $this$forEach$iv = CollectionsKt.withIndex((Iterable)displayed);
      int $i$f$forEach = false;
      Iterator var9 = $this$forEach$iv.iterator();

      while(var9.hasNext()) {
         Object element$iv = var9.next();
         IndexedValue var11 = (IndexedValue)element$iv;
         int var12 = false;
         int index = var11.component1();
         ItemStack value = (ItemStack)var11.component2();
         int x = index % 16 * 20;
         int y = index / 16 * 20 - this.scrollAmount;
         double var17 = this.containerWidth;
         double var19 = (double)x;
         if (0.0D <= var19 ? var19 <= var17 : false) {
            var17 = this.containerHeight;
            var19 = (double)y;
            if (0.0D <= var19 ? var19 <= var17 : false) {
               Intrinsics.checkNotNull(current);
               if (BlockSelectGuiKt.matches(value, current, meta)) {
                  RenderUtils.INSTANCE.renderRect((Number)x, (Number)y, (Number)20.0D, (Number)20.0D, new Color(0, 255, 0, 128));
               } else if (favourites.contains(value.func_77973_b().getRegistryName() + value.func_77960_j())) {
                  RenderUtils.INSTANCE.renderRect((Number)x, (Number)y, (Number)20.0D, (Number)20.0D, new Color(0, 255, 255, 128));
               }

               this.field_146296_j.func_180450_b(value, x + 2, y + 2);
            }
         }
      }

      GL11.glDisable(3089);
      RenderHelper.func_74518_a();
      GlStateManager.func_179137_b(-this.left - (double)10, -this.top - (double)10, 0.0D);
      int blockIndex = this.getHoveredIndex(mouseX, mouseY);
      ItemStack var26 = (ItemStack)CollectionsKt.getOrNull(displayed, blockIndex);
      if (var26 != null) {
         ItemStack it = var26;
         int var23 = false;
         this.func_146283_a(CollectionsKt.listOf(it.func_82833_r()), mouseX, mouseY);
      }

   }

   protected void func_73864_a(int mouseX, int mouseY, int mouseButton) {
      BlockSelectGui.TabButton var10000 = this.allTabButton;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("allTabButton");
         var10000 = null;
      }

      BlockSelectGui.Companion var7;
      if (var10000.isHovered(mouseX, mouseY)) {
         var7 = Companion;
         inFavourites = false;
         this.updateSearch();
      } else {
         var10000 = this.favouriteTabButton;
         if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favouriteTabButton");
            var10000 = null;
         }

         if (var10000.isHovered(mouseX, mouseY)) {
            var7 = Companion;
            inFavourites = true;
            this.updateSearch();
            this.scrollAmount = 0;
         }
      }

      int blockIndex = this.getHoveredIndex(mouseX, mouseY);
      ItemStack var8 = (ItemStack)CollectionsKt.getOrNull(displayed, blockIndex);
      if (var8 != null) {
         ItemStack it = var8;
         int var6 = false;
         if (mouseButton == 0) {
            EditMode.INSTANCE.setCurrentBlock(it);
         } else if (!favourites.remove(it.func_77973_b().getRegistryName() + it.func_77960_j())) {
            favourites.add(it.func_77973_b().getRegistryName() + it.func_77960_j());
         }
      }

      super.func_73864_a(mouseX, mouseY, mouseButton);
   }

   public boolean func_73868_f() {
      return false;
   }

   public void func_146281_b() {
      super.func_146281_b();
      FunnyMap.INSTANCE.getExtras().saveFavBlocks();
   }

   static {
      RegistryNamespaced var10000 = Item.field_150901_e;
      Intrinsics.checkNotNullExpressionValue(var10000, "itemRegistry");
      Iterable $this$forEach$iv = (Iterable)var10000;
      int $i$f$forEach = false;
      Iterator var2 = $this$forEach$iv.iterator();

      while(var2.hasNext()) {
         Object element$iv = var2.next();
         Item it = (Item)element$iv;
         int var5 = false;
         if (it instanceof ItemBlock) {
            it.func_150895_a(it, (CreativeTabs)null, blocks);
         }
      }

   }

   @Metadata(
      mv = {1, 9, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"},
      d2 = {"Lfunnymap/features/extras/BlockSelectGui$Companion;", "", "", "Lnet/minecraft/item/ItemStack;", "blocks", "Ljava/util/List;", "getBlocks", "()Ljava/util/List;", "displayed", "getDisplayed", "", "favourites", "getFavourites", "setFavourites", "(Ljava/util/List;)V", "", "inFavourites", "Z", "getInFavourites", "()Z", "setInFavourites", "(Z)V", "<init>", "()V", "FunnyMapExtras"}
   )
   public static final class Companion {
      private Companion() {
      }

      @NotNull
      public final List<ItemStack> getBlocks() {
         return BlockSelectGui.blocks;
      }

      @NotNull
      public final List<ItemStack> getDisplayed() {
         return BlockSelectGui.displayed;
      }

      @NotNull
      public final List<String> getFavourites() {
         return BlockSelectGui.favourites;
      }

      public final void setFavourites(@NotNull List<String> <set-?>) {
         Intrinsics.checkNotNullParameter(var1, "<set-?>");
         BlockSelectGui.favourites = var1;
      }

      public final boolean getInFavourites() {
         return BlockSelectGui.inFavourites;
      }

      public final void setInFavourites(boolean <set-?>) {
         BlockSelectGui.inFavourites = var1;
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }

   @Metadata(
      mv = {1, 9, 0},
      k = 1,
      xi = 48,
      d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0019\u001a\u00020\f\u0012\u0006\u0010\u001a\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u000eR\u0014\u0010\u0019\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u000eR\u0014\u0010\u001a\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u000e¨\u0006\u001d"},
      d2 = {"Lfunnymap/features/extras/BlockSelectGui$TabButton;", "", "", "mouseX", "mouseY", "", "isHovered", "(II)Z", "active", "", "render", "(IIZ)V", "", "height", "D", "hovered", "Z", "", "text", "Ljava/lang/String;", "", "textX", "F", "textY", "width", "x", "y", "<init>", "(Ljava/lang/String;DDDD)V", "FunnyMapExtras"}
   )
   public static final class TabButton {
      @NotNull
      private final String text;
      private final double x;
      private final double y;
      private final double width;
      private final double height;
      private final float textX;
      private final float textY;
      private boolean hovered;

      public TabButton(@NotNull String text, double x, double y, double width, double height) {
         Intrinsics.checkNotNullParameter(text, "text");
         super();
         this.text = text;
         this.x = x;
         this.y = y;
         this.width = width;
         this.height = height;
         this.textX = (float)(this.x + (this.width - (double)FunnyMap.INSTANCE.getMc().field_71466_p.func_78256_a(this.text)) / (double)2);
         this.textY = (float)(this.y + (this.height - (double)FunnyMap.INSTANCE.getMc().field_71466_p.field_78288_b) / (double)2);
      }

      public final boolean isHovered(int mouseX, int mouseY) {
         double var3 = this.x;
         double var5 = this.x + this.width;
         double var7 = (double)mouseX;
         boolean var10000;
         if (var3 <= var7 ? var7 <= var5 : false) {
            var3 = this.y;
            var5 = this.y + this.height;
            var7 = (double)mouseY;
            if (var3 <= var7 ? var7 <= var5 : false) {
               var10000 = true;
               return var10000;
            }
         }

         var10000 = false;
         return var10000;
      }

      public final void render(int mouseX, int mouseY, boolean active) {
         this.hovered = this.isHovered(mouseX, mouseY);
         Color color = !active && !this.hovered ? Color.WHITE : Color.CYAN;
         RenderUtils var10000 = RenderUtils.INSTANCE;
         double var10001 = this.x;
         double var10002 = this.y;
         double var10003 = this.width;
         double var10004 = this.height;
         Intrinsics.checkNotNull(color);
         var10000.renderRectBorder(var10001, var10002, var10003, var10004, 2.0D, color);
         FunnyMap.INSTANCE.getMc().field_71466_p.func_175065_a(this.text, this.textX, this.textY, Color.WHITE.getRGB(), true);
      }
   }
}
