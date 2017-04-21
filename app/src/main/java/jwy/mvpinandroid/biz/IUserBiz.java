package jwy.mvpinandroid.biz;

/**
 * Created by Administrator on 2017/4/17.
 * biz层User功能业务接口定义类
 *
 */

public interface IUserBiz {
    public void login(String account,String pwd, OnLoginListener loginListener);//登录方法
}
