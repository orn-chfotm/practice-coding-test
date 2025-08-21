package inflearn.problem_10;

import java.util.Arrays;
import java.util.Scanner;

public class Problem_10_03 {

     public static int solution(int n, int[] arr) {
         int[] counting = new int[n + 1];
         int max = Integer.MIN_VALUE;

         for (int i = 1; i <= n; i++) {
             int current = arr[i];
             int count = 0;
             for (int j = i - 1; j >= 0; j--) {
                 if (arr[j] < current) {
                     count = Math.max(count, counting[j]);
                 }
             }
             counting[i] = count + 1;
             max = Math.max(counting[i], max);
         }

         return max;
     }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(n, arr));
    }
}
