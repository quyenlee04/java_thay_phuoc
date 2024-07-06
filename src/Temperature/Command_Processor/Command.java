package Temperature.Command_Processor;

import Temperature.TemperatureModel;

public abstract class Command {
    protected TemperatureModel model;

    public Command(TemperatureModel model) {
        this.model = model;
    }

    public abstract void execute();
}
