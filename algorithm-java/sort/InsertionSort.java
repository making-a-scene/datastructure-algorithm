package sort;

public class InsertionSort {
	
	private static int[] sampleArr = {9, 33, 15, 17, 4, 26, 7, 23, 30, 13};	

	public static void main(String[] args) {
		executeSort(0);	
	}
	
	private static void executeSort(int sortedEnd) {
		if (sortedEnd > sampleArr.length - 2) {
			for (int i = 0; i < sampleArr.length; i++) {
				System.out.print(sampleArr[i] + " ");
			}
			return;
		}
		
		findInsertingPlace(sortedEnd + 1);
		executeSort(++sortedEnd);
	}
	
	private static void findInsertingPlace(int currTarget) {
		for (int i = 0; i < currTarget; i++) {
			if (sampleArr[i] > sampleArr[currTarget]) {
				int temp = sampleArr[currTarget];
				pushArrayElements(currTarget - 1, i);
				sampleArr[i] = temp;
				break;
			}
		}
	}
	
	private static void pushArrayElements(int start, int end) {
		for (int i = start; i >= end; i--) {
			sampleArr[i + 1] = sampleArr[i];
		}
	}
	
}
