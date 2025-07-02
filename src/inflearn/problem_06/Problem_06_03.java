package inflearn.problem_06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem_06_03 {

    public int[] solution(int n, int[] arr) {
        int value = 0;
        for (int i = 1; i < n; i++) {
            value = arr[i];
            for (int j = i - 1; j >= 0 && arr[j] > value; j--) {
                arr[j + 1] = arr[j];
                arr[j] = value;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Problem_06_03 main = new Problem_06_03();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int num : main.solution(n, arr)) {
            System.out.print(num + " ");
        }
    }
}
