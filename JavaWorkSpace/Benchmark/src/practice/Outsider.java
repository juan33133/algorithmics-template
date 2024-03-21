package practice;

public class Outsider {

	int[] v;

	/**
	 * We start from a collection of ordered numbers, where each number appears
	 * exactly twice (except a number that will appear only once). Design a highly
	 * efficient algorithm to find the value that appears alone.
	 */
	public int outsider(int[] v) {
		return outsider(0, v.length - 1, v);
	}

	public int outsider(int left, int right, int[] v) {
		
		if (right == left) {
			return left;
		}
		
		int pos = (right + left) / 2;

		if (pos % 2 == 1) // is even
		{
			if (v[pos] == v[pos - 1]) {
				return outsider(pos +1, right, v);
			}else if (v[pos] == v[pos + 1]){
				return outsider(left , pos- 1, v);
			}else {
				return pos;
			}
		} else { // is odd
			if (v[pos] == v[pos -1]) {
				return outsider(left, pos-1, v);
			}else if (v[pos] == v[pos +1]) {
				return outsider(pos + 1, right, v);
			}else {
				return pos;
			}
		}
	}
}
