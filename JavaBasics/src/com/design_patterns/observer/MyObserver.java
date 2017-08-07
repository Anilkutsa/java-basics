package com.design_patterns.observer;

public class MyObserver implements Observer, DisplayElement {

    private String name;
    private float temp;
    private float humidity;
    private Subject weatherData;

    public MyObserver(String name, Subject weatherData) {
        this.name = name;
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("Observer " + name + " ,Curent conditions: " + temp
                + " F degrees and " + humidity + " % humidity");
    }
}
