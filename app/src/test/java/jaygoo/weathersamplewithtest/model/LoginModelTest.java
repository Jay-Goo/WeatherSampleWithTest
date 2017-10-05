package jaygoo.weathersamplewithtest.model;

import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;

import jaygoo.weathersamplewithtest.MyRobolectricTestRunner;
import jaygoo.weathersamplewithtest.bean.UserBean;
import jaygoo.weathersamplewithtest.listener.OnLoginListener;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * ================================================
 * 作    者：JayGoo
 * 版    本：
 * 创建日期：2017/10/4
 * 描    述: LoginModel 单元测试
 * ================================================
 */
@RunWith(MyRobolectricTestRunner.class)
@Config(manifest = "./src/main/AndroidManifest.xml")

public class LoginModelTest {
    private LoginModel loginModel;

    @Before
    public void setUp() throws Exception {
        //输出日志
        ShadowLog.stream = System.out;
        loginModel = new LoginModel();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void login() throws Exception {

        loginModel.login("123", "123", new OnLoginListener() {
            @Override
            public void loginSuccess(UserBean user) {
                assertTrue(true);
                assertEquals(user.getUserName(),"123");
                assertEquals(user.getPassWord(),"123");
                Log.i("LoginModelTest", "loginSuccess: ");
            }

            @Override
            public void loginFail(String msg) {
                assertTrue(false);
            }
        });

        loginModel.login("123", "456", new OnLoginListener() {
            @Override
            public void loginSuccess(UserBean user) {
                assertTrue(false);
            }

            @Override
            public void loginFail(String msg) {
                assertTrue(true);
            }
        });


        loginModel.login(null, "456", new OnLoginListener() {
            @Override
            public void loginSuccess(UserBean user) {
                assertTrue(false);
            }

            @Override
            public void loginFail(String msg) {
                assertTrue(true);
            }
        });
    }

}