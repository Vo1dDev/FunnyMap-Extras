package funnymap.config;

import funnymap.FunnyMap;
import funnymap.ui.EditLocationGui;
import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Category;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyCollector;
import gg.essential.vigilance.data.PropertyData;
import gg.essential.vigilance.data.PropertyType;
import gg.essential.vigilance.data.SortingBehavior;
import java.awt.Color;
import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.GuiScreen;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b?\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0003\bØ\u0001\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002¸\u0002B\n\b\u0002¢\u0006\u0005\b·\u0002\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0004R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\"\u0010\u0017\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\"\u0010\u001a\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\"\u0010\u001d\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\"\u0010 \u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u000f\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\"\u0010#\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u000f\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\"\u0010&\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u000f\u001a\u0004\b'\u0010\u0011\"\u0004\b(\u0010\u0013R\"\u0010)\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u000f\u001a\u0004\b*\u0010\u0011\"\u0004\b+\u0010\u0013R\"\u0010,\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u000f\u001a\u0004\b-\u0010\u0011\"\u0004\b.\u0010\u0013R\"\u0010/\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u000f\u001a\u0004\b0\u0010\u0011\"\u0004\b1\u0010\u0013R\"\u00102\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u000f\u001a\u0004\b3\u0010\u0011\"\u0004\b4\u0010\u0013R\"\u00105\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u000f\u001a\u0004\b6\u0010\u0011\"\u0004\b7\u0010\u0013R\"\u00108\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010\u000f\u001a\u0004\b9\u0010\u0011\"\u0004\b:\u0010\u0013R\"\u0010;\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010\u000f\u001a\u0004\b<\u0010\u0011\"\u0004\b=\u0010\u0013R\"\u0010>\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010\u000f\u001a\u0004\b?\u0010\u0011\"\u0004\b@\u0010\u0013R\"\u0010A\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u0010\u000f\u001a\u0004\bB\u0010\u0011\"\u0004\bC\u0010\u0013R\"\u0010D\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010\u000f\u001a\u0004\bE\u0010\u0011\"\u0004\bF\u0010\u0013R\"\u0010G\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bG\u0010\u000f\u001a\u0004\bH\u0010\u0011\"\u0004\bI\u0010\u0013R\"\u0010J\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bJ\u0010\u000f\u001a\u0004\bK\u0010\u0011\"\u0004\bL\u0010\u0013R\"\u0010N\u001a\u00020M8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010T\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bT\u0010\b\u001a\u0004\bU\u0010\n\"\u0004\bV\u0010\fR\"\u0010W\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bW\u0010\b\u001a\u0004\bX\u0010\n\"\u0004\bY\u0010\fR\"\u0010[\u001a\u00020Z8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\"\u0010b\u001a\u00020a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\"\u0010h\u001a\u00020a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bh\u0010c\u001a\u0004\bi\u0010e\"\u0004\bj\u0010gR\"\u0010k\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bk\u0010\b\u001a\u0004\bl\u0010\n\"\u0004\bm\u0010\fR\"\u0010n\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bn\u0010\b\u001a\u0004\bo\u0010\n\"\u0004\bp\u0010\fR\"\u0010q\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bq\u0010\b\u001a\u0004\br\u0010\n\"\u0004\bs\u0010\fR\"\u0010t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bt\u0010\b\u001a\u0004\bu\u0010\n\"\u0004\bv\u0010\fR\"\u0010w\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bw\u0010\b\u001a\u0004\bx\u0010\n\"\u0004\by\u0010\fR\"\u0010z\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bz\u0010\u000f\u001a\u0004\b{\u0010\u0011\"\u0004\b|\u0010\u0013R\"\u0010}\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b}\u0010\u000f\u001a\u0004\b~\u0010\u0011\"\u0004\b\u007f\u0010\u0013R&\u0010\u0080\u0001\u001a\u00020Z8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0080\u0001\u0010\\\u001a\u0005\b\u0081\u0001\u0010^\"\u0005\b\u0082\u0001\u0010`R&\u0010\u0083\u0001\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0083\u0001\u0010\b\u001a\u0005\b\u0084\u0001\u0010\n\"\u0005\b\u0085\u0001\u0010\fR&\u0010\u0086\u0001\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0086\u0001\u0010\b\u001a\u0005\b\u0087\u0001\u0010\n\"\u0005\b\u0088\u0001\u0010\fR&\u0010\u0089\u0001\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0089\u0001\u0010\b\u001a\u0005\b\u008a\u0001\u0010\n\"\u0005\b\u008b\u0001\u0010\fR&\u0010\u008c\u0001\u001a\u00020a8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008c\u0001\u0010c\u001a\u0005\b\u008d\u0001\u0010e\"\u0005\b\u008e\u0001\u0010gR&\u0010\u008f\u0001\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008f\u0001\u0010\b\u001a\u0005\b\u0090\u0001\u0010\n\"\u0005\b\u0091\u0001\u0010\fR&\u0010\u0092\u0001\u001a\u00020Z8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0092\u0001\u0010\\\u001a\u0005\b\u0093\u0001\u0010^\"\u0005\b\u0094\u0001\u0010`R&\u0010\u0095\u0001\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0095\u0001\u0010\b\u001a\u0005\b\u0096\u0001\u0010\n\"\u0005\b\u0097\u0001\u0010\fR&\u0010\u0098\u0001\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0098\u0001\u0010\b\u001a\u0005\b\u0099\u0001\u0010\n\"\u0005\b\u009a\u0001\u0010\fR&\u0010\u009b\u0001\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u009b\u0001\u0010\b\u001a\u0005\b\u009c\u0001\u0010\n\"\u0005\b\u009d\u0001\u0010\fR&\u0010\u009e\u0001\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u009e\u0001\u0010\b\u001a\u0005\b\u009f\u0001\u0010\n\"\u0005\b \u0001\u0010\fR&\u0010¡\u0001\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¡\u0001\u0010\b\u001a\u0005\b¢\u0001\u0010\n\"\u0005\b£\u0001\u0010\fR&\u0010¤\u0001\u001a\u00020a8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¤\u0001\u0010c\u001a\u0005\b¥\u0001\u0010e\"\u0005\b¦\u0001\u0010gR&\u0010§\u0001\u001a\u00020a8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b§\u0001\u0010c\u001a\u0005\b¨\u0001\u0010e\"\u0005\b©\u0001\u0010gR&\u0010ª\u0001\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bª\u0001\u0010\b\u001a\u0005\b«\u0001\u0010\n\"\u0005\b¬\u0001\u0010\fR&\u0010\u00ad\u0001\u001a\u00020Z8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u00ad\u0001\u0010\\\u001a\u0005\b®\u0001\u0010^\"\u0005\b¯\u0001\u0010`R&\u0010°\u0001\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b°\u0001\u0010\b\u001a\u0005\b±\u0001\u0010\n\"\u0005\b²\u0001\u0010\fR&\u0010³\u0001\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b³\u0001\u0010\b\u001a\u0005\b´\u0001\u0010\n\"\u0005\bµ\u0001\u0010\fR&\u0010¶\u0001\u001a\u00020a8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¶\u0001\u0010c\u001a\u0005\b·\u0001\u0010e\"\u0005\b¸\u0001\u0010gR&\u0010¹\u0001\u001a\u00020a8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¹\u0001\u0010c\u001a\u0005\bº\u0001\u0010e\"\u0005\b»\u0001\u0010gR&\u0010¼\u0001\u001a\u00020M8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¼\u0001\u0010O\u001a\u0005\b½\u0001\u0010Q\"\u0005\b¾\u0001\u0010SR&\u0010¿\u0001\u001a\u00020M8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¿\u0001\u0010O\u001a\u0005\bÀ\u0001\u0010Q\"\u0005\bÁ\u0001\u0010SR&\u0010Â\u0001\u001a\u00020M8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÂ\u0001\u0010O\u001a\u0005\bÃ\u0001\u0010Q\"\u0005\bÄ\u0001\u0010SR&\u0010Å\u0001\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÅ\u0001\u0010\b\u001a\u0005\bÆ\u0001\u0010\n\"\u0005\bÇ\u0001\u0010\fR&\u0010È\u0001\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÈ\u0001\u0010\b\u001a\u0005\bÉ\u0001\u0010\n\"\u0005\bÊ\u0001\u0010\fR&\u0010Ë\u0001\u001a\u00020a8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bË\u0001\u0010c\u001a\u0005\bÌ\u0001\u0010e\"\u0005\bÍ\u0001\u0010gR&\u0010Î\u0001\u001a\u00020Z8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÎ\u0001\u0010\\\u001a\u0005\bÏ\u0001\u0010^\"\u0005\bÐ\u0001\u0010`R&\u0010Ñ\u0001\u001a\u00020a8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÑ\u0001\u0010c\u001a\u0005\bÒ\u0001\u0010e\"\u0005\bÓ\u0001\u0010gR&\u0010Ô\u0001\u001a\u00020Z8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÔ\u0001\u0010\\\u001a\u0005\bÕ\u0001\u0010^\"\u0005\bÖ\u0001\u0010`R&\u0010×\u0001\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b×\u0001\u0010\b\u001a\u0005\bØ\u0001\u0010\n\"\u0005\bÙ\u0001\u0010\fR&\u0010Ú\u0001\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÚ\u0001\u0010\b\u001a\u0005\bÛ\u0001\u0010\n\"\u0005\bÜ\u0001\u0010\fR&\u0010Ý\u0001\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÝ\u0001\u0010\b\u001a\u0005\bÞ\u0001\u0010\n\"\u0005\bß\u0001\u0010\fR&\u0010à\u0001\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bà\u0001\u0010\b\u001a\u0005\bá\u0001\u0010\n\"\u0005\bâ\u0001\u0010\fR&\u0010ã\u0001\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bã\u0001\u0010\b\u001a\u0005\bä\u0001\u0010\n\"\u0005\bå\u0001\u0010\fR&\u0010æ\u0001\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bæ\u0001\u0010\b\u001a\u0005\bç\u0001\u0010\n\"\u0005\bè\u0001\u0010\fR&\u0010é\u0001\u001a\u00020a8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bé\u0001\u0010c\u001a\u0005\bê\u0001\u0010e\"\u0005\bë\u0001\u0010gR&\u0010ì\u0001\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bì\u0001\u0010\b\u001a\u0005\bí\u0001\u0010\n\"\u0005\bî\u0001\u0010\fR&\u0010ï\u0001\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bï\u0001\u0010\b\u001a\u0005\bð\u0001\u0010\n\"\u0005\bñ\u0001\u0010\fR&\u0010ò\u0001\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bò\u0001\u0010\b\u001a\u0005\bó\u0001\u0010\n\"\u0005\bô\u0001\u0010\fR&\u0010õ\u0001\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bõ\u0001\u0010\b\u001a\u0005\bö\u0001\u0010\n\"\u0005\b÷\u0001\u0010\fR&\u0010ø\u0001\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bø\u0001\u0010\b\u001a\u0005\bù\u0001\u0010\n\"\u0005\bú\u0001\u0010\fR&\u0010û\u0001\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bû\u0001\u0010\b\u001a\u0005\bü\u0001\u0010\n\"\u0005\bý\u0001\u0010\fR&\u0010þ\u0001\u001a\u00020a8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bþ\u0001\u0010c\u001a\u0005\bÿ\u0001\u0010e\"\u0005\b\u0080\u0002\u0010gR&\u0010\u0081\u0002\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0081\u0002\u0010\b\u001a\u0005\b\u0082\u0002\u0010\n\"\u0005\b\u0083\u0002\u0010\fR&\u0010\u0084\u0002\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0084\u0002\u0010\b\u001a\u0005\b\u0085\u0002\u0010\n\"\u0005\b\u0086\u0002\u0010\fR&\u0010\u0087\u0002\u001a\u00020a8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0087\u0002\u0010c\u001a\u0005\b\u0088\u0002\u0010e\"\u0005\b\u0089\u0002\u0010gR&\u0010\u008a\u0002\u001a\u00020Z8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008a\u0002\u0010\\\u001a\u0005\b\u008b\u0002\u0010^\"\u0005\b\u008c\u0002\u0010`R&\u0010\u008d\u0002\u001a\u00020a8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008d\u0002\u0010c\u001a\u0005\b\u008e\u0002\u0010e\"\u0005\b\u008f\u0002\u0010gR&\u0010\u0090\u0002\u001a\u00020a8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0090\u0002\u0010c\u001a\u0005\b\u0091\u0002\u0010e\"\u0005\b\u0092\u0002\u0010gR&\u0010\u0093\u0002\u001a\u00020a8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0093\u0002\u0010c\u001a\u0005\b\u0094\u0002\u0010e\"\u0005\b\u0095\u0002\u0010gR&\u0010\u0096\u0002\u001a\u00020a8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0096\u0002\u0010c\u001a\u0005\b\u0097\u0002\u0010e\"\u0005\b\u0098\u0002\u0010gR&\u0010\u0099\u0002\u001a\u00020a8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0099\u0002\u0010c\u001a\u0005\b\u009a\u0002\u0010e\"\u0005\b\u009b\u0002\u0010gR&\u0010\u009c\u0002\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u009c\u0002\u0010\b\u001a\u0005\b\u009d\u0002\u0010\n\"\u0005\b\u009e\u0002\u0010\fR&\u0010\u009f\u0002\u001a\u00020Z8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u009f\u0002\u0010\\\u001a\u0005\b \u0002\u0010^\"\u0005\b¡\u0002\u0010`R&\u0010¢\u0002\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¢\u0002\u0010\b\u001a\u0005\b£\u0002\u0010\n\"\u0005\b¤\u0002\u0010\fR&\u0010¥\u0002\u001a\u00020a8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¥\u0002\u0010c\u001a\u0005\b¦\u0002\u0010e\"\u0005\b§\u0002\u0010gR&\u0010¨\u0002\u001a\u00020Z8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¨\u0002\u0010\\\u001a\u0005\b©\u0002\u0010^\"\u0005\bª\u0002\u0010`R&\u0010«\u0002\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b«\u0002\u0010\u000f\u001a\u0005\b¬\u0002\u0010\u0011\"\u0005\b\u00ad\u0002\u0010\u0013R&\u0010®\u0002\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b®\u0002\u0010\u000f\u001a\u0005\b¯\u0002\u0010\u0011\"\u0005\b°\u0002\u0010\u0013R&\u0010±\u0002\u001a\u00020Z8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b±\u0002\u0010\\\u001a\u0005\b²\u0002\u0010^\"\u0005\b³\u0002\u0010`R&\u0010´\u0002\u001a\u00020Z8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b´\u0002\u0010\\\u001a\u0005\bµ\u0002\u0010^\"\u0005\b¶\u0002\u0010`¨\u0006¹\u0002"},
   d2 = {"Lfunnymap/config/Config;", "Lgg/essential/vigilance/Vigilant;", "", "openMoveMapGui", "()V", "resetMapLocation", "", "autoScan", "Z", "getAutoScan", "()Z", "setAutoScan", "(Z)V", "Ljava/awt/Color;", "colorBlood", "Ljava/awt/Color;", "getColorBlood", "()Ljava/awt/Color;", "setColorBlood", "(Ljava/awt/Color;)V", "colorBloodDoor", "getColorBloodDoor", "setColorBloodDoor", "colorEntrance", "getColorEntrance", "setColorEntrance", "colorEntranceDoor", "getColorEntranceDoor", "setColorEntranceDoor", "colorFairy", "getColorFairy", "setColorFairy", "colorMiniboss", "getColorMiniboss", "setColorMiniboss", "colorOpenWitherDoor", "getColorOpenWitherDoor", "setColorOpenWitherDoor", "colorPuzzle", "getColorPuzzle", "setColorPuzzle", "colorRare", "getColorRare", "setColorRare", "colorRoom", "getColorRoom", "setColorRoom", "colorRoomDoor", "getColorRoomDoor", "setColorRoomDoor", "colorRoomMimic", "getColorRoomMimic", "setColorRoomMimic", "colorTextCleared", "getColorTextCleared", "setColorTextCleared", "colorTextFailed", "getColorTextFailed", "setColorTextFailed", "colorTextGreen", "getColorTextGreen", "setColorTextGreen", "colorTextUncleared", "getColorTextUncleared", "setColorTextUncleared", "colorTrap", "getColorTrap", "setColorTrap", "colorUnopened", "getColorUnopened", "setColorUnopened", "colorUnopenedDoor", "getColorUnopenedDoor", "setColorUnopenedDoor", "colorWitherDoor", "getColorWitherDoor", "setColorWitherDoor", "", "customPrefix", "Ljava/lang/String;", "getCustomPrefix", "()Ljava/lang/String;", "setCustomPrefix", "(Ljava/lang/String;)V", "editElementEnabled", "getEditElementEnabled", "setEditElementEnabled", "editHideNotEdit", "getEditHideNotEdit", "setEditHideNotEdit", "", "editScale", "F", "getEditScale", "()F", "setEditScale", "(F)V", "", "editX", "I", "getEditX", "()I", "setEditX", "(I)V", "editY", "getEditY", "setEditY", "enableExtras", "getEnableExtras", "setEnableExtras", "enableGlobalExtras", "getEnableGlobalExtras", "setEnableGlobalExtras", "forceSkyblock", "getForceSkyblock", "setForceSkyblock", "freeCamSpectatorMovement", "getFreeCamSpectatorMovement", "setFreeCamSpectatorMovement", "legitMode", "getLegitMode", "setLegitMode", "mapBackground", "getMapBackground", "setMapBackground", "mapBorder", "getMapBorder", "setMapBorder", "mapBorderWidth", "getMapBorderWidth", "setMapBorderWidth", "mapCenter", "getMapCenter", "setMapCenter", "mapCenterCheckmark", "getMapCenterCheckmark", "setMapCenterCheckmark", "mapCenterRoomName", "getMapCenterRoomName", "setMapCenterRoomName", "mapCheckmark", "getMapCheckmark", "setMapCheckmark", "mapColorText", "getMapColorText", "setMapColorText", "mapDarkenPercent", "getMapDarkenPercent", "setMapDarkenPercent", "mapDarkenUndiscovered", "getMapDarkenUndiscovered", "setMapDarkenUndiscovered", "mapDynamicRotate", "getMapDynamicRotate", "setMapDynamicRotate", "mapEnabled", "getMapEnabled", "setMapEnabled", "mapGrayUndiscovered", "getMapGrayUndiscovered", "setMapGrayUndiscovered", "mapHideInBoss", "getMapHideInBoss", "setMapHideInBoss", "mapRoomNames", "getMapRoomNames", "setMapRoomNames", "mapRoomSecrets", "getMapRoomSecrets", "setMapRoomSecrets", "mapRotate", "getMapRotate", "setMapRotate", "mapScale", "getMapScale", "setMapScale", "mapShowRunInformation", "getMapShowRunInformation", "setMapShowRunInformation", "mapVanillaMarker", "getMapVanillaMarker", "setMapVanillaMarker", "mapX", "getMapX", "setMapX", "mapY", "getMapY", "setMapY", "message270", "getMessage270", "setMessage270", "message300", "getMessage300", "setMessage300", "mimicMessage", "getMimicMessage", "setMimicMessage", "mimicMessageEnabled", "getMimicMessageEnabled", "setMimicMessageEnabled", "paulBonus", "getPaulBonus", "setPaulBonus", "peekMode", "getPeekMode", "setPeekMode", "playerHeadScale", "getPlayerHeadScale", "setPlayerHeadScale", "playerHeads", "getPlayerHeads", "setPlayerHeads", "playerNameScale", "getPlayerNameScale", "setPlayerNameScale", "preventBlockReset", "getPreventBlockReset", "setPreventBlockReset", "renderBeta", "getRenderBeta", "setRenderBeta", "runInformationCrypts", "getRunInformationCrypts", "setRunInformationCrypts", "runInformationDeaths", "getRunInformationDeaths", "setRunInformationDeaths", "runInformationMimic", "getRunInformationMimic", "setRunInformationMimic", "runInformationScore", "getRunInformationScore", "setRunInformationScore", "runInformationSecrets", "getRunInformationSecrets", "setRunInformationSecrets", "scanChatInfo", "getScanChatInfo", "setScanChatInfo", "scoreAssumeSpirit", "getScoreAssumeSpirit", "setScoreAssumeSpirit", "scoreCrypts", "getScoreCrypts", "setScoreCrypts", "scoreDeaths", "getScoreDeaths", "setScoreDeaths", "scoreElementEnabled", "getScoreElementEnabled", "setScoreElementEnabled", "scoreHideInBoss", "getScoreHideInBoss", "setScoreHideInBoss", "scoreMessage", "getScoreMessage", "setScoreMessage", "scoreMimic", "getScoreMimic", "setScoreMimic", "scoreMinimizedName", "getScoreMinimizedName", "setScoreMinimizedName", "scorePuzzles", "getScorePuzzles", "setScorePuzzles", "scoreScale", "getScoreScale", "setScoreScale", "scoreSecrets", "getScoreSecrets", "setScoreSecrets", "scoreTitle", "getScoreTitle", "setScoreTitle", "scoreTotalScore", "getScoreTotalScore", "setScoreTotalScore", "scoreX", "getScoreX", "setScoreX", "scoreY", "getScoreY", "setScoreY", "teamInfo", "getTeamInfo", "setTeamInfo", "textScale", "getTextScale", "setTextScale", "timeTo300", "getTimeTo300", "setTimeTo300", "witherDoorESP", "getWitherDoorESP", "setWitherDoorESP", "witherDoorFill", "getWitherDoorFill", "setWitherDoorFill", "witherDoorKeyColor", "getWitherDoorKeyColor", "setWitherDoorKeyColor", "witherDoorNoKeyColor", "getWitherDoorNoKeyColor", "setWitherDoorNoKeyColor", "witherDoorOutline", "getWitherDoorOutline", "setWitherDoorOutline", "witherDoorOutlineWidth", "getWitherDoorOutlineWidth", "setWitherDoorOutlineWidth", "<init>", "CategorySorting", "FunnyMapExtras"}
)
public final class Config extends Vigilant {
   @NotNull
   public static final Config INSTANCE = new Config();
   @Property(
      type = PropertyType.SWITCH,
      name = "Auto Scan",
      category = "General",
      subcategory = "Scanning",
      description = "Automatically scans when entering dungeon. Manual scan can be done with /fmap scan."
   )
   private static boolean autoScan = true;
   @Property(
      type = PropertyType.SWITCH,
      name = "Chat Info",
      category = "General",
      subcategory = "Scanning",
      description = "Show dungeon overview information after scanning."
   )
   private static boolean scanChatInfo = true;
   @Property(
      type = PropertyType.SWITCH,
      name = "Legit Mode",
      category = "General",
      subcategory = "Legit Mode",
      description = "Hides unopened rooms. Still uses scanning to identify all rooms."
   )
   private static boolean legitMode;
   @Property(
      type = PropertyType.SELECTOR,
      name = "Peek Mode",
      category = "General",
      subcategory = "Legit Mode",
      description = "Shows cheater map while in legit mode.",
      options = {"Toggle", "Hold"}
   )
   private static int peekMode;
   @Property(
      type = PropertyType.SWITCH,
      name = "Enable Extras",
      category = "General",
      subcategory = "Extras",
      description = "Enables custom blocks."
   )
   private static boolean enableExtras = true;
   @Property(
      type = PropertyType.SWITCH,
      name = "Global Extras",
      category = "General",
      subcategory = "Extras",
      description = "Enables custom blocks for out of dungeons."
   )
   private static boolean enableGlobalExtras;
   @Property(
      type = PropertyType.SWITCH,
      name = "Prevent Block Reset",
      category = "General",
      subcategory = "Extras",
      description = "Prevents clicking on custom blocks changing them to air."
   )
   private static boolean preventBlockReset = true;
   @Property(
      type = PropertyType.SWITCH,
      name = "Map Enabled",
      category = "Map",
      subcategory = "Toggle",
      description = "Render the map!"
   )
   private static boolean mapEnabled = true;
   @Property(
      type = PropertyType.SWITCH,
      name = "Rotate Map",
      category = "Map",
      subcategory = "Toggle",
      description = "Rotates map to follow the player."
   )
   private static boolean mapRotate;
   @Property(
      type = PropertyType.SWITCH,
      name = "Center Map",
      category = "Map",
      subcategory = "Toggle",
      description = "Centers the map on the player if Rotate Map is enabled."
   )
   private static boolean mapCenter;
   @Property(
      type = PropertyType.SWITCH,
      name = "Dynamic Rotate",
      category = "Map",
      subcategory = "Toggle",
      description = "Keeps the entrance room at the bottom. Does not work with rotate map."
   )
   private static boolean mapDynamicRotate;
   @Property(
      type = PropertyType.SWITCH,
      name = "Hide In Boss",
      category = "Map",
      subcategory = "Toggle",
      description = "Hides the map in boss."
   )
   private static boolean mapHideInBoss;
   @Property(
      type = PropertyType.SELECTOR,
      name = "Show Player Names",
      category = "Map",
      subcategory = "Toggle",
      description = "Show player name under player head",
      options = {"Off", "Holding Leap", "Always"}
   )
   private static int playerHeads;
   @Property(
      type = PropertyType.SWITCH,
      name = "Vanilla Head Marker",
      category = "Map",
      subcategory = "Toggle",
      description = "Uses the vanilla head marker for yourself."
   )
   private static boolean mapVanillaMarker;
   @Property(
      type = PropertyType.NUMBER,
      name = "Map X",
      category = "Map",
      subcategory = "Size",
      hidden = true
   )
   private static int mapX = 10;
   @Property(
      type = PropertyType.NUMBER,
      name = "Map Y",
      category = "Map",
      subcategory = "Size",
      hidden = true
   )
   private static int mapY = 10;
   @Property(
      type = PropertyType.DECIMAL_SLIDER,
      name = "Map Size",
      category = "Map",
      subcategory = "Size",
      minF = 0.1F,
      maxF = 4.0F,
      decimalPlaces = 2,
      hidden = true
   )
   private static float mapScale = 1.25F;
   @Property(
      type = PropertyType.DECIMAL_SLIDER,
      name = "Map Text Scale",
      category = "Map",
      subcategory = "Size",
      description = "Scale of room names and secret counts relative to map size.",
      maxF = 2.0F,
      decimalPlaces = 2
   )
   private static float textScale = 0.75F;
   @Property(
      type = PropertyType.DECIMAL_SLIDER,
      name = "Player Heads Scale",
      category = "Map",
      subcategory = "Size",
      description = "Scale of player heads relative to map size.",
      maxF = 2.0F,
      decimalPlaces = 2
   )
   private static float playerHeadScale = 1.0F;
   @Property(
      type = PropertyType.DECIMAL_SLIDER,
      name = "Player Name Scale",
      category = "Map",
      subcategory = "Size",
      description = "Scale of player names relative to head size.",
      maxF = 2.0F,
      decimalPlaces = 2
   )
   private static float playerNameScale = 0.8F;
   @Property(
      type = PropertyType.COLOR,
      name = "Map Background Color",
      category = "Map",
      subcategory = "Render",
      allowAlpha = true
   )
   @NotNull
   private static Color mapBackground = new Color(0, 0, 0, 100);
   @Property(
      type = PropertyType.COLOR,
      name = "Map Border Color",
      category = "Map",
      subcategory = "Render",
      allowAlpha = true
   )
   @NotNull
   private static Color mapBorder = new Color(0, 0, 0, 255);
   @Property(
      type = PropertyType.DECIMAL_SLIDER,
      name = "Border Thickness",
      category = "Map",
      subcategory = "Render",
      maxF = 10.0F
   )
   private static float mapBorderWidth = 3.0F;
   @Property(
      type = PropertyType.SWITCH,
      name = "Dark Undiscovered Rooms",
      category = "Rooms",
      subcategory = "Render",
      description = "Darkens unentered rooms."
   )
   private static boolean mapDarkenUndiscovered = true;
   @Property(
      type = PropertyType.PERCENT_SLIDER,
      name = "Darken Multiplier",
      category = "Rooms",
      subcategory = "Render",
      description = "How much to darken undiscovered rooms."
   )
   private static float mapDarkenPercent = 0.4F;
   @Property(
      type = PropertyType.SWITCH,
      name = "Gray Undiscovered Rooms",
      category = "Rooms",
      subcategory = "Render",
      description = "Grayscale unentered rooms."
   )
   private static boolean mapGrayUndiscovered;
   @Property(
      type = PropertyType.SELECTOR,
      name = "Room Names",
      category = "Rooms",
      subcategory = "Text",
      description = "Shows names of rooms on map.",
      options = {"None", "Puzzles / Trap", "All"}
   )
   private static int mapRoomNames = 2;
   @Property(
      type = PropertyType.SELECTOR,
      name = "Room Secrets",
      category = "Rooms",
      subcategory = "Text",
      description = "Shows total secrets of rooms on map.",
      options = {"Off", "On", "Replace Checkmark"}
   )
   private static int mapRoomSecrets;
   @Property(
      type = PropertyType.SWITCH,
      name = "Center Room Names",
      category = "Rooms",
      subcategory = "Text",
      description = "Center room names."
   )
   private static boolean mapCenterRoomName = true;
   @Property(
      type = PropertyType.SWITCH,
      name = "Color Text",
      category = "Rooms",
      subcategory = "Text",
      description = "Colors name and secret count based on room state."
   )
   private static boolean mapColorText;
   @Property(
      type = PropertyType.SELECTOR,
      name = "Room Checkmarks",
      category = "Rooms",
      subcategory = "Checkmarks",
      description = "Adds room checkmarks based on room state.",
      options = {"None", "Default", "NEU", "Legacy"}
   )
   private static int mapCheckmark = 1;
   @Property(
      type = PropertyType.SWITCH,
      name = "Center Room Checkmarks",
      category = "Rooms",
      subcategory = "Checkmarks",
      description = "Center room checkmarks."
   )
   private static boolean mapCenterCheckmark = true;
   @Property(
      type = PropertyType.COLOR,
      name = "Blood Door",
      category = "Colors",
      subcategory = "Doors",
      allowAlpha = true
   )
   @NotNull
   private static Color colorBloodDoor = new Color(231, 0, 0);
   @Property(
      type = PropertyType.COLOR,
      name = "Entrance Door",
      category = "Colors",
      subcategory = "Doors",
      allowAlpha = true
   )
   @NotNull
   private static Color colorEntranceDoor = new Color(20, 133, 0);
   @Property(
      type = PropertyType.COLOR,
      name = "Normal Door",
      category = "Colors",
      subcategory = "Doors",
      allowAlpha = true
   )
   @NotNull
   private static Color colorRoomDoor = new Color(92, 52, 14);
   @Property(
      type = PropertyType.COLOR,
      name = "Wither Door",
      category = "Colors",
      subcategory = "Doors",
      allowAlpha = true
   )
   @NotNull
   private static Color colorWitherDoor = new Color(0, 0, 0);
   @Property(
      type = PropertyType.COLOR,
      name = "Opened Wither Door",
      category = "Colors",
      subcategory = "Doors",
      allowAlpha = true
   )
   @NotNull
   private static Color colorOpenWitherDoor = new Color(92, 52, 14);
   @Property(
      type = PropertyType.COLOR,
      name = "Unopened Door",
      category = "Colors",
      subcategory = "Doors",
      allowAlpha = true
   )
   @NotNull
   private static Color colorUnopenedDoor = new Color(65, 65, 65);
   @Property(
      type = PropertyType.COLOR,
      name = "Blood Room",
      category = "Colors",
      subcategory = "Rooms",
      allowAlpha = true
   )
   @NotNull
   private static Color colorBlood = new Color(255, 0, 0);
   @Property(
      type = PropertyType.COLOR,
      name = "Entrance Room",
      category = "Colors",
      subcategory = "Rooms",
      allowAlpha = true
   )
   @NotNull
   private static Color colorEntrance = new Color(20, 133, 0);
   @Property(
      type = PropertyType.COLOR,
      name = "Fairy Room",
      category = "Colors",
      subcategory = "Rooms",
      allowAlpha = true
   )
   @NotNull
   private static Color colorFairy = new Color(224, 0, 255);
   @Property(
      type = PropertyType.COLOR,
      name = "Miniboss Room",
      category = "Colors",
      subcategory = "Rooms",
      allowAlpha = true
   )
   @NotNull
   private static Color colorMiniboss = new Color(254, 223, 0);
   @Property(
      type = PropertyType.COLOR,
      name = "Normal Room",
      category = "Colors",
      subcategory = "Rooms",
      allowAlpha = true
   )
   @NotNull
   private static Color colorRoom = new Color(107, 58, 17);
   @Property(
      type = PropertyType.COLOR,
      name = "Mimic Room",
      category = "Colors",
      subcategory = "Rooms",
      allowAlpha = true
   )
   @NotNull
   private static Color colorRoomMimic = new Color(186, 66, 52);
   @Property(
      type = PropertyType.COLOR,
      name = "Puzzle Room",
      category = "Colors",
      subcategory = "Rooms",
      allowAlpha = true
   )
   @NotNull
   private static Color colorPuzzle = new Color(117, 0, 133);
   @Property(
      type = PropertyType.COLOR,
      name = "Rare Room",
      category = "Colors",
      subcategory = "Rooms",
      allowAlpha = true
   )
   @NotNull
   private static Color colorRare = new Color(255, 203, 89);
   @Property(
      type = PropertyType.COLOR,
      name = "Trap Room",
      category = "Colors",
      subcategory = "Rooms",
      allowAlpha = true
   )
   @NotNull
   private static Color colorTrap = new Color(216, 127, 51);
   @Property(
      type = PropertyType.COLOR,
      name = "Unopened Room",
      category = "Colors",
      subcategory = "Rooms",
      allowAlpha = true
   )
   @NotNull
   private static Color colorUnopened = new Color(65, 65, 65);
   @Property(
      type = PropertyType.COLOR,
      name = "Cleared Room Text",
      category = "Colors",
      subcategory = "Text",
      allowAlpha = true
   )
   @NotNull
   private static Color colorTextCleared = new Color(255, 255, 255);
   @Property(
      type = PropertyType.COLOR,
      name = "Uncleared Room Text",
      category = "Colors",
      subcategory = "Text",
      allowAlpha = true
   )
   @NotNull
   private static Color colorTextUncleared = new Color(170, 170, 170);
   @Property(
      type = PropertyType.COLOR,
      name = "Green Room Text",
      category = "Colors",
      subcategory = "Text",
      allowAlpha = true
   )
   @NotNull
   private static Color colorTextGreen = new Color(85, 255, 85);
   @Property(
      type = PropertyType.COLOR,
      name = "Failed Room Text",
      category = "Colors",
      subcategory = "Text",
      allowAlpha = true
   )
   @NotNull
   private static Color colorTextFailed = new Color(255, 255, 255);
   @Property(
      type = PropertyType.SWITCH,
      name = "Show Score",
      category = "Score",
      subcategory = "Toggle",
      description = "Shows separate score element."
   )
   private static boolean scoreElementEnabled;
   @Property(
      type = PropertyType.SWITCH,
      name = "Assume Spirit",
      category = "Score",
      subcategory = "Toggle",
      description = "Assume everyone has a legendary spirit pet."
   )
   private static boolean scoreAssumeSpirit = true;
   @Property(
      type = PropertyType.SWITCH,
      name = "Minimized Text",
      category = "Score",
      subcategory = "Toggle",
      description = "Shortens description for score elements."
   )
   private static boolean scoreMinimizedName;
   @Property(
      type = PropertyType.SWITCH,
      name = "Hide in Boss",
      category = "Score",
      subcategory = "Toggle"
   )
   private static boolean scoreHideInBoss;
   @Property(
      type = PropertyType.NUMBER,
      name = "Score Calc X",
      category = "Score",
      subcategory = "Size",
      hidden = true
   )
   private static int scoreX = 10;
   @Property(
      type = PropertyType.NUMBER,
      name = "Score Calc Y",
      category = "Score",
      subcategory = "Size",
      hidden = true
   )
   private static int scoreY = 10;
   @Property(
      type = PropertyType.DECIMAL_SLIDER,
      name = "Score Calc Size",
      category = "Score",
      subcategory = "Size",
      minF = 0.1F,
      maxF = 4.0F,
      decimalPlaces = 2,
      hidden = true
   )
   private static float scoreScale = 1.0F;
   @Property(
      type = PropertyType.SELECTOR,
      name = "Score",
      category = "Score",
      subcategory = "Elements",
      options = {"Off", "On", "Separate"}
   )
   private static int scoreTotalScore = 2;
   @Property(
      type = PropertyType.SELECTOR,
      name = "Secrets",
      category = "Score",
      subcategory = "Elements",
      options = {"Off", "Total", "Total and Missing"}
   )
   private static int scoreSecrets = 1;
   @Property(
      type = PropertyType.SWITCH,
      name = "Crypts",
      category = "Score",
      subcategory = "Elements"
   )
   private static boolean scoreCrypts;
   @Property(
      type = PropertyType.SWITCH,
      name = "Mimic",
      category = "Score",
      subcategory = "Elements"
   )
   private static boolean scoreMimic;
   @Property(
      type = PropertyType.SWITCH,
      name = "Deaths",
      category = "Score",
      subcategory = "Elements"
   )
   private static boolean scoreDeaths;
   @Property(
      type = PropertyType.SELECTOR,
      name = "Puzzles",
      category = "Score",
      subcategory = "Elements",
      options = {"Off", "Total", "Completed and Total"}
   )
   private static int scorePuzzles;
   @Property(
      type = PropertyType.SELECTOR,
      name = "Score Messages",
      category = "Score",
      subcategory = "Message",
      options = {"Off", "300", "270 and 300"}
   )
   private static int scoreMessage;
   @Property(
      type = PropertyType.SELECTOR,
      name = "Score Title",
      category = "Score",
      subcategory = "Message",
      description = "Shows score messages as a title notification.",
      options = {"Off", "300", "270 and 300"}
   )
   private static int scoreTitle;
   @Property(
      type = PropertyType.TEXT,
      name = "270 Message",
      category = "Score",
      subcategory = "Message"
   )
   @NotNull
   private static String message270 = "270 Score";
   @Property(
      type = PropertyType.TEXT,
      name = "300 Message",
      category = "Score",
      subcategory = "Message"
   )
   @NotNull
   private static String message300 = "300 Score";
   @Property(
      type = PropertyType.SWITCH,
      name = "300 Time",
      category = "Score",
      subcategory = "Message",
      description = "Shows time to reach 300 score."
   )
   private static boolean timeTo300;
   @Property(
      type = PropertyType.SWITCH,
      name = "Show Run Information",
      category = "Run Information",
      subcategory = "Toggle",
      description = "Shows run information under map."
   )
   private static boolean mapShowRunInformation = true;
   @Property(
      type = PropertyType.SWITCH,
      name = "Score",
      category = "Run Information",
      subcategory = "Elements"
   )
   private static boolean runInformationScore = true;
   @Property(
      type = PropertyType.SELECTOR,
      name = "Secrets",
      category = "Run Information",
      subcategory = "Elements",
      options = {"Off", "Total", "Total and Missing"}
   )
   private static int runInformationSecrets = 1;
   @Property(
      type = PropertyType.SWITCH,
      name = "Crypts",
      category = "Run Information",
      subcategory = "Elements"
   )
   private static boolean runInformationCrypts = true;
   @Property(
      type = PropertyType.SWITCH,
      name = "Mimic",
      category = "Run Information",
      subcategory = "Elements"
   )
   private static boolean runInformationMimic = true;
   @Property(
      type = PropertyType.SWITCH,
      name = "Deaths",
      category = "Run Information",
      subcategory = "Elements"
   )
   private static boolean runInformationDeaths = true;
   @Property(
      type = PropertyType.SWITCH,
      name = "Show Team Info",
      category = "Other Features",
      description = "Shows team member secrets and room times at end of run."
   )
   private static boolean teamInfo;
   @Property(
      type = PropertyType.SWITCH,
      name = "Mimic Message",
      category = "Other Features",
      subcategory = "Mimic Message",
      description = "Sends party message when a mimic is killed. Detects most instant kills."
   )
   private static boolean mimicMessageEnabled;
   @Property(
      type = PropertyType.TEXT,
      name = "Mimic Message Text",
      category = "Other Features",
      subcategory = "Mimic Message"
   )
   @NotNull
   private static String mimicMessage = "Mimic Killed!";
   @Property(
      type = PropertyType.SELECTOR,
      name = "Wither Door ESP",
      category = "Other Features",
      subcategory = "Wither Door",
      description = "Boxes unopened wither doors.",
      options = {"Off", "First", "All"}
   )
   private static int witherDoorESP;
   @Property(
      type = PropertyType.COLOR,
      name = "No Key Color",
      category = "Other Features",
      subcategory = "Wither Door",
      allowAlpha = true
   )
   @NotNull
   private static Color witherDoorNoKeyColor = new Color(255, 0, 0);
   @Property(
      type = PropertyType.COLOR,
      name = "Has Key Color",
      category = "Other Features",
      subcategory = "Wither Door",
      allowAlpha = true
   )
   @NotNull
   private static Color witherDoorKeyColor = new Color(0, 255, 0);
   @Property(
      type = PropertyType.DECIMAL_SLIDER,
      name = "Door Outline Width",
      category = "Other Features",
      subcategory = "Wither Door",
      minF = 1.0F,
      maxF = 10.0F
   )
   private static float witherDoorOutlineWidth = 3.0F;
   @Property(
      type = PropertyType.PERCENT_SLIDER,
      name = "Door Outline Opacity",
      category = "Other Features",
      subcategory = "Wither Door"
   )
   private static float witherDoorOutline = 1.0F;
   @Property(
      type = PropertyType.PERCENT_SLIDER,
      name = "Door Fill Opacity",
      category = "Other Features",
      subcategory = "Wither Door"
   )
   private static float witherDoorFill = 0.25F;
   @Property(
      type = PropertyType.SWITCH,
      name = "Show Edit Mode Display",
      category = "Other Features",
      subcategory = "Edit Mode",
      description = "HUD element that shows current room and block."
   )
   private static boolean editElementEnabled;
   @Property(
      type = PropertyType.SWITCH,
      name = "Only Show in Edit",
      category = "Other Features",
      subcategory = "Edit Mode"
   )
   private static boolean editHideNotEdit = true;
   @Property(
      type = PropertyType.NUMBER,
      name = "Score Calc X",
      category = "Other Features",
      subcategory = "Edit Mode",
      hidden = true
   )
   private static int editX = 10;
   @Property(
      type = PropertyType.NUMBER,
      name = "Score Calc Y",
      category = "Other Features",
      subcategory = "Edit Mode",
      hidden = true
   )
   private static int editY = 10;
   @Property(
      type = PropertyType.DECIMAL_SLIDER,
      name = "Score Calc Size",
      category = "Other Features",
      subcategory = "Edit Mode",
      minF = 0.1F,
      maxF = 4.0F,
      decimalPlaces = 2,
      hidden = true
   )
   private static float editScale = 1.0F;
   @Property(
      type = PropertyType.SWITCH,
      name = "Spectator Movement",
      category = "Other Features",
      subcategory = "Free Cam",
      description = "Moving forward and backward in free cam mode changes y level."
   )
   private static boolean freeCamSpectatorMovement;
   @Property(
      type = PropertyType.SWITCH,
      name = "Force Skyblock",
      category = "Debug",
      description = "Disables in skyblock and dungeon checks. Don't enable unless you know what you're doing."
   )
   private static boolean forceSkyblock;
   @Property(
      type = PropertyType.SWITCH,
      name = "Paul Score",
      category = "Debug",
      description = "Assumes paul perk is active to give 10 bonus score."
   )
   private static boolean paulBonus;
   @Property(
      type = PropertyType.SWITCH,
      name = "Beta Rendering",
      category = "Debug"
   )
   private static boolean renderBeta = true;
   @Property(
      type = PropertyType.TEXT,
      name = "Custom Prefix",
      category = "Other Features",
      hidden = true
   )
   @NotNull
   private static String customPrefix = "";

