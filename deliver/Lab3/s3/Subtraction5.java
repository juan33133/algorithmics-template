package algstudent.s3;

public class Subtraction5 {

	// O(3^(n/2))
	private static long rec5(int n) {
		
		return rec52(n /2);
	}
	private static long rec52(int n) {
		long cont = 0;
		if (n <= 0)
			cont++;
		else {
			cont++; // O(1)
			rec52(n - 1);
			rec52(n - 1);
			rec52(n - 1);
		}
		return cont;
	}

	public static void main(String arg[]) {
		long t1, t2, cont = 0;
		for (int n = 30; n <= 100000000; n+=2) {
			t1 = System.currentTimeMillis();

			cont = rec5(n);

			t2 = System.currentTimeMillis();

			System.out.println("n=" + n + "**TIME=" + (t2 - t1) + "**cont=" + cont);
		}
	}
}
