import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class KQGUITitlePage extends JFrame implements ActionListener {

	// JLabel images and buttons
	JLabel title = new JLabel(new ImageIcon("images/knight quest draft.png")); 
	JLabel castle = new JLabel(new ImageIcon("images/Castle.gif"));
	JLabel welcome = new JLabel(new ImageIcon("images/welcome.png"));
	JButton instButton = new JButton("INSTRUCTIONS"); 

	public KQGUITitlePage() { 

		// properties
		setSize(800,800);
		setLayout(null);
		setTitle("Knight Quest");
		setVisible(true);
		setResizable(false);
		this.setLocationRelativeTo(null);
		getContentPane().setBackground(Color.BLACK);

		// title location
		title.setBounds(-250, -220, 1350, 700);
		add(title);

		// castle location
		castle.setBounds(50, 320, 224, 224);
		add(castle);

		// welcome banner location
		welcome.setBounds(150,10,800,800);
		add(welcome);

		// new font
		Font buttonFont = new Font("Times New Roman", Font.BOLD, 25);
		
		// button properties
		instButton.setFont(buttonFont);
		instButton.setBounds(250, 630, 320, 100);
		instButton.addActionListener(this);
		add(instButton);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == instButton) {

			setVisible(false);
			
			new KQGUIInstructions();

		}

	}

}