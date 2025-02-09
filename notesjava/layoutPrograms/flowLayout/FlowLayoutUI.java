package layoutPrograms.flowLayout;

import java.awt.*;
import java.awt.event.*;

public class FlowLayoutUI extends Frame   {
    public static void main(String[] args) {
        new FlowLayoutUI();

    }
    Frame frame;
    public FlowLayoutUI() {
         frame = new Frame();
        setLayout(new FlowLayout(FlowLayout.CENTER));

        Label label = new Label("Enter Name");
        TextField textField = new TextField(10);
        Button submitBtn = new Button("Submit");
        Button exitBtn = new Button("Exit");

       add(label);
        add(textField);
        add(submitBtn);
        add(exitBtn);

        textField.setPreferredSize(new Dimension(300,30));

        submitBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Dialog dialog = new Dialog(frame,"Messages",true);
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
        exitBtn.addActionListener(event -> dispose());




        setVisible(true);
        setSize(400, 300);
        setResizable(false);
    }
}