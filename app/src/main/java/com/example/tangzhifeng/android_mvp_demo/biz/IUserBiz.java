package com.example.tangzhifeng.android_mvp_demo.biz;

/**
 * Created by TangZhiFeng on 2016/10/29.
 */

public interface  IUserBiz {
    public void login(String username,String password,OnLoginListener onLoginListener);
}
