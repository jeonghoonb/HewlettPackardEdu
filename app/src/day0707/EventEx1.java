package day0707;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EventEx1 extends Frame implements ActionListener, AdjustmentListener {

   Button btn1, btn2;
   Scrollbar sb;
   Checkbox ch;
   
   public EventEx1() {
      
      btn1 = new Button("버튼1 ");
      btn2 = new Button("버튼2");
      sb = new Scrollbar(Scrollbar.HORIZONTAL, 5, 5, 0, 260);
      ch = new Checkbox("라벨1", true);
      //setLayout(new FlowLayout());
      
      add(btn1, "West");
      add(btn2, "East");
      add(sb, "Center");
      add(ch, "South");
      setSize(300, 150);
      setVisible(true);
      
      btn1.addActionListener(this);
      btn2.addActionListener(this);
      sb.addAdjustmentListener(this);
      
      //내부 익명 클래스로 사용해되 된다.
      ch.addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
            System.out.println("CheckBox : "+((Checkbox)e.getSource()).getLabel());
            
         }
      });
      
      addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      });

   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      Button obj = (Button)e.getSource(); //getSource() 컴포넌트 객체 찾아오기. 원래 Object의 메서드인데 강제 형변환해서 원하는데로 사용
      System.out.println(obj.getLabel()); //getLabel() 컴포넌트 객체의 텍스트 값 리턴
      
      if(obj == btn1) {
         System.out.println("btn1 이벤트 발생");      
      }else {
         System.out.println("btn2 이벤트 발생");
      }
   }
   

   @Override
   public void adjustmentValueChanged(AdjustmentEvent e) {
      System.out.println("Scroll : "+e.getValue());
   }

   public static void main(String[] args) {
      new EventEx1();
   }
   
}