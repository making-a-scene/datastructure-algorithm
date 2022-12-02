package recursion;

public class SumRecursive {
    public static void main(String[] args) {
        int sum = getSumByRecursion(10);
        System.out.println(sum); // 55

        sum = getSumByRecursion(100);
        System.out.println(sum); // 5050

        sum = getSumByTailRecursion(10, 0);
        System.out.println(sum); // 55

        sum = getSumByTailRecursion(100, 0);
        System.out.println(sum); // 5050

        // 반복문 사용해서 연산할 때와는 달리 재귀 함수 사용시 스택오버플로우 예외가 발생함.
        sum = getSumByRecursion(100000); 
        // java는 꼬리 호출 최적화를 지원하지 않기 때문에 꼬리 재귀를 사용해도 여전히 스택오버플로우 발생....
        sum = getSumByTailRecursion(10000, 0);
        
    }

    private static int getSumByRecursion(int n) {
        if (n <= 1) {
            return n;
        }
        return n + getSumByRecursion(n - 1);
    }

    private static int getSumByTailRecursion(int n, int sum) {
        if (n == 0) {
            return sum;
        }
        return getSumByTailRecursion(n - 1, sum + n);
    }

}