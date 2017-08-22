package test.weiguang.cn.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRlview;
    private ArrayList<SwipeCardBean> mList;
    private int[] mCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        setData();
    }


    private void initView() {
        mRlview = (RecyclerView) findViewById(R.id.rlview);
        mList = new ArrayList<>();

    }

    private void initData() {
        mCard = new int[]{R.drawable.e, R.drawable.f, R.drawable.g};
        for (int i = 0; i < 3; i++) {
            SwipeCardBean swipeCardBean = new SwipeCardBean();
            swipeCardBean.resoutimage = mCard[i];
            swipeCardBean.title = "图片" + i;
            mList.add(swipeCardBean);
        }
    }

    private void setData() {
        CardLayoutManage cardLayoutManage = new CardLayoutManage(this);
        mRlview.setLayoutManager(cardLayoutManage);
        UniversalAdapter universalAdapter = new UniversalAdapter(this, mList);
//        universalAdapter.setOnItemClickListener(this);
        mRlview.setAdapter(universalAdapter);
    }

}
