package jaygoo.weathersamplewithtest.presenter;

import jaygoo.weathersamplewithtest.bean.WeatherBean;
import jaygoo.weathersamplewithtest.model.WeatherModel;
import jaygoo.weathersamplewithtest.network.ApiCallback;
import jaygoo.weathersamplewithtest.view.IWeatherView;

/**
 * ================================================
 * 作    者：JayGoo
 * 版    本：
 * 创建日期：2017/10/5
 * 描    述:
 * ================================================
 */
public class WeatherPresenter extends BasePresenter<IWeatherView> implements IWeatherPresenter {

    public WeatherPresenter(IWeatherView weatherView){
        attachView(weatherView);
    }

    @Override
    public void loadData(String cityId) {
        baseView.startSearching();
        addSubscription(apiStores.loadWeatherData(cityId),
                new ApiCallback<WeatherModel>(){

                    @Override
                    public void onSuccess(WeatherModel model) {
                        baseView.searchSuccess(model);
                    }

                    @Override
                    public void onFailure(String msg) {
                        baseView.searchFail(msg);
                    }

                    @Override
                    public void onFinish() {
                        baseView.cancelSearching();
                    }
                });
    }
}
