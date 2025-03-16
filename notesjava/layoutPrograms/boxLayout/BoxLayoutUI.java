package layouts.boxlayout;

import javax.swing.*;
public class BoxLayoutUI extends JFrame {
    JButton[] button;
    final int noofBtns = 5;
    public BoxLayoutUI(){
        button = new JButton[noofBtns];

        for (int i=0; i<noofBtns;i++){
            button[i] = new JButton("Button"+ (i+1));
            add(button[i]);

        }

        setTitle("Box Layout Demo");
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        setSize(400,300);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new BoxLayoutUI();
    }
}
