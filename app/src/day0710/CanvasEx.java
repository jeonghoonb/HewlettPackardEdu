package day0710;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CanvasEx extends Canvas implements ActionListener {

   Frame f;
   Image img;
   Button b, bUp, bDown, bLeft, bRight;
   Panel p;
   Label lb1, lb2;
   int x, y;

   public CanvasEx() {
      x=10; y=10;
      f = new Frame("Canvas Test");
      b = new Button("Button");
      bUp = new Button("▲");
      bDown = new Button("▼");
      bLeft = new Button("◀");
      bRight = new Button("▶");
      p = new Panel();
      lb1 = new Label();
      lb2 = new Label();
      Toolkit tool = Toolkit.getDefaultToolkit();
      img = tool.getImage("C:/Users/odae/workspace/app/src/day0710/duke.jpg");
      
      p.setLayout(new GridLayout(2,3));
      p.add(lb1);
      p.add(bUp);
      p.add(lb2);
      p.add(bLeft);
      p.add(bDown);
      p.add(bRight);
      f.add(this, "Center");
      f.add(p, "South");
      //f.add(b, "South");
      
      f.setSize(500, 500);
      f.setVisible(true);

      b.addActionListener(this);
      bUp.addActionListener(this);
      bDown.addActionListener(this);
      bLeft.addActionListener(this);
      bRight.addActionListener(this);
      
      f.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      });
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getSource()==bUp) {
         y-=10;
         repaint();
         System.out.println("위");
      }else if(e.getSource()==bLeft) {
         x-=10;
         repaint();
         System.out.println("왼");
      }else if(e.getSource()==bRight) {
         x+=10;
         repaint();
         System.out.println("오른");
      }else if(e.getSource()==bDown) {
         y+=10;
         repaint();
         System.out.println("아래");
      }

   }
   
   
   /*
    * <Callback 메서드>
    *    - paint() 메서드는 임이 호출이 아니라 Canvas 생성 시 자동 호출 
    *    - repaint() 다시 paint() 호출 : repain() 호출 시 자동으로 update()를 호출해서 canvas를 지우고 paint()를 호출하는 순서로 작동
    *  - update() 지우기
    */
   @Override
   public void paint(Graphics g) {
      //g.drawRect(x, y, 10, 10); //drawRect(시작x좌표, 시작y좌표, 가로, 세로)
      //g.fillRect(x, y, 10, 10);
	   System.out.println("ggg");
      g.drawImage(img, 10, 0, 100, 100, this);
   }
   
//   @Override
//   public void update(Graphics g) {
//      //paint(g); //이렇게 하면 지우는 기능이 소멸 된다. 즉, repaint() 호출 시 update()가 호출되고 그 안에서 canvas가 지워지지 않고 paint()로 됨
//   }
   
   public static void main(String[] args) {
      new CanvasEx();
   }

}