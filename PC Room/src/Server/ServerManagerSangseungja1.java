package Server;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import ButtonArray.ButtonToArray;

public class ServerManagerSangseungja1 extends ButtonToArray{
	JLayeredPane lpane;
	JPanel map_panel;
	JLabel label_img;
	
	public ServerManagerSangseungja1(){
			//setTitle("관리자화면");	
			//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//setBounds(100, 100, 1400, 800);
			
			label_img= new JLabel("");
			label_img.setIcon(new ImageIcon(ManegerMainSeat.class.getResource("/logo/map.png")));
			label_img.setBounds(0, 0, 1550, 883);
		
			
			map_panel = new JPanel();
			map_panel.setLayout(null);
			map_panel.setBounds(0, 0, 1550, 883);
		
		
			/*lpane = new JLayeredPane();
			lpane.setBounds(0, 0, 1400, 700);
			lpane.setLayout(null);*/
			
			/*seat30 = new JPanel();
			seat30.setLayout(null);
			seat30.setBounds(10, 10, 900, 400);*/

			int x = 500;
			int y = 200;
			for(int i = 1; i < 49; i++) {
				ClassArray[i] = new ButtonArray.PanelUI(i);
				ClassArray[i].setBounds(x, y, 100, 100);
				
				
				x += 125;
				if(i % 8 == 0 && i != 0) {
					x = 500;
					y += 100;
				}
				add(ClassArray[i]);
				
				//seat30.add(ClassArray[i]);
			}
			
			
			//lpane.add(seat30, new Integer(1),0);
			
			
			map_panel.add(label_img);
			
			add(map_panel);
			//setBackground(Color.black);
			//add(lpane);	
			setLayout(null);
			//setBounds(500,200,590,500);
		
			
			//Seat = new JButton[5]; //2 0,1,2
				
			/*for(int i=0;i<=Seat.length - 1;i++) {
				
				Seat[i] = new JButton("좌석 : " +i);
				panel.add(Seat[i]);
				Seat[i].addMouseListener(new MousePopupListener());
			}*/
					
			/*Seat=new JButton("클라이언트");
			Seat.setBounds(10, 10, 200, 200);
			Seat.addActionListener(this);
			
			Seat1=new JButton("클라이언트2");
			Seat1.setBounds(230,10,200,200);
			Seat1.addActionListener(this);
			
			Seat2=new JButton("클라이언트3");
			Seat2.setBounds(460, 10, 200, 200);
			Seat2.addActionListener(this);*/
			
			
			/*int j = 10;
			for(int i= 0 ; i <=Seat.length - 1; i ++) {
				Seat[i].setBounds(j, 10, 200, 200);
				j += 220;
				
			}*/
			
			/*pMenu = new JPopupMenu();
			
			
			
			miEnd= new JMenuItem("정산");
			miEnd.addActionListener(this);
			miInfo = new JMenuItem("회원정보");
			miChat = new JMenuItem("메시지보내기");
			miChat.addActionListener(this);*/
			
			
			/*miChat = new JMenuItem[5];
			
			for(int i = 0; i<=miChat.length-1;i++) {
				miChat[i] = new JMenuItem("메시지보내기");
				pMenu.add(miChat[i]);
				miChat[i].addActionListener(this);
				miChat[i].addMouseListener(new MousePopupListener());
			}*/
			
			
			/*pMenu.add(miChat);
			pMenu.add(miEnd);
			pMenu.add(miInfo);*/
		
	}
	
	public static void main(String[] args) {
		
		ServerManagerSangseungja1 a  = new ServerManagerSangseungja1();
		/*JFrame b = new JFrame();
		b.setVisible(true);
		b.setLayout(null);
		b.setBounds(0, 0, 1500, 1000);
		b.add(a);*/
		
	}
	//ServerManagerSangseungja instance = new ServerManagerSangseungja(); 
}
