package Practic_19_20;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Server {
    public static void main(String[] args) throws IOException {
        byte[] buffer = new byte[2048];
        DatagramSocket datagramSocket = new DatagramSocket(722);
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
        DatagramPacket toPacket;
        String message;
        StringBuilder toMessage = new StringBuilder();
        StringBuilder history = new StringBuilder();
        HashMap<String, String> userNameAndIP = new HashMap<>();
        ArrayList<InetAddress> addressIp = new ArrayList<>();
        ArrayList<Integer> ports = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date;
        File file = new File("src/main/java/Practic_19_20/history.txt");

        file.createNewFile();

        while (true) {
            datagramSocket.receive(packet);
            message = new String(buffer, 0, packet.getLength());
            date = new Date();
            toMessage.append(dateFormat.format(date) + " | ");

            if (userNameAndIP.get(packet.getAddress().getHostAddress() + packet.getPort()) == null
                    || ports.indexOf(packet.getPort()) == -1) {
                userNameAndIP.put(packet.getAddress().getHostAddress() + packet.getPort(), message);
                toMessage.append("Server: Hello, " + message);
                addressIp.add(packet.getAddress());
                ports.add(packet.getPort());
            } else {
                toMessage.append(userNameAndIP.get(packet.getAddress().getHostAddress() + packet.getPort()) + ": ");
                toMessage.append(message);
            }

            for (int i = 0; i < addressIp.size(); i++) {
                toPacket = new DatagramPacket(toMessage.toString().getBytes(),
                        0,
                        toMessage.length(),
                        addressIp.get(i),
                        ports.get(i));
                datagramSocket.send(toPacket);
            }

            System.out.println(toMessage);
            history.append(toMessage.toString() + "\n");
            toMessage = new StringBuilder();
            try (PrintWriter writerFile = new PrintWriter(file)) {
                writerFile.write(history.toString());
            } catch (IOException e) {
                e.getStackTrace();
            }

        }
    }
}
