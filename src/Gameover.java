import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Gameover extends JFrame implements ActionListener {

	// images, button, and labels
	JLabel gameOver = new JLabel("GAME OVER!");
	JLabel darkCastle = new JLabel(new ImageIcon("images/Dark Castle.gif"));
	JLabel pearlLabel = new JLabel("PEARLS COLLECTED:");
	static JLabel pearlAmount = new JLabel();
	JButton click = new JButton("CLICK TO PROCEED");

	// constructor method
	public Gameover() { 

		// once game over method starts, make the other classes unseen
		KQGUI.sidebar.setVisible(false);
		KQGUI.battlefield.setVisible(false);
		SideBarGUI.sidebar.setVisible(false);
		Battlefield.battlefield.setVisible(false);

		// GUI properties
		setSize(600,600);
		setLayout(null);
		setTitle("Game Over!");
		setVisible(true);
		setResizable(false);
		this.setLocationRelativeTo(null);
		getContentPane().setBackground(Color.BLACK);

		// font properties
		Font bigFont = new Font("Times New Roman", Font.BOLD, 48);
		Font smallFont = new Font("Times New Roman", Font.BOLD,24);

		// label properties
		gameOver.setFont(bigFont);
		gameOver.setForeground(Color.YELLOW);
		gameOver.setBounds(150,-70,500,300);
		add(gameOver);

		// label properties
		pearlLabel.setFont(smallFont);
		pearlLabel.setForeground(Color.WHITE);
		pearlLabel.setBounds(260,80,500,300);
		add(pearlLabel);

		// label properties
		pearlAmount.setFont(bigFont);
		pearlAmount.setForeground(Color.YELLOW);
		pearlAmount.setBounds(370,160,500,300);
		add(pearlAmount);

		// image properties
		darkCastle.setBounds(20,160,224,224);
		add(darkCastle);

		// button properties
		click.setFont(smallFont);
		click.setBounds(150,430, 300,100);
		click.addActionListener(this);
		add(click);

	}

	@Override
	public void actionPerformed(ActionEvent event) {

		// if click to proceed button is clicked, hide this and make a new title page
		if(event.getSource() == click) {
			
			this.setVisible(false);
			new KQGUITitlePage();

		}	
		
	}
	
}