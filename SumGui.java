import java.applet.Applet;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SumGui extends Applet {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sum of Two Numbers");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel label1 = new JLabel("Enter first number:");
        label1.setBounds(20, 20, 120, 25);
        frame.add(label1);

        JTextField textField1 = new JTextField();
        textField1.setBounds(150, 20, 100, 25);
        frame.add(textField1);

        JLabel label2 = new JLabel("Enter second number:");
        label2.setBounds(20, 60, 130, 25);
        frame.add(label2);

        JTextField textField2 = new JTextField();
        textField2.setBounds(150, 60, 100, 25);
        frame.add(textField2);

        JButton addButton = new JButton("Add");
        addButton.setBounds(90, 100, 100, 30);
        frame.add(addButton);

        JLabel resultLabel = new JLabel("Result: ");
        resultLabel.setBounds(20, 140, 200, 25);
        frame.add(resultLabel);

        addButton.addActionListener(e -> {
            try {
                int num1 = Integer.parseInt(textField1.getText());
                int num2 = Integer.parseInt(textField2.getText());
                int sum = num1 + num2;
                resultLabel.setText("Result: " + sum);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        });

        frame.setVisible(true);

    }
}
