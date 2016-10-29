# Android-LoginMVP-Demo

文/大大大大峰哥


------------

在自学Android开发的道路上也行走了一小段路咯，最近看到了MVP框架，每个人看完都会有不一样的看法，所以我也谈谈我对MVP的一些看法，同时
分享一下我是如何学习了解MVP的。
![](http://upload-images.jianshu.io/upload_images/925416-c9f8fa9e379923fa.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
我们来了解MVP，我是通过一个登录的Demo来了解的。

**我主要从流程中来带大家了解我们该如果使用MVP，不讲理论因为我也不知道**。
**我主要从流程中来带大家了解我们该如果使用MVP，不讲理论因为我也不知道**。
**我主要从流程中来带大家了解我们该如果使用MVP，不讲理论因为我也不知道**。





## 1 流程

通过流程这样可能更好理解，而且通过我这个流程，自己动手走一遍玩一玩，这样我觉得效果更好。

-----

### 1.1 大纲
1. 首先完成User Been文件的创建，在这里面，我们只需要要User的serget方法。
2. 接着思考User有什么业务，并将这些业务统统添加进入IUserBiz接口中。
3. 每一个业务逻辑都有一个附带的Listener，这个Listener中有执行这个业务后会发生的事情。
4. 然后UserBiz 将 IUserBiz中的功能实现。
5. 对应的View（Activity）中的功能写一个 接口出来。
6. 对应的View（Activity）实现接口。
7. 实现Presenter，Presenter的作用就是将View与Model进行连接。


----


### 1.2 问题
主要是将我的思路是怎么走的与大家进行一个分享。

### 1.2.1 User Been的创建
仔细看我上面那个登录界面，然后回答：

- 根据上面的图片如果是你创建一个User，里面有什么属性？
- 然后你想象我们有登录与清除的功能，那你的User中需要有什么方法？

### 1.2.2 IUserBiz接口的创建
思考：我们已经有一个User Been了，我们需要用这个User进行什么操作？
并将User即将进行的操作写为抽象方法。

### 1.2.3 附带的Listener创建
思考：我们之前创建的IUserBiz接口中的方法有哪种情况会发生？
并将可能会出现的情况进行写入抽象Listener中去。

### 1.2.4 创建UserBiz直接实现IUserBiz
就是将方法实现。

### 1.2.5 将View（Activity）中的功能写入接口
仔细看我上面那个登录界面，然后回答：
- Activity中有两个Button，点击一下会进行什么操作？
- 操作过程中会发生什么情况，并将情况转换成对应的方法。


### 1.2.6 将View（Activity）连接创建好的接口并实现
根据接口并实现。

### 1.2.7 实现Presenter
在MVP中Presenter将Model与View进行一个连接，在这个地方的Presenter属于一个中间人的传话的效果。
那么在这个Presenter类中，主要就是图中Button的方法，也就是一个login方法，一个clear方法，具体实现还是将之前所实现的接口进行一个方法对接。
**这个地方看不懂没有关系，第七步需要看代码了解同时了解什么是MVP**

----
## 1.3 解答
这七个问题中，不一定要按我的回答来实现，大家可以用别的思路去想问题。

### 1.3.1 User Been的创建
仔细看我上面那个登录界面，然后回答：

- 根据上面的图片如果是你创建一个User，里面有什么属性？
- 然后你想象我们有登录与清除的功能，那你的User中需要有什么方法？

```
回答：
1.User有userName与password两个属性。
2.userName与password拥有setget方法即可。
```
### 1.3.2 IUserBiz接口的创建
思考：我们已经有一个User Been了，我们需要用这个User进行什么操作？
并将User即将进行的操作写为抽象方法。
```
回答：
User需要有一个login的功能，这个功能中我们需要将我们的账号密码传递进
去，同时还有一个Listener需要监听login的情况，在下面就是Listener的创
建了。
```


### 1.3.3 附带的Listener创建
思考：我们之前创建的IUserBiz接口中的方法有哪种情况会发生？
并将可能会出现的情况进行写入抽象Listener中去。

```
回答：
以前接口中主要实现了一个login的功能，这个功能会有两种可能发生，第一
种就是登录成功，第二种就是登录失败。
```

### 1.3.4 创建UserBiz直接实现IUserBiz
就是将方法实现。

```
这个就不解释了。
```

### 1.3.5 将View（Activity）中的功能写入接口
仔细看我上面那个登录界面，然后回答：
- Activity中有两个Button，点击一下会进行什么操作？
- 操作过程中会发生什么情况，并将情况转换成对应的方法。
```
回答：
1.点击login会有登录成功或者登录失败，在这里登录需要获取Edit的信息。
2.点击clear会清除EditView。
那么方法如下：
登录成功方法
登录失败方法
获取UserName
获取PassWord
清除Edit框
```

### 1.3.6 将View（Activity）连接创建好的接口并实现
根据接口并实现。

```
这个就不解释了。
```

### 1.3.7 实现Presenter
在MVP中Presenter将Model与View进行一个连接，在这个地方的Presenter属于一个中间人的传话的效果。
那么在这个Presenter类中，主要就是图中Button的方法，也就是一个login方法，一个clear方法，具体实现还是将之前所实现的接口进行一个方法对接。
**这个地方看不懂没有关系，第七步需要看代码了解同时了解什么是MVP**

```
//直接用代码解释了
package com.example.tangzhifeng.android_mvp_demo.presenter;

import android.os.Handler;

import com.example.tangzhifeng.android_mvp_demo.been.User;
import com.example.tangzhifeng.android_mvp_demo.biz.IUserBiz;
import com.example.tangzhifeng.android_mvp_demo.biz.OnLoginListener;
import com.example.tangzhifeng.android_mvp_demo.biz.UserBiz;
import com.example.tangzhifeng.android_mvp_demo.view.ILoginView;

*/**
 * Created by TangZhiFeng on 2016/10/29.
 * **这里主要充当一个中间人的作用，将**View**与**Model**之间进行操作。
 ***/

*public class UserLoginPresenter {
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
    */**
     * **下面有两个方法主要是将两个**Button**的操作直接封装完成，然后直接使用
     *** */
   
    *//这个是login按钮
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
```

##


## 2 作者有话说
我主要是通过这篇博文让我理解了MVP[浅谈 MVP in Android](http://blog.csdn.net/lmj623565791/article/details/46596109)，那我为什么还写呢，因为我想和大家分析下我是如何一步一步的实现的，对MVP原理有疑问的可以留言，我尽力而为，但是我也是小白，大家共同学习吧，在周六的日子码了这么多字也码了大几个小时，希望大家点个喜欢，你的喜欢可以让我知道没有白白码字。


## 3 干货
我的源码：[GitHub](https://github.com/DDDDDFG/Android-LoginMVP-Demo)
