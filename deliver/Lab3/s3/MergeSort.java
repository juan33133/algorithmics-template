package algstudent.s3;

public class MergeSort {
	
    public static void mergeSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        
        int mid = array.length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[array.length - mid];
        
        System.arraycopy(array, 0, leftArray, 0, mid);
        System.arraycopy(array, mid, rightArray, 0, array.length - mid);
        
        mergeSort(leftArray);
        mergeSort(rightArray);
        
        merge(array, leftArray, rightArray);
    }
    
    private static void merge(int[] array, int[] leftArray, int[] rightArray) {
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;
        
        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                array[resultIndex++] = leftArray[leftIndex++];
            } else {
                array[resultIndex++] = rightArray[rightIndex++];
            }
        }
        
        while (leftIndex < leftArray.length) {
            array[resultIndex++] = leftArray[leftIndex++];
        }
        
        while (rightIndex < rightArray.length) {
            array[resultIndex++] = rightArray[rightIndex++];
        }
    }
}
