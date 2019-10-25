
package PCRoom;

	import java.awt.BorderLayout;
	import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.net.URL;

import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
	import java.awt.Color;
	import javax.swing.JTextPane;
	import javax.swing.JLabel;
	import javax.swing.JList;
	import javax.swing.JScrollBar;

	public class Menu extends JFrame implements MouseListener{

		private JPanel contentPane;//��ü�г�
				JButton btnNewButton;//�α��ǰ��ư
				JButton btnNewButton_1;//����
				JButton btnNewButton_2;//����
				JButton btnNewButton_3;//���
				JButton btnNewButton_4;//�õ�
				JButton btnNewButton_5;//��ǰ �ֹ��ϱ��ư
				JPanel panel_1;//�޴���� �� �г�(����̲�)
				JScrollBar scrollBar;//��ǰ��� ��ũ�ѹ�
				
				
				
				
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Menu frame = new Menu();
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
		public Menu() {
			setBackground(Color.DARK_GRAY);
			setTitle("\uC0C1\uD488\uC8FC\uBB38");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 969, 806);
			contentPane = new JPanel();
			contentPane.setBackground(Color.BLACK);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			btnNewButton = new JButton("");//�α��ǰ
			btnNewButton.setIcon(new ImageIcon(Menu.class.getResource("/image/button/PopulariteMenuButton.PNG")));
			btnNewButton.setBounds(12, 35, 114, 40);
			btnNewButton.setBorderPainted(false);//��ư�׵θ� ������
			contentPane.add(btnNewButton);
			btnNewButton.addMouseListener(this);


			
			btnNewButton_1 = new JButton("");//���
			btnNewButton_1.setIcon(new ImageIcon(Menu.class.getResource("/image/button/DrinkMenuButton.PNG")));
			btnNewButton_1.setBounds(12, 85, 114, 40);
			btnNewButton_1.setBorderPainted(false);//��ư�׵θ� ������
			contentPane.add(btnNewButton_1);
			
			btnNewButton_2 = new JButton("");//����
			btnNewButton_2.setIcon(new ImageIcon(Menu.class.getResource("/image/button/SnackMenuButton.PNG")));
			btnNewButton_2.setBounds(12, 135, 114, 40);
			btnNewButton_2.setBorderPainted(false);//��ư�׵θ� ������
			contentPane.add(btnNewButton_2);
			
			btnNewButton_3 = new JButton("");//���
			btnNewButton_3.setIcon(new ImageIcon(Menu.class.getResource("/image/button/RamenMenuButton.PNG")));
			btnNewButton_3.setBounds(12, 185, 114, 40);
			btnNewButton_3.setBorderPainted(false);//��ư�׵θ� ������
			contentPane.add(btnNewButton_3);
			
			btnNewButton_4 = new JButton("");//�õ�
			btnNewButton_4.setIcon(new ImageIcon(Menu.class.getResource("/image/button/InstantMenuButton.PNG")));
			btnNewButton_4.setBounds(12, 235, 114, 40);
			btnNewButton_4.setBorderPainted(false);//��ư�׵θ� ������
			contentPane.add(btnNewButton_4);
			
			
			panel_1 = new JPanel();
			panel_1.setBounds(133, 35, 743, 536);
			contentPane.add(panel_1);
			panel_1.setLayout(null);
			
			scrollBar = new JScrollBar();
			scrollBar.setBounds(714, 10, 17, 516);
			panel_1.add(scrollBar);
			
			btnNewButton_5 = new JButton("");
			btnNewButton_5.setBounds(690, 591, 186, 99);
			contentPane.add(btnNewButton_5);
			btnNewButton_5.setIcon(new ImageIcon(Menu.class.getResource("/image/button/MenuOrderButton.PNG")));
			
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setBounds(31, 581, 336, 132);
			contentPane.add(lblNewLabel_1);
			lblNewLabel_1.setIcon(new ImageIcon(Menu.class.getResource("/logo/logo3.PNG")));
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			Image img=null;
		    if(e.getSource()==btnNewButton)  {
			System.out.println("1234");
			try{
				btnNewButton.setIcon(new ImageIcon(Menu.class.getResource("image/button/DrinkMenuButton.PNG")));
			}catch(Exception a){
				System.out.println("�̹��� ������ �����ϴ�.");
			}
		    	}
		    }	

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}//Menu
