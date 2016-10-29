package com.example.tangzhifeng.android_mvp_demo.presenter;

import android.os.Handler;

import com.example.tangzhifeng.android_mvp_demo.been.User;
import com.example.tangzhifeng.android_mvp_demo.biz.IUserBiz;
import com.example.tangzhifeng.android_mvp_demo.biz.OnLoginListener;
import com.example.tangzhifeng.android_mvp_demo.biz.UserBiz;
import com.example.tangzhifeng.android_mvp_demo.view.ILoginView;


/**
 * Created by TangZhiFeng on 2016/10/29.
 */

public class UserLoginPresenter {
    private IUserBiz userBiz;
    private ILoginView loginView;
    private Handler mHandle=new Handler();

    public UserLoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
        userBiz=new UserBiz();
    }

    public void login()
    {
        loginView.showLoading();
        userBiz.login(loginView.getUserName(), loginView.getPassWord(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                mHandle.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.toMainActivity(user);
                        loginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFaild() {
                mHandle.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.showFailedError();
                        loginView.hideLoading();
                    }
                });
            }
        });
    }

    public void clear()
    {
        loginView.clearPassWord();
        loginView.clearUserName();
    }
}
