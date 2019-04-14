package day0710;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class DialogEx extends JFrame {
   
   JButton button;
   Dialog dialog;
   
   public DialogEx() {
      super("Dialog EX");
      button = new JButton("로그인");
      /*dialog = new Dialog(this); //this 기억하기.
      dialog.setSize(100, 100);*/
      dialog = new MyDialog(this);
      
      //dialog.pack(); //Component 크기에 알맞게 생성
      
      setLayout(new FlowLayout());
      add(button);
      
      setSize(300, 300);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      });
      
      button.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            dialog.setVisible(true);
            
         }
      });
   }
   
   public static void main(String[] args) {
      new DialogEx();
   }
}

class MyDialog extends JDialog{
   
   public Panel p;
   public JTextField tfId;
   public JPasswordField tfPw;
   public Label lbId, lbPw, lb1, lb2, lb3, lb4, lb5, lb6;
   public JButton btnOk, btnReset;
   public Dialog_Client dc;

   public MyDialog(JFrame frame) {
      super(frame);
      dc = new Dialog_Client("jh", "123");
      setTitle("로그인 창");
      p = new Panel();
      tfId = new JTextField("");
      tfPw = new JPasswordField("");
      lbId = new Label(" ID ");
      lbPw = new Label(" PW ");
      lb1 = new Label();
      lb2 = new Label();
      lb3 = new Label();
      lb4 = new Label();
      lb5 = new Label();
      lb6 = new Label();
      btnOk = new JButton("로그인");
      btnReset = new JButton("취소");
         
      tfPw.echoCharIsSet();
      
      p.setLayout(new GridLayout(3, 2));
      p.add(lb1);
      p.add(lbId);
      p.add(tfId);
      p.add(lb2);
      p.add(lb3);
      p.add(lbPw);
      p.add(tfPw);
      p.add(lb4);
      p.add(lb6);
      p.add(btnOk);
      p.add(btnReset);
      p.add(lb5);
      add(p);
   
      btnOk.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
               if(tfId.getText().equals(dc.id) && tfPw.getText().equals(dc.pw)) {
                  System.out.println("로그인 성공");
                  JDialog jd = new JDialog();
                  jd.setVisible(true);
                  jd.add(new Label("로그인 성공"));
                  jd.pack();
                  
               }else {
                  System.out.println("로그인 실패");
               }
            
         }
      });
      
      btnReset.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            tfId.setText(" ");
            tfPw.setText(" ");
         }
      });
      
      setSize(400, 150);
   
   }
   
   
   
}

class Dialog_Client{
   public String id, pw;
   
   Dialog_Client(String id, String pw){
      this.id = id;
      this.pw = pw;
   }
   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getPw() {
      return pw;
   }

   public void setPw(String pw) {
      this.pw = pw;
   }
   
   
}