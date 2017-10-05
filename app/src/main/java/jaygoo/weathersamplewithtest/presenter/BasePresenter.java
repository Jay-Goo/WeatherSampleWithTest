package jaygoo.weathersamplewithtest.presenter;

import jaygoo.weathersamplewithtest.network.ApiClient;
import jaygoo.weathersamplewithtest.network.ApiStores;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * ================================================
 * 作    者：JayGoo
 * 版    本：
 * 创建日期：2017/10/5
 * 描    述:
 * ================================================
 */
public class BasePresenter<V> {
    public V baseView;
    protected ApiStores apiStores;
    private CompositeSubscription mCompositeSubscription;

    public void attachView(V baseView){
        this.baseView = baseView;
        apiStores = ApiClient.retrofit().create(ApiStores.class);
    }

    public void detachView() {
        this.baseView = null;
        onUnsubscribe();
    }


    //RxJava取消注册，以避免内存泄露
    public void onUnsubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }

    public void addSubscription(Observable observable, Subscriber subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }
}
