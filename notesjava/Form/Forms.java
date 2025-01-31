package notesjava.Form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Forms {
    public static void main(String[] args) {
        new RegisterForm();
    }
}

class RegisterForm extends JFrame {
    JLabel lbl = new JLabel("Please Register this form");
    JLabel lbl1 = new JLabel("Full Name");
    JTextField tf = new JTextField(15);
    JLabel lbl2 = new JLabel("Address");
    JTextField tf2 = new JTextField(15);
    JLabel lbl3 = new JLabel("Gender");
    JRadioButton cb = new JRadioButton("Male");
    JRadioButton cb2 = new JRadioButton("Female");
    JButton btn = new JButton("Register");
    ButtonGroup genderGroup = new ButtonGroup();  // For grouping radio buttons

    public RegisterForm() {
        // Set layout and add components
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        JPanel panelT = new JPanel();
        panelT.add(lbl);
        add(panelT);

        JPanel panel = new JPanel();
        panel.add(lbl1);
        panel.add(tf);
        add(panel);

        JPanel panel2 = new JPanel();
        panel2.add(lbl2);
        panel2.add(tf2);
        add(panel2);

        JPanel panel3 = new JPanel();
        panel3.add(lbl3);
        panel3.add(cb);
        panel3.add(cb2);
        add(panel3);

        JPanel panel4 = new JPanel();
        panel4.add(btn);
        add(panel4);

       
        genderGroup.add(cb);
        genderGroup.add(cb2);

        
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validateForm();
            }
        });

        // Set JFrame properties
        setSize(600, 550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    // Method for validating form data
    private void validateForm() {
        String fullName = tf.getText().trim();
        String address = tf2.getText().trim();
        String gender = null;

        // Check if name and address are empty
        if (fullName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Full Name is required!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (address.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Address is required!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

     
        if (cb.isSelected()) {
            gender = "Male";
        } else if (cb2.isSelected()) {
            gender = "Female";
        } else {
            JOptionPane.showMessageDialog(this, "Gender selection is required!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

       
        JOptionPane.showMessageDialog(this, "Registration Successful!\n" +
                "Name: " + fullName + "\n" +
                "Address: " + address + "\n" +
                "Gender: " + gender, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
