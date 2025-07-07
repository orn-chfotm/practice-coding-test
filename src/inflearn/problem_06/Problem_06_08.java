package inflearn.problem_06;

import java.util.Arrays;
import java.util.Scanner;

public class Problem_06_08 {

    public int solution(int n, int m, int[] arr) {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        int left = 0, right = arr.length - 1, mid = 0;
        while (arr[mid] != m) {
            mid = (left + right) / 2;

            if (arr[mid] < m) {
                left = mid;
            } else if (arr[mid] > m){
                right = mid;
            }
            mid = (left + right) / 2;
        }

        return mid + 1;
    }

    public static void main(String[] args) {
        Problem_06_08 main = new Problem_06_08();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(main.solution(n, m, arr));
    }
}
