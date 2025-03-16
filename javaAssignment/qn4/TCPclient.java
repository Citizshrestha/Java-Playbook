// Q6. Write a GUI based Java program to demonstrate TCP/IP based message passing mechanism. Design a client-side message box with send button and a server-side message displaying label with client’s IP address and port information. The message flows from client to server only.
package qn4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class TCPclient extends JFrame {
    JFrame frame;
    JTextField messageField;
    JButton sendButton;

    public TCPclient() {
        frame = new JFrame("TCP/IP Client");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        messageField = new JTextField(20);
        sendButton = new JButton("Send");

        add(new JLabel("Enter Message:"));
        add(messageField);
        add(sendButton);

        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        setVisible(true);
    }

    public void sendMessage() {
        try {
            Socket socket = new Socket("127.0.0.1", 5000);
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            String message = messageField.getText();

            if (!message.isEmpty()) {
                output.println(message);
                JOptionPane.showMessageDialog(frame, "Message Sent!");
                messageField.setText("");
            }

            output.close();
            socket.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Connection Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new TCPclient();
    }
}
