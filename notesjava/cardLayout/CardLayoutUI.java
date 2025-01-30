package notesjava;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class CardLayoutUI extends JFrame implements ActionListener {
     public static void main(String[] args) {
        new CardLayoutUI();

    }
    CardLayout cardLayout;
     Container container;
     public CardLayoutUI(){
         cardLayout  =  new CardLayout(10,10);
         container =  getContentPane();
         setLayout(cardLayout);

         Button b1 = new Button("button1");
         Button b2 = new Button("button2");
         Button b3 = new Button("button3");
         Button b4 = new Button("button4");

         b1.addActionListener(this);
         b2.addActionListener(this);
         b3.addActionListener(this);
         b4.addActionListener(this);

         add("A",b1);
         add("B",b2);
         add("C",b3);
         add("D",b4);

         setVisible(true);
         setSize(400,400);
         onClose();
     }
     @Override
     public void actionPerformed(ActionEvent e){
         cardLayout.next(container);
     }
        public void onClose(){
         addWindowListener(new WindowAdapter(){
                     public void WindowClosing(WindowEvent e){
                   dispose();
                }
            });
        }
     }

