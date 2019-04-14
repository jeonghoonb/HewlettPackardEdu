package day0720;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatServer1 {

	private Vector handlers;

	public ChatServer1(int port) {
		try {
			ServerSocket server = new ServerSocket(port); //서버 소켓 생성
			handlers = new Vector(); //백터 객체 생성
			System.out.println("ChatServer is ready.");
			while (true) {
				Socket client = server.accept(); //client 요청 올 때 마다 실행
				ChatHandler1 c = new ChatHandler1(this, client);
				c.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Object getHandler(int index) {
		return handlers.elementAt(index);
	}

	public void register(ChatHandler1 c) {
		handlers.addElement(c);
	}

	public void unregister(Object o) {
		handlers.removeElement(o);
	}

	public void broadcast(String message) {
		synchronized (handlers) {
			int n = handlers.size(); //Vector의 크기를 구한다.
			for (int i = 0; i < n; i++) {
				ChatHandler1 c = (ChatHandler1) handlers.elementAt(i); //Vector안의 요소를 하나 씩 꺼낸다.
				try {
					c.println(message);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		new ChatServer1(9830);
	}
}
