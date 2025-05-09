package funnymap;

import funnymap.commands.FunnyMapCommands;
import funnymap.config.Config;
import funnymap.config.ExtrasConfig;
import funnymap.features.dungeon.Dungeon;
import funnymap.features.dungeon.MapRender;
import funnymap.features.dungeon.MapRenderList;
import funnymap.features.dungeon.RunInformation;
import funnymap.features.dungeon.WitherDoorESP;
import funnymap.features.extras.EditMode;
import funnymap.features.extras.FreeCam;
import funnymap.ui.GuiRenderer;
import funnymap.utils.Location;
import funnymap.utils.RenderUtils;
import funnymap.utils.UpdateChecker;
import gg.essential.api.EssentialAPI;
import gg.essential.api.gui.Notifications;
import gg.essential.vigilance.gui.SettingsGui;
import java.io.File;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.command.ICommand;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Mod(
   modid = "funnymap",
   name = "Funny Map",
   version = "0.7.8",
   modLanguageAdapter = "funnymap.utils.KotlinAdapter"
)
@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b;\u0010<J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u0011\u0010\u001a\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00178\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u00178\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u00178\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0017\u0010.\u001a\u00020-8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0017\u00103\u001a\u0002028\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00109¨\u0006="},
   d2 = {"Lfunnymap/FunnyMap;", "", "Lnet/minecraftforge/client/event/GuiOpenEvent;", "event", "", "onGuiClose", "(Lnet/minecraftforge/client/event/GuiOpenEvent;)V", "Lnet/minecraftforge/fml/common/event/FMLInitializationEvent;", "onInit", "(Lnet/minecraftforge/fml/common/event/FMLInitializationEvent;)V", "Lnet/minecraftforge/fml/common/gameevent/InputEvent$KeyInputEvent;", "onKey", "(Lnet/minecraftforge/fml/common/gameevent/InputEvent$KeyInputEvent;)V", "Lnet/minecraftforge/fml/common/gameevent/TickEvent$ClientTickEvent;", "onTick", "(Lnet/minecraftforge/fml/common/gameevent/TickEvent$ClientTickEvent;)V", "Lnet/minecraftforge/fml/common/event/FMLLoadCompleteEvent;", "Lkotlinx/coroutines/Job;", "postInit", "(Lnet/minecraftforge/fml/common/event/FMLLoadCompleteEvent;)Lkotlinx/coroutines/Job;", "Lnet/minecraftforge/fml/common/event/FMLPreInitializationEvent;", "preInit", "(Lnet/minecraftforge/fml/common/event/FMLPreInitializationEvent;)V", "", "getCHAT_PREFIX", "()Ljava/lang/String;", "CHAT_PREFIX", "MOD_ID", "Ljava/lang/String;", "MOD_NAME", "MOD_VERSION", "Lnet/minecraft/client/gui/GuiScreen;", "display", "Lnet/minecraft/client/gui/GuiScreen;", "getDisplay", "()Lnet/minecraft/client/gui/GuiScreen;", "setDisplay", "(Lnet/minecraft/client/gui/GuiScreen;)V", "Lfunnymap/config/ExtrasConfig;", "extras", "Lfunnymap/config/ExtrasConfig;", "getExtras", "()Lfunnymap/config/ExtrasConfig;", "setExtras", "(Lfunnymap/config/ExtrasConfig;)V", "Lnet/minecraft/client/Minecraft;", "mc", "Lnet/minecraft/client/Minecraft;", "getMc", "()Lnet/minecraft/client/Minecraft;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "Lnet/minecraft/client/settings/KeyBinding;", "toggleFreeCamKey", "Lnet/minecraft/client/settings/KeyBinding;", "toggleLegitKey", "<init>", "()V", "FunnyMapExtras"}
)
@SourceDebugExtension({"SMAP\nFunnyMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FunnyMap.kt\nfunnymap/FunnyMap\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,131:1\n1#2:132\n1855#3,2:133\n*S KotlinDebug\n*F\n+ 1 FunnyMap.kt\nfunnymap/FunnyMap\n*L\n68#1:133,2\n*E\n"})
public final class FunnyMap {
   @NotNull
   public static final FunnyMap INSTANCE = new FunnyMap();
   @NotNull
   public static final String MOD_ID = "funnymap";
   @NotNull
   public static final String MOD_NAME = "Funny Map";
   @NotNull
   public static final String MOD_VERSION = "0.7.8";
   @NotNull
   private static final Minecraft mc;
   @Nullable
   private static GuiScreen display;
   @NotNull
   private static final KeyBinding toggleLegitKey;
   @NotNull
   private static final KeyBinding toggleFreeCamKey;
   @NotNull
   private static final CoroutineScope scope;
   @NotNull
   private static ExtrasConfig extras;

   private FunnyMap() {
   }

   @NotNull
   public final String getCHAT_PREFIX() {
      StringBuilder var10000 = (new StringBuilder()).append("§b§l<§f");
      CharSequence var1 = (CharSequence)Config.INSTANCE.getCustomPrefix();
      Object var10001;
      if (StringsKt.isBlank(var1)) {
         StringBuilder var3 = var10000;
         int var2 = false;
         var10001 = "Funny Map";
         var10000 = var3;
      } else {
         var10001 = var1;
      }

      return var10000.append((String)var10001).append("§b§l>§r").toString();
   }

