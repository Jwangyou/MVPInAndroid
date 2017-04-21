package jwy.mvpinandroid.biz;

import jwy.mvpinandroid.bean.User;

/**
 * Created by Administrator on 2017/4/17.
 *需要实现IUserBiz里面的方法
 */

public class UserBiz implements IUserBiz{
    @Override
    public void login(final String account, final String pwd, final OnLoginListener loginListener) {
        //模拟子线程耗时操作
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(1000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("jwy".equals(account) && "123".equals(pwd))
                {
                    User user = new User();
                    user.setAccount(account);
                    user.setPasswrod(pwd);
                    loginListener.loginSuccess(user);
                } else
                {
                    loginListener.loginFailed();
                }
            }
        }.start();

    }
}
