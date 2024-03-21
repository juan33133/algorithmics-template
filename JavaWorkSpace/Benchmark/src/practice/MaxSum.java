package practice;

public class MaxSum {
	/**
	 * Given a vector with n integer numbers (a1, a2, a3, …, an), we need to find
	 * the maximum summation (addition) of all the continuous subsequences of n
	 * elements. For example, given the vector (-2, 11, -4, 13, -5, -2) the solution
	 * would be 20, from a2 to a4.
	 * 
	 * @return
	 */
	private int [] vector;

	public int maxSum() {
		int left = 0;
		int right = vector.length;

		return maxSum(left, right);
	}

	public int maxSum(int left, int right) {
		int center = (right + left)/2 ;
		
		if(left == right) {
			return vector[left];
		}else {
			int maxLeft= maxSum(left, center);
			int maxRight= maxSum(center + 1, right);
			
			int sum1=0; 
			int maxSum1=0; 
			
			for(int i=center; i<=left; i--) {
				sum1 += vector[i];
				if(sum1 > maxSum1) {
					maxSum1 = sum1;
				}
			}
			
			int sum2=0; 
			int maxSum2=0 ; 
			
			for (int i=center+1; i<=right; i++) {
				sum2 += vector[i];
				if(maxSum2 < sum2) {
					maxSum2 = sum2;
				}
			}
			
			return biggest(maxLeft,maxRight, maxSum1+maxSum2);
		}
		
		
	}

	private static int biggest(int a, int b, int c) {
		if (a>=b && a>=c) return a;
		else if (b>=a && b>=c) return b;
		else return c;
		}


}
