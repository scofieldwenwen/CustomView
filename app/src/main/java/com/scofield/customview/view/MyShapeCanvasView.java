package com.scofield.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author scofield@tronsis.com
 * @date 2016/10/13 14:38
 */

public class MyShapeCanvasView extends View {
    private Paint mPaint = new Paint();

    public MyShapeCanvasView(Context context) {
        super(context);
    }

    public MyShapeCanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyShapeCanvasView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initPaint() {
        mPaint.setColor(Color.GRAY);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(20f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initPaint();

        mPaint.setColor(Color.RED);
        canvas.drawPoint(0,0,mPaint);
        canvas.drawPoints(new float[]{20,100,100,100,200,100,300,100},mPaint);

        canvas.drawLine(0,200,800,200,mPaint);

        RectF rectF = new RectF(0, 300, 400, 500);
        canvas.drawRect(rectF,mPaint);

        mPaint.setColor(Color.GRAY);
        canvas.drawRoundRect(rectF,50,50,mPaint);//当rx,ry大于矩形长度的一半时,为椭圆

        RectF rectF1 = new RectF(0,600,400,800);
        mPaint.setColor(Color.BLUE);
        canvas.drawOval(rectF1,mPaint);

        mPaint.setColor(Color.CYAN);
        canvas.drawCircle(200,1100,200,mPaint);

        mPaint.setColor(Color.GRAY);
        RectF rectF2 = new RectF(600, 300, 1000, 700);
        canvas.drawRect(rectF2, mPaint);
        mPaint.setColor(Color.BLUE);
        canvas.drawArc(rectF2,0,90,false,mPaint);

        mPaint.setColor(Color.GRAY);
        RectF rectF3 = new RectF(600, 800, 1000, 1200);
        canvas.drawRect(rectF3, mPaint);
        mPaint.setColor(Color.BLUE);
        canvas.drawArc(rectF3,0,90,true,mPaint);
    }
}
