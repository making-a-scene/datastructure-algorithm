package recursion;

import java.util.Scanner;

public class FibonacciNumbers {

	public static void main(String[] args) {
		int[] sequence = new int[46];
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("=== 피보나치 수열 ===\n출력할 항의 개수를 1 이상 45 이하로 입력해 주세요.");
		int num = scanner.nextInt();
		
		getResult(sequence, 1, num);
		
		scanner.close();
	}
	
	private static void getResult(int[] nums, int idx, int max) {
		if (idx > max) {
			return;
		}
		
		if (idx == 1 || idx == 2) {
			nums[idx] = 1;
		 } else {
			 nums[idx] = nums[idx - 1] + nums[idx - 2];
		 }
		 System.out.println("index : " + idx + ", num : " + nums[idx]);
		 getResult(nums, ++idx, max);
	}

}
