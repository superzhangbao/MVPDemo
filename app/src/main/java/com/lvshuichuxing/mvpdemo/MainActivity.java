package com.lvshuichuxing.mvpdemo;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.lvshuichuxing.mvpdemo.base.BaseActivity;

import java.util.List;

public class MainActivity extends BaseActivity<Contract.View,LoginPresenter<Contract.View>> implements Contract.View{

    private TextView mtv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtv = (TextView) findViewById(R.id.textView2);
        presenter.loadData1();
    }

    @Override
    protected LoginPresenter<Contract.View> createPresenter() {
        return new LoginPresenter<>();
    }

    @Override
    public void loading() {
        //TODO 加载进度条
        Toast.makeText(this,"加载进度条",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void show(List<String> data) {
        //TODO 拿到数据进行UI操作
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mtv.setText("拿到数据进行UI操作");
            }
        });
        presenter.loadData2(data);
    }

    @Override
    public void getData2Start() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,"开始拿第二条数据",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void getData2Complete(List<String> data) {
        String a = "";
        for (String s : data) {
            a = a+s;
        }
        final String finalA = a;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mtv.setText(finalA);
            }
        });

    }

}
