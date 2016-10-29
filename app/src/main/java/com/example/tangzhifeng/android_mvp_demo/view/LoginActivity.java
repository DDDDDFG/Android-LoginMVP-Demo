package com.example.tangzhifeng.android_mvp_demo.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.tangzhifeng.android_mvp_demo.R;
import com.example.tangzhifeng.android_mvp_demo.been.User;
import com.example.tangzhifeng.android_mvp_demo.presenter.UserLoginPresenter;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    public static final String TAG = "tzf";
    @InjectView(R.id.id_edit_username)
    EditText idEditUsername;
    @InjectView(R.id.id_edit_password)
    EditText idEditPassword;
    @InjectView(R.id.id_btn_login)
    Button idBtnLogin;
    @InjectView(R.id.id_btn_clear)
    Button idBtnClear;
    @InjectView(R.id.activity_main)
    LinearLayout activityMain;
    @InjectView(R.id.id_pb_loading)
    ProgressBar idPbLoading;

    UserLoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        loginPresenter=new UserLoginPresenter(this);

    }


    @OnClick({R.id.id_btn_login, R.id.id_btn_clear})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_btn_login:
                loginPresenter.login();
                break;
            case R.id.id_btn_clear:
                loginPresenter.clear();
                break;
        }
    }

    @Override
    public String getUserName() {
        return idEditUsername.getText().toString();
    }

    @Override
    public String getPassWord() {
        return idEditPassword.getText().toString();
    }

    @Override
    public void clearUserName() {
        idEditUsername.setText("");
    }

    @Override
    public void clearPassWord() {
        idEditPassword.setText("");
    }

    @Override
    public void showLoading() {
        idPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        idPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) {
        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this, "账号或者密码错误！", Toast.LENGTH_SHORT).show();
    }


}
