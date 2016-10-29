Android-mvp-demo2


#运用MVP进行login操作

##流程：

1. 首先完成User Been文件的创建，在这里面，我们只需要要User的serget方法。

2. 接着思考User有什么业务，并将这些业务统统添加进入IUserBiz接口中。

3. 每一个业务逻辑都有一个附带的Listener，这个Listener中有执行这个业务后会发生的事情。

4. 然后UserBiz 将 IUserBiz中的功能实现。

5. 对应的View（Activity）中的功能写一个 接口出来。

6. 对应的View（Activity）实现接口。

7. 实现Presenter，Presenter的作用就是将View与Model进行连接。

