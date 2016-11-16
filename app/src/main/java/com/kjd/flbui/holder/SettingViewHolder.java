//<MStar Software>
//******************************************************************************
// MStar Software
// Copyright (c) 2010 - 2014 MStar Semiconductor, Inc. All rights reserved.
// All software, firmware and related documentation herein ("MStar Software") are
// intellectual property of MStar Semiconductor, Inc. ("MStar") and protected by
// law, including, but not limited to, copyright law and international treaties.
// Any use, modification, reproduction, retransmission, or republication of all
// or part of MStar Software is expressly prohibited, unless prior written
// permission has been granted by MStar.
//
// By accessing, browsing and/or using MStar Software, you acknowledge that you
// have read, understood, and agree, to be bound by below terms ("Terms") and to
// comply with all applicable laws and regulations:
//
// 1. MStar shall retain any and all right, ownership and interest to MStar
//    Software and any modification/derivatives thereof.
//    No right, ownership, or interest to MStar Software and any
//    modification/derivatives thereof is transferred to you under Terms.
//
// 2. You understand that MStar Software might include, incorporate or be
//    supplied together with third party's software and the use of MStar
//    Software may require additional licenses from third parties.
//    Therefore, you hereby agree it is your sole responsibility to separately
//    obtain any and all third party right and license necessary for your use of
//    such third party's software.
//
// 3. MStar Software and any modification/derivatives thereof shall be deemed as
//    MStar's confidential information and you agree to keep MStar's
//    confidential information in strictest confidence and not disclose to any
//    third party.
//
// 4. MStar Software is provided on an "AS IS" basis without warranties of any
//    kind. Any warranties are hereby expressly disclaimed by MStar, including
//    without limitation, any warranties of merchantability, non-infringement of
//    intellectual property rights, fitness for a particular purpose, error free
//    and in conformity with any international standard.  You agree to waive any
//    claim against MStar for any loss, damage, cost or expense that you may
//    incur related to your use of MStar Software.
//    In no event shall MStar be liable for any direct, indirect, incidental or
//    consequential damages, including without limitation, lost of profit or
//    revenues, lost or damage of data, and unauthorized system use.
//    You agree that this Section 4 shall still apply without being affected
//    even if MStar Software has been modified by MStar in accordance with your
//    request or instruction for your use, except otherwise agreed by both
//    parties in writing.
//
// 5. If requested, MStar may from time to time provide technical supports or
//    services in relation with MStar Software to you for your use of
//    MStar Software in conjunction with your or your customer's product
//    ("Services").
//    You understand and agree that, except otherwise agreed by both parties in
//    writing, Services are provided on an "AS IS" basis and the warranty
//    disclaimer set forth in Section 4 above shall apply.
//
// 6. Nothing contained herein shall be construed as by implication, estoppels
//    or otherwise:
//    (a) conferring any license or right to use MStar name, trademark, service
//        mark, symbol or any other identification;
//    (b) obligating MStar or any of its affiliates to furnish any person,
//        including without limitation, you and your customers, any assistance
//        of any kind whatsoever, or any information; or
//    (c) conferring any license or right under any intellectual property right.
//
// 7. These terms shall be governed by and construed in accordance with the laws
//    of Taiwan, R.O.C., excluding its conflict of law rules.
//    Any and all dispute arising out hereof or related hereto shall be finally
//    settled by arbitration referred to the Chinese Arbitration Association,
//    Taipei in accordance with the ROC Arbitration Law and the Arbitration
//    Rules of the Association by three (3) arbitrators appointed in accordance
//    with the said Rules.
//    The place of arbitration shall be in Taipei, Taiwan and the language shall
//    be English.
//    The arbitration award shall be final and binding to both parties.
//
//******************************************************************************
//<MStar Software>

package com.kjd.flbui.holder;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.kjd.flbui.R;
import com.kjd.flbui.ui.ImgTextButton;


public class SettingViewHolder {
    // 16*16 switchmode...
    private static final String TAG = "SettingViewHolder";

