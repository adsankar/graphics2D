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
public class SankarInstagram extends JPanel {

	private static BufferedImage original, filtered, lordKelvinVersionVersion,
	borderVersion, topBorder, bottomBorder, image1, image2,
	modifiedImage1, modifiedImage2;
	private static final float GRAY_FACTOR = .2f;
	private static final float BRIGHT_FACTOR = .2f;

	/**
	 * This program simulates the Instagram application by modifying a buffered
	 * image in a way that it resembles a photograph that has been processed
	 * with an Instagram fiilter. A frame is created with the images, both
	 * filtered and unfiltered, and then displayed on the screen.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {

		// create the frame
		JFrame myFrame = new JFrame();
		myFrame.setTitle("Instagram");
		myFrame.setSize(1200, 800);
		myFrame.setBackground(Color.white);
		myFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}// end window closing event
		});// end process of closing the frame using the x button

		SankarInstagram s = new SankarInstagram();// create the instagram object
		myFrame.add(s);// add the object to the frame

		myFrame.setVisible(true);// display the frame
	}// end main

	/**
	 * The constructor for the Instagram object. It reads in all of the
	 * necessary files and then applies the filter to the images.
	 */
	public SankarInstagram() {
		// read in all of the necessary files
		try {
			original = ImageIO.read(new File("tree.png"));
			filtered = ImageIO.read(new File("filteredTree.png"));
			image1 = ImageIO.read(new File("box.png"));
			image2 = ImageIO.read(new File("flower.jpg"));
		} catch (IOException ex) {// case if the compiler doesn't locate the required file
			System.out.println("File not Found!");
			System.exit(0);// exit program if file is not found
		}// end try-catch statement

		// apply the filters to the images
		// first it applies the filter Lord Kelvin and then adds the border to each picture
		lordKelvinVersionVersion = toLordKelvin(original);
		borderVersion = addBorder(lordKelvinVersionVersion);
		modifiedImage1 = toLordKelvin(image1);
		modifiedImage1 = addBorder(modifiedImage1);
		modifiedImage2 = toLordKelvin(image2);
		modifiedImage2 = addBorder(modifiedImage2);
	}// end constructor

	/**
	 * This method paints the objects onto the canvas along with some labels.
	 * @param g the Graphics object drawn on
	 */
	public void paint(Graphics g) {
		int heightCount = 0;
		g.setColor(Color.black);
		g.drawImage(original, 0, 0, null);// draw the original image

		// display comments explaining the positioning of the pictures and where filters are applied
		Font myFont = new Font("Verdana", Font.PLAIN, 20);// create a larger, more readable font
		g.setFont(myFont);
		g.drawString("Before (top left)", original.getWidth() + 20,
				original.getHeight() + 30);
		g.drawString("After (top right)", original.getWidth() + 20,
				original.getHeight() + 70);
		g.drawString("My Filter (bottom left)", original.getWidth() + 20,
				original.getHeight() + 110);
		// draw the image of what the filter is supposed to look like
		g.drawImage(filtered, original.getWidth(), 0, null);
		heightCount += original.getHeight();
		g.drawImage(borderVersion, 0, heightCount, null);// draw the filtered image
		heightCount += original.getHeight();

		// draw the other two images, before and after the filter is applied
		g.drawImage(image1, 0, heightCount, null);
		g.drawImage(modifiedImage1, image1.getWidth(), heightCount, null);
		heightCount += image1.getHeight();
		g.drawImage(image2, 2 * original.getWidth(), 0, null);
		g.drawImage(modifiedImage2,
				2 * original.getWidth() + image2.getWidth(), 0, null);
	}// end paint

	/**
	 * Applies the Lord Kelvin filter to the image by modifying the RGB values
	 * using RescaleOp and then changing the saturation and brightness.
	 * @param b the image being processed
	 * @return s another image with the filter applied to it
	 */
	public BufferedImage toLordKelvin(BufferedImage b) {
		// create a new image where the filtered image will be stored
		BufferedImage finalImage = new BufferedImage(b.getWidth(),
				b.getHeight(), b.getType());

		// arrays containing the floats that modify the color
		float[] scalings = { 1.15f, .5f, .1f };
		float[] constants = { 1f, 1f, 1f };

		// create the RescaleOp
		RescaleOp recolor = new RescaleOp(scalings, constants, null);
		// apply the RescaleOp
		finalImage = recolor.filter(b, finalImage);
		int pixelCount = 0;

		// array to store all of the HSB values for each pixel
		float[][] HSBValues = new float[b.getWidth() * b.getHeight()][3];

		// nested for loops to access each pixel and modify each color
		for (int i = 0; i < b.getWidth(); i++) {// loop through image horizontally
			for (int j = 0; j < b.getHeight(); j++) {// loop through image vertically
				Color c = new Color(finalImage.getRGB(i, j));// retrieve color at that pixel
				HSBValues[pixelCount] = Color.RGBtoHSB(c.getRed(),
						c.getGreen(), c.getBlue(), null);// obtain the HSB values
				HSBValues[pixelCount][1] -= GRAY_FACTOR; // decrease the saturation
				HSBValues[pixelCount][2] += BRIGHT_FACTOR; // increase the brightness

				// keep the HSB values within bounds
				if (HSBValues[pixelCount][2] > 1)
					HSBValues[pixelCount][2] = 1;
				if (HSBValues[pixelCount][2] < 0)
					HSBValues[pixelCount][2] = 0;
				// set the color to the modified one
				finalImage.setRGB(
						i,
						j,
						Color.getHSBColor(HSBValues[pixelCount][0],
								HSBValues[pixelCount][1],
								HSBValues[pixelCount][2]).getRGB());
				pixelCount++;
			}// end for
		}// end for
		return finalImage;
	}// end toLordKelvin

	/**
	 * Adds a border to the image by drawing one image on top of the original.
	 * @param b the image being processed
	 * @return another image with the border around it.
	 */
	public BufferedImage addBorder(BufferedImage b) {
		// create image for the modified image to be stored
		BufferedImage withBorder = b;
		try {// read in the border images
			topBorder = ImageIO.read(new File("topBorder.png"));
			bottomBorder = ImageIO.read(new File("bottomBorder.png"));
		} catch (IOException ex) {
			System.out.println("File not Found!");
			System.exit(0);
		}// end try-catch

		// draw the border on top of the original image
		Graphics2D g = (Graphics2D) withBorder.getGraphics();
		// loop and draw the border until the border width equals the image width
		int repeat = 0;
		while (repeat < b.getWidth()) {
			g.drawImage(topBorder, repeat, 0, null);// draw border at the top
			g.drawImage(bottomBorder, repeat,
					b.getHeight() - bottomBorder.getHeight(), null);// draw the border at the bottom
			repeat += topBorder.getWidth();
		}// end while
		return withBorder;
	}// end addBorder

}// end class