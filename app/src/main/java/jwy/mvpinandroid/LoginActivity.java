package jwy.mvpinandroid;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import jwy.mvpinandroid.bean.User;
import jwy.mvpinandroid.presenter.UserLoginPresenter;
import jwy.mvpinandroid.view.IUserLoginView;

public class LoginActivity extends AppCompatActivity implements IUserLoginView {

    private EditText account, pwd;
    private Button tologin;
    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);
    private Lock mLock = new ReentrantLock();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pwd = (EditText) findViewById(R.id.login_pwd);
        init();
    }


    void init() {
        account = (EditText) findViewById(R.id.login_account);
        tologin = (Button) findViewById(R.id.login_btn);

        tologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mUserLoginPresenter.login();

            }
        });

    }

    @Override
    public String getUserName() {
        return account.getText().toString();
    }

    @Override
    public String getPassword() {
        return pwd.getText().toString();
    }

    @Override
    public void clearUserName() {
        account.setText("");
    }

    @Override
    public void clearPassword() {
        pwd.setText("");
    }

    @Override
    public void showLoading() {
        //显示加载进度条，为节省时间次功能暂不实现
    }

    @Override
    public void hideLoading() {
        //隐藏加载进度条，为节省时间次功能暂不实现
    }

    @Override
    public void toSuccessActivity(User user) {
        //传值跳转
        Intent intent = new Intent(LoginActivity.this, LoginSuccessActivity.class);
        Bundle mBundle=new Bundle();
        mBundle.putSerializable("user",user);
        intent.putExtras(mBundle);
        startActivity(intent);

    }

    @Override
    public void showFailedError() {
        Toast.makeText(this, "登录失败", Toast.LENGTH_LONG).show();
    }
}
