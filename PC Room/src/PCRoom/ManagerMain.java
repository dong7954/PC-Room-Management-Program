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

		private JPanel contentPane; // ��ü�г�
				JLabel lblPc;//�ΰ� ���� ��
				JButton btn1;// ȸ����ư
				JButton btn2;//�����ư
				JButton btn3;//Ȩ
				JButton btn4;//�޴�
				JTabbedPane tabbedPane;// �ֹ���ǰ��� DB�� �г��� �ֱ����� ȭ��
				JPanel pane1;//�ֹ���ǰ��� DB�� �г�
				private JPanel panel_1; // �ڸ�1
				private JPanel panel_2; // �ڸ�2
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
			setIconImage(Toolkit.getDefaultToolkit().getImage(ManagerMain.class.getResource("/logo/logo.PNG"))); /// â ������
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

			
			btn1 = new JButton(""); //ȸ����ư
			btn1.setIcon(new ImageIcon(ManagerMain.class.getResource("/image/button/UserlistButton.PNG")));
			btn1.setBounds(445, 53, 103, 59);
			btn1.setBorderPainted(false);//��ư�׵θ� ������ 
			contentPane.add(btn1);
			btn1.addActionListener(this);
			
			btn2 = new JButton("");//�����ư
			btn2.setIcon(new ImageIcon(ManagerMain.class.getResource("/image/button/HomeButton.PNG")));
			btn2.setBounds(584, 53, 103, 59);
			btn2.setBorderPainted(false);//��ư�׵θ� ������
			contentPane.add(btn2);
			btn2.addActionListener(this);
			
			btn3 = new JButton("");//Ȩ��ư
			btn3.setIcon(new ImageIcon(ManagerMain.class.getResource("/image/button/MenuDBButton.PNG")));
			btn3.setBounds(719, 53, 103, 59);
			btn3.setBorderPainted(false);//��ư�׵θ� ������
			contentPane.add(btn3);
			btn3.addActionListener(this);
			
			btn4 = new JButton("");//�޴���ư
			btn4.setIcon(new ImageIcon(ManagerMain.class.getResource("/image/button/MenuButton.PNG")));
			btn4.setBounds(861, 53, 103, 59);
			btn4.setBorderPainted(false);//��ư�׵θ� ������
			contentPane.add(btn4);
			btn4.addActionListener(this);
			
			//////////////////////////////////////////////////////////////////////////////////////////���� â
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(12, 150, 280, 831);
			contentPane.add(tabbedPane);
			pane1 = new JPanel(); // �ֹ�����г�
			tabbedPane.addTab("�ֹ����", null, pane1, null);
//////////////////////////////////////////////////////////////////////////////////////////���� â
			panel_1 = new JPanel(); // �ڸ�1
			panel_1.setBounds(696, 325, 133, 94);
			contentPane.add(panel_1);
			
			panel_2 = new JPanel(); // �ڸ�2
			panel_2.setBounds(841, 325, 133, 94);
			contentPane.add(panel_2);
			
			JLabel lblNewLabel = new JLabel(""); // ��ġ�� ��
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