   private Config() {
      super(new File("./config/funnymap/config.toml"), "Funny Map", (PropertyCollector)null, (SortingBehavior)Config.CategorySorting.INSTANCE, 4, (DefaultConstructorMarker)null);
   }

   public final boolean getAutoScan() {
      return autoScan;
   }

   public final void setAutoScan(boolean <set-?>) {
      autoScan = var1;
   }

   public final boolean getScanChatInfo() {
      return scanChatInfo;
   }

   public final void setScanChatInfo(boolean <set-?>) {
      scanChatInfo = var1;
   }

   @Property(
      type = PropertyType.BUTTON,
      name = "Map Position",
      category = "General",
      subcategory = "Size",
      placeholder = "Edit"
   )
   public final void openMoveMapGui() {
      FunnyMap.INSTANCE.setDisplay((GuiScreen)(new EditLocationGui()));
   }

   @Property(
      type = PropertyType.BUTTON,
      name = "Reset Map Position",
      category = "General",
      subcategory = "Size",
      placeholder = "Reset"
   )
   public final void resetMapLocation() {
      mapX = 10;
      mapY = 10;
   }

   public final boolean getLegitMode() {
      return legitMode;
   }

   public final void setLegitMode(boolean <set-?>) {
      legitMode = var1;
   }