   @NotNull
   public final Minecraft getMc() {
      return mc;
   }

   @Nullable
   public final GuiScreen getDisplay() {
      return display;
   }

   public final void setDisplay(@Nullable GuiScreen <set-?>) {
      display = var1;
   }

   @NotNull
   public final CoroutineScope getScope() {
      return scope;
   }

   @NotNull
   public final ExtrasConfig getExtras() {
      return extras;
   }

   public final void setExtras(@NotNull ExtrasConfig <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      extras = var1;
   }

   @EventHandler
   public final void preInit(@NotNull FMLPreInitializationEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      (new File(event.getModConfigurationDirectory(), "funnymap")).mkdirs();
   }

   @EventHandler
   public final void onInit(@NotNull FMLInitializationEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      ClientCommandHandler.instance.func_71560_a((ICommand)(new FunnyMapCommands()));
      Object[] var2 = new Object[]{this, Dungeon.INSTANCE, EditMode.INSTANCE, FreeCam.INSTANCE, GuiRenderer.INSTANCE, Location.INSTANCE, RunInformation.INSTANCE, WitherDoorESP.INSTANCE};
      Iterable $this$forEach$iv = (Iterable)CollectionsKt.listOf(var2);
      EventBus var10000 = MinecraftForge.EVENT_BUS;
      Intrinsics.checkNotNullExpressionValue(var10000, "EVENT_BUS");
      EventBus var3 = var10000;
      int $i$f$forEach = false;
      Iterator var5 = $this$forEach$iv.iterator();

      while(var5.hasNext()) {
         Object element$iv = var5.next();
         int var8 = false;
         var3.register(element$iv);
      }

      RenderUtils var10 = RenderUtils.INSTANCE;
      ClientRegistry.registerKeyBinding(toggleLegitKey);
      ClientRegistry.registerKeyBinding(toggleFreeCamKey);
   }

   @EventHandler
   @NotNull
   public final Job postInit(@NotNull FMLLoadCompleteEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      return BuildersKt.launch$default(scope, (CoroutineContext)null, (CoroutineStart)null, (Function2)(new Function2<CoroutineScope, Continuation<? super Unit>, Object>((Continuation)null) {
         int label;

         @Nullable
         public final Object invokeSuspend(@NotNull Object $result) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch(this.label) {
            case 0:
               ResultKt.throwOnFailure(var1);
               if (FunnyMap.INSTANCE.getExtras().getEnabled()) {
                  FunnyMap.INSTANCE.getExtras().loadConfig();
                  if (!Config.INSTANCE.getEnableExtras()) {
                     FunnyMap.INSTANCE.getExtras().setEnabled(false);
                  }
               }

               if (UpdateChecker.INSTANCE.hasUpdate() > 0) {
                  Notifications.push$default(EssentialAPI.Companion.getNotifications(), "Funny Map", "New release available on Github. Click to open download link.", 10.0F, (Function0)null.INSTANCE, (Function0)null, (Function1)null, 48, (Object)null);
               }

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
      }), 3, (Object)null);
   }

   @SubscribeEvent
   public final void onTick(@NotNull ClientTickEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      if (event.phase == Phase.START) {
         mc.field_71424_I.func_76320_a("funnymap");
         if (display != null) {
            mc.func_147108_a(display);
            display = null;
         }

         if (Config.INSTANCE.getPeekMode() == 1) {
            MapRender.INSTANCE.setLegitPeek(toggleLegitKey.func_151470_d());
         }

         Dungeon.INSTANCE.onTick();
         GuiRenderer.INSTANCE.onTick();
         Location.INSTANCE.onTick();
         mc.field_71424_I.func_76319_b();
      }
   }

   @SubscribeEvent
   public final void onKey(@NotNull KeyInputEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      if (Config.INSTANCE.getPeekMode() == 0 && toggleLegitKey.func_151468_f()) {
         MapRender.INSTANCE.setLegitPeek(!MapRender.INSTANCE.getLegitPeek());
      }

      if (toggleFreeCamKey.func_151468_f()) {
         FreeCam.INSTANCE.onToggleKey();
      }

   }

   @SubscribeEvent
   public final void onGuiClose(@NotNull GuiOpenEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      if (event.gui == null && mc.field_71462_r instanceof SettingsGui) {
         MapRenderList.INSTANCE.setRenderUpdated(true);
      }

   }

   static {
      Minecraft var10000 = Minecraft.func_71410_x();
      Intrinsics.checkNotNullExpressionValue(var10000, "getMinecraft(...)");
      mc = var10000;
      toggleLegitKey = new KeyBinding("Legit Peek", 0, "Funny Map");
      toggleFreeCamKey = new KeyBinding("Free Cam", 0, "Funny Map");
      scope = CoroutineScopeKt.CoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE);
      FunnyMap var10004 = INSTANCE;
      extras = new ExtrasConfig(new File(mc.field_71412_D, "config/funnymap/extras"));
   }
}
