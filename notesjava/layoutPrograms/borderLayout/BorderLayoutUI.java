package layouts.borderlayout;

import java.awt.*;

import javax.swing.*;

public class BorderLayoutUI extends JFrame {
    public BorderLayoutUI() {
        setTitle("Border Layout Demo");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,300);
        setLayout(new BorderLayout());

        JLabel lblNorth = new JLabel("North");
        JLabel lblSouth = new JLabel("South");
        JLabel lblCenter = new JLabel("Center");
        JLabel lblWest = new JLabel("West");
        JLabel lblEast = new JLabel("East");

        lblNorth.setHorizontalAlignment(JLabel.CENTER);
        lblSouth.setHorizontalAlignment(JLabel.CENTER);
        lblCenter.setHorizontalAlignment(JLabel.CENTER);
        lblEast.setHorizontalAlignment(JLabel.CENTER);
        lblWest.setHorizontalAlignment(JLabel.CENTER);


        add(lblNorth, BorderLayout.NORTH);
        add(lblSouth, BorderLayout.SOUTH);
        add(lblCenter, BorderLayout.CENTER);
        add(lblWest, BorderLayout.WEST);
        add(lblEast, BorderLayout.EAST);

        setVisible(true);
    }

    public static void main(String[] args) {
        new BorderLayoutUI();
    }
}