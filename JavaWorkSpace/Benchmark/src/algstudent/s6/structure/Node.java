package algstudent.s6.structure;

import java.util.ArrayList;

public class Node {
	private String[][] board;

	public int val;
	public int row;
	public int col;
	private int heuristic;

	public Node(Board board) {
		this.board = board.getBoard();
		this.row = 0;
		this.col = 0;
		computeHeuristic();
	}

	public Node(String[][] board, int row, int col) {
		this.board = board;
		this.row = row;
		this.col = col;
		computeHeuristic();
	}

	public Node(String[][] board, int row, int col, int val) {
		this.board = board;
		this.row = row;
		this.col = col;
		this.board[row][col] = String.valueOf(val);
		computeHeuristic();
	}
	
	public ArrayList<Node> expand() {
		ArrayList<Node> children = new ArrayList<>();
		
		
		if (Board.given[row][col]) {
			children.add(new Node(board, row, col + 2));
		}

		return children;
	}

	public int getHeuristicValue() {
		return this.heuristic;
	}

	public int initialValuePruneLimit() {
		return heuristic;
	}
	
	public boolean isSolution() {
		return this.heuristic == 0;
	}

	private void computeHeuristic() {
		int heuristic = 0;
		for (int i = 0; i < board.length; i += 2) {
			heuristic += rowDiff(i) + colDiff(i);
		}
		this.heuristic = heuristic;
	}

	private int rowDiff(int row) {
		int lastEl = board.length - 3;
		int rowSol = Integer.valueOf(board[row][board.length - 1]);
		return Math.abs(numericRow(row, lastEl) - rowSol);
	}

	private int colDiff(int col) {
		int lastEl = board.length - 3;
		int colSol = Integer.valueOf(board[col][board.length - 1]);
		return Math.abs(numericCol(lastEl, col) - colSol);
	}

	private int numericRow(int row, int j) {
		int val;

		val = Integer.valueOf(board[row][j]);

		if (j == 0) {
			return val;
		}

		if (board[row][j - 1].equals("/")) {
			if (val == 0) {
				return Integer.MAX_VALUE;
			} else {
				return numericRow(row, j - 2) / val;
			}

		} else if (board[row][j - 1].equals("*")) {
			return val * numericRow(row, j - 2);
		} else if (board[row][j - 1].equals("+")) {
			return val + numericRow(row, j - 2);
		} else if (board[row][j - 1].equals("-")) {
			return numericRow(row, j - 2) - val;
		}

		return val;
	}

	private int numericCol(int i, int col) {

		int val;
		val = Integer.valueOf(board[i][col]);

		if (i == 0) {
			return val;
		}

		if (board[i - 1][col].equals("/")) {
			if (val == 0) {
				return Integer.MAX_VALUE;
			} else {
				return numericCol(i - 2, col) / val;

			}
		} else if (board[i - 1][col].equals("*")) {
			return val * numericCol(i - 2, col);
		} else if (board[i - 1][col].equals("+")) {
			return val + numericCol(i - 2, col);
		} else if (board[i - 1][col].equals("-")) {
			return numericCol(i - 2, col) - val;
		}

		return val;
	}
}
