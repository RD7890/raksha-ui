package com.dw.launcher;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.dw.launcher.databinding.ActivityNoDisturbBindingImpl;
import com.dw.launcher.databinding.DialogDeleteBindingImpl;
import com.dw.launcher.databinding.FragmentStepBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_ACTIVITYNODISTURB = 1;
    private static final int LAYOUT_DIALOGDELETE = 2;
    private static final int LAYOUT_FRAGMENTSTEP = 3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(3);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.activity_no_disturb, 1);
        sparseIntArray.put(R.layout.dialog_delete, 2);
        sparseIntArray.put(R.layout.fragment_step, 3);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
        int i = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
        if (i <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        if (i == 1) {
            if ("layout/activity_no_disturb_0".equals(tag)) {
                return new ActivityNoDisturbBindingImpl(component, view);
            }
            throw new IllegalArgumentException("The tag for activity_no_disturb is invalid. Received: " + tag);
        }
        if (i == 2) {
            if ("layout/dialog_delete_0".equals(tag)) {
                return new DialogDeleteBindingImpl(component, view);
            }
            throw new IllegalArgumentException("The tag for dialog_delete is invalid. Received: " + tag);
        }
        if (i != 3) {
            return null;
        }
        if ("layout/fragment_step_0".equals(tag)) {
            return new FragmentStepBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_step is invalid. Received: " + tag);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
        if (views == null || views.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId) <= 0 || views[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String tag) {
        Integer num;
        if (tag == null || (num = InnerLayoutIdLookup.sKeys.get(tag)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int localId) {
        return InnerBrLookup.sKeys.get(localId);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.chad.library.DataBinderMapperImpl());
        arrayList.add(new com.dw.bloodpressure.DataBinderMapperImpl());
        arrayList.add(new com.dwiot.dwstep.DataBinderMapperImpl());
        return arrayList;
    }

    private static class InnerBrLookup {
        static final SparseArray<String> sKeys;

        private InnerBrLookup() {
        }

        static {
            SparseArray<String> sparseArray = new SparseArray<>(1);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
        }
    }

    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys;

        private InnerLayoutIdLookup() {
        }

        static {
            HashMap<String, Integer> map = new HashMap<>(3);
            sKeys = map;
            map.put("layout/activity_no_disturb_0", Integer.valueOf(R.layout.activity_no_disturb));
            map.put("layout/dialog_delete_0", Integer.valueOf(R.layout.dialog_delete));
            map.put("layout/fragment_step_0", Integer.valueOf(R.layout.fragment_step));
        }
    }
}
