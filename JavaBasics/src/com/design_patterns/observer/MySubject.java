package com.design_patterns.observer;

import java.util.ArrayList;

public class MySubject implements Subject {

    private ArrayList<Observer> observers;
    private float temp;
    private float humidity;
    private float pressure;

    MySubject() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int index = observers.indexOf(o);
        if (index > -1) {
            System.out.println("Removing Observer at position " + index);
            observers.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer o : observers) {
            o.update(temp, humidity, pressure);
        }
    }

    public void measurementChanged() {
        notifyObserver();
    }

    public void setMeasurements(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementChanged();
    }
}
