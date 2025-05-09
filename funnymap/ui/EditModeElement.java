package funnymap.ui;

import funnymap.FunnyMap;
import funnymap.config.Config;
import funnymap.core.RoomData;
import funnymap.core.map.Room;
import funnymap.features.dungeon.ScanUtils;
import funnymap.features.extras.EditMode;
import funnymap.features.extras.FreeCam;
import funnymap.mixins.AccessorMinecraft;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u001d\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR+\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011*\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\nR+\u0010\u001c\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b8V@VX\u0096\u008e\u0002¢\u0006\u0012\u001a\u0004\b\u0018\u0010\n\"\u0004\b\u0019\u0010\u001a*\u0004\b\u001b\u0010\u0013R\"\u0010\u001d\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\n\"\u0004\b\u001f\u0010\u001aR+\u0010#\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b8V@VX\u0096\u008e\u0002¢\u0006\u0012\u001a\u0004\b \u0010\n\"\u0004\b!\u0010\u001a*\u0004\b\"\u0010\u0013R\"\u0010$\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0016\u001a\u0004\b%\u0010\n\"\u0004\b&\u0010\u001a¨\u0006)"},
   d2 = {"Lfunnymap/ui/EditModeElement;", "Lfunnymap/ui/MovableGuiElement;", "", "render", "()V", "", "shouldRender", "()Z", "", "getH", "()I", "h", "", "<set-?>", "getScale", "()F", "setScale", "(F)V", "getScale$delegate", "(Lfunnymap/ui/EditModeElement;)Ljava/lang/Object;", "scale", "w", "I", "getW", "getX", "setX", "(I)V", "getX$delegate", "x", "x2", "getX2", "setX2", "getY", "setY", "getY$delegate", "y", "y2", "getY2", "setY2", "<init>", "Companion", "FunnyMapExtras"}
)
@SourceDebugExtension({"SMAP\nEditModeElement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EditModeElement.kt\nfunnymap/ui/EditModeElement\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,56:1\n1#2:57\n215#3,2:58\n*S KotlinDebug\n*F\n+ 1 EditModeElement.kt\nfunnymap/ui/EditModeElement\n*L\n33#1:58,2\n*E\n"})
public final class EditModeElement extends MovableGuiElement {
   @NotNull
   public static final EditModeElement.Companion Companion = new EditModeElement.Companion((DefaultConstructorMarker)null);
   private final int w;
   private int x2;
   private int y2;
   @NotNull
   private static final FontRenderer fr;

   public EditModeElement() {
      Config var10000 = Config.INSTANCE;
      var10000 = Config.INSTANCE;
      this.w = fr.func_78256_a("Last placed room: Cobble Wall Pillar");
      var10000 = Config.INSTANCE;
      this.x2 = (int)((float)this.getX() + (float)this.getW() * this.getScale());
      this.y2 = (int)((float)this.getY() + (float)this.getH() * this.getScale());
   }

   public int getX() {
      return Config.INSTANCE.getEditX();
   }

   public void setX(int <set-?>) {
      Config.INSTANCE.setEditX(var1);
   }

   private static Object getX$delegate(EditModeElement <this>) {
      return Reflection.mutableProperty0((MutablePropertyReference0)(new MutablePropertyReference0Impl(Config.INSTANCE, Config.class, "editX", "getEditX()I", 0)));
   }

   public int getY() {
      return Config.INSTANCE.getEditY();
   }

   public void setY(int <set-?>) {
      Config.INSTANCE.setEditY(var1);
   }

   private static Object getY$delegate(EditModeElement <this>) {
      return Reflection.mutableProperty0((MutablePropertyReference0)(new MutablePropertyReference0Impl(Config.INSTANCE, Config.class, "editY", "getEditY()I", 0)));
   }

   public int getH() {
      return fr.field_78288_b * 4 + 20;
   }

   public int getW() {
      return this.w;
   }

   public float getScale() {
      return Config.INSTANCE.getEditScale();
   }

   public void setScale(float <set-?>) {
      Config.INSTANCE.setEditScale(var1);
   }

   private static Object getScale$delegate(EditModeElement <this>) {
      return Reflection.mutableProperty0((MutablePropertyReference0)(new MutablePropertyReference0Impl(Config.INSTANCE, Config.class, "editScale", "getEditScale()F", 0)));
   }

   public int getX2() {
      return this.x2;
   }

   public void setX2(int <set-?>) {
      this.x2 = var1;
   }

   public int getY2() {
      return this.y2;
   }

   public void setY2(int <set-?>) {
      this.y2 = var1;
   }

