package com.example.emotiondetector.Utils;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

public class RectOverlay extends GraphicOverlay.Graphic {
    int mRectColor = Color.GREEN;
    float mStrokeWidth = 4.0f;
    Paint mRectPaint;
    GraphicOverlay graphicOverlay;
    Rect rect;


    public RectOverlay(GraphicOverlay overlay, Rect rect) {
        super(overlay);
        mRectPaint = new Paint();
        mRectPaint.setColor(mRectColor);
        mRectPaint.setStyle(Paint.Style.STROKE);
        mRectPaint.setStrokeWidth(mStrokeWidth);

        this.graphicOverlay = graphicOverlay;
        this.rect = rect;

        postInvalidate();
    }

    @Override
    public void draw(Canvas canvas) {

        RectF rectF = new RectF(rect);
        rectF.left = translateY(rectF.left);
        rectF.right = translateY(rectF.right);
        rectF.top = translateY(rectF.top);
        rectF.bottom = translateY(rectF.bottom);

        canvas.drawRect(rectF, mRectPaint);
    }
}
