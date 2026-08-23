package com.dw.launcher.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.dw.launcher.R;
import com.dw.launcher.core.component.NotificationComponent;
import com.google.android.mms.pdu.CharacterSets;
import dagger.hilt.android.AndroidEntryPoint;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.Observable;
import java.util.Observer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DialNotificationView.kt */
/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u001aH\u0014J\u001c\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006!"}, d2 = {"Lcom/dw/launcher/ui/view/DialNotificationView;", "Landroid/widget/FrameLayout;", "Ljava/util/Observer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ivIcon", "Lde/hdodenhof/circleimageview/CircleImageView;", "notificationComponent", "Lcom/dw/launcher/core/component/NotificationComponent;", "getNotificationComponent", "()Lcom/dw/launcher/core/component/NotificationComponent;", "setNotificationComponent", "(Lcom/dw/launcher/core/component/NotificationComponent;)V", "parent", "getParent", "()Landroid/widget/FrameLayout;", "setParent", "(Landroid/widget/FrameLayout;)V", "onAttachedToWindow", "", "onDetachedFromWindow", "update", "o", "Ljava/util/Observable;", "arg", "", "app_version8Release"}, k = 1, mv = {1, CharacterSets.ISO_8859_6, 0}, xi = 48)
@AndroidEntryPoint
public final class DialNotificationView extends Hilt_DialNotificationView implements Observer {
    private CircleImageView ivIcon;

    @Inject
    public NotificationComponent notificationComponent;
    private FrameLayout parent;

    @Override // java.util.Observer
    public void update(Observable o, Object arg) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialNotificationView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View viewInflate = FrameLayout.inflate(getContext(), R.layout.dial_view_notification, this);
        View viewFindViewById = viewInflate.findViewById(R.id.parent);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.parent = (FrameLayout) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.ivIcon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.ivIcon = (CircleImageView) viewFindViewById2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialNotificationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        View viewInflate = FrameLayout.inflate(getContext(), R.layout.dial_view_notification, this);
        View viewFindViewById = viewInflate.findViewById(R.id.parent);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.parent = (FrameLayout) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.ivIcon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.ivIcon = (CircleImageView) viewFindViewById2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialNotificationView(Context context, AttributeSet attrs, int i) {
        super(context, attrs, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        View viewInflate = FrameLayout.inflate(getContext(), R.layout.dial_view_notification, this);
        View viewFindViewById = viewInflate.findViewById(R.id.parent);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.parent = (FrameLayout) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.ivIcon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.ivIcon = (CircleImageView) viewFindViewById2;
    }

    public final NotificationComponent getNotificationComponent() {
        NotificationComponent notificationComponent = this.notificationComponent;
        if (notificationComponent != null) {
            return notificationComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("notificationComponent");
        return null;
    }

    public final void setNotificationComponent(NotificationComponent notificationComponent) {
        Intrinsics.checkNotNullParameter(notificationComponent, "<set-?>");
        this.notificationComponent = notificationComponent;
    }

    @Override // android.view.View, android.view.ViewParent
    public final FrameLayout getParent() {
        return this.parent;
    }

    public final void setParent(FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
        this.parent = frameLayout;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getNotificationComponent().addObserver(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getNotificationComponent().deleteObserver(this);
    }
}
