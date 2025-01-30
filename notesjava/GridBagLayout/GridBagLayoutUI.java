package notesjava.GridBagLayout;


import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GridBagLayoutUI extends Frame {

    GridBagLayoutUI() {
        
        GridBagLayout layout = new GridBagLayout();
        setSize(300, 300);
        setLayout(layout);
        setTitle("Grid Bag Layout Demo");
        setVisible(true);
        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(new Button("Button 1"), constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 0;
        add(new Button("Button 2"), constraints);
        
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.ipady = 15;
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(new Button("Button 3"), constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 1;
        add(new Button("Button 4"), constraints);
        
        constraints.gridwidth = 2;
        constraints.gridx = 0;
        constraints.gridy = 2;
        add(new Button("Button 5"), constraints);
     
        onClose();
    }
    
    public void onClose() {
        
        // To close the window after clicking X button.
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
    
}
