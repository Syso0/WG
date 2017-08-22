package test.weiguang.cn.demo;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/14.
 */

public class UniversalAdapter extends RecyclerView.Adapter {
    public ArrayList<SwipeCardBean> mData;
    public Context context;
    private Bitmap mBitmap;
    private int positionId;
    private Paint mPaint;

    public UniversalAdapter(Context context, ArrayList<SwipeCardBean> mlist) {
        this.context = context;
        this.mData = mlist;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, null);
        UniversalViewHolder holder = new UniversalViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final UniversalViewHolder holder1 = (UniversalViewHolder) holder;
//        mBitmap = BitmapFactory.decodeResource(context.getResources(), mData.get(position).resoutimage);
        holder1.recy_item_im.setImageResource(mData.get(position).resoutimage);
//        holder1.recy_item_im.setImageBitmap(changeImage());
        holder1.recy_item_tv.setText(mData.get(position).title);
//        holder1.recy_item_im.setFocusableInTouchMode(true);
//        holder1.recy_item_im.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                Animation animation = AnimationUtils.loadAnimation(context, R.anim.anim);
//                switch (motionEvent.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        Log.e("WG", "onTouch: 触摸了么：：" + position);
////                        changeImage(view);
////                        animation.setFillAfter(true);
////                        view.startAnimation(animation);
//                        break;
//                    case MotionEvent.ACTION_MOVE:
////                        animation.setFillAfter(true);
////                        view.startAnimation(animation);
//                        break;
//                    case MotionEvent.ACTION_UP:
////                        view.startAnimation(animation);
////                        changeImage(view);
//                        break;
//                }
//                return false;
//            }
//        });
        if (mOnItemClickListener != null) {
            holder1.recy_item_im.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e("WG", "onClick:+++++++: " + position);
                    mOnItemClickListener.onItemClick(view, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }


    public class UniversalViewHolder extends RecyclerView.ViewHolder {
        public TextView recy_item_tv;
        public ImageView recy_item_im;

        public UniversalViewHolder(View itemView) {
            super(itemView);
            recy_item_im = (ImageView) itemView.findViewById(R.id.iv);
            recy_item_tv = (TextView) itemView.findViewById(R.id.tv2);
        }

    }

    private void changeImage(View view) {
        ObjectAnimator ROTATION_X = ObjectAnimator.ofFloat(view, View.ROTATION_X, 0);
        ROTATION_X.setDuration(500);
        ROTATION_X.start();
        ObjectAnimator ROTATION = ObjectAnimator.ofFloat(view, View.ROTATION, 0);
        ROTATION.setDuration(500);
        ROTATION.start();
//        ObjectAnimator SCALE_X = ObjectAnimator.ofFloat(view, View.SCALE_X, 1.5f);
//        SCALE_X.setDuration(500);
//        SCALE_X.start();
//        ObjectAnimator SCALE_Y = ObjectAnimator.ofFloat(view, View.SCALE_Y, 1.5f);
//        SCALE_Y.setDuration(500);
//        SCALE_Y.start();

    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}
