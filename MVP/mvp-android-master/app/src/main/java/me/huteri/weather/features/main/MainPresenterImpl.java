package me.huteri.weather.features.main;


import java.util.List;

import me.huteri.weather.features.BasePresenter;
import me.huteri.weather.model.Weather;
import me.huteri.weather.model.service.WeatherApi;
import me.huteri.weather.model.service.WeatherApiImpl;
import me.huteri.weather.util.EspressoIdlingResource;

/**
 * The implementation of the main presenter interface
 */

public class MainPresenterImpl extends BasePresenter implements MainPresenter {

    private final MainView mView;
    private final WeatherApiImpl mWeatherApi;

    public MainPresenterImpl(MainView view, WeatherApiImpl weatherApi) {
        mView = view;
        mWeatherApi = weatherApi;
    }

    @Override
    public void loadWeatherData() {

        mView.showProgress();

        EspressoIdlingResource.increment();

        mWeatherApi.getAllWeathers(new WeatherApi.WeatherServiceCallback<List<Weather>>() {

            @Override
            public void onSuccess(List<Weather> weathers) {
                EspressoIdlingResource.decrement();
                mView.hideProgress();
                mView.showWeathers(weathers);
            }

            @Override
            public void onFailure() {
                EspressoIdlingResource.decrement();
                mView.showConnectionError();
                mView.hideProgress();
            }
        });
    }

    @Override
    public void clickWeatherItem(Weather item) {
        mView.showWeatherClickedMessage(item);
    }
}
