package graphics;

import java.awt.Canvas;
import java.awt.Color;

import javax.swing.JPanel;

public class TestCanvas extends JPanel{

	public static void main(String[] args){
		JPanel myFrame = new JPanel();
		myFrame.setBackground(Color.black);
		Canvas c = new CircleClicker();
		myFrame.add(c);
		myFrame.setSize(800,800);
		myFrame.setName("This is the clicker");
		myFrame.setVisible(true);
	}
	
}
