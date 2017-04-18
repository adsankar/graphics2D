package graphics;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class TestJFrame {
	private static boolean shrooms;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame jf = new JFrame("I'm a JFrame");
		Container pane = jf.getContentPane();
		FlowLayout myLayout = new FlowLayout(FlowLayout.CENTER);
		myLayout.setHgap(20);
		jf.setLayout(myLayout);
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton butt = new JButton("You want some mushrooms?");
		JLabel jlabel = new JLabel("I\'m a string");
		ActionListener al = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("Trippy restarted.");
				shrooms = true;
			}
		};
		butt.addActionListener(al);
		//UIManager.setLookAndFeel()
		pane.add(jlabel);
		pane.add(butt);
		
		jf.add(jlabel);
		if (shrooms) pane.add(new PursuitOct());
		jf.pack();
		jf.setVisible(true);
	}

}
