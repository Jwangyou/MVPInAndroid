package jwy.mvpinandroid.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/17.
 * 实体User类
 */

public class User implements Serializable {
    String account;//登录账号
    String passwrod;//登录密码

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPasswrod() {
        return passwrod;
    }

    public void setPasswrod(String passwrod) {
        this.passwrod = passwrod;
    }
}
