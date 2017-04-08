package graphics;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class SankarLayoutExercises {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{	
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());	
		}
		catch(Exception ex){
			System.out.println("Couldn't set Look & Feel");
		}
		JFrame jf = new JFrame("I'm a JFrame");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = jf.getContentPane();
		JPanel panel = new	JPanel();
		JPanel panel2 = new JPanel();
		
		//pane.setPreferredSize(new Dimension(300,200));
		JButton tab1 = new JButton("tab1");
		tab1.setMaximumSize(new Dimension(40,20));
		JButton tab2 = new JButton("tab2");
		tab2.setMaximumSize(new Dimension(40,20));
		JButton tab3 = new JButton("tab3");
		JButton tab4 = new JButton("tab4");
		JButton back = new JButton("<-");
		JButton forward = new JButton("->");
		JButton refresh = new JButton("(refresh)");
		
		JFormattedTextField addressBar = new JFormattedTextField();
		addressBar.setMinimumSize(new Dimension(Integer.MAX_VALUE, 30));
		//addressBar.setMaximumSize(new Dimension(30, Integer.MAX_VALUE));
				//,"dannyfowler.com");
		//FlowLayout row1 = new FlowLayout(FlowLayout.LEFT);
		pane.setLayout(new GridLayout(2,4,10,10));
		panel.setLayout(new GridLayout(1,4, 20, 10)); 
		panel2.setLayout(new BoxLayout(panel2,BoxLayout.X_AXIS));
		pane.setLayout(new GridLayout(1,2,10,80));
		panel.add(tab1);
		panel.add(tab2);
		panel.add(tab3);
		panel.add(tab4);
		panel2.add(back);
		panel2.add(forward);
		panel2.add(refresh);
		panel2.add(addressBar);
		pane.add(panel);
		pane.add(panel2);
		//pane.add(new JLabel("TROLOLOL")); //#doit
		//pane.add(new JLabel("TRollolrorlro"));
		/*Container pane2 = jf.getContentPane();
		pane2.setLocation(0, 70);
		pane.setLayout(new FlowLayout(FlowLayout.LEFT));
		pane2.add(forward);
		pane2.add(refresh);
		/*pane.add(back);
		pane.add(forward);
		pane.add(refresh);*/
		jf.setSize(300, 200);
		jf.setContentPane(panel);
		jf.pack();
		jf.setVisible(true);
		
		
	}
	
}
/* Questions
 * 1.	How do you make the buttons stretch across the width of the panel

Set the maximum size of the button to Integer.MAX_VALUE.

2.	How could you prevent the text in the buttons from being truncated

You could set the minimum size of the button to a dimension that completely fits the word.

3.	What does setting the button's Y alignment do

It makes the button either aligned to the top, center, or bottom of the component.

4.	How could you make the two buttons appear in the center of the space

Set the x alignment and the y alignment to the center (component size/2).

5.	Summarize the rules for sizing components within a box layout.Java2D.

You can set them to a preferred size, like a default size, but then resizable. You could also set the minimum size or the maximum size, putting a one-way constraint on the component. Use both of these constraints to make a static sized component.

 */
