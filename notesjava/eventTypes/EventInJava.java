package practice.eventTypes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventInJava extends JFrame implements MouseMotionListener {

    JLabel lblError;
    JButton btn;
    JTextField text;

    public EventInJava() {
        // Set layout to BoxLayout for the main content pane
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Panel to hold all components
        JPanel panel = new JPanel();
        JLabel lbl = new JLabel("Write your name");
        panel.add(lbl);

        // Create text field for user input
        text = new JTextField(15);
        // Set preferred sizes for the text field and button
        text.setPreferredSize(new Dimension(150, 30));
        panel.add(text);

        // Create a label for error messages
        lblError = new JLabel("");
        panel.add(lblError);


        btn = new JButton("Click Me");
        btn.setPreferredSize(new Dimension(80, 30));
        panel.add(btn);

        // Layout the components inside the panel using FlowLayout
        panel.setLayout(new FlowLayout());
        add(panel);

        // JFrame settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 250);
        setVisible(true);

        // Call method to handle events
        handleEvents();
    }

    public void handleEvents() {
        this.addMouseMotionListener(this);

        // Add a mouse listener to the button for detecting clicks
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String data = text.getText();
                if (data.isEmpty()) {
                    lblError.setForeground(Color.RED);
                    lblError.setText("Please enter your name");
                } else {
                    lblError.setForeground(Color.BLACK);
                    lblError.setText("Name: " + data);
                }
            }
        });

        text.addActionListener(new MyActionListener());


    }
    @Override
    public void mouseDragged(MouseEvent e){
        lblError.setForeground(Color.BLUE);
        lblError.setText("Your mouse is dragged.....");

    }
    @Override
    public  void mouseMoved(MouseEvent e){
        lblError.setForeground(Color.GREEN);
        lblError.setText("Your mouse is moved....."+ e.getX() +","+ e.getY());
    }
    class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String data = text.getText();
            if (data.isEmpty()){
                lblError.setForeground(Color.RED);
                lblError.setText("Please enter your name");

            } else{
                lblError.setForeground(Color.BLACK);
                lblError.setText("Name: " + data);
            }
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        new EventInJava();
    }
}
