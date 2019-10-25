package DBpratice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;

public class RankingServer implements Runnable {
	// ����� ���� ��Ʈ ��ȣ
	public static final int SERVERPORT = 8081;

	@Override
    public void run() {
        // TODO Auto-generated method stub       
         PrintWriter pw;
        try{
            System.out.println("S: Connecting...");
            ServerSocket serverSocket = new ServerSocket(SERVERPORT);
           
            while (true) {
                Socket client = serverSocket.accept();
                System.out.println("S: Receiving...");
                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                   
                    //������ �ִ� dbname�̶�� db�� ����, 'dlaqpelem'�� DB���� �� ���Ǵ� ��й�ȣ��. ����  
                       //������ ��й�ȣ�� �Է��ϸ� �ȴ�.
                    JdbcConnect jdbc=new JdbcConnect("member","1234");
                    //client���Լ� ���� ���ڿ��� str�� ���� ��, DB Update
                    String str = in.readLine();                   
                    jdbc.excuteUpdate(str);
                    jdbc.closeDB();
                   
                } catch(Exception e) {
                    System.out.println("S: Error");
                    e.printStackTrace();
                } finally {
                    client.close();
                    System.out.println("S: Done.");
                }
            }
        } catch (Exception e) {
            System.out.println("S: Error");
            e.printStackTrace();
        }
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread desktopServerThread = new Thread(new RankingServer());
		desktopServerThread.start();
	}
}
