package com.scofield.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author scofield@tronsis.com
 * @date 2016/10/14 11:07
 */

public class CanvasView extends View {
    Paint mPaint = new Paint();

    private int mWidth;
    private int mHight;

    public CanvasView(Context context) {
        super(context);
    }

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CanvasView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        mPaint.setColor(Color.BLACK);
//        mPaint.setStyle(Paint.Style.FILL);
//        mPaint.setAntiAlias(true);
//
//        canvas.drawCircle(200,200,100,mPaint);
//
//        mPaint.setColor(Color.BLUE);
//        canvas.translate(400,0);
//        canvas.drawCircle(200,200,100,mPaint);
//
//        mPaint.setColor(Color.RED);
//        canvas.scale(100, 100);
//        canvas.drawCircle(200,200,100,mPaint);

         mPaint.setColor(Color.BLUE);
        RectF oval2 = new RectF(60, 100, 200, 240);// 设置个新的长方形，扫描测量
        canvas.drawArc(oval2, 0, 90, true, mPaint);
        // 画弧，第一个参数是RectF：该类是第二个参数是角度的开始，第三个参数是多少度，第四个参数是真的时候画扇形，是假的时候画弧线


        mPaint.setColor(Color.RED);
        Path path=new Path();
        path.moveTo(getWidth()/2,getHeight()/2);
        path.arcTo(new RectF(0,0,200,200),0,180);
        path.close();
        canvas.drawPath(path,mPaint);
    }
}
