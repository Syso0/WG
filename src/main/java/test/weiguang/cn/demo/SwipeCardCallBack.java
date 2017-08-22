package test.weiguang.cn.demo;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by Administrator on 2017/8/14.
 */

public class SwipeCardCallBack extends ItemTouchHelper.SimpleCallback {

    public SwipeCardCallBack(int dragDirs, int swipeDirs) {
        super(dragDirs, swipeDirs);
    }

    public SwipeCardCallBack() {
        /*
        * 即我们对哪些方向操作关心。如果我们关心用户向上拖动，可以将
         填充swipeDirs参数为LEFT | RIGHT 。0表示从不关心。
        * */
        super(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.UP |
                        ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN
        );
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }
}
