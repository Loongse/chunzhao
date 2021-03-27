package com.loong.mvptest.model;

import com.loong.mvptest.bean.User;

public interface OnLoginListener {
    //登录回调方法
    void loginSuccess(User mUser);

    void loginFailed();
}
