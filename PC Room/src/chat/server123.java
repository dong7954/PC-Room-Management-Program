package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class server123 extends Thread{

	
	Vcontrol vc = Vcontrol.getInstance("����");
	ServerReceiver receiver = null;
	
	
	public void run() {
		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			serverSocket = new ServerSocket(7788);
			System.out.println("ȣ��Ʈ �ǽ� : " + "PC�� ȣ��Ʈ�� ���۵˴ϴ�");

			// ������ ��� �޾Ƴ��� ������~
			while (true) {
				socket = serverSocket.accept();
				System.out.println("ȣ��Ʈ �ǽ� : " + "[" + socket.getInetAddress()
						+ "]���� �����Ͽ���!");

				receiver = new ServerReceiver(socket);
				receiver.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	class ServerReceiver extends Thread {
		Socket socket;
		DataInputStream in;
		DataOutputStream out;
		
		// �����ڿ����� ���������� �޾Ƽ� ��ǲ�ƿ�ǲ ��Ʈ���� �ϳ� ����� �����Ѵ�~
		ServerReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
				System.out.println("ȣ��Ʈ �ǽ� : �ξƿ� �����Ϸ�!");
			} catch (IOException e) {
				System.out.println("ȣ��Ʈ �ǽ� : " + "���� ���ù� ���� ����� ����");
			}
		}// ������ ��
		
		//���ù� ��ŸƮ
		public void run() {
			int num = 0;
			String name ="";
			
			try {
				num = in.readInt();
				name = in.readUTF();
				System.out.println("ȣ��Ʈ �ǽ� : " + "�ڸ� ��ȣ�� " + num);
				System.out.println("ȣ��Ʈ �ǽ� : " + "�� ����� �̸��� " + name + "�Դϴ�.");
				
				while(in != null) {
					String s = in.readUTF();
					
					switch(s) {
					case "�α���":
						vc.newSeat(num, name, socket);
						System.out.println("case �α��� �� ");
						vc.login(num, name);
						break;
					
					case "�޽���":
						String message = in.readUTF();
						vc.messageFromPC(num,message);
						break;
					}
				}		
			} catch(IOException e) {
				System.out.println("ȣ��Ʈ�ǽ�: " + "Ŭ���̾�Ʈ���� ������ ���� : �����ų�..");
			}
		}
	}
	
}
