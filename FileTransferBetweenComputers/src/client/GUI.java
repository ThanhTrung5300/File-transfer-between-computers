package client;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class GUI extends JFrame implements ActionListener{
	private JTextField txtFileName;
	private JButton btnStart;
	private JButton btnExit;
	private JTextField txtPort;
	private JTextField txtHost;
	Component frame = null;
	public GUI() {
		setSize(500, 270);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		//setLocationRelativeTo(null);
		Box b, b1, b2, b3, b4, b5;
		add(b = Box.createVerticalBox());
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b5 = Box.createHorizontalBox());
		b1.add(txtHost = new JTextField());
		b1.setBorder(BorderFactory.createTitledBorder("Enter host you want to connect"));
		b2.add(txtPort = new JTextField());
		b2.setBorder(BorderFactory.createTitledBorder("Enter port"));
		b3.add(txtFileName = new JTextField());
		b3.setBorder(BorderFactory.createTitledBorder("Enter file name you want to save"));
		b4.add(btnStart = new JButton("Start"));
		b5.add(btnExit = new JButton("Exit"));
		b.add(Box.createVerticalStrut(10));
		btnStart.addActionListener(this);
		btnExit.addActionListener(this);
	}
	public static void main(String[] args) {
		new GUI().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnStart)) {
			JOptionPane.showMessageDialog(frame, "Start connect to Server");
			Client cl = new Client();
			String name = txtFileName.getText();
			int port;
			if ((txtPort.getText()).equalsIgnoreCase("")) port = 9876;
			else port = Integer.parseInt(txtPort.getText());
			String host = txtHost.getText();
			try {
				if (host.equalsIgnoreCase("")) host = new String("localhost");
				if (name.equalsIgnoreCase("")) name = new String("out.rar");
				int rs = cl.client(name, port, host);
				if (rs == 1)
					JOptionPane.showMessageDialog(frame, "Done");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		else if (obj.equals(btnExit)) {
			System.exit(0);
		}
	}
}
