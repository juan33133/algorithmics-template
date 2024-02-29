package algstudent.s12;

public class Loop7 {

	/**
	 * 
	 * @param n
	 * 
	 * complexity = 
	 * n^4
	 * 
	 * @return
	 */
	public static long loop7(int n) {
		long cont = 0;
		long n2= n*n;
		
		for (int i = 1; i <= n2 * n2; i++)
			cont++;
		
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
				c = loop7(n);

			t2 = System.currentTimeMillis();

			System.out.println(n + "\t" + (t2 - t1) + "\t" + nTimes + "\t\t" + c);
		} // for
	} // main
}
