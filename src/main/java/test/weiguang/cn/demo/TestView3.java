package test.weiguang.cn.demo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/8/9.
 */

public class TestView3 extends View {

    private String mString = "123456789";
    private int kuan;
    private int gao;


    public TestView3(Context context) {
        super(context);
    }

    public TestView3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.kuan = w;
        this.gao = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);

//        canvas.drawText(mString, kuan / 2, gao / 2,paint);
        canvas.translate(kuan / 2, gao / 2);
        canvas.scale(1, -1);
        Path path = new Path();
        path.lineTo(100,100);
        RectF rect =new RectF(0,0,300,300);
        path.arcTo(rect,0,270);
//        path.addArc(rect,0,270);

//        Path pat = new Path();
//        path.addRect(-100, -100, 100, 100, Path.Direction.CW);
//        pat.addCircle(0, 0, 100, Path.Direction.CW);

//        path.addPath(pat, 0, 100);
//        paint.setColor(Color.BLACK);

//        path.setLastPoint(-200,200);

//        path.lineTo(200, 200);
//        path.moveTo(200, 100);
//        path.setLastPoint(200, 100);
//        path.lineTo(200, 0);
//        path.close();
//        path.lineTo(200, 0);

        canvas.drawPath(path, paint);
    }
}
