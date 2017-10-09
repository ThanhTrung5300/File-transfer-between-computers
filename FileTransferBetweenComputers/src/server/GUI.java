package server;
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
	Component frame = null;
	public GUI() {
		setSize(500, 220);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		Box b, b1, b2, b3, b4;
		add(b = Box.createVerticalBox());
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b4 = Box.createHorizontalBox());
		b1.add(txtPort = new JTextField());
		b1.setBorder(BorderFactory.createTitledBorder("Enter port you want to connect"));
		b2.add(txtFileName = new JTextField());
		b2.setBorder(BorderFactory.createTitledBorder("Enter file name you want to send"));
		b3.add(btnStart = new JButton("Start"));
		b4.add(btnExit = new JButton("Exit"));
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
			JOptionPane.showMessageDialog(frame, "Waiting for Client connect...");
			Server sv = new Server();
			String name = txtFileName.getText();
			int port;
			if ((txtPort.getText()).equalsIgnoreCase("")) port = 9876;
			else port = Integer.parseInt(txtPort.getText());
			try {
				if (name.equalsIgnoreCase("")) name = new String("qq.rar");
				int rs = sv.server(name, port);
				if (rs == 1)
					JOptionPane.showMessageDialog(frame, "Done");
				else  if (rs == 0)
					JOptionPane.showMessageDialog(frame, "Fail");
				else
					JOptionPane.showMessageDialog(frame, "File does not exists");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		else if (obj.equals(btnExit)) {
			System.exit(0);
		}
	}
}
