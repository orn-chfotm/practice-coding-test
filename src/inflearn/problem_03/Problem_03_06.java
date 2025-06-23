package inflearn.problem_03;

import java.util.Scanner;

public class Problem_03_06 {

    public int solution(int n, int k, int[] arr) {
        int left = 0, count = 0, result = 0;

        for (int right = 0; right < n; right++) {
            if (arr[right] == 0) {
                count++;
                while (count > k) {
                    if (arr[left] == 0) {
                        count--;
                    }
                    left++;
                }
            }
            result = Math.max(result, right - left + 1);
        }

        return result;
    }

    public int solution2(int n, int k, int[] arr) {
        int result = 0, count = 0, lt = 0;

        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) count++;
            while (count > k) {
                if (arr[lt] == 0) count--;
                lt++;
            }
            result = Math.max(result, rt - lt + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        Problem_03_06 problem = new Problem_03_06();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(problem.solution(n, k, arr));
    }
}
