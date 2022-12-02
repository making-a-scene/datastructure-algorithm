package search;

public class RotatedArray {
    public static void main(String args[]) {
        int[] arr = {20, 25, 26, 29, 33, 1, 3, 5, 6, 10, 11, 19};

        int index = indexOfRotatedArray(arr, 0, arr.length - 1, 26);
        System.out.println(index); // 2
    }

    private static int indexOfRotatedArray(int[] arr, int start, int end, int num) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (arr[mid] == num) {
            return mid;
        }

        /* 정렬이 안 된 곳은 한 군데밖에 없으니까 start~mid, mid~end 두 부분 모두에서 정렬 안 된 곳이 존재할 수는 없음.. */

        /* 1. start에서 mid까지의 숫자들이 정렬되어 있는 경우 */ 
        if (arr[start] <= arr[mid]) {
            // num이 start에서 mid 사이에 존재하는 경우 -> 내부의 범위를 좁혀 탐색
            if (num >= arr[start] && num <= arr[mid]) {
                return indexOfRotatedArray(arr, start, mid - 1, num);
            }
            // num이 start에서 mid 사이에 존재하지 않는 경우 -> 외부를 탐색
            return indexOfRotatedArray(arr, mid + 1, end, num);
        }

        /* 2. mid에서 end까지의 숫자들이 정렬되어 있는 경우 */
        // num이 mid에서 end 사이에 존재하는 경우 -> 내부의 범위를 좁힘
        if (num >= arr[mid] && num <= arr[end]) {
            return indexOfRotatedArray(arr, mid + 1, end, num);
        }
        // num이 mid에서 end 사이에 존재하지 않는 경우 -> 외부를 탐색
        return indexOfRotatedArray(arr, start, mid - 1, num);


    }
}
