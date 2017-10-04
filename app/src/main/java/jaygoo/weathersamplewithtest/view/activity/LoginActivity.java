package jaygoo.weathersamplewithtest.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jaygoo.weathersamplewithtest.R;
import jaygoo.weathersamplewithtest.presenter.LoginPresenter;
import jaygoo.weathersamplewithtest.view.ILoginView;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    @BindView(R.id.username_et)
    EditText usernameEt;
    @BindView(R.id.password_et)
    EditText passwordEt;
    @BindView(R.id.login_btn)
    Button loginBtn;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenter(this, this);
    }

    @Override
    public String getUserName() {
        return usernameEt.getText().toString();
    }

    @Override
    public String getPassWord() {
        return passwordEt.getText().toString();
    }

    @OnClick(R.id.login_btn)
    public void onViewClicked() {
        Log.i("LoginActivity", "onViewClicked: ");
        loginPresenter.login();
    }
}
