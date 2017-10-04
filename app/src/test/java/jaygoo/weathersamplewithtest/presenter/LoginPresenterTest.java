package jaygoo.weathersamplewithtest.presenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowToast;

import jaygoo.weathersamplewithtest.BuildConfig;
import jaygoo.weathersamplewithtest.MyRobolectricTestRunner;
import jaygoo.weathersamplewithtest.view.activity.LoginActivity;

import static org.junit.Assert.*;

/**
 * ================================================
 * 作    者：JayGoo
 * 版    本：
 * 创建日期：2017/10/4
 * 描    述:
 * ================================================
 */
@RunWith(MyRobolectricTestRunner.class)
@Config(sdk = 21,constants = BuildConfig.class)
public class LoginPresenterTest {
    LoginPresenter loginPresenter;
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void login() throws Exception {
        LoginActivity loginActivity = Robolectric.setupActivity(LoginActivity.class);
        assertNotNull(loginActivity);
        loginPresenter = new LoginPresenter(loginActivity,loginActivity);
        loginPresenter.login();
        assertEquals(ShadowToast.getTextOfLatestToast(),"密码错误");
    }

}