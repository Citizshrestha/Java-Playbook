package layouts.gridlayout;

import java.awt.*;
import javax.swing.*;
public class GridLayoutUI extends JFrame {
    public GridLayoutUI(){
        setTitle("Calculator using GridLayout");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5,4,20,20));
        setSize(400,300);


        
        
        JButton acButton = new JButton("AC");
        JButton bracket =  new JButton("()");
        JButton percent =  new JButton("%");
        JButton div =  new JButton("/");
        JButton sevenBtn =  new JButton("7");
        JButton eightBtn =  new JButton("8");
        JButton nineButton =  new JButton("9");
        JButton mulButton =  new JButton("*");
        JButton fourButton =  new JButton("4");
        JButton fiveButton =  new JButton("5");
        JButton sixButton =  new JButton("6");
        JButton addButton =  new JButton("+");
        JButton oneButton =  new JButton("1");
        JButton twoButton =  new JButton("2");
        JButton threeButton =  new JButton("3");
        JButton  subButton=  new JButton("-");
        JButton zeroButton = new JButton("0");
        JButton pointButton = new JButton(".");
        JButton crossButton = new JButton("X");
        JButton equalsButton = new JButton("=");


        add(acButton);
        add(bracket);
        add(percent);
        add(div);
        add(sevenBtn);
        add(eightBtn);
        add(nineButton);
        add(mulButton);
        add(fourButton);
        add(fiveButton);
        add(sixButton);
        add(addButton);
        add(oneButton);
        add(twoButton);
        add(threeButton);
        add(subButton);
        add(zeroButton);
        add(pointButton);
        add(crossButton);
        add(equalsButton);






        setVisible(true);
    }

    public static void main(String[] args) {
        new GridLayoutUI();
    }
}
