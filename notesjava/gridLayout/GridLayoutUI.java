package notesjava.gridLayout;



import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GridLayoutUI {

    public static void main(String[] args) {
        new GridLayoutUI();
    }
    JFrame frame;

    public GridLayoutUI() {

        frame = new JFrame();
        JButton b0 = new JButton("0");
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton multiply = new JButton("X");
        JButton divide = new JButton("/");
        JButton equal = new JButton("=");
        JButton decimal = new JButton(".");

        frame.setLayout(new GridLayout(4, 4, 15, 10));
        frame.add(b7);
        frame.add(b8);
        frame.add(b9);
        frame.add(divide);
        frame.add(b4);
        frame.add(b5);
        frame.add(b6);
        frame.add(multiply);
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(minus);
        frame.add(decimal);
        frame.add(b0);
        frame.add(equal);
        frame.add(plus);

        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setTitle("Calculator - Grid Layout");

        // To close the window after clicking X button.
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }

}
