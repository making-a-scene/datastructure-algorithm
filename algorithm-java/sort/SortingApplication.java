import java.util.Arrays;
import java.util.Random;

public class SortingApplication {

    public static void main(String args[]) {
        Random random = new Random(500);

        int[] nums = new int[15];
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = random.nextInt(1000);
        }
        printNums(nums);
        Arrays.sort(nums);
        System.out.println("Minimum Difference : " + findMinDiff(nums));


    }

    private static int findMinDiff(int[] nums) {
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 1; ++i) {
            int diff = Math.abs(nums[i] - nums[i + 1]);

            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        return minDiff;
    }

    private static void printNums(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}