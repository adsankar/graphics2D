package graphics;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;


public class SankarJFrameExercises extends JFrame {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{	
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());	
		}
		catch(Exception ex){
			System.out.println("Couldn't set L&F");
		}	
		JFrame jf = new JFrame("I'm a JFrame");
		Container pane = jf.getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.LINE_AXIS));
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton top = new JButton("TOP");
		JButton bottom = new JButton("BOTTOM");
		ActionListener topClick = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("The top button was pressed.");

			}
		};
		
		KeyListener shortcut = new KeyListener(){
			public void keyTyped(KeyEvent e) {
								
			}

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyChar()=='t') System.out.println("The top button was pressed.");
				if (e.getKeyChar()== 'b') System.out.println("The bottom button was pressed.");
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		
		ActionListener bottomClick = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("The bottom button was pressed.");

			}
		};
		top.addKeyListener(shortcut);
		top.addActionListener(topClick);
		bottom.addActionListener(bottomClick);
		//TODO fix here
		JLabel message = new JLabel("Swing Components are like AWT 1.1");
		top.setBackground(Color.green);
		bottom.setForeground(Color.white);
		bottom.setBackground(Color.blue);
		pane.add(top);
		
		pane.add(message);
	
		pane.add(bottom);

		jf.pack();
		jf.setVisible(true);

	}

}
