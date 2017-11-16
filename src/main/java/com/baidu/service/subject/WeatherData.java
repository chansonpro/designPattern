package com.baidu.service.subject;

import com.baidu.service.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * User: chanson-pro
 * Date-Time: 2017-11-16 11:32
 * Description:
 */
public class WeatherData implements Subject{
    private List<Observer> observers;
    private float temperature;//温度
    private float humidity;//湿度
    private float pressure;//气压
    private List<Float> forecastTemperatures;//未来几天温度

    //构造器
    public WeatherData() {
        this.observers = new ArrayList<Observer>();
    }
    //注册观察者，调用add方法
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }
    //移除观察者，调用remove方法
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    //通知观察者，相当于调用update（）方法
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update();
            //observer.notify();
        }
    }
    //参数发生变化后，告诉所有观察者
    private void measurementsChanged() {
        notifyObserver();
    }
    public void setMeasurements(float temperature,float humidity,float pressure,
                                List<Float> forecastTemperatures ) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.forecastTemperatures = forecastTemperatures;
        measurementsChanged();
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public List<Float> getForecastTemperatures() {
        return forecastTemperatures;
    }

}
