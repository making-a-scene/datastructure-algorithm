package recursion;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("=== 팩토리얼 ===\n값을 출력할 수를 입력해주세요.");
		int num = scanner.nextInt();		
		System.out.println(num + "! = " + getResult(num));
		scanner.close();
	}
	
	private static int getResult(int n) {
		if (n > 1) {
			return n * getResult(--n);
		}
		return 1;
	}
}
