package MultiChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

public class ChatHandler extends Thread {
	private Socket s;
	private BufferedReader i;
	private PrintWriter o;
	private ChatServer server;

	public ChatHandler(ChatServer server, Socket s) throws IOException {
		this.s = s;
		this.server = server;
		InputStream ins = s.getInputStream();
		OutputStream os = s.getOutputStream();
		i = new BufferedReader(new InputStreamReader(ins));
		o = new PrintWriter(new OutputStreamWriter(os), true);
	}

	@Override
	public void run() {
		try {
			while(true){
				String msg = i.readLine();
				String protocol = "";
				if(msg == Integer.toString(100) || msg == Integer.toString(300)){
					protocol = msg;
				}
				StringTokenizer st = new StringTokenizer(msg, "|");
				protocol = st.nextToken();
				
				switch (Integer.parseInt(protocol)) {
				case 100:
					System.out.println(100);
					String name = st.nextToken();
					server.register(this, name);
					broadcast(name + "님이 방문하셨습니다.");
					break;
				case 200:
					System.out.println(200);
					msg = st.nextToken();
					broadcast(msg);
					break;	
				case 300:
					System.out.println(300);
					name = st.nextToken();
					broadcast(name+"님이 나갔습니다.");
					server.unregister(this, name);
					break;
				default:
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}try {
			i.close();
			o.close();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void println(String message) {
		o.println(message);
	}

	public void broadcast(String message) {
		server.broadcast(message);
	}
}
