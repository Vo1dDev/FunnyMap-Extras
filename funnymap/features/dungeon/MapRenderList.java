package funnymap.features.dungeon;

import funnymap.FunnyMap;
import funnymap.config.Config;
import funnymap.core.map.Door;
import funnymap.core.map.Room;
import funnymap.core.map.RoomState;
import funnymap.core.map.RoomType;
import funnymap.core.map.Tile;
import funnymap.core.map.UniqueRoom;
import funnymap.core.map.Unknown;
import funnymap.utils.Location;
import funnymap.utils.MapUtils;
import funnymap.utils.RenderUtils;
import funnymap.utils.RenderUtilsGL;
import funnymap.utils.Utils;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.minecraft.client.renderer.GlStateManager;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0004R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\n¨\u0006\u0014"},
   d2 = {"Lfunnymap/features/dungeon/MapRenderList;", "", "", "renderMap", "()V", "renderRooms", "renderText", "updateRenderMap", "", "borderGlList", "I", "", "renderUpdated", "Z", "getRenderUpdated", "()Z", "setRenderUpdated", "(Z)V", "roomGlList", "<init>", "FunnyMapExtras"}
)
@SourceDebugExtension({"SMAP\nMapRenderList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapRenderList.kt\nfunnymap/features/dungeon/MapRenderList\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,223:1\n1855#2,2:224\n*S KotlinDebug\n*F\n+ 1 MapRenderList.kt\nfunnymap/features/dungeon/MapRenderList\n*L\n167#1:224,2\n*E\n"})
public final class MapRenderList {
   @NotNull
   public static final MapRenderList INSTANCE = new MapRenderList();
   private static boolean renderUpdated;
   private static int borderGlList = -1;
   private static int roomGlList = -1;

   private MapRenderList() {
   }

   public final boolean getRenderUpdated() {
      return renderUpdated;
   }

   public final void setRenderUpdated(boolean <set-?>) {
      renderUpdated = var1;
   }

   public final void updateRenderMap() {
      if (borderGlList == -1) {
         borderGlList = GL11.glGenLists(1);
         GL11.glNewList(borderGlList, 4864);
         RenderUtilsGL.INSTANCE.renderRect((Number)0.0D, (Number)0.0D, (Number)128.0D, (Number)Config.INSTANCE.getMapShowRunInformation() ? 142.0D : 128.0D, Config.INSTANCE.getMapBackground());
         RenderUtilsGL.INSTANCE.renderRectBorder(0.0D, 0.0D, 128.0D, Config.INSTANCE.getMapShowRunInformation() ? 142.0D : 128.0D, (double)Config.INSTANCE.getMapBorderWidth(), Config.INSTANCE.getMapBorder());
         GL11.glEndList();
      }

      if (renderUpdated && Config.INSTANCE.getRenderBeta()) {
         if (roomGlList >= 0) {
            GL11.glDeleteLists(roomGlList, 1);
            roomGlList = -1;
         }

         roomGlList = GL11.glGenLists(1);
         renderUpdated = false;
         GL11.glNewList(roomGlList, 4864);
         this.renderRooms();
         this.renderText();
         GL11.glEndList();
      }

   }

   public final void renderMap() {
      if (roomGlList == -1 || borderGlList == -1 || renderUpdated) {
         this.updateRenderMap();
      }

      FunnyMap.INSTANCE.getMc().field_71424_I.func_76320_a("border");
      if (borderGlList != -1) {
         GL11.glCallList(borderGlList);
      }

      FunnyMap.INSTANCE.getMc().field_71424_I.func_76319_b();
      if (Config.INSTANCE.getMapRotate()) {
         GlStateManager.func_179094_E();
         MapRender.INSTANCE.setupRotate();
      } else if (Config.INSTANCE.getMapDynamicRotate()) {
         GlStateManager.func_179137_b(64.0D, 64.0D, 0.0D);
         GlStateManager.func_179114_b(MapRender.INSTANCE.getDynamicRotation(), 0.0F, 0.0F, 1.0F);
         GlStateManager.func_179137_b(-64.0D, -64.0D, 0.0D);
      }

      FunnyMap.INSTANCE.getMc().field_71424_I.func_76320_a("rooms");
      if (roomGlList != -1) {
         GL11.glCallList(roomGlList);
      }

      RenderUtilsGL.INSTANCE.unbindTexture();
      if (!Location.INSTANCE.getInBoss()) {
         FunnyMap.INSTANCE.getMc().field_71424_I.func_76318_c("heads");
         MapRender.INSTANCE.renderPlayerHeads();
      }

      FunnyMap.INSTANCE.getMc().field_71424_I.func_76319_b();
      if (Config.INSTANCE.getMapRotate()) {
         GL11.glDisable(3089);
         GlStateManager.func_179121_F();
      } else if (Config.INSTANCE.getMapDynamicRotate()) {
         GlStateManager.func_179137_b(64.0D, 64.0D, 0.0D);
         GlStateManager.func_179114_b(-MapRender.INSTANCE.getDynamicRotation(), 0.0F, 0.0F, 1.0F);
         GlStateManager.func_179137_b(-64.0D, -64.0D, 0.0D);
      }

      if (Config.INSTANCE.getMapShowRunInformation()) {
         FunnyMap.INSTANCE.getMc().field_71424_I.func_76320_a("footer");
         MapRender.INSTANCE.renderRunInformation();
         FunnyMap.INSTANCE.getMc().field_71424_I.func_76319_b();
      }

   }

