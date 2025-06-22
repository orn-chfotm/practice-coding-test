package inflearn.problem_03;

import java.util.Scanner;
import java.util.logging.Level;

public class Problem_03_04 {

    public int solution(int n, int m, int[] arr) {
        int result = 0, left = 0, right = 0, sum = 0;

        while (true) {
            if (sum >= m) {
                if (sum == m) result++;
                sum -= arr[left++];
            } else {
                if (right == n) break;
                sum += arr[right++];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Problem_03_04 problem = new Problem_03_04();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(problem.solution(n, m, arr));
    }
}
