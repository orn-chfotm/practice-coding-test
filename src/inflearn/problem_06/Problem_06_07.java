package inflearn.problem_06;

import java.util.Scanner;

public class Problem_06_07 {

    public int[][] solution(int n, int[][] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[j][0] > arr[j + 1][0] || (arr[j][0] == arr[j + 1][0] && arr[j][1] > arr[j + 1][1])) {
                    switching(j, j + 1, arr);
                }
            }
        }
        return arr;
    }

    public void switching(int beforeIdx, int afterIdx, int[][] arr) {
        int[] temp = arr[beforeIdx];
        arr[beforeIdx] = arr[afterIdx];
        arr[afterIdx] = temp;
    }

    public static void main(String[] args) {
        Problem_06_07 main = new Problem_06_07();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int[] result : main.solution(n, arr)) {
            System.out.println(result[0] + " " + result[1]);
        }
    }
}
