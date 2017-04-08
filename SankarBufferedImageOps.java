package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SankarBufferedImageOps extends JPanel {

	private static BufferedImage original,darkened,inBetween,semitransparent,left,right,rot,blurry;

	private static int  rotAngle;


	public static void main(String[] args){

		JFrame frame = new JFrame();
		frame.setTitle("Pokémon!");
		frame.setSize(700, 500);
		frame.setBackground(Color.RED);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		rotAngle = Integer.parseInt(JOptionPane.showInputDialog("Enter the counterclockwise rotation angle in degrees",null));



		SankarBufferedImageOps o= new SankarBufferedImageOps();
		frame.add(o);

		frame.setVisible(true);
	}


	public SankarBufferedImageOps(){
		File chosen = null;
		JFileChooser jf = new JFileChooser();
		int result = jf.showOpenDialog(this);
		do {
			
			if (result==JFileChooser.APPROVE_OPTION){
				System.out.println(jf.getSelectedFile().getAbsolutePath());
				chosen = jf.getSelectedFile();
			}
			
		} while (chosen==null);
		try {
			original = ImageIO.read(chosen);
		} catch (IOException ex) {
			System.out.println("File not Found!");
			System.exit(0);
		}

		darkened = new BufferedImage(original.getWidth(), original.getHeight(), original.getType());
		semitransparent = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_ARGB);
		left = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_ARGB);
		right = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_ARGB);
		rot = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_ARGB);
		inBetween = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_ARGB);
	}

	public void paint(Graphics g){
		g.drawImage(original,0,0,null);//draw original image

		//rescale operation that darkens the image
		RescaleOp darker = new RescaleOp(0.7f, 0f, null);
		//the first parameter darkens the image by a factor of 0.7 and offset by 0. 
		//Rendering hints are not used so the parameter for that is set to null

		darker.filter(original,darkened);
		g.drawImage(darkened, original.getWidth(), 0, null);
		((Graphics2D)inBetween.getGraphics()).drawImage(original,null, 0,0);
		float[] t = {1,1,1,.5f};
		float[] u = {1,1,1,1};
		RescaleOp transparent = new RescaleOp(t, u, null);
		semitransparent = transparent.filter(inBetween, semitransparent);
		g.drawImage(semitransparent,0,original.getHeight(),null);
		left = original.getSubimage(0, 0, original.getWidth()/2, original.getHeight());
		right = semitransparent.getSubimage(original.getWidth()/2,0,original.getWidth()/2,original.getHeight());
		g.drawImage(left,2*original.getWidth(),0,null);
		g.drawImage(right, 5*original.getWidth()/2,0,null);

		AffineTransform slide = AffineTransform.getTranslateInstance(0,-original.getHeight()/2);
		AffineTransform cc = AffineTransform.getRotateInstance(-rotAngle*Math.PI/180,0,0);
		cc.concatenate(slide);
		AffineTransformOp a = new AffineTransformOp(cc,null);
		rot = a.filter(original,rot);
		g.drawImage(rot,0,0,null);
		float[] w = {.5f,.5f,.5f,.5f,.5f,.5f,.5f,.5f,.5f,.5f};
		Kernel k = new Kernel(3,3,w);
		ConvolveOp blur = new ConvolveOp(k);
		blur.filter(original, blurry);
		g.drawImage(blurry,650,220,null);


		//System.out.println(darkened.getType());
	}

}