import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class KQGUIInstructions extends JFrame implements ActionListener {

	// JLabel images and buttons
	JLabel instTitle = new JLabel(new ImageIcon("images/instructions.png")); 
	JLabel instructionsText = new JLabel(new ImageIcon("images/instructions long.png"));
	JButton proceed = new JButton("PROCEED TO GAME"); 

	public KQGUIInstructions() { 

		// properties
		setSize(800, 800);
		setLayout(null);
		setTitle("Knight Quest Instructions");
		setVisible(true);
		setResizable(false);
		this.setLocationRelativeTo(null);
		getContentPane().setBackground(Color.BLACK);

		// banner location
		instTitle.setBounds(-250, -220, 1350, 700);
		add(instTitle);

		// text location
		instructionsText.setBounds(-1, 10, 800, 800);
		add(instructionsText);

		// new font
		Font buttonFont = new Font("Times New Roman", Font.BOLD, 25);
		
		// button properties
		proceed.setFont(buttonFont);
		proceed.setBounds(250, 630, 320, 100);
		proceed.addActionListener(this);
		add(proceed);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == proceed) {

			setVisible(false);

			new KQGUI();

		}

	}

}