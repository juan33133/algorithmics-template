package algstudent.s5;

public class Matches {

	private boolean[][] matches;

	private char sequence = '*';
	private char anyChar = '?';

	private boolean[][] build(char[] text, char[] pattern) {
		int rows = text.length + 1;
		int cols = pattern.length + 1;
		boolean[][] board = new boolean[rows + 1][cols + 1];

		board[0][0] = true;

		for (int j = 1; j < cols; j++) {
			for (int i = 1; i < rows; i++) {
				// when * & 
				if (pattern[j - 1] == sequence && (board[i - 1][j - 1] || board[i - 1][j])) {
					board[i - 1][j] = true;
					board[i][j] = true;
				} else if (pattern[j - 1] == anyChar && (board[i - 1][j - 1] ||  board[i - 1][j])) {
					board[i - 1][j] = true;
					board[i][j] = true;
				} else if ((pattern[j - 1] == text[i - 1]) && board[i - 1][j - 1]) {
					board[i][j] = true;
				}
			}
		}
		return board;
	}

	public boolean matches(char[] text, char[] pattern) {
		matches = build(text, pattern);
		int rows = text.length;
		int cols = pattern.length;

		return (matches[rows][cols]);
	}

	public String toString(char[] text, char[] pattern) {
		StringBuilder sb = new StringBuilder();
		sb.append(" ");

		for (int i = 0; i <= text.length; i++) {
			for (int j = 0; j <= pattern.length; j++) {
				if (i == 0 && j == 0) {
					sb.append("");
				} else if (i == 0) {
					sb.append(pattern[j - 1]);
					
				} else if (j == 0) {
					sb.append(text[i - 1]);
				}else{
					if(matches[i][j]) {
						sb.append("T");
					}else {
						sb.append(" ");// easier to read than using "F"
					}
					
				}
				sb.append(" ");
			}
			sb.append("\n");

		}

		return sb.toString();
	}

}
