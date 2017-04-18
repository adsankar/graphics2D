package graphics;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class DrawRect extends JPanel {
  /**
	 * 
	 */

public void paintComponent(Graphics g1) {
//   Graphics2D g = (Graphics2D) g1;
//   GradientPaint gr = new GradientPaint(0, 0, Color.red, 100, 100, Color.green);
   // fill here Rectangle2D()
  }
 
public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setTitle("DrawRect");
    frame.setSize(300, 200);
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    Container contentPane = frame.getContentPane();
    contentPane.add(new DrawRect());
 
    frame.setVisible(true);
    
  }
}

