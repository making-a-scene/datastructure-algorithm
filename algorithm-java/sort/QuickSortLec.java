public class QuickSortLec {

    private static final int[] sampleArr = {7, 2, 5, 1, 3, 8, 7, 4, 9, 6};
    public static void main(String[] args) {
        quickSort(0, sampleArr.length - 1);
        for (int j : sampleArr) {
            System.out.print(j + " ");
        }
    }

    private static void quickSort(int start, int pivot) {
        if (start >= pivot) {
            return;
        }

        int pointer = start;
        for (int i = start; i < pivot; i++) {
            if (sampleArr[i] <= sampleArr[pivot]) {
                swap(i, pointer++);
            }
        }

        swap(pointer, pivot);

        quickSort(start, pointer - 1);
        quickSort(pointer, pivot);
    }

    private static void swap(int a, int b) {
        int temp = sampleArr[a];
        sampleArr[a] = sampleArr[b];
        sampleArr[b] = temp;
    }
}
