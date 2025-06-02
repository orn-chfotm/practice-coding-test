package inflearn.problem_02;

import java.util.Queue;
import java.util.Scanner;

public class Problem_02_10 {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.print(solution(n, arr));
    }

    private static int solution(int n, int[][] arr) {
        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                        if (arr[nx][ny] >= arr[i][j]) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    result++;
                }
            }
        }

        return result;
    }
}
