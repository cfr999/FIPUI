package com.kjd.flbui.ui;



import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kjd.flbui.R;

public class ImgTextButton extends RelativeLayout {
    
    private ImageView imgView;  
    private TextView  textView;

    public ImgTextButton(Context context) {
        super(context,null);
    }
    
    public ImgTextButton(Context context,AttributeSet attributeSet) {
        super(context, attributeSet);
        
        LayoutInflater.from(context).inflate(R.layout.img_text_button, this,true);
        
        this.imgView = (ImageView)findViewById(R.id.imgview);
        this.textView = (TextView)findViewById(R.id.textview);
        
        this.setClickable(true);
        this.setFocusable(true);
    }
    
    public void setImgResource(int resourceID) {
        this.imgView.setImageResource(resourceID);
    }
    
    public void setText(int resourceID) {
        this.textView.setText(resourceID);
    }
    
    public void setTextColor(int color) {
        this.textView.setTextColor(color);
    }
    
    public void setTextSize(float size) {
        this.textView.setTextSize(size);
    }
    
}