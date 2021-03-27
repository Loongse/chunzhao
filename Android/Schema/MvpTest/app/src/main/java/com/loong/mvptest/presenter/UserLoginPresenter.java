package com.loong.mvptest.presenter;

import android.os.Handler;

import com.loong.mvptest.bean.User;
import com.loong.mvptest.model.IUserImpl;
import com.loong.mvptest.model.IUserModel;
import com.loong.mvptest.model.OnLoginListener;
import com.loong.mvptest.view.IUserView;

public class UserLoginPresenter {
    private IUserModel iUserModel;
    private IUserView iUserView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserView iUserView) {
        this.iUserView = iUserView;
        iUserModel = new IUserImpl();
    }

    public void doLogin() {
        iUserView.showProgressDialog();
        iUserModel.login(iUserView.getUserName(), iUserView.getUserPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User mUser) {
                mHandler.post(() -> {
                    iUserView.gotoMainView(mUser);
                    iUserView.hideProgressDialog();
                });
            }

            @Override
            public void loginFailed() {
                mHandler.post(() -> {
                    iUserView.showErrorMessage();
                    iUserView.hideProgressDialog();
                });
            }
        });
    }

    public void doReset() {
        iUserView.clearUserName();
        iUserView.clearPassword();
    }
}
