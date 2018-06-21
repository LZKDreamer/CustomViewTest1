package com.lzk.customviewtest2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by huqun on 2018/6/21.
 */

public class CustomTextView extends android.support.v7.widget.AppCompatTextView{

    private Paint mPaint;
    private int lineColor,lineWidth;

    public CustomTextView(Context context) {
        super(context);
        initPaint();
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaintAndParam(attrs);

    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaintAndParam(attrs);
    }

    private void initPaint(){
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(lineColor);
        mPaint.setStrokeWidth(lineWidth);
    }

    private void initPaintAndParam(AttributeSet attrs){

        TypedArray typedArray=getContext().obtainStyledAttributes(attrs,R.styleable.CustomTextView);
        lineColor=typedArray.getColor(R.styleable.CustomTextView_lineColor,Color.GREEN);
        lineWidth= (int) typedArray.getDimension(R.styleable.CustomTextView_lineWidth, TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP,3,getResources().getDisplayMetrics()));
        typedArray.recycle();
       initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initPaint();//<-----加上此代码，在代码中设置Paint属性才会生效。
        int width=getWidth();
        int height=getHeight();
        canvas.drawLine(0,height/2,width,height/2,mPaint);
    }

    /*暴露给外部使用的方法*/

    public void setLineWidth(int width){
       this.lineWidth=width;
    }

    public void setLineColor(int color){
        this.lineColor=color;
    }

    public interface OnViewClickListener{
         void OnViewClick();
    }

    private OnViewClickListener mClickListener;

    public void setOnViewClickListener(OnViewClickListener listener){
        this.mClickListener=listener;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (mClickListener!=null){
                    mClickListener.OnViewClick();
                }
                break;
        }
        return super.onTouchEvent(event);
    }
}
