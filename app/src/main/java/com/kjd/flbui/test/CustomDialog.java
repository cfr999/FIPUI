package com.kjd.flbui.test;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by zzl19 on 2016/11/17.
 */

public class CustomDialog extends Dialog {

    private int mLayoutId;


    public CustomDialog(Context context , int layoutId) {
        super(context);
        this.mLayoutId = layoutId;
    }

    public CustomDialog(Context context, int themeResId, int layoutId) {
        super(context, themeResId);
        mLayoutId = layoutId;
    }

    public CustomDialog(Context context, boolean cancelable, OnCancelListener cancelListener, int layoutId) {
        super(context, cancelable, cancelListener);
        mLayoutId = layoutId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mLayoutId);
    }
}
