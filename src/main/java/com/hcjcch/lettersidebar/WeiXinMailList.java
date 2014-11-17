package com.hcjcch.lettersidebar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by hcjcch on 2014/11/17.
 */
public class WeiXinMailList extends View implements View.OnTouchListener {
    private Paint mPaint;
    private CallBack callBack;

    public WeiXinMailList(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        setOnTouchListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        Rect mBounds = new Rect();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        mPaint.setColor(Color.BLACK);
        canvas.drawRect(0, 0, width, height, mPaint);
        float itemHeight = (float) (height / 26 * 1.0);
        for (int i = 0; i < 26; i++) {
            mPaint.setStyle(Paint.Style.FILL);
            String txt = String.valueOf((char) ('A' + i));
            mPaint.setTextSize(60);
            mPaint.getTextBounds(txt, 0, txt.length(), mBounds);
            float textWidth = mBounds.width();
            float textHeight = mBounds.height();
            canvas.drawText(txt, width / 2 - textWidth / 2, itemHeight * i + itemHeight / 2 + textHeight / 2, mPaint);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        double itemHeight = getHeight() / 26 * 1.0;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                float y = event.getY();
                int a = (int) (y / itemHeight);
                callBack.callBack(a);
                break;
            case MotionEvent.ACTION_MOVE:
                float x = event.getY();;
                int b = (int) (x / itemHeight);
                callBack.callBack(b);
                break;
            case MotionEvent.ACTION_UP:
                float z = event.getY();;
                int c = (int) (z / itemHeight);
                callBack.callBack(c);
                break;
        }
        return true;
    }

    interface CallBack {
        void callBack(int yPosition);
    }

    void setInterFace(CallBack callBack) {
        this.callBack = callBack;
    }
}