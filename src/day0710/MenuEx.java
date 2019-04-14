package day0710;

import java.awt.Canvas;
import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;

public class MenuEx extends Frame implements ActionListener {

	public MenuBar mb;
	public Menu m;
	public Dialog dialog;
	public Canvas can;
	public MenuItem[] mi;
	public TextArea ta;
	public String dfName, title;
	public boolean isNewFile, isOpenFile;
	public PrintWriter pw;
	public BufferedWriter bw;
	public FileDialog fileDialog;
	public InputStream is;
	public InputStreamReader isr;
	public BufferedReader br;
	public FileWriter fw;
	public FileReader fr;
	public File file;
	public int t_s_end;

	MenuEx() {

		mb = new MenuBar();
		m = new Menu("File");
		mi = new MenuItem[5];
		mi[0] = new MenuItem("New File");
		mi[1] = new MenuItem("Open File");
		mi[2] = new MenuItem("Save File");
		mi[3] = new MenuItem("Save As");
		mi[4] = new MenuItem("Exit");
		ta = new TextArea();
		title = " ";
		for (int i = 0; i < mi.length; i++) {
			m.add(mi[i]);
			mi[i].addActionListener(this);
			if (i != 2 && i != (mi.length - 1))
				m.addSeparator();
		}
		mi[2].setEnabled(false);
		mi[3].setEnabled(false);
		ta.setEnabled(false);
		mb.add(m);
		add(ta);
		
		setMenuBar(mb);
		setSize(500, 500);
		setVisible(true);

		System.out.println(ta.getText());
		m.addActionListener(this);
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				t_s_end = 10;
				while(t_s_end>0){
					t_s_end--;
					setTitle(title+"\t\t\t\t\t 자동 종료 시간 : "+Integer.toString(t_s_end));
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				JOptionPane.showMessageDialog(null, "움직임이 없어 자동 종료됩니다.");
				System.exit(0);
			}
		});
		t1.start();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		// New File
		if (obj.equals(mi[0])) {
			newFile();

			// Open File
		} else if (obj.equals(mi[1])) {
			openFile();

			// Save File
		} else if (obj.equals(mi[2])) {
			saveFile();

			// Sava As
		} else if (obj.equals(mi[3])) {
			savaAs();

			// Exit
		} else if (obj.equals(mi[4])) {
			exitFile();
		}

	}
	

	public void newFile() {
		t_s_end = 10;
		title = "New File";
		isNewFile = true;
		ta.setText(" ");
		ta.setEnabled(true);
		setTitle(title);
		mi[2].setEnabled(true);
		mi[3].setEnabled(true);
	}

	public void openFile() {
		t_s_end = 10;
		isOpenFile = true;

		fileDialog = new FileDialog(this, "Open File", FileDialog.LOAD);
		fileDialog.setVisible(true);

		if (fileDialog.getFile() == null) {
			return;
		}
		dfName = fileDialog.getDirectory() + fileDialog.getFile();
		ta.setText(" ");
		try {
			fr = new FileReader(dfName);
			br = new BufferedReader(fr);
			String line = "";
			while ((line = br.readLine()) != null) {
				ta.append(line + "\n");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}
		title = fileDialog.getFile();
		setTitle(title);
		ta.setEnabled(true);
		mi[2].setEnabled(true);
		mi[3].setEnabled(true);
	}

	public void saveFile() {
		t_s_end = 10;
		// 새로 만든 파일 일 때
		if (isNewFile) {
			fileDialog = new FileDialog(this, "Save File", FileDialog.SAVE);
			fileDialog.setVisible(true);
			dfName = fileDialog.getDirectory() + fileDialog.getFile() + ".txt";
			file = new File(dfName);
			try {
				fw = new FileWriter(file);
				bw = new BufferedWriter(fw);
				pw = new PrintWriter(bw, true);
				pw.write(ta.getText());
			} catch (IOException e1) {
				e1.printStackTrace();
			} finally {
				pw.close();
			}

			// 기존 파일 내용 변경일 때
		} else {
			file = new File(dfName);

			try {
				fw = new FileWriter(file);
				bw = new BufferedWriter(fw);
				pw = new PrintWriter(bw, true);

				is = System.in;
				isr = new InputStreamReader(is);
				br = new BufferedReader(isr);
				pw.write(ta.getText());

			} catch (IOException e1) {
				e1.printStackTrace();
			} finally {
				try {
					pw.close();
					br.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

	}

	public void savaAs() {
		t_s_end = 10;
		fileDialog = new FileDialog(this, "Save File", FileDialog.SAVE);
		fileDialog.setVisible(true);
		dfName = fileDialog.getDirectory() + fileDialog.getFile() + ".txt";
		file = new File(dfName);
		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw, true);
			pw.write(ta.getText());
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			pw.close();
		}
	}

	public void exitFile() {
		if (isNewFile == true || isOpenFile == true) {
			if (JOptionPane.showConfirmDialog(null, "저장 후 종료하시겠습니까?", "alert", 0) == 0) {
				saveFile();
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		new MenuEx();
	}

}
