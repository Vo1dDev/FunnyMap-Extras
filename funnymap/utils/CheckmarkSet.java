package funnymap.utils;

import funnymap.FunnyMap;
import funnymap.core.map.RoomState;
import funnymap.features.dungeon.MapRender;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\b¨\u0006\u0015"},
   d2 = {"Lfunnymap/utils/CheckmarkSet;", "", "Lfunnymap/core/map/RoomState;", "state", "Lnet/minecraft/util/ResourceLocation;", "getCheckmark", "(Lfunnymap/core/map/RoomState;)Lnet/minecraft/util/ResourceLocation;", "crossResource", "Lnet/minecraft/util/ResourceLocation;", "greenResource", "questionResource", "", "size", "I", "getSize", "()I", "whiteResource", "", "location", "<init>", "(ILjava/lang/String;)V", "FunnyMapExtras"}
)
@SourceDebugExtension({"SMAP\nCheckmarkSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CheckmarkSet.kt\nfunnymap/utils/CheckmarkSet\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,31:1\n1855#2,2:32\n*S KotlinDebug\n*F\n+ 1 CheckmarkSet.kt\nfunnymap/utils/CheckmarkSet\n*L\n16#1:32,2\n*E\n"})
public final class CheckmarkSet {
   private final int size;
   @NotNull
   private final ResourceLocation crossResource;
   @NotNull
   private final ResourceLocation greenResource;
   @NotNull
   private final ResourceLocation questionResource;
   @NotNull
   private final ResourceLocation whiteResource;

   public CheckmarkSet(int size, @NotNull String location) {
      Intrinsics.checkNotNullParameter(location, "location");
      super();
      this.size = size;
      this.crossResource = new ResourceLocation("funnymap", location + "/cross.png");
      this.greenResource = new ResourceLocation("funnymap", location + "/green_check.png");
      this.questionResource = new ResourceLocation("funnymap", location + "/question.png");
      this.whiteResource = new ResourceLocation("funnymap", location + "/white_check.png");
      ResourceLocation[] var3 = new ResourceLocation[]{this.crossResource, this.greenResource, this.questionResource, this.whiteResource};
      Iterable $this$forEach$iv = (Iterable)CollectionsKt.listOf(var3);
      int $i$f$forEach = false;
      Iterator var5 = $this$forEach$iv.iterator();

      while(var5.hasNext()) {
         Object element$iv = var5.next();
         ResourceLocation it = (ResourceLocation)element$iv;
         int var8 = false;
         FunnyMap.INSTANCE.getMc().func_110434_K().func_110579_a(it, (ITextureObject)(new SimpleTexture(it)));
      }

   }

   public final int getSize() {
      return this.size;
   }

   @Nullable
   public final ResourceLocation getCheckmark(@NotNull RoomState state) {
      Intrinsics.checkNotNullParameter(state, "state");
      ResourceLocation var10000;
      switch(CheckmarkSet.WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
      case 1:
         var10000 = this.whiteResource;
         break;
      case 2:
         var10000 = this.greenResource;
         break;
      case 3:
         var10000 = this.crossResource;
         break;
      case 4:
         var10000 = MapRender.INSTANCE.getLegitRender() ? this.questionResource : null;
         break;
      default:
         var10000 = null;
      }

      return var10000;
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
         int[] var0 = new int[RoomState.values().length];

         try {
            var0[RoomState.CLEARED.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[RoomState.GREEN.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[RoomState.FAILED.ordinal()] = 3;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[RoomState.UNOPENED.ordinal()] = 4;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
