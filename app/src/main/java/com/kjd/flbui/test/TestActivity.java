package com.kjd.flbui.test;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kjd.flbui.R;

public class TestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        CustomDialog customDialog = new CustomDialog(this , R.style.customDialog , R.layout.layout_dialog);
        customDialog.show();
    }
}
