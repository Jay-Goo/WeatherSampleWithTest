package jaygoo.weathersamplewithtest.bean;

/**
 * ================================================
 * 作    者：JayGoo
 * 版    本：
 * 创建日期：2017/10/5
 * 描    述: 天气信息
 * ================================================
 */
public class WeatherBean {
    private String city;
    private String cityid;
    private String WD;
    private String WS;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityId() {
        return cityid;
    }

    public void setCityId(String cityId) {
        this.cityid = cityId;
    }

    public String getWD() {
        return WD;
    }

    public void setWD(String WD) {
        this.WD = WD;
    }

    public String getWS() {
        return WS;
    }

    public void setWS(String WS) {
        this.WS = WS;
    }
}