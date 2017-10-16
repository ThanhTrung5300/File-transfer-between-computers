package server;
import java.io.*;
import java.net.*;
<<<<<<< HEAD
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
public class Server extends SwingWorker<Void, Integer> {
	private String name;
	private int port;
	private Component frame = null;
	private static DatagramSocket serverSocket;
	private int length;
	public int done;
	public Server(String name, int port) {
		super();
		this.name = name;
		this.port = port;
	}
	public int getDone() {
		//System.out.println("this "+this.done);
		return done;
	}
	public static void sendData(byte[] arr, InetAddress IPAddress, int port) throws Exception {
		serverSocket = new DatagramSocket();
		DatagramPacket sendPacket = new DatagramPacket(arr, arr.length, IPAddress, port);
		serverSocket.send(sendPacket);
	}
	@Override
	protected Void doInBackground() throws Exception {
		DatagramSocket serverSocket = new DatagramSocket(port);
		DatagramPacket receivePacket;
		byte[] arr = new byte[1024];
		receivePacket = new DatagramPacket(arr, 0, arr.length);
		serverSocket.receive(receivePacket);
		InetAddress IPAddress = receivePacket.getAddress();
		String command = new String(receivePacket.getData());
		serverSocket.close();
		serverSocket = new DatagramSocket();
		command = command.trim();
		JOptionPane.showMessageDialog(frame, command);
		System.out.println(command);
		if (command.equalsIgnoreCase("Begin")) {
			File sourceFile = new File("G:\\file\\"+name);
			FileInputStream fis = new FileInputStream(sourceFile);
			byte[] b = new byte[1024];
			length = (int) sourceFile.length();
			String len = String.valueOf(length);
			b = (len).getBytes();
			sendData(b, IPAddress, port);
			long i = 0;
			int count = length/(102400), process = 0;
			if (sourceFile.exists()) {
				System.out.println("Begin transfer...");
=======
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
>>>>>>> parent of 48b01a4... Hoàn thành cơ bản giao diện sử dụng và gửi nhận file thành công
				while (fis.read(arr) != -1) {
					sendData(arr, IPAddress, 9876);
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
				String stop = new String("stop");
<<<<<<< HEAD
				byte[] br = new byte[1024];
				br = stop.getBytes();
				sendData(br, IPAddress, port);
=======
				byte[] b = new byte[1024];
				b = stop.getBytes();
				sendData(b, IPAddress, 9876);
>>>>>>> parent of 48b01a4... Hoàn thành cơ bản giao diện sử dụng và gửi nhận file thành công
				fis.close();
				serverSocket.close();
				
				System.out.println("finish");
<<<<<<< HEAD
				this.done = 1;
			}
			else this.done = 0;
		}
		else this.done = -1;
		return null;
=======
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
>>>>>>> parent of 48b01a4... Hoàn thành cơ bản giao diện sử dụng và gửi nhận file thành công
	}
}
