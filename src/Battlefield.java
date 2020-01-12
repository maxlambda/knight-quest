import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Battlefield extends JPanel implements  KeyListener, ActionListener{

	// create the battlefield panel
	static JPanel battlefield = new JPanel(null); 

	// set image file locations
	public static ImageIcon darkKnight =new ImageIcon("images/Dark Knight.gif");
	public static ImageIcon ogre = new ImageIcon("images/Ogre.gif");
	public static ImageIcon tree = new ImageIcon("images/Tree.gif");
	public static ImageIcon pearl = new ImageIcon("images/Pearl.png");
	public static JLabel knight = new JLabel(new ImageIcon("images/Sword Attack.gif")); 
	
	// sword attacking
	public static final ImageIcon SWORDATTACK = new ImageIcon("images/Sword Attack.gif"); 

	// timers
	public Timer knightQuestTimer = new Timer(1500,this); 
	public Timer moveTimer = new Timer(100,this); 
	public Timer knightMovement = new Timer(3,this);
	public Timer displayAttack = new Timer(1000,this); 

	public static int rndPicE;
	public static int rndPicI; 
	public static int treeSelc; 

	public int x; 
	public int totalEnemies;  
	public int totalItems; 
	public int totalTrees; 
	
	// location and x location 
	public int knightXLoc = 400; 
	int knightXMov = 0;  
	public int skullCount = 0;

	private int pearlCounter = 0; 

	int test = -10; 

	// variables for count locations 

	public int timeCount=0; 

	// enemy array 
	public JLabel[] enemy = new JLabel[1000];

	// pearl counter title
	public JLabel[] pearlList = new JLabel[1000]; 

	// tree list 
	public JLabel[] treeList = new JLabel[500]; 

	int countE = 0;
	int countI = 0; 
	int countT = 0; 

	// sets the "grass" color
	Color grass = new Color(154, 219, 111);
	
	
	
	// constructor method
	public Battlefield() {  

		addKeyListener(this); 

		setVisible(true); 
		
		// adds the JPanel
		add(battlefield);
		
		// JPanel properties
		battlefield.setPreferredSize(new Dimension(1000, 900));
		battlefield.setBackground(grass); 
		knightQuestTimer.start();
		moveTimer.start(); 
		knightMovement.start(); 
		
		// add the player
		battlefield.add(knight);  

	}

	public void actionPerformed(ActionEvent event) {

		knightXLoc= knightXLoc + knightXMov;  
		knight.setBounds(knightXLoc, 460, 110, 128);  

		if(knightXLoc>770) { 
			knightXLoc = knightXLoc - 5; 
		}

		if(knightXLoc<50) { 
			knightXLoc = knightXLoc + 5; 
		}
		
		if(skullCount == 10) {
			death();
		}

		int xloc[] = {105, 170, 235, 300, 365, 430, 495, 560, 625, 690}; 

		if(event.getSource() == knightQuestTimer) {

			// Random generator to choose the number of pictures   
			rndPicE  = (int)(Math.random() * 2 + 1); 

			enemy[countE] = new JLabel(); 

			totalEnemies++;


			switch(rndPicE) { 

			// Dark Knight 
			case 1:   

				enemy[countE].setIcon(darkKnight);
				battlefield.add(enemy[countE]); 
				x  = (int)(Math.random() * 10);
				enemy[countE].setBounds(xloc[x], -60, 128, 128); 

				// DKy = +DKy; 
				break;


			case 2:

				enemy[countE].setIcon(ogre);
				battlefield.add(enemy[countE]);
				x  = (int)(Math.random() *10);
				enemy[countE].setBounds(xloc[x], -60, 160, 160); 

				break; 

			}

			rndPicI = (int)(Math.random() *2 +1);  

			pearlList[countI] = new JLabel(); 
			totalItems++; 

			switch(rndPicI) { 

			// Case 1 is blank because sometimes pearls "spawn" along with the enemies whiles sometimes they do not
			case 1: 

			case 2:  

				pearlList[countI].setIcon(pearl);
				battlefield.add(pearlList[countI]); 
				x  = (int)(Math.random() *10);
				pearlList[countI].setBounds(xloc[x],-60,160,160);
				break;

			}

			treeSelc = (int)(Math.random() *2 +1); 
			treeList[countT] = new JLabel(); 
			totalTrees++; 

			switch(treeSelc) { 

			case 1: 

				treeList[countT].setIcon(tree);
				battlefield.add(treeList[countT]); 
				x  = (int)(Math.random() *10);
				treeList[countT].setBounds(xloc[x],-60,160,160);
				break;
				
			// Case 2 is blank for the same reasons outlined above
			case 2:

			}

			countI++; 
			countE++; 
			countT++; 

			// increases count for next time
			
		}


		if (event.getSource() == moveTimer) {

			for (int x = 0; x < totalEnemies; x ++) { 

				enemy[x].setLocation( enemy[x].getX(), enemy[x].getY() + 20); 

				if (knight.getBounds().intersects(enemy[x].getBounds())) {
					enemy[x].setLocation( enemy[x].getX(), enemy[x].getY() +300 ); 
				} 

				if(enemy[x].getY() == 600) { 
					skullAppear();
					skullCount += 1;
				}
				
			} 

			for (int xE =0; xE< totalItems; xE++) { 

				pearlList[xE].setLocation( pearlList[xE].getX(), pearlList[xE].getY() + 30); 

				if (knight.getBounds().intersects(pearlList[xE].getBounds())) {
					pearlList[xE].setLocation( pearlList[xE].getX(), pearlList[xE].getY() +300 ); 
					pearlCounter += 1;
					SideBarGUI.pearlAmount.setText("" + pearlCounter);
				}
				
			} 

			for (int xT =0; xT< totalTrees; xT++) { 

				treeList[xT].setLocation( treeList[xT].getX(), treeList[xT].getY() + 10); 

				if (knight.getBounds().intersects(treeList[xT].getBounds())) {
					
					treeList[xT].setLocation( treeList[xT].getX(), treeList[xT].getY() +300 ); 
					
					skullAppear();
					
					skullCount += 1;

				}
				
			}
			
		} 
		
	}
	
	public void skullAppear() {

		if(skullCount < 1) {
			SideBarGUI.skull1.setVisible(true);
		}
		else if(skullCount < 2) {
			SideBarGUI.skull2.setVisible(true);
		}
		else if(skullCount < 3) {
			SideBarGUI.skull3.setVisible(true);
		}
		else if(skullCount < 4) {
			SideBarGUI.skull4.setVisible(true);
		}
		
	}
	
	public void death() {

		this.setVisible(false);

		knightQuestTimer.stop();
		moveTimer.stop();
		knightMovement.stop();
		displayAttack.stop();

		Gameover.pearlAmount.setText("" + pearlCounter);
		
		new Gameover();

	}
	
	public void keyPressed(KeyEvent key) {

		if(key.getKeyCode() == KeyEvent.VK_LEFT)  { 
			knightXMov =-4; 
		}

		if(key.getKeyCode() == KeyEvent.VK_RIGHT)  { 
			knightXMov =4; 
		} 
		
	}
	
	public void keyReleased(KeyEvent arg0) {

	}
	public void keyTyped(KeyEvent arg0) {

	}
	
}