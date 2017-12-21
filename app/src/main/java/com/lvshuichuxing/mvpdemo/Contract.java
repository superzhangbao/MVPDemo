package com.lvshuichuxing.mvpdemo;

import java.util.List;

/**
 * Created by 张宝 on 2017/12/22.
 */

public interface Contract {
    interface View {
        void loading();
        void show(List<String> data);

        void getData2Start();

        void getData2Complete(List<String> data);
    }

    interface Presenter{
        void loadData1();
        void loadData2(List<String> data);
    }

    interface Modle {
        void loadData(OnLoadDataListener onLoadDataListener);

        void loadData2(OnLoadDataListener onLoadDataListener);

        interface OnLoadDataListener {
            void onLoadStart();
            void onLoadComplete(List<String> data);
        }
    }
}
