package test.weiguang.cn.demo;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnticipateInterpolator;

/**
 * Created by Administrator on 2017/8/14.
 */

public class CardLayoutManage extends RecyclerView.LayoutManager implements View.OnClickListener {

    private Context mContext;
    int GAP;
    private float DefalutSp = 60;

    public CardLayoutManage(Context context) {
        this.mContext = context;
//        CardConfig.initConfig(mContext);
    }

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
        detachAndScrapAttachedViews(recycler);
        int count = getItemCount();
        for (int i = count - 1; i >= 0; i--) {
            View viewForPosition = recycler.getViewForPosition(i);
            Log.e("WG", "onLayoutChildren: " + i);
            viewForPosition.setOnClickListener(this);
            viewForPosition.setTag(i);
            addView(viewForPosition);
            measureChildWithMargins(viewForPosition, 0, 0);
            int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
            int decoratedMeasuredHeight = getDecoratedMeasuredHeight(viewForPosition);
            int width = getWidth() - decoratedMeasuredWidth;
            int height = getHeight() - decoratedMeasuredHeight;
            layoutDecoratedWithMargins(viewForPosition, width / 2, 50, width / 2 + decoratedMeasuredWidth, decoratedMeasuredHeight);
            ObjectAnimator ROTATION_X = ObjectAnimator.ofFloat(viewForPosition, View.ROTATION_X, 60);
            ROTATION_X.setDuration(500);
            ROTATION_X.start();
            ObjectAnimator ROTATION = ObjectAnimator.ofFloat(viewForPosition, View.ROTATION, -30);
            ROTATION.setDuration(500);
            ROTATION.start();
            if (i > 0) {
                ObjectAnimator TRANSLATION_Y = ObjectAnimator.ofFloat(viewForPosition, View.TRANSLATION_Y, DefalutSp * i);
                TRANSLATION_Y.setDuration(500);
                TRANSLATION_Y.start();
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View view) {
        int tag = (Integer) view.getTag();
        Log.e("WG", "onClick    : " + tag);
        changeImage(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void changeImage(View v) {
        v.setBackground(null);
        ObjectAnimator ROTATION_X = ObjectAnimator.ofFloat(v, View.ROTATION_X, 0);
        ROTATION_X.setDuration(600);
        ROTATION_X.setStartDelay(500);
        ROTATION_X.start();
        ObjectAnimator ROTATION = ObjectAnimator.ofFloat(v, View.ROTATION, 0);
        ROTATION.setDuration(600);
        ROTATION.setStartDelay(600);
        ROTATION.start();
        ObjectAnimator SCALE_X = ObjectAnimator.ofFloat(v, View.SCALE_Y, 1.5f);
        SCALE_X.setDuration(600);
        ROTATION_X.setStartDelay(1100);
        SCALE_X.start();
        ObjectAnimator SCALE_Y = ObjectAnimator.ofFloat(v, View.SCALE_X, 1.5f);
        SCALE_Y.setDuration(600);
        SCALE_X.setStartDelay(1100);
        SCALE_Y.start();
        int connect = getChildCount();
        for (int i = 0; i < connect; i++) {
            if (getChildAt(i) != v) {
                AnticipateInterpolator anticipateInterpolator = new AnticipateInterpolator();
                ObjectAnimator translationX = ObjectAnimator.ofFloat(getChildAt(i), View.TRANSLATION_X, 200);
                translationX.setDuration(500);
                translationX.setInterpolator(anticipateInterpolator);
                translationX.start();
                ObjectAnimator alpha = ObjectAnimator.ofFloat(getChildAt(i), View.ALPHA, 0);
                alpha.setDuration(500);
                alpha.start();
            }
        }
    }
}
