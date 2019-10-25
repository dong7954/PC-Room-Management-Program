package Client;
 
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import assets.database;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JToggleButton;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
 
public class bugerHamberger4 {
	String[] columnName = { "제품명", "가격", "수량", "총액" };
	DefaultTableModel model = new DefaultTableModel(columnName, 0);
	JTable table;
	JLabel lb1;
	database db = new database();
    int count = 0;
    String show = "";
    String menu[] = { "콜라", "사이다", "환타", "소떡소떡", "피카츄", "라면", "불고기버거", "핫도그" };
    int price[] = { 1000, 1000, 1000, 1500, 2500, 2500, 2700, 2500 };
    ImageIcon[] img = { 
    		new ImageIcon("Image/1.png"),
    		new ImageIcon("Image/2.png"),
    		new ImageIcon("Image/3.png"),
    		new ImageIcon("Image/4.png"),
    		new ImageIcon("Image/5.png"),
    		new ImageIcon("Image/6.png"),
    		new ImageIcon("Image/7.png"),
    		new ImageIcon("Image/8.png")};
    
   // public List phoneList = new List(10);
   // private JTable tb;
   // private JTable tb;
    /**
     * @wbp.parser.entryPoint
     */
    bugerHamberger4() {
        // 디자인단
        // 프레임 설정단
        JFrame frame = new JFrame("ODD PC CAFE");
        frame.setBounds(0, 0, 625, 1000);
        frame.setBackground(Color.black);
        frame.setResizable(false);
 
        // 폰트
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
        Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 22);
 
        // 북쪽
        Panel pNorth = new Panel();
        pNorth.setBackground(new Color(0, 0, 0));
        pNorth.setLayout(null);
        pNorth.setSize(0, 500);
        pNorth.setFont(font);
 
        // 배열 설정 부분
        //String header[] ={"주문 현황"};
        //String contents[][]={{"빅맥버거 5000 1 5000"}};
        
        
        JButton bt[] = new JButton[menu.length];
        TextField suja[] = new TextField[menu.length];
        Button minus[] = new Button[menu.length];
        Button plus[] = new Button[menu.length];
        JButton ok[] = new JButton[menu.length];
        Label l[] = new Label[menu.length];
        //ImageIcon icon[] = new ImageIcon[menu.length];
     /*  ImageIcon[] icon = { // ImageIcon 클래스 객체 images를 배열로 선언합니다. 
     		   new ImageIcon("Image/2.png"), // [0] 
     		   // [2]
     		 };*/
        
        table = new JTable(model);
        table.setFont(new Font("맑은 고딕", Font.PLAIN, 16 ));
        table.setForeground(Color.black);
        table.setFillsViewportHeight (true);
        table.setBackground(Color.white);
        
        JScrollPane scrollPane = new JScrollPane(table);
        
        // 버튼 설정 부분
        for (int i = 0; i < menu.length; i++) {
        	
 
            // 햄버거 버튼
            bt[i] = new JButton();
            bt[i].setIcon(img[i]);
            bt[i].setBackground(new Color(255,255,255));
            if (i < 4) {
                bt[i].setBounds(25 + i * 150, 50, 100, 100);
              
            } else {
                bt[i].setBounds(25 + (i - 4) * 150, 300, 100, 100);
            }
            bt[i].setBorderPainted(false); 
            
            bt[i].setContentAreaFilled(false);
            
            bt[i].setFocusPainted(false);

            // 숫자 txt 버튼
            suja[i] = new TextField("0");
            suja[i].setBackground(Color.white);
            suja[i].setEditable(false);
            suja[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 130, 40, 20);
 
            // "-" 버튼
            minus[i] = new Button("-");
            minus[i].setBounds(bt[i].getX(), suja[i].getY(), 20, 20);
            minus[i].setEnabled(false);
 
            // "+" 버튼
            plus[i] = new Button("+");
            plus[i].setBounds(bt[i].getX() + (100 - 20), suja[i].getY(), 20, 20);
            plus[i].setEnabled(false);
 
            // 가격
            l[i] = new Label(price[i] + "원");
            l[i].setBounds(bt[i].getX() + 20, suja[i].getY() - 25, 100, 20);
            l[i].setForeground(Color.white); 
            // 확인 버튼
            ok[i] = new JButton("확인");
            ok[i].setBounds(bt[i].getX(), suja[i].getY() + 30, 100, 20);
            ok[i].setEnabled(false);
 

            
            pNorth.add(bt[i]);
            pNorth.add(suja[i]);
            pNorth.add(minus[i]);
            pNorth.add(plus[i]);
            pNorth.add(l[i]);
            pNorth.add(ok[i]);
        }
        
        
        
        
 
