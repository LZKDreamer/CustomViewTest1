package com.lzk.customviewtest2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by huqun on 2018/6/22.
 */

public class CustomView extends View {

    private Paint mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint newPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
    private int customBackgroundColor;

    public CustomView(Context context) {
        super(context);
        initPaint();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.CustomView);
        customBackgroundColor=typedArray.getColor(R.styleable.CustomView_customBackgroundColor,Color.BLUE);
        typedArray.recycle();
        initPaint();
    }

    private void initPaint(){
        mPaint.setColor(customBackgroundColor);
        mPaint.setStrokeWidth(5f);
        newPaint.setColor(Color.RED);
        newPaint.setStrokeWidth(3);
        newPaint.setTextSize(30);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        /*处理wrap_content属性*/
        int widthSpecMode=MeasureSpec.getMode(widthMeasureSpec);
        int heightSpecMode=MeasureSpec.getMode(heightMeasureSpec);
        int widthSpecSize=MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecSize=MeasureSpec.getSize(heightMeasureSpec);

        if (widthSpecMode==MeasureSpec.AT_MOST&&heightSpecMode==MeasureSpec.AT_MOST){
            setMeasuredDimension(200,200);//设置默认大小
        }else if (widthSpecMode==MeasureSpec.AT_MOST){//当宽度为wrap_content时设置宽度默认大小
            setMeasuredDimension(200,heightSpecSize);
        }else if (heightSpecMode==MeasureSpec.AT_MOST){//当高度为wrap_content时设置高度默认大小
            setMeasuredDimension(widthSpecSize,200);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /*处理padding属性*/
        int paddingLeft=getPaddingLeft();
        int paddingRight=getPaddingRight();
        int paddingTop=getPaddingTop();
        int paddingBottom=getPaddingBottom();
        int width=getWidth()-paddingLeft-paddingRight;
        int height=getHeight()-paddingBottom-paddingTop;
        canvas.drawRect(0+paddingLeft,0+paddingTop,width+paddingLeft,height+paddingTop,mPaint);


        canvas.drawText("继承自View",10,height/2,newPaint);
    }

    public void setCustomBackgroundColor(int color){
        customBackgroundColor=color;
        initPaint();
    }

    public interface OnCustomViewClickListener{
        void onCustomViewClicked();
    }

    private OnCustomViewClickListener mClickListener;

    public void setCustomViewClickListener(OnCustomViewClickListener listener){
        mClickListener=listener;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (mClickListener!=null){//为空说明没有注册点击事件
                    mClickListener.onCustomViewClicked();
                }
                break;
        }
        return super.onTouchEvent(event);
    }
}
