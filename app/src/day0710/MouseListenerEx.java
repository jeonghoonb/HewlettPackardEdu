package day0710;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseListenerEx extends Canvas implements MouseMotionListener {

   public JFrame f;
   public JTextField tf;
   public int x;
   public int y;
   public JButton b;
   public JButton b2;

   public MouseListenerEx() {
      b = new JButton("버 튼(Swing)");
      b2 = new JButton("버 튼(Awt)");
      f = new JFrame();
      tf = new JTextField();

      f.add(new JLabel("마우스를 움직이고 Drag 해보세요."), BorderLayout.NORTH);
      f.add(this, "Center");
      f.add(b, "East");
      f.add(b2, "West");
      f.add(tf, "South");
      
      f.setSize(500, 500);
      f.setVisible(true);
      
      addMouseMotionListener(this);

      f.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      });
   }

   @Override
   public void paint(Graphics g) {
      g.drawString("안녕하세요", this.x, this.y);
   }

   public void setA(int x, int y) {
      this.x = x;
      this.y = y;
   }

   @Override
   public void mouseDragged(MouseEvent me) {
      tf.setText("마우스 끌리는 소리 : 끼기기긱..........");
   }

   @Override
   public void mouseMoved(MouseEvent me) {
      tf.setText("현재 마우스 좌표 : " + me.getX() + " , " + me.getY());
      setA(me.getX(), me.getY());
      this.repaint();
   }
   
   public static void main(String[] args) {
      new MouseListenerEx();
   }
}