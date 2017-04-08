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

/**
 * Basic Bitmap Exercises Program
 * @author Aleksander Sankar
 * Graphics Pd. 1
 * Mr. Fowler
 */
public class SankarBitmapExercises extends JPanel {

	//fields
	private BufferedImage flip;
	private BufferedImage troll;

	/**
	 * This program creates a JFrame, reads in two images, applies some effects to the images and then displays them.
	 * @param args not used
	 */
	public static void main(String [] args){
		JFrame frame = new JFrame();
		frame.setTitle("It's a flip!");
		frame.setSize(776, 580);
		frame.setBackground(Color.white);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}//end closing event
		});

		SankarBitmapExercises b= new SankarBitmapExercises();
		frame.add(b);

		frame.setVisible(true);

	}//end main

	/**
	 * This method applies the black and white filter to the BufferedImage passed in as the parameter.
	 * This is done by going through each pixel, and setting its green and blue values to the red value there.
	 * @param b the BufferedImage to be modified
	 * @return a black and white version of the image
	 */
	public BufferedImage toBlackAndWhite(BufferedImage b){
		for (int i=0; i<b.getWidth(); i++){
			for (int j=0; j<b.getHeight(); j++){
				int raw = b.getRGB(i,j);//retrieve the color of that pixel
				int part = (raw<<8)>>>24;//isolate the red
				int full = part<<16| part<<8 |part;//set the red value for both blue and green
				b.setRGB(i, j, full);//apply this color to that pixel
			}//end for loop
		}//end for loop
		return b;
	}//end toBlackAndWhite
	
	/**
	 * This method applies the "night vision" filter to the BufferedImage passed in as the parameter.
	 * This is done by going through each pixel, and setting its green value to the red value there. It sets the red and blue values to 0.
	 * Note: It's not really night vision, but it provides a green tint to the image
	 * @param b the BufferedImage used in the method
	 * @return a green-tinted version of the image
	 */
	public BufferedImage nightVision(BufferedImage b){
		for (int i=0; i<b.getWidth(); i++){
			for (int j=0; j<b.getHeight(); j++){
				int raw = b.getRGB(i,j);
				int part = (raw<<8)>>>24;
				int full = part<<8;
				b.setRGB(i, j, full);
			}//end for loop
		}//end for loop
		return b;
	}//end fake nightVision method

	/**
	 * This method is where the pictures are drawn onto the frame and the filter effects are called.
	 * @param g the Graphics object manipulated in this method
	 */
	public void paint(Graphics g){
		//read the two images
		try {
			troll = ImageIO.read(new File("troll.png"));
			flip = ImageIO.read(new File ("flip.jpg"));
		} catch (IOException ex) {
			System.out.println("File not Found!");
			System.exit(0);
		}//end catch
		
		g.drawImage(flip,200,0,null);//draw the original image
		g.drawImage(flip,getWidth()-flip.getWidth(),getHeight()-flip.getHeight(),null);//draw the image
		
		//display some information about the image
		g.drawString("Image 1 (flip):",5,30);
		String info = "Width: "+flip.getWidth()+" Height: "+flip.getHeight();
		String info2 = "Type: "+flip.getType();
		g.drawString(info,5,50);
		g.drawString(info2,5,70);
		g.drawString("Image 2 (troll):",5,130);
		
		//draw the transparent PNG onto the bottom right corner of the panel
		g.drawImage(troll,getWidth()-troll.getWidth(),getHeight()-troll.getHeight(),null);
		
		//display some information about the image
		info = "Width: "+troll.getWidth()+" Height: "+troll.getHeight();
		info2 = "Type: "+troll.getType();
		g.drawString(info,5,150);
		g.drawString(info2,5,170);

		
		flip = toBlackAndWhite(flip);//apply b&w effect
		g.drawImage(flip,200+flip.getWidth(),0,null);//draw the image
		flip = nightVision(flip);//apply "night vision" effect
		g.drawImage(flip,200,flip.getHeight(),null);//draw the image
	}//end paint
	
}//end class