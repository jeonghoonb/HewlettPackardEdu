package day0710;

import java.awt.*;
import java.awt.event.*;

/*
 *  - MouseListener Interface를 사용하면 overriding 할 메서드가 많다. MouseAdapter Class 사용(상속 또는 내부익명)하면 소스를 줄일 수 있다.
 *  - 휠, 움직임 등은 MouseMotionListener Interface에 있다.
 */
public class CardLayoutEx extends Frame implements MouseListener {

   private Panel p1, p2, p3, p4;
   private Label lb1, lb2, lb3, lb4;
   private CardLayout cards;

   public CardLayoutEx() {
      setTitle("CardLayout Ex");
      
      //CardLayout 중첩 배치
      cards = new CardLayout();
      setLayout(cards);

      p1 = new Panel();
      p2 = new Panel();
      p3 = new Panel();
      p4 = new Panel();

      lb1 = new Label("I");
      p1.setBackground(Color.yellow);
      p1.add(lb1);

      lb2 = new Label("I Love");
      p2.setBackground(Color.green);
      p2.add(lb2);

      lb3 = new Label("I Love Java");
      p3.setBackground(Color.magenta);
      p3.add(lb3);

      lb4 = new Label("I Love JavaBible");
      p4.setBackground(Color.white);
      p4.add(lb4);
      
      //add(추가할 컴포넌트, 컴포넌트 이름 설정)
      add(p1, "p1");
      add(p2, "p2");
      add(p3, "p3");
      add(p4, "p4");
      
      cards.show(this, "frame");
      setSize(200, 200);
      setVisible(true);
      
      //이벤트 메서드 호출
      
      //이렇게 MouseAdapter Class를 내부 익명으로 사용해도 됨 OR 상속 받아서 사용해도 됨
      p1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
            super.mouseClicked(e);
         }
      });
      p2.addMouseListener(this);
      p3.addMouseListener(this);
      p4.addMouseListener(this);
      
      //awt 닫기 이벤트
      addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      });
   }
   
   
   @Override //클릭 : 마우스 클릭을 유지한채로 움직이면 클릭이 안 되고 Pressed()로 인식
   public void mouseClicked(MouseEvent e) { 
      cards.next(this);
      //cards.previous(this); //이전 화면으로 넘김
   }

   @Override //마우스가 awt 화면으로 들어감
   public void mouseEntered(MouseEvent e) { System.out.println("들어옴");}

   @Override //마우스가 awt 화면 밖으로 나감
   public void mouseExited(MouseEvent e) { System.out.println("나감");}

   @Override //마우스 누름
   public void mousePressed(MouseEvent e) { System.out.println("마우스 누름");}

   @Override //마우스 뗌
   public void mouseReleased(MouseEvent e) { System.out.println("마우스 뗌");}
   
   public static void main(String[] args) {
      new CardLayoutEx(); 
   }
}