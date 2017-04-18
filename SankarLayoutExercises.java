package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 * Fake Web Browser Layout Exercises
 * @author Aleksander Sankar
 * Graphics Pd. 1
 */
public class SankarLayoutExercises extends Component{
	/*
	 * Notes on Layouts:
	 * BoxLayout: arranges the components in the container lengthwise or vertically
	 * GridLayout: splits container into cells, with specified gaps, and assigns components in order
	 * BorderLayout: five regions (north, south, east, west, and center)
	 * FlowLayout: Arranges the components along the "flow" of the page; horizontal, then wraps
	 */
	

	private static Icon forwardButton;
	private static Icon backButton;
	private static Icon refreshButton;
	private static int size;
	private static FocusListener myFocusListener;
	private static MouseListener myMouseListener;

	/**
	 * Initialize, set the look and feel to one that doesn't have cross-platform issues, and displays the final frame.
	 * @param args not used
	 */
	public static void main(String[] args) {


		new SankarLayoutExercises();//call the constructor

		//set the look and feel
		try{	
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());	
		}//end try
		catch(Exception ex){
			System.out.println("Couldn't set Look & Feel");
		}//end catch

		//set the title
		JFrame jf = new JFrame("Fake Web Browser - Layout Exercises");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//closes when X is clicked

		//the container that holds everything
		Container pane = jf.getContentPane();

		//create some JPanels
		JPanel panel = new	JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();

		JPanel blankSpace = new JPanel();//one blank panel
		blankSpace.setPreferredSize(new Dimension(500,400));
		Dimension d = new Dimension(200,30);

		//initialize some JButtons
		JButton tab1 = new JButton("tab 1");
		JButton tab2 = new JButton("tab 2");
		JButton tab3 = new JButton("tab 3");
		JButton tab4 = new JButton("tab 4");

		//set the names of the tabs
		tab1.setName("tab 1");
		tab2.setName("tab 2");
		tab3.setName("tab 3");
		tab4.setName("tab 4");

		//give the tabs the same maximum size
		tab1.setMaximumSize(d);
		tab2.setMaximumSize(d);
		tab3.setMaximumSize(d);
		tab4.setMaximumSize(d);


		//add mouse and focus listeners to all of the tabs
		tab1.addFocusListener(myFocusListener);
		tab2.addFocusListener(myFocusListener);
		tab3.addFocusListener(myFocusListener);
		tab4.addFocusListener(myFocusListener);
		tab1.addMouseListener(myMouseListener);
		tab2.addMouseListener(myMouseListener);
		tab3.addMouseListener(myMouseListener);
		tab4.addMouseListener(myMouseListener);

		Dimension d3 = new Dimension(50,30);

		//make some more buttons
		JButton back = new JButton(backButton);
		JButton forward = new JButton(forwardButton);
		JButton refresh = new JButton(refreshButton);

		//set the button names
		back.setName("back button");
		forward.setName("forward button");
		refresh.setName("refresh button");

		//set the max size to the same dimension
		back.setMinimumSize(d3);
		forward.setMinimumSize(d3);
		refresh.setMinimumSize(d3);

		//create a dimension using font metrics
		Dimension d2 = new Dimension(size,30);
		//make more buttons
		JButton favorite1 = new JButton("Favorite 1");
		JButton favorite2 = new JButton("Favorite 2");
		JButton favorite3 = new JButton("Favorite 3");

		//set the names of the buttons
		favorite1.setName("favorite 1");
		favorite2.setName("favorite 2");
		favorite3.setName("favorite 3");

		//set the minimum size of the buttons
		favorite1.setMinimumSize(d2);
		favorite2.setMinimumSize(d2);
		favorite3.setMinimumSize(d2);

		//add mouse and focus listeners to all of the favorites
		favorite1.addFocusListener(myFocusListener);
		favorite2.addFocusListener(myFocusListener);
		favorite3.addFocusListener(myFocusListener);
		favorite1.addMouseListener(myMouseListener);
		favorite2.addMouseListener(myMouseListener);
		favorite3.addMouseListener(myMouseListener);

		//create the address bar and size it so that it takes up the space of the whole window
		JFormattedTextField addressBar = new JFormattedTextField();
		addressBar.setMaximumSize(new Dimension(Integer.MAX_VALUE-5, 40));


		//row 1
		panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
		//add tabs the the first row
		panel.add(tab1);
		panel.add(tab2);
		panel.add(tab3);
		panel.add(tab4);
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);//align to the left

		//row 2
		panel2.setLayout(new BoxLayout(panel2,BoxLayout.X_AXIS));
		//add the buttons on the second row
		panel2.add(back);
		panel2.add(forward);
		panel2.add(refresh);
		panel2.add(addressBar);
		panel2.setAlignmentX(Component.LEFT_ALIGNMENT);//align to the left

		//row 3
		panel3.setLayout(new BoxLayout(panel3,BoxLayout.X_AXIS));
		panel3.add(favorite1);
		panel3.add(favorite2);
		panel3.add(favorite3);
		panel3.setAlignmentX(Component.LEFT_ALIGNMENT);//align to the left


		//add all the panes in separate rows
		JPanel top = new JPanel();
		top.setLayout(new BorderLayout(0,0));
		pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));
		pane.add(panel);
		pane.add(panel2);
		pane.add(panel3);
		pane.add(blankSpace);
		top.add(pane,BorderLayout.NORTH);//align to the top of the panel

		jf.setContentPane(top);
		jf.pack();
		jf.setVisible(true);//show the panel


	}
	/**
	 * Constructor that initializes the listeners, finds font sizes, and reads in the images for the icons.
	 */
	public SankarLayoutExercises() {
		super();
		myFocusListener = new FocusListener() {//displays message of which button is clicked

			public void focusLost(FocusEvent e) {
				System.out.println(((JComponent) e.getSource()).getName()+" lost focus");

			}
			public void focusGained(FocusEvent e) {
				System.out.println(((JComponent) e.getSource()).getName()+" gained focus");
			}
		};
		myMouseListener = new MouseListener() {//change color when button is moused over
			

			public void mouseClicked(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}

			//revert to original color
			public void mouseExited(MouseEvent e) {
				((JButton)e.getSource()).setBackground(getBackground());
			}

			//change to green
			public void mouseEntered(MouseEvent e) {
				((JButton)e.getSource()).setBackground(Color.GREEN);
			}
		};


		Font myFont = new Font("Verdana",Font.PLAIN,11);
		size = getFontMetrics(myFont).stringWidth("Favorite  ");//find the size for the favorites tabs

		//read in the icons
		try {
			readIcons();
		} catch (IOException e) {
			System.out.println("Icons not set!");
			e.printStackTrace();
		}
	}

	public void readIcons() throws IOException {
		Image temp1 = null;
		Image temp2 = null;
		Image temp3 = null;
		//read in the files
		try {
			temp1 = ImageIO.read(new File("pics/rightArrow.png"));
			temp2 = ImageIO.read(new File("pics/refresh.png"));
			temp3 = ImageIO.read(new File("pics/leftArrow.png"));
		}

		catch (FileNotFoundException e) {
			System.out.println("The file was not found!");
		}
		//change to icons, resize appropriately
		forwardButton = new ImageIcon(temp1.getScaledInstance(40, 30,
				java.awt.Image.SCALE_SMOOTH));
		refreshButton = new ImageIcon(temp2.getScaledInstance(40, 30,
				java.awt.Image.SCALE_SMOOTH));
		backButton = new ImageIcon(temp3.getScaledInstance(40, 30,
				java.awt.Image.SCALE_SMOOTH));
	}//end readIcons

}//end class