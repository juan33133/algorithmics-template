package algstudent.s6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NumericalSquare {

	private String[][] square;
	private boolean[][] board;
	private int lastEl = 0;

	public NumericalSquare() {
		this.square = read();
		lastEl = square.length - 3;
		removeQuestionMarks();
	}

	private void removeQuestionMarks() {
		for (int size = 0; size <= lastEl; size += 2) {
			numericCol(lastEl, size);
			numericRow(size, lastEl);
		}
	}

	public String[][] NumericSquareOne() {

		numericSquareOne();
		return square;
	}

	private void numericSquareOne() {
		boolean solvable = true;
		while (!isValid() && solvable) {
			solvable = addOne(lastEl, lastEl);
		}

	}

	private boolean isValid() {
		for (int size = lastEl; size >= 0; size -= 2) {

			int colSol = Integer.valueOf(square[square.length - 1][size]);
			int rowSol = Integer.valueOf(square[size][square.length - 1]);

			int solvedCol = numericCol(lastEl, size);

			if (solvedCol != colSol) {
				return false;
			}

			int solvedRow = numericRow(size, lastEl);

			if (solvedRow != rowSol) {
				return false;
			}
		}

		return true;
	}

	private boolean addOne(int row, int col) {
		int rVal;

		rVal = Integer.valueOf(square[row][col]);

		// It is not in the board given
		if (!board[row][col]) {
			// the value of the cell its lower than 9
			if (rVal < 9) {
				square[row][col] = String.valueOf(rVal + 1);
				return true;
			}

			// the value of the cell is equal to 9
			// is the first element of the row
			if (col == 0) {
				// is the first row of the matrix
				if (row == 0) {
					return false;
				}
				if (addOne(row - 2, lastEl)) {
					square[row][col] = "0";
					return true;
				}

			} else if (addOne(row, col - 2)) {
				square[row][col] = "0";
				return true;
			}
			return false;

		}
		// is in the board given
		if (col == 0) {
			if (row == 0) {
				return false;
			}
			addOne(row - 2, lastEl);
		} else {
			return (addOne(row, col - 2));
		}
		return false;

	}

	private int numericRow(int row, int j) {
		int val;
		if (square[row][j].equals("?")) {
			square[row][j] = "0";
			val = 0;
		} else {
			val = Integer.valueOf(square[row][j]);
		}

		if (j == 0) {
			return val;
		}

		if (square[row][j - 1].equals("/")) {
			if (val == 0) {
				return Integer.MAX_VALUE;
			} else {
				return numericRow(row, j - 2) / val;
			}

		} else if (square[row][j - 1].equals("*")) {
			return val * numericRow(row, j - 2);
		} else if (square[row][j - 1].equals("+")) {
			return val + numericRow(row, j - 2);
		} else if (square[row][j - 1].equals("-")) {
			return numericRow(row, j - 2) - val;
		}

		return val;
	}

	private int numericCol(int i, int col) {

		int val;
		if (square[i][col].equals("?")) {
			val = 0;
			square[i][col] = "0";
		} else {
			val = Integer.valueOf(square[i][col]);
		}

		if (i == 0) {
			return val;
		}

		if (square[i - 1][col].equals("/")) {
			if (val == 0) {
				return Integer.MAX_VALUE;
			} else {
				return numericCol(i - 2, col) / val;

			}
		} else if (square[i - 1][col].equals("*")) {
			return val * numericCol(i - 2, col);
		} else if (square[i - 1][col].equals("+")) {
			return val + numericCol(i - 2, col);
		} else if (square[i - 1][col].equals("-")) {
			return numericCol(i - 2, col) - val;
		}

		return val;
	}

	public String[][] read() {
		String[][] board = null;
		try {
			String fileName = "src/algstudent/s6/test02.txt";
			BufferedReader reader = new BufferedReader(new FileReader(fileName));

			String line;
			String[] elements;

			int size = Integer.valueOf(reader.readLine().strip());
			size = size * 2 + 1;

			board = new String[size][size];
			this.board = new boolean[size][size];

			int row = 0;

			while ((line = reader.readLine()) != null) {

				elements = line.split(" ");
				if (row % 2 == 0 && row != size - 1) {
					for (int i = 0; i < elements.length; i++) {
						board[row] = elements;
						if (i % 2 == 0) {
							if (!elements[i].equals("?")) {
								this.board[row][i] = true;
							}
						}
					}

				} else {
					int i = 0;
					for (int col = 0; col < size - 1; col += 2) {

						board[row][col + 1] = " ";
						board[row][col + 2] = " ";

						if (i < elements.length) {
							board[row][col] = elements[i];
							i += 1;
						}

					}

				}
				row++;

			}

			reader.close();

			return board;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return board;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square[i].length; j++) {
				sb.append(square[i][j]);
				sb.append("\t");
			}
			sb.append("\n");
		}

		return sb.toString();
	}
}