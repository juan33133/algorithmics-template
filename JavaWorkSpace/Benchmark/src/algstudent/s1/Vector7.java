package algstudent.s1;

public class Vector7 {


	static int[] v; //vector of elements
	static int[] w; //another vector of elements
	
	public static void main(String arg[]) {
		int repetitions = 10000;
		long t1, t2;

		for (int n = 10000; n <= Integer.MAX_VALUE; n *= 2) { // n is increased *5

			w = new int[n];
			v = new int[n];
			Vector1.fillIn(w);
			Vector1.fillIn(v);
			
			t1 = System.currentTimeMillis();
			// We have to repeat the whole process to be measured
			for (int repetition = 1; repetition <= repetitions; repetition++) {
				Vector1.matches2(w, v);
			}
			t2 = System.currentTimeMillis();
			System.out.printf("SIZE=%d TIME=%d milliseconds NTIMES=%d\n", n, (t2 - t1), repetitions);
		} // for

	}// main
}
