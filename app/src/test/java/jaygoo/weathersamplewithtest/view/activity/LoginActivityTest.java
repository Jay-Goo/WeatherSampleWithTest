package jaygoo.weathersamplewithtest.view.activity;

import android.widget.Button;
import android.widget.EditText;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;
import org.robolectric.shadows.ShadowToast;

import butterknife.BindView;
import butterknife.ButterKnife;
import jaygoo.weathersamplewithtest.BuildConfig;
import jaygoo.weathersamplewithtest.MyRobolectricTestRunner;
import jaygoo.weathersamplewithtest.R;
import jaygoo.weathersamplewithtest.presenter.LoginPresenter;

import static org.junit.Assert.*;

/**
 * ================================================
 * 作    者：JayGoo
 * 版    本：
 * 创建日期：2017/10/5
 * 描    述:
 * ================================================
 */
@RunWith(MyRobolectricTestRunner.class)
@Config(sdk = 21,constants = BuildConfig.class)
public class LoginActivityTest {
    LoginActivity loginActivity;
    EditText usernameEt;
    EditText passwordEt;
    Button loginBtn;
    @Before
    public void setUp() throws Exception {
        ShadowLog.stream = System.out;

        loginActivity = Robolectric.setupActivity(LoginActivity.class);
        usernameEt = (EditText) loginActivity.findViewById(R.id.username_et);
        passwordEt = (EditText)loginActivity.findViewById(R.id.password_et);
        loginBtn = (Button)loginActivity.findViewById(R.id.login_btn);
        usernameEt.setText("123");
        passwordEt.setText("123");
    }

    @Test
    public void onCreate() throws Exception {

        //点击登录按钮
        loginBtn.performClick();
    }

    @Test
    public void getUserName() throws Exception {
        assertEquals(loginActivity.getUserName(),"123");
    }

    @Test
    public void getPassWord() throws Exception {
        assertEquals(loginActivity.getPassWord(),"123");

    }

    @Test
    public void onViewClicked() throws Exception {

    }

}