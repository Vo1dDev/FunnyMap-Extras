package funnymap.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import funnymap.core.ExtrasData;
import funnymap.core.adapters.BlockPosAdapter;
import funnymap.core.adapters.BlockStateDeserializer;
import funnymap.features.extras.BlockSelectGui;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010.\u001a\u00020\u0014¢\u0006\u0004\b/\u00100J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\r\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\bJ\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\bR.\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0019\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u0016RD\u0010'\u001a$\u0012\u0004\u0012\u00020\u0002\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020#\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$0\fj\u0002`&0\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u000f\u001a\u0004\b(\u0010\u0011\"\u0004\b)\u0010\u0013R\u0014\u0010*\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010\u0016R\u001c\u0010,\u001a\n \u0018*\u0004\u0018\u00010+0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010\u0016¨\u00061"},
   d2 = {"Lfunnymap/config/ExtrasConfig;", "", "", "directoryName", "", "createBackup", "(Ljava/lang/String;)V", "loadConfig", "()V", "loadFavBlocks", "saveConfig", "saveFavBlocks", "", "Lfunnymap/core/ExtrasData;", "config", "Ljava/util/Map;", "getConfig", "()Ljava/util/Map;", "setConfig", "(Ljava/util/Map;)V", "Ljava/io/File;", "configFile", "Ljava/io/File;", "Ljava/time/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "dateFormat", "Ljava/time/format/DateTimeFormatter;", "", "enabled", "Z", "getEnabled", "()Z", "setEnabled", "(Z)V", "favBlocks", "Lnet/minecraft/block/state/IBlockState;", "", "Lnet/minecraft/util/BlockPos;", "Lfunnymap/config/BlockMap;", "floorsConfig", "getFloorsConfig", "setFloorsConfig", "floorsConfigFile", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "path", "<init>", "(Ljava/io/File;)V", "FunnyMapExtras"}
)
@SourceDebugExtension({"SMAP\nExtrasConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExtrasConfig.kt\nfunnymap/config/ExtrasConfig\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,114:1\n1#2:115\n1549#3:116\n1620#3,3:117\n*S KotlinDebug\n*F\n+ 1 ExtrasConfig.kt\nfunnymap/config/ExtrasConfig\n*L\n55#1:116\n55#1:117,3\n*E\n"})
public final class ExtrasConfig {
   @NotNull
   private final File path;
   private final DateTimeFormatter dateFormat;
   private final Gson gson;
   @NotNull
   private final File configFile;
   @NotNull
   private final File floorsConfigFile;
   @NotNull
   private final File favBlocks;
   @NotNull
   private Map<String, ExtrasData> config;
   @NotNull
   private Map<String, Map<IBlockState, Set<BlockPos>>> floorsConfig;
   private boolean enabled;

   public ExtrasConfig(@NotNull File path) {
      Intrinsics.checkNotNullParameter(path, "path");
      super();
      this.path = path;
      this.dateFormat = DateTimeFormatter.ofPattern("uu-MM-dd HH-mm-ss");
      this.gson = (new GsonBuilder()).registerTypeAdapter((Type)BlockPos.class, new BlockPosAdapter()).registerTypeAdapter((Type)IBlockState.class, new BlockStateDeserializer()).disableHtmlEscaping().setPrettyPrinting().create();
      this.configFile = new File(this.path, "extrasConfig.json");
      this.floorsConfigFile = new File(this.path, "floorsConfig.json");
      this.favBlocks = new File(this.path, "favBlocks.json");
      this.config = (Map)(new LinkedHashMap());
      this.floorsConfig = (Map)(new LinkedHashMap());
      this.enabled = true;

      try {
         if (!this.path.exists() && !this.path.mkdirs()) {
            this.enabled = false;
         } else {
            this.configFile.createNewFile();
            this.floorsConfigFile.createNewFile();
            this.favBlocks.createNewFile();
         }
      } catch (Exception var3) {
         this.enabled = false;
         System.out.println("Error initializing FunnyMap Extras");
      }

   }

   @NotNull
   public final Map<String, ExtrasData> getConfig() {
      return this.config;
   }

