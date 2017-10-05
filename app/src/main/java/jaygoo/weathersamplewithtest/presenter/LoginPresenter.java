package jaygoo.weathersamplewithtest.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import jaygoo.weathersamplewithtest.bean.UserBean;
import jaygoo.weathersamplewithtest.listener.OnLoginListener;
import jaygoo.weathersamplewithtest.model.LoginModel;
import jaygoo.weathersamplewithtest.view.ILoginView;
import jaygoo.weathersamplewithtest.view.activity.WeatherActivity;

/**
 * ================================================
 * 作    者：JayGoo
 * 版    本：
 * 创建日期：2017/10/4
 * 描    述:
 * ================================================
 */
public class LoginPresenter implements ILoginPresenter{

    private Context context;
    private ILoginView loginView;
    private LoginModel loginModel;

    public LoginPresenter(Context context, ILoginView loginView){
        this.context = context;
        this.loginView = loginView;
        loginModel = new LoginModel();
    }

    @Override
    public void login() {
        loginModel.login(loginView.getUserName(), loginView.getPassWord(),
                new OnLoginListener() {
                    @Override
                    public void loginSuccess(UserBean user) {
                        Toast.makeText(context,"登录成功",Toast.LENGTH_LONG).show();
                        ((Activity)context).startActivity(
                                new Intent(context, WeatherActivity.class));
                        ((Activity) context).finish();

                    }

                    @Override
                    public void loginFail(String msg) {
                        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
                    }
                });
    }


}
