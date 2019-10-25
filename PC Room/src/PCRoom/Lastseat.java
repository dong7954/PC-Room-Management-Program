package PCRoom;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;


public class Lastseat extends JFrame implements ActionListener {

	private JPanel contentPane;
	private int money; // 현재 사용요금
	private int timer;
	JLabel label;
	JLabel lblid2;
	JLabel lbltime2;
	JLabel lblmoney2;
	JLabel label2;
	JLabel lblid;
	static JLabel lbltime5;
	JLabel lblmoney;
	JLabel lblmoney3;
	

	JButton btnchat = new JButton();
	JButton btnmenu = new JButton();
	JButton btnend = new JButton();

	JScrollPane scrollPane;
	ImageIcon icon;


	public static void main(String[] args) {

		/*
		 * 
		 * 
		 * Calendar date3 = Calendar.getInstance();
		 * 
		 * lbltime(date3);
		 */

	}

	private static Lastseat instance = new Lastseat();

	public static Lastseat getInstance() {
		System.out.println("브이컨트롤호출");
		return instance;
	}

	public static Lastseat getInstance(String s) {
		System.out.println(s + "에서 브이컨트롤호출");
		return instance;
	}

	class money01 implements Runnable {

		public void run() {

			money = 0;
			while (true) {

				try {
					// 좌석에서 6분이 지날때마다 100원씩 늘린다. 비회원인 경우
					// 지금은 시험을 위해 10초가 지날때마다 100원씩 늘린다.
					Thread.sleep(1000);
					money += 100;

					// Vcontrol 호출해서 거기서 값 올려주게~
					lblmoney.setText(money + "원");

				}

				catch (InterruptedException e) {
					e.printStackTrace();

				}

			}
		}
	}

	class timer extends Thread {

