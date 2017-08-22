package test.weiguang.cn.demo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/8/8.
 */

public class TestView2 extends View {

    private Picture mPicture = new Picture();
    private static final int NULL = 0;
    private static final int START = 1;
    private static final int END = 2;
    private int mWidth;
    private int mHeight;
    private Bitmap mBitmap;
    private Handler mHandler;
    private int page = -1;
    private int max = 15;
    private int anim = 500;
    private int animState = NULL;
    private boolean isCheck = false;

    public TestView2(Context context) {
        super(context);

    }

    public TestView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        recording(context);
        check();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.mWidth = w;
        this.mHeight = h;
    }

    private void recording(Context context) {
        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.shu);

        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (page < max && page >= 0) {
                    invalidate();
                    if (animState == NULL)
                        return;
                    if (animState == START) {
                        page++;
                    } else if (animState == END) {
                        page--;
                    }
                    this.sendEmptyMessageDelayed(0, anim / max);
                } else {
                    if (isCheck) {
                        page = max - 1;
                    } else {
                        page = -1;
                    }
                    invalidate();
                    animState = NULL;
                }
            }
        };

//        // 开始录制
//        Canvas canvas = mPicture.beginRecording(500, 500);
//        // 创建一个画笔
//        Paint paint = new Paint();
//        paint.setColor(Color.RED);
//        paint.setStyle(Paint.Style.FILL);
//        // 在Canvas中具体操作
//        canvas.translate(250, 250);
//        // 绘制一个圆
//        canvas.drawCircle(0, 0, 100, paint);
//        //结束录制
//        mPicture.endRecording();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawBitmap(mBitmap, new Matrix(), new Paint());
//        canvas.drawBitmap(mBitmap, 100, 200, new Paint());
        canvas.translate(mWidth / 2, mHeight / 2);
        int height = mBitmap.getHeight();
        Rect rect = new Rect(height * page, 0, height * (page + 1), height);
        Rect rect1 = new Rect(-200, -200, 200, 200);
        canvas.drawBitmap(mBitmap, rect, rect1, null);

//        canvas.drawPicture(mPicture, new RectF(0, 0, mPicture.getWidth(), 200));
//        mPicture.draw(canvas);

//        PictureDrawable pictureDrawable = new PictureDrawable(mPicture);
//        pictureDrawable.setBounds(0, 0, 250, mPicture.getHeight());
//        pictureDrawable.draw(canvas);
    }

    public void check() {
        if (animState != NULL || isCheck)
            return;
        animState = START;
        page = 0;
        mHandler.sendEmptyMessageDelayed(0, anim / max);
        isCheck = true;
    }

    public void setAnim(int anim) {
        this.anim = anim;
        if (anim <= 0) {
            return;
        }
    }
}
