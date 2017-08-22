package test.weiguang.cn.demo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Administrator on 2017/8/15.
 */

@SuppressLint("AppCompatCustomView")
public class ShearView extends ImageView {
    private int width;
    private int heigth;
    private Paint mPaint= new Paint();
    public ShearView(Context context) {
        super(context);
    }

    public ShearView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        heigth = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
// 将坐标系原点移动到画布正中心
        canvas.translate(width / 2, heigth / 2);
        RectF rect = new RectF(0,0,200,200);   // 矩形区域

        canvas.drawRect(rect,mPaint);

        canvas.skew(1,0);                       // 水平错切 <- 45度
        canvas.drawRect(rect,mPaint);
    }
}
