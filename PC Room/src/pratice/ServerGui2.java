package pratice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class GuiC2 extends JFrame implements ActionListener{

	JPanel panel;
	JTextArea txtViewChat;
	JTextField txtinputChat;
	JButton btnExit,btnSend;
	
	ServerSocket serverSocket=null;
	Socket clientSocket =null;
	
	OutputStream out;
	DataOutputStream dataout;
	InputStream in;
	DataInputStream datain;
	public GuiC2() {
		panel = new JPanel();
		setContentPane(panel);

		txtViewChat = new JTextArea();
		txtViewChat.setBounds(0, 0, 480, 376);
		
		txtinputChat=new JTextField();
		txtinputChat.setBounds(0,386,480,24);
		
		btnExit=new JButton();
		btnExit.setBounds(480, 0, 240, 24);
		btnExit.addActionListener(this);
		
		btnSend=new JButton("send");
		btnSend.setBounds(480,386,240,24);
		btnSend.addActionListener(this);
	}
	
	void display() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		getContentPane().setLayout(null);
		setVisible(true);
	}//dispaly
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
	public void serverStart() throws IOException{
		try {
			serverSocket=new ServerSocket(7778);
			
			txtViewChat.append(txtinputChat.getText()+getTime()+"서버가 시작되었습니다.\n");
			
			txtViewChat.append(txtinputChat.getText()+getTime()+"연결대기 중입니다.\n");
			clientSocket=serverSocket.accept();
			txtViewChat.append(txtinputChat.getText()+getTime()+clientSocket.getInetAddress()+"접속요청이 발생되었습니다.\n");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		while(true) {
			try {
			in=clientSocket.getInputStream();
			datain=new DataInputStream(in);
			
			txtViewChat.append(txtinputChat.getText()+getTime()+"서버로 부터 받은 메세지"+datain.readUTF()+"\n");
			} catch(IOException e1) {
				e1.printStackTrace();
			}
		}
		
		//while(true) {
			
			
			
			
					
			//try
		//}//while(true)
		
	}//serverStart()
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnExit) {
			try {
				dataout.close();
				clientSocket.close();
				//System.exit(0);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if(e.getSource()==btnSend) {
			try {
				out=clientSocket.getOutputStream();
				dataout=new DataOutputStream(out);
				dataout.writeUTF(getTime()+txtinputChat.getText()+"\n");
				txtViewChat.append(getTime()+txtinputChat.getText()+"\n");
				txtinputChat.setText("");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}//actionPerformed(ActionEvent e)
}//GUI
public class ServerGui2{
	public static void main(String[] args) throws IOException {
		
		GuiC2 gui = new GuiC2();
		gui.display();
		gui.makeMenu();
		gui.serverStart();
	}//main
	
}