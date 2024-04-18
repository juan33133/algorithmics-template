package algstudent.s6;

public class Main {

	public static void main(String[] arg) {
		int repetitions = 1;
		
		NumericalSquare n = new NumericalSquare();
		System.out.println(n.toString());
		double t1 = System.currentTimeMillis();
		for(int i =0 ; i < repetitions ; i++) {
			n= new NumericalSquare();
			n.NumericSquareOne();
		}
		
		double t2 = System.currentTimeMillis(); 
		System.out.println(n.toString());
		System.out.println(t2 - t1);
	}
}