   public final int getPeekMode() {
      return peekMode;
   }

   public final void setPeekMode(int <set-?>) {
      peekMode = var1;
   }

   public final boolean getEnableExtras() {
      return enableExtras;
   }

   public final void setEnableExtras(boolean <set-?>) {
      enableExtras = var1;
   }

   public final boolean getEnableGlobalExtras() {
      return enableGlobalExtras;
   }

   public final void setEnableGlobalExtras(boolean <set-?>) {
      enableGlobalExtras = var1;
   }

   public final boolean getPreventBlockReset() {
      return preventBlockReset;
   }

   public final void setPreventBlockReset(boolean <set-?>) {
      preventBlockReset = var1;
   }

   public final boolean getMapEnabled() {
      return mapEnabled;
   }

   public final void setMapEnabled(boolean <set-?>) {
      mapEnabled = var1;
   }

   public final boolean getMapRotate() {
      return mapRotate;
   }

   public final void setMapRotate(boolean <set-?>) {
      mapRotate = var1;
   }

   public final boolean getMapCenter() {
      return mapCenter;
   }

   public final void setMapCenter(boolean <set-?>) {
      mapCenter = var1;
   }

   public final boolean getMapDynamicRotate() {
      return mapDynamicRotate;
   }

   public final void setMapDynamicRotate(boolean <set-?>) {
      mapDynamicRotate = var1;
   }

