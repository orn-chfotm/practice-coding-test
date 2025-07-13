package inflearn.problem_08;

import java.util.Scanner;

public class Problem_08_03 {
    int n, m;
    int max = Integer.MIN_VALUE;

    public int solution(int n, int m, int[][] arr) {
        this.n = n;
        this.m = m;

        dfs(0, 0,0, arr);

        return max;
    }

    public void dfs(int index, int time, int sum, int[][] arr) {
        if (time > m) return;

        if (index == n) {
            if (time <= m) {
                max = Math.max(max, sum);
            }
            return;
        }

        int[] problem = arr[index];
        dfs(index + 1, time + problem[1], sum + problem[0], arr);
        dfs(index + 1, time, sum, arr);
    }

    public static void main(String[] args) {
        Problem_08_03 main = new Problem_08_03();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        System.out.println(main.solution(n, m, arr));
    }
}
