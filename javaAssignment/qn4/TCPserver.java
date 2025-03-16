// Q6. Write a GUI based Java program to demonstrate TCP/IP based message passing mechanism. Design a client-side message box with send button and a server-side message displaying label with client’s IP address and port information. The message flows from client to server only.
package javaAssignment2.qn4;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class TCPserver extends JFrame {
     JFrame frame;
     JTextArea textArea;
     ServerSocket serverSocket;

    public TCPserver() {
        frame = new JFrame("Friendly TCP Chat Server");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        setVisible(true);

        startServer();
    }

    public void startServer() {
        try {
            serverSocket = new ServerSocket(5000);
            textArea.append("Hello! I'm your chat server, now listening on port 5000...\n");
            textArea.append("Waiting for Client to say hi!\n\n");

            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    InetAddress clientAddress = clientSocket.getInetAddress();
                    int clientPort = clientSocket.getPort();

                    BufferedReader input = new BufferedReader(
                            new InputStreamReader(clientSocket.getInputStream()));
                    String message = input.readLine();

                    if (message != null) {
                        textArea.append("Client [" + clientAddress.getHostAddress() +
                                ":" + clientPort + "] says: " + message + "\n");
                    } else {
                        textArea.append("Client [" + clientAddress.getHostAddress() +
                                ":" + clientPort + "] visited but said nothing!\n");
                    }

                    input.close();
                    clientSocket.close();

                } catch (IOException e) {
                    textArea.append("Oops! Had a little trouble chatting: " +
                            e.getMessage() + "\n");
                }
            }
        } catch (IOException e) {
            textArea.append("Oh no! I couldn't open the chat room: " +
                    e.getMessage() + "\n");
            JOptionPane.showMessageDialog(frame,
                    "Sorry, I couldn't start the server: " + e.getMessage(),
                    "Server Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new TCPserver();
    }
}