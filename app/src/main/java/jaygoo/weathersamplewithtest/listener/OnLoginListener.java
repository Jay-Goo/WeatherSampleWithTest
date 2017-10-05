package jaygoo.weathersamplewithtest.listener;

import jaygoo.weathersamplewithtest.bean.UserBean;

/**
 * ================================================
 * 作    者：JayGoo
 * 版    本：
 * 创建日期：2017/10/4
 * 描    述: 登录状态监听
 * ================================================
 */
public interface OnLoginListener {
    void loginSuccess(UserBean user);
    void loginFail(String msg);
}
