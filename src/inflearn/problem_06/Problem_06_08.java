package inflearn.problem_06;

import java.util.Arrays;
import java.util.Scanner;

public class Problem_06_08 {

    public int solution(int n, int m, int[] arr) {
        int answer = -1;

        Arrays.sort(arr);

        int left = 0, right = n - 1, mid;
        while (left <= right) {
            mid = (left + right) / 2;

            if (arr[mid] == m) {
                answer = mid + 1;
                break;
            }

            if (arr[mid] < m) {
                left = mid + 1;
            } else if (arr[mid] > m){
                right = mid - 1;
            }
        }

        return answer;
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
