package com.example.tangzhifeng.android_mvp_demo.biz;

import com.example.tangzhifeng.android_mvp_demo.been.User;

/**
 * Created by TangZhiFeng on 2016/10/29.
 */

public class UserBiz implements IUserBiz {
    @Override
    public void login(final String username, final String password, final OnLoginListener onLoginListener) {
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(username.equals("tzf")&&"123".equals(password))
                {
                    User user=new User(username,password);
                    onLoginListener.loginSuccess(user);
                }else{
                    onLoginListener.loginFaild();
                }
            }
        }.start();
    }
}
