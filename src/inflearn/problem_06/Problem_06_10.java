package inflearn.problem_06;

import java.util.Arrays;
import java.util.Scanner;

public class Problem_06_10 {

    public int count(int[] arr, int distance) {
        int count = 1;
        int last = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - last >= distance) {
                count++;
                last = arr[i];
            }
        }

        return count;
    }

    public int solution(int n, int c, int[] arr) {
        Arrays.sort(arr);

        int answer = 0;
        int lt = 1;
        int rt = arr[n - 1] - arr[0];

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (count(arr, mid) >= c) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Problem_06_10 main = new Problem_06_10();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(main.solution(n, c, arr));
    }
}
