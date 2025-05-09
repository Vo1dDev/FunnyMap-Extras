package funnymap.features.dungeon;

import funnymap.FunnyMap;
import funnymap.config.Config;
import funnymap.core.map.UniqueRoom;
import gg.essential.universal.UChat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.collections.Grouping;
import kotlin.collections.GroupingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.BlockPos;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\"\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0004R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006#"},
   d2 = {"Lfunnymap/features/dungeon/MimicDetector;", "", "", "checkMimicDead", "()V", "", "findMimic", "()Ljava/lang/String;", "Lnet/minecraft/entity/Entity;", "entity", "", "isMimic", "(Lnet/minecraft/entity/Entity;)Z", "Lnet/minecraft/util/BlockPos;", "pos", "Lnet/minecraft/block/state/IBlockState;", "old", "new", "onBlockChange", "(Lnet/minecraft/util/BlockPos;Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/block/state/IBlockState;)V", "setMimicKilled", "", "mimicOpenTime", "J", "getMimicOpenTime", "()J", "setMimicOpenTime", "(J)V", "mimicPos", "Lnet/minecraft/util/BlockPos;", "getMimicPos", "()Lnet/minecraft/util/BlockPos;", "setMimicPos", "(Lnet/minecraft/util/BlockPos;)V", "<init>", "FunnyMapExtras"}
)
@SourceDebugExtension({"SMAP\nMimicDetector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MimicDetector.kt\nfunnymap/features/dungeon/MimicDetector\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,68:1\n2624#2,3:69\n766#2:72\n857#2,2:73\n1536#2:75\n215#3:76\n216#3:78\n1#4:77\n*S KotlinDebug\n*F\n+ 1 MimicDetector.kt\nfunnymap/features/dungeon/MimicDetector\n*L\n31#1:69,3\n56#1:72\n56#1:73,2\n57#1:75\n57#1:76\n57#1:78\n*E\n"})
public final class MimicDetector {
   @NotNull
   public static final MimicDetector INSTANCE = new MimicDetector();
   private static long mimicOpenTime;
   @Nullable
   private static BlockPos mimicPos;

   private MimicDetector() {
   }

   public final long getMimicOpenTime() {
      return mimicOpenTime;
   }

   public final void setMimicOpenTime(long <set-?>) {
      mimicOpenTime = var1;
   }

   @Nullable
   public final BlockPos getMimicPos() {
      return mimicPos;
   }

   public final void setMimicPos(@Nullable BlockPos <set-?>) {
      mimicPos = var1;
   }

   public final void onBlockChange(@NotNull BlockPos pos, @NotNull IBlockState old, @NotNull IBlockState new) {
      Intrinsics.checkNotNullParameter(pos, "pos");
      Intrinsics.checkNotNullParameter(old, "old");
      Intrinsics.checkNotNullParameter(var3, "new");
      if (Intrinsics.areEqual(old.func_177230_c(), Blocks.field_150447_bR) && Intrinsics.areEqual(var3.func_177230_c(), Blocks.field_150350_a)) {
         mimicOpenTime = System.currentTimeMillis();
         mimicPos = pos;
      }

   }

