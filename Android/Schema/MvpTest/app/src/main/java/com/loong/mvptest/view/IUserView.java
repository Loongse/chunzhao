package com.loong.mvptest.view;

import com.loong.mvptest.bean.User;

public interface IUserView {
    //View层
    String getUserName();

    String getUserPassword();

    void showProgressDialog();

    void hideProgressDialog();

    void gotoMainView(User mUser);

    void showErrorMessage();

    void clearUserName();

    void clearPassword();
}
