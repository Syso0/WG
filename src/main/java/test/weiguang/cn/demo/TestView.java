package test.weiguang.cn.demo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/3.
 */

public class TestView extends View {

    // 颜色表 (注意: 此处定义颜色使用的是ARGB，带Alpha通道的)
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};
    // 饼状图初始绘制角度
    private float mStartAngle = 0;
    // 数据
    private ArrayList<TestBase> mData;
    // 宽高
    private int mWidth;
    private int mHeight;

    // 画笔
    private Paint mPaint = new Paint();
    private PointF mStartPoint = new PointF(20, 20);
    private PointF mCurrentPoint = new PointF(mStartPoint.x, mStartPoint.y);
    private float mColorRectSideLength = 20;
    private float mTextInterval = 10;
    private float mRowMaxLength;

    public TestView(Context context) {
        super(context);

    }

    public TestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.mWidth = w;
        this.mHeight = h;

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mData == null) {
            return;
        }
        float startangle = mStartAngle;
        canvas.translate(mWidth/2, mHeight/2);
        Log.e("WG", " 宽 " + mWidth);
        Log.e("WG", "GAO " + mHeight);
        float v = (float) (Math.min(mWidth, mHeight) / 2 * 0.8);
        Log.e("WG", "onDraw: " + v);
        RectF rectF = new RectF(-v, -v, v, v);

        for (int i = 0; i < mData.size(); i++) {
            TestBase testBase = mData.get(i);
            mPaint.setColor(testBase.getColor());
            canvas.drawArc(rectF, startangle, testBase.getAngle(), true, mPaint);
            startangle += testBase.getAngle();
            Log.e("WG", "onDraw:startangle:: " + startangle);
            canvas.save();

        }


//        Paint mPaint = new Paint();
//        mPaint.setColor(Color.RED);
//        mPaint.setStyle(Paint.Style.STROKE);
//        mPaint.setStrokeWidth(50f);
//        canvas.drawCircle(200, 200, 100, mPaint);
//
//        mPaint.setStyle(Paint.Style.FILL);
//        canvas.drawCircle(500, 200, 100, mPaint);
//
//        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
//        canvas.drawCircle(800, 200, 100, mPaint);
//        mPaint.setColor(Color.BLUE);
//        mPaint.setStyle(Paint.Style.FILL);
//        mPaint.setStrokeMiter(100f);
//
////        canvas.drawLine(300, 300, 500, 600, mPaint);
////        canvas.drawRect(100, 200, 800, 300, mPaint);
//        RectF rectF = new RectF(300, 100, 600, 200);
//
//        canvas.drawRoundRect(rectF, 300, 350, mPaint);
//        canvas.drawCircle(500, 500, 200, mPaint);
    }

    public void setData(ArrayList<TestBase> data) {
        mData = data;
        init(data);
        invalidate();
    }

    public void init(ArrayList<TestBase> data) {
        // 数据有问题 直接返回
        if (null == mData || mData.size() == 0)  {
            return;
        }
        float sumValue = 0;
        for (int i = 0; i < mData.size(); i++) {
            TestBase pie = mData.get(i);

            sumValue += pie.getValue();       //计算数值和

            Log.e("WG", "shuzhi: " + sumValue);
            int j = i % mColors.length;       //设置颜色
            pie.setColor(mColors[j]);
        }

        float sumAngle = 0;
        for (int i = 0; i < mData.size(); i++) {
            TestBase pie = mData.get(i);

            float percentage = pie.getValue() / sumValue;   // 百分比
            float angle = percentage * 360;                 // 对应的角度

            pie.setPercentage(percentage);                  // 记录百分比
            pie.setAngle(angle);                            // 记录角度大小
            sumAngle += angle;

            Log.e("WG", "" + pie.getAngle());
            Log.e("WG", "init: " + percentage);
        }
    }
}