   public final void setConfig(@NotNull Map<String, ExtrasData> <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.config = var1;
   }

   @NotNull
   public final Map<String, Map<IBlockState, Set<BlockPos>>> getFloorsConfig() {
      return this.floorsConfig;
   }

   public final void setFloorsConfig(@NotNull Map<String, Map<IBlockState, Set<BlockPos>>> <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.floorsConfig = var1;
   }

   public final boolean getEnabled() {
      return this.enabled;
   }

   public final void setEnabled(boolean <set-?>) {
      this.enabled = var1;
   }

   public final void loadFavBlocks() {
      File var1 = this.favBlocks;
      Charset var2 = Charsets.UTF_8;
      short var3 = 8192;
      Reader var4 = (Reader)(new InputStreamReader((InputStream)(new FileInputStream(var1)), var2));
      Closeable var19 = (Closeable)(var4 instanceof BufferedReader ? (BufferedReader)var4 : new BufferedReader(var4, var3));
      Throwable var20 = null;

      String var23;
      try {
         BufferedReader it = (BufferedReader)var19;
         int var25 = false;
         var23 = TextStreamsKt.readText((Reader)it);
      } catch (Throwable var17) {
         var20 = var17;
         throw var17;
      } finally {
         CloseableKt.closeFinally(var19, var20);
      }

      String $this$loadFavBlocks_u24lambda_u242 = var23;
      boolean var24 = false;
      if (!Intrinsics.areEqual($this$loadFavBlocks_u24lambda_u242, "")) {
         BlockSelectGui.Companion var10000 = BlockSelectGui.Companion;
         Object var10001 = (new Gson()).fromJson($this$loadFavBlocks_u24lambda_u242, JsonArray.class);
         Intrinsics.checkNotNullExpressionValue(var10001, "fromJson(...)");
         Iterable $this$map$iv = (Iterable)var10001;
         BlockSelectGui.Companion var5 = var10000;
         int $i$f$map = false;
         Collection destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10)));
         int $i$f$mapTo = false;
         Iterator var10 = $this$map$iv.iterator();

         while(var10.hasNext()) {
            Object item$iv$iv = var10.next();
            JsonElement it = (JsonElement)item$iv$iv;
            int var14 = false;
            destination$iv$iv.add(it.getAsString());
         }

         var5.setFavourites(CollectionsKt.toMutableList((Collection)((List)destination$iv$iv)));
      }

   }

   public final void saveFavBlocks() {
      File var1 = this.favBlocks;
      Charset var2 = Charsets.UTF_8;
      short var3 = 8192;
      Writer var4 = (Writer)(new OutputStreamWriter((OutputStream)(new FileOutputStream(var1)), var2));
      Closeable var9 = (Closeable)(var4 instanceof BufferedWriter ? (BufferedWriter)var4 : new BufferedWriter(var4, var3));
      Throwable var10 = null;

      try {
         BufferedWriter it = (BufferedWriter)var9;
         int var13 = false;
         it.write(this.gson.toJson(BlockSelectGui.Companion.getFavourites()));
         Unit var12 = Unit.INSTANCE;
      } catch (Throwable var7) {
         var10 = var7;
         throw var7;
      } finally {
         CloseableKt.closeFinally(var9, var10);
      }

   }

   public final void loadConfig() {
      try {
         File var1 = this.configFile;
         Charset var2 = Charsets.UTF_8;
         short var3 = 8192;
         Reader var4 = (Reader)(new InputStreamReader((InputStream)(new FileInputStream(var1)), var2));
         Closeable var23 = (Closeable)(var4 instanceof BufferedReader ? (BufferedReader)var4 : new BufferedReader(var4, var3));
         Throwable var24 = null;

         BufferedReader it;
         String var27;
         boolean var29;
         try {
            it = (BufferedReader)var23;
            var29 = false;
            var27 = TextStreamsKt.readText((Reader)it);
         } catch (Throwable var19) {
            var24 = var19;
            throw var19;
         } finally {
            CloseableKt.closeFinally(var23, var24);
         }

         String it = var27;
         boolean var28 = false;
         Object var30;
         if (((CharSequence)it).length() > 0) {
            var30 = this.gson.fromJson(it, (new TypeToken<Map<String, ExtrasData>>() {
            }).getType());
            Intrinsics.checkNotNullExpressionValue(var30, "fromJson(...)");
            this.config = (Map)var30;
         }

         var1 = this.floorsConfigFile;
         var2 = Charsets.UTF_8;
         var3 = 8192;
         var4 = (Reader)(new InputStreamReader((InputStream)(new FileInputStream(var1)), var2));
         var23 = (Closeable)(var4 instanceof BufferedReader ? (BufferedReader)var4 : new BufferedReader(var4, var3));
         var24 = null;

         try {
            it = (BufferedReader)var23;
            var29 = false;
            var27 = TextStreamsKt.readText((Reader)it);
         } catch (Throwable var17) {
            var24 = var17;
            throw var17;
         } finally {
            CloseableKt.closeFinally(var23, var24);
         }

         it = var27;
         var28 = false;
         if (((CharSequence)it).length() > 0) {
            var30 = this.gson.fromJson(it, (new TypeToken<Map<String, Map<IBlockState, Set<BlockPos>>>>() {
            }).getType());
            Intrinsics.checkNotNullExpressionValue(var30, "fromJson(...)");
            this.floorsConfig = (Map)var30;
         }
      } catch (JsonSyntaxException var21) {
         String var10001 = this.dateFormat.format((TemporalAccessor)LocalDateTime.now());
         Intrinsics.checkNotNullExpressionValue(var10001, "format(...)");
         this.createBackup(var10001);
         System.out.println("Error parsing FunnyMap Extras Config. Backing up current Config.");
         var21.printStackTrace();
      } catch (JsonIOException var22) {
         System.out.println("Error reading FunnyMap Extras Config.");
      }

   }

   public final void saveConfig() {
      try {
         File var1 = this.configFile;
         Charset var2 = Charsets.UTF_8;
         short var3 = 8192;
         Writer var4 = (Writer)(new OutputStreamWriter((OutputStream)(new FileOutputStream(var1)), var2));
         Closeable var20 = (Closeable)(var4 instanceof BufferedWriter ? (BufferedWriter)var4 : new BufferedWriter(var4, var3));
         Throwable var21 = null;

         BufferedWriter it;
         Unit var23;
         boolean var24;
         try {
            it = (BufferedWriter)var20;
            var24 = false;
            it.write(this.gson.toJson(this.config));
            var23 = Unit.INSTANCE;
         } catch (Throwable var17) {
            var21 = var17;
            throw var17;
         } finally {
            CloseableKt.closeFinally(var20, var21);
         }

         var1 = this.floorsConfigFile;
         var2 = Charsets.UTF_8;
         var3 = 8192;
         var4 = (Writer)(new OutputStreamWriter((OutputStream)(new FileOutputStream(var1)), var2));
         var20 = (Closeable)(var4 instanceof BufferedWriter ? (BufferedWriter)var4 : new BufferedWriter(var4, var3));
         var21 = null;

         try {
            it = (BufferedWriter)var20;
            var24 = false;
            it.write(this.gson.toJson(this.floorsConfig));
            var23 = Unit.INSTANCE;
         } catch (Throwable var15) {
            var21 = var15;
            throw var15;
         } finally {
            CloseableKt.closeFinally(var20, var21);
         }
      } catch (IOException var19) {
         System.out.println("Error saving FunnyMap Extras Config.");
      }

   }

   private final void createBackup(String directoryName) {
      File backupDirectory = new File(this.path, directoryName);
      backupDirectory.mkdirs();
      Path var10000 = this.configFile.toPath();
      Path var10001 = (new File(backupDirectory, "extrasConfig.json")).toPath();
      CopyOption[] var3 = new CopyOption[]{StandardCopyOption.REPLACE_EXISTING};
      Files.copy(var10000, var10001, var3);
      var10000 = this.floorsConfigFile.toPath();
      var10001 = (new File(backupDirectory, "floorsConfig.json")).toPath();
      var3 = new CopyOption[]{StandardCopyOption.REPLACE_EXISTING};
      Files.copy(var10000, var10001, var3);
   }
}
