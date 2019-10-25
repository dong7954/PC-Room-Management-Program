	package PCRoom;

	import java.awt.Color;
	import java.awt.EventQueue;
	import java.awt.Toolkit;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JMenu;
	import javax.swing.JMenuBar;
	import javax.swing.JMenuItem;
	import javax.swing.JPanel;
	import javax.swing.JRadioButton;
	import javax.swing.JTabbedPane;
	import javax.swing.JTextField;
	import javax.swing.border.EmptyBorder;


	public class ManagerMain extends JFrame implements ActionListener{

		private JPanel contentPane; // 전체패널
				JLabel lblPc;//로고 들어가는 라벨
				JButton btn1;// 회원버튼
				JButton btn2;//매장버튼
				JButton btn3;//홈
				JButton btn4;//메뉴
				JTabbedPane tabbedPane;// 주문상품목록 DB들어갈 패널을 넣기위한 화면
				JPanel pane1;//주문상품목록 DB들어갈 패널
				private JPanel panel_1; // 자리1
				private JPanel panel_2; // 자리2
		/**
		 * Launch the application.
		 */
		
		public static void main(String[] args) {
			JFrame frame = new JFrame("Menu");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			class exitaction implements ActionListener{
				public void actionPerformed(ActionEvent e){
					System.exit(0);
				}
			}

			
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						ManagerMain frame = new ManagerMain();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
		}

		
		
		/**
		 * Create the frame.
		 */
		public ManagerMain() {
			setTitle("ODD PC Cafe");
			setIconImage(Toolkit.getDefaultToolkit().getImage(ManagerMain.class.getResource("/logo/logo.PNG"))); /// 창 아이콘
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(0, 0, 1920, 1080);
		
			contentPane = new JPanel();
			contentPane.setBackground(Color.BLACK);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			lblPc = new JLabel("");
			lblPc.setIcon(new ImageIcon(ManagerMain.class.getResource("/logo/logo3.PNG")));
			lblPc.setForeground(Color.WHITE);
			lblPc.setBounds(0, 0, 395, 140);
			contentPane.add(lblPc);

			
			btn1 = new JButton(""); //회원버튼
			btn1.setIcon(new ImageIcon(ManagerMain.class.getResource("/image/button/UserlistButton.PNG")));
			btn1.setBounds(445, 53, 103, 59);
			btn1.setBorderPainted(false);//버튼테두리 없에기 
			contentPane.add(btn1);
			btn1.addActionListener(this);
			
			btn2 = new JButton("");//매장버튼
			btn2.setIcon(new ImageIcon(ManagerMain.class.getResource("/image/button/HomeButton.PNG")));
			btn2.setBounds(584, 53, 103, 59);
			btn2.setBorderPainted(false);//버튼테두리 없에기
			contentPane.add(btn2);
			btn2.addActionListener(this);
			
			btn3 = new JButton("");//홈버튼
			btn3.setIcon(new ImageIcon(ManagerMain.class.getResource("/image/button/MenuDBButton.PNG")));
			btn3.setBounds(719, 53, 103, 59);
			btn3.setBorderPainted(false);//버튼테두리 없에기
			contentPane.add(btn3);
			btn3.addActionListener(this);
			
			btn4 = new JButton("");//메뉴버튼
			btn4.setIcon(new ImageIcon(ManagerMain.class.getResource("/image/button/MenuButton.PNG")));
			btn4.setBounds(861, 53, 103, 59);
			btn4.setBorderPainted(false);//버튼테두리 없에기
			contentPane.add(btn4);
			btn4.addActionListener(this);
			
			//////////////////////////////////////////////////////////////////////////////////////////좌측 창
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(12, 150, 280, 831);
			contentPane.add(tabbedPane);
			pane1 = new JPanel(); // 주문목록패널
			tabbedPane.addTab("주문목록", null, pane1, null);
//////////////////////////////////////////////////////////////////////////////////////////좌측 창
			panel_1 = new JPanel(); // 자리1
			panel_1.setBounds(696, 325, 133, 94);
			contentPane.add(panel_1);
			
			panel_2 = new JPanel(); // 자리2
			panel_2.setBounds(841, 325, 133, 94);
			contentPane.add(panel_2);
			
			JLabel lblNewLabel = new JLabel(""); // 배치도 라벨
			lblNewLabel.setIcon(new ImageIcon(ManagerMain.class.getResource("/logo/map.png")));
			lblNewLabel.setBounds(325, 133, 1552, 888);
			contentPane.add(lblNewLabel);
			
			
		}



		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			/*if(e.getSource()==btn1) {
				switchPane(pt1);
			}
			if(e.getSource()==btn2) {
				switchPane(pt2);
			}
			if(e.getSource()==btn3) {
				switchPane(pt3);
			}
			if(e.getSource()==btn4) {
				switchPane(pt4);
			}*/
		}
	}

