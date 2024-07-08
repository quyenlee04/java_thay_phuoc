package Temperature;

import Temperature.observer.Publisher;


public class TemperatureModel extends Publisher {
    private double celsius;
    private double fahrenheit;

    public double getCelsius() {
        return celsius;
    }

    public void setCelsius(double celsius) {
        this.celsius = celsius;
        notifySubscribers();
    }

    public double getFahrenheit() {
        return celsius * 9 / 5 + 32;
    }

    public void setFahrenheit(double  fahrenheit) {
        this.celsius = (fahrenheit - 32) * 5 / 9;
        notifySubscribers();
    }

}
