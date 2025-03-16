// Q8. Write a GUI based Java program to demonstrate UDP based message passing mechanism. Design a server-side message box with send button and a client-side message displaying label with server’s IP address and port information. The message flows from server to client only. 
package qn5;

import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.io.*;

public class UDPClient extends JFrame {
    private JLabel messageLabel;
    private JLabel serverInfoLabel;
    private DatagramSocket socket;

    public UDPClient() {
        setTitle(" UDP Message Receiver");
        setSize(450, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(15, 15));
        setLocationRelativeTo(null);

        serverInfoLabel = new JLabel("Waiting for a friend to say hi...");
        serverInfoLabel.setHorizontalAlignment(JLabel.CENTER);
        serverInfoLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        messageLabel = new JLabel("Ready for cheerful messages!");
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        add(serverInfoLabel, BorderLayout.NORTH);
        add(messageLabel, BorderLayout.CENTER);

        try {
            socket = new DatagramSocket(9876);
            new Thread(this::receiveMessages).start();
        } catch (SocketException e) {
            JOptionPane.showMessageDialog(this,
                    "Oh! Couldn't set up to receive messages: " + e.getMessage(),
                    "Setup Trouble",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        setVisible(true);
    }

    private void receiveMessages() {
        byte[] receiveData = new byte[1024];

        while (true) {
            try {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                InetAddress serverAddress = receivePacket.getAddress();
                int serverPort = receivePacket.getPort();

                serverInfoLabel.setText("Our server at " + serverAddress.getHostAddress() +
                        ":" + serverPort + " says hi!");
                messageLabel.setText("They said: " + message);

            } catch (IOException e) {
                messageLabel.setText("Oops! Trouble in receiving meesage from client: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new UDPClient();
    }
}