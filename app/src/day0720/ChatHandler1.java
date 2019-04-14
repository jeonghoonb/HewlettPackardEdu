package day0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatHandler1 extends Thread {

	private Socket s;
	private BufferedReader i;
	private PrintWriter o;
	private ChatServer1 server;
	private String clientName;

	public ChatHandler1() {
	
	}
	
	public ChatHandler1(ChatServer1 server, Socket s) throws IOException {
		this.s = s;
		this.server = server;
		InputStream ins = s.getInputStream();
		OutputStream os = s.getOutputStream();
		i = new BufferedReader(new InputStreamReader(ins));
		o = new PrintWriter(new OutputStreamWriter(os), true);
	}

	@Override
	public void run() {
		String name = "";
		try {
			name = i.readLine();		
			
			server.register(this); //Vector에 저장
			broadcast(name + "님이 방문하셨습니다"); //Client가 입력한 이름을 받아서 broadcast() 호출
			clientName += "#"+name;
			
			while (true) {
				String msg = i.readLine();
				broadcast(name + "-" + msg+clientName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		server.unregister(this);
		broadcast(name + "님이 나갔습니다.");
		try {
			i.close();
			o.close();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void println(String message) {
	 	o.println(message); //PrintWriter를 통해 출력
	}

	protected void broadcast(String message) {
		server.broadcast(message);
	}

}
