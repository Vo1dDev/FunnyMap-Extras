package funnymap.utils;

import funnymap.FunnyMap;
import gg.essential.universal.UChat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000e\u001a\u00020\r*\u0004\u0018\u00010\u00012\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000b\"\u00020\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0010\u001a\u00020\u0002*\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0015\u001a\u00020\u0002*\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"},
   d2 = {"Lfunnymap/utils/Utils;", "", "", "message", "", "modMessage", "(Ljava/lang/String;)V", "Lkotlin/Function0;", "run", "runMinecraftThread", "(Lkotlin/jvm/functions/Function0;)V", "", "other", "", "equalsOneOf", "(Ljava/lang/Object;[Ljava/lang/Object;)Z", "removeFormatting", "(Ljava/lang/String;)Ljava/lang/String;", "Lnet/minecraft/item/ItemStack;", "getItemID", "(Lnet/minecraft/item/ItemStack;)Ljava/lang/String;", "itemID", "<init>", "()V", "FunnyMapExtras"}
)
@SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\nfunnymap/utils/Utils\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,26:1\n12474#2,2:27\n*S KotlinDebug\n*F\n+ 1 Utils.kt\nfunnymap/utils/Utils\n*L\n11#1:27,2\n*E\n"})
public final class Utils {
   @NotNull
   public static final Utils INSTANCE = new Utils();

   private Utils() {
   }

   public final boolean equalsOneOf(@Nullable Object $this$equalsOneOf, @NotNull Object... other) {
      Intrinsics.checkNotNullParameter(other, "other");
      Object[] $this$any$iv = other;
      int $i$f$any = false;
      int var5 = 0;
      int var6 = other.length;

      boolean var10000;
      while(true) {
         if (var5 >= var6) {
            var10000 = false;
            break;
         }

         Object element$iv = $this$any$iv[var5];
         int var9 = false;
         if (Intrinsics.areEqual($this$equalsOneOf, element$iv)) {
            var10000 = true;
            break;
         }

         ++var5;
      }

      return var10000;
   }

   public final void runMinecraftThread(@NotNull Function0<Unit> run) {
      Intrinsics.checkNotNullParameter(run, "run");
      if (!FunnyMap.INSTANCE.getMc().func_152345_ab()) {
         FunnyMap.INSTANCE.getMc().func_152344_a(Utils::runMinecraftThread$lambda$1);
      } else {
         run.invoke();
      }

   }

   @NotNull
   public final String removeFormatting(@NotNull String $this$removeFormatting) {
      Intrinsics.checkNotNullParameter($this$removeFormatting, "<this>");
      String var10000 = StringUtils.func_76338_a($this$removeFormatting);
      Intrinsics.checkNotNullExpressionValue(var10000, "stripControlCodes(...)");
      return var10000;
   }

   public final void modMessage(@NotNull String message) {
      Intrinsics.checkNotNullParameter(message, "message");
      UChat.chat(FunnyMap.INSTANCE.getCHAT_PREFIX() + ' ' + message);
   }

   @NotNull
   public final String getItemID(@NotNull ItemStack $this$itemID) {
      Intrinsics.checkNotNullParameter($this$itemID, "<this>");
      NBTTagCompound var10000 = $this$itemID.func_179543_a("ExtraAttributes", false);
      String var2 = var10000 != null ? var10000.func_74779_i("id") : null;
      if (var2 == null) {
         var2 = "";
      }

      return var2;
   }

   private static final void runMinecraftThread$lambda$1(Function0 $tmp0) {
      Intrinsics.checkNotNullParameter($tmp0, "$tmp0");
      $tmp0.invoke();
   }
}
