package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyDraw extends View {
    private Paint pnt;
    private Path path;
    private float X, Y;

    public MyDraw(Context context) {
        super(context);
        init();
    }

    public MyDraw(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void init() {
        pnt = new Paint();
        path = new Path();
        pnt.setColor(Color.BLUE);
        pnt.setStyle(Paint.Style.STROKE);
        pnt.setStrokeWidth(30);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);
                X = x;
                Y = y;
                invalidate();
            case MotionEvent.ACTION_MOVE:
                FreeMove(x, y);
                invalidate();
            case MotionEvent.ACTION_UP:
                path.lineTo(X, Y);
                invalidate();
        }
        return true;
    }

    private void FreeMove(float x, float y) {
        float dx = Math.abs(x - X);
        float dy = Math.abs(y - Y);
        if(dx>=5||dy>=5){
            path.quadTo(X,Y,(x+X)/2,(y+Y)/2);
            X=x;
            Y=y;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, pnt);
    }
}