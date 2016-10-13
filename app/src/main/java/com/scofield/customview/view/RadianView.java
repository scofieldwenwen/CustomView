package com.scofield.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.scofield.customview.RadianBean;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author scofield@tronsis.com
 * @date 2016/10/13 15:57
 */

public class RadianView extends View {
    // 颜色表 (注意: 此处定义颜色使用的是ARGB，带Alpha通道的)
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080, 0xFFE6B800, 0xFF7CFC00};

    private Paint mPaint = new Paint();
    private float mStartAngle = 0;
    private int mWidth, mHeight;

    private ArrayList<RadianBean> mData;

    public RadianView(Context context) {
        super(context);
    }

    public RadianView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    public RadianView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mData == null) {
            return;
        }
        float currentStartAngle = mStartAngle;
        canvas.translate(mWidth / 2, mHeight / 2);
        float r = (float) (Math.min(mWidth, mHeight) / 2 * 0.8);
        RectF rectF = new RectF(-r, -r, r, r);

        for (int i = 0; i < mData.size(); i++) {
            RadianBean radianBean = mData.get(i);

            Random random = new Random();
            int ranColor = 0xff000000 | random.nextInt(0x00ffffff);

            //            mPaint.setColor(radianBean.getColor());
            mPaint.setColor(ranColor);
            canvas.drawArc(rectF, currentStartAngle, radianBean.getAngle(), true, mPaint);
            currentStartAngle += radianBean.getAngle();
        }

    }

    public void setStartAngle(float startAngle) {
        this.mStartAngle = startAngle;
        invalidate();//刷新
    }

    public void setData(ArrayList<RadianBean> data) {
        mData = data;
        initDate(mData);
        invalidate();   // 刷新
    }

    // 初始化数据
    private void initDate(ArrayList<RadianBean> data) {
        if (data == null || data.size() == 0) {
            return;
        }

        float sumValue = 0;
        for (int i = 0; i < data.size(); i++) {
            RadianBean radianBean = mData.get(i);
            sumValue += radianBean.getValue();

            int j = i % mColors.length;
            radianBean.setColor(mColors[j]);
        }

        for (int i = 0; i < data.size(); i++) {
            RadianBean radianBean = mData.get(i);
            float percent = radianBean.getValue() / sumValue;
            float angle = percent * 360;
            radianBean.setAngle(angle);
        }

    }
}
