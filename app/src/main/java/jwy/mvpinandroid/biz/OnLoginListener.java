package jwy.mvpinandroid.biz;

import jwy.mvpinandroid.bean.User;

/**
 * Created by Administrator on 2017/4/17.
 */
public interface OnLoginListener {

    void loginSuccess(User user);//登录成功调用

    void loginFailed();//登录失败调用

}
