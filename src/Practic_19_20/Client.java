package Practic_19_20;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){
        try {
            DatagramSocket socket = new DatagramSocket(248);
            System.out.print("Enter your name: ");
            Thread thread = new Thread(() -> getMessage(socket));
            thread.start();
            thread = new Thread(() -> sendMessage(socket));
            thread.start();
        }catch(SocketException e){
            e.getStackTrace();
        }
    }

    public static void getMessage(DatagramSocket socket) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            DatagramPacket toPacket;
            byte[] toSendBuffer = scanner.nextLine().getBytes();
            try {
                toPacket = new DatagramPacket(toSendBuffer, 0, toSendBuffer.length, InetAddress.getByName("192.168.1.34"), 722);
                socket.send(toPacket);
            } catch (UnknownHostException e) {
                e.getStackTrace();
            } catch (IOException e) {
                e.getStackTrace();
            }
        }
    }

    public static void sendMessage(DatagramSocket socket) {
        while (true) {
            byte[] buffer = new byte[2048];
            DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
            String message;
            try {
                socket.receive(packet);
                message = new String(buffer, 0, packet.getLength());
                System.out.println(message);
            } catch (IOException e) {
                e.getStackTrace();
            }
        }
    }

}
