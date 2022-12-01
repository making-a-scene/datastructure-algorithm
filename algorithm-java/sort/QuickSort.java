package sort;

public class QuickSort {

	private static int[] sampleArr = {9, 33, 15, 17, 4, 26, 7, 23, 30, 13};
	
	public static void main(String[] args) {
		executeSorting(0, 1, sampleArr.length - 1);
		
		for (int i = 0; i < sampleArr.length; i++) {
			System.out.print(sampleArr[i] + " ");
		}
	}
	

	private static void executeSorting(int pivot, int front, int rear) {
		if (front >= rear) {
			return;
		}
		
		findElementsNeedToSwap(pivot, front, rear);
		int center = movePivotToCenter(pivot, front, rear);

		executeSorting(front - 1, front, center - 1);
		executeSorting(center, center + 1, rear);
	}
	
	private static void swap(int a, int b) {
		int temp = sampleArr[a];
		sampleArr[a] = sampleArr[b];
		sampleArr[b] = temp;
	}
		
	private static void findElementsNeedToSwap(int pivot, int front, int rear) {
		int flag = 1;
		int i = front;
		int j = rear;
		
		while (flag == 1) {
			flag = 0;
			while (i < rear && sampleArr[pivot] > sampleArr[i]) {
				i++;
			}
			while (j > front && sampleArr[pivot] < sampleArr[j]) {
				j--;
			}
			if (i < j) {
				swap(i, j);
				flag = 1;
			}
		}
	}
	
	private static int movePivotToCenter(int pivot, int front, int rear) {
		int k = front;
		for (; k <= rear + 1; k++) {
			if (k == rear + 1 || sampleArr[pivot] < sampleArr[k]) {
				swap(pivot, k - 1);
				break;
			}
		}
		return k;
	}
	

}
