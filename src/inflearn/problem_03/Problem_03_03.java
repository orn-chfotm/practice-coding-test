package inflearn.problem_03;

import java.util.Scanner;

public class Problem_03_03 {

    public int solution(int n, int k, int[] arr) {
        int result = Integer.MIN_VALUE;

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        result = sum;

        for (int i = k; i < n; i++) {
            sum += (arr[i] - arr[i - k]);
            result = Math.max(result, sum);
        }

        return result;
    }

    public static void main(String[] args) {
        Problem_03_03 problem = new Problem_03_03();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(problem.solution(n, k, arr));
    }
}
