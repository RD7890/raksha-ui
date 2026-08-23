package com.dwiot.dwstep.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dwiot.dwstep.R;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class ItemStepDataView extends RelativeLayout {
    private static final String TAG = "ItemStepDataView";
    private ImageView ivIcon;
    private View mRootView;
    private TextView txtUnit;
    private TextView txtValue;
    private TextView txtlabel;

    public ItemStepDataView(Context context) {
        super(context);
    }

    public ItemStepDataView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = View.inflate(context, R.layout.item_step_data, this);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.itemStepData);
        initView(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void initView(TypedArray typedArray) {
        this.txtValue = (TextView) this.mRootView.findViewById(R.id.txtValue);
        this.txtlabel = (TextView) this.mRootView.findViewById(R.id.txtLable);
        this.ivIcon = (ImageView) this.mRootView.findViewById(R.id.ivIcon);
        this.txtUnit = (TextView) this.mRootView.findViewById(R.id.txtUnit);
        this.txtValue.setText(typedArray.getString(R.styleable.itemStepData_itemValue));
        this.txtlabel.setText(typedArray.getString(R.styleable.itemStepData_itemLabel));
        this.txtUnit.setText(typedArray.getString(R.styleable.itemStepData_itemUnit));
        int resourceId = typedArray.getResourceId(R.styleable.itemStepData_itemIcon, -1);
        if (resourceId > 0) {
            this.ivIcon.setImageResource(resourceId);
        }
    }

    public void setValue(String str) {
        this.txtValue.setText(str);
    }
}
