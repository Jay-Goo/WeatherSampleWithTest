package jaygoo.weathersamplewithtest.view;

import jaygoo.weathersamplewithtest.model.WeatherModel;

/**
 * ================================================
 * 作    者：JayGoo
 * 版    本：
 * 创建日期：2017/10/5
 * 描    述: 查询天气视图接口
 * ================================================
 */
public interface IWeatherView {
    void startSearching();
    void cancelSearching();
    void searchSuccess(WeatherModel weatherModel);
    void searchFail(String msg);
}
