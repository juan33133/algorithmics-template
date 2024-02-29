package algstudent.s0.a1;

import java.util.ArrayList;

public class JavaA1 {
	
	static int n = 10000;
	public static void main(String[] args) {
		for (int i=0; i<7 ; i++) {
			double t1=0; 
			double t2=0; 
			t1=System.currentTimeMillis();
			ArrayList <Integer> primes = JavaA1v1.listadoPrimos(n);
			t2 = System.currentTimeMillis();
			
			System.out.println("n =" + n + "***" + "time =" + ((t2 - t1)/1000) + "seconds)");
			
			n*=2;
		
		}
	}
}
