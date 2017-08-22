package test.weiguang.cn.demo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2017/8/10.
 */

public class TestView4 extends View {
    private int centerX;
    private int centerY;
    private Paint mPaint;
    private PointF mStart;
    private PointF mEnd;
    private PointF mControl;

    public TestView4(Context context) {
        super(context);
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(8);
        mPaint.setTextSize(30);

        mStart = new PointF(0, 0);
        mEnd = new PointF(0, 0);
        mControl = new PointF(0, 0);


    }

    public TestView4(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
        centerY = h / 2;
        Log.e("WG", "onSizeChanged: " + centerX);
        mStart.x = centerX -200;
        mStart.y = centerY;
        mEnd.x = centerX + 200;
        mEnd.y = centerY;
        mControl.x = centerX;
        mControl.y = centerY - 100;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mControl.x = event.getX();
        mControl.y = event.getY();
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(20);
        canvas.drawPoint(mStart.x, mStart.y, mPaint);
        canvas.drawPoint(mEnd.x, mEnd.y, mPaint);
        canvas.drawPoint(mControl.x, mControl.y, mPaint);
        mPaint.setStrokeWidth(4);
        canvas.drawLine(mStart.x, mStart.y, mControl.x, mControl.y, mPaint);
        canvas.drawLine(mEnd.x, mEnd.y, mControl.x, mControl.y, mPaint);

        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(8);
        Path path = new Path();
        path.moveTo(mStart.x, mStart.y);
        path.quadTo(mControl.x, mControl.y, mEnd.x, mEnd.y);
        canvas.drawPath(path, mPaint);
    }
}
