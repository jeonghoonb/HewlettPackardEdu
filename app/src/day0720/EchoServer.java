package day0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	private ServerSocket server;

	public EchoServer(int port) throws IOException {
		server = new ServerSocket(port); 
	}

	public void service() throws IOException {
		System.out.println("EchoServer is ready");
		Socket client = server.accept(); //client의 객체(socket) 요청을 기다림, client가 접속 할 때마다 실행

		InputStream is = client.getInputStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		OutputStream os = client.getOutputStream();
		PrintWriter out = new PrintWriter(os, true);

		while (true) {
			String msg = in.readLine(); //Client에서 보내온 데이터를 BufferedReader를 통해 받고, msg에 저장
			System.out.println(msg); //msg를 출력
			if (msg.equals("bye")) { //Client에서 보내온 데이터가 bye면 종료
				break;
			}
			out.println(">>" + msg); //Client에 PrintWriter를 통해 '>>데이터'를 전송한다.
		}
	}

	public void close() throws IOException {
		server.close();
	}

	public static void main(String[] args) {
		try {
			EchoServer es = new EchoServer(1289);
			es.service();
			es.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
