package jaygoo.weathersamplewithtest.model;

import jaygoo.weathersamplewithtest.listener.OnLoginListener;

/**
 * ================================================
 * 作    者：JayGoo
 * 版    本：
 * 创建日期：2017/10/4
 * 描    述: 登录接口
 * ================================================
 */
public interface ILoginModel {
    void login(String userName, String passWord, OnLoginListener onLoginListener);

}
