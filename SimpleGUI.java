import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGUI {

    private int clickCount = 0;
    private JLabel label;

    public SimpleGUI() {
        // Create the main window (JFrame)
        JFrame frame = new JFrame("Simple GUI Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close on exit
        frame.setSize(1000, 1000); // Set window size
        frame.setLocationRelativeTo(null); // Center the window

        // Create a panel to hold components
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30)); // Add padding

        // Create a label
        label = new JLabel("Clicks: 0");
        panel.add(label);

        // Create a button
        JButton button = new JButton("Click Me!");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickCount++;
                label.setText("Clicks: " + clickCount); // Update label text on button click
            }
        });
        panel.add(button);

        // Add the panel to the frame
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Run the GUI creation on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SimpleGUI();
            }
        });
    }
}