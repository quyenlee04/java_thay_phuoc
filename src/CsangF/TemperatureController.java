package CsangF;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class TemperatureController {
    private TemperatureModel model;
    private TemperatureView view;

    public TemperatureController(TemperatureModel model, TemperatureView view) {
        this.model = model;
        this.view = view;

        this.view.addConvertListener(new ConvertListener());
        this.view.addConvertFtoCListener(new ConvertFtoCListener());
        this.view.addExitListener(new ExitListener());
        this.view.addEnterController(new EnterController());
    }

    class ConvertListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double celsius = view.getCelsius();
                model.setCelsius(celsius);
                view.setFahrenheit(model.getFahrenheit());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(view, "Vui lòng nhập hợp lệ.");
            }
        }
    }
    class ConvertFtoCListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double fahrenheit = view.getFahrenheit();
                model.setFahrenheit(fahrenheit);
                view.setCelsius(model.getCelsius());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(view, "Vui lòng nhập một số hợp lệ.");
            }
        }
    }
    class ExitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    class EnterController implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource() == view.getCelsiusTextField()) {
                    double celsius = view.getCelsius();
                    model.setCelsius(celsius);
                    view.setFahrenheit(model.getFahrenheit());
                } else if (e.getSource() == view.getFahrenheitTextField()) {
                    double fahrenheit = view.getFahrenheit();
                    model.setFahrenheit(fahrenheit);
                    view.setCelsius(model.getCelsius());
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(view, "Vui lòng nhập hợp lệ.");
            }
        }
    }
}
