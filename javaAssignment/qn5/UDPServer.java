// Q8. Write a GUI based Java program to demonstrate UDP based message passing mechanism. Design a server-side message box with send button and a client-side message displaying label with server’s IP address and port information. The message flows from server to client only. 

package qn5;

import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.io.*;

public class UDPServer extends JFrame {
    private JTextField messageField;
    private JButton sendButton;
    private DatagramSocket socket;

    public UDPServer() {
        setTitle(" UDP Message Sender");
        setSize(450, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(15, 15));

        JLabel promptLabel = new JLabel("Send the  data  to client:");
        messageField = new JTextField(25);
        sendButton = new JButton("Send Cheer");
        sendButton.setPreferredSize(new Dimension(120, 30));

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        inputPanel.add(promptLabel);
        inputPanel.add(messageField);
        inputPanel.add(sendButton);

        add(inputPanel, BorderLayout.CENTER);

        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            JOptionPane.showMessageDialog(this,
                    "Oh no! Couldn't set up our message sender: " + e.getMessage(),
                    "Setup Trouble",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        sendButton.addActionListener(e -> sendMessage());
        messageField.addActionListener(e -> sendMessage());

        setVisible(true);
    }

    private void sendMessage() {
        String message = messageField.getText().trim();
        if (message.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Oops! Type some cheer to send first!",
                    "No Message",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            byte[] sendData = message.getBytes();
            InetAddress clientAddress = InetAddress.getByName("localhost");
            int clientPort = 9876;

            DatagramPacket sendPacket = new DatagramPacket(
                    sendData, sendData.length, clientAddress, clientPort);
            socket.send(sendPacket);

            JOptionPane.showMessageDialog(this,
                    "Woohoo! Your  message is on its way!",
                    "Sent!",
                    JOptionPane.INFORMATION_MESSAGE);
            messageField.setText("");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    " Couldn't send the message: " + e.getMessage(),
                    "Sending Trouble",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new UDPServer();
    }
}
