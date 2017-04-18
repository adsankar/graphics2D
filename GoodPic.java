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
	    frame.setTitle("This is a flag:");
	    frame.setSize(300, 270);
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
      String iName="bahrainflag.jpg";
    	try {        
    	   //TODO find filepath name
    	 //edit here according to filepath and filename
          image = ImageIO.read(new File(iName));
       } catch (IOException ex) {
           System.out.println("File not found!"); 
    	   System.exit(0);
       }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, null);    
        System.out.println(image.getType());
        System.out.println("Type: "+image.getType()+" Height: "+image.getHeight()+" Width: "+image.getWidth());
        //g.drawString("U mad bro?", 120, 200);
      //  System.out.println(BufferedImage.;
    }

}
