package com.example.tangzhifeng.android_mvp_demo.presenter;

import android.os.Handler;

import com.example.tangzhifeng.android_mvp_demo.been.User;
import com.example.tangzhifeng.android_mvp_demo.biz.IUserBiz;
import com.example.tangzhifeng.android_mvp_demo.biz.OnLoginListener;
import com.example.tangzhifeng.android_mvp_demo.biz.UserBiz;
import com.example.tangzhifeng.android_mvp_demo.view.ILoginView;

/**
 * Created by TangZhiFeng on 2016/10/29.
 * 这里主要充当一个中间人的作用，将View与Model之间进行操作。
 */

public class UserLoginPresenter {
    //这个是Model的代表
    private IUserBiz userBiz;
    //这个是View的代表
    private ILoginView loginView;

    private Handler mHandle=new Handler();

    //传递一个loginView
    public UserLoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
        //Model代表人员早在先前就已经准备好了
        userBiz=new UserBiz();
    }
    /**
     * 下面有两个方法主要是将两个Button的操作直接封装完成，然后直接使用
     * */

    //这个是login按钮
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
    //这个是clear按钮
    public void clear()
    {
        loginView.clearPassWord();
        loginView.clearUserName();
    }
}
