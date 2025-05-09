package funnymap.ui;

import funnymap.config.Config;
import funnymap.features.dungeon.MapRender;
import funnymap.features.dungeon.MapRenderList;
import funnymap.utils.Location;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u001c\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR+\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011*\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\nR+\u0010\u001b\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b8V@VX\u0096\u008e\u0002¢\u0006\u0012\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\u0019*\u0004\b\u001a\u0010\u0013R\"\u0010\u001c\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\n\"\u0004\b\u001f\u0010\u0019R+\u0010#\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b8V@VX\u0096\u008e\u0002¢\u0006\u0012\u001a\u0004\b \u0010\n\"\u0004\b!\u0010\u0019*\u0004\b\"\u0010\u0013R\"\u0010$\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001d\u001a\u0004\b%\u0010\n\"\u0004\b&\u0010\u0019¨\u0006("},
   d2 = {"Lfunnymap/ui/MapElement;", "Lfunnymap/ui/MovableGuiElement;", "", "render", "()V", "", "shouldRender", "()Z", "", "getH", "()I", "h", "", "<set-?>", "getScale", "()F", "setScale", "(F)V", "getScale$delegate", "(Lfunnymap/ui/MapElement;)Ljava/lang/Object;", "scale", "getW", "w", "getX", "setX", "(I)V", "getX$delegate", "x", "x2", "I", "getX2", "setX2", "getY", "setY", "getY$delegate", "y", "y2", "getY2", "setY2", "<init>", "FunnyMapExtras"}
)
public final class MapElement extends MovableGuiElement {
   private int x2;
   private int y2;

   public MapElement() {
      Config var10000 = Config.INSTANCE;
      var10000 = Config.INSTANCE;
      var10000 = Config.INSTANCE;
      this.x2 = (int)((float)this.getX() + (float)this.getW() * this.getScale());
      this.y2 = (int)((float)this.getY() + (float)this.getH() * this.getScale());
   }

   public int getX() {
      return Config.INSTANCE.getMapX();
   }

   public void setX(int <set-?>) {
      Config.INSTANCE.setMapX(var1);
   }

   private static Object getX$delegate(MapElement <this>) {
      return Reflection.mutableProperty0((MutablePropertyReference0)(new MutablePropertyReference0Impl(Config.INSTANCE, Config.class, "mapX", "getMapX()I", 0)));
   }

   public int getY() {
      return Config.INSTANCE.getMapY();
   }

   public void setY(int <set-?>) {
      Config.INSTANCE.setMapY(var1);
   }

   private static Object getY$delegate(MapElement <this>) {
      return Reflection.mutableProperty0((MutablePropertyReference0)(new MutablePropertyReference0Impl(Config.INSTANCE, Config.class, "mapY", "getMapY()I", 0)));
   }

   public int getH() {
      return Config.INSTANCE.getMapShowRunInformation() ? 142 : 128;
   }

   public int getW() {
      return 128;
   }

   public float getScale() {
      return Config.INSTANCE.getMapScale();
   }

   public void setScale(float <set-?>) {
      Config.INSTANCE.setMapScale(var1);
   }

   private static Object getScale$delegate(MapElement <this>) {
      return Reflection.mutableProperty0((MutablePropertyReference0)(new MutablePropertyReference0Impl(Config.INSTANCE, Config.class, "mapScale", "getMapScale()F", 0)));
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
      if (Config.INSTANCE.getRenderBeta()) {
         MapRenderList.INSTANCE.renderMap();
      } else {
         MapRender.INSTANCE.renderMap();
      }

   }

   public boolean shouldRender() {
      if (!Config.INSTANCE.getMapEnabled()) {
         return false;
      } else {
         return Config.INSTANCE.getMapHideInBoss() && Location.INSTANCE.getInBoss() ? false : super.shouldRender();
      }
   }
}
