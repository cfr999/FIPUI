//<MStar Software>
//******************************************************************************
// MStar Software
// Copyright (c) 2010 - 2015 MStar Semiconductor, Inc. All rights reserved.
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
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.LinearLayout;
import com.kjd.flbui.R;
import com.kjd.flbui.ui.ImgTextButton;

public class SoundViewHolder {
    private static final String TAG = "SoundViewHolder";

    protected static final int STEP = 1;



    protected Activity activity;



    protected ImgTextButton btPicture2;
    protected ImgTextButton btSound2;    
    protected ImgTextButton btSetting2;
    protected ImgTextButton btSource2;
    protected ImgTextButton btChannel2;
    
    private static final int CHANGE_PAGE = 10099;
	protected Handler handler;

    public SoundViewHolder(Activity act,Handler handler) {
        this.activity = act;
        this.handler = handler;
    }

    public void findViews() {
    	
    	btSource2=(ImgTextButton)activity.findViewById(R.id.btSource_sound);
        btSource2.setImgResource(R.mipmap.source);
        btSource2.setText(R.string.str_input_source_title);
         btSource2.setFocusable(false);   
       
        btPicture2=(ImgTextButton)activity.findViewById(R.id.btPicture_sound);     
		    btPicture2.setImgResource(R.mipmap.picture);
        btPicture2.setText(R.string.str_pic_picture);
        btPicture2.setFocusable(false);
        
        btSound2=(ImgTextButton)activity.findViewById(R.id.btSound_sound);
        btSound2.setImgResource(R.mipmap.sound);
        btSound2.setText(R.string.str_sound_sound_adjustment);
        btSound2.setBackgroundResource(R.mipmap.menu_icon_select);
          btSound2.setFocusable(false);   
       
        btChannel2=(ImgTextButton)activity.findViewById(R.id.btchannel_sound);
        btChannel2.setImgResource(R.mipmap.channel);
        btChannel2.setText(R.string.str_cha_channel);
        btChannel2.setFocusable(false);
        
        btSetting2=(ImgTextButton)activity.findViewById(R.id.btSetting_sound);
        btSetting2.setImgResource(R.mipmap.setting);
        btSetting2.setText(R.string.str_set_setting);
          btSetting2.setFocusable(false);   


    }


}
