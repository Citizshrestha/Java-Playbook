package notesjava.networkingwithJava.tcp;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    
    public static void main(String[] args) throws IOException {
        
        /***
            Steps to create a server to serve clients.
            Step 1: Create a server socket.
            Step 2: Listen for clients to connect and accept the connection.
            Step 3: Receive messages from client using Data Input Stream.
            Step 4: Send message to client using Data Output Stream.
            Step 5: Close the streams and sockets.
        ***/
        
        System.out.println("=+=+= This is Server Machine =+=+=");
        
        // Create a server socket to serve clients.
        ServerSocket serverSocket = new ServerSocket(2000);
        System.out.println("Server is running and listening for clients..");
        
        // Listen for a client to connect to this socket and accept it.
        Socket clientSocket = serverSocket.accept();
        String clientSocketIP = clientSocket.getInetAddress().toString();
        int clientSocketPort = clientSocket.getPort();
        
        System.out.println("[IP: " + clientSocketIP + " , Port: " + clientSocketPort +"]  " + "Client Connection Successful!");

        // Receive message from the client.
        DataInputStream dataIn = new DataInputStream(clientSocket.getInputStream());
        String clientMessage = dataIn.readUTF();
        System.out.println("Message: " + clientMessage);
        
        // Send message back to the client.
        String serverMessage = "Hi, this is coming from Server!  I received your message.";
        DataOutputStream dataOut = new DataOutputStream(clientSocket.getOutputStream());
        dataOut.writeUTF(serverMessage);

        // Close the streams and sockets.
        dataIn.close();
        dataOut.close();
        serverSocket.close();
        clientSocket.close();
    }
    
}
