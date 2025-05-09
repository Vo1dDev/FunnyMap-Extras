package funnymap.features.dungeon;

import funnymap.FunnyMap;
import funnymap.config.Config;
import funnymap.ui.GuiRenderer;
import funnymap.utils.APIUtils;
import funnymap.utils.Location;
import funnymap.utils.Utils;
import gg.essential.universal.UChat;
import kotlin.Metadata;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b&\u0010\u0014J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0004J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u0017\u0010\u001f\u001a\u00020\u00158F¢\u0006\f\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010\u0019R\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0004\"\u0004\b$\u0010%¨\u0006'"},
   d2 = {"Lfunnymap/features/dungeon/ScoreCalculation;", "", "", "getBonusScore", "()I", "getDeathDeduction", "getExplorationScore", "", "getSecretPercent", "()F", "getSkillScore", "percentage", "getSpeedDeduction", "(F)F", "timeElapsed", "getSpeedScore", "(I)I", "getTimeLimit", "", "updateScore", "()V", "", "message270", "Z", "getMessage270", "()Z", "setMessage270", "(Z)V", "message300", "getMessage300", "setMessage300", "paul", "getPaul", "score", "I", "getScore", "setScore", "(I)V", "<init>", "FunnyMapExtras"}
)
public final class ScoreCalculation {
   @NotNull
   public static final ScoreCalculation INSTANCE = new ScoreCalculation();
   private static final boolean paul;
   private static int score;
   private static boolean message300;
   private static boolean message270;

   private ScoreCalculation() {
   }

   public final boolean getPaul() {
      return paul || Config.INSTANCE.getPaulBonus();
   }

   public final int getScore() {
      return score;
   }

   public final void setScore(int <set-?>) {
      score = var1;
   }

   public final boolean getMessage300() {
      return message300;
   }

   public final void setMessage300(boolean <set-?>) {
      message300 = var1;
   }

   public final boolean getMessage270() {
      return message270;
   }

   public final void setMessage270(boolean <set-?>) {
      message270 = var1;
   }

   public final void updateScore() {
      score = this.getSkillScore() + this.getExplorationScore() + this.getSpeedScore(RunInformation.INSTANCE.getTimeElapsed()) + this.getBonusScore();
      if (score >= 300 && !message300) {
         message300 = true;
         message270 = true;
         if (Config.INSTANCE.getScoreMessage() != 0) {
            UChat.say("/pc " + Config.INSTANCE.getMessage300());
         }

         if (Config.INSTANCE.getScoreTitle() != 0) {
            FunnyMap.INSTANCE.getMc().field_71439_g.func_85030_a("random.orb", 1.0F, 0.5F);
            GuiRenderer.INSTANCE.displayTitle(Config.INSTANCE.getMessage300(), 40);
         }

         if (Config.INSTANCE.getTimeTo300()) {
            Utils.INSTANCE.modMessage("§3300 Score§7: §a" + Duration.toString-impl(DurationKt.toDuration(RunInformation.INSTANCE.getTimeElapsed(), DurationUnit.SECONDS)));
         }
      } else if (score >= 270 && !message270) {
         message270 = true;
         if (Config.INSTANCE.getScoreMessage() == 2) {
            UChat.say("/pc " + Config.INSTANCE.getMessage270());
         }

         if (Config.INSTANCE.getScoreTitle() == 2) {
            FunnyMap.INSTANCE.getMc().field_71439_g.func_85030_a("random.orb", 1.0F, 0.5F);
            GuiRenderer.INSTANCE.displayTitle(Config.INSTANCE.getMessage270(), 40);
         }
      }

   }

   public final int getSkillScore() {
      int puzzleDeduction = (RunInformation.INSTANCE.getTotalPuzzles() - RunInformation.INSTANCE.getCompletedPuzzles()) * 10;
      float roomPercent = RangesKt.coerceAtMost(RunInformation.INSTANCE.getCompletedRoomsPercentage(), 1.0F);
      return 20 + RangesKt.coerceAtLeast((int)((float)80 * roomPercent) - puzzleDeduction - this.getDeathDeduction(), 0);
   }

