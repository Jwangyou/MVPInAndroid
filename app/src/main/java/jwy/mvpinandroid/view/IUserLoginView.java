package jwy.mvpinandroid.view;

import jwy.mvpinandroid.bean.User;

/**
 * Created by Administrator on 2017/4/17.
 */

public interface IUserLoginView {
    //定义需要的业务接口 ，在activity里面具体实现
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toSuccessActivity(User user);

    void showFailedError();
}
