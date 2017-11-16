package com.baidu.service.observer;

import com.baidu.service.subject.WeatherData;

/**
 * User: chanson-pro
 * Date-Time: 2017-11-16 12:31
 * Description:显示当前天气的公告牌CurrentConditionsDisplay
 */
public class CurrentConditionsDisplay implements Observer,DisplayElement{
    private WeatherData weatherData;
    private float temperature;//温度
    private float humidity;//湿度
    private float pressure;//气压

    //当前天气的显示公告
    public CurrentConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver((java.util.Observer) this);
    }

    public void display() {
        System.out.println("当前温度为：" + this.temperature + "℃");
        System.out.println("当前湿度为：" + this.humidity);
        System.out.println("当前气压为：" + this.pressure);

    }
    public void update() {
        this.temperature = this.weatherData.getTemperature();
        this.humidity = this.weatherData.getHumidity();
        this.pressure = this.weatherData.getPressure();
        display();
    }
}
