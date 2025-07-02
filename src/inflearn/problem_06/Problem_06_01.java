package inflearn.problem_06;

import java.util.Scanner;

public class Problem_06_01 {

    public int[] solution(int n, int[] arr) {
        for (int i = 0; i < n; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j] && arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Problem_06_01 problem = new Problem_06_01();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int num : problem.solution(n, arr)) {
            System.out.print(num + " ");
        }
    }
}
