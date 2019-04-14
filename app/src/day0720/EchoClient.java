package day0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
	
	private Socket socket;
	
	public EchoClient(String host, int port) throws Exception{
		socket = new Socket(host, port);
	}
	
	public void echo() throws IOException{
		InputStream is = socket.getInputStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		OutputStream os = socket.getOutputStream();
		PrintWriter out = new PrintWriter(os, true);
		BufferedReader con = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String msg = con.readLine(); //키보드로 입력한 값을 msg에 저장
			out.println(msg); //msg를 PrintWriter를 이용해 Server에보낸다.
			if (msg.equals("bye")) {
				break;
			}
			System.out.println(in.readLine()); //BufferedReader를 통해 Server에서 보낸 데이터를 받아 출력
		}
	}
	
	public void close() throws IOException {
		socket.close();
	}
	
	public static void main(String[] args) {
		try{
			EchoClient ec;
			System.out.println("메시지를 입력하세요.");
			if(args.length > 0){
				ec = new EchoClient(args[0], 1289); //args에 IP를 입력하면 그걸 받고
			}else{
				ec = new EchoClient("59.29.225.105", 1289); //여긴 코드상으로 입력, Server의 IP, port입력
			}
			ec.echo();
			ec.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
