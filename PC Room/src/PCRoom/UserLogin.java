
	package PCRoom;

	import java.awt.BorderLayout;
	import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import javax.swing.JLabel;
	import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JTextField;

	public class UserLogin extends JFrame {

		private JPanel contentPane;//전체패널
		private JTextField textField;// 아이디칸
		private JTextField textField_1;//비밀번호칸
				JButton button;//로그인버튼
				JButton button_1 ;//회원가입
				JButton btnNewButton;//전원끄기
				JButton btnNewButton_1;//다시시작
				JLabel lblNewLabel;// 바탕넣는라벨
		
		
		
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						UserLogin frame = new UserLogin();
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
		public UserLogin() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1329, 803);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			button = new JButton("로그인");
			button.setBounds(923, 481, 69, 60);
			contentPane.add(button);
			
			textField = new JTextField();
			textField.setBounds(805, 484, 116, 21);
			contentPane.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setBounds(805, 515, 116, 21);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
			
			button_1 = new JButton("회원가입");
			button_1.setBounds(815, 554, 97, 23);
			contentPane.add(button_1);
			
			btnNewButton = new JButton("전원끄기");
			btnNewButton.setBounds(878, 610, 97, 23);
			contentPane.add(btnNewButton);
			
			btnNewButton_1 = new JButton("다시시작");
			btnNewButton_1.setBounds(762, 610, 97, 23);
			contentPane.add(btnNewButton_1);
			
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(UserLogin.class.getResource("/logo/login2.PNG")));
			lblNewLabel.setBounds(-118, 0, 1138, 672);
			contentPane.add(lblNewLabel);
		}
	}
