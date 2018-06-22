package com.lzk.customviewtest2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by huqun on 2018/6/22.
 */

public class CustomViewGroupTest1 extends FrameLayout {
    private ImageView imageView;
    private TextView textView;
    private TextView imageOption;
    private RelativeLayout mRelativeLayout;

    private int titleTextColor;
    private int backgroundColor;

    public CustomViewGroupTest1(Context context) {
        super(context);
        initView(context);
    }

    public CustomViewGroupTest1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.CustomViewGroupTest1);
        titleTextColor=typedArray.getColor(R.styleable.CustomViewGroupTest1_titleTextColor, Color.BLACK);
        backgroundColor=typedArray.getColor(R.styleable.CustomViewGroupTest1_backgroundColor,Color.GREEN);
        typedArray.recycle();
        initView(context);
    }

    private void initView(Context context){
        LayoutInflater.from(context).inflate(R.layout.custom_viewgroup,this);
        imageView=findViewById(R.id.custom_view_group_img);
        textView=findViewById(R.id.custom_view_group_text);
        imageOption=findViewById(R.id.custom_view_group_option);
        mRelativeLayout=findViewById(R.id.custom_view_group_background);
    }

    public void setTitleTextColor(int color){
        titleTextColor=color;
        textView.setTextColor(titleTextColor);
    }

    public void setTitleBackgroundColor(int color){
        backgroundColor=color;
        mRelativeLayout.setBackgroundColor(backgroundColor);
    }

    public String getTitle(){
        return textView.getText().toString();
    }

    public void setTitleClickListener(OnClickListener listener){
        textView.setOnClickListener(listener);
    }

}
