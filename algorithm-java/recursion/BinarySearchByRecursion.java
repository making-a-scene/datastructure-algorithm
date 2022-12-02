package recursion;

public class BinarySearchByRecursion {

    private static final int[] data = {3, 5, 10, 14, 18, 22, 36, 44, 45, 60, 69};
    private static final int TARGET_1 = 18; // 4
    private static final int TARGET_2 = 3; // 0
    private static final int TARGET_3 = 69; // 10
    private static final int TARGET_4 = 20; // 해당 숫자가 배열 내에 존재하지 않습니다.

    public static void main(String args[]) {
        
        int output = binarySearch(0, data.length - 1, TARGET_1);
        if (output == -1) {
            System.out.println("해당 숫자(" + TARGET_1 + ")가 배열 내에 존재하지 않습니다.");
        } else {
            System.out.println("Target value : " + TARGET_1 + ", Locating index : " + output);
        }

        output = binarySearch(0, data.length - 1, TARGET_2);
        if (output == -1) {
            System.out.println("해당 숫자(" + TARGET_2 + ")가 배열 내에 존재하지 않습니다.");
        } else {
            System.out.println("Target value : " + TARGET_2 + ", Locating index : " + output);
        }

        output = binarySearch(0, data.length - 1, TARGET_3);
        if (output == -1) {
            System.out.println("해당 숫자(" + TARGET_3 + ")가 배열 내에 존재하지 않습니다.");
        } else {
            System.out.println("Target value : " + TARGET_3 + ", Locating index : " + output);
        }

        output = binarySearch(0, data.length - 1, TARGET_4);
        if (output == -1) {
            System.out.println("해당 숫자(" + TARGET_4 + ")가 배열 내에 존재하지 않습니다.");
        } else {
            System.out.println("Target value : " + TARGET_4 + ", Locating index : " + output);
        }
        

    }

    private static int binarySearch(int left, int right, int target) {
        int mid = (left + right) / 2;
        
        if (left > right) {
            return -1;
        }

        if (data[mid] == target) {
            return mid;
        } else if (data[mid] > target) {
            return binarySearch(left, mid - 1, target);
        } else {
            return binarySearch(mid + 1, right, target);
        }


    }
}