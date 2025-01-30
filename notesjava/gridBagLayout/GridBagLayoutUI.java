package notesjava.gridBagLayout;


// import java.awt.Button;
// import java.awt.Frame;
// import java.awt.GridBagConstraints;
// import java.awt.GridBagLayout;
// import java.awt.event.WindowAdapter;
// import java.awt.event.WindowEvent;
import java.awt.*;
import java.awt.event.*;

import notesjava.gridLayout.GridLayoutUI;

public class GridBagLayoutUI extends Frame{
  public static void main(String[] args) {
    new GridBagLayoutUI();
  }
  public GridBagLayoutUI(){
    GridBagLayout gridbagLayout = new GridBagLayout();
    setLayout(gridbagLayout);
    setSize(300,300);
    setTitle("GridbagLaYOUT Demo");
    setVisible(true);

    Label user = new Label("Username");
    TextField userTxt = new TextField(10);
    Button loginBtn = new Button("Login");

    Label pwd = new Label("Password");
    TextField pwdText = new TextField(10);

  

    GridBagConstraints constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.HORIZONTAL;
    constraints.gridx = 0;
    constraints.gridy  = 0;
    add(user,constraints);

    constraints.gridx = 1;
    constraints.gridy = 0;
    add(userTxt,constraints);

    constraints.fill = GridBagConstraints.HORIZONTAL;
    constraints.gridx = 0;
    constraints.gridy = 1;
    add(pwd,constraints);

    constraints.gridx = 1;
    constraints.gridy = 1;
    add(pwdText,constraints);

    constraints.gridwidth =2;
    constraints.gridx  = 0;
    constraints.gridy  = 2;
    add(loginBtn,constraints);

    onClose();
  }
  public void onClose(){
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e){
        dispose();
      }
    });
  }
}