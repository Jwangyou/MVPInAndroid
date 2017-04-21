package jwy.mvpinandroid.presenter;

import android.os.Handler;

import jwy.mvpinandroid.bean.User;
import jwy.mvpinandroid.biz.IUserBiz;
import jwy.mvpinandroid.biz.OnLoginListener;
import jwy.mvpinandroid.biz.UserBiz;
import jwy.mvpinandroid.view.IUserLoginView;

/**
 * Created by Administrator on 2017/4/17.
 * 主要业务处理类
 */

public class UserLoginPresenter {
    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView)
    {
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz();
    }

    public void login()
    {
        userLoginView.showLoading();//进度条显示省略

        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener()
        {
            @Override
            public void loginSuccess(final User user)
            {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        userLoginView.toSuccessActivity(user);
                        userLoginView.hideLoading();//进度条隐藏 省略
                    }
                });

            }

            @Override
            public void loginFailed()
            {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        userLoginView.showFailedError();

                        userLoginView.hideLoading();//进度条隐藏 省略
                    }
                });

            }
        });
    }

    public void clear()
    {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }


}
