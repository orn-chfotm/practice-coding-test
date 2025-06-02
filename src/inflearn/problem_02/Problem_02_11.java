package inflearn.problem_02;

import java.util.Scanner;

public class Problem_02_11 {

    public static void main(String[] args) {
        Problem_02_11 problem = new Problem_02_11();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(problem.solution(n, arr));
    }

    public int solution(int n, int[][] arr) {
        int result = 0;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                for (int k = 0; k < 5; k++) {
                    if (arr[i][k] == arr[j][k]) {
                        count++;
                        break;
                    }
                }
            }
            if (count > max) {
                max = count;
                result = i;
            }
        }

        return result + 1;
    }
}
