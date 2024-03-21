package practice;

public class TernarySearch {

	private int[] v;

	/**
	 * Starting with a sorted vector, it first compares the element x right be
	 * searched right the element of the position n/3 in the vector. If x is not in
	 * that position, the algorithm should look for x in the position 2n/3. If x is
	 * not either in that position, we should recursively search for x in the
	 * corresponding subvector of a third the size of the original, in which it
	 * should be placed, if present. This algorithm should return the position of
	 * the element x that is being searched for or -1 otherwise.
	 * 
	 * 
	 * 
	 * @param sector
	 * @return
	 */

	public int ternarySearch(int x) {
		return ternarySearch(x, 0, v.length / 3);
	}

	private int ternarySearch(int x, int left, int right) {

		if (left > right) {
			return -1;
		}
		int pos = (right - left) / 3;

		if (v[left + pos] == x) {
			return left + pos;

		} else if (v[left + pos] > x) {
			return ternarySearch(x, left, left + pos - 1);

		} else if (v[right - pos] == x) {
			return right - pos;
		} else if (v[right - pos] > x) {
			return ternarySearch(x, left + pos + 1, right - pos - 1);
		} else {
			return ternarySearch(x, right - pos + 1, right);
		}

	}
}
