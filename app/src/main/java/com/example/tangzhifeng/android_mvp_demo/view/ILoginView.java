package com.example.tangzhifeng.android_mvp_demo.view;

import com.example.tangzhifeng.android_mvp_demo.been.User;

/**
 * Created by TangZhiFeng on 2016/10/29.
 */

public interface ILoginView {
    String getUserName();
    String getPassWord();

    void clearUserName();
    void clearPassWord();

    void showLoading();
    void hideLoading();

    void toMainActivity(User user);
    void showFailedError();

}