        // 중앙
        //TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        //ta.setText("   상품명        단가        수량        합계\n\n");
        //ta.setBackground(Color.white);
        //ta.setEditable(false);
        //ta.setFont(font1);
 
        // 남쪽
        Panel pSouth = new Panel();
        pSouth.setFont(font);
        pSouth.setBackground(new Color(0, 0, 0));
 
        JButton bt1 = new JButton(new ImageIcon("Image/주문.png"));
        JButton bt2 = new JButton(new ImageIcon("Image/초기화.png"));
        JButton bt3 = new JButton(new ImageIcon("Image/닫기.png"));
        bt1.setBorderPainted(false); 
        
        bt1.setContentAreaFilled(false);
        
        bt1.setFocusPainted(false);

        bt2.setBorderPainted(false); 
        
        bt2.setContentAreaFilled(false);
        
        bt2.setFocusPainted(false);
        
        bt3.setBorderPainted(false); 
        
        bt3.setContentAreaFilled(false);
        
        bt3.setFocusPainted(false);
        
        pSouth.add(bt1);
        pSouth.add(bt2);
        pSouth.add(bt3);
 
        
        
        
       
        
         
        
        
        
        
        // 주문버튼
        bt1.addActionListener(new ActionListener() {
        	
        	@Override
            public void actionPerformed(ActionEvent e) {
            	
            	
            
                JOptionPane.showMessageDialog(null,  " 주문되었습니다. \n이용해주셔서 감사합니다.");
                //{ menu[j], String.valueOf(price[j]), String.valueOf(count), String.valueOf(price[j]*count) };
                
             
                
                
                
                
                
                for (int i = 0; i < table.getRowCount(); i++)
                	
                {
                	
                    bt[i].setEnabled(true);
                    minus[i].setEnabled(false);
                    plus[i].setEnabled(false);
                    suja[i].setText("0");
                    //ta.setText("   상품명        단가        수량        합계\n\n");
 
                    
                   
                    
                
                   // String InsertQuery = "insert into buger(buger_name,buger_money,buger_stock,buger_sum) values('" +ta  + "')";
                   // db.executeUpdate(InsertQuery);
                    
                    
                    
                    //String InsertQuery = "insert into buger( buger_name, buger_stock, buger_sum) values('" + bt[i].getText() + "','" + suja[i].getText() + "','" + l[i].getText() + "');";
                    //db.executeUpdate(InsertQuery);
                    //show = bt[j].getActionCommand();
                    //tf1.append("   " + show + "       " + price[j] + "        " + count + "         " + price[j] * count + "원" + "\n");    
                }
            }
        
        
        });
 
