package funnymap.events;

import kotlin.Metadata;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

@Cancelable
@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"},
   d2 = {"Lfunnymap/events/ClickEvent;", "Lnet/minecraftforge/fml/common/eventhandler/Event;", "<init>", "()V", "Left", "Middle", "Right", "FunnyMapExtras"}
)
public class ClickEvent extends Event {
   @Metadata(
      mv = {1, 9, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lfunnymap/events/ClickEvent$Left;", "Lfunnymap/events/ClickEvent;", "<init>", "()V", "FunnyMapExtras"}
   )
   public static final class Left extends ClickEvent {
   }

   @Metadata(
      mv = {1, 9, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lfunnymap/events/ClickEvent$Middle;", "Lfunnymap/events/ClickEvent;", "<init>", "()V", "FunnyMapExtras"}
   )
   public static final class Middle extends ClickEvent {
   }

   @Metadata(
      mv = {1, 9, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lfunnymap/events/ClickEvent$Right;", "Lfunnymap/events/ClickEvent;", "<init>", "()V", "FunnyMapExtras"}
   )
   public static final class Right extends ClickEvent {
   }
}
