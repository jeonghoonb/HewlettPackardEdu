package day0707;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutEx extends JFrame {
   
   public JButton b1, b2, b3, b4, b5;
   
   public GridLayoutEx() {
      //setLocation(600, 200); //처음 Frame 뜨는 위치 설정 (모니터에 따라 다르다)
      
      b1 = new JButton("버튼 1");
      b2 = new JButton("버튼 2");
      b3 = new JButton("버튼 3");
      b4 = new JButton("버튼 4");
      b5 = new JButton("버튼 5");
      
      setLayout(new GridLayout(2, 3, 2, 5)); //GridLayout( 행, 열, 열 사이 간격, 행 사이 간격 )
      add(b1); //문자열로 입력 또는 BorderLayout.상수명 으로 가능
      add(b2);
      add(b3);
      add(b4);
      add(b5);

      
// awt 종료 이벤트      
//      addWindowListener(new WindowAdapter() {
//         public void windowClosing(WindowEvent e) {
//            System.exit(0);
//         }
//      });
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Jframe 에서는 이걸로 종료
      setSize(500, 500);
      setVisible(true);
   }
   
   public static void main(String[] args) {
      new GridLayoutEx();
   }
}