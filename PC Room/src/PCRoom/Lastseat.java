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
	private int money; // ���� �����
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
		System.out.println("������Ʈ��ȣ��");
		return instance;
	}

	public static Lastseat getInstance(String s) {
		System.out.println(s + "���� ������Ʈ��ȣ��");
		return instance;
	}

	class money01 implements Runnable {

		public void run() {

			money = 0;
			while (true) {

				try {
					// �¼����� 6���� ���������� 100���� �ø���. ��ȸ���� ���
					// ������ ������ ���� 10�ʰ� ���������� 100���� �ø���.
					Thread.sleep(1000);
					money += 100;

					// Vcontrol ȣ���ؼ� �ű⼭ �� �÷��ְ�~
					lblmoney.setText(money + "��");

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

			// ������ ���� 10�� ������ �����Ѵ�.
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

					// Vcontrol ȣ���ؼ� �ű⼭ �� �÷��ְ�~
					lbltime5.setText(hour + "�ð�" + min + "��" + sec + "��");
					btnchat.setBorderPainted(false);//��ư�׵θ� ������
					btnmenu.setBorderPainted(false);//��ư�׵θ� ������
					btnend.setBorderPainted(false);//��ư�׵θ� ������
					
			

				}

				catch (InterruptedException e) {
					System.out.println("Seat : �α׾ƿ��� �ѵ��ϳ׿�~!");
					
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
		
		
		setTitle("1�� �¼�");
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

		// ���� �ð�

		label = new JLabel("1");
		lblid2 = new JLabel("�� ���̵�");
		lbltime2 = new JLabel("�̿� �ð�");
		lblmoney2 = new JLabel("�̿� ���");
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
		//btnend.setBorderPainted(false); // ������ �����
		btnend.setContentAreaFilled(false);
		btnend.setFocusPainted(false);
		

		label.setFont(new Font("���� ���", Font.BOLD ,99));
		label.setForeground(Color.WHITE);
		lblid2.setFont(new Font("���� ���", Font.PLAIN, 20));
		lblid2.setForeground(Color.WHITE);
		lbltime2.setFont(new Font("���� ���", Font.PLAIN, 20));
		lbltime2.setForeground(Color.WHITE);
		lblmoney2.setFont(new Font("���� ���", Font.PLAIN, 20));
		lblmoney2.setForeground(Color.WHITE);
		label2.setFont(new Font("���� ���", Font.BOLD, 40));
		label2.setForeground(Color.WHITE);
		lblid.setForeground(Color.WHITE);
		lbltime5.setForeground(Color.WHITE);
		lblmoney.setForeground(Color.WHITE);
		btnchat.setFont(new Font("���� ���", Font.BOLD, 20));
		btnmenu.setFont(new Font("���� ���", Font.BOLD, 20));
		btnend.setFont(new Font("���� ���", Font.BOLD, 16));

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
		 * // ���� �ð� long startTime = System.currentTimeMillis();
		 * 
		 * // ���� �ð� üũ�� �༮��... for(int i=0; i<100000000; i++){ ; } // ���� �ð� long endTime
		 * = System.currentTimeMillis();
		 * 
		 * // �ð� ��� System.out.println("##  ���۽ð� : " + new
		 * Lastseat().formatTime(startTime)); System.out.println("##  ����ð� : " + new
		 * Lastseat().formatTime(endTime)); System.out.println("##  �ҿ�ð�(��.0f) : " + (
		 * endTime - startTime )/1000.0f +"��");
		 */

	}

	/*
	 * public static void lbltime(Calendar date) { Calendar date3 =
	 * Calendar.getInstance(); date3.setTimeInMillis(System.currentTimeMillis());
	 * Calendar date4 = Calendar.getInstance();
	 * date4.setTimeInMillis(System.currentTimeMillis() + 1000 * 60 * 6);
	 * System.out.println("���� �� :" + date3.get(Calendar.HOUR));
	 * System.out.println("���� �� :" + date3.get(Calendar.MINUTE)); //
	 * System.out.println("���� �� :" + date4.get(Calendar.HOUR)); //
	 * System.out.println("���� �� :" + date4.get(Calendar.MINUTE)); long differ =
	 * (date3.getTimeInMillis() - date4.getTimeInMillis()) / 1000;
	 * System.out.println("���ð����� ���ݱ��� " + differ / 60 + "���� ������"); int money =
	 * (int) (differ / 60) * 100 / 6; lbltime5.setText("������� " + money + "���̴�."); }
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == btnend) {
			JOptionPane.showMessageDialog(null, lblmoney.getText() + "�Դϴ�. �̿����ּż� �����մϴ�."
					+ "");
			System.exit(0);

		}

	}

	/*
	 * public void continueMoney(Calendar date) {
	 * 
	 * Calendar dateAfter = Calendar.getInstance(); // calendar ��ü�� ��� ����
	 * getInstance() �޼��带 ȣ�� �ϸ� // ������ ��¥�� �ð����� �ʱ�ȭ�� �Ǳ� ������ ������ ���� �۾� ���̵� // �޼���� ����
	 * �ð��� ��� �� �� �ֽ��ϴ�.
	 * 
	 * dateAfter.setTimeInMillis(System.currentTimeMillis());
	 * System.out.println(dateAfter); // currenttimemillis ����ð� ���ϴ� �޼���
	 * 
	 * long differ = (dateAfter.getTimeInMillis() - date.getTimeInMillis()) /
	 * (1000); System.out.println("����ð��� : " + differ); long differ_hour = differ /
	 * 60;
	 * 
	 * String gametime = differ_hour + ":" + (differ % 60) + "��";
	 * lbltime.setText(gametime);
	 * 
	 * // �ٷ� �ؿ� Ŭ���̾�Ʈ�� ���ð� �����ִ� �޼ҵ� ���� }
	 * 
	 * public String formatTime(long lTime) { Calendar c = Calendar.getInstance();
	 * c.setTimeInMillis(lTime); return (c.get(Calendar.HOUR_OF_DAY) + "�� " +
	 * c.get(Calendar.MINUTE) + "�� " + c.get(Calendar.SECOND) + "." +
	 * c.get(Calendar.MILLISECOND) + "��"); } // end function formatTime()
	 */

}
