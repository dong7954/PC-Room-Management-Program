package Server;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class ManagerMain extends JFrame implements ActionListener{
		private JPanel contentPane; // ��ü�г�
				JButton btn1;// ȸ����ư
				JButton btn2;//�����ư
				JButton btn3;//Ȩ
				JButton btn4;//�޴�
				JLayeredPane layeredPane;//�г��� ��� layer�г�
				JPanel layerPanel;//���̾ �߰���ų �г�
				PanelTest1 pt1=null;//�г��� �����ϴ� ��ư
				ServerManagerSangseungja1 pt2=null;
				//PanelTest3 pt3=null;
				//PanelTest4 pt4=null;
		public static void main(String[] args) {
			ManagerMain frame = new ManagerMain();
						frame.setVisible(true);
		}
		public ManagerMain() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1322, 834);
		
			contentPane = new JPanel();
			contentPane.setBackground(Color.BLACK);
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			layeredPane=new JLayeredPane();
			layeredPane.setBounds(344, 161, 942, 601);
			contentPane.add(layeredPane);
			layeredPane.setLayout(null);
			
			pt1=new PanelTest1();
			layeredPane.add(pt1);
			pt1.setBounds(0, 0, 942, 601);


			pt2=new ServerManagerSangseungja1();
			layeredPane.add(pt2);
			pt2.setBounds(0, 0, 942, 601);

			/*pt3=new PanelTest3();
			layeredPane.add(pt3);
			pt3.setBounds(0, 0, 942, 601);

			pt4=new PanelTest4();
			layeredPane.add(pt4);
			pt4.setBounds(0, 0, 942, 601);*/
			
			layerPanel =new JPanel();
			layerPanel.setBounds(0, 0, 942, 601);
			layerPanel.setBackground(Color.LIGHT_GRAY);
			layeredPane.add(layerPanel);
			
			btn1 = new JButton("ȸ��"); //ȸ����ư
			btn1.setBounds(419, 64, 103, 59);
			btn1.setBorderPainted(false);//��ư�׵θ� ������ 
			contentPane.add(btn1);
			btn1.addActionListener(this);
			
			btn2 = new JButton("����");//�����ư
			btn2.setBounds(558, 64, 103, 59);
			btn2.setBorderPainted(false);//��ư�׵θ� ������
			contentPane.add(btn2);
			btn2.addActionListener(this);
			
			
			btn3 = new JButton("Ȩ");//Ȩ��ư
			btn3.setBounds(693, 64, 103, 59);
			btn3.setBorderPainted(false);//��ư�׵θ� ������
			contentPane.add(btn3);
			btn3.addActionListener(this);
			
			btn4 = new JButton("�޴�");//�޴���ư
			btn4.setBounds(835, 64, 103, 59);
			btn4.setBorderPainted(false);//��ư�׵θ� ������
			contentPane.add(btn4);
			btn4.addActionListener(this);
			
			setVisible(true);
		}
		public void switchPane(JPanel panel){// �г� 1���� 2�� ���� �� �缳��
	        		layeredPane.removeAll();
	        		layeredPane.add(panel);
	        		layeredPane.repaint();
	        		layeredPane.revalidate();
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==btn1) {
				switchPane(pt1);
			}
			if(e.getSource()==btn2) {
				switchPane(pt2);
			}
			/*if(e.getSource()==btn3) {
				switchPane(pt3);
			}
			if(e.getSource()==btn4) {
				switchPane(pt4);
			}*/
		}
	}



