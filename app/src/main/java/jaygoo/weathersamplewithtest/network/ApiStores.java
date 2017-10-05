package jaygoo.weathersamplewithtest.network;



import jaygoo.weathersamplewithtest.bean.WeatherBean;
import jaygoo.weathersamplewithtest.model.WeatherModel;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * ================================================
 * 作    者：JayGoo
 * 版    本：
 * 创建日期：2017/10/5
 * 描    述: 接口Api
 * ================================================
 */
public interface ApiStores {

    String API_SERVER_URL = "http://www.weather.com.cn/";

    @GET("adat/sk/{cityId}.html")
    Observable<WeatherModel> loadWeatherData(@Path("cityId") String cityId);

}
