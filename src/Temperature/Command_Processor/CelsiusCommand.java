package Temperature.Command_Processor;

import Temperature.TemperatureModel;

public class CelsiusCommand extends Command {
    private double value;

    public CelsiusCommand(TemperatureModel model, double value) {
        super(model);
        this.value = value;
    }

    @Override
    public void execute() {
        model.setCelsius(value);
    }
}