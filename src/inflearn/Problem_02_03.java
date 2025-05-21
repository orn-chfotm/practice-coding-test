package inflearn;

import java.util.Scanner;

public class Problem_02_03 {
    public static void solution(int n, int[][] info) {
        for (int i = 0; i < n; i++) {
            int a = info[0][i];
            int b = info[1][i];
            String result = "";

            if (a == b) {
                result = "D";
            } else if (
                    (a == 1 && b == 3)
                            || (a == 2 && b == 1)
                            || (a == 3 && b == 2)
            ) {
                result = "A";
            } else {
                result = "B";
            }

            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] info = new int[2][n];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                info[i][j] = sc.nextInt();
            }
        }

        solution(n, info);
    }
}