   public final boolean getMapHideInBoss() {
      return mapHideInBoss;
   }

   public final void setMapHideInBoss(boolean <set-?>) {
      mapHideInBoss = var1;
   }

   public final int getPlayerHeads() {
      return playerHeads;
   }

   public final void setPlayerHeads(int <set-?>) {
      playerHeads = var1;
   }

   public final boolean getMapVanillaMarker() {
      return mapVanillaMarker;
   }

   public final void setMapVanillaMarker(boolean <set-?>) {
      mapVanillaMarker = var1;
   }

   public final int getMapX() {
      return mapX;
   }

   public final void setMapX(int <set-?>) {
      mapX = var1;
   }

   public final int getMapY() {
      return mapY;
   }

   public final void setMapY(int <set-?>) {
      mapY = var1;
   }

   public final float getMapScale() {
      return mapScale;
   }

   public final void setMapScale(float <set-?>) {
      mapScale = var1;
   }

   public final float getTextScale() {
      return textScale;
   }

   public final void setTextScale(float <set-?>) {
      textScale = var1;
   }

   public final float getPlayerHeadScale() {
      return playerHeadScale;
   }

   public final void setPlayerHeadScale(float <set-?>) {
      playerHeadScale = var1;
   }

   public final float getPlayerNameScale() {
      return playerNameScale;
   }

