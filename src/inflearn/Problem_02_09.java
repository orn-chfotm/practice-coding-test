package inflearn;

import java.util.Scanner;

public class Problem_02_09 {

    public static int solution(int n, int[][] arr) {
        int result = 0;

        for (int i = 0; i < n; i++) {
            int sumX = 0;
            int sumY = 0;
            for (int j = 0; j < n; j++) {
                sumX += arr[i][j];
                sumY += arr[j][i];
            }
            result = Math.max(Math.max(sumX, sumY), result);
        }

        int diagonal1 = 0;
        int diagonal2 = 0;
        for (int i = 0; i < n; i++) {
            diagonal1 += arr[i][i];
            diagonal2 += arr[n - (i + 1)][n - (i + 1)];
        }

        result = Math.max(Math.max(diagonal1, diagonal2), result);

        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, arr));
    }
}
