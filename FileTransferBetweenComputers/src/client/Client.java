package client;
import java.io.*; 
import java.net.*;
<<<<<<< HEAD
import javax.swing.SwingWorker;
public class Client extends SwingWorker<Void, Integer> {
	private int length;
	private String fileName;
	private int port;
	private String host;
	public int done = 0;
	public Client(String fileName, int port, String host) {
		super();
		this.fileName = fileName;
		this.port = port;
		this.host = host;
	}
	public int getDone() {
		//System.out.println("this "+this.done);
		return done;
	}
	public static void sendData(byte[] b, InetAddress IPAddress, int port) throws Exception {
		DatagramSocket clientSocket = new DatagramSocket();
		DatagramPacket sendPacket = new DatagramPacket(b, b.length, IPAddress, port);
		clientSocket.send(sendPacket);
		clientSocket.close();
	}
	@Override
	protected Void doInBackground() throws Exception {
		String serverHostname = new String(host);
		InetAddress IPAddress = InetAddress.getByName(serverHostname);
		DatagramSocket clientSocket = new DatagramSocket();
=======
public class Client {
	public static void main(String[] args) throws Exception {
		String t = new String();
		DatagramSocket clientSocket = new DatagramSocket(9876);
>>>>>>> parent of 48b01a4... Hoàn thành cơ bản giao diện sử dụng và gửi nhận file thành công
		DatagramPacket receivePacket;
		byte[] arr = new byte[1024];
		File destFile = new File("G:\\file\\out.rar");
		FileOutputStream fos = new FileOutputStream(destFile, true);
		long i = 0;
<<<<<<< HEAD
		clientSocket = new DatagramSocket(port);
		receivePacket = new DatagramPacket(arr, 0, arr.length);
		clientSocket.receive(receivePacket);
		String len = new String(receivePacket.getData());
		clientSocket.close();
		len = len.trim();
		length = Integer.parseInt(len);
		int count = length/(102400), process = 0;
		System.out.println("Waiting for server connect...");
		clientSocket = new DatagramSocket(port);
		receivePacket = new DatagramPacket(arr, 0, arr.length);
		clientSocket.receive(receivePacket);
		System.out.println("Begin transfer...");
		while (receivePacket.getLength() == 1024) {
			if (receivePacket.getLength() == 1024) {
				fos.write(arr);
				i++;
				if (i == count) {
					count += length/102400;
					process ++;
					publish(process);
					setProgress(Math.min(process, 100));
					System.out.println("=========>"+process+"%");
				}
				System.out.println("# "+i+ " kb");
			}
			receivePacket = new DatagramPacket(arr, 0, arr.length);
			clientSocket.receive(receivePacket);
		}
		System.out.println("finish");
		done = 1;
		fos.close();
		clientSocket.close();
		return null;
=======
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
>>>>>>> parent of 48b01a4... Hoàn thành cơ bản giao diện sử dụng và gửi nhận file thành công
	}
}
