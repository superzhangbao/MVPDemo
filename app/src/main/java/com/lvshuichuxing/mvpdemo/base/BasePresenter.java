package com.lvshuichuxing.mvpdemo.base;

import java.lang.ref.WeakReference;

/**
 * Created by 张宝 on 2017/12/22.
 */

public class BasePresenter<T> {

    //view的引用
    protected WeakReference<T> mWeakReference;
    protected T view;

    /**
     * 绑定
     */
    void attachView(T t) {
        mWeakReference = new WeakReference<>(t);
        view = mWeakReference.get();
    }

    /**
     * 解绑
     */
    void detachView() {
        mWeakReference.clear();
    }
}
