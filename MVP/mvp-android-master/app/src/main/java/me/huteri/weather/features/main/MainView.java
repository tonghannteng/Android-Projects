package me.huteri.weather.features.main;

import java.util.List;

import me.huteri.weather.model.Weather;

public interface MainView {
    void showProgress();
    void hideProgress();
    void showWeatherClickedMessage(Weather s);
    void showWeathers(List<Weather> weathers);
    void showConnectionError();
}
