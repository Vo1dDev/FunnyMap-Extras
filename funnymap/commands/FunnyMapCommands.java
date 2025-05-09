package funnymap.commands;

import funnymap.FunnyMap;
import funnymap.config.Config;
import funnymap.core.ExtrasData;
import funnymap.core.RoomData;
import funnymap.core.map.Room;
import funnymap.features.dungeon.Dungeon;
import funnymap.features.dungeon.DungeonScan;
import funnymap.features.dungeon.ScanUtils;
import funnymap.features.extras.BlockSelectGui;
import funnymap.features.extras.EditMode;
import funnymap.features.extras.ExtrasDungeon;
import funnymap.utils.Utils;
import gg.essential.universal.UChat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.NumberInvalidException;
import net.minecraft.util.BlockPos;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"J3\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006#"},
   d2 = {"Lfunnymap/commands/FunnyMapCommands;", "Lnet/minecraft/command/CommandBase;", "Lnet/minecraft/command/ICommandSender;", "sender", "", "", "args", "Lnet/minecraft/util/BlockPos;", "pos", "", "addTabCompletionOptions", "(Lnet/minecraft/command/ICommandSender;[Ljava/lang/String;Lnet/minecraft/util/BlockPos;)Ljava/util/List;", "", "getCommandAliases", "()Ljava/util/List;", "getCommandName", "()Ljava/lang/String;", "getCommandUsage", "(Lnet/minecraft/command/ICommandSender;)Ljava/lang/String;", "", "getRequiredPermissionLevel", "()I", "", "processCommand", "(Lnet/minecraft/command/ICommandSender;[Ljava/lang/String;)V", "commands", "Ljava/util/List;", "extrasCommands", "lastConfirmationRoom", "Ljava/lang/String;", "", "lastConfirmationTime", "J", "<init>", "()V", "FunnyMapExtras"}
)
public final class FunnyMapCommands extends CommandBase {
   private long lastConfirmationTime;
   @NotNull
   private String lastConfirmationRoom = "";
   @NotNull
   private final List<String> commands;
   @NotNull
   private final List<String> extrasCommands;

   public FunnyMapCommands() {
      String[] var1 = new String[]{"help", "scan", "roomdata"};
      this.commands = CollectionsKt.listOf(var1);
      Collection var10001 = (Collection)this.commands;
      var1 = new String[]{"editmode", "block", "blockgui", "toggleextras", "clearroom", "guide"};
      this.extrasCommands = CollectionsKt.plus(var10001, (Iterable)CollectionsKt.listOf(var1));
   }

   @NotNull
   public String func_71517_b() {
      return "funnymap";
   }

   @NotNull
   public List<String> func_71514_a() {
      String[] var1 = new String[]{"fmap", "fm"};
      return CollectionsKt.listOf(var1);
   }

   @NotNull
   public String func_71518_a(@NotNull ICommandSender sender) {
      Intrinsics.checkNotNullParameter(sender, "sender");
      return '/' + this.func_71517_b();
   }

   public int func_82362_a() {
      return 0;
   }

