package notesjava.networkingwithJava.socketProgram;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocketDemo {
  public static void main(String[] args) {
    try{
      Socket socket = new Socket("localhost",5000);
      System.out.println("Connected to server!");

      PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
      writer.println("Hello server , this is client");

      writer.close();
      socket.close();
    } catch(IOException e){
      e.printStackTrace();
    }
  }
}