   public final void setPlayerNameScale(float <set-?>) {
      playerNameScale = var1;
   }

   @NotNull
   public final Color getMapBackground() {
      return mapBackground;
   }

   public final void setMapBackground(@NotNull Color <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      mapBackground = var1;
   }

   @NotNull
   public final Color getMapBorder() {
      return mapBorder;
   }

   public final void setMapBorder(@NotNull Color <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      mapBorder = var1;
   }

   public final float getMapBorderWidth() {
      return mapBorderWidth;
   }

   public final void setMapBorderWidth(float <set-?>) {
      mapBorderWidth = var1;
   }

   public final boolean getMapDarkenUndiscovered() {
      return mapDarkenUndiscovered;
   }

   public final void setMapDarkenUndiscovered(boolean <set-?>) {
      mapDarkenUndiscovered = var1;
   }

   public final float getMapDarkenPercent() {
      return mapDarkenPercent;
   }

   public final void setMapDarkenPercent(float <set-?>) {
      mapDarkenPercent = var1;
   }

   public final boolean getMapGrayUndiscovered() {
      return mapGrayUndiscovered;
   }

   public final void setMapGrayUndiscovered(boolean <set-?>) {
      mapGrayUndiscovered = var1;
   }

   public final int getMapRoomNames() {
      return mapRoomNames;
   }

