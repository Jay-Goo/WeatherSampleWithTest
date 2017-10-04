package jaygoo.weathersamplewithtest.model;

import android.text.TextUtils;

import jaygoo.weathersamplewithtest.listener.OnLoginListener;

/**
 * ================================================
 * 作    者：JayGoo
 * 版    本：
 * 创建日期：2017/10/4
 * 描    述: 登录model
 * ================================================
 */
public class LoginModel implements ILoginModel{

    @Override
    public void login(String userName, String passWord, OnLoginListener onLoginListener) {
        //这里做一些登录校验操作
        if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(passWord)
                && userName.equals(passWord)){
            if (onLoginListener != null){
                onLoginListener.loginSuccess();
            }
        }else {
            if (onLoginListener != null){
                onLoginListener.loginFail("密码错误");
            }
        }
    }
}
