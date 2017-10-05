package jaygoo.weathersamplewithtest.model;

import jaygoo.weathersamplewithtest.bean.WeatherBean;

/**
 * ================================================
 * 作    者：JayGoo
 * 版    本：
 * 创建日期：2017/10/5
 * 描    述:
 * ================================================
 */
public interface IWeatherModel {
    WeatherBean getWeatherInfo();
    String getFormatWeatherInfo();
    void setWeatherInfo(WeatherBean weatherInfo);
}
