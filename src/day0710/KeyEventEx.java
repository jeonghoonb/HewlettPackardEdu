package day0710;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class KeyEventEx extends JFrame implements KeyListener {

   JTextArea ta;
   JTextField txt;
   JButton b;

   public KeyEventEx() {
      b = new JButton("지 우 기");
      txt = new JTextField();
      ta = new JTextArea();

      // JFrame은 기본 레이아웃이 BorderLayout
      add("North", txt);
      add(ta, BorderLayout.CENTER);
      add(b, "South");

      setSize(300, 300);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      txt.addKeyListener(this);

      /*
       * KeyListener Interface 대신 KeyAdapter Class 사용해도 가능하다
       */
      // txt.addKeyListener(new KeyAdapter() {
      // @Override
      // public void keyPressed(KeyEvent e) {
      // // TODO Auto-generated method stub
      // super.keyPressed(e);
      // }
      // });

      b.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            ta.setText("");
            txt.setText("");

         }
      });
   }

   /*
    * getKeyChar 눌린 키보드의 문자값 받아오는 메서드 엔터, 스페이스바, 백스페이스 등 상수값으로 저장된 필드 존재.
    */
   @Override
   public void keyPressed(KeyEvent e) {
      int key = (int) e.getKeyChar();
      if (key >= 65 && key <= 90) {
         System.out.println("제한된 입력");
      } else if (key >= 97 && key <= 122) {
         System.out.println("제한된 입력");
      } else {
         ta.append(e.getKeyChar() + " 가 눌림.\n");
         if (e.getKeyChar() == KeyEvent.VK_SPACE)
            System.out.println("스페이스바가 입력되었습니다.");
         else if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE)
            System.out.println("백 스페이스가 입력되었습니다.");
         else if (e.getKeyChar() == KeyEvent.VK_ENTER)
            System.out.println("엔터가 입력되었습니다.");
      }
   }

   @Override
   public void keyReleased(KeyEvent e) {
      int key = (int) e.getKeyChar();
      if (key >= 65 && key <= 90) {
         System.out.println("제한된 입력");
      } else if (key >= 97 && key <= 122) {
         System.out.println("제한된 입력");
      } else
         ta.append(e.getKeyChar() + " 를 놓았음.\n");
   }

   @Override
   public void keyTyped(KeyEvent e) {
   
   }

   public static void main(String[] args) {
      new KeyEventEx();
   }
}