    private static final int SWITCH_OFF = 0;
    private static final int SWITCH_ON = 1;
    private static final int HBBTV_OFF = 0;
    private static final int HBBTV_ON = 1;

	private ImgTextButton btSource;
    private ImgTextButton btPicture;
    private ImgTextButton btSound; 
	private ImgTextButton btChannel;
	private ImgTextButton btSetting;

    protected TextView text_set_language_val;
    protected TextView text_set_audio_language1_val;
    protected TextView text_set_audio_language2_val;
    protected TextView text_set_subtitle_language1_val;
    protected TextView text_set_subtitle_language2_val;

    protected TextView text_set_menutime_val;
    protected TextView text_set_switchmode_val;
    protected TextView text_set_autosourceident_val;
    protected TextView text_set_sourcepreview_val;
    protected TextView text_set_autosourceswit_val;
    protected TextView text_set_colorrange_val;

    protected TextView text_set_mhlswitch_val;
    protected TextView text_set_moviemode_val;
    protected TextView text_set_bluescreenswitch_val;
    protected TextView text_set_hdmiarc_val;
    protected TextView text_set_hdmicec_val;
    protected TextView text_set_standyon_val;
    protected LinearLayout linear_set_pvrfs;
    protected LinearLayout linear_set_hdmicec;
    protected LinearLayout linear_set_cec_list;
    protected LinearLayout linear_set_standyon;
    protected LinearLayout linear_set_powersetting;
    protected LinearLayout linear_hbbtv_onoff;
    protected LinearLayout linear_set_restoretodefault;
    protected LinearLayout linear_set_language;
    protected LinearLayout linear_set_audio_language1;
    protected LinearLayout linear_set_audio_language2;
    protected LinearLayout linear_set_subtitle_language1;
    protected LinearLayout linear_set_subtitle_language2;

    protected LinearLayout linear_set_menutime;
    protected LinearLayout linear_set_switchmode;
    protected LinearLayout linear_set_autosourceident;
    protected LinearLayout linear_set_sourcepreview;
    protected LinearLayout linear_set_autosourceswit;
    protected LinearLayout linear_set_colorrange;
    protected LinearLayout linear_set_mhlswitch;
    protected LinearLayout linear_set_moviemode;
    protected LinearLayout linear_set_bluescreenswitch;
    protected LinearLayout linear_set_hdmiarc;
    protected LinearLayout linear_setting;

    private Handler mHandler = new Handler();



    private Activity settingActivity;
    private Intent intent = new Intent();

    private ProgressDialog mProgressDialog = null;
    private Thread mThreadEdidChange = null;

    private int languageindex = 0;
    private int mAudiolanguage1index = 0;
    private int mAudiolanguage2index = 0;
    private int mSubtitlelanguage1index = 0;
    private int mSubtitlelanguage2index = 0;
    private int menutimeindex = 0;
    private int switchmodeindex = 0;
    private int sourceidentindex = SWITCH_OFF;
    private int sourcepreviewindex = SWITCH_OFF;
    private int sourceswitindex = SWITCH_OFF;
    private int colorrangeindex = 0;
    private int mhlswitchindex = SWITCH_OFF;
    private int moviemodeindex = SWITCH_OFF;
    private int bluescreenindex = SWITCH_OFF;
    private int hdmiarcindex = SWITCH_OFF;
    private int hdmicecindex = SWITCH_OFF;
    private int standyonindex = SWITCH_OFF;
    private int focusedid = 0x00000000;
    private int DeviceListCount = 0;
    private String[] languagetype;
    private String[] menutimetype;
    private String[] switchmodetype;
    private String[] sourceidenttype;
    private String[] sourcepreviewtype;
    private String[] sourceswittype;
    private String[] mhlswitchtype;
    private String[] moviemodetype;
    private String[] bluescreentype;
    private String[] hdmidarctype;
    private String[] hdmicectype;
    private String[] standyontype;
    private String[] colorrangetype;
    private Handler handler;
    private String[] mLanguageNameArray;
    private String[] mCecListName;


    private static final int CHANGE_PAGE = 10099;
    
