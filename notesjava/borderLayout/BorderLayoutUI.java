package notesjava.borderLayout;

import java.awt.*;
import java.awt.event.*;

public class BorderLayoutUI {
    public static void main(String[] args) {
        new BorderLayoutUI();
    }

    Frame frame;

    public BorderLayoutUI() {

        frame = new Frame();
        Label lblNorth = new Label("North");
        Label lblSouth = new Label("South");
        Label lblEast = new Label("East");
        Label lblWest = new Label("West");

        Panel panel = new Panel();
        panel.add(new Checkbox("This is checkbox 1."));
        panel.add(new Checkbox("This is checkbox 2."));
        panel.add(new Checkbox("This is checkbox 3."));
        panel.add(new Button("Click Me"));

        frame.setLayout(new BorderLayout(5, 5));
        frame.add(lblNorth, BorderLayout.NORTH);
        frame.add(lblSouth, BorderLayout.SOUTH);
        frame.add(lblEast, BorderLayout.EAST);
        frame.add(lblWest, BorderLayout.WEST);
        frame.add(panel, BorderLayout.CENTER);

        frame.setTitle("Demo Program - Border Layout");
        frame.setSize(400, 300);
        frame.setVisible(true);

        // To close the window after clicking X button.
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }

}
