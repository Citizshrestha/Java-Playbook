//Q3. Design a ‘Contact Us’ form consisting of First Name, Last Name, Email Address and Message fields.
//Validate the form for empty and invalid entries. Store the information in a database.

package javaAssignment2.qn3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ContactForm extends JFrame implements ActionListener {
    JTextField fName, sName, email;
    JTextArea msgField, displayArea;
    JButton submitBtn;

    public ContactForm() {
        setTitle("Contact Form");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2, 15, 15)); // 7 rows, 2 columns = 14 slots

        fName = new JTextField(10);
        sName = new JTextField(10);
        email = new JTextField(10);
        msgField = new JTextArea(3, 20);
        submitBtn = new JButton("Submit");
        submitBtn.addActionListener(this);
        displayArea = new JTextArea(5, 30);
        displayArea.setEditable(false);

        add(new JLabel("First Name"));
        add(fName);
        add(new JLabel("Last Name"));
        add(sName);
        add(new JLabel("Email"));
        add(email);
        add(new JLabel("Message"));
        add(msgField);
        add(submitBtn);
        add(new JLabel("")); // Placeholder
        add(new JLabel("Display Area"));
        add(displayArea);
        add(new JLabel("")); // Placeholder

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String firstName = fName.getText().trim();
        String lastName = sName.getText().trim();
        String emailStr = email.getText().trim(); // Fixed: Renamed 'emails' to 'emailStr' for clarity
        String message = msgField.getText().trim();

        // Validation
        if (firstName.isEmpty() || lastName.isEmpty() || emailStr.isEmpty() || message.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields");
            return;
        }

        if (!emailStr.contains("@") || !emailStr.contains(".")) {
            JOptionPane.showMessageDialog(null, "Please enter a valid email address");
            return;
        }

        if (message.length() < 6) {
            JOptionPane.showMessageDialog(null, "Please enter a message of at least 6 characters");
            return;
        }

        // Store data in database
        try {
            // Load MySQL JDBC driver (required for newer JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connect to database
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/contact_db", "root", "Citizstha9523");

            if (con != null) {
                System.out.println("Database Connection Successful");
            } else {
                System.out.println("Database Connection Failed");
            }

            // Fixed: Correct column names and number of parameters (id is AUTO_INCREMENT, so exclude it)
            PreparedStatement pstmt = con.prepareStatement(
                    "INSERT INTO contacts (firstName, lastName, email, message) VALUES (?, ?, ?, ?)");
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, emailStr);
            pstmt.setString(4, message);

            // Fixed: Typo 'stmt' to 'pstmt' and added execution
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully.");
                // Display in JTextArea
                displayArea.setText("Contact Form Details:\n" +
                        "First Name: " + firstName + "\n" +
                        "Last Name: " + lastName + "\n" +
                        "Email: " + emailStr + "\n" +
                        "Message: " + message + "\n");
                JOptionPane.showMessageDialog(null, "Data saved successfully!");
            } else {
                System.out.println("No rows inserted.");
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            System.out.println("JDBC Driver not found: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Database Error: Driver not found");
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new ContactForm();
    }
}

//CREATE DATABASE contact_db;
//USE contact_db;
//
//CREATE TABLE contacts(
//        id INT auto_increment PRIMARY KEY,
//        firstName VARCHAR(100) NOT NULL,
//lastName VARCHAR(100) NOT NULL,
//email VARCHAR(100) NOT NULL,
//message TEXT NOT NULL
//);
//
//
//select * from contacts;
