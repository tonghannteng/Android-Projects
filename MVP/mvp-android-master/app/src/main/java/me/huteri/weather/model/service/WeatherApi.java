package me.huteri.weather.model.service;

import java.util.List;

import me.huteri.weather.model.Weather;

public interface WeatherApi {

    interface WeatherServiceCallback<T> {
        void onSuccess(T weathers);
        void onFailure();
    }

    void getAllWeathers(WeatherServiceCallback<List<Weather>> callback);
}
