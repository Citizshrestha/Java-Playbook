package notesjava.networkingwithJava.udpProgram;


import java.net.*;

public class UDPServer{
    public static void main(String[] args) {
     try {
        DatagramSocket serverSocket = new DatagramSocket(5000);
        byte[] receiveBuffer = new byte[1024];

        DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
        serverSocket.receive(receivePacket);

        String clientMsg =  new String(receivePacket.getData()).trim();
        System.out.println("Client says: "+clientMsg);

        String serverResponse = "Yo client whats upp?";
        byte[] sendBuffer = serverResponse.getBytes();

        InetAddress clientAddress = receivePacket.getAddress();
        int clientPort = receivePacket.getPort();

        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length,clientAddress,clientPort);
        serverSocket.send(sendPacket);

        serverSocket.close();
     } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
     }
    }
}