package pratice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class server1 extends JFrame implements Runnable {
	ServerSocket serverSocket;
	Thread[] threadArr;
	InputStream in;
	DataInputStream datain;
	OutputStream out;
	DataOutputStream dataout; 
	Socket socket;
	String msg;
	
	public static void main(String[] args) {
		//5���� �����带 �����ϴ� ������ �����Ѵ�.
		server1 server1 = new server1(5);
		server1.start();
		
		UI a = new UI();
		a.display();
	}//main
	
	
	
	
	
	public server1(int num) {
		try {
			//���������� �����Ͽ� 7777�� ��Ʈ�� ���ս�Ų��.
			serverSocket = new ServerSocket(7777);
			System.out.println(getTime() + "������ �غ�Ǿ����ϴ�");
			
			threadArr = new Thread[num];
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void start() {
		for(int i = 0 ; i < threadArr.length; i++) {
			threadArr[i] = new Thread(this);
			threadArr[i].start();
		}
	}
	
	public void run() {
		while(true) {
			try {
				System.out.println(getTime() + "�� �����û�� ��ٸ��ϴ�.");
				
				socket = serverSocket.accept();
				System.out.println(getTime() + socket.getInetAddress()+ "�κ��� �����û�� ���Խ��ϴ�.");
				
				
				in = socket.getInputStream();
				datain = new DataInputStream(in);
				
				//������ ��½�Ʈ���� ��´�.
				out = socket.getOutputStream();
				dataout = new DataOutputStream(out);
				
				//���� ����(remote socket)�� �����͸� ������.
				msg = datain.readUTF();
				System.out.println(getTime() + "�����͸� �����߽��ϴ�.");
				
				//��Ʈ���� ������ �ݾ��ش�.
				dataout.close();
				socket.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}//while
	}//run
	
	//����ð��� ���ڿ��� ��ȯ�ϴ� �Լ�
	static String getTime() {
		String name = Thread.currentThread().getName();
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date()) + name;
	}
}




class UI extends JFrame{
	JTextField Field;
	JPanel panel;
	JTextArea TextArea;
	JButton button;
	
	server1 a = new server1(5);
	
	UI(){
		setTitle("����");
		panel = new JPanel();
		panel.setBounds(10, 10, 200, 200);
		panel.setVisible(true);
		panel.setLayout(null);
		
		TextArea = new JTextArea();
		TextArea.setBounds(10, 10, 180, 180);
		
		button = new JButton("����");
		
		button.setBounds(200, 200, 70, 20);
		
		Field = new JTextField();
		Field.setBounds(10, 200, 180, 20);
		Field.setVisible(true);
		
		
		
		panel.add(button);
		panel.add(TextArea);
		panel.add(Field);
	}
	
	void display() {
		setBounds(100,100,300,300);
		
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
		
	
}
	
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public void ServerMake() {
		 ServerSocket serverSocket = null;
	     Socket socket = null;
	         
         try{           
       	 serverSocket = new ServerSocket(9000);
       	 socket = serverSocket.accept();
       	 
       	 InputStream in = socket.getInputStream();
       	 OutputStream out = socket.getOutputStream();
       	 
       	 byte arr[] = new byte[100];
       	 in.read(arr);
       	 System.out.println(new String(arr));
       	 String str = "hello client";
       	 
       	 
       	 out.write(str.getBytes());
       	 
        } catch(Exception e){
       	 System.out.println(e.getMessage());                 
        } finally {
       	 try {
       		 socket.close();
       	 } catch(Exception e2) {
       		 
       	 }
       	 
       	 try {
       		 serverSocket.close();
       	 } catch(Exception e2) {
       		 
       	 }
       }

	}*/

