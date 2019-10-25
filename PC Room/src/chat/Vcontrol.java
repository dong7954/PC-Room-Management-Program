package chat;


import java.awt.Color;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import ButtonArray.*;





public class Vcontrol {
	Socket socket;
	DataOutputStream out;
	
	public HashMap<Seat, Socket> clients 
			= new HashMap<Seat, Socket>();
	/*1. HashMap이란?
	HashMap은 Map을 구현한다. Key와 value를 묶어 하나의 entry로 저장한다는 특징을 갖는다. 
	그리고 hashing을 사용하기 때문에 많은양의 데이터를 검색하는데 뛰어난 성능을 보인다.*/

	public Seat[] pcseat = new Seat[50];
	
	
	ButtonToArray Array;
	
	
	
	public static MsgToCustomer[] chatClient = new MsgToCustomer[50]; //관리자의 메시지를 클라이언트에게 전송하는 클래스를 50개의 배열로 객체변수 선언
	
	public static void main(String[] args) {
		Thread host = new server123(); //server123 서버 쓰레드
		//서버 시작
		host.start();
		
		//ManagerMain frame = new ManagerMain();
		
		
	}
	
	// 02.새로운 자리받는 메소드
	public void newSeat(int num, String name, Socket socket) {
		pcseat[num] = new Seat(num, name);
		clients.put(pcseat[num], socket);
		//System.out.println(Array.ClassArray[num]);
	}
	
	// 05.로그인 처리 from HostPcServer
	public void login(int num, String name) {
		int money = pcseat[num].getMoney();
		System.out.println(Array.ClassArray[0]);
		Array.ClassArray[num].setBackground(Color.blue);
		Array.ClassArray[num].label[0].setForeground(Color.red);
		Array.ClassArray[num].label[0].setText((num + 1) + ". 로그인");
		
		Array.ClassArray[num].label[1].setText(name + "님");
		Array.ClassArray[num].label[2].setText("");
		Array.ClassArray[num].label[3].setText(money + "원");
		//Array.ClassArray[num].isLogined = true;
		//Array.ClassArray[num].nickname = name;
		pcseat[num].setUsername(name);
		pcseat[num].setLogin(true);
		if (!pcseat[num].isFirst()) {
			System.out.println("실험: 첫번째 실행이 된 적이 없으므로 새로 스타트");
			pcseat[num].setFirst(true);
			pcseat[num].start();
		}

	}
	
	
	
	// 10. 클라이언트로 부터 받은 메시지
	public void messageFromPC(int num, String message) {
		if (chatClient[num] == null) {
			
		chatClient[num] = new MsgToCustomer(num); //MsgToCustomer(num)이 채팅창 UI 생성자 부분
		
		chatClient[num].setVisible(true);// MstToCustomer 채팅창 UI를 보여줌
		
		chatClient[num].ta.append(message); // 클라이언트가 보낸 메시지를 담아서 TextArea에 표기해줌
		
		}
	}
	
	
	// 01.컨트롤타워 싱글톤만들기
	private static Vcontrol instance = new Vcontrol();
	
	private Vcontrol() {
		Collections.synchronizedMap(clients);
	}
	
	public static Vcontrol getInstance(String s) {
		System.out.println(s + "에서 브이컨트롤호출");
		return instance;
	}

}