    public SettingViewHolder(Activity activity, Handler handler) {
        this.settingActivity = activity;

        this.handler = handler;
    }

    public void findViews() {
		
        btSource=(ImgTextButton)settingActivity.findViewById(R.id.btSource_settings);
        btSource.setImgResource(R.mipmap.source);
        btSource.setText(R.string.str_input_source_title);
        //btSource.setBackgroundResource(R.mipmap.menu_icon_select);
        btSource.setFocusable(false);   

        btPicture=(ImgTextButton)settingActivity.findViewById(R.id.btPicture_settings);
        btPicture.setImgResource(R.mipmap.picture);
        btPicture.setText(R.string.str_pic_picture);   

        btPicture.setFocusable(false);   

        btSound=(ImgTextButton)settingActivity.findViewById(R.id.btSound_settings);
        btSound.setImgResource(R.mipmap.sound);
        btSound.setText(R.string.str_sound_sound_adjustment);
        //btSound.setBackgroundResource(R.mipmap.menu_icon_select);

        btSound.setFocusable(false);
        

        btChannel=(ImgTextButton)settingActivity.findViewById(R.id.btchannel_settings);
        btChannel.setImgResource(R.mipmap.channel);
        btChannel.setText(R.string.str_cha_channel);
        //btChannel.setBackgroundResource(R.mipmap.menu_icon_select);;

        btChannel.setFocusable(false);
        

        btSetting=(ImgTextButton)settingActivity.findViewById(R.id.btSetting_settings);
        btSetting.setImgResource(R.mipmap.setting);
        btSetting.setText(R.string.str_set_setting);
        btSetting.setBackgroundResource(R.mipmap.menu_icon_select);
        btSetting.setFocusable(false);

        mLanguageNameArray = new String[] {
                settingActivity.getResources().getString(R.string.str_set_language_czech),
                settingActivity.getResources().getString(R.string.str_set_language_danish),
                settingActivity.getResources().getString(R.string.str_set_language_german),
                settingActivity.getResources().getString(R.string.str_set_language_english),
                settingActivity.getResources().getString(R.string.str_set_language_spanish),
                settingActivity.getResources().getString(R.string.str_set_language_greek),
                settingActivity.getResources().getString(R.string.str_set_language_french),
                settingActivity.getResources().getString(R.string.str_set_language_croatian),
                settingActivity.getResources().getString(R.string.str_set_language_italian),
                settingActivity.getResources().getString(R.string.str_set_language_hungarian),
                settingActivity.getResources().getString(R.string.str_set_language_dutch),
                settingActivity.getResources().getString(R.string.str_set_language_norwegian),
                settingActivity.getResources().getString(R.string.str_set_language_polish),
                settingActivity.getResources().getString(R.string.str_set_language_portuguese),
                settingActivity.getResources().getString(R.string.str_set_language_russian),
                settingActivity.getResources().getString(R.string.str_set_language_romanian),
                settingActivity.getResources().getString(R.string.str_set_language_slovenian),
                settingActivity.getResources().getString(R.string.str_set_language_serbian),
                settingActivity.getResources().getString(R.string.str_set_language_finnish),
                settingActivity.getResources().getString(R.string.str_set_language_swedish),
                settingActivity.getResources().getString(R.string.str_set_language_bulgarian),
                settingActivity.getResources().getString(R.string.str_set_language_slovak),
                settingActivity.getResources().getString(R.string.str_set_language_chinese),
                settingActivity.getResources().getString(R.string.str_set_language_gaelic),
                settingActivity.getResources().getString(R.string.str_set_language_welsh),
                settingActivity.getResources().getString(R.string.str_set_language_irish),
                settingActivity.getResources().getString(R.string.str_set_language_arabic),
                settingActivity.getResources().getString(R.string.str_set_language_latvian),
                settingActivity.getResources().getString(R.string.str_set_language_hebrew),
                settingActivity.getResources().getString(R.string.str_set_language_turkish),
                settingActivity.getResources().getString(R.string.str_set_language_estonian),
                settingActivity.getResources().getString(R.string.str_set_language_gallegan),
                settingActivity.getResources().getString(R.string.str_set_language_basque),
                settingActivity.getResources().getString(R.string.str_set_language_catalan),
                settingActivity.getResources().getString(R.string.str_set_language_icelandic),
                settingActivity.getResources().getString(R.string.str_set_language_letzeburgesch),
                settingActivity.getResources().getString(R.string.str_set_language_lithuanian),
                settingActivity.getResources().getString(R.string.str_set_language_ukrainian),
                settingActivity.getResources().getString(R.string.str_set_language_byelorussian),
                settingActivity.getResources().getString(R.string.str_set_language_maori),
                settingActivity.getResources().getString(R.string.str_set_language_mandarin),
                settingActivity.getResources().getString(R.string.str_set_language_cantonese),
                settingActivity.getResources().getString(R.string.str_set_language_korean),
                settingActivity.getResources().getString(R.string.str_set_language_japanese),
                settingActivity.getResources().getString(R.string.str_set_language_hindi),
                settingActivity.getResources().getString(R.string.str_set_language_thai),
                settingActivity.getResources().getString(R.string.str_set_language_vietnamese),
        };

        text_set_language_val = (TextView) settingActivity
                .findViewById(R.id.textview_set_language_val);
        text_set_audio_language1_val = (TextView) settingActivity
                .findViewById(R.id.textview_set_audio_language1_val);
        text_set_audio_language2_val = (TextView) settingActivity
                .findViewById(R.id.textview_set_audio_language2_val);
        text_set_subtitle_language1_val = (TextView) settingActivity
                .findViewById(R.id.textview_set_subtitle_language1_val);
        text_set_subtitle_language2_val = (TextView) settingActivity
                .findViewById(R.id.textview_set_subtitle_language2_val);
        text_set_menutime_val = (TextView) settingActivity
                .findViewById(R.id.textview_set_menutime_val);
        text_set_switchmode_val = (TextView) settingActivity
                .findViewById(R.id.textview_set_switchmode_val);
        text_set_autosourceident_val = (TextView) settingActivity
                .findViewById(R.id.textview_set_autosourceident_val);
        text_set_sourcepreview_val = (TextView) settingActivity
                .findViewById(R.id.textview_set_sourcepreview_val);
        text_set_autosourceswit_val = (TextView) settingActivity
                .findViewById(R.id.textview_set_autosourceswit_val);
        text_set_colorrange_val = (TextView) settingActivity
                .findViewById(R.id.textview_set_colorrange_val);
        text_set_moviemode_val = (TextView) settingActivity
                .findViewById(R.id.textview_set_moviemode_val);
        text_set_mhlswitch_val = (TextView) settingActivity
                .findViewById(R.id.textview_set_mhlswitch_val);
        text_set_bluescreenswitch_val = (TextView) settingActivity
                .findViewById(R.id.textview_set_bluescreenswitch_val);
        text_set_hdmiarc_val = (TextView) settingActivity
                .findViewById(R.id.textview_set_hdmiarc_val);
        text_set_hdmicec_val = (TextView) settingActivity
                .findViewById(R.id.textview_set_hdmicec_val);
        text_set_standyon_val = (TextView) settingActivity
                .findViewById(R.id.textview_set_standyon_val);
        linear_set_pvrfs = (LinearLayout) settingActivity.findViewById(R.id.linearlayout_set_pvrfs);

        linear_set_hdmicec = (LinearLayout) settingActivity
                .findViewById(R.id.linearlayout_set_hdmicec);
        linear_set_standyon = (LinearLayout) settingActivity
                .findViewById(R.id.linearlayout_set_standyon);
        linear_set_cec_list = (LinearLayout) settingActivity
                .findViewById(R.id.linearlayout_set_cec_list);
        linear_set_powersetting = (LinearLayout) settingActivity
                .findViewById(R.id.linearlayout_set_powersetting);
        linear_set_language = (LinearLayout) settingActivity
                .findViewById(R.id.linearlayout_set_language);
        linear_set_audio_language1 = (LinearLayout) settingActivity
                .findViewById(R.id.linearlayout_set_audio_language1);
        linear_set_audio_language2 = (LinearLayout) settingActivity
                .findViewById(R.id.linearlayout_set_audio_language2);
        linear_set_subtitle_language1 = (LinearLayout) settingActivity
                .findViewById(R.id.linearlayout_set_subtitle_language1);
        linear_set_subtitle_language2 = (LinearLayout) settingActivity
                .findViewById(R.id.linearlayout_set_subtitle_language2);

        linear_set_menutime = (LinearLayout) settingActivity
                .findViewById(R.id.linearlayout_set_menutime);
        linear_set_switchmode = (LinearLayout) settingActivity
                .findViewById(R.id.linearlayout_set_switchmode);
        linear_set_autosourceident = (LinearLayout) settingActivity
                .findViewById(R.id.linearlayout_set_autosourceident);
        linear_set_sourcepreview = (LinearLayout) settingActivity
                .findViewById(R.id.linearlayout_set_sourcepreview);
        linear_set_autosourceswit = (LinearLayout) settingActivity
                .findViewById(R.id.linearlayout_set_autosourceswit);
        linear_set_colorrange = (LinearLayout) settingActivity
                .findViewById(R.id.linearlayout_set_colorrange);
        linear_set_moviemode = (LinearLayout) settingActivity
                .findViewById(R.id.linearlayout_set_moviemode);
        linear_set_bluescreenswitch = (LinearLayout) settingActivity
                .findViewById(R.id.linearlayout_set_bluescreenswitch);
        linear_set_mhlswitch = (LinearLayout) settingActivity
                .findViewById(R.id.linearlayout_set_mhlswitch);
        linear_set_hdmiarc = (LinearLayout) settingActivity
                .findViewById(R.id.linearlayout_set_hdmiarc);
        linear_hbbtv_onoff = (LinearLayout) settingActivity
                .findViewById(R.id.linearlayout_set_hbbtv_switch);
        linear_set_restoretodefault = (LinearLayout) settingActivity
                .findViewById(R.id.linearlayout_set_restoretodefault);
        linear_setting = (LinearLayout) settingActivity
                .findViewById(R.id.linearlayout_setting);
        languagetype = settingActivity.getResources().getStringArray(
                R.array.str_arr_set_default_language);
        menutimetype = settingActivity.getResources().getStringArray(
                R.array.str_arr_set_menutimetype);
        switchmodetype = settingActivity.getResources().getStringArray(
                R.array.str_arr_set_switchmodetype);
        sourceidenttype = settingActivity.getResources().getStringArray(
                R.array.str_arr_set_sourceidenttype);
        sourcepreviewtype = settingActivity.getResources().getStringArray(
                R.array.str_arr_set_sourcepreviewtype);
        sourceswittype = settingActivity.getResources().getStringArray(
                R.array.str_arr_set_sourceswittype);
        mhlswitchtype = settingActivity.getResources().getStringArray(
                R.array.str_arr_set_mhlautoswitch_onoff);
        moviemodetype = settingActivity.getResources().getStringArray(
                R.array.str_arr_set_moviemodetype);
        bluescreentype = settingActivity.getResources().getStringArray(
                R.array.str_arr_set_bluescreenswitchtype);
        hdmidarctype = settingActivity.getResources().getStringArray(
                R.array.str_arr_set_hdmiarctype);
        hdmicectype = settingActivity.getResources()
                .getStringArray(R.array.str_arr_set_hdmicectype);
        standyontype = settingActivity.getResources().getStringArray(
                R.array.str_arr_set_standyontype);
        colorrangetype = settingActivity.getResources().getStringArray(
                R.array.str_arr_set_colorrangetype);
        linear_set_menutime.requestFocus();
        linear_set_language.setVisibility(View.GONE);
        linear_set_bluescreenswitch.setVisibility(View.GONE);

        Configuration config = settingActivity.getResources().getConfiguration();
        if (config.locale.toString().equals("en_US")) {
            languageindex = 0;
        } else {
            languageindex = 1;
        }


    }



}
