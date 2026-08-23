package com.dwiot.dwstep;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.dwiot.dwstep.databinding.ActivityStepBindingImpl;
import com.dwiot.dwstep.databinding.FragmentSimpleStepBindingImpl;
import com.dwiot.dwstep.databinding.FragmentStepNewBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes2.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_ACTIVITYSTEP = 1;
    private static final int LAYOUT_FRAGMENTSIMPLESTEP = 2;
    private static final int LAYOUT_FRAGMENTSTEPNEW = 3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(3);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.activity_step, 1);
        sparseIntArray.put(R.layout.fragment_simple_step, 2);
        sparseIntArray.put(R.layout.fragment_step_new, 3);
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = INTERNAL_LAYOUT_ID_LOOKUP.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        if (i2 == 1) {
            if ("layout/activity_step_0".equals(tag)) {
                return new ActivityStepBindingImpl(dataBindingComponent, view);
            }
            throw new IllegalArgumentException("The tag for activity_step is invalid. Received: " + tag);
        }
        if (i2 == 2) {
            if ("layout/fragment_simple_step_0".equals(tag)) {
                return new FragmentSimpleStepBindingImpl(dataBindingComponent, view);
            }
            throw new IllegalArgumentException("The tag for fragment_simple_step is invalid. Received: " + tag);
        }
        if (i2 != 3) {
            return null;
        }
        if ("layout/fragment_step_new_0".equals(tag)) {
            return new FragmentStepNewBindingImpl(dataBindingComponent, view);
        }
        throw new IllegalArgumentException("The tag for fragment_step_new is invalid. Received: " + tag);
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = InnerLayoutIdLookup.sKeys.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public String convertBrIdToString(int i) {
        return InnerBrLookup.sKeys.get(i);
    }

    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
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
            map.put("layout/activity_step_0", Integer.valueOf(R.layout.activity_step));
            map.put("layout/fragment_simple_step_0", Integer.valueOf(R.layout.fragment_simple_step));
            map.put("layout/fragment_step_new_0", Integer.valueOf(R.layout.fragment_step_new));
        }
    }
}
