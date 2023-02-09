public class MergeSort {

	public static int[] src;
	public static int[] tmp;

	public static void main(String[] args) {
		src = new int[] {1, 9, 8, 5, 4, 2, 3, 7, 6};
		tmp = new int[src.length];

		printArray(); // before sorting
		executeSorting(0, src.length - 1);
		printArray();// after sorting
	}

	public static void executeSorting(int start, int end) {
		if (start < end) {
			// seperation
			int mid = (start + end) / 2;
			executeSorting(start, mid);
			executeSorting(mid + 1, end);

			// execute merging after seperation.
			merge(start, mid, end);
		}
	}

	private static void merge(int start, int mid, int end) {
		int p = start;
		int q = mid + 1;
		int idx = p;

		while (p <= mid || q <= end) {
			if (q > end || (p <= mid && src[p] < src[q])) {
				tmp[idx++] = src[p++];
			} else {
				tmp[idx++] = src[q++];
			}
		}
		copyElements(start, end);
	}

	private static void copyElements(int start, int end) {
		for (int i = start; i <= end; i++) {
			src[i] = tmp[i];
		}
	}

	private static void printArray() {
		for (int i = 0; i < src.length; i++) {
			System.out.print(src[i] + " ");
		}
		System.out.println();
	}
}
