package Temperature.Command_Processor;

import Temperature.TemperatureModel;

public class FahrenheitCommand extends Command{
    private double value;

    public FahrenheitCommand(TemperatureModel model, double value) {
        super(model);
        this.value = value;
    }

    @Override
    public void execute() {
        model.setFahrenheit(value);
    }

}