		public void run() {
			int hour = 0, min = 0, sec = 0;

			// 시험을 위해 10초 단위로 변경한다.
			while (true) {
				sec++;

				if (sec % 60 == 0) {
					min++;
					sec = 0;
					if (min % 60 == 0) {
						min = 0;
						hour++;
					}
				}

				try {

					Thread.sleep(1000);

					// Vcontrol 호출해서 거기서 값 올려주게~
					lbltime5.setText(hour + "시간" + min + "분" + sec + "초");
					btnchat.setBorderPainted(false);//버튼테두리 없에기
					btnmenu.setBorderPainted(false);//버튼테두리 없에기
					btnend.setBorderPainted(false);//버튼테두리 없에기
					
			

				}

				catch (InterruptedException e) {
					System.out.println("Seat : 로그아웃을 한듯하네요~!");
					
					break;
				}

			}
		}
	}

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	public Lastseat() {
		
		icon = new ImageIcon("img/main.png");
		
		
		setTitle("1번 좌석");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 424);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.black);
		contentPane.setLayout(null);

		JFrame frame = new JFrame();
		
		frame.setSize(430, 430);
		Thread t1 = new Thread(new money01());
		t1.start();
		Thread t2 = new Thread(new timer());
		t2.start();

		// 시작 시간

		label = new JLabel("1");
		lblid2 = new JLabel("고객 아이디");
		lbltime2 = new JLabel("이용 시간");
		lblmoney2 = new JLabel("이용 요금");
		label2 = new JLabel(" ODD PC CAFE ");
		lblid = new JLabel("");
		lbltime5 = new JLabel("");
		lblmoney = new JLabel("");
		btnchat = new JButton(new ImageIcon("img/chat2.png"));
		btnchat.addActionListener(this);
		btnchat.setContentAreaFilled(false);
		btnchat.setFocusPainted(false);
		
		
		btnmenu = new JButton(new ImageIcon("img/menu3.png"));
		btnmenu.addActionListener(this);
		btnmenu.setContentAreaFilled(false);
		btnmenu.setFocusPainted(false);
		
		btnend = new JButton(new ImageIcon("img/end2.png"));
		btnend.addActionListener(this);
		//btnend.setBorderPainted(false); // 윤관선 지우기
		btnend.setContentAreaFilled(false);
		btnend.setFocusPainted(false);
		

		label.setFont(new Font("맑은 고딕", Font.BOLD ,99));
		label.setForeground(Color.WHITE);
		lblid2.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblid2.setForeground(Color.WHITE);
		lbltime2.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lbltime2.setForeground(Color.WHITE);
		lblmoney2.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblmoney2.setForeground(Color.WHITE);
		label2.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		label2.setForeground(Color.WHITE);
		lblid.setForeground(Color.WHITE);
		lbltime5.setForeground(Color.WHITE);
		lblmoney.setForeground(Color.WHITE);
		btnchat.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnmenu.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnend.setFont(new Font("맑은 고딕", Font.BOLD, 16));

		label.setBounds(12, 10, 95, 91);
		lblid2.setBounds(40, 144, 112, 27);
		lbltime2.setBounds(40, 199, 87, 27);
		lblmoney2.setBounds(40, 251, 87, 27);
		label2.setBounds(103, 10, 319, 102);
		lblid.setBounds(329, 154, 57, 15);
		lbltime5.setBounds(300, 209, 200, 15);
		lblmoney.setBounds(338, 261, 57, 15);
		btnchat.setBounds(190, 302, 87, 62);
		btnmenu.setBounds(299, 302, 87, 62);
		btnend.setBounds(40, 302, 112, 62);

		contentPane.add(label);
		contentPane.add(lblid2);
		contentPane.add(lbltime2);
		contentPane.add(lblmoney2);
		contentPane.add(label2);
		contentPane.add(lblid);
		contentPane.add(lbltime5);
		contentPane.add(lblmoney);
		contentPane.add(btnchat);
		contentPane.add(btnmenu);
		contentPane.add(btnend);

		frame.add(contentPane);
		frame.setVisible(true);

		/*
		 * // 시작 시간 long startTime = System.currentTimeMillis();
		 * 
		 * // 실행 시간 체크될 녀석들... for(int i=0; i<100000000; i++){ ; } // 종료 시간 long endTime
		 * = System.currentTimeMillis();
		 * 
		 * // 시간 출력 System.out.println("##  시작시간 : " + new
		 * Lastseat().formatTime(startTime)); System.out.println("##  종료시간 : " + new
		 * Lastseat().formatTime(endTime)); System.out.println("##  소요시간(초.0f) : " + (
		 * endTime - startTime )/1000.0f +"초");
		 */

	}

	/*
	 * public static void lbltime(Calendar date) { Calendar date3 =
	 * Calendar.getInstance(); date3.setTimeInMillis(System.currentTimeMillis());
	 * Calendar date4 = Calendar.getInstance();
	 * date4.setTimeInMillis(System.currentTimeMillis() + 1000 * 60 * 6);
	 * System.out.println("지금 시 :" + date3.get(Calendar.HOUR));
	 * System.out.println("지금 분 :" + date3.get(Calendar.MINUTE)); //
	 * System.out.println("지금 시 :" + date4.get(Calendar.HOUR)); //
	 * System.out.println("지금 분 :" + date4.get(Calendar.MINUTE)); long differ =
	 * (date3.getTimeInMillis() - date4.getTimeInMillis()) / 1000;
	 * System.out.println("사용시간부터 지금까지 " + differ / 60 + "분이 지났다"); int money =
	 * (int) (differ / 60) * 100 / 6; lbltime5.setText("사용요금은 " + money + "원이다."); }
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == btnend) {
			JOptionPane.showMessageDialog(null, lblmoney.getText() + "입니다. 이용해주셔서 감사합니다."
					+ "");
			System.exit(0);

		}

	}

	/*
	 * public void continueMoney(Calendar date) {
	 * 
	 * Calendar dateAfter = Calendar.getInstance(); // calendar 객체를 얻기 위해
	 * getInstance() 메서드를 호출 하면 // 현재의 일짜와 시각으로 초기화가 되기 때문에 별도의 설정 작업 없이도 // 메서드로 현재
	 * 시간을 얻어 올 수 있습니다.
	 * 
	 * dateAfter.setTimeInMillis(System.currentTimeMillis());
	 * System.out.println(dateAfter); // currenttimemillis 현재시간 구하는 메서드
	 * 
	 * long differ = (dateAfter.getTimeInMillis() - date.getTimeInMillis()) /
	 * (1000); System.out.println("현재시각은 : " + differ); long differ_hour = differ /
	 * 60;
	 * 
	 * String gametime = differ_hour + ":" + (differ % 60) + "초";
	 * lbltime.setText(gametime);
	 * 
	 * // 바로 밑에 클라이언트로 사용시간 보내주는 메소드 실행 }
	 * 
	 * public String formatTime(long lTime) { Calendar c = Calendar.getInstance();
	 * c.setTimeInMillis(lTime); return (c.get(Calendar.HOUR_OF_DAY) + "시 " +
	 * c.get(Calendar.MINUTE) + "분 " + c.get(Calendar.SECOND) + "." +
	 * c.get(Calendar.MILLISECOND) + "초"); } // end function formatTime()
	 */

}