   private final void renderRooms() {
      GlStateManager.func_179109_b((float)((Number)MapUtils.INSTANCE.getStartCorner().getFirst()).intValue(), (float)((Number)MapUtils.INSTANCE.getStartCorner().getSecond()).intValue(), 0.0F);
      int yPos = 0;
      int yStep = 0;

      for(int y = 0; y < 11; ++y) {
         boolean yEven = y % 2 == 0;
         yPos += yStep;
         yStep = yEven ? MapUtils.INSTANCE.getRoomSize() : MapUtils.INSTANCE.getConnectorSize();
         int xPos = 0;
         int xStep = 0;

         for(int x = 0; x < 11; ++x) {
            boolean xEven = x % 2 == 0;
            xPos += xStep;
            xStep = xEven ? MapUtils.INSTANCE.getRoomSize() : MapUtils.INSTANCE.getConnectorSize();
            Tile tile = Dungeon.Info.INSTANCE.getDungeonList()[y * 11 + x];
            if (!(tile instanceof Unknown) && (!MapRender.INSTANCE.getLegitRender() || tile.getState() != RoomState.UNDISCOVERED)) {
               Color color = tile.getColor();
               Utils var10000 = Utils.INSTANCE;
               RoomState var10001 = tile.getState();
               Object[] var11 = new Object[]{RoomState.UNDISCOVERED, RoomState.UNOPENED};
               if (var10000.equalsOneOf(var10001, var11) && !MapRender.INSTANCE.getLegitRender() && Dungeon.Info.INSTANCE.getStartTime() != 0L) {
                  if (Config.INSTANCE.getMapDarkenUndiscovered()) {
                     color = RenderUtils.INSTANCE.darken(color, (float)1 - Config.INSTANCE.getMapDarkenPercent());
                  }

                  if (Config.INSTANCE.getMapGrayUndiscovered()) {
                     color = RenderUtils.INSTANCE.grayScale(color);
                  }
               }

               if (tile instanceof Room) {
                  RenderUtilsGL.INSTANCE.renderRect((Number)xPos, (Number)yPos, (Number)xStep, (Number)yStep, color);
                  if (MapRender.INSTANCE.getLegitRender() && tile.getState() == RoomState.UNOPENED) {
                     RenderUtilsGL.INSTANCE.drawCheckmark((float)xPos, (float)yPos, tile.getState());
                  }
               } else if (tile instanceof Door) {
                  int doorOffset = MapUtils.INSTANCE.getRoomSize() == 16 ? 5 : 6;
                  if (xEven) {
                     RenderUtilsGL.INSTANCE.renderRect((Number)xPos + doorOffset, (Number)yPos, (Number)xStep - doorOffset * 2, (Number)yStep, color);
                  } else {
                     RenderUtilsGL.INSTANCE.renderRect((Number)xPos, (Number)yPos + doorOffset, (Number)xStep, (Number)yStep - doorOffset * 2, color);
                  }
               }
            }
         }
      }

      GlStateManager.func_179109_b(-((float)((Number)MapUtils.INSTANCE.getStartCorner().getFirst()).intValue()), -((float)((Number)MapUtils.INSTANCE.getStartCorner().getSecond()).intValue()), 0.0F);
   }

