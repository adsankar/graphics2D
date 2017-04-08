package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RotateImage extends JPanel {

	private BufferedImage flip;
	private BufferedImage rotated;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("It's a flip!");
		frame.setSize(700, 500);
		frame.setBackground(Color.white);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	
		RotateImage r= new RotateImage();
		frame.add(r);

		frame.setVisible(true);

	}
	
	public void paint(Graphics g){
		try {
			flip = ImageIO.read(new File ("flip.jpg"));
			rotated = new BufferedImage(flip.getHeight(),flip.getWidth(),1);
		} catch (IOException ex) {
			System.out.println("File not Found!");
			System.exit(0);
		}
		
		g.drawImage(flip,flip.getWidth(),0,null);
		for (int i=1; i< flip.getHeight(); i++){
			for (int j=1; j<flip.getWidth(); j++){
				int color = flip.getRGB(j, i);
				rotated.setRGB(i,flip.getWidth()-j,color);
			}
		}
		g.drawImage(rotated,0,0,null);
	}
}
