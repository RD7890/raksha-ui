package com.dw.launcher.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.mms.pdu.CharacterSets;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshFooter;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.simple.SimpleMultiListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SmartRefresh.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\tB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¨\u0006\n"}, d2 = {"Lcom/dw/launcher/ui/view/SmartRefresh;", "Lcom/scwang/smart/refresh/layout/SmartRefreshLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "setupRefreshLayout", "", "MultiPurposeListener", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
public final class SmartRefresh extends SmartRefreshLayout {
    public /* synthetic */ SmartRefresh(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmartRefresh(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setupRefreshLayout(context);
    }

    private final void setupRefreshLayout(Context context) {
        setEnableRefresh(false);
        setEnableLoadMore(false);
        setEnableOverScrollBounce(true);
        setEnableOverScrollDrag(true);
        setRefreshHeader(new ClassicsHeader(context));
        setRefreshFooter(new ClassicsFooter(context));
        setHeaderHeight(2000.0f);
        setOnMultiListener(new MultiPurposeListener());
    }

    /* JADX INFO: compiled from: SmartRefresh.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J8\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016¨\u0006\u0013"}, d2 = {"Lcom/dw/launcher/ui/view/SmartRefresh$MultiPurposeListener;", "Lcom/scwang/smart/refresh/layout/simple/SimpleMultiListener;", "(Lcom/dw/launcher/ui/view/SmartRefresh;)V", "onFooterMoving", "", "footer", "Lcom/scwang/smart/refresh/layout/api/RefreshFooter;", "isDragging", "", "percent", "", "offset", "", "footerHeight", "maxDragHeight", "onHeaderMoving", "header", "Lcom/scwang/smart/refresh/layout/api/RefreshHeader;", "headerHeight", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
    private final class MultiPurposeListener extends SimpleMultiListener {
        public MultiPurposeListener() {
        }

        @Override // com.scwang.smart.refresh.layout.simple.SimpleMultiListener, com.scwang.smart.refresh.layout.listener.OnMultiListener
        public void onHeaderMoving(RefreshHeader header, boolean isDragging, float percent, int offset, int headerHeight, int maxDragHeight) {
            Intrinsics.checkNotNullParameter(header, "header");
            super.onHeaderMoving(header, isDragging, percent, offset, headerHeight, maxDragHeight);
        }

        @Override // com.scwang.smart.refresh.layout.simple.SimpleMultiListener, com.scwang.smart.refresh.layout.listener.OnMultiListener
        public void onFooterMoving(RefreshFooter footer, boolean isDragging, float percent, int offset, int footerHeight, int maxDragHeight) {
            Intrinsics.checkNotNullParameter(footer, "footer");
            super.onFooterMoving(footer, isDragging, percent, offset, footerHeight, maxDragHeight);
        }
    }
}
