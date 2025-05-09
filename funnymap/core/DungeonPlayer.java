package funnymap.core;

import funnymap.FunnyMap;
import funnymap.core.map.Room;
import funnymap.features.dungeon.Dungeon;
import funnymap.utils.APIUtils;
import funnymap.utils.Location;
import funnymap.utils.MapUtils;
import funnymap.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0018\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b`\u0010aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u000eR\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010&\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b%\u0010\u000eR\"\u0010'\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u000e\"\u0004\b*\u0010+R\"\u0010,\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010 \u001a\u0004\b,\u0010\"\"\u0004\b-\u0010$R\"\u0010.\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010(\u001a\u0004\b/\u0010\u000e\"\u0004\b0\u0010+R\"\u00102\u001a\u0002018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00108\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010\u0011\"\u0004\b;\u0010<R\"\u0010=\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u00109\u001a\u0004\b>\u0010\u0011\"\u0004\b?\u0010<R\"\u0010@\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010(\u001a\u0004\bA\u0010\u000e\"\u0004\bB\u0010+R\"\u0010C\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010 \u001a\u0004\bD\u0010\"\"\u0004\bE\u0010$R\"\u0010F\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010 \u001a\u0004\bG\u0010\"\"\u0004\bH\u0010$R4\u0010K\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\f0J0I8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010Q\u001a\u0004\bR\u0010\u0004R\"\u0010S\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u00109\u001a\u0004\bT\u0010\u0011\"\u0004\bU\u0010<R\"\u0010V\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010(\u001a\u0004\bW\u0010\u000e\"\u0004\bX\u0010+R\"\u0010Z\u001a\u00020Y8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_¨\u0006b"},
   d2 = {"Lfunnymap/core/DungeonPlayer;", "", "Lnet/minecraft/util/ResourceLocation;", "component1", "()Lnet/minecraft/util/ResourceLocation;", "skin", "copy", "(Lnet/minecraft/util/ResourceLocation;)Lfunnymap/core/DungeonPlayer;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "getCurrentRoom", "()Ljava/lang/String;", "", "hashCode", "()I", "Lnet/minecraft/entity/player/EntityPlayer;", "player", "", "setData", "(Lnet/minecraft/entity/player/EntityPlayer;)V", "toString", "", "colorPrefix", "C", "getColorPrefix", "()C", "setColorPrefix", "(C)V", "dead", "Z", "getDead", "()Z", "setDead", "(Z)V", "getFormattedName", "formattedName", "icon", "Ljava/lang/String;", "getIcon", "setIcon", "(Ljava/lang/String;)V", "isPlayer", "setPlayer", "lastRoom", "getLastRoom", "setLastRoom", "", "lastTime", "J", "getLastTime", "()J", "setLastTime", "(J)V", "mapX", "I", "getMapX", "setMapX", "(I)V", "mapZ", "getMapZ", "setMapZ", "name", "getName", "setName", "playerLoaded", "getPlayerLoaded", "setPlayerLoaded", "renderHat", "getRenderHat", "setRenderHat", "", "Lkotlin/Pair;", "roomVisits", "Ljava/util/List;", "getRoomVisits", "()Ljava/util/List;", "setRoomVisits", "(Ljava/util/List;)V", "Lnet/minecraft/util/ResourceLocation;", "getSkin", "startingSecrets", "getStartingSecrets", "setStartingSecrets", "uuid", "getUuid", "setUuid", "", "yaw", "F", "getYaw", "()F", "setYaw", "(F)V", "<init>", "(Lnet/minecraft/util/ResourceLocation;)V", "FunnyMapExtras"}
)
public final class DungeonPlayer {
   @NotNull
   private final ResourceLocation skin;
   @NotNull
   private String name;
   private char colorPrefix;
   private int mapX;
   private int mapZ;
   private float yaw;
   private boolean playerLoaded;
   @NotNull
   private String icon;
   private boolean renderHat;
   private boolean dead;
   @NotNull
   private String uuid;
   private boolean isPlayer;
   private int startingSecrets;
   @NotNull
   private String lastRoom;
   private long lastTime;
   @NotNull
   private List<Pair<Long, String>> roomVisits;

   public DungeonPlayer(@NotNull ResourceLocation skin) {
      Intrinsics.checkNotNullParameter(skin, "skin");
      super();
      this.skin = skin;
      this.name = "";
      this.colorPrefix = 'f';
      this.icon = "";
      this.uuid = "";
      this.lastRoom = "";
      this.roomVisits = (List)(new ArrayList());
   }

   @NotNull
   public final ResourceLocation getSkin() {
      return this.skin;
   }

   @NotNull
   public final String getName() {
      return this.name;
   }

   public final void setName(@NotNull String <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.name = var1;
   }

   public final char getColorPrefix() {
      return this.colorPrefix;
   }

   public final void setColorPrefix(char <set-?>) {
      this.colorPrefix = var1;
   }

   @NotNull
   public final String getFormattedName() {
      return "" + '§' + this.colorPrefix + this.name;
   }

   public final int getMapX() {
      return this.mapX;
   }

   public final void setMapX(int <set-?>) {
      this.mapX = var1;
   }

   public final int getMapZ() {
      return this.mapZ;
   }

   public final void setMapZ(int <set-?>) {
      this.mapZ = var1;
   }

   public final float getYaw() {
      return this.yaw;
   }

   public final void setYaw(float <set-?>) {
      this.yaw = var1;
   }

   public final boolean getPlayerLoaded() {
      return this.playerLoaded;
   }

   public final void setPlayerLoaded(boolean <set-?>) {
      this.playerLoaded = var1;
   }

   @NotNull
   public final String getIcon() {
      return this.icon;
   }

   public final void setIcon(@NotNull String <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.icon = var1;
   }

   public final boolean getRenderHat() {
      return this.renderHat;
   }

   public final void setRenderHat(boolean <set-?>) {
      this.renderHat = var1;
   }

   public final boolean getDead() {
      return this.dead;
   }

   public final void setDead(boolean <set-?>) {
      this.dead = var1;
   }

   @NotNull
   public final String getUuid() {
      return this.uuid;
   }

   public final void setUuid(@NotNull String <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.uuid = var1;
   }

   public final boolean isPlayer() {
      return this.isPlayer;
   }

   public final void setPlayer(boolean <set-?>) {
      this.isPlayer = var1;
   }

   public final int getStartingSecrets() {
      return this.startingSecrets;
   }

   public final void setStartingSecrets(int <set-?>) {
      this.startingSecrets = var1;
   }

   @NotNull
   public final String getLastRoom() {
      return this.lastRoom;
   }

   public final void setLastRoom(@NotNull String <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.lastRoom = var1;
   }

   public final long getLastTime() {
      return this.lastTime;
   }

   public final void setLastTime(long <set-?>) {
      this.lastTime = var1;
   }

   @NotNull
   public final List<Pair<Long, String>> getRoomVisits() {
      return this.roomVisits;
   }

   public final void setRoomVisits(@NotNull List<Pair<Long, String>> <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.roomVisits = var1;
   }

   public final void setData(@NotNull EntityPlayer player) {
      Intrinsics.checkNotNullParameter(player, "player");
      this.renderHat = player.func_175148_a(EnumPlayerModelParts.HAT);
      String var10001 = player.func_110124_au().toString();
      Intrinsics.checkNotNullExpressionValue(var10001, "toString(...)");
      this.uuid = var10001;
      this.playerLoaded = true;
      BuildersKt.launch$default(FunnyMap.INSTANCE.getScope(), (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, (Function2)(new Function2<CoroutineScope, Continuation<? super Unit>, Object>((Continuation)null) {
         int label;

         @Nullable
         public final Object invokeSuspend(@NotNull Object $result) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch(this.label) {
            case 0:
               ResultKt.throwOnFailure(var1);
               final int secrets = APIUtils.INSTANCE.getSecrets(DungeonPlayer.this.getUuid());
               Utils.INSTANCE.runMinecraftThread((Function0)(new Function0<Unit>() {
                  public final void invoke() {
                     DungeonPlayer.this.setStartingSecrets(secrets);
                  }
               }));
               return Unit.INSTANCE;
            default:
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }

         @NotNull
         public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
            return (Continuation)(new <anonymous constructor>($completion));
         }

         @Nullable
         public final Object invoke(@NotNull CoroutineScope p1, @Nullable Continuation<? super Unit> p2) {
            return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
         }
      }), 2, (Object)null);
   }

   @NotNull
   public final String getCurrentRoom() {
      if (this.dead) {
         return "Dead";
      } else if (Location.INSTANCE.getInBoss()) {
         return "Boss";
      } else {
         int x = (this.mapX - ((Number)MapUtils.INSTANCE.getStartCorner().getFirst()).intValue()) / (MapUtils.INSTANCE.getRoomSize() + MapUtils.INSTANCE.getConnectorSize());
         int z = (this.mapZ - ((Number)MapUtils.INSTANCE.getStartCorner().getSecond()).intValue()) / (MapUtils.INSTANCE.getRoomSize() + MapUtils.INSTANCE.getConnectorSize());
         Object var3 = ArraysKt.getOrNull(Dungeon.Info.INSTANCE.getDungeonList(), x * 2 + z * 22);
         Room var10000 = var3 instanceof Room ? (Room)var3 : null;
         String var5;
         if ((var3 instanceof Room ? (Room)var3 : null) != null) {
            RoomData var4 = var10000.getData();
            if (var4 != null) {
               var5 = var4.getName();
               if (var5 != null) {
                  return var5;
               }
            }
         }

         var5 = "Error";
         return var5;
      }
   }

   @NotNull
   public final ResourceLocation component1() {
      return this.skin;
   }

   @NotNull
   public final DungeonPlayer copy(@NotNull ResourceLocation skin) {
      Intrinsics.checkNotNullParameter(skin, "skin");
      return new DungeonPlayer(skin);
   }

   // $FF: synthetic method
   public static DungeonPlayer copy$default(DungeonPlayer var0, ResourceLocation var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = var0.skin;
      }

      return var0.copy(var1);
   }

   @NotNull
   public String toString() {
      return "DungeonPlayer(skin=" + this.skin + ')';
   }

   public int hashCode() {
      return this.skin.hashCode();
   }

   public boolean equals(@Nullable Object other) {
      if (this == other) {
         return true;
      } else if (!(other instanceof DungeonPlayer)) {
         return false;
      } else {
         DungeonPlayer var2 = (DungeonPlayer)other;
         return Intrinsics.areEqual(this.skin, var2.skin);
      }
   }
}
