package day0720;

import java.awt.BorderLayout;
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
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;

public class ChatClient1 extends JFrame implements Runnable, ActionListener {

	private BufferedReader i;
	private PrintWriter o;
	private JTextArea output;
	private JTextField input;
	private JLabel label;
	private Thread listener;
	private String host;
	private JScrollPane scroll;
	private JPanel p1, p2;
	private JList<List> clientList;
	private Vector clientNames;
	private String[] strName;

	
	public ChatClient1(String server) {
		super("채팅 프로그램");
		host = server;
		
		listener = new Thread(this);
		output = new JTextArea();
		clientList = new JList();
		clientNames = new Vector();
		
		//scroll = new JScrollPane(output, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll = new JScrollPane(output);
		p1 = new JPanel(new BorderLayout()); 
		p2 = new JPanel(new BorderLayout());
		
		label = new JLabel("사용자 이름");
		input = new JTextField();
		
		
		
		output.setEditable(false); // TextArea 클릭 및 글 안 써지게
		
		p1.add(scroll, "Center");
		p1.add(clientList, "East");
		p2.add(label, "West");
		p2.add(input, "Center");
		
		add(p2, "South");
		add(p1, "Center");

		input.addActionListener(this);

		listener.start();
		
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void run() {
		try {
			Socket s = new Socket(host, 9830);
			InputStream ins = s.getInputStream();
			OutputStream os = s.getOutputStream();
			
			i = new BufferedReader(new InputStreamReader(ins));
			o = new PrintWriter(new OutputStreamWriter(os), true);
			
			while (true) {
				String line = i.readLine();
				clientNames.clear();
				strName = line.split("#");
				output.append(strName[0] + "\n");	
				for(int i=0; i<strName.length-1; i++){
					clientNames.add(strName[i+1]);
				}
				//	output.append(clientNames[0] + "\n");	
				clientList.setListData(clientNames);
				
				//output.setCaretPosition(output.getDocument().getLength()); //스크롤바 자동 내리기
				scroll.getVerticalScrollBar().setValue(output.getDocument().getLength()); //스크롤바 자동 내리기
			}		
		} catch (IOException ie) {
			ie.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object c = e.getSource();
		if (c == input) {
			label.setText("메시지");
			o.println(input.getText());
			input.setText("");
		}
	}

	public static void main(String[] args) {
		if (args.length > 0) {
			new ChatClient1(args[0]);
		} else {
			new ChatClient1("localhost");
		}
	}

}