   public final int getDeathDeduction() {
      int deathDeduction = RunInformation.INSTANCE.getDeathCount() * 2;
      if (Config.INSTANCE.getScoreAssumeSpirit()) {
         --deathDeduction;
      }

      return RangesKt.coerceAtLeast(deathDeduction, 0);
   }

   public final int getExplorationScore() {
      float secretPercent = RangesKt.coerceAtMost(RunInformation.INSTANCE.getSecretPercentage() / this.getSecretPercent(), 1.0F);
      float roomPercent = RangesKt.coerceAtMost(RunInformation.INSTANCE.getCompletedRoomsPercentage(), 1.0F);
      return (int)((float)60 * roomPercent + (float)40 * secretPercent);
   }

   public final int getSpeedScore(int timeElapsed) {
      int score = 100;
      int limit = this.getTimeLimit();
      if (timeElapsed < limit) {
         return score;
      } else {
         float percentageOver = (float)(timeElapsed - limit) * 100.0F / (float)limit;
         int score = score - (int)this.getSpeedDeduction(percentageOver);
         return Location.INSTANCE.getDungeonFloor() == 0 ? MathKt.roundToInt((double)score * 0.7D) : score;
      }
   }

   public final int getBonusScore() {
      int score = 0;
      int score = score + RangesKt.coerceAtMost(RunInformation.INSTANCE.getCryptsCount(), 5);
      if (RunInformation.INSTANCE.getMimicKilled()) {
         score += 2;
      }

      if (this.getPaul()) {
         score += 10;
      }

      return score;
   }

   public final float getSecretPercent() {
      if (Location.INSTANCE.getMasterMode()) {
         return 1.0F;
      } else {
         float var10000;
         switch(Location.INSTANCE.getDungeonFloor()) {
         case 0:
            var10000 = 0.3F;
            break;
         case 1:
            var10000 = 0.3F;
            break;
         case 2:
            var10000 = 0.4F;
            break;
         case 3:
            var10000 = 0.5F;
            break;
         case 4:
            var10000 = 0.6F;
            break;
         case 5:
            var10000 = 0.7F;
            break;
         case 6:
            var10000 = 0.85F;
            break;
         default:
            var10000 = 1.0F;
         }

         return var10000;
      }
   }

   private final int getTimeLimit() {
      short var10000;
      if (Location.INSTANCE.getMasterMode()) {
         switch(Location.INSTANCE.getDungeonFloor()) {
         case 1:
         case 2:
         case 3:
         case 4:
         case 5:
            var10000 = 480;
            break;
         case 6:
            var10000 = 600;
            break;
         default:
            var10000 = 840;
         }
      } else {
         switch(Location.INSTANCE.getDungeonFloor()) {
         case 0:
            var10000 = 1320;
            break;
         case 1:
         case 2:
         case 3:
         case 5:
            var10000 = 600;
            break;
         case 4:
         case 6:
            var10000 = 720;
            break;
         default:
            var10000 = 840;
         }
      }

      return var10000;
   }

   private final float getSpeedDeduction(float percentage) {
      float deduction = 0.0F;
      deduction += RangesKt.coerceAtMost(percentage, 20.0F) / 2.0F;
      float percentageOver = percentage - 20.0F;
      if (percentageOver <= 0.0F) {
         return deduction;
      } else {
         deduction += RangesKt.coerceAtMost(percentageOver, 20.0F) / 3.5F;
         percentageOver -= 20.0F;
         if (percentageOver <= 0.0F) {
            return deduction;
         } else {
            deduction += RangesKt.coerceAtMost(percentageOver, 10.0F) / 4.0F;
            percentageOver -= 10.0F;
            if (percentageOver <= 0.0F) {
               return deduction;
            } else {
               deduction += RangesKt.coerceAtMost(percentageOver, 10.0F) / 5.0F;
               percentageOver -= 10.0F;
               if (percentageOver <= 0.0F) {
                  return deduction;
               } else {
                  deduction += percentageOver / 6.0F;
                  return deduction;
               }
            }
         }
      }
   }

   static {
      paul = APIUtils.INSTANCE.hasBonusPaulScore();
   }
}
