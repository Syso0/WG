package test.weiguang.cn.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2017/8/7.
 */

public class TestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        TestView4 testView4 = new TestView4(this);
//        TestView5 testView5 = new TestView5(this);
//        setContentView(testView5);
        ShearView shearView = new ShearView(this);
        setContentView(shearView);
    }
}
