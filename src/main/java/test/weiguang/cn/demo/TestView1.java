package test.weiguang.cn.demo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/8/7.
 */

public class TestView1 extends View {
    private static final int LAYER_FLAGS = Canvas.MATRIX_SAVE_FLAG | Canvas.CLIP_SAVE_FLAG
            | Canvas.HAS_ALPHA_LAYER_SAVE_FLAG | Canvas.FULL_COLOR_LAYER_SAVE_FLAG
            | Canvas.CLIP_TO_LAYER_SAVE_FLAG;
    private Paint mPaint = new Paint();
    private int mWidth;
    private int mHeight;
    private Picture mPicture = new Picture();
    public TestView1(Context context) {
        super(context);
    }


    public TestView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        recording();
    }

    private void recording() {
        // 开始录制
        Canvas canvas = mPicture.beginRecording(500, 500);
        // 创建一个画笔
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        // 在Canvas中具体操作
        canvas.translate(250,250);
        // 绘制一个圆
        canvas.drawCircle(0,0,100,paint);
        //结束录制
        mPicture.endRecording();

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawPicture(mPicture, new RectF(0, 0, mPicture.getWidth(), 200));


//        mPaint.setColor(Color.BLACK);
//        mPaint.setStyle(Paint.Style.STROKE);
//        canvas.translate(250, 250);
//        canvas.drawCircle(0, 0, 100, mPaint);
//
//        mPaint.setColor(Color.BLUE);
//        canvas.translate(250, 250);
//        canvas.drawCircle(0, 0, 100, mPaint);


//        RectF rectF = new RectF(-400, -400, 400, 400);
//        canvas.translate(mWidth / 2, mHeight / 2);
//        RectF rectF = new RectF(-400, -400, 400, 400);
//  缩放
//        for (int i = 0; i <= 20; i++) {
//            canvas.scale(0.9f, 0.9f);
//            canvas.drawRect(rectF, mPaint);
//        }
        /**
         * 旋转
         */
//        mPaint.setColor(Color.RED);
//        canvas.translate(mWidth / 2, mHeight / 2);
//        RectF rectF = new RectF(0, -400, 400, 0);
//        canvas.drawRect(rectF, mPaint);
//        canvas.rotate(180);
//        mPaint.setColor(Color.BLUE);
//        canvas.drawRect(rectF, mPaint);
//        mPaint.setColor(Color.BLACK);
//        mPaint.setStyle(Paint.Style.STROKE);
//        canvas.translate(mWidth / 2, mHeight / 2);
//        canvas.drawCircle(0, 0, 380, mPaint);
//        canvas.drawCircle(0, 0, 400, mPaint);
//        for (int i = 0; i <= 360; i += 10) {
//            canvas.drawLine(0, 400, 0, 380, mPaint);
//            canvas.rotate(10);
//        }


//        mPaint.setColor(Color.BLACK);
//        mPaint.setStyle(Paint.Style.STROKE);
//        mPaint.setStrokeMiter(10f);
//        canvas.translate(mWidth / 2, mHeight / 2);
//        RectF rectF = new RectF(0, 0, 200, 200);
//        canvas.drawRect(rectF, mPaint);
//        canvas.skew(1, 0);
//        canvas.skew(0, 1);
//
//        mPaint.setColor(Color.RED);
//        canvas.drawRect(rectF, mPaint);


//        canvas.drawColor(Color.WHITE);
//
//        canvas.translate(10, 10);
//
//        mPaint.setColor(Color.RED);
//        canvas.drawCircle(75, 75, 75, mPaint);
//
//        canvas.saveLayerAlpha(0, 0, 200, 200, 0x88, LAYER_FLAGS);
//
//        mPaint.setColor(Color.BLUE);
//        canvas.drawCircle(125, 125, 75, mPaint);
//
//        canvas.restore();

//        mPaint.setColor(Color.RED);
//        canvas.drawRect(rectF, mPaint);
//        canvas.scale(0.5f, 0.5f);
//        canvas.scale(0.5f, 0.1f);
//        mPaint.setColor(Color.BLUE);
//        canvas.drawRect(rectF, mPaint);


    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.mWidth = w;
        this.mHeight = h;
    }
}
