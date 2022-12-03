package sort;

public class MergeSort {
	
	public static void main(String[] args) {
		private int[] sampleArr = {9, 33, 17, 15, 4, 26, 12, 6, 30, 13};

	}

	private static int[] pairwiseMergeSort(int[] arr, int nums) {
		if (nums == arr.length) {
			return arr;
		}



	}

	// 두 개의 분할된 배열을 하나로 merge, sort
	private static int[] merging(int[] leftArr, int[] rightArr) {
		int[] merged = new int[leftArr.length + rightArr.length];
		int leftIdx = 0;
		int rightIdx = 0;
		int i = 0;
		for (; leftIdx < leftArr.length && rightIdx < rightArr.length; i++) {
			if (leftArr[leftIdx] > rightArr[rightIdx]) {
				merged[i] = rightArr[rightIdx++];
			} else {
				merged[i] = leftArr[leftIdx++];
			}
		}
		if (leftIdx != leftArr.length) {
			for (;i < merged.length; i++, leftIdx++) {
				merged[i] = leftArr[leftIdx];
			}
		} else if (rightIdx != rightArr.length) {
			for (; i < merged.length; i++, rightIdx++) {
				merged[i] = rightArr[rightIdx];
			}
		}

		return merged;
	}



}
