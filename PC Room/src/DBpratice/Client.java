package DBpratice;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;


class Client implements Runnable{
   
    public void run() {
       
    }

    public static void main(String args[]){
		OutputStreamWriter osw=null;
        InputStreamReader isr=null;
        PrintWriter pw =null;
        try {
            //������ ip�ּҿ� port �ѹ�
            Socket socket = new Socket("192.168.43.78",8081);
            OutputStream os = socket.getOutputStream();
            osw = new OutputStreamWriter(os);
           
            pw = new PrintWriter(osw);
           
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Making Socket is Failed");
        }
        //������ ���ڿ�; ���� �ƿ� sql��ɹ� �������� ����
        String sql="INSERT INTO member(age) VALUES(5555);";

            //������ ����
            pw.println(sql);
            pw.flush();

    }
   
}