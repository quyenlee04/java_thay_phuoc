package CsangF;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TemperatureView extends JFrame{

private JTextField celsiusTextField = new JTextField(10);
    private JTextField fahrenheitTextField = new JTextField(10);
    private JMenuItem convertCtoFMenuItem = new JMenuItem("C2F");
    private JMenuItem convertFtoCMenuItem = new JMenuItem("F2C");
    private JMenuItem exitMenuItem = new JMenuItem("Exit");
    public TemperatureView() {
       
        this.setTitle("Temperature Converter");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 150);
        this.setLayout(new GridLayout(3, 2));

        
        this.add(new JLabel("Celsius:"));
        this.add(celsiusTextField);
        this.add(new JLabel("Fahrenheit:"));
        this.add(fahrenheitTextField);

      
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Commands");
        menu.add(convertCtoFMenuItem);
        menu.add(convertFtoCMenuItem);
        menu.add(exitMenuItem);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        
        
    }

    public double getCelsius() {
        return Double.parseDouble(celsiusTextField.getText());
    }

    public double getFahrenheit() {
        return Double.parseDouble(fahrenheitTextField.getText());
    }

    public void setFahrenheit(double fahrenheit) {
        fahrenheitTextField.setText(String.valueOf(fahrenheit));
    }

    public void setCelsius(double celsius) {
        celsiusTextField.setText(String.valueOf(celsius));
    }

    public void addConvertListener(ActionListener listener) {
        convertCtoFMenuItem.addActionListener(listener);
    }
    public void addConvertFtoCListener(ActionListener listener) {
        convertFtoCMenuItem.addActionListener(listener);
    }
   
    public void addExitListener(ActionListener listener) {
      exitMenuItem.addActionListener(listener);
    }

    public JTextField getCelsiusTextField() {
        return celsiusTextField;
    }

    public JTextField getFahrenheitTextField() {
        return fahrenheitTextField;
    }

    public void addEnterController(ActionListener listener) {
        celsiusTextField.addActionListener(listener);
        fahrenheitTextField.addActionListener(listener);
    }
}

