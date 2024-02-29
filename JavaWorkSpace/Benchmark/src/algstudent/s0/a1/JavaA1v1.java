package algstudent.s0.a1;

import java.util.ArrayList;

public class JavaA1v1 {

	
	public static void main(int []args) {
		int n = 1000;
		double t1 = System.currentTimeMillis(); 
		listadoPrimos(n);
		double t2 = System.currentTimeMillis();
		System.out.println("n ="+n+ "***" + (1000*(t2-t1)) + "milliseconds");
	}
	
	public static ArrayList<Integer> listadoPrimos(int size) {
		ArrayList<Integer> primes = new <Integer> ArrayList<Integer>(); 
		
		for(int i=2; i<size+1; i++) {
			if(JavaA1v0.primoA1(i)) {
				primes.add(i);
			}

		}
		return primes;
	}
}
