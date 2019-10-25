package pratice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TcpIpClient {
	public static void main(String[] args) {
		ClientUI a = new ClientUI();
		a.display();	
	}//main
}

class ClientUI extends JFrame implements ActionListener{
	
	JTextField Field;
	
	int Seatnum ;
	
	JTextField conField;
	JPanel panel;
	JTextArea TextArea;
	JButton SendBtn;
	JButton ConBtn;
	JButton ExitBtn;
	String msg = null;
	
	InputStream in;
	DataInputStream datain;
	OutputStream out;
	DataOutputStream dataout; 
	
	Socket socket;
	
	ClientUI(){
		setTitle("Ŭ���̾�Ʈ");
		panel = new JPanel();
		panel.setBounds(10, 10, 200, 200);
		panel.setVisible(true);
		panel.setLayout(null);
		
		TextArea = new JTextArea();
		TextArea.setBounds(10, 10, 180, 150);
		
		SendBtn = new JButton("����");
		SendBtn.addActionListener(this);
		SendBtn.setBounds(200, 200, 70, 20);
		
		ConBtn = new JButton("����");
		ConBtn.addActionListener(this);
		ConBtn.setBounds(200, 170, 70, 20);
		
		ExitBtn = new JButton("����");
		ExitBtn.addActionListener(this);
		ExitBtn.setBounds(200, 40, 70, 20);
	
		conField = new JTextField();
		conField.setBounds(10, 170, 180, 20);
		conField.addActionListener(this);
		conField.setVisible(true);
		
		Field = new JTextField(25);
		Field.setBounds(10, 200, 180, 20);
		Field.setVisible(true);
		
		
		panel.add(SendBtn);
		panel.add(ConBtn);
		panel.add(ExitBtn);
		panel.add(TextArea);
		panel.add(Field);
		panel.add(conField);
	}
	
	void display() {
		setBounds(100,100,300,300);
		
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/*static ClientUI instance = new ClientUI();
	
	public static ClientUI getInstance() {
		return instance;
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@Override
	public void actionPerformed(ActionEvent e) {	
		if(e.getSource() == ConBtn) { // ���� ��ư
			try {
				String serverIp = "127.0.0.1";
				System.out.println("������ �������Դϴ�. ����IP : " + serverIp);
				socket = new Socket(serverIp, 7790);
				System.out.println("���� ���� ");
				TextArea.append("���� ���� ����\n");
				
				Seatnum = Integer.parseInt(conField.getText());
	
				in = socket.getInputStream();
				datain = new DataInputStream(in);
				
				out = socket.getOutputStream();
				dataout = new DataOutputStream(out);
				
				
				dataout.writeInt(Seatnum);
				
				dataout.writeUTF("�̺���");
				
				dataout.writeUTF("�α���");
				
				while(true) {
					String str = datain.readUTF();
					
					if(str.equals("�޽���")) {
						String msg = datain.readUTF();
						
					}
				}
				
				
			} catch(ConnectException ce) {
				ce.printStackTrace();
			} catch(IOException ie) {
				ie.printStackTrace();
			} catch(Exception e1) {
				e1.printStackTrace();
			}			
		}
		
		
		
		if(e.getSource() == SendBtn) { //���� ��ư
			//������ �Է½�Ʈ���� ��´�.
			try {
				msg = Field.getText();
				TextArea.append(msg + "\n");
				
				in = socket.getInputStream();
				datain = new DataInputStream(in);
				
				out = socket.getOutputStream();
				dataout = new DataOutputStream(out);
				
				dataout.writeUTF(msg);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		
		if(e.getSource() == ExitBtn) {
			System.exit(0);
			
			
		}
	
	}*/
}
