package server;
import java.io.*;
import java.net.*;
public class Server {
	public static void main(String[] args) throws Exception {
		String serverHostname = new String ("localhost");
		InetAddress IPAddress = InetAddress.getByName(serverHostname);
		DatagramSocket serverSocket = new DatagramSocket();
		byte[] arr = new byte[1024];
		File sourceFile = new File("G:\\file\\qq.rar");
		FileInputStream fis = new FileInputStream(sourceFile);
		System.out.println("Begin");
		long i = 0;
		if (sourceFile.exists()) {
			try {
				while (fis.read(arr) != -1) {
					sendData(arr, IPAddress, 9876);
					i++;
					System.out.println("# "+i+ " kb");
				}
				String stop = new String("stop");
				byte[] b = new byte[1024];
				b = stop.getBytes();
				sendData(b, IPAddress, 9876);
				fis.close();
				serverSocket.close();
				
				System.out.println("finish");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void sendData(byte[] arr, InetAddress IPAddress, int port) throws Exception {
		DatagramPacket sendPacket;
		sendPacket = new DatagramPacket(arr, arr.length, IPAddress, port);
		DatagramSocket serverSocket = new DatagramSocket();
		serverSocket.send(sendPacket);
	}
}
