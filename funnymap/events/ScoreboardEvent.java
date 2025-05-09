package funnymap.events;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.play.server.S3EPacketTeams;
import net.minecraftforge.fml.common.eventhandler.Event;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"},
   d2 = {"Lfunnymap/events/ScoreboardEvent;", "Lnet/minecraftforge/fml/common/eventhandler/Event;", "Lnet/minecraft/network/play/server/S3EPacketTeams;", "packet", "Lnet/minecraft/network/play/server/S3EPacketTeams;", "getPacket", "()Lnet/minecraft/network/play/server/S3EPacketTeams;", "<init>", "(Lnet/minecraft/network/play/server/S3EPacketTeams;)V", "FunnyMapExtras"}
)
public final class ScoreboardEvent extends Event {
   @NotNull
   private final S3EPacketTeams packet;

   public ScoreboardEvent(@NotNull S3EPacketTeams packet) {
      Intrinsics.checkNotNullParameter(packet, "packet");
      super();
      this.packet = packet;
   }

   @NotNull
   public final S3EPacketTeams getPacket() {
      return this.packet;
   }
}