   public void func_71515_b(@NotNull ICommandSender sender, @NotNull String[] args) {
      Intrinsics.checkNotNullParameter(sender, "sender");
      Intrinsics.checkNotNullParameter(args, "args");
      if (args.length == 0) {
         FunnyMap.INSTANCE.setDisplay((GuiScreen)Config.INSTANCE.gui());
      } else {
         label179: {
            label180: {
               String var3 = args[0];
               switch(var3.hashCode()) {
               case -1270003544:
                  if (var3.equals("clearroom")) {
                     ScanUtils var10 = ScanUtils.INSTANCE;
                     BlockPos var13 = FunnyMap.INSTANCE.getMc().field_71439_g.func_180425_c();
                     Intrinsics.checkNotNullExpressionValue(var13, "getPosition(...)");
                     Room room = var10.getRoomFromPos(var13);
                     if (room == null) {
                        Utils.INSTANCE.modMessage("§cYou are not standing in a valid room!");
                        return;
                     }

                     String roomName = room.getData().getName();
                     if (System.currentTimeMillis() - this.lastConfirmationTime <= 10000L && Intrinsics.areEqual(this.lastConfirmationRoom, roomName)) {
                        ExtrasData var11 = (ExtrasData)FunnyMap.INSTANCE.getExtras().getConfig().get(roomName);
                        if (var11 != null) {
                           Map var12 = var11.getPreBlocks();
                           if (var12 != null) {
                              var12.clear();
                           }
                        }

                        ExtrasDungeon.INSTANCE.updateBlocks(roomName);
                        Utils.INSTANCE.modMessage("§aCleared all custom blocks in §c" + roomName + "§a!");
                     } else {
                        this.lastConfirmationTime = System.currentTimeMillis();
                        this.lastConfirmationRoom = roomName;
                        Utils.INSTANCE.modMessage("§aAre you sure you want to clear all saved blocks in §c" + roomName + "§a? Run the command again to confirm.");
                     }

                     return;
                  }

                  return;
               case -664574578:
                  if (!var3.equals("blockgui")) {
                     return;
                  }
                  break label179;
               case -172848379:
                  if (var3.equals("roomdata")) {
                     Pair pos = ScanUtils.INSTANCE.getRoomCentre((int)FunnyMap.INSTANCE.getMc().field_71439_g.field_70165_t, (int)FunnyMap.INSTANCE.getMc().field_71439_g.field_70161_v);
                     RoomData data = ScanUtils.INSTANCE.getRoomData(((Number)pos.getFirst()).intValue(), ((Number)pos.getSecond()).intValue());
                     if (data != null) {
                        GuiScreen.func_146275_d(data.toString());
                        Utils.INSTANCE.modMessage("Copied room data to clipboard.");
                     } else {
                        GuiScreen.func_146275_d(String.valueOf(ScanUtils.INSTANCE.getCore(((Number)pos.getFirst()).intValue(), ((Number)pos.getSecond()).intValue())));
                        Utils.INSTANCE.modMessage("Existing room data not found. Copied room core to clipboard.");
                     }

                     return;
                  }

                  return;
               case 3141:
                  if (!var3.equals("bg")) {
                     return;
                  }
                  break label179;
               case 3240:
                  if (!var3.equals("em")) {
                     return;
                  }
                  break label180;
               case 3697:
                  if (!var3.equals("te")) {
                     return;
                  }
                  break;
               case 3198785:
                  if (var3.equals("help")) {
                     UChat.chat("§b§l<§fFunnyMap Commands§b§l>\n  §b/funnymap §9> §3Opens the main mod GUI. §7(Alias: fm, fmap)\n  §b/§ffunnymap §bscan §9> §3Rescans the map.\n  §b/§ffunnymap §broomdata §9> §3Copies current room data or room core to clipboard.\n\n§b§l<§fFunnyMapExtras Commands§b§l>\n  §b/§ffunnymap §beditmode §9> §3§3Toggles edit mode. §7(Alias: em)\n  §b/§ffunnymap §bblock §a[block] §9> §3Change edit mode block.\n  §b/§ffunnymap §bblockgui §9> §3Opens menu to select edit mode block. §7(Alias: bg)\n  §b/§ffunnymap §btoggleextras §9> §3Toggles extras functionality. §7(Alias: te)\n  §b/§ffunnymap §bclearroom §9> §3Clears custom blocks in the current room.\n  §b/§ffunnymap §bguide §9> §3Shows basic edit mode guide.");
                  }

                  return;
               case 3524221:
                  if (var3.equals("scan")) {
                     Dungeon.INSTANCE.reset();
                     DungeonScan.INSTANCE.scan();
                  }

                  return;
               case 93832333:
                  if (var3.equals("block")) {
                     if (args.length != 2) {
                        Utils.INSTANCE.modMessage("§cSpecify a block.");
                        return;
                     }

                     try {
                        Block block = CommandBase.func_147180_g(sender, args[1]);
                        EditMode var10000 = EditMode.INSTANCE;
                        IBlockState var10001 = block.func_176223_P();
                        Intrinsics.checkNotNullExpressionValue(var10001, "getDefaultState(...)");
                        var10000.setCurrentBlock(var10001);
                     } catch (NumberInvalidException var6) {
                        Utils.INSTANCE.modMessage("§cInvalid block name.");
                     }

                     return;
                  }

                  return;
               case 98712316:
                  if (var3.equals("guide")) {
                     UChat.chat("§b§l<§fFunnyMapExtras Guide§b§l>\nEdit Mode:\n  §bLeft clicking §fis a §cdelete §faction. This will:\n    §7- §3Change a dungeon block to a ghost block §for\n    §7- §3Remove a custom block\n  §bRight clicking §fis a §aplace §faction. This will:\n    §7- §3Remove a ghost block §for\n    §7- §3Place a custom block\n  §bShift right click §3removes any ghost blocks §fand §3places a custom block.\n    §7- §3This lets you replace existing dungeon blocks by §bleft clicking §fthen §bshift right clicking§3.\n  §bMiddle click §3sets your current block to the block you're looking at.\nBlock select GUI:\n  §bLeft clicking §3selects your current custom block. This will be highlighted in §agreen§3.\n  §bRight clicking §3adds/removes a block from your favourites tab. Favourite blocks will be highlighted in §baqua§3.");
                  }

                  return;
               case 1602785965:
                  if (!var3.equals("editmode")) {
                     return;
                  }
                  break label180;
               case 1639766711:
                  if (!var3.equals("toggleextras")) {
                     return;
                  }
                  break;
               default:
                  return;
               }

               FunnyMap.INSTANCE.getExtras().setEnabled(!FunnyMap.INSTANCE.getExtras().getEnabled());
               Config.INSTANCE.setEnableExtras(FunnyMap.INSTANCE.getExtras().getEnabled());
               Config.INSTANCE.markDirty();
               Config.INSTANCE.writeData();
               Utils.INSTANCE.modMessage("Extras " + (FunnyMap.INSTANCE.getExtras().getEnabled() ? "§aenabled" : "§cdisabled") + '!');
               return;
            }

            if (FunnyMap.INSTANCE.getExtras().getEnabled()) {
               EditMode.INSTANCE.setEnabled(!EditMode.INSTANCE.getEnabled());
               Utils.INSTANCE.modMessage("Edit Mode " + (EditMode.INSTANCE.getEnabled() ? "§aenabled" : "§cdisabled") + '!');
               FunnyMap.INSTANCE.getExtras().saveConfig();
               FunnyMap.INSTANCE.getExtras().loadConfig();
            }

            return;
         }

         FunnyMap.INSTANCE.setDisplay((GuiScreen)(new BlockSelectGui()));
      }
   }

   @NotNull
   public List<String> func_180525_a(@NotNull ICommandSender sender, @NotNull String[] args, @NotNull BlockPos pos) {
      Intrinsics.checkNotNullParameter(sender, "sender");
      Intrinsics.checkNotNullParameter(args, "args");
      Intrinsics.checkNotNullParameter(pos, "pos");
      List var10000;
      if (args.length == 1) {
         var10000 = CommandBase.func_175762_a(args, (Collection)(FunnyMap.INSTANCE.getExtras().getEnabled() ? this.extrasCommands : this.commands));
         Intrinsics.checkNotNullExpressionValue(var10000, "getListOfStringsMatchingLastWord(...)");
         return var10000;
      } else if (Intrinsics.areEqual(args[0], "block") && args.length == 2) {
         var10000 = CommandBase.func_175762_a(args, (Collection)Block.field_149771_c.func_148742_b());
         Intrinsics.checkNotNullExpressionValue(var10000, "getListOfStringsMatchingLastWord(...)");
         return var10000;
      } else {
         return (List)(new ArrayList());
      }
   }
}