   public void render() {
      float y = 0.0F;
      BlockPos var18;
      if (FreeCam.INSTANCE.getEnabled()) {
         MovingObjectPosition var10000 = FreeCam.INSTANCE.getLooking();
         var18 = var10000 != null ? var10000.func_178782_a() : null;
      } else {
         var18 = FunnyMap.INSTANCE.getMc().field_71439_g.func_180425_c();
      }

      Pair[] var4;
      byte var11;
      String var12;
      String var13;
      byte var10001;
      String var10002;
      Pair[] var19;
      String var10003;
      Room var20;
      RoomData var21;
      String var22;
      label58: {
         BlockPos currentPos = var18;
         var4 = new Pair[4];
         var4[0] = TuplesKt.to("Edit mode: ", EditMode.INSTANCE.getEnabled() ? "§aEnabled" : "§cDisabled");
         var19 = var4;
         var10001 = 1;
         var10002 = "Current room: §a";
         if (currentPos != null) {
            label55: {
               var12 = "Current room: §a";
               var11 = 1;
               int var8 = false;
               var20 = ScanUtils.INSTANCE.getRoomFromPos(currentPos);
               if (var20 != null) {
                  var21 = var20.getData();
                  if (var21 != null) {
                     var22 = var21.getName();
                     break label55;
                  }
               }

               var22 = null;
            }

            var13 = var22;
            var19 = var4;
            var10001 = var11;
            var10002 = var12;
            var10003 = var13;
            if (var13 != null) {
               break label58;
            }
         }

         var10003 = "None";
      }

      boolean var9;
      label48: {
         var19[var10001] = TuplesKt.to(var10002, var10003);
         var19 = var4;
         var10001 = 2;
         var10002 = "Last placed room: §a";
         BlockPos var23 = EditMode.INSTANCE.getLastPlacePos();
         if (var23 != null) {
            label45: {
               BlockPos it = var23;
               var12 = "Last placed room: §a";
               var11 = 2;
               var9 = false;
               var20 = ScanUtils.INSTANCE.getRoomFromPos(it);
               if (var20 != null) {
                  var21 = var20.getData();
                  if (var21 != null) {
                     var22 = var21.getName();
                     break label45;
                  }
               }

               var22 = null;
            }

            var13 = var22;
            var19 = var4;
            var10001 = var11;
            var10002 = var12;
            var10003 = var13;
            if (var13 != null) {
               break label48;
            }
         }

         var10003 = "None";
      }

      var19[var10001] = TuplesKt.to(var10002, var10003);
      var4[3] = TuplesKt.to("Current block: §a", EditMode.INSTANCE.getCurrentBlockState().func_177230_c().func_149732_F());
      Map lines = MapsKt.mapOf(var4);
      int $i$f$forEach = false;

      for(Iterator var6 = lines.entrySet().iterator(); var6.hasNext(); y += (float)fr.field_78288_b) {
         Entry element$iv = (Entry)var6.next();
         var9 = false;
         fr.func_175065_a((String)element$iv.getKey() + (String)element$iv.getValue(), 0.0F, y, 16777215, true);
      }

      IBlockState $this$render_u24lambda_u243 = EditMode.INSTANCE.getCurrentBlockState();
      int var16 = false;
      ItemStack itemStack = new ItemStack($this$render_u24lambda_u243.func_177230_c(), 1, $this$render_u24lambda_u243.func_177230_c().func_176201_c($this$render_u24lambda_u243));
      RenderHelper.func_74520_c();
      Minecraft var24 = FunnyMap.INSTANCE.getMc();
      Intrinsics.checkNotNull(var24, "null cannot be cast to non-null type funnymap.mixins.AccessorMinecraft");
      ((AccessorMinecraft)var24).getRenderItem().func_175042_a(itemStack, 0, (int)y);
      RenderHelper.func_74518_a();
   }

   public boolean shouldRender() {
      if (!Config.INSTANCE.getEditElementEnabled()) {
         return false;
      } else {
         return Config.INSTANCE.getEditHideNotEdit() && !EditMode.INSTANCE.getEnabled() ? false : super.shouldRender();
      }
   }

   static {
      FontRenderer var10000 = FunnyMap.INSTANCE.getMc().field_71466_p;
      Intrinsics.checkNotNullExpressionValue(var10000, "fontRendererObj");
      fr = var10000;
   }

   @Metadata(
      mv = {1, 9, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"},
      d2 = {"Lfunnymap/ui/EditModeElement$Companion;", "", "Lnet/minecraft/client/gui/FontRenderer;", "fr", "Lnet/minecraft/client/gui/FontRenderer;", "getFr", "()Lnet/minecraft/client/gui/FontRenderer;", "<init>", "()V", "FunnyMapExtras"}
   )
   public static final class Companion {
      private Companion() {
      }

      @NotNull
      public final FontRenderer getFr() {
         return EditModeElement.fr;
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}
