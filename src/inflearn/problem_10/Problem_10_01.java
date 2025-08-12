package inflearn.problem_10;

import java.util.Scanner;

public class Problem_10_01 {

    public int solution(int n) {
        int[] dy = new int[n + 1];
        dy[1] = 1;
        dy[2] = 2;

        for (int i = 3; i <= n; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }

        return dy[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Problem_10_01 main = new Problem_10_01();
        System.out.println(main.solution(n));
    }
}
