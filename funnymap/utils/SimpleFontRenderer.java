package funnymap.utils;

import funnymap.FunnyMap;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b/\u0010\u001aJ5\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001c\u0010\u0011J\u0017\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ7\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001f\u0010\rJ\u0017\u0010 \u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010-¨\u00060"},
   d2 = {"Lfunnymap/utils/SimpleFontRenderer;", "Lnet/minecraft/client/resources/IResourceManagerReloadListener;", "", "text", "", "x", "y", "Ljava/awt/Color;", "color", "", "dropShadow", "", "drawString", "(Ljava/lang/String;FFLjava/awt/Color;Z)I", "", "character", "getCharWidth", "(C)I", "getStringWidth", "(Ljava/lang/String;)I", "Lnet/minecraft/client/resources/IResourceManager;", "resourceManager", "", "onResourceManagerReload", "(Lnet/minecraft/client/resources/IResourceManager;)V", "readFontTexture", "()V", "ch", "renderChar", "renderDefaultChar", "(I)I", "renderString", "renderStringAtPos", "(Ljava/lang/String;)V", "FONT_HEIGHT", "I", "VALID_CHARS", "Ljava/lang/String;", "", "charWidth", "[I", "Lnet/minecraft/util/ResourceLocation;", "locationFontTexture", "Lnet/minecraft/util/ResourceLocation;", "posX", "F", "posY", "<init>", "FunnyMapExtras"}
)
@SourceDebugExtension({"SMAP\nSimpleFontRenderer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SimpleFontRenderer.kt\nfunnymap/utils/SimpleFontRenderer\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,156:1\n1174#2,2:157\n1#3:159\n*S KotlinDebug\n*F\n+ 1 SimpleFontRenderer.kt\nfunnymap/utils/SimpleFontRenderer\n*L\n121#1:157,2\n*E\n"})
public final class SimpleFontRenderer implements IResourceManagerReloadListener {
   @NotNull
   public static final SimpleFontRenderer INSTANCE = new SimpleFontRenderer();
   @NotNull
   private static final ResourceLocation locationFontTexture = new ResourceLocation("textures/font/ascii.png");
   @NotNull
   private static int[] charWidth = new int[256];
   private static float posX;
   private static float posY;
   public static final int FONT_HEIGHT = 9;
   @NotNull
   private static final String VALID_CHARS = "ÀÁÂÈÊËÍÓÔÕÚßãõğİıŒœŞşŴŵžȇ\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000ÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜø£Ø×ƒáíóúñÑªº¿®¬½¼¡«»░▒▓│┤╡╢╖╕╣║╗╝╜╛┐└┴┬├─┼╞╟╚╔╩╦╠═╬╧╨╤╥╙╘╒╓╫╪┘┌█▄▌▐▀αβΓπΣσμτΦΘΩδ∞∅∈∩≡±≥≤⌠⌡÷≈°∙·√ⁿ²■\u0000";

   private SimpleFontRenderer() {
   }

   public void func_110549_a(@NotNull IResourceManager resourceManager) {
      Intrinsics.checkNotNullParameter(resourceManager, "resourceManager");
      this.readFontTexture();
   }

   private final void readFontTexture() {
      BufferedImage var2;
      try {
         var2 = TextureUtil.func_177053_a(FunnyMap.INSTANCE.getMc().func_110442_L().func_110536_a(locationFontTexture).func_110527_b());
         Intrinsics.checkNotNull(var2);
         var2 = var2;
      } catch (IOException var16) {
         throw new RuntimeException((Throwable)var16);
      }

      int w = var2.getWidth();
      int h = var2.getHeight();
      int[] arr = new int[w * h];
      var2.getRGB(0, 0, w, h, arr, 0, w);
      int charHeight = h / 16;
      int charWidth = w / 16;
      float scale = 8.0F / (float)charWidth;

      label52:
      for(int charIndex = 0; charIndex < 256; ++charIndex) {
         if (charIndex == 32) {
            SimpleFontRenderer.charWidth[charIndex] = 4;
         }

         int column = charIndex % 16;
         int row = charIndex / 16;

         for(int scanX = charWidth - 1; -1 < scanX; --scanX) {
            int x = column * charWidth + scanX;
            boolean found = false;

            for(int scanY = 0; scanY < charHeight; ++scanY) {
               int y = row * charHeight + scanY;
               if ((arr[x + y * w] >> 24 & 255) != 0) {
                  found = true;
                  break;
               }
            }

            if (found) {
               SimpleFontRenderer.charWidth[charIndex] = (int)(0.5D + (double)((float)(scanX + 1) * scale)) + 1;
               continue label52;
            }
         }

         SimpleFontRenderer.charWidth[charIndex] = (int)(0.5D + (double)scale) + 1;
      }

      if (FunnyMap.INSTANCE.getMc().func_110434_K().func_110581_b(locationFontTexture) == null) {
         FunnyMap.INSTANCE.getMc().func_110434_K().func_110579_a(locationFontTexture, (ITextureObject)(new SimpleTexture(locationFontTexture)));
      }

   }

