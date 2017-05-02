package me.huteri.weather.features.main;

import me.huteri.weather.model.Weather;

public interface MainPresenter {

    void loadWeatherData();

    void clickWeatherItem(Weather item);
}
