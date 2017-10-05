package jaygoo.weathersamplewithtest.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.math.MathUtils;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jaygoo.weathersamplewithtest.R;
import jaygoo.weathersamplewithtest.model.WeatherModel;
import jaygoo.weathersamplewithtest.presenter.WeatherPresenter;
import jaygoo.weathersamplewithtest.view.IWeatherView;

/**
 * ================================================
 * 作    者：JayGoo
 * 版    本：
 * 创建日期：2017/10/5
 * 描    述:
 * ================================================
 */
public class WeatherActivity extends BaseActivity implements IWeatherView {
    @BindView(R.id.search_btn)
    Button searchBtn;
    @BindView(R.id.weather_tv)
    TextView weatherTv;
    private String[] cityIds={"101010200","101020200","101030200","101040200","101050200"};

    WeatherPresenter weatherPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);
        weatherPresenter = new WeatherPresenter(this);
    }

    @Override
    public void startSearching() {
        searchBtn.setText("查询中...");
        searchBtn.setEnabled(false);
        showProgressDialog("查询天气中");
    }

    @Override
    public void cancelSearching() {
        dismissProgressDialog();
    }

    @Override
    public void searchSuccess(WeatherModel weatherModel) {
        searchBtn.setText("查询天气");
        searchBtn.setEnabled(true);
        weatherTv.setText(weatherModel.getFormatWeatherInfo());
    }

    @Override
    public void searchFail(String msg) {
        searchBtn.setText("查询天气");
        searchBtn.setEnabled(true);
        weatherTv.setText(msg);

    }

    @OnClick(R.id.search_btn)
    public void onViewClicked() {
        int index = (int) (Math.random() * 10) % 5;
        weatherPresenter.loadData(cityIds[index]);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cancelSearching();
        weatherPresenter.detachView();
    }
}
