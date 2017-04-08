package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SankarBufferedImageOps2 extends JPanel {

	private BufferedImage c,dest;
	
	public static void main(String[]args){
		JFrame frame = new JFrame();
		frame.setTitle("Pokémon!");
		frame.setSize(700, 500);
		frame.setBackground(Color.white);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	//	File chosen = null;

		SankarBufferedImageOps2 o= new SankarBufferedImageOps2();
		frame.add(o);

		frame.setVisible(true);
	}
	public SankarBufferedImageOps2(){
		try {
			c = ImageIO.read(new File ("charmeleon.jpg"));
		} catch (IOException ex) {
			System.out.println("File not Found!");
			System.exit(0);
		}
		dest = new BufferedImage(c.getWidth(), c.getHeight(), BufferedImage.TYPE_INT_ARGB);
		c =dest;
		float[] t = {1,1,1,.5f};
		float[] u = {1,1,1,1};
		RescaleOp transparent = new RescaleOp(t, u, null);
		 dest = transparent.filter(c, dest);

	}

	public void paint(Graphics g){
		
		
		g.setColor(Color.RED);
		g.fillRect(0,0,getWidth(),getHeight());
		
		//TODO display the left half of the original image next to the right half of the filtered image.
		
		g.drawImage(c,0,0,null);//draw original image
		
		//rescale operation that changes the transparency of image
		
		//Rendering hints are not used so the parameter for that is set to null
		
		//((Graphics2D)c.getGraphics()).drawImage(c,transparent,c.getWidth(),0);
		g.drawImage(dest, c.getWidth(), 0, null);
	}
	
}