   public final void setMapRoomNames(int <set-?>) {
      mapRoomNames = var1;
   }

   public final int getMapRoomSecrets() {
      return mapRoomSecrets;
   }

   public final void setMapRoomSecrets(int <set-?>) {
      mapRoomSecrets = var1;
   }

   public final boolean getMapCenterRoomName() {
      return mapCenterRoomName;
   }

   public final void setMapCenterRoomName(boolean <set-?>) {
      mapCenterRoomName = var1;
   }

   public final boolean getMapColorText() {
      return mapColorText;
   }

   public final void setMapColorText(boolean <set-?>) {
      mapColorText = var1;
   }

   public final int getMapCheckmark() {
      return mapCheckmark;
   }

   public final void setMapCheckmark(int <set-?>) {
      mapCheckmark = var1;
   }

   public final boolean getMapCenterCheckmark() {
      return mapCenterCheckmark;
   }

   public final void setMapCenterCheckmark(boolean <set-?>) {
      mapCenterCheckmark = var1;
   }

   @NotNull
   public final Color getColorBloodDoor() {
      return colorBloodDoor;
   }

   public final void setColorBloodDoor(@NotNull Color <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      colorBloodDoor = var1;
   }

   @NotNull
   public final Color getColorEntranceDoor() {
      return colorEntranceDoor;
   }

