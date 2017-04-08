package graphics;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GoodPic extends JPanel{

    private BufferedImage image;

    public static void main(String [] args){
    	JFrame frame = new JFrame();
	    frame.setTitle("This is a Troll:");
	    frame.setSize(300, 250);
	    frame.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	        System.exit(0);
	      }
	    });
	    Container contentPane = frame.getContentPane();
	    contentPane.add(new GoodPic());
	 
	    frame.setVisible(true);
	    
    }
    
    public GoodPic() {
       try {                
    	 //edit here according to filepath and filename
          image = ImageIO.read(new File("C:/Users/Aleksander/Pictures/Misc Pics/Trollface.png"));
       } catch (IOException ex) {
            System.exit(0);
       }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);    
        g.drawString("U mad bro?", 120, 200);
    }

}
