package layouts.flowLayout;

import java.awt.*;
import javax.swing.*;

public class FlowLayoutUI extends JFrame  {
    public FlowLayoutUI(){
        setTitle("FlowLayout Demo");
        setSize(400,300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel lbl = new JLabel("Enter your name");
        JTextField namField = new JTextField(15);
        JButton sendBtn = new JButton("SEND");
        JButton exitBtn = new JButton("EXIT");

        add(lbl);
        add(namField);
        add(sendBtn);
        add(exitBtn);

        sendBtn.addActionListener(e -> {
            JDialog dialog = new JDialog(this,"message", true);
            dialog.setLayout(new FlowLayout());
            dialog.setSize(250,150);

            String input = namField.getText().trim();
            String message = input.isEmpty()? "Hey, type a name first" : "Hello"+ input + "!";
            dialog.add(new JLabel(message));

            JButton okBtn = new JButton("OK");
            okBtn.addActionListener(event -> dialog.dispose());
            dialog.add(okBtn);

            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        });

        exitBtn.addActionListener(e -> dispose());

        setVisible(true);
    }
    public static void main(String[] args) {
        new FlowLayoutUI();
    }
}