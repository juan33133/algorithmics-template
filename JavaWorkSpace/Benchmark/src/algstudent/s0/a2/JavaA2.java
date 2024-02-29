package algstudent.s0.a2;

import java.awt.image.SampleModel;
import java.util.ArrayList;

public class JavaA2 {
	static int n = 10000;

	public static void main(String[] args) {
		double t1 = 0;
		double t2 = 0;
		for (int casos = 0; casos < 7; casos++) {
			t1 = System.currentTimeMillis();
			ArrayList<Integer> primes = listadoPrimos(n);
			t2 = System.currentTimeMillis();
			
			System.out.println("n =" + n + "***" + "time =" + ((t2 - t1)/1000) + "milliseconds)");
			
			n*=2;
		
		}

	}

	private static ArrayList<Integer> listadoPrimos(int n) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i = 2; i < n + 1; i++) {
			if (primoA2(i)) {
				primes.add(i);
			}
		}

		return primes;
	}

	private static boolean primoA2(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
