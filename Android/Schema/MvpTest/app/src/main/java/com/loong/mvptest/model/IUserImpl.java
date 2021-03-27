package com.loong.mvptest.model;

import com.loong.mvptest.bean.User;

public class IUserImpl implements IUserModel {
    @Override
    public void login(String userName, String userPassword, OnLoginListener onLoginListener) {
        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if ("jack".equals(userName) && "123".equals(userPassword)) {
                User mUser = new User();
                mUser.setUserName(userName);
                mUser.setUserPassword(userPassword);
                onLoginListener.loginSuccess(mUser);
            } else {
                onLoginListener.loginFailed();
            }
        }).start();
    }
}
