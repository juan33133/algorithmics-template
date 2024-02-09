package s0.a1;

public class JavaA1v0 {

	public static void main(int []args) {
		int n = args[0];
		double t1 = System.currentTimeMillis(); 
		primoA1(n);
		double t2 = System.currentTimeMillis();
		System.out.println("n ="+n+ "***" + (1000*(t2-t1)) + "milliseconds");
	}
	
	
	public static boolean primoA1(int number) {
		boolean p = true; 
		for(int i=2 ; i<number ; i++) {
			if (number % i == 0 ) {
				p=false;
			}
		}
		return p;
	}
}
