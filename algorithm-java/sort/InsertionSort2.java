public class InsertionSort2 {
    private static final int[] sampleArr = {9, 33, 15, 17, 4, 26, 7, 23, 30, 13};
    public static void main(String args[]) {
        for (int i = 0; i < sampleArr.length; i++) {
            int j = i;
            while (j > 0 && sampleArr[j] < sampleArr[j - 1]) {
                int temp = sampleArr[j];
                sampleArr[j] = sampleArr[j - 1];
                sampleArr[j - 1] = temp;
                j--;
            }
        }
        
        for (int i = 0; i < sampleArr.length; i++) {
            System.out.print(sampleArr[i] + " ");
        }
    }
}