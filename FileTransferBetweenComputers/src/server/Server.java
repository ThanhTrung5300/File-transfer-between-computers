package server;
import java.awt.Component;
import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;
public class Server {
	Component frame = null;
	public int server(String name, int port) throws Exception {
		DatagramSocket serverSocket = new DatagramSocket(port);
		DatagramPacket receivePacket;
		byte[] arr = new byte[1024];
		receivePacket = new DatagramPacket(arr, 0, arr.length);
		serverSocket.receive(receivePacket);
		InetAddress IPAddress = receivePacket.getAddress();
		int portt = receivePacket.getPort();
		String command = new String(receivePacket.getData());
		serverSocket.close();
		serverSocket = new DatagramSocket();
		JOptionPane.showMessageDialog(frame, command);
		System.out.println(command);
		command = command.trim();
		if (command.equalsIgnoreCase("Begin")) {
			File sourceFile = new File("G:\\file\\"+name);
			FileInputStream fis = new FileInputStream(sourceFile);
			long i = 0;
			if (sourceFile.exists()) {
				System.out.println("Begin transfer...");
				while (fis.read(arr) != -1) {
					sendData(arr, IPAddress, port);
					i++;
					System.out.println("# "+i+ " kb");
				}
				String stop = new String("stop");
				byte[] b = new byte[1024];
				b = stop.getBytes();
				sendData(b, IPAddress, port);
				fis.close();
				serverSocket.close();
				System.out.println("finish");
			}
			else return 0;
			return 1;
		}
		else return -1;
	}
	public static void sendData(byte[] arr, InetAddress IPAddress, int port) throws Exception {
		DatagramSocket serverSocket = new DatagramSocket();
		DatagramPacket sendPacket = new DatagramPacket(arr, arr.length, IPAddress, port);
		serverSocket.send(sendPacket);
	}
}
