package inflearn.problem_10;

import java.util.Scanner;

public class Problem_10_02 {


    public int solution(int n) {
        int[] dx = new int[n + 1];
        dx[1] = 1;
        dx[2] = 2;

        for (int i = 3; i <= n; i++) {
            dx[i] = dx[i - 2] + dx[i - 1];
        }

        return dx[n] + dx[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Problem_10_02 main = new Problem_10_02();
        System.out.println(main.solution(n));
    }
}
