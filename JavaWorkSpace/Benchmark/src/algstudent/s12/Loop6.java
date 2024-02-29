package algstudent.s12;

public class Loop6 {

	/**
	 * 
	 * @param n
	 * 
	 * complexity = 
	 * O(n^3 * log n)
	 * 
	 * @return
	 */
	public static long loop6(int n) {
		long cont = 0;
		long n3 = n*n*n;
		for (int i = 1; i <= n3; i++) {
			cont++;
			i*=10;
		}
		return cont;

	}

	public static void main(String arg[]) {
		long c = 0;
		long t1, t2;

		int nTimes = Integer.parseInt(arg[0]);

		System.out.println("n\ttime\trepetions\tcounter");

		for (int n = 100; n <= 819200; n *= 2) {
			t1 = System.currentTimeMillis();

			for (int repetitions = 1; repetitions <= nTimes; repetitions++)
				c = loop6(n);

			t2 = System.currentTimeMillis();

			System.out.println(n + "\t" + (t2 - t1) + "\t" + nTimes + "\t\t" + c);
		} // for
	} // main
}
