package com.kjd.flbui.holder;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import com.kjd.flbui.R;
import com.kjd.flbui.ui.ImgTextButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SourceViewHolder {
	private static final String TAG="SourceViewHolder";
        // ===== add by zhh 20160523 ===== //
    private int mHDMI0_SEL = 81;  //(HDMI2&DP)
    private int mHDMI1_SEL= 80;  //OPS & HDMI3
    private int mVGA_SEL= 82;  //VGA1 & VGA2

        // ===== add end ===== //
    private Activity activity;

	private ImgTextButton btSource;
        private ImgTextButton btPicture;
        private ImgTextButton btSound;  
	private ImgTextButton btChannel;
       private ImgTextButton btSetting;
	
       private GridView gview;
	private List<Map<String, Object>> data_list;
	private SimpleAdapter sim_adapter;

/*
	private int[] icon = { R.drawable.tv, R.drawable.tv,R.drawable.pc, R.drawable.hdmi , R.drawable.hdmi, R.drawable.hdmi,R.drawable.hdmi,R.drawable.av, R.drawable.ypbpr};
	private String[] iconName = { "ATV", "DTV", "VGA", "HDMI1", "HDMI2", "FRONT-HDMI", "PC", "AV", "YPBPR"};
	private int[] inputsouce ={TvCommonManager.INPUT_SOURCE_HDMI3,TvCommonManager.INPUT_SOURCE_HDMI2,TvCommonManager.INPUT_SOURCE_HDMI,
                                                TvCommonManager.INPUT_SOURCE_HDMI3,TvCommonManager.INPUT_SOURCE_VGA,TvCommonManager.INPUT_SOURCE_CVBS};
                                                */
	private int[] icon = { R.mipmap.tv,/*ATV*/
	                               R.mipmap.tv,/*DTV*/
	                               R.mipmap.pc,/*vga*/
	                               R.mipmap.hdmi ,/*HDMI1*/
	                               R.mipmap.hdmi, /*HDMI2*/
	                               R.mipmap.hdmi, /*front-HDMI*/
	                               R.mipmap.hdmi, /*OPS*/
	                               R.mipmap.av,  /*AV*/
	                               R.mipmap.ypbpr, /*YPBPR*/
	                               R.mipmap.media /*MEDIA*/
	                               };
	private int[] iconName = {   
		                                 R.string.str_inputsource_ATV,
		                                 R.string.str_inputsource_DTV,
		                                 R.string.str_inputsource_VGA,
		                                 R.string.str_inputsource_HDMI1,
		                                 R.string.str_inputsource_HDMI2,
		                                 R.string.str_inputsource_FrontHDMI,
		                                 R.string.str_inputsource_OPS,
		                                 R.string.str_inputsource_AV,
		                                 R.string.str_inputsource_YPBPR,
		                                 R.string.str_inputsource_MEDIA,
		                              };

	



	
	private static final int CHANGE_PAGE = 10099;
	protected Handler handler;
	
	public SourceViewHolder(Activity act ,Handler handler) {
        this.activity = act;
        this.handler = handler;
    }
	
	public void findViews() {		
   
	 btSource=(ImgTextButton)activity.findViewById(R.id.btSource_source);
        btSource.setImgResource(R.mipmap.source);
        btSource.setText(R.string.str_input_source_title);
        btSource.setBackgroundResource(R.mipmap.menu_icon_select);
           btSource.setFocusable(false);   

        
        btPicture=(ImgTextButton)activity.findViewById(R.id.btPicture_source);
        btPicture.setImgResource(R.mipmap.picture);
        btPicture.setText(R.string.str_pic_picture);
        btPicture.setOnClickListener(new buttonOnclick());
            btPicture.setFocusable(false);   
       
        btSound=(ImgTextButton)activity.findViewById(R.id.btSound_source);
        btSound.setImgResource(R.mipmap.sound);
        btSound.setText(R.string.str_sound_sound_adjustment);
        btSound.setOnClickListener(new buttonOnclick());
            btSound.setFocusable(false);   
        
        btChannel=(ImgTextButton)activity.findViewById(R.id.btchannel_source);
        btChannel.setImgResource(R.mipmap.channel);
        btChannel.setText(R.string.str_cha_channel);
        btChannel.setOnClickListener(new buttonOnclick());
            btChannel.setFocusable(false);   

        btSetting=(ImgTextButton)activity.findViewById(R.id.btSetting_source);
        btSetting.setImgResource(R.mipmap.setting);
        btSetting.setText(R.string.str_set_setting);
        btSetting.setOnClickListener(new buttonOnclick());
            btSetting.setFocusable(false);   


        
		gview = (GridView) activity.findViewById(R.id.gview);
		gview.setOnItemClickListener(new itemClickListener());
		gview.setOnItemSelectedListener(new itemSelectListener());
		data_list = new ArrayList<Map<String, Object>>();
		getData();
		String[] from ={"image","text"};
		int [] to = {R.id.image,R.id.text};
		sim_adapter = new SimpleAdapter(activity, data_list, R.layout.source_item, from, to);
		gview.setAdapter(sim_adapter);		
	}
	public List<Map<String, Object>> getData(){
		for(int i=0;i<icon.length;i++){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("image", icon[i]);
			//map.put("text", iconName[i]);
			map.put("text", activity.getResources().getString(iconName[i]));
			data_list.add(map);
		}			
		return data_list;
	}
	public void LoadDataToUI() {
	
	}

	private class itemClickListener implements OnItemClickListener
	{

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			Log.i(TAG, "arg2 :" + arg2);
			Log.i(TAG, "arg3 :" + arg3);

		}
		
	}
	private class buttonOnclick implements View.OnClickListener
    {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			boolean haveClick = true;
			int page_num = 0;
			switch(arg0.getId())
			{
				case R.id.btPicture_source:
					page_num = 1;
					break;
				case R.id.btSound_source:
					page_num = 2;
					break;
				case R.id.btchannel_source:

					page_num = 3;
					break;
	    		case R.id.btSetting_source:	
					page_num = 4;
				    break;
				default:
					haveClick = false;
					break;
			}
			if(haveClick)
			{
				Message msg = new Message();
				msg.what = CHANGE_PAGE;
				msg.arg1 = page_num;		
				handler.sendMessage(msg);
			}

		}
    	
    }
	private class itemSelectListener implements OnItemSelectedListener
	{

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
