package MultiChat;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

public class ChatServer {
	private Vector handler;
	private ArrayList<String> users;

	public ChatServer(int port) {
		try {
			ServerSocket server = new ServerSocket(port);
			handler = new Vector<ChatHandler>();
			users = new ArrayList<String>();
			System.out.println("ChatServer is ready");
			while (true) {
				Socket client = server.accept();
				ChatHandler c = new ChatHandler(this, client);
				c.start();// 쓰레드 가동...
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<String> users) {
		this.users = users;
	}

	public Object getHandler(int index) {
		return handler.elementAt(index);// 특정 사람만 대응하게 할 수 있다.
	}

	public void register(ChatHandler c, String user) {
		handler.addElement(c);
		users.add(user);
	}

	public void unregister(Object o, String user) {
		handler.removeElement(o);
		users.remove(user);
	}

	public void broadcast(String message) {
		StringBuilder sb = new StringBuilder();
		synchronized (users) {
			for (String user : users) {
				sb.append("#" + user);
			}
		}
		synchronized (handler) {// 동기화
			int n = handler.size();
			for (int i = 0; i < n; i++) {// 벡터의 사이즈 만큼 반복
				ChatHandler c = (ChatHandler) handler.elementAt(i);//
				try {
					c.println(message+sb.toString());// 소켓을 출력
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		new ChatServer(9000);
	}

}