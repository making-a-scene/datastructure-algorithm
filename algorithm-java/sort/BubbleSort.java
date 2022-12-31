package sort;

public class BubbleSort {
	
	private static int[] sampleArr = {9, 33, 15, 17, 4, 26, 7, 23, 30, 13};

	public static void main(String[] args) {
		executeSorting(sampleArr.length - 1);
	}
	
	private static void executeSorting(int end) {
		if (end < 1) {
			for (int i = 0; i < sampleArr.length; i++) {
				System.out.print(sampleArr[i] + " ");
			}
			return;
		}
		compare(end);
		executeSorting(--end);
	}
	
	private static void compare(int end) {
		for (int i = 0; i < end; i++) {
			if (sampleArr[i] > sampleArr[i + 1]) {
				swap(i);
			}
		}
	}
	
	private static void swap(int target) {
		int temp = sampleArr[target];
		sampleArr[target] = sampleArr[target + 1];
		sampleArr[target + 1] = temp;
	}

	public static void bubbleSortLec(int[] nums) {
		for (int i = 0; i < nums.length; ++i) {
			for (int j = 0; j < nums.length - i - 1; ++j) {
				// 내림차순 구현시 부등호 방향을 바꾸면 됨.
				if (nums[j] > nums[j + 1]) {
					swap(j);
				}
			}
		}

	}
}
