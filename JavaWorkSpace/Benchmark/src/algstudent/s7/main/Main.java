package algstudent.s7.main;

import algstudent.s7.numericalSquare.NumericalSquare;

public class Main {

	public static void main(String[] arg) {
		int repetitions = 1;
		
		NumericalSquare n = new NumericalSquare();
		n.numericalSquareBranchAndBound();
		
		System.out.println(n.toString());
		double t1 = System.currentTimeMillis();
		System.out.println(); 
		
		double t2 = System.currentTimeMillis(); 
		System.out.println(t2 - t1);
	}
}
