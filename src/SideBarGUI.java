import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SideBarGUI extends JPanel implements ActionListener{

	// image file locations for label pictures and icons
	JLabel pearlsLabel = new JLabel(new ImageIcon("images/sidebarPearls.png"));
	JLabel skullsLabel = new JLabel(new ImageIcon("images/sidebarSkulls.png"));
	JLabel weaponLabel = new JLabel(new ImageIcon("images/sidebarWeapon.png"));
	JLabel sword = new JLabel(new ImageIcon("images/Sword.png"));
	public static JLabel skull1 = new JLabel(new ImageIcon("images/Skull.png"));
	public static JLabel skull2 = new JLabel(new ImageIcon("images/Skull.png"));
	public static JLabel skull3 = new JLabel(new ImageIcon("images/Skull.png"));
	public static JLabel skull4 = new JLabel(new ImageIcon("images/Skull.png"));

	// new JLabel for pearl amount
	static JLabel pearlAmount = new JLabel("");

	// bar color
	Color barColor = new Color(150, 95, 72);

	// create JPanel
	static JPanel sidebar = new JPanel(null); 

	// create pearl variable

	public SideBarGUI() {

		// side bar properties: 
		add(sidebar); 
		sidebar.setBackground(barColor);
		setVisible(true);
		
		// new font
		Font smallFont = new Font("Times New Roman", Font.BOLD,36);

		// side bar size
		sidebar.setPreferredSize(new Dimension(800, 200));

		// pearl label properties
		pearlsLabel.setBounds(-190, -10, 600, 120);
		sidebar.add(pearlsLabel);

		// skull label properties
		skullsLabel.setBounds(100, -10, 600, 120);
		sidebar.add(skullsLabel);

		// weapon label properties
		weaponLabel.setBounds(380, -10, 600, 120);
		sidebar.add(weaponLabel);

		// weapon icon properties
		sword.setBounds(630, 65, 96, 96);
		sidebar.add(sword);

		// skull picture 1 properties
		skull1.setBounds(240, 50, 96, 96);
		sidebar.add(skull1);
		skull1.setVisible(false);
		
		// skull picture 2 properties
		skull2.setBounds(310, 50, 96, 96);
		sidebar.add(skull2);
		skull2.setVisible(false);

		// skull picture 3 properties
		skull3.setBounds(380, 50, 96, 96);
		sidebar.add(skull3);
		skull3.setVisible(false);

		// skull picture 4 properties
		skull4.setBounds(450, 50, 96, 96);
		sidebar.add(skull4);
		skull4.setVisible(false);

		// pearl amount label properties
		pearlAmount.setFont(smallFont);
		pearlAmount.setForeground(Color.YELLOW);
		pearlAmount.setBounds(120, -10, 300, 200);
		sidebar.add(pearlAmount);

	}

	public void actionPerformed(ActionEvent arg0) {

	}

}