import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ticTacToe {

	static String[][] winningScenarios = { { "11", "21", "21" }, { "12", "22", "32" }, { "13", "23", "33" },
			{ "11", "12", "13" }, { "21", "22", "23" }, { "31", "32", "33" }, { "13", "22", "31" },
			{ "11", "22", "33" } };

	static int i = 0;
	static char board[][] = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
//	static char xo1[] = { ' ', ' ', ' ' };
//	static char xo2[] = { ' ', ' ', ' ' };
//	static char xo3[] = { ' ', ' ', ' ' };
	static boolean isAI = false;
	static int whichLevel = -1;
	// if AIxOro is 0, then it's equal to x, if it's 1, it is o
	static boolean isFirst = false;
	static int AIxOro = -1;

	public static void main(String[] args) {
		String[] Options = { "vs.Computer", "vs.Player" };
		int choice = JOptionPane.showOptionDialog(null, "Which one do you want", "tic tac toe",
				JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, Options, 0);
		if (choice == 0) {
			isAI = true;
		}
		if (isAI == true) {
			String[] Options1 = { "easy", "medium", "hard" };
			whichLevel = JOptionPane.showOptionDialog(null, "Choose a level", "tic tac toe",
					JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, Options1, 0) + 1;
			String[] Options2 = { "x", "o" };
			AIxOro = JOptionPane.showOptionDialog(null, "Do you want to be x or o", "tic tac toe",
					JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, Options2, 0);

			Options2[0] = "first";
			Options2[1] = "second";
			int isFirst2 = 0;
			isFirst2 = JOptionPane.showOptionDialog(null, "Do you want to be first or second", "tic tac toe",
					JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, Options2, 0) + 1;
			if (isFirst2 == 1) {
				isFirst = true;
			} else if (isFirst2 == 2) {
				isFirst = false;
			}

		}

		if (isAI == false) {
			Scanner scan = new Scanner(System.in);
			boolean gameOver = false;

			System.out.println("Welcome to tic tac toe\n choose who will be player one and who will be two");
			Random randy = new Random();

			int player = randy.nextInt(2) + 1;

			printBoard();

			while (gameOver == false) {
				char oOrx;
				System.out.println("Player " + player + " will be 'x'\n The other player will be 'o'");

				int whichPlayer = 0;
				if (i % 2 == 0) {
					System.out.println("Player1's turn");
					whichPlayer = 1;
					if (player == 1) {
						oOrx = 'x';

					} else {
						oOrx = 'o';
					}

				} else {
					System.out.println("Player2's turn");
					whichPlayer = 2;
					if (player == 2) {
						oOrx = 'x';
					} else {
						oOrx = 'o';
					}
				}

				// figurs who's turn it is based on i. player2, or player1

				int coords[] = input(oOrx, player, whichPlayer, false);
				board[coords[0] - 1][coords[1] - 1] = oOrx;
				i++;

				if (containsSpaces(board[0]) == false && containsSpaces(board[1]) == false
						&& containsSpaces(board[2]) == false) {
					printBoard();

					System.out.println("draw");
					System.exit(0);
				}

				if (isWinningBoard(board[0], board[1], board[2]) == true) {

					System.out.println("new game board");
					printBoard();
					System.out.println("player" + whichPlayer + " won");

					System.exit(0);
				}

				System.out.println("new game board");
			}

		} else if (isAI == true) {
			// all the AI stuff goes in here
			char AIletter = 'o';
			char UserLetter = 'x';
			if (AIxOro == 0) {
				UserLetter = 'x';
				AIletter = 'o';
			} else if (AIxOro == 1) {
				UserLetter = 'o';
				AIletter = 'x';
			}
			boolean gameOver = false;
			String whichPlayer = "";
			i = 0;

			printBoard();

			while (gameOver == false) {

				if (i % 2 == 0) {
					if (isFirst == true) {
						whichPlayer = "You";
						int coords[] = input(UserLetter, 0, 0, true);
						board[coords[0] - 1][coords[1] - 1] = UserLetter;

					} else {
						whichPlayer = "Computer";
						int coords[] = { 0, 0 };
						if (whichLevel == 1) {
							// code for easy level
							coords = easyLevel();

						} else if (whichLevel == 2) {
							// code for medium level
						} else if (whichLevel == 3) {
							// code for hard level
						}
						board[coords[0] - 1][coords[1] - 1] = AIletter;

						printBoard();
						System.out.println("AI played");
					}
				} else {
					if (isFirst == false) {
						whichPlayer = "You";
						int coords[] = input(UserLetter, 0, 0, true);
						board[coords[0] - 1][coords[1] - 1] = UserLetter;
						printBoard();

					} else {
						whichPlayer = "Computer";
						int coords[] = { 0, 0 };
						if (whichLevel == 1) {
							// code for easy level
							coords = easyLevel();

						} else if (whichLevel == 2) {
							// code for medium level
						} else if (whichLevel == 3) {
							// code for hard level
						}
						board[coords[0] - 1][coords[1] - 1] = AIletter;
						System.out.println("AI turn");
						printBoard();
						System.out.println("AI played");
					}
				}

				if (containsSpaces(board[0]) == false && containsSpaces(board[1]) == false
						&& containsSpaces(board[2]) == false) {
					printBoard();

					System.out.println("draw");
					System.exit(0);
				}

				if (isWinningBoard(board[0], board[1], board[2]) == true) {

					System.out.println("new game board");
					printBoard();
					System.out.println(whichPlayer + " won");

					System.exit(0);
				}
				i++;
			}

		}

	}

	// checks if it is a winning board
	public static boolean isWinningBoard(char[] xo1, char[] xo2, char[] xo3) {
		if (xo1[0] == xo1[1] && xo1[0] == xo1[2] && xo1[1] == xo1[2] && containsSpaces(xo1) == false) {

			return true;
		}
		if (xo2[0] == xo2[1] && xo2[0] == xo2[2] && xo2[1] == xo2[2] && containsSpaces(xo2) == false) {

			return true;

		}
		if (xo3[0] == xo3[1] && xo3[0] == xo3[2] && xo3[1] == xo3[2] && containsSpaces(xo3) == false) {

			return true;
		}
		if (xo1[2] == xo2[2] && xo1[2] == xo3[2] && xo2[2] == xo3[2] && xo1[2] != ' ' && xo2[2] != ' '
				&& xo3[2] != ' ') {

			return true;
		}
		if (xo1[1] == xo2[1] && xo1[1] == xo3[1] && xo2[1] == xo3[1] && xo1[1] != ' ' && xo2[1] != ' '
				&& xo3[1] != ' ') {

			return true;
		}
		if (xo1[0] == xo2[0] && xo1[0] == xo3[0] && xo2[0] == xo3[0] && xo1[0] != ' ' && xo2[0] != ' '
				&& xo3[0] != ' ') {

			return true;
		}
		if (xo1[0] == xo2[1] && xo1[0] == xo3[2] && xo2[1] == xo3[2] && xo1[0] != ' ' && xo2[1] != ' '
				&& xo3[2] != ' ') {

			return true;
		}
		if (xo1[2] == xo2[1] && xo1[2] == xo3[0] && xo2[1] == xo3[0] && xo1[2] != ' ' && xo2[1] != ' '
				&& xo3[0] != ' ') {

			return true;
		}
		return false;
	}

	public static boolean containsSpaces(char array[]) {
		for (char c : array) {
			if (c == ' ') {
				return true;
			}
		}
		return false;

	}

// takes input from the user. If the input is not correct, recurs the method
	public static int[] input(char oOrx, int player, int whichPlayer, boolean isAI) {
		boolean isIncorrect = true;
		while (isIncorrect == true) {
			if (isAI == false) {
				if (i % 2 == 0) {

					whichPlayer = 1;
					if (player == 1) {
						oOrx = 'x';

					} else {
						oOrx = 'o';
					}

				} else {

					whichPlayer = 2;
					if (player == 2) {
						oOrx = 'x';
					} else {
						oOrx = 'o';
					}
				}
			}

			Scanner scan = new Scanner(System.in);
			String coordinate = scan.nextLine();
			coordinate.replaceAll(" ", "");
			if (coordinate.length() > 3) {
				System.out.println("This input is not formated correctly");
				continue;
			}

			try {
				int coords[] = { Integer.parseInt(String.valueOf(coordinate.charAt(0))),
						Integer.parseInt(String.valueOf(coordinate.charAt(2))) };
			} catch (Exception e) {

				System.out.println("This input needs to be like the example. Try again");
				continue;
			}
			int coords[] = { Integer.parseInt(String.valueOf(coordinate.charAt(0))),
					Integer.parseInt(String.valueOf(coordinate.charAt(2))) };

			if (board[coords[0] - 1][coords[1] - 1] == 'x' || board[coords[0] - 1][coords[1] - 1] == 'o') {
				System.out.println("This space is occupied. Try again");
				continue;
			}

			if (coords[0] > 3 || coords[0] > 3) {
				System.out.println("These coordinates are off the board. try again");
				continue;
			}
			board[coords[0] - 1][coords[1] - 1] = oOrx;
			printBoard();
			return coords;
		}
		System.out.println("type a coordinate less then three. ex: 3,1");
		return null;

	}

	public static int[] coordsToBlock(char Userletter, char AIletter) {
		int[] blockingCoords = { -1, -1 };
		for (int i = 0; i < winningScenarios.length; i++) {
			int countOfUserLetter = 0;
			int countOfSpaces = 0;
			for (int j = 0; j < 3; j++) {
				int xcoord = Integer.parseInt(Character.toString(winningScenarios[i][j].charAt(0))) - 1;
				int ycoord = Integer.parseInt(Character.toString(winningScenarios[i][j].charAt(1))) - 1;
				if (board[xcoord][ycoord] == Userletter) {
					countOfUserLetter++;
				} else if (board[xcoord][ycoord] == ' ') {
					countOfSpaces++;
				}
			}
			if (countOfUserLetter == 2 && countOfSpaces == 1) {
				for (int j = 0; j < 3; j++) {
					if (board[Integer.parseInt(Character.toString(winningScenarios[i][j].charAt(0))) - 1]
							[Integer.parseInt(Character.toString(winningScenarios[i][j].charAt(1))) - 1] == ' ') {
                            blockingCoords[0] = Integer.parseInt(Character.toString(winningScenarios[i][j].charAt(0))) - 1;
                            blockingCoords[1] = j;
                            return blockingCoords;
					}
				}
			}
		}
		return blockingCoords;
	}
	
	public static int[] coordsToWin(char Userletter, char AIletter) {
		int[] winningCoords = { -1, -1 };
		for (int i = 0; i < winningScenarios.length; i++) {
			int countOfAIletter = 0;
			int countOfSpaces = 0;
			for (int j = 0; j < 3; j++) {
				int xcoord = Integer.parseInt(Character.toString(winningScenarios[i][j].charAt(0))) - 1;
				int ycoord = Integer.parseInt(Character.toString(winningScenarios[i][j].charAt(1))) - 1;
				if (board[xcoord][ycoord] == AIletter) {
					countOfAIletter++;
				} else if (board[xcoord][ycoord] == ' ') {
					countOfSpaces++;
				}
			}
			if (countOfAIletter == 2 && countOfSpaces == 1) {
				for (int j = 0; j < 3; j++) {
					if (board[Integer.parseInt(Character.toString(winningScenarios[i][j].charAt(0))) - 1]
							[Integer.parseInt(Character.toString(winningScenarios[i][j].charAt(1))) - 1] == ' ') {
                            winningCoords[0] = Integer.parseInt(Character.toString(winningScenarios[i][j].charAt(0))) - 1;
                            winningCoords[1] = j;
                            return winningCoords;
					}
				}
			}
		}
		return winningCoords;
	}

	public static int[] easyLevel() {
		int coords[] = { 0, 0 };
		boolean isOccupied = true;
		while (isOccupied == true) {
			coords[0] = new Random().nextInt(3) + 1;
			coords[1] = new Random().nextInt(3) + 1;

			if (board[coords[0] - 1][coords[1] - 1] != ' ') {
				continue;
			}
			isOccupied = false;
		}

		return coords;
	}
	public static int[] mediumLevel(char UserLetter, char AIletter) {
		int coords[] = { 0, 0 };
		
		coordsToBlock(UserLetter, AIletter);
		return coords;
	}
	public static void printBoard() {
		System.out.println(" 1   2   3");
		System.out.println("1 " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
		System.out.println("2 " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
		System.out.println("3 " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
	}

}
