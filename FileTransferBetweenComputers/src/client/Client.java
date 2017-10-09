package client;
import java.io.*; 
import java.net.*;
public class Client {
	public static void main(String[] args) throws Exception {
		String t = new String();
		DatagramSocket clientSocket = new DatagramSocket(9876);
		DatagramPacket receivePacket;
		byte[] arr = new byte[1024];
		File destFile = new File("G:\\file\\out.rar");
		FileOutputStream fos = new FileOutputStream(destFile, true);
		long i = 0;
		System.out.println("Begin");
		try {
			do {
				receivePacket = new DatagramPacket(arr, 0, arr.length);
				clientSocket.receive(receivePacket);
				if (receivePacket.getLength() == 1024) {
					fos.write(arr);
					i++;
					System.out.println("# "+i+ " kb");
				}
			} while (receivePacket.getLength() == 1024);
			System.out.println("finish");
			fos.close();
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
