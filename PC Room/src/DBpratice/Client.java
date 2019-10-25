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
            //접속할 ip주소와 port 넘버
            Socket socket = new Socket("192.168.43.78",8081);
            OutputStream os = socket.getOutputStream();
            osw = new OutputStreamWriter(os);
           
            pw = new PrintWriter(osw);
           
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Making Socket is Failed");
        }
        //전송할 문자열; 저는 아예 sql명령문 형식으로 전송
        String sql="INSERT INTO member(age) VALUES(5555);";

            //서버에 전송
            pw.println(sql);
            pw.flush();

    }
   
}