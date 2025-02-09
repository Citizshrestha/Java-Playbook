package notesjava.networkingwithJava.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

    
    public static void main(String[] args) throws UnknownHostException, IOException {
        
        /***
            Steps to communicate to server.
            Step 1: Create a client socket.
            Step 2: Create a server socket using server IP address and port number.
            Step 3: Connect the client socket to server using server details.
            Step 4: Send messages to server using Data Output Stream.
            Step 5: Receive message from server using Data Input Stream.
            Step 5: Close the streams and sockets.
        ***/
        
        System.out.println("=+=+= This is Client Machine =+=+=");
        
        // Create a client socket to connect to the server.
        Socket socket = new Socket();
        
        // Create server details with Server IP + Port number, and then connect.
        InetSocketAddress serverDetails = new InetSocketAddress(InetAddress.getLocalHost(), 2000);
        socket.connect(serverDetails, 1000);
        System.out.println("[IP: " + serverDetails.getAddress() + " , Port: " + serverDetails.getPort() +"]  " + 
                "Server Connection Successful!");
        
        // Send a message to the server.
        DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
        dataOut.writeUTF("Hello, This is coming from Client! Reply me soon as you get this.");
        
        // Receive message from the server.
        DataInputStream dataIn = new DataInputStream(socket.getInputStream());
        String serverMessage = dataIn.readUTF();
        System.out.println("Message: " + serverMessage);

        // Close the streams and socket.
        dataIn.close();
        dataOut.close();
        socket.close();
    }
    
}

