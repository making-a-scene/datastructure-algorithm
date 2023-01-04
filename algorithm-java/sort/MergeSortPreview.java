public class MergeSortPreview {
    public static void main(String args[]) {
        int[] arrA = {1, 2, 5, 7};
        int[] arrB = {3, 4, 6, 7, 8};
        int[] result = mergeArrays(arrA, arrB);
        for (int v : result) {
            System.out.print(v + " ");
        }
    }

    private static int[] mergeArrays(int[] a, int[] b) {
        int[] merged = new int[a.length + b.length];
        
        int idxA = 0;
        int idxB = 0;
        for (int i = 0; i < merged.length; ++i) {
            if (idxB == b.length) {
                merged[i] = a[idxA++];
                continue;
            } else if (idxA == a.length) {
                merged[i] = b[idxB++];
                continue;
            }

            if (a[idxA] < b[idxB]) {
                merged[i] = a[idxA++];
            } else if (a[idxA] > b[idxB]) {
                merged[i] = b[idxB++];
            } else {
                merged[i++] = a[idxA++];
                merged[i] = b[idxB++];
            }
        }

        return merged;
    }
    
}
