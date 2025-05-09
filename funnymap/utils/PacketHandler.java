package funnymap.utils;

import funnymap.events.ChatEvent;
import funnymap.events.ScoreboardEvent;
import funnymap.events.TabListEvent;
import funnymap.features.extras.ExtrasDungeon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S02PacketChat;
import net.minecraft.network.play.server.S23PacketBlockChange;
import net.minecraft.network.play.server.S34PacketMaps;
import net.minecraft.network.play.server.S38PacketPlayerListItem;
import net.minecraft.network.play.server.S3EPacketTeams;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"},
   d2 = {"Lfunnymap/utils/PacketHandler;", "", "Lnet/minecraft/network/Packet;", "packet", "", "processPacket", "(Lnet/minecraft/network/Packet;)Z", "<init>", "()V", "FunnyMapExtras"}
)
public final class PacketHandler {
   @NotNull
   public static final PacketHandler INSTANCE = new PacketHandler();

   private PacketHandler() {
   }

   public final boolean processPacket(@NotNull Packet<?> packet) {
      Intrinsics.checkNotNullParameter(packet, "packet");
      if (packet instanceof S02PacketChat) {
         if (((S02PacketChat)packet).func_179841_c() != 2) {
            MinecraftForge.EVENT_BUS.post((Event)(new ChatEvent((S02PacketChat)packet)));
         }
      } else if (packet instanceof S3EPacketTeams) {
         MinecraftForge.EVENT_BUS.post((Event)(new ScoreboardEvent((S3EPacketTeams)packet)));
      } else if (packet instanceof S38PacketPlayerListItem) {
         MinecraftForge.EVENT_BUS.post((Event)(new TabListEvent((S38PacketPlayerListItem)packet)));
      } else {
         if (packet instanceof S23PacketBlockChange) {
            return ExtrasDungeon.INSTANCE.handleSetBlock((S23PacketBlockChange)packet);
         }

         if (packet instanceof S34PacketMaps) {
            MapUtils.INSTANCE.updateMapData((S34PacketMaps)packet);
         }
      }

      return false;
   }
}
