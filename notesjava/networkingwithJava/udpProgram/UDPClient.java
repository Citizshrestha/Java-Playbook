package notesjava.networkingwithJava.udpProgram;

import java.net.*;
public class UDPClient {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();
            String clientMsg =  "Hey server how is it going man?";
            byte[] sendBuffer = clientMsg.getBytes();
     
            InetSocketAddress servdetails = new InetSocketAddress("localhost",5000);
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length,servdetails);
            clientSocket.send(sendPacket);

            byte[] receiveBuffer = new byte[1024];
            DatagramPacket rPacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            clientSocket.receive(rPacket);

            String serverResponse = new String(rPacket.getData()).trim();
            System.out.println("Server Response: "+serverResponse);

            clientSocket.close();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
}
