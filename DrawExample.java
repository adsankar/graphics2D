package graphics;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DrawExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame myFrame = new Frame();
		myFrame.setSize(500,400);
		SankarBasicAWT c = new SankarBasicAWT();
		myFrame.add(c);
		myFrame.setVisible(true);
		myFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}//end windowClosing event
		});

	}

}
