package jaygoo.weathersamplewithtest.model;

import jaygoo.weathersamplewithtest.bean.WeatherBean;

/**
 * ================================================
 * 作    者：JayGoo
 * 版    本：
 * 创建日期：2017/10/5
 * 描    述: 天气信息具体业务处理
 * ================================================
 */
public class WeatherModel implements IWeatherModel{
    private WeatherBean weatherinfo;
    @Override
    public WeatherBean getWeatherInfo() {
        return weatherinfo;
    }

    @Override
    public String getFormatWeatherInfo() {
        if (weatherinfo == null)return "";
        return new StringBuilder("城市：").append(weatherinfo.getCity())
                .append("\n")
                .append("风向：").append(weatherinfo.getWD())
                .append("\n")
                .append("风力：").append(weatherinfo.getWS())
                .toString();
    }

    @Override
    public void setWeatherInfo(WeatherBean weatherInfo) {
        this.weatherinfo = weatherInfo;
    }

}
