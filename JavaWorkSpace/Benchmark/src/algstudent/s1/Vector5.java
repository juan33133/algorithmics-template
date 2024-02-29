package algstudent.s1;

public class Vector5 {
	static int[] u;
	static int[] v;

	public static void main(String arg[]) {
		int repetitions = 1000;
		long t1, t2;
		int sum = 0;

		for (int n = 10000; n <= Integer.MAX_VALUE; n *= 2) { // n is increased *5

			u = new int[n];
			v = new int[2];
			Vector1.fillIn(u);

			t1 = System.currentTimeMillis();
			// We have to repeat the whole process to be measured
			for (int repetition = 1; repetition <= repetitions; repetition++) {
				Vector1.maximum(u,v);
			}
			t2 = System.currentTimeMillis();
			System.out.printf("SIZE=%d TIME=%d milliseconds SUM=%d NTIMES=%d\n", n, (t2 - t1), sum, repetitions);
		} // for

	}// main

}
