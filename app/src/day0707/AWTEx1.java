package day0707;

import java.awt.*;
import java.awt.event.*;

public class AWTEx1 extends Frame {
   
   public AWTEx1() {
      
      Panel p = new Panel(); //Panel의 기본 레이아웃은 FlowLayout < Frame의 기본 레이아웃은 BorderLayout >
      //p.setLayout(new GridLayout()); //이런식으로 사용
      
      Button b= new Button("버튼");
      b.setLabel("변경된 라벨"); //버튼에 표시 될 Text 설정
      
      Checkbox cb1 = new Checkbox("체크 박스", true);
      Checkbox cb2 = new Checkbox("체크 박스", true);
      Checkbox cb3 = new Checkbox("체크 박스", true);
      
      CheckboxGroup ch = new CheckboxGroup(); //awt에서는 별도의 RadioButton이 없다. CheckboxGroup를 사용해서 Radiobutton으로 사용 가능
      Checkbox rb1 = new Checkbox("라디오 버튼",true,ch);
      Checkbox rb2 = new Checkbox("라디오 버튼",true,ch);
      Checkbox rb3 = new Checkbox("라디오 버튼",true,ch);
      
      Choice cho = new Choice(); // = 콤보박스
      cho.add("학년 선택");
      cho.add("1학년");
      cho.add("2학년");
      cho.add("3학년");
      cho.add("4학년");
      
      Label la = new Label("자바 수강생");
      List ls = new List(4);  //리스트 : 스크롤 존재, 4대신 5를 쓰면 항목이 5개라서 스크롤 삭제 됨
      ls.add("List 1");
      ls.add("List 2");
      ls.add("List 3");
      ls.add("List 4");
      ls.add("List 5");
      
      Scrollbar sb = new Scrollbar(Scrollbar.HORIZONTAL, 200, 100, 0,255);
      TextField tf = new TextField("TextField", 20);
      TextArea ta = new TextArea("TextArea", 20, 10, 2); //("기본 출력 문자", 행개수, 열개수, 스크롤바설정(0:가로세로둘다, 1:세로, 2:가로, 3:없다)
   
      //Panel에 add() 메서드를 사용해서 Component를 추가 
      p.add(cb1);
      p.add(cb2);
      p.add(cb3);
      p.add(rb1);
      p.add(rb2);
      p.add(rb3);
      p.add(cho);
      p.add(b);
      p.add(la);
      p.add(ls);
      p.add(sb);
      p.add(tf);
      p.add(ta);
      add(p);
      
      setSize(500, 500);
      setVisible(true);
      addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      });
   }
   
   public static void main(String[] args) {
      new AWTEx1();
   }
}