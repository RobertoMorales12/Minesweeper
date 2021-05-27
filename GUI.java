//https://youtu.be/0FVdpLLTwoQ
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GUI extends JFrame  {

	//variables that will be used
	
	
	//Grid variables
	public static Grid counts = new Grid();
	
	public static int numRows = counts.getNumRows();
	public static int numColumns = counts.getNumColumns();
	
	
	public static int[][] countGrid = counts.getCountGrid();
	public static boolean [][] bombGrid = counts.getBombGrid();
	public static int numBombs = counts.getNumBombs();
	
	//buttons initialized
	JButton [][] buttons = new JButton[10][10];

	int spacing = 2;
	
	
	//dis da window
	public GUI() {
		
		
		
		//name and size
		setTitle("Minesweeper");
		setSize(800, 365);
		
		//JFrame settings
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
		
		//calls the button creation
		
		counts.createBombGrid();
		ActualGrid grid = new ActualGrid(this);
		setContentPane(grid);
		
		
		
		
		
		
		
		
	}
	
	
	//dis da background color and buttons being displayed
		public class ActualGrid extends JPanel implements ActionListener  {
			
			public void paintComponent(Graphics g) { 
				//gradient background		
				Graphics2D g2 = (Graphics2D) g; 
				GradientPaint yellowToOrange = new GradientPaint(50, 50, Color.YELLOW, 300, 100, Color.ORANGE);
				g2.setPaint(yellowToOrange);
				g2.fillRect(0, 0, 800, 365);
				
				
				
				
				
				
				
			}
			
			//display of buttons
			ActualGrid(JFrame window) {
				
				
				
				//populating buttons array and adding action listeners
				for(int x = 0; x < buttons.length; x++) {
					for(int y = 0; y < buttons[x].length; y++) {
						buttons[x][y] = new JButton("?");
						buttons[x][y].setBounds(spacing + x * 50, spacing + y * 50 + 50, 50 - 2 * spacing, 50 - 2 * spacing);
						add(buttons[x][y]);
						
						//if there is no bombs
						if(bombGrid[x][y] == false) {
						buttons[x][y].addActionListener(this);
						
						
						}
						
						//if there is bombs
						else {
							buttons[x][y].addActionListener(this);	
						}
							
						
						
					}
				}
				
				
				
			}
			//sets the actions
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//temp bomb counter
				int noBombs = 0;
				
				
				
				//checks if the source is equal to the current button and checks if the current location has a bomb
				for(int i = 0; i < countGrid.length; i++) {
					for(int j = 0; j < countGrid[i].length; j++) {
						if(e.getSource() == buttons[i][j] && bombGrid[i][j] == false){
							
							//checks the count of the bombs, meant for ending game if no buttons are clicked
							while(noBombs <= numBombs) {
							buttons[i][j].setText(Integer.toString(countGrid[i][j]));
							
							
							
							
							
							//sets the button background to green if there 
							buttons[i][j].setBackground(Color.GREEN);
							buttons[i][j].setOpaque(true);
							noBombs++;
							
							}
						}
							
						
					
						if(e.getSource() == buttons[i][j] && bombGrid[i][j] == true) {
							for(int x= 0; x < countGrid.length; x++) {
								for(int y = 0; y < countGrid[x].length; y++) {
									//displays the values
									buttons[x][y].setText(Integer.toString(countGrid[x][y]));
									//sets background to red
									buttons[x][y].setBackground(Color.RED);
									buttons[x][y].setOpaque(true);
									
								}
							}
							
							//displays pane asking if you want to restart
							
							//array of options "yes" or "no"
							String[] options = new String[] {"Yes", "No"};
							//the response of the user, 0 = yes 1 = no  
							int response = JOptionPane.showOptionDialog(this, "GAME OVER LOSER! PLAY AGAIN?", "GAME OVER",
							    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
							  
							//if yes
							if(response == 0) {
							  	dispose();
							  	//creates a new JFrame
							  	
							  	
							  	GUI gui = new GUI();
							  	
							  	
							//if no  
							} else if(response == 1) {
							  	//exits the game
								System.exit(0);
							   	
							  }
							
						}
					
					
					}
						
						//the current point is equal to the source and has a bomb in it
						 
					}
				}
				
				
				
				
				
				
			}
		
		
		
		
		
		
	
	
	
			
		public static void main(String [] args) {
			GUI gui = new GUI();
		
			gui.setVisible(true);
			
		}
}