package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class server123 extends Thread{

	
	Vcontrol vc = Vcontrol.getInstance("서버");
	ServerReceiver receiver = null;
	
	
	public void run() {
		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			serverSocket = new ServerSocket(7788);
			System.out.println("호스트 피시 : " + "PC방 호스트가 시작됩니다");

			// 접속을 계속 받아내는 쓰레드~
			while (true) {
				socket = serverSocket.accept();
				System.out.println("호스트 피시 : " + "[" + socket.getInetAddress()
						+ "]에서 접속하였다!");

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
		
		// 생성자에서는 서버소켓을 받아서 인풋아웃풋 스트림을 하나 만들고 연결한다~
		ServerReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
				System.out.println("호스트 피시 : 인아웃 생성완료!");
			} catch (IOException e) {
				System.out.println("호스트 피시 : " + "서버 리시버 소켓 입출력 에러");
			}
		}// 생성자 끝
		
		//리시버 스타트
		public void run() {
			int num = 0;
			String name ="";
			
			try {
				num = in.readInt();
				name = in.readUTF();
				System.out.println("호스트 피시 : " + "자리 번호는 " + num);
				System.out.println("호스트 피시 : " + "이 사람의 이름은 " + name + "입니다.");
				
				while(in != null) {
					String s = in.readUTF();
					
					switch(s) {
					case "로그인":
						vc.newSeat(num, name, socket);
						System.out.println("case 로그인 부 ");
						vc.login(num, name);
						break;
					
					case "메시지":
						String message = in.readUTF();
						vc.messageFromPC(num,message);
						break;
					}
				}		
			} catch(IOException e) {
				System.out.println("호스트피시: " + "클라이언트와의 접속중 에러 : 나가거나..");
			}
		}
	}
	
}
