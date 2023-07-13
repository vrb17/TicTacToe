# TicTacToe
The code implements a command-line Tic-Tac-Toe game. It handles user input, generates the computer's moves, checks for winning conditions, updates the game board, and writes the moves made by both the user and the computer to a file. The game continues until there is a winner or a tie, and the board is printed after each turn.

Regardless of who goes first, the computer will never allow the user to win.
The game will always result in either the computer winning or forcing a draw.

Importing Required Modules:
- The code imports necessary modules such as Scanner, Random, BufferedWriter, FileWriter, and IOException to enable specific functionalities.

Initializing the Game:
- The board variable is initialized as a 3x3 character array to represent the game board.
- The initial empty game board is printed using the printBoard method.
- The first player (user or computer) is randomly determined by generating a random number between 0 and 1.

Game Loop:
- The code enters a game loop that continues until the game is finished (isGameFinished method returns true).
- If the user goes first, the loop alternates between the user's turn and the computer's turn.
- If the computer goes first, the loop alternates between the computer's turn and the user's turn.
- After each turn, the game board is printed using the printBoard method.

File Writing:
- The writeFile method is used to write the player's name and their chosen move to a file called "ttt.txt".
- It appends the player's name and move to the file, separating them with a colon.

Game Logic:
- The isGameFinished method checks if the game is over by checking for winning combinations or a tie.
- The hasContestantWon method checks if a specific player ('X' or 'O') has won by checking all possible winning combinations.
- The computerTurn method determines the computer's move based on specific rules and strategies.
- The isValidMove method checks if a move is valid by verifying if the corresponding cell on the board is empty.
- The playerTurn method prompts the user to enter their desired move and validates it before placing it on the board.
- The placeMove method updates the game board with the chosen move.

