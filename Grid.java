


import java.util.Random;

public class Grid {
	private boolean [][] bombGrid;
	private int [][] countGrid;
	private int numRows;
	private int numColumns;
	private int numBombs =25;

	public Grid() {
		this.numRows = 10;
		this.numColumns = 10;
		this.numBombs = 25;
		createBombGrid(); 
		createCountGrid(); 
	}

	public Grid(int rows, int columns) {
		
		this.numRows = rows;
		this.numColumns = columns;
		this.bombGrid = new boolean[numRows][numColumns];
		this.countGrid = new int [numRows][numColumns];
		this.numBombs = 25;
		createBombGrid(); 
		createCountGrid(); 
	}

	public Grid(int rows, int columns, int numBombs) {
		
		this.numRows = rows;
		this.numColumns = columns;
		this.bombGrid = new boolean[numRows][numColumns];
		this.countGrid = new int [numRows][numColumns];
		
		this.numBombs = numBombs;
		createBombGrid(); 
		createCountGrid(); 
	}

	public int getNumRows() {
		return numRows;
	}

	public int getNumColumns() {
		return numColumns;
	}

	public int getNumBombs() {
		return numBombs;
	}

	public boolean[][] getBombGrid() {
		
		boolean[][] copy = new boolean[numRows][numColumns];
		
		for (int i = 0; i < numRows; i++) {
			for(int j = 0; j < bombGrid[i].length; j++) {
				copy [i][j] = bombGrid[i][j];
			}
		}
		return copy;
	}
	public int[][] getCountGrid() {
		
		int[][] copy = new int[numRows][numColumns];
		
		for (int i = 0; i < numRows; i++) {
			for(int j = 0; j < countGrid[i].length; j++) {
				copy[i][j] = countGrid[i][j];
			}
		}
		return copy;
	}

	public boolean isBombAtLocation(int row, int column) {
		return bombGrid[row][column];
	}

	public int getCountAtLocation(int row, int column) {
		return countGrid[row][column];
	}

	public void createBombGrid() {
		
		Random rand = new Random();
		
		bombGrid = new boolean[numRows][numColumns];
		
		for(int i=0; i<numRows; i++){
			for(int j=0;j<numColumns;j++){
				bombGrid[i][j] = false;
			}
		}
		
		for(int i=0; i<numBombs; i++){
			
			int mX = 0;
			
			int mY = 0;
			
			do {
				mX = rand.nextInt(numRows);
				mY = rand.nextInt(numColumns);
				
			}while(bombGrid[mX][mY] == true);
				bombGrid[mX][mY] = true;
				
			}
	}
	
	public boolean isAtPoint(int i, int j) {
		
		return(i >= 0 && i < numRows && j >= 0 && j < numColumns);
	}
	
	private void createCountGrid() {
		
		countGrid = new int[numRows][numColumns];
		
		for(int i=0;i<numRows;i++){
			for(int j=0;j<numColumns;j++){
				int bombs = 0;
				
				if(isAtPoint(i,j)){ 
					if(isBombAtLocation(i, j))
						bombs += 1;
				}
				
				if(isAtPoint(i,j-1)){ 
					if(isBombAtLocation(i, j -1))
						bombs += 1;
				}
				 
				if(isAtPoint(i,j+1)){
					if(isBombAtLocation(i, j + 1))
						bombs += 1;
				}
				
				if(isAtPoint(i-1,j-1)){ 
					if(isBombAtLocation(i - 1, j - 1))
						bombs += 1;
				}
				
				if(isAtPoint(i-1,j)){ 
					if(isBombAtLocation(i - 1, j))
						bombs += 1;
				}
				
				if(isAtPoint(i-1,j+1)){ 
					if(isBombAtLocation(i - 1, j + 1))
						bombs += 1;
				}
				
				if(isAtPoint(i + 1,j)){
					if(isBombAtLocation(i + 1, j))
						bombs += 1;
				}
				
				if(isAtPoint(i+1,j+1)){ 
					if(isBombAtLocation(i + 1, j + 1))
						bombs += 1;
				}
				
				if(isAtPoint(i+1,j-1)){ 
					if(isBombAtLocation(i + 1, j - 1))
						bombs += 1;
				}
				
				countGrid[i][j] = bombs;
			}
		}
	}
	
	public static void main(String [] args) {
		Grid test = new Grid();	
	}
}