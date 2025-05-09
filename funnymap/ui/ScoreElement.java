package funnymap.ui;

import funnymap.FunnyMap;
import funnymap.config.Config;
import funnymap.features.dungeon.RunInformation;
import funnymap.features.dungeon.ScoreCalculation;
import funnymap.utils.Location;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import net.minecraft.client.gui.FontRenderer;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u001b\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b*\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R$\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR+\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00118V@VX\u0096\u008e\u0002¢\u0006\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016*\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001a\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\u000fR+\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b8V@VX\u0096\u008e\u0002¢\u0006\u0012\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\r*\u0004\b\u001e\u0010\u0018R\"\u0010 \u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\rR+\u0010&\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b8V@VX\u0096\u008e\u0002¢\u0006\u0012\u001a\u0004\b#\u0010\u000f\"\u0004\b$\u0010\r*\u0004\b%\u0010\u0018R\"\u0010'\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b'\u0010\u000b\u001a\u0004\b(\u0010\u000f\"\u0004\b)\u0010\r¨\u0006,"},
   d2 = {"Lfunnymap/ui/ScoreElement;", "Lfunnymap/ui/MovableGuiElement;", "", "render", "()V", "", "shouldRender", "()Z", "", "value", "elementLines", "I", "setElementLines", "(I)V", "getH", "()I", "h", "", "<set-?>", "getScale", "()F", "setScale", "(F)V", "getScale$delegate", "(Lfunnymap/ui/ScoreElement;)Ljava/lang/Object;", "scale", "w", "getW", "getX", "setX", "getX$delegate", "x", "x2", "getX2", "setX2", "getY", "setY", "getY$delegate", "y", "y2", "getY2", "setY2", "<init>", "Companion", "FunnyMapExtras"}
)
@SourceDebugExtension({"SMAP\nScoreElement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScoreElement.kt\nfunnymap/ui/ScoreElement\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,166:1\n1855#2,2:167\n*S KotlinDebug\n*F\n+ 1 ScoreElement.kt\nfunnymap/ui/ScoreElement\n*L\n32#1:167,2\n*E\n"})
public final class ScoreElement extends MovableGuiElement {
   @NotNull
   public static final ScoreElement.Companion Companion = new ScoreElement.Companion((DefaultConstructorMarker)null);
   private final int w;
   private int x2;
   private int y2;
   private int elementLines;
   @NotNull
   private static final FontRenderer fr;

   public ScoreElement() {
      Config var10000 = Config.INSTANCE;
      var10000 = Config.INSTANCE;
      this.w = fr.func_78256_a("Score: 100/100/100/7 : (300)");
      var10000 = Config.INSTANCE;
      this.x2 = (int)((float)this.getX() + (float)this.getW() * this.getScale());
      this.y2 = (int)((float)this.getY() + (float)this.getH() * this.getScale());
      this.elementLines = 1;
   }

   public int getX() {
      return Config.INSTANCE.getScoreX();
   }

   public void setX(int <set-?>) {
      Config.INSTANCE.setScoreX(var1);
   }

   private static Object getX$delegate(ScoreElement <this>) {
      return Reflection.mutableProperty0((MutablePropertyReference0)(new MutablePropertyReference0Impl(Config.INSTANCE, Config.class, "scoreX", "getScoreX()I", 0)));
   }

   public int getY() {
      return Config.INSTANCE.getScoreY();
   }

   public void setY(int <set-?>) {
      Config.INSTANCE.setScoreY(var1);
   }

   private static Object getY$delegate(ScoreElement <this>) {
      return Reflection.mutableProperty0((MutablePropertyReference0)(new MutablePropertyReference0Impl(Config.INSTANCE, Config.class, "scoreY", "getScoreY()I", 0)));
   }

   public int getH() {
      return fr.field_78288_b * this.elementLines;
   }

   public int getW() {
      return this.w;
   }

   public float getScale() {
      return Config.INSTANCE.getScoreScale();
   }

   public void setScale(float <set-?>) {
      Config.INSTANCE.setScoreScale(var1);
   }

