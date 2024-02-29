package s2;

public class QuicksortInsertion {

	public static int k = 10;

	public static void quicksortInsertion(int[] a) {
		quicksortInsertion(a, 0, a.length-1);
	}
	
	
	public static void quicksortInsertion(int[] a, int left, int right) {
		int i = left;
		int j = right - 1;
		int pivot;
		
		int distance = right - left;

		if (distance > k) {
			if (left < right) { // if there is one element it is not necessary
				int center = median_of_three(a, left, right);
				// if there are less than or equal to 3 elements, there are just ordered
				if ((right - left) >= 3) {
					pivot = a[center]; // choose the pivot
					Vector.interchange(a, center, right); // hide the pivot

					do {
						while (a[i] <= pivot && i < right)
							i++; // first element > pivot
						while (a[j] >= pivot && j > left)
							j--; // first element < pivot
						if (i < j)
							Vector.interchange(a, i, j);
					} while (i < j); // end while

					// we set the position of the pivot
					Vector.interchange(a, i, right);

					quicksortInsertion(a, left, i - 1);
					quicksortInsertion(a, i + 1, right);
				} // if
			} // if
		}else {
			insertion(a, left , right);
		}
		
	}
	public static int median_of_three(int[] a, int left, int right) { 
		int center = (left + right) / 2;
		if (a[left] > a[center])
			Vector.interchange(a, left, center);
		if (a[left] > a[right])
			Vector.interchange(a, left, right);
		if (a[center] > a[right])
			Vector.interchange(a, center, right);
		return center;
	}

	/* Sorting by the Insertion method */
	public static void insertion(int[] a, int left , int right) {
		int j;
		int pivot;
		

		for (int i = left; i < right; i++) {
			pivot = a[i];
			j = i - 1;

			while (j >= left && pivot < a[j]) {
				a[j + 1] = a[j];
				j--;
			}

			a[j + 1] = pivot;
		}
	}

}
