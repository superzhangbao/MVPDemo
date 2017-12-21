package com.lvshuichuxing.mvpdemo;

import android.os.SystemClock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张宝 on 2017/12/21.
 */

public class LoginModle implements Contract.Modle {
    private List<String> data = new ArrayList<>();
    @Override
    public void loadData(final OnLoadDataListener onLoadDataListener) {
        //TODO 获取数据
        onLoadDataListener.onLoadStart();
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(3000);
                data.add("1");
                data.add("2");
                data.add("3");
                data.add("4");
                onLoadDataListener.onLoadComplete(data);
            }
        }).start();
    }

    @Override
    public void loadData2(final OnLoadDataListener onLoadDataListener) {
        onLoadDataListener.onLoadStart();
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(3000);
                data.add("5");
                data.add("6");
                data.add("7");
                data.add("8");
                onLoadDataListener.onLoadComplete(data);
            }
        }).start();
    }
}
