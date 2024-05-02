package algstudent.s5;

public class Main {

	public static void main (String[] arg) {
		Matches m = new Matches() ;
		char [] a = new String("cxxxttcxc").toCharArray();
		char [] b = new String("***??tc*****xc").toCharArray();
		
		m.matches(a,b);
		System.out.println(m.toString(a,b));
	}
}
