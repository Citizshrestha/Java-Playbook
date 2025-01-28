package notesjava.gridLayout;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GridLayoutUI{
  public static void main(String[] args)  {
    new GridLayoutUI();
  
  }
  JFrame frame;

  public GridLayoutUI(){
    frame = new JFrame();
    frame.setTitle("Calculator -- GridLayout");

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
    JButton add = new JButton("+");
    JButton subtract = new JButton("-");
    JButton divide = new JButton("/");
    JButton multiply = new JButton("*");
    JButton equal = new JButton("=");
    JButton decimal = new JButton(".");

      frame.add(b7);
      frame.add(b8);
      frame.add(b9);
      frame.add(divide);
      frame.add(b4);
      frame.add(b5);
      frame.add(b6);
      frame.add(multiply);
      frame.add(b3);
      frame.add(b2);
      frame.add(b1);
      frame.add(subtract);
      frame.add(b0);
      frame.add(decimal);
      frame.add(equal);
      frame.add(add);

    frame.setLayout(new GridLayout(4,4,10,10));
    frame.setVisible(true);
    frame.setSize(400,400);

    frame.addWindowListener(new WindowAdapter() {
       @Override
       public void windowClosing(WindowEvent e){
         frame.dispose();
       }

    });


    

    
  }
}