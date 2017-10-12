package server;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
public class GUI extends JFrame implements ActionListener, PropertyChangeListener {
	private static final long serialVersionUID = 1L;
	private JTextField txtFileName;
	private JButton btnStart;
	private JButton btnExit;
	private JTextField txtPort;
	private Component frame = null;
	private JProgressBar jb;
	public GUI() {
		setTitle("Server");
		setSize(500, 210);
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
		b.add(Box.createVerticalStrut(20));
		b1.add(txtPort = new JTextField());
		b1.setBorder(BorderFactory.createTitledBorder("Enter port you want to connect"));
		b2.add(txtFileName = new JTextField());
		b2.setBorder(BorderFactory.createTitledBorder("Enter file name you want to send"));
		b3.add(btnStart = new JButton("Start"));
		b3.add(btnExit = new JButton("Exit"));
		b4.add(jb = new JProgressBar());
		jb.setStringPainted(true);
		jb.setMinimum(0);
		jb.setMaximum(100);
		b.add(Box.createVerticalStrut(10));
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
			String name = txtFileName.getText();
			int port;
			if ((txtPort.getText()).equalsIgnoreCase("")) port = 7777;
			else port = Integer.parseInt(txtPort.getText());
			try {
				if (name.equalsIgnoreCase("")) name = new String("qq.rar");
				Server sv = new Server(name, port);
				sv.addPropertyChangeListener(this);
				sv.execute();
//				if (sv.getDone() == 1)
//					JOptionPane.showMessageDialog(frame, "Server is Done");
//				else  if (sv.getDone() == 0)
//					JOptionPane.showMessageDialog(frame, "Server is Failed");
//				else
//					JOptionPane.showMessageDialog(frame, "File does not exists");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		else if (obj.equals(btnExit)) {
			System.exit(0);
		}
	}
	@Override
	public void propertyChange(PropertyChangeEvent e) {
		if ("progress".equalsIgnoreCase(e.getPropertyName())) {
			int value = (int) e.getNewValue();
			jb.setValue(value);
			if (jb.getValue() == 100) JOptionPane.showMessageDialog(frame, "Server is Done");
		}
	}
}
