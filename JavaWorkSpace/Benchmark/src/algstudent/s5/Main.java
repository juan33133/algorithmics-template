package algstudent.s5;

public class Main {

	public static void main (String[] arg) {
		Matches m = new Matches() ;
		char [] a = {'c','a','a','o','e','a'};
		char [] b = {'c','a','*','a'};
		
		m.matches(a,b);
		System.out.println(m.toString(a,b));
	}
}
