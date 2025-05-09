package funnymap.events;

import funnymap.utils.Utils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.play.server.S02PacketChat;
import net.minecraftforge.fml.common.eventhandler.Event;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"},
   d2 = {"Lfunnymap/events/ChatEvent;", "Lnet/minecraftforge/fml/common/eventhandler/Event;", "Lnet/minecraft/network/play/server/S02PacketChat;", "packet", "Lnet/minecraft/network/play/server/S02PacketChat;", "getPacket", "()Lnet/minecraft/network/play/server/S02PacketChat;", "", "text$delegate", "Lkotlin/Lazy;", "getText", "()Ljava/lang/String;", "text", "<init>", "(Lnet/minecraft/network/play/server/S02PacketChat;)V", "FunnyMapExtras"}
)
public final class ChatEvent extends Event {
   @NotNull
   private final S02PacketChat packet;
   @NotNull
   private final Lazy text$delegate;

   public ChatEvent(@NotNull S02PacketChat packet) {
      Intrinsics.checkNotNullParameter(packet, "packet");
      super();
      this.packet = packet;
      this.text$delegate = LazyKt.lazy((Function0)(new Function0<String>() {
         @NotNull
         public final String invoke() {
            Utils var10000 = Utils.INSTANCE;
            String var10001 = ChatEvent.this.getPacket().func_148915_c().func_150260_c();
            Intrinsics.checkNotNullExpressionValue(var10001, "getUnformattedText(...)");
            return var10000.removeFormatting(var10001);
         }
      }));
   }

   @NotNull
   public final S02PacketChat getPacket() {
      return this.packet;
   }

   @NotNull
   public final String getText() {
      Lazy var1 = this.text$delegate;
      return (String)var1.getValue();
   }
}
