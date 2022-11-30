package sort;

public class SelectionSort {
	
	private static int[] sampleArr = {9, 33, 15, 17, 4, 26, 7, 23, 30, 13};

	public static void main(String[] args) {
		executeSorting(0);

	}
	
	private static void executeSorting(int idx) {
		if (idx > sampleArr.length - 1) {
			for (int num : sampleArr) {
				System.out.print(num + " ");
			}
			return;
		}	
		
		swap(idx, findMin(idx));
		executeSorting(++idx);
	}
	
	private static int findMin(int start) {
		int minIdx = -1;
		int minVal = 100;
		
		for (int tempIdx = start; tempIdx < sampleArr.length; tempIdx++) {
			if (sampleArr[tempIdx] < minVal) {
				minVal = sampleArr[tempIdx];
				minIdx = tempIdx;
			}
		}
		return minIdx;
	}
	
	private static void swap(int start, int target) {
		int temp = sampleArr[start];
		sampleArr[start] = sampleArr[target];
		sampleArr[target] = temp;
	}

}