        // 초기화 버튼
        bt2.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	
                for (int i = 0; i < menu.length; i++) {
                    
                
                	bt[i].setEnabled(true);
                    minus[i].setEnabled(false);
                    plus[i].setEnabled(false);
                    suja[i].setText("0");
                    DefaultTableModel model = (DefaultTableModel)table.getModel();
                    
                

                    model.setNumRows(0);
                    lb1.setText("총합의금액 = 0");
                }
                
            }          
        });
 
 

       
        
        
        
      //bt3 닫기버튼
        bt3.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
               frame.dispose();
               
            }
        });
 
 
        // 컴포넌트
        frame.getContentPane().add(pNorth, BorderLayout.NORTH);
        //frame.add(ta, BorderLayout.CENTER);
        frame.getContentPane().add(pSouth, BorderLayout.SOUTH);
        
       
    
       // frame.getContentPane().add(tb, BorderLayout.CENTER);
        frame.getContentPane().add(scrollPane);
        
        lb1 = new JLabel("총합의 금액 = 0");
        lb1.setForeground(Color.BLACK);
        lb1.setBackground(Color.BLACK);
        lb1.setToolTipText("");
        lb1.setHorizontalAlignment(SwingConstants.RIGHT);
        lb1.setIcon(null);
        frame.getContentPane().add(lb1, BorderLayout.EAST);

    
        
      

        frame.setVisible(true);
        
 
        // 이벤트단
        for (int i = 0; i < menu.length; i++) {
           
        	int j = i;
            
            
 
            // 햄버그 버튼 이벤트
            bt[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    minus[j].setEnabled(true);
                    plus[j].setEnabled(true);
                    bt[j].setEnabled(false);
                    ok[j].setEnabled(true);
 
                    count = 0;
                }
            });
 
            // "-" 버튼 이벤트
            minus[i].addActionListener(new ActionListener() {
 
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (count > 0) {
                        count = count - 1;
                        suja[j].setText(count + "");
                        ok[j].setEnabled(true);
                    } else {
                        minus[j].setEnabled(false);
                    }
                }
            });
            
            // "+" 버튼 이벤트
            plus[i].addActionListener(new ActionListener() {
 
                @Override
                public void actionPerformed(ActionEvent e) {
                    count = count + 1;
                    suja[j].setText(count + "");
                    ok[j].setEnabled(true);
                    if (count > 0) {
                        minus[j].setEnabled(true);
                    }
                }
            });
            
            //확인 버튼 이벤트
            ok[i].addActionListener(new ActionListener() { 
 
                @Override
                public void actionPerformed(ActionEvent e) {
                	
                    int total = price[j]*count; 

                    for (int i = 0; i<table.getRowCount(); i++){ 
                    int amount = Integer.parseInt(table.getValueAt(i, 3)+""); 
                    total += amount; 
                    }
                    lb1.setText("총합의 금액 = "+Integer.toString(total)); 
                    
                    
                    System.out.println(count);
                    //count, menuDB[j], total
                    
                    
                    
                    String menuDB[] = {"Coke", "Cider", "Fanta", "sodduck", "Pikachu", "Lamen",
                    		"Hamburger","Hotdog"
                    };
                    
                    String a = menuDB[j];
                    System.out.println(a);
                    
                    
                    
                    //String InsertQuery = "insert into stock(Coke) Values(" + count + ");";
                    String selectQuery = "update stock set Coke = Coke-" + count +
                    		"where Coke > " + count + ";";
                
                    String select1Query = "update stock set "+ menuDB[j] + "="+ menuDB[j] + "-" + count +
                    		"where " + menuDB[j] + ">"+ count + ";";
                    
                    
                    db.executeUpdate(select1Query);
                    
                    System.out.println(j);
                		                      
                	
                    
                    show = bt[j].getActionCommand(); 
                    String[] order = { menu[j], String.valueOf(price[j]), String.valueOf(count), String.valueOf(price[j]*count) };
                   
                    model.addRow(order);
                    table.updateUI();
                    //tb.("   " +show + "       " + price[j] + "        " + count + "         " + price[j] * count
                    //       + "원" + "\n");
                    
                    
                    
                    
                   
                    
                    ok[j].setEnabled(false);
                }
            });
 
        }
 
        // 끄기
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	frame.dispose();
            }
        });
    }
 
    // 메인
    public static void main(String[] args) {
        new bugerHamberger4();
    }
}


