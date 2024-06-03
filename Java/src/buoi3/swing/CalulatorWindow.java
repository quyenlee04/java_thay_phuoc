package buoi3.swing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import buoi2.association.association;

public class CalulatorWindow extends JFrame implements ActionListener {
    //tield
    private String title;
    private JPanel jPanelRemote;
    private JLabel jLabelInput1Remote, jLabelInput2Remote, jLabelOuputRemote;
    private JTextField JTextFieldInput1Remote, JTextFieldInput2Remote, JTextFieldOuputRemote;
    private JButton  addButtonRemote, subButtonRemote, mulButtonRemote, divButtonRemote, closeButton;


    //funcition
    CalulatorWindow(){
        buildPanel();
        add(jPanelRemote);
        title = "FrameViewer";
        setTitle(title);
        setSize(500, 600);
        setVisible(true);

    }
    public void buildPanel(){
        jPanelRemote = new JPanel();
        jLabelInput1Remote = new JLabel("input 1");
        jPanelRemote.add(jLabelInput1Remote);
        JTextFieldInput1Remote = new JTextField(10);
        jPanelRemote.add(JTextFieldInput1Remote);
        jLabelInput2Remote = new JLabel("input 2");
        jPanelRemote.add(jLabelInput2Remote);
        JTextFieldInput2Remote = new JTextField(10);
        jPanelRemote.add(JTextFieldInput2Remote);
        jLabelOuputRemote = new JLabel("ouput");
        jPanelRemote.add(jLabelOuputRemote);
        JTextFieldOuputRemote = new JTextField(10);
        jPanelRemote.add(JTextFieldOuputRemote);
        addButtonRemote = new JButton("ADD");
        addButtonRemote.addActionListener(this);
        jPanelRemote.add(addButtonRemote);

        subButtonRemote = new JButton("SUB");
        subButtonRemote.addActionListener(this);
        jPanelRemote.add(subButtonRemote);

        mulButtonRemote = new JButton("MUL");
        mulButtonRemote.addActionListener(this);
        jPanelRemote.add(mulButtonRemote);

        divButtonRemote = new JButton("DIV");
        divButtonRemote.addActionListener(this);
        jPanelRemote.add(divButtonRemote);

        jPanelRemote.setBackground(Color.PINK);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.equals("ADD")){
        double num1 = Double.parseDouble(JTextFieldInput1Remote.getText());
        double num2 = Double.parseDouble(JTextFieldInput2Remote.getText());
        double result = num1 + num2;
        JTextFieldOuputRemote.setText("" + result);
        }
        else if(command.equals("SUB")){
        double num1 = Double.parseDouble(JTextFieldInput1Remote.getText());
        double num2 = Double.parseDouble(JTextFieldInput2Remote.getText());
        double result = num1 - num2;
        JTextFieldOuputRemote.setText("" + result);
        }
        else if(command.equals("MUL")){
        double num1 = Double.parseDouble(JTextFieldInput1Remote.getText());
        double num2 = Double.parseDouble(JTextFieldInput2Remote.getText());
        double result = num1 * num2;
        JTextFieldOuputRemote.setText("" + result);
        }
        else if(command.equals("DIV")){
        double num1 = Double.parseDouble(JTextFieldInput1Remote.getText());
        double num2 = Double.parseDouble(JTextFieldInput2Remote.getText());
        double result = num1 / num2;
        JTextFieldOuputRemote.setText("" + result);
        }
        

    }
}
