package com.kjd.flbui;

import android.app.Activity;
import android.os.Handler;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.kjd.flbui.holder.ChannelViewHolder;
import com.kjd.flbui.holder.PictureViewHolder;
import com.kjd.flbui.holder.SettingViewHolder;
import com.kjd.flbui.holder.SoundViewHolder;
import com.kjd.flbui.holder.SourceViewHolder;
import com.kjd.flbui.test.CustomDialog;

public class MainActivity extends Activity {

    private ViewFlipper viewFlipper = null;
    private float startX;

    protected LayoutInflater lf;
    private LinearLayout linearlayout_pic_colortemperature;
    private LinearLayout parameterLayout;
    private LinearLayout picture_indicator;
    private LinearLayout zoom_model_indicator;
    private LinearLayout linearlayout_pic_picturemode;
    private LinearLayout linearlayout_pic_zoommode;

    //动态
    private TextView color_temperature_dynamic;
    //标准
    private TextView color_temperature_standar;
    //柔和
    private TextView color_temperature_soft;
    //用户
    private TextView color_temperature_user;


    public final static int SOURCE_PAGE = 0;

    public final static int PICTURE_PAGE = 1;

    public final static int SOUND_PAGE = 2;

    public final static int CHANNEL_PAGE = 3;

    public final static int SETTING_PAGE = 4;

    private int mMaxPageIdx = 4;

    protected SourceViewHolder sourceViewHolder;

    protected PictureViewHolder pictureViewHolder;

    protected SoundViewHolder soundViewHolder;

    protected ChannelViewHolder menuOfChannelViewHolder;

    protected SettingViewHolder menuOfSettingViewHolder;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        viewFlipper = (ViewFlipper) this.findViewById(R.id.view_flipper_main_menu);
        lf = LayoutInflater.from(this);
        addCurrentView(4);
        initUIComponent(1);

        parameterLayout = (LinearLayout) findViewById(R.id.parameterLayout);
        picture_indicator = (LinearLayout) findViewById(R.id.picturemode_indicator);
        zoom_model_indicator = (LinearLayout) findViewById(R.id.zoom_model_indicator);
        linearlayout_pic_picturemode = (LinearLayout) findViewById(R.id.linearlayout_pic_picturemode);
        linearlayout_pic_picturemode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                picture_indicator.setVisibility(View.VISIBLE);
                zoom_model_indicator.setVisibility(View.GONE);
            }
        });
        linearlayout_pic_colortemperature = (LinearLayout) findViewById(R.id.linearlayout_pic_colortemperature);
        linearlayout_pic_colortemperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog customDialog = new CustomDialog(MainActivity.this , R.style.customDialog , R.layout.layout_dialog);
                customDialog.show();
            }
        });

        linearlayout_pic_zoommode = (LinearLayout) findViewById(R.id.linearlayout_pic_zoommode);
        linearlayout_pic_zoommode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                picture_indicator.setVisibility(View.GONE);
                zoom_model_indicator.setVisibility(View.VISIBLE);
            }
        });






    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                Log.d(MainActivity.class.getSimpleName() , "....");
                if (event.getX() > startX) { // 向右滑动
                    viewFlipper.setInAnimation(this, R.anim.in_leftright);
                    viewFlipper.setOutAnimation(this, R.anim.out_leftright);
                    viewFlipper.showNext();
                } else if (event.getX() < startX) { // 向左滑动
                    viewFlipper.setInAnimation(this, R.anim.in_rightleft);
                    viewFlipper.setOutAnimation(this, R.anim.out_rightleft);
                    viewFlipper.showPrevious();
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    protected void addCurrentView(int pageId) {
        if (viewFlipper.getChildCount() > mMaxPageIdx) {
            return;
        }
        viewFlipper.removeAllViews();
        for (int i = 0; i <= pageId; i++) {
            addView(i);
        }
    }

    protected void addView(int id) {
        switch (id) {
            case SOURCE_PAGE:
                try {
                    viewFlipper.addView(lf.inflate(R.layout.source, null), 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case PICTURE_PAGE:
                try {
                    viewFlipper.addView(lf.inflate(R.layout.picture, null), 1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case SOUND_PAGE:
                try {
                    viewFlipper.addView(lf.inflate(R.layout.sound, null), 2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case CHANNEL_PAGE:
                try {
                    viewFlipper.addView(lf.inflate(R.layout.channel, null), 3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case SETTING_PAGE:
                try {
                    View viewSetting = lf.inflate(R.layout.setting, null);

                    viewFlipper.addView(viewSetting, 4);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }


    protected void initUIComponent(int page) {
        viewFlipper.setDisplayedChild(page);
        switch (page) {

            case SOURCE_PAGE:
                if (sourceViewHolder == null) {
                    sourceViewHolder = new SourceViewHolder(MainActivity.this,handler);
                    sourceViewHolder.findViews();
                    sourceViewHolder.LoadDataToUI();
                }
                break;

            case PICTURE_PAGE:
                if (pictureViewHolder == null) {
                    pictureViewHolder = new PictureViewHolder(MainActivity.this,handler);
                    pictureViewHolder.findViews();
                }
                break;
            case SOUND_PAGE:
                if (soundViewHolder == null) {
                    soundViewHolder = new SoundViewHolder(MainActivity.this,handler);
                    soundViewHolder.findViews();
                }
                break;

            case CHANNEL_PAGE:
                if (menuOfChannelViewHolder == null) {
                    menuOfChannelViewHolder = new ChannelViewHolder(MainActivity.this,handler);
                    menuOfChannelViewHolder.findViews();
                }
                break;
            case SETTING_PAGE:
                if (menuOfSettingViewHolder == null) {
                    menuOfSettingViewHolder = new SettingViewHolder(MainActivity.this, handler);
                    menuOfSettingViewHolder.findViews();
                }
                break;
        }

    }

}
