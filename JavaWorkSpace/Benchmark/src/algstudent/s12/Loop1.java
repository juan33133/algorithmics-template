package algstudent.s12;

public class Loop1 {

	/**
	 * 
	 * @param n
	 * 
	 * complexity = 
	 * log3(n^2)  * (2/3) * n =
	 * O((4/3)n * log3(n))
	 * 
	 * @return
	 */
	public static long loop1(long n) {
		long cont = 0;
		long n1 = 1;
		while (n1 <= n * n) {
			for (long i = 1; i <= 2 * n; i += 3)
				cont++;
			n1 = 3 * n1;
		}
		return cont;
	}

	public static void main(String arg[]) {
		long t1, t2;
		int nTimes =10_000;

		System.out.println("n\ttime\trepetions\tcounter");

		for (long n = 100; n <= 819200; n *= 2) {
			long c = 0;
			t1 = System.currentTimeMillis();

			for (int repetitions = 1; repetitions <= nTimes; repetitions++)
				c = loop1(n);

			t2 = System.currentTimeMillis();

			System.out.println(n + "\t" + (t2 - t1) + "\t" + nTimes + "\t\t" + c);
		} // for
	} // main
	
} 