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
	/*1. HashMap�̶�?
	HashMap�� Map�� �����Ѵ�. Key�� value�� ���� �ϳ��� entry�� �����Ѵٴ� Ư¡�� ���´�. 
	�׸��� hashing�� ����ϱ� ������ �������� �����͸� �˻��ϴµ� �پ ������ ���δ�.*/

	public Seat[] pcseat = new Seat[50];
	
	
	ButtonToArray Array;
	
	
	
	public static MsgToCustomer[] chatClient = new MsgToCustomer[50]; //�������� �޽����� Ŭ���̾�Ʈ���� �����ϴ� Ŭ������ 50���� �迭�� ��ü���� ����
	
	public static void main(String[] args) {
		Thread host = new server123(); //server123 ���� ������
		//���� ����
		host.start();
		
		//ManagerMain frame = new ManagerMain();
		
		
	}
	
	// 02.���ο� �ڸ��޴� �޼ҵ�
	public void newSeat(int num, String name, Socket socket) {
		pcseat[num] = new Seat(num, name);
		clients.put(pcseat[num], socket);
		//System.out.println(Array.ClassArray[num]);
	}
	
	// 05.�α��� ó�� from HostPcServer
	public void login(int num, String name) {
		int money = pcseat[num].getMoney();
		System.out.println(Array.ClassArray[0]);
		Array.ClassArray[num].setBackground(Color.blue);
		Array.ClassArray[num].label[0].setForeground(Color.red);
		Array.ClassArray[num].label[0].setText((num + 1) + ". �α���");
		
		Array.ClassArray[num].label[1].setText(name + "��");
		Array.ClassArray[num].label[2].setText("");
		Array.ClassArray[num].label[3].setText(money + "��");
		//Array.ClassArray[num].isLogined = true;
		//Array.ClassArray[num].nickname = name;
		pcseat[num].setUsername(name);
		pcseat[num].setLogin(true);
		if (!pcseat[num].isFirst()) {
			System.out.println("����: ù��° ������ �� ���� �����Ƿ� ���� ��ŸƮ");
			pcseat[num].setFirst(true);
			pcseat[num].start();
		}

	}
	
	
	
	// 10. Ŭ���̾�Ʈ�� ���� ���� �޽���
	public void messageFromPC(int num, String message) {
		if (chatClient[num] == null) {
			
		chatClient[num] = new MsgToCustomer(num); //MsgToCustomer(num)�� ä��â UI ������ �κ�
		
		chatClient[num].setVisible(true);// MstToCustomer ä��â UI�� ������
		
		chatClient[num].ta.append(message); // Ŭ���̾�Ʈ�� ���� �޽����� ��Ƽ� TextArea�� ǥ������
		
		}
	}
	
	
	// 01.��Ʈ��Ÿ�� �̱��游���
	private static Vcontrol instance = new Vcontrol();
	
	private Vcontrol() {
		Collections.synchronizedMap(clients);
	}
	
	public static Vcontrol getInstance(String s) {
		System.out.println(s + "���� ������Ʈ��ȣ��");
		return instance;
	}

}