   private final int renderChar(char ch) {
      if (ch == ' ') {
         return 4;
      } else {
         int i = StringsKt.indexOf$default((CharSequence)"ÀÁÂÈÊËÍÓÔÕÚßãõğİıŒœŞşŴŵžȇ\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000ÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜø£Ø×ƒáíóúñÑªº¿®¬½¼¡«»░▒▓│┤╡╢╖╕╣║╗╝╜╛┐└┴┬├─┼╞╟╚╔╩╦╠═╬╧╨╤╥╙╘╒╓╫╪┘┌█▄▌▐▀αβΓπΣσμτΦΘΩδ∞∅∈∩≡±≥≤⌠⌡÷≈°∙·√ⁿ²■\u0000", ch, 0, false, 6, (Object)null);
         return i != -1 ? this.renderDefaultChar(i) : 0;
      }
   }

   private final int renderDefaultChar(int ch) {
      float texX = (float)(ch % 16 * 8) / 128.0F;
      float texY = (float)(ch / 16 * 8) / 128.0F;
      float width = (float)charWidth[ch] - 1.01F;
      float height = 7.99F;
      float texWidth = width / 128.0F;
      float texHeight = height / 128.0F;
      GL11.glBegin(5);
      GL11.glTexCoord2f(texX, texY);
      GL11.glVertex3f(posX, posY, 0.0F);
      GL11.glTexCoord2f(texX, texY + texHeight);
      GL11.glVertex3f(posX, posY + height, 0.0F);
      GL11.glTexCoord2f(texX + texWidth, texY);
      GL11.glVertex3f(posX + width, posY, 0.0F);
      GL11.glTexCoord2f(texX + texWidth, texY + texHeight);
      GL11.glVertex3f(posX + width, posY + height, 0.0F);
      GL11.glEnd();
      return charWidth[ch];
   }

   public final int drawString(@NotNull String text, float x, float y, @NotNull Color color, boolean dropShadow) {
      Intrinsics.checkNotNullParameter(text, "text");
      Intrinsics.checkNotNullParameter(color, "color");
      int i = false;
      GL11.glEnable(3008);
      GL11.glEnable(3553);
      RenderUtilsGL.INSTANCE.bind(locationFontTexture);
      int i;
      if (dropShadow) {
         i = this.renderString(text, x + 1.0F, y + 1.0F, color, true);
         i = Math.max(i, this.renderString(text, x, y, color, false));
      } else {
         i = this.renderString(text, x, y, color, false);
      }

      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      return i;
   }

   private final void renderStringAtPos(String text) {
      CharSequence $this$forEach$iv = (CharSequence)text;
      int $i$f$forEach = false;

      for(int var4 = 0; var4 < $this$forEach$iv.length(); ++var4) {
         char element$iv = $this$forEach$iv.charAt(var4);
         int var7 = false;
         SimpleFontRenderer var10000 = INSTANCE;
         posX += (float)INSTANCE.renderChar(element$iv);
      }

   }

   private final int renderString(String text, float x, float y, Color color, boolean dropShadow) {
      if (dropShadow) {
         GL11.glColor4f((float)color.getRed() * 0.25F / 255.0F, (float)color.getGreen() * 0.25F / 255.0F, (float)color.getBlue() * 0.25F / 255.0F, (float)color.getAlpha() / 255.0F);
      } else {
         GL11.glColor4f((float)color.getRed() / 255.0F, (float)color.getGreen() / 255.0F, (float)color.getBlue() / 255.0F, (float)color.getAlpha() / 255.0F);
      }

      posX = x;
      posY = y;
      this.renderStringAtPos(text);
      return (int)posX;
   }

   public final int getStringWidth(@NotNull String text) {
      Intrinsics.checkNotNullParameter(text, "text");
      CharSequence var2 = (CharSequence)text;
      int var3 = 0;

      for(int var4 = 0; var4 < var2.length(); ++var4) {
         char var5 = var2.charAt(var4);
         int var7 = false;
         int var9 = INSTANCE.getCharWidth(var5);
         var3 += var9;
      }

      return var3;
   }

   public final int getCharWidth(char character) {
      if (character == ' ') {
         return 4;
      } else {
         int i = StringsKt.indexOf$default((CharSequence)"ÀÁÂÈÊËÍÓÔÕÚßãõğİıŒœŞşŴŵžȇ\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000ÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜø£Ø×ƒáíóúñÑªº¿®¬½¼¡«»░▒▓│┤╡╢╖╕╣║╗╝╜╛┐└┴┬├─┼╞╟╚╔╩╦╠═╬╧╨╤╥╙╘╒╓╫╪┘┌█▄▌▐▀αβΓπΣσμτΦΘΩδ∞∅∈∩≡±≥≤⌠⌡÷≈°∙·√ⁿ²■\u0000", character, 0, false, 6, (Object)null);
         return Intrinsics.compare(character, 0) > 0 && i != -1 ? charWidth[i] : 0;
      }
   }

   static {
      INSTANCE.readFontTexture();
   }
}
