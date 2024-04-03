package algstudent.s3;

public class Division5 {

	public static long rec5(double n) {
		long cont = 0;
		double b = 2;
		if (n <= 1)
			cont++;
		else {
			cont++; // O(1)
			for (int i = 0; i < 4; i++) {
				rec5(n / b);
			}

		}
		return cont;
	}

	public static void main(String arg[]) {
		long t1, t2, cont = 0;
		for (int n = 1000; n <= 10000000; n *= 2) {
			t1 = System.currentTimeMillis();

			cont = rec5(n);

			t2 = System.currentTimeMillis();

			System.out.println("n=" + n + "**TIME=" + (t2 - t1) + "**cont=" + cont);
		} // for
	} // main
}
