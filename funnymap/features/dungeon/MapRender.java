package funnymap.features.dungeon;

import funnymap.FunnyMap;
import funnymap.config.Config;
import funnymap.core.DungeonPlayer;
import funnymap.core.map.Door;
import funnymap.core.map.Room;
import funnymap.core.map.RoomState;
import funnymap.core.map.RoomType;
import funnymap.core.map.Tile;
import funnymap.core.map.UniqueRoom;
import funnymap.core.map.Unknown;
import funnymap.ui.ScoreElement;
import funnymap.utils.Location;
import funnymap.utils.MapUtils;
import funnymap.utils.RenderUtils;
import funnymap.utils.Utils;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b%\u0010\u000fJ?\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\r\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u000fJ\u000f\u0010\u0013\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0013\u0010\u000fJ\r\u0010\u0014\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR*\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0011\u0010$\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b#\u0010 ¨\u0006&"},
   d2 = {"Lfunnymap/features/dungeon/MapRender;", "", "", "x", "y", "doorWidth", "", "doorway", "vertical", "Ljava/awt/Color;", "color", "", "drawRoomConnector", "(IIIZZLjava/awt/Color;)V", "renderMap", "()V", "renderPlayerHeads", "renderRooms", "renderRunInformation", "renderText", "setupRotate", "", "dynamicRotation", "F", "getDynamicRotation", "()F", "setDynamicRotation", "(F)V", "value", "legitPeek", "Z", "getLegitPeek", "()Z", "setLegitPeek", "(Z)V", "getLegitRender", "legitRender", "<init>", "FunnyMapExtras"}
)
@SourceDebugExtension({"SMAP\nMapRender.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapRender.kt\nfunnymap/features/dungeon/MapRender\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,292:1\n1855#2,2:293\n959#2,7:297\n936#2,15:304\n215#3,2:295\n*S KotlinDebug\n*F\n+ 1 MapRender.kt\nfunnymap/features/dungeon/MapRender\n*L\n180#1:293,2\n283#1:297,7\n284#1:304,15\n243#1:295,2\n*E\n"})
public final class MapRender {
   @NotNull
   public static final MapRender INSTANCE = new MapRender();
   private static float dynamicRotation;
   private static boolean legitPeek;

   private MapRender() {
   }

   public final float getDynamicRotation() {
      return dynamicRotation;
   }

   public final void setDynamicRotation(float <set-?>) {
      dynamicRotation = var1;
   }

   public final boolean getLegitPeek() {
      return legitPeek;
   }

   public final void setLegitPeek(boolean value) {
      if (legitPeek != value && Config.INSTANCE.getLegitMode()) {
         MapRenderList.INSTANCE.setRenderUpdated(true);
      }

      legitPeek = value;
   }

   public final boolean getLegitRender() {
      return Config.INSTANCE.getLegitMode() && !legitPeek;
   }

   public final void renderMap() {
      FunnyMap.INSTANCE.getMc().field_71424_I.func_76320_a("border");
      RenderUtils.INSTANCE.renderRect((Number)0.0D, (Number)0.0D, (Number)128.0D, (Number)Config.INSTANCE.getMapShowRunInformation() ? 142.0D : 128.0D, Config.INSTANCE.getMapBackground());
      RenderUtils.INSTANCE.renderRectBorder(0.0D, 0.0D, 128.0D, Config.INSTANCE.getMapShowRunInformation() ? 142.0D : 128.0D, (double)Config.INSTANCE.getMapBorderWidth(), Config.INSTANCE.getMapBorder());
      FunnyMap.INSTANCE.getMc().field_71424_I.func_76319_b();
      if (Config.INSTANCE.getMapRotate()) {
         GlStateManager.func_179094_E();
         this.setupRotate();
      } else if (Config.INSTANCE.getMapDynamicRotate()) {
         GlStateManager.func_179137_b(64.0D, 64.0D, 0.0D);
         GlStateManager.func_179114_b(dynamicRotation, 0.0F, 0.0F, 1.0F);
         GlStateManager.func_179137_b(-64.0D, -64.0D, 0.0D);
      }

      FunnyMap.INSTANCE.getMc().field_71424_I.func_76320_a("rooms");
      this.renderRooms();
      FunnyMap.INSTANCE.getMc().field_71424_I.func_76318_c("text");
      this.renderText();
      if (!Location.INSTANCE.getInBoss()) {
         FunnyMap.INSTANCE.getMc().field_71424_I.func_76318_c("heads");
         this.renderPlayerHeads();
      }

      FunnyMap.INSTANCE.getMc().field_71424_I.func_76319_b();
      if (Config.INSTANCE.getMapRotate()) {
         GL11.glDisable(3089);
         GlStateManager.func_179121_F();
      } else if (Config.INSTANCE.getMapDynamicRotate()) {
         GlStateManager.func_179137_b(64.0D, 64.0D, 0.0D);
         GlStateManager.func_179114_b(-dynamicRotation, 0.0F, 0.0F, 1.0F);
         GlStateManager.func_179137_b(-64.0D, -64.0D, 0.0D);
      }

      if (Config.INSTANCE.getMapShowRunInformation()) {
         FunnyMap.INSTANCE.getMc().field_71424_I.func_76320_a("footer");
         this.renderRunInformation();
         FunnyMap.INSTANCE.getMc().field_71424_I.func_76319_b();
      }

   }