   public final void setColorEntranceDoor(@NotNull Color <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      colorEntranceDoor = var1;
   }

   @NotNull
   public final Color getColorRoomDoor() {
      return colorRoomDoor;
   }

   public final void setColorRoomDoor(@NotNull Color <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      colorRoomDoor = var1;
   }

   @NotNull
   public final Color getColorWitherDoor() {
      return colorWitherDoor;
   }

   public final void setColorWitherDoor(@NotNull Color <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      colorWitherDoor = var1;
   }

   @NotNull
   public final Color getColorOpenWitherDoor() {
      return colorOpenWitherDoor;
   }

   public final void setColorOpenWitherDoor(@NotNull Color <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      colorOpenWitherDoor = var1;
   }

   @NotNull
   public final Color getColorUnopenedDoor() {
      return colorUnopenedDoor;
   }

   public final void setColorUnopenedDoor(@NotNull Color <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      colorUnopenedDoor = var1;
   }

   @NotNull
   public final Color getColorBlood() {
      return colorBlood;
   }

   public final void setColorBlood(@NotNull Color <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      colorBlood = var1;
   }

   @NotNull
   public final Color getColorEntrance() {
      return colorEntrance;
   }

   public final void setColorEntrance(@NotNull Color <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      colorEntrance = var1;
   }

   @NotNull
   public final Color getColorFairy() {
      return colorFairy;
   }

   public final void setColorFairy(@NotNull Color <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      colorFairy = var1;
   }

   @NotNull
   public final Color getColorMiniboss() {
      return colorMiniboss;
   }

   public final void setColorMiniboss(@NotNull Color <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      colorMiniboss = var1;
   }

   @NotNull
   public final Color getColorRoom() {
      return colorRoom;
   }

   public final void setColorRoom(@NotNull Color <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      colorRoom = var1;
   }

   @NotNull
   public final Color getColorRoomMimic() {
      return colorRoomMimic;
   }

   public final void setColorRoomMimic(@NotNull Color <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      colorRoomMimic = var1;
   }

   @NotNull
   public final Color getColorPuzzle() {
      return colorPuzzle;
   }

   public final void setColorPuzzle(@NotNull Color <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      colorPuzzle = var1;
   }

   @NotNull
   public final Color getColorRare() {
      return colorRare;
   }

   public final void setColorRare(@NotNull Color <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      colorRare = var1;
   }

   @NotNull
   public final Color getColorTrap() {
      return colorTrap;
   }

   public final void setColorTrap(@NotNull Color <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      colorTrap = var1;
   }

   @NotNull
   public final Color getColorUnopened() {
      return colorUnopened;
   }

   public final void setColorUnopened(@NotNull Color <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      colorUnopened = var1;
   }

   @NotNull
   public final Color getColorTextCleared() {
      return colorTextCleared;
   }

   public final void setColorTextCleared(@NotNull Color <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      colorTextCleared = var1;
   }

   @NotNull
   public final Color getColorTextUncleared() {
      return colorTextUncleared;
   }

   public final void setColorTextUncleared(@NotNull Color <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      colorTextUncleared = var1;
   }

   @NotNull
   public final Color getColorTextGreen() {
      return colorTextGreen;
   }

   public final void setColorTextGreen(@NotNull Color <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      colorTextGreen = var1;
   }

   @NotNull
   public final Color getColorTextFailed() {
      return colorTextFailed;
   }

   public final void setColorTextFailed(@NotNull Color <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      colorTextFailed = var1;
   }

   public final boolean getScoreElementEnabled() {
      return scoreElementEnabled;
   }

   public final void setScoreElementEnabled(boolean <set-?>) {
      scoreElementEnabled = var1;
   }

   public final boolean getScoreAssumeSpirit() {
      return scoreAssumeSpirit;
   }

   public final void setScoreAssumeSpirit(boolean <set-?>) {
      scoreAssumeSpirit = var1;
   }

   public final boolean getScoreMinimizedName() {
      return scoreMinimizedName;
   }

   public final void setScoreMinimizedName(boolean <set-?>) {
      scoreMinimizedName = var1;
   }

   public final boolean getScoreHideInBoss() {
      return scoreHideInBoss;
   }

   public final void setScoreHideInBoss(boolean <set-?>) {
      scoreHideInBoss = var1;
   }

   public final int getScoreX() {
      return scoreX;
   }

   public final void setScoreX(int <set-?>) {
      scoreX = var1;
   }

   public final int getScoreY() {
      return scoreY;
   }

   public final void setScoreY(int <set-?>) {
      scoreY = var1;
   }

   public final float getScoreScale() {
      return scoreScale;
   }

   public final void setScoreScale(float <set-?>) {
      scoreScale = var1;
   }

   public final int getScoreTotalScore() {
      return scoreTotalScore;
   }

   public final void setScoreTotalScore(int <set-?>) {
      scoreTotalScore = var1;
   }

   public final int getScoreSecrets() {
      return scoreSecrets;
   }

   public final void setScoreSecrets(int <set-?>) {
      scoreSecrets = var1;
   }

   public final boolean getScoreCrypts() {
      return scoreCrypts;
   }

   public final void setScoreCrypts(boolean <set-?>) {
      scoreCrypts = var1;
   }

   public final boolean getScoreMimic() {
      return scoreMimic;
   }

   public final void setScoreMimic(boolean <set-?>) {
      scoreMimic = var1;
   }

   public final boolean getScoreDeaths() {
      return scoreDeaths;
   }

   public final void setScoreDeaths(boolean <set-?>) {
      scoreDeaths = var1;
   }

