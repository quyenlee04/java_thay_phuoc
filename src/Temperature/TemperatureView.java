package Temperature;


import Temperature.Command_Processor.CelsiusCommand;
import Temperature.Command_Processor.CommandProcessor;
import Temperature.Command_Processor.FahrenheitCommand;
import Temperature.observer.Subscriber;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class TemperatureView extends JFrame implements Subscriber {
    private TemperatureModel model;
    private JPanel jPanel;
    private JTextField celsiusJTextField;
    private JTextField fahrenheitJTextField;
    private JLabel cJLabel, fJLabel;
     private CommandProcessor commandProcessor;
  
    

    public TemperatureView(TemperatureModel model) {
        this.model = model;
        this.commandProcessor = new CommandProcessor();
        model.subscribe(this);
        buildUI();
} 

    private void buildUI() {
        setTitle("Temperature Converter");
        
        setSize(300, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        
        JMenuItem celsiusToFahrenheitItem = new JMenuItem("CtoF");
        celsiusToFahrenheitItem.addActionListener(e -> convertCelsiusToFahrenheit());
        menu.add(celsiusToFahrenheitItem);

        JMenuItem fahrenheitToCelsiusItem = new JMenuItem("FtoC");
        fahrenheitToCelsiusItem.addActionListener(e -> convertFahrenheitToCelsius());
        menu.add(fahrenheitToCelsiusItem);

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        menu.add(exitItem);

        menuBar.add(menu);
        setJMenuBar(menuBar);

        JPanel panel = new JPanel();
        celsiusJTextField = new JTextField(10);
        fahrenheitJTextField = new JTextField(10);

        celsiusJTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    double value = Double.parseDouble(celsiusJTextField.getText());
                    commandProcessor.execute(new CelsiusCommand(model, value));
                }
            }
        });

        fahrenheitJTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    double value = Double.parseDouble(fahrenheitJTextField.getText());
                    commandProcessor.execute(new FahrenheitCommand(model, value));
                }
            }
        });

        panel.add(new JLabel("Celsius:"));
        panel.add(celsiusJTextField);
        panel.add(new JLabel("Fahrenheit:"));
        panel.add(fahrenheitJTextField);
        
        add(panel);
        pack();
    }
    private void convertCelsiusToFahrenheit() {
        double value = Double.parseDouble(celsiusJTextField.getText());
        commandProcessor.execute(new CelsiusCommand(model, value));
    }

    private void convertFahrenheitToCelsius() {
        double value = Double.parseDouble(fahrenheitJTextField.getText());
        commandProcessor.execute(new FahrenheitCommand(model, value));
    }

    @Override
    public void update() {
        celsiusJTextField.setText(String.valueOf(model.getCelsius()));
        fahrenheitJTextField.setText(String.valueOf(model.getFahrenheit()));
    }

    public static void main(String[] args) {
        TemperatureModel model = new TemperatureModel();
        new TemperatureView(model);
    }

}
