
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

		private JPanel contentPane;//��ü�г�
		private JTextField textField;// ���̵�ĭ
		private JTextField textField_1;//��й�ȣĭ
				JButton button;//�α��ι�ư
				JButton button_1 ;//ȸ������
				JButton btnNewButton;//��������
				JButton btnNewButton_1;//�ٽý���
				JLabel lblNewLabel;// �����ִ¶�
		
		
		
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
			
			button = new JButton("�α���");
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
			
			button_1 = new JButton("ȸ������");
			button_1.setBounds(815, 554, 97, 23);
			contentPane.add(button_1);
			
			btnNewButton = new JButton("��������");
			btnNewButton.setBounds(878, 610, 97, 23);
			contentPane.add(btnNewButton);
			
			btnNewButton_1 = new JButton("�ٽý���");
			btnNewButton_1.setBounds(762, 610, 97, 23);
			contentPane.add(btnNewButton_1);
			
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(UserLogin.class.getResource("/logo/login2.PNG")));
			lblNewLabel.setBounds(-118, 0, 1138, 672);
			contentPane.add(lblNewLabel);
		}
	}
