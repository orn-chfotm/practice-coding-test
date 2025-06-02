package inflearn.problem_02;

import java.util.Scanner;

public class Problem_02_05 {
    public static int solution(int n) {
        int count = 0;
        int[] check = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            if (check[i] == 0) {
                count++;
                for (int j = i; j <= n; j=j+i) {
                    check[j] = 1;
                }
            }
        }

        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(solution(n));
    }
}
