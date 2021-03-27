package com.loong.mvptest.mvpschema;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.loong.mvptest.R;
import com.loong.mvptest.bean.User;
import com.loong.mvptest.presenter.UserLoginPresenter;
import com.loong.mvptest.view.IUserView;

public class MainActivity extends AppCompatActivity implements IUserView {
    private Button mBtnLogin, mBtnReset;
    private EditText mETUserName, mETUserPassword;
    private ProgressBar mPBLoading;
    private final UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();
        mBtnLogin.setOnClickListener(v -> mUserLoginPresenter.doLogin());
        mBtnReset.setOnClickListener(v -> mUserLoginPresenter.doReset());
    }

    private void initWidgets() {
        mBtnLogin = findViewById(R.id.btn_login);
        mBtnReset = findViewById(R.id.btn_reset);
        mETUserName = findViewById(R.id.et_username);
        mETUserPassword = findViewById(R.id.et_password);

        mPBLoading = findViewById(R.id.pg_loading);
    }

    @Override
    public String getUserName() {
        return mETUserName.getText().toString();
    }

    @Override
    public String getUserPassword() {
        return mETUserPassword.getText().toString();
    }

    @Override
    public void showProgressDialog() {
        mPBLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressDialog() {
        mPBLoading.setVisibility(View.INVISIBLE);
    }

    @Override
    public void gotoMainView(User mUser) {
        Toast.makeText(this, mUser.getUserName() + " login success , to MainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, "login failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearUserName() {
        mETUserName.setText("");
    }

    @Override
    public void clearPassword() {
        mETUserPassword.setText("");
    }
}
