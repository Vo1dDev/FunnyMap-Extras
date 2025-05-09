package funnymap.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraftforge.fml.common.FMLModContainer;
import net.minecraftforge.fml.common.ILanguageAdapter;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.relauncher.Side;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ9\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0013\u001a\u00020\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J-\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006 "},
   d2 = {"Lfunnymap/utils/KotlinAdapter;", "Lnet/minecraftforge/fml/common/ILanguageAdapter;", "Lnet/minecraftforge/fml/common/FMLModContainer;", "container", "Ljava/lang/Class;", "objectClass", "Ljava/lang/ClassLoader;", "classLoader", "Ljava/lang/reflect/Method;", "factoryMarkedAnnotation", "", "getNewInstance", "(Lnet/minecraftforge/fml/common/FMLModContainer;Ljava/lang/Class;Ljava/lang/ClassLoader;Ljava/lang/reflect/Method;)Ljava/lang/Object;", "Lnet/minecraftforge/fml/common/ModContainer;", "mod", "Lnet/minecraftforge/fml/relauncher/Side;", "side", "loader", "", "setInternalProxies", "(Lnet/minecraftforge/fml/common/ModContainer;Lnet/minecraftforge/fml/relauncher/Side;Ljava/lang/ClassLoader;)V", "Ljava/lang/reflect/Field;", "target", "proxyTarget", "proxy", "setProxy", "(Ljava/lang/reflect/Field;Ljava/lang/Class;Ljava/lang/Object;)V", "", "supportsStatics", "()Z", "<init>", "()V", "FunnyMapExtras"}
)
public final class KotlinAdapter implements ILanguageAdapter {
   public boolean supportsStatics() {
      return false;
   }

   @NotNull
   public Object getNewInstance(@Nullable FMLModContainer container, @NotNull Class<?> objectClass, @Nullable ClassLoader classLoader, @Nullable Method factoryMarkedAnnotation) {
      Intrinsics.checkNotNullParameter(objectClass, "objectClass");
      Object var10000 = JvmClassMappingKt.getKotlinClass(objectClass).getObjectInstance();
      if (var10000 == null) {
         var10000 = objectClass.getDeclaredConstructor().newInstance();
         Intrinsics.checkNotNullExpressionValue(var10000, "newInstance(...)");
      }

      return var10000;
   }

   public void setProxy(@NotNull Field target, @NotNull Class<?> proxyTarget, @Nullable Object proxy) {
      Intrinsics.checkNotNullParameter(target, "target");
      Intrinsics.checkNotNullParameter(proxyTarget, "proxyTarget");
      target.set(JvmClassMappingKt.getKotlinClass(proxyTarget).getObjectInstance(), proxy);
   }

   public void setInternalProxies(@Nullable ModContainer mod, @Nullable Side side, @Nullable ClassLoader loader) {
   }
}
