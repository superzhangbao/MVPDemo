package com.lvshuichuxing.mvpdemo;

import com.lvshuichuxing.mvpdemo.base.BasePresenter;

import java.util.List;

/**
 * Created by 张宝 on 2017/12/21.
 */

public class LoginPresenter<T extends Contract.View> extends BasePresenter<T> implements Contract.Presenter {

    //modle的引用
    private Contract.Modle mLoginModle;

    public LoginPresenter() {
        mLoginModle = new LoginModle();
    }

    @Override
    public void loadData1() {
        if (mLoginModle != null) {
            mLoginModle.loadData(new Contract.Modle.OnLoadDataListener() {
                @Override
                public void onLoadStart() {
                    if (view != null) {
                        view.loading();
                    }
                }

                @Override
                public void onLoadComplete(List<String> data) {
                    if (view != null) {
                        view.show(data);
                    }
                }
            });
        }
    }

    @Override
    public void loadData2(List<String> data) {
        mLoginModle.loadData2(new Contract.Modle.OnLoadDataListener() {
            @Override
            public void onLoadStart() {
                view.getData2Start();
            }

            @Override
            public void onLoadComplete(List<String> data) {
                view.getData2Complete(data);
            }
        });
    }
}
