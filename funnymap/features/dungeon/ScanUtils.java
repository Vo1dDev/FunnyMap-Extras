package funnymap.features.dungeon;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import funnymap.FunnyMap;
import funnymap.core.RoomData;
import funnymap.core.map.Room;
import funnymap.core.map.Tile;
import funnymap.utils.Utils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.text.Charsets;
import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.chunk.Chunk;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u0010J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"},
   d2 = {"Lfunnymap/features/dungeon/ScanUtils;", "", "", "x", "z", "getCore", "(II)I", "posX", "posZ", "Lkotlin/Pair;", "getRoomCentre", "(II)Lkotlin/Pair;", "hash", "Lfunnymap/core/RoomData;", "getRoomData", "(I)Lfunnymap/core/RoomData;", "(II)Lfunnymap/core/RoomData;", "Lnet/minecraft/util/BlockPos;", "pos", "Lfunnymap/core/map/Room;", "getRoomFromPos", "(Lnet/minecraft/util/BlockPos;)Lfunnymap/core/map/Room;", "", "roomList", "Ljava/util/Set;", "getRoomList", "()Ljava/util/Set;", "<init>", "()V", "FunnyMapExtras"}
)
@SourceDebugExtension({"SMAP\nScanUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScanUtils.kt\nfunnymap/features/dungeon/ScanUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,64:1\n1#2:65\n*E\n"})
public final class ScanUtils {
   @NotNull
   public static final ScanUtils INSTANCE = new ScanUtils();
   @NotNull
   private static final Set<RoomData> roomList;

   private ScanUtils() {
   }

   @NotNull
   public final Set<RoomData> getRoomList() {
      return roomList;
   }

   @Nullable
   public final RoomData getRoomData(int x, int z) {
      return this.getRoomData(this.getCore(x, z));
   }

   @Nullable
   public final RoomData getRoomData(int hash) {
      Iterable var2 = (Iterable)roomList;
      Iterator var3 = var2.iterator();

      Object var10000;
      while(true) {
         if (var3.hasNext()) {
            Object var4 = var3.next();
            RoomData it = (RoomData)var4;
            int var6 = false;
            if (!it.getCores().contains(hash)) {
               continue;
            }

            var10000 = var4;
            break;
         }

         var10000 = null;
         break;
      }

      return (RoomData)var10000;
   }

   @NotNull
   public final Pair<Integer, Integer> getRoomCentre(int posX, int posZ) {
      int roomX = MathKt.roundToInt((float)(posX - -185) / 32.0F);
      int roomZ = MathKt.roundToInt((float)(posZ - -185) / 32.0F);
      return new Pair(roomX * 32 + -185, roomZ * 32 + -185);
   }

   @Nullable
   public final Room getRoomFromPos(@NotNull BlockPos pos) {
      Intrinsics.checkNotNullParameter(pos, "pos");
      int x = pos.func_177958_n() - -185 + 15 >> 5;
      int z = pos.func_177952_p() - -185 + 15 >> 5;
      Tile room = (Tile)ArraysKt.getOrNull(Dungeon.Info.INSTANCE.getDungeonList(), x * 2 + z * 22);
      return room instanceof Room ? (Room)room : null;
   }

   public final int getCore(int x, int z) {
      StringBuilder sb = new StringBuilder(150);
      Chunk chunk = FunnyMap.INSTANCE.getMc().field_71441_e.func_175726_f(new BlockPos(x, 0, z));

      for(int y = 140; 11 < y; --y) {
         int id = Block.field_149771_c.func_148757_b(chunk.func_177428_a(new BlockPos(x, y, z)));
         Utils var10000 = Utils.INSTANCE;
         Integer var10001 = id;
         Object[] var7 = new Object[]{5, 54, 146};
         if (!var10000.equalsOneOf(var10001, var7)) {
            sb.append(id);
         }
      }

      return sb.toString().hashCode();
   }

   static {
      Set var0;
      try {
         Gson var10000 = new Gson();
         InputStream var10001 = FunnyMap.INSTANCE.getMc().func_110442_L().func_110536_a(new ResourceLocation("funnymap", "rooms.json")).func_110527_b();
         Intrinsics.checkNotNullExpressionValue(var10001, "getInputStream(...)");
         InputStream var1 = var10001;
         Charset var2 = Charsets.UTF_8;
         Reader var3 = (Reader)(new InputStreamReader(var1, var2));
         short var4 = 8192;
         Object var7 = var10000.fromJson((Reader)(var3 instanceof BufferedReader ? (BufferedReader)var3 : new BufferedReader(var3, var4)), (new TypeToken<Set<? extends RoomData>>() {
         }).getType());
         Intrinsics.checkNotNull(var7);
         var0 = (Set)var7;
      } catch (JsonSyntaxException var5) {
         System.out.println("Error parsing FunnyMap room data.");
         var0 = SetsKt.emptySet();
      } catch (JsonIOException var6) {
         System.out.println("Error reading FunnyMap room data.");
         var0 = SetsKt.emptySet();
      }

      roomList = var0;
   }
}
