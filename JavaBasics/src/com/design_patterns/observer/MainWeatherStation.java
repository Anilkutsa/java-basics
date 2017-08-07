package com.design_patterns.observer;

public class MainWeatherStation {
    public static void main(String[] args) {
        MySubject wd = new MySubject();
        
        MyObserver obsr1 = new MyObserver("Observer1", wd);
        MyObserver obsr2 = new MyObserver("Observer2", wd);
        
        wd.setMeasurements(44, 45, 46.4f);
        wd.setMeasurements(56, 53, 54.4f);
        wd.setMeasurements(67, 68, 60.4f);
        
        wd.removeObserver(obsr2);
        
        wd.setMeasurements(345, 35, 345.4f);
        wd.setMeasurements(23, 45, 466.4f);
    }
}
