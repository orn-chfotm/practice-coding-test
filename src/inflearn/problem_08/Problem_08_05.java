package inflearn.problem_08;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Problem_08_05 {

    int n, m;
    Integer[] arr;
    int answer = Integer.MAX_VALUE;

    public Problem_08_05(int n, int m, Integer[] arr) {
        this.n = n;
        this.m = m;
        this.arr = arr;
    }

    public int solution() {
        dfs(0, 0);
        return answer;
    }

    public void dfs(int count, int sum) {
        if (sum > m || count >= answer) return;

        if (sum == m) {
            answer = Math.min(answer, count);
            return;
        }

        for (int i = 0; i < n; i++) {
            dfs(count + 1, sum + arr[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();

        Arrays.sort(arr, Collections.reverseOrder());

        Problem_08_05 main = new Problem_08_05(n, m, arr);
        System.out.println(main.solution());
    }
}
