package layoutPrograms.boxLayout;

import javax.swing.*;

public class BoxLayoutExample extends JFrame {
    private JButton[] buttons;
    private final int noOfButtons = 5;

    public static void main(String[] args) {
        new BoxLayoutExample();
    }

    public BoxLayoutExample() {
        setTitle("BoxLayout Example");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);

        // Create a panel with BoxLayout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        // Initialize buttons and add to the panel
        buttons = new JButton[noOfButtons];
        for (int i = 0; i < noOfButtons; i++) {
            buttons[i] = new JButton("Button " + (i + 1));
            panel.add(buttons[i]);
        }

        // Add the panel to the frame               
        add(panel);

        // Make the frame visible
        setVisible(true);
    }
}
