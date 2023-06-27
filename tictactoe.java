import java.util.Scanner;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class tictactoe {
    
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);

        String asdf = "Computer";
        String userName;
		
		System.out.println("What is your name??");
		userName = scanner.nextLine();

        char[][] board = {{' ',' ',' '},
                          {' ',' ',' '},
                          {' ',' ',' '}};
                                  
        printBoard(board);
                
        double rand = Math.random();
        System.out.println(userName + " is heads. Computer is tails.");

        if(rand < 0.500){
            System.out.println("It's heads. " + userName + " goes first.");
            while (true) {
                                
                String userNumber = playerTurn(board, scanner);
                
                writeFile(userName, userNumber);


                if (isGameFinished(board)){
                    break;
                }
                printBoard(board);
                
                System.out.println("------------------------------");

                int x = computerTurn(board);
                String compTurn = Integer.toString(x);
                
                writeFile(asdf, compTurn);

                if (isGameFinished(board)){
                    break;
                }
                printBoard(board);

            }
        } else {
            System.out.println("It's tails. Computer goes first.");
            while (true) {

                int y = computerTurn(board);
                String compTurn2 = Integer.toString(y);

                writeFile(asdf, compTurn2);
        
                if (isGameFinished(board)){
                    break;
                }
                printBoard(board);

                System.out.println("------------------------------");
                        
                String userNumber2 = playerTurn(board, scanner);
                writeFile(userName, userNumber2);
                
                if (isGameFinished(board)){
                    break;
                }
                printBoard(board);
            }
        }

		scanner.close();

    }

    //---------------------------------------------------------------------------------------------------------------------------------

    public static void writeFile(String name, String move){

       
         try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("ttt.txt"));
            

            writer.append(name + ": " + move + "\n");
    
            
            writer.close();
        } catch (IOException e){
                e.printStackTrace();
        }
        
        
    }

    //---------------------------------------------------------------------------------------------------------------------------------

    private static boolean isGameFinished(char[][] board) {
		
		if (hasContestantWon(board, 'X')) {	
			printBoard(board);
			System.out.println("Player wins!!");
			return true;
		}
		
		if (hasContestantWon(board, 'O')) {	
			printBoard(board);
			System.out.println("Computer wins!! :(");
			return true;
		}
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == ' ') {
					return false;
				}
			}
		}
		printBoard(board);
		System.out.println("Game is a tie.");
		return true;
	}

    //---------------------------------------------------------------------------------------------------------------------------------

	private static boolean hasContestantWon(char[][] board, char symbol) {
		if ((board[0][0] == symbol && board [0][1] == symbol && board [0][2] == symbol) ||
			(board[1][0] == symbol && board [1][1] == symbol && board [1][2] == symbol) ||
			(board[2][0] == symbol && board [2][1] == symbol && board [2][2] == symbol) ||
			
			(board[0][0] == symbol && board [1][0] == symbol && board [2][0] == symbol) ||
			(board[0][1] == symbol && board [1][1] == symbol && board [2][1] == symbol) ||
			(board[0][2] == symbol && board [1][2] == symbol && board [2][2] == symbol) ||
			
			(board[0][0] == symbol && board [1][1] == symbol && board [2][2] == symbol) ||
			(board[0][2] == symbol && board [1][1] == symbol && board [2][0] == symbol) ) {
			return true;
		}
		return false;
	}

    //---------------------------------------------------------------------------------------------------------------------------------

    private static int computerTurn(char[][] board) {
        
            int bestSpot = 0;
            int computerMove;


            //-------------------------------------Finishing moves
            if(((board[0][1] == 'O' && board[0][2] == 'O') || (board[1][0] == 'O' && board[2][0] == 'O') || 
                                                    (board[1][1] == 'O' && board[2][2] == 'O')) && (board[0][0] == ' ')){
                bestSpot = 1;
            } else if(((board[0][0] == 'O' && board[0][2] == 'O') || (board[1][1] == 'O' && board[2][1] == 'O')) && (board[0][1] == ' ')){
                bestSpot = 2;
            } else if(((board[0][0] == 'O' && board[0][1] == 'O') || (board[1][2] == 'O' && board[2][2] == 'O') || 
                                                    (board[1][1] == 'O' && board[2][0] == 'O')) && (board[0][2] == ' ')){
                bestSpot = 3;
            } else if(((board[0][0] == 'O' && board[2][0] == 'O') || (board[1][1] == 'O' && board[1][2] == 'O')) && (board[1][0] == ' ')){
                bestSpot = 4;
            } else if(((board[1][0] == 'O' && board[1][2] == 'O') || (board[0][1] == 'O' && board[2][1] == 'O') || 
                        (board[0][0] == 'O' && board[2][2] == 'O') || (board[0][2] == 'O' && board[2][0] == 'O')) && (board[1][1] == ' ')){
                bestSpot = 5;
            } else if(((board[0][2] == 'O' && board[2][2] == 'O') || (board[1][0] == 'O' && board[1][1] == 'O')) && (board[1][2] == ' ')){
                bestSpot = 6;
            } else if(((board[0][0] == 'O' && board[1][0] == 'O') || (board[2][1] == 'O' && board[2][2] == 'O') || 
                                                    (board[1][1] == 'O' && board[0][2] == 'O')) && (board[2][0] == ' ')){
                bestSpot = 7;
            } else if(((board[0][1] == 'O' && board[1][1] == 'O') || (board[2][0] == 'O' && board[2][2] == 'O')) && (board[2][1] == ' ')){
                bestSpot = 8;
            } else if(((board[0][0] == 'O' && board[1][1] == 'O') || (board[0][2] == 'O' && board[1][2] == 'O') || 
                                                    (board[2][1] == 'O' && board[2][0] == 'O')) && (board[2][2] == ' ')){
                bestSpot = 9;
            } else {
                 //-------------------------------------Block moves
                if(((board[0][1] == 'X' && board[0][2] == 'X') || (board[1][0] == 'X' && board[2][0] == 'X') || 
                        (board[1][1] == 'X' && board[2][2] == 'X')) && (board[0][0] == ' ')){
                    bestSpot = 1;
                } else if(((board[0][0] == 'X' && board[0][2] == 'X') || (board[1][1] == 'X' && board[2][1] == 'X')) && (board[0][1] == ' ')){
                    bestSpot = 2;
                } else if(((board[0][0] == 'X' && board[0][1] == 'X') || (board[1][2] == 'X' && board[2][2] == 'X') || 
                             (board[1][1] == 'X' && board[2][0] == 'X')) && (board[0][2] == ' ')){
                    bestSpot = 3;
                } else if(((board[0][0] == 'X' && board[2][0] == 'X') || (board[1][1] == 'X' && board[1][2] == 'X')) && (board[1][0] == ' ')){
                    bestSpot = 4;
                } else if(((board[1][0] == 'X' && board[1][2] == 'X') || (board[0][1] == 'X' && board[2][1] == 'X') || 
                            (board[0][0] == 'X' && board[2][2] == 'X') || (board[0][2] == 'X' && board[2][0] == 'X')) && (board[1][1] == ' ')){
                    bestSpot = 5;
                } else if(((board[0][2] == 'X' && board[2][2] == 'X') || (board[1][0] == 'X' && board[1][1] == 'X')) && (board[1][2] == ' ')){
                    bestSpot = 6;
                } else if(((board[0][0] == 'X' && board[1][0] == 'X') || (board[2][1] == 'X' && board[2][2] == 'X') || 
                         (board[1][1] == 'X' && board[0][2] == 'X')) && (board[2][0] == ' ')){
                    bestSpot = 7;
                } else if(((board[0][1] == 'X' && board[1][1] == 'X') || (board[2][0] == 'X' && board[2][2] == 'X')) && (board[2][1] == ' ')){
                    bestSpot = 8;
                } else if(((board[0][0] == 'X' && board[1][1] == 'X') || (board[0][2] == 'X' && board[1][2] == 'X') || 
                        (board[2][1] == 'X' && board[2][0] == 'X')) && (board[2][2] == ' ')){
                    bestSpot = 9;
                } else { //----------------------------------------------------------X goes on 2,4,6,8 moves/// O is first
                    if(board[1][1] == ' '){
                        bestSpot = 5;
                    } else if(board[0][1] == 'X' && board[1][1] == 'O' && board[0][0] == ' '){
                        bestSpot = 1;
                    } else if(board[1][0] == 'X' && board[1][1] == 'O' && board[2][0] == ' '){
                        bestSpot = 7;
                    } else if(board[1][2] == 'X' && board[1][1] == 'O' && board[0][2] == ' '){
                        bestSpot = 3;
                    } else if(board[2][1] == 'X' && board[1][1] == 'O' && board[2][2] == ' '){
                        bestSpot = 9;
                    } else if(board[0][1] == 'X' && board[1][1] == 'O' && board[0][0] == 'O' && board[1][0] == ' '){ //-------second move
                        bestSpot = 4;
                    } else if(board[1][0] == 'X' && board[1][1] == 'O' && board[2][0] == 'O' && board[2][1] == ' '){
                        bestSpot = 8;
                    } else if(board[1][2] == 'X' && board[1][1] == 'O' && board[0][2] == 'O' && board[0][1] == ' '){
                        bestSpot = 2;
                    } else if(board[2][1] == 'X' && board[1][1] == 'O' && board[2][2] == 'O' && board[1][2] == ' '){
                        bestSpot = 6;
                    } else { //-------------------------------------------------X goes second on 1,3,7,9
                        if((board[0][0] == 'X') && (board[1][1] == 'O')  && board[2][2] == ' '){
                            bestSpot = 9;
                        } else if((board[0][2] == 'X') && (board[1][1] == 'O')  && board[2][0] == ' '){
                            bestSpot = 7;
                        } else if((board[0][0] == 'X') && (board[1][1] == 'O')  && board[2][2] == 'X'){
                            bestSpot = 2;
                        } else if((board[2][0] == 'X') && (board[1][1] == 'O')  && board[0][2] == ' '){
                            bestSpot = 3;
                        } else if((board[2][2] == 'X') && (board[1][1] == 'O')  && board[0][0] == ' '){
                            bestSpot = 1;
                        } else if((board[0][0] == 'X') && (board[1][1] == 'O')  && board[2][2] == 'O'){//------trap move
                            if(board[1][2] == 'X'){
                                bestSpot = 8;
                            } else if(board[2][1] == 'X'){
                                bestSpot = 6;
                            }
                        } else if((board[0][2] == 'X') && (board[1][1] == 'O')  && board[2][0] == 'O'){
                            if(board[1][0] == 'X'){
                                bestSpot = 8;
                            } else if(board[2][1] == 'X'){
                                bestSpot = 4;
                            }
                        } else if((board[2][0] == 'X') && (board[1][1] == 'O')  && board[0][2] == 'O'){
                            if(board[0][1] == 'X'){
                                bestSpot = 6;
                            } else if(board[1][2] == 'X'){
                                bestSpot = 2;
                            }
                        } else if((board[2][2] == 'X') && (board[1][1] == 'O')  && board[0][0] == 'O'){
                            if(board[1][0] == 'X'){
                                bestSpot = 2;
                            } else if(board[0][1] == 'X'){
                                bestSpot = 4;
                            }
                        }  else{
                                if(board[1][1] == 'X'){
                                    bestSpot = 3;
                                } 
                                if(board[1][1] == 'X' && board[0][2] == 'O'){
                                    if(board[0][0] == ' '){
                                        bestSpot = 1;
                                    } else if(board[0][2] == ' '){
                                        bestSpot = 3;
                                    } else if(board[2][0] == ' '){
                                        bestSpot = 7;
                                    } else if(board[2][2] == ' '){
                                        bestSpot = 9;
                                    } else if(board[0][1] == ' '){
                                        bestSpot = 2;
                                    } else if(board[1][0] == ' '){
                                        bestSpot = 4;
                                    } else if(board[1][2] == ' '){
                                        bestSpot = 6;
                                    } else if(board[2][1] == ' '){
                                        bestSpot = 8;
                                    }
                                }
                                
                        }




                    }            
                } 
            }

           

    
            while (true) {
                computerMove = bestSpot;
                if (isValidMove(board, Integer.toString(computerMove))) {
                    break;
                }
            }
            
            placeMove(board, Integer.toString(computerMove), 'O');
            return bestSpot;
    }
	
	

    //---------------------------------------------------------------------------------------------------------------------------------


	private static boolean isValidMove (char[][] board, String position) {
		switch(position) {
			case "1":
				return (board[0][0] == ' ');
			case "2":
				return (board[0][1] == ' ');
			case "3":
				return (board[0][2] == ' ');
			case "4":
				return (board[1][0] == ' ');
			case "5":
				return (board[1][1] == ' ');
			case "6":
				return (board[1][2] == ' ');
			case "7":
				return (board[2][0] == ' ');
			case "8":
				return (board[2][1] == ' ');
			case "9":
				return (board[2][2] == ' ');
			default:
				return false;
		}
	}

    //---------------------------------------------------------------------------------------------------------------------------------

	private static String playerTurn(char[][] board, Scanner scanner) {
		String userInput;
		while (true) {
			System.out.println("Where would you like to play? (1-9)");
			userInput = scanner.nextLine();
			if (isValidMove(board, userInput)){
				break;
			} else {
                System.out.println(userInput + " is not a valid move.");
			}
		}
		placeMove(board, userInput, 'X');
        return userInput;
	}

   

    //---------------------------------------------------------------------------------------------------------------------------------

	private static void placeMove(char[][] board, String position, char symbol) {
		switch(position) {
			case "1":
				board[0][0] = symbol;
				break;
			case "2":
				board[0][1] = symbol;
				break;
			case "3":
				board[0][2] = symbol;
				break;
			case "4":
				board[1][0] = symbol;
				break;
			case "5":
				board[1][1] = symbol;
				break;
			case "6":
				board[1][2] = symbol;
				break;
			case "7":
				board[2][0] = symbol;
				break;
			case "8":
				board[2][1] = symbol;
				break;
			case "9":
				board[2][2] = symbol;
				break;
			default:
            System.out.println("(.)(.)");
		}
	}

	//---------------------------------------------------------------------------------------------------------------------------------
	
	private static void printBoard(char[][] board) {
		
        System.out.println(board[0][0] + "|" +  board[0][1] + "|" +  board[0][2] );
		System.out.println("-+-+-");
		System.out.println(board[1][0] + "|" +  board[1][1] + "|" +  board[1][2] );
		System.out.println("-+-+-");
		System.out.println(board[2][0] + "|" +  board[2][1] + "|" +  board[2][2] );

	}

}
