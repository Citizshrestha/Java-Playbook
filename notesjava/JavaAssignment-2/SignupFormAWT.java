import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SignupFormAWT extends Frame implements ActionListener {
    Label lblName, lblEmail, lblMobile, lblGender, lblAddress;
    TextField txtName, txtEmail, txtMobile;
    CheckboxGroup genderGroup;
    Checkbox male, female;
    TextArea txtAddress;
    Button btnSubmit;

    public SignupFormAWT() {
        setTitle("Signup Form");
        setSize(400, 400);
        setLayout(new GridLayout(6, 2, 10, 10));


        lblName = new Label("Name:");
        txtName = new TextField();


        lblEmail = new Label("Email:");
        txtEmail = new TextField();


        lblMobile = new Label("Mobile:");
        txtMobile = new TextField();


        lblGender = new Label("Gender:");
        genderGroup = new CheckboxGroup();
        male = new Checkbox("Male", genderGroup, false);
        female = new Checkbox("Female", genderGroup, false);
        Panel genderPanel = new Panel();
        genderPanel.add(male);
        genderPanel.add(female);


        lblAddress = new Label("Address:");
        txtAddress = new TextArea(3, 20);


        btnSubmit = new Button("Submit");
        btnSubmit.addActionListener(this);


        add(lblName);
        add(txtName);
        add(lblEmail);
        add(txtEmail);
        add(lblMobile);
        add(txtMobile);
        add(lblGender); add(genderPanel);
        add(lblAddress); add(txtAddress);
        add(new Label()); add(btnSubmit);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = txtName.getText().trim();
        String email = txtEmail.getText().trim();
        String mobile = txtMobile.getText().trim();
        String gender = genderGroup.getSelectedCheckbox() != null ? genderGroup.getSelectedCheckbox().getLabel() : "";
        String address = txtAddress.getText().trim();
    

        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Mobile: " + mobile);
        System.out.println("Gender: " + gender);
        System.out.println("Address: " + address);
    
        //  Validation Part
        if (name.isEmpty() || email.isEmpty() || mobile.isEmpty() || gender.isEmpty() || address.isEmpty()) {
            showMessage("All fields are required!");
            return;
        }
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            showMessage("Invalid email format!");
            return;
        }
        if (!mobile.matches("\\d{10}")) {
            showMessage("Mobile number must be 10 digits!");
            return;
        }
    
        // Store data in database
        try {
            // Establish the connection to the database
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/signup_schema", "root", "Citizstha9523");
            
            // Check if the connection is successful
            if (con != null) {
                System.out.println("Database connection successful!");
            } else {
                System.out.println("Database connection failed!");
            }
    
            PreparedStatement stmt = con.prepareStatement("INSERT INTO users (name, email, mobile, gender, address) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, mobile);
            stmt.setString(4, gender);
            stmt.setString(5, address);
    
            // Execute the update and check if data is inserted
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("No rows inserted.");
            }
            con.close();
            showMessage("Signup Successful!");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            showMessage("Database Error: " + ex.getMessage());
        }
    }
    
    

    private void showMessage(String message) {
        new Dialog(this, "Message", true) {{
            setLayout(new FlowLayout());
            add(new Label(message));
            Button ok = new Button("OK");
            ok.addActionListener(e -> dispose());
            add(ok);
            setSize(250, 100);
            setVisible(true);
        }};
    }

    public static void main(String[] args) {
        new SignupFormAWT();
    }
}

