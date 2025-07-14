package inflearn.problem_08;

import java.util.Scanner;

public class Problem_08_05_02 {

    int n, m;
    int answer = Integer.MAX_VALUE;

    public int solution(int n, int m, int[] arr) {
        this.n = n;
        this.m = m;

        dfs(n - 1, 0, m, arr);

        return answer;
    }

    public void dfs(int index, int count, int change, int[] arr) {
        if (change < 0) return;
        if (count >= answer) return;

        if (index < 0) {
            if (change == 0) {
                answer = Math.min(answer, count);
            }
            return;
        }

        dfs(index, count + 1, change - arr[index], arr);
        dfs(index - 1, count, change, arr);
    }

    public static void main(String[] args) {
        Problem_08_05_02 main = new Problem_08_05_02();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();

        System.out.println(main.solution(n, m, arr));
    }
}
