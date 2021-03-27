package com.loong.mvptest.model;

public interface IUserModel {
    //MVP模式的Model层，用来处理业务逻辑
    public void login(String userName,String userPassword,OnLoginListener onLoginListener);
}
