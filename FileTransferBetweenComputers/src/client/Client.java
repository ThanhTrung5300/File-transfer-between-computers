package client;
import java.awt.Component;
import java.io.*; 
import java.net.*;
public class Client {
	Component frame = null;
	public int client(String fileName, int port, String host) throws Exception {
		String serverHostname = new String (host);
		InetAddress IPAddress = InetAddress.getByName(serverHostname);
		DatagramSocket clientSocket = new DatagramSocket();
		DatagramPacket receivePacket;
		byte[] arr = new byte[1024];
		byte[] b = new byte[1024];
		String mess = new String("Begin");
		b = mess.getBytes();
		sendData(b, IPAddress, port);
		clientSocket.close();
		File destFile = new File("G:\\file\\"+fileName);
		FileOutputStream fos = new FileOutputStream(destFile, true);
		long i = 0;
		System.out.println("Waiting for server connect...");
		clientSocket = new DatagramSocket(port);
		receivePacket = new DatagramPacket(arr, 0, arr.length);
		clientSocket.receive(receivePacket);
		System.out.println("Begin transfer...");
		while (receivePacket.getLength() == 1024) {
			if (receivePacket.getLength() == 1024) {
				fos.write(arr);
				i++;
				System.out.println("# "+i+ " kb");
			}
			receivePacket = new DatagramPacket(arr, 0, arr.length);
			clientSocket.receive(receivePacket);
		}
		System.out.println("finish");
		fos.close();
		clientSocket.close();
		return 1;
	}
	public static void sendData(byte[] b, InetAddress IPAddress, int port) throws Exception {
		DatagramSocket clientSocket = new DatagramSocket();
		DatagramPacket sendPacket = new DatagramPacket(b, b.length, IPAddress, port);
		clientSocket.send(sendPacket);
		clientSocket.close();
	}
}
