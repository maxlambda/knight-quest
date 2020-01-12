import java.awt.Color;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class KQGUI extends JFrame {

	// creates new green color
	Color grass = new Color(154, 219, 111);

	// creates sidebar and battlefield
	public static SideBarGUI sidebar; 
	public static Battlefield battlefield; 

	// constructor method
	public KQGUI() {

		// properties
		setSize(800,800);
		setLayout(null);
		setVisible(true); 
		setResizable(false); 
		setLocationRelativeTo(null);
		getContentPane().setBackground(grass);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// sidebar properties
		sidebar = new SideBarGUI(); 
		sidebar.setBounds(0,600,800,200); 
		add(sidebar); 

		// battlefield properties
		battlefield = new Battlefield(); 
		battlefield.setBounds(0, 0,800,600); 
		battlefield.setBackground(grass);
		add(battlefield); 

		// listen for events on the battlefield
		addKeyListener(battlefield);
		
	} 
	
}