   public final void setupRotate() {
      int scale = (new ScaledResolution(FunnyMap.INSTANCE.getMc())).func_78325_e();
      GL11.glEnable(3089);
      GL11.glScissor(Config.INSTANCE.getMapX() * scale, (int)((float)(FunnyMap.INSTANCE.getMc().field_71440_d - Config.INSTANCE.getMapY() * scale) - (float)(128 * scale) * Config.INSTANCE.getMapScale()), (int)((float)(128 * scale) * Config.INSTANCE.getMapScale()), (int)((float)(128 * scale) * Config.INSTANCE.getMapScale()));
      GlStateManager.func_179137_b(64.0D, 64.0D, 0.0D);
      GlStateManager.func_179114_b(-FunnyMap.INSTANCE.getMc().field_71439_g.field_70177_z + 180.0F, 0.0F, 0.0F, 1.0F);
      if (Config.INSTANCE.getMapCenter()) {
         GlStateManager.func_179137_b(-((FunnyMap.INSTANCE.getMc().field_71439_g.field_70165_t - (double)-185 + (double)15) * MapUtils.INSTANCE.getCoordMultiplier() + ((Number)MapUtils.INSTANCE.getStartCorner().getFirst()).doubleValue() - (double)2), -((FunnyMap.INSTANCE.getMc().field_71439_g.field_70161_v - (double)-185 + (double)15) * MapUtils.INSTANCE.getCoordMultiplier() + ((Number)MapUtils.INSTANCE.getStartCorner().getSecond()).doubleValue() - (double)2), 0.0D);
      } else {
         GlStateManager.func_179137_b(-64.0D, -64.0D, 0.0D);
      }

   }

   private final void renderRooms() {
      GlStateManager.func_179094_E();
      GlStateManager.func_179109_b((float)((Number)MapUtils.INSTANCE.getStartCorner().getFirst()).intValue(), (float)((Number)MapUtils.INSTANCE.getStartCorner().getSecond()).intValue(), 0.0F);

      for(int y = 0; y < 11; ++y) {
         for(int x = 0; x < 11; ++x) {
            Tile tile = Dungeon.Info.INSTANCE.getDungeonList()[y * 11 + x];
            if (!(tile instanceof Unknown) && (!this.getLegitRender() || tile.getState() != RoomState.UNDISCOVERED)) {
               int xOffset = (x >> 1) * (MapUtils.INSTANCE.getRoomSize() + MapUtils.INSTANCE.getConnectorSize());
               int yOffset = (y >> 1) * (MapUtils.INSTANCE.getRoomSize() + MapUtils.INSTANCE.getConnectorSize());
               boolean xEven = (x & 1) == 0;
               boolean yEven = (y & 1) == 0;
               Color color = tile.getColor();
               Utils var10000 = Utils.INSTANCE;
               RoomState var10001 = tile.getState();
               Object[] var9 = new Object[]{RoomState.UNDISCOVERED, RoomState.UNOPENED};
               if (var10000.equalsOneOf(var10001, var9) && !this.getLegitRender() && Dungeon.Info.INSTANCE.getStartTime() != 0L) {
                  if (Config.INSTANCE.getMapDarkenUndiscovered()) {
                     color = RenderUtils.INSTANCE.darken(color, (float)1 - Config.INSTANCE.getMapDarkenPercent());
                  }

                  if (Config.INSTANCE.getMapGrayUndiscovered()) {
                     color = RenderUtils.INSTANCE.grayScale(color);
                  }
               }

               if (xEven && yEven) {
                  if (tile instanceof Room) {
                     RenderUtils.INSTANCE.renderRect((Number)xOffset, (Number)yOffset, (Number)MapUtils.INSTANCE.getRoomSize(), (Number)MapUtils.INSTANCE.getRoomSize(), color);
                     if (this.getLegitRender() && tile.getState() == RoomState.UNOPENED) {
                        RenderUtils.INSTANCE.drawCheckmark((float)xOffset, (float)yOffset, tile.getState());
                     }
                  }
               } else if (!xEven && !yEven) {
                  RenderUtils.INSTANCE.renderRect((Number)xOffset, (Number)yOffset, (Number)MapUtils.INSTANCE.getRoomSize() + MapUtils.INSTANCE.getConnectorSize(), (Number)MapUtils.INSTANCE.getRoomSize() + MapUtils.INSTANCE.getConnectorSize(), color);
               } else {
                  this.drawRoomConnector(xOffset, yOffset, MapUtils.INSTANCE.getConnectorSize(), tile instanceof Door, !xEven, color);
               }
            }
         }
      }

      GlStateManager.func_179121_F();
   }

