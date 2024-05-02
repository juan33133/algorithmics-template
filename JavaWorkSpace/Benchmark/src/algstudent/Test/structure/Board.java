package algstudent.Test.structure;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Board {
	private String[][] board;
	public static boolean[][] given;
	private int lastEl;

	public Board() {
		this.board = read();
		lastEl = board.length - 3;
	}
	
	public String [][] getBoard(){
		return this.board;
	}
	
	public boolean[][] getGiven() {
		return given;
	}
	
	public void clearBoard() {
		for (int row = 0; row <= lastEl; row += 2) {
			for (int col = 0; col <= lastEl; col += 2) {

				if (board[row][col].equals("?")) {
					board[row][col] = "0";
				}
			}
		}
	}

	private static String[][] read() {
		String[][] board = null;
		try {
			String fileName = "src/algstudent/Test/test/test02.txt";
			BufferedReader reader = new BufferedReader(new FileReader(fileName));

			String line;
			String[] elements;

			int size = Integer.valueOf(reader.readLine().strip());
			size = size * 2 + 1;

			board = new String[size][size];
			given = new boolean[size][size];
			int row = 0;

			while ((line = reader.readLine()) != null) {

				elements = line.split(" ");
				if (row % 2 == 0 && row != size - 1) {
					for (int i = 0; i < elements.length - 2; i++) {
						board[row] = elements;
						if (i % 2 == 0) {
							if (!elements[i].equals("?")) {
								given[row][i] = true;
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
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				sb.append(board[i][j]);
				sb.append("\t");
			}
			sb.append("\n");
		}

		return sb.toString();
	}

}
