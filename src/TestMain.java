
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestMain extends Canvas implements ActionListener, MouseMotionListener, MouseListener {
   
   JFrame frame;
   Image imgBackground;
   Image img;
   Toolkit toolkit;
   JPanel jp,jp2;
   JButton jb;
   int destx,desty;
   int charx,chary;
   int direct = 0; //0:x왼,y고정    1:x고정,y감소   2:x증가,y고정   3:x고정,y증가
   
   Image img_buffer;
   Graphics buffer;
   
   TestMain(){

      charx=720;
      chary=720;

      
      
      destx=800;
      desty=750;

      frame = new JFrame("Modu Marble");
      jp = new JPanel();
      jp2 = new JPanel();
      jb = new JButton("이동");
      jb.addActionListener(this);
      
      toolkit = Toolkit.getDefaultToolkit();
      jp2.setBackground(Color.black);
      jp.setBackground(Color.pink);
      
      this.setBounds(0, 0, 900, 900);
      jp.setBounds(900,0, 400, 900);
      
      imgBackground = toolkit.getImage("C:/Users/odae/workspace/ModuMarble/imgBackground.png");
      img = toolkit.getImage("C:/Users/odae/workspace/app/src/day0710/duke.jpg");
      jp.add(jb);
      
      frame.add(this);
      frame.add(jp);
      frame.add(jp2);
      frame.setSize(1300, 900);
      frame.setVisible(true);
      frame.setResizable(false);
      
      frame.setLocation(250, 100);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      addMouseMotionListener(this);
      addMouseListener(this);
   }
   
   @Override
   public void paint(Graphics g) {
            
      img_buffer = createImage(this.getWidth(), this.getHeight());
      buffer = img_buffer.getGraphics();      
      
      buffer.drawImage(img, charx, chary, this);
      
      g.drawImage(imgBackground, 10, 10, this);
      g.drawImage(img, charx, chary, this);
//      g.drawImage(img_buffer, x, y, this);

      
   }

   public void update(Graphics g) {
      paint(g);
   }
   

   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getSource()==jb) {
            xgo.start();
      }
   }
   
   Thread xgo = new Thread(new Runnable() {
       public void run() {
       
       while(true){
    	   switch (direct) {
			case 0: // x감소, y고정
				if(charx==0){
					
				}
				break;
			case 1: // x고정, y감소
					
				break;
			case 2: // x증가, y고정
				
				break;	
				
			default: //x고정, y증가
				break;
			}
    	   
       }
    	   
    	   
        
          
	
       }
    });
   @Override
   public void mouseClicked(MouseEvent e) {
      System.out.println("X : "+e.getX()+", Y : "+e.getY());
      this.destx = e.getX();
      this.desty = e.getY();
   }

   @Override
   public void mousePressed(MouseEvent e) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void mouseReleased(MouseEvent e) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void mouseEntered(MouseEvent e) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void mouseExited(MouseEvent e) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void mouseDragged(MouseEvent e) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void mouseMoved(MouseEvent e) {
      // TODO Auto-generated method stub
      
   }

   
   public static void main(String[] args) {
      new TestMain();
   }
   
   
}