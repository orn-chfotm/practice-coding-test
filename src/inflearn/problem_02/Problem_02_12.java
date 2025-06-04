package inflearn.problem_02;

import java.util.Scanner;

public class Problem_02_12 {

    public int solution(int n, int m, int[][] arr) {
        int result = 0;

        for (int i = 1; i < n + 1; i++) {
            int[] count = new int[n];

            for (int j = 0; j < m; j++) {
                int rank = 0;
                for (int k = 0; k < n; k++) {
                    if (arr[j][k] == i) {
                        rank = k;
                        break;
                    }
                }
                for (int k = n - 1; k > rank; k--) {
                    count[arr[j][k] - 1] = count[arr[j][k] - 1] + 1;
                }
            }

            for (int j = 0; j < n; j++) {
                if (count[j] == m) result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Problem_02_12 problem = new Problem_02_12();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(problem.solution(n, m, arr));
    }
}