   private final void renderText() {
      GlStateManager.func_179094_E();
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
         if (INSTANCE.getLegitRender()) {
            var10000 = Utils.INSTANCE;
            RoomState var10001 = room.getState();
            Object[] var8 = new Object[]{RoomState.UNDISCOVERED, RoomState.UNOPENED};
            if (var10000.equalsOneOf(var10001, var8)) {
               continue;
            }
         }

         Pair checkPos = unique.getCheckmarkPosition();
         Pair namePos = unique.getNamePosition();
         float xOffsetCheck = ((Number)checkPos.getFirst()).floatValue() / 2.0F * (float)(MapUtils.INSTANCE.getRoomSize() + MapUtils.INSTANCE.getConnectorSize());
         float yOffsetCheck = ((Number)checkPos.getSecond()).floatValue() / 2.0F * (float)(MapUtils.INSTANCE.getRoomSize() + MapUtils.INSTANCE.getConnectorSize());
         float xOffsetName = ((Number)namePos.getFirst()).floatValue() / 2.0F * (float)(MapUtils.INSTANCE.getRoomSize() + MapUtils.INSTANCE.getConnectorSize());
         float yOffsetName = ((Number)namePos.getSecond()).floatValue() / 2.0F * (float)(MapUtils.INSTANCE.getRoomSize() + MapUtils.INSTANCE.getConnectorSize());
         if (Config.INSTANCE.getMapCheckmark() != 0 && Config.INSTANCE.getMapRoomSecrets() != 2) {
            RenderUtils.INSTANCE.drawCheckmark(xOffsetCheck, yOffsetCheck, room.getState());
         }

         Color var18;
         if (Config.INSTANCE.getMapColorText()) {
            switch(MapRender.WhenMappings.$EnumSwitchMapping$0[room.getState().ordinal()]) {
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

         int color = var18.getRGB();
         if (Config.INSTANCE.getMapRoomSecrets() == 2) {
            GlStateManager.func_179094_E();
            GlStateManager.func_179109_b(xOffsetCheck + (float)MapUtils.INSTANCE.getHalfRoomSize(), yOffsetCheck + (float)2 + (float)MapUtils.INSTANCE.getHalfRoomSize(), 0.0F);
            GlStateManager.func_179152_a(2.0F, 2.0F, 1.0F);
            RenderUtils.INSTANCE.renderCenteredText(CollectionsKt.listOf(String.valueOf(room.getData().getSecrets())), 0, 0, color);
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

         RenderUtils.INSTANCE.renderCenteredText(name, (int)xOffsetName + MapUtils.INSTANCE.getHalfRoomSize(), (int)yOffsetName + MapUtils.INSTANCE.getHalfRoomSize(), color);
      }

      GlStateManager.func_179121_F();
   }

   public final void renderPlayerHeads() {
      try {
         if (Dungeon.INSTANCE.getDungeonTeammates().isEmpty()) {
            RenderUtils var10000 = RenderUtils.INSTANCE;
            String var10001 = FunnyMap.INSTANCE.getMc().field_71439_g.func_70005_c_();
            Intrinsics.checkNotNullExpressionValue(var10001, "getName(...)");
            ResourceLocation var10004 = FunnyMap.INSTANCE.getMc().field_71439_g.func_110306_p();
            Intrinsics.checkNotNullExpressionValue(var10004, "getLocationSkin(...)");
            DungeonPlayer var1 = new DungeonPlayer(var10004);
            String var10 = var10001;
            RenderUtils var9 = var10000;
            int var3 = false;
            var1.setYaw(FunnyMap.INSTANCE.getMc().field_71439_g.field_70177_z);
            Unit var11 = Unit.INSTANCE;
            var9.drawPlayerHead(var10, var1);
         } else {
            Map $this$forEach$iv = Dungeon.INSTANCE.getDungeonTeammates();
            int $i$f$forEach = false;
            Iterator var14 = $this$forEach$iv.entrySet().iterator();

            while(var14.hasNext()) {
               Entry element$iv = (Entry)var14.next();
               int var6 = false;
               String name = (String)element$iv.getKey();
               DungeonPlayer teammate = (DungeonPlayer)element$iv.getValue();
               if (!teammate.getDead()) {
                  RenderUtils.INSTANCE.drawPlayerHead(name, teammate);
               }
            }
         }
      } catch (ConcurrentModificationException var12) {
      }

   }

   private final void drawRoomConnector(int x, int y, int doorWidth, boolean doorway, boolean vertical, Color color) {
      int doorwayOffset = MapUtils.INSTANCE.getRoomSize() == 16 ? 5 : 6;
      int width = doorway ? 6 : MapUtils.INSTANCE.getRoomSize();
      int x1 = vertical ? x + MapUtils.INSTANCE.getRoomSize() : x;
      int y1 = vertical ? y : y + MapUtils.INSTANCE.getRoomSize();
      if (doorway) {
         if (vertical) {
            y1 += doorwayOffset;
         } else {
            x1 += doorwayOffset;
         }
      }

      RenderUtils.INSTANCE.renderRect((Number)x1, (Number)y1, (Number)vertical ? doorWidth : width, (Number)vertical ? width : doorWidth, color);
   }

   public final void renderRunInformation() {
      GlStateManager.func_179094_E();
      GlStateManager.func_179109_b(64.0F, 128.0F, 0.0F);
      GlStateManager.func_179139_a(0.6666666666666666D, 0.6666666666666666D, 1.0D);
      List lines = ScoreElement.Companion.runInformationLines();
      Iterable $this$takeWhile$iv = (Iterable)lines;
      int $i$f$takeWhile = false;
      ArrayList list$iv = new ArrayList();
      Iterator var6 = $this$takeWhile$iv.iterator();

      while(var6.hasNext()) {
         Object item$iv = var6.next();
         String it = (String)item$iv;
         int var9 = false;
         if (Intrinsics.areEqual(it, "split")) {
            break;
         }

         list$iv.add(item$iv);
      }

      String lineOne = CollectionsKt.joinToString$default((Iterable)((List)list$iv), (CharSequence)"    ", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null, 62, (Object)null);
      int $i$f$takeLastWhile = false;
      List var10000;
      if (lines.isEmpty()) {
         var10000 = CollectionsKt.emptyList();
      } else {
         label59: {
            ListIterator iterator$iv = lines.listIterator(lines.size());

            while(iterator$iv.hasPrevious()) {
               String it = (String)iterator$iv.previous();
               int var17 = false;
               if (Intrinsics.areEqual(it, "split")) {
                  iterator$iv.next();
                  int expectedSize$iv = lines.size() - iterator$iv.nextIndex();
                  if (expectedSize$iv == 0) {
                     var10000 = CollectionsKt.emptyList();
                  } else {
                     ArrayList var10 = new ArrayList(expectedSize$iv);
                     ArrayList $this$takeLastWhile_u24lambda_u245$iv = var10;
                     boolean var12 = false;

                     while(iterator$iv.hasNext()) {
                        $this$takeLastWhile_u24lambda_u245$iv.add(iterator$iv.next());
                     }

                     var10000 = (List)var10;
                  }
                  break label59;
               }
            }

            var10000 = CollectionsKt.toList((Iterable)lines);
         }
      }

      String lineTwo = CollectionsKt.joinToString$default((Iterable)var10000, (CharSequence)"    ", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null, 62, (Object)null);
      FunnyMap.INSTANCE.getMc().field_71466_p.func_175065_a(lineOne, (float)(-FunnyMap.INSTANCE.getMc().field_71466_p.func_78256_a(lineOne)) / 2.0F, 0.0F, 16777215, true);
      FunnyMap.INSTANCE.getMc().field_71466_p.func_175065_a(lineTwo, (float)(-FunnyMap.INSTANCE.getMc().field_71466_p.func_78256_a(lineTwo)) / 2.0F, 9.0F, 16777215, true);
      GlStateManager.func_179121_F();
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
