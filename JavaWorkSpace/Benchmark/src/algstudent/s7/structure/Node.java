package algstudent.s7.structure;

import java.util.ArrayList;

public class Node {
	private String[][] board;
	private int lastEl = Board.getLastEl();

	public int row;
	public int col;
	private boolean[][] rowColSol;
	private int heuristic;

	public Node(Board board) {
		this.board = board.getBoard();
		this.row = -2;
		this.col = lastEl;
		rowColSol = new boolean[2][lastEl + 1];
		computeHeuristic();
	}

	public Node(String[][] board, int row, int col, int heuristic) {
		this.board = new String[board.length][];
		for (int i = 0; i < board.length; i++) {
			this.board[i] = board[i].clone();
		}

		this.row = row;
		this.col = col;
		this.heuristic = heuristic;
		rowColSol = new boolean[2][lastEl + 1];
		updateHeuristic();
	}

	public Node(String[][] board, int row, int col, int val, int heuristic) {
		this.board = new String[board.length][];
		for (int i = 0; i < board.length; i++) {
			this.board[i] = board[i].clone();
		}

		this.row = row;
		this.col = col;
		this.heuristic = heuristic;
		this.board[row][col] = String.valueOf(val);
		rowColSol = new boolean[2][lastEl + 1];
		updateHeuristic();
	}

	public ArrayList<Node> expand() {
		ArrayList<Node> children = new ArrayList<>();

		int[] newPos = newPos(row, col);

		while (Board.given[newPos[0]][newPos[1]]) {
			newPos = newPos(newPos[0], newPos[1]);
		}

		for (int i = 0; i < 10; i++) {
			children.add(new Node(board, newPos[0], newPos[1], i, heuristic));
		}

		return children;
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

	public int getHeuristicValue() {
		return this.heuristic;
	}

	public int initialValuePruneLimit() {
		return lastEl * 2;
	}

	/**
	 * return the sum of the differences for all the rows and cols of the matrix
	 */
	private void computeHeuristic() {
		int numberOfSolutions = 0;
		for(int i = 0; i<= lastEl; i+=2) {
			numberOfSolutions++;
		}
		int heuristic =  numberOfSolutions * 2;
		
		for (int i = 0; i <= lastEl; i += 2) {
			if (rowDiff(i) == 0) {
				heuristic--;
				rowColSol[0][i] = true;
			}
			if (colDiff(i) == 0) {
				heuristic--;
				rowColSol[0][i] = true;
			}

		}
		this.heuristic = heuristic;
	}

	private void updateHeuristic() {
		// if the row is right
		if (rowDiff(row) == 0) {
			// if it wasn't right at first
			if (!rowColSol[0][row]) {
				rowColSol[0][row] = true;
				heuristic--;
			}
		} else {
			if (rowColSol[0][row]) {
				rowColSol[0][row] = false;
				heuristic++;
			}
		}
		// if the col is right
		if (colDiff(col) == 0) {
			// if it wasn't right at first
			if (!rowColSol[1][col]) {
				rowColSol[1][col] = true;
				heuristic--;
			}
			// if the col is wrong
		} else {
			// if it was right before
			if (rowColSol[1][col]) {
				rowColSol[1][col] = false;
				heuristic++;
			}
		}
	}

	public boolean isValid() {

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

	private int rowDiff(int row) {
		int rowSol = Integer.valueOf(board[row][board.length - 1]);
		return numericLine(lastEl, board[row]) - rowSol;
	}

	private int colDiff(int col) {
		int colSol = Integer.valueOf(board[board.length - 1][col]);
		return numericLine(lastEl, getColString(col)) - colSol;
	}

	private String[] getColString(int pos) {
		String[] col = new String[lastEl + 1];
		for (int i = 0; i <= lastEl; i++) {
			col[i] = board[i][pos];
		}
		return col;
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				sb.append(board[i][j]);
				sb.append("\t");
			}
			sb.append("\n");
		}

		return sb.toString();
	}

	public boolean isSolution() {
		return col == lastEl || row == lastEl;
	}
}
