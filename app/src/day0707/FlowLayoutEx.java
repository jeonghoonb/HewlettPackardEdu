package day0707;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutEx extends JFrame {
   
   public JButton b1, b2, b3;
   
   public FlowLayoutEx() {
      setSize(500, 500);
      setVisible(true);
      //setLocation(600, 200); //처음 Frame 뜨는 위치 설정 (모니터에 따라 다르다)
      setLayout(new FlowLayout()); //setLayout 설정 안 하면 기본 BorderLayout 가운데 정렬로 중첩
      
      b1 = new JButton("버튼 1");
      b2 = new JButton("버튼 2");
      b3 = new JButton("버튼 3");
      add(b1);
      add(b2);
      add(b3);
      
// awt 종료 이벤트      
//      addWindowListener(new WindowAdapter() {
//         public void windowClosing(WindowEvent e) {
//            System.exit(0);
//         }
//      });
//      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Jframe 에서는 이걸로 종료
   }
   
   public static void main(String[] args) {
      new FlowLayoutEx();
   }
}