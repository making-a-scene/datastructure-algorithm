package recursion;

import java.util.Scanner;

public class TowerOfHanoi {
	
	private static int count = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("=== 하노이탑 ===\n원판의 수를 입력해주세요.");
		int num = scanner.nextInt();	
		move(num, 1, 2);
		System.out.println(count);
		scanner.close();

	}
	private static void move(int n, int a, int b) { // a: 초기 기둥 번호, b: 목표 기둥 번호
		count++;
		// n이 1인 경우 원판 하나를 a에서 b로 옮기고 실행이 종료됨.
		
		int c;
		if (n != 1) {
			c = 6 - a - b; // 각 기둥을 1번, 2번, 3번이라고 하면 c 기둥의 번호는 a, b번 기둥의 번호를 6(1+2+3)에서 뺀 값이 됨.
			
			// n번째 원판을 꺼내기 위해 n - 1개의 원판을 a에서 c로 옮긴 후, c에서 다시 b로 옮김.
			move(n - 1, a, c);
			move(n - 1, c, b);
		}

	}

}
