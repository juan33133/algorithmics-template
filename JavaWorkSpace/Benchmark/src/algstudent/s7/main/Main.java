package algstudent.s7.main;

import algstudent.s7.numericalSquare.NumericalSquareBranchAndBound;

public class Main {

	public static void main(String[] arg) {
		NumericalSquareBranchAndBound n = new NumericalSquareBranchAndBound();
		
		double t1 = System.currentTimeMillis();
		n.branchAndBound();
		double t2 = System.currentTimeMillis(); 
		System.out.println(t2 - t1);
	}
}
