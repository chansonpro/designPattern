package com.baidu.service.subject;


import com.baidu.service.observer.Observer;

/**
 * User: chanson-pro
 * Date-Time: 2017-11-16 11:15
 * Description:主题（发布者、被观察者）
 */
public interface Subject {
    //注册观察者
    void registerObserver(Observer observer);
    //移除观察者
    void removeObserver(Observer observer);
    //通知观察者
    void notifyObserver();
}
