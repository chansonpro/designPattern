package com.baidu.service.observer;

import com.baidu.service.subject.WeatherData;

import java.util.List;

/**
 * User: chanson-pro
 * Date-Time: 2017-11-16 12:46
 * Description:显示未来几天的天气情况
 */
public class ForecastDisplay implements Observer,DisplayElement{
    private WeatherData weatherData;
    private List<Float> forecastTemperatures;//未来几天的温度

    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver((java.util.Observer) this);
    }

    public void display() {
        System.out.println("未来几天的气温");
        int count = forecastTemperatures.size();//记录长度
        for (int i = 0; i <count ; i++) {
            System.out.println("第" + i + "天:" + forecastTemperatures.get(i) + "℃");
        }
    }

    public void update() {
        this.forecastTemperatures = this.weatherData.getForecastTemperatures();
        display();

    }
}
