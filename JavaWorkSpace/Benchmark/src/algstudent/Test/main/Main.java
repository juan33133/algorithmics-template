package algstudent.Test.main;

import algstudent.Test.numericalSquare.NumericalSquare;
import algstudent.Test.structure.Board;

public class Main {

	public static void main(String[] arg) {
		Board board = new Board();
		System.out.println(board.toString());
		NumericalSquare n = new NumericalSquare(board);
		
		double t1 = System.currentTimeMillis();
		
		n.backtracking();
		
		double t2 = System.currentTimeMillis(); 
		System.out.println(board.toString()); 
		System.out.println(t2 - t1);
	}
}