   public final void checkMimicDead() {
      if (!RunInformation.INSTANCE.getMimicKilled()) {
         if (mimicOpenTime != 0L) {
            if (System.currentTimeMillis() - mimicOpenTime >= 750L) {
               if (FunnyMap.INSTANCE.getMc().field_71439_g.func_174818_b(mimicPos) < 400.0D) {
                  List var10000 = FunnyMap.INSTANCE.getMc().field_71441_e.field_72996_f;
                  Intrinsics.checkNotNullExpressionValue(var10000, "loadedEntityList");
                  Iterable $this$none$iv = (Iterable)var10000;
                  int $i$f$none = false;
                  boolean var10;
                  if ($this$none$iv instanceof Collection && ((Collection)$this$none$iv).isEmpty()) {
                     var10 = true;
                  } else {
                     Iterator var3 = $this$none$iv.iterator();

                     while(true) {
                        if (!var3.hasNext()) {
                           var10 = true;
                           break;
                        }

                        label49: {
                           Object element$iv = var3.next();
                           Entity it = (Entity)element$iv;
                           int var6 = false;
                           if (it instanceof EntityZombie && ((EntityZombie)it).func_70631_g_()) {
                              String var9;
                              label45: {
                                 ItemStack var7 = ((EntityZombie)it).func_82169_q(3);
                                 if (var7 != null) {
                                    NBTTagCompound var8 = var7.func_179543_a("SkullOwner", false);
                                    if (var8 != null) {
                                       var9 = var8.func_74779_i("Id");
                                       break label45;
                                    }
                                 }

                                 var9 = null;
                              }

                              if (Intrinsics.areEqual(var9, "bcb486a4-0cb5-35db-93f0-039fbdde03f0")) {
                                 var10 = true;
                                 break label49;
                              }
                           }

                           var10 = false;
                        }

                        if (var10) {
                           var10 = false;
                           break;
                        }
                     }
                  }

                  if (var10) {
                     this.setMimicKilled();
                  }
               }

            }
         }
      }
   }

   public final void setMimicKilled() {
      RunInformation.INSTANCE.setMimicKilled(true);
      if (Config.INSTANCE.getMimicMessageEnabled()) {
         UChat.say("/pc " + Config.INSTANCE.getMimicMessage());
      }

   }

   public final boolean isMimic(@NotNull Entity entity) {
      Intrinsics.checkNotNullParameter(entity, "entity");
      if (entity instanceof EntityZombie && ((EntityZombie)entity).func_70631_g_()) {
         for(int i = 0; i < 4; ++i) {
            if (((EntityZombie)entity).func_82169_q(i) != null) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @Nullable
   public final String findMimic() {
      List var10000 = FunnyMap.INSTANCE.getMc().field_71441_e.field_147482_g;
      Intrinsics.checkNotNullExpressionValue(var10000, "loadedTileEntityList");
      Iterable $this$groupingBy$iv = (Iterable)var10000;
      int $i$f$forEach = false;
      Collection destination$iv$iv = (Collection)(new ArrayList());
      int $i$f$filterTo = false;
      Iterator var6 = $this$groupingBy$iv.iterator();

      while(var6.hasNext()) {
         Object element$iv$iv = var6.next();
         TileEntity it = (TileEntity)element$iv$iv;
         int var9 = false;
         if (it instanceof TileEntityChest && ((TileEntityChest)it).func_145980_j() == 1) {
            destination$iv$iv.add(element$iv$iv);
         }
      }

      $this$groupingBy$iv = (Iterable)((List)destination$iv$iv);
      $i$f$forEach = false;
      Map $this$forEach$iv = GroupingKt.eachCount((Grouping)(new MimicDetector$findMimic$$inlined$groupingBy$1($this$groupingBy$iv)));
      $i$f$forEach = false;
      Iterator var3 = $this$forEach$iv.entrySet().iterator();

      UniqueRoom var14;
      do {
         if (!var3.hasNext()) {
            return null;
         }

         Entry element$iv = (Entry)var3.next();
         int var17 = false;
         String room = (String)element$iv.getKey();
         int trappedChests = ((Number)element$iv.getValue()).intValue();
         Iterable var20 = (Iterable)Dungeon.Info.INSTANCE.getUniqueRooms();
         Iterator var10 = var20.iterator();

         Object var22;
         while(true) {
            if (!var10.hasNext()) {
               var22 = null;
               break;
            }

            Object var11 = var10.next();
            UniqueRoom it = (UniqueRoom)var11;
            int var13 = false;
            if (Intrinsics.areEqual(it.getName(), room) && it.getMainRoom().getData().getTrappedChests() < trappedChests) {
               var22 = var11;
               break;
            }
         }

         var14 = (UniqueRoom)var22;
      } while(var14 == null);

      int var21 = false;
      var14.setHasMimic(true);
      MapRenderList.INSTANCE.setRenderUpdated(true);
      return var14.getName();
   }
}
