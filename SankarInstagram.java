package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Instagram Program
 * @author Aleksander Sankar
 * Graphics Pd. 1
 * Mr. Fowler
 */
public class SankarInstagram extends JPanel{

	private static BufferedImage original, filtered, sutroVersion, borderVersion, topBorder, bottomBorder,image1,image2,image3,modifiedImage1,modifiedImage2,modifiedImage3,imgc,imgc1;
	private static final float GRAY_FACTOR =.4f;
//	private static final float BRIGHT_FACTOR =.1f;

	/**
	 * This program . .. 
	 * @param args not used
	 */
	public static void main(String[] args) {
		// TODO add file chooser, do the other filters, make all filters work, show original, refactor
		JFrame myFrame = new JFrame();
		myFrame.setTitle("Instagram");
		myFrame.setSize(1200, 800);
		myFrame.setBackground(Color.white);
		myFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});




		SankarInstagram s = new SankarInstagram();
		myFrame.add(s); 

		myFrame.setVisible(true);
	}

	/**
	 * The constructor for the Instagram object. 
	 * It reads in all of the necessary files and then applies the filter to the images.
	 */
	public SankarInstagram(){
		try {
			original = ImageIO.read(new File ("tree.png"));
			filtered = ImageIO.read(new File("filteredTree.png"));
			image1 = ImageIO.read(new File("box.png"));
			image2 = ImageIO.read(new File("flower.png"));
			image3 = ImageIO.read(new File("giraffe.png"));
		} catch (IOException ex) {
			System.out.println("File not Found!");
			System.exit(0);
		}
		sutroVersion = toSutro(original);
		borderVersion = addBorder(sutroVersion);

		modifiedImage1 = toSutro(image1);
		modifiedImage1 = addBorder(modifiedImage1);
		
		modifiedImage2 = toSutro(image2);
		modifiedImage2 = addBorder(modifiedImage2);
		
		modifiedImage3 = toSutro(image3);
		modifiedImage3 = addBorder(modifiedImage3);
		
	}

	/**
	 * This method paints the objects onto the canvas along with some labels. 
	 * @param g the Graphics object drawn on
	 */
	public void paint(Graphics g){
		int heightCount =0;
		g.setColor(Color.black);
		g.drawImage(original,0,0,null);
		Font myFont = new Font("Verdana", Font.PLAIN, 20);
		g.setFont(myFont);
		g.drawString("Before (top left)",3*original.getWidth()/2,original.getHeight()+30);
		g.drawString("After (top right)",3*original.getWidth()/2,original.getHeight()+70);
		g.drawString("My Filter (bottom left)",3*original.getWidth()/2,original.getHeight()+110);
		g.drawImage(filtered,original.getWidth(),0,null);
		heightCount+=original.getHeight();
		g.drawImage(borderVersion,0,heightCount,null);
		heightCount+=original.getHeight();
		g.drawImage(image1,0,heightCount,null);
		g.drawImage(modifiedImage1,image1.getWidth(),heightCount,null);
		heightCount+=image1.getHeight();
		g.drawImage(image2,0,heightCount,null);
		g.drawImage(modifiedImage2,image2.getWidth(),heightCount,null);
		heightCount+=image2.getHeight();
		g.drawImage(image3,0,heightCount,null);
		g.drawImage(modifiedImage3,image3.getWidth(),heightCount,null);
	}

	/**
	 * Applies the sutro filter to the image by modifying the RGB values using RescaleOp and then changing the saturation.
	 * @param b the image being processed
	 * @return s another image with the filter applied to it
	 */
	public BufferedImage toSutro(BufferedImage b){
		BufferedImage s = new BufferedImage(b.getWidth(), b.getHeight(), b.getType());
		BufferedImage mid = new BufferedImage(b.getWidth(), b.getHeight(), b.getType());
		float[] scalings = {1.3f,.4f,.6f};
		float[] constants = {1.1f,1.1f,1.1f};
		RescaleOp mod = new RescaleOp(scalings, constants, null);
		mid= mod.filter(b,mid);
		int pixelCount =0;
		float[][] HSBValues = new float[b.getWidth()*b.getHeight()][3];
		for (int i=0; i<b.getWidth(); i++){
			for (int j= 0; j<b.getHeight(); j++){
				Color c = new Color(mid.getRGB(i,j));
				HSBValues[pixelCount] = Color.RGBtoHSB(c.getRed(),c.getGreen(),c.getBlue(),null);
				HSBValues[pixelCount][1] -= GRAY_FACTOR;
				//HSBValues[pixelCount][2] += BRIGHT_FACTOR;
				if(HSBValues[pixelCount][2]>1) HSBValues[pixelCount][2] =1;
				s.setRGB(i, j, Color.getHSBColor(HSBValues[pixelCount][0],HSBValues[pixelCount][1],HSBValues[pixelCount][2]).getRGB());
				pixelCount++;
			}
		}//end for
		return s;
	}//end toSutro

	/**
	 * Adds a border to the image by drawing one image on top of the original.
	 * @param b the image being processed
	 * @return another image with the border around it. 
	 */
	public BufferedImage addBorder(BufferedImage b){
		BufferedImage withBorder = b;
		try {
			topBorder = ImageIO.read(new File ("topBorder.png"));
			bottomBorder = ImageIO.read(new File ("bottomBorder.png"));
		} catch (IOException ex) {
			System.out.println("File not Found!");
			System.exit(0);
		}
		Graphics2D g = (Graphics2D) withBorder.getGraphics();
		int repeat =0;
		while (repeat<b.getWidth()){
			g.drawImage(topBorder,repeat,0,null);
			g.drawImage(bottomBorder,repeat,b.getHeight()-bottomBorder.getHeight(),null);
			repeat += b.getWidth();
		}//end while
		return withBorder;
	}//end addBorder

}//end class