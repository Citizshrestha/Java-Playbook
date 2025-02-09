package notesjava.networkingwithJava.socketProgram;

import java.io.*;
import java.net.*;

public class ServerSocketDemo {
  public static void main(String[] args) {
    try{
      ServerSocket serverSocket = new ServerSocket(5000);
      System.out.println("Server  is waiting for client");

      Socket socket = serverSocket.accept();
      System.out.println("Client connected");

      BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      String msg = reader.readLine();
      System.out.println("Received from Client " + msg);

      reader.close();
      socket.close();
      serverSocket.close();
    } catch(IOException e){
     e.printStackTrace();
    }
  }
}
