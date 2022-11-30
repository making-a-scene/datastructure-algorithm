package recursion;

import java.util.Scanner;

public class GreatestCommonFactor {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=== 최대공약수 ===\n최대공약수를 구할 두 수를 입력해주세요.");
		int a = scanner.nextInt();	
		int b = scanner.nextInt();
		System.out.println(getCommonFactor(a, b));
		scanner.close();

	}
	
	private static int getCommonFactor(int a, int b) {
		if (b == 0) {
			return a;
		}
		return getCommonFactor(b, a % b);
	}

}
