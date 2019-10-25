package pratice;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


class Gui extends JFrame implements ActionListener{

	JPanel panel;
	JTextArea txtViewChat;
	JTextField txtinputChat;
	JButton btnExit,btnSend;
    
	Socket socket = null;

    InputStream in;
    DataInputStream dis;
    OutputStream out;
	DataOutputStream dataout;
	
	String msg = null;
	
	
	
	public Gui() {
		panel = new JPanel();
		panel.setBounds(10, 10, 400, 500);
		panel.setLayout(null);
		panel.setVisible(true);
		
		
		txtViewChat = new JTextArea();
		txtViewChat.setBounds(0, 0, 480, 376);
		//txtViewChat.setColumns(10); 최대 입력값을 정의함
		
		txtinputChat=new JTextField();
		txtinputChat.setBounds(0,386,480,24);
		
		btnExit=new JButton("종료");
		btnExit.setBounds(480, 0, 100, 24);
		btnExit.addActionListener(this);
		
		btnSend=new JButton("전송");
		btnSend.setBounds(480,386,100,24);
		btnSend.addActionListener(this);		
	}//Gui
	
	
	void display() {
		
		add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		setVisible(true);
		
	}//display
	
	
	void makeMenu() {
		panel.add(txtViewChat);
		panel.add(txtinputChat);
		panel.add(btnExit);
		panel.add(btnSend);
	}//makeMenu
	
	
	static String getTime() {
		SimpleDateFormat f=new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}//getTime
	
	
	public void Client() throws IOException{

		try {
			String serverIp="172.16.52.126";
			int PortNum=7779;
			txtViewChat.append(txtinputChat.getText()+getTime()+"서버에 연결중입니다.서버에 받은 IP"+serverIp+"\n");
			
			
			socket=new Socket(serverIp,PortNum);
			
			while(true) {
			in=socket.getInputStream();
			dis=new DataInputStream(in);
			
			txtViewChat.append(txtinputChat.getText()+getTime()+"서버로 부터 받은 메세지"+dis.readUTF()+"\n");
			}
		}catch(ConnectException ce) {
			ce.printStackTrace();
		}catch(IOException ie) {
			ie.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
			}//catch	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnExit) {
			txtViewChat.append(txtinputChat.getText()+getTime()+"연결을 종료합니다.\n");
			
			try {
				dis.close();
				socket.close();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			txtViewChat.append(txtinputChat.getText()+getTime()+"종료 되었습니다.\n");
			
			//System.exit(0);
		}
		if(e.getSource()==btnSend) {
			
			txtViewChat.append(txtinputChat.getText()+"\n");
			msg = txtinputChat.getText();
			
			
			try {
				out = socket.getOutputStream();
				dataout = new DataOutputStream(out);
				dataout.writeUTF(msg);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			txtinputChat.setText("");
		}
	}//actionPerformed(ActionEvent e)
}//GUI


public class ClientGui{
	public static void main(String[] args)throws IOException {
		Gui gui = new Gui();
		gui.display();
		gui.makeMenu();
		gui.Client();
	}//main
}//ClientGUI