   private static Object getScale$delegate(ScoreElement <this>) {
      return Reflection.mutableProperty0((MutablePropertyReference0)(new MutablePropertyReference0Impl(Config.INSTANCE, Config.class, "scoreScale", "getScoreScale()F", 0)));
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

   private final void setElementLines(int value) {
      if (this.elementLines != value) {
         this.elementLines = value;
         this.setY2((int)((float)this.getY() + (float)this.getH() * this.getScale()));
      }

   }

   public void render() {
      float y = 0.0F;
      List lines = Companion.getScoreLines();
      this.setElementLines(lines.size());
      Iterable $this$forEach$iv = (Iterable)lines;
      int $i$f$forEach = false;

      for(Iterator var5 = $this$forEach$iv.iterator(); var5.hasNext(); y += (float)fr.field_78288_b) {
         Object element$iv = var5.next();
         String it = (String)element$iv;
         int var8 = false;
         fr.func_175065_a(it, 0.0F, y, 16777215, true);
      }

   }

   public boolean shouldRender() {
      if (!Config.INSTANCE.getScoreElementEnabled()) {
         return false;
      } else {
         return Config.INSTANCE.getScoreHideInBoss() && Location.INSTANCE.getInBoss() ? false : super.shouldRender();
      }
   }

   static {
      FontRenderer var10000 = FunnyMap.INSTANCE.getMc().field_71466_p;
      Intrinsics.checkNotNullExpressionValue(var10000, "fontRendererObj");
      fr = var10000;
   }

   @Metadata(
      mv = {1, 9, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006J!\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000bJ\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u000bJ\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0004\b\u0013\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"},
      d2 = {"Lfunnymap/ui/ScoreElement$Companion;", "", "", "minimized", "", "getCrypts", "(Z)Ljava/lang/String;", "getDeaths", "getMimic", "total", "getPuzzles", "(ZZ)Ljava/lang/String;", "expanded", "getScore", "", "getScoreLines", "()Ljava/util/List;", "missing", "getSecrets", "runInformationLines", "Lnet/minecraft/client/gui/FontRenderer;", "fr", "Lnet/minecraft/client/gui/FontRenderer;", "getFr", "()Lnet/minecraft/client/gui/FontRenderer;", "<init>", "()V", "FunnyMapExtras"}
   )
   public static final class Companion {
      private Companion() {
      }

      @NotNull
      public final FontRenderer getFr() {
         return ScoreElement.fr;
      }

      @NotNull
      public final List<String> getScoreLines() {
         List list = (List)(new ArrayList());
         switch(Config.INSTANCE.getScoreTotalScore()) {
         case 1:
            list.add(this.getScore(Config.INSTANCE.getScoreMinimizedName(), false));
            break;
         case 2:
            list.add(this.getScore(Config.INSTANCE.getScoreMinimizedName(), true));
         }

         switch(Config.INSTANCE.getScoreSecrets()) {
         case 1:
            list.add(this.getSecrets(Config.INSTANCE.getScoreMinimizedName(), false));
            break;
         case 2:
            list.add(this.getSecrets(Config.INSTANCE.getScoreMinimizedName(), true));
         }

         if (Config.INSTANCE.getScoreCrypts()) {
            list.add(this.getCrypts(Config.INSTANCE.getScoreMinimizedName()));
         }

         if (Config.INSTANCE.getScoreMimic()) {
            list.add(this.getMimic(Config.INSTANCE.getScoreMinimizedName()));
         }

         if (Config.INSTANCE.getScoreDeaths()) {
            list.add(this.getDeaths(Config.INSTANCE.getScoreMinimizedName()));
         }

         switch(Config.INSTANCE.getScorePuzzles()) {
         case 1:
            list.add(this.getPuzzles(Config.INSTANCE.getScoreMinimizedName(), false));
            break;
         case 2:
            list.add(this.getPuzzles(Config.INSTANCE.getScoreMinimizedName(), true));
         }

         return list;
      }

      @NotNull
      public final List<String> runInformationLines() {
         List list = (List)(new ArrayList());
         if (Config.INSTANCE.getRunInformationScore()) {
            list.add(this.getScore(false, false));
         }

         switch(Config.INSTANCE.getRunInformationSecrets()) {
         case 1:
            list.add(this.getSecrets(false, false));
            break;
         case 2:
            list.add(this.getSecrets(false, true));
         }

         list.add("split");
         if (Config.INSTANCE.getRunInformationCrypts()) {
            list.add(getCrypts$default(this, false, 1, (Object)null));
         }

         if (Config.INSTANCE.getRunInformationMimic()) {
            list.add(getMimic$default(this, false, 1, (Object)null));
         }

         if (Config.INSTANCE.getRunInformationDeaths()) {
            list.add(getDeaths$default(this, false, 1, (Object)null));
         }

         return list;
      }

      private final String getScore(boolean minimized, boolean expanded) {
         String scoreColor = ScoreCalculation.INSTANCE.getScore() < 270 ? "§c" : (ScoreCalculation.INSTANCE.getScore() < 300 ? "§e" : "§a");
         String line = minimized ? "" : "§7Score: ";
         if (expanded) {
            line = line + "§b" + ScoreCalculation.INSTANCE.getSkillScore() + "§7/§a" + ScoreCalculation.INSTANCE.getExplorationScore() + "§7/§3" + ScoreCalculation.INSTANCE.getSpeedScore(RunInformation.INSTANCE.getTimeElapsed()) + "§7/§d" + ScoreCalculation.INSTANCE.getBonusScore() + " §7: ";
         }

         line = line + scoreColor + ScoreCalculation.INSTANCE.getScore();
         return line;
      }

      // $FF: synthetic method
      static String getScore$default(ScoreElement.Companion var0, boolean var1, boolean var2, int var3, Object var4) {
         if ((var3 & 1) != 0) {
            var1 = false;
         }

         return var0.getScore(var1, var2);
      }

      private final String getSecrets(boolean minimized, boolean missing) {
         String line = minimized ? "" : "§7Secrets: ";
         line = line + "§b" + RunInformation.INSTANCE.getSecretsFound() + "§7/";
         if (missing) {
            int missingSecrets = RangesKt.coerceAtLeast(RunInformation.INSTANCE.getMinSecrets() - RunInformation.INSTANCE.getSecretsFound(), 0);
            line = line + "§e" + missingSecrets + "§7/";
         }

         line = line + "§c" + RunInformation.INSTANCE.getSecretTotal();
         return line;
      }

      // $FF: synthetic method
      static String getSecrets$default(ScoreElement.Companion var0, boolean var1, boolean var2, int var3, Object var4) {
         if ((var3 & 1) != 0) {
            var1 = false;
         }

         return var0.getSecrets(var1, var2);
      }

      private final String getCrypts(boolean minimized) {
         String line = minimized ? "§7C: " : "§7Crypts: ";
         line = line + (RunInformation.INSTANCE.getCryptsCount() >= 5 ? "§a" + RunInformation.INSTANCE.getCryptsCount() : "§c" + RunInformation.INSTANCE.getCryptsCount());
         return line;
      }

      // $FF: synthetic method
      static String getCrypts$default(ScoreElement.Companion var0, boolean var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = false;
         }

         return var0.getCrypts(var1);
      }

      private final String getMimic(boolean minimized) {
         String line = minimized ? "§7M: " : "§7Mimic: ";
         line = line + (RunInformation.INSTANCE.getMimicKilled() ? "§a✔" : "§c✘");
         return line;
      }

      // $FF: synthetic method
      static String getMimic$default(ScoreElement.Companion var0, boolean var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = false;
         }

         return var0.getMimic(var1);
      }

      private final String getDeaths(boolean minimized) {
         String line = minimized ? "§7D: " : "§7Deaths: ";
         line = line + "§c" + RunInformation.INSTANCE.getDeathCount();
         return line;
      }

      // $FF: synthetic method
      static String getDeaths$default(ScoreElement.Companion var0, boolean var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = false;
         }

         return var0.getDeaths(var1);
      }

      private final String getPuzzles(boolean minimized, boolean total) {
         String color = RunInformation.INSTANCE.getCompletedPuzzles() == RunInformation.INSTANCE.getTotalPuzzles() ? "§a" : "§c";
         String line = minimized ? "§7P: " : "§7Puzzles: ";
         line = line + color + RunInformation.INSTANCE.getCompletedPuzzles();
         if (total) {
            line = line + "§7/" + color + RunInformation.INSTANCE.getTotalPuzzles();
         }

         return line;
      }

      // $FF: synthetic method
      static String getPuzzles$default(ScoreElement.Companion var0, boolean var1, boolean var2, int var3, Object var4) {
         if ((var3 & 1) != 0) {
            var1 = false;
         }

         return var0.getPuzzles(var1, var2);
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}
