package MultiChat;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ChatClient extends JFrame implements Runnable, ActionListener {

	private BufferedReader i;
	private PrintWriter o;
	private JTextField input;
	private JTextArea output;
	private JLabel label;
	private Thread listener;
	private String host;
	private JScrollPane scroll;
	private List list;
	private StringTokenizer st;
	private JButton btnEnter, btnExit;

	public ChatClient(String server) {
		super("채팅프로그램");
		host = server;
		listener = new Thread(this);
		listener.start();
		output = new JTextArea();
		scroll = new JScrollPane(output);

		output.setEditable(false);
		list = new List();
		btnEnter = new JButton("입장");
		btnExit = new JButton("퇴장");
		label = new JLabel("사용자 이름");
		input = new JTextField(15);
		
		Panel bottom = new Panel(new FlowLayout());
		Panel up = new Panel(new GridLayout(1, 2));
		
		up.add(scroll, "Center");
		up.add(list, "East");
		bottom.add(label);
		bottom.add(input);
		bottom.add(btnEnter);
		bottom.add(btnExit);
		add(up, "Center");
		add(bottom, "South");

		btnExit.setEnabled(false);
		btnEnter.addActionListener(this);
		btnExit.addActionListener(this);
		input.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 500);
		setVisible(true);
	}

	int cnt;
	@Override
	public void actionPerformed(ActionEvent e) {
		Object c = e.getSource();
		if(c == btnEnter){
			label.setText("메시지");
			o.println(100);
			input.setText("");
			btnExit.setEnabled(true);
			btnEnter.setEnabled(false);
		}else if(c == btnExit){
			o.println(300);
		}else if(c == input){
			o.println(200 + "|" + input.getText());
		}
	}

	@Override
	public void run() {
		try {
			Socket s = new Socket(host, 9000);
			InputStream ins = s.getInputStream();
			OutputStream os = s.getOutputStream();
			i = new BufferedReader(new InputStreamReader(ins));
			o = new PrintWriter(new OutputStreamWriter(os), true);

			while (true) {
				String line = i.readLine();
				System.out.println(line);
				st = new StringTokenizer(line, "#");
				String token = st.nextToken();
				output.append(token + "\n");
				list.clear();
				while (st.hasMoreTokens()) {
					list.add(st.nextToken());
				}
				scroll.getVerticalScrollBar().setValue(scroll.getVerticalScrollBar().getMaximum());
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		if (args.length > 0) {
			new ChatClient(args[0]);
		} else {
			new ChatClient("localhost");
		}
	}

}
