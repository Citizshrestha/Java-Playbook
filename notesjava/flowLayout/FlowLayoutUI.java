package notesjava.flowLayout;

import java.awt.*;
import java.awt.event.*;

public class FlowLayoutUI  {
    public static void main(String[] args) {
        new FlowLayoutUI();

    }
    Frame frame;
    public FlowLayoutUI() {
         frame = new Frame();
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));

        Label label = new Label("Enter Name");
        TextField textField = new TextField(10);
        Button submitBtn = new Button("Submit");
        Button exitBtn = new Button("Exit");

        frame.add(label);
        frame.add(textField);
        frame.add(submitBtn);
        frame.add(exitBtn);

        textField.setPreferredSize(new Dimension(300,30));

        submitBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Dialog dialog = new Dialog(frame,"Message",true);
                dialog.setLayout(new FlowLayout(FlowLayout.CENTER));
                dialog.setSize(200,150);

                String message = textField.getText().isEmpty() ? "Please enter your name" : "Hello, " + textField.getText()+"!";
                dialog.add(new Label(message));

                Button okBtn  = new Button("OK");
                okBtn.addActionListener(event -> dialog.dispose());
                dialog.add(okBtn);


                dialog.setLocationRelativeTo(frame);
                dialog.setVisible(true);


            }
        });
        exitBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                System.out.println("Program ended");
            }
        });




        frame.setVisible(true);
        frame.setSize(400, 300);
        frame.setResizable(false);
    }
}