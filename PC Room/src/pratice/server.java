package pratice;


import java.net.*;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class server implements Runnable {
	ServerSocket serverSocket;
	Thread[] threadArr;
	
	public static void main(String[] args) {
		//5���� �����带 �����ϴ� ������ �����Ѵ�.
		server server = new server(5);
		server.start();
	}//main
	
	public server(int num) {
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
				
				Socket socket = serverSocket.accept();
				System.out.println(getTime() + socket.getInetAddress()+ "�κ��� �����û�� ���Խ��ϴ�.");
				
				//������ ��½�Ʈ���� ��´�.
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				//���� ����(remote socket)�� �����͸� ������.
				dos.writeUTF("[Notice] Test Message1 from server.");
				System.out.println(getTime() + "�����͸� �����߽��ϴ�.");
				
				//��Ʈ���� ������ �ݾ��ش�.
				dos.close();
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
	
}//class
