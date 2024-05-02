package algstudent.Test.numericalSquare;

import java.util.ArrayList;

import algstudent.Test.structure.Board;

public class NumericalSquare {
	private Board square;

	private ArrayList<String> solutions = new ArrayList<>();
	private int numberOfSolutions = 0;

	private String[][] board;
	private boolean[][] given;
	private boolean solved;
	private int lastEl;

	public NumericalSquare(Board board) {
		square = board;
		board.clearBoard();
		this.board = board.getBoard();
		this.given = board.getGiven();
		lastEl = this.board.length - 3;
	}

	public void backtracking() {
		solver(0, 0);

		if (!solved) {
			System.out.println("Ended without solution");
		}
	}

	private String getSerializedSol() {
		String out = "";
		for (int i = 0; i <= lastEl; i += 2) {
			for (int j = 0; j <= lastEl; j += 2) {
				out += board[i][j];
			}
		}
		return out;
	}

	private void solver(int row, int col) {
		if (row > lastEl) {
			solved = isBoardSolved();
			if (solved) {
				String sol = getSerializedSol();
				if (!solutions.contains(sol)) {
					solutions.add(sol);
					numberOfSolutions++;
					System.out.println(numberOfSolutions);
					System.out.println(square.toString());
					solved = false;
				}}
				return;
			}
			int[] newPos = newPos(row, col);

			if (given[row][col]) {
				solver(newPos[0], newPos[1]);
			} else {
				int i = -5;
				while (i < 6 && !solved) {

					board[row][col] = String.valueOf(i);
					if (isValid(row, col)) {
						solver(newPos[0], newPos[1]);
					}
					i++;
				}
			}
		

	}

	private boolean isValid(int row, int col) {
		int solvedRow = numericLine(col, board[row]);
		if (col == lastEl) {
			int rowSol = Integer.valueOf(board[row][board.length - 1]);
			return rowSol == solvedRow;
		}

		int solvedCol = numericLine(row, getColString(col));
		if (row == lastEl) {
			int colSol = Integer.valueOf(board[board.length - 1][col]);
			return colSol == solvedCol;
		}

		int dividedByZero = 1000000;
		return ((Math.abs(solvedRow) < dividedByZero) && (Math.abs(solvedCol) < dividedByZero));

	}

	private int diagonalSum() {
		int sum = 0;
		for (int i = 0; i <= lastEl; i += 2) {
			sum += Integer.valueOf(board[i][i]);
		}
		return sum;
	}

	private boolean isBoardSolved() {
		for (int diagonal = 0; diagonal <= lastEl; diagonal += 2) {
			int colSol = Integer.valueOf(board[board.length - 1][diagonal]);
			int rowSol = Integer.valueOf(board[diagonal][board.length - 1]);

			int solvedDiagonal = diagonalSum();
			int solvedRow = numericLine(lastEl, board[diagonal]);
			int solvedCol = numericLine(lastEl, getColString(diagonal));

			boolean rightSol = ((colSol == solvedCol) && (rowSol == solvedRow) && (solvedDiagonal == 0));
			if (!rightSol) {
				return false;
			}
		}
		return true;
	}

	private String[] getColString(int pos) {
		String[] col = new String[lastEl + 1];
		for (int i = 0; i <= lastEl; i++) {
			col[i] = board[i][pos];
		}
		return col;
	}

	private int[] newPos(int row, int col) {
		int[] newPos = new int[2];
		if (col < lastEl) {
			newPos[0] = row;
			newPos[1] = col + 2;
		} else {
			newPos[0] = row + 2;
			newPos[1] = 0;
		}
		return newPos;

	}

	private int numericLine(int index, String[] arr) {
		int val = Integer.valueOf(arr[index]);

		if (index == 0) {
			return val;
		}

		if (arr[index - 1].equals("/")) {
			if (val != 0) {
				int numerator = numericLine(index - 2, arr);
				if (numerator % val == 0) {
					return numerator / val;
				}
			}
			return Integer.MAX_VALUE;

		} else if (arr[index - 1].equals("*")) {
			return numericLine(index - 2, arr) * val;
		} else if (arr[index - 1].equals("+")) {
			return numericLine(index - 2, arr) + val;
		} else if (arr[index - 1].equals("-")) {
			return numericLine(index - 2, arr) - val;
		}

		return val;
	}
}