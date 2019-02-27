package com.test;

public class NQueensProblem {

	private static int SIZE = 4;
	
	// placing queens in rows starting from 0
	
	private static boolean isSafe(Character[][] grid , int row , int col) {
		
		// checking for columns
		for(int i = 0 ; i < SIZE ; i++) {
			if(grid[i][col] == 'Q') {
				return false;
			}
		}
		
		//checking for right up diagonals \
		for(int i = row , j = col ; i >= 0 && j >= 0 ; i-- , j--) {
			if(grid[i][j] == 'Q') {
				return false;
			}
		}
		
		// checking for left up /
		for(int i = row , j = col ; i >= 0 && j < SIZE ; i-- , j++) {
			if(grid[i][j] == 'Q') {
				return false;
			}
		}
		
		return true;
		
	}
	
	private static void solve (Character[][] grid , int row) {
		
		if( row == SIZE ) {
			/*System.out.println("Finished placing queens, printing....");
			
			Arrays.stream(grid).forEach(array -> {
				
				Arrays.stream(array).forEach(i -> System.out.print(i + " "));
				System.out.println();
				
			});	
			System.exit(0);*/
			
		}
		else {
			
			for( int i = 0 ; i < SIZE ; i++) {
				
				if(isSafe(grid, row, i)) {
					// setting the queen in place
					grid[row][i] = 'Q';
					
					// solving for next row
					solve(grid, row+1);
					
					// if we moved in wrong direction, set the grid position back to '_'
					grid[row][i] = '_';
				}		
			}
			
		}
		
	}
	
	
	public static void main(String[] args) {
		
		for(SIZE = 4 ; SIZE <= 20 ; SIZE++) {
			

			Character[][] grid = new Character[SIZE][SIZE];
			
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[i].length; j++) {
					grid[i][j] = '_';
				}
			}
			
			long start = System.currentTimeMillis();
			
			solve(grid, 0);
			
			long end = System.currentTimeMillis();
			
			System.out.println("Solving took " + (end - start) + " milliseconds for grid size " + SIZE );
		}
		
		

	}	

}
