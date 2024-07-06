package CsangF;

public class TemperatureModel {
    private double celsius;
    private double fahrenheit;

    public double getCelsius() {
        return celsius;
    }

    public void setCelsius(double celsius) {
        this.celsius = celsius;
        convertToFahrenheit();
    }

    public double getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(double fahrenheit) {
        this.fahrenheit = fahrenheit;
        convertToCelsius();
    }

    private void convertToFahrenheit() {
        this.fahrenheit = (celsius * 9 / 5) + 32;
    }
    private void convertToCelsius() {
        this.celsius = (fahrenheit - 32) * 5 / 9;
    }
    
    
}
