package inflearn.problem_08;

import java.util.Scanner;

public class Problem_08_02 {

    int n, c;
    int max = Integer.MIN_VALUE;

    public int solution(int c, int n, int[] arr) {
        this.c = c;
        this.n = n;

        dfs(0, 0, arr);

        return max;
    }

    public void dfs(int index, int sum, int[] arr) {
        if (sum > c) return ;

        if (index == n) {
            if (sum <= c) {
                max = Math.max(max, sum);
            }
            return;
        }

        dfs(index + 1, sum, arr);
        dfs(index + 1, sum + arr[index], arr);
    }

    public static void main(String[] args) {
        Problem_08_02 main = new Problem_08_02();
        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(main.solution(c, n, arr));
    }
}
