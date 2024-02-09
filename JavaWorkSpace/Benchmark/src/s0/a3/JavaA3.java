package s0.a3;

import java.util.ArrayList;

public class JavaA3 {

	private static ArrayList<Integer> primes = new ArrayList<Integer>();

	public static void main(String[] args) {

		int n = 10_000;
		double t1 = 0;
		double t2 = 0;

		for (int casos = 0; casos < 7; casos++) {
			t1 = System.currentTimeMillis();
			primes = listadoPrimos(n);
			t2 = System.currentTimeMillis();
			System.out.println("n =" + n + "***" + "time =" + ((t2 - t1)/1000) + "milliseconds)");
			n = n*2;

		}
	}

	private static ArrayList<Integer> listadoPrimos(int n) {

		for (int i = 2; i < n + 1; i++) {
			if (primoA3(i)) {
				primes.add(i);
			}
		}

		return primes;
	}

	private static boolean primoA3(int m) {
		
		
		for (int i = 2; i < m/2+1; i++) {
			if (m % i == 0) {
				return false;
			}
		}

		return true;
	}
}
