package day0707;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Interface 'AdjustmentListener'(조정리스너)를 쓰는 이유 : Scrollbar 이벤트 때문이다.
 */
public class AWTExercise extends Frame implements AdjustmentListener, ActionListener {
   
   public Panel p1, p2, p3, p4;
   public Scrollbar sb_R, sb_G, sb_B;
   public Label lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10, lb11, lb12, lb13;
   public TextField tf, tfr, tfg, tfb;
   public TextArea ta;
   public Button btnReset, btnMax, btnOk;
   
   public AWTExercise() {
      super("재미있는 스크롤바");

      p1 = new Panel();
      p2 = new Panel();
      p3 = new Panel();
      p4 = new Panel();
      sb_R = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 265);
      sb_G = new Scrollbar(0, 0, 10, 0, 265);
      sb_B = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 265);
      lb1 = new Label("");
      lb2 = new Label("R : 0                                                              255");
      lb3 = new Label("G : 0                                                              255");
      lb4 = new Label("B : 0                                                              255");
      lb5 = new Label("현재 색상");
      lb6 = new Label("");
      lb7 = new Label("");
      lb8 = new Label("");
      lb9 = new Label("");
      lb10 = new Label("");
      lb11 = new Label("R");
      lb12 = new Label("G");
      lb13 = new Label("B");
      tf = new TextField(" R : 255  G: 255  B : 255");
      tfr = new TextField("");
      tfg = new TextField("");
      tfb = new TextField("");
      ta = new TextArea(" ", 5, 5, 1);
      ta.setBackground(Color.BLACK);

      btnReset = new Button("최저");
      btnMax = new Button("최대");
      btnOk = new Button("변경");
      
      setLayout(new GridLayout(1, 2));
      p1.setLayout(new GridLayout(11, 1));
      p2.setLayout(new BorderLayout());
      p3.setLayout(new GridLayout(1, 2));
      
      p1.add(lb1);
      p1.add(sb_R);
      p1.add(lb2);
      p1.add(sb_G);
      p1.add(lb3);
      p1.add(sb_B);
      p1.add(lb4);
      p1.add(lb5);
      p1.add(tf);
      p4.add(lb11);
      p4.add(tfr);
      p4.add(lb12);
      p4.add(tfg);
      p4.add(lb13);
      p4.add(tfb);
      p4.add(btnOk);
      p1.add(p4);
      p3.add(btnReset);
      p3.add(btnMax);
      p1.add(p3);
      p2.add(ta, BorderLayout.CENTER);
      p2.add(lb7, BorderLayout.NORTH);
      p2.add(lb8, BorderLayout.WEST);
      p2.add(lb9, BorderLayout.EAST);
      p2.add(lb10, BorderLayout.SOUTH);
      add(p1);
      add(p2);

      sb_R.addAdjustmentListener(this);
      sb_G.addAdjustmentListener(this);
      sb_B.addAdjustmentListener(this);
      btnReset.addActionListener(this);
      btnMax.addActionListener(this);
      btnOk.addActionListener(this);
      
      setSize(500, 400);
      setVisible(true);
      setLocation(1000,  300);
      
      addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      });

   }

   @Override
   public void adjustmentValueChanged(AdjustmentEvent e) {
      int r = sb_R.getValue();
      int g = sb_G.getValue();
      int b = sb_B.getValue();
      Color c = new Color(r, g, b);
      tf.setText(" R : " + r + ",  G : " + g + ",  B : " + b);
      ta.setBackground(c);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if(((Button)e.getSource())==btnReset) {
         tf.setText(" R : 0,  G: 0,  B : 0");
         sb_R.setValue(0);
         sb_G.setValue(0);
         sb_B.setValue(0);
         ta.setBackground(Color.BLACK);
      }else if(((Button)e.getSource())==btnMax) {
         tf.setText(" R : 255,  G: 255,  B : 255");
         sb_R.setValue(265);
         sb_G.setValue(265);
         sb_B.setValue(265);
         ta.setBackground(Color.WHITE);
      }else {
         sb_R.setValue(Integer.parseInt(tfr.getText()));
         sb_G.setValue(Integer.parseInt(tfg.getText()));
         sb_B.setValue(Integer.parseInt(tfb.getText()));
         tf.setText(" R : " + Integer.parseInt(tfr.getText()) + ",  G : " + Integer.parseInt(tfg.getText()) + ",  B : " + Integer.parseInt(tfb.getText()));
         Color c = new Color(Integer.parseInt(tfr.getText()), Integer.parseInt(tfg.getText()), Integer.parseInt(tfb.getText()));
         ta.setBackground(c);
      }
   }
   
   public static void main(String[] args) {
      new AWTExercise();
   }

}