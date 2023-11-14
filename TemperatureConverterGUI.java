import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

public class TemperatureConverterGUI extends JFrame implements ActionListener {


private JTextField inputField;

private JLabel resultLabel;

private JButton convertButton;

public TemperatureConverterGUI() {

// Initialize frame and components

setTitle("Temperature Converter");

setSize( 300, 200); 

setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

setLayout(new FlowLayout());

getContentPane().setBackground (Color.decode("#F5F5F5")); // Set background color

// Create and set fonts

Font LabelFont = new Font(" Arial", Font.BOLD, 16);

Font inputFont =new Font("Arial", Font.PLAIN, 14);

inputField = new JTextField( 10);

inputField.setFont(inputFont);

resultLabel = new JLabel("Converted:");

resultLabel.setFont(LabelFont);

convertButton = new JButton("Convert"); convertButton.setFont(LabelFont); convertButton.addActionListener(this);

add(new JLabel("Enter Temperature (Celsius): ")); 
add (inputField); 
add (resultLabel);
 add(convertButton);

setVisible(true);

}


public void actionPerformed (ActionEvent e) {
    if (e.getSource() == convertButton) {
        try {
            double celsius =Double.parseDouble (inputField.getText());
            double fahrenheit = celsiusToFahrenheit (celsius);
            resultLabel.setText("Converted: "+fahrenheit + "  F");
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input");
        }
    }
}
private double celsiusToFahrenheit (double celsius) { return (celsius * 9 / 5) + 32; }

public static void main(String[] args) {SwingUtilities.invokeLater (() -> new TemperatureConverterGUI());}
}