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

import android.app.ProgressDialog;

import android.content.Intent;

import android.os.Handler;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.kjd.flbui.R;
import com.kjd.flbui.ui.ImgTextButton;


public class ChannelViewHolder {
    private static final String TAG = "ChannelViewHolder";
    
    private static final int CHANGE_PAGE = 10099;
    
    private final int SWITCH_OFF = 0;

    private final int SWITCH_ON = 1;

    private final int VIEW_PROMPT_SWITCH_OFF = 0;

    private final int VIEW_PROMPT_SWITCH_ON = 1;

    private final int OAD_UPDATE_TIME_NOW = 24;

    private final int BANDWIDTH_7_MHZ_INDEX = 0;

    private final int BANDWIDTH_8_MHZ_INDEX = 1;

    private final int UHF_7_MHZ_DISABLE = 0;

    private final int UHF_7_MHZ_ENABLE = 1;

    protected TextView text_cha_software_update_oad_val;

    protected TextView text_cha_time_to_search_for_ssu_val;


    private Thread mThreadRouteChange = null;

    private ProgressDialog mProgressDialog = null;

    protected LinearLayout linear_cha_autotuning;

    protected LinearLayout linear_cha_dtvmanualtuning;

    protected LinearLayout linear_cha_atvmanualtuning;

    protected LinearLayout linear_cha_dvbs_lnbsetting;

    protected LinearLayout linear_cha_programedit;

    protected LinearLayout linear_cha_ciinformation;

    protected LinearLayout linear_cha_cainformation;

    protected LinearLayout linear_cha_signalinfo;

    protected LinearLayout linear_cha_softwareupdateoad;

    protected LinearLayout linear_cha_oadtime;

    protected LinearLayout linear_cha_oadscan;


    private final Activity mChannelActivity;

    private final Intent mIntent = new Intent();

    private int focusedid = 0x00000000;

    private String[] mSoftwareUpdateOadTable;

    private int mTvSystem = 0;



    private int mSoftwareUpdateOadIndex = SWITCH_OFF;

    private int oadTime = 0;

	  private ImgTextButton btPicture;
    private ImgTextButton btSound;    
    private ImgTextButton btSetting;
    private ImgTextButton btSource;
    private ImgTextButton btChannel;
    
    protected Handler handler;



    public ChannelViewHolder(Activity activity,Handler handler) {
        this.mChannelActivity = activity;
        this.handler = handler;

    }

    public void findViews() {
        /* Create Set Antenna Type ComboButton according to the given TV System */
        btSource=(ImgTextButton)mChannelActivity.findViewById(R.id.btSource_channel);
        btSource.setImgResource(R.mipmap.source);
        btSource.setText(R.string.str_input_source_title);
        btSource.setFocusable(false);   
	
        
        btPicture=(ImgTextButton)mChannelActivity.findViewById(R.id.btPicture_channel);
        btPicture.setImgResource(R.mipmap.picture);
        btPicture.setText(R.string.str_pic_picture);

        btPicture.setFocusable(false);   
       
        
        btSound=(ImgTextButton)mChannelActivity.findViewById(R.id.btSound_channel);
        btSound.setImgResource(R.mipmap.sound);
        btSound.setText(R.string.str_sound_sound_adjustment);
        btSound.setFocusable(false);   
        
        btChannel=(ImgTextButton)mChannelActivity.findViewById(R.id.btchannel_channel);
        btChannel.setImgResource(R.mipmap.channel);
        btChannel.setText(R.string.str_cha_channel);
	    btChannel.setBackgroundResource(R.mipmap.menu_icon_select);
        btChannel.setFocusable(false);   
        
        btSetting=(ImgTextButton)mChannelActivity.findViewById(R.id.btSetting_channel);
        btSetting.setImgResource(R.mipmap.setting);
        btSetting.setText(R.string.str_set_setting);
        btSetting.setFocusable(false);   
		

        text_cha_software_update_oad_val = (TextView) mChannelActivity
                .findViewById(R.id.textview_cha_software_update_oad_val);
        text_cha_time_to_search_for_ssu_val = (TextView) mChannelActivity
                .findViewById(R.id.textview_cha_time_to_search_for_ssu_val);
        linear_cha_autotuning = (LinearLayout) mChannelActivity
                .findViewById(R.id.linearlayout_cha_autotuning);
        linear_cha_dtvmanualtuning = (LinearLayout) mChannelActivity
                .findViewById(R.id.linearlayout_cha_dtvmanualtuning);
        linear_cha_atvmanualtuning = (LinearLayout) mChannelActivity
                .findViewById(R.id.linearlayout_cha_atvmanualtuning);
        linear_cha_dvbs_lnbsetting = (LinearLayout) mChannelActivity
                .findViewById(R.id.linearlayout_cha_dvbs_lnbsetting);
        linear_cha_programedit = (LinearLayout) mChannelActivity
                .findViewById(R.id.linearlayout_cha_programedit);
        linear_cha_ciinformation = (LinearLayout) mChannelActivity
                .findViewById(R.id.linearlayout_cha_ciinformation);
        linear_cha_cainformation = (LinearLayout) mChannelActivity
                .findViewById(R.id.linearlayout_cha_cainformation);
        linear_cha_signalinfo = (LinearLayout) mChannelActivity
                .findViewById(R.id.linearlayout_cha_signalinfo);
        linear_cha_softwareupdateoad = (LinearLayout) mChannelActivity
                .findViewById(R.id.linearlayout_cha_software_update_oad);
        linear_cha_oadtime = (LinearLayout) mChannelActivity
                .findViewById(R.id.linearlayout_cha_oadtime);
        linear_cha_oadscan = (LinearLayout) mChannelActivity
                .findViewById(R.id.linearlayout_cha_oadscan);
    }









}
