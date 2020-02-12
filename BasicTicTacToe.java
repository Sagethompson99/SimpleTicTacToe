import java.util.InputMismatchException;
import java.util.Scanner;

public class BasicTicTacToe {
	
	private static String winner(int[][] board) {
		int row = 0;
		int col = 0;
		
		while(row < 3) {
		   if(board[row][0] == 1 && board[row][1] == 1 && board[row][2] == 1) {
			  return "Player One";
		   }
		   if(board[row][0] == 2 && board[row][1] == 2 && board[row][2] == 2) {
			  return "Player Two";
		   }
		
		   row++;
		
		   if(board[0][col] == 1 && board[1][col] == 1 && board[2][col] == 1) {
		      return "Player One";
		   }
		   if(board[0][col] == 2 && board[1][col] == 2 && board[2][col] == 2) {
			  return "Player Two";
		   }
			
		   col++;
		}
		
		   if(board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1) {
			   return "Player One";
		   }
		   if(board[0][0] == 2 && board[1][1] == 2 && board[2][2] == 2) {
			   return "Player Two";
		   }
		   
		   if(board[0][2] == 1 && board[1][1] == 1 && board[2][0] == 1) {
			   return "Player One";
		   }
		   if(board[0][2] == 2 && board[1][1] == 2 && board[2][0] == 2) {
			   return "Player Two";
		   }
	    
		
		return null;
	} 
	
	private static void updateBoard(int[][] board) {
		System.out.println();
		
		for(int i = 0; i < board.length; i++) {
           for(int j = 0; j < board[i].length; j++) {
        	   
        	   //last column
         	   if(j == 2 ) {	   
         		  //special case for bottom right
         		  if(i == 2) {
         			 if(board[i][j] == 0) 
                		 System.out.println("| ");
                	   
                	  if(board[i][j] == 1) 
                		 System.out.println("| X ");
                	   
                	  if(board[i][j] == 2) 
                	     System.out.println("| O ");  
         		  }
         		  //case for top and middle of end column
         		  else {
               	      if(board[i][j] == 0) 
            		     System.out.println("|___");
            	   
            	      if(board[i][j] == 1) 
            		     System.out.println("|_X_");
            	   
            	      if(board[i][j] == 2) 
            	         System.out.println("|_O_");  
         		  }
        	   }
         	   //middle column
        	   else if(j == 1 ) {
        		  //special case for bottom middle
          		  if(i == 2) {
          			  if(board[i][j] == 0) 
                 		 System.out.print("   ");
                 	   
                 	  if(board[i][j] == 1) 
                 		 System.out.print(" X ");
                 	   
                 	  if(board[i][j] == 2) 
                 	     System.out.print(" O ");  
          		  }
          		  //case for top and bottom of middle column
          		  else {
        		      if(board[i][j] == 0) 
              		     System.out.print("___");
              	   
              	      if(board[i][j] == 1) 
              		     System.out.print("_X_");
              	   
              	      if(board[i][j] == 2) 
              	         System.out.print("_O_");
          		  }
        	   }
         	   //first column
               else {
            	   //special case for bottom left of first column
            	  if(i==2 && j ==0) {
            	      if(board[i][j] == 0) 
                		 System.out.print("   |");
                  	   
                	  if(board[i][j] == 1) 
                		 System.out.print(" X |");
                  	   
                	  if(board[i][j] == 2) 
                		 System.out.print(" O |");  
            	  }
            	  //case for top and middle of first column
            	  else {
           	          if(board[i][j] == 0) 
           		         System.out.print("___|");
             	   
           	          if(board[i][j] == 1) 
           		         System.out.print("_X_|");
             	   
           	          if(board[i][j] == 2) 
           		         System.out.print("_O_|");  
            	  }
               }   	   
 
           }
	    }
	}
	
    public static void main(String args[]) {
    	int[][] board = new int[3][3];
    	boolean running = true;
    	int num = 0;
    	
    	System.out.println();
    	System.out.println("                    Tic Tac Toe\n");
    	System.out.println("                     1    2    3  ");
    	System.out.println("                 1     |     |    ");
    	System.out.println("                   ---------------");
    	System.out.println("                 2     |     |    ");
    	System.out.println("                   ---------------");
    	System.out.println("                 3     |     |    ");
    	
    	System.out.println("\nRULES:");
    	System.out.println("Each player must enter the row and column of his/her\ndesired move, "
    			+ "separated by a single space. The diagram\nabove shows the row and column"
    			+ " numbers to be used.");
      	System.out.println("\nOBJECTIVE:");
      	System.out.println("Be the first to get 3 in a row vertically,\nhorizontally,"
      			+ " or diagonally.");
    	
    	while(running) {
    	   int player;
    	      if(num % 2 == 0) {
    	    	  player = 1;
    	      }
    	      else {
    	    	  player = 2;
    	      }
    	try {
       	   System.out.println("\nPlayer " + player + "'s move:");
    	   Scanner input = new Scanner(System.in);
    	   int chosenRow = input.nextInt() - 1;
    	   int chosenCol = input.nextInt() - 1;
    	   
    	   //catch errors
           while(chosenCol > 2 || chosenRow > 2 || chosenCol < 0 || chosenRow < 0 || board[chosenRow][chosenCol] == 1 || board[chosenRow][chosenCol] == 2) {
        	  if(chosenCol > 2 || chosenRow > 2 || chosenCol < 0 || chosenRow < 0 ) {
        	    System.out.println("Woah! That position is invalid. \nTry another position:");
        	    input = new Scanner(System.in);
        	    chosenRow = input.nextInt() - 1;
        	    chosenCol = input.nextInt() - 1;
        	  }
           
        	  else {
        	    System.out.println("Uh oh! Looks like that position has already been\n"
        	    + "filled! Try another position:");
        	    input = new Scanner(System.in);
        	    chosenRow = input.nextInt() - 1;
        	    chosenCol = input.nextInt() - 1;
              }
           }
           
           board[chosenRow][chosenCol] = player;
    	   updateBoard(board);
    	}
    	catch(InputMismatchException e) {
    		System.out.println("Only numbers are allowed! \nYou lose your turn for testing my patience");
    		num--;
    	}
    	 
    	   String winner = winner(board);
    	   num++;
    	   
    	      if(winner != null) {
    	    	  System.out.println("\n" + winner + " Wins!");
    	    	  running = false;
    	      }
    	      if(num == 9 ) {
    	    	  System.out.println("\nBoard is full! Tie game.");
    	    	  running = false;
    	      }
    	}
    }
}