   public final int getScorePuzzles() {
      return scorePuzzles;
   }

   public final void setScorePuzzles(int <set-?>) {
      scorePuzzles = var1;
   }

   public final int getScoreMessage() {
      return scoreMessage;
   }

   public final void setScoreMessage(int <set-?>) {
      scoreMessage = var1;
   }

   public final int getScoreTitle() {
      return scoreTitle;
   }

   public final void setScoreTitle(int <set-?>) {
      scoreTitle = var1;
   }

   @NotNull
   public final String getMessage270() {
      return message270;
   }

   public final void setMessage270(@NotNull String <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      message270 = var1;
   }

   @NotNull
   public final String getMessage300() {
      return message300;
   }

   public final void setMessage300(@NotNull String <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      message300 = var1;
   }

   public final boolean getTimeTo300() {
      return timeTo300;
   }

   public final void setTimeTo300(boolean <set-?>) {
      timeTo300 = var1;
   }

   public final boolean getMapShowRunInformation() {
      return mapShowRunInformation;
   }

   public final void setMapShowRunInformation(boolean <set-?>) {
      mapShowRunInformation = var1;
   }

   public final boolean getRunInformationScore() {
      return runInformationScore;
   }

   public final void setRunInformationScore(boolean <set-?>) {
      runInformationScore = var1;
   }

   public final int getRunInformationSecrets() {
      return runInformationSecrets;
   }

   public final void setRunInformationSecrets(int <set-?>) {
      runInformationSecrets = var1;
   }

   public final boolean getRunInformationCrypts() {
      return runInformationCrypts;
   }

   public final void setRunInformationCrypts(boolean <set-?>) {
      runInformationCrypts = var1;
   }

   public final boolean getRunInformationMimic() {
      return runInformationMimic;
   }

   public final void setRunInformationMimic(boolean <set-?>) {
      runInformationMimic = var1;
   }

   public final boolean getRunInformationDeaths() {
      return runInformationDeaths;
   }

   public final void setRunInformationDeaths(boolean <set-?>) {
      runInformationDeaths = var1;
   }

   public final boolean getTeamInfo() {
      return teamInfo;
   }

   public final void setTeamInfo(boolean <set-?>) {
      teamInfo = var1;
   }

   public final boolean getMimicMessageEnabled() {
      return mimicMessageEnabled;
   }

   public final void setMimicMessageEnabled(boolean <set-?>) {
      mimicMessageEnabled = var1;
   }

   @NotNull
   public final String getMimicMessage() {
      return mimicMessage;
   }

   public final void setMimicMessage(@NotNull String <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      mimicMessage = var1;
   }

   public final int getWitherDoorESP() {
      return witherDoorESP;
   }

   public final void setWitherDoorESP(int <set-?>) {
      witherDoorESP = var1;
   }

   @NotNull
   public final Color getWitherDoorNoKeyColor() {
      return witherDoorNoKeyColor;
   }

   public final void setWitherDoorNoKeyColor(@NotNull Color <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      witherDoorNoKeyColor = var1;
   }

   @NotNull
   public final Color getWitherDoorKeyColor() {
      return witherDoorKeyColor;
   }

   public final void setWitherDoorKeyColor(@NotNull Color <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      witherDoorKeyColor = var1;
   }

   public final float getWitherDoorOutlineWidth() {
      return witherDoorOutlineWidth;
   }

   public final void setWitherDoorOutlineWidth(float <set-?>) {
      witherDoorOutlineWidth = var1;
   }

   public final float getWitherDoorOutline() {
      return witherDoorOutline;
   }

   public final void setWitherDoorOutline(float <set-?>) {
      witherDoorOutline = var1;
   }

   public final float getWitherDoorFill() {
      return witherDoorFill;
   }

   public final void setWitherDoorFill(float <set-?>) {
      witherDoorFill = var1;
   }

   public final boolean getEditElementEnabled() {
      return editElementEnabled;
   }

   public final void setEditElementEnabled(boolean <set-?>) {
      editElementEnabled = var1;
   }

   public final boolean getEditHideNotEdit() {
      return editHideNotEdit;
   }

   public final void setEditHideNotEdit(boolean <set-?>) {
      editHideNotEdit = var1;
   }

   public final int getEditX() {
      return editX;
   }

   public final void setEditX(int <set-?>) {
      editX = var1;
   }

   public final int getEditY() {
      return editY;
   }

   public final void setEditY(int <set-?>) {
      editY = var1;
   }

   public final float getEditScale() {
      return editScale;
   }

   public final void setEditScale(float <set-?>) {
      editScale = var1;
   }

   public final boolean getFreeCamSpectatorMovement() {
      return freeCamSpectatorMovement;
   }

   public final void setFreeCamSpectatorMovement(boolean <set-?>) {
      freeCamSpectatorMovement = var1;
   }

   public final boolean getForceSkyblock() {
      return forceSkyblock;
   }

   public final void setForceSkyblock(boolean <set-?>) {
      forceSkyblock = var1;
   }

   public final boolean getPaulBonus() {
      return paulBonus;
   }

   public final void setPaulBonus(boolean <set-?>) {
      paulBonus = var1;
   }

   public final boolean getRenderBeta() {
      return renderBeta;
   }

   public final void setRenderBeta(boolean <set-?>) {
      renderBeta = var1;
   }

   @NotNull
   public final String getCustomPrefix() {
      return customPrefix;
   }

   public final void setCustomPrefix(@NotNull String <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      customPrefix = var1;
   }

   private static final void _init_$lambda$0(Boolean it) {
      Intrinsics.checkNotNullParameter(it, "it");
      FunnyMap.INSTANCE.getExtras().setEnabled(it);
   }

   static {
      INSTANCE.initialize();
      INSTANCE.setCategoryDescription("General", "&f&l Funny Map\n&7Big thanks to &lIllegalMap&r&7 by UnclaimedBloom");
      INSTANCE.registerListener("enableExtras", Config::_init_$lambda$0);
   }

   @Metadata(
      mv = {1, 9, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00030\u0002j\n\u0012\u0006\b\u0000\u0012\u00020\u0003`\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006JG\u0010\u000b\u001a:\u0012\u0018\b\u0000\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00070\u0002j\u001c\u0012\u0018\b\u0000\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0007`\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\u0006R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\r¨\u0006\u0011"},
      d2 = {"Lfunnymap/config/Config$CategorySorting;", "Lgg/essential/vigilance/data/SortingBehavior;", "Ljava/util/Comparator;", "Lgg/essential/vigilance/data/Category;", "Lkotlin/Comparator;", "getCategoryComparator", "()Ljava/util/Comparator;", "", "", "", "Lgg/essential/vigilance/data/PropertyData;", "getSubcategoryComparator", "configCategories", "Ljava/util/List;", "configSubcategories", "<init>", "()V", "FunnyMapExtras"}
   )
   private static final class CategorySorting extends SortingBehavior {
      @NotNull
      public static final Config.CategorySorting INSTANCE = new Config.CategorySorting();
      @NotNull
      private static final List<String> configCategories;
      @NotNull
      private static final List<String> configSubcategories;

      @NotNull
      public Comparator<? super Category> getCategoryComparator() {
         return (Comparator)(new Config$CategorySorting$getCategoryComparator$$inlined$compareBy$1());
      }

      @NotNull
      public Comparator<? super Entry<String, ? extends List<PropertyData>>> getSubcategoryComparator() {
         return (Comparator)(new Config$CategorySorting$getSubcategoryComparator$$inlined$compareBy$1());
      }

      // $FF: synthetic method
      public static final List access$getConfigCategories$p() {
         return configCategories;
      }

      // $FF: synthetic method
      public static final List access$getConfigSubcategories$p() {
         return configSubcategories;
      }

      static {
         String[] var0 = new String[]{"General", "Map", "Rooms", "Run Information", "Score", "Colors", "Other Features", "Debug"};
         configCategories = CollectionsKt.listOf(var0);
         var0 = new String[]{"Toggle", "Message", "Elements", "Scanning", "Size", "Legit Mode", "Extras", "Render"};
         configSubcategories = CollectionsKt.listOf(var0);
      }
   }
}