   private final void renderText() {
      GlStateManager.func_179109_b((float)((Number)MapUtils.INSTANCE.getStartCorner().getFirst()).intValue(), (float)((Number)MapUtils.INSTANCE.getStartCorner().getSecond()).intValue(), 0.0F);
      Iterable $this$forEach$iv = (Iterable)Dungeon.Info.INSTANCE.getUniqueRooms();
      int $i$f$forEach = false;
      Iterator var3 = $this$forEach$iv.iterator();

      while(var3.hasNext()) {
         Object element$iv = var3.next();
         UniqueRoom unique = (UniqueRoom)element$iv;
         int var6 = false;
         Room room = unique.getMainRoom();
         Utils var10000;
         if (MapRender.INSTANCE.getLegitRender()) {
            var10000 = Utils.INSTANCE;
            RoomState var10001 = room.getState();
            Object[] var8 = new Object[]{RoomState.UNDISCOVERED, RoomState.UNOPENED};
            if (var10000.equalsOneOf(var10001, var8)) {
               continue;
            }
         }

         Pair checkPos = unique.getCheckmarkPosition();
         Pair namePos = unique.getNamePosition();
         float xPosCheck = ((Number)checkPos.getFirst()).floatValue() / 2.0F * (float)(MapUtils.INSTANCE.getRoomSize() + MapUtils.INSTANCE.getConnectorSize());
         float yPosCheck = ((Number)checkPos.getSecond()).floatValue() / 2.0F * (float)(MapUtils.INSTANCE.getRoomSize() + MapUtils.INSTANCE.getConnectorSize());
         float xPosName = ((Number)namePos.getFirst()).floatValue() / 2.0F * (float)(MapUtils.INSTANCE.getRoomSize() + MapUtils.INSTANCE.getConnectorSize());
         float yPosName = ((Number)namePos.getSecond()).floatValue() / 2.0F * (float)(MapUtils.INSTANCE.getRoomSize() + MapUtils.INSTANCE.getConnectorSize());
         if (Config.INSTANCE.getMapCheckmark() != 0 && Config.INSTANCE.getMapRoomSecrets() != 2) {
            RenderUtilsGL.INSTANCE.drawCheckmark(xPosCheck, yPosCheck, room.getState());
         }

         Color var18;
         if (Config.INSTANCE.getMapColorText()) {
            switch(MapRenderList.WhenMappings.$EnumSwitchMapping$0[room.getState().ordinal()]) {
            case 1:
               var18 = Config.INSTANCE.getColorTextGreen();
               break;
            case 2:
               var18 = Config.INSTANCE.getColorTextCleared();
               break;
            case 3:
               var18 = Config.INSTANCE.getColorTextFailed();
               break;
            default:
               var18 = Config.INSTANCE.getColorTextUncleared();
            }
         } else {
            var18 = Config.INSTANCE.getColorTextCleared();
         }

         Color color = var18;
         if (Config.INSTANCE.getMapRoomSecrets() == 2) {
            GlStateManager.func_179094_E();
            GlStateManager.func_179109_b(xPosCheck + (float)MapUtils.INSTANCE.getHalfRoomSize(), yPosCheck + (float)2 + (float)MapUtils.INSTANCE.getHalfRoomSize(), 0.0F);
            GlStateManager.func_179152_a(2.0F, 2.0F, 1.0F);
            RenderUtilsGL.INSTANCE.renderCenteredText(CollectionsKt.listOf(String.valueOf(room.getData().getSecrets())), 0, 0, color);
            GlStateManager.func_179121_F();
         }

         List name;
         label52: {
            label62: {
               name = (List)(new ArrayList());
               Object[] var16;
               RoomType var20;
               if (Config.INSTANCE.getMapRoomNames() != 0) {
                  var10000 = Utils.INSTANCE;
                  var20 = room.getData().getType();
                  var16 = new Object[]{RoomType.PUZZLE, RoomType.TRAP};
                  if (var10000.equalsOneOf(var20, var16)) {
                     break label62;
                  }
               }

               if (Config.INSTANCE.getMapRoomNames() != 2) {
                  break label52;
               }

               var10000 = Utils.INSTANCE;
               var20 = room.getData().getType();
               var16 = new Object[]{RoomType.NORMAL, RoomType.RARE, RoomType.CHAMPION};
               if (!var10000.equalsOneOf(var20, var16)) {
                  break label52;
               }
            }

            CharSequence var21 = (CharSequence)room.getData().getName();
            String[] var19 = new String[]{" "};
            name.addAll((Collection)StringsKt.split$default(var21, var19, false, 0, 6, (Object)null));
         }

         if (room.getData().getType() == RoomType.NORMAL && Config.INSTANCE.getMapRoomSecrets() == 1) {
            name.add(String.valueOf(room.getData().getSecrets()));
         }

         RenderUtilsGL.INSTANCE.renderCenteredText(name, (int)xPosName + MapUtils.INSTANCE.getHalfRoomSize(), (int)yPosName + MapUtils.INSTANCE.getHalfRoomSize(), color);
      }

      GlStateManager.func_179109_b(-((float)((Number)MapUtils.INSTANCE.getStartCorner().getFirst()).intValue()), -((float)((Number)MapUtils.INSTANCE.getStartCorner().getSecond()).intValue()), 0.0F);
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
            var0[RoomState.GREEN.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[RoomState.CLEARED.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[RoomState.FAILED.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
