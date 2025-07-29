package inflearn.problem_09;

import java.util.Arrays;
import java.util.Scanner;

public class Problem_09_02 {

    public int solution(int[][] arr) {
        Arrays.sort(arr, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        int count = 0;
        int prevEndTime = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] >= prevEndTime) {
                prevEndTime = arr[i][1];
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{sc.nextInt(), sc.nextInt()};
        }

        Problem_09_02 main = new Problem_09_02();
        System.out.println(main.solution(arr));
    }
}
