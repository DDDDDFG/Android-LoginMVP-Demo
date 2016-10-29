package com.example.tangzhifeng.android_mvp_demo.biz;

import com.example.tangzhifeng.android_mvp_demo.been.User;

/**
 * Created by TangZhiFeng on 2016/10/29.
 */
public interface OnLoginListener {

    public void loginSuccess(User user) ;

    public void loginFaild() ;